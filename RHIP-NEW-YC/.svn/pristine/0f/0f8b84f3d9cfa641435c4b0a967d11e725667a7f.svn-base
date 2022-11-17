package com.founder.rhip.phsr.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.ehr.dto.InfectEmergencies;
import com.founder.rhip.ehr.repository.statistics.IInfectiousEmergenciesDao;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.ihm.service.IInfectiousEmergenciesService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IOrganizationDao;
import com.founder.rhip.mdm.service.IOrganizationService;

/**
 * 传染病及突发公共卫生事件报表
 * @author admin
 *
 */
@Controller
@RequestMapping(value = "/infectEmergCensus")
public class InfectEmergCensusController extends BaseController {

    @Resource(name = "infectiousEmergenciesService")
    private IInfectiousEmergenciesService infectiousEmergenciesService;

    @Resource(name = "mdmOrganizationService")
    private IOrganizationService organizationService;

    @Resource(name = "infectEmergenciesDao")
    private IInfectiousEmergenciesDao infectiousEmergenciesDao;

    @Resource(name = "mdmOrganizationDao")
    private IOrganizationDao organizationDao;

	@Autowired
	private IOrganizationApp organizationApp;
	
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
        return "rhip.phsr.infectEmergCensus.search";
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
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		if(initInfectEmer.getQuarter() != null){
			criteria.add("month",initInfectEmer.getQuarter().toString());
		}
		
        String countType = initInfectEmer.getCountType();
		if("1".equals(countType)){//按年
			criteria.remove("month");
		}
		
		String roleType = "";
        String currentOrgName = "";
        String currentOrgCode = "";
        //获取当前机构
        Organization organization = getCurrentOrg(request);
        if (ObjectUtil.isNotEmpty(organization)) {
            currentOrgName = organization.getOrganName();
            currentOrgCode = organization.getOrganCode();
        }

	      //获取查询条件
	      int year = 0;
	      if (ObjectUtil.isNullOrEmpty(initInfectEmer.getYear())) {
	          year = new Date().getYear() + 1900;
	      } else {
	          year = initInfectEmer.getYear();
	      }
       
		// 不同身份查询条件
		organizeCriteria(criteria, model, request);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<InfectEmergencies> reports = new ArrayList<InfectEmergencies>();
		
		InfectEmergencies infectEmergencies = new InfectEmergencies();
		Criteria cri = new Criteria("orgCode", currentOrgCode).add("year", year);
        if(initInfectEmer.getQuarter() != null){
        	cri.add("quarter", initInfectEmer.getQuarter());
        }
		if (hasRole(RoleType.ZX_GLY, request)||hasRole(RoleType.ZXCRB, request)) {//中心
            roleType = RoleType.ZX_GLY.getValue();
            
            infectEmergencies = infectiousEmergenciesService.getInfectEmerGency(cri);
            if (ObjectUtil.isNullOrEmpty(infectEmergencies)) {
				infectEmergencies = new InfectEmergencies();
				infectEmergencies.setOrgCode(currentOrgCode);
			}
		} else if (hasRole(RoleType.Z_GLY, request)||hasRole(RoleType.ZCRB, request)) {   //站
			roleType = RoleType.Z_GLY.getValue();
			 infectEmergencies = infectiousEmergenciesService.getInfectEmerGency(cri);
			if (ObjectUtil.isNullOrEmpty(infectEmergencies)) {
				infectEmergencies = new InfectEmergencies();
				infectEmergencies.setOrgCode(currentOrgCode);
			}
			infectEmergencies.setGbCode(organizationApp.queryOrgan(infectEmergencies.getOrgCode()).getGbCode());
        } else if (hasRole(RoleType.QWGZX, request)) {  //卫管中心
            roleType = RoleType.QWGZX.getValue();
        }else{
            roleType = RoleType.ADMIN.getValue();
        }
		
		reports = infectiousEmergenciesService.getInfectEmergenciesList(criteria);     
		//统计总数
		InfectEmergencies census = countCensus(reports);
		
		model.addAttribute("total", census);
	    model.addAttribute("infectEmergenciesList", reports);
	    model.addAttribute("infectEmergencies", infectEmergencies);
	    
