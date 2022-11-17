package com.founder.rhip.idm.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmSetup;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.ehr.entity.control.idm.special.ListTs;
import com.founder.rhip.idm.common.ReportStatus;
import com.founder.rhip.idm.controller.form.ReportQueryForm;
import com.founder.rhip.idm.dto.CaseDto;
import com.founder.rhip.idm.service.IFrTsService;
import com.founder.rhip.idm.service.IReportService;
import com.founder.rhip.idm.service.ISetupService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 随访、采样
 */
@Controller
@RequestMapping("/idm/frts")
public class FrTsController extends BaseController {

    @Resource(name = "frTsService")
    private IFrTsService frTsService;

    @Resource(name = "setupService")
    private ISetupService setupService;

    @Resource(name = "reportService")
    private IReportService reportService;
    
    @Autowired
	private IOrganizationApp organizationApp;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static List<String> tsCodes = new ArrayList<String>(Arrays.asList("101","102","201",
            "2031","2032","2033","2034","205","206","208","209","211",
            "2121","2122","2123",
            "2151","2152",
            "216",
            "220","221","224","311"));

    List<String> ignoreInfectious = new ArrayList<String>(Arrays.asList(
            "202",//艾滋病
            "2035", //病毒性肝炎 未分型
            "2141", "2142", "2143", "2144",//病毒性肝炎 未分型
            "2261", "2262", "2263",//疟疾
            "305",//麻风病
            "225",//血吸虫病
            "309"//丝虫病
    ));
    /**
     * 进入随访查询画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/frIndex")
    public String frIndex(HttpServletRequest request, ModelMap model) {
        boolean bAllOrg = false;
        /*根据当前机构，设置页面中的上报机构*/
        Organization org = getCurrentOrg(request);
        String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
        if (hasRole(RoleType.JKFYK, request)) {
            bAllOrg = true;
        }
        if (!bAllOrg) {
            model.addAttribute("fillOrganCode", currentOrgCode);
            model.addAttribute("currentOrgCode", currentOrgCode);
        }
        model.addAttribute("logoff", "0");
        return "rhip.idm.case.frSearch";
    }

    @RequestMapping("/frList")
    public String frList(ReportQueryForm form, HttpServletRequest request, ModelMap model) {
        //String url = "rhip.idm.frList";  //手足口LIST
    	String url = "rhip.idm.case.afpFrList";//AFP LIST
        PageList<IdmReport> plist = new PageList<>();
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = null;
        String orgCode = getCurrentOrg(request).getOrganCode();
        List<String> orgStr = new ArrayList<String>();
        ca = form.getCriteria();
        if(ObjectUtil.isNullOrEmpty(ca.get("CURRENT_UNIT"))){
        	//2017-10-10需求修改：中心可见下属站
        	if(hasRole(RoleType.ZXCRB, request)){
        		Criteria criteria = new Criteria();
        		criteria.add("organCode", orgCode);
        		criteria.add(LOP.OR,"parentCode", orgCode);
        		List<Organization> orgs = organizationApp.queryOrganization(criteria);
        		for(Organization org: orgs){
        			orgStr.add(org.getOrganCode());        		
        		}
        		ca.add("CURRENT_UNIT", OP.IN, orgStr);
        	}else if (hasRole(RoleType.YYCRB, request) || hasRole(RoleType.ZCRB, request)){
        		//医院、站 只显示分配给自己的
        		ca.add("CURRENT_UNIT",  orgCode);
        	}
        }
        /*2017-8-28 修改为手足口不随访，随访AFP 327 ,脊髓灰质炎 204 随访必须已分配的；分配中的不随访*/
       // ca.add("INFECTIOUS_CODE", "311"); //手足口
        ca.add("INFECTIOUS_CODE", OP.IN, new String[]{"204", "327"});
        ca.add("REPORT_STATUS", ReportStatus.HOSPITAL_VERIFY.getValue());
        //随访必须已分配的；分配中的不随访
        plist = reportService.getFrList(ca, page);
        model.addAttribute("reports", plist);
        model.addAttribute("page", plist.getPage());
        model.addAttribute("pageIndex", indexPage);
        return url;
    }

    /**
     * 进入采样查询画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/tsIndex")
    public String tsIndex(HttpServletRequest request, ModelMap model) {
        boolean bAllOrg = false;
		/*根据当前机构，设置页面中的上报机构*/
        Organization org = getCurrentOrg(request);
        String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
        if (hasRole(RoleType.JKFYK, request)) {
            bAllOrg = true;
        }
        if (!bAllOrg) {
            model.addAttribute("fillOrganCode", currentOrgCode);
            model.addAttribute("currentOrgCode", currentOrgCode);
        }
        model.addAttribute("logoff", "0");
        return "rhip.idm.case.tsSearch";
    }

    /**
     * 随访初始化
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initFr")
    public String initFr(Long singleId, String name, Long logoff, HttpServletRequest request, ModelMap model) {

    	String url = "";

        Criteria ca = new Criteria("idmId", singleId);
        Page page = super.getPage(request, 1);
        Order od = new Order("VISIT_DT", false);//正序
        IdmReport report = frTsService.getReportInfo(singleId);
        if("327".equals(report.getInfectiousCode()) || "204".equals(report.getInfectiousCode())){
        	url = "rhip.idm.case.afpFr";//AFP,脊髓灰质炎
        }else if ("311".equals(report.getInfectiousCode())){
        	url = "rhip.idm.case.fr";//手足口
        }
        ListFr listFr = new ListFr();
        PageList<ListFr> plist = frTsService.findFrList(ca, page, od);
        //患者基本信息-有随访时显示随访信息，没有显示报卡信息
        List<ListFr> listFrs = frTsService.findIdmListFrs(new Criteria("idmId",singleId));
        if(ObjectUtil.isNotEmpty(listFrs)){
            listFr= listFrs.get(0);
        }else{ 
            if (ObjectUtil.isNotEmpty(report)) {
                listFr.setName(report.getName());
                listFr.setGender(report.getGender());
                listFr.setAge(report.getAge());
                listFr.setParentsName(report.getParentsName());
                listFr.setPatownShip(report.getPatownShip());
                listFr.setPastreet(report.getPastreet());
                listFr.setPahouseNumber(report.getPahouseNumber());
                listFr.setPhoneNumber(report.getPhoneNumber());
                listFr.setAttackDt(report.getPathogenesisDate());
                listFr.setTreatmentDt(report.getDiagnosisDate());
                listFr.setTreatmentUnit(report.getFillOrganName());
                listFr.setRecordNumber(report.getRecordNumber());
                listFr.setBirthday(report.getBirthday());
            }
        }
        User user = getCurrentUser(request);
        listFr.setVisitById(user.getUserCode());
        model.addAttribute("listFr", listFr);
        model.addAttribute("singleId", singleId);
        model.addAttribute("frList", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("logoff", logoff);
        model.addAttribute("infectiousCode", report.getInfectiousCode());
        return url;
    }

    @RequestMapping("/tsList")
    public String caseList(ReportQueryForm form, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.tsList";
        PageList<IdmReport> plist = new PageList<>();
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = null;
        String orgCode = getCurrentOrg(request).getOrganCode();
        ca = form.getCriteria();
        if(!ObjectUtil.isNotEmpty(ca.get("infectiousCode"))){
            ca.add("INFECTIOUS_CODE", OP.IN,  tsCodes);
        }
        if(!hasRole(RoleType.JKFYK, request)){
            Criteria crF  = new Criteria("fillOrganCode",  orgCode);
            Criteria crC = new Criteria("CURRENT_UNIT", orgCode);
            crF.add(LOP.OR, crC);
            ca.add(crF);
        }
        ca.add("REPORT_STATUS", ReportStatus.HOSPITAL_VERIFY.getValue());

        plist = reportService.findReport(ca,page);

        model.addAttribute("reports", plist);
        model.addAttribute("page", plist.getPage());
        model.addAttribute("pageIndex", indexPage);
        return url;
    }

    /**
     * 随访列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/searchFrList")
    public String searchFrList(Long singleId, int pageIndex, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.case.frList";

        Criteria ca = new Criteria("idmId", singleId);
        Page page = super.getPage(request, pageIndex, "/idm/frts/initFr");
        Order od = new Order("VISIT_DT", false);//正序
        PageList<ListFr> plist = frTsService.findFrList(ca, page, od);

        model.addAttribute("frList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return url;
    }

    /**
     * 获取随访明细
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initFrDetail")
    public String initFrDetail(Long id, HttpServletRequest request, ModelMap model) {
        Criteria ca = new Criteria("id", id);
        ListFr listFr = frTsService.findFr(ca);

        model.put("listFr", listFr);
        model.put("singleId", listFr.getIdmId());

        return "rhip.idm.case.frDetail";
    }

    /**
     * 保存随访
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/saveFr")
    public String saveFr(ListFr listFr, String type, HttpServletRequest request, ModelMap model) throws InstantiationException, IllegalAccessException {
        boolean result = false;
        Organization org = getCurrentOrg(request);
        User user = getCurrentUser(request);
        if("327".equals(listFr.getInfectiousCode()) || "204".equals(listFr.getInfectiousCode())){
        	if(ObjectUtil.isNullOrEmpty(listFr.getId())){
        		listFr.setVisitById(user.getUserCode());
            	listFr.setVisitInst(org.getOrganCode());
            	listFr.setCreateDt(new Date());
            	listFr.setCreateUnit(org.getOrganCode());
            	listFr.setCreateUser(user.getUserCode());
    		} else {
    			listFr.setModifyUnit(org.getOrganCode());
    			listFr.setModifyDt(new Date());
    			listFr.setMofigyUser(user.getUserCode());
    		}
        	result = frTsService.addFr(listFr);
        }else if ("311".equals(listFr.getInfectiousCode())){//手足口
        	if (ObjectUtil.isNotEmpty(listFr)) {
                String frList = listFr.getListFrJson();
                if (StringUtil.isNotEmpty(frList)) {
                    List<ListFr> idmListFr = (List<ListFr>) json2Obj(frList, ListFr.class);
                    for(ListFr listFr1 : idmListFr){
                        listFr1.setVisitById(user.getUserCode());
                    }
                    listFr.setListFrs(idmListFr);
                }
                result = frTsService.addFr(listFr);
            }
        }
        createOperationLog(request, RhipModuleName.IDM, "36种传染病随访", OperationName.ADD);
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 删除随访
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/deleteFr")
    public String deleteFr(String id, HttpServletRequest request, ModelMap model) throws Exception {
        if (!StringUtil.isNotEmpty(id)) {
            return EHRMessageUtil.returnMsg(model, "fail");
        } else {
            frTsService.deleteFr(Long.parseLong(id));
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }

    /**
     * 采样初始化
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initTs")
    public String initTs(Long singleId, String infectiousCode, Long logoff, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.case.ts";

        Criteria ca = new Criteria("idmId", singleId);
        Page page = super.getPage(request, 1);
        Order od = new Order("SAMPLE_DT", false);//正序
        PageList<ListTs> plist = frTsService.findTsList(ca, page, od);

        Long userId = getCurrentUser(request).getId();
        ListTs listTs = new ListTs();
//        listTs.setName(name);
        IdmReport report = frTsService.getReportInfo(singleId);
        if (ObjectUtil.isNotEmpty(report)) {
            listTs.setName(report.getName());
            listTs.setGender(report.getGender());
            listTs.setBirthday(report.getBirthday());
            listTs.setParentsName(report.getParentsName());
            listTs.setAttackDt(report.getPathogenesisDate());
            listTs.setTreatDt(report.getDiagnosisDate());
        }

        CaseDto caseDto = frTsService.getPersonInfo(singleId);
        if (ObjectUtil.isNotEmpty(caseDto.getCaseInformation())) {
            listTs.setMediRecordNum(caseDto.getCaseInformation().getMediRecordNum());
        }

        listTs.setCreateDt(new Date());
        listTs.setCreateUser(userId.toString());
        listTs.setCreateUnit(getCurrentOrg(request).getOrganCode());

        model.addAttribute("listTs", listTs);
        model.addAttribute("singleId", singleId);
        model.addAttribute("tsList", plist.getList());
        model.addAttribute("infectiousCode", infectiousCode);
        model.addAttribute("page", plist.getPage());
        model.addAttribute("logoff", logoff);

        return url;
    }

    /**
     * 采样列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/searchTsList")
    public String searchTsList(Long singleId, int pageIndex, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.case.tsList";

        Criteria ca = new Criteria("idmId", singleId);
        Page page = super.getPage(request, pageIndex, "/idm/frts/initTs");
        Order od = new Order("SAMPLE_DT", false);//正序
        PageList<ListTs> plist = frTsService.findTsList(ca, page, od);

        model.addAttribute("tsList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return url;
    }

    /**
     * 获取采样明细
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initTsDetail")
    public String initTsDetail(Long id, String infectiousCode, HttpServletRequest request, ModelMap model) {
        Criteria ca = new Criteria("id", id);
        ListTs listTs = frTsService.findTs(ca);

        model.put("listTs", listTs);
        model.put("infectiousCode", infectiousCode);
        model.put("singleId", listTs.getIdmId());

        return "rhip.idm.case.tsDetail";
    }

    /**
     * 保存采样
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/saveTs")
    public String saveTs(ListTs listTs, String type, String infectiousCode, HttpServletRequest request, ModelMap model) throws InstantiationException, IllegalAccessException {
        boolean result = false;
        if (ObjectUtil.isNotEmpty(listTs)) {
            listTs.setDiseaseCode(infectiousCode);
            Organization org = getCurrentOrg(request);
            User user = getCurrentUser(request);
            listTs.setModifyDt(new Date());
            listTs.setModifyUnit(org.getOrganCode());
            listTs.setMofigyUser(user.getId().toString());
            //添加
            if ("add".equals(type)) {
                listTs.setGenreCode(org.getGenreCode());//设置机构类型
                listTs.setCreateDt(new Date());
                listTs.setCreateUnit(org.getOrganCode());
                listTs.setCreateUser(user.getId().toString());
                result = frTsService.addTs(listTs);
                createOperationLog(request, RhipModuleName.IDM, "36种传染病采样", OperationName.ADD);
            } else if ("edit".equals(type)) {
                result = frTsService.updateTs(listTs);
                createOperationLog(request, RhipModuleName.IDM, "36种传染病采样", OperationName.UPDATE);
            }
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 删除采样
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/deleteTs")
    public String deleteTs(String id, HttpServletRequest request, ModelMap model) throws Exception {
        if (!StringUtil.isNotEmpty(id)) {
            return EHRMessageUtil.returnMsg(model, "fail");
        } else {
            frTsService.deleteTs(Long.parseLong(id));
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }

    @RequestMapping("/popFr")
    public String addContacted(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListFr> idmListFrList = (List<ListFr>) json2Obj(trData, ListFr.class);
            model.put("listFr", idmListFrList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.frts.popFr";
    }

    private Criteria getCriteria(ReportQueryForm form, String orgCode) {
//        Criteria criteria1 = form.getCriteria();
//        List<String> infectiousCodes = getInfectiousCodes(orgCode);
//        //报卡状态是已审核 其防疫科将其传染病分给该用户
//        criteria1.add("INFECTIOUS_CODE", OP.IN, infectiousCodes);
        Criteria ca = new Criteria("CURRENT_UNIT", OP.EQ, orgCode);
//        Criteria ca1 = new Criteria("fillOrganCode", OP.EQ, orgCode);
//        ca.add(LOP.OR, ca1);
//        criteria1.add(ca);
        return ca;
    }

    /*五个专项的传染病code和不作处理的code(肝炎，艾滋病)*/
    public static List<String> specialInfectiousCodes = new ArrayList<String>(Arrays.asList("2141", "2142", "2143", "2144", "2035", "202", "2261",
            "2262", "2263", "225", "305", "309"));

    /**
     * 根据当前用户的code和当前年份 从idm_setup表中获取当前用户所需管辖的个案
     *
     * @return
     */
    private List<String> getInfectiousCodes(String orgCode) {
        List<String> infectiousCodes = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        Criteria criteria = new Criteria("SET_YEAR", calendar.get(Calendar.YEAR));
        criteria.add("CASE_ORGAN_CODE", orgCode);
        List<String> notHandleCodes = new ArrayList<String>(specialInfectiousCodes);
        notHandleCodes.add("2035");
        notHandleCodes.add("202");
        criteria.add("INFECTIOUS_CODE", OP.NOTIN, notHandleCodes);
        List<IdmSetup> idmSetupList = setupService.findSetup(criteria);
        if (ObjectUtil.isNotEmpty(idmSetupList)) {
            for (IdmSetup idmSetup : idmSetupList) {
                infectiousCodes.add(idmSetup.getInfectiousCode());
            }
        }
        return infectiousCodes;
    }

    /**
     * json数组转成List
     *
     * @param jsonArrayStr
     * @param clazz
     * @return
     */
    private static List<?> json2Obj(String jsonArrayStr, Class clazz) throws IllegalAccessException, InstantiationException {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        String[] dateFormats = new String[]{"yyyy/MM/dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        List resultList = new ArrayList();
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            Object obj = JSONObject.toBean(jsonObj, clazz);
            resultList.add(obj);
        }
        return resultList;
    }

}