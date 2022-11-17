package com.founder.rhip.ehr.controller.child;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.MomChildConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.repository.child.INeonatalFamilyVisitDao;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.ihm.controller.form.WChQueryForm;
import com.founder.rhip.ihm.service.IWchSearchService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/childFamilyVisit")
public class ChildFamilyVisitController extends BaseController {
	@Autowired
    private IOrganizationApp organizationApp;
	
	@Resource(name = "wchSearchService")
	private IWchSearchService wchSearchService;
	@Resource(name = "personInfoService")
	private IPersonInfoService personInfoService;

	@Resource(name = "neonatalFamilyVisitDao")
	private INeonatalFamilyVisitDao neonatalFamilyVisitDao;
	
	@RequestMapping("/search")
	public String neonatalVisit1(HttpServletRequest request, Model model) {
		initOrg(request, model);
		return "rhip.ehr.child.familyVisit.search";
	}

	/**
	 * 新生儿随访信息
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String neonatalVisit(HttpServletRequest request, WChQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setOrganCode(request.getParameter("orgCode"));
		
		PageList<NeonatalFamilyVisit> plist = wchSearchService.getNeonatalVisitList(flg,orgCodes,form.getParamMap(), page);
		model.addAttribute("childList", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "rhip.ehr.child.familyVisit.list";
	}

	@RequestMapping("/list1")
	public String neonatalVisit1(HttpServletRequest request, WChQueryForm form, Model model, String babyCardNo) {
		int currentPage = 1;
		Page page = super.getPage(request, currentPage);
		Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		Criteria criteria = new Criteria();
		criteria.add("BABY_CARD_NO",babyCardNo);
		NeonatalFamilyVisit neonatalFamilyVisit = neonatalFamilyVisitDao.get(criteria);
        if(ObjectUtil.isNullOrEmpty(neonatalFamilyVisit)){
			PageList<NeonatalFamilyVisit> plist = new PageList<NeonatalFamilyVisit>();
			model.addAttribute("childList", plist.getList());
			model.addAttribute("page", plist.getPage());

			return "rhip.ehr.child.familyVisit.visitList";
        }
		form.setName(neonatalFamilyVisit.getNeonatusName());
		form.setGender(neonatalFamilyVisit.getNeonatalGender());
		form.setBirthday(neonatalFamilyVisit.getNeonatusBirthday().toString());
		form.setOrganCode(neonatalFamilyVisit.getCreateOrganCode());
		PageList<NeonatalFamilyVisit> plist = wchSearchService.getNeonatalVisitList(flg,orgCodes,form.getParamMap(), page);
		model.addAttribute("childList", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "rhip.ehr.child.familyVisit.visitList";
	}

	@RequestMapping("/add")
	public String addNeonatalVisitDetail(HttpServletRequest request, ModelMap model, NeonatalFamilyVisit neonatalFamilyVisit){
		neonatalFamilyVisit=wchSearchService.getNeonatalVisit(new Criteria("ID", neonatalFamilyVisit.getId()));
		if (ObjectUtil.isNullOrEmpty(neonatalFamilyVisit)){
			neonatalFamilyVisit = new NeonatalFamilyVisit();
			neonatalFamilyVisit.setSupervisionDoctorCode(getCurrentUser(request).getStaffCode());
		}
		model.addAttribute("neonatalFamilyVisit", neonatalFamilyVisit);
		return "rhip.ehr.child.familyVisit.add";
	}

	@ResponseBody
	@RequestMapping("/save")
	public String saveNeonatalVisitDetail(HttpServletRequest request, NeonatalFamilyVisit neonatalFamilyVisit){
		Organization org = getCurrentOrg(request);
		int num=wchSearchService.saveNeonatalFamilyVisit(neonatalFamilyVisit,org);
		List<WomenChildHealth> womenChildHealthList=null;
		if(ObjectUtil.isNotEmpty(neonatalFamilyVisit.getNeonatusIdcard())&& ObjectUtil.isNotEmpty(neonatalFamilyVisit.getBabyCardNo())){
			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, neonatalFamilyVisit.getNeonatusIdcard()).add("BABY_CARD_NO", OP.EQ, neonatalFamilyVisit.getBabyCardNo()));
		}else if(ObjectUtil.isNullOrEmpty(neonatalFamilyVisit.getNeonatusIdcard())&& ObjectUtil.isNotEmpty(neonatalFamilyVisit.getBabyCardNo())){
			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("BABY_CARD_NO", OP.EQ, neonatalFamilyVisit.getBabyCardNo()));
		}else{
			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, neonatalFamilyVisit.getNeonatusIdcard()));
		}
		if(ObjectUtil.isNullOrEmpty(womenChildHealthList)){
			
			WomenChildHealth childHealth=new WomenChildHealth();
			childHealth.setBabyCardNo(neonatalFamilyVisit.getBabyCardNo());
			childHealth.setIdCard(neonatalFamilyVisit.getNeonatusIdcard());
			childHealth.setCreateDate(new Date());
			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
			childHealth.setCreatePerson(currentLoginInfo.getUser().getUserName());
			childHealth.setGender(neonatalFamilyVisit.getNeonatalGender());
			childHealth.setOrgCode(neonatalFamilyVisit.getCreateOrganCode());
			childHealth.setOrgName(neonatalFamilyVisit.getCreateOrganName());
			childHealth.setChildBirthday(neonatalFamilyVisit.getNeonatusBirthday());
			childHealth.setName(neonatalFamilyVisit.getNeonatusName());
			childHealth.setIdentityType("1");
			childHealth.setIsDelete("0");
			childHealth.setUpdateDate(new Date());
			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
			childHealth.setPersonId(neonatalFamilyVisit.getPersonId().toString());
			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",neonatalFamilyVisit.getNeonatusIdcard()));
			if(ObjectUtil.isNullOrEmpty(personInfo)){
				personInfo= personInfoService.getPersonInfoId(new Criteria("BABY_CARD_NO",neonatalFamilyVisit.getBabyCardNo()));
			}
			if(ObjectUtil.isNotEmpty(personInfo)){
				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
				childHealth.setPersonId(personInfo.getId().toString());
			}
			
			wchSearchService.inerstWomenChildHealth(childHealth);
		}else{
			WomenChildHealth childHealth=womenChildHealthList.get(0);
			childHealth.setBabyCardNo(neonatalFamilyVisit.getBabyCardNo());
			childHealth.setIdCard(neonatalFamilyVisit.getNeonatusIdcard());
			childHealth.setUpdateDate(new Date());
			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
			childHealth.setGender(neonatalFamilyVisit.getNeonatalGender());
			childHealth.setOrgCode(neonatalFamilyVisit.getCreateOrganCode());
			childHealth.setOrgName(neonatalFamilyVisit.getCreateOrganName());
			childHealth.setChildBirthday(neonatalFamilyVisit.getNeonatusBirthday());
			childHealth.setName(neonatalFamilyVisit.getNeonatusName());
			childHealth.setPersonId(neonatalFamilyVisit.getPersonId().toString());
			childHealth.setIdentityType("1");
			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",neonatalFamilyVisit.getNeonatusIdcard()));
			if(ObjectUtil.isNullOrEmpty(personInfo)){
				personInfo= personInfoService.getPersonInfoId(new Criteria("BABY_CARD_NO",neonatalFamilyVisit.getBabyCardNo()));
			}
			if(ObjectUtil.isNotEmpty(personInfo)){
				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
				childHealth.setPersonId(personInfo.getId().toString());
			}
			wchSearchService.updateWomenChildHealth(childHealth);
		}
		String str="";
		if(num==0){
			str="保存失败!";
		}else{
			str="保存成功";
		}
		return str;
	}

	@ResponseBody
	@RequestMapping("/delete")
	public String deleteNeonatalVisit(String id){
		int num=wchSearchService.deleteNeonatalFamilyVisit(id);
		String str="";
		if(num==0){
			str="删除失败!";
		}else if(num==1){
			str="删除成功!";
		}
		return str;
	}

	/**
	 * 新生儿随访信息详细
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/view")
	public String neonatalVisitDetail(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID", id);
		NeonatalFamilyVisit neonatalFamilyVisit = wchSearchService.getNeonatalVisit(criteria);
		if(ObjectUtil.isNullOrEmpty(neonatalFamilyVisit)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("neonatalFamilyVisit", neonatalFamilyVisit);
		model.addAttribute("isShowBackBtn", true);
		model.addAttribute("NO_EXCEPTION", MomChildConstants.NO_EXCEPTION);
		model.addAttribute("NOT_EXISTS_OR_NO", MomChildConstants.NO_EXCEPTION);
		model.addAttribute("EXISTS_OR_YES", MomChildConstants.NO_EXCEPTION);
		return "rhip.ehr.child.familyVisit.view";
	}
	@RequestMapping("/view1")
	public String neonatalVisitDetail1(String id, ModelMap model){
		Criteria criteria = new Criteria();
		criteria.add("ID", id);
		NeonatalFamilyVisit neonatalFamilyVisit = wchSearchService.getNeonatalVisit(criteria);
		if(ObjectUtil.isNullOrEmpty(neonatalFamilyVisit)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("neonatalFamilyVisit", neonatalFamilyVisit);
		model.addAttribute("isShowBackBtn", true);
		return "rhip.ehr.child.familyVisit.view1";
	}
}
