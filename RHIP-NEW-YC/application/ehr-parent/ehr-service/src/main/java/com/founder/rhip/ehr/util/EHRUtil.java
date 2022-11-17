package com.founder.rhip.ehr.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.mdm.entity.Person;

public class EHRUtil {

	private final static String EHREVENT_SERIAL_NUMBER = "XXXXXX";

	/**
	 * 根据平台中的人员对象组装MDM中的人员对象
	 * 
	 * @param personInfo
	 * @return person
	 */
	public static Person getPersonFromPersonInfo(PersonInfo personInfo) {
		Person person = new Person();
		person.setDomainId("ehr.01");
		person.setIdCard(personInfo.getIdcard());
        if(StringUtil.isNotEmpty(personInfo.getBabyCardNo())) {
            person.setOtherCardNo(personInfo.getBabyCardNo());
        }else {
            person.setOtherCardNo(personInfo.getOtherIdcard());
        }

		person.setLocalId(personInfo.getId().toString());
		person.setHealthFileNo(personInfo.getHealthFileNo());
		person.setName(personInfo.getName());
		person.setBirthday(personInfo.getBirthday());
		person.setNation(personInfo.getNation());
		person.setGender(personInfo.getGender());
		person.setOccupation(personInfo.getOccupation());
		person.setMarriage(personInfo.getMarriage());
		person.setEducation(personInfo.getEducation());
		person.setPhoneNumber(personInfo.getPhoneNumber());
		person.setGbCode(personInfo.getGBCode());
		person.setHrCity(personInfo.getHrcity());
		person.setHrTownship(personInfo.getHrtownShip());
		person.setHrStreet(personInfo.getHrstreet());
		person.setHrHouseNumber(personInfo.getHrhouseNumber());
		person.setPaProvince(personInfo.getPaprovince());
		person.setPaCity(personInfo.getPacity());
		person.setPaTownship(personInfo.getPatownShip());
		person.setPaStreet(personInfo.getPastreet());
		person.setPaHouseNumber(personInfo.getPahouseNumber());
		person.setPaPostcode(personInfo.getPapostCode());
		person.setUnitName(personInfo.getUnitName());
		person.setUnitPhone(personInfo.getUnitPhone());

		person.setUpdatePerson(personInfo.getUpdateName());
		person.setUpdateIdcard(personInfo.getUpdateIdcard());
		person.setUpdateTime(getOperatorTime(personInfo.getUpdateDate()));
		person.setUpdateOrganCode(personInfo.getUpdateOrganCode());
		person.setUpdateOrganName(personInfo.getUpdateOrganName());
		return person;
	}
	
	public static Person getPersonFromPersonInfoForIntegrateData(PersonInfo personInfo) {
		Person person = new Person();
		person.setDomainId(personInfo.getDomainId());
		person.setIdCard(personInfo.getIdcard());
		person.setLocalId(personInfo.getLocalId());
		person.setHealthFileNo(personInfo.getHealthFileNo());
		person.setName(personInfo.getName());
		person.setBirthday(personInfo.getBirthday());
		person.setNation(personInfo.getNation());
		person.setGender(personInfo.getGender());
		person.setOccupation(personInfo.getOccupation());
		person.setMarriage(personInfo.getMarriage());
		person.setEducation(personInfo.getEducation());
		person.setPhoneNumber(personInfo.getPhoneNumber());
		person.setGbCode(personInfo.getGBCode());
		person.setHrCity(personInfo.getHrcity());
		person.setHrTownship(personInfo.getHrtownShip());
		person.setHrStreet(personInfo.getHrstreet());
		person.setHrHouseNumber(personInfo.getHrhouseNumber());
		person.setPaProvince(personInfo.getPaprovince());
		person.setPaCity(personInfo.getPacity());
		person.setPaTownship(personInfo.getPatownShip());
		person.setPaStreet(personInfo.getPastreet());
		person.setPaHouseNumber(personInfo.getPahouseNumber());
		person.setPaPostcode(personInfo.getPapostCode());
		person.setUnitName(personInfo.getUnitName());
		person.setUnitPhone(personInfo.getUnitPhone());

		person.setUpdatePerson(personInfo.getUpdateName());
		person.setUpdateIdcard(personInfo.getUpdateIdcard());
		person.setUpdateTime(getOperatorTime(personInfo.getUpdateDate()));
		person.setUpdateOrganCode(personInfo.getUpdateOrganCode());
		person.setUpdateOrganName(personInfo.getUpdateOrganName());
		return person;
	}

