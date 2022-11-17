package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.common.ImConstants;
import com.founder.rhip.im.service.publicHealth.ILifeWayService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 生活方式分析
 * add by yejianfei
 */
@Controller
@RequestMapping("/ihm/lifeway")
public class LifeWayTargetController extends IHMBaseController {
 
    @Resource(name = "lifeWayService")
    private ILifeWayService lifeWayService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

	@RequestMapping("/index")
	public String index(Model model) {
		return "ihm.lifeway.index";
	}

    /**
     * 饮食习惯分析
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/eatingHabits")
    @ResponseBody
    public Map<String, Object> eatingHabitsChart(HttpServletRequest request, Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria ca = new Criteria();
        List<Map<String,Object>> targetMapList = lifeWayService.getLifeWayMapList(ca, ImConstants.EATING_HABITS);
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getEatingHabitsPieData(series,targetMapList);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","");
        resultMap.put("subTitle","");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 运动频率分析
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/trainFrequency")
    @ResponseBody
    public Map<String, Object> trainFrequencyChart(HttpServletRequest request, Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria ca = new Criteria("TRAIN_FREQUENCY_TYPE_CODE", OP.UEMPTY,"NULL");
        List<Map<String,Object>> targetMapList = lifeWayService.getLifeWayMapList(ca, ImConstants.TRAIN_FREQUENCY);
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getLifeWayPieData(series,"FS10208","TRAIN_FREQUENCY_TYPE_CODE","TRAIN_FREQUENCY_COUNT",targetMapList);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","");
        resultMap.put("subTitle","");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 吸烟频率分析
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/smodeStatus")
    @ResponseBody
    public Map<String, Object> smodeStatusChart(HttpServletRequest request, Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria ca = new Criteria("SMODE_STATUS_CODE", OP.UEMPTY,"NULL");
        List<Map<String,Object>> targetMapList = lifeWayService.getLifeWayMapList(ca, ImConstants.SMODE_STATUS);
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getLifeWayPieData(series,"CV0300101","SMODE_STATUS_CODE","SMODE_STATUS_COUNT",targetMapList);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","");
        resultMap.put("subTitle","");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 饮酒频率分析
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/drinkFrequency")
    @ResponseBody
    public Map<String, Object> drinkFrequencyChart(HttpServletRequest request, Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria ca = new Criteria("DRINK_FREQUENCY", OP.UEMPTY,"NULL");
        List<Map<String,Object>> targetMapList = lifeWayService.getLifeWayMapList(ca, ImConstants.DRINK_FREQUENCY);
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getLifeWayPieData(series,"FS10208","DRINK_FREQUENCY","DRINK_FREQUENCY_COUNT",targetMapList);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","");
        resultMap.put("subTitle","");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    /**
     * 获取饮食习惯构成饼图数据
     * @param series
     * @param targetMapList
     * @return
     */
    private List<String> getEatingHabitsPieData(List<Map<String,Object>>  series,List<Map<String,Object>> targetMapList){
        List<String> result = new ArrayList<>();
        if(ObjectUtil.isNotEmpty(targetMapList)){
            Map<String,Object> targetMap = targetMapList.get(0);
            series.add(addPieData(targetMap.get("HUNSU_EQUILIBRIUM"),"荤素均衡"));
            result.add("荤素均衡");
            series.add(addPieData(targetMap.get("MEAT_MAIN"),"荤食为主"));
            result.add("荤食为主");
            series.add(addPieData(targetMap.get("VEGETARIAN"),"素食为主"));
            result.add("素食为主");
            series.add(addPieData(targetMap.get("HALOPHILIC"),"嗜盐"));
            result.add("嗜盐");
            series.add(addPieData(targetMap.get("ADDICTED_OIL"),"嗜油"));
            result.add("嗜油");
            series.add(addPieData(targetMap.get("SUGAR_CRAVINGS"),"嗜糖"));
            result.add("嗜糖");
        }
        return result;
    }

    /**
     * 获取运动频率、吸烟状况、饮酒频率构成饼图数据
     * @param series
     * @param targetMapList
     * @return
     */
    private List<String> getLifeWayPieData(List<Map<String,Object>>  series
            ,String dicCode
            ,String dicCodeField
            ,String targetField
            ,List<Map<String,Object>> targetMapList){
        List<String> result = new ArrayList<>();
        for(Map<String,Object> targetMap:targetMapList){
            String targetName = "";
            Object trainFrequencyTypeCode = targetMap.get(dicCodeField);
            if(ObjectUtil.isNotEmpty(trainFrequencyTypeCode)){
                DicItem item = dictionaryApp.queryDicItem(dicCode,trainFrequencyTypeCode.toString());
                if(ObjectUtil.isNotEmpty(item)){
                    targetName = item.getItemName();
                }
            }
            series.add(addPieData(targetMap.get(targetField),targetName));
            result.add(targetName);
        }
        return result;
    }
}