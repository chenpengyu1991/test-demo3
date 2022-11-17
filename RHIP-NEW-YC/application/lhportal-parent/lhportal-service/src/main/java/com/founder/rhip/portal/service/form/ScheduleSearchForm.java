package com.founder.rhip.portal.service.form;

import java.util.Calendar;
import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
public class ScheduleSearchForm {
	
	private String hospital;
	private String clinic;
	private String doctor;
	private String clinicType;
	private String clinicName;
	private Date requestDateBegin;
	private Date requestDateEnd;
	private Date requestTimeBegin;
	private Date requestTimeEnd;
	private Long frequent;
	private String startViewReserveHour;
	private String startViewReserveMin;
	private String type;
	private String deptName;
	
	
	public Criteria getCriteria(String scheTableName,String clinicTableName){
		Criteria criteria = new Criteria();
		
		if(ObjectUtil.isNotEmpty(hospital)){
			criteria.add(scheTableName + ".hospital_Code", hospital);
		}
		
		if(ObjectUtil.isNotEmpty(clinic)){
			criteria.add(scheTableName + ".dept_Sn" ,clinic);
		}

		if(ObjectUtil.isNotEmpty(clinicName)){
			criteria.add(clinicTableName + ".name",OP.LIKE ,clinicName);
		}
		
		if(ObjectUtil.isNotEmpty(doctor)){
			criteria.add(scheTableName + ".doctor_Sn", doctor);
		}
		
		if(ObjectUtil.isNotEmpty(clinicType)){
			criteria.add(scheTableName + ".clinic_Type", clinicType);
		}
		if(StringUtil.isNotEmpty(type) && type.equals("02")) {
			if(ObjectUtil.isNotEmpty(deptName)){
				criteria.add(clinicTableName + ".name" ,deptName);
			}
		}
		
		/*if ((this.getRequestTimeBegin()).after(this.getRequestTimeEnd())) {
			requestDateBegin  = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,2);
			requestDateEnd = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,8);
			DateUtil.getCriteriaByDateRange(criteria, scheTableName + ".request_Date", requestDateBegin, requestDateEnd);
		} else {
			requestDateBegin  = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,1);
			requestDateEnd = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,7);
			DateUtil.getCriteriaByDateRange(criteria, scheTableName + ".request_Date", requestDateBegin, requestDateEnd);
		}*/
		return criteria;
	}

	public String getStartViewReserveHour() {
		return startViewReserveHour;
	}

	public void setStartViewReserveHour(String startViewReserveHour) {
		this.startViewReserveHour = startViewReserveHour;
	}

	public String getStartViewReserveMin() {
		return startViewReserveMin;
	}

	public void setStartViewReserveMin(String startViewReserveMin) {
		this.startViewReserveMin = startViewReserveMin;
	}

	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getClinic() {
		return clinic;
	}
	public void setClinic(String clinic) {
		this.clinic = clinic;
	}
	
	public Date getRequestDateBegin() {
		return requestDateBegin;
	}

	public void setRequestDateBegin(Date requestDateBegin) {
		this.requestDateBegin = requestDateBegin;
	}

	public Date getRequestDateEnd() {
		return requestDateEnd;
	}

	public void setRequestDateEnd(Date requestDateEnd) {
		this.requestDateEnd = requestDateEnd;
	}

	public Date getRequestTimeBegin() {
		if(ObjectUtil.isNullOrEmpty(requestTimeBegin)){
			Calendar cal = Calendar.getInstance();
			cal.get(Calendar.HOUR_OF_DAY);
			cal.get(Calendar.MINUTE); 
			cal.get(Calendar.SECOND); 
			cal.get(Calendar.MILLISECOND);
			requestTimeBegin = cal.getTime();
		}
		return requestTimeBegin;
	}

	public void setRequestTimeBegin(Date requestTimeBegin) {
		this.requestTimeBegin = requestTimeBegin;
	}

	public Date getRequestTimeEnd() {
		if(ObjectUtil.isNullOrEmpty(requestTimeEnd)){
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(this.getStartViewReserveHour()).intValue());
			if (this.getStartViewReserveMin().equals("00")) {
				cal.set(Calendar.MINUTE, 0);
			} else {
				cal.set(Calendar.MINUTE, Integer.valueOf(this.getStartViewReserveMin()).intValue());
			}
	        cal.set(Calendar.SECOND, 0);
	        cal.set(Calendar.MILLISECOND, 0);
			requestTimeEnd = cal.getTime();
		}
		return requestTimeEnd;
	}

	public void setRequestTimeEnd(Date requestTimeEnd) {
		this.requestTimeEnd = requestTimeEnd;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getClinicType() {
		return clinicType;
	}

	public void setClinicType(String clinicType) {
		this.clinicType = clinicType;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public Long getFrequent() {
		return frequent;
	}

	public void setFrequent(Long frequent) {
		this.frequent = frequent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
