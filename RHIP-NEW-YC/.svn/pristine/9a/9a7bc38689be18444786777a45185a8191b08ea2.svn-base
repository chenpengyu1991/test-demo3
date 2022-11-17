
package com.founder.rhip.ehr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.dto.HisWebServiceDto;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.InpatientInfo;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.entity.clinic.SurgeryInfo;
import com.founder.rhip.ehr.entity.clinic.TransBloodInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.rhip.ehr.entity.summary.DrugAllergyHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.ehr.entity.summary.SurgeryHistory;
import com.founder.rhip.ehr.entity.summary.TransBloodHistory;
import com.founder.rhip.ehr.entity.women.BirthControlService;
import com.founder.rhip.ehr.entity.women.MotherhoodPeriodFollowup;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IDiseaseDiagnosisInfoDao;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.ISurgeryInfoDao;
import com.founder.rhip.ehr.repository.clinic.ITransBloodInfoDao;
import com.founder.rhip.ehr.repository.control.IVaccinationMgmtDao;
import com.founder.rhip.ehr.repository.summary.IDiseaseHistoryDao;
import com.founder.rhip.ehr.repository.summary.IDrugAllergyHistoryDao;
import com.founder.rhip.ehr.repository.summary.IHospitalizedHistoryDao;
import com.founder.rhip.ehr.repository.summary.ISurgeryHistoryDao;
import com.founder.rhip.ehr.repository.summary.ITransBloodHistoryDao;
import com.founder.rhip.ehr.repository.women.IBirthControlServiceDao;
import com.founder.rhip.ehr.repository.women.IMotherhoodPeriodFollowupDao;
import com.founder.rhip.ehr.service.util.ValidateUtil;
import com.founder.rhip.ehr.service.util.XmlWebserviceForUtil;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("pastHistoryAnalyzeService")
@TaskBean(cron = "0 0 5 * * ?", description = "既往史定时任务")
public class PastHistoryAnalyzeServiceImpl extends AbstractService implements
		IPastHistoryAnalyzeService, Task {

	private static final String IS_ANALYSE = "isAnalyse";

	@Resource(name = "diseaseDiagnosisInfoDao")
	private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "diseaseHistoryDao")
	private IDiseaseHistoryDao diseaseHistoryDao;

	@Resource(name = "inpatientInfoDao")
	private IInpatientInfoDao inpatientInfoDao;

	@Resource(name = "hospitalizedHistoryDao")
	private IHospitalizedHistoryDao hospitalizedHistoryDao;

	@Resource(name = "surgeryInfoDao")
	private ISurgeryInfoDao surgeryInfoDao;

	@Resource(name = "surgeryHistoryDao")
	private ISurgeryHistoryDao surgeryHistoryDao;

	@Resource(name = "transBloodInfoDao")
	private ITransBloodInfoDao transBloodInfoDao;

	@Resource(name = "transBloodHistoryDao")
	private ITransBloodHistoryDao transBloodHistoryDao;

	@Resource(name = "drugAllergyHistoryDao")
	private IDrugAllergyHistoryDao drugAllergyHistoryDao;

	@Resource(name = "birthControlServiceDao")
	private IBirthControlServiceDao birthControlServiceDao;

	@Resource(name = "motherhoodPeriodFollowupDao")
	private IMotherhoodPeriodFollowupDao motherhoodPeriodFollowupDao;

	@Resource(name = "vaccinationMgmtDao")
	private IVaccinationMgmtDao vaccinationMgmtDao;

	@Resource(name = "ehrHealthEventDao")
	private IEHRHealthEventDao ehrHealthEventDao;
	
	@Override
	public void run(Map<String, Object> data) {
		Criteria criteria = new Criteria("isAnalyse", -1);
		// 疾病史
		analyzeDiseaseHistory(criteria);
		// 住院史
		analyzeHospitalizedHistory(criteria);
		// 手术史
		analyzeSurgeryHistory(criteria);
		// 输血史
		analyzeTransBloodHistory(criteria);
		// 过敏史
		analyzeDrugAllergyHistory(criteria);
	}

	@Override
	public void analyzeDiseaseHistory(final Criteria criteria) {
		// 分页处理
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
					PersonInfo personInfo = null;
					Long personId = null;
					if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo)) {
						continue;
					}
					if (ObjectUtil.isNullOrEmpty(personId = diseaseDiagnosisInfo.getPersonId()) || ObjectUtil.isNullOrEmpty(personInfo = personInfoDao.get(personId))
							|| ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo.getDiseaseCode()) || ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo.getEhrId())) {
						diseaseDiagnosisInfo.setIsAnalyse(1);
						continue;
					}
					DiseaseHistory diseaseHistory = new DiseaseHistory();
					diseaseHistory.setPersonId(personId);
					diseaseHistory.setIdcard(personInfo.getIdcard());
					diseaseHistory.setEhrId(diseaseDiagnosisInfo.getEhrId());
					diseaseHistory.setFormerlyType(diseaseDiagnosisInfo.getNlohmsiCode());
					diseaseHistory.setDiseaseCode(diseaseDiagnosisInfo.getDiseaseCode());
					diseaseHistory.setDiseaseName(diseaseDiagnosisInfo.getDiagnosisDesc());
					Date d = diseaseDiagnosisInfo.getDiagnoseDate();
					if (ObjectUtil.isNullOrEmpty(d)) {
						EHRHealthEvent ehrHealthEvent = ehrHealthEventDao.get(new Criteria("ehrId", diseaseHistory.getEhrId()));
						if (ObjectUtil.isNotEmpty(ehrHealthEvent)) {
							d= ehrHealthEvent.getClinicDate();
						}
					}
					diseaseHistory.setConfirmationDate(d);
					diseaseHistory.setInputName(personInfo.getInputName());
					diseaseHistory.setInputIdcard(personInfo.getIdcard());
					diseaseHistory.setInputOrganCode(personInfo.getInputOrganCode());
					diseaseHistory.setInputOrganName(personInfo.getInputOrganName());
					diseaseHistory.setInputDate(personInfo.getInputDate());
					DiseaseHistory dh = diseaseHistoryDao.get(new Criteria("personId", personId).add("diseaseCode", diseaseDiagnosisInfo.getDiseaseCode()));
					try {
						if (ObjectUtil.isNotEmpty(diseaseHistory.getDiseaseName()) && ObjectUtil.isNullOrEmpty(dh)) {
							diseaseHistoryDao.insert(diseaseHistory);
						}
						diseaseDiagnosisInfo.setIsAnalyse(1);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
				diseaseDiagnosisInfoDao.batchUpdate(list, IS_ANALYSE);
			}
		});
	}

	@Override
	public void analyzeSurgeryHistory(final Criteria criteria) {
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<SurgeryInfo>() {

			@Override
			public PageList<SurgeryInfo> get(Page page) {
				return surgeryInfoDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<SurgeryInfo> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (SurgeryInfo surgeryInfo : list) {
					Long personId = null;
					PersonInfo personInfo = null;
					if (ObjectUtil.isNullOrEmpty(surgeryInfo)) {
						continue;
					}
					if (ObjectUtil.isNullOrEmpty(personId = surgeryInfo.getPersonId()) || ObjectUtil.isNullOrEmpty(personInfo = personInfoDao.get(personId))
							||ObjectUtil.isNullOrEmpty(surgeryInfo.getEhrId()) || ObjectUtil.isNullOrEmpty(surgeryInfo.getOpertationName())) {
						// 更新状态
						surgeryInfo.setIsAnalyse(1);
						continue;
					}
					SurgeryHistory surgeryHistory = new SurgeryHistory();
					surgeryHistory.setPersonId(personId);
					surgeryHistory.setEhrId(surgeryInfo.getEhrId());
					surgeryHistory.setIdcard(personInfo.getIdcard());
					surgeryHistory.setHosName(surgeryInfo.getHospitalName());
					surgeryHistory.setInputDate(personInfo.getInputDate());
					surgeryHistory.setInputIdcard(personInfo.getInputIdcard());
					surgeryHistory.setInputName(personInfo.getInputName());
					surgeryHistory.setInputOrganCode(personInfo.getInputOrganCode());
					surgeryHistory.setInputOrganName(personInfo.getInputOrganName());
					surgeryHistory.setOperationCode(surgeryInfo.getOpertationCode());
					Date d = surgeryInfo.getOpertationDate();
					if (ObjectUtil.isNullOrEmpty(d)) {
						EHRHealthEvent ehrHealthEvent = ehrHealthEventDao.get(new Criteria("ehrId", surgeryInfo.getEhrId()));
						if (ObjectUtil.isNotEmpty(ehrHealthEvent)) {
							d = ehrHealthEvent.getClinicDate();
						}
					}
					surgeryHistory.setOpsDate(d);
					surgeryHistory.setOpsName(surgeryInfo.getOpertationName());
					try {
						if (ObjectUtil.isNotEmpty(surgeryHistory.getOpsName()) || ObjectUtil.isNotEmpty(surgeryHistory.getOperationCode())) {
							surgeryHistoryDao.insert(surgeryHistory);
						}
						// 更新状态
						surgeryInfo.setIsAnalyse(1);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
				surgeryInfoDao.batchUpdate(list, IS_ANALYSE);
			}
			
		});
	}

	@Override
	public void analyzeHospitalizedHistory(final Criteria criteria) {
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<InpatientInfo>() {

			@Override
			public PageList<InpatientInfo> get(Page page) {
				return inpatientInfoDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<InpatientInfo> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (InpatientInfo inpatientInfo : list) {
					Long personId = null;
					PersonInfo personInfo = null;
					if (ObjectUtil.isNullOrEmpty(inpatientInfo)) {
						continue;
					}
					if (ObjectUtil.isNullOrEmpty(personId = inpatientInfo.getPersonId()) || ObjectUtil.isNullOrEmpty(personInfo = personInfoDao.get(personId))
							|| ObjectUtil.isNullOrEmpty(inpatientInfo.getEhrId())) {
						// 更新状态
						inpatientInfo.setIsAnalyse(1);
						continue;
					}
					HospitalizedHistory hospitalizedHistory = new HospitalizedHistory();
					hospitalizedHistory.setPersonId(personId);
					hospitalizedHistory.setEhrId(inpatientInfo.getEhrId());
					hospitalizedHistory.setIdcard(personInfo.getIdcard());
					hospitalizedHistory.setHosName(inpatientInfo.getReferralHospitalName());
					hospitalizedHistory.setInDate(inpatientInfo.getInhosDate());
					hospitalizedHistory.setInhosDays(inpatientInfo.getInhosDays());
					hospitalizedHistory.setInhosReason(inpatientInfo.getInhosReason());
					hospitalizedHistory.setInputDate(personInfo.getInputDate());
					hospitalizedHistory.setInputIdcard(personInfo.getInputIdcard());
					hospitalizedHistory.setInputName(personInfo.getInputName());
					hospitalizedHistory.setInputOrganCode(personInfo.getInputOrganCode());
					hospitalizedHistory.setInputOrganName(personInfo.getInputOrganName());
					hospitalizedHistory.setMedicalRecordNo(inpatientInfo.getMedicalRecordNo());
					hospitalizedHistory.setOuthosDate(inpatientInfo.getOutHospitalDate());
					try {
						hospitalizedHistoryDao.insert(hospitalizedHistory);
						// 更新状态
						inpatientInfo.setIsAnalyse(1);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
				inpatientInfoDao.batchUpdate(list, IS_ANALYSE);
			}
		});
	}

	@Override
	public void analyzeTransBloodHistory(final Criteria criteria) {
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<TransBloodInfo>() {

			@Override
			public PageList<TransBloodInfo> get(Page page) {
				return transBloodInfoDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<TransBloodInfo> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (TransBloodInfo transBloodInfo : list) {
					Long personId = null;
					PersonInfo personInfo = null;
					if (ObjectUtil.isNullOrEmpty(transBloodInfo)) {
						continue;
					}
					if (ObjectUtil.isNullOrEmpty(personId = transBloodInfo.getPersonId()) || ObjectUtil.isNullOrEmpty(personInfo = personInfoDao.get(personId))
							|| ObjectUtil.isNullOrEmpty(transBloodInfo.getEhrId())) {
						// 更新状态
						transBloodInfo.setIsAnalyse(1);
						continue;
					}
					TransBloodHistory bloodHistory = new TransBloodHistory();
					bloodHistory.setPersonId(personId);
					bloodHistory.setIdcard(personInfo.getIdcard());
					Date d = transBloodInfo.getBloodDate();
					if (ObjectUtil.isNullOrEmpty(d)) {
						EHRHealthEvent ehrHealthEvent = ehrHealthEventDao.get(new Criteria("ehrId", transBloodInfo.getEhrId()));
						if (ObjectUtil.isNotEmpty(ehrHealthEvent)) {
							d = ehrHealthEvent.getClinicDate();
						}
					}
					bloodHistory.setBloodDate(d);
					bloodHistory.setBloodNum(ObjectUtil.isNullOrEmpty(transBloodInfo
							.getBloodQuantity()) ? null : transBloodInfo.getBloodQuantity()
							.intValue());
					bloodHistory.setBloodReason(transBloodInfo.getBloodReason());
					bloodHistory.setBloodType(transBloodInfo.getBloodTypeCode());
					bloodHistory.setBloodTypeName(transBloodInfo.getBloodTypeName());
					bloodHistory.setBloodUnit(transBloodInfo.getBloodOrganName());
					bloodHistory.setEhrId(transBloodInfo.getEhrId());
					try {
						if (ObjectUtil.isNotEmpty(bloodHistory.getBloodTypeName())) {
							transBloodHistoryDao.insert(bloodHistory);
						}
						// 更新状态
						transBloodInfo.setIsAnalyse(1);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
				transBloodInfoDao.batchUpdate(list, IS_ANALYSE);
			}
		});
	}

	@Override
	public void analyzeDrugAllergyHistory(final Criteria criteria) {
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<BirthControlService>() {

			@Override
			public PageList<BirthControlService> get(Page page) {
				return birthControlServiceDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<BirthControlService> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (BirthControlService birthControlService : list) {
					Long personId = null;
					PersonInfo personInfo = null;
					if (ObjectUtil.isNullOrEmpty(birthControlService)) {
						continue;
					}
					if (ObjectUtil.isNullOrEmpty(personId = birthControlService.getPersonId())
							|| ObjectUtil.isNullOrEmpty(personInfo = personInfoDao.get(personId))) {
						// 更新状态位
						birthControlService.setIsAnalyse(1);
						continue;
					}
					DrugAllergyHistory allergyHistory = new DrugAllergyHistory();
					allergyHistory.setPersonId(personId);
					allergyHistory.setIdcard(personInfo.getIdcard());
					allergyHistory.setEhrId(birthControlService.getEhrId());
					allergyHistory.setAllergensName(birthControlService.getAllergicHistory());
					allergyHistory.setInputDate(personInfo.getInputDate());
					allergyHistory.setInputName(personInfo.getInputName());
					allergyHistory.setInputOrganCode(personInfo.getInputOrganCode());
					allergyHistory.setInputOrganName(personInfo.getInputOrganName());
					try {
						if (ObjectUtil.isNotEmpty(allergyHistory.getAllergensName())) {
							drugAllergyHistoryDao.insert(allergyHistory);
						}
						// 更新状态位
						birthControlService.setIsAnalyse(1);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
				birthControlServiceDao.batchUpdate(list, IS_ANALYSE);
			}
		});
		
		PageableDateSource.execFirst(new IDataSource<MotherhoodPeriodFollowup>() {

			@Override
			public PageList<MotherhoodPeriodFollowup> get(Page page) {
				return motherhoodPeriodFollowupDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<MotherhoodPeriodFollowup> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (MotherhoodPeriodFollowup motherhoodPeriodFollowup : list) {
					Long personId = null;
					PersonInfo personInfo = null;
					if (ObjectUtil.isNullOrEmpty(motherhoodPeriodFollowup)
							|| ObjectUtil.isNullOrEmpty(personId = motherhoodPeriodFollowup.getPersonId())
							|| ObjectUtil.isNullOrEmpty(personInfo = personInfoDao.get(personId))) {
						motherhoodPeriodFollowup.setIsAnalyse(1);
						continue;
					}
					DrugAllergyHistory allergyHistory = new DrugAllergyHistory();
					allergyHistory.setPersonId(personId);
					allergyHistory.setIdcard(personInfo.getIdcard());
					allergyHistory.setEhrId(motherhoodPeriodFollowup.getEhrId());
					allergyHistory.setAllergensName(motherhoodPeriodFollowup.getAllergicHistory());
					allergyHistory.setInputDate(personInfo.getInputDate());
					allergyHistory.setInputName(personInfo.getInputName());
					allergyHistory.setInputOrganCode(personInfo.getInputOrganCode());
					allergyHistory.setInputOrganName(personInfo.getInputOrganName());
					try {
						if (ObjectUtil.isNotEmpty(allergyHistory.getAllergensName())) {
							drugAllergyHistoryDao.insert(allergyHistory);
						}
						// 更新状态位
						motherhoodPeriodFollowup.setIsAnalyse(1);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
				motherhoodPeriodFollowupDao.batchUpdate(list, IS_ANALYSE);
			}
		});
		
		PageableDateSource.execFirst(new IDataSource<VaccinationMgmt>() {

			@Override
			public PageList<VaccinationMgmt> get(Page page) {
				return vaccinationMgmtDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<VaccinationMgmt> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (VaccinationMgmt vaccinationMgmt : list) {
					Long personId = null;
					PersonInfo personInfo = null;
					if (ObjectUtil.isNullOrEmpty(vaccinationMgmt) || ObjectUtil.isNullOrEmpty(personId = vaccinationMgmt.getPersonId())
							|| ObjectUtil.isNullOrEmpty(personInfo = personInfoDao.get(personId))) {
						vaccinationMgmt.setIsAnalyse(1);
						continue;
					}
					DrugAllergyHistory allergyHistory = new DrugAllergyHistory();
					allergyHistory.setPersonId(personId);
					allergyHistory.setIdcard(personInfo.getIdcard());
					allergyHistory.setEhrId(vaccinationMgmt.getEhrId());
					allergyHistory.setAllergensName(vaccinationMgmt.getAllergen());
					allergyHistory.setInputDate(personInfo.getInputDate());
					allergyHistory.setInputName(personInfo.getInputName());
					allergyHistory.setInputOrganCode(personInfo.getInputOrganCode());
					allergyHistory.setInputOrganName(personInfo.getInputOrganName());
					try {
						if (ObjectUtil.isNotEmpty(allergyHistory.getAllergensName())) {
							drugAllergyHistoryDao.insert(allergyHistory);
						}
						// 更新状态位
						vaccinationMgmt.setIsAnalyse(1);
					} catch (Exception e) {
						log.error(e.getMessage(), e);
					}
				}
				vaccinationMgmtDao.batchUpdate(list, IS_ANALYSE);
			}
		});
	}

	@Override
	public String getAnalyse(HisWebServiceDto hisWebServiceDto) {
		String validateString = ValidateUtil.doValidate(hisWebServiceDto, "idcard");
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		
		if( ObjectUtil.isNullOrEmpty(hisWebServiceDto.getIdcard())){
			return XmlWebserviceForUtil.returnError("身份证编码不能为空");
		}
		PersonInfo personInfo = personInfoDao.get(new Criteria("IDCARD", hisWebServiceDto.getIdcard()));
		if(ObjectUtil.isNullOrEmpty(personInfo)) {
			return XmlWebserviceForUtil.getString("0",String.class);
		}
		BirthControlService birthControlService = birthControlServiceDao.get(new Criteria("EHR_ID", personInfo.getId()));
		if(ObjectUtil.isNotEmpty(birthControlService)) {
			return XmlWebserviceForUtil.getString(birthControlService.getAllergicHistory(),String.class);
		}
		return XmlWebserviceForUtil.getString("",String.class);
	}
}
