package com.founder.rhip.im.repository.medical;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.im.entity.medical.RdExamAnalys;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO interface of RdBedDistribution
 * 
 */
public interface IRdExamAnalysDao extends IDao<RdExamAnalys,Long> {

    /**
     * 按机构汇总检验结果统计
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<Map<String,Object>> getOrganSummary(Date beginDate, Date endDate);

    public List<Map<String, Object>> getExamAnalysList(Map<String, String> paramMap);

    /**
     * 医技服务监管
     */
    public List<Map<String, Object>> getServiceAnalys(Map<String, String> paramMap);
}