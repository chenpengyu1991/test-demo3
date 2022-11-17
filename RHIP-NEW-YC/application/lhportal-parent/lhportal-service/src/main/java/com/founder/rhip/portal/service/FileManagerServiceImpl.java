package com.founder.rhip.portal.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.FileManager;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.portal.IFileManagerDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("fileManagerService")
public class FileManagerServiceImpl  extends AbstractService implements IFileManagerService {

	@Resource(name = "lhFileManagerDao")
	private IFileManagerDao fileManagerDao; 
	
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;
	
	@Override
	public PageList<FileManager> getFileManagers(Criteria criteria, Page page) {
		Order order = new Order("create_date");
		return fileManagerDao.getPageList(page, criteria, order);
	}

	@Override
	public boolean save(FileManager fileManager, Map<String, String> map, String createUserCode) throws Exception {
		boolean result = true;
		if (ObjectUtil.isNotEmpty(fileManager)) {
			Long id = fileManagerDao.generatedKey(fileManager,"ID", null).longValue();
			saveUploadInfoRecord(id, map, createUserCode);
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean save(FileManager fileManager, Map<String, String> fileMap, Map<String, String> fileNameMap, String createUserCode) throws Exception {
		boolean result = true;
		if (ObjectUtil.isNotEmpty(fileManager)) {
			Long id = fileManagerDao.generatedKey(fileManager,"ID", null).longValue();
			saveUploadInfoRecord(id, fileMap,fileNameMap, createUserCode);
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean delete(Long id) {
		boolean result = true;
		if (ObjectUtil.isNotEmpty(id)) {
			int rt = fileManagerDao.update(new Parameters("is_delete", "1"), new Criteria("id", id));
			if (rt == 0) {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public FileManager getFileManager(Criteria criteria, String... properties) {
		return fileManagerDao.get(criteria, properties);
	}

	@Override
	public boolean update(FileManager fileManager, Map<String, String> map, String createUserCode, String... properties) {
		boolean result = true;
		if (ObjectUtil.isNotEmpty(fileManager) && ObjectUtil.isNotEmpty(fileManager.getId())) {
			int rt = fileManagerDao.update(fileManager, properties);
			saveUploadInfoRecord(fileManager.getId(), map, createUserCode);
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean update(FileManager fileManager, Map<String, String> fileMap, Map<String, String> fileNameMap, String createUserCode, String... properties) {
		boolean result = true;
		if (ObjectUtil.isNotEmpty(fileManager) && ObjectUtil.isNotEmpty(fileManager.getId())) {
			int rt = fileManagerDao.update(fileManager, properties);
			saveUploadInfoRecord(fileManager.getId(), fileMap,fileNameMap, createUserCode);
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean publish(Long fileId, String fileStatus) {
		if(StringUtil.isEmpty(fileStatus) || fileId < 1l) {
			return  false;
		}
		fileManagerDao.update(new Parameters("STATUS", fileStatus), new Criteria("id", fileId));
		return true;
	}
	private void saveUploadInfoRecord(Long id, Map<String, String> map, String createUserCode) {
		// 附件
		if (ObjectUtil.isNotEmpty(map)) {
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for (String uuid : map.keySet()) {
				//uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", healthResourceRecord.getId())); // 删除原来附件路径名称
				//String originalFilePath = map.get(uuid).substring(0, map.get(uuid).indexOf("[<+=0a0=+>]"));
				//String originalFileName = map.get(uuid).substring(map.get(uuid).indexOf("[<+=0a0=+>]")+11,map.get(uuid).length());
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(id);
				uploadInfoRecord.setOriginalFilePath(map.get(uuid));
//				uploadInfoRecord.setOriginalFileName(originalFileName);
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(map.get(uuid))); // 缩略图地址
				uploadInfoRecord.setFileResource("lhpwdgl");
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createUserCode);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}

	private void saveUploadInfoRecord(Long id,Map<String, String> fileMap,Map<String, String> fileNameMap, String createUserCode) {
		// 附件
		if (ObjectUtil.isNotEmpty(fileMap)) {
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for (String uuid : fileMap.keySet()) {
				// 删除原来附件路径名称
				uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", id));
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(id);
				uploadInfoRecord.setOriginalFilePath(fileMap.get(uuid));
				uploadInfoRecord.setOriginalFileName(fileNameMap.get(uuid));
				// 缩略图地址
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(fileMap.get(uuid)));
				uploadInfoRecord.setFileResource("lhpwdgl");
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createUserCode);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}
	@Override
	public int update(FileManager fileManager) {
		return fileManagerDao.update(fileManager);
	}
}
