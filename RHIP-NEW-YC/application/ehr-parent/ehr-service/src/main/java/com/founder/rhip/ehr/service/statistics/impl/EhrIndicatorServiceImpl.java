package com.founder.rhip.ehr.service.statistics.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.repository.management.mhm.IMhmStatusInfoDao;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;

@Service("ehrIndicatorService")
public class EhrIndicatorServiceImpl implements IPublicHealthTarget{

    @Autowired
    private IPersonInfoDao personInfoDao;
    
    @Autowired
    private IDmDiseaseInfoDao dmDiseaseInfoDao;
    
    @Autowired
    private IMhmStatusInfoDao mhmStatusInfoDao;
    
    @Override
    public Float getEHRTarget(List<String> orgCode,Date startDate, Date endDate, String targetCode){
    	switch(targetCode){
    		case TargetConstants.BEN_NIAN_XIN_ZENG_DANG_AN:
    			//新增档案
    			return getNewTarget(orgCode,startDate,endDate);
    		case TargetConstants.ZHONG_DIAN_REN_QUN_LR:
    			//65岁以上
    			return getOver65Target(orgCode,startDate,endDate);
    		case TargetConstants.ZHONG_DIAN_REN_QUN_GXY:
    			//高血压
    			return getHbbTarget(orgCode,startDate,endDate);
    		case TargetConstants.ZHONG_DIAN_REN_QUN_TNB:
    			//2型糖尿病
    			return getDiTarget(orgCode,startDate,endDate);
    		case TargetConstants.ZHONG_DIAN_REN_QUN_JSB:
    			//精神病
    			return getJSTarget(orgCode,startDate,endDate);
    		case TargetConstants.EHR_SHI_YONG_QING_KUANG_YOU:
    			//有动态记录
    			return getActive(orgCode,startDate,endDate);
    		case TargetConstants.EHR_SHI_YONG_QING_KUANG_WU:
    			//无动态记录数
    			return getUNActive(orgCode,startDate,endDate);
    		case TargetConstants.LEI_JI_DANG_AN_HJ:
    			//累计档案 - 户籍
    			String hj = "1";
    			return getArchivesTarget(hj,orgCode,startDate,endDate);
    		case TargetConstants.LEI_JI_DANG_AN_FHJ:
    			//累计档案 - 非户籍
    			String fhj = "2";
    			return getArchivesTarget(fhj,orgCode,startDate,endDate);
    	}
    	return -1.0f;
    }
    
    private Float getNewTarget(List<String> orgCode,Date startDate, Date endDate){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("orgKey", "inputOrganCode");
    	map.put("dateKey", "inputDate");
    	Criteria criteria = getCriteria(orgCode,map,startDate,endDate);
    	criteria.add("FILING_FLAG", EHRConstants.HAD_CREATE);
    	Long pList = personInfoDao.getCount(criteria, "ID", Long.class);
    	return Float.valueOf(pList);
    }
    
    private Float getUNActive(List<String> orgCode,Date startDate, Date endDate){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("orgKey", "inputOrganCode");
    	//map.put("dateKey", "inputDate");
    	Criteria criteria = getCriteria(orgCode,map,startDate,endDate);
    	criteria.add("FILING_FLAG", EHRConstants.HAD_CREATE);
    	criteria.add("inputDate", OP.LE,endDate);
    	Long pList = personInfoDao.getCount(criteria, "ID", Long.class);
    	
    	Float active = getActive(orgCode,startDate,endDate);
    	return pList - active;
    }
    
    /** 
    * @Title: getActive 
    * @Description: 有动态记录数
    * @param @param orgCode
    * @param @param startDate
    * @param @param endDate
    * @param @return
    * @return Float
    * @throws 
    */
    private Float getActive(List<String> orgCode,Date startDate, Date endDate){
    	Criteria criteria = new Criteria();
    	if(ObjectUtil.isNotEmpty(orgCode)){
    		String[] orgs = new String[orgCode.size()];
        	orgCode.toArray(orgs);
        	criteria.add("BPF.INPUT_ORGAN_CODE", OP.IN,orgs);
    	}
    	criteria.add("BPF.FILING_FLAG", EHRConstants.HAD_CREATE);
    	Long update = personInfoDao.getActiveCount(criteria,startDate,endDate);
    	return Float.valueOf(update);
    }
    
