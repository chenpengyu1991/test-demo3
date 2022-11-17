package com.founder.rhip.ehr.tld;

import java.io.StringWriter;

import com.founder.fasf.util.ObjectUtil;

/**
 * 提示
 * 
 * @author liuk
 * 
 */
public final class TextWithTipTag extends javax.servlet.jsp.tagext.SimpleTagSupport {

	private java.lang.String value;
	private java.lang.String defaultValue;
	private java.lang.Integer length;
	private java.lang.Boolean linkStyle;
	private java.lang.Boolean trim = false;

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

	public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException {
		javax.servlet.jsp.JspWriter out = getJspContext().getOut();
		if (null == value) {
			final StringWriter stringWriter = new StringWriter();
			getJspBody().invoke(stringWriter);
			value = stringWriter.toString();
		}
		if (null == value) {
			return;
		}
		
		if (null != trim && trim) {
			value = value.replaceAll("\\s*|\t|\r|\n|", "");
		}

		if (value.trim().length() < 1 && null != defaultValue) {
			value = defaultValue;
		}

		if (value.trim().length() > 0) {
			String subValue = value;
			if (null != length && length > 0) {
				subValue = value.substring(0, length);
			}
			out.write("<label  ");
			if (null != linkStyle && linkStyle) {
				out.write(" style=\"cursor:hand\"");
			}
			out.write("  class=\"text_tip_span\" title=\"");
			out.print(value);
			out.write('"');
			out.write('>');
			out.print(subValue);
			out.write("</label>");
		}
	}

	public java.lang.Boolean getTrim() {
		return trim;
	}

	public void setTrim(java.lang.Boolean trim) {
		this.trim = trim;
	}

	public java.lang.String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(java.lang.String defaultValue) {
		this.defaultValue = defaultValue;
	}
}
