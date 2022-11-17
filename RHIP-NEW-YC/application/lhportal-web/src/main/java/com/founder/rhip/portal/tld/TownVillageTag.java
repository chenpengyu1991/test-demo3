package com.founder.rhip.portal.tld;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.mdm.app.IDictionaryApp;
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
	
	@Autowired
	private IDictionaryApp dictionaryApp;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		//获取所有的镇
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
		int random = (int)(Math.random() * 100000);
		StringBuilder html = getSelectBefore(this.townId, townName, "townId"+random, random,false);

		for (DicItem item : dicItems) {
			html.append(getOption(item));
		}
		html.append("</select>");
		if( StringUtils.isNotEmpty(this.villageName)) {
			boolean villageDisplay = StringUtils.isNotEmpty(this.villageValue) ? false : true;
			html.append(getSelectBefore(this.villageId, this.villageName, "villageId"+random, random,villageDisplay));
			if(StringUtils.isNotEmpty(this.townValue)) {
				html.append(this.getVillage(this.townValue));
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

	private StringBuilder getSelectBefore(String id, String name,String idd, int random, boolean display) {//onchange
		StringBuilder sb = new StringBuilder("<select");
		if(StringUtils.contains(idd, "town") && StringUtils.isNotEmpty(this.villageName)){
			if(StringUtil.isNotEmpty(this.callback)){
				sb.append(" onchange=\"getVillageOpting('"+random+"','','','"+this.callback+"')\"");
			}else{
				sb.append(" onchange=\"getVillageOpting('"+random+"','','')\"");
			}
		} 
		
		if (StringUtils.contains(idd, "town")){
			sb.append(showTitle(townValue));
		}
		
		if (StringUtils.contains(idd, "village")) {
			sb.append(showTitle(townValue));
		}
		
		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		
		if (StringUtils.isNotEmpty(idd)) {
			sb.append(" idd=\"" + idd + "\"");
		}
		
		sb.append(" name=\"" + name + "\"");
		
		if (StringUtils.isNotEmpty(reg)) {
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
		}
		
		/*if (display && StringUtils.isNotEmpty(width)) {
			sb.append("style=\"display:none;width:" + width + ";\"");
		} else if(!display && StringUtils.isNotEmpty(width)) {*/
			sb.append("style=\"width:" + width + ";\"");
		/*} else if (display) {
			sb.append("style=\"display:none;\"");
		}*/
		
		sb.append(">\r\n");
		sb.append("\t\t<option value=\"\">"+firstLabel+"</option>\r\n");
		return sb;
	}
	
	private String getOption(DicItem item) {//getVillageOpting()
		if (item.getItemCode().equals(townValue)) {
			return "<option title=\""+ item.getItemName() + "\"  value=\"" + item.getItemCode() + "\" selected>" + item.getItemName() + "</option>\r\n";
		} else{
			return "<option title=\""+ item.getItemName() + "\"  value=\"" + item.getItemCode() + "\">" + item.getItemName() + "</option>\r\n";
		}
	}
	
	private StringBuffer getVillage(String parentCode){
		 List<DicItem> villages = dictionaryApp.queryDicItems("FS990001", parentCode);
		 StringBuffer buffer = new StringBuffer();
		 for(DicItem item: villages) {
			 buffer.append("<option title=\""+ item.getItemName() + "\"  value='"+ item.getItemCode() + "'");
			 if(item.getItemCode().equals(villageValue)) buffer.append(" selected");
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
}
