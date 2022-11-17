package com.founder.rhip.idm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmNcp;
import com.founder.rhip.idm.service.IIdmNcpService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 新冠肺炎防控
 */
@Controller
@RequestMapping("/idm/ncp")
public class NCPController extends BaseController {

    @Resource(name = "idmNcpService")
    private IIdmNcpService idmNcpService;

    /**
     * 进入查询
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/emc/search")
    public String tempSearch(HttpServletRequest request,ModelMap model) {
        model.addAttribute("emcFlag", "1");
        return "rhip.idm.ncp.emc.search";
    }
    /**
     * 进入查询结果
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/emc/list")
    public String emcList(HttpServletRequest request, ModelMap model, Integer indexPage, IdmNcp idmNcp) {
        Page page = super.getPage(request, indexPage);
        Criteria criteria = getCriteria(idmNcp);
        int flag = 1;
        PageList<IdmNcp> idmNcpList = idmNcpService.getIdmNcpPageList(criteria, page);
        model.addAttribute("idmNcpList", idmNcpList.getList());
        model.addAttribute("page", idmNcpList.getPage());
        if(ObjectUtil.isNullOrEmpty(idmNcpList.getList())) {
            flag = 0;
        }
        model.addAttribute("emcFlag", flag);
        return "rhip.idm.ncp.emc.list";
    }

    private Criteria getCriteria(IdmNcp idmNcp) {
        Criteria criteria = new Criteria();
        if(ObjectUtil.isNotEmpty(idmNcp.getName()) && ObjectUtil.isNullOrEmpty(idmNcp.getIdcard())) {
            criteria.add("name", OP.LIKE, idmNcp.getName());
        } else if(ObjectUtil.isNotEmpty(idmNcp.getName()) && ObjectUtil.isNotEmpty(idmNcp.getIdcard())) {
            criteria.add("name", idmNcp.getName());
        }
        if(ObjectUtil.isNotEmpty(idmNcp.getIdcard())) {
            criteria.add("idcard", idmNcp.getIdcard());
        }
        if(ObjectUtil.isNotEmpty(idmNcp.getSurveyResult())) {
            criteria.add("survey_result", idmNcp.getSurveyResult());
        }
        return criteria;
    }
}