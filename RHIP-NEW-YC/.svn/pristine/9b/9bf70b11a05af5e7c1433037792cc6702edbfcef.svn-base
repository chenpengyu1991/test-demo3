package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.service.IDiseaseDiagnosisInfoService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.im.service.medical.IDiagnosisService;
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
 * 诊断相关：疾病排名
 * add by yejianfei
 */
@Controller
@RequestMapping("/ihm/diagnosis")
public class DiagnosisTargetController extends IHMBaseController {
 
    @Resource(name = "diagnosisService")
    private IDiagnosisService diagnosisService;

    @Resource(name = "diseaseApp")
    private IDiseaseApp diseaseApp;

    @Resource(name = "diseaseDiagnosisInfoService")
    private IDiseaseDiagnosisInfoService diseaseDiagnosisInfoService;

	@RequestMapping("/rank")
	public String index(Model model) {
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",new Date());
		return "ihm.diagnosis.rank.index";
	}

    @RequestMapping("/rankingChart")
    @ResponseBody
    public Map<String, Object> rankingChart(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        Map<String,Object> resultMap = new HashMap<>();
        Criteria ca = form.getDiagnosisCriteria();
        List<Map<String,Object>> prescriptionMap = diagnosisService.getRankingMapList(ca);
        List<Map<String,Object>> series = new ArrayList<>();
        List<String> yAxisList = getRankingBarData(series,prescriptionMap);
        resultMap.put(LEGEND_JSON,Arrays.asList(new String[]{"疾病统计排名"}));
        resultMap.put(YAXIS_JSON,yAxisList);
        resultMap.put(SERIES_JSON,series);
        resultMap.put("unit","例");
        resultMap.put("title","疾病统计TOP10");
        logger.debug(convertToJSON(resultMap));
        return resultMap;
    }

    private List<String> getRankingBarData(List<Map<String,Object>>  series,List<Map<String,Object>> diagnosisMapList){
        List<String> result =  new ArrayList<>();
        List<String> diagnosisData = new ArrayList<>();
        for(Map<String,Object> map:diagnosisMapList){
            String diagnosisName = "";
            String diagnosisCode = map.get("DIAGNOSIS_CODE").toString();
            Disease disease = diseaseApp.getDisease(diagnosisCode);
            if(ObjectUtil.isNotEmpty(disease)){
                diagnosisName = disease.getDiseaseName();
            }
            diagnosisData.add(map.get("DIAGNOSIS_COUNT").toString());
            result.add(diagnosisName);
        }
        Map<String,Object> seriesMap = addSeries("疾病统计排名","bar",diagnosisData);
        series.add(seriesMap);
        return result;
    }


    private String getDiagnosisName(String diagnosisCode){
        String result = "";
        Disease disease = diseaseApp.getDisease(diagnosisCode);
        //如果疾病表disease中疾病名称为空，则从诊断表中获取
        if(ObjectUtil.isNotEmpty(disease)){
            result = disease.getDiseaseName();
        }else{
            result = diseaseDiagnosisInfoService.getDiseaseName(new Criteria("DIAGNOSIS_CODE",diagnosisCode));
        }
        return result;
    }

}