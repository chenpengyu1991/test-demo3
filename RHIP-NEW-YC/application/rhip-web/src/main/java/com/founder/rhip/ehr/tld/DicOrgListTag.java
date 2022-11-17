package com.founder.rhip.ehr.tld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import com.founder.rhip.ehr.cache.DictionaryCache;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;

public class DicOrgListTag extends BaseTag {

	private static final long serialVersionUID = -789945210773001174L;

	@Autowired
    private IOrganizationApp organizationApp;

	private String id = null;
	private String name = null;
	private String value = null;
	private String defaultval = "N";
	private String firstLabel = "请选择";
	private String width = null;
	private String onclick;
	private String reg = null;
	private String cssClass = null;
	//根据属性isShowOneself判断是否显示当前登录的机构(中心级别)取值
	private boolean isShowOneself = false;

	public int doStartTagInternal() throws JspTagException {
		inject();
		List<Organization> list = null;
		String html = null;
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) pageContext.getSession().getAttribute("currentLoginInfo");
		Organization org = currentLoginInfo.getOrganization();
		
		list = this.getOrgs(org);
		StringBuilder sb = this.getSelectBefore(this.id,this.name, org, list);
		if(ObjectUtil.isNotEmpty(list)) {
			for (Organization temp : list) {
				sb = this.getOption(temp, sb);
			}
		}
		sb.append("</select>");
		html = sb.toString();
		
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDefaultval() {
		return defaultval;
	}

	public void setDefaultval(String defaultval) {
		this.defaultval = defaultval;
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

	public String getOnclick() {
		return onclick;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	public boolean isIsShowOneself() {
		return isShowOneself;
	}

	public void setIsShowOneself(boolean isShowOneself) {
		this.isShowOneself = isShowOneself;
	}

	private List<Organization> getOrgs(Organization org) {
		List<Organization> list = new ArrayList<Organization>();
		if (ObjectUtil.isNullOrEmpty(org)) return list;
		if(StringUtils.equals(org.getGenreCode(), OrgGenreCode.CENTRE.getValue())){
			if(isShowOneself) {
				list.add(org);
			}
			list.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, org.getOrganCode())));
		} else {//StringUtils.isNotEmpty(org.getParentCode())
			list = organizationApp.queryOrganization(new Criteria("organ_code", org.getOrganCode()));
		}
		return list;
	}
	
	private StringBuilder getSelectBefore(String id, String name, Organization org, List<Organization> list) {
		StringBuilder sb = new StringBuilder("<select");
		
		sb.append(showTitle(value,list));
		sb.append("onchange=\"showTitleByName('" + name + "')\"");
		
		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		sb.append(" name=\"" + name + "\"");
		if (StringUtils.isNotEmpty(width)) {
			sb.append("style=\"width:"+ width + ";\"");
		}
		
		if (StringUtils.isNotEmpty(cssClass)) {
			sb.append("class=\""+ cssClass + "\"");
		}
		
		if (StringUtils.isNotEmpty(reg)) {
            sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
            this.setReg(null);
        }
		
		sb.append(" idd=\"orglistid\"");
		sb.append(" onchange=\"showTitle('orglistid')\"");
		sb.append(">\r\n");
		if("N".equals(defaultval) && StringUtils.isNotEmpty(org.getGbCode())){
			sb.append("\t\t<option value=\"\">"+firstLabel+"</option>\r\n");
		}	
		return sb;
	}
	
	private StringBuilder getOption(Organization org, StringBuilder sb) {//addFamily.displayValue
		if (org.getOrganCode().equals(value)) {
			if (StringUtils.isNotEmpty(onclick)) {//无点击事件
				sb.append("\t\t<option title=\""+ org.getOrganName()+ "\" value=\"" + org.getOrganCode() +"\" onclick=\""+ onclick + "('"+ org.getOrganName() + "');\"" 
						+ " selected");
			} else {
				sb.append("\t\t<option title=\""+ org.getOrganName() + "\" value=\"" + org.getOrganCode() + "\" selected");
			}
		} else{
			if (StringUtils.isNotEmpty(onclick)) {//有点击事件
				sb.append("\t\t<option title=\""+ org.getOrganName() + "\" value=\"" + org.getOrganCode() +"\" onclick=\""+ onclick + "('"+ org.getOrganName() + "');\"");
			} else {
				sb.append("\t\t<option title=\""+ org.getOrganName() + "\" value=\"" + org.getOrganCode() + "\"");
			}
		}
		sb.append(">" + org.getOrganName() + "</option>\r\n");
		return sb;
	}
	
	/**
	 * 判断select的title是显示默认值还是已给出的值
	 * @param value
	 * @return
	 */
	private String showTitle(String value, List<Organization> list) {
		if(ObjectUtil.isNullOrEmpty(value) && ObjectUtil.isNotEmpty(list) && list.size() == 1) {
			return " title=\""+ list.get(0).getOrganName() + "\"";
		}
		Organization org = organizationApp.queryOrgan(value);
		if(ObjectUtil.isNotEmpty(org)) {
			return " title=\""+ org.getOrganName() + "\"";
		} else {
			return" title=\""+ firstLabel + "\"";
		}
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	
}
