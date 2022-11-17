package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of User
 * 
 */
@Repository("ehrUserDao")
public class UserDaoImpl extends AbstractDao<User, Long> implements IUserDao{
	
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;


	@Override
	public PageList<User> getUserList1(Page page, Criteria criteria, String roleCode) {

		StringBuilder sb = new StringBuilder(" SELECT a.ID,a.USER_NAME,a.NAME,a.GENDER,a.EMAIL,a.TELEPHONE,a.HOME_ADDRESS,a.STATUS FROM (SELECT ID,USER_NAME,NAME,GENDER,EMAIL,TELEPHONE,HOME_ADDRESS,STATUS FROM MDM_USERS");
		sb.append(" WHERE ID IN(SELECT USER_CODE FROM MDM_USER_ROLE role WHERE role.TYPE=0");

		if (ObjectUtil.isNotEmpty(roleCode)) {
			sb.append(" and role.role_code = " + roleCode + "'");
		}
		sb.append(" ) ) a  ");
		SqlBuilder.buildWhereStatement(User.class, sb, criteria);
		SqlBuilder.buildOrderStatement(sb, " a.USER_NAME ASC ");
		return this.getPageList(page, sb.toString(), criteria);
	}

	@Override
	public PageList<User> getUserList(Page page, Criteria criteria) {
		StringBuilder sb = new StringBuilder("  SELECT distinct a.ID,a.USER_CODE, a.USER_NAME,a.NAME,a.GENDER,a.EMAIL,a.TELEPHONE,a.HOME_ADDRESS,a.STATUS ");
		sb.append(" FROM  MDM_USERS a left join MDM_USER_ROLE role on (a.USER_CODE = role.USER_CODE and role.type = '0')");
		SqlBuilder.buildWhereStatement(User.class, sb, criteria);
		SqlBuilder.buildOrderStatement(sb, " a.USER_NAME ASC ");
		return this.getPageList(page, sb.toString(), criteria);
	}

	@Override
	public PageList<User> getUserNew(Page page, Criteria criteria, boolean isSuper, String organCode, String roleCode) {
		StringBuilder sb = new StringBuilder(" SELECT a.ID,a.USER_NAME,a.NAME,a.GENDER,a.EMAIL,a.TELEPHONE,a.HOME_ADDRESS,a.STATUS FROM (SELECT ID,USER_NAME,NAME,GENDER,EMAIL,TELEPHONE,HOME_ADDRESS,STATUS FROM MDM_USERS");
		sb.append(" WHERE ID IN(SELECT USER_CODE FROM MDM_USER_ROLE role WHERE role.TYPE=0");

		if (ObjectUtil.isNotEmpty(organCode)) {
			sb.append(" and role.ORGAN_CODE = " + organCode);
		}
		if (ObjectUtil.isNotEmpty(roleCode)) {
			sb.append(" and role.role_code = '" + roleCode + "'");
		}
		sb.append("AND role.USER_CODE NOT IN (SELECT USER_CODE FROM MDM_USER_ROLE WHERE ROLE_CODE = 9");
		if(!isSuper){
			sb.append(" OR ROLE_CODE = 1 ");
		}

		sb.append(" ) GROUP BY USER_CODE)) a  ");
		SqlBuilder.buildWhereStatement(User.class, sb, criteria);
		SqlBuilder.buildOrderStatement(sb, " a.USER_NAME ASC ");
		return this.getPageList(page, sb.toString(), criteria);

	}

	public List<User> getUserList(UserRole userRole, Criteria userCriteria) {
		StringBuilder sql = new StringBuilder("select u.*　from MDM_USERS u join MDM_USER_ROLE ur on  u.id = ur.USER_CODE");
		sql.append(" and ur.role_code = ");
		sql.append(userRole.getRoleCode());
		sql.append(" and ORGAN_CODE = '");
		sql.append(userRole.getOrganCode() + "'");
		SqlBuilder.buildWhereStatement(User.class, sql, userCriteria);
		return getList(sql.toString(), userCriteria);
	}
} 
