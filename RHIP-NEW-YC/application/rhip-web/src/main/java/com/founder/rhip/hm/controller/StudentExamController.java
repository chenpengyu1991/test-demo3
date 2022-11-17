package com.founder.rhip.hm.controller;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.dto.StudentExamReportDTO;
import com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentExam;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentInfo;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.hm.controller.form.StudentExamQueryForm;
import com.founder.rhip.hm.service.IClassInfoService;
import com.founder.rhip.hm.service.IStudentExamService;
import com.founder.rhip.hm.service.IStudentInfoService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.SchoolInfo;
import com.founder.rhip.mdm.service.ISchoolInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.*;

@Controller
@RequestMapping(value = "/hm/studentExam")
public class StudentExamController extends BaseController {

	@Resource
	private ISchoolInfoService schoolInfoService;

	@Resource
	private IClassInfoService classInfoService;

	@Resource
	private IStudentInfoService studentInfoService;

	@Resource
	private IStudentExamService studentExamService;
	
	@Resource
	private IDictionaryApp dictionaryApp;
	
	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;

	@RequestMapping("/search")
	public String search(ModelMap model) {
		List<SchoolInfo> schools = schoolInfoService.getSchools(null);
		model.addAttribute("schools", schools);
		return "com.founder.rhip.hm.studentExam.search";
	}
	
	@RequestMapping("/reportSearch")
	public String reportSearch(HttpServletRequest request, ModelMap model) {
		List<SchoolInfo> schools = getDefaultSchool(request);
		model.addAttribute("schools", schools);
		List<DicItem> areaTypes = dictionaryApp.queryDicItem("FS10256");
		model.addAttribute("areaTypes", areaTypes);
		List<DicItem> types = dictionaryApp.queryDicItem("FS10255");
		model.addAttribute("types", types);
		List<DicItem> gradeCodes = dictionaryApp.queryDicItem("FS10258");
		model.addAttribute("gradeCodes", gradeCodes);
		model.addAttribute("examYear", DateUtil.getCurrentWithoutTime());
		return "com.founder.rhip.hm.studentExam.reportSearch";
	}

