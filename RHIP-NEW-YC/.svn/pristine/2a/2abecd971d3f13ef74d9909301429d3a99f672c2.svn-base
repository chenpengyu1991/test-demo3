package com.founder.rhip.ehr.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.ehr.entity.clinic.ObservationInfo;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.service.IHealthExaminationService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class PhysicalExamController extends BaseController {
	
	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;
	
	@Resource(name = "healthExaminationService")
	private IHealthExaminationService healthExaminationService;
	
    @RequestMapping("/physicalExam")
    public String searchIndex(ModelMap model) {
		model.addAttribute("currentBeginDate",DateUtil.firstDateOfMonth(new Date()));
		model.addAttribute("currentEndDate",new Date());
		model.addAttribute("flag","");//如果传递该参数，表示页面是从“综合查询-》体检数据综合查询”进入。不传表示“健康档案-》体检专项”
        return "rhip.ehr.healthExam.search";
    }
    
    /**
	 * 获取体检专项列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/physicalExam/list")
	public String getPhysiqueExaminationList(HttpServletRequest request, ModelMap model){
		Criteria examCriteria = new Criteria();
		this.createCriteria(examCriteria, request);
		PageList<HealthExamination> healthExaminationList = new PageList<HealthExamination>();
		String physicalExamType = request.getParameter("phyType");
		Order order = new Order("EXAMINATION_DATE desc NULLS LAST, ID ");
		if("31".equals(physicalExamType)){//老年人体检
			healthExaminationList = healthExaminationService.getHealthExams(buildPage(request), examCriteria, order);
		}else{//除老年人外其他体检
			healthExaminationList = healthExaminationService.getHealthExamList(buildPage(request), examCriteria, order);
		}

		if(ObjectUtil.isNotEmpty(healthExaminationList)){
			model.addAttribute("healthExaminationList", healthExaminationList.getList());
		}
        model.addAttribute("flag", 1);//1体检专项查询
        return "rhip.ehr.healthExam.list";
	}
	
	/**
	 * 获取体检专项列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/physicalExam/analyze/list")
	public String getList(HttpServletRequest request, ModelMap model){
		Criteria examCriteria = new Criteria();
		this.createAnalyzeCriteria(examCriteria, request);
		
		PageList<HealthExamination> healthExaminationList = new PageList<HealthExamination>();
		//String physicalExamType = request.getParameter("phyType");
		Order order = new Order("EXAMINATION_DATE DESC NULLS LAST,ID ");
		examCriteria.add("PHYSICAL_EXAM_TYPE",OP.UEMPTY,"");
		healthExaminationList = healthExaminationService.getAnalyzeHealthExams(buildPage(request), examCriteria, order);
//		if("31".equals(physicalExamType)){//老年人体检
//			healthExaminationList = healthExaminationService.getAnalyzeHealthExams(buildPage(request), examCriteria, order);
//		}else{//除老年人外其他体检
//			//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei
////			healthExaminationList = healthExaminationService.getHealthExamList(buildPage(request), examCriteria, order);
//			//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei
//			
//			//EHR_ID IN,作为条件,大于1000时不能使用,增加以下代码,20140811 modify by yejianfei	
//			examCriteria.add("PHYSICAL_EXAM_TYPE",OP.NE,EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());//
//			healthExaminationList = healthExaminationService.getAnalyzeHealthExaminations(buildPage(request), examCriteria, order);
//			//EHR_ID IN,作为条件,大于1000时不能使用,增加以下代码,20140811 modify by yejianfei	
//		}		
		if(ObjectUtil.isNotEmpty(healthExaminationList)){
			model.addAttribute("healthExaminationList", healthExaminationList.getList());
		}
        model.addAttribute("flag", 2);//2指标分析查询
        model.addAttribute("weight", request.getParameter("weight"));//2指标分析查询
        model.addAttribute("hepatitisB", request.getParameter("hepatitisB"));//2指标分析查询
        model.addAttribute("bloodfat", request.getParameter("bloodfat"));//2指标分析查询

        return "rhip.ehr.healthExam.list";
	}
	
	/**
	 * 获取体检专项详细
	 * @param model
	 * @return
	 */
	@RequestMapping("/physicalExam/index/{personId}/{ehrId}")
	public String index(@PathVariable("personId") Long personaId,@PathVariable("ehrId") String ehrId, Model model){
		Criteria criteria = new Criteria("personId", personaId).add("ehrId", ehrId);
		HealthExamination he = healthExaminationService.getHealthExam(criteria);
		model.addAttribute("healthExamination",he);
		
		List<ObservationInfo> observationInfos = healthExaminationService.getObservationInfos(criteria);
		model.addAttribute("observationInfos", observationInfos);
		
		List<Map<String,Object>> examEventMaps = healthExaminationService.getExamEvents(criteria);
		if(ObjectUtil.isNotEmpty(examEventMaps)){
			for (Map<String, Object> map : examEventMaps) {
				Criteria detailC = new Criteria("ehrId", ehrId).add("personId", personaId).add("EXAMINATION_NUMBER",map.get("EXAMINATION_NUMBER"));
				List<ExamineDetail> examDetails = healthExaminationService.getExamDetails(detailC);
				map.put("examDetails", examDetails);
			}
		}
		model.addAttribute("examEvents", examEventMaps);
		
		List<StudyEvent> studyEvents = healthExaminationService.getStudyEvents(criteria);
		model.addAttribute("studyEvents", studyEvents);

		return "rhip.ehr.healthExam.report";
	}
	
	@RequestMapping("/physicalExam/analyzeDialog")
	public String analyzeDialog(HttpServletRequest request,Model model){
		model.addAttribute("beginDate",request.getParameter("beginDate"));
		model.addAttribute("endDate",request.getParameter("endDate"));
		model.addAttribute("phyExamOrg",request.getParameter("phyExamOrg"));
		model.addAttribute("phyType",request.getParameter("phyType"));
		model.addAttribute("name",request.getParameter("name"));
		model.addAttribute("idcard",request.getParameter("idcard"));
		return "rhip.ehr.healthExam.analyzeDialog";
	}
	
	private void createCriteria(Criteria examCriteria, HttpServletRequest request){
		Date[] dates = DateUtil.getDateRange(request.getParameter("beginDate"), request.getParameter("endDate"));
		DateUtil.getCriteriaByDateRange(examCriteria, "EXAMINATION_DATE", dates[0], dates[1]);
		if(ObjectUtil.isNotEmpty(request.getParameter("name"))){
			examCriteria.add("NAME", OP.LIKE, request.getParameter("name"));
		}
		if(ObjectUtil.isNotEmpty(request.getParameter("phyType"))){
			examCriteria.add("PHYSICAL_EXAM_TYPE", request.getParameter("phyType"));
		}else {
			examCriteria.add("PHYSICAL_EXAM_TYPE", OP.UEMPTY, null);
		}
		if(ObjectUtil.isNotEmpty(request.getParameter("phyExamOrg"))){
			examCriteria.add("hospitalCode", request.getParameter("phyExamOrg"));
		}
		if(ObjectUtil.isNotEmpty(request.getParameter("idcard"))){
			PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("idcard", request.getParameter("idcard")));
			if(ObjectUtil.isNotEmpty(personInfo)){
				examCriteria.add("PERSON_ID", personInfo.getId());
			}else {
				examCriteria.add("PERSON_ID", EHRConstants.NO_RESULT);
			}
		}
		//删除标志,add by yejianfei 20140801 ,IS_DELETE<>1
		Criteria deleteCriteria = new Criteria("IS_DELETE",OP.NE,EHRConstants.DELETE_FLG_1);
		deleteCriteria.add(LOP.OR,"IS_DELETE",OP.IS,"NULL");
		examCriteria.add(deleteCriteria);
		
	}
	
	private void createAnalyzeCriteria(Criteria examCriteria, HttpServletRequest request){
		String physicalExamType = request.getParameter("phyType");
		Date[] dates = DateUtil.getDateRange(request.getParameter("beginDate"), request.getParameter("endDate"));
		DateUtil.getCriteriaByDateRange(examCriteria, "EXAMINATION_DATE", dates[0], dates[1]);
		if(ObjectUtil.isNotEmpty(request.getParameter("name"))){
			examCriteria.add("NAME", OP.LIKE, request.getParameter("name"));
		}
		if(ObjectUtil.isNotEmpty(physicalExamType)){
			if(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode().equals(physicalExamType)){
				examCriteria.add("exam_status",1);
			}
			examCriteria.add("PHYSICAL_EXAM_TYPE",physicalExamType);
		}else {
			examCriteria.add("PHYSICAL_EXAM_TYPE", OP.UEMPTY, null);
		}
		if(ObjectUtil.isNotEmpty(request.getParameter("phyExamOrg"))){
			examCriteria.add("hospitalCode", request.getParameter("phyExamOrg"));
		}
		if(ObjectUtil.isNotEmpty(request.getParameter("idcard"))){
			PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("idcard", request.getParameter("idcard")));
			if(ObjectUtil.isNotEmpty(personInfo)){
				examCriteria.add("PERSON_ID", personInfo.getId());
			}else {
				examCriteria.add("PERSON_ID", EHRConstants.NO_RESULT);
			}
		}
		//删除标志,add by yejianfei 20140801 ,IS_DELETE<>1
		Criteria deleteCriteria = new Criteria("IS_DELETE",OP.NE,EHRConstants.DELETE_FLG_1);
		deleteCriteria.add(LOP.OR,"IS_DELETE",OP.IS,"NULL");
		examCriteria.add(deleteCriteria);
		
		//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei
