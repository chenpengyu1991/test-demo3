package com.founder.rhip.portal.tld;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.RegisterScheduleDTO;
import com.founder.rhip.ehr.entity.portal.*;
import com.founder.rhip.portal.common.Constants;
import com.founder.rhip.portal.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import java.util.Date;
import java.util.List;

/**
 * 预约排班资源标签
 * @author Liu jingyin
 *
 */          
public class PortalHotExpertRegisterScheduleTag extends BaseTag {

	private static final long serialVersionUID = -2965834693493677396L;

	private String hospitalCode;
	private String deptSn;
	private String doctorSn;
	private String clinicType;
	private String startDate;
	private String endDate;
	private String registerFee;
	private String contextPath;
	
	private static final String STATUS_NULL ="";
	private static final String STATUS_NOT_RESERVE = "无可预约人";
	private static final String STATUS_FULL = "已满";
	private static final String STATUS_OK = "可预约";
	private static final String STATUS_STOP = "已停诊";
	
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
			RegisterScheduleDTO registerScheduleDTO = registerSchedule.getRegisterScheduleDetail(hospitalCode, deptSn,sDate, eDate);
			
			html.append("<tr>");
			html.append("<td>");
			html.append("上午");
			html.append("</td>");
			html.append(getWeekTds(registerScheduleDTO,"a",sDate,eDate));
			html.append("</tr>");
			html.append("<tr>");
			html.append("<td>");
			html.append("下午");
			html.append("</td>");
			html.append(getWeekTds(registerScheduleDTO,"p",sDate,eDate));
			html.append("</tr>");
		
			JspWriter jw = pageContext.getOut();
			jw.write(html.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	/**
	 * 分别获取上午和下午的出诊排班
	 * @param registerScheduleDTO
	 * @param ampm
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private String getWeekTds(RegisterScheduleDTO registerScheduleDTO,String ampm,Date startDate,Date endDate){
		String tdString = "";
		List<Date> dateList = registerSchedule.getBetweenDate(startDate, endDate);
		StopDoctor stopDoctor = getStopDoctor(registerScheduleDTO);
		for(Date date:dateList){
			String td = getWeekTd(stopDoctor,registerScheduleDTO,ampm,date);
			tdString += td;
		}
		return tdString;
	}
	
	/**
	 * 查询停诊医生
	 * @return
	 */
	private StopDoctor getStopDoctor(RegisterScheduleDTO registerScheduleDTO){
		if(ObjectUtil.isNullOrEmpty(registerScheduleDTO.getOutDoctor())){
			return null;
		}
		Criteria criteria = new Criteria();
		criteria.add("hospitalCode", registerScheduleDTO.getOutDoctor().getHospitalCode());
		criteria.add("deptSn", registerScheduleDTO.getOutDoctor().getDeptSn());
		criteria.add("doctorSn", registerScheduleDTO.getOutDoctor().getDoctorSn());
		criteria.add("stopingStatus", 1);
		StopDoctor stopDoctor = stopDoctorService.getStopDoctor(criteria);
		return stopDoctor;
	}
	
	private String getWeekTd(StopDoctor stopDoctor,RegisterScheduleDTO registerScheduleDTO,String ampm,Date date){

		for(RegisterSchedule reg : registerScheduleDTO.getRegisterSchedules()){
			String yyString = DateUtil.toFormatString("yyyy/MM/dd", reg.getRequestDate());
			Date yyDate = DateUtil.parseDateString(yyString);

			if(isStop(stopDoctor,date) && date.equals(yyDate)){
				return formateWeekDate(null,null,STATUS_STOP);
			}

			if (yyDate.equals(date) && reg.getAmpm().equals(ampm)) {
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
							
						} */else {
							
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
			sb.append("<td style=\"color:#999999\">");
		} else{
			sb.append("<td style=\"color:green\">");
		}
		if(status.equals(STATUS_OK)){
			sb.append("<a href=\"javascript:void(0);\" class=\"link\" onclick=\"hotExpertSearch.selectRegisterScheduleTimes(this,"+reg.getId()+")\" title=\"点击预约\" >");
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
}
