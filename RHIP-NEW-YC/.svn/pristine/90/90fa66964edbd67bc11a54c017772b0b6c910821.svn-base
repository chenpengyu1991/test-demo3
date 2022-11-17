package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.repository.basic.IReportRecordDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmStatusInfoDao;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chen_haibing
 * Date: 9/22/13
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("idmHealthTargetService")
public class IDMHealthTarget implements IPublicHealthTarget {

    @Resource(name = "idmStatusInfoDao")
    private IIdmStatusInfoDao idmStatusInfoDao;        //状态表

    @Resource(name = "reportRecordDao")
    private IReportRecordDao reportRecordDao;

    @Override
    public Float getEHRTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Float getHETarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Float getVaccinateTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Float getWomenChildrenTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Float getHmTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Float getCDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Float getIDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
        Criteria ca = new Criteria();
        // 登记传染病人数\报告传染病人数\报告及时传染病人数
        if(TargetConstants.IDM_REG.equals(targetCode)|| TargetConstants.IDM_REPORT.equals(targetCode)|| TargetConstants.IDM_INTIME.equals(targetCode)){
            ca.add("S.IDM_TYPE", "1");
            ca.add("S.REPORT_STATUS", "2");//审核通过
            if(null != orgCode && orgCode.size()>0 ){
                ca.add("R.FILL_ORGAN_CODE", OP.IN, orgCode);
            }
            this.getCriteriaByDateRange(ca, "R.FILL_DATE", startDate, endDate);
            return idmStatusInfoDao.getIDMTarget(ca);
        }
        // 医生工作站 慢病、传染病上报数   ***1:慢病；2:传染病
        if(TargetConstants.IDM_CDM_STATION_REPORT.equals(targetCode)){
            if(null != orgCode && orgCode.size()>0 ){
                ca.add("createOrganCode", OP.IN, orgCode);
            }
            this.getCriteriaByDateRange(ca, "createDate", startDate, endDate);
            return reportRecordDao.getCount(ca, "1", Float.class);
        }
        // 医生工作站 慢病上报数
        if(TargetConstants.CDM_STATION_REPORT.equals(targetCode)){
            if(null != orgCode && orgCode.size()>0 ){
                ca.add("createOrganCode", OP.IN, orgCode);
            }
            ca.add("type", 1);
            this.getCriteriaByDateRange(ca, "createDate", startDate, endDate);
            return reportRecordDao.getCount(ca, "1", Float.class);
        }
        // 医生工作站 传染病上报数
        if(TargetConstants.IDM_STATION_REPORT.equals(targetCode)){
            if(null != orgCode && orgCode.size()>0 ){
                ca.add("createOrganCode", OP.IN, orgCode);
            }
            ca.add("type", 2);
            this.getCriteriaByDateRange(ca, "createDate", startDate, endDate);
            return reportRecordDao.getCount(ca, "1", Float.class);
        }
        if(TargetConstants.IDM_YESTERDAY_REPORT.equals(targetCode)){
            if(null != orgCode && orgCode.size()>0 ){
                ca.add("createOrganCode", OP.IN, orgCode);
            }
            DateUtil.getCriteriaByDateRange(ca, "createDate", DateUtil.getBeforeDay(new Date(), 1), DateUtil.getBeforeDay(new Date(), 1));
            return reportRecordDao.getCount(ca, "1", Float.class);
        }
        return Float.valueOf(0);
    }

    @Override
    public Float getHSATarget(List<String> orgCode, Date startDate, Date endDate, String targetCode) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void getCriteriaByDateRange(Criteria criteria, String property, Date bDate, Date eDate) {

        // 开始时间不为空，结束时间为空
        if (bDate != null && eDate == null)
            criteria.add(property, OP.GE, bDate);
        if (bDate != null && eDate != null) {
            Object[] obj = new Object[2];
            obj[0] = bDate;
            obj[1] = eDate;
            criteria.add(property, OP.BETWEEN, obj);
        }
        if (bDate == null && eDate != null)
            criteria.add(property, OP.LE, eDate);
    }

	@Override
	public Float getMhmTarget(String orgCode, String orgType, Date startDate, Date endDate, String targetCode) {
		return null;
	}
}
