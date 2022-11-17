package com.founder.rhip.portal.tld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;

/**
 * 字典数据以Radio形式展现
 * 
 * @author Jiang Haiying
 * 
 */
public class DictionaryRadioTag extends BaseTag {

	private static final long serialVersionUID = 660059466296981149L;

	// attribute
	private String id = null;
	private String name = null;
	private String dicmeta = null;
	private String value = null;
	private String code = null;
	private String reg = null;
	private String isDefault = "N";
	private String firstLabel = "全部";
	private String uninclude = null;
	private String onchange = null;
	private String hideCodes = null;
	private Set<String> hideCodeSet = null;
	private String disabled = null;
	
	@Autowired
	private IDictionaryApp dictionaryApp;

	public int doStartTagInternal() throws JspTagException {
		inject();
		List<DicItem> list = this.getDicItems();
		String html = null;
		StringBuilder sb = new StringBuilder();
		String[] codeArray = null;
		if (StringUtils.isNotEmpty(this.code) && code.contains("-1")) {
			codeArray = code.split(",");
		}
		if (ObjectUtil.isNotEmpty(list)) {
			if ("Y".equals(isDefault) && (StringUtils.isEmpty(this.code) || !code.contains("-1"))) {
				this.appendDefault(sb);
			}
			int i = 0;
			for (DicItem dic : list) {
				if (ObjectUtil.isNotEmpty(codeArray) && StringUtils.equals(codeArray[i], "-1")) {
					this.appendDefault(sb);
				}
				this.getRadio(dic, sb);
				i++;
			}
			if (ObjectUtil.isNotEmpty(codeArray) && StringUtils.equals(codeArray[i], "-1")) {
				this.appendDefault(sb);
			}
		}
		html = sb.toString();
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	/**
	 * 获取默认值
	 * 
	 * @param sb
	 */
	private void appendDefault(StringBuilder sb) {
		DicItem dic = new DicItem();
		dic.setItemCode("");
		dic.setItemName(firstLabel);
		this.getRadio(dic, sb);
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

	public String getDicmeta() {
		return dicmeta;
	}

	public void setDicmeta(String dicmeta) {
		this.dicmeta = dicmeta;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getReg() {
		return reg;
	}

	public String getUninclude() {
		return uninclude;
	}

	public void setUninclude(String uninclude) {
		this.uninclude = uninclude;
	}

	public String getOnchange() {
		return onchange;
	}

	public void setOnchange(String onchange) {
		this.onchange = onchange;
	}
	
	public String getDisabled() {
		return disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	private List<DicItem> getDicItems() {
		List<DicItem> temp = dictionaryApp.queryDicItem(dicmeta);// WebCache.dicItemList.get(dicmeta);
		List<DicItem> list = new ArrayList<DicItem>();

		if (StringUtils.isNotEmpty(this.code) && StringUtils.isNotEmpty(this.uninclude)) {
			return temp;
		}
		if (StringUtils.isNotEmpty(this.code)) {
			list = this.getIncludeDicItems(temp);
		} else if (StringUtils.isNotEmpty(this.uninclude)) {
			list = this.getUnincludeDicItems(temp);
		} else {
			return temp;
		}
		return list;
	}

	/**
	 * 根据code获取code所包含的数据
	 * 
	 * @return
	 */
	private List<DicItem> getIncludeDicItems(List<DicItem> temp) {
		List<DicItem> list = new ArrayList<DicItem>();
		String[] codes = this.code.split(",");
		for (String code : codes) {
			for (DicItem item : temp) {
				if (StringUtils.equals(code, item.getItemCode())) {
					list.add(item);
					break;
				}
			}
		}
		return list;
	}

	/**
	 * 根据uninclude排除其包含的数据
	 * 
	 * @return
	 */
	private List<DicItem> getUnincludeDicItems(List<DicItem> temp) {
		List<DicItem> list = new ArrayList<DicItem>();
		list.addAll(temp);
		String[] unincludes = this.uninclude.split(",");
		for (String code : unincludes) {
			for (DicItem item : temp) {
				if (StringUtils.equals(code, item.getItemCode())) {
					list.remove(item);
					break;
				}
			}
		}
		return list;
	}

	private StringBuilder getRadio(DicItem dic, StringBuilder sb) {
		String dicCode = dic.getItemCode();
		boolean show = true;
		if (null != hideCodeSet && hideCodeSet.contains(dicCode)) {
			show = false;
		}
		sb.append("<label ");
		if (!show) {
			sb.append("style='display:none'");
		}
		sb.append("><input type=\"radio\"");

		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		
		if(StringUtils.isNotEmpty(disabled)) {
			sb.append(" disabled=\"disabled\"");
		}
		sb.append(" name=\"" + name + "\"");
		sb.append(" class=\"radioGroup\"");

		if (StringUtils.isNotEmpty(onchange)) {
			sb.append(" onchange=\"" + onchange + "\"");
		}

		if (StringUtils.isNotEmpty(reg)) {
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
			this.setReg(null);
		}

		sb.append("onclick=\"this.blur()\"");

		if (dic.getItemCode().equals(value)) {
			sb.append(" value=\"" + dic.getItemCode() + "\"  data-label=\"" + dic.getItemName() + "\" checked=\"checked\">" + "</input>");
		} else {
			sb.append(" value=\"" + dic.getItemCode() + "\"  data-label=\"" + dic.getItemName() + "\" >" + "</input>");
		}
		sb.append("" + dic.getItemName() + "</label>");
		return sb;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getFirstLabel() {
		return firstLabel;
	}

	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}

	public String getHideCodes() {
		return hideCodes;
	}

	public void setHideCodes(String hideCodes) {
		this.hideCodes = hideCodes;
		if (ObjectUtil.isNotEmpty(hideCodes)) {
			String[] array = hideCodes.split(",");
			this.hideCodeSet = new HashSet<>(array.length);
			for (String string : array) {
				hideCodeSet.add(string);
			}
		}
	}

}
