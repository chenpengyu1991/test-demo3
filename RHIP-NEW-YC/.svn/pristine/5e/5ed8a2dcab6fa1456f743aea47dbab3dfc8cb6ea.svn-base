package com.founder.rhip.ehr.service.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpExpense;
import com.founder.rhip.ehr.repository.clinic.IExpenseInfoDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientInfoDao;
import com.founder.rhip.ehr.repository.report.IRpExpenseDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IStaffService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service("rpExpenseService")
@TaskBean(cron = "0 0 5 * * ?", description = "医疗费用定时任务")
public class RpExpenseServiceImpl extends RpBaseService implements IRpExpenseService,Task {
	
	@Resource(name = "expenseInfoDao")
	private IExpenseInfoDao expenseInfoDao;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
    @Autowired
	private IDictionaryApp dictionaryApp;
    
    @Resource(name = "mdmStaffService")
    private IStaffService mdmStaffService;
    
    @Resource(name = "rpExpenseDao")
    private IRpExpenseDao rpExpenseDao;
    
    @Resource(name = "outpatientInfoDao")
    private IOutpatientInfoDao outpatientInfoDao;
    
    @Resource(name = "inpatientInfoDao")
    private IInpatientInfoDao inpatientInfoDao;

    @Override
    public void saveExpenseStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
		// 获取各机构医务人员数量
		Map<String,Long> staffCountMap = mdmStaffService.getStaffNumByOrg(null);
		// 各类医疗费用统计
    	List<Map<String, Object>> mapList = expenseInfoDao.getExpenseMapList(dateStr);

