package com.founder.rhip.ehr.repository.control.idm.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.ListScDc;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.SelfCheck;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of IdmScDc
 * 
 */
@Repository("idmScDcDao")
public class ListScDcDaoImpl extends AbstractDao<ListScDc, Long> implements IListScDcDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	/**
	 * 查询科室传染病信息
	 * @param criteria
	 * @return List<ListScDc>
	 */    
    public List<ListScDc> findDepartmentInfection(Criteria criteria, List<ListScDc> existsInfection){
    	List<ListScDc> result = null;
    	String sql = getInfectionSql(criteria,existsInfection);
    	if(StringUtil.isNotEmpty(sql)){
    		result = getList(sql,criteria);
    	}
    	return result;
    } 

	/**
	 * 生成SQL
	 * @param criteria
	 * @return String
	 */  
    private String getInfectionSql(Criteria criteria, List<ListScDc> existsInfection){
		StringBuilder sql = new StringBuilder();
		Object reportMonth = criteria.get("REPORT_MONTH");
		Object reportUnitCode = criteria.get("REPORT_UNIT_CODE");
		Object departmentCode = criteria.get("DEPARTMENT_CODE");
		Criteria ca = new Criteria("REPORT_UNIT_CODE",reportUnitCode);
		ca.add("DEPARTMENT_CODE",departmentCode);
		for(ListScDc scDc:existsInfection){
			String infectionCode = scDc.getInfectiousCode();
			if(sql.length() > 0){
				sql.append("   UNION ALL");
			}
			sql.append("   SELECT DISTINCT NVL((SELECT MISS_NUM  FROM idm_sc_dc");
			SqlBuilder.buildWhereStatement(ListScDc.class, sql, ca) ;
			sql.append(" AND REPORT_MONTH = TO_DATE('");
			sql.append(reportMonth);
			sql.append("', 'yyyy/mm/dd')");
			sql.append("   AND INFECTIOUS_CODE ='" + infectionCode + "'),0) MISS_NUM," );
			sql.append("   NVL((SELECT SHOULD_NUM  FROM idm_sc_dc");
			SqlBuilder.buildWhereStatement(ListScDc.class, sql, ca) ;
			sql.append(" AND REPORT_MONTH = TO_DATE('");
			sql.append(reportMonth);
			sql.append("', 'yyyy/mm/dd')");
			sql.append("   AND INFECTIOUS_CODE ='" + infectionCode + "'),0) SHOULD_NUM" );
			sql.append("   FROM IDM_SC_DC " );
		}
		return sql.toString();
    }
    /**
     * 获取本机构，本月共上报多少种传染病
     * @param       criteria
     * @return      List<ListScDc>
     */
    public List<ListScDc> findInfections(Criteria criteria){
    	StringBuilder sql = new StringBuilder();
    	Object reportMonth = criteria.get("REPORT_MONTH");
		Object reportUnitCode = criteria.get("REPORT_UNIT_CODE");
		Criteria ca = new Criteria("REPORT_UNIT_CODE",reportUnitCode);
		sql.append(" SELECT  DISTINCT INFECTIOUS_CODE FROM IDM_SC_DC ");
		SqlBuilder.buildWhereStatement(SelfCheck.class, sql, ca) ;
		sql.append(" AND REPORT_MONTH = TO_DATE('");
		sql.append(reportMonth);
		sql.append("', 'yyyy/mm/dd')");
		SqlBuilder.buildOrderStatement(sql, " INFECTIOUS_CODE DESC");
    	return getList(sql.toString(),ca);
    }

    
	/**
	 * 合计传染病信息
	 * @param criteria
	 * @return List<ListScDc>
	 */    
    public List<ListScDc> summaryInfection(Criteria criteria){
    	List<ListScDc> result = null;
    	String sql = getInfectionSummarySql(criteria);
    	if(StringUtil.isNotEmpty(sql)){
    		result = getList(sql,criteria);
    	}
    	return result;
    }
	/**
	 * 生成SQL-合计
	 * @param criteria
	 * @return String
	 */  
    private String getInfectionSummarySql(Criteria criteria){
    	List<ListScDc> exists = findInfections(criteria);
		StringBuilder sql = new StringBuilder();
		Object reportMonth = criteria.get("REPORT_MONTH");
		Object reportUnitCode = criteria.get("REPORT_UNIT_CODE");
		Criteria ca = new Criteria("REPORT_UNIT_CODE",reportUnitCode);
		for(ListScDc scDc:exists){
			String infectionCode = scDc.getInfectiousCode();
			if(sql.length() > 0){
				sql.append("   UNION ALL");
			}
			sql.append("   SELECT NVL(SUM(MISS_NUM),0) MISS_NUM,NVL(SUM(SHOULD_NUM),0) SHOULD_NUM  FROM idm_sc_dc");
			SqlBuilder.buildWhereStatement(ListScDc.class, sql, ca) ;
			sql.append(" AND REPORT_MONTH = TO_DATE('");
			sql.append(reportMonth);
			sql.append("', 'yyyy/mm/dd')");
			sql.append("   AND INFECTIOUS_CODE ='" + infectionCode + "'" );
		}
		return sql.toString();
    }    
}