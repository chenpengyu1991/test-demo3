package com.founder.rhip.im.service.loader;


import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.basic.IReportRecordDao;
import com.founder.rhip.ehr.repository.child.IChildHealthCardDao;
import com.founder.rhip.ehr.repository.child.INeonatalFamilyVisitDao;
import com.founder.rhip.ehr.repository.clinic.IReadHealthRecordDao;
import com.founder.rhip.ehr.repository.statistics.ICdmsStatisticsDao;
import com.founder.rhip.ehr.repository.women.IPostnatalFollowupDao;
import com.founder.rhip.ehr.repository.women.IPostpartumDaysHealthInfoDao;
import com.founder.rhip.im.common.TargetCategory;
import com.founder.rhip.im.entity.publicHealth.RdTargetPublicHealth;
import com.founder.rhip.im.repository.publicHealth.IRdTargetPublicHealthDao;


/**
 * 公卫指标获取loader类
 * <p/>
 * Created by bagen on 2016/8/2.
 */
public class PublicHealthTargetLoader extends BaseLoader<RdTargetPublicHealth> implements Runnable {

        private static Logger logger = Logger.getLogger(PublicHealthTargetLoader.class);

        @Autowired
        private IPersonInfoDao personInfoDao;

        @Resource(name = "readHealthRecordDao")
        private IReadHealthRecordDao readHealthRecordDao;

        @Resource(name = "rdTargetPublicHealthDao")
        private IRdTargetPublicHealthDao rdTargetPublicHealthDao;

        @Resource(name = "reportRecordDao")
        private IReportRecordDao reportRecordDao;

        @Autowired
        private INeonatalFamilyVisitDao neonatalFamilyVisitDao;

        @Autowired
        private IChildHealthCardDao childHealthCardDao;

        @Autowired
        private IPostnatalFollowupDao postnatalFollowupDao;

        @Autowired
        private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;

        @Resource(name = "cdmsStatisticsDao")
        private ICdmsStatisticsDao cdmsStatisticsDao;
//
//    @Resource(name = "vaccinationStatisticsDao")
//    private IVaccinationStatisticsDao vaccinationStatisticsDao;


    public PublicHealthTargetLoader(ApplicationContext context) {
    	 super();
         setContext(context);
         if (ObjectUtil.isNullOrEmpty(personInfoDao)) {
        	 personInfoDao = (IPersonInfoDao) context.getBean("personInfoDao");
         }
         if (ObjectUtil.isNullOrEmpty(readHealthRecordDao)) {
        	 readHealthRecordDao = (IReadHealthRecordDao) context.getBean("readHealthRecordDao");
         }
         if (ObjectUtil.isNullOrEmpty(rdTargetPublicHealthDao)) {
        	 rdTargetPublicHealthDao = (IRdTargetPublicHealthDao) context.getBean("rdTargetPublicHealthDao");
         }
         if (ObjectUtil.isNullOrEmpty(reportRecordDao)) {
        	 reportRecordDao = (IReportRecordDao) context.getBean("reportRecordDao");
         }
         if (ObjectUtil.isNullOrEmpty(neonatalFamilyVisitDao)) {
        	 neonatalFamilyVisitDao = (INeonatalFamilyVisitDao) context.getBean("neonatalFamilyVisitDao");
         }
         if (ObjectUtil.isNullOrEmpty(childHealthCardDao)) {
        	 childHealthCardDao = (IChildHealthCardDao) context.getBean("childHealthCardDao");
         }
         if (ObjectUtil.isNullOrEmpty(postnatalFollowupDao)) {
        	 postnatalFollowupDao = (IPostnatalFollowupDao) context.getBean("whPostnatalFollowupDao");
         }
         if (ObjectUtil.isNullOrEmpty(postpartumDaysHealthInfoDao)) {
        	 postpartumDaysHealthInfoDao = (IPostpartumDaysHealthInfoDao) context.getBean("postpartumDaysHealthInfoDao");
         }
         if (ObjectUtil.isNullOrEmpty(cdmsStatisticsDao)) {
        	 cdmsStatisticsDao = (ICdmsStatisticsDao) context.getBean("cdmsStatisticsDao");
         }
//         if (ObjectUtil.isNullOrEmpty(vaccinationStatisticsDao)) {
//        	 vaccinationStatisticsDao = (IVaccinationStatisticsDao) context.getBean("vaccinationStatisticsDao");
//         }
    }
    /**
     * 获取全市电子健康档案指标
     *
     */
    private void getEHRTarget() {
    	try {
	        //全市已建档（户籍）人数
	        long hjNums = getHealthFile("1");
	        //全市已建档（非户籍）人数
	        long fhjNums = getHealthFile("2");
	        //医生使用档案次数
	        int useNums = readHealthRecordDao.countRow(null);
	        //全市已建档
	        long Nums = hjNums + fhjNums;
	        RdTargetPublicHealth rdTargetPublicHealth = new RdTargetPublicHealth();
	        rdTargetPublicHealth.setTargetCode(TargetCategory.T01.getCode());
	        rdTargetPublicHealth.setTargetName(TargetCategory.T01.getName());
	        rdTargetPublicHealth.setValue1(String.valueOf(Nums));
	        rdTargetPublicHealth.setValue2(String.valueOf(hjNums));
	        rdTargetPublicHealth.setValue3(String.valueOf(fhjNums));
	        rdTargetPublicHealth.setValue4(String.valueOf(useNums));
        
	        logger.debug("[全市电子健康档案指标][全市已建档（户籍）份数：" + hjNums + ", 全市已建档（非户籍）份数："+ fhjNums +", "
	        		+ "医生使用档案份数："+ useNums +", 全市已建档次数"+ Nums +"]");
        	update(rdTargetPublicHealth);
        } catch(Exception e) {
        	logger.error("[PublicHealthTargetLoader][全市电子健康档案指标-处理抽取的业务数据出错]\n" + e.getMessage(), e);
        }
    }

