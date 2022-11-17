package com.founder.rhip.whch.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.child.ChildWeekExamNum;
import com.founder.rhip.ehr.repository.child.IChildWeekExamNumDao;
import com.founder.rhip.ehr.service.child.IChildWeekExamNumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yuanzg on 2017/6/16.
 */
@Service("childWeekExamNumService")
public class ChildWeekExamNumServiceImpl implements IChildWeekExamNumService{

    @Resource(name = "childWeekExamNumDao")
    private IChildWeekExamNumDao childWeekExamNumDao;
    @Override
    public void save(ChildWeekExamNum childWeekExamNum) {
        childWeekExamNumDao.insert(childWeekExamNum);
    }

    @Override
    public ChildWeekExamNum getChildNum(Criteria criteria) {
        return childWeekExamNumDao.get(criteria);
    }

    @Override
    public void delete(Criteria criteria) {
        childWeekExamNumDao.delete(criteria);
    }
}
