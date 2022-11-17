package com.founder.rhip.ehr.service.statistics.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientPrescriptionDao;
import com.founder.rhip.ehr.service.statistics.IOutPatientPrescriptionAnalyseService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("outPatientPrescriptionAnalyseService")
@TaskBean(cron = "0 0 5 * * ?", description = "门诊处方统计定时任务")
public class OutPatientPrescriptionAnalyseServiceImpl implements
		IOutPatientPrescriptionAnalyseService, Task {

	@Resource(name = "outpatientInfoDao")
	private IOutpatientInfoDao outpatientInfoDao;
	
	@Resource(name = "outpatientPrescriptionDao")
	private IOutpatientPrescriptionDao outpatientPrescriptionDao;
	
	@Resource(name = "drugUsageDao")
	private IDrugUsageDao drugUsageDao;
	
	@Override
	public void analysePrescription() {
//		Date currentTime = new Date();
//		Date date = DateUtil.getBeforeDay(new Date(), 1);
//		final Criteria criteria = new Criteria();
//		Date d = DateUtil.parseDateString("2014/07/17");
//		criteria.add("clinicDate", d);
//		DateUtil.getCriteriaByDateRange(criteria, "clinicDate", date, currentTime);
		
		PageableDateSource.exec(new IDataSource<OutpatientInfo>() {

			@Override
			public PageList<OutpatientInfo> get(Page page) {
				return outpatientInfoDao.getPageList(page, null);
			}

			@Override
			public void run(List<OutpatientInfo> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				List<OutpatientInfo> outpatientInfos = new ArrayList<>();
				for (OutpatientInfo outpatientInfo : list) {
					String ehrId = null;
					String outpatientNo = null;
					if (ObjectUtil.isNullOrEmpty(outpatientInfo) || ObjectUtil.isNullOrEmpty(ehrId = outpatientInfo.getEhrId()) 
							|| ObjectUtil.isNullOrEmpty(outpatientNo = outpatientInfo.getOutpatientNo())) {
						continue;
					}
					// 处方数
					List<OutpatientPrescription> outpatientPrescriptions = outpatientPrescriptionDao.getList(new Criteria("ehrId", ehrId).add("outpatientNo", outpatientNo));
					if (ObjectUtil.isNotEmpty(outpatientPrescriptions)) {
						outpatientInfo.setPrescriptionCount(outpatientPrescriptions.size());
					}
					int i = 0;
					for (OutpatientPrescription outpatientPrescription : outpatientPrescriptions) {
						String pNo = null;
						if (ObjectUtil.isNullOrEmpty(outpatientInfo) || ObjectUtil.isNullOrEmpty(pNo = outpatientPrescription.getRecordNumber())) {
							continue;
						}
						List<DrugUsage> drugUsages = drugUsageDao.getList(new Criteria("ehrId", ehrId).add("recordNumber", pNo));
						for (DrugUsage drugUsage : drugUsages) {
							if (ObjectUtil.isNullOrEmpty(drugUsage)) {
								continue;
							}
							if (StringUtils.contains(drugUsage.getDrugUseRouteCode(), "404") || StringUtils.contains(drugUsage.getDrugUseRouteCode(), "静滴")) {
								i++;
								break;
							}
						}
					}
					if (i > 0) {
						outpatientInfo.setPrescription_route_count(i);
					}
					if (ObjectUtil.isNotEmpty(outpatientInfo.getPrescriptionCount()) || ObjectUtil.isNotEmpty(outpatientInfo.getPrescription_route_count())) {
						outpatientInfos.add(outpatientInfo);
					}
				}
				if (ObjectUtil.isNotEmpty(outpatientInfos)) {
					outpatientInfoDao.batchUpdate(outpatientInfos, new String[] {"prescriptionCount", "prescription_route_count"});
				}
			}
		});
	}

	@Override
	public void run(Map<String, Object> data) {
		System.out.println("开始处理...");
		Long start = System.currentTimeMillis();
		analysePrescription();
		Long end = System.currentTimeMillis();
		System.out.println(formatTime(end - start));
	}
	
	private String formatTime(long millis) {
		String unit = "秒";
		double sec = (double)millis / 1000;
		if (sec >= 60) {
			sec = sec / 60;
			unit = "分钟";
		}
		if (sec >= 60) {
			sec = sec / 60;
			unit = "小时";
		}
		return String.format("%.2f", sec) + unit;
	}
}
