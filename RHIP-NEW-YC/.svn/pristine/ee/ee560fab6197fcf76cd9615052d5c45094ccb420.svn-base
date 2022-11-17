
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.child.ChildHealthCard;

@XmlRootElement(name = "root")
public class ChildHealthCardEntity {

	private List<ChildHealthCard> childHealthCards;

	@XmlElementWrapper(name = "childHealthCards")
	@XmlElement(name = "childHealthCard")
	public List<ChildHealthCard> getChildHealthCards() {
		return childHealthCards;
	}

	public void setChildHealthCards(List<ChildHealthCard> childHealthCards) {
		this.childHealthCards = childHealthCards;
	}
}
