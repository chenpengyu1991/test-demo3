package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpWeightSet;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository("rpWeightSetDao")
public class RpWeightSetDaoImpl extends AbstractDao<RpWeightSet, Long> implements IRpWeightSetDao {
	
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	private static final String CHILD_AGE_STATISTICS_SQL =  " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) AS %4$s,"
			+ " sum(NVL(zero_num, 0))zero_num,sum(NVL(one_num, 0))one_num,"
			+ " sum(NVL(two_num, 0))two_num,sum(NVL(three_num, 0))three_num,"
			+ " sum(NVL(four_num, 0))four_num,sum(NVL(five_num, 0))five_num,sum(NVL(six_num, 0))six_num,sum(NVL(total_num, 0))total_num"
			+ " from rp_child rp %2$s GROUP BY rollup(%1$s) %6$s ORDER BY %1$s";

	@Override
	public PageList<RpWeightSet> getWeightSets(Criteria criteria, Page page){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM RP_WEIGHT_SET WHERE 1=1");
		if(ObjectUtil.isNotEmpty(criteria.get("GB_CODE"))){
			sql.append(" AND GB_CODE = '").append(criteria.get("GB_CODE").toString()).append("'");
		}
		if(ObjectUtil.isNotEmpty(criteria.get("CENTER_CODE")) && ObjectUtil.isNullOrEmpty(criteria.get("ORGAN_CODE"))){
			sql.append(" AND ORGAN_CODE = '").append(criteria.get("CENTER_CODE").toString()).append("'");
		}
		if(ObjectUtil.isNotEmpty(criteria.get("ORGAN_CODE"))){
			sql.append(" AND ORGAN_CODE = '").append(criteria.get("ORGAN_CODE").toString()).append("'");
		}
		if(ObjectUtil.isNotEmpty(criteria.get("RP_TYPE"))){
			sql.append(" AND RP_TYPE = '").append(criteria.get("RP_TYPE").toString()).append("'");
		}
		if(ObjectUtil.isNotEmpty(criteria.get("WEIGHT_INDEX"))){
			sql.append(" AND WEIGHT_INDEX = '").append(criteria.get("WEIGHT_INDEX").toString()).append("'");
		}
		if(ObjectUtil.isNotEmpty(criteria.get("RP_BEGIN_DATE")) && !ObjectUtil.isNotEmpty(criteria.get("RP_END_DATE"))){
			sql.append(" AND RP_END_DATE >=to_date('").append(criteria.get("RP_BEGIN_DATE").toString()).append("','yyyy/MM/dd')");
		}
		if(!ObjectUtil.isNotEmpty(criteria.get("RP_BEGIN_DATE")) && ObjectUtil.isNotEmpty(criteria.get("RP_END_DATE"))) {
			sql.append(" AND RP_BEGIN_DATE <=to_date('").append(criteria.get("RP_END_DATE").toString()).append("','yyyy/MM/dd')");
		}

		if(ObjectUtil.isNotEmpty(criteria.get("RP_BEGIN_DATE")) && ObjectUtil.isNotEmpty(criteria.get("RP_END_DATE"))) {
			sql.append(" AND (");
			sql.append(" (RP_BEGIN_DATE >=to_date('").append(criteria.get("RP_BEGIN_DATE").toString()).append("','yyyy/MM/dd')").append(" AND ").append("RP_BEGIN_DATE <=to_date('").append(criteria.get("RP_END_DATE").toString()).append("','yyyy/MM/dd')").append(")");
			sql.append(" OR ");
			sql.append(" (RP_END_DATE >=to_date('").append(criteria.get("RP_BEGIN_DATE").toString()).append("','yyyy/MM/dd')").append(" AND ").append("RP_END_DATE <=to_date('").append(criteria.get("RP_END_DATE").toString()).append("','yyyy/MM/dd')").append(")");
			sql.append(" OR ");
			sql.append(" (RP_BEGIN_DATE >=to_date('").append(criteria.get("RP_BEGIN_DATE").toString()).append("','yyyy/MM/dd')").append(" AND ").append("RP_END_DATE <=to_date('").append(criteria.get("RP_END_DATE").toString()).append("','yyyy/MM/dd')").append(")");
			sql.append(" OR ");
			sql.append(" (RP_BEGIN_DATE <=to_date('").append(criteria.get("RP_BEGIN_DATE").toString()).append("','yyyy/MM/dd')").append(" AND ").append("RP_END_DATE >=to_date('").append(criteria.get("RP_END_DATE").toString()).append("','yyyy/MM/dd')").append(")");
			sql.append(" ) ");
		}
		sql.append(" order by organ_code asc, rp_type asc, id desc ");
		criteria = new Criteria();
		return this.getPageList(page, sql.toString(), criteria);
	}
	
