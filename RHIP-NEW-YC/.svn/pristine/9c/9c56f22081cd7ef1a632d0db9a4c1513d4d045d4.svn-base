package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.SurgeryInfo;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of SurgeryInfo
 */
public interface ISurgeryInfoDao extends IDao<SurgeryInfo, Long> {

	/**
     * 根据ehr_id区分是住院还是门诊来填充op_em_hp_mark
     * EHR_ID门诊是mz开头的
     * zy开头的是住院
     * 急诊的活动号也是mz 
     * 1、2:急诊、普通门诊 3：住院
     */
	public void updateOpEmHpMark();
	
	/**
     * 获取质量质量中有关住院手术的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getCureResultHosOperationStatistics(String dateStr);
}