package com.founder.rhip.portal.repository;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.portal.SurveyRecord;
import com.founder.rhip.ehr.repository.portal.ISurveyRecordDao;
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
@Repository("surveyRecordDao")
public class SurveyRecordDaoImpl extends AbstractDao<SurveyRecord, Long> implements ISurveyRecordDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public int startSurvey(Long surveyId) {
		return this.update(new Parameters("status",SurveyStatus.START.getValue()), new Criteria("id", surveyId));
	}

	@Override
	public int endSurvey(Long surveyId) {
		return this.update(new Parameters("status", SurveyStatus.ENDS.getValue()), new Criteria("id", surveyId));
	}

	@Override
	public PageList<SurveyRecord> getMySurveyList(Page page, Criteria crita, User user) {
		
        StringBuilder sql = new StringBuilder("SELECT survey.id,");
        sql.append("survey.title,");
        sql.append("survey.purpose,");
        sql.append("survey.directions,");
        sql.append("survey.SUBMIT_TIME, ");
        sql.append("survey.ORG_ID ");
        sql.append("FROM survey_record survey ");
        sql.append("inner join poll po on po.survey_id = survey.id ");
        
        SqlBuilder.buildWhereStatement(SurveyRecord.class, sql, crita);
        SqlBuilder.buildOrderStatement(sql, " survey.SUBMIT_TIME DESC ");  
        
        List<SurveyRecord> result = new ArrayList<SurveyRecord>();
        PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), crita);
        for (Map<String, Object> map : maps.getList()) {
        	SurveyRecord surveyOne = this.get(map,SurveyRecord.class);
        	if(!contain(result,surveyOne)){
        		result.add(surveyOne);
        	}
        }
        
        PageList<SurveyRecord> pageList = new PageList<SurveyRecord>();
        pageList.setList(result);
        pageList.setPage(maps.getPage());
		return pageList;
	}
	
	private boolean contain(List<SurveyRecord> result, SurveyRecord surveyOne){
		if(null == surveyOne || null == result || result.isEmpty())
			return false;
		
		for(SurveyRecord survey: result){
			if(survey.getId().equals(surveyOne.getId())){
				return true;
			}
		}
		
		return false;
	}
	
}