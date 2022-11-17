package com.founder.rhip.hsa.controller.insp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

/**
 * 
 * @author liuk
 * 
 */
public class QueryForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private String inspectionRecordPrefix = "HSA_INSPECTION_RECORD";
	private String locationInfoPrefix = "HSA_LOCATION_INFO";
	private String familyInfoPrefix = "familyInfo";
	private String startDate;
	private String endDate;
	private String createOrganCode;
	private String createDoctorName;
	private String inspPersonUnitCode;
	private String isGuide;
	private String isReport;
	private String gbcode;
	private String centerOrganCode;
	private String status;
	private String householderName;
	private String familyAddress;
	private String unitName;
	private String idcard;
	private String contactPhone;
	private String contact;
	private String townshipLotCode;
	private String healthProfessional;
	private String inspHealthProfessional;
	private String mainBusinessCode;
	private String locationStatus;
	private String guideCountType;
	private String inspCountType;
	private String personInCharge;
	private String dueDateType;
	private String inspPersonName;
	private String stationCode;

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getCenterOrganCode() {
		return centerOrganCode;
	}

	public void setCenterOrganCode(String centerOrganCode) {
		this.centerOrganCode = centerOrganCode;
	}

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();

		if (ObjectUtil.isNotEmpty(this.householderName)) {
			criteria.add(familyInfoPrefix + ".HOUSEHOLDER_NAME", OP.LIKE, householderName);
		}

		if (ObjectUtil.isNotEmpty(this.familyAddress)) {
			criteria.add(familyInfoPrefix + ".ADDRESS", OP.LIKE, familyAddress);
		}
		if (ObjectUtil.isNotEmpty(stationCode)) {
			criteria.add(inspectionRecordPrefix + ".CREATE_ORGAN_CODE", stationCode);
		}else if (ObjectUtil.isNotEmpty(centerOrganCode)) {
			Criteria cr = new Criteria();
			cr.add(inspectionRecordPrefix + ".CREATE_CENTER_ORGAN_CODE", centerOrganCode);
			cr.add(LOP.OR, inspectionRecordPrefix + ".CREATE_ORGAN_CODE", centerOrganCode);
			criteria.add(cr);
		} else if (ObjectUtil.isNotEmpty(gbcode)) {
			criteria.add(inspectionRecordPrefix + ".CREATE_GBCODE", gbcode);
		}
		
		if (StringUtil.isNotEmpty(inspPersonName)) {
			Criteria cr = new Criteria();
			cr.add(inspectionRecordPrefix + ".INSP_PERSON_NAME", OP.LIKE, inspPersonName);
			cr.add(LOP.OR, inspectionRecordPrefix + ".SEC_INSP_PERSON_NAME", OP.LIKE, inspPersonName);
			criteria.add(cr);
		}
		
		if (StringUtil.isNotEmpty(inspPersonUnitCode)) {
			criteria.add(locationInfoPrefix + ".UNIT_NAME", OP.LIKE, inspPersonUnitCode);
		}
		
		if (StringUtil.isNotEmpty(isGuide)) {
			criteria.add(inspectionRecordPrefix + ".IS_GUIDE", isGuide);
		}
		if (StringUtil.isNotEmpty(inspHealthProfessional)) {
			criteria.add(inspectionRecordPrefix + ".INSP_HEALTH_PROFESSIONAL", inspHealthProfessional);
		}
		if (StringUtil.isNotEmpty(isReport)) {
			criteria.add(inspectionRecordPrefix + ".IS_REPORT", isReport);
		}
		if (StringUtil.isNotEmpty(status)) {
			criteria.add("HSA_INSPECTION_RECORD.STATUS", status); 
		}
		if (ObjectUtil.isNotEmpty(startDate) && ObjectUtil.isNullOrEmpty(endDate)) {
			criteria.add(inspectionRecordPrefix + ".INSP_DATE", OP.GE, ConverToDate(startDate));
		} else if (ObjectUtil.isNullOrEmpty(startDate) && ObjectUtil.isNotEmpty(endDate)) {
			criteria.add(inspectionRecordPrefix + ".INSP_DATE", OP.LE, ConverToDate(endDate));
		} else if (ObjectUtil.isNotEmpty(startDate) && ObjectUtil.isNotEmpty(endDate)) {
			criteria.add(inspectionRecordPrefix + ".INSP_DATE", OP.BETWEEN, new Date[] { ConverToDate(startDate), ConverToDate(endDate) });
		}
		if (StringUtil.isNotEmpty(contactPhone)) {
			criteria.add("HSA_LOCATION_INFO.CONTACT_PHONE", OP.LIKE, contactPhone);
		}
		if (StringUtil.isNotEmpty(unitName)) {
			criteria.add("HSA_LOCATION_INFO.UNIT_NAME", OP.LIKE, unitName);
		}
		if (StringUtil.isNotEmpty(contact)) {
			criteria.add("HSA_LOCATION_INFO.CONTACT", OP.LIKE, contact);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("HSA_LOCATION_INFO.IDCARD", OP.LIKE, idcard);
		}
		if (ObjectUtil.isNotEmpty(townshipLotCode)) {
			criteria.add("HSA_LOCATION_INFO.TOWNSHIP_LOT_CODE", townshipLotCode);
		}
		
		if (StringUtil.isNotEmpty(healthProfessional)) {
			criteria.add(locationInfoPrefix + ".HEALTH_PROFESSIONAL",healthProfessional);
		}
		if (StringUtil.isNotEmpty(mainBusinessCode)) {
			criteria.add(locationInfoPrefix + ".MAIN_BUSINESS_CODE",  mainBusinessCode);
		}
		
		if (StringUtil.isNotEmpty(locationStatus)) {
			criteria.add(locationInfoPrefix + ".STATUS",  locationStatus);
		}
		
		if (StringUtil.isNotEmpty(personInCharge)) {
			Criteria cr = new Criteria();
			cr.add(locationInfoPrefix + ".PERSON_IN_CHARGE", OP.LIKE, personInCharge);
			cr.add(LOP.OR, locationInfoPrefix + ".LEGAL", OP.LIKE, personInCharge);
			criteria.add(cr);
		}
		
		if (StringUtil.isNotEmpty(dueDateType)) {
			Date current=new Date();
			switch (dueDateType) {
			case "1":
				current=DateUtil.add(current, Calendar.MONTH, 2);
				criteria.add(locationInfoPrefix + ".DUE_DATE",OP.GT, current);
				break;
			case "2":
				Date after=new Date();
				after=DateUtil.add(after, Calendar.MONTH, 2);
				after=DateUtil.makeTimeToMax(after);
				criteria.add(locationInfoPrefix + ".DUE_DATE",OP.BETWEEN, new Date[]{current,after});
				break;
			case "3":
				Date after1=new Date();
				after1=DateUtil.add(after1, Calendar.MONTH, 1);
				after1=DateUtil.makeTimeToMax(after1);
				criteria.add(locationInfoPrefix + ".DUE_DATE",OP.BETWEEN, new Date[]{current,after1});
				break;
			case "4":
				criteria.add(locationInfoPrefix + ".DUE_DATE",OP.LT, current);
				break;
			default:
				break;
			}
		}
		
		if (StringUtil.isNotEmpty(guideCountType)) {
			criteria.add(locationInfoPrefix + ".GUIDE_COUNT_TYPE",  guideCountType);
		}
		if (StringUtil.isNotEmpty(inspCountType)) {
			criteria.add(locationInfoPrefix + ".INSP_COUNT_TYPE",  inspCountType);
		}
		
		return criteria;
	}

	// 把字符串转为日期
	public static Date ConverToDate(String strDate) {
		Date date = null;
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		try {
			date = df.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public String getInspPersonUnitCode() {
		return inspPersonUnitCode;
	}

	public void setInspPersonUnitCode(String inspPersonUnitCode) {
		this.inspPersonUnitCode = inspPersonUnitCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCreateOrganCode() {
		return createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public String getCreateDoctorName() {
		return createDoctorName;
	}

	public void setCreateDoctorName(String createDoctorName) {
		this.createDoctorName = createDoctorName;
	}

	public String getIsGuide() {
		return isGuide;
	}

	public void setIsGuide(String isGuide) {
		this.isGuide = isGuide;
	}

	public String getIsReport() {
		return isReport;
	}

	public void setIsReport(String isReport) {
		this.isReport = isReport;
	}

	public String getInspectionRecordPrefix() {
		return inspectionRecordPrefix;
	}

	public void setInspectionRecordPrefix(String inspectionRecordPrefix) {
		this.inspectionRecordPrefix = inspectionRecordPrefix;
	}

	public String getLocationInfoPrefix() {
		return locationInfoPrefix;
	}

	public void setLocationInfoPrefix(String locationInfoPrefix) {
		this.locationInfoPrefix = locationInfoPrefix;
	}

	public String getFamilyInfoPrefix() {
		return familyInfoPrefix;
	}

	public void setFamilyInfoPrefix(String familyInfoPrefix) {
		this.familyInfoPrefix = familyInfoPrefix;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHouseholderName() {
		return householderName;
	}

	public void setHouseholderName(String householderName) {
		this.householderName = householderName;
	}

	public String getFamilyAddress() {
		return familyAddress;
	}

	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTownshipLotCode() {
		return townshipLotCode;
	}

	public void setTownshipLotCode(String townshipLotCode) {
		this.townshipLotCode = townshipLotCode;
	}


	public String getLocationStatus() {
		return locationStatus;
	}

	public void setLocationStatus(String locationStatus) {
		this.locationStatus = locationStatus;
	}


	public String getMainBusinessCode() {
		return mainBusinessCode;
	}

	public void setMainBusinessCode(String mainBusinessCode) {
		this.mainBusinessCode = mainBusinessCode;
	}

	public String getHealthProfessional() {
		return healthProfessional;
	}

	public void setHealthProfessional(String healthProfessional) {
		this.healthProfessional = healthProfessional;
	}

	public String getGuideCountType() {
		return guideCountType;
	}

	public void setGuideCountType(String guideCountType) {
		this.guideCountType = guideCountType;
	}

	public String getInspCountType() {
		return inspCountType;
	}

	public void setInspCountType(String inspCountType) {
		this.inspCountType = inspCountType;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getDueDateType() {
		return dueDateType;
	}

	public void setDueDateType(String dueDateType) {
		this.dueDateType = dueDateType;
	}

	public String getInspHealthProfessional() {
		return inspHealthProfessional;
	}

	public void setInspHealthProfessional(String inspHealthProfessional) {
		this.inspHealthProfessional = inspHealthProfessional;
	}

	public String getInspPersonName() {
		return inspPersonName;
	}

	public void setInspPersonName(String inspPersonName) {
		this.inspPersonName = inspPersonName;
	}

}
