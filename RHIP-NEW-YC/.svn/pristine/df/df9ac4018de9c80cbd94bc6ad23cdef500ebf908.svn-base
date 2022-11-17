package com.founder.rhip.ehr.controller;

import com.founder.elb.common.MessageUtils;
import com.founder.elb.entity.Role;
import com.founder.elb.service.ISecurityService;
import com.founder.fasf.beans.*;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.RequestUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PortalUser;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.entity.StaffOrg;
import com.founder.rhip.mdm.service.IStaffService;
import com.sun.org.apache.xpath.internal.operations.Or;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用户管理
 */
@Controller
@RequestMapping("/user")
@SessionAttributes(value = { "USER_CODE", "org_id" }, types = { Long.class, Integer.class })
public class UserController extends BaseController {

	@Resource(name = "ehrSecurityService")
	private IEhrSecurityService ehrSecurityService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Resource(name = "mdmStaffService")
	private IStaffService mdmStaffService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping("/updateSelf")
	public String updateSelf(HttpServletRequest request, ModelMap model, Integer viewMark){
		User user = this.getCurrentUser(request);
		model.addAttribute("user", user);
		if (ObjectUtil.isNotEmpty(viewMark)) {
			return "rhip.ehr.user.view.self";
		}
		return "rhip.ehr.user.updateSelf";
	}

	@RequestMapping("/updatePassword")
	public String updatePassword(HttpServletRequest request, ModelMap model){
		User user = this.getCurrentUser(request);
		model.addAttribute("user", user);
		return "rhip.ehr.user.updatePassword";
	}

	@RequestMapping("/saveSelf")
	public String saveSelf(HttpServletRequest request,String telephone,String mobile,String email,String userCode, ModelMap model){

		User user = ehrSecurityService.getUser(new Criteria("userCode",userCode));
		user.setTelephone(telephone);
		user.setMobile(mobile);
		user.setEmail(email);

		ehrSecurityService.updateUserObject(user);

		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		currentLoginInfo.setUser(user);
		request.getSession().setAttribute("currentLoginInfo",currentLoginInfo);
		super.createOperationLog(request, RhipModuleName.MDM, "用户管理", OperationName.UPDATE);
		return EHRMessageUtil.returnMsg(model, 1);
	}

	@RequestMapping("/savePassword")
	public String savePassword(HttpServletRequest request,String oldPassword,String newPassword,String newPassword2, String userCode, ModelMap model){

		User user = ehrSecurityService.getUser(new Criteria("userCode", userCode));
		if(ObjectUtil.isNullOrEmpty(oldPassword)){
			return EHRMessageUtil.returnMsg(model, "旧密码不能空");
		}

		if(ObjectUtil.isNullOrEmpty(newPassword)){
			return EHRMessageUtil.returnMsg(model, "新密码不能空");
		}

/*		if(newPassword.length()>8){
			return EHRMessageUtil.returnMsg(model, "新密码长度不能大于8");
		}*/


		if(!MD5Encoder.getMD5Str(oldPassword).equals(user.getPassword())){
			return EHRMessageUtil.returnMsg(model, "旧密码不正确");
		}

		if(!newPassword.equals(newPassword2)){
			return EHRMessageUtil.returnMsg(model, "新密码和确认密码不一致");
		}

		newPassword = MD5Encoder.getMD5Str(newPassword);
		user.setPassword(newPassword);
		ehrSecurityService.updateUserObject(user);
		//同步修改portal密码
		ehrSecurityService.updatePortalUserPassword(newPassword,userCode);
		super.createOperationLog(request, RhipModuleName.MDM, "用户管理", OperationName.UPDATE);
		return EHRMessageUtil.returnMsg(model, 1);
	}

	/**
	 * 用户查询(新)
	 */
	@RequestMapping("/search")
	public String search(ModelMap model, HttpServletRequest request) {
		List<Role> roles = addByZX(model, request);
		model.addAttribute("roles", roles);
		return "rhip.ehr.user.search";
	}