	@RequestMapping("/queryGradeList")
	@ResponseBody
	public ModelMap queryGradeList(HttpServletRequest request, String itemCodes) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, "FS10258");
		if(ObjectUtil.isNotEmpty(itemCodes)){
			criteria.add("itemCode",OP.IN,itemCodes.split(","));
		}
		List<DicItem> gradeCodes = dictionaryApp.queryDicItem(criteria);
		ModelMap model = new ModelMap();
		model.addAttribute("success", true);
		model.addAttribute("gradeCodes", gradeCodes);
		return model;
	}
	
	@RequestMapping("/querySchoolList")
	@ResponseBody
	public ModelMap querySchoolList(HttpServletRequest request, String areaType, String type) {
		String[] araTypes = areaType.split(",");
		String[] types = type.split(",");
		Criteria criteria = getDefaultSchoolCriteria(request);
		if (StringUtil.isNotEmpty(areaType)) {
			criteria.add("areaType", OP.IN, araTypes);
		}
		if (StringUtil.isNotEmpty(type)) {
			criteria.add("type", OP.IN, types);
		}
		List<SchoolInfo> schools = schoolInfoService.getSchools(criteria);
		
		ModelMap model = new ModelMap();
		model.addAttribute("success", true);
		model.addAttribute("schools", schools);
		return model;
	}
	
	@RequestMapping("/report")
	public String report(ModelMap model, HttpServletRequest request,String examYear, String schoolCode, String gradeCode) {
		StudentExamReportDTO.ReportDataList reportData = new StudentExamReportDTO.ReportDataList();
//        需求变更修改，可以不选择学校统计，2014-03-05
		if (StringUtil.isNotEmpty(schoolCode) && StringUtil.isNullOrEmpty(gradeCode)) {
		    String[] schoolCodes = schoolCode.split(",");
			reportData = studentExamService.report(examYear, schoolCodes, null,false);
		}
		//如果不选学校，中心也只能查看中心所管辖的学校的数据
        if (StringUtil.isNullOrEmpty(schoolCode)) {
        	String[] schoolCodes = 	(String[])getDefaultSchoolCodes(request).toArray(new String[0]);
        	if(ObjectUtil.isNullOrEmpty(schoolCodes)){
        		schoolCodes = new String[]{""};
        	}
            String[] gradeCodes =  StringUtil.isNotEmpty(gradeCode)?gradeCode.split(","):null;
            //是否合并数据：如果没有选择学校，且选择了年级，则一个年级显示一列（男、女、合计）
            boolean mergeFlag = StringUtil.isNotEmpty(gradeCode);
            reportData = studentExamService.report(examYear, schoolCodes, gradeCodes,mergeFlag);
        }
        if (StringUtil.isNotEmpty(schoolCode) && StringUtil.isNotEmpty(gradeCode)) {
            String[] schoolCodes = schoolCode.split(",");
            String[] gradeCodes = gradeCode.split(",");
            reportData = studentExamService.report(examYear, schoolCodes, gradeCodes,false);
        }
        model.addAttribute("examYear", examYear);
		model.addAttribute("reportData", reportData);
		return "com.founder.rhip.hm.studentExam.report";
	}
	
	@RequestMapping("/list")
	public String list(ModelMap model, HttpServletRequest request, StudentExamQueryForm form, int indexPage) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = form.toCriteria();
		if (!criteria.contains("schoolCode") && !criteria.contains("type")) {
			criteria.add("schoolCode", OP.IN, getDefaultSchoolCodes(request));
		}
		//如果选择了学校类型，没有选择具体的学校
		if (!criteria.contains("schoolCode") && criteria.contains("type")) {
			String type = criteria.get("type").toString();
			criteria.add("schoolCode", OP.IN, getSchoolCodesByType(request,type));
		}		
		criteria.remove("type");		
		PageList<StudentExam> pageList = studentExamService.getExamPageList(page, criteria);
		model.addAttribute("studentExams", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.rhip.hm.studentExam.list";
	}
	
	@RequestMapping("/studentSearch")
	public String studentSearch(ModelMap model) {
		List<SchoolInfo> schools = schoolInfoService.getSchools(null);
		model.addAttribute("schools", schools);
		model.addAttribute("currentYear",new Date());
		return "com.founder.rhip.hm.studentExam.studentSearch";
	}
	
	@RequestMapping("/studentList")
	public String studentList(ModelMap model, HttpServletRequest request, StudentExamQueryForm form, int indexPage) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = form.toCriteria();
		if (!criteria.contains("schoolCode")) {
			criteria.add("schoolCode", OP.IN, getDefaultSchoolCodes(request));
		}
		PageList<StudentExam> pageList = studentExamService.getExamStudentPageList(page, criteria);
		model.addAttribute("studentExams", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.rhip.hm.studentExam.studentList";
	}
	
	@RequestMapping("/deleteStudentInfo")
	@ResponseBody
	public ModelMap deleteStudentInfo(HttpServletRequest request, Long studentId) {
		ModelMap model = new ModelMap();
		try {
            createOperationLog(request, RhipModuleName.HM_STUDENT, "体检信息", OperationName.DELETE);
			studentInfoService.deleteStudent(studentId);
			model.addAttribute("success", true);
			model.addAttribute("message", "删除成功");
		} catch (Exception e) {
			logger.error("删除学校出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/progress/search")
	public String progressSearch(ModelMap model) {
		return "com.founder.rhip.hm.studentExam.progressSearch";
	}
	
	@RequestMapping("/progress/list")
	public String progressList(ModelMap model, HttpServletRequest request, StudentExamQueryForm form, int indexPage) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = form.getProgressCriteria();
		if (!criteria.contains("schoolCode") && !criteria.contains("type")) {
			criteria.add("schoolCode", OP.IN, getDefaultSchoolCodes(request));
			criteria.add("S.SCHOOL_CODE", OP.IN, getDefaultSchoolCodes(request));
		}
		//如果选择了学校类型，没有选择具体的学校
		if (!criteria.contains("schoolCode") && criteria.contains("type")) {
			String type = criteria.get("type").toString();
			criteria.add("schoolCode", OP.IN, getSchoolCodesByType(request,type));
			criteria.add("S.SCHOOL_CODE", OP.IN, getSchoolCodesByType(request,type));
		}		
		criteria.remove("type");		
		PageList<Map<String, Object>> pageList = studentExamService.getProgressList(page, criteria);
		model.addAttribute("progresslist", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		return "com.founder.rhip.hm.studentExam.progressList";
	}
	/**
	 * 根据学校类型获取学校列表
	 * @param type：学校类型
	 * @param schoolCode:学校编码
	 * @param response
	 * @param request
	 */
	 @RequestMapping("/schoollist")
	 public void getVillageJson(String type,String schoolCode, HttpServletResponse response, HttpServletRequest request){
		 Organization org = getCurrentOrg(request);
		 Criteria criteria = new Criteria("TYPE",type);
		if (!"46714114-9".equals(org.getOrganCode())) {
			criteria.add("examOrgan", org.getOrganCode());
		}		 
		 List<SchoolInfo> list = schoolInfoService.getSchools(criteria);
		 StringBuffer buffer = new StringBuffer();
		 if(StringUtils.isNotEmpty(schoolCode)) {
			 for(SchoolInfo info: list) {
				 if(StringUtils.equals(info.getSchoolCode(), schoolCode)) {
					 buffer.append("<option title=\""+ info.getName() + "\" value='"+ info.getSchoolCode() +  "' selected=\"selected\">" + info.getName() + "</option>");
				 } else {
					 buffer.append("<option title=\""+ info.getName() + "\" value='"+ info.getSchoolCode() +  "'>" + info.getName() + "</option>");
				 }
			 }
		 } else {
			 for(SchoolInfo info: list) {
				 buffer.append("<option title=\""+ info.getName() + "\" value='"+ info.getSchoolCode() +  "'>" + info.getName() + "</option>");
			 }
		 }
		 MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString():"empty", response);
	 }
	 
	private Criteria getDefaultSchoolCriteria(HttpServletRequest request) {
		Organization org = getCurrentOrg(request);
		String areaTypes = request.getParameter("areaTypeInput");//地区
		String types = request.getParameter("typeInput");//学校类型
		Criteria criteria = new Criteria();
		if (!"46714114-9".equals(org.getOrganCode())) {
			criteria = new Criteria("examOrgan", org.getOrganCode());
		}
		if (StringUtil.isNotEmpty(areaTypes)) {
			criteria.add("areaType", OP.IN, areaTypes.split(","));
		}
		if (StringUtil.isNotEmpty(types)) {
			criteria.add("type", OP.IN, types.split(","));
		}
		return criteria;
	}
	
	private List<SchoolInfo> getDefaultSchool(HttpServletRequest request) {
		Criteria criteria = getDefaultSchoolCriteria(request);
		List <SchoolInfo> list = schoolInfoService.getSchools(criteria);
		return list;
	}
	
	private List<String> getDefaultSchoolCodes(HttpServletRequest request) {
		List <SchoolInfo> list = getDefaultSchool(request);
		List<String> schoolCodes = new ArrayList<String>();
		if (list != null) {
			for (SchoolInfo info : list) {
				schoolCodes.add(info.getSchoolCode());
			}
		}
		return schoolCodes;
	}

	/**
	 * 按学校类型查询学校编码
	 *
	 * @param request
	 * @param type
	 * @return
	 * @author Ye jianfei
	 */
	private List<String> getSchoolCodesByType(HttpServletRequest request,String type) {
		Criteria criteria = new Criteria("type",type);
		criteria.addAll(getDefaultSchoolCriteria(request));
		List <SchoolInfo> list = schoolInfoService.getSchools(criteria);
		List<String> schoolCodes = new ArrayList<String>();
		if (list != null) {
			for (SchoolInfo info : list) {
				schoolCodes.add(info.getSchoolCode());
			}
		}
		return schoolCodes;
	}
	
	@RequestMapping("/downloadStudentTemplet")
	public void downloadStudentTemplet(HttpServletResponse response) throws Exception {
		ExcelUtils excel = new ExcelUtils(getExcelPath("../views/hm/template/studentInfoTemplet.xls"));
		setExcelContent(response, "学生信息导入模板.xls");
		excel.save(response.getOutputStream());
	}
	
	@RequestMapping("/studentImport")
	public String studentImport(ModelMap model) {
		return "com.founder.rhip.hm.studentExam.import";
	}

	@RequestMapping("/showImport")
	public String showImport(ModelMap model) {
		return "com.founder.rhip.hm.studentExam.schoolSearch";
	}
	
	@RequestMapping("/schoolList")
	public String schoolList(HttpServletRequest request,ModelMap model, SchoolInfo school, int indexPage) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = toCriteria(school);
		PageList<SchoolInfo> schoolList = schoolInfoService.getPageSchools(page, criteria);
		model.addAttribute("page", schoolList.getPage());
		model.addAttribute("schoolList", schoolList.getList());
		return "com.founder.rhip.hm.studentExam.schoolList";
	}
	
	@RequestMapping("/schoolInfoEdit")
	public String addSchool(ModelMap model, Long schoolId) {
		if (ObjectUtil.isNotEmpty(schoolId)) {
			SchoolInfo school = schoolInfoService.getSchool(schoolId);
			model.addAttribute("school", school);
		}
		return "com.founder.rhip.hm.studentExam.schoolInfoEdit";
	}
	
	@RequestMapping("/viewSchool")
	public String viewSchool(ModelMap model, Long schoolId) {
		SchoolInfo school = schoolInfoService.getSchool(schoolId);
		model.addAttribute("school", school);
		return "com.founder.rhip.hm.studentExam.schoolInfo";
	}
	
	@RequestMapping("/deleteSchool")
	@ResponseBody
	public ModelMap deleteSchool(HttpServletRequest request, Long schoolId) {
		ModelMap model = new ModelMap();
		try {
            createOperationLog(request, RhipModuleName.HM_STUDENT, "删除学校", OperationName.DELETE);
			schoolInfoService.deleteSchool(schoolId);
			model.addAttribute("success", true);
			model.addAttribute("message", "删除成功");
		} catch (Exception e) {
			logger.error("删除学校出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/saveSchool")
	@ResponseBody
	public ModelMap saveSchool(HttpServletRequest request, SchoolInfo school) {
		ModelMap model = new ModelMap();
		try {
			User user = getCurrentUser(request);
			initSchoolValue(school, user);
			Long schoolId = school.getSchoolId();
			if (ObjectUtil.isNullOrEmpty(schoolId)) {
				String schoolCode = school.getSchoolCode();
				Criteria cri = new Criteria("schoolCode", schoolCode);
				List<SchoolInfo> schools = schoolInfoService.getSchools(cri);
				if (schools != null && schools.size() > 0) {
					model.addAttribute("success", false);
					model.addAttribute("message", "相同编码的学校已经存在！");
					return model;
				}
			}
            createOperationLog(request, RhipModuleName.HM_STUDENT, "保存学校", ObjectUtil.isNullOrEmpty(schoolId)?OperationName.ADD:OperationName.UPDATE);
			schoolInfoService.saveSchool(school);
			model.addAttribute("success", true);
			model.addAttribute("message", "保存成功");
		} catch (Exception e) {
			logger.error("保存学校出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}

	@RequestMapping("/uploadStudent")
	@ResponseBody
	public ModelMap uploadStudent(HttpServletRequest request, @RequestParam("qqfile") MultipartFile file, String schoolCode, String schoolName, int actionType) {
		ModelMap model = new ModelMap();
		try {
            createOperationLog(request, RhipModuleName.HM_STUDENT, "导入学生", OperationName.IMP);
			List<StudentInfo> studentList = readStudentInfo(file.getInputStream());
			if (ObjectUtil.isNullOrEmpty(studentList)) {
				model.addAttribute("success", false);
				model.addAttribute("message", "导入学生数据为空");
				logger.error("StudentExam: 导入学生数据为空");
				return model;
			}
			List<String> msg = validateData(studentList);
			if (msg != null && msg.size()>0) {
				model.addAttribute("success", false);
				model.addAttribute("message", "导入学生数据失败，" + StringUtil.join(msg));
				return model;
			}
			
			User user = getCurrentUser(request);
			Organization organ = getCurrentOrg(request);
			initFullData(studentList, user, organ.getOrganCode(), schoolCode, schoolName);
			
			int count = studentInfoService.importStudents(studentList, actionType);
			model.addAttribute("success", true);
			model.addAttribute("message", "总共导入" + studentList.size() + "条学生数据，成功" + count + "条，失败" + (studentList.size() - count) + "条");
		} catch (Exception e) {
			logger.error("StudentExam: 导入学生数据出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", "无法导入，请检查导入文件模板和数据格式");
			return model;
		}
		return model;
	}

	@RequestMapping("/showGradeList")
	@ResponseBody
	public List<String> showGradeList(String schoolCode) {
		return classInfoService.getGradeList(schoolCode);
	}

	@RequestMapping("/showClassList")
	@ResponseBody
	public List<String> showClassList(String schoolCode, String gradeName) {
		return classInfoService.getClassList(schoolCode, gradeName);
	}

	@RequestMapping("/addExamReport")
	public String addExamReport(ModelMap model, StudentExam exam, String addFlag) {
		model.addAttribute("exam", exam);
		model.addAttribute("addFlag", addFlag);
		return "com.founder.rhip.hm.studentExam.editExamReport";
	}

	@RequestMapping("/addStudentExam")
	@ResponseBody
	public int addExamReport(StudentExam studentExam, ModelMap model, HttpServletRequest request) {
		int result = -1;
		Date now  = new Date();
		User user = getCurrentUser(request);
		Organization organization=getCurrentOrg(request);
		studentExam.setOperator(user.getUserName());
		studentExam.setOperateOrgan(organization.getOrganCode());
		studentExam.setOrganization(organization.getOrganName());
		studentExam.setOperateTime(now);
		Integer healthCount = studentExamService.getHealthExaminationCount(studentExam);
		if(healthCount>0){
            createOperationLog(request, RhipModuleName.HM_STUDENT, "学生体检", OperationName.ADD);
			result = studentExamService.addStudentExam(studentExam);
		}
		return result;
	}

	@RequestMapping("/updateExamReport")
	public String updateExamReport(ModelMap model, Long studentExamId) {
		StudentExam studentExam = studentExamService.getStudentExam(new Criteria("studentExamId", studentExamId));
		//studentExamService.resetToothNo(studentExam);
		model.addAttribute("exam", studentExam);
		return "com.founder.rhip.hm.studentExam.editExamReport";
	}

	@RequestMapping("/updateStudentExam")
	@ResponseBody
	public int updateExamReport(StudentExam studentExam, ModelMap model, HttpServletRequest request) {
		Date now  = new Date();
		User user = getCurrentUser(request);
		Organization organization=getCurrentOrg(request);
		studentExam.setOperator(user.getUserName());
		studentExam.setOperateOrgan(organization.getOrganCode());
		studentExam.setOrganization(organization.getOrganName());
		studentExam.setOperateTime(now);
		int result =  studentExamService.updateStudentExam(studentExam);
        createOperationLog(request, RhipModuleName.HM_STUDENT, "学生体检", OperationName.UPDATE);
        return result;
	}

	@RequestMapping("/checkStudentInfo")
	@ResponseBody
	public Object checkStudentInfo(HttpServletRequest request, String examYear, String idCard) {
		StudentExam exam = studentExamService.getStudentExamInfo(examYear, idCard);
		if (exam != null) {
			return -1;
		}
		StudentInfo student = studentInfoService.queryStudent(idCard);
		List<String> schoolCodes = getDefaultSchoolCodes(request);
		if (schoolCodes != null && student != null) {
			if (schoolCodes.contains(student.getSchoolCode())) {
				return student;
			}
		}
		return -2;
	}
	
	@RequestMapping("/checkHeightAndWeight")
	@ResponseBody
	public ModelMap checkHeightAndWeight(Date birthday, String gender, double height, double weight, Date examDate) {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("success", true);
		double age = DateUtil.getAgeByBirthday(birthday, examDate);
		String hResult = studentExamService.checkHeightCatagory(age, gender, height);
		String wResult = studentExamService.checkWeightCatagory(age, gender, height, weight);
		List<String> msg = new ArrayList<String>();
		if (StringUtil.isNotEmpty(hResult)) {
			msg.add(hResult);
		}
		if (StringUtil.isNotEmpty(wResult)) {
			msg.add(wResult);
		}
		if (msg.size() > 0) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", StringUtil.join(msg));
		}
		return modelMap;
	}
	
	@RequestMapping("/checkHighBoold")
	@ResponseBody
	public ModelMap checkHighBoold(Date birthday, String gender, double sbp, double dbp, Date examDate) {
		ModelMap modelMap = new ModelMap();
		double age = DateUtil.getAgeByBirthday(birthday, examDate);
		String result = studentExamService.checkHighBlood(age, gender, sbp, dbp);
		if (result == null) {
			modelMap.addAttribute("success", true);
		} else {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", result);
		}
		return modelMap;
	}

	@RequestMapping("/deleteStudentExam")
	@ResponseBody
	public int deleteStudentExam(HttpServletRequest request, Long studentExamId) {
        int result = studentExamService.deleteStudentExam(studentExamId);
        createOperationLog(request, RhipModuleName.HM_STUDENT, "体检记录", OperationName.DELETE);
		return result;
	}

	@RequestMapping("/viewStudentExam")
	public String viewStudentExam(ModelMap model, String ids) {
		Long[] examIds = getIds(ids);
		List<StudentExam> examList = getStudentExamList(new Criteria("studentExamId", OP.IN, examIds));
		model.addAttribute("examList", examList);
		model.addAttribute("operation", "view");
		return "com.founder.rhip.hm.studentExam.viewStudentExam";
	}

	@RequestMapping("/printStudentExam")
	public String printStudentExam(ModelMap model, String ids) {
		Long[] examIds = getIds(ids);
		List<StudentExam> examList = getStudentExamList(new Criteria("studentExamId", OP.IN, examIds));
		studentExamService.savePrintStatus(examIds);
		model.addAttribute("examList", examList);
		model.addAttribute("operation", "print");
		return "com.founder.rhip.hm.studentExam.printStudentExam";
	}
	
	/** 学生体检 通过 personId和ehrId获取信息 */
	@RequestMapping("/viewStudentExam/{personId}/{ehrId}")
	public String viewStudentExam(@PathVariable(value = "personId")String personId, 
			@PathVariable(value = "ehrId")String ehrId, ModelMap model){
		Criteria criteria = new Criteria("personInfoId", personId);
		criteria.add("ehrId", ehrId);
		List<StudentExam> examList = getStudentExamList(criteria);
		model.addAttribute("examList", examList);
		return "com.founder.rhip.hm.studentExam.viewStudentExam";
	}
	
	@RequestMapping("/excel")
	public void excel(StudentExamQueryForm form, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String title = "学生体检";
		final Criteria criteria = form.toCriteria();
		if (!criteria.contains("schoolCode") && !criteria.contains("type")) {
			criteria.add("schoolCode", OP.IN, getDefaultSchoolCodes(request));
		}
		//如果选择了学校类型，没有选择具体的学校
		if (!criteria.contains("schoolCode") && criteria.contains("type")) {
			String type = criteria.get("type").toString();
			criteria.add("schoolCode", OP.IN, getSchoolCodesByType(request,type));
		}		
		criteria.remove("type");
        createOperationLog(request, RhipModuleName.HM_STUDENT, "体检数据", OperationName.EXP);
		excelExportService.exportListExecl(title, StudentExam.class, response,new IDataSource() {
			@Override
			public List<Map<String, Object>> get(Page page) {
				List<Map<String, Object>> dataSource = studentExamService.exportExamList(page, criteria);
				return dataSource;
			}
		});
	}

	private List<StudentExam> getStudentExamList(Criteria criteria) {
		//Long[] examIds = getIds(ids);
		List<StudentExam> examList = studentExamService.getExamList(criteria);
		for (StudentExam exam : examList) {
			//studentExamService.resetToothNo(exam);
			String medHis = exam.getMedicalHistory();
			if (StringUtil.isNotEmpty(medHis)) {
				medHis = medHis.replaceAll(",", ", ");
				exam.setMedicalHistory(medHis);
				if (medHis.endsWith("其他") && exam.getOtherMedicalHistory() != null) {
					medHis = medHis.replace("其他", exam.getOtherMedicalHistory());
				}
				exam.setMedicalHistory(medHis);
			} else {
				exam.setMedicalHistory("无");
			}
			String guidance = exam.getHealthGuidance();
			if (StringUtil.isNotEmpty(guidance)) {
				guidance = guidance.replaceAll(",", "<br/>");
				exam.setHealthGuidance(guidance);
			}
		}
		return examList;
	}

	private List<StudentInfo> readStudentInfo(InputStream in) throws Exception {
		ExcelUtils excelUtils = new ExcelUtils(in);
		for (int i = 0; i < 3; i++) {
			excelUtils.readLine();
		}
		List<StudentInfo> studentList = new ArrayList<StudentInfo>();
		while (excelUtils.hasNextLine()) {
			List<Object> line = excelUtils.readLine();
			if (!ExcelUtils.isEmptyLine(line)) {
				StudentInfo student = readLine(line);
				studentList.add(student);
			}
		}
		return studentList;
	}
	
	private StudentInfo readLine(List<Object> line) {
		int index = 0;
		StudentInfo student = new StudentInfo();
		student.setName(ExcelUtils.getStringValue(line, index++));
		student.setGender(FissureSealantController.formatGender(ExcelUtils.getStringValue(line,  index++)));
		student.setIdcard(ExcelUtils.getStringValue(line,  index++).toUpperCase());
		//student.setBirthday(ExcelUtils.getDateValue(line,  index++, "yyyy-MM-dd"));
		student.setInYear(ExcelUtils.getStringValue(line,  index++));
		student.setGradeCode(ExcelUtils.getStringValue(line,  index++));
		student.setClassCode(ExcelUtils.getStringValue(line,  index++));
		student.setNation(ExcelUtils.getStringValue(line,  index++));
		student.setAboBloodType(ExcelUtils.getStringValue(line,  index++));
		student.setStudentNo(ExcelUtils.getStringValue(line,  index++));
		return student;
	}
	
	private Criteria toCriteria(SchoolInfo school) {
		Criteria criteria = new Criteria();
		String schoolCode = school.getSchoolCode();
		if (StringUtil.isNotEmpty(schoolCode)) {
			criteria.add("schoolCode", OP.LIKE, schoolCode);
		}
		String name = school.getName();
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		String type = school.getType();
		if (StringUtil.isNotEmpty(type)) {
			criteria.add("type", type);
		}
		String areaType = school.getAreaType();
		if (StringUtil.isNotEmpty(areaType)) {
			criteria.add("areaType", areaType);
		}
		String boardType = school.getBoardType();
		if (StringUtil.isNotEmpty(boardType)) {
			criteria.add("boardType", boardType);
		}
		String examOrgan = school.getExamOrgan();
		if (StringUtil.isNotEmpty(examOrgan)) {
			criteria.add("examOrgan", examOrgan);
		}
		String organTown = school.getOrganTown();
		if (StringUtil.isNotEmpty(organTown)) {
			criteria.add("organTown", organTown);
		}
		return criteria;
	}
	
	private SchoolInfo initSchoolValue(SchoolInfo school, User user) {
		school.setOperator(getOperator(user));
		school.setOperateTime(getOperateTime());
		school.setCityCode("3205810000");
		school.setCityName("常熟市");
		//school.setArea("苏南");
		return school;
	}
	
	private void initFullData(List<StudentInfo> dataList, User user, String organCode, String schoolCode, String schoolName) {
		for (StudentInfo studentInfo : dataList) {
			studentInfo.setSchoolCode(schoolCode);
			studentInfo.setSchoolName(schoolName);
			studentInfo.setGradeName(dictionaryApp.queryDicItemName("FS10258", studentInfo.getGradeCode()));
			studentInfo.setBirthday(IDCardUtil.getBirthDateByIdCard(studentInfo.getIdcard()));
			studentInfo.setOperator(user.getName());
			studentInfo.setOperateType(organCode);
			studentInfo.setOperateTime(getOperateTime());
		}
	}
	
	private List<String> validateData(List<StudentInfo> dataList) {
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			StudentInfo student = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			FissureSealantController.validateObject("姓名", student.getName(), ret);
			FissureSealantController.validateObject("性别", student.getGender(), ret);
			FissureSealantController.validateObject("身份证", student.getIdcard(), ret);
			//FissureSealantController.validateDate("出生日期", student.getBirthday(), ret);
			FissureSealantController.validateObject("入学年份", student.getInYear(), ret);
			FissureSealantController.validateObject("年级编码", student.getGradeCode(), ret);
			FissureSealantController.validateObject("班级编码", student.getClassCode(), ret);
			
			FissureSealantController.validateMaxLength("姓名", 20, student.getName(), ret);
			FissureSealantController.validateMaxLength("身份证", 18, student.getIdcard(), ret);
			FissureSealantController.validateMaxLength("入学年份", 4, student.getInYear(), ret);
			FissureSealantController.validateMaxLength("班级", 4, student.getClassCode(), ret);
			FissureSealantController.validateMaxLength("民族", 20, student.getNation(), ret);
			FissureSealantController.validateMaxLength("血型", 5, student.getAboBloodType(), ret);
			FissureSealantController.validateMaxLength("学籍卡号", 20, student.getStudentNo(), ret);
			
			if (!IDCardUtil.validateCard(student.getIdcard())) {
				ret.add("身份证号"+student.getIdcard()+"不合法");
			}
			
			FissureSealantController.validateDict(dictionaryApp, "性别", "GBT226112003", student.getGender(), ret);
			FissureSealantController.validateDict(dictionaryApp, "年级编码", "FS10258", student.getGradeCode(), ret);
			
			String classCode = student.getClassCode();
			try {
				int intValue = Integer.parseInt(classCode);
				if (intValue >= 100 || intValue <= 0) {
					ret.add("班级编码不合法");
				}
			} catch (Exception e) {
				ret.add("班级编码不合法");
			}
			
			String inYear = student.getInYear();
			try {
				int intValue = Integer.parseInt(inYear);
				if (intValue > Calendar.getInstance().get(Calendar.YEAR)) {
					ret.add("入学年份不合法");
				}
			} catch (Exception e) {
				ret.add("入学年份不合法");
			}
			
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;
	}


	private Long[] getIds(String ids) {
		if (ObjectUtil.isNullOrEmpty(ids)) {
			return null;
		}
		if (ids.contains(",")) {
			String[] list = ids.split(",");
			Long[] idList = new Long[list.length];
			for (int i = 0; i < list.length; i++) {
				idList[i] = Long.parseLong(list[i]);
			}
			return idList;
		} else {
			Long id = Long.parseLong(ids);
			return new Long[] {id};
		}
	}
}
