package com.founder.rhip.ep.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.ep.IodineNutritionMonitor;
import com.founder.rhip.ehr.entity.ep.IodineNutritionSampling;
import com.founder.rhip.ehr.repository.ep.IIodineNutritionMonitorDao;
import com.founder.rhip.ehr.repository.ep.IIodineNutritionSamplingDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.SchoolInfo;
import com.founder.rhip.mdm.repository.ISchoolInfoDao;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;

@Service("iodineNutritionService")
public class IodineNutritionServiceImpl implements IIodineNutritionService, IMergerOrganizationListener {
	
	@Resource
	private IIodineNutritionSamplingDao iodineNutritionSamplingDao;
	
	@Resource
	private IIodineNutritionMonitorDao iodineNutritionMonitorDao;
	
	@Resource
	private ISchoolInfoDao schoolInfoDao;
	
	/**
	 * 获取抽样列表
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IodineNutritionSampling> getPageList(Page page, Criteria criteria) {
		return iodineNutritionSamplingDao.getPageList(page, criteria, new Order("SAMPLING_YEAR", false).asc("SAMPLING_NO"));
	}
	
	/**
	 * 获取抽样列表
	 * @param criteria
	 * @return
	 */
	public List<IodineNutritionSampling> getList(Criteria criteria) {
		return iodineNutritionSamplingDao.getList(criteria, new Order("SAMPLING_YEAR", false).asc("SAMPLING_NO"));
	}
	
	/**
	 * 获取本年度抽样列表
	 * @param criteria
	 * @return
	 */
	public List<IodineNutritionSampling> getCurrentYearSampling(String gbCode, String type) {
		Criteria criteria = new Criteria("deleteFlag", EHRConstants.DELETE_FLG_0);
		criteria.add("samplingYear", DateUtil.getCurrentYear());
		if (StringUtil.isNotEmpty(type)) {
			criteria.add("type", type);
		}
		
		if (StringUtil.isNotEmpty(gbCode)) {
			List<String> codes = new ArrayList<String>();
			Criteria schoolCriteria = new Criteria("organTown", gbCode);
			List<SchoolInfo> infos = schoolInfoDao.getList(schoolCriteria, "schoolCode");
			if (StringUtil.isNullOrEmpty(type)) {
				codes.add(gbCode);
				if (infos != null) {
					for (SchoolInfo info : infos) {
						codes.add(info.getSchoolCode());
					}
				}
			} else {
				if (IodineNutritionSampling.TYPE_TOWN.equals(type)) {
					codes.add(gbCode);
				} else if (IodineNutritionSampling.TYPE_SCHOOL.equals(type)) {
					if (infos != null) {
						for (SchoolInfo info : infos) {
							codes.add(info.getSchoolCode());
						}
					}
				}
			}
			criteria.add("code", OP.IN, codes);
		}
		List<IodineNutritionSampling> list = iodineNutritionSamplingDao.getList(criteria, new Order("SAMPLING_YEAR", false).asc("SAMPLING_NO"));
		return list;
	}
	
	/**
	 * 获取抽样详细
	 * @param id
	 * @return
	 */
	public IodineNutritionSampling getDetail(Long id) {
		return iodineNutritionSamplingDao.get(id);
	}
	
	/**
	 * 获取抽样详细
	 * @param id
	 * @return
	 */
	public IodineNutritionSampling getDetail(Criteria criteria) {
		return iodineNutritionSamplingDao.get(criteria);
	}
	
	/**
	 * 保存抽样详细
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@Transactional
	public void save(IodineNutritionSampling sampling) throws Exception {
		Long id = sampling.getId();
		if (ObjectUtil.isNullOrEmpty(id)) {
			iodineNutritionSamplingDao.insertWithSeq(sampling, "SEQ_IODINE_NUTRITION_SAMPLING");
		} else {
			Criteria criteria = new Criteria("samplingId", id);
			
			List<IodineNutritionMonitor> monitorList = iodineNutritionMonitorDao.getList(criteria, "id");
			if (monitorList.size() > 0) {
				throw new Exception("此抽样点存在调查明细记录，无法更新");
			}
			iodineNutritionSamplingDao.update(sampling, "code", "name", "type", "remark", "updatePerson", "updateOrgan", "updateTime");
		}
	}
	
	/**
	 * 删除抽样详细
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@Transactional
	public void delete(Long id) throws Exception {
		Criteria criteria = new Criteria("samplingId", id);
		List<IodineNutritionMonitor> monitorList = iodineNutritionMonitorDao.getList(criteria, "id");
		if (monitorList.size() > 0) {
			throw new Exception("此抽样点存在调查明细记录，无法删除");
		}
		iodineNutritionSamplingDao.delete(id);
	}
	
	@Override
	public void mergeStation(Organization station,
			List<Organization> stationList) {
		;
	}

	@Override
	@Transactional
	public void mergeCenter(Organization center, List<Organization> centerList) {
		Parameters parameters = new Parameters("createOrgan", center.getOrganCode());
		List<String> codes = new ArrayList<String>();
		for (Organization organ : centerList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("createOrgan", OP.IN, codes);
		iodineNutritionSamplingDao.update(parameters, criteria);
		iodineNutritionMonitorDao.update(parameters, criteria);
	}

	@Override
	public void moveStation(Organization center, List<Organization> stationList) {
		;
	}

	@Override
	public void changeRelationOrgVillage(String orgCode,
			String[] newAddVillageCodes) {
		;
	}
}
