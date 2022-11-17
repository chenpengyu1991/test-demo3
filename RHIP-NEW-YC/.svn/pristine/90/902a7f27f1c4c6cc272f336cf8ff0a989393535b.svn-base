package com.founder.rhip.portal.tld;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

import org.apache.commons.lang.StringUtils;

import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.elb.entity.Role;

/**
 * 权限标签 只有ifAnyGranted包含某角色的name 才会显示去标签内的内容
 * @author Jiang Haiying
 *
 */
public class Authorize extends BaseTag {

	private static final long serialVersionUID = -2965834693493677396L;

	private String ifAnyGranted;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		if(StringUtils.isEmpty(ifAnyGranted)){
			return SKIP_BODY;
		}
		
		String roles[] = ifAnyGranted.split(",");
		
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) pageContext.getSession().getAttribute("currentLoginInfo");
		List<Role> userRoles = currentLoginInfo.getRoles();
		
		for (String roleName : roles) {
			for(Role userRole : userRoles) {
				if(StringUtils.equals(roleName, userRole.getRoleCode())) {
					return EVAL_BODY_INCLUDE;
				}
			}
		}
		return SKIP_BODY;
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public String getIfAnyGranted() {
		return ifAnyGranted;
	}

	public void setIfAnyGranted(String ifAnyGranted) {
		this.ifAnyGranted = ifAnyGranted;
	}
}
