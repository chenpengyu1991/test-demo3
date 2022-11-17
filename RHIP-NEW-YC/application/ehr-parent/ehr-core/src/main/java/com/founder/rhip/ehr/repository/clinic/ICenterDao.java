package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.OutTransfer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * DAO interface of OutTransfer
 * 
 */
public interface ICenterDao extends IDao<OutTransfer,Long> {

    Map approve(final LinkedHashMap<String, String> map);

}