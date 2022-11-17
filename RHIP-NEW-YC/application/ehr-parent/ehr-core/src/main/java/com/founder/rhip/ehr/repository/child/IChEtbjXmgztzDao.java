package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.child.ChEtbjXmgztz;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of ChEtbjXmgztz
 * 
 */
public interface IChEtbjXmgztzDao extends IDao<ChEtbjXmgztz, Long> {

    /**
     * 0-6岁儿童项目工作台账
     * @param criteria
     * @param order
     * @return
     */
    public List<Map<String, Object>> queryEtbjXmgztzList(Criteria criteria, Order order);

    /**
     * 根据查询条件获取0-6岁儿童项目的合计数据
     * @param criteria
     * @return
     */
    public Map<String, Object> queryTotalEtbjXmgztzGroupByNf(Criteria criteria);
}