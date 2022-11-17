package com.founder.rhip.ehr.tld;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
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
	private String townValue="";
	private String centreValue="";
	private String stationValue="";
	private String firstLabel = "请选择";
	//此属性不建议使用用style属性代替
	private String width = null;
	private Boolean isShow = false;// 是否显示市级医院 默认不显示
	private Boolean isShowInfirmary = false;//是否显示医务室
	private Boolean isShowHealthOversight = false;//是否显示卫生监督检验(监测、检测)所(站)
	private Boolean isShowOther = false;//是否显示机构类型为R2的机构 默认不显示
	//根据属性isShowOneself判断是否显示在站级别显示所属中心的取值
	private boolean isShowOneself = false;
	private String reg = null;//验证规则
	/*为零表示机构无变化 1表示站的parent_code发生变化和表示此站的状态为-1
	状态是1 此时的下拉列表都是不可选的 保持以往的中心站关心*/
	private Integer mergeType = 1;

	private String defaultval = "N";

	private Boolean isAdministration = true;//默认显示行政区划的三级下拉列表 为false时显示机构区划的列表

	private boolean isAllTown = false;//默认只显示 金凤区 西夏区 兴庆区

	private String includeTownCodes = "";//第一级下拉列表包含的code

	private String style = null;

	private Order order = new Order("sort");
	
	private String cssClass = null;

    /*默认为true 根据患者所属的机构级别来定显示内容
    1.县区疾控、县区委计委显示三级没有任何限制
    3.中心、卫生院显示下属站 若是需要在下属站也显示此中心则需将属性isShowOneself设置为true
    4.站显示自己**/
    private boolean isAuthorize = true;

	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IDictionaryApp dictionaryApp;

	@Autowired
	private IOrganizationService mdmOrganizationService;

	public int doStartTagInternal() throws JspTagException {
		inject();
		StringBuilder html = new StringBuilder();
		//this.judgeMergeType();
		int random = (int) (Math.random() * 100000);
        CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) pageContext.getSession().getAttribute("currentLoginInfo");
        Organization currentOrg = currentLoginInfo.getOrganization();
		if(isAdministration) {
			html = this.getAdministrationTownSelect(random, currentOrg);
		} else {
			html = this.getOrganizationTownSelect(random, currentOrg);
		}
		if (isShow) {
			html.append(getOption(this.getDicItem("_hospital","综合医院")));
		}
		if (isShowInfirmary) {
			html.append(getOption(this.getDicItem(EHRConstants._INFIRMARY,"医务室")));
		}
		if (isShowHealthOversight) {
			html.append(getOption(this.getDicItem(EHRConstants._HEALTHOVERSIGHT,"卫生监督检验(监测、检测)所(站)")));
		}
		if(isShowOther) {
			html.append(getOption(this.getDicItem("_other","其它")));
		}
		html.append("</select>");
		getChildrenSelect(html, random, currentOrg);

		JspWriter jw = pageContext.getOut();
		this.mergeType = 1;
        townValue="";
        centreValue="";
        stationValue="";
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

	private StringBuilder getChildrenSelect(StringBuilder html, int random, Organization currentOrg) {
		if(ObjectUtil.isNotEmpty(this.centreName)) {
			// 生成中心
            boolean centreDisplay = true;
            //townValue和centreValue不为空但是登录单位需要为市疾控市卫计委（isAuthorize＝true）或者 isAuthorize为fasle
            if((StringUtils.isNotEmpty(this.townValue)||StringUtils.isNotEmpty(this.centreValue)) &&
                    ((isAuthorize && (ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue())||
                            ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.JK.getValue()))) || !isAuthorize)) {
                centreDisplay = false;
            }

            html.append(getSelectBefore(this.centreId, this.centreName, "centreId" + random, random, centreDisplay, this.cssClass));
            //登录的机构为站、医务室、卫生室只显示本机构
            if((isAuthorize && (ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.STATION.getValue())||
                    ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CLINIC.getValue())||
                    ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.INFIRMARY.getValue()))) &&
                    ObjectUtil.isNullOrEmpty(this.centreValue)) {
                this.centreValue = currentOrg.getParentCode();
            }
            if(StringUtils.isNotEmpty(this.townValue)) {
                String gbCode = this.townValue;
                if(StringUtils.isEmpty(gbCode)) {
                    if(isAdministration) {
                        gbCode = currentOrg.getGbCode();
                    } else {
                        gbCode = currentOrg.getOrganCode();
                    }
                }
                html.append(this.getCentre(gbCode, currentOrg));
            }
			html.append("</select>");
			//若stationName为空则不显示站级别的数据
			// 若stationValue不为空 则直接显示站的下拉列表
			if(ObjectUtil.isNotEmpty(this.stationName)) {
                //登录的机构为站、医务室、卫生室只显示本机构
                if((isAuthorize && (ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.STATION.getValue())||
                        ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CLINIC.getValue())||
                        ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.INFIRMARY.getValue())))) {
                    html.append(getSelectBefore(this.stationId, this.stationName, "stationId" + random, random, false, this.cssClass));
                    html.append("<option title=\""+ currentOrg.getOrganName() + "\" value='" + currentOrg.getOrganCode() + "' selected =\"selected\"");
                    html.append(">" + currentOrg.getOrganName() + "</option>");
                    html.append("</select>");
                    return html;
                }
                if((isAuthorize && (ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.JK.getValue())||
                        ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue())||
                        //ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.QJK.getValue())||
                        ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CENTRE.getValue())||
                        ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.INSTITUTES.getValue())))
                        || !isAuthorize) {
                    boolean isNotSecendSelect = isAuthorize && (ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CENTRE.getValue())||
                            ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.INSTITUTES.getValue()));
                    boolean stationDisplay = (StringUtils.isNotEmpty(this.centreValue)||StringUtils.isNotEmpty(this.stationValue) || isNotSecendSelect) ? false : true;
                    html.append(getSelectBefore(this.stationId, this.stationName, "stationId" + random, random, stationDisplay, cssClass));
                    if (StringUtils.isNotEmpty(this.centreValue) || isNotSecendSelect) {
                        String centreCode = this.centreValue;
                        if(StringUtil.isEmpty(centreCode)) {
                            centreCode = currentOrg.getOrganCode();
                        }
                        html.append(this.getStation(centreCode));
                    }
                }
			}

		}
		return html;
	}

	private StringBuilder getSelectBefore(String id, String name, String idd, int random, boolean display, String cssClass) {// onchange
		StringBuilder sb = new StringBuilder("<select");
		if (StringUtils.contains(idd, "town")) {
			sb.append(showTitleItem(townValue));
			sb.append(" onchange=\"orgUtil.getCentreOpting(" + random + "," + isShowOneself + "," + isAdministration + ")\"");
		}
		//若stationName为空则不显示站级别的数据  onchange中第一个参数为空是为js处理方便
		if (StringUtils.contains(idd, "centre") && ObjectUtil.isNullOrEmpty(this.stationName)) {
			sb.append(showTitleOrg(centreValue));
			sb.append(" onchange=\"orgUtil.getStationOpting('" + random + "_'," + isShowOneself + ")\"");
		} else if (StringUtils.contains(idd, "centre")){
			sb.append(showTitleOrg(centreValue));
			sb.append(" onchange=\"orgUtil.getStationOpting('" + random + "'," + isShowOneself + ")\"");
		}

		if (StringUtils.contains(idd, "station") && ObjectUtil.isNotEmpty(this.stationName)) {
			sb.append(showTitleOrg(stationValue));
		}

		if (StringUtils.isNotEmpty(id)) {
			sb.append(" id=\"" + id + "\"");
		}
		
		if (StringUtils.isNotEmpty(cssClass)) {
			sb.append(" class=\"" + cssClass + "\"");
		}

		if (StringUtils.isNotEmpty(idd)) {
			sb.append(" idd=\"" + idd + "\"");
		}

		sb.append(" name=\"" + name + "\"");

		if (StringUtils.isNotEmpty(reg)) {
			sb.append(" reg=\"" + reg.replaceAll("\"", "'") + "\"");
		}
		if(mergeType == -1) {
			sb.append(" disabled=\"disabled\"");
		}

		if (display && StringUtils.isNotEmpty(width)) {
			sb.append("style=\"display:none;width:" + width + ";\"");
		} else if(!display && StringUtils.isNotEmpty(width)) {
			sb.append("style=\"width:" + width + ";\"");
		}

		if (display && StringUtils.isNotEmpty(style)) {
			sb.append(" style=\"display:none;" + style + ";\"");
		} else if(!display && StringUtils.isNotEmpty(style)) {
			sb.append(" style=\"" + style + ";\"");
		} else if (display) {
			sb.append(" style=\"display:none;\"");
		}

		sb.append(">\r\n");
		if("N".equals(defaultval)){
			sb.append("\t\t<option title=\""+ firstLabel + "\"  value=\"\">" + firstLabel + "</option>\r\n");
		}

		return sb;
	}

	private String getOption(DicItem item) {// getCentreOpting()
		if (item.getItemCode().equals(townValue)) {
			return "<option title=\""+ item.getItemName() + "\" value=\"" + item.getItemCode() + "\" selected =\"selected\">" + item.getItemName() + "</option>\r\n";
		} else {
			return "<option title=\""+ item.getItemName() + "\" value=\"" + item.getItemCode() + "\">" + item.getItemName() + "</option>\r\n";
		}
	}

	private StringBuffer getCentre(String gbCode, Organization currentOrg) {
		Criteria criteria = new Criteria();
		if(gbCode.equals("_hospital")){
			criteria.add("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue());
		}else if(gbCode.equals("_other")){
			criteria.add("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.AREA_HEALTH.getValue(), OrgGenreCode.OTHER.getValue()});
		} else if(gbCode.equals(EHRConstants._INFIRMARY)) {
			criteria.add("GENRE_CODE", OrgGenreCode.INFIRMARY.getValue());
		} else if(gbCode.equals(EHRConstants._HEALTHOVERSIGHT)) {
			criteria.add("GENRE_CODE", OrgGenreCode.HEALTH_OVERSIGHT.getValue());
		} else{
			if(isAdministration) {
				criteria = new Criteria("GB_CODE", gbCode);
            } else {
                Organization orgParent = organizationApp.queryOrgan(gbCode);
                if(ObjectUtil.equals(OrgGenreCode.AREA_HEALTH.getValue(), orgParent.getGenreCode())) {
					criteria = new Criteria("parentCodeHealth", gbCode);
				} else {
					criteria = new Criteria("parentCode", gbCode);
				}
			}
            //中心和卫生院
            criteria.add("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.INSTITUTES.getValue()});
            //登录的机构为中心卫生院时隐藏二级下拉列表仅有当前登录机构
            if(isAuthorize && (
                    ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CENTRE.getValue())||
                    ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.INSTITUTES.getValue()))) {
                criteria.add("organ_code", currentOrg.getOrganCode());
                this.centreValue = currentOrg.getOrganCode();
            } else if(isAuthorize && (
                            ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.STATION.getValue())||
                            ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CLINIC.getValue())||
                            ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.INFIRMARY.getValue()))) {
                //登录的机构为站级别时隐藏二级下拉列表仅有当前登录机构的父类
                criteria.add("organ_code", currentOrg.getParentCode());
                this.centreValue = currentOrg.getParentCode();
            }
        }

		List<Organization> centres = organizationApp.queryOrganization(criteria, order);
		StringBuffer buffer = new StringBuffer();
		//若中心已不在该镇下 或此中心已不可用
		if (StringUtils.isNotEmpty(this.centreValue) && StringUtils.isEmpty(this.centreValue)) {
			Organization orgCentre = mdmOrganizationService.getOrganization(centreValue);
			if(ObjectUtil.isNotEmpty(orgCentre)
					&& (!StringUtils.equals(orgCentre.getGbCode(), this.townValue)
					|| orgCentre.getStatus() == StatusValue.deleteValue.getValue())) {
				buffer.append("<option title=\""+ orgCentre.getOrganName() + "\" value='" + orgCentre.getOrganCode() + "' selected =\"selected\"");
				buffer.append(">" + orgCentre.getOrganName() + "</option>");
				return buffer;
			}
		}
		for (Organization org : centres) {
			buffer.append("<option title=\""+ org.getOrganName() + "\" value='" + org.getOrganCode() + "'");
			if (org.getOrganCode().equals(centreValue)) {
				buffer.append(" selected =\"selected\"");
			}
			buffer.append(">" + org.getOrganName() + "</option>");
		}
		return buffer;
	}

	private StringBuffer getStation(String supOrganCode) {
		List<Organization> stations = new ArrayList<Organization>();
		if(isShowOneself) {
			stations.add(mdmOrganizationService.getOrganization(supOrganCode));
		}
		Criteria criteria = new Criteria(Organization.PARENT_CODE, supOrganCode);
		criteria.add("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.STATION.getValue(), OrgGenreCode.CLINIC.getValue()});
		stations.addAll(organizationApp.queryOrganization(criteria, order));
		StringBuffer buffer = new StringBuffer();

		//若站已不在该镇下 或此站已不可用
		Organization orgStation = mdmOrganizationService.getOrganization(this.stationValue);
		if(ObjectUtil.isNotEmpty(orgStation)
				&& (!StringUtils.equals(orgStation.getParentCode(), this.centreValue)
				|| orgStation.getStatus() == StatusValue.deleteValue.getValue())) {
			buffer.append("<option title=\""+ orgStation.getOrganName() + "\" value='" + orgStation.getOrganCode() + "' selected =\"selected\"");
			buffer.append(">" + orgStation.getOrganName() + "</option>");
			return buffer;
		}

		if (null != stations) {
			for (Organization org : stations) {
				buffer.append("<option title=\""+ org.getOrganName() + "\" value='" + org.getOrganCode() + "'");
				if (org.getOrganCode().equals(this.stationValue)) {
					buffer.append(" selected =\"selected\"");
				}
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

	/**
	 * 为1表示机构无变化 1表示站的parent_code发生变化和表示此站的状态为-1  状态是-1 此时的下拉列表都是不可选的 保持以往的中心站关心
	 * @return
	 */
	private void judgeMergeType() {
		if(StringUtils.equals(townValue, EHRConstants._HOSPITAL) ||StringUtils.equals(townValue, EHRConstants._CENTRE)||
				StringUtils.equals(townValue, EHRConstants._INFIRMARY) || StringUtils.equals(townValue, EHRConstants._HEALTHOVERSIGHT)){
			mergeType = 1;
			return;
		}
		Organization org = mdmOrganizationService.getOrganization(this.stationValue);
		if(ObjectUtil.isNotEmpty(org)
				&& (!StringUtils.equals(org.getParentCode(), this.centreValue)
				|| org.getStatus() == StatusValue.deleteValue.getValue())) {
			mergeType = -1;
		} else if (StringUtils.isNotEmpty(this.centreValue) && StringUtils.isEmpty(this.stationValue)) {
			Organization orgCentre = mdmOrganizationService.getOrganization(this.centreValue);
			if(ObjectUtil.isNotEmpty(orgCentre)
					&& (!StringUtils.equals(orgCentre.getGbCode(), this.townValue)
					|| orgCentre.getStatus() == StatusValue.deleteValue.getValue())) {
				mergeType = -1;
			}
		}
	}


	/**
	 * 获取行政区划的下拉列表
	 * @return
	 */
	private StringBuilder getAdministrationTownSelect(int random, Organization currentOrg ) {
		Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
		if(isAuthorize && !ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue()) &&
                !ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.JK.getValue()) &&
                !ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.HEALTH_OVERSIGHT.getValue()) &&
                ObjectUtil.isNullOrEmpty(includeTownCodes)) {
            criteria.add("item_code", currentOrg.getGbCode());
        }
        //市疾控看到的应该是所有的机构
		if(ObjectUtil.isNotEmpty(includeTownCodes)
				&& (!ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.JK.getValue()) &&
				ObjectUtil.equals(currentOrg.getGbCode(), includeTownCodes))) {
			criteria.add("item_code", OP.IN, includeTownCodes.split(","));
		}

		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
		boolean townDisplay = ((isAuthorize && (ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue())||
				ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.HEALTH_OVERSIGHT.getValue())||
                ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.JK.getValue()))) || !isAuthorize) ? false : true;
		StringBuilder html = getSelectBefore(this.townId, townName, "townsId" + random, random, townDisplay, this.cssClass);
        //若第一级隐藏那么默认选中本机构的所属区化
        if(townDisplay && ObjectUtil.isNullOrEmpty(this.townValue)) {
		    townValue = currentOrg.getGbCode();
        }
		for(DicItem item : dicItems) {
			html.append(getOption(item));
		}
		return html;
	}

	/**
	 * 获取机构区划的下拉列表
	 * @return
	 */
	private StringBuilder getOrganizationTownSelect(int random, Organization currentOrg ) {
		String genreCodes[] = new String[]{OrgGenreCode.JK.getValue(), OrgGenreCode.AREA_HEALTH.getValue()};
		Criteria criteria = new Criteria("genre_code", OP.IN, genreCodes);
		if(ObjectUtil.isNotEmpty(includeTownCodes)) {
			criteria = new Criteria(Organization.ORGAN_CODE, OP.IN, includeTownCodes.split(","));
		}
		List<Organization> organizations = organizationApp.queryOrganization(criteria, order);
        boolean townDisplay = ((isAuthorize && (ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue())||
                ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.JK.getValue()))) || !isAuthorize) ? false : true;
		StringBuilder html = getSelectBefore(this.townId, townName, "townsId" + random, random, townDisplay, this.cssClass);
        //若第一级隐藏那么默认选中本机构的上级机构代码 注意:townDisplay=true则不显示
		if(townDisplay && ObjectUtil.isNullOrEmpty(this.townValue)) {
            townValue = currentOrg.getParentCode();
        }
		for(Organization organization : organizations) {
			html.append(getOption(getDicItem(organization.getOrganCode(), organization.getOrganName())));
		}
		return html;
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

	@Deprecated
	public String getWidth() {
		return width;
	}

	@Deprecated
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

	public Boolean getIsShowOther() {
		return isShowOther;
	}

	public void setIsShowOther(Boolean isShowOther) {
		this.isShowOther = isShowOther;
	}

	public void setShowOneself(boolean isShowOneself) {
		this.isShowOneself = isShowOneself;
	}

	public Boolean getIsShowInfirmary() {
		return isShowInfirmary;
	}

	public void setIsShowInfirmary(Boolean isShowInfirmary) {
		this.isShowInfirmary = isShowInfirmary;
	}

	public Boolean getIsShowHealthOversight() {
		return isShowHealthOversight;
	}

	public void setIsShowHealthOversight(Boolean isShowHealthOversight) {
		this.isShowHealthOversight = isShowHealthOversight;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getDefaultval() {
		return defaultval;
	}

	public void setDefaultval(String defaultval) {
		this.defaultval = defaultval;
	}

	public boolean isShowOneself() {
		return isShowOneself;
	}

	public Integer getMergeType() {
		return mergeType;
	}

	public void setMergeType(Integer mergeType) {
		this.mergeType = mergeType;
	}

	public Boolean getIsAdministration() {
		return isAdministration;
	}

	public void setIsAdministration(Boolean isAdministration) {
		this.isAdministration = isAdministration;
	}

	public boolean getIsAllTown() {
		return isAllTown;
	}

	public void setIsAllTown(boolean isAllTown) {
		this.isAllTown = isAllTown;
	}

	public String getIncludeTownCodes() {
		return includeTownCodes;
	}

	public void setIncludeTownCodes(String includeTownCodes) {
		this.includeTownCodes = includeTownCodes;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

    public boolean getIsAuthorize() {
        return isAuthorize;
    }

    public void setIsAuthorize(boolean authorize) {
        isAuthorize = authorize;
    }

	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
    
    
}
