package com.founder.rhip.ehr.repository.pbusiness.oh;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.oh.OhEnterpriseInfo;
import com.founder.rhip.ehr.repository.oh.IOhEnterpriseInfoDao;

@Repository("ohEnterpriseInfoDao")
public class OhEnterpriseInfoDaoImpl extends
		AbstractDao<OhEnterpriseInfo, Integer> implements IOhEnterpriseInfoDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<OhEnterpriseInfo> searchEnterpriseInfoList(Page page,
			Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("select id,  file_no, company_name, org_code, addr,postcode,economic_type,industry_type,founded_date,legal_repr,contacts_dept,contacts_name,");
		sql.append("position,phone, mobilephone, create_time,  create_by, update_time, update_by, is_delete from oh_enterprise_info t");
		SqlBuilder
				.buildWhereStatement(OhEnterpriseInfo.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, " update_time DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public Long saveEnterpriseInfo(OhEnterpriseInfo enterpriseInfo) {	
		Number keyId= this.generatedKey(enterpriseInfo,"id",null);
		return  keyId==null?null:keyId.longValue();
	}

	@Override
	public OhEnterpriseInfo searchEnterpriseInfo(Criteria criteria) {
		// TODO Auto-generated method stub
		return this.get(OhEnterpriseInfo.class, criteria);
	}
}
