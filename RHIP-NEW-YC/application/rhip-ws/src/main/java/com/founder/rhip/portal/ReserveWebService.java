package com.founder.rhip.portal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PortalSetType;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.common.ReserveStauts;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.entity.portal.FrequentContacts;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.entity.portal.StopDoctor;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.portal.dto.GetYYAllDepartmentInfo;
import com.founder.rhip.portal.dto.GetYYClinicDateByDepartment;
import com.founder.rhip.portal.dto.GetYYDoctorByDepartment;
import com.founder.rhip.portal.dto.GetYYDoctorInfo;
import com.founder.rhip.portal.dto.GetYYDoctorInfoByDoctor;
import com.founder.rhip.portal.dto.QueryReserve;
import com.founder.rhip.portal.dto.SearchReserve;
import com.founder.rhip.portal.dto.UpdateResource;
import com.founder.rhip.portal.service.IAccountInfoService;
import com.founder.rhip.portal.service.IFrequentContactsService;
import com.founder.rhip.portal.service.IPortalSetService;
import com.founder.rhip.portal.service.IReserveForClientService;
import com.founder.rhip.portal.service.IReserveHisService;
import com.founder.rhip.portal.service.util.ValidateUtil;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;


@Service("reserveWebService")
@WebService(serviceName="reserveWebService")
public class ReserveWebService extends BaseWebService implements IReserveWebService {

	private static String folder;

	private static String error = "请求数据格式不正确";

	@Resource(name = "reserveHisService")
	private IReserveHisService reserveHisService;

	@Resource(name = "reserveForClientService")
	private IReserveForClientService reserveForClientService;

	@Resource(name = "lhaccountInfoService")
	private IAccountInfoService lhaccountInfoService;

	@Autowired
	private IPlatformService platformService;
	
    @Resource(name = "portalSetService")
    private IPortalSetService portalSetService;
    
    @Resource
	protected WebServiceContext wsContext;
    
    @Resource(name="lhFrequentContactsService")
	private IFrequentContactsService frequentService;

	static {
		Properties properties = PropertiesUtils.initProperties("setting");
		if (ObjectUtil.isNotEmpty(properties)) {
			folder = properties.getProperty("portal.data.folder");
		}
	}

