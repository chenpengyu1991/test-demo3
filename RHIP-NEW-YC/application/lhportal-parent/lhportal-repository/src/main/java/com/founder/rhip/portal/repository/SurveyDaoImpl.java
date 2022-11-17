package com.founder.rhip.portal.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.portal.Survey;
import com.founder.rhip.ehr.repository.portal.ISurveyDao;
import com.founder.rhip.portal.common.SurveyStatus;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of Survey
 * 
 */
@Repository("lhsurveyDao")
public class SurveyDaoImpl extends AbstractDao<Survey, Long> implements ISurveyDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public int startSurvey(Long surveyId) {
		return this.update(new Parameters("status", SurveyStatus.START.getValue()), new Criteria("id", surveyId));
	}

	@Override
	public int endSurvey(Long surveyId) {
		return this.update(new Parameters("status", SurveyStatus.ENDS.getValue()), new Criteria("id", surveyId));
	}

	@Override
	public PageList<Survey> getMySurveyList(Page page, Criteria crita, User user) {
		
        StringBuilder sql = new StringBuilder("SELECT survey.id,");
        sql.append("survey.title,");
        sql.append("survey.purpose,");
        sql.append("survey.directions,");
        sql.append("survey.SUBMIT_TIME, ");
        sql.append("survey.ORG_ID ");
        sql.append("FROM survey survey ");
        sql.append("inner join poll po on po.survey_id = survey.id ");
        
        SqlBuilder.buildWhereStatement(Survey.class, sql, crita);
        SqlBuilder.buildOrderStatement(sql, " survey.SUBMIT_TIME DESC ");
        
        List<Survey> result = new ArrayList<Survey>();
        PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), crita);
        for (Map<String, Object> map : maps.getList()) {
        	Survey surveyOne = this.get(map, Survey.class);
        	if(!contain(result,surveyOne)){
        		result.add(surveyOne);
        	}
        }
        
        PageList<Survey> pageList = new PageList<Survey>();
        pageList.setList(result);
        pageList.setPage(maps.getPage());
		return pageList;
	}
	
	private boolean contain(List<Survey> result, Survey surveyOne){
		if(null == surveyOne || null == result || result.isEmpty()) {
			return false;
		}
		
		for(Survey survey: result){
			if(survey.getId().equals(surveyOne.getId())){
				return true;
			}
		}
		
		return false;
	}
	
}