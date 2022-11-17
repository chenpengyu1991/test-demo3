package com.founder.rhip.portal.tld;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 镇 中心 站 等机构的级联下拉列表
 * 
 * @author Jiang Haiying
 * 
 */
public class TownCentreStationTag extends BaseTag {

	private static final long serialVersionUID = 4064993671438497188L;

	private String townId = null;
	private String centreId = null;
	private String stationId = null;
	private String townName = null;
	private String centreName = null;
	private String stationName = null;
	private String townValue;
	private String centreValue;
	private String stationValue;
	private String firstLabel = "请选择";
	private String width = null;
	private Boolean isShow = false;// 是否显示市级医院 默认不显示
	private Boolean isShowOther = false;//是否显示机构类型为R2的机构 默认不显示
	//根据属性isShowOneself判断是否显示在站级别显示所属中心的取值
	private boolean isShowOneself = false;
	
	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		//获取所有的镇
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
		
		int random = (int) (Math.random() * 100000);
		StringBuilder html = getSelectBefore(this.townId, townName, "townsId" + random, random, false);
		for (DicItem item : dicItems) {
			html.append(getOption(item));
		}
		if (isShow) {
			html.append(getOption(this.getDicItem("_hospital","市级医院")));
		}
		if(isShowOther) {
			html.append(getOption(this.getDicItem("_other","其它")));
		}
		html.append("</select>");
		getChildrenSelect(html, random);

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

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
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

	public String getCentreValue() {
		return centreValue;
	}

	public void setCentreValue(String centreValue) {
		this.centreValue = centreValue;
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

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getStationValue() {
		return stationValue;
	}

	public void setStationValue(String stationValue) {
		this.stationValue = stationValue;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public Boolean getIsShow() {
		return isShow;
	}

	public void setIsShow(Boolean isShow) {
		this.isShow = isShow;
	}

	public boolean getIsShowOneself() {
		return isShowOneself;
	}

	public void setIsShowOneself(boolean isShowOneself) {
		this.isShowOneself = isShowOneself;
	}

	private StringBuilder getChildrenSelect(StringBuilder html, int random) {
		// 生成中心
		// 若stationValue不为空 则直接显示站的下拉列表
		boolean centreDisplay = StringUtils.isNotEmpty(this.centreValue) ? false : true;
		html.append(getSelectBefore(this.centreId, this.centreName, "centreId" + random, random, centreDisplay));
		if (StringUtils.isNotEmpty(this.townValue)) {
			html.append(this.getCentre(this.townValue));
		}
		html.append("</select>");
		//若stationName为空则不显示站级别的数据  
		// 若stationValue不为空 则直接显示站的下拉列表
		if(ObjectUtil.isNotEmpty(this.stationName)) {
			boolean stationDisplay = StringUtils.isNotEmpty(this.stationValue) ? false : true;
			html.append(getSelectBefore(this.stationId, this.stationName, "stationId" + random, random, stationDisplay));
			if (StringUtils.isNotEmpty(this.centreValue)) {
				html.append(this.getStation(this.centreValue));
			}
			html.append("</select>");
		}
		return html;
	}

	private StringBuilder getSelectBefore(String id, String name, String idd, int random, boolean display) {// onchange
		StringBuilder sb = new StringBuilder("<select");
		if (StringUtils.contains(idd, "town")) {
			sb.append(showTitleItem(townValue));
			sb.append(" onchange=\"getCentreOpting(" + random + "," + isShowOneself + ")\"");
		}
		//若stationName为空则不显示站级别的数据  onchange中第一个参数为空是为js处理方便
		if (StringUtils.contains(idd, "centre") && ObjectUtil.isNullOrEmpty(this.stationName)) {
			sb.append(showTitleOrg(centreValue));
			sb.append(" onchange=\"getStationOpting('" + random + "_'," + isShowOneself + ")\"");
		} else if (StringUtils.contains(idd, "centre")){
			sb.append(showTitleOrg(centreValue));
			sb.append(" onchange=\"getStationOpting('" + random + "'," + isShowOneself + ")\"");
		}
		
		if (StringUtils.contains(idd, "station") && ObjectUtil.isNotEmpty(this.stationName)) {
			sb.append(showTitleOrg(stationValue));
		}
		
		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}

		if (StringUtils.isNotEmpty(idd)) {
			sb.append(" idd=\"" + idd + "\"");
		}

		sb.append(" name=\"" + name + "\"");
		
		if (display && StringUtils.isNotEmpty(width)) {
			sb.append("style=\"display:none;width:" + width + ";\"");
		} else if(!display && StringUtils.isNotEmpty(width)) {
			sb.append("style=\"width:" + width + ";\"");
		} else if (display) {
			sb.append("style=\"display:none;\"");
		}
		
		sb.append(">\r\n");
		sb.append("\t\t<option title=\""+ firstLabel + "\"  value=\"\">" + firstLabel + "</option>\r\n");
		return sb;
	}

	private String getOption(DicItem item) {// getCentreOpting()
		if (item.getItemCode().equals(townValue)) {
			return "<option title=\""+ item.getItemName() + "\" value=\"" + item.getItemCode() + "\" selected>" + item.getItemName() + "</option>\r\n";
		} else {
			return "<option title=\""+ item.getItemName() + "\" value=\"" + item.getItemCode() + "\">" + item.getItemName() + "</option>\r\n";
		}
	}

	private StringBuffer getCentre(String gbCode) {
		Criteria criteria = new Criteria();
		if(gbCode.equals("_hospital")){
			criteria.add("GENRE_CODE",OrgGenreCode.HOSPITAL.getValue());
		}else if(gbCode.equals("_other")){
			criteria.add("GENRE_CODE",OrgGenreCode.OTHER.getValue());
		}else{
			criteria = new Criteria("GB_CODE", gbCode);
			criteria.add("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
		}
		
		List<Organization> centres = organizationApp.queryOrganization(criteria);
		StringBuffer buffer = new StringBuffer();
		for (Organization org : centres) {
			buffer.append("<option title=\""+ org.getOrganName() + "\" value='" + org.getOrganCode() + "'");
			if (org.getOrganCode().equals(centreValue))
				buffer.append(" selected");
			buffer.append(">" + org.getOrganName() + "</option>");
		}
		return buffer;
	}

	private StringBuffer getStation(String supOrganCode) {
		List<Organization> stations = new ArrayList<Organization>();
		if(isShowOneself) {
			stations.add(organizationApp.queryOrgan(supOrganCode));
		}
		stations.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue())));
		StringBuffer buffer = new StringBuffer();
		if (null != stations) {
			for (Organization org : stations) {
				buffer.append("<option title=\""+ org.getOrganName() + "\" value='" + org.getOrganCode() + "'");
				if (org.getOrganCode().equals(this.stationValue))
					buffer.append(" selected");
				buffer.append(">" + org.getOrganName() + "</option>");
			}
		}
		return buffer;
	}

	private DicItem getDicItem(String code, String name) {
		DicItem item = new DicItem();
		item.setItemCode(code);
		item.setItemName(name);
		return item;
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
	 * 判断select的title是显示默认值还是已给出的值
	 * @param value
	 * @return
	 */
	private String showTitleOrg(String value) {
		if(ObjectUtil.isNotEmpty(value)) {
			return " title=\""+ organizationApp.queryOrganName(value) + "\"";
		} else {
			return" title=\""+ firstLabel + "\"";
		}
	}

	public Boolean getIsShowOther() {
		return isShowOther;
	}

	public void setIsShowOther(Boolean isShowOther) {
		this.isShowOther = isShowOther;
	}
	
}
