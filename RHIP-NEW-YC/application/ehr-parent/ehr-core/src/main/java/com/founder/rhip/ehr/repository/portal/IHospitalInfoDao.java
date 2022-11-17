package com.founder.rhip.ehr.repository.portal;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;

/**
 * DAO interface of HospitalInfo
 * 
 */
public interface IHospitalInfoDao extends IDao<HospitalInfo,Long> {

	/***
	 * 预约快速搜索
	 * 从资源表里去重复hospitalCode,
	 * 并从医院表里查hospitalNo,hospitalName和hospitalIfo信息
	 * @param criteria
	 * @return
	 */
	public List<HospitalInfo> getHosInfoByDistinctHosRegScheduleLists (Criteria criteria);

}