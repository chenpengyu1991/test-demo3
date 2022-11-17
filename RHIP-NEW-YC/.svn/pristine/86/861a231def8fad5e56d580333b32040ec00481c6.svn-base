package com.founder.rhip.portal.repository;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.OutDoctor;
import com.founder.rhip.ehr.repository.portal.IOutDoctorDao;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.List;

/**
 * DAO implement of Doctor
 * 
 */
@Repository("outDoctorDao")
public class OutDoctorDaoImpl extends AbstractDao<OutDoctor, String> implements IOutDoctorDao {
	@Resource(name = "portaldbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public List<OutDoctor> getScheduleDoctor(Criteria criteria){
		StringBuilder sb = new StringBuilder("SELECT ODR.HOSPITAL_CODE, ODR.DEPT_SN,");
		sb.append(" ODR.DOCTOR_SN, ODR.NAME, ODR.SPECIALIZES ");
		sb.append(" FROM OUT_DOCTOR ODR LEFT JOIN  REGISTER_SCHEDULE RS ");
		sb.append(" ON RS.HOSPITAL_CODE = ODR.HOSPITAL_CODE ");
		sb.append(" AND RS.DEPT_SN = ODR.DEPT_SN ");
		sb.append(" AND RS.DOCTOR_SN = ODR.DOCTOR_SN ");
		SqlBuilder.buildWhereStatement(OutDoctor.class, sb, criteria);
		sb.append(" GROUP BY ODR.HOSPITAL_CODE,ODR.DEPT_SN,ODR.DOCTOR_SN,ODR.NAME,ODR.SPECIALIZES ");
		sb.append(" ORDER BY ODR.HOSPITAL_CODE,ODR.DEPT_SN,ODR.DOCTOR_SN,ODR.NAME,ODR.SPECIALIZES ");
		
		List<OutDoctor> doctorList = this.getList(sb.toString(),criteria);
		return doctorList;
	}

	@Override
	public List<OutDoctor> getHosInfosByDoctor(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select hi.hospital_name, od.id, od.hospital_code, od.name, od.doctor_sn, od.dept_sn, od.dept_name, od.emp_tit_name, od.emp_tit_code");
		sb.append(" from out_doctor od left join hospital_info hi ");
		sb.append(" on (od.hospital_code = hi.hospital_no) ");
		SqlBuilder.buildWhereStatement(OutDoctor.class, sb, criteria);
		sb.append(" order by hi.hospital_name, od.name ");
		List<OutDoctor> doctorList = this.getList(sb.toString(),criteria);
		return doctorList;
	}

	@Override
	public List<OutDoctor> getOutHospitals(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select od.hospital_code, hi.hospital_name, hi.order_num");
		sb.append(" from out_doctor od left join hospital_info hi");
		sb.append(" on (od.hospital_code = hi.hospital_no) ");
		SqlBuilder.buildWhereStatement(OutDoctor.class, sb, criteria);
		sb.append(" and hi.is_delete='0'");
		sb.append(" group by od.hospital_code, hi.hospital_name, hi.order_num");
		sb.append(" order by hi.order_num");
		List<OutDoctor> hospitalNameList = this.getList(sb.toString(), criteria);
		return hospitalNameList;
	}

	@Override
	public List<OutDoctor> getHotDoctors(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select od.emp_tit_name, od.emp_tit_code");
		sb.append(" from out_doctor od left join hospital_info hi ");
		sb.append(" on (od.hospital_code = hi.hospital_no) ");
		SqlBuilder.buildWhereStatement(OutDoctor.class, sb, criteria);
		sb.append(" group by od.emp_tit_name, od.emp_tit_code");
		sb.append(" order by od.emp_tit_name");
		List<OutDoctor> getHotDoctorLists = this.getList(sb.toString(), criteria);
		return getHotDoctorLists;
	}
	
	@Override
	public List<OutDoctor> getHotClinics(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select od.dept_name, od.dept_sn");
		sb.append(" from out_doctor od left join hospital_info hi ");
		sb.append(" on (od.hospital_code = hi.hospital_no) ");
		SqlBuilder.buildWhereStatement(OutDoctor.class, sb, criteria);
		sb.append(" and hi.is_delete='0'");
		sb.append(" group by od.dept_name, od.dept_sn");
		sb.append(" order by od.dept_name");
		List<OutDoctor> getHotClinicsLists = this.getList(sb.toString(), criteria);
		return getHotClinicsLists;
	}
	
	@Override
	public List<OutDoctor> getHotEmpTits(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select od.emp_tit_name, od.emp_tit_code");
		sb.append(" from out_doctor od left join hospital_info hi ");
		sb.append(" on (od.hospital_code = hi.hospital_no) ");
		SqlBuilder.buildWhereStatement(OutDoctor.class, sb, criteria);
		sb.append(" group by od.emp_tit_name, od.emp_tit_code");
		sb.append(" order by od.emp_tit_name");
		List<OutDoctor> getHotEmpTitsLists = this.getList(sb.toString(), criteria);
		return getHotEmpTitsLists;
	}

	@Override
	public PageList<OutDoctor> showHotDoctors(Page page, String searchContent, Criteria criteria) {
		StringBuilder sb = new StringBuilder("select hi.hospital_name, od.id, od.hospital_code, od.doctor_sn, od.name, "
				+ "od.dept_sn, od.dept_name, od.emp_tit_name, od.emp_tit_code, od.specializes, od.work_experience, od.is_hot, od.is_delete, od.status");
		sb.append(" from out_doctor od left join hospital_info hi ");
		sb.append(" on (od.hospital_code = hi.hospital_no) ");
		SqlBuilder.buildWhereStatement(OutDoctor.class, sb, criteria);
		if(ObjectUtil.isNotEmpty(searchContent)) {
			sb.append(" and od.name like '%").append(searchContent).append("%'");
		}
		sb.append(" and hi.is_delete='0'");
		sb.append(" order by hi.hospital_name, od.name");
		PageList<OutDoctor> showHotDoctorsPageLists = this.getPageList(page, sb.toString(), criteria);
		return showHotDoctorsPageLists;
	}
	
}