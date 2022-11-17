package com.founder.rhip.idm.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.ReportRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.service.basic.IReportRecordService;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.idm.common.ReportStatus;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.controller.form.ReportQueryForm;
import com.founder.rhip.idm.dto.ReportDto;
import com.founder.rhip.idm.service.IApprovalService;
import com.founder.rhip.idm.service.IHaInterfaceService;
import com.founder.rhip.idm.service.IReportService;
import com.founder.rhip.idm.service.ISetupService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IMedicalTargetService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IOrganizationService;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping(value = "/idm/report")
public class ReportController extends BaseController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "reportService")
	private IReportService reportService;

	@Resource(name = "haInterfaceService")
	private IHaInterfaceService haInterfaceService;

	@Resource(name="mdmDictionaryService")
	private IDictionaryService mdmDictionaryService;
	
	@Resource(name="approvalService")
	private IApprovalService approvalService;
	
	@Resource(name="setupService")
	private ISetupService setupService;

    @Resource(name = "reportRecordService")
    private IReportRecordService reportRecordService;

    @Resource(name="mdmOrganizationService")
    private IOrganizationService mdmOrganizationService;

    @Autowired
    private IDictionaryApp dictionaryApp;

    @Autowired
    private IOrganizationApp organizationApp;

    @Resource(name="medicalTargetService")
    private IMedicalTargetService medicalTargetService;

	private static  CustomDateEditor  dateEditor =
			new CustomDateEditor(new SimpleDateFormat("yyyy/MM/dd"), true);
	
	/*五个专项的传染病code和不作处理的code(肝炎，艾滋病)*/
	public static List<String> specialInfectiousCodes = new ArrayList<String>(Arrays.asList("2141","2142","2143","2144","2035","202","2261",
										"2262","2263","225","305","309"));


    private IdmReport externalReport;

	private static final String CREATE_ORAGAN_CODE_KEY = "fillOrganCode";

	@InitBinder
	public void initBinder(WebDataBinder binder) {	    
	    binder.registerCustomEditor(Date.class, dateEditor);
	}

    /**
	 * 进入查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String searchCheckReport(HttpServletRequest request, ModelMap model) {
		search(request, model);
		return "rhip.idm.report.search";
	}
	
	/**
	 * 进入历史查询查询
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/searchHistory")
	public String searchHistoryReport(HttpServletRequest request, ModelMap model) {
		search(request, model);
		return "rhip.idm.report.searchHistory";
	}
	

	public void search(HttpServletRequest request,ModelMap model) {
		boolean bAllOrg = false;
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (hasRole(RoleType.JKFYK, request) || hasRole(RoleType.ADMIN, request)){
			bAllOrg = true;
		}
		if(!bAllOrg){
			model.addAttribute("fillOrganCode", currentOrgCode);
			model.addAttribute("currentOrgCode", currentOrgCode);
		}
        //默认未审核状体
        model.addAttribute("reportStatus", 1);	
	}

	/**
	 * 查询报卡信息列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/reportList")
	public String checkReportRecord(ReportQueryForm form, HttpServletRequest request, ModelMap model) {
		String url = "rhip.idm.report.reportList";
		reportRecords(form, request, model);
		return url;
	}
	/**
	 * 查询历史报卡信息列表
	 * @param request
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/historyReportList")
	public String historyReportRecord(ReportQueryForm form, HttpServletRequest request, ModelMap model) {
		String url = "rhip.idm.report.historyReportList";
		reportRecords(form, request, model);
		return url;
	}
	
	public void reportRecords(ReportQueryForm form, HttpServletRequest request, ModelMap model) {
		
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = form.getCriteria();
		String orgCode = getCurrentOrg(request).getOrganCode();

		//页面列表 操作 是否显示
		if(hasRole(RoleType.ZXCRB, request)){
			model.addAttribute("ROLE", RoleType.ZXCRB.getValue());
			if(StringUtil.isNullOrEmpty(form.getFillOrganCode())){
				ca.add("role", RoleType.ZXCRB.getValue());
				ca.add("currentCenterCode", orgCode);
			}
		}else if(hasRole(RoleType.JKFYK, request)){
			model.addAttribute("ROLE", RoleType.JKFYK.getValue());
		}else if( hasRole(RoleType.ADMIN, request)){
			model.addAttribute("ROLE", RoleType.ADMIN.getValue());
		}else if(hasRole(RoleType.YYCRB, request)){ //医院-传染病
            model.addAttribute("ROLE", RoleType.YYCRB.getValue());
            ca.add("fillOrganCode", orgCode);
		}else if(hasRole(RoleType.ZCRB, request)){
            model.addAttribute("ROLE", RoleType.ZCRB.getValue());
            ca.add("fillOrganCode", orgCode);
        }else{
			model.addAttribute("ROLE", "");
		}
		
		/*//页面列表 操作 是否显示
		if(hasRole(RoleType.ZXCRB, request)){
			model.addAttribute("ROLE", RoleType.ZXCRB.getValue());
		}else if(hasRole(RoleType.JKFYK, request)){
			model.addAttribute("ROLE", RoleType.JKFYK.getValue());
		}else if(hasRole(RoleType.SJYYFBK, request)){
            model.addAttribute("ROLE", RoleType.SJYYFBK.getValue());
        }else{
			model.addAttribute("ROLE", "");
		}
		ca = form.getCriteria();
*/
        /*传染病类型*/
        if(StringUtil.isNotEmpty(form.getType()) && StringUtil.isNullOrEmpty(form.getInfectiousCode())){
            if(!"L".equals(form.getType())){
                ca.remove("infectiousCode");
                ca.add("infectiousCode", OP.IN, getInfectionByType("IDM00400"+form.getType()));
            }else{
                ca.remove("infectiousCode");
                ca.add("infectiousCode", OP.EQ, "99999");
            }
        }
        if(StringUtil.isNotEmpty(form.getInfectiousCode())){
            String parentInfCodes = "203,212,213,214,215,223,226";
            if(parentInfCodes.contains(form.getInfectiousCode())){
                ca.remove("infectiousCode");
                ca.add("infectiousCode", OP.IN, getInfectionByType2("IDM00400"+form.getType(),form.getInfectiousCode()));
            }
        }
