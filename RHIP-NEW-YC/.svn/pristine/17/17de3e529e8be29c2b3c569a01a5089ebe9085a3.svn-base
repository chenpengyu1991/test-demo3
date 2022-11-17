package com.founder.rhip.portal.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.portal.service.util.HttpClientUtil;
import com.founder.rhip.portal.util.PropertiesUtils;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.ReserveStauts;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.entity.portal.FrequentContacts;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.OutClinic;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.RegisterScheduleTime;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.portal.common.Constants;
import com.founder.rhip.portal.common.DateJsonValueProcessor;
import com.founder.rhip.portal.common.OperationName;
import com.founder.rhip.portal.service.IAccountInfoService;
import com.founder.rhip.portal.service.IFrequentContactsService;
import com.founder.rhip.portal.service.IHospitalInfoService;
import com.founder.rhip.portal.service.IHospitalReserveAdapter;
import com.founder.rhip.portal.service.IPortalSetService;
import com.founder.rhip.portal.service.IRegisterScheduleService;
import com.founder.rhip.portal.service.IReserveService;
import com.founder.rhip.portal.service.form.FrequentSearchForm;
import com.founder.rhip.portal.service.form.ReserveSearchForm;
import com.founder.rhip.portal.service.form.ScheduleSearchForm;
import com.founder.rhip.portal.service.util.Axis2Util;
import com.founder.rhip.portal.service.util.SMSUtil;

/*import org.apache.commons.httpclient.util.DateUtil;*/

@Controller
@RequestMapping(value = "/userSpace/reserve")
public class UserReserveController extends BaseController {

    @Resource(name = "reserveService")
    private IReserveService reserveService;

    @Resource(name = "registerScheduleService")
    private IRegisterScheduleService registerScheduleService;

    @Autowired
   	private IRegisterScheduleService registerSchedule;
    
    @Resource(name = "lhhospitalInfoService")
    private IHospitalInfoService hospitalInfoService;

    @Resource(name = "lhaccountInfoService")
    private IAccountInfoService accountInfoService;

    @Resource(name = "lhFrequentContactsService")
    private IFrequentContactsService frequentContactsService;

    @Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
    
    @Resource(name = "portalSetService")
    private IPortalSetService portalSetService;
    
    @Resource(name = "maternalChildrenHospitalReserveAdapter")
    private IHospitalReserveAdapter maternalChildrenHospitalReserveAdapter;
    
    @Resource(name = "firstHospitalReserveAdapter")
    private IHospitalReserveAdapter firstHospitalReserveAdapter;
    
    @Resource(name = "chineseMedicineHospitalReserveAdapter")
    private IHospitalReserveAdapter chineseMedicineHospitalReserveAdapter;
    
    @Resource(name = "stomatologicalHospitalReserveAdapter")
    private IHospitalReserveAdapter stomatologicalHospitalReserveAdapter;
    
    //操作来源0:平台；1:健康门户网站
    private static final String REG_PORTAL = "1";

    //接口返回CODE值正确
    private static final String RET_CODE_CORRECT= "1";

	private Properties properties = PropertiesUtils.initProperties("ws_config");

	@RequestMapping(value = "/search")
    public String search(HttpServletRequest request, ModelMap model) {
    	PersonInfo p = this.getPerson(request);
    	AccountInfo accountInfo = accountInfoService.get(new Criteria("cardNo", p.getIdcard()));
    	List<FrequentContacts> frequentContactsLists = 
    			frequentContactsService.getFrequentContactsLists(new Criteria("account_id",accountInfo.getId()));
        model.addAttribute("frequentContactsLists", frequentContactsLists);
        model.addAttribute("accountInfo", accountInfo);
        return "portal.reserve.search";
    }

    @RequestMapping(value = "/list")
    public String list(ReserveSearchForm reserveSearchForm, int indexPage, ModelMap model, HttpServletRequest request) {
        Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
        Criteria criteria = reserveSearchForm.getCriteria();
        Long accountId = this.getCurrentUser(request).getId();
        PageList<ReserveRegister> reserveRegisters = reserveService.getResRegByFreContacts(accountId, criteria, page);
        model.addAttribute("reserveRegisters", reserveRegisters.getList());
        model.addAttribute("page", reserveRegisters.getPage());
        return "portal.reserve.list";
    }

