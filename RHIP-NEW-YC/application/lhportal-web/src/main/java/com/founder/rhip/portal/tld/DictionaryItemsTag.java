package com.founder.rhip.portal.tld;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.service.IDictionaryService;

public class DictionaryItemsTag extends BaseTag {

	private static final long serialVersionUID = 9019982971572640214L;

	@Autowired
	private IDictionaryService mdmDictionaryService;
	
	private String dicmeta;
	
	private String parentcode;
	
	private String value;
	
	private List<DicItem> items;
	
	private boolean isExterItems = false;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		if (!isExterItems) {
			Criteria criteria = new Criteria();
			criteria.add(Dictionary.STATUS, StatusValue.normalValue.getValue());
			if (dicmeta != null) {
				criteria.add(Dictionary.DIC_CODE, dicmeta);
			} else {
				criteria.add(Dictionary.DIC_CODE, "dicmeta");
			}
			if (parentcode != null) {
				criteria.add(DicItem.PARENT_CODE, parentcode);
			}
			items = mdmDictionaryService.getDicItemsUseCache(criteria);
		}
		StringBuilder html = new StringBuilder();
		for (DicItem item : items) {
			html.append(getOption(item));
		}
		JspWriter jw = pageContext.getOut();
		try {
			jw.write(html.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	private String getOption(DicItem item) {
		if (item.getItemCode().equals(value)) {
			return "<option value=\"" + item.getItemCode() + "\" selected>" + item.getItemName() + "</option>\r\n";
		} else{
			return "<option value=\"" + item.getItemCode() + "\">" + item.getItemName() + "</option>\r\n";
		}
	}
	
	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public String getDicmeta() {
		return dicmeta;
	}

	public void setDicmeta(String dicmeta) {
		this.dicmeta = dicmeta;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}

	public List<DicItem> getItems() {
		return items;
	}

	public void setItems(List<DicItem> items) {
		this.items = items;
		isExterItems = true;
	}
}
