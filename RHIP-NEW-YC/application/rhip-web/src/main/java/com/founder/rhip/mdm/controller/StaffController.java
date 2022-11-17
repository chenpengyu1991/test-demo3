package com.founder.rhip.mdm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.mdm.entity.*;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.idm.controller.DateJsonValueProcessor;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.app.IStaffApp;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.service.IDepartmentService;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IOrganizationService;
import com.founder.rhip.mdm.service.IStaffService;

@Controller
@RequestMapping("/staff")
public class StaffController extends BaseController {

	@Resource(name = "mdmStaffService")
	private IStaffService staffService;

	@Resource(name = "mdmDictionaryService")
	private IDictionaryService dictionaryService;

	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;

	@Resource(name = "mdmDepartmentService")
	private IDepartmentService departmentService;

	@Resource(name = "ehrSecurityService")
	private IEhrSecurityService ehrSecurityService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Resource(name = "staffApp")
	private IStaffApp staffApp;

	@RequestMapping("/staffManage")
	public String personManage(ModelMap model,HttpServletRequest request) {
		StaffSearchForm condition = new StaffSearchForm();
		model.addAttribute("condition", condition);
		addByZX(model, request);
		return "com.founder.mdm.smpi.staffManage";
	}

	private void addByZX(ModelMap model,HttpServletRequest request){
		if(hasRole(RoleType.ZX_GLY, request)){
			List<Organization> orgList = new ArrayList<>();
			Organization org = getCurrentOrg(request);
			orgList.add(org);
			orgList.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, org.getOrganCode())));
			model.addAttribute("orgList", orgList);
		} else if(this.hasRole(RoleType.YYZH, request)) {
			List<Organization> orgList = new ArrayList<>();
			Organization org = getCurrentOrg(request);
			orgList.add(org);
			model.addAttribute("orgList", orgList);
		}
	}

	@RequestMapping("/staffList")
	public String staffList(HttpServletRequest request, StaffSearchForm condition, ModelMap model, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		// convert condition to criteria
		Record record = new Record(condition);
		Set<Map.Entry<String, Object>> entrySet = record.entrySet();
		Criteria criteria = new Criteria();

		for (Map.Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (ObjectUtil.isNotEmpty(value)) {
				if (key.equals("name")) {
					criteria.add("name", OP.LIKE, value);
				}else if(key.equals("beginDate") || key.equals("endDate")){
                    continue;
                }else if(key.equals("ageFrom") || key.equals("ageTo")){
                    continue;
                }else if(key.equals("townCode") || key.equals("organCode")|| key.equals("stationCode")){
                    continue;
                }else{
					criteria.add(key, value);
				}
			}
		}

        /*出生日期*/
        Date birthBeginDate = DateUtil.parseSimpleDate(condition.beginDate, null);
        Date birthEndDate = DateUtil.parseSimpleDate(condition.endDate, null);
        DateUtil.getCriteriaByDateRange(criteria, "birthday", birthBeginDate,birthEndDate);
        // 年龄段
        int eYear = -1;
        int bYear = -1;
        if (StringUtils.isNotEmpty(condition.ageFrom))
            eYear = DateUtil.getBirthYearByAge(Integer.parseInt(condition.ageFrom));
        if (StringUtils.isNotEmpty(condition.ageTo))
            bYear = DateUtil.getBirthYearByAge(Integer.parseInt(condition.ageTo));
        DateUtil.getCriteriaByYearRange(criteria, "birthday", bYear, eYear);

		//List<String> orgCodes = this.getOrgCodeByOrgCode(request, condition.getTownCode(), condition.getOrganCode(), condition.getStationCode());
		List<String> orgCodes = this.getOrgCodes(request,condition.getOrganCode(), condition.getStationCode());
		if(ObjectUtil.isNotEmpty(orgCodes)){
			criteria.add("organCode", OP.IN, orgCodes);
		}
		PageList<Staff> list = staffService.getStaffPageList(page, criteria);
		List<Staff> staffList = list.getList();
		for(Staff staff : staffList){
			if(ObjectUtil.isNullOrEmpty(staff.getTechnical())){
				staff.setTechnical("");
			}else{
				String technical = staff.getTechnical();
				if(technical.equals("1")){
					staff.setTechnical("正高");
				}else if (technical.equals("2")){
					staff.setTechnical("副高");
				}else if (technical.equals("3")){
					staff.setTechnical("中级");
				}else if (technical.equals("4")){
					staff.setTechnical("师级（助理）");
				}else if (technical.equals("5")){
					staff.setTechnical("士级");
				}else if (technical.equals("9")){
					staff.setTechnical("其他");
				}
			}
		}
		model.addAttribute("staffList", list.getList());
		model.addAttribute("page", list.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.smpi.staffList";
	}

	@RequestMapping("/staffMainInfo")
	public String staffMainInfo(String smpiId, ModelMap model) {
		Staff staff = staffService.getStaffMain(smpiId);
		model.addAttribute("staff", staff);
		return "com.founder.mdm.smpi.staffMainDetail";
	}

	@RequestMapping("/staffInfo")
	public String staffInfo(HttpServletRequest request,String staffCode, String idCard, ModelMap model) {
		super.getPage(request,  1);
		Staff staff = staffService.getStaff(staffCode);
		convertCodeToName(staff);
		model.addAttribute("staff", staff);
		model.addAttribute("idCardForSr", idCard);
		return "com.founder.mdm.smpi.staffDetail";
	}

	@RequestMapping("/linkStaffSearch")
	@ResponseBody
	public List<Staff> linkStaffSearch(String smpiId) {
		List<Staff> list = staffService.getLinkStaffs(smpiId);
		Map<String, String> genderMap = dictionaryService.getDicItemMapUseCache(new Criteria("dicCode", "GBT226112003"));
		for (Staff staff : list) {
			staff.setGender(genderMap.get(staff.getGender()));
		}
		convertCodeToName(list);
		return list;
	}

	@RequestMapping("/staffLogList")
	public String getStaffTracks(HttpServletRequest request,int indexPage, ModelMap model, String staffCode) {
		Page page = super.getPage(request,  indexPage);
		PageList<Staff> logList = staffService.getStaffLogs(page, staffCode);
		List<Staff> staffList = logList.getList();
		if (ObjectUtil.isNullOrEmpty(staffList)) {
			staffList = new ArrayList<>();
		}
		convertCodeToName(staffList);
		model.addAttribute("logList", staffList);
		model.addAttribute("page", logList.getPage());
		return "com.founder.mdm.smpi.staffLogList";
	}

	@RequestMapping("/viewLogDetail")
	public String getStaffLog(String staffCode, Long updateTime, ModelMap model) {
		Staff staff = staffService.getStaffLog(staffCode, updateTime);
		if (staff == null) {
			Criteria crt = new Criteria();
			crt.add("staffCode", staffCode);
			crt.add("updateTime", updateTime);
			List<Staff> list = staffService.getStaffs(crt);
			if (ObjectUtil.isNotEmpty(list)) {
				staff = list.get(0);
			}
		}
		convertCodeToName(staff);
		model.addAttribute("staff", staff);
		return "com.founder.mdm.smpi.staffLogDetail";
	}

	@RequestMapping("/compareLogDetail")
	public String compareLogDetail(String params, ModelMap model) {
		String[] compareList = params.split(",");
		Staff left = null;
		Staff right = null;
		if (compareList.length == 1) {
			String[] s = compareList[0].split(":");
            String staffCode = s[0];
            Long updateTime = Long.parseLong(s[1]);
			left = staffService.getStaff(staffCode);
			right = staffService.getStaffLog(staffCode, updateTime);
			model.addAttribute("leftName", "最新记录");
			model.addAttribute("rightName", "历史记录(" + printUpdateTime(s[1]) + ")");
		} else {
			String[] s1 = compareList[0].split(":");
			String[] s2 = compareList[1].split(":");
            String staffCode1 = s1[0];
			Long updateTime1 = Long.parseLong(s1[1]);
            String staffCode2 = s2[0];
			Long updateTime2 = Long.parseLong(s2[1]);
			left = staffService.getStaffLog(staffCode1, updateTime1);
			right = staffService.getStaffLog(staffCode2, updateTime2);
			model.addAttribute("leftName", "记录(" + printUpdateTime(s1[1]) + ")");
			model.addAttribute("rightName", "记录(" + printUpdateTime(s2[1]) + ")");
		}
		convertCodeToName(left);
		convertCodeToName(right);
		model.addAttribute("leftStaff", left);
		model.addAttribute("rightStaff", right);
		return "com.founder.mdm.smpi.compareDiff";
	}

	@RequestMapping("/mergeConfirm")
	public String mergeConfirm(String smpiIds, ModelMap model) {
		String[] sids = smpiIds.split(",");
		Staff staffMain = staffService.getStaffMain(sids[0]);
		model.addAttribute("sids", smpiIds);
		model.addAttribute("staff", staffMain);
		return "com.founder.mdm.smpi.mergeConfirm";
	}

	@RequestMapping("/merge")
	@ResponseBody
	public int merge(String smpiId, String staffCodes) {
		String[] ids = staffCodes.split(",");
		List<Staff> staffList = staffService.getStaffs(new Criteria("staffCodes", OP.IN, ids));
		if (ObjectUtil.isNotEmpty(staffList)) {
			String operator = getOperator();
			Long updateTime = getOperatorTime();
			for (Staff staff : staffList) {
				staff.setOperateType(OperateType.merge.getName());
				staff.setUpdateTime(updateTime);
				staff.setUpdatePerson(operator);
			}
		}
		return staffService.mergeStaff(staffList, smpiId);
	}

	@RequestMapping("/split")
	@ResponseBody
	public int split(String staffCodes) {
		return staffService.splitStaff(getOperator(), staffCodes.split(","));
	}

	@RequestMapping("/staffEdit")
	public String staffEdit(ModelMap modelMap, HttpServletRequest request, String staffCode) {
		Staff staff = staffService.getStaff(staffCode);
		Organization currentOrg = SecurityUtils.getCurrentOrganization(request);
		String organCode = null;
		if (staff != null) {
			organCode = staff.getOrganCode();
			Organization org = organizationService.getOrganization(organCode);
			modelMap.addAttribute("org", org);
		} else if (OrgGenreCode.STATION.getValue().equals(currentOrg.getGenreCode())) {
			organCode = currentOrg.getOrganCode();
		}
		if (StringUtil.isNotEmpty(organCode)) {
			List<Department> deptList = departmentService.getDepartments(new Criteria("organCode", organCode));
			modelMap.addAttribute("deptList", deptList);
		}
		modelMap.addAttribute("currentOrg", currentOrg);
		modelMap.addAttribute("staff", staff);
		addByZX(modelMap, request);
		if(ObjectUtil.isNotEmpty(staff)) {
			setTownCentreStationNew(staff, modelMap);
		}
		return "com.founder.mdm.smpi.staffEdit";
	}

	/**
	 * 编辑医务人员所属机构默认选中以前的机构
	 * @param staff
	 * @param modelMap
	 */
	private void setTownCentreStationCodeForStaff(Staff staff, ModelMap modelMap) {
		Organization organizationHave = organizationApp.queryOrgan(staff.getOrganCode());
		if(ObjectUtil.isNotEmpty(organizationHave)) {
			String townValue="";
			String centreValue="";
			String stationValue="";
			if(ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.JK.getValue()) ||
					ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.CITY_HEALTH.getValue())
					|| ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue())) {
				townValue = staff.getOrganCode();
			} else if(ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.CENTRE.getValue()) ||
					ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.INSTITUTES.getValue()) ||
					ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.OTHER.getValue()) ||
					ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.HOSPITAL.getValue())) {
				townValue=organizationHave.getParentCode();
				if(ObjectUtil.isNullOrEmpty(organizationApp.queryOrgan(organizationHave.getParentCode()))) {
					townValue=organizationHave.getParentCodeHealth();
				}
				centreValue=organizationHave.getOrganCode();
			} else if(ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.HEALTH_OVERSIGHT.getValue())) {
				townValue = EHRConstants._HEALTHOVERSIGHT;
				centreValue=organizationHave.getOrganCode();
			} else {
				stationValue = staff.getOrganCode();
				centreValue = organizationHave.getParentCode();
				Organization organizationCentre = organizationApp.queryOrgan(centreValue);
				townValue = organizationCentre.getParentCode();
				if(ObjectUtil.isNullOrEmpty(organizationApp.queryOrgan(organizationCentre.getParentCode()))) {
					townValue=organizationCentre.getParentCodeHealth();
				}
			}
			modelMap.addAttribute("townValue", townValue);
			modelMap.addAttribute("centreValue", centreValue);
			modelMap.addAttribute("stationValue", stationValue);
		}
	}
	@RequestMapping("/org/add")
	public String addStaffOrg(ModelMap model, HttpServletRequest request, String trData, String type, String rowIndex)
			throws InstantiationException, IllegalAccessException {
		model.put("rowIndex", rowIndex);
		if (StringUtil.isNotEmpty(type) && "edit".equals(type)) {
			this.setModel(trData, model, request);
			model.put("type", type);
		} else {
			model.put("type", "add");
		}
		return "com.founder.mdm.smpi.staff.org.add";
	}

	private void setModel(String trData, ModelMap model, HttpServletRequest request)  throws InstantiationException, IllegalAccessException {
		if (StringUtil.isNotEmpty(trData)) {
			List<StaffOrg> staffOrgs = (List<StaffOrg>) json2Obj(trData, StaffOrg.class);
			model.put("staffOrg", staffOrgs.get(0));
			model.put("deptList", departmentService.getDepartments(new Criteria("organCode", staffOrgs.get(0).getOrganCode())));
		}
	}

	@RequestMapping("/getDept")
	@ResponseBody
	public List<Department> getDepartments(String organCode) {
		return departmentService.getDepartments(new Criteria("organCode", organCode));
	}

	@RequestMapping("/registStaff")
	@ResponseBody
	public Object registStaff(HttpServletRequest request, Staff staff, String staffOrgStr) {

		//在保存是验证此医护人员是否已经在该机构下存在
		int flag = checkIdCard(staff.getIdCard(), staff.getOrganCode(), staff.getStaffCode());
		if(flag == 0) {
			return 3;
		}
		if (StringUtil.isNullOrEmpty(staff.getLocalId())) {
			staff.setLocalId(staff.getIdCard());
		}
		staff.setUpdatePerson(getOperator());
		staff.setUpdateTime(getOperatorTime());
		try {
            String honorString  = staff.getHonorString();
            List<StaffHonor> honorList = (List<StaffHonor>) json2Obj(honorString, StaffHonor.class);
            if (staff.getStaffCode() == null) {
                staff.setOperateType("新建");
                createOperationLog(request, RhipModuleName.MDM, "医务人员注册", OperationName.ADD);
            } else {
                staff.setOperateType("更新");
                createOperationLog(request, RhipModuleName.MDM, "医务人员注册", OperationName.UPDATE);
                for(StaffHonor staffHonor : honorList){
                    staffHonor.setSmpiId(staff.getSmpiId());
                    staffHonor.setStaffCode(staff.getStaffCode());
                    staffHonor.setIdCard(staff.getIdCard());
                    staffHonor.setCreateOrganCode(getCurrentOrg(request).getOrganCode());
                    staffHonor.setCreateDate(new Date());
                    staffHonor.setCreateOrganName(getCurrentOrg(request).getOrganName());
                    staffHonor.setCreateUserName(staff.getUpdatePerson());
                }
            }
            staff.setStaffHonors(honorList);
			//医务人员所属的机构
			staff.setStaffOrgs(this.getStaffOrg(staff, staffOrgStr, request));
			int status = checkUser(staff.getStaffCode(), staff.getStaffOrgs());
			Staff staffMain = staffApp.registStaff(staff);
			if (staffMain == null) {
				return 0;
			}
			return status;
		} catch (Exception e) {
			log.error("注册医务人员出错。", e);
			return e.getMessage();
			//throw new RuntimeException("注册医务人员出错。",e);
		}
	}

	/**
	 * 验证此医务人员所属机构和对应用户中的机构是否一致
	 * @param staffCode the staff code
	 * @param staffOrgs the org code
	 * @return Integer 1:直接提醒保存成功 2:提醒保存成功并同时打开用户修改页面
	 */
	public int checkUser(String staffCode, List<StaffOrg> staffOrgs) {
		/*
		 1.医务人员所属机构的列表staffOrg
		 2.通过staffCode获取此用户所属的userRole列表
		 3.通过对比步骤1、2是否完全一致判断此用户对应的医务人员所属机构是否发生变化
		 */
		//通过staffCode获取医务人员所属机构的列表staffOrg
		List<String> staffOrgCodes = new ArrayList<String>();
		for(StaffOrg staffOrg : staffOrgs) {
			staffOrgCodes.add(staffOrg.getOrganCode());
		}
		//通过staffCode获取此用户所属的userRole列表
		User user = ehrSecurityService.getUser(new Criteria("staff_code",staffCode));
		if(ObjectUtil.isNullOrEmpty(user)) {
			return 1;
		}
		List<String> userOrgCodes = ehrSecurityService.getDistinctOrgCodes(new Criteria("user_code", user.getUserCode()));
		//通过对比步骤1、2是否完全一致判断此用户对应的医务人员所属机构是否发生变化
		for(String userOrgCode : userOrgCodes) {
			if(!staffOrgCodes.contains(userOrgCode)) {
				return 2;
			}
		}
		return 1;
	}

	/**
	 * 为StaffOrg赋值
	 * @param staff
	 * @param staffOrgStr
	 * @throws Exception
	 */
	private List<StaffOrg> getStaffOrg(Staff staff, String staffOrgStr, HttpServletRequest request) throws Exception{
		List<StaffOrg> staffOrgs = (List<StaffOrg>) json2Obj(staffOrgStr, StaffOrg.class);
		User user = getCurrentUser(request);
		Organization organization = getCurrentOrg(request);

		for(StaffOrg staffOrg : staffOrgs) {
			staffOrg.setStaffCode(staff.getStaffCode());
			staffOrg.setSmpiId(staff.getSmpiId());
			staffOrg.setCreateOrganCode(organization.getOrganCode());
			staffOrg.setCreateDate(new Date());
			staffOrg.setCreateOrganName(organization.getOrganName());
			staffOrg.setCreateUserName(user.getUserName());
			staffOrg.setCreateUserId(user.getUserCode());
			staffOrg.setIS_MAIN("1");

		}
		//添加医务人员所在编制的机构
		if(ObjectUtil.isNotEmpty(staff.getOrganCode())) {
			StaffOrg staffOrg = new StaffOrg();
			staffOrg.setStaffCode(staff.getStaffCode());
			staffOrg.setSmpiId(staff.getSmpiId());
			staffOrg.setOrganCode(staff.getOrganCode());
			staffOrg.setDeptCode(staff.getDeptCode());
			staffOrg.setWorkIdCard(staff.getWorkIdCard());
			staffOrg.setCardNum(staff.getCardNum());
			staffOrg.setIS_MAIN("0");
			staffOrgs.add(staffOrg);
			staffOrg.setCreateOrganCode(organization.getOrganCode());
			staffOrg.setCreateDate(new Date());
			staffOrg.setCreateOrganName(organization.getOrganName());
			staffOrg.setCreateUserName(user.getUserName());
			staffOrg.setCreateUserId(user.getUserCode());
		}
		return staffOrgs;
	}

	@RequestMapping("/changeStatus")
	@ResponseBody
	public int changeStatus(String staffCode, Integer status) {
		User user = ehrSecurityService.getUser(new Criteria("staffCode", staffCode).add("status", 1));
		int updated = staffService.updateStatus(staffCode, status);
		if (updated != 0 && user != null) {
			ehrSecurityService.changeStatus(status, user.getUserCode());
		}
		return updated;
	}

	@RequestMapping("/checkIdCard")
	@ResponseBody
	public int checkIdCard(String idCard, String organCode, String staffCode) {
		Criteria criteria = new Criteria("idCard", idCard);

		List<Staff> staffs = staffService.getStaffs(criteria);
		//staff编辑页面
		if(ObjectUtil.isNotEmpty(staffs) && staffs.size() == 1 && staffs.get(0).getStaffCode().equals(staffCode)) {
			return 1;
		}
		if (ObjectUtil.isNullOrEmpty(staffs) || StringUtil.isEmpty(organCode)) {
			return 1;
		} else {
			return 0;
		}
	}

	private String printUpdateTime(String updateTime) {
		StringBuilder sb = new StringBuilder();
		sb.append(updateTime.substring(0, 4)).append("-")
				.append(updateTime.substring(4, 6)).append("-")
				.append(updateTime.substring(6, 8)).append(" ")
				.append(updateTime.substring(8, 10)).append(":")
				.append(updateTime.substring(10, 12)).append(":")
				.append(updateTime.substring(12, 14));
		return sb.toString();
	}

	private String getOrganName(List<Organization> orgList, String organCode){
		for (Organization org : orgList) {
			if (org.getOrganCode().equals(organCode)) {
				return org.getOrganName();
			}
		}
		return organCode;
	}

	private String getDeptName(List<Department> deptList, String organCode, String deptCode) {
		for (Department dept : deptList) {
			if (dept.getOrganCode().equals(organCode) && dept.getDeptCode().equals(deptCode)) {
				return dept.getDeptName();
			}
		}
		return deptCode;
	}

	private void convertCodeToName(List<Staff> list) {
		List<Organization> orgList = organizationService.getOrganizationsUseCache(null);
		List<Department> deptList = departmentService.getDepartmentsUsingCache(null);
		for (Staff staff : list) {
			String organCode = staff.getOrganCode();
			String deptCode = staff.getDeptCode();
			staff.setOrganCode(getOrganName(orgList, organCode));
			staff.setDeptCode(getDeptName(deptList, organCode, deptCode));
		}
	}

	private void convertCodeToName(Staff staff) {
		List<Organization> orgList = organizationService.getOrganizationsUseCache(null);
		List<Department> deptList = departmentService.getDepartmentsUsingCache(null);
		String organCode = staff.getOrganCode();
		String deptCode = staff.getDeptCode();
		staff.setOrganCode(getOrganName(orgList, organCode));
		staff.setDeptCode(getDeptName(deptList, organCode, deptCode));
	}


	public static class StaffSearchForm {
		private String name;
		private String gender;
		private String idCard;
		private String organCode;
		private String townCode;
		private String stationCode;
		private String deptCode;
		private String localId;
		private String useCpy;
		private String useLike;
        private String beginDate;
        private String endDate;
        private String technical; //职称
        private String ageFrom;
        private String ageTo;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getIdCard() {
			return idCard;
		}
		public void setIdCard(String idCard) {
			this.idCard = idCard;
		}
		public String getOrganCode() {
			return organCode;
		}
		public void setOrganCode(String organCode) {
			this.organCode = organCode;
		}
		public String getDeptCode() {
			return deptCode;
		}
		public void setDeptCode(String deptCode) {
			this.deptCode = deptCode;
		}
		public String getLocalId() {
			return localId;
		}
		public void setLocalId(String localId) {
			this.localId = localId;
		}
		public String getUseCpy() {
			return useCpy;
		}
		public void setUseCpy(String useCpy) {
			this.useCpy = useCpy;
		}
		public String getUseLike() {
			return useLike;
		}
		public void setUseLike(String useLike) {
			this.useLike = useLike;
		}

        public String getBeginDate() {
            return beginDate;
        }

        public void setBeginDate(String beginDate) {
            this.beginDate = beginDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getTechnical() {
            return technical;
        }

        public void setTechnical(String technical) {
            this.technical = technical;
        }

        public String getAgeFrom() {
            return ageFrom;
        }

        public void setAgeFrom(String ageFrom) {
            this.ageFrom = ageFrom;
        }

        public String getAgeTo() {
            return ageTo;
        }

        public void setAgeTo(String ageTo) {
            this.ageTo = ageTo;
        }
		public String getTownCode() {
			return townCode;
		}
		public void setTownCode(String townCode) {
			this.townCode = townCode;
		}
		public String getStationCode() {
			return stationCode;
		}
		public void setStationCode(String stationCode) {
			this.stationCode = stationCode;
		}

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
	@RequestMapping("/getStaffLogListByOrg")
	@ResponseBody
	public Object getStaffLogList(HttpServletRequest request) {
		Criteria criteria = new Criteria();
		//中心登录
		Organization currentOrg = SecurityUtils.getCurrentOrganization(request);
		if ("B100".equals(currentOrg.getGenreCode())) {//中心
			List<Organization> orgList = organizationService.getOrganizations(new Criteria("parentCode", currentOrg.getOrganCode()));
			List<String> codeList = new ArrayList<>();
			for (Organization org : orgList) {
				codeList.add(org.getOrganCode());
			}
			codeList.add(currentOrg.getOrganCode());
			criteria.add("organCode", OP.IN, codeList);
		}else if("B200".equals(currentOrg.getGenreCode())){//站
			criteria.add("organCode",  currentOrg.getOrganCode());
		}
		List<Staff> list = staffService.getStaffs(criteria);
		return list;
	}

	private List<String> getOrgCodes(HttpServletRequest request,String organCode,String stationCode){
		List<String> orgCodes = new ArrayList<String>();
		if(hasRole(RoleType.QWGZX,request) || hasRole(RoleType.ADMIN,request)){
			if(ObjectUtil.isNotEmpty(organCode)){
				String town = request.getParameter("town");
				String center = request.getParameter("village");
				String station = request.getParameter("station");
				if (ObjectUtil.isNullOrEmpty(station)) {//三级下拉框为空
					if(ObjectUtil.isNullOrEmpty(center)){//二级下拉框为空
						if(ObjectUtil.equals("_showJk", organCode)) {//一级下拉框选择 疾病预防控制中心
							List<Organization> jks = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.JK.getValue()));
							orgCodes=this.getOrganCodes(jks);
						}else if(ObjectUtil.equals("_showWjw", organCode)) {//一级下拉框选择 区卫计委
							List<Organization> wjws = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.AREA_HEALTH.getValue()));
							orgCodes=this.getOrganCodes(wjws);
						}else if(ObjectUtil.equals("_hospital", organCode)) {//一级下拉框选择 综合医院
							List<Organization> hospitals = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue()));
							orgCodes=this.getOrganCodes(hospitals);
						} else if(ObjectUtil.equals("_healthoversight", organCode)) {//一级下拉框选择 卫生监督检验(监测、检测)所(站)
							List<Organization> healthOverSights = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.HEALTH_OVERSIGHT.getValue()));
							orgCodes=this.getOrganCodes(healthOverSights);
						} else if(ObjectUtil.equals("_other", organCode)) {//一级下拉框选择 其它
							List<Organization> others = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.OTHER.getValue()));
							orgCodes=this.getOrganCodes(others);
						} else {//一级下拉框选择 镇或乡
							List<Organization> centres = organizationApp.queryOrganization(new Criteria("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.STATION.getValue()}).add("GB_CODE",town));
							orgCodes=this.getOrganCodes(centres);
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
								orgCodes =this.getOrganCodes(stations);
							}else{//选择  xx疾病预防控制中心  xx卫计委  xx医院 xx卫生监督检验站 xx其他
								orgCodes.add(organization.getOrganCode());
							}
						}
					}
				}else {//三级下拉框不为空
					orgCodes.add(organCode);
				}
			}
		}else if(hasRole(RoleType.ZX_GLY,request)||hasRole(RoleType.Z_GLY, request)||hasRole(RoleType.YY_GLY, request)){
			if(StringUtil.isNotEmpty(stationCode)){
				orgCodes.add(stationCode);
			}
		}
		return orgCodes;
	}

	private void setTownCentreStationNew(Staff staff, ModelMap modelMap) {
		Organization organizationHave = organizationApp.queryOrgan(staff.getOrganCode());
		if(ObjectUtil.isNotEmpty(organizationHave)) {
			String townValue="";
			String centreValue="";
			String stationValue="";
			if(ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.JK.getValue())) {//疾病控制中心
				townValue = EHRConstants._SHOWJK;
				centreValue=organizationHave.getOrganCode();
			}else if(ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue())){//区卫计委
				townValue = EHRConstants._QWJW;
				centreValue=organizationHave.getOrganCode();
			}else if(ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.HEALTH_OVERSIGHT.getValue())){//卫生监督检验(监测、检测)所(站)
				townValue = EHRConstants._HEALTHOVERSIGHT;
				centreValue=organizationHave.getOrganCode();
			}else if(ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.HOSPITAL.getValue())){//综合医院
				townValue = EHRConstants._HOSPITAL;
				centreValue=organizationHave.getOrganCode();
			}else if(ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.OTHER.getValue())){//其他
				townValue = EHRConstants._OTHER;
				centreValue=organizationHave.getOrganCode();
			}else if(ObjectUtil.equals(organizationHave.getGenreCode(), OrgGenreCode.CENTRE.getValue())){//中心
				centreValue = organizationHave.getOrganCode();
				Organization organizationCentre = organizationApp.queryOrgan(centreValue);
				townValue = organizationCentre.getGbCode();
			}else {//站
				stationValue = staff.getOrganCode();
				centreValue = organizationHave.getParentCode();
				Organization organizationCentre = organizationApp.queryOrgan(centreValue);
				townValue = organizationCentre.getGbCode();
			}
			modelMap.addAttribute("townValue", townValue);
			modelMap.addAttribute("centreValue", centreValue);
			modelMap.addAttribute("stationValue", stationValue);
		}
	}

	protected List<String> getOrganCodes(List<Organization> organizations){
		List<String> organCodes = new ArrayList<String>();
		for(Organization organization : organizations) {
			organCodes.add(organization.getOrganCode());
		}
		return organCodes;
	}
}
