/**   
* @Title: ReserveHisServiceImpl.java 
* @Package com.founder.rhip.portal.service 
* @Description:预约和HIS交互的接口
* @author LJY
* @date 2013-8-8 下午2:26:34 
* @version V1.0   
*/
package com.founder.rhip.portal.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.portal.OutClinic;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;
//import com.founder.rhip.portal.dto.CheckLockRequest;
import com.founder.rhip.portal.dto.DataRow;
import com.founder.rhip.portal.dto.GetDeptmentListRequest;
import com.founder.rhip.portal.dto.GetDeptmentListResponse;
import com.founder.rhip.portal.dto.GetScheduleListRequest;
import com.founder.rhip.portal.dto.GetScheduleListResponse;
import com.founder.rhip.portal.dto.InputValues;
import com.founder.rhip.portal.dto.NewOrderRequest;
import com.founder.rhip.portal.dto.NewOrderResponse;
import com.founder.rhip.portal.dto.PageActionIn;
import com.founder.rhip.portal.dto.Retrieveargs;
import com.founder.rhip.portal.service.util.Axis2Util;
import com.founder.rhip.portal.service.util.Constants;
import com.founder.rhip.portal.service.util.ValidateUtil;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;

/**
 * @ClassName: ReservePayServiceImpl
 * @Description: 预约支付相关接口
 * @author  bagen
 * @date 2016年3月16日
 *
 */
@Service("firstHospitalReserveAdapter")
public class FirstHospitalReserveAdapter  implements IHospitalReserveAdapter {

	@Autowired
	private IHospitalInfoDao hospitalInfoDao;
	
	protected static Logger logger = Logger.getLogger(FirstHospitalReserveAdapter.class.getName());
	//第一人民医院最后修改时间
    private static final String BEGINDATE="2014-01-01";

