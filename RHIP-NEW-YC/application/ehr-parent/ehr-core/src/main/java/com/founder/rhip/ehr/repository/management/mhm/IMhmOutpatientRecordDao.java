package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmOutpatientRecord;

import java.util.List;

/**
 * DAO interface of MhmOutpatientRecord
 * 
 */
public interface IMhmOutpatientRecordDao extends IDao<MhmOutpatientRecord,Long> {

    public List<MhmOutpatientRecord> getOutPatientRecords (Criteria criteria);

}