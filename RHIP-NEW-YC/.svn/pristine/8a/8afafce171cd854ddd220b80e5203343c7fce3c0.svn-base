/**   
* @Title: StomatologicalHospitalReserveAdapter.java 
* @Package com.founder.rhip.portal.service 
* @Description:预约和HIS交互的接口
* @author LJY
* @date 2013-8-8 下午2:26:34 
* @version V1.0   
*/
package com.founder.rhip.portal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.rhip.portal.dto.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.ReserveStauts;
import com.founder.rhip.ehr.entity.portal.OutClinic;
import com.founder.rhip.ehr.entity.portal.OutReginfo;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
import com.founder.rhip.ehr.repository.portal.IOutReginfoDao;
import com.founder.rhip.ehr.repository.portal.IReserveRegisterDao;
import com.founder.rhip.portal.common.TransCodeConstants;
import com.founder.rhip.portal.service.util.Axis2Util;
import com.founder.rhip.portal.service.util.Constants;
import com.founder.rhip.portal.service.util.ValidateUtil;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;

/**
 * @ClassName: StomatologicalHospitalReserveAdapter
 * @Description: 口腔医院预约相关接口
 * @author  bagen
 * @date 2016年5月26日
 *
 */
@Service("stomatologicalHospitalReserveAdapter")
public class StomatologicalHospitalReserveAdapter  implements IHospitalReserveAdapter {

	@Autowired
	private IHospitalInfoDao hospitalInfoDao;

    @Autowired
    private IReserveRegisterDao reserveRegisterDao;
    
    @Autowired
    private IOutReginfoDao outReginfoDao;
	
	protected static Logger logger = Logger.getLogger(StomatologicalHospitalReserveAdapter.class.getName());

