package com.founder.rhip.finance.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.finance.FcPubFinanceDetails;
import com.founder.rhip.ehr.entity.finance.FcPubFinanceInfo;
import com.founder.rhip.ehr.entity.sr.SrScientificResearch;
import com.founder.rhip.finance.controller.form.FinanceQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import com.founder.rhip.service.IFinanceService;
import com.founder.rhip.sr.service.ISrService;

import net.sf.cglib.beans.BeanMap;

@Controller
@RequestMapping(value = "/finance")
public class FinanceController extends BaseController {

    @Resource(name = "financeService")
    private IFinanceService financeService;

    @Resource(name = "srService")
    private ISrService srService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;
    
    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    /**
     * 公立医院收支情况表 查询
     * @param model
     * @return
     */
    @RequestMapping("/searchPubFinanceInfo")
    public String search(Model model) {
        model.addAttribute("type", "PubFinanceInfo");
        model.addAttribute("searchUrl", "/finance/pubFinanceInfoList");
        model.addAttribute("listpath", "pubFinanceInfoList.jsp");
        return "rhip.finance.searchPub";
    }

    @RequestMapping("/pubFinanceInfoList")
    public String list(HttpServletRequest request, ModelMap modelMap, FinanceQueryForm form) {
        Criteria criteria = form.toCriteria();

        List<FcPubFinanceInfo> resultList = financeService.getPubFinanceInfoList(criteria);
        modelMap.addAttribute("resultList", resultList);
        return "rhip.finance.pubFinanceInfoList";
    }

    
    /**
     * 公立医院收支明细
     *
     * @param model
     * @return
     */
    @RequestMapping("/searchPubFinanceDetails")
    public String searchDetails(Model model, HttpServletRequest request) {
        model.addAttribute("type", "PubFinanceDetails");
        model.addAttribute("searchUrl", "/finance/pubFinanceDetailsList");
        model.addAttribute("listpath", "pubFinanceDetailsList.jsp");
        return "rhip.finance.searchPub";
    }

    @RequestMapping("/pubFinanceDetailsList")
    public String detailsList(HttpServletRequest request, ModelMap modelMap, FinanceQueryForm form) {
        List<FcPubFinanceDetails> resultList = new ArrayList();
        Criteria criteria = form.toCriteria();
        Criteria criteriaL = form.toLastCriteria();
        String isAdmin = "F";
        if (!hasRole(RoleType.ADMIN, request)) {
            criteria.add("organCode", getCurrentOrg(request).getOrganCode());
            criteriaL.add("organCode", getCurrentOrg(request).getOrganCode());
        }else{
            isAdmin = "T";
           /* criteria.add("isSubmit", 1);
            criteriaL.add("isSubmit", 1);*/
        }
        List<FcPubFinanceDetails> resultListNow = financeService.getPubFinanceDetailsList(criteria);
        List<FcPubFinanceDetails> resultListL = financeService.getPubFinanceDetailsList(criteriaL);

        //admin查看所有机构
        if (hasRole(RoleType.ADMIN, request)) {
        	//梅李人民医院，支塘人民医院算入公立医院报表中
            Criteria criteriaOrgan = new Criteria();
            criteriaOrgan.add("GENRE_CODE", "A1");
            criteriaOrgan.add("SUBSID", 0);
            String orgList[]={"320003282","320003263"};
            criteriaOrgan.add(LOP.OR, "organCode",OP.IN,orgList);
            List<Organization> organs = organizationService.getOrganizations(criteriaOrgan);
//            organs = sortOrg(organs);
            for (int n = 0; n < organs.size(); n++) {
                String organ = organs.get(n).getOrganCode().toString();
                Boolean b = false;
                for (int i = 0; i < resultListNow.size(); i++) {
                    FcPubFinanceDetails resultNow = resultListNow.get(i);
                    String organCode = resultNow.getOrganCode();
                    if (organCode.equals(organ)) {
                        resultList.add(resultNow);
                        b = true;
                        break;
                    }
                }
                if (b == false) {
                    FcPubFinanceDetails result = new FcPubFinanceDetails();
                    result.setOrganCode(organ);
                    resultList.add(result);
                }
                for (int j = 0; j < resultListL.size(); j++) {
                    FcPubFinanceDetails resultL = resultListL.get(j);
                    String organCodeL = resultL.getOrganCode();
                    if (organCodeL.equals(organ)) {
                        resultList.add(resultL);
                        break;
                    }
                }
                if (resultList.size() % 3 == 1) {
                    resultList.add(null);
                }
                resultList.add(null);
            }
        } else {//填写机构只能查看自己机构
            if (ObjectUtil.isNotEmpty(resultListNow)) {
                resultList.add(resultListNow.get(0));
            } else {
                FcPubFinanceDetails fcPubFinanceDetails = new FcPubFinanceDetails();
                fcPubFinanceDetails.setOrganCode(getCurrentOrg(request).getOrganCode());
                resultList.add(fcPubFinanceDetails);
            }
            if (ObjectUtil.isNotEmpty(resultListL)) {
                resultList.add(resultListL.get(0));
            } else {
                FcPubFinanceDetails fcPubFinanceDetails = new FcPubFinanceDetails();
                fcPubFinanceDetails.setOrganCode(getCurrentOrg(request).getOrganCode());
                resultList.add(fcPubFinanceDetails);
            }
            FcPubFinanceDetails fcPubFinanceDetails = new FcPubFinanceDetails();
            fcPubFinanceDetails.setOrganCode(getCurrentOrg(request).getOrganCode());
            resultList.add(fcPubFinanceDetails);
        }
        modelMap.addAttribute("year", getYearMonth(form).get("year"));
        modelMap.addAttribute("month", getYearMonth(form).get("month"));
        modelMap.addAttribute("resultList", resultList);
        modelMap.addAttribute("isAdmin", isAdmin);
        return "rhip.finance.pubFinanceDetailsList";
    }
    
    
    @RequestMapping("/initAddPubFinanceInfo")
    public String edit(HttpServletRequest request, ModelMap modelMap, Long id) {
        return "rhip.finance.addPubFinanceInfo";
    }

    @RequestMapping("/savePubFinanceInfo")
    @ResponseBody
    public ModelMap save(HttpServletRequest request, FcPubFinanceInfo fcPubFinanceInfo) {
        ModelMap modelMap = new ModelMap();
        try {
            int result = financeService.savePubFinanceInfo(fcPubFinanceInfo);
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

    private Map getYearMonth(FinanceQueryForm form) {
        Map result = new HashMap();
        String year = form.getYearMonth().substring(0, 4);
        String month = form.getYearMonth().substring(5, 7);
        if (month.startsWith("0")) {
            month = month.substring(1, 2);
        }
        result.put("year", year);
        result.put("month", month);
        return result;
    }

    private BigDecimal calcYearOnYear(BigDecimal n1, BigDecimal n2) {
        return ((n1.divide(n2)).subtract(BigDecimal.valueOf(1))).multiply(BigDecimal.valueOf(100));
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