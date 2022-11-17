package com.founder.rhip.portal.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.portal.OutDoctor;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.portal.IOutDoctorDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/***
 * 
 * @author zhou yang
 *
 */

@Service("outDoctorService")
public class OutDoctorServiceImpl extends AbstractService implements IOutDoctorService {
	@Autowired
	private IOutDoctorDao outDoctorDao;

	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;

	@Override
	public List<OutDoctor> getOutHospitals(Criteria criteria) {
		return outDoctorDao.getOutHospitals(criteria);
	}

	@Override
	public List<OutDoctor> getHotDoctors(Criteria criteria) {
		return outDoctorDao.getHotDoctors(criteria);
	}
	
	@Override
	public List<OutDoctor> getHotClinics(Criteria criteria) {
		return outDoctorDao.getHotClinics(criteria);
	}
	
	/***
	 * 根据搜索条件查询职称
	 * @param add
	 * @return
	 */
	public List<OutDoctor> getHotEmpTits(Criteria criteria) {
		return outDoctorDao.getHotEmpTits(criteria);
	}

	@Override
	public OutDoctor getOutEmpTit(Criteria criteria) {
		return outDoctorDao.get(criteria);
	}

	@Override
	public PageList<OutDoctor> showHotDoctors(Page page, String searchContent, Criteria criteria) {
		return outDoctorDao.showHotDoctors(page, searchContent, criteria);
	}

	@Override
	public List<OutDoctor> getOutDoctors(Criteria criteria) {
		return outDoctorDao.getList(criteria);
	}

	@Override
	public OutDoctor getOutClinic(Criteria criteria) {
		return outDoctorDao.get(criteria);
	}


	@Override
	public PageList<OutDoctor> getOutDoctors(Page page, Criteria criteria) {
		Order order = new Order("status", false);
		order.asc("hospital_code");
		order.asc("dept_name");
		order.asc("name");
		if(ObjectUtil.isNullOrEmpty(criteria)) {
			criteria = new Criteria();
		}
		criteria.add("IS_DELETE", "0");
		return outDoctorDao.getPageList(page, criteria, order);
	}

	@Override
	public OutDoctor getOutDoctor(Criteria criteria) {
		return outDoctorDao.get(criteria);
	}

	@Override
	public Integer deleteOutDoctor(Criteria criteria) {
		return outDoctorDao.delete(criteria);
	}

	@Override
	public Integer updateOutDoctor(Parameters parameters,  Criteria criteria) {
		return outDoctorDao.update(parameters, criteria);
	}

	@Override
	public Integer updateOutDoctor(OutDoctor outDoctor, Map<String, String> map, String createUserCode) {
		Long id = outDoctor.getId();
		OutDoctor isExits = outDoctorDao.get(
				new Criteria("HOSPITAL_CODE",outDoctor.getHospitalCode())
				.add("DOCTOR_SN",outDoctor.getDoctorSn()).add("DEPT_SN",outDoctor.getDeptSn()));
		if(ObjectUtil.isNotEmpty(outDoctor) && ObjectUtil.isNotEmpty(id)){
			 outDoctorDao.update(outDoctor);
		} else if (ObjectUtil.isNotEmpty(outDoctor) && ObjectUtil.isNotEmpty(isExits) && ObjectUtil.isNullOrEmpty(id)) {
			//新增医生时，通过HOSPITAL_CODE，DOCTOR_SN，DEPT_SN查找是否存在，如果isExits存在，就不增加一条记录，只是修改该记录
			Parameters parameters = new Parameters("IS_DELETE",0);
			parameters.add("STATUS", outDoctor.getStatus()).add("IS_HOT", outDoctor.getIsHot())
			.add("SOCIAL_NO", outDoctor.getSocialNo()).add("EMP_TIT_CODE", outDoctor.getEmpTitCode()).add("EMP_TIT_NAME", outDoctor.getEmpTitName())
			.add("SPECIALIZES", outDoctor.getSpecializes()).add("WORK_EXPERIENCE", outDoctor.getWorkExperience())
			.add("NAME", outDoctor.getName()).add("DEPT_NAME", outDoctor.getDeptName());
			
			outDoctorDao.update(parameters, new Criteria("ID",isExits.getId()));
			id = isExits.getId();
		} else {
			id = outDoctorDao.generatedKey(outDoctor, "ID", null).longValue();
		}
		saveUploadInfoRecod(id, map, createUserCode);

		return id.intValue();
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
				uploadInfoRecord.setFileResource("outDoctorPic");
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createUserCode);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}
}
