package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.founder.rhip.ehr.common.JaxbDateSerializer;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetYYClinicDateByDepartmentResponse implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	@XmlElementWrapper(name = "requestDates")
	@XmlElement(name = "requestDate")
	@XmlJavaTypeAdapter(JaxbDateSerializer.class)
	List<Date> requestDate;

	public List<Date> getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(List<Date> requestDate) {
		this.requestDate = requestDate;
	}
}