	@RequestMapping(value = "/schedule")
    public String schedule(HttpServletRequest request, ModelMap model, String type, String hospital,
    		String clinic, String deptName, String clinicType, Long frequent) throws UnsupportedEncodingException {
    	
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
    	accountInfo = accountInfoService.get(new Criteria("id", accountInfo.getId()));
    	model.addAttribute("accountInfo", accountInfo);
    	
    	//查询科室时增加时间查询条件 start
    	Criteria newCriteria = new Criteria();
    	Date requestDateBegin = getRequestDateBegin();
		Date requestDateEnd = getRequestDateEnd();
		DateUtil.getCriteriaByDateRange(newCriteria, "RS.REQUEST_DATE", requestDateBegin, requestDateEnd);
		//查询科室时增加时间查询条件 end
		
		//分条件进行预约 type:01按医院预约(显示医院列表),type:02按科室预约(显示科室列表)
		displayHosNameOrDeptNameByType(model, type, deptName, newCriteria);
		//通过预约状态来显示常用联系人
    	showFrequentByReserveStatus(model, accountInfo);
        return "portal.reserve.schedule";
    }

	/***
     * 分条件进行预约
     * 01按医院预约
     * 02按科室预约
     * @param type
     * @param deptName
     * @param newCriteria
     * @return
	 * @throws UnsupportedEncodingException 
     */
	private ModelMap displayHosNameOrDeptNameByType(ModelMap model,String type,
			String deptName, Criteria newCriteria) throws UnsupportedEncodingException {
		if("01".equals(type)) {//按医院预约
    		//显示所有未删除并且可以预约的医院
    		List<HospitalInfo> hospitalInfoList = hospitalInfoService.getAllHospital();
    		model.addAttribute("hospitalInfoList", hospitalInfoList);
    	}
		if("02".equals(type)) {//按科室预约
    		//显示所有科室
    		List<RegisterSchedule> getDeptNameList = reserveService.getDeptName(newCriteria);
    		model.addAttribute("DeptNameList", getDeptNameList);
    		//显示包括该科室的医院
    		if (ObjectUtil.isNotEmpty(deptName)) {
    			deptName = new String(deptName.getBytes("iso-8859-1"), "UTF-8").trim();
    			model.addAttribute("deptName", deptName);
    			Criteria deptSnCriteria = new Criteria("oc.name", deptName);
    			List<RegisterSchedule> getHospitalList = reserveService.getHosByDeptName(deptSnCriteria);
    			model.addAttribute("hospitalList", getHospitalList);
    		}
    	}
		model.addAttribute("type", type);
		return model;
	}
	
	/***
	 * 
	* @Title: scheduleClinic 
	* @Description: 按医院预约:显示科室
	* @param @param request
	* @param @param model
	* @param @param scheduleSearchForm
	* @param @return
	* @param @throws MalformedURLException
	* @param @throws IOException
	* @param @throws IllegalAccessException
	* @param @throws InstantiationException  参数说明 
	* @return String    返回类型 
	* @throws
	 */
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/scheduleClinic")
    private String scheduleClinic (HttpServletRequest request, ModelMap model, ScheduleSearchForm scheduleSearchForm) 
    		throws MalformedURLException, IOException, IllegalAccessException, InstantiationException {
    	model.addAttribute("type", scheduleSearchForm.getType());
    	String hospital = scheduleSearchForm.getHospital();
    	AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
    	accountInfo = accountInfoService.get(new Criteria("id", accountInfo.getId()));
    	model.addAttribute("accountInfo", accountInfo);
    	
    	//显示科室列表
    	List<OutClinic> queryDepartmentList = new ArrayList<OutClinic>();
    	if (ObjectUtil.isNotEmpty(this.commonMethods(hospital))) {//调用医院接口
    		Map<String, Object> queryDepartmentListMap = new HashMap<String, Object>();
    		
			//显示queryDepartmentListMap查询出来的科室
			queryDepartmentListMap = this.commonMethods(hospital).queryDepartmentList();
			
			//显示queryDepartmentListMap返回的code
			String returnCode = queryDepartmentListMap.get(Constants.RESERVE_RET_CODE).toString();
    		
    		if (Constants.RET_CODE_CORRECT.equals(returnCode)) {
    			queryDepartmentList = (List<OutClinic>) queryDepartmentListMap.get(Constants.RESERVE_RET_MSG);
    		}
    	} else {
    		queryDepartmentList = reserveService.getOutClinicList(new Criteria("HOSPITAL_CODE",hospital));
    	}
    	//按医院预约，显示该医院的信息和该医院下的所有科室列表
    	if ("01".equals(scheduleSearchForm.getType())) {
    		displayHospitalInfo(model, hospital);//显示被选中医院的信息
    		model.addAttribute("clinicList", queryDepartmentList);//科室为空时页面显示无科室
    	}
    	//通过预约状态来显示常用联系人
    	showFrequentByReserveStatus(model, accountInfo);
    	model.addAttribute("hospitalCode", hospital);
    	return "portal.reserve.scheduleClinic";
    }