	@Override
	public Map<String,Object> queryDepartmentList() {
		Retrieveargs re = new Retrieveargs();
		re.setBegindate(BEGINDATE);
		GetDeptmentListRequest deptmentListRequest = new GetDeptmentListRequest();
		deptmentListRequest.setPageactionin(new PageActionIn());
		deptmentListRequest.setRetrieveargs(re);
		String requestXml = XmlWebserviceForUtil.getString(deptmentListRequest,GetDeptmentListRequest.class);
		String[] params = new String[]{Base64Util.encrypt(requestXml.toString(), "UTF-8")};
		String response = Axis2Util.sendService(params, "GetDeptmentList", Constants.FIRST_HOSPITAL);
		Map<String, Object> mapResult = Axis2Util.toXmlResult(response,Constants.FIRST_HOSPITAL);
		if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE))) {
			return mapResult;
		}
		//获取返回的XML
		String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
		try {
			GetDeptmentListResponse deptmentListResponse = XmlWebserviceForUtil.parseDataXml(responseXml,GetDeptmentListResponse.class);
			
			//接口返回错误
			if(!Axis2Util.checkResult(deptmentListResponse.getReturnresult())){
				mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
				mapResult.put(Constants.RESERVE_RET_MSG,(deptmentListResponse.getReturnresult()).getErrormsg());
				return mapResult;
			}
			//将获取的科室信息set到outClinic中
			List<OutClinic> outClinics = new ArrayList<OutClinic>();
			for (DataRow dr : deptmentListResponse.getData_row()) {
				OutClinic outClinic = new OutClinic();
				outClinic.setHospitalCode(dr.getHospitalCode());
				outClinic.setDeptSn(dr.getDeptSn());
				outClinic.setName(dr.getName());
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
	public Map<String, Object> querySchduleList(String hospitalcode,Date requestDate, String ampm, 
			String clinicCode, String deptName, String doctorSn, String clinicType) {
		Retrieveargs re = new Retrieveargs();
		re.setDeptcode(StringUtils.trimToEmpty(clinicCode));
		re.setDoctorno(StringUtils.trimToEmpty(doctorSn));
		if (StringUtil.isNotEmpty(ampm)) {
			re.setTimeinterval("a".equals(ampm)?"am":"pm");
		}
		if (ObjectUtil.isNotEmpty(requestDate)) {
			re.setStartRequestDate(DateUtil.convertDate("MM-dd-yyyy",requestDate));
			re.setEndRequestDate(DateUtil.convertDate("MM-dd-yyyy",requestDate));
		} else {
			re.setStartRequestDate(DateUtil.convertDate("MM-dd-yyyy", Axis2Util.getDate().get("sDate")));
			re.setEndRequestDate(DateUtil.convertDate("MM-dd-yyyy", Axis2Util.getDate().get("eDate")));
		}
		
		GetScheduleListRequest sechduleListRequest = new GetScheduleListRequest();
		sechduleListRequest.setPageactionin(new PageActionIn());
		sechduleListRequest.setRetrieveargs(re);
		String requestXml = XmlWebserviceForUtil.getString(sechduleListRequest,GetScheduleListRequest.class);
		String[] params = new String[]{Base64Util.encrypt(requestXml.toString(), "UTF-8")};
		String response = Axis2Util.sendService(params, "GetScheduleList", hospitalcode);
		Map<String, Object> mapResult = Axis2Util.toXmlResult(response,Constants.FIRST_HOSPITAL);
		if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE))) {
			return mapResult;
		}
		//获取返回的XML
		String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
		try {
			GetScheduleListResponse scheduleListResponse = XmlWebserviceForUtil.parseDataXml(responseXml,GetScheduleListResponse.class);
			
			//接口返回错误
			if(!Axis2Util.checkResult(scheduleListResponse.getReturnresult())){
				mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
				mapResult.put(Constants.RESERVE_RET_MSG,(scheduleListResponse.getReturnresult()).getErrormsg());
				return mapResult;
			}
			//将获取的科室信息set到outClinic中
			List<RegisterSchedule> rsLists = new ArrayList<RegisterSchedule>();
			String hospitalName = hospitalInfoDao.get(new Criteria("HOSPITAL_NO",Constants.FIRST_HOSPITAL).add("IS_DELETE","0")).getHospitalName();
			for (DataRow dr : scheduleListResponse.getData_row()) {
				RegisterSchedule rs = new RegisterSchedule();
				String requestDates = dr.getRequestDate().replace("-", "/");
				rs.setId(Long.parseLong(dr.getScheduleid()));
				rs.setHospitalCode(dr.getHospitalCode());
				rs.setHospitalName(hospitalName);
				rs.setRequestDate(DateUtil.parseDateString(requestDates));
				rs.setAmpm(("AM".equals(dr.getAmpm()))?"a":"p");
				if ("AM".equals(dr.getAmpm())) {
					rs.setTimeIntervalStart("08:00");
					rs.setTimeIntervalEnd("11:00");
				} else {
					rs.setTimeIntervalStart("14:00");
					rs.setTimeIntervalEnd("17:00");
				}
				rs.setDeptSn(dr.getDeptSn());
				rs.setDeptName(dr.getName());
				rs.setDoctorSn(dr.getDoctorSn());
				rs.setDoctorName(dr.getDoctorname());
				rs.setRegisterFee(Double.valueOf(dr.getClinicfee())+Double.valueOf(dr.getRegisterFee()));
				rs.setReserveStatus(String.valueOf(dr.getReserveflag()));
				rsLists.add(rs);
			}
			mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_CORRECT);
			if (StringUtil.isNotEmpty(clinicCode) && StringUtil.isNotEmpty(deptName)) {
				//显示医院7天内有排班资源的医生数量(通过所有的排班资源信息列表来筛选可预约的医生数量)
				mapResult.put(Constants.RESERVE_RET_MSG, Axis2Util.schedulesCombineByConditions(rsLists));
			} else {
				//显示该医生7天内的所有排班资源信息列表
				mapResult.put(Constants.RESERVE_RET_MSG, rsLists);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return mapResult;
	}

	@Override
	public Map<String,Object> saveReserve(ReserveRegister reserveRegister) {
		Map<String, Object> mapResult = new HashMap<String, Object>();
		//判断前台传值
		String validateResult = ValidateUtil.doValidate(reserveRegister,"hospitalCode","phoneNumber","ampm","registerScheduleTimeId",
				"submitUser");
        //判断必须项
		if(StringUtil.isNotEmpty(validateResult)){
            logger.error(validateResult);
            mapResult.put(Constants.RESERVE_RET_CODE, Constants.RET_CODE_ERROR);
            mapResult.put(Constants.RESERVE_RET_MSG,validateResult);
            return mapResult;
        }
		
		//生成挂号订单并锁号
		NewOrderRequest newOrderReq = new NewOrderRequest();
		InputValues inputValues = new InputValues();
		inputValues.setReservemobile(reserveRegister.getPhoneNumber());
		inputValues.setHospitalid(reserveRegister.getHospitalCode());
		inputValues.setScheduleid(reserveRegister.getRegisterScheduleTimeId());
		inputValues.setParttimeid(reserveRegister.getAmpm());
		inputValues.setCreator(reserveRegister.getSubmitUserName());
		newOrderReq.setInputvalues(inputValues);
		
		String requestXml = XmlWebserviceForUtil.getString(newOrderReq,NewOrderRequest.class);
		String[] params = new String[]{Base64Util.encrypt(requestXml.toString(), "UTF-8")};
		String response = Axis2Util.sendService(params, "NewOrder", reserveRegister.getHospitalCode());
		mapResult = Axis2Util.toXmlResult(response,Constants.FIRST_HOSPITAL);
		if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE))) {
			return mapResult;
		}
		NewOrderResponse newOrderResponse = null;
		String responseXml = mapResult.get(Constants.RESERVE_RET_MSG).toString();
		try {
			newOrderResponse = XmlWebserviceForUtil.parseDataXml(responseXml,NewOrderResponse.class);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		//检查锁号是否成功
		inputValues = new InputValues();
		inputValues.setOrderid(newOrderResponse.getOutputValues().getOrderid());
//		CheckLockRequest checkLockReq = new CheckLockRequest();
//		checkLockReq.setInputvalues(inputValues);
//
//		String requestCheckXml = XmlWebserviceForUtil.getString(checkLockReq,CheckLockRequest.class);
//		String[] paramsCheck = new String[]{Base64Util.encrypt(requestCheckXml.toString(), "UTF-8")};
//		String responseCheck = Axis2Util.sendService(paramsCheck, "NewOrder", reserveRegister.getHospitalCode());
//		mapResult = Axis2Util.toXmlResult(response);
//		if (Constants.RET_CODE_ERROR.equals(mapResult.get(Constants.RESERVE_RET_CODE))) {
//			return mapResult;
//		}
		
		return null;
	}

    @Override
    public Map<String, Object> cancleReserve(ReserveRegister reserveRegister) {
        return null;
    }

    @Override
    public Map<String, Object> selectSchdule(RegisterSchedule registerSchedule) {
        return null;
    }

}
