package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.management.DiabeticFollowup;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of DiabeticFollowup
 */
public interface IDiabeticFollowupDao extends IDao<DiabeticFollowup, String> {

    /**
     * 慢性病患者健康管理数据
     * 1.新发慢病患者首次登记报告人数 统计对象为管理卡 一个病人同时管理五种慢病算五次
     * 2.慢病患者随访人次数（人次）
     * 3.高血压、糖尿病高危人群生活方式指导人次数
     * 4.糖尿病人免费空腹血糖测量人次
     * @param form
     * @return
     */
    public List<Map<String, Object>> getCdmStatistics(ReportQueryForm form);

    /**
     * 基本公卫工作量-慢性病患者健康管理数据
     * 1.新发慢病患者首次登记报告人数 统计对象为管理卡 一个病人同时管理五种慢病算五次
     * 2.慢病患者随访人次数（人次）
     * 3.高血压、糖尿病高危人群生活方式指导人次数
     * 4.糖尿病人免费空腹血糖测量人次
     * @param form
     * @return
     */
    public List<Map<String, Object>> getCdmStatisticsForBigReport(ReportQueryForm form);

}