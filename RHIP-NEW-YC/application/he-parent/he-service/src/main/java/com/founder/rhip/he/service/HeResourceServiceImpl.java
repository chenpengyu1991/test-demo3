/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.he.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeResource;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.healtheducation.IHeResourceDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("heResourceService")
public class HeResourceServiceImpl extends AbstractService implements IHeResourceService {

	@Resource(name = "heResourceDao")
	private IHeResourceDao heResourceDao;
	
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

	@Transactional
	public int createHealthEducationResource(HeResource healthEducationResource, Map<String, String> fileMap, Map<String, String> fileNameMap, String createrName) {
		int result = 0;
		if (ObjectUtil.isNullOrEmpty(healthEducationResource)) {
			return result;
		}
		try {
			Long resourceId = heResourceDao.generatedKey(healthEducationResource, "ID", null).longValue();
			// 附件上传
			if (ObjectUtil.isNotEmpty(fileMap)) {
				List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
				for (String uuid : fileMap.keySet()) {
					String originalFilePath = fileMap.get(uuid);
					UploadInfoRecord uploadInfoRecord = new UploadInfoRecord(resourceId, originalFilePath, ResourceCategory.HEALTH_RESOURCE_MATERIAL.getCode(), createrName, new Date());
					uploadInfoRecord.setOriginalFileName(fileNameMap.get(uuid));
					uploadInfoRecords.add(uploadInfoRecord);
				}
				uploadInfoRecordDao.batchInsert(uploadInfoRecords);
			}
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return result;
	}

	public int updateHealthEducationResource(HeResource healthEducationResource, Map<String, String> fileMap, Map<String, String> fileNameMap, String createrName, String... properties) {
		int result = 0;
		try {
			heResourceDao.update(healthEducationResource, properties);
			// 附件
			if(ObjectUtil.isNotEmpty(fileMap)){
				List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
				for(String uuid : fileMap.keySet()){
					//String originalFilePath = fileMap.get(uuid).substring(0, fileMap.get(uuid).indexOf("[<+=0a0=+>]"));
					//String originalFileName = fileMap.get(uuid).substring(fileMap.get(uuid).indexOf("[<+=0a0=+>]")+11,fileMap.get(uuid).length());
					UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
					uploadInfoRecord.setResourceId(healthEducationResource.getId());
					uploadInfoRecord.setOriginalFilePath(fileMap.get(uuid));
					uploadInfoRecord.setOriginalFileName(fileNameMap.get(uuid));
					uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(fileMap.get(uuid))); // 缩略图地址
					uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_RESOURCE_MATERIAL.getCode());
					uploadInfoRecord.setCreateTime(new Date());
					uploadInfoRecord.setCreater(createrName);
					uploadInfoRecords.add(uploadInfoRecord);
				}
				uploadInfoRecordDao.batchInsert(uploadInfoRecords);
			}
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public int deleteHealthEducationResource(Long... ids) {
		int result = 0;
		try {
			//heResourceDao.delete(ids);
			heResourceDao.update(new Parameters("STATUS", "0"), new Criteria("ID", OP.IN, ids));
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public PageList<HeResource> findHealthEducationResource(Criteria criteria, Page page) {
		Order order=new Order("RESOURCE_RECORD_TIME",false);
	    order.desc("ID");
		return heResourceDao.getPageList(page, criteria, order);
	}

	@Override
	public HeResource getHealthEducationResource(Criteria criteria) {
		return heResourceDao.get(criteria);
	}

}