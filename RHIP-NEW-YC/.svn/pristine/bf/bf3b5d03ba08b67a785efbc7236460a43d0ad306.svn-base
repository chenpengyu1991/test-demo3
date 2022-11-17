package com.founder.rhip.ihm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.sr.SrScientificResearch;
import com.founder.rhip.sr.controller.form.SrQueryForm;
import com.founder.rhip.sr.service.ISrService;

@Controller
@RequestMapping(value = "/ihm/sr")
public class SrTargetController extends BaseController {

    @Resource(name = "srService")
    private ISrService srService;

    @RequestMapping("/search")
    public String search() {
        return "ihm.sr.search";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request, ModelMap modelMap, int pageIndex, SrQueryForm form, String idCard, String type, String organCode) {
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
        PageList<SrScientificResearch> list = srService.getPageList(page, criteria);
        modelMap.addAttribute("srList", list.getList());
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("type", type);
        modelMap.addAttribute("pageIndex", pageIndex);
        return "ihm.sr.list";
    }


    @RequestMapping("/view")
    public String view(ModelMap modelMap, Long id) {
        SrScientificResearch scientificResearch = srService.getSrScientificResearch(new Criteria("id", id));
        modelMap.addAttribute("sr", scientificResearch);
        return "ihm.sr.view";
    }
}