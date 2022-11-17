package com.founder.rhip.ehr.repository.portal;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.PollText;

/**
 * DAO interface of PollText
 * 
 */
public interface IPollTextDao extends IDao<PollText,Long> {

	//根据survey_id查相应的问题的text选项列表
	List<PollText> getPollTextLists(Criteria criteria);

}