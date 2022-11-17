package com.founder.rhip.he.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.common.ResourceCategory;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.healtheducation.HeIndividual;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.healtheducation.IHeActiveDao;
import com.founder.rhip.ehr.repository.healtheducation.IHeIndividualDao;
@Service("heIndividualService")
public class HeIndividualServiceImpl extends AbstractService implements IHeIndividualService {
	@Resource(name = "heIndividualDao")
	private IHeIndividualDao heIndividualDao;
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;
	@Override
	public PageList<HeIndividual> findHealthEducationActive(Criteria criteria, Page page) {
		// TODO Auto-generated method stub
		return heIndividualDao.getPageList(page, criteria);
	}

	@Override
	public void createHeIndividual(HeIndividual heIndividual, Map<String, String> fileMap, String name) {
		// TODO Auto-generated method stub
		heIndividual.setStatus("1"); // "1"默认状态，"0"删除
		Long heIndividualId = heIndividualDao.generatedKey(heIndividual, "ID", null).longValue();
		// 附件上传
					if (ObjectUtil.isNotEmpty(fileMap)) {
						List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
						for (String uuid : fileMap.keySet()) {
							String originalFilePath = fileMap.get(uuid);
							UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
							uploadInfoRecord.setResourceId(heIndividualId);
							uploadInfoRecord.setOriginalFilePath(originalFilePath);
							//StringBuilder sb = new StringBuilder(StringUtils.substringBeforeLast(originalFilePath, "\\")).append(Constants.THUMBNAIL).append(StringUtils.substringAfterLast(originalFilePath, "\\"));
							uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(originalFilePath)); // 缩略图地址
							//uploadInfoRecord.setThumbnailPath(sb.toString()); // 缩略图地址
							uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_INDIVIDUAL.getCode());
							uploadInfoRecord.setCreateTime(new Date());
							uploadInfoRecord.setCreater(name);
							uploadInfoRecords.add(uploadInfoRecord);
						}
						uploadInfoRecordDao.batchInsert(uploadInfoRecords);
					}
	}

	@Override
	public void updateHeIndividual(HeIndividual heIndividual, Map<String, String> fileMap, String name,String[] properties) {

		heIndividualDao.update(heIndividual,properties);
		// 附件
		if(ObjectUtil.isNotEmpty(fileMap)){
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			for(String uuid : fileMap.keySet()){
				//String originalFilePath = map.get(uuid).substring(0, map.get(uuid).indexOf("[<+=0a0=+>]"));
				//String originalFileName = map.get(uuid).substring(map.get(uuid).indexOf("[<+=0a0=+>]")+11,map.get(uuid).length());
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(heIndividual.getId());
				uploadInfoRecord.setOriginalFilePath(fileMap.get(uuid));
				//uploadInfoRecord.setOriginalFileName(originalFileName);
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(fileMap.get(uuid))); // 缩略图地址
				uploadInfoRecord.setFileResource(ResourceCategory.HEALTH_INDIVIDUAL.getCode());
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(name);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	
	}

	@Override
	public HeIndividual getHeIndividual(Criteria criteria) {
		// TODO Auto-generated method stub
		return heIndividualDao.get(criteria);
	}

	@Override
	public void deleteHeIndividual(Long id) {
		// TODO Auto-generated method stub
		heIndividualDao.update(new Parameters("STATUS", "0"), new Criteria("ID",id));
	}


}
