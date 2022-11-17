package com.founder.rhip.portal.dto;

import com.founder.rhip.ehr.entity.portal.RegisterSchedule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
public class UpdateResource implements Serializable{
	private static final long serialVersionUID = -1893167872644876493L;
	
	private List<RegisterSchedule> registerScheduleList;

	@XmlElementWrapper(name = "registerSchedules")
	@XmlElement(name = "registerSchedule")
	public List<RegisterSchedule> getRegisterScheduleList() {
		return registerScheduleList;
	}

	public void setRegisterScheduleList(List<RegisterSchedule> registerScheduleList) {
		this.registerScheduleList = registerScheduleList;
	}

	public UpdateResource() {
		registerScheduleList = new ArrayList<RegisterSchedule>();
		RegisterSchedule registerSchedule = new RegisterSchedule();
//		registerSchedule.setAdmitNum(11L);
		registerSchedule.setAmpm("p");
//		registerSchedule.setClinicType("11");
		registerSchedule.setDeptSn("001");
		registerSchedule.setDoctorSn("dd1");
		registerSchedule.setHospitalCode("dd1");
		registerSchedule.setHospitalName("医院1");
		registerSchedule.setDeptName("kehsi1");
		registerSchedule.setDoctorName("hah");
		registerSchedule.setRegisterFee(22.2);
		registerSchedule.setRequestDate(new Date());
//		registerSchedule.setReserveNum(11L);
		registerSchedule.setEmpTitCode("职称代码");
		registerSchedule.setEmpTitName("职称");
		registerSchedule.setSocialNo("身份证");
		registerSchedule.setSpecializes("专长");
		registerScheduleList.add(registerSchedule);
		registerScheduleList.add(registerSchedule);
	}
}
