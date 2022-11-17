package com.founder.rhip.ehr.repository.control.idm.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.SelfCheck;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of IdmSelfCheck
 * 
 */
@Repository("idmSelfCheckDao")
public class SelfCheckDaoImpl extends AbstractDao<SelfCheck, Long> implements ISelfCheckDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	/**
	 * 查询科室传染病信息
	 * @param criteria
	 * @return List<ListScDc>
	 */    
    public List<SelfCheck> findSelfCheck(Criteria criteria, List<DicItem> departments ){
    	String sql = getSelfCheckSql(criteria,departments);
    	return getList(sql,criteria);
    } 
    
	/**
	 * 查询科室列表
	 * @param criteria
	 * @return List<ListScDc>
	 */   
    public List<SelfCheck> findDepartment(Criteria criteria){
    	StringBuilder sql = new StringBuilder();
    	Object reportMonth = criteria.get("REPORT_MONTH");
    	Object reportUnitCode = criteria.get("REPORT_UNIT_CODE");
    	Criteria ca = new Criteria("REPORT_UNIT_CODE",reportUnitCode);
		sql.append(" SELECT DEPARTMENT_CODE FROM IDM_SELF_CHECK ");
		SqlBuilder.buildWhereStatement(SelfCheck.class, sql, ca) ;
		sql.append(" AND REPORT_MONTH = TO_DATE('");
		sql.append(reportMonth);
		sql.append("', 'yyyy/mm/dd')");
		return getList(sql.toString(),ca);
    }

	/**
	 * 生成SQL
	 * @param criteria
	 * @return String
	 */  
    private String getSelfCheckSql(Criteria criteria, List<DicItem> departments){
		StringBuilder sql = new StringBuilder();
		Object reportMonth = criteria.get("REPORT_MONTH");
		Object reportUnitCode = criteria.get("REPORT_UNIT_CODE");
		Criteria ca = new Criteria("REPORT_UNIT_CODE",reportUnitCode);
		for(DicItem item:departments){
			String departmentCode = item.getItemCode();
			if(sql.length() > 0){
				sql.append(" UNION ALL");
			}
			sql.append(" select DISTINCT '" + departmentCode + "' department_code,");
			sql.append(" NVL((SELECT CHECK_NUM FROM IDM_SELF_CHECK");
			SqlBuilder.buildWhereStatement(SelfCheck.class, sql, ca) ;
			sql.append(" AND REPORT_MONTH=TO_DATE('");
			sql.append(reportMonth);
			sql.append("', 'yyyy/mm/dd')");
			sql.append(" AND DEPARTMENT_CODE='" + departmentCode + "'),0) CHECK_NUM," );
			sql.append(" NVL((SELECT SHOULD_NUM FROM IDM_SELF_CHECK");
			SqlBuilder.buildWhereStatement(SelfCheck.class, sql, ca) ;
			sql.append(" AND REPORT_MONTH=TO_DATE('");
			sql.append(reportMonth);
			sql.append("', 'yyyy/mm/dd')");
			sql.append(" AND DEPARTMENT_CODE='" + departmentCode + "'),0) SHOULD_NUM," );	
			sql.append(" NVL((SELECT MISS_NUM FROM IDM_SELF_CHECK");
			SqlBuilder.buildWhereStatement(SelfCheck.class, sql, ca) ;
			sql.append(" AND REPORT_MONTH=TO_DATE('");
			sql.append(reportMonth);
			sql.append("', 'yyyy/mm/dd')");
			sql.append(" AND DEPARTMENT_CODE='" + departmentCode + "'),0) MISS_NUM," );
			sql.append(" NVL((SELECT MISS_RATE FROM IDM_SELF_CHECK");
			SqlBuilder.buildWhereStatement(SelfCheck.class, sql, ca) ;
			sql.append(" AND REPORT_MONTH=TO_DATE('");
			sql.append(reportMonth);
			sql.append("', 'yyyy/mm/dd')");
			sql.append(" AND DEPARTMENT_CODE='" + departmentCode + "'),0) MISS_RATE" );
			sql.append(" FROM IDM_SELF_CHECK " );
		}
		return sql.toString();
    } 

	/**
	 * 合计传染病报告
	 * @param criteria
	 * @return SelfCheck
	 */    
    public SelfCheck summarySelfCheck(Criteria criteria){
    	String sql = getSelfCheckSummarySql(criteria);
    	return get(sql,criteria);
    } 
	/**
	 * 生成SQL:合计
	 * @param criteria
	 * @return String
	 */  
    private String getSelfCheckSummarySql(Criteria criteria){
		StringBuilder sql = new StringBuilder();
		Object reportMonth = criteria.get("REPORT_MONTH");
		Object reportUnitCode = criteria.get("REPORT_UNIT_CODE");
		Criteria ca = new Criteria("REPORT_UNIT_CODE",reportUnitCode);
		sql.append("  SELECT NVL(SUM(CHECK_NUM),0) CHECK_NUM,NVL(SUM(SHOULD_NUM),0)  SHOULD_NUM,NVL(SUM(MISS_NUM),0)  MISS_NUM,NVL(AVG(MISS_RATE),0)   MISS_RATE FROM IDM_SELF_CHECK");
		SqlBuilder.buildWhereStatement(SelfCheck.class, sql, ca) ;
		sql.append(" AND REPORT_MONTH = TO_DATE('");
		sql.append(reportMonth);
		sql.append("', 'yyyy/mm/dd')");
		return sql.toString();
    }  
    
	/**
	 * 合计传染病报告
	 * @param criteria
	 * @return SelfCheck
	 */    
    public SelfCheck summaryNeonate(Criteria criteria){
		StringBuilder sql = new StringBuilder();
		Object reportMonth = criteria.get("REPORT_MONTH");
		Object reportUnitCode = criteria.get("REPORT_UNIT_CODE");
		Criteria ca = new Criteria("REPORT_UNIT_CODE",reportUnitCode);
		ca.add("TYPE","2");
		sql.append("  SELECT  NEONATE_NUM,THREE_NEONATE_NUM,BCG_SHOULD_NUM,");
		sql.append(" HBV_SHOULD_NUM,HBV_ACTUAL_NUM,HBV_ACTUAL_RATE,");
		sql.append(" BCG_ACTUAL_NUM,BCG_ACTUAL_RATE FROM IDM_SELF_CHECK");
		SqlBuilder.buildWhereStatement(SelfCheck.class, sql, ca) ;
		sql.append(" AND REPORT_MONTH = TO_DATE('");
		sql.append(reportMonth);
		sql.append("', 'yyyy/mm/dd')");
    	return get(sql.toString(),ca);
    }
    
    /**查询直报报表数据：创建人、创建机构、创建时间
	 * @param orgCode
	 * @param fillDate
	 * @return	SelfCheck
	 */
	@Override
    public SelfCheck getSelfCheckInfo(String orgCode, String fillDate){
		StringBuilder sql = new StringBuilder();
		sql.append(" select REPORT_UNIT_CODE,REPORT_DATE,REPORT_USER_CODE");
		sql.append(" from IDM_SELF_CHECK");
		sql.append(" WHERE TO_CHAR(REPORT_MONTH,'yyyy/mm')='");
		sql.append(fillDate + "'");
		sql.append(" AND REPORT_UNIT_CODE='" + orgCode + "'");
		sql.append(" and rownum = 1");
		SqlBuilder.buildOrderStatement(sql, " REPORT_DATE DESC");
		return this.get(sql.toString(),new Criteria());
    }    
}