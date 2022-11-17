package com.founder.rhip.ehr.tld;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

/**
 * 给出机构code值显示其机构名称
 * @author Jiang Haiying
 *
 */
public class OrganizationTag extends BaseTag {

	private static final long serialVersionUID = -7771532441918268451L;

	@Autowired
	private IOrganizationService mdmOrganizationService;

	private String code = null;
	private String flag = "0";

	public int doStartTagInternal() throws JspTagException {
		String name = "";
		String key = flag + "|" + code;
		if (DictionaryCache.orgMap.containsKey(key)) {
			name = DictionaryCache.orgMap.get(key);
		} else {
			if (StringUtils.isNotEmpty(code)) {
				List<Organization> list = null;
				Criteria criteria = null;
				inject();
				String[] codes = code.split(",");
				if ("1".equals(flag)) {
					criteria = new Criteria(Organization.ORGAN_ID, OP.IN, codes);
				} else {
					criteria = new Criteria(Organization.ORGAN_CODE, OP.IN, codes);
				}
				list = mdmOrganizationService.getOrganizations(criteria);
				if (list != null) {
					for (Organization org : list) {
						name += org.getOrganName() + "，";
					}
					if (name.length() > 0) {
						name = name.substring(0, name.length() - 1);
					}
					DictionaryCache.orgMap.put(key, name);
				}
			}
		}
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(name);
		} catch (IOException e) {

		}
		return SKIP_BODY;
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
