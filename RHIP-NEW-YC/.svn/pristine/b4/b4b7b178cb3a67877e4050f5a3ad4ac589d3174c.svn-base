package com.founder.rhip.ehr.tld;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.cache.DictionaryCache;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;

/**
 * 给出字典中相应code值 显示其中文名称
 * @author Jiang Haiying
 *
 */
public class DictionaryTag extends BaseTag {

	private static final long serialVersionUID = 4697185718254037665L;
	// attribute
	private String dicmeta = null;
	private String code = null;
	private List<DicItem> items;
	private boolean isExterItems = false;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	public int doStartTagInternal() throws JspTagException {
		String name = null;
		if (isExterItems && items != null) {
			for (DicItem item : items) {
				if (code.equals(item.getItemCode())) {
					name = item.getItemName();
					break;
				}
			}
		} else {
			String key = dicmeta + "|" + code;
			if (DictionaryCache.dicMap.containsKey(key)) {
				name = DictionaryCache.dicMap.get(key);
			} else {
				inject();
				name=this.getName(name, key);
			}
		}
		try {
			JspWriter jw = pageContext.getOut();
			if (name != null) {
				jw.write(name);
			}
		} catch (IOException e) {
			e.printStackTrace();
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

	public String getDicmeta() {
		return dicmeta;
	}

	public void setDicmeta(String dicmeta) {
		this.dicmeta = dicmeta;
	}

	public List<DicItem> getItems() {
		return items;
	}

	public void setItems(List<DicItem> items) {
		this.items = items;
		isExterItems = true;
	}
	
	private String getName(String name, String key) {
		if(StringUtil.isNotEmpty(code)) {
			String codes[] = code.split(",");
			StringBuffer str = new StringBuffer();
			for(String temp: codes) {
				DicItem item = dictionaryApp.queryDicItem(dicmeta, temp);
				if(ObjectUtil.isNotEmpty(item)) {
					str.append(item.getItemName() + ",");
				} else if (ObjectUtil.isNotEmpty(item) && !code.contains(",")) {
					return item.getItemName();
				}
			}
			if (StringUtils.isNotBlank(str.toString())) {
    			name = str.toString().substring(0, str.length()-1);
    			DictionaryCache.dicMap.put(key, name);
    		}
		}
		return name;
	}
}
