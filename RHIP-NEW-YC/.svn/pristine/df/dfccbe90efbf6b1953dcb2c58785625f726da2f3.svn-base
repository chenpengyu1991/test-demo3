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
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.service.IDiseaseService;

@Controller
@RequestMapping("/mdmDisease")
public class DiseaseController extends BaseController {
	
	@Resource(name="mdmDiseaseService")
	private IDiseaseService diseaseService;
	
	@RequestMapping("/manager")
	public String manager(ModelMap model) {
		return search(model);
	}
	
	@RequestMapping("/showImport")
	public String showImport(ModelMap model) {
		Long version = diseaseService.getCurrentVersion();
		model.addAttribute("version", version);
		return "com.founder.mdm.ompi.diseaseManager";
	}
	
	@RequestMapping("/search")
	public String search(ModelMap model) {
		model.addAttribute("criDisease", new Disease());
		return "com.founder.mdm.ompi.diseaseSearch";
	}

	@RequestMapping("/changeStatus")
	@ResponseBody
	public ModelMap changeStatus(Long diseaseId, int oldStatus) {
		ModelMap model = new ModelMap();
		try {
			Disease disease = new Disease();
			disease.setDiseaseId(diseaseId);
			disease.setOperator(getOperator());
			disease.setOperateTime(getOperatorTime());
			disease.setOperateType(OperateType.update.getName());
			if (oldStatus == StatusValue.normalValue.getValue()) {
				disease.setStatus(StatusValue.deleteValue.getValue());
			} else {
				disease.setStatus(StatusValue.normalValue.getValue());
			}
			diseaseService.changeStatus(disease);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("修改疾病状态出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/diseaseList")
	public String diseaseList(HttpServletRequest request,ModelMap model, Disease criDisease, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		Criteria criteria = initCriteria(criDisease);
		PageList<Disease> pageList = diseaseService.getDiseases(page, criteria);
		model.addAttribute("diseaseList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.ompi.diseaseList";
	}
	
	@RequestMapping("/downLoadCurrent")
	public void downLoadCurrent(HttpServletResponse response) throws IOException {
        String fileName = "disease.csv";
        setCSVDownLoadResponse(response, fileName);
        Criteria criteria = new Criteria();
        criteria.add(Dictionary.STATUS, StatusValue.normalValue.getValue());
        //final Long version = diseaseService.getCurrentVersion();
        final List<Disease> diseases = diseaseService.queryDiseases(criteria);
        outputCSVData(response, new ICSVDataTemplement() {

			@Override
			public String getTitle() {
				//return "主要编码,附加编码,疾病名称,版本号";
				return "主要编码,附加编码,疾病名称";
			}

			@Override
			public int getCount() {
				return diseases.size();
			}

			@Override
			public String getLine(int lineNo) {
				Disease disease = diseases.get(lineNo);
				StringBuilder sb = new StringBuilder();
				sb.append(formatProperty(disease.getIcd10main()));
				sb.append(",");
				sb.append(formatProperty(disease.getIcd10ext()));
				sb.append(",");
				sb.append(formatProperty(disease.getDiseaseName()));
				//sb.append(",");
				//sb.append(version);
				return sb.toString();
			}
        	
        });
	}
	
	@RequestMapping("/downTemplate")
	@ResponseBody
	public void downTemplate(HttpServletResponse response) throws IOException {
        String fileName = "disease.csv";
        setCSVDownLoadResponse(response, fileName);
        downFile("../views/mdm/template/disease.csv", response);
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletResponse response) throws IOException {
		ModelMap model = new ModelMap();
		//setCostomerJsonlDownLoadResponse(response);
		try {
			InputStream in = file.getInputStream();
			List<Record> diseaseList = readCSVFile(in);
			if (diseaseList == null || diseaseList.size() == 0) {
				model.addAttribute("result", false);
				model.addAttribute("message", "导入文件为空");
				ObjectMapper mapper = new ObjectMapper();   
				String content = mapper.writeValueAsString(model);     
				return content;
			}
			
			CheckResult results = new CheckResult();
			for (Record record : diseaseList) {
				record.set(Disease.OPERATOR, getOperator());
				record.set(Disease.OPERATE_TYPE,OperateType.batchImport.getName());
				record.set(Disease.OPERATE_TIME, getOperatorTime());
				record.set(Disease.STATUS, StatusValue.normalValue.getValue());
				
				//检查合法性
				List<String> chkMessageList = new ArrayList<String>();
				checkAll(chkMessageList, record, EntityType.DISEASE);
				results.add(chkMessageList);
			}
			
			if (results.hasError()) {
				model.addAttribute("result", false);
				model.addAttribute("message", getCheckErrorStr(results));
				diseaseList.clear();
				diseaseList = null;
				//outputJsonData(response, model);
				ObjectMapper mapper = new ObjectMapper();   
				String content = mapper.writeValueAsString(model);     
				return content;
			}
			
			int count = diseaseService.importDiseases(diseaseList);
			model.addAttribute("message", "总共导入"+diseaseList.size()+"条疾病，成功"+count+"条，失败"+(diseaseList.size() - count)+"条");
			model.addAttribute("result", true);
			diseaseList.clear();
			diseaseList = null;
		} catch (Exception e) {
			log.error("导入疾病出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		//outputJsonData(response, model);
		ObjectMapper mapper = new ObjectMapper();   
		String content = mapper.writeValueAsString(model);     
		return content;
	}
	
	@RequestMapping("/addDisease")
	public String addDisease(ModelMap model) {
		model.addAttribute("disease", new Disease());
		return "com.founder.mdm.ompi.diseaseInfoEdit";
	}
	
	@RequestMapping("/editDisease")
	public String editDisease(ModelMap model, Long diseaseId) {
		Disease disease = diseaseService.getDisease(diseaseId);
		model.addAttribute("disease", disease);
		return "com.founder.mdm.ompi.diseaseInfoEdit";
	}
	
	@RequestMapping("/deleteDisease")
	@ResponseBody
	public ModelMap deleteDisease(Long diseaseId) {
		ModelMap model = new ModelMap();
		try {
			diseaseService.deleteDisease(diseaseId);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("删除疾病出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/showDiseaseLogs")
	public String showDiseaseLogs(HttpServletRequest request,ModelMap model, Long diseaseId, int indexPage) {
		Page page = super.getPage(request,  indexPage);
		PageList<Disease> pageList = diseaseService.getDiseaseLogs(page, diseaseId);
		model.addAttribute("logList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("diseaseId", diseaseId);
		return "com.founder.mdm.ompi.diseaseLogList";
	}
	
	@RequestMapping("/publishVersion")
	@ResponseBody
	public ModelMap publishVersion() {
		ModelMap model = new ModelMap();
		try {
			Long version = diseaseService.publishDiseaseVersion();
			model.addAttribute("version", version);
			model.addAttribute("result", true);
			model.addAttribute("message", "发布成功");
		} catch (Exception e) {
			log.error("发布疾病版本出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(Disease disease, String type) {
		ModelMap model = new ModelMap();
		
		disease.setOperator(getOperator());
		disease.setOperateTime(getOperatorTime());
		
		//检查合法性
		Record record = new Record(disease);
		List<String> chkMessageList = new ArrayList<String>();
		checkAll(chkMessageList, record, EntityType.DISEASE);
		
		if (chkMessageList.size() > 0) {
			model.addAttribute("result", false);
			model.addAttribute("message", getCheckErrorStr(chkMessageList));
			return model;
		}
		
		String icd10main = disease.getIcd10main();
		Disease dbDisease = diseaseService.getDisease(new Criteria(Disease.ICD10MAIN, icd10main));
		if (dbDisease == null) {
			if ("edit".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "需要更新的疾病不存在");
				return model;
			}
		} else {
			if ("add".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "相同编码的疾病已经存在");
				return model;
			}
		}
		try {
			if ("add".equalsIgnoreCase(type)) {
				disease.setOperateType(OperateType.create.getName());
				diseaseService.createDisease(disease);
				model.addAttribute("result", true);
				model.addAttribute("message", "添加成功");
			} else if ("edit".equalsIgnoreCase(type)) {
				disease.setOperateType(OperateType.update.getName());
				setDiseaseValue(dbDisease, disease);
				diseaseService.updateDisease(disease);
				model.addAttribute("result", true);
				model.addAttribute("message", "修改成功");
			}
		} catch (Exception e) {
			log.error("保存疾病出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	private void setDiseaseValue(Disease dbDisease, Disease disease) {
		disease.setDiseaseId(dbDisease.getDiseaseId());
	}
	
	private Criteria initCriteria(Disease disease) {
		Criteria criteria = new Criteria();
		String icd10main = disease.getIcd10main();
		if (StringUtil.isNotEmpty(icd10main)) {
			criteria.add(Disease.ICD10MAIN, OP.LIKE, icd10main);
		}
		String icd10ext= disease.getIcd10ext();
		if (StringUtil.isNotEmpty(icd10ext)) {
			criteria.add(Disease.ICD10EXT, OP.LIKE, icd10ext);
		}
		String diseaseName= disease.getDiseaseName();
		if (StringUtil.isNotEmpty(diseaseName)) {
			criteria.add("diseaseName", OP.LIKE, diseaseName);
		}
		return criteria;
	}
}
