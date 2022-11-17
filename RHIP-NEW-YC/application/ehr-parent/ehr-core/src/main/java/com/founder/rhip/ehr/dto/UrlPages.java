package com.founder.rhip.ehr.dto;

import java.util.HashMap;

import com.founder.rhip.ehr.common.EHRConstants;

public class UrlPages {
	private HashMap<String,Integer> urlPgaeMap;

	public HashMap<String, Integer> getUrlPgaeMap() {
		return urlPgaeMap;
	}

	public void setUrlPgaeMap(HashMap<String, Integer> urlPgaeMap) {
		this.urlPgaeMap = urlPgaeMap;
	}
	
	public void setPageSize(String url,Integer pageSize){
		urlPgaeMap.put(url, pageSize);
	}
	
	public Integer getPageSize(String url){
		Integer pageSize = urlPgaeMap.get(url);
		if(pageSize == null){
			pageSize = EHRConstants.PAGE_SIZE;
		}
		return pageSize;
	}
}
