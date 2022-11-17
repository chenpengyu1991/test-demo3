package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.control.RemindStatistics;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.ehr.service.IRemindStatisticsService;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.hm.service.IPhysiqueExaminationService;
import com.founder.rhip.portal.common.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by wang_zhou on 2015/6/6.
 */

@Controller
@RequestMapping(value = "/oldManHealthCare")
public class OldManHealthCareController {

    @Resource
    private IBrwHealthService brwHealthService;

    @Resource(name = "physiqueExaminiationService")
    private IPhysiqueExaminationService physiqueExaminiationService;

    @Resource(name = "remindStatisticsService")
    private IRemindStatisticsService remindStatisticsService;

    @Resource(name = "physicalExamRecordService")
    private IPhysicalExamRecordService physicalExamRecordService;

    /**
     * 老年人自我评估
     * @param model
     * @return
     */
    @RequestMapping("/selfEvaluation")
    public String getSelfEvaluationCard(HttpServletRequest request,ModelMap model){
        int year = Integer.parseInt(String.valueOf(DateUtil.getCurrentYear()));
        PersonInfo personInfo=(PersonInfo)request.getSession().getAttribute(Constants.PERSON_INFO);
        if(personInfo!=null) {
            //此处添加根据personInfo.getId()去老年人体检表里查询是否已核实，如已核实，则可填评估表
            Criteria criteria = new Criteria();
            criteria.add("personId", personInfo.getId());
            criteria.add("examYear", OP.BETWEEN, DateUtil.getDateRangeByYear(DateUtil.getCurrentYear()));
            PhysicalExamRecord per = physicalExamRecordService.getPhysicalExamRecord(criteria);
            if(per!=null) {
                Integer confirm = per.getConfirm();
                if(confirm==1) {
                    ElderlyPhyExamination result = physiqueExaminiationService.getElderlyPhyExamination(personInfo.getId(), year, EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
                    model.addAttribute("personInfo", personInfo);
                    model.addAttribute("physiqueExamination", result);
            /* 插入一条记录到提醒统计表REMIND_STATISTICS     add by wangzhou   start*/
                    //User user = SecurityUtils.getCurrentUser(request);
                    RemindStatistics remindSt = new RemindStatistics();
                    remindSt.setOrganCode(personInfo.getInputOrganCode()==null?"":personInfo.getInputOrganCode());
                    remindSt.setOrganName(personInfo.getInputOrganName()==null?"":personInfo.getInputOrganName());
                    remindSt.setOrgType("");
                    remindSt.setGbcode(personInfo.getInputGbcode()==null?"":personInfo.getInputGbcode());
                    remindSt.setSupOrganCode("");
                    remindSt.setUserCode(personInfo.getId()==null?"":personInfo.getId().toString());
                    remindSt.setUserName(personInfo.getName()==null?"":personInfo.getName());
                    remindSt.setCategoryType("12");//门户老年人自我评估提醒
                    remindSt.setCreateDate(new Date());
                    remindStatisticsService.save(remindSt);
            /* 插入一条记录到提醒统计表REMIND_STATISTICS     add by wangzhou    end*/
                    return "lhprotal.ehr.selfEvaluationCard";
                }else{
                    return "lhportal.ehr.brwNoRecord";
                }
            }else{
                return "lhportal.ehr.brwNoRecord";
            }
        }
        return "lhportal.info.accountLogin";
    }

    /**
     * 更新自我评估
     * @param examination
     * @return
     */
    @RequestMapping("/selfAssessment")
    @ResponseBody
    public String updateAssessment(ElderlyPhyExamination examination, ModelMap model) {
        boolean result = false;
         result = physiqueExaminiationService.updateSelfAssessment(examination);
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
}
