package com.founder.rhip.ehr.repository.basic;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonMoveInfo;

/**
 * DAO implement of personMoveInfoDao
 * 
 */
@Repository("personMoveInfoDao")
public class PersonMoveInfoDaoImpl extends AbstractDao<PersonMoveInfo, Long> implements IPersonMoveInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<Map<String, Object>> exportMovePersonRecordList(Page page, Criteria criteria, Order order) {
		Criteria ca = new Criteria();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT B.NAME,B.IDCARD,B.HOUSEHOLD_TYPE,B.GENDER,B.BIRTHDAY,B.UPDATE_DATE,B.PAPROVINCE,B.PACITY,B.PACOUNTY,B.PATOWN_SHIP,B.PASTREET,B.PAHOUSE_NUMBER,B.FILING_FLAG,B.STAR,B.PHONE_NUMBER,B.NATION,B.HRCOUNTY,B.INPUT_NAME,B.HRTOWN_SHIP,B.HRSTREET,B.HRHOUSE_NUMBER,B.INPUT_DATE,B.PHYSICIANS_CARING_NAME,B.INPUT_ORGAN_CODE,B.GUARDIAN_PHONE_ONE,B.INPUTER_ID,B.HEALTH_FILE_NO,B.REMARKS,M.OLD_STATION_CODE,M.NEW_STATION_CODE,M.OPERATOR,M.OPERATION_DATE ");
    	sql.append(" FROM BI_PERSON_INFO B RIGHT JOIN BI_ARCHIVES_MOVE_RECORD M ON B.ID = M.PERSON_ID" );
    	
    	sql.append(" WHERE M.OLD_STATION_CODE IS NOT NULL ");
        
        if(StringUtil.isNotEmpty((String)criteria.get("personName"))){
            sql.append(" AND ").append("M.PERSON_NAME LIKE '%").append((String)criteria.get("personName")).append("%'");
        }
        
        if(ObjectUtil.isNotEmpty(criteria.get("newStationCode"))){
            if(ObjectUtil.isCollection(criteria.get("newStationCode"))){
        		sql.append(" AND ").append("M.NEW_STATION_CODE").append(" in ( :newStationCode )");
        	}else if(ObjectUtil.isString(criteria.get("newStationCode"))){
        		sql.append(" AND ").append("M.NEW_STATION_CODE").append(" =:newStationCode");
        	}
        	ca.add("newStationCode", criteria.get("newStationCode"));
        }
        
        if(ObjectUtil.isNotEmpty(criteria.get("oldStationCode"))){
            if(ObjectUtil.isCollection(criteria.get("oldStationCode"))){
        		sql.append(" AND ").append("M.OLD_STATION_CODE").append(" in ( :oldStationCode )");
        	}else if(ObjectUtil.isString(criteria.get("oldStationCode"))){
        		sql.append(" AND ").append("M.OLD_STATION_CODE").append(" =:oldStationCode");
        	}
        	ca.add("oldStationCode", criteria.get("oldStationCode"));
        }
        
        if(ObjectUtil.isNotEmpty(criteria.get("operationDate"))){
        	for(Criterion cri : criteria.getCriteria()){
        		if("operationDate".equals(cri.getName())){
        			if(cri.getOperation().equals(OP.GE)){
        				 sql.append(" AND ").append("M.OPERATION_DATE").append(" >=:operationDateStart");
        				 ca.add("operationDateStart", cri.getValue());
        			}
        			
        			if(cri.getOperation().equals(OP.BETWEEN)){
        				 Object[] objs = (Object[]) cri.getValue();
        				 sql.append(" AND ").append("M.OPERATION_DATE").append(" >=:operationDateStart");
        				 sql.append(" AND ").append("M.OPERATION_DATE").append(" <=:operationDateEnd");
	       				 ca.add("operationDateStart", objs[0]);
	       				 ca.add("operationDateEnd", objs[1]);
        			}
        			
        			if(cri.getOperation().equals(OP.LE)){
       				 sql.append(" AND ").append("M.OPERATION_DATE").append(" <=:operationDateEnd");
       				 ca.add("operationDateEnd", cri.getValue());
       			}
        		}
        	}
        }
		
		sql.append(order.toString());
		PageList<Map<String, Object>> map = getPageMapList(page, sql.toString(),ca);
        return map;
	}

	@Override
	public void batchInsertMergeOrgan(List<String> oldOrgCodes, Organization newOrg, String operator) {
		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO BI_ARCHIVES_MOVE_RECORD(PERSON_ID,PERSON_NAME,ID_CARD,OLD_STATION_CODE,OLD_STATION_NAME,NEW_STATION_CODE,NEW_STATION_NAME,OPERATOR_ID,OPERATOR,OPERATION_DATE,IS_DELETE)\n" +
				"select id,name,idcard,INPUT_ORGAN_CODE,INPUT_ORGAN_NAME,'%1$s','%2$s','01','%3$s',sysdate,0 from bi_person_info\n" +
				"where INPUT_ORGAN_CODE in(:inputOrganCodes)");
		MapSqlParameterSource parameterSource = new MapSqlParameterSource("inputOrganCodes", oldOrgCodes);
		String sql = String.format(sqlBuilder.toString(), newOrg.getOrganCode(), newOrg.getOrganName(),operator);
		simpleJdbcTemplate.update(sql, parameterSource);
	}

	@Override
	public void batchInsertChangeRelationOrgVillage(String[] newAddVillageCodes, Organization newOrg, String operator) {
		StringBuilder sqlBuilder = new StringBuilder("INSERT INTO BI_ARCHIVES_MOVE_RECORD(PERSON_ID,PERSON_NAME,ID_CARD,OLD_STATION_CODE,OLD_STATION_NAME,NEW_STATION_CODE,NEW_STATION_NAME,OPERATOR_ID,OPERATOR,OPERATION_DATE,IS_DELETE)\n" +
				"select id,name,idcard,INPUT_ORGAN_CODE,INPUT_ORGAN_NAME,'%1$s','%2$s','01','%3$s',sysdate,0 from bi_person_info\n" +
				"where pastreet in(:pastreets)");
		MapSqlParameterSource parameterSource = new MapSqlParameterSource("pastreets", Arrays.asList(newAddVillageCodes));
		String sql = String.format(sqlBuilder.toString(), newOrg.getOrganCode(), newOrg.getOrganName(),operator);
		simpleJdbcTemplate.update(sql, parameterSource);
	}
}