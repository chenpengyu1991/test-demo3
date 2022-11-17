package com.founder.rhip.ihm.controller;

import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.service.IPopulaceService;
import com.founder.rhip.ihm.controller.form.HRBaseTargetQueryForm;
import com.founder.rhip.ihm.service.IHRBaseTargetService;

/**
 *  人力资源
 * @author chen_wenbo
 *
 */
@Controller
@RequestMapping("/ihm/hr/")
public class HRBaseTargetController extends IHMBaseController {

	@Resource(name = "hrBaseTargetService")
    private IHRBaseTargetService hrBaseTargetService;
	
	@Resource(name = "populaceService")
	private IPopulaceService populaceService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "ihm.hr.index";
	}

	@RequestMapping("/detail")
	public String detail(Model model) {
		return "ihm.hr.detail";
	}

	@RequestMapping("/health")
	public String health(HttpServletRequest request, HRBaseTargetQueryForm form,
			Model model) {
		model.addAttribute("listpage", "healthList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/hr/healthlist"); //查询请求路径
		return "ihm.hr.health";
	}

	/**
	 * 人员统计
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/healthlist")
	public String healthlist(HttpServletRequest request,
			HRBaseTargetQueryForm form,Model model) {
		String organCode = form.getOrganCode();
		String genreCode = form.getGenreCode();
		String superOrganCode = form.getSuperOrganCode();
		String gbCode = form.getGbCode();
		
		List<Map<String, Object>> list = hrBaseTargetService.getHealthTargetList(organCode, superOrganCode, gbCode, genreCode);
		model.addAttribute("healthlist", list);
		return "ihm.hr.healthlist";
	}
	
	@RequestMapping("/listEcharts")
	public @ResponseBody Object listEcharts() {
		Map<String,Object> allData = new HashMap<String,Object>();
		Map<String,Object> health = new HashMap<String, Object>();
		Map<String,Object> practice = new HashMap<String, Object>();	
		String organCode = "";
		String genreCode = "0";
		String superOrganCode = "";
		String gbCode = "";
		List<Map<String, Object>> healthList = hrBaseTargetService.getHealthTargetList(organCode, superOrganCode, gbCode, genreCode);
		List<Map<String, Object>> practiceList = hrBaseTargetService.getPracticeList(organCode, superOrganCode, gbCode, genreCode);
		int healthTotal=healthList.size()-1;
		int practiceTotal=practiceList.size()-1;
		practice.put("COUNT1", practiceList.get(practiceTotal).get("COUNT1"));
    	practice.put("COUNT2", practiceList.get(practiceTotal).get("COUNT2"));
		practice.put("COUNT3", practiceList.get(practiceTotal).get("COUNT3"));
		practice.put("COUNT4", practiceList.get(practiceTotal).get("COUNT4"));
		practice.put("COUNT5", practiceList.get(practiceTotal).get("COUNT5"));
		practice.put("COUNT6", practiceList.get(practiceTotal).get("COUNT6"));
		practice.put("COUNT7", practiceList.get(practiceTotal).get("COUNT7"));
		practice.put("COUNT8", practiceList.get(practiceTotal).get("COUNT8"));
		practice.put("COUNT9", practiceList.get(practiceTotal).get("COUNT9"));
		practice.put("COUNT10", practiceList.get(practiceTotal).get("COUNT10"));
		practice.put("COUNT11", practiceList.get(practiceTotal).get("COUNT11"));
		practice.put("COUNT12", practiceList.get(practiceTotal).get("COUNT12"));
		health.put("COUNT1", healthList.get(healthTotal).get("COUNT1"));
		health.put("COUNT2", healthList.get(healthTotal).get("COUNT2"));
		health.put("COUNT3", healthList.get(healthTotal).get("COUNT3"));
		health.put("COUNT4", healthList.get(healthTotal).get("COUNT4"));
		health.put("COUNT5", healthList.get(healthTotal).get("COUNT5"));
		health.put("COUNT6", healthList.get(healthTotal).get("COUNT6"));
		health.put("COUNT7", healthList.get(healthTotal).get("COUNT7"));
		health.put("COUNT8", healthList.get(healthTotal).get("COUNT8"));
		health.put("COUNT9", healthList.get(healthTotal).get("COUNT9"));
		health.put("COUNT10", healthList.get(healthTotal).get("COUNT10"));
		health.put("COUNT11", healthList.get(healthTotal).get("COUNT11"));
		health.put("COUNT12", healthList.get(healthTotal).get("COUNT12"));
		
		allData.put("practice", practice);
		allData.put("health", health);
		return allData;
	}

	@RequestMapping("/healththousand")
	public String healththousand(HttpServletRequest request, HRBaseTargetQueryForm form,
			Model model) {
		model.addAttribute("listpage", "healthThousandList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/hr/healththousandlist"); //查询请求路径
		return "ihm.hr.health";
	}

	/**
	 * 千人统计
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/healththousandlist")
	public String healththousandlist(HttpServletRequest request,
			HRBaseTargetQueryForm form, Model model) {
		String organCode = form.getOrganCode();
		String genreCode = form.getGenreCode();
		String superOrganCode = form.getSuperOrganCode();
		String gbCode = form.getGbCode();
		
		List<Map<String, Object>> list = hrBaseTargetService.getHealthTargetList(organCode, superOrganCode, gbCode, genreCode);
		Criteria criteria = new Criteria();
		criteria.add("countYear", Calendar.getInstance().get(Calendar.YEAR));
		Integer holdNum = populaceService.getPopulaceNum(criteria, "householdNum") + 
				populaceService.getPopulaceNum(criteria, "unHouseHoldNum");

		Double count2 = 0d, count3 = 0d, count4 = 0d;
		if(list != null && list.size() > 0)
		{
			for (Map<String, Object> map : list) {
				if("<B>合计</B>".equalsIgnoreCase((String) map.get("ORGAN_NAME")))
				{
					map.put("COUNT2", String.format("%.5f", count2/holdNum*1000));
					map.put("COUNT3", String.format("%.5f", count3/holdNum*1000));
					map.put("COUNT4", String.format("%.5f", count4/holdNum*1000));
					
					map.put("COUNT_ROW", String.format("%.5f", (count2 + count3 + count4)/holdNum*1000));
				}else
				{
					Double c2 = Double.valueOf(map.get("COUNT2").toString());
					Double c3 = Double.valueOf(map.get("COUNT3").toString());
					Double c4 = Double.valueOf(map.get("COUNT4").toString());
					Double countRow = c2 + c3 + c4;
					
					map.put("COUNT_ROW", String.format("%.5f", countRow/holdNum*1000));
					map.put("COUNT2", String.format("%.5f", c2/holdNum*1000));
					map.put("COUNT3", String.format("%.5f", c3/holdNum*1000));
					map.put("COUNT4", String.format("%.5f", c4/holdNum*1000));
					
					count2 = count2 + c2;
					count3 = count3 + c3;
					count4 = count4 + c4;
				}
			}
		}
		
		model.addAttribute("healthlist", list);
		return "ihm.hr.healththousandlist";
	}

    @RequestMapping("/practice")
    public String practice(HttpServletRequest request, HRBaseTargetQueryForm form, Model model) {
        model.addAttribute("listpage", "technicalList.jsp"); //查询结果列表页面
        model.addAttribute("queryPath", "/ihm/hr/practiceList"); //查询请求路径
        return "ihm.hr.health";
    }

    /**
     * 执业职称
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/practiceList")
    public String practiceList(HttpServletRequest request, HRBaseTargetQueryForm form, Model model) {
        String organCode = form.getOrganCode();
        String genreCode = form.getGenreCode();
        String superOrganCode = form.getSuperOrganCode();
        String gbCode = form.getGbCode();

        List<Map<String, Object>> list = hrBaseTargetService.getPracticeList(organCode, superOrganCode, gbCode, genreCode);
        model.addAttribute("healthlist", list);
        return "ihm.hr.practiceList";
    }

    /**
     * 综合管理-人力资源
     * @return
     */
    @RequestMapping("/getStaffCyTypeDate")
    @ResponseBody
    public Map<String, Object> getStaffCyTypeDate() {
        Map<String,Object> resultMap = new HashMap<>();
        Map<String,Object> staffData = hrBaseTargetService.getStaffCyTypeDate();
        resultMap.put("CY_TYPE1",staffData.get("CY_TYPE1"));
        resultMap.put("CY_TYPE2",staffData.get("CY_TYPE2"));
        resultMap.put("CY_TYPE3",staffData.get("CY_TYPE3"));
        resultMap.put("CY_TYPE4",staffData.get("CY_TYPE4"));
        resultMap.put("CY_TYPE5",staffData.get("CY_TYPE5"));
        resultMap.put("CY_TYPE6",staffData.get("CY_TYPE6"));

        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getStaffPieData(series,staffData);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","卫生人员构成");
        return resultMap;
    }

    /**
     * 获取全市卫生人员饼图数据
     * @param series
     * @param staffData
     * @return
     */
    private List<String> getStaffPieData(List<Map<String,Object>>  series,Map<String,Object> staffData){
        List<String> result = new ArrayList<>();
        series.add(putPieData(staffData.get("CY_TYPE1"),"卫生人员"));
        series.add(putPieData(staffData.get("CY_TYPE2"),"卫生技术人员"));
        series.add(putPieData(staffData.get("CY_TYPE3"),"执业(助理)医师"));
        series.add(putPieData(staffData.get("CY_TYPE4"),"注册护士"));
        series.add(putPieData(staffData.get("CY_TYPE5"),"卫生监督员"));
        series.add(putPieData(staffData.get("CY_TYPE6"),"管理人员"));
        result.add("卫生人员");
        result.add("卫生技术人员");
        result.add("执业(助理)医师");
        result.add("注册护士");
        result.add("卫生监督员");
        result.add("管理人员");
        return result;
    }

    private Map<String, Object> putPieData(Object value,String name){
        Map<String, Object> data = new HashMap<String,Object>();
        data.put("value",value);
        data.put("name",name);
        return data;
    }

}