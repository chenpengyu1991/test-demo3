package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.CdmParamCode;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.ehr.repository.basic.IStandParameterCfgDao;
import com.founder.rhip.ehr.repository.management.*;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 高危人群Service User: Andy Date: 13-3-12 Time: 下午3:35
 */
@Service
public class HighRiskServiceImpl extends AbstractService implements IHighRiskService {
	@Resource
	private IDmHighriskPersonInfoDao dmHighriskPersonInfoDao;

	@Resource
	private IDmHighriskRiskFactorsDao dmHighriskFactorsDao;

	@Resource
	private IDmHighriskManagePlanDao dmHighriskManagePlanDao;

	@Resource
	private IDmHighriskFollowupDao dmHighriskFollowupDao;

	@Resource
	private IDmHighriskConclusionDao dmHighriskConclusionDao;

	@Resource
	private IDmPotentialPersonInfoDao dmPotentialPersonInfoDao;
	
	@Resource
	private IDmPotentialPersonParamDao dmPotentialPersonParamDao;
	
	@Resource
	private IDMFollowupPlanDao dMFollowupPlanDao;
	
	@Resource
	private IStandParameterCfgDao standParameterCfgDao;
	
	@Override
	public List<DMFollowupPlan> searchDmFollowupPlan(Criteria ca, Order order){
		return dMFollowupPlanDao.getList(ca, order);	
	}
	@Override
	public DMFollowupPlan searchDmFollowupPlanInfo(Criteria ca){
		return dMFollowupPlanDao.get(ca);	
	}
	/**
	 * 获取纳入管理潜在人群列表
	 * @param criteria page
	 * @return personList 
	 */
	@Override
	public List<DmPotentialPersonInfo> searchPotentialPerson(Criteria criteria, Page page) {
		PageList<DmPotentialPersonInfo> personInfoList = dmPotentialPersonInfoDao.getNotIntoPatientInfo(page, criteria);
		List<StandParameterCfg> standParameterCfgList = standParameterCfgDao.getList(new Criteria("standardCode", CdmParamCode.FIRST_CLASS_STANDARD.getValue()));
		Set<String> parameterCode = new HashSet<String>();
		for (StandParameterCfg standParameterCfg : standParameterCfgList) {
			parameterCode.add(standParameterCfg.getParameterCode());
		}
		List<DmPotentialPersonInfo> personList = personInfoList.getList();
		for (DmPotentialPersonInfo dmPotentialPersonInfo : personList) {
			List<DmPotentialPersonParam> firstClassStandard = new ArrayList<DmPotentialPersonParam>();
			List<DmPotentialPersonParam> secondClassStandard = new ArrayList<DmPotentialPersonParam>();
			Criteria ca = new Criteria("personId",dmPotentialPersonInfo.getPersonId());
			List<DmPotentialPersonParam> dmpotentialPersonParam = dmPotentialPersonParamDao.getList(ca);
			if(ObjectUtil.isNotEmpty(dmpotentialPersonParam)){
				for(int i=0;i<dmpotentialPersonParam.size();i++){
					dmpotentialPersonParam.get(i).setResultValue(dmpotentialPersonParam.get(i).getResultValue().replace(",", "~"));
					if(parameterCode.contains(dmpotentialPersonParam.get(i).getParameterId())){
						firstClassStandard.add(dmpotentialPersonParam.get(i));
					}else{
						secondClassStandard.add(dmpotentialPersonParam.get(i));
					}
				}
				dmPotentialPersonInfo.setFirstClassStandard(firstClassStandard);
				dmPotentialPersonInfo.setSecondClassStandard(secondClassStandard);
			}
		}
		return personList;
	}
	
