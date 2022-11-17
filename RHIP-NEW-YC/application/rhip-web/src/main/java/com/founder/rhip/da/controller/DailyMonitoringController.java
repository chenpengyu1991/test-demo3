package com.founder.rhip.da.controller;

import java.util.Date;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.da.controller.form.DailyMonitoringQueryForm;
import com.founder.rhip.da.service.IDaMonitoringService;
import com.founder.rhip.da.service.IDailyMonitoringService;
import com.founder.rhip.da.service.IDrugMonitoringService;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/da/daily")
public class DailyMonitoringController extends DaBaseController {
	
    @Resource(name = "dailyMonitoringService")
    private IDailyMonitoringService dailyMonitoringService;

    @Resource(name = "drugMonitoringService")
    private IDrugMonitoringService drugMonitoringService;

    @Resource(name = "daMonitoringService")
    private IDaMonitoringService daMonitoringService;

    /**
	 * 进入异常处方监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/unusual/search")
	public String unusualSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.daily.unusual.search";
	}


    /**
     * 异常处方查询结果画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/unusual/list")
    public String unusualList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getUnusualCriteria();
    	Map<String,String> paramMap = form.getUnusualParamMap();
        PageList<Map<String, Object>> plist = dailyMonitoringService.getUnusualPrescriptionList(buildPage(request), ca, form.getUnusualOrder(),form.getMonitorIndex(),paramMap);
        model.addAttribute("unusuals", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("monitorIndex",form.getMonitorIndex());
        return "rhip.da.daily.unusual.list";
    }

    /**
     * 处方详细画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/unusual/prescription")
    public String prescription(String ehrId,String recordNumber,HttpServletRequest request,ModelMap model) {
    	OutpatientPrescription result = dailyMonitoringService.getOutpatientPrescription(ehrId, recordNumber);
        model.addAttribute("prescription",result);
        model.addAttribute("ehrId",ehrId);
        model.addAttribute("recordNumber",recordNumber);
        return "rhip.da.daily.unusual.prescription";
    }
    
    /**
     * 处方详细用药列表画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/unusual/drugusagelist")
    public String drugusagelist(String ehrId,String recordNumber,HttpServletRequest request,ModelMap model) {
    	Criteria criteria = new Criteria();
    	criteria.add("EHR_ID",ehrId).add("RECORD_NUMBER",recordNumber);
    	criteria.add("EXPENSE_TYPE",1);//药品/耗材/处置等标志，只查询药物
        PageList<DrugUsage> plist = dailyMonitoringService.getDrugUsageList(buildPage(request), criteria, new Order("UNIT_PRICE"));
        model.addAttribute("drugusages", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.daily.unusual.drugusagelist";
    }  
    
    /**
	 * 进入医师用药监控查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/physicianDrug/search")
	public String physicianDrugSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);		
		return "rhip.da.daily.physicianDrug.search";
	}    

    /**
     * 医师用药监控查询结果画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/physicianDrug/list")
    public String physicianDrugList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getPhysicianCriteria();

        PageList<Map<String, Object>> plist = dailyMonitoringService.getPhysicianDrugList(form.getPatientType(), buildPage(request), ca);
        model.addAttribute("physicianDrugs", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("prescribeDateBegin", form.getPrescribeDateBegin());//监督开始时间
        model.addAttribute("prescribeDateEnd", form.getPrescribeDateEnd());//监督结束时间
        model.addAttribute("patientType", form.getPatientType());//患者类型：门诊/住院
        
        return "rhip.da.daily.physicianDrug.list";
    }
    
    /**
     * 用药排名画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/physicianDrug/medicationRanking")
    public String medicationRanking(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	model.addAttribute("hospitalCode", form.getHospitalCode());//所属机构
    	model.addAttribute("drugCode", form.getDrugCode());//药品编码
        model.addAttribute("prescribeDateBegin", form.getPrescribeDateBegin());//监督开始时间
        model.addAttribute("prescribeDateEnd", form.getPrescribeDateEnd());//监督结束时间
        model.addAttribute("patientType", form.getPatientType());//患者类型：门诊/住院
        return "rhip.da.daily.physicianDrug.medicationRanking";
    }
    /**
     * 处方详细用药列表画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/physicianDrug/medicationlist")
    public String medicationlist(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria criteria = form.getMedicationRankingCriteria();
        PageList<Map<String, Object>> plist = dailyMonitoringService.getMedicationRankingList(form.getPatientType(), buildPage(request), criteria);
        model.addAttribute("medications", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("hospitalCode", form.getHospitalCode());//所属机构
        model.addAttribute("patientType", form.getPatientType());//患者类型：门诊/住院
        return "rhip.da.daily.physicianDrug.medicationlist";
    } 
    
    /**
	 * 进入门诊费用药品比例查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/outpatientDrug/search")
	public String outpatientDrugSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);
		return "rhip.da.daily.outpatientDrug.search";
	} 
	
    /**
     * 门诊费用药品比例查询结果画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/outpatientDrug/list")
    public String outpatientDrugList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getDrugRateCriteria();
        PageList<Map<String, Object>> plist = dailyMonitoringService.getDrugCostList(EventType.OUTPATIENT.getCode(), buildPage(request), ca);
        model.addAttribute("outpatientDrugs", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("prescribeDateBegin", form.getPrescribeDateBegin());//监督开始时间
        model.addAttribute("prescribeDateEnd", form.getPrescribeDateEnd());//监督结束时间
        model.addAttribute("patientType", form.getPatientType());//患者类型：门诊/住院
        return "rhip.da.daily.outpatientDrug.list";
    }
    
    /**
	 * 进入住院费用药品比例查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/inpatientDrug/search")
	public String inpatientDrugSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);
		return "rhip.da.daily.inpatientDrug.search";
	} 
	
    /**
     * 住院费用药品比例查询结果画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/inpatientDrug/list")
    public String inpatientDrugList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getDrugRateCriteria();
        PageList<Map<String, Object>> plist = dailyMonitoringService.getDrugCostList(EventType.INPATIENT.getCode(), buildPage(request), ca);
        model.addAttribute("inpatientDrugs", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("prescribeDateBegin", form.getPrescribeDateBegin());//监督开始时间
        model.addAttribute("prescribeDateEnd", form.getPrescribeDateEnd());//监督结束时间
        model.addAttribute("patientType", form.getPatientType());//患者类型：门诊/住院
        return "rhip.da.daily.inpatientDrug.list";
    }  
    
    /**
     * 门诊药品明细查询
     *
     * @param form
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/outpatientDrug/drugsearch")
    public String outpatientDetailSearch(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	model.addAttribute("hospitalCode", form.getHospitalCode());
    	model.addAttribute("prescribeDateBegin", form.getPrescribeDateBegin());//监督开始时间
        model.addAttribute("prescribeDateEnd", form.getPrescribeDateEnd());//监督结束时间
        model.addAttribute("drugCostSum", form.getDrugCostSum());//药品费用合计
    	return "rhip.da.daily.outpatientDrug.drugsearch";
    }
    
    /**
     * 门诊药品明细列表
     *
     * @param form
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/outpatientDrug/druglist")
    public String outpatientDetailList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getDrugDetailCriteria();
        PageList<Map<String, Object>> plist = dailyMonitoringService.getDrugDetailList(EventType.OUTPATIENT.getCode(), buildPage(request), ca);
        model.addAttribute("drugCostSum", form.getDrugCostSum());//药品费用合计      
        model.addAttribute("details", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.daily.outpatientDrug.druglist";
    }    
 
    /**
     * 住院药品明细查询
     *
     * @param form
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/inpatientDrug/drugsearch")
    public String inpatientDetailSearch(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	model.addAttribute("hospitalCode", form.getHospitalCode());
    	model.addAttribute("prescribeDateBegin", form.getPrescribeDateBegin());//监督开始时间
        model.addAttribute("prescribeDateEnd", form.getPrescribeDateEnd());//监督结束时间
        model.addAttribute("drugCostSum", form.getDrugCostSum());//药品费用合计        
    	return "rhip.da.daily.inpatientDrug.drugsearch";
    }
    
    /**
     * 住院药品明细列表
     *
     * @param form
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/inpatientDrug/druglist")
    public String inpatientDetailList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getDrugDetailCriteria();
        PageList<Map<String, Object>> plist = dailyMonitoringService.getDrugDetailList(EventType.INPATIENT.getCode(), buildPage(request), ca);
        model.addAttribute("drugCostSum", form.getDrugCostSum());//药品费用合计      
        model.addAttribute("details", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.daily.inpatientDrug.druglist";
    }   
 
    
    /**
     * 门诊费用明细查询
     *
     * @param form
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/outpatientDrug/itemsearch")
    public String outpatientItemSearch(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	model.addAttribute("hospitalCode", form.getHospitalCode());
    	model.addAttribute("prescribeDateBegin", form.getPrescribeDateBegin());//监督开始时间
        model.addAttribute("prescribeDateEnd", form.getPrescribeDateEnd());//监督结束时间
        model.addAttribute("totalCostSum", form.getTotalCostSum());//药品费用合计
    	return "rhip.da.daily.outpatientDrug.itemsearch";
    }
    
    /**
     * 门诊费用明细列表
     *
     * @param form
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/outpatientDrug/itemlist")
    public String outpatientItemList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getOutpatientItemCriteria();
        PageList<Map<String, Object>> plist = dailyMonitoringService.getItemDetailList(EventType.OUTPATIENT.getCode(), buildPage(request), ca);

        model.addAttribute("totalCostSum", form.getTotalCostSum());//药品费用合计      
        model.addAttribute("details", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.daily.outpatientDrug.itemlist";
    }   

    /**
     * 住院费用明细查询
     *
     * @param form
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/inpatientDrug/itemsearch")
    public String inpatientItemSearch(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	model.addAttribute("hospitalCode", form.getHospitalCode());
    	model.addAttribute("prescribeDateBegin", form.getPrescribeDateBegin());//监督开始时间
        model.addAttribute("prescribeDateEnd", form.getPrescribeDateEnd());//监督结束时间
        model.addAttribute("totalCostSum", form.getTotalCostSum());//药品费用合计
    	return "rhip.da.daily.inpatientDrug.itemsearch";
    }
    
    /**
     * 住院费用明细列表
     *
     * @param form
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/inpatientDrug/itemlist")
    public String inpatientItemList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getInpatientItemCriteria();
        PageList<Map<String, Object>> plist = dailyMonitoringService.getItemDetailList(EventType.INPATIENT.getCode(), buildPage(request), ca);

        model.addAttribute("totalCostSum", form.getTotalCostSum());//药品费用合计      
        model.addAttribute("details", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.daily.inpatientDrug.itemlist";
    } 

    /**
	 * 进入药品价格监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/drugPrice/search")
	public String drugPriceSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.daily.drugPrice.search";
	}


    /**
     * 药品价格监控列表画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/drugPrice/list")
    public String drugPriceList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getDrugPriceCriteria();
        PageList<Map<String, Object>> plist = dailyMonitoringService.getDrugPriceList(buildPage(request), ca);
        model.addAttribute("drugPrices", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.daily.drugPrice.list";
    }
 
    /**
	 * 进入药品分布监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/drugDistribution/search")
	public String drugDistributionSearch(HttpServletRequest request,ModelMap model) {
//		Date firstDate = firstDateOfMonth(new Date());
//		Date lastDate = lastDateOfMonth(new Date());
//		model.addAttribute("firstDate", firstDate);
//		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.daily.drugDistribution.search";
	}


    /**
     * 药品分布监控列表画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/drugDistribution/list")
    public String drugDistributionList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getDrugDistributionCriteria();
        PageList<Map<String, Object>> plist = daMonitoringService.getDrugDistributionList(buildPage(request), ca);
        model.addAttribute("drugDistributions", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.daily.drugDistribution.list";
    }


    /**
	 * 进入药品分布监控详细查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/drugDistribution/detailSearch")
	public String detailSearch(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		String type = form.getType();//类型（1药库入库；2药库库存；3药房库存；4科室库存）
		String medicareCode = form.getMedicareCode();//药品编码
		String genericName = form.getGenericName();//药品通用名
		String beginDt = form.getBeginDt();//监控开始时间
		String endDt = form.getEndDt();//监控结束时间	
		String organCode = form.getHospitalCode();//机构
		model.addAttribute("organCode", organCode);
		model.addAttribute("type", type);
		model.addAttribute("medicareCode", medicareCode);
		model.addAttribute("genericName", genericName);
		model.addAttribute("beginDt", beginDt);
		model.addAttribute("endDt", endDt);		
		return "rhip.da.daily.drugDistribution.detailSearch";
	}
	
    /**
     * 药品分布监控详细列表画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/drugDistribution/detailList")
    public String detailList(DailyMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getDistributionDetailCriteria();
    	String type = form.getType();
    	PageList<Map<String, Object>> plist = null;
    	String urlString ="";
    	switch (type){
    		case "1"://药库入库
    			plist = drugMonitoringService.getStorageInDetailList(buildPage(request), ca);
    	        model.addAttribute("storageInDetails", plist.getList());
    	        urlString = "rhip.da.drug.storageIn.detail.list";
    			break;
    		case "2"://药库库存
    			plist = drugMonitoringService.getStorageList(buildPage(request), ca);
    	        model.addAttribute("storages", plist.getList());    			
    	        urlString = "rhip.da.drug.storage.list";
    	        break;
    		case "3"://药房库存
    			ca.add("PHARMACY_TYPE_CODE",OP.IN,new String[]{"1","2"});
    			plist = drugMonitoringService.getPharmacyList(buildPage(request), ca);
    	        model.addAttribute("pharmacys", plist.getList()); 
    	        urlString = "rhip.da.drug.pharmacy.list";
    			break;
    		case "4"://科室库存
    			ca.add("PHARMACY_TYPE_CODE",OP.IN,new String[]{"3"});
    			plist = drugMonitoringService.getPharmacyList(buildPage(request), ca);
    	        model.addAttribute("pharmacys", plist.getList());  
    	        urlString = "rhip.da.drug.pharmacy.list";
    			break;    			
    	}
        model.addAttribute("page", plist.getPage());
        model.addAttribute("type",type);
        return urlString;
    }	
}
