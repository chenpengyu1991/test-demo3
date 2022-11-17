package com.founder.rhip.ncp.repository;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ncp.entity.NcpSymptioms;

public interface ISymptiomsDao extends IDao<NcpSymptioms, Long> {

    /***
     * 根据monitor表Id查询症状code，逗号隔开
     * @param id
     * @return
     */
    String findSymptiomsByMonitorid(String id);
}
