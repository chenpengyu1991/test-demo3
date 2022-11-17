package com.founder.rhip.im.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.im.entity.ReportBaseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * DAO implement of reportDao
 * 
 */
@Repository("reportDao")
public class ReportDaoImpl extends AbstractReportDao<ReportBaseEntity, Long> implements IReportDao {

    @Override
    public List<Map<String, Object>> getReportList(Criteria ca, String sqlDefine) {
        String sql = getSql(ca,sqlDefine);
        return this.getMapList(sql,ca);
    }
}