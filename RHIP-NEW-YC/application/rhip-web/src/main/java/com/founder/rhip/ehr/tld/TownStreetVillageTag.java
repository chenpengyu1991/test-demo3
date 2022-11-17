package com.founder.rhip.ehr.tld;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.List;

/**
 * 区 街道 居委会 级联下拉列表
 * 
 * @author Jiang Haiying
 * 
 */
public class TownStreetVillageTag extends BaseTag {

	private static final long serialVersionUID = 4064993671438497188L;

	private String townId = null;
	private String streetId = null;
	private String villageId = null;
	private String townName = null;
	private String streetName = null;
	private String villageName = null;
	private String townValue;
	private String streetValue =null;
	private String villageValue;
	private String firstLabel = "请选择";
	private String width = null;
	private String reg = null;//验证规则
	private String callback;//回调函数
	private String defaultval = "N";
	private String cssClass = null;

	/*为零表示镇或者行政村无变化 1表示镇或者行政村状态为-1 或者关系发生变化
	状态是1 此时的下拉列表都是不可选的 保持以往的中心站关心*/
	private Integer mergeType = 1;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		//this.judgeMergeType();
		int random = (int) (Math.random() * 100000);
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
		StringBuilder html = getSelectBefore(this.townId, townName, "townId" + random, random, false, this.cssClass);

		DicItem town = dictionaryApp.queryDicItem("FS990001", this.townValue);
		if(ObjectUtil.isNotEmpty(town) && (town.getStatus() == StatusValue.deleteValue.getValue())) {
			html.append(getOption(town));
		} else {
			for (DicItem item : dicItems) {
				html.append(getOption(item));
			}
		}

		html.append("</select>");
		getChildrenSelect(html, random, this.cssClass);

