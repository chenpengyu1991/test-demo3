
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.child.FrailChildFollowup;

@XmlRootElement(name = "root")
public class FrailChildFollowupEntity {

	private List<FrailChildFollowup> frailChildFollowups;

	@XmlElementWrapper(name = "frailChildFollowups")
	@XmlElement(name = "frailChildFollowup")
	public List<FrailChildFollowup> getFrailChildFollowups() {
		return frailChildFollowups;
	}

	public void setFrailChildFollowups(List<FrailChildFollowup> frailChildFollowups) {
		this.frailChildFollowups = frailChildFollowups;
	}
}
