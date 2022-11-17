
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.BirthControlService;

@XmlRootElement(name = "root")
public class BirthControlServiceEntity {

	private List<BirthControlService> birthControlServices;

	@XmlElementWrapper(name = "birthControlServices")
	@XmlElement(name = "birthControlService")
	public List<BirthControlService> getBirthControlServices() {
		return birthControlServices;
	}

	public void setBirthControlServices(List<BirthControlService> birthControlServices) {
		this.birthControlServices = birthControlServices;
	}
}
