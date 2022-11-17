package com.founder.rhip.ehr.dto.integration;


public class GenericMonitor {
	private Long shouldCount;

	private Long actualCount;

	public Long getShouldCount() {
		return shouldCount;
	}

	public void setShouldCount(Long shouldCount) {
		this.shouldCount = shouldCount;
	}

	public Long getActualCount() {
		return actualCount;
	}

	public void setActualCount(Long actualCount) {
		this.actualCount = actualCount;
	}
}
