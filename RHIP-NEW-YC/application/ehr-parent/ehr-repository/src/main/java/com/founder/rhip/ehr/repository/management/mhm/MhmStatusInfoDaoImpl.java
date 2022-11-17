package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.dto.mhm.MhmClueQueryDto;
import com.founder.rhip.ehr.dto.mhm.MhmManagementQueryDto;
import com.founder.rhip.ehr.dto.mhm.MhmMoveQueryDto;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmEventInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmStatusInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * DAO implement of MhmStatusInfo
 * 
 */
@Repository("mhmStatusInfoDao")
public class MhmStatusInfoDaoImpl extends AbstractDao<MhmStatusInfo, Long> implements IMhmStatusInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
  
	/**
	 * 更新状态表
	 * @param statusInfo
	 * @param cr
	 */	    
	@Override
	public int updateStatus(MhmStatusInfo statusInfo,Criteria cr){
		Parameters parameters = new Parameters();
		String pixId = statusInfo.getPixId();
		Long personId = statusInfo.getPersonId();
		Integer status = statusInfo.getStatus();
		Integer logoff = statusInfo.getLogoff();
		if(StringUtil.isNotEmpty(pixId)){
			if(pixId.equals("-1")){
				parameters.add("PIX_ID", null);
			}else{
				parameters.add("PIX_ID", pixId);
			}
		}
		if(ObjectUtil.isNotEmpty(personId)){
			parameters.add("PERSON_ID", personId);
		}		
		if(ObjectUtil.isNotEmpty(status)){
			parameters.add("STATUS", status);
		}
		if(ObjectUtil.isNotEmpty(logoff)){
			parameters.add("LOGOFF", logoff);
		}
		return update(parameters,cr);
	}
	/**
	 * 分页查询--规范管理
	 * @param page
	 * @param criteria
	 */		
	@Override
	public PageList<MhmManagementQueryDto> findManagementList(Page page, Criteria criteria) {
		List<MhmManagementQueryDto> list = new ArrayList<MhmManagementQueryDto>();

		StringBuilder sql = new StringBuilder();
		Object eventType = criteria.get("EVENT_TYPE");
		Object followupFlag = criteria.get("followupFlag");
		String followupFlagSql ="";
		String joinSql ="";
		String dateSql ="";
		if(ObjectUtil.isNotEmpty(followupFlag)){
			followupFlagSql =",(SELECT T4.STATUS_ID,T4.NEXT_FOLLOWUP_DT FROM MHM_FOLLOWUP T4 WHERE T4.ID IN(SELECT MAX(T1.ID) FROM MHM_FOLLOWUP T1 INNER JOIN(\n" +
					"SELECT MAX (T2. FOLLOWUP_DT) FOLLOWUP_DT,INFO.STATUS_ID FROM MHM_EVENT_INFO INFO LEFT JOIN  MHM_FOLLOWUP T2 ON INFO. ID = T2.EVENT_ID WHERE INFO.EVENT_TYPE = '2003'  GROUP BY INFO.STATUS_ID) T3\n" +
					"ON T1.FOLLOWUP_DT = T3.FOLLOWUP_DT AND T3.STATUS_ID = T1.STATUS_ID GROUP BY T1.STATUS_ID) AND T4.NEXT_FOLLOWUP_DT IS NOT NULL) T5";
			joinSql ="AND S.ID = T5.STATUS_ID(+)";
			String startDate =DateUtil.convertDateToString(new Date())+" 00:00:00";
			String endDate =DateUtil.convertDateToString(DateUtil.add(new Date(), Calendar.MONTH, 1))+"  23:59:59";
			if("1".equals(followupFlag)){//30天内待访
				dateSql ="and T5.NEXT_FOLLOWUP_DT >= to_date('" + startDate + "','yyyy/MM/dd hh24:mi:ss')" +"and T5.NEXT_FOLLOWUP_DT <= to_date('"+ endDate + "','yyyy/MM/dd hh24:mi:ss')";
			}else {//逾期待访
				dateSql ="and T5.NEXT_FOLLOWUP_DT < to_date('" + startDate + "','yyyy/MM/dd hh24:mi:ss')";
			}

			System.out.println(dateSql);
			criteria.remove("followupFlag");
		}
        sql.append("SELECT E.STATUS_ID, E.ID AS event_id, S.LOGOFF AS logoff, S.PIX_ID, B.NAME, B.GENDER, B.AGE, B.IDCARD, O.MANAGEMENT_TOWN, O.FILL_DATE, D.DIAGNOSIS_CONTENT,O.FREE_FLAG, O.BRING_INTO_MODE ");
        sql.append(" FROM MHM_BASICS_INFO B, MHM_DIAGNOSIS D, MHM_OTHER_INFO O, MHM_STATUS_INFO S, ");
        sql.append(" (SELECT T1.* FROM MHM_EVENT_INFO T1 WHERE T1.ID IN (SELECT MAX(T2.ID) FROM MHM_EVENT_INFO T2 WHERE T1.STATUS_ID = T2.STATUS_ID and (IS_DELETE is null or IS_DELETE<>1)");
        if(ObjectUtil.isNotEmpty(eventType)){
        	Criteria eventCa = new Criteria("EVENT_TYPE",OP.IN,eventType);
        	sql.append(" AND ").append(eventCa.toSql(ClassMetadata.getMetadata(MhmEventInfo.class), ":")).toString();
        }
        sql.append(" )) E ");
		sql.append(followupFlagSql);
        sql.append(" WHERE E.ID = B.EVENT_ID(+) AND E.ID = D.EVENT_ID(+) AND E.ID = O.EVENT_ID(+) AND E.STATUS_ID = S.ID(+)");
		sql.append(joinSql);
		sql.append(dateSql);
        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
            sql.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(MhmStatusInfo.class), ":")).toString();
        }
        SqlBuilder.buildOrderStatement(sql, " S.LOGOFF, S.STATUS ASC,E .STATUS_ID DESC");
        PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
		for (Map<String, Object> map : maps.getList()) {
			if(ObjectUtil.isNullOrEmpty(map.get("AGE")) && !ObjectUtil.isNullOrEmpty(map.get("IDCARD"))){
				map.put("AGE", IDCardUtil.getAgeByIdCard(map.get("IDCARD").toString()));
			}
			MhmManagementQueryDto dto = this.get(map, MhmManagementQueryDto.class);
			list.add(dto);
		}
		PageList<MhmManagementQueryDto> result = new PageList<MhmManagementQueryDto>();
		result.setList(list);
		result.setPage(page);
		return result;
	} 
	
	/**
	 * 查询--规范管理
	 * @param criteria
	 */		
	@Override
	public List<MhmManagementQueryDto> findManagementList(Criteria criteria) {
		List<MhmManagementQueryDto> list = new ArrayList<MhmManagementQueryDto>();

		StringBuilder sql = new StringBuilder();
		//TODO:
		List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
		for (Map<String, Object> map : maps) {
			MhmManagementQueryDto dto = this.get(map, MhmManagementQueryDto.class);
			list.add(dto);
		}

		return list;	
	}

	/**
	 * 分页查询--线索登记
	 * @param page
	 * @param criteria
	 */		
	@Override
	public PageList<MhmClueQueryDto> findClueList(Page page, Criteria criteria) {
		List<MhmClueQueryDto> list = new ArrayList<MhmClueQueryDto>();

		StringBuilder sql = new StringBuilder();
		Object eventTypes = criteria.get("EVENT_TYPE");
		Criteria eventCr = new Criteria("EVENT_TYPE",OP.IN,eventTypes);		
		getClueListSql(sql,eventCr);
		SqlBuilder.buildWhereStatement(MhmStatusInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " status.LOGOFF, status.STATUS ASC,other.FILL_ORGAN_CODE DESC,other.FILL_DATE DESC ");
		PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
		for (Map<String, Object> map : maps.getList()) {
			if(ObjectUtil.isNullOrEmpty(map.get("AGE")) && !ObjectUtil.isNullOrEmpty(map.get("IDCARD"))){
				map.put("AGE", IDCardUtil.getAgeByIdCard(map.get("IDCARD").toString()));
			}
			MhmClueQueryDto dto = this.get(map, MhmClueQueryDto.class);
			list.add(dto);
		}
		PageList<MhmClueQueryDto> result = new PageList<MhmClueQueryDto>();
		result.setList(list);
		result.setPage(page);
		return result;	
	} 
	
	/**
	 * 查询--线索登记
	 * @param criteria
	 */		
	@Override
	public List<MhmClueQueryDto> findClueList(Criteria criteria) {
		List<MhmClueQueryDto> list = new ArrayList<MhmClueQueryDto>();
		StringBuilder sql = new StringBuilder();
		getClueListSql(sql,criteria);
		SqlBuilder.buildWhereStatement(MhmStatusInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, "  status.LOGOFF, status.STATUS ASC,other.FILL_ORGAN_CODE DESC,other.FILL_DATE DESC ");
		List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
		for (Map<String, Object> map : maps) {
			MhmClueQueryDto dto = this.get(map, MhmClueQueryDto.class);
			list.add(dto);
		}
		return list;	
	}
	
	private void getClueListSql(StringBuilder sql,Criteria criteria){
		sql.append(" SELECT  status.ID STATUS_ID,status.STATUS,status.PIX_ID,status.LOGOFF as logoff, event.ID EVENT_ID, ");
		sql.append(" basics.IDCARD,basics.NAME,basics.GENDER,basics.AGE,basics.AGE_UNIT,basics.OCCUPATION,");
		sql.append(" basics.PA_ADDRESS,basics.PARENTS_NAME,status.PATIENT_RESOURCE,basics.FAMILY_PHONE,basics.BIRTHDATE,basics.GUARDER_PHONE,");
		sql.append(" other.BRING_INTO_FLAG,other.FILL_DATE,other.FILL_ORGAN_CODE,other.BELONG_TOWNSHIP FROM MHM_STATUS_INFO status ");		
		sql.append(getEventSql(criteria));
		sql.append(" LEFT JOIN MHM_BASICS_INFO basics ON event.ID = basics.EVENT_ID" );
		sql.append(" LEFT JOIN MHM_OTHER_INFO other ON event.ID = other.EVENT_ID" );		
	}
	
	/**
	 * 专项，需要用到个案填写的信息MHM_EVENT_INFO表应该取max
	 * @param criteria
	 */	
	private String getEventSql(Criteria criteria){
		StringBuilder sql = new StringBuilder();
		sql.append(" LEFT JOIN  (select t1.* from MHM_EVENT_INFO t1 where t1.id in ( select max(t2.id)  from  MHM_EVENT_INFO t2  where  t1.STATUS_ID=t2.STATUS_ID AND " );
		sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
		sql.append(")) event ON status.ID = event.STATUS_ID " );
		return sql.toString();
	}

    /**
     * 分页查询--迁入迁出
     * @param page
     * @param criteria
     * @return
     */
    @Override
    public PageList<MhmMoveQueryDto> findMoveList(Page page, Criteria criteria){
        List<MhmMoveQueryDto> list = new ArrayList<MhmMoveQueryDto>();

        StringBuilder sql = new StringBuilder();
        sql.append("select T.*, M.id, M.move_in_dt, M.move_in_organ, M.move_out_dt, M.move_out_organ, M.flag from ");
        sql.append("(select E.id as event_id, S.id as status_id, S.LOGOFF, B.name, B.idcard, B.gender, B.pa_address, B.parents_name, B.guarder_phone, O.management_town, O.management_center, O.management_station, O.move_id ");
        sql.append("from mhm_basics_info B, mhm_other_info O, mhm_event_info E, mhm_status_info S ");
        sql.append("where E.id=B.event_id(+) and E.id=O.event_id(+) and E.event_type=2001 and E.status_id=S.id and S.status=4) T ");
        sql.append("left join ");
        sql.append("(select * from mhm_move where id in (select max(id) from mhm_move group by event_id)) M ");
        sql.append("on T.event_id=M.event_id ");
        sql.append("where 1=1 ");
        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
            sql.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(MhmStatusInfo.class), ":")).toString();
        }
        sql.append(" ORDER BY T.LOGOFF ");
        PageList<Map<String, Object>> maps = this.getPageMapList(page, sql.toString(), criteria);
        for (Map<String, Object> map : maps.getList()) {
            MhmMoveQueryDto dto = this.get(map, MhmMoveQueryDto.class);
            list.add(dto);
        }
        PageList<MhmMoveQueryDto> result = new PageList<MhmMoveQueryDto>();
        result.setList(list);
        result.setPage(page);
        return result;
    }

	@Override
	public Long getPersonIdCount(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select count(distinct(si.PIX_ID)) from MHM_STATUS_INFO si");
		sb.append(" inner join MHM_EVENT_INFO ei on si.id = ei.STATUS_ID ");
		sb.append(" inner join MHM_OTHER_INFO oi on ei.id = oi.EVENT_ID ");
		SqlBuilder.buildWhereStatement(MhmStatusInfo.class, sb, criteria);
		Long count = this.getSingle(sb.toString(), criteria, Long.class);
		return count;
	}

    @Override
    public List<MhmMoveQueryDto> getMhmInfoForCic(){
        StringBuilder sql = new StringBuilder("SELECT DISTINCT S.PERSON_ID, B.IDCARD\n" +
                "  FROM MHM_DIAGNOSIS   D,\n" +
                "       MHM_EVENT_INFO  E,\n" +
                "       MHM_STATUS_INFO S,\n" +
                "       MHM_BASICS_INFO B\n" +
                " WHERE D.RE_CHECK = 2\n" +
                "   AND D.EVENT_ID = E.ID\n" +
                "   AND E.STATUS_ID = S.ID\n" +
                "   AND B.EVENT_ID = E.ID AND PERSON_ID IS NOT NULL");

        List<MhmMoveQueryDto> result = new ArrayList<>();

        List<Map<String, Object>> resultMap = this.getMapList(sql.toString(), new Criteria());
        for (Map<String, Object> map : resultMap) {
            MhmMoveQueryDto dto = this.get(map, MhmMoveQueryDto.class);
            result.add(dto);
        }
        return result;
    }

}