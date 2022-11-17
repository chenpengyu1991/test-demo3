package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.oh.OhCompanyInfo;
import com.founder.rhip.ehr.repository.oh.IOhCompanyInfoDao;

@Repository("ohCompanyInfoDao")
public class OhCompanyInfoDaoImpl extends AbstractDao<OhCompanyInfo, Integer>
		implements IOhCompanyInfoDao {
	
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public OhCompanyInfo searchCompanyInfo(Criteria criteria) {
		return this.get(OhCompanyInfo.class, criteria);
	}

	@Override
	public Long saveCompanyInfo(OhCompanyInfo companyInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
