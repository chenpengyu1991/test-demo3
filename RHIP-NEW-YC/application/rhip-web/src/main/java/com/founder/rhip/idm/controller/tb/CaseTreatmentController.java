package com.founder.rhip.idm.controller.tb;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.ListAs;
import com.founder.rhip.ehr.entity.control.idm.special.ListTr;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.common.TbStatus;
import com.founder.rhip.idm.controller.form.TbQueryForm;
import com.founder.rhip.idm.dto.TbSaveDto;
import com.founder.rhip.idm.service.ITbService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.OrganizationArea;
import com.founder.rhip.mdm.repository.IOrganizationAreaDao;
import com.founder.rhip.mdm.repository.IOrganizationDao;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * 专用病例和管理卡
 */
@Controller
@RequestMapping("/idm/tb/treatment")
public class CaseTreatmentController extends BaseController {
    
	@Resource(name = "tbService")
	private ITbService tbService;
	
	@Autowired
    private IDictionaryApp dictionaryApp;

	@Autowired
	private IOrganizationAreaDao orgAreaDao;

	@Resource(name="mdmOrganizationDao")
	private IOrganizationDao organizationDao;

	@RequestMapping("/dcmr/search")
    public String dcmrSearch(HttpServletRequest request, ModelMap model) {
		
        return "rhip.idm.dcmr.search";
    }
	
    /**
     * 专用病例列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/dcmr/list")
    public String searchDcmrList(TbQueryForm form, HttpServletRequest request, ModelMap model) {
    	
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		criteria.add("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_RECOMMENDATION.getValue(),
				SpecialEvents.T_TRANSFERTREAT.getValue(), SpecialEvents.T_DCMR.getValue()});
		/*获取已确诊为肺结核的患者*/
		criteria.add("dia.diagnosis_Type", "2");
		getCriteriaForDcmr(form, criteria);
		getRoleCriteria(criteria, request);//权限
				
		PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, null, null,null);
		model.addAttribute("dcmrs", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.idm.dcmr.list";
    }
    
    @RequestMapping("/search")
    public String treatmentSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.treatment.search";
    }
    
    /**
     * 治疗管理卡列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String searchTreatmentList(TbQueryForm form, HttpServletRequest request, ModelMap model) {

    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		this.getEventId(form, criteria, SpecialEvents.T_DCMR.getValue(), SpecialEvents.T_TREATMENT.getValue());
		getCriteriaForTransfertreat(form, criteria);//查询条件中状态的处理
		getRoleCriteria(criteria, request);//权限

		PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, null, null,null);
		model.addAttribute("treatments", plist.getList());
		model.addAttribute("page", plist.getPage());
		this.getRole(request, model);
        return "rhip.idm.treatment.list";
    }


	private Logger log = LoggerFactory.getLogger(this.getClass());
	@RequestMapping("/downLoad")
	@ResponseBody
	public void downTransferExcel(TbQueryForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {

			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/tbTrans.xls"));
			/*Criteria criteria = form.getCriteria();
		*//*获取唯一事件编码*//*
			this.getEventId(form, criteria,SpecialEvents.T_REGISTER.getValue(),SpecialEvents.T_TRANSFERTREAT.getValue());
		*//*组装查询页面状态的条件*//*
			this.getCriteriaForTransfertreat(form, criteria);
			criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限
			getCriteriaForTransfertreat(form, criteria);//查询条件中状态的处理
			getRoleCriteria(criteria, request);//权限
			List<IdmStatusInfo> plist = tbService.findTreatList( criteria, null, null);*/
			Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
			this.getEventId(form, criteria, SpecialEvents.T_REGISTER.getValue(), SpecialEvents.T_TRANSFERTREAT.getValue());
		/*组装查询页面状态的条件*/
			this.getCriteriaForTransfertreat(form, criteria);
			criteria.add("caseInfo.MODIFY_SURVEY_ORG", getCurrentOrg(request).getOrganCode());//权限

			List<IdmStatusInfo> plist = tbService.findTreatList( criteria, null, null);

			int totalRows = 7;
			int beginRowIndex = 5;
			int line = 0;
			excel.shiftRows(line + beginRowIndex, totalRows + line,plist.size());
			for (IdmStatusInfo transfer : plist) {
				List<Object> objects = getTransExcelValues(transfer, line + 1);
				excel.writeLineWithFormat(objects,line + beginRowIndex);
				line++;
			}
			excel.shiftRows(beginRowIndex, totalRows + line, -1);//删除多余行
			excel.shiftRows(beginRowIndex + line, totalRows + line, -1);//删除多余行
			setExcelContent(response, "结核病人转诊登记汇总.xls");
			excel.save(response.getOutputStream());

			plist.clear();
