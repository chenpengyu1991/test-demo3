package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

public interface INewWchTargetDao {
    /**
     * 住院分娩率
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getHospitalDelivery(Map<String, String> paramMap);
    
    
    /**
     * 孕产妇死亡率
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getMaternalDeath(Map<String, String> paramMap);
}
