package com.founder.rhip.ehr.repository.management.mhm;

import java.util.Date;
import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmStatusInfo;

/**
 * DAO interface of MhmStatusInfo
 * 
 */
public interface IMhmHealthTargetDao extends IDao<MhmStatusInfo,Long> {
	
	/**
	 * 获取精神卫生统计指标
	 *
	 * @param orgCode
	 * @param orgType
	 * @param startDate
	 * @param endDate
	 * @param targetCode
	 * @return
	 * @author Ye jianfei
	 */
	public Float getMhmTarget(String orgCode,String orgType, Date startDate, Date endDate, String targetCode);

}