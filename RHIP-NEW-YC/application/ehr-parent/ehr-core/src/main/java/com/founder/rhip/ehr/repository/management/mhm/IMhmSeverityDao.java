package com.founder.rhip.ehr.repository.management.mhm;

import java.util.Date;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmSeverity;

/**
 * DAO interface of MhmManageType
 * 
 */
public interface IMhmSeverityDao extends IDao<MhmSeverity,Long> {

    public MhmSeverity findMhmSeverity(String eventId);
    
    /**
     * 根据随访日期查找，对应该时间的历史记录
     * 小于等于随访日期
     * @param eventId
     * @param startDt
     * @return
     * @author Ye jianfei
     */
    public MhmSeverity getMhmSeverity(Long eventId,Date startDt);
    
    /**
     * 查找第一次记录时间
     * @param eventId
     * @return
     * @author Ye jianfei
     */
    public MhmSeverity getFirstMhmSeverity(Long eventId);    
}