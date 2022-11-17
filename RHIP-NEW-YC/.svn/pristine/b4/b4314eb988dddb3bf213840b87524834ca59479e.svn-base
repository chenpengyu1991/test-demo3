package com.founder.rhip.ehr.repository.management;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.DmQuestion;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/5/18.
 */
@Repository("dmQuestionDao")
public class DmQuestionDaoImpl extends AbstractDao<DmQuestion, Long> implements IDmQuestionDao {

    @Override
    public List<Map<String, Object>> searchPercentResult() {
        StringBuffer sb =new StringBuffer("select  total.question_code,rightAsw.cnt,round（(total.cnt-unknow.cnt)/total.cnt*100,0) knowPercent from ");
        sb.append("(select q.question_code,count(1) cnt from dm_question q left join dm_answer a on q.question_code=a.question_code " +
                "group by q.question_code) total,");
        sb.append("(select q.question_code,count(1) cnt from dm_question q left join dm_answer a on q.question_code=a.question_code " +
                "and q.right_answer=a.answer group by q.question_code) rightAsw,");
        sb.append("(select q.question_code,count(a.answer) cnt from dm_question q left join dm_answer a on q.question_code=a.question_code " +
                "and q.unknown = a.answer group by q.question_code) unknow ");
        sb.append(" where total.question_code = rightAsw.question_code and rightAsw.question_code =  unknow.question_code ");
        List<Map<String, Object>> listMap = this.getMapList(sb.toString(),new Criteria());
        return listMap;
    }

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<DmQuestion> getQuestionList(Criteria criteria) {
        Order order = new Order("question_code");
        return this.getList(criteria,order);
    }


}
