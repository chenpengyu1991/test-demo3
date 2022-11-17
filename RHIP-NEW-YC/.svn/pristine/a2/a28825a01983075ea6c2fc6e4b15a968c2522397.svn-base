package com.founder.rhip.ehr.repository.summary;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.fasf.repository.IDao;

import java.util.List;

/**
 * DAO interface of DiseaseHistory
 */
public interface IDiseaseHistoryDao extends IDao<DiseaseHistory, String> {

    /**
     * 根据CONFIRMATION_DATE倒序获取不重复的DiseaseCode的疾病列表信息
     * @param criteria
     * @return
     */
    List<DiseaseHistory> getDiseaseHistoryListByDistinctDiseaseCode(Criteria criteria);
}