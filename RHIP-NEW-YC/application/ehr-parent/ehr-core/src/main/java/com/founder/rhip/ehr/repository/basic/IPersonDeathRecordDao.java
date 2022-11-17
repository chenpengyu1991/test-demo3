package com.founder.rhip.ehr.repository.basic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonCanceledInfo;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;

/**
 * 死亡记录
 * @author liuk
 */
public interface IPersonDeathRecordDao extends IDao<PersonDeathRecord, Long> {

	/**
     * 获取质量质量中有关手术的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getCureResultHosOperationStatistics(String dateStr);
}