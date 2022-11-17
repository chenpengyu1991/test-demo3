package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.DmPotentialPersonParam;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of DmPotentialPerinfo
 * 
 */
@Repository("dmPotentialPersonParamDao")
public class DmPotentialPersonPramDaoImpl extends AbstractDao<DmPotentialPersonParam, Long> implements IDmPotentialPersonParamDao {
	  @Resource(name = "phbdbJDBCTemplate")
	    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public boolean truncateTable() {
		StringBuilder sb = new StringBuilder();
		boolean result=true;
		try {
			sb.append(" TRUNCATE TABLE  DM_POTENTIAL_PERSON_PARAM");
			 this.delete(sb.toString());
		} catch (Exception e) {
			result=false;
			logger.error("DM_POTENTIAL_PERSON_PARAM表删除失败"+e);
		}
		return result;
	}
}