	/**
	 * 个人危险因素查看
	 * @param criteria page
	 * @return personList
	 */
	@Override
	public DmPotentialPersonInfo searchPreventionPersonnelInfo(Long personId){
		Criteria criteria = new Criteria("personId",personId);
		List<StandParameterCfg> standParameterCfgList = standParameterCfgDao.getList(new Criteria("standardCode", CdmParamCode.FIRST_CLASS_STANDARD.getValue()));
		DmPotentialPersonInfo personInfo = dmPotentialPersonInfoDao.get(criteria);
		Set<String> parameterCode = new HashSet<String>();
		for (StandParameterCfg standParameterCfg : standParameterCfgList) {
			parameterCode.add(standParameterCfg.getParameterCode());
		}
		List<DmPotentialPersonParam> firstClassStandard=new ArrayList<DmPotentialPersonParam>();
		List<DmPotentialPersonParam> secondClassStandard=new ArrayList<DmPotentialPersonParam>();
		List<DmPotentialPersonParam> dmpotentialPersonParam = dmPotentialPersonParamDao.getList(criteria);
		if(ObjectUtil.isNotEmpty(dmpotentialPersonParam)){
			for(int i=0;i<dmpotentialPersonParam.size();i++){
				dmpotentialPersonParam.get(i).setResultValue(dmpotentialPersonParam.get(i).getResultValue().replace(",", "~"));
				if(parameterCode.contains(dmpotentialPersonParam.get(i).getParameterId())){
					firstClassStandard.add(dmpotentialPersonParam.get(i));
				}else{
					secondClassStandard.add(dmpotentialPersonParam.get(i));
				}
			}
			personInfo.setFirstClassStandard(firstClassStandard);
			personInfo.setSecondClassStandard(secondClassStandard);
		}
		return personInfo;	
	}
	/**
	 * 将患者信息纳入到高危人群中
	 * @param criteria personInfo
	 * @return highriskPersonInfo
	 */
	@Override
	public DmHighriskPersonInfo intoHighRiskGroup(Criteria ca, PersonInfo personInfo) {
		DmHighriskPersonInfo highriskPersonInfo = new DmHighriskPersonInfo();
		DmHighriskRiskFactors riskFactorsInfo = dmHighriskFactorsDao.get(ca);
		if (ObjectUtil.isNotEmpty(riskFactorsInfo)) {
			highriskPersonInfo.setDmhighriskRiskFactors(riskFactorsInfo);
		}
		DmHighriskPersonInfo dmPersonInfo = dmHighriskPersonInfoDao.get(ca);
		if (ObjectUtil.isNotEmpty(dmPersonInfo)) {
			if (dmPersonInfo.getId() != null) {
				highriskPersonInfo.setId(dmPersonInfo.getId());
			}
		}
		highriskPersonInfo.setPersonId(personInfo.getId());
		highriskPersonInfo.setIdcard(personInfo.getIdcard());
		highriskPersonInfo.setName(personInfo.getName());
		highriskPersonInfo.setGender(personInfo.getGender());
		highriskPersonInfo.setPhoneNumber(personInfo.getPhoneNumber());
		highriskPersonInfo.setBirthday(personInfo.getBirthday());
		highriskPersonInfo.setPastreet(personInfo.getPastreet());
		highriskPersonInfo.setPatownShip(personInfo.getPatownShip());
		highriskPersonInfo.setPahouseNumber(personInfo.getPahouseNumber());
		highriskPersonInfo.setUnitName(personInfo.getUnitName());
		highriskPersonInfo.setPageMark("intoManagePage");
		return highriskPersonInfo;
	}
	/**
	 * 管理计计划制定阶段下拉菜单
	 * @param  managePlanInfo
	 * @return gradations
	 */
	@Override
	public List<String> selectMenuStage(DmHighriskManagePlan managePlanInfo) {
		Criteria criteria = new Criteria("personId",managePlanInfo.getPersonId());
		DmHighriskPersonInfo dmHighriskPersonInfo = dmHighriskPersonInfoDao.get(criteria);
		Integer par = new Integer(dmHighriskPersonInfo.getRiskLevel());
		String currentYear = String.valueOf(DateUtil.getCurrentYear());
		String year = managePlanInfo.getYear();
		int riskLevel = par.intValue();
		int risknumber = riskLevel == 3?riskLevel+1:riskLevel;
		if(!year.equals(currentYear)){
			risknumber = 4;
		}
		List<String> gradations = new ArrayList<>();
		for(int i=1;i<=risknumber;i++){
			gradations.add(String.valueOf(i));
		}
		criteria.add("year",managePlanInfo.getYear());
		List<DmHighriskManagePlan> managePlanList = dmHighriskManagePlanDao.getList(criteria);
		if(ObjectUtil.isNotEmpty(managePlanList)){
			for (DmHighriskManagePlan dmHighriskManagePlan : managePlanList) {
				gradations.remove(dmHighriskManagePlan.getGradation());
			}
		}
		return gradations;
	}
	/**
	 * 根据管理计划阶段制定随访记录  下拉菜单选择
	 * @param  managePlanInfo
	 * @return gradations
	 */
	@Override
	public List<String> chooseManageStage(DmHighriskFollowup followupInfo){
		Criteria criteria = new Criteria("personId",followupInfo.getPersonId());
		criteria.add("year",followupInfo.getYear());
		List<DmHighriskManagePlan>managePlanList = dmHighriskManagePlanDao.getList(criteria);
		List<String> gradations = new ArrayList<>();
		if(ObjectUtil.isNotEmpty(managePlanList)){
			for (DmHighriskManagePlan dmHighriskManagePlan : managePlanList) {
				gradations.add(dmHighriskManagePlan.getGradation());
			}
		}else{
			gradations.add("notExist");
		}
		List<DmHighriskFollowup> followupList = dmHighriskFollowupDao.getList(criteria);
		if(ObjectUtil.isNotEmpty(followupList)){
			for (DmHighriskFollowup dmHighriskFollowup : followupList) {
				gradations.remove(dmHighriskFollowup.getGradation().toString());
			}
		}
		Collections.sort(gradations);
		return gradations;	
	}
	/**
	 * 高危纳入管理 判断是否已纳入
	 * @param criteria
	 * @return personInfo
	 */
	@Override
	public DmPotentialPersonInfo intoManage(Criteria criteria) {
		DmPotentialPersonInfo personInfo = dmPotentialPersonInfoDao.get(criteria);
		return personInfo;
	}
	/**
	 * 获取潜在患者信息
	 * @param criteria
	 * @return
	 */
	@Override
	public DmPotentialPersonInfo getPotentialInfo(Criteria criteria) {
		DmPotentialPersonInfo personInfo = dmPotentialPersonInfoDao.get(criteria);
		return personInfo;
	}
	/**
	 * 获取纳入管理患者列表
	 * @param criteria page          
	 * @return personInfoList
	 */
	@Override
	public PageList<DmHighriskPersonInfo> getPersonList(Page page, Criteria criteria, Organization organization, RoleType roleType) {
		setDmHighRiskPersonInfoParam(organization,roleType,criteria);
		PageList<DmHighriskPersonInfo> personInfoList = dmHighriskPersonInfoDao.getPageList(page, criteria);
		return personInfoList;
	}
	private void setDmHighRiskPersonInfoParam(Organization organization, RoleType roleType, Criteria criteria) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		if (RoleType.ZMB.equals(roleType)) {
			criteria.add("CREATE_ORGAN_CODE", organization.getOrganCode());
		}
	}
	/**
	 * 患者信息
	 * @param criteria
	 * @return dhrpi
	 */
	@Override
	public DmHighriskPersonInfo getPerson(Criteria criteria) {
		DmHighriskPersonInfo dhrpi = dmHighriskPersonInfoDao.get(criteria);
		return dhrpi;
	}
	/**
	 * 获得某患者危险因素信息
	 * @param criteria
	 * @return dhrf
	 */
	@Override
	public DmHighriskRiskFactors getRiskFactorsInfo(Criteria criteria) {
		DmHighriskRiskFactors dhrf = dmHighriskFactorsDao.get(criteria);
		return dhrf;
	}
	/**
	 * 检查是否纳入管理
	 * @param personId
	 * @return String
	 */
	@Override
	public String checkIntoManage(Long personId){
		if(ObjectUtil.isNullOrEmpty(personId)){
			return "operationFails";
		}
		Criteria criteria = new Criteria("personId",personId);
		DmHighriskPersonInfo dmPersonInfo = dmHighriskPersonInfoDao.get(criteria);
		if(ObjectUtil.isNotEmpty(dmPersonInfo)){
			if(dmPersonInfo.getRiskManageStatus() != null){
				return "intoManageAgain";
			}else{
				return "alreadyIntoManage";
			}
		}
		return "intoManageCard";
	}
	/**
	 * 保存危险因素填写的信息
	 * @param personInfo  properties  
	 * @return status
	 */
	public String saveIntoManage(DmHighriskPersonInfo personInfo, Organization organization) {
		String checkedStatus = checkIntoManage(personInfo.getPersonId());
		if("intoManageAgain".equals(checkedStatus)){
			boolean status=saveOrupdate(personInfo,organization);
			if(status){
				dmPotentialPersonInfoDao.delete(new Criteria("personId",personInfo.getPersonId()));
			}
			return status ? "intoManageSuccess" : "intoManagefailure";
		}else if("alreadyIntoManage".equals(checkedStatus)){
			return "intoManagefailure";
		}else if("operationFails".equals(checkedStatus)){
			return "operationFails";
		}
		personInfo.setId(null);
		boolean status = saveOrupdate(personInfo,organization);
		if(status){
			dmPotentialPersonInfoDao.delete(new Criteria("personId",personInfo.getPersonId()));
		}
		return status ? "intoManageSuccess" : "intoManagefailure";
	}
	/**
	 * 保存管理卡
	 * @param personInfo    
	 * @return 
	 */
	@Override
	public boolean saveRiskFactors(DmHighriskPersonInfo personInfo, Organization organization) {
		if (ObjectUtil.isNotEmpty(personInfo.getId())) {
			if (ObjectUtil.isNullOrEmpty(personInfo.getId())) {
				return false;
			}
		}
		return saveOrupdate(personInfo,organization);
	}
	/**
	 * 某患者的所有的随访记录
	 * @param criteria
	 * @return List<DmHighriskFollowup>
	 */
	@Override
	public List<DmHighriskFollowup> getFollowupPlanList(Criteria criteria) {
		List<DmHighriskFollowup> followUpList = dmHighriskFollowupDao.getList(criteria);
		return followUpList;
	}
	/**
	 * 随访管理中显示已建管理计划的患者列表
	 * @param dmHighriskPersonInfo page Ages         
	 * @return personInfoList
	 */
	@Override
	public PageList<DmHighriskPersonInfo> getFollowPersonList(DmHighriskPersonInfo dmHighriskPersonInfo, Page page, Date[] Ages, Organization organization, RoleType roleType) {
		PageList<DmHighriskPersonInfo> personInfoList = dmHighriskPersonInfoDao.getFollowPersonList(dmHighriskPersonInfo, page, Ages,organization,roleType);
		return personInfoList;
	}
	/**
	 * 随访记录
	 * @param criteria
	 * @return followUpInfo
	 */
	@Override
	public DmHighriskFollowup getFollowup(Criteria criteria) {
		DmHighriskFollowup followUpInfo = dmHighriskFollowupDao.get(criteria);
		return followUpInfo;
	}
	/**
	 * 保存随访记录
	 * @param dmHighriskFollowup
	 * @return boolean
	 */
	@Override
	public String saveFollowupPlan(DmHighriskFollowup dmHighriskFollowup) {
		if(ObjectUtil.isNullOrEmpty(dmHighriskFollowup.getDmFollowupPlan())){
			return "operateFailure";
		}else if(ObjectUtil.isNullOrEmpty(dmHighriskFollowup.getDmFollowupPlan().getId())){
			return "failure";
		}
		if(ObjectUtil.isNotEmpty(dmHighriskFollowup.getId())){
			dmHighriskFollowupDao.update(dmHighriskFollowup);
		} else {
			Number id = dmHighriskFollowupDao.generatedKey(dmHighriskFollowup, "ID", null);
			DMFollowupPlan dmFollowupPlan=new DMFollowupPlan();
			dmFollowupPlan.setFollowupId(id.longValue());
			dmFollowupPlan.setFollowupDate(dmHighriskFollowup.getVisitDate());
			dmFollowupPlan.setId(dmHighriskFollowup.getDmFollowupPlan().getId());
			String[] properties = {"followupId","followupDate"};
			dMFollowupPlanDao.update(dmFollowupPlan, properties);
		}
		return "success";
	
//		if (dmHighriskFollowup.getId() != null) {
//			// 根据年度和personId判断是否已存在该计划
//			List<DmHighriskFollowup> planInfoList = dmHighriskFollowupDao.getList(criteria);
//			for (int i = 0; i < planInfoList.size(); i++) {
//				if (!(dmHighriskFollowup.getId()).equals(planInfoList.get(i).getId())) {
//					if ((planInfoList.get(i).getGradation()).equals(dmHighriskFollowup.getGradation())) {
//						return "failure";
//					}
//				}
//			}
//			dmHighriskFollowupDao.update(dmHighriskFollowup);
//			return "success";
//		} else {
//			criteria.add("gradation", dmHighriskFollowup.getGradation());
//			List<DmHighriskFollowup> followupList = dmHighriskFollowupDao.getList(criteria);
//			if (ObjectUtil.isNotEmpty(followupList)) {
//				return "failure";
//			} else {
//				dmHighriskFollowupDao.insert(dmHighriskFollowup);
//				return "success";
//			}
//		}
	}
	/**
	 * 删除随访记录
	 * @param criteria
	 * @return boolean
	 */
	@Override
	public boolean removeFollowUpPlan(Criteria criteria) {
		dmHighriskFollowupDao.delete(criteria);
		return true;
	}
	/**
	 * 保存/修改随访评论
	 * @param criteria
	 * @return boolean
	 */
	@Override
	public String saveFollowupConclusion(DmHighriskRiskFactors dmHighriskRiskFactors, DmHighriskConclusion dmHighriskConclusion) {
		//管理评价信息跟选项卡首页信息同步
//		DmHighriskRiskFactors riskFactorInfo = dmHighriskFactorsDao.get(new Criteria("personId",dmHighriskConclusion.getPersonId()));
//		if(ObjectUtil.isNotEmpty(riskFactorInfo.getPersonId())){
//			dmHighriskRiskFactors.setId(riskFactorInfo.getId());
//		}
		if(ObjectUtil.isNotEmpty(dmHighriskConclusion.getId())){
			if (dmHighriskConclusion.getFactorId() != null) {
				dmHighriskRiskFactors.setId(dmHighriskConclusion.getFactorId());
			}
			dmHighriskFactorsDao.update(dmHighriskRiskFactors);
			dmHighriskConclusionDao.update(dmHighriskConclusion);
			continueToManageStatus(dmHighriskConclusion);
			return "success";
		}else{
			boolean status = validateFollowupCount(dmHighriskRiskFactors,dmHighriskConclusion);
			if(!status){
				return "forbidBuild";
			}
			Criteria criteria = new Criteria("personId",dmHighriskConclusion.getPersonId());
			criteria.add("year",dmHighriskConclusion.getYear());
			DmHighriskConclusion conclusionInfo = dmHighriskConclusionDao.get(criteria);
			if(ObjectUtil.isNotEmpty(conclusionInfo)){
				return "failure";
			}
//			dmHighriskFactorsDao.update(dmHighriskRiskFactors);
			Long fid = dmHighriskFactorsDao.generatedKey(dmHighriskRiskFactors, "ID", null).longValue();
			dmHighriskConclusion.setFactorId(fid);
			dmHighriskConclusionDao.insert(dmHighriskConclusion);
			continueToManageStatus(dmHighriskConclusion);
			return "success";
		}
	}
	/**
	 * 获得所有管理评价信息
	 * @param criteria
	 * @return conclusionList
	 */
	@Override
	public List<DmHighriskConclusion> getConclusionList(Criteria criteria) {
		List<DmHighriskConclusion> conclusionList = dmHighriskConclusionDao.getList(criteria);
		return conclusionList;
	}
	/**
	 * 管理评价
	 * @param criteria
	 * @return conclusionList
	 */
	@Override
	public DmHighriskConclusion getConclusion(Criteria criteria) {
		DmHighriskConclusion conclusionInfo = dmHighriskConclusionDao.get(criteria);
		return conclusionInfo;
	}
	/**
	 * 删除管理评价
	 * @param criteria
	 * @return
	 */
	@Override
	public void removeConclusionPlan(Criteria criteria) {
		dmHighriskConclusionDao.delete(criteria);
	}
	/**
	 * 获得某患者所有管理计划
	 * @param criteria
	 * @return dhmpList
	 */
	@Override
	public List<DmHighriskManagePlan> getManagePalnList(Criteria criteria) {
		List<DmHighriskManagePlan> dhmpList = dmHighriskManagePlanDao.getList(criteria);
		return dhmpList;
	}
