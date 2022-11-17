package com.founder.rhip.ehr.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PortalUser;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;

import java.util.List;

/**
 * DAO interface of PortalUser
 */
public interface IPortalUserDao extends IDao<PortalUser, Long> {

}