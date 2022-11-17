package com.founder.rhip.ehr.service.basic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.IntegrationMonitorRecorder;
import com.founder.rhip.ehr.common.IntegrationNumberType;
import com.founder.rhip.ehr.common.WomenChildrenHealthcareType;
import com.founder.rhip.ehr.dto.integration.DrugMonitorRecord;
import com.founder.rhip.ehr.dto.integration.GenericMonitor;
import com.founder.rhip.ehr.dto.integration.HospitalMedicalMonitorRecord;
import com.founder.rhip.ehr.dto.integration.MedicalData;
import com.founder.rhip.ehr.dto.integration.MedicalDataRecord;
import com.founder.rhip.ehr.dto.integration.MedicalMonitor;
import com.founder.rhip.ehr.dto.integration.PhysicalExaminationMonitorRecord;
import com.founder.rhip.ehr.dto.integration.WomenChildrenMonitorRecord;
import com.founder.rhip.ehr.entity.basic.IntegrationLog;
import com.founder.rhip.ehr.entity.basic.IntegrationMonitor;
import com.founder.rhip.ehr.repository.basic.IIntegrationLogDao;
import com.founder.rhip.ehr.repository.basic.IIntegrationMonitorDao;
import com.founder.rhip.ehr.repository.clinic.IConsultationInfoDao;
import com.founder.rhip.ehr.repository.clinic.IDiseaseDiagnosisInfoDao;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;
import com.founder.rhip.ehr.repository.clinic.IHealthExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientMedicalRecordDao;
import com.founder.rhip.ehr.repository.clinic.IOuthospitalSummaryDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientPrescriptionDao;
import com.founder.rhip.ehr.repository.clinic.IReferralInfoDao;
import com.founder.rhip.ehr.repository.clinic.IStudyEventDao;
import com.founder.rhip.ehr.repository.clinic.ISurgeryInfoDao;
import com.founder.rhip.ehr.repository.clinic.ITransBloodInfoDao;
import com.founder.rhip.mdm.entity.Organization;

@Service("integrationMonitorService")
public class IntegrationMonitorServiceImpl extends AbstractService implements IIntegrationMonitorService {
	
	private static final String ORGAN_CODE = "ORGAN_CODE";
	private static final String RECORD_DATE = "RECORD_DATE";
	private static final String NUMBER_CODE = "NUMBER_CODE";
	private static final String TIME_STYLE = "yyyy/MM/dd";
	// 5家综合医院
	private static final String[] HOSPITAL_CODES = new String[] {"46714063-X","46714062-1","46714078-7","46714117-3","46714077-9"};
	
	private static final String KEY_SYMBOL = "~";
	
	private static final String DATE_STYLE = "yyyy/MM/dd";
	
	@Resource(name = "integrationMonitorDao")
	private IIntegrationMonitorDao integrationMonitorDao;
	
	@Resource(name = "integrationLogDao")
	private IIntegrationLogDao integrationLogDao;

	@Resource(name = "outpatientInfoDao")
	private IOutpatientInfoDao outpatientInfoDao;
	
	@Resource(name = "inpatientInfoDao")
	private IInpatientInfoDao inpatientInfoDao;
	
	@Resource(name = "diseaseDiagnosisInfoDao")
	private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;
	
	@Resource(name = "outpatientPrescriptionDao")
	private IOutpatientPrescriptionDao outpatientPrescriptionDao;
	
	@Resource(name = "drugUsageDao")
	private IDrugUsageDao drugUsageDao;
	
	@Resource(name = "surgeryInfoDao")
	private ISurgeryInfoDao surgeryInfoDao;
	
	@Resource(name = "transBloodInfoDao")
	private ITransBloodInfoDao transBloodInfoDao;
	
	@Resource(name = "examineEventDao")
	private IExamineEventDao examineEventDao;
	
	@Resource(name = "healthExaminationDao")
	private IHealthExaminationDao healthExaminationDao;
	
	@Resource(name = "outhospitalSummaryDao")
	private IOuthospitalSummaryDao outhospitalSummaryDao;
	
	@Resource(name = "inpatientMedicalRecordDao")
	private IInpatientMedicalRecordDao inpatientMedicalRecordDao;
	
	@Resource(name = "referralInfoDao")
	private IReferralInfoDao referralInfoDao;
	
	@Resource(name = "consultationInfoDao")
	private IConsultationInfoDao consultationInfoDao;
	
	@Resource(name = "studyEventDao")
	private IStudyEventDao studyEventDao;
	
	@Override
	public List<IntegrationMonitor> queryIntegrationMonitors(Criteria criteria) {
		List<IntegrationMonitor> integrationMonitors = new ArrayList<>();
		if (criteria == null) {
			return integrationMonitors;
		}
		return integrationMonitorDao.getList(criteria);
	}