    /***
     * 
    * @Title: displayHospitalInfo 
    * @Description: 显示被选中医院的信息 
    * @param @param model
    * @param @param hospital
    * @param @return  参数说明 
    * @return ModelMap    返回类型 
    * @throws
     */
	private ModelMap displayHospitalInfo(ModelMap model, String hospital) {
		if(StringUtil.isNotEmpty(hospital)) {
			HospitalInfo hospitalInfo = hospitalInfoService.getHospitalinfo(new Criteria("hospital_no", hospital).add("is_delete",0));
			hospitalPic(model, hospitalInfo.getId());//医院照片
			this.changeImageSrc(hospitalInfo);
			model.addAttribute("hospitalInfo", hospitalInfo); 
		}
		return model;
	}


	/***
	 * 
	* @Title: showFrequentByReserveStatus 
	* @Description: 通过预约状态来显示常用联系人
	* @param @param model
	* @param @param accountInfo  参数说明 
	* @return void    返回类型 
	* @throws
	 */
	private void showFrequentByReserveStatus(ModelMap model,
			AccountInfo accountInfo) {
		//通过预约状态对常用联系人进行排序
		    List<FrequentContacts> frequentContactsList = frequentContactsService.getFrequentContactsByOrderLists(new Criteria(FrequentContacts.ACCOUNT_ID, accountInfo.getId()), new Order("RESERVE_STATUS", false));
		    model.addAttribute("frequentContactsList", frequentContactsList);
		    //预约功能开启状态的常用联系人
		    List<FrequentContacts> frequentContactsLists1 =new ArrayList<FrequentContacts>();
		    if (ObjectUtil.isNotEmpty(frequentContactsList)) {
		    	for (FrequentContacts frequentContact: frequentContactsList){
		 	   	   if (frequentContact.getReserveStatus().equals(RET_CODE_CORRECT)){
		 	   		   frequentContactsLists1.add(frequentContact);
		 	   	   }
		    	}
		    }
		    //如果登录用户预约功能被禁用，默认选择第一个未被禁用的常用联系人
		    if (ObjectUtil.equals(accountInfo.getReserveStatus(), "0")) {
		    	if (ObjectUtil.isNotEmpty(frequentContactsLists1)) {
		    		String thisFrequentName = frequentContactsLists1.get(0).getFrequentName();
		    		model.addAttribute("thisFrequentName", thisFrequentName);
		    		model.addAttribute("frequent", frequentContactsLists1.get(0));
		    	}
		    }
	}


	//医院照片
    private void hospitalPic(ModelMap model, Long id) {
  		List<UploadInfoRecord> hospicuploadInfoRecords = new ArrayList<UploadInfoRecord>();
		List<UploadInfoRecord> uploadInfoRecord = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",id).add("FILE_RESOURCE", "lhHospitalPic"));
		hospicuploadInfoRecords.addAll(uploadInfoRecord);
  		model.addAttribute("hosPicattches", hospicuploadInfoRecords);
  	}

    /***
     * 
    * @Title: changeImageSrc 
    * @Description: 医院文本框中图片的显示
    * @param @param hospitalInfo  参数说明 
    * @return void    返回类型 
    * @throws
     */
    private void changeImageSrc(HospitalInfo hospitalInfo) {
        if (ObjectUtil.isNotEmpty(hospitalInfo)){
            String detail = hospitalInfo.getHospitalInfo();
            if (ObjectUtil.isNotEmpty(detail)){
                detail=changeImageSrc(detail);
                hospitalInfo.setHospitalInfo(detail);
            }
            String guideForMedical = hospitalInfo.getGuideForMedical();
            if (ObjectUtil.isNotEmpty(guideForMedical)){
                guideForMedical=changeImageSrc(guideForMedical);
                hospitalInfo.setGuideForMedical(guideForMedical);
            }
            String microGuidance = hospitalInfo.getMicroGuidance();
            if (ObjectUtil.isNotEmpty(microGuidance)){
                microGuidance=changeImageSrc(microGuidance);
                hospitalInfo.setMicroGuidance(microGuidance);
            }
        }

    }

