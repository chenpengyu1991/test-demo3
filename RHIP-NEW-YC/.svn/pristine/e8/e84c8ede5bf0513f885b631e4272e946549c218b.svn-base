package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.ehr.service.IBrwDiseaseManageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/CDmanage")
public class ManageController extends BaseController{
	
	@Resource
	private IStandardizationService standardizationService;
	
	@Resource
	private IBrwDiseaseManageService brwDiseaseManageService; 
	
	@RequestMapping(value = "/manageIndex")
	public String manageIndex(HttpServletRequest request, ModelMap model) {
		if (!checkLoginStatus(request)) return "lhportal.info.login";
		Long personId = getPersonId(request);
		
		if(personId == null){
			return "lhportal.ehr.brwNoRecord";
		}
		
		Criteria criteria = new Criteria("personId", personId);
		DmDiseaseInfo diseaseInfo = standardizationService.getHmCard(criteria);
		if(null == diseaseInfo){
			return "lhportal.ehr.brwNoRecord";
		}
		model.put("brwDiseaseInfo", diseaseInfo);
		return "lhportal.ehr.manageIndex";
	}
	
	@RequestMapping(value = "/managePlan")
	public String managePlan(HttpServletRequest request, ModelMap model) {
		Long personId = getPersonId(request);
		if(personId == null){
			return "lhportal.ehr.brwNoRecord";
		}
		
		List<DmHypertensionConclusion> dmHypertensionConclusions = brwDiseaseManageService.getDmHypertensionConclusions(new Criteria("personId", personId));
		if(ObjectUtil.isNotEmpty(dmHypertensionConclusions)){
			model.addAttribute("dmHypertensionConclusions", dmHypertensionConclusions);
			return "lhportal.ehr.managePlan";
		}
		return "lhportal.ehr.brwNoRecord";
	}
	
	@RequestMapping(value = "/managePlanInfo")
	public String managePlanInfo(String id, ModelMap model) {
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
		return "lhportal.ehr.managePlanInfo";
	}
	
	@RequestMapping("/manageFollow")
	public String managePlanFollowupList(HttpServletRequest request, ModelMap model) {
		Long personId =  getPersonId(request);
		if(personId == null){
			return "lhportal.ehr.brwNoRecord";
		}
		
		Criteria criteria = new Criteria();
		criteria.add("personId",personId);
		List<DmHypertensionFollowup> hypertensionList = brwDiseaseManageService.getDmHypertensionFollowups(new Criteria("DM_HYPERTENSION_FOLLOWUP.PERSON_ID", personId));
		List<DmDiabeticFollowup> diabeticList = brwDiseaseManageService.getDmDiabeticFollowups(new Criteria("DM_DIABETIC_FOLLOWUP.PERSON_ID", personId));
		List<DmTumorFollowup> tumorList = brwDiseaseManageService.getDmTumorFollowups(new Criteria("DM_TUMOR_FOLLOWUP.PERSON_ID", personId));
		List<DmStrtumFollowup> strtumList = brwDiseaseManageService.getStrtumFollowups(new Criteria("DM_STRTUM_FOLLOWUP.PERSON_ID", personId));
		if(ObjectUtil.isNotEmpty(hypertensionList) || ObjectUtil.isNotEmpty(diabeticList) ||ObjectUtil.isNotEmpty(hypertensionList) ||ObjectUtil.isNotEmpty(strtumList)){
			model.addAttribute("hypertensionList", hypertensionList);
			model.addAttribute("diabeticList", diabeticList);
			model.addAttribute("tumorList", tumorList);
			model.addAttribute("strtumList", strtumList);
			return "lhportal.ehr.manageFollow";
		}
		return "lhportal.ehr.brwNoRecord";
	}
	
	@RequestMapping("/followUpDetail")
	public String followUpDetail(String id, String type, ModelMap model) {
		Criteria criteria = new Criteria("id", id);
		if(StringUtil.isNotEmpty(type)){
			if(type.equals("1")){
				DmHypertensionFollowup dmHypertensionFollowup = brwDiseaseManageService.getDmHypertensionFollowup(criteria);
				model.addAttribute("hbp", dmHypertensionFollowup);
				return "lhportal.ehr.followUpHyp";
			}else if(type.equals("2")){
				DmDiabeticFollowup dmDiabeticFollowup = brwDiseaseManageService.getDmDiabeticFollowup(criteria);
				model.addAttribute("di", dmDiabeticFollowup);
				return "lhportal.ehr.followUpDi";
			}else if(type.equals("5")){
				DmTumorFollowup dmTumorFollowup = brwDiseaseManageService.getDmTumorFollowup(criteria);
				model.addAttribute("tumor", dmTumorFollowup);
				return "lhportal.ehr.followUpTum";
			}else if(type.equals("3") || type.equals("4")){
				DmStrtumFollowup dmStrtumFollowup = brwDiseaseManageService.getStrtumFollowup(criteria);
				model.addAttribute("strtum", dmStrtumFollowup);
				return "lhportal.ehr.followUpStr";
			}
		}
		return "lhportal.ehr.brwNoRecord";
	}
}