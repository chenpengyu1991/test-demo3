package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.management.InoculationAppointmentParam;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("inoculationAppointmentParamDao")
public class InoculationAppointmentParamDaoImpl extends AbstractDao<InoculationAppointmentParam, Long> implements IInoculationAppointmentParamDao {
	 @Resource(name = "msdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<InoculationAppointmentParam> getInoculationAppointmentParamList(Criteria criteria) {
		Object countYear = criteria.get("countYear");
		Object organCode = criteria.get("organCode");
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT A.* FROM DC_INOCULAT_APPOINTMENT_PARAM A LEFT JOIN SY_PHBDB_MDM_ORGANIZATION B ON A.ORGAN_CODE=B.ORGAN_CODE WHERE 1=1 ");
		if(ObjectUtil.isNotEmpty(countYear)){
			sql.append("AND COUNT_YEAR='").append(countYear).append("'");
		}
		if(ObjectUtil.isNotEmpty(organCode)){
			sql.append("AND A.ORGAN_CODE='").append(organCode).append("'");
		}
		sql.append("ORDER BY B.sort ");
		return this.getList(sql.toString());
	}
	
}
