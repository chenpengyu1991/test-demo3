package com.founder.rhip.portal.controller;


import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.entity.portal.OutDoctor;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.mdm.common.CommonUtil;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.portal.service.IHospitalInfoService;
import com.founder.rhip.portal.service.IOutDoctorService;
import com.founder.rhip.portal.service.IRegisterScheduleService;
import com.founder.rhip.portal.service.form.ScheduleSearchForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/**
 * 热门专家管理
 * 
 *
 */
@Controller
@RequestMapping(value = "/outDoctor")
public class OutDoctorController extends BaseController {

	@Resource(name="outDoctorService")
	private IOutDoctorService outDoctorService;

	@Resource(name="lhhospitalInfoService")
	private IHospitalInfoService hospitalInfoService;

	@Resource(name = "registerScheduleService")
	private IRegisterScheduleService registerScheduleService;

	@Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;

	//预约时间开始的key值
	public static final String PORTAL_RESERVE_START_TIME= "portal_reserve_start_time";

	//预约时间结束的key值
	public static final String PORTAL_RESERVE_END_TIME= "portal_reserve_end_time";

	//预约时间结束的key值
	public static final String PORTAL_RESERVE_VIEW_END_TIME= "portal_reserve_view_end_time";

	@RequestMapping(value="/search")
	public String search(HttpServletRequest request, ModelMap model) {
		this.initHospitalList(request, model);
		return "portal.doctor.search";
	}
	
	/**
	 * 出诊医生列表
	 * 
	 * @param request
	 * @param indexPage
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list")
	public String list(HttpServletRequest request, Integer indexPage, ModelMap model, OutDoctor outDoctor) {
		int currentPage = indexPage;
		Page page = super.getPage(request, currentPage);
		Criteria criteria = initSearch(outDoctor);//获取查询条件

		/*当前机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		if (!hasRole(RoleType.ADMIN, request)){
			criteria.add("HOSPITAL_CODE", currentOrgCode);
		}

		PageList<OutDoctor> pageList = outDoctorService.getOutDoctors(page, criteria);
		model.addAttribute("outDoctors", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		this.initHospitalList(request, model);
		return "portal.doctor.list";
	}
	
	/**
	 * 编辑出诊医生信息
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/detail")
	public String getOutDoctor(HttpServletRequest request, ModelMap model, Long id, Boolean ifSee) {
		this.initHospitalList(request, model);
		OutDoctor outDoctor = new OutDoctor();
		if(ObjectUtil.isNotEmpty(id)) {
			outDoctor = outDoctorService.getOutDoctor(new Criteria("id", id));
		}
		model.addAttribute("outDoctor", outDoctor);
		model.addAttribute("ifSee", ifSee);
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",id).add("FILE_RESOURCE", "outDoctorPic"));
		model.addAttribute("attches", uploadInfoRecords);
		return "portal.doctor.detail";
	}
	
	/**
	 * 查看出诊医生信息
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/view")
	public String view(HttpServletRequest request, ModelMap model, Long id, Boolean ifSee) {
		this.initHospitalList(request, model);
		OutDoctor outDoctor = new OutDoctor();
		if(ObjectUtil.isNotEmpty(id)) {
			outDoctor = outDoctorService.getOutDoctor(new Criteria("id", id));
		}
		String hospitalCode = outDoctor.getHospitalCode();
		if(ObjectUtil.isNotEmpty(hospitalCode)) {
			String hospitalName = hospitalInfoService.getHospitalinfo(new Criteria("HOSPITAL_NO", hospitalCode)).getHospitalName();
			model.addAttribute("hospitalName", hospitalName);
		}
		model.addAttribute("outDoctor", outDoctor);
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID",id).add("FILE_RESOURCE", "outDoctorPic"));
		model.addAttribute("attches", uploadInfoRecords);
		return "portal.doctor.view";
	}

	/*
	 * 专家信息保存
	 *
	 * @param request
	 * @param model
	 * @param serviceInfo
	 * @param contents
	 * @return
	 */
	@RequestMapping("/save")
	public String save(HttpServletRequest request, ModelMap model, @Valid OutDoctor outDoctor) {
		Map<String, Object> map =new HashMap<>();
		Criteria criteria = new Criteria("HOSPITAL_CODE", outDoctor.getHospitalCode());
		criteria.add("DEPT_SN", outDoctor.getDeptSn());
		criteria.add("DOCTOR_SN", outDoctor.getDoctorSn());
		criteria.add("IS_DELETE", "0");

		Map<String, String> linkMap = (Map<String, String>) request.getSession().getAttribute("outDoctorPic_fileMap");//附件
		String message = validateAttchement(linkMap, outDoctor.getId());
		if(ObjectUtil.isNotEmpty(message)) {
			return EHRMessageUtil.returnMsg(model, message);
		}

		OutDoctor outDoctorR = outDoctorService.getOutDoctor(criteria);
		if(ObjectUtil.isNullOrEmpty(outDoctor.getId()) && ObjectUtil.isNotEmpty(outDoctorR)) {
			return EHRMessageUtil.returnMsg(model, "exits");
		} else if(ObjectUtil.isNotEmpty(outDoctorR) && ObjectUtil.isNotEmpty(outDoctor.getId()) && !ObjectUtil.equals(outDoctor.getId(), outDoctorR.getId())) {
			return EHRMessageUtil.returnMsg(model, "exits");
		}
		outDoctor.setPyCode(CommonUtil.getPinYin(outDoctor.getName()));
		outDoctorService.updateOutDoctor(outDoctor, linkMap, getCurrentUser(request).getUserCode());
		// 保存成功清理session
		if(ObjectUtil.isNotEmpty(linkMap)) {
			request.getSession().removeAttribute("outDoctorPic_fileMap");
		}

		return EHRMessageUtil.returnMsg(model, "success");
	}

