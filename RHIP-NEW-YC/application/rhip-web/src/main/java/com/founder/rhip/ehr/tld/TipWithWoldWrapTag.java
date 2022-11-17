package com.founder.rhip.ehr.tld;

import java.io.StringWriter;

/**
 * 提示 换行
 * @author ggf
 *
 */
public final class TipWithWoldWrapTag extends javax.servlet.jsp.tagext.SimpleTagSupport {

	private java.lang.String value;
	private java.lang.Integer length;
	private java.lang.Integer titleLength;
	private java.lang.Boolean linkStyle;

	public java.lang.String getValue() {
		return this.value;
	}

	public void setValue(java.lang.String value) {
		this.value = value;
	}

	public java.lang.Integer getLength() {
		return this.length;
	}

	public void setLength(java.lang.Integer length) {
		this.length = length;
	}

	public java.lang.Boolean getLinkStyle() {
		return this.linkStyle;
	}

	public void setLinkStyle(java.lang.Boolean linkStyle) {
		this.linkStyle = linkStyle;
	}

	public java.lang.Integer getTitleLength() {
		return titleLength;
	}

	public void setTitleLength(java.lang.Integer titleLength) {
		this.titleLength = titleLength;
	}

	public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException {
		javax.servlet.jsp.JspWriter out = getJspContext().getOut();
		if (null == value || value.trim().length() < 1) {
			final StringWriter stringWriter = new StringWriter();
			getJspBody().invoke(stringWriter);
			value = stringWriter.toString();
		}
		String subValue = value;
		if (null != value && value.trim().length() > 0) {
			if(null != titleLength && titleLength > 0){
				String titleValue = "";
				for(int i=0; i <= Math.round(value.length() / titleLength); i++){
					if(titleLength*(i+1) <= value.length()){
						titleValue = titleValue +  value.substring(i*titleLength,titleLength*(i+1)) + "\n";
					}else if(i*titleLength < value.length()){
						titleValue = titleValue +  value.substring(i*titleLength,value.length()) + "\n";
					}
				}
				titleValue = titleValue.substring(0, titleValue.length() - 1);
				value = titleValue;
			}
			if (null != length && length > 0) {
				subValue = value.substring(0, length);
			}
			out.write("<label  ");
			out.write(" title=\"");
			out.print(value);
			out.write('"');
			out.write('>');
			out.print(subValue);
			out.write("</label>");
		}
	}
}
