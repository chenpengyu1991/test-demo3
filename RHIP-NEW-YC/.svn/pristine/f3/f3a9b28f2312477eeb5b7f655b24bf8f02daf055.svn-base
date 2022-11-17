package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.WomanDiseaseCensus;

@XmlRootElement(name = "root")
public class WomanDiseaseCensusEntity {
	
	private List<WomanDiseaseCensus> womanDiseaseCensus;

	@XmlElementWrapper(name = "womanDiseaseCensuses")
	@XmlElement(name = "womanDiseaseCensus")
	public List<WomanDiseaseCensus> getWomanDiseaseCensus() {
		return womanDiseaseCensus;
	}

	
	public void setWomanDiseaseCensus(List<WomanDiseaseCensus> womanDiseaseCensus) {
		this.womanDiseaseCensus = womanDiseaseCensus;
	}
	
	
}
