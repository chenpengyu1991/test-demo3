package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.QueryForm;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.repository.management.IDMFollowupPlanDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by f on 2019/11/13.
 */
@Service
@TaskBean(description = "慢病随访计划补缺(高血压和糖尿病)")
public class AddFollowupPlanTaskService implements Task {
    Logger logger = Logger.getLogger(AddFollowupPlanTaskService.class);

    @Resource(name = "dmDiseaseInfoDao")
    private IDmDiseaseInfoDao dmDiseaseInfoDao;

    @Resource(name = "dmFollowupPlanDao")
    private IDMFollowupPlanDao planDao;
    @Override
    public void run(Map<String, Object> data) {
        logger.info("补足随访计划任务开始...");
        String dis_type_1="1";//高血压随访计划标记
        String dis_type_2="2";//糖尿病随访计划标记
        //查询高血压慢病人数
        Criteria hbpcriteria = new Criteria();
        hbpcriteria.add("status","1");
        hbpcriteria.add("hbpFlag","2");
        List<DmDiseaseInfo> hbpList= dmDiseaseInfoDao.getList(hbpcriteria);
        addPlanProcess(hbpList,dis_type_1);
        //糖尿病
        Criteria tnbcriteria = new Criteria();
        tnbcriteria.add("status","1");
        tnbcriteria.add("diFlag","2");
        List<DmDiseaseInfo> tnbList= dmDiseaseInfoDao.getList(tnbcriteria);
        int r = addPlanProcess(tnbList,dis_type_2);
        logger.info("补足随访计划任务结束，成功添加随访计划"+r+"条数据。");
    }

    public int addPlanProcess(List<DmDiseaseInfo> hbpList,String dis_type) {
        int r = 0;
        String year = "2019";
        String planType_1 = "1";
        String type_9 = "9";//作废字段标记9方便恢复
        Integer zero = 0;//删除标记
        int fst = 0;
        int sec = 3;
        int thd = 6;
        int fth = 10;//11月份
        for (DmDiseaseInfo dm : hbpList) {
            Long pid = dm.getPersonId();
            if (pid == null)
                continue;
            Criteria cPlan = new Criteria();

            cPlan.add("person_id", pid.toString());
            cPlan.add("plan_year", year);
            cPlan.add("dis_type", dis_type);//高血压或糖尿病标记
            List<DMFollowupPlan> planList = planDao.getList(cPlan);
            List<DMFollowupPlan> insertList = null;
            DMFollowupPlan plan1 = null;
            DMFollowupPlan plan2 = null;
            DMFollowupPlan plan3 = null;
            DMFollowupPlan plan4 = null;
            Date date1 = null;
            Date date2 = null;
            Date date3 = null;
            Date date4 = null;

            if (planList == null || planList.isEmpty()) {//补最后一季度计划
                insertList = new ArrayList<DMFollowupPlan>();
                /*date1 = DateUtil.firstDateOfYear(new Date());
                plan1 = new DMFollowupPlan();
                plan1.setPlanYear(year);
                plan1.setDisType(dis_type);
                plan1.setPersonId(pid);
                plan1.setIsDelete(zero);
                plan1.setPlanType(planType_1);
                plan1.setType(type_9);
                plan1.setPlanDate(date1);
                insertList.add(plan1);
                plan2 = new DMFollowupPlan();
                plan2.setPlanYear(year);
                plan2.setDisType(dis_type);
                plan2.setPersonId(pid);
                plan2.setIsDelete(zero);
                plan2.setPlanType(planType_1);
                plan2.setType(type_9);
                date2 = DateUtil.firstDateOfYear(new Date());
                date2.setMonth(sec);
                plan2.setPlanDate(date2);
                insertList.add(plan2);
                plan3 = new DMFollowupPlan();
                plan3.setPlanYear(year);
                plan3.setDisType(dis_type);
                plan3.setPersonId(pid);
                plan3.setIsDelete(zero);
                plan3.setPlanType(planType_1);
                plan3.setType(type_9);
                date3 = DateUtil.firstDateOfYear(new Date());
                date3.setMonth(thd);
                plan3.setPlanDate(date3);
                insertList.add(plan3);*/
                plan4 = new DMFollowupPlan();
                plan4.setPlanYear(year);
                plan4.setDisType(dis_type);
                plan4.setPersonId(pid);
                plan4.setIsDelete(zero);
                plan4.setPlanType(planType_1);
                plan4.setType(type_9);
                date4 = DateUtil.firstDateOfYear(new Date());
                date4.setMonth(fth);
                plan4.setPlanDate(date4);
                insertList.add(plan4);
                planDao.batchInsert(insertList);
                continue;
            }
            boolean hasseason1 = false;
            boolean hasseason2 = false;
            boolean hasseason3 = false;
            boolean hasseason4 = false;
            for (DMFollowupPlan p : planList) {
                Date planDate = p.getPlanDate();
                if (planDate == null)
                    continue;
                int m = planDate.getMonth();
                if (m <= 2)
                    hasseason1 = true;
                else if (m <= 5)
                    hasseason2 = true;
                else if (m <= 8)
                    hasseason3 = true;
                else if (m <= 11)
                    hasseason4 = true;
            }
           /*  if(!hasseason1||!hasseason2||!hasseason3||!hasseason4){
                insertList =new ArrayList<DMFollowupPlan>();
            }

           if(!hasseason1){
                plan1 = new DMFollowupPlan();
                plan1.setPlanYear(year);
                plan1.setDisType(dis_type);
                plan1.setPersonId(pid);
                plan1.setIsDelete(zero);
                plan1.setPlanType(planType_1);
                plan1.setType(type_9);
                date1 = DateUtil.firstDateOfYear(new Date());
                plan1.setPlanDate(date1);
                insertList.add(plan1);
            }
            if(!hasseason2){
                plan2 = new DMFollowupPlan();
                plan2.setPlanYear(year);
                plan2.setDisType(dis_type);
                plan2.setPersonId(pid);
                plan2.setIsDelete(zero);
                plan2.setPlanType(planType_1);
                plan2.setType(type_9);
                date2 = DateUtil.firstDateOfYear(new Date());
                date2.setMonth(sec);
                plan2.setPlanDate(date2);
                insertList.add(plan2);
            }
            if(!hasseason3){
                plan3 = new DMFollowupPlan();
                plan3.setPlanYear(year);
                plan3.setDisType(dis_type);
                plan3.setPersonId(pid);
                plan3.setIsDelete(zero);
                plan3.setPlanType(planType_1);
                plan3.setType(type_9);
                date3 = DateUtil.firstDateOfYear(new Date());
                date3.setMonth(thd);
                plan3.setPlanDate(date3);
                insertList.add(plan3);
            }*/
            if (!hasseason4) {
                insertList = new ArrayList<DMFollowupPlan>();
                plan4 = new DMFollowupPlan();
                plan4.setPlanYear(year);
                plan4.setDisType(dis_type);
                plan4.setPersonId(pid);
                plan4.setIsDelete(zero);
                plan4.setPlanType(planType_1);
                plan4.setType(type_9);
                date4 = DateUtil.firstDateOfYear(new Date());
                date4.setMonth(fth);
                date4.setDate(20);//mantis0171897日期统一为11月20日
                plan4.setPlanDate(date4);
                insertList.add(plan4);
                r++;
                logger.info("姓名：" + dm.getName() + "，身份证号：" + dm.getIdcard() + "，person_id：" + dm.getPersonId() + ",成功添加随访计划,计划随访日期:" + DateUtil.getStringByDate(date4));
            }
            if (insertList != null)
                planDao.batchInsert(insertList);
        }
        return r;
    }
}
