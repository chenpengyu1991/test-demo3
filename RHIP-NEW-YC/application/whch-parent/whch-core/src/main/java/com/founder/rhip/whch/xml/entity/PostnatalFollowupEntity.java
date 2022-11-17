
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.PostnatalFollowup;

@XmlRootElement(name = "root")
public class PostnatalFollowupEntity {

	private List<PostnatalFollowup> postnatalFollowups;


	@XmlElementWrapper(name = "postnatalFollowups")
	@XmlElement(name = "postnatalFollowup")
	public List<PostnatalFollowup> getPostnatalFollowups() {
		return postnatalFollowups;
	}

	public void setPostnatalFollowups(List<PostnatalFollowup> postnatalFollowups) {
		this.postnatalFollowups = postnatalFollowups;
	}
}
