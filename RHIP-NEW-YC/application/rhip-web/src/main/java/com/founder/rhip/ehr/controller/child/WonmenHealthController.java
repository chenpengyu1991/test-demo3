
package com.founder.rhip.ehr.controller.child;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.ehr.repository.child.IWomenChildHealthDao;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ehr.service.woman.IDeliveryService;
import com.founder.rhip.ehr.service.woman.IPrenatalFollowupService;
import com.founder.rhip.ihm.controller.form.WChQueryForm;
import com.founder.rhip.ihm.service.IWchSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wonmenHealth")
public class WonmenHealthController extends BaseController {

	@Resource(name = "wchSearchService")
	private IWchSearchService wchSearchService;
	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;
	@Resource(name = "womenChildHealthDao")
	private IWomenChildHealthDao womenChildHealthDao;
	@Resource(name = "prenatalFollowupService")
	private IPrenatalFollowupService prenatalFollowupService;
	@Resource(name = "deliveryService")
	private IDeliveryService deliveryService;

	@RequestMapping("/search")
	public String neonatalVisit1(HttpServletRequest request, Model model) {
		initOrg(request, model);
		return "rhip.ehr.child.wonmenHealth.search";
	}

	/**
	 * 新生儿随访信息
	 *
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String neonatalVisit(HttpServletRequest request, WChQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX, request) || hasRole(RoleType.ADMIN, request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setName(request.getParameter("name"));
		form.setGender(request.getParameter("gender"));
		form.setCreateDate(request.getParameter("createDate"));
		form.setCreateDateEnd(request.getParameter("createDateEnd"));
		form.setUpdateDate(request.getParameter("updateDate"));
		form.setUpdateDateEnd(request.getParameter("updateDateEnd"));
		form.setOrganCode(request.getParameter("orgCode"));
		form.setIdCard(request.getParameter("idCard"));
		form.setHealthGuideStatus(request.getParameter("healthGuideStatus"));
		PageList<WomenChildHealth> plist = wchSearchService.getWomenHealthList(flg, orgCodes, form.getParamMap(), page);
		model.addAttribute("childList", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "rhip.ehr.child.wonmenHealth.list";
	}

	@RequestMapping("/export")
	public void exportPersonInfoList(final WChQueryForm form, HttpServletRequest request, HttpServletResponse response) {
		final Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX, request) || hasRole(RoleType.ADMIN, request);
		final List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setName(request.getParameter("name"));
		form.setGender(request.getParameter("gender"));
		form.setCreateDate(request.getParameter("createDate"));
		form.setCreateDateEnd(request.getParameter("createDateEnd"));
		form.setUpdateDate(request.getParameter("updateDate"));
		form.setUpdateDateEnd(request.getParameter("updateDateEnd"));
		form.setOrganCode(request.getParameter("orgCode"));
		form.setIdCard(request.getParameter("idCard"));
		form.setHealthGuideStatus(request.getParameter("healthGuideStatus"));

		excelExportService.exportListExecl("孕产妇人员列表", WomenChildHealth.class, response, new IDataSource() {
			@Override
			public List<Map<String, Object>> get(Page page) {
				return wchSearchService.exportPersonRecordList(page, flg, orgCodes, form.getParamMap(), 2);
			}
		});
	}

	@RequestMapping("/wonmanVisitList/{idcard}")
	public String neonatalVisit1(@PathVariable("idcard") String idcard , HttpServletRequest request, WChQueryForm form, Model model) {
		Criteria criteria = new Criteria();
		criteria.add("id_card",idcard);
		WomenChildHealth womenChildHealth  = womenChildHealthDao.get(criteria);
		model.addAttribute("child",womenChildHealth);

		return "rhip.ehr.child.wonmenHealth.wonmenRecordIndex";
	}

	@RequestMapping("/fisrt/list")
	public String prenatalVisitList(HttpServletRequest request, WChQueryForm form, Model model, String idCard) {
		int currentPage = 1;
		Page page = super.getPage(request, currentPage);
		Criteria criteria = new Criteria();
		criteria.add("id_card",idCard);
		PageList<PrenatalFollowup> plist = prenatalFollowupService.getPrenatalFollowupList(criteria, page);
		model.addAttribute("prenatalFollowups", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "rhip.ehr.child.wonmenHealth.firstList";
	}
	@RequestMapping("/other/list")
	public String prenatalVisitOtherList(HttpServletRequest request, WChQueryForm form, Model model, String idCard) {
		int currentPage = 1;
		Page page = super.getPage(request, currentPage);
		Criteria criteria = new Criteria();
		criteria.add("id_card",idCard);
		PageList<PrenatalFollowupOther> plist = prenatalFollowupService.getPrenatalFollowupOtherList(criteria, page);
		model.addAttribute("prenatalFollowupOthers", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "rhip.ehr.child.wonmenHealth.other.list";
	}
	@RequestMapping("/delivery")
	public String deliverySearch(HttpServletRequest request, WChQueryForm form, Model model, String idCard) {
		int currentPage = 1;
		Page page = super.getPage(request, currentPage);
		Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setIdCard(idCard);
		PageList<DeliveryRecordInfo> plist = deliveryService.getDeliveryList(flg, orgCodes, form.getParamMap(), page,request);
		model.addAttribute("womanList", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "rhip.ehr.woman.delivery.list1";
	}
	@RequestMapping("/woman/postnatalFollowup/list")
	public String postnatalFollowupList(HttpServletRequest request, WChQueryForm form, Model model, String idCard) {
		String curCode = getCurrentOrg(request).getOrganCode();
		int currentPage = 1;
		Page page = super.getPage(request, currentPage);
		Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setIdCard(idCard);
		PageList<PostnatalFollowup> plist = wchSearchService.getPostnatalFollowupList(flg,orgCodes,form.getParamMap(), page);
		model.addAttribute("curCode",curCode);
		model.addAttribute("postnatalFollowupList", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "ihm.woman.postnatalFollowupList1";
	}



	@RequestMapping("/fisrt/view")
	public String viewPrenatalFollowup(String prenatalId, HttpServletRequest request, ModelMap model){
		PrenatalFollowup prenatalFollowup = new PrenatalFollowup();
		if(ObjectUtil.isNotEmpty(prenatalId)) {
			Criteria criteria = new Criteria();
			criteria.add("id", prenatalId);
			prenatalFollowup = prenatalFollowupService.getPrenatalFollowup(criteria);
			model.addAttribute("prenatalFollowup", prenatalFollowup);
		}
		model.addAttribute("prenatalFollowup", prenatalFollowup);
		model.addAttribute("isShowBackBtn", true);
		return "ehr.woman.prenatal.followup.first.view1";
	}

	@RequestMapping("/other/view")
	public String viewPrenatalFollowup1(String prenatalId, HttpServletRequest request, ModelMap model){
		PrenatalFollowupOther prenatalFollowupOther = new PrenatalFollowupOther();
        if(ObjectUtil.isNotEmpty(prenatalId)) {
            Criteria criteria = new Criteria();
            criteria.add("id", prenatalId);
            prenatalFollowupOther = prenatalFollowupService.getPrenatalFollowupOther(criteria);
        }
        model.addAttribute("prenatalFollowupOther", prenatalFollowupOther);
        model.addAttribute("isShowBackBtn", true);
		return "ehr.woman.prenatal.followup.other.view1";
	}
	@RequestMapping("/woman/postpartum/list")
	public String postpartumList(HttpServletRequest request, WChQueryForm form, Model model , String idCard) {
		String curCode = getCurrentOrg(request).getOrganCode();
		int currentPage = 1;
		Page page = super.getPage(request, currentPage);
		Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setIdCard(idCard);
		PageList<PostpartumDaysHealthInfo> plist = wchSearchService.getPostpartumList(flg,orgCodes,form.getParamMap(), page);
		model.addAttribute("curCode",curCode);
		model.addAttribute("womanList", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "ihm.woman.postpartumList1";
	}

}
