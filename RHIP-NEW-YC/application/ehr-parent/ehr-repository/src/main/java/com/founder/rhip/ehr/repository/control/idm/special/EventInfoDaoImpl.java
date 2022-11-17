package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO implement of EventInfo
 * 
 */
@Repository("eventInfoDao")
public class EventInfoDaoImpl extends AbstractDao<EventInfo, Long> implements IEventInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    /**
	 * 根据报卡中的活动Id获取相应Id最大的个案
	 * @param idmId
	 * @return
	 */
    @Override
	public EventInfo findEventInfo(String idmId, String eventId){
		String sql = "select max(t1.id) id from IDM_EVENT_INFO t1 where t1.status_id in" +
				"(select t2.status_id from IDM_EVENT_INFO t2 where t2.id ="+ idmId +" ) and t1.event_id='"+ eventId +"'";
		return this.get(sql, null);
	}

    public List forOrgChange(Criteria criteria){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT E.ID FROM IDM_EVENT_INFO E, IDM_STATUS_INFO S ");
        sql.append(" WHERE E.STATUS_ID = S.ID ");
        if(ObjectUtil.isNotEmpty(criteria) && criteria.getCriteria().size() > 0){
            sql.append(" AND ");
            sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":")).toString();
        }
        List<EventInfo> eventInfos = this.getList(EventInfo.class, sql.toString(), criteria);
        List<Long> singleIds = new ArrayList<Long>();
        for(EventInfo eventInfo : eventInfos){
            singleIds.add(eventInfo.getId());
        }
        return singleIds;
    }
}