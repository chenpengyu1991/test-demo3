
package com.founder.rhip.whch.xml.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.women.PremaritalHealthService;

@XmlRootElement(name = "root")
public class PremaritalHealthServiceEntity {

	private List<PremaritalHealthService> premaritalHealthServices;

	@XmlElementWrapper(name = "premaritalHealthServices")
	@XmlElement(name = "premaritalHealthService")
	public List<PremaritalHealthService> getPremaritalHealthServices() {
		return premaritalHealthServices;
	}

	public void setPremaritalHealthServices(List<PremaritalHealthService> premaritalHealthServices) {
		this.premaritalHealthServices = premaritalHealthServices;
	}
}
