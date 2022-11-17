package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.report.RpDiseases;
import com.founder.rhip.ehr.service.report.IRpDiseasesService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Disease;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report/rpDiseases")
public class RpDiseasesController extends BaseController {

    @Autowired
    private IDictionaryApp dictionaryApp;

    @Resource(name = "rpDiseasesService")
    private IRpDiseasesService rpDiseasesService;
    
    @Resource(name = "diseaseApp")
    private IDiseaseApp diseaseApp;

    /**
     * 从诊断记录中统计传染病--A、B类型传染病统计(初始页面)
     * * @return
     */
    @RequestMapping("/diseaseTypeSearch/index")
    public String diseaseTypeSearch(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/report/rpDiseases/diseaseTypeList/list");
        model.addAttribute("listpath", "diseaseTypeList.jsp");
        return "rhip.idm.statistics.diseaseTypeSearch";
    }

    /**
     * A、B类型传染病统计
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/diseaseTypeList/list")
    public String diseaseTypeList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        Map<String, String> paramMap = form.getParamMap();
        List<RpDiseases> rpDiseasesList = rpDiseasesService.getDiseases(paramMap);
        this.fillTown(paramMap, rpDiseasesList);

        model.addAttribute("genreCode", paramMap.get("genreCode"));
        model.addAttribute("results", rpDiseasesList);
        return "rhip.idm.statistics.diseaseTypeList";
    }

    /**
     * 能够对诊断的传染病分析
     * 近一年A、B类型传染病发病统计
     *
     * @param request
     * @return
     */
    @RequestMapping("/yearData")
    @ResponseBody
    public Map<String, Object> diseaseData(HttpServletRequest request,String organCode, String gbCode) {
        String[] last12Months = new String[12];  
        Calendar cal = Calendar.getInstance();  
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)+1); //要先+1,才能把本月的算进去 
        for (int i=0; i<12; i++) {  
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH)-1); //逐次往前推1个月  
            last12Months[11-i] = cal.get(Calendar.YEAR)+ "/" + StringUtils.leftPad(String.valueOf(cal.get(Calendar.MONTH)+1), 2, "0"); // 格式化日期格式
        }  
        Map<String, Object> ret = new HashMap<String, Object>();  
     /*   List<Object[]> diseaseData1 = new ArrayList<>(12);
        List<Object[]> diseaseData2 = new ArrayList<>(12);
        Map<String, List<Object[]>> result = new HashMap<>();
            int year = DateUtil.getCurrentYear();
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH) + 1;
            Map<String, Object> monthMapA = new LinkedHashMap<>();
            Map<String, Object> monthMapB = new LinkedHashMap<>();
            for (int monthTemp = month + 1; monthTemp <= 12; monthTemp++) {
                monthMapA.put(String.valueOf(year - 1) + "/" + StringUtils.leftPad(String.valueOf(monthTemp), 2, "0"), "");
            }
            for (int monthTemp = 1; monthTemp <= month; monthTemp++) {
                monthMapA.put(String.valueOf(year) + "/" + StringUtils.leftPad(String.valueOf(monthTemp), 2, "0"), "");
            }
            monthMapB.putAll(monthMapA);*/

        	
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("gbCode", gbCode);
            paramMap.put("organCode", organCode);
            paramMap.put("beginDate", last12Months[0]);
            paramMap.put("endDate", last12Months[last12Months.length-1]);
     /*       if (month==12) {
                paramMap.put("beginDate", String.valueOf(year) + "/" + String.valueOf(1));
            }else {
                paramMap.put("beginDate", String.valueOf(year - 1) + "/" + String.valueOf(month + 1));
            }
            paramMap.put("endDate", DateUtil.toDateString(new Date(), "yyyy/MM"));*/
            paramMap.put("type", "A");
            List<Map<String, Object>> aResult = rpDiseasesService.getDiseaseMonth(paramMap);
            paramMap.remove("type");
            paramMap.put("type", "B");
            List<Map<String, Object>> bResult = rpDiseasesService.getDiseaseMonth(paramMap);
            Object[] aDestRet = new Object[last12Months.length];
            Object[] bDestRet = new Object[last12Months.length];
            for (int i = 0; i < last12Months.length; i++) {
            	String month = last12Months[i];
            	boolean aMatch = false;
				for (Map<String, Object> map : aResult) {
					if (StringUtils.equals(month, String.valueOf(map.get("PMONTH")))) {
						aDestRet[i] = map.get("ABCOUNT");
						aMatch = true;
					}
				}
				if (!aMatch) {
					aDestRet[i] = 0;
				}
				boolean bMatch = false;
				for (Map<String, Object> map : bResult) {
					if (StringUtils.equals(month, String.valueOf(map.get("PMONTH")))) {
						bDestRet[i] = map.get("ABCOUNT");
						bMatch = true;
					}
				}
				if (!bMatch) {
					bDestRet[i] = 0;
				}
			}
