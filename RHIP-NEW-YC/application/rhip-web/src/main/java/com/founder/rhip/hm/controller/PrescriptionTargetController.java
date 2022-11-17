package com.founder.rhip.hm.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;
import com.founder.rhip.ehr.service.IOutpatientService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ihm.controller.IHMBaseController;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.im.service.medical.IPrescriptionService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.*;

/**
 * 处方监管
 * add by yejianfei
 */
@Controller
@RequestMapping("/ihm/prescription")
public class PrescriptionTargetController extends IHMBaseController {
 
    @Resource(name = "prescriptionService")
    private IPrescriptionService prescriptionService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    @Resource(name = "personalRecordService")
    private IPersonalRecordService personalRecordService;

    @Resource(name = "outpatientService")
    private IOutpatientService outpatientService;

	@RequestMapping("/index")
	public String index(Model model) {
		return "ihm.prescription.index";
	}
	
    @RequestMapping("/prescriptionCost/index")
    public String prescriptionCostIndex(HttpServletRequest request,Model model) {
        initOrg(request,model);
        return "ihm.prescription.prescriptionCost";
    }	
    
    @RequestMapping("/prescriptionCost/chart")
    @ResponseBody
    public Map<String, Object> prescriptionCostChart(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria ca = form.getPrescriptionCriteria();
        String genreCode = form.getGenreCode();
        List<Map<String,Object>> prescriptionMap = prescriptionService.getPrescriptionCostMapList(ca);
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> xAxisList = new ArrayList<>();
        List<String> orgCodes = getPrescriptionBarData(genreCode,series,prescriptionMap,xAxisList);
        resultMap.put(LEGEND_JSON,Arrays.asList(new String[]{"平均处方费用","处方数量"}));
        resultMap.put(XAXIS_JSON,xAxisList);
        resultMap.put(YAXIS_JSON,getYAxisJson());
        resultMap.put(SERIES_JSON,series);
        resultMap.put("orgCodes",orgCodes);
        resultMap.put("genreCode",form.getGenreCode());
        resultMap.put("beginDt",form.getBeginDate());
        resultMap.put("endDt",form.getEndDate());
        resultMap.put(TOOLTIP_JSON, Arrays.asList(new String[]{"元","张"}));
        resultMap.put(EXTRA_TOOLTIP_JSON,Arrays.asList(new String[]{"(下钻)","(下钻)"}));
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 处方监控-向下钻取查询页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/detail/search")
    public String detailSearch(HttpServletRequest request,Model model) {
        initOrg(request,model);
        String genreCode = request.getParameter("genreCode");
        String orgCode = request.getParameter("orgCode");
        String beginDt = request.getParameter("beginDt");
        String endDt = request.getParameter("endDt");
        //按镇查询
        if("0".equals(genreCode)){
            model.addAttribute("gbCode",orgCode);
        }else{
            model.addAttribute("organCode",orgCode);
        }
        model.addAttribute("beginDt",beginDt);
        model.addAttribute("endDt",endDt);
        return "ihm.prescription.detail.search";
    }

    @RequestMapping("/detail/list")
    public String detailList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        String pageIndex = request.getParameter("pageIndex");
        int currentPage = Integer.valueOf(pageIndex);
        Page page = super.getPage(request, currentPage);
        Criteria ca = buildCriteria(form);
        PageList<OutpatientPrescription> prescriptionList = outpatientService.getOutpatientPrescriptionList(page, ca, new Order("PRESCRIBE_DATE",false));
        for(OutpatientPrescription info : prescriptionList.getList()){
            Criteria criteria = new Criteria();
            criteria.add("id",info.getPersonId());
            PersonInfo personInfo = personalRecordService.getPersonRecord(criteria);
            if(ObjectUtil.isNotEmpty(personInfo)){
                info.setIdcard(personInfo.getIdcard());
            }
        }
        model.addAttribute("prescriptionList", prescriptionList.getList());
        model.addAttribute("page", prescriptionList.getPage());
        return "ihm.prescription.detail.list";
    }


