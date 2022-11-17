/**   
* @Title: ReserveHisServiceImpl.java 
* @Package com.founder.rhip.portal.service 
* @Description:预约和HIS交互的接口
* @author LJY
* @date 2013-8-8 下午2:26:34 
* @version V1.0   
*/
package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.common.ReserveStauts;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.*;
import com.founder.rhip.ehr.repository.portal.*;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.mdm.common.CommonUtil;
import com.founder.rhip.portal.dto.GetHotExpertResponse;
import com.founder.rhip.portal.dto.QueryReserve;
import com.founder.rhip.portal.dto.SearchContactsResponse;
import com.founder.rhip.portal.dto.SearchReserve;
import com.founder.rhip.portal.dto.SearchReserveRequest;
import com.founder.rhip.portal.dto.UpdateResource;
import com.founder.rhip.portal.service.util.CompareUtil;
import com.founder.rhip.portal.service.util.SMSUtil;
import com.founder.rhip.portal.service.util.ValidateUtil;
import com.founder.rhip.portal.service.util.XmlWebserviceForUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/** 
 * @ClassName: ReserveHisServiceImpl 
 * @Description: 预约和HIS交互的接口
 * @author  LJY
 * @date 2013-8-8 下午2:26:34 
 *  
 */
@Service("reserveHisService")
public class ReserveHisServiceImpl implements IReserveHisService {

	private static final String RESERVE_TIME = "预约挂号";
	
	private static String imgPath;

	protected static Logger logger = Logger.getLogger(ReserveHisServiceImpl.class.getName());
	
	@Autowired
	private IOutClinicDao outClinicDao;
	
	@Autowired
	private IOutDoctorDao outDoctorDao;
	
	@Autowired
	private IRegisterScheduleDao registerScheduleDao;

	@Autowired
	private IRegisterScheduleTimeDao registerScheduleTimeDao;

	@Autowired
	private IReserveRegisterDao reserveRegisterDao;
	
	@Autowired
	private IStopDoctorService stopDoctorService;

	@Resource(name = "portalSetService")
	private IPortalSetService portalSetService;
	
	@Resource(name="lhFrequentContactsService")
	private IFrequentContactsService frequentService;
	
	@Resource(name = "lhaccountInfoService")
	private IAccountInfoService lhaccountInfoService;
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	@Resource(name = "smsRecordDao")
	private ISmsRecordDao smsDao;
	
	static {
		Properties properties = PropertiesUtils.initProperties("setting");
		if (ObjectUtil.isNotEmpty(properties)) {
			imgPath = properties.getProperty("portal.hrc");
		}
	}

	/** 
	* @Title: getReserve 
	* @Description: 查询预约挂号
	* @param @param queryReserve
	* @param @return
	* @return String
	* @throws 
	*/
	@Override
	public String getReserve(SearchReserve searchReserve){

		String validateString = ValidateUtil.doValidate(searchReserve, "hospitalCode");
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		
		if( ObjectUtil.isNullOrEmpty(searchReserve.getIdcard()) && ObjectUtil.isNullOrEmpty(searchReserve.getSearchCode())){
			return XmlWebserviceForUtil.returnError("身份证编码，查询码不能同时为空");
		}
		Criteria criteria = searchReserve.getCriteria();
		Date nowDate = DateUtil.getToday().getTime();
		criteria.add("requestDate",nowDate);
		criteria.add("RESERVER_STAUTS","01");
		
		List<ReserveRegister> reserveRegisters =  reserveRegisterDao.getList(criteria);
		SearchReserveRequest searchReserveRequst = new SearchReserveRequest();
		searchReserveRequst.setReserveRegisters(reserveRegisters);
		return XmlWebserviceForUtil.getString(searchReserveRequst,SearchReserveRequest.class);
	}
	
	
	/** 
	* @Title: searchReserves 
	* @Description: 查询预约挂号LIST
	* @param @param searchReserve
	* @param @return
	* @return String
	* @throws 
	*/
	@Override
	public String searchReserves(SearchReserve searchReserve){
		String validateString = ValidateUtil.doValidate(searchReserve, "hospitalCode");
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		if(searchReserve.getIdcard() == null && searchReserve.getName() == null && searchReserve.getSearchCode() == null){
			return XmlWebserviceForUtil.returnError("身份证编码，姓名，查询码不能同时为空");
		}
		List<ReserveRegister> reserveRegisters =  reserveRegisterDao.getList(searchReserve.getCriteria());
		SearchReserveRequest searchReserveRequst = new SearchReserveRequest();
		searchReserveRequst.setReserveRegisters(reserveRegisters);
		return XmlWebserviceForUtil.getString(searchReserveRequst,SearchReserveRequest.class);
	}
	
