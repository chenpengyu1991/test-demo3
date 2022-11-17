package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.report.RpSymptom;
import com.founder.rhip.ehr.service.report.IRpSymptomService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/report/rpSymptom")
public class RpSymptomController extends BaseController {

    @Autowired
    private IDictionaryApp dictionaryApp;

    @Resource(name = "rpSymptomService")
    private IRpSymptomService rpSymptomService;

    /**
     * 从就诊记录统计监测症状--50症状(初始页面)
     * * @return
     */
    @RequestMapping("/symptomTypeSearch/index")
    public String symptomTypeSearch(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/report/rpSymptom/symptomTypeList/list");
        model.addAttribute("listpath", "medicalTarget/symptomList.jsp");
        return "ihm.medical.symptom";
    }

    /**
     * 从就诊记录统计监测症状--50症状(查询)
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/symptomTypeList/list")
    public String symptomTypeList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        Map<String, String> paramMap = form.getParamMap();
        List<RpSymptom> rpSymptomsList = rpSymptomService.getSymptom(paramMap);
        this.fillTown(paramMap, rpSymptomsList);

        model.addAttribute("genreCode", paramMap.get("genreCode"));
        model.addAttribute("results", rpSymptomsList);
        return "ihm.medical.symptomlist";
    }

    /**
     //能够对监测症状进行分析
     * 近一年统计
     *
     * @param request
     * @return
     */
    @RequestMapping("/yearData")
    @ResponseBody
    public Object symptomData(HttpServletRequest request,String organCode, String gbCode) {
//        List<Object[]> symptomdata1 = new ArrayList<>(12);
//        List<Object[]> symptomdata2 = new ArrayList<>(12);
//        Map<String, List<Object[]>> result = new HashMap<>();
//        int year = DateUtil.getCurrentYear();
//        Calendar calendar = Calendar.getInstance();
//        int month = calendar.get(Calendar.MONTH) + 1;
//
//
//        Map<String, Object> monthMapA = new LinkedHashMap<>();
//        Map<String, Object> monthMapB = new LinkedHashMap<>();
//        for (int monthTemp = month + 1; monthTemp <= 12; monthTemp++) {
//            monthMapA.put(String.valueOf(year - 1) + "/" + StringUtils.leftPad(String.valueOf(monthTemp), 2, "0"), "");
//        }
//        for (int monthTemp = 1; monthTemp <= month; monthTemp++) {
//            monthMapA.put(String.valueOf(year) + "/" + StringUtils.leftPad(String.valueOf(monthTemp), 2, "0"), "");
//        }
//        monthMapB.putAll(monthMapA);
//
//
        Map<String, List<Object[]>> result = new HashMap<>();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("gbCode", gbCode);
        paramMap.put("organCode", organCode);
//        paramMap.put("beginDate", String.valueOf(year - 1) + "/" + String.valueOf(month + 1));
//        paramMap.put("endDate", DateUtil.toDateString(new Date(), "yyyy/MM"));
//        paramMap.put("type", "A");
//        List<Map<String, Object>> aResult = rpSymptomService.getSymptomMonth(paramMap);
//        paramMap.remove("type");
//        paramMap.put("type", "B");
//        List<Map<String, Object>> bResult = rpSymptomService.getSymptomMonth(paramMap);
//
//        for (String key : monthMapA.keySet()) {
//            Object[] data = new Object[2];
//            data[0] = DateUtil.parseSimpleDate(key, "yyyy/MM");
//            data[1] = 0;
//            for (Map<String, Object> mapTemp : aResult) {
//                if (key.equals(mapTemp.get("PMONTH"))) {
//                    monthMapA.put(key, mapTemp.get("ABCOUNT"));
//                    data[1] = mapTemp.get("ABCOUNT");
//                }
//            }
//            result.put("dataA", symptomdata1);
//            symptomdata1.add(data);
//        }
//        for (String key : monthMapB.keySet()) {
//            Object[] data = new Object[2];
//            data[0] = DateUtil.parseSimpleDate(key, "yyyy/MM");
//            data[1] = 0;
//            for (Map<String, Object> mapTemp : bResult) {
//                if (key.equals(mapTemp.get("PMONTH"))) {
//                    monthMapB.put(key, mapTemp.get("ABCOUNT"));
//                    data[1] = mapTemp.get("ABCOUNT");
//                }
//            }
//            symptomdata2.add(data);
//            result.put("dataB", symptomdata2);
//        }
        result = selectItem(result, paramMap, "FEVER","A1");
        result = selectItem(result, paramMap, "SYSTEMIC_PAIN","A2");
        result = selectItem(result, paramMap, "DISCOMFORT_FATIGUE","A3");
        result = selectItem(result, paramMap, "ENLARGED_LYMPH","A4");
        result = selectItem(result, paramMap, "MOUTH_BREATHING","A5");
        result = selectItem(result, paramMap, "SNEEZE","A6");
        result = selectItem(result, paramMap, "SORE_THROAT","A7");
        result = selectItem(result, paramMap, "COUGH","A8");
        result = selectItem(result, paramMap, "ABNORMAL_SPUTUM","A9");
        result = selectItem(result, paramMap, "BREATHING_CHEST_PAIN","A10");
        result = selectItem(result, paramMap, "DYSPNEA","A11");
        result = selectItem(result, paramMap, "NAUSEA_VOMITING","A12");
        result = selectItem(result, paramMap, "ABDOMINAL_PAIN","A13");
        result = selectItem(result, paramMap, "DIARRHEA","A14");
        result = selectItem(result, paramMap, "CONSTIPATION","A15");
        result = selectItem(result, paramMap, "FLATULENCE","A16");
        result = selectItem(result, paramMap, "APPETITE_LACK","A17");
        result = selectItem(result, paramMap, "RASH_MACULA","A18");
        result = selectItem(result, paramMap, "POPULAR_URTICARIA","A19");
        result = selectItem(result, paramMap, "URTICARIAL","A20");
        result = selectItem(result, paramMap, "ERYTHEMA_MULTIFORME","A21");
        result = selectItem(result, paramMap, "SPONTANEOUS_STASIS","A22");
        result = selectItem(result, paramMap, "PURPURA","A23");
        result = selectItem(result, paramMap, "WATER_HERPES","A24");
        result = selectItem(result, paramMap, "HEMATEMESIS","A25");
        result = selectItem(result, paramMap, "NASAL_BLEEDING","A26");
        result = selectItem(result, paramMap, "HEMOPTYSIS","A27");
        result = selectItem(result, paramMap, "HEMATURIA","A28");
        result = selectItem(result, paramMap, "STOMACH_BLOOD","A29");
        result = selectItem(result, paramMap, "FECAL_OCCULT_BLOOD","A30");
        result = selectItem(result, paramMap, "VAGINAL_BLEEDING","A31");
        result = selectItem(result, paramMap, "HEADACHE","A32");
        result = selectItem(result, paramMap, "DIZZINESS_VERTIGO","A33");
        result = selectItem(result, paramMap, "COMA","A34");
        result = selectItem(result, paramMap, "FEBRILE_CONVULSION","A35");
        result = selectItem(result, paramMap, "TREMOR","A36");
        result = selectItem(result, paramMap, "TETANY","A37");
        result = selectItem(result, paramMap, "ATAXIA","A38");
        result = selectItem(result, paramMap, "ANOMALOUS_REFLECTION","A39");
        result = selectItem(result, paramMap, "CRAMPS_SPASMS","A40");
        result = selectItem(result, paramMap, "BLURRED_VISION","A41");
        result = selectItem(result, paramMap, "DIPLOPIA","A42");
        result = selectItem(result, paramMap, "DYSPHONIA","A43");
        result = selectItem(result, paramMap, "SPEECH_DISORDERS","A44");
        result = selectItem(result, paramMap, "DYSPHAGIA","A45");
        result = selectItem(result, paramMap, "DRY_MOUTH","A46");
        result = selectItem(result, paramMap, "MYASTHENIA_GRAVIS","A47");
        result = selectItem(result, paramMap, "NO_URINE_OLIGURIA","A48");
        result = selectItem(result, paramMap, "HYPERHIDROSIS","A49");
        result = selectItem(result, paramMap, "SKIN_REDNESS","A50");
        result = selectItem(result, paramMap, "WAIST_PAIN","A51");
        result = selectItem(result, paramMap, "EYE_PAIN","A52");
        result = selectItem(result, paramMap, "CONJUNCTIVA_BLOOD","A53");
        return result;
    }

