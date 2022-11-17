package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;

import java.util.List;

/**
 * DAO interface of ExamineEvent
 */
public interface IExamineEventQueryDao extends IDao<ExamineEvent, Long> {

    /**
     * 综合管理 检验查询页面用(有身份证)
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<ExamineEvent> getExamEventsWithIdCard(Page page, Criteria criteria, Order order);

    public PageList<ExamineEvent> getIDMExamsResult(Page page, Criteria criteria);
}