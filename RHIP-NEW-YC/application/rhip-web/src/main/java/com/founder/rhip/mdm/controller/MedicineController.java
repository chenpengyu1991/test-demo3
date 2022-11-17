/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mdm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
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
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Medicine;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IMedicineService;

@Controller
@RequestMapping("/mdmMedicine")
public class MedicineController extends BaseController {
	
	@Resource(name="mdmMedicineService")
	private IMedicineService medicineService;
	
	@Resource(name = "mdmDictionaryService")
	private IDictionaryService dictionaryService;
	
	@RequestMapping("/manager")
	public String manager(ModelMap model) {
		return search(model);
	}
	
	@RequestMapping("/showImport")
	public String showImport(ModelMap model) {
		Long version = medicineService.getCurrentVersion();
		model.addAttribute("version", version);
		return "com.founder.mdm.ompi.medicineManager";
	}
	
	@RequestMapping("/search")
	public String search(ModelMap model) {
		List<String> categoryOne = medicineService.getCategoryOneDict(null);
		model.addAttribute("categoryOne", categoryOne);
		List<String> dosage = medicineService.getDosageDict(null);
		model.addAttribute("dosageList", dosage);
		model.addAttribute("criMedicine", new Medicine());
		return "com.founder.mdm.ompi.medicineSearch";
	}
	
	@RequestMapping("/getDosage")
	@ResponseBody
	public List<String> getDosage(String q) {
		List<String> categoryOne = medicineService.getDosageDict(q);
		return categoryOne;
	}
	
	@RequestMapping("/getCategoryNameOne")
	@ResponseBody
	public List<String> getCategoryNameOne(String q) {
		List<String> categoryOne = medicineService.getCategoryOneDict(q);
		return categoryOne;
	}
	
	@RequestMapping("/getCategoryNameTwo")
	@ResponseBody
	public List<String> getCategoryNameTwo(String categoryNameOne, String q) {
		List<String> categoryTwo = medicineService.getCategoryTwoDict(categoryNameOne, q);
		return categoryTwo;
	}
	
	@RequestMapping("/getCategoryNameThree")
	@ResponseBody
	public List<String> getCategoryNameThree(String categoryNameTwo, String q) {
		//log.debug("q=" + q);
		List<String> categoryThree = medicineService.getCategoryThreeDict(categoryNameTwo, q);
		return categoryThree;
	}
	
