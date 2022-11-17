package com.founder.rhip.portal.tld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;

/**
 * 字典数据以下拉列表形式展现
 * @author Jiang Haiying
 *
 */
public class DictionaryListTag extends BaseTag {

	private static final long serialVersionUID = -789945210773001174L;

	// attribute
	private String id = null;
	private String name = null;
	private String dicmeta = null;
	private String value = null;
	private String defaultval = "N";
	private String firstLabel = "请选择";
	private boolean type = false;//若为true说明是复选
	private String width = null;
	private String code = null;
	private String reg = null;//验证规则
	private String uninclude = null;
	private String onchange = null;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		List<DicItem> list = this.getDicItems();
		String html = null;
		String key = id + "|" + name + "|" + dicmeta + "|" + value + "|" + width + "|"+ defaultval + "|" + code+"|"+reg + "|" + uninclude + "|" + onchange;
		if (DictionaryCache.dicListMap.containsKey(key)) {
			html = DictionaryCache.dicListMap.get(key);
		} else {
			StringBuilder sb = this.getSelectBefore();
			
			if(ObjectUtil.isNotEmpty(list)) {
				if (type && StringUtils.isNotEmpty(value)) {
					for (DicItem dic : list) {
						sb = this.getMultipleOption(dic, sb);
					}
				} else {
					for (DicItem dic : list) {
						sb = this.getOption(dic, sb);
					}
				}
			}
			
			sb.append("</select>");
			html = sb.toString();
			DictionaryCache.dicListMap.put(key, html);
		}
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

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}
	
	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

    private List<DicItem> getDicItems() {
		List<DicItem> temp = dictionaryApp.queryDicItem(dicmeta);// WebCache.dicItemList.get(dicmeta);
		List<DicItem> list = new ArrayList<DicItem>();
	
		if(StringUtils.isNotEmpty(this.code) && StringUtils.isNotEmpty(this.uninclude)) {
			return temp;
		}
		if(StringUtils.isNotEmpty(this.code)) {
			list = this.getIncludeDicItems(temp);
		} else if(StringUtils.isNotEmpty(this.uninclude)) {
			list = this.getUnincludeDicItems(temp);
		} else {
			return temp;
		}
		return list;
	}
	
	/**
	 * 根据code获取code所包含的数据
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
	
	private StringBuilder getSelectBefore () {
		StringBuilder sb = new StringBuilder("<select");
		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		sb.append(" name=\"" + name + "\"");
		if (type) {
			sb.append(" multiple=\"multiple \"");
		}
		if (StringUtils.isNotEmpty(width)) {
			sb.append("style=\"width:"+ width + ";\"");
		}
		
		if (StringUtils.isNotEmpty(reg)) {
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
		}

        if (StringUtils.isNotEmpty(onchange)) {
            sb.append(" onchange=\"" + onchange + "\"");
        }

//        sb.append("onclick=\"this.blur()\"");
		
		sb.append(">\r\n");
		if("N".equals(defaultval) && !type){
			sb.append("\t\t<option value=\"\">"+firstLabel+"</option>\r\n");
		}	
		return sb;
	}
	
	private StringBuilder getMultipleOption(DicItem dic, StringBuilder sb) {
		String values[] = value.split(",");
		boolean flag = true;
		for(String temp: values) {
			if (dic.getItemCode().equals(temp)) {
				sb.append("\t\t<option value=\"" + dic.getItemCode() + "\" selected>" + dic.getItemName() + "</option>\r\n");
				flag = false;
				break;
			}
		}
		if (flag){
			sb.append("\t\t<option value=\"" + dic.getItemCode() + "\">" + dic.getItemName() + "</option>\r\n");
		}
		return sb;
	}
	private StringBuilder getOption(DicItem dic, StringBuilder sb) {
		if (dic.getItemCode().equals(value)) {
			sb.append("\t\t<option value=\"" + dic.getItemCode() + "\" selected>" + dic.getItemName() + "</option>\r\n");
		} else{
			sb.append("\t\t<option value=\"" + dic.getItemCode() + "\">" + dic.getItemName() + "</option>\r\n");
		}
		return sb;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}
}
