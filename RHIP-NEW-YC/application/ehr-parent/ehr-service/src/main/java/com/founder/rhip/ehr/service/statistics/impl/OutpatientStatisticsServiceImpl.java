package com.founder.rhip.ehr.service.statistics.impl;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpOutpatient;
import com.founder.rhip.ehr.repository.ihm.IMedicalTargetDao;
import com.founder.rhip.ehr.repository.report.IRpOutpatientDao;
import com.founder.rhip.ehr.service.statistics.IOutpatientStatisticsService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Alene on 2016/2/26.
 */
@Service("outpatientStatisticsService")
@TaskBean(cron = "0 0 5 * * ?", description = "门急诊信息统计定时任务")
public class OutpatientStatisticsServiceImpl implements
        IOutpatientStatisticsService, Task {
	
	@Resource(name="medicalTargetDao")
	private IMedicalTargetDao medicalTargetDao;
	
	@Resource(name = "rpOutpatientDao")
	private IRpOutpatientDao rpOutpatientDao;
	
    @Autowired
    private IOrganizationApp organizationApp;

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    protected Logger logger = LoggerFactory.getLogger(OutpatientStatisticsServiceImpl.class);

    List<RpOutpatient> updatRpOutpatient = new ArrayList<RpOutpatient>();
    List<RpOutpatient> insertRpOutpatient = new ArrayList<RpOutpatient>();
    private static final String FORMATER = "yyyy/MM/dd";

    @Override
    public void analysePrescription(String dateStr) {
    	updatRpOutpatient = new ArrayList<RpOutpatient>();
    	insertRpOutpatient = new ArrayList<RpOutpatient>();
        //若参数为空则默认同步前一天的数据
        Date date = DateUtil.getBeforeDay(new Date(), 1);;
        if(!StringUtils.isNotEmpty(dateStr)) {
            dateStr = DateUtil.getDateTime(FORMATER, date);
        }
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        result = medicalTargetDao.getRpMapList(dateStr);
       //查询所有机构
        Criteria criteriaOrgan = new Criteria();
        List<String> generCodes = new ArrayList<>();
        generCodes.add("A100");//综合医院
        generCodes.add("B100");//中心
        generCodes.add("B200");//站
//        generCodes.add("D400");//医务室
//        generCodes.add("L");//监督所
//        generCodes.add("R2");//其他
        criteriaOrgan.add("genreCode", OP.IN, generCodes);
//        criteriaOrgan.add("subsid", 0);//不查询子机构
        criteriaOrgan.add("status", 1);//只查询可用机构
        List<Organization> organs = organizationService.getOrganizations(criteriaOrgan);
        List<Organization> hasorgans = new ArrayList<Organization>();

        for(int i = 0;i<result.size();i++) {//遍历有数据的机构
            for (Organization o : organs) {//遍历所有机构
                if(o.getOrganCode().equals(result.get(i).get("ORGAN_CODE"))){
                    //如果在有数据的机构里找到所有机构里对应的code，则执行插入操作
                	RpOutpatient rps = new RpOutpatient();
                    Organization organization = organizationApp.queryOrgan(String.valueOf(result.get(i).get("ORGAN_CODE")));
                    this.setValueForRpOutpatientAboutOrg(organization, rps);
                    Date clinicDate = DateUtil.parseSimpleDate(dateStr, FORMATER);
                    rps.setRpDate(clinicDate);
                    rps.setRegisterNum((ObjectUtil.isNullOrEmpty(result.get(i).get("REGISTERNUM"))) ? 0 : Long.valueOf(String.valueOf(result.get(i).get("REGISTERNUM"))));
                    rps.setTreatmentNum((ObjectUtil.isNullOrEmpty(result.get(i).get("VISITNUM"))) ? 0 : Long.valueOf(String.valueOf(result.get(i).get("VISITNUM"))));
                    rps.setStayNum((ObjectUtil.isNullOrEmpty(result.get(i).get("OBSERVEDNUM"))) ? 0 : Long.valueOf(String.valueOf(result.get(i).get("OBSERVEDNUM"))));
                    this.addRpOutpatient(organization.getOrganCode(), DateUtil.parseDateString(dateStr), rps);
                    hasorgans.add(o);//将有数据的机构放在一个集合里
                }
            }
        }
        organs.removeAll(hasorgans);//去除已有数据的机构在剩余机构集合里
        //剩余的所有机构的数据，则RpOutpatient数据的数量补0
        for (Organization o : organs) {//遍历剩余所有机构
        	RpOutpatient rps = new RpOutpatient();
            Organization organization = organizationApp.queryOrgan(String.valueOf(o.getOrganCode()));
            if(organization!=null) {
                this.setValueForRpOutpatientAboutOrg(organization, rps);
                //rps.setRpDate(DateUtil.parseDateString("2014/07/29"));
                rps.setRpDate(DateUtil.parseSimpleDate(dateStr, FORMATER));
                //写定时任务的时候就把所有的机构都存进去（没有数据的机构写0），
                // 是为了统计的时候的效率，统计的时候就不用跨库了，大大提高统计速度和数据库的开销
                rps.setRegisterNum(Long.valueOf(0));
                rps.setTreatmentNum(Long.valueOf(0));
                rps.setStayNum(Long.valueOf(0));
                
                //this.addRpStudy(organization.getOrganCode(), DateUtil.parseDateString("2014/07/29"), rps);
                this.addRpOutpatient(organization.getOrganCode(), DateUtil.parseDateString(dateStr), rps);
            }
        }
        rpOutpatientDao.batchInsert(insertRpOutpatient);
        rpOutpatientDao.batchUpdate(updatRpOutpatient,"registerNum","rpDate","treatmentNum","stayNum");
        logger.info("插入综合管理统计表的检查人次:"+insertRpOutpatient.size());
        logger.info("更新综合管理统计表的检查人次:"+updatRpOutpatient.size());
    }


	@Override
    public void run(Map<String, Object> data) {
        System.out.println("开始处理...");
        Long start = System.currentTimeMillis();
        analysePrescription(String.valueOf(data.get("jobDataCustomParamKey")));
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

    /**
     * 为RpStudyEvent对象中和机构相关的属性赋值
     * @param organization
     * @param rpStatistics
     */
    private void setValueForRpOutpatientAboutOrg(Organization organization, RpOutpatient rpOutpatient) {
    	rpOutpatient.setGbCode(organization.getGbCode());
    	rpOutpatient.setCenterCode(organization.getParentCode());
    	rpOutpatient.setOrganCode(organization.getOrganCode());
    	rpOutpatient.setOrganType(organization.getGenreCode());
    }

    /**
     * 根据机构code和统计日期检查时更新还是插入
     * @param orgCode
     * @param date
     * @param rps
     */
    private void addRpOutpatient(String orgCode, Date date, RpOutpatient rps) {
        Criteria rpCriteria = new Criteria("organCode", orgCode);
        DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToMax(date), DateUtil.makeTimeToMax(date));
        RpOutpatient tempOutpatient = rpOutpatientDao.get(rpCriteria);
        if(ObjectUtil.isNullOrEmpty(tempOutpatient)) {
        	insertRpOutpatient.add(rps);
        } else {
        	tempOutpatient.setRpDate(rps.getRpDate());
        	tempOutpatient.setRegisterNum(rps.getRegisterNum());
        	tempOutpatient.setTreatmentNum(rps.getTreatmentNum());
        	tempOutpatient.setStayNum(rps.getStayNum());
            updatRpOutpatient.add(tempOutpatient);
        }
    }

}
