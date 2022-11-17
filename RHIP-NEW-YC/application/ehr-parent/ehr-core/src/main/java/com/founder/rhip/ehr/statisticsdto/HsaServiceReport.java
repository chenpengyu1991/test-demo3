package com.founder.rhip.ehr.statisticsdto;

public class HsaServiceReport {
	private String type;
	private String subType;
	private int count;
	private int total;
	private final static String SPLIT = "_";

	public String makeKey() {
		int size = type == null ? 4 : type.length() + subType == null ? 4 : subType.length() + 1;
		return new StringBuilder(size).append(type).append(SPLIT).append(subType).toString();
	}

	public void setTotal(HsaServiceReport that) {
		if (null != that) {
			this.setTotal(that.getCount());
		} else {
			this.setTotal(0);
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
