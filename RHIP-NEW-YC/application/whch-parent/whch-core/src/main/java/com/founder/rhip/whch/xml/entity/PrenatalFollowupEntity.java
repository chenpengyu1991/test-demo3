
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.PrenatalFollowup;

@XmlRootElement(name = "root")
public class PrenatalFollowupEntity {

	private List<PrenatalFollowup> prenatalFollowups;

	@XmlElementWrapper(name = "prenatalFollowups")
	@XmlElement(name = "prenatalFollowup")
	public List<PrenatalFollowup> getPrenatalFollowups() {
		return prenatalFollowups;
	}

	public void setPrenatalFollowups(List<PrenatalFollowup> prenatalFollowups) {
		this.prenatalFollowups = prenatalFollowups;
	}
}
