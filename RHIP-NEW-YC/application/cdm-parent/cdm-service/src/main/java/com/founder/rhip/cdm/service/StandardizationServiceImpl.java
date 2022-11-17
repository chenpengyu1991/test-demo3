package com.founder.rhip.cdm.service;

import com.alibaba.fastjson.JSON;
import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.cdm.common.ApprovalState;
import com.founder.rhip.cdm.common.ManageCardErrorCode;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.dto.QueryForm;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.dto.ToBringIntoDiseaseInfo;
import com.founder.rhip.ehr.entity.basic.EhrDocLevel;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.cic.CicTarget;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.management.*;
import com.founder.rhip.ehr.repository.statistics.IEhrDocLevelDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ehr.service.ta.ICicTargetService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

/**
 * 规范化管理
 * 
 * @author liuk
 */

@Service("standardizationService")
public class StandardizationServiceImpl extends AbstractService implements IStandardizationService {

	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao dmDiseaseInfoDao;

	@Resource(name = "cdmStatusInfoDao")
	private ICdmStatusInfoDao cdmStatusInfoDao;

	@Resource(name = "dmPersonInfoDao")
	private IDmPersonInfoDao dmPersonInfoDao;

	@Resource(name = "platformService")
	private IPlatformService platformService;

	@Resource(name = "followupRecordService")
	private IFollowupRecordService followupRecordService;

	@Resource(name = "dmReportInfoDao")
	private IDmReportInfoDao dmReportInfoDao;

	@Resource(name = "dmHypertensionConclusionDao")
	private IDmHypertensionConclusionDao dmHypertensionConclusionDao;

	@Autowired
	private DmIcdTenUtil dmIcdTenUtil;

	@Resource(name = "cdmApprovalInfoDao")
	private ICdmApprovalInfoDao cdmApprovalInfoDao;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Resource(name = "cdmPersonService")
	private ICdmPersonService cdmPersonService;

	@Resource(name = "followupPlanService")
	private IFollowupPlanService followupPlanService;

    @Resource(name="cicTargetService")
    private ICicTargetService cicTargetService;

