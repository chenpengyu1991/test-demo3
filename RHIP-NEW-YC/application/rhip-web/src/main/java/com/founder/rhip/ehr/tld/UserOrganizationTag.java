package com.founder.rhip.ehr.tld;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户所属的机构
 */
public class UserOrganizationTag extends BaseTag {

	private static final long serialVersionUID = 7639868414405547561L;

	@Autowired
	private IEhrSecurityService ehrSecurityService;

	@Autowired
	private IOrganizationApp organizationApp;

	private String userCode = null;

	public int doStartTagInternal() throws JspTagException {
		String html = "";
		inject();
		List<UserRole> userRoles = ehrSecurityService.getUserRole(userCode);
		Map<String, String> organCodes = new HashMap<String, String>();
		for(UserRole ur : userRoles){
			//用户在同一个机构属于多个角色的情况处理
			if(organCodes.containsKey(ur.getOrganCode())){
				continue;
			} else {
				organCodes.put(ur.getOrganCode(), ur.getOrganCode());
			}
			Organization organization = organizationApp.queryOrgan(ur.getOrganCode());
			if(ObjectUtil.isNullOrEmpty(organization)) {
				continue;
			}
			if(html.equals("")){
				html = organization.getOrganName();
				continue;
			}
			html += "," + organization.getOrganName();
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
}
