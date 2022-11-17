package com.founder.rhip.portal.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("lhhospitalInfoService")
public class HospitalInfoServiceImpl extends AbstractService implements IHospitalInfoService{
	
	@Autowired
	private IHospitalInfoDao hospitalInfoDao;
	
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;
	
	@Override
	public PageList<HospitalInfo> getList(Page page, Criteria criteria) {
		criteria.add("IS_DELETE", "0");
		PageList<HospitalInfo> result = hospitalInfoDao.getPageList(page, criteria, new Order("order_num", true));
		return result;
	}

	@Override
	public PageList<HospitalInfo> getPortalLists(Page page, Criteria criteria) {
		
		criteria.add("status","1").add("is_delete", 0);
		PageList<HospitalInfo> hospitalInfoPageList = hospitalInfoDao.getPageList(page, criteria, new Order("order_num", true));
		hospitalInfoPageList.setPage(hospitalInfoPageList.getPage());
		return hospitalInfoPageList;
	}
	
	@Override
	public PageList<HospitalInfo> getPortalList(Page page, String[] param, String orgType) {
		
		Criteria hospitalInfoCriteria = new Criteria("status","1").add("is_delete", 0);
		if(param != null) {
			hospitalInfoCriteria.add("HOSPITAL_LEVEL", OP.IN, param);
		}
		if(orgType != null) {
			hospitalInfoCriteria.add("ORGANIZATION_TYPE", orgType);
		}
		PageList<HospitalInfo> hospitalInfoPageList = hospitalInfoDao.getPageList(page, hospitalInfoCriteria, new Order("order_num", true));
		
		hospitalInfoPageList.setPage(hospitalInfoPageList.getPage());
		return hospitalInfoPageList;
	}
	
	@Override
	public boolean update(HospitalInfo hospitalInfo, Map<String, String> map, String createUserCode) {
		boolean result = true;
		if(ObjectUtil.isNotEmpty(hospitalInfo) && ObjectUtil.isNotEmpty(hospitalInfo.getId())){
			hospitalInfoDao.update(hospitalInfo);
			saveUploadInfoRecod(hospitalInfo.getId(), map, createUserCode);
		}else{
			result = false;
		}
		return result;
	}

	@Override
	public int update(Parameters parameters, Criteria criteria){
		return hospitalInfoDao.update(parameters, criteria);
	}
	
	@Override
	public HospitalInfo get(Long idTemp) {
		return hospitalInfoDao.get(idTemp);
	}
	
	@Override
	public HospitalInfo getHospitalinfo(Criteria criteria) {
		return hospitalInfoDao.get(criteria);
	}
	
	@Override
	public boolean insert(HospitalInfo hospitalInfo, Map<String, String> map, String createUserCode) {
		boolean result = true;
		if(ObjectUtil.isNotEmpty(hospitalInfo)){
			Long id = hospitalInfoDao.generatedKey(hospitalInfo, "ID", null).longValue();
			saveUploadInfoRecod(id, map, createUserCode);
		}else{
			result = false;
		}
		return result;
	}

	@Override
	public int delete(Long id) {
		int result = hospitalInfoDao.update(new Parameters("IS_DELETE", "1"), new Criteria("id", id));
		if(result != 0){
			return 1;
		}else
			return 0;
	}

	@Override
	public Integer getHospitalCount(Criteria criteria) {
		Integer result = 0;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = hospitalInfoDao.getCount(criteria, "IS_DELETE", Integer.class);
		}
		return result;
	}

	@Override
	public List<HospitalInfo> get(Criteria criteria) {
		Order order = new Order("order_num", true);
		return hospitalInfoDao.getList(criteria);
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
				uploadInfoRecord.setFileResource("lhHospitalPic");
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createUserCode);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}
	
	@Override
	public List<HospitalInfo> getHosInfoByDistinctHosRegScheduleLists (Criteria criteria) {
		return hospitalInfoDao.getHosInfoByDistinctHosRegScheduleLists (criteria);
	}

	@Override
	public List<HospitalInfo> getAllHospital() {
		Criteria criteria = new Criteria("IS_DELETE","0").add("IS_REGISTERED_HOSPITAL","1");
		Order order = new Order("order_num", true);
		return hospitalInfoDao.getList(criteria,order);
	}

}
