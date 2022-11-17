package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.PostpartumDaysHealthInfo;

@XmlRootElement(name = "root")
public class PostpartumDaysHealthInfoEntity {
	private List<PostpartumDaysHealthInfo> postpartumDaysHealthInfos;

	@XmlElementWrapper(name = "postpartumDaysHealthInfos")
	@XmlElement(name = "postpartumDaysHealthInfo")
	public List<PostpartumDaysHealthInfo> getPostpartumDaysHealthInfos() {
		return postpartumDaysHealthInfos;
	}

	
	public void setPostpartumDaysHealthInfos(List<PostpartumDaysHealthInfo> postpartumDaysHealthInfos) {
		this.postpartumDaysHealthInfos = postpartumDaysHealthInfos;
	}
	
	
}
