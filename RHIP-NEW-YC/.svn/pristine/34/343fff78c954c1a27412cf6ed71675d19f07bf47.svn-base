package com.founder.rhip.hsa.controller.insp;

import java.util.Calendar;
import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class ReportQueryForm {
	private String year;
	private String timeType;
	private String gender;
	private String disType;
	private int currentMonth;
	private int currentSeason;
	private int currentYear;
	private String organCode;
	private String gbCode;
	private String yearMonth;
	private String season;
	private String beginDate;
	private String endDate;

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();

		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("GENDER", gender);
		}
		return criteria;
	}

	@SuppressWarnings("unused")
	private Date getStart() {
		Calendar beginDate = Calendar.getInstance();
		beginDate.set(Calendar.YEAR, currentYear);
		beginDate.set(Calendar.MONTH, Calendar.JANUARY);
		beginDate.set(Calendar.DAY_OF_MONTH, 1);
		DateUtil.makeTimeToZero(beginDate);
		return beginDate.getTime();
	}

	@SuppressWarnings("unused")
	private Date getEnd() {
		Calendar endDate = Calendar.getInstance();
		endDate.set(Calendar.YEAR, currentYear);
		endDate.set(Calendar.MONTH, Calendar.DECEMBER);
		endDate.set(Calendar.DAY_OF_MONTH, 31);
		DateUtil.makeTimeToMax(endDate);
		return endDate.getTime();
	}

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		if (ObjectUtil.isNotEmpty(yearMonth)) {
			int index = yearMonth.indexOf("/");
			if (index != -1) {
				this.currentYear = Integer.parseInt(yearMonth.substring(0, index));
				this.currentMonth = Integer.parseInt(yearMonth.substring(index + 1));
			} else {
				Calendar calendar = Calendar.getInstance();
				this.currentYear = calendar.get(Calendar.YEAR);
				this.currentMonth = calendar.get(Calendar.MONTH) + 1;
			}
		}
		this.yearMonth = yearMonth;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		if (ObjectUtil.isNotEmpty(year)) {
			this.currentYear = Integer.parseInt(year);
		} else {
			this.currentYear = DateUtil.getCurrentYear();
			year = String.valueOf(this.currentYear);
		}
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		if (ObjectUtil.isNullOrEmpty(season)) {
			this.currentSeason = 1;
		} else {
			this.currentSeason = Integer.parseInt(season);
		}
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(int currentMonth) {
		this.currentMonth = currentMonth;
	}

	public int getCurrentSeason() {
		return currentSeason;
	}

	public void setCurrentSeason(int currentSeason) {
		this.currentSeason = currentSeason;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}

}
