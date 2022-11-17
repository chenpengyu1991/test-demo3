package com.founder.rhip.da.controller;

import java.util.Date;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.da.controller.form.EquipmentMonitoringQueryForm;
import com.founder.rhip.da.service.IEquipmentMonitoringService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 设备监控
 * 
 * 
 * @version 1.0, 2014-1-21
 * @author Ye jianfei
 */
@Controller
@RequestMapping(value = "/da/equipment")
public class EquipmentController extends DaBaseController {
	
    @Resource(name = "equipmentMonitoringService")
    private IEquipmentMonitoringService equipmentMonitoringService;

    
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
		return "rhip.da.equipment.store.search";
	}


    /**
     * 库存监控查询列表画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/store/list")
    public String storeList(EquipmentMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getStoreCriteria();

        PageList<Map<String, Object>> plist = equipmentMonitoringService.getStoreList(buildPage(request), ca);
        model.addAttribute("stores", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.equipment.store.list";
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
		return "rhip.da.equipment.breakage.search";
	}


    /**
     * 报损监控查询结果画面
     * @param form
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/breakage/list")
    public String breakageList(EquipmentMonitoringQueryForm form,HttpServletRequest request,ModelMap model) {
    	Criteria ca = form.getBreakageCriteria();

        PageList<Map<String, Object>> plist = equipmentMonitoringService.getBreakageList(buildPage(request), ca);
        model.addAttribute("breakages", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.da.equipment.breakage.list";
    }

}
