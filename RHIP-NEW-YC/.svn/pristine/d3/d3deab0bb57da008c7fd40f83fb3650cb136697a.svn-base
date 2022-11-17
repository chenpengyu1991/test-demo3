package com.founder.rhip.fds.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.fds.entity.AttachmentRecord;
import com.founder.rhip.fds.repository.IAttachmentRecordDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("attachmentRecordService")
public class AttachmentRecordServiceImpl implements IAttachmentRecordService {

	@Resource(name = "attachmentRecordDao")
	private IAttachmentRecordDao attachmentRecordDao;
	
	@Override
	public List<AttachmentRecord> queryAttachmentRecord(Criteria criteria) {
		return attachmentRecordDao.getList(criteria);
	}

	@Override
	public boolean deleteAttachmentRecord(Long... ids) {
		if (ObjectUtil.isNullOrEmpty(ids)) {
			return false;
		}
		try {
			attachmentRecordDao.delete(ids);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
