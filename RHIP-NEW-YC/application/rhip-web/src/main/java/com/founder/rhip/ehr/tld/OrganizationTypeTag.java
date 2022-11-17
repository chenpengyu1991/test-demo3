package com.founder.rhip.ehr.tld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import com.founder.fasf.beans.LOP;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

public class OrganizationTypeTag extends BaseTag {


	private static final long serialVersionUID = 1833883670610689166L;
	private String name = null;
	private String id = null;
	private String value = null;
	private String type = null;//机构类别 例如 综合医院  中心医院 站  其它
	private String code = null;
	private String codeOther = null;//机构类型 其它 中进行机构过滤 需求比较特殊 有些只需要显示疾控
	private String defaultval = "N";
	private String firstLabel = "请选择";
	private String width = null;
	private String reg = null;//验证规则
	private boolean isMultiple = false;////若为true说明是复选
	private String parentCode = null;//根据中心的code获取其下的站
	private boolean includeParent = false;//包含中心机构
	private String onchange = null;
	private String cssClass = null;

	public String getSubsid() {
		return subsid;
	}

	public void setSubsid(String subsid) {
		this.subsid = subsid;
	}

	private String subsid = null;//是否显示子机构 例如分院什么的   子机构标识：0非子机构，1子机构
	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IOrganizationService mdmOrganizationService;

	public int doStartTagInternal() throws JspTagException {
		inject();
		String html;

		List<Organization> result = this.getResultOrgs();
		StringBuilder sb = this.getSelectBefore();
		if(ObjectUtil.isNotEmpty(result)) {
			if (isMultiple) {
				if(StringUtils.isNotEmpty(value)) {
					List<Organization> orgTemps = mdmOrganizationService.getOrganizations(new Criteria(Organization.ORGAN_CODE, OP.IN, value.split(",")));
					for(Organization temp: orgTemps) {
						if(temp.getStatus() == StatusValue.deleteValue.getValue()) {
							sb.append("\t\t<option value=\"" + temp.getOrganCode() + "\" title=\"" + temp.getOrganName() + "\" selected>" + temp.getOrganName() + "</option>\r\n");
						}
					}
				}
				for (Organization temp : result) {
					sb = this.getMultipleOption(temp, sb);
				}
			} else {
				Organization org = mdmOrganizationService.getOrganization(this.value);
				if(ObjectUtil.isNotEmpty(org) && org.getStatus() == StatusValue.deleteValue.getValue()) {
					sb.append("<option title=\""+ org.getOrganName() + "\" value='" + org.getOrganCode() + "' selected" + ">" + org.getOrganName() + "</option>");
				}
				for (Organization temp : result) {
					sb = this.getOption(temp, sb);
				}
			}
		}
		sb.append("</select>");
		html = sb.toString();

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

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public boolean isIncludeParent() {
		return includeParent;
	}

	public void setIncludeParent(boolean includeParent) {
		this.includeParent = includeParent;
	}

	private List<Organization> getResultOrgs() {
		List<Organization> result = new ArrayList<Organization>();
		Criteria hosCriteria = new Criteria("GENRE_CODE",OrgGenreCode.HOSPITAL.getValue());
		if(ObjectUtil.isNotEmpty(subsid)) {
			//在机构管理中没有发现subsid赋值 暂时先忽略此属性
			//hosCriteria.add("subsid", subsid);
		}
		List<Organization> hospitals = organizationApp.queryOrganization(hosCriteria);//获取综合医院
		List<Organization> centres = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.CENTRE.getValue()));//获取中心医院
		List<Organization> stations = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.STATION.getValue()));//获取服务站

		if(StringUtils.isNotEmpty(parentCode)) {
			if(includeParent)
				result = organizationApp.queryOrganization(new Criteria(Organization.ORGAN_CODE, parentCode).add(LOP.OR,new Criteria(Organization.PARENT_CODE, parentCode)));//获取中心及服务站
			else
				result = organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, parentCode));//获取服务站
		} else {
			if(StringUtils.isEmpty(type)) {
				result.addAll(hospitals);
				result.addAll(centres);
				result.addAll(stations);
			}
			if(StringUtils.contains(type, "hospital")) {
				result.addAll(hospitals);
			}
			if(StringUtils.contains(type, "other")) {
				Criteria criteria = new Criteria();
				criteria.add("GENRE_CODE", OP.IN,new String[]{OrgGenreCode.OTHER.getValue(),OrgGenreCode.JK.getValue()});
				if(StringUtils.isNotEmpty(codeOther)) {
					result.addAll(organizationApp.queryOrganization(criteria.add("organCode", codeOther)));
				} else {
					result.addAll(organizationApp.queryOrganization(criteria));
				}
			}
			if(StringUtils.contains(type, "centre")) {
				result.addAll(centres);
			}
			if(StringUtils.contains(type, "station")) {
				result.addAll(stations);
			}
			if(StringUtils.contains(type, "wsjdsfs")) {
				result.addAll( organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.HEALTH_OVERSIGHT.getValue())));
			}
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
		if (StringUtils.isNotEmpty(cssClass)) {
			sb.append(" class=\"" + cssClass + "\"");
		}
		if (StringUtils.isNotEmpty(width)) {
			sb.append("style=\"width:"+ width + ";\"");
		}
		if (isMultiple) {
			sb.append(" multiple=\"multiple \"");
		}
		if (StringUtils.isNotEmpty(reg)) {
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
		}
		if(StringUtils.isNotEmpty(onchange)){
			sb.append(" onchange=\"" + onchange + "\"");
		}
		sb.append(">\r\n");
		if("N".equals(defaultval) && !isMultiple){
			sb.append("\t\t<option value=\"\">"+firstLabel+"</option>\r\n");
		}
		return sb;
	}

	private StringBuilder getMultipleOption(Organization org, StringBuilder sb) {
		boolean flag = true;
		if(StringUtils.isNotEmpty(value)) {
			String values[] = value.split(",");
			for(String temp: values) {
				if (org.getOrganCode().equals(temp)) {
					sb.append("\t\t<option value=\"" + org.getOrganCode() + "\" title=\"" + org.getOrganName() + "\" selected>" + org.getOrganName() + "</option>\r\n");
					flag = false;
					break;
				}
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

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public String getDefaultval() {
		return defaultval;
	}

	public void setDefaultval(String defaultval) {
		this.defaultval = defaultval;
	}

	public String getCodeOther() {
		return codeOther;
	}

	public void setCodeOther(String codeOther) {
		this.codeOther = codeOther;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	
}