		model.addAttribute("currentLoginInfo", currentLoginInfo);
        model.addAttribute("countType", initInfectEmer.getCountType());
        model.addAttribute("ROLE", roleType);
        model.addAttribute("CurrentOrg", currentOrgName);
        model.addAttribute("currentOrgName", currentOrgName);
		return "rhip.phsr.infectEmergCensus.list";
	}
    
	private InfectEmergencies countCensus(List<InfectEmergencies> reports) {
		//统计合计信息
		InfectEmergencies census = new InfectEmergencies();
		
		if(ObjectUtil.isNotEmpty(reports)){
			for (InfectEmergencies infectEmergencies : reports) {
				census.setOccurInfectiousNum(census.getOccurInfectiousNum() + infectEmergencies.getOccurInfectiousNum());		
				census.setReportInfectiousNum(census.getReportInfectiousNum() + infectEmergencies.getReportInfectiousNum());		
				census.setTimelyInfectiousNum(census.getTimelyInfectiousNum() + infectEmergencies.getTimelyInfectiousNum());		
				census.setOccurEmergenciesNum(census.getOccurEmergenciesNum() + infectEmergencies.getOccurEmergenciesNum());		
				census.setReportEmergenciesNum(census.getReportEmergenciesNum() + infectEmergencies.getReportEmergenciesNum());		
			
				census.setTimelyEmergenciesNum(census.getTimelyEmergenciesNum() + infectEmergencies.getTimelyEmergenciesNum());		
				census.setNetReportDeathnum(census.getNetReportDeathnum() + infectEmergencies.getNetReportDeathnum());		
				census.setRegisterInfectiousNum(census.getRegisterInfectiousNum() + infectEmergencies.getRegisterInfectiousNum());		
				census.setNetworkInfectiousNum(census.getNetworkInfectiousNum() + infectEmergencies.getNetworkInfectiousNum());		
			}
		}
		return census;
	}

	/**
	 * 组织不同身份查询条件
	 * 
	 * @param criteria
	 * @param model
	 * @param request
	 */
	protected void organizeCriteria(Criteria criteria, ModelMap model, HttpServletRequest request) {
		Organization org = getCurrentOrg(request);
		model.addAttribute("createrOrg", hasRole(RoleType.YY_GLY, request) ? "_999" : org.getOrganCode()); // 用来控制编辑与删除的操作
		if (!criteria.contains("organCode")) {
			if (hasRole(RoleType.ZX_GLY, request)||hasRole(RoleType.ZXCRB, request)) {
				criteria.add("centerOrgCode", org.getOrganCode());
			} else if (hasRole(RoleType.Z_GLY, request)||hasRole(RoleType.ZCRB, request)||hasRole(RoleType.YYCRB, request)) {
				criteria.add("orgCode", org.getOrganCode());
			}
		}
		
		// 用来页面判断显示机构
		if (criteria.contains("orgCode")) {
			model.addAttribute("orgCode", criteria.get("orgCode")); 
		} else if (criteria.contains("centerOrgCode")) {
			model.addAttribute("centerOrgCode", criteria.get("centerOrgCode")); 
		} else if (criteria.contains("gbcode")) {
			model.addAttribute("gbcode", criteria.get("gbcode")); 
		}else{
			model.addAttribute("all", "all"); 
		}
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
        if (ObjectUtil.isNotEmpty(map.get("AllRegInfect"))) {
            infectEmergencies.setRegisterInfectiousNum(Integer.parseInt(map.get("AllRegInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllNetInfect"))) {
            infectEmergencies.setNetworkInfectiousNum(Integer.parseInt(map.get("AllNetInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearRegInfect"))) {
            infectEmergencies.setYearRegisterInfectiousNum(Integer.parseInt(map.get("AllYearRegInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearNetInfect"))) {
            infectEmergencies.setYearNetworkInfectiousNum(Integer.parseInt(map.get("AllYearNetInfect").toString()));
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
            if (ObjectUtil.isNotEmpty(infectZX.getRegisterInfectiousNum())){
            	infectEmergencies.setRegisterInfectiousNum(infectEmergencies.getRegisterInfectiousNum() + infectZX.getRegisterInfectiousNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getNetworkInfectiousNum())){
            	infectEmergencies.setNetworkInfectiousNum(infectEmergencies.getNetworkInfectiousNum() + infectZX.getNetworkInfectiousNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getYearRegisterInfectiousNum())){
            	infectEmergencies.setYearRegisterInfectiousNum(infectEmergencies.getYearRegisterInfectiousNum() + infectZX.getYearRegisterInfectiousNum());
            }
            if (ObjectUtil.isNotEmpty(infectZX.getYearNetworkInfectiousNum())){
            	infectEmergencies.setYearNetworkInfectiousNum(infectEmergencies.getYearNetworkInfectiousNum() + infectZX.getYearNetworkInfectiousNum());
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
        if (ObjectUtil.isNotEmpty(map.get("AllRegInfect"))) {
        	infectEmergencies.setYearRegisterInfectiousNum(Integer.parseInt(map.get("AllRegInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllNetInfect"))) {
            infectEmergencies.setYearNetworkInfectiousNum(Integer.parseInt(map.get("AllNetInfect").toString()));
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
        if (ObjectUtil.isNotEmpty(infectZX.getYearRegisterInfectiousNum())){
        	infectEmergencies.setYearRegisterInfectiousNum(infectZX.getYearRegisterInfectiousNum());
        }
        if (ObjectUtil.isNotEmpty(infectZX.getYearNetworkInfectiousNum())){
        	infectEmergencies.setYearNetworkInfectiousNum(infectZX.getYearNetworkInfectiousNum());
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
        if (ObjectUtil.isNullOrEmpty(infectEmergencies.getRegisterInfectiousNum())) {
            infectEmergencies.setRegisterInfectiousNum(0);
        }
        if (ObjectUtil.isNullOrEmpty(infectEmergencies.getNetworkInfectiousNum())) {
            infectEmergencies.setNetworkInfectiousNum(0);
        }
        return infectEmergencies;
    }

}
