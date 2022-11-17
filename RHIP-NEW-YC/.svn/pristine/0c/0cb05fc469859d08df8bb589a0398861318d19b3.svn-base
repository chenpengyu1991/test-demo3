package com.founder.rhip.ehr.controller.woman;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.entity.women.PrenatalFollowup;
import com.founder.rhip.ehr.entity.women.PrenatalFollowupOther;
import com.founder.rhip.ehr.service.woman.IPrenatalFollowupService;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.ihm.controller.form.WChQueryForm;
import com.founder.rhip.ihm.service.IWchSearchService;
import com.founder.rhip.mdm.entity.Organization;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 产前随访
 * @author jiang haiying
 *
 */
@Controller
@RequestMapping("/prenatalFollowup")
public class PrenatalFollowupController extends BaseController {

    @Resource(name = "prenatalFollowupService")
    private IPrenatalFollowupService prenatalFollowupService;
    @Resource(name = "wchSearchService")
   	private IWchSearchService wchSearchService;
    
    @Resource(name = "personInfoService")
	private IPersonInfoService personInfoService;
    /**
     * 查询第一次产前检查
     * @return
     */
    @RequestMapping("/fisrt/search")
    public String prenatalVisit(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchType", "2");
        return "ehr.woman.prenatal.followup.first.search";
    }

    /**
     * 第一次产前随访服务记录（孕产妇健康管理）
     * @return
     */
    @RequestMapping("/fisrt/list")
    public String prenatalVisitList(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setOrganCode(request.getParameter("orgCode"));
        PageList<PrenatalFollowup> plist = prenatalFollowupService.getPrenatalFollowupList(this.getCriteria(flg, orgCodes, form, request), page);
        model.addAttribute("prenatalFollowups", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ehr.woman.prenatal.followup.first.list";
    }

    /**
     * 第一次产前访视详细
     * @param prenatalId
     * @param model
     * @return
     */
    @RequestMapping("/fisrt/add")
    public String getPrenatalFollowup(String prenatalId, HttpServletRequest request, ModelMap model){
        PrenatalFollowup prenatalFollowup = new PrenatalFollowup();
        if(ObjectUtil.isNotEmpty(prenatalId)) {
            Criteria criteria = new Criteria();
            criteria.add("id", prenatalId);
            prenatalFollowup = prenatalFollowupService.getPrenatalFollowup(criteria);
            model.addAttribute("prenatalFollowup", prenatalFollowup);
        } else {
            initPrenatalFollowup(prenatalFollowup, request);
        }
        model.addAttribute("prenatalFollowup", prenatalFollowup);
        return "ehr.woman.prenatal.followup.first.add";
    }

    /**
     * 第一次产前访视详细
     * @param prenatalId
     * @param model
     * @return
     */
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
        return "ehr.woman.prenatal.followup.first.view";
    }

