package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.im.service.medical.IRealNameAnalyseService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.util.*;

/**
 * 实名制就诊统计
 * add by yejianfei
 */
@Controller
@RequestMapping("/ihm/realname")
public class RealNameTargetController extends IHMBaseController {
 
    @Resource(name = "realNameAnalyseService")
    private IRealNameAnalyseService realNameAnalyseService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;


    @RequestMapping("/index")
    public String index(HttpServletRequest request,Model model) {
        return "ihm.realname.index";
    }

    @RequestMapping("/trend/index")
    public String trendIndex(HttpServletRequest request,Model model) {
        initOrg(request,model);
        model.addAttribute("monthRangeFlag","1");//不显示按月
        model.addAttribute("quarterRangeFlag","1");//不显示按季度
        model.addAttribute("rangeFlag","1");//不显示按时间段
        model.addAttribute("quarterRangeFlag","1");//不显示按季度
        model.addAttribute("firstHalfYearFlag","1");//不显示上半年
        model.addAttribute("secondHalfYearFlag","1");//不显示下半年
        //model.addAttribute("gbFlag","1");//不显示按镇
        return "ihm.realname.trend.index";
    }

    @RequestMapping("/ranking/index")
    public String rankingIndex(HttpServletRequest request,Model model) {
        initOrg(request,model);
        return "ihm.realname.ranking.index";
    }

