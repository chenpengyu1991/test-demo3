package com.founder.rhip.mdm.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.Assert;
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.repository.IDiseaseDao;

@Service("mdmDiseaseService")
public class DiseaseService extends MDMService implements IDiseaseService {

	public static final String SEQ_DISEASE = "SEQ_MDM_DISEASE";

	@Resource(name = "mdmDiseaseDao")
	private IDiseaseDao diseaseDao;

	@Override
	public PageList<Disease> getDiseases(Page page, Criteria criteria) {
		PageList<Disease> pageList = diseaseDao.getPageList(page, criteria);
		return pageList;
	}

	@Override
	public List<Disease> queryDiseases(Criteria criteria) {
		List<Disease> diaeases = diseaseDao.getList(criteria);
		return diaeases;
	}

	@Override
	public List<Disease> queryDiseasesUseCache(Criteria criteria) {
		String key = LSIT_KEY + criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		List<Disease> retList = (List<Disease>) getCache(EntityType.DISEASE, key);
		if (retList == null) {
			retList = diseaseDao.getList(criteria);
			if (retList != null && retList.size() > 0) {
				setCache(EntityType.DISEASE, key, retList);
			}
		}
		return retList;
	}

	@Override
	public Disease getDisease(Long diseaseId) {
		Disease disease = diseaseDao.get(diseaseId);
		return disease;
	}

	@Override
	public Disease getDisease(Criteria criteria) {
		Disease disease = diseaseDao.get(criteria);
		return disease;
	}

	@Override
	public PageList<Disease> getDiseaseLogs(Page page, Long diseaseId) {
		// Criteria criteria = new Criteria(Disease.DISEASE_ID, diseaseId);
		PageList<Disease> logs = diseaseDao.getLogList(page, diseaseId);
		return logs;
	}

	@Override
	public List<Disease> queryDiseasesByCategoryRange(String startCategory, String endCategory) {
		Assert.notNull(startCategory);
		Assert.notNull(endCategory);
		List<Disease> diseases = diseaseDao.getDiseasesByCategoryRange(startCategory, endCategory);
		return diseases;
	}

	@Override
	public List<Disease> queryDiseasesByCategoryRangeUseCache(String startCategory, String endCategory) {
		Assert.notNull(startCategory);
		Assert.notNull(endCategory);
		StringBuilder key = new StringBuilder(LSIT_KEY);
		key.append(startCategory).append("_").append(endCategory);
		@SuppressWarnings("unchecked")
		List<Disease> retList = (List<Disease>) getCache(EntityType.DISEASE, key.toString());
		if (retList == null) {
			retList = diseaseDao.getDiseasesByCategoryRange(startCategory, endCategory);
			if (retList != null && retList.size() > 0) {
				setCache(EntityType.DISEASE, key.toString(), retList);
			}
		}
		return retList;
	}

	@Transactional
	@Override
	public void createDisease(Disease disease) {
		Long version = diseaseDao.getDiseaseVersion();
		disease.setVersion(version);
		diseaseDao.insertWithSeq(disease, SEQ_DISEASE);
		removeCache(EntityType.DISEASE);
	}

	@Transactional
	@Override
	public void updateDisease(Disease disease) {
		Criteria criteria = new Criteria(Disease.DISEASE_ID, disease.getDiseaseId());
		diseaseDao.insertLog(criteria);
		Long version = diseaseDao.getDiseaseVersion();
		disease.setVersion(version);
		diseaseDao.update(disease);
		removeCache(EntityType.DISEASE);
	}

	@Transactional
	@Override
	public void deleteDisease(Long diseaseId) {
		Criteria criteria = new Criteria(Disease.DISEASE_ID, diseaseId);
		diseaseDao.deleteLog(criteria);
		diseaseDao.delete(diseaseId);
		removeCache(EntityType.DISEASE);
	}

	@Transactional
	@Override
	public void changeStatus(Disease disease) {
		Long diseaseId = disease.getDiseaseId();
		Disease dbDisease = diseaseDao.get(diseaseId);
		dbDisease.setStatus(disease.getStatus());
		dbDisease.setOperator(disease.getOperator());
		dbDisease.setOperateTime(disease.getOperateTime());
		dbDisease.setOperateType(disease.getOperateType());

		Criteria criteria = new Criteria(Disease.DISEASE_ID, diseaseId);
		diseaseDao.insertLog(criteria);
		diseaseDao.update(dbDisease);
		removeCache(EntityType.DISEASE);
	}

	@Override
	public Long getCurrentVersion() {
		return diseaseDao.getDiseaseVersion();
	}

	@Transactional
	@Override
	public Long publishDiseaseVersion() {
		diseaseDao.publishDiseaseVersion();
		return diseaseDao.getDiseaseVersion();
	}

	@Override
	public int importDiseases(List<Record> diseaseList) {
		List<Record> insertDiseaseList = new ArrayList<Record>();
		List<Record> updateDiseaseList = new ArrayList<Record>();
		List<Long> updateDiseaseCodes = new ArrayList<Long>();
		Long version = diseaseDao.getDiseaseVersion();
		for (Record record : diseaseList) {
			record.set(Disease.VERSION, version);
			String icdMain = record.getAsString(Disease.ICD10MAIN);
			Disease disease = diseaseDao.get(new Criteria(Disease.ICD10MAIN, icdMain));
			if (disease == null) {
				record.set(Disease.DISEASE_ID, diseaseDao.getSequenceNextVal(SEQ_DISEASE, Long.class));
				insertDiseaseList.add(record);
			} else {
				record.set(Disease.DISEASE_ID, disease.getDiseaseId());
				updateDiseaseCodes.add(disease.getDiseaseId());
				updateDiseaseList.add(record);
			}
		}

		List<List> logList = getInsertLogs(updateDiseaseCodes);
		for (List ids : logList) {
			Criteria criteria = new Criteria(Disease.DISEASE_ID, OP.IN, ids);
			diseaseDao.insertLog(criteria);
			ids.clear();
			ids = null;
		}
		logList.clear();
		logList = null;
		updateDiseaseCodes.clear();
		updateDiseaseCodes = null;

		String[] properties = diseaseList.get(0).keySet().toArray(new String[] {});
		diseaseDao.batchMapInsert(insertDiseaseList, properties);
		diseaseDao.batchMapUpdate(updateDiseaseList, properties);
		insertDiseaseList.clear();
		insertDiseaseList = null;
		updateDiseaseList.clear();
		updateDiseaseList = null;
		removeCache(EntityType.DISEASE);
		return diseaseList.size();
	}

}
