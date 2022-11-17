package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.repository.clinic.IConsultationInfoDao;
import com.founder.rhip.ehr.repository.clinic.IDiseaseDiagnosisInfoDao;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;
import com.founder.rhip.ehr.repository.clinic.IExpenseInfoDao;
import com.founder.rhip.ehr.repository.clinic.IHealthExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientMedicalRecordDao;
import com.founder.rhip.ehr.repository.clinic.IObservationInfoDao;
import com.founder.rhip.ehr.repository.clinic.IOuthospitalSummaryDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientPrescriptionDao;
import com.founder.rhip.ehr.repository.clinic.IReferralInfoDao;
import com.founder.rhip.ehr.repository.clinic.IStudyEventDao;
import com.founder.rhip.ehr.repository.clinic.ISurgeryInfoDao;
import com.founder.rhip.ehr.repository.clinic.ITransBloodInfoDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service("idmAnalyseService")
@TaskBean(cron = "0 0 4 * * ?", description = "传染病过滤定时任务")
public class IdmAnalyseServiceImpl extends AbstractService implements IIdmAnalyseService, Task {
	
	private static final String IS_LIMIT = "isLimit";
	
	private static final String EHR_ID = "ehrId";
	
	private static Integer FILTER_TRUE = 1;
	
	private static Integer FILTER_FALSE = 0;
	
	@Resource(name = "diseaseDiagnosisInfoDao")
	private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;
	
	@Resource(name = "ehrHealthEventDao")
	private IEHRHealthEventDao ehrHealthEventDao;
	
	@Resource(name = "expenseInfoDao")
	private IExpenseInfoDao expenseInfoDao;
	
	@Resource(name = "outpatientInfoDao")
	private IOutpatientInfoDao outpatientInfoDao;
	
	@Resource(name = "outpatientPrescriptionDao")
	private IOutpatientPrescriptionDao outpatientPrescriptionDao;
	
	@Resource(name = "drugUsageDao")
	private IDrugUsageDao drugUsageDao;
	
	@Resource(name = "inpatientInfoDao")
	private IInpatientInfoDao inpatientInfoDao;
	
	@Resource(name = "surgeryInfoDao")
	private ISurgeryInfoDao surgeryInfoDao;
	
	@Resource(name = "referralInfoDao")
	private IReferralInfoDao referralInfoDao;
	
	@Resource(name = "consultationInfoDao")
	private IConsultationInfoDao consultationInfoDao;
	
	@Resource(name = "observationInfoDao")
	private IObservationInfoDao observationInfoDao;
	
	@Resource(name = "healthExaminationDao")
	private IHealthExaminationDao healthExaminationDao;
	
	@Resource(name = "studyEventDao")
	private IStudyEventDao studyEventDao;
	
	@Resource(name = "examineEventDao")
	private IExamineEventDao examineEventDao;
	
	@Resource(name = "examineDetailDao")
	private IExamineDetailDao examineDetailDao;
	
	@Resource(name = "inpatientMedicalRecordDao")
	private IInpatientMedicalRecordDao inpatientMedicalRecordDao;
	
	@Resource(name = "outhospitalSummaryDao")
	private IOuthospitalSummaryDao outhospitalSummaryDao;
	
	@Resource(name = "transBloodInfoDao")
	private ITransBloodInfoDao transBloodInfoDao;
	
	private Properties properties =  PropertiesUtils.initProperties("idm");

	@Override
	public void run(Map<String, Object> data) {
		analyse();
	}

	@Override
	public void analyse() {

		final Criteria criteria = new Criteria(IS_LIMIT, OP.EQ, -1);//标志位为空还未处理
		
		PageableDateSource.execFirst(new IDataSource<DiseaseDiagnosisInfo>() {

			@Override
			public PageList<DiseaseDiagnosisInfo> get(Page page) {
				return diseaseDiagnosisInfoDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<DiseaseDiagnosisInfo> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (DiseaseDiagnosisInfo diseaseDiagnosisInfo : list) {
					if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo)) {
						continue;
					}
					boolean isLimit = isLimit(diseaseDiagnosisInfo);
					try {
						if (isLimit) {
							diseaseDiagnosisInfo.setIsLimit(FILTER_TRUE);
							ehrHealthEventDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							outpatientInfoDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							outpatientPrescriptionDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							inpatientInfoDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							studyEventDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							examineEventDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							examineDetailDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							expenseInfoDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							drugUsageDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							surgeryInfoDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							healthExaminationDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							referralInfoDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							consultationInfoDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							observationInfoDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							inpatientMedicalRecordDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							outhospitalSummaryDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
							transBloodInfoDao.update(new Parameters(IS_LIMIT, FILTER_TRUE), new Criteria(EHR_ID, diseaseDiagnosisInfo.getEhrId()));
						} else {
							diseaseDiagnosisInfo.setIsLimit(FILTER_FALSE);
						}
						diseaseDiagnosisInfoDao.update(diseaseDiagnosisInfo);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
			}
		});
	}
	
	/**
	 * 是否包含过滤的传染病
	 * @param diseaseDiagnosisInfo
	 * @return
	 */
	private boolean isLimit(DiseaseDiagnosisInfo diseaseDiagnosisInfo) {
		if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo)) {
			return false;
		}
	
		if (ObjectUtil.isNullOrEmpty(properties) || properties.isEmpty()) {
			return false;
		}

		String[] codes = StringUtils.split(properties.getProperty("idm.code.filter"), ",");
		String[] names = StringUtils.split(properties.getProperty("idm.name.filter"), ",");
		if (ObjectUtil.isNullOrEmpty(codes) && ObjectUtil.isNullOrEmpty(names)) {
			return false;
		}
		boolean isLimit = false;
		// 诊断编码
		if (ObjectUtil.isNotEmpty(diseaseDiagnosisInfo.getDiagnosisCode())) {
			for (String code : codes) {
				if (StringUtils.startsWith(diseaseDiagnosisInfo.getDiagnosisCode(), code)) {
					isLimit = true;
					break;
				}
			}
		} else { // 诊断名称
			for (String name : names) {
				if (StringUtils.contains(diseaseDiagnosisInfo.getDiagnosisDesc(), name)) {
					isLimit = true;
					break;
				}
			}
		}
		return isLimit;
	}
}