	/** 
	* @Title: getOver65Target 
	* @Description: 查询65岁以上人群建档数
	* @param @param orgCode
	* @param @param startDate
	* @param @param endDate
	* @param @param targetCode
	* @param @return
	* @return Float
	* @throws 
	*/
    private Float getOver65Target(List<String> orgCode,Date startDate, Date endDate){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("orgKey", "inputOrganCode");
    	map.put("dateKey", "inputDate");
    	Criteria criteria = getCriteria(orgCode,map,startDate,endDate);
    	Date birthDate = DateUtil.getBirthdayByAge(65);
    	criteria.add("birthday",OP.LE, birthDate);
    	criteria.add("FILING_FLAG", EHRConstants.HAD_CREATE);
    	Long pList = personInfoDao.getCount(criteria, "ID", Long.class);
    	return Float.valueOf(pList);
    }
    
	/** 
	* @Title: getHbbTarget 
	* @Description: 查询高血压
	* @param @param orgCode
	* @param @param startDate
	* @param @param endDate
	* @param @param targetCode
	* @param @return
	* @return Float
	* @throws 
	*/
    private Float getHbbTarget(List<String> orgCode,Date startDate, Date endDate){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("orgKey", "createOrganCode");
    	map.put("dateKey", "hbpManagedDate");
    	Criteria criteria = getCriteria(orgCode,map,startDate,endDate);
    	criteria.add("hbpFlag", 2);
    	criteria.add("isDelete", EHRConstants.DELETE_FLG_0);
    	Long l = dmDiseaseInfoDao.getPersonIdCount(criteria);
    	return Float.valueOf(l);
    }
    
	/** 
	* @Title: getDiTarget 
	* @Description: 查询2型糖尿病
	* @param @param orgCode
	* @param @param startDate
	* @param @param endDate
	* @param @param targetCode
	* @param @return
	* @return Float
	* @throws 
	*/
    private Float getDiTarget(List<String> orgCode,Date startDate, Date endDate){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("orgKey", "createOrganCode");
    	map.put("dateKey", "diManagedDate");
    	Criteria criteria = getCriteria(orgCode,map,startDate,endDate);
    	criteria.add("isDelete", EHRConstants.DELETE_FLG_0);
    	criteria.add("diFlag", 2);
    	criteria.add("diType", 2);
    	Long l = dmDiseaseInfoDao.getPersonIdCount(criteria);
    	return Float.valueOf(l);
    }
    
	/** 
	* @Title: getDiTarget 
	* @Description: 查询精神病
	* @param @param orgCode
	* @param @param startDate
	* @param @param endDate
	* @param @param targetCode
	* @param @return
	* @return Float
	* @throws 
	*/
    private Float getJSTarget(List<String> orgCode,Date startDate, Date endDate){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("orgKey", "oi.MANAGEMENT_STATION");
    	map.put("dateKey", "oi.BRING_INTO_DATE");
    	Criteria criteria = getCriteria(orgCode,map,startDate,endDate);
    	criteria.add("si.STATUS", OP.IN,new Integer[]{3,4});
    	Long l = mhmStatusInfoDao.getPersonIdCount(criteria);
    	return Float.valueOf(l);
    }
    
    private Float getArchivesTarget(String houseHoldType, List<String> orgCode,Date startDate, Date endDate){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("orgKey", "inputOrganCode");
    	map.put("dateKey", "inputDate");
    	Criteria criteria = getCriteria(orgCode,map,startDate,endDate);
    	criteria.add("householdType",houseHoldType);
    	//[B130929-002][综合管理-统计汇总] modify by：meixingjian begin
    	//String[] flags = {EHRConstants.HAD_CREATE, EHRConstants.HAD_BACK, EHRConstants.CHECK_FLAG};
    	String flags = EHRConstants.HAD_CREATE;
    	criteria.add("FILING_FLAG",OP.EQ, flags);
    	//end
    	Long l = personInfoDao.getCount(criteria, "id", Long.class);
    	return Float.valueOf(l);
    }
    
    private Criteria getCriteria(List<String> orgCode,Map<String,String> map,Date startDate, Date endDate){
    	Criteria criteria = new Criteria();
    	if(ObjectUtil.isNotEmpty(orgCode)){
    		String orgKey = map.get("orgKey");
    		String[] orgs = new String[orgCode.size()];
        	orgCode.toArray(orgs);
        	criteria.add(orgKey,OP.IN,orgs);
    	}
    	
    	String dateKey = map.get("dateKey");
    	if(ObjectUtil.isNotEmpty(dateKey)){
    		DateUtil.getCriteriaByDateRange(criteria, dateKey, startDate, endDate);
    	}
    	return criteria;
    }

	@Override
	public Float getHETarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getVaccinateTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getWomenChildrenTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHmTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getCDMTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getIDMTarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getHSATarget(List<String> orgCode, Date startDate,
			Date endDate, String targetCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Float getMhmTarget(String orgCode,String orgType, Date startDate, Date endDate, String targetCode) {
		return null;
	}
}
