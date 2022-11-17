package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmSetup;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of IdmSetup
 * 
 */
@Repository("idmSetupDao")
public class SetupDaoImpl extends AbstractDao<IdmSetup, Long> implements ISetupDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    @Override
    public void deleteSetups(String[] infectiousCodes, String[] caseOrganCodes, Integer getSetYear){

		StringBuilder sql = new StringBuilder();
		sql.append(" DELETE FROM IDM_SETUP  WHERE ");

	    for(int i = 0; i < infectiousCodes.length; i++){
		  for(int j = 0; j < caseOrganCodes.length; j++){
			  if(i == 0 && j == 0){
				  sql.append("  ( infectious_Code = '" + infectiousCodes[i] +"' and case_Organ_Code = '" + caseOrganCodes[j] +"' ) ");
			  } else {
				  sql.append(" OR ").append( " ( infectious_Code = '" + infectiousCodes[i] +"' and case_Organ_Code = '" + caseOrganCodes[j] +"' ) "); 
			  }  
		  }
	    }
	    //2017-6-12修改 个案参数设置跟年份无关（不再按照每年设置一次）
		//sql.append(" AND SET_YEAR= " +  getSetYear );
		this.delete(sql.toString());
    }

	/**
	 * 根据条件查询出不重复的INFECTIOUS_CODE
	 * @param criteria
	 * @return
	 */
	@Override
	public List<IdmSetup> findDistinctInfectiousCodes(Criteria criteria){
		StringBuilder sqlBuilder = new StringBuilder("select DISTINCT INFECTIOUS_CODE from IDM_SETUP");
		SqlBuilder.buildWhereStatement(IdmSetup.class, sqlBuilder, criteria) ;
		return this.getList(sqlBuilder.toString(), criteria);
	}
}