//	/**
//	 * 管理计划信息提示
//	 * @param dmHighriskManagePlan
//	 * @return map
//	 */
//	@Override
//	public Map<String, Integer> messageAlert(DmHighriskManagePlan dmHighriskManagePlan){
//		Criteria criteria = new Criteria("personId",dmHighriskManagePlan.getPersonId());
//		DmHighriskPersonInfo dmHighriskPersonInfo = dmHighriskPersonInfoDao.get(criteria);
//		Integer riskLevel = dmHighriskPersonInfo.getRiskLevel();
//		Integer manageCount = dmHighriskManagePlanDao.getCount(criteria, "id", Integer.class);
//		criteria.add("year",String.valueOf(DateUtil.getCurrentYear()));
//		Integer currentManageCount = dmHighriskManagePlanDao.getCount(criteria, "id", Integer.class);
//	    Map<String, Integer> map  =  new HashMap<String,Integer>();
//	    map.put("riskLevel", riskLevel);
//	    map.put("manageCount", manageCount);
//	    map.put("currentManageCount", currentManageCount);
//	    return map;
//	}
	/**
	 * 加载管理计划默认值 控制年份选择
	 * @param dmHighriskManagePlan
	 * @return map
	 */
	@Override
	public Map<String,Object> loadManageDefaultValues(DmHighriskManagePlan dmHighriskManagePlan, String currentUser){
		//限制管理计划年度选择
//		DmHighriskPersonInfo personInfo = dmHighriskPersonInfoDao.get(new Criteria("personId",dmHighriskManagePlan.getPersonId()));
//		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy");        
//		String startYear = formatDate.format(personInfo.getCreateDate());
//		String startYear = String.valueOf(DateUtil.getCurrentYear());
//		String endYear =  String.valueOf(DateUtil.getCurrentYear()+1);
		
		String startYear = DateUtil.toDateString(new Date(), "yyyy-MM-dd");
		String endYear =  DateUtil.toDateString(DateUtil.getYearsLater(new Date(), 1), "yyyy-MM-dd");
		String currentYear = String.valueOf(DateUtil.getCurrentYear());
		//加载管理计划列表时默认加载管理卡首页危险因素信息
//		DmHighriskRiskFactors dmHighriskRiskFactors = dmHighriskFactorsDao.get(new Criteria("personId",dmHighriskManagePlan.getPersonId()));
		DmHighriskManagePlan managePlanInfo = new DmHighriskManagePlan();
		managePlanInfo.setPersonId(dmHighriskManagePlan.getPersonId());
//		managePlanInfo.setBodyMassIndex(dmHighriskRiskFactors.getBodyMassIndex());
//		if("1".equals(dmHighriskRiskFactors.getDailyEatFishFlag())){
//			managePlanInfo.setDailyFish(8);
//		}
//		managePlanInfo.setDailySmoke(dmHighriskRiskFactors.getDailySmoke());
//		managePlanInfo.setWaostline(dmHighriskRiskFactors.getWaostline());
//		managePlanInfo.setWeeklyTrain(dmHighriskRiskFactors.getWeeklyTrain());
//		managePlanInfo.setWeeklyDrinnk(dmHighriskRiskFactors.getWeeklyDrinnk());
//		managePlanInfo.setTc(dmHighriskRiskFactors.getTc());
//		managePlanInfo.setTriglycerideValue(dmHighriskRiskFactors.getTriglycerideValue());
		managePlanInfo.setYear(currentYear);
		managePlanInfo.setCreateDate(new Date());
		managePlanInfo.setCreateDoctorCode(currentUser);
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.DAY_OF_MONTH, 1);
//		managePlanInfo.setNextVisitDate(cal.getTime());
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("startYear", startYear);
		map.put("endYear", endYear);
		map.put("managePlanInfo", managePlanInfo);
		return map;
	}
	/**
	 * 获得管理计划
	 * @param criteria
	 * @return dhmpList
	 */
	@Override
	public DmHighriskManagePlan getManagePlan(Criteria criteria) {
		DmHighriskManagePlan dhmpInfo = dmHighriskManagePlanDao.get(criteria);
		return dhmpInfo;
	}
	/**
	 * 管理计划新增、修改
	 * @param criteria dmHighriskManagePlan
	 * @return String
	 */
	@Override
	public String saveManagePlan(DmHighriskManagePlan dmHighriskManagePlan, Criteria criteria) {
		//去年未完成随访记录不能保存和制定下一年计划，随访日期必须大约去年最后一次随访日期
		int lastYear = Integer.parseInt(dmHighriskManagePlan.getYear())-1;
		String year = String.valueOf(lastYear);
		Criteria cri = new Criteria("personId",dmHighriskManagePlan.getPersonId());
		cri.add("planYear",year);
		cri.add("disType",6);
		List<DMFollowupPlan> dmfpdList = dMFollowupPlanDao.getList(cri);
		if(ObjectUtil.isNotEmpty(dmfpdList)){
			cri.add("followupId", OP.UEMPTY,null);
			Long dmfpdCount = dMFollowupPlanDao.getCount(cri, "id", Long.class);
			if(dmfpdCount>0){
				cri.remove("followupId");
				Long followupId = dMFollowupPlanDao.getMax(cri, "id", Long.class);
				if(ObjectUtil.isNotEmpty(followupId)){
					DMFollowupPlan dmFollowupPlanInfo = dMFollowupPlanDao.get(new Criteria("id",followupId));
					int a = dmHighriskManagePlan.getNextVisitDate().compareTo(dmFollowupPlanInfo.getPlanDate());
					if(a<0){
						return "errorFollowupDate";
					}
				}
			}else{
				return "followupRecordUnfinished";
			}
		}
		//修改如果该计划已建随访记录则随访日期不能修改，若没有建立删掉随访计划重新生成
		if (dmHighriskManagePlan.getId() != null) {
			DmHighriskManagePlan dhmpInfo = dmHighriskManagePlanDao.get(new Criteria("id",dmHighriskManagePlan.getId()));
			String updateYear = dmHighriskManagePlan.getYear();
			if(!updateYear.equals(dhmpInfo.getYear())){
				DmHighriskManagePlan managePlanInfo = dmHighriskManagePlanDao.get(criteria);
				if(ObjectUtil.isNotEmpty(managePlanInfo)){
					return "failure";
				}
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String visitDate = "";
			if(ObjectUtil.isNotEmpty(dhmpInfo.getNextVisitDate())){
				visitDate = sdf.format(dhmpInfo.getNextVisitDate());
			}
			String updateVisitDate = sdf.format(dmHighriskManagePlan.getNextVisitDate());
			if(!visitDate.equals(updateVisitDate)){
				Criteria ca = new Criteria("personId",dhmpInfo.getPersonId());
				ca.add("planYear",dhmpInfo.getYear());
				ca.add("disType",6);
				ca.add("followupId", OP.UEMPTY,null);
				Long followupCount = dMFollowupPlanDao.getCount(ca, "id", Long.class);
				if(followupCount > 0){
					return "alreadyBuildFollowup";
				}
				ca.remove("followupId");
				List<DMFollowupPlan> dmFollowupPlanList = dMFollowupPlanDao.getList(ca);
				for (DMFollowupPlan dmFollowupPlan : dmFollowupPlanList) {
					dMFollowupPlanDao.delete(dmFollowupPlan.getId());
				}
				calculateFollowupPlanDate(dmHighriskManagePlan,dmHighriskManagePlan.getId());
			}
			dmHighriskManagePlanDao.update(dmHighriskManagePlan);
			return "changeSuccess";
		}
		//新建随访计划
		DmHighriskManagePlan dmHighRiskManagePlan = dmHighriskManagePlanDao.get(criteria);
		if(ObjectUtil.isNotEmpty(dmHighRiskManagePlan)){
			return "failure";
		}
		Number id = dmHighriskManagePlanDao.generatedKey(dmHighriskManagePlan, "ID", null);
		return calculateFollowupPlanDate(dmHighriskManagePlan,id);	
	}
	/**
	 * 生成随访计划
	 * @param id dmHighriskManagePlan
	 * @return String
	 */
	private String calculateFollowupPlanDate(DmHighriskManagePlan dmHighriskManagePlan, Number id){
		Criteria cri = new Criteria("personId", dmHighriskManagePlan.getPersonId());
		DmHighriskPersonInfo personInfo = dmHighriskPersonInfoDao.get(cri);
		if(ObjectUtil.isNullOrEmpty(personInfo.getRiskLevel())){
			return "notExistRiskLevel";
		}
		Integer par = new Integer(personInfo.getRiskLevel());
		int riskLevel = par.intValue();
		int levelNum=riskLevel== 3 ? (riskLevel + 1) : riskLevel;
		List<DMFollowupPlan> list = new ArrayList<DMFollowupPlan>();
		Calendar calendar = Calendar.getInstance();
		for(int i=0;i<levelNum;i++){
			DMFollowupPlan dMFollowupPlan = new DMFollowupPlan();
			dMFollowupPlan.setPersonId(dmHighriskManagePlan.getPersonId());
			dMFollowupPlan.setPlanId(id.longValue());
			dMFollowupPlan.setDisType("6");
			dMFollowupPlan.setPlanYear(dmHighriskManagePlan.getYear());
			calendar.setTime(dmHighriskManagePlan.getNextVisitDate());
			if(riskLevel == 1){
				calendar.add(Calendar.MONTH, +12);
			}else if(riskLevel == 2){
				calendar.add(Calendar.MONTH, +6+i*6);
			}else if(riskLevel == 3){
				calendar.add(Calendar.MONTH, +3+i*3);
			}
			dMFollowupPlan.setPlanDate(calendar.getTime());
			list.add(dMFollowupPlan);	
		}
		dMFollowupPlanDao.batchInsert(list);
		return "buildFollowup";
	}
//	if (dmHighriskManagePlan.getId() != null) {
//		List<DmHighriskManagePlan> managePlanList = dmHighriskManagePlanDao.getList(criteria);
//		for (int i = 0; i < managePlanList.size(); i++) {
//			if (!(dmHighriskManagePlan.getId()).equals(managePlanList.get(i).getId())) {
//				if ((managePlanList.get(i).getGradation()).equals(dmHighriskManagePlan.getGradation())) {
//					return "failure";
//				}
//			}
//		}
//		dmHighriskManagePlanDao.update(dmHighriskManagePlan);
//		return "changeSuccess";
//	} else {
//		criteria.add("gradation", dmHighriskManagePlan.getGradation());
//		List<DmHighriskManagePlan> managePlanList = dmHighriskManagePlanDao.getList(criteria);
//		if (ObjectUtil.isNotEmpty(managePlanList)) {
//			return "failure";
//		}
//		return whetherBuilderFollowup(dmHighriskManagePlan);
//	}
	/**
	 * 根据所选状态查询已建/待建管理计划
	 * @param dmHighriskPersonInfo page ageDateRange        
	 * @return personInfoList
	 */
	@Override
	public PageList<DmHighriskPersonInfo> getManagePlanPersonList(DmHighriskPersonInfo dmHighriskPersonInfo, Page page, Date[] ageDateRange, Organization organization, RoleType roleType) {
		PageList<DmHighriskPersonInfo> personInfoList = dmHighriskPersonInfoDao.getManagePlanPersonList(dmHighriskPersonInfo, page, ageDateRange,organization,roleType);
		return personInfoList;
	}
	/**
	 * 删除管理计划
	 * @param criteria
	 * @return boolean
	 */
	@Override
	public boolean removeManagePlan(DmHighriskManagePlan dmHighriskManagePlan, Criteria criteria) {
		DmHighriskFollowup followup = dmHighriskFollowupDao.get(criteria);
		if (ObjectUtil.isNotEmpty(followup)) {
			return false;
		} else {
			dmHighriskManagePlanDao.delete(dmHighriskManagePlan.getId());
		}
		return true;
	}

	/**
	 * 删除管理评价中危险因素
	 * @param criteria
	 * @return boolean
	 */
	@Override
	public void removeRiskFactor(Criteria criteria) {
		dmHighriskFactorsDao.delete(criteria);
	}
	public Map<String, Integer> getFollowCount(){
		Map<String, Integer> result = new HashMap<String, Integer>();
		// 今日
		Criteria criteriaToday = createToFollowupDateRange(EHRConstants.DM_FOLLOWUP_EXPIRE_TODAY);
		Integer todayCount = dMFollowupPlanDao.getCount(criteriaToday, "ID", Integer.class);
		// 本周
		Criteria thisWeekCriteria = createToFollowupDateRange(EHRConstants.DM_FOLLOWUP_EXPIRE_WEEK);
		Integer thisWeekCount = dMFollowupPlanDao.getCount(thisWeekCriteria, "ID", Integer.class);
		// 本月
		Criteria thisMonthCriteria = createToFollowupDateRange(EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH);
		Integer thisMonthCount = dMFollowupPlanDao.getCount(thisMonthCriteria, "ID", Integer.class);
		// 过期
		Criteria expireCriteria = createToFollowupDateRange(EHRConstants.DM_FOLLOWUP_EXPIRE_EXPIRED);
		Integer expireCount = dMFollowupPlanDao.getCount(expireCriteria, "ID", Integer.class);
		// 结果
		result.put("todayCount", todayCount);
		result.put("thisWeekCount", thisWeekCount);
		result.put("thisMonthCount", thisMonthCount);
		result.put("expireCount", expireCount);
		return result;
	}
	private Criteria createToFollowupDateRange(String followupFlag) {
		Date date = getFollowupNextDateRange(followupFlag);
		Criteria followupDate = new Criteria("disType",6);
		followupDate.add("planDate", OP.LE, date);
		followupDate.add("followupId",null);
		return followupDate;
	}
	private Date getFollowupNextDateRange(String followupFlag) {
		Date date = new Date();
		switch (followupFlag) {
		case EHRConstants.DM_FOLLOWUP_EXPIRE_TODAY:
			date = DateUtil.makeTimeToMax(date);
			break;
		case EHRConstants.DM_FOLLOWUP_EXPIRE_WEEK:
			date = DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.DAY_OF_MONTH, 7));
			break;
		case EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH:
			date = DateUtil.makeTimeToMax(DateUtil.add(date, Calendar.MONTH, 1));
			break;
		case EHRConstants.DM_FOLLOWUP_EXPIRE_EXPIRED:
			date = DateUtil.makeTimeToZero(date);
			break;
		}
		return date;
	}
	/**
	 * 根据危险等级管理计划建完后是否马上建随访记录
	 * @param criteria
	 * @return boolean
	 */
