package com.founder.rhip.ehr.repository.clinic;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.RegisterRecord;

/**
 * DAO implement of OutpatientInfo
 * 
 */
@Repository("registerRecordDao")
public class RegisterRecordDaoImpl extends AbstractDao<RegisterRecord, Long> implements IRegisterRecordDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


	@Override
	public List<Map<String,Object>> getRegisterStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
		StringBuilder sqlBuilder = new StringBuilder("SELECT T.CREATE_ORGAN_CODE CODE, TO_CHAR(T.VISIT_DATE, 'yyyy/MM/dd') VT, SUM(DECODE(T.VISIT_STATUS,'2', 1, 0)) N1,SUM(DECODE(T.VISIT_STATUS,'1', 1, 0)) N2, SUM(DECODE(T.VISIT_STATUS,'2', 1, 0))"
				+ "+SUM(DECODE(T.VISIT_STATUS,'1', 1, 0)) N3 FROM MS_REGISTER_RECORD T WHERE TO_CHAR(T.GATHER_DATE, 'yyyy/MM/dd')='");
			sqlBuilder.append(dateStr).append("'").append(" GROUP BY T.CREATE_ORGAN_CODE, TO_CHAR(T.VISIT_DATE, 'yyyy/MM/dd') ");
		return getMapList(sqlBuilder.toString(), (Criteria) null);
	}
}