package com.founder.rhip.ehr.repository.portal;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.PollOption;

import java.util.List;

/**
 * DAO interface of PollOption
 * 
 */
public interface IPollOptionDao extends IDao<PollOption,Long> {

    List<PollOption> getPollOptionList(Long itemId);

	List<PollOption> getOptionCountLists(Criteria criteria);

	List<PollOption> optionCountByItemLists(Criteria criteria);
}