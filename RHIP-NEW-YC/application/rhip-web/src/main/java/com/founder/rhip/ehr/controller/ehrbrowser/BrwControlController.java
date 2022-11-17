package com.founder.rhip.ehr.controller.ehrbrowser;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.cdm.service.IHighRiskService;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.ehr.entity.management.DmHighriskPersonInfo;
import com.founder.rhip.ehr.entity.management.DmPotentialPersonInfo;
import com.founder.rhip.ehr.repository.management.IDmHighriskPersonInfoDao;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.idm.common.ReportStatus;
import com.founder.rhip.idm.controller.form.ReportQueryForm;
import com.founder.rhip.idm.service.IFrTsService;
import com.founder.rhip.idm.service.IReportService;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.service.IDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.rhip.BaseController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 疾病控制
 * @author liuk
 *
 */
@Controller
@RequestMapping("/ehrbrowser/control")
public class BrwControlController extends BaseController {
	@Resource(name = "reportService")
	private IReportService reportService;

	@Resource(name = "frTsService")
	private IFrTsService frTsService;

	@Resource(name="mdmDictionaryService")
	private IDictionaryService mdmDictionaryService;

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;

	@Resource(name = "dmHighriskPersonInfoDao")
	private IDmHighriskPersonInfoDao highriskPersonInfoDao;

	@Resource
	private IHighRiskService highRiskService;

	@RequestMapping()
	public String index(String personId, ModelMap model){
		PersonInfo personInfo=personalRecordService.getPersonRecord(new Criteria("id",personId),"name","idcard","birthday","gender","signFlag");
		model.addAttribute("personInfo", personInfo);
		//添加高危人群标识
		DmHighriskPersonInfo highriskPersonInfo = highriskPersonInfoDao.get(new Criteria("personId", personId));
		if(ObjectUtil.isNotEmpty(highriskPersonInfo)){
			model.addAttribute("riskLevel", highriskPersonInfo.getRiskLevel());
		}else {
			List<DmPotentialPersonInfo> personInfoList = highRiskService.searchPotentialPerson(new Criteria("personId", personId), new Page(1,1));
			if(ObjectUtil.isNotEmpty(personInfoList)&&personInfoList.size()>0){
				model.addAttribute("riskLevel", "Y");
			}
		}
		model.addAttribute("leftFlag", "1");
		return "rhip.ehr.browser.control";
	}

	@RequestMapping("/controlIndex")
	public String diseaseControlIndex(HttpServletRequest request, ModelMap model){
		String url = "rhip.ehr.browser.controlIndex.list";

		ReportQueryForm form = new ReportQueryForm();
		form.setPersonId(request.getParameter("personId"));


		String indexPage = request.getParameter("indexPage")==null?"1":request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = form.getDiseaseControlCriteria();

		/*传染病类型*/
		if(StringUtil.isNotEmpty(form.getType()) && StringUtil.isEmpty(form.getInfectiousCode())){
			if(!"L".equals(form.getType())){
				ca.remove("infectiousCode");
				ca.add("infectiousCode", OP.IN, getInfectionByType("IDM00400"+form.getType()));
			}else{
				ca.remove("infectiousCode");
				ca.add("infectiousCode",OP.EQ, "99999");
			}
		}
		if(StringUtil.isNotEmpty(form.getInfectiousCode())){
			String parentInfCodes = "203,212,213,214,215,223,226";
			if(parentInfCodes.contains(form.getInfectiousCode())){
				ca.remove("infectiousCode");
				ca.add("infectiousCode",OP.IN, getInfectionByType2("IDM00400"+form.getType(),form.getInfectiousCode()));
			}
		}
		PageList<IdmReport> plist = reportService.findReport(ca,page);
		model.addAttribute("reports", plist);
		model.addAttribute("page", plist.getPage());
		return url;
	}

	@RequestMapping("/controlFollow")
	public String diseaseControlFollow(HttpServletRequest request, ModelMap model){
		String url = "rhip.ehr.browser.controlFollow.list";

		ReportQueryForm form = new ReportQueryForm();
		form.setPersonId(request.getParameter("personId"));

		String indexPage = request.getParameter("indexPage")==null?"1":request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = form.getDiseaseControlCriteria();

		//只有手足口病随访
		ca.add("INFECTIOUS_CODE", "311");
		ca.add("REPORT_STATUS", ReportStatus.HOSPITAL_VERIFY.getValue());
		PageList<IdmReport> plist = reportService.getFrList(ca, page);

		List<Long> idmids = new ArrayList<Long>();
		if(plist.getList().size()>0){
			for(IdmReport idmReport : plist.getList() ){
				idmids.add(idmReport.getIdmId());
			}
		}
		PageList<ListFr> follows = new PageList<>();
		if(null!= idmids && idmids.size()>0){
			for(int i=0; i<idmids.size(); i++){
				Criteria criteria = new Criteria("idmId", idmids.get(i));
				Order od = new Order("VISIT_DT", false);//正序
				follows = frTsService.findFrList(criteria, page, od);
			}
		}

		model.addAttribute("follows", follows.getList());
		model.addAttribute("page", follows.getPage());

		return url;
	}

	private List getInfectionByType(String type){
		Criteria criteria = new Criteria();
		criteria.add("DIC_CODE", OP.FLIKE, type);
		List<DicItem> dicItems = mdmDictionaryService.getDicItemsUseCache(criteria);
		List<String> result = new ArrayList<String>();
		for(DicItem dicItem : dicItems){
			result.add(dicItem.getItemCode());
		}
		return result;
	}

	private List getInfectionByType2(String type, String code){
		Criteria criteria = new Criteria();
		criteria.add("dicCode", OP.EQ, type);
		criteria.add("itemCode", OP.LIKE, code);
		List<DicItem> dicItems = mdmDictionaryService.getDicItems(criteria);
		List<String> result = new ArrayList<String>();
		for(DicItem dicItem : dicItems){
			result.add(dicItem.getItemCode());
		}
		return result;
	}
}
