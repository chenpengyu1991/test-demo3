package com.founder.rhip.he.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.healtheducation.HePromorion;
import com.founder.rhip.ehr.service.IRemindStatisticsService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.service.IHePromorionService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chen.q on 15-6-8.
 */
@Controller
@RequestMapping(value = "/he/promorion")
public class HePromorionController extends VisitController {

    @Resource(name = "hePromorionService")
    private IHePromorionService hePromorionService;
    @Resource(name="mdmOrganizationService")
    private IOrganizationService organizationService;

    @Resource(name = "remindStatisticsService")
    private IRemindStatisticsService remindStatisticsService;

    @RequestMapping("/search")
    public String search(HttpServletRequest request, ModelMap model) {
      //  model.addAttribute("currentYear",new Date());
        if(hasRole(RoleType.ADMIN, request)) {
            model.addAttribute("ROLE", RoleType.ADMIN.getValue());
        }else{
            model.addAttribute("ROLE", "");
        }
        return "rhip.he.promorion.search";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, HePromorion form, Model model, Integer indexPage){
        int currentPage = Integer.valueOf(indexPage);
        Page page;
        if(!("").equals(indexPage) &&  indexPage!=null){
            page = super.getPage(request, currentPage);
        } else {
            page = new Page(EHRConstants.PAGE_SIZE, 1);
        }
        String promorionTitle=request.getParameter("promorionTitle");
       /* String organCode=request.getParameter("organCode");*/
        Criteria criteria = CriteriaOrganizer.initCriteria(request.getParameterMap(), HePromorion.class, "CREATE_DATE");
        if(StringUtil.isNotEmpty(promorionTitle)){
            criteria.add("PROMORION_TITLE", OP.LIKE, promorionTitle);
        }
        /*if(StringUtil.isNotEmpty(organName)){
        criteria.add("ORGAN_NAME",organName);
        }*/
        PageList<HePromorion> pageList=null;
        Organization organization = getCurrentOrg(request);
        List<String> roles = getCurrentUserRoles(request);
        String roleIds="";
        for(String roId:roles){
            roleIds+=roId+",";
        }
        if(roleIds.contains("01,")){
            pageList = hePromorionService.findHealthPromorion(criteria, page);
        }  else{
            criteria.add("ORGAN_CODE",organization.getOrganCode());
            pageList = hePromorionService.findHealthPromorion(criteria, page);
        }
       model.addAttribute("healthPromorions", pageList.getList());
       model.addAttribute("page", pageList.getPage());
        return "rhip.he.promorion.list";
    }

    @RequestMapping("/add")
    public String add(ModelMap model, Long id, String operatorType) {

        HePromorion healthPromorion = new HePromorion();
        if (ObjectUtil.isNotEmpty(id)) {
            healthPromorion = hePromorionService.getHealthPromorionById(new Criteria("ID", id));
        }
        model.addAttribute("healthPromorion", healthPromorion);
        healthPromorion.setOperatorType(operatorType);

        return "rhip.he.promorion.edit";
    }

    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    public Map<String, Object> saveOrUpdate(HePromorion healthPromorion, HttpServletRequest request) {
        initOrganCode(new ConvertingWrapDynaBean(healthPromorion), request); // 初始化机构代码
        Date nowTime=new Date();
        User user = getCurrentUser(request);
        healthPromorion.setUserCode(user.getId().toString());
        healthPromorion.setUserName(user.getName());
        healthPromorion.setCreateDate(nowTime);
        int ret =0;
        ret = hePromorionService.createHealthPromorion(healthPromorion);

        Organization organization = getCurrentOrg(request);
        Map<String, Object> map = new HashMap<>();
        map.put("result", ret > 0 ? true : false);
        map.put("message", ret > 0 ? "操作成功!" : "操作失败!");
        return map;
    }

    //查看健康宣传详情信息
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id")Long id, ModelMap model) {
        if (ObjectUtil.isNotEmpty(id)) {
            HePromorion healthPromorion = hePromorionService.getHealthPromorionById(new Criteria("ID", id));
            model.addAttribute("healthPromorion", healthPromorion);
        }
        return "rhip.he.promorion.detail";
    }

    /**
     * 设置对应的机构编码
     *
     * @param dynaBean
     * @param request
     */
    protected void initOrganCode(ConvertingWrapDynaBean dynaBean, HttpServletRequest request) {
        if (ObjectUtil.isNullOrEmpty(dynaBean)) {
            return;
        }
        Organization org = getCurrentOrg(request); // 当前登录机构
        dynaBean.set("organCode", org.getOrganCode()); // 机构编码
        dynaBean.set("organName", org.getOrganName()); // 机构名称

    }

    /**
     * 发布和不发布到门户
     *
     * @param request
     * @param model
     * @param id
     * @param operation
     * @return
     */
    @RequestMapping("/status")
    public String publish(HttpServletRequest request, ModelMap model, Long id, String operation) {
        if (ObjectUtil.isNotEmpty(id) && operation.trim().equals("publish")) {
            if (hePromorionService.updateStatus(new Parameters("status", 1), new Criteria("id", id)) > 0)
                return EHRMessageUtil.returnMsg(model, "1");
        } else if (ObjectUtil.isNotEmpty(id) && operation.trim().equals("unpublish")) {
            if (hePromorionService.updateStatus(new Parameters("status", 0), new Criteria("id", id)) > 0)
                return EHRMessageUtil.returnMsg(model, "1");
        }
        return EHRMessageUtil.returnMsg(model, "0");
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request, ModelMap model, Long id) {
        if (ObjectUtil.isNotEmpty(id)) {
            if (hePromorionService.delete(new Criteria("ID", id)) > 0)
                return EHRMessageUtil.returnMsg(model, 1);
        }
        return EHRMessageUtil.returnMsg(model, 0);
    }

}
