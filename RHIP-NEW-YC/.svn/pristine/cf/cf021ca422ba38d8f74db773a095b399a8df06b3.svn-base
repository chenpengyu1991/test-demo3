package com.founder.rhip.ehr.controller.populace;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.dto.CommunityInfoDTO;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.PopulaceDTO;
import com.founder.rhip.ehr.entity.basic.OrganizationEconomicRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationOldPeopleHomeRelation;
import com.founder.rhip.ehr.entity.basic.OrganizationSchoolRelation;
import com.founder.rhip.ehr.entity.basic.Populace;
import com.founder.rhip.ehr.service.IPopulaceService;
import com.founder.rhip.ehr.service.orgotherinfo.*;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Populace
 * 
 * By Sean
 */

@Controller
@RequestMapping("/populace")
public class PopulaceController extends BaseController {

	@Resource(name = "populaceService")
	private IPopulaceService populaceService;

	@Resource(name = "orgWaterRelationService")
	private IOrgWaterRelationService orgWaterRelationService;

	@Resource(name = "orgEnvironmentRelationService")
	private IOrgEnvironmentRelationService orgEnvironmentRelationService;

	@Resource(name = "orgEconomicRelationService")
	private IOrgEconomicRelationService orgEconomicRelationService;

	@Resource(name = "orgGarbageRelationService")
	private IOrgGarbageRelationService orgGarbageRelationService;

	@Resource(name = "orgSchoolRelationService")
	private IOrgSchoolRelationService orgSchoolRelationService;

	@Resource(name = "orgOldPeopleHomeRelationService")
	private IOrgOldPeopleHomeRelationService orgOldPeopleHomeRelationService;

