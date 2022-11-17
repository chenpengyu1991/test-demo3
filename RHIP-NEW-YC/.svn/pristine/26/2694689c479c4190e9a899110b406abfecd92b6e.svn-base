package com.founder.rhip.ihm.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IDaTargetService;

/**
 * 疾病控制
 * 
 */
@Controller
@RequestMapping("/ihm/da/")
public class DaTargetController extends IHMBaseController {
	
    @Resource(name = "daTargetService")
    private IDaTargetService daTargetService;
    
	@RequestMapping("/index")
	public String index(Model model) {
		return "ihm.da.index";
	}
	
    @RequestMapping("/change")
    public String change(HttpServletRequest request, Model model) {
    	model.addAttribute("page", new Page(0,0));
    	model.addAttribute("searchUrl", "/ihm/da/changelist");
    	model.addAttribute("listpath", "daTarget/change/list.jsp");
    	model.addAttribute("type", "ihmDa");
    	initOrg(request,model);
        return "ihm.da.change";
    }	
    
    @RequestMapping("/changelist")
    public String changelist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
 		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage); 
		Criteria criteria = form.getDaChangeCriteria();    
        PageList<Map<String, Object>> plist = daTargetService.getChangeTargetList(page, criteria, form.getGenreCode());
        model.addAttribute("changelist", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("genreCode", form.getGenreCode());
        return "ihm.da.changelist";
    }
    /**
     * 出入库、库存全年合计
     * 
     */
    @RequestMapping("/changelistEcharts")
    public @ResponseBody Object changelistEcharts(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
    	Map<String,Object> allData = new HashMap<String,Object>();
		Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
		form.setBeginDate(year +"/01/01");
		form.setEndDate(year +"/12/31");
		form.setYearType("1");
		Criteria criteria = form.getDaChangeCriteria(); 
		Criteria criterias = form.getDaStorageCriteria(); 
		List<Map<String, Object>> clist = daTargetService.getChangeTargetSum(criteria,"0");
		List<Map<String, Object>> slist = daTargetService.getStorageTargetSum(criterias, "0");
		allData.put("STORAGEIN", clist.get(0).get("STORAGEINNUM")==null? 0:clist.get(0).get("STORAGEINNUM"));
	    allData.put("STORAGEOUT",  clist.get(0).get("STORAGEOUTNUM")==null? 0:clist.get(0).get("STORAGEOUTNUM"));
	    allData.put("PHARMACYIN",  clist.get(0).get("PHARMACYINNUM")==null? 0:clist.get(0).get("PHARMACYINNUM"));
	    allData.put("PHARMACYOUT",  clist.get(0).get("PHARMACYOUTNUM")==null? 0:clist.get(0).get("PHARMACYOUTNUM"));
	    allData.put("STORAGE", slist.get(0).get("STORAGENUM")==null? 0:slist.get(0).get("STORAGENUM"));
	    allData.put("PHARMACY", slist.get(0).get("PHARMACYNUM")==null? 0:slist.get(0).get("PHARMACYNUM"));
	    allData.put("year", year);
		return allData;
	}
      
    @RequestMapping("/storage")
    public String storage(HttpServletRequest request,Model model) {
    	model.addAttribute("page", new Page(0,0));
    	model.addAttribute("searchUrl", "/ihm/da/storagelist");
    	model.addAttribute("listpath", "daTarget/storage/list.jsp");
    	model.addAttribute("type", "ihmDa");
    	initOrg(request,model);
        return "ihm.da.storage";
    }	
    
    @RequestMapping("/storagelist")
    public String storagelist(HttpServletRequest request,TargetOrgQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage); 
		Criteria criteria = form.getDaStorageCriteria();  
        PageList<Map<String, Object>> plist = daTargetService.getStorageTargetList(page, criteria, form.getGenreCode());
        model.addAttribute("storagelist", plist.getList());
        model.addAttribute("page", plist.getPage());
        model.addAttribute("genreCode", form.getGenreCode());
        return "ihm.da.storagelist";
    }  
}