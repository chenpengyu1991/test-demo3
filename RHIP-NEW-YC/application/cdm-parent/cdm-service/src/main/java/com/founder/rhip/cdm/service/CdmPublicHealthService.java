package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.repository.basic.IReportRecordDao;
import com.founder.rhip.ehr.repository.statistics.ICdmsStatisticsDao;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("cdmPublicHealthService")
public class CdmPublicHealthService extends AbstractService implements IPublicHealthTarget {

	@Resource(name = "cdmsStatisticsDao")
	private ICdmsStatisticsDao cdmsStatisticsDao;

	@Resource(name = "reportRecordDao")
	private IReportRecordDao reportRecordDao;

	@Override
	public Float getEHRTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHETarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getVaccinateTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getWomenChildrenTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHmTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getIDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHSATarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getCDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
		Date current=new Date();
		Date byYearEndDate =endDate==null?current:endDate;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(byYearEndDate);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR,0);
		calendar.set(Calendar.MINUTE,0);
		calendar.set(Calendar.SECOND,0);
		calendar.set(Calendar.MILLISECOND,0);
		calendar.set(Calendar.AM_PM,0);
		Date byYearStartDate=calendar.getTime();
		
		Date byTotalStartDate=null;
        Date byTotalEndDate=endDate;//允许为null
		
		Long count = null;

		switch (targetCode) {
		case TargetConstants.CDM_HBP_MANAGED_BY_YEAR_COUNT:
			count = cdmsStatisticsDao.getHbpCountByOrganCode(orgCode, byYearStartDate, byYearEndDate);
			break;
		case TargetConstants.CDM_HBP_MANAGED_TOTAL_COUNT:
			count = cdmsStatisticsDao.getHbpCountByOrganCode(orgCode, byTotalStartDate, byTotalEndDate);
			break;
		case TargetConstants.CDM_HBP_NEW_COUNT:
			count = cdmsStatisticsDao.getHbpCountByOrganCode(orgCode, startDate, endDate);
			break;
		case TargetConstants.CDM_HBP_FOLLOWUP_BSOK_COUNT:
			count = cdmsStatisticsDao.getHbpFollowupOKCountByOrganCode(orgCode, startDate, endDate);
			break;
		case TargetConstants.CDM_HBP_FOLLOWUP_COUNT:
			count = cdmsStatisticsDao.getHbpFollowupCountByOrganCode(orgCode, startDate, endDate);
			break;
		case TargetConstants.CDM_DI_MANAGED_BY_YEAR_COUNT:
			count = cdmsStatisticsDao.getDiCountByOrganCode(orgCode, byYearStartDate, byYearEndDate);
			break;
		case TargetConstants.CDM_DI_MANAGED_TOTAL_COUNT:
			count = cdmsStatisticsDao.getDiCountByOrganCode(orgCode, byTotalStartDate, byTotalEndDate);
			break;
		case TargetConstants.CDM_DI_NEW_COUNT:
			count = cdmsStatisticsDao.getDiCountByOrganCode(orgCode, startDate, endDate);
			break;
		case TargetConstants.CDM_DI_FOLLOWUP_BSOK_COUNT:
			count = cdmsStatisticsDao.getDiFollowupOKCountByOrganCode(orgCode, startDate, endDate);
			break;
		case TargetConstants.CDM_DI_FOLLOWUP_COUNT:
			count = cdmsStatisticsDao.getDiFollowupCountByOrganCode(orgCode, startDate, endDate);
			break;
		case TargetConstants.CDM_DI_TYPE_TWO_MANAGED_BY_YEAR_COUNT:
			count = cdmsStatisticsDao.getDiTypeTwoCountByOrganCode(orgCode, byYearStartDate, byYearEndDate);
			break;
		case TargetConstants.CDM_DI_TYPE_TWO_MANAGED_TOTAL_COUNT:
			count = cdmsStatisticsDao.getDiTypeTwoCountByOrganCode(orgCode, byTotalStartDate, byTotalEndDate);
			break;
		case TargetConstants.CDM_DI_TYPE_TWO_NEW_COUNT:
			count = cdmsStatisticsDao.getDiTypeTwoCountByOrganCode(orgCode, startDate, endDate);
			break;
		case TargetConstants.CDM_DI_TYPE_TWO_FOLLOWUP_BSOK_COUNT:
			count = cdmsStatisticsDao.getDiTypeTwoFollowupOKCountByOrganCode(orgCode, startDate, endDate);
			break;
		case TargetConstants.CDM_DI_TYPE_TWO_FOLLOWUP_COUNT:
			count = cdmsStatisticsDao.getDiTypeTwoFollowupCountByOrganCode(orgCode, startDate, endDate);
			break;
		case TargetConstants.CDM_STATION_REPORT:
			Criteria ca = new Criteria();
			// 医生工作站 慢病上报数
			if (null != orgCode && orgCode.size() > 0) {
				ca.add("createOrganCode", OP.IN, orgCode);
			}
			ca.add("type", 2);
			DateUtil.getCriteriaByDateRange(ca, "createDate", startDate, endDate);
			count = reportRecordDao.getCount(ca, "1", Long.class);
			break;
		default:
			count = 0L;
			log.warn("不支持的指标:" + targetCode);
			break;
		}
		if (null == count) {
			count = 0L;
		}
		return count.floatValue();
	}

	@Override
	public Float getMhmTarget(String orgCode,String orgType, Date startDate, Date endDate, String targetCode) {
		return null;
	}

}
