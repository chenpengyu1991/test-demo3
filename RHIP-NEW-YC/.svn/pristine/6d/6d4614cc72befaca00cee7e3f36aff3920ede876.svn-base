/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeCopy;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.healtheducation.IHeCopyDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("heCopyService")
public class HeCopyServiceImpl extends AbstractService implements IHeCopyService {

	@Resource(name = "heCopyDao")
	private IHeCopyDao HeCopyDao;
	
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

	@Transactional
	public int createHeCopy(HeCopy HeCopy, Map<String, String> fileMap, String createrName) {
		int result = 0;
		if (ObjectUtil.isNullOrEmpty(HeCopy)) {
			return result;
		}
		try {
			Long resourceId = HeCopyDao.generatedKey(HeCopy, "ID", null).longValue();
			// 附件上传
			if (ObjectUtil.isNotEmpty(fileMap)) {
				//uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", healthResourceRecord.getId())); // 删除原来附件路径名称
				List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
				for (String uuid : fileMap.keySet()) {
					String originalFilePath = fileMap.get(uuid);
					UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
					uploadInfoRecord.setResourceId(HeCopy.getId().longValue());
					uploadInfoRecord.setOriginalFilePath(originalFilePath);
					//StringBuilder sb = new StringBuilder(StringUtils.substringBeforeLast(originalFilePath, "\\")).append(Constants.THUMBNAIL).append(StringUtils.substringAfterLast(originalFilePath, "\\"));
					//uploadInfoRecord.setThumbnailPath(sb.toString()); // 缩略图地址
					uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(originalFilePath)); // 缩略图地址
					uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_COPY.getCode());
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
		}
		return result;
	}

	@Transactional
	public int updateHeCopy(HeCopy HeCopy, Map<String, String> fileMap, String createrName, String... properties) {
		int result = 0;
		try {
			HeCopyDao.update(HeCopy, properties);
			// 附件
			if (ObjectUtil.isNotEmpty(fileMap)) {
				//uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", healthResourceRecord.getId())); // 删除原来附件路径名称
				List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
				for (String uuid : fileMap.keySet()) {
					String originalFilePath = fileMap.get(uuid);
					UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
					uploadInfoRecord.setResourceId(HeCopy.getId().longValue());
					uploadInfoRecord.setOriginalFilePath(originalFilePath);
					//StringBuilder sb = new StringBuilder(StringUtils.substringBeforeLast(originalFilePath, "\\")).append(Constants.THUMBNAIL).append(StringUtils.substringAfterLast(originalFilePath, "\\"));
					//uploadInfoRecord.setThumbnailPath(sb.toString()); // 缩略图地址
					uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(originalFilePath)); // 缩略图地址
					uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_COPY.getCode());
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

	@Transactional
	public int deleteHeCopy(Long... ids) {
		int result = 0;
		try {
			//HeCopyDao.delete(ids);
			HeCopyDao.delete(new Criteria("ID", OP.IN, ids));
			uploadInfoRecordDao.delete(new Criteria("resourceId", OP.IN, ids));
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public PageList<HeCopy> findHeCopy(Criteria criteria, Page page) {
		return HeCopyDao.getPageList(page, criteria);
	}

	@Override
	public HeCopy getHeCopy(Criteria criteria) {
		return HeCopyDao.get(criteria);
	}

}