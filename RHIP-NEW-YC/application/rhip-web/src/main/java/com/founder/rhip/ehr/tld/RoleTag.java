package com.founder.rhip.ehr.tld;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * 给出机构code值显示其机构名称
 * @author Jiang Haiying
 *
 */
public class RoleTag extends BaseTag {

	@Autowired
	private IEhrSecurityService ehrSecurityService;

	private static final long serialVersionUID = -7173108652475404757L;

	private String roleCode = null;//role表中的role_code

	public int doStartTagInternal() throws JspTagException {
		inject();
		String name = "";

		if (StringUtils.isNotEmpty(roleCode)) {
			if(DictionaryCache.userMap.containsKey(roleCode)) {
				name = DictionaryCache.userMap.get(roleCode);
			} else {
				Role role = ehrSecurityService.getRole(new Criteria("role_code", roleCode));
				if(ObjectUtil.isNotEmpty(role)) {
					name = role.getName();
					DictionaryCache.userMap.put(roleCode, name);
				}
			}
		}
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
}
