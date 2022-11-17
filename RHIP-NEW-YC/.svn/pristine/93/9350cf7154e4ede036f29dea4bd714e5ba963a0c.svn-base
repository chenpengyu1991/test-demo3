package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;

/**
 * DAO interface of StudyEvent
 */
public interface IStudyExamDao extends IDao<StudyEvent, Long> {

    /**
     * 综合管理 检查查询页面用(没有身份证)
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<StudyEvent> getStudyEvents1(Page page, Criteria criteria, Order order);

    /**
     * 综合管理 检查查询页面用(有身份证)
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    PageList<StudyEvent> getStudyEvents2(Page page, Criteria criteria, Order order);

}