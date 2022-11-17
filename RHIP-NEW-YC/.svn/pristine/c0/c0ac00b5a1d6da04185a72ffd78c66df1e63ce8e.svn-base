package com.founder.rhip.ehr.repository.management.mhm;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.dto.TargetDTO;
import com.founder.rhip.ehr.entity.management.mhm.MhmFollowup;
import com.founder.rhip.ehr.entity.management.mhm.MhmOtherInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmSeverity;
import com.founder.rhip.ehr.entity.management.mhm.MhmStatusInfo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
/**
 * 精神卫生统计指标
 * 
 */
@Repository("mhmHealthTargetDao")
public class MhmHealthTargetDaoImpl extends AbstractDao<MhmStatusInfo, Long> implements IMhmHealthTargetDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * PH039:新发现重性精神疾病患者数
     * %1$s:时间条件
     * %2$s：机构条件
     * %3$s：GROUP BY字段
     */
    private static final String PH039_SQL = " select count(result.id) TARGET_RESULT from ("
    		+ " select status.id,status.STATUS,other.MODIFY_DATE," 
    		+ "other.BELONG_TOWNSHIP,other.BELONG_CENTER,other.FILL_ORGAN_CODE"
    		+ " from mhm_status_info status"
    		+ " left join MHM_EVENT_INFO  event on (event.STATUS_ID = status.id AND event.event_type IN (1001) )"
    		+ " left join MHM_OTHER_INFO  other on event.id = other.EVENT_ID"
    		+ " left join MHM_EVENT_INFO  eventSeverity on (eventSeverity.STATUS_ID = status.id AND eventSeverity.event_type IN (2001) )"
    		+ " left join MHM_SEVERITY  severity on ( eventSeverity.id = severity.EVENT_ID AND severity.VERSION = 1)"
    		+ "  WHERE %1$s %2$s AND status.status IN(3,4,8,9) AND severity.STATUS = 1) result"
    		+ " GROUP BY %3$s";

    /**
     * 获得指定时间内，最后一次病人类型记录
     * 病人类型：重性：1、非重性：2
     */
    private static final String SEVERITY_SQL = " SELECT a.event_id , dt, status FROM MHM_SEVERITY b, ("
    		+ " SELECT event_id, max(start_dt)  dt FROM MHM_SEVERITY"
    		+ " WHERE %4$s"//to_char(start_dt, 'yyyy/mm')<='2013/09'
    		+ " GROUP BY event_id) A"
    		+ " where b.event_id = a.event_id and b.start_dt = a.dt";
    
    /**
     * PH040:年内累计管理重性精神疾病患者数
     * %1$s:时间条件
     * %2$s：机构条件
     * %3$s：GROUP BY字段
     */
    private static final String PH040_SQL = " select count(result.id) TARGET_RESULT from ("
    		+ " select status.id,status.STATUS,other.MODIFY_DATE," 
    		+ " other.MANAGEMENT_TOWN,other.MANAGEMENT_CENTER,other.MANAGEMENT_STATION"
    		+ " from mhm_status_info status"
    		+ " left join MHM_EVENT_INFO  event on (event.STATUS_ID = status.id AND event.event_type IN (2001))"
    		+ " left join MHM_OTHER_INFO  other on event.id = other.EVENT_ID"
    		+ " left join(" + SEVERITY_SQL + ") severity on event.id = severity.EVENT_ID"     		
    		+ "  WHERE %1$s  %2$s AND status.status IN(4,9) AND severity.STATUS = 1) result"
    		+ " GROUP BY %3$s";

    /**
     * PH041:规范管理重性精神疾病患者数
     * %1$s:时间条件
     * %2$s：机构条件
     * %3$s：GROUP BY字段
     */
    private static final String PH041_SQL = " select count(result.id) TARGET_RESULT from ("
    		+ " select status.id,status.STATUS,other.MODIFY_DATE," 
    		+ " other.MANAGEMENT_TOWN,other.MANAGEMENT_CENTER,other.MANAGEMENT_STATION"
    		+ " from mhm_status_info status"
    		+ " left join MHM_EVENT_INFO  event on (event.STATUS_ID = status.id AND event.event_type IN (2001))"
    		+ " left join MHM_OTHER_INFO  other on event.id = other.EVENT_ID"
    		+ " left join(" + SEVERITY_SQL + ") severity on event.id = severity.EVENT_ID"     
    		+ "  WHERE %1$s %2$s AND status.status IN(4,9) AND severity.STATUS = 1) result"
    		+ " GROUP BY %3$s";

    /**
     * 随访记录
     */
    private static final String FOLLOWUP_SQL = " SELECT   STATUS_ID,a.event_id,b.FOLLOWUP_TYPE  FROM MHM_FOLLOWUP b, ("
    		+ " SELECT event_id, max(FOLLOWUP_DT)  dt,FOLLOWUP_TYPE FROM MHM_FOLLOWUP"
    		+ " WHERE FOLLOWUP_TYPE = '3'  %1$s"
    		+ " GROUP BY event_id,FOLLOWUP_TYPE) a  where b.event_id = a.event_id and b.FOLLOWUP_DT = a.dt";
    
    /**
     * PH042:最近一次随访时分类为“病情稳定”的患者数
     * %1$s:时间条件
     * %2$s：机构条件
     * %3$s：GROUP BY字段
     */
    private static final String PH042_SQL = " select count(result.id) TARGET_RESULT from ("
    		+ " select status.id,status.STATUS,other.MODIFY_DATE," 
    		+ "	other.MANAGEMENT_TOWN,other.MANAGEMENT_CENTER,other.MANAGEMENT_STATION"
    		+ " from mhm_status_info status"
    		+ " left join MHM_EVENT_INFO  event on (event.STATUS_ID = status.id AND event.event_type IN (2001))"
    		+ " left join MHM_OTHER_INFO  other on event.id = other.EVENT_ID"
    		+ " left join(" + FOLLOWUP_SQL + ") followup on status.id = followup.status_id" 
    		+ "  WHERE (followup.event_id is not null) %2$s AND status.status IN(4,9)) result"
    		+ " GROUP BY %3$s";
    
	@Override
	public Float getMhmTarget(String orgCode,String orgType, Date startDate, Date endDate, String targetCode) {
		Float result =0F;
		String sql = getStatisticsSql(orgCode,orgType, startDate, endDate, targetCode);
		MapSqlParameterSource sqlParameterSource = getParameterSource(orgCode, startDate, endDate,targetCode);
		List<Map<String, Object>> map = this.getMapList(sql, sqlParameterSource);
		if(ObjectUtil.isNotEmpty(map)){
			Object target = map.get(0).get("TARGET_RESULT");
			if(ObjectUtil.isNotEmpty(target)){
				result = NumberUtil.convert(target.toString(), Float.class);
			}
		}
		return result;
	} 

    private String getStatisticsSql(String orgCode,String orgType, Date startDate, Date endDate, String targetCode){
    	StringBuilder args1 = new StringBuilder();//时间条件
		StringBuilder args2 = new StringBuilder();//机构条件
		StringBuilder args3 = new StringBuilder();//GROUP BY字段
		StringBuilder args4 = new StringBuilder();//SEVERITY，时间条件

		String baseSql= getBaseSql(targetCode);
		args1.append(buildDateWhere(startDate,endDate,targetCode));
		args2.append(buildOrgWhere(orgCode,orgType,targetCode));

		String orgFieldType = getOrgType(targetCode);
		if(orgType.equals(TargetDTO.GB.toString())){
			args3.append(orgFieldType.equals("1")?"BELONG_TOWNSHIP":"MANAGEMENT_TOWN");
		}else if(orgType.equals(TargetDTO.CENTER.toString())){
			args3.append(orgFieldType.equals("1")?"BELONG_TOWNSHIP,BELONG_CENTER":"MANAGEMENT_TOWN,MANAGEMENT_CENTER");
		}else if(orgType.equals(TargetDTO.STATION.toString())){
			args3.append(orgFieldType.equals("1")?"BELONG_TOWNSHIP,BELONG_CENTER,FILL_ORGAN_CODE":"MANAGEMENT_TOWN,MANAGEMENT_CENTER,MANAGEMENT_STATION");
		}		
		args4.append(buildSeverityDateWhere(startDate,endDate,targetCode));
		return String.format(baseSql, args1.toString(),args2.toString(),args3.toString(),args4.toString());    	
    }
    
	private String getBaseSql(String targetCode){
		String result = "";
		switch (targetCode){
			case TargetConstants.MHM_NEW_SEVERE_COUNT:
				result = PH039_SQL;
				break;
			case TargetConstants.MHM_WITHIN_SEVERE_COUNT:
				result = PH040_SQL;
				break;
			case TargetConstants.MHM_MANAGEMENT_SEVERE_COUNT:
				result = PH041_SQL;
				break;
			case TargetConstants.MHM_FOLLOWUP_STABLE_COUNT:
				result = PH042_SQL;
				break;				
		}
		return result;
	}
    
    private String buildOrgWhere(String orgCode,String orgType, String targetCode){
    	StringBuilder where = new StringBuilder();
    	String orgFieldType = "1";//1:线索登记，所属单位；2：规范管理，管理单位
    	switch (targetCode){
    		case TargetConstants.MHM_FOLLOWUP_STABLE_COUNT:
    			orgFieldType = "2";
    			break;
    		case TargetConstants.MHM_MANAGEMENT_SEVERE_COUNT:
    		case TargetConstants.MHM_WITHIN_SEVERE_COUNT:
    			orgFieldType = "2"; 
    			break;
    		case TargetConstants.MHM_NEW_SEVERE_COUNT:
    			orgFieldType = "1"; 
    			break;
    	}
		if(orgType.equals(TargetDTO.GB.toString())){
			where.append(" AND").append(orgFieldType.equals("1")?" BELONG_TOWNSHIP":" MANAGEMENT_TOWN");
		}else if(orgType.equals(TargetDTO.CENTER.toString())){
			where.append(" AND").append(orgFieldType.equals("1")?" BELONG_CENTER":" MANAGEMENT_CENTER");
		}else if(orgType.equals(TargetDTO.STATION.toString())){
			where.append(" AND").append(orgFieldType.equals("1")?" FILL_ORGAN_CODE":" MANAGEMENT_STATION");
		}
		where.append(" = :ORG_CODE");
    	return where.toString();
    }	
    
    /**
     * 根据指标类型，生成日期条件,查询字段不同
     * 
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     * @author Ye jianfei
     */
    private String buildDateWhere(Date startDate, Date endDate, String targetCode){
    	StringBuilder where = new StringBuilder();
    	Criteria criteria = new Criteria();
	
    	switch (targetCode){
    		case TargetConstants.MHM_FOLLOWUP_STABLE_COUNT:
    			if(ObjectUtil.isNullOrEmpty(startDate) && ObjectUtil.isNullOrEmpty(endDate)){
    				where.append("");
    			}else{
    				DateUtil.getCriteriaByDateRange(criteria, "FOLLOWUP_DT", startDate,endDate);
    				where.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(MhmFollowup.class), ":")).toString();
    			}
    			break;
    		case TargetConstants.MHM_MANAGEMENT_SEVERE_COUNT:
    			if(ObjectUtil.isNullOrEmpty(startDate) && ObjectUtil.isNullOrEmpty(endDate)){
    				where.append("1=1");
    			}else{
    				DateUtil.getCriteriaByDateRange(criteria, "BRING_INTO_DATE", startDate,endDate);
        			where.append(criteria.toSql(ClassMetadata.getMetadata(MhmOtherInfo.class), ":")).toString();  
    			}    			
    			break;
    		case TargetConstants.MHM_NEW_SEVERE_COUNT:
    			if(ObjectUtil.isNullOrEmpty(startDate) && ObjectUtil.isNullOrEmpty(endDate)){
    				where.append("1=1");
    			}else{
	    			DateUtil.getCriteriaByDateRange(criteria, "MODIFY_DATE", startDate,endDate);
	    			where.append(criteria.toSql(ClassMetadata.getMetadata(MhmOtherInfo.class), ":")).toString();
    			}
    			break;    			
    		case TargetConstants.MHM_WITHIN_SEVERE_COUNT:
    			if(ObjectUtil.isNullOrEmpty(startDate) && ObjectUtil.isNullOrEmpty(endDate)){
    				where.append("(TO_CHAR(BRING_INTO_DATE,'yyyy')  =:bringIntoDate)");;
    			}else if(ObjectUtil.isNullOrEmpty(startDate)){
    				where.append("(TO_CHAR(BRING_INTO_DATE,'yyyy')  <=:bringIntoDate)");
    			}else{
    				where.append("(TO_CHAR(BRING_INTO_DATE,'yyyy')  >=:minbringIntoDate AND TO_CHAR(BRING_INTO_DATE,'yyyy') <=:maxbringIntoDate)");
    			}
    			break;
    	}
    	return where.toString();
    }  

    private String buildSeverityDateWhere(Date startDate, Date endDate, String targetCode){
    	StringBuilder where = new StringBuilder();
    	Criteria criteria = new Criteria();
	
    	switch (targetCode){
    		case TargetConstants.MHM_FOLLOWUP_STABLE_COUNT:
   				where.append("");
    			break;
    		case TargetConstants.MHM_MANAGEMENT_SEVERE_COUNT:
    			if(ObjectUtil.isNullOrEmpty(startDate) && ObjectUtil.isNullOrEmpty(endDate)){
    				where.append("1=1");
    			}else{
    				DateUtil.getCriteriaByDateRange(criteria, "START_DT", startDate,endDate);
        			where.append(criteria.toSql(ClassMetadata.getMetadata(MhmSeverity.class), ":")).toString();  
    			}    			
    			break;
    		case TargetConstants.MHM_NEW_SEVERE_COUNT:
    			where.append(" ");
    			break;    			
    		case TargetConstants.MHM_WITHIN_SEVERE_COUNT:
    			if(ObjectUtil.isNullOrEmpty(startDate) && ObjectUtil.isNullOrEmpty(endDate)){
    				where.append("(TO_CHAR(START_DT,'yyyy')  =:startDt)");;
    			}else if(ObjectUtil.isNullOrEmpty(startDate)){
    				where.append("(TO_CHAR(START_DT,'yyyy')  <=:startDt)");
    			}else{
    				where.append("(TO_CHAR(START_DT,'yyyy')  >=:minstartDt AND TO_CHAR(START_DT,'yyyy') <=:maxstartDt)");
    			}
    			break;
    	}
    	return where.toString();
    } 
    
    private String getOrgType(String targetCode){
    	String orgFieldType = "1";//1:线索登记，所属单位；2：规范管理，管理单位
    	switch (targetCode){
    		case TargetConstants.MHM_FOLLOWUP_STABLE_COUNT:
    		case TargetConstants.MHM_MANAGEMENT_SEVERE_COUNT:
    		case TargetConstants.MHM_WITHIN_SEVERE_COUNT:
    			orgFieldType = "2"; 
    			break;
    		case TargetConstants.MHM_NEW_SEVERE_COUNT:
    			orgFieldType = "1"; 
    			break;
    	}
    	return orgFieldType;
    }
    
    private MapSqlParameterSource getParameterSource(String orgCode, Date startDate, Date endDate, String targetCode){
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
    	switch (targetCode){
    		case TargetConstants.MHM_FOLLOWUP_STABLE_COUNT:
    			if(ObjectUtil.isNotEmpty(startDate) && ObjectUtil.isNotEmpty(endDate)){
        			sqlParameterSource.addValue("minfollowupDt", startDate);
        			sqlParameterSource.addValue("maxfollowupDt", endDate);
    			} else if(ObjectUtil.isNotEmpty(startDate) ){
    				sqlParameterSource.addValue("followupDt", startDate);
    			}else if(ObjectUtil.isNotEmpty(endDate) ){
    				sqlParameterSource.addValue("followupDt", endDate);
    			}    			
    			break;    		
    		case TargetConstants.MHM_MANAGEMENT_SEVERE_COUNT:
    			if(ObjectUtil.isNotEmpty(startDate) && ObjectUtil.isNotEmpty(endDate)){
    				sqlParameterSource.addValue("minbringIntoDate", startDate);
        			sqlParameterSource.addValue("maxbringIntoDate", endDate);
        			sqlParameterSource.addValue("minstartDt", startDate);
        			sqlParameterSource.addValue("maxstartDt", endDate);
    			} else if(ObjectUtil.isNotEmpty(startDate) ){
    				sqlParameterSource.addValue("bringIntoDate", startDate);
    				sqlParameterSource.addValue("startDt", startDate);
    			}else if(ObjectUtil.isNotEmpty(endDate) ){
    				sqlParameterSource.addValue("bringIntoDate", endDate);
    				sqlParameterSource.addValue("startDt", startDate);
    			}
    			break;
    		case TargetConstants.MHM_NEW_SEVERE_COUNT:
    			if(ObjectUtil.isNotEmpty(startDate) && ObjectUtil.isNotEmpty(endDate)){
    				sqlParameterSource.addValue("minmodifyDate", startDate);
        			sqlParameterSource.addValue("maxmodifyDate", endDate);
    			} else if(ObjectUtil.isNotEmpty(startDate) ){
    				sqlParameterSource.addValue("modifyDate", startDate);
    			}else if(ObjectUtil.isNotEmpty(endDate) ){
    				sqlParameterSource.addValue("modifyDate", endDate);
    			}    			
    			break;
    		case TargetConstants.MHM_WITHIN_SEVERE_COUNT:
    			if(ObjectUtil.isNullOrEmpty(startDate) && ObjectUtil.isNullOrEmpty(endDate)){
    				sqlParameterSource.addValue("startDt", DateUtil.toDateString(new Date(), "yyyy"));
    				sqlParameterSource.addValue("bringIntoDate", DateUtil.toDateString(new Date(), "yyyy"));
    			}else if(ObjectUtil.isNullOrEmpty(startDate)){
    				sqlParameterSource.addValue("startDt", DateUtil.toDateString(endDate, "yyyy"));
    				sqlParameterSource.addValue("bringIntoDate", DateUtil.toDateString(endDate, "yyyy"));
    			}else {
    				sqlParameterSource.addValue("minstartDt", DateUtil.toDateString(startDate, "yyyy"));
        			sqlParameterSource.addValue("maxstartDt", DateUtil.toDateString(ObjectUtil.isNullOrEmpty(endDate)?new Date():endDate, "yyyy")); 
        			sqlParameterSource.addValue("minbringIntoDate", DateUtil.toDateString(startDate, "yyyy"));
        			sqlParameterSource.addValue("maxbringIntoDate", DateUtil.toDateString(ObjectUtil.isNullOrEmpty(endDate)?new Date():endDate, "yyyy"));
    			}      			
    			
    			break;
    	}  
    	sqlParameterSource.addValue("ORG_CODE",orgCode);
		return sqlParameterSource;
    }    
}