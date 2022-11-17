package com.founder.rhip.hm.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.rhip.ehr.common.RhipModuleName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
import com.founder.rhip.ehr.dto.FissureSealantReportDTO;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.pbusiness.student.FissureSealant;
import com.founder.rhip.ehr.entity.pbusiness.student.SchoolStudent;
import com.founder.rhip.hm.controller.form.FissureSealantQueryForm;
import com.founder.rhip.hm.service.IFissureSealantService;
import com.founder.rhip.hm.service.ISchoolStudentService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.SchoolInfo;
import com.founder.rhip.mdm.service.ISchoolInfoService;

@Controller
@RequestMapping(value = "/hm/fissureSealant")
public class FissureSealantController extends BaseController {
	
	@Resource
	private ISchoolInfoService schoolInfoService;
	
	//@Resource
	//private IStudentInfoService studentInfoService;
	
	@Resource
	private IFissureSealantService fissureSealantService;
	
	@Resource
	private ISchoolStudentService schoolStudentService;
	
	@Resource
	private IDictionaryApp dictionaryApp;
	
	private String[] codes = new String[] {"01","06"};
	
	private List<SchoolInfo> schools;
	
	private List<DicItem> areaTypes;
	
	private List<DicItem> dicTypes;
	
	@RequestMapping("/search")
	public String search(ModelMap model) {
		return "com.founder.rhip.hm.fissureSealant.search";
	}
	
	@RequestMapping("/list")
	public String list(ModelMap model, HttpServletRequest request, FissureSealantQueryForm form, int indexPage) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = form.toCriteria();
		PageList<FissureSealant> pageList = fissureSealantService.getExamPageList(page, criteria);
		model.addAttribute("fissureSealants", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.rhip.hm.fissureSealant.list";
	}
	
	@RequestMapping("/reportSearch")
	public String reportSearch(ModelMap model) {
		if (schools == null) {
			Criteria criteria = new Criteria();
			criteria.add("type", OP.IN, codes);
			schools = schoolInfoService.getSchools(criteria);
		}
		model.addAttribute("schools", schools);
		
		if (areaTypes == null) {
			areaTypes = dictionaryApp.queryDicItem("FS10256");
		}
		model.addAttribute("areaTypes", areaTypes);
		
		if (dicTypes == null) {
			List<DicItem> types = dictionaryApp.queryDicItem("FS10255");
			dicTypes = new ArrayList<DicItem>();
			for (DicItem item : types) {
				for (String code : codes) {
					if (code.equals(item.getItemCode())) {
						dicTypes.add(item);
					}
				}
			}
		}
		model.addAttribute("types", dicTypes);
		
		return "com.founder.rhip.hm.fissureSealant.reportSearch";
	}
	
	@RequestMapping("/querySchoolList")
	@ResponseBody
	public ModelMap querySchoolList(String areaType, String type) {
		String[] araTypes = areaType.split(",");
		String[] types = type.split(",");
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(areaType)) {
			criteria.add("areaType", OP.IN, araTypes);
		}
		if (StringUtil.isNotEmpty(type)) {
			criteria.add("type", OP.IN, types);
		} else {
			criteria.add("type", OP.IN, codes);
		}
		List<SchoolInfo> schools = schoolInfoService.getSchools(criteria);
		
