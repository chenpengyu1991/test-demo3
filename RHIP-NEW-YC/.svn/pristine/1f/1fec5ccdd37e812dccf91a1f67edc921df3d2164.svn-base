package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.exception.BaseException;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.common.ApprovalState;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.ehr.entity.message.MessageSent;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.ihm.IMessageSentDao;
import com.founder.rhip.ehr.repository.management.ICdmApprovalInfoDao;
import com.founder.rhip.ehr.repository.management.ICdmStatusInfoDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.repository.management.IDmReportInfoDao;
import com.founder.rhip.ehr.service.basic.IReportRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

/**
 * 慢病报卡
 */
@Service(value = "reportCardService")
public class ReportCardServiceImpl extends AbstractService implements IReportCardService {

	/**
	 * The Dm report info dao.
	 */
	@Resource(name = "dmReportInfoDao")
	private IDmReportInfoDao dmReportInfoDao;

	/**
	 * The Cdm status info dao.
	 */
	@Resource(name = "cdmStatusInfoDao")
	private ICdmStatusInfoDao cdmStatusInfoDao;

	/**
	 * The Cdm approval info dao.
	 */
	@Resource(name = "cdmApprovalInfoDao")
	private ICdmApprovalInfoDao cdmApprovalInfoDao;

	/**
	 * The Organization app.
	 */
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	/**
	 * The Report record service.
	 */
	@Resource(name = "reportRecordService")
	private IReportRecordService reportRecordService;

	/**
	 * The Cdm person service.
	 */
	@Resource(name = "cdmPersonService")
	private ICdmPersonService cdmPersonService;

	/**
	 * The Disease info dao.
	 */
	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao diseaseInfoDao;

	@Resource(name = "platformService")
	private IPlatformService platformService;

	@Resource(name = "messageSentDao")
	private IMessageSentDao messageSentDao;

	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

	/** 高血压保存信息 */
	private String[] hbpProperties;

	/** 糖尿病保存信息 */
	private String[] diProperties;

	/** 脑卒中 */
	private String[] strokeProperties;

	/** 肿瘤 */
	private String[] tumorProperties;

	/** 冠心病 */
	private String[] coronaryProperties;

	/** 四种上报慢病更新字段 */
	private String[] updateProperties;

	/**
	 * 状态cache
	 */
	private static final Map<String, String> statusRule = new HashMap<String, String>();
	/**
	 * 状态对应task cache
	 */
	private static final Map<String, IUserTask<DmReportInfo>> noteTask = new HashMap<>();

	/**
	 * The constant NORMAL_REPORT_STATUS.
	 */
	private static final String[] NORMAL_REPORT_STATUS = new String[] { ApprovalState.ALLOC_REJECT_FIRST.getValue(), ApprovalState.ALLOC_REJECT_SECOND.getValue(), ApprovalState.ALLOCATED.getValue(), ApprovalState.DEATH.getValue(),
			ApprovalState.MANAGED.getValue(), ApprovalState.READY.getValue(), ApprovalState.REJECT.getValue(), ApprovalState.VERIFIED_FIRST.getValue(), ApprovalState.VERIFIED_SECOND.getValue() };

	/**
	 * The HBP _ pROPERTIES.
	 */
	private static final List<String> HBP_PROPERTIES = Arrays.asList("hbpType", "hbpAccidentDate", "hbpDiagnosisDate", "hbpDiagnosisDepends", "hbpIcdTenCode");

	/**
	 * The DI _ pROPERTIES.
	 */
	private static final List<String> DI_PROPERTIES = Arrays.asList("diType", "diAccidentDate", "diDiagnosisDate", "diDiagnosisDepends", "diIcdTenCode");
	/**
	 * The STROKE _ pROPERTIES.
	 */
	private static final List<String> STROKE_PROPERTIES = Arrays.asList("strokeType", "strokeAccidentDate", "strokeDiagnosisDate", "strokeDiagnosisDepends", "strokeIcdTenCode");
	/**
	 * The constant CORONARY_PROPERTIES.
	 */
	private static final List<String> CORONARY_PROPERTIES = Arrays.asList("coronaryType", "coronaryAccidentDate", "coronaryDiagnosisDate", "coronaryDiagnosisDepends", "coronaryIcdTenCode");
	/**
	 * The constant TUMOR_PROPERTIES.
	 */
	private static final List<String> TUMOR_PROPERTIES = Arrays.asList("tumorType", "tumorDeathFirstFlag", "tumorIcdTenType", "tumorInformedFlag", "tumorIcdTenCode", "tumorIcdTenName", "tumorPrimaryPart", "tumorMetastasisPart",
			"tumorDiagnosisDepends", "tumorPathologyType", "tumorIcdThreeCode", "tumorAccidentDate", "tumorDiagnosisDate", "isSecondary", "secondaryId");
	/**
	 * The constant COMMON_PROPERTIES.
	 */
	private static final List<String> COMMON_PROPERTIES = Arrays.asList("deathReason", "deathDate", "deathReportOrganCode", "dmPersonId", "personId", "idcard", "cdmId", "disType", "reportType", "subDisType", "ehrNo", "admissionNo",
			"diagnosisOrganCode", "diagnosisOrganName", "diagnoseDoctor", "diagnosisDate", "updateOrganCode", "updateOrganName", "updateDoctorCode", "updateDoctorName", "updateDate", "manageOrganCode", "superManageOrganCode", "manageOrganName",
			"superManageOrganName", "createOrganCode", "createOrganName", "createDoctorCode", "createDoctorName", "createDate", "otherDiagnosisOrganName", "otherDiagnosisOrganFlag","createCenterOrganCode");
	/**
	 * The COMMON _ uPDATE _ pROPERTIES.
	 */
	private static final List<String> COMMON_UPDATE_PROPERTIES = Arrays.asList("updateOrganCode", "updateOrganName", "updateDoctorCode", "updateDoctorName", "updateDate", "ehrNo", "admissionNo");

	/**
	 * Init void.
	 */
	@PostConstruct
	public void init() {

		int size = COMMON_PROPERTIES.size() + DI_PROPERTIES.size();

		// 糖尿病
		ArrayList<String> resultList = new ArrayList<>(size);
		resultList.addAll(COMMON_PROPERTIES);
		resultList.addAll(DI_PROPERTIES);
		this.diProperties = resultList.toArray(new String[size]);

		// 高血压
		size = COMMON_PROPERTIES.size() + HBP_PROPERTIES.size();
		resultList = new ArrayList<>(size);
		resultList.addAll(COMMON_PROPERTIES);
		resultList.addAll(HBP_PROPERTIES);
		this.hbpProperties = resultList.toArray(new String[size]);

		// 脑卒中
		size = COMMON_PROPERTIES.size() + STROKE_PROPERTIES.size();
		resultList = new ArrayList<>(size);
		resultList.addAll(COMMON_PROPERTIES);
		resultList.addAll(STROKE_PROPERTIES);
		this.strokeProperties = resultList.toArray(new String[size]);
		// 冠心病
		size = COMMON_PROPERTIES.size() + CORONARY_PROPERTIES.size();
		resultList = new ArrayList<>(size);
		resultList.addAll(COMMON_PROPERTIES);
		resultList.addAll(CORONARY_PROPERTIES);
		this.coronaryProperties = resultList.toArray(new String[size]);
		// 肿瘤
		size = COMMON_PROPERTIES.size() + TUMOR_PROPERTIES.size();
		resultList = new ArrayList<>(size);
		resultList.addAll(COMMON_PROPERTIES);
		resultList.addAll(TUMOR_PROPERTIES);
		this.tumorProperties = resultList.toArray(new String[size]);
		// 更新字段
		size = HBP_PROPERTIES.size()+DI_PROPERTIES.size() + STROKE_PROPERTIES.size() + CORONARY_PROPERTIES.size() + TUMOR_PROPERTIES.size() + COMMON_UPDATE_PROPERTIES.size();
		resultList = new ArrayList<>();
		resultList.addAll(HBP_PROPERTIES);
		resultList.addAll(DI_PROPERTIES);
		resultList.addAll(STROKE_PROPERTIES);
		resultList.addAll(CORONARY_PROPERTIES);
		resultList.addAll(TUMOR_PROPERTIES);
		resultList.addAll(COMMON_UPDATE_PROPERTIES);
		this.updateProperties = resultList.toArray(new String[size]);
		// 初始化,节点规则,上报报卡用
		initRule();
	}

