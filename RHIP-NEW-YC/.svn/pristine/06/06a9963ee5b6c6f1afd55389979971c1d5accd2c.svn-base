package com.founder.rhip.portal.controller.form;

import java.util.Calendar;
import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class TargetOrgQueryForm {
	
	//市级医院或站
	private String organCode;
	//卫生院
	private String superOrganCode;

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
                    this.endDate = DateUtil.getDateTime("yyyy/MM/dd",DateUtil.lastDateOfMonth(tempDate));
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
            }
        }
    }
    
    
    
    public Criteria getCriteria(){
    	organizeTime();
    	Criteria ca = new Criteria();
    	if(StringUtil.isNotEmpty(superOrganCode)){
    		ca.add("oc.HOSPITAL_CODE",superOrganCode);
    	}
		/* 时间范围 */
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(ca, "REQUEST_DATE", beginDate,endDate);  
		return ca;
    }
    
    
    /**
     * 设置环比日期
     *
     * @author Ye jianfei
     */
    private void setMonthOnMonth(){
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
    
    /**
     * 设置同比日期
     *
     * @author Ye jianfei
     */
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
    
    public void initMonthOnMonth(){
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
    
}