	@Autowired
	private IDictionaryApp dictionaryApp;

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest httpServletRequest, ModelMap model) {
		Organization organization = SecurityUtils
				.getCurrentOrganization(httpServletRequest);
		CommunityInfoDTO communityInfoDTO = (CommunityInfoDTO) populaceService
				.getPopulaceByOrganization(organization);
		model.addAttribute("CommunityInfoDTO", communityInfoDTO);
		return "rhip.ehr.populace.index";
	}

	@RequestMapping(value = "/basicInfo")
	public String basicInfo(HttpServletRequest httpServletRequest,
			ModelMap model) {
		Organization organization = SecurityUtils
				.getCurrentOrganization(httpServletRequest);
		CommunityInfoDTO communityInfoDTO = (CommunityInfoDTO) populaceService
				.getBasicInfoByOrganization(organization);

		model.addAttribute("CommunityInfoDTO", communityInfoDTO);
		return "rhip.ehr.populace.basicinfo";
	}

	@RequestMapping(value = "/update")
	public String update(HttpServletRequest request, ModelMap model) {
		createOperationLog(request, RhipModuleName.EHR, "基础信息",
				OperationName.UPDATE);
		CommunityInfoDTO communityInfoDTO = VoUtil.getFormData(request,
				CommunityInfoDTO.class);

		Organization organization = SecurityUtils
				.getCurrentOrganization(request);
		communityInfoDTO.setOrganization(organization);

		// 组织饮用水
		// organizationService.updateOrganization(organization);
		orgWaterRelationService.createOrgWaterRelation(organization
				.getOrganId().intValue(), communityInfoDTO.getWater());
		// 组织环境状况
		orgEnvironmentRelationService.createOrgEnvironmentRelation(organization
				.getOrganId().intValue(), communityInfoDTO.getEnvironment());
		// 组织垃圾回收
		orgGarbageRelationService.createOrgGarbageRelation(organization
				.getOrganId().intValue(), communityInfoDTO.getGarbage());
		// 组织学校
		OrganizationSchoolRelation orgSchoolRelation = new OrganizationSchoolRelation();
		orgSchoolRelation.setOrganizationId(organization.getOrganId()
				.intValue());
		orgSchoolRelation.setSchool(communityInfoDTO.getSchool());
		orgSchoolRelationService.createOrgSchoolRelation(orgSchoolRelation);
		// 组织经济值
		OrganizationEconomicRelation orgEconomicRelation = new OrganizationEconomicRelation();
		orgEconomicRelation.setOrganizationId(organization.getOrganId().intValue());
		orgEconomicRelation.setEconomic(communityInfoDTO.getEconomic());
		orgEconomicRelationService.createOrgEconomicRelation(orgEconomicRelation);
		// 组织养老院
		OrganizationOldPeopleHomeRelation orgOldPeopleHomeRelation = new OrganizationOldPeopleHomeRelation();
		orgOldPeopleHomeRelation.setOrganizationId(organization.getOrganId().intValue());
		orgOldPeopleHomeRelation.setOldPeopleHome(communityInfoDTO.getOldPeopleHome());
		orgOldPeopleHomeRelationService.createOrgOldPeopleHomeRelation(orgOldPeopleHomeRelation);

		// populaceService.saveOrUpdatePopulace(communityInfoDTO.toPopulace());
		return "redirect:/populace/basicInfo";
	}

	@RequestMapping(value = "/populaceUpdate")
	public String populaceUpdate(HttpServletRequest request, Model model) {
		createOperationLog(request, RhipModuleName.EHR, "人口分布信息", OperationName.UPDATE);
		PopulaceDTO populaceDTO = VoUtil.getFormData(request, PopulaceDTO.class);
		List<Populace> populaceList = populaceDTO.getStationPopulaceList();
		String gBCode = populaceDTO.getGbCode();
		String organCode = populaceDTO.getOrganCode();
		String countYear=populaceDTO.getCountYear();
		String[] properties = {"householdPhbNum","unhouseholdPhbNum",
				"householdDiNum","unhouseholdDiNum",
				"householdMentalNum","unhouseholdMentalNum",
				"organName", "countYear", "organCode",
				"householdNum", "unHouseHoldNum", "householdManNum",
				"unHouseholdManNum", "householdWomanNum",
				"unHouseholdWomanNum", "householdSixChildNum",
				"unHouseholdSixChildNum", "householdFertileWomanNum",
				"unHouseholdFertileWomanNum", "householdSixoToSixfNum",
				"unHouseholdSixoToSixfNum", "householdGreatSixfNum",
				"unHouseholdGreatSixfNum", "gbcode", "organParentCode","familyNum" };
		if (null != populaceList && populaceList.size() > 0) {
			populaceService.updateOrSavePopulace(populaceList, properties, gBCode, organCode);
		}
		List<Populace> stationpopulaceList = populaceService.getOrganizationPopulaceListByYear(gBCode,organCode,countYear);
		model.addAttribute("stationPopulaceList", stationpopulaceList);
		return "rhip.ehr.record.sanitaryBureau.popstationDistribution";
	}

	@RequestMapping(value = "/popDistribution")
	public String popDistribution(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		model.addAttribute("userGbCode", currentLoginInfo.getOrganization().getGbCode());
		return "rhip.ehr.record.sanitaryBureau.popDistribution";
	}
	
	@RequestMapping(value = "/popChange")
	public String getPopChangeData(@RequestParam(value="gbCode",required=false)String gbCode, @RequestParam(value="organCode",required=false)String organCode,
			@RequestParam(value="countYear",required=false)String countYear,HttpServletRequest request, ModelMap model) {
		if(ObjectUtil.isNullOrEmpty(gbCode) && ObjectUtil.isNullOrEmpty(organCode)){
			Organization organization = SecurityUtils.getCurrentOrganization(request);
			if(ObjectUtil.isNotEmpty(organization)){
				organCode = organization.getOrganCode();
			}
		}
		List<Populace> populaceList = populaceService.getOrganizationPopulaceListByYear(gbCode,organCode,countYear);
		model.addAttribute("stationPopulaceList", populaceList);
		return "rhip.ehr.record.sanitaryBureau.popstationDistribution";
	}

	/**
	 * 人口统计 查询
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/popTarget")
	public String searchPopTarget(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentBeginDate", new Date());
		return "rhip.ehr.record.sanitaryBureau.popTarget.search";
	}
	
	/**
	 * 人口统计结果
	 * @param gbCode 镇
	 * @param
	 * @param
	 * @param genreCode 机构类型
	 * @param gbCodeOrg 若选择的是按中心  这个值就是镇-中心中的镇code
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/popTargetList")
	public String getPopTarget(String gbCode, String organCode, Integer countYear,String genreCode,String gbCodeOrg,
			HttpServletRequest request, ModelMap model) {
		//因为前面有两个镇的下拉列表 这边特殊处理一下
		if(ObjectUtil.isNotEmpty(gbCodeOrg)){
			gbCode = gbCodeOrg;
		}
		List<Populace> populaceList = populaceService.getTarget(gbCode, organCode, countYear, genreCode);
//		for(Populace populace : populaceList){
//			populace.setHouseholdPhbNum((int)Math.floor(populace.getHouseholdNum()*0.172));
//			populace.setHouseholdDiNum((int)Math.floor(populace.getHouseholdNum()*0.04));
//			populace.setHouseholdMentalNum((int)Math.floor(populace.getHouseholdNum()*0.036));
//		}
		
		if(ObjectUtil.equals(genreCode, "0") && ObjectUtil.isNullOrEmpty(gbCode)
				&& ObjectUtil.isNotEmpty(populaceList)) {
			//将合计的数据放在列表的最后  目的是让页面更友好
			Populace totalPop = populaceList.get(populaceList.size()-1);
			populaceList.remove(populaceList.size()-1);
			//获取所有的镇
			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
			List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
			for(DicItem dicItem : dicItems) {
				boolean flag = true;
				for(Populace populace : populaceList) {
					if(ObjectUtil.equals(populace.getOrganCode(), dicItem.getItemCode())) {
						flag = false;
					}
				}
				if(flag) {
					Populace populace = new Populace();
					populace.setOrganCode(dicItem.getItemCode());
					populaceList.add(populace);
				}
			}
			populaceList.add(totalPop);
		}
		
		model.addAttribute("stationPopulaceList", populaceList);
		model.addAttribute("genreCode", genreCode);
		return "rhip.ehr.record.sanitaryBureau.popTarget.list";
	}
	
	@RequestMapping(value = "/healthManagementPop")
	public String healthPopDistribution(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
        Organization organization=getCurrentOrg(request);
        model.addAttribute("organization", organization);
		return "rhip.ehr.record.healthManagement.popDistribution";
	}

	@RequestMapping(value = "/healthManagementPopData")
	public String getHealthManagementPopulaceListByYear(HttpServletRequest request, ModelMap model) {
		Organization organization = SecurityUtils.getCurrentOrganization(request);
		List<Populace> populaceList = populaceService.getHealthManagementPopulaceListByYear(organization.getOrganCode());
		model.addAttribute("healthManagementPopList", populaceList);
		return "rhip.ehr.record.healthManagement.popstationDistribution";
	}

}