    /***
     * 
    * @Title: scheduleList 
    * @Description: 显示预约资源列表 
    * @param @param scheduleSearchForm
    * @param @param indexPage
    * @param @param type
    * @param @param model
    * @param @return  参数说明 
    * @return String    返回类型 
    * @throws
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/scheduleList")
    public String scheduleList(ScheduleSearchForm scheduleSearchForm, int indexPage, String type, ModelMap model) {
    	String hospital = scheduleSearchForm.getHospital();
    	String deptSn = scheduleSearchForm.getClinic();
    	String deptName = scheduleSearchForm.getDeptName();
    	String doctorSn = scheduleSearchForm.getDoctor();
    	String clinicType = scheduleSearchForm.getClinicType();
    	
        if (ObjectUtil.isNullOrEmpty(scheduleSearchForm.getHospital()) && type.equals("01")) {
            return "portal.reserve.scheduleList";
        }
        if (ObjectUtil.isNullOrEmpty(scheduleSearchForm.getDeptName())  && type.equals("02")) {
            return "portal.reserve.scheduleList";
        }
        Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
		Date requestDateBegin = Axis2Util.getDate().get("sDate");//显示预约列表的开始时间
		Date requestDateEnd = Axis2Util.getDate().get("eDate");//显示预约列表结束时间(7天)
		
		if (ObjectUtil.isNotEmpty(this.commonMethods(hospital))) {//调用医院接口
			List<RegisterSchedule> querySchduleList = new ArrayList<RegisterSchedule>();
			Map<String, Object> querySchduleListMap = new HashMap<String, Object>();
			
			querySchduleListMap = this.commonMethods(hospital).querySchduleList(
					hospital,null,null,deptSn,deptName,doctorSn,clinicType);
			
			String returnCode = querySchduleListMap.get(Constants.RESERVE_RET_CODE).toString();
				
			if (Constants.RET_CODE_CORRECT.equals(returnCode)) {
				querySchduleList = (List<RegisterSchedule>) querySchduleListMap.get(Constants.RESERVE_RET_MSG);
			}
			if (ObjectUtil.isNotEmpty(querySchduleList)) {
				page.setTotalRows(querySchduleList.size());
			}
			PageList<RegisterSchedule> regsPageList =  new PageList<RegisterSchedule>(querySchduleList, page);
			List<RegisterSchedule> schduleList = new ArrayList<RegisterSchedule>();
			int sizes = pageCalculate(indexPage, page);
			
			for(int i = page.getStartRow(); i < sizes; i++) {
				schduleList.add(regsPageList.getList().get(i));//分页筛选后显示相应医生的资源列表
			}
			model.addAttribute("registerSchedules", schduleList);
			model.addAttribute("hospitalCode", hospital);
			model.addAttribute("page", regsPageList.getPage());
			
		} else {
			Criteria criteria = scheduleSearchForm.getCriteria("RS", "OC");
    		DateUtil.getCriteriaByDateRange(criteria, "RS.REQUEST_DATE", requestDateBegin, requestDateEnd);
			PageList<RegisterSchedule> registerSchedules = registerScheduleService.getRegisterSchedule(criteria, page);
	        model.addAttribute("registerSchedules", registerSchedules.getList());
	        model.addAttribute("page", registerSchedules.getPage());
		}
        model.addAttribute("startDate", DateUtil.toDateString(requestDateBegin, "yyyy/MM/dd"));
        model.addAttribute("endDate", DateUtil.toDateString(requestDateEnd, "yyyy/MM/dd"));
        model.addAttribute("dateList", registerScheduleService.getBetweenDate(requestDateBegin, requestDateEnd));
        model.addAttribute("hospitalCode", hospital);
        model.addAttribute("type", type);
        return "portal.reserve.scheduleList";
    }

    /***
     * 
    * @Title: pageCalculate 
    * @Description: 调用医院接口:计算分页
    * @param @param indexPage
    * @param @param page
    * @param @return  参数说明 
    * @return int    返回类型 
    * @throws
     */
	private int pageCalculate(int indexPage, Page page) {
		int sizes;//显示条数的最大范围
		int intSize = page.getTotalRows()/page.getPageSize();//总页数
		if ("1".equals(String.valueOf(indexPage))) {
			if (page.getTotalRows() <= page.getPageSize()) {
				sizes = page.getTotalRows();
			} else {
				sizes = page.getPageSize();
			}
		} else if (indexPage <= intSize) {
			sizes = page.getStartRow()+page.getPageSize();
		} else {
			int retu= page.getTotalRows()-(intSize)*page.getPageSize();
			sizes = page.getStartRow() + retu;
		}
		return sizes;
	}