    	if (ObjectUtil.isNotEmpty(mapList)) {
    		for (Map<String, Object> map : mapList) {
    			Object organCode = null;
    			Object rpDate = null;
    			Object rpType = null;
    			if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))
    					|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
    					|| ObjectUtil.isNullOrEmpty(rpType = map.get("rpType"))) {
    				continue;
    			}
    			BigDecimal chineseMedicineFee = (ObjectUtil.isNullOrEmpty(map.get("chineseMedicineFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("chineseMedicineFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("chineseMedicineFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("chineseMedicineFee"))));
    			BigDecimal medicineFee = (ObjectUtil.isNullOrEmpty(map.get("medicineFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("medicineFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("medicineFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("medicineFee"))));
    			BigDecimal westernMedicineFee = (ObjectUtil.isNullOrEmpty(map.get("westernMedicineFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("westernMedicineFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("westernMedicineFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("westernMedicineFee"))));
    			BigDecimal inspectingFee = (ObjectUtil.isNullOrEmpty(map.get("inspectingFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("inspectingFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("inspectingFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("inspectingFee"))));
    			BigDecimal inspectionFee = (ObjectUtil.isNullOrEmpty(map.get("inspectionFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("inspectionFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("inspectionFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("inspectionFee"))));
    			BigDecimal laboratoryFee = (ObjectUtil.isNullOrEmpty(map.get("laboratoryFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("laboratoryFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("laboratoryFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("laboratoryFee"))));
    			BigDecimal radiationFee = (ObjectUtil.isNullOrEmpty(map.get("radiationFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("radiationFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("radiationFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("radiationFee"))));
    			BigDecimal treatmentFee = (ObjectUtil.isNullOrEmpty(map.get("treatmentFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("treatmentFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("treatmentFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("treatmentFee"))));
    			BigDecimal operationFee = (ObjectUtil.isNullOrEmpty(map.get("operationFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("operationFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("operationFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("operationFee"))));
    			BigDecimal bloodFee = (ObjectUtil.isNullOrEmpty(map.get("bloodFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("bloodFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("bloodFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("bloodFee"))));
    			BigDecimal bedFee = (ObjectUtil.isNullOrEmpty(map.get("bedFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("bedFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("bedFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("bedFee"))));
    			BigDecimal nursingFee = (ObjectUtil.isNullOrEmpty(map.get("nursingFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("nursingFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("nursingFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("nursingFee"))));
    			BigDecimal anesthesiaFee = (ObjectUtil.isNullOrEmpty(map.get("anesthesiaFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("anesthesiaFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("anesthesiaFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("anesthesiaFee"))));
    			BigDecimal otherFee = (ObjectUtil.isNullOrEmpty(map.get("otherFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("otherFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("otherFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("otherFee"))));
    			BigDecimal consumablesFee = (ObjectUtil.isNullOrEmpty(map.get("consumablesFee"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("consumablesFee"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("consumablesFee"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("consumablesFee"))));
    			
    			//Long rpPersonNum = (ObjectUtil.isNullOrEmpty(map.get("countEhrId"))) ? 0 : Long.valueOf(String.valueOf(map.get("countEhrId")));						
    			
    			RpExpense rpe = getRpExpense(String.valueOf(organCode), String.valueOf(rpType), String.valueOf(rpDate));
    			if (ObjectUtil.isNullOrEmpty(rpe)) {
    				Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
    				RpExpense rpExpense = new RpExpense();
    				rpExpense.setGbCode(organization.getGbCode());
    				rpExpense.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
    				rpExpense.setOrganCode(organization.getOrganCode());
    				rpExpense.setOrganType(organization.getGenreCode());
    				rpExpense.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
    				rpExpense.setRpType(String.valueOf(map.get("rpType")));
    				rpExpense.setChineseMedicineFee(chineseMedicineFee);
    				rpExpense.setMedicineFee(medicineFee);
    				rpExpense.setWesternMedicineFee(westernMedicineFee);
    				rpExpense.setInspectingFee(inspectingFee);
    				rpExpense.setInspectionFee(inspectionFee);
    				rpExpense.setLaboratoryFee(laboratoryFee);
    				rpExpense.setRadiationFee(radiationFee);
    				rpExpense.setTreatmentFee(treatmentFee);
    				rpExpense.setOperationFee(operationFee);
    				rpExpense.setBloodFee(bloodFee);
    				rpExpense.setBedFee(bedFee);
    				rpExpense.setNursingFee(nursingFee);
    				rpExpense.setAnesthesiaFee(anesthesiaFee);
    				rpExpense.setOtherFee(otherFee);
    				rpExpense.setConsumablesFee(consumablesFee);
    				rpExpense.setDoctorNum(staffCountMap.get(organization.getOrganCode()));
    				//rpExpense.setRpPersonNum(rpPersonNum);
    				rpExpenseDao.insert(rpExpense);
    			} else {
    				rpe.setChineseMedicineFee(chineseMedicineFee);
    				rpe.setMedicineFee(medicineFee);
    				rpe.setWesternMedicineFee(westernMedicineFee);
    				rpe.setInspectingFee(inspectingFee);
    				rpe.setInspectionFee(inspectionFee);
    				rpe.setLaboratoryFee(laboratoryFee);
    				rpe.setRadiationFee(radiationFee);
    				rpe.setTreatmentFee(treatmentFee);
    				rpe.setOperationFee(operationFee);
    				rpe.setBloodFee(bloodFee);
    				rpe.setBedFee(bedFee);
    				rpe.setNursingFee(nursingFee);
    				rpe.setAnesthesiaFee(anesthesiaFee);
    				rpe.setOtherFee(otherFee);
    				rpe.setConsumablesFee(consumablesFee);
    				rpe.setDoctorNum(staffCountMap.get(String.valueOf(organCode)));
    				//rpe.setRpPersonNum(rpPersonNum);
    				rpExpenseDao.update(rpe);
    			}
			
    		}
			
		}
    	// 门诊总费用
    	List<Map<String, Object>> outpatientMapList = outpatientInfoDao.getOutpatientStatistics(dateStr, true);
    	
    	if (ObjectUtil.isNotEmpty(outpatientMapList)) {
			for (Map<String, Object> map : outpatientMapList) {
				Object organCode = null;
    			Object rpDate = null;
    			Object rpType = null;
    			if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("CODE"))
    					|| ObjectUtil.isNullOrEmpty(rpDate = map.get("dt"))
    					|| ObjectUtil.isNullOrEmpty(rpType = map.get("OUTPATIENT_TYPE"))) {
    				continue;
    			}
    			
    			BigDecimal feeTotal = (ObjectUtil.isNullOrEmpty(map.get("N4"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("N4"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("N4"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("N4"))));
    			Long rpPersonNum = (ObjectUtil.isNullOrEmpty(map.get("countEhrId"))) ? 0 : Long.valueOf(String.valueOf(map.get("countEhrId")));
    			saveOrUpdateRpExpense(String.valueOf(organCode), String.valueOf(rpType), String.valueOf(rpDate), feeTotal, rpPersonNum, staffCountMap);
			}
		}
    	
    	// 住院总费用
    	List<Map<String, Object>> inpatientMapList = inpatientInfoDao.getInpatientInfoStatistics(dateStr);
    	if (ObjectUtil.isNotEmpty(inpatientMapList)) {
			for (Map<String, Object> map : inpatientMapList) {
				Object organCode = null;
    			Object rpDate = null;
    			if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("referral_hospital_code"))
    					|| ObjectUtil.isNullOrEmpty(rpDate = map.get("out_hospital_date"))) {
    				continue;
    			}
    			BigDecimal feeTotal = (ObjectUtil.isNullOrEmpty(map.get("inhos_cost_sum"))
    					|| (!NumberUtil.isInteger(String.valueOf(map.get("inhos_cost_sum"))) 
    							&& !NumberUtil.isDecimal(String.valueOf(map.get("inhos_cost_sum"))))) ? null
    									: new BigDecimal(String.valueOf(String.valueOf(map.get("inhos_cost_sum"))));
    			Long rpPersonNum = (ObjectUtil.isNullOrEmpty(map.get("countEhrId"))) ? 0 : Long.valueOf(String.valueOf(map.get("countEhrId")));
    			saveOrUpdateRpExpense(String.valueOf(organCode), "3", String.valueOf(rpDate), feeTotal,rpPersonNum, staffCountMap);
			}
		}
    }

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		saveExpenseStatistics(dateStr);
	}

	@Override
	public List<Map<String, Object>> getRpExpenseMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = rpExpenseDao.getRpExpenseMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
		return destMapList;
	}
	
	@Override
	public List<Map<String, Object>> getBurdenRpExpenseMapList(Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = rpExpenseDao.getBurdenRpExpenseMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
		return destMapList;
	}

	/**
	 * 查询费用报表中存在的记录
	 * @param organCode 机构编码
	 * @param rpType 报表类型（门诊、急诊、住院）
	 * @param rpDate 报表统计日期
	 * @return
	 */
	private RpExpense getRpExpense(String organCode, String rpType, String rpDate) {
		Criteria criteria = new Criteria();
		if (ObjectUtil.isNotEmpty(organCode)) {
			criteria.add("organCode", organCode);
		}
		if (ObjectUtil.isNotEmpty(rpType)) {
			criteria.add("rpType", rpType);
		}
		if (ObjectUtil.isNotEmpty(rpDate)) {
			DateUtil.getCriteriaByDateRange(criteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
		}
		RpExpense rpe = rpExpenseDao.get(criteria);
		return rpe;
	}
	
	/**
	 * 保存或者更新费用报表记录
	 * @param organCode 机构编码
	 * @param rpType 报表类型（门诊、急诊、住院）
	 * @param rpDate 报表统计日期
	 * @param feeTotal 门诊或者住院总费用
	 * @param staffCountMap
	 */
	private void saveOrUpdateRpExpense(String organCode, String rpType, String rpDate, BigDecimal feeTotal, Long rpPersonNum,Map<String,Long> staffCountMap) {
		if (ObjectUtil.isNullOrEmpty(organCode)
				|| ObjectUtil.isNullOrEmpty(rpType)
				|| ObjectUtil.isNullOrEmpty(rpDate)
				|| ObjectUtil.isNullOrEmpty(feeTotal)) {
			return;
		}
		RpExpense rpe = getRpExpense(organCode, rpType, rpDate);
		if (ObjectUtil.isNullOrEmpty(rpe)) {
			RpExpense rpExpense = new RpExpense();
			Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
			rpExpense.setGbCode(organization.getGbCode());
			rpExpense.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
			rpExpense.setOrganCode(organization.getOrganCode());
			rpExpense.setOrganType(organization.getGenreCode());
			rpExpense.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
			rpExpense.setRpType(rpType);
			rpExpense.setFeeTotal(feeTotal);
			rpExpense.setDoctorNum(staffCountMap.get(organization.getOrganCode()));
			rpExpense.setRpPersonNum(rpPersonNum);
			rpExpenseDao.insert(rpExpense);
		} else {
			Parameters parameters = new Parameters("feeTotal", feeTotal);
			parameters.add("rpPersonNum", rpPersonNum);
			rpExpenseDao.update(parameters, new Criteria("id", rpe.getId()));
		}
	}

}
