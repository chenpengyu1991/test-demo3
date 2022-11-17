package com.founder.rhip.report.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.report.RpInhospital;
import com.founder.rhip.ehr.service.ihm.IYiZhengService;
import com.founder.rhip.ehr.service.report.IRpInhospitalService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IPerformanceService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/report/rpInhosptial")
public class RpInhosptialController extends BaseController {

    @Resource(name = "performanceService")
    private IPerformanceService performanceService;

    @Resource(name = "rpInhosptialService")
    private IRpInhospitalService rpInhosptialService;
    
    @Autowired
	private IDictionaryApp dictionaryApp;

	@Resource(name = "ihmYiZhengService")
	private IYiZhengService yiZhengService;

    protected void initOrg(HttpServletRequest request, Model model) {
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate",DateUtil.lastDateOfMonth(new Date()));
    }
    
    /**
     * 统计病案质量
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/viewInpatientMedicalRecordQuality/index")
    public String viewInpatientMedicalRecordQuality(HttpServletRequest request, Model model) {
    	   initOrg(request, model);
    	   Page page = super.getPage(request, 1);
    	   model.addAttribute("page", page);
           model.addAttribute("searchUrl", "/report/rpInhosptial/viewInpatientMedicalRecordQuality/list");
           model.addAttribute("listpath", "inpatientMedicalRecordQualityList.jsp");
           return "pam.organPerformance.searchInpatientMedicalRecordQuality.index";
    }
    
    /**
     * 查看病案质量列表
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/viewInpatientMedicalRecordQuality/list")
    public String viewInpatientMedicalRecordQualityList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
		Map<String, String> paramMap = form.getParamMap();
		List<RpInhospital> rpInhospitalList = rpInhosptialService.getInpatientMedicalRecordQuality(paramMap);
		this.fillTown(paramMap, rpInhospitalList);
		
		model.addAttribute("genreCode", paramMap.get("genreCode"));
		model.addAttribute("results", rpInhospitalList);
		return "pam.organPerformance.searchInpatientMedicalRecordQuality.list";
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
    	model.addAttribute("searchUrl", "/report/rpInhosptial/inpatientlist");
    	//页面URL
    	model.addAttribute("listpath", "medicalTarget/inpatientList.jsp");
		//机构类型默认选择卫生院
		model.addAttribute("genreCodeSelect", 3);
		initOrg(request,model);
        return "ihm.medical.inpatient";
    }	
    
    @RequestMapping("/inpatientlist")
    public String inpatientlist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		form.initMedical();
		Map<String, String> paramMap = form.getParamMap();
		List<Map<String, Object>> reports = yiZhengService.statisticsHmHospitalize(paramMap);
		if("320581100000".equals(reports.get(0).get("GB_CODE")) && "0".equals(form.getGenreCode())){
			reports.remove(0);
		};
		model.addAttribute("reports", reports);
		model.addAttribute("genreCode", form.getGenreCode());
        return "ihm.medical.inpatientlist";
    }
    
    /**
     * 进入查询页面(服务能力指标)
     * @return
     */
    @RequestMapping("/clinicalPathway")
    public String search(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/report/rpInhosptial/clinicalPathwaylist");
        model.addAttribute("listpath", "listSt.jsp");
        return "ihm.clinicalPathway.index";
    }
    
    @RequestMapping("/clinicalPathwaylist")
    public String statistics(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
    	Map<String, String> paramMap = form.getParamMap();
		List<RpInhospital> result = rpInhosptialService.getClinicalPathwayStatistics(paramMap);
		model.addAttribute("genreCode", paramMap.get("genreCode"));
		model.addAttribute("summaryList", result);
        return "ihm.clinicalPathway.statistics";
    }
    
    //住院人均工作量考核(初始页面)
  	@RequestMapping("/organ/inhosptial/index")
  	public String organInhosptial(HttpServletRequest request, Model model) {
  		// 列表URL
  		model.addAttribute("searchUrl", "/report/rpInhosptial/organ/inhosptiallist");
  		// 页面URL
  		model.addAttribute("listpath", "inhospitalPerformanceList.jsp");
  		initOrg(request, model);
  		return "pam.organPerformance.index";
  	}

  	@RequestMapping("/organ/inhosptiallist")
  	public String oragnInhosptiallist(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
  		Map<String, String> paramMap = form.getParamMap();
		List<RpInhospital> result = rpInhosptialService.getRpInhospitalPerformanceOrg(paramMap);
  		this.fillTown(paramMap, result);
  	    
  	    model.addAttribute("result", result);
  	    model.addAttribute("genreCode", paramMap.get("genreCode"));
  		return "pam.organPerformance.inhosptial.performance.list";
  	}
  	
    /**
     * 当查询条件按照镇查询时自动补充统计不到的镇
     * @param paramMap
     * @param rpInhospitalList
     */
    private void fillTown(Map<String, String> paramMap, List<RpInhospital> rpInhospitalList) {
    	if(ObjectUtil.equals(paramMap.get("genreCode"), "0") && ObjectUtil.isNullOrEmpty(paramMap.get("gbCode"))) {
			//将合计的数据放在列表的最后  目的是让页面更友好
			RpInhospital totalRp = rpInhospitalList.get(rpInhospitalList.size()-1);
			rpInhospitalList.remove(rpInhospitalList.size()-1);
			//获取所有的镇
			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
			List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
			for(DicItem dicItem : dicItems) {
				boolean flag = true;
				for(RpInhospital rpInhospital : rpInhospitalList) {
					if(ObjectUtil.equals(rpInhospital.getGbCode(), dicItem.getItemCode())) {
						flag = false;
					}
				}
				if(flag) {
					RpInhospital rpInhospital = new RpInhospital();
					rpInhospital.setGbCode(dicItem.getItemCode());
					rpInhospitalList.add(rpInhospital);
				}
			}
			rpInhospitalList.add(totalRp);
		}
    }
}