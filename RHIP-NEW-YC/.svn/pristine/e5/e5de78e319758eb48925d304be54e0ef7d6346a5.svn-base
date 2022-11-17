package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.im.service.whch.INeonateAnalyseService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 新生儿统计分析
 * add by yejianfei
 */
@Controller
@RequestMapping("/ihm/neonateAnalyse")
public class NeonateAnalyseTargetController extends IHMBaseController {
 
    @Resource(name = "neonateAnalyseService")
    private INeonateAnalyseService neonateAnalyseService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

	@RequestMapping("/index")
	public String index(Model model) {
        model.addAttribute("currentYear", new Date());
		return "ihm.neonate.index";
	}

    /**
     * 年度趋势图
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/trendChart")
    @ResponseBody
    public Map<String, Object> trendChart(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria ca = form.getNeonateCriteria("NEONATAL_BIRTHDAY");
        Map<String,Object> birthTrendMap = neonateAnalyseService.getBirthTrendMap(ca);
        ca = form.getNeonateCriteria("DELIVERY_DATE");
        Map<String,Object> defectTrendMap = neonateAnalyseService.getDefectTrendMap(ca);
        List<Map<String,Object>> series = new ArrayList<>();
        getTrendLineData("新生儿数",series,birthTrendMap,0);
        getTrendLineData("出生缺陷数",series,defectTrendMap,1);
        resultMap.put(LEGEND_JSON,new String[]{"新生儿数","出生缺陷数"});
        resultMap.put(SERIES_JSON,series);
        List<String> xAxis = new ArrayList<String>(0);
        xAxis.add("1月");xAxis.add("2月");xAxis.add("3月");xAxis.add("4月");
        xAxis.add("5月");xAxis.add("6月");xAxis.add("7月");xAxis.add("8月");
        xAxis.add("9月");xAxis.add("10月");xAxis.add("11月");xAxis.add("12月");
        resultMap.put(XAXIS_JSON, xAxis);
        resultMap.put(YAXIS_JSON,getYAxisJson());
        resultMap.put("title","新生儿统计分析");
        resultMap.put("subTitle",form.getYearDate() + "年度数据");
        resultMap.put("unit","条");
        resultMap.put(TOOLTIP_JSON, Arrays.asList(new String[]{"人","人"}));
        resultMap.put(EXTRA_TOOLTIP_JSON,Arrays.asList(new String[]{"(下钻)","(下钻)"}));
        resultMap.put("year",form.getYearDate());
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 性别构成页面
     * @param model
     * @param year
     * @param month
     * @param chartType
     * @return
     */
    @RequestMapping("/detail")
    public String detail(Model model, String year, String month, Integer chartType) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, NumberUtil.convert(year,Integer.class));
        if(StringUtil.isNotEmpty(month)){
            cal.set(Calendar.MONTH, NumberUtil.convert(month,Integer.class));
            Date startDt = DateUtil.firstDateOfMonth(cal.getTime());
            Date endDt = DateUtil.lastDateOfMonth(cal.getTime());
            model.addAttribute("beginDate", DateUtil.toFormatString("yyyy/MM/dd",startDt));
            model.addAttribute("endDate", DateUtil.toFormatString("yyyy/MM/dd",endDt));
            model.addAttribute("subTitle", DateUtil.toFormatString("yyyy年MM月",endDt));
        }else{
            Date startDt = DateUtil.firstDateOfYear(cal.getTime());
            Date endDt = DateUtil.lastDateOfYear(cal.getTime());
            model.addAttribute("beginDate", DateUtil.toFormatString("yyyy/MM/dd",startDt));
            model.addAttribute("endDate", DateUtil.toFormatString("yyyy/MM/dd",endDt));
            model.addAttribute("subTitle", DateUtil.toFormatString("yyyy年",endDt));
        }
        model.addAttribute("chartType",chartType);
        return "ihm.neonate.detail";
    }


    @RequestMapping("/genderComposeChart")
    @ResponseBody
    public Map<String, Object> genderComposeChart(TargetOrgQueryForm form, String subTitle, String type) {
        Map<String,Object> resultMap = new HashMap<>();
        //按年统计
        if("1".equals(type)){
            form.setRangeType("3");
            form.setYearType("1");
            String yearField = form.getBeginDate();
            form.setYearDate(NumberUtil.convert(yearField.substring(0,4),Integer.class));
            subTitle = yearField.substring(0,4) + "年";
        }
        Criteria ca = form.getNeonateCriteria("NEONATAL_BIRTHDAY");
        Map<String,Object> genderComposeMap = neonateAnalyseService.getGenderComposeMap(ca);


        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getGenderComposePieData(series,genderComposeMap);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","新生儿性别构成");
        resultMap.put("subTitle",subTitle);
        return resultMap;
    }

    @RequestMapping("/defectTypeChart")
    @ResponseBody
    public Map<String, Object> defectTypeChart(TargetOrgQueryForm form, String subTitle, String type) {
        Map<String,Object> resultMap = new HashMap<>();
        //按年统计
        if("1".equals(type)){
            form.setRangeType("3");
            form.setYearType("1");
            String yearField = form.getBeginDate();
            form.setYearDate(NumberUtil.convert(yearField.substring(0,4),Integer.class));
            subTitle = yearField.substring(0,4) + "年";
        }
        Criteria ca = form.getNeonateCriteria("DELIVERY_DATE");
        List<Map<String,Object>> defectTypeMap = neonateAnalyseService.getDefectTypeMap(ca);


        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getDefectTypePieData(series,defectTypeMap);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","出生缺陷构成");
        resultMap.put("subTitle",subTitle);
        return resultMap;
    }

    /**
     * 获取新生儿缺陷构成饼图数据
     * @param series
     * @param defectTypeMap
     * @return
     */
    private List<String> getDefectTypePieData(List<Map<String,Object>>  series,List<Map<String,Object>> defectTypeMap){
        List<String> result = new ArrayList<>();
        for(Map<String,Object> map:defectTypeMap){
            Object defectType = map.get("BIRTH_DEFECT_TYPE");
            String defectTypeName = "未知";
            if(ObjectUtil.isNotEmpty(defectType)){
                DicItem item = dictionaryApp.queryDicItem("CV0501016",defectType.toString());
                if(ObjectUtil.isNotEmpty(item)){
                    defectTypeName = item.getItemName();
                }
            }
            series.add(addPieData(map.get("DEFECT_TYPE_COUNT"),defectTypeName));
            result.add(defectTypeName);
        }
        return result;
    }

    /**
     * 获取新生儿出生构成饼图数据
     * @param series
     * @param genderComposeMap
     * @return
     */
    private List<String> getGenderComposePieData(List<Map<String,Object>>  series,Map<String,Object> genderComposeMap){
        List<String> result = new ArrayList<>();
        series.add(addPieData(genderComposeMap.get("GENDER1"),"男"));
        series.add(addPieData(genderComposeMap.get("GENDER2"),"女"));
        result.add("男");
        result.add("女");
        return result;
    }

    /**
     * Y轴数据（双轴）
     * @return
     */
    private List<Map<String,Object>> getYAxisJson(){
        List<Map<String,Object>> result = new ArrayList<>();
        result.add(addYAxis("新生儿数","人"));
        result.add(addYAxis("出生缺陷数","人"));
        return result;
    }
    /**
     * 组装新生儿出生趋势折线图数据
     * @param series
     * @return
     */
    private void getTrendLineData(String name, List<Map<String,Object>>  series,Map<String,Object> neonateMap,Integer yAxisIndex){
        List<Object> seriesDatas = new ArrayList<>();
        for(int i = 1;i<13;i++){
            seriesDatas.add(neonateMap.get("month" + i).toString());
        }
        Map<String,Object> seriesMap = addSeries(name,"line",seriesDatas,yAxisIndex);
        series.add(seriesMap);

    }

}