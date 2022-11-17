package com.founder.rhip.ehr.service.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-6-5
 * Time: 下午4:06
 * To change this template use File | Settings | File Templates.
 */
public interface IUserOperationLogService {

    /**
     * 创建操作
     * @param userOperationLog
     */
    void createOperationLog(UserOperationLog userOperationLog);

    /**
     * 查询列表
     * @param criteria
     * @param page
     * @return
     */
    PageList<UserOperationLog> getList(Page page, Criteria criteria);
}
