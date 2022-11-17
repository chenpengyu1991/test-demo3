package com.founder.rhip.ehr.controller;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.DeathInfo;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.ChildDeath;
import com.founder.rhip.ehr.entity.control.DeathMedicineCertificate;
import com.founder.rhip.ehr.entity.women.MaternalDeath;
import com.founder.rhip.ehr.service.IDeathMedicineCertificateService;
import com.founder.rhip.ehr.service.ILifeEventService;
import com.founder.rhip.ehr.service.personal.IPersonCanceledService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ihm.controller.form.DeathMedicineCertificateForm;
import com.founder.rhip.ihm.controller.form.HealthCardTargetForm;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.whch.service.IWhchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class LifeEventsController extends com.founder.rhip.mdm.controller.BaseController {

	@Resource(name = "lifeEventService")
	private ILifeEventService lifeEventService;

	@Resource(name = "personCanceledInfoService")
	private IPersonCanceledService personCanceledInfoService;

	@Resource(name = "deathMedicineCertificateService")
	private IDeathMedicineCertificateService deathMedicineCertificateService;

	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "whchService")
	private IWhchService whchService;

	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService personalRecordManagmentService;

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;

    @Resource(name = "platformService")
    private IPlatformService platformService;

	@RequestMapping("/life/events")
	public String searchIndex(HttpServletRequest request, HealthCardTargetForm form,
							  Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		return "rhip.ehr.life.index";
	}

	//查看生命周期详细信息
	@RequestMapping("/life/view")
	public String view(Long id, ModelMap model) {
		Criteria criteria = new Criteria("id", id);
		PersonDeathRecord personDeathRecord = lifeEventService.query(criteria);
		model.put("personDeathRecord", personDeathRecord);
		return "rhip.ehr.life.view";
	}

	@RequestMapping("/life/query")
	public String query(HttpServletRequest request, HealthCardTargetForm form,
						Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		PageList<PersonDeathRecord> pagelist = lifeEventService.queryList(form.getLifeEventCriteria(),page);
		getFilingFlag(pagelist.getList());
		model.addAttribute("lifeList", pagelist.getList());
		model.addAttribute("page", pagelist.getPage());
		CurrentLoginInfo loginInfo = (CurrentLoginInfo)getSessionObj("currentLoginInfo");
		model.addAttribute("loginUserName",loginInfo.getUser().getUserName());
		return "rhip.ehr.life.query";
	}

	/**
	 * 获取关联档案建档状态
	 * @param personDeathRecords
	 */
	private void getFilingFlag(List<PersonDeathRecord> personDeathRecords){
		for(PersonDeathRecord record : personDeathRecords){
			Long personId = record.getPersonId();
			if(ObjectUtil.isNotEmpty(personId)){
				PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id",personId));
				if(ObjectUtil.isNotEmpty(personInfo)){
					String filingFlag = personInfo.getFilingFlag();
					record.setFilingFlag(filingFlag);
					//如果健康档案是注销状态，则生命事件中是注销状态
					if(EHRConstants.HAD_OFF.equals(filingFlag)){
						record.setCancelStatus("1");
					}
				}
			}
		}

	}
	@RequestMapping("/life/importExcel")
	public String importExcel(HttpServletRequest request, HealthCardTargetForm form,
							  Model model) {
		return "rhip.ehr.life.importExcel";
	}

	@RequestMapping("/life/upload")
	@ResponseBody
	public ModelMap upload(@RequestParam("file") CommonsMultipartFile file, HttpServletResponse response) throws IOException {
		ModelMap model = new ModelMap();
		try {
			List<String> errorMsgs = new ArrayList<String>();
			List<Record> list = readXlsFile(file.getInputStream());
			List<PersonDeathRecord> personList = new ArrayList<PersonDeathRecord>();
			List<DeathMedicineCertificate> deathMedicineCertificatesList = new ArrayList<DeathMedicineCertificate>();
			//add by yjf  20160113
			List<ChildDeath> childDeaths = new ArrayList<ChildDeath>();
			List<MaternalDeath> maternalDeaths = new ArrayList<MaternalDeath>();
			int totalCount = 0;
			int currentCount = 0;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			for(Record record : list){
				PersonDeathRecord pdr = new PersonDeathRecord();
				DeathMedicineCertificate dmc = new DeathMedicineCertificate();
				ChildDeath childDeath = new ChildDeath();
				MaternalDeath maternalDeath = new MaternalDeath();
				//modify by yejianfei 20160531
				//只需要导入必填字段：身份证、乡(镇、街道办事处)编码、死亡日期、录入机构编码、人群分类
				String idcard = (String)record.get("idcard");
				idcard = strSub(idcard);
				if(StringUtil.isNotEmpty(idcard) && (idcard.length() != 15 && idcard.length() != 18)){
					addErrorMsg(errorMsgs,"身份证号长度不正确！");
					continue;
				}else if (StringUtil.isEmpty(idcard)){
				}else{
					pdr.setIdcard(idcard);
					dmc.setIdcard(idcard);
					maternalDeath.setIdcard(idcard);
					PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("IDCARD",idcard));
					if(ObjectUtil.isNotEmpty(personInfo)){
						pdr.setPersonId(personInfo.getId());
						dmc.setPersonId(personInfo.getId());
						maternalDeath.setPersonId(personInfo.getId());
					}
				}
				PersonDeathRecord persondr = lifeEventService.query(new Criteria("idcard",idcard));
				if(persondr != null){
					addErrorMsg(errorMsgs,"身份证号("+idcard+")重复导入!");
					continue;
				}
				String name = (String)record.get("name");
				if(StringUtil.isNullOrEmpty(name)){
					addErrorMsg(errorMsgs,"姓名不能为空！");
					continue;
				}else if(this.judgeLength(name, 50, errorMsgs, "姓名")){
					pdr.setName(name);
					dmc.setName(name);
					childDeath.setChildName(name);
					maternalDeath.setName(name);
				} else {
					continue;
				}
//				String patownShip = (String)record.get("patownShip");
//				patownShip = strSub(patownShip);
//				if(StringUtil.isNullOrEmpty(patownShip)){
//					addErrorMsg(errorMsgs,"乡(镇、街道办事处)编码不能为空！");
//					continue;
//				}else{
//					dmc.setPatownShip(patownShip);
//					childDeath.setPatownShip(patownShip);
//				}
				if(record.get("deathDate") == null){
					addErrorMsg(errorMsgs,"死亡日期不能为空！");
					continue;
				}else{
					try {
						pdr.setDeathDate(sdf.parse((String)record.get("deathDate")));
						dmc.setDeathDate(sdf.parse((String)record.get("deathDate")));
						childDeath.setDeathDate(sdf.parse((String)record.get("deathDate")));
						maternalDeath.setDeathDate(sdf.parse((String)record.get("deathDate")));
					} catch (Exception e) {
						addErrorMsg(errorMsgs,"死亡日期格式不正确，应为yyyy-mm-dd hh:mm:ss！");
						continue;
					}
				}
				String deathIcd10 = (String)record.get("deathIcd10");
				if(this.judgeLength(deathIcd10, 5, errorMsgs, "根本死因代码")){
					pdr.setDeathIcd(deathIcd10);
					dmc.setUnderlyingDeathCode(deathIcd10);
					childDeath.setDeathCauseCode(deathIcd10);
					maternalDeath.setDeathCauseCode(deathIcd10);
				} else {
					continue;
				}
				String deathReason = (String)record.get("deathReason");
				if(this.judgeLength(deathReason, 200, errorMsgs, "根本死亡原因名称")){
					pdr.setDeathReason(deathReason);
				} else {
					continue;
				}
				if(record.get("inputOrgancode") == null){
					addErrorMsg(errorMsgs,"录入机构编码不能为空！");
					break;
				}else{
					pdr.setInputOrgancode((String) record.get("inputOrgancode"));
					dmc.setFillOrganCode((String) record.get("inputOrgancode"));
					childDeath.setFillUnitCode((String)record.get("inputOrgancode"));
					maternalDeath.setFillUnitCode((String)record.get("inputOrgancode"));
				}
				String personType = (String)record.get("personType");
				personType = judgeNumber(personType,"#.0");
				if(this.judgeLength3(personType, 2, errorMsgs, "人群分类")){
					pdr.setPersonType(personType);
					//dmc.setDeathHighEvidenceTypeCode(deathBasis);
				} else {
					pdr.setPersonType("1");//1标识其他人群
				}
				pdr.setCancelStatus("0");
				dmc.setIsDelete(0);
				setOperator(pdr);
				personList.add(pdr);
				deathMedicineCertificatesList.add(dmc);
				//1	其他
				//2	孕产妇
				//3	5岁以下儿童
				//婴儿死亡数据
				if("3".equals(personType)){
					Date deathDate = DateUtil.parseSimpleDate((String)record.get("deathDate"), "yyyy-MM-dd hh:mm:ss");
					double childDeathAge = 0;
					Integer deathAgeYear = 0;
					if(StringUtil.isNotEmpty(idcard)){
						Date childBirthday = IDCardUtil.getBirthDateByIdCard(idcard);
						childDeathAge = DateUtil.getAgeByBirthday(childBirthday,deathDate);
						deathAgeYear = NumberUtil.convert(Math.floor(childDeathAge),Integer.class);
					}
					childDeath.setDeathAgeYear(deathAgeYear);
					childDeaths.add(childDeath);
				}
				//孕产妇死亡数据
				if("2".equals(personType)){
					maternalDeaths.add(maternalDeath);
				}
				log.debug("当前序号：" + currentCount);
				//分批导入数据库
				if(++currentCount >=100){
					log.debug("保存生命事件：" + totalCount);
					lifeEventService.batchSave(personList, deathMedicineCertificatesList,childDeaths,maternalDeaths);
					personList.clear();
					deathMedicineCertificatesList.clear();
					childDeaths.clear();
					maternalDeaths.clear();
					currentCount = 0;
				}
				totalCount++;
			}

			lifeEventService.batchSave(personList,deathMedicineCertificatesList,childDeaths,maternalDeaths);
			String message = "总共导入" + list.size() + "条机构，成功" + totalCount+ "条，失败" + (list.size() - totalCount) + "条\r\n";
			if(errorMsgs.size() > 0){
				message+= getErrorMsg(errorMsgs);
			}
			model.addAttribute("message", message);
			model.addAttribute("result", true);
		}catch (Exception e) {
			log.error("导入出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", "导入出错"+e.getMessage());
		}
		return model;
	}

	/**
	 * 设置操作者信息
	 * @param record
	 */
	private void setOperator(PersonDeathRecord record){
		CurrentLoginInfo loginInfo = (CurrentLoginInfo)getSessionObj("currentLoginInfo");
		record.setInputDate(new Date());
		record.setInputIdcard(loginInfo.getUser().getIdentityCard());
		//record.setInputOrgancode(loginInfo.getOrganization().getOrganCode());
		record.setInputUser(loginInfo.getUser().getUserName());
	}
	/**
	 * EXCEL中数值型字符串导入成浮点型，转换成整形
	 * @param str
	 * @param format
	 * @return
	 */
	private String judgeNumber(String str,String format){
		String result = str;
		if(NumberUtil.isDecimal(str)){
			Integer strInt = NumberUtil.convert(str,Integer.class,new DecimalFormat(format));
			result = strInt.toString();
		}
		return result;
	}
	private boolean judgeLength(String str, int length, List<String> errorMsgs, String msg) {
		if(StringUtil.isNotEmpty(str) && str.length() > length) {
			addErrorMsg(errorMsgs, msg + "请不要超过" + length + "汉字");
			return false;
		}
		return true;
	}

	private boolean judgeLength2(String str, int length, List<String> errorMsgs, String msg) {
		if(StringUtil.isNotEmpty(str) && str.length() > length) {
			addErrorMsg(errorMsgs, msg + "必须输入整数，范围0-99");
			return false;
		}
		return true;
	}


	private boolean judgeLength3(String str, int length, List<String> errorMsgs, String msg) {
		if(StringUtil.isNotEmpty(str) && str.length() > length) {
			addErrorMsg(errorMsgs, msg + "请不要超过" + length + "字符");
			return false;
		}
		return true;
	}

	public boolean validateDict(IDictionaryApp dictionaryApp, String dicCode, String key, List<String> errorMsgs, String msg) {
		if (StringUtil.isEmpty(key)) {
			return false;
		}
		Map<String, String> dictMap = dictionaryApp.queryDicItemMap(dicCode);
		if (!dictMap.containsKey(key)) {
			addErrorMsg(errorMsgs,msg + "不合法");
			return false;
		}
		return true;
	}

	public boolean validateDict(Object[] dict, Object value, List<String> errorMsgs, String msg) {
		if (ObjectUtil.isNullOrEmpty(value)) {
			return false;
		}
		for (Object obj : dict) {
			if (value.equals(obj)) {
				return true;
			}
		}
		addErrorMsg(errorMsgs,msg + "不合法");
		return false;
	}

	private void addErrorMsg(List<String> errorMsg, String text){
		if(errorMsg.contains(text)) return;
		if(errorMsg.size() < 10) {
			errorMsg.add(text);
		} else if(errorMsg.size()==10) {
			errorMsg.add(text);
			errorMsg.add("......");
		}
	}

	private String getErrorMsg(List<String> errorMsg){
		String msg = "";
		for(String str : errorMsg){
			msg+= str+"\r\n";
		}
		return msg;
	}

	private List<Record> readXlsFile(InputStream in) throws Exception{
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

	@RequestMapping("/life/cancel")
	public @ResponseBody
	String cancel(HttpServletRequest request, ModelMap model) {
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo)request.getSession().getAttribute("currentLoginInfo");
		String msg = personCanceledInfoService.cancelPersonByIdcard(currentLoginInfo, getRequestIp(request));
		if(StringUtil.isEmpty(msg)){
			msg = "结案成功!";
		}
		model.addAttribute("message", msg);
		return msg;
	}


	/**
	 * 档案激活
	 *
	 * @param recordId
	 * @return
	 */
	@RequestMapping("/life/personOffActive")
	public @ResponseBody
	String personOffActive(@RequestParam(value = "recordId") Long recordId,@RequestParam(value = "filingFlag") String filingFlag) {
		return lifeEventService.activePersonRecord(recordId,filingFlag);
	}

	@RequestMapping("/life/downTemplate")
	@ResponseBody
	public void downTemplate(HttpServletResponse response, String format) throws IOException {
		String fileName = "xls".equals(format) ? "lifeEvent.xls" : "lifeEvent.xlsx";
		setExcelDownLoadResponse(response, fileName, format);
		downFile("../views/life/template/"+fileName, response);
	}

	@RequestMapping("/life/deathMedicineCertificate")
	public String deathMedicineCertificate(HttpServletRequest request, Model model) {
		Page page = new Page(0,0);
		model.addAttribute("pageIndex", page);
		model.addAttribute("page", page);
		return "rhip.ehr.life.deathMedicineCertificate.index";
	}

	@RequestMapping("/life/deathMedicineCertificate/search")
	public String deathMedicineCertificateSearch(HttpServletRequest request, DeathMedicineCertificateForm form,
												 Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		PageList<DeathMedicineCertificate> pagelist = deathMedicineCertificateService.queryList(form.getCriteria(), page);
		model.addAttribute("deathMedicineCertificateList", pagelist.getList());
		model.addAttribute("page", pagelist.getPage());
		return "rhip.ehr.life.deathMedicineCertificate.list";
	}

	@RequestMapping("/life/deathMedicineCertificate/view")
	public String deathMedicineCertificateView(String id, Model model) {
		Criteria criteria = new Criteria("ID", id);
		DeathMedicineCertificate deathMedicineCertificate = deathMedicineCertificateService.getDeathMedicineCertificate(criteria);
		if(ObjectUtil.isNullOrEmpty(deathMedicineCertificate)){
			return "rhip.ehr.browser.error";
		}
		model.addAttribute("personInfo", deathMedicineCertificate);
		return "rhip.ehr.life.deathMedicineCertificate.view";
	}
	
	@RequestMapping("/life/deathMedicineCertificate/queryPersonInfo")
	@ResponseBody
	public Map<String, Object>  loadPersonInfo(HttpServletRequest request, Model model, @RequestParam("idcard") String idcard) {
		DeathMedicineCertificate deathMedicineCertificate = deathMedicineCertificateService.getDeathMedicineCertificate(new Criteria("idcard",idcard));
        if(ObjectUtil.isNotEmpty(deathMedicineCertificate)){
			if(ObjectUtil.equals("1",deathMedicineCertificate.getCancelStatus())){
				Map<String, Object> re = new HashMap<String, Object>();
				re.put("msg","该人员已结案！");
				return re;
			}else if(ObjectUtil.isNullOrEmpty(deathMedicineCertificate.getIsDelete())|| ObjectUtil.equals(0,deathMedicineCertificate.getIsDelete())){
				Map<String, Object> re = new HashMap<String, Object>();
				re.put("msg","该人员已登记！");
				return re;
			}
        }
		PersonInfo personInfo = platformService.queryPersonalInfo(new Criteria("idcard", StringUtil.trimAllWhitespace(idcard)).add("filingFlag", OP.NE, "9"));
        
        /*if (ObjectUtil.isNullOrEmpty(personInfo)) {
			Map<String, Object> re = new HashMap<String, Object>();
			re.put("msg","该人员未建档！");
            return re;
        }*/
        if (ObjectUtil.isNotEmpty(personInfo)) {
            getPersonAddress(personInfo);
        }else{
			personInfo = new PersonInfo();
			personInfo.setIdcard(idcard);
		}
        Map<String, Object> record = new Record(personInfo);
        Date birthday = setBirthday(personInfo);
        if (ObjectUtil.isNotEmpty(birthday)) {
            SimpleDateFormat df = new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN);
            record.put("birthdayStr", df.format(birthday));
        }
        if (ObjectUtil.isNotEmpty(personInfo.getInputDate())) {
            SimpleDateFormat df = new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN);
            record.put("inputDateStr", df.format(personInfo.getInputDate()));
        }
        return record;
	    
	}
	
	@RequestMapping("/life/deathMedicineCertificate/add")
	public String addDeathMedicineCertificate(HttpServletRequest request, Model model) {
		return "rhip.ehr.life.deathMedicineCertificate.add";
	}
	
	@RequestMapping("/life/deathMedicineCertificate/update")
	public String addDeathMedicineCertificate(HttpServletRequest request, Model model, Long id) {
		DeathMedicineCertificate dmc = new DeathMedicineCertificate();
		if(ObjectUtil.isNotEmpty(id)){
			dmc = deathMedicineCertificateService.getDeathMedicineCertificate(new Criteria("id",id));
			
		}
		model.addAttribute("personInfo", dmc);
		return "rhip.ehr.life.deathMedicineCertificate.update";
	}

	@RequestMapping("/life/deathMedicineCertificate/save")
	@ResponseBody
	public Map<String, Object>  saveDeathMedicineCertificate(HttpServletRequest request, Model model, DeathMedicineCertificate deathInfo ) {
		Map<String, Object> map = new HashMap<>();
		boolean result = false;
		if (ObjectUtil.isNotEmpty(deathInfo)) {
			DeathMedicineCertificate existed = deathMedicineCertificateService.getDeathMedicineCertificate(new Criteria("idcard",deathInfo.getIdcard()).add(new Criteria("isDelete", 0).add(LOP.OR, "isDelete", OP.IS, "NULL")));
			int  r = 0;
			if(ObjectUtil.isNotEmpty(existed) ){
				if(!existed.getCancelStatus().equals("1")){
					deathInfo.setCancelStatus("0");
					deathInfo.setId(existed.getId());
					r = deathMedicineCertificateService.update(deathInfo);
				}
	        }else{
	        	deathInfo.setCancelStatus("0");
	        	r = deathMedicineCertificateService.save(deathInfo);
	        }
            
             if (r!=0){
				 result = true;
			 }
        }
        map.put("result", result);
		return map;
	}
	@RequestMapping("/life/deathMedicineCertificate/delete")
	@ResponseBody
	public Map<String, Object>  deleteDeathMedicineCertificate(HttpServletRequest request, Model model, Long id ) {
		Map<String, Object> map = new HashMap<>();
		boolean result = false;
		DeathMedicineCertificate dmc = new DeathMedicineCertificate();
		dmc.setId(id);
		dmc.setIsDelete(1);
		int  r = deathMedicineCertificateService.deleteChildDeath(dmc);
        if (r==1){
        	result = true;
		}
        map.put("result", result);
		return map;
	}
	
	@RequestMapping("/life/query/deathInfo")
	public String queryDeathInfo(HttpServletRequest request, HealthCardTargetForm form,
						Model model) {
		int currentPage = Integer.valueOf(request.getParameter("indexPage"));
		Page page = super.getPage(request, currentPage);
		PageList<DeathInfo> pagelist = deathMedicineCertificateService.queryDeathInfoList(form.getLifeEventCriteria(),page);
		model.addAttribute("lifeList", pagelist.getList());
		model.addAttribute("page", pagelist.getPage());
		CurrentLoginInfo loginInfo = (CurrentLoginInfo)getSessionObj("currentLoginInfo");
		model.addAttribute("loginUserName",loginInfo.getUser().getUserName());
		return "rhip.ehr.life.query";
	}
	
	@RequestMapping("/life/view/deathInfo")
	public String viewDeathInfo(Long id, ModelMap model) {
		Criteria criteria = new Criteria("id", id);
		DeathInfo personDeathRecord = deathMedicineCertificateService.queryDeathInfo(criteria);
		model.put("personInfo", personDeathRecord);
		return "rhip.ehr.life.deathMedicineCertificate.view.deathInfo";
	}


	protected void setExcelDownLoadResponse(HttpServletResponse response, String fileName, String format) {
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		response.setContentType("text/"+format);
	}

	/**
	 * 去掉excel导入后的数字中文格式时候的.0
	 * @param target
	 * @return
	 */
	private String strSub(String target){
		if(!StringUtil.isNullOrEmpty(target) && target.indexOf(".0")!=-1){
			target = target.substring(0,target.indexOf(".0"));
		}
		return target;
	}
	
	private void getPersonAddress(PersonInfo personInfo) {
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
	 * 如果人员生日为空,则根据身份证设置生日
	 * 
	 * @param personInfo
	 * @return
	 */
	private Date setBirthday(PersonInfo personInfo) {
		Date birthday = personInfo.getBirthday();
		if (ObjectUtil.isNullOrEmpty(birthday)) {
			String idcard = personInfo.getIdcard();
			if (ObjectUtil.isNotEmpty(idcard)) {
				// 如果没有生日,根据身份证算出
				birthday = IDCardUtil.getBirthDateByIdCard(idcard);
				personInfo.setBirthday(birthday);
			}
		}
		return birthday;
	}

}
