package com.founder.rhip.im.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.im.entity.ReportBaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 列表类报表Dao
 * 
 */
public interface IReportDao extends IDao<ReportBaseEntity,Long> {

    /**
     * 获取统计报表
     * @param ca
     * @param sqlDefine
     * @return
     */
    List<Map<String,Object>> getReportList(Criteria ca,String sqlDefine);
}