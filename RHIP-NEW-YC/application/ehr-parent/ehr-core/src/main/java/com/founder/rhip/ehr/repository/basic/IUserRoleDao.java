package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.UserRole;

import java.util.List;

/**
 * DAO interface of UserRole
 */
public interface IUserRoleDao extends IDao<UserRole, Long> {

    /**
     * 根据条件获取MDM_USER_ROLE中的org_code
     * @param criteria
     * @return
     */
    public List<String> getDistinctOrgCodes(Criteria criteria);
}