	/**
	 * 根据机构 类型和时间的查取表中的数据 只有一段时间在此时间段的也算
	 * @param organCode
	 * @param weightIndex
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@Override
	public List<RpWeightSet> getWeightSets(String gbCode, String organCode, String weightIndex, Date beginDate, Date endDate) {
		StringBuilder sql = new StringBuilder("select * from rp_weight_set t where 1=1");
		
		if(ObjectUtil.isNotEmpty(gbCode)) {
			sql.append(" and t.gb_code = '" + gbCode + "'");
		}
		
		if(ObjectUtil.isNotEmpty(organCode)) {
			sql.append(" and t.organ_code = '" + organCode + "'");
		}
		if(ObjectUtil.isNotEmpty(weightIndex)) {
			sql.append(" and t.weight_index = '" + weightIndex + "'");
		}
		if(ObjectUtil.isNotEmpty(beginDate) && ObjectUtil.isNotEmpty(endDate)) {
			String beginStr = DateUtil.getDateTime("yyyy/MM/dd", beginDate);
			String endStr = DateUtil.getDateTime("yyyy/MM/dd", endDate);
			sql.append("and (");
			sql.append(" (t.rp_begin_date>= to_date('" +  beginStr + "','yyyy/mm/dd') and t.rp_begin_date <=to_date('" +  endStr + "','yyyy/mm/dd'))");
			sql.append("or");
			sql.append(" (rp_begin_date <= to_date('" +  beginStr + "','yyyy/mm/dd') and  rp_end_date >=to_date('" +  beginStr + "','yyyy/mm/dd'))");
			sql.append(")");
		}
		return this.getList(sql.toString());
	}

	/**
	 * 个人绩效模拟(查询页面)
	 * @param organCode
	 * @param rpType
	 * @param weightIndex
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getStaffRpPaList(String organCode, String rpType, String weightIndex, String weightIndexColumn, String beginDate, String endDate){
		Criteria criteria = new Criteria();
		StringBuilder sql = new StringBuilder();
		sql.append(" select max(organ_code) as organCode, doctor_code as doctorCode, doctor_name as doctorName, max(rp_type) as rpType, max(WEIGHT_INDEX) as weightIndex, max(WEIGHT_VALUE) as weightValue, ");
		if(rpType.equalsIgnoreCase("1")) {
			sql.append(" sum(").append(weightIndexColumn).append("*WEIGHT_VALUE) as totalScore ");
		}
		if(rpType.equalsIgnoreCase("2")) {
			sql.append(" SUM(WEIGHT_VALUE) AS totalScore ");
		}
		sql.append(" from ");
		sql.append(" (select bb.organ_code,bb.doctor_code,bb.doctor_name,aa.rp_type,aa.weight_index,aa.WEIGHT_DATUM_BEGIN,aa.WEIGHT_DATUM_END,aa.weight_value,bb.").append(weightIndexColumn).append(" from RP_WEIGHT_SET aa ");
		sql.append(" left join ");
		sql.append(" (select * from RP_PA_WOMEN_CHILD_HEALTHCARE where rp_date >=to_date('").append(beginDate).append("','yyyy/MM/dd') and rp_date <=to_date('").append(endDate).append("','yyyy/MM/dd')) bb ");
		sql.append(" on aa.ORGAN_CODE=bb.ORGAN_CODE ");
		sql.append(" where aa.ORGAN_CODE='").append(organCode).append("'");
		sql.append(" and aa.RP_TYPE=").append(rpType);
		sql.append(" and aa.WEIGHT_INDEX=").append(weightIndex);
		sql.append(" and bb.rp_date >= aa.RP_BEGIN_DATE and bb.RP_DATE <= aa.RP_END_DATE ");
		if(rpType.equalsIgnoreCase("2")){
			sql.append(" and bb.").append(weightIndexColumn).append(">=aa.WEIGHT_DATUM_BEGIN and bb.").append(weightIndexColumn).append("<aa.WEIGHT_DATUM_END ");
		}
		sql.append(" )");
		sql.append(" group by doctor_code, doctor_name");
		return this.getMapList(sql.toString(), criteria);
	}
}
