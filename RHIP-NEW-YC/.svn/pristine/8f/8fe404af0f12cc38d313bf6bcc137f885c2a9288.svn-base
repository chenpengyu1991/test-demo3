package com.founder.rhip.ehr.service.basic;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;
import com.founder.rhip.ehr.repository.basic.IUserOperationLogDao;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-6-5
 * Time: 下午4:11
 */
@Service("userOperationLogService")
public class UserOperationLogServiceImpl implements IUserOperationLogService {

    @Resource(name = "userOperationLogDao")
    private IUserOperationLogDao userOperationLogDao;

    @Override
    @Transactional
    public void createOperationLog(UserOperationLog userOperationLog) {
            userOperationLogDao.insert(userOperationLog);
    }

    @Override
    public PageList<UserOperationLog> getList(Page page, Criteria criteria) {
            return userOperationLogDao.getPageList(page,criteria,new Order("OPERATION_TIME",false));
    }
}
