package com.founder.rhip.portal.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;

/**
 * @author Zhou Yang
 *
 */
public interface IHospitalInfoService {

	PageList<HospitalInfo> getList(Page page, Criteria criteria);
	
	PageList<HospitalInfo> getPortalLists(Page page, Criteria criteria);
	
	PageList<HospitalInfo> getPortalList(Page page, String[] param, String orgType);

	List<HospitalInfo> get(Criteria criteria);
	
	boolean update(HospitalInfo hospitalInfo, Map<String, String> map, String createUserCode);
	
	int update(Parameters parameters, Criteria criteria) ;
	
	boolean insert(HospitalInfo hospitalInfo, Map<String, String> map, String createUserCode);
	
	public HospitalInfo get(Long id);
	
	public HospitalInfo getHospitalinfo(Criteria criteria);
	
	/**
	 * 查询医院数量
	 *
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	Integer getHospitalCount(Criteria criteria);
	
	public int delete(Long id);
	
	/***
	 * 预约快速搜索
	 * 从资源表里去重复hospitalCode,
	 * 并从医院表里查hospitalNo,hospitalName和hospitalIfo信息
	 * @param criteria
	 * @return
	 */
	public List<HospitalInfo> getHosInfoByDistinctHosRegScheduleLists (Criteria criteria);
	
	/**
	 * 显示HospitalInfo表里的所有医院
	 * @return
	 */
	public List<HospitalInfo> getAllHospital();
}
