	package com.founder.rhip.da.controller;

import java.util.Date;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.da.controller.form.DrugMonitoringQueryForm;
import com.founder.rhip.da.service.IDrugMonitoringService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 药品监控
 * 
 * 
 * @version 1.0, 2014-1-16
 * @author Ye jianfei
 */
@Controller
@RequestMapping(value = "/da/drug")
public class DrugMonitoringController extends DaBaseController {
	
    @Resource(name = "drugMonitoringService")
    private IDrugMonitoringService drugMonitoringService;

    
    /**
	 * 进入药库入库监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storageIn/search")
	public String storageInSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.storageIn.search";
	}


    /**
     * 药库入库监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/storageIn/list")
    public String storageInList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getStorageInCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getStorageInList(buildPage(request), ca);
        model.addAttribute("storageIns", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.storageIn.list";
    }

    /**
	 * 进入药库入库详细查询画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storageIn/detail/search")
	public String storageDetailSearch(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		model.addAttribute("batchNo", form.getBatchNo());	
		model.addAttribute("organCode", form.getOrganCode());	
		model.addAttribute("medicareCode", form.getMedicareCode());	
		model.addAttribute("firstDt", form.getBeginDt());	
		model.addAttribute("lastDt", form.getEndDt());			
		return "rhip.da.drug.storageIn.detail.search";
	}

    /**
	 * 进入药库入库详细列表画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storageIn/detail/list")
	public String storageInDetailList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
	   	Criteria ca = form.getStorageInDetailCriteria();
        PageList<Map<String, Object>> plist = drugMonitoringService.getStorageInDetailList(buildPage(request), ca);
        model.addAttribute("storageInDetails", plist.getList());
        model.addAttribute("page", plist.getPage());	
		return "rhip.da.drug.storageIn.detail.list";
	}
	
    /**
	 * 进入药库出库监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storageOut/search")
	public String storageOutSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.storageOut.search";
	}


    /**
     * 药库出库监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/storageOut/list")
    public String storageOutList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getStorageOutCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getStorageOutList(buildPage(request), ca);
        model.addAttribute("storageOuts", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.storageOut.list";
    }

    /**
	 * 进入药库出库详细查询画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storageOut/detail/search")
	public String storageOutDetailSearch(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		model.addAttribute("batchNo", form.getBatchNo());	
		return "rhip.da.drug.storageOut.detail.search";
	}

    /**
	 * 进入药库出库详细列表画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storageOut/detail/list")
	public String storageOutDetailList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
	   	Criteria ca = form.getStorageOutDetailCriteria();
        PageList<Map<String, Object>> plist = drugMonitoringService.getStorageOutDetailList(buildPage(request), ca);
        model.addAttribute("storageOutDetails", plist.getList());
        model.addAttribute("page", plist.getPage());	
		return "rhip.da.drug.storageOut.detail.list";
	}

    /**
	 * 进入药库库存监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storage/search")
	public String storageSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.storage.search";
	}


    /**
     * 药库库存监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/storage/list")
    public String storageList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getStorageCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getStorageList(buildPage(request), ca);
        model.addAttribute("storages", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.storage.list";
    }
    
    /**
	 * 进入药库退库监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storageReturn/search")
	public String storageReturnSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.storageReturn.search";
	}


    /**
     * 药库退库监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/storageReturn/list")
    public String storageReturnList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getStorageReturnCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getStorageReturnList(buildPage(request), ca);
        model.addAttribute("storageReturns", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.storageReturn.list";
    }

    /**
	 * 进入药库退库详细查询画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storageReturn/detail/search")
	public String storageReturnDetailSearch(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		model.addAttribute("batchNo", form.getBatchNo());	
		return "rhip.da.drug.storageReturn.detail.search";
	}

    /**
	 * 进入药库退库详细列表画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/storageReturn/detail/list")
	public String storageReturnDetailList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
	   	Criteria ca = form.getStorageReturnDetailCriteria();
        PageList<Map<String, Object>> plist = drugMonitoringService.getStorageReturnDetailList(buildPage(request), ca);
        model.addAttribute("storageReturnDetails", plist.getList());
        model.addAttribute("page", plist.getPage());	
		return "rhip.da.drug.storageReturn.detail.list";
	} 
	
	   
    /**
	 * 进入药房入库监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyIn/search")
	public String pharmacyInSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.pharmacyIn.search";
	}


    /**
     * 药房入库监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/pharmacyIn/list")
    public String pharmacyInList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getPharmacyInCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getPharmacyInList(buildPage(request), ca);
        model.addAttribute("pharmacyIns", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.pharmacyIn.list";
    }

    /**
	 * 进入药房入库详细查询画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyIn/detail/search")
	public String pharmacyInDetailSearch(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		model.addAttribute("batchNo", form.getBatchNo());
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);
		return "rhip.da.drug.pharmacyIn.detail.search";
	}

    /**
	 * 进入药房入库详细列表画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyIn/detail/list")
	public String pharmacyInDetailList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
	   	Criteria ca = form.getPharmacyInDetailCriteria();
        PageList<Map<String, Object>> plist = drugMonitoringService.getPharmacyInDetailList(buildPage(request), ca);
        model.addAttribute("pharmacyInDetails", plist.getList());
        model.addAttribute("page", plist.getPage());	
		return "rhip.da.drug.pharmacyIn.detail.list";
	}

	
    /**
	 * 进入药房出库监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyOut/search")
	public String pharmacyOutSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.pharmacyOut.search";
	}


    /**
     * 药房出库监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/pharmacyOut/list")
    public String pharmacyOutList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getPharmacyOutCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getPharmacyOutList(buildPage(request), ca);
        model.addAttribute("pharmacyOuts", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.pharmacyOut.list";
    }

    /**
	 * 进入药房出库详细查询画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyOut/detail/search")
	public String pharmacyOutDetailSearch(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		model.addAttribute("batchNo", form.getBatchNo());
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);
		return "rhip.da.drug.pharmacyOut.detail.search";
	}

    /**
	 * 进入药房入库详细列表画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyOut/detail/list")
	public String pharmacyOutDetailList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
	   	Criteria ca = form.getPharmacyOutDetailCriteria();
        PageList<Map<String, Object>> plist = drugMonitoringService.getPharmacyOutDetailList(buildPage(request), ca);
        model.addAttribute("pharmacyOutDetails", plist.getList());
        model.addAttribute("page", plist.getPage());	
		return "rhip.da.drug.pharmacyOut.detail.list";
	}
	
    /**
	 * 进入药房库存监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacy/search")
	public String pharmacySearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.pharmacy.search";
	}


    /**
     * 药房库存监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/pharmacy/list")
    public String pharmacyList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getPharmacyCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getPharmacyList(buildPage(request), ca);
        model.addAttribute("pharmacys", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.pharmacy.list";
    }	
    
    /**
	 * 进入药房退库监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyReturn/search")
	public String pharmacyReturnSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.pharmacyReturn.search";
	}


    /**
     * 药房退库监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/pharmacyReturn/list")
    public String pharmacyReturnList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getPharmacyReturnCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getPharmacyReturnList(buildPage(request), ca);
        model.addAttribute("pharmacyReturns", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.pharmacyReturn.list";
    }

    /**
	 * 进入药房退库详细查询画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyReturn/detail/search")
	public String pharmacyReturnDetailSearch(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		model.addAttribute("batchNo", form.getBatchNo());	
		return "rhip.da.drug.pharmacyReturn.detail.search";
	}

    /**
	 * 进入药房退库详细列表画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyReturn/detail/list")
	public String pharmacyReturnDetailList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
	   	Criteria ca = form.getPharmacyReturnDetailCriteria();
        PageList<Map<String, Object>> plist = drugMonitoringService.getPharmacyReturnDetailList(buildPage(request), ca);
        model.addAttribute("pharmacyReturnDetails", plist.getList());
        model.addAttribute("page", plist.getPage());	
		return "rhip.da.drug.pharmacyReturn.detail.list";
	}     
	
    /**
	 * 进入药房退药监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyCancel/search")
	public String pharmacyCancelSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.pharmacyCancel.search";
	}


    /**
     * 药房退药监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/pharmacyCancel/list")
    public String pharmacyCancelList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getPharmacyCancelCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getPharmacyCancelList(buildPage(request), ca);
        model.addAttribute("pharmacyCancels", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.pharmacyCancel.list";
    }

    /**
	 * 进入药房退药详细查询画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyCancel/detail/search")
	public String pharmacyCancelDetailSearch(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		model.addAttribute("batchNo", form.getBatchNo());	
		return "rhip.da.drug.pharmacyCancel.detail.search";
	}

    /**
	 * 进入药房退药详细列表画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/pharmacyCancel/detail/list")
	public String pharmacyCancelDetailList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
	   	Criteria ca = form.getPharmacyCancelDetailCriteria();
        PageList<Map<String, Object>> plist = drugMonitoringService.getPharmacyCancelDetailList(buildPage(request), ca);
        model.addAttribute("pharmacyCancelDetails", plist.getList());
        model.addAttribute("page", plist.getPage());	
		return "rhip.da.drug.pharmacyCancel.detail.list";
	} 
	
    /**
	 * 进入药品养护监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/drugUpkeep/search")
	public String drugUpkeepSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.drug.drugUpkeep.search";
	}


    /**
     * 药品养护监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/drugUpkeep/list")
    public String drugUpkeepList(DrugMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getUpkeepCriteria();

        PageList<Map<String, Object>> plist = drugMonitoringService.getUpkeepList(buildPage(request), ca);
        model.addAttribute("upkeeps", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.drug.drugUpkeep.list";
    }	
}
