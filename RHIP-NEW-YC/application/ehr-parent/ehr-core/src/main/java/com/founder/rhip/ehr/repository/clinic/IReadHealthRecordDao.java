package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.ReadHealthRecord;

/**
 * DAO interface of ReadHealthRecord
 */
public interface IReadHealthRecordDao extends IDao<ReadHealthRecord, Long> {
	/**
     * 获取满足条件的行数
     * @param criteria
     * @return
     */
    public int countRow(Criteria criteria);
}