package com.founder.rhip.ph.service.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.oh.OhChemicalsUsed;
import com.founder.rhip.ehr.entity.control.oh.OhCondition;
import com.founder.rhip.ehr.entity.control.oh.OhContactSituation;
import com.founder.rhip.ehr.entity.control.oh.OhEnterpriseInfo;
import com.founder.rhip.ehr.entity.control.oh.OhEquipment;
import com.founder.rhip.ehr.entity.control.oh.OhTestItems;

public interface IEnterpriseDocService {
	
	/**
	 * 查询重点企业
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<OhEnterpriseInfo>
	 */
	public PageList<OhEnterpriseInfo> searchEnterpriseInfoList(Criteria criteria, Page page);
	
	/**
	 * 保存企业基本信息
	 * @param       OhEnterpriseInfo
	 * @return      OhEnterpriseInfo
	 */
	public Boolean saveEnterpriseInfo(OhEnterpriseInfo enterpriseInfo, String opType);
	
	/**
	 * 查询重点企业
	 * @param       Criteria
	 * @return      OhEnterpriseInfo
	 */
	public OhEnterpriseInfo searchEnterpriseInfo(Criteria criteria);
	
	/**
	 * 查询重点企业职业卫生情况
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<OhCondition>
	 */
	public PageList<OhCondition> searchConditionList(Criteria criteria, Page page);
	
	/**
	 * 保存职业卫生情况
	 * @param       OhCondition
	 * @return      Boolean
	 */
	public Boolean saveCondition(OhCondition condition, String opType);
	
	/**
	 * 查询职业卫生情况
	 * @param       Criteria
	 * @return      OhCondition
	 */
	public OhCondition searchCondition(Criteria criteria);
	
	/**
	 * 查询化学物质使用情况
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<OhCondition>
	 */
	public PageList<OhChemicalsUsed> searchChemicalsUsedList(Criteria criteria, Page page);
	
	/**
	 * 查询化学物质使用
	 * @param       Criteria
	 * @return      OhChemicalsUsed
	 */
	public OhChemicalsUsed searchChemicalsUsed(Criteria criteria);
	
	/**
	 * 保存化学物质使用
	 * @param       OhCondition
	 * @return      Boolean
	 */
	public Boolean saveChemicalsUsed(OhChemicalsUsed chemicalsUsed, String opType);
	
	/**
	 * 查询危害因素接触
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<OhContactSituation>
	 */
	public PageList<OhContactSituation> searchContactSituationList(Criteria criteria, Page page);
	
	/**
	 * 查询危害因素接触
	 * @param       Criteria
	 * @return      OhContactSituation
	 */
	public OhContactSituation searchContactSituation(Criteria criteria);
	
	/**
	 * 保存危害因素接触
	 * @param       OhCondition
	 * @return      Boolean
	 */
	public Boolean saveContactSituation(OhContactSituation contactSituation, String opType);
	
	/**
	 * 查询主要生产设备
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<OhContactSituation>
	 */
	public PageList<OhEquipment> searchEquipmentList(Criteria criteria, Page page);
	
	/**
	 * 查询主要生产设备
	 * @param       Criteria
	 * @return      OhEquipment
	 */
	public OhEquipment searchEquipment(Criteria criteria);
	
	/**
	 * 保存主要生产设备
	 * @param       OhEquipment
	 * @return      Boolean
	 */
	public Boolean saveEquipment(OhEquipment equipment, String opType);
	
	/**
	 * 查询监测点
	 * 分页
	 * @param       Criteria
	 * @param       Page
	 * @return      PageList<OhTestItems>
	 */
	public PageList<OhTestItems> searchTestItemsList(Criteria criteria, Page page);
	
	/**
	 * 查询监测点
	 * @param       Criteria
	 * @return      OhTestItems
	 */
	public OhTestItems searchTestItem(Criteria criteria);
	
	/**
	 * 保存监测点及示意图
	 * @param       OhTestItems
	 * @return      Boolean
	 */
	public Boolean saveTestItem(OhTestItems testItem, String opType);
}
