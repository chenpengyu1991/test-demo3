package com.founder.rhip.ehr.repository.statistics;

import java.util.List;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.statistics.RecordStatistics;
import com.founder.rhip.ehr.service.statistics.StarStatistics;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;

/**
 * 档案和星级统计
 *
 * @author liuk
 */
public interface IRecordStatisticsDao extends IDao<PersonInfo, Long> {


    /**
     * 档案统计
     *
     * @param criteria
     * @return
     */
    List<RecordStatistics> getRecordStatisticsData(Criteria criteria);


    /**
     * 星级统计
     *
     * @param criteria
     * @return
     */
    List<StarStatistics> getStarStatisticsData(Criteria criteria);

}
