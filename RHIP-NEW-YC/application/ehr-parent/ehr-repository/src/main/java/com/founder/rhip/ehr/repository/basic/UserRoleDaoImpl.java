package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.mdm.entity.StaffOrg;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO implement of UserRole
 * 
 */
@Repository("ehrUserRoleDao")
public class UserRoleDaoImpl extends AbstractDao<UserRole, Long> implements IUserRoleDao
{

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 根据条件获取MDM_USER_ROLE中的org_code
     * @param criteria
     * @return
     */
    public List<String> getDistinctOrgCodes(Criteria criteria) {
        StringBuilder sb = new StringBuilder("select DISTINCT organ_code from MDM_USER_ROLE");
        SqlBuilder.buildWhereStatement(UserRole.class, sb, criteria);
        List<UserRole>  userRoles = this.getList(UserRole.class, sb.toString(), criteria);
        List<String> userOrgCodes = new ArrayList<String>();
        for(UserRole userRole : userRoles) {
            userOrgCodes.add(userRole.getOrganCode());
        }
        return userOrgCodes;
    }
}