		JspWriter jw = pageContext.getOut();
		try {
			jw.write(html.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	private StringBuilder getChildrenSelect(StringBuilder html, int random, String cssClass) {
		// 生成街道
		// 若villageValue不为空 则直接显示站的下拉列表
		//boolean streetDisplay = StringUtils.isNotEmpty(this.streetValue) ? false : true;
		html.append(getSelectBefore(this.streetId, this.streetName, "streetId" + random, random, false, cssClass));
		if (StringUtils.isNotEmpty(this.townValue)) {
			html.append(this.getChildOption(this.townValue, this.streetValue));
		}
		html.append("</select>");
		//若villageName为空则不显示站级别的数据  
		// 若villageValue不为空 则直接显示居委会的下拉列表
		if(ObjectUtil.isNotEmpty(this.villageName)) {
			//boolean villageDisplay = StringUtils.isNotEmpty(this.villageValue) ? false : true;
			html.append(getSelectBefore(this.villageId, this.villageName, "villageId" + random, random, false, cssClass));
			if (StringUtils.isNotEmpty(this.streetValue)) {
				html.append(this.getChildOption(this.streetValue, this.villageValue));
			}
			html.append("</select>");
		}
		return html;
	}

	private StringBuilder getSelectBefore(String id, String name, String idd, int random, boolean display, String cssClass) {// onchange
		StringBuilder sb = new StringBuilder("<select");
		if (StringUtils.contains(idd, "town")) {
			sb.append(showTitleItem(townValue));
			// Kevin Ro 修改
			if("Y".equals(defaultval)) {
				sb.append(" onchange=\"orgUtil.getStreetOpting('"+random+"','','"+this.callback+"','childDeath')\"");
			} else {
				sb.append(" onchange=\"orgUtil.getStreetOpting('"+random+"','','"+this.callback+"','')\"");
			}
		}
		//若villageName为空则不显示居委会级别的数据  onchange中第一个参数为空是为js处理方便
		if (StringUtils.contains(idd, "street") && ObjectUtil.isNotEmpty(this.villageName)) {
			sb.append(showTitleItem(streetValue));
			sb.append(" onchange=\"orgUtil.getVillageOpting('"+random+"','','"+this.callback+"')\"");
		}
		
		if (StringUtils.contains(idd, "village") && ObjectUtil.isNotEmpty(this.villageName)) {
			sb.append(showTitleItem(villageValue));
		}
		
		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}

		if (StringUtils.isNotEmpty(idd)) {
			sb.append(" idd=\"" + idd + "\"");
		}

		sb.append(" name=\"" + name + "\"");
		
		if (StringUtils.isNotEmpty(cssClass)) {
			sb.append(" class=\"" + cssClass + "\"");
		}
		
		if (StringUtils.isNotEmpty(reg)&&!StringUtils.contains(name,"Group")) {//地址中村小组不必填，不支持reg属性
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
		}
		if(mergeType == -1) {
			sb.append(" disabled=\"disabled\"");
		}
		if (display && StringUtils.isNotEmpty(width)) {
			sb.append("style=\"display:none;width:" + width + ";\"");
		} else if(!display && StringUtils.isNotEmpty(width)) {
			sb.append("style=\"width:" + width + ";\"");
		} else if (display) {
			sb.append("style=\"display:none;\"");
		}
		
		sb.append(">\r\n");
		if("N".equals(defaultval)){
			sb.append("\t\t<option title=\""+ firstLabel + "\"  value=\"\">" + firstLabel + "</option>\r\n");
		} 
		// kevin ro add
		if("Y".equals(defaultval)){
			sb.append("\t\t<option title=\""+ firstLabel + "\"  value=\"\">" + firstLabel + "</option>\r\n");
		} 
		return sb;
	}

	private String getOption(DicItem item) {//
		if (item.getItemCode().equals(townValue)) {
			return "<option title=\""+ item.getItemName() + "\" value=\"" + item.getItemCode() + "\" selected =\"selected\">" + item.getItemName() + "</option>\r\n";
		} else {
			return "<option title=\""+ item.getItemName() + "\" value=\"" + item.getItemCode() + "\">" + item.getItemName() + "</option>\r\n";
		}
	}

	private StringBuffer getChildOption(String parentCode, String selectValue) {
		List<DicItem> villages = dictionaryApp.queryDicItems("FS990001", parentCode);
		StringBuffer buffer = new StringBuffer();

		if (null != villages) {
			for (DicItem village : villages) {
				buffer.append("<option title=\""+ village.getItemName() + "\" value='" + village.getItemCode() + "'");
				if (village.getItemCode().equals(selectValue)) {
					buffer.append(" selected =\"selected\"");
				}
				buffer.append(">" + village.getItemName() + "</option>");
			}
		}
		return buffer;
	}
	
	/**
	 * 判断select的title是显示默认值还是已给出的值
	 * @param value
	 * @return
	 */
	private String showTitleItem(String value) {
		if(ObjectUtil.isNotEmpty(value)) {
			return " title=\""+ dictionaryApp.queryDicItemName("FS990001", value) + "\"";
		} else {
			return" title=\""+ firstLabel + "\"";
		}
	}

	/**
	 * 为零表示镇或者行政村无变化 1表示镇或者行政村状态为-1 或者关系发生变化
	 状态是1 此时的下拉列表都是不可选的 保持以往的中心站关心
	 */
	private void judgeMergeType() {
		DicItem town = dictionaryApp.queryDicItem("FS990001", this.townValue);
		DicItem street = dictionaryApp.queryDicItem("FS990001", this.streetValue);
		DicItem village = dictionaryApp.queryDicItem("FS990001", this.villageValue);
		if(ObjectUtil.isNotEmpty(town) && (town.getStatus() == StatusValue.deleteValue.getValue())) {
			mergeType = -1;
		} else if((ObjectUtil.isNotEmpty(street)&&
				(!StringUtils.equals(street.getParentCode(), this.townValue)|| street.getStatus() == StatusValue.deleteValue.getValue()))
				|| (ObjectUtil.isNotEmpty(village)&&
				(!StringUtils.equals(village.getParentCode(), this.streetValue)|| village.getStatus() == StatusValue.deleteValue.getValue()))) {
			mergeType = -1;
		}
	}


	/**
	 * 获取行政区划的下拉列表
	 * @return
	 */
	private StringBuilder getAdministrationTownSelect(int random) {
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
		StringBuilder html = getSelectBefore(this.townId, townName, "townsId" + random, random, false, this.cssClass);
		for(DicItem item : dicItems) {
			html.append(getOption(item));
		}
		return html;
	}

	public String getTownId() {
		return townId;
	}

	public void setTownId(String townId) {
		this.townId = townId;
	}

	public String getStreetId() {
		return streetId;
	}

	public void setStreetId(String streetId) {
		this.streetId = streetId;
	}

	public String getVillageId() {
		return villageId;
	}

	public void setVillageId(String villageId) {
		this.villageId = villageId;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getTownValue() {
		return townValue;
	}

	public void setTownValue(String townValue) {
		this.townValue = townValue;
	}

	public String getStreetValue() {
		return streetValue;
	}

	public void setStreetValue(String streetValue) {
		this.streetValue = streetValue;
	}

	public String getVillageValue() {
		return villageValue;
	}

	public void setVillageValue(String villageValue) {
		this.villageValue = villageValue;
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

	public String getDefaultval() {
		return defaultval;
	}

	public void setDefaultval(String defaultval) {
		this.defaultval = defaultval;
	}

	public Integer getMergeType() {
		return mergeType;
	}

	public void setMergeType(Integer mergeType) {
		this.mergeType = mergeType;
	}

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	
}
