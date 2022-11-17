
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.child.BirthCertificate;

@XmlRootElement(name = "root")
public class BirthCertificateEntity {

	private List<BirthCertificate> birthCertificates;

	@XmlElementWrapper(name = "birthCertificates")
	@XmlElement(name = "birthCertificate")
	public List<BirthCertificate> getBirthCertificates() {
		return birthCertificates;
	}

	public void setBirthCertificates(List<BirthCertificate> birthCertificates) {
		this.birthCertificates = birthCertificates;
	}
}
