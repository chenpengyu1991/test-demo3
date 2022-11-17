package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.child.NeonatalDiseaseScreen;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of NeonatalDiseaseScreen
 */
public interface INeonatalDiseaseScreenDao extends IDao<NeonatalDiseaseScreen, String> {

    public Map countDiseaseScreen(Map<String, String> paramMap, List orgCodes);
    
    public List<Map<String, Object>> getNeonatalDiseaseScreenMapList(String dateStr);

}