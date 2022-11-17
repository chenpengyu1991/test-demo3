package com.founder.rhip.ehr.service.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpPregantWomenHealthcare;
import com.founder.rhip.ehr.repository.report.IRpPregantWomenHealthcareDao;
import com.founder.rhip.ehr.repository.women.IDeliveryRecordInfoDao;
import com.founder.rhip.ehr.repository.women.IMotherhoodPeriodFollowupDao;
import com.founder.rhip.ehr.repository.women.IPostpartumDaysHealthInfoDao;
import com.founder.rhip.ehr.repository.women.IPrenatalFollowupDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpPregantWomenHealthcareService")
@TaskBean(cron = "0 0 5 * * ?", description = "孕产妇保健服务报表定时任务")
public class RpPregantWomenHealthcareServiceImpl extends RpBaseService
		implements IRpPregantWomenHealthcareService,Task {

	@Resource(name = "motherhoodPeriodFollowupDao")
	private IMotherhoodPeriodFollowupDao motherhoodPeriodFollowupDao;
	
	@Resource(name = "prenatalFollowupDao")
	private IPrenatalFollowupDao prenatalFollowupDao;
	
	@Resource(name = "deliveryRecordInfoDao")
	private IDeliveryRecordInfoDao deliveryRecordInfoDao;
	
	@Resource(name = "postpartumDaysHealthInfoDao")
	private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;
	
	@Resource(name = "rpPregantWomenHealthcareDao")
	private IRpPregantWomenHealthcareDao rpPregantWomenHealthcareDao;
	
	@Override
	public void savePregantWomenHealthcareStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			Date date = DateUtil.getBeforeDay(new Date(), 1);
			dateStr = DateUtil.convertDateToString(date);
		}
		// 各机构下面医务人员数量
		Map<String,Long> staffCountMap = mdmStaffService.getStaffNumByOrg(null);
		// 孕产妇登记统计
		List<Map<String, Object>> followUpMapList = motherhoodPeriodFollowupDao.getMotherhoodPeriodFollowupMapList(dateStr);
		if (ObjectUtil.isNotEmpty(followUpMapList)) {
			for (Map<String, Object> map : followUpMapList) {
				Object rpDate = null;
				Object organCode = null;
				Object maternalRegistrationNum = null;
				if (ObjectUtil.isNullOrEmpty(map)
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("dt"))
						|| ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))
						|| ObjectUtil.isNullOrEmpty(maternalRegistrationNum = map.get("maternal_registration_num"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
			
				RpPregantWomenHealthcare rpwh = rpPregantWomenHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rpwh)) {
					RpPregantWomenHealthcare rpPregantWomenHealthcare = setRpPregantWomenHealthcare(String.valueOf(organCode), String.valueOf(rpDate), staffCountMap);
					if (ObjectUtil.isNotEmpty(rpPregantWomenHealthcare)) {
						rpPregantWomenHealthcare.setMaternalRegistrationNum(Long.valueOf(String.valueOf(maternalRegistrationNum)));
						rpPregantWomenHealthcareDao.insert(rpPregantWomenHealthcare);
					}
				} else {
					rpPregantWomenHealthcareDao.update(new Parameters("maternalRegistrationNum", maternalRegistrationNum), new Criteria("id", rpwh.getId()));
				}
			}
		}
		
		// 产前检查
		List<Map<String, Object>> prenatalFollowupMapList = prenatalFollowupDao.getPrenataFollowupMapList(dateStr);
		if (ObjectUtil.isNotEmpty(prenatalFollowupMapList)) {
			for (Map<String, Object> map : prenatalFollowupMapList) {
				Object rpDate = null;
				Object organCode = null;
				Object prenatalCheckNum = null;
				if (ObjectUtil.isNullOrEmpty(map)
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))
						|| ObjectUtil.isNullOrEmpty(prenatalCheckNum = map.get("prenatalCheckNum"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
			
				RpPregantWomenHealthcare rpwh = rpPregantWomenHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rpwh)) {
					RpPregantWomenHealthcare rpPregantWomenHealthcare = setRpPregantWomenHealthcare(String.valueOf(organCode), String.valueOf(rpDate), staffCountMap);
					if (ObjectUtil.isNotEmpty(rpPregantWomenHealthcare)) {
						rpPregantWomenHealthcare.setPrenatalCheckNum(Long.valueOf(String.valueOf(prenatalCheckNum)));
						rpPregantWomenHealthcareDao.insert(rpPregantWomenHealthcare);
					}
				} else {
					rpPregantWomenHealthcareDao.update(new Parameters("prenatalCheckNum", prenatalCheckNum), new Criteria("id", rpwh.getId()));
				}
			}
		}
		
		// 产妇分娩记录
		List<Map<String, Object>> deliveryMapList = deliveryRecordInfoDao.getDeliveryRecordMapList(dateStr);
		List<RpPregantWomenHealthcare> insertRpPregantWomenHealthcares = new ArrayList<RpPregantWomenHealthcare>();
		List<RpPregantWomenHealthcare> updateRpPregantWomenHealthcares = new ArrayList<RpPregantWomenHealthcare>();
		if (ObjectUtil.isNotEmpty(deliveryMapList)) {
			for (Map<String, Object> map : deliveryMapList) {
				Object rpDate = null;
				Object organCode = null;
				if (ObjectUtil.isNullOrEmpty(map)
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
			
				RpPregantWomenHealthcare rpwh = rpPregantWomenHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rpwh)) {
					RpPregantWomenHealthcare rpPregantWomenHealthcare = setRpPregantWomenHealthcare(String.valueOf(organCode), String.valueOf(rpDate), staffCountMap);
					if (ObjectUtil.isNotEmpty(rpPregantWomenHealthcare)) {
						//腹膜外剖宫产人数
						rpPregantWomenHealthcare.setCesareanNum(ObjectUtil.isNullOrEmpty(map.get("cesarean_num")) ? null : Long.valueOf(String.valueOf(map.get("cesarean_num"))));
//						阴道自然分娩人数
						rpPregantWomenHealthcare.setSpontaneousVaginalNum(ObjectUtil.isNullOrEmpty(map.get("spontaneous_vaginal_num")) ? null : Long.valueOf(String.valueOf(map.get("spontaneous_vaginal_num"))));
//						产钳助产人数
						rpPregantWomenHealthcare.setForcepsDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("forceps_delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("forceps_delivery_num"))));
//						胎头吸引人数
						rpPregantWomenHealthcare.setFetalHeadSuctionNum(ObjectUtil.isNullOrEmpty(map.get("fetal_head_suction_num")) ? null : Long.valueOf(String.valueOf(map.get("fetal_head_suction_num"))));
//						臀位助产人数
						rpPregantWomenHealthcare.setBreechDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("breech_delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("breech_delivery_num"))));
//						其他分娩人数
						rpPregantWomenHealthcare.setOtherDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("other_delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("other_delivery_num"))));
//						产妇分娩数
						rpPregantWomenHealthcare.setDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("delivery_num"))));
//						阴道手术助产人数
						rpPregantWomenHealthcare.setVaginaSurgicalDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("vagina_surgical_delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("vagina_surgical_delivery_num"))));
//						子宫下段横切口剖宫产人数
						rpPregantWomenHealthcare.setLowerCesareanNum(ObjectUtil.isNullOrEmpty(map.get("lower_cesarean_num")) ? null : Long.valueOf(String.valueOf(map.get("lower_cesarean_num"))));
//						子宫体剖宫产人数
						rpPregantWomenHealthcare.setUterineCesareanNum(ObjectUtil.isNullOrEmpty(map.get("uterine_cesarean_num")) ? null : Long.valueOf(String.valueOf(map.get("uterine_cesarean_num"))));
//						腹膜外剖宫产人数
						rpPregantWomenHealthcare.setExtraperitonealCesareanNum(ObjectUtil.isNullOrEmpty(map.get("extraperitoneal_cesarean_num")) ? null : Long.valueOf(String.valueOf(map.get("extraperitoneal_cesarean_num"))));
						//rpPregantWomenHealthcareDao.insert(rpPregantWomenHealthcare);
						insertRpPregantWomenHealthcares.add(rpPregantWomenHealthcare);
					}
				} else {
					//String[] properties = new String[] {"cesareanNum","spontaneousVaginalNum","forcepsDeliveryNum","fetalHeadSuctionNum","breechDeliveryNum","otherDeliveryNum","deliveryNum"};
					rpwh.setCesareanNum(ObjectUtil.isNullOrEmpty(map.get("cesarean_num")) ? null : Long.valueOf(String.valueOf(map.get("cesarean_num"))));
					rpwh.setSpontaneousVaginalNum(ObjectUtil.isNullOrEmpty(map.get("spontaneous_vaginal_num")) ? null : Long.valueOf(String.valueOf(map.get("spontaneous_vaginal_num"))));
					rpwh.setForcepsDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("forceps_delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("forceps_delivery_num"))));
					rpwh.setFetalHeadSuctionNum(ObjectUtil.isNullOrEmpty(map.get("fetal_head_suction_num")) ? null : Long.valueOf(String.valueOf(map.get("fetal_head_suction_num"))));
					rpwh.setBreechDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("breech_delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("breech_delivery_num"))));
					rpwh.setOtherDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("other_delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("other_delivery_num"))));
					rpwh.setDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("delivery_num"))));
//					阴道手术助产人数
					rpwh.setVaginaSurgicalDeliveryNum(ObjectUtil.isNullOrEmpty(map.get("vagina_surgical_delivery_num")) ? null : Long.valueOf(String.valueOf(map.get("vagina_surgical_delivery_num"))));
//					子宫下段横切口剖宫产人数
					rpwh.setLowerCesareanNum(ObjectUtil.isNullOrEmpty(map.get("lower_cesarean_num")) ? null : Long.valueOf(String.valueOf(map.get("lower_cesarean_num"))));
//					子宫体剖宫产人数
					rpwh.setUterineCesareanNum(ObjectUtil.isNullOrEmpty(map.get("uterine_cesarean_num")) ? null : Long.valueOf(String.valueOf(map.get("uterine_cesarean_num"))));
//					腹膜外剖宫产人数
					rpwh.setExtraperitonealCesareanNum(ObjectUtil.isNullOrEmpty(map.get("extraperitoneal_cesarean_num")) ? null : Long.valueOf(String.valueOf(map.get("extraperitoneal_cesarean_num"))));
					updateRpPregantWomenHealthcares.add(rpwh);
					//rpPregantWomenHealthcareDao.update(rpwh,properties);
				}
			}
			if(ObjectUtil.isNotEmpty(insertRpPregantWomenHealthcares)) {
				rpPregantWomenHealthcareDao.batchInsert(insertRpPregantWomenHealthcares);
			}
			if(ObjectUtil.isNotEmpty(updateRpPregantWomenHealthcares)) {
				String[] properties = new String[] {"cesareanNum","spontaneousVaginalNum","forcepsDeliveryNum","fetalHeadSuctionNum","breechDeliveryNum",
						"otherDeliveryNum","deliveryNum","vaginaSurgicalDeliveryNum","lowerCesareanNum","uterineCesareanNum","extraperitonealCesareanNum"};
				rpPregantWomenHealthcareDao.batchUpdate(updateRpPregantWomenHealthcares, properties);
			}
		}
		
		// 产后42天健康检查
		List<Map<String, Object>> postpartumDaysHealthInfoMapList = postpartumDaysHealthInfoDao.getPostpartumDaysHealthInfoMapList(dateStr);
		if (ObjectUtil.isNotEmpty(postpartumDaysHealthInfoMapList)) {
			for (Map<String, Object> map : postpartumDaysHealthInfoMapList) {
				Object rpDate = null;
				Object organCode = null;
				Object healthExaminationNum = null;
				if (ObjectUtil.isNullOrEmpty(map)
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))
						|| ObjectUtil.isNullOrEmpty(healthExaminationNum = map.get("health_examination_num"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
			
				RpPregantWomenHealthcare rpwh = rpPregantWomenHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rpwh)) {
					RpPregantWomenHealthcare rpPregantWomenHealthcare = setRpPregantWomenHealthcare(String.valueOf(organCode), String.valueOf(rpDate), staffCountMap);
					if (ObjectUtil.isNotEmpty(rpPregantWomenHealthcare)) {
						rpPregantWomenHealthcare.setHealthExaminationNum(Long.valueOf(String.valueOf(healthExaminationNum)));
						rpPregantWomenHealthcareDao.insert(rpPregantWomenHealthcare);
					}
				} else {
					rpPregantWomenHealthcareDao.update(new Parameters("healthExaminationNum", healthExaminationNum), new Criteria("id", rpwh.getId()));
				}
				
			}
		}
	}

	/**
	 * 设置RpPregantWomenHealthcare对象公共属性
	 * @param organCode 机构编码
	 * @param rpDate 统计日期
	 * @param staffCountMap 医技人员与机构对应map
	 * @return
	 */
	private RpPregantWomenHealthcare setRpPregantWomenHealthcare(String organCode, String rpDate, Map<String,Long> staffCountMap) {
		if (ObjectUtil.isNullOrEmpty(organCode)) {
			return null;
		}
		RpPregantWomenHealthcare rpPregantWomenHealthcare = new RpPregantWomenHealthcare();
		Organization organization = organizationApp.queryOrgan(organCode);
		setRpOrganization(new ConvertingWrapDynaBean(rpPregantWomenHealthcare), organization);
		rpPregantWomenHealthcare.setDoctorNum(staffCountMap.get(organCode));
		rpPregantWomenHealthcare.setRpDate(DateUtil.parseDateString(rpDate));
		return rpPregantWomenHealthcare;
	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		savePregantWomenHealthcareStatistics(dateStr);
		
	}

	@Override
	public List<Map<String, Object>> getPregantWomenHealthcareMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		mapList = rpPregantWomenHealthcareDao.getPregantWomenHealthcareMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
		return destMapList;
	}
	
	/**
	 * 育龄妇女保健工作量考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getGestationalPerformanceOrg(Map<String, String> paramMap) {
		return rpPregantWomenHealthcareDao.getGestationalPerformanceOrg(paramMap);
	}
	
	/**
	 * 孕产妇保健工作量考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPregantPerformanceOrg(Map<String, String> paramMap) {
		return rpPregantWomenHealthcareDao.getPregantPerformanceOrg(paramMap);
	}
	
}
