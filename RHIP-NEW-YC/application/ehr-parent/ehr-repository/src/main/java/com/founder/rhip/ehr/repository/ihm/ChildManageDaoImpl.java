package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.child.ChildUnderThreeManage;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("childManageDao")
public class ChildManageDaoImpl extends AbstractDao<ChildUnderThreeManage, Long> implements IChildManageDao{
	
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public List<ChildUnderThreeManage> getChildManageRate(String criteria,String gbCode) {
		
		StringBuilder sql = new StringBuilder("SELECT (SUM(MANAGEMENT_NUMBER)/SUM(UNDERTHREE_NUMBER))*100 AS managementRate,");
		sql.append(" SUM(UNDERTHREE_NUMBER) as underThreeNumber, SUM(MANAGEMENT_NUMBER) as managementNumber,");
		sql.append(" GBCODE AS gbCode FROM CH_UNDERTHREE_MANAGEMENT");
		sql.append(" WHERE MONTH_RECORD in "+criteria);
		
    	sql.append(" GROUP BY GBCODE");
    	
    	if(!gbCode.equals("")){
    		sql.append(" HAVING GBCODE = "+gbCode);
    	}
		List<ChildUnderThreeManage> list = this.getList(sql.toString());
		return list;
	}
	
}
