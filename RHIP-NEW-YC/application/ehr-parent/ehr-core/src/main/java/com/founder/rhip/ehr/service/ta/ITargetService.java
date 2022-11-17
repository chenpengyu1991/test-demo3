package com.founder.rhip.ehr.service.ta;

import java.util.List;
import java.util.Set;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.rhip.ehr.entity.ta.TargetResultValue;

/**
 * The interface ITargetService.
 *
 * @author liuk
 * @since 2014年4月4日 09:19:09
 */
public interface ITargetService {

    /**
     * queryTargetResultValues
     *
     * @param page             the page
     * @param criteria             the criteria
     * @param order             the order
     * @param properties             the properties
     * @return the list
     */
	List<TargetResultValue> queryTargetResultValues(Page page, Criteria criteria, Order order, Set<String> properties);

    /**
     * addOrUpdate TargetResultValue 自动处理属性,
     *
     * @param targetResultValue             the target result value
     * @param organCode the organ code
     * @param userId the user id
     */
	public void addOrUpdateTargetResultValue(TargetResultValue targetResultValue,String organCode, String userId);

    /**
     *
     * addOrUpdate TargetResultValue 执行需要处理的属性, properties必须有值,否则exception
     *
     * @param targetResultValue             the target result value
     * @param organCode the organ code
     * @param userId the user id
     * @param properties             the properties 必须有值,否则exception
     */
	public Long addOrUpdateTargetResultValue(TargetResultValue targetResultValue, String organCode, String userId, Set<String> properties);

}
