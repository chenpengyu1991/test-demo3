/**
 * 检验结果分析
 */
package com.founder.rhip.im.service.medical;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IExanAnalyseService {
    /**
     * 按机构汇总检验结果统计
     * @param beginDate
     * @param endDate
     * @return
     */
    public List<Map<String,Object>> getOrganSummary(Date beginDate, Date endDate);

    /**
     * 检验结果统计分析
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getExamAnalys(Map<String, String> paramMap);


    /**
     * 医技服务监管
     */
    public List<Map<String, Object>> getServiceAnalys(Map<String, String> paramMap);
}