package com.founder.rhip.im.repository.medical;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.im.entity.medical.RdPrescription;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of RdPrescriptionDao
 * 
 */
public interface IRdPrescriptionDao extends IDao<RdPrescription,Long> {

    /**
     * 获取平均处方、最大处方
     * @param ca
     * @return
     */
    List<Map<String,Object>> getPrescriptionCostMapList(Criteria ca);

}