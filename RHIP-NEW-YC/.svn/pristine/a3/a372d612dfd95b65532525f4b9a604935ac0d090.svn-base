package com.founder.rhip.lda.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.ui.Model;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ldaQueryForm {

    private String monitorIndex;//监控指标
    private String monitorValue;//监控值（小值）
    private String monitorValueMax;//监控值（大值）
    private String prescribeDateBegin;//监控开始时间
    private String prescribeDateEnd;//监控结束时间
    private String prescribeDoctorName;//开方医生姓名
    private String prescribeDoctorNo;//开方医生工号
    private String hospitalCode;//所属机构
    private Order unusualOrder;


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


    /*抗菌药物使用*/
    private String beginDateA;
    
    private String endDateA;
    
    /**特殊药物类型**/
    private String drugType;

    /*
     * 异常处方
     * */
    public Criteria getUnusualCriteria(){
        Criteria criteria = new Criteria();
		/*监控指标*/
        if (StringUtils.isNotBlank(monitorIndex)){
            switch(monitorIndex){
                case "1"://处方金额
                    getCriteriaByRange(criteria, "prescriptionTotalCost", monitorValue, monitorValueMax);
                    setUnusualOrder(new Order("PRESCRIPTION_TOTAL_COST DESC,HOSPITAL_CODE DESC"));
                    break;
                case "2"://用量
                    getCriteriaByRange(criteria, "DRUG_USE_TOTAL_DOSE", monitorValue, monitorValueMax);
                    setUnusualOrder(new Order("HOSPITAL_CODE,DRUG_USE_TOTAL_DOSE DESC"));
                    break;
                case "3"://天数
                    getCriteriaByRange(criteria, "DRUG_USE_DAYS", monitorValue, monitorValueMax);
                    setUnusualOrder(new Order("HOSPITAL_CODE,DRUG_USE_DAYS DESC"));
                    break;
                case "4"://处方品种
                    getCriteriaByRange(criteria, "DRUG.PRESCRIPTION_TOTAL_COUNT", monitorValue, monitorValueMax);
                    setUnusualOrder(new Order("HOSPITAL_CODE,DRUG.PRESCRIPTION_TOTAL_COUNT DESC"));
                    break;
            }

        }

		/*监控日期*/
        Date prescribeDateBegin = DateUtil.parseDateString(this.prescribeDateBegin);
        Date prescribeDateEnd = DateUtil.parseDateString(this.prescribeDateEnd);
        DateUtil.getCriteriaByDateRange(criteria, "PRESCRIBE_DATE", prescribeDateBegin,prescribeDateEnd);

		/*开方医生姓名*/
        if (StringUtils.isNotBlank(prescribeDoctorName)){
            criteria.add("PRESCRIBE_DOCTOR_NAME", OP.LIKE, prescribeDoctorName.trim());
        }
		/*开方医生工号*/
        if (StringUtils.isNotBlank(prescribeDoctorNo)){
            criteria.add("PRESCRIBE_DOCTOR_NO", OP.LIKE, prescribeDoctorNo.trim());
        }
		/*所属机构*/
        if (StringUtils.isNotBlank(hospitalCode)){
            criteria.add("HOSPITAL_CODE", hospitalCode);
        }
        criteria.add("HOSPITAL_CODE",OP.UEMPTY,"");
        return criteria;
    }

    public static void getCriteriaByRange(Criteria criteria, String property, String begin, String end) {

        // 开始时间不为空，结束时间为空
        if (StringUtil.isNotEmpty(begin) && StringUtil.isEmpty(end))
            criteria.add(property, OP.GE, begin);
        if (StringUtil.isNotEmpty(begin) && StringUtil.isNotEmpty(end)) {
            Object[] obj = new Object[2];
            obj[0] = begin;
            obj[1] = end;
            criteria.add(property, OP.BETWEEN, obj);
        }
        if (StringUtil.isEmpty(begin) && StringUtil.isNotEmpty(end))
            criteria.add(property, OP.LE, end);
    }

    public Map<String, String> getUnusualParamMap(){

        Map<String,String> paramMap = new HashMap<String,String>();
        if(StringUtil.isNotEmpty(prescribeDateBegin)){
            paramMap.put("beginDate",prescribeDateBegin);
        }
        if(StringUtil.isNotEmpty(prescribeDateEnd)){
            paramMap.put("endDate",prescribeDateEnd);
        }
        if(StringUtil.isNotEmpty(hospitalCode)){
            paramMap.put("hospitalCode",hospitalCode);
        }
		/*监控指标*/
        if (StringUtils.isNotBlank(monitorIndex) && StringUtils.isNotBlank(monitorValue)){
            paramMap.put("monitorValue",monitorValue);
        }
        if (StringUtils.isNotBlank(monitorIndex) && StringUtils.isNotBlank(monitorValueMax)){
            paramMap.put("monitorValueMax",monitorValueMax);
        }
        return paramMap;
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
    public Criteria getDaChangeCriteria(){
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
		/* 时间范围 --出入库日期*/
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(ca, "SEARCH_DT", beginDate,endDate);     	
		return ca;
    }
    
    /**
     * 基药管理--出入库
     *
     * @return
     * @author Ye jianfei
     */
    public Criteria getDaStorageCriteria(){
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
    		}else if(OrgGenreCode.STATION.getValue().equals(genreCode)){
    			ca.add("SUP_ORGAN_CODE",superOrganCode);
    		}
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		ca.add("GBCODE",gbCode);
    	}   
		/* 时间范围--失效日期 */
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(ca, "CREATE_DATE", beginDate,endDate);     	
		return ca;
    }  
    
    public Criteria getEpidemicCriteria(){
    	organizeTime();
    	Criteria ca = new Criteria();
    	//机构类型
    	if(StringUtil.isNotEmpty(genreCode)){
    		ca.add("genreCode",genreCode);
    	}
    	if(StringUtil.isNotEmpty(superOrganCode)){
    		ca.add("ORGAN_CODE",superOrganCode);
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		ca.add("GB_CODE",gbCode);
    	}     	
		/* 时间范围 */
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(ca, "FILL_DATE", beginDate,endDate);  
		return ca;
    }
    
    public Criteria getLifeEventCriteria(){
    	organizeTime();
    	Criteria ca = new Criteria();
    	//机构类型
    	if(StringUtil.isNotEmpty(genreCode)){
    		ca.add("genreCode",genreCode);
    	}
    	if(StringUtil.isNotEmpty(superOrganCode)){
    		ca.add("ORGAN_CODE",superOrganCode);
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		ca.add("GB_CODE",gbCode);
    	}     	
		/* 时间范围 */
		/*Date beginDate = DateUtil.parseDateString(this.beginDate);
		Date endDate = DateUtil.parseDateString(this.endDate);
		DateUtil.getCriteriaByDateRange(ca, "input_date", beginDate,endDate);*/  
    	ca.add(this.getCriDateLife());
		return ca;
    }
    
    public Criteria getCriDateLife() {
    	Criteria ca = new Criteria();
    	Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(ca, "death_date", beginDate,endDate);
		return ca;
    }
    public Criteria getHealthCardCriteria(){
    	organizeTime();
    	Criteria ca = new Criteria();
    	Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(ca, "CREATE_DATE", beginDate,endDate);  
		ca.add("genreCode", genreCode);
		//社区卫生服务站
    	if("B2".equals(genreCode)){
    		if(StringUtil.isNotEmpty(organCode)){
    			ca.add("INPUT_ORGAN_CODE",organCode);
    		}
    		if(StringUtil.isNotEmpty(superOrganCode)){
    			ca.add("INPUT_CENTER_ORGAN_CODE",superOrganCode);
    		}
    		if(StringUtil.isNotEmpty(gbCode)){
    			ca.add("INPUT_GBCODE",gbCode);
    		}
        //镇
    	}else if("0".equals(genreCode) && StringUtil.isNotEmpty(gbCode)){
		    ca.add("INPUT_GBCODE",gbCode);
    	}
    	return ca;
    }
    
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

    public Map<String, String> getCriteria() {
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
    }
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
        if (StringUtil.isNotEmpty(beginDateA)) {
			paramMap.put("beginDateA", beginDateA);
		}
        if (StringUtil.isNotEmpty(endDateA)) {
        	paramMap.put("endDateA", endDateA);
		}
        if (StringUtil.isNotEmpty(drugType)) {
        	paramMap.put("drugType", drugType);
		}
        return paramMap;
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

    public Order getUnusualOrder() {
        return unusualOrder;
    }

    public void setUnusualOrder(Order unusualOrder) {
        this.unusualOrder = unusualOrder;
    }

    public String getMonitorIndex() {
        return monitorIndex;
    }

    public void setMonitorIndex(String monitorIndex) {
        this.monitorIndex = monitorIndex;
    }

    public String getMonitorValue() {
        return monitorValue;
    }

    public void setMonitorValue(String monitorValue) {
        this.monitorValue = monitorValue;
    }

    public String getMonitorValueMax() {
        return monitorValueMax;
    }

    public void setMonitorValueMax(String monitorValueMax) {
        this.monitorValueMax = monitorValueMax;
    }

    public String getPrescribeDateBegin() {
        return prescribeDateBegin;
    }

    public void setPrescribeDateBegin(String prescribeDateBegin) {
        this.prescribeDateBegin = prescribeDateBegin;
    }

    public String getPrescribeDateEnd() {
        return prescribeDateEnd;
    }

    public void setPrescribeDateEnd(String prescribeDateEnd) {
        this.prescribeDateEnd = prescribeDateEnd;
    }

    public String getPrescribeDoctorName() {
        return prescribeDoctorName;
    }

    public void setPrescribeDoctorName(String prescribeDoctorName) {
        this.prescribeDoctorName = prescribeDoctorName;
    }

    public String getPrescribeDoctorNo() {
        return prescribeDoctorNo;
    }

    public void setPrescribeDoctorNo(String prescribeDoctorNo) {
        this.prescribeDoctorNo = prescribeDoctorNo;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

	public String getDrugType() {
		return drugType;
	}

	public void setDrugType(String drugType) {
		this.drugType = drugType;
	}
    
    
}
