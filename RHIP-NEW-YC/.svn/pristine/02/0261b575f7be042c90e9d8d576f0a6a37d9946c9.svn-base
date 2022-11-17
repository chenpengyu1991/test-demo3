package com.founder.rhip.ehr.service.report;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.rhip.ehr.entity.report.RpInpatientMedicalRecord;
import com.founder.rhip.ehr.repository.report.IRpInpatientMedicalRecordDao;
import org.springframework.stereotype.Service;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpInpatientMedicalRecordService")
@TaskBean(cron = "0 0 5 * * ?", description = "抓取病案首页相关信息")
public class RpInpatientMedicalRecordServiceImpl extends RpBaseService implements Task {
	
	@Resource(name = "rpInpatientMedicalRecordDao")
	private IRpInpatientMedicalRecordDao rpInpatientMedicalRecordDao;

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		saveInpatientMedicalRecord(dateStr);
	}

	public void saveInpatientMedicalRecord(String dateStr) {
		Criteria delCriteria = new Criteria();
		String startDate = null;
		String endDate = null;
		if(ObjectUtil.isNotEmpty(dateStr)){
			if(DateUtil.isValidDate(dateStr, "yyyy/MM/dd")){
				//传入日期 删除这日期
				delCriteria.add("gatherDate",DateUtil.parseSimpleDate(dateStr, "yyyy/MM/dd"));
				startDate = dateStr;
			} else if(DateUtil.isValidDate(dateStr,"yyyy/MM")){
				//传入月份 删除这月
				Date date = DateUtil.parseSimpleDate(dateStr,"yyyy/MM");
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				Date[] dateRange = DateUtil.getDateRangeByMonth(cal.get(Calendar.MONTH));
				delCriteria.add("gatherDate",OP.BETWEEN,dateRange);
				startDate = DateUtil.getStringByDate(dateRange[0]);
				endDate = DateUtil.getStringByDate(dateRange[1]);
			} else if(DateUtil.isValidDate(dateStr,"yyyy")){
				//传入年份 删除这年
				Date date = DateUtil.parseSimpleDate(dateStr,"yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				Date[] dateRange = DateUtil.getDateRangeByYear(cal.get(Calendar.YEAR));
				delCriteria.add("gatherDate",OP.BETWEEN,dateRange);
				startDate = DateUtil.getStringByDate(dateRange[0]);
				endDate = DateUtil.getStringByDate(dateRange[1]);
			}
		}else {
			//未传入参数 抽取前天数据
			Date date = DateUtil.getBeforeDay(new Date(), 2);
			delCriteria.add("gatherDate", date);
		}
		//删除抽取时间内的老数据
		rpInpatientMedicalRecordDao.delete(delCriteria);
		//抽取数据
		List<RpInpatientMedicalRecord> inpatientMedicalRecords = rpInpatientMedicalRecordDao.getInpatientMedicalRecordList(startDate, endDate);
		//插入数据
		rpInpatientMedicalRecordDao.batchInsert(inpatientMedicalRecords);
	}

}
