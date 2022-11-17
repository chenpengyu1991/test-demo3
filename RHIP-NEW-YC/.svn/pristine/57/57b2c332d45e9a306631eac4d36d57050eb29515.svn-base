package com.founder.rhip.ehr.repository.healtheducation;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.healtheducation.HeActive;
import com.founder.rhip.mdm.common.OrgGenreCode;

import java.util.Map;

/**
 * DAO interface of HealthEducationActive
 * 
 */
public interface IHeActiveDao extends IDao<HeActive,Long> {

    public PageList<HeActive> getHealthEducationActiveList(Criteria criteria,Page page,Order order);
    
    /**
     * 精神卫生报表(培训人数,培训次数)
     *
     * @param gbCode
     * @param parentCode
     * @param organCode
     * @param genreCode
     * @param startDate
     * @param endDate
     * @return
     * @author Ye jianfei
     */
    public Map<String,Object> getStatistics(String gbCode,String parentCode,String organCode,OrgGenreCode genreCode,String startDate,String endDate);
}