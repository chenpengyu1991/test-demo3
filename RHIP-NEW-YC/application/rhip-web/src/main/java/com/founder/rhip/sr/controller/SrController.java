package com.founder.rhip.sr.controller;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.*;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.sr.SrScientificResearch;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.controller.StaffController;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IOrganizationService;
import com.founder.rhip.mdm.service.IStaffService;
import com.founder.rhip.sr.controller.form.SrQueryForm;
import com.founder.rhip.sr.controller.form.SrStaffQueryForm;
import com.founder.rhip.sr.service.ISrService;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/sr")
public class SrController extends BaseController {

    @Resource(name = "srService")
    private ISrService srService;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    @Resource(name = "mdmStaffService")
    private IStaffService staffService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @RequestMapping("/search")
    public String search() {
        return "rhip.sr.search";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, ModelMap modelMap, int pageIndex, SrQueryForm form, String idCard, String type, String organCode) {
        String technical = form.getTechnical();//职称等级
        Page page = super.getPage(request, pageIndex);
        Criteria criteria = form.toCriteria();
        if(StringUtil.isNotEmpty(idCard)){
            criteria = criteria.add("BELONG_NAME",OP.LIKE, idCard);
        }
        if(StringUtil.isNotEmpty(organCode)){
            Criteria caCenter = new Criteria("BELONG_ORGAN_CODE", organCode);
            Criteria caStation = new Criteria("BELONG_CENTER_CODE", organCode);
            caCenter.add(LOP.OR, caStation);
            criteria = criteria.add(caCenter);
        }
        if(hasRole(RoleType.ZX_GLY, request)){
            criteria.add("CREATE_ORGAN_CODE", getCurrentOrg(request).getOrganCode());
        }
        if(StringUtil.isNullOrEmpty(technical)){
            PageList<SrScientificResearch> list = srService.getPageList(page, criteria);
            modelMap.addAttribute("srList", list.getList());
        }else{//按职称等级查询
            List techMap = new ArrayList();
            if("1".equals(technical)){//初级-->师级（助理）、士级
                techMap.add("4");
                techMap.add("5");
            }
            if("2".equals(technical)){//中级-->中级
                techMap.add("3");
            }
            if("3".equals(technical)){//高级-->正高、副高
                techMap.add("1");
                techMap.add("2");
            }
            StringBuilder sql = new StringBuilder("SELECT * FROM SR_SCIENTIFIC_RESEARCH");
            List<Staff> staffs = staffService.queryStaff(new Criteria("TECHNICAL", OP.IN, techMap));//获取该等级的所有staff
            String techSql = "";
            for(int i=0; i<staffs.size(); i++){
                if(i == 0){
                    techSql = techSql + " BELONG_NAME LIKE '%" + staffs.get(i).getIdCard() + "%'" ;
                }else{
                    techSql = techSql + " OR BELONG_NAME LIKE '%" + staffs.get(i).getIdCard() + "%'" ;
                }
            }

            SqlBuilder.buildWhereStatement(Staff.class, sql, criteria);

            if(sql.indexOf("WHERE") != -1){
                sql = sql.append(" AND (" + techSql + ")");
            }else {
                sql = sql.append(" WHERE " + techSql);
            }
            PageList<SrScientificResearch> list = srService.getPageListBySql(page, sql.toString(), criteria);
            modelMap.addAttribute("srList", list.getList());
        }

        modelMap.addAttribute("page", page);
        modelMap.addAttribute("type", type);
        modelMap.addAttribute("pageIndex", pageIndex);
        return "rhip.sr.list";
    }

    @RequestMapping("/initSrEdit")
    public String edit(HttpServletRequest request, ModelMap modelMap, Long id) {
        if (id != null) {
            SrScientificResearch scientificResearch = srService.getSrScientificResearch(new Criteria("id", id));
            modelMap.addAttribute("sr", scientificResearch);
            if(StringUtil.isNotEmpty(scientificResearch.getBelongName())){
                modelMap.addAttribute("belongFlag", "1");
            }else {
                modelMap.addAttribute("belongFlag", "2");
            }
        }
        return "rhip.sr.edit";
    }

