package com.founder.rhip.idm.controller.tb;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.idm.ListCcDto;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.*;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.common.TbStatus;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.idm.controller.form.TbQueryForm;
import com.founder.rhip.idm.dto.TbSaveDto;
import com.founder.rhip.idm.service.ITbService;
import com.founder.rhip.mdm.entity.Organization;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * 规范化管理
 */
@Controller
@RequestMapping("/idm/tb/management")
public class StandardizedManagementController extends BaseController {

	@Resource(name = "tbService")
	private ITbService tbService;

	@RequestMapping("/search")
	public String managementSearch(String type, HttpServletRequest request, ModelMap model) {
		request.getSession().setAttribute("typeTb", type);
	    return "rhip.idm.standardization.search";
	}

	/**
	 * 规范化列表
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String searchManagementList(TbQueryForm form, HttpServletRequest request, ModelMap model) {
		
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		String firstVist = form.getFirstVist();
		String orgcode = form.getOrgCode();
		criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_TREATMENT.getValue()});
		/*获取已接受的患者*/
		criteria.add("status.SPECIAL_STATUS", TbStatus.ACCEPT.getValue());
		getRoleCriteria(criteria, request);
		PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, null, null,firstVist);
		
		model.addAttribute("standardizations", plist.getList());
		model.addAttribute("page", plist.getPage());
	    return "rhip.idm.standardization.list";
	}

    /**
     * 保存规范化管理信息
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public String save(TbSaveDto tbSaveDto, HttpServletRequest request, ModelMap model) throws Exception {
        boolean result = false;
        if (ObjectUtil.isNotEmpty(tbSaveDto)) {
            //获取子表数据
            getListData(tbSaveDto);
            result = tbService.saveStandardization(tbSaveDto);
        }
        createOperationLog(request, RhipModuleName.IDM, "结核病专项-规范化管理", OperationName.ADD);
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    
    /**
	 * 获取查询结核病 治疗管理卡的权限条件
	 * @param criteria
	 * @param request
	 * @return
	 */
	private void getRoleCriteria(Criteria criteria, HttpServletRequest request) {
		Criteria temp = new Criteria();
		String orgCode = getCurrentOrg(request).getOrganCode();
        //BUG0095656
		if (!hasRole(RoleType.JKJHB, request)&&!hasRole(RoleType.DDCRBYY, request)) {
    		temp.add("status.LAST_UNIT", orgCode).add("status.special_status", 
    				OP.IN,new Integer[]{TbStatus.REASSIGN.getValue(), TbStatus.ACCEPT.getValue()})
    			.add(LOP.OR, new Criteria("status.CURRENT_UNIT", orgCode));
    		criteria.add(temp);
		}
	}
	
    /**
     * 子表数据处理
     *
     * @return
     */
    private void getListData(TbSaveDto tbSaveDto) throws InstantiationException, IllegalAccessException {
    	
    	//督导服药－子表
    	String listSdJson = tbSaveDto.getListSdJson();
        if (StringUtil.isNotEmpty(listSdJson) && !"[]".equals(listSdJson)) {
            List<ListSd> listSd = (List<ListSd>) json2Obj(listSdJson, ListSd.class);
            tbSaveDto.setListSd(listSd);
        }else {
            //页面上无法获取子表数据 从数据库取
            Criteria criteria = new Criteria("IDM_ID",tbSaveDto.getSingleId());
            //非耐多药标记
            criteria.add("FLAG", "0");
            List<ListSd> listSd = tbService.getSdList(criteria);
            tbSaveDto.setListSd(listSd);
        }
        //用药延迟－子表
        String listDdJson = tbSaveDto.getListDdJson();
        if (StringUtil.isNotEmpty(listDdJson)) {
            List<ListDd> listDds = (List<ListDd>) json2Obj(listDdJson, ListDd.class);
            tbSaveDto.setListDd(listDds);
        }
    	
    	// 访视记录－子表
        String frListJson = tbSaveDto.getListFrJson();
        if (StringUtil.isNotEmpty(frListJson)) {
            List<ListFr> listFrs = (List<ListFr>) json2Obj(frListJson, ListFr.class);
            tbSaveDto.setListFr(listFrs);
        }
    }
    
    /**
     * 进入预约查痰页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/sputum")
    public String initSputum(String singleId, String thisDtStr, String thisType, Integer logoff, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if (!StringUtil.isNotEmpty(singleId)) {
            return EHRMessageUtil.returnMsg(model, "fail");
        }
        Criteria ca = new Criteria("IDM_ID",singleId);
        Order od = new Order("SPUTUM_DT",true);//正序
        List<ListAs> listAs = tbService.getAsList(ca, od);

        /*int setAble = 0;   //2月结果已填写，下次检查结果已填写
        if(listAs.size() == 1){
            setAble = 1;   //2月结果未填写
        }else if(listAs.size() > 1){
            ListAs temp = listAs.get(1);
            if(!StringUtil.isNotEmpty(temp.getSputumResult())){
                setAble = 2;  //2月结果已填写，下次检查结果未填写
            }
        }*/

        model.addAttribute("listAs", listAs);
        /*model.addAttribute("setAble", setAble);
        model.addAttribute("thisType", thisType);*/

        model.addAttribute("logoff", logoff);
        model.put("singleId", singleId);
        model.put("pageIndex", pageIndex);
        return "rhip.idm.tb.standardization.sputum";
    }

    /**
     * 保存预约查痰日期
     * @param singleId
     * @param sputumJson
     * @return
     */
    @RequestMapping("/saveSputum")
    public String saveSputum(String singleId, String sputumJson, HttpServletRequest request, ModelMap model) throws Exception {
        if (!StringUtil.isNotEmpty(singleId)) {
            return EHRMessageUtil.returnMsg(model, "fail");
        }
        boolean result = false;
        Organization org = getCurrentOrg(request);
        String orgCode = org.getOrganCode();
        String userId = getCurrentUser(request).getUserCode();
        List<ListAs> idmListAs = (List<ListAs>) json2Obj(sputumJson, ListAs.class, orgCode, userId, singleId);
        tbService.updateAs(idmListAs);
        createOperationLog(request, RhipModuleName.IDM, "结核病专项-预约查痰", OperationName.ADD);
        result = true;
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    @RequestMapping("/init")
    public String initChild(String singleId, Integer logoff, HttpServletRequest request, ModelMap model) {
    	model.put("singleId", singleId);
		model.addAttribute("tbSaveDto", tbService.getStandardization(singleId));
    	model.put("logoff", logoff);
        request.getSession().removeAttribute("idmAddType");
	    return "rhip.idm.standardization.child.list";
	}

    @RequestMapping("/initFuwu")
    public String initFuwuChild(String singleId, Integer logoff, HttpServletRequest request, ModelMap model) {
        model.put("singleId", singleId);
        model.addAttribute("tbSaveDto", tbService.getStandardization(singleId));
        model.put("logoff", logoff);
        request.getSession().setAttribute("idmAddType", "1");
        return "rhip.idm.standardization.service.record.list";
    }

    @RequestMapping("/initDrug")
    public String initDrug(String singleId, String patientName, Integer logoff, HttpServletRequest request, ModelMap model) {
        String drugCardId = request.getParameter("drugCardId");
        Criteria criteria = new Criteria("IDM_ID",singleId);
        //非耐多药标记
        criteria.add("FLAG", "0");
        List<ListSd> listSds = tbService.getSdList(criteria);
        if(null != listSds && listSds.size()>0){
            StringBuffer sb = new StringBuffer();
            for(ListSd listSd : listSds){
                sb.append(listSd.getMonthNo().toString() + "-" + listSd.getDayNo().toString());
                sb.append(":");
                sb.append(listSd.getDrudType());
                sb.append(",");
            }
            String initJson = sb.toString();
            initJson = initJson.substring(0, initJson.length()-1);
            model.addAttribute("initJson", initJson);
        }

        User user = getCurrentUser(request);
        model.put("singleId", singleId);
        model.put("patientName", patientName);
        model.put("drugDoctor", user.getUserCode());
        model.put("logoff", logoff);
        return "rhip.idm.standardization.medicine.add";
    }

    /***
     * 停止治疗
     * @param singleId
     * @param logoff
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/trDiscontinued")
    public String trDiscontinued(String statusId, String singleId, Integer logoff, HttpServletRequest request, ModelMap model) {
        IdmStatusInfo statusInfo = tbService.findIdmStatusInfo(statusId);
        Integer frCount = tbService.findFrCount(singleId);
        if(statusInfo!=null&&statusInfo.getVisitCount()==null){
            statusInfo.setVisitCount(frCount.longValue());
        }
        model.addAttribute("statusInfo", statusInfo);
        model.put("logoff", logoff);
//        request.getSession().setAttribute("idmAddType", "1");
        return "rhip.idm.standardization.service.trDiscontinued";
    }

    /***
     * 保存停止治疗
     * @param singleId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/saveDiscontinued")
    @ResponseBody
    public Map<String, Object> saveDiscontinued(String singleId, IdmStatusInfo statusInfo, HttpServletRequest request, ModelMap model) {
        int rs = tbService.updateIdmStatusInfo(statusInfo);
        createOperationLog(request, RhipModuleName.IDM, "结核病专项-服务记录", OperationName.ADD);
        Map<String, Object> map = new HashMap<>();
        map.put("result", rs>0 ? "true!" : "false!");
        map.put("message", rs>0 ? "操作成功!" : "操作失败!");
        return map;
    }



    @RequestMapping("/saveDrug")
    public String saveDrug(String singleId, String dataJson, HttpServletRequest request, ModelMap model) {
        List<ListSd> listSds = new ArrayList<ListSd>();
        boolean result = false;
        if(StringUtil.isNotEmpty(dataJson)){
            User user = getCurrentUser(request);
            JSONObject jObject = JSONObject.fromObject(dataJson);
            HashMap objMap = (HashMap) JSONObject.toBean(jObject, HashMap.class);
            for(Object key : objMap.keySet()){
                ListSd listSd = new ListSd();
                listSd.setIdmId(Long.parseLong(singleId));

                String keyStr = key.toString();
                String keyParts[] = keyStr.split("-");
                listSd.setMonthNo(Integer.parseInt(keyParts[0]));
                listSd.setDayNo(Integer.parseInt(keyParts[1]));
                listSd.setDrudType((String)objMap.get(key));
                listSd.setDrugDoctor(user.getUserCode());
                //非耐多药普通患者
                listSd.setFlag("0");
                listSds.add(listSd);
            }
            Criteria c = new Criteria("IDM_ID", singleId);
            tbService.saveSd(c, listSds);
            createOperationLog(request, RhipModuleName.IDM, "结核病专项-用药记录", OperationName.ADD);
            result = true;
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    @RequestMapping("/saveServiceRecord")
    @ResponseBody
    public Map<String, Object> saveServiceRecord(String singleId, ListSr listSr, HttpServletRequest request, ModelMap model) {
        boolean result = tbService.saveListSr(listSr);
        createOperationLog(request, RhipModuleName.IDM, "结核病专项-服务记录", OperationName.ADD);
        Map<String, Object> map = new HashMap<>();
        map.put("result", result);
        map.put("message", result ? "操作成功!" : "操作失败!");
        return map;
    }

    /**
     * 删除服务记录
     *
     * @param id
     *            服务记录主键ID
     * @return
     */
    @RequestMapping("/deleteServiceRecord/{id}")
    @ResponseBody
    public Map<String, Object> deleteServiceRecord(@PathVariable("id") String id, HttpServletRequest request) {
        Boolean rs = false;
        createOperationLog(request, RhipModuleName.IDM, "结核病专项-服务记录", OperationName.DELETE);
        rs=tbService.delListSr(id);
        Map<String, Object> map = new HashMap<>();
        map.put("result", rs);
        map.put("message", rs ? "删除成功!" : "删除失败!");
        return map;
    }

    /**
     * 删除耐多药服药卡
     *
     *            服务记录主键ID
     * @return
     */
    @RequestMapping("/deleteNdy/{id}/{idmId}")
    @ResponseBody
    public Map<String, Object> deleteNdy(@PathVariable("id") String drugCardId, @PathVariable("idmId") String idmId, HttpServletRequest request) {
        Boolean rs = false;
        createOperationLog(request, RhipModuleName.IDM, "结核病专项-耐多药服药卡", OperationName.DELETE);
        rs=tbService.delNdy(drugCardId,idmId);
        Map<String, Object> map = new HashMap<>();
        map.put("result", rs);
        map.put("message", rs ? "删除成功!" : "删除失败!");
        return map;
    }

    @RequestMapping("/saveNdyDrug")
    public String saveNdyDrug(String singleId, String dataJson, DrugCard drugCard, HttpServletRequest request, ModelMap model) {

        boolean result = false;
        User user = getCurrentUser(request);
        if(StringUtil.isEmpty(dataJson))
            return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
        drugCard.setIdmId(new BigDecimal(singleId));
        tbService.saveDrugCard(drugCard,dataJson,user.getUserCode());
        createOperationLog(request, RhipModuleName.IDM, "结核病专项-耐多药服药卡", OperationName.ADD);
        result = true;
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 规范化管理中的子页面添加
     * @param trData
     * @param rowIndex
     * @param type
     * @param pageIndex
     * @param model
     * @param request
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @RequestMapping("/add")
    public String addChild(String singleId, String trData, String rowIndex, String type, String pageIndex, String firstVist,
                           ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
    	
    	this.setModel(trData, rowIndex, type, model, request);
    	model.put("rowIndex", rowIndex);
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
    	model.put("pageIndex", pageIndex);
    	model.put("singleId", singleId);
    	model.put("nowDate", new Date());
    	/*
    	* 0153176: 【肺结核健康管理】随访记录将第一次和入户分开
    	* */
        TbSaveDto tbSaveDto = tbService.getTbSaveDto(singleId);
        model.addAttribute("tbSaveDto", tbSaveDto);
        String typeTb = (String)request.getSession().getAttribute("typeTb");
        return this.getUrl(typeTb, firstVist);
    }

    /***
     *  编辑服务记录
     * @param singleId
     * @param id
     * @param model
     * @param request
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @RequestMapping("/edit")
    public String editChild(String singleId, String id,
                            ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {

        model.put("type", "edit");
        model.put("singleId", singleId);
        model.put("nowDate", new Date());
//        String typeTb = (String)request.getSession().getAttribute("typeTb");
//        String addType = (String)request.getSession().getAttribute("idmAddType");
        ListSr listSr = tbService.findListSr(id);
        model.put("listSr", listSr);
        return "rhip.idm.standardization.service.record.add";
    }

    private void setModel(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request)  throws InstantiationException, IllegalAccessException {
    	String typeTb = (String)request.getSession().getAttribute("typeTb");
    	if (StringUtil.isNotEmpty(trData) && StringUtils.equals(typeTb, "1")) {
    		 List<ListSd> idmListSdList = (List<ListSd>) json2Obj(trData, ListSd.class);
             model.put("listSd", idmListSdList.get(0));
        } else if (StringUtil.isNotEmpty(trData) && StringUtils.equals(typeTb, "3")) {
        	 List<ListFr> idmListFrList = (List<ListFr>) json2Obj(trData, ListFr.class);
             model.put("listFr", idmListFrList.get(0));
        } else if (StringUtil.isNotEmpty(trData) && StringUtils.equals(typeTb, "4")) {
        	 List<ListDd> idmListDdList = (List<ListDd>) json2Obj(trData, ListDd.class);
             model.put("listDd", idmListDdList.get(0));
        }
    }
    
//    private String getUrl(String typeTb) {
//    	String url = "rhip.idm.standardization.medicine.add";
//    	if (StringUtils.equals(typeTb, "3")) {
//    		url = "rhip.idm.standardization.interview.add";//访视记录
//    	} else if (StringUtils.equals(typeTb, "4")) {
//    		url = "rhip.idm.standardization.delayRecord.add";//用药延误记录
//    	}else if (StringUtils.equals(typeTb, "7"))   	{
//            return "rhip.idm.standardization.service.record.add";
//        }
//        return url;
//    }

    /**
     *
     * @param typeTb
     * @param firstVist 1：首次随访 ：2非首次随访
     * @return
     */
    private String getUrl(String typeTb, String firstVist) {
        String url = "rhip.idm.standardization.medicine.add";
        if (StringUtils.equals(typeTb, "3")) {
            url = "rhip.idm.standardization.interview.add";//访视记录
        } else if (StringUtils.equals(typeTb, "4")) {
            url = "rhip.idm.standardization.delayRecord.add";//用药延误记录
        } else if (StringUtils.equals(typeTb, "7") && StringUtils.equals(firstVist, "1"))   	{
            return "rhip.idm.standardization.service.record.add.first";
        } else if (StringUtils.equals(typeTb, "7") && StringUtils.equals(firstVist, "2"))   	{
            return "rhip.idm.standardization.service.record.add.second";
        }
        return url;
    }

    /**
     * 进入密切接触者页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initContacts")
    public String initContacts(String singleId, String patientName, String registerNum, Integer logoff, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {

        Criteria ca = new Criteria("IDM_ID",singleId);
        Order od = new Order("REGIST_DT",false);//正序
        Page page = super.getPage(request,  1, "/idm/tb/management/getContacts");

        PageList<ListCc> listCcs = tbService.getCcList(page, ca, od);

        ListCc listCc = new ListCc();
        listCc.setPatientName(patientName);
        listCc.setRegistNo(registerNum);
        model.put("listCc", listCc);
        model.put("logoff", logoff);
        model.put("listCcs", listCcs.getList());
        model.put("page", listCcs.getPage());
        model.put("idmId", singleId);

        return "rhip.idm.tb.standardization.contacts";
    }

    @Resource(name = "excelExportService")
    private IExcelExportService excelExportService;

    @RequestMapping("/contacts/downExcel")
    public void downExcel(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
        try {
            String singleId = request.getParameter("singleId");
            final Criteria ca = new Criteria("IDM_ID",singleId);
            final Order od = new Order("REGIST_DT",false);//正序
            excelExportService.exportListExecl("密切接触者", ListCcDto.class, response, new IDataSource() {
				@Override
				public List<Map<String, Object>> get(Page page) {
					return tbService.getCcMapList(ca, od);
				}
			});
            createOperationLog(request, RhipModuleName.IDM, "密切接触者", OperationName.EXP);
        } catch (Exception e) {
            logger.error("导出接触者列表出错", e);
            throw e;
        }
    }
    /**
     * 查询密切接触者列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getContacts")
    public String getContacts(String singleId, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {

        Criteria ca = new Criteria("IDM_ID",singleId);
        Order od = new Order("REGIST_DT",false);//正序
        int currentPage = Integer.valueOf(pageIndex);
        Page page = super.getPage(request, currentPage);

        PageList<ListCc> listCc = tbService.getCcList(page, ca, od);

        model.put("listCcs", listCc.getList());
        model.put("page", listCc.getPage());
        return "rhip.idm.tb.standardization.contactList";
    }

    /**
     * 添加密切接触者
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/addContacts")
    public String addContacts(ListCc listCc, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if(!ObjectUtil.isNotEmpty(listCc)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
            listCc.setCreateUnit(this.getCurrentOrg(request).getOrganCode());
            listCc.setCreateDt(new Date());
            listCc.setCreateUser(this.getCurrentUser(request).getUserCode());
            listCc.setModifyUnit(this.getCurrentOrg(request).getOrganCode());
            listCc.setModifyDt(new Date());
            listCc.setMofigyUser(this.getCurrentUser(request).getUserCode());
            tbService.insertCc(listCc);
            createOperationLog(request, RhipModuleName.IDM, "结核病专项-密切接触者", OperationName.ADD);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }


    /**
     * 密切接触者详细
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/contactDetail")
    public String contactDetail(String id, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        ListCc listCc = tbService.getCc(Long.parseLong(id));
        model.put("listCc", listCc);
        model.put("idmId", listCc.getIdmId());
        model.put("id", listCc.getId());

        return "rhip.idm.tb.standardization.contactDetail";
    }

    /**
     * 修改密切接触者
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/updateContacts")
    public String updateContacts(ListCc listCc, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if(!ObjectUtil.isNotEmpty(listCc)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
            listCc.setModifyUnit(this.getCurrentOrg(request).getOrganCode());
            listCc.setModifyDt(new Date());
            listCc.setMofigyUser(this.getCurrentUser(request).getUserCode());
            tbService.updateCc(listCc);
            createOperationLog(request, RhipModuleName.IDM, "结核病专项-密切接触者", OperationName.UPDATE);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }

    /**
     * 删除密切接触者
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/deleteContacts")
    public String deleteContacts(String id, String pageIndex, HttpServletRequest request, ModelMap model) throws Exception {
        if(!StringUtil.isNotEmpty(id)){
            return EHRMessageUtil.returnMsg(model, "fail");
        }else {
            tbService.deleteCc(Long.parseLong(id));
            createOperationLog(request, RhipModuleName.IDM, "结核病专项-密切接触者", OperationName.DELETE);
            return EHRMessageUtil.returnMsg(model, "success");
        }
    }
    
    /**
     * json数组转成List
     *
     * @param jsonArrayStr
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
	private static List<?> json2Obj(String jsonArrayStr, @SuppressWarnings("rawtypes") Class clazz) throws IllegalAccessException, InstantiationException {
    	@SuppressWarnings("rawtypes")
        List resultList = new ArrayList();
    	if (StringUtil.isNullOrEmpty(jsonArrayStr)) {
    		return resultList;
    	}
    	JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        String[] dateFormats = new String[]{"yyyy/MM/dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            Object obj = JSONObject.toBean(jsonObj, clazz);
            if(ObjectUtil.isNotEmpty(obj)){
                resultList.add(obj);
            }
        }
        return resultList;
    }

    /**
     * json数组转成List
     *
     * @param jsonArrayStr
     * @param clazz
     * @return
     */
    private static List<?> json2Obj(String jsonArrayStr, Class clazz, String orgCode, String userId , String singleId) throws IllegalAccessException, InstantiationException {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        String[] dateFormats = new String[]{"yyyy/MM/dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        List resultList = new ArrayList();
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            ListAs obj = (ListAs)JSONObject.toBean(jsonObj, clazz);
            obj.setIdmId(Long.parseLong(singleId));
            obj.setModifyDt(obj.getInspectDt());
            obj.setModifyUnit(orgCode);
            obj.setMofigyUser(userId);
            resultList.add(obj);
        }
        return resultList;
    }


}