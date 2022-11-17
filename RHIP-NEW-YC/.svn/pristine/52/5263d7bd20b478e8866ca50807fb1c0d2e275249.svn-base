package com.founder.rhip.ehr.tld;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;

public class DicCascadedListTag extends BaseTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// attribute
	private String firstLabel = "请选择";
	private String width = null;

	// private int level;
	private String dicmetaFirst = null;
	private String dicmetaSec = null;

	private String firstId = null;
	private String secId = null;
	private String firstName = null;
	private String secName = null;
	private String firstValue;
	private String secValue;
	private String reg = null;// 验证规则
	private String callback;// 回调函数
	@Autowired
	private IDictionaryApp dictionaryApp;

	public int doStartTagInternal() throws JspTagException {
		inject();
		// 获取所有的父选项
		Criteria criteria = new Criteria("dic_code", dicmetaFirst);
		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
		int random = (int) (Math.random() * 100000);
		StringBuilder html = getSelectBefore(firstId, firstName, random);

		for (DicItem item : dicItems) {
			html.append(getOption(item));
		}
		html.append("</select>");
		if (StringUtils.isNotEmpty(secName)) {
			html.append(getSelectBefore(secId, secName, random));
			if (StringUtils.isNotEmpty(this.firstValue)) {
				html.append(this.getVillage(this.firstValue));
			}
			html.append("</select>");
		}
		JspWriter jw = pageContext.getOut();
		try {
			jw.write(html.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private StringBuilder getSelectBefore(String id, String name, int random) {// onchange
		StringBuilder sb = new StringBuilder("<select");
		if (firstName.equals(name)) {
			if (StringUtil.isNotEmpty(this.callback)) {
//				sb.append(" onchange=\"getCascadedOpting('" + name + random
//						+ "','"+ secName + random+"','','" + this.callback + "','" + dicmetaSec
//						+ "')\"");
				sb.append(" onchange=\"getCascadedOpting('" + name + random
						+ "','"+ secName + random+"','','" + this.callback + "','" + dicmetaSec
						+ "')\"");
			} else {
//				sb.append(" onchange=\"getCascadedOpting('" + random
//						+ "','','','','" + dicmetaSec + "')\"");
				sb.append(" onchange=\"getCascadedOpting('" + name + random
						+ "','"+secName+random+"','','" + dicmetaSec + "')\"");
			}
		}

		if (firstName.equals(name)) {
			sb.append(showTitle(firstValue));
		}

		if (secName.equals(name)) {
			sb.append(showTitle(firstValue));
		}

		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		sb.append(" idd=\"" + name + random + "\"");
		sb.append(" name=\"" + name + "\"");

		if (StringUtils.isNotEmpty(reg)) {
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
		}
		sb.append("style=\"width:" + width + ";\"");
		sb.append(">\r\n");
		sb.append("\t\t<option value=\"\">" + firstLabel + "</option>\r\n");
		return sb;
	}

	private String getOption(DicItem item) {// getCascadedOpting()
		if (item.getItemCode().equals(firstValue)) {
			return "<option title=\"" + item.getItemName() + "\"  value=\""
					+ item.getItemCode() + "\" selected>" + item.getItemName()
					+ "</option>\r\n";
		} else {
			return "<option title=\"" + item.getItemName() + "\"  value=\""
					+ item.getItemCode() + "\">" + item.getItemName()
					+ "</option>\r\n";
		}
	}

	private StringBuffer getVillage(String parentCode) {
		List<DicItem> villages = dictionaryApp.queryDicItems(dicmetaSec,
				parentCode);
		StringBuffer buffer = new StringBuffer();
		for (DicItem item : villages) {
			buffer.append("<option title=\"" + item.getItemName()
					+ "\"  value='" + item.getItemCode() + "'");
			if (item.getItemCode().equals(secValue))
				buffer.append(" selected");
			buffer.append(">" + item.getItemName() + "</option>");
		}
		return buffer;
	}

	/**
	 * 判断select的title是显示默认值还是已给出的值
	 * 
	 * @param value
	 * @return
	 */
	private String showTitle(String value) {
		if (ObjectUtil.isNotEmpty(value)) {
			return " title=\""
					+ dictionaryApp.queryDicItemName("FS990001", value) + "\"";
		} else {
			return " title=\"" + firstLabel + "\"";
		}
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
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

	public String getCallback() {
		return callback;
	}

	public void setCallback(String callback) {
		this.callback = callback;
	}

	public String getDicmetaFirst() {
		return dicmetaFirst;
	}

	public void setDicmetaFirst(String dicmetaFirst) {
		this.dicmetaFirst = dicmetaFirst;
	}

	public String getDicmetaSec() {
		return dicmetaSec;
	}

	public void setDicmetaSec(String dicmetaSec) {
		this.dicmetaSec = dicmetaSec;
	}

	public IDictionaryApp getDictionaryApp() {
		return dictionaryApp;
	}

	public void setDictionaryApp(IDictionaryApp dictionaryApp) {
		this.dictionaryApp = dictionaryApp;
	}

	public String getFirstId() {
		return firstId;
	}

	public void setFirstId(String firstId) {
		this.firstId = firstId;
	}

	public String getSecId() {
		return secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecName() {
		return secName;
	}

	public void setSecName(String secName) {
		this.secName = secName;
	}

	public String getFirstValue() {
		return firstValue;
	}

	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}

	public String getSecValue() {
		return secValue;
	}

	public void setSecValue(String secValue) {
		this.secValue = secValue;
	}

}
