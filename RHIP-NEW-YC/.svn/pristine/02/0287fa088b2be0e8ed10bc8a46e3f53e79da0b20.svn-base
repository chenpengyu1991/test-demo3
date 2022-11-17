package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpInhospitalTreatment;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("rpInhospitalTreatmentDao")
public class RpInhospitalTreatmentDaoImpl extends
		AbstractDao<RpInhospitalTreatment, Long> implements
		IRpInhospitalTreatmentDao {
	
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	
	private static final String INHOSPITAL_TREATMENT_RECORD_STATISTICS_SQL = "select rp.diseases_code,"
			+ " sum(NVL(case_num_1, 0))case_num_1,sum(NVL(case_death_num_1, 0))case_death_num_1,"
			+ " decode(sum(NVL(case_num_1,0)),0,0,sum(NVL(fifteen_again_num_1, 0))/sum(NVL(case_num_1,0)))fifteen_rate1,"
			+ " decode(sum(NVL(case_num_1,0)),0,0,sum(NVL(month_again_num_1, 0))/sum(NVL(case_num_1,0)))month_rate1,"
			+ " decode(sum(NVL(case_num_1,0)),0,0,sum(NVL(inhospital_day_1, 0))/sum(NVL(case_num_1,0)))aver_day1,"
			+ " decode(sum(NVL(case_num_1,0)),0,0,sum(NVL(inhospital_fee_1, 0))/sum(NVL(case_num_1,0)))aver_fee1,"
			+ " sum(NVL(case_num_2, 0))case_num_2,sum(NVL(case_death_num_2, 0))case_death_num_2,"
			+ " decode(sum(NVL(case_num_2,0)),0,0,sum(NVL(fifteen_again_num_2, 0))/sum(NVL(case_num_2,0)))fifteen_rate2,"
			+ " decode(sum(NVL(case_num_2,0)),0,0,sum(NVL(month_again_num_2, 0))/sum(NVL(case_num_2,0)))month_rate2,"
			+ " decode(sum(NVL(case_num_2,0)),0,0,sum(NVL(inhospital_day_2, 0))/sum(NVL(case_num_2,0)))aver_day2,"
			+ " decode(sum(NVL(case_num_2,0)),0,0,sum(NVL(inhospital_fee_2, 0))/sum(NVL(case_num_2,0)))aver_fee2,"
			+ " sum(NVL(case_num_3, 0))case_num_3,sum(NVL(case_death_num_3, 0))case_death_num_3,"
			+ " decode(sum(NVL(case_num_3,0)),0,0,sum(NVL(fifteen_again_num_3, 0))/sum(NVL(case_num_3,0)))fifteen_rate3,"
			+ " decode(sum(NVL(case_num_3,0)),0,0,sum(NVL(month_again_num_3, 0))/sum(NVL(case_num_3,0)))month_rate3,"
			+ " decode(sum(NVL(case_num_3,0)),0,0,sum(NVL(inhospital_day_3, 0))/sum(NVL(case_num_3,0)))aver_day3,"
			+ " decode(sum(NVL(case_num_3,0)),0,0,sum(NVL(inhospital_fee_3, 0))/sum(NVL(case_num_3,0)))aver_fee3,"
			+ " sum(NVL(case_num_4, 0))case_num_4,sum(NVL(case_death_num_4, 0))case_death_num_4,"
			+ " decode(sum(NVL(case_num_4,0)),0,0,sum(NVL(fifteen_again_num_4, 0))/sum(NVL(case_num_4,0)))fifteen_rate4,"
			+ " decode(sum(NVL(case_num_4,0)),0,0,sum(NVL(month_again_num_4, 0))/sum(NVL(case_num_4,0)))month_rate4,"
			+ " decode(sum(NVL(case_num_4,0)),0,0,sum(NVL(inhospital_day_4, 0))/sum(NVL(case_num_4,0)))aver_day4,"
			+ " decode(sum(NVL(inhospital_day_4,0)),0,0,sum(NVL(inhospital_fee_4, 0))/sum(NVL(inhospital_day_4,0)))aver_fee4,"
			+ " (sum(NVL(case_num_1, 0))+sum(NVL(case_num_2, 0))+sum(NVL(case_num_3, 0))+sum(NVL(case_num_4, 0)))sum_case_num,"
			+ " (sum(NVL(case_death_num_1, 0))+sum(NVL(case_death_num_2, 0))+sum(NVL(case_death_num_2, 0))+sum(NVL(case_death_num_2, 0)))sum_case_death_num,"
			+ " decode((sum(NVL(case_num_1,0))+sum(NVL(case_num_2,0))+sum(NVL(case_num_3,0))+sum(NVL(case_num_4,0))),0,0,"
			+ " (sum(NVL(fifteen_again_num_1, 0))+sum(NVL(fifteen_again_num_2, 0))+sum(NVL(fifteen_again_num_3, 0))+"
			+ " sum(NVL(fifteen_again_num_4, 0)))/(sum(NVL(case_num_1,0))+sum(NVL(case_num_2,0))+sum(NVL(case_num_3,0))+"
			+ " sum(NVL(case_num_4,0))))sum_fifteen_rate,"
			+ " decode((sum(NVL(case_num_1,0))+sum(NVL(case_num_2,0))+sum(NVL(case_num_3,0))+sum(NVL(case_num_4,0))),0,0,"
			+ " (sum(NVL(month_again_num_1, 0))+sum(NVL(month_again_num_2, 0))+sum(NVL(month_again_num_3, 0))+"
			+ " sum(NVL(month_again_num_4, 0)))/(sum(NVL(case_num_1,0))+sum(NVL(case_num_2,0))+sum(NVL(case_num_3,0))+"
			+ " sum(NVL(case_num_4,0))))sum_month_rate,"
			+ " decode((sum(NVL(case_num_1,0))+sum(NVL(case_num_2,0))+sum(NVL(case_num_3,0))+sum(NVL(case_num_4,0))),0,0,"
			+ " (sum(NVL(inhospital_day_1, 0))+sum(NVL(inhospital_day_2, 0))+sum(NVL(inhospital_day_3, 0))+"
			+ " sum(NVL(inhospital_day_4, 0)))/(sum(NVL(case_num_1,0))+sum(NVL(case_num_2,0))+sum(NVL(case_num_3,0))+"
			+ " sum(NVL(case_num_4,0))))sum_aver_day,"
			+ " decode((sum(NVL(case_num_1,0))+sum(NVL(case_num_2,0))+sum(NVL(case_num_3,0))+sum(NVL(case_num_4,0))),0,0,"
			+ " (sum(NVL(inhospital_fee_1, 0))+sum(NVL(inhospital_fee_2, 0))+sum(NVL(inhospital_fee_3, 0))+"
			+ " sum(NVL(inhospital_fee_4, 0)))/(sum(NVL(case_num_1,0))+sum(NVL(case_num_2,0))+sum(NVL(case_num_3,0))+"
			+ " sum(NVL(case_num_4,0))))sum_aver_fee"
			+ " from rp_inhospital_treatment rp %1$s group by rp.diseases_code ";

	@Override
	public List<Map<String, Object>> getHospitalTreatmentMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		
		String sql =  String.format(INHOSPITAL_TREATMENT_RECORD_STATISTICS_SQL, getConditionSql(paramMap));
		return getMapList(sql, (Criteria) null);
	}
	
	private String getConditionSql(Map<String, String> paramMap) {
		StringBuilder conditionBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(paramMap.get("rpYear"))) {
			conditionBuilder.append(" where rp.rp_year='").append(paramMap.get("rpYear")).append("'");
		}
		if (ObjectUtil.isNotEmpty(paramMap.get("organType")) && !StringUtils.equals(paramMap.get("organType"), "0")) {
			conditionBuilder.append(" and rp.organ_type='").append(paramMap.get("organType")).append("'");
		}

    	if (ObjectUtil.isNotEmpty(paramMap.get("organCode"))) {
    		conditionBuilder.append(" and rp.organ_code='").append(paramMap.get("organCode")).append("'");
		}
    	if (ObjectUtil.isNotEmpty(paramMap.get("gbCode"))) {
    		conditionBuilder.append(" and rp.gb_code='").append(paramMap.get("gbCode")).append("'");
		}
		return conditionBuilder.toString();
	}

}