	/** 
	* @Title: queryReserveRegister 
	* @Description: 查询预约挂号LIST
	* @param @param searchReserve
	* @param @return
	* @return String
	* @throws 
	*/
	@Override
	public String queryReserveRegister(SearchReserve searchReserve, Criteria criteria){
		String validateString = ValidateUtil.doValidate(searchReserve, "hospitalCode");
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		List<ReserveRegister> reserveRegisters =  reserveRegisterDao.getList(criteria);
		SearchReserveRequest searchReserveRequst = new SearchReserveRequest();
		searchReserveRequst.setReserveRegisters(reserveRegisters);
		return XmlWebserviceForUtil.getString(searchReserveRequst,SearchReserveRequest.class);
	}
	
	
	/** 
	* @Title: updateReserveStatus 
	* @Description: 刷新到诊状态
	* @param @param queryReserve
	* @param @return
	* @return String
	* @throws 
	*/
	@Override
	public String updateReserveStatus(QueryReserve queryReserve,String reserveStauts){
		String validateString = ValidateUtil.doValidate(queryReserve, "searchCode","idcard");
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		
		Criteria criteria = new Criteria("searchCode", queryReserve.getSearchCode());
		criteria.add("idcard", queryReserve.getIdcard());
		
		ReserveRegister reserveRegister =  reserveRegisterDao.get(criteria);
		if(reserveRegister==null){
			return XmlWebserviceForUtil.returnError("找不到预约记录!");
		}
		if(!(ReserveStauts.SWDZ.getStauts()).equals(reserveRegister.getReserverStauts())){
			return XmlWebserviceForUtil.returnError("只能取消未就诊的预约记录!");
		}
		// 取消预约的截止时间是就诊日前一天16:00 add at 2016-01-20 ↓
		if (ReserveStauts.QX.getStauts().equals(reserveStauts)) {
			String result = null;
			String startViewReserveHour = portalSetService.getByCode("portal_reserve_view_end_time").split("\\:")[0];
			String startViewReserveMin = portalSetService.getByCode("portal_reserve_view_end_time").split("\\:")[1];
			Date date = DateUtil.convertDate("MM/dd/yyyy", new Date());
			if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour, startViewReserveMin))) {
				// 如果当前日前在PORTAL_RESERVE_VIEW_END_TIME后，将当前日期加1天
				date = DateUtil.convertDate("MM/dd/yyyy", DateUtil.add(new Date(), Calendar.DAY_OF_MONTH, 1));
			}
			if (!(reserveRegister.getRequestDate().after(date))) {
				result = "取消预约失败，请在就诊日前一天的" + startViewReserveHour + ":" + startViewReserveMin + "之前取消预约";
				return XmlWebserviceForUtil.returnError(result);
			}
		}
		//取消预约的截止时间是就诊日前一天16:00 add at 2016-01-20 ↑
		reserveRegister.setReserverStauts(reserveStauts);
		int rs=reserveRegisterDao.update(reserveRegister);
		Map<String,String> smsMap = new HashMap<String,String>();
		smsMap.put("NAME",reserveRegister.getName());
		smsMap.put("HOSPITAL",reserveRegister.getHospitalName());
		smsMap.put("DOCTOR_NAME",reserveRegister.getDoctorName());
		smsMap.put("DEPT_NAME",reserveRegister.getDeptName());
		smsMap.put("TIME",DateUtil.getDateTime("yyyy年MM月dd日",reserveRegister.getRequestDate()));
		smsMap.put("AMPM",reserveRegister.getAmpm());
		smsMap.put("TIME_INTERVAL_START",reserveRegister.getTimeIntervalStart().trim());
		smsMap.put("TIME_INTERVAL_END",reserveRegister.getTimeIntervalEnd().trim());
		smsMap.put("TAKE_NO_TIME_START",reserveRegister.getTakeNoTimeStart().trim());
		smsMap.put("TAKE_NO_TIME_END",reserveRegister.getTakeNoTimeEnd().trim());
		smsMap.put("SEARCH_CODE",queryReserve.getSearchCode());
		//发送取消短信
		try {
			SMSUtil smsUtil=new SMSUtil();
			String content=smsUtil.createSMSContent(smsMap,SMSUtil.MODE_TYPE_4);
//			if(smsUtil.isPortal_reserve_send())
			String smsResult="";
			smsResult = smsUtil.send(content, reserveRegister.getPhoneNumber());
			if("Success".equals(smsResult)){
				SmsRecord sms=new SmsRecord();
				sms.setContent(content);
				sms.setName(reserveRegister.getName());
				sms.setPhoneNumber(reserveRegister.getPhoneNumber());
				sms.setType(SMSUtil.MODE_TYPE_4);
				sms.setCreateTime(new Date());
				smsDao.insert(sms);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(rs);
	}
	
	@Override
	public String stopingDoctor(StopDoctor stopDoctor){
		String validateString = ValidateUtil.doValidate(stopDoctor, "doctorSn","deptSn",
				"hospitalCode","startDate","endDate");
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		
		String result = stopDoctorService.processUnResReg(stopDoctor,"2");
		
		if(result.equals(EHRConstants.STOP_REPEAT)){
			return XmlWebserviceForUtil.returnError("此医生已经停诊，请勿重复停诊");
		}
		
		return "1";
	}
	
	@Override
	public String cancelingDoctor(StopDoctor stopDoctor){
		String validateString = ValidateUtil.doValidate(stopDoctor, "doctorSn","deptSn","hospitalCode");
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		
		List<StopDoctor> lstopDoctor = stopDoctorService.getStopList(stopDoctor);
		for(StopDoctor sd:lstopDoctor){
			stopDoctorService.cancelStop(sd.getId());
		}
		return "1";
	}
	
	@Override
	public String updateSchedule(UpdateResource updateResource){
		if(ObjectUtil.isNullOrEmpty(updateResource)){
			return "1";
		}
		if(ObjectUtil.isNullOrEmpty(updateResource.getRegisterScheduleList())){
			return "1";
		}
		List<RegisterSchedule> registerSchedules = new ArrayList<RegisterSchedule>();
		List<OutClinic> outClinics = new ArrayList<OutClinic>();
		List<OutDoctor> outDoctors = new ArrayList<OutDoctor>();

		List<RegisterSchedule> registerScheduleList = updateResource.getRegisterScheduleList();
		int sum = registerScheduleList.size();
		int err = 0;
		
		for(RegisterSchedule rs : registerScheduleList){
			String validateString = ValidateUtil.doValidate(rs,"admitNum",
					"ampm","clinicType","deptName","deptSn","hospitalCode",
					"hospitalName","requestDate");
			
			if(ObjectUtil.isNotEmpty(validateString)){
				logger.error(validateString);
				err ++;
				continue;
			}

			if(ObjectUtil.isNullOrEmpty(rs.getRegisterFee())){
				double d = 0;
				rs.setRegisterFee(d);
			}
			updateOutClinic(outClinics,rs);
			updateOutDoctor(outDoctors,rs);
			updateSchedule(rs);
			registerSchedules.add(rs);
		}
		
		doUpdate(registerSchedules,outClinics,outDoctors);
		logger.error("一共" + sum + "条，其中格式错误" + err + "条");
		return "1";
	}
	
	@Override
	public String updateScheduleByTime(String xml){
		Document xmlDc = XmlWebserviceForUtil.parseDocument(xml);
		//预约资源xpath
		String xpathRegi = "//registerSchedules/registerSchedule";
		//时间段xpath
		String xpathTime = "//timeInterval";
		List<Node> nodes = xmlDc.selectNodes(xpathRegi);
		//排班信息实体
		List<RegisterSchedule> registerSchedules = new ArrayList<RegisterSchedule>();
		//处理分段预约资源报文
		for(Iterator<Node> itRegister = nodes.iterator();itRegister.hasNext();){
			//排班时段	信息实体
			List<RegisterScheduleTime> regScheduleTimes = new ArrayList<RegisterScheduleTime>();
			//循环排班信息
			RegisterSchedule regiSchedule = new RegisterSchedule();
			Node ndRegister = (Node)itRegister.next();
			Document  xmlReg = XmlWebserviceForUtil.parseDocument(ndRegister.asXML());
			this.paraseRegXMl(regiSchedule, xmlReg);
			List<Node> nodesTime = xmlReg.selectNodes(xpathTime);
			for(Iterator<Node> itTime = nodesTime.iterator();itTime.hasNext();){
				RegisterScheduleTime regTime = new RegisterScheduleTime();
				//循环排班时段信息
				Node ndTime = (Node)itTime.next();
				Document  xmlTime = XmlWebserviceForUtil.parseDocument(ndTime.asXML());
				Element eleTime = xmlTime.getRootElement();
				this.paraseRegTimeXMl(regTime, eleTime);
				//排班时段信息
				regScheduleTimes.add(regTime);
			}
			regiSchedule.setRegisterScheduleTime(regScheduleTimes);
			//排班信息
			registerSchedules.add(regiSchedule);
		}
		//预约资源非空判断
		if(ObjectUtil.isNullOrEmpty(registerSchedules)){
			return "1";
		}else{ //时间段预约资源非空判断
			for(RegisterSchedule rgs : registerSchedules){
				if(ObjectUtil.isNullOrEmpty(rgs)){
					return "1";
				}
			}
		}
		List<OutClinic> outClinics = new ArrayList<OutClinic>();
		List<OutDoctor> outDoctors = new ArrayList<OutDoctor>();
		
		int sum = registerSchedules.size();
		int err = 0;
		List<RegisterSchedule> registerScheduleList = new ArrayList<RegisterSchedule>();
		for(RegisterSchedule rs:registerSchedules){
			//验证预约表字段
			String validateString = ValidateUtil.doValidate(rs,"clinicType","deptName","deptSn","hospitalCode",
					"ampm","hospitalName","requestDate");
			if(ObjectUtil.isNotEmpty(validateString)){
				logger.error(validateString);
				err ++;
				continue;
			}
			//验证预约时段表字段
			for(RegisterScheduleTime rst : rs.getRegisterScheduleTime()){
				String validateRes = ValidateUtil.doValidate(rst,"timeIntervalStart","timeIntervalEnd","admitNum",
						"takeNoTimeStart","takeNoTimeEnd");
				logger.error(validateRes);
				}
			if(ObjectUtil.isNullOrEmpty(rs.getRegisterFee())){
				double d = 0;
				rs.setRegisterFee(d);
			}
			updateOutClinic(outClinics,rs);
			updateOutDoctor(outDoctors,rs);
			updateScheduleByTime(rs);
			registerScheduleList.add(rs);
		}
		
		doUpdateByTime(registerScheduleList,outClinics,outDoctors);
		logger.error("一共" + sum + "条，其中格式错误" + err + "条");
		return "1";
	}
	
	/** 
	* @Title: updateOutDoctor 
	* @Description: 整理所有的出诊科室
	* @param @param outDoctors
	* @param @param registerSchedule
	* @return void
	* @throws 
	*/
	private void updateOutClinic(List<OutClinic> outClinics,RegisterSchedule registerSchedule){
		boolean hs = false;
		for(OutClinic oc:outClinics){
			/**判断OutClinic和RegisterSchedule中两个属性hospitalCode","deptSn"是否相同*/
			hs = CompareUtil.doCompare(oc, registerSchedule, "hospitalCode","deptSn");
			if(hs){
				return;
			}
		}
		OutClinic newOutClinic = new OutClinic();
		newOutClinic.setHospitalCode(registerSchedule.getHospitalCode());
		newOutClinic.setDeptSn(registerSchedule.getDeptSn());
		newOutClinic.setName(registerSchedule.getDeptName());
		String pyCode = CommonUtil.getPinYin(newOutClinic.getName());
		newOutClinic.setPyCode(pyCode);
		outClinics.add(newOutClinic);
	}
	
	/** 
	* @Title: updateOutDoctor 
	* @Description: 整理所有的出诊医生 
	* @param @param outDoctors
	* @param @param registerSchedule
	* @return void
	* @throws 
	*/
	private void updateOutDoctor(List<OutDoctor> outDoctors,RegisterSchedule registerSchedule){
		String validateString = ValidateUtil.doValidate(registerSchedule,"doctorSn","doctorName");
		
		if(ObjectUtil.isNotEmpty(validateString)){
			return;
		}
		
		boolean hs = false;
		for(OutDoctor od:outDoctors){
			/**判断OutClinic和RegisterSchedule中两个属性hospitalCode","deptSn"是否相同*/
			hs = CompareUtil.doCompare(od, registerSchedule, "hospitalCode","deptSn","doctorSn");
			if(hs){
				return;
			}
		}
		
		OutDoctor newOutDoctor = new OutDoctor();
		newOutDoctor.setHospitalCode(registerSchedule.getHospitalCode());
		newOutDoctor.setDeptSn(registerSchedule.getDeptSn());
		newOutDoctor.setDeptName(registerSchedule.getDeptName());
		newOutDoctor.setDoctorSn(registerSchedule.getDoctorSn());
		newOutDoctor.setEmpTitCode(registerSchedule.getEmpTitCode());
		newOutDoctor.setEmpTitName(registerSchedule.getEmpTitName());
		newOutDoctor.setName(registerSchedule.getDoctorName());
		newOutDoctor.setPyCode(CommonUtil.getPinYin(newOutDoctor.getName()));
		newOutDoctor.setSocialNo(registerSchedule.getSocialNo());
		newOutDoctor.setSpecializes(registerSchedule.getSpecializes());
		outDoctors.add(newOutDoctor);
	}
	
	/** 
	* @Title: updateSchedule 
	* @Description: 整理预约挂号资源 
	* @param @param registerSchedule
	* @return void
	* @throws 
	*/
	private void updateSchedule(RegisterSchedule registerSchedule){
		Criteria criteria = new Criteria("hospitalCode",registerSchedule.getHospitalCode());
		criteria.add("deptSn", registerSchedule.getDeptSn());

        //liuk 2014年3月10日 17:22:01 条件判断错误
        //如果医生为空,则作为独立记录
		//if(ObjectUtil.isNotEmpty(registerSchedule.getDeptSn())){
		if(ObjectUtil.isNotEmpty(registerSchedule.getDoctorSn())){
			criteria.add("doctorSn", registerSchedule.getDoctorSn());
		}else{
			criteria.add("doctorSn",OP.IS, " null ");
		}
		criteria.add("clinicType", registerSchedule.getClinicType());
		criteria.add("registerFee", registerSchedule.getRegisterFee());
		criteria.add("requestDate", registerSchedule.getRequestDate());
		criteria.add("ampm", registerSchedule.getAmpm());
		
		RegisterSchedule reg = registerScheduleDao.get(criteria);
		Date now=new Date();
		registerSchedule.setCreateTime(now);
		registerSchedule.setUpdateTime(now);
		if(ObjectUtil.isNotEmpty(reg)){
            /** 2014年3月31日 11:07:51 liuk 不再处理医院传入数据
            Long reserveNum=null==  registerSchedule.getReserveNum()?0: registerSchedule.getReserveNum();
            Long total=null==registerSchedule.getAdmitNum()?0:registerSchedule.getAdmitNum();
            Long oldReserveNum=null==reg.getReserveNum()?0:reg.getReserveNum();
            //新的已经预约的资源数为本地系统已经预约数量和医院新传入已预约数量只和 //医院要求
            Long newReserveNum=reserveNum+oldReserveNum;
            //如果新的已经预约的资源数已经超过资源,则设置为资源书
            newReserveNum=newReserveNum>total?total:newReserveNum;
			registerSchedule.setReserveNum(newReserveNum);
             */
			//此字段移入到RegisterScheduleTime jianghaiying
			RegisterScheduleTime registerScheduleTime = registerScheduleTimeDao.get(new Criteria("REGISTER_SCHEDULE_ID", reg.getId()));
			 if(ObjectUtil.isNotEmpty(registerScheduleTime)) {
				 //不能更新已预约人数问题修正 modify by:meixingjian
				 registerSchedule.setReserveNum(registerScheduleTime.getReserveNum());
				 //增加时间记录及预约号变动数记录
				 registerSchedule.setId(reg.getId());
				 Long localNum =registerScheduleTime.getAdmitNum();
				 Long remoteNum =registerSchedule.getAdmitNum();
				 if(localNum==null)
					 localNum=0l;
				 if(remoteNum==null)
					 remoteNum=0l;
				 //当可预约数和既存不一致时记录1次变化数量
				 if(!localNum.equals(remoteNum)){
					 registerSchedule.setCuteFlag(localNum-remoteNum);
				 }else{
					 registerSchedule.setCuteFlag(reg.getCuteFlag());
				 }
				 registerSchedule.setCreateTime(reg.getCreateTime());
			 }
		}
	}
	
	/** 
	* @Title: updateScheduleByTime 
	* @Description: 整理预约挂号分时段资源 
	* @param @param registerSchedule
	* @return void
	* @throws 
	*/
	private void updateScheduleByTime(RegisterSchedule registerSchedule){
		//排班信息查询条件
		Criteria criteria = new Criteria("hospitalCode",registerSchedule.getHospitalCode());
		criteria.add("deptSn", registerSchedule.getDeptSn());

		if(ObjectUtil.isNotEmpty(registerSchedule.getDoctorSn())){
			criteria.add("doctorSn", registerSchedule.getDoctorSn());
		}else{
			criteria.add("doctorSn",OP.IS, " null ");
		}
		criteria.add("clinicType", registerSchedule.getClinicType());
		criteria.add("registerFee", registerSchedule.getRegisterFee());
		criteria.add("requestDate", registerSchedule.getRequestDate());
		criteria.add("ampm", registerSchedule.getAmpm());
		
		RegisterSchedule reg = registerScheduleDao.get(criteria);

		//排班信息存在时
		if(ObjectUtil.isNotEmpty(reg)){
			//排班信息主键
			registerSchedule.setId(reg.getId());
			registerSchedule.setCreateTime(reg.getCreateTime()); //创建时间
			for(RegisterScheduleTime rst : registerSchedule.getRegisterScheduleTime()){
				//排班时间信息查询条件
				Criteria criteriaRs = new Criteria("REGISTER_SCHEDULE_ID", reg.getId());
				criteriaRs.add("TIME_INTERVAL_START",rst.getTimeIntervalStart()) ;
				criteriaRs.add("TIME_INTERVAL_END",rst.getTimeIntervalEnd()) ;
				RegisterScheduleTime registerScheduleTime = registerScheduleTimeDao.get(criteriaRs);
				//预约时段存在的情况
				if(ObjectUtil.isNotEmpty(registerScheduleTime)){
					rst.setId(registerScheduleTime.getId()); //主键
					rst.setCreateTime(registerScheduleTime.getCreateTime());
					rst.setRegisterScheduleId(registerScheduleTime.getRegisterScheduleId());//医院编码
					rst.setReserveNum(registerScheduleTime.getReserveNum());//已预约数不变
					Long localNum = registerScheduleTime.getAdmitNum() == null ? 0L : registerScheduleTime.getAdmitNum(); //DB总资源数
					Long hisNum = rst.getAdmitNum() == null ? 0L : rst.getAdmitNum();//HIS总资源数
					if(!localNum.equals(hisNum)){
						rst.setCuteFlag(localNum-hisNum);
					 }
				}
			}			 
		}
	}
	
	/** 
	* @Title: doUpdate 
	* @Description: 更新
	* @param @param registerSchedules
	* @param @param outClinics
	* @param @param outDoctors
	* @return void
	* @throws 
	*/
	private void doUpdate(List<RegisterSchedule> registerSchedules,List<OutClinic> outClinics,List<OutDoctor> outDoctors){
		for(OutClinic oc :outClinics){
			Criteria criteria = new Criteria("hospitalCode",oc.getHospitalCode());
			criteria.add("deptSn", oc.getDeptSn());
			outClinicDao.delete(criteria);
			outClinicDao.insert(oc);
		}
		
		for(OutDoctor od :outDoctors){
			Criteria criteria = new Criteria("hospitalCode",od.getHospitalCode());
			criteria.add("deptSn", od.getDeptSn());
			criteria.add("doctorSn", od.getDoctorSn());
			OutDoctor outDoctor = outDoctorDao.get(criteria);
			if(ObjectUtil.isNotEmpty(outDoctor)) {
				od.setId(outDoctor.getId());
				od.setEmpTitName(outDoctor.getEmpTitName());
				od.setSpecializes(outDoctor.getSpecializes());
				od.setStatus(outDoctor.getStatus());
				od.setIsHot(outDoctor.getIsHot());
				od.setWorkExperience(outDoctor.getWorkExperience());
				outDoctorDao.update(od);
			} else {
				outDoctorDao.insert(od);
			}
		}
		
		for(RegisterSchedule rs :registerSchedules){
			RegisterScheduleTime registerScheduleTime = new RegisterScheduleTime();
			this.setRegisterScheduleTime(rs, registerScheduleTime);
			if(ObjectUtil.isNotEmpty(rs.getId())){
				registerScheduleDao.update(rs);
				Parameters parameters = new Parameters("ADMIT_NUM", registerScheduleTime.getAdmitNum());
				parameters.add("CUTE_FLAG", registerScheduleTime.getCuteFlag());
				parameters.add("RESERVE_NUM", registerScheduleTime.getReserveNum());
				parameters.add("UPDATE_TIME", new Date());
				registerScheduleTimeDao.update(parameters, new Criteria("REGISTER_SCHEDULE_ID", registerScheduleTime.getRegisterScheduleId()));
				continue;
			} else {
				Number id = registerScheduleDao.generatedKey(rs, "ID", null);
				registerScheduleTime.setRegisterScheduleId(id.longValue());
				registerScheduleTimeDao.insert(registerScheduleTime);
				//registerScheduleDao.insert(rs);
			}

		}
	}
	
	/** 
	* @Title: doUpdateByTime 
	* @Description: 更新出诊医生表   出诊科室表  排班信息表  排班时间信息表
	* @param @param registerSchedules
	* @param @param outClinics
	* @param @param outDoctors
	* @return void
	* @throws 
	*/
	private void doUpdateByTime(List<RegisterSchedule> registerSchedules,List<OutClinic> outClinics,List<OutDoctor> outDoctors){
		//更新出诊科室
		for(OutClinic oc :outClinics){
			Criteria criteria = new Criteria("hospitalCode",oc.getHospitalCode());
			criteria.add("deptSn", oc.getDeptSn());
//			outClinicDao.delete(criteria);
//			outClinicDao.insert(oc);
			//科室可以新增不可修改 add by bagen at 2016-01-21 
			if (ObjectUtil.isNullOrEmpty(outClinicDao.get(criteria))) {
				outClinicDao.insert(oc);
			}
		}
		//更新出诊医生
		for(OutDoctor od :outDoctors){
			Criteria criteria = new Criteria("hospitalCode",od.getHospitalCode());
			criteria.add("deptSn", od.getDeptSn());
			criteria.add("doctorSn", od.getDoctorSn());
			OutDoctor outDoctor = outDoctorDao.get(criteria);
			//入库时更新预约医生
			if(ObjectUtil.isNotEmpty(outDoctor)) {
				od.setId(outDoctor.getId());
				od.setStatus(outDoctor.getStatus());
				od.setEmpTitName(outDoctor.getEmpTitName());
				od.setSpecializes(outDoctor.getSpecializes());
				od.setIsHot(outDoctor.getIsHot());
				od.setWorkExperience(outDoctor.getWorkExperience());
				outDoctorDao.update(od);
			} else {
				outDoctorDao.insert(od);
			}
			
		}
		//预约信息
		for(RegisterSchedule rs :registerSchedules){
			//排班信息ID
			Long registerScheduleId = 0L;
			//预约信息表操作
			if(ObjectUtil.isNotEmpty(rs.getId())){
				registerScheduleDao.update(rs);
			}else{
				//插入预约表返回主键
				registerScheduleId = (registerScheduleDao.generatedKey(rs, "ID",null)).longValue();
			}
			//预约时段表操作
			for(RegisterScheduleTime rst : rs.getRegisterScheduleTime()){
				if(ObjectUtil.isNotEmpty(rst.getId())){
					registerScheduleTimeDao.update(rst);
				}else{
					rst.setRegisterScheduleId(registerScheduleId);//放入排版信息表ID
					registerScheduleTimeDao.insert(rst);
				}
			}
			
			
		}
	}
	
	/**
	 * 将排班信息放入实体类中
	 * @param regSchedules  排版信息实体类
	 * @param xmlReg  排班element
	 */
	private void paraseRegXMl(RegisterSchedule regSchedules, Document xmlReg ){
		Date now=new Date();
		Element ele = xmlReg.getRootElement();
		regSchedules.setClinicType(ele.elementText("clinicType"));
		regSchedules.setDeptName(ele.elementText("deptName"));
		regSchedules.setDeptSn(ele.elementText("deptSn"));
		regSchedules.setDoctorName(ele.elementText("doctorName"));
		regSchedules.setDoctorSn(ele.elementText("doctorSn"));
		regSchedules.setEmpTitCode(ele.elementText("empTitCode"));
		regSchedules.setEmpTitName(ele.elementText("empTitName"));
		regSchedules.setHospitalCode(ele.elementText("hospitalCode"));
		regSchedules.setHospitalName(ele.elementText("hospitalName"));
		regSchedules.setRegisterFee(Double.valueOf(ele.elementText("registerFee")));
		regSchedules.setRequestDate(DateUtil.parseDateString(ele.elementText("requestDate")));
		regSchedules.setSocialNo(ele.elementText("socialNo"));
		regSchedules.setSpecializes(ele.elementText("specializes"));
		regSchedules.setAmpm(ele.elementText("ampm"));
		regSchedules.setCreateTime(now); //创建时间
		regSchedules.setUpdateTime(now); //更新时间
	}
	
	/**
	 * 将排班时间信息放入实体类中
	 * @param regSchTime  排班时段信息实体类
	 * @param ele  排班时段element
	 */
	private void paraseRegTimeXMl(RegisterScheduleTime regSchTime, Element ele ){
		Date now = new Date();
		regSchTime.setTimeIntervalStart(ele.elementText("timeIntervalStart"));
		regSchTime.setTimeIntervalEnd(ele.elementText("timeIntervalEnd"));
		regSchTime.setAdmitNum(Long.valueOf(ele.elementText("admitNum")));
		regSchTime.setReserveNum(Long.valueOf(ele.elementText("reserveNum")));
		regSchTime.setTakeNoTimeStart(ele.elementText("takeNoTimeStart"));
		regSchTime.setTakeNoTimeEnd(ele.elementText("takeNoTimeEnd"));
		regSchTime.setCreateTime(now);
		regSchTime.setUpdateTime(now);
	}


	/**
	 * 为registerScheduleTime赋值相应的预约信息
	 * @param registerSchedule
	 * @param registerScheduleTime
	 */
	private void setRegisterScheduleTime(RegisterSchedule registerSchedule, RegisterScheduleTime registerScheduleTime) {
		Properties properties = PropertiesUtils.initProperties("setting");
		registerScheduleTime.setAdmitNum(registerSchedule.getAdmitNum());
		registerScheduleTime.setCreateTime(new Date());
		registerScheduleTime.setCuteFlag(registerSchedule.getCuteFlag());
		registerScheduleTime.setRegisterScheduleId(registerSchedule.getId());
		registerScheduleTime.setReserveNum(registerSchedule.getReserveNum());
		if(ObjectUtil.isNullOrEmpty(registerSchedule.getId())) {
			String hopitalCode = registerSchedule.getHospitalCode();
			Criteria criteria = new Criteria("TYPE", this.RESERVE_TIME);
			criteria.add("code", OP.LIKE, hopitalCode);	
			HashMap<String,String> map = portalSetService.getSetByType(criteria);
			if(ObjectUtil.isNullOrEmpty(map)) {
				if(ObjectUtil.isNotEmpty(properties)){
					//从配置文件获取看病、取号的开始、结束时间
					registerScheduleTime.setTakeNoTimeEnd(properties.getProperty(registerSchedule.getAmpm() + ".take.end.time"));
					registerScheduleTime.setTakeNoTimeStart(properties.getProperty(registerSchedule.getAmpm() + ".take.start.time"));
					registerScheduleTime.setTimeIntervalEnd(properties.getProperty(registerSchedule.getAmpm() + ".see.end.time"));
					registerScheduleTime.setTimeIntervalStart(properties.getProperty(registerSchedule.getAmpm() + ".see.start.time"));		
				}	
			} else {
				registerScheduleTime.setTakeNoTimeEnd(map.get(registerSchedule.getAmpm() + "_take_end_" + hopitalCode));
				registerScheduleTime.setTakeNoTimeStart(map.get(registerSchedule.getAmpm() + "_take_start_" + hopitalCode));
				registerScheduleTime.setTimeIntervalEnd(map.get(registerSchedule.getAmpm() + "_see_end_" + hopitalCode));
				registerScheduleTime.setTimeIntervalStart(map.get(registerSchedule.getAmpm() + "_see_start_" + hopitalCode));
			}
		}
	}
	
	public Date getRequestTimeBegin() {
    	Date requestTimeBegin;
		Calendar cal = Calendar.getInstance();
		cal.get(Calendar.HOUR_OF_DAY);
		cal.get(Calendar.MINUTE); 
		cal.get(Calendar.SECOND); 
		cal.get(Calendar.MILLISECOND);
		requestTimeBegin = cal.getTime();
		return requestTimeBegin;
	}
    
    public Date getRequestTimeEnd(String startViewReserveHour, String startViewReserveMin) {
    	Date requestTimeEnd;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, Integer.valueOf(startViewReserveHour).intValue());
		if (startViewReserveMin.equals("00")) {
			cal.set(Calendar.MINUTE, 0);
		} else {
			cal.set(Calendar.MINUTE, Integer.valueOf(startViewReserveMin).intValue());
		}
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
		requestTimeEnd = cal.getTime();
		return requestTimeEnd;
	}


	@Override
	public String getContants(String idcard) {
		AccountInfo rs = lhaccountInfoService.get(new Criteria("cardNo", idcard));
		if(ObjectUtil.isNullOrEmpty(rs)){
			return XmlWebserviceForUtil.returnError("身份证没有对应的用户信息！");
		}
		List<FrequentContacts> fc = frequentService.getFrequentContactsLists(new Criteria("accountId",rs.getId()));
		SearchContactsResponse scr = new SearchContactsResponse();
		scr.setFrequentContacts(fc);
		return XmlWebserviceForUtil.getString(scr,SearchContactsResponse.class);
	}
	
	@Override
	public String updateContants(FrequentContacts fc) {
		//通过登录用户的身份证号获取用户ID
		AccountInfo rs = lhaccountInfoService.get(new Criteria("cardNo", fc.getIdCard()));
		if(ObjectUtil.isNullOrEmpty(rs)){
			return XmlWebserviceForUtil.returnError("身份证没有对应的用户信息！");
		}
		fc.setAccountId(rs.getId()); //所属登录用户ID
		String result = frequentService.update(fc, rs.getId());
		//失败情况
		if(EHRConstants.FREQUENT_FAIL.equals(result)){
			return XmlWebserviceForUtil.returnError("更新失败，缺少必填项！");
		}
		//重复情况
		else if(EHRConstants.FREQUENT_REPEAT.equals(result)){
			return XmlWebserviceForUtil.returnError("找不到要更新的联系人或新增联系人已存在！");
		}
		return "1";
	}
	
	@Override
	public String getHotExpert(String hospitalCode) {
		Criteria criteria = new Criteria("hospitalCode",hospitalCode);
		criteria.add("status", "1"); //专家状态
		criteria.add("isHot", "1");  //是否热门
		criteria.add("isDelete", "0");  //是否删除
		List<OutDoctor> outDoctors = outDoctorDao.getList(criteria);
		List<Long> ids = new ArrayList<Long>();
		for(int i = 0; i < outDoctors.size(); i++) {
			ids.add(outDoctors.get(i).getId());	
		}
		StringBuffer imgId = new StringBuffer();
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",OP.IN, ids).add("FILE_RESOURCE", "outDoctorPic"));
		for (OutDoctor outDoctor: outDoctors) {
			for (UploadInfoRecord uploadInfoRecord: uploadInfoRecords) {
				if(ObjectUtil.equals(outDoctor.getId(), uploadInfoRecord.getResourceId())){
					imgId.setLength(0);
					imgId.append(imgPath).append(uploadInfoRecord.getId()).append("?type=1");
					outDoctor.setImgSrc(imgId.toString());
					uploadInfoRecords.remove(uploadInfoRecord);
					break;
				}
			}
		}
		GetHotExpertResponse hotexpert = new GetHotExpertResponse();
		hotexpert.setOutDoctors(outDoctors);
		return XmlWebserviceForUtil.getString(hotexpert, GetHotExpertResponse.class);
	}


	@Override
	public String getUserReserve(SearchReserve searchReserve) {
		String validateString = ValidateUtil.doValidate(searchReserve, "idcard","startRequestDate","endRequestDate");
		//通过登录用户的身份证号获取用户信息
		AccountInfo rs = lhaccountInfoService.get(new Criteria("cardNo", searchReserve.getIdcard()));
		if(ObjectUtil.isNotEmpty(validateString)){
			return XmlWebserviceForUtil.returnError(validateString);
		}
		if(ObjectUtil.isNullOrEmpty(rs)){
			return XmlWebserviceForUtil.returnError("身份证没有对应的用户信息！");
		}
		Criteria criteria = new Criteria();
		DateUtil.getCriteriaByDateRange(criteria, "requestDate", searchReserve.getStartRequestDate(), searchReserve.getEndRequestDate());
		Long accountId = rs.getId();
		List<ReserveRegister> reserveRegisters =  reserveRegisterDao.getAllReserve(accountId, criteria);
		SearchReserveRequest searchReserveRequst = new SearchReserveRequest();
		searchReserveRequst.setReserveRegisters(reserveRegisters);
		return XmlWebserviceForUtil.getString(searchReserveRequst,SearchReserveRequest.class);
	}
	
}
