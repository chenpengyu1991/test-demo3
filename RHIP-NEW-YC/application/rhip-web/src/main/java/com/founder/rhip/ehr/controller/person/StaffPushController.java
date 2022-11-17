package com.founder.rhip.ehr.controller.person;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PushStaffResponse;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.WebProperties;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.mdm.app.IStaffApp;
import com.founder.rhip.mdm.app.OrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.entity.StaffOrg;
import com.founder.rhip.mdm.service.IStaffService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 医务人员注册服务
 */
@Controller
@RequestMapping("/staffPush")
public class StaffPushController extends BaseController {
	
	@Resource(name = "staffApp")
	private IStaffApp staffApp;
	
	@Resource(name = "ehrSecurityService")
	private IEhrSecurityService ehrSecurityService;

    @Resource(name = "organizationApp")
    private OrganizationApp organizationApp;

	@Resource(name = "mdmStaffService")
	private IStaffService staffService;

	@RequestMapping("/push")
	@ResponseBody
	public Map<String,String> push(HttpServletRequest request, String staffXml) {

		PushStaffResponse pushResp = new PushStaffResponse();
		try {
			Staff staff = unmarshal(staffXml, Staff.class);
			if (ObjectUtil.isNullOrEmpty(staff.getIdCard())) {
				pushResp.setCode(EHRConstants.AE);
				pushResp.setText("医务人员身份证为空！");
				return pushResp.getMap();
			}
			List<Staff> staffList = staffApp.queryStaff(new Criteria("idCard", staff.getIdCard()).add("status","1"));
			if (ObjectUtil.isNotEmpty(staffList)) { // 如果医务人员表中存在取localId、staffId的值
				staff.setStaffCode(staffList.get(0).getStaffCode());
				staff.setLocalId(staffList.get(0).getLocalId());
			} else { // localId的值为身份证号
				staff.setLocalId(staff.getIdCard());
			}
			Organization org = organizationApp.queryOrgan(staff.getOrganCode());
			//医务人员所属的机构
			List<StaffOrg> staffOrgs = getStaffOrg(staff,org);
			staff.setStaffOrgs(staffOrgs);
			Staff saf = staffApp.registStaff(staff);
            //更新情况下不丢失staffcode
            if(StringUtil.isNullOrEmpty(saf.getStaffCode())){
                saf.setStaffCode(staff.getStaffCode());
            }
			//更新情况下不丢失staffcode
			if(StringUtil.isNullOrEmpty(saf.getUserName())){
				saf.setUserName(staff.getUserName());
			}
			User user = ehrSecurityService.getUser(new Criteria("identityCard", staff.getIdCard()));
			// 医务人员未创建用户，需要创建用户
			if (ObjectUtil.isNullOrEmpty(user)) {
				User u = new User();
				u.setUserName(saf.getUserName());
				u.setPassword(WebProperties.getMsg("default.pwd"));
				u.setIdentityCard(saf.getIdCard());
				u.setName(saf.getName());
				u.setGender(Integer.valueOf(saf.getGender()));
				u.setMobile(saf.getMobile());
				u.setStaffCode(saf.getStaffCode());
                u.setUserCode("0");
                //注册用户角色
                if(ObjectUtil.isNotEmpty(org)){
                    String[] roleCodes = new String[1];
                    if(OrgGenreCode.CENTRE.getValue().equals(org.getGenreCode())){
                        roleCodes[0] = RoleType.ZX_GLY.getValue();
                    }else if(OrgGenreCode.STATION.getValue().equals(org.getGenreCode())){
                        roleCodes[0] = RoleType.Z_GLY.getValue();
                    }else if(OrgGenreCode.CITY_HEALTH.getValue().equals(org.getGenreCode())){//卫生局
                        roleCodes[0] = RoleType.ADMIN.getValue();
                    }else if(OrgGenreCode.AREA_HEALTH.getValue().equals(org.getGenreCode())){//区卫生局 团风三级层级都是ADMIN 四级需根据要求变更
                        roleCodes[0] = RoleType.ADMIN.getValue();
                    }else if(OrgGenreCode.JK.getValue().equals(org.getGenreCode())){//疾控
                        roleCodes[0] = RoleType.JKJKDN.getValue();
                    }else if(OrgGenreCode.HOSPITAL.getValue().equals(org.getGenreCode())){
                        roleCodes[0] = RoleType.JKJKDN.getValue();
                    }else {
                        roleCodes[0] = RoleType.Z_GLY.getValue();
                    }
                    ehrSecurityService.createUser(u,staff.getOrganCode(),roleCodes);
                }else{
                    ehrSecurityService.createUser(u);
                }
			} else {
				user.setStaffCode(saf.getStaffCode());
				ehrSecurityService.updateUserObject(user);
			}
			pushResp.setCode(EHRConstants.AA);
			pushResp.setText("医务人员注册成功！");
		} catch (Exception e) {
			pushResp.setCode(EHRConstants.AE);
			pushResp.setText(e.getMessage());
			e.printStackTrace();
		}
		return pushResp.getMap();
	}

	/**
	 * 为StaffOrg赋值
	 * @param staff
	 * @param org
	 * @throws Exception
	 */
	private List<StaffOrg> getStaffOrg(Staff staff, Organization org){
		List<StaffOrg> result = new ArrayList<>();
		List<StaffOrg> staffOrgs = staffService.getStaffOrgList(new Criteria("STAFF_CODE", staff.getStaffCode()));
		for (StaffOrg staffOrg:staffOrgs){
			if(!org.getOrganCode().equals(staffOrg.getOrganCode())){
				result.add(staffOrg);
			}
		}
		StaffOrg staffOrg = new StaffOrg();
		staffOrg.setStaffCode(staff.getStaffCode());
		staffOrg.setSmpiId(staff.getSmpiId());
		staffOrg.setOrganCode(staff.getOrganCode());
		staffOrg.setDeptCode(staff.getDeptCode());
		staffOrg.setWorkIdCard(staff.getWorkIdCard());
		staffOrg.setCardNum(staff.getCardNum());
		staffOrg.setCreateOrganCode(org.getOrganCode());
		staffOrg.setCreateDate(new Date());
		staffOrg.setCreateOrganName(org.getOrganName());

		User user = ehrSecurityService.getUser(new Criteria("userName", "admin"));
		if(ObjectUtil.isNotEmpty(user)) {
			staffOrg.setCreateUserName(user.getUserName());
			staffOrg.setCreateUserId(user.getUserCode());
		}
		/*主机构*/
		staffOrg.setIS_MAIN("0");
		result.add(staffOrg);
		return result;
	}
}