	@RequestMapping(value = "/list")
	public String goToList(ModelMap model, HttpServletRequest request,String roleCode,Integer status, String organCode,String ccOrg,Integer indexPage) {
		PageList<User> pageListUser = null;
		//新的分页
		Page page = super.getPage(request, indexPage);
		Criteria criteria = RequestUtil.getCriteria(request);
		if(hasRole(RoleType.QWGZX, request) && ObjectUtil.isNullOrEmpty(organCode)) {
			organCode = this.getCurrentOrg(request).getOrganCode();
		}
		addOrgCri(request,criteria,roleCode,organCode);
		criteria.remove("status");

		if(ObjectUtil.isNotEmpty(status)){
			criteria.add("status", status);
		}else{
			criteria.add("status",OP.IN,new Integer[]{0,1});
		}

		pageListUser = ehrSecurityService.getUserPageList(page, criteria);
		model.addAttribute("page", pageListUser.getPage());
		model.addAttribute("collection", pageListUser.getList());
		return "rhip.ehr.user.list";
	}

	private void addOrgCri(HttpServletRequest request,Criteria criteria,String roleCode, String organCode){

		if(ObjectUtil.isNotEmpty(roleCode)){
			criteria.add("role.role_code",roleCode);
		}

		if(ObjectUtil.isNotEmpty(organCode)){
			String town = request.getParameter("town");
			String center = request.getParameter("village");
			String station = request.getParameter("station");
			if (ObjectUtil.isNullOrEmpty(station)) {//三级下拉框为空
				if(ObjectUtil.isNullOrEmpty(center)){//二级下拉框为空
					if(ObjectUtil.equals("_showJk", organCode)) {//一级下拉框选择 疾病预防控制中心
						List<Organization> jks = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.JK.getValue()));
						criteria.add("role.ORGAN_CODE", OP.IN, this.getOrganCodes(jks));
					}else if(ObjectUtil.equals("_showWjw", organCode)) {//一级下拉框选择 区卫计委
						List<Organization> wjws = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.AREA_HEALTH.getValue()));
						criteria.add("role.ORGAN_CODE", OP.IN, this.getOrganCodes(wjws));
					}else if(ObjectUtil.equals("_hospital", organCode)) {//一级下拉框选择 综合医院
						List<Organization> hospitals = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue()));
						criteria.add("role.ORGAN_CODE", OP.IN, this.getOrganCodes(hospitals));
					} else if(ObjectUtil.equals("_healthoversight", organCode)) {//一级下拉框选择 卫生监督检验(监测、检测)所(站)
						List<Organization> healthOverSights = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.HEALTH_OVERSIGHT.getValue()));
						criteria.add("role.ORGAN_CODE", OP.IN, this.getOrganCodes(healthOverSights));
					} else if(ObjectUtil.equals("_other", organCode)) {//一级下拉框选择 其它
						List<Organization> others = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.OTHER.getValue()));
						criteria.add("role.ORGAN_CODE", OP.IN, this.getOrganCodes(others));
					} else {//一级下拉框选择 镇或乡
						if(ObjectUtil.isNotEmpty(town)){
							List<Organization> centres = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.STATION.getValue()}).add("GB_CODE",town));
							criteria.add("role.ORGAN_CODE", OP.IN, this.getOrganCodes(centres));
						}else {// 中心管理员、站管理员、医院管理员 三个角色登录时  查询当前选择的机构
							criteria.add("role.ORGAN_CODE", organCode);
						}
					}
				}else{//二级下拉框不为空
					List<Organization> stations = new ArrayList<Organization>();
					Organization organization = organizationApp.queryOrgan(center);
					if(ObjectUtil.isNotEmpty(organization)){
						//二级下拉框选择 中心卫生院
						if(OrgGenreCode.CENTRE.getValue().equals(organization.getGenreCode())) {
							//获取中心下属站
							stations = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.STATION.getValue()).add(Organization.PARENT_CODE,center));
							stations.add(organization);
							criteria.add("role.ORGAN_CODE", OP.IN,this.getOrganCodes(stations));
						}else{//选择  xx疾病预防控制中心  xx卫计委  xx医院 xx卫生监督检验站 xx其他
							criteria.add("role.ORGAN_CODE", organization.getOrganCode());
						}
					}
				}
			}else {//三级下拉框不为空
				criteria.add("role.ORGAN_CODE",organCode);
			}
			return;
		}


		if(!hasRole(RoleType.ZXJCSZ, request)){
			return;
		}

		List<Organization> orgList = new ArrayList<>();
		Organization org = getCurrentOrg(request);
		orgList.add(org);
		orgList.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, org.getOrganCode())));
		String [] orgs = new String[orgList.size()];

		for(int i = 0 ; i<orgList.size(); i++ ){
			orgs[i] = orgList.get(i).getOrganCode();
		}
		criteria.add("role.ORGAN_CODE", OP.IN,orgs);
		return ;
	}


	@RequestMapping("/selectStaff")
	public String selectStaff(HttpServletRequest request,ModelMap model, String orgCode) {
		model.addAttribute("orgCode", orgCode);
		return "rhip.ehr.user.selectStaff";
	}

	@RequestMapping("/listStaff")
	public String selectStaff(HttpServletRequest request,ModelMap model,
							  int indexPage,String staffName, String organCode) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = new Criteria();
		criteria.add("status",1);
		if(ObjectUtil.isNotEmpty(staffName)){
			criteria.add("name",OP.LIKE, staffName);
		}
		Organization currentOrg = this.getCurrentOrg(request);
		//区卫管中心管理员可以看到gb_code是它的所有机构的医务人员
		if(hasRole(RoleType.QWGZX, request) && ObjectUtil.isNotEmpty(organCode)) {
			criteria.add("o.gb_code", currentOrg.getGbCode());
		}
		//中心管理员可以看到它本身以及下属站的医务人员
		//站管理员可以看到它本身机构的医务人员genre_code
		if((hasRole(RoleType.ZX_GLY, request) ||
				hasRole(RoleType.Z_GLY, request)) && ObjectUtil.isNotEmpty(organCode)) {
			criteria.add("o.parent_code", currentOrg.getOrganCode());
			criteria.add("o.organ_code", currentOrg.getOrganCode());

		}
		//医院管理员可以看到所有机构类型genre_code为A100机构的医务人员
		if(hasRole(RoleType.YY_GLY, request) && ObjectUtil.isNotEmpty(organCode)) {
			criteria.add("o.genre_code", OrgGenreCode.HOSPITAL);
		}
