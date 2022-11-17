package com.founder.rhip.ehr.service.export;

/**
 * 导出单
 * 
 * @author liuk
 * 
 */
public class Report {
	private String title;
	private Unit[][] header;
	private Unit[][] body;
	private Unit[][] footer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Unit[][] getHeader() {
		return header;
	}

	public void setHeader(Unit[][] header) {
		this.header = header;
	}

	public Unit[][] getBody() {
		return body;
	}

	public void setBody(Unit[][] body) {
		this.body = body;
	}

	public Unit[][] getFooter() {
		return footer;
	}

	public void setFooter(Unit[][] footer) {
		this.footer = footer;
	}

}
