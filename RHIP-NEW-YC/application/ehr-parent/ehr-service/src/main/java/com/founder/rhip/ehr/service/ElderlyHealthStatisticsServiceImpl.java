package com.founder.rhip.ehr.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.ElderlyHealthStatistics;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyExaminationDao;
import com.founder.rhip.ehr.repository.statistics.IElderlyHealthStatisticsDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("elderlyHealthStatisticsService")
@TaskBean(cron = "0 0 4 * * ?", description = "老年人健康指标统计定时任务")
public class ElderlyHealthStatisticsServiceImpl extends AbstractService implements
		IElderlyHealthStatisticsService, Task {

	@Resource(name = "physicalExamRecordDao")
	private IPhysicalExamRecordDao physicalExamRecordDao;
	
	@Resource(name = "elderlyPhyExaminationDao")
	private IElderlyPhyExaminationDao elderlyPhyExaminationDao;
	
	@Resource(name = "elderlyHealthStatisticsDao")
	private IElderlyHealthStatisticsDao elderlyHealthStatisticsDao;
	
	@Override
	public void processElderlyHealthStatistics(String year) {
		if (ObjectUtil.isNullOrEmpty(year)) {
			year = String.valueOf(DateUtil.getCurrentYear());
		}
		// 老年人体检人数统计
		List<Map<String, Object>> examCountMapList = physicalExamRecordDao.getPhysicalExamMapList(year);
		if (ObjectUtil.isNotEmpty(examCountMapList)) {
			for (Map<String, Object> map : examCountMapList) {
				Object orgCode = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(orgCode = map.get("orgCode"))) {
					continue;
				}
				Criteria criteria = new Criteria("orgCode", orgCode);
				DateUtil.getCriteriaByDateRange(criteria, "examYear", DateUtil.makeDateToZero(DateUtil.parseSimpleDate(year, "yyyy")), DateUtil.makeDateToMax(DateUtil.parseSimpleDate(year, "yyyy")));
				ElderlyHealthStatistics ehs = elderlyHealthStatisticsDao.get(criteria);
				if (ObjectUtil.isNullOrEmpty(ehs)) {
					ElderlyHealthStatistics elderlyHealthStatistics = new ElderlyHealthStatistics();
					elderlyHealthStatistics.setShouldExamQuantity(ObjectUtil.isNullOrEmpty(map.get("shouldExamQuantity")) ? null : Integer.valueOf(String.valueOf(map.get("shouldExamQuantity"))));
					elderlyHealthStatistics.setActualExamQuantity(ObjectUtil.isNullOrEmpty(map.get("actualExamQuantity")) ? null : Integer.valueOf(String.valueOf(map.get("actualExamQuantity"))));
					elderlyHealthStatistics.setExamYear(DateUtil.parseSimpleDate(year, "yyyy"));
					elderlyHealthStatistics.setOrgCode(String.valueOf(orgCode));
					elderlyHealthStatisticsDao.insert(elderlyHealthStatistics);
				} else {
					ehs.setShouldExamQuantity(ObjectUtil.isNullOrEmpty(map.get("shouldExamQuantity")) ? null : Integer.valueOf(String.valueOf(map.get("shouldExamQuantity"))));
					ehs.setActualExamQuantity(ObjectUtil.isNullOrEmpty(map.get("actualExamQuantity")) ? null : Integer.valueOf(String.valueOf(map.get("actualExamQuantity"))));
					elderlyHealthStatisticsDao.update(ehs, new String[] {"shouldExamQuantity","actualExamQuantity"});
				}
			}
		}
		// 体检项统计
		List<Map<String, Object>> examMapList = elderlyPhyExaminationDao.getElderlyExaminationStatisticsMapList(year);
		if (ObjectUtil.isNotEmpty(examMapList)) {
			for (Map<String, Object> map : examMapList) {
				Object orgCode = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(orgCode = map.get("orgCode"))) {
					continue;
				}
				Criteria criteria = new Criteria("orgCode", orgCode);
				DateUtil.getCriteriaByDateRange(criteria, "examYear", DateUtil.makeDateToZero(DateUtil.parseSimpleDate(year, "yyyy")), DateUtil.makeDateToMax(DateUtil.parseSimpleDate(year, "yyyy")));
				ElderlyHealthStatistics ehs = elderlyHealthStatisticsDao.get(criteria);
				String[] properties = new String[] {"bloodBioQuantity","urineRoutineQuantity","ecgQuantity","bUltrasonicQuantity","xRayQuantity",
						"bpvQuantity","ifgQuantity","dyslipidemiaQuantity","liverAbnormalQuantity","renalAbnormalQuantity",
						"xRayAbnormalQuantity","hepaticCystQuantity","fattyLiverQuantity","gallStoneQuantity",
						"cholecystitisQuantity","renalCystQuantity","kidneyStoneQuantity","tumorQuantity","tuberculosisQuantity"};
				if (ObjectUtil.isNullOrEmpty(ehs)) {
					ElderlyHealthStatistics elderlyHealthStatistics = new ElderlyHealthStatistics();
					ConvertingWrapDynaBean wrapDynaBean = new ConvertingWrapDynaBean(elderlyHealthStatistics);
					for (String property : properties) {
						wrapDynaBean.set(property, map.get(property));
					}
					elderlyHealthStatistics.setOrgCode(String.valueOf(orgCode));
					elderlyHealthStatistics.setExamYear(DateUtil.parseSimpleDate(year, "yyyy"));
					elderlyHealthStatisticsDao.insert(elderlyHealthStatistics);
				} else {
					ConvertingWrapDynaBean wrapDynaBean = new ConvertingWrapDynaBean(ehs);
					for (String property : properties) {
						wrapDynaBean.set(property, map.get(property));
					}
					elderlyHealthStatisticsDao.update(ehs, properties);
				}
			}
		}
	}
	
	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		processElderlyHealthStatistics(dateStr);
	}
}