//		List<String> ehrIds = new ArrayList<String>();
//		List<ObservationInfo> observationInfos = null;
		//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei
		
		
		//EHR_ID IN,作为条件,大于1000时不能使用,增加以下代码,20140811 modify by yejianfei	
		String weigth = request.getParameter("weight");
		if(StringUtil.isNotEmpty(weigth)){
			//observationInfoDao.getPersonAndEhrList(type)
			examCriteria.add("he_weigth",weigth);
		}
		String hepatitisB = request.getParameter("hepatitisB");
		if(StringUtil.isNotEmpty(hepatitisB)){
			//examineDetailDao.getList(criteria)
			examCriteria.add("he_hepatitisB",hepatitisB);
		}		
		//EHR_ID IN,作为条件,大于1000时不能使用,增加以下代码,20140811 modify by yejianfei	
		
		//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei		
//		if(("1").equals(request.getParameter("weight"))){
//			observationInfos = healthExaminationService.getPersonIdAndEhrId(1);
//		}
//		if(("2").equals(request.getParameter("weight"))){
//			observationInfos = healthExaminationService.getPersonIdAndEhrId(2);
//		}
//		if(ObjectUtil.isNotEmpty(observationInfos)){
//			for (ObservationInfo observationInfo : observationInfos) {
//				ehrIds.add(observationInfo.getEhrId());
//			}
//		}
		//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei		
		