    /**
     * 组装查询条件
     * @param form
     * @return
     */
    private Criteria buildCriteria(TargetOrgQueryForm form){
        Criteria criteria = new Criteria();
        Criteria criteriaTemp = null;
        if(StringUtil.isNotEmpty(form.getGbCode())){ //如果选择的是镇,则查出该镇下所有服务中心和服务站的数据
            criteriaTemp = new Criteria().add("gbCode", form.getGbCode());
        }
        if(StringUtil.isNotEmpty(form.getOrganCode())){
            criteria.add("HOSPITAL_CODE", form.getOrganCode());
        }

        if(null != criteriaTemp){
            List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);
            if(!CollectionUtils.isEmpty(orgs)){
                criteria.add("HOSPITAL_CODE", OP.IN, Convert2Array(orgs,"organCode"));
            }
        }
        /* 时间范围 */
        Date beginDate = DateUtil.parseDateString(form.getBeginDate());
        Date endDate = DateUtil.parseDateString(form.getEndDate());
        DateUtil.getCriteriaByDateRange(criteria, "PRESCRIBE_DATE", beginDate,endDate);

        //姓名
        if(StringUtil.isNotEmpty(form.getName())){
            criteria.add("name", OP.LIKE, form.getName());
        }
        //门诊号
        if(StringUtil.isNotEmpty(form.getOutpatientNo())){
            criteria.add("outpatientNo", form.getOutpatientNo());
        }
        //身份证
        if(StringUtil.isNotEmpty(form.getIdcard())){
            Criteria criteria2 = new Criteria();
            criteria2.add("idcard", form.getIdcard());
            List<PersonInfo> personInfoList = personalRecordService.getPersonRecordList(criteria2);
            if(CollectionUtils.isEmpty(personInfoList)){
                criteria.add("personId", OP.IN, new String[]{"0"});
            }else{
                criteria.add("personId", OP.IN, Convert2Array(personInfoList, "id"));
            }
        }
        return criteria;
    }

    private <T> Object[] Convert2Array(List<T> list, String fieldName){
        Object[] ta = new Object[list.size()];
        if(CollectionUtils.isEmpty(list)) return ta;
        Method method;
        try {
            method = list.get(0).getClass().getDeclaredMethod("get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
            for(int i = 0; i < list.size(); i++){
                ta[i] = method.invoke(list.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ta;
    }

    private List<Map<String,Object>> getYAxisJson(){
        List<Map<String,Object>> result = new ArrayList<>();
        result.add(addYAxis("平均处方费用","元"));
        result.add(addYAxis("处方数量","张"));
        return result;
    }

    private List<String> getPrescriptionBarData(Object genreCode, List<Map<String,Object>>  series,List<Map<String,Object>> prescriptionMapList,List<String> xAxisList){
        List<String> result =  new ArrayList<>();
        List<Object> prescriptionData1 = new ArrayList<>();
        List<Object> prescriptionData2 = new ArrayList<>();
        for(Map<String,Object> map:prescriptionMapList){
            prescriptionData1.add(map.get("avg_cost").toString());
            prescriptionData2.add(map.get("p_count").toString());
            String orgName = getOrganName(genreCode.toString(),map);
            xAxisList.add(orgName);
            result.add(getOrganCode(genreCode.toString(),map));
        }
        Map<String,Object> seriesMap1 = addSeries("平均处方费用","bar",prescriptionData1,0);
        Map<String,Object> seriesMap2 = addSeries("处方数量","line",prescriptionData2,1);
        series.add(seriesMap1);
        series.add(seriesMap2);
         return result;
    }

    private String getOrganName(String genreCode,Map<String,Object> prescriptionMap){
        String result = "";
        if("0".equals(genreCode)){
            String gbCode = prescriptionMap.get("GB_CODE").toString();
            DicItem dicItem = dictionaryApp.queryDicItem("FS990001",gbCode);
            if(ObjectUtil.isNotEmpty(dicItem)){
                result = dicItem.getItemName();
            }
        }else{
            String organCode = prescriptionMap.get("ORGAN_CODE").toString();
            Organization org = organizationApp.queryOrgan(organCode);
            if(ObjectUtil.isNotEmpty(org)){
                result = org.getOrganName();
            }
        }
        return result;
    }

    private String getOrganCode(String genreCode,Map<String,Object> prescriptionMap){
        String result = "";
        if("0".equals(genreCode)){
            result = prescriptionMap.get("GB_CODE").toString();

        }else{
            result= prescriptionMap.get("ORGAN_CODE").toString();
        }
        return result;
    }

}