	@Override
	public void recordMedicalIntegrationMonitor(Map<String, Long[]> map, String numberCode, String numberName) {
		if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(numberCode)) {
			return;
		}
		for (String key : map.keySet()) {
			if (!StringUtils.contains(key, KEY_SYMBOL)) {
				continue;
			}
			String[] strs = StringUtils.split(key, KEY_SYMBOL);
			Long[] counts = null;
			if (strs == null || strs.length < 2 || ObjectUtil.isNullOrEmpty(strs[0]) || ObjectUtil.isNullOrEmpty(strs[1]) || (counts = map.get(key)) == null || counts.length < 3) {
				continue;
			}
	
			IntegrationMonitor monitor = integrationMonitorDao.getIntegrationMonitor(new Criteria(ORGAN_CODE, strs[0]).add(RECORD_DATE, strs[1]).add(NUMBER_CODE, numberCode));
			counts[0] = counts[0] == null ? 0 : counts[0];
			counts[1] = counts[1] == null ? 0 : counts[1];
			counts[2] = counts[2] == null ? 0 : counts[2];
			Date date = DateUtil.parseSimpleDate(strs[1], DATE_STYLE);
			try {
				// 5家市级医院采用CDA方式，不通过前置机处理在监控表中不会存在
				if (monitor == null) {
					if (ArrayUtils.contains(HOSPITAL_CODES, strs[0])) {
						if (StringUtils.equalsIgnoreCase(numberCode,
								IntegrationNumberType.DOCTOR_ADVICE.getCode()) && counts[0] == 0 && counts[1] == 0 && counts[2] == 0) {
							recordOtherInfo(strs[0], counts, date, IntegrationNumberType.ORDER_DRUG);
						} else {
							IntegrationMonitor im = new IntegrationMonitor();
							im.setOrganCode(strs[0]); // 机构代码
							im.setNumberCode(numberCode);
							im.setNumberName(numberName);
							im.setRecordDate(date);
							im.setFrontUploadCount(counts[0] + counts[1] + counts[2]);
							im.setFactAddCount(counts[0]); // 新增数量
							im.setFactUpdateCount(counts[1]); // 更新数量
							im.setFactFailCount(counts[2]); // 失败数量
							im.setFactUploadCount(counts[0] + counts[1] + counts[2]); // 实际总数量
							im.setStatus(0); // 默认状态0
							integrationMonitorDao.insert(im);
						}
						// 如果是门诊处方，则应该还要处理用药信息
						if (StringUtils.equalsIgnoreCase(numberCode, IntegrationNumberType.OUTPATIENT_PRESCRIPTION.getCode())) {
//							recordDrugUsage(strs[0], counts, date);
							recordOtherInfo(strs[0], counts, date, IntegrationNumberType.ORDER_DRUG);
						}
						// 如果是门诊记录，还需要处理门急诊挂号信息
						if (StringUtils.equalsIgnoreCase(numberCode, IntegrationNumberType.OUTPATIENT.getCode())) {
							recordOtherInfo(strs[0], counts, date, IntegrationNumberType.REGISTER_RECORD);
						}
						// 如果是医嘱记录，还需要处理用药信息
						if (StringUtils.equalsIgnoreCase(numberCode, IntegrationNumberType.DOCTOR_ADVICE.getCode())
								&& (counts[0] != 0 || counts[1] != 0 || counts[2] != 0)) {
							recordOtherInfo(strs[0], counts, date, IntegrationNumberType.ORDER_DRUG);
						}
					}
				} else {// SAAS、乡镇卫生院医疗数据从前置机到中间库的数量已经保存，所以需要更新
					monitor.setFactAddCount(counts[0]); // 新增数量
					monitor.setFactUpdateCount(counts[1]); // 更新数量
					monitor.setFactFailCount(counts[2]); // 失败数量
					monitor.setFactUploadCount(counts[0] + counts[1] + counts[2]); // 实际总数量
					String[] properties = new String[] {"factAddCount", "factUpdateCount", "factFailCount", "factUploadCount"};
					integrationMonitorDao.update(monitor, properties);
				}
			} catch (Exception e) {
				StringBuilder sb = new StringBuilder("记录集成监控记录错误，机构编码：").append(strs[0]).append(" 编号代码：").append(numberCode);
				log.error(sb.toString());
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 记录用药记录
	 * 
	 * @param orgCode 机构代码
	 * @param counts
	 * @param date
	 */
	private void recordDrugUsage(String orgCode, Long[] counts, Date date) {
		if (ObjectUtil.isNullOrEmpty(orgCode) || ObjectUtil.isNullOrEmpty(counts) || counts.length < 6) {
			return;
		}
		IntegrationMonitor monitor = integrationMonitorDao.getIntegrationMonitor(new Criteria(ORGAN_CODE, orgCode).add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, date)).add(NUMBER_CODE, IntegrationNumberType.ORDER_DRUG.getCode()));
		counts[3] = counts[3] == null ? 0 : counts[3];
		counts[4] = counts[4] == null ? 0 : counts[4];
		counts[5] = counts[5] == null ? 0 : counts[5];
		if (monitor == null) {
			IntegrationMonitor im = new IntegrationMonitor();
			im.setOrganCode(orgCode); // 机构代码
			im.setNumberCode(IntegrationNumberType.ORDER_DRUG.getCode());
			im.setNumberName(IntegrationNumberType.ORDER_DRUG.getName());
			im.setRecordDate(date);
			im.setFrontUploadCount(counts[3] + counts[4] + counts[5]);
			im.setFactAddCount(counts[3]); // 新增数量
			im.setFactUpdateCount(counts[4]); // 更新数量
			im.setFactFailCount(counts[5]); // 失败数量
			im.setFactUploadCount(counts[3] + counts[4] + counts[5]); // 实际总数量
			im.setStatus(0); // 默认状态0
			integrationMonitorDao.insert(im);
		} else {
			monitor.setFactAddCount(counts[3]); // 新增数量
			monitor.setFactUpdateCount(counts[4]); // 更新数量
			monitor.setFactFailCount(counts[5]); // 失败数量
			monitor.setFactUploadCount(counts[3] + counts[4] + counts[5]); // 实际总数量
			String[] properties = new String[] {"factAddCount", "factUpdateCount", "factFailCount", "factUploadCount"};
			integrationMonitorDao.update(monitor, properties);
		}
	}
	