    /**
     * 获取健康档案建档数
     * @param houseHoldType 户籍:1  非户籍:2
     * @return 建档数
     */
    private Long getHealthFile(String houseHoldType) {
        Criteria criteria = new Criteria();
        criteria.add("householdType", houseHoldType);
        String flags = EHRConstants.HAD_CREATE;
        criteria.add("FILING_FLAG", OP.EQ, flags);
        return personInfoDao.getCount(criteria, "id", Long.class);

    }

    /**
     *获取全市社区公共卫生
     */
    private void getCDMTarget(){
    	try {
	    	//糖尿病建卡
	        long diManageCount = 0l;
	        diManageCount = cdmsStatisticsDao.getDiCountByOrganCode(null, null, null);
	        //糖尿病随访
	        long diFolowUpCount = 0l;
	        diFolowUpCount = cdmsStatisticsDao.getDiFollowupCountByOrganCode(null, null, null);
	        //高血压建卡
	        long hbpManageCount = 0l;
	        hbpManageCount = cdmsStatisticsDao.getHbpCountByOrganCode(null, null, null);
	        //高血压随访
	        long hbpFolowUpCount = 0l;
	        hbpFolowUpCount = cdmsStatisticsDao.getHbpFollowupCountByOrganCode(null, null, null);
	        RdTargetPublicHealth rdTargetPublicHealth = new RdTargetPublicHealth();
	        rdTargetPublicHealth.setTargetCode(TargetCategory.T02.getCode());
	        rdTargetPublicHealth.setTargetName(TargetCategory.T02.getName());
	        rdTargetPublicHealth.setValue1(String.valueOf(diManageCount));
	        rdTargetPublicHealth.setValue2(String.valueOf(diFolowUpCount));
	        rdTargetPublicHealth.setValue3(String.valueOf(hbpManageCount));
	        rdTargetPublicHealth.setValue4(String.valueOf(hbpFolowUpCount));
        
	        logger.debug("[全市社区公共卫生][糖尿病建卡人数：" + diManageCount + ", 糖尿病随访人数："+ diFolowUpCount +", "
	        		+ "高血压建卡人数："+ hbpManageCount +", 高血压随访人数"+ hbpFolowUpCount +"]");
        	update(rdTargetPublicHealth);
        } catch(Exception e) {
        	logger.error("[PublicHealthTargetLoader][全市社区公共卫生-处理抽取的业务数据出错]\n" + e.getMessage(), e);
        }
    }

    /**
     * 预防接种
     */
    public void getVaccination() {/*
    	try {
	        Long vaccinationNum = (long) vaccinationStatisticsDao.vaccinationNum(null);//预防接种总人数
	        String year = String.valueOf(DateUtil.getCurrentYear());
	        Long vaccinationNumByYear = (long) vaccinationStatisticsDao.vaccinationNumByYear(new Criteria("year",year));//本年接种人数
	        RdTargetPublicHealth rtph = new RdTargetPublicHealth();
	        rtph.setTargetCode(TargetCategory.T03.getCode());
	        rtph.setTargetName(TargetCategory.T03.getName());
	        rtph.setValue1(String.valueOf(vaccinationNum));//预防接种总人数
	        rtph.setValue2(String.valueOf(vaccinationNumByYear));//本年接种人数
        
	        logger.debug("[预防接种][预防接种总人数：" + vaccinationNum + ", 本年接种人数："+ vaccinationNumByYear +"]");
        	update(rtph);
        } catch(Exception e) {
        	logger.error("[PublicHealthTargetLoader][预防接种-处理抽取的业务数据出错]\n" + e.getMessage(), e);
        }
    */}

