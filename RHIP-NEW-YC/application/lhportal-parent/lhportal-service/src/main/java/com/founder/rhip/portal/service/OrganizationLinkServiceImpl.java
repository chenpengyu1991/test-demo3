package com.founder.rhip.portal.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.OrganizationLink;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.portal.IOrganizationLinkDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("organizationLinkService")
public class OrganizationLinkServiceImpl extends AbstractService implements IOrganizationLinkService{
	@Autowired
	private IOrganizationLinkDao organizationLinkDao;
	
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

	@Override
	public PageList<OrganizationLink> getList(Page page, Criteria criteria) {
		Order order = new Order("order_num", true);
		PageList<OrganizationLink> result = organizationLinkDao.getPageList(page, criteria, order);
		return result;
	}

	@Override
	public OrganizationLink get(Long id) {
		return organizationLinkDao.get(id);
	}

	@Override
	public int delete(Long id) {
		int result = organizationLinkDao.update(new Parameters("IS_DELETE","1"), new Criteria("id",id));
		if(result != 0){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public boolean update(OrganizationLink organizationLink, Map<String, String> map, String createUserCode) {
		boolean result = true;
		if(ObjectUtil.isNotEmpty(organizationLink) && ObjectUtil.isNotEmpty(organizationLink.getId())){
			organizationLinkDao.update(organizationLink);
			saveUploadInfoRecod(organizationLink.getId(), map, createUserCode);
		}else{
			result = false;
		}
		return result;
	}

	@Override
	public boolean save(OrganizationLink organizationLink, Map<String, String> map, String createUserCode) {
		boolean result = true;
		if(ObjectUtil.isNotEmpty(organizationLink)){
			Long id = organizationLinkDao.generatedKey(organizationLink, "ID", null).longValue();
			saveUploadInfoRecod(id, map, createUserCode);
		}else{
			result = false;
		}
		return result;
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
				uploadInfoRecord.setFileResource("lhol");
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createUserCode);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}

	@Override
	public int updateStatus(Parameters parameters, Criteria criteria) {
		return organizationLinkDao.update(parameters, criteria);
	}

}
