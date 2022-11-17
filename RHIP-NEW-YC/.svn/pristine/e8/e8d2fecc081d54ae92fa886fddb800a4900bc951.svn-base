package com.founder.rhip.portal.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.founder.rhip.ehr.entity.portal.RegisterSchedule;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetYYDoctorInfoResponse implements Serializable {
	private static final long serialVersionUID = -1893167872644876493L;

	@XmlElementWrapper(name = "registerSchedules")
	@XmlElement(name = "registerSchedule")
	private List<RegisterSchedule> registerScheduleList;

	public List<RegisterSchedule> getRegisterScheduleList() {
		return registerScheduleList;
	}

	public void setRegisterScheduleList(List<RegisterSchedule> registerScheduleList) {
		this.registerScheduleList = registerScheduleList;
	}
}
