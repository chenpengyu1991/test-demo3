package com.founder.rhip.mdm.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.service.IDiseaseService;

@Service("diseaseApp")
public class DiseaseApp extends MDMBaseApp implements IDiseaseApp {
	
	@Resource(name="mdmDiseaseService")
	private IDiseaseService diseaseService;
	
	@Resource
	private IDictionaryApp dictionaryApp;

	@Override
	public Disease queryDisease(String icd10) {
		Criteria criteria = new Criteria(Disease.ICD10MAIN, OP.FLIKE, icd10);
		List<Disease> diseaseList = queryDiseases(criteria);
		if (diseaseList == null || diseaseList.size() == 0) {
			criteria = new Criteria(Disease.ICD10EXT, OP.FLIKE, icd10);
			diseaseList = queryDiseases(criteria);
		}
		if (diseaseList == null || diseaseList.size() == 0) {
			return null;
		}
		Disease ret = diseaseList.get(0);
		if (diseaseList.size() == 1) {
			return ret;
		}
		for (Disease disease : diseaseList) {
			if (disease.getIcd10main().contains(".900")) {
				return disease;
			} else if (disease.getIcd10main().contains(".x00")) {
				return disease;
			}
		}
		return ret;
	}

	@Override
	public List<Disease> queryDiseases(Criteria criteria) {
		setStatusToCriteria(criteria);
		List<Disease> diseases = diseaseService.queryDiseasesUseCache(criteria);
		return diseases;
	}
	
	@Override
	public List<Disease> queryDiseasesByCategoryRange(String startCategory, String endCategory) {
		List<Disease> diseases = diseaseService.queryDiseasesByCategoryRangeUseCache(startCategory, endCategory);
		return diseases;
	}
	
	private Criteria setStatusToCriteria(Criteria criteria) {
		if (criteria == null) {
			return criteria;
		}
		if (!criteria.contains(Disease.STATUS)) {
			criteria.add(Disease.STATUS, StatusValue.normalValue.getValue());
		}
		return criteria;
	}

	@Override
	public String registDisease(Disease disease) throws CheckException {
		disease.setOperateTime(getOperatorTime());
		disease.setOperateType(OperateType.regist.getName());
		List<String> messageList = new ArrayList<String>();
		checkAll(messageList, new Record(disease), EntityType.DISEASE);
		if (messageList.size() > 0) {
			CheckException exception = getCheckException(messageList);
			throw exception;
		}
		String icd10main = disease.getIcd10main();
		String icd10ext = disease.getIcd10ext();
		if (StringUtil.isNullOrEmpty(icd10main)
				&& StringUtil.isNullOrEmpty(icd10ext)) {
			messageList.add("ICD10主编码和ICD10扩展编码至少一项不能为空");
			CheckException exception = getCheckException(messageList);
			throw exception;
		}
		Criteria criteria = null;
		if (StringUtil.isNotEmpty(icd10main)) {
			criteria = new Criteria(Disease.ICD10MAIN, icd10main);
		} else {
			criteria = new Criteria(Disease.ICD10EXT, icd10ext);
		}
		Disease dbDisease = diseaseService.getDisease(criteria);
		if (dbDisease == null) {
			diseaseService.createDisease(disease);
		} else {
			disease.setDiseaseId(dbDisease.getDiseaseId());
			diseaseService.updateDisease(disease);
		}
		return StringUtil.isNotEmpty(icd10main)?icd10main:icd10ext;
	}
	
	public Map<String, String> getDictionary(String dictKey) {
		Map<String, String> dictMap = dictionaryApp.queryDicItemMap(dictKey);
		return dictMap;
	}

	@Override
	public Disease getDisease(String icd10) {
		Criteria criteria = new Criteria(Disease.ICD10MAIN, icd10);
		List<Disease> diseaseList = queryDiseases(criteria);
		if (diseaseList == null || diseaseList.size() == 0) {
			criteria = new Criteria(Disease.ICD10EXT, OP.FLIKE, icd10);
			diseaseList = queryDiseases(criteria);
		}
		if (diseaseList == null || diseaseList.size() == 0) {
			return null;
		}
		Disease ret = diseaseList.get(0);
		if (diseaseList.size() == 1) {
			return ret;
		}
		for (Disease disease : diseaseList) {
			if (disease.getIcd10main().contains(".900")) {
				return disease;
			} else if (disease.getIcd10main().contains(".x00")) {
				return disease;
			}
		}
		return ret;
	}
}
