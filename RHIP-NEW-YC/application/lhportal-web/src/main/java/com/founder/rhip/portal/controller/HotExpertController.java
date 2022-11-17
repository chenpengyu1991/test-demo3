package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.*;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.portal.common.Constants;
import com.founder.rhip.portal.service.*;
import com.founder.rhip.portal.service.form.ScheduleSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * Sample controller for going to the home page with a message
 */
@Controller
@RequestMapping(value = "/userSpace/hotExpert")
public class HotExpertController extends BaseController {
	
	@Resource(name = "reserveService")
    private IReserveService reserveService;
	
	@Resource(name = "registerScheduleService")
    private IRegisterScheduleService registerScheduleService;
	
	@Resource(name = "lhFrequentContactsService")
    private IFrequentContactsService frequentContactsService;
	
	@Resource(name = "outDoctorService")
    private IOutDoctorService outDoctorService;
	
	@Resource(name = "lhhospitalInfoService")
	private IHospitalInfoService hospitalInfoService;
	
	@Resource(name = "portalSetService")
    private IPortalSetService portalSetService;
	
	@Resource(name = "lhaccountInfoService")
    private IAccountInfoService accountInfoService;
	
	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
	
	@RequestMapping(value="/search")
	public String search(HttpServletRequest request, ModelMap model, String hospitalCode, String deptSn, String doctorSn) {
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
		model.addAttribute("accountInfo", accountInfo);
		Criteria criteria = initCriteria("od.");
		//显示outdoctor的医院名称
		List<OutDoctor> hospitalNameList = outDoctorService.getOutHospitals(criteria);
		HospitalInfo hospitalInfo = hospitalInfoService.getHospitalinfo(new Criteria("hospital_no", hospitalCode).add("is_delete",0));
	    model.addAttribute("hospitalInfo", hospitalInfo);  
        model.addAttribute("hospitalNameList", hospitalNameList);
        
        criteria.add("od.hospital_code", hospitalCode);
        //显示outdoctor的科室名称
        if(StringUtil.isNotEmpty(hospitalCode)) {
        List<OutDoctor> clinicList = outDoctorService.getHotClinics(criteria);
        model.addAttribute("clinicList", clinicList);
        }
        //显示outdoctor的医生职称
        if(StringUtil.isNotEmpty(hospitalCode) && StringUtil.isNotEmpty(deptSn)) {
        	List<OutDoctor> empList = outDoctorService.getHotEmpTits(criteria.add("od.dept_sn",deptSn));
        	OutDoctor outClinic = outDoctorService.getOutClinic(new Criteria("dept_Sn", deptSn).add("hospital_Code",hospitalCode));
            model.addAttribute("clinic", outClinic);
        	model.addAttribute("empList", empList);
        }
        if(StringUtil.isNotEmpty(hospitalCode) && StringUtil.isNotEmpty(deptSn) && StringUtil.isNotEmpty(doctorSn)) {
        	//显示outdoctor的医生
        	OutDoctor doctorSns = outDoctorService.getOutEmpTit(new Criteria("doctor_sn", doctorSn).add("hospital_Code",hospitalCode).add("dept_Sn",deptSn));
        	model.addAttribute("doctorSns", doctorSns);
        }
        
		return "portal.hotExpert.search";
	}
	
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request, ModelMap model, Integer indexPage, String searchContent, OutDoctor outdoctor) {
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
		model.addAttribute("accountInfo", accountInfo);
		Page page = new Page(10, indexPage);
		if(ObjectUtil.isNotEmpty(outdoctor)) {
			Criteria criteria = newCriterai(outdoctor);
			PageList<OutDoctor> showHotDoctorsPageLists = outDoctorService.showHotDoctors(page,"".equals(searchContent)?null:searchContent,criteria);
			criteria = new Criteria();
			if(StringUtil.isNotEmpty(outdoctor.getHospitalCode())) {
				criteria.add("hospital_code", outdoctor.getHospitalCode());
			}
			outDoctorPic(model, showHotDoctorsPageLists.getList());
			model.addAttribute("showHotDoctorsLists", showHotDoctorsPageLists.getList());
			model.addAttribute("page", showHotDoctorsPageLists.getPage());
		}
		return "portal.hotExpert.list";
	}
	
	//医生照片
	public void outDoctorPic(ModelMap model, List<OutDoctor> outDoctorList) {
		List<Long> ids = new ArrayList<Long>();
		for(int i = 0; i < outDoctorList.size(); i++) {
			ids.add(outDoctorList.get(i).getId());	
		}
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",OP.IN, ids).add("FILE_RESOURCE", "outDoctorPic"));
		for (OutDoctor outDoctor: outDoctorList) {
			for (UploadInfoRecord uploadInfoRecord: uploadInfoRecords) {
				if(ObjectUtil.equals(outDoctor.getId(), uploadInfoRecord.getResourceId())){
					outDoctor.setUploadFileId(uploadInfoRecord.getId());
					uploadInfoRecords.remove(uploadInfoRecord);
					break;
				}
			}
		}
	}
		
	@RequestMapping(value = "/scheduleList")
    public String scheduleList(HttpServletRequest request, ScheduleSearchForm scheduleSearchForm, ModelMap model) {
		AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
		accountInfo = accountInfoService.get(new Criteria("id", accountInfo.getId()));
	    model.addAttribute("accountInfo", accountInfo);
	    
	    //通过ReserveStatus来显示可进行预约的常用联系人
	    showFrequentByReserveStatus(model, accountInfo);
	    
        if (ObjectUtil.isNullOrEmpty(scheduleSearchForm.getHospital())) {
            return "portal.hotExpert.scheduleList";
        }
        Criteria criteria = scheduleSearchForm.getCriteria("RS", "OC");
        String startViewReserveHour = portalSetService.getByCode(Constants.PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[0];
		String startViewReserveMin = portalSetService.getByCode(Constants.PORTAL_RESERVE_VIEW_END_TIME).split("\\:")[1];
		Date requestDateBegin = null;
		Date requestDateEnd  = null;
		if (getRequestTimeBegin().after(getRequestTimeEnd(startViewReserveHour,startViewReserveMin))) {
			//查看后天以后的7天资源
			requestDateBegin = getRequestDateByTime(2);
			requestDateEnd = getRequestDateByTime(8);
		}else {
			//查看明天以后的7天资源
			requestDateBegin = getRequestDateByTime(1);
			requestDateEnd = getRequestDateByTime(7);
		}
		DateUtil.getCriteriaByDateRange(criteria, "RS.REQUEST_DATE", requestDateBegin, requestDateEnd);
        List<RegisterSchedule> registerSchedules = registerScheduleService.getNoPageRegisterSchedule(criteria);

		model.addAttribute("registerSchedules", registerSchedules);
		model.addAttribute("hospitalCode", scheduleSearchForm.getHospital());
		model.addAttribute("deptSn", scheduleSearchForm.getClinic());
		model.addAttribute("doctorSn", scheduleSearchForm.getDoctor());
        model.addAttribute("startDate", DateUtil.toDateString(requestDateBegin, "yyyy/MM/dd"));
        model.addAttribute("endDate", DateUtil.toDateString(requestDateEnd, "yyyy/MM/dd"));
        model.addAttribute("dateList", registerScheduleService.getBetweenDate(requestDateBegin, requestDateEnd));
        return "portal.hotExpert.scheduleList";
    }

	/**
	 * 通过ReserveStatus来显示可进行预约的常用联系人
	 * @param model
	 * @param accountInfo
	 */
	private void showFrequentByReserveStatus(ModelMap model,
			AccountInfo accountInfo) {
		//通过预约状态对常用联系人进行排序
		    List<FrequentContacts> frequentContactsList = 
		    		frequentContactsService.getFrequentContactsByOrderLists(
		    				new Criteria(FrequentContacts.ACCOUNT_ID, accountInfo.getId()), new Order("RESERVE_STATUS", false));
		    model.addAttribute("frequentContactsList", frequentContactsList);
		    //预约功能开启状态的常用联系人
		    List<FrequentContacts> frequentContactsLists1 =new ArrayList<FrequentContacts>();
		    if (ObjectUtil.isNotEmpty(frequentContactsList)) {
		    	for (FrequentContacts frequentContact: frequentContactsList){
		 	   	   if (frequentContact.getReserveStatus().equals("1")){
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
	
	private Date getRequestDateByTime(int i) {
		Date requestDate = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,i);
		return requestDate;
	}

	/**
     * 显示预约时段的资源
     *
     * @param scheduleId
     * @param model
     * @return
     */
    @RequestMapping(value = "/select")
    public String select(HttpServletRequest request, Long scheduleId, ModelMap model) { 
		Criteria criteria = new Criteria("REGISTER_SCHEDULE_ID", scheduleId);
		List<RegisterScheduleTime> registerScheduleTimeList = registerScheduleService.getRegisterScheduleTimeLists(criteria);
		RegisterSchedule registerSchedule = registerScheduleService.getRegisterSchedule(new Criteria("id", scheduleId));
    	model.addAttribute("registerScheduleTimeList", registerScheduleTimeList);
    	model.addAttribute("registerSchedule", registerSchedule);
    	model.addAttribute("scheduleId", scheduleId);
		return "portal.hotExpert.registerScheduleTimeView";
    }

    @RequestMapping(value = "/loadConfirmInfo")
    public String loadConfirmInfo(HttpServletRequest request, ModelMap model, Long scheduleId, Long scheduleTimeId, Long frequentId) {
        RegisterScheduleTime registerScheduleTime = registerScheduleService.getRegisterScheduleTime(new Criteria("id", scheduleTimeId));
        RegisterSchedule registerSchedule = registerScheduleService.getRegisterSchedule(new Criteria("id", scheduleId));
        model.addAttribute("personInfo", getSchedulePersonInfo(request, frequentId));
        model.addAttribute("registerScheduleTime", registerScheduleTime);
        model.addAttribute("registerSchedule", registerSchedule);
        return "portal.hotExpert.reserveConfirmView";
    }
    
    /***
     * 热门医生快速搜索
     * @param searchContent
     * @param model
     * @return
     */
    @RequestMapping(value = "/hotExpertSearchList")
    public String reserveSearch(HttpServletRequest request, String searchContent, ModelMap model, Integer indexPage) {
    	AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
		model.addAttribute("accountInfo", accountInfo);
    	Page page = new Page(3, indexPage);
		PageList<OutDoctor> showHotDoctorsPageLists = outDoctorService.showHotDoctors(page,searchContent,initCriteria("od."));
		outDoctorPic(model, showHotDoctorsPageLists.getList());//显示医生照片		
		model.addAttribute("showHotDoctorsLists", showHotDoctorsPageLists.getList());
		model.addAttribute("page", showHotDoctorsPageLists.getPage());
		return "portal.hotExpert.list";
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
	
	private Criteria newCriterai(OutDoctor outdoctor) {
		Criteria criteria = new Criteria();
		criteria.add(initCriteria("od."));
		if(ObjectUtil.isNotEmpty(outdoctor.getHospitalCode())) {
			criteria.add("od.hospital_code", outdoctor.getHospitalCode());
		}
		if(ObjectUtil.isNotEmpty(outdoctor.getDeptSn())) {
			criteria.add("od.dept_sn", outdoctor.getDeptSn());	
		}
		if(ObjectUtil.isNotEmpty(outdoctor.getEmpTitCode())) {
			criteria.add("od.emp_tit_code", outdoctor.getEmpTitCode());
		}
		if(ObjectUtil.isNotEmpty(outdoctor.getDoctorSn())) {
			criteria.add("od.doctor_sn", outdoctor.getDoctorSn());
		}
		return criteria;
	}

	/**
	 * 初始化查询的基础条件
	 * @param pre
	 * @return
	 */
	private Criteria initCriteria(String pre) {

		Criteria criteria = new Criteria();
		criteria.add(pre + "is_hot", "1");
		criteria.add(pre + "is_delete", 0);
		criteria.add(pre + "status", 1);

		return criteria;
	}
}
