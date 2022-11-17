package com.founder.rhip.portal.tld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;

public class OrganizationTypeTag extends BaseTag {

	private static final long serialVersionUID = 1833883670610689166L;
	private String name = null;
	private String id = null;
	private String value = null;
	private String type = null;//机构类别 例如 综合医院  中心医院
	private String code = null;
	private String firstLabel = "请选择";
	private String width = null;
	private String reg = null;//验证规则
	private boolean isMultiple = false;////若为true说明是复选
	@Autowired
	private IOrganizationApp organizationApp;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		String key = id + "|" + name + "|" + type + "|" + width+"|" +code + "|" + value ;
		String html;
		/*if (DictionaryCache.dicListMap.containsKey(key)) {
			html = DictionaryCache.dicListMap.get(key);
		} else {*/
			List<Organization> result = this.getResultOrgs(); 
			StringBuilder sb = this.getSelectBefore();
			if(ObjectUtil.isNotEmpty(result)) {
				if (isMultiple && StringUtils.isNotEmpty(value)) {
					for (Organization org : result) {
						sb = this.getMultipleOption(org, sb);
					}
				} else {
					for (Organization org : result) {
						sb = this.getOption(org, sb);
					}
				}
			}
			sb.append("</select>");
			html = sb.toString();
			DictionaryCache.dicListMap.put(key, html);
		/*}*/
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(html);
		} catch (IOException e) {
		}
		return SKIP_BODY;
	}
	
	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstLabel() {
		return firstLabel;
	}

	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean getIsMultiple() {
		return isMultiple;
	}

	public void setIsMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}

	private List<Organization> getResultOrgs() {
		List<Organization> result = new ArrayList<Organization>(); 
		
		List<Organization> hospitals = organizationApp.queryOrganization(new Criteria("GB_CODE",  "_999"));//获取综合医院
		List<Organization> centres = organizationApp.queryOrganization(new Criteria("GB_CODE", OP.UEMPTY,"").add("GB_CODE", OP.NE, "_999"));//获取中心医院
		List<Organization> stations = organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, OP.EQ,"0").add("GB_CODE", OP.IS,"NULL"));//获取服务站
		if(StringUtils.isEmpty(type)) {
			result.addAll(hospitals);
			result.addAll(centres);
			result.addAll(stations);
		}
		if(StringUtils.contains(type, "hospital")) {
			result.addAll(hospitals);
		}
		if(StringUtils.contains(type, "centre")) {
			result.addAll(centres);
		}
		if(StringUtils.contains(type, "station")) {
			result.addAll(stations);
		}
		
		if (StringUtils.isNotEmpty(code)) {
			String[] codes = this.code.split(",");
			result = organizationApp.queryOrganization(new Criteria(Organization.ORGAN_CODE, OP.IN, codes));
		}
		return result;
	}
	
	private StringBuilder getSelectBefore () {
		StringBuilder sb = new StringBuilder("<select");
		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		sb.append(" name=\"" + name + "\"");
		if (StringUtils.isNotEmpty(width)) {
			sb.append("style=\"width:"+ width + ";\"");
		}
		if (isMultiple) {
			sb.append(" multiple=\"multiple \"");
		} 
		if (StringUtils.isNotEmpty(reg)) {
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
		}
		sb.append(">\r\n");
		if(!isMultiple){
			sb.append("\t\t<option value=\"\">"+firstLabel+"</option>\r\n");
		}
		return sb;
	}

	private StringBuilder getMultipleOption(Organization org, StringBuilder sb) {
		String values[] = value.split(",");
		boolean flag = true;
		for(String temp: values) {
			if (org.getOrganCode().equals(temp)) {
				sb.append("\t\t<option value=\"" + org.getOrganCode() + "\" title=\"" + org.getOrganName() + "\" selected>" + org.getOrganName() + "</option>\r\n");
				flag = false;
				break;
			}
		}
		if (flag){
			sb.append("\t\t<option value=\"" + org.getOrganCode() + "\" title=\"" + org.getOrganName() + "\" >" + org.getOrganName() + "</option>\r\n");
		}
		return sb;
	}
	
	private StringBuilder getOption(Organization org, StringBuilder sb) {
		if (org.getOrganCode().equals(value)) {
			sb.append("\t\t<option value=\"" + org.getOrganCode() + "\"  title=\"" + org.getOrganName() + "\" selected>" + org.getOrganName() + "</option>\r\n");
		} else{
			sb.append("\t\t<option value=\"" + org.getOrganCode() + "\"  title=\"" + org.getOrganName() + "\" >" + org.getOrganName() + "</option>\r\n");
		}
		return sb;
	}
}
