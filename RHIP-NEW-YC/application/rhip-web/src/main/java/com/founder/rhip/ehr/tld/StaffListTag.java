package com.founder.rhip.ehr.tld;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.service.IStaffService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 字典数据以下拉列表形式展现
 * @author Jiang Haiying
 *
 */
public class StaffListTag extends BaseTag {

	private static final long serialVersionUID = -789945210773001174L;

	// attribute
	private String id = null;
	private String name = null;
	private String orgCode = null;
	private String value = null;
	private String defaultval = "N";
	private String firstLabel = "请选择";
	private String style = null;
	private String reg = null;//验证规则
	private String onchange = null;
	private boolean flag = false;

	@Autowired
	private IStaffService mdmStaffService;

	public int doStartTagInternal() throws JspTagException {
		flag = false;
		inject();
		if(StringUtils.isEmpty(orgCode)) {
			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) pageContext.getSession().getAttribute("currentLoginInfo");
			orgCode = currentLoginInfo.getOrganization().getOrganCode();
		}
		List<Staff> list = getStaffs(new Criteria("o.organ_code", orgCode).add("status", "1"));
		String html = null;
//		String key = id + "|" + name + "|" + orgCode + "|" + value + "|" + style + "|"+ defaultval + "|"+reg + "|" + onchange;
//		if (DictionaryCache.staffListMap.containsKey(key)) {
//			html = DictionaryCache.staffListMap.get(key);
//		} else {
			StringBuilder sb = this.getSelectBefore();
			if(ObjectUtil.isNotEmpty(list)) {
				for (Staff staff : list) {
					sb = this.getOption(staff, sb);
				}
			}
			//上级查询下级时，列表中增加要查询的下级信息
			if(!flag && value!=null) {
				list = this.getStaffs(new Criteria("o.staff_Code", value));
				if (list.size() > 0) {
					sb.append("\t\t<option title=\"" + list.get(0).getName() + "\" value=\"" + list.get(0).getStaffCode() + "\" selected>" + list.get(0).getName() + "</option>\r\n");
				}
			}
			sb.append("</select>");
			html = sb.toString();
			//DictionaryCache.staffListMap.put(key, html);
		//}
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.orgCode="";
		return SKIP_BODY;
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	private StringBuilder getSelectBefore () {
		StringBuilder sb = new StringBuilder("<select");
		sb.append(showTitle(value));
		sb.append(" onchange=\"showTitleByName('" + name + "');");

		if (StringUtils.isNotEmpty(onchange)) {
			sb.append(onchange + "\"");
		} else {
			sb.append("\"");
		}
		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		sb.append(" name=\"" + name + "\"");
		if (StringUtils.isNotEmpty(style)) {
			sb.append("style=\""+ style + "\"");
		}

		if (StringUtils.isNotEmpty(reg)) {
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
		}

		sb.append(">\r\n");
		if("N".equals(defaultval)){
			sb.append("\t\t<option value=\"\">"+firstLabel+"</option>\r\n");
		}
		return sb;
	}

	private StringBuilder getOption(Staff staff, StringBuilder sb) {
		if (staff.getStaffCode().equals(value)) {
			flag = true;
			sb.append("\t\t<option title=\""+ staff.getName() + "\" value=\"" + staff.getStaffCode() + "\" selected>" + staff.getName() + "</option>\r\n");
		} else{
			sb.append("\t\t<option title=\""+ staff.getName() + "\" value=\"" + staff.getStaffCode() + "\">" + staff.getName() + "</option>\r\n");
		}
		return sb;
	}

	/**
	 * 判断select的title是显示默认值还是已给出的值
	 * @param value
	 * @return
	 */
	private String showTitle(String value) {
		Staff staff = mdmStaffService.getStaff(value);
		if(ObjectUtil.isNotEmpty(staff)) {
			return " title=\""+ staff.getName() + "\"";
		} else {
			return" title=\""+ firstLabel + "\"";
		}
	}

	private List<Staff> getStaffs(Criteria criteria) {
		List<Staff> list = new ArrayList<Staff>();
		try {
			list = mdmStaffService.getAllStaffs(criteria);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
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

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
