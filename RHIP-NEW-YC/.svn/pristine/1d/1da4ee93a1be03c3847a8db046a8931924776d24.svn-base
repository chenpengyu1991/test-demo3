package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;

/**
 * DAO interface of ExamineEvent
 */
public interface IExamineEventDao extends IDao<ExamineEvent, Long> {

	List<ExamineEvent> getListWithoutHiv(Criteria criteria, Order order);

	PageList<ExamineEvent> getPagedListWithoutHiv(Page page, Criteria criteria, Order order);
	
	List<Map<String, Object>> getExamineEventMapList(String dateStr);

}