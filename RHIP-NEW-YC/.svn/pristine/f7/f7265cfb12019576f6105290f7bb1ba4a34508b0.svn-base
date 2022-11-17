package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.portal.OutClinic;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetYYAllDepartmentInfoResponse implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	@XmlElementWrapper(name = "outClinics")
	@XmlElement(name = "outClinic")
	private List<OutClinic> outClinics;

	public List<OutClinic> getOutClinics() {
		return outClinics;
	}

	public void setOutClinics(List<OutClinic> outClinics) {
		this.outClinics = outClinics;
	}

}
