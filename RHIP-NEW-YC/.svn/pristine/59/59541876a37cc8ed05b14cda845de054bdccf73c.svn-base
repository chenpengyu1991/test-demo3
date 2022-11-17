package com.founder.rhip.ehr.controller.child;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.DeathMedicineCertificate;
import com.founder.rhip.ehr.service.IDeathMedicineCertificateService;
import com.founder.rhip.ihm.controller.form.DeathMedicineCertificateForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 儿童死亡报告卡
 *
 * @author Kevin Ro 2017-3-25
 */
@Controller
@RequestMapping("/childDeathReport")
public class ChildDeathReportController extends BaseController {

    @Autowired
    private IOrganizationApp organizationApp;

    @Resource(name = "deathMedicineCertificateService")
    private IDeathMedicineCertificateService deathMedicineCertificateService;

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    @Autowired
    private IDictionaryApp dictionaryApp;

    @RequestMapping("/search")
    public String search(Model model) {
        Page page = new Page(0, 0);
        model.addAttribute("pageIndex", page);
        model.addAttribute("page", page);
        return "rhip.ehr.child.death.search";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, ModelMap model, DeathMedicineCertificateForm form) {
        int currentPage = Integer.valueOf(request.getParameter("indexPage"));
        Page page = super.getPage(request, currentPage);
        Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX, request) || hasRole(RoleType.ADMIN, request);
        List<String> orgCodes = this.getOrgCodeByOrgCode(request);
        Order order = new Order("id", false);
        Criteria ca = form.getCriteria();
        ca.add("isDelete", OP.NE, "1");
        ca.add("personType",OP.EQ,EHRConstants.PERSON_TYPE_ET);//查询死亡登记表设置人群分类为儿童的数据
        if (flg) {
            if (ObjectUtil.isNotEmpty(form.getOrganCode())) {
                ca.add("fillOrganCode", form.getOrganCode());
            } else if (ObjectUtil.isNotEmpty(orgCodes)) {
                ca.add("fillOrganCode", OP.IN, orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(form.getOrganCode())) {
                ca.add("fillOrganCode", form.getOrganCode());
            } else if (ObjectUtil.isNotEmpty(orgCodes)) {
                ca.add("fillOrganCode", OP.IN, orgCodes);
            }
        }

        PageList<DeathMedicineCertificate> pagelist = deathMedicineCertificateService.queryList(ca, page, order);
        model.addAttribute("deathMedicineCertificateList", pagelist.getList());
        model.addAttribute("page", pagelist.getPage());
        return "rhip.ehr.child.death.list";
    }

    @RequestMapping("/view")
    public String view(String id, Model model) {
        Criteria criteria = new Criteria("ID", id);
        DeathMedicineCertificate deathMedicineCertificate = deathMedicineCertificateService.getDeathMedicineCertificate(criteria);
        if (ObjectUtil.isNullOrEmpty(deathMedicineCertificate)) {
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("deathMedicineCertificate", deathMedicineCertificate);
        return "rhip.ehr.child.death.view";
    }

    /**
     * 新增或编辑页面的跳转
     */
    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, String id, Model model) {
        DeathMedicineCertificate deathMedicineCertificate = null;
        if (ObjectUtil.isNotEmpty(id)) { // id不为空，说明此时为编辑
            Criteria criteria = new Criteria("ID", id);
            deathMedicineCertificate = deathMedicineCertificateService.getDeathMedicineCertificate(criteria);
            model.addAttribute("fillOrganName", deathMedicineCertificate.getFillOrganName()); // 创建单位(机构名称)
            model.addAttribute("fillOrganCode", deathMedicineCertificate.getFillOrganCode()); // 创建单位(机构编码)
            if (ObjectUtil.isNullOrEmpty(deathMedicineCertificate)) {
                return "rhip.ehr.browser.error";
            }
        } else { // 新增
            deathMedicineCertificate = new DeathMedicineCertificate();
            // 查询当前登陆者所属于的机构
            Organization org = getCurrentOrg(request);
            model.addAttribute("fillOrganName", org.getOrganName()); // 创建单位(机构名称)
            model.addAttribute("fillOrganCode", org.getOrganCode()); // 创建单位(机构编码)
            deathMedicineCertificate.setFillTime(new Date());
            User user = getCurrentUser(request); // 当前登陆者的姓名
            deathMedicineCertificate.setFillUserName(user.getName());
        }
        model.addAttribute("deathMedicineCertificate", deathMedicineCertificate);
        return "rhip.ehr.child.death.edit";
    }

    /**
     * ajax查询儿童分类编号
     */
    @ResponseBody
    @RequestMapping("/queryCategoryNo")
    public void queryCategoryNo(String categoryNo, HttpServletResponse response, HttpServletRequest request) {
        List<DicItem> items = dictionaryApp.queryDicItem("YC201702");
        StringBuffer buffer = new StringBuffer("<option title=\"请选择\" value=\"\">请选择</option>");
        for (DicItem item : items) {
            String code = item.getItemCode();
            String name = item.getItemName();
            if (ObjectUtil.isNotEmpty(categoryNo) && code.equals(categoryNo)) {
                buffer.append("<option selected=\"selected\" title=\"" + name + "\" value='" + code + "'>" + name + "</option>");
            } else {
                buffer.append("<option title=\"" + name + "\" value='" + code + "'>" + name + "</option>");
            }
        }
        MessageUtils.outputJSONResult(ObjectUtil.isNotEmpty(buffer.toString()) ? buffer.toString() : "empty", response);
    }

    @ResponseBody
    @RequestMapping("/save")
    public Map<String, Object> save(@ModelAttribute DeathMedicineCertificate deathMedicineCertificate, String birthday, String deathDate) {
        Map<String, Object> result = new HashMap<String, Object>();
        int rs = 0;
        deathMedicineCertificate.setBirthday(DateUtil.parseSimpleDate(birthday, "yyyy/MM/dd HH:mm"));
        deathMedicineCertificate.setDeathDate(DateUtil.parseSimpleDate(deathDate, "yyyy/MM/dd HH:mm"));
        deathMedicineCertificate.setIsDelete(0);
        deathMedicineCertificate.setPersonType(EHRConstants.PERSON_TYPE_ET);//死亡登记表设置人群分类为儿童
        if (StringUtil.isEmpty(deathMedicineCertificate.getIsAdd())) deathMedicineCertificate.setIsAdd("0");
        try {
            if (ObjectUtil.isNotEmpty(deathMedicineCertificate.getId())) { // 不为空，为更新
                rs = deathMedicineCertificateService.update(deathMedicineCertificate);
            } else {
                rs = deathMedicineCertificateService.save(deathMedicineCertificate);
            }
            if (rs > 0) { // 保存或更新成功
                result.put("success", true);
            } else {
                result.put("success", false);
            }
        } catch (Exception e) {
            logger.error("保存或更新儿童死亡报告卡失败", e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    /**
     * 删除，修改isDelete的值为1即可，仅作物理删除，不做逻辑删除
     *
     * @param id
     */
    @ResponseBody
    @RequestMapping("/delete")
    public String delete(String id) {
        DeathMedicineCertificate deathMedicineCertificate = deathMedicineCertificateService.getDeathMedicineCertificate(new Criteria("id", id));
        deathMedicineCertificate.setIsDelete(1);
        int num = deathMedicineCertificateService.deleteChildDeath(deathMedicineCertificate);
        String str = "";
        if (num == 0) {
            str = "删除失败!";
        } else if (num == 1) {
            str = "删除成功!";
        }
        return str;
    }
}
