package com.founder.rhip.portal.tld;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

public class SerialNumber extends BaseTag {

	private static final long serialVersionUID = 1L;

	private int currentPage;
	
	private int pageSize;
	
	private int index;
	
	@Override
	public int doStartTagInternal() throws JspTagException {
		
		int serialNmuber = (currentPage-1)*pageSize+index+1;
		JspWriter jw = pageContext.getOut();
		try {
			jw.write(serialNmuber+"");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public int doEndTagInternal() throws JspException {
		return super.doEndTag();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