	/**
	 * 审核是否通过
	 * 
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/status")
	public String enable(HttpServletRequest request, ModelMap model, Long id, String status) {
		if(ObjectUtil.isNotEmpty(id)) {
			if(outDoctorService.updateOutDoctor(new Parameters("status", status), new Criteria("id", id)) > 0)
				return EHRMessageUtil.returnMsg(model, "1");
		}
		return EHRMessageUtil.returnMsg(model, "0");
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, ModelMap model, HttpServletResponse response, Long id) {
		if(ObjectUtil.isNullOrEmpty(id)) {
			EHRMessageUtil.returnMsg(model, null);
		}
		OutDoctor outDoctor = outDoctorService.getOutDoctor(new Criteria("id", id));
		//首先判断是否有排班资源 若是有则返回exits
		if(ifHaveSchedule(outDoctor)) {
			return EHRMessageUtil.returnMsg(model, "exits");
		}
		outDoctorService.updateOutDoctor(new Parameters("is_delete", "1"), new Criteria("id", id));
		createOperationLog(request, RhipModuleName.LHPORTAL,"出诊医生记录删除", OperationName.DELETE);
		return EHRMessageUtil.returnMsg(model, "success");
	}

	/**
	 * //首先判断是否有排班资源
	 * @param outDoctor
	 * @return
	 */
	private boolean ifHaveSchedule(OutDoctor outDoctor) {
		ScheduleSearchForm scheduleSearchForm = new ScheduleSearchForm();
		scheduleSearchForm.setDoctor(outDoctor.getDoctorSn());
		scheduleSearchForm.setHospital(outDoctor.getHospitalCode());
		scheduleSearchForm.setClinic(outDoctor.getDeptSn());
		Criteria criteria = scheduleSearchForm.getCriteria("RS","OC");
		//7天内全部有资源的数据
		Date requestDateBegin  = DateUtil.add(new Date(), Calendar.DAY_OF_MONTH,1);
		DateUtil.getCriteriaByDateRange(criteria, "RS.REQUEST_DATE", requestDateBegin, null);
		if(ObjectUtil.isNotEmpty(registerScheduleService.getNoPageRegisterSchedule(criteria))) {
			return true;
		}
		return false;
	}

	private Date getRequestTimeBegin() {
		Date requestTimeBegin;
		Calendar cal = Calendar.getInstance();
		cal.get(Calendar.HOUR_OF_DAY);
		cal.get(Calendar.MINUTE);
		cal.get(Calendar.SECOND);
		cal.get(Calendar.MILLISECOND);
		requestTimeBegin = cal.getTime();
		return requestTimeBegin;
	}

	private Date getRequestTimeEnd(String startViewReserveHour, String startViewReserveMin) {
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
	/**
	 * 姓名名，身份证号，预约状态和性别的查询条件
	 * @return
	 */
	private Criteria initSearch(OutDoctor outDoctor) {
		Criteria criteria = new Criteria();
		if(ObjectUtil.isNullOrEmpty(outDoctor)) {
			return criteria;
		}
		if(ObjectUtil.isNotEmpty(outDoctor.getName())) {
			criteria.add("name", OP.LIKE, outDoctor.getName());
		}

		if(ObjectUtil.isNotEmpty(outDoctor.getHospitalCode())) {
			criteria.add("hospitalCode", outDoctor.getHospitalCode());
		}

		if(ObjectUtil.isNotEmpty(outDoctor.getDeptName())) {
			criteria.add("deptName", OP.LIKE, outDoctor.getDeptName());
		}

		if(ObjectUtil.isNotEmpty(outDoctor.getIsHot())) {
			criteria.add("is_hot", OP.LIKE, outDoctor.getIsHot());
		}

		if(ObjectUtil.isNotEmpty(outDoctor.getStatus())) {
			criteria.add("status", OP.LIKE, outDoctor.getStatus());
		}
		return criteria;
	}

	/**
	 * 根据用户登录角色 获取医院信息列表
	 * @param request
	 * @param model
	 */
	private void initHospitalList(HttpServletRequest request, ModelMap model) {
		/*当前机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();
		List<HospitalInfo> hospitalInfos = new ArrayList<HospitalInfo>();

		if (hasRole(RoleType.ADMIN, request)){
			hospitalInfos = hospitalInfoService.get(new Criteria("IS_DELETE", "0"));
		} else {
			hospitalInfos = hospitalInfoService.get(new Criteria("IS_DELETE", "0").add("HOSPITAL_NO", currentOrgCode));
		}

		model.addAttribute("hospitalInfos", hospitalInfos);
	}

	/**
	 * 验证附件数量
	 * @param fileMap
	 * @param resourceId
	 * @return
	 */
	protected String validateAttchement(Map<String, String> fileMap, Long resourceId) {
		String message = "";

		int count = 0;
		List<UploadInfoRecord> infoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", resourceId).add("FILE_RESOURCE", "outDoctorPic"));
		if (ObjectUtil.isNotEmpty(fileMap)) {
			count += fileMap.size();
		}
		if (ObjectUtil.isNotEmpty(infoRecords)) {
			count += infoRecords.size();
		}
		if (count > 1) {
			message = "out";
			return message;
		}
		return message;
	}
}
