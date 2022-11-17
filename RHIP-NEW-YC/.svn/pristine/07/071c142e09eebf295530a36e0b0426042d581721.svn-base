package com.founder.rhip.ehr.tld;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

import org.apache.commons.lang.StringUtils;

import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;

/**
 * 权限标签 只有ifAnyGranted包含某角色的name 才会显示去标签内的内容
 * @author Jiang Haiying
 *
 */
public class Authorize extends BaseTag {

	private static final long serialVersionUID = -2965834693493677396L;

	private String ifAnyGranted = null;//包含其中任何一个角色则显示期间内容
	
	private String ifNotGranted = null;//包含其中任何一个角色 跳过其显示区域
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		if(StringUtils.isEmpty(ifAnyGranted) && StringUtils.isEmpty(ifNotGranted)) {
			return SKIP_BODY;
		} else if(StringUtils.isNotEmpty(ifAnyGranted) && StringUtils.isNotEmpty(ifNotGranted)) {
			return SKIP_BODY;
		}
		
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) pageContext.getSession().getAttribute("currentLoginInfo");
		if(ObjectUtil.isNullOrEmpty(currentLoginInfo)) {
			return SKIP_BODY;
		}
		List<String> userRoles = this.getUserRoles(currentLoginInfo);
		
		if(StringUtils.isNotEmpty(ifAnyGranted)) {
			String roles[] = ifAnyGranted.split(",");
			for (String roleName : roles) {
				if(userRoles.contains(roleName)) {
					return EVAL_BODY_INCLUDE;
				}
			}
			return SKIP_BODY;
		} else if(StringUtils.isNotEmpty(ifNotGranted)) {
			String notRoles[] = ifNotGranted.split(",");
			for (String roleName : notRoles) {
				if(userRoles.contains(roleName)) {
					return SKIP_BODY;
				}
			}
			return EVAL_BODY_INCLUDE;
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
	
	public String getIfNotGranted() {
		return ifNotGranted;
	}

	public void setIfNotGranted(String ifNotGranted) {
		this.ifNotGranted = ifNotGranted;
	}

	/**
	 * 以String集合的形式获取当前用户的角色
	 * @param currentLoginInfo
	 * @return
	 */
	private List<String> getUserRoles(CurrentLoginInfo currentLoginInfo) {
    	List<String> roleCodes = new ArrayList<String>();
    	List<Role> userRoles = currentLoginInfo.getRoles();
    	for(Role userRole : userRoles) {
    		roleCodes.add(userRole.getRoleCode());
		}
    	return roleCodes;
    }
	 
}