	public static String[] getMDMParameter(String[] params) {
		if (null == params)
			return null;
		List<String> mdmParam = new ArrayList<>();
		for (String param : params) {
			if (param.equalsIgnoreCase("name"))
				mdmParam.add("name");
			if (param.equalsIgnoreCase("gender"))
				mdmParam.add("gender");
			if (param.equalsIgnoreCase("birthday"))
				mdmParam.add("birthday");
			if (param.equalsIgnoreCase("marriage"))
				mdmParam.add("marriage");
			if (param.equalsIgnoreCase("nation"))
				mdmParam.add("nation");
			if (param.equalsIgnoreCase("occupation"))
				mdmParam.add("occupation");
			if (param.equalsIgnoreCase("gBCode"))
				mdmParam.add("gbCode");
			if (param.equalsIgnoreCase("education"))
				mdmParam.add("education");
			if (param.equalsIgnoreCase("unitName"))
				mdmParam.add("unitName");
			if (param.equalsIgnoreCase("unitPhone"))
				mdmParam.add("unitPhone");
			if (param.equalsIgnoreCase("phoneNumber"))
				mdmParam.add("phoneNumber");
			if (param.equalsIgnoreCase("hrcity"))
				mdmParam.add("hrCity");
			if (param.equalsIgnoreCase("hrtownShip"))
				mdmParam.add("hrTownship");
			if (param.equalsIgnoreCase("hrstreet"))
				mdmParam.add("hrStreet");
			if (param.equalsIgnoreCase("hrhouseNumber"))
				mdmParam.add("hrHouseNumber");
			if (param.equalsIgnoreCase("paprovince"))
				mdmParam.add("paProvince");
			if (param.equalsIgnoreCase("pacity"))
				mdmParam.add("paCity");
			if (param.equalsIgnoreCase("patownShip"))
				mdmParam.add("paTownship");
			if (param.equalsIgnoreCase("pastreet"))
				mdmParam.add("paStreet");
			if (param.equalsIgnoreCase("pahouseNumber"))
				mdmParam.add("paHouseNumber");
			if (param.equalsIgnoreCase("papostCode"))
				mdmParam.add("paPostcode");
			if (param.equalsIgnoreCase("updateDate"))
				mdmParam.add("updateTime");
			if (param.equalsIgnoreCase("updateName"))
				mdmParam.add("updatePerson");
			if (param.equalsIgnoreCase("updateIdcard"))
				mdmParam.add("updateIdcard");
			if (param.equalsIgnoreCase("updateOrganCode"))
				mdmParam.add("updateOrganCode");
			if (param.equalsIgnoreCase("updateOrganName"))
				mdmParam.add("updateOrganName");
		}
		return mdmParam.toArray(new String[mdmParam.size()]);
	}

	/**
	 * 根据平台中的人员对象集合组装MDM中的人员对象集合
	 * 
	 * @param personInfoList
	 * @return returnList
	 */
	public static List<Person> getPersonListFromPersonInfoList(List<PersonInfo> personInfoList) {
		List<Person> returnList = new ArrayList<Person>();
		for (PersonInfo personInfo : personInfoList) {
			if (personInfo.getSmpiId() == null)
				returnList.add(getPersonFromPersonInfo(personInfo));
		}
		return returnList;
	}

	/**
	 * 根据日期生成14位流水号 yyyyMMdd + XXXXXX
	 * 
	 * @param date
	 *            事件日期 如果为空则为当前日期
	 * @param sno
	 *            事件流水号 如果为空则为000001开始
	 * @return
	 */
	public static synchronized String getEHREvent(Date date, String sno) {
		String id = null;
		if (date == null)
			date = new Date();
		if (sno == null) {
			id = DateUtil.getDateTime("yyyyMMdd", date) + "000001";
		} else {
			int count = EHREVENT_SERIAL_NUMBER.length();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < count; i++) {
				sb.append("0");
			}
			DecimalFormat df = new DecimalFormat("000000");
			id = DateUtil.getDateTime("yyyyMMdd", date) + df.format(1 + Integer.parseInt(sno.substring(8, 14)));
		}
		return id;
	}

	private static Long getOperatorTime(Date date) {
		if (null == date) {
			return null;
		}
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return Long.parseLong(sf.format(date));
	}

	public static void main(String[] args) {
		System.out.print(getEHREvent(null, "20130415101999"));
	}
}
