package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.AiHiDrugCatalog;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * DAO implement of AiHiDrugCatalog
 * 
 */
@Repository("aiHiDrugCatalogDao")
public class AiHiDrugCatalogDaoImpl extends AbstractDao<AiHiDrugCatalog, Long> implements IAiHiDrugCatalogDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
}