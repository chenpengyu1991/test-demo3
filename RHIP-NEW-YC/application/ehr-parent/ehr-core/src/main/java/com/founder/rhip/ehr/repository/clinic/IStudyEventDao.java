package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of StudyEvent
 */
public interface IStudyEventDao extends IDao<StudyEvent, Long> {

	/**
     * 获取检查的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    public List<Map<String, Object>> getStudyInfoStatistics(String dateStr);
    
    /**
     * 获取体检检查项
     * @param dateStr
     * @return
     */
    public List<Map<String, Object>> getStudyEventMapList(String dateStr);
}