package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;

/**
 * DAO interface of HealthExamination
 */
public interface IHealthExaminationDao extends IDao<HealthExamination, Long> {
    /**
     * Gets health examinations.
     *
     * @param criteria the criteria
     * @param page the page
     * @return the health examinations
     */
    PageList<HealthExamination> getHealthExaminations(Criteria criteria, Page page); // 返回体检专项列表

    /**
     * 获取最近一次体检
     *
     * @param criteria the criteria
     * @return last health examination
     */
	HealthExamination getLastHealthExamination(Criteria criteria);

    /**
     * 用于获取老年人体检数据
     * @param year the year
     * @param personId the person id
     * @param type the type
     * @return health examination
     */
	public HealthExamination getHealthExamination(String year, Long personId, String type);


    /**
     * Gets max exam date.
     *
     * @param criteria the criteria
     * @return the max exam date
     */
    public HealthExamination getMaxExamDate(Criteria criteria);
    
    /**
     * 体检专项-指标分析列表
     *
     * @param page
     * @param criteria
     * @param order
     * @return
     * @author Ye jianfei
     */
    public PageList<HealthExamination> getAnalyzeHealthExaminations(Page page,Criteria criteria,Order order );
    
    /**
     * 获取各机构体检人数
     * @param dateStr
     * @return
     */
    public List<Map<String, Object>> getHealthExaminationMapList(String dateStr);

    public List<HealthExamination> getHealthExaminationList(String examYear, String idList, String type);
}