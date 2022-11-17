package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;

import java.util.List;

/**
 * DAO interface of EventInfo
 * 
 */
public interface IEventInfoDao extends IDao<EventInfo,Long> {
	/**
	 * 根据报卡中的活动Id获取相应Id最大的个案
	 * @param idmId
	 * @return
	 */
	public EventInfo findEventInfo(String idmId, String eventId);

    public List forOrgChange(Criteria criteria);
}