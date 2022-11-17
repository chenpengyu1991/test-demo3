package com.founder.rhip.ehr.repository.basic;

import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.AdministrativeArea;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of AdministrativeArea
 * 
 */
@Repository("administrativeAreaDao")
public class AdministrativeAreaDaoImpl extends
		AbstractDao<AdministrativeArea, Long> implements IAdministrativeAreaDao {
	public static final String SQL_QUERYALL = "SELECT * FROM BI_ADMINISTRATIVE_AREA";

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<AdministrativeArea> getAll() {
		return this.getList(SQL_QUERYALL);
	}
}