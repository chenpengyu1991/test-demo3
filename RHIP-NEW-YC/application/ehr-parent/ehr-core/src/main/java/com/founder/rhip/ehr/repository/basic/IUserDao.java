package com.founder.rhip.ehr.repository.basic;

import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.User;

import java.util.List;

/**
 * DAO interface of User
 */
public interface IUserDao extends IDao<User, Long> {

    PageList<User> getUserList1(Page page, Criteria criteria,String roleCode);

    PageList<User> getUserNew(Page page, Criteria criteria, boolean isSuper, String organCode, String roleCode);

    List<User> getUserList(UserRole userRole, Criteria userCriteria);

    PageList<User> getUserList(Page page, Criteria criteria);

}