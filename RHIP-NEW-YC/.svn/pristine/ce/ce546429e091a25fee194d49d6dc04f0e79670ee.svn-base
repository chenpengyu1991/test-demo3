package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.DmAnswerPeople;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by admin on 2017/5/22.
 */
@Repository("dmAnswerPeopleDao")
public class DmAnswerPeopleDaoImpl extends AbstractDao<DmAnswerPeople, Long> implements IDmAnswerPeopleDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public Map<String, Object> searchBasicResult() {
        StringBuffer sb =new StringBuffer("select total.total,sex1.sex1,sex2.sex2,minAge.minAge,maxAge.maxAge,avgAge.avgAge," +
                " round(sex1.sex1/total.total*100,0) sex1Precent,round(sex2.sex2/total.total*100,0) sex2Precent from");
        sb.append(" (select count(1) total from DM_ANSWER_PEOPLE) total,");
        sb.append(" (select count(1) sex1 from DM_ANSWER_PEOPLE where sex ='1') sex1, ");
        sb.append(" (select count(1) sex2 from DM_ANSWER_PEOPLE where sex ='2') sex2,");
        sb.append(" (select min(age) minAge from DM_ANSWER_PEOPLE) minAge,");
        sb.append(" (select max(age) maxAge from DM_ANSWER_PEOPLE) maxAge,");
        sb.append(" (select round(avg(age),0) avgAge from DM_ANSWER_PEOPLE) avgAge");
        Map<String, Object> map = this.getMap(sb.toString(), new Criteria());
        return map;
    }
}
