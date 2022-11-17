package com.founder.rhip.phsr.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.Populace;
import com.founder.rhip.ehr.service.IPopulaceService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanzg on 2017/6/5.
 */
@Controller
@RequestMapping(value = "/population")
public class PopulationController extends BaseController {

    @Resource(name = "populaceService")
    private IPopulaceService populaceService;

    @Autowired
    private IOrganizationApp organizationApp;

    /**
     * 查询界面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/search")
    public String search(HttpServletRequest request, ModelMap model) {
        model.addAttribute("searchDate", new Date());
        return "rhip.phsr.population.search";
    }

    @RequestMapping(value = "/list")
    public String list(HttpServletRequest request, ModelMap model) {
        Populace total = new Populace();
        List<Populace> populaceList = new ArrayList<>();
        Criteria initCriteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
        initCriteria.remove("date");//去除多余的条件
        Organization organization = getCurrentOrg(request);
        if (hasRole(RoleType.Z_GLY, request)) {//站登录
            initCriteria.add("curOrg", organization.getOrganCode());
            initCriteria.add("roleType", RoleType.Z_GLY.getValue());
            initCriteria.add("countTotal", "0");//判断是否为合计
            populaceList = populaceService.getPopolaceReport(initCriteria);
            total = populaceList.get(0);
        }
        if (hasRole(RoleType.ZX_GLY, request)) {//中心登录
            initCriteria.add("curOrg", organization.getOrganCode());
            initCriteria.add("roleType", RoleType.ZX_GLY.getValue());
            initCriteria.add("countTotal", "0");//非合计
            populaceList = populaceService.getPopolaceReport(initCriteria);
            initCriteria.remove("countTotal");
            initCriteria.add("countTotal", "1");//判断是否为合计
            total = populaceService.getPopolaceReport(initCriteria).get(0);
        }
        if (hasRole(RoleType.QWGZX, request)) {//卫管中心登录
            List<Populace> populacesWG = new ArrayList<>();
            Criteria criteria = new Criteria();
            if (initCriteria.contains("parentCode")) {
                initCriteria.add("curOrg", initCriteria.get("parentCode"));
                initCriteria.add("roleType", RoleType.ZX_GLY.getValue());
                initCriteria.add("countTotal", "0");//非合计
                populaceList = populaceService.getPopolaceReport(initCriteria);
                initCriteria.remove("countTotal");
                initCriteria.add("countTotal", "1");//判断是否为合计
                total = populaceService.getPopolaceReport(initCriteria).get(0);
            } else {
                criteria.add("gbCode", getCurrentOrg(request).getGbCode());
                criteria.add("genreCode", "B1");
                List<Organization> organizations = organizationApp.queryOrganization(criteria);
                for (Organization organZX : organizations) {
                    initCriteria.add("roleType", RoleType.ZX_GLY.getValue());
                    initCriteria.add("curOrg", organZX.getOrganCode());
                    initCriteria.add("countTotal", "1");//中心合计
                    populaceList = populaceService.getPopolaceReport(initCriteria);
                    populaceList.get(0).setOrganCode(organZX.getOrganCode());
                    populacesWG.add(populaceList.get(0));
                    initCriteria.remove("curOrg");
                }
                populaceList = populacesWG;
                total = countWGTotal(populaceList);
            }
        }
        if (hasRole(RoleType.ADMIN, request)) {//卫计委登录
            List<Populace> populacesWG = new ArrayList<>();
            List<Populace> pop = new ArrayList<>();
            if (initCriteria.contains("parentCode")) {
                initCriteria.add("curOrg", initCriteria.get("parentCode"));
                initCriteria.add("roleType", RoleType.ZX_GLY.getValue());
                initCriteria.add("countTotal", "0");//非合计
                populaceList = populaceService.getPopolaceReport(initCriteria);
                initCriteria.remove("countTotal");
                initCriteria.add("countTotal", "1");//判断是否为合计
                total = populaceService.getPopolaceReport(initCriteria).get(0);
            }else if(initCriteria.contains("gbCode")) {
                Criteria criteria = new Criteria();
                criteria.add("gbCode", initCriteria.get("gbCode"));
                criteria.add("genreCode", "B1");
                List<Organization> organizations = organizationApp.queryOrganization(criteria);
                for (Organization organZX : organizations) {
                    initCriteria.add("roleType", RoleType.ZX_GLY.getValue());
                    initCriteria.add("curOrg", organZX.getOrganCode());
                    initCriteria.add("countTotal", "1");//中心合计
                    populaceList = populaceService.getPopolaceReport(initCriteria);
                    populaceList.get(0).setOrganCode(organZX.getOrganCode());
                    populacesWG.add(populaceList.get(0));
                    initCriteria.remove("curOrg");
                }
                populaceList = populacesWG;
                total = countWGTotal(populaceList);
            }else {
                Criteria criteria = new Criteria();
                criteria.add("genreCode", "R11");
                List<Organization> organizationWGs = organizationApp.queryOrganization(criteria);
                for(Organization organWG : organizationWGs){
                    criteria.add("gbCode", organWG.getGbCode());
                    criteria.add("genreCode", "B1");
                    List<Organization> organizations = organizationApp.queryOrganization(criteria);
                    for (Organization organZX : organizations) {
                        initCriteria.add("roleType", RoleType.ZX_GLY.getValue());
                        initCriteria.add("curOrg", organZX.getOrganCode());
                        initCriteria.add("countTotal", "1");//中心合计
                        pop = populaceService.getPopolaceReport(initCriteria);
                        populacesWG.add(pop.get(0));
                        initCriteria.remove("curOrg");
                    }
                    total = countWGTotal(populacesWG);
                    total.setOrganCode(organWG.getOrganCode());
                    populaceList.add(total);
                }
                total = countWGTotal(populaceList);
            }
        }


        String countType = initCriteria.get("countType").toString();//查询类型
        model.addAttribute("populace", populaceList);
        model.addAttribute("total", total);
        model.addAttribute("countType", countType);
        return "rhip.phsr.population.list";
    }

    //计算卫管合计
    private Populace countWGTotal(List<Populace> populacesSource) {
        Populace populaceAll = new Populace();
        for (Populace populace : populacesSource) {
            populaceAll.setTotal(populaceAll.getTotal() + populace.getTotal());
            populaceAll.setElderNum(populaceAll.getElderNum() + populace.getElderNum());
            populaceAll.setPhbNum(populaceAll.getPhbNum() + populace.getPhbNum());
            populaceAll.setDiNum(populaceAll.getDiNum() + populace.getDiNum());
            populaceAll.setPsychosisNum(populaceAll.getPsychosisNum() + populace.getPsychosisNum());
            populaceAll.setIdentificationNum(populaceAll.getIdentificationNum() + populace.getPsychosisNum());
            populaceAll.setLiveBirth(populaceAll.getLiveBirth() + populace.getLiveBirth());
            populaceAll.setChildNum(populaceAll.getChildNum() + populace.getChildNum());
            populaceAll.setMaternalNum(populaceAll.getMaternalNum() + populace.getMaternalNum());
        }
        return populaceAll;
    }
}
