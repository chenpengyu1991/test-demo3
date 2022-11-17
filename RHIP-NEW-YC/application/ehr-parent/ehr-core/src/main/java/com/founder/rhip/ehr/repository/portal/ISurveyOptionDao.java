package com.founder.rhip.ehr.repository.portal;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.SurveyOption;

/**
 * DAO interface of SurveyOption
 * 
 */
public interface ISurveyOptionDao extends IDao<SurveyOption,Long> {

	List<SurveyOption> getSurveyOptionsByItemIdLists(Criteria criteria);

}