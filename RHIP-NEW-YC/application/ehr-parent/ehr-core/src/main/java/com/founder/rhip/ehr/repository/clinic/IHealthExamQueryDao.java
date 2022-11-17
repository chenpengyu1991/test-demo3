package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;

/**
 * DAO interface of HealthExamination
 */
public interface IHealthExamQueryDao extends IDao<HealthExamination, Long> {
    /**
     * Gets health examinations.(没有扁平化的数据不显示)
     *
     * @param criteria the criteria
     * @param page the page
     * @return the health examinations
     */
    PageList<HealthExamination> getHealthExaminations(Criteria criteria, Page page,Order order); // 返回体检专项列表
    
    /**
     * 体检专项-指标分析列表
     *
     * @param criteria
     * @param page
     * @param order
     * @return
     * @author Ye jianfei
     */
    PageList<HealthExamination> getAnalyzeHealthExams(Criteria criteria, Page page,Order order);
}