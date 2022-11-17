package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.HmQueryConditionHelper;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of HmHospitalize
 * 
 */
@Repository("ihmHospitalizeDao")
public class HmHospitalizeDaoImpl extends AbstractDao<HmHospitalize, Long>
		implements IHmHospitalizeDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String HOSPITALIZE_RECORD_STATISTICS_SQL = "select * from("
            + " select %7$s"
            + " decode(grouping_id(%1$s), %5$s, %4$s) as %4$s,"
            + " round(sum(in_hos_fee)/decode(sum(sickbed_count),0,null,sum(sickbed_count)),4) avg_fee,"
            + " sum(in_hospital_num) in_hospital_num,sum(inhosp_operate_num) inhosp_operate_num,"
            + " sum(out_hosp_bed)/decode(sum(leave_hospital_num),0,null,sum(leave_hospital_num)) out_hosp_bed,"
            + " sum(critical_ill_num) critical_ill_num,"
            + " round(sum(in_hos_medicinal_fee)/decode(sum(in_hos_fee),0,null,sum(in_hos_fee)),4)*100 medicinal_fee_per,"
            + " 'daterange' period,"
            + " round(sum(antibacterial_num)/decode(sum(leave_hospital_num),0,null,sum(leave_hospital_num)),4) antibacterial_rate,"
            + " sum(t.leave_hospital_num) leave_hospital_num ,sum(t.in_hos_fee) in_hos_fee,sum(t.in_hos_medicinal_fee) in_hos_medicinal_fee,"
            + " sum(t.in_insurance_fee) in_insurance_fee,sum(t.in_personal_fee) in_personal_fee,"
            + " sum(sickbed_count) sickbed_count, sum(anesthesia_num) anesthesia_num"
            + " from (SELECT org.gb_code, org.center_code, org.organ_code, org.organ_type,"
            + " leave_hospital_num,in_hospital_num,inhosp_operate_num, out_hosp_bed, critical_ill_num,"
            + " antibacterial_num, in_hos_fee,in_hos_medicinal_fee,in_insurance_fee,in_personal_fee,"
            + " sickbed_count, anesthesia_num"
            + " FROM v_mdm_organization@DL_MS org"
            + " LEFT JOIN"
            + " (SELECT organ_code, in_hos_fee, leave_hospital_num, in_hospital_num, inhosp_operate_num,"
            + " out_hosp_bed, critical_ill_num, in_hos_medicinal_fee, antibacterial_num,"
            + " in_insurance_fee, in_personal_fee,sickbed_count,anesthesia_num"
            + " FROM RP_HM_HOSPITALIZE %2$s) o on o.organ_code =org.organ_code where 1=1 %3$s) t"
            + " group by rollup(%1$s) %6$s order by %1$s"
            + " )";

	private static final String HOSPITALIZE_RECORD_STATISTICS_EMP_SQL = "select * from("
			+ " select %7$s"
			+ " decode(grouping_id(%1$s), %5$s, %4$s) as %4$s,"
			+ " round(sum(in_hos_fee)/decode(sum(sickbed_count),0,null,sum(sickbed_count)),4) avg_fee,"
			+ " sum(in_hospital_num) in_hospital_num,sum(inhosp_operate_num) inhosp_operate_num,"
			+ " sum(out_hosp_bed)/decode(sum(leave_hospital_num),0,null,sum(leave_hospital_num)) out_hosp_bed,"
			+ " sum(critical_ill_num) critical_ill_num,"
			+ " round(sum(in_hos_medicinal_fee)/decode(sum(in_hos_fee),0,null,sum(in_hos_fee)),4)*100 medicinal_fee_per,"
			+ " 'daterange' period,"
			+ " round(sum(antibacterial_num)/decode(sum(leave_hospital_num),0,null,sum(leave_hospital_num)),4) antibacterial_rate,"
			+ " sum(t.leave_hospital_num) leave_hospital_num ,sum(t.in_hos_fee) in_hos_fee,sum(t.in_hos_medicinal_fee) in_hos_medicinal_fee,"
			+ " sum(t.in_insurance_fee) in_insurance_fee,sum(t.in_personal_fee) in_personal_fee,"
			+ " sum(sickbed_count) sickbed_count, sum(anesthesia_num) anesthesia_num"
			+ " from (SELECT org.gb_code, org.center_code, org.organ_code, org.organ_type,"
			+ " leave_hospital_num,in_hospital_num,inhosp_operate_num, out_hosp_bed, critical_ill_num,"
			+ " antibacterial_num, in_hos_fee,in_hos_medicinal_fee,in_insurance_fee,in_personal_fee,"
			+ " sickbed_count, anesthesia_num"
			+ " FROM v_mdm_organization@DL_MS org"
			+ " LEFT JOIN"
			+ " (SELECT organ_code, in_hos_fee, leave_hospital_num, in_hospital_num, inhosp_operate_num,"
			+ " out_hosp_bed, critical_ill_num, in_hos_medicinal_fee, antibacterial_num,"
			+ " in_insurance_fee, in_personal_fee,sickbed_count,anesthesia_num"
			+ " FROM RP_HM_HOSPITALIZE %2$s) o on o.organ_code =org.organ_code where gb_code != '320581100000' and 1=1 %3$s) t"
			+ " group by rollup(%1$s) %6$s order by %1$s"
			+ " )";

	public PageList<HmHospitalize> statisticsHospitalize(Criteria criteria,
			Page page) {
		StringBuilder sql = new StringBuilder();
		String dateRange = this.getDateRange(criteria, "CREATE_DATE");
		sql.append("select organ_code,sum(IN_HOS_FEE) IN_HOS_FEE,round(sum(IN_HOS_FEE)/sum(IN_HOSPITAL_NUM),2) avg_fee,sum(IN_HOSPITAL_NUM) IN_HOSPITAL_NUM,sum(LEAVE_HOSPITAL_NUM) LEAVE_HOSPITAL_NUM,sum(INHOSP_OPERATE_NUM) INHOSP_OPERATE_NUM,sum(OUT_HOSP_BED)/sum(LEAVE_HOSPITAL_NUM) OUT_HOSP_BED,sum(CRITICAL_ILL_NUM) CRITICAL_ILL_NUM,round(sum(IN_HOS_MEDICINAL_FEE)/sum(IN_HOS_FEE),2)*100 MEDICINAL_FEE_PER,'");
		sql.append(dateRange
				+ "' PERIOD,round(sum(ANTIBACTERIAL_NUM)/sum(LEAVE_HOSPITAL_NUM),2) ANTIBACTERIAL_RATE  from RP_HM_HOSPITALIZE t ");
		SqlBuilder.buildWhereStatement(HmHospitalize.class, sql, criteria);
		sql.append(" group by organ_code");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public HmHospitalize statisticsHospitalize(Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		String dateRange = this.getDateRange(criteria, "CREATE_DATE");
		sql.append("select round(sum(IN_HOS_FEE)/decode(sum(leave_hospital_num),0,null,sum(leave_hospital_num)),2) avg_fee,sum(IN_HOSPITAL_NUM) IN_HOSPITAL_NUM,sum(INHOSP_OPERATE_NUM) INHOSP_OPERATE_NUM," +
				"sum(OUT_HOSP_BED)/decode(sum(LEAVE_HOSPITAL_NUM),0,null,sum(LEAVE_HOSPITAL_NUM)) OUT_HOSP_BED,sum(CRITICAL_ILL_NUM) CRITICAL_ILL_NUM," +
				"round(sum(IN_HOS_MEDICINAL_FEE)/decode(sum(IN_HOS_FEE),0,null,sum(IN_HOS_FEE)),2)*100 MEDICINAL_FEE_PER,'");
		sql.append(dateRange
				+ "' PERIOD,round(sum(ANTIBACTERIAL_NUM)/decode(sum(LEAVE_HOSPITAL_NUM),0,null,sum(LEAVE_HOSPITAL_NUM)),2) ANTIBACTERIAL_RATE,");
		sql.append(" sum(t.leave_hospital_num) leave_hospital_num ,sum(t.in_hos_fee) in_hos_fee,sum(t.in_hos_medicinal_fee) in_hos_medicinal_fee,");
		sql.append(" sum(t.in_insurance_fee) in_insurance_fee,sum(t.in_personal_fee) in_personal_fee from RP_HM_HOSPITALIZE t ");
		SqlBuilder.buildWhereStatement(HmHospitalize.class, sql, criteria);
		return this.get(sql.toString(), criteria);
	}

	private String getDateRange(Criteria criteria, String col) {
		String dateRageStr = "";
		// Object<?> para = criteria.get(col);
		List<Criterion> list = criteria.getCriteria();
		Criterion criterion = null;
		for (Criterion crt : list) {
			if (col.equals(crt.getName()))
				criterion = crt;
		}
		if (criterion != null) {
			OP operation = criterion.getOperation();
			Date par;
			switch (operation) {
			case BETWEEN:
				Object[] para = (Object[]) criteria.get(col);
				dateRageStr = DateUtil.toDateString((Date) para[0], "yyyy/MM/dd")
						+ "-"
						+ DateUtil.toDateString((Date) para[1], "yyyy/MM/dd");
				break;
			case GE:
				par = (Date) criteria.get(col);
				dateRageStr = DateUtil.toDateString(par, "yyyy/MM/dd") + "-";
				break;
			case LE:
				par = (Date) criteria.get(col);
				dateRageStr = "-" + DateUtil.toDateString(par, "yyyy/MM/dd");
				break;
			}

		}
		return dateRageStr;
	}

	public Boolean deleteHospitalizeData(String start, String end) {
		String sql = "delete RP_HM_HOSPITALIZE t where t.create_date >= to_date('"
				+ start + "','yyyy/MM/dd') and t.create_date <= to_date('"
				+ end + "','yyyy/MM/dd')";
		int rs = this.delete(sql);
		return rs > 0 ? true : false;
	}

    @Override
    public List<Map<String, Object>> getHmHospitalizeMapList(Map<String, String> paramMap) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
        if (ObjectUtil.isNullOrEmpty(paramMap)) {
            return mapList;
        }
        String sql = "";
        Criteria criteria = HmQueryConditionHelper.organizeCriteria(paramMap);
        StringBuilder organizationCondition = HmQueryConditionHelper.getOrganizationCondition(paramMap);
        StringBuilder rpOutpatientBuilder = new StringBuilder();
        SqlBuilder.buildWhereStatement(HmOutpatient.class,rpOutpatientBuilder, criteria);
        String having = "having grouping_id(gb_code,center_code,organ_code)!=3 and grouping_id(gb_code,center_code,organ_code)!=1";
        String genreCode = paramMap.get("genreCode");
        if(StringUtils.equals("0", genreCode)) {
            sql=String.format(HOSPITALIZE_RECORD_STATISTICS_EMP_SQL, "gb_code",rpOutpatientBuilder,organizationCondition,"gb_code","1, '合计'","","");
        } else if(StringUtils.equals(OrgGenreCode.STATION.getValue(), genreCode)){
            sql=String.format(HOSPITALIZE_RECORD_STATISTICS_SQL, "gb_code,center_code,organ_code",rpOutpatientBuilder,organizationCondition,
                    "organ_code","1,'小计', 7, '合计'",having,"gb_code,center_code,");
        } else {
            having = "having grouping_id(gb_code,organ_code)!=1";
            sql=String.format(HOSPITALIZE_RECORD_STATISTICS_SQL, "gb_code,organ_code",rpOutpatientBuilder,organizationCondition,"organ_code","1,'小计', 3, '合计'",having,"gb_code,");
        }

        return getMapList(sql, criteria);
    }
}