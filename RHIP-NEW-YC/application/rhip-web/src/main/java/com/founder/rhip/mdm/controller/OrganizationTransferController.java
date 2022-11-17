package com.founder.rhip.mdm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.ehr.entity.basic.ActivityInfoRh;
import com.founder.rhip.ehr.entity.basic.FamilyInfoRh;
import com.founder.rhip.ehr.entity.basic.PersonInfoRh;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecordRh;
import com.founder.rhip.ehr.entity.basic.TransferOperationLog;
import com.founder.rhip.ehr.entity.management.DmPersonInfoRh;
import com.founder.rhip.ehr.entity.management.DmReportInfoRh;
import com.founder.rhip.ehr.service.basic.ITransferLogService;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.repository.IDicItemDao;
import com.founder.rhip.mdm.service.IDictionaryService;



@Controller
@RequestMapping(value = "/transfer")
public class OrganizationTransferController extends BaseController{

	@Resource(name = "transferLogService")
	private ITransferLogService transferLogService;
	
	@Resource(name = "mdmDictionaryService")
	private IDictionaryService dictionaryService;
	
	@Resource(name="mdmDicItemDao")
	private IDicItemDao dicItemDao;
	
	private  static final String EHR_MODULE="个人档案";
	private  static final String FAMILY_MODULE="家庭档案";
	private  static final String CDM_REPORT="慢病报卡";
	private  static final String CDM_MANA_CARD="慢病管理卡";
	private  static final String ACTIVITY_MODULE="健康教育活动";
	private  static final String HM_OLDMAN="老年人健康管理";

	
	@RequestMapping(value = "/log/search")
	public String search(HttpServletRequest request, Model model) {
		
		List<String> moList = new ArrayList<String>();
		moList.add(EHR_MODULE);
		moList.add(FAMILY_MODULE);
		moList.add(CDM_REPORT);
		moList.add(CDM_MANA_CARD);
		moList.add(ACTIVITY_MODULE);
		moList.add(HM_OLDMAN);
		
		model.addAttribute("moList", moList);
		return "com.founder.mdm.transfer.organization.search";
	}
	
	@RequestMapping(value = "/log/villagesearch")
	public String villagesearch(HttpServletRequest request, Model model) {
		List<String> moList = new ArrayList<String>();
		moList.add(EHR_MODULE);
		moList.add(FAMILY_MODULE);
		moList.add(CDM_MANA_CARD);
		
		model.addAttribute("moList", moList);
		return "com.founder.mdm.transfer.village.search";
	}
	
	@RequestMapping(value = "/log/list")
	public String list(HttpServletRequest request,TransferOperationLog form, Model model) {
        
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		String result = null;

        switch(form.getModuleName()){
        case EHR_MODULE:
        	result = getEhrtransferLog(request,model,currentPage,form);
        	break;
        	
        case CDM_REPORT:
        	result = getTransferReportInfo(request, model, currentPage, form);
        	break;
        
        case CDM_MANA_CARD:
        	result = getManageCardTransferLog(request,model,currentPage,form);
        	break;
        	
        case FAMILY_MODULE:
        	result = getFamilyTransferLog(request,model,currentPage,form);
        	break;
        	
        case ACTIVITY_MODULE:
        	result = getActivityTransferLog(request,model,currentPage,form);
        	break;
        	
        case HM_OLDMAN:
           	result = ElderPhyExamTransferLog(request,model,currentPage,form);
        	break;
        	
        default:
            break;
        } 
		return result;
	}
	
	@RequestMapping(value = "/log/villagelist")
	public String villagelist(HttpServletRequest request,TransferOperationLog form, Model model) {
        
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		String result = null;

        switch(form.getModuleName()){
        case EHR_MODULE:
        	result = getEhrVillagetransferLog(request,model,currentPage,form);
        	break;
        
        case CDM_MANA_CARD:
        	result = getManageCardVillageTransferLog(request, model, currentPage, form);
        	break;
        	
        case FAMILY_MODULE:
        	result = getFamilyVillageTransferLog(request,model,currentPage,form);
        	break;
        	
        default:
            break;
        } 
		return result;
	}
	
	@RequestMapping("/villageSelect")
	@ResponseBody
	public SelectDTO<DicItem> getVillageSelectData(
			HttpServletRequest request,
			ModelMap model,
			@RequestParam(required = false, value = "inputValue") String villageName,
			@RequestParam(required = false, value = "currentPage") int indexPage) {

		Page page = super.getPage(request, indexPage);

		Criteria criteria = new Criteria("dicCode","FS990001");
		criteria.add("itemCode", OP.LIKE, "320581");

		if (ObjectUtil.isNotEmpty(villageName)) {
			criteria.add("itemName", OP.LIKE, villageName);
		}
		
		PageList<DicItem> villagedicItems = dicItemDao.getPageList(page, criteria);
		
		//PageList<DicItem> villagedicItems = dictionaryService.getDicItems(page, criteria);
		SelectDTO<DicItem> result = new SelectDTO<>(villagedicItems);
		return result;
	}
	
	//个人档案模块查询
    public String getEhrtransferLog(HttpServletRequest request, Model model,Integer indexPage,TransferOperationLog transferLog){
        Page page = super.getPage(request, indexPage);
 		
 		PageList<PersonInfoRh> ehrLogList=transferLogService.getEhrLogList(page,transferLog);
 		request.setAttribute("ehrLogList", ehrLogList.getList());
        request.setAttribute("page",ehrLogList.getPage());
    	
    	return "com.founder.mdm.transfer.organization.ehr.list";
    }
    
