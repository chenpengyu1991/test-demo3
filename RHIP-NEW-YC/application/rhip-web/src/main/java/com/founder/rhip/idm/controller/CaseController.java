package com.founder.rhip.idm.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.service.IReportCardService;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.ICaseApprovalInfoDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.ICaseInformationDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmStatusInfoDao;
import com.founder.rhip.ehr.repository.control.idm.special.IEventInfoDao;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.idm.common.AssignmentStatus;
import com.founder.rhip.idm.common.ReportStatus;
import com.founder.rhip.idm.controller.form.ReportQueryForm;
import com.founder.rhip.idm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.idm.dto.CaseDto;
import com.founder.rhip.idm.dto.ReportDto;
import com.founder.rhip.idm.service.ICaseSurveyService;
import com.founder.rhip.idm.service.IReportService;
import com.founder.rhip.idm.service.ISetupService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

/**
 * 个案处置管理
 */
@Controller
@RequestMapping("/idm/case")
public class CaseController extends BaseController {

    @Resource(name = "reportService")
    private IReportService reportService;

    @Resource(name = "caseSurveyService")
    private ICaseSurveyService caseSurveyService;

    @Resource(name="setupService")
    private ISetupService setupService;
    
    @Resource(name = "idmStatusInfoDao")
    private IIdmStatusInfoDao idmStatusInfoDao;
    
    @Resource(name = "eventInfoDao")
    private IEventInfoDao eventInfoDao;//状态表
    
    @Resource(name = "excelExportService")
	private IExcelExportService excelExportService;
    @Resource(name="dictionaryApp")
    private IDictionaryApp dictionaryApp;
    
    @Resource(name="caseApprovalInfoDao")
    ICaseApprovalInfoDao caseApprovalInfoDao;
    
    @Resource(name="caseInformationDao")
    ICaseInformationDao caseInformationDao;
    
    @Resource(name = "reportCardService")
	private IReportCardService reportCardService;
    
    @Autowired
	private IOrganizationApp organizationApp;
    
    @Resource(name="mdmDictionaryService")
    private IDictionaryService mdmDictionaryService;
 

    //防保科只能看到以下疾病
    /*private static List<String> caseCodes = new ArrayList<String>(Arrays.asList("101","102","201",
            "2031","2032","2033","2034","205","206","208","209","211",
            "2121","2122","2123",
            "2131", "2132",
            "2151","2152",
            "216",
            "220","221","224","311","210","217","218","303","310","204","304","302","240"));*/
    
    //屏蔽未设个案的传染病
    private static List<String> notCaseCodes = new ArrayList<String>(Arrays.asList("2035", "2132", "222",
			"2231", "2232", "2233",
			"2234", "306", "307", "201",
			"308", "205",
			"2035","305","309","225","214","2141","2142","2143","2144",
			 "001", "002", "003", "004", "005", "006", "007", "008", "009"));
    
    Properties properties = PropertiesUtils.initProperties("idm-export-def");
    
    //甲类
    List<String> caseCodes = new ArrayList<String>(Arrays.asList("101","102","2121","204","201"));

