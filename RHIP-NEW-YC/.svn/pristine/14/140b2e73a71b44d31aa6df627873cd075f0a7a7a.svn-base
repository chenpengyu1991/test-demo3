package com.founder.rhip.ehr.tld;

import com.founder.fasf.util.StringUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

/**
 * Bootstrap Small-box box
 * 
 * @author yejianfei
 * 
 */
public final class BoxTag extends BaseTag {
	private static final long serialVersionUID = 6375236950704996479L;

	//ID
	private String id = null;
	//box背景css
	private String boxBgCss;
	//指标值单位
	private String unitDisplay;
	//指标名称
	private String nameDisplay;
	//指标值
	private String value;
	//指标请求URL
	private String url;
	//指标图标
	private String boxIcon;
	//是否显示刷新按钮
	private boolean refreshBtnFlag = false;
	//box类型：small-box,box,infobox
	private String boxType;
	//box的样式
	private String style;


	public int doStartTagInternal() throws JspTagException {
		inject();
		String html = null;
		if(StringUtil.isNullOrEmpty(this.boxBgCss)){
			this.boxBgCss = "bg-aqua";
		}
		if(StringUtil.isNullOrEmpty(this.boxIcon) ){
			this.boxIcon = "ion ion-gear-a";
		}
		StringBuilder sb = new StringBuilder();
		String boxCss = this.boxType;
		if(!"info-box".equals(boxType)){
			boxCss += " " + this.boxBgCss;
		}
		//start box
		//url
		String dataUrl = " data-url='" + this.url + "'";
		String dataStyle = " style='"+ this.style + "'";
		String idStr = "";
		if(StringUtil.isNotEmpty(this.id)){
			idStr = " id='" + this.id + "'";
		}
		sb.append("<div " + idStr + " class='" + boxCss + "'" + dataUrl + dataStyle + ">");
		if(this.boxType.equals("small-box")){
			sb.append(createSmallBoxContent());
		}else if(this.boxType.equals("box")){
			sb.append(createBoxContent());
		}else if(this.boxType.equals("info-box")){
			sb.append(createInfoBoxContent());
		}
		//end box
		sb.append("</div>");
		html = sb.toString();
		try {
			JspWriter jw = pageContext.getOut();
			jw.write(html);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	private String createSmallBoxContent(){
		StringBuilder sb = new StringBuilder();
		//是否显示刷新按钮
		if(this.isRefreshBtnFlag()){
			sb.append("<div class=\"refresh-btn pull-right\">");
			sb.append("<i class=\"fa fa-refresh\"></i>");
			sb.append("</div>");
		}
		//small-box内容
		sb.append("<div class=\"inner\">");
		String boxContent = String.format("<h3><span class=\"box-content\">%1$s</span><span class=\"box-unit\">%2$s</span></h3>",this.value,this.unitDisplay);
		sb.append(boxContent);
		sb.append(String.format("<p><span class='box-name'>%1$s</span></p>",this.nameDisplay));
		sb.append("</div>");
		sb.append("<div class=\"icon\">");
		sb.append(String.format("<i class=\"%1$s\"></i>",this.boxIcon));
		sb.append("</div>");
		return sb.toString();
	}

	private String createBoxContent(){
		StringBuilder sb = new StringBuilder();
		sb.append("<div class=\"box-header\">");
		sb.append(String.format("<h3 class=\"box-title\">%1$s</h3>",this.nameDisplay));

		//是否显示刷新按钮
		if(this.isRefreshBtnFlag()){
			sb.append("<div class=\"refresh-btn pull-right\">");
			sb.append("<i class=\"fa fa-refresh\"></i>");
			sb.append("</div>");
		}
		sb.append("</div>");
		sb.append("<div class=\"box-body\">");
		String boxContent = String.format("<h3><span class=\"box-content\">%1$s</span>%2$s</h3>",this.value,this.unitDisplay);
		sb.append(boxContent);
		sb.append("</div>");

		return sb.toString();
	}

	private String createInfoBoxContent(){
		StringBuilder sb = new StringBuilder();
		sb.append("<span class=\"info-box-icon "+ this.boxBgCss +"\"><i class=\"fa " + this.boxIcon +"\"></i></span>");
		sb.append("<div class=\"info-box-content\">");
		sb.append(String.format("<span class=\"info-box-text\">%1$s</span>",this.nameDisplay));
		sb.append(String.format("<span style=\"display:inline\" class=\"info-box-number\">%1$s</span><span class=\"box-unit\">%2$s</span>",this.value,this.unitDisplay));
		sb.append("</div>");
		return sb.toString();
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

	public String getBoxBgCss() {
		return boxBgCss;
	}

	public void setBoxBgCss(String boxBgCss) {
		this.boxBgCss = boxBgCss;
	}
	public String getUnitDisplay() {
		return unitDisplay;
	}

	public void setUnitDisplay(String unitDisplay) {
		this.unitDisplay = unitDisplay;
	}

	public String getNameDisplay() {
		return nameDisplay;
	}

	public void setNameDisplay(String nameDisplay) {
		this.nameDisplay = nameDisplay;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBoxIcon() {
		return boxIcon;
	}

	public void setBoxIcon(String boxIcon) {
		this.boxIcon = boxIcon;
	}

	public boolean isRefreshBtnFlag() {
		return refreshBtnFlag;
	}

	public void setRefreshBtnFlag(boolean refreshBtnFlag) {
		this.refreshBtnFlag = refreshBtnFlag;
	}

	public String getBoxType() {
		return boxType;
	}

	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}