	@Override
	public PageList<DmReportInfo> getRepeatCardList(Page page, Criteria criteria, String conditions) {
		return dmReportInfoDao.getRepeatCardList(page, criteria, conditions);
	}

	@Override
	public List<DmReportInfo> getTumorReportInfos(String idcard) {
		Criteria criteria = new Criteria("idcard" ,idcard);
		criteria.add("disType", EHRConstants.DM_TUMOR_TYPE);
		criteria.add(new Criteria("isSecondary", "0").add(LOP.OR, "isSecondary", OP.IS, "null"));
		return dmReportInfoDao.getList(criteria, new Order("tumor_diagnosis_date"));
	}

	@Override
	public String updateRepeatCard(String cdmId) {
		int count = cdmStatusInfoDao.update(new Parameters("reportStatus", ApprovalState.CANCEL.getValue()), new Criteria("ID", cdmId));
		if (count > 0)
			return "success";
		return "failure";
	}

	@Override
	public List<DmPersonInfo> getReportsGroupByPersonId(Page page, Criteria criteria) {
		List<DmPersonInfo> resuls = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(criteria)) {
			return resuls;
		}
		List<DmReportInfo> reports = dmReportInfoDao.getPagedDetailReportCardListGroupByPerson(page, criteria);
		if (ObjectUtil.isNullOrEmpty(reports)) {
			return resuls;
		}
		Map<Long, DmPersonInfo> personMap = new HashMap<>();
		for (DmReportInfo dmReportInfo : reports) {
			Long personId = dmReportInfo.getPersonId();
			DmPersonInfo personInfo = null;
			List<DmReportInfo> groupedReports = null;
			if (personMap.containsKey(personId)) {
				personInfo = personMap.get(personId);
				groupedReports = personInfo.getReportInfoList();
			} else {
				personInfo = new DmPersonInfo();
				personMap.put(personId, personInfo);
				personInfo.setIdcard(dmReportInfo.getIdcard());
				personInfo.setBirthday(dmReportInfo.getBirthday());
				personInfo.setPersonId(dmReportInfo.getPersonId());
				personInfo.setName(dmReportInfo.getName());
				personInfo.setGender(dmReportInfo.getGender());
				groupedReports = new ArrayList<DmReportInfo>();
				personInfo.setReportInfoList(groupedReports);
				resuls.add(personInfo);
			}
			groupedReports.add(dmReportInfo);
		}
		return resuls;
	}

	@Override
	public List<Map<String, Object>> getDetailReportCardMapList(Criteria criteria) {
		List<Map<String, Object>> reports = dmReportInfoDao.getDetailReportCardMapList(criteria);
		if (ObjectUtil.isNullOrEmpty(reports)) {
			return Collections.emptyList();
		}
		return reports;
	}

	@Override
	public List<DmReportInfo> getReportCard(Criteria criteria) {
		Order order = new Order("CREATE_DATE", false);
		List<DmReportInfo> reportInfos = dmReportInfoDao.getReports(criteria, order);
		if (null != reportInfos) {
			for (DmReportInfo reportInfo : reportInfos) {
				CdmStatusInfo cdmStatusInfo = cdmStatusInfoDao.get(new Criteria("id", reportInfo.getCdmId()));
				if (null == cdmStatusInfo) {
					// TODO
					log.error("数据错误! 没有找到审核状态 报卡 Id" + reportInfo.getIdcard() + "状态Id" + reportInfo.getCdmId());
				}
				reportInfo.setSecondaryReportInfos(this.getSecondaryReportInfos(reportInfo));
				List<CdmApprovalInfo> approvalInfos = cdmApprovalInfoDao.getList(new Criteria("cdmId", reportInfo.getCdmId()), new Order("APPROVAL_DATE"));
				reportInfo.setApprovalInfos(approvalInfos);
				reportInfo.setCdmStatusInfo(cdmStatusInfo);
			}
		}
		return reportInfos;
	}

	@Override
	public DmReportInfo getDmReportInfo(long id) {
		return dmReportInfoDao.get(id);
	}

	private List<DmReportInfo> getSecondaryReportInfos(DmReportInfo reportInfo) {
		List<DmReportInfo> secondaryReportInfos = new ArrayList<DmReportInfo>();

		if(ObjectUtil.equals(reportInfo.getIsSecondary(), "1")) {
			Criteria criteria = new Criteria("isSecondary", "1");
			criteria.add("id", OP.NE, reportInfo.getId());
			criteria.add(LOP.OR, new Criteria("id", reportInfo.getSecondaryId()));
			secondaryReportInfos = dmReportInfoDao.getList(criteria, new Order("tumor_diagnosis_date"));
		} else {
			Criteria criteria = new Criteria("isSecondary", "1");
			criteria.add("secondaryId", reportInfo.getId());
			secondaryReportInfos = dmReportInfoDao.getList(criteria, new Order("tumor_diagnosis_date"));
		}

		return secondaryReportInfos;
	}

	/**
	 * 新增报卡保存校验是否能够上报
	 * 高血压: 不区分二级分类，只要存在就不能上报。
	 * 糖尿病: 需要区分二级分类是否重复上报
	 * 冠心病: 冠心病中只有急性心梗，超过28天可以再次上报，不算重报
	 * 脑卒中: 不同二级疾病可以重复上报，28天外再次发病的患者，允许上报相同疾病类型报卡
	 * 脑瘤: 不相同ICD-10疾病类型可以重复报卡
	 */
	@Override
	public Map<String, Boolean> checkDuplicateReport(DmReportInfo reportInfo) {

		// 默认可以上报所有。(高血压，糖尿病)
		Map<String, Boolean> checkedResults = new HashMap<>();
		if (ObjectUtil.isNullOrEmpty(reportInfo.getPersonId())) {
			checkedResults.put("hbpIsNotDuplicateReport", true);
			checkedResults.put("diIsNotDuplicateReport", true);
			checkedResults.put("strokeIsNotDuplicateReport", true);
			checkedResults.put("coronaryIsNotDuplicateReport", true);
			checkedResults.put("tumorIsNotDuplicateReport", true);

			return checkedResults;
		}

		boolean hbpIsNotDuplicateReport = true;
		boolean diIsNotDuplicateReport = true;
		boolean strokeIsNotDuplicateReport = true;
		boolean coronaryIsNotDuplicateReport = true;
		boolean tumorIsNotDuplicateReport = true;

		if (ObjectUtil.isNullOrEmpty(reportInfo.getReportType())) {
			reportInfo.setReportType(EHRConstants.DM_REPORT_DIS);
		}

		Set<String> reportedDisTypes = new HashSet<>(5);
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getHbpFlag())) {
			reportedDisTypes.add(EHRConstants.DM_HBP_TYPE);
		}
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getDiFlag())) {
			reportedDisTypes.add(EHRConstants.DM_DI_TYPE);
		}
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getStrokeFlag())) {
			reportedDisTypes.add(EHRConstants.DM_STROKE_TYPE);
		}
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getCoronaryFlag())) {
			reportedDisTypes.add(EHRConstants.DM_CORONARY_TYPE);
		}
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getTumorFlag())) {
			reportedDisTypes.add(EHRConstants.DM_TUMOR_TYPE);
		}
		//获取已报卡信息
		List<DmReportInfo> reportInfos = getDmReportInfos(reportInfo.getPersonId(), reportedDisTypes, reportInfo.getReportType());

		if (null != reportInfos) {
			//遍历获取到的已报卡信息，查看是否已经报卡
			for (DmReportInfo dmReportInfo : reportInfos) {
				String disType = dmReportInfo.getDisType();

				if (hbpIsNotDuplicateReport && EHRConstants.DM_HBP_TYPE.equals(disType)) {
					hbpIsNotDuplicateReport = !reportInfo.getHbpType().equals(dmReportInfo.getHbpType());
				}
				if (diIsNotDuplicateReport && EHRConstants.DM_DI_TYPE.equals(disType)) {
					diIsNotDuplicateReport = !reportInfo.getDiType().equals(dmReportInfo.getDiType());
				}
				if (strokeIsNotDuplicateReport && EHRConstants.DM_STROKE_TYPE.equals(disType)) {
					if (dmReportInfo.getStrokeType().equals(reportInfo.getStrokeType())) {
						Date date = dmReportInfo.getStrokeDiagnosisDate();
						Date current = reportInfo.getStrokeDiagnosisDate();
						if (checkDiagnosisDate(date, current)) {
							strokeIsNotDuplicateReport = true;
							// TODO 重复报卡记录
						} else {
							strokeIsNotDuplicateReport = false;
						}
					}
				}
				if (coronaryIsNotDuplicateReport && EHRConstants.DM_CORONARY_TYPE.equals(disType)) {
					if (dmReportInfo.getCoronaryType().equals(reportInfo.getCoronaryType())) {
						Date date = dmReportInfo.getCoronaryDiagnosisDate();
						Date current = reportInfo.getCoronaryDiagnosisDate();
						//冠心病中只有急性心梗，超过28天可以再次上报，不算重报
						if (checkDiagnosisDate(date, current) && dmReportInfo.getCoronaryType().equals("1")) {
							coronaryIsNotDuplicateReport = true;
							// TODO 重复报卡记录
						} else {
							coronaryIsNotDuplicateReport = false;
						}
					}
				}
				if (tumorIsNotDuplicateReport && EHRConstants.DM_TUMOR_TYPE.equals(disType)) {
					if (null != reportInfo.getTumorIcdTenCode() && null != dmReportInfo.getTumorIcdTenCode()
							&& dmReportInfo.getTumorIcdTenCode().equals(reportInfo.getTumorIcdTenCode())) {
						tumorIsNotDuplicateReport = false;
					}
				}
			}
		}

		//查看高血压是否已经被管理
		if (hbpIsNotDuplicateReport) {
			if(hbpIsManaged(reportInfo)) {
				hbpIsNotDuplicateReport = false;
			}
		}
		//查看糖尿病是否已经被管理
		if (diIsNotDuplicateReport) {
			if (diIsManaged(reportInfo)) {
				diIsNotDuplicateReport = false;
			}
		}
		//查看脑卒中是否已经被管理
		if (strokeIsNotDuplicateReport) {
			if (strokeIsManaged(reportInfo.getPersonId(), EHRConstants.DM_STROKE_TYPE)) {
				strokeIsNotDuplicateReport = false;
			}
		}
		//查看冠心病是否已经被管理
		if (coronaryIsNotDuplicateReport) {
			if (coronaryIsManaged(reportInfo.getPersonId(), EHRConstants.DM_CORONARY_TYPE)) {
				coronaryIsNotDuplicateReport = false;
			}
		}
		//查看脑瘤是否已经被管理
		if (tumorIsNotDuplicateReport) {
			if (tumorIsManaged(reportInfo.getPersonId(), EHRConstants.DM_TUMOR_TYPE)) {
				tumorIsNotDuplicateReport = false;
			}
		}

		checkedResults.put("hbpIsNotDuplicateReport", hbpIsNotDuplicateReport);
		checkedResults.put("diIsNotDuplicateReport", diIsNotDuplicateReport);
		checkedResults.put("strokeIsNotDuplicateReport", strokeIsNotDuplicateReport);
		checkedResults.put("coronaryIsNotDuplicateReport", coronaryIsNotDuplicateReport);
		checkedResults.put("tumorIsNotDuplicateReport", tumorIsNotDuplicateReport);
		return checkedResults;
	}

	private List<DmReportInfo> getDmReportInfos(Long personId, Set reportedDisTypes, String reportType) {

		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		criteria.add("disType", OP.IN, reportedDisTypes.toArray(new String[reportedDisTypes.size()]));
		criteria.add("reportType", reportType);

		// 只检查正常状态的报卡
		criteria.add("cdmStatusInfo.REPORT_STATUS", OP.IN, NORMAL_REPORT_STATUS);
		// Order order = new Order("dmReportInfo.CREATE_DATE", false);
		return dmReportInfoDao.getReports(criteria, null);
	}

	/**
	 * 检查脑卒中是否已经管理
	 *
	 */
	private boolean strokeIsManaged(Long personId, String strokeType) {

		Criteria managedCriteria = new Criteria();
		managedCriteria.add("personId", personId);
		managedCriteria.add(this.getHmCardDeleteStatus(EHRConstants.DM_MANAGED_FLAG));
		DmDiseaseInfo diseaseInfo =  diseaseInfoDao.get(managedCriteria, "strokeFlag", "strokeType");

		return null != diseaseInfo && EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getStrokeFlag()) && ObjectUtil.equals(strokeType, diseaseInfo.getStrokeType());
	}

	/**
	 * 检查冠心病是否已经管理
	 *
	 */
	private boolean coronaryIsManaged(Long personId, String coronaryType) {

		Criteria managedCriteria = new Criteria();
		managedCriteria.add("personId", personId);
		managedCriteria.add(this.getHmCardDeleteStatus(EHRConstants.DM_MANAGED_FLAG));
		DmDiseaseInfo diseaseInfo =  diseaseInfoDao.get(managedCriteria, "coronaryFlag", "coronaryType");

		return null != diseaseInfo && EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getCoronaryFlag()) && ObjectUtil.equals(coronaryType, diseaseInfo.getCoronaryType());
	}

	/**
	 * 检查肿瘤是否已经管理
	 *
	 */
	private boolean tumorIsManaged(Long personId, String tumorType) {

		Criteria managedCriteria = new Criteria();
		managedCriteria.add("personId", personId);
		managedCriteria.add(this.getHmCardDeleteStatus(EHRConstants.DM_MANAGED_FLAG));
		DmDiseaseInfo diseaseInfo =  diseaseInfoDao.get(managedCriteria, "tumorFlag", "tumorType");

		return null != diseaseInfo && EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag()) && ObjectUtil.equals(tumorType, diseaseInfo.getTumorType());
	}

	/**
	 * 检查高血压是否已经管理
	 *
	 * @param reportInfo
	 *            the report info
	 */
	private boolean hbpIsManaged(DmReportInfo reportInfo) {
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getHbpFlag())) {
			DmDiseaseInfo diseaseInfo = getDmDisInfo(reportInfo);
			if (null != diseaseInfo) {
				return EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag()) && ObjectUtil.equals(reportInfo.getHbpType(), diseaseInfo.getHbpType());
			}
		}
		return false;
	}

	/**
	 * 检查糖尿病是否已经管理
	 *
	 * @param dmReportInfo
	 */
	private boolean diIsManaged(DmReportInfo dmReportInfo) {
		if (EHRConstants.DM_REPORTED_FLAG.equals(dmReportInfo.getDiFlag())) {
			DmDiseaseInfo diseaseInfo = getDmDisInfo(dmReportInfo);
			if (null != diseaseInfo) {
				return EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag()) && ObjectUtil.equals(dmReportInfo.getDiType(), diseaseInfo.getDiType());
			}
		}
		return false;
	}

	/**
	 * 检查是否已经管理
	 * 
	 * @param reportInfo
	 *            the report info
	 * @param result
	 *            the result
	 */
	private void checkIsManaged(DmReportInfo reportInfo, boolean[] result) {
		DmDiseaseInfo diseaseInfo = null;
		// 检查糖尿病,根据类型
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getDiFlag())) {
			if (result[0]) {
				diseaseInfo = getDmDisInfo(reportInfo);
				if (null == diseaseInfo) {
					return;
				}
				result[0] = !(EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag()) && ObjectUtil.equals(reportInfo.getDiType(), diseaseInfo.getDiType()));
			}
		}

		// 检查肿瘤,根据icd10
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getTumorFlag())) {
			if (result[3]) {
				if (null == diseaseInfo) {
					diseaseInfo = getDmDisInfo(reportInfo);
				}
				if (null == diseaseInfo) {
					return;
				}
				result[3] = !(EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getTumorFlag()) && ObjectUtil.equals(reportInfo.getTumorIcdTenCode(), diseaseInfo.getTumorIcdTenCode()));
			}
		}

		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getStrokeFlag())) {
			// 可以重复报卡不检查
		}

		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getCoronaryFlag())) {
			// 可以重复报卡不检查
		}

	}

	/**
	 * Gets dm dis info.
	 * 
	 * @param reportInfo
	 *            the report info
	 * @return the dm dis info
	 */
	private DmDiseaseInfo getDmDisInfo(DmReportInfo reportInfo) {
		DmDiseaseInfo diseaseInfo = null;
		Criteria managedCriteria = new Criteria();
		managedCriteria.add("personId", reportInfo.getPersonId());
		managedCriteria.add(this.getHmCardDeleteStatus(EHRConstants.DM_MANAGED_FLAG));
		diseaseInfo = diseaseInfoDao.get(managedCriteria, "diFlag", "tumorFlag", "diType", "tumorIcdTenCode");
		return diseaseInfo;
	}

	@Override
	@Transactional
	public boolean saveReportCard(DmReportInfo reportInfo, RoleType roleType, User user, Organization organization,Map<String, String> linkMapGxy,
								  Map<String, String> linkMapTnb,Map<String, String> linkMapGxb,Map<String, String> linkMapNcz,Map<String, String> linkMapZl) {
		if (ObjectUtil.isNullOrEmpty(reportInfo)) {
			log.error("报卡信息不全");
			return false;
		}
		DmPersonInfo dmPersonInfo = reportInfo.getPersonInfo();
		if (ObjectUtil.isNullOrEmpty(dmPersonInfo)) {
			log.error("患者信息不全");
			return false;
		}
		Long personId = cdmPersonService.createOrUpdatePersonUseDmPersonInfo(dmPersonInfo, user, organization);
		dmPersonInfo.setPersonId(personId);
		if (ObjectUtil.isNullOrEmpty(personId)) {
			log.error("患者信息保存失败");
			return false;
		}

		/* 保存上报的人员信息 */
		Long dmPersonId = saveDmReportPerson(dmPersonInfo, user, organization);
		/* 设置报卡内的人员信息 */
		String idCard = dmPersonInfo.getIdcard();
		reportInfo.setIdcard(idCard);// 身份证
		reportInfo.setDmPersonId(dmPersonId); // 人员的id
		reportInfo.setPersonId(personId); // 健康档案的人员id
		// 默认病例报卡
		if (ObjectUtil.isNullOrEmpty(reportInfo.getReportType())) {
			reportInfo.setReportType(EHRConstants.DM_REPORT_DIS);
		}
		//返回reportId主键数组0:高血压1:糖尿病
		Long[] reportIdArr = doSaveReportCard(reportInfo, roleType, user, organization);

//		保存附件支持多病种报卡及附件上传
		if(EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getHbpFlag()) && ObjectUtil.isNotEmpty(linkMapGxy)) { // 高血压
			uploadInfoRecords(reportIdArr[0], linkMapGxy, user.getName(),EHRConstants.FILE_TYPE_MBBKGXY);//mbglkgxy=>mbbkgxy区分报卡附件和历史管理卡附件
		}
		if(EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getDiFlag()) && ObjectUtil.isNotEmpty(linkMapTnb)) { // 糖尿病
			uploadInfoRecords(reportIdArr[1], linkMapTnb, user.getName(),EHRConstants.FILE_TYPE_MBBKTNB);//mbglktnb=>mbbktnb区分报卡附件和历史管理卡附件
		}

		//往消息提醒表添加记录 2015/07/30
		MessageSent messageSent = new MessageSent();
		messageSent.setCreateDate(new Date());
		messageSent.setReceivingUnit(reportInfo.getCreateOrganCode());
		messageSent.setType("2");//慢病
		messageSent.setStatus("1");//未提醒
		messageSent.setTitle("慢病报卡");
		messageSent.setCreateOrganCode(organization.getOrganCode());
		messageSentDao.insert(messageSent);
		return true;
	}
	/**
	 * 附件上传
	 * @author add by Kevin Ro 2018-10-11
 	 */
	private void uploadInfoRecords(Long sourceId, Map<String, String> fileMap, String createrName, String fileSource) {
		if (ObjectUtil.isNotEmpty(fileMap)) {
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
	/**
	 * Save dm report person.
	 * 
	 * @param dmPersonInfo
	 *            the dm person info
	 * @param user
	 *            the user
	 * @param organization
	 *            the organization
	 * @return the long
	 */
	private Long saveDmReportPerson(DmPersonInfo dmPersonInfo, User user, Organization organization) {
		dmPersonInfo.setType(EHRConstants.DM_PERSON_REPORT_TYPE);
		setDmPersonInputInfo(user, organization, dmPersonInfo);
		dmPersonInfo.setId(null);
		cdmPersonService.saveOrUpdateDmPersonInfo(dmPersonInfo);
		Long dmPersonId = dmPersonInfo.getId();
		return dmPersonId;
	}

	/**
	 * Sets dm person input info.
	 * 
	 * @param user
	 *            the user
	 * @param organization
	 *            the organization
	 * @param dmPersonInfo
	 *            the dm person info
	 */
	private void setDmPersonInputInfo(User user, Organization organization, DmPersonInfo dmPersonInfo) {
		if (ObjectUtil.isNotEmpty(organization)) {
			String orgCode = organization.getOrganCode();
			//管理机构
			dmPersonInfo.setInputOrganCode(orgCode);
			dmPersonInfo.setInputOrganName(organization.getOrganName());
			//创建慢病档案机构
			dmPersonInfo.setCreateOrganName(organization.getOrganName());
			dmPersonInfo.setCreateOrganCode(orgCode);
			dmPersonInfo.setCreateDate(new Date());
		}
		if (ObjectUtil.isNotEmpty(user)) {
			dmPersonInfo.setCreateDoctorCode(user.getUserCode());
		}
	}

	/**
	 * 根据报卡慢病不同,分别新建报卡
	 * 
	 * @param reportInfo
	 *            the report info
	 * @param roleType
	 *            the role type
	 * @param user
	 *            the user
	 * @param organization
	 *            the organization
	 */
	private Long[] doSaveReportCard(DmReportInfo reportInfo, RoleType roleType, User user, Organization organization) {
		Long[] reportIdArr = new Long[5];
		// 根据不同类型报卡设置报卡类型标志
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getHbpFlag())) {
			reportIdArr[0] = createReport(EHRConstants.DM_HBP_TYPE, reportInfo.getHbpType(), reportInfo, roleType, user, organization, this.hbpProperties);
		}
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getDiFlag())) {
			reportIdArr[1] = createReport(EHRConstants.DM_DI_TYPE, reportInfo.getDiType(), reportInfo, roleType, user, organization, this.diProperties);
		}
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getStrokeFlag())) {
			reportIdArr[2] = createReport(EHRConstants.DM_STROKE_TYPE, reportInfo.getStrokeType(), reportInfo, roleType, user, organization, this.strokeProperties);
		}
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getCoronaryFlag())) {
			reportIdArr[3] = createReport(EHRConstants.DM_CORONARY_TYPE, reportInfo.getCoronaryType(), reportInfo, roleType, user, organization, this.coronaryProperties);
		}
		// 肿瘤二级类型直接存入icd10,便于统计使用用
		if (EHRConstants.DM_REPORTED_FLAG.equals(reportInfo.getTumorFlag())) {
			String[] properties = this.tumorProperties;
			// 肿瘤计算出是恶性和非恶性
			reportInfo.setTumorIcdTenType(getTumorType(reportInfo.getTumorIcdTenCode()));
			setTumorDeathFirstFlag(reportInfo);
			reportIdArr[4] = createReport(EHRConstants.DM_TUMOR_TYPE, reportInfo.getTumorIcdTenCode(), reportInfo, roleType, user, organization, properties);
		}
		return reportIdArr;
	}

	/**
	 * 创建报卡和报卡状态
	 * 
	 * @param type
	 *            the type
	 * @param subType
	 *            the sub type
	 * @param reportInfo
	 *            the report info
	 * @param roleType
	 *            the role type
	 * @param user
	 *            the user
	 * @param organization
	 *            the organization
	 * @param insertPros
	 *            the insert pros
	 */
	private Long createReport(String type, String subType, DmReportInfo reportInfo, RoleType roleType, User user, Organization organization, String[] insertPros) {
		CdmStatusInfo cdmStatusInfo = new CdmStatusInfo();
		cdmStatusInfo.setType(type);

		/** 根据报卡的角色设置初始状态 */
		// TODO 可配置
		if (RoleType.ZXMB.equals(roleType)){
			cdmStatusInfo.setReportStatus(ApprovalState.VERIFIED_FIRST.getValue());
		} else if (RoleType.JKMBK.equals(roleType)) {
			if (EHRConstants.DM_REPORT_DEATH.equals(reportInfo.getReportType())) {
				cdmStatusInfo.setReportStatus(ApprovalState.DEATH.getValue());
			} else {
				/** 慢病科上报直接分配 */
				// String orgCode = reportInfo.getSuperManageOrganCode();
				// Assert.notNull(orgCode, "分配机构为空!");
				checkAllocOrganization(true, reportInfo);
				cdmStatusInfo.setReportStatus(ApprovalState.VERIFIED_SECOND.getValue());
			}
		} else if(RoleType.ZMB.equals(roleType)) {
			/** 站慢病科上报状态为已审核防保科已分配已纳入直接分配本站 */
			reportInfo.setManageOrganCode(organization.getOrganCode());
			reportInfo.setManageOrganName(organization.getOrganName());
			reportInfo.setSuperManageOrganCode(organization.getParentCode());
			checkAllocOrganization(true, reportInfo);
			//BUG0135278慢病报告审核流程团风个性需求
			cdmStatusInfo.setReportStatus(ApprovalState.READY.getValue());
		}
		else {
			cdmStatusInfo.setReportStatus(ApprovalState.READY.getValue());
		}
		Integer cdmId = cdmStatusInfoDao.generatedKey(cdmStatusInfo, "ID", null).intValue();// 创建审核状态
		reportInfo.setDisType(type);
		reportInfo.setSubDisType(subType);
		reportInfo.setCdmId(cdmId);
		setReportInputInfo(true, reportInfo, user, organization);// 设置报卡输入信息
		// dmReportInfoDao.insert(reportInfo, insertPros);
		Number reportId = dmReportInfoDao.generatedKey(reportInfo, "ID", insertPros);
		// 更新记录id,外部报卡上报会产生一条记录,此处将更新此记录的状态为上报成功
		Long reportRecordId = reportInfo.getHosReportRecordId();
		if (null != reportRecordId) {
			reportRecordService.update(reportRecordId, reportId.longValue(), EHRConstants.DM_REPORTE_YES);
		}
		return reportId.longValue();
	}

	/**
	 * 设置报卡输入信息
	 * 
	 * @param input
	 *            the input
	 * @param dmReportInfo
	 *            the dm report info
	 * @param user
	 *            the user
	 * @param organization
	 *            the organization
	 */
	private void setReportInputInfo(boolean input, DmReportInfo dmReportInfo, User user, Organization organization) {
		Date cuDate = new Date();
		if (input) {
			if (ObjectUtil.isNotEmpty(organization)) {
				dmReportInfo.setCreateOrganCode(organization.getOrganCode());
				dmReportInfo.setCreateOrganName(organization.getOrganName());
			}
			if (ObjectUtil.isNotEmpty(user)) {
				dmReportInfo.setCreateDoctorCode(user.getUserCode());
				dmReportInfo.setCreateDoctorName(user.getName());
			}
			dmReportInfo.setCreateDate(cuDate);
		}
		if (ObjectUtil.isNotEmpty(organization)) {
			dmReportInfo.setUpdateOrganCode(organization.getOrganCode());
			dmReportInfo.setUpdateOrganName(organization.getOrganName());
		}
		if (ObjectUtil.isNotEmpty(user)) {
			dmReportInfo.setUpdateDoctorCode(user.getUserCode());
			dmReportInfo.setUpdateDoctorName(user.getName());
		}
		dmReportInfo.setUpdateDate(cuDate);
	}

	// ===新增报卡保存 end==//

	// ===审核分配报卡 start==//

	@Override
	@Transactional
	public void approveReport(PersonInfo personInfo, List<DmReportInfo> reportInfos, RoleType roleType, User user, Organization organization,Map<String, String> linkMapGxy,
							  Map<String, String> linkMapTnb) {
		Assert.notNull(roleType);
		Assert.notNull(user);
		Assert.notNull(organization);
		boolean isNeedModifyPerson = false;
		List<Long> dmPersonIds = null;
		if (null != reportInfos) {
			dmPersonIds = new ArrayList<>(reportInfos.size());
			Long start = System.currentTimeMillis();
			for (DmReportInfo dmReportInfo : reportInfos) {
				if (null != dmReportInfo) {
					dmPersonIds.add(dmReportInfo.getDmPersonId());
					doApproveAndAllocReport(personInfo, dmReportInfo, roleType, user, organization);
					if (!isNeedModifyPerson) {
						isNeedModifyPerson = dmReportInfo.isModified();
					}
				}
			}
			if (log.isDebugEnabled()) {
				Long end = System.currentTimeMillis();
				log.debug("===============审核,审核总耗时:" + (end - start));
			}
		}

		/**
		 * 保存附件
		 * @author add by Kevin Ro 2018-10-11
		 */
		for(DmReportInfo report : reportInfos) {
			if(EHRConstants.DM_HBP_TYPE.equals(report.getDisType()) && ObjectUtil.isNotEmpty(linkMapGxy)) { // 高血压
				uploadInfoRecords(report.getId(), linkMapGxy, user.getName(), "mbglkgxy");
			}else if(EHRConstants.DM_DI_TYPE.equals(report.getDisType()) && ObjectUtil.isNotEmpty(linkMapTnb)) { // 糖尿病
				uploadInfoRecords(report.getId(), linkMapTnb, user.getName(), "mbglktnb");
			}
		}

		// TODO 人员修改
		if (RoleType.ZXMB.equals(roleType) || RoleType.YYMB.equals(roleType)) {
			Long start = System.currentTimeMillis();
			Long personId = personInfo.getId();
			String idcard = personInfo.getIdcard();

			Criteria criteria = new Criteria("id", OP.IN, dmPersonIds);
			// 仅更新部分字段
			Parameters parameters = new Parameters("name", personInfo.getName());
			parameters.add("idcard", idcard);
			parameters.add("birthday", personInfo.getBirthday());
			parameters.add("gender", personInfo.getGender());

			// 检查身份证是否被占用
			if (ObjectUtil.isNotEmpty(idcard)) {
				PersonInfo old = platformService.queryPersonalInfo(null, idcard);
				if (null != old) {
					// 如果根据身份证查询的id不同,则认为身份证被占用
					if (!old.getId().equals(personId)) {
						dmReportInfoDao.update(new Parameters("personId", old.getId()), new Criteria("personId", personId));
						platformService.deleteNoIdCardPerson(personId);
						parameters.add("personId", old.getId());
						personInfo.setId(old.getId());
					}
				}
			}
			cdmPersonService.saveOrUpdatePerson(personInfo, user, organization);
			cdmPersonService.updateDmPersonInfo(parameters, criteria);
			if (log.isDebugEnabled()) {
				Long end = System.currentTimeMillis();
				log.debug("===============审核,人员修改耗时:" + (end - start));
			}
		}
	}

	/**
	 * 审核和分配
	 * 
	 * @param personInfo
	 *            the person info
	 * @param dmReportInfo
	 *            the dm report info
	 * @param roleType
	 *            the role type
	 * @param user
	 *            the user
	 * @param organization
	 *            the organization
	 */
	private void doApproveAndAllocReport(PersonInfo personInfo, DmReportInfo dmReportInfo, RoleType roleType, User user, Organization organization) {
		// TODO 批量保存修改的数据
		boolean debug = log.isDebugEnabled();
		String op = dmReportInfo.getApprovalOp();
		CdmStatusInfo cdmStatusInfo = cdmStatusInfoDao.get(dmReportInfo.getCdmId());
		String oldStatus = cdmStatusInfo.getReportStatus();
		String status = null;
		/** 审核 */
		if (!EHRConstants.DM_APPROVE_NO.equals(op)) {
			Long start = System.currentTimeMillis();
			setReportInputInfo(false, dmReportInfo, user, organization);// 设置更新数据
			status = calNextStatusAndExecuteTask(dmReportInfo, oldStatus, op, roleType, organization, user);
			if (debug) {
				Long end = System.currentTimeMillis();
				log.debug("===============审核,单此报卡,状态和任务计算耗时:" + (end - start));
			}
			// 检查是否修改状态,如果修改,则记录审核信息,并更新状态
			if (null != status && !oldStatus.equals(status)) {
				start = System.currentTimeMillis();
				cdmStatusInfo.setId(dmReportInfo.getCdmId());
				cdmStatusInfo.setReportStatus(status);
				CdmApprovalInfo approvalInfo = createApproval(dmReportInfo, dmReportInfo.getComments(), status, user, organization);
				cdmStatusInfoDao.update(cdmStatusInfo, "reportStatus");
				cdmApprovalInfoDao.insert(approvalInfo);
				if (debug) {
					Long end = System.currentTimeMillis();
					log.debug("===============审核,单此报卡,审核信息修改耗时:" + (end - start));
				}
			}
		}
	}

	/**
	 * 计算下一个状态,并执行对应的任务
	 * 
	 * @param dmReportInfo
	 *            the dm report info
	 * @param oldStatus
	 *            the old status
	 * @param op
	 *            the op
	 * @param roleType
	 *            the role type
	 * @param organization
	 *            the organization
	 * @param user
	 *            the user
	 * @return string
	 */
	private String calNextStatusAndExecuteTask(DmReportInfo dmReportInfo, String oldStatus, String op, RoleType roleType, Organization organization, User user) {
		String status = null;
		String key = buildRuleKey(dmReportInfo.getReportType(), oldStatus, op, roleType.getValue());
		status = statusRule.get(key);
		if (null != status && !status.equals(oldStatus)) {
			IUserTask<DmReportInfo> task = noteTask.get(key);
			if (null != task) {
				task.execute(dmReportInfo, roleType, organization, user);
			}
		}
		if(roleType.getValue().equals("0307")){
			status = "3";
		}
		return status;
	}

	/**
	 * 创建审批信息
	 * 
	 * @param dmReportInfo
	 *            the dm report info
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
	private CdmApprovalInfo createApproval(DmReportInfo dmReportInfo, String Comments, String status, User user, Organization organization) {
		CdmApprovalInfo approvalInfo = new CdmApprovalInfo();
		approvalInfo.setApprovalDate(new Date());
		approvalInfo.setComments(Comments);
		approvalInfo.setCdmId(dmReportInfo.getCdmId());
		approvalInfo.setStatus(status);
		approvalInfo.setUserId(user.getId().toString());
		approvalInfo.setUserName(user.getName());
		approvalInfo.setOrgCode(organization.getOrganCode());
		approvalInfo.setOrgName(organization.getOrganName());
		return approvalInfo;
	}

	// ====审核分配报卡 end==//

	// ==初始化报卡上报流程 start==//

	/**
	 * 初始化审核节点
	 */
	private void initRule() {

		// 节点任务,当执行到对应节点时,会执行此任务
		IUserTask<DmReportInfo> modifyTask = new ModifyReportTask();// 修改
		IUserTask<DmReportInfo> allocTask = new AllocReportTask();// 防保科分配
		IUserTask<DmReportInfo> cdcAllocTask = new CdcAllocReportTask();// 慢病科分配

		// 疾病类型
		String reportDisType = EHRConstants.DM_REPORT_DIS;
		// 报卡类型,目前有两种,死亡和病例
		String reportDeathType = EHRConstants.DM_REPORT_DEATH;
		// 医院上报,防保科审核通过
		addRule(reportDisType, ApprovalState.VERIFIED_FIRST, ApprovalState.READY, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, modifyTask);
		// 慢病科退回,防保科修改后通过
		addRule(reportDisType, ApprovalState.VERIFIED_FIRST, ApprovalState.REJECT, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, modifyTask);
		// 医院上报,防保科作废
		addRule(reportDisType, ApprovalState.CANCEL, ApprovalState.READY, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);

		// 慢病科退回,防保科作废
		addRule(reportDisType, ApprovalState.CANCEL, ApprovalState.REJECT, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);

		// 上报,防保科审核通过
		addRule(reportDisType, ApprovalState.VERIFIED_FIRST, ApprovalState.READY, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, modifyTask);
		// 慢病科退回,医院防保科修改后通过
		addRule(reportDisType, ApprovalState.VERIFIED_FIRST, ApprovalState.REJECT, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, modifyTask);
		// 医院上报,医院防保科作废
		addRule(reportDisType, ApprovalState.CANCEL, ApprovalState.READY, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);
		// 慢病科退回,医院防保科作废
		addRule(reportDisType, ApprovalState.CANCEL, ApprovalState.REJECT, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);

		// 慢病科 退回到防保科
		addRule(reportDisType, ApprovalState.REJECT, ApprovalState.VERIFIED_FIRST, EHRConstants.DM_APPROVE_REJECT, RoleType.JKMBK, null);
		// 慢病科 审核通过并分配
		addRule(reportDisType, ApprovalState.VERIFIED_SECOND, ApprovalState.VERIFIED_FIRST, EHRConstants.DM_APPROVE_PASS, RoleType.JKMBK, cdcAllocTask);
		// 慢病科 防保科退会再次分配
		addRule(reportDisType, ApprovalState.VERIFIED_SECOND, ApprovalState.ALLOC_REJECT_FIRST, EHRConstants.DM_APPROVE_PASS, RoleType.JKMBK, cdcAllocTask);
		// 防保科分配
		addRule(reportDisType, ApprovalState.ALLOCATED, ApprovalState.VERIFIED_SECOND, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, allocTask);
		// 防保科退回
		addRule(reportDisType, ApprovalState.ALLOC_REJECT_FIRST, ApprovalState.VERIFIED_SECOND, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);
		// 防保科 社区站退回再次分配
		addRule(reportDisType, ApprovalState.ALLOCATED, ApprovalState.ALLOC_REJECT_SECOND, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, allocTask);
		// 防保科 社区站退回 退回给慢病科
		addRule(reportDisType, ApprovalState.ALLOC_REJECT_FIRST, ApprovalState.ALLOC_REJECT_SECOND, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);
		// 社区站退回
		addRule(reportDisType, ApprovalState.ALLOC_REJECT_SECOND, ApprovalState.ALLOCATED, EHRConstants.DM_APPROVE_REJECT, RoleType.ZMB, null);
		// 社区站不管理
		addRule(reportDisType, ApprovalState.NO_MANAGED, ApprovalState.ALLOCATED, EHRConstants.DM_APPROVE_PASS, RoleType.ZMB, null);

		// 中心分配本中心，纳入前退回
		addRule(reportDisType, ApprovalState.ALLOC_REJECT_THREE, ApprovalState.ALLOCATED, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);
		// 防保科纳入退回再次分配
		addRule(reportDisType, ApprovalState.ALLOCATED, ApprovalState.ALLOC_REJECT_THREE, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, allocTask);
		// 防保科纳入退回 退回给慢病科
		addRule(reportDisType, ApprovalState.ALLOC_REJECT_FIRST, ApprovalState.ALLOC_REJECT_THREE, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);

		// 死亡报卡节点
		// 慢病科审核,并退回
		addRule(reportDeathType, ApprovalState.REJECT, ApprovalState.VERIFIED_FIRST, EHRConstants.DM_APPROVE_REJECT, RoleType.JKMBK, null);
		// 慢病科审核,通过为死亡报卡
		addRule(reportDeathType, ApprovalState.DEATH, ApprovalState.VERIFIED_FIRST, EHRConstants.DM_APPROVE_PASS, RoleType.JKMBK, null);
		// 慢病科退回,防保科修改后通过
		addRule(reportDeathType, ApprovalState.VERIFIED_FIRST, ApprovalState.REJECT, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, null);
		// 慢病科退回,防保科修作废
		addRule(reportDeathType, ApprovalState.CANCEL, ApprovalState.REJECT, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);

		// 慢病科退回,市级医院防保科修改后通过
		addRule(reportDeathType, ApprovalState.VERIFIED_FIRST, ApprovalState.REJECT, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, null);
		// 慢病科退回,市级医院防保科修作废
		addRule(reportDeathType, ApprovalState.CANCEL, ApprovalState.REJECT, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);

		// 慢病科 作废
		addRule(reportDisType, ApprovalState.NO_MANAGED, ApprovalState.VERIFIED_FIRST, EHRConstants.DM_APPROVE_NO_MANAGE, RoleType.JKMBK, null);
		// 慢病科 作废
		addRule(reportDisType, ApprovalState.NO_MANAGED, ApprovalState.ALLOC_REJECT_FIRST, EHRConstants.DM_APPROVE_NO_MANAGE, RoleType.JKMBK, null);
		// 慢病科 作废
		addRule(reportDeathType, ApprovalState.NO_MANAGED, ApprovalState.VERIFIED_FIRST, EHRConstants.DM_APPROVE_NO_MANAGE, RoleType.JKMBK, null);

	}

	/**
	 * 创建一个节点
	 * 
	 * @param type
	 *            the type
	 * @param value
	 *            the value
	 * @param oldStatus
	 *            the old status
	 * @param op
	 *            the op
	 * @param roleType
	 *            the role type
	 * @param task
	 *            the task
	 */
	private static void addRule(String type, ApprovalState value, ApprovalState oldStatus, String op, RoleType roleType, IUserTask<DmReportInfo> task) {
		String key = buildRuleKey(type, oldStatus.getValue(), op, roleType.getValue());
		statusRule.put(key, value.getValue());
		if (ObjectUtil.isNotEmpty(task)) {
			noteTask.put(key, task);
		}
	}

	/**
	 * make rule key
	 * 
	 * @param type
	 *            the type
	 * @param oldStatus
	 *            the old status
	 * @param op
	 *            the op
	 * @param roleType
	 *            the role type
	 * @return string
	 */
	private static String buildRuleKey(String type, String oldStatus, String op, String roleType) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(type).append("|").append(oldStatus).append("|").append(op).append("|").append(roleType);
		return stringBuilder.toString();
	}

	/**
	 * 修改报卡
	 * 
	 * @author liuk
	 */
	private class ModifyReportTask implements IUserTask<DmReportInfo> {
		@Override
		public void execute(DmReportInfo dmReportInfo, RoleType roleType, Organization organization, User user) {
			// 增加修改时更新二级类型
			updateReport(dmReportInfo, updateProperties, organization, user);
			// dmReportInfoDao.update(dmReportInfo, updateProperties);
			dmReportInfo.setModified(true);
		}
	}

	/**
	 * 更新报卡
	 * 
	 * @param reportInfo
	 *            the report info
	 * @param updateProperties
	 *            the update properties
	 */
	private void updateReport(DmReportInfo reportInfo, String[] updateProperties, Organization organization, User user) {
		if (EHRConstants.DM_DI_TYPE.equals(reportInfo.getDisType())) {
			reportInfo.setSubDisType(reportInfo.getDiType());
		} else if (EHRConstants.DM_STROKE_TYPE.equals(reportInfo.getDisType())) {
			reportInfo.setSubDisType(reportInfo.getStrokeType());
		} else if (EHRConstants.DM_CORONARY_TYPE.equals(reportInfo.getDisType())) {
			reportInfo.setSubDisType(reportInfo.getCoronaryType());
		} else if (EHRConstants.DM_TUMOR_TYPE.equals(reportInfo.getDisType())) {
			// 此处的肿瘤二级类型,直接存入icd10编码
			reportInfo.setSubDisType(reportInfo.getTumorIcdTenCode());
			// 肿瘤计算出是恶性和非恶性
			reportInfo.setTumorIcdTenType(getTumorType(reportInfo.getTumorIcdTenCode()));
			setTumorDeathFirstFlag(reportInfo);
		}
		setReportInputInfo(false, reportInfo, user, organization);
		dmReportInfoDao.update(reportInfo, updateProperties);
	}

	/**
	 * 分配报卡
	 * 
	 * @author liuk
	 */
	private class AllocReportTask implements IUserTask<DmReportInfo> {
		@Override
		public void execute(DmReportInfo dmReportInfo, RoleType roleType, Organization organization, User user) {
			// String orgCode = dmReportInfo.getManageOrganCode();
			// Assert.notNull(orgCode, "分配机构获取失败");
			// String orgName = organizationApp.queryOrganName(orgCode);
			// dmReportInfo.setManageOrganName(orgName);
			checkAllocOrganization(false, dmReportInfo);
			setReportInputInfo(false, dmReportInfo, user, organization);
			dmReportInfoDao.update(dmReportInfo, "manageOrganCode", "manageOrganName", "updateOrganCode", "updateOrganName", "updateDoctorCode", "updateDoctorName", "updateDate");
		}
	}

	/**
	 * 分配报卡
	 * 
	 * @author liuk
	 */
	private class CdcAllocReportTask implements IUserTask<DmReportInfo> {
		@Override
		public void execute(DmReportInfo dmReportInfo, RoleType roleType, Organization organization, User user) {
			// String orgCode = dmReportInfo.getSuperManageOrganCode();
			// Assert.notNull(orgCode, "分配机构获取失败");
			// String orgName = organizationApp.queryOrganName(orgCode);
			// dmReportInfo.setSuperManageOrganName(orgName);
			checkAllocOrganization(true, dmReportInfo);
			setReportInputInfo(false, dmReportInfo, user, organization);
			dmReportInfoDao.update(dmReportInfo, "superManageOrganCode", "superManageOrganName", "updateOrganCode", "updateOrganName", "updateDoctorCode", "updateDoctorName", "updateDate");
		}
	}

	/**
	 * Check alloc organization.
	 * 
	 * @param isCdc
	 *            the is cdc
	 * @param reportInfo
	 *            the report info
	 */
	private void checkAllocOrganization(boolean isCdc, DmReportInfo reportInfo) {
		// 检查分配单位
		String allocOrganCode = isCdc ? reportInfo.getSuperManageOrganCode() : reportInfo.getManageOrganCode();
		if (ObjectUtil.isNullOrEmpty(allocOrganCode)) {
			throw new BaseException("分配机构不能为空");
		}
		// 检查是否分配错误
		Organization organization = getAllocOrganization(reportInfo.getPersonId());
		if (ObjectUtil.isNotEmpty(organization)) {
			if (isCdc && organization.getGenreCode().equals(OrgGenreCode.STATION.getValue())) {
				String centerOrganCode = organization.getParentCode();
				if (!allocOrganCode.equals(centerOrganCode)) {
					String centerOrganName = organizationApp.queryOrganName(centerOrganCode);
					throw new BaseException("该人员已经被 " + organization.getOrganName() + " 管理,请分配到:" + centerOrganName);
				}
			} else {
				String managedOraganCode = organization.getOrganCode();
				if (!allocOrganCode.equals(managedOraganCode)) {
					throw new BaseException("该人员已经被 " + organization.getOrganName() + " 管理,请分配到" + organization.getOrganName());
				}
			}

		}
	}

	// ==初始化报卡上报流程 end==//

	@Override
	public Organization getAllocOrganization(Long personId) {
		// 从已经被管理的报卡中获取
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		criteria.add(this.getHmCardDeleteStatus(EHRConstants.DM_MANAGED_FLAG));
		DmDiseaseInfo diseaseInfo = diseaseInfoDao.get(criteria, "createOrganCode");
		if (ObjectUtil.isNotEmpty(diseaseInfo) && ObjectUtil.isNotEmpty(diseaseInfo.getCreateOrganCode())) {
			String createOrganCode = diseaseInfo.getCreateOrganCode();
			Organization organization = organizationApp.queryOrgan(createOrganCode);
			return organization;
		}
		return null;
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

	/**
	 * Gets alloc organization dp.
	 * 
	 * @param personId
	 *            the person id
	 * @return the alloc organization dp
	 */
	@Deprecated
	public DmReportInfo getAllocOrganizationDp(Long personId) {
		// 从已经被管理的报卡中获取
		Criteria criteria = new Criteria();
		criteria.add("personId", personId);
		criteria.add("reportType", EHRConstants.DM_REPORT_DIS);
		criteria.add("cdmStatusInfo.REPORT_STATUS", ApprovalState.MANAGED.getValue());
		List<DmReportInfo> reportInfos = dmReportInfoDao.getReports(criteria, null);
		if (ObjectUtil.isNotEmpty(reportInfos)) {
			return reportInfos.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 计算肿瘤死亡报卡是否为第一次上报
	 * 
	 * @param reportInfo
	 *            the report info
	 */
	private void setTumorDeathFirstFlag(DmReportInfo reportInfo) {
		if (EHRConstants.DM_REPORT_DEATH.equals(reportInfo.getReportType()) && isSameYear(reportInfo.getTumorDiagnosisDate(), reportInfo.getDeathDate())) {
			Criteria criteria = new Criteria("personId", reportInfo.getPersonId());
			criteria.add("disType", EHRConstants.DM_TUMOR_TYPE);
			Integer count = dmReportInfoDao.getCount(criteria, "ID", Integer.class);
			if (null == count || count < 1) {
				reportInfo.setTumorDeathFirstFlag(EHRConstants.DM_REPORT_DEATH_FIRST_FLAG);
				return;
			}
		}
		reportInfo.setTumorDeathFirstFlag("");
	}

	/**
	 * 诊断日期 是否相差指定时间
	 * 
	 * @param preDisDate
	 *            the pre dis date
	 * @param currentDisDate
	 *            the current dis date
	 * @return boolean
	 */
	private boolean checkDiagnosisDate(Date preDisDate, Date currentDisDate) {
		if (null == preDisDate || null == currentDisDate) {
			return true;
		}
		return currentDisDate.getTime() - preDisDate.getTime() > EHRConstants.DM_MAX_REPORT_INTERVAL;
	}

	/**
	 * 判断年份是否相同
	 * 
	 * @param date
	 *            the date
	 * @param ohter
	 *            the ohter
	 * @return boolean
	 */
	private boolean isSameYear(Date date, Date ohter) {
		// 只要有一个为null,则无法判断
		if (null == date && null == ohter) {
			return true;
		} else if (null == date || null == ohter) {
			return false;
		} else {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			int year = calendar.get(Calendar.YEAR);
			calendar.setTime(ohter);
			int other = calendar.get(Calendar.YEAR);
			return year == other;
		}
	}

	/**
	 * 根据icd10判断是恶性和非恶性肿瘤
	 * 
	 * @param icdCode
	 *            the icd code
	 * @return tumor type
	 */
	private String getTumorType(String icdCode) {
		// ICD-10/C00-C97：恶性肿瘤
		try {
			if (ObjectUtil.isNotEmpty(icdCode) && icdCode.startsWith("C")) {
				String type = icdCode.substring(1, 3);
				int value = Integer.parseInt(type);
				if (value >= 0 && value <= 97) {
					return EHRConstants.DM_TUMOR_MALIGNANT_TYPE;
				}
			}
		} catch (NumberFormatException e) {
			log.error("肿瘤icd10编码错误", e);
		}
		return EHRConstants.DM_TUMOR_NON_MALIGNANT_TYPE;
	}

	@Override
	public int getReportsCount(Criteria criteria){
		int count = 0;
		count = dmReportInfoDao.getPagedDetailReportCardListGroupByPersonCount(criteria);
		if (count < 0) {
			count = 0;
		}
		return count;
	}
}