//	private String whetherBuilderFollowup(DmHighriskManagePlan dmHighriskManagePlan) {
//		dmHighriskManagePlanDao.insert(dmHighriskManagePlan);
//		Criteria cri = new Criteria("personId", dmHighriskManagePlan.getPersonId());
//		DmHighriskPersonInfo personInfo = dmHighriskPersonInfoDao.get(cri);
//		Integer par = new Integer(personInfo.getRiskLevel());
//		int riskLevel = par.intValue();
//		String currentYear = String.valueOf(DateUtil.getCurrentYear());
//		String year = dmHighriskManagePlan.getYear();
//		if (year.equals(currentYear)) {
//			cri.add("year", currentYear);
//			List<DmHighriskManagePlan> managePlan = dmHighriskManagePlanDao.getList(cri);
//			if ((riskLevel == 3 ? (riskLevel + 1) : riskLevel) == (managePlan.size())) {
//				return "buildFollowup";
//			} else {
//				return "success";
//			}
//		} else {
//			return "success";
//		}
//	}
	/**
	 * 保存/修改管理卡信息
	 * @param personInfo    
	 * @param organization 
	 * @return 
	 */
	private boolean saveOrupdate(DmHighriskPersonInfo personInfo, Organization organization) {
		String[] properties = { "name", "gender", "birthday", "phoneNumber", "pastreet", "patownShip","pahouseNumber","unitName", "riskLevel", "lcuLevel", "manageAdvice","createDoctorName",
				                "createDate", "factorId","riskManageStatus","paGroup"};
		if(ObjectUtil.isNotEmpty(personInfo)){
			personInfo.setCreateOrganName(organization.getOrganName());
			personInfo.setCreateOrganCode(organization.getOrganCode());
			personInfo.setCreateCenterOrganCode(organization.getParentCode());
			personInfo.setCreateGbcode(organization.getGbCode());
		}
		if (ObjectUtil.isNotEmpty(personInfo.getId())) {
			dmHighriskPersonInfoDao.update(personInfo, properties);
			dmHighriskFactorsDao.update(personInfo.getDmhighriskRiskFactors());
		} else {
			Long fid = dmHighriskFactorsDao.generatedKey(personInfo.getDmhighriskRiskFactors(), "ID", null).longValue();
			personInfo.setFactorId(fid);
			personInfo.setRiskManageStatus("2");//1：已被纳入慢病管理 2：已管理
			dmHighriskPersonInfoDao.insert(personInfo);
		}
		return true;
	}
	/**
	 * 当前年度随访计划和管理计划是否完成
	 * @param dmHighriskRiskFactors dmHighriskConclusion
	 * @return boolean
	 */
