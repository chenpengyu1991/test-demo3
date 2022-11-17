package com.founder.rhip.portal.repository;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.repository.portal.IRegisterScheduleDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of Schedual
 * 
 */
@Repository("registerScheduleDao")
public class RegisterScheduleDaoImpl extends AbstractDao<RegisterSchedule, String> implements IRegisterScheduleDao {

	@Resource(name = "portaldbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public PageList<RegisterSchedule> getRegisterSchedules(Criteria criteria,Page page){
		StringBuilder sb = new StringBuilder("SELECT RS.HOSPITAL_CODE,RS.DEPT_SN,OC.NAME AS deptName,OD.NAME AS doctorName,RS.DOCTOR_SN,RS.CLINIC_TYPE,RS.REGISTER_FEE FROM REGISTER_SCHEDULE RS");
		sb.append(" LEFT JOIN OUT_CLINIC OC ON RS.DEPT_SN = OC.DEPT_SN  AND RS.HOSPITAL_CODE = OC.HOSPITAL_CODE");
		sb.append(" LEFT JOIN OUT_DOCTOR OD ON RS.DEPT_SN = OD.DEPT_SN AND RS.HOSPITAL_CODE = OD.HOSPITAL_CODE AND RS.DOCTOR_SN = OD.DOCTOR_SN");
		SqlBuilder.buildWhereStatement(RegisterSchedule.class, sb, criteria);
		sb.append(" GROUP BY RS.HOSPITAL_CODE,RS.DEPT_SN,OC.NAME,OD.NAME,RS.DOCTOR_SN,RS.CLINIC_TYPE,RS.REGISTER_FEE ");
		SqlBuilder.buildOrderStatement(sb, " RS.DOCTOR_SN ");
		
		PageList<RegisterSchedule> pageList = this.getPageList(page, sb.toString(), criteria);
		return pageList;
	}
	
	@Override
	public List<RegisterSchedule> getRegisterSchedules(Criteria criteria){
		StringBuilder sb = new StringBuilder("SELECT T.ID, T.DOCTOR_SN,T.HOSPITAL_CODE,T.DEPT_SN,");
		/*sb.append(" T.CLINIC_TYPE ,T.ADMIT_NUM,T.RESERVE_NUM,T.REGISTER_FEE, ");*/
		sb.append(" T.CLINIC_TYPE,T.REGISTER_FEE, ");
		sb.append(" ODR.NAME DOCTOR_NAME,ODR.SPECIALIZES,T.AMPM ,T.REQUEST_DATE");
		sb.append(" FROM  REGISTER_SCHEDULE T LEFT JOIN OUT_DOCTOR ODR ");
		sb.append(" ON T.DOCTOR_SN = ODR.DOCTOR_SN ");
		sb.append(" AND T.HOSPITAL_CODE = ODR.HOSPITAL_CODE ");
		sb.append(" AND T.DEPT_SN = ODR.DEPT_SN ");
		SqlBuilder.buildWhereStatement(RegisterSchedule.class, sb, criteria);
		SqlBuilder.buildOrderStatement(sb, " T.HOSPITAL_CODE,T.DEPT_SN,T.CLINIC_TYPE ");
		
		List<RegisterSchedule> list = this.getList(sb.toString(), criteria);
		return list;
	}
	
	@Override
	public List<Date> getRequestDate(Criteria criteria){
		StringBuilder sb = new StringBuilder("SELECT DISTINCT(REQUEST_DATE) REQUEST_DATE FROM  REGISTER_SCHEDULE ");
		SqlBuilder.buildWhereStatement(RegisterSchedule.class, sb,criteria);
		SqlBuilder.buildOrderStatement(sb, " REQUEST_DATE ");
		
		List<Map<String,Object>> mapList = this.getMapList(sb.toString(), criteria);
		List<Date> dateList = new ArrayList<Date>();
		for(Map<String,Object> map:mapList){
			Date date = (Date)map.get("request_date");
			dateList.add(date);
		}
		return dateList;
	}
	
	@Override
	public int updateRegisterSchedule(Long id){
		int r=0;
		/*StringBuilder sb = new StringBuilder("update REGISTER_SCHEDULE set RESERVE_NUM=RESERVE_NUM+1");
//		sb.append(reserveNum);
		sb.append(" where ID =");
		sb.append(id);
		sb.append(" and RESERVE_NUM < ADMIT_NUM");
		r=execute(sb.toString());*/
		return r;
	}
	
