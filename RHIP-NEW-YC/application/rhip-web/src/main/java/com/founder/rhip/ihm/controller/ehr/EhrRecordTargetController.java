package com.founder.rhip.ihm.controller.ehr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;
import com.founder.rhip.ehr.service.ILifeEventService;
import com.founder.rhip.ihm.controller.IHMBaseController;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IEhrRecordStatisticsService;
import com.founder.rhip.ihm.service.IPerformanceService;

/**
 * 健康档案 档案统计
 * 
 * @author liuk
 * @since 2014年5月20日 14:59:24
 */
@Controller
@RequestMapping("/ihm/ehr")
public class EhrRecordTargetController extends IHMBaseController {

	@Resource(name = "ehrRecordStatisticsService")
	private IEhrRecordStatisticsService recordStatisticsService;
	
	@Resource(name = "lifeEventService")
	private ILifeEventService lifeEventService;
	
    @Resource(name = "performanceService")
    private IPerformanceService performanceService;
    
	/**
	 * Record string.
	 * 
	 * @return the string
	 */
	@RequestMapping("/record")
	public String record(Model model) {
		model.addAttribute("searchUrl", "/ihm/ehr/record/result");
		// 不需要按市级医院查询
		model.addAttribute("hospitalFlag", 1);
		return "ihm.ehr.record.main";
	}

	@RequestMapping("/record/result")
	public String recordResult(TargetOrgQueryForm form, Model model, @RequestParam(value = "gender", required = false) String gender, @RequestParam(value = "recordStartAge", required = false) String recordStartAge,
			@RequestParam(value = "recordEndAge", required = false) String recordEndAge) {
		form.calTime();
		Date[] dateAges = DateUtil.getDateRangeByAge(recordStartAge, recordEndAge);
		Date begin = ObjectUtil.isNotEmpty(form.getBeginDate()) ? DateUtil.parseSimpleDate(form.getBeginDate(), "yyyy/MM/dd") : null;
        Date end = ObjectUtil.isNotEmpty(form.getEndDate()) ? DateUtil.parseSimpleDate(form.getEndDate().trim()+" 23:59:59.999", "yyyy/MM/dd HH:mm:ss.S") : null;
        List<Map<String, Object>> data = recordStatisticsService.getRecordStatisticsData(form.getGenreCode(), form.getGbCode(), form.getSuperOrganCode(), form.getOrganCode(), begin, end, dateAges[0], dateAges[1], gender);
		model.addAttribute("data", data);
		return "ihm.ehr.record.reslut";
	}

	@RequestMapping("/star")
	public String star(Model model) {
		model.addAttribute("searchUrl", "/ihm/ehr/star/result");
		// 不需要按市级医院查询
		model.addAttribute("hospitalFlag", 1);
		return "ihm.ehr.star.main";
	}

	@RequestMapping("/star/result")
	public String starResult(TargetOrgQueryForm form, Model model, @RequestParam(value = "householdType", required = false) String householdType) {
		form.calTime();
		Date begin = ObjectUtil.isNotEmpty(form.getBeginDate()) ? DateUtil.parseSimpleDate(form.getBeginDate(), "yyyy/MM/dd") : null;
        Date end = ObjectUtil.isNotEmpty(form.getEndDate()) ? DateUtil.parseSimpleDate(form.getEndDate().trim()+" 23:59:59.999", "yyyy/MM/dd HH:mm:ss.S") : null;
		List<Map<String, Object>> data = recordStatisticsService.getStarStatisticsData(form.getGenreCode(), form.getGbCode(), form.getSuperOrganCode(), form.getOrganCode(), begin, end, householdType);
		model.addAttribute("data", data);
		return "ihm.ehr.star.reslut";
	}

