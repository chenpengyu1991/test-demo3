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
import com.founder.rhip.ehr.entity.healtheducation.HeSupervisor;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.healtheducation.IHeSupervisorDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("heSupervisorService")
public class HeSupervisorServiceImpl extends AbstractService implements IHeSupervisorService {

	@Resource(name = "heSupervisorDao")
	private IHeSupervisorDao heSupervisorDao;
	
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

	public void createHealthSupervisor(HeSupervisor healthSupervisor, Map<String, String> map, String createrName) {
		if (ObjectUtil.isNullOrEmpty(healthSupervisor)) {
			return;
		}
		Long id = heSupervisorDao.generatedKey(healthSupervisor, "ID", null).longValue();
		// 附件
		if(ObjectUtil.isNotEmpty(map)){
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for(String uuid : map.keySet()){
				//String originalFilePath = map.get(uuid).substring(0, map.get(uuid).indexOf("[<+=0a0=+>]"));
				//String originalFileName = map.get(uuid).substring(map.get(uuid).indexOf("[<+=0a0=+>]")+11,map.get(uuid).length());
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(id);
				uploadInfoRecord.setOriginalFilePath(map.get(uuid));
//				uploadInfoRecord.setOriginalFileName(originalFileName);
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(map.get(uuid))); // 缩略图地址
				uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_EDUCATION_SUPERVISOR.getCode());
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createrName);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}

	@Transactional
	@Override
	public void updateHealthSupervisor(HeSupervisor healthSupervisor, Map<String, String> map, String createrName, String... properties) {
		if (ObjectUtil.isNullOrEmpty(healthSupervisor) && ObjectUtil.isNullOrEmpty(map)) {
			return;
		}
		
		heSupervisorDao.update(healthSupervisor, properties);
		// 附件上传
		if (ObjectUtil.isNotEmpty(map)) {
			//uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", healthSupervisor.getId())); // 删除原来附件路径名称
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for (String uuid : map.keySet()) {
				String originalFilePath = map.get(uuid);
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord(healthSupervisor.getId(), originalFilePath, ResourceCategory.HEALTH_EDUCATION_SUPERVISOR.getCode(), createrName, new Date());
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}

	public int deleteHealthSupervisor(Long... ids) {
		int result = 0;
		try {
			//heSupervisorDao.delete(ids);
			heSupervisorDao.update(new Parameters("STATUS", "0"), new Criteria("ID", OP.IN, ids));
			result = 1;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public PageList<HeSupervisor> findHealthSupervisor(Criteria criteria, Page page) {
		Order order=new Order("OVERSEE_TIME", false);
	    order.desc("ID");
		return heSupervisorDao.getPageList(page, criteria, order);
	}

	@Override
	public HeSupervisor getHealthSupervisor(Criteria criteria) {
		return heSupervisorDao.get(criteria);
	}

}