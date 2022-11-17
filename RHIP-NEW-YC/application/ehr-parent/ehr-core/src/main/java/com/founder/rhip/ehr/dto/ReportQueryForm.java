package com.founder.rhip.ehr.dto;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Calendar;
import java.util.Date;

public class ReportQueryForm {
	
	//市级医院或疾控
	private String townCode;
	//卫生院
	private String centreCode;
	//站
	private String stationCode;
	
    //开始时间
    private String beginDate;
    //结束时间
    private String endDate;

    //医务人员编码
    private String staffCode;

    //时间范围类型：按月、按季度、按年、按时间段
    private String rangeType;

    //按年类型：全年、上半年、下半年
    private String yearType;

    //月份
    private String monthDate;

    //季度年份
    private Integer quarterDate;

    //年份
    private Integer yearDate;

    //季度
    private Integer rangeQuarter;

    //门急诊住院类型|1,2门诊3住院
    private String opEmHpMark;

    //统计类型 1:按机构 2:按现住址
    private String searchType;

    //所属镇
    private String patownShip;

    //所属居委会
    private String paStreet;

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getCentreCode() {
        return centreCode;
    }

    public void setCentreCode(String centreCode) {
        this.centreCode = centreCode;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
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

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getRangeType() {
        return rangeType;
    }

    public void setRangeType(String rangeType) {
        this.rangeType = rangeType;
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

    public Integer getRangeQuarter() {
        return rangeQuarter;
    }

    public void setRangeQuarter(Integer rangeQuarter) {
        this.rangeQuarter = rangeQuarter;
    }

    public String getOpEmHpMark() {
        return opEmHpMark;
    }

    public void setOpEmHpMark(String opEmHpMark) {
        this.opEmHpMark = opEmHpMark;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getPatownShip() {
        return patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    public String getPaStreet() {
        return paStreet;
    }

    public void setPaStreet(String paStreet) {
        this.paStreet = paStreet;
    }

    /**
     * 根据时间范围组织时间
     *
     *
     * @author Ye jianfei
     */
    public void organizeTime(){
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
            }
        }
    }
}