//			transferList = null;
		} catch (Exception e) {
			log.error("下载《结核病人转诊登记汇总》出错", e);
			throw e;
		}
	}

	/**
	 * 生成转诊EXCEL一行数据
	 *
	 * @param transfer
	 * @param lineNumber
	 * @return
	 */
	private List<Object> getTransExcelValues(IdmStatusInfo transfer, int lineNumber) {
		List<Object> line = new ArrayList<Object>();
		line.add(lineNumber);
		line.add(transfer.getTbDto().getName());
		line.add(dictionaryApp.queryDicItemName("GBT226112003", transfer.getTbDto().getGender()));
		line.add(transfer.getTbDto().getIdcard());
		line.add(dictionaryApp.queryDicItemName("IDM00255",transfer.getPlaceStatus()));
		line.add(DateUtil.getDateTime("yyyy/MM/dd", transfer.getTbDto().getTransferTreatmentDt()));
		line.add(dictionaryApp.queryDicItemName("IDM00218", transfer.getTbDto().getDiagnosisReason()));
		String diagnosisType = transfer.getTbDto().getDiagnosisType();
		if(diagnosisType==null)
			line.add("未诊断");
		else
			line.add(dictionaryApp.queryDicItemName("IDM00224", diagnosisType));
		return line;
	}
    

    /**
     * 治疗管理卡 接受或拒绝
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/update")
    public String updateIdmStatusInfo(long idmId, long singleId, Integer specialStatus, HttpServletRequest request, ModelMap model) {
    	IdmStatusInfo idmStatusInfo = tbService.getIdmStatusInfo(idmId);
    	IdmApprovalInfo idmApprovalInfo = this.setIdmApprovalInfo(singleId, specialStatus, request, null);
    	if (ObjectUtil.equals(specialStatus, TbStatus.RETURN.getValue())) {
    		if(hasRole(RoleType.ZJHB, request) || hasRole(RoleType.ZXJHB, request)) {//若站退回 则退回给分派给它的上一级单位
    			/*String currentUnit = idmStatusInfo.getCurrentUnit();*/
        		idmStatusInfo.setCurrentUnit(idmStatusInfo.getLastUnit());
        		idmStatusInfo.setLastUnit("");
    		} else {//若中心或市级医院 直接退回给结防所
    			idmStatusInfo.setLastUnit(idmStatusInfo.getCurrentUnit());
        		idmStatusInfo.setCurrentUnit("");
    		}
    	}
    	idmStatusInfo.setSpecialStatus(specialStatus);
    	int result = tbService.updateSpecialStatus(idmStatusInfo, idmApprovalInfo);
    	if (result > 0 && ObjectUtil.equals(specialStatus, TbStatus.ACCEPT.getValue())) {
    		//创建2,3,5,6,9预约查痰日期
			List<ListAs> idmListAs = new ArrayList<>();
			Date thisDt = tbService.findOtherCondition(singleId).getThisDt();
			idmListAs.add(setFirstSputumDt(singleId, thisDt, 60, "2", request));
			idmListAs.add(setFirstSputumDt(singleId, thisDt, 90, "3", request));
			idmListAs.add(setFirstSputumDt(singleId, thisDt, 150, "5", request));
			idmListAs.add(setFirstSputumDt(singleId, thisDt, 180, "6", request));
			idmListAs.add(setFirstSputumDt(singleId, thisDt, 270, "9", request));
			tbService.saveAs(""+singleId, idmListAs);
    	}
    	createOperationLog(request, RhipModuleName.IDM, "结核病专项-治疗管理卡 接受或拒绝", OperationName.UPDATE);
        return EHRMessageUtil.returnMsg(model,result > 0 ? "success" : "fail");
    }

    /**
     * 进入专用病例添加页面
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/init")
    public String initAdd(String singleId, Integer specialStatus, String type, String pageIndex, ModelMap model, HttpServletRequest request) {
    	TbSaveDto tbSaveDto = new TbSaveDto();
    	if(StringUtil.isNotEmpty(singleId)) {
    		tbSaveDto = tbService.getTbSaveDto(singleId);
    	}
    	if (StringUtils.equals(type, "1")) {
    		tbSaveDto.setSpecialStatus(specialStatus);
    		this.setCurrentUser(tbSaveDto, request);
    		//将筛查登记的症状初始化专用病历
    		if(ObjectUtil.equals(specialStatus, TbStatus.DCMR.getValue()) && StringUtils.isNotEmpty(singleId)) {
    			ClinicalManifestations clinicalManifestations = tbService.getClinicalManifestations(singleId);//new ClinicalManifestations();
    			if(ObjectUtil.isNotEmpty(clinicalManifestations) && StringUtils.isNotEmpty(clinicalManifestations.getOriginalSymptom())) {
    				this.copyPropertyOriginalSymptom(clinicalManifestations);
    				tbSaveDto.setClinicalManifestations(clinicalManifestations);
    			}
    		}
    	}
        //确诊
        if (StringUtils.equals(type, "2") && ObjectUtil.equals(specialStatus, TbStatus.DIAGNOSIS.getValue())) {
        	if(ObjectUtil.isNullOrEmpty(tbSaveDto.getDiagnosis())) {
        		tbSaveDto.setDiagnosis(new Diagnosis());
    		}
        	tbSaveDto.getDiagnosis().setRegisterDt(new Date());
        }
        //治疗卡
		if(ObjectUtil.equals(specialStatus, TbStatus.TREATMENT.getValue()) && StringUtils.isNotEmpty(singleId)) {
			ClinicalManifestations clinicalManifestations = tbService.getClinicalManifestations(singleId, SpecialEvents.T_TREATMENT.getValue());
			if(ObjectUtil.isNotEmpty(clinicalManifestations)) {
				tbSaveDto.setClinicalManifestations(clinicalManifestations);
			}
		}
		 //筛查登记修改
		if(ObjectUtil.equals(specialStatus, TbStatus.REGISTER.getValue()) && StringUtils.isNotEmpty(singleId)) {
			ClinicalManifestations clinicalManifestations = tbService.getClinicalManifestations(singleId);
			if(ObjectUtil.isNotEmpty(clinicalManifestations)) {
				tbSaveDto.setClinicalManifestations(clinicalManifestations);
			}
		}
		//疑似推荐修改查看
		if(ObjectUtil.equals(specialStatus, TbStatus.RECOMMENDATION.getValue()) && StringUtils.isNotEmpty(singleId)) {
			ClinicalManifestations clinicalManifestations = tbService.getClinicalManifestations(singleId, SpecialEvents.T_RECOMMENDATION.getValue());
			if(ObjectUtil.isNotEmpty(clinicalManifestations)) {
				tbSaveDto.setClinicalManifestations(clinicalManifestations);
			}
		}
    	if(!StringUtils.equals(type, "3")) {
    		this.setDoctor(tbSaveDto, request);
    	}
        model.addAttribute("tbSaveDto", tbSaveDto);
        model.put("type", type);
        model.put("pageIndex", pageIndex);
        return TbLayoutMap.getLayoutStr(specialStatus);
    }
    
    /**
     * 新增结核病专项
     * @param tbSaveDto
     * @param type
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/save")
    public String saveTbSaveDto(TbSaveDto tbSaveDto, int type , HttpServletRequest request, ModelMap model)  throws Exception {
    	boolean result = false;
		if(ObjectUtil.isNotEmpty(tbSaveDto)){
			GeneralCondition generalCondition = tbSaveDto.getGeneralCondition();
			boolean flag = ObjectUtil.isNotEmpty(generalCondition.getFloatPopulation()) && generalCondition.getFloatPopulation().equalsIgnoreCase("1");
			/*generalCondition.setPaAddress(flag
                    ? dictionaryApp.queryDicItemName("FS990001", generalCondition.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", generalCondition.getPastreet()) + generalCondition.getPahouseNumber()
                    : generalCondition.getPahouseNumber());*/
			generalCondition.setPaAddress(
                    dictionaryApp.queryDicItemName("FS990001", generalCondition.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", generalCondition.getPastreet()) + generalCondition.getPahouseNumber()
                    );
			generalCondition.setHrAddress(flag
                    ? dictionaryApp.queryDicItemName("FS990001", generalCondition.getHrtownShip()) + dictionaryApp.queryDicItemName("FS990001", generalCondition.getHrstreet()) + generalCondition.getHrhouseNumber()
                    : generalCondition.getHrhouseNumber());

			String actionName = getActionName(tbSaveDto.getSpecialStatus());
			updatePersonInfo(tbSaveDto,request);        	
			if(type == 1){//新增
                tbSaveDto.getCaseInformation().setModifySurveyOrg(this.getCurrentOrg(request).getOrganCode());
                tbSaveDto.getCaseInformation().setModifySurveyDate(new Date());
                tbSaveDto.getCaseInformation().setModifyRespondents(this.getCurrentUser(request).getUserCode());
				this.setCurrentUser(tbSaveDto, request);
				result = tbService.saveTbSaveDto(tbSaveDto, tbSaveDto.getEventId(), null);
				createOperationLog(request, RhipModuleName.IDM, actionName, OperationName.ADD);
			} else {//更新
				/*获取PERSON_ID modify by yjf 20140107*/
				Long personId = tbService.getPersonId(tbSaveDto.getIdmId());
				tbSaveDto.setPersonId(personId);
                tbSaveDto.getCaseInformation().setModifySurveyOrg(this.getCurrentOrg(request).getOrganCode());
                tbSaveDto.getCaseInformation().setModifySurveyDate(new Date());
                tbSaveDto.getCaseInformation().setModifyRespondents(this.getCurrentUser(request).getUserCode());
				result = tbService.updateTbSaveDto(tbSaveDto);
				createOperationLog(request, RhipModuleName.IDM, actionName, OperationName.UPDATE);
			}

			//结核病专项管理卡新增时根据居委会编号自动指派到站
			if(type == 1&& TbStatus.TREATMENT.getValue()==tbSaveDto.getSpecialStatus()) {
				Long idmId = tbSaveDto.getIdmId();
				Long singleId = tbSaveDto.getSingleId();
				if (idmId != null && singleId != null) {
					String townCode = generalCondition.getPastreet();
					Criteria criteria = new Criteria("areaCode", townCode);
					OrganizationArea orgArea = orgAreaDao.get(criteria);
					if (orgArea != null)
						result = assignPro(idmId, singleId, orgArea.getOrganizationCode(), request);
				}
			}
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    
    /**
     * 根据状态获取结核病专项的哪一步
     * @param specialStatus
     * @return
     */
    private String getActionName(Integer specialStatus) {
    	TbStatus.RECOMMENDATION.getValue();
    	if(specialStatus == TbStatus.RECOMMENDATION.getValue()) {
    		return "结核病专项-推荐单";
    	} else if (specialStatus == TbStatus.REGISTER.getValue()) {
    		return "结核病专项-筛查登记";
    	} else if (specialStatus == TbStatus.TRANSFERTREAT.getValue()) {
    		return "结核病专项-转诊";
    	} else if (specialStatus == TbStatus.DIAGNOSIS.getValue()) {
    		return "结核病专项-诊断";
    	} else if (specialStatus == TbStatus.DCMR.getValue()) {
    		return "结核病专项-专用病历";
    	} else if (specialStatus == TbStatus.TREATMENT.getValue()) {
    		return "结核病专项-管理卡";
    	} else {
    		return "结核病专项-管理卡";
    	}
    }
    @RequestMapping("/diagnosis/search")
    public String diagnosisSearch(HttpServletRequest request, ModelMap model) {
        return "rhip.idm.diagnosis.search";
    }
	
    /**
     * 确诊列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/diagnosis/list")
    public String searchDiagnosisList(TbQueryForm form, HttpServletRequest request, ModelMap model) {
    	String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = form.getCriteria();
		/*获取唯一事件编码*/
		Criteria criteriaTemp = new Criteria("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_TRANSFERTREAT.getValue()});
		//传染病医院的医生可以看到转诊后的患者和推荐单中复查单位为传染病医院的患者
		criteriaTemp.add(LOP.OR, new Criteria("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_RECOMMENDATION.getValue()})
						.add("caseInfo.Review_Unit", getCurrentOrg(request).getOrganCode()));
		
		criteria.add(LOP.AND, criteriaTemp);
		//查询条件 是否已确诊
		if(StringUtils.equals(form.getDiagnosisType(), "1")) {
			criteria.add("dia.diagnosis_Type", OP.UEMPTY,"");
		} else if (StringUtils.equals(form.getDiagnosisType(), "2")){
			criteria.add("dia.diagnosis_Type", OP.IS,"NULL");
		}
		//形成获取event表中最新数据的条件
		Criteria statusCr = new Criteria("EVENT_ID", OP.IN, new String[]{SpecialEvents.T_RECOMMENDATION.getValue(), SpecialEvents.T_TRANSFERTREAT.getValue()});
		Order order = new Order("caseInfo.MODIFY_SURVEY_DATE", false);
		order.asc("status.PLACE_STATUS");
		PageList<IdmStatusInfo> plist = tbService.findTreatmentList(page, criteria, statusCr, order,null);
		model.addAttribute("diagnosiss", plist.getList());
		model.addAttribute("page", plist.getPage());
        return "rhip.idm.diagnosis.list";
    }
    
    /**
     * 更新到诊状态
     * @param idmId
     * @param model
     * @param request
     */
    @RequestMapping("/updatePlaceStatus")
    public String updatePlaceStatus(Long idmId, Long singleId, ModelMap model, HttpServletRequest request) {
    	
    	CaseInformation caseInformation = tbService.findCaseInformation(singleId);
    	Integer transferDays = DateUtil.getBetweenDays(caseInformation.getTransferTreatmentDt(), new Date())-2;
    	ListTr listTr = this.getListTr(singleId, "5",transferDays, request);
    	
    	Boolean result = tbService.updatePlaceStatus(idmId, "5",listTr);
    	createOperationLog(request, RhipModuleName.IDM, "结核病专项-到诊状态", OperationName.UPDATE);
    	return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    
    /**
     * 更新诊断结果
     * @param model
     * @param request
     */
    @RequestMapping("/diagnosis/update")
    public String diagnosis(TbSaveDto tbSaveDto, ModelMap model, HttpServletRequest request) {
    	Integer transferDays = DateUtil.getBetweenDays(tbSaveDto.getCaseInformation().getTransferTreatmentDt(), new Date())-2;
    	ListTr listTr = this.getListTr(tbSaveDto.getSingleId(), "5",transferDays, request);
		//将诊断值更新到诊断表
		boolean result = tbService.updateDiagnosis(tbSaveDto, listTr);
		createOperationLog(request, RhipModuleName.IDM, "结核病专项-诊断状态", OperationName.UPDATE);
    	return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    
    @RequestMapping("/init/assign")
    public String initAssign(Long idmId, Long singleId, String specialStatus, String pageIndex, HttpServletRequest request, ModelMap model) {
    	model.addAttribute("idmId", idmId);
    	model.addAttribute("singleId", singleId);
    	this.getRole(request, model);
    	model.put("pageIndex", pageIndex);
		return "rhip.idm.treatment.assign";
    }
    
    @RequestMapping("/assign/save")
    public String saveAssign(Long idmId, Long singleId, String orgCode, ModelMap model, HttpServletRequest request) {

    	
    	boolean result = assignPro(idmId, singleId, orgCode, request);
    	createOperationLog(request, RhipModuleName.IDM, "结核病专项-已分派", OperationName.UPDATE);
    	return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

	private boolean assignPro(Long idmId, Long singleId, String orgCode, HttpServletRequest request){

		//BUG0096153
		/*if(!hasRole(RoleType.JKJHB, request)) {
			specialStatus = TbStatus.REASSIGN.getValue();
		}*/
		IdmStatusInfo idmStatusInfo = this.getIdmStatusInfo(idmId, orgCode);
		Integer specialStatus = idmStatusInfo.getSpecialStatus();
		IdmApprovalInfo idmApprovalInfo = this.setIdmApprovalInfo(singleId, specialStatus, request, orgCode);
		return tbService.saveAssign(idmStatusInfo, idmApprovalInfo);
	}
    /**
     * 判断当前用户权限
     * @param request
     * @param model
     */
    private void getRole(HttpServletRequest request, ModelMap model) {

		if (hasRole(RoleType.JKJHB, request)) {
	        model.addAttribute("ROLE", RoleType.JKJHB.getValue());
	    }
        if (hasRole(RoleType.ZXJHB, request)) {
            model.addAttribute("ROLE", RoleType.ZXJHB.getValue());
        }
        if (hasRole(RoleType.YYJHB, request)) {
            model.addAttribute("ROLE", RoleType.YYJHB.getValue());
        }
        if (hasRole(RoleType.ZJHB, request)) {
            model.addAttribute("ROLE", RoleType.ZJHB.getValue());
        }
		if (hasRole(RoleType.DDCRBYY, request)) {
			model.addAttribute("ROLE", RoleType.DDCRBYY.getValue());
		}
    }
    
    /*获取唯一事件编码*/
    private void getEventId(TbQueryForm form, Criteria criteria, String eventIdF, String eventIdS) {
		String arrays[] = {eventIdF, eventIdS};
		criteria.add("EVENT_ID", OP.IN, arrays);
    }
    
    /**
     * 页面初始化时 进行一些关于用户信息的加载
     */
    private void setCurrentUser(TbSaveDto tbSaveDto, HttpServletRequest request) {
    	/*根据当前用户，设置页面中的调查机构*/
        CaseInformation caseInformation = tbSaveDto.getCaseInformation();
        if (ObjectUtil.isNullOrEmpty(caseInformation)) {
        	caseInformation = new CaseInformation();
        }
        Organization org = getCurrentOrg(request);
        String currentOrgName = org.getOrganName();
        caseInformation.setSurveyOrgName(currentOrgName);
        caseInformation.setSurveyDate(new Date());

        String userId = getCurrentUser(request).getUserCode();
        caseInformation.setModifyRespondents(userId);
        caseInformation.setModifySurveyOrg(org.getOrganCode());
        caseInformation.setModifySurveyDate(new Date());
        
        //设置转诊信息
        if(ObjectUtil.equals(TbStatus.TRANSFERTREAT.getValue(), tbSaveDto.getSpecialStatus())) {
        	caseInformation.setTransferTreatmentDoctor(String.valueOf(userId));
        	caseInformation.setTransferTreatmentUnit(org.getOrganCode());
        	caseInformation.setTransferTreatmentDt(new Date());
        }
        tbSaveDto.setCaseInformation(caseInformation);
    }
    
    /**
     * 专用病历 医生签名和判断医生签名
     */
    private void setDoctor(TbSaveDto tbSaveDto, HttpServletRequest request) {
    	OtherCondition otherCondition = null;
    	if(ObjectUtil.isNullOrEmpty(tbSaveDto.getOtherCondition())) {
    		otherCondition = new OtherCondition();
    	} else {
    		otherCondition = tbSaveDto.getOtherCondition();
    	}
    	 String userId = getCurrentUser(request).getUserCode();
    	 String thisDoctor = otherCondition.getThisDoctor();
    	 String judgeDoctor = otherCondition.getJudgeDoctor();
    	 //医生签名
    	 if(StringUtils.isEmpty(thisDoctor)) {
    		 otherCondition.setThisDoctor(userId);
    	 } else {
    		 List<String> thisDoctors = Arrays.asList(thisDoctor.split(","));
    		 if(!thisDoctors.contains(userId)){
    			 otherCondition.setThisDoctor(thisDoctor+"," + userId);
    		 }
    	 }
    	 //判断医生签名
    	 if(StringUtils.isEmpty(judgeDoctor)) {
    		 otherCondition.setJudgeDoctor(userId);
    	 } else {
    		 List<String> JudgeDoctors = Arrays.asList(judgeDoctor.split(","));
    		 if(!JudgeDoctors.contains(userId)){
    			 otherCondition.setJudgeDoctor(judgeDoctor+"," + userId);
    		 }
    	 }
    	 tbSaveDto.setOtherCondition(otherCondition);
    }
    
    /**
	 * 获取查询结核病 治疗管理卡的权限条件
	 * @return
	 */
	private void getRoleCriteria(Criteria criteria, HttpServletRequest request) {
		Criteria temp = new Criteria();
		String orgCode = getCurrentOrg(request).getOrganCode();
		if (!hasRole(RoleType.JKJHB, request)&&!hasRole(RoleType.DDCRBYY, request)) {
    		temp.add("status.LAST_UNIT", orgCode).add("status.special_status", 
    				OP.IN,new Integer[]{TbStatus.REASSIGN.getValue(), TbStatus.ACCEPT.getValue(), TbStatus.ASSIGN.getValue()})//bug0096457
    			.add(LOP.OR, new Criteria("status.CURRENT_UNIT", orgCode));
    		criteria.add(temp);
		}
	}
	
	/**
	 * 组装追踪记录
	 * @param idmId
	 * @param transferStatus
	 * @param transferDays
	 * @param request
	 * @return
	 */
	private ListTr getListTr(Long idmId, String transferStatus, int transferDays, HttpServletRequest request) {
    	Organization org = getCurrentOrg(request);
    	String userId = getCurrentUser(request).getUserCode();
    	ListTr listTr = new ListTr();
    	listTr.setCreateDt(new Date());
    	listTr.setCreateUnit(org.getOrganCode());
    	listTr.setCreateUser(userId);
    	listTr.setFlag(IdmType.TB.getValue());
    	listTr.setIdmId(idmId);
    	listTr.setTransferStatus(transferStatus);
		listTr.setTransferDays(transferDays);
    	listTr.setTransferDt(new Date());
    	return listTr;
    }
	
	/**
     * 专用病历的状态 未建专用病历 状态为已确诊但状态为转诊状态   若已建专用病历则不等于转诊可也不一定要等于建专用病历状态
     * @param form
     * @param criteria
     */
    private void getCriteriaForDcmr(TbQueryForm form, Criteria criteria) {
    	Integer specialStatus = form.getSpecialStatus();
    	criteria.remove("status.special_status");
    	if (ObjectUtil.isNotEmpty(specialStatus)){
    		if(ObjectUtil.equals(specialStatus, TbStatus.TRANSFERTREAT.getValue())) {
    			Integer arrays[] = {TbStatus.RECOMMENDATION.getValue(), TbStatus.TRANSFERTREAT.getValue()};
    			criteria.add("status.SPECIAL_STATUS", OP.IN, arrays);
    		} else if(ObjectUtil.equals(specialStatus, TbStatus.DCMR.getValue())){
    			Integer arrays[] = {TbStatus.RECOMMENDATION.getValue(), TbStatus.REGISTER.getValue(),
    						TbStatus.DIAGNOSIS.getValue(), TbStatus.TRANSFERTREAT.getValue()};
    			criteria.add("status.SPECIAL_STATUS", OP.NOTIN, arrays);
    		}
    	}
    }
    
    /**
     * 治疗管理卡 状态查询
     * @param form
     * @param criteria
     */
    private void getCriteriaForTransfertreat(TbQueryForm form, Criteria criteria) {
    	Integer specialStatus = form.getSpecialStatus();
    	criteria.remove("status.special_status");
    	if (ObjectUtil.isNotEmpty(specialStatus)){
    		if(ObjectUtil.equals(specialStatus, TbStatus.TREATMENT.getValue())){
    			Integer arrays[] = {TbStatus.ASSIGN.getValue(), TbStatus.REASSIGN.getValue(), TbStatus.RETURN.getValue(), TbStatus.ACCEPT.getValue(), TbStatus.STOP.getValue()};
    			criteria.add("status.SPECIAL_STATUS", OP.NOTIN, arrays);
    		} else if(ObjectUtil.equals(specialStatus, TbStatus.ASSIGN.getValue())) {
    			Integer arrays[] = {TbStatus.ASSIGN.getValue(), TbStatus.REASSIGN.getValue()};
    			criteria.add("status.SPECIAL_STATUS", OP.IN, arrays);
    		}else{
    			criteria.add("status.SPECIAL_STATUS", specialStatus);
    		}
		}
    }

    /**
     * 根据专项状态获取状态对象
     * @param idmId
	 * @String orgCode
     * @return
     */
    private IdmStatusInfo getIdmStatusInfo(Long idmId, String orgCode) {
    	IdmStatusInfo idmStatusInfo = tbService.getIdmStatusInfo(idmId);
		Integer orginalStatus = idmStatusInfo.getSpecialStatus();
		Integer specialStatus = null;
		if(ObjectUtil.equals(TbStatus.RETURN.getValue(),orginalStatus))
			specialStatus= TbStatus.REASSIGN.getValue();
		else
			specialStatus= TbStatus.ASSIGN.getValue();
		if(ObjectUtil.equals(specialStatus, TbStatus.ASSIGN.getValue())
    			|| ObjectUtil.equals(specialStatus, TbStatus.REASSIGN.getValue())) {
			//BUG0096457
    		/*if(StringUtils.isNotEmpty(idmStatusInfo.getCurrentUnit())) {
    			idmStatusInfo.setLastUnit(idmStatusInfo.getCurrentUnit());
        	}*/
			Organization org = organizationDao.get(new Criteria(Organization.ORGAN_CODE, orgCode));
			//若现住址关联机构为中心
			if(OrgGenreCode.CENTRE.getValue().equals(org.getGenreCode()))
				idmStatusInfo.setLastUnit(null);
			else if(OrgGenreCode.STATION.getValue().equals(org.getGenreCode())) //若现住址关联机构为站
				idmStatusInfo.setLastUnit(org.getParentCode());
    		idmStatusInfo.setCurrentUnit(orgCode);
    	}
    	idmStatusInfo.setSpecialStatus(specialStatus);
    	
    	return idmStatusInfo;
    }

    /**
     * 获取审批对象 将分派作为一个审批来看
     * @param singleId
     * @param specialStatus
     * @param request
     * @param nextUnit
     * @return
     */
    private IdmApprovalInfo setIdmApprovalInfo(long singleId, Integer specialStatus, HttpServletRequest request, String nextUnit) {
    	IdmApprovalInfo idmApprovalInfo = new IdmApprovalInfo();
    	 Organization org = getCurrentOrg(request);
         User user = getCurrentUser(request);
    	idmApprovalInfo.setIdmId(singleId);
        idmApprovalInfo.setStatus(specialStatus.toString());
        idmApprovalInfo.setUserId(user.getUserCode());
        idmApprovalInfo.setUserName(user.getUserName());
        idmApprovalInfo.setUnitCode(org.getOrganCode());
        idmApprovalInfo.setNextUnit(nextUnit);
        idmApprovalInfo.setApprovalDate(new Date());
        return idmApprovalInfo;
    }
    
    /**
     * 纳入是指点第一次预约查痰日期
     * @param singleId
     * @param thisDt 始治日期
     * @param days 2个月天数 按60计
     * @return
     */
    private ListAs setFirstSputumDt(Long singleId, Date thisDt, int days, String monthSeq, HttpServletRequest request){
        Organization org = getCurrentOrg(request);
        String orgCode = org.getOrganCode();
        String userId = getCurrentUser(request).getUserCode();
        ListAs listAs = new ListAs();
        listAs.setIdmId(singleId);
        listAs.setSputumDt(DateUtil.add(thisDt, Calendar.DATE, days - 7));
        listAs.setMonthSeq(monthSeq);
        listAs.setCreateUnit(orgCode);
        listAs.setCreateUser(userId);
        listAs.setCreateDt(new Date());
        return listAs;
    }
    
    /**
     * 将筛查登记的症状赋予专用病历
     * @param clinicalManifestations
     */
    private void copyPropertyOriginalSymptom(ClinicalManifestations clinicalManifestations) {
    	List<String> originalSymptoms = Arrays.asList(clinicalManifestations.getOriginalSymptom().split(","));
    	if(originalSymptoms.contains("1") || originalSymptoms.contains("2")) {//咳嗽 咳痰
    		clinicalManifestations.setCough("1");
    		clinicalManifestations.setExpectoration("1");
    	}
		if(originalSymptoms.contains("3")) {// 咯血
			clinicalManifestations.setHemoptysis("1");
		}
		if(originalSymptoms.contains("4")) {//发热
			clinicalManifestations.setFever("1");
		}
		if(originalSymptoms.contains("5")) {//盗汗
			clinicalManifestations.setNightSweat("1");
		}
		if(originalSymptoms.contains("6")) {//胸闷
			clinicalManifestations.setChestPain("1");
		}
		if(originalSymptoms.contains("99")) {//其它
			clinicalManifestations.setOtherSelect("1");
		}
    }
    
    private void updatePersonInfo(TbSaveDto tbSaveDto, HttpServletRequest request) throws Exception {
    	String[] param = null;
    	Integer specialStatus = tbSaveDto.getSpecialStatus();
    	switch(specialStatus){
    		case 1://推荐单
    			param = new String[]{"name", "gender","nation","otherNationDesc","birthday","phoneNumber","occupation","unitName","householdType",
    					"patownShip", "pastreet", "paGroup", "pahouseNumber", "paAddress",
						"hrtownShip", "hrstreet", "hrGroup", "hrhouseNumber", "hrAddress",
						"updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    		case 2://筛查登记
    			param = new String[]{"name", "gender","phoneNumber","householdType",
    					"patownShip", "pastreet", "paGroup", "pahouseNumber", "paAddress",
						"hrtownShip", "hrstreet", "hrGroup", "hrhouseNumber", "hrAddress",
						"updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    		case 3://转诊
    			param = new String[]{"name", "gender","phoneNumber","householdType",
    					"patownShip", "pastreet", "paGroup", "pahouseNumber", "paAddress",
						"hrtownShip", "hrstreet", "hrGroup", "hrhouseNumber", "hrAddress",
						"updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;
    		case 4://专用病历
    			param = new String[]{"name", "gender","nation","otherNationDesc","phoneNumber","occupation","unitName","householdType",
    					"patownShip", "pastreet", "paGroup", "pahouseNumber", "paAddress",
    					"hrtownShip", "hrstreet", "hrGroup", "hrhouseNumber", "hrAddress",
	                    "updateOrganCode", "updateOrganName","updateDate", "updateIdcard", "updateName"};
    			break;    			
    	}
    	tbSaveDto.setPersonInfoParam(param);
        tbSaveDto.getPersonInfo().setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
        tbSaveDto.getPersonInfo().setUpdateOrganName(getCurrentOrg(request).getOrganName());
        tbSaveDto.getPersonInfo().setUpdateName(getCurrentUser(request).getName());
        tbSaveDto.getPersonInfo().setUpdateDate(new Date());
        tbSaveDto.getPersonInfo().setUpdateIdcard(getCurrentUser(request).getIdentityCard()); 
    }



}