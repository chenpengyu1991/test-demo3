package com.founder.rhip.export.controller;

import java.io.Serializable;

public class ReportContentForm implements Serializable {
	private static final long serialVersionUID = 4094493906237813449L;
	private String title;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