		ModelMap model = new ModelMap();
		model.addAttribute("success", true);
		model.addAttribute("schools", schools);
		return model;
	}
	
	@RequestMapping("/report")
	public String report(ModelMap model, Date beginDate, Date endDate, String schoolCode) {
		String[] schoolCodes = schoolCode.split(",");
		FissureSealantReportDTO reportData = fissureSealantService.report(beginDate, endDate, schoolCodes);
		model.addAttribute("reportData", reportData);
		return "com.founder.rhip.hm.fissureSealant.report";
	}
	
	@RequestMapping("/print")
	public String print(ModelMap model, Long id) {
		FissureSealant fs = fissureSealantService.getFissureSealant(id);
		model.addAttribute("fs", fs);
		model.addAttribute("operation", "print");
		return "com.founder.rhip.hm.fissureSealant.print";
	}
	
	@RequestMapping("/view")
	public String view(ModelMap model, Long id) {
		FissureSealant fs = fissureSealantService.getFissureSealant(id);
		model.addAttribute("fs", fs);
		return "com.founder.rhip.hm.fissureSealant.view";
	}
	
	@RequestMapping("/edit")
	public String edit(ModelMap model, Long id) {
		FissureSealant fs = fissureSealantService.getFissureSealant(id);
		model.addAttribute("fs", fs);
		return "com.founder.rhip.hm.fissureSealant.edit";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(FissureSealant fs) {
		ModelMap model = new ModelMap();
		try {
			fissureSealantService.save(fs);
			model.addAttribute("success", true);
			model.addAttribute("message", "保存成功");
		} catch (Exception e) {
			logger.error("保存窝沟数据出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public ModelMap delete(Long id) {
		ModelMap model = new ModelMap();
		try {
			fissureSealantService.delete(id);
			model.addAttribute("success", true);
			model.addAttribute("message", "删除成功");
		} catch (Exception e) {
			logger.error("保存窝沟数据出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/showImport")
	public String showImport(ModelMap model) {
		return "com.founder.rhip.hm.fissureSealant.import";
	}
	
	@RequestMapping("/downloadFissureSealantTemplet")
	public void downloadFissureSealantTemplet(HttpServletResponse response) throws Exception {
		ExcelUtils excel = new ExcelUtils(getExcelPath("../views/hm/template/fissureSealantTemplet.xls"));
		setExcelContent(response, "窝沟封闭导入模板.xls");
		excel.save(response.getOutputStream());
	}
	
	/**
	 * @param request
	 * @param file
	 * @param schoolCode
	 * @param schoolName
	 * @param mnumber
	 * @param fnumber
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public ModelMap upload(HttpServletRequest request, @RequestParam("qqfile") CommonsMultipartFile file, String schoolCode, String schoolName, String year, int mnumber, int fnumber) {
		ModelMap model = new ModelMap();
		try {
			InputStream in = file.getInputStream();
			try {
                createOperationLog(request, RhipModuleName.HM_FIS, "窝沟封闭", OperationName.IMP);
				ExcelUtils excelUtils = new ExcelUtils(in);
				List<FissureSealant> dataList = readData(excelUtils);
				if (ObjectUtil.isNullOrEmpty(dataList)) {
					model.addAttribute("success", false);
					model.addAttribute("message", "导入窝沟封闭数据为空");
					return model;
				}
				List<String> msg = validateData(dataList);
				if (msg != null && msg.size()>0) {
					model.addAttribute("success", false);
					model.addAttribute("message", "导入窝沟封闭数据失败，" + StringUtil.join(msg));
					return model;
				}
				User user = getCurrentUser(request);
				Organization organ = getCurrentOrg(request);
				processSchoolStudent(user, organ, schoolCode, schoolName, year, mnumber, fnumber);
				
				initFullData(dataList, user, organ, schoolCode, schoolName);
				int count = fissureSealantService.importDatas(dataList);
				model.addAttribute("success", true);
				model.addAttribute("message", "总共导入"+dataList.size()+"条窝沟封闭数据，成功"+count+"条，失败"+(dataList.size() - count)+"条");
			} finally {
				in.close();
			}
		} catch (Exception e) {
			logger.error("导入窝沟封闭数据出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", "无法导入，请检查导入文件模板和数据格式");
			return model;
		}
		return model;
	}
	
	private void processSchoolStudent(User user, Organization organ, String schoolCode, String schoolName, String year, int mnumber, int fnumber) {
		//String currentYear = String.valueOf(DateUtil.getCurrentYear());
		Date now = new Date();
		SchoolStudent studentInfo = schoolStudentService.querySchoolStudent(year, schoolCode);
		if (studentInfo == null) {
			studentInfo = new SchoolStudent();
			studentInfo.setYear(year);
			studentInfo.setSchoolCode(schoolCode);
			studentInfo.setSchoolName(schoolName);
		}
		studentInfo.setFsMnumber(mnumber);
		studentInfo.setFsFnumber(fnumber);
		studentInfo.setFsTnumber(mnumber + fnumber);
		studentInfo.setOperator(getOperator(user));
		studentInfo.setOperateOrgan(organ.getOrganCode());
		studentInfo.setOperateTime(now);
		schoolStudentService.save(studentInfo);
	}
	
	private List<String> validateData(List<FissureSealant> dataList) {
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			FissureSealant fs = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", fs.getName(), ret);
			validateObject("性别", fs.getGender(), ret);
			validateObject("身份证", fs.getIdcard(), ret);
			validateObject("是否本地学生", fs.getNativeStudent(), ret);
			validateObject("检查牙数", fs.getTeethNumber(), ret);
			validateObject("是否患龋", fs.getHasDentalCaries(), ret);
			validateObject("龋齿数", fs.getDentalCaries(), ret);
			validateObject("可窝沟封闭牙数", fs.getNeedNumber(), ret);
			validateObject("实际窝沟封闭牙数", fs.getRealNumber(), ret);
			validateDate("封闭日期", fs.getCloseDate(), ret);
			
			validateMaxLength("姓名", 20, fs.getName(), ret);
			validateMaxLength("身份证", 18, fs.getIdcard(), ret);
			
			if (!IDCardUtil.validateCard(fs.getIdcard())) {
				ret.add("身份证号"+fs.getIdcard()+"不合法");
			}
			
			validateDict(dictionaryApp, "性别", "GBT226112003", fs.getGender(), ret);
			validateDict("是否本地学生", new String[]{"1","2"}, fs.getNativeStudent(), ret);
			validateDict("是否患龋",  new String[]{"1","2"}, fs.getHasDentalCaries(), ret);
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;
	}
	
	private List<FissureSealant> readData(ExcelUtils excelUtils) {
		for (int i = 0; i < 3; i++) {
			excelUtils.readLine();
		}
		List<FissureSealant> results = new ArrayList<FissureSealant>();
		while (excelUtils.hasNextLine()) {
			List<Object> line = excelUtils.readLine();
			if (!ExcelUtils.isEmptyLine(line)) {
				results.add(readLine(line));
			}
		}
		return results;
	}
	
	private FissureSealant readLine(List<Object> line) {
		FissureSealant fs = new FissureSealant();
		fs.setName(ExcelUtils.getStringValue(line, 0));
		fs.setGender(formatGender(ExcelUtils.getStringValue(line, 1)));
		fs.setIdcard(ExcelUtils.getStringValue(line, 2));
		fs.setNativeStudent(formatTrueOrFalse(ExcelUtils.getStringValue(line, 3)));
		fs.setTeethNumber(ExcelUtils.getIntegerValue(line, 4));
		fs.setHasDentalCaries(formatTrueOrFalse(ExcelUtils.getStringValue(line, 5)));
		fs.setDentalCaries(ExcelUtils.getIntegerValue(line, 6));
		fs.setNeedNumber(ExcelUtils.getIntegerValue(line, 7));
		fs.setRealNumber(ExcelUtils.getIntegerValue(line, 8));
		fs.setCloseDate(ExcelUtils.getDateValue(line, 9, "yyyy-MM-dd"));
		fs.setDoctor(ExcelUtils.getStringValue(line ,10));
		fs.setPosition(ExcelUtils.getStringValue(line, 11));
		return fs;
	}
	
	private void initFullData(List<FissureSealant> dataList, User user, Organization organ, String schoolCode, String schoolName) {
		for (FissureSealant fs : dataList) {
			/*
			StudentInfo student = studentInfoService.queryStudent(fs.getIdcard());
			if (student != null) {
				fs.setName(student.getName());
				fs.setGender(student.getGender());
				fs.setSchoolCode(student.getSchoolCode());
				fs.setSchoolName(student.getSchoolName());
				fs.setClassCode(student.getClassCode());
				fs.setClassName(student.getClassName());
				fs.setGradeCode(student.getGradeCode());
				fs.setGradeName(student.getGradeName());
				fs.setPersonInfoId(student.getPersonInfoId());
			}
			*/
			fs.setSchoolCode(schoolCode);
			fs.setSchoolName(schoolName);
			fs.setExamYear(DateUtil.toDateString(fs.getCloseDate(), "yyyy"));
			fs.setOperator(getOperator(user));
			fs.setOperateType(organ.getOrganCode());
			fs.setOperateTime(getOperateTime());
		}
	}
	
	private static String formatTrueOrFalse(String nativeStudent) {
		if (StringUtil.isNullOrEmpty(nativeStudent)) {
			return null;
		}
		String ret = nativeStudent.trim();
		if ("是".equals(ret)) {
			ret = "1";
		}
		if ("否".equals(ret)) {
			ret = "2";
		}
		return ret;
	}
	
	public static String formatGender(String gender) {
		if (StringUtil.isNullOrEmpty(gender)) {
			return null;
		}
		String ret = gender.trim();
		if ("男".equals(ret)) {
			ret = "1";
		}
		if ("女".equals(ret)) {
			ret = "2";
		}
		return ret;
	}
	
	public static void validateMaxLength(String msg, int maxLength, Object val, List<String> ret) {
		if (ObjectUtil.isNullOrEmpty(val)) {
			return;
		}
		boolean result = (val.toString().length() > maxLength);
		if (result) {
			ret.add(msg+"超过最大长度" + maxLength);
		}
	}
	
	public static void validateObject(String msg, Object val, List<String> ret) {
		if (ObjectUtil.isNullOrEmpty(val)) {
			ret.add(msg+"为空");
		}
	}
	
	public static void validateDate(String msg, Object val, List<String> ret) {
		if (ObjectUtil.isNullOrEmpty(val)) {
			ret.add(msg+"为空或不合法");
			return;
		}
		if (Calendar.getInstance().before(val)) {
			ret.add(msg+"不合法");
		}
	}

	public static void validateDict(IDictionaryApp dictionaryApp, String msg, String dicCode, String key, List<String> ret) {
		if (StringUtil.isNullOrEmpty(key)) {
			return;
		}
		Map<String, String> dictMap = dictionaryApp.queryDicItemMap(dicCode);
		if (!dictMap.containsKey(key)) {
			ret.add(msg+"不合法");
		}
	}
	
	public static void validateDict(String msg, Object[] dict, Object value, List<String> ret) {
		if (ObjectUtil.isNullOrEmpty(value)) {
			return;
		}
		for (Object obj : dict) {
			if (value.equals(obj)) {
				return;
			}
		}
		ret.add(msg+"不合法");
	}

}
