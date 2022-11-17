package com.founder.rhip.ehr.repository.control.idm.statistics.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.statistics.report.Supervisor;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of IdmSupervisor
 * 
 */
@Repository("idmSupervisorDao")
public class SupervisorDaoImpl extends AbstractDao<Supervisor, Long> implements ISupervisorDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
  
	/**
	 * 合计
	 * @param criteria
	 * @param summaryType
	 * @return Supervisor
	 */    
    public Supervisor getSummary(Criteria criteria, String summaryType){
    	Object reportMonth = criteria.get("REPORT_MONTH");
    	Object reportUnitCode = criteria.get("REPORT_UNIT_CODE");
    	Object genreCode = criteria.get("GENRE_CODE");
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT nvl(sum(ZERO_DEFECT_ORG_NUM),0) sumZeroDefectOrgNum,");
		sql.append(" nvl(sum(ZERO_DEFECT_MEDICAL_NUM),0) sumZeroDefectMedicalNum,");
		sql.append(" nvl(sum(DIRECT_NUM_PROVINCE),0) sumDirectNumProvince,");
		sql.append(" nvl(sum(DIRECT_NUM_CITY),0) sumDirectNumCity,");
		sql.append(" nvl(sum(DIRECT_NUM_COUNTY),0) sumDirectNumCounty,");
		sql.append(" nvl(sum(SUPERVISOR_NUM),0) sumSupervisorNum,");
		sql.append(" nvl(sum(SUPERVISOR_MISS_NUM),0) sumSupervisorMissNum,");
		sql.append(" nvl(avg(SUPERVISOR_MISS_RATE),0) avgSupervisorMissRate,");
		sql.append(" nvl(sum(NETWORK_NUM_CITY),0) sumNetworkNumCity,");
		sql.append(" nvl(sum(NETWORK_NUM_COUNTY),0) sumNetworkNumCounty,");
		sql.append(" nvl(sum(NETWORK_NUM),0) sumNetworkNum,");
		sql.append(" nvl(sum(NETWORK_MISS_NUM),0) sumNetworkMissNum,");
		sql.append(" nvl(avg(NETWORK_MISS_RATE),0) avgNetworkMissRate FROM IDM_SUPERVISOR");
 
		if(summaryType.equals("1")){//按月
			sql.append(" WHERE TO_CHAR(REPORT_MONTH,'yyyy/MM') ='");
			
		}else{//按年
			sql.append(" WHERE TO_CHAR(REPORT_MONTH,'yyyy') ='");
		}
		sql.append(reportMonth + "'");
		if(ObjectUtil.isNotEmpty(reportUnitCode)){
			sql.append(" AND REPORT_UNIT_CODE ='");
			sql.append(reportUnitCode + "'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'"); 
		}
		
    	return get(sql.toString(),new Criteria());
    }
 
	/**
	 * 汇总
	 * @param criteria
	 * @param summaryType
	 * @return List<Supervisor>
	 */    
    public List<Supervisor> findSupervisorFill(Criteria criteria, String summaryType){
    	Object reportMonth = criteria.get("REPORT_MONTH");
    	Object reportUnitCode = criteria.get("REPORT_UNIT_CODE");
    	Object genreCode = criteria.get("GENRE_CODE");
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM IDM_SUPERVISOR");
		if(summaryType.equals("1")){//按月
			sql.append(" WHERE TO_CHAR(REPORT_MONTH,'yyyy/MM') ='");
			
		}else{//按年
			sql.append(" WHERE TO_CHAR(REPORT_MONTH,'yyyy') ='");
		}
		sql.append(reportMonth + "'");
		if(ObjectUtil.isNotEmpty(reportUnitCode)){
			sql.append(" AND REPORT_UNIT_CODE ='");
			sql.append(reportUnitCode + "'");
		}else if(ObjectUtil.isNotEmpty(genreCode)){
			sql.append(" AND GENRE_CODE ='");
			sql.append(genreCode + "'");
		}
		SqlBuilder.buildOrderStatement(sql, "REPORT_UNIT_CODE,REPORT_MONTH ASC");
    	return this.getList(sql.toString());
    }
}