package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.DmQuestion;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/5/18.
 */
public interface IDmQuestionDao extends IDao<DmQuestion,Long> {

    public List<DmQuestion> getQuestionList(Criteria criteria);

    public List<Map<String,Object>> searchPercentResult();
}
