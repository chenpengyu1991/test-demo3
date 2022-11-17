package com.founder.rhip.ehr.tld;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.RegisterScheduleDTO;
import com.founder.rhip.ehr.entity.portal.OutDoctor;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.RegisterScheduleTime;
import com.founder.rhip.ehr.entity.portal.StopDoctor;
import com.founder.rhip.portal.common.ScheduleStatus;
import com.founder.rhip.portal.service.IRegisterScheduleService;
import com.founder.rhip.portal.service.IReserveService;
import com.founder.rhip.portal.service.IStopDoctorService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.xml.bind.JAXBException;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 预约排班资源标签
 * @author Liu jingyin
 *
 */          
public class RegisterScheduleTag extends BaseTag {

	private static final long serialVersionUID = -2965834693493677396L;

	private String hospitalCode;
	private String deptSn;
	private String doctorSn;
	private String clinicType;
	private String startDate;
	private String endDate;
	private String registerFee;
	
	private static final String STATUS_NULL = "";
	private static final String STATUS_FULL = ScheduleStatus.FULL.getValue();
	private static final String STATUS_STOP = ScheduleStatus.STOP.getValue();
	private static final String STATUS_OK = ScheduleStatus.NORMAL.getValue();
	
	@Autowired
   	private IReserveService reserveService;
	
	@Autowired
   	private IRegisterScheduleService registerSchedule;
	
	@Autowired
   	private IStopDoctorService stopDoctorService;
	
	public int doStartTagInternal() throws JspTagException {
		inject();
		try {
			StringBuilder html = new StringBuilder();
			
			Date sDate = DateUtil.parseSimpleDate(startDate, "yyyy/MM/dd");
			Date eDate = DateUtil.parseSimpleDate(endDate, "yyyy/MM/dd");
			RegisterScheduleDTO registerScheduleDTO;
			try {
				registerScheduleDTO = registerSchedule.getRegisterScheduleDetail(hospitalCode, deptSn, sDate, eDate);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
			
			html.append("<tr>");
			html.append("<td rowspan=\"2\" style=\"text-align:center\">");
//			html.append(registerScheduleDTO.getOutClinic().getName());
			html.append("</td>");
			html.append("<td rowspan=\"2\" style=\"text-align:center\">");
//			html.append(getDoctorName(registerScheduleDTO.getOutDoctor()));
			html.append("</td>");
			html.append("<td rowspan=\"2\" style=\"text-align:center\">");
//			html.append(registerScheduleDTO.getRegisterSchedules().get(0).getRegisterFee());
			html.append("</td>");
			html.append("<td>");
			html.append("上午");
			html.append("</td>");
//			html.append(getWeekTds(registerScheduleDTO,"a",sDate,eDate));
			html.append("</tr>");
			html.append("<tr>");
			html.append("<td>");
			html.append("下午");
			html.append("</td>");
//			html.append(getWeekTds(registerScheduleDTO,"p",sDate,eDate));
			html.append("</tr>");
		
			JspWriter jw = pageContext.getOut();
			jw.write(html.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	private String getDoctorName(OutDoctor outDoctor){
		if(ObjectUtil.isNotEmpty(outDoctor)){
			return outDoctor.getName();
		}
		return "";
	}

	/**
	 * 分别获取上午和下午的出诊排班
	 * @param registerScheduleDTO
	 * @param ampm
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private String getWeekTds(RegisterScheduleDTO registerScheduleDTO,String ampm, Date startDate,Date endDate){
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
		for(RegisterSchedule reg:registerScheduleDTO.getRegisterSchedules()){
			String yyString = DateUtil.toFormatString("yyyy/MM/dd", reg.getRequestDate());
			Date yyDate = DateUtil.parseDateString(yyString);
			
			
			if(isStop(stopDoctor,yyDate)){
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
						} else {
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
	
	/**
	 * 生成一个TD
	 * 
	 * @param reg
	 * @param status
	 * @return
	 */
	private String formateWeekDate(RegisterScheduleDTO registerScheduleDTO,RegisterSchedule reg,String status){
		ServletRequest request = pageContext.getRequest();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + pageContext.getServletContext().getContextPath();
		StringBuilder sb = new StringBuilder();
		if (status.equals(STATUS_OK)) {
			sb.append("<td style=\"text-align:center\">");
		} else {
			sb.append("<td style=\"color:red;text-align:center\">");
		}
		if(status.equals(STATUS_OK)){
			sb.append("<a href=\"javascript:void(0);\" onclick=\"reserveschedule.selectRegisterScheduleTimes(this,"+reg.getId()+")\" title=\"点击预约\" >");
			sb.append("<img src='" + basePath + "/images/reserve/btn.png' style='vertical-align:middle;'>");
		}else{
			sb.append(status);
		}
		if(status.equals(STATUS_OK)){
			sb.append("</a>");
		}
		sb.append("</td>");
		return sb.toString();
	}
	
	/**
	 * 创建方法
	 * @param regDTO
	 * @param reg
	 * @return
	 */
	private String createFun(RegisterScheduleDTO regDTO,RegisterSchedule reg){
		String funString = "reserveschedule.select(";
		StringBuilder dataParam = new StringBuilder("{");
		dataParam.append("scheduleId:'" + reg.getId() + "',");
		dataParam.append("hospitalName:'" + regDTO.getOrganization().getOrganName() + "',");
		dataParam.append("outClinicName:'" + regDTO.getOutClinic().getName() + "',");
		
		if(ObjectUtil.isNotEmpty(regDTO.getOutDoctor())){
			dataParam.append("outDoctorName:'" + regDTO.getOutDoctor().getName() + "',");
		}
		
		dataParam.append("clinicType:'" + reg.getTypeName() + "',");
		dataParam.append("registerFee:'" + reg.getRegisterFee() + "',");
		dataParam.append("requestDate:'" + reg.getRequestDateDetail() + "'");
		dataParam.append("}");
		return funString + dataParam.toString() + ")";
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

	 
}
