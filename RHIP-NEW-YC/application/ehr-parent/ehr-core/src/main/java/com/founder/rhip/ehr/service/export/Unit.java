package com.founder.rhip.ehr.service.export;

/**
 * 单元格
 * 
 * @author liuk
 * 
 */
public class Unit {
	private String value;
	private boolean used = false;
	private int colspan;
	private int rowspan;
	private Integer width;
	private Integer height;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getColspan() {
		return colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}

	public int getRowspan() {
		return rowspan;
	}

	public void setRowspan(int rowspan) {
		this.rowspan = rowspan;
	}

}
