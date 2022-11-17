package com.founder.rhip.cdm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 慢病
 * 
 * @author liuk
 * 
 */
public abstract class CdmBaseController extends BaseController {

	private static final String INDEX_PAGE_KEY = "indexPage";// resquest中的当前页的key
	private static final String PAGE_KEY = "page";// page key

	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IDictionaryApp dictionaryApp;

	/**
	 * 获取角色
	 * 
	 * @param request
	 * @return
	 */
	public RoleType getRole(HttpServletRequest request) {
		RoleType role = null;
		if (hasRole(RoleType.ZXMB, request)) {
			role = RoleType.ZXMB;
		}else if (hasRole(RoleType.YYMB, request)) {
			role = RoleType.YYMB;
		} else if (hasRole(RoleType.JKMBK, request)) {
			role = RoleType.JKMBK;
		} else if (hasRole(RoleType.ZMB, request)) {
			role = RoleType.ZMB;
		} else if (hasRole(RoleType.ADMIN, request)) {
			role = RoleType.ADMIN;
		} else {
			Assert.notNull(role, "没有权限,请更换用户登录");
		}
		return role;
	}

	/**
	 * 如果人员生日为空,则根据身份证设置生日
	 * 
	 * @param personInfo
	 * @return
	 */
	public Date setBirthday(PersonInfo personInfo) {
		Date birthday = personInfo.getBirthday();
		if (ObjectUtil.isNullOrEmpty(birthday)) {
			String idcard = personInfo.getIdcard();
			if (ObjectUtil.isNotEmpty(idcard)) {
				// 如果没有生日,根据身份证算出
				birthday = IDCardUtil.getBirthDateByIdCard(idcard);
				personInfo.setBirthday(birthday);
			}
		}
		return birthday;
	}

	/**
	 * 当前controller类功能描述
	 * 
	 * @return
	 */
	protected String getActionName() {
		String clazzName = this.getClass().getName();
		return clazzName;
	}

	/**
	 * 记录操作日志
	 * 
	 * @param request
	 * @param op
	 */
	protected void record(HttpServletRequest request, OperationName op) {
		createOperationLog(request, RhipModuleName.CDM, getActionName(), op);
	}

	protected void addRoleCriteria(Criteria criteria, String columnName, HttpServletRequest request) {
		Organization organization = getCurrentOrg(request);
		if (RoleType.ZMB.equals(getRole(request))) {
			criteria.add(columnName, organization.getOrganCode());
		} else if (RoleType.ZXMB.equals(getRole(request))) {
			criteria.add(columnName, OP.IN, getStation(organization.getOrganCode()));
		}
	}

	protected List<String> getStation(String parentCode) {
		List<Organization> stations = new ArrayList<Organization>();
		List<String> stationOrgCodes = new ArrayList<String>();

		Criteria criteria = new Criteria(Organization.PARENT_CODE, parentCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue());

		stations = organizationApp.queryOrganization(criteria);
		for(Organization org : stations) {
			stationOrgCodes.add(org.getOrganCode());
		}
		return stationOrgCodes;
	}

	protected String getStations(String parentCode) {
		List<Organization> stations = new ArrayList<Organization>();
		String stationOrgCodes = "";
		Criteria criteria = new Criteria(Organization.PARENT_CODE, parentCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue());

		stations = organizationApp.queryOrganization(criteria);
		for(Organization org : stations) {
			if(ObjectUtil.isNotEmpty(stationOrgCodes)) {
				stationOrgCodes = stationOrgCodes + ",'" + org.getOrganCode() + "'";
			} else {
				stationOrgCodes = "'" + org.getOrganCode() + "'";
			}

		}
		return stationOrgCodes;
	}

	protected void getPersonAddress(PersonInfo personInfo) {
		String paAddressDetail = "";
		if (ObjectUtil.isNotEmpty(personInfo.getPatownShip())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getPatownShip());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String pacountyName = paDicItem1.getItemName();
				paAddressDetail = pacountyName;
			}
		}

		if (ObjectUtil.isNotEmpty(personInfo.getPastreet())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getPastreet());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String paStreetName = paDicItem1.getItemName();
				paAddressDetail += " " + paStreetName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getPaGroup())) {
			DicItem paDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getPaGroup());
			if (ObjectUtil.isNotEmpty(paDicItem2)) {
				String paVillagName = paDicItem2.getItemName();
				paAddressDetail += " " + paVillagName;
			}
		}

		String hrAddressDetail = "";
		if (ObjectUtil.isNotEmpty(personInfo.getHrtownShip())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrtownShip());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String hrcountyName = paDicItem1.getItemName();
				hrAddressDetail = hrcountyName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getHrstreet())) {
			DicItem hrDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrstreet());
			if (ObjectUtil.isNotEmpty(hrDicItem1)) {
				String paTownName = hrDicItem1.getItemName();
				hrAddressDetail += " " + paTownName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getHrGroup())) {
			DicItem hrDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrGroup());
			if (ObjectUtil.isNotEmpty(hrDicItem2)) {
				String paStreetName = hrDicItem2.getItemName();
				hrAddressDetail += " " + paStreetName;
			}
		}
		personInfo.setHrAddressDetail(hrAddressDetail);
		personInfo.setPaAddressDetail(paAddressDetail);
	}

	/**
	 * 根据身份证号计算年龄
	 * @param IdNO
	 * @return
	 */
	public int IdNOToAge(String IdNO){
		int leh = IdNO.length();
		String dates="";
		if (leh == 18) {
			//身份证去除int的转换
            /*int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;*/
			dates = IdNO.substring(6, 10);
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String year=df.format(new Date());
			int u=Integer.parseInt(year)-Integer.parseInt(dates);
			return u;
		}else{
			dates = IdNO.substring(6, 8);
			return Integer.parseInt(dates);
		}

	}
}