	private void recordOtherInfo(String orgCode, Long[] counts, Date date, IntegrationNumberType integrationNumberType) {
		if (ObjectUtil.isNullOrEmpty(orgCode) || ObjectUtil.isNullOrEmpty(counts) || counts.length < 6) {
			return;
		}
		IntegrationMonitor monitor = integrationMonitorDao.getIntegrationMonitor(new Criteria(ORGAN_CODE, orgCode).add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, date)).add(NUMBER_CODE, integrationNumberType.getCode()));
		counts[3] = counts[3] == null ? 0 : counts[3];
		counts[4] = counts[4] == null ? 0 : counts[4];
		counts[5] = counts[5] == null ? 0 : counts[5];
		if (monitor == null) {
			IntegrationMonitor im = new IntegrationMonitor();
			im.setOrganCode(orgCode); // 机构代码
			im.setNumberCode(integrationNumberType.getCode());
			im.setNumberName(integrationNumberType.getName());
			im.setRecordDate(date);
			im.setFrontUploadCount(counts[3] + counts[4] + counts[5]);
			im.setFactAddCount(counts[3]); // 新增数量
			im.setFactUpdateCount(counts[4]); // 更新数量
			im.setFactFailCount(counts[5]); // 失败数量
			im.setFactUploadCount(counts[3] + counts[4] + counts[5]); // 实际总数量
			im.setStatus(0); // 默认状态0
			integrationMonitorDao.insert(im);
		} else {
			Long frontCount = monitor.getFrontUploadCount();
			Long factCount = monitor.getFactUploadCount();
			Long finalFrontCount = frontCount + counts[3] + counts[4] + counts[5];
			Long finalFactCount = factCount + counts[3] + counts[4] + counts[5];
			monitor.setFrontUploadCount(finalFrontCount);
			monitor.setFactAddCount(monitor.getFactAddCount() + counts[3]); // 新增数量
			monitor.setFactUpdateCount(monitor.getFactUpdateCount() + counts[4]); // 更新数量
			monitor.setFactFailCount(monitor.getFactFailCount() + counts[5]); // 失败数量
			monitor.setFactUploadCount(finalFactCount); // 实际总数量
			String[] properties = new String[] {"factAddCount", "factUpdateCount", "factFailCount", "factUploadCount", "frontUploadCount"};
			integrationMonitorDao.update(monitor, properties);
		}
	}

	@Override
	public List<HospitalMedicalMonitorRecord> organizeHospitalMedicalMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate,List<String> projectNameList) {

		List<HospitalMedicalMonitorRecord> hmMonitorList = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(organizations) || ObjectUtil.isNullOrEmpty(dateList)) {
			return hmMonitorList;
		}
		
		List<String> orgCodes = new ArrayList<String>();
		for (Organization organization : organizations) {
			orgCodes.add(organization.getOrganCode());
		}
		for (Organization organization : organizations) {
			List<MedicalMonitor> mList = new ArrayList<>();
			for (int i = 0; i < dateList.size(); i++) {
				MedicalMonitor m = new MedicalMonitor();
				Date d = DateUtil.getAfterDay(beginDate, i);
				Criteria criteria = new Criteria();
				criteria.add(ORGAN_CODE, organization.getOrganCode()); //机构编码
				criteria.add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, d)); // 记录时间
				if(projectNameList.contains("h01")) {
					// 门诊记录
					IntegrationMonitor opm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.OUTPATIENT.getCode()));
					if (ObjectUtil.isNotEmpty(opm)) {
						m.setShouldOutpatientCount(opm.getFrontUploadCount());
						m.setActualOutpatientCount(opm.getFactUploadCount());
					}
				}
				
				if(projectNameList.contains("h06")) {
					// 住院记录
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.INPATIENT.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldInpatientCount(ipm.getFrontUploadCount());
						m.setActualInpatientCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h02")) {
					// 诊断记录
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.MEDIDAL_DIAGNOSIS.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldDiseaseDiagnosisCount(ipm.getFrontUploadCount());
						m.setActualDiseaseDiagnosisCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h03")) {
					// 门诊处方
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.OUTPATIENT_PRESCRIPTION.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldOutpatientPrescriptionCount(ipm.getFrontUploadCount());
						m.setActualOutpatientPrescriptionCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h04")) {
					// 医嘱用药
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.ORDER_DRUG.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldDrugCount(ipm.getFrontUploadCount());
						m.setActualDrugCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h07")) {
					// 手术记录
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.SURGERY.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldSurgeryCount(ipm.getFrontUploadCount());
						m.setActualSurgeryCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h08")) {
					// 输血记录
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.BLOOD_TRANS.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldTransBloodCount(ipm.getFrontUploadCount());
						m.setActualTransBloodCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h09")) {
					// 检验
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.LABORATORY_EXAMINATION.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldExamineEventCount(ipm.getFrontUploadCount());
						m.setActualExamineEventCount(ipm.getFactUploadCount());
					}
				}
				
				if(projectNameList.contains("h10")) {
					// 体检
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHYSICAL_EXAMINATION.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldHealthExaminationCount(ipm.getFrontUploadCount());
						m.setActualHealthExaminationCount(ipm.getFactUploadCount());
					}
				}
				
				if(projectNameList.contains("h11")) {
					// 出院小结
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.DISCHARGE_SUMMARY.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldOuthospitalSummaryCount(ipm.getFrontUploadCount());
						m.setActualOuthospitalSummaryCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h12")) {
					// 病案首页
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.INPATIENT_MEDICAL_RECORD.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldInpatientMedicalRecordCount(ipm.getFrontUploadCount());
						m.setActualInpatientMedicalRecordCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h13")) {
					// 转诊
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.REFERRAL.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldReferralCount(ipm.getFrontUploadCount());
						m.setActualReferralCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h14")) {
					// 会诊
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.CONSULTATION.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldConsultationCount(ipm.getFrontUploadCount());
						m.setActualConsultationCount(ipm.getFactUploadCount());
					}
				}
				if(projectNameList.contains("h15")) {
					// 检查
					criteria.remove(NUMBER_CODE);
					IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.ASSISTANTEXAMINATION.getCode()));
					if (ObjectUtil.isNotEmpty(ipm)) {
						m.setShouldStudyEventCount(ipm.getFrontUploadCount());
						m.setActualStudyEventCount(ipm.getFactUploadCount());
					}
				}
				mList.add(m);
			}
			HospitalMedicalMonitorRecord hmr = new HospitalMedicalMonitorRecord();
			hmr.setMonitors(mList);
			hmr.setOrganization(organization);
			hmMonitorList.add(hmr);
		}
		return hmMonitorList;
	}

	@Override
	public List<DrugMonitorRecord> organizeDrugMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate) {
		List<DrugMonitorRecord> drugMonitorRecordList = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(organizations) || ObjectUtil.isNullOrEmpty(dateList)) {
			return drugMonitorRecordList;
		}
		for (Organization organization : organizations) {
			List<GenericMonitor> genericMonitorList = new ArrayList<>();
			for (int i = 0; i < dateList.size(); i++) {
				GenericMonitor genericMonitor = new GenericMonitor();
				Date d = DateUtil.getAfterDay(beginDate, i);
				Criteria criteria = new Criteria(); // 查询条件
				criteria.add(ORGAN_CODE, organization.getOrganCode()); //机构编码
				criteria.add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, d)); // 记录时间
				criteria.add(NUMBER_CODE, IntegrationNumberType.DRUG_CHARGE.getCode());
				IntegrationMonitor im = integrationMonitorDao.getIntegrationMonitor(criteria);
				if (im == null) {
					genericMonitor.setShouldCount(0L);
					genericMonitor.setActualCount(0L);
				} else {
					genericMonitor.setShouldCount(im.getFrontUploadCount());
					genericMonitor.setActualCount(im.getFactUploadCount());
				}
				genericMonitorList.add(genericMonitor);
			}
			DrugMonitorRecord drugMonitorRecord = new DrugMonitorRecord();
			drugMonitorRecord.setOrganization(organization);
			drugMonitorRecord.setGenericMonitors(genericMonitorList);
			drugMonitorRecordList.add(drugMonitorRecord);
		}
		return drugMonitorRecordList;
	}

	@Override
	public List<WomenChildrenMonitorRecord> organizeWomenChildrenMoitorRecord(List<Date> dateList, Date beginDate) {
		List<WomenChildrenMonitorRecord> womenChildrenMonitorRecordList = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(dateList)) {
			return womenChildrenMonitorRecordList;
		}
		List<WomenChildrenMonitorRecord> wChildrenMonitorRecordList = new ArrayList<>();
		for (WomenChildrenHealthcareType womenChildrenHealthcareType : WomenChildrenHealthcareType.values()) {
			List<GenericMonitor> genericMonitorList = new ArrayList<>();
			for (int i = 0; i < dateList.size(); i++) {
				GenericMonitor genericMonitor = new GenericMonitor();
				Date d = DateUtil.getAfterDay(beginDate, i);
				Criteria criteria = new Criteria(); // 查询条件
				criteria.add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, d)); // 记录时间
				criteria.add(NUMBER_CODE, womenChildrenHealthcareType.getCode());
				IntegrationMonitor im = integrationMonitorDao.getIntegrationMonitor(criteria);
				if (im == null) {
					genericMonitor.setShouldCount(0L);
					genericMonitor.setActualCount(0L);
				} else {
					genericMonitor.setShouldCount(im.getFrontUploadCount());
					genericMonitor.setActualCount(im.getFactUploadCount());
				}
				genericMonitorList.add(genericMonitor);
			}
			WomenChildrenMonitorRecord womenChildrenMonitorRecord = new WomenChildrenMonitorRecord();
			womenChildrenMonitorRecord.setTypeName(womenChildrenHealthcareType.getDes());
			womenChildrenMonitorRecord.setGenericMonitors(genericMonitorList);
			wChildrenMonitorRecordList.add(womenChildrenMonitorRecord);
		}
		return wChildrenMonitorRecordList;
	}

	@Override
	public List<GenericMonitor> organizePlanImmunizationMonitorRecord(List<Date> dateList, Date beginDate) {
		List<GenericMonitor> genericMonitorList = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(dateList)) {
			return genericMonitorList;
		}
		for (int i = 0; i < dateList.size(); i++) {
			GenericMonitor genericMonitor = new GenericMonitor();
			Date d = DateUtil.getAfterDay(beginDate, i);
			Criteria criteria = new Criteria(); // 查询条件
			criteria.add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, d)); // 记录时间
			criteria.add(NUMBER_CODE, IntegrationNumberType.VACCINATE_INFO.getCode());
			IntegrationMonitor im = integrationMonitorDao.getIntegrationMonitor(criteria);
			if (im == null) {
				genericMonitor.setShouldCount(0L);
				genericMonitor.setActualCount(0L);
			} else {
				genericMonitor.setShouldCount(im.getFrontUploadCount());
				genericMonitor.setActualCount(im.getFactUploadCount());
			}
			genericMonitorList.add(genericMonitor);
		}
		return genericMonitorList;
	}

	@Override
	public List<PhysicalExaminationMonitorRecord> organizePhysicalExaminationMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate) {
		List<PhysicalExaminationMonitorRecord> physicalExamMonitorRecordList = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(organizations) || ObjectUtil.isNullOrEmpty(dateList)) {
			return physicalExamMonitorRecordList;
		}
		for (Organization organization : organizations) {
			List<GenericMonitor> genericMonitorList = new ArrayList<>();
			for (int i = 0; i < dateList.size(); i++) {
				GenericMonitor genericMonitor = new GenericMonitor();
				Date d = DateUtil.getAfterDay(beginDate, i);
				Criteria criteria = new Criteria(); // 查询条件
				criteria.add(ORGAN_CODE, organization.getOrganCode()); //机构编码
				criteria.add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, d)); // 记录时间
				criteria.add(NUMBER_CODE, IntegrationNumberType.PHYSICAL_EXAMINATION.getCode());
				IntegrationMonitor im = integrationMonitorDao.getIntegrationMonitor(criteria);
				if (im == null) {
					genericMonitor.setShouldCount(0L);
					genericMonitor.setActualCount(0L);
				} else {
					genericMonitor.setShouldCount(im.getFrontUploadCount());
					genericMonitor.setActualCount(im.getFactUploadCount());
				}
				genericMonitorList.add(genericMonitor);
			}
			PhysicalExaminationMonitorRecord physicalExamMonitorRecord = new PhysicalExaminationMonitorRecord();
			physicalExamMonitorRecord.setOrganization(organization);
			physicalExamMonitorRecord.setGenericMonitors(genericMonitorList);
			physicalExamMonitorRecordList.add(physicalExamMonitorRecord);
		}
		return physicalExamMonitorRecordList;
	}

	@Override
	public void recordHealthCareIntegrationMonitor(Map<String, Long[]> map, Date date, String category) {
		Long[] counts = null;
		IntegrationNumberType integrationNumberType = null;
		if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(category) 
				|| ObjectUtil.isNullOrEmpty(integrationNumberType = IntegrationMonitorRecorder.matchIntegrationType(category))
				|| date == null || ObjectUtil.isNullOrEmpty(counts = map.get(category))
				|| counts.length < 3) {
			return;
		}
		
		Criteria criteria = new Criteria(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, date)).add(NUMBER_CODE, integrationNumberType.getCode());
		IntegrationMonitor im = integrationMonitorDao.getIntegrationMonitor(criteria);
		counts[0] = counts[0] == null ? 0 : counts[0];
		counts[1] = counts[1] == null ? 0 : counts[1];
		counts[2] = counts[2] == null ? 0 : counts[2];
		try {
			if (im == null) {
				IntegrationMonitor integrationMonitor = new IntegrationMonitor();
				integrationMonitor.setNumberCode(integrationNumberType.getCode());
				integrationMonitor.setNumberName(integrationNumberType.getName());
				integrationMonitor.setFactAddCount(counts[0]);
				integrationMonitor.setFactUpdateCount(counts[1]);
				integrationMonitor.setFactFailCount(counts[2]);
				integrationMonitor.setFactUploadCount(counts[0] + counts[1] + counts[2]); // 实传数量
				integrationMonitor.setFrontUploadCount(counts[0] + counts[1] + counts[2]); // 应传数量
				integrationMonitor.setStatus(0); // 默认状态为0
				integrationMonitor.setRecordDate(date);
				integrationMonitorDao.insert(integrationMonitor);
			} else {
				Long addCount = im.getFactAddCount();
				Long updateCount = im.getFactUpdateCount();
				Long faildCount = im.getFactFailCount();
				addCount = addCount == null ? 0 : addCount;
				updateCount = updateCount == null ? 0 : updateCount;
				faildCount = faildCount == null ? 0 : faildCount;
				Long tAddCount = addCount + counts[0];
				Long tUpdateCount = updateCount + counts[1];
				Long tFaildCount = faildCount + counts[2];
				im.setFactAddCount(tAddCount);
				im.setFactUpdateCount(tUpdateCount);
				im.setFactFailCount(tFaildCount);
				im.setFrontUploadCount(tAddCount + tUpdateCount + tFaildCount);
				im.setFactUploadCount(tAddCount + tUpdateCount + tFaildCount);
				String[] properties = new String[] {"factAddCount", "factUpdateCount", "factFailCount", "factUploadCount", "frontUploadCount"};
				integrationMonitorDao.update(im, properties);
			}
		} catch (Exception e) {
			StringBuilder sb = new StringBuilder("记录集成监控记录错误，编号代码：").append(integrationNumberType.getCode());
			log.error(sb.toString());
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public PageList<IntegrationLog> searchIntegrationLogs(Criteria criteria, Page page) {
		Order order = new Order("RECORD_DATE", false);
		return integrationLogDao.getPageList(page, criteria, order);
	}
	
	@Override
	public List<MedicalDataRecord> searchMedicalDataRecord(List<Organization> organizations, Date medicalDataDate, List<String> projectNameList) {

		List<MedicalDataRecord> medicalDataRecordList = new ArrayList<MedicalDataRecord>();
		List<String> orgCodes = new ArrayList<String>();
		for (Organization organization : organizations) {
			orgCodes.add(organization.getOrganCode());
		}
		
		for (Organization organization : organizations) {
			List<MedicalData> medicalDataList = new ArrayList<MedicalData>();
			for (int i = 6; i >= 0; i--) {
				MedicalData m = new MedicalData();
				Date d = DateUtil.getBeforeDay(medicalDataDate, i);
				if(projectNameList.contains("h01")) {
					Criteria outpatientCriteria = new Criteria("CLINIC_ORGAN_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(outpatientCriteria, "CLINIC_DATE", d, d);
					// 门诊记录
					m.setActualOutpatientCount(outpatientInfoDao.getCount(outpatientCriteria, "id", Long.class));
					//m.setActualOutpatientCount(outpatientInfoDao.getCount(outpatientCriteria));
				}
				
				if(projectNameList.contains("h06")) {
					Criteria inpatientCriteria = new Criteria("REFERRAL_HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(inpatientCriteria, "INHOS_DATE", d, d);
					m.setActualInpatientCount(inpatientInfoDao.getCount(inpatientCriteria, "id", Long.class));
					//m.setActualInpatientCount(inpatientInfoDao.getCount(inpatientCriteria));
				}
				if(projectNameList.contains("h02")) {
					Criteria diseaseDiagnosisCriteria = new Criteria("HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(diseaseDiagnosisCriteria, "DIAGNOSE_DATE", d, d);
					m.setActualDiseaseDiagnosisCount(diseaseDiagnosisInfoDao.getCount(diseaseDiagnosisCriteria, "id", Long.class));
					//m.setActualDiseaseDiagnosisCount(diseaseDiagnosisInfoDao.getCount(diseaseDiagnosisCriteria));
				}
				if(projectNameList.contains("h03")) {
					Criteria outpatientPrescriptionCriteria = new Criteria("HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(outpatientPrescriptionCriteria, "PRESCRIBE_DATE", d, d);
					m.setActualOutpatientPrescriptionCount(outpatientPrescriptionDao.getCount(outpatientPrescriptionCriteria, "id", Long.class));
				}
				if(projectNameList.contains("h04")) {
					Criteria drugUsageCriteria = new Criteria("REFERRAL_HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(drugUsageCriteria, "CLINIC_DATE", d, d);
					m.setActualDrugCount(drugUsageDao.getCount(drugUsageCriteria, "id", Long.class));
				}
				if(projectNameList.contains("h07")) {
					Criteria surgeryCriteria = new Criteria("HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(surgeryCriteria, "OPERTATION_DATE", d, d);
					m.setActualSurgeryCount(surgeryInfoDao.getCount(surgeryCriteria, "id", Long.class));
				}
				if(projectNameList.contains("h08")) {
					Criteria transBloodCriteria = new Criteria("HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(transBloodCriteria, "BLOOD_DATE", d, d);
					m.setActualTransBloodCount(transBloodInfoDao.getCount(transBloodCriteria, "id", Long.class));
				}
				if(projectNameList.contains("h09")) {
					Criteria examineEventCriteria = new Criteria("HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(examineEventCriteria, "CHECK_DATE", d, d);
					m.setActualExamineEventCount(examineEventDao.getCount(examineEventCriteria, "id", Long.class));
				}
				
				if(projectNameList.contains("h10")) {
					Criteria healthExaminationCriteria = new Criteria("HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(healthExaminationCriteria, "EXAMINATION_DATE", d, d);
					m.setActualHealthExaminationCount(healthExaminationDao.getCount(healthExaminationCriteria, "id", Long.class));
				}
				
				if(projectNameList.contains("h11")) {
					Criteria outhospitalSummaryCriteria = new Criteria("HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(outhospitalSummaryCriteria, "OUTHOS_DATE", d, d);
					m.setActualOuthospitalSummaryCount(outhospitalSummaryDao.getCount(outhospitalSummaryCriteria, "id", Long.class));
				}
				if(projectNameList.contains("h12")) {
					Criteria inpatientMedicalRecordCriteria = new Criteria("HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(inpatientMedicalRecordCriteria, "OUT_HOSPITAL_DATE", d, d);
					m.setActualInpatientMedicalRecordCount(inpatientMedicalRecordDao.getCount(inpatientMedicalRecordCriteria, "id", Long.class));
				}
				if(projectNameList.contains("h13")) {
					Criteria referralCriteria = new Criteria("DEST_DEPT_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(referralCriteria, "REFERRAL_DATE", d, d);
					m.setActualReferralCount(referralInfoDao.getCount(referralCriteria, "id", Long.class));
				}
				if(projectNameList.contains("h14")) {
					Criteria consultationCriteria = new Criteria("CONSULTATION_ORG_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(consultationCriteria, "CONSULTATION_DAE", d, d);
					m.setActualConsultationCount(consultationInfoDao.getCount(consultationCriteria, "id", Long.class));
				}
				if(projectNameList.contains("h15")) {
					Criteria studyEventCriteria = new Criteria("HOSPITAL_CODE", organization.getOrganCode());
					DateUtil.getCriteriaByDateRange(studyEventCriteria, "CHECK_DATE", d, d);
					m.setActualStudyEventCount(studyEventDao.getCount(studyEventCriteria, "id", Long.class));
				}
				medicalDataList.add(m);
			}
			MedicalDataRecord medicalDataRecord = new MedicalDataRecord();
			medicalDataRecord.setMedicalDatas(medicalDataList);
			medicalDataRecord.setOrganization(organization);
			medicalDataRecordList.add(medicalDataRecord);
		}
		return medicalDataRecordList;
	}

	@Override
	public void removeIntegrationLog(Date date) {
		if (ObjectUtil.isNullOrEmpty(date)) {
			return;
		}
		// 获取指定时间三天之前的时间
		Date destDate = DateUtil.getBeforeDay(date, 3);
		Criteria criteria = new Criteria("recordDate", OP.LE, destDate);
		
		try {
			integrationLogDao.delete(criteria);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

    /**
     * 按特定时间段 医药卫生用品 监控记录
     *
     * @param organizations 机构对象集合
     * @param dateList 日期对象集合，选定的日期时间段
     * @param beginDate 开始日期
     * @return
     */
    @Override
    public List<HospitalMedicalMonitorRecord> medicalGoodsMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate, List<String> projectNameList){
        List<HospitalMedicalMonitorRecord> hmMonitorList = new ArrayList<>();
        if (ObjectUtil.isNullOrEmpty(organizations) || ObjectUtil.isNullOrEmpty(dateList)) {
            return hmMonitorList;
        }

        List<String> orgCodes = new ArrayList<String>();
        for (Organization organization : organizations) {
            orgCodes.add(organization.getOrganCode());
        }
        for (Organization organization : organizations) {
            List<MedicalMonitor> mList = new ArrayList<>();
            for (int i = 0; i < dateList.size(); i++) {
                MedicalMonitor m = new MedicalMonitor();
                Date d = DateUtil.getAfterDay(beginDate, i);
                Criteria criteria = new Criteria();
                criteria.add(ORGAN_CODE, organization.getOrganCode()); //机构编码
                criteria.add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, d)); // 记录时间
                if(projectNameList.contains("da01")) {
                    // 药库入库
                    IntegrationMonitor opm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.STORAGE_IN.getCode()));
                    if (ObjectUtil.isNotEmpty(opm)) {
                        m.setShouldOutpatientCount(opm.getFrontUploadCount());
                        m.setActualOutpatientCount(opm.getFactUploadCount());
                    }
                }

                if(projectNameList.contains("da02")) {
                    // 药库入库详细
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.STORAGE_IN_DETAIL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldInpatientCount(ipm.getFrontUploadCount());
                        m.setActualInpatientCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da03")) {
                    // 药库出库
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.STORAGE_OUT.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldDiseaseDiagnosisCount(ipm.getFrontUploadCount());
                        m.setActualDiseaseDiagnosisCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da04")) {
                    // 药库出库详细
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.STORAGE_OUT_DETAIL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldOutpatientPrescriptionCount(ipm.getFrontUploadCount());
                        m.setActualOutpatientPrescriptionCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da05")) {
                    // 药库库存
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.STORAGE.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldDrugCount(ipm.getFrontUploadCount());
                        m.setActualDrugCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da06")) {
                    // 药库退货
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.STORAGE_RETURN.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldSurgeryCount(ipm.getFrontUploadCount());
                        m.setActualSurgeryCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da07")) {
                    // 药库退货详细
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.STORAGE_RETURN_DETAIL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldTransBloodCount(ipm.getFrontUploadCount());
                        m.setActualTransBloodCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da08")) {
                    // 药房入库
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHARMACY_IN.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount08(ipm.getFrontUploadCount());
                        m.setActualUploadCount08(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da09")) {
                    // 药房入库详细
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHARMACY_IN_DETAIL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldExamineEventCount(ipm.getFrontUploadCount());
                        m.setActualExamineEventCount(ipm.getFactUploadCount());
                    }
                }

                if(projectNameList.contains("da10")) {
                    // 药房出库
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHARMACY_OUT.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldHealthExaminationCount(ipm.getFrontUploadCount());
                        m.setActualHealthExaminationCount(ipm.getFactUploadCount());
                    }
                }

                if(projectNameList.contains("da11")) {
                    // 药房出库详细
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHARMACY_OUT_DETAIL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldOuthospitalSummaryCount(ipm.getFrontUploadCount());
                        m.setActualOuthospitalSummaryCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da12")) {
                    // 药房库存
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHARMACY.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldInpatientMedicalRecordCount(ipm.getFrontUploadCount());
                        m.setActualInpatientMedicalRecordCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da13")) {
                    // 药房退货
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHARMACY_RETURN.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldReferralCount(ipm.getFrontUploadCount());
                        m.setActualReferralCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da14")) {
                    // 药房退货详细
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHARMACY_RETURN_DETAIL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldConsultationCount(ipm.getFrontUploadCount());
                        m.setActualConsultationCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da15")) {
                    // 药房退药
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHARMACY_CANCEL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount15(ipm.getFrontUploadCount());
                        m.setActualUploadCount15(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da16")) {
                    //药房退药详细
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.PHARMACY_CANCEL_DETAIL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount16(ipm.getFrontUploadCount());
                        m.setActualUploadCount16(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da17")) {
                    //药品养护
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.DRUG_UP_KEEP.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount17(ipm.getFrontUploadCount());
                        m.setActualUploadCount17(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da18")) {
                    //耗材监控(入库单)
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.CONSUMABLE_IN.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount18(ipm.getFrontUploadCount());
                        m.setActualUploadCount18(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da19")) {
                    //耗材监控(入库明细)
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.CONSUMABLE_IN_DETAIL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount19(ipm.getFrontUploadCount());
                        m.setActualUploadCount19(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da20")) {
                    //耗材监控(出库单)
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.CONSUMABLE_OUT.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount20(ipm.getFrontUploadCount());
                        m.setActualUploadCount20(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da21")) {
                    //耗材监控(出库明细)
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.CONSUMABLE_OUT_DETAIL.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount21(ipm.getFrontUploadCount());
                        m.setActualUploadCount21(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da22")) {
                    //耗材监控(库存)
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.CONSUMABLE_STORE.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount22(ipm.getFrontUploadCount());
                        m.setActualUploadCount22(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da23")) {
                    //耗材监控(报损)
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.CONSUMABLE_BREAKAGE.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount23(ipm.getFrontUploadCount());
                        m.setActualUploadCount23(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da24")) {
                    //设备监控(库存)
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.EQUIPMENT_STORE.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount24(ipm.getFrontUploadCount());
                        m.setActualUploadCount24(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("da25")) {
                    //设备监控(报损)
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.EQUIPMENT_BREAKAGE.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldUploadCount25(ipm.getFrontUploadCount());
                        m.setActualUploadCount25(ipm.getFactUploadCount());
                    }
                }
                mList.add(m);
            }
            HospitalMedicalMonitorRecord hmr = new HospitalMedicalMonitorRecord();
            hmr.setMonitors(mList);
            hmr.setOrganization(organization);
            hmMonitorList.add(hmr);
        }
        return hmMonitorList;
    }

    /**
     * 按特定时间段 血站 监控记录
     *
     * @param organizations 机构对象集合
     * @param dateList 日期对象集合，选定的日期时间段
     * @param beginDate 开始日期
     * @return
     */
    public List<HospitalMedicalMonitorRecord> bloodStationMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate, List<String> projectNameList){
        List<HospitalMedicalMonitorRecord> hmMonitorList = new ArrayList<>();
        if (ObjectUtil.isNullOrEmpty(organizations) || ObjectUtil.isNullOrEmpty(dateList)) {
            return hmMonitorList;
        }

        List<String> orgCodes = new ArrayList<String>();
        for (Organization organization : organizations) {
            orgCodes.add(organization.getOrganCode());
        }
        for (Organization organization : organizations) {
            List<MedicalMonitor> mList = new ArrayList<>();
            for (int i = 0; i < dateList.size(); i++) {
                MedicalMonitor m = new MedicalMonitor();
                Date d = DateUtil.getAfterDay(beginDate, i);
                Criteria criteria = new Criteria();
                criteria.add(ORGAN_CODE, organization.getOrganCode()); //机构编码
                criteria.add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, d)); // 记录时间
                if(projectNameList.contains("bs01")) {
                    // 献血记录
                    IntegrationMonitor opm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.BS_BLOOD_DONOR_INFO.getCode()));
                    if (ObjectUtil.isNotEmpty(opm)) {
                        m.setShouldOutpatientCount(opm.getFrontUploadCount());
                        m.setActualOutpatientCount(opm.getFactUploadCount());
                    }
                }

                if(projectNameList.contains("bs02")) {
                    // 免费用血
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.BS_REIMBURSEMENT.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldInpatientCount(ipm.getFrontUploadCount());
                        m.setActualInpatientCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("bs03")) {
                    // 血液库存
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.BS_BLOODBANK.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldDiseaseDiagnosisCount(ipm.getFrontUploadCount());
                        m.setActualDiseaseDiagnosisCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("bs04")) {
                    // 血液出库
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.BS_BLOOD2HOS.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldOutpatientPrescriptionCount(ipm.getFrontUploadCount());
                        m.setActualOutpatientPrescriptionCount(ipm.getFactUploadCount());
                    }
                }
                mList.add(m);
            }
            HospitalMedicalMonitorRecord hmr = new HospitalMedicalMonitorRecord();
            hmr.setMonitors(mList);
            hmr.setOrganization(organization);
            hmMonitorList.add(hmr);
        }
        return hmMonitorList;
    }


    /**
     * 按特定时间段 120数据 监控记录
     *
     * @param organizations 机构对象集合
     * @param dateList 日期对象集合，选定的日期时间段
     * @param beginDate 开始日期
     * @return
     */
    public List<HospitalMedicalMonitorRecord> data120MonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate, List<String> projectNameList){
        List<HospitalMedicalMonitorRecord> hmMonitorList = new ArrayList<>();
        if (ObjectUtil.isNullOrEmpty(organizations) || ObjectUtil.isNullOrEmpty(dateList)) {
            return hmMonitorList;
        }

        List<String> orgCodes = new ArrayList<String>();
        for (Organization organization : organizations) {
            orgCodes.add(organization.getOrganCode());
        }
        for (Organization organization : organizations) {
            List<MedicalMonitor> mList = new ArrayList<>();
            for (int i = 0; i < dateList.size(); i++) {
                MedicalMonitor m = new MedicalMonitor();
                Date d = DateUtil.getAfterDay(beginDate, i);
                Criteria criteria = new Criteria();
                criteria.add(ORGAN_CODE, organization.getOrganCode()); //机构编码
                criteria.add(RECORD_DATE, DateUtil.getDateTime(TIME_STYLE, d)); // 记录时间
                if(projectNameList.contains("jj01")) {
                    // 急救事件
                    IntegrationMonitor opm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.JJ_ALARM_EVENT.getCode()));
                    if (ObjectUtil.isNotEmpty(opm)) {
                        m.setShouldOutpatientCount(opm.getFrontUploadCount());
                        m.setActualOutpatientCount(opm.getFactUploadCount());
                    }
                }

                if(projectNameList.contains("jj02")) {
                    // 接受事件
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.JJ_ACCEPT_EVENT.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldInpatientCount(ipm.getFrontUploadCount());
                        m.setActualInpatientCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("jj03")) {
                    // 血液库存
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.JJ_TASK.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldDiseaseDiagnosisCount(ipm.getFrontUploadCount());
                        m.setActualDiseaseDiagnosisCount(ipm.getFactUploadCount());
                    }
                }
                if(projectNameList.contains("jj04")) {
                    // 血液出库
                    criteria.remove(NUMBER_CODE);
                    IntegrationMonitor ipm = integrationMonitorDao.getIntegrationMonitor(criteria.add(NUMBER_CODE, IntegrationNumberType.JJ_AMBULANCE.getCode()));
                    if (ObjectUtil.isNotEmpty(ipm)) {
                        m.setShouldOutpatientPrescriptionCount(ipm.getFrontUploadCount());
                        m.setActualOutpatientPrescriptionCount(ipm.getFactUploadCount());
                    }
                }
                mList.add(m);
            }
            HospitalMedicalMonitorRecord hmr = new HospitalMedicalMonitorRecord();
            hmr.setMonitors(mList);
            hmr.setOrganization(organization);
            hmMonitorList.add(hmr);
        }
        return hmMonitorList;
    }

	@Override
	public Map<String, Object> getMonitorRecordNumMap(Criteria criteria) {

		return integrationMonitorDao.getIntegrationMonitorNum(criteria);
	}

	@Override
	public MedicalMonitor getHospitalMedicalMonitorRecord(Criteria criteria) {
		MedicalMonitor m = new MedicalMonitor();

		Map<String, Object> ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(getHospitalMedalDataCriteria()));

		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}

		// 门诊记录
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.OUTPATIENT.getCode()));

		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldOutpatientCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualOutpatientCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}

		// 住院记录
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.INPATIENT.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldInpatientCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualInpatientCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}

		// 诊断记录
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.MEDIDAL_DIAGNOSIS.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldDiseaseDiagnosisCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualDiseaseDiagnosisCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 门诊处方
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.OUTPATIENT_PRESCRIPTION.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldOutpatientPrescriptionCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualOutpatientPrescriptionCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 医嘱用药
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.ORDER_DRUG.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldDrugCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualDrugCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 手术记录
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.SURGERY.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldSurgeryCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualSurgeryCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 输血记录
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.BLOOD_TRANS.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldTransBloodCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualTransBloodCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 检验
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.LABORATORY_EXAMINATION.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldExamineEventCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualExamineEventCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 体检
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.PHYSICAL_EXAMINATION.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldHealthExaminationCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualHealthExaminationCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 出院小结
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.DISCHARGE_SUMMARY.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldOuthospitalSummaryCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualOuthospitalSummaryCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 病案首页
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.INPATIENT_MEDICAL_RECORD.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldInpatientMedicalRecordCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualInpatientMedicalRecordCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 转诊
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.REFERRAL.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldReferralCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualReferralCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 会诊
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.CONSULTATION.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldConsultationCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualConsultationCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		// 检查
		criteria.remove(NUMBER_CODE);
		ipm = integrationMonitorDao.getIntegrationMonitorNum(criteria.add(NUMBER_CODE, IntegrationNumberType.ASSISTANTEXAMINATION.getCode()));
		if (ObjectUtil.isNotEmpty(ipm)) {
			m.setShouldStudyEventCount((ObjectUtil.isNullOrEmpty(ipm.get("FACT_ADD_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_ADD_COUNT").toString())) + (ObjectUtil.isNullOrEmpty(ipm.get("FACT_UPDATE_COUNT"))? 0L : Long.valueOf(ipm.get("FACT_UPDATE_COUNT").toString())));
			m.setActualStudyEventCount(ObjectUtil.isNullOrEmpty(ipm.get("FACT_FAIL_COUNT")) ? 0L : Long.valueOf(ipm.get("FACT_FAIL_COUNT").toString()));
		}
		return m;
	}

	private Criteria getHospitalMedalDataCriteria() {
		Criteria criteria = new Criteria();
		criteria.add(NUMBER_CODE,OP.IN, new String[]{"h01", "h02", "h03", "h04", "h06", "h07", "h09", "h10", "h11", "h12", "h13", "h14", "h15"});
		return  criteria;
	}
}


