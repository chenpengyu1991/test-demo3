package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.EhrDocLevel;

import java.util.Map;

/**
 * DAO interface of HaStatistics
 * 
 */
public interface IEhrDocLevelDao extends IDao<EhrDocLevel,Long> {

    /**
     * 工作量统计 若是医务人员给患者建档直接从0-3星 那么总数为1 一星的为1 二星的为1 三星的为1
     * @param page
     * @param form
     * @return
     */
    public PageList<Map<String, Object>> getWorkStatistics(Page page, ReportQueryForm form);

    /**
     * 星级统计 若是医务人员给患者建档直接从0-3星 那么总数为1 一星的为0 二星的为0 三星的为1
     * @param page
     * @param form
     * @return
     */
    public PageList<Map<String, Object>> getStarStatistics(Page page, ReportQueryForm form);
}