package com.founder.rhip.portal.repository;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.entity.portal.SurveyItem;
import com.founder.rhip.ehr.entity.portal.SurveyOption;
import com.founder.rhip.ehr.repository.portal.IReserveRegisterDao;

/**
 * DAO implement of Appointment
 * 
 */
@Repository("reserveRegisterDao")
public class ReserveRegisterDaoImpl extends AbstractDao<ReserveRegister, Long> implements IReserveRegisterDao {
	@Resource(name = "portaldbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	/**
     * 按职业统计
     */
    private static final String REGISER_STATISTICS_SQL = "select * from(select"
    		+ " decode(grouping_id(hospitalCode)+grouping_id(dsn)+grouping_id(dname) , 3, '合计', dsn) AS dept_sn,"
    		+ " decode(grouping_id(hospitalCode)+grouping_id(dsn) , 2, '合计', hospitalCode) AS hospital_code,"
    		+ " decode(grouping_id(dsn)+grouping_id(dname) , 2, '合计', dname) AS dept_name,"
    		+ "SUM(DECODE(NVL(reserver_stauts, 0), 0, 0, 1)) total,"
    		+ " SUM(CASE WHEN reserver_stauts = '01' THEN 1  ELSE 0 END) AS future,"
    		+ " SUM(CASE WHEN reserver_stauts = '02' THEN 1 ELSE 0 END) AS time,"
    		+ " SUM(CASE WHEN reserver_stauts = '03' THEN 1 ELSE 0 END) AS fails, "
    		+ " SUM(CASE WHEN reserver_stauts = '04' THEN 1 ELSE 0 END) AS cancel,"
    		+ " SUM(CASE WHEN reserver_stauts = '05' THEN 1 ELSE 0 END) AS stop"
    		+ " from ("
    		+ " SELECT oc.hospital_code hospitalCode,oc.dept_sn dsn,oc.name dname,rr.*"
    		+ " FROM out_clinic oc LEFT JOIN (SELECT * FROM reserve_register %2$s)rr "
    		+ " on oc.hospital_code =rr.hospital_code and oc.dept_sn = rr.dept_sn %1$s ) hh"
    		+ " GROUP BY CUBE(hh.hospitalCode, hh.dsn, hh.dname)"
    		+ " order by hh.hospitalCode, hh.dsn, hh.dname)yy"
    		+ "  where yy.hospital_code is not null and yy.dept_sn is not null and yy.dept_name is not null";

    /**
     * 根据机构获取各个科室的预约数
     * @param criteria
     * @return
     */
    @Override
	public List<ReserveRegister> getRegisterTargetList(Criteria criteria) {
		StringBuilder sql = new StringBuilder(REGISER_STATISTICS_SQL);
		StringBuilder  whereSQL1 = new StringBuilder();
		StringBuilder  whereSQL2 = new StringBuilder();

        if(criteria.contains("oc.HOSPITAL_CODE")){
            String hospitalCode = criteria.get("oc.HOSPITAL_CODE").toString();
            if(ObjectUtil.isNotEmpty(hospitalCode)){
                whereSQL1.append(" where oc.HOSPITAL_CODE='" + hospitalCode + "'");//机构类型
            }
        }
		criteria.remove("oc.HOSPITAL_CODE");
		SqlBuilder.buildWhereStatement(ReserveRegister.class, whereSQL2, criteria);
		String lastSql = String.format(sql.toString(),whereSQL1.toString(),whereSQL2.toString());
		return this.getList(lastSql, criteria);
	}

	@Override
	public PageList<ReserveRegister> getResRegByFreContacts(Long accountId, Criteria criteria,
			Page page) {
		StringBuilder sql = new StringBuilder("(select * from ");
		sql.append(" (select t.* from reserve_register t ,account_info i ");
		if(criteria.getCriteria().size() != 0) {
			SqlBuilder.buildWhereStatement(ReserveRegister.class, sql, criteria);
			sql.append(" and ");
		} else {
			sql.append(" where ");
		}
		sql.append(" t.idcard = i.card_no ");
		sql.append(" and i.id= '"+accountId+"' ");
		
		sql.append(" union all ");
		sql.append(" select s.* from reserve_register s ,frequent_contacts f ");
		if(criteria.getCriteria().size() != 0) {
			SqlBuilder.buildWhereStatement(ReserveRegister.class, sql, criteria);
			sql.append(" and ");
		} else {
			sql.append(" where ");
		}
		sql.append(" s.idcard = f.card_no ");
		sql.append(" and f.account_id = '"+accountId+"' )");
		sql.append(" order by submit_Date desc )");
		PageList<ReserveRegister> getResRegByFreContacts = this.getPageList(page, sql.toString(), criteria);
		return getResRegByFreContacts;
	}

	@Override
	public List<ReserveRegister> getAllReserve(Long accountId,Criteria criteria) {
		StringBuilder sql = new StringBuilder("(select t.* from reserve_register t ,account_info i ");
		if(criteria.getCriteria().size() != 0) {
			SqlBuilder.buildWhereStatement(ReserveRegister.class, sql, criteria);
			sql.append(" and ");
		} else {
			sql.append(" where ");
		}
		sql.append(" t.idcard = i.card_no ");
		sql.append(" and i.id= '"+accountId+"' ");
		
		sql.append(" union all ");
		sql.append(" select s.* from reserve_register s ,frequent_contacts f ");
		if(criteria.getCriteria().size() != 0) {
			SqlBuilder.buildWhereStatement(ReserveRegister.class, sql, criteria);
			sql.append(" and ");
		} else {
			sql.append(" where ");
		}
		sql.append(" s.idcard = f.card_no ");
		sql.append(" and f.account_id = '"+accountId+"') ");
		List<ReserveRegister> getResRegByFreContacts = this.getList(sql.toString(), criteria);
		return getResRegByFreContacts;
	}
	
}