	@Override
	public PageList<RegisterSchedule> getSearchRegisterSchedulePageLists(Page page, String deptName) {
		StringBuilder sb = new StringBuilder("select oc.hospital_code, "
				+ "hi.hospital_name as hospitalName,"
				+ " oc.dept_sn, oc.name as deptName");
		sb.append(" from register_schedule rs");
		sb.append(" left join  out_clinic oc");
		sb.append(" on (oc.dept_sn = rs.dept_sn and oc.hospital_code = rs.hospital_code)");
		sb.append(" left join hospital_info hi on (oc.hospital_code = hi.hospital_no)");
		sb.append(" where oc.name like '%").append(deptName).append("%'");
		sb.append(" and to_char(request_date, 'yyyy/mm/dd') > '"+DateUtil.convertDateToString(new Date())+"' ");
		sb.append(" group by oc.hospital_code, hi.hospital_name, oc.dept_sn, oc.name ");
		PageList<RegisterSchedule> registerSchedulePageLists = this.getPageList(page, sb.toString(), new Criteria());
		return registerSchedulePageLists;
	}
	
	@Override
	public List<RegisterSchedule> getDisHosRegisterScheduleList(Criteria criteria) {
		StringBuilder sb = new StringBuilder("SELECT DISTINCT(HOSPITAL_CODE)");
		sb.append(" FROM REGISTER_SCHEDULE");
		List<RegisterSchedule> registerScheduleList = this.getList(sb.toString(), criteria);
		return registerScheduleList;
	}

	@Override
	public List<RegisterSchedule> getNoPageRegisterSchedule(Criteria criteria) {
		StringBuilder sb = new StringBuilder("SELECT RS.ID,RS.HOSPITAL_CODE,RS.DEPT_SN,RS.DOCTOR_SN,RS.CLINIC_TYPE,RS.REGISTER_FEE FROM REGISTER_SCHEDULE RS");
		sb.append(" LEFT JOIN OUT_CLINIC OC ON RS.DEPT_SN = OC.DEPT_SN ");
		SqlBuilder.buildWhereStatement(RegisterSchedule.class, sb, criteria);
		sb.append(" GROUP BY RS.ID,RS.HOSPITAL_CODE,RS.DEPT_SN,RS.DOCTOR_SN,RS.CLINIC_TYPE,RS.REGISTER_FEE ");
		SqlBuilder.buildOrderStatement(sb, " RS.HOSPITAL_CODE,RS.DEPT_SN,RS.DOCTOR_SN,RS.CLINIC_TYPE,RS.REGISTER_FEE ");
		
		List<RegisterSchedule> List = this.getList(sb.toString(), criteria);
		return List;
	}

	@Override
	public List<RegisterSchedule> getDeptName(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select oc.name as deptName from register_schedule rs left join out_clinic oc");
		sb.append(" on rs.hospital_code = oc.hospital_code and rs.dept_sn = oc.dept_sn");
		SqlBuilder.buildWhereStatement(RegisterSchedule.class, sb, criteria);
		/*sb.append(" where to_char(rs.request_date, 'yyyy/mm/dd') > '"+DateUtil.convertDateToString(new Date())+"' ");*/
		sb.append(" group by oc.name ");
		List<RegisterSchedule> List = this.getList(sb.toString(), criteria);
		return List;
	}

	@Override
	public List<RegisterSchedule> getHosByDeptName(Criteria criteria) {
		/*criteria.add("rs.request_date", OP.GT, new Date());*/
		StringBuilder sb = new StringBuilder("select rs.hospital_code, hi.hospital_name as hospitalName, oc.name as deptName from register_schedule rs left join out_clinic oc");
		sb.append(" on rs.hospital_code = oc.hospital_code");
		sb.append(" left join hospital_info hi on rs.hospital_code = hi.hospital_no");
		SqlBuilder.buildWhereStatement(RegisterSchedule.class, sb, criteria);
		sb.append(" and to_char(rs.request_date, 'yyyy/mm/dd') > '"+DateUtil.convertDateToString(new Date())+"' ");
		sb.append(" group by oc.name,rs.hospital_code, hi.hospital_name ");
		List<RegisterSchedule> List = this.getList(sb.toString(), criteria);
		return List;
	}
	
}