//	private boolean validateFollowupCount(DmHighriskRiskFactors dmHighriskRiskFactors, DmHighriskConclusion dmHighriskConclusion){
//		String currentYear = String.valueOf(DateUtil.getCurrentYear());
//		Criteria ca = new Criteria("personId",dmHighriskConclusion.getPersonId());
//		if(currentYear.equals(dmHighriskConclusion.getYear())){
//		DmHighriskPersonInfo dmHighriskPersonInfo = dmHighriskPersonInfoDao.get(ca);
//		    int riskLevel = (dmHighriskPersonInfo.getRiskLevel()).intValue();
//			ca.add("planYear",dmHighriskConclusion.getYear());
//			ca.add("followupId",OP.UEMPTY,null);
//			Integer followupCount = dMFollowupPlanDao.getCount(ca, "id",Integer.class );
//			int num = riskLevel == 3?riskLevel+1:riskLevel;
//			if(ObjectUtil.isNullOrEmpty(followupCount)){
//				return false;
//			}else{
//				if(num!=followupCount.intValue()){
//					return false;
//				}
//			}	
//		}else{
//			ca.add("planYear",dmHighriskConclusion.getYear());
//			List<DMFollowupPlan> followUpList = dMFollowupPlanDao.getList(ca);
//			if(ObjectUtil.isNullOrEmpty(followUpList)){
//				return false;
//			}
//		}
//		return true;
//	}
	private boolean validateFollowupCount(DmHighriskRiskFactors dmHighriskRiskFactors, DmHighriskConclusion dmHighriskConclusion){
		Criteria ca = new Criteria("personId",dmHighriskConclusion.getPersonId());
		ca.add("planYear",dmHighriskConclusion.getYear());
		ca.add("followupId", OP.UEMPTY,null);
		Integer followupCount = dMFollowupPlanDao.getCount(ca, "id",Integer.class );
		if(followupCount > 0){
			return true ;
		}	
		return false;
	}
	@Override
	public Map<String, Object> defaultConclusionValue(DmHighriskConclusion dmHighriskConclusion, String currentUser){
		Map<String, Object> map  =  new HashMap<String,Object>();
		Criteria ca = new Criteria("personId",dmHighriskConclusion.getPersonId());
		List<DmHighriskManagePlan> dmManagePlan = dmHighriskManagePlanDao.getList(ca);
//		String thisYear = String.valueOf(DateUtil.getCurrentYear());
//		String nextYear = String.valueOf(DateUtil.getCurrentYear()+1);
//		String yearAfter= String.valueOf(DateUtil.getCurrentYear()+2);
		DmHighriskConclusion conclusion = new DmHighriskConclusion();
		conclusion.setManageEndData(new Date());
		conclusion.setDoctorCode(currentUser);
		String yearString = "";
		if(ObjectUtil.isNotEmpty(dmManagePlan)){
			for(int i=0;i<dmManagePlan.size();i++){
//				if(thisYear.equals(dmManagePlan.get(i).getYear())){
//					map.put("thisYear", dmManagePlan.get(i).getYear());
//				}else if(nextYear.equals(dmManagePlan.get(i).getYear())){
//					map.put("nextYear", dmManagePlan.get(i).getYear());
//				}else if(yearAfter.equals(dmManagePlan.get(i).getYear())){
//					map.put("yearAfter", dmManagePlan.get(i).getYear());
//				}
				yearString = yearString + dmManagePlan.get(i).getYear() + ",";
			}
		}
		map.put("yearString", yearString);
		Long id = dmHighriskManagePlanDao.getMin(ca,"id",Long.class);
		DmHighriskManagePlan mp = dmHighriskManagePlanDao.get(new Criteria("id",id));
		conclusion.setYear(mp.getYear());
		map.put("conclusion", conclusion);
		return map;
	}
	//高危人群结束管理
	@Override
	@Transactional
	public void highRiskEndManage(Long personId){
		Assert.notNull(personId, "结束管理高危指定人员id不能为空");
		Criteria criteria = new Criteria("personId",personId);
		DmHighriskPersonInfo dmHighriskPersonInfo = dmHighriskPersonInfoDao.get(criteria);
		if(ObjectUtil.isNotEmpty(dmHighriskPersonInfo)){
			String[] properties = {"riskManageStatus"};
			dmHighriskPersonInfo.setRiskManageStatus("1");
			dmHighriskPersonInfoDao.update(dmHighriskPersonInfo, properties);
		}
	}
	//高危人群恢复管理
	@Override
	@Transactional
	public void highRiskRecoverManage(Long personId){
		Assert.notNull(personId, "恢复管理高危指定人员id不能为空");
		Criteria criteria = new Criteria("personId",personId);
		DmHighriskPersonInfo dmHighriskPersonInfo = dmHighriskPersonInfoDao.get(criteria);
		if(ObjectUtil.isNotEmpty(dmHighriskPersonInfo)){
			String[] properties = {"riskManageStatus"};
			dmHighriskPersonInfo.setRiskManageStatus(null);
			dmHighriskPersonInfoDao.update(dmHighriskPersonInfo, properties);
		}
	}
	/**
	 * 管理评论评价 ：是否结束管理  如果结束管理标记状态
	 * @param dmHighriskRiskFactors dmHighriskConclusion
	 * @return boolean
	 */
	private void continueToManageStatus(DmHighriskConclusion dmHighriskConclusion){
		DmHighriskPersonInfo dmHighriskPersonInfo=dmHighriskPersonInfoDao.get(new Criteria("personId",dmHighriskConclusion.getPersonId()));
		String[] properties = {"riskManageStatus"};
		if(ObjectUtil.isNotEmpty(dmHighriskPersonInfo)){
			if("2".equals(dmHighriskConclusion.getContinueManageFlag())){
				dmHighriskPersonInfo.setRiskManageStatus("1");
				dmHighriskPersonInfoDao.update(dmHighriskPersonInfo, properties);
			}	
		}
	}

	/**
	 * 获取危险因素中根据筛查标准的危险因素
	 * @param criteria
	 * @return
	 */
	@Override
	public List<DmPotentialPersonParam> getDmPotentialPersonParams(Criteria criteria) {
		return dmPotentialPersonParamDao.getList(criteria);
	}
}