//		if(ObjectUtil.isNotEmpty(request.getParameter("cigarate"))){
//			examCriteria.add("T1.SMODE_STATUS_CODE", OP.NE, 4);
//		}
//		if(ObjectUtil.isNotEmpty(request.getParameter("drink"))){
//			examCriteria.add("T1.DRINK_FREQUENCY", OP.NE, 4);
//		}

		//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei	
//		if(ObjectUtil.isNotEmpty(request.getParameter("hepatitisB"))){
//			Criteria criteria = new Criteria("INSPECTION_ITEM_CODE", "5446").add("INSPECTION_RESULT", 1);
//			List<ExamineDetail> getExamDetails = healthExaminationService.getExamDetails(criteria);
//			if(ObjectUtil.isNotEmpty(getExamDetails)){
//				for (ExamineDetail examineDetail : getExamDetails) {
//					ehrIds.add(examineDetail.getEhrId());
//				}
//			}
//		}
		//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei
		
//		if(ObjectUtil.isNotEmpty(request.getParameter("bloodfat"))){
//			Criteria criteria = new Criteria("INSPECTION_ITEM_CODE", "x001").add("INSPECTION_RESULT", 1);
//			List<ExamineDetail> getExamDetails = healthExaminationService.getExamDetails(criteria);
//		}
		
		//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei		
//		examCriteria.add("ehrId", OP.IN, ehrIds);
		//EHR_ID IN,作为条件,大于1000时不能使用,删除以下代码,20140811 modify by yejianfei
	}

}