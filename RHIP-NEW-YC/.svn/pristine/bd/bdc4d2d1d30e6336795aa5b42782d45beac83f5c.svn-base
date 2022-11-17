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
import com.founder.rhip.ehr.common.HealthEducationRecordType;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeActive;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.healtheducation.IHeActiveDao;
import com.founder.rhip.ehr.repository.healtheducation.IHeResourceRecordDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("heActiveService")
public class HeActiveServiceImpl extends AbstractService implements IHeActiveService {

	@Resource(name = "heActiveDao")
	private IHeActiveDao heActiveDao;
	
	@Resource(name = "heResourceRecordDao")
	private IHeResourceRecordDao healthResourceRecordDao;
	
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

	@Transactional
	public void createHealthEducationActive(HeActive heActive, HeResourceRecord healthResourceRecord, Map<String, String> map, Map<String, String> fileNameMap, String createrName) {
		if (ObjectUtil.isNotEmpty(heActive)) {
			heActive.setStatus("1"); // "1"默认状态，"0"删除
			Long activeId = heActiveDao.generatedKey(heActive, "ID", null).longValue();
			// 印刷资料发放
			if (ObjectUtil.isNotEmpty(healthResourceRecord)) {
				healthResourceRecord.setActiveId(activeId);
				healthResourceRecord.setOrgCode(heActive.getOrgCode());
				healthResourceRecord.setCenterOrgCode(heActive.getCenterOrgCode());
				healthResourceRecord.setGbcode(heActive.getGbcode());
				healthResourceRecord.setResourceType(HealthEducationRecordType.MATERIALS.getCode());
				healthResourceRecord.setIssueTime(new Date());
				healthResourceRecord.setStatus("1"); // "1"默认状态，"0"删除
				healthResourceRecordDao.insert(healthResourceRecord);
			}
			// 附件上传
			if (ObjectUtil.isNotEmpty(map) && ObjectUtil.isNotEmpty(fileNameMap)) {
				List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
				for (String uuid : map.keySet()) {
					String originalFilePath = map.get(uuid);
					UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
					uploadInfoRecord.setResourceId(activeId);
					uploadInfoRecord.setOriginalFilePath(originalFilePath);
					uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(originalFilePath)); // 缩略图地址
					uploadInfoRecord.setOriginalFileName(fileNameMap.get(uuid));
					uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_ACTIVE.getCode());
					uploadInfoRecord.setCreateTime(new Date());
					uploadInfoRecord.setCreater(createrName);
					uploadInfoRecords.add(uploadInfoRecord);
				}
				uploadInfoRecordDao.batchInsert(uploadInfoRecords);
			}
		}
	}

	@Transactional
	public void updateHealthEducationActive(HeActive heActive, HeResourceRecord healthResourceRecord, Map<String, String> map, Map<String, String> fileNameMap, String createrName, String... properties) {
		heActiveDao.update(heActive, properties);
		// 健康资料发放记录
		if (ObjectUtil.isNotEmpty(healthResourceRecord)) {
			Criteria criteria = new Criteria("ACTIVE_ID", heActive.getId());
			Parameters parameters = new Parameters("MATERIAL_TYPE", healthResourceRecord.getMaterialType()).add("ISSUE_QUANTITY", healthResourceRecord.getIssueQuantity());
			healthResourceRecordDao.update(parameters, criteria);
		}
		// 附件
		if(ObjectUtil.isNotEmpty(map) && ObjectUtil.isNotEmpty(fileNameMap)){
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for(String uuid : map.keySet()){
				//String originalFilePath = map.get(uuid).substring(0, map.get(uuid).indexOf("[<+=0a0=+>]"));
				//String originalFileName = map.get(uuid).substring(map.get(uuid).indexOf("[<+=0a0=+>]")+11,map.get(uuid).length());
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(healthResourceRecord.getId());
				uploadInfoRecord.setOriginalFilePath(map.get(uuid));
				uploadInfoRecord.setOriginalFileName(fileNameMap.get(uuid));
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(map.get(uuid))); // 缩略图地址
				uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_ACTIVE.getCode());
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createrName);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}

	@Transactional
	public void deleteHealthEducationActive(Long... ids) {
		if (ObjectUtil.isNullOrEmpty(ids)) {
			return;
		}
		// 删除健康教育活动
		//heActiveDao.delete(ids);
		heActiveDao.update(new Parameters("STATUS", "0"), new Criteria("ID", OP.IN, ids));
		// 删除健康教育活动发放的资料
		//healthResourceRecordDao.delete(new Criteria("ACTIVE_ID", OP.IN, ids));
		healthResourceRecordDao.update(new Parameters("STATUS", "0"), new Criteria("ACTIVE_ID", OP.IN, ids));
		// 删除附件
		//uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", OP.IN, ids));
	}

	public PageList<HeActive> findHealthEducationActive(Criteria criteria,Page page) {
        Order order=new Order("ACTIVE_TIME",false);
        order.desc("ID");
		return heActiveDao.getHealthEducationActiveList(criteria, page, order);
	}

	@Override
	public HeActive getHealthEducationActive(Criteria criteria) {
		return heActiveDao.get(criteria);
	}

}