package com.founder.rhip.cdm.controller.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liuk
 * 
 */
public class QueryForm implements Serializable {
	private static final long serialVersionUID = -8257725460816520198L;
	private String year;
	private String timeType;
	private String gender;
	private String disType;
	private String currentMonth;
	private String currentSeason;
	private String currentYear;
	private String organCode;
	private String gbCode;
	private String yearMonth;
	private String season;
	private String beginDate;
	private String endDate;

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if ("2".equals(timeType)) {
			Date[] rangeDates = new Date[] { getStart(), getEnd() };
			if (EHRConstants.DM_TUMOR_TYPE.equals(disType)) {
				criteria.add("TUMOR_DIAGNOSIS_DATE", OP.BETWEEN, rangeDates);
			} else {
				Criteria orCriteria = new Criteria();
				orCriteria.add(LOP.OR, "HBP_DIAGNOSIS_DATE", OP.BETWEEN, rangeDates);
				orCriteria.add(LOP.OR, "DI_DIAGNOSIS_DATE", OP.BETWEEN, rangeDates);
				orCriteria.add(LOP.OR, "STROKE_DIAGNOSIS_DATE", OP.BETWEEN, rangeDates);
				orCriteria.add(LOP.OR, "CORONARY_DIAGNOSIS_DATE", OP.BETWEEN, rangeDates);
				criteria.add(orCriteria);
			}
		} else {
			criteria.add("CREATE_DATE", OP.BETWEEN, new Date[] { getStart(), getEnd() });
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("GENDER", gender);
		}
		return criteria;
	}

	private Date getStart() {
		Calendar beginDate = Calendar.getInstance();
		beginDate.set(Calendar.YEAR, Integer.parseInt(currentYear));
		beginDate.set(Calendar.MONTH, Calendar.JANUARY);
		beginDate.set(Calendar.DAY_OF_MONTH, 1);
		DateUtil.makeTimeToZero(beginDate);
		return beginDate.getTime();
	}

	private Date getEnd() {
		Calendar endDate = Calendar.getInstance();
		endDate.set(Calendar.YEAR, Integer.parseInt(currentYear));
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
				this.currentYear = yearMonth.substring(0, index);
				this.currentMonth =yearMonth.substring(index + 1);
                if (this.currentMonth.startsWith("0")){
                    this.currentMonth=currentMonth.substring(1);
                }
			} else {
				Calendar calendar = Calendar.getInstance();
				this.currentYear =String.valueOf(calendar.get(Calendar.YEAR));
				this.currentMonth = String.valueOf(calendar.get(Calendar.MONTH) +1);
			}
		}else{
            Calendar calendar = Calendar.getInstance();
            this.currentYear = String.valueOf(calendar.get(Calendar.YEAR));
            this.currentMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        }
		this.yearMonth = yearMonth;
	}

	public String getCurrentMonth() {
		return currentMonth;
	}

	public void setCurrentMonth(String currentMonth) {
		this.currentMonth = currentMonth;
	}

	public String getCurrentSeason() {
		return currentSeason;
	}

	public void setCurrentSeason(String currentSeason) {
		this.currentSeason = currentSeason;
	}

	public String getCurrentYear() {
		return currentYear;
	}

	public void setCurrentYear(String currentYear) {
		this.currentYear = currentYear;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		if (ObjectUtil.isNotEmpty(year)) {
			this.currentYear = year;
		} else {
			this.currentYear =String.valueOf(DateUtil.getCurrentYear());
		}
        this.year=this.currentYear;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		if (ObjectUtil.isNullOrEmpty(season)) {
			this.currentSeason = "1";
		} else {
			this.currentSeason = season;
		}
        this.season=this.currentSeason;
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

}
