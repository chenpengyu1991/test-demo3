package com.founder.rhip.da.controller;

import java.util.Date;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.da.controller.form.ConsumableMonitoringQueryForm;
import com.founder.rhip.da.service.IConsumableMonitoringService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 卫生耗材
 * 
 * 
 * @version 1.0, 2014-1-21
 * @author Ye jianfei
 */
@Controller
@RequestMapping(value = "/da/consumable")
public class ConsumableController extends DaBaseController {
	
    @Resource(name = "consumableMonitoringService")
    private IConsumableMonitoringService consumableMonitoringService;

    
    /**
	 * 进入入库监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/in/search")
	public String inSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.consumable.in.search";
	}


    /**
     * 入库监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/in/list")
    public String inList(ConsumableMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getInCriteria();

        PageList<Map<String, Object>> plist = consumableMonitoringService.getInList(buildPage(request), ca);
        model.addAttribute("consumableIns", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.consumable.in.list";
    }

    /**
	 * 进入入库详细查询画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/in/detail/search")
	public String inDetailSearch(ConsumableMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		model.addAttribute("batchNo", form.getBatchNo());	
		return "rhip.da.consumable.in.detail.search";
	}

    /**
	 * 进入入库详细列表画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/in/detail/list")
	public String inDetailList(ConsumableMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
	   	Criteria ca = form.getInDetailCriteria();
        PageList<Map<String, Object>> plist = consumableMonitoringService.getInDetailList(buildPage(request), ca);
        model.addAttribute("consumableInDetails", plist.getList());
        model.addAttribute("page", plist.getPage());	
		return "rhip.da.consumable.in.detail.list";
	}
	
    /**
	 * 进入出库监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/out/search")
	public String outSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.consumable.out.search";
	}


    /**
     * 出库监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/out/list")
    public String outList(ConsumableMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getOutCriteria();

        PageList<Map<String, Object>> plist = consumableMonitoringService.getOutList(buildPage(request), ca);
        model.addAttribute("consumableOuts", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.consumable.out.list";
    }

    /**
	 * 进入出库详细查询画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/out/detail/search")
	public String outDetailSearch(ConsumableMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
		model.addAttribute("batchNo", form.getBatchNo());	
		return "rhip.da.consumable.out.detail.search";
	}

    /**
	 * 进入出库详细列表画面
	 * @param form
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/out/detail/list")
	public String outDetailList(ConsumableMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
	   	Criteria ca = form.getOutDetailCriteria();
        PageList<Map<String, Object>> plist = consumableMonitoringService.getOutDetailList(buildPage(request), ca);
        model.addAttribute("consumableOutDetails", plist.getList());
        model.addAttribute("page", plist.getPage());	
		return "rhip.da.consumable.out.detail.list";
	}

    /**
	 * 进入库存监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/store/search")
	public String storeSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.consumable.store.search";
	}


    /**
     * 库存监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/store/list")
    public String storeList(ConsumableMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getStoreCriteria();

        PageList<Map<String, Object>> plist = consumableMonitoringService.getStoreList(buildPage(request), ca);
        model.addAttribute("stores", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.consumable.store.list";
    }
    
    /**
	 * 进入报损监控查询画面
	 * @param request
	 * @param model
	 * @return 
	 */
	@RequestMapping("/breakage/search")
	public String breakageSearch(HttpServletRequest request,ModelMap model) {
		Date firstDate = firstDateOfMonth(new Date());
		Date lastDate = lastDateOfMonth(new Date());
		model.addAttribute("firstDate", firstDate);
		model.addAttribute("lastDate", lastDate);	
		return "rhip.da.consumable.breakage.search";
	}


    /**
     * 报损监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/breakage/list")
    public String breakageList(ConsumableMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getBreakageCriteria();

        PageList<Map<String, Object>> plist = consumableMonitoringService.getBreakageList(buildPage(request), ca);
        model.addAttribute("breakages", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.consumable.breakage.list";
    }

}
