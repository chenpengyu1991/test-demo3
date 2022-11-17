package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.SchoolInfo;
import com.founder.rhip.mdm.repository.ISchoolInfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("schoolInfoService")
public class SchoolInfoServiceImpl implements ISchoolInfoService /**, IMergerOrganizationListener, IMergerTownListener**/ {

	@Resource
	private ISchoolInfoDao schoolInfoDao;

	@Override
	public List<SchoolInfo> getSchools(Criteria criteria) {
		return schoolInfoDao.getList(criteria, new Order("SCHOOL_ID", true));
	}
	
	@Override
	public PageList<SchoolInfo> getPageSchools(Page page, Criteria criteria) {
		return schoolInfoDao.getPageList(page, criteria, new Order("SCHOOL_ID", true));
	}

	@Transactional
	@Override
	public int importSchools(List<SchoolInfo> schoolList) {
		schoolInfoDao.delete(new Criteria(SchoolInfo.SCHOOL_ID, OP.UEMPTY, null));
		for (SchoolInfo schoolInfo : schoolList) {
			schoolInfo.setSchoolId(schoolInfoDao.getSequenceNextVal("SEQ_SCHOOL_INFO", Long.class));
		}
		schoolInfoDao.batchInsert(schoolList);
		return schoolList.size();
	}
	
	@Override
	public SchoolInfo getSchool(Long schoolId) {
		return schoolInfoDao.get(schoolId);
	}
	
	public SchoolInfo getSchool(String code) {
		Criteria criteria = new Criteria(SchoolInfo.SCHOOL_CODE, code);
		return schoolInfoDao.get(criteria);
	}

	@Transactional
	@Override
	public void saveSchool(SchoolInfo schoolInfo) {
		Long schoolId = schoolInfo.getSchoolId();
		if (ObjectUtil.isNullOrEmpty(schoolId)) {
			schoolInfo.setOperateType("新建");
			schoolInfoDao.insertWithSeq(schoolInfo, "SEQ_SCHOOL_INFO");
		} else {
			schoolInfo.setOperateType("更新");
			schoolInfoDao.update(schoolInfo);
		}
	}

	@Transactional
	@Override
	public void deleteSchool(Long schoolId) {
		schoolInfoDao.delete(schoolId);
	}

	//@Override
	public void mergeStation(Organization station, List<Organization> stationList) {
		;
	}

	//@Override
	@Transactional
	public void mergeCenter(Organization center, List<Organization> centerList) {
		Parameters parameters = new Parameters("examOrgan", center.getOrganCode());
		parameters.add("organTown", center.getGbCode());
		List<String> codes = new ArrayList<String>();
		for (Organization organ : centerList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("examOrgan", OP.IN, codes);
		schoolInfoDao.update(parameters, criteria);
	}

	//@Override
	public void moveStation(Organization center, List<Organization> stationList) {
		;
	}

	//@Override
	@Transactional
	public void mergeTown(String newTownCode, String[] oldTownCode) {
		Parameters parameters = new Parameters("organTown", newTownCode);
		Criteria criteria = new Criteria("organTown", OP.IN, oldTownCode);
		schoolInfoDao.update(parameters, criteria);
	}

	//@Override
	public void sendTownVillageRelation(String townCode,
			String[] newAddVillageCodes) {
		;
	}

	//@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
		// TODO Auto-generated method stub
		
	}
}
