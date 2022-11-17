package com.founder.rhip.ehr.service.report;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpOutpatient;
import com.founder.rhip.ehr.repository.clinic.IExpenseInfoDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientPrescriptionDao;
import com.founder.rhip.ehr.repository.clinic.IRegisterRecordDao;
import com.founder.rhip.ehr.repository.report.IRpOutpatientDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IStaffService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpOutpatientService")
@TaskBean(cron = "0 0 4 * * ?", description = "门急诊挂号定时任务")
public class RpOutpatientServiceImpl extends RpBaseService implements IRpOutpatientService, Task {
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "rpOutpatientDao")
	private IRpOutpatientDao rpOutpatientDao;
	
	@Resource(name = "registerRecordDao")
	private IRegisterRecordDao registerRecordDao;
	
	@Resource(name = "outpatientPrescriptionDao")
	private IOutpatientPrescriptionDao outpatientPrescriptionDao;
	
	@Resource(name = "outpatientInfoDao")
	private IOutpatientInfoDao outpatientInfoDao;
	
    @Autowired
	private IDictionaryApp dictionaryApp;
    
    @Resource(name = "mdmStaffService")
    private IStaffService mdmStaffService;
    
	@Resource(name = "expenseInfoDao")
	private IExpenseInfoDao expenseInfoDao;
	
	@Override
	public void saveOutpatientStatistics(String dateStr) {
		
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			Date date = DateUtil.getBeforeDay(new Date(), 1);
			dateStr = DateUtil.convertDateToString(date);
		}
		// 各机构下面医务人员数量
		Map<String,Long> staffCountMap = mdmStaffService.getStaffNumByOrg(null);
		// 挂号就诊统计
		List<Map<String, Object>> registerMapList = registerRecordDao.getRegisterStatistics(dateStr);
		if (ObjectUtil.isNotEmpty(registerMapList)) {
			for (Map<String, Object> map : registerMapList) {
				Object orgCode = null;
				Object vt = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(orgCode = map.get("CODE")) || ObjectUtil.isNullOrEmpty(vt = map.get("VT"))) {
					continue;
				}
				Map<String, Object> m = rpOutpatientDao.getRpOutpatientMap(String.valueOf(orgCode), String.valueOf(vt));
				if (ObjectUtil.isNullOrEmpty(m)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(orgCode));
					if (ObjectUtil.isNullOrEmpty(organization)) {
						continue;
					}
					RpOutpatient rpOutpatient = new RpOutpatient();
					rpOutpatient.setGbCode(organization.getGbCode());
					rpOutpatient.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
					rpOutpatient.setOrganCode(organization.getOrganCode());
					rpOutpatient.setOrganType(organization.getGenreCode());
					rpOutpatient.setRegisterNum(ObjectUtil.isNullOrEmpty(map.get("N3")) ? 0 : Long.valueOf(String.valueOf(map.get("N3")))); // 挂号人次数
					rpOutpatient.setTreatmentNum(ObjectUtil.isNullOrEmpty(map.get("N1")) ? 0 : Long.valueOf(String.valueOf(map.get("N1")))); // 就诊人次数
					rpOutpatient.setDoctorNum(staffCountMap.get(String.valueOf(orgCode))); // 医技人员数量
					rpOutpatient.setRpDate(DateUtil.parseDateString(String.valueOf(vt)));
					rpOutpatientDao.insert(rpOutpatient);
				} else {
					Parameters parameters = new Parameters();
					parameters.add("registerNum", ObjectUtil.isNullOrEmpty(map.get("N3")) ? 0 : Long.valueOf(String.valueOf(map.get("N3")))); // 挂号人次数
					parameters.add("treatmentNum", ObjectUtil.isNullOrEmpty(map.get("N1")) ? 0 : Long.valueOf(String.valueOf(map.get("N1")))); // 就诊人次数
					parameters.add("doctorNum", staffCountMap.get(String.valueOf(orgCode)));
					rpOutpatientDao.update(parameters, new Criteria("id", m.get("ID")));
				}
			}
		}
		// 门诊摘要统计
		List<Map<String, Object>> outpatientMapList = outpatientInfoDao.getOutpatientStatistics(dateStr, false);
		if (ObjectUtil.isNotEmpty(outpatientMapList)) {
			for (Map<String, Object> map : outpatientMapList) {
				Object orgCode = null;
				Object dt = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(orgCode = map.get("CODE")) || ObjectUtil.isNullOrEmpty(dt = map.get("DT"))) {
					continue;
				}
				Map<String, Object> m = rpOutpatientDao.getRpOutpatientMap(String.valueOf(orgCode), String.valueOf(dt));
				if (ObjectUtil.isNullOrEmpty(m)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(orgCode));
					if (ObjectUtil.isNullOrEmpty(organization)) {
						continue;
					}
					RpOutpatient rpOutpatient = new RpOutpatient();
					rpOutpatient.setGbCode(organization.getGbCode());
					rpOutpatient.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
					rpOutpatient.setOrganCode(organization.getOrganCode());
					rpOutpatient.setOrganType(organization.getGenreCode());
					rpOutpatient.setStayNum(ObjectUtil.isNullOrEmpty(map.get("N5")) ? 0 : Long.valueOf(String.valueOf(map.get("N5")))); // 留观人次数
					rpOutpatient.setMedicalFee((ObjectUtil.isNullOrEmpty(map.get("N1")) 
							|| (!NumberUtil.isInteger(String.valueOf(map.get("N1"))) && !NumberUtil.isDecimal(String.valueOf(map.get("N1"))))) ? null
							: new BigDecimal(String.valueOf(map.get("N1")))); // 医疗保险金额
					rpOutpatient.setCooperativeMedicalFee((ObjectUtil.isNullOrEmpty(map.get("N2")) 
							|| (!NumberUtil.isInteger(String.valueOf(map.get("N2"))) && !NumberUtil.isDecimal(String.valueOf(map.get("N2"))))) ? null
							: new BigDecimal(String.valueOf(map.get("N2")))); // 新农合支付金额

					rpOutpatient.setPersonalFee((ObjectUtil.isNullOrEmpty(map.get("N3")) 
									|| (!NumberUtil.isInteger(String.valueOf(map.get("N3"))) && !NumberUtil.isDecimal(String.valueOf(map.get("N3"))))) ? null
									: new BigDecimal(String.valueOf(map.get("N3")))); // 个人支付费用
					rpOutpatient.setFeeTotal((ObjectUtil.isNullOrEmpty(map.get("N4")) 
							|| (!NumberUtil.isInteger(String.valueOf(map.get("N4"))) && !NumberUtil.isDecimal(String.valueOf(map.get("N4"))))) ? null
							: new BigDecimal(String.valueOf(map.get("N4")))); // 合计费用
					rpOutpatient.setRpDate(DateUtil.parseDateString(String.valueOf(dt)));
					rpOutpatientDao.insert(rpOutpatient);
				} else {
					Parameters parameters = new Parameters();
					parameters.add("stayNum", ObjectUtil.isNullOrEmpty(map.get("N5")) ? 0 : Long.valueOf(String.valueOf(map.get("N5"))));
					parameters.add("medicalFee", (ObjectUtil.isNullOrEmpty(map.get("N1")) 
							|| (!NumberUtil.isInteger(String.valueOf(map.get("N1"))) && !NumberUtil.isDecimal(String.valueOf(map.get("N1"))))) ? null
							: new BigDecimal(String.valueOf(map.get("N1"))));
					parameters.add("cooperativeMedicalFee", (ObjectUtil.isNullOrEmpty(map.get("N2")) 
							|| (!NumberUtil.isInteger(String.valueOf(map.get("N2"))) && !NumberUtil.isDecimal(String.valueOf(map.get("N2"))))) ? null
							: new BigDecimal(String.valueOf(map.get("N2"))));
					parameters.add("personalFee", (ObjectUtil.isNullOrEmpty(map.get("N3")) 
							|| (!NumberUtil.isInteger(String.valueOf(map.get("N3"))) && !NumberUtil.isDecimal(String.valueOf(map.get("N3"))))) ? null
							: new BigDecimal(String.valueOf(map.get("N3"))));
					parameters.add("feeTotal", (ObjectUtil.isNullOrEmpty(map.get("N4")) 
							|| (!NumberUtil.isInteger(String.valueOf(map.get("N4"))) && !NumberUtil.isDecimal(String.valueOf(map.get("N4"))))) ? null
							: new BigDecimal(String.valueOf(map.get("N4"))));
					rpOutpatientDao.update(parameters, new Criteria("id", m.get("ID")));
				}
			}
		}
		// 门诊处方统计
		List<Map<String, Object>> prescriptionMapList = outpatientPrescriptionDao.getPrescriptionStatistics(dateStr);
		if (ObjectUtil.isNotEmpty(prescriptionMapList)) {
			for (Map<String, Object> map : prescriptionMapList) {
				Object orgCode = null;
				Object dt = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(orgCode = map.get("CODE")) || ObjectUtil.isNullOrEmpty(dt = map.get("DT"))) {
					continue;
				}
				Map<String, Object> m = rpOutpatientDao.getRpOutpatientMap(String.valueOf(orgCode), String.valueOf(dt));
				if (ObjectUtil.isNullOrEmpty(m)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(orgCode));
					if (ObjectUtil.isNullOrEmpty(organization)) {
						continue;
					}
					RpOutpatient rpOutpatient = new RpOutpatient();
					rpOutpatient.setGbCode(organization.getGbCode());
					rpOutpatient.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
					rpOutpatient.setOrganCode(organization.getOrganCode());
					rpOutpatient.setOrganType(organization.getGenreCode());
					rpOutpatient.setPrescriptionNumm(ObjectUtil.isNullOrEmpty(map.get("N4")) ? 0 : Long.valueOf(String.valueOf(map.get("N4")))); // 处方数
					rpOutpatient.setFeePrescriptionNum(ObjectUtil.isNullOrEmpty(map.get("N1")) ? 0 : Long.valueOf(String.valueOf(map.get("N1")))); // 收费处方数
					rpOutpatient.setAntibacterialPrescriptionNum(ObjectUtil.isNullOrEmpty(map.get("N3")) ? null : Long.valueOf(String.valueOf(map.get("N3")))); // 抗菌处方数
					rpOutpatient.setRpDate(DateUtil.parseDateString(String.valueOf(dt)));
					rpOutpatientDao.insert(rpOutpatient);
				} else {
					Parameters parameters = new Parameters();
					parameters.add("prescriptionNumm", ObjectUtil.isNullOrEmpty(map.get("N4")) ? 0 : Long.valueOf(String.valueOf(map.get("N4"))));
					parameters.add("feePrescriptionNum", ObjectUtil.isNullOrEmpty(map.get("N1")) ? 0 : Long.valueOf(String.valueOf(map.get("N1"))));
					parameters.add("antibacterialPrescriptionNum", ObjectUtil.isNullOrEmpty(map.get("N3")) ? 0 : Long.valueOf(String.valueOf(map.get("N3"))));
					rpOutpatientDao.update(parameters, new Criteria("id", m.get("ID")));
				}
			}
		}


	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		saveOutpatientStatistics(dateStr);
		
	}

	@Override
	public List<Map<String, Object>> getRpoutpatientMapList(Map<String, String> paramMap) {

		List<Map<String, Object>> mapList = rpOutpatientDao.getRpoutpatientMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
		return destMapList;
	}

	/**
	 * 综合管理首页住院统计(门急诊)
	 * @param criteria
	 * @return
	 */
	@Override
	public Map<String, Object> statisticsFeeOutpatient(String dateStr, String dateFormater){
		return rpOutpatientDao.statisticsFeeOutpatient(dateStr, dateFormater);
	}
	 
	/**
	 * 门急诊服务绩效考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getOutpatientPerformanceOrg(Map<String, String> paramMap) {
		return rpOutpatientDao.getOutpatientPerformanceOrg(paramMap);
	}
}
