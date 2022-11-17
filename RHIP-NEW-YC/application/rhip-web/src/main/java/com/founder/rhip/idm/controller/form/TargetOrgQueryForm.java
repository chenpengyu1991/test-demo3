package com.founder.rhip.idm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import org.springframework.ui.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TargetOrgQueryForm {
	
	//查询类型
	private String genreCode;
	//市级医院或站
	private String organCode;
	//卫生院
	private String superOrganCode;
	//镇
	private String gbCode;

	//时间范围类型：按月、按季度、按年、按时间段
	private String rangeType;

	//季度
	private Integer rangeQuarter;
	
	//按年类型：全年、上半年、下半年
	private String yearType;
	
    //开始时间
    private String beginDate;
    //结束时间
    private String endDate;
    //月份
    private String monthDate;
    //季度年份
    private Integer quarterDate;
    //年份
    private Integer yearDate;
    //继续教育学分年份
    private String trainingYear;

    //儿童人数统计用
    private String timePoint;

    //常熟市妇幼保健所
    private String orgG2;

    /* 临床路径查询  */
    private String hospitalCode;
    private String idCard;
    private String patientName;
    private String diagnosisName;
    
    /* 病床使用情况查询  */
    private String departmentName;
    private String sickArea;
    private String extraBedMark;
    private String avirableBedMark;
    
    /*医院费用*/
    private String opEmHpMark;//门诊/急诊/住院标志,吗,门急诊:1,住院:2
    
    /*传染病疫情趋势分析*/
    private String infectiousCode;//传染病编码
    
    /*抗菌药物使用*/
    private String beginDateA;
    
    private String endDateA;
    
    /*病案首页质量*/
    private String quality;
    
    /**儿童年龄段统计 行政镇*/
    private String paCounty;
    
    /**儿童年龄段统计 行政村*/
    private String paTownShip;
    
    /*传染病分地区统计表*/
    private Integer weekNumber;//第几周
    private String weekDate;//周月份
    private Integer weekBeginDate1;//第1周开始天数
    private Integer weekBeginDate2;//第2周开始天数
    private Integer weekBeginDate3;//第3周开始天数
    private Integer weekBeginDate4;//第4周开始天数
    private Integer weekBeginDate5;//第5周开始天数
    private Integer weekBeginDate6;//第6周开始天数
    private Integer weekEndDate1;//第1周结束天数
    private Integer weekEndDate2;//第2周结束天数
    private Integer weekEndDate3;//第3周结束天数
    private Integer weekEndDate4;//第4周结束天数
    private Integer weekEndDate5;//第5周结束天数
    private Integer weekEndDate6;//第6周结束天数

    public void calTime(){
        this.organizeTime();
    }

    /**
     * 根据时间范围组织时间
     * 
     *
     * @author Ye jianfei
     */
    private void organizeTime(){
        if(StringUtil.isNotEmpty(this.rangeType)){
            switch (this.rangeType){
                case "1"://按月
                    if(StringUtil.isNullOrEmpty(monthDate)){
                        this.monthDate = DateUtil.getDateTime("yyyy/MM", new Date());
                    }
                    Date tempDate = DateUtil.parseSimpleDate(this.monthDate, "yyyy/MM");
                    this.beginDate = this.monthDate + "/01";
                    this.endDate = DateUtil.getDateTime("yyyy/MM/dd", DateUtil.lastDateOfMonth(tempDate));
                    break;
                case "2"://按季度
                    if(ObjectUtil.isNullOrEmpty(quarterDate)){
                        this.quarterDate = DateUtil.getCurrentYear();
                    }
                    Calendar c = Calendar.getInstance();
                    Date quarterMonth[] = DateUtil.getDateRangeBySeason(rangeQuarter);
                    c.setTime(quarterMonth[0]);
                    c.set(Calendar.YEAR, this.quarterDate);
                    this.beginDate = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());
                    c.setTime(quarterMonth[1]);
                    c.set(Calendar.YEAR, this.quarterDate);
                    this.endDate = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());

                    break;
                case "3"://按年
                    if(ObjectUtil.isNullOrEmpty(yearDate)){
                        this.yearDate = DateUtil.getCurrentYear();
                    }
                    switch(this.yearType){
                        case "1"://全年
                            this.beginDate = yearDate + "/01/01";
                            this.endDate =  yearDate + "/12/31";
                            break;
                        case "2"://上半年
                            this.beginDate = yearDate + "/01/01";
                            this.endDate =  yearDate + "/06/30";
                            break;
                        case "3"://下半年
                            this.beginDate = yearDate + "/07/01";
                            this.endDate =  yearDate + "/12/31";
                            break;
                    }
                    break;
                case "5"://按周
                	switch(this.weekNumber){
                		case 1:
                    		this.beginDate = this.weekDate + "/" + String.format("%02d", this.weekBeginDate1);
                            this.endDate = this.weekDate + "/" + String.format("%02d", this.weekEndDate1);
                			break;
                		case 2:
                    		this.beginDate = this.weekDate + "/" + String.format("%02d", this.weekBeginDate2);
                            this.endDate = this.weekDate + "/" + String.format("%02d", this.weekEndDate2);
                			break;
                		case 3:
                    		this.beginDate = this.weekDate + "/" + String.format("%02d", this.weekBeginDate3);
                            this.endDate = this.weekDate + "/" + String.format("%02d", this.weekEndDate3);
                			break;
                		case 4:
                    		this.beginDate = this.weekDate + "/" + String.format("%02d", this.weekBeginDate4);
                            this.endDate = this.weekDate + "/" + String.format("%02d", this.weekEndDate4);
                			break;
                		case 5:
                    		this.beginDate = this.weekDate + "/" + String.format("%02d", this.weekBeginDate5);
                            this.endDate = this.weekDate + "/" + String.format("%02d", this.weekEndDate5);
                			break;
                		case 6:
                    		this.beginDate = this.weekDate + "/" + String.format("%02d", this.weekBeginDate6);
                            this.endDate = this.weekDate + "/" + String.format("%02d", this.weekEndDate6);
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
        this.beginDate = yearDate + "/01/01";
        this.endDate =  yearDate + "/12/31";
    }
    /**
     * 基药管理--出入库
     *
     * @return
     * @author Ye jianfei
     */
    /*public Criteria getDaChangeCriteria(){
    	organizeTime();
    	Criteria ca = new Criteria();
    	if(StringUtil.isNotEmpty(genreCode)){
    		if(!"0".equals(genreCode)){
    			ca.add("ORG_TYPE",genreCode);
    		}
    	}
    	if(StringUtil.isNotEmpty(organCode)){
    		ca.add("ORGAN_CODE",organCode);
    	}
    	if(StringUtil.isNotEmpty(superOrganCode)){
    		if(OrgGenreCode.CENTRE.getValue().equals(genreCode) 
    				|| OrgGenreCode.HOSPITAL.getValue().equals(genreCode)){//中心,市级医院
    			ca.add("ORGAN_CODE",superOrganCode);
    		}else if(OrgGenreCode.STATION.getValue().equals(genreCode)){//站
    			ca.add("SUP_ORGAN_CODE",superOrganCode);
    		}
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		ca.add("GBCODE",gbCode);
    	}   
		 时间范围 --出入库日期
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(ca, "SEARCH_DT", beginDate,endDate);     	
		return ca;
    }
    */
    
   
    
    public void initMedical(){
    	organizeTime();
    }
    
    /**
     * 本次查询条件
     *
     * @param model
     * @author Ye jianfei
     */
    public void setCurrentResult(Model model){
    	model.addAttribute("resultGenreCode", genreCode);
    	model.addAttribute("resultOrganCode", organCode);
    	model.addAttribute("resultSuperOrganCode", superOrganCode);
    	model.addAttribute("resultGbCode", gbCode);
    	model.addAttribute("resultRangeType", rangeType);
    	model.addAttribute("resultMonthDate", monthDate);
    	model.addAttribute("resultRangeQuarter", rangeQuarter);
    	model.addAttribute("resultQuarterDate", quarterDate);
    	model.addAttribute("resultYearType", yearType);
    	model.addAttribute("resultYearDate", yearDate);
    }
    
    /**
     * 设置环比日期
     *
     * @author Ye jianfei
     */
   /* private void setMonthOnMonth(){
        if(StringUtil.isNotEmpty(this.rangeType)){
            switch (this.rangeType){
                case "1"://按月
                    if(StringUtil.isNullOrEmpty(monthDate)){
                        this.monthDate = DateUtil.getDateTime("yyyy/MM", new Date());
                    }
                    Date tempDate = getBeforeDate(DateUtil.parseSimpleDate(this.monthDate, "yyyy/MM"),"1");
                    this.beginDate = DateUtil.getDateTime("yyyy/MM/dd",tempDate);
                    this.endDate = DateUtil.getDateTime("yyyy/MM/dd",DateUtil.lastDateOfMonth(tempDate));
                    break;
                case "2"://按季度
                    if(ObjectUtil.isNullOrEmpty(quarterDate)){
                        this.quarterDate = DateUtil.getCurrentYear();
                    }
                    Calendar c = Calendar.getInstance();
                    if(rangeQuarter>1){
                    	this.rangeQuarter = this.rangeQuarter -1;
                    }else{
                    	this.quarterDate = this.quarterDate - 1;
                    	this.rangeQuarter = 4;
                    }
                    Date quarterMonth[] = DateUtil.getDateRangeBySeason(rangeQuarter);
                    c.setTime(quarterMonth[0]);
                    c.set(Calendar.YEAR, this.quarterDate);
                    this.beginDate = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());
                    c.setTime(quarterMonth[1]);
                    c.set(Calendar.YEAR, this.quarterDate);
                    this.endDate = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());

                    break;
                case "3"://按年
                    if(ObjectUtil.isNullOrEmpty(yearDate)){
                        this.yearDate = DateUtil.getCurrentYear();
                    }
                    this.yearDate = this.yearDate - 1;
                    switch(this.yearType){
                        case "1"://全年
                            this.beginDate = yearDate + "/01/01";
                            this.endDate =  yearDate + "/12/31";
                            break;
                        case "2"://上半年
                            this.beginDate = yearDate + "/01/01";
                            this.endDate =  yearDate + "/06/30";
                            break;
                        case "3"://下半年
                            this.beginDate = yearDate + "/07/01";
                            this.endDate =  yearDate + "/12/31";
                            break;
                    }
                    break;
            }
        }    	
    }
    
    *//**
     * 设置同比日期
     *
     * @author Ye jianfei
     *//*
    public void setYearOnYear(){
        if(StringUtil.isNotEmpty(this.rangeType)){
            switch (this.rangeType){
                case "1"://按月
                    if(StringUtil.isNullOrEmpty(monthDate)){
                        this.monthDate = DateUtil.getDateTime("yyyy/MM", new Date());
                    }
                    Date tempDate = getBeforeDate(DateUtil.parseSimpleDate(this.monthDate, "yyyy/MM"),"2");
                    this.beginDate = DateUtil.getDateTime("yyyy/MM/dd",tempDate);
                    this.endDate = DateUtil.getDateTime("yyyy/MM/dd",DateUtil.lastDateOfMonth(tempDate));
                    break;
                case "2"://按季度
                    if(ObjectUtil.isNullOrEmpty(quarterDate)){
                        this.quarterDate = DateUtil.getCurrentYear();
                    }
                    Calendar c = Calendar.getInstance();
                    this.quarterDate = this.quarterDate - 1;
                    Date quarterMonth[] = DateUtil.getDateRangeBySeason(rangeQuarter);
                    c.setTime(quarterMonth[0]);
                    c.set(Calendar.YEAR, this.quarterDate);
                    this.beginDate = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());
                    c.setTime(quarterMonth[1]);
                    c.set(Calendar.YEAR, this.quarterDate);
                    this.endDate = DateUtil.getDateTime("yyyy/MM/dd", c.getTime());

                    break;
                case "3"://按年
                    if(ObjectUtil.isNullOrEmpty(yearDate)){
                        this.yearDate = DateUtil.getCurrentYear();
                    }
                    this.yearDate = this.yearDate - 1;
                    switch(this.yearType){
                        case "1"://全年
                            this.beginDate = yearDate + "/01/01";
                            this.endDate =  yearDate + "/12/31";
                            break;
                        case "2"://上半年
                            this.beginDate = yearDate + "/01/01";
                            this.endDate =  yearDate + "/06/30";
                            break;
                        case "3"://下半年
                            this.beginDate = yearDate + "/07/01";
                            this.endDate =  yearDate + "/12/31";
                            break;
                    }
                    break;
            }
        }    	
    }
    */
   /* public void initMonthOnMonth(){
    	setMonthOnMonth();
     }
    
    public void initYearOnYear(){
    	setYearOnYear();
     }
    private Date getBeforeDate(Date currentDate,String type){
    	Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        if("1".equals(type)){//环比
        	cal.add(Calendar.MONTH, -1);
        }
        if("2".equals(type)){//同比
        	cal.add(Calendar.YEAR, -1);
        }  
        cal.add(Calendar.DAY_OF_MONTH, 0);
        return cal.getTime();
    }
    
    public Criteria getClinicalPathway(){
    	Criteria ca = new Criteria();
    	if(StringUtil.isNotEmpty(hospitalCode)){
			ca.add("HOSPITAL_CODE",hospitalCode);
		}
    	if(StringUtil.isNotEmpty(idCard)){
			ca.add("ID_CARD",idCard.toUpperCase());
		}
    	if(StringUtil.isNotEmpty(patientName)){
			ca.add("PATIENT_NAME",OP.LIKE,patientName);
		}
    	if(StringUtil.isNotEmpty(patientName)){
			ca.add("PATIENT_NAME",OP.LIKE,patientName);
		}    	
        诊断名称
    	if(StringUtil.isNotEmpty(diagnosisName)){
			ca.add("DIAGNOSIS_NAME",OP.LIKE,diagnosisName);
		}      	
    	return ca;
    }*/
    
    public Criteria getSickbedUseState(){
    	Criteria ca = new Criteria();
    	if(StringUtil.isNotEmpty(hospitalCode)){
			ca.add("HOSPITAL_CODE",hospitalCode);
		}
    	if(StringUtil.isNotEmpty(departmentName)){
			ca.add("DEPARTMENT_NAME", OP.LIKE,departmentName);
		}
    	if(StringUtil.isNotEmpty(sickArea)){
			ca.add("SICK_AREA", OP.LIKE,sickArea);
		}
    	if(StringUtil.isNotEmpty(extraBedMark)){
			ca.add("EXTRA_BED_MARK",extraBedMark);
		}
    	if(StringUtil.isNotEmpty(avirableBedMark)){
			ca.add("AVIRABLE_BED_MARK",avirableBedMark);
		}
    	return ca;    	
    }
	public String getGenreCode() {
		return genreCode;
	}
	
	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	
	public String getSuperOrganCode() {
		return superOrganCode;
	}
	
	public void setSuperOrganCode(String superOrganCode) {
		this.superOrganCode = superOrganCode;
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
	public String getRangeType() {
		return rangeType;
	}
	public void setRangeType(String rangeType) {
		this.rangeType = rangeType;
	}
	public Integer getRangeQuarter() {
		return rangeQuarter;
	}
	public void setRangeQuarter(Integer rangeQuarter) {
		this.rangeQuarter = rangeQuarter;
	}
	public String getYearType() {
		return yearType;
	}
	public void setYearType(String yearType) {
		this.yearType = yearType;
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

	public Integer getYearDate() {
		return yearDate;
	}

	public void setYearDate(Integer yearDate) {
		this.yearDate = yearDate;
	}

    public String getTimePoint() {
        return timePoint;
    }

    public void setTimePoint(String timePoint) {
        this.timePoint = timePoint;
    }

    public String getOrgG2() {
        return orgG2;
    }

    public void setOrgG2(String orgG2) {
        this.orgG2 = orgG2;
    }

   /* public Map<String, String> getCriteria() {
    	setMonthOnMonth();
    	Map<String, String> paramMap = new HashMap<String, String>();
    	if(ObjectUtil.isNotEmpty(genreCode)){
    		paramMap.put("organType", genreCode);
        }
        if(ObjectUtil.isNotEmpty(superOrganCode)){
        	paramMap.put("organCode", superOrganCode);
        }
        if(ObjectUtil.isNotEmpty(organCode)){
        	paramMap.put("organCode", organCode);
        }
        if(ObjectUtil.isNotEmpty(gbCode)){
        	paramMap.put("gbCode", gbCode);
        }
        return paramMap;
    }*/
   /* public Map<String, String> getParamMap(){
        organizeTime();

        Map<String, String> paramMap = new HashMap<String, String>();
        if(StringUtil.isNotEmpty(genreCode)){
            paramMap.put("genreCode",genreCode);
        }
        if(StringUtil.isNotEmpty(organCode)){
            paramMap.put("organCode",organCode);
        }
 
        if(StringUtil.isNotEmpty(gbCode)){
            paramMap.put("gbCode",gbCode);
        }
        if(StringUtil.isNotEmpty(beginDate)){
            paramMap.put("beginDate",beginDate);
        }
        if(StringUtil.isNotEmpty(endDate)){
            paramMap.put("endDate",endDate);
        }
        if(StringUtil.isNotEmpty(superOrganCode)){
            paramMap.put("superOrganCode",superOrganCode);
        }
        return paramMap;
    }*/
     public Map<String, String> getParamMap(){
        organizeTime();

        Map<String, String> paramMap = new HashMap<String, String>();
        if(StringUtil.isNotEmpty(genreCode)){
            paramMap.put("genreCode",genreCode);
        }
        if(StringUtil.isNotEmpty(organCode)){
            paramMap.put("organCode",organCode);
        }
        if(StringUtil.isNotEmpty(superOrganCode)){
            paramMap.put("superOrganCode",superOrganCode);
        }
        if(StringUtil.isNotEmpty(gbCode)){
            paramMap.put("gbCode",gbCode);
        }
        if(StringUtil.isNotEmpty(beginDate)){
            paramMap.put("beginDate",beginDate);
        }
        if(StringUtil.isNotEmpty(endDate)){
            paramMap.put("endDate",endDate);
        }
        if(StringUtil.isNotEmpty(timePoint)){
            paramMap.put("timePoint",timePoint);
        }
        if(StringUtil.isNotEmpty(orgG2)){
            paramMap.put("orgG2",orgG2);
        }
        if(StringUtil.isNotEmpty(trainingYear)){
            paramMap.put("trainingYear",trainingYear);
        }
        if (StringUtil.isNotEmpty(beginDateA)) {
			paramMap.put("beginDateA", beginDateA);
		}
        if (StringUtil.isNotEmpty(endDateA)) {
        	paramMap.put("endDateA", endDateA);
		}
        if (StringUtil.isNotEmpty(quality)) {
        	paramMap.put("quality", quality);
		}
        if (StringUtil.isNotEmpty(opEmHpMark)) {
			paramMap.put("opEmHpMark", opEmHpMark);
		}
        if (StringUtil.isNotEmpty(paCounty)) {
        	paramMap.put("paCounty", paCounty);
		}
        if (StringUtil.isNotEmpty(paTownShip)) {
        	paramMap.put("paTownShip", paTownShip);
		}
        return paramMap;
    }
    
     /*  public Map<String, String> getRpParamMap() {
    	Map<String, String> paramMap = new HashMap<String, String>();
    	if (ObjectUtil.isNotEmpty(yearDate)) {
			paramMap.put("rpYear", String.valueOf(yearDate));
		}
    	if (ObjectUtil.isNotEmpty(genreCode)) {
			paramMap.put("organType", genreCode);
		}
    	if (ObjectUtil.isNotEmpty(gbCode)) {
			paramMap.put("gbCode", gbCode);
		}
    	if (ObjectUtil.isNotEmpty(superOrganCode)) {
			paramMap.put("organCode", superOrganCode);
		}
    	return paramMap;
    }
*/
	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getSickArea() {
		return sickArea;
	}

	public void setSickArea(String sickArea) {
		this.sickArea = sickArea;
	}

	public String getExtraBedMark() {
		return extraBedMark;
	}

	public void setExtraBedMark(String extraBedMark) {
		this.extraBedMark = extraBedMark;
	}

	public String getAvirableBedMark() {
		return avirableBedMark;
	}

	public void setAvirableBedMark(String avirableBedMark) {
		this.avirableBedMark = avirableBedMark;
	}

    public String getTrainingYear() {
        return trainingYear;
    }

    public void setTrainingYear(String trainingYear) {
        this.trainingYear = trainingYear;
    }

	public String getDiagnosisName() {
		return diagnosisName;
	}

	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
	}

	public String getOpEmHpMark() {
		return opEmHpMark;
	}

	public void setOpEmHpMark(String opEmHpMark) {
		this.opEmHpMark = opEmHpMark;
	}

	public String getInfectiousCode() {
		return infectiousCode;
	}

	public void setInfectiousCode(String infectiousCode) {
		this.infectiousCode = infectiousCode;
	}

	
	public String getBeginDateA() {
		return beginDateA;
	}

	
	public void setBeginDateA(String beginDateA) {
		this.beginDateA = beginDateA;
	}

	
	public String getEndDateA() {
		return endDateA;
	}

	
	public void setEndDateA(String endDateA) {
		this.endDateA = endDateA;
	}

	
	public String getQuality() {
		return quality;
	}

	
	public void setQuality(String quality) {
		this.quality = quality;
	}
	
	
	public Integer getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(Integer weekNumber) {
		this.weekNumber = weekNumber;
	}

	public String getWeekDate() {
		return weekDate;
	}

	public void setWeekDate(String weekDate) {
		this.weekDate = weekDate;
	}

	public Integer getWeekBeginDate1() {
		return weekBeginDate1;
	}

	public void setWeekBeginDate1(Integer weekBeginDate1) {
		this.weekBeginDate1 = weekBeginDate1;
	}

	public Integer getWeekBeginDate2() {
		return weekBeginDate2;
	}

	public void setWeekBeginDate2(Integer weekBeginDate2) {
		this.weekBeginDate2 = weekBeginDate2;
	}

	public Integer getWeekBeginDate3() {
		return weekBeginDate3;
	}

	public void setWeekBeginDate3(Integer weekBeginDate3) {
		this.weekBeginDate3 = weekBeginDate3;
	}

	public Integer getWeekBeginDate5() {
		return weekBeginDate5;
	}

	public void setWeekBeginDate5(Integer weekBeginDate5) {
		this.weekBeginDate5 = weekBeginDate5;
	}

	public Integer getWeekBeginDate4() {
		return weekBeginDate4;
	}

	public void setWeekBeginDate4(Integer weekBeginDate4) {
		this.weekBeginDate4 = weekBeginDate4;
	}

	public Integer getWeekEndDate1() {
		return weekEndDate1;
	}

	public void setWeekEndDate1(Integer weekEndDate1) {
		this.weekEndDate1 = weekEndDate1;
	}

	public Integer getWeekEndDate2() {
		return weekEndDate2;
	}

	public void setWeekEndDate2(Integer weekEndDate2) {
		this.weekEndDate2 = weekEndDate2;
	}

	public Integer getWeekEndDate3() {
		return weekEndDate3;
	}

	public void setWeekEndDate3(Integer weekEndDate3) {
		this.weekEndDate3 = weekEndDate3;
	}

	public Integer getWeekEndDate4() {
		return weekEndDate4;
	}

	public void setWeekEndDate4(Integer weekEndDate4) {
		this.weekEndDate4 = weekEndDate4;
	}

	public Integer getWeekEndDate5() {
		return weekEndDate5;
	}

	public void setWeekEndDate5(Integer weekEndDate5) {
		this.weekEndDate5 = weekEndDate5;
	}

	public Integer getWeekBeginDate6() {
		return weekBeginDate6;
	}

	public void setWeekBeginDate6(Integer weekBeginDate6) {
		this.weekBeginDate6 = weekBeginDate6;
	}

	public Integer getWeekEndDate6() {
		return weekEndDate6;
	}

	public void setWeekEndDate6(Integer weekEndDate6) {
		this.weekEndDate6 = weekEndDate6;
	}

	public String getPaCounty() {
		return paCounty;
	}

	public void setPaCounty(String paCounty) {
		this.paCounty = paCounty;
	}

	public String getPaTownShip() {
		return paTownShip;
	}

	public void setPaTownShip(String paTownShip) {
		this.paTownShip = paTownShip;
	}

}