    @RequestMapping("/trend/chart")
    @ResponseBody
    public Map<String, Object> trendChart(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria ca = form.getRealNameCriteria();
        Map<String,Object> trendMap = realNameAnalyseService.getMonthTrendMap(ca);
        boolean checkData = checkTrendData(trendMap,"month");
        if(checkData) {
            List<Map<String, Object>> series = new ArrayList<>();
            getTrendData("就诊人次", "bar", "month", "", series, trendMap, 0);
            getTrendData("实名就诊人次", "bar", "month_real", "", series, trendMap, 0);
            getTrendData("实名就诊率", "line", "month_real", "month", series, trendMap, 1);
            resultMap.put(LEGEND_JSON, new String[]{"就诊人次", "实名就诊人次", "实名就诊率"});
            resultMap.put(SERIES_JSON, series);
            List<String> xAxis = new ArrayList<String>(0);
            xAxis.add("1月");
            xAxis.add("2月");
            xAxis.add("3月");
            xAxis.add("4月");
            xAxis.add("5月");
            xAxis.add("6月");
            xAxis.add("7月");
            xAxis.add("8月");
            xAxis.add("9月");
            xAxis.add("10月");
            xAxis.add("11月");
            xAxis.add("12月");
            resultMap.put(XAXIS_JSON, xAxis);
            resultMap.put(YAXIS_JSON, getYAxisJson());
            resultMap.put("title", "实名就诊分析");
            resultMap.put("subTitle", form.getYearDate() + "年度数据");
            resultMap.put("unit", "人次");
            resultMap.put(TOOLTIP_JSON, Arrays.asList(new String[]{"人次","人次","%"}));
            resultMap.put("year", form.getYearDate());
        }
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    @RequestMapping("/ranking/chart")
    @ResponseBody
    public Map<String, Object> rankingChart(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria ca = form.getRealNameRankCriteria();
        String genreCode = form.getGenreCode();
        List<Map<String,Object>> prescriptionMap = realNameAnalyseService.getRankingMapList(ca);
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> xAxisList = new ArrayList<>();
        getRankingData(genreCode,series,prescriptionMap,xAxisList);

        List<Map<String,Object>> yAxisList = new ArrayList<>();
        yAxisList.add(addYAxis("实名就诊率","%"));

        resultMap.put(LEGEND_JSON,Arrays.asList(new String[]{"实名就诊率"}));
        resultMap.put(XAXIS_JSON,xAxisList);
        resultMap.put(YAXIS_JSON,yAxisList);
        resultMap.put(SERIES_JSON,series);
        resultMap.put(TOOLTIP_JSON, Arrays.asList(new String[]{"%"}));
        resultMap.put("unit","%");
        resultMap.put("title","实名就诊率排名");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    private List<String> getRankingData(String genreCode,List<Map<String,Object>>  series,List<Map<String,Object>> diagnosisMapList,List<String> xAxisList){
        List<String> result =  new ArrayList<>();
        List<Object> realnameData = new ArrayList<>();
        for(Map<String,Object> map:diagnosisMapList){
            realnameData.add(map.get("REALNAME_RATE").toString());
            xAxisList.add(getOrganName(genreCode,map));
            result.add(getOrganCode(genreCode.toString(),map));
        }

        Map<String,Object> seriesMap1 = addSeries("实名就诊率排名","bar",realnameData,0);
        series.add(seriesMap1);
        return result;
    }
    /**
     * 组装实名制就诊月度趋势图数据
     * @param name 指标名称
     * @param type 指标类型
     * @param fieldNumerator 分子
     * @param fieldDenominator 分母
     * @param series
     * @param trendMap
     * @param yAxisIndex
     */
    private void getTrendData(String name,String type,String fieldNumerator,String fieldDenominator, List<Map<String,Object>>  series,Map<String,Object> trendMap,Integer yAxisIndex){
        List<Object> seriesDatas = new ArrayList<>();
        for(int i = 1;i<13;i++){
            String numerator = ObjectUtil.isNotEmpty(trendMap.get(fieldNumerator + i))?trendMap.get(fieldNumerator + i).toString():"0";
            //如果分母为空，直接取分子的值
            if(StringUtil.isNullOrEmpty(fieldDenominator)) {
                numerator = ObjectUtil.isNotEmpty(trendMap.get(fieldNumerator + i))?trendMap.get(fieldNumerator + i).toString():numerator;
                seriesDatas.add(numerator);
            }else{
                String denominator = ObjectUtil.isNotEmpty(trendMap.get(fieldDenominator + i))?trendMap.get(fieldDenominator + i).toString():"0";;
                String s = "";
                Float numeratorF = NumberUtil.convert(numerator,Float.class);
                Float denominatorF = NumberUtil.convert(denominator,Float.class);
                DecimalFormat df = new DecimalFormat("0.00");//格式化小数
                if("0".equals(trendMap.get(fieldDenominator + i).toString())){
                    s = "0.00";
                }else {
                    s = df.format((numeratorF / denominatorF) * 100);//返回的是String类型
                }
                seriesDatas.add(s);
            }
        }
        Map<String,Object> seriesMap = addSeries(name,type,seriesDatas,yAxisIndex);
        series.add(seriesMap);
    }

    /**
     * 如果都是空，表明没有数据
     * @param trendMap
     * @param field
     * @return
     */
    private boolean checkTrendData(Map<String,Object> trendMap,String field){
        boolean result = false;
        for(int i = 1;i<13;i++){
            if(ObjectUtil.isNotEmpty(trendMap.get(field + i))){
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Y轴数据（双轴）
     * @return
     */
    private List<Map<String,Object>> getYAxisJson(){
        List<Map<String,Object>> result = new ArrayList<>();
        result.add(addYAxis("就诊人次","人次"));
        result.add(addYAxis("实名就诊率","%"));
        return result;
    }

    private String getOrganCode(String genreCode,Map<String,Object> dataMap){
        String result = "";
        if("0".equals(genreCode)){
            result = dataMap.get("GB_CODE").toString();

        }else{
            result= dataMap.get("ORGAN_CODE").toString();
        }
        return result;
    }

    private String getOrganName(String genreCode,Map<String,Object> dataMap){
        String result = "";
        if("0".equals(genreCode)){
            String gbCode = dataMap.get("GB_CODE").toString();
            DicItem dicItem = dictionaryApp.queryDicItem("FS990001",gbCode);
            if(ObjectUtil.isNotEmpty(dicItem)){
                result = dicItem.getItemName();
            }
        }else{
            String organCode = dataMap.get("ORGAN_CODE").toString();
            Organization org = organizationApp.queryOrgan(organCode);
            if(ObjectUtil.isNotEmpty(org)){
                result = org.getOrganName();
            }
        }
        return result;
    }
}