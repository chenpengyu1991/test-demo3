package com.founder.rhip.ehr.tld;

import java.io.StringWriter;

import org.apache.commons.lang.StringUtils;

/**
 * 健康档案打开link
 * 
 * @author liuk
 * 
 */
public final class EhrBrwLinkTag extends javax.servlet.jsp.tagext.SimpleTagSupport {

	private String personId;
	private String idCard;

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	private final String openEhrBrwById = "<a  href=\"javascript:void(0)\" onclick=\"openEhrBrwById('%1$s')\">%2$s</a>";
	private final String openEhrBrwByIdCard = "<a href=\"javascript:void(0)\" onclick=\"openEhrBrwByIdCard('%1$s')\">%2$s</a>";

	public void doTag() throws javax.servlet.jsp.JspException, java.io.IOException {
		javax.servlet.jsp.JspWriter out = getJspContext().getOut();
		String text = null;
		final StringWriter stringWriter = new StringWriter();
		getJspBody().invoke(stringWriter);
		String value = stringWriter.toString();
		if (null != personId && personId.trim().length() > 0 && StringUtils.isNumeric(personId.trim())) {
			text = String.format(openEhrBrwById, personId, value);
		} else if (null != idCard && idCard.trim().length() > 0) {
			text = String.format(openEhrBrwByIdCard, idCard, value);
		} else {
			text = value;
		}
		if (null != text && text.trim().length() > 0) {
			out.write(text);
		}
	}

}