	private Date getRequestDateBegin() {
		String startViewReserveHour = portalSetService.getByCode(Constants.PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[0];
		String startViewReserveMin = portalSetService.getByCode(Constants.PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[1];
		Date requestDateBegin = null;
		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour,startViewReserveMin))) {
			//查看后天以后的天资源
			requestDateBegin = getRequestDateByTime(2);
		} else {
			//查看明天以后的天资源
			requestDateBegin = getRequestDateByTime(1);
		}
		return requestDateBegin;
	}
	
	private Date getRequestDateEnd() {
		String startViewReserveHour = portalSetService.getByCode(Constants.PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[0];
		String startViewReserveMin = portalSetService.getByCode(Constants.PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[1];
		Date requestDateEnd = null;
		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour,startViewReserveMin))) {
			//查看后天以后的7天资源
			requestDateEnd = getRequestDateByTime(8);
		} else {
			//查看明天以后的7天资源
			requestDateEnd = getRequestDateByTime(7);
		}
		return requestDateEnd;
	}
	
	 private Date getRequestDateByTime(int i) {
		Date requestDate = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,i);
		return requestDate;
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
    
    /***
     * 门户页面未刷新时，验证预约状态是否被禁止或开启
     * @param request
     * @param frequentId
     * @return
     */
    @RequestMapping(value = "/checkReserveStatus")
    @ResponseBody
    public ModelMap checkReserveStatus (HttpServletRequest request, Long frequentId) {
    	ModelMap model = new ModelMap();
    	if(ObjectUtil.isNotEmpty(frequentId)) {
    		String frequentReserveStatue = frequentContactsService.get(frequentId).getReserveStatus();
    		if(frequentReserveStatue.equals("0")) {
    			return model.addAttribute("success", false);
    		}
    	} else {
    		AccountInfo accountInfo  = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
    		String accountInfoStatue = accountInfoService.get(accountInfo.getId()).getReserveStatus();
    		if(accountInfoStatue.equals("0")) {
    			return model.addAttribute("success", false);
    		}
    	}
    	model.addAttribute("success", true);
    	return model;
    }
    
    /**
     * 显示预约时段的资源
     *
     * @param scheduleId
     * @param model
     * @return
     * @throws InstantiationException 
     * @throws IllegalAccessException 
     */
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/select")
    public String select(HttpServletRequest request, ModelMap model, String data) throws IllegalAccessException, InstantiationException { 
    	RegisterSchedule registerSchedule = (RegisterSchedule) json2Obj(data, RegisterSchedule.class).get(0);
    	if (StringUtil.isNotEmpty(registerSchedule.getSubId())) {
    		String id = registerSchedule.getId()+registerSchedule.getSubId();
    		registerSchedule.setId(Long.valueOf(id));
    	}
    	String hospitalCode = registerSchedule.getHospitalCode();
    	if (ObjectUtil.isNotEmpty(this.commonMethods(hospitalCode))) {//调用医院接口
    		List<RegisterSchedule> registerScheduleLists = new ArrayList<RegisterSchedule>();
    		Map<String, Object> querySchduleListMap = new HashMap<String, Object>();
    		String returnCode = null;
    			querySchduleListMap = this.commonMethods(hospitalCode).selectSchdule(registerSchedule);
    			returnCode = querySchduleListMap.get(Constants.RESERVE_RET_CODE).toString();
    		if (Constants.RET_CODE_CORRECT.equals(returnCode)) {
    			registerScheduleLists = (List<RegisterSchedule>) querySchduleListMap.get(Constants.RESERVE_RET_MSG);
    		}
    		
    		model.addAttribute("registerScheduleList", registerScheduleLists);
    		model.addAttribute("hospitalCode", hospitalCode);
    		model.addAttribute("isRealTime",true);
    		if (ObjectUtil.isNotEmpty(registerSchedule.getId())) {
    			model.addAttribute("scheduleId", registerSchedule.getId());
    		}
    	} else {
    		Criteria criteria = new Criteria("REGISTER_SCHEDULE_ID", registerSchedule.getId());
            List<RegisterScheduleTime> registerScheduleTimeList = registerScheduleService.getRegisterScheduleTimeLists(criteria);
            RegisterSchedule regSchedule = registerScheduleService.getRegisterSchedule(new Criteria("id", registerSchedule.getId()));
            model.addAttribute("registerScheduleTimeList", registerScheduleTimeList);
            model.addAttribute("registerSchedule", regSchedule);
            model.addAttribute("scheduleId", registerSchedule.getId());
            model.addAttribute("isRealTime",false);
    	}
		return "portal.reserve.registerScheduleTimeView";
    }
    
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/loadConfirmInfo")
    public String loadConfirmInfo(HttpServletRequest request, ModelMap model, String data, Long frequentId, Long scheduleId, Long scheduleTimeId) throws IllegalAccessException, InstantiationException {
    	List<RegisterSchedule> registerSchedules = (List<RegisterSchedule>) json2Obj(data, RegisterSchedule.class);
    	RegisterSchedule registerSchedule = registerSchedules.get(0);
    	if (ObjectUtil.isNotEmpty(commonMethods(registerSchedule.getHospitalCode()))) {
    		model.addAttribute("registerSchedule", registerSchedule);
    		model.addAttribute("isRealTime", true);
    	} else {
    		RegisterScheduleTime registerScheduleTime = registerScheduleService.getRegisterScheduleTime(new Criteria("id", scheduleTimeId));
            RegisterSchedule registerSche = registerScheduleService.getRegisterSchedule(new Criteria("id", scheduleId));
            model.addAttribute("registerScheduleTime", registerScheduleTime);
            model.addAttribute("registerSchedule", registerSche);
            model.addAttribute("isRealTime", false);
    	}
    	model.addAttribute("personInfo", getSchedulePersonInfo(request, frequentId));
        return "portal.reserve.reserveConfirmView";
    }


    /**
     * json数组转成List
     *
     * @param jsonArrayStr
     * @param clazz
     * @return
     */
    @SuppressWarnings({ "unchecked" })
	private static List<?> json2Obj(String jsonArrayStr, @SuppressWarnings("rawtypes") Class clazz) throws IllegalAccessException, InstantiationException {
    	@SuppressWarnings("rawtypes")
		List resultList = new ArrayList();
    	if (StringUtil.isNullOrEmpty(jsonArrayStr)) {
    		return resultList;
    	}
    	JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        String[] dateFormats = new String[]{"yyyy/MM/dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            Object obj = JSONObject.toBean(jsonObj, clazz);
            if(ObjectUtil.isNotEmpty(obj)){
                resultList.add(obj);
            }
        }
        return resultList;
    } 
    
    @RequestMapping(value = "/save")
    @ResponseBody
    public ModelMap save(HttpServletRequest request, ReserveRegister register,String hospitalCode, Long scheduleId, Long scheduleTimeId, Long frequentId) throws InstantiationException, IllegalAccessException {
    	ModelMap model = new ModelMap();
    	String result = null;
    	String registTime = null;/*妇幼返回用户就近一次的办卡时间*/
    	if (ObjectUtil.isNotEmpty(this.commonMethods(hospitalCode))) {
    		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
    		accountInfo = accountInfoService.get(new Criteria("id", accountInfo.getId()));
            //排班资源有唯一标识时，放入timeId字段
            if(ObjectUtil.isNotEmpty(scheduleId)) {
                register.setRegisterScheduleTimeId(scheduleId.toString());
            }
    		if (ObjectUtil.isNotEmpty(frequentId)) {
    			PersonInfo person = getSchedulePersonInfo(request, frequentId);
    			register.setName(person.getName());
    			register.setPhoneNumber(person.getPhoneNumber());
    			register.setIdcard(person.getIdcard());
    			
    		} else {
    			register.setName(accountInfo.getRealName());
    			register.setPhoneNumber(accountInfo.getTelephone());
    			register.setIdcard(accountInfo.getCardNo());
    		}
    		register.setSubmitUserName(accountInfo.getRealName());
    		register.setSubmitUser(accountInfo.getId());
    		register.setRegFrom(REG_PORTAL);
    		register.setAccountId(accountInfo.getId());
    		
    		Map<String, Object> isReserve = null;
    		
			isReserve = this.commonMethods(hospitalCode).saveReserve(register);
			
			if (Constants.RET_CODE_CORRECT.equals(isReserve.get(Constants.RESERVE_RET_CODE))) {
				ReserveRegister reserveRegister = (ReserveRegister) isReserve.get(Constants.RESERVE_RET_MSG);
				reserveService.sendSMS(reserveRegister, SMSUtil.MODE_TYPE_1);
				result = reserveRegister.getId().toString();
				if (ObjectUtil.isNotEmpty(reserveRegister.getRegistTime())) {
					registTime = DateUtil.toDateString(reserveRegister.getRegistTime(), "yyyy年MM月dd日");
				}
				createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户预约挂号成功", OperationName.RESERVE_REPEAT);
			} else {
				result = isReserve.get(Constants.RESERVE_RET_MSG).toString();
				createOperationLog(request, RhipModuleName.LHPORTAL, result, OperationName.RESERVE_FAIL);
			}
    		
    	} else {
    		PersonInfo personInfo = getSchedulePersonInfo(request, frequentId);
            Long userId = getCurrentAccountInfoId(request);
            //保存患者信息
            result = reserveService.saveReserveRegister(personInfo, scheduleId, scheduleTimeId, null, userId, REG_PORTAL);
            switch (result) {
    			case "fail": createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户预约挂号失败", OperationName.RESERVE_FAIL); break;
    								
    			case "full": createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户预约挂号数量已满", OperationName.RESERVE_FULL); break;
    								
    			case "over": createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户预约挂号同一天超过三次", OperationName.RESERVE_OVER); break;
    			
    			case "repeat": createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户已经预约相同医生", OperationName.RESERVE_REPEAT); break;
    			
    			default: createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户预约挂号成功", OperationName.RESERVE_SUCCESS);
            }	
    	}
    	if (Constants.MATERNAL_CHILD_HOSPITAL.equals(hospitalCode)) {
    		model.addAttribute("needTip", true);
    	} else {
    		model.addAttribute("needTip", false);
    	}
    	model.addAttribute("result", result);
    	model.addAttribute("registTime", registTime);
        return model;
    }


    @RequestMapping(value = "/view/{regId}")
    public String view(@PathVariable("regId") Long regId, ModelMap model, HttpServletRequest request) {
        ReserveRegister reserveRegister = reserveService.getReserveRegister(regId);
        if (ObjectUtil.isNullOrEmpty(reserveRegister)) {
            return "portal.reserve.view";
        }
        createOperationLog(request, RhipModuleName.LHPORTAL, "查看健康门户预约信息", OperationName.UPDATE);
        model.addAttribute("reserveRegister", reserveRegister);
        String code = reserveRegister.getAmpm() + "_" + reserveRegister.getHospitalCode();
		/*model.addAttribute("promptMessage", portalSetService.getByCode(code));*/
        return "portal.reserve.view";
    }

    @RequestMapping(value = "/cancel")
    @ResponseBody
    public String cancel(HttpServletRequest request, Long regId) {
    	ReserveRegister reserveRegister = reserveService.getReserveRegister(regId);
    	if (ObjectUtil.isNullOrEmpty(reserveRegister)) {
			return EHRConstants.CANCEL_FAIL;
		}
    	String hospitalCode = reserveRegister.getHospitalCode();
    	String result = null;
    	
    	if (ObjectUtil.isNotEmpty(this.commonMethods(hospitalCode))) {
    		Map<String, Object> reserveReg = null;
    			reserveReg = this.commonMethods(hospitalCode).cancleReserve(reserveRegister);
    		if (Constants.RET_CODE_ERROR.equals(reserveReg.get(Constants.RESERVE_RET_CODE))) {
    			result = reserveReg.get(Constants.RESERVE_RET_MSG).toString();
    			return result;
    		}
    	} else {
    		String startViewReserveHour = portalSetService.getByCode(Constants.PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[0];
    		String startViewReserveMin = portalSetService.getByCode(Constants.PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[1];
    		Date date = DateUtil.convertDate("MM/dd/yyyy", new Date());
    		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour,startViewReserveMin))) {
    			//如果当前日前在PORTAL_RESERVE_VIEW_END_TIME后，将当前日期加1天
    			date = DateUtil.add(date, Calendar.DAY_OF_MONTH,1);
    		}
    		if(!(reserveRegister.getRequestDate().after(date))) {//如果当前日期加1天等于预约表的日期就提示
    			String rs= ReserveStauts.getByStauts("06").getDescription();
    			result = "请在就诊日前一天"+startViewReserveHour+":"+startViewReserveMin+"之前"+rs;
    			return result;
    		}
    	}
    	
		//取消操作人
		reserveRegister.setCancelUser(this.getPerson(request).getName());
		//取消时间
		reserveRegister.setCancelTime(new Date());
		//操作来源
		reserveRegister.setCancelFlag(REG_PORTAL);
		
		return cancelReserve(request, reserveRegister);
    }
    
    /***
     * 取消预约加上时间限制
     * @param request
     * @param regId
     * @return
     */
    private String cancelReserve(HttpServletRequest request, ReserveRegister reserveRegister) {
		String result;
		result = reserveService.cancelRegister(reserveRegister);
		if (EHRConstants.CANCEL_OK.equals(result))
			createOperationLog(request, RhipModuleName.LHPORTAL, "健康门户取消挂号", OperationName.UPDATE);
		return result;
	}


    @RequestMapping(value = "/print")
    public String print() {
        return "portal.reserve.print";
    }

    /***
     * 预约快速搜索
     * @param searchContent
     * @param indexPage
     * @param model
     * @return
     */
    @RequestMapping(value = "/reserveSearchList")
    public String reserveSearch(String searchContent, String type, int indexPage, ModelMap model) {
    	Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
    	PageList<RegisterSchedule> registerSchedulePageLists = registerScheduleService.getSearchRegisterSchedulePageLists(page,searchContent);
    	List<HospitalInfo> hospitalInfoLists = hospitalInfoService.getHosInfoByDistinctHosRegScheduleLists(new Criteria());
    	model.addAttribute("hospitalInfoLists", hospitalInfoLists);
    	model.addAttribute("registerScheduleLists", registerSchedulePageLists.getList());
    	model.addAttribute("page", registerSchedulePageLists.getPage());
    	model.addAttribute("searchContent", searchContent);
    	model.addAttribute("searchContentRed", "<font style=\"color:#F05A2E\">"+searchContent+"</font>");
    	model.addAttribute("type", type);
        return "portal.reserve.reserveSearchList";
    }


    @RequestMapping(value = "/frequent/search")
    public String frequentContacts() {
        return "portal.reserve.frequent";
    }

    @RequestMapping(value = "/frequent/list")
    public String frequentList(FrequentSearchForm frequentSearchForm, int indexPage, ModelMap model, HttpServletRequest request) {
        Page page = new Page(EHRConstants.PAGE_SIZE, indexPage);
        Criteria criteria = frequentSearchForm.getCriteria();
        criteria.add(FrequentContacts.ACCOUNT_ID, getCurrentAccountInfoId(request));
        PageList<FrequentContacts> frequentContactsList = frequentContactsService.getFrequentPageList(page, criteria);
        model.addAttribute("frequentContactsList", frequentContactsList.getList());
        model.addAttribute("page", frequentContactsList.getPage());
        return "portal.reserve.frequentList";
    }

    @RequestMapping(value = "/frequent/save")
    @ResponseBody
    public String save(HttpServletRequest request, FrequentContacts frequentContacts, ModelMap model, String contents) {
        if (ObjectUtil.isNullOrEmpty(frequentContacts)) return "";
        frequentContacts.setAccountId(getCurrentAccountInfoId(request));
        createOperationLog(request, RhipModuleName.LHPORTAL, "保存常用联系人信息", OperationName.UPDATE);
        return frequentContactsService.update(frequentContacts, getCurrentAccountInfoId(request));
    }


    @RequestMapping(value = "/frequent/deleteFrequent")
    @ResponseBody
    public String deleteFrequent(HttpServletRequest request, Long frequentId) {
        createOperationLog(request, RhipModuleName.LHPORTAL, "删除常用联系人信息", OperationName.UPDATE);
        return frequentContactsService.delete(frequentId);
    }

	@RequestMapping(value = "/intelligentGuidance")
    public String intelligentGuidance(ModelMap model) {
		return "portal.reserve.intelGuide";
	}

	@RequestMapping(value = "/getBodyList")
	@ResponseBody
	public JSONObject getBodyList() {
    	String url = properties.getProperty("intelGuide.getBodyList");
		JSONObject json = HttpClientUtil.sendPost(url, "");
		return json;
	}

	@RequestMapping(value = "/getSymptomList")
	@ResponseBody
	public JSONObject getSymptomList(String sex, String bodyId, String age) {
    	String url = properties.getProperty("intelGuide.getSymptomList");
		String param = "sex=" + sex + "&bodyId=" + bodyId + "&age=" + age;
		String result = HttpClientUtil.sendPost1(url, param);
		JSONObject json = JSONObject.fromObject(result);
		return json;
	}

	@RequestMapping(value = "/getQuestionList")
	@ResponseBody
	public JSONObject getQuestionList(String sex, String symptomId) {
    	String url = properties.getProperty("intelGuide.getQuestionList");
		String param = "sex=" + sex + "&symptomId=" + symptomId;
		String result = HttpClientUtil.sendPost1(url, param);
		JSONObject json = JSONObject.fromObject(result);
		return json;
	}

	@RequestMapping(value = "/getRecDept")
	@ResponseBody
	public JSONObject getRecDept(String age, String sex, String symptomId) {
    	String url = properties.getProperty("intelGuide.getRecDept");
		String param = "age=" + age + "&sex=" + sex + "&symptomId=" + symptomId;
		String result = HttpClientUtil.sendPost1(url, param);
		JSONObject json = JSONObject.fromObject(result);
		return json;
	}

    private PersonInfo getSchedulePersonInfo(HttpServletRequest request, Long frequentId){
        PersonInfo personInfo = new PersonInfo();
    	if (ObjectUtil.isNotEmpty(frequentId)) {
            FrequentContacts frequentContacts = frequentContactsService.getFrequent(new Criteria(FrequentContacts.ID, frequentId));
            if (ObjectUtil.isNotEmpty(frequentContacts)) {
                personInfo.setName(frequentContacts.getFrequentName());
                personInfo.setPhoneNumber(frequentContacts.getTelephone());
                personInfo.setGender(frequentContacts.getGender());
                personInfo.setBirthday(frequentContacts.getBirthday());
                personInfo.setIdcard(frequentContacts.getCardNo());
                //todo:shushu:这些字段在frequentContacts还缺少，需要补充！
//                    personInfo.setIdcardFarm();
//                    personInfo.setIcdcardArchives();
//                    personInfo.setIdcardHos();
//                    personInfo.setUnitName();
//                    personInfo.setPatownShip();
//                    personInfo.setPastreet();
//                    personInfo.setPahouseNumber();
            }
        } else {
        	personInfo = this.getPerson(request);
        }
        return personInfo;
    }
    
    /***
     * 根据不同医院调用不同接口
     * @param hospitalCode
     * @return
     */
	public IHospitalReserveAdapter commonMethods(String hospitalCode) { 
		switch (hospitalCode) {
			case Constants.FIRST_HOSPITAL:
				/*return firstHospitalReserveAdapter;*/
				return null;
			case Constants.SECOND_HOSPITAL:
				return null;
			case Constants.THIRD_HOSPITAL:
				return null;
			case Constants.CHINESE_MEDICINE_HOSPITAL:
				return chineseMedicineHospitalReserveAdapter;
			case Constants.MATERNAL_CHILD_HOSPITAL:
				return maternalChildrenHospitalReserveAdapter;
			case Constants.STOMATOLOGICAL_HOSPITAL:
				return stomatologicalHospitalReserveAdapter;
			default: return null;
		}
	}
}

