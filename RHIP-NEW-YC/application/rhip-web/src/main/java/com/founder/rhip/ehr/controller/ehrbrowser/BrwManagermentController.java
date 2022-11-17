package com.founder.rhip.ehr.controller.ehrbrowser;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.LOP;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.management.DmHypertensionConclusion;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.ehr.entity.management.DmStrtumFollowup;
import com.founder.rhip.ehr.entity.management.DmTumorFollowup;
import com.founder.rhip.ehr.service.IBrwDiseaseManageService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;

/**
 * 疾病管理
 * @author liuk
 *
 */
@Controller
@RequestMapping("/ehrbrowser/management")
public class BrwManagermentController extends BaseController{
	
	@Resource
	private IStandardizationService standardizationService;

    @Resource(name = "personalRecordService")
    private IPersonalRecordService personalRecordService;

	
	@Resource
	private IBrwDiseaseManageService brwDiseaseManageService; 
	
	 @Resource(name = "personalRecordManagmentService")
	    private IPersonalRecordManagmentService personalRecordManagmentService;

	@RequestMapping()
	public String index(String personId, ModelMap model){
//		PersonalBasicInfoDTO personBasicInfoDto = (PersonalBasicInfoDTO) personalRecordManagmentService.getPersonalBasicInfo((new Criteria("id", personId)));
//	    model.addAttribute("personBasicInfoDto", personBasicInfoDto);

        PersonInfo personInfo=personalRecordService.getPersonRecord(new Criteria("id",personId),"name","birthday","gender","idcard");
        model.addAttribute("personInfo", personInfo);


		return "rhip.ehr.browser.management";
	}
	
