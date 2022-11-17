package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;

/**
 * DAO interface of ExamineDetail
 */
public interface IExamineDetailDao extends IDao<ExamineDetail, Long> {

    /**
     * 获取检验的数据
     *
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getExamineDetailStatistics(String dateStr);
}