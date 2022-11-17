package com.founder.rhip.ech.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.service.IPhyExaminationService;
import com.founder.rhip.ech.controller.form.EchManageQueryForm;
import com.founder.rhip.ech.service.IEchManageService;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.ech.EchIdentificationOption;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.hm.controller.form.EchPersonInfoExcel;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

@Controller
@RequestMapping(value = "/ech/manage")
public class EchManageController extends BaseController {

	@Resource
	private IPhysicalExamRecordService physicalExamRecordService;

	@Resource(name = "echManageService")
	private IEchManageService echManageService;

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;

	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;

	@Resource(name = "platformService")
	private IPlatformService platformService;
	
	@Resource(name = "cdmPhyExaminationService")
	private IPhyExaminationService phyExaminationService;

	@RequestMapping("/search")
	public String search(ModelMap model) {
		model.addAttribute("currentYear", new Date());
		return "rhip.ech.manage.search";
	}
	/**
	 * 查询体检记录
	 * @param form
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public String search(EchManageQueryForm form, ModelMap model, HttpServletRequest request) {
		String searchTown = request.getParameter("searchTown");
		String searchCenter = request.getParameter("searchCenter");
		String searchOrg = request.getParameter("searchOrg");
		if(hasRole(RoleType.QWGZX,request) && StringUtil.isNullOrEmpty(searchTown)){
			searchTown = getCurrentOrg(request).getGbCode();
		}
		if(StringUtil.isNotEmpty(searchTown) && StringUtil.isNullOrEmpty(searchCenter)){
			form.setOrganCode(searchTown);
			form.setSelectCodeType("0");
		}
		if(StringUtil.isNotEmpty(searchCenter) && StringUtil.isNullOrEmpty(searchOrg)){
			form.setOrganCode(searchCenter);
			form.setSelectCodeType("B1");
		}
		if(StringUtil.isNotEmpty(searchOrg)){
			form.setOrganCode(searchOrg);
		}
		form.setLogoff("0");
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage); 
		Criteria criteria = initCriteria(form, request);
		 if(hasRole(RoleType.QWGZX, request)||hasRole(RoleType.ADMIN, request)){
			 
			for (int i = 0; i < criteria.getCriteria().size(); i++) {
				if("inputSuperOrganCode".equals(criteria.getCriteria().get(i).getName())==true){
					criteria.getCriteria().remove(criteria.getCriteria().get(i));
				}
			}
			List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode",form.getOrganCode())); 
			String[] orgs = new String[orgList.size()+1];
			for(int i=0; i<orgList.size(); i++) {
				orgs[i] = orgList.get(i).getOrganCode();
			}
			orgs[orgList.size()] = form.getOrganCode();
			
			if(orgList.size()>0){
				criteria.add("inputOrganCode", OP.IN, orgs);
			}
		}
		PageList<PhysicalExamRecord> list = physicalExamRecordService.getEchExamRecords(page, criteria);
		model.addAttribute("personInfos", list.getList());
		model.addAttribute("page", list.getPage());
		return "rhip.ech.manage.list";
	}

	/**
	 * 体质辨识列表
	 * 
	 * @param personId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/perEchList")
	public String perEchList(@RequestParam("personId") Long personId, HttpServletRequest request, ModelMap model) {
		Assert.notNull(personId, "人员id为空");
		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		PhysicalExamRecord record = physicalExamRecordService.getPhysicalExamRecord(new Criteria("personId", personId));
		model.put("record", record);
		model.addAttribute("personInfo", personInfo);
		return "rhip.ech.manage.perEchlist";
	}
	
	/**
	 * 体质辨识列表结果
	 * 
	 * @param personId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/perEchResult")
	public String perEchResult(@RequestParam("personId") Long personId, HttpServletRequest request, ModelMap model) {
		PhysicalExamRecord record = physicalExamRecordService.getPhysicalExamRecord(new Criteria("personId", personId));
		model.put("record", record);
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		
		Criteria criteria = new Criteria("personId", personId);
		PageList<EchIdentification> idens = echManageService.getPageList(page, criteria, new Order("CREATE_DATE DESC"));
		for(EchIdentification iden :idens.getList()){
			Criteria cri = new Criteria("personId", personId);
			cri.add("identificationId", iden.getId());
			cri.add("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
			List<ElderlyPhyExamination> exams = phyExaminationService.getElderlyPhyExaminations(cri, new Order("examination_date desc"), "examinationDate", "physicalExamCode");
			iden.setExams(exams);
		}
		model.addAttribute("echIdentifications", idens.getList());
		model.addAttribute("page", idens.getPage());
		return "rhip.ech.manage.perEchlistResult";
	}
	
	/**
	 * 导出体检记录
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/excel")
	public void exportPhysicalList(EchManageQueryForm form, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String searchTown = request.getParameter("searchTown");
		String searchCenter = request.getParameter("searchCenter");
		String searchOrg = request.getParameter("searchOrg");
		if(hasRole(RoleType.QWGZX,request) && StringUtil.isNullOrEmpty(searchTown)){
			searchTown = getCurrentOrg(request).getGbCode();
		}
		if(StringUtil.isNotEmpty(searchTown) && StringUtil.isNullOrEmpty(searchCenter)){
			form.setOrganCode(searchTown);
			form.setSelectCodeType("0");
		}
		if(StringUtil.isNotEmpty(searchCenter) && StringUtil.isNullOrEmpty(searchOrg)){
			form.setOrganCode(searchCenter);
			form.setSelectCodeType("B1");
		}
		if(StringUtil.isNotEmpty(searchOrg)){
			form.setOrganCode(searchOrg);
		}
		form.setLogoff("0");
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		final Criteria criteria = initCriteria(form, request);
		if(hasRole(RoleType.QWGZX, request)||hasRole(RoleType.ADMIN, request)){

			for (int i = 0; i < criteria.getCriteria().size(); i++) {
				if("inputSuperOrganCode".equals(criteria.getCriteria().get(i).getName())==true){
					criteria.getCriteria().remove(criteria.getCriteria().get(i));
				}
			}
			List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode",form.getOrganCode()));
			String[] orgs = new String[orgList.size()+1];
			for(int i=0; i<orgList.size(); i++) {
				orgs[i] = orgList.get(i).getOrganCode();
			}
			orgs[orgList.size()] = form.getOrganCode();

			if(orgList.size()>0){
				criteria.add("inputOrganCode", OP.IN, orgs);
			}
		}
//		PageList<PhysicalExamRecord> list = physicalExamRecordService.getEchExamRecords(page, criteria);
		excelExportService.exportListExecl("中医药健康管理体质辨识", EchPersonInfoExcel.class, response, new IDataSource() {
			@Override
			public List<Map<String, Object>> get(Page page) {
				List<Map<String, Object>> dataSource = physicalExamRecordService.exportEchExamRecords(page, criteria);
				return dataSource;
			}
		});
	}
		/**
         * 进入老年人中医药健康管理服务记录表新增/查看画面
         * @param request
         * @param editflag
         * @param model
         * @return
         */
	@RequestMapping("/report/init")
	public String initReport(HttpServletRequest request,Long personId, Long id,String editflag,String sourceFlag,Long isInfo,ModelMap model) {
		PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", personId));
		EchIdentification identification;
		if(ObjectUtil.isNullOrEmpty(id)){
			identification = new EchIdentification();
			identification.setPersonId(personId);
			identification.setName(personInfo.getName());
			identification.setIdcard(personInfo.getIdcard());
		}else {
			identification = echManageService.getEchIdentification(id);
		}
		//取档案编号的后8位
		if(StringUtil.isNotEmpty(personInfo.getHealthFileNo())){
			identification.setEchNo(personInfo.getHealthFileNo().substring(personInfo.getHealthFileNo().length() - 8, personInfo.getHealthFileNo().length()));
		}
		List<EchIdentificationOption> options = identification.getIdentificationOptions();
		String optionsData = "";

		if(ObjectUtil.isNullOrEmpty(identification.getId())) {
			identification.setCreateDate(new Date());
			identification.setCreateUser(SecurityUtils.getCurrentUser(request).getUserCode());
		}
		if(ObjectUtil.isNotEmpty(options)){
			identification.calTcmFlag();//计算体质标志；
			for(EchIdentificationOption option:options){
				optionsData += "option" + option.getOptionNo() + "_" + option.getScore() + ";";
			}
			model.addAttribute("options", optionsData);
		}
		model.addAttribute("personInfo",personInfo);
		model.addAttribute("editflag", editflag);
		model.addAttribute("report", identification);
		model.addAttribute("sourceFlag", sourceFlag);//页面来源 1：中医药，2：健康档案
		model.addAttribute("isInfo", isInfo);
		return "rhip.ech.manage.report";
	}

