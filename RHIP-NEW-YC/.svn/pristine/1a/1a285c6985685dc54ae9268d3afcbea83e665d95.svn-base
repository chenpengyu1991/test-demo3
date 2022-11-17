package com.founder.rhip.portal.tld;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;

import com.founder.fasf.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.RegisterScheduleDTO;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.entity.portal.FrequentContacts;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.RegisterScheduleTime;
import com.founder.rhip.ehr.entity.portal.StopDoctor;
import com.founder.rhip.portal.common.Constants;
import com.founder.rhip.portal.service.IAccountInfoService;
import com.founder.rhip.portal.service.IFrequentContactsService;
import com.founder.rhip.portal.service.IRegisterScheduleService;
import com.founder.rhip.portal.service.IReserveService;
import com.founder.rhip.portal.service.IStopDoctorService;
import com.founder.rhip.portal.service.util.Axis2Util;

/**
 * 预约排班资源标签
 * @author Liu jingyin
 *
 */          
public class PortalRegisterScheduleTag extends BaseTag {

	private static final long serialVersionUID = -2965834693493677396L;

	private String hospitalCode;
	private String deptSn;
	private String doctorSn;
	private String deptName;
	private String doctorName;
	private String clinicType;
	private String startDate;
	private String endDate;
	private String type;
	private String registerFee;
	private String amPm;
	private int reserveFlag;
	private String requestDate;
	private String contextPath;
	
	private List<RegisterSchedule> registerSchedules;
	
	private static final String STATUS_NULL ="";
	private static final String STATUS_NOT_RESERVE = "无可预约人";
	private static final String STATUS_FULL = "已满";
	private static final String STATUS_OK = "可预约";
	private static final String STATUS_STOP = "已停诊";
	
    //1:可挂 ( 院方门办正式确定了的排班表）
    private static final String YYReserveKG = "1";
    //2:已满（已经全部挂满或者放给预约的约满了） 
    private static final String YYReserveYM = "2";
    //3:停号 （院方通知医生停诊了，停止继续预约）
    private static final String YYReserveTH = "3";
    
	@Autowired
   	private IReserveService reserveService;
	
	@Autowired
   	private IRegisterScheduleService registerSchedule;
	
	@Autowired
   	private IStopDoctorService stopDoctorService;
	
	@Autowired
    private IFrequentContactsService frequentContactsService;
	
