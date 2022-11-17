
package com.founder.rhip.hm.controller.form;

import java.util.Calendar;
import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class HealthManageQueryForm {

	private String examYear;
	
	private String beginTime;
	
	private String endTime;

	private String examNumber;

	private String name;

	private String idcard;

	private String gender;
	
	private String orgCode;

	private String inputSuperOrganCode;

	private String inputOrganCode;

	private String healthGuideStatus;

	private String examStatus;

	private String gbcode;

	private Integer confirm;

	private Integer beginAge;

	private Integer endAge;
	
	private String paymentPatternCode;

	private String estimateStatus;
	
	private Date startDate;
	
	private Date endDate;

	private String selectCodeType;
	
	private String organCode;
	
	private String logoff;

	private String townCode;

	private String centerCode;

	private String stationCode;
	
	private String examinationDateStart;
	
	private String examinationDateEnd;
	
	private String criterionExamination;
	
	private String searchPastreet;
	private String searchPatownShip;
	private String genreCode;//统计类型  1机构  2现地址
	private String rangeType;//时间类型  1按月  2按季度 3按年 4按时间段
	private String monthDate;
	private Integer quarterDate;//季度年份
	private Integer rangeQuarter;//季度
	//按年类型：全年、上半年、下半年
	private String yearType;
	private Integer yearDate;
	private String patownShip;//现地址-镇
	private String pastreet;//现地址-居委会
	

	public String getExaminationDateStart() {
		return examinationDateStart;
	}

	public void setExaminationDateStart(String examinationDateStart) {
		this.examinationDateStart = examinationDateStart;
	}

	public String getExaminationDateEnd() {
		return examinationDateEnd;
	}

	public void setExaminationDateEnd(String examinationDateEnd) {
		this.examinationDateEnd = examinationDateEnd;
	}

	public String getExamYear() {
		return examYear;
	}

	public void setExamYear(String examYear) {
		this.examYear = examYear;
	}

	public String getExamNumber() {
		return examNumber;
	}

	public void setExamNumber(String examNumber) {
		this.examNumber = examNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public String getHealthGuideStatus() {
		return healthGuideStatus;
	}

	public void setHealthGuideStatus(String healthGuideStatus) {
		this.healthGuideStatus = healthGuideStatus;
	}

	public String getExamStatus() {
		return examStatus;
	}

	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}

	public String getInputSuperOrganCode() {
		return inputSuperOrganCode;
	}

	public void setInputSuperOrganCode(String inputSuperOrganCode) {
		this.inputSuperOrganCode = inputSuperOrganCode;
	}

	
	public String getGbcode() {
		return gbcode;
	}

	
	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public Integer getConfirm() {
		return confirm;
	}

	public void setConfirm(Integer confirm) {
		this.confirm = confirm;
	}

	public Integer getBeginAge() {
		return beginAge;
	}

	public void setBeginAge(Integer beginAge) {
		this.beginAge = beginAge;
	}

	public Integer getEndAge() {
		return endAge;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
	}

	public String getPaymentPatternCode() {
		return paymentPatternCode;
	}

	public void setPaymentPatternCode(String paymentPatternCode) {
		this.paymentPatternCode = paymentPatternCode;
	}

	public String getEstimateStatus() {
		return estimateStatus;
	}

	public void setEstimateStatus(String estimateStatus) {
		this.estimateStatus = estimateStatus;
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

	public String getTownCode() {
		return townCode;
	}

	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}

	public Criteria statisticCriteria(){
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(examYear)) {
			Date beginDate = DateUtil.parseSimpleDate(examYear + "/01/01", null);
			Date endDate = DateUtil.parseSimpleDate(examYear + "/12/31", null);
			DateUtil.getCriteriaByDateRange(criteria, "examYear", beginDate,endDate);  
		}
		if (StringUtil.isNotEmpty(orgCode)) {
			criteria.add("orgCode", orgCode);
		}
		
		return criteria;
	}
	
	public Criteria toCriteriaNew() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(examYear)) {
			Calendar endDate = Calendar.getInstance();
			endDate.set(Calendar.YEAR, Integer.parseInt(examYear));
			endDate.set(Calendar.MONTH, Calendar.DECEMBER);
			endDate.set(Calendar.DAY_OF_MONTH, 31);
			
			criteria.add("examYear",OP.LE,DateUtil.lastTimeOfDay(endDate.getTime()));
			criteria.add("examYearStr",examYear);
		}
		
		if (StringUtil.isNotEmpty(orgCode)) {
			criteria.add("orgCode", orgCode);
		}
		if (StringUtil.isNotEmpty(beginTime)) {
			criteria.add("beginTime", beginTime);
		}
		if (StringUtil.isNotEmpty(endTime)) {
			criteria.add("endTime", endTime);
		}
		if (StringUtil.isNotEmpty(examNumber)) {
			criteria.add("examNumber", examNumber);
		}
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("idcard", idcard.toUpperCase());
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("gender", gender);
		}
		if (StringUtil.isNotEmpty(paymentPatternCode)) {
			criteria.add("paymentPatternCode", paymentPatternCode);
		}
		if (StringUtil.isNotEmpty(inputOrganCode)) {
			criteria.add("inputOrganCode", inputOrganCode);
		}
		if (StringUtil.isNotEmpty(inputSuperOrganCode)) {
			criteria.add("inputSuperOrganCode", inputSuperOrganCode);
		}
		if (StringUtil.isNotEmpty(gbcode)) {
			criteria.add("gbcode", gbcode);
		}
		if (StringUtil.isNotEmpty(healthGuideStatus)) {
			criteria.add("healthGuideStatus", healthGuideStatus);
		}
		if (StringUtil.isNotEmpty(examStatus)) {
			criteria.add("examStatus", examStatus);
		}
		if (ObjectUtil.isNotEmpty(confirm)) {
			criteria.add("confirm", confirm);
		}
		if (ObjectUtil.isNotEmpty(logoff)) {
			criteria.add("logoff", logoff);
		}
		if (ObjectUtil.isNotEmpty(estimateStatus)) {
			criteria.add("estimateStatus", estimateStatus);
		}
		if (ObjectUtil.isNotEmpty(beginAge) && ObjectUtil.isNotEmpty(endAge)) {
			Calendar beginDate = Calendar.getInstance();
			beginDate.add(Calendar.YEAR, -endAge);
			beginDate.set(Calendar.MONTH, Calendar.JANUARY);
			beginDate.set(Calendar.DAY_OF_MONTH, 1);
			
			Calendar endDate = Calendar.getInstance();
			endDate.add(Calendar.YEAR, -beginAge);
			endDate.set(Calendar.MONTH, Calendar.DECEMBER);
			endDate.set(Calendar.DAY_OF_MONTH, 31);
			//System.out.println("beginDate:"+beginDate.getTime() +",endDate:"+endDate.getTime());
			criteria.add("birthday", OP.BETWEEN, new Date[] {beginDate.getTime(), endDate.getTime()});
		}
    	if(StringUtil.isNotEmpty(organCode)){
        	switch(selectCodeType){
         		case "B1"://中心
         			Criteria cri = new Criteria("inputSuperOrganCode",organCode);;
         			cri.add(LOP.OR, "inputOrganCode",organCode);
         			criteria.add(cri);
        			break;
        		case "0"://镇
        			criteria.add("gbcode",organCode);
        			break;
        		default:
        			criteria.add("inputOrganCode",organCode);
        	}    		
    	}	
    	if (ObjectUtil.isNotEmpty(criterionExamination)) {
			criteria.add("criterionExamination", criterionExamination);
		}
    	if (ObjectUtil.isNotEmpty(searchPastreet)) {
			criteria.add("pastreet", searchPastreet);
		}else if (ObjectUtil.isNotEmpty(searchPatownShip)) {
			criteria.add("patown_ship", searchPatownShip);
		}
    	
    	if (ObjectUtil.isNotEmpty(patownShip)) {
			criteria.add("patownShip", patownShip);
		}
    	if (ObjectUtil.isNotEmpty(pastreet)) {
			criteria.add("pastreet", pastreet);
    	}
		return criteria;
	}
	
	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		organizeTime();
		if (StringUtil.isNotEmpty(examYear)) {
			Calendar endDate = Calendar.getInstance();
			endDate.set(Calendar.YEAR, Integer.parseInt(examYear));
			endDate.set(Calendar.MONTH, Calendar.DECEMBER);
			endDate.set(Calendar.DAY_OF_MONTH, 31);
			
			criteria.add("record.exam_Year", OP.LE,DateUtil.lastTimeOfDay(endDate.getTime()));
		}
		if (StringUtil.isNotEmpty(orgCode)) {
			criteria.add("inputOrganCode", orgCode);
		}
		if (StringUtil.isNotEmpty(beginTime)) {
			criteria.add("beginTime", beginTime);
		}
		if (StringUtil.isNotEmpty(endTime)) {
			criteria.add("endTime", endTime);
		}
		if (StringUtil.isNotEmpty(examNumber)) {
			criteria.add("examNumber", examNumber);
		}
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("idcard", idcard.toUpperCase());
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("gender", gender);
		}
		if (StringUtil.isNotEmpty(paymentPatternCode)) {
			criteria.add("paymentPatternCode", paymentPatternCode);
		}
		if (StringUtil.isNotEmpty(inputOrganCode)) {
			criteria.add("inputOrganCode", inputOrganCode);
		}
		if (StringUtil.isNotEmpty(inputSuperOrganCode)) {
			criteria.add("inputSuperOrganCode", inputSuperOrganCode);
		}
		if (StringUtil.isNotEmpty(gbcode)) {
			criteria.add("gbcode", gbcode);
		}
		if (StringUtil.isNotEmpty(townCode)) {
			criteria.add("gbcode", townCode);
		}
		if (StringUtil.isNotEmpty(centerCode)) {
			criteria.add("centerCode", centerCode);
		}
		if (StringUtil.isNotEmpty(orgCode)) {
			criteria.add("orgCode", orgCode);
		}
		if (StringUtil.isNotEmpty(healthGuideStatus)) {
			criteria.add("healthGuideStatus", healthGuideStatus);
		}
		if (StringUtil.isNotEmpty(examStatus)) {
			criteria.add("examStatus", examStatus);
		}
		if (ObjectUtil.isNotEmpty(confirm)) {
			criteria.add("confirm", confirm);
		}
		if (ObjectUtil.isNotEmpty(logoff)) {
			criteria.add("logoff", logoff);
		}
		if (ObjectUtil.isNotEmpty(estimateStatus)) {
			criteria.add("estimateStatus", estimateStatus);
		}
		if (ObjectUtil.isNotEmpty(beginAge) && ObjectUtil.isNotEmpty(endAge)) {
			Calendar beginDate = Calendar.getInstance();
			beginDate.add(Calendar.YEAR, -endAge);
			beginDate.set(Calendar.MONTH, Calendar.JANUARY);
			beginDate.set(Calendar.DAY_OF_MONTH, 1);
			
			Calendar endDate = Calendar.getInstance();
			endDate.add(Calendar.YEAR, -beginAge);
			endDate.set(Calendar.MONTH, Calendar.DECEMBER);
			endDate.set(Calendar.DAY_OF_MONTH, 31);
			//System.out.println("beginDate:"+beginDate.getTime() +",endDate:"+endDate.getTime());
			criteria.add("birthday", OP.BETWEEN, new Date[] {beginDate.getTime(), endDate.getTime()});
		}
    	if(StringUtil.isNotEmpty(organCode)){
        	switch(selectCodeType){
         		case "B1"://中心
         			criteria.add("inputSuperOrganCode",organCode);
        			break;
        		case "0"://镇
        			criteria.add("gbcode",organCode);
        			break;
        		default:
        			criteria.add("inputOrganCode",organCode);
        	}    		
    	}	
    	if (ObjectUtil.isNotEmpty(criterionExamination)) {
			criteria.add("criterionExamination", criterionExamination);
		}
    	if (ObjectUtil.isNotEmpty(searchPastreet)) {
			criteria.add("pastreet", searchPastreet);
		}else if (ObjectUtil.isNotEmpty(searchPatownShip)) {
			criteria.add("patown_ship", searchPatownShip);
		}
    	if (ObjectUtil.isNotEmpty(patownShip)) {
			criteria.add("patownShip", patownShip);
		}
    	if (ObjectUtil.isNotEmpty(pastreet)) {
			criteria.add("pastreet", pastreet);
		}
		return criteria;
	}
	
    private void organizeTime(){
        if(StringUtil.isNotEmpty(this.rangeType)){
            switch (this.rangeType){
                case "1"://按月
                    if(StringUtil.isNullOrEmpty(monthDate)){
                        this.monthDate = DateUtil.getDateTime("yyyy/MM", new Date());
                    }
                    Date tempDate = DateUtil.parseSimpleDate(this.monthDate, "yyyy/MM");
                    this.beginTime = this.monthDate + "/01";
                    this.endTime = DateUtil.getDateTime("yyyy/MM/dd", DateUtil.lastDateOfMonth(tempDate));
                    break;
                case "2"://按季度
                    if(ObjectUtil.isNullOrEmpty(quarterDate)){
                        this.quarterDate = DateUtil.getCurrentYear();
                    }
                    Calendar c = Calendar.getInstance();
                    Date quarterMonth[] = DateUtil.getDateRangeBySeason(rangeQuarter);
                    c.setTime(quarterMonth[0]);
                    c.set(Calendar.YEAR, this.quarterDate);
                    this.beginTime = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());
                    c.setTime(quarterMonth[1]);
                    c.set(Calendar.YEAR, this.quarterDate);
                    this.endTime = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());
                    break;
                case "3"://按年
                    if(ObjectUtil.isNullOrEmpty(yearDate)){
                        this.yearDate = DateUtil.getCurrentYear();
                    }
                    switch(this.yearType){
                        case "1"://全年
                            this.beginTime = yearDate + "/01/01";
                            this.endTime =  yearDate + "/12/31";
                            break;
                        case "2"://上半年
                            this.beginTime = yearDate + "/01/01";
                            this.endTime =  yearDate + "/06/30";
                            break;
                        case "3"://下半年
                            this.beginTime = yearDate + "/07/01";
                            this.endTime =  yearDate + "/12/31";
                            break;
                    }
                    break;
            }
        }
    }
    
    public void setYearDate(){
        if(ObjectUtil.isNullOrEmpty(yearDate)){
            this.yearDate = DateUtil.getCurrentYear();
        }
        this.beginTime = yearDate + "/01/01";
        this.endTime =  yearDate + "/12/31";
    }
	
	public Date getStartDate() {
		return startDate;
	}

	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
	public Date getEndDate() {
		return endDate;
	}

	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	public String getOrgCode() {
		return orgCode;
	}

	
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getSelectCodeType() {
		return selectCodeType;
	}

	public void setSelectCodeType(String selectCodeType) {
		this.selectCodeType = selectCodeType;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getLogoff() {
		return logoff;
	}

	public void setLogoff(String logoff) {
		this.logoff = logoff;
	}

	public String getCriterionExamination() {
		return criterionExamination;
	}

	public void setCriterionExamination(String criterionExamination) {
		this.criterionExamination = criterionExamination;
	}

	public String getSearchPastreet() {
		return searchPastreet;
	}

	public void setSearchPastreet(String searchPastreet) {
		this.searchPastreet = searchPastreet;
	}

	public String getSearchPatownShip() {
		return searchPatownShip;
	}

	public void setSearchPatownShip(String searchPatownShip) {
		this.searchPatownShip = searchPatownShip;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getRangeType() {
		return rangeType;
	}

	public void setRangeType(String rangeType) {
		this.rangeType = rangeType;
	}

	public String getMonthDate() {
		return monthDate;
	}

	public void setMonthDate(String monthDate) {
		this.monthDate = monthDate;
	}

	public Integer getQuarterDate() {
		return quarterDate;
	}

	public void setQuarterDate(Integer quarterDate) {
		this.quarterDate = quarterDate;
	}

	public Integer getRangeQuarter() {
		return rangeQuarter;
	}

	public void setRangeQuarter(Integer rangeQuarter) {
		this.rangeQuarter = rangeQuarter;
	}

	public Integer getYearDate() {
		return yearDate;
	}

	public String getYearType() {
		return yearType;
	}

	public void setYearType(String yearType) {
		this.yearType = yearType;
	}

	public String getPatownShip() {
		return patownShip;
	}

	public void setPatownShip(String patownShip) {
		this.patownShip = patownShip;
	}

	public String getPastreet() {
		return pastreet;
	}

	public void setPastreet(String pastreet) {
		this.pastreet = pastreet;
	}

	public void setYearDate(Integer yearDate) {
		this.yearDate = yearDate;
	}
	
}