	@RequestMapping("/changeStatus")
	@ResponseBody
	public ModelMap changeStatus(String medicineCode, int oldStatus) {
		ModelMap model = new ModelMap();
		try {
			Medicine medicine = new Medicine();
			medicine.setMedicineCode(medicineCode);
			medicine.setOperator(getOperator());
			medicine.setOperateTime(getOperatorTime());
			medicine.setOperateType(OperateType.update.getName());
			if (oldStatus == StatusValue.normalValue.getValue()) {
				medicine.setStatus(StatusValue.deleteValue.getValue());
			} else {
				medicine.setStatus(StatusValue.normalValue.getValue());
			}
			medicineService.changeStatus(medicine);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("修改药品状态出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/medicineList")
	public String medicineList(HttpServletRequest request,ModelMap model, Medicine criMedicine, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = initCriteria(criMedicine);
		PageList<Medicine> pageList = medicineService.getMedicines(page, criteria);
		model.addAttribute("medicineList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.ompi.medicineList";
	}
	
	@RequestMapping("/downLoadCurrent")
	public void downLoadCurrent(HttpServletResponse response) throws IOException {
        String fileName = "medicine.csv";
        setCSVDownLoadResponse(response, fileName);
        Criteria criteria = new Criteria();
        criteria.add(Dictionary.STATUS, StatusValue.normalValue.getValue());
        final List<Medicine> medicines = medicineService.queryMedicines(criteria);
        outputCSVData(response, new ICSVDataTemplement() {

			@Override
			public String getTitle() {
				return "分类,申报编码,一级分类,二级分类,三级分类,通用名,商品名,规格,剂型,最小单位,包装材质,装换比,生产厂家";
			}

			@Override
			public int getCount() {
				return medicines.size();
			}

			@Override
			public String getLine(int lineNo) {
				Medicine medicine = medicines.get(lineNo);
				StringBuilder sb = new StringBuilder();
				sb.append(formatProperty(getDictName(dictionaryService, "FS10242", medicine.getLevelCode())));
				sb.append(",");
				sb.append(formatProperty(medicine.getMedicineCode()));
				sb.append(",");
				sb.append(formatProperty(medicine.getCategoryNameOne()));
				sb.append(",");
				sb.append(formatProperty(medicine.getCategoryNameTwo()));
				sb.append(",");
				sb.append(formatProperty(medicine.getCategoryNameThree()));
				sb.append(",");
				sb.append(formatProperty(medicine.getCommonName()));
				sb.append(",");
				sb.append(formatProperty(medicine.getProductName()));
				sb.append(",");
				sb.append(formatProperty(medicine.getSpecification()));
				sb.append(",");
				sb.append(formatProperty(medicine.getDosage()));
				sb.append(",");
				sb.append(formatProperty(medicine.getUnit()));
				sb.append(",");
				sb.append(formatProperty(medicine.getMaterial()));
				sb.append(",");
				sb.append(formatProperty(medicine.getPackageSize()));
				sb.append(",");
				sb.append(formatProperty(medicine.getManufactory()));
				return sb.toString();
			}
        	
        });
	}
	
	@RequestMapping("/viewMedicine")
	public String viewMedicine(ModelMap model, String medicineCode, String operateTime) {
		Medicine medicine = null;
		if (StringUtil.isNullOrEmpty(operateTime)) {
			medicine = medicineService.getMedicine(medicineCode);
		} else {
			Criteria criteria = new Criteria(Medicine.MEDICINE_CODE, medicineCode);
			criteria.add(Medicine.OPERATE_TIME, operateTime);
			medicine = medicineService.getMedicineLog(criteria);
			if (medicine == null) {
				medicine = medicineService.getMedicine(criteria);
			}
		}
		model.addAttribute("medicine", medicine);
		return "com.founder.mdm.ompi.medicineInfo";
	}
	
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletResponse response) throws IOException {
		ModelMap model = new ModelMap();
		//setCostomerJsonlDownLoadResponse(response);
		try {
			InputStream in = file.getInputStream();
			List<Record> medicineList = readCSVFile(in);
			if (medicineList == null || medicineList.size() == 0) {
				model.addAttribute("result", false);
				model.addAttribute("message", "导入文件为空");
				ObjectMapper mapper = new ObjectMapper();   
				String content = mapper.writeValueAsString(model);     
				return content;
			}
			
			CheckResult results = new CheckResult();
			for (Record record : medicineList) {
				record.set(Medicine.OPERATOR, getOperator());
				record.set(Medicine.OPERATE_TYPE,OperateType.batchImport.getName());
				record.set(Medicine.OPERATE_TIME, getOperatorTime());
				record.set(Medicine.STATUS, StatusValue.normalValue.getValue());
				
				//检查合法性
				List<String> chkMessageList = new ArrayList<String>();
				checkAll(chkMessageList, record, EntityType.MEDICINE);
				results.add(chkMessageList);
			}
			
			if (results.hasError()) {
				model.addAttribute("result", false);
				model.addAttribute("message", getCheckErrorStr(results));
				medicineList.clear();
				medicineList = null;
//				outputJsonData(response, model);
				ObjectMapper mapper = new ObjectMapper();   
				String content = mapper.writeValueAsString(model);     
				return content;
			}
			
			int count = medicineService.importMedicines(medicineList);
			model.addAttribute("message", "总共导入"+medicineList.size()+"条药物，成功"+count+"条，失败"+(medicineList.size() - count)+"条");
			model.addAttribute("result", true);
			medicineList.clear();
			medicineList = null;
		} catch (Exception e) {
			log.error("导入药品出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		ObjectMapper mapper = new ObjectMapper();   
		String content = mapper.writeValueAsString(model);     
//		outputJsonData(response, model);
		return content;
	}
	
	@RequestMapping("/addMedicine")
	public String addMedicine(ModelMap model) {
		model.addAttribute("medicine", new Medicine());
		return "com.founder.mdm.ompi.medicineInfoEdit";
	}
	
	@RequestMapping("/editMedicine")
	public String editMedicine(ModelMap model, String medicineCode) {
		Medicine medicine = medicineService.getMedicine(medicineCode);
		model.addAttribute("medicine", medicine);
		return "com.founder.mdm.ompi.medicineInfoEdit";
	}
	
	@RequestMapping("/deleteMedicine")
	@ResponseBody
	public ModelMap deleteMedicine(String medicineCode) {
		ModelMap model = new ModelMap();
		try {
			medicineService.deleteMedicine(medicineCode);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("删除药品出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/showMedicineLogs")
	public String showMedicineLogs(HttpServletRequest request,ModelMap model, String medicineCode, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		PageList<Medicine> pageList = medicineService.getMedicineLogs(page, medicineCode);
		model.addAttribute("logList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("medicineCode", medicineCode);
		return "com.founder.mdm.ompi.medicineLogList";
	}
	
	@RequestMapping("/publishVersion")
	@ResponseBody
	public ModelMap publishVersion() {
		ModelMap model = new ModelMap();
		try {
			Long version = medicineService.publishMedicineVersion();
			model.addAttribute("version", version);
			model.addAttribute("result", true);
			model.addAttribute("message", "发布成功");
		} catch (Exception e) {
			log.error("发布药品新版本出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/downTemplate")
	@ResponseBody
	public void downTemplate(HttpServletResponse response) throws IOException {
        String fileName = "medicine.csv";
        setCSVDownLoadResponse(response, fileName);
        downFile("../views/mdm/template/medicine.csv", response);
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(Medicine medicine, String type) {
		ModelMap model = new ModelMap();
		
		medicine.setOperator(getOperator());
		medicine.setOperateTime(getOperatorTime());
		
		//检查合法性
		Record record = new Record(medicine);
		List<String> chkMessageList = new ArrayList<String>();
		checkAll(chkMessageList, record, EntityType.MEDICINE);
		
		if (chkMessageList.size() > 0) {
			model.addAttribute("result", false);
			model.addAttribute("message", getCheckErrorStr(chkMessageList));
			return model;
		}
		
		String medicineCode = medicine.getMedicineCode();
		Medicine dbMedicine = medicineService.getMedicine(medicineCode);
		if (dbMedicine == null) {
			if ("edit".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "需要更新的药品不存在");
				return model;
			}
		} else {
			if ("add".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "相同申报编码的药品已经存在");
				return model;
			}
		}
		try {
			if ("add".equalsIgnoreCase(type)) {
				medicine.setOperateType(OperateType.create.getName());
				medicineService.createMedicine(medicine);
				model.addAttribute("result", true);
				model.addAttribute("message", "添加成功");
			} else if ("edit".equalsIgnoreCase(type)) {
				medicine.setOperateType(OperateType.update.getName());
				setMedicineValue(dbMedicine, medicine);
				medicineService.updateMedicine(medicine);
				model.addAttribute("result", true);
				model.addAttribute("message", "修改成功");
			}
		} catch (Exception e) {
			log.error("保存药品出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	public Map<String, String> getDictionary(String dictKey) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dictKey);
		Map<String, String> dictMap = dictionaryService.getDicItemMapUseCache(criteria);
		return dictMap;
	}
	
	private void setMedicineValue(Medicine dbMedicine, Medicine medicine) {
		//medicine.setVersion(dbMedicine.getVersion());
	}
	
	private Criteria initCriteria(Medicine criMedicine) {
		Criteria criteria = new Criteria();
		String categoryNameOne = criMedicine.getCategoryNameOne();
		if (StringUtil.isNotEmpty(categoryNameOne)) {
			criteria.add("categoryNameOne", categoryNameOne);
		}
		String categoryNameTwo = criMedicine.getCategoryNameTwo();
		if (StringUtil.isNotEmpty(categoryNameTwo)) {
			criteria.add("categoryNameTwo", categoryNameTwo);
		}
		String categoryNameThree = criMedicine.getCategoryNameThree();
		if (StringUtil.isNotEmpty(categoryNameThree)) {
			criteria.add("categoryNameThree", categoryNameThree);
		}
		String medicineCode = criMedicine.getMedicineCode();
		if (StringUtil.isNotEmpty(medicineCode)) {
			criteria.add("medicineCode", OP.LIKE, medicineCode);
		}
		String commonName = criMedicine.getCommonName();
		if (StringUtil.isNotEmpty(commonName)) {
			criteria.add("commonName", OP.LIKE, commonName);
		}
		String productName = criMedicine.getProductName();
		if (StringUtil.isNotEmpty(productName)) {
			criteria.add("productName", OP.LIKE, productName);
		}
		String levelCode = criMedicine.getLevelCode();
		if (StringUtil.isNotEmpty(levelCode)) {
			criteria.add("levelCode", levelCode);
		}
		String dosage = criMedicine.getDosage();
		if (StringUtil.isNotEmpty(dosage)) {
			criteria.add("dosage", dosage);
		}
		String manufactory = criMedicine.getManufactory();
		if (StringUtil.isNotEmpty(manufactory)) {
			criteria.add("manufactory", OP.LIKE, manufactory);
		}
		return criteria;
	}
}
