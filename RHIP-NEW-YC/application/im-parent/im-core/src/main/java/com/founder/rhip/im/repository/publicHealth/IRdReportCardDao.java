package com.founder.rhip.im.repository.publicHealth;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.im.entity.publicHealth.RdReportCard;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of RdReportCard
 * 
 */
public interface IRdReportCardDao extends IDao<RdReportCard,Long> {

    /**
     * 根据报卡类型获取1~12月份的报卡数量
     * @param criteria
     * @return
     */
    public List<Map<String, Object>> getReportCardTrendList(Criteria criteria);
}