    private Map<String, List<Object[]>> selectItem(Map<String, List<Object[]>> result, Map<String, String> paramMap, String item, String showItem){
        List<Object[]> symptomdata = new ArrayList<>(12);
        int year = DateUtil.getCurrentYear();
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;

        Map<String, Object> monthMap = new LinkedHashMap<>();
        for (int monthTemp = month + 1; monthTemp <= 12; monthTemp++) {
            monthMap.put(String.valueOf(year - 1) + "/" + StringUtils.leftPad(String.valueOf(monthTemp), 2, "0"), "");
        }
        for (int monthTemp = 1; monthTemp <= month; monthTemp++) {
            monthMap.put(String.valueOf(year) + "/" + StringUtils.leftPad(String.valueOf(monthTemp), 2, "0"), "");
        }
        if (month==12) {
            paramMap.put("beginDate", String.valueOf(year) + "/" + String.valueOf(1));
        }else {
            paramMap.put("beginDate", String.valueOf(year - 1) + "/" + String.valueOf(month + 1));
        }
        paramMap.put("endDate", DateUtil.toDateString(new Date(), "yyyy/MM"));
        paramMap.remove("type");
        paramMap.put("type", item);
        List<Map<String, Object>> resultList = rpSymptomService.getSymptomMonth(paramMap);

        for (String key : monthMap.keySet()) {
            Object[] data = new Object[2];
            data[0] = DateUtil.parseSimpleDate(key, "yyyy/MM");
            data[1] = 0;
            for (Map<String, Object> mapTemp : resultList) {
                if (key.equals(mapTemp.get("PMONTH"))) {
                    data[1] = mapTemp.get("ABCOUNT");
                }
            }
            String itemKey = "data"+showItem;
            result.put(itemKey, symptomdata);
            symptomdata.add(data);
        }
        return result;
    }
    /**
     * 当查询条件按照镇查询时自动补充统计不到的镇
     * @param paramMap
     * @param rpSymptomsList
     */
    private void fillTown(Map<String, String> paramMap, List<RpSymptom> rpSymptomsList) {
        if(ObjectUtil.equals(paramMap.get("genreCode"), "0") && ObjectUtil.isNullOrEmpty(paramMap.get("gbCode"))) {
            //将合计的数据放在列表的最后  目的是让页面更友好
            RpSymptom totalRp = rpSymptomsList.get(rpSymptomsList.size()-1);
            rpSymptomsList.remove(rpSymptomsList.size()-1);
            //获取所有的镇
            Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
            List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
            for(DicItem dicItem : dicItems) {
                boolean flag = true;
                for(RpSymptom rpSymptom : rpSymptomsList) {
                    if(ObjectUtil.equals(rpSymptom.getGbCode(), dicItem.getItemCode())) {
                        flag = false;
                    }
                }
                if(flag) {
                    RpSymptom rpSymptom = new RpSymptom();
                    rpSymptom.setGbCode(dicItem.getItemCode());
                    rpSymptomsList.add(rpSymptom);
                }
            }
            rpSymptomsList.add(totalRp);
        }
    }

}