    /**
     * 保存老年人中医药健康管理服务记录表
     *
     * @param
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/report/save")
    public String save(EchIdentification identification,String optionDatas,String sourceFlag, HttpServletRequest request, ModelMap model) throws Exception {
    	String result = "rhip.ech.manage.result";
    	if(StringUtil.isNotEmpty(optionDatas)){
    		List<EchIdentificationOption>  options = json2Obj(optionDatas);
    		identification.setIdentificationOptions(options);
    		identification.calTcm();//计算体质分；
    	}
    	updateReportInfo(identification,request);
        echManageService.saveEchIdentification(identification,"1");
        model.addAttribute("report", identification);
        //如果页面来源（sourceFlag == 2）则返回结果页面健康档案返回时体质辨识结果 
        if("2".equals(sourceFlag)){
        	result = EHRMessageUtil.returnMsg(model,getTcmMap(identification));
        }
        return result;
    }
    
    @RequestMapping("/report/guidance")
    @ResponseBody
    public Object guidance(EchIdentification identification,String optionDatas,String sourceFlag, HttpServletRequest request, ModelMap model) throws Exception {
    	Map<String,Object> map=new HashMap<>();
    	if(StringUtil.isNotEmpty(optionDatas)){
    		List<EchIdentificationOption>  options = json2Obj(optionDatas);
    		identification.setIdentificationOptions(options);
    		identification.calTcm();//计算体质分；
    	}
    	updateReportInfo(identification,request);
       // echManageService.saveEchIdentification(identification);
        //如果页面来源（sourceFlag == 2）则返回结果页面健康档案返回时体质辨识结果
        if("2".equals(sourceFlag)){
        	//String result = EHRMessageUtil.returnMsg(model,getTcmMap(identification));
        	map=getTcmMap(identification);
        }
        map.put("report", identification);
        return map;
    }
    /**
     * 保存老年人中医药健康管理服务记录表
     *
     * @param
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/report/save1")
    public String save1(EchIdentification identification,String optionDatas,String sourceFlag, HttpServletRequest request, ModelMap model) throws Exception {
    	String result = "rhip.ech.manage.result";
    	if(StringUtil.isNotEmpty(optionDatas)){
    		List<EchIdentificationOption>  options = json2Obj(optionDatas);
    		identification.setIdentificationOptions(options);
    		identification.calTcm();//计算体质分；
    	}
    	updateReportInfo(identification,request);
        echManageService.saveEchIdentification(identification);
        model.addAttribute("report", identification);
        //如果页面来源（sourceFlag == 2）则返回结果页面健康档案返回时体质辨识结果 
        if("2".equals(sourceFlag)){
        	result = EHRMessageUtil.returnMsg(model,getTcmMap(identification));
        }
        return result;
    }
    
    @RequestMapping("/report/guidance1")
    public String guidance1(EchIdentification identification,String optionDatas,String sourceFlag, HttpServletRequest request, ModelMap model) throws Exception {
    	String result = "rhip.ech.manage.guidance";
    	if(StringUtil.isNotEmpty(optionDatas)){
    		List<EchIdentificationOption>  options = json2Obj(optionDatas);
    		identification.setIdentificationOptions(options);
    		identification.calTcm();//计算体质分；
    	}
		//此时暂时先不保存
    	updateReportInfo(identification,request);
        //echManageService.saveEchIdentification(identification);
    	// modify by Kevin Ro 2017-4-11 此处不做保存，等整个体检表保存的时候才将数据进行保存，先将此值放到session中
    	request.getSession().setAttribute("identification", identification);
        model.addAttribute("report", identification);
        //如果页面来源（sourceFlag == 2）则返回结果页面健康档案返回时体质辨识结果 
        if("2".equals(sourceFlag)){
        	result = EHRMessageUtil.returnMsg(model,getTcmMap(identification));
        }
        return result;
    }
    
	/**
	 * 计算老年人中医药健康管理服务记录表
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/report/calc")
	public String calc(EchIdentification identification,String optionDatas,String sourceFlag, HttpServletRequest request, ModelMap model) throws Exception {
		String result = "rhip.ech.manage.resultDialog";
		if(StringUtil.isNotEmpty(optionDatas)){
			List<EchIdentificationOption>  options = json2Obj(optionDatas);
			identification.setIdentificationOptions(options);
			identification.calTcm();//计算体质分；
		}
//		updateReportInfo(identification,request);
//		echManageService.saveEchIdentification(identification);
		model.addAttribute("report", identification);
		model.addAttribute("fromType", "calc");
		//如果页面来源（sourceFlag == 2）则返回结果页面健康档案返回时体质辨识结果
		if("2".equals(sourceFlag)){
			/*result = EHRMessageUtil.returnMsg(model,getTcmMap(identification));*/
		}
		return result;
	}

    private Map<String,Object> getTcmMap(EchIdentification ech){
    	Map<String, Object> map = new HashMap<String, Object>();
    	if(ObjectUtil.isNotEmpty(ech)){
    		ech.calTcmFlag();
    		map.put("qiFlag", ech.getQiFlag());
    		map.put("yangFlag", ech.getYangFlag());
    		map.put("yinDeficiencyFlag", ech.getYinDeficiencyFlag());
    		map.put("phlegmWetnessFlag", ech.getPhlegmWetnessFlag());
    		map.put("heatMediumFlag", ech.getHeatMediumFlag());
    		map.put("bloodFlag", ech.getBloodFlag());
    		map.put("qiStagnationFlag", ech.getQiStagnationFlag());
    		map.put("specialFlag", ech.getSpecialFlag());
    		map.put("peacefulFlag", ech.getPeacefulFlag());
    		map.put("id", ech.getId());
    	}
    	return map;
    }
	@RequestMapping("/report/printHealthEducation")
	public String printHealthEducation(ModelMap model, String type) {
		model.addAttribute("type", type);
		return "rhip.ech.manage.printHealthEducation";
	}
    /**
     * 设置更新人相关信息
     *
     * @param
     * @param request
     * @throws Exception
     * @author Ye jianfei
     */
    protected void updateReportInfo(EchIdentification identification,HttpServletRequest request){
    	if(ObjectUtil.isNotEmpty(identification.getId())){
        	identification.setUpdateOrg(getCurrentOrg(request).getOrganCode());
        	identification.setUpdateDate(new Date());
        	identification.setUpdateUser(String.valueOf(getCurrentUser(request).getUserCode()));
    	}else{
	    	identification.setCreateOrg(getCurrentOrg(request).getOrganCode());
	    	identification.setCreateDate(new Date());
	    	identification.setCreateUser(String.valueOf(getCurrentUser(request).getUserCode()));    		
    	}
    }
    /**
     * json数组转成List
     *
     * @param jsonArrayStr
     * @param
     * @return
     */
    private static List<EchIdentificationOption> json2Obj(String jsonArrayStr){
        JsonConfig jsonConfig = new JsonConfig();
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        List<EchIdentificationOption> resultList = new ArrayList<EchIdentificationOption>();
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            EchIdentificationOption option = (EchIdentificationOption) JSONObject.toBean(jsonObj, EchIdentificationOption.class);
            resultList.add(option);
        }
        return resultList;
    }
	private Criteria initCriteria(EchManageQueryForm form, HttpServletRequest request) {
		Criteria criteria = form.manageCriteria();
		//criteria.add("confirm", 1);
		if (!criteria.contains("inputOrganCode")) {
			Organization org = getCurrentOrg(request);
			if (hasRole(RoleType.ZXZYY, request)) {
				//criteria.add("inputSuperOrganCode", org.getOrganCode());
				// modify by Kevin Ro 2017-4-11 社区中心的时候还要能查看当前自己辨识的
				List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode",org.getOrganCode())); // 查询当前孩子
				String[] orgs = new String[orgList.size()+1];
    			for(int i=0; i<orgList.size(); i++) {
    				orgs[i] = orgList.get(i).getOrganCode();
    			}
    			orgs[orgList.size()] = org.getOrganCode();
    			criteria.add("inputOrganCode", OP.IN, orgs);
			} else if (hasRole(RoleType.ZZYY, request)) {
				criteria.add("inputOrganCode", org.getOrganCode());
			}
		}
		return criteria;
	}
	
	/**
	 * 中医药健康管理增加删除记录表的功能
	 */
	@RequestMapping("/report/deleteReport")
	@ResponseBody
	public ModelMap deleteReport(Long id, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		try {
			echManageService.delEchIdentification(id);
			createOperationLog(request, RhipModuleName.HM_CMMAN, "体质辨识", OperationName.DELETE);
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
		} catch (Exception e) {
			logger.error("记录删除失败", e);
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	@RequestMapping("/report/getEchIdentification")
	@ResponseBody
	public ModelMap getEchIdentification(Long id){
		ModelMap model = new ModelMap();
		try {
			EchIdentification identification = echManageService.getEchIdentification(id);
			model.addAttribute("data", getTcmMap(identification));
			model.addAttribute("result", true);
			model.addAttribute("message", "关联成功");
		} catch (Exception e) {
			model.addAttribute("result", false);
			model.addAttribute("message", "关联失败");
			e.printStackTrace();
		}
		
		return model;
	}
}
