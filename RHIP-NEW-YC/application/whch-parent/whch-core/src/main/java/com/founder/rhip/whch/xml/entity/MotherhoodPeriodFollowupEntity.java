
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.MotherhoodPeriodFollowup;

@XmlRootElement(name = "root")
public class MotherhoodPeriodFollowupEntity {

	private List<MotherhoodPeriodFollowup> motherhoodPeriodFollowups;

	@XmlElementWrapper(name = "motherhoodPeriodFollowups")
	@XmlElement(name = "motherhoodPeriodFollowup")
	public List<MotherhoodPeriodFollowup> getMotherhoodPeriodFollowups() {
		return motherhoodPeriodFollowups;
	}

	public void setMotherhoodPeriodFollowups(
			List<MotherhoodPeriodFollowup> motherhoodPeriodFollowups) {
		this.motherhoodPeriodFollowups = motherhoodPeriodFollowups;
	}
}
