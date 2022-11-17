package com.founder.rhip.ncp.service;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.service.AddFollowupPlanTaskService;
import com.founder.rhip.ehr.service.ncp.INcpFollowDataTaskService;
import com.founder.rhip.ncp.dao.INcpPatientDao;
import com.founder.rhip.ncp.entity.NcpMonitorPlan;
import com.founder.rhip.ncp.entity.NcpPatient;
import com.founder.rhip.ncp.repository.IMonitorPlanDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@Service("ncpFollowDataTaskService")
@TaskBean(cron = "0 0 4 31 12 ?", description = "新冠随访历史数据处理定时任务")
public class NcpFollowDataTaskServiceImpl implements INcpFollowDataTaskService,Task {
    Logger logger = Logger.getLogger(NcpFollowDataTaskServiceImpl.class);
    @Resource(name = "ncpPatientDao")
    private INcpPatientDao ncpPatientDao;

    @Resource(name = "ncpMonitorPlanDao")
    private IMonitorPlanDao ncpMonitorPlanDao;

    @Override
    public void run(Map<String, Object> data) {
        logger.error("======新冠随访定时任务开始=======");
        followUpDataProcess();
        logger.error("======新冠随访定时任务结束=======");
    }
    @Override
    public void followUpDataProcess() {
    //只建了新冠肺炎管理卡，但是随访中未新增过任何计划。

        List<NcpPatient> ncpPatientList = ncpPatientDao.queryWithOutFollowUp();
        List<NcpPatient> ncpList = ncpPatientDao.queryTimesFollowUp();
        List<NcpPatient> ncpTotalList = ncpPatientDao.queryFollowUp();
        List<NcpMonitorPlan> insertList =  new ArrayList<NcpMonitorPlan>();
        if(ObjectUtil.isNotEmpty(ncpPatientList)){
            //这种统一新增一次计划内的随访，随访日期根据出院时间+4个月
            for (NcpPatient ncpPatient:ncpPatientList){
                NcpMonitorPlan plan = new NcpMonitorPlan();
                plan.setType(new BigDecimal(3));
                String nextPlanDateStr = DateUtil.convertDateToString(DateUtil.getMonthsLater(ncpPatient.getDischargeDate(), 4));
                plan.setPlanDate(DateUtil.parseSimpleDate(nextPlanDateStr, "yyyy/MM/dd"));
                plan.setPid(new BigDecimal(ncpPatient.getId()));
                plan.setCreateTime(new Date());
                plan.setCardno(ncpPatient.getCardno());
                plan.setCreateStaffCode(ncpPatient.getCreateDoctorCode());
                //1:计划内 2:计划外
                plan.setPlanType("1");
                insertList.add(plan);
            }
        }
        if(ObjectUtil.isNotEmpty(ncpTotalList)){
            List<String> mapTotalList = new ArrayList<String>();
            for (NcpPatient ncpPatient:ncpTotalList){
                mapTotalList.add(ncpPatient.getMonitorPlanId());
            }
            //先将有多次随访的全部改为计划外
            Parameters parameters = new Parameters("PLAN_TYPE", "2");
            Criteria criteria = new Criteria("id", OP.IN, mapTotalList);
            ncpMonitorPlanDao.update(parameters, criteria);
        }
        //建了新冠肺炎管理卡，随访中新增过一次甚至多次随访 根据最后一次计划内随访间隔3个月生成下一次随访计划
        if(ObjectUtil.isNotEmpty(ncpList)){
            List<String> mapList = new ArrayList<String>();
            for (NcpPatient ncpPatient:ncpList){
                Map<String,Object> addMap = new HashMap<String, Object>();
                NcpMonitorPlan ncpPlan = new NcpMonitorPlan();
                ncpPlan.setType(new BigDecimal(3));
                String nextPlanDateStr = DateUtil.convertDateToString(DateUtil.getMonthsLater(ncpPatient.getMonitorPlanDate(), 3));
                ncpPlan.setPlanDate(DateUtil.parseSimpleDate(nextPlanDateStr, "yyyy/MM/dd"));
                ncpPlan.setPid(new BigDecimal(ncpPatient.getId()));
                ncpPlan.setCreateTime(new Date());
                ncpPlan.setCardno(ncpPatient.getCardno());
                ncpPlan.setCreateStaffCode(ncpPatient.getCreateDoctorCode());
                //1:计划内 2:计划外
                ncpPlan.setPlanType("1");
                insertList.add(ncpPlan);
                mapList.add(ncpPatient.getMonitorPlanId());

            }
            //将最后一次随访类型（按照实际随访日期）改为计划内
            Parameters parameters = new Parameters("PLAN_TYPE", "1");
            Criteria criteria = new Criteria("id", OP.IN, mapList);
            ncpMonitorPlanDao.update(parameters, criteria);
        }
        ncpMonitorPlanDao.batchInsert(insertList);
    }

}
