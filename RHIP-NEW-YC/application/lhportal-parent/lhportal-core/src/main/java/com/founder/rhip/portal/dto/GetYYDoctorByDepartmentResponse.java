package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.portal.OutDoctor;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetYYDoctorByDepartmentResponse implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	@XmlElementWrapper(name = "outDoctors")
	@XmlElement(name = "outDoctor")
	private List<OutDoctor> outDoctors;

	public List<OutDoctor> getOutDoctors() {
		return outDoctors;
	}

	public void setOutDoctors(List<OutDoctor> outDoctors) {
		this.outDoctors = outDoctors;
	}
	
}