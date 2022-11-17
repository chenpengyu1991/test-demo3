package com.founder.rhip.portal.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class PageActionOut implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	private static final int CURRENTPAGENUM = 1;
	private static final int CURRENTPAGECOUNT = 10;
	
	private int currentpagenum = CURRENTPAGENUM;
	private int rowcountall;
	private int pagecountall;
	private int currentpagecount = CURRENTPAGECOUNT;
	public int getCurrentpagenum() {
		return currentpagenum;
	}
	public void setCurrentpagenum(int currentpagenum) {
		this.currentpagenum = currentpagenum;
	}
	public int getRowcountall() {
		return rowcountall;
	}
	public void setRowcountall(int rowcountall) {
		this.rowcountall = rowcountall;
	}
	public int getPagecountall() {
		return pagecountall;
	}
	public void setPagecountall(int pagecountall) {
		this.pagecountall = pagecountall;
	}
	public int getCurrentpagecount() {
		return currentpagecount;
	}
	public void setCurrentpagecount(int currentpagecount) {
		this.currentpagecount = currentpagecount;
	}
	
	
	
}
