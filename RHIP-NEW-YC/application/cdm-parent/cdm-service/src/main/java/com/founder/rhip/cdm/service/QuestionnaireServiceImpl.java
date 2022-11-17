package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.management.DmAnswer;
import com.founder.rhip.ehr.entity.management.DmAnswerPeople;
import com.founder.rhip.ehr.entity.management.DmQuestion;
import com.founder.rhip.ehr.repository.management.IDmAnswerDao;
import com.founder.rhip.ehr.repository.management.IDmAnswerPeopleDao;
import com.founder.rhip.ehr.repository.management.IDmQuestionDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/5/18.
 */
@Service("questionnaireService")
public class QuestionnaireServiceImpl extends AbstractService implements IQuestionnaireService{

    @Resource(name = "dmQuestionDao")
    private IDmQuestionDao questionDao;

    @Resource(name = "dmAnswerPeopleDao")
    private IDmAnswerPeopleDao answerPeopleDao;

    @Resource(name = "dmAnswerDao")
    private IDmAnswerDao dmAnswerDao;

    @Override
    public List<DmQuestion> getQuestionsList(Criteria criteria) {
        return questionDao.getQuestionList(criteria);
    }

    @Override
    @Transactional
    public boolean saveDmAnswerPeople(DmAnswerPeople answerPeople) {
        Date date = new Date();
        answerPeople.setCreateTime(date);
        Number id = answerPeopleDao.generatedKey(answerPeople, "ID" , null);
        List<DmAnswer> answers = answerPeople.getAnswers();
        for(DmAnswer answer:answers){
            answer.setCreateTime(date);
            answer.setAnswerPeopleId(id.longValue());
        }
        int r = dmAnswerDao.batchInsert(answers,null);

        return true;
    }

    @Override
    public Map<String, Object> searchResult() {
        Map<String, Object> map = answerPeopleDao.searchBasicResult();
        List<Map<String,Object>> list = questionDao.searchPercentResult();
        map.put("list", list);
        return map;
    }
}