//		if(!hasRole(RoleType.JKFYK, request)){
//			/*Organization org = getCurrentOrg(request);
//			ca.add("fillOrganCode",org.getOrganCode());*/ //代码注释原因  以往是谁上报谁修改填写  新需求  是根据防疫科的指派去添加
//			ca = this.getCriteria(form, orgCode);
//		}    
        model.addAttribute("currentOrgCode", orgCode);
        //PageList<IdmReport> plist = reportService.findReport(ca,page);
        PageList<IdmReport> plist = reportService.getReportLists(page,ca);
        
		model.addAttribute("reports", getReportList(request,plist, orgCode));
		model.addAttribute("page", plist.getPage());	
	}

	@RequestMapping("/historyReportImport")
	public String showImport(String infectiousCode, ModelMap model, HttpServletRequest request) {
		model.put("infectiousCode", infectiousCode);
		return "rhip.idm.report.reportImport";
	}




	/**
	 *
	 *	导出保卡审核EXCEL
	 * @param request
	 * @param response
	 * @param form
	 * @throws Exception
	 */
	@RequestMapping("/historyReportExport")
	@ResponseBody
	public void historyReportRecordExport(ReportQueryForm form, HttpServletResponse response, HttpServletRequest request, ModelMap model) throws Exception {
		try {
			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/reportExport.xls"));

			List<String> events = new ArrayList<String>();
			events.add(SpecialEvents.S_BlOOD.getValue());

			excel.write("A1", "传染病报卡");
			List<IdmReport> lists = getIdmReportList(form,request,model);
			int totalRows = 8;
			int beginRowIndex = 6;
			int line = 0;
			excel.shiftRows(line + beginRowIndex-1 , totalRows + line,lists.size());//
			for (IdmReport dto : lists) {
				List<Object> objects = getExcelValues(dto,line + 1);
				excel.writeLineWithFormat(objects,line + beginRowIndex-1);
				line++;
			}
			excel.shiftRows(beginRowIndex + line , totalRows + line, -1);//删除多余行
			excel.shiftRows(beginRowIndex-1, totalRows + line-1, -1);//删除多余行

			setExcelContent(response, "传染病报卡.xls");
			excel.save(response.getOutputStream());

			lists.clear();
			lists = null;
		} catch (Exception e) {
			log.error("下载《传染病报卡》出错", e);
			throw e;
		}
	}
	@RequestMapping("/downTemplate")
	@ResponseBody
	public void downTemplate(HttpServletResponse response) throws Exception {
		try {
			ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/reportModel.xls"));
			setExcelContent(response, "模板.xls");
			excel.save(response.getOutputStream());

		} catch (Exception e) {
			log.error("下载模板出错", e);
			throw e;
		}
	}
	private List<Record> readXlsFile(InputStream in) throws Exception {
		List<Record> records = new ArrayList<Record>();
		try {
			ExcelUtils reader = new ExcelUtils(in);
			// 读取字段信息
			List<Object> fieldLine = reader.readLine();
			// 读取字段描述
			reader.readLine();
			List<Object> nextLine;
			int row = 2;
			while ((nextLine = reader.readLine()) != null && nextLine.size() > 0) {
				Record record = new Record();
				for (int i = 0; i < fieldLine.size(); i++) {
					String fieldName = String.valueOf(fieldLine.get(i));
					String value = String.valueOf(reader.read(row, i)).trim();
					if ("".equals(value) || fieldName.equalsIgnoreCase("no")) {
						continue;
					}
					setValue(record, fieldName, value);

				}
				records.add(record);
				row++;
			}
			in.close();
		} catch(Exception e){
			log.error("导入excel出错!",e);
			throw e;
		}
		return records;
	}
	private void setValue(Record record, String fieldName, String value) throws ParseException {
		if (fieldName.contains("@")) {
			String[] vals = fieldName.split("@");
			SimpleDateFormat df = new SimpleDateFormat(vals[1]);
			Date date = df.parse(value);
			record.set(vals[0], date);
		} else {
			record.set(fieldName, value);
		}
	}
	@RequestMapping("/upload")
	@ResponseBody
	public ModelMap reportUpload(@RequestParam("file") MultipartFile file, HttpServletResponse response,HttpServletRequest request) throws IOException {
		ModelMap model = new ModelMap();
		try {
			InputStream in = file.getInputStream();
			List<Record> reportList = readXlsFile(in);
			if (reportList == null || reportList.size() == 0) {
				model.addAttribute("result", false);
				model.addAttribute("message", "导入文件为空");
				return model;
			}
			//暂时根据卡片编号查重
			List<ReportDto> reportDtos = new ArrayList<>();
			String falseStr= "记录重复，报卡号为：";
			for (Record record : reportList) {
				IdmReport idmReport =reportService.getReport(new Criteria("RECORD_NUMBER",record.get("recordNumber")));
				if(ObjectUtil.isNullOrEmpty(idmReport )){
					reportDtos.add(setReportDtoValue(record));
				}else{
					falseStr +=  record.get("recordNumber")+";";
				}

			}
			//保存不重复的传染病个案
			int count = reportDtos.size();
			RoleType role = getReportRole(request);
			User user = getCurrentUser(request);

			for(ReportDto reportDto:reportDtos){
				Long reportRecordId = NumberUtil.convert("0", Long.class);
				Organization orgz = getCurrentOrg(request);
				reportDto.getReport().setUpdateOrganCode(orgz.getOrganCode());
				reportDto.getReport().setUpdateName(user.getName());
				reportService.createReport(reportDto,role,user,reportRecordId);
			}
			if(reportList.size()==(count)){
				falseStr ="";
			}


				model.addAttribute("message", "总共导入"+reportList.size()+"条信息，成功"+count+"条，失败"+(reportList.size() - count)+"条;"+ falseStr);
				model.addAttribute("result", true);
			reportList.clear();
			reportList = null;
		} catch (Exception e) {
			log.error("导入报卡出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}

	/**
	 *
	 * @param record
	 * @return
	 */
	private ReportDto setReportDtoValue(Record record) throws ParseException {
		ReportDto reportDto = new ReportDto();
		IdmReport idmReport= new IdmReport();
		IdmReportDesc idmReportDesc = new IdmReportDesc();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		idmReport.setName(ObjectUtil.isNullOrEmpty(record.get("name"))?"":record.get("name").toString());
		idmReport.setRecordNumber(ObjectUtil.isNullOrEmpty(record.get("recordNumber"))?"":record.get("recordNumber").toString());
		idmReport.setParentsName(ObjectUtil.isNullOrEmpty(record.get("parentsName"))?"":record.get("parentsName").toString());
		idmReport.setIdcard(ObjectUtil.isNullOrEmpty(record.get("idcard"))?"":record.get("idcard").toString());
        idmReport.setGender(ObjectUtil.isNullOrEmpty(record.get("gender"))?"":reportService.valueFindCode(new Criteria("itemName","男"),"GBT226112003").toString());
		idmReport.setBirthday(ObjectUtil.isNullOrEmpty(record.get("birthday"))?null:parseDateFormat(record.get("birthday").toString()));
		idmReport.setAge(ObjectUtil.isNullOrEmpty(record.get("age"))?"":record.get("age").toString());
		idmReport.setUnitName(ObjectUtil.isNullOrEmpty(record.get("unitName"))?"":record.get("unitName").toString());//record.get("unitName").toString()
		idmReport.setPhoneNumber(ObjectUtil.isNullOrEmpty(record.get("phoneNumber"))?"":record.get("phoneNumber").toString());
		idmReport.setInfectedpersonBelong(ObjectUtil.isNullOrEmpty(record.get("infectedpersonBelong"))?"":reportService.valueFindCode(new Criteria("itemName",record.get("infectedpersonBelong")),"CV0201104").toString().trim());
		idmReport.setPahouseNumber(ObjectUtil.isNullOrEmpty(record.get("pahouseNumber"))?"":record.get("pahouseNumber").toString());
		idmReport.setCaseCategory(ObjectUtil.isNullOrEmpty(record.get("caseCategory"))?"":reportService.valueFindCode(new Criteria("itemName",record.get("caseCategory")),"CV0501002").toString().trim());//record.get("caseCategory"))?"":record.get("caseCategory").toString()
		idmReport.setCaseCategoryFlag(ObjectUtil.isNullOrEmpty(record.get("caseCategoryFlag"))?"":reportService.valueFindCode(new Criteria("itemName",record.get("caseCategoryFlag")),"FS10062").toString().trim());//record.get("caseCategoryFlag"))?"":record.get("caseCategoryFlag").toString()
		idmReport.setPathogenesisDate(ObjectUtil.isNullOrEmpty(record.get("pathogenesisDate"))?null:parseDateFormat(record.get("pathogenesisDate").toString()));
		idmReport.setDiagnosisDate(ObjectUtil.isNullOrEmpty(record.get("diagnosisDate"))?null:parseDateFormat(record.get("diagnosisDate").toString()));
		//idmReport.setDeathDate(ObjectUtil.isNullOrEmpty(record.get("deathDate"))?null:parseDateFormat(record.get("deathDate").toString()));
		idmReport.setInfectiousName(ObjectUtil.isNullOrEmpty(record.get("infectiousCode"))?"":record.get("infectiousCode").toString());
		idmReport.setReportDoctorName(ObjectUtil.isNullOrEmpty(record.get("reportDoctorName"))?"":record.get("reportDoctorName").toString());
		idmReport.setFillDate(ObjectUtil.isNullOrEmpty(record.get("fillDate"))?null:parseDateFormat(record.get("fillDate").toString()));
		idmReport.setFillOrganName(ObjectUtil.isNullOrEmpty(record.get("fillOrganName"))?"":record.get("fillOrganName").toString());
		idmReport.setComments(ObjectUtil.isNullOrEmpty(record.get("comments"))?"":record.get("comments").toString());
		idmReportDesc.setCheckResult(ObjectUtil.isNullOrEmpty(record.get("checkResult"))?"":reportService.valueFindCode(new Criteria("itemName",record.get("checkResult")),"IDM00346").toString().trim());//record.get("checkResult"))?"":record.get("checkResult").toString()
		idmReportDesc.setSevereCase(ObjectUtil.isNullOrEmpty(record.get("severeCase"))?"":reportService.valueFindCode(new Criteria("itemName",record.get("severeCase")),"PH00001").toString().trim());//record.get("severeCase"))?"":record.get("severeCase").toString()
	/*	if(ObjectUtil.isNotEmpty(record.get("GBCode"))){
			String GBCode = record.get("GBCode").toString();
			GBCode=GBCode.substring(0,1);

		};*/
		reportDto.setReportDesc(idmReportDesc);
		reportDto.setReport(idmReport);
		return  reportDto;
	}
	public Date parseDateFormat(String dateStr) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy", Locale.US

		);
		Date date = DateUtil.convertDate("yyyy/MM/dd mm:hh:dd", format.parse(dateStr));
		return date;
	}

	/**
	 * 保存正确导入的信息
	 * @param reportDto
	 * @param request
	 * @throws Exception
	 */
	public void saveReportDto(ReportDto reportDto, HttpServletRequest request) throws Exception {


		reportService.createUplodReport(reportDto);

	}

	/**
	 * 生成监测登记EXCEL一行数据
	 *
	 * @param lineNumber
	 * @return
	 */
	private List<Object> getExcelValues(IdmReport idmReport, int lineNumber) {

		List<Object> line = new ArrayList<Object>();
		line.add(lineNumber);
		line.add(idmReport.getName());
		line.add(dictionaryApp.queryDicItemName("GBT226112003", idmReport.getGender()));
		line.add(idmReport.getAge() + dictionaryApp.queryDicItemName("IDM00003", idmReport.getAgeUnit()));
		line.add(idmReport.getInfectiousName());
		line.add(dictionaryApp.queryDicItemName("CV0501002", idmReport.getCaseCategory()));
		line.add(idmReport.getPaAddress());
		line.add(idmReport.getFillOrganName());
		line.add(dictionaryApp.queryDicItemName("GBT6565", idmReport.getOccupation()));
		line.add(DateUtil.getDateTime("yyyy/MM/dd", idmReport.getPathogenesisDate()));
		line.add(DateUtil.getDateTime("yyyy/MM/dd HH:mm:ss", idmReport.getDiagnosisDate()));
		line.add(DateUtil.getDateTime("yyyy/MM/dd", idmReport.getFillDate()));
		line.add(dictionaryApp.queryDicItemName("IDM00408", idmReport.getReportSource()));
		return line;
	}
	public List<IdmReport> getIdmReportList(ReportQueryForm form, HttpServletRequest request, ModelMap model) {
		Criteria ca = form.getCriteria();
		String orgCode = getCurrentOrg(request).getOrganCode();

		//页面列表 操作 是否显示
		if(hasRole(RoleType.ZXCRB, request)){
			model.addAttribute("ROLE", RoleType.ZXCRB.getValue());
			if(StringUtil.isNullOrEmpty(form.getFillOrganCode())){
				ca.add("role", RoleType.ZXCRB.getValue());
				ca.add("currentCenterCode", orgCode);
			}
		}else if(hasRole(RoleType.JKFYK, request)){
			model.addAttribute("ROLE", RoleType.JKFYK.getValue());
		}else if( hasRole(RoleType.ADMIN, request)){
			model.addAttribute("ROLE", RoleType.ADMIN.getValue());
		}else if(hasRole(RoleType.YYCRB, request)){ //医院-传染病
			model.addAttribute("ROLE", RoleType.YYCRB.getValue());
			ca.add("fillOrganCode", orgCode);
		}else if(hasRole(RoleType.ZCRB, request)){
			model.addAttribute("ROLE", RoleType.ZCRB.getValue());
			ca.add("fillOrganCode", orgCode);
		}else{
			model.addAttribute("ROLE", "");
		}

        /*传染病类型*/
		if(StringUtil.isNotEmpty(form.getType()) && StringUtil.isNullOrEmpty(form.getInfectiousCode())){
			if(!"L".equals(form.getType())){
				ca.remove("infectiousCode");
				ca.add("infectiousCode", OP.IN, getInfectionByType("IDM00400"+form.getType()));
			}else{
				ca.remove("infectiousCode");
				ca.add("infectiousCode", OP.EQ, "99999");
			}
		}
		if(StringUtil.isNotEmpty(form.getInfectiousCode())){
			String parentInfCodes = "203,212,213,214,215,223,226";
			if(parentInfCodes.contains(form.getInfectiousCode())){
				ca.remove("infectiousCode");
				ca.add("infectiousCode", OP.IN, getInfectionByType2("IDM00400"+form.getType(),form.getInfectiousCode()));
			}
		}
		model.addAttribute("currentOrgCode", orgCode);
		//PageList<IdmReport> plist = reportService.findReport(ca,page);
		List<IdmReport> list = reportService.getReportLists(ca);
		return list;
	}

	/**
	 * 进入新增画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, String pageIndex, ModelMap model) {
		IdmReport report = new IdmReport();
		String orgCode = getCurrentOrg(request).getOrganCode();
		report.setFillOrganCode(orgCode);
		String orgName = getCurrentOrg(request).getOrganName();
		report.setFillOrganName(orgName);
		String userName = getCurrentUser(request).getName();
		report.setReportDoctorName(userName);
		String userId = getCurrentUser(request).getUserCode().toString();
		report.setReportDoctorId(userId);
		report.setFillDate(new Date());
        report.setDiagnosisDate(new Date());
        report = checkAddress(report);
        ReportDto reportDto = new ReportDto();
        reportDto.setReport(report);
		model.addAttribute("reportDto", reportDto);
		model.put("pageIndex", pageIndex);
		model.put("loadResourcesMark", "add");
        return "rhip.idm.report.add";
    }

	/**
	 * 传染病报卡帮助页面
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
	@RequestMapping("/help")
	public String help(HttpServletRequest request, ModelMap model){
		return "rhip.idm.report.help";
	}
	/**
	 * 报卡监控中，1初诊未上报；3复诊未上报时补卡
	 *
	 * @param request
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
	@RequestMapping("/resubmit")
    public String resubmit(Long reportRecordId, HttpServletRequest request, ModelMap model){
        if(ObjectUtil.isNullOrEmpty(reportRecordId)){
            model.put("errorMessage", "报卡监控记录ID为空");
            return "rhip.idm.report.error";
        }
        IdmReport report = fillReportFromRecord(reportRecordId);

        //转成dto
        ReportDto reportDto = new ReportDto();
        reportDto.setReport(report);
        model.addAttribute("resubmit", 1); 
        model.addAttribute("reportRecordId", reportRecordId); 
        model.addAttribute("reSubmitFlag", 1); //报卡监控状态：补卡已上报
        model.addAttribute("reportDto", reportDto);        
        return "rhip.idm.report.report";
	}
	

    /**
     * 外部报卡
     * @param request
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/report")
    public String report(HttpServletRequest request, ModelMap model) throws Exception {
        request.getSession().setAttribute("currentUser", "_");

        Map<String, Object[]> map = new HashMap<String, Object[]>();
        map = (Map<String, Object[]>) request.getAttribute("map");

        boolean returnFlag = true;

        String idcard = getFieldValue(map, "idcard");
        
        // 传染病修改为不查重 2016-12-5
       /* //查该患者是否报过卡（有身份证，是乙肝报卡时才查重）
        if(ObjectUtil.isNotEmpty(idcard) && "2032".equals(getFieldValue(map, "diagnosisCode"))){
            if(!checkReview(request,idcard, "2032")){
                model.put("errorMessage", "该患者乙肝已经上报过。关闭当前页面即可。");
                return "rhip.idm.report.error";
            }        	
        }else if(!ObjectUtil.isNullOrEmpty(idcard)){        //有身份证要判断该病一周之内有没有报过
            //具体判断方法
            returnFlag= checkReview(request,idcard, getFieldValue(map, "diagnosisCode"), null);
        }

        if(!returnFlag){
            model.put("errorMessage", "此疾病一周之内已经上报过。关闭当前页面即可。");
            return "rhip.idm.report.error";
        }*/

        
        if(StringUtil.isNullOrEmpty(getFieldValue(map, "fillOrganCode"))){
            model.put("errorMessage", "没有参数能取得机构信息");
            return "rhip.idm.report.error";
        }

		// 检查字段合法性
		String fillOrganCode = getFieldValue(map, CREATE_ORAGAN_CODE_KEY);
		if (!checkOrganCode(fillOrganCode)) {
			model.put("errorMessage", "上报机构参数不合法,无法找到此机构");
			return "rhip.idm.report.error";
		}

        if(StringUtil.isNullOrEmpty(getFieldValue(map, "reportDoctorId")) || StringUtil.isNullOrEmpty(getFieldValue(map, "reportDoctorName"))){
            model.put("errorMessage", "没有参数能取得上报医生信息");
            return "rhip.idm.report.error";
        }
        
        
        //201704027  传染病修改为传报卡页面所有字段（不包含各个传染病单独有的字段）
      /*  if(StringUtil.isNullOrEmpty(getFieldValue(map, "infectedpersonBelong"))){
            model.put("errorMessage", "没有参数能取得病人属于信息");
            return "rhip.idm.report.error";
        }
        //本县区 必填住址
        if(map.get("infectedpersonBelong").equals("1")){
        	if(StringUtil.isNullOrEmpty(getFieldValue(map, "pastreet"))){
                model.put("errorMessage", "没有参数能取得现住地址-乡(镇、街道办事处)信息");
                return "rhip.idm.report.error";
            }
            if(StringUtil.isNullOrEmpty(getFieldValue(map, "patownShip"))){
                model.put("errorMessage", "没有参数能取得现住地址地址-村(街、路、弄等)信息");
                return "rhip.idm.report.error";
            }
        }*/

        /*if(StringUtil.isNullOrEmpty(getFieldValue(map, "pahouseNumber"))){
            model.put("errorMessage", "没有参数能取得现住址详填信息");
            return "rhip.idm.report.error";
        }*/
        if(StringUtil.isNullOrEmpty(getFieldValue(map, "caseCategory"))){
            model.put("errorMessage", "没有参数能取得病例分类(1)信息");
            return "rhip.idm.report.error";
        }
        if(StringUtil.isNullOrEmpty(getFieldValue(map, "pathogenesisDate"))){
            model.put("errorMessage", "没有参数能取得发病日期信息");
            return "rhip.idm.report.error";
        }
        if(StringUtil.isNullOrEmpty(getFieldValue(map, "diagnosisDate"))){
            model.put("errorMessage", "没有参数能取得诊断日期信息");
            return "rhip.idm.report.error";
        } else if(ObjectUtil.isNullOrEmpty(DateUtil.parseSimpleDate(getFieldValue(map, "diagnosisDate"), "yyyy/MM/dd hh:mm:ss"))) {
			model.put("errorMessage", "诊断日期的格式应该是yyyy/MM/dd hh:mm:ss");
			return "rhip.idm.report.error";
		}
        

        IdmReport report = setReport(map);
        externalReport = report;
        IdmReportDesc reportDesc = fillReportDesc(map);

        //转成dto
        ReportDto reportDto = new ReportDto();
        reportDto.setReport(report);
        reportDto.setReportDesc(reportDesc);
        reportDto.setLogoff(report.getLogoff());

        model.addAttribute("reportDto", reportDto);
        //用于设置按钮隐藏，弹出“初治、复治”提示
        model.put("reportFlag", "reportOut");
        //页面隐藏上报记录表的id
        model.addAttribute("reportRecordId", request.getAttribute("reportRecordId"));

        /*现住址初始化值*/
        model.put("patownShip", reportDto.getReport().getPatownShip());
        model.put("orgFlag", request.getAttribute("orgFlag"));

        return "rhip.idm.report.report.require";
    }

    /**
     * 报卡时验证：选择身份证、疾病种类时验证
     * 1：乙肝只能上报一次
     * 2：同一种疾病一周内只能上报一次
     * @param idCard
     * @param diagnosisCode
     * @param model
     * @return
     * @author Ye jianfei
     */
	@RequestMapping("/reportCheck")
	public String reportCheck(String idCard, String diagnosisCode, HttpServletRequest request, ModelMap model){
		Map<String, Object> map = new HashMap<String, Object>();
		String returnFlag = "success";
		String error = "";
        //查该患者是否报过卡（有身份证，是乙肝报卡时才查重）
        if(ObjectUtil.isNotEmpty(idCard) && "2032".equals(diagnosisCode)){
            if(!checkReview(request,idCard, "2032")){
            	returnFlag = "fail";
            	error = "该患者乙肝已经上报过。";
            }        	
        }else if(!ObjectUtil.isNullOrEmpty(idCard)){//有身份证要判断该病一周之内有没有报过
            //具体判断方法
        	if(!checkReview(request,idCard, diagnosisCode, null))
        	{
                returnFlag = "fail";
            	error = "此疾病一周之内已经上报过。";        		
        	}
        }
        map.put("returnFlag", returnFlag);
        map.put("error", error);
		return EHRMessageUtil.returnMsg(model, map);
	}
	
    /**
     * 外部报卡选择”复治“的时候，后台存报卡的数据，
     * 并且设置报卡是”不审核的“
     * @param request
     * @param pageIndex
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveReportRetreat")
    public String saveRetreat(HttpServletRequest request, long reportRecordId, String pageIndex, ModelMap model) throws Exception {
        request.getSession().setAttribute("currentUser", "_");

        boolean result = false;

        ReportDto reportDto = new ReportDto();
        reportDto.setReport(externalReport);

        User user =  new User();
        user.setName(externalReport.getReportDoctorName());

        externalReport.setReportStatus(0);

        updatePersonInfo(reportDto,request);//更新患者信息中，更新人、更新时间等信息
        result = reportService.createReport(reportDto, RoleType.YS,user,reportRecordId);

        //要设置一个值表示这个报卡不用审核
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 外部报卡诊断错误
     * @param request
     * @param reportRecordId
     * @param pageIndex
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/diagnosisError")
    public String diagnosisError(HttpServletRequest request, long reportRecordId, String pageIndex, ModelMap model) throws Exception {
        request.getSession().setAttribute("currentUser", "_");

        boolean result = false;

        //诊断错误修改上报记录表状态为：初诊并且诊断错误
        if(reportRecordId!=0){
            result = reportRecordService.update(reportRecordId, null, EHRConstants.IDM_SECOND_ERROR)>0?true:false;;
        }

        //要设置一个值表示这个报卡不用审核
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 外部报卡保存
     * @param reportDto
     * @param model
     * @throws Exception
     */
    @RequestMapping("/saveReportInitial")
    public String saveInitial(HttpServletRequest request, ReportDto reportDto, long reportRecordId, ModelMap model) throws Exception {
        boolean result = false;
        String returnFlag = "";
        IdmReport reportInfo = reportDto.getReport();
        if(ObjectUtil.isNotEmpty(reportInfo)){

            boolean flag = true;

              //***！！！外部报卡保存放到页面打开时和页面操作时，不放在保存时
//            //查该患者是否报过卡（有身份证，是乙肝报卡时才查重）
//            if(ObjectUtil.isNotEmpty(reportInfo.getIdcard()) && reportInfo.getInfectiousCode().equals("2032")){
//            	flag = checkReview(request,reportInfo.getIdcard(), reportInfo.getInfectiousCode());
//            	returnFlag = flag?"":"repeat2032";
//            }else if(!ObjectUtil.isNullOrEmpty(reportInfo.getIdcard())){//有身份证要判断该病一周之内有没有报过
//                    //具体判断方法
//                    flag= checkReview(request,reportInfo.getIdcard(), reportInfo.getInfectiousCode(), null);
//                    returnFlag = flag?"":"repeat";
//            }
            if(flag){
    //            Organization  org = getCurrentOrg(request);
    //            User user = getCurrentUser(request);

                //保存动作
                saveDetail(request, reportDto, reportRecordId);
            }
        }
        return EHRMessageUtil.returnMsg(model, "success");
    }

	/**
	 * 进入审批编辑画面
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap model, String pageIndex){
        Organization org = getCurrentOrg(request);
		ReportDto reportDto = reportService.getReport(id);
        IdmReport report = reportDto.getReport();
		Integer reportStatus = report.getReportStatus();
		model.addAttribute("reportDto", reportDto);
		boolean flg = getApprovalFlag(request, reportStatus);
		if(flg){
			model.addAttribute("approvalFlag", 1);
		}
		/*如果是防保(乡镇卫生院或者市级医院)，且状态为审核,防保科可以修改报卡：modify yjf 2013-09-13*/
		/*疾控可修改自己上报的报卡：modify  2017-08-22*/
		if((hasRole(RoleType.ZXCRB,request) || hasRole(RoleType.YYCRB,request) || hasRole(RoleType.JKFYK,request))  && reportStatus.equals(ReportStatus.HOSPITAL_VERIFY.getValue())){
			model.addAttribute("editFlag", 1);;
		}
		String warning = "";
		Date diagnosisDate = report.getDiagnosisDate();
		//法定传染病的上报时限：甲类-2小时内上报;乙类/丙类:除节假日，24小时内上报 : 防保科审核：超过时效的加提醒
		if(reportStatus.equals(ReportStatus.NOT_VERIFY.getValue())&&ObjectUtil.isNotEmpty(diagnosisDate)){
	        if("101".equals(report.getInfectiousCode()) || "102".equals(report.getInfectiousCode())){//甲类： 鼠疫 霍乱
	        	Date checkDate1 = DateUtil.add(diagnosisDate, Calendar.HOUR_OF_DAY, 2);
	        	if (checkDate1.getTime() < new Date().getTime()) {
	    			warning = "诊断时间距现在已经超过2小时";
	    		}
	        }else{
	        	Date checkDate2 = DateUtil.add(diagnosisDate, Calendar.HOUR_OF_DAY, 24);
	        	if (checkDate2.getTime() < new Date().getTime()) {
	    			warning = "诊断时间距现在已经超过24小时";
	    		}
	        }
		}
		report.setCurrentDiagnosisTimeS(DateUtil.toDateString(report.getCurrentDiagnosisTime(), "yyyy/MM/dd hh:mm:ss"));
		report.setCurrentFillTimeS(DateUtil.toDateString(report.getCurrentFillTime(), "yyyy/MM/dd hh:mm:ss"));
        model.addAttribute("pageIndex", pageIndex);        
        model.addAttribute("ROLE", getCurrentUserRoles(request).get(0));
        model.addAttribute("currentOrgCode", org.getOrganCode());
        model.addAttribute("warning", warning);
        return "rhip.idm.report.add";
	}

	/**
	 * 进入查看（只读）画面
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/print/{id}")
	public String print(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap model){
        String url = "rhip.idm.report.print";

        ReportDto reportDto = reportService.getReport(id);
        IdmReport report = reportDto.getReport();
		Integer reportStatus = report.getReportStatus();
		model.addAttribute("reportDto", reportDto);

        return url;
	}

    /**
     * 进入查看（只读）画面
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") Integer id, HttpServletRequest request, ModelMap model){
        String url = "rhip.idm.report.detail";

        ReportDto reportDto = reportService.getReport(id);
        IdmReport report = reportDto.getReport();
        Integer reportStatus = report.getReportStatus();
        model.addAttribute("reportDto", reportDto);
        //true是有审核权限，单还未审核。false是其他情况
        boolean flg = getApprovalFlag(request, reportStatus);
        if(flg){
            model.addAttribute("approvalFlag", 1);
        }
        //审核状态
        model.addAttribute("printFlag", reportStatus);

        return url;
    }

	/**
	 * 新增报卡
	 * @param reportDto
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String save(ReportDto reportDto, HttpServletRequest request, ModelMap model) throws Exception {
		boolean result = false;
        String returnFlag = "";
        IdmReport reportInfo = reportDto.getReport();
		if(ObjectUtil.isNotEmpty(reportInfo)){
			Organization org = getCurrentOrg(request);
			User user = getCurrentUser(request);
			
			//传染病不查重 2016-12-6
			 reportInfo.setPaAddress(reportInfo.getInfectedpersonBelong().equalsIgnoreCase("1")
                     ? dictionaryApp.queryDicItemName("FS990001", reportInfo.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", reportInfo.getPastreet()) + reportInfo.getPahouseNumber()
                     : reportInfo.getPahouseNumber());
             reportInfo.setHrAddress(reportInfo.getInfectedpersonBelong().equalsIgnoreCase("1")
                     ? dictionaryApp.queryDicItemName("FS990001", reportInfo.getHrtownShip()) + dictionaryApp.queryDicItemName("FS990001", reportInfo.getHrstreet()) + reportInfo.getHrhouseNumber()
                     : reportInfo.getHrhouseNumber());
             reportInfo.setUpdateOrganCode(org.getOrganCode());
             reportInfo.setUpdateOrganName(org.getOrganName());
             reportInfo.setUpdateIdCard(user.getIdentityCard());
             reportInfo.setUpdateName(user.getName());
             reportInfo.setUpdateDate(new Date());
             Date diagnosisDate = reportInfo.getDiagnosisDate();
             String diagnosisHMS = reportInfo.getDiagnosisHour();
             String dateYMDStr = DateUtil.toDateString(diagnosisDate, "yyyy/MM/dd");
             Date diagnosisDateReal = DateUtil.parseSimpleDate(dateYMDStr + " " + diagnosisHMS, "yyyy/MM/dd hh:mm:ss");
             reportInfo.setDiagnosisDate(diagnosisDateReal);
             if(ObjectUtil.isNullOrEmpty(reportInfo.getCurrentDiagnosisTime())){
               	reportInfo.setCurrentDiagnosisTime(diagnosisDateReal);
               }
             reportInfo.setReportSource(EHRConstants.REPORT_SOURCE_PLATFORM);
             //2017-08-14 需求  填卡日期增加时分秒
             Date fillDate = reportInfo.getFillDate();
			 String fillHMS = reportInfo.getFillHour();
			 if(StringUtil.isNotEmpty(fillHMS)){
                String fillDateYMDStr = DateUtil.toDateString(fillDate, "yyyy/MM/dd");
                Date fillDateReal = DateUtil.parseSimpleDate(fillDateYMDStr + " " + fillHMS, "yyyy/MM/dd hh:mm:ss");
                reportInfo.setFillDate(fillDateReal);
                if(ObjectUtil.isNullOrEmpty(reportInfo.getCurrentFillTime())){
                 	reportInfo.setCurrentFillTime(fillDateReal);
                 }
			 }
             //2017-08-14 需求 增加上报报卡的真实时间和诊断的真实时间
            
             
              //2017-08-14 需求  死亡日期增加时
             Date deathDate = reportInfo.getDeathDate();
			 String deathHMS = reportInfo.getDeathHour();
			 if(StringUtil.isNotEmpty(deathHMS)){
                String deathDateYMDStr = DateUtil.toDateString(deathDate, "yyyy/MM/dd");
                Date deathDateReal = DateUtil.parseSimpleDate(deathDateYMDStr + " " + deathHMS, "yyyy/MM/dd hh");
                reportInfo.setDeathDate(deathDateReal);
			 }
             RoleType role = getReportRole(request);
            // 报卡监控ID,MODIFY BY YE JIAN FEI 20131031
             String reportRecord = request.getParameter("reportRecordId");
             if(StringUtil.isNullOrEmpty(reportRecord)){
             	reportRecord = "0";
             }
             Long reportRecordId = NumberUtil.convert(reportRecord, Long.class);
            /* //不是身份证
             if("0" != reportInfo.getOtherIdcardType()){
            	 reportInfo.getPersonInfo().setOtherIdcard(reportInfo.getIdcard());
            	 reportInfo.getPersonInfo().setIdcard("");
             }*/
             //报卡监控，补卡时更新监控状态 modify ye jianfei 20131031
             result = reportService.createReport(reportDto,role,user,reportRecordId);
	
            /*  传染病查重 
            //默认没有
             boolean flag = true;
            
            //查该患者是否报过卡（有身份证，是乙肝报卡时才查重）
            if(ObjectUtil.isNotEmpty(reportInfo.getIdcard()) && reportInfo.getInfectiousCode().equals("2032")){
            	flag = checkReview(request,reportInfo.getIdcard(), reportInfo.getInfectiousCode());
            	returnFlag = flag?"":"repeat2032";
            }else if(!ObjectUtil.isNullOrEmpty(reportInfo.getIdcard())){//查一周内同人同病同机构是否报过卡（有身份证才查重）
                flag = checkReview(request,reportInfo.getIdcard(), reportInfo.getInfectiousCode(), org.getOrganCode());
                returnFlag = flag?"":"repeat";
            }
            if(flag){
                reportInfo.setPaAddress(reportInfo.getInfectedpersonBelong().equalsIgnoreCase("1")
                        ? dictionaryApp.queryDicItemName("FS990001", reportInfo.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", reportInfo.getPastreet()) + reportInfo.getPahouseNumber()
                        : reportInfo.getPahouseNumber());
                reportInfo.setHrAddress(reportInfo.getInfectedpersonBelong().equalsIgnoreCase("1")
                        ? dictionaryApp.queryDicItemName("FS990001", reportInfo.getHrtownShip()) + dictionaryApp.queryDicItemName("FS990001", reportInfo.getHrstreet()) + reportInfo.getHrhouseNumber()
                        : reportInfo.getHrhouseNumber());
                reportInfo.setUpdateOrganCode(org.getOrganCode());
                reportInfo.setUpdateOrganName(org.getOrganName());
                reportInfo.setUpdateIdCard(user.getIdentityCard());
                reportInfo.setUpdateName(user.getName());
                reportInfo.setUpdateDate(new Date());
                Date diagnosisDate = reportInfo.getDiagnosisDate();
                String diagnosisHMS = reportInfo.getDiagnosisHour();
//                Integer hour = Integer.parseInt(diagnosisHour);
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(diagnosisDate);
//                calendar.set(Calendar.HOUR_OF_DAY, hour );
//                reportInfo.setDiagnosisDate(calendar.getTime());
                String dateYMDStr = DateUtil.toDateString(diagnosisDate, "yyyy/MM/dd");
                Date diagnosisDateReal = DateUtil.parseSimpleDate(dateYMDStr + " " + diagnosisHMS, "yyyy/MM/dd hh:mm:ss");
                reportInfo.setDiagnosisDate(diagnosisDateReal);
                RoleType role = getReportRole(request);
                报卡监控ID,MODIFY BY YE JIAN FEI 20131031
                String  reportRecord = request.getParameter("reportRecordId");
                if(StringUtil.isNullOrEmpty(reportRecord)){
                	reportRecord = "0";
                }
                Long reportRecordId = NumberUtil.convert(reportRecord, Long.class);
                报卡监控，补卡时更新监控状态 modify ye jianfei 20131031
                result = reportService.createReport(reportDto,role,user,reportRecordId);
            }*/
		}
		return EHRMessageUtil.returnMsg(model, ObjectUtil.isNullOrEmpty(returnFlag) ? (result ? "success" : "fail") : returnFlag);
	}

	/**
	 * 审批报卡
	 * @param reportDto
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/approval")
	public String approval(String updateFlag, ReportDto reportDto, HttpServletRequest request, HttpServletResponse response, ModelMap model) throws Exception {
		boolean result = false;
        IdmReport reportInfo = reportDto.getReport();
		if(ObjectUtil.isNotEmpty(reportInfo)){
			Integer currentStatus =reportInfo.getReportStatus();
			User user = getCurrentUser(request);
			/*如果是作废，则不更新数据*/
			if (!currentStatus.equals(ReportStatus.CANCEL.getValue())){
				Organization org = getCurrentOrg(request);

                reportInfo.setPaAddress(reportInfo.getInfectedpersonBelong().equalsIgnoreCase("1")
                        ? dictionaryApp.queryDicItemName("FS990001", reportInfo.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", reportInfo.getPastreet()) + reportInfo.getPahouseNumber()
                        : reportInfo.getPahouseNumber());
                reportInfo.setHrAddress(reportInfo.getInfectedpersonBelong().equalsIgnoreCase("1")
                        ? dictionaryApp.queryDicItemName("FS990001", reportInfo.getHrtownShip()) + dictionaryApp.queryDicItemName("FS990001", reportInfo.getHrstreet()) + reportInfo.getHrhouseNumber()
                        : reportInfo.getHrhouseNumber());
				reportInfo.setUpdateOrganCode(org.getOrganCode());
				reportInfo.setUpdateOrganName(org.getOrganName());
				reportInfo.setUpdateIdCard(user.getIdentityCard());
				reportInfo.setUpdateName(user.getName());
                reportInfo.setUpdateDate(new Date());
                Integer status = getNextStatus(request,currentStatus);
				reportInfo.setReportStatus(status);
				Date diagnosisDate = reportInfo.getDiagnosisDate();
				String diagnosisHMS = reportInfo.getDiagnosisHour();
				if(StringUtil.isNotEmpty(diagnosisHMS)){
                    String dateYMDStr = DateUtil.toDateString(diagnosisDate, "yyyy/MM/dd");
                    Date diagnosisDateReal = DateUtil.parseSimpleDate(dateYMDStr + " " + diagnosisHMS, "yyyy/MM/dd hh:mm:ss");
                    reportInfo.setDiagnosisDate(diagnosisDateReal);
				}
				//2017-08-14 需求  死亡日期增加时
	             Date deathDate = reportInfo.getDeathDate();
				 String deathHMS = reportInfo.getDeathHour();
				 if(StringUtil.isNotEmpty(deathHMS)){
	                String deathDateYMDStr = DateUtil.toDateString(deathDate, "yyyy/MM/dd");
	                Date deathDateReal = DateUtil.parseSimpleDate(deathDateYMDStr + " " + deathHMS, "yyyy/MM/dd hh");
	                reportInfo.setDeathDate(deathDateReal);
				 }
				//2017-08-14 需求  填卡日期增加时分秒
	             Date fillDate = reportInfo.getFillDate();
				 String fillHMS = reportInfo.getFillHour();
				 if(StringUtil.isNotEmpty(fillHMS)){
	                String fillDateYMDStr = DateUtil.toDateString(fillDate, "yyyy/MM/dd");
	                Date fillDateReal = DateUtil.parseSimpleDate(fillDateYMDStr + " " + fillHMS, "yyyy/MM/dd hh:mm:ss");
	                reportInfo.setFillDate(fillDateReal);
				 }
				 if(StringUtil.isNotEmpty(reportInfo.getCurrentDiagnosisTimeS())){
					 reportInfo.setCurrentDiagnosisTime(DateUtil.parseSimpleDate(reportInfo.getCurrentDiagnosisTimeS(), "yyyy/MM/dd hh:mm:ss"));
				 }
				 if(StringUtil.isNotEmpty(reportInfo.getCurrentFillTimeS())){
					 reportInfo.setCurrentFillTime(DateUtil.parseSimpleDate(reportInfo.getCurrentFillTimeS(), "yyyy/MM/dd hh:mm:ss"));
				 }
			}
			/*报卡审核通过后，ZXCRB进行修改时的标志*/
			/*if("1".equals(updateFlag)){
				reportDto.getReport().setUpdateFlag(updateFlag);
			}*/
			result = reportService.approveReport(reportDto,user);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

	/**
	 * 根据身份证号码查询患者信息
	 * @param idCard
	 * @param name
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping("/queryPerson")
	public String queryPerson(String idCard, String name, HttpServletResponse response,HttpServletRequest request, ModelMap model) throws IOException {
		PersonInfo person = haInterfaceService.queryPersonalInfo(name, StringUtil.trimAllWhitespace(idCard));
		Map<String, Object> map = new HashMap<String, Object>();

		//organs = getBelongedOrgans(criteria.get("centerOrgCode").toString(), OrgGenreCode.STATION.getValue());
		if (ObjectUtil.isNotEmpty(person)) { 
			
			if(hasRole(RoleType.JKJFZX, request)) {
				map.put("manageFlag", true);
			}else if(hasRole(RoleType.ZXJFYS, request)) {
				if(person.getInputOrganCode().equals(getCurrentOrg(request).getOrganCode())) {
					map.put("manageFlag", true);
				}else {
					List<Organization> organs = getBelongedOrgans(getCurrentOrg(request).getOrganCode(), OrgGenreCode.STATION.getValue());
					for (Organization organization : organs) {
						if(person.getInputOrganCode().equals(organization.getOrganCode())) {
							map.put("manageFlag", true);
							break;
						}
					}
				}
			}else if(hasRole(RoleType.ZJSB, request)&&person.getInputOrganCode().equals(getCurrentOrg(request).getOrganCode())) {
				map.put("manageFlag", true);
			}else {
				map.put("manageFlag", false);
			}
			getPersonAddress(person);
			
			map.put("flag", true);
			map.put("Name", person.getName());
			map.put("Gender", person.getGender());
			map.put("Idcard", person.getIdcard());
			map.put("healthFileNo", person.getHealthFileNo());
			Date birthday = person.getBirthday();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            if(ObjectUtil.isNotEmpty(birthday)){
				map.put("Birthday", sdf.format(person.getBirthday()));
			}
            if (ObjectUtil.isNullOrEmpty(birthday)) {
                String idcard = person.getIdcard();
                if (ObjectUtil.isNotEmpty(idcard)) {
                    birthday = IDCardUtil.getBirthDateByIdCard(idcard);
                }
                map.put("Birthday", sdf.format(birthday));
            }
            map.put("Occupation", person.getOccupation());
			map.put("PatownShip", person.getPatownShip());
			map.put("Pastreet", person.getPastreet());
			map.put("PaGroup", person.getPaGroup());
			map.put("PahouseNumber", person.getPahouseNumber());
			map.put("PaAddress", person.getPaAddress());
			map.put("HrtownShip", person.getHrtownShip());
			map.put("Hrstreet", person.getHrstreet());
			map.put("HrGroup", person.getHrGroup());
			map.put("HrhouseNumber", person.getHrhouseNumber());
			map.put("HrAddress", person.getHrAddress());
			map.put("PaAddressDetail", person.getPaAddressDetail());
			map.put("HrAddressDetail", person.getHrAddressDetail());
			map.put("FirstGuardian", person.getFirstGuardian());
			map.put("UnitName", person.getUnitName());
			map.put("PhoneNumber", person.getPhoneNumber());
			map.put("otherNationDesc",person.getOtherNationDesc());
			map.put("FloatPopulation", person.getHouseholdType());
			map.put("Nation", person.getNation());
			map.put("Education", person.getEducation());
			map.put("inputGbcode", person.getInputGbcode());
			map.put("inputCenterOrganCode", person.getInputCenterOrganCode());
			map.put("inputOrganCode", person.getInputOrganCode());
			/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
			if(ObjectUtil.isNotEmpty(person.getFilingFlag())) {
				map.put("Logoff", person.getFilingFlag().equals("9")?1:0);  //该人的状态：9注销，其他正常
			} else {
				map.put("Logoff", 0);  //该人的状态：9注销，其他正常
			}

            /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
        }else{
			map.put("flag", false);
			map.put("Idcard", idCard);
		}
		return EHRMessageUtil.returnMsg(model, map);
	}

	protected void getPersonAddress(PersonInfo personInfo) {
		String paAddressDetail = "";
		if (ObjectUtil.isNotEmpty(personInfo.getPatownShip())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getPatownShip());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String pacountyName = paDicItem1.getItemName();
				paAddressDetail = pacountyName;
			}
		}

		if (ObjectUtil.isNotEmpty(personInfo.getPastreet())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getPastreet());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String paStreetName = paDicItem1.getItemName();
				paAddressDetail += " " + paStreetName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getPaGroup())) {
			DicItem paDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getPaGroup());
			if (ObjectUtil.isNotEmpty(paDicItem2)) {
				String paVillagName = paDicItem2.getItemName();
				paAddressDetail += " " + paVillagName;
			}
		}

		String hrAddressDetail = "";
		if (ObjectUtil.isNotEmpty(personInfo.getHrtownShip())) {
			DicItem paDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrtownShip());
			if (ObjectUtil.isNotEmpty(paDicItem1)) {
				String hrcountyName = paDicItem1.getItemName();
				hrAddressDetail = hrcountyName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getHrstreet())) {
			DicItem hrDicItem1 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrstreet());
			if (ObjectUtil.isNotEmpty(hrDicItem1)) {
				String paTownName = hrDicItem1.getItemName();
				hrAddressDetail += " " + paTownName;
			}
		}
		if (ObjectUtil.isNotEmpty(personInfo.getHrGroup())) {
			DicItem hrDicItem2 = dictionaryApp.queryDicItem("FS990001", personInfo.getHrGroup());
			if (ObjectUtil.isNotEmpty(hrDicItem2)) {
				String paStreetName = hrDicItem2.getItemName();
				hrAddressDetail += " " + paStreetName;
			}
		}
		personInfo.setHrAddressDetail(hrAddressDetail);
		personInfo.setPaAddressDetail(paAddressDetail);
	}
	/**
	 * 根据传染病类型查询传染病
	 *
	 * @param type
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping("/queryInfection")
	public String queryInfection(String type, ModelMap model) throws IOException {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, "CV0501017");
		if (StringUtil.isNotEmpty(type)) {
			criteria.add("itemCode", OP.FLIKE, type);
		}
		List<DicItem> dicItems = mdmDictionaryService.getDicItemsUseCache(criteria);

		JSONObject jsonObject = getInfectionDic(dicItems);
		return EHRMessageUtil.returnMsg(model, jsonObject.toString());
	}

    @RequestMapping("/queryInfections")
    public String queryInfections(String type, ModelMap model) throws IOException {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(type)) {
            criteria.add("DIC_CODE", OP.FLIKE, type);
        }
        List<DicItem> dicItems = mdmDictionaryService.getDicItemsUseCache(criteria);

        JSONObject jsonObject = getInfectionDicForSearch(dicItems);
        return EHRMessageUtil.returnMsg(model, jsonObject.toString());
    }

    private List getInfectionByType(String type){
        Criteria criteria = new Criteria();
        criteria.add("DIC_CODE", OP.FLIKE, type);
        List<DicItem> dicItems = mdmDictionaryService.getDicItemsUseCache(criteria);
        List<String> result = new ArrayList<String>();
        for(DicItem dicItem : dicItems){
            result.add(dicItem.getItemCode());
        }
        return result;
    }

    private List getInfectionByType2(String type, String code){
        Criteria criteria = new Criteria();
        criteria.add("dicCode", OP.EQ, type);
        criteria.add("itemCode", OP.LIKE, code);
        List<DicItem> dicItems = mdmDictionaryService.getDicItems(criteria);
        List<String> result = new ArrayList<String>();
        for(DicItem dicItem : dicItems){
            result.add(dicItem.getItemCode());
        }
        return result;
    }

    /**
     * 进入审批记录画面
     * @param idmId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/popApproval")
    public String popApproval(Long idmId, HttpServletRequest request, ModelMap model){
        model.addAttribute("idmId", idmId);
        return "rhip.idm.approval.search";
    }
    
	/**
	 * 进入查看审批记录画面
	 * @param idmId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/approvallist")
	public String approvallist(Integer idmId, HttpServletRequest request, ModelMap model){
		Page page = super.getPage(request,  1);
		Criteria ca = new Criteria("IDM_ID",idmId);
		PageList<IdmApprovalInfo> plist = approvalService.findApprovalInfo(ca,page);
		model.addAttribute("ApprovalInfo",plist);
		model.addAttribute("page", plist.getPage());
		return "rhip.idm.approval.list";
	}
	
	/**
	 * 上报传染病查询界面
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/diseasesStatistics/search")
	public String statisticDiseasesSearch(HttpServletRequest request, ModelMap map, Model model) {
		return "rhip.idm.diseasesStatistics.search";
	}
	
	/**
	 * 上报传染病统计结果界面
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping("/diseasesStatistics/list")
	public String statisticDiseasesList(HttpServletRequest request, ReportQueryForm queryForm, ModelMap map) {

		Criteria criteria= CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		Organization org = getCurrentOrg(request);
		String tempOrgan = "";
		List<Organization> organs = null;
		//1机构=疾控 +所有中心
		if(!criteria.contains("townOrgCode") && !criteria.contains("centerOrgCode")) {	
		}
		//2机构=疾控
		if(criteria.contains("townOrgCode") && !criteria.contains("centerOrgCode")) {
			tempOrgan= "'" + criteria.get("townOrgCode").toString()+ "'";
		}
		//非单疾控，非具体站，非具体中心
		if (!criteria.contains("orgCode")) {
			//中心登陆
			if (hasRole(RoleType.ZXCRB, request)) {
				// 获取中心下属站
			    organs = getBelongedOrgans(org.getOrganCode(), OrgGenreCode.STATION.getValue());
				for (Organization organization : organs) {
					tempOrgan = tempOrgan + "'" + organization.getOrganCode() + "',";
				}
				tempOrgan = tempOrgan + "'" + org.getOrganCode() + "'";
			}
			
			//3疾控登陆：
			if (hasRole(RoleType.JKFYK, request) || hasRole(RoleType.ADMIN, request) ) {
				//中心及下属所有站或者医院
				if(criteria.contains("townOrgCode") && criteria.contains("centerOrgCode")) {
					// 获取中心下属站
				    organs = getBelongedOrgans(criteria.get("centerOrgCode").toString(), OrgGenreCode.STATION.getValue());
					for (Organization organization : organs) {
						tempOrgan = tempOrgan + "'" + organization.getOrganCode() + "',";
					}
					tempOrgan = tempOrgan + "'" + criteria.get("centerOrgCode").toString() + "'";
				}
				//机构=疾控 +所有中心
				if(!criteria.contains("townOrgCode") && !criteria.contains("centerOrgCode")){
					// 获取疾控下属中心+医院
					organs = getBelongedOrgans(EHRConstants.JK_CODE, OrgGenreCode.CENTRE.getValue());
					organs.addAll(getBelongedOrgans(EHRConstants.JK_CODE, OrgGenreCode.HOSPITAL.getValue()));
					for (Organization organization : organs) {
						tempOrgan = tempOrgan + "'" + organization.getOrganCode() + "',";
					}
					tempOrgan = tempOrgan + "'"+ EHRConstants.JK_CODE + "'";
				}
			}
			//站登录：
			if (hasRole(RoleType.ZCRB, request) || hasRole(RoleType.YYCRB, request)) {
				tempOrgan = tempOrgan + "'" + org.getOrganCode() + "'";
			}
		}else {
			//4机构=站
			tempOrgan =  "'" + criteria.get("orgCode").toString() + "'";
		}
		Map<String, String> diseases = new HashMap<String, String>();
		List<DicItem> dicItems = new ArrayList<DicItem>();
		List<String> ths = new ArrayList<String>();
		List<String> tds = new ArrayList<String>();
		String diseaseType = "";
		if("1".equals(queryForm.getDiseaseType())){
			//IDM00400F-甲类传染病
			dicItems = dictionaryApp.queryDicItem(new Criteria("dicCode", "IDM00400F"));
			diseaseType="甲类";
		} else if ("2".equals(queryForm.getDiseaseType())){
			//IDM00400G-乙类传染病
			dicItems = dictionaryApp.queryDicItem(new Criteria("dicCode", "IDM00400G"));
			diseaseType="乙类";
		} else if ("3".equals(queryForm.getDiseaseType())){
			//IDM00400H-丙类传染病
			dicItems = dictionaryApp.queryDicItem(new Criteria("dicCode", "IDM00400H"));
			diseaseType="丙类";
		}else if ("9".equals(queryForm.getDiseaseType())){
			//IDM00400L-其它传染性疾病
			dicItems = dictionaryApp.queryDicItem(new Criteria("dicCode", "IDM00400L"));
			diseaseType="其他类";
		}
		for(int i=0; i< dicItems.size(); i++){
			ths.add(dicItems.get(i).getItemName());
			tds.add(dicItems.get(i).getItemCode());
			diseases.put(dicItems.get(i).getItemCode(), dicItems.get(i).getItemName());
		}
		Criteria ca = new Criteria();
		ca.add("tds", tds);
		ca.add("fillBeginDate", queryForm.getFillBeginDate());
		ca.add("fillEndDate", queryForm.getFillEndDate());
		List<Map<String, Object>> list = reportService.getDiseaseStatisticList(ca);
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		String centerAndStation = "";
		//1机构=疾控 +所有中心
		if(!criteria.contains("townOrgCode") && !criteria.contains("centerOrgCode")) {	
			/*for(Map<String, Object> r: list){
				if("J100".equals(r.get("genre_code"))||"A100".equals(r.get("genre_code"))||(ObjectUtil.isNullOrEmpty(r.get("genre_code"))&&!"-1".equals(r.get("parent_code")))){
					results.add(r);
				}
			}*/
		}
		//2机构=疾控
		if(criteria.contains("townOrgCode") && !criteria.contains("centerOrgCode")) {
			for(Map<String, Object> r: list){
				if("J100".equals(r.get("genre_code"))){
					results.add(r);
				}
			}
		}
		//非单疾控，非具体站，非具体中心
		if (!criteria.contains("orgCode")) {
			//中心登陆
			if (hasRole(RoleType.ZXCRB, request)) {
				centerAndStation = "centerAndStation";
				// 获取中心下属站
				for(Map<String, Object> r: list){
					if(org.getOrganCode().equals(r.get("parent_code"))){
						results.add(r);
					}
				}
			}
			//3疾控登陆：
			if (hasRole(RoleType.JKFYK, request) || hasRole(RoleType.ADMIN, request) ) {
				//中心及下属所有站或者医院
				if(criteria.contains("townOrgCode") && criteria.contains("centerOrgCode")) {
					// 获取中心下属站
					for(Map<String, Object> r: list){
						if(criteria.get("centerOrgCode").equals(r.get("parent_code"))){
							results.add(r);
							centerAndStation = "centerAndStation";
						}
						//医院
						if(criteria.get("centerOrgCode").equals(r.get("organ_code"))&&"-1".equals(r.get("parent_code"))){
							results.add(r);
						}
					}
				}
				//机构=疾控 +所有中心
				if(!criteria.contains("townOrgCode") && !criteria.contains("centerOrgCode")){
					// 获取疾控下属中心+医院
					for(Map<String, Object> r: list){
						if("J100".equals(r.get("genre_code"))||"A100".equals(r.get("genre_code"))||(ObjectUtil.isNullOrEmpty(r.get("genre_code"))&&(!"-1".equals(r.get("parent_code"))||!"合计".equals(r.get("parent_code"))))){
							results.add(r);
						}
					}
				}
			}
			//站登录：
			if (hasRole(RoleType.ZCRB, request) || hasRole(RoleType.YYCRB, request)) {
				/*tempOrgan = tempOrgan + "'" + org.getOrganCode() + "'";*/
				for(Map<String, Object> r: list){
					if(org.getOrganCode().equals(r.get("organ_code"))){
						results.add(r);
					}
				}
			}
		}else {
			//4机构=站
			for(Map<String, Object> r: list){
				if(criteria.get("orgCode").equals(r.get("organ_code"))){
					results.add(r);
				}
			}
		}
		map.addAttribute("results", results);
		map.addAttribute("ths", ths);
		map.addAttribute("tds", tds);
		map.addAttribute("diseaseType", diseaseType);
		map.addAttribute("centerAndStation", centerAndStation);
		return "rhip.idm.diseasesStatistics.list";
	}
	
	
	/**
	 * 获取机构下属所有机构
	 * @param supOrganCode 中心机构编码
	 * @return
	 */
	private List<Organization> getBelongedOrgans(String supOrganCode, String genreCode) {
		List<Organization> organs = new ArrayList<Organization>();
		organs.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", genreCode)));
		return organs;
	}

	/**
	 * 将字段中的树形字段进行组装，只取最末级，名称将上级名称带入
	 * @param dicItems
	 * @return
	 */
	private JSONObject getInfectionDic(List<DicItem> dicItems) {
		int length = dicItems.size();
		String currentCode;
		String currentName;
		String preCode = "";
		String preName = "";
		JSONObject jsonObject = new JSONObject();
		for (int i = 0; i < length; i++) {
			DicItem item = dicItems.get(i);
			currentCode = item.getItemCode();
			currentName = item.getItemName();
			if (item.getItemCode().length() == 1) {
				continue;
			}
			int itemLevel = item.getItemCode().length();
			if (itemLevel == 3) {
				preCode = item.getItemCode();
				preName = item.getItemName();
				String nextCode;
				if (i < length - 1) {
					nextCode = dicItems.get(i + 1).getItemCode();
					if(nextCode.length() <=3){
						jsonObject.put(currentCode, currentName);
						continue;
					}
					if ( !preCode.equals(nextCode.substring(0, 3))) {
						jsonObject.put(currentCode, currentName);
					}
				} else {
					jsonObject.put(currentCode, currentName);
				}
			} else if (itemLevel > 3 && itemLevel < 5) {
                if (currentCode.substring(0, 3).equals(preCode)) {
                    jsonObject.put(currentCode, preName + " " + currentName);
                }else{
                    jsonObject.put(currentCode, currentName);
                }
            }
            //其他 code:"99999"
            else if (item.getItemCode().length() == 5) {
                jsonObject.put(currentCode, currentName);
            }
		}
		return jsonObject;
	}

    /**
     * 将字段中的树形字段进行组装，保留任何父级，名称将上级名称带入
     * @param dicItems
     * @return
     */
    private JSONObject getInfectionDicForSearch(List<DicItem> dicItems) {
        int length = dicItems.size();
        String currentCode;
        String currentName;
        String preCode = "";
        String preName = "";
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < length; i++) {
            DicItem item = dicItems.get(i);
            currentCode = item.getItemCode();
            currentName = item.getItemName();
            if (item.getItemCode().length() == 1) {
                continue;
            }
            int itemLevel = item.getItemCode().length();
            if (itemLevel == 3) {
                preCode = item.getItemCode();
                preName = item.getItemName();
                jsonObject.put(currentCode, currentName);
            } else if (itemLevel == 4) {
                if (currentCode.substring(0, 3).equals(preCode)) {
                    jsonObject.put(currentCode, preName + " " + currentName);
                }else{
                    jsonObject.put(currentCode, currentName);
                }
            }
            //其他 code:"99999"
            else if (item.getItemCode().length() == 5) {
                jsonObject.put(currentCode, currentName);
            }
        }
        return jsonObject;
    }

	   /**
	    * 获取角色
	    * 医生
	    * 医院防保科
	    * 疾控防疫科
	    * @return
	    */
	private RoleType getReportRole(HttpServletRequest request){
		RoleType role = RoleType.YS;
		if(hasRole(RoleType.JKFYK,request)){
			role = RoleType.JKFYK;
		}else if(hasRole(RoleType.ZXCRB,request)){
			role = RoleType.ZXCRB;
		}else if (hasRole(RoleType.YYCRB,request)){
            role = RoleType.YYCRB;
		}else if(hasRole(RoleType.ZCRB,request)){
			role = RoleType.ZCRB;
		}
		return role;
	}
	
	 /**
	    * 获取角色
	    *
	    * @return
	    */
	private RoleType getReportRole(Organization organ){
		RoleType role = RoleType.YS;
		if(OrgGenreCode.JK.getValue().equals(organ.getGenreCode())){
			role = RoleType.JKFYK;
		}else if(OrgGenreCode.CENTRE.getValue().equals(organ.getGenreCode())){
			role = RoleType.ZXCRB;
		}else if (OrgGenreCode.HOSPITAL.getValue().equals(organ.getGenreCode())){
         role = RoleType.YYCRB;
		}else if(OrgGenreCode.STATION.getValue().equals(organ.getGenreCode())){
			role = RoleType.ZCRB;
		}
		return role;
	}
	/**
	 * 循环遍历所有报卡，设置是否有审批权限
	 *
	 * @param request
	 * @param pList
	 * @return
	 */
	private PageList<IdmReport> getReportList(HttpServletRequest request, PageList<IdmReport> pList, String orgCode){
		List<IdmReport> list = pList.getList();
		List<String> infectiousCodes = getInfectiousCodes(orgCode);
		boolean isRole = hasRole(RoleType.JKFYK, request);
		if(ObjectUtil.isNotEmpty(list)) {
			for(IdmReport dc : list) {
				//HIV 和 艾滋病  修改为姓名 、身份证号、 现住址改为*****表示
				if("202".equals(dc.getInfectiousCode()) || "229".equals(dc.getInfectiousCode())){
					dc.setName(dc.getName().substring(0, 1)+"**");
					dc.setPaAddress("**********");
				}
				Integer reportStatus = dc.getReportStatus();
				boolean flg = getApprovalFlag(request, reportStatus);
				if(flg){
					dc.setApprovalFlg("1");
				}
				if(!isRole){
					/*当前用户有无报卡填写和修改的权限*/
					if(!infectiousCodes.contains(dc.getInfectiousCode())
							&& ObjectUtil.equals(ReportStatus.HOSPITAL_VERIFY.getValue(), dc.getReportStatus())){
						dc.setIsOperate(2);
					}
				}

				/*如果是防保(乡镇卫生院或者市级医院)，且状态为审核,防保科可以修改报卡：modify yjf 2013-09-13*/
                if((hasRole(RoleType.ZXCRB,request) || hasRole(RoleType.YYCRB,request)) && reportStatus.equals(ReportStatus.HOSPITAL_VERIFY.getValue())){
                    dc.setIsOperate(5);
                }
			}
		}
		return pList;
	}

	/**
	 *根据角色判断当前状态是否具有审批权限
	 * @param request
	 * @param reportStatus

	 */
	private boolean getApprovalFlag(HttpServletRequest request,Integer reportStatus) {
		boolean result= false;
		/*如果是防保(乡镇卫生院或者市级医院)，且状态为防保科未审核*/
		if((hasRole(RoleType.ZXCRB,request) || hasRole(RoleType.YYCRB,request)) && reportStatus.equals(ReportStatus.NOT_VERIFY.getValue())){
			result=true;
		}
		return result;
	
		/*boolean result= false;
		如果是防保(乡镇卫生院或者市级医院)，且状态为防保科未审核
		if((hasRole(RoleType.ZXCRB,request) || hasRole(RoleType.SJYYFBK,request)) && reportStatus.equals(ReportStatus.READY.getValue())){
			result=true;
		}
		如果是防疫科，且状态为防疫科待审核
		if(hasRole(RoleType.JKFYK,request) && reportStatus.equals(ReportStatus.VERIFIED_FIRST.getValue())){
			result=true;
		}
		return result;*/
	}
	
	/**
	 *根据角色和报卡状态获取报卡下一步状态
	 * @param request
	 * @param reportStatus

	 */
	private Integer getNextStatus(HttpServletRequest request, Integer reportStatus) {
		Integer result = ReportStatus.HOSPITAL_VERIFY.getValue();
		/*如果是状态为作废,则不变*/
		if(reportStatus.equals(ReportStatus.CANCEL.getValue())){
			result = reportStatus;
		}
		/*如果是防保，且状态为未审核*/
		if((hasRole(RoleType.ZXCRB,request) || hasRole(RoleType.YYCRB,request))&& reportStatus.equals(ReportStatus.NOT_VERIFY.getValue())){
			result= ReportStatus.HOSPITAL_VERIFY.getValue();
		}
		return result;
	}

	/**
	 * 获取查询报卡的查询条件
	 * @param form
	 * @param orgCode
	 * @return
	 */
	private Criteria getCriteria(ReportQueryForm form, String orgCode) {
		Criteria criteria1 = form.getDateCriteria(new Criteria());
//		Criteria criteria2 = form.getCriteria();
//		List<String> infectiousCodes = getInfectiousCodes(orgCode);
		//报卡状态是已审核 其防疫科将其传染病分给该用户
//		criteria1.add("INFECTIOUS_CODE", OP.IN, infectiousCodes);
//		criteria1.add("REPORT_STATUS", ReportStatus.HOSPITAL_VERIFY.getValue());
//		criteria1.add("fill_organ_code", orgCode);

		//报卡是当前用户填写且其状态不是已审核
//		criteria2.add("fill_organ_code", orgCode);

		return criteria1;
	}

	/**
	 * 根据当前用户的code和当前年份 从idm_setup表中获取当前用户所需管辖的个案
	 * @return
	 */
	private List<String> getInfectiousCodes(String orgCode) {
		List<String> infectiousCodes = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		Criteria criteria = new Criteria("SET_YEAR",calendar.get(Calendar.YEAR));
		criteria.add("CASE_ORGAN_CODE", orgCode);
		List<IdmSetup> idmSetupList = setupService.findSetup(criteria);
		if(ObjectUtil.isNotEmpty(idmSetupList)) {
			for(IdmSetup idmSetup : idmSetupList) {
				infectiousCodes.add(idmSetup.getInfectiousCode());
			}
		}
		return infectiousCodes;
	}

    /**
     * 设置外部报卡的参数对应
     * @param map
     * @return
     * @throws Exception
     */
    private IdmReport setReport(Map<String, Object[]> map) throws Exception {
        IdmReport report;
        String idCard = getFieldValue(map, "idcard");
        //有身份证，则先查健康档案该人是否存在。
        if(ObjectUtil.NotEmpty(idCard)){
            PersonInfo person = haInterfaceService.queryPersonalInfo(null, idCard);
            /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
            report = fillReport(map,person);
            /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
        }else{
        	 //没有身份证，则信息全是由参数组成
            report = fillReport(map,null);
        }
        report.setFillDate(new Date());
        //report.setDiagnosisDate(new Date());

        //整理好数据后，看现住址问题（先决条件：上报机构要存在）
        if(ObjectUtil.isNotEmpty(report.getFillOrganCode())){
            report = checkAddress(report);
        }
        //标记为外部报卡
        report.setReportSource(EHRConstants.REPORT_SOURCE_EXTERNAL);
        return report;
    }

    /**
     * 存在健康档案的信息，覆盖问题
     * 传的参数有则覆盖健康档案，没有使用健康档案
     * @param map
     * @param person
     * @return
     * @throws Exception
     */
    private IdmReport fillReport(Map<String, Object[]> map, PersonInfo person) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        IdmReport report = new IdmReport();

        if (ObjectUtil.isNotEmpty(person)) {
            report.setGender(person.getGender());

            //出生日期只能根据身份证来判断
            Date birthday = person.getBirthday();
            if(ObjectUtil.isNotEmpty(birthday)){
                String idcard = person.getIdcard();
                birthday = IDCardUtil.getBirthDateByIdCard(idcard);
                report.setBirthday(birthday);
            }
//            if (ObjectUtil.isNullOrEmpty(birthday)) {
//                String idcard = person.getIdcard();
//                if (ObjectUtil.isNotEmpty(idcard)) {
//                    birthday = IDCardUtil.getBirthDateByIdCard(idcard);
//                }
//                report.setBirthday(birthday);
//            }
            if(!ObjectUtil.isNullOrEmpty(person.getIdcard())){
                report.setAge(IDCardUtil.getAgeByIdCard(person.getIdcard())+"");
            }
            report.setAgeUnit("1");
            report.setPhoneNumber(person.getPhoneNumber());
            report.setUnitName(person.getUnitName());
            report.setOccupation(person.getOccupation());

            report.setInfectedpersonBelong(person.getHouseholdType());
            report.setPatownShip(person.getPatownShip());
            report.setPastreet(person.getPastreet());
            report.setPahouseNumber(person.getPahouseNumber());
            
            report.setHrtownShip(person.getHrtownShip());
            report.setHrstreet(person.getHrstreet());
            report.setHrhouseNumber(person.getHrhouseNumber());
            report.setNation(person.getNation());//民族
            report.setEducation(person.getEducation());//文化程度
			report.setMarriage(person.getMarriage());//婚姻状态
            /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
            report.setLogoff(person.getFilingFlag().equals("9")?1:0);//该人的状态：9注销，其他正常
            /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
        }else {//如果健康档案不存在此人信息，则初始化年龄、出生日期
        	String idcard = getFieldValue(map, "idcard");
        	if(IDCardUtil.validateCard(idcard)){
        		report.setAge(String.valueOf(IDCardUtil.getAgeByIdCard(idcard)));//年龄
        		report.setBirthday(IDCardUtil.getBirthDateByIdCard(idcard));//出生日期
        		report.setAgeUnit("1");
        	}
        }
        String value = "";
        for(Object o : map.keySet()){
            value = getFieldValue(map, o.toString());
            if(!value.isEmpty()){
                switch (o.toString()) {
                    case "name": report.setName(value); break;//患者姓名
                    case "idcard": report.setIdcard(value); break;//身份证号
                    case "gender": report.setGender(value); break;//性别
                    case "birthday":
                        if(ObjectUtil.NotEmpty(value)){
                            report.setBirthday(sdf.parse(value));//出生日期
                        };
                        break;
                    case "age": report.setAge(value); break;//年龄
                    case "ageUnit": report.setAgeUnit(value); break;//年龄单位
                    case "diseaseType": report.setInfectiousType(value); break;//传染病类型（甲、乙、丙）
                    case "diagnosisCode": report.setInfectiousCode(value); break;
                    case "fillOrganCode": report.setFillOrganCode(value); //上报机构编码
                        report.setFillOrganName(organizationApp.queryOrganName(value));
                        break;//上报机构名称
//                    case "reportDoctorId": report.setReportDoctorId(Long.parseLong("0")); break;//上报医生编码
                    case "reportDoctorName": report.setReportDoctorName(value); break;//上报医生名称
                    case "unitName": report.setUnitName(value); break;//工作单位
                    case "phoneNumber": report.setPhoneNumber(value); break;//联系电话
                    case "occupation": report.setOccupation(value); break;//职业
					case "marriage" : report.setMarriage(value); break;//婚姻
                    case "pathogenesisDate":
                        if(ObjectUtil.NotEmpty(value)){
                            report.setPathogenesisDate(sdf.parse(value));//发病日期
                        };
                        break;
                    case "diagnosisDate":
                        if(ObjectUtil.NotEmpty(value)){
                        	report.setDiagnosisDate(DateUtil.parseSimpleDate(value, "yyyy/MM/dd hh:mm:ss"));//诊断日期
                        };
                        break;
                    case "parentsName":
                    	report.setParentsName(value); break; //患儿家长姓名
                    case "caseCategoryFlag":
                    	report.setCaseCategoryFlag(value);
                    	break; //病例分类(2)
                    case "deathDate":
                    	if(ObjectUtil.NotEmpty(value)){
                            report.setDeathDate(sdf.parse(value));
                        };
                    	break; //死亡日期
                    case "amendName":
                    	report.setAmendName(value);
                    	break; //订正病名 
                    case "backCardCause":
                    	report.setBackCardCause(value);
                    	break; //退卡原因
                    case "fillOrganPhone":
                    	report.setFillOrganPhone(value);;
                    	break; //联系电话 
                    case "deleteContent":
                    	report.setDeleteContent(value);
                    	break; //作废原因: 
                    case "deleteContentOther":
                    	report.setDeleteContentOther(value);
                    	break; //作废原因 其他: 
                    case "comments":
                    	report.setComments(value);
                    	break; //备注 
                    case "infectedpersonBelong":
                    	report.setInfectedpersonBelong(value);
                    	break; 
                    case "pastreet":
                    	report.setPastreet(value);
                    	break;
                    case "patownShip":
                    	report.setPatownShip(value);
                    	break;
					case "paGroup":
						report.setPaGroup(value);
						break;
                    case "pahouseNumber":
                    	report.setPahouseNumber(value);
                    	break; 
                    case "caseCategory":
                    	report.setCaseCategory(value);
                    	break; //病例分类(1)
                    case "occupationOther":
                    	report.setOccupationOther(value);
                    	break; //职业其他
                    case "roleType":
                    	report.setRoleType(value);
                    	break; //上报人角色
                    case "approvalType":
                    	report.setApprovalFlg(value);
                    	break; //审核状态
                    case "education":
                    	report.setEducation(value);
                    	break;//文化程度
                }
            }
        }
        return report;

    }
    /**
     * 从外部报卡的url获取性病、乙肝、手足口的数值 
     * @param map
     * @return
     * @throws Exception
     */
    private IdmReportDesc fillReportDesc(Map<String, Object[]> map) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        IdmReportDesc report = new IdmReportDesc();
        String value = "";
        for(Object o : map.keySet()){
            value = getFieldValue(map, o.toString());
            if(!value.isEmpty()){
                switch (o.toString()) {
                    case "hbsagPositiveDt":
                    	report.setHbsagPositiveDt(value);
                    	break; //HBsAg阳性时间
                    case "hbvSignDt":
                    	report.setHbvSignDt(DateUtil.convert("yyyy/MM/dd", value));
                    	break; //首次出现乙肝症状和体征时间
                    case "alt":
                    	report.setAlt(value);;
                    	break; //本次ALT 
                    case "hbcCheckResult":
                    	report.setHbcCheckResult(value);
                    	break; //抗-HBc IgM 1:1000检测结果
                    case "punctureCheckResult":
                    	report.setPunctureCheckResult(value);
                    	break; //肝穿检测结果
                    case "hbsToPositive":
                    	report.setHbsToPositive(value);
                    	break; //恢复期血清HBsAg阴转，抗HBs阳转 
                    case "contactHistory":
                    	report.setContactHistory(value);
                    	break;//接触史
                    case "infectionWay":
                    	report.setInfectionWay(value);
                    	break; //最可能感染途径
                    case "sampleSource":
                    	report.setSampleSource(value);
                    	break; //样本来源
                    case "checkResult":
                    	report.setCheckResult(value);
                    	break; //实验室结果
                    case "severeCase":
                    	report.setSevereCase(value);
                    	break; //重症患者  
                }
            }
        }
        return report;

    }

    /**
     * 如果原来没有镇，则代入登陆或者报卡单位所在的镇
     * @param report
     * @return
     */
    private IdmReport checkAddress(IdmReport report){
        Organization organization = mdmOrganizationService.getOrganization(report.getFillOrganCode());
        //如果原来没有镇，则代入登陆或者报卡单位所在的镇,可能存在问题因为没有详细考虑
        if(ObjectUtil.isNullOrEmpty(report.getPatownShip()) && ObjectUtil.isNotEmpty(organization)){
            report.setPatownShip(organization.getGbCode());
        }
        return report;
    }

    /**
     * 判断疾病是否存在过报卡(同人同病同机构)
     * @param idcard  身份证
     * @param diagnosisCode 疾病编码（字典的）
     * @param organCode 上报机构code
     * @return returnFlag  没有true，有flase
     */
    private boolean checkReview(HttpServletRequest request, String idcard, String diagnosisCode, String organCode){
        Page page = super.getPage(request,  1);
        return checkReview(page, idcard, diagnosisCode, organCode);
    }

    private boolean checkReview(Page page, String idcard, String diagnosisCode, String organCode) {
        Criteria ca = new Criteria();
        ca.add("idcard", OP.LIKE, idcard);
        ca.add("infectiousCode", diagnosisCode);
        Date fillEndDate = new Date();
        Date fillBeginDate = DateUtil.add(fillEndDate, Calendar.DATE, -7);
        DateUtil.getCriteriaByDateRange(ca, "fillDate", fillBeginDate,fillEndDate);
        //外部报卡不要机构参数，中心要机构参数
        if(!ObjectUtil.isNullOrEmpty(organCode)){
            ca.add("fillOrganCode", organCode);
        }

        PageList<IdmReport> plist = reportService.findReport(ca, page);

        boolean returnFlag;
        //没有true，有flase
        if(ObjectUtil.isNullOrEmpty(plist) || ObjectUtil.isNullOrEmpty(plist.getList()) || plist.getList().size() <= 0){
            returnFlag =  true;
        }else{
            returnFlag = false;
        }
        return returnFlag;
    }

    /**
     * 判断疾病是否存在过报卡(同人同病，目前暂时乙肝需要判断)
     * @param idcard  身份证
     * @param diagnosisCode 疾病编码（字典的）
     * @return returnFlag  没有true，有flase
     */
    private boolean checkReview(HttpServletRequest request, String idcard, String diagnosisCode){
        Page page = super.getPage(request,  1);
        return checkReview(page, idcard, diagnosisCode);
    }

    /**
     * 判断疾病是否存在过报卡(同人同病，目前暂时乙肝需要判断)
     * @param idcard  身份证
     * @param diagnosisCode 疾病编码（字典的）
     * @return returnFlag  没有true，有flase
     */
    private boolean checkReview(Page page, String idcard, String diagnosisCode){
        Criteria ca = new Criteria();
        ca.add("idcard", idcard);
        ca.add("infectiousCode", diagnosisCode);
        ca.add("REPORT_STATUS", OP.NE, ReportStatus.CANCEL.getValue());
        PageList<IdmReport> plist = reportService.findReport(ca, page);

        boolean returnFlag;
        if(ObjectUtil.isNullOrEmpty(plist) || ObjectUtil.isNullOrEmpty(plist.getList()) || plist.getList().size() <= 0){
            returnFlag =  true;
        }else{
            returnFlag = false;
        }
        return returnFlag;
    }
    
    /**
     * map中获取String值 ,null则返回""
     *
     * @param map
     * @param key
     * @return
     */
    private String getFieldValue(Map<String, Object[]> map, String key) {
        if (!map.containsKey(key)) {
            return "";
        }
        return map.get(key)[0].toString();
    }

    private boolean saveDetail(HttpServletRequest request, final ReportDto reportDto, final long reportRecordId) throws Exception {
        final Page page = super.getPage(request,  1);
        //另开线程，为了报卡保存慢处理
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    boolean result = false;
                    boolean flag = true;
                    IdmReport reportInfo = reportDto.getReport();

                    User user =  new User();
//                user.setId(reportInfo.getReportDoctorId());
                    user.setName(reportInfo.getReportDoctorName());

                    Organization org = new Organization();
                    org.setOrganCode(reportInfo.getFillOrganCode());
                    org.setOrganName(reportInfo.getFillOrganName());

                    reportInfo.setPaAddress(reportInfo.getInfectedpersonBelong().equalsIgnoreCase("1")
                            ? dictionaryApp.queryDicItemName("FS990001", reportInfo.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", reportInfo.getPastreet()) + reportInfo.getPahouseNumber()
                            : reportInfo.getPahouseNumber());

                    reportInfo.setUpdateOrganCode(org.getOrganCode());
                    reportInfo.setUpdateOrganName(org.getOrganName());
                    reportInfo.setUpdateIdCard(user.getIdentityCard());
                    reportInfo.setUpdateName(user.getName());
                    reportInfo.setUpdateDate(new Date());
                    if(ObjectUtil.isNullOrEmpty(reportInfo.getCurrentFillTime())){
                    	reportInfo.setCurrentFillTime(new Date());
                    }
                    reportInfo.setReportSource(EHRConstants.REPORT_SOURCE_EXTERNAL);
                    Date diagnosisDate = reportInfo.getDiagnosisDate();
                    String diagnosisHMS = reportInfo.getDiagnosisHour();
                    String dateYMDStr = DateUtil.toDateString(diagnosisDate, "yyyy/MM/dd");
                    Date diagnosisDateReal = DateUtil.parseSimpleDate(dateYMDStr + " " + diagnosisHMS, "yyyy/MM/dd hh:mm:ss");
                    reportInfo.setDiagnosisDate(diagnosisDateReal);
                    //2017-08-14 需求  死亡日期增加时
                    Date deathDate = reportInfo.getDeathDate();
                    String deathHMS = reportInfo.getDeathHour();
       			 	if(StringUtil.isNotEmpty(deathHMS)){
                       String deathDateYMDStr = DateUtil.toDateString(deathDate, "yyyy/MM/dd");
                       Date deathDateReal = DateUtil.parseSimpleDate(deathDateYMDStr + " " + deathHMS, "yyyy/MM/dd hh");
                       reportInfo.setDeathDate(deathDateReal);
       			 	}
                    //2017-08-14 需求  填卡日期增加时分秒
                    Date fillDate = reportInfo.getFillDate();
       			 	String fillHMS = reportInfo.getFillHour();
       			 	if(StringUtil.isNotEmpty(fillHMS)){
                       String fillDateYMDStr = DateUtil.toDateString(fillDate, "yyyy/MM/dd");
                       Date fillDateReal = DateUtil.parseSimpleDate(fillDateYMDStr + " " + fillHMS, "yyyy/MM/dd hh:mm:ss");
                       reportInfo.setFillDate(fillDateReal);
       			 	}
                    Organization organ = organizationApp.queryOrgan(reportInfo.getFillOrganCode()) ;
                    RoleType role = getReportRole(organ);
                    result = reportService.createReport(reportDto,role,user, reportRecordId);
                    
                    //重卡已经在保存按钮之前判断了，保存后还是需要再判断重卡，但是不需要修改报卡监控的记录了
                    //查该患者是否报过卡（有身份证，是乙肝报卡时才查重）
                   /* 报卡不查重 2016-12-8
                    * if(ObjectUtil.isNotEmpty(reportInfo.getIdcard()) && reportInfo.getInfectiousCode().equals("2032")){
                        flag = checkReview(page,reportInfo.getIdcard(), reportInfo.getInfectiousCode());
                    }else if(!ObjectUtil.isNullOrEmpty(reportInfo.getIdcard())){//有身份证要判断该病一周之内有没有报过
                        //具体判断方法
                        flag= checkReview(page,reportInfo.getIdcard(), reportInfo.getInfectiousCode(), null);
                    }

                    if(flag){
                        if( "A1".equals(organ.getGenreCode())){
                            //A1市级医院
                            result = reportService.createReport(reportDto,RoleType.SJYYYS,user, reportRecordId);
                        }else {
                            //B1社区中心
                            result = reportService.createReport(reportDto,RoleType.YS,user, reportRecordId);
                        }
                    }*/
//                    else{
//                        result = reportRecordService.update(reportRecordId, null, EHRConstants.IDM_REPEAT) > 0 ? true : false;
//                    }
                }catch (Exception e){
                    logger.error("报卡保存失败！",e);
                }
            }
        }).start();
        return true;
    }
    
	/**
	 * 根据报卡监控记录获取报卡数据
	 *
	 * @param reportRecordId
	 * @return
	 * @author Ye jianfei
	 */
	private IdmReport fillReportFromRecord(Long reportRecordId){
		ReportRecord reportRecord = reportRecordService.getReportRecord(reportRecordId);
		String name = reportRecord.getName();
		String idCard = reportRecord.getIdcard();
        IdmReport report = new IdmReport();
        if (ObjectUtil.isNotEmpty(reportRecord)) {
        	report = reportRecord.getReport();
        	report.setFillDate(new Date());
        	report.setFillOrganName(organizationApp.queryOrgan(report.getFillOrganCode()).getOrganName());
        }
		if(StringUtil.isNotEmpty(idCard)){
			PersonInfo person = haInterfaceService.queryPersonalInfo(name, StringUtil.trimAllWhitespace(idCard));
			if(ObjectUtil.isNotEmpty(person)){
				if(StringUtil.isNullOrEmpty(report.getName())){
					report.setName(person.getName());
				}
				if(StringUtil.isNullOrEmpty(report.getGender())){
					report.setGender(person.getGender());
				}				
				if(StringUtil.isNullOrEmpty(report.getHealthFileNo())){
					report.setHealthFileNo(person.getHealthFileNo());
				}
				if(ObjectUtil.isNullOrEmpty(report.getBirthday())){
					Date birthday = person.getBirthday();
		            if(ObjectUtil.isNotEmpty(birthday)){
						report.setBirthday(person.getBirthday());
					}
		            if (ObjectUtil.isNullOrEmpty(birthday)) {
		                String idcard = person.getIdcard();
		                if (ObjectUtil.isNotEmpty(idcard)) {
		                    birthday = IDCardUtil.getBirthDateByIdCard(idcard);
		                }
		                report.setBirthday(birthday);
		            }
				}				
				if(StringUtil.isNullOrEmpty(report.getOccupation())){
					report.setOccupation(person.getOccupation());
				}				

				if(StringUtil.isNullOrEmpty(report.getPatownShip())){
					report.setPatownShip(person.getPatownShip());
				}	
				if(StringUtil.isNullOrEmpty(report.getPastreet())){
					report.setPastreet(person.getPastreet());
				}	
				if(StringUtil.isNullOrEmpty(report.getPahouseNumber())){
					report.setPahouseNumber(person.getPahouseNumber());
				}	
				if(StringUtil.isNullOrEmpty(report.getPaAddress())){
					report.setPaAddress(person.getPaAddress());
				}	
				if(StringUtil.isNullOrEmpty(report.getHrtownShip())){
					report.setHrtownShip(person.getHrtownShip());
				}	
				if(StringUtil.isNullOrEmpty(report.getHrstreet())){
					report.setHrstreet(person.getHrstreet());
				}	
				if(StringUtil.isNullOrEmpty(report.getHrhouseNumber())){
					report.setHrhouseNumber(person.getHrhouseNumber());
				}	
				if(StringUtil.isNullOrEmpty(report.getHrAddress())){
					report.setHrAddress(person.getHrAddress());
				}	

				if(StringUtil.isNullOrEmpty(report.getParentsName())){
					report.setParentsName(person.getFirstGuardian());
				}
				if(StringUtil.isNullOrEmpty(report.getHrAddress())){
					report.setHrAddress(person.getHrAddress());
				}
				if(StringUtil.isNullOrEmpty(report.getUnitName())){
					report.setUnitName(person.getUnitName());
				}
				if(StringUtil.isNullOrEmpty(report.getPhoneNumber())){
					report.setPhoneNumber(person.getPhoneNumber());
				}
				if(StringUtil.isNullOrEmpty(report.getUnitName())){
					report.setUnitName(person.getUnitName());
				}
				if(StringUtil.isNullOrEmpty(report.getInfectedpersonBelong())){
					report.setInfectedpersonBelong(person.getHouseholdType());
				}
				if(ObjectUtil.isNullOrEmpty(report.getLogoff())){
					report.setLogoff(person.getFilingFlag().equals("9")?1:0);//该人的状态：9注销，其他正常	
				}
				if(StringUtil.isNullOrEmpty(report.getEducation())){
					report.setEducation(person.getEducation());
				}
				if(StringUtil.isNullOrEmpty(report.getNation())){
					report.setNation(person.getNation());
				}
			}
		}        
		return report;
	} 
	
    private void updatePersonInfo(ReportDto reportDto, HttpServletRequest request) throws Exception {
    	if(ObjectUtil.isNotEmpty(reportDto.getReport())){
	    	reportDto.getReport().getPersonInfo().setUpdateOrganCode(getCurrentOrg(request).getOrganCode());
	    	reportDto.getReport().getPersonInfo().setUpdateOrganName(getCurrentOrg(request).getOrganName());
	    	reportDto.getReport().getPersonInfo().setUpdateName(getCurrentUser(request).getName());
	    	reportDto.getReport().getPersonInfo().setUpdateDate(new Date());
	    	reportDto.getReport().getPersonInfo().setUpdateIdcard(getCurrentUser(request).getIdentityCard()); 
    	}
    }

    /**
     * A、B类型传染病统计
     * * @return
     */
    @RequestMapping("/diseaseTypeSearch/index")
    public String diseaseTypeSearch(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("searchUrl", "/idm/report/diseaseTypeList/list");
        model.addAttribute("listpath", "diseaseTypeList.jsp");
        return "rhip.idm.statistics.diseaseTypeSearch";
    }

    /**
     * A、B类型传染病统计
     * @param request
     * @param form
     * @param model
     * @return
     */
    @RequestMapping("/diseaseTypeList/list")
    public String diseaseTypeList(HttpServletRequest request, TargetOrgQueryForm form, Model model) {
        initOrg(request, model);
        List<Map<String, Object>> plist = medicalTargetService.getDiseaseType(form.getParamMap());
        model.addAttribute("summaryList", plist);
        return "rhip.idm.statistics.diseaseTypeList";
    }

    protected void initOrg(HttpServletRequest request, Model model) {
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        model.addAttribute("currentBeginDate", DateUtil.firstDateOfMonth(new Date()));
        model.addAttribute("currentEndDate", DateUtil.lastDateOfMonth(new Date()));
    }

    /**
     * 近一年A、B类型传染病发病统计
     *
     * @param request
     * @return
     */
    @RequestMapping("/yearData")
    @ResponseBody
    public Object symptomData(HttpServletRequest request, String organCode, String gbCode) {
        List<Object[]> symptomdata1 = new ArrayList<>(12);
        List<Object[]> symptomdata2 = new ArrayList<>(12);
        Map<String, List<Object[]>> result = new HashMap<>();
        if(!organCode.isEmpty()) {
            int year = DateUtil.getCurrentYear();
            Calendar calendar = Calendar.getInstance();
            int month = calendar.get(Calendar.MONTH) + 1;
            Map<String, Object> monthMapA = new LinkedHashMap<>();
            Map<String, Object> monthMapB = new LinkedHashMap<>();
            for (int monthTemp = month + 1; monthTemp <= 12; monthTemp++) {
                monthMapA.put(String.valueOf(year - 1) + "/" + StringUtils.leftPad(String.valueOf(monthTemp), 2, "0"), "");
            }
            for (int monthTemp = 1; monthTemp <= month; monthTemp++) {
                monthMapA.put(String.valueOf(year) + "/" + StringUtils.leftPad(String.valueOf(monthTemp), 2, "0"), "");
            }
            monthMapB.putAll(monthMapA);


            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("organCode", organCode);
            paramMap.put("beginDate", String.valueOf(year - 1) + "/" + String.valueOf(month + 1));
            paramMap.put("endDate", DateUtil.toDateString(new Date(), "yyyy/MM"));
            paramMap.put("type", "A");
            List<Map<String, Object>> aResult = medicalTargetService.getDiseaseMonth(paramMap);
            paramMap.remove("type");
            paramMap.put("type", "B");
            List<Map<String, Object>> bResult = medicalTargetService.getDiseaseMonth(paramMap);

            for (String key : monthMapA.keySet()) {
                Object[] data = new Object[2];
                data[0] = DateUtil.parseSimpleDate(key, "yyyy/MM");
                data[1] = 0;
                for (Map<String, Object> mapTemp : aResult) {
                    if (key.equals(mapTemp.get("PMONTH"))) {
//                    monthMapA.put(key, mapTemp.get("ABCOUNT"));
                        data[1] = mapTemp.get("ABCOUNT");
                    }
                }
                result.put("dataA", symptomdata1);
                symptomdata1.add(data);
            }
            for (String key : monthMapB.keySet()) {
                Object[] data = new Object[2];
                data[0] = DateUtil.parseSimpleDate(key, "yyyy/MM");
                data[1] = 0;
                for (Map<String, Object> mapTemp : bResult) {
                    if (key.equals(mapTemp.get("PMONTH"))) {
//                    monthMapB.put(key, mapTemp.get("ABCOUNT"));
                        data[1] = mapTemp.get("ABCOUNT");
                    }
                }
                symptomdata2.add(data);
                result.put("dataB", symptomdata2);
            }
        }
        return result;
    }

	private boolean checkOrganCode(String orgCode) {
		Organization organization = organizationApp.queryOrgan(orgCode);
		return null != organization;
	}

}
