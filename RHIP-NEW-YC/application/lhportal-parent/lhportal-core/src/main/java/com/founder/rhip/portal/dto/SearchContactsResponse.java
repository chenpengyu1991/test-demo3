package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.portal.FrequentContacts;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class SearchContactsResponse implements Serializable {

	private static final long serialVersionUID = 4275215106009462357L;
	
	@XmlElement(name = "contact")
	private List<FrequentContacts> frequentContacts;

	public List<FrequentContacts> getFrequentContacts() {
		return frequentContacts;
	}

	public void setFrequentContacts(List<FrequentContacts> frequentContacts) {
		this.frequentContacts = frequentContacts;
	}


}
