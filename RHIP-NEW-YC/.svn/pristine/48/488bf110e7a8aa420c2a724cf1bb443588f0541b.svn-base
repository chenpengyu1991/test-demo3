package com.founder.rhip.ph.service.vaccine;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ehr.entity.management.InoculationAppointment;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;
import com.founder.rhip.ehr.repository.control.IInoculationDao;
import com.founder.rhip.ehr.repository.control.IVaccinationEventDao;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.control.IVaccinationMgmtDao;
import com.founder.rhip.ehr.repository.summary.ITraumaHistoryDao;
import com.founder.rhip.ph.repository.vaccine.IPersonInfoVaccineInfoDao;

/**
 * 
 * @author xu_bin
 * 
 */
@Service("vaccineService")
public class VaccineServiceImpl extends AbstractService implements
		IVaccinationReadService {
	@Autowired
	private IVaccinationMgmtDao vaccinationMgmtDao;

	@Autowired
	private IPersonInfoDao personInfoDao;

	@Autowired
	private IVaccinationInfoDao vaccinationInfoDao;
	
	@Autowired
	private IVaccinationEventDao vaccinationEventDao;
	
	@Autowired
	private IExamineEventDao examineEventDao;
	
	@Autowired
	private IExamineDetailDao examineDetailDao;
	
	@Autowired
	private ITraumaHistoryDao traumaHistoryDao;
	
	@Autowired
	private IInoculationDao inoculationDao;
	
	@Autowired
	private IPersonInfoVaccineInfoDao personInfoVaccineInfoDao;
	
	public PageList<VaccinationEvent> getList(Page page, Criteria criteria){
		return vaccinationEventDao.getVaccinationEventList(page, criteria);
	}
	
	@Override
	public VaccinationEvent getVaccinationEvent(Criteria criteria){
		return vaccinationEventDao.get(criteria);
	}
	
	@Override
	public VaccinationMgmt getVaccinationMgmt(Criteria criteria) {
		criteria.add("vaccinationType",  "02");
		VaccinationMgmt vaccinationMgmt = vaccinationMgmtDao.get(criteria);	
		if(ObjectUtil.isNullOrEmpty(vaccinationMgmt)){
			return new VaccinationMgmt();
		}
		Integer age = DateUtil.getAgeByBirthday(vaccinationMgmt.getBirthday());
		vaccinationMgmt.setAge(age);
		// 获取接种记录 修改人：高飞  修改日期：20180402
		List<VaccinationInfo> vaccinationInfoList = vaccinationInfoDao.getList(new Criteria("personId", vaccinationMgmt.getPersonId()).add("isDelete", 0));
		if (ObjectUtil.isNotEmpty(vaccinationInfoList)) {
			List<String> strList = new ArrayList<>();
			for (VaccinationInfo vaccinationInfo : vaccinationInfoList) {
				if (ObjectUtil.isNullOrEmpty(vaccinationInfo) || ObjectUtil.isNullOrEmpty(vaccinationInfo.getVaccineName())) {
					continue;
				}
				StringBuilder builder = new StringBuilder();
				builder.append(DateUtil.getDateTime("yyyy/MM/dd", vaccinationInfo.getVaccinationDate())).append(":").append(vaccinationInfo.getVaccineName());
				strList.add(builder.toString());
			}
			if (ObjectUtil.isNotEmpty(strList)) {
				vaccinationMgmt.setVaccineHistory(StringUtils.join(strList, ";   "));
			}
		}
		return vaccinationMgmt;
	}

	@Override
	public TraumaHistory getTraumaHistory(Criteria criteria) {
		TraumaHistory traumaHistory = traumaHistoryDao.get(criteria);
		if(ObjectUtil.isNullOrEmpty(traumaHistory)){
			return new TraumaHistory();
		}
		return traumaHistory;
	}

	@Override
	public List<ExamineDetail> getExamineDetail(Criteria criteria) {
		List<ExamineDetail> examineDetails = examineDetailDao.getList(criteria);
		return examineDetails;
	}

	@Override
	public VaccinationInfo getVaccinationInfo(Criteria criteria) {
		VaccinationInfo vaccinationInfo = vaccinationInfoDao.get(criteria);
		return vaccinationInfo;
	}

	@Override
	public List<VaccinationInfo> getVaccinationList(Criteria criteria,String... properties) {
		Order order = new Order("INOCULATION_TIMES", true);
		List<VaccinationInfo> vaccinationInfoList = vaccinationInfoDao.getList(criteria,order,properties);
		return vaccinationInfoList;
	}

	@Override
	public int analyseLastVaccineDate(Date date, Long personId) {
		Criteria criteria = new Criteria("personId", personId).add("isDelete",0).add("immuType",OP.IN,new String[]{"1"});
		List<VaccinationInfo> vacInfoList = vaccinationInfoDao.getList(criteria,new Order("INOCULATION_TIMES DESC nulls last"));
		if (ObjectUtil.isNotEmpty(vacInfoList)) {
			Date vacDate = vacInfoList.get(0).getVaccinationDate();
			int days = DateUtil.getBetweenDays(vacDate, date);
			if (days <= 184) {
				return 0;
			} else if (days > 184 && days <= 365) {
				return 2;
			} else if (days > 365 && days <= 365*3) {
				return 3;
			} else if (days > 365*3) {
				return 4;
			}
		}
		return 4;
	}

	@Override
	public PageList<VaccinationInfo> getVaccInDocList(
			Criteria criteria, Page page) {
		return vaccinationInfoDao.getPageList(page, criteria);
	}

	@Override
	public List<Map<String, Object>> exportVaccineList(Page page,Criteria criteria) {
		List<Map<String, Object>> dataSource = vaccinationMgmtDao.exportVaccineList(page, criteria);
		return dataSource;
	}

	@Override
	public PageList<InoculationAppointment> getInoculationList(Criteria criteria, Page page, String sql) {
		return inoculationDao.getPageListBySql(page, sql,criteria);
	}

	@Override
	public List<Map<String, Object>> statisticsVaccinationReport(Criteria criteria) {
		return inoculationDao.statisticsVaccinationReport(criteria);
	}
}
