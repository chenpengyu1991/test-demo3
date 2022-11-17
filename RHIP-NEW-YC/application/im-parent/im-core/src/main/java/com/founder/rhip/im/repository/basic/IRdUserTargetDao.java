package com.founder.rhip.im.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.im.entity.basic.RdUserTarget;

import java.util.List;

/**
 * DAO interface of UserTarget
 * 
 */
public interface IRdUserTargetDao extends IDao<RdUserTarget,Long> {

    /**
     * 获取首页布局指标数据
     * @param criteria
     * @return
     */
    List<RdUserTarget> getUserTargetList(Criteria criteria);
}