package com.founder.rhip.ehr.repository.basic;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.UserOrganization;

/**
 * DAO interface of UserRole
 */
public interface IUserRoleOrganizationDao extends IDao<UserOrganization, Integer> {
    public PageList<UserOrganization> getList(Page page, Criteria criteria);

    public List<UserOrganization> getListNew(long[] userids);


}