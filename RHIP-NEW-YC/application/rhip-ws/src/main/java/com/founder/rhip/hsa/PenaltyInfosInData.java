package com.founder.rhip.hsa;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.hsa.PenaltyInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
public class PenaltyInfosInData {
	@XmlElement(name = "location")
	@XmlElementWrapper(name = "locations")
	private List<PenaltyInfo> penaltyInfos;

	public List<PenaltyInfo> getPenaltyInfos() {
		return penaltyInfos;
	}

	public void setPenaltyInfos(List<PenaltyInfo> penaltyInfos) {
		this.penaltyInfos = penaltyInfos;
	}
}
