package com.founder.rhip.ihm.controller;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ihm.controller.form.EmrMedicalTargetQueryForm;
import com.founder.rhip.ihm.service.IFamilyPlanningService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

/**
 * 计划生育查询
 * @author chen_tao
 *
 */
@Controller
@RequestMapping("/ihm/familyPlanning/")
public class FamilyPlanningController extends IHMBaseController {

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;
	
	@Resource(name = "familyPlanningService")
	private IFamilyPlanningService familyPlanningService;
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@RequestMapping("/childBearing")
	public String childBearing(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy");
		model.addAttribute("listpage", "childBearingList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/familyPlanning/childBearingList"); //查询请求路径
		return "ihm.familyPlanning.childBearing";
	}

	/**
	 * 育龄妇女登记列表查询
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/childBearingList")
	public String childBearingList(HttpServletRequest request,
			EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
        PageList<Map<String, Object>> pagelist = familyPlanningService.getChildBearingList(page, buildPremaritalHealthCriteria(form));
		
		model.addAttribute("childBearingList", pagelist.getList());
		model.addAttribute("page", pagelist.getPage());
		return "ihm.familyPlanning.childBearingList";
	}
	
	/**
	 * 查看育龄妇女登记
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/childBearingDetail")
	public String childBearingDetail(HttpServletRequest request, Model model, String id) {
		Object obj = familyPlanningService.getChildBearing(id);
		model.addAttribute("childBearing", obj);
		return "ihm.familyPlanning.childBearingDetail";
	}
	
	@RequestMapping("/premaritalHealth")
	public String premaritalHealth(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("genderCriteria", "1");
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy");
		model.addAttribute("listpage", "premaritalHealthList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/familyPlanning/premaritalHealthList"); //查询请求路径
		return "ihm.familyPlanning.premaritalHealth";
	}

	/**
	 * 男女婚检列表查询
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/premaritalHealthList")
	public String premaritalHealthList(HttpServletRequest request,
			EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
        Page page = super.getPage(request, currentPage);

        PageList<Map<String, Object>> pagelist = familyPlanningService.getPremaritalHealthList(page, buildPremaritalHealthCriteria(form));

        model.addAttribute("premaritalHealthList", pagelist.getList());
        model.addAttribute("page", pagelist.getPage());

        return "ihm.familyPlanning.premaritalHealthList";
	}
	
	/**
	 * 查看男女婚检信息
	 * @param request
	 * @param model
	 * @param ehrId
	 * @param personId
	 * @return
	 */
	@RequestMapping("/premaritalHealthDetail")
	public String premaritalHealthDetail(HttpServletRequest request, Model model, String id) {
		Object obj = familyPlanningService.getPremaritalHealth(id);
		model.addAttribute("premaritalHealth", obj);
		return "ihm.familyPlanning.premaritalHealthDetail";
	}
	
	@RequestMapping("/womanDisease")
	public String womanDisease(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy");
		model.addAttribute("listpage", "womanDiseaseList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/familyPlanning/womanDiseaseList"); //查询请求路径
		return "ihm.familyPlanning.womanDisease";
	}

	/**
	 * 男女婚检列表查询
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/womanDiseaseList")
	public String womanDiseaseList(HttpServletRequest request,
			EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage); 
		
        PageList<Map<String, Object>> pagelist = familyPlanningService.getWomenDiseaseList(page, buildPremaritalHealthCriteria(form));
		
		model.addAttribute("womanDiseaseList", pagelist.getList());
		model.addAttribute("page", pagelist.getPage());
		
		return "ihm.familyPlanning.womanDiseaseList";
	}
	
	/**
	 * 查看男女婚检信息
	 * @param request
	 * @param model
	 * @param ehrId
	 * @param personId
	 * @return
	 */
	@RequestMapping("/womanDiseaseDetail")
	public String WomanDiseaseDetail(HttpServletRequest request, Model model, String id) {
		Object obj = familyPlanningService.getWomenDisease(id);
		model.addAttribute("womanDisease", obj);
		return "ihm.familyPlanning.womanDiseaseDetail";
	}
	
	/**
	 * 组装查询条件
	 * @param form
	 * @param orgCodeFieldName 机构域名
	 * @param dateFieldName 时间域名
	 * @param nameFieldName 姓名域名
	 * @return
	 */
	private Criteria buildChildBearingCriteria(EmrMedicalTargetQueryForm form){
		Criteria criteria = new Criteria();

		if(StringUtil.isNotEmpty(form.getOrganCode()))
		{
			if("0".equals(form.getGenreCode())) //如果选择的是镇,则查出该镇下所有服务中心和服务站的数据
			{
				criteria.add("GBCODE", form.getOrganCode());
			}
			else //如果是中心或服务站，则查出对应的数据
			{
				criteria.add("INPUT_ORGAN_CODE", form.getOrganCode());
			}
		}
		
		//日期
		if(StringUtil.isNotEmpty(form.getBeginDate())){
			criteria.add("INPUT_DATE", OP.GE, form.getBeginDate());
		}
		if(StringUtil.isNotEmpty(form.getEndDate())){
            criteria.add("INPUT_DATE", OP.LE, form.getEndDate());
		}
		//姓名
		if(StringUtil.isNotEmpty(form.getName())){
			criteria.add("NAME", OP.LIKE, form.getName());
		}
		//身份证
		if(StringUtil.isNotEmpty(form.getIdcard())){
			criteria.add("IDCARD", form.getIdcard());
		}
		return criteria;
	}
	
	/**
	 * 组装查询条件
	 * @param form
	 * @param orgCodeFieldName 机构域名
	 * @param dateFieldName 时间域名
	 * @param nameFieldName 姓名域名
	 * @return
	 */
	private Criteria buildPremaritalHealthCriteria(EmrMedicalTargetQueryForm form){
		Criteria criteria = new Criteria();

		if(StringUtil.isNotEmpty(form.getOrganCode()))
		{
			if("0".equals(form.getGenreCode())) //如果选择的是镇,则查出该镇下所有服务中心和服务站的数据
			{
				List<Organization> orgs = organizationService.getOrganizations(new Criteria().add("gbCode", form.getOrganCode()));
				if(!CollectionUtils.isEmpty(orgs))
				{ 
					criteria.add("CREATE_ORGAN_CODE", OP.IN, orgs);
				}
			}
			else //如果是中心或服务站，则查出对应的数据
			{
				criteria.add("CREATE_ORGAN_CODE", form.getOrganCode());
			}
		}
		
		//日期
		if(StringUtil.isNotEmpty(form.getBeginDate()) || StringUtil.isNotEmpty(form.getEndDate())){
            DateUtil.getCriteriaByDateRange(criteria, "CHECK_DATE", DateUtil.parseSimpleDate(form.getBeginDate(), null),DateUtil.parseSimpleDate(form.getEndDate(), null));
		}
		//姓名
		if(StringUtil.isNotEmpty(form.getName())){
			criteria.add("NAME", OP.LIKE, form.getName());
		}
		//身份证
        if(StringUtil.isNotEmpty(form.getIdcard())){
            criteria.add("ID_CARD", form.getIdcard());
        }
        //性别
        if(StringUtil.isNotEmpty(form.getSex())){
            criteria.add("gender", form.getSex());
        }
		return criteria;
	}
	
}