	@Resource(name = "ehrDocLevelDao")
	private IEhrDocLevelDao ehrDocLevelDao;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "dmYiShareDao")
	private IDmYiShareDao yiShareDao;

	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

	@Resource(name = "dmDiseaseInfoLogDao")
	private IDmDiseaseInfoLogDao dmDiseaseInfoLogDao;

	// 公共属性
	private List<String> commonPros = Arrays.asList("id", "personId", "idcard");

	@SuppressWarnings("unused")
	// 疾病类型字段
	private List<String> disTypePros = Arrays.asList("hbpFlag", "diFlag", "strokeFlag", "tumorFlag", "coronaryFlag");

	// 五种慢病字段
	private List<String> hbpPros = new ArrayList<>();
	private List<String> diPros = new ArrayList<>();
	private List<String> strokePros = new ArrayList<>();
	private List<String> tumorPros = new ArrayList<>();
	private List<String> coronaryPros = new ArrayList<>();

	// 新增信息字段
	private List<String> createPros = new ArrayList<>();

	// 更新信息字段
	private List<String> updatePros = new ArrayList<>();

	// 管理卡状态字段,标志注销等
	private final static String STATUS_COLUMN = "status";
	private final static String IS_DELETE_COLUMN = "isDelete";

	// 纳入管理日期字段,在更新时,需要这些字段去掉,不能更新
	private final static String HBP_MANAGED_DATE_COLUMN = "hbpManagedDate";
	private final static String DI_MANAGED_DATE_COLUMN = "diManagedDate";
	private final static String STROKE_MANAGED_DATE_COLUMN = "strokeManagedDate";
	private final static String CORONARY_MANAGED_DATE_COLUMN = "coronaryManagedDate";
	private final static String TUMOR_MANAGED_DATE_COLUMN = "tumorManagedDate";

	/**
	 * Init void.
	 */
	@PostConstruct
	public void init() {
		// 疾病属性
		hbpPros.addAll(Arrays.asList("hbpSelfliveFlag", "hbpDbp", "hbpType", "hbpManageLevel", "hbpDiagnosisDepends", "hbpFlag", "id", "hbpAccidentDate", "hbpVascularFlag", "hbpCerebrovascularFlag", "hbpManagedDate", "hbpDiagnosedOrganCode",
				"hbpHeartFlag", "hbpRetinopathyFlag", "hbpDiagnosedDate", "idcard", "hbpSbp", "hbpDiagnosisDate", "personId", "hbpDiagnosedOrganName", "hbpKidneyFlag", "hbpOtherDiagnosisOrganFlag", "hbpOtherDiagnosisOrganName"));
		diPros.addAll(Arrays.asList("diRtPhyActivityFlag", "diCcomHbpDisDate", "diComDrinkingFlag", "diRtPhyActivityTime", "diCcomNerveDisDate", "diCcomKidneyTreatment", "diRtHypDrugsperDose", "diCcomFootDisDate", "diFlag", "diCcomFootTreatment",
				"diRtQuitSmokingFlag", "diDiagnosisDepends", "diComFpg", "diDiagnosedDate", "diRtInsulinPerDose", "diAccidentDate", "diCcomHbcTreatment", "diCcomFootFlag", "diComKidneyFlag", "diComHbpFlag", "diCcomRetyDisDate",
				"diRtHypDrugsperDoseUnit", "diManagedDate", "diComDiFootFlag", "diCcomNerveFlag", "diCcomCoronaryTreatment", "diRtDoctorCode", "diRtInsulinPerDoseUnit", "diComNeuropathyFlag", "diCcomKidneyFlag", "diRtDietControlFlag",
				"diCcomHbpTreatment", "diCcomHbcFlag", "diRtLimitDrinkingFlag", "diCcomHbpFlag", "id", "diComSmokingFlag", "diDiagnosedWay", "diType", "diCcomCoronaryFlag", "diComRetyFlag", "diComSmokingDailyNum", "diRtPhyActivityWeekCount",
				"diCcomCoronaryDisDate", "diRtHypDrugsDailyCount", "diComHgb", "diCcomRetyFlag", "idcard", "diCcomStrokeFlag", "diCcomStrokeTreatment", "diCcomStrokeDisDate", "diRtDoctorName", "diComDrinkingdailyNum", "diRtInsulinDailyCount",
				"diRtInsulinFlag", "diComStrokeFlag", "personId", "diRtHypDrugsFlag", "diRtInputDate", "diCcomHbcDisDate", "diDiagnosisDate", "diCcomRetypTreatment", "diDiagnosedOrganCode", "diComHbcFlag", "diDiagnosedOrganName",
				"diCcomNerveTreatment", "diCcomKidneyDisDate", "diOtherDiagnosisOrganFlag", "diOtherDiagnosisOrganName"));
		strokePros.addAll(Arrays.asList("strokeFamilyHisFlag", "strokeManagedFlag", "strokeAccidentDate", "strokeBodyLimitFlag", "strokeType", "strokeFlag", "strokeManagedFayFlag", "id", "strokeDiagnosisDate", "strokeDiagnosisDepends", "idcard",
				"personId", "strokeManagedDate"));
		tumorPros.addAll(Arrays.asList("tumorFlag", "tumorManagedFlag", "tumorIcdThreeCode", "tumorIcdTenName", "tumorAccidentDate", "tumorDiagnosisDepends", "tumorManagedDate", "tumorIcdTenCode", "id", "tumorMetastasisPart", "tumorPrimaryPart",
				"idcard", "tumorType", "tumorInformedFlag", "personId", "tumorPathologyType", "tumorDiagnosisDate"));
		coronaryPros.addAll(Arrays.asList("coronaryManagedFayFlag", "coronaryType", "coronaryManagedFlag", "coronaryAccidentDate", "coronaryBodyLimitFlag", "coronaryManagedDate", "coronaryFlag", "id", "coronaryDiagnosisDepends",
				"coronaryDiagnosisDate", "idcard", "coronaryFamilyHisFlag", "personId"));

		// 公共属性
		createPros.addAll(Arrays.asList("createDate", "createOrganName", "createOrganCode", "createDoctorName", "createDoctorCode",
				"hbpCreateDate", "diCreateDate", "strokeCreateDate", "coronaryCreateDate", "tumorCreateDate",
				"hbpCreateOrganCode", "diCreateOrganCode", "strokeCreateOrganCode", "coronaryCreateOrganCode", "tumorCreateOrganCode",
				"hbpCreateDoctorCode", "diCreateDoctorCode", "strokeCreateDoctorCode", "coronaryCreateDoctorCode", "tumorCreateDoctorCode"
		));
		updatePros.addAll(Arrays.asList("updateDate", "updateOrganName", "updateOrganCode", "updateDoctorName", "updateDoctorCode"));
	}

	@Deprecated
	private void calProperties() {
		// 计算每种病的属性
		ClassMetadata classMetadata = ClassMetadata.getMetadata(DmDiseaseInfo.class);
		Map<String, PropertyMetadata> columns = classMetadata.getProperty();
		for (Map.Entry<String, PropertyMetadata> entry : columns.entrySet()) {
			PropertyMetadata propertyMetadata = entry.getValue();
			if (!propertyMetadata.isDbField()) {
				continue;
			}
			String proper = entry.getKey();
			if (proper.startsWith("hbp")) {
				hbpPros.add(proper);
			} else if (proper.startsWith("di")) {
				diPros.add(proper);
			} else if (proper.startsWith("stroke")) {
				strokePros.add(proper);
			} else if (proper.startsWith("tumor")) {
				tumorPros.add(proper);
			} else if (proper.startsWith("coronary")) {
				coronaryPros.add(proper);
			}

		}

		hbpPros.addAll(commonPros);
		diPros.addAll(commonPros);
		strokePros.addAll(commonPros);
		tumorPros.addAll(commonPros);
		coronaryPros.addAll(commonPros);
	}

	@Override
	public List<DmPersonInfo> getDmPersonInfoList(Criteria criteria) {
		return dmPersonInfoDao.getStandardizationPersonInfoList(criteria);
	}

	@Override
	public DmDiseaseInfo getHmCard(Criteria criteria) {
		if (ObjectUtil.isNullOrEmpty(criteria)) {
			log.error("管理卡获取条件为空");
			return null;
		}
		DmDiseaseInfo dmDiseaseInfo = dmDiseaseInfoDao.get(criteria);
		if (ObjectUtil.isNullOrEmpty(dmDiseaseInfo)) {
			log.warn("指定条件无法获取到关联的管理卡");
			return null;
		}
		Long personId = dmDiseaseInfo.getPersonId();
		if (ObjectUtil.isNullOrEmpty(personId)) {
			log.error("管理卡人员信息获取失败");
			return null;
		}
		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		dmDiseaseInfo.setPersonInfo(personInfo);
		/* 如果肿瘤已经纳入管理,则此处需要肿瘤报卡信息 */
		if (EHRConstants.DM_MANAGED_FLAG.equals(dmDiseaseInfo.getTumorFlag())) {
			dmDiseaseInfo.setTumorReports(getManagedeTumorReports(personId));
		}

		return dmDiseaseInfo;
	}

	@Override
	public boolean[] getPersonDmManagedFlag(PersonInfo personInfo) {
		Criteria criteria = new Criteria("personId", personInfo.getId());
		criteria.add(this.getHmCardDeleteStatus("", EHRConstants.DM_MANAGED_FLAG));
		DmDiseaseInfo diseaseInfo = dmDiseaseInfoDao.get(criteria, "diFlag", "hbpFlag", "strokeFlag", "coronaryFlag", "tumorFlag");
		boolean[] result = new boolean[] { false, false, false, false, false };// 默认可以上报所有

		if (null != diseaseInfo) {

			if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag())) {
				result[0] = true;
			}
			if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag())) {
				result[1] = true;
			}
			if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag())) {
				result[2] = true;
			}
			if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag())) {
				result[3] = true;
			}
			if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag())) {
				result[4] = true;
			}

		}
		return result;
	}

	/**
	 * Gets managede tumor reports.
	 * 
	 * @param personId
	 *            the person id
	 * @return the managede tumor reports
	 */
	private List<DmReportInfo> getManagedeTumorReports(Long personId) {
		Criteria param = new Criteria("personId", personId);
		param.add("disType", EHRConstants.DM_TUMOR_TYPE);
		param.add("cdmStatusInfo.REPORT_STATUS", ApprovalState.MANAGED.getValue());
		return dmReportInfoDao.getReports(param, null);
	}

	@Override
	public PageList<DmDiseaseInfo> getHmCardList(Page page, Criteria criteria, Organization organization, RoleType roleType) {
		if (null == criteria) {
			criteria = this.getHmCardDeleteStatus("dmDiseaseInfo.", EHRConstants.DM_MANAGED_FLAG);
		}
		setDiseaseInfoListDefaultParam(organization, roleType, criteria);
		return dmDiseaseInfoDao.getManageCardList(page, criteria);
	}

	@Override
	public PageList<DmDiseaseInfo> getManageCardWithFollowupCountList(Page page, Criteria criteria, QueryForm form) {
		if (null == criteria) {
			criteria = this.getHmCardDeleteStatus("dmDiseaseInfo.", EHRConstants.DM_MANAGED_FLAG);
		} else {
			criteria.add(this.getHmCardDeleteStatus("dmDiseaseInfo.", EHRConstants.DM_MANAGED_FLAG));
		}
		return dmDiseaseInfoDao.getManageCardWithFollowupCountList(page, criteria, form);
	}

	/**
	 * 设置查询默认权限条件
	 * 
	 * @param organization
	 *            the organization
	 * @param roleType
	 *            the role type
	 * @param criteria
	 *            the criteria
	 */
	private void setDiseaseInfoListDefaultParam(Organization organization, RoleType roleType, Criteria criteria) {
		if (RoleType.ZMB.equals(roleType)) {
			criteria.add("dmDiseaseInfo.CREATE_ORGAN_CODE", organization.getOrganCode());
		} else if (RoleType.ZXMB.equals(roleType)) {
			criteria.add("dmPersonInfo.CREATE_CENTER_ORGAN_CODE", organization.getOrganCode());
		}
	}

	@Override
	public DmDiseaseInfo queryDmDiseaseInfo(Long personId) {
		Criteria criteria = new Criteria("personId", personId);
		criteria.add(this.getHmCardDeleteStatus("", EHRConstants.DM_MANAGED_FLAG));
		return dmDiseaseInfoDao.get(criteria);
	}

	// ==============获取待纳入管理卡信息=============//

	@Override
	public List<ToBringIntoDiseaseInfo> getToBringIntoDiseaseInfos(Long psersonId, String orgCode) {
		List<ToBringIntoDiseaseInfo> result = null;
		List<DmReportInfo> reportInfos = getToManageReport(psersonId, orgCode);
		if (ObjectUtil.isNotEmpty(reportInfos)) {
			result = new ArrayList<>(reportInfos.size());
			for (DmReportInfo dmReportInfo : reportInfos) {
				ToBringIntoDiseaseInfo bringIntoDiseaseInfo = new ToBringIntoDiseaseInfo();
				result.add(bringIntoDiseaseInfo);
				String disTypeString = dmReportInfo.getDisType();
				bringIntoDiseaseInfo.setDiseaseType(disTypeString);
				bringIntoDiseaseInfo.setIcdCode(getIcdTenCode(dmReportInfo));
			}
		}
		return result;
	}

	/**
	 * Gets icd ten code.
	 * 
	 * @param dmReportInfo
	 *            the dm report info
	 * @return the icd ten code
	 */
	private String getIcdTenCode(DmReportInfo dmReportInfo) {
		String codeString = "";
		String diseaseType = dmReportInfo.getDisType();
		switch (diseaseType) {
		case EHRConstants.DM_HBP_TYPE:
			codeString = dmIcdTenUtil.getCode(diseaseType, dmReportInfo.getHbpType());
			break;
		case EHRConstants.DM_DI_TYPE:
			codeString = dmIcdTenUtil.getCode(diseaseType, dmReportInfo.getDiType());
			break;
		case EHRConstants.DM_CORONARY_TYPE:
			codeString = dmIcdTenUtil.getCode(diseaseType, dmReportInfo.getCoronaryType());
			break;
		case EHRConstants.DM_STROKE_TYPE:
			codeString = dmIcdTenUtil.getCode(diseaseType, dmReportInfo.getStrokeType());
			break;
		case EHRConstants.DM_TUMOR_TYPE:
			codeString = dmReportInfo.getTumorIcdTenCode();
			break;
		default:
			log.warn("无法获取icd10code id为" + dmReportInfo.getId() + "当期疾病类型为" + diseaseType);
		}
		return codeString;
	}

	// ==============获取待纳入管理卡信息end==========//

	// ==============直接添加管理卡=============//

	@Override
	@Transactional
	public Set<String> addManage(DmDiseaseInfo diseaseInfo, Map<String, String> fileMapGxy, Map<String, String> fileMapTnb, String createrName,Map<String, String> managedOrgMap) {
		Set<String> result = new HashSet<>();
		// 检查必须字段
		checkBeforeAdd(diseaseInfo, result);
		if (result.size() > 0) {
			return result;
		}
		Long personId = diseaseInfo.getPersonInfo().getId();
		// 根据身份证检查人员是否可以管理
		PersonInfo personInfo = platformService.queryPersonalInfo(null, diseaseInfo.getPersonInfo().getIdcard());
		if (ObjectUtil.isNotEmpty(personInfo)) {
			Set<String> checkToManagedPersonResult = checkToManagedPerson(diseaseInfo.getCurrentOrganization().getOrganCode(), personInfo,managedOrgMap);
			if (checkToManagedPersonResult.size() > 0) {
				result.addAll(checkToManagedPersonResult);
				return result;
			}
		}else {//人员未在本社区建档
			result.add(ManageCardErrorCode.NO_PERSON_RECOR.getValue());
			return result;
		}

		// 如果已经建档,需要检查是否已经被管理
		DmDiseaseInfo oldDiseaseInfo = null;
		if (ObjectUtil.isNotEmpty(personId)) {
			oldDiseaseInfo = dmDiseaseInfoDao.getDiseaseInfoOnly(new Criteria("personId", personId).add("status", EHRConstants.DM_MANAGE_STATUS_NORMAL));
			if (ObjectUtil.isNotEmpty(oldDiseaseInfo)) {
				Set<String> checkResult = checkDuplicateManage(diseaseInfo, oldDiseaseInfo);
				if (checkResult.size() > 0) {
					result.addAll(checkResult);
					return result;
				}
				diseaseInfo.setId(oldDiseaseInfo.getId());
			}
		}

		// 获取需要保存的字段
		Set<String> insertPropers = getDealProperties(diseaseInfo);
		saveOrUpdate(diseaseInfo, oldDiseaseInfo, insertPropers);
		// 附件上传
		uploadInfoRecords(diseaseInfo.getId(), fileMapGxy, createrName, "mbglkgxy");
		uploadInfoRecords(diseaseInfo.getId(), fileMapTnb, createrName, "mbglktnb");

		// 查询当前保存的管理卡信息(dm_disease_info)
		/*******************add by Kevin Ro 2019-02-25 start*************************/
		String hbpKey = "",diKey = "";
		DmDiseaseInfo temp = dmDiseaseInfoDao.getDiseaseInfoOnly(new Criteria("personId", personId).add("status", EHRConstants.DM_MANAGE_STATUS_NORMAL));
		List<UploadInfoRecord> loadList = uploadInfoRecordDao.getList(new Criteria("RESOURCE_ID",temp.getId()));
		if(loadList.size() > 0) {
			for (UploadInfoRecord record : loadList) {
				if("mbglktnb".equals(record.getFileResource())) {
					diKey = record.getResourceId().toString();
				} else if("mbglkgxy".equals(record.getFileResource())) {
					hbpKey = record.getResourceId().toString();
				}
			}
		}

		Map<String,String> map = new HashMap<>();
		if(ObjectUtil.isNotEmpty(hbpKey)) {
			map.put(EHRConstants.HBP, hbpKey);
		}
		if(ObjectUtil.isNotEmpty(diKey)) {
			map.put(EHRConstants.DI, diKey);
		}
		String json = JSON.toJSONString(map);
		temp.setReportInfoId(json);
		dmDiseaseInfoDao.update(temp, new String[]{"reportInfoId"});
		return result;
	}

	/**
	 * Check before add.
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param result
	 *            the result
	 * @return the set
	 */
	private Set<String> checkBeforeAdd(DmDiseaseInfo diseaseInfo, Set<String> result) {
		if (ObjectUtil.isNullOrEmpty(diseaseInfo)) {
			result.add(ManageCardErrorCode.DISEASEINFO_INFO_ERROR.getValue());
		}
		PersonInfo personInfo = diseaseInfo.getPersonInfo();
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			result.add(ManageCardErrorCode.DISEASEINFO_INFO_ERROR.getValue());
		}

		boolean hasDis = EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag()) || EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag()) || EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag())
				|| EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag()) || EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag());
		if (!hasDis) {
			result.add(ManageCardErrorCode.DISEASEINFO_INFO_ERROR.getValue());
		}
		return result;
	}

	@Override
	public Set<String> checkToManagedPerson(String organCode, PersonInfo personByIdcard,Map<String, String> managedOrgMap) {
		Set<String> result = new HashSet<>();
		// 检查是否被注销
		if (EHRConstants.HAD_OFF.equals(personByIdcard.getFilingFlag())) {
			result.add(ManageCardErrorCode.PERSON_RECORD_IS_CANCEL.getValue());
			return result;
		}
		//FilingFlag不等于 1或5 属于 未建档
		if (!(EHRConstants.HAD_CREATE.equals(personByIdcard.getFilingFlag()) || EHRConstants.MOVE_OUT.equals(personByIdcard.getFilingFlag()))) {
			result.add(ManageCardErrorCode.NO_PERSON_RECOR.getValue());
			return result;
		}
		// 检查是否在其他社区中被管理
		Long newPersonId = personByIdcard.getId();
		Criteria criteria = new Criteria("personId", newPersonId);
		DmDiseaseInfo oldDiseaseInfo = dmDiseaseInfoDao.getDiseaseInfoOnly(criteria);
		if(ObjectUtil.isNotEmpty(oldDiseaseInfo)){
			boolean cdmFlag = EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getHbpFlag()) ||
					EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getDiFlag()) ||
					EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getStrokeFlag()) ||
					EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getCoronaryFlag()) ||
					EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getTumorFlag());
			if (ObjectUtil.isNotEmpty(oldDiseaseInfo) && cdmFlag) {
				String createOragenCode = oldDiseaseInfo.getCreateOrganCode();
				// 已经被其他社区管理  此为 慢病管理卡管理机构 与当前登录机构不一致
				if (!organCode.equals(createOragenCode)) {
					result.add(ManageCardErrorCode.MANAGERED_BY_ANOTHER_ORG.getValue());
					String orgName =organizationApp.queryOrganName(createOragenCode);
					managedOrgMap.put("isManagedByOtherOrg","该患者已经在"+orgName+"管理慢病，请去该机构创建慢病管理卡!");
					return result;
				}
			}
		}else {//从未创建慢病管理卡   判断档案管理机构 和 当前登录机构是否一致
			if (!organCode.equals(personByIdcard.getInputOrganCode())) {
				result.add(ManageCardErrorCode.MANAGERED_BY_ANOTHER_ORG.getValue());
				String orgName =organizationApp.queryOrganName(personByIdcard.getInputOrganCode());
				managedOrgMap.put("isManagedByOtherOrg","该患者已经在"+orgName+"管理，请去该机构创建慢病管理卡!");
				return result;
			}
		}
		return result;
	}

	/**
	 * 获取管理卡,无其它信息
	 * 
	 * @param criteria
	 *            the criteria
	 * @param properties
	 *            the properties
	 * @return disease info only
	 */
	private DmDiseaseInfo getDiseaseInfoOnly(Criteria criteria, String... properties) {
		if (ObjectUtil.isNullOrEmpty(criteria)) {
			return null;
		}
		criteria.add(this.getHmCardDeleteStatus("",EHRConstants.DM_MANAGED_FLAG));
		return dmDiseaseInfoDao.get(criteria, properties);
	}

	// ==============直接添加管理卡 end=============//

	// ==============纳入管理卡 ==================//

	@Override
	public Set<String> checkReport(Long personId, String manageOrgCode) {
		// TODO 考虑多张相同类型的报卡
		Set<String> result = new HashSet<>();
		if (ObjectUtil.isNullOrEmpty(personId)) {
			log.debug("当前选择人 personId为空");
			result.add(ManageCardErrorCode.INFO_NOT_COMPLETE.getValue());
			return result;
		}
		List<DmReportInfo> reportInfos = getToManageReport(personId, manageOrgCode);
		if (ObjectUtil.isNullOrEmpty(reportInfos)) {
			log.debug("当前选择人,无法获取报卡信息 personId:" + personId + "管理机构 :" + manageOrgCode);
			result.add(ManageCardErrorCode.INFO_NOT_COMPLETE.getValue());
		}
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("status", EHRConstants.DM_MANAGE_STATUS_NORMAL);
		DmDiseaseInfo diseaseInfo = dmDiseaseInfoDao.getDiseaseInfoOnly(criteria);
		if (!ObjectUtil.isNullOrEmpty(diseaseInfo)) {
			for (DmReportInfo reportInfo : reportInfos) {
				String type = reportInfo.getDisType();
				if (!result.contains(ManageCardErrorCode.DI_HAS_MANAGED.getValue()) && EHRConstants.DM_DI_TYPE.equals(type) && EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag())) {
					result.add(ManageCardErrorCode.DI_HAS_MANAGED.getValue());
				}
				if (!result.contains(ManageCardErrorCode.STROKE_HAS_MANAGED.getValue()) && EHRConstants.DM_STROKE_TYPE.equals(type) && EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag())) {
					result.add(ManageCardErrorCode.STROKE_HAS_MANAGED.getValue());
				}
				if (!result.contains(ManageCardErrorCode.CORONARY_HAS_MANAGED.getValue()) && EHRConstants.DM_CORONARY_TYPE.equals(type) && EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag())) {
					result.add(ManageCardErrorCode.CORONARY_HAS_MANAGED.getValue());
				}
				if (!result.contains(ManageCardErrorCode.TUMOR_HAS_MANAGED.getValue()) && EHRConstants.DM_TUMOR_TYPE.equals(type) && EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag())) {
					result.add(ManageCardErrorCode.TUMOR_HAS_MANAGED.getValue());
				}
			}
		}
		return result;
	}

	@Override
	public DmDiseaseInfo convertReportToDiseaseInfo(Long personId, Organization organization) {
		List<DmReportInfo> reportInfos = getToManageReport(personId, organization.getOrganCode());
		if (ObjectUtil.isNullOrEmpty(reportInfos)) {
			return null;
		}

		// 不显示历史数据
		DmDiseaseInfo diseaseInfo = new DmDiseaseInfo();

		// TODO 是否需要显示已经管理的卡
		DmDiseaseInfo oldDiseaseInfo = dmDiseaseInfoDao.getDiseaseInfoOnly(new Criteria("personId", personId).add("status", EHRConstants.DM_MANAGE_STATUS_NORMAL));
		if (null != oldDiseaseInfo) {
			diseaseInfo.setId(oldDiseaseInfo.getId());
			diseaseInfo.setPersonId(oldDiseaseInfo.getPersonId());
		}

		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		if (null == personInfo) {
			log.error("指定人员无法找到 人员Id为:" + personId);
			return null;
		}

		// 填充慢病信息
		diseaseInfo.setPersonInfo(personInfo);
		diseaseInfo.setToManagedReports(reportInfos);
		String hbp = "",di = "",stroke = "",coronary = "",tumor = "";
		Map<String,Long> json = new HashMap<String,Long>();
		for (DmReportInfo reportInfo : reportInfos) {
			String type = reportInfo.getDisType();
			if (EHRConstants.DM_HBP_TYPE.equals(type)) {
				diseaseInfo.setHbpFlag(EHRConstants.DM_MANAGED_FLAG);
				diseaseInfo.setHbpType(reportInfo.getHbpType());
				diseaseInfo.setHbpAccidentDate(reportInfo.getHbpAccidentDate());
				diseaseInfo.setHbpDiagnosisDate(reportInfo.getHbpDiagnosisDate());
				diseaseInfo.setHbpDiagnosedDate(reportInfo.getHbpDiagnosisDate());
				diseaseInfo.setHbpDiagnosedOrganCode(reportInfo.getDiagnosisOrganCode());
				diseaseInfo.setHbpDiagnosedOrganName(reportInfo.getDiagnosisOrganName());
				diseaseInfo.setHbpDiagnosisDepends(reportInfo.getHbpDiagnosisDepends());
				diseaseInfo.setHbpOtherDiagnosisOrganFlag(reportInfo.getOtherDiagnosisOrganFlag());
				diseaseInfo.setHbpOtherDiagnosisOrganName(reportInfo.getOtherDiagnosisOrganName());
				json.put(EHRConstants.HBP,reportInfo.getId());
			}
			if (EHRConstants.DM_DI_TYPE.equals(type)) {
				diseaseInfo.setDiFlag(EHRConstants.DM_MANAGED_FLAG);
				diseaseInfo.setDiType(reportInfo.getDisType());
				diseaseInfo.setDiDiagnosedWay(reportInfo.getDiDiagnosisDepends());
				diseaseInfo.setDiDiagnosedDate(reportInfo.getDiDiagnosisDate());
				diseaseInfo.setDiDiagnosedOrganCode(reportInfo.getDiagnosisOrganCode());
				diseaseInfo.setDiDiagnosedOrganName(reportInfo.getDiagnosisOrganName());
                diseaseInfo.setDiOtherDiagnosisOrganFlag(reportInfo.getOtherDiagnosisOrganFlag());
				diseaseInfo.setDiOtherDiagnosisOrganName(reportInfo.getOtherDiagnosisOrganName());
				json.put(EHRConstants.DI,reportInfo.getId());
			}
			if (EHRConstants.DM_STROKE_TYPE.equals(type)) {
				diseaseInfo.setStrokeFlag(EHRConstants.DM_MANAGED_FLAG);
				diseaseInfo.setStrokeType(reportInfo.getStrokeType());
				diseaseInfo.setStrokeAccidentDate(reportInfo.getStrokeAccidentDate());
				diseaseInfo.setStrokeDiagnosisDate(reportInfo.getStrokeDiagnosisDate());
				diseaseInfo.setStrokeDiagnosisDepends(reportInfo.getStrokeDiagnosisDepends());
				json.put(EHRConstants.STROKE,reportInfo.getId());
			}
			if (EHRConstants.DM_CORONARY_TYPE.equals(type)) {
				diseaseInfo.setCoronaryFlag(EHRConstants.DM_MANAGED_FLAG);
				diseaseInfo.setCoronaryType(reportInfo.getCoronaryType());
				diseaseInfo.setCoronaryAccidentDate(reportInfo.getCoronaryAccidentDate());
				diseaseInfo.setCoronaryDiagnosisDate(reportInfo.getCoronaryDiagnosisDate());
				diseaseInfo.setCoronaryDiagnosisDepends(reportInfo.getCoronaryDiagnosisDepends());
				json.put(EHRConstants.CORONARY,reportInfo.getId());
			}
			if (EHRConstants.DM_TUMOR_TYPE.equals(type)) {
				/* 肿瘤无管理卡信息,显示报卡信息 */
				List<DmReportInfo> tumorReports = diseaseInfo.getTumorReports();
				if (null == tumorReports) {
					tumorReports = new ArrayList<>();
					diseaseInfo.setTumorReports(tumorReports);
				}
				tumorReports.add(reportInfo);
				diseaseInfo.setTumorFlag(EHRConstants.DM_MANAGED_FLAG);
				json.put(EHRConstants.TUMOR, reportInfo.getId());
			}
		}
		String reports = JSON.toJSONString(json);
		diseaseInfo.setReportInfoId(reports);
		return diseaseInfo;

	}

	@Override
	@Transactional
	public Set<String> bringIntoManage(DmDiseaseInfo diseaseInfo,String hbpReportId,String diReportId,Map<String,String> linkMapGxy,Map<String,String> linkMapTnb,Map<String,String> managedOrgMap) {
		Set<String> result = new HashSet<>();
		// 检查信息
		if (!checkDiseaseInfo(diseaseInfo)) {
			result.add(ManageCardErrorCode.DISEASEINFO_INFO_ERROR.getValue());
			return result;
		}
		// 检查带纳入报卡信息
		List<DmReportInfo> toManagedReports = diseaseInfo.getToManagedReports();
		if (!ObjectUtil.isNotEmpty(toManagedReports)) {
			log.error("获取待纳入报卡出错");
			result.add(ManageCardErrorCode.GET_TO_BE_MANAGED_REPORT_ERROR.getValue());
			return result;
		}

		PersonInfo personInfo = diseaseInfo.getPersonInfo();
		Long personId = personInfo.getId();
		Long oldPersonId = null;
		/* 检查身份证是否被占用 PersonInfo */
		// Long end = System.currentTimeMillis();
		PersonInfo personByIdcard = platformService.queryPersonalInfo(null, personInfo.getIdcard());
		// log.error("====bringIntoManage 496 " + (System.currentTimeMillis() -
		// end));
		if (ObjectUtil.isNotEmpty(personByIdcard)) {
			// end = System.currentTimeMillis();
			Set<String> checkToManagedPersonResult = checkToManagedPerson(diseaseInfo.getCurrentOrganization().getOrganCode(), personByIdcard,managedOrgMap);
			if (checkToManagedPersonResult.size() > 0) {
				result.addAll(checkToManagedPersonResult);
				return result;
			}
			// 新增的身份证已经被占用,则使用该人的id if
			if (!personByIdcard.getId().equals(personId)) {
				oldPersonId = personId;
				personId = personByIdcard.getId();
				personInfo.setId(personId);
				personInfo.setName(personByIdcard.getName());
			}
			// log.error("====bringIntoManage 511 " +
			// (System.currentTimeMillis() - end));
		}
		/* 检查重复 */
		// end = System.currentTimeMillis();
		DmDiseaseInfo oldDiseaseInfo = dmDiseaseInfoDao.getDiseaseInfoOnly(new Criteria("personId", personId).add("status", EHRConstants.DM_MANAGE_STATUS_NORMAL));
		Set<String> dResult = checkDuplicateManage(diseaseInfo, oldDiseaseInfo);
		// log.error("====bringIntoManage 517 " + (System.currentTimeMillis() -
		// end));
		if (dResult.size() > 0) {
			result.addAll(dResult);
			return result;
		}

		// 获取更新字段
		Set<String> updatePropers = getDealProperties(diseaseInfo);
		if (ObjectUtil.isNotEmpty(oldDiseaseInfo)) {
			diseaseInfo.setId(oldDiseaseInfo.getId());
		}
		// 保存
		saveOrUpdate(diseaseInfo, oldDiseaseInfo, updatePropers);

		// 查询当前保存的管理卡信息(dm_disease_info)
		/*******************add by Kevin Ro 2018-10-15 start*************************/
		DmDiseaseInfo temp = dmDiseaseInfoDao.getDiseaseInfoOnly(new Criteria("personId", personId).add("status", EHRConstants.DM_MANAGE_STATUS_NORMAL));
        Map<String,String> map = null;
        if(temp!=null&& StringUtil.isNotEmpty(temp.getReportInfoId()))
            map = (Map)JSON.parse(temp.getReportInfoId());
        else
			map = new HashMap<>();

		if(ObjectUtil.isNotEmpty(hbpReportId)) {
			map.put(EHRConstants.HBP, hbpReportId);
		}
		if(ObjectUtil.isNotEmpty(diReportId)) {
			map.put(EHRConstants.DI, diReportId);
		}
		String json = JSON.toJSONString(map);
		temp.setReportInfoId(json);
		dmDiseaseInfoDao.update(temp, new String[]{"reportInfoId"});

		// 附件上传
		uploadInfoRecords(diseaseInfo.getId(), linkMapGxy, temp.getCreateDoctorName(), "mbglkgxy");
		uploadInfoRecords(diseaseInfo.getId(), linkMapTnb, temp.getCreateDoctorName(), "mbglktnb");
		/**********************add by Kevin Ro 2018-10-15 end***********************/

		// end = System.currentTimeMillis();
		// 更新已经纳入管理的报卡状态
		updateManagedReportCard(diseaseInfo, toManagedReports);
		// log.error("====bringIntoManage 534 " + (System.currentTimeMillis() -
		// end));

		// 如果关联到新的人员上,则更新已存在的报卡和人员信息
		if (ObjectUtil.isNotEmpty(oldPersonId)) {
			// end = System.currentTimeMillis();
			Parameters parameters = new Parameters("personId", personId);
			//管理机构
			Organization org = diseaseInfo.getCurrentOrganization();
			parameters.add("inputOrganCode",org.getOrganCode());
			parameters.add("inputOrganName",org.getOrganCode());
			parameters.add("createOrganCode",org.getOrganCode());
			parameters.add("createOrganName",org.getOrganCode());
			Criteria paramCriteria = new Criteria("personId", oldPersonId);
			dmPersonInfoDao.update(parameters, paramCriteria);
			dmReportInfoDao.update(parameters, paramCriteria);
			platformService.deleteNoIdCardPerson(oldPersonId);
			// log.error("====bringIntoManage 543 " +
			// (System.currentTimeMillis() - end));
		}else {
			Organization org = diseaseInfo.getCurrentOrganization();
			Parameters parameters = new Parameters("inputOrganCode", org.getOrganCode());
			//管理机构
			parameters.add("inputOrganName", org.getOrganCode());
			parameters.add("createOrganCode", org.getOrganCode());
			parameters.add("createOrganName", org.getOrganCode());
			Criteria paramCriteria = new Criteria("personId", personId);
			dmPersonInfoDao.update(parameters, paramCriteria);
		}

		return result;
	}

	/**
	 * 更新已经纳入报卡的信息
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param toManagedReports
	 *            the to managed reports
	 * @return
	 */
	private void updateManagedReportCard(DmDiseaseInfo diseaseInfo, List<DmReportInfo> toManagedReports) {
		int size = toManagedReports.size();
		List<Integer> cdmStatusInfoIds = new ArrayList<>(size);
		List<Long> dmPersonIds = new ArrayList<>(size);
		List<CdmApprovalInfo> approvalInfos = new ArrayList<>(size);
		for (DmReportInfo dmReportInfo : toManagedReports) {
			dmPersonIds.add(dmReportInfo.getDmPersonId());
			CdmStatusInfo cdmStatusInfo = dmReportInfo.getCdmStatusInfo();
			cdmStatusInfoIds.add(cdmStatusInfo.getId());
			CdmApprovalInfo approvalInfo = createApproval(cdmStatusInfo.getId(), "纳入管理", ApprovalState.MANAGED.getValue(), diseaseInfo.getCurrentUser(), diseaseInfo.getCurrentOrganization());
			approvalInfos.add(approvalInfo);
		}
		// 更新人员信息
		Parameters personParams = new Parameters("idcard", diseaseInfo.getIdcard());
		// personParams.add("name",
		// diseaseInfo.getPersonInfo().getName());//TODO 是否需要更新name
		Criteria personCriteria = new Criteria("id", OP.IN, dmPersonIds);
		dmPersonInfoDao.update(personParams, personCriteria);
		// 插入审核信息
		cdmApprovalInfoDao.batchInsert(approvalInfos);
		// 更新报卡状态
		Parameters statusParams = new Parameters("reportStatus", ApprovalState.MANAGED.getValue());
		Criteria statusCriteria = new Criteria("id", OP.IN, cdmStatusInfoIds);
		cdmStatusInfoDao.update(statusParams, statusCriteria);
	}

	/**
	 * 检查管理卡信息是否完整
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @return boolean
	 */
	private boolean checkDiseaseInfo(DmDiseaseInfo diseaseInfo) {
		if (ObjectUtil.isNullOrEmpty(diseaseInfo)) {
			log.error("信息获取失败");
			return false;
		}
		PersonInfo personInfo = diseaseInfo.getPersonInfo();
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			log.error("人员信息获取失败");
			return false;
		}
		Long personId = personInfo.getId();
		if (ObjectUtil.isNullOrEmpty(personId)) {
			log.error("人员id获取失败");
			return false;
		}
		return true;
	}

	/**
	 * 纳入和新增时检查重复管理
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param personId
	 *            the person id
	 * @return set
	 */
	@SuppressWarnings("unused")
	private Set<String> checkDuplicateManage(DmDiseaseInfo diseaseInfo, Long personId) {
		DmDiseaseInfo oldDiseaseInfo = dmDiseaseInfoDao.getDiseaseInfoOnly(new Criteria("personId", personId).add("status", EHRConstants.DM_MANAGE_STATUS_NORMAL));
		return checkDuplicateManage(diseaseInfo, oldDiseaseInfo);
	}

	/**
	 * 获取当前户 指定患者的可以纳入的报卡
	 * 
	 * @param personId
	 *            the person id
	 * @param manageOrgCode
	 *            the manage org code
	 * @return to manage report
	 */
	private List<DmReportInfo> getToManageReport(Long personId, String manageOrgCode) {
		Criteria criteria = new Criteria();
		criteria.add("dmReportInfo.PERSON_ID", personId);
		criteria.add("dmReportInfo.MANAGE_ORGAN_CODE", manageOrgCode);
//        String[] stsArr={ApprovalState.ALLOCATED.getValue(),ApprovalState.MANAGED.getValue()};
		criteria.add("cdmStatusInfo.REPORT_STATUS", ApprovalState.ALLOCATED.getValue());
		List<DmReportInfo> reportInfos = dmReportInfoDao.getReports(criteria, null);
		return reportInfos;
	}

	// ==============纳入管理卡 ==end===============//

	// ==============删除和撤销管理 ===============//

	@Override
	@Transactional
	public void cancelManage(Long personId) {
		Parameters parameters = new Parameters(STATUS_COLUMN, EHRConstants.DM_MANAGE_STATUS_CANCEL);
		parameters.add("updateDate", new Date());
		Criteria criteria = new Criteria("personId", personId);
		dmDiseaseInfoDao.update(parameters, criteria);
		// followupRecordService.delUnDoFollowupPalnByPersonId(personId); //TODO
		// 注销是否删除未完成的随访计划
	}

	@Override
	@Transactional
	public void recoveryManage(Long personId) {
		Parameters parameters = new Parameters(STATUS_COLUMN, EHRConstants.DM_MANAGE_STATUS_NORMAL);
		parameters.add("updateDate", new Date());
		Criteria criteria = new Criteria("personId", personId);
		dmDiseaseInfoDao.update(parameters, criteria);
	}

	/**
	 * Delete hm card phy.
	 * 
	 * @param diseaseinfoId
	 *            the diseaseinfo id
	 */
	@SuppressWarnings("unused")
	private void deleteHmCardPhy(Long diseaseinfoId) {
		DmDiseaseInfo dmDiseaseInfo = dmDiseaseInfoDao.get(diseaseinfoId);
		Assert.notNull(dmDiseaseInfo, "指定删除的管理卡不存在,指定的id为" + diseaseinfoId);
		Long personId = dmDiseaseInfo.getPersonId();
		Assert.notNull(personId, "指定删除的管理卡的人员id不存在,指定的管理卡id为" + diseaseinfoId);
		Criteria criteria = new Criteria("personId", personId);
		// 删除管理卡
		dmDiseaseInfoDao.delete(criteria);
		// 删除基本信息
		criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
		dmPersonInfoDao.delete(criteria);
		// 删除随访信息
		followupRecordService.delFollowupAfterDelHm(personId);
	}

	// ==============删除和撤销管理 ==end==========//

	// ==============保存或者更新管理卡 ============//
	@Override
	@Transactional
	public boolean saveHmCard(DmDiseaseInfo diseaseInfo, Map<String, String> fileMapGxy, Map<String, String> fileMapTnb, String createrName) {
		if (!checkDiseaseInfo(diseaseInfo)) {
			return false;
		}
		Set<String> updatePropers = getDealProperties(diseaseInfo);
		DmDiseaseInfo oldDiseaseInfo = dmDiseaseInfoDao.getDiseaseInfoOnly(new Criteria("id", diseaseInfo.getId()));
		if (ObjectUtil.isNullOrEmpty(oldDiseaseInfo)) {
			log.error("获取管理卡失败 id:" + diseaseInfo.getId());
			return false;
		}
		saveOrUpdate(diseaseInfo, oldDiseaseInfo, updatePropers);
		// 附件上传
		uploadInfoRecords(diseaseInfo.getId(), fileMapGxy, createrName, "mbglkgxy");
		uploadInfoRecords(diseaseInfo.getId(), fileMapTnb, createrName, "mbglktnb");

		// 查询当前保存的管理卡信息(dm_disease_info)团风需求修改慢病管理卡时不允许修改附件 0175263: 【慢病管理】通过慢病报卡上传的附件，在慢病管理卡中不显示，
		/*******************add by Kevin Ro 2019-02-26 start*************************/
		/*String hbpKey = "",diKey = "";
//		DmDiseaseInfo temp = dmDiseaseInfoDao.getDiseaseInfoOnly(new Criteria("personId", diseaseInfo.getPersonId()).add("status", EHRConstants.DM_MANAGE_STATUS_NORMAL));
		List<UploadInfoRecord> loadList = uploadInfoRecordDao.getList(new Criteria("RESOURCE_ID",diseaseInfo.getId()));
		if(loadList.size() > 0) {
			for (UploadInfoRecord record : loadList) {
				if("mbglktnb".equals(record.getFileResource())) {
					diKey = record.getResourceId().toString();
				} else if("mbglkgxy".equals(record.getFileResource())) {
					hbpKey = record.getResourceId().toString();
				}
			}
		}

		Map<String,String> map = new HashMap<>();
		if(ObjectUtil.isNotEmpty(hbpKey)) {
			map.put(EHRConstants.HBP, hbpKey);
		}
		if(ObjectUtil.isNotEmpty(diKey)) {
			map.put(EHRConstants.DI, diKey);
		}
		if(!map.isEmpty()) {
			String json = JSON.toJSONString(map);
			diseaseInfo.setReportInfoId(json);
			dmDiseaseInfoDao.update(diseaseInfo, new String[]{"id", "reportInfoId"});
		}*/
		return true;
	}
	// 附件上传
	private void uploadInfoRecords(Long sourceId, Map<String, String> fileMap, String createrName, String fileSource) {
		if (ObjectUtil.isNotEmpty(fileMap)) {
			//不删除之前上传的附件 2019-02-26 by Kevin Ro 注释
			//uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", sourceId).add("FILE_RESOURCE", fileSource));
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for (String uuid : fileMap.keySet()) {
				String originalFilePath = fileMap.get(uuid);
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord(sourceId, originalFilePath, fileSource, createrName, new Date());
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}
	// ==============保存或者更新肿瘤基本信息 ============//
        @Override
        @Transactional
        public boolean saveTumorPersonInfo(DmDiseaseInfo diseaseInfo) {
		if (!checkDiseaseInfo(diseaseInfo)) {
			return false;
		}
		Set<String> updatePropers = new HashSet<>();
        updatePropers.addAll(Arrays.asList("tumorDiagnosisDepends", "id", "tumorMetastasisPart", "tumorPrimaryPart",
                "idcard", "tumorType", "tumorPathologyType", "tumorDiagnosisDate"));
		DmDiseaseInfo oldDiseaseInfo = dmDiseaseInfoDao.getDiseaseInfoOnly(new Criteria("id", diseaseInfo.getId()));
		if (ObjectUtil.isNullOrEmpty(oldDiseaseInfo)) {
			log.error("获取管理卡失败 id:" + diseaseInfo.getId());
			return false;
		}
		saveOrUpdate(diseaseInfo, oldDiseaseInfo, updatePropers);
		return true;
	}

	/**
	 * 保存或者更新管理卡
	 *
	 * @param diseaseInfo
	 *            the disease info
	 * @param oldDiseaseInfo
	 *            the old disease info
	 * @param properties
	 *            the properties
	 * @return
	 */
	private void saveOrUpdate(DmDiseaseInfo diseaseInfo, DmDiseaseInfo oldDiseaseInfo, Set<String> properties) {
		Assert.notNull(diseaseInfo.getCurrentOrganization());
		Assert.notNull(diseaseInfo.getCurrentUser());

		/* 人员更新至平台 */
		PersonInfo personInfo = diseaseInfo.getPersonInfo();
		//设置健康档案中的人群分类属性
		setPopulationCategory(personInfo, diseaseInfo);
		// Long end = System.currentTimeMillis();
		cdmPersonService.saveOrUpdatePersonAsyn(personInfo, diseaseInfo.getCurrentUser(), diseaseInfo.getCurrentOrganization());
		// log.error("====saveOrUpdate 712 " + (System.currentTimeMillis() -
		// end));
		// end = System.currentTimeMillis();

		/* 保存或更新管理卡 */
		Long personId = personInfo.getId();
		Assert.notNull(personId, "管理卡人员id不能为空");
		diseaseInfo.setPersonId(personId);
		diseaseInfo.setIdcard(personInfo.getIdcard());

		if (ObjectUtil.isNullOrEmpty(diseaseInfo.getId())) {
			// 如果当前患者有被删除过的管理卡,则其一定有慢病人员信息
			// 这种情况必须要更新人员的全部信息,包含管理机构,上级等冗余字段
			saveOrReUpdateDmPerson(personInfo, diseaseInfo);
			setInputInfo(false, diseaseInfo, properties);// 设置新增信息
			setDisAddManagedInfo(diseaseInfo);// 设置纳入日期
			diseaseInfo.setStatus(EHRConstants.DM_MANAGE_STATUS_NORMAL);
			properties.add(STATUS_COLUMN);
			//properties.add(IS_DELETE_COLUMN);
			// end = System.currentTimeMillis();
			// 新增之前处理其它业务
			dealSthBeforeAdd(diseaseInfo, properties);
			dmDiseaseInfoDao.insert(diseaseInfo, properties.toArray(new String[properties.size()]));
			DmDiseaseInfo diseaseInfoDb = dmDiseaseInfoDao.get(new Criteria("person_id", diseaseInfo.getPersonId()), "id");
			diseaseInfo.setId(diseaseInfoDb.getId());
		} else {
			/* 保存到慢病人员 */
			saveOrUpdateDmPerson(personInfo, diseaseInfo);
			boolean cdmFlag = EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getHbpFlag()) ||
					EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getDiFlag()) ||
					EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getStrokeFlag()) ||
					EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getCoronaryFlag()) ||
					EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getTumorFlag());
			//检查是不是撤销状态下 再次新建 若是是需要重新设置创建机构等信息
			if(!cdmFlag) {//若五种慢病没有任何一种慢病是已管理状态说明此卡是已撤销的慢病管理卡
				setInputInfo(false, diseaseInfo, properties);
			} else {
				setInputInfo(true, diseaseInfo, properties);
			}			// end = System.currentTimeMillis();
			setDisUpdateManagedDate(diseaseInfo, oldDiseaseInfo, properties);
			// 更新之前的处理
			dealSthBeforeUpdate(diseaseInfo, oldDiseaseInfo, properties);
			// log.error("====saveOrUpdate 743 " + (System.currentTimeMillis() -
			// end));
			// 拒绝更新注销状态和删除状态
			properties.remove(STATUS_COLUMN);
			//properties.remove(IS_DELETE_COLUMN);
			// end = System.currentTimeMillis();
			this.setUpdatePros(properties, oldDiseaseInfo, diseaseInfo);
			dmDiseaseInfoDao.update(diseaseInfo, properties.toArray(new String[properties.size()]));
			this.deleteUpdatePros(properties, oldDiseaseInfo, diseaseInfo);

			// log.error("====saveOrUpdate 749 " + (System.currentTimeMillis() -
			// end));
		}
		//查看健康档案是否为二星若是因为慢病已管理星级则变为三星 jianghaiying
		//syncWork(diseaseInfo, personInfo);
		// end = System.currentTimeMillis();
		// 处理其它业务
		dealSthAfterSave(diseaseInfo, oldDiseaseInfo, properties);
		// log.error("====saveOrUpdate 754 " + (System.currentTimeMillis() -
		// end));
	}
	//设置健康档案中的人群分类属性

	private void setPopulationCategory(PersonInfo personInfo, DmDiseaseInfo diseaseInfo) {
		String populationCategory="";
		PersonInfo personInfoDB = personInfoDao.get(new Criteria("idcard", personInfo.getIdcard()));
		boolean isEmpty =  ObjectUtil.isNullOrEmpty(personInfoDB) || ObjectUtil.isNullOrEmpty(personInfoDB.getPopulationCategory());

		if((isEmpty || !personInfoDB.getPopulationCategory().contains("1")) &&
			ObjectUtil.equals(diseaseInfo.getHbpFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			populationCategory = "1,";
		}
		if((isEmpty || !personInfoDB.getPopulationCategory().contains("2")) &&
				ObjectUtil.equals(diseaseInfo.getDiFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			populationCategory = populationCategory + "2,";
		}
		if((isEmpty || !personInfoDB.getPopulationCategory().contains("5")) &&
				ObjectUtil.equals(diseaseInfo.getStrokeFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			populationCategory = populationCategory + "5,";
		}
		if((isEmpty || !personInfoDB.getPopulationCategory().contains("6")) &&
				ObjectUtil.equals(diseaseInfo.getCoronaryFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			populationCategory = populationCategory + "6,";
		}
		if((isEmpty || !personInfoDB.getPopulationCategory().contains("7")) &&
				ObjectUtil.equals(diseaseInfo.getTumorFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			populationCategory = populationCategory + "7,";
		}
		personInfo.setPopulationCategory(populationCategory);
	}
	private void syncWork(DmDiseaseInfo dmDiseaseInfo, PersonInfo personInfo) {
		personInfo = personInfoDao.get(personInfo.getId());
		if(ObjectUtil.equals(personInfo.getStar(), EHRConstants.TWO_STAR) && ObjectUtil.equals(personInfo.getFilingFlag(), EHRConstants.HAD_CREATE)) {
			Organization organization = dmDiseaseInfo.getCurrentOrganization();
			User user = dmDiseaseInfo.getCurrentUser();
			Date nowDate = new Date();
			String[] param = new String[]{"star", "updateOrganCode", "updateOrganName", "updateIdcard",
					"updateName", "updateDate", "starUpdateDate"};
			personInfo.setStar(EHRConstants.THREE_STAR);
			personInfo.setUpdateDate(nowDate);
			personInfo.setUpdateIdcard(user.getIdentityCard());
			personInfo.setUpdateName(user.getName());
			personInfo.setUpdateOrganCode(organization.getOrganCode());
			personInfo.setUpdateOrganName(organization.getOrganName());
			personInfo.setStarUpdateDate(nowDate);
			personInfoDao.update(personInfo, param);

			//星级变化记录表
			EhrDocLevel entity = new EhrDocLevel();
			entity.setPersonId(personInfo.getId());
			entity.setNewStar(EHRConstants.THREE_STAR);
			entity.setOldStar(EHRConstants.TWO_STAR);
			entity.setCreateTime(new Date());
			if (organization != null)
				entity.setUpdateOrgCode(organization.getOrganCode());
			if (user != null)
				entity.setUpdateStaffCode(user.getStaffCode());
			// 星级发生改变执行以下
			ehrDocLevelDao.insert(entity);
		}
	}

	private void setUpdatePros(Set<String> properties, DmDiseaseInfo oldDiseaseInfo, DmDiseaseInfo diseaseInfo) {
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getHbpFlag()) && ObjectUtil.equals(diseaseInfo.getHbpFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.add("hbpCreateDate");
			properties.add("hbpCreateOrganCode");
			properties.add("hbpCreateDoctorCode");
			properties.add("hbpUpdateDate");
			properties.add("hbpUpdateOrganCode");
			properties.add("hbpUpdateDoctorCode");
		}
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getDiFlag()) && ObjectUtil.equals(diseaseInfo.getDiFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.add("diCreateDate");
			properties.add("diCreateOrganCode");
			properties.add("diCreateDoctorCode");
			properties.add("diUpdateDate");
			properties.add("diUpdateOrganCode");
			properties.add("diUpdateDoctorCode");
		}
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getCoronaryFlag()) && ObjectUtil.equals(diseaseInfo.getCoronaryFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.add("coronaryCreateDate");
			properties.add("coronaryCreateOrganCode");
			properties.add("coronaryCreateDoctorCode");
			properties.add("coronaryUpdateDate");
			properties.add("coronaryUpdateOrganCode");
			properties.add("coronaryUpdateDoctorCode");
		}
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getStrokeFlag()) && ObjectUtil.equals(diseaseInfo.getStrokeFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.add("coronaryCreateDate");
			properties.add("strokeCreateOrganCode");
			properties.add("strokeCreateDoctorCode");
			properties.add("coronaryUpdateDate");
			properties.add("strokeUpdateOrganCode");
			properties.add("strokeUpdateDoctorCode");
		}
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getTumorFlag()) && ObjectUtil.equals(diseaseInfo.getTumorFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.add("tumorCreateDate");
			properties.add("tumorCreateOrganCode");
			properties.add("tumorCreateDoctorCode");
			properties.add("tumorUpdateDate");
			properties.add("tumorUpdateOrganCode");
			properties.add("tumorUpdateDoctorCode");
		}
	}

	private void deleteUpdatePros(Set<String> properties, DmDiseaseInfo oldDiseaseInfo, DmDiseaseInfo diseaseInfo) {
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getHbpFlag()) && ObjectUtil.equals(diseaseInfo.getHbpFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.remove("hbpCreateDate");
			properties.remove("hbpCreateOrganCode");
			properties.remove("hbpCreateDoctorCode");
			properties.remove("hbpUpdateDate");
			properties.remove("hbpUpdateOrganCode");
			properties.remove("hbpUpdateDoctorCode");
		}
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getDiFlag()) && ObjectUtil.equals(diseaseInfo.getDiFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.remove("diCreateDate");
			properties.remove("diCreateOrganCode");
			properties.remove("diCreateDoctorCode");
			properties.remove("diUpdateDate");
			properties.remove("diUpdateOrganCode");
			properties.remove("diUpdateDoctorCode");
		}
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getCoronaryFlag()) && ObjectUtil.equals(diseaseInfo.getCoronaryFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.remove("coronaryCreateDate");
			properties.remove("coronaryCreateOrganCode");
			properties.remove("coronaryCreateDoctorCode");
			properties.remove("coronaryUpdateDate");
			properties.remove("coronaryUpdateOrganCode");
			properties.remove("coronaryUpdateDoctorCode");
		}
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getStrokeFlag()) && ObjectUtil.equals(diseaseInfo.getStrokeFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.remove("coronaryCreateDate");
			properties.remove("strokeCreateOrganCode");
			properties.remove("strokeCreateDoctorCode");
			properties.remove("coronaryUpdateDate");
			properties.remove("strokeUpdateOrganCode");
			properties.remove("strokeUpdateDoctorCode");
		}
		if(ObjectUtil.isNullOrEmpty(oldDiseaseInfo.getTumorFlag()) && ObjectUtil.equals(diseaseInfo.getTumorFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			properties.remove("tumorCreateDate");
			properties.remove("tumorCreateOrganCode");
			properties.remove("tumorCreateDoctorCode");
			properties.remove("tumorUpdateDate");
			properties.remove("tumorUpdateOrganCode");
			properties.remove("tumorUpdateDoctorCode");
		}
	}

	/**
	 * 更新时设置纳入日期
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param oldDiseaseInfo
	 *            the old disease info
	 * @param properties
	 *            the properties
	 */
	private void setDisUpdateManagedDate(DmDiseaseInfo diseaseInfo, DmDiseaseInfo oldDiseaseInfo, Set<String> properties) {
		Date date = new Date();
		// 如果已经纳入一种慢病,则后续的纳入实质为更新标志,所以需要检查旧的信息,防止历史信息被覆盖
		// 如果已经纳入,则不更新慢病对应的字段,否则设置纳入日期为当前日期
		if (EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getDiFlag())) {
			properties.remove(DI_MANAGED_DATE_COLUMN);
		} else {
			diseaseInfo.setDiManagedDate(date);
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getHbpFlag())) {
			properties.remove(HBP_MANAGED_DATE_COLUMN);
		} else {
			diseaseInfo.setHbpManagedDate(date);
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getStrokeFlag())) {
			properties.remove(STROKE_MANAGED_DATE_COLUMN);
		} else {
			diseaseInfo.setStrokeManagedDate(date);
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getCoronaryFlag())) {
			properties.remove(CORONARY_MANAGED_DATE_COLUMN);
		} else {
			diseaseInfo.setCoronaryManagedDate(date);
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getTumorFlag())) {
			properties.remove(TUMOR_MANAGED_DATE_COLUMN);
		} else {
			diseaseInfo.setTumorManagedDate(date);
		}
	}

	/**
	 * 设置纳入日期
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 */
	private void setDisAddManagedInfo(DmDiseaseInfo diseaseInfo) {
		Date date = new Date();
		diseaseInfo.setDiManagedDate(date);
		diseaseInfo.setHbpManagedDate(date);
		diseaseInfo.setTumorManagedDate(date);
		diseaseInfo.setStrokeManagedDate(date);
		diseaseInfo.setCoronaryManagedDate(date);
	}

	/**
	 * 保存或者更新慢病人员信息
	 * 
	 * @param personInfo
	 *            the person info
	 * @param diseaseInfo
	 *            the disease info
	 * @return
	 */
	private void saveOrReUpdateDmPerson(PersonInfo personInfo, DmDiseaseInfo diseaseInfo) {
		Criteria criteria = new Criteria("personId", personInfo.getId());
		criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
		DmPersonInfo dmPersonInfo = dmPersonInfoDao.get(criteria);
		if (null == dmPersonInfo) {
			dmPersonInfo = new DmPersonInfo();
		}
		Long id = dmPersonInfo.getId();
		copy(dmPersonInfo, personInfo);
		dmPersonInfo.setId(id);
		dmPersonInfo.setPersonId(personInfo.getId());
		dmPersonInfo.setType(EHRConstants.DM_PERSON_MANGE_TYPE);
		setDmPersonInputInfo(diseaseInfo, dmPersonInfo);
		cdmPersonService.saveOrReUpdateDmPersonInfo(dmPersonInfo);
	}

	/**
	 * 保存或者更新慢病人员信息
	 * 
	 * @param personInfo
	 *            the person info
	 * @param diseaseInfo
	 *            the disease info
	 * @return
	 */
	private void saveOrUpdateDmPerson(PersonInfo personInfo, DmDiseaseInfo diseaseInfo) {
		Criteria criteria = new Criteria("personId", personInfo.getId());
		criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
		DmPersonInfo dmPersonInfo = dmPersonInfoDao.get(criteria);
		if (null == dmPersonInfo) {
			dmPersonInfo = new DmPersonInfo();
		}
		Long id = dmPersonInfo.getId();
		copy(dmPersonInfo, personInfo);
		dmPersonInfo.setId(id);
		dmPersonInfo.setPersonId(personInfo.getId());
		dmPersonInfo.setType(EHRConstants.DM_PERSON_MANGE_TYPE);
		if (ObjectUtil.isNullOrEmpty(dmPersonInfo.getId())) {
			setDmPersonInputInfo(diseaseInfo, dmPersonInfo);
		}
		cdmPersonService.saveOrUpdateDmPersonInfo(dmPersonInfo);
	}

	/**
	 * 保存之后处理其业务
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param oldDiseaseInfo
	 *            the old disease info
	 *
	 * @param properties
	 *            the properties
	 * @return
	 */
	private void dealSthAfterSave(DmDiseaseInfo diseaseInfo, DmDiseaseInfo oldDiseaseInfo, Set<String> properties) {
		/*
		 * // 脑卒中 冠心病 管理方式变更,重新建立随访计划 if
		 * (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag())) {
		 * // 新纳入或者发生变化 if (null == oldDiseaseInfo ||
		 * !diseaseInfo.getStrokeBodyLimitFlag
		 * ().equals(oldDiseaseInfo.getStrokeBodyLimitFlag())) { boolean result
		 * =
		 * followupRecordService.buildStrtumPlanAndUpdNextFollowupDate(diseaseInfo
		 * . getStrokeBodyLimitFlag(), EHRConstants.DM_STROKE_TYPE,
		 * diseaseInfo.getPersonId()); if (!result) { throw new
		 * RuntimeException("脑卒中建立随访计划失败"); } } } if
		 * (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag()))
		 * { if (null == oldDiseaseInfo ||
		 * !diseaseInfo.getCoronaryBodyLimitFlag(
		 * ).equals(oldDiseaseInfo.getCoronaryBodyLimitFlag())) { boolean result
		 * =
		 * followupRecordService.buildStrtumPlanAndUpdNextFollowupDate(diseaseInfo
		 * . getCoronaryBodyLimitFlag(), EHRConstants.DM_CORONARY_TYPE,
		 * diseaseInfo.getPersonId()); if (!result) { throw new
		 * RuntimeException("冠心病建立随访计划失败"); } } }
		 */
        dealSthAfterSaveAsync(diseaseInfo, oldDiseaseInfo, properties);
	}

    private void dealSthAfterSaveAsync(final DmDiseaseInfo diseaseInfo, final DmDiseaseInfo oldDiseaseInfo, final Set<String> properties) {
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    // 更新疾病史
                    tryAddDisHistory(diseaseInfo, oldDiseaseInfo, properties);
                    //更新糖尿病指标
                    //trySaveCicTarget(diseaseInfo, oldDiseaseInfo);
                }
            }).start();
        }catch (Exception ex) {
            log.error("其它信息保存执行失败,请检查详细信息",ex);
        }
    }

    /**
	 * 增加之前处理其它业务
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param properties
	 *            the properties
	 * @return
	 */
	private void dealSthBeforeAdd(DmDiseaseInfo diseaseInfo, Set<String> properties) {
		// 如果肿瘤新纳入,且选择已经管理则加入第一次的随访时间
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag()) && EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(diseaseInfo.getTumorManagedFlag())) {
//			diseaseInfo.setNextTumorFollowupDate(new Date());
//			properties.add("nextTumorFollowupDate");
			buildTumorPlan(diseaseInfo, properties);
		}

		// 脑卒中 冠心病 管理方式变更,重新建立随访计划
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag()) && EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(diseaseInfo.getStrokeManagedFlag())) {
			buildStrokePlan(diseaseInfo, properties);
		}

		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag()) && EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(diseaseInfo.getCoronaryManagedFlag())) {
			buildCoronaryPlan(diseaseInfo, properties);
		}

		//高血压
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag())) {
			buildHbpPlan(diseaseInfo, properties);
		}

		//糖尿病
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag())) {
			buildDiPlan(diseaseInfo, properties);
		}

	}

	/**
	 * 更新前处理
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param oldDiseaseInfo
	 *            the old disease info
	 * @param properties
	 *            the properties
	 */
	private void dealSthBeforeUpdate(DmDiseaseInfo diseaseInfo, DmDiseaseInfo oldDiseaseInfo, Set<String> properties) {

		//高血压已管理
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag())) {
			boolean isFirstManaged = !EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getHbpFlag());
			if (isFirstManaged) {
				this.buildHbpPlan(diseaseInfo, properties);
			}
		}
		//糖尿病已管理
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag())) {
			boolean isFirstManaged = !EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getDiFlag());
			if (isFirstManaged) {
				this.buildDiPlan(diseaseInfo, properties);
			}
		}

		// 如果肿瘤已经管理
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag())) {
			// 检查是否是第一次管理

			boolean isFirstManaged = !EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getTumorFlag());
			boolean currentManagedFlagYes = EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(diseaseInfo.getTumorManagedFlag());
			boolean oldManagedFlagYes = EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(oldDiseaseInfo.getTumorManagedFlag());

			if (isFirstManaged) {
				// 第一次纳入管理,之检查是否管理
				if (currentManagedFlagYes) {
                    buildTumorPlan(diseaseInfo, properties);
//					diseaseInfo.setNextTumorFollowupDate(new Date());
//					properties.add("nextTumorFollowupDate");
				}
			} else {
				if (!oldManagedFlagYes && !currentManagedFlagYes) {
					// 不管理>不管理,不做什么处理
				} else if (oldManagedFlagYes && !currentManagedFlagYes) {
					// 管理>不管理
					// 去掉下次随访日期
					diseaseInfo.setNextTumorFollowupDate(null);
					properties.add("nextTumorFollowupDate");
					// 去掉未完成的随访计划
					followupRecordService.delUnDoFollowupPalnByPersonIdAndDisType(diseaseInfo.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
				} else if (!oldManagedFlagYes && currentManagedFlagYes) {
					boolean hasDeadFollowp = followupRecordService.isHasEndTumorFollowup(diseaseInfo.getPersonId());
					if (hasDeadFollowp) {
						followupRecordService.delUnDoFollowupPalnByPersonIdAndDisType(diseaseInfo.getPersonId(), EHRConstants.DM_TUMOR_TYPE);
					} else {
                        buildTumorPlan(diseaseInfo, properties);
//						Date next = new Date();
//						diseaseInfo.setNextTumorFollowupDate(next);
//						properties.add("nextTumorFollowupDate");
//						followupPlanService.buildTumorPlans(diseaseInfo.getPersonId(), String.valueOf(DateUtil.getCurrentYear()), next);
					}
				} else if (oldManagedFlagYes && currentManagedFlagYes) {
					// 已经管理状态没有变化
					// 肿瘤不用处理
				}
			}

		}

		// 脑卒中
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag())) {

			boolean isFirstManaged = !EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getStrokeFlag());
			boolean currentManagedFlagYes = EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(diseaseInfo.getStrokeManagedFlag());
			boolean oldManagedFlagYes = EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(oldDiseaseInfo.getStrokeManagedFlag());

			if (isFirstManaged) {
				// 第一次纳入管理,之检查是否管理
				if (currentManagedFlagYes) {
					buildStrokePlan(diseaseInfo, properties);
				}
			} else {
				if (!oldManagedFlagYes && !currentManagedFlagYes) {
					// 不管理>不管理,不做什么处理
				} else if (oldManagedFlagYes && !currentManagedFlagYes) {
					followupRecordService.delUnDoFollowupPalnByPersonIdAndDisType(diseaseInfo.getPersonId(), EHRConstants.DM_STROKE_TYPE);
					diseaseInfo.setNextStrokeFollowupDate(null);
					properties.add("nextStrokeFollowupDate");
				} else if (!oldManagedFlagYes && currentManagedFlagYes) {
					buildStrokePlan(diseaseInfo, properties);
				} else if (oldManagedFlagYes && currentManagedFlagYes) {
					// 已经管理状态没有变化,则检查是否满一年标志是否变化,如果变化重新生成计划
					if (!ObjectUtil.equals(oldDiseaseInfo.getStrokeManagedFayFlag(), diseaseInfo.getStrokeManagedFayFlag())) {
						buildStrokePlan(diseaseInfo, properties);
					}
				}
			}
		}

		// 冠心病
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag())) {
			// 检查是否是第一次管理

			boolean isFirstManaged = !EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getCoronaryFlag());
			boolean currentManagedFlagYes = EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(diseaseInfo.getCoronaryManagedFlag());
			boolean oldManagedFlagYes = EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(oldDiseaseInfo.getCoronaryManagedFlag());

			if (isFirstManaged) {
				// 第一次纳入管理,之检查是否管理
				if (currentManagedFlagYes) {
					buildCoronaryPlan(diseaseInfo, properties);
				}
			} else {
				if (!oldManagedFlagYes && !currentManagedFlagYes) {
					// 不管理>不管理,不做什么处理
				} else if (oldManagedFlagYes && !currentManagedFlagYes) {
					followupRecordService.delUnDoFollowupPalnByPersonIdAndDisType(diseaseInfo.getPersonId(), EHRConstants.DM_CORONARY_TYPE);
					diseaseInfo.setNextCoronaryFollowupDate(null);
					properties.add("nextCoronaryFollowupDate");
				} else if (!oldManagedFlagYes && currentManagedFlagYes) {
					buildCoronaryPlan(diseaseInfo, properties);
				} else if (oldManagedFlagYes && currentManagedFlagYes) {
					// 已经管理状态没有变化,则检查是否满一年标志是否变化,如果变化重新生成计划
					if (!ObjectUtil.equals(oldDiseaseInfo.getCoronaryManagedFayFlag(), diseaseInfo.getCoronaryManagedFayFlag())) {
						buildCoronaryPlan(diseaseInfo, properties);
					}
				}
			}

		}

	}

	/**
	 * 
	 * Build stroke plan
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param properties
	 *            the properties
	 */
	private void buildStrokePlan(DmDiseaseInfo diseaseInfo, Set<String> properties) {
		Date date = followupPlanService.buildStrtumPlan(diseaseInfo.getStrokeManagedFayFlag(), EHRConstants.DM_STROKE_TYPE, diseaseInfo.getPersonId());
		diseaseInfo.setNextStrokeFollowupDate(date);
		properties.add("nextStrokeFollowupDate");
	}

	/**
	 * Build coronary plan.
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param properties
	 *            the properties
	 */
	private void buildCoronaryPlan(DmDiseaseInfo diseaseInfo, Set<String> properties) {
		Date date = followupPlanService.buildStrtumPlan(diseaseInfo.getCoronaryManagedFayFlag(), EHRConstants.DM_CORONARY_TYPE, diseaseInfo.getPersonId());
		diseaseInfo.setNextCoronaryFollowupDate(date);
		properties.add("nextCoronaryFollowupDate");
	}

	/**
	 * Build Hbp plan.
	 *
	 * @param diseaseInfo
	 *            the disease info
	 * @param properties
	 *            the properties
	 */
	private void buildHbpPlan(DmDiseaseInfo diseaseInfo, Set<String> properties) {
		Date date = followupPlanService.buildHbpAndDiPlan(EHRConstants.DM_HBP_TYPE,new Date(), diseaseInfo.getPersonId(), true);
		diseaseInfo.setNextHbpFollowupDate(date);
		properties.add("nextHbpFollowupDate");
	}

	/**
	 * Build Di plan.
	 *
	 * @param diseaseInfo
	 *            the disease info
	 * @param properties
	 *            the properties
	 */
	private void buildDiPlan(DmDiseaseInfo diseaseInfo, Set<String> properties) {
		Date date = followupPlanService.buildHbpAndDiPlan(EHRConstants.DM_DI_TYPE_TWO,new Date(), diseaseInfo.getPersonId(), true);
		diseaseInfo.setNextDiFollowupDate(date);
		properties.add("nextDiFollowupDate");
	}
    /**
     *
     * Build tumor plan
     *
     * @param diseaseInfo
     *            the disease info
     * @param properties
     *            the properties
     */
    private void buildTumorPlan(DmDiseaseInfo diseaseInfo, Set<String> properties) {
        Date date = new Date();
        if (followupRecordService.isHasTumorFollowup(diseaseInfo.getPersonId())) {
            date = followupPlanService.buildTumorPlan(null, EHRConstants.DM_FOLLOWUP_TUMOR_NORMAL, EHRConstants.DM_TUMOR_TYPE, diseaseInfo.getPersonId());
        }else{
            date = followupPlanService.buildTumorPlan(null, "0", EHRConstants.DM_TUMOR_TYPE, diseaseInfo.getPersonId());

        }
        diseaseInfo.setNextTumorFollowupDate(date);
        properties.add("nextTumorFollowupDate");
    }


    /**
     * Save cic target.
     *
     * @param diseaseInfo the disease info
     * @param oldDiseaseInfo the old disease info
     */
    private void trySaveCicTarget(DmDiseaseInfo diseaseInfo, DmDiseaseInfo oldDiseaseInfo) {
        try {
            Long personId = diseaseInfo.getPersonId();
            if (null != personId) {
                CicTarget cicTarget = new CicTarget();
                cicTarget.setPersonId(String.valueOf(personId));
                if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag()) || (null != oldDiseaseInfo && EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getDiFlag()))) {
                    cicTarget.setDiabetesFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
                } else {
                    cicTarget.setDiabetesFlag(EHRConstants.CIC_TARGET_FLAG_FALSE);
                }
                Set<String> select = new HashSet<>(1);
                select.add("diabetesFlag");
                cicTargetService.saveTargetValue(cicTarget, select);
            }
        } catch (Exception ex) {
            log.error("save cic target  error ,detail:",ex);
        }
    }

	/**
	 * Add dis history.
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param oldDiseaseInfo
	 *            the old disease info
	 * @param properties
	 *            the properties
	 */
    private void tryAddDisHistory(final DmDiseaseInfo diseaseInfo, final DmDiseaseInfo oldDiseaseInfo, final Set<String> properties) {
        try {
            addDisHistory(diseaseInfo, properties);
        } catch (Exception e) {
            log.error("疾病史更新失败", e);
        }
    }

	/**
	 * Add dis history.
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param properties
	 *            the properties
	 */
	private void addDisHistory(final DmDiseaseInfo diseaseInfo, final Set<String> properties) {
		Long personId = diseaseInfo.getPersonId();

		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag())) {
			doAddDisHistory(personId, EHRConstants.DM_TUMOR_TYPE, diseaseInfo.getTumorDiagnosisDate());
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag())) {
			doAddDisHistory(personId, EHRConstants.DM_HBP_TYPE, diseaseInfo.getHbpDiagnosedDate());
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag())) {
			doAddDisHistory(personId, EHRConstants.DM_STROKE_TYPE, diseaseInfo.getStrokeDiagnosisDate());
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag())) {
			doAddDisHistory(personId, EHRConstants.DM_CORONARY_TYPE, diseaseInfo.getCoronaryDiagnosisDate());
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag())) {
			doAddDisHistory(personId, EHRConstants.DM_DI_TYPE, diseaseInfo.getDiDiagnosedDate());
		}
	}

	/**
	 * 添加疾病史
	 * 
	 * @param personId
	 *            the person id
	 * @param type
	 *            the type
	 * @param date
	 *            the date
	 */
	private void doAddDisHistory(Long personId, String type, Date date) {
		DisHistoryDisCode disCode = null;
		switch (type) {
		case EHRConstants.DM_DI_TYPE:
			disCode = DisHistoryDisCode.DI;
			break;
		case EHRConstants.DM_HBP_TYPE:
			disCode = DisHistoryDisCode.HBP;
			break;
		case EHRConstants.DM_STROKE_TYPE:
			disCode = DisHistoryDisCode.STROKE;
			break;
		case EHRConstants.DM_TUMOR_TYPE:
			disCode = DisHistoryDisCode.TUMOR;
			break;
		case EHRConstants.DM_CORONARY_TYPE:
			disCode = DisHistoryDisCode.CORONARY;
			break;
		default:
			break;
		}

		if (null != disCode) {
			platformService.addDiseaseHistory(personId, disCode, date);
		}

	}

	// ==============保存或者更新管理卡 ============//

	/**
	 * Check duplicate manage.
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param oldDiseaseInfo
	 *            the old disease info
	 * @return the set
	 */
	private Set<String> checkDuplicateManage(DmDiseaseInfo diseaseInfo, DmDiseaseInfo oldDiseaseInfo) {
		Set<String> result = new HashSet<>();
		if (ObjectUtil.isNullOrEmpty(oldDiseaseInfo)) {
			return result;
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag()) && EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getHbpFlag())) {
			result.add(ManageCardErrorCode.HBP_HAS_MANAGED.getValue());
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag()) && EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getDiFlag())) {
			result.add(ManageCardErrorCode.DI_HAS_MANAGED.getValue());
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag()) && EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getStrokeFlag())) {
			result.add(ManageCardErrorCode.STROKE_HAS_MANAGED.getValue());
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag()) && EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getCoronaryFlag())) {
			result.add(ManageCardErrorCode.CORONARY_HAS_MANAGED.getValue());
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag()) && EHRConstants.DM_MANAGED_FLAG.equals(oldDiseaseInfo.getTumorFlag())) {
			result.add(ManageCardErrorCode.TUMOR_HAS_MANAGED.getValue());
		}
		return result;
	}

	/**
	 * 平台人员到慢病人员
	 * 
	 * @param dmPersonInfo
	 *            the dm person info
	 * @param personInfo
	 *            the person info
	 */
	private void copy(DmPersonInfo dmPersonInfo, PersonInfo personInfo) {
		cdmPersonService.ehrPersonInfoToDmPersonInfo(dmPersonInfo, personInfo);
	}

	/**
	 * 创建审批信息
	 * 
	 * @param cdmid
	 *            the cdmid
	 * @param Comments
	 *            the comments
	 * @param status
	 *            the status
	 * @param user
	 *            the user
	 * @param organization
	 *            the organization
	 * @return cdm approval info
	 */
	private CdmApprovalInfo createApproval(Integer cdmid, String Comments, String status, User user, Organization organization) {
		CdmApprovalInfo approvalInfo = new CdmApprovalInfo();
		approvalInfo.setApprovalDate(new Date());
		approvalInfo.setComments(Comments);
		approvalInfo.setCdmId(cdmid);
		approvalInfo.setStatus(status);
		approvalInfo.setUserId(user.getId().toString());
		approvalInfo.setUserName(user.getName());
		approvalInfo.setOrgCode(organization.getOrganCode());
		approvalInfo.setOrgName(organization.getOrganName());
		return approvalInfo;
	}

	/**
	 * Gets deal properties.
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @return the deal properties
	 */
	private Set<String> getDealProperties(DmDiseaseInfo diseaseInfo) {
		Set<String> all = new HashSet<>();
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag())) {
			all.addAll(this.hbpPros);
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag())) {
			all.addAll(this.diPros);
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag())) {
			all.addAll(this.strokePros);
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag())) {
			all.addAll(this.coronaryPros);
		}
		if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag())) {
			all.addAll(this.tumorPros);
		}
		return all;
	}

	/**
	 * 设置人员输入信息
	 * 
	 * @param diseaseInfo
	 *            the disease info
	 * @param dmPersonInfo
	 *            the dm person info
	 */
	private void setDmPersonInputInfo(DmDiseaseInfo diseaseInfo, DmPersonInfo dmPersonInfo) {
		Organization organization = diseaseInfo.getCurrentOrganization();
		if (ObjectUtil.isNotEmpty(organization)) {
			String orgCode = organization.getOrganCode();
			Organization current = organizationApp.queryOrgan(orgCode);
			// 冗余上级机构
			String parentCode = current.getParentCode();
			if (ObjectUtil.equals(current.getGenreCode(), OrgGenreCode.STATION.getValue())) {
				// 冗余中心
				dmPersonInfo.setCreateCenterOrganCode(parentCode);
			}
			if(ObjectUtil.equals(current.getGenreCode(), OrgGenreCode.CENTRE.getValue())) {
				// 冗余中心
				dmPersonInfo.setCreateCenterOrganCode(current.getOrganCode());
			}
			// 冗余镇
			dmPersonInfo.setCreateGbcode(current.getGbCode());
			dmPersonInfo.setCreateOrganCode(orgCode);
		}
	}

	/**
	 * 设置输入信息
	 * 
	 * @param update
	 *            the update
	 * @param diseaseInfo
	 *            the disease info
	 * @param properties
	 *            the properties
	 */
	private void setInputInfo(Boolean update, DmDiseaseInfo diseaseInfo, Set<String> properties) {
		Organization organization = diseaseInfo.getCurrentOrganization();
		User user = diseaseInfo.getCurrentUser();
		Date nowDate = new Date();
		diseaseInfo.setUpdateDate(nowDate);
		diseaseInfo.setUpdateDoctorCode(user.getUserCode());
		diseaseInfo.setUpdateDoctorName(user.getName());
		diseaseInfo.setUpdateOrganCode(organization.getOrganCode());
		diseaseInfo.setUpdateOrganName(organization.getOrganName());
		properties.addAll(this.updatePros);
		if (!update) {
			diseaseInfo.setCreateDate(nowDate);
			diseaseInfo.setCreateDoctorCode(user.getUserCode());
			diseaseInfo.setCreateDoctorName(user.getName());
			diseaseInfo.setCreateOrganCode(organization.getOrganCode());
			diseaseInfo.setCreateOrganName(organization.getOrganName());
			properties.addAll(this.createPros);
		}
		if(ObjectUtil.equals(diseaseInfo.getHbpFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			diseaseInfo.setHbpCreateDate(nowDate);
			diseaseInfo.setHbpCreateOrganCode(organization.getOrganCode());
			diseaseInfo.setHbpCreateDoctorCode(user.getUserCode());
			diseaseInfo.setHbpUpdateDate(nowDate);
			diseaseInfo.setHbpUpdateOrganCode(organization.getOrganCode());
			diseaseInfo.setHbpUpdateDoctorCode(user.getUserCode());
		}
		if(ObjectUtil.equals(diseaseInfo.getDiFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			diseaseInfo.setDiCreateDate(nowDate);
			diseaseInfo.setDiCreateOrganCode(organization.getOrganCode());
			diseaseInfo.setDiCreateDoctorCode(user.getUserCode());
			diseaseInfo.setDiUpdateDate(nowDate);
			diseaseInfo.setDiUpdateOrganCode(organization.getOrganCode());
			diseaseInfo.setDiUpdateDoctorCode(user.getUserCode());
		}
		if(ObjectUtil.equals(diseaseInfo.getStrokeFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			diseaseInfo.setStrokeCreateDate(nowDate);
			diseaseInfo.setStrokeCreateOrganCode(organization.getOrganCode());
			diseaseInfo.setStrokeCreateDoctorCode(user.getUserCode());
			diseaseInfo.setStrokeUpdateDate(nowDate);
			diseaseInfo.setStrokeUpdateOrganCode(organization.getOrganCode());
			diseaseInfo.setStrokeUpdateDoctorCode(user.getUserCode());
		}
		if(ObjectUtil.equals(diseaseInfo.getCoronaryFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			diseaseInfo.setCoronaryCreateDate(nowDate);
			diseaseInfo.setCoronaryCreateOrganCode(organization.getOrganCode());
			diseaseInfo.setCoronaryCreateDoctorCode(user.getUserCode());
			diseaseInfo.setCoronaryUpdateDate(nowDate);
			diseaseInfo.setCoronaryUpdateOrganCode(organization.getOrganCode());
			diseaseInfo.setCoronaryUpdateDoctorCode(user.getUserCode());
		}
		if(ObjectUtil.equals(diseaseInfo.getTumorFlag(), EHRConstants.DM_MANAGED_FLAG)) {
			diseaseInfo.setTumorCreateDate(nowDate);
			diseaseInfo.setTumorCreateOrganCode(organization.getOrganCode());
			diseaseInfo.setTumorCreateDoctorCode(user.getUserCode());
			diseaseInfo.setTumorUpdateDate(nowDate);
			diseaseInfo.setTumorUpdateOrganCode(organization.getOrganCode());
			diseaseInfo.setTumorUpdateDoctorCode(user.getUserCode());
		}
	}

	@Override
	@Transactional
	public void modifyManageOrganization(Long personId, String oldOrganCode, String newOrganCode) {
		Assert.notNull(personId, "迁移人员id不能为空");
		Assert.notNull(newOrganCode, "迁移目标机构不能为空");
		Assert.notNull(oldOrganCode, "当前机构不能为空");
		Organization newOrganization = organizationApp.queryOrgan(newOrganCode);
		Assert.notNull(newOrganization, "迁移目标机构不存在,指定的organcode:" + newOrganCode);
		Parameters parameters = new Parameters("createOrganCode", newOrganCode);
		parameters.add("createOrganName", newOrganization.getOrganName());
		Criteria criteria = new Criteria("createOrganCode", oldOrganCode);
		criteria.add("personId", personId);
		// 迁移随访数据
		// followupRecordService.modifyManageOrganization(personId,
		// oldOrganCode, newOrganCode);
		// 迁移保健计划
		// dmHypertensionConclusionDao.update(parameters, criteria);
		// 迁移管理卡
		dmDiseaseInfoDao.update(parameters, criteria);
		// 迁移人员基本信息,人员冗余了上级和镇信息,都需要更新
		parameters.add("createCenterOrganCode", newOrganization.getParentCode());// 中心,直接取parentCode因为迁移针只对站
		parameters.add("createGbcode", newOrganization.getGbCode()); // 所在镇
		// 只针对管理卡人员信息
		criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
		dmPersonInfoDao.update(parameters, criteria);
	}

	/**
	 * The entry point of application.
	 * 
	 * @param args
	 *            the input arguments
	 */
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.err.println(Thread.currentThread().getName());
				throw new RuntimeException(Thread.currentThread().getName());
			}
		}).start();
	}

	/**
	 * 管理卡的导出功能
	 *
	 * @param page
	 * @param criteria
	 * @return
	 */
	public List<Map<String, Object>> exportManageCard(Page page, Criteria criteria, Organization organization, RoleType roleType) {
		if (null == criteria) {
			criteria = this.getHmCardDeleteStatus("dmDiseaseInfo.", EHRConstants.DM_MANAGED_FLAG);
		}
		setDiseaseInfoListDefaultParam(organization, roleType, criteria);
		return dmDiseaseInfoDao.exportManageCard(page, criteria);
	}

	@Override
	public List<Map<String, Object>> exportHmCardList(Page page, Criteria criteria, Organization organization, RoleType roleType) {
		if (null == criteria) {
			criteria = this.getHmCardDeleteStatus("dmDiseaseInfo.", EHRConstants.DM_MANAGED_FLAG);
		}
		setDiseaseInfoListDefaultParam(organization, roleType, criteria);
		List<Map<String, Object>> list = dmDiseaseInfoDao.exportManageCardList(page, criteria);
		return list;
	}

	/**
	 * 统计五种慢病已管理的数量
	 * @param criteria
	 * @param organization
	 * @param roleType
	 * @return
	 */
	@Override
	public Map<String, Object> getMangerNum(Criteria criteria, Organization organization, RoleType roleType) {
		if (null == criteria) {
			criteria = new Criteria("dmDiseaseInfo.STATUS", EHRConstants.DM_MANAGE_STATUS_NORMAL);
			criteria = criteria.add(this.getHmCardDeleteStatus("dmDiseaseInfo.", EHRConstants.DM_MANAGED_FLAG));
		}
		setDiseaseInfoListDefaultParam(organization, roleType, criteria);
		return dmDiseaseInfoDao.getMangerNum(criteria);
	}

	/**
	 *  统计不同时间段每种慢病的纳入管理的情况
	 * @param dateType
	 * @return
	 */
	@Override
	public Map<String, Object> getBringNum(int dateType, Organization organization, RoleType roleType){
		return dmDiseaseInfoDao.getBringNum(dateType, organization, roleType);
	}

	/**
	 * 慢病纳入统计
	 * @param page
	 * @param form
	 * @return
	 */
	@Override
	public PageList<Map<String, Object>> getMangerIntoStatistics(Page page, ReportQueryForm form, Organization currentOrg) {
		return dmDiseaseInfoDao.getMangerIntoStatistics(page, form, currentOrg);
	}

	/**
	 * 导出纳入统计
	 * @param page
	 * @param form
	 * @return
	 */
	@Override
	public List<Map<String, Object>> exportMangerIntoStatistics(Page page, ReportQueryForm form, Organization currentOrg) {
		PageList<Map<String, Object>> pageList = dmDiseaseInfoDao.getMangerIntoStatistics(page, form, currentOrg);
		List<Map<String, Object>> list = null;
		if (null != pageList) {
			list = pageList.getList();
		}
		if (null == list) {
			return Collections.emptyList();
		}
		return list;
	}

	/**
	 * 获取高血压糖尿病规范化管理人数
	 * @return
	 */
	public List<Map<String, Object>> getHbpDiManagerMaps(String year) {
		return dmDiseaseInfoDao.getHbpDiManagerMaps(year);
	}

	@Override
	public PageList<DmYiShare> searchYshareList(Page page, Criteria criteria) {
		PageList<DmYiShare> rs = yiShareDao.getPageList(page,criteria,new Order("CHECK_TIME",false));
		return rs;
	}


	/**
	 * 根据Id和疾病类型删除相应的管理卡
	 * @param dmDiseaseInfo
	 * @param organization
	 * @param user
	 */
	@Override
	@Transactional
	public void deleteHmCardBySelectedType(DmDiseaseInfo dmDiseaseInfo, Organization organization, User user) {
		Long diseaseinfoId = dmDiseaseInfo.getId();
		DmDiseaseInfo dmDiseaseInfoDB = dmDiseaseInfoDao.get(diseaseinfoId);
		Assert.notNull(dmDiseaseInfo, "指定删除的管理卡不存在,指定的id为" + diseaseinfoId);
		Long personId = dmDiseaseInfo.getPersonId();
		Assert.notNull(personId, "指定删除的管理卡的人员id为空,指定的id为" + diseaseinfoId);
		Assert.notNull(organization, "删除的管理卡,操作机构为空");
		Assert.notNull(user, "删除的管理卡,操作用户为空" );
		List<DisHistoryDisCode> toDeCodes = new ArrayList<>();
		List<String> disTypes = new ArrayList<String>();
		setDmDiseaseInfo(dmDiseaseInfo, dmDiseaseInfoDB, organization, user, toDeCodes, disTypes, EHRConstants.DELETE_FLG_1.toString(),EHRConstants.DM_MANAGED_FLAG);
		dmDiseaseInfoDao.update(dmDiseaseInfoDB);
		this.saveDmDiseaseInfoLog(dmDiseaseInfo, organization, user, EHRConstants.DELETE_FLG_1.toString(), disTypes.toString());
		// 删除保健计划
		Criteria criteria = new Criteria("personId", personId);
		dmHypertensionConclusionDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_1), criteria);
		// 删除随访信息
		followupRecordService.delFollowupPlanByPersonIdAndDisType(personId, disTypes);
		// 删除疾病史
		platformService.deleteDiseaseHistory(personId, toDeCodes);
	}

	/**
	 * 根据Id和疾病类型恢复相应的管理卡
	 * @param dmDiseaseInfo
	 * @param organization
	 * @param user
	 */
	@Override
	@Transactional
	public void renewHmCardBySelectedType(DmDiseaseInfo dmDiseaseInfo, Organization organization, User user) {
		DmDiseaseInfo dmDiseaseInfoDB = dmDiseaseInfoDao.get(dmDiseaseInfo.getId());
		Assert.notNull(dmDiseaseInfo, "指定恢复的管理卡不存在,指定的id为" + dmDiseaseInfo.getId());
		Long personId = dmDiseaseInfo.getPersonId();
		Assert.notNull(personId, "指定恢复的管理卡的人员id为空,指定的id为" + dmDiseaseInfo.getId());
		Assert.notNull(organization, "恢复的管理卡,操作机构为空");
		Assert.notNull(user, "恢复的管理卡,操作用户为空" );
		List<DisHistoryDisCode> toDeCodes = new ArrayList<>();
		List<String> disTypes = new ArrayList<String>();
		setDmDiseaseInfo(dmDiseaseInfo, dmDiseaseInfoDB, organization, user, toDeCodes, disTypes,  EHRConstants.DM_MANAGED_FLAG, EHRConstants.DELETE_FLG_1.toString());
		dmDiseaseInfoDao.update(dmDiseaseInfoDB);
		this.saveDmDiseaseInfoLog(dmDiseaseInfo, organization, user, EHRConstants.DM_MANAGED_FLAG, disTypes.toString());
		//恢复保健计划
		Criteria criteria = new Criteria("personId", personId);
		dmHypertensionConclusionDao.update(new Parameters("IS_DELETE", EHRConstants.DELETE_FLG_0), criteria);
		//恢复随访信息
		followupRecordService.renewFollowupAfterRenewlHm(personId);
		//恢复疾病史
		platformService.renewDiseaseHistory(personId, toDeCodes);
	}

	/**
	 * 保存管理卡的撤销恢复纪录
	 * @param dmDiseaseInfo
	 * @param organization
	 * @param user
	 * @param operateType 操作类型：撤销 1 恢复 2
	 */
	private void saveDmDiseaseInfoLog(DmDiseaseInfo dmDiseaseInfo, Organization organization,
									  User user, String operateType, String disTypes) {
		DmDiseaseInfoLog dmDiseaseInfoLog = new DmDiseaseInfoLog();
		dmDiseaseInfoLog.setPersonId(dmDiseaseInfo.getPersonId());
		dmDiseaseInfoLog.setDiseaseInfoId(dmDiseaseInfo.getId());
		dmDiseaseInfoLog.setDisType(disTypes);
		dmDiseaseInfoLog.setOperateType(operateType);
		dmDiseaseInfoLog.setCreateDate(new Date());
		dmDiseaseInfoLog.setCreateOrganCode(organization.getOrganCode());
		dmDiseaseInfoLog.setCreateDoctorCode(user.getUserCode());
		dmDiseaseInfoLogDao.insert(dmDiseaseInfoLog);
	}

	/**
	 * 根据选择的需要删除的慢病管理卡类型删除数据
	 * @param dmDiseaseInfo
	 * @param dmDiseaseInfoDB
	 * @param organization
	 * @param user
	 * @return
	 */
	private void setDmDiseaseInfo(DmDiseaseInfo dmDiseaseInfo, DmDiseaseInfo dmDiseaseInfoDB, Organization organization, User user,
								  List<DisHistoryDisCode> toDeCodes, List<String> disTypes, String isDelete, String equalValue) {
		if(ObjectUtil.equals(dmDiseaseInfo.getHbpFlag(), equalValue)) {
			toDeCodes.add(DisHistoryDisCode.HBP);
			disTypes.add(EHRConstants.DM_HBP_TYPE);
			this.setHbpCard(dmDiseaseInfoDB, organization, user, isDelete);
		}
		if(ObjectUtil.equals(dmDiseaseInfo.getDiFlag(), equalValue)) {
			toDeCodes.add(DisHistoryDisCode.DI);
			disTypes.add(EHRConstants.DM_DI_TYPE);
			this.setDiCard(dmDiseaseInfoDB, organization, user, isDelete);
		}
		if(ObjectUtil.equals(dmDiseaseInfo.getStrokeFlag(), equalValue)) {
			toDeCodes.add(DisHistoryDisCode.STROKE);
			disTypes.add(EHRConstants.DM_STROKE_TYPE);
			this.setStrokeCard(dmDiseaseInfoDB, organization, user, isDelete);
		}
		if(ObjectUtil.equals(dmDiseaseInfo.getCoronaryFlag(), equalValue)) {
			toDeCodes.add(DisHistoryDisCode.CORONARY);
			disTypes.add(EHRConstants.DM_CORONARY_TYPE);
			this.setCoronaryCard(dmDiseaseInfoDB, organization, user, isDelete);
		}
		if(ObjectUtil.equals(dmDiseaseInfo.getTumorFlag(), equalValue)) {
			toDeCodes.add(DisHistoryDisCode.TUMOR);
			disTypes.add(EHRConstants.DM_TUMOR_TYPE);
			this.setTumorCard(dmDiseaseInfoDB, organization, user, isDelete);
		}
	}

	/**
	 *撤销高血压管理卡需要更新的值
	 * @param dmDiseaseInfoDB
	 * @param organization
	 * @param user
	 * @param isDelete 0:表示存在 1:表示已删除
	 */
	private void setHbpCard(DmDiseaseInfo dmDiseaseInfoDB, Organization organization, User user, String isDelete){
		dmDiseaseInfoDB.setHbpFlag(isDelete);
		dmDiseaseInfoDB.setHbpUpdateDoctorCode(String.valueOf(user.getId()));
		dmDiseaseInfoDB.setHbpUpdateOrganCode(organization.getOrganCode());
		dmDiseaseInfoDB.setHbpUpdateDate(new Date());
	}

	/**
	 *撤销高血压糖尿病需要更新的值
	 * @param dmDiseaseInfoDB
	 * @param organization
	 * @param user
	 * @param isDelete 0:表示存在 1:表示已删除
	 */
	private void setDiCard(DmDiseaseInfo dmDiseaseInfoDB, Organization organization, User user, String isDelete){
		dmDiseaseInfoDB.setDiFlag(isDelete);
		dmDiseaseInfoDB.setDiUpdateDoctorCode(String.valueOf(user.getId()));
		dmDiseaseInfoDB.setDiUpdateOrganCode(organization.getOrganCode());
		dmDiseaseInfoDB.setDiUpdateDate(new Date());
	}

	/**
	 *撤销脑卒中管理卡需要更新的值
	 * @param dmDiseaseInfoDB
	 * @param organization
	 * @param user
	 * @param isDelete 0:表示存在 1:表示已删除
	 */
	private void setStrokeCard(DmDiseaseInfo dmDiseaseInfoDB, Organization organization, User user, String isDelete){
		dmDiseaseInfoDB.setStrokeFlag(isDelete);
		dmDiseaseInfoDB.setStrokeUpdateDoctorCode(String.valueOf(user.getId()));
		dmDiseaseInfoDB.setStrokeUpdateOrganCode(organization.getOrganCode());
		dmDiseaseInfoDB.setStrokeUpdateDate(new Date());
	}

	/**
	 *撤销脑冠心病管理卡需要更新的值
	 * @param dmDiseaseInfoDB
	 * @param organization
	 * @param user
	 * @param isDelete 0:表示存在 1:表示已删除
	 */
	private void setCoronaryCard(DmDiseaseInfo dmDiseaseInfoDB, Organization organization, User user, String isDelete){
		dmDiseaseInfoDB.setCoronaryFlag(isDelete);
		dmDiseaseInfoDB.setCoronaryUpdateDoctorCode(String.valueOf(user.getId()));
		dmDiseaseInfoDB.setCoronaryUpdateOrganCode(organization.getOrganCode());
		dmDiseaseInfoDB.setCoronaryUpdateDate(new Date());
	}

	/**
	 *撤销肿瘤管理卡需要更新的值
	 * @param dmDiseaseInfoDB
	 * @param organization
	 * @param user
	 * @param isDelete 0:表示存在 1:表示已删除
	 */
	private void setTumorCard(DmDiseaseInfo dmDiseaseInfoDB, Organization organization, User user, String isDelete){
		dmDiseaseInfoDB.setTumorFlag(isDelete);
		dmDiseaseInfoDB.setTumorUpdateDoctorCode(String.valueOf(user.getId()));
		dmDiseaseInfoDB.setTumorUpdateOrganCode(organization.getOrganCode());
		dmDiseaseInfoDB.setTumorUpdateDate(new Date());
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param alias
	 * @param isDelete
	 * @return
	 */
	private Criteria getHmCardDeleteStatus(String alias, String isDelete) {
		Criteria criteria = new Criteria();
		criteria.add(alias + "hbp_flag", isDelete);
		criteria.add(LOP.OR, alias + "di_flag", isDelete);
		criteria.add(LOP.OR, alias + "stroke_flag", isDelete);
		criteria.add(LOP.OR, alias + "coronary_flag", isDelete);
		criteria.add(LOP.OR, alias + "tumor_flag", isDelete);
		return criteria;
	}
}
