package com.founder.rhip.portal.repository;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.portal.OutClinic;
import com.founder.rhip.ehr.repository.portal.IOutClinicDao;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of Department
 * 
 */
@Repository("outClinicDao")
public class OutClinicDaoImpl extends AbstractDao<OutClinic, String> implements IOutClinicDao {
	
	@Resource(name = "portaldbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public List<String> getOutHospitalCode(){
		List<String> strList = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder("SELECT  DISTINCT(HOSPITAL_CODE) HOSPITAL_CODE FROM OUT_CLINIC ");
		List<Map<String, Object>> mapList = this.getMapList(sb.toString(), new Criteria());
		
		for(Map<String, Object> map:mapList){
			String hospitalCode = map.get("HOSPITAL_CODE").toString();
			strList.add(hospitalCode);
		}
		
		return strList;
	}
	
	
	@Override
	public List<OutClinic> getOutClinics(Criteria criteria){
		StringBuilder sb = new StringBuilder("SELECT RS.HOSPITAL_CODE,RS.DEPT_SN,OC.NAME,RS.CLINIC_TYPE FROM REGISTER_SCHEDULE RS");
		sb.append(" LEFT JOIN OUT_CLINIC OC ON RS.DEPT_SN = OC.DEPT_SN AND RS.HOSPITAL_CODE = OC.HOSPITAL_CODE");
		SqlBuilder.buildWhereStatement(OutClinic.class, sb, criteria);
		sb.append(" GROUP BY RS.HOSPITAL_CODE,RS.DEPT_SN,OC.NAME,RS.CLINIC_TYPE");
		SqlBuilder.buildOrderStatement(sb, " RS.HOSPITAL_CODE,RS.DEPT_SN,RS.CLINIC_TYPE ");
		
		List<OutClinic> list = this.getList(sb.toString(), criteria);
		return list;
	}
	
	/** 
	* @Title: getOutClinics 
	* @Description: 查询可预约的科室
	* @param @param criteria
	* @param @return
	* @return List<OutClinic>
	* @throws 
	*/
	public List<OutClinic> getReserveableClinics(Criteria criteria){
		StringBuilder sb = new StringBuilder("select t.id, t.hospital_code, t.dept_sn, t.name, t.abb_code, t.abb_name, t.py_code ");
		sb.append("from OUT_CLINIC t");
		/*sb.append("from OUT_CLINIC t join REGISTER_SCHEDULE rs on rs.hospital_code = t.hospital_code and rs.dept_sn = t.dept_sn ");*/
		SqlBuilder.buildWhereStatement(OutClinic.class, sb, criteria);
		sb.append(" GROUP BY T.ID,T.HOSPITAL_CODE,T.DEPT_SN,T.NAME,T.ABB_CODE,T.ABB_NAME,T.PY_CODE order by T.PY_CODE");
		/*SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);*/
		List<OutClinic> list = this.getList(sb.toString(),criteria);
		return list;
	}
}