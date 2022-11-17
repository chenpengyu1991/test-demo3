package com.founder.rhip.ech.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ech.controller.form.EchManageQueryForm;
import com.founder.rhip.ech.service.IEchStatisticsService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.service.child.IChildHealthExamineService;
import com.founder.rhip.hm.service.IPhysicalExamRecordService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/ech/children")
public class EchChildrenController extends BaseController {

    @Resource
    private IPhysicalExamRecordService physicalExamRecordService;

    @Resource(name = "echStatisticsService")
    private IEchStatisticsService echStatisticsService;

    @Resource
    private IChildHealthExamineService childHealthExamineService;

    @Autowired
    private IOrganizationApp organizationApp;

    @RequestMapping("/init")
    public String childrenGuideInit(ModelMap model, HttpServletRequest request) {
        return "rhip.ech.childrenGuide.init";
    }

    /**
     * 查询儿童中医体质辨识
     */
    @RequestMapping("/list")
    public String search(EchManageQueryForm form, ModelMap model, HttpServletRequest request, int indexPage) {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(form.getName())) {
            criteria.add("name", OP.LIKE, form.getName());
        }
        if (StringUtil.isNotEmpty(form.getIdcard())) {
            criteria.add("idCard", form.getIdcard().toUpperCase());
        }
        if (StringUtil.isNotEmpty(form.getInputOrganCode())) {
            criteria.add("createOrganCode", form.getInputOrganCode());
        } else {
            List<String> orgCodes = this.getOrgCodeByOrgCode(request);
            if (ObjectUtil.isNotEmpty(orgCodes)) {
                criteria.add("createOrganCode", OP.IN, orgCodes);
            }
        }
        criteria.add("isDelete", EHRConstants.DELETE_FLG_0);
        Page page = super.getPage(request, indexPage);
        criteria.add("tcmHealthManageService", OP.UEMPTY, "");
        PageList<ChildHealthExamination> list = childHealthExamineService.getPageChildExamine(criteria, page, new Order("VISIT_DATE", false));
        model.addAttribute("childHeathExamination", list.getList());
        model.addAttribute("page", list.getPage());
        return "rhip.ech.childrenGuide.list";
    }


    /**
     * 编辑和新建儿童中医体质辨识
     */
    @RequestMapping("/report")
    public String report(String examRecordId, String examFlag, HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
        String url = "rhip.ech.childrenGuide.edit";
        modelMap.addAttribute("type", examFlag);
        if("view".equals(examFlag)){
            url = "rhip.ech.childrenGuide.view";
        }
        if (StringUtil.isNullOrEmpty(examRecordId)) {
            ChildHealthExamination childHealthExamination = new ChildHealthExamination();
            childHealthExamination.setcPhysicalExamAge("2");
            modelMap.addAttribute("exam", childHealthExamination);
            return url;
        } else {
            ChildHealthExamination childHealthExamination = childHealthExamineService.getChildHealthExam(new Criteria("id", examRecordId));
            modelMap.addAttribute("exam", childHealthExamination);
            return url;
        }
    }

    /**
     * 编辑和新建儿童中医体质辨识
     */
    @RequestMapping("/save")
    @ResponseBody
    public Map<String, Object> saveReport(ChildHealthExamination childHealthExamination, HttpServletRequest request, HttpServletResponse response,
                                          ModelMap modelMap) {
        Map<String, Object> result = new HashMap<>();
        //创建机构
        Organization organization = getCurrentOrg(request);
        childHealthExamination.setIsDelete(Short.valueOf("0"));
        childHealthExamination.setCreateOrganCode(organization.getOrganCode());
        childHealthExamination.setCreateOrganName(organization.getOrganName());
        childHealthExamination.setCreateSuperOrganCode(organization.getParentCode());
        childHealthExamination.setCreateGbCode(organization.getGbCode());
        //性别和出生年月
        if (StringUtil.isNotEmpty(childHealthExamination.getIdCard())) {
            childHealthExamination.setGender(IDCardUtil.getGenderByIdCard(childHealthExamination.getIdCard()));
            childHealthExamination.setBirthday(IDCardUtil.getBirthDateByIdCard(childHealthExamination.getIdCard()));
        }
        if (ObjectUtil.isNullOrEmpty(childHealthExamination.getId())) {
            childHealthExamineService.addChildrenEchExam(childHealthExamination);
        } else {
            childHealthExamineService.updateChildHealthExam(childHealthExamination);
        }
        result.put("success", true);
        return result;
    }


    /**
     *
     * @param cPhysicalExamAge
     * @param modelMap
     * @return
     */
    @RequestMapping("/changeAge")
    public String changeAge(String cPhysicalExamAge, ModelMap modelMap) {
        String url = "rhip.ech.childrenGuide.edit";
        ChildHealthExamination childHealthExamination = new ChildHealthExamination();
        childHealthExamination.setcPhysicalExamAge(cPhysicalExamAge);
        modelMap.addAttribute("type", "edit");
        modelMap.addAttribute("exam", childHealthExamination);
        return url;
    }

    /**
     *
     */
    @RequestMapping("/delReport")
    @ResponseBody
    public int delReport(String reportId){
        return childHealthExamineService.deleteChildHealthExam(Integer.parseInt(reportId));
    }

    @RequestMapping("/printChildHealthCare")
    public String printChildHealthCare(ModelMap model, String type) {
        model.addAttribute("type", type);
        return "rhip.ech.childrenGuide.printChildHealthCare";
    }
}
