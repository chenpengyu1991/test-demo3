package com.founder.rhip.fds.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.fds.entity.Sign;

import java.util.List;

/**
 * DAO interface of Sign
 * 
 */
public interface ISignDao extends IDao<Sign,Long> {
    List<Sign> getServicePackageList(Criteria criteria);
}