    @RequestMapping("/save")
    @ResponseBody
    public ModelMap save(HttpServletRequest request, SrScientificResearch srScientificResearch, String srType,String belong, String belongName, String belongOrganCode, String belongCenterCode, String belongGbCode) {
        ModelMap modelMap = new ModelMap();
        srScientificResearch.setSrType(srType);
        if ("1".equals(belong)) {//个人
            srScientificResearch.setBelongName(belongName);
            srScientificResearch.setBelongGbCode(null);
            srScientificResearch.setBelongCenterCode(null);
            srScientificResearch.setBelongOrganCode(null);
        }
        if ("2".equals(belong)) {//机构
            srScientificResearch.setBelongName(null);
            srScientificResearch.setBelongGbCode(belongGbCode);
            srScientificResearch.setBelongCenterCode(belongCenterCode);
            srScientificResearch.setBelongOrganCode(belongOrganCode);
        }
        actionRecord(request, srScientificResearch);
        srScientificResearch.setIsDelete(0);
        try {
            int result = srService.save(srScientificResearch);
            if (result != 0) {
                modelMap.addAttribute("success", true);
                modelMap.addAttribute("message", "保存成功！");
            } else {
                modelMap.addAttribute("success", false);
                modelMap.addAttribute("message", "保存失败！");
            }
        } catch (Exception e) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("message", "保存失败！" + e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ModelMap delete(HttpServletRequest request, Long id) {
        ModelMap modelMap = new ModelMap();
        try {
            int result = srService.delete(new Criteria("ID", id));
            if (result != 0) {
                modelMap.addAttribute("success", true);
                modelMap.addAttribute("message", "删除成功！");
            } else {
                modelMap.addAttribute("success", false);
                modelMap.addAttribute("message", "删除失败！");
            }
        } catch (Exception e) {
            modelMap.addAttribute("success", false);
            modelMap.addAttribute("message", "删除失败！" + e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping("/view")
    public String view(ModelMap modelMap, Long id) {
        SrScientificResearch scientificResearch = srService.getSrScientificResearch(new Criteria("id", id));
        modelMap.addAttribute("sr", scientificResearch);
        return "rhip.sr.view";
    }

    @RequestMapping("/staffSearch")
    public String personManage(ModelMap model, HttpServletRequest request, String html) {
        StaffController.StaffSearchForm condition = new StaffController.StaffSearchForm();
        model.addAttribute("condition", condition);
        model.addAttribute("html", html);
        addByZX(model, request);
        return "rhip.sr.staffSearch";
    }

    @RequestMapping("/staffList")
    public String staffList(int indexPage, ModelMap model, HttpServletRequest request, SrStaffQueryForm srStaffQueryForm) {
        Page page = super.getPage(request, indexPage);
        // convert condition to criteria
//        Record record = new Record(condition);
//        Set<Map.Entry<String, Object>> entrySet = record.entrySet();
//        Criteria criteria = new Criteria();
//        for (Map.Entry<String, Object> entry : entrySet) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            if (ObjectUtil.isNotEmpty(value)) {
//                if (key.equals("name")) {
//                    criteria.add("name", OP.LIKE, value);
//                } else {
//                    criteria.add(key, value);
//                }
//            }
//        }
//        //中心登录
//        Organization currentOrg = SecurityUtils.getCurrentOrganization(request);
//        if ("B1".equals(currentOrg.getGenreCode()) && !criteria.contains("organCode")) {
//            List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", currentOrg.getOrganCode()));
//            List<String> codeList = new ArrayList<>();
//            for (Organization org : orgList) {
//                codeList.add(org.getOrganCode());
//            }
//            codeList.add(currentOrg.getOrganCode());
//            criteria.add("organCode", OP.IN, codeList);
//        }
        PageList<Staff> list = staffService.queryStaff(page, srStaffQueryForm.getCriteria());
        model.addAttribute("staffList", list.getList());
        model.addAttribute("page", list.getPage());
        model.addAttribute("indexPage", indexPage);
        return "rhip.sr.staffList";
    }

    private void addByZX(ModelMap model, HttpServletRequest request) {
        if (hasRole(RoleType.ZX_GLY, request)) {
            List<Organization> orgList = new ArrayList<>();
            Organization org = getCurrentOrg(request);
            orgList.add(org);
            orgList.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, org.getOrganCode())));
            model.addAttribute("orgList", orgList);
        }
    }

    private void actionRecord(HttpServletRequest request, Object entity) {
        BeanMap beanMap = BeanMap.create(entity);
        User user = getCurrentUser(request);
        Organization org = getCurrentOrg(request);
        Date date = new Date();

        beanMap.put("createUserCode", user.getUserName());
        beanMap.put("createOrganCode", org.getOrganCode());
        beanMap.put("createDate", date);

        beanMap.put("updateUserCode", user.getUserName());
        beanMap.put("updateOrganCode", org.getOrganCode());
        beanMap.put("updateDate", date);
    }

    @RequestMapping("/getDicList")
    private void getDicList(String dicCode, HttpServletResponse response, HttpServletRequest request) {
        List<DicItem> dicItems = dictionaryApp.queryDicItem(dicCode);
        StringBuffer buffer = new StringBuffer();

        for (DicItem item : dicItems) {
            buffer.append("<option title=\"" + item.getItemName() + "\" value='" + item.getItemCode() + "'>" + item.getItemName() + "</option>");
        }
        MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString() : "", response);
    }
}