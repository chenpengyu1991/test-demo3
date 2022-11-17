package com.founder.rhip.portal.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.ServiceInfo;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.portal.IServiceInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("lhserviceInfoService")
public class ServiceInfoServiceImpl extends AbstractService implements IServiceInfoService{

	@Autowired
	private IServiceInfoDao serviceInfoDao;
	
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;
	
	@Override
	public PageList<ServiceInfo> getList(Page page, Criteria criteria) {
		Criteria isDeleteCriteria = new Criteria("IS_DELETE", "0").add(LOP.OR, "IS_DELETE", OP.IS, "null");
		criteria.add(isDeleteCriteria);
		Order order = new Order("creat_time", false);
		return serviceInfoDao.getPageList(page, criteria, order);
	}
	@Override
	public List<ServiceInfo> getList(Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		return serviceInfoDao.getList(criteria);
	}
	@Override
	public ServiceInfo get(Long id) {
		return serviceInfoDao.get(id);
	}
	@Override
	public boolean update(ServiceInfo serviceInfo, Map<String, String> map, String createUserCode) {
		boolean result = true;
		if(ObjectUtil.isNotEmpty(serviceInfo) && ObjectUtil.isNotEmpty(serviceInfo.getId())){
			serviceInfoDao.update(serviceInfo);
			saveUploadInfoRecod(serviceInfo.getId(), map, createUserCode);
		}else{
			result = false;
		}
		return result;
	}
	@Override
	public boolean insert(ServiceInfo serviceInfo, Map<String, String> map, String createUserCode) {
		boolean result = true;
		if(ObjectUtil.isNotEmpty(serviceInfo)){
			Long id = serviceInfoDao.generatedKey(serviceInfo, "ID", null).longValue();
			saveUploadInfoRecod(id, map, createUserCode);
		}else{
			result = false;
		}
		return result;
	}
	@Override
	public int delete(Criteria criteria) {
		return serviceInfoDao.update(new Parameters("IS_DELETE", "1"), criteria);
	}
	@Override
	public int updateStatus(Parameters parameters, Criteria criteria) {
		return serviceInfoDao.update(parameters, criteria);
	}

	private void saveUploadInfoRecod(Long id, Map<String, String> map, String createUserCode) {
		// 附件
		if(ObjectUtil.isNotEmpty(map)){
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for(String uuid : map.keySet()){
				//String originalFilePath = map.get(uuid).substring(0, map.get(uuid).indexOf("[<+=0a0=+>]"));
				//String originalFileName = map.get(uuid).substring(map.get(uuid).indexOf("[<+=0a0=+>]")+11,map.get(uuid).length());
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(id);
				uploadInfoRecord.setOriginalFilePath(map.get(uuid));
				//uploadInfoRecord.setOriginalFileName(originalFileName);
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(map.get(uuid))); // 缩略图地址
				uploadInfoRecord.setFileResource("lhrollpic");
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createUserCode);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}
	@Override
	public int update(ServiceInfo serviceInfo) {
		return serviceInfoDao.update(serviceInfo);
	}
}