	@Override
	@WebMethod
	public String updateResource(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"updateResource",folder);
			UpdateResource updateResource = XmlWebserviceForUtil.parseDataXml(requestXml,UpdateResource.class);
			return reserveHisService.updateSchedule(updateResource);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}
	
	@Override
	@WebMethod
	public String updateResourceByTime(@WebParam(name = "requestXml") String requestXml) {
		try {
			//保存文档到本地
			XmlWebserviceForUtil.saveDataFile(requestXml,"updateResourceByTime",folder);
			return reserveHisService.updateScheduleByTime(requestXml);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String queryReserve(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"queryReserve",folder);
			SearchReserve searchReserve = XmlWebserviceForUtil.parseDataXml(requestXml,SearchReserve.class);
			return reserveHisService.getReserve(searchReserve);
		} catch (Exception e) {
			e.printStackTrace();
			String errorString =  XmlWebserviceForUtil.returnError(error);
			return errorString;
		}
	}


	@Override
	@WebMethod
	public String searchReserve(@WebParam(name = "requestXml") String requestXml) {
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml,"searchReserve",folder);
			SearchReserve searchReserve = XmlWebserviceForUtil.parseDataXml(requestXml,SearchReserve.class);
			return reserveHisService.searchReserves(searchReserve);
		} catch (Exception e) {
			e.printStackTrace();
			String errorString =  XmlWebserviceForUtil.returnError(error);
			return errorString;
		}
	}

	@Override
	@WebMethod
	public String updatePatientStatus(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"updatePatientStatus",folder);
			QueryReserve queryReserve = XmlWebserviceForUtil.parseDataXml(requestXml,QueryReserve.class);
			return reserveHisService.updateReserveStatus(queryReserve, ReserveStauts.YDZ.getStauts());
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String cancelReserve(@WebParam(name = "requestXml") String requestXml) {
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml,"cancelReserve",folder);
			QueryReserve queryReserve = XmlWebserviceForUtil.parseDataXml(requestXml,QueryReserve.class);
			return reserveHisService.updateReserveStatus(queryReserve, ReserveStauts.QX.getStauts());
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String stopDiagnose(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"stopDiagnose",folder);
			StopDoctor stopDoctor = XmlWebserviceForUtil.parseDataXml(requestXml,StopDoctor.class);
			return reserveHisService.stopingDoctor(stopDoctor);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String renewDiagnose(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"renewDiagnose",folder);
			StopDoctor stopDoctor = XmlWebserviceForUtil.parseDataXml(requestXml,StopDoctor.class);
			return reserveHisService.cancelingDoctor(stopDoctor);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String getYYAllDepartmentInfo(@WebParam(name = "requestXml") String requestXml) {
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml,"getYYAllDepartmentInfo",folder);
			GetYYAllDepartmentInfo getYYAllDepartmentInfo = XmlWebserviceForUtil.parseDataXml(requestXml,GetYYAllDepartmentInfo.class);
			return reserveForClientService.getClinicByType(getYYAllDepartmentInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String getYYDoctorInfo(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"getYYDoctorInfo",folder);
			GetYYDoctorInfo getYYDoctorInfo = XmlWebserviceForUtil.parseDataXml(requestXml,GetYYDoctorInfo.class);
			return reserveForClientService.getScheduleByClinic(getYYDoctorInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String getYYDoctorByDepartment(@WebParam(name = "requestXml") String requestXml) {
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml,"getYYDoctorByDepartment",folder);
			GetYYDoctorByDepartment getYYDoctorByDepartment = XmlWebserviceForUtil.parseDataXml(requestXml,GetYYDoctorByDepartment.class);
			return reserveForClientService.getDoctorByClinic(getYYDoctorByDepartment);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String getYYDoctorByDoctor(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"getYYDoctorByDoctor",folder);
			GetYYDoctorInfoByDoctor getYYDoctorInfoByDoctor = XmlWebserviceForUtil.parseDataXml(requestXml,GetYYDoctorInfoByDoctor.class);
			return reserveForClientService.getScheduleByDoctor(getYYDoctorInfoByDoctor);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String getYYClinicDateByDepartment(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"getYYClinicDateByDepartment",folder);
			GetYYClinicDateByDepartment getYYClinicDateByDepartment = XmlWebserviceForUtil.parseDataXml(requestXml,GetYYClinicDateByDepartment.class);
			return reserveForClientService.getRequestDate(getYYClinicDateByDepartment);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}
	@Override
	@WebMethod
	public String getYYAllDepartmentInfo2(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"getYYAllDepartmentInfo2",folder);
			GetYYAllDepartmentInfo getYYAllDepartmentInfo = XmlWebserviceForUtil.parseDataXml(requestXml,GetYYAllDepartmentInfo.class);
			return reserveForClientService.getClinicByType(getYYAllDepartmentInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}
	@Override
	@WebMethod
	public String getYYDoctorInfo2(@WebParam(name = "requestXml") String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"getYYDoctorInfo2",folder);
			GetYYDoctorInfo getYYDoctorInfo = XmlWebserviceForUtil.parseDataXml(requestXml,GetYYDoctorInfo.class);
			return reserveForClientService.getScheduleByClinic(getYYDoctorInfo);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String saveYYRegister(@WebParam(name = "requestXml") String requestXml) {
		ReserveRegister reserveRegister = null;
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml,"saveYYRegister",folder);
			reserveRegister = XmlWebserviceForUtil.parseDataXml(requestXml,ReserveRegister.class);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
		if(reserveRegister==null)
			return XmlWebserviceForUtil.returnError("请求参数不能为空!");
		/*//数据为空校验   银川全时段使用时间   delete at 2015-12-24 13:49:20
		if(this.reserveEffectiveTime()){
			return XmlWebserviceForUtil.returnError("!");
		}*/
		String validateString = ValidateUtil.doValidate(reserveRegister, "idcard");
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		//银川本地不需验证
//		String from=reserveRegister.getRegFrom();
//		if(IReserveService.REG_WS_CSAPP.equals(from)&&IReserveService.REG_WS_JS.equals(from))
//			return XmlWebserviceForUtil.returnError("预约来源字段不符合规则。");
		AccountInfo accInfo =lhaccountInfoService.get(new Criteria("cardNo", reserveRegister.getIdcard()));
		if(accInfo==null){
			return XmlWebserviceForUtil.returnError("身份证号:"+reserveRegister.getIdcard()+"用户未注册不能预约!");
		}
		//保存预约用户ID
		reserveRegister.setSubmitUser(accInfo.getId());
		reserveRegister.setSubmitOrg(StringUtils.EMPTY);
		String rs = reserveForClientService.saveRegister(reserveRegister);
		return rs;
	}

	@Override
	@WebMethod
	public String searchReserveByDate(String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"queryReserveRegister",folder);
			SearchReserve searchReserve = XmlWebserviceForUtil.parseDataXml(requestXml,SearchReserve.class);
			//若参数预约日期为空 则默认查询前一天的预约资源
			if(ObjectUtil.isNullOrEmpty(searchReserve) || (ObjectUtil.isNullOrEmpty(searchReserve.getStartRequestDate()) && ObjectUtil.isNullOrEmpty(searchReserve.getEndRequestDate()))) {
				searchReserve.setStartRequestDate(DateUtil.getBeforeDay(new Date(), 1));
				searchReserve.setEndRequestDate(DateUtil.getBeforeDay(new Date(), 1));
			}
			return reserveHisService.queryReserveRegister(searchReserve, searchReserve.getCriteria());
		} catch (Exception e) {
			e.printStackTrace();
			String errorString =  XmlWebserviceForUtil.returnError(error);
			return errorString;
		}
	}

	@Override
	@WebMethod
	public String verifyUser(String requestXml) {
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml,"verifyUser",folder);
			AccountInfo account = XmlWebserviceForUtil.parseDataXml(requestXml,AccountInfo.class);
			return lhaccountInfoService.verifyUser(account);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String createUser(String requestXml) {
		AccountInfo account = null;
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml,"createUser",folder);
			account = XmlWebserviceForUtil.parseDataXml(requestXml,AccountInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
		if(account.getAccountName()==null)
			return XmlWebserviceForUtil.returnError("账户名不能为空！");
		if(account.getPassword()==null)
			return XmlWebserviceForUtil.returnError("密码不能为空！");
		if(account.getCardNo()==null)
			return XmlWebserviceForUtil.returnError("身份证号不能为空！");
		if(account.getRealName()==null)
			return XmlWebserviceForUtil.returnError("真实姓名不能为空！");
		if(account.getTelephone()==null)
			return XmlWebserviceForUtil.returnError("手机号不能为空！");

		AccountInfo rs =lhaccountInfoService.get(new Criteria("accountName", account.getAccountName()));
		if(rs!=null)
			return XmlWebserviceForUtil.returnError("用户名已存在！");
		rs =lhaccountInfoService.get(new Criteria("cardNo", account.getCardNo()));
		if(rs!=null)
			return XmlWebserviceForUtil.returnError("身份证号已被注册！");
		//查询personId 无则创建
		String personId = createPerson(account);
		if(StringUtil.isEmpty(personId))
		{
			return XmlWebserviceForUtil.returnError("未成功创建健康档案，注册失败！");
		}
		//md5加密密码
		account.setPassword(MD5Encoder.getMD5Str(account.getPassword()));
		//手机注册默认激活状态为 1.启用 0.禁用
		account.setActivateStatus("1");
		return lhaccountInfoService.createUser(account);
	}
	
	@Override
	@WebMethod
	public String modifyPassword(String requestXml) {
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml,"verifyUser",folder);
			AccountInfo account = XmlWebserviceForUtil.parseDataXml(requestXml,AccountInfo.class);
			if(account.getAccountName()==null)
				return XmlWebserviceForUtil.returnError("账户名不能为空！");
			if(account.getOldPassword()==null)
				return XmlWebserviceForUtil.returnError("原密码不能为空！");
			if(account.getPassword()==null)
				return XmlWebserviceForUtil.returnError("新密码不能为空！");
			return lhaccountInfoService.changePassword(account);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}
	
	@Override
	@WebMethod
	public String searchContacts(String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"searchContacts",folder);
			SearchReserve searchReserve = XmlWebserviceForUtil.parseDataXml(requestXml,SearchReserve.class);
			if(searchReserve.getIdcard()==null){
				return XmlWebserviceForUtil.returnError("登录用户身份证不能为空！");
			}
			return reserveHisService.getContants(searchReserve.getIdcard());
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
		
	}

	@Override
	@WebMethod
	public String modifyContacts(String requestXml) {
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml, "modifyContacts", folder);
			FrequentContacts fs = XmlWebserviceForUtil.parseDataXml(requestXml, FrequentContacts.class);
			return reserveHisService.updateContants(fs);
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String deleteContacts(String requestXml) {
		try {
			if(getIpAddr(wsContext)){
				return XmlWebserviceForUtil.returnError("无权限访问,请联系管理员！");
			}
			XmlWebserviceForUtil.saveDataFile(requestXml, "deleteContacts", folder);
			FrequentContacts fs = XmlWebserviceForUtil.parseDataXml(requestXml, FrequentContacts.class);
			if(fs.getId()==null){
				return XmlWebserviceForUtil.returnError("联系人ID不能为空！");
			}
			String result = frequentService.delete(fs.getId());
			if(EHRConstants.FREQUENT_FAIL.equals(result)){
				return XmlWebserviceForUtil.returnError("操作失败！");
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}

	@Override
	@WebMethod
	public String searchExpert(String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml, "searchExpert", folder);
			GetYYAllDepartmentInfo queryCondition = XmlWebserviceForUtil.parseDataXml(requestXml,GetYYAllDepartmentInfo.class);
			if(queryCondition.getHospitalCode()==null){
					return XmlWebserviceForUtil.returnError("医院代码不能为空！");
				}
			return reserveHisService.getHotExpert(queryCondition.getHospitalCode());
		} catch (Exception e) {
			e.printStackTrace();
			return XmlWebserviceForUtil.returnError(error);
		}
	}
	
	@Override
	@WebMethod
	public String searchUserReserve(String requestXml) {
		try {
			XmlWebserviceForUtil.saveDataFile(requestXml,"searchUserReserve",folder);
			SearchReserve searchReserve = XmlWebserviceForUtil.parseDataXml(requestXml,SearchReserve.class);
			return reserveHisService.getUserReserve(searchReserve);
		} catch (Exception e) {
			e.printStackTrace();
			String errorString =  XmlWebserviceForUtil.returnError(error);
			return errorString;
		}
	
	}

	private String createPerson(AccountInfo accountInf){
		String rs = null;
		PersonInfo personInfo = platformService.queryPersonalInfo(null, accountInf.getCardNo());
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			personInfo = new PersonInfo();
			personInfo.setName(accountInf.getRealName());
			personInfo.setPhoneNumber(accountInf.getTelephone());
			personInfo.setIdcard(accountInf.getCardNo());
			personInfo.setPastreet(accountInf.getPastreet());
			personInfo.setFilingFlag(EHRConstants.CHECK_FLAG);
			personInfo.setPatownShip(accountInf.getPatownShip());
			personInfo.setPahouseNumber(accountInf.getPahouseNumber());
			personInfo.setHrstreet(accountInf.getHrstreet());
			personInfo.setHrtownShip(accountInf.getHrtownShip());
			personInfo.setHrhouseNumber(accountInf.getHrhouseNumber());
			personInfo.setHouseholdType(accountInf.getHouseholdType());
			personInfo.setUpdateOrganName("手机APP");
			personInfo.setUpdateName("手机APP");
			// end add
			rs =platformService.createPerson(personInfo, EHRConstants.RETURN_PERSON_ID, true);
		}
		rs = personInfo.getId().toString();
		return rs;
	}
	
	//	预约时间判断
	private Boolean reserveEffectiveTime() {
		HashMap<String,String> map = portalSetService.getSetByType(PortalSetType.RESERVE.getValue());
	  	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		try {
			Date reserveStart = (Date) sdf.parseObject(map.get(EHRConstants.PORTAL_RESERVE_START_TIME));
			Date reserveEnd = (Date) sdf.parseObject(map.get(EHRConstants.PORTAL_RESERVE_END_TIME));
			Calendar cal = Calendar.getInstance();

			Date nowDate = (Date) sdf.parseObject(cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));

			if (nowDate.before(reserveStart) || nowDate.after(reserveEnd)) {
				return true;
			}
		} catch (ParseException e) {
				e.printStackTrace();
			}
		return false;
	}
	
	/**
	 * 获取来访机器的IP地址，判断是否规则内的IP
	 * @param wsContext
	 * @return
	 */
	protected boolean getIpAddr(WebServiceContext wsContext) {
		//门户设置的IP
		HashMap<String, String> map = portalSetService.getSetByType(PortalSetType.RESERVE_TIME.getValue());
        String ipAddr = map.get("reserve_app_ip");
        if(StringUtil.isEmpty(ipAddr)){
        	return false;
        }
		MessageContext mc = wsContext.getMessageContext();
		HttpServletRequest request = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if(ipAddr.equals(ip)){
			return false;
		}else{
			return true;
		}
	}

	
}
