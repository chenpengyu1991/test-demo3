package com.founder.rhip.portal.tld;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;

public class UserOrganizationTag extends BaseTag {

	private static final long serialVersionUID = 7639868414405547561L;
	
	@Autowired
	private IEhrSecurityService ehrSecurityService;

	@Autowired
	private IOrganizationApp organizationApp;
	
	// attribute
	private String userCode = null;

	private Boolean showCenter = false;
	
	public int doStartTagInternal() throws JspTagException {
		String html = "";
		inject();
		List<UserRole> userRoles = ehrSecurityService.getUserRole(userCode);
		
		for(UserRole ur:userRoles){
			if(html.equals("")){
				html = getOrgName(ur.getOrganCode());
				continue;
			}
			html += "," + getOrgName(ur.getOrganCode());
		}
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	private String getOrgName(String organCode){
		List<Organization> orgList = organizationApp.queryAllOrganization();
		Organization organization = null;
		for(Organization org:orgList){
			if(org.getOrganCode().equals(organCode)){
				organization = org;
			}
		}
		if(ObjectUtil.isNotEmpty(organization)){
			String orgName = organization.getOrganName();
			if(organization.getGenreCode().equals(OrgGenreCode.STATION.getValue())){
				Organization porg = organizationApp.queryOrgan(organization.getParentCode());
				orgName = porg.getOrganName() + " -- " + orgName;
			}
			return orgName;
		}
		return "";
	}
	
	public IEhrSecurityService getEhrSecurityService() {
		return ehrSecurityService;
	}

	public void setEhrSecurityService(IEhrSecurityService ehrSecurityService) {
		this.ehrSecurityService = ehrSecurityService;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Boolean getShowCenter() {
		return showCenter;
	}

	public void setShowCenter(Boolean showCenter) {
		this.showCenter = showCenter;
	}

}
