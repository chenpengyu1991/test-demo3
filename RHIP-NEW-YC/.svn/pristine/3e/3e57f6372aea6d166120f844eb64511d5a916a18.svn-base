package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.management.DmPersonInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of DmPersonInfo
 * 
 */
@Repository("dmPersonInfoDao")
public class DmPersonInfoDaoImpl extends AbstractDao<DmPersonInfo, Long> implements IDmPersonInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<DmPersonInfo> getStandardizationPersonInfoList(Criteria criteria) {
		StringBuilder sb = new StringBuilder();
		if(criteria.get("personId") != null) {
			sb.append("SELECT * FROM DM_PERSON_INFO WHERE TYPE = 2 AND PERSON_ID IN(" + criteria.get("personId") + ")");
			return this.getList(sb.toString());
		}
		else {
			return null;
		}
	}
	
	@Override
	public List<DmPersonInfo> getReportCardPersonInfoList(Criteria criteria) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM DM_PERSON_INFO");
		SqlBuilder.buildWhereStatement(DmPersonInfo.class, sb, criteria);
		return this.getList(sb.toString(), criteria);
	}
	
}