//            for (String key : monthMapA.keySet()) {
//                Object[] data = new Object[2];
//                data[0] = DateUtil.parseSimpleDate(key, "yyyy/MM");
//                data[1] = 0;
//                for (Map<String, Object> mapTemp : aResult) {
//                    if (key.equals(mapTemp.get("PMONTH"))) {
////                    monthMapA.put(key, mapTemp.get("ABCOUNT"));
//                        data[1] = mapTemp.get("ABCOUNT");
//                    }
//                }
//                result.put("dataA", diseaseData1);
//                diseaseData1.add(data);
//            }
//            for (String key : monthMapB.keySet()) {
//                Object[] data = new Object[2];
//                data[0] = DateUtil.parseSimpleDate(key, "yyyy/MM");
//                data[1] = 0;
//                for (Map<String, Object> mapTemp : bResult) {
//                    if (key.equals(mapTemp.get("PMONTH"))) {
////                    monthMapB.put(key, mapTemp.get("ABCOUNT"));
//                        data[1] = mapTemp.get("ABCOUNT");
//                    }
//                }
//                diseaseData1.add(data);
//                result.put("dataB", diseaseData1);
//            }
        ret.put("range", last12Months);
        ret.put("aDestRet", aDestRet);
        ret.put("bDestRet", bDestRet);
        return ret;
    }

    /**
     * 当查询条件按照镇查询时自动补充统计不到的镇
     * @param paramMap
     * @param rpDiseasesList
     */
    private void fillTown(Map<String, String> paramMap, List<RpDiseases> rpDiseasesList) {
        if(ObjectUtil.equals(paramMap.get("genreCode"), "0") && ObjectUtil.isNullOrEmpty(paramMap.get("gbCode"))) {
            //将合计的数据放在列表的最后  目的是让页面更友好
            RpDiseases totalRp = rpDiseasesList.get(rpDiseasesList.size()-1);
            rpDiseasesList.remove(rpDiseasesList.size()-1);
            //获取所有的镇
            Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
            List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
            for(DicItem dicItem : dicItems) {
                boolean flag = true;
                for(RpDiseases rpDiseases : rpDiseasesList) {
                    if(ObjectUtil.equals(rpDiseases.getGbCode(), dicItem.getItemCode())) {
                        flag = false;
                    }
                }
                if(flag) {
                    RpDiseases rpDiseases = new RpDiseases();
                    rpDiseases.setGbCode(dicItem.getItemCode());
                    rpDiseasesList.add(rpDiseases);
                }
            }
            rpDiseasesList.add(totalRp);
        }
    }
    
    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
    	return "ihm.disease.statistics.view";
    }
    
    @RequestMapping("/search")
    public String search(HttpServletRequest request, Model model) {
    	 model.addAttribute("searchUrl", "/report/rpDiseases/list");
         model.addAttribute("listpath", "disease_list.jsp");
         model.addAttribute("disease", "disease");
         initOrg(request, model);
    	return "ihm.disease.statistics.search";
    }
    
    @RequestMapping("/list")
    @ResponseBody
    public List<Map<String, Object>> list(TargetOrgQueryForm form) {
    	List<Map<String, Object>> mapList = rpDiseasesService.getDiseaseMapList(form.getParamMap());
    	if (ObjectUtil.isNotEmpty(mapList)) {
			for (Map<String, Object> map : mapList) {
				if (ObjectUtil.isNullOrEmpty(map)) {
					continue;
				}
				Object diseaseCode = null;
				Disease disease = null;
				if (ObjectUtil.isNullOrEmpty(diseaseCode = map.get("DISEASECODE"))
						|| ObjectUtil.isNullOrEmpty(disease = diseaseApp.queryDisease(String.valueOf(diseaseCode)))) {
					continue;
				}
				String v = new StringBuilder(String.valueOf(diseaseCode)).append("(").append(disease.getDiseaseName()).append(")").toString();
				map.put("DISEASECODE", v);
			}
		}
    	return mapList;
    }

}