	@Autowired
    private IAccountInfoService accountInfoService;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		try {
			StringBuilder html = new StringBuilder();
			
			Date sDate = DateUtil.parseSimpleDate(startDate, "yyyy/MM/dd");
			Date eDate = DateUtil.parseSimpleDate(endDate, "yyyy/MM/dd");
			String deptSn = registerSchedules.get(0).getDeptSn();
			RegisterScheduleDTO registerScheduleDTO = registerSchedule.getRegisterScheduleDetail(hospitalCode, deptSn, sDate, eDate);
			
				for (int i = 0; i < registerSchedules.size(); i++) {
					RegisterSchedule regSchedule = registerSchedules.get(i);
					html.append("<tr>");
					html.append("<td rowspan=\"2\" title=\""+regSchedule.getDeptName()+"\">");
					html.append(regSchedule.getDeptName());
					html.append("</td>");
					html.append("<td rowspan=\"2\">");
					html.append(regSchedule.getDoctorName());
					html.append("</td>");
					html.append("</td>");
					if ((!Constants.MATERNAL_CHILD_HOSPITAL.equals(hospitalCode)) 
							&& (!Constants.STOMATOLOGICAL_HOSPITAL.equals(hospitalCode))) {
						html.append("<td rowspan=\"2\">");
						html.append(regSchedule.getRegisterFee());
						html.append("</td>");
					}
					html.append("<td>");
					html.append("上午");
					html.append("</td>");
					if (Axis2Util.commonMethods(hospitalCode)) {
						html.append(getWeekTdsForyy(registerScheduleDTO,regSchedule,"a",sDate,eDate));
					} else {
						html.append(getWeekTds(registerScheduleDTO,regSchedule,"a",sDate,eDate));
					}
					html.append("</tr>");
					html.append("<tr>");
					html.append("<td>");
					html.append("下午");
					html.append("</td>");
					if (Axis2Util.commonMethods(hospitalCode)) {
						html.append(getWeekTdsForyy(registerScheduleDTO,regSchedule,"p",sDate,eDate));
					} else {
						html.append(getWeekTds(registerScheduleDTO,regSchedule,"p",sDate,eDate));
					}
					html.append("</tr>");
				}
			
			JspWriter jw = pageContext.getOut();
			jw.write(html.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}


/****************************************调用医院接口start****************************************************************/
	/**
	 * 分别获取上午和下午的出诊排班
	 * @param registerScheduleDTO
	 * @param ampm
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private String getWeekTdsForyy(RegisterScheduleDTO registerScheduleDTO, RegisterSchedule regSchedule,String ampm,Date startDate,Date endDate){
		String tdString = "";
		List<Date> dateList = registerSchedule.getBetweenDate(startDate, endDate);
		for(Date date:dateList){
			String td = getWeekTdForyy(registerScheduleDTO,regSchedule,ampm,date);
			tdString += td;
		}
		return tdString;
	}
	
	private String getWeekTdForyy(RegisterScheduleDTO registerScheduleDTO,RegisterSchedule regSchedule, String ampm,Date date){
		for(RegisterSchedule reg : registerScheduleDTO.getRegisterSchedules()){
			String yyString = DateUtil.toFormatString("yyyy/MM/dd", reg.getRequestDate());
			Date yyDate = DateUtil.parseDateString(yyString);

			String deptNo = regSchedule.getDeptSn();
			String doctorNo = regSchedule.getDoctorSn();
			
			if (StringUtil.isNullOrEmpty(reg.getDeptName())) {
				reg.setDeptName(regSchedule.getDeptName());
			}
			if (date.equals(yyDate) && ampm.equals(reg.getAmpm()) && 
					deptNo.equals(reg.getDeptSn()) && doctorNo.equals(reg.getDoctorSn())) {
				
				if (YYReserveTH.equals(reg.getReserveStatus())) {
					return formateWeekDateForyy(null,STATUS_STOP);
				}
				if (YYReserveKG.equals(reg.getReserveStatus())) {
					return formateWeekDateForyy(reg,STATUS_OK);
				}
				if (YYReserveYM.equals(reg.getReserveStatus())) {
					return formateWeekDateForyy(null,STATUS_FULL);
				}
				return formateWeekDateForyy(null,STATUS_NULL);
			} else {
				continue;
			}
		}
		return formateWeekDateForyy(null,STATUS_NULL);
	}
	
	/**
	 * 生成一个TD
	 * 
	 * @param reg
	 * @param status
	 * @return
	 */
	private String formateWeekDateForyy(RegisterSchedule reg, String status){
		StringBuilder sb = new StringBuilder();
		if (STATUS_OK.equals(status)) {
			sb.append("<td style=\"background-color:#CEFFBE;\">");
		} else if (STATUS_FULL.equals(status)) {
			sb.append("<td style=\"color:red;background-color:#FFBFBF\">");
		}else if (STATUS_NOT_RESERVE.equals(status)) {
			sb.append("<td style=\"background-color:#CEFFBE\">");
		} else{
			sb.append("<td style=\"color:green\">");
		}
		if(STATUS_OK.equals(status)){
			StringBuffer id = new StringBuffer();
			if (StringUtil.isNotEmpty(reg.getId() == null?"":reg.getId().toString())) {
				if (reg.getId().toString().length() > 9) {
					id.append("id:'").append(String.valueOf(reg.getId()).substring(0, 9)).append("',");
					id.append("subId:'").append(String.valueOf(reg.getId()).substring(9)).append("',");
				} else {
					id.append("id:'").append(reg.getId()).append("',");
				}
			}
			if (ObjectUtil.isNotEmpty(reg.getRegisterFee())) {
				id.append("registerFee:'").append(reg.getRegisterFee()).append("',");
			}
			if (ObjectUtil.isNotEmpty(reg.getClinicType())) {
				id.append("clinicType:'").append(reg.getClinicType()).append("',");
			}
			sb.append("<a href=\"javascript:void(0);\" class=\"link\" "
			+ "onclick=\"reserveschedule.selectRegisterScheduleTimes(this,([{hospitalCode:'"+reg.getHospitalCode()+"',"+id+""
			+ "requestDate:'"+DateUtil.toDateString(reg.getRequestDate(),"yyyy/MM/dd")+"',ampm:'"+reg.getAmpm()+"',deptSn:'"+reg.getDeptSn()+"',"
			+ "deptName:'"+reg.getDeptName()+"',doctorSn:'"+reg.getDoctorSn()+"', doctorName:'"+((StringUtil.isNullOrEmpty(reg.getDoctorName()))?"":reg.getDoctorName())+"'}]))\" title=\"点击预约\" >");
			sb.append("预约");
		} else if (STATUS_NOT_RESERVE.equals(status)) {
			sb.append("<label title=\"无可预约的用户\" disabled=\"disabled\" >");
			sb.append("预约");
		}else{
			sb.append(status);
		}
		
		if(STATUS_OK.equals(status)){
			sb.append("</a>");
		}
		if(STATUS_NOT_RESERVE.equals(status)){
			sb.append("</label>");
		}
		sb.append("</td>");
		return sb.toString();
	}
/****************************************调用医院接口end*********************************************************************/
	
	
	
/******************************不调用医院的接口使用start***********************************************************************/
	
	/**
	 * 分别获取上午和下午的出诊排班
	 * @param registerScheduleDTO
	 * @param ampm
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private String getWeekTds(RegisterScheduleDTO registerScheduleDTO, RegisterSchedule regSchedule,String ampm,Date startDate,Date endDate){
		String tdString = "";
		List<Date> dateList = registerSchedule.getBetweenDate(startDate, endDate);
		StopDoctor stopDoctor = getStopDoctor(regSchedule);
		for(Date date:dateList){
			String td = getWeekTd(stopDoctor,registerScheduleDTO, regSchedule ,ampm,date);
			tdString += td;
		}
		return tdString;
	}
	
	/**
	 * 查询停诊医生
	 * @return
	 */
	private StopDoctor getStopDoctor(RegisterSchedule regSchedule){
		if(ObjectUtil.isNullOrEmpty(regSchedule)){
			return null;
		}
		Criteria criteria = new Criteria();
		criteria.add("hospitalCode", regSchedule.getHospitalCode());
		criteria.add("deptSn", regSchedule.getDeptSn());
		criteria.add("doctorSn", regSchedule.getDoctorSn());
		criteria.add("stopingStatus", 1);
		StopDoctor stopDoctor = stopDoctorService.getStopDoctor(criteria);
		return stopDoctor;
	}
	
	private String getWeekTd(StopDoctor stopDoctor,RegisterScheduleDTO registerScheduleDTO,RegisterSchedule regSchedule,String ampm,Date date){

		for(RegisterSchedule reg : registerScheduleDTO.getRegisterSchedules()){
			String yyString = DateUtil.toFormatString("yyyy/MM/dd", reg.getRequestDate());
			Date yyDate = DateUtil.parseDateString(yyString);

			String deptNo = regSchedule.getDeptSn();
			String doctorNo = regSchedule.getDoctorSn();
			String clinicType = regSchedule.getClinicType();
			
			if(isStop(stopDoctor,date) && date.equals(yyDate) && ampm.equals(reg.getAmpm())){
				return formateWeekDate(null,null,STATUS_STOP);
			}

			if (date.equals(yyDate) && ampm.equals(reg.getAmpm()) && 
			deptNo.equals(reg.getDeptSn()) && doctorNo.equals(reg.getDoctorSn()) 
			&& (StringUtil.isNullOrEmpty(clinicType)?true:(clinicType.equals(reg.getClinicType())))) {
				List<RegisterScheduleTime> registerScheduleTimeLists = 
						reserveService.getRegisterScheduleTimeLists(new Criteria("registerScheduleId",String.valueOf(reg.getId())));
				if (ObjectUtil.isNotEmpty(registerScheduleTimeLists)) {
					int i=0;
					for(int k=0; k<registerScheduleTimeLists.size(); k++) {
						if(registerScheduleTimeLists.get(k).isFull()){
							i++;
							if (i == registerScheduleTimeLists.size()) {
								return formateWeekDate(null,null,STATUS_FULL);
							}
						}/* else if(isReserve()){
							
							return formateWeekDate(null,null,STATUS_NOT_RESERVE);
							
						}*/ else {
							
							return formateWeekDate(registerScheduleDTO,reg,STATUS_OK);
						}
					}
				} else {
					return formateWeekDate(null,null,STATUS_NULL);
				}
			} else {
				continue;
			}
		}
		return formateWeekDate(null,null,STATUS_NULL);
	}
	
	
	private boolean isStop(StopDoctor stopDoctor,Date yyDate){
		if(ObjectUtil.isNullOrEmpty(stopDoctor)){
			return false;
		}
		
		if(yyDate.before(stopDoctor.getStartDate())){
			return false;
		}
		if(yyDate.after(stopDoctor.getEndDate())){
			return false;
		}
		return true;
	}
	
	private boolean isReserve (){
		AccountInfo accountInfo = (AccountInfo) ((HttpServletRequest)pageContext.getRequest()).getSession().getAttribute(Constants.ACCOUNT_INFO);
		accountInfo = accountInfoService.get(new Criteria("id", accountInfo.getId()));
		List<FrequentContacts> getFrequentContactsLists = frequentContactsService.getFrequentContactsLists(new Criteria("account_id", accountInfo.getId()));
		int j = 0;
		for (int i = 0; i < getFrequentContactsLists.size(); i++) {
			if (getFrequentContactsLists.get(i).getReserveStatus().equals("0")) {
				j++;
			}
		}
		if (getFrequentContactsLists.size() == j && accountInfo.getReserveStatus().equals("0")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 生成一个TD
	 * 
	 * @param reg
	 * @param status
	 * @return
	 */
	private String formateWeekDate(RegisterScheduleDTO registerScheduleDTO,RegisterSchedule reg,String status){
		
		StringBuilder sb = new StringBuilder();
		if (status.equals(STATUS_OK)) {
			sb.append("<td style=\"background-color:#CEFFBE;\">");
		} else if (status.equals(STATUS_FULL)) {
			sb.append("<td style=\"color:red;background-color:#FFBFBF\">");
		}else if (status.equals(STATUS_NOT_RESERVE)) {
			sb.append("<td style=\"background-color:#CEFFBE\">");
		} else{
			sb.append("<td style=\"color:#999999\">");
		}
		if(status.equals(STATUS_OK)){
			sb.append("<a href=\"javascript:void(0);\" class=\"link\" onclick=\"reserveschedule.selectRegisterScheduleTimes(this,([{id:'"+reg.getId()+"',"
			+ "hospitalCode:'"+reg.getHospitalCode()+"'}]))\" title=\"点击预约\" >");
			sb.append("预约");
		} else if (status.equals(STATUS_NOT_RESERVE)) {
			sb.append("<label title=\"无可预约的用户\" disabled=\"disabled\" >");
			sb.append("预约");
		}else{
			sb.append(status);
		}
		if(status.equals(STATUS_OK)){
			sb.append("</a>");
		}
		if(status.equals(STATUS_NOT_RESERVE)){
			sb.append("</label>");
		}
		sb.append("</td>");
		return sb.toString();
	}

	
	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}


	public String getRegisterFee() {
		return registerFee;
	}

	public void setRegisterFee(String registerFee) {
		this.registerFee = registerFee;
	}

	public String getDeptSn() {
		return deptSn;
	}


	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}


	public String getDoctorSn() {
		return doctorSn;
	}


	public void setDoctorSn(String doctorSn) {
		this.doctorSn = doctorSn;
	}


	public String getClinicType() {
		return clinicType;
	}


	public void setClinicType(String clinicType) {
		this.clinicType = clinicType;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getAmPm() {
		return amPm;
	}

	public void setAmPm(String amPm) {
		this.amPm = amPm;
	}

	public int getReserveFlag() {
		return reserveFlag;
	}

	public void setReserveFlag(int reserveFlag) {
		this.reserveFlag = reserveFlag;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public List<RegisterSchedule> getRegisterSchedules() {
		return registerSchedules;
	}

	public void setRegisterSchedules(List<RegisterSchedule> registerSchedules) {
		this.registerSchedules = registerSchedules;
	}
	
}
