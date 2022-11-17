package com.founder.rhip.ehr.service.basic;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;

@Service("uploadInfoRecordService")
public class UploadInfoRecordServiceImpl implements IUploadInfoRecordService {

	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;
	
	@Override
	public List<UploadInfoRecord> queryUploadInfoRecord(Criteria criteria) {
		List<UploadInfoRecord> uploadInfoRecords = uploadInfoRecordDao.getList(criteria);
		for (UploadInfoRecord uploadInfoRecord: uploadInfoRecords){
			uploadInfoRecord.isImageFlag();
		}
		return uploadInfoRecords;
	}

	@Override
	public boolean deleteUploadInfoRecord(Long... ids) {
		if (ObjectUtil.isNullOrEmpty(ids)) {
			return false;
		}
		try {
			uploadInfoRecordDao.delete(ids);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
