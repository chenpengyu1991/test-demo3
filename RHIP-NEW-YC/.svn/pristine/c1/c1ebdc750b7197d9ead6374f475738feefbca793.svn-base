package com.founder.rhip.im.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.im.entity.report.ReportDefine;

import java.util.List;
import java.util.Map;

/**
 * 报表 Service
 *
 * @author ye jianfei
 * @version 1.0 2016-08-25
 */
public interface IReportService{
    /**
     * 获得报表定义
     * @param reportType
     * @return
     */
    ReportDefine getReportDefine(String reportType);

    /**
     * 获取报表数据
     * @param ca
     * @param sqlDefine
     * @return
     */
    List<Map<String, Object>> getReportList(Criteria ca, String sqlDefine);
}