   //村委会个人档案模块查询
    public String getEhrVillagetransferLog(HttpServletRequest request, Model model,Integer indexPage,TransferOperationLog transferLog){
        Page page = super.getPage(request, indexPage);
 		
 		PageList<PersonInfoRh> ehrLogList=transferLogService.getVillageEhrLogList(page,transferLog);
 		for(PersonInfoRh personinfoRh : ehrLogList.getList()){
 			
 			Criteria criteria = new Criteria("dicCode","FS990001");
 			criteria.add("itemCode", personinfoRh.getGbCode());
 			
 			DicItem dicItem = dicItemDao.get(criteria);
 			personinfoRh.setVillageName(dicItem.getItemName());
 		}
 		
 		request.setAttribute("ehrLogList", ehrLogList.getList());
        request.setAttribute("page",ehrLogList.getPage());
    	
    	return "com.founder.mdm.transfer.village.ehr.list";
    }
    
    //慢病报卡模块查询
    public String getTransferReportInfo(HttpServletRequest request, Model model,Integer indexPage,TransferOperationLog transferLog){
		Page page=super.getPage(request, indexPage);
    	PageList<DmReportInfoRh> reportList=transferLogService.getReportList(page, transferLog);
    	model.addAttribute("reportList",reportList.getList());
    	model.addAttribute("page",reportList.getPage());
    	return "com.founder.mdm.transfer.organization.report.list";
    }
	
	//机构迁移 慢病管理卡模块查询
    public String getManageCardTransferLog(HttpServletRequest request, Model model,Integer indexPage,TransferOperationLog transferLog){
        Page page = super.getPage(request, indexPage);
 		
 		PageList<DmPersonInfoRh> dmManaCardLogList=transferLogService.getCdmManaCardLogList(page,transferLog);
 		request.setAttribute("dmManaCardLogList", dmManaCardLogList.getList());
        request.setAttribute("page",dmManaCardLogList.getPage());
    	
    	return "com.founder.mdm.transfer.organization.managecard.list";
    }
    //村委会迁移 慢病管理卡查询
    public String getManageCardVillageTransferLog(HttpServletRequest request, Model model,Integer indexPage,TransferOperationLog transferLog){
        Page page = super.getPage(request, indexPage);
 		
 		PageList<DmPersonInfoRh> villageDmManaCardLogList=transferLogService.getVillageCdmManaCardLogList(page, transferLog);
 		request.setAttribute("VillageDmManaCardLogList", villageDmManaCardLogList.getList());
        request.setAttribute("page",villageDmManaCardLogList.getPage());
    	for(DmPersonInfoRh dmPersonInfoRh: villageDmManaCardLogList.getList()){
    		Criteria criteria = new Criteria("dicCode","FS990001");
    		criteria.add("itemCode", dmPersonInfoRh.getPastreet());
    		DicItem dicItem=dicItemDao.get(criteria);
    		dmPersonInfoRh.setVillageName(dicItem.getItemName());
    	}
    	return "com.founder.mdm.transfer.village.managecard.list";
    }
    
	//老年人健康管理模块查询
    public String ElderPhyExamTransferLog(HttpServletRequest request, Model model,Integer indexPage,TransferOperationLog transferLog){
        Page page = super.getPage(request, indexPage);
 		
 		PageList<PhysicalExamRecordRh> elderPhyExamLogList=transferLogService.getElderPhyExamLogList(page,transferLog);
 		request.setAttribute("elderphyexamLogList", elderPhyExamLogList.getList());
        request.setAttribute("page",elderPhyExamLogList.getPage());
    	
    	return "com.founder.mdm.transfer.organization.eldphyexam.list";
    }
    
	//机构家庭档案模块迁移查询
    public String getFamilyTransferLog(HttpServletRequest request, Model model, Integer indexPage, TransferOperationLog transferLog){
    	Page page = super.getPage(request, indexPage);
    	PageList<FamilyInfoRh> familyLogList = transferLogService.getFamilyLogList(page, transferLog);
    	request.setAttribute("familyLogList", familyLogList.getList());
    	request.setAttribute("page", familyLogList.getPage());
    	return "com.founder.mdm.transfer.organization.family.list"; 
    }
    
  //村委会家庭档案模块查询
    public String getFamilyVillageTransferLog(HttpServletRequest request, Model model, Integer indexPage, TransferOperationLog transferLog){
    	Page page = super.getPage(request, indexPage);
    	
    	PageList<FamilyInfoRh> ehrLogList = transferLogService.getVillageFamilyLogList(page,transferLog);
    	Criteria criteria = new Criteria("dicCode","FS990001");
    	for(FamilyInfoRh list : ehrLogList.getList()){  		
    		criteria.add("itemCode", list.getGbCode());
    		DicItem name = dicItemDao.get(criteria);
    		list.setGbCode(name.getItemName());    		
    	}
    	request.setAttribute("ehrLogList", ehrLogList.getList());
    	request.setAttribute("page", ehrLogList.getPage());
    	
    	return "com.founder.mdm.transfer.village.family.list";
    }

    
  //健康活动模块查询
    public String getActivityTransferLog(HttpServletRequest request, Model model, Integer indexPage, TransferOperationLog transferLog){
    	Page page = super.getPage(request, indexPage);
    	PageList<ActivityInfoRh> activityLogList = transferLogService.getActivityLogList(page, transferLog);	
    	request.setAttribute("activityLogList", activityLogList.getList());
    	request.setAttribute("page", activityLogList.getPage());
    	return "com.founder.mdm.transfer.organization.activity.list"; 
    } 

}
