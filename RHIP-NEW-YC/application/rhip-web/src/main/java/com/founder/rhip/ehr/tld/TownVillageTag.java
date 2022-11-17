package com.founder.rhip.ehr.tld;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
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
 * 镇 村 级联下拉列表
 * @author Jiang Haiying
 *
 */
public class TownVillageTag extends BaseTag {

	private static final long serialVersionUID = 4064993671438497188L;

	private String townId = null;
	private String villageId = null;
	private String townName = null;
	private String villageName = null;
	private String townValue;
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
		this.judgeMergeType();
		//获取所有的镇
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
		int random = (int)(Math.random() * 100000);
		StringBuilder html = getSelectBefore(this.townId, townName, "townId"+random, random);

		DicItem town = dictionaryApp.queryDicItem("FS990001", this.townValue);
		if(ObjectUtil.isNotEmpty(town) && (town.getStatus() == StatusValue.deleteValue.getValue())) {
			html.append(getOption(town));
		} else {
			for (DicItem item : dicItems) {
				html.append(getOption(item));
			}
		}
		html.append("</select>");
		if(StringUtils.isNotEmpty(this.villageName)) {
			html.append(getSelectBefore(this.villageId, this.villageName, "villageId"+random, random));
			DicItem village = dictionaryApp.queryDicItem("FS990001", this.villageValue);
			//this.villageValue的数据状态变为-1或行政区划关系变化 为true
			boolean flag = ObjectUtil.isNotEmpty(village) 
					&& (!StringUtils.equals(village.getParentCode(), this.townValue) 
							|| village.getStatus() == StatusValue.deleteValue.getValue());
			
			if(!flag && StringUtils.isNotEmpty(this.townValue)) {
				html.append(this.getVillage(this.townValue));
			} else if (flag) {
				html.append("<option title=\""+ village.getItemName() + "\"  value='"+ village.getItemCode() + "'");
				 if(village.getItemCode().equals(villageValue)) {
					 html.append(" selected =\"selected\"");
				 }
				 html.append( ">"+ village.getItemName() + "</option>");
				 html.append(this.getVillage(this.townValue));
			}
			html.append("</select>");
		}
		mergeType = 1;
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

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public String getFirstLabel() {
		return firstLabel;
	}

	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}
	
	public String getTownValue() {
		return townValue;
	}

	public void setTownValue(String townValue) {
		this.townValue = townValue;
	}

	public String getVillageValue() {
		return villageValue;
	}

	public void setVillageValue(String villageValue) {
		this.villageValue = villageValue;
	}
	
	public String getWidth() {
		return width;
	}

	public String getTownId() {
		return townId;
	}


	public void setTownId(String townId) {
		this.townId = townId;
	}


	public String getVillageId() {
		return villageId;
	}


	public void setVillageId(String villageId) {
		this.villageId = villageId;
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
	

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	private StringBuilder getSelectBefore(String id, String name,String idd, int random) {//onchange
		StringBuilder sb = new StringBuilder("<select");
		if(StringUtils.contains(idd, "town") && StringUtils.isNotEmpty(this.villageName)){
			if(StringUtil.isNotEmpty(this.callback)){
				sb.append(" onchange=\"orgUtil.getVillageOpting('"+random+"','','"+this.callback+"','')\"");
			}else{
				sb.append(" onchange=\"orgUtil.getVillageOpting('"+random+"','','')\"");
			}
		} 
		
		if(StringUtils.contains(idd, "village")){
			sb.append(" onchange=\"showTitle('villageId"+random+"')\"");
		}
		
		if (StringUtils.contains(idd, "town")){
			sb.append(showTitle(townValue));
		}
		
		if (StringUtils.contains(idd, "village")) {
			sb.append(showTitle(villageValue));
		}
		
		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		
		if (StringUtils.isNotEmpty(idd)) {
			sb.append(" idd=\"" + idd + "\"");
		}
		
		if (StringUtils.isNotEmpty(cssClass)) {
			sb.append(" class=\"" + cssClass + "\"");
		}
		
		sb.append(" name=\"" + name + "\"");
		/*if(mergeType == -1) {
			sb.append(" disabled=\"disabled\"");
		}*/
		if (StringUtils.isNotEmpty(reg)) {
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
		}
		
		sb.append(" style=\"width:" + width + ";\"");
		
		sb.append(">\r\n");
		if("N".equals(defaultval)){
			sb.append("\t\t<option title=\""+ firstLabel + "\"  value=\"\">" + firstLabel + "</option>\r\n");
		}
		return sb;
	}
	
	private String getOption(DicItem item) {//getVillageOpting()
		if (item.getItemCode().equals(townValue)) {
			return "<option title=\""+ item.getItemName() + "\"  value=\"" + item.getItemCode() + "\" selected =\"selected\">" + item.getItemName() + "</option>\r\n";
		} else{
			return "<option title=\""+ item.getItemName() + "\"  value=\"" + item.getItemCode() + "\">" + item.getItemName() + "</option>\r\n";
		}
	}
	
	private StringBuffer getVillage(String parentCode){
		 List<DicItem> villages = dictionaryApp.queryDicItems("FS990001", parentCode);
		 StringBuffer buffer = new StringBuffer();
		 for(DicItem item: villages) {
			 buffer.append("<option title=\""+ item.getItemName() + "\"  value='"+ item.getItemCode() + "'");
			 if(item.getItemCode().equals(villageValue)) {
				 buffer.append(" selected =\"selected\"");
			 }
			 buffer.append( ">"+ item.getItemName() + "</option>");
		 }
		 return buffer;
	 }
	
	/**
	 * 判断select的title是显示默认值还是已给出的值
	 * @param value
	 * @return
	 */
	private String showTitle(String value) {
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
		DicItem village = dictionaryApp.queryDicItem("FS990001", this.villageValue);
		if(ObjectUtil.isNotEmpty(town) && (town.getStatus() == StatusValue.deleteValue.getValue())) {
			mergeType = -1;
		} else if(ObjectUtil.isNotEmpty(village) 
				&& (!StringUtils.equals(village.getParentCode(), this.townValue) 
						|| village.getStatus() == StatusValue.deleteValue.getValue())) {
			mergeType = -1;
		}
	}
}
