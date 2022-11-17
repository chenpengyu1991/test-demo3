package com.founder.rhip.ehr.repository.basic;
import java.util.Arrays;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.PersonCanceledInfo;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Criterion;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import javax.annotation.Resource;

/**
 * DAO implement of PersonInfo
 * 
 */
@Repository("personCanceledInfoDao")
public class PersonCanceledInfoDaoImpl extends AbstractDao<PersonCanceledInfo, Long> implements IPersonCanceledDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<Map<String, Object>> exportPersonRecordList(Page page,
			Criteria criteria, Order order) {
		Criteria ca = new Criteria();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT PERSON_ID,B.NAME,B.IDCARD,B.HOUSEHOLD_TYPE,B.GENDER,B.BIRTHDAY,B.UPDATE_DATE,B.PAPROVINCE,B.PACITY,B.PACOUNTY,B.PATOWN_SHIP,B.PASTREET,B.PAHOUSE_NUMBER,B.FILING_FLAG,B.STAR,B.PHONE_NUMBER,B.NATION,B.HRCOUNTY,B.INPUT_NAME,B.HRTOWN_SHIP,B.HRSTREET,B.HRHOUSE_NUMBER,B.INPUT_DATE,B.PHYSICIANS_CARING_NAME,B.INPUT_ORGAN_CODE,B.GUARDIAN_PHONE_ONE,B.INPUTER_ID,B.HEALTH_FILE_NO,B.REMARKS,DECODE(CANCELED_REASON,1,'死亡',2,'迁出外地（县外）',3,'失访',9,'其他') CANCELED_REASON,CANCELED_DATE,CANCELED_NAME,CANCELED_ORGAN_CODE,DECODE(CANCELED_REASON,1,CANCELED_REASON_DATE)CANCELED_REASON_DATE ");
    	sql.append(" FROM BI_PERSON_INFO B RIGHT JOIN BI_PERSON_CANCELED_INFO P ON B.ID = P.PERSON_ID" );
    	
    	sql.append(" WHERE CANCELED_STATUS=1 ");
        
        if(StringUtil.isNotEmpty((String)criteria.get("personName"))){
            sql.append(" AND ").append("P.PERSON_NAME like '%").append((String)criteria.get("personName")).append("%'");
        }
        if(StringUtil.isNotEmpty((String)criteria.get("canceledReason"))){
            sql.append(" AND ").append("P.CANCELED_REASON").append("=:canceledReason");
            ca.add("canceledReason", (String)criteria.get("canceledReason"));
        }
        
        if(ObjectUtil.isNotEmpty(criteria.get("canceledOrganCode"))){
        	if(ObjectUtil.isCollection(criteria.get("canceledOrganCode"))){
        		sql.append(" AND ").append("P.CANCELED_ORGAN_CODE").append(" in ( :canceledOrganCode )");
        	}else if(ObjectUtil.isString(criteria.get("canceledOrganCode"))){
        		sql.append(" AND ").append("P.CANCELED_ORGAN_CODE").append(" =:canceledOrganCode");
        	}
        	 ca.add("canceledOrganCode", criteria.get("canceledOrganCode"));
        }
        
        if(ObjectUtil.isNotEmpty(criteria.get("canceledDate"))){
        	for(Criterion cri : criteria.getCriteria()){
        		if("canceledDate".equals(cri.getName())){
        			if(cri.getOperation().equals(OP.GE)){
        				 sql.append(" AND ").append("P.CANCELED_DATE").append(" >=:canceledDateStart");
        				 ca.add("canceledDateStart", cri.getValue());
        			}
        			
        			if(cri.getOperation().equals(OP.BETWEEN)){
        				 Object[] objs = (Object[]) cri.getValue();
        				 sql.append(" AND ").append("P.CANCELED_DATE").append(" >=:canceledDateStart");
        				 sql.append(" AND ").append("P.CANCELED_DATE").append(" <=:canceledDateEnd");
	       				 ca.add("canceledDateStart", objs[0]);
	       				 ca.add("canceledDateEnd", objs[1]);
        			}
        			
        			if(cri.getOperation().equals(OP.LE)){
       				 sql.append(" AND ").append("P.CANCELED_DATE").append(" <=:canceledDateEnd");
       				 ca.add("canceledDateEnd", cri.getValue());
       			}
        		}
        	}
        }
		
		sql.append(order.toString());
		PageList<Map<String, Object>> map = getPageMapList(page, sql.toString(),ca);
        return map;
	}

	@Override
	public void updatePersonCanceledInfo(String canceledOrganCode, String canceledOrganName, String[] newAddVillageCodes) {
		String sqlUpdate = "UPDATE BI_PERSON_CANCELED_INFO bi set bi.CANCELED_ORGAN_CODE= :canceledOrganCode ,bi.CANCELED_ORGAN_NAME = :canceledOrganName " +
				"where EXISTS(select 1 from BI_PERSON_INFO p where bi.PERSON_ID = p.id AND p.PASTREET in (:newAddVillageCodes))";

		MapSqlParameterSource parameterSource = new MapSqlParameterSource("canceledOrganCode", canceledOrganCode);
		parameterSource.addValue("canceledOrganName", canceledOrganName);
		parameterSource.addValue("newAddVillageCodes", Arrays.asList(newAddVillageCodes));
		simpleJdbcTemplate.update(sqlUpdate, parameterSource);
	}





}