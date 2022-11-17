package com.founder.rhip.portal.repository;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.HospitalInfo;
import com.founder.rhip.ehr.repository.portal.IHospitalInfoDao;

/**
 * DAO implement of HospitalInfo
 * 
 */
@Repository("lhhospitalInfoDao")
public class HospitalInfoDaoImpl extends AbstractDao<HospitalInfo, Long> implements IHospitalInfoDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public List<HospitalInfo> getHosInfoByDistinctHosRegScheduleLists (Criteria criteria) {
		StringBuilder sb = new StringBuilder("select hi.hospital_no, hi.hospital_name, hi.hospital_info");
		sb.append(" from hospital_info hi");
		sb.append(" inner join (select distinct(hospital_code) from register_schedule) rs");
		sb.append(" on (rs.hospital_code = hi.hospital_no)");
		List<HospitalInfo> hospitalInfoList = this.getList(sb.toString(), criteria);
		return hospitalInfoList;
	}

}