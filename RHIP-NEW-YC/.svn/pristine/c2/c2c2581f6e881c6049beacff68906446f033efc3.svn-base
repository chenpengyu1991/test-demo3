package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.entity.healtheducation.HePromorion;

/**
 * Created by chen.q on 15-6-9.
 */
public interface IHePromorionService {
     PageList<HePromorion> findHealthPromorion(Criteria criteria, Page page);
     int createHealthPromorion(HePromorion healthPromorion);
     HePromorion getHealthPromorionById(Criteria criteria);

     /**
      * 根据条件删除健康宣传
      *
      * @param criteria
      * @return
      */
     int delete(Criteria criteria);

     /**
      * 更新是否发布的状态
      *
      * @param parameters
      * @param criteria
      * @return
      */
     public int updateStatus(Parameters parameters, Criteria criteria);

     /**
      * 更新健康宣传
      *
      * @param healthPromorion
      * @return
      */
     public int update(HePromorion healthPromorion);
}
