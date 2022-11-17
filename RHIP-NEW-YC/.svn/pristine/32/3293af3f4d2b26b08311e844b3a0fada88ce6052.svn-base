package com.founder.rhip.ihm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.ClinicalPathway;
import com.founder.rhip.ehr.entity.clinic.SickbedUseState;
import com.founder.rhip.ehr.service.ihm.IYiZhengService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IMedicalTargetService;
import com.founder.rhip.mdm.app.IDictionaryApp;

/**
 * 医疗服务-门急诊、住院、医院费用信息
 */
@Controller
@RequestMapping("/ihm/medical")
public class MedicalTargetController extends IHMBaseController {

	@Resource(name="medicalTargetService")
	private IMedicalTargetService medicalTargetService;
	
    @Resource(name = "ihmYiZhengService")
    private IYiZhengService yiZhengService;

    @Resource(name = "dictionaryApp")
    private IDictionaryApp dictionaryApp;

    /**
	 * 门诊信息查询
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
    @RequestMapping("/outpatient")
    public String outpatient(HttpServletRequest request,Model model) {
    	//列表URL
    	model.addAttribute("searchUrl", "/ihm/medical/outpatientlist");
    	//页面URL
    	model.addAttribute("listpath", "medicalTarget/outpatientList.jsp");
    	model.addAttribute("type", "outpatient");// 页面导航文字显示判断使用
    	initOrg(request,model);
        return "ihm.medical.outpatient";
    }	
    
    @RequestMapping("/outpatientlist")
    public String outpatientlist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		form.initMedical();
		List<Map<String, Object>> reports = medicalTargetService.getOutpatientList(form.getBeginDate()
        		,form.getEndDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode());
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.medical.outpatientlist";
    }

    /**
     * 住院信息查询
     *
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/inpatient")
    public String inpatient(HttpServletRequest request,Model model) {
    	//列表URL
    	model.addAttribute("searchUrl", "/ihm/medical/inpatientlist");
    	//页面URL
    	model.addAttribute("listpath", "medicalTarget/inpatientList.jsp");
    	initOrg(request,model);
        return "ihm.medical.inpatient";
    }	
    
    @RequestMapping("/inpatientlist")
    public String inpatientlist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
    	form.initMedical();
    	Map<String, String> paramMap = form.getParamMap();
        List<Map<String, Object>> reports = yiZhengService.statisticsHmHospitalize(paramMap);
        if("440303000000".equals(reports.get(0).get("GB_CODE")) && "0".equals(form.getGenreCode())){
            reports.remove(0);
        };
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode", form.getGenreCode());
        return "ihm.medical.inpatientlist";
        /*List<Map<String, Object>> reports = medicalTargetService.getInpatientList(form.getBeginDate()
        		,form.getEndDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode());
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.medical.inpatientlist";*/
    }
    
	/**
	 * 医院费用查询
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
    @RequestMapping("/hospitalCosts")
    public String hospitalCosts(HttpServletRequest request,Model model) {
    	//列表URL
    	model.addAttribute("searchUrl", "/ihm/medical/hospitalCostslist");
    	//页面URL
    	model.addAttribute("listpath", "medicalTarget/hospitalCostsList.jsp");
    	model.addAttribute("opEmHpMarkFlag","1");
    	model.addAttribute("type", "cost");// 页面导航文字显示判断使用
    	initOrg(request,model);
        return "ihm.medical.hospitalCosts";
    }

    @RequestMapping("/hospitalCostslist")
    public String hospitalCostslist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		form.initMedical();
		List<Map<String, Object>> reports = medicalTargetService.getHospitalCostsList(form.getBeginDate()
        		,form.getEndDate()
        		,form.getGenreCode()
        		,form.getGbCode()
        		,form.getSuperOrganCode()
        		,form.getOrganCode()
        		,form.getOpEmHpMark());
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.medical.hospitalCostslist";
    }
    
	/**
	 * 临床路径查询
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
    @RequestMapping("/clinicalPathway")
    public String clinicalPathway(HttpServletRequest request,Model model) {
        return "ihm.medical.clinicalPathway";
    }	
    
    @RequestMapping("/clinicalPathway/list")
    public String cpwList(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage); 
		Criteria criteria = form.getClinicalPathway();  
        PageList<ClinicalPathway> plist = medicalTargetService.getClinicalPathwayList(page, criteria);
        model.addAttribute("clinicalPathways", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "ihm.medical.clinicalPathway.list";
    } 
    
	/**
	 * 病床使用情况查询
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
    @RequestMapping("/sickbedUseState")
    public String sickbedUseState(HttpServletRequest request,Model model) {
        return "ihm.medical.sickbedUseState";
    }	
    
    @RequestMapping("/sickbedUseState/list")
    public String susList(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage); 
		Criteria criteria = form.getSickbedUseState();  
        PageList<SickbedUseState> plist = medicalTargetService.getSickbedUseStateList(page, criteria);
        model.addAttribute("sickbedUseStates", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "ihm.medical.sickbedUseState.list";
    }


    /**
     * 监测症状统计
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/symptom")
    public String symptom(HttpServletRequest request,Model model) {
        //列表URL
        model.addAttribute("searchUrl", "/ihm/medical/symptomlist");
        //页面URL
        model.addAttribute("listpath", "medicalTarget/symptomList.jsp");
    	model.addAttribute("organFlag", "1");
    	model.addAttribute("hospitalFlag", "1");
    	model.addAttribute("superOrganFlag", "1");
    	model.addAttribute("monthRangeFlag", "1");
    	model.addAttribute("quarterRangeFlag", "1");
    	model.addAttribute("rangeFlag", "1");
    	model.addAttribute("firstHalfYearFlag", "1");
    	model.addAttribute("secondHalfYearFlag", "1");
    	
        initOrg(request,model);
        return "ihm.medical.symptom";
    }

    @RequestMapping("/symptomlist")
    public String symptomlist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
        form.initMedical();
//        List<Map<String, Object>> reports = medicalTargetService.getSymptomList(form.getBeginDate()
//        		,form.getEndDate()
//        		,form.getGenreCode()
//        		,form.getGbCode()
//        		,form.getSuperOrganCode()
//        		,form.getOrganCode());

        //20140902改为中统计镇  temp数据
        List<Map<String, Object>> result = new ArrayList<>();
        String date = form.getBeginDate();
        String gbCode = form.getGbCode();
        if("2014".equals(date.substring(0,4))){
            result = tempData(gbCode);
        }

//        Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
//        if(StringUtil.isNotEmpty(gbCode)){
//            criteria.add("ITEM_CODE", gbCode);
//        }
//        List<DicItem> townList = dictionaryApp.queryDicItem(criteria);

        model.addAttribute("reports", result);
        model.addAttribute("genreCode",form.getGenreCode());
        return "ihm.medical.symptomlist";
    }
    
    /**
     * 监测症状分析
     *
     * @param request
     * @param form
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/symptom/data")
    @ResponseBody
    public Object symptomData(HttpServletRequest request,TargetOrgQueryForm form, ModelMap model) {
    	List<Object[]> symptomdata = new ArrayList<>(12);
		Map<String, List<Object[]>> result = new HashMap<>(53);
		for(int i = 0;i<1;i++){
			symptomdata = new ArrayList<>(12);
	    	for (int j=1;j<13;j++) {
	    		Object[] data = new Object[2];
				data[0] = DateUtil.parseSimpleDate(form.getYearDate() + "/" + String.format("%02d",j), "yyyy/MM");
				data[1] = 0;
				symptomdata.add(data);
	    	}			
			result.put("data" + i, symptomdata);
		}

        return result;
    }

    List<int[]> townList = new ArrayList();
    private void array(){
        for(int i=0; i< 15; i++){
            int[] tempTown = new int[53];
            for(int j=0; j< 53; j++){
                tempTown[j] = (int)(Math.random()*100);
            }
            if(townList.size()<16){
                townList.add(tempTown);
            }
        }
    }

    private List<Map<String, Object>> tempData(String gbCode){
        array();
        List<Map<String, Object>> result = new ArrayList<>();


        Map<String, Object> townMap01 = new HashMap<>();
        townMap01.put("organCode", "320581100000");//虞山镇
//        townMap01 = fillMapData(townMap01, new int[]{11,22,1,0,1,2,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,2,2,2,2});
        townMap01 = fillMapData(townMap01, townList.get(0));

        Map<String, Object> townMap02 = new HashMap<>();
        townMap02.put("organCode", "320581101000");//梅李镇
        townMap02 = fillMapData(townMap02, townList.get(1));

        Map<String, Object> townMap03 = new HashMap<>();
        townMap03.put("organCode", "320581102000");//海虞镇
        townMap03 = fillMapData(townMap03, townList.get(2));

        Map<String, Object> townMap04 = new HashMap<>();
        townMap04.put("organCode", "320581104000");//古里镇
        townMap04 = fillMapData(townMap04, townList.get(3));

        Map<String, Object> townMap05 = new HashMap<>();
        townMap05.put("organCode", "320581105000");//沙家浜镇
        townMap05 = fillMapData(townMap05, townList.get(4));

        Map<String, Object> townMap06 = new HashMap<>();
        townMap06.put("organCode", "320581106000");//支塘镇
        townMap06 = fillMapData(townMap06, townList.get(5));

        Map<String, Object> townMap07 = new HashMap<>();
        townMap07.put("organCode", "320581107000");//支塘镇
        townMap07 = fillMapData(townMap07, townList.get(6));

        Map<String, Object> townMap08 = new HashMap<>();
        townMap08.put("organCode", "320581107000");//支塘镇
        townMap08 = fillMapData(townMap08, townList.get(7));

        Map<String, Object> townMap09 = new HashMap<>();
        townMap09.put("organCode", "320581111000");//尚湖镇
        townMap09 = fillMapData(townMap09, townList.get(8));

        Map<String, Object> townMap10 = new HashMap<>();
        townMap10.put("organCode", "320581400000");//虞山林场
        townMap10 = fillMapData(townMap10, townList.get(9));

        Map<String, Object> townMap11 = new HashMap<>();
        townMap11.put("organCode", "320581401000");//常熟经济开发区
        townMap11 = fillMapData(townMap11, townList.get(10));

        Map<String, Object> townMap12 = new HashMap<>();
        townMap12.put("organCode", "320581402000");//常熟东南开发区
        townMap12 = fillMapData(townMap12, townList.get(11));

        Map<String, Object> townMap13 = new HashMap<>();
        townMap13.put("organCode", "320581403000");//常熟虞山尚湖旅游度假区
        townMap13 = fillMapData(townMap13, townList.get(12));

        Map<String, Object> townMap14 = new HashMap<>();
        townMap14.put("organCode", "320581404000");//江苏常熟服装城管理委员会
        townMap14 = fillMapData(townMap14, townList.get(13));

        Map<String, Object> townMap15 = new HashMap<>();
        townMap15.put("organCode", "320581405000");//碧溪街道办事处
        townMap15 = fillMapData(townMap15, townList.get(14));

        result.add(townMap01);
        result.add(townMap02);
        result.add(townMap03);
        result.add(townMap04);
        result.add(townMap05);
        result.add(townMap06);
        result.add(townMap07);
        result.add(townMap08);
        result.add(townMap09);
        result.add(townMap10);
        result.add(townMap11);
        result.add(townMap12);
        result.add(townMap13);
        result.add(townMap14);
        result.add(townMap15);

        if(StringUtil.isNullOrEmpty(gbCode)){
            return result;
        }else{
            List<Map<String, Object>> result1 = new ArrayList<>();
            for(Map<String, Object> map : result){
                if(map.get("organCode").equals(gbCode)){
                    result1.add(map);
                    break;
                }
            }
            return result1;
        }
    }

    private Map<String, Object> fillMapData(Map<String, Object> paramMap, int[] dates){
        for (int i = 0; i<dates.length; i++){
            paramMap.put("DATA"+String.valueOf(i), dates[i]);
        }
        return paramMap;
    }
}