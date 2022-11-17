package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.service.ILifeEventService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.entity.Disease;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 死因统计分析
 * add by yejianfei
 */
@Controller
@RequestMapping("/ihm/deathAnalys")
public class DeathAnalysTargetController extends IHMBaseController {
 
    @Resource(name = "lifeEventService")
    private ILifeEventService lifeEventService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    @Resource(name = "diseaseApp")
    private IDiseaseApp diseaseApp;

	@RequestMapping("/index")
	public String index(Model model) {
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",new Date());
		return "ihm.deathanalyse.index";
	}

    @RequestMapping("/tabIndex")
    public String tabIndex(HttpServletRequest request, Model model, String chartUrl) {
        initOrg(request,model);
        model.addAttribute("chartUrl",chartUrl);
        return "ihm.deathanalyse.chart";
    }

    @RequestMapping("/icd10ComposeChart")
    @ResponseBody
    public Map<String, Object> icd10ComposeChart(TargetOrgQueryForm form) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria criteria = form.getDeathAnalysCriteria();
        List<Map<String,Object>> icd10ComposeMapList = lifeEventService.getDeathICD10MapList(criteria);
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getIcd10ComposeMapPieData(series,icd10ComposeMapList);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","死因构成");
        return resultMap;
    }


    @RequestMapping("/personTypeComposeChart")
    @ResponseBody
    public Map<String, Object> personTypeComposeChart(TargetOrgQueryForm form) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria criteria = form.getDeathAnalysCriteria();
        List<Map<String,Object>> icd10ComposeMapList = lifeEventService.getPersonTypeMapList(criteria);
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> legends = getPersonTypeMapPieData(series,icd10ComposeMapList);
        resultMap.put(LEGEND_JSON,legends);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("title","人群分类构成");
        return resultMap;
    }

    /**
     * 获取死因构成饼图数据
     * @param series
     * @param icd10ComposeMapList
     * @return
     */
    private List<String> getIcd10ComposeMapPieData(List<Map<String,Object>>  series,List<Map<String,Object>> icd10ComposeMapList){
        List<String> result = new ArrayList<>();
        Integer totalCount = 0;
        Integer sumCount = 0;
        for(Map<String,Object> map:icd10ComposeMapList){
            String groupid = map.get("GROUPINGID").toString();
            String deathCount = map.get("DEATH_COUNT").toString();
            Integer deathCountInt = NumberUtil.convert(deathCount,Integer.class);
            String deathIcd = "";
            if("TOTAL".equals(groupid)){
                totalCount = deathCountInt;
            }else{
                deathIcd = map.get("DEATH_ICD").toString();
                sumCount += deathCountInt;
                Disease disease = diseaseApp.queryDisease(deathIcd);
                if(ObjectUtil.isNotEmpty(disease)){
                    result.add(disease.getDiseaseName());
                }
                String diseaseName = "";
                if(ObjectUtil.isNotEmpty(disease)){
                    diseaseName = disease.getDiseaseName();
                    series.add(addPieData(deathCountInt,diseaseName));
                }
            }
        }
/*        Integer otherCount = totalCount - sumCount;
        if(otherCount >0){
            result.add("其他");
            series.add(addPieData(otherCount,"其他"));
        }*/
        return result;
    }


    /**
     * 获取人群分类构成饼图数据
     * @param series
     * @param personTypeMapList
     * @return
     */
    private List<String> getPersonTypeMapPieData(List<Map<String,Object>>  series,List<Map<String,Object>> personTypeMapList){
        List<String> result = new ArrayList<>();
        if(ObjectUtil.isNotEmpty(personTypeMapList)){
            Map<String,Object> perTypeMap = personTypeMapList.get(0);
            Object deathCount1 = perTypeMap.get("DEATH_COUNT1");
            if(ObjectUtil.isNotEmpty(deathCount1)) {
                result.add("普通人群");
                series.add(addPieData(deathCount1, "普通人群"));
            }
            Object deathCount2 = perTypeMap.get("DEATH_COUNT2");
            if(ObjectUtil.isNotEmpty(deathCount2)) {
                result.add("孕产妇");
                series.add(addPieData(deathCount2,"孕产妇"));
            }
            Object deathCount3 = perTypeMap.get("DEATH_COUNT3");
            if(ObjectUtil.isNotEmpty(deathCount3)) {
                result.add("5岁以下");
                series.add(addPieData(deathCount3,"5岁以下"));
            }


        }
        return result;
    }
}