	@RequestMapping("/manageIndex")
	public String diseaseManageIndex(HttpServletRequest request, ModelMap model){
		Criteria criteria = new Criteria("personId", request.getParameter("personId"));
		criteria.add(this.getHmCardDeleteStatus(EHRConstants.DM_MANAGED_FLAG));
		DmDiseaseInfo diseaseInfo = standardizationService.getHmCard(criteria);
		if(ObjectUtil.isNotEmpty(diseaseInfo)){
			model.put("brwDiseaseInfo", diseaseInfo);
			return "rhip.ehr.browser.manageIndex";
		}
		return "rhip.ehr.browser.error";
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param isDelete
	 * @return
	 */
	private Criteria getHmCardDeleteStatus(String isDelete) {
		Criteria criteria = new Criteria();
		criteria.add("hbp_flag", isDelete);
		criteria.add(LOP.OR, "di_flag", isDelete);
		criteria.add(LOP.OR, "stroke_flag", isDelete);
		criteria.add(LOP.OR, "coronary_flag", isDelete);
		criteria.add(LOP.OR, "tumor_flag", isDelete);
		return criteria;
	}

	@RequestMapping("/managePlan")
	public String diseaseManagePlan(HttpServletRequest request, ModelMap model){
		String personId = request.getParameter("personId");
		List<DmHypertensionConclusion> dmHypertensionConclusions = brwDiseaseManageService.getDmHypertensionConclusions(new Criteria("personId", personId));
		if(ObjectUtil.isNotEmpty(dmHypertensionConclusions)){
			model.addAttribute("dmHypertensionConclusions", dmHypertensionConclusions);
			return "rhip.ehr.browser.managePlan";
		}
		return "rhip.ehr.browser.error";
	}
	
	@RequestMapping("/managePlanInfo")
	public String diseaseManagePlanInfo(String id, ModelMap model){
		DmHypertensionConclusion dmHypertensionConclusion = brwDiseaseManageService.getHealthPlanDetail(new Criteria("id", id));
		if(ObjectUtil.isNotEmpty(dmHypertensionConclusion)){
			Criteria criteria=new Criteria();
			criteria.add("personId", dmHypertensionConclusion.getPersonId());
			DmDiseaseInfo diseaseInfo=brwDiseaseManageService.getDmDiseaseInfo(criteria);
			if(ObjectUtil.isNotEmpty(diseaseInfo)){
				dmHypertensionConclusion.setDiDiagnosedDate(diseaseInfo.getDiDiagnosedDate());
				dmHypertensionConclusion.setDiDiagnosedOrganCode(diseaseInfo.getDiDiagnosedOrganCode());
				dmHypertensionConclusion.setDiType(diseaseInfo.getDiType());
			}
			if (dmHypertensionConclusion.getDiseaseType().equals("1")) {
				// 给checkBox绑赋属性
				if (!ObjectUtil.isNullOrEmpty(dmHypertensionConclusion.getCvdElement())) {
					String[] cvdElementArr = dmHypertensionConclusion.getCvdElement().split(",");
					for (int i = 0; i < cvdElementArr.length; i++) {
						switch (cvdElementArr[i]) {
						case "1":
							model.addAttribute("cvdElementArr0", 1);
							break;
						case "2":
							model.addAttribute("cvdElementArr1", 2);
							break;
						case "3":
							model.addAttribute("cvdElementArr2", 3);
							break;
						case "4":
							model.addAttribute("cvdElementArr3", 4);
							break;
						case "5":
							model.addAttribute("cvdElementArr4", 5);
							break;
						case "6":
							model.addAttribute("cvdElementArr5", 6);
							break;
						case "7":
							model.addAttribute("cvdElementArr6", 7);
							break;
						}
					}
				}
				if (!ObjectUtil.isNullOrEmpty(dmHypertensionConclusion.getTrDamage())) {
					String[] trDamageArr = dmHypertensionConclusion.getTrDamage().split(",");
					for (int i = 0; i < trDamageArr.length; i++) {
						switch (trDamageArr[i]) {
						case "1":
							model.addAttribute("trDamageArr0", 1);
							break;
						case "2":
							model.addAttribute("trDamageArr1", 2);
							break;
						case "3":
							model.addAttribute("trDamageArr2", 3);
							break;
						case "4":
							model.addAttribute("trDamageArr3", 4);
							break;
						case "5":
							model.addAttribute("trDamageArr4", 5);
							break;
						case "6":
							model.addAttribute("trDamageArr5", 6);
							break;
						}
					}
				}
				if (!ObjectUtil.isNullOrEmpty(dmHypertensionConclusion.getRelatedDiseases())) {
					String[] relatedDiseasesArr = dmHypertensionConclusion.getRelatedDiseases().split(",");
					for (int i = 0; i < relatedDiseasesArr.length; i++) {
						switch (relatedDiseasesArr[i]) {
						case "1":
							model.addAttribute("relatedDiseasesArr0", 1);
							break;
						case "2":
							model.addAttribute("relatedDiseasesArr1", 2);
							break;
						case "3":
							model.addAttribute("relatedDiseasesArr2", 3);
							break;
						case "4":
							model.addAttribute("relatedDiseasesArr3", 4);
							break;
						case "5":
							model.addAttribute("relatedDiseasesArr4", 5);
							break;
						case "6":
							model.addAttribute("relatedDiseasesArr5", 6);
							break;
						case "7":
							model.addAttribute("relatedDiseasesArr6", 7);
							break;
						case "8":
							model.addAttribute("relatedDiseasesArr7", 8);
							break;
						case "9":
							model.addAttribute("relatedDiseasesArr8", 9);
							break;
						case "10":
							model.addAttribute("relatedDiseasesArr9", 10);
							break;
						case "11":
							model.addAttribute("relatedDiseasesArr10", 11);
							break;
						case "12":
							model.addAttribute("relatedDiseasesArr11", 12);
							break;
						case "13":
							model.addAttribute("relatedDiseasesArr12", 13);
							break;
						}
					}
				}
			}
		}
		model.addAttribute("planInfo", dmHypertensionConclusion);
		return "rhip.ehr.browser.planInfo";
	}
	
	/**
	 * 获取随访列表
	 * @param personId
	 * @param planYear
	 * @param model
	 * @return
	 */
	@RequestMapping("/manageFollow")
	public String managePlanFollowupList(String personId, String planYear, ModelMap model) {
		Criteria criteria = new Criteria();
		criteria.add("DM_DISEASE_INFO.PERSON_ID", personId);
		List<DmHypertensionFollowup> hypertensionList = brwDiseaseManageService.getDmHypertensionFollowups(criteria);
		List<DmDiabeticFollowup> diabeticList = brwDiseaseManageService.getDmDiabeticFollowups(criteria);
		List<DmTumorFollowup> tumorList = brwDiseaseManageService.getDmTumorFollowups(criteria);
		List<DmStrtumFollowup> strtumList = brwDiseaseManageService.getStrtumFollowups(criteria);
		if(ObjectUtil.isNotEmpty(hypertensionList) || ObjectUtil.isNotEmpty(diabeticList) || ObjectUtil.isNotEmpty(tumorList) || ObjectUtil.isNotEmpty(strtumList)){
			model.addAttribute("hypertensionList", hypertensionList);
			model.addAttribute("diabeticList", diabeticList);
			model.addAttribute("tumorList", tumorList);
			model.addAttribute("strtumList", strtumList);
			return "rhip.ehr.browser.manageFollow";
		}
		return "rhip.ehr.browser.error";
	}


	/**
	 * 随访
	 * @param id
	 * @param type
	 * @param model
	 * @return
	 */
	@RequestMapping("/followUpDetail")
	public String followUpDetail(String id, String type, ModelMap model) {
		Criteria criteria = new Criteria("id", id);
		if(StringUtil.isNotEmpty(type)){
			if(type.equals("1")){
				DmHypertensionFollowup dmHypertensionFollowup = brwDiseaseManageService.getDmHypertensionFollowup(criteria);
				model.addAttribute("hbp", dmHypertensionFollowup);
				return "rhip.ehr.browser.followUpHyp";
			}else if(type.equals("2")){
				DmDiabeticFollowup dmDiabeticFollowup = brwDiseaseManageService.getDmDiabeticFollowup(criteria);
				model.addAttribute("di", dmDiabeticFollowup);
				return "rhip.ehr.browser.followUpDi";
			}else if(type.equals("5")){
				DmTumorFollowup dmTumorFollowup = brwDiseaseManageService.getDmTumorFollowup(criteria);
				model.addAttribute("tumor", dmTumorFollowup);
				return "rhip.ehr.browser.followUpTum";
			}else if(type.equals("3") || type.equals("4")){
				DmStrtumFollowup dmStrtumFollowup = brwDiseaseManageService.getStrtumFollowup(criteria);
				model.addAttribute("strtum", dmStrtumFollowup);
				return "rhip.ehr.browser.followUpStr";
			}
		}
		return "rhip.ehr.browser.error";
	}
}