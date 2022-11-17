package com.founder.rhip.he.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.healtheducation.IHeResourceRecordDao;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("heResourceRecordService")
public class HeResourceRecordServiceImpl extends AbstractService implements IHeResourceRecordService {
	
	@Resource(name = "heResourceRecordDao")
	private IHeResourceRecordDao heResourceRecordDao;
	
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

	private static final String[] IMAGE_TYPE = new String[] {"jpg", "jpeg", "png", "bmp"};

	@Override
	@Transactional
	public void createHealthResourceRecord(HeResourceRecord healthResourceRecord, Map<String, String> map, Map<String, String> filenameMap, String createrName) {
		if (ObjectUtil.isNullOrEmpty(healthResourceRecord)) {
			return;
		}
		Long id = heResourceRecordDao.generatedKey(healthResourceRecord, "ID", null).longValue();
		// 附件
		if (ObjectUtil.isNotEmpty(map)) {
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for (String uuid : map.keySet()) {
				String originalFilePath = map.get(uuid);
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(id);
				uploadInfoRecord.setOriginalFilePath(originalFilePath);
				uploadInfoRecord.setOriginalFileName(filenameMap.get(uuid));//设置附件名字
				String suffixName = StringUtils.substringAfterLast(filenameMap.get(uuid), ".");//设置文件类型
				if (ArrayUtils.contains(IMAGE_TYPE, StringUtils.lowerCase(suffixName))) {
					uploadInfoRecord.setFileType("image");//设置文件类型
				}

				//StringBuilder sb = new StringBuilder(StringUtils.substringBeforeLast(originalFilePath, "\\")).append(Constants.THUMBNAIL).append(StringUtils.substringAfterLast(originalFilePath, "\\"));
				//uploadInfoRecord.setThumbnailPath(sb.toString()); // 缩略图地址
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(originalFilePath)); // 缩略图地址
				uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_EDUCATION_RECORD.getCode());
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createrName);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}

	@Override
	@Transactional
	public void updateHealthResourceRecord(HeResourceRecord healthResourceRecord, Map<String, String> map, Map<String, String> filenameMap,  String createrName, String... properties) {
		if (ObjectUtil.isNullOrEmpty(healthResourceRecord) && ObjectUtil.isNullOrEmpty(map)) {
			return;
		}
		
		heResourceRecordDao.update(healthResourceRecord, properties);
		// 附件上传
		if (ObjectUtil.isNotEmpty(map)) {
			//uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", healthResourceRecord.getId())); // 删除原来附件路径名称
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for (String uuid : map.keySet()) {
				String originalFilePath = map.get(uuid);
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(healthResourceRecord.getId());
				uploadInfoRecord.setOriginalFilePath(originalFilePath);
				uploadInfoRecord.setOriginalFileName(filenameMap.get(uuid));//设置附件名字
				String suffixName = StringUtils.substringAfterLast(filenameMap.get(uuid), ".");//设置文件类型
				if (ArrayUtils.contains(IMAGE_TYPE, StringUtils.lowerCase(suffixName))) {
					uploadInfoRecord.setFileType("image");//设置文件类型
				}
				//StringBuilder sb = new StringBuilder(StringUtils.substringBeforeLast(originalFilePath, "\\")).append(Constants.THUMBNAIL).append(StringUtils.substringAfterLast(originalFilePath, "\\"));
				//uploadInfoRecord.setThumbnailPath(sb.toString()); // 缩略图地址
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(originalFilePath)); // 缩略图地址
				uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_EDUCATION_RECORD.getCode());
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createrName);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}

	@Override
	@Transactional
	public void deleteHealthResourceRecord(Long... ids) {
		if (ObjectUtil.isNullOrEmpty(ids)) {
			return;
		}
		//heResourceRecordDao.delete(ids);
		heResourceRecordDao.update(new Parameters("STATUS", "0"), new Criteria("ID", OP.IN, ids));
		// 删除附件
		//uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", OP.IN, ids));
	}

	@Override
	public PageList<HeResourceRecord> findHealthResourceRecord(Criteria criteria, Page page) {
		Order order=new Order("ISSUE_TIME",false);
	    order.desc("ID");
		return heResourceRecordDao.getPageList(page, criteria, order);
	}

	@Override
	public HeResourceRecord getHealthResourceRecord(Criteria criteria) {
		return heResourceRecordDao.get(criteria);
	}

	@Override
	public PageList<HeResourceRecord> findHealthPostionRecord(Criteria criteria, Page page) {
		return heResourceRecordDao.getHealthPositionPageList(criteria, page);
	}


}
