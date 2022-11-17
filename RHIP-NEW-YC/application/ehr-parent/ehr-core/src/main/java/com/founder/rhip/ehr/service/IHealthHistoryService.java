package com.founder.rhip.ehr.service;

import com.founder.rhip.ehr.dto.HealthHistoryDTO;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;

import java.util.List;

public interface IHealthHistoryService {
    HealthHistoryDTO getHealthHistory(Criteria criteria);
    
    PageList<DiseaseHistory> getDiseaseHistorys(Criteria criteria, Page page);

    List<DiseaseHistory> getDiseaseHistorys(Criteria criteria);


    /**
     * 根据不同类型，加载不用的健康史
     * @param criteria
     * @param historyType
     * @return
     */
    HealthHistoryDTO getHealthHistory(Criteria criteria,String historyType);
}
