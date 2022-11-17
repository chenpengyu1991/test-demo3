package com.founder.rhip.ehr.repository.portal;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.Poll;

/**
 * DAO interface of Poll
 * 
 */
public interface IPollDao extends IDao<Poll,Long> {

	PageList<Poll> getMyList(Page page, Criteria crita);
}