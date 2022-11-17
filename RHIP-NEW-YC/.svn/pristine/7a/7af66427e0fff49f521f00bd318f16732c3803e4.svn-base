package com.founder.rhip.ihm.controller;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ihm.controller.form.VaccineTargetQueryForm;
import com.founder.rhip.ihm.service.IVaccinationTargetService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

/**
 * 儿童接种疫苗
 * 
 * @author chen_wenbo
 * 
 */
@Controller
@RequestMapping("/ihm/vaccine")
public class ImmuneTargetController extends BaseController {
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@Resource(name = "vaccinationTargetService")
	private IVaccinationTargetService vaccinationTargetService;

	
	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		return "ihm.vaccine.index";
	}
	
	/**
	 * 儿童副反应
	 * 
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/sideEffect")
	public String sideEffect(HttpServletRequest request,
			VaccineTargetQueryForm form, Model model) {
		Page page = new Page(0, 0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy/MM/dd");
		model.addAttribute("listpage", "sideEffectList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/vaccine/sideEffectlist"); //查询请求路径
		return "ihm.vaccine.sideEffectSearch";
	}

	/**
	 * 儿童副反应
	 * 
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/sideEffectlist")
	public String sideEffectlist(HttpServletRequest request,
			VaccineTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		Criteria criteria = this.buildCriteria(form);
		PageList<Map<String, Object>> plist = vaccinationTargetService.getSideEffectlist(page, criteria);
		model.addAttribute("sideEffectlist", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "ihm.vaccine.sideEffectList";
	}

	/**
	 * 儿童副反应
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/sideEffectDetail")
	public String sideEffectDetail(HttpServletRequest request, Model model, String id) {
		Object obj = vaccinationTargetService.getSideEffect(id);
		model.addAttribute("obj", obj);
		return "ihm.vaccine.sideEffectDetail";
	}
	
	/**
	 * 禁忌
	 * 
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/taboo")
	public String taboo(HttpServletRequest request,
			VaccineTargetQueryForm form, Model model) {
		Page page = new Page(0, 0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy/MM/dd");
		model.addAttribute("listpage", "tabooList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/vaccine/taboolist"); //查询请求路径
		return "ihm.vaccine.tabooSearch";
	}

	/**
	 * 禁忌
	 * 
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/taboolist")
	public String taboolist(HttpServletRequest request,
			VaccineTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		Criteria criteria = this.buildCriteria(form);
		PageList<Map<String, Object>> plist = vaccinationTargetService.getTaboolist(page, criteria);
		model.addAttribute("taboolist", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "ihm.vaccine.tabooList";
	}

	/**
	 * 禁忌
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/tabooDetail")
	public String tabooDetail(HttpServletRequest request, Model model, String id) {
		Object obj = vaccinationTargetService.getTaboo(id);
		model.addAttribute("obj", obj);
		return "ihm.vaccine.tabooDetail";
	}
	
	@RequestMapping("/vaccine")
	public String vaccine(HttpServletRequest request,
			VaccineTargetQueryForm form, Model model) {
		Page page = new Page(0, 0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy/MM/dd");
		model.addAttribute("listpage", "vaccineList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/vaccine/vaccinelist"); //查询请求路径
		return "ihm.vaccine.vaccineSearch";
	}

	/**
	 * 接种疫苗
	 * 
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/vaccinelist")
	public String vaccinelist(HttpServletRequest request,
			VaccineTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		Criteria criteria = this.buildCriteria(form);
        //TODO 暂定 VACCINATION_TYPE != 02 且 neighborhood_address not like '%数据导入%'的为 儿童数据  待验证
        criteria.add("VACCINATION_TYPE", OP.IS, "NULL");
        criteria.add("VACCINATION_CODE", OP.UEMPTY, "");
//        criteria.add("NEIGHBORHOOD_ADDRESS", OP.NOTLIKE, "数据导入");
		PageList<VaccinationMgmt> plist = vaccinationTargetService.getVaccinationMgmtList2(page, criteria);
		model.addAttribute("vaccinelist", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "ihm.vaccine.vaccineList";
	}
	
	/**
	 * 接种疫苗
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/vaccineDetail")
	public String vaccineDetail(HttpServletRequest request, Model model, String vaccinationCode) {
		VaccinationMgmt vaccinationMgmt = vaccinationTargetService.getVaccinationMgmt(new Criteria("vaccination_Code", vaccinationCode));
		List<VaccinationInfo> vaccinationInfos = vaccinationTargetService.getVaccinationInfoList(new Criteria("vaccination_Code", vaccinationCode));
		
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("vaccinationInfos", vaccinationInfos);
		return "ihm.vaccine.vaccineDetail";
	}

	/**
	 * 组装查询条件
	 * 
	 * @param form
	 * @param orgCodeFieldName 机构域名
	 * @param dateFieldName 时间域名
	 * @param nameFieldName 姓名域名
	 * @return
	 */
	private Criteria buildCriteria(VaccineTargetQueryForm form) {
		String orgCodeFieldName = "unitName";
		Criteria criteria = new Criteria();
		Criteria criteriaTemp = null;

		if(StringUtil.isNotEmpty(form.getOrganCode()))
		{
			if("0".equals(form.getGenreCode())) //如果选择的是镇,则查出该镇下所有服务中心和服务站的数据
			{
				criteriaTemp = new Criteria().add("gbCode", form.getOrganCode());
			}
			else //如果是中心或服务站，则查出对应的数据
			{
				criteria.add(orgCodeFieldName, form.getOrganCode());
			}
		}
		
		if(null != criteriaTemp)
		{
			List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);
			
			if(!CollectionUtils.isEmpty(orgs))
			{ 
				criteria.add(orgCodeFieldName, OP.IN, Convert2Array(orgs,"organCode"));
			}else
			{
				criteria.add(orgCodeFieldName, form.getOrganCode());
			}
		}
		
		
		// 姓名
		if (StringUtil.isNotEmpty(form.getName())) {
			criteria.add("name", OP.LIKE, form.getName());
		}
		// 身份证
		if (StringUtil.isNotEmpty(form.getIdcard())) {
			criteria.add("idcard", form.getIdcard());
		}
		// 受接种者编号
		if (StringUtil.isNotEmpty(form.getVaccinationCode())) {
			criteria.add("vaccinationCode", form.getVaccinationCode());
		}
		//父亲姓名
		if (StringUtil.isNotEmpty(form.getFatherName())) {
			criteria.add("fatherName", OP.LIKE, form.getFatherName());
		}
		//父亲身份证
		if (StringUtil.isNotEmpty(form.getFatherIdcard())) {
			criteria.add("fatherIdcard", form.getFatherIdcard());
		}
		//母亲姓名
		if (StringUtil.isNotEmpty(form.getMotherName())) {
			criteria.add("motherName", OP.LIKE, form.getMotherName());
		}
		//母亲身份证
		if (StringUtil.isNotEmpty(form.getMotherIdcard())) {
			criteria.add("motherIdcard", form.getMotherIdcard());
		}
		
		Date beginDate = DateUtil.parseSimpleDate(form.getBeginDate(), null);
		Date endDate = DateUtil.parseSimpleDate(form.getEndDate(), null);
		DateUtil.getCriteriaByDateRange(criteria, "createCardDate", beginDate, endDate);
		return criteria;
	}

	private <T> Object[] Convert2Array(List<T> list, String fieldName) {
		Object[] ta = new Object[list.size()];
		if (CollectionUtils.isEmpty(list))
			return ta;
		Method method;
		try {
			method = list.get(0).getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
			for (int i = 0; i < list.size(); i++) {
				ta[i] = method.invoke(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ta;
	}
}
