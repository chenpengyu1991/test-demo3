package com.founder.rhip.idm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.ExcelUtils;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.ListEfc;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.ListEs;
import com.founder.rhip.idm.dto.CaseDto;
import com.founder.rhip.idm.service.ICaseSurveyService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 个案处置管理
 */
@Controller
@RequestMapping("/idm/case/import")
public class CaseImportController extends BaseController {

    @Resource(name = "caseSurveyService")
    private ICaseSurveyService caseSurveyService;
    
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	/**
	 * 进入导入画面-密切接触者
	 * @param infectiousCode
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showContactedImport")
	public String showImport(String infectiousCode, ModelMap model, HttpServletRequest request) {
		model.put("infectiousCode", infectiousCode);
		return "rhip.idm.case.contactedImport";
	}

	@RequestMapping("/downloadContactedTemplet")
	public void downloadStudentTemplet(HttpServletResponse response,String infectiousCode) throws Exception {
		String templetName = getContactedTempletName(infectiousCode);
		ExcelUtils excel = new ExcelUtils(getExcelPath("../views/idm/template/" + templetName));
		setExcelContent(response, "密切接触者导入模板.xls");
		excel.save(response.getOutputStream());
	}


	/**
	 * 查询晚血病人列表
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/contactedList")
	public String contactedList(String infectiousCode, Long idmId, HttpServletRequest request, ModelMap model) {
		Criteria ca = new Criteria("IDM_ID", OP.EQ,idmId);
		CaseDto caseDto;
		if(infectiousCode.equals("3111")){
			caseDto = caseSurveyService.findcontact(ca);//手足口病，患者接触史存储在不同的表中
		}else{
			caseDto = caseSurveyService.findcontacted(ca);
		}
        model.addAttribute("caseDto", caseDto);
		return getContactedListName(infectiousCode);
	}
	
	@RequestMapping("/uploadContacted")
	@ResponseBody
	public ModelMap uploadContacted(HttpServletRequest request, @RequestParam("qqfile") MultipartFile file, String infectiousCode, Long idmId) {
		ModelMap model = new ModelMap();
		try {
			InputStream in = file.getInputStream();
			try {
				int count = 0;
				ExcelUtils excelUtils = new ExcelUtils(in);
				if(infectiousCode.equals("3111")){
					List<ListEs> dataList = readDataEs(excelUtils);
					if (ObjectUtil.isNullOrEmpty(dataList)) {
						model.addAttribute("success", false);
						model.addAttribute("message", "导入密切接触者数据为空");
						return model;
					}
					List<String> msg = validateDataHfmdEs(dataList);
					if (msg != null && msg.size()>0) {
						model.addAttribute("success", false);
						model.addAttribute("message", "导入密切接触者数据失败，" + StringUtil.join(msg));
						return model;
					}
					initFullDataEs(dataList, idmId);
					count = caseSurveyService.importEsContactDatas(dataList);
					model.addAttribute("message", "总共导入"+dataList.size()+"条密切接触者数据，成功"+count+"条，失败"+(dataList.size() - count)+"条");
					
				}else{
					List<ListEfc> dataList = readData(excelUtils,infectiousCode);
					if (ObjectUtil.isNullOrEmpty(dataList)) {
						model.addAttribute("success", false);
						model.addAttribute("message", "导入密切接触者数据为空");
						return model;
					}
					List<String> msg = validateData(dataList,infectiousCode);
					if (msg != null && msg.size()>0) {
						model.addAttribute("success", false);
						model.addAttribute("message", "导入密切接触者数据失败，" + StringUtil.join(msg));
						return model;
					}
					initFullData(dataList, idmId);
					count = caseSurveyService.importContactedDatas(dataList);
					model.addAttribute("message", "总共导入"+dataList.size()+"条密切接触者数据，成功"+count+"条，失败"+(dataList.size() - count)+"条");
				}
				model.addAttribute("success", true);
				
			} finally {
				in.close();
			}
		} catch (Exception e) {
			logger.error("导入密切接触者数据出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
			return model;
		}
		return model;
	}

	 /**
     * 保存未提交密切接触者信息
     *
     * @param caseDto
     * @param request
     * @param model
     * @return
     */
    @SuppressWarnings("unchecked")
	@RequestMapping("/save")
    public String save(CaseDto caseDto, String infectiousCode, HttpServletRequest request, ModelMap model) throws Exception {
        String idmId = caseDto.getIdmId();
        if (!StringUtil.isNotEmpty(idmId)) {
            return EHRMessageUtil.returnMsg(model, "fail");
        }
        boolean result = false;
        if (ObjectUtil.isNotEmpty(caseDto)) {
        	if(infectiousCode.equals("3111")){
                // 添加患者接触史
                String esList = caseDto.getEsList();
                if (StringUtil.isNotEmpty(esList)) {
                    List<ListEs> idmListEs = (List<ListEs>) json2Obj(esList, ListEs.class);
                    caseDto.setIdmListEsList(idmListEs);
                }
                result = caseSurveyService.saveCaseEs(caseDto);       		
        	}else{
                // 添加密切接触者
                String efcList = caseDto.getEfcList();
                if (StringUtil.isNotEmpty(efcList)) {
                    List<ListEfc> idmListEfc = (List<ListEfc>) json2Obj(efcList, ListEfc.class);
                    caseDto.setIdmListEfcList(idmListEfc);
                }
                result = caseSurveyService.saveCaseEfc(caseDto);        		
        	}

        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }
    /**
     * 获取模板名称
     * @param dataList
     * @return List<String>
     */	
	private String getContactedTempletName(String infectiousCode){
		String result = "";
		switch (infectiousCode){
			case "101":
				result = "contactedPlagueTemplet.xls";
				break;
			case "2011":
				result = "contactedSarsFamilyTemplet.xls";
				break;
			case "2012":
				result = "contactedSarsWorkOrgTemplet.xls";
				break;
			case "2031":
				result = "contactedHavTemplet.xls";
				break;	
			case "205":
				result = "contactedHiwhpaiTemplet.xls";
				break;
			case "2131":
				result = "contactedDysenteryTemplet.xls";
				break;	
			case "216":
				result = "contactedMeningitisTemplet.xls";
				break;	
			case "220":
				result = "contactedScarlatinaTemplet.xls";
				break;	
			case "306":
				result = "contactedTyphusFeverTemplet.xls";
				break;
			case "3111":
				result = "contactHfmdTemplet.xls";
				break;				
		}
		return result;
	}
	
    /**
     * 获取密切接触者列表页面
     * @param dataList
     * @return List<String>
     */	
	private String getContactedListName(String infectiousCode){
		String result = "";
		switch (infectiousCode){
			case "101":
				result = "rhip.idm.case.plague.contactedList";
				break;
			case "2011":
				result = "rhip.idm.case.sars.contactedFamilyList";
				break;	
			case "2012":
				result = "rhip.idm.case.sars.contactedWorkOrgList";
				break;
			case "2031":
				result = "rhip.idm.case.hav.contactedList";
				break;	
			case "205":
				result = "rhip.idm.case.hiwhpai.contactedList";
				break;	
			case "2131":
				result = "rhip.idm.case.dysentery.contactedList";
				break;	
			case "216":
				result = "rhip.idm.case.meningitis.contactedList";
				break;
			case "220":
				result = "rhip.idm.case.scarlatina.contactedList";
				break;	
			case "306":
				result = "rhip.idm.case.typhusFever.contactedList";
				break;	
			case "3111":
				result = "rhip.idm.case.hfmd.contactList";
				break;
			case "3112":
				result = "rhip.idm.case.hfmd.contactedList";
				break;					
		}
		return result;
	}
    /**
     * 导入密切接触者-数据验证-手足口病-患者接触史
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataHfmdEs(List<ListEs> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEs es = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", es.getName(), ret);
			validateDict(dictionaryApp, "性别", "GBT226112003", es.getSex(), ret);
			if (ret.size() > 1) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}
	
    /**
     * 导入密切接触者-数据验证
     * @param dataList
     * @return List<String>
     */	
	private List<String> validateData(List<ListEfc> dataList, String infectiousCode) {
		List<String> msg = new ArrayList<String>();
		switch (infectiousCode){
			case "101":
				msg	=	validateDataPlague(dataList);
				break;
			case "2011":
				msg = validateDataSarsFamily(dataList);
				break;
			case "2012":
				msg = validateDataSarsWorkOrg(dataList);
				break;
			case "2031":
				msg = validateDataHav(dataList);
				break;	
			case "205":
				msg = validateDataHiwhpai(dataList);
				break;	
			case "2131":
				msg = validateDataDysentery(dataList);
				break;
			case "216":
				msg = validateDataMeningitis(dataList);
				break;	
			case "220":
				msg = validateDataScarlatina(dataList);
				break;
			case "306":
				msg = validateDataTyphusFever(dataList);
				break;	
			case "3112":
				msg = validateDataHfmd(dataList);
				break;					
		}
		return msg;
	}

    /**
     * 导入密切接触者-数据验证-手足口病
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataHfmd(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", efc.getName(), ret);
			validateDict(dictionaryApp, "性别", "GBT226112003", efc.getSex(), ret);
			validateDict(dictionaryApp, "发病是否", "PH00001", efc.getAttack(), ret);
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}
	
    /**
     * 导入密切接触者-数据验证-流行性、地方性斑疹伤寒
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataTyphusFever(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", efc.getName(), ret);
			validateObject("性别", efc.getSex(), ret);
			validateDict(dictionaryApp, "性别", "GBT226112003", efc.getSex(), ret);
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}
	
    /**
     * 导入密切接触者-数据验证-猩红热
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataScarlatina(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", efc.getName(), ret);
			validateObject("性别", efc.getSex(), ret);
			validateDict(dictionaryApp, "性别", "GBT226112003", efc.getSex(), ret);
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}
	
    /**
     * 导入密切接触者-数据验证-流行性脑脊髓膜炎
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataMeningitis(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", efc.getName(), ret);
			validateDict(dictionaryApp, "性别", "GBT226112003", efc.getSex(), ret);
			validateDict(dictionaryApp, "接触情况", "IDM00057", efc.getContactType(), ret);
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}
	
    /**
     * 导入密切接触者-数据验证-细菌性和阿米巴性痢疾
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataDysentery(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", efc.getName(), ret);
			validateObject("是否发病", efc.getAttack(), ret);
			if("1".equals(efc.getAttack())){//如果发病，发病日期也为必填项目
				validateObject("发病日期", efc.getAttackDt(), ret);
			}
			validateDict(dictionaryApp, "性别", "GBT226112003", efc.getSex(), ret);
			validateDict(dictionaryApp, "关系", "IDM00018", efc.getRelation(), ret);
			validateDict(dictionaryApp, "是否发病", "PH00002", efc.getAttack(), ret);
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}
	
    /**
     * 导入密切接触者-数据验证-人感染高致病性禽流感
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataHiwhpai(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", efc.getName(), ret);
			
			validateDict(dictionaryApp, "性别", "GBT226112003", efc.getSex(), ret);

			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}
	
    /**
     * 导入密切接触者-数据验证-甲型（戊型）肝炎
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataHav(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", efc.getName(), ret);
			validateObject("性别", efc.getSex(), ret);
			validateObject("关系", efc.getRelation(), ret);
			validateDict(dictionaryApp, "性别", "GBT226112003", efc.getSex(), ret);
			validateDict(dictionaryApp, "是否发病", "PH00001", efc.getAttack(), ret);

			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}
	
    /**
     * 导入密切接触者-数据验证-鼠疫
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataPlague(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("姓名", efc.getName(), ret);
			
			validateDict(dictionaryApp, "性别", "GBT226112003", efc.getSex(), ret);
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}

    /**
     * 导入密切接触者-数据验证-传染性非典型肺炎-家庭、亲友
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataSarsFamily(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("接触者姓名", efc.getName(), ret);

			
			validateDict(dictionaryApp, "性别", "GBT226112003", efc.getSex(), ret);
			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}
	
    /**
     * 导入密切接触者-数据验证-传染性非典型肺炎-工作单位或主要活动场所联系人
     * @param dataList
     * @return List<String>
     */
	private List<String> validateDataSarsWorkOrg(List<ListEfc> dataList){
		List<String> msg = new ArrayList<String>();
		List<String> ret = new ArrayList<String>();
		int lineNo = 1;
		for (int index=0; index < dataList.size(); index++) {
			ListEfc efc = dataList.get(index);
			ret.clear();
			lineNo = index+1;
			validateObject("单位名称", efc.getUnitAddr(), ret);

			if (ret.size() > 0) {
				msg.add("第" + lineNo + "行：" + StringUtil.join(ret));
			}
		}
		return msg;		
	}	
	   /**
     * 导入密切接触者-读取数据-手足口病-患者接触史
     * @param excelUtils
     * @param infectiousCode
     * @return List<ListEfc>
     */
	private List<ListEs> readDataEs(ExcelUtils excelUtils) {
		for (int i = 0; i < 3; i++) {
			excelUtils.readLine();
		}
		List<ListEs> results = new ArrayList<ListEs>();
		while (excelUtils.hasNextLine()) {
			List<Object> line = excelUtils.readLine();
			if (!ExcelUtils.isEmptyLine(line)) {
				results.add(readLineEs(line));
			}
		}
		return results;
	}
	
	/**
     * 导入密切接触者-读取一行数据-手足口病-患者接触史
     * @param line
     * @return ListEs
     */
	private ListEs readLineEs(List<Object> line){
		
		ListEs es = new ListEs();
		es.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		es.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		es.setAge(ExcelUtils.getStringValue(line.get(2)));//年龄
		es.setRelation(ExcelUtils.getStringValue(line.get(3)));//与病例关系
		es.setAttackDt(ExcelUtils.getDateValue(line.get(4),"yyyy/MM/dd"));//发病时间
		es.setClinicalDiagnosis(ExcelUtils.getStringValue(line.get(5)));//临床诊断
		es.setContactBeginDt(ExcelUtils.getDateValue(line.get(6),"yyyy/MM/dd"));//接触时间(起)
		es.setContactEndDt(ExcelUtils.getDateValue(line.get(7),"yyyy/MM/dd"));//接触时间(止)
		es.setInhospital(formatTrueOrFalse(ExcelUtils.getStringValue(line.get(8))));//住院是否
		es.setComments(ExcelUtils.getStringValue(line.get(9)));//备注
		return es;
	}
	
    /**
     * 导入密切接触者-读取数据
     * @param excelUtils
     * @param infectiousCode
     * @return List<ListEfc>
     */
	private List<ListEfc> readData(ExcelUtils excelUtils, String infectiousCode) {
		for (int i = 0; i < 3; i++) {
			excelUtils.readLine();
		}
		List<ListEfc> results = new ArrayList<ListEfc>();
		while (excelUtils.hasNextLine()) {
			List<Object> line = excelUtils.readLine();
			if (!ExcelUtils.isEmptyLine(line)) {
				results.add(readLine(line,infectiousCode));
			}
		}
		return results;
	}

    /**
     * 导入密切接触者-读取一行数据
     * @param line
     * @param infectiousCode
     * @return ListEfc
     */
	private ListEfc readLine(List<Object> line, String infectiousCode) {
		ListEfc efc = null;
		switch (infectiousCode){
			case "101":
				efc	=	readLinePlague(line);
				break;
			case "2011":
				efc = readLineSarsFamily(line);
				break;
			case "2012":
				efc = readLineSarsWorkOrg(line);
				break;	
			case "2031":
				efc = readLineHav(line);
				break;
			case "205":
				efc = readLineHiwhpai(line);
				break;	
			case "2131":
				efc = readLineDysentery(line);
				break;	
			case "216":
				efc = readLineMeningitis(line);
				break;	
			case "220":
				efc = readLineScarlatina(line);
				break;	
			case "306":
				efc = readLineTyphusFever(line);
				break;
			case "3112":
				efc = readLineHfmd(line);
				break;				
		}
		return efc;
	}

	/**
     * 导入密切接触者-读取一行数据-手足口病
     * @param line
     * @return ListEs
     */
	private ListEfc readLineHfmd(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		efc.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		efc.setAge(ExcelUtils.getStringValue(line.get(2)));//年龄
		efc.setRelation(ExcelUtils.getStringValue(line.get(3)));//与患者关系
		efc.setAttack(formatDict(dictionaryApp,"PH00001",(ExcelUtils.getStringValue(line.get(4)))));
		efc.setAttackDt(ExcelUtils.getDateValue(line.get(5),"yyyy/MM/dd"));//发病时间
		efc.setContactBeginDt(ExcelUtils.getDateValue(line.get(6),"yyyy/MM/dd"));//接触时间(起)
		efc.setContactEndDt(ExcelUtils.getDateValue(line.get(7),"yyyy/MM/dd"));//接触时间(止)
		efc.setInhospital(formatTrueOrFalse(ExcelUtils.getStringValue(line.get(8))));//住院是否
		efc.setClinicalDiagnosis(ExcelUtils.getStringValue(line.get(9)));//临床诊断
		return efc;
	}
	
	/**
     * 导入密切接触者-读取一行数据-流行性、地方性斑疹伤寒
     * @param line
     * @return ListEfc
     */
	private ListEfc readLineTyphusFever(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		efc.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		efc.setAge(ExcelUtils.getStringValue(line.get(2)));//年龄
		efc.setUnitAddr(ExcelUtils.getStringValue(line.get(3)));//住址
		efc.setVaccineDt(ExcelUtils.getDateValue(line.get(4),"yyyy/MM/dd"));//预防接种日期
		efc.setDelousingDt(ExcelUtils.getDateValue(line.get(5),"yyyy/MM/dd"));//灭虱日期
		efc.setContactType(ExcelUtils.getStringValue(line.get(6)));//接触方式
		return efc;
	}
	
	/**
     * 导入密切接触者-读取一行数据-猩红热
     * @param line
     * @return ListEfc
     */
	private ListEfc readLineScarlatina(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		efc.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		efc.setAge(ExcelUtils.getStringValue(line.get(2)));//年龄
		efc.setRelation(ExcelUtils.getStringValue(line.get(3)));//关系
		efc.setUnitAddr(ExcelUtils.getStringValue(line.get(4)));//住址
		efc.setContactType(ExcelUtils.getStringValue(line.get(5)));//接触方式
		efc.setAttackCondition(ExcelUtils.getStringValue(line.get(6)));//发病情况
		return efc;
	}
	
	/**
     * 导入密切接触者-读取一行数据-流行性脑脊髓膜炎
     * @param line
     * @return ListEfc
     */
	private ListEfc readLineMeningitis(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		efc.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		efc.setAge(ExcelUtils.getStringValue(line.get(2)));//年龄
		efc.setProfession(ExcelUtils.getStringValue(line.get(3)));//职业
		efc.setUnitAddr(ExcelUtils.getStringValue(line.get(4)));//住址
		efc.setContactType(formatDict(dictionaryApp,"IDM00057",(ExcelUtils.getStringValue(line.get(5)))));//与该病人接触情况
		efc.setVaccineHistory(ExcelUtils.getStringValue(line.get(6)));//疫苗接种史
		efc.setComments(ExcelUtils.getStringValue(line.get(7)));//备注
		return efc;
	}
	
    /**
     * 导入密切接触者-读取一行数据-细菌性和阿米巴性痢疾
     * @param line
     * @return ListEfc
     */
	private ListEfc readLineDysentery(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		efc.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		efc.setAge(ExcelUtils.getStringValue(line.get(2)));//年龄
		efc.setRelation(formatDict(dictionaryApp,"IDM00018", ExcelUtils.getStringValue(line.get(3))));//关系
		efc.setUnitAddr(ExcelUtils.getStringValue(line.get(4)));//单位或住址
		efc.setAttack(formatDict(dictionaryApp,"PH00002",(ExcelUtils.getStringValue(line.get(5)))));//是否发病
		efc.setAttackDt(ExcelUtils.getDateValue(line.get(6), "yyyy/MM/dd"));//发病日期
		efc.setLabExamination(ExcelUtils.getStringValue(line.get(7)));//实验室检查
		return efc;
	}
	
    /**
     * 导入密切接触者-读取一行数据-人感染高致病性禽流感
     * @param line
     * @return ListEfc
     */
	private ListEfc readLineHiwhpai(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		efc.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		efc.setRelation(ExcelUtils.getStringValue(line.get(2)));//与患者关系
		efc.setUnitAddr(ExcelUtils.getStringValue(line.get(3)));//联系电话
		return efc;
	}
	
    /**
     * 导入密切接触者-读取一行数据-甲型肝炎
     * @param line
     * @return ListEfc
     */
	private ListEfc readLineHav(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		efc.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		efc.setAge(ExcelUtils.getStringValue(line.get(2)));//年龄
		efc.setRelation(ExcelUtils.getStringValue(line.get(3)));//关系
		efc.setUnitAddr(ExcelUtils.getStringValue(line.get(4)));//单位或住址
		efc.setAttack(formatDict(dictionaryApp,"PH00001",(ExcelUtils.getStringValue(line.get(5)))));//是否发病
		efc.setAttackDt(ExcelUtils.getDateValue(line.get(6), "yyyy/MM/dd"));//发病日期
		efc.setLabExamination(ExcelUtils.getStringValue(line.get(7)));//实验室检查
		return efc;
	}
	
    /**
     * 导入密切接触者-读取一行数据-传染性非典型肺炎-工作单位或主要活动场所联系人
     * @param line
     * @return ListEfc
     */
	private ListEfc readLineSarsWorkOrg(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setUnitAddr(ExcelUtils.getStringValue(line.get(0)));//单位名称
		efc.setTel(ExcelUtils.getStringValue(line.get(1)));//地址及联系电话
		efc.setLinkman(ExcelUtils.getStringValue(line.get(2)));//主要联系人
		efc.setContactName(ExcelUtils.getStringValue(line.get(3)));//接触者名单
		efc.setFlag("7");
		return efc;
	}
	
    /**
     * 导入密切接触者-读取一行数据-传染性非典型肺炎-家庭、亲友
     * @param line
     * @return ListEfc
     */
	private ListEfc readLineSarsFamily(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		efc.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		efc.setAge(ExcelUtils.getStringValue(line.get(2)));//年龄
		efc.setRelation(ExcelUtils.getStringValue(line.get(3)));//关系
		efc.setContactType(ExcelUtils.getStringValue(line.get(4)));//接触情况
		efc.setUnitAddr(ExcelUtils.getStringValue(line.get(5)));//住址(或工作单位)
		efc.setTel(ExcelUtils.getStringValue(line.get(6)));//电话
		efc.setFlag("6");
		return efc;
	}
	
    /**
     * 导入密切接触者-读取一行数据-鼠疫
     * @param line
     * @return ListEfc
     */
	private ListEfc readLinePlague(List<Object> line){
		ListEfc efc = new ListEfc();
		efc.setName(ExcelUtils.getStringValue(line.get(0)));//姓名
		efc.setSex(formatGender(ExcelUtils.getStringValue(line.get(1))));//性别
		efc.setAge(ExcelUtils.getStringValue(line.get(2)));//年龄
		efc.setUnitAddr(ExcelUtils.getStringValue(line.get(3)));//住址
		efc.setContactType(ExcelUtils.getStringValue(line.get(4)));//接触方式
		return efc;
	}
	
    /**
     * 导入密切接触者-导入数据初始化IDM_ID字段-手足口病-患者接触史
     * @param dataList
     * @param idmId
     * @return void
     */
	private void initFullDataEs(List<ListEs> dataList, Long idmId) {
		for (ListEs es : dataList) {
			es.setIdmId(idmId);
		}
	}
	
    /**
     * 导入密切接触者-导入数据初始化IDM_ID字段
     * @param dataList
     * @param idmId
     * @return void
     */
	private void initFullData(List<ListEfc> dataList, Long idmId) {
		for (ListEfc efc : dataList) {
			efc.setIdmId(idmId);
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
			ret = "0";
		}
		return ret;
	}
	
	private static String formatGender(String gender) {
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
	
	private static String formatDict(IDictionaryApp dictionaryApp, String dicCode, String itemName) {
		String result = null;
		if(StringUtil.isNotEmpty(itemName)){
			Criteria ca = new Criteria("dicCode",dicCode);
			ca.add(DicItem.ITEM_NAME,itemName);
			if (StringUtil.isNotEmpty(itemName)) {
				List<DicItem> dicItem = dictionaryApp.queryDicItem(ca);
				if(ObjectUtil.isNotEmpty(dicItem)){
					result = dicItem.get(0).getItemCode();
				}
			}
		}
		return result;
	}
	
	private static Date formatDate(String date) {
		String result = date.trim();
		if (StringUtil.isNullOrEmpty(result)) {
			return null;
		}
		return DateUtil.parseSimpleDate(date.trim(), "yyyy/MM/dd");
	}
	
	private static void validateObject(String msg, Object val, List<String> ret) {
		if (ObjectUtil.isNullOrEmpty(val)) {
			ret.add(msg+"为空");
		}
	}

	private static void validateDate(String msg, Object val, List<String> ret) {
		if (ObjectUtil.isNotEmpty(val)) {
			Date date = DateUtil.parseSimpleDate(val.toString(), ("yyyy/MM/dd"));
			if(ObjectUtil.isNullOrEmpty(date)){
				ret.add(msg+"日期格式不正确！");
			}
		}
	}
	
	private static void validateDict(IDictionaryApp dictionaryApp, String msg, String dicCode, String key, List<String> ret) {
		if (StringUtil.isNullOrEmpty(key)) {
			return;
		}
		Map<String, String> dictMap = dictionaryApp.queryDicItemMap(dicCode);
		if (!dictMap.containsKey(key)) {
			ret.add(msg+"不合法");
		}
	}
	

    /**
     * json数组转成List
     *
     * @param jsonArrayStr
     * @param clazz
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	private static List<?> json2Obj(String jsonArrayStr, Class clazz) throws IllegalAccessException, InstantiationException {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy/MM/dd"));
        JSONArray jsonObjects = JSONArray.fromObject(jsonArrayStr, jsonConfig);
        String[] dateFormats = new String[]{"yyyy/MM/dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        List resultList = new ArrayList();
        for (int i = 0; i < jsonObjects.size(); i++) {
            JSONObject jsonObj = (JSONObject) jsonObjects.get(i);
            Object obj = JSONObject.toBean(jsonObj, clazz);
            resultList.add(obj);
        }
        return resultList;
    }	
}