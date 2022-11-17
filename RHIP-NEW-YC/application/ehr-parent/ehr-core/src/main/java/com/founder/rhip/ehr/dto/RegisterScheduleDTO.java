package com.founder.rhip.ehr.dto;

import java.util.List;

import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.OutClinic;
import com.founder.rhip.ehr.entity.portal.OutDoctor;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.RegisterScheduleTime;
import com.founder.rhip.mdm.entity.Organization;

public class RegisterScheduleDTO {
	
	private Organization organization;
	
	private HospitalInfo hospitalInfo;
	
	private OutClinic outClinic;
	
	private OutDoctor outDoctor;
	
	private List<RegisterSchedule> registerSchedules;
	
	private List<RegisterScheduleTime> registerSchedulesTime;

	public List<RegisterScheduleTime> getRegisterSchedulesTime() {
		return registerSchedulesTime;
	}

	public void setRegisterSchedulesTime(
			List<RegisterScheduleTime> registerSchedulesTime) {
		this.registerSchedulesTime = registerSchedulesTime;
	}

	public HospitalInfo getHospitalInfo() {
		return hospitalInfo;
	}

	public void setHospitalInfo(HospitalInfo hospitalInfo) {
		this.hospitalInfo = hospitalInfo;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public OutClinic getOutClinic() {
		return outClinic;
	}

	public void setOutClinic(OutClinic outClinic) {
		this.outClinic = outClinic;
	}

	public OutDoctor getOutDoctor() {
		return outDoctor;
	}

	public void setOutDoctor(OutDoctor outDoctor) {
		this.outDoctor = outDoctor;
	}

	public List<RegisterSchedule> getRegisterSchedules() {
		return registerSchedules;
	}

	public void setRegisterSchedules(List<RegisterSchedule> registerSchedules) {
		this.registerSchedules = registerSchedules;
	}
	
}