	@RequestMapping("/population/search")
	public String population(Model model, HttpServletRequest request) {
		String from = request.getParameter("from");
		model.addAttribute("from", from);
		model.addAttribute("searchUrl", "/ihm/ehr/population/result");
        model.addAttribute("listpath","ehrTarget/population/datagrid.jsp");//!因为注意main.jsp的引入方式
		// 不需要按市级医院查询
		model.addAttribute("hospitalFlag", 1);
		model.addAttribute("timeRangeFlag", 1);
		return "ihm.ehr.population.main";
	}

	@RequestMapping("/population/result")
	public String populationResult(TargetOrgQueryForm form, Model model, @RequestParam(value = "householdType", required = false) String householdType, @RequestParam(value = "gender", required = false) String gender) {
		form.calTime();
		Date begin = ObjectUtil.isNotEmpty(form.getBeginDate()) ? DateUtil.parseSimpleDate(form.getBeginDate(), "yyyy/MM/dd") : null;
        Date end = ObjectUtil.isNotEmpty(form.getEndDate()) ? DateUtil.parseSimpleDate(form.getEndDate().trim()+" 23:59:59.999", "yyyy/MM/dd HH:mm:ss.S") : null;
		List<Map<String, Object>> data = recordStatisticsService.getPopulationStatisticsData(form.getGenreCode(), form.getGbCode(), form.getSuperOrganCode(), form.getOrganCode(), begin, end, householdType, gender);
		model.addAttribute("data", data);
		return "ihm.ehr.population.reslut";
	}

    @RequestMapping("/population")
    public String personChartIndex(Model model) {
       Map<String, Object> data = recordStatisticsService.getIndexChartData();
        String male = "";
        String female = "";
        List maleList = new ArrayList();
        List femaleList = new ArrayList();
        for(int i = 0 ; i < 19 ; i++){
            male = male + "," + data.get("M"+i);
            female = female + "," + data.get("F"+i);

            maleList.add(data.get("M"+i));
            femaleList.add(data.get("F"+i));
        }
        male = male.substring(1, male.length());
        female = female.substring(1, female.length());

        model.addAttribute("male", male);
        model.addAttribute("female", female);

        model.addAttribute("maleList", maleList);
        model.addAttribute("femaleList", femaleList);
        return "ihm.ehr.population.index";
    }

    @RequestMapping("/die")
	public String die(HttpServletRequest request, Model model) {
    	initOrg(request, model);
    	 List<PersonDeathRecord> icd10list = lifeEventService.getTopTenDeath(null);
	     model.addAttribute("icd10list",icd10list);
		return "ihm.ehr.die.main";
	}

	@RequestMapping("/die/result")
	public String dieResult(TargetOrgQueryForm form, Model model, HttpServletRequest request) {
		 Criteria criteria = form.getLifeEventCriteria();
		 List<PersonDeathRecord> icd10list = lifeEventService.getTopTenDeath(form.getCriDateLife());
	     model.addAttribute("icd10list",icd10list);		
	     List<PersonDeathRecord> personDeathRecords = lifeEventService.getDeathICD10TargetList(criteria);
	     model.addAttribute("personDeathRecords",personDeathRecords);
		return "ihm.ehr.die.reslut";
	}
	
	/**
	 * Record string.
	 * 
	 * @return the string
	 */
	@RequestMapping("/recordupdate/index")
	public String recordupdate(HttpServletRequest request,Model model) {
        model.addAttribute("hospitalFlag", "1");//不要市级医院
        model.addAttribute("superOrganFlag", "1");//不要卫生院
		model.addAttribute("searchUrl", "/ihm/ehr/recordupdate/list");
		model.addAttribute("listpath","ehrTarget/recordUpdate/list.jsp");
		initOrg(request,model);
		return "ihm.ehr.recordupdate.index";
	}
	
    /**
     * 健康档案指标
     *
     * @param request
     * @param form
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/recordupdate/list")
    public String recordupdateList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> List = performanceService.getHRPerformanceList(form.getParamMap());
        model.addAttribute("reports", List);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.ehr.recordupdate.list";
    }	
	
}