    /**
     * 进入个案查询画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String search(HttpServletRequest request, ModelMap model) {
        boolean bAllOrg = false;
		/*根据当前机构，设置页面中的上报机构*/
        Organization org = getCurrentOrg(request);
        String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
        if (hasRole(RoleType.JKFYK, request)){
            bAllOrg = true;
        }
        if(!bAllOrg){
            model.addAttribute("fillOrganCode", currentOrgCode);
            model.addAttribute("currentOrgCode", currentOrgCode);
        }
        model.addAttribute("logoff", "0");
        model.addAttribute("tab", "case");
        return "rhip.idm.case.search";
    }

    /**
     * 查询报卡信息列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/caseList/{tab}")
    public String caseList(ReportQueryForm form, @PathVariable("tab") String tab, HttpServletRequest request, ModelMap model) {
   
        String url = "rhip.idm.case.caseList";
        PageList<IdmReport> plist = new PageList<>();
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = null;
        String orgCode = getCurrentOrg(request).getOrganCode();
        ca = form.getCriteria();  
        List<String> itemCodes = new ArrayList<String>();
        List<String> orgStr = new ArrayList<String>();
        Criteria crF  = new Criteria();
        if(!hasRole(RoleType.JKFYK, request) && !hasRole(RoleType.ADMIN, request)){
        	
        	Criteria infectiousCa = new Criteria();
        	//2017-8-17需求修改：中心可见下属站
        	if(hasRole(RoleType.ZXCRB, request)){
        		Criteria criteria = new Criteria();
        		criteria.add("organCode", orgCode);
        		criteria.add(LOP.OR,"parentCode", orgCode);
        		List<Organization> orgs = organizationApp.queryOrganization(criteria);
        		for(Organization org: orgs){
        			orgStr.add(org.getOrganCode());        		
        		}
        		infectiousCa = new Criteria("caseOrganCode", OP.IN, orgStr);
        		crF.add("CURRENT_UNIT", OP.IN, orgStr);
        		crF.add(LOP.OR, "ASSIGNED_TO_UNIT", OP.IN, orgStr);
        	}else{
        		//医院、站 只显示分配给自己的个案
        		infectiousCa = new Criteria("caseOrganCode", getCurrentOrg(request).getOrganCode());
        		crF.add("CURRENT_UNIT",  orgCode);
             	crF.add(LOP.OR, "ASSIGNED_TO_UNIT", orgCode);
        	}
            //infectiousCa.add("setYear", OP.EQ, DateUtil.getCurrentYear());
     	    List<IdmSetup> setups = setupService.findDistinctInfectiousCodes(infectiousCa);
     	    //只查询有个案填报页面的的疾病 屏蔽未设个案的传染病
     	    for(IdmSetup setup : setups){
	 	    	if(!ObjectUtil.isNullOrEmpty(CaseLayoutMap.getLayoutStr(setup.getInfectiousCode()))){
	 	    		itemCodes.add(setup.getInfectiousCode()); 
	        	}
    	    }                 
         	ca.add(crF); 
        }else{
        	//只查询有个案填报页面的的疾病 屏蔽未设个案的传染病--疾控，查看全部有个案的疾病
            List<DicItem> dicItems = dictionaryApp.queryDicItem(new Criteria("dicCode","CV0501017"));
		 	   for(DicItem dicItem: dicItems){
		 		  if(!ObjectUtil.isNullOrEmpty(CaseLayoutMap.getLayoutStr(dicItem.getItemCode()))){
			    		itemCodes.add(dicItem.getItemCode()); 
		      	  }    
		 	}
        }
        ca.add("INFECTIOUS_CODE", OP.IN, itemCodes);
        //屏蔽未设个案的传染病-2017-6-12 修改为了从CaseLayoutMap获取
        //ca.add("INFECTIOUS_CODE",OP.NOTIN, notCaseCodes);
        ca.add("REPORT_STATUS", ReportStatus.HOSPITAL_VERIFY.getValue());
        plist = reportService.findReport(ca,page);
        if(ObjectUtil.isNotEmpty(plist)){
			for(IdmReport dc : plist.getList()) {
				//HIV 和 艾滋病  修改为姓名 、身份证号、 现住址改为*****表示
				if("202".equals(dc.getInfectiousCode()) || "229".equals(dc.getInfectiousCode())){
					dc.setName(dc.getName().substring(0, 1)+"**");
					/*dc.setIdcard(dc.getIdcard().substring(0, 6)+"************");*/
				}
			}
        }
        model.addAttribute("reports", plist);
        model.addAttribute("page", plist.getPage());
        model.addAttribute("tab", tab);
        model.addAttribute("currentOrgCode", orgCode);
        model.addAttribute("logoff", form.getLogoff());
        return url;
    }
    
    @RequestMapping("/caseIndex")
    public String caseIndex(String id, String idmId, String infectiousCode, String type, Integer logoff, String name, ModelMap model, HttpServletRequest request, String pageIndex, String repeat) {
        model.put("idI", id);
        model.put("idmIdI", idmId);
        model.put("infectiousCode", infectiousCode);
        model.put("typeI", type);
        model.put("pageIndexI", pageIndex);
        model.put("nameI", name);
        model.put("logoffI", logoff);
        model.put("repeat", repeat);
        //个案查重-查看
        /*if(ObjectUtil.isNotEmpty(repeat)){
        	return "rhip.idm.case.repeatCase.index";
        }*/
        return "rhip.idm.case.index";
    }

    @RequestMapping("/initAdd")
    public String initAdd(String id, String idmId, String infectiousCode, Long logoff, ModelMap model, HttpServletRequest request, String pageIndex) {
        CaseDto caseDto = new CaseDto();
        Criteria ca = new Criteria("IDM_ID", OP.EQ,idmId).add("object", OP.IS," NULL");
        //获取报卡数据
        ReportDto reportDto = reportService.getReport(Integer.parseInt(id));
        IdmReport idmReport = reportDto.getReport();
        if (ObjectUtil.isNotEmpty(idmReport)) {
            caseDto = fillInReportData(idmReport);
        }
        /*获取密切接触者信息*/
        CaseDto dto = caseSurveyService.findcontacted(ca);
        if(ObjectUtil.isNotEmpty(dto)){
            caseDto.setIdmListEfcList(dto.getIdmListEfcList());
            caseDto.setEpidemiologicalSurvey(dto.getEpidemiologicalSurvey());
            caseDto.setIdmListEsList(dto.getIdmListEsList());
        }
        /*根据当前用户，设置页面中的调查机构*/
        CaseInformation caseInformation = caseDto.getCaseInformation();
        setCaseInfo(caseInformation, request); 
        caseDto.setCaseInformation(caseInformation);
        //个案状态：未填写
        caseDto.setCaseStatus("1"); 
        setAttackConditionInfo(caseDto, reportDto);
        setLabExamInfo(caseDto, reportDto);
        setRoleAttribute(model, request);
        model.addAttribute("caseDto", caseDto);
        model.put("idmId", idmId);
        model.put("logoff", logoff); 
        model.put("pageIndex", pageIndex); 
        model.put("infectiousCode", infectiousCode);
       return CaseLayoutMap.getLayoutStr(infectiousCode);
    }
    
    @RequestMapping("/initEdit")
    public String initEdit(String idmId, String infectiousCode, Long logoff, HttpServletRequest request, String pageIndex, ModelMap model) throws Exception {
        CaseDto caseDto = caseSurveyService.getCaseSurvey(idmId);
        setRoleAttribute(model, request);
        //个案状态：已填写
        caseDto.setCaseStatus("2");
        model.addAttribute("caseDto", caseDto);
        model.put("idmId", idmId);
        model.put("pageIndex", pageIndex);
        model.put("logoff", logoff);
        model.put("infectiousCode", infectiousCode);
        return CaseLayoutMap.getLayoutStr(infectiousCode);
    }
    /**
     * 查看
     * @param idmId
     * @param infectiousCode
     * @param logoff
     * @param request
     * @param pageIndex
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/initView")
    public String initView(String idmId, String infectiousCode, Long logoff, String repeat, HttpServletRequest request, String pageIndex, ModelMap model) throws Exception {
        CaseDto caseDto = caseSurveyService.getCaseSurvey(idmId);
        setRoleAttribute(model, request);
        //审核通过
        caseDto.setCaseStatus("3");
        model.addAttribute("caseDto", caseDto);
        model.put("idmId", idmId);
        model.put("pageIndex", pageIndex);
        model.put("logoff", logoff);
        model.put("repeat", repeat);
        return CaseLayoutMap.getLayoutStr(infectiousCode);
    }

    /**
     * 保存个案信息
     *
     * @param caseDto
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public String save(CaseDto caseDto, String infectiousCode , HttpServletRequest request, ModelMap model) throws Exception {
        String idmId = caseDto.getIdmId();
        if (!StringUtil.isNotEmpty(idmId)) {
            return EHRMessageUtil.returnMsg(model, "fail");
        }
        boolean result = false;
        if (ObjectUtil.isNotEmpty(caseDto)) {
            //获取子表数据
            getListData(caseDto);

            //需要具体到小时的时间处理
            prepareDate(caseDto);
            //设定调查者、调查单位
            setCaseInfo(caseDto, request, "add");
            IdmStatusInfo statusInfo = new IdmStatusInfo();
         
            if(hasRole(RoleType.JKFYK, request)||hasRole(RoleType.ADMIN, request)){
	           	statusInfo.setCaseStatus("3");
	        }else if(hasRole(RoleType.ZXCRB, request)||hasRole(RoleType.YYCRB, request)){
	        	 if(caseCodes.contains(infectiousCode)){
	        		 statusInfo.setCaseStatus("2");
	        	 }else{
	        		 statusInfo.setCaseStatus("3");
	        	 }
	        }else if(hasRole(RoleType.ZCRB, request)){
	        	statusInfo.setCaseStatus("2");
	        }          
            result = caseSurveyService.createCaseSurvey(caseDto, statusInfo, new PersonInfo());
            createOperationLog(request, RhipModuleName.IDM, "36种传染病个案" + idmId, OperationName.ADD);
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 修改个案信息
     *
     * @param caseDto
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String edit(CaseDto caseDto, String infectiousCode, HttpServletRequest request, ModelMap model) throws Exception {
        boolean result = false;
        User user = getCurrentUser(request);
        Organization org = getCurrentOrg(request);
        String idmId = caseDto.getIdmId();
        if (!StringUtil.isNotEmpty(idmId)) {
            return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
        }
        if (ObjectUtil.isNotEmpty(caseDto)) {
            //获取子表数据
            getListData(caseDto);

            //需要具体到小时的时间处理
            caseDto = prepareDate(caseDto);

            //设定调查者、调查单位
           //setCaseInfo(caseDto, request, "edit");
            IdmStatusInfo statusInfo = new IdmStatusInfo();
            
            if(hasRole(RoleType.JKFYK, request)||hasRole(RoleType.ADMIN, request)){
	           	statusInfo.setCaseStatus("3");
	        }else if(hasRole(RoleType.ZXCRB, request)||hasRole(RoleType.YYCRB, request)){
	        	 if(caseCodes.contains(infectiousCode)){
	        		 statusInfo.setCaseStatus("2");
	        	 }else{
	        		 statusInfo.setCaseStatus("3");
	        	 }
	        }else if(hasRole(RoleType.YYCRB, request)){
	        	statusInfo.setCaseStatus("2");
	        }        
            //传防科审核
            if(hasRole(RoleType.JKFYK, request)||(hasRole(RoleType.ZXCRB, request)&& !caseCodes.contains(infectiousCode))){
            	statusInfo.setCaseStatus("3");
            	 //防保科审核
            	createApprovalInfo("1", org.getOrganCode() , user, Long.parseLong(idmId), "");
            }else{
            	 statusInfo.setCaseStatus("2");
            }
            result = caseSurveyService.updateCaseSurvey(caseDto, statusInfo, new PersonInfo());
            createOperationLog(request, RhipModuleName.IDM, "36种传染病个案" + idmId, OperationName.UPDATE);
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    
    @RequestMapping("/back")
    public String back(CaseDto caseDto, HttpServletRequest request, ModelMap model) throws Exception {
        boolean result = false;
        User user = getCurrentUser(request);
        Organization org = getCurrentOrg(request);
        String idmId = caseDto.getIdmId();
        if (!StringUtil.isNotEmpty(idmId)) {
            return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
        }
        if (ObjectUtil.isNotEmpty(caseDto)) {
        	Long idmIdReal = eventInfoDao.get(Long.parseLong(idmId)).getStatusId();
		    List<Map<String, Object>> updateRecords =  idmStatusInfoDao.getMapList(new Criteria("ID", idmIdReal), "ID", "CASE_STATUS","CASE_PASS_STATUS");
	  		updateRecords.get(0).put("CASE_PASS_STATUS", 0);//个案不合格
	  	    updateRecords.get(0).put("CASE_STATUS", "4");   //个案状态为退回
            result = !"0".equals(idmStatusInfoDao.batchMapUpdate(updateRecords, "ID", "CASE_STATUS","CASE_PASS_STATUS"))? true : false;
            
            CaseInformation caseInfo = caseInformationDao.get( new Criteria("IDM_ID", idmId));
            createApprovalInfo("2", org.getOrganCode() , user, idmIdReal, caseInfo.getSurveyOrg()); 
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }


    @RequestMapping("/dysentery/dycontact")
    public String addDyContact(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws IllegalAccessException, InstantiationException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowNum", rowNum);
        }

        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.dysentery.contact.add";
    }

    @RequestMapping("/dysentery/disinfect")
    public String addDisinfectt(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws IllegalAccessException, InstantiationException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowNum", rowNum);
        }

        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.dysentery.disinfect.add";
    }
    
    @RequestMapping("/dysentery/le")
    public String addLe(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws IllegalAccessException, InstantiationException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListLe> idmListLeList = (List<ListLe>) json2Obj(trData, ListLe.class);
            model.put("idmListLe", idmListLeList.get(0));
            model.put("rowNum", rowNum);
        }

        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.dysentery.le.add";
    }

    @RequestMapping("/hfmd/contact")
    public String addContact(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEs", idmListEsList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.hfmd.contact";
    }

    @RequestMapping("/hfmd/contacted")
    public String addContacted(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.hfmd.contacted";
    }
    
    @RequestMapping("/pertussis/contacted")
    public String addPertussisContacted(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.pertussis.contacted";
    }
    @RequestMapping("/pertussis/contact")
    public String addPertussisContact(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEs", idmListEsList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.pertussis.contact";
    }
    /**
     * 水痘家庭病人
     * @param trData
     * @param rowIndex
     * @param type
     * @param model
     * @param request
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    
    @RequestMapping("/varicella/contacted")
    public String addVaricellaContacted(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.varicella.contacted";
    }
    @RequestMapping("/varicella/contact")
    public String addVaricellaContact(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEs", idmListEsList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.varicella.contact";
    }
    
    @RequestMapping("/mumps/contacted")
    public String addMumpsContacted(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.mumps.contacted";
    }
    @RequestMapping("/mumps/contact")
    public String addMumpsContact(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEs", idmListEsList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.mumps.contact";
    }
    
    @RequestMapping("/h7n9/exposure")
    public String addContact(String tableNo, String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
    	String url="";
    	//设置慢病以管理人数和规范化管理人数
		switch(tableNo){
			case "1":
				url = "rhip.idm.case.h7n9.exposure1";
				break;
			case "2":
				url = "rhip.idm.case.h7n9.exposure2";
				break;
			case "3":
				url = "rhip.idm.case.h7n9.exposure3";
				break;
			case "4":
				url = "rhip.idm.case.h7n9.exposure4";
				break;
			default :
				url = "";
				break;
		}
    	
    	if (StringUtil.isNotEmpty(trData)) {
            List<ListEh> idmListEhList = (List<ListEh>) json2Obj(trData, ListEh.class);
            model.put("idmListEh", idmListEhList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return url;
    }

    @RequestMapping("/meningitis/initPopEs")
    public String addMeningitisEs(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEs", idmListEsList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.meningitis.es";
    }

    @RequestMapping("/meningitis/initPopEfc")
    public String addMeningitisEfc(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.meningitis.efc";
    }

    @RequestMapping("/hav/contacted")
    public String addHavContacted(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.hav.contact";
    }
    /**
     * 鼠疫的实验室检查密切接触者的弹出
     * @param trData
     * @param rowIndex
     * @param type
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/plague/contact")
    public String addPlagueContact(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws Exception {
        String dialogId = request.getParameter("id");
        if (StringUtil.isNotEmpty(dialogId) && "leDialog".equals(dialogId)) {
            if (StringUtil.isNotEmpty(trData)) {
                List<ListLe> idmListLeList = (List<ListLe>) json2Obj(trData, ListLe.class);
                model.put("idmListLe", idmListLeList.get(0));
                model.put("rowIndex", rowIndex);
            }
            if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
                model.put("type", type);
            } else {
                model.put("type", "add");
            }
            return "rhip.idm.case.plague.contact";
        }
        if (StringUtil.isNotEmpty(dialogId) && "efcDialog".equals(dialogId)) {
            if (StringUtil.isNotEmpty(trData)) {
                List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
                model.put("idmListEfc", idmListEfcList.get(0));
                model.put("rowIndex", rowIndex);
            }
            if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
                model.put("type", type);
            } else {
                model.put("type", "add");
            }
            return "rhip.idm.case.plague.contacted";
        }
        return "";
    }

    /**
     * 钩体病的实验室检查弹出
     */
    @RequestMapping("/leptospirosis/contact")
    public String addLeptospirosisContact(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws Exception {
        if(StringUtil.isNotEmpty(trData)) {
            List<ListLe> idmListLeList = (List<ListLe>) json2Obj(trData, ListLe.class);
            model.put("idmListLe", idmListLeList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.leptospirosis.contact";
    }

    /**
     * 霍乱 病人发病前五天和发病后的主要活动情况
     *
     * @param trData
     * @param rowIndex
     * @param type
     * @param model
     * @param request
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @RequestMapping("/cholera/active")
    public String addCholeraActive(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.cholera.active";
    }

    @RequestMapping("/scarlatina/contact")
    public String addScarContact(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws IllegalAccessException, InstantiationException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowNum", rowNum);
        }

        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.scarlatina.contact";
    }

    @RequestMapping("/scarlatina/labExamine")
    public String addlabExamine(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws IllegalAccessException, InstantiationException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListLe> idmListLeList = (List<ListLe>) json2Obj(trData, ListLe.class);
            model.put("idmListle", idmListLeList.get(0));
            model.put("rowNum", rowNum);
        }

        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.scarlatina.labExamine";
    }

    /**
     * 霍乱 病前5天食谱
     */
    @RequestMapping("/cholera/diet")
    public String addCholeraDiet(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListBdd> idmListBddList = (List<ListBdd>) json2Obj(trData, ListBdd.class);
            model.put("idmListBdd", idmListBddList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.cholera.diet";
    }

    /**
     * 伤寒、副伤寒个案调查表 的字表
     */
    @RequestMapping("/typhia/child")
    public String addTyphiaChild(String typeChild, String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListLe> idmListLeList = (List<ListLe>) json2Obj(trData, ListLe.class);
            model.put("idmListLe", idmListLeList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.typhia." + typeChild;
    }

    /**
     * SARS 发病情况
     */
    @RequestMapping("/sars/ac")
    public String addAc(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListAc> idmListAcList = (List<ListAc>) json2Obj(trData, ListAc.class);
            model.put("idmListAc", idmListAcList.get(0));
            model.put("rowNum", rowNum);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.sars.ac";
    }

    /**
     * SARS 发病前一周内逐日活动情况
     */
    @RequestMapping("/sars/activity")
    public String addEsActivity(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEs", idmListEsList.get(0));
            model.put("rowNum", rowNum);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.sars.esActivity";
    }

    /**
     * SARS 发病前两周内接触动物
     */
    @RequestMapping("/sars/animal")
    public String addEsAnimal(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEsAnimal", idmListEsList.get(0));
            model.put("rowNum", rowNum);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.sars.esAnimal";
    }

    /**
     * SARS 发病后至隔离治疗前逐日活动情况
     */
    @RequestMapping("/sars/leave")
    public String addEsLeave(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEsLeave", idmListEsList.get(0));
            model.put("rowNum", rowNum);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.sars.esLeave";
    }

    /**
     * SARS 发病前2周内是否接触过非典病人或/和疑似非典患者
     */
    @RequestMapping("/sars/contact")
    public String addEsContact(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEsContact", idmListEsList.get(0));
            model.put("rowNum", rowNum);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.sars.esContact";
    }

    /**
     * SARS 发病后至住院前密切接触者:家庭、亲友
     */
    @RequestMapping("/sars/family")
    public String addEfcFamily(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcFamily = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfcFamily", idmListEfcFamily.get(0));
            model.put("rowNum", rowNum);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.sars.efcFamily";
    }

    /**
     * SARS 发病后至住院前密切接触者:工作单位或主要活动场所联系人
     */
    @RequestMapping("/sars/workOrg")
    public String addEfcWorkOrg(String trData, String type, String rowNum, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcWorkOrg = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfcWorkOrg", idmListEfcWorkOrg.get(0));
            model.put("rowNum", rowNum);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.sars.efcWorkOrg";
    }

    /**
     * 流行性、地方性斑疹伤寒个案调查表 密切接触者
     */
    @RequestMapping("/typhusFever/contacted")
    public String addContactedTyphusFever(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.typhusFever.contacted";
    }

    /**
     * 白喉个案调查表实验室检查
     */
    @RequestMapping("/diphtheria/exam")
    public String addExamDiphtheria(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListLe> idmListLeList = (List<ListLe>) json2Obj(trData, ListLe.class);
            model.put("idmListle", idmListLeList.get(0));
            model.put("rowNum", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.diphtheria.exam";
    }
    @RequestMapping("/diphtheria/contacted")
    public String addDiphtheriaContacted(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEfc> idmListEfcList = (List<ListEfc>) json2Obj(trData, ListEfc.class);
            model.put("idmListEfc", idmListEfcList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.diphtheria.contacted";
    }
    @RequestMapping("/diphtheria/contact")
    public String addDiphtheriaContact(String trData, String rowIndex, String type, ModelMap model, HttpServletRequest request) throws InstantiationException, IllegalAccessException {
        if (StringUtil.isNotEmpty(trData)) {
            List<ListEs> idmListEsList = (List<ListEs>) json2Obj(trData, ListEs.class);
            model.put("idmListEs", idmListEsList.get(0));
            model.put("rowIndex", rowIndex);
        }
        if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
            model.put("type", type);
        } else {
            model.put("type", "add");
        }
        return "rhip.idm.case.diphtheria.contact";
    }
    
    /**
     * 创建个案审核记录信息
     * @param status 操作类型
     * @param unitCode 审核机构代码
     * @param user
     * @param idmId 上报传染病的IdmReport.Id
     * @param backToUnit 退回单位
     */ 
    private void createApprovalInfo(String status, String unitCode , User user, Long idmId, String backToUnit){
    	//status=1 审核通过； status=2退回
    	CaseApprovalInfo caseApprovalInfo= new CaseApprovalInfo();
     	caseApprovalInfo.setApprovalDate(new Date());
     	caseApprovalInfo.setIdmId(idmId);
     	caseApprovalInfo.setOperateType(status);
     	caseApprovalInfo.setUnitCode(unitCode);
     	caseApprovalInfo.setUserId(user.getStaffCode());
     	caseApprovalInfo.setUserName(user.getName());   
    	if("2".equals(status)){
    		caseApprovalInfo.setBackToUnit(backToUnit);
    	}
    	caseSurveyService.createApprovalInfo(caseApprovalInfo);
    }
    
    private void setRoleAttribute(ModelMap model, HttpServletRequest request){
    	 if (hasRole(RoleType.ZXCRB, request)) {
             model.addAttribute("ROLE", RoleType.ZXCRB.getValue());
         }
         if (hasRole(RoleType.YYCRB, request)) {
             model.addAttribute("ROLE", RoleType.YYCRB.getValue());
         }
         if (hasRole(RoleType.ZCRB, request)) {
             model.addAttribute("ROLE", RoleType.ZCRB.getValue());
         }
         if (hasRole(RoleType.JKFYK, request)) {
             model.addAttribute("ROLE", RoleType.JKFYK.getValue());
         }
    }
    
    private void setCaseInfo(CaseInformation caseInformation, HttpServletRequest request){
   	    Organization org = getCurrentOrg(request);
        String currentOrgName = org.getOrganName();
        caseInformation.setSurveyOrgName(currentOrgName);
        caseInformation.setSurveyDate(new Date());
        String userId = getCurrentUser(request).getUserCode();
        caseInformation.setModifyRespondents(userId);
        caseInformation.setModifySurveyOrg(org.getOrganCode());
        caseInformation.setModifySurveyDate(new Date());
        caseInformation.setCaseFillPerson(userId);
        caseInformation.setCaseFillDate(new Date());
        caseInformation.setRespondents(userId);
        caseInformation.setSurveyOrg(org.getOrganCode());
        caseInformation.setCaseFillOrg(org.getOrganCode());
        caseInformation.setAuditor(userId);
   }
    
    private void setLabExamInfo(CaseDto caseDto, ReportDto reportDto){
    	LabExamine labExamine = new LabExamine();
        if(ObjectUtil.isNotEmpty(caseDto.getLabExamine())){
        	labExamine = caseDto.getLabExamine();
        }
        if(ObjectUtil.isNotEmpty(reportDto.getReportDesc())){
        	if(ObjectUtil.isNotEmpty(reportDto.getReportDesc().getHbvSign())){
        		 labExamine.setHbvSign(reportDto.getReportDesc().getHbvSign());
        	}
        	if(ObjectUtil.isNotEmpty(reportDto.getReportDesc().getHbsagPositiveDt())){
        		labExamine.setHbsagPositiveDt(reportDto.getReportDesc().getHbsagPositiveDt());
	       	}
        	if(ObjectUtil.isNotEmpty(reportDto.getReportDesc().getHbvSignDt())){
	       		 labExamine.setHbvSignDt(reportDto.getReportDesc().getHbvSignDt());
	       	}
        	if(ObjectUtil.isNotEmpty(reportDto.getReportDesc().getHbcCheckResult())){
	       		 labExamine.setHbcCheckResult(reportDto.getReportDesc().getHbcCheckResult());
	       	}
        	if(ObjectUtil.isNotEmpty(reportDto.getReportDesc().getPunctureCheckResult())){
	       		 labExamine.setPunctureCheckResult(reportDto.getReportDesc().getPunctureCheckResult());
	       	}
            caseDto.setLabExamine(labExamine);
        }  
    }
    
    private void setAttackConditionInfo(CaseDto caseDto, ReportDto reportDto){
	    AttackCondition attackCondition = new AttackCondition();
	    if(ObjectUtil.isNotEmpty(caseDto.getAttackCondition())){
	    	attackCondition = caseDto.getAttackCondition();
	    }
	    //死亡日期
	    if(ObjectUtil.isNotEmpty(reportDto.getReport())){
	     	if(ObjectUtil.isNotEmpty(reportDto.getReport().getDeathDate())){
	     		attackCondition.setDieDt(reportDto.getReport().getDeathDate());
	       	}
	     	caseDto.setAttackCondition(attackCondition);
	    }
    }

    private CaseDto fillInReportData(IdmReport idmReport) {
        CaseDto caseDto = new CaseDto();
        GeneralCondition generalCondition = new GeneralCondition();
        AttackCondition attackCondition = new AttackCondition();
        CaseInformation caseInformation = new CaseInformation();
        OtherCondition otherCondition = new OtherCondition();
        //本人姓名
        generalCondition.setName(idmReport.getName());
        //家长或监护人姓名
        generalCondition.setParentsName(idmReport.getParentsName());
        //身份证件号码
        generalCondition.setIdcard(idmReport.getIdcard());
        //性别
        generalCondition.setGender(idmReport.getGender());
        //出生日期
        generalCondition.setBirthday(idmReport.getBirthday());
        //年龄
        if (StringUtil.isNotEmpty(idmReport.getAge())) {
            generalCondition.setAge(idmReport.getAge());
        }
        //年龄单位
        generalCondition.setAgeUnit(idmReport.getAgeUnit());
        //工作或学习单位
        generalCondition.setUnitName(idmReport.getUnitName());
        //职业
        generalCondition.setOccupation(idmReport.getOccupation());
        //职业-其他
        generalCondition.setOccupationOther(idmReport.getOccupationOther());
        //联系电话
        generalCondition.setPhoneNumber(idmReport.getPhoneNumber());
        //现居住地乡街道
        generalCondition.setPatownShip(idmReport.getPatownShip());
        //现住址小组地址
        generalCondition.setPaGroup(idmReport.getPaGroup());
        //现居住地村社区
        generalCondition.setPastreet(idmReport.getPastreet());
        //现居住地详细
        generalCondition.setPahouseNumber(idmReport.getPahouseNumber());
      //户籍乡街道
        generalCondition.setHrtownShip(idmReport.getHrtownShip());
        //户籍村社区
        generalCondition.setHrstreet(idmReport.getHrstreet());
        //户籍小组地址
        generalCondition.setHrGroup(idmReport.getHrGroup());
        //户籍地详细
        generalCondition.setHrhouseNumber(idmReport.getHrhouseNumber());
        //户籍地址-详细地址
        generalCondition.setHrAddress(idmReport.getHrAddress());
        /*病人属于*/
        generalCondition.setPatientAttribute(idmReport.getInfectedpersonBelong());
        generalCondition.setFloatPopulation(idmReport.getInfectedpersonBelong());
        //现住址
        generalCondition.setAddrType(idmReport.getInfectedpersonBelong());
        //婚姻
        if (StringUtil.isNotEmpty(idmReport.getMarriage())) {
            generalCondition.setMarriage(idmReport.getMarriage());
        }
        //患者文化程度
        if (StringUtil.isNotEmpty(idmReport.getNation())) {
            generalCondition.setNation(idmReport.getNation());
        } 
        //年龄
        if (StringUtil.isNotEmpty(idmReport.getEducation())) {
            generalCondition.setEducation(idmReport.getEducation());
        }
        //上报时间(填报日期)      ？？？？？？
//        attackCondition.setReportTime(idmReport.getFillDate());
        //发病日期
        attackCondition.setPathogenesisDate(idmReport.getPathogenesisDate());
        //确诊日期
        attackCondition.setConfirmationDate(idmReport.getDiagnosisDate());
        //死亡日期
        attackCondition.setDieDt(idmReport.getDeathDate());
        //
        attackCondition.setRemarks(idmReport.getComments());
        //报告卡卡片编号
        caseInformation.setCaseNo(idmReport.getRecordNumber());
        //传染病名称
        caseInformation.setReportDiseases(idmReport.getInfectiousName());
        //填卡医生
        caseInformation.setSurveyName(idmReport.getReportDoctorName());
        //报告种类
        caseInformation.setReportType(idmReport.getReportCardTypeCode());
        //上报时间(填报日期)
        caseInformation.setReportDate(idmReport.getFillDate());
        //上报人名称（外部报卡没有医生id）
        if(!ObjectUtil.isNullOrEmpty(idmReport.getReportDoctorId())){
            caseInformation.setReportPerson(idmReport.getReportDoctorId());
        }
        //上报单位
        caseInformation.setReportOrg(idmReport.getFillOrganCode());
        //病例分类
        otherCondition.setCaseType(idmReport.getCaseCategory());
        caseDto.setGeneralCondition(generalCondition);
        caseDto.setAttackCondition(attackCondition);
        caseDto.setCaseInformation(caseInformation);
        caseDto.setOtherCondition(otherCondition);

        return caseDto;
    }

    private Date formatTimeWithHour(Date date, Integer hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, hour);
        return calendar.getTime();
    }

    private Date formatTimeHM(Date date, String hm) {
        String dateStr = DateUtil.getDateTime("yyyy/MM/dd", date);
        dateStr = dateStr + " " + hm;
        return DateUtil.parseSimpleDate(dateStr, "yyyy/MM/dd HH:mm");
    }

    /**
     * 需要具体到小时的时间处理
     * @param date
     * @param hourStr
     * @return
     */
    private Date jointDateHour(Date date, String hourStr){
    	if (null != date && StringUtil.isNotEmpty(hourStr)) {
            Integer hour = Integer.parseInt(hourStr);
            return formatTimeWithHour(date, hour);
        }
    	return date;
    }
    
    /**
     * 需要具体到小时的时间处理
     *
     * @param caseDto
     * @return
     */
    private CaseDto prepareDate(CaseDto caseDto) {
        
        LabExamine labExamine = caseDto.getLabExamine();
        if (ObjectUtil.isNotEmpty(labExamine)) {
        	//报告时间具体到小时
            Date reportTime = labExamine.getReportTime();
            String reportHour = labExamine.getReportHour();
            if (null != reportTime && StringUtil.isNotEmpty(reportHour)) {
                Integer hour = Integer.parseInt(reportHour);
                labExamine.setReportTime(formatTimeWithHour(reportTime, hour));
            }
            //病人粪检情况 第五次时间
            labExamine.setStoolCollecttimeFive(jointDateHour(labExamine.getStoolCollecttimeFive(), labExamine.getStoolCollectHourFive()));
            //病人粪检情况 第四次时间
            labExamine.setStoolCollecttimeFour(jointDateHour(labExamine.getStoolCollecttimeFour(), labExamine.getStoolCollectHourFour()));
            //病人粪检情况 第三次时间
            labExamine.setStoolCollecttimeThree(jointDateHour(labExamine.getStoolCollecttimeThree(), labExamine.getStoolCollectHourThree()));
            //病人粪检情况 第二次时间
            labExamine.setStoolCollecttimeTwo(jointDateHour(labExamine.getStoolCollecttimeTwo(), labExamine.getStoolCollectHourTwo()));
            //病人粪检情况 第一次时间
            labExamine.setStoolCollecttimeOne(jointDateHour(labExamine.getStoolCollecttimeOne(), labExamine.getStoolCollectHourOne()));
        }
        //确诊时间具体到小时
        AttackCondition attackCondition = caseDto.getAttackCondition();
        if (ObjectUtil.isNotEmpty(attackCondition)) {
            Date confirmationDate = attackCondition.getConfirmationDate();
            String confirmationHour = attackCondition.getConfirmationHour();
            if (null != confirmationDate && StringUtil.isNotEmpty(confirmationHour)) {
                Integer hour = Integer.parseInt(confirmationHour);
                attackCondition.setConfirmationDate(formatTimeWithHour(confirmationDate, hour));
            }
            //发病日期
            Date pathogenesisDate = attackCondition.getPathogenesisDate();
            String pathogenesisHour = attackCondition.getPathogenesisHour();
            if (null != pathogenesisDate && StringUtil.isNotEmpty(pathogenesisHour)) {
                Integer hour = Integer.parseInt(pathogenesisHour);
                attackCondition.setPathogenesisDate(formatTimeWithHour(pathogenesisDate, hour));
            }
            //首诊时间
            Date firstVisitDate = attackCondition.getFirstVisitDate();
            String firstVisitHour = attackCondition.getFirstVisitHour();
            if (null != firstVisitDate && StringUtil.isNotEmpty(firstVisitHour)) {
                Integer hour = Integer.parseInt(firstVisitHour);
                attackCondition.setFirstVisitDate(formatTimeWithHour(firstVisitDate, hour));
            }
        }
        
        BeforeDiseaseDiet bfeforeDiseaseDiet = caseDto.getBeforeDiseaseDiet();
        if (ObjectUtil.isNotEmpty(bfeforeDiseaseDiet)) {
        	//最近就餐时间具体到小时
            Date eatTime = bfeforeDiseaseDiet.getEatTime();
            String eatTimeHour = bfeforeDiseaseDiet.getEatTimeHour();
            if (null != eatTime && StringUtil.isNotEmpty(eatTimeHour)) {
                Integer hour = Integer.parseInt(eatTimeHour);
                bfeforeDiseaseDiet.setEatTime(formatTimeWithHour(eatTime, hour));
            }
            // 同餐日期
            bfeforeDiseaseDiet.setDinnerDate(jointDateHour(bfeforeDiseaseDiet.getDinnerDate(), bfeforeDiseaseDiet.getDinnerHour()));
        }

        //发现时间/网络直报时间具体到时分秒
        CaseInformation caseInformation = caseDto.getCaseInformation();
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            Date discoveryDate = caseInformation.getDiscoveryDate();
            String discoveryDateHM = caseInformation.getDiscoveryDateHM();
            if (null != discoveryDate && StringUtil.isNotEmpty(discoveryDateHM)) {
                caseInformation.setDiscoveryDate(formatTimeHM(discoveryDate, discoveryDateHM));
            }
            Date directReportDate = caseInformation.getDirectReportDate();
            String directReportDateHm = caseInformation.getDirectReportDateHM();
            if (null != directReportDate && StringUtil.isNotEmpty(directReportDateHm)) {
                caseInformation.setDirectReportDate(formatTimeHM(directReportDate, directReportDateHm));
            }
            Date reportDate = caseInformation.getReportDate();
            String reportDateHm = caseInformation.getReportDateHM();
            if (null != reportDate && StringUtil.isNotEmpty(reportDateHm)) {
            	Integer hour = Integer.parseInt(reportDateHm);
                caseInformation.setReportDate(formatTimeWithHour(reportDate, hour));
            }
        }

        InfectionSourceRoute infectionSourceRoute = caseDto.getInfectionSourceRoute();
        if (ObjectUtil.isNotEmpty(infectionSourceRoute)) {
        	//接触时间
        	infectionSourceRoute.setContactSimilerPatientDt(jointDateHour(infectionSourceRoute.getContactSimilerPatientDt(), infectionSourceRoute.getContactSimilerPatientHour()));
        }
        
        EpidemicFocusClose epidemicFocusClose = caseDto.getEpidemicFocusClose();
        if (ObjectUtil.isNotEmpty(epidemicFocusClose)) {
        	//县级疾控接到报告时间
        	epidemicFocusClose.setDiseaseReportDate(jointDateHour(epidemicFocusClose.getDiseaseReportDate(), epidemicFocusClose.getDiseaseReportHour()));
            //县级疾控到达现场时间
        	epidemicFocusClose.setDiseaseSceneDate(jointDateHour(epidemicFocusClose.getDiseaseSceneDate(), epidemicFocusClose.getDiseaseSceneHour()));
            //解除时间
        	epidemicFocusClose.setRemoveDate(jointDateHour(epidemicFocusClose.getRemoveDate(), epidemicFocusClose.getRemoveHour()));
            //终末消毒时间
        	epidemicFocusClose.setTermSterTime(jointDateHour(epidemicFocusClose.getTermSterTime(), epidemicFocusClose.getTermSterHour()));
        }
        
        ExposureHistory exposureHistory = caseDto.getExposureHistory();
        if (ObjectUtil.isNotEmpty(exposureHistory)) {
        	//暴露日期
        	exposureHistory.setExposureDt(jointDateHour(exposureHistory.getExposureDt(), exposureHistory.getExposureHour()));
            //处理时间
        	exposureHistory.setHandlingTime(jointDateHour(exposureHistory.getHandlingTime(), exposureHistory.getHandlingHour()));
            //首针时间
        	exposureHistory.setRabiesVaccinationDtF(jointDateHour(exposureHistory.getRabiesVaccinationDtF(), exposureHistory.getRabiesVaccinationHourF()));
        }
       
        return caseDto;
    }

    /**
     * 子表数据处理
     *
     * @param caseDto
     * @return
     */
    private CaseDto getListData(CaseDto caseDto) throws InstantiationException, IllegalAccessException {
        // 添加患者接触史、病例密切接触者
        String efcList = caseDto.getEfcList();
        if (StringUtil.isNotEmpty(efcList)) {
            List<ListEfc> idmListEfc = (List<ListEfc>) json2Obj(efcList, ListEfc.class);
            caseDto.setIdmListEfcList(idmListEfc);
        }
        /*添加消毒情况*/
        String disinfectList = caseDto.getDisinfectList();
        if (StringUtil.isNotEmpty(disinfectList)) {
            List<ListEfc> idmDisinfectList = (List<ListEfc>) json2Obj(disinfectList, ListEfc.class);
            caseDto.setIdmDisinfectList(idmDisinfectList);
        }
        /*发病前两周内接触动物*/
        String esAnimalList = caseDto.getEsAnimalList();
        if (StringUtil.isNotEmpty(esAnimalList)) {
            List<ListEs> idmEsAnimalList = (List<ListEs>) json2Obj(esAnimalList, ListEs.class);
            caseDto.setIdmListEsAnimal(idmEsAnimalList);
        }
        /*发病前一周内逐日活动情况esActivityList*/
        String esActivityList = caseDto.getEsActivityList();
        if (StringUtil.isNotEmpty(esActivityList)) {
            List<ListEs> idmEsActivityList = (List<ListEs>) json2Obj(esActivityList, ListEs.class);
            caseDto.setIdmListEsActivity(idmEsActivityList);
        }
        /*发病后至隔离治疗前逐日活动情况*/
        String esLeaveList = caseDto.getEsLeaveList();
        if (StringUtil.isNotEmpty(esLeaveList)) {
            List<ListEs> idmEsLeaveActivityList = (List<ListEs>) json2Obj(esLeaveList, ListEs.class);
            caseDto.setIdmListEsLeave(idmEsLeaveActivityList);
        }

        /*发病前2周内是否接触过非典病人或/和疑似非典患者*/
        String esContactList = caseDto.getEsContactList();
        if (StringUtil.isNotEmpty(esContactList)) {
            List<ListEs> idmEsContactList = (List<ListEs>) json2Obj(esContactList, ListEs.class);
            caseDto.setIdmListEsContact(idmEsContactList);
        }

        /*家庭、亲友*/
        String efcFamilyList = caseDto.getEfcFamilyList();
        if (StringUtil.isNotEmpty(efcFamilyList)) {
            List<ListEfc> idmEfcFamilyList = (List<ListEfc>) json2Obj(efcFamilyList, ListEfc.class);
            caseDto.setIdmListEfcFamily(idmEfcFamilyList);
        }

        /*工作单位或主要活动场所联系人者*/
        String efcWorkOrgList = caseDto.getEfcWorkOrgList();
        if (StringUtil.isNotEmpty(efcWorkOrgList)) {
            List<ListEfc> idmEfcWorkOrgList = (List<ListEfc>) json2Obj(efcWorkOrgList, ListEfc.class);
            caseDto.setIdmListEfcWorkOrg(idmEfcWorkOrgList);
        }

        // 添加流行性病学
        String esList = caseDto.getEsList();
        if (StringUtil.isNotEmpty(esList)) {
            List<ListEs> idmListEs = (List<ListEs>) json2Obj(esList, ListEs.class);
            caseDto.setIdmListEsList(idmListEs);
        }
        //实验室检查
        String leList = caseDto.getLeList();
        if (StringUtil.isNotEmpty(leList)) {
            List<ListLe> idmListLe = (List<ListLe>) json2Obj(leList, ListLe.class);
            caseDto.setIdmListLeList(idmListLe);
        }
        //食谱
        String bddList = caseDto.getBddList();
        if (StringUtil.isNotEmpty(bddList)) {
            List<ListBdd> idmListBdd = (List<ListBdd>) json2Obj(bddList, ListBdd.class);
            caseDto.setIdmListBddList(idmListBdd);
        }
        /*发病情况*/
        String acList = caseDto.getAcList();
        if (StringUtil.isNotEmpty(acList)) {
            List<ListAc> idmListAc = (List<ListAc>) json2Obj(acList, ListAc.class);
            caseDto.setIdmListAcList(idmListAc);
        }
        //暴露史
        String ehList = caseDto.getEhList();
        if (StringUtil.isNotEmpty(ehList)) {
            List<ListEh> idmListEh = (List<ListEh>) json2Obj(ehList, ListEh.class);
            caseDto.setIdmListEhList(idmListEh);
        }

        //卫生条件
        String hcList = caseDto.getHcList();
        if (StringUtil.isNotEmpty(hcList)) {
            List<ListHc> idmListHc = (List<ListHc>) json2Obj(hcList, ListHc.class);
            caseDto.setIdmListHcList(idmListHc);
        }
        return caseDto;
    }

    /**
     * 设置caseInformation
     *
     * @param caseDto
     * @param request
     * @return
     */
    private CaseDto setCaseInfo(CaseDto caseDto, HttpServletRequest request, String model) {
        CaseInformation caseInformation = caseDto.getCaseInformation();
        Organization org = getCurrentOrg(request);
        String currentOrgCode = org.getOrganCode();
        String userCode = getCurrentUser(request).getUserCode();
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            if ("add".equals(model)) {
                caseInformation.setSurveyOrg(currentOrgCode);
                caseInformation.setRespondents(userCode);
                caseInformation.setAuditor(userCode);
            } 
            if(StringUtil.isEmpty(caseInformation.getModifySurveyOrg())){
            	caseInformation.setModifySurveyOrg(currentOrgCode);
            }
            
            caseInformation.setModifyRespondents(userCode);
//            caseInformation.setModifySurveyDate(new Date());
            caseInformation.setCaseFillOrg(currentOrgCode);
            caseInformation.setCaseFillPerson(userCode);

        }
        return caseDto;
    }

    /**
     * 查询已审核的报卡
     * @param form
     * @param orgCode
     * @return
     */
//    private Criteria getCriteria(ReportQueryForm form, String orgCode) {
//        Criteria criteria1 = form.getCriteria();
//        Criteria criteria2 = form.getCriteria();
//        List<String> infectiousCodes = getInfectiousCodes(orgCode);
//        //报卡状态是已审核 其防疫科将其传染病分给该用户
//        criteria1.add("INFECTIOUS_CODE", OP.IN, infectiousCodes);
////        criteria1.add("REPORT_STATUS", ReportStatus.HOSPITAL_VERIFY.getValue());
//        Criteria ca = new Criteria("CURRENT_UNIT", OP.EQ, orgCode);
//        Criteria ca1 = new Criteria("fillOrganCode", OP.EQ, orgCode);
//        ca.add(LOP.OR, ca1);
//        criteria1.add(ca);
////        criteria1.add("CURRENT_UNIT", orgCode);
//
//        //报卡是当前用户填写且其状态不是已审核
////        criteria2.add("fill_organ_code", orgCode);
//
////        return criteria1.add(LOP.OR, criteria2);
//        return criteria1;
//    }

    /**
     * 根据当前用户的code和当前年份 从idm_setup表中获取当前用户所需管辖的个案
     * @return
     */
//    private List<String> getInfectiousCodes(String orgCode) {
//        List<String> infectiousCodes = new ArrayList<String>();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//
//        Criteria criteria = new Criteria("SET_YEAR",calendar.get(Calendar.YEAR));
//        criteria.add("CASE_ORGAN_CODE", orgCode);
//        List<String> notHandleCodes = new ArrayList<String>(specialInfectiousCodes);
//        notHandleCodes.add("2035");
//        notHandleCodes.add("202");
//        criteria.add("INFECTIOUS_CODE",OP.NOTIN,notHandleCodes);
//        List<IdmSetup> idmSetupList = setupService.findSetup(criteria);
//        if(ObjectUtil.isNotEmpty(idmSetupList)) {
//            for(IdmSetup idmSetup : idmSetupList) {
//                infectiousCodes.add(idmSetup.getInfectiousCode());
//            }
//        }
//        return infectiousCodes;
//    }

    /**
     * 循环遍历所有报卡，设置是否有审批权限
     *
     * @param request
     * @param pList
     * @return
     */
//    private PageList<IdmReport> getCaseList(HttpServletRequest request,PageList<IdmReport> pList, String orgCode){
//        List<IdmReport> list = pList.getList();
//        List<String> infectiousCodes = getInfectiousCodes(orgCode);
//        boolean isRole = hasRole(RoleType.JKFYK, request);
//        if(ObjectUtil.isNotEmpty(list)) {
//            for(IdmReport dc : list) {
//                Integer reportStatus = dc.getReportStatus();
//				/*五个专项的传染病code和不作处理的code(肝炎，艾滋病)*/
//                if(specialInfectiousCodes.contains(dc.getInfectiousCode())) {
//					/* 4：不处理*/
//                    if(ObjectUtil.equals(dc.getInfectiousCode(), "2035") || ObjectUtil.equals(dc.getInfectiousCode(), "202")) {
//                        dc.setIsOperate(4);
//                    } else {
//						/*3：专项 */
//                        dc.setIsOperate(3);
//                    }
//                }
//            }
//        }
//        return pList;
//    }

    /*五个专项的传染病code和不作处理的code(肝炎，艾滋病)*/
    public static List<String> specialInfectiousCodes = new ArrayList<String>(Arrays.asList("2141", "2142", "2143", "2144", "2035", "202", "2261",
            "2262", "2263", "225", "305", "309"));

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

    @RequestMapping("/initPrint")
    public String initEdit(String idmId, String infectiousCode, ModelMap model) throws Exception {
        CaseDto caseDto = caseSurveyService.getCaseSurvey(idmId);
        //个案状态：已填写
        caseDto.setCaseStatus("2");
        model.addAttribute("caseDto", caseDto);
        model.addAttribute("isPrint", 1);
        return CaseLayoutMap.getPrintStr(infectiousCode);
    }
    
    /**
	 * 个案手动分配
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/assign")
	public String assign(Integer id, HttpServletRequest request, ModelMap model, String pageIndex){
		/*IdmStatusInfo new IdmStatusInfo()*/
		model.addAttribute("id", id);          
        model.addAttribute("statusInfo", new IdmStatusInfo());
        return "rhip.idm.case.assign";
	} 
	
	/**
	 * 保存个案分配
	 *
	 * @param 
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveAssign")
	@ResponseBody
	public Map<String, Object> saveAssign(IdmStatusInfo statusInfo, Integer id, String type, HttpServletRequest request) {
		ReportDto reportDto = reportService.getReport(id) ;
		IdmReport reportInfo = reportDto.getReport();
		EventInfo eventInfo = eventInfoDao.get(new Criteria("ID", reportInfo.getIdmId()));
        IdmStatusInfo curStatusInfo = idmStatusInfoDao.get(eventInfo.getStatusId());//当前状态表
        CaseOperateLog opLog = new CaseOperateLog();
        opLog.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
        opLog.setAssignUnit(curStatusInfo.getCurrentUnit());//分配机构=当前管理机构
 		opLog.setIdmId(reportInfo.getIdmId());
 		opLog.setPersonId(reportInfo.getPersonId());
 		opLog.setCreateUserCode(getCurrentUser(request).getUserCode());
 		opLog.setCreateDate(new Date());
 		opLog.setInfectiousCode(reportInfo.getInfectiousCode());
		//type: 0-分配；1-纳入
		if("0".equals(type)){
			curStatusInfo.setAssignmentStatus(AssignmentStatus.ASSIGNING.getValue().toString());
			curStatusInfo.setAssignedToUnit(statusInfo.getAssignedToUnit());
			opLog.setReceivingUnit(statusInfo.getAssignedToUnit());	
 			opLog.setOperateType("1");//分配
		}else {
			//2017-5-4 纳入时，当前管理机构为分配至机构（当前机构），分配至机构清空
			/*curStatusInfo.setAssignmentStatus(AssignmentStatus.ASSIGNED.getValue().toString());
			curStatusInfo.setCurrentUnit("");*/
			curStatusInfo.setAssignmentStatus(AssignmentStatus.ASSIGNED.getValue().toString());
			curStatusInfo.setCurrentUnit(getCurrentOrg(request).getOrganCode());
			
	 		opLog.setReceivingUnit(getCurrentOrg(request).getOrganCode());	
 			opLog.setOperateType("2");//纳入
		}

		int ret = caseSurveyService.assignCase(opLog, curStatusInfo);
		Map<String, Object> map = new HashMap<>();
		map.put("result", ret > 0 ? true : false);
		map.put("message", ret > 0 ? "操作成功!" : "分配失败！请确认被分配机构是否有该病的处置填写权限！");
		return  map;
	}
	
	/**
	 * 初始化报表可配置列
	 * @param form
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/exportIndex")
	public String initExport(ReportQueryForm form, HttpServletRequest request, ModelMap model){
        Map<String ,Object> columnCNs = new HashMap<String ,Object>();
        for(Object key :  properties.keySet()){
        	columnCNs.put((String) key, properties.getProperty((String) key));
        }
        model.addAttribute("columnCNs", columnCNs);	
        model.addAttribute("searchForm", form);	
		return "rhip.idm.case.exportIndex";
	}
	
	/**
	 * 导出个案报表
	 * @param form
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/exportTable")
	public String exportTable(ReportQueryForm form , HttpServletRequest request, HttpServletResponse response, ModelMap model){
		String colNamesStr= form.getColumnName();
        String colNames = "";
        Map<String, Object> cloumnMap = new HashMap<>();
		if (StringUtil.isNotEmpty(colNamesStr)) {
			String[] columns = colNamesStr.split(",");
			if (columns.length > 0) {
				for (String col : columns) {
					colNames = colNames + " &nbsp; &nbsp;" + properties.getProperty(col);
					cloumnMap.put(col, properties.getProperty(col));
				}
			}
		}
        Criteria ca = null;
        String orgCode = getCurrentOrg(request).getOrganCode();
        ca = form.getCriteria();
        List<String> orgStr = new ArrayList<String>();
        Criteria crF  = new Criteria();
        List<String> itemCodes = new ArrayList<String>();
        if(!hasRole(RoleType.JKFYK, request) && !hasRole(RoleType.ADMIN, request)){
        	
        	Criteria infectiousCa = new Criteria();
        	//2017-8-17需求修改：中心可见下属站
        	if(hasRole(RoleType.ZXCRB, request)){
        		Criteria criteria = new Criteria();
        		criteria.add("organCode", orgCode);
        		criteria.add(LOP.OR,"parentCode", orgCode);
        		List<Organization> orgs = organizationApp.queryOrganization(criteria);
        		for(Organization org: orgs){
        			orgStr.add(org.getOrganCode());        		
        		}
        		infectiousCa = new Criteria("caseOrganCode", OP.IN, orgStr);
        		crF.add("CURRENT_UNIT", OP.IN, orgStr);
        		crF.add(LOP.OR, "ASSIGNED_TO_UNIT", OP.IN, orgStr);
        	}else{
        		//医院、站 只显示分配给自己的个案
        		infectiousCa = new Criteria("caseOrganCode", getCurrentOrg(request).getOrganCode());
        		crF.add("CURRENT_UNIT",  orgCode);
             	crF.add(LOP.OR, "ASSIGNED_TO_UNIT", orgCode);
        	}
     	    List<IdmSetup> setups = setupService.findDistinctInfectiousCodes(infectiousCa);
     	    //只查询有个案填报页面的的疾病 屏蔽未设个案的传染病
     	    for(IdmSetup setup : setups){
	 	    	if(!ObjectUtil.isNullOrEmpty(CaseLayoutMap.getLayoutStr(setup.getInfectiousCode()))){
	 	    		itemCodes.add(setup.getInfectiousCode()); 
	        	}
    	    }                 
         	ca.add(crF); 
        }else{
        	//只查询有个案填报页面的的疾病 屏蔽未设个案的传染病--疾控，查看全部有个案的疾病
            List<DicItem> dicItems = dictionaryApp.queryDicItem(new Criteria("dicCode","CV0501017"));
		 	   for(DicItem dicItem: dicItems){
		 		  if(!ObjectUtil.isNullOrEmpty(CaseLayoutMap.getLayoutStr(dicItem.getItemCode()))){
			    		itemCodes.add(dicItem.getItemCode()); 
		      	  }    
		 	}
        }
        ca.add("INFECTIOUS_CODE", OP.IN, itemCodes);
        ca.add("REPORT_STATUS", ReportStatus.HOSPITAL_VERIFY.getValue());
        List<IdmReport> plist = reportService.findReportTable(ca);
        transformColumns(plist);
        createOperationLog(request, RhipModuleName.IDM, "个案报表", OperationName.EXP);
        model.addAttribute("reports", plist);
		model.addAttribute("colNames", colNames);
		model.addAttribute("cloumnMap", cloumnMap);
		return "rhip.idm.case.exportList";
	}

	private void  transformColumns( List<IdmReport> plist){
		
	    Organization org = new Organization();
	       
		for(IdmReport report : plist){
			Map<String, String> dictMap = dictionaryApp.queryDicItemMap("GBT226112003");
			report.setGender(StringUtil.isNotEmpty(report.getGender())?dictMap.get(report.getGender()) : "");//性别
			//状态
			switch (report.getCaseStatus()){
			case "1":
				report.setCaseStatus("未填写");
				break;
			case "2":
				report.setCaseStatus("待审核");
				break;
			case "3":
				report.setCaseStatus("已审核");
				break;
			default :
				report.setCaseStatus("");
				break;	
			}
			if(ObjectUtil.isNotEmpty(report.getModifySurveyOrg())){
				org = organizationApp.queryOrgan(report.getModifySurveyOrg());
				report.setModifySurveyOrg(ObjectUtil.isNotEmpty(org)? org.getOrganName() :"");
			}
			if(ObjectUtil.isNotEmpty(report.getFillDate())){
				report.setFillDateDesc(DateUtil.toDateString(report.getFillDate(), "yyyy/MM/dd"));
			}

		}
	}
	
	@RequestMapping("/statisticsSearch")
	public String statisticsSearch(HttpServletRequest request, Model model){
		String url = "rhip.idm.case.statisticsSearch";
		/*String orgCode = getCurrentOrg(request).getOrganCode();
		model.addAttribute("", orgCode);*/
		initOrg(request, model);
		return url;
	}
	
	@RequestMapping("/statisticsList")
	public String statistics(TargetOrgQueryForm queryForm, HttpServletRequest request, ModelMap model){
		String url = "rhip.idm.case.statisticsList";
		List<Map<String, Object>> mapList = caseSurveyService.getCaseStatisticsMapList(queryForm.getParamMap());
		/*model.addAttribute("genreCode", queryForm.getGenreCode());*/
		model.addAttribute("results", mapList);
		return url;
	}
	
	
	/**
     * 进入个案查重页面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/repeatSearch")
    public String repeatSearch(HttpServletRequest request, ModelMap model) {
        /*boolean bAllOrg = false;
		//根据当前机构，设置页面中的上报机构
        Organization org = getCurrentOrg(request);
        String currentOrgCode = org.getOrganCode();

		//防疫科显示所有机构数据
        if (hasRole(RoleType.JKFYK, request)){
            bAllOrg = true;
        }
        if(!bAllOrg){
            model.addAttribute("fillOrganCode", currentOrgCode);
            model.addAttribute("currentOrgCode", currentOrgCode);
        }*/
    	/*boolean bAllOrg = true;*/
        model.addAttribute("logoff", "0");
        /*model.addAttribute("tab", "case");*/
        return "rhip.idm.case.repeatSearch";
    }

    /**
     * 查重报卡信息列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/repeatList")
    public String repeatCaseList(ReportQueryForm form, HttpServletRequest request, ModelMap model) {
        String url = "rhip.idm.case.repeatList";
        PageList<IdmReport> plist = new PageList<>();
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = null;
        String orgCode = getCurrentOrg(request).getOrganCode();

        ca = form.getCriteria();
       /* if(!ObjectUtil.isNotEmpty(ca.get("infectiousCode"))){
        	//艾滋病个案只有疾控可见
            if(hasRole(RoleType.JKFYK,request)){
            	caseCodes.add("202");
            }
            ca.add("INFECTIOUS_CODE", OP.IN,  caseCodes);
        }*/

       /* if(hasRole(RoleType.SQZ, request)){    
        	//个案 只查询登录机构所管理的个案
        	Criteria crF  = new Criteria("CURRENT_UNIT",  orgCode);
        	crF.add(LOP.OR, "ASSIGNED_TO_UNIT", orgCode);
        	ca.add(crF);
        }
        if(hasRole(RoleType.ZXCRB, request)){
        	if(StringUtil.isNotEmpty(form.getSurveyOrgCode())){
        		//个案 只查询登录机构所管理的个案
            	Criteria crF  = new Criteria("CURRENT_UNIT",  orgCode);
            	crF.add(LOP.OR, "ASSIGNED_TO_UNIT", orgCode);
            	ca.add(crF);
        	}
        	
        }*/
          
        if(!hasRole(RoleType.JKFYK, request) && !hasRole(RoleType.ADMIN, request)){
        	//查询各机构限制的疾病
        	Criteria infectiousCa = new Criteria("caseOrganCode",getCurrentOrg(request).getOrganCode());
            //infectiousCa.add("setYear", OP.EQ, DateUtil.getCurrentYear());
     	    List<IdmSetup> setups = setupService.findDistinctInfectiousCodes(infectiousCa);
     	    List<String> itemCodes = new ArrayList<String>();
     	    for(IdmSetup setup : setups){
     	    	itemCodes.add(setup.getInfectiousCode()); 
    	    }
     		ca.add("INFECTIOUS_CODE", OP.IN, itemCodes);
            //中心、医院、站 只显示分配给自己的个案
            Criteria crF  = new Criteria("CURRENT_UNIT",  orgCode);
         	crF.add(LOP.OR, "ASSIGNED_TO_UNIT", orgCode);
         	ca.add(crF);
        }
       
        ca.add("INFECTIOUS_CODE", OP.NOTIN, notCaseCodes);
        
        ca.add("REPORT_STATUS", ReportStatus.HOSPITAL_VERIFY.getValue());
        //ca.add("VALID_CASE_STATUS", OP.NE , "0");
        String repeatConditions = form.getRepeatConditions();
        if(StringUtil.isNullOrEmpty(repeatConditions)){
        	repeatConditions = "infectious_Code";
        }else{
        	repeatConditions = repeatConditions + ",infectious_Code";
        }
        plist = reportService.getRepeatCasesList(ca, page, repeatConditions);

        model.addAttribute("reports", plist);
        model.addAttribute("page", plist.getPage());
        model.addAttribute("tab", "case");
        model.addAttribute("currentOrgCode", orgCode);
        return url;
    }
    
    /**
	 * 进入导入画面-肠道旬报表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showAnorectaImport")
	public String showImport(ModelMap model, HttpServletRequest request) {
		return "rhip.idm.anorecta.import";
	}

	@RequestMapping("/downloadAnorectaTemplet")
	public void downloadStudentTemplet(HttpServletResponse response,String infectiousCode) throws Exception {
		ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/anorecta.xls"));
		setExcelContent(response, "园区肠道门诊旬报表导入模板.xls");
		excel.save(response.getOutputStream());
	}
    
	@RequestMapping("/uploadAnorecta")
//	@ResponseBody
	public void uploadContacted(HttpServletRequest request, @RequestParam("qqfile") MultipartFile file, Long idmId, HttpServletResponse response) {
		ModelMap model = new ModelMap();
		try {
			InputStream in = file.getInputStream();
			try {
				int count = 0;
				ExcelUtils excelUtils = new ExcelUtils(in);
				
				List<IdmAnorectaReportTable> dataList = readData(excelUtils);
				if (ObjectUtil.isNullOrEmpty(dataList)) {
					model.addAttribute("success", false);
					model.addAttribute("message", "导入肠道门诊旬报表数据为空");

                    response.setContentType("text/html");
                    String messageStr = "导入肠道门诊旬报表数据为空";
                    response.getWriter().write("{\"success\":\"false\",\"msg\":\"" + messageStr + "\"}");
				}
				
				initFullData(dataList, request);
				count = caseSurveyService.importAnorectaDatas(dataList);
				model.addAttribute("message", "总共导入"+dataList.size()+"条肠道门诊旬报表数据，成功"+count+"条，失败"+(dataList.size() - count)+"条");
				model.addAttribute("success", true);

                response.setContentType("text/html");
                String messageStr = "总共导入" + dataList.size() + "条肠道门诊旬报表数据，成功"+count+"条，失败"+(dataList.size() - count)+"条";
                response.getWriter().write("{\"success\":\"true\",\"msg\":\"" + messageStr + "\"}");

			} finally {
				in.close();
			}
		} catch (Exception e) {
			logger.error("导入肠道门诊旬报表数据出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
	}
	
	 /**
     * 导入肠道旬报表-导入数据初始化机构 人员字段
     * @param dataList
     * @param request
     * @return void
     */
	private void initFullData(List<IdmAnorectaReportTable> dataList, HttpServletRequest request) {
		Organization org = getCurrentOrg(request);
        String userId = getCurrentUser(request).getUserCode();
        
		for (IdmAnorectaReportTable art : dataList) {
			art.setFillOrganCode(org.getOrganCode());
			art.setFillTime(new Date());
			art.setFillUserCode(userId);
		}
	}

    /**
     * 导入肠道旬报表-读取数据
     * @param excelUtils
     * @return List<IdmAnorectaReportTable>
     */
	private List<IdmAnorectaReportTable> readData(ExcelUtils excelUtils) {
		for (int i = 0; i < 4; i++) {
			excelUtils.readLine();
		}
		List<IdmAnorectaReportTable> results = new ArrayList<IdmAnorectaReportTable>();
		while (excelUtils.hasNextLine()) {
			List<Object> line = excelUtils.readLine();
			if (!ExcelUtils.isEmptyLine(line)) {
				results.add(readLine(line));
			}
		}
		return results;
	}

    /**
     * 导入肠道旬报表-读取一行数据
     * @param line
     * @return IdmAnorectaReportTable
     */
	private IdmAnorectaReportTable readLine(List<Object> line) {
		IdmAnorectaReportTable art = new IdmAnorectaReportTable();
		if(ObjectUtil.isNotEmpty(line.get(0))){
			if(!ExcelUtils.getDateValue(line.get(0),"yyyy/MM/dd").after(new Date())){
				art.setReportDate(ExcelUtils.getDateValue(line.get(0),"yyyy/MM/dd"));
				art.setTsDiaRegNum(Integer.parseInt(ExcelUtils.getStringValue(line.get(1))));
				art.setViDiaRegNum(Integer.parseInt(ExcelUtils.getStringValue(line.get(2))));
				art.setStDiaRegNum(Integer.parseInt(ExcelUtils.getStringValue(line.get(3))));
				art.setRetrievalNum(Integer.parseInt(ExcelUtils.getStringValue(line.get(4))));
				art.setRetrievalRate(ExcelUtils.getStringValue(line.get(5)));
				art.setCholeraPosiO1(Integer.parseInt(ExcelUtils.getStringValue(line.get(6))));
				art.setCholeraPosiO139(Integer.parseInt(ExcelUtils.getStringValue(line.get(7))));
			}
		}
		return art;
	}
	    
    @RequestMapping(value="/invalid")
    @ResponseBody
    public Map<String, Object> invalid(String idmId){
    	Map<String, Object> map = new HashMap<>();
    	int ret = caseSurveyService.invalidCase(idmId);
    	map.put("result", ret > 0 ? true : false);
    	map.put("message", ret > 0 ? "操作成功!" : "操作失败!");
    	return map;
    }
    
	protected void initOrg(HttpServletRequest request, Model model) {
		Organization org = getCurrentOrg(request);
		model.addAttribute("orgCode",org.getOrganCode());
		/*if(hasRole(RoleType.JKFYK, request)){
			
		}*/
		if(hasRole(RoleType.ZXCRB, request)){
			model.addAttribute("superOrganCode",org.getOrganCode());			
		}
			
		//model.addAttribute("superOrganCode",org.getOrganCode());
		model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
		model.addAttribute("currentEndDate",new Date());
	}

}
