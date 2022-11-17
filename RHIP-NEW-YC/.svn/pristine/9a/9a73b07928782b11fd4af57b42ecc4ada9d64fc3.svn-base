package com.founder.rhip.phsr.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.InfectEmergencies;
import com.founder.rhip.ehr.repository.statistics.IInfectiousEmergenciesDao;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.he.controller.VisitController;
import com.founder.rhip.ihm.service.IInfectiousEmergenciesService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IOrganizationDao;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yuanzg on 2017/5/8.
 */
@Controller
@RequestMapping(value = "/infectEmergencies")
public class InfectiousEmergenciesController extends BaseController {

    @Resource(name = "infectiousEmergenciesService")
    private IInfectiousEmergenciesService infectiousEmergenciesService;

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    @Resource(name = "infectEmergenciesDao")
    private IInfectiousEmergenciesDao infectiousEmergenciesDao;

    @Resource(name = "mdmOrganizationDao")
    private IOrganizationDao organizationDao;

    /**
     * 传染病及突发公共卫生事件查询界面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/search")
    public String Search(HttpServletRequest request, ModelMap model) {
        //判断机构
        String roleType = "";
        if (hasRole(RoleType.Z_GLY, request)) {
            roleType = RoleType.Z_GLY.getValue();
        }
        if (hasRole(RoleType.ZX_GLY, request)) {
            roleType = RoleType.ZX_GLY.getValue();
        }
        try {
            int year = new Date().getYear() + 1900;
            SimpleDateFormat sd = new SimpleDateFormat("yyyy");
            Date date = sd.parse(String.valueOf(year));
            model.addAttribute("searchDate", date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("roleType", roleType);
        return "rhip.phsr.infectEmergencies.search";
    }

    /**
     * 传染病及突发公共卫生事件列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String List(HttpServletRequest request, ModelMap model, InfectEmergencies initInfectEmer) {
        Criteria initCriteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
        String centerOrgCode = (String) initCriteria.get("centerOrgCode");
        CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        String initGbCode = (String) initCriteria.get("gbcode");
        String roleType = "";
        String currentOrgName = "";
        String currentOrgCode = "";
        //获取当前机构
        Organization organization = getCurrentOrg(request);
        if (ObjectUtil.isNotEmpty(organization)) {
            currentOrgName = organization.getOrganName();
            currentOrgCode = organization.getOrganCode();
        }
        String gbcode = organization.getGbCode();
        //获取查询条件
        String countType = initInfectEmer.getCountType();
        String searchOrg = initInfectEmer.getOrgCode();
        int year = 0;
        if (ObjectUtil.isNullOrEmpty(initInfectEmer.getYear())) {
            year = new Date().getYear() + 1900;
        } else {
            year = initInfectEmer.getYear();
        }
        Criteria criteria = new Criteria();
        //判断机构
        if (hasRole(RoleType.ZX_GLY, request)) {//中心
            roleType = RoleType.ZX_GLY.getValue();
            //获取中心以及下属站的所有数据
            List<InfectEmergencies> infectEmergenciesList = infectiousEmergenciesService.getInfectEmerOrgList(searchOrg, countType, currentOrgCode, year, initInfectEmer.getQuarter());
            InfectEmergencies infectEmergenciZX = infectiousEmergenciesService.getInfectEmerGency(new Criteria("orgCode", currentOrgCode).add("year", year).add("quarter", initInfectEmer.getQuarter()));
            if (ObjectUtil.isNotEmpty(infectEmergenciZX)) {
                model.addAttribute("infectEmergencies", infectEmergenciZX);
            }
            //计算单个中心及下属站数据总和
            Map<String, Object> map = infectiousEmergenciesService.CountZXTotal(currentOrgCode, year, initInfectEmer.getQuarter());
            InfectEmergencies infectTotal = setField(map);
            /*infectEmergenciesList.add(infectTotal);*/
            //合计一栏
            if (StringUtil.isNotEmpty(searchOrg)) {
                infectTotal = infectiousEmergenciesService.getInfectEmerGency(new Criteria("orgCode", searchOrg).add("year", year).add("quarter", initInfectEmer.getQuarter()));
                if (ObjectUtil.isNullOrEmpty(infectTotal)) {
                    infectTotal = new InfectEmergencies();
                }
            }
            model.addAttribute("total", infectTotal);
            model.addAttribute("infectEmergenciesList", infectEmergenciesList);
            model.addAttribute("currentOrgName", currentOrgName);
        } else if (hasRole(RoleType.Z_GLY, request)) {   //站
            roleType = RoleType.Z_GLY.getValue();
            //初始化查询条件
            criteria.add("orgCode", currentOrgCode);
            criteria.add("year", year);
            criteria.add("quarter", initInfectEmer.getQuarter());
            InfectEmergencies infectEmergencies = infectiousEmergenciesService.getInfectEmerGency(criteria);
            if (ObjectUtil.isNullOrEmpty(infectEmergencies)) {
                InfectEmergencies newInfect = new InfectEmergencies();
                model.addAttribute("infectEmergencies", newInfect);
                model.addAttribute("total", newInfect);
            } else {
                model.addAttribute("infectEmergencies", infectEmergencies);
                model.addAttribute("total", infectEmergencies);
            }
            model.addAttribute("currentOrgName", currentOrgName);
        } else if (hasRole(RoleType.QWGZX, request)) {  //卫管中心
            roleType = RoleType.QWGZX.getValue();
            //获取该卫管管辖区域中所有中心机构
            List<Organization> ZXOrgs = organizationService.getOrganizations(new Criteria("GB_CODE", organization.getGbCode()).add("GENRE_CODE", "B1"));
            List<InfectEmergencies> infectEmerAllList = new ArrayList<InfectEmergencies>();
            InfectEmergencies infectAll = new InfectEmergencies();
            //获取每个中心下所有站以及统计卫管下所有中心和站
            if (StringUtil.isNotEmpty(centerOrgCode)) {
                Organization org = new Organization();
                org.setOrganCode(centerOrgCode);
                ZXOrgs.clear();
                ZXOrgs.add(org);
            }
            if(StringUtil.isNullOrEmpty(centerOrgCode) && StringUtil.isNullOrEmpty(searchOrg)){
                infectEmerAllList = infectiousEmergenciesService.getWGAllZX(gbcode,year,initInfectEmer.getQuarter());
                Map<String, Object> map = infectiousEmergenciesService.countWGAllZX(year,initInfectEmer.getQuarter(),"B1",gbcode);
                infectAll = setField(map);
            }else{
            for (Organization org : ZXOrgs) {
                List<InfectEmergencies> infectEmergenciesList = infectiousEmergenciesService.getInfectEmerOrgList(searchOrg, countType, org.getOrganCode(), year, initInfectEmer.getQuarter());
                infectEmerAllList.addAll(infectEmergenciesList);
                Map<String, Object> map = infectiousEmergenciesService.CountZXTotal(org.getOrganCode(), year, initInfectEmer.getQuarter());
                infectAll = addEveryReport(infectAll, setField(map));
            }
            /*infectEmerAllList.add(infectAll);*/
            if (StringUtil.isNotEmpty(searchOrg)) {
                infectAll = infectiousEmergenciesService.getInfectEmerGency(new Criteria("orgCode", searchOrg).add("year", year).add("quarter", initInfectEmer.getQuarter()));
                if (ObjectUtil.isNullOrEmpty(infectAll)) {
                    infectAll = new InfectEmergencies();
                }
            }
            }
            model.addAttribute("total", infectAll);
            model.addAttribute("infectEmergenciesList", infectEmerAllList);
        }else{
            roleType = RoleType.ADMIN.getValue();
            //获取所有中心
            List<InfectEmergencies> infectEmergenciesList = new ArrayList<InfectEmergencies>();
            InfectEmergencies infectAllTotal = new InfectEmergencies();
            Map<String, Object> map = new HashMap<String, Object>();
            if(StringUtil.isNotEmpty(initGbCode) && StringUtil.isNullOrEmpty(centerOrgCode) && StringUtil.isNullOrEmpty(searchOrg)){
                infectEmergenciesList = infectiousEmergenciesService.getWGAllZX(initGbCode,year,initInfectEmer.getQuarter());
            }else {
                infectEmergenciesList = getAll(searchOrg, countType, year, initInfectEmer.getQuarter(), centerOrgCode);
                //计算所有中心的统计
                map = infectiousEmergenciesService.countAll(year, initInfectEmer.getQuarter(),"B1");
                infectAllTotal = setField(map);
            }
            /*infectEmergenciesList.add(infectAllTotal);*/
            if (StringUtil.isNotEmpty(searchOrg)) {
                infectAllTotal = infectiousEmergenciesService.getInfectEmerGency(new Criteria("orgCode", searchOrg).add("year", year).add("quarter", initInfectEmer.getQuarter()));
                if (ObjectUtil.isNullOrEmpty(infectAllTotal)) {
                    infectAllTotal = new InfectEmergencies();
                }
            } else if (ObjectUtil.isNullOrEmpty(searchOrg)) {
                if (StringUtil.isNotEmpty(centerOrgCode)) {
                    Map<String, Object> mapZX = infectiousEmergenciesService.CountZXTotal(centerOrgCode, year, initInfectEmer.getQuarter());
                    infectAllTotal = setField(mapZX);
                }else if(StringUtil.isNotEmpty(initGbCode)){
                    Map<String, Object> mapWGAllZX = infectiousEmergenciesService.countWGAllZX(year,initInfectEmer.getQuarter(),"B1",initGbCode);
                    infectAllTotal = setField(mapWGAllZX);
                }
            }
            model.addAttribute("total", infectAllTotal);
            model.addAttribute("infectEmergenciesList", infectEmergenciesList);
        }
        model.addAttribute("currentLoginInfo", currentLoginInfo);
        model.addAttribute("countType", initInfectEmer.getCountType());
        model.addAttribute("ROLE", roleType);
        model.addAttribute("CurrentOrg", currentOrgName);
        return "rhip.phsr.infectEmergencies.list";
    }

    /**
     * 保存
     *
     * @param request
     * @param model
     * @param infectEmergencies
     * @return
     */
    @RequestMapping(value = "/save")
    public String save(HttpServletRequest request, ModelMap model, InfectEmergencies infectEmergencies) {
        infectEmergencies = initInfect(infectEmergencies);
        //赋值年、季度、时间
        String quarter = request.getParameter("quarter");
        String year = request.getParameter("year");
        if (StringUtil.isNotEmpty(quarter) && StringUtil.isNotEmpty(year)) {
            infectEmergencies.setYear(Integer.parseInt(year));
            infectEmergencies.setQuarter(Integer.parseInt(quarter));
        }
        infectEmergencies.setReportTime(new Date());
        //赋值机构
        Organization Curorgan = getCurrentOrg(request);
        String curOrgCode = Curorgan.getOrganCode();
        Organization organization = organizationService.getOrganization(curOrgCode);
        infectEmergencies.setOrgCode(curOrgCode);
        infectEmergencies.setOrgName(organization.getOrganName());
        infectEmergencies.setParentCode(organization.getParentCode());
        infectEmergencies.setGenreCode(organization.getGenreCode());
        infectEmergencies.setGbCode(organization.getGbCode());

        //判断是否存在该条数据
        Long id = infectEmergencies.getId();
        Criteria cr = new Criteria();
        cr.add("year", year);
        cr.add("quarter", quarter);
        cr.add("orgCode", curOrgCode);
        if (ObjectUtil.isNullOrEmpty(id) && ObjectUtil.isNullOrEmpty(infectiousEmergenciesService.getInfectEmerGency(cr))) {
            infectiousEmergenciesService.save(infectEmergencies);
        } else {
            infectiousEmergenciesService.update(infectEmergencies);
        }
        //赋值年度累计字段
        Map<String, Object> map = infectiousEmergenciesService.countYearOrg(curOrgCode,Integer.parseInt(year));
        infectEmergencies = setYearField(infectEmergencies, map);
        //新增或修改数据时同步更新相应机构的年度累计数据
        List<InfectEmergencies> infList = infectiousEmergenciesService.getInfectEmergencyList(new Criteria("orgCode", curOrgCode).add("year",year));
        for (InfectEmergencies infect : infList) {
            infect = setSameOrgYearCount(infect, infectEmergencies);
            infectiousEmergenciesService.update(infect);
        }
        return "rhip.phsr.infectEmergencies.list";
    }


    //计算中心及下属站的总和
    private InfectEmergencies setField(Map<String, Object> map) {
        InfectEmergencies infectEmergencies = new InfectEmergencies();
        if (ObjectUtil.isNotEmpty(map.get("AllOcInfect"))) {
            infectEmergencies.setOccurInfectiousNum(Integer.parseInt(map.get("AllOcInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllReInfect"))) {
            infectEmergencies.setReportInfectiousNum(Integer.parseInt(map.get("AllReInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllTimInfect"))) {
            infectEmergencies.setTimelyInfectiousNum(Integer.parseInt(map.get("AllTimInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllOcEmer"))) {
            infectEmergencies.setOccurEmergenciesNum(Integer.parseInt(map.get("AllOcEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllReEmer"))) {
            infectEmergencies.setReportEmergenciesNum(Integer.parseInt(map.get("AllReEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllTimEmer"))) {
            infectEmergencies.setTimelyEmergenciesNum(Integer.parseInt(map.get("AllTimEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllNetRep"))) {
            infectEmergencies.setNetReportDeathnum(Integer.parseInt(map.get("AllNetRep").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearOcInfect"))) {
            infectEmergencies.setYearOccurInfectiousNum(Integer.parseInt(map.get("AllYearOcInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearReInfect"))) {
            infectEmergencies.setYearReportInfectiousNum(Integer.parseInt(map.get("AllYearReInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearTimInfect"))) {
            infectEmergencies.setYearTimelyInfectiousNum(Integer.parseInt(map.get("AllYearTimInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearOcEmer"))) {
            infectEmergencies.setYearOccurEmergenciesNum(Integer.parseInt(map.get("AllYearOcEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearReEmer"))) {
            infectEmergencies.setYearReportEmergenciesNum(Integer.parseInt(map.get("AllYearReEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearTimEmer"))) {
            infectEmergencies.setYearTimelyEmergenciesNum(Integer.parseInt(map.get("AllYearTimEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearNetRep"))) {
            infectEmergencies.setYearNetReportDeathnum(Integer.parseInt(map.get("AllYearNetRep").toString()));
        }
        infectEmergencies.setOrgName("合计");
        return infectEmergencies;
    }


    //角色为ADMIN时-获取所有中心的数据
    private List<InfectEmergencies> getAll(String searchOrg, String ountType, int year, int quarter, String centerOrgCode) {
        Criteria criteria = new Criteria();
        /*criteria.add("genreCode", OP.IN, new String[]{"B1", "B2"});*/
        criteria.add("genreCode","B1");
        List<Organization> organizationList = organizationDao.getList(criteria);
        List<InfectEmergencies> infectEmergenciesList = new ArrayList<InfectEmergencies>();
        if (StringUtil.isNotEmpty(searchOrg)) {
            infectEmergenciesList = infectiousEmergenciesDao.getList(new Criteria("year", year).add("orgCode", searchOrg).add("quarter", quarter));
        } else if (StringUtil.isNullOrEmpty(searchOrg)) {
            if (StringUtil.isNullOrEmpty(centerOrgCode)) {
                /*infectEmergenciesList = infectiousEmergenciesDao.getList(new Criteria("year", year).add("quarter", quarter).add("genreCode","B1"));*/
                for(Organization organization: organizationList){
                    InfectEmergencies infectEmergencies = new InfectEmergencies();
                    Map<String, Object> mapZX = infectiousEmergenciesService.CountZXTotal(organization.getOrganCode(), year, quarter);
                    infectEmergencies = setField(mapZX);
                    infectEmergencies.setOrgName(organization.getOrganName());
                    infectEmergenciesList.add(infectEmergencies);
                }
            } else {
                infectEmergenciesList = infectiousEmergenciesService.getInfectEmerOrgList(searchOrg, ountType, centerOrgCode, year, quarter);
            }
        }
        if (StringUtil.isNullOrEmpty(searchOrg)) {
            if (StringUtil.isNullOrEmpty(centerOrgCode)) {
                /*for (Organization organization : organizationList) {
                    if (ObjectUtil.isNullOrEmpty(infectiousEmergenciesDao.get(new Criteria("orgCode", organization.getOrganCode()).add("year",year)))) {
                        InfectEmergencies infectEmergencies = new InfectEmergencies();
                        infectEmergencies.setOrgCode(organization.getOrganCode());
                        infectEmergencies.setOrgName(organization.getOrganName());
                        infectEmergenciesList.add(infectEmergencies);
                    }
                }*/
            }
        } else if (StringUtil.isNotEmpty(searchOrg)) {
            if (ObjectUtil.isNullOrEmpty(infectEmergenciesList)) {
                InfectEmergencies infectEmergencies = new InfectEmergencies();
                infectEmergencies.setOrgName(organizationDao.get(new Criteria("organCode", searchOrg)).getOrganName());
                infectEmergencies.setOrgCode(searchOrg);
                infectEmergenciesList.add(infectEmergencies);
            }
        }
        return infectEmergenciesList;
    }

    //卫管下每个中心下属站的统计
    private InfectEmergencies addEveryReport(InfectEmergencies infectEmergencies, InfectEmergencies infectZX) {
        /*InfectEmergencies infectEmergencies = new InfectEmergencies();*/
        if (ObjectUtil.isNotEmpty(infectZX)) {
            if (ObjectUtil.isNotEmpty(infectZX.getOccurInfectiousNum())) {
                infectEmergencies.setOccurInfectiousNum(infectEmergencies.getOccurInfectiousNum() + infectZX.getOccurInfectiousNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getReportInfectiousNum())) {
                infectEmergencies.setReportInfectiousNum(infectEmergencies.getReportInfectiousNum() + infectZX.getReportInfectiousNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getTimelyInfectiousNum())) {
                infectEmergencies.setTimelyInfectiousNum(infectEmergencies.getTimelyInfectiousNum() + infectZX.getTimelyInfectiousNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getOccurEmergenciesNum())) {
                infectEmergencies.setOccurEmergenciesNum(infectEmergencies.getOccurEmergenciesNum() + infectZX.getOccurEmergenciesNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getReportEmergenciesNum())) {
                infectEmergencies.setReportEmergenciesNum(infectEmergencies.getReportEmergenciesNum() + infectZX.getReportEmergenciesNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getTimelyEmergenciesNum())) {
                infectEmergencies.setTimelyEmergenciesNum(infectEmergencies.getTimelyEmergenciesNum() + infectZX.getTimelyEmergenciesNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getNetReportDeathnum())) {
                infectEmergencies.setNetReportDeathnum(infectEmergencies.getNetReportDeathnum() + infectZX.getNetReportDeathnum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getYearOccurInfectiousNum())) {
                infectEmergencies.setYearOccurInfectiousNum(infectEmergencies.getYearOccurInfectiousNum() + infectZX.getYearOccurInfectiousNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getYearReportInfectiousNum())) {
                infectEmergencies.setYearReportInfectiousNum(infectEmergencies.getYearReportInfectiousNum() + infectZX.getYearReportInfectiousNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getYearTimelyInfectiousNum())) {
                infectEmergencies.setYearTimelyInfectiousNum(infectEmergencies.getYearTimelyInfectiousNum() + infectZX.getYearTimelyInfectiousNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getYearOccurEmergenciesNum())) {
                infectEmergencies.setYearOccurEmergenciesNum(infectEmergencies.getYearOccurEmergenciesNum() + infectZX.getYearOccurEmergenciesNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getYearReportEmergenciesNum())) {
                infectEmergencies.setYearReportEmergenciesNum(infectEmergencies.getYearReportEmergenciesNum() + infectZX.getYearReportEmergenciesNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getYearTimelyEmergenciesNum())) {
                infectEmergencies.setYearTimelyEmergenciesNum(infectEmergencies.getYearTimelyEmergenciesNum() + infectZX.getYearTimelyEmergenciesNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getYearNetReportDeathnum())) {
                infectEmergencies.setYearNetReportDeathnum(infectEmergencies.getYearNetReportDeathnum() + infectZX.getYearNetReportDeathnum());
            }
        }
        return infectEmergencies;
    }

    //将机构中所有季度的值赋值到年度累计中
    private InfectEmergencies setYearField(InfectEmergencies infectEmergencies, Map<String, Object> map) {
        if (ObjectUtil.isNotEmpty(map.get("AllOcInfect"))) {
            infectEmergencies.setYearOccurInfectiousNum(Integer.parseInt(map.get("AllOcInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllReInfect"))) {
            infectEmergencies.setYearReportInfectiousNum(Integer.parseInt(map.get("AllReInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllTimInfect"))) {
            infectEmergencies.setYearTimelyInfectiousNum(Integer.parseInt(map.get("AllTimInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllOcEmer"))) {
            infectEmergencies.setYearOccurEmergenciesNum(Integer.parseInt(map.get("AllOcEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllReEmer"))) {
            infectEmergencies.setYearReportEmergenciesNum(Integer.parseInt(map.get("AllReEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllTimEmer"))) {
            infectEmergencies.setYearTimelyEmergenciesNum(Integer.parseInt(map.get("AllTimEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllNetRep"))) {
            infectEmergencies.setYearNetReportDeathnum(Integer.parseInt(map.get("AllNetRep").toString()));
        }
        return infectEmergencies;
    }

    //增加或修改季度统计时，更新相同机构的年度累计
    private InfectEmergencies setSameOrgYearCount(InfectEmergencies infectEmergencies, InfectEmergencies infectZX) {
        if (ObjectUtil.isNotEmpty(infectZX.getYearOccurInfectiousNum())) {
            infectEmergencies.setYearOccurInfectiousNum(infectZX.getYearOccurInfectiousNum());
        }
        if (ObjectUtil.isNotEmpty(infectZX.getYearReportInfectiousNum())) {
            infectEmergencies.setYearReportInfectiousNum(infectZX.getYearReportInfectiousNum());
        }
        if (ObjectUtil.isNotEmpty(infectZX.getYearTimelyInfectiousNum())) {
            infectEmergencies.setYearTimelyInfectiousNum(infectZX.getYearTimelyInfectiousNum());
        }
        if (ObjectUtil.isNotEmpty(infectZX.getYearOccurEmergenciesNum())) {
            infectEmergencies.setYearOccurEmergenciesNum(infectZX.getYearOccurEmergenciesNum());
        }
        if (ObjectUtil.isNotEmpty(infectZX.getYearReportEmergenciesNum())) {
            infectEmergencies.setYearReportEmergenciesNum(infectZX.getYearReportEmergenciesNum());
        }
        if (ObjectUtil.isNotEmpty(infectZX.getYearTimelyEmergenciesNum())) {
            infectEmergencies.setYearTimelyEmergenciesNum(infectZX.getYearTimelyEmergenciesNum());
        }
        if (ObjectUtil.isNotEmpty(infectZX.getYearNetReportDeathnum())) {
            infectEmergencies.setYearNetReportDeathnum(infectZX.getYearNetReportDeathnum());
        }
        return infectEmergencies;
    }

    //初始化录入数据
    private InfectEmergencies initInfect(InfectEmergencies infectEmergencies) {
        if (ObjectUtil.isNullOrEmpty(infectEmergencies.getOccurInfectiousNum())) {
            infectEmergencies.setOccurInfectiousNum(0);
        }
        if (ObjectUtil.isNullOrEmpty(infectEmergencies.getReportInfectiousNum())) {
            infectEmergencies.setReportInfectiousNum(0);
        }
        if (ObjectUtil.isNullOrEmpty(infectEmergencies.getTimelyInfectiousNum())) {
            infectEmergencies.setTimelyInfectiousNum(0);
        }
        if (ObjectUtil.isNullOrEmpty(infectEmergencies.getOccurEmergenciesNum())) {
            infectEmergencies.setOccurEmergenciesNum(0);
        }
        if (ObjectUtil.isNullOrEmpty(infectEmergencies.getReportEmergenciesNum())) {
            infectEmergencies.setReportEmergenciesNum(0);
        }
        if (ObjectUtil.isNullOrEmpty(infectEmergencies.getTimelyEmergenciesNum())) {
            infectEmergencies.setTimelyEmergenciesNum(0);
        }
        if (ObjectUtil.isNullOrEmpty(infectEmergencies.getNetReportDeathnum())) {
            infectEmergencies.setNetReportDeathnum(0);
        }
        return infectEmergencies;
    }

}
