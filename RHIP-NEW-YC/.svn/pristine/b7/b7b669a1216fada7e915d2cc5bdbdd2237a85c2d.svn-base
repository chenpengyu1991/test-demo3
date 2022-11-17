package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.ObservationInfo;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

/**
 * DAO implement of ObservationInfo
 * 
 */
@Repository("observationInfoDao")
public class ObservationInfoDaoImpl extends AbstractDao<ObservationInfo, Long> implements IObservationInfoDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<ObservationInfo> getPersonAndEhrList(int type) {
		StringBuilder sb = new StringBuilder("SELECT " +
				"	T1.PERSON_ID, T1.EHR_ID " +
				" FROM " +
				"	( " +
				"		SELECT " +
				"			PERSON_ID, " +
				"			EHR_ID, " +
				"			DECODE(trim(translate(nvl(OBSERVATION_RESULT,0),'0123456789.',' ')),null,nvl(OBSERVATION_RESULT,0),0) as OBSERVATION_RESULT " +
				"		FROM " +
				"			MS_OBSERVATION_INFO " +
				"		WHERE " +
				"			OBSERVATION_ITEM_CODE = '010011' " +
				"  AND regexp_like(OBSERVATION_RESULT ,'^(-?[0-9]+)(.[0-9]+)?$') " + 
				"	) T1 " +
				" INNER JOIN ( " +
				"	SELECT " +
				"		PERSON_ID, " +
				"		EHR_ID, " +
                "		DECODE(trim(translate(nvl(OBSERVATION_RESULT,0),'0123456789.',' ')),null,nvl(OBSERVATION_RESULT,0),0) as OBSERVATION_RESULT " +
				"	FROM " +
				"		MS_OBSERVATION_INFO " +
				"	WHERE " +
				"		OBSERVATION_ITEM_CODE = '010012' " +
				"  AND regexp_like(OBSERVATION_RESULT ,'^(-?[0-9]+)(.[0-9]+)?$') " + 
				" ) T2 ON T1.PERSON_ID = T2.PERSON_ID " +
				" AND T1.EHR_ID = T2.EHR_ID " +
                " AND T2.OBSERVATION_RESULT <> 0 " );
		if(type == 1){
//			sb.append(" AND trunc(T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01)),4) > 24 " +
//					" AND trunc(T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01)),4) < 27.9999 ");
			sb.append(" AND trunc(DECODE(T2.OBSERVATION_RESULT,0,0,T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01))),4) > 24");
			sb.append(" AND trunc(DECODE(T2.OBSERVATION_RESULT,0,0,T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01))),4) < 27.9999");
			
		}else if(type == 2){
			//sb.append(" AND trunc(T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01)),4) > 28" );
			sb.append(" AND trunc(DECODE(T2.OBSERVATION_RESULT,0,0,T1.OBSERVATION_RESULT/((T2.OBSERVATION_RESULT*0.01)*(T2.OBSERVATION_RESULT*0.01))),4) > 28");
		}
		return this.getList(sb.toString());
	}
}