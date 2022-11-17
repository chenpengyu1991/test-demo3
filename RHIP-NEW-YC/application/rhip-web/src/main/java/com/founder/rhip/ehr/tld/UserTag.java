package com.founder.rhip.ehr.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.mdm.app.IOrganizationApp;

/**
 * 给出机构code值显示其机构名称
 * @author Jiang Haiying
 *
 */
public class UserTag extends BaseTag {

	private static final long serialVersionUID = -7771532441918268451L;

	@Autowired
	private IEhrSecurityService ehrSecurityService;
	
	@Autowired
	private IOrganizationApp organizationApp;

	// attribute
	private String userCode = null;

	public int doStartTagInternal() throws JspTagException {
		inject();
		String name = "";
		if (DictionaryCache.userMap.containsKey(userCode)) {
			name = DictionaryCache.userMap.get(userCode);
		} else {
			if (StringUtils.isNotEmpty(userCode) && userCode.contains(",")) {
				String[] userCodes = userCode.split(",");
				for(String temp : userCodes) {
					if ("".equals(name)) {
						name = ehrSecurityService.getUser(new Criteria("user_code", temp)).getName();
					} else {
						name = name + "," + getUserName(temp);
					}
				}
				DictionaryCache.userMap.put(userCode, name);
			} else if(StringUtils.isNotEmpty(userCode) && !userCode.contains(",")) {
				name = getUserName(userCode);
				DictionaryCache.userMap.put(userCode, name);
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
	
	private String getUserName(String userCode){
		if(ObjectUtil.isNullOrEmpty(userCode)){
			return "";
		}
		User user = ehrSecurityService.getUser(new Criteria("user_code", userCode));
		if(null!=user){
			return user.getName();
		}
		return "";
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public IOrganizationApp getOrganizationApp() {
		return organizationApp;
	}

	public void setOrganizationApp(IOrganizationApp organizationApp) {
		this.organizationApp = organizationApp;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
}