    /**
     * 妇幼保健
     */
    public void getWomenChildrenTarget() {
    	try {
	        Criteria criteria = new Criteria();
	        Long xsefsCount = neonatalFamilyVisitDao.getNeonatalVisitCount(criteria);//新生儿访视人数
	        Long yejadaCount = childHealthCardDao.getCount(criteria, "id", Long.class);//婴幼儿健康管理数
	        Long chfsCount = postnatalFollowupDao.postnatalFollowupCount(criteria);//产后访视人数
	        Long chfs42Count = postpartumDaysHealthInfoDao.postpartumDaysCount(criteria);//产后42天健康检查人数
	        RdTargetPublicHealth rtph = new RdTargetPublicHealth();
	        rtph.setTargetCode(TargetCategory.T04.getCode());
	        rtph.setTargetName(TargetCategory.T04.getName());
	        rtph.setValue1(String.valueOf(xsefsCount));//新生儿访视人数
	        rtph.setValue2(String.valueOf(yejadaCount));//婴幼儿健康管理数
	        rtph.setValue3(String.valueOf(chfsCount));//产后访视人数
	        rtph.setValue4(String.valueOf(chfs42Count));//产后42天健康检查人数
        
	        logger.debug("[妇幼保健][新生儿访视人数：" + xsefsCount + ", 婴幼儿健康管理人数："+ yejadaCount +", "
	        		+ "产后访视人数："+ chfsCount +", 产后42天健康检查人数"+ chfs42Count +"]");
        	update(rtph);
        } catch(Exception e) {
        	logger.error("[PublicHealthTargetLoader][妇幼保健-处理抽取的业务数据出错]\n" + e.getMessage(), e);
        }
    }


    /***
     * 全市医疗单位信息
     */
    public void getIDMTarget() {
    	try {
	        Criteria criteria = new Criteria();
	        Long total = reportRecordDao.getCount(null, "1", Long.class);//总上报数
	
	        this.getCriteriaByDateRange(criteria, "createDate", DateUtil.getBeforeDay(new Date(), 1), DateUtil.getBeforeDay(new Date(), 1));
	        Long yesterday = reportRecordDao.getCount(criteria, "1", Long.class);//昨日上报数
	
	        RdTargetPublicHealth rtph = new RdTargetPublicHealth();
	        rtph.setTargetCode(TargetCategory.T05.getCode());
	        rtph.setTargetName(TargetCategory.T05.getName());
	        rtph.setValue1(String.valueOf(yesterday));//昨日上报数
	        rtph.setValue2(String.valueOf(total));//总上报数
        
	        logger.debug("[全市医疗单位信息][总上报条数：" + total + ", 昨日上报条数："+ yesterday +"]");
        	update(rtph);
        } catch(Exception e) {
        	logger.error("[PublicHealthTargetLoader][全市医疗单位信息-处理抽取的业务数据出错]\n" + e.getMessage(), e);
        }
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

    /**
     * 更新指标
     *
     * @param rtph
     */
    private void update(RdTargetPublicHealth rtph) {
    	RdTargetPublicHealth rdTargetPublicHealth = rdTargetPublicHealthDao.get(new Criteria("targetCode", rtph.getTargetCode()));
        if (ObjectUtil.isNullOrEmpty(rdTargetPublicHealth)) {
        	rtph.setCreateDate(new Date());
        	rtph.setUpdateDate(new Date());
            rdTargetPublicHealthDao.insert(rtph);
        } else {
        	rtph.setId(rdTargetPublicHealth.getId());
        	rtph.setCreateDate(rdTargetPublicHealth.getCreateDate());
        	rtph.setUpdateDate(new Date());
            rdTargetPublicHealthDao.update(rtph);
        }
    }

    @Override
    public void run() {
        logger.debug("全市电子健康档案指标统计 开始");
        getEHRTarget();
        logger.debug("全市电子健康档案指标统计 结束");

        logger.debug("全市社区公共卫生指标统计 开始");
        getCDMTarget();
        logger.debug("全市社区公共卫生标统计 结束");

        logger.debug("妇幼保健指标统计 开始");
        getWomenChildrenTarget();
        logger.debug("妇幼保健指标统计 结束");

        logger.debug("预防接种指标统计 开始");
        getVaccination();
        logger.debug("预防接种指标统计 结束");

        logger.debug("全市医疗单位信息统计 开始");
        getIDMTarget();
        logger.debug("全市医疗单位信息指标统计 结束");

    }


}