    @RequestMapping(value = "/fisrt/save", method = RequestMethod.POST)
    public void save(PrenatalFollowup prenatalFollowup, HttpServletRequest request,ModelMap model,HttpServletResponse response) {
        int result = 0;
        Organization org = getCurrentOrg(request);
        if(ObjectUtil.isNotEmpty(prenatalFollowup.getId())) {
            if (hasRole(RoleType.ZXFB, request)) {
                prenatalFollowup.setUpdateOrganCode(org.getOrganCode());
                prenatalFollowup.setUpdateGbcode(org.getGbCode());
            } else if (hasRole(RoleType.ZFB, request)) {
                prenatalFollowup.setUpdateOrganCode(org.getOrganCode());
                prenatalFollowup.setUpdateSuperOrganCode(org.getParentCode());
                prenatalFollowup.setUpdateGbcode(org.getGbCode());
            }
        }
        
        prenatalFollowupService.savePrenatalFollowup(prenatalFollowup);
        	List<WomenChildHealth> womenChildHealthList=null;
    		if(ObjectUtil.isNotEmpty(prenatalFollowup.getIdCard())){
    			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, prenatalFollowup.getIdCard()));
    		}
    		if(ObjectUtil.isNullOrEmpty(womenChildHealthList)){
    			
    			WomenChildHealth childHealth=new WomenChildHealth();
    			childHealth.setBabyCardNo(prenatalFollowup.getBabyCardNo());
    			childHealth.setIdCard(prenatalFollowup.getIdCard());
    			childHealth.setCreateDate(new Date());
    			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
    			childHealth.setCreatePerson(currentLoginInfo.getUser().getUserName());
    			childHealth.setUpdateDate(new Date());
    			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
    			childHealth.setGender("2");
    			childHealth.setOrgCode(prenatalFollowup.getCreateOrganCode());
    			childHealth.setOrgName(prenatalFollowup.getCreateOrganName());
    			childHealth.setChildBirthday(prenatalFollowup.getBirthday());
    			childHealth.setName(prenatalFollowup.getName());
    			childHealth.setIdentityType("2");
    			childHealth.setIsDelete("0");
    			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",prenatalFollowup.getIdCard()));
    			if(ObjectUtil.isNotEmpty(personInfo)){
    				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
    				childHealth.setPersonId(personInfo.getId().toString());
    			}
    			wchSearchService.inerstWomenChildHealth(childHealth);
    		}else{
			WomenChildHealth childHealth=womenChildHealthList.get(0);
			childHealth.setBabyCardNo(prenatalFollowup.getBabyCardNo());
			childHealth.setIdCard(prenatalFollowup.getIdCard());
			childHealth.setUpdateDate(new Date());
			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
			childHealth.setGender("2");
			childHealth.setOrgCode(prenatalFollowup.getCreateOrganCode());
			childHealth.setOrgName(prenatalFollowup.getCreateOrganName());
			childHealth.setChildBirthday(prenatalFollowup.getBirthday());
			childHealth.setName(prenatalFollowup.getName());
			childHealth.setPersonId(prenatalFollowup.getPersonId().toString());
			childHealth.setIdentityType("2");
			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",prenatalFollowup.getIdCard()));
			if(ObjectUtil.isNotEmpty(personInfo)){
				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
				childHealth.setPersonId(personInfo.getId().toString());
			}
			wchSearchService.updateWomenChildHealth(childHealth);
		}
        MessageUtils.outputJSONResult("success", response);
    }

    @RequestMapping(value = "/fisrt/delete", method = RequestMethod.POST)
    public void delete(Long prenatalId, HttpServletRequest request, ModelMap model,HttpServletResponse response) {
        int result = 0;
        result = prenatalFollowupService.deletePrenatalFollowup(prenatalId);
        MessageUtils.outputJSONResult(result > 0 ? "success" : "fail", response);
    }

    /**
     * 查询第2-5次产前检查
     * @return
     */
    @RequestMapping("/other/search")
    public String prenatalVisitOther(HttpServletRequest request, Model model) {
        initOrg(request, model);
        return "ehr.woman.prenatal.followup.other.search";
    }

    /**
     * 第2-5次产前随访服务记录(孕产妇健康管理)
     * @return
     */
    @RequestMapping("/other/list")
    public String prenatalVisitOtherList(HttpServletRequest request, WChQueryForm form, Model model) {
//        String searchTown = request.getParameter("searchTown");
//        String searchCenter = request.getParameter("searchCenter");
//        String searchStation = request.getParameter("searchStation");
//        if(StringUtil.isNotEmpty(searchTown) && StringUtil.isNullOrEmpty(searchCenter)){
//            form.setGenreCode("0");
//            form.setOrganCode(searchTown);
//        }else if(StringUtil.isNotEmpty(searchCenter) && StringUtil.isNullOrEmpty(searchStation)){
//            form.setGenreCode("B1");
//            form.setOrganCode(searchCenter);
//        }else if(StringUtil.isNotEmpty(searchStation)){
//            form.setOrganCode(searchStation);
//        }
//        if(hasRole(RoleType.QWGZX,request) && StringUtil.isNullOrEmpty(searchTown)){
//            form.setGenreCode("0");
//            form.setOrganCode(getCurrentOrg(request).getGbCode());
//        }
        
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setOrganCode(request.getParameter("orgCode"));
        PageList<PrenatalFollowupOther> plist = prenatalFollowupService.getPrenatalFollowupOtherList(this.getCriteria(flg,orgCodes,form, request), page);
        model.addAttribute("prenatalFollowupOthers", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "ehr.woman.prenatal.followup.other.list";
    }

    /**
     * 第2-5次产前访视详细
     * @param prenatalId
     * @param model
     * @return
     */
    @RequestMapping("/other/add")
    public String getPrenatalFollowupOther(String prenatalId, HttpServletRequest request, ModelMap model){
        PrenatalFollowupOther prenatalFollowupOther = new PrenatalFollowupOther();
        if(ObjectUtil.isNotEmpty(prenatalId)) {
            Criteria criteria = new Criteria();
            criteria.add("id", prenatalId);
            prenatalFollowupOther = prenatalFollowupService.getPrenatalFollowupOther(criteria);
            model.addAttribute("prenatalFollowupOther", prenatalFollowupOther);
        } else {
            initPrenatalFollowupOther(prenatalFollowupOther, request);
        }
        model.addAttribute("prenatalFollowupOther", prenatalFollowupOther);
        return "ehr.woman.prenatal.followup.other.add";
    }

    /**
     * 第2-5次产前访视详细
     * @param prenatalId
     * @param model
     * @return
     */
    @RequestMapping("/other/view")
    public String viewPrenatalFollowupOther(String prenatalId, HttpServletRequest request, ModelMap model){
        PrenatalFollowupOther prenatalFollowupOther = new PrenatalFollowupOther();
        if(ObjectUtil.isNotEmpty(prenatalId)) {
            Criteria criteria = new Criteria();
            criteria.add("id", prenatalId);
            prenatalFollowupOther = prenatalFollowupService.getPrenatalFollowupOther(criteria);
            model.addAttribute("prenatalFollowupOther", prenatalFollowupOther);
        }
        model.addAttribute("prenatalFollowupOther", prenatalFollowupOther);
        model.addAttribute("isShowBackBtn", true);
        return "ehr.woman.prenatal.followup.other.view";
    }


    @RequestMapping(value = "/other/save", method = RequestMethod.POST)
    public void saveOther(PrenatalFollowupOther prenatalFollowupOther, HttpServletRequest request,ModelMap model,HttpServletResponse response) {
        int result = 0;
        Organization org = getCurrentOrg(request);
        if(ObjectUtil.isNotEmpty(prenatalFollowupOther.getId())) {
            if (hasRole(RoleType.ZXFB, request)) {
                prenatalFollowupOther.setUpdateOrganCode(org.getOrganCode());
                prenatalFollowupOther.setUpdateGbcode(org.getGbCode());
            } else if (hasRole(RoleType.ZFB, request)) {
                prenatalFollowupOther.setUpdateOrganCode(org.getOrganCode());
                prenatalFollowupOther.setUpdateSuperOrganCode(org.getParentCode());
                prenatalFollowupOther.setUpdateGbcode(org.getGbCode());
            }
        }
            prenatalFollowupOther.setCreateOrganCodeTwo(org.getOrganCode());
            prenatalFollowupOther.setCreateOrganCodeThree(org.getOrganCode());
            prenatalFollowupOther.setCreateOrganCodeFour(org.getOrganCode());
            prenatalFollowupOther.setCreateOrganCodeFive(org.getOrganCode());
            prenatalFollowupOther.setCreateOrganNameTwo(org.getOrganName());
            prenatalFollowupOther.setCreateOrganNameThree(org.getOrganName());
            prenatalFollowupOther.setCreateOrganNameFour(org.getOrganName());
            prenatalFollowupOther.setCreateOrganNameFive(org.getOrganName());
        prenatalFollowupService.savePrenatalFollowupOther(prenatalFollowupOther);
        	List<WomenChildHealth> womenChildHealthList=null;
    		if(ObjectUtil.isNotEmpty(prenatalFollowupOther.getIdCard())){
    			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, prenatalFollowupOther.getIdCard()));
    		}
    		if(ObjectUtil.isNullOrEmpty(womenChildHealthList)){
    			WomenChildHealth childHealth=new WomenChildHealth();
    			childHealth.setBabyCardNo("");
    			childHealth.setIdCard(prenatalFollowupOther.getIdCard());
    			childHealth.setCreateDate(new Date());
    			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
    			childHealth.setCreatePerson(currentLoginInfo.getUser().getUserName());
    			childHealth.setGender("2");
    			childHealth.setOrgCode(prenatalFollowupOther.getCreateOrganCode());
    			childHealth.setOrgName("");
    			childHealth.setChildBirthday(prenatalFollowupOther.getBirthday());
    			childHealth.setName(prenatalFollowupOther.getName());
    			childHealth.setIdentityType("2");
    			childHealth.setIsDelete("0");
    			childHealth.setUpdateDate(new Date());
    			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
    			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",prenatalFollowupOther.getIdCard()));
    			if(ObjectUtil.isNotEmpty(personInfo)){
    				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
    				childHealth.setPersonId(personInfo.getId().toString());
    			}
    			wchSearchService.inerstWomenChildHealth(childHealth);
    		}else{
    			WomenChildHealth childHealth=womenChildHealthList.get(0);
    			childHealth.setBabyCardNo("");
    			childHealth.setIdCard(prenatalFollowupOther.getIdCard());
    			childHealth.setUpdateDate(new Date());
    			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
    			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
    			childHealth.setGender("2");
    			childHealth.setOrgCode(prenatalFollowupOther.getCreateOrganCode());
    			childHealth.setOrgName("");
    			childHealth.setChildBirthday(prenatalFollowupOther.getBirthday());
    			childHealth.setName(prenatalFollowupOther.getName());
    			childHealth.setPersonId(prenatalFollowupOther.getPersonId().toString());
    			childHealth.setIdentityType("2");
    			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",prenatalFollowupOther.getIdCard()));
    			if(ObjectUtil.isNotEmpty(personInfo)){
    				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
    				childHealth.setPersonId(personInfo.getId().toString());
    			}
    			wchSearchService.updateWomenChildHealth(childHealth);
    		}
        MessageUtils.outputJSONResult("success", response);
    }

    @RequestMapping(value = "/other/delete", method = RequestMethod.POST)
    public void deleteOther(Long prenatalId, HttpServletRequest request, ModelMap model,HttpServletResponse response) {
        int result = 0;
        result = prenatalFollowupService.deletePrenatalFollowupOther(prenatalId);
        MessageUtils.outputJSONResult(result > 0 ? "success" : "fail", response);
    }

    private void initPrenatalFollowup(PrenatalFollowup prenatalFollowup, HttpServletRequest request) {
        prenatalFollowup.setInputDate(new Date());
        prenatalFollowup.setVisitDate(new Date());
        prenatalFollowup.setSupervisionDoctor(this.getCurrentUser(request).getStaffCode());
        Organization org = getCurrentOrg(request);
        if (hasRole(RoleType.ZXFB, request)) {
            prenatalFollowup.setCreateOrganCode(org.getOrganCode());
            prenatalFollowup.setCreateGbcode(org.getGbCode());
        } else if (hasRole(RoleType.ZFB, request)) {
            prenatalFollowup.setCreateOrganCode(org.getOrganCode());
            prenatalFollowup.setCreateSuperOrganCode(org.getParentCode());
            prenatalFollowup.setCreateGbcode(org.getGbCode());
        }
    }

    private void initPrenatalFollowupOther(PrenatalFollowupOther prenatalFollowupOther, HttpServletRequest request) {
        prenatalFollowupOther.setInputDateTwo(new Date());
        prenatalFollowupOther.setSupervisionDoctorTwo(this.getCurrentUser(request).getStaffCode());
        prenatalFollowupOther.setSupervisionDoctorThree(this.getCurrentUser(request).getStaffCode());
        prenatalFollowupOther.setSupervisionDoctorFour(this.getCurrentUser(request).getStaffCode());
        prenatalFollowupOther.setSupervisionDoctorFive(this.getCurrentUser(request).getStaffCode());
        Organization org = getCurrentOrg(request);
        if (hasRole(RoleType.ZXFB, request)) {
            prenatalFollowupOther.setCreateOrganCode(org.getOrganCode());
            prenatalFollowupOther.setCreateGbcode(org.getGbCode());
        } else if (hasRole(RoleType.ZFB, request)) {
            prenatalFollowupOther.setCreateOrganCode(org.getOrganCode());
            prenatalFollowupOther.setCreateSuperOrganCode(org.getParentCode());
            prenatalFollowupOther.setCreateGbcode(org.getGbCode());
        }
    }

    private Criteria getCriteria(Boolean flg, List<String> orgCodes, WChQueryForm form, HttpServletRequest request) {
        Criteria criteria = new Criteria();
        if(StringUtil.isNotEmpty(form.getName())){
            criteria.add("NAME", OP.LIKE, form.getName());
        }
        if(StringUtil.isNotEmpty(form.getIdCard())){
            criteria.add("ID_CARD", OP.LIKE, form.getIdCard());
        }
        if(ObjectUtil.isNotEmpty(form.getEstimatedDueDateStart()) || ObjectUtil.isNotEmpty(form.getEstimatedDueDateEnd())) {
            DateUtil.getCriteriaByDateRange(criteria, "ESTIMATED_DUE_DATES", form.getEstimatedDueDateStart(), form.getEstimatedDueDateEnd());
        }
        if(ObjectUtil.isNotEmpty(form.getVisitDateStart()) || ObjectUtil.isNotEmpty(form.getVisitDateEnd())) {
            DateUtil.getCriteriaByDateRange(criteria, "VISIT_DATE", form.getVisitDateStart(), form.getVisitDateEnd());
        }
        if(flg){
            if(ObjectUtil.isNotEmpty(form.getOrganCode())){
            	criteria.add("CREATE_ORGAN_CODE", form.getOrganCode());
            }else if(ObjectUtil.isNotEmpty(orgCodes)){
            	criteria.add("CREATE_ORGAN_CODE", OP.IN, orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(form.getOrganCode())){
            	criteria.add("CREATE_ORGAN_CODE", form.getOrganCode());
            }else if(ObjectUtil.isNotEmpty(orgCodes)){
                criteria.add("CREATE_ORGAN_CODE", OP.IN, orgCodes);
            }
        }
        return criteria;
    }

}