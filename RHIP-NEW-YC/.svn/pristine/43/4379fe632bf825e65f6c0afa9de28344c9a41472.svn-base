package com.founder.rhip.hm.controller.form;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class StudentExamQueryForm {
	
	private String idcard;
	
	private String name;
	
	private String gender;
	
	private String type;
	
	private String schoolCode;
	
	private String gradeCode;
	
	private String classCode;
	
	private int status;
	
	private Date beginDate;
	
	private Date endDate;
	
	private String year;

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("idcard", OP.LIKE, idcard);
		}
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("gender", gender);
		}
		if (StringUtil.isNotEmpty(type)) {
			criteria.add("type", type);
		}		
		if (StringUtil.isNotEmpty(schoolCode)) {
			criteria.add("schoolCode", schoolCode);
		}
		if (StringUtil.isNotEmpty(gradeCode)) {
			criteria.add("gradeCode", gradeCode);
		}
		if (StringUtil.isNotEmpty(classCode)) {
			criteria.add("classCode", classCode);
		}
		if (ObjectUtil.isNotEmpty(beginDate)) {
			if (ObjectUtil.isNotEmpty(endDate)) {
				criteria.add("examDate", OP.BETWEEN, new Date[]{beginDate, endDate});
			} else {
				criteria.add("examDate", OP.GE, beginDate);
			}
		} else if (ObjectUtil.isNotEmpty(endDate)) {
			criteria.add("examDate", OP.LE, endDate);
		} else {
			if (status == 1) {
				criteria.add("examDate", OP.IS , "NULL");
			} else if (status == 2) {
				criteria.add("examDate", OP.IS , "NOT NULL");
				criteria.add("printDate", OP.IS , "NULL");
			}
		}
		if (status == 3) {
			criteria.add("printDate", OP.IS , "NOT NULL");
		}
		if (StringUtil.isNotEmpty(year)) {
			criteria.add("year", year);
		}
		return criteria;
	}

	public Criteria getProgressCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(type)) {
			criteria.add("type", type);
		}		
		if (StringUtil.isNotEmpty(schoolCode)) {
			criteria.add("schoolCode",OP.IN,new String[]{ schoolCode});
			criteria.add("S.SCHOOL_CODE",OP.IN,new String[]{ schoolCode});
		}	
		return criteria;		
	}
	
	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
