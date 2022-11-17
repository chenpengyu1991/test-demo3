package com.founder.rhip.ihm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.ui.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BloodJJQueryForm {

	private String name;

	private String idCard;

	private String gender;

	// 采血\发血\用血日期
	private String bloodDate;

	private String hospital;

	// ABO血型
	private String abotype;

	// 失效日期
	private String exptime;

	private String assignee;

	private String acceptType;

	private String beginTime;

	private String endTime;

	private String fromCall;

	private String patName;

	private String busNo;

	private String driver;

	private String carTelphone;

	private String centerNo;

	private String carId;

	private String stationNo;

	private String sendToPlace;

	private String firstCall;

	private String eventTitle;

	private String firstDispatcher;
	// xh
	private String idcard;

	private String bloodType;

	private String aboBloodType;

	private String patientname;

	private String patientidentitytype;

	private String patientidentityid;

	private String usetime;

	private String rhtype;

	private String dontime;

	private String proctime;

	private String branch;

	private String outtime;

	private String procname;

	private String hosname;

	private String age;

	private String unitName;
	
	private String logType;
	
	private String personName;
	
	private String parentName;
	
	private String operateDate;

	private String dateFrom;

	private String dateTo;

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public String getPatientidentitytype() {
		return patientidentitytype;
	}

	public void setPatientidentitytype(String patientidentitytype) {
		this.patientidentitytype = patientidentitytype;
	}

	public String getPatientidentityid() {
		return patientidentityid;
	}

	public void setPatientidentityid(String patientidentityid) {
		this.patientidentityid = patientidentityid;
	}

	public String getUsetime() {
		return usetime;
	}

	public void setUsetime(String usetime) {
		this.usetime = usetime;
	}

	public String getRhtype() {
		return rhtype;
	}

	public void setRhtype(String rhtype) {
		this.rhtype = rhtype;
	}

	public String getDontime() {
		return dontime;
	}

	public void setDontime(String dontime) {
		this.dontime = dontime;
	}

	public String getProctime() {
		return proctime;
	}

	public void setProctime(String proctime) {
		this.proctime = proctime;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getOuttime() {
		return outtime;
	}

	public void setOuttime(String outtime) {
		this.outtime = outtime;
	}

	public String getProcname() {
		return procname;
	}

	public void setProcname(String procname) {
		this.procname = procname;
	}

	public String getHosname() {
		return hosname;
	}

	public void setHosname(String hosname) {
		this.hosname = hosname;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getAboBloodType() {
		return aboBloodType;
	}

	public void setAboBloodType(String aboBloodType) {
		this.aboBloodType = aboBloodType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodDate() {
		return bloodDate;
	}

	public void setBloodDate(String bloodDate) {
		this.bloodDate = bloodDate;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getAbotype() {
		return abotype;
	}

	public void setAbotype(String abotype) {
		this.abotype = abotype;
	}

	public String getExptime() {
		return exptime;
	}

	public void setExptime(String exptime) {
		this.exptime = exptime;
	}

	public String getAssignee() {
		return assignee;
	}

	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

	public String getAcceptType() {
		return acceptType;
	}

	public void setAcceptType(String acceptType) {
		this.acceptType = acceptType;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getFromCall() {
		return fromCall;
	}

	public void setFromCall(String fromCall) {
		this.fromCall = fromCall;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getCarTelphone() {
		return carTelphone;
	}

	public void setCarTelphone(String carTelphone) {
		this.carTelphone = carTelphone;
	}

	public String getCenterNo() {
		return centerNo;
	}

	public void setCenterNo(String centerNo) {
		this.centerNo = centerNo;
	}

	public String getFirstCall() {
		return firstCall;
	}

	public void setFirstCall(String firstCall) {
		this.firstCall = firstCall;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getFirstDispatcher() {
		return firstDispatcher;
	}

	public void setFirstDispatcher(String firstDispatcher) {
		this.firstDispatcher = firstDispatcher;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getStationNo() {
		return stationNo;
	}

	public void setStationNo(String stationNo) {
		this.stationNo = stationNo;
	}

	public String getSendToPlace() {
		return sendToPlace;
	}

	public void setSendToPlace(String sendToPlace) {
		this.sendToPlace = sendToPlace;
	}

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public Criteria getCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("NAME", name);
		}
		return criteria;
	}

	public Criteria getNewCitizenScore() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(logType)) {
			criteria.add("LOG_TYPE", logType);
		}
		if (StringUtil.isNotEmpty(idCard)) {
			criteria.add("ID_CARD", idCard);
		}
		if (StringUtil.isNotEmpty(personName)) {
			criteria.add("PERSON_NAME",OP.LIKE, personName);
		}
		if (StringUtil.isNotEmpty(parentName)) {
			criteria.add("PARENT_NAME",OP.LIKE, parentName);
		}
		if (StringUtil.isNotEmpty(operateDate)) {
		//	criteria.add("OPERATE_DATE", operateDate);
			DateUtil.getCriteriaByDateRange(criteria, "OPERATE_DATE",
					DateUtil.parseSimpleDate(operateDate, "yyyyMMdd"),
					DateUtil.parseSimpleDate(operateDate, "yyyyMMdd"));
		}
		return criteria;
	}

	public Criteria getHospitalBloodUse() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("NAME", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("GENDER", gender);
		}
		if (StringUtil.isNotEmpty(age)) {
			criteria.add("AGE", OP.LIKE, age);
		}
		if (StringUtil.isNotEmpty(unitName)) {
			criteria.add("UNIT_NAME", OP.LIKE, unitName);
		}
        if(StringUtil.isNotEmpty(hospital)){
            criteria.add("HOSPITAL_NAME", OP.LIKE, hospital);
        }
		return criteria;
	}

    public Criteria getHospitalBloodUse2() {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.add("B.NAME", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(gender)) {
            criteria.add("B.GENDER", gender);
        }
        if (StringUtil.isNotEmpty(age)) {
            criteria.add("B.AGE", OP.LIKE, age);
        }
        if (StringUtil.isNotEmpty(unitName)) {
            criteria.add("B.UNIT_NAME", OP.LIKE, unitName);
        }
        if(StringUtil.isNotEmpty(hospital)){
            criteria.add("B.HOSPITAL_NAME", OP.LIKE, hospital);
        }
        if(StringUtil.isNotEmpty(idCard)){
            criteria.add("P.IDCARD", idCard);
        }
        if(StringUtil.isNotEmpty(dateFrom) || StringUtil.isNotEmpty(dateTo)){
            DateUtil.getCriteriaByDateRange(criteria, "B.BLOOD_DATE", DateUtil.parseSimpleDate(dateFrom, null), DateUtil.parseSimpleDate(dateTo, null));
        }
        return criteria;
    }

	public Criteria getBloodDonorInfoCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("NAME", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("GENDER", gender);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("IDCARD", idcard);
		}
		if (StringUtil.isNotEmpty(bloodType)) {
			criteria.add("BLOOD_TYPE", bloodType);
		}
		if (StringUtil.isNotEmpty(aboBloodType)) {
			criteria.add("ABO_BLOOD_TYPE", aboBloodType);
		}
		return criteria;
	}

	public Criteria getReimbursementCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(patientname)) {
			criteria.add("PATIENTNAME", OP.LIKE, patientname);
		}
		if (StringUtil.isNotEmpty(patientidentitytype)) {
			criteria.add("PATIENTIDENTITYTYPE", patientidentitytype);
		}
		if (StringUtil.isNotEmpty(patientidentityid)) {
			criteria.add("PATIENTIDENTITYID", patientidentityid);
		}
		if (StringUtil.isNotEmpty(usetime)) {
			// criteria.add("USETIME", OP.LIKE,DateUtil.parseSimpleDate(usetime,
			// "yyyy/MM/dd"));
			DateUtil.getCriteriaByDateRange(criteria, "USETIME",
					DateUtil.parseSimpleDate(usetime, "yyyy/MM/dd"),
					DateUtil.parseSimpleDate(usetime, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(hospital)) {
			criteria.add("HOSPITAL", OP.LIKE, hospital);
		}
		return criteria;
	}

	public Criteria getBloodBankCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(abotype)) {
			criteria.add("abotype", abotype);
		}
        if (StringUtil.isNotEmpty(rhtype)) {
            if(rhtype.equals("阴")){
                String arrays[] = {"**D**","不详","未查",null};
                criteria.add("RHTYPE", OP.NOTIN ,arrays);
            }else if(rhtype.equals("阳")) {
                criteria.add("RHTYPE", OP.EQ ,"**D**");
            }else{
                criteria.add("RHTYPE", rhtype);
            }
        }
		if (StringUtil.isNotEmpty(dontime)) {
			// criteria.add("DONTIME", dontime);
			DateUtil.getCriteriaByDateRange(criteria, "DONTIME",
					DateUtil.parseSimpleDate(dontime, "yyyy/MM/dd"),
					DateUtil.parseSimpleDate(dontime, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(proctime)) {
			// criteria.add("PROCTIME", proctime);
			DateUtil.getCriteriaByDateRange(criteria, "PROCTIME",
					DateUtil.parseSimpleDate(proctime, "yyyy/MM/dd"),
					DateUtil.parseSimpleDate(proctime, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(exptime)) {
			// criteria.add("EXPTIME", exptime);
			DateUtil.getCriteriaByDateRange(criteria, "EXPTIME",
					DateUtil.parseSimpleDate(exptime, "yyyy/MM/dd"),
					DateUtil.parseSimpleDate(exptime, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(branch)) {
			criteria.add("BRANCH", branch);
		}
		return criteria;
	}

	public Criteria getBlood2HosCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(outtime)) {
			// criteria.add("OUTTIME", outtime);
			DateUtil.getCriteriaByDateRange(criteria, "OUTTIME",
					DateUtil.parseSimpleDate(outtime, "yyyy/MM/dd"),
					DateUtil.parseSimpleDate(outtime, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(procname)) {
			criteria.add("PROCNAME", procname);
		}
		if (StringUtil.isNotEmpty(abotype)) {
			criteria.add("ABOTYPE", abotype);
		}
		if (StringUtil.isNotEmpty(rhtype)) {
            if(rhtype.equals("阴")){
                String arrays[] = {"**D**","不详","未查",null};
                criteria.add("RHTYPE", OP.NOTIN ,arrays);
            }else if(rhtype.equals("阳")) {
                criteria.add("RHTYPE", OP.EQ ,"**D**");
            }else{
                criteria.add("RHTYPE", rhtype);
            }
		}
		if (StringUtil.isNotEmpty(hosname)) {
			criteria.add("HOSNAME", hosname);
		}
		return criteria;
	}

	public Criteria getAcceptEventCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(assignee)) {
			criteria.add("ASSIGNEE", OP.LIKE, assignee);
		}
		if (StringUtil.isNotEmpty(acceptType)) {
			criteria.add("ACCEPT_TYPE", acceptType);
		}
		if (StringUtil.isNotEmpty(beginTime) || StringUtil.isNotEmpty(endTime)) {
			DateUtil.getCriteriaByDateRange(criteria, "BEGIN_TIME",
					DateUtil.parseSimpleDate(beginTime, "yyyy/MM/dd"),
					DateUtil.parseSimpleDate(endTime, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(fromCall)) {
			criteria.add("FROM_CALL", OP.LIKE, fromCall);
		}
		if (StringUtil.isNotEmpty(patName)) {
			criteria.add("PAT_NAME", OP.LIKE, patName);
		}
		return criteria;
	}

	public Criteria getAmbulanceCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(busNo)) {
			criteria.add("BUS_NO", busNo);
		}
		if (StringUtil.isNotEmpty(driver)) {
			criteria.add("DRIVER", OP.LIKE, driver);
		}
		if (StringUtil.isNotEmpty(carTelphone)) {
			criteria.add("CAR_TELPHONE", OP.LIKE, carTelphone);
		}
		if (StringUtil.isNotEmpty(centerNo)) {
			criteria.add("CENTER_NO", centerNo);
		}
		return criteria;
	}

	public Criteria getCallEventCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(firstCall)) {
			criteria.add("FIRST_CALL", firstCall);
		}
		if (StringUtil.isNotEmpty(eventTitle)) {
			criteria.add("EVENT_TITLE", eventTitle);
		}
		if (StringUtil.isNotEmpty(firstDispatcher)) {
			criteria.add("FIRST_DISPATCHER", OP.LIKE, firstDispatcher);
		}
		return criteria;
	}

	public Criteria getTaskCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(carId)) {
			criteria.add("CAR_ID", carId);
		}
		if (StringUtil.isNotEmpty(stationNo)) {
			criteria.add("STATION_NO", stationNo);
		}
		if (StringUtil.isNotEmpty(sendToPlace)) {
			criteria.add("SEND_TO_PLACE", OP.LIKE, sendToPlace);
		}
		return criteria;
	}
}
