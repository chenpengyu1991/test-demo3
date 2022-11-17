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
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.ep.IodineNutritionMonitor;
import com.founder.rhip.ehr.repository.ep.IIodineNutritionMonitorDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;

@Service("iodineNutritionMonitorService")
public class IodineNutritionMonitorServiceImpl implements IIodineNutritionMonitorService, IMergerOrganizationListener {
	
	@Resource
	private IIodineNutritionMonitorDao iodineNutritionMonitorDao;
	
	/**
	 * 获取碘营养和碘缺乏调查监测列表
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IodineNutritionMonitor> getPageList(Page page, Criteria criteria) {
		return iodineNutritionMonitorDao.getPageList(page, criteria, new Order("INVESTIGATE_TIME", false).asc("SAMPLING_ID").asc("SURVEY_NO"));
	}
	
	/**
	 * 获取碘营养和碘缺乏调查监测列表
	 * @param criteria
	 * @return
	 */
	public List<IodineNutritionMonitor> getList(Criteria criteria) {
		return iodineNutritionMonitorDao.getList(criteria, new Order("INVESTIGATE_TIME", false).asc("SAMPLING_ID").asc("SURVEY_NO"));
	}
	
	/**
	 * 获取碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	public IodineNutritionMonitor getDetail(Long id) {
		return iodineNutritionMonitorDao.get(id);
	}
	
	/**
	 * 获取抽样对应的最大调查编号
	 * @param samplingNo
	 * @return
	 */
	public Long getMaxMonitorId(Long samplingId) {
		String maxSurveyNo = iodineNutritionMonitorDao.getMax(samplingId);
		return (maxSurveyNo == null) ? 0 : Long.valueOf(maxSurveyNo.split("_")[1]);
	}
	
	/**
	 * 获取碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	public IodineNutritionMonitor getDetail(Criteria criteria) {
		return iodineNutritionMonitorDao.get(criteria);
	}
	
	/**
	 * 保存碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	@Transactional
	public void save(IodineNutritionMonitor monitor) {
		Long id = monitor.getId();
		if (ObjectUtil.isNullOrEmpty(id)) {
			iodineNutritionMonitorDao.insertWithSeq(monitor, "SEQ_IODINE_NUTRITION_SAMPLING");
		} else {
			iodineNutritionMonitorDao.update(monitor, ServiceUtil.getUpdateProperties(IodineNutritionMonitor.class));
		}
	}
	
	/**
	 * 删除碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	@Transactional
	public void delete(IodineNutritionMonitor monitor) {
		iodineNutritionMonitorDao.update(monitor, ServiceUtil.getDeleteProperties());
	}
	
	/**
	 * 通过编号取得今年监测记录
	 * @param surveyNo
	 * @return
	 */
	public IodineNutritionMonitor getCurrentYearDetailBySurveyNo(String surveyNo) {
		return iodineNutritionMonitorDao.getCurrentYearDetailBySurveyNo(surveyNo);
	}
	
	/**
	 * 删除碘营养和碘缺乏调查监测详细
	 * @param id
	 * @return
	 */
	@Transactional
	public void delete(Long id) {
		iodineNutritionMonitorDao.delete(id);
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
