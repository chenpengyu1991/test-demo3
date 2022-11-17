package com.founder.rhip.ncp.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.cdm.service.IStandardizationService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.idm.controller.NCPController;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IStaffService;
import com.founder.rhip.ncp.common.NcpConstants;
import com.founder.rhip.ncp.controller.form.FollowForm;
import com.founder.rhip.ncp.dto.FollowDto;
import com.founder.rhip.ncp.entity.NcpMonitor;
import com.founder.rhip.ncp.entity.NcpMonitorPlan;
import com.founder.rhip.ncp.entity.NcpPatient;
import com.founder.rhip.ncp.service.IFollowService;
import com.founder.rhip.ncp.service.INcpPatientService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 新冠患者健康管理
 * 患者随访管理
 */
@Controller
@RequestMapping("/ncp/follow")
public class FollowUpNcpController extends NcpController {

    @Resource(name = "ncpFollowService")
    IFollowService followService;

    @Resource(name = "ncpPatientService")
    INcpPatientService patientService;

    @Resource(name = "organizationApp")
    IOrganizationApp organizationApp;

    @Resource(name = "platformService")
    IPlatformService platformService;

    @Resource(name = "mdmStaffService")
    IStaffService staffService;
	@Resource
	private IStandardizationService standardizationService;
    Logger logger = Logger.getLogger(FollowUpNcpController.class);
    /**
     * 进入随访查询画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest request, ModelMap model) {
        Criteria ca = new Criteria("ncp.is_delete", EHRConstants.DELETE_FLG_0);
        this.createRoleSearch(request, ca);
        Map map = followService.searchQuickCnt(ca);
        model.put("ncpfollowcnt",map);
        return "rhip.ncp.follow.search";
    }

    /**
     * 进入随访列表画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(FollowForm form, HttpServletRequest request, ModelMap model) {
        String quicktype = request.getParameter("quicktype");
        //病例分类
        String patientType = request.getParameter("patientType");
        //县内治疗、县外治疗
        String zlType = request.getParameter("zlType");
        Criteria ca = null;
        if(StringUtil.isEmpty(quicktype)) {
            ca = form.toCriteria();
            this.createRoleSearch(request, ca);
        }else{//快速查询
            ca = new Criteria("ncp.is_delete", EHRConstants.DELETE_FLG_0);
            createRoleSearch(request, ca);
            ca.add("jhrq",DateUtil.toDateString(new Date(),DateUtil.getDateFormat()));
            ca.add("jhlb",quicktype);
        }
        if (StringUtil.isNotEmpty(patientType)) {
            ca.add("ncp.patient_type", patientType);
            if("2".equals(patientType) && StringUtil.isNotEmpty(zlType)){
                ca.add("ncp.zl_type", zlType);
            }
        }
        PageList<FollowDto> plist = followService.searchFollowList(buildPage(request), ca);

        model.addAttribute("quicktype", quicktype);//快捷办公查询方式
        model.addAttribute("followList", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("monitorType", NcpConstants.NCP_MONITOR_TYPE_1);
        model.addAttribute("reexamType", NcpConstants.NCP_MONITOR_TYPE_2);
        model.addAttribute("followType", NcpConstants.NCP_MONITOR_TYPE_3);
        return "rhip.ncp.follow.list";
    }


    /**
     * 查看
     * 监测测/复查/随访
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editFollow")
    public String viewAll(@RequestParam("id") Long id, @RequestParam("pid") Long pid, @RequestParam("type") String type, ModelMap model) {
        model.addAttribute("monitorType", NcpConstants.NCP_MONITOR_TYPE_1);
        model.addAttribute("reexamType", NcpConstants.NCP_MONITOR_TYPE_2);
        model.addAttribute("followType", NcpConstants.NCP_MONITOR_TYPE_3);
        model.addAttribute("type", type);
        
        PersonInfo personInfo = platformService.queryPersonalInfo(pid);
        DmDiseaseInfo dmDiseaseInfo= standardizationService.queryDmDiseaseInfo(pid);
        model.put("personInfo", personInfo);
        model.put("dmDiseaseInfo", dmDiseaseInfo);
        model.put("ncpid", id);
        model.put("type", type);
        model.put("currentDate", new Date());
        model.put("oneYearBeforeDate", DateUtil.add(new Date(), Calendar.YEAR, -1));
        return "rhip.ncp.follow.main";
    }

    /***
     *
     * @param ncpId 新冠患者ncp_patient表ID
     * @param type 随访类型1:2:3
     * @param personId person表ID
     * @param planYearStart
     * @param planYearEnd
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/plan")
    public String inputPlanFollowupList(@RequestParam("ncpId") String ncpId, @RequestParam("type") String type, @RequestParam("personId") String personId, @RequestParam(value = "planYearStart", required = false) String planYearStart, @RequestParam(value = "planYearEnd", required = false) String planYearEnd, ModelMap model, HttpServletRequest request) {
        Criteria criteria = new Criteria();
        criteria.add("pid", ncpId);//新冠patien表ID
        criteria.addCriterion(buildPlanYearCriterion("planDate", planYearStart, planYearEnd));
        criteria.add("type", type);
        List<NcpMonitorPlan> list = followService.searchFollowupPlanList(criteria, new Order("PLAN_DATE"));
        if("3".equals(type) && ObjectUtil.isNotEmpty(list)){//每次随访计划都只能在前后30天内随访，超过时间范围不能随访
            for(NcpMonitorPlan ncpMonitorPlan :list){
                if(ObjectUtil.isNotEmpty(ncpMonitorPlan)){
                    boolean notOverTime =isNotOverTime(ncpMonitorPlan.getPlanDate());
                    ncpMonitorPlan.setNotOverTime(notOverTime);
                }
            }
        }
        model.addAttribute("plans", list);
        model.addAttribute("type", type);
        return "rhip.ncp.follow.plan.list";
    }

    private Criterion buildPlanYearCriterion(String property, String planYearStart, String planYearEnd) {
        Date begin;
        Date end;
        if (ObjectUtil.isNullOrEmpty(planYearEnd)) {
            end = DateUtil.lastDateOfYear(new Date());
        } else {
            end = DateUtil.lastDateOfYear(DateUtil.getDateByYear(Integer.valueOf(planYearEnd)));
        }
        if (ObjectUtil.isNullOrEmpty(planYearStart))
            planYearStart = "1900";
        begin = DateUtil.firstDateOfYear(DateUtil.getDateByYear(Integer.valueOf(planYearStart)));
        return new Criterion(property, OP.BETWEEN, new Date[]{begin, end});
    }

    @RequestMapping("/edit")
    public String monitorView(@RequestParam("type") String type,
                              @RequestParam(value = "ncpId", required = false) Long ncpId,
                              @RequestParam(value = "monitorId", required = false) Long monitorId,
                              @RequestParam(value = "planId", required = false) Long planId,
                              ModelMap model, HttpServletRequest request) {
        Assert.notNull(planId, "计划id不能为空");
        Assert.notNull(ncpId, "随访患者id不能为空");
        NcpMonitor monitor = null;
        if(monitorId!=null) {
            monitor = followService.findMonitorById(Long.valueOf(monitorId));
            model.addAttribute("editFlag", "edit");
        }
        else{
            monitor = new NcpMonitor();
            User user = getCurrentUser(request);
            Organization org = getCurrentOrg(request);
            monitor.setMonitorOrg(org.getOrganCode());
            Staff staff = staffService.getStaff(user.getStaffCode());
            if(staff==null){
                logger.error("根据登录账号staffCode("+user.getStaffCode()+")，找不到数据！");
                return null;
            }
            monitor.setMonitorDoctor(user.getStaffCode());
            monitor.setDoctorName(staff.getName());
            monitor.setCreateId(user.getUserCode());//user表userCode
            monitor.setCreateTime(new Date());
            model.addAttribute("editFlag", "add");
        }
        model.addAttribute("monitor", monitor);
        NcpPatient pat = patientService.getNcpPatient(new Criteria("ID",ncpId));
        NcpMonitorPlan ncpMonitorPlan =followService.findMonitorPlanById(planId);
        if(ObjectUtil.isNotEmpty(ncpMonitorPlan)){
            model.addAttribute("planType", ncpMonitorPlan.getPlanType());
        }
        if(pat==null){
            logger.error("根据【NCP_PATIENT】新冠患者ID="+ncpId+"，找不到数据！");
            return null;
        }

//        PersonInfo info= platformService.queryPersonalInfo(personId);
        model.addAttribute("pat", pat);
        model.addAttribute("planId", planId);
        model.addAttribute("type", type);
        return "rhip.ncp.follow.plan.edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    public Object saveMonitor(NcpMonitor monitor, ModelMap model, HttpServletRequest request) {
        Assert.notNull(monitor, "新冠随访表单为空!");
        boolean b = followService.saveMonitor(monitor);
        return b;
    }

    // 新增随访计划
    @RequestMapping("/addPlanData")
    @ResponseBody
    public String addPlanData(@RequestParam(value = "ncpid") Long pid, @RequestParam(value = "type") Integer type,@RequestParam(value = "cardNo") String cardNo, HttpServletRequest request) {
        NcpMonitorPlan plan = new NcpMonitorPlan();
        plan.setCardno(cardNo);
        plan.setPid(BigDecimal.valueOf(pid));
        Date d = new Date();
        plan.setCreateTime(d);
        plan.setPlanDate(DateUtil.getToday().getTime());
        plan.setType(BigDecimal.valueOf(type));
        plan.setCreateStaffCode(getCurrentUser(request).getStaffCode());
        plan.setPlanType("2");//点新增按钮产生的随访都属于计划外随访  1:计划内 2:计划外
        boolean b = followService.saveMonitorPlan(plan);
        if (b)
            return "success";
        else
            return "failure";
        }

        private boolean isNotOverTime(Date date){
            Date beginDate =DateUtil.getMonthsLater(date,-1);
            Date endDate =DateUtil.getDaysLater(date,31);
            Date currentDate =new Date();
            //0193326随访计划生成时间改为以出院时间+4个月，已过期的随访都可以填写，未到计划时间的可以提前一个月录入
            if(currentDate.getTime()>=beginDate.getTime()){
                return true;
            }
            return false;
        }
}