	@Override
	public Map<String,Object> queryDepartmentList(){
		Map<String, Object> mapResult = new HashMap<String, Object>();
		GetDeptmentListRequestFY deptRequest = new GetDeptmentListRequestFY();
		String requestXml = XmlWebserviceForUtil.getString(deptRequest,GetDeptmentListRequestFY.class);
		String[] params = new String[]{TransCodeConstants.QUERY_CLINIC,requestXml.toString()};
		String response = Axis2Util.sendService(params, TransCodeConstants.INTERFACE_TRADE_JKZL, Constants.STOMATOLOGICAL_HOSPITAL);
		mapResult = Axis2Util.toXmlResult(response,Constants.STOMATOLOGICAL_HOSPITAL);
		if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE))) {
			return mapResult;
		}
		//获取返回的XML
		String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
		try {
			GetDeptmentListResponseFY deptmentListResponse = XmlWebserviceForUtil.parseDataXml(responseXml,GetDeptmentListResponseFY.class);
			//接口返回错误
			if("0".equals(deptmentListResponse.getRespCode())?false:true) {
				mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
				mapResult.put(Constants.RESERVE_RET_MSG,(deptmentListResponse.getRespMessage()));
				return mapResult;
			}
			//将获取的科室信息set到outClinic中
			List<OutClinic> outClinics = new ArrayList<OutClinic>();
			for (Dept dept : deptmentListResponse.getUpperDept()) {
				OutClinic outClinic = new OutClinic();
				outClinic.setHospitalCode(Constants.STOMATOLOGICAL_HOSPITAL);
				outClinic.setDeptSn(dept.getDeptSn());
				outClinic.setName(dept.getDeptName());
				outClinics.add(outClinic);
			}
			mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
			mapResult.put(Constants.RESERVE_RET_MSG, outClinics);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return mapResult;
	}

	@Override
	public Map<String, Object> querySchduleList(String hospitalcode, Date requestDate, String ampm,
			String clinicCode, String deptName, String doctorSn, String clinicType) {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		GetSchduleListRequestFY schReq = new GetSchduleListRequestFY();
		schReq.setTransactionCode(TransCodeConstants.QUERY_RESERVE);
		Map<String,Date> dateMap = Axis2Util.getDate();
		schReq.setDeptCode(StringUtils.trimToEmpty(clinicCode));
		schReq.setDoctorCode(StringUtils.trimToEmpty(doctorSn));
		if (ObjectUtil.isNotEmpty(requestDate)) {
			schReq.setWorkDateStart(DateUtil.toDateString(requestDate,"yyyy-MM-dd"));
			schReq.setWorkDateEnd(DateUtil.toDateString(requestDate, "yyyy-MM-dd"));
		} else {
			schReq.setWorkDateStart(DateUtil.toDateString(dateMap.get("sDate"),"yyyy-MM-dd"));
			schReq.setWorkDateEnd(DateUtil.toDateString(dateMap.get("eDate"),"yyyy-MM-dd"));
		}
		if (StringUtil.isNotEmpty(ampm)) {
			schReq.setWorkTime("a".equals(ampm)?"1":"2");// "0" 全天  "1"上午  "2"下午
		}
		schReq.setStatus("0");// "0" 接诊  "1"停诊  "2"全部
		//转化成xml发送报文
		String requestXml = XmlWebserviceForUtil.getString(schReq, GetSchduleListRequestFY.class);
        //请求参数
        String[] params = new String[]{TransCodeConstants.QUERY_RESERVE,requestXml};
		//webservice发送报文并返回
		String resultXml = Axis2Util.sendService(params,TransCodeConstants.INTERFACE_TRADE_JKZL,Constants.STOMATOLOGICAL_HOSPITAL);
        mapResult = Axis2Util.toXmlResult(resultXml, Constants.STOMATOLOGICAL_HOSPITAL);
        if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE))) {
            return mapResult;
        }
        //获取返回的XML
        String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
        GetSchduleListResponseFY schResp = null;
		try {
			schResp = XmlWebserviceForUtil.parseDataXml(responseXml,GetSchduleListResponseFY.class);
		} catch (Exception e) {
			e.printStackTrace();
            logger.error(e.getMessage());
		}
		//接口返回错误情况
		if(!"0".equals(schResp.getRespCode())){
			mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
			mapResult.put(Constants.RESERVE_RET_MSG, schResp.getRespMessage());
			return  mapResult;
		}
		List<RegisterSchedule> registerSchedules = new ArrayList<RegisterSchedule>();
		String hospitalName = hospitalInfoDao.get(new Criteria("HOSPITAL_NO",Constants.STOMATOLOGICAL_HOSPITAL).add("IS_DELETE","0")).getHospitalName();
		if (schResp.getPreInfo() != null) {
			for (PerInfo perInfo : schResp.getPreInfo()) {
				if (!"0".equals(perInfo.getPreLimit()) && StringUtil.isNotEmpty(perInfo.getPreLimit())) {//妇幼预约限号
					RegisterSchedule registerSchedule = new RegisterSchedule();
					registerSchedule.setHospitalCode(Constants.STOMATOLOGICAL_HOSPITAL);
					registerSchedule.setHospitalName(hospitalName);
					registerSchedule.setAmpm("1".equals(perInfo.getWorkType())?"a":"p");
					registerSchedule.setRequestDate(perInfo.getWorkDate());
					registerSchedule.setDeptSn(perInfo.getDeptCode());
					registerSchedule.setDoctorSn(perInfo.getDocCode());
					registerSchedule.setDoctorName(perInfo.getDocName());
					registerSchedule.setDeptName(perInfo.getDeptName());
					String sTime = perInfo.getSTime();//诊疗开始时间
					String eTime = perInfo.getETime();//诊疗结束时间
					registerSchedule.setTimeIntervalStart(sTime.length() > 4?sTime.substring(0, 5):sTime);//显示时分
					registerSchedule.setTimeIntervalEnd(eTime.length() >4?perInfo.getETime().substring(0, 4):eTime);
					String preLimit = perInfo.getPreLimit();
					String preNum = perInfo.getPreNum();
					String status = "";
					if("1".equals(perInfo.getStatus())){
						status = "3";
					}else if("0".equals(preNum)){
						status = "2";
					}else{
						status = "1";
					}
					registerSchedule.setAdmitNum(StringUtil.isNullOrEmpty(preLimit)?0l:Long.valueOf(preLimit));
					registerSchedule.setReserveStatus(status);
					registerSchedule.setReserveNum(StringUtil.isNullOrEmpty(preNum)?0l:Long.valueOf(preNum));
					String registCode = perInfo.getRegistCode();
					if(StringUtil.isNotEmpty(registCode)){
						registerSchedule.setClinicType(("1".equals(registCode) ? "1" : "2"));
					}
					registerSchedules.add(registerSchedule);
				} else {
					continue;
				}
			}
		}
		
		if (ObjectUtil.isNotEmpty(registerSchedules)) {
			mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
			if(StringUtil.isNotEmpty(clinicCode) && StringUtil.isNotEmpty(deptName)){
				//显示医院7天内有排班资源的医生数量
				mapResult.put(Constants.RESERVE_RET_MSG, Axis2Util.schedulesCombineByConditions(registerSchedules));
				
			}else {
				////显示该医生7天内的所有排班资源信息列表
				mapResult.put(Constants.RESERVE_RET_MSG, registerSchedules);
			}
		} else {
			mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
		}
		return mapResult;
	}

	@Override
	public Map<String,Object> saveReserve(ReserveRegister reserveRegister){
        Map<String, Object> mapResult = new HashMap<String, Object>();
        String sickId = null;
        Date registTime = null;
        //判断前台传值
  		String validateResult = ValidateUtil.doValidate(reserveRegister,"idcard","phoneNumber","ampm","deptSn","doctorSn",
  				"timeIntervalStart","requestDate","name");
          //判断必须项
  		if(StringUtil.isNotEmpty(validateResult)){
	          logger.error(validateResult);
	          mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
	          mapResult.put(Constants.RESERVE_RET_MSG,validateResult);
	          return mapResult;
	      }
      		
        	mapResult = this.queryPatientInfo(reserveRegister);//通过HIS查询患者的信息
        	PatientInfoResponseFY patientInfoRep = (PatientInfoResponseFY) mapResult.get("patientInfoRep");
        	//接口返回错误情况
        	if(!"0".equals(patientInfoRep.getRespCode())) {//通过HIS，没有查询到患者信息
        		logger.error(patientInfoRep.getRespMessage());
                mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
                mapResult.put(Constants.RESERVE_RET_MSG,"暂未开通无卡预约服务，请先去口腔医院办理就诊卡后再进行网上预约，给您带来的不便，敬请谅解");
                return mapResult;
        	} else {
        		if (ObjectUtil.isNotEmpty(patientInfoRep.getSickInfo().getCardNo())) {//通过HIS，查询到患者之前操作过无卡预注册，但实际没有就诊卡号
        			sickId = patientInfoRep.getSickInfo().getPatientID();//通过HIS查询患者的信息,获取sickId
        		} else {
        			logger.error("请您先办理就诊卡再进行预约！");
                    mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
                    mapResult.put(Constants.RESERVE_RET_MSG,"暂未开通无卡预约服务，请先去口腔医院办理就诊卡后再进行网上预约，给您带来的不便，敬请谅解");
                    return mapResult;
        		}
        	}
        	
		//发送保存预约报文 相关bean的赋值
		SaveReserveRequestFY saveReserveRequestFY = new SaveReserveRequestFY();
		saveReserveRequestFY.setIDCardNo(reserveRegister.getIdcard());
		saveReserveRequestFY.setMobile(reserveRegister.getPhoneNumber());
		saveReserveRequestFY.setName(reserveRegister.getName());
		saveReserveRequestFY.setWorkDate(DateUtil.toDateString(reserveRegister.getRequestDate(), "yyyy-MM-dd"));
		saveReserveRequestFY.setWorkType("a".equals(reserveRegister.getAmpm()) ? "1" : "2");
		saveReserveRequestFY.setDeptCode(reserveRegister.getDeptSn());
		saveReserveRequestFY.setDocCode(reserveRegister.getDoctorSn());
		saveReserveRequestFY.setSTime(reserveRegister.getTimeIntervalStart());
		saveReserveRequestFY.setCustomTime(DateUtil.toDateString(new Date(), "yyyy-MM-dd"));
		saveReserveRequestFY.setSickID(sickId);
		if ("0".equals(patientInfoRep.getRespCode())) {
			if (ObjectUtil.isNotEmpty(patientInfoRep.getSickInfo().getCardNo())) {
				saveReserveRequestFY.setCardNo(patientInfoRep.getSickInfo().getCardNo());
			}
		}
		String requestXml = XmlWebserviceForUtil.getString(saveReserveRequestFY,SaveReserveRequestFY.class);
		//请求参数
	    String[] params = new String[]{TransCodeConstants.RESERVE_REGISTER,requestXml};
		//webservice发送报文并返回
		String resultXml = Axis2Util.sendService(params,TransCodeConstants.INTERFACE_TRADE_JKZL,Constants.STOMATOLOGICAL_HOSPITAL);
	    mapResult = Axis2Util.toXmlResult(resultXml, Constants.STOMATOLOGICAL_HOSPITAL);
	    if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE).toString())) {
	    	return mapResult;
	    }
	    String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
        SaveReserveResponseFY resReserve =  new SaveReserveResponseFY();
        try {
            resReserve = XmlWebserviceForUtil.parseDataXml(responseXml, SaveReserveResponseFY.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //接口返回错误情况
        if(!"0".equals(resReserve.getRespCode())){
            logger.error(resReserve.getRespMessage());
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,resReserve.getRespMessage());
            return mapResult;
        }
        //保存预约信息
        reserveRegister.setSearchCode(resReserve.getSeqNumber());//HIS编号 识别号源的唯一标志
        reserveRegister.setSubmitDate(new Date());
        reserveRegister.setGender(IDCardUtil.getGenderByIdCard(reserveRegister.getIdcard()));
        reserveRegister.setBirthday(IDCardUtil.getBirthDateByIdCard(reserveRegister.getIdcard()));
        reserveRegister.setReserverStauts(ReserveStauts.SWDZ.getStauts());//预约标志
        reserveRegister.setRegisterScheduleTimeId("");
        Long id  =reserveRegisterDao.generatedKey(reserveRegister, "ID", null).longValue();
        if(id == 0 ){
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG, "预约记录保存失败");
            return mapResult;
        }
        reserveRegister.setId(id);
        if ("0".equals(patientInfoRep.getRespCode())) {
        	if (ObjectUtil.isNotEmpty(patientInfoRep.getSickInfo().getRegistTime())) {
        		reserveRegister.setRegistTime(DateUtil.parseSimpleDate(patientInfoRep.getSickInfo().getRegistTime(),"yyyy-MM-dd HH:mm:ss"));
        	}
        }
        mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
        mapResult.put(Constants.RESERVE_RET_MSG, reserveRegister);
        return mapResult;
	}

	
	/***
	 * 
	* @Title: queryPatientInfo 
	* @Description: 根据HIS获取患者基本信息
	* @param @param reserveRegister
	* @param @return  参数说明 
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	private Map<String, Object> queryPatientInfo(ReserveRegister reserveRegister) {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		PatientInfoRequestFY patientInfoReq = new PatientInfoRequestFY();
        patientInfoReq.setIDCardID(reserveRegister.getIdcard());
        patientInfoReq.setMobile(reserveRegister.getPhoneNumber());
        patientInfoReq.setName(reserveRegister.getName());
        //转化成xml发送报文
		String requestXml = XmlWebserviceForUtil.getString(patientInfoReq, PatientInfoRequestFY.class);
	    //请求参数
	    String[] params = new String[]{TransCodeConstants.QUERY_PATIENT_INFO,requestXml};
		//webservice发送报文并返回
		String resultXml = Axis2Util.sendService(params,TransCodeConstants.INTERFACE_TRADE_JKZL,Constants.STOMATOLOGICAL_HOSPITAL);
	    mapResult = Axis2Util.toXmlResult(resultXml, Constants.STOMATOLOGICAL_HOSPITAL);
	    if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE).toString())) {
	    	return mapResult;
	    }
	    String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
	    PatientInfoResponseFY patientInfoRep = new PatientInfoResponseFY();
	    try {
			patientInfoRep = XmlWebserviceForUtil.parseDataXml(responseXml,PatientInfoResponseFY.class);
		} catch (Exception e) {
			e.printStackTrace();
            logger.error(e.getMessage());
		}
	    mapResult.put("patientInfoRep", patientInfoRep);
		return mapResult;
	}
	
	
	/***
	 * 
	* @Title: noCardPreRegister 
	* @Description: 根据HIS进行无卡预注册 
	* @param @param reserveRegister
	* @param @return
	* @return Map<String,Object>    返回类型 
	* @throws
	 */
	private Map<String, Object> noCardPreRegister(
			ReserveRegister reserveRegister) {
		Map<String, Object> mapResult;
		NoCardPreRegRequestFY noCardRegReq = new NoCardPreRegRequestFY();
		noCardRegReq.setIDCardID(reserveRegister.getIdcard());
		noCardRegReq.setMobile(reserveRegister.getPhoneNumber());
		noCardRegReq.setName(reserveRegister.getName());
		noCardRegReq.setBirthDay(DateUtil.toDateString(IDCardUtil.getBirthDateByIdCard(reserveRegister.getIdcard()), "yyyy-MM-dd"));
		noCardRegReq.setSex("1".equals(IDCardUtil.getGenderByIdCard(reserveRegister.getIdcard())) ? "男" : "女");
		String requestXml = XmlWebserviceForUtil.getString(noCardRegReq, NoCardPreRegRequestFY.class);
		//请求参数
		String[] params = new String[]{TransCodeConstants.NO_CARD_PRE_REG,requestXml};
		String resultXml = Axis2Util.sendService(params, TransCodeConstants.INTERFACE_TRADE_JKZL, Constants.STOMATOLOGICAL_HOSPITAL);
		mapResult = Axis2Util.toXmlResult(resultXml, Constants.STOMATOLOGICAL_HOSPITAL);
		if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE))) {
			return mapResult;
		}
		String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
		NoCardPreRegResponseFY noCardRegResp = new NoCardPreRegResponseFY();
		try {
			noCardRegResp = XmlWebserviceForUtil.parseDataXml(responseXml, NoCardPreRegResponseFY.class);
		} catch (Exception e) {
			e.printStackTrace();
            logger.error(e.getMessage());
		}
		String SickID = noCardRegResp.getSickID();
		mapResult.put("SickID", SickID);
		return mapResult;
	}

    @Override
    public Map<String, Object> cancleReserve(ReserveRegister reserveRegister) {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        //判断前台传值
        String validateResult = ValidateUtil.doValidate(reserveRegister,"searchCode","name");
        //判断必须项
        if(StringUtil.isNotEmpty(validateResult)){
            logger.error(validateResult);
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,validateResult);
            return mapResult;
        }
        CancelReserveRequestFY request = new CancelReserveRequestFY();
        request.setSeqNumber(reserveRegister.getSearchCode());
        request.setName(reserveRegister.getName());
        request.setCustomTime(DateUtil.toDateString(new Date(), "yyyy-MM-dd"));
        String requestXml = XmlWebserviceForUtil.getString(request,CancelReserveRequestFY.class);
        //请求参数
  		String[] params = new String[]{TransCodeConstants.CANCLE_REGISTER,requestXml};
  		String resultXml = Axis2Util.sendService(params, TransCodeConstants.INTERFACE_TRADE_JKZL, Constants.STOMATOLOGICAL_HOSPITAL);
  		mapResult = Axis2Util.toXmlResult(resultXml, Constants.STOMATOLOGICAL_HOSPITAL);
  		if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE))) {
  			return mapResult;
  		}
  		String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
        CancelReserveResponseFY responseFY = new CancelReserveResponseFY();
        try {
            responseFY = XmlWebserviceForUtil.parseDataXml(responseXml, CancelReserveResponseFY.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(!"0".equals(responseFY.getRespCode())){
            logger.error(responseFY.getRespMessage());
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,responseFY.getRespMessage());
            return mapResult;
        }
        mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
        mapResult.put(Constants.RESERVE_RET_MSG, responseFY.getRespMessage());
        return mapResult;
    }

    @Override
    public Map<String, Object> selectSchdule(RegisterSchedule registerSchedule) {
        Map<String, Object> mapResult = new HashMap<String, Object>();
        SelectSchduleRequestFY selectSchduleRequestFY = new SelectSchduleRequestFY();
        selectSchduleRequestFY.setTransactionCode(TransCodeConstants.SELECT_RESERVE);
        selectSchduleRequestFY.setDeptCode(registerSchedule.getDeptSn());
        selectSchduleRequestFY.setDocCode(registerSchedule.getDoctorSn());
        selectSchduleRequestFY.setWorkDate(DateUtil.toDateString(registerSchedule.getRequestDate(), "yyyy-MM-dd"));
        selectSchduleRequestFY.setWorkType("a".equals(registerSchedule.getAmpm()) ? "1" : "2");
        String requestXml = XmlWebserviceForUtil.getString(selectSchduleRequestFY,SelectSchduleRequestFY.class);
        //请求参数
        String[] params = new String[]{TransCodeConstants.SELECT_RESERVE,requestXml};
        String resultXml = Axis2Util.sendService(params, TransCodeConstants.INTERFACE_TRADE_JKZL, Constants.STOMATOLOGICAL_HOSPITAL);
        mapResult = Axis2Util.toXmlResult(resultXml, Constants.STOMATOLOGICAL_HOSPITAL);
        //返回异常情况
        if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE))) {
            return mapResult;
        }
        String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
        SelectSchduleResponseFY schduleRespFY = new SelectSchduleResponseFY();
        try {
            schduleRespFY = XmlWebserviceForUtil.parseDataXml(responseXml, SelectSchduleResponseFY.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取失败
        if(!"0".equals(schduleRespFY.getRespCode())){
            logger.error(schduleRespFY.getRespMessage());
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,schduleRespFY.getRespMessage());
            return mapResult;
        }
        List<TimeList> nums = schduleRespFY.getNum();
        //获取医院名称
        List<RegisterSchedule> registerSchedules = new ArrayList<RegisterSchedule>();
        String hospitalName = hospitalInfoDao.get(new Criteria("HOSPITAL_NO",Constants.STOMATOLOGICAL_HOSPITAL).add("IS_DELETE","0")).getHospitalName();
        for (TimeList num : nums) {
            RegisterSchedule regSchedule = new RegisterSchedule();
            regSchedule.setHospitalCode(Constants.STOMATOLOGICAL_HOSPITAL);
            regSchedule.setHospitalName(hospitalName);
            regSchedule.setAmpm(registerSchedule.getAmpm());
            regSchedule.setRequestDate(registerSchedule.getRequestDate());
            regSchedule.setDeptName(registerSchedule.getDeptName());
            regSchedule.setDeptSn(registerSchedule.getDeptSn());
            regSchedule.setDoctorSn(registerSchedule.getDoctorSn());
            regSchedule.setDoctorName(registerSchedule.getDoctorName());
            regSchedule.setTimeIntervalStart(num.getSTime().substring(0, 5));
            regSchedule.setTimeIntervalEnd(num.getETime().substring(0, 5));
            regSchedule.setReserveStatus("1".equals(num.getPreOrNo())?"1":"2");
            registerSchedules.add(regSchedule);
        }
        mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
        mapResult.put(Constants.RESERVE_RET_MSG, registerSchedules);
        return mapResult;
    }

}
