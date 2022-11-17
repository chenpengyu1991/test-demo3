package com.founder.rhip.ihm.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.entity.clinic.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.ExamReportDTO;
import com.founder.rhip.ehr.dto.OutpatientReportDTO;
import com.founder.rhip.ehr.dto.StudyReportDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.IExamService;
import com.founder.rhip.ehr.service.IHealthEventService;
import com.founder.rhip.ehr.service.IInpatientDataService;
import com.founder.rhip.ehr.service.IInpatientMedicalRecordService;
import com.founder.rhip.ehr.service.IOuthospitalSummaryService;
import com.founder.rhip.ehr.service.IOutpatientService;
import com.founder.rhip.ehr.service.IStudyService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ihm.controller.form.EmrMedicalTargetQueryForm;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

/**
 * 电子病历
 * @author chen_tao
 *
 */
@Controller
@RequestMapping("/ihm/emr/")
public class EmrMedicaTargetController extends IHMBaseController {

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;
	
	@Resource(name = "outpatientService")
	private IOutpatientService outpatientService;
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@Resource(name = "healthEventService")
	private IHealthEventService healthEventService;
	
	@Resource(name = "inpatientDataService")
	private IInpatientDataService inpatientDataService;
	
	@Resource(name = "outhospitalSummaryService")
	private IOuthospitalSummaryService  outhospitalSummaryService;
	
	@Resource(name = "inpatientMedicalRecordService")
	private IInpatientMedicalRecordService  inpatientMedicalRecordService;
	
	@Resource(name = "studyService")
	private IStudyService studyService;
	