//		if(ObjectUtil.isNotEmpty(organCode)) {
//			criteria.add("o.organ_code", organCode);
//		}
		List<String> organCodes = new ArrayList<String>();
		if(ObjectUtil.isNotEmpty(organCode)){
			String town = request.getParameter("town");
			String center = request.getParameter("village");
			String station = request.getParameter("station");
			if (ObjectUtil.isNullOrEmpty(station)) {//三级下拉框为空
				if(ObjectUtil.isNullOrEmpty(center)){//二级下拉框为空
					if(ObjectUtil.equals("_showJk", organCode)) {//一级下拉框选择 疾病预防控制中心
						List<Organization> jks = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.JK.getValue()));
						criteria.add("o.organ_code", OP.IN, this.getOrganCodes(jks));
					}else if(ObjectUtil.equals("_showWjw", organCode)) {//一级下拉框选择 区卫计委
						List<Organization> wjws = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.AREA_HEALTH.getValue()));
						criteria.add("o.organ_code", OP.IN, this.getOrganCodes(wjws));
					}else if(ObjectUtil.equals("_hospital", organCode)) {//一级下拉框选择 综合医院
						List<Organization> hospitals = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue()));
						criteria.add("o.organ_code", OP.IN, this.getOrganCodes(hospitals));
					} else if(ObjectUtil.equals("_healthoversight", organCode)) {//一级下拉框选择 卫生监督检验(监测、检测)所(站)
						List<Organization> healthOverSights = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.HEALTH_OVERSIGHT.getValue()));
						criteria.add("o.organ_code", OP.IN, this.getOrganCodes(healthOverSights));
					} else if(ObjectUtil.equals("_other", organCode)) {//一级下拉框选择 其它
						List<Organization> others = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.OTHER.getValue()));
						criteria.add("o.organ_code", OP.IN, this.getOrganCodes(others));
					} else {//一级下拉框选择 镇或乡
						List<Organization> centres = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.STATION.getValue()}).add("GB_CODE",town));
						criteria.add("o.organ_code", OP.IN, this.getOrganCodes(centres));
					}
				}else{//二级下拉框不为空
					List<Organization> stations = new ArrayList<Organization>();
					Organization organization = organizationApp.queryOrgan(center);
					if(ObjectUtil.isNotEmpty(organization)){
						//二级下拉框选择 中心卫生院
						if(OrgGenreCode.CENTRE.getValue().equals(organization.getGenreCode())) {
							//获取中心下属站
							stations = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.STATION.getValue()).add(Organization.PARENT_CODE,center));
							stations.add(organization);
							criteria.add("o.organ_code", OP.IN,this.getOrganCodes(stations));
						}else{//选择  xx疾病预防控制中心  xx卫计委  xx医院 xx卫生监督检验站 xx其他
							organCodes.add(organization.getOrganCode());
							criteria.add("o.organ_code", OP.IN,organCodes);
						}
					}
				}
			}else {//三级下拉框不为空
				organCodes.add(organCode);
				criteria.add("o.organ_code", OP.IN,organCodes);
			}
		}

		PageList<Staff> staffList = mdmStaffService.getStaffPageListsNoInUsers(page, criteria);

		model.addAttribute("page", staffList.getPage());
		model.addAttribute("staffList", staffList.getList());
		model.addAttribute("staffName", staffName);

		return "rhip.ehr.user.staff.list";
	}


	/**
	 * @param userCode
	 * @param changeStaff 因为人员变动而变动
	 */
	@RequestMapping("/add")
	public String add(String staffCode, String userCode,String changeStaff, ModelMap model,HttpServletRequest request) {
		User user  = ehrSecurityService.getUser(new Criteria("staff_code",staffCode));
		if(ObjectUtil.isNotEmpty(staffCode) && ObjectUtil.isNotEmpty(user)) {
			userCode = user.getUserCode();
			model.addAttribute("changeStaff", "change");
		}
		if (!userCode.equals("0")) {
			if(changeStaff != null && changeStaff.equals("change")){
				model.addAttribute("changeStaff", "change");
			}
			updateByUsers( userCode,  model);
		}

		if(hasRole(RoleType.ZXJCSZ, request)){
			List<Organization> orgList = new ArrayList<>();
			Organization org = getCurrentOrg(request);
			orgList.add(org);
			orgList.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, org.getOrganCode())));
			model.addAttribute("orgList", orgList);
		}

		if(hasRole(RoleType.YYJCSZ, request)){
			List<Organization> orgList = new ArrayList<>();
			Organization org = getCurrentOrg(request);
			orgList.add(org);
			model.addAttribute("orgList", orgList);
		}

		model.addAttribute("userCode", userCode);
		return "rhip.ehr.user.add";
	}

	@RequestMapping("/roleList")
	public String roleList(String orgCode, String roleCode, ModelMap model,HttpServletRequest request) {
		Organization o = organizationApp.queryOrgan(orgCode);
		List<Role> roleList = ehrSecurityService.getRoles();

		List<Role> areaHealthList = new ArrayList<>();
		List<Role> centerList = new ArrayList<>();
		List<Role> stationList = new ArrayList<>();
		List<Role> hospitalList = new ArrayList<>();
		List<Role> wjList = new ArrayList<>();
		List<Role> otherList = new ArrayList<>();

		for(Role r : roleList){
			if(r.getRoleCode().equals(RoleType.QWGZX.getValue())){
				areaHealthList.add(r);
			}else if(RoleType.checkZxRole(r)){
				centerList.add(r);
			}else if(RoleType.checkZRole(r)){
				stationList.add(r);
			}else if(RoleType.checkSjyyRole(r)){
				hospitalList.add(r);
			}else if(RoleType.checkWJRole(r)){
				wjList.add(r);
			}else{
				otherList.add(r);
			}
		}
		List<Role> retList = new ArrayList<Role>();

		//bug B140224-002
		//编辑用户时 用户机构可能为空 取当前登录机构
		//2014年2月26日 11:29:25
		//liuk
		if (null==o){
			o=getCurrentOrg(request);
		}

		if (o.getGenreCode().equals(OrgGenreCode.CENTRE.getValue())){
			retList = centerList;
		} else if (o.getGenreCode().equals(OrgGenreCode.STATION.getValue())
				|| o.getGenreCode().equals(OrgGenreCode.INFIRMARY.getValue())
				|| o.getGenreCode().equals(OrgGenreCode.CLINIC.getValue())){
			retList = stationList;
		} else if (o.getGenreCode().equals(OrgGenreCode.HOSPITAL.getValue())){
			retList = hospitalList;
		} else if (o.getGenreCode().equals(OrgGenreCode.HEALTH_OVERSIGHT.getValue())){
			retList = wjList;
		} else {
			retList = otherList;
			retList.addAll(wjList);//卫监角色 要显示在两种机构类型下：疾控、卫监
		}

		roleLine(model, retList);
		String roleSelecteds[] = roleCode.split(",");
		for(Role role : retList) {
			for(String roleDb : roleSelecteds) {
				if(ObjectUtil.equals(role.getRoleCode(), roleDb)) {
					role.setHasRole(1);
					break;
				}
			}
		}
		model.addAttribute("roles", retList);
		model.addAttribute("orgCode", orgCode);
		return "rhip.ehr.user.roleList";
	}

	@RequestMapping("/orgList")
	public String orgList(String staffCode, String userCode, ModelMap model,HttpServletRequest request) {
		Criteria criteria = new Criteria("STAFF_CODE", staffCode);
		List<StaffOrg> staffOrgs = mdmStaffService.getStaffOrgList(criteria);
		model.addAttribute("staffOrgs", staffOrgs);
		//此用户已经拥有的角色
		model.addAttribute("haveRoles", ehrSecurityService.getUserRole(userCode));
		return "rhip.ehr.user.orgList";
	}
	/**
	 *
	 */
	private void roleLine(ModelMap model,List<Role> roleList){
		int size = roleList.size();
		int lineSize = size/3;
		int yu = size%3;

		int line1 = lineSize;
		int line2 = lineSize;
		int line3 = lineSize;

		if(yu > 1){
			line2 = lineSize + 1;
		}

		if(yu > 0){
			line1 = lineSize + 1;
		}
		model.addAttribute("line3", line3);
		model.addAttribute("line2", line2);
		model.addAttribute("line1", line1);
	}

	/**
	 * 中心登录
	 * @param model
	 * @param request
	 * @return
	 */
	private List<Role> addByZX(ModelMap model,HttpServletRequest request){
		List<Role> roleList = ehrSecurityService.getRoles();
		if(hasRole(RoleType.ZXJCSZ, request)){
			List<Organization> orgList = new ArrayList<>();
			Organization org = getCurrentOrg(request);
			orgList.add(org);
			orgList.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, org.getOrganCode())));
			model.addAttribute("orgList", orgList);
			roleList = RoleType.getZXRols(roleList);
		}
		return roleList;
	}

	/**
	 * 修改
	 * */
	private void updateByUsers(String userCode, ModelMap model){
		User user = ehrSecurityService.getUser(new Criteria("userCode", userCode));
		model.addAttribute("user", user);
		Organization org = getOrganizationByUserId(userCode);

		String gbCode = null;
		String parentCode = null;
		String orgCode = null;

		if (null != org) {
			gbCode = org.getGbCode();
			parentCode = org.getOrganCode();

			if (StringUtils.equals(org.getGenreCode(), OrgGenreCode.STATION.getValue())) {
				parentCode = org.getParentCode();
				Organization parentOrg = organizationApp.queryOrgan(parentCode);
				gbCode = parentOrg.getGbCode();
				orgCode = org.getOrganCode();
			}

			if (org.getGenreCode().equals(OrgGenreCode.HOSPITAL.getValue())) {
				gbCode = "_hospital";
				parentCode = org.getOrganCode();
				orgCode = null;
			}

			if (org.getGenreCode().equals(OrgGenreCode.OTHER.getValue())) {
				gbCode = "_other";
				parentCode = org.getOrganCode();
				orgCode = null;
			}

			if (org.getGenreCode().equals(OrgGenreCode.INFIRMARY.getValue())) {
				gbCode = EHRConstants._INFIRMARY;
				parentCode = org.getOrganCode();
				orgCode = null;
			}

			if (org.getGenreCode().equals(OrgGenreCode.HEALTH_OVERSIGHT.getValue())) {
				gbCode = EHRConstants._HEALTHOVERSIGHT;
				parentCode = org.getOrganCode();
				orgCode = null;
			}
		}
		List<UserRole> userRoles = ehrSecurityService.getUserRole(userCode, 0);
		if(ObjectUtil.isNotEmpty(userRoles)) {
			model.addAttribute("roleCode", userRoles.get(0).getRoleCode());
		}
		model.addAttribute("org", org);
		model.addAttribute("gbCode", gbCode);
		model.addAttribute("parentCode", parentCode);
		model.addAttribute("orgCode", orgCode);
	}


	/**
	 * 进入用户基本信息修改界面
	 */
	@RequestMapping("/userUpdate")
	public String userUpdate(HttpSession session, ModelMap model) {
		Object obj = session.getAttribute("currentUser");
		if (ObjectUtil.isNotEmpty(obj)) {
			model.addAttribute("user", (User) obj);
		}
		return "rhip.ehr.user.userUpdate";
	}

	/**
	 * 创建用户(+角色)
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid User user, BindingResult errors, HttpServletRequest request,ModelMap model, String orgRoleCodeStr)
			throws IllegalAccessException, InstantiationException{
		int result = 0;

		if (!checkName(user.getUserName())) {
			ObjectError oe = new ObjectError("", "用户名只能是英文、数字、下划线和点的组合！");
			errors.addError(oe);
		}

		User u = ehrSecurityService.getUser(user.getUserName());
		if (u != null && ObjectUtil.isNullOrEmpty(user.getId())) {
			if(u.getIdentityCard().equalsIgnoreCase(user.getIdentityCard())){
			}else {
				ObjectError oe = new ObjectError("", "用户名已经存在！");
				errors.addError(oe);
			}
		}

		if (u != null && ObjectUtil.isNotEmpty(user.getId()) && !u.getId().equals(user.getId())) {
			ObjectError oe = new ObjectError("", "用户名已经存在！");
			errors.addError(oe);
		}
		List<UserRole> userRoles = (List<UserRole>)json2Obj(orgRoleCodeStr, UserRole.class);

		Criteria criteria = new Criteria("STAFF_CODE",user.getStaffCode());
		criteria.add("status",OP.IN, new Integer[]{1,0});
		User userDb = ehrSecurityService.getUser(criteria);

		if(ObjectUtil.isNotEmpty(userDb) && ObjectUtil.isNotEmpty(userDb.getId()) && !userDb.getId().equals(user.getId())) {
			ObjectError oe = new ObjectError("", "此医务人员已存在相应的用户，请核实！");
			errors.addError(oe);
		}

		if (ObjectUtil.isNullOrEmpty(user.getStaffCode())) {
			ObjectError oe2 = new ObjectError("", "请关联医务人员信息！");
			errors.addError(oe2);
		}

		if (errors.hasErrors()) {
			String msg = getErrorString(MessageUtils.getErrorMessage(errors));
			return EHRMessageUtil.returnMsg(model, msg);
		}
		user.setPassword("123456");
		if (null == user.getUserCode() || user.getUserCode().equals("0") || user.getUserCode().equals("null")) {
			result = ehrSecurityService.createUser(user, userRoles);
			super.createOperationLog(request, RhipModuleName.MDM, "用户管理", OperationName.ADD);
		} else {
			String pws = MD5Encoder.getMD5Str(user.getPassword());
			user.setPassword(pws);
			result = ehrSecurityService.updateUser(user, userRoles);
			super.createOperationLog(request, RhipModuleName.MDM, "用户管理", OperationName.UPDATE);
		}

		if(result > 0){
			return EHRMessageUtil.returnMsg(model, "1");
		}
		return EHRMessageUtil.returnMsg(model, "0");
	}

	private String getErrorString(List<String> error) {
		String err = "";
		for (String str : error) {
			if (err.equals("")) {
				err = str;
				continue;
			}
			err += "\n" + str;
		}
		return err;
	}

	private boolean checkName(String s) {
		s = s.trim();
		String regex = "^[a-zA-Z0-9_.]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(s);
		boolean b = match.matches();
		return b;
	}

	/**
	 * 用户状态变更
	 */
	@RequestMapping("/status")
	public void statusChange(String userCode, Integer status, HttpServletResponse response,HttpServletRequest request) {
		int result = 0;

		if(getCurrentUser(request).getUserCode().equals(userCode)){
			MessageUtils.outputJSONResult("deleteSelf", response);
			return;
		}

		result = ehrSecurityService.changeStatus(status, userCode);
		super.createOperationLog(request, RhipModuleName.MDM, "用户管理", OperationName.UPDATE);
		MessageUtils.outputJSONResult(result > 0 ? "success" : "fail", response);
	}

	/**
	 * 修改用户密码
	 */
	@RequestMapping("/changepwd")
	public String changepwd(HttpServletRequest request) {
		return "rhip.ehr.user.changepwd";
	}

	/**
	 * 修改用户密码
	 */
	@RequestMapping(value = "/updatepwd", method = RequestMethod.POST)
	public String updatepwd(User user, String newPassword, HttpServletRequest request, ModelMap model) {

		int result = 0;

		if (ObjectUtil.isNotEmpty(user)) {
			User sessionUser = SecurityUtils.getCurrentUser(request);

			if (ObjectUtil.isNotEmpty(sessionUser)) {
				String userName = sessionUser.getUserName();
				String oldPassword = user.getPassword();
				result = ehrSecurityService.changePassword(userName, oldPassword, newPassword);
			}
		}

		if (result > 0) {
			super.createOperationLog(request, RhipModuleName.MDM, "用户管理", OperationName.UPDATE);
			return EHRMessageUtil.returnMsg(model, "success");
		} else {
			return EHRMessageUtil.returnMsg(model, "旧密码不对，修改失败！");
		}
	}

	/**
	 * 删除机构
	 */
	@RequestMapping("/delOrg")
	public @ResponseBody
	String delOrg(String userCode, String OrgCode, HttpServletResponse response) {
		int result = 0;
		List<UserRole> list = null;
		list = ehrSecurityService.getUserRole(userCode, 0);

		String preOrgCode = "";
		String curOrgCode = "";
		int orgIdCount = 0;
		for (UserRole ur : list) {
			curOrgCode = ur.getOrganCode();
			if (!curOrgCode.equals(preOrgCode)) {
				orgIdCount++;
			}
			preOrgCode = ur.getOrganCode();
		}
		if (orgIdCount > 1) {
			result = ehrSecurityService.deleteUserRoleOrganiation(userCode, OrgCode);
		}
		// 还缺少第3个，即删除失败的结果
		return result > 0 ? "success" : "fail";
	}

	@RequestMapping("/psdUpdate")
	public void psdUpdate(String userCode,HttpServletResponse response,HttpServletRequest request) {
		ehrSecurityService.setPassword(userCode);
		ehrSecurityService.setPortalPassword(userCode);
		MessageUtils.outputJSONResult("1", response);
	}

	@RequestMapping("/delete")
	public void deleteUser(String userCode,HttpServletResponse response,HttpServletRequest request) {
		int result = 0;
		if(getCurrentUser(request).getId().equals(userCode)){
			MessageUtils.outputJSONResult("deleteSelf", response);
			return;
		}
		result = ehrSecurityService.deleteUser(userCode);
		super.createOperationLog(request, RhipModuleName.MDM, "用户管理", OperationName.DELETE);
		MessageUtils.outputJSONResult(result > 0 ? "success" : "fail", response);
	}
	/**
	 * 重置密码
	 */
	@RequestMapping(value = "/setpwd/{userCode}")
	public void setpwd(@PathVariable("userCode") String userCode, HttpServletResponse response) {
		int result = ehrSecurityService.setPassword(userCode);
		MessageUtils.outputJSONResult(result > 0 ? "success" : "fail", response);
	}


	/**
	 * 通过userId获取所属机构
	 * @param userCode
	 * @return
	 */
	private Organization getOrganizationByUserId(String userCode) {
		List<UserRole> userRoles = ehrSecurityService.getUserRole(userCode, 0);
		if (ObjectUtil.isNotEmpty(userRoles)){
			List<String> orgCodes = new ArrayList<String>(userRoles.size());
			for(UserRole userRole : userRoles) {
				orgCodes.add(userRole.getOrganCode());
			}
			List<Organization> organizations=organizationApp.queryOrganization(new Criteria("organ_Code", OP.IN, orgCodes));
			if (ObjectUtil.isNotEmpty(organizations)){
				return  organizations.get(0);
			}
		}
		return null;
	}

	@Autowired
	private IPublicHealthTarget ehrIndicatorService;


	@RequestMapping(value = "/orgManage")
	public @ResponseBody Long orgManage() {
		List<String> orgs = new ArrayList<>();
		orgs.add("320003222");
		orgs.add("22");
		Date sdate = DateUtil.parseSimpleDate("2012/04/01","yyyy/MM/dd");
		Date edate = DateUtil.parseSimpleDate("2014/04/01","yyyy/MM/dd");
		Float l = ehrIndicatorService.getEHRTarget(orgs, sdate, edate, "PH009");
		return l.longValue();
	}

	/**
	 * 从Portal注册的用户
	 * @param username
	 * @param organCode
	 * @param staffCode
	 * @return
	 */
	@RequestMapping("/portalRegist")
	@ResponseBody
	public String portalRegist(String username, String organCode, String staffCode) {
		logger.debug("portal注册用户：username=" + username + ", organCode=" + organCode + ", staffCode=" + staffCode);
		JSONObject jsonResult = new JSONObject();
		try {
			if (StringUtil.isNullOrEmpty(username)) {
				jsonResult.put("code", 500);
				jsonResult.put("msg", "用户名为空");
			} else {
				User user = ehrSecurityService.getUser(username);
				if (user != null) {
					jsonResult.put("code", 500);
					jsonResult.put("msg", "用户名已存在");
					jsonResult.put("userCode", user.getUserCode());
				} else {
					Criteria criteria = new Criteria("STAFF_CODE", staffCode);
					criteria.add("status",OP.IN, new Integer[]{1,0});
					User userDb = ehrSecurityService.getUser(criteria);
					if (userDb != null) {
						jsonResult.put("code", 500);
						jsonResult.put("msg", "此医务人员已存在相应的用户，请核实！");
						jsonResult.put("userCode", userDb.getUserCode());
					} else {
						if (StringUtil.isNullOrEmpty(organCode) && StringUtil.isNullOrEmpty(staffCode)) {
							jsonResult.put("code", 500);
							jsonResult.put("msg", "机构编码或人员编码为空");
						} else {
							Staff staff = mdmStaffService.getStaff(staffCode);
							if (staff == null) {
								jsonResult.put("code", 500);
								jsonResult.put("msg", "该医务人员不存在");
							} else {
								user = new User();
								user.setUserName(username);
								user.setPassword("123456");
								user.setStaffCode(staffCode);
								user.setName(staff.getName());
								user.setIdentityCard(staff.getIdCard());
								int result = ehrSecurityService.createUser(user);
								if (result > 0) {
									jsonResult.put("code", 200);
									jsonResult.put("msg", "操作成功");
									jsonResult.put("userCode", user.getUserCode());
								} else {
									jsonResult.put("code", 500);
									jsonResult.put("msg", "操作失败");
								}
							}

						}
					}
				}
			}
		} catch (Exception e) {
			logger.error("portal注册用户出错", e);
			jsonResult.put("code", 500);
			jsonResult.put("msg", e.getMessage());
		}
		return jsonResult.toString();
	}

	/**
	 * json数组转成List
	 *
	 * @param jsonArrayStr
	 * @param clazz
	 * @return
	 */
	private static List<?> json2Obj(String jsonArrayStr, Class<?> clazz) throws IllegalAccessException, InstantiationException {
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
		JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
		String[] dateFormats = new String[]{"yyyy/MM/dd"};
		JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
		List<Object> resultList = new ArrayList<Object>();
		for (int i = 0; i < jsonObjects.size(); i++) {
			JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
			Object obj = JSONObject.toBean(jsonObj, clazz);
			resultList.add(obj);
		}
		return resultList;
	}

	private List<String> getOrganCodes(List<Organization> organizations){
		List<String> organCodes = new ArrayList<String>();
		for(Organization organization : organizations) {
			organCodes.add(organization.getOrganCode());
		}
		return organCodes;
	}
}