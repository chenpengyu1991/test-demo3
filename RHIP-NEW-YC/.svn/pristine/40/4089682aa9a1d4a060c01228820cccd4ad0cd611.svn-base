
package com.founder.rhip.ehr.repository.basic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.dto.UserOrganization;
import com.founder.rhip.ehr.repository.basic.IUserRoleOrganizationDao;

import javax.annotation.Resource;

/**
 * DAO implement of UserRole
 * 
 */
@Repository("userRoleOrganizationDao")
public class UserRoleDaoOrganizationImpl extends AbstractDao<UserOrganization, Integer> implements IUserRoleOrganizationDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<UserOrganization> getList(Page page, Criteria criteria) {
		criteria.add("U.USER_NAME", OP.IS, "NOT NULL").add("O.NAME", OP.IS, "NOT NULL");
		StringBuilder sql = new StringBuilder("SELECT U.ID,U.USER_NAME,U.NAME,U.GENDER,U.EMAIL,U.TELEPHONE,U.HOME_ADDRESS,U.STATUS,O.ID AS ORGID,O.NAME AS ORGNAME  FROM USERS U");
		sql.append(" LEFT JOIN  (SELECT USER_CODE,ORG_ID FROM USER_ROLE  GROUP BY USER_CODE,ORG_ID) UR ON U.ID=UR.USER_CODE");
		sql.append(" LEFT JOIN ORGANIZATION O ON UR.ORG_ID=O.ID ");
		SqlBuilder.buildWhereStatement(null, sql, criteria);
		sql.append(" ORDER BY U.NAME ASC");
		return getPageList(page, sql.toString(), criteria);
	}
	
	@Override
	public List<UserOrganization> getListNew(long[] userids) {
		StringBuilder userid = new StringBuilder();
		Criteria criteria = new Criteria();
		
		for(long id:userids){
			userid.append(id+",");
		}
		userid.deleteCharAt(userid.lastIndexOf(","));
		
		StringBuilder sb = new StringBuilder("SELECT U.ID,U.USER_NAME,U.NAME,U.GENDER,U.EMAIL,U.TELEPHONE,U.HOME_ADDRESS,U.STATUS,O.ID AS ORGID,O.NAME AS ORGNAME FROM USERS U");
		sb.append(" LEFT JOIN  (SELECT USER_CODE,ORG_ID,TYPE FROM USER_ROLE GROUP BY USER_CODE,ORG_ID,TYPE) UR ON U.ID=UR.USER_CODE");
		sb.append(" LEFT JOIN ORGANIZATION O ON UR.ORG_ID=O.ID ");
		sb.append(" WHERE U.ID IN("+userid+") AND UR.TYPE=0");		
		SqlBuilder.buildOrderStatement(sb, "U.ID ASC");
		return getList(sb.toString(), criteria);
			}
	
	
}