	@Resource(name = "examService")
	private IExamService examService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		return "ihm.emr.index";
	}
	
	@RequestMapping("/prescription")
	public String prescription(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy");
		model.addAttribute("isOutpatient", "1"); //是否门诊1是0不是
		model.addAttribute("listpage", "prescriptionList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/emr/prescriptionlist"); //查询请求路径
		model.addAttribute("type", "prescription"); //用来判断显示页面导航文字
		return "ihm.emr.prescription";
	}

	/**
	 * 处方查询
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/prescriptionlist")
	public String prescriptionlist(HttpServletRequest request,
			EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage); 
		
		//查门诊登记信息
        Order order = new Order("GATHER_DATE", false);
        Criteria ca = buildCriteria(form, "hospitalCode", "prescribeDate", "pre.name");
        ca.add("personId",OP.UEMPTY,"");
        ca.add("outpatientNo",OP.UEMPTY,"");
        PageList<OutpatientPrescription> outpatientInfoPageList = outpatientService.getOutpatientPrescriptionList(page, ca, order);

		model.addAttribute("outpatientInfoList", outpatientInfoPageList.getList());
		model.addAttribute("page", outpatientInfoPageList.getPage());
		
		return "ihm.emr.prescriptionlist";
	}
	
	private <T> Object[] Convert2Array(List<T> list, String fieldName){
		Object[] ta = new Object[list.size()];
		if(CollectionUtils.isEmpty(list)) return ta;
		Method method;
		try {
			method = list.get(0).getClass().getDeclaredMethod("get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
			for(int i = 0; i < list.size(); i++){
				if(ObjectUtil.isNotEmpty(method.invoke(list.get(i)))) {
					ta[i] = method.invoke(list.get(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ta;
	}
	
	/**
	 * 查看处方
	 * @param request
	 * @param model
	 * @param ehrId
	 * @param personId
	 * @return
	 */
	@RequestMapping("/prescriptionDetail")
	public String prescriptionDetail(HttpServletRequest request,Model model, String ehrId, Long personId, String recordNumber) {
		Criteria criteria = new Criteria();
		criteria.add("ehrId", ehrId);
		criteria.add("personId", personId);
        criteria.add("recordNumber",recordNumber);
		OutpatientReportDTO outpatientReport = outpatientService.getOutpatientDrugDetail(criteria);
		model.addAttribute("outpatientReportDTO", outpatientReport);
		return "rhip.ehr.outpatient.drugReport";
	}
	
	@RequestMapping("/inspect")
	public String inspect(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy");
		model.addAttribute("isOutpatient", "99"); //是否门诊1是0不是
		model.addAttribute("listpage", "inspectList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/emr/inspectlist"); //查询请求路径
		model.addAttribute("type", "inspect"); //用来判断显示页面导航文字
		return "ihm.emr.inspect";
	}
	
	@RequestMapping("/inspectlist")
	public String inspectlist(HttpServletRequest request,
			EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
        String idCard = form.getIdcard();
        PageList<StudyEvent> outpatientInfoPageList = new PageList<>();
        if(StringUtil.isNullOrEmpty(idCard)){
            outpatientInfoPageList = studyService.getStudyEvents1(page, buildStudyCriteria(form), new Order("GATHER_DATE", false));
        }else {
            outpatientInfoPageList = studyService.getStudyEvents2(page, buildStudyCriteria(form), new Order("GATHER_DATE", false));
        }
		model.addAttribute("outpatientInfoList", outpatientInfoPageList.getList());
		model.addAttribute("page", outpatientInfoPageList.getPage());
		
		return "ihm.emr.inspectlist";
	}
	
	@RequestMapping("/inspectDetail")
	public String inspectDetail(HttpServletRequest request,Model model, String ehrId, Long personId, String id) {
		Criteria criteria = new Criteria();
//		criteria.add("ehrId", ehrId);
//		criteria.add("personId", personId);
		criteria.add("ID", id);
		StudyReportDTO studyReportDTO = studyService.getStudyReport(criteria);
		request.setAttribute("studyReportDTO", studyReportDTO);
		return "rhip.ehr.study.report";
	}
	
	@RequestMapping("/exam")
	public String exam(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy");
		model.addAttribute("isOutpatient", "99"); //是否门诊1是0不是
		model.addAttribute("listpage", "examList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/emr/examlist"); //查询请求路径
		model.addAttribute("type", "exam"); //用来判断显示页面导航文字
		return "ihm.emr.exam";
	}
	
	@RequestMapping("/examlist")
	public String examlist(HttpServletRequest request,
			EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
        PageList<ExamineEvent> outpatientInfoPageList = new PageList<>();
        if(StringUtil.isNullOrEmpty(form.getIdcard())){
            Order order = new Order("GATHER_DATE", false);
            outpatientInfoPageList = examService.getExamEventListWithIdcard1(page, buildExam1Criteria(form), order);
        }else{
            outpatientInfoPageList = examService.getExamEventListWithIdcard2(page, buildStudyCriteria(form), new Order("GATHER_DATE",false));
        }
		model.addAttribute("outpatientInfoList", outpatientInfoPageList.getList());
		model.addAttribute("page", outpatientInfoPageList.getPage());
		
		return "ihm.emr.examlist";
	}
	
	@RequestMapping("/examDetail")
	public String examDetail(HttpServletRequest request,Model model, String ehrId, Long personId, String examinationNumber) {
		Criteria criteria = new Criteria();
		criteria.add("ehrId", ehrId);
		criteria.add("personId", personId);
		criteria.add("examinationNumber", examinationNumber);
		ExamReportDTO examReportDTO = examService.getExamReport(criteria);
		request.setAttribute("examReport", examReportDTO);
		return "rhip.ehr.exam.report";
	}
	
	@RequestMapping("/beHospital")
	public String beHospital(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy");
		model.addAttribute("isOutpatient", "0"); //是否门诊1是0不是
		model.addAttribute("listpage", "beHospitalList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/emr/beHospitallist"); //查询请求路径
		model.addAttribute("type", "beHospital"); //用来判断显示页面导航文字
		return "ihm.emr.beHospital";
	}

	/**
	 * 入院记录
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/beHospitallist")
	public String beHospitallist(HttpServletRequest request,
			EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));

        Order order = new Order("ID", false);
        Page page = super.getPage(request, currentPage);
		PageList<InpatientInfo> inpatientInfoPageList = inpatientDataService.getInpatientPageList(page, buildCriteria(form, "pre.REFERRAL_HOSPITAL_CODE", "pre.INHOS_DATE","pre.NAME"), order);
		
		model.addAttribute("inpatientInfoList", inpatientInfoPageList.getList());
		model.addAttribute("page", inpatientInfoPageList.getPage());
		return "ihm.emr.beHospitallist";
	}
	
	/**
	 * 查看入院记录
	 * @param request
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("/beHospitalDetail")
	public String beHospitalDetail(HttpServletRequest request,Model model, Long id) {
		Criteria criteria = new Criteria();
		criteria.add("id", id);
		InpatientInfo info = inpatientDataService.getInpatientInfo(criteria);
		model.addAttribute("inpatientInfo", info);
		return "ihm.emr.beHospitalDetail";
	}
	
	/**
	 * 
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/leaveHospital")
	public String leaveHospital(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy");
		model.addAttribute("isOutpatient", "0"); //是否门诊1是0不是
		model.addAttribute("listpage", "leaveHospitalList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/emr/leaveHospitallist"); //查询请求路径
		model.addAttribute("type", "leaveHospital"); //用来判断显示页面导航文字
		return "ihm.emr.leaveHospital";
	}

	/**
	 * 出院小结列表
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/leaveHospitallist")
	public String leaveHospitallist(HttpServletRequest request,
			EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		
		Criteria criteria = this.buildCriteria(form, "hospitalCode", "outhosDate", "name");
		criteria.add("admissionNo", OP.IS, "NOT NULL");
		
		//出院小结列表
        Order order = new Order("ID", false);
        PageList<OuthospitalSummary> plist = outhospitalSummaryService.getOuthospitalSummarys(criteria, page, order);
		//用于页面显示用列表
		List<OuthospitalSummary> temp = null;
		if(!CollectionUtils.isEmpty(plist.getList())){ 
			
			temp = new ArrayList<OuthospitalSummary>();
			//查询对应人员信息
			
			System.out.println(Convert2Array(plist.getList(),"personId"));
			
			Object[] list1= Convert2Array(plist.getList(),"personId");
			List<String> list2= new ArrayList<String>();
			for (int i = 0; i < list1.length; i++) {
				if(ObjectUtil.isNotEmpty(list1[i])) {
					list2.add(list1[i].toString());
				}
			}
			
			List<PersonInfo> personInfoList = personalRecordService.getPersonRecordList(new Criteria().add("id", OP.IN, list2));
			for(OuthospitalSummary inp: plist.getList())
			{
				String idcard = null;
				for(PersonInfo person: personInfoList)
				{
					if(ObjectUtil.isNotEmpty(inp.getPersonId()) && ObjectUtil.isNotEmpty(person.getId()) && inp.getPersonId().equals(person.getId()))
					{
						idcard = person.getIdcard();
						break;
					}
				}
				
				//暂时将idcard的值设置在age中，在页面显示，对后台无影响
				if(idcard != null)
				{
					inp.setAge(idcard);
				}else
				{
					inp.setAge("");
				}
				
				temp.add(inp);
			}
		}else
		{
			temp = plist.getList();
		}
		
		model.addAttribute("healthlist", temp);
		model.addAttribute("page", plist.getPage());
		return "ihm.emr.leaveHospitallist";
	}
	
	@RequestMapping("/case")
	public String casing(HttpServletRequest request, EmrMedicalTargetQueryForm form,
			Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy");
		model.addAttribute("isOutpatient", "0"); //是否门诊1是0不是
		model.addAttribute("listpage", "caseList.jsp"); //查询结果列表页面
		model.addAttribute("queryPath", "/ihm/emr/caselist"); //查询请求路径
		model.addAttribute("type", "case"); //用来判断显示页面导航文字
		return "ihm.emr.case";
	}

	/**
	 * 病案首页列表
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/caselist")
	public String caselist(HttpServletRequest request,
			EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage); 
		Criteria criteria = this.buildCriteria(form, "hospitalCode", "outHospitalDate","name");
		criteria.add("admissionNo", OP.IS, "NOT NULL");
		
		//查询病案首页列表
        Order order = new Order("ID", false);
        PageList<InpatientMedicalRecord> plist = inpatientMedicalRecordService.getInpatientMedicalRecords(criteria, page, order);
		//用于页面显示用列表
		List<InpatientMedicalRecord> temp = null;
		if(!CollectionUtils.isEmpty(plist.getList())){ 
			temp = new ArrayList<InpatientMedicalRecord>();
			//查询对应人员信息
            //去除personId为空的参数
            List personIds = new ArrayList();
            Object[] personIdArray = Convert2Array(plist.getList(),"personId");
            for(Object personId : personIdArray){
                if(ObjectUtil.isNotEmpty(personId)){
                    personIds.add(personId);
                }
            }
			List<PersonInfo> personInfoList = personalRecordService.getPersonRecordList(new Criteria().add("id", OP.IN, personIds));
			for(InpatientMedicalRecord inp: plist.getList())
			{
				String idcard = null;
				for(PersonInfo person: personInfoList)
				{
					if(ObjectUtil.isNotEmpty(inp.getPersonId()) && inp.getPersonId().equals(person.getId()))
					{
						idcard = person.getIdcard();
						break;
					}
				}
				
				//暂时将idcard的值设置在age中，在页面显示，对后台无影响
				if(idcard != null)
				{
					inp.setAge(idcard);
				}else
				{
					inp.setAge("");
				}
				
				temp.add(inp);
			}
		}else
		{
			temp = plist.getList();
		}
		
		model.addAttribute("healthlist", temp);
		model.addAttribute("page", plist.getPage());
		return "ihm.emr.caselist";
	}

	@RequestMapping("/outpatient")
	public String outpatient(HttpServletRequest request, EmrMedicalTargetQueryForm form,
							 Model model) {
		Page page = new Page(0,0);
		model.addAttribute("defaultDateB", DateUtil.getBeforeDay(new Date(),2));
		model.addAttribute("defaultDateE", new Date());
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		model.addAttribute("pattern", "yyyy/MM/dd");
		model.addAttribute("isOutpatient", "1");
		model.addAttribute("listpage", "outpatientList.jsp");
		model.addAttribute("queryPath", "/ihm/emr/outpatientList");
		return "ihm.emr.outpatient";
	}

	@RequestMapping("/outpatientList")
	public String outpatientList(HttpServletRequest request,
								 EmrMedicalTargetQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		PageList<OutpatientInfo> outpatientInfoPageList = new PageList<>();
		if(StringUtil.isEmpty(form.getIdcard()) ){
			Order order = new Order("CLINIC_DATE", false);
			outpatientInfoPageList = outpatientService.getOutpatientInfoWithIdCard1(page, buildOutPatientCriteria(form), order);
		}else{
			Order order = new Order("CLINIC_DATE", false);
			outpatientInfoPageList = outpatientService.getOutpatientInfoWithIdCard(page, buildOutPatientCriteria(form), order);
		}
		model.addAttribute("outpatientInfoList", outpatientInfoPageList.getList());
		model.addAttribute("page", outpatientInfoPageList.getPage());

		return "ihm.emr.outpatientList";
	}

	/**
	 * 组装查询条件
	 * @param form
	 * @param orgCodeFieldName 机构域名
	 * @param dateFieldName 时间域名
	 * @param nameFieldName 姓名域名
	 * @return
	 */
	private Criteria buildCriteria(EmrMedicalTargetQueryForm form, 
			String orgCodeFieldName, String dateFieldName,
			String nameFieldName){
		Criteria criteria = new Criteria();
		Criteria criteriaTemp = null;
		//机构
//		if("4".equals(form.getOrgType())) //按镇
//		{
//			if(StringUtil.isNotEmpty(form.getGbCode()))
//			{
//				criteriaTemp = new Criteria().add("gbCode", form.getGbCode());
//			}else
//			{
//				criteriaTemp = new Criteria().add("gbCode",OP.IS, "NOT NULL");
//			}
//		}else if("1".equals(form.getOrgType())) //按市级医院
//		{
//			if(StringUtil.isEmpty(form.getHospitalCode()))
//			{
//				criteriaTemp = new Criteria().add("genre_code", "A1");
//			}else
//			{
//				criteria.add(orgCodeFieldName, form.getHospitalCode());
//			}
//			
//		}else if("2".equals(form.getOrgType()) ) //按卫生院
//		{
//			if(StringUtil.isNotEmpty(form.getSuperOrganCode()))
//			{
//				//如果选择的是镇
//				if("0".equals(form.getGenreCode()))
//				{
//					criteriaTemp = new Criteria().add("gbCode", form.getSuperOrganCode()).add("genreCode", "B1");
//				}else
//				{
//					criteria.add(orgCodeFieldName, form.getSuperOrganCode());
//				}
//			}else
//			{
//				criteriaTemp = new Criteria().add("genreCode", "B1");
//			}
//			
//		}else if("3".equals(form.getOrgType())) //按社区卫服务站
//		{
//			if(StringUtil.isNotEmpty(form.getOrganCode()))
//			{
//				if("0".equals(form.getGenreCode())) //如果选择的是镇
//				{
//					criteriaTemp = new Criteria().add("gbCode", form.getOrganCode()).add("genreCode", "B2");
//				}else if("B1".equals(form.getGenreCode())) //如果选择的是卫生服务中心
//				{ 
//					criteriaTemp = new Criteria().add("parentCode", form.getOrganCode()).add("genreCode", "B2");
//				}
//				else
//				{
//					criteria.add(orgCodeFieldName, form.getOrganCode());
//				}
//			}else
//			{
//				criteriaTemp = new Criteria().add("genreCode", "B2");
//			}
			
//		}
		
		if(StringUtil.isNotEmpty(form.getOrganCode()))
		{
			if("0".equals(form.getGenreCode())) //如果选择的是镇,则查出该镇下所有服务中心和服务站的数据
			{
				criteriaTemp = new Criteria().add("gbCode", form.getOrganCode());
			}
			else //如果是中心或服务站，则查出对应的数据
			{
				criteria.add(orgCodeFieldName, form.getOrganCode());
			}
		}
		
		if(null != criteriaTemp)
		{
			List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);
			
			if(!CollectionUtils.isEmpty(orgs))
			{ 
				criteria.add(orgCodeFieldName, OP.IN, Convert2Array(orgs,"organCode"));
			}
		}
		//日期
		Date beginDate = null;
		Date endDate = null;
		if(StringUtil.isNotEmpty(form.getBeginDate())){
            beginDate = DateUtil.parseDateString(form.getBeginDate());
		}
		if(StringUtil.isNotEmpty(form.getEndDate())){
            endDate = DateUtil.parseDateString(form.getEndDate());
		}
		DateUtil.getCriteriaByDateRange(criteria, dateFieldName, beginDate, endDate);
		//姓名
		if(StringUtil.isNotEmpty(form.getName())){
			criteria.add(nameFieldName, OP.LIKE, form.getName());
		}
		//门诊号
		if(StringUtil.isNotEmpty(form.getOutpatientNo())){
			criteria.add("outpatientNo", form.getOutpatientNo());
		}
		//住院号
		if(StringUtil.isNotEmpty(form.getAdmissionNo())){
			criteria.add("ADMISSION_NO", form.getAdmissionNo());
		}
		//身份证
		if(StringUtil.isNotEmpty(form.getIdcard())){
			Criteria criteria2 = new Criteria();
			criteria2.add("idcard", form.getIdcard());
	        List<PersonInfo> personInfoList = personalRecordService.getPersonRecordList(criteria2);
	        if(CollectionUtils.isEmpty(personInfoList)){
	        	criteria.add("personId", OP.IN, new String[]{"0"});
	        }else{
	        	criteria.add("personId", OP.IN, Convert2Array(personInfoList, "id"));
	        }
		}
		return criteria;
	}

    /**
     * 组装查询条件
     * @param form
     * @return
     */
    private Criteria buildStudyCriteria(EmrMedicalTargetQueryForm form){
        Criteria criteria = new Criteria();
        Criteria criteriaTemp = null;
        //机构
        if(StringUtil.isNotEmpty(form.getOrganCode()))
        {
            if("0".equals(form.getGenreCode())) //如果选择的是镇,则查出该镇下所有服务中心和服务站的数据
            {
                criteriaTemp = new Criteria().add("gbCode", form.getOrganCode());
            }
            else //如果是中心或服务站，则查出对应的数据
            {
                criteria.add("S.HOSPITAL_CODE", form.getOrganCode());
            }
        }

        if(null != criteriaTemp)
        {
            List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);

            if(!CollectionUtils.isEmpty(orgs))
            {
                criteria.add("S.HOSPITAL_CODE", OP.IN, Convert2Array(orgs,"organCode"));
            }
        }
        //日期
        Date beginDate = null;
        Date endDate = null;
        if(StringUtil.isNotEmpty(form.getBeginDate())){
            /*Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.valueOf(form.getBeginDate()), 0, 1, 0, 0, 0);
            beginDate = calendar.getTime();*/
			beginDate = DateUtil.parseSimpleDate(form.getBeginDate(),null);
        }
        if(StringUtil.isNotEmpty(form.getEndDate())){
            /*Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.valueOf(form.getEndDate()), 11, 31, 23, 59, 59);
            endDate = calendar.getTime();*/
			endDate = DateUtil.parseSimpleDate(form.getEndDate(),null);
        }
        DateUtil.getCriteriaByDateRange(criteria, "S.CHECK_DATE", beginDate, endDate);
        //姓名
        if(StringUtil.isNotEmpty(form.getName())){
            criteria.add("S.NAME", OP.LIKE, form.getName());
        }
        //身份证
        if(StringUtil.isNotEmpty(form.getIdcard())){
            criteria.add("P.IDCARD", form.getIdcard());
        }
        return criteria;
    }

    /**
     * 组装查询条件
     * @param form
     * @return
     */
    private Criteria buildExam1Criteria(EmrMedicalTargetQueryForm form){
        Criteria criteria = new Criteria();
        Criteria criteriaTemp = null;
        //机构
        if(StringUtil.isNotEmpty(form.getOrganCode()))
        {
            if("0".equals(form.getGenreCode())) //如果选择的是镇,则查出该镇下所有服务中心和服务站的数据
            {
                criteriaTemp = new Criteria().add("gbCode", form.getOrganCode());
            }
            else //如果是中心或服务站，则查出对应的数据
            {
                criteria.add("HOSPITAL_CODE", form.getOrganCode());
            }
        }

        if(null != criteriaTemp)
        {
            List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);

            if(!CollectionUtils.isEmpty(orgs))
            {
                criteria.add("HOSPITAL_CODE", OP.IN, Convert2Array(orgs,"organCode"));
            }
        }
        //日期
        Date beginDate = null;
        Date endDate = null;
        if(StringUtil.isNotEmpty(form.getBeginDate())){
            /*Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.valueOf(form.getBeginDate()), 0, 1, 0, 0, 0);
            beginDate = calendar.getTime();*/
			beginDate = DateUtil.parseSimpleDate(form.getBeginDate(),null);
        }
        if(StringUtil.isNotEmpty(form.getEndDate())){
            /*Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.valueOf(form.getEndDate()), 11, 31, 23, 59, 59);
            endDate = calendar.getTime();*/
			endDate = DateUtil.parseSimpleDate(form.getEndDate(),null);
        }
        DateUtil.getCriteriaByDateRange(criteria, "CHECK_DATE", beginDate, endDate);
        //姓名
        if(StringUtil.isNotEmpty(form.getName())){
            criteria.add("NAME", OP.LIKE, form.getName());
        }
        //身份证
        if(StringUtil.isNotEmpty(form.getIdcard())){
            criteria.add("IDCARD", form.getIdcard());
        }
        return criteria;
    }

	private Criteria buildOutPatientCriteria(EmrMedicalTargetQueryForm form){
		Criteria criteria = new Criteria();
		//机构
		if(StringUtil.isNotEmpty(form.getOrganCode()))
		{
			criteria.add("CLINIC_ORGAN_CODE", form.getOrganCode());
		}
		Date beginDate = null;
		Date endDate = null;
		if(StringUtil.isNotEmpty(form.getBeginDate()) && form.getBeginDate().length() == 4){
			Calendar calendar = Calendar.getInstance();
			calendar.set(Integer.valueOf(form.getBeginDate()), 0, 1, 0, 0, 0);
			beginDate = calendar.getTime();
		}else {
			beginDate = DateUtil.convert("yyyy/MM/dd", form.getBeginDate());
		}
		if(StringUtil.isNotEmpty(form.getEndDate()) && form.getEndDate().length() == 4){
			Calendar calendar = Calendar.getInstance();
			calendar.set(Integer.valueOf(form.getEndDate()), 11, 31, 23, 59, 59);
			endDate = calendar.getTime();
		}else {
			endDate = DateUtil.convert("yyyy/MM/dd", form.getEndDate());
		}
		DateUtil.getCriteriaByDateRange(criteria, "CLINIC_DATE", beginDate, endDate);

		if(StringUtil.isNotEmpty(form.getIdcard())){
			criteria.add("IDCARD", form.getIdcard());
		}
		if(StringUtil.isNotEmpty(form.getName())){
			criteria.add("CLINIC_PEOPLE_NAME",form.getName());
		}
		if(StringUtil.isNotEmpty(form.getOutpatientNo())){
			criteria.add("OUTPATIENT_NO",form.getOutpatientNo());
		}
		return criteria;
	}
}