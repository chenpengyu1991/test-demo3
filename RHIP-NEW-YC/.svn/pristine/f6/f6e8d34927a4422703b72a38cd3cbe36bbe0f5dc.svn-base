package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.InoculationAppointment;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository("inoculationDao")
public class InoculationDaoImpl extends AbstractDao<InoculationAppointment, Long> implements
		IInoculationDao {

	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	
	private static String STATISTICS_SQL = "select ret2.create_org organ_code,ret1.num1+ret2.num6 yy65,ret1.num2+ret2.num7 yy70"
			+ ", ret1.num3+ret2.num8 yy75,ret1.num4+ret2.num9 yy80,ret1.num5+ret2.num10 yyz,ret2.num6 sz65"
			+ ", ret2.num7 sz70,ret2.num8 sz75,ret2.num9 sz80,ret2.num10 szz"
			+ ", round(ret2.num10/(ret1.num5+ret2.num10),2)*100||'%%'jzl from (select organ_code"
			+ ", sum(case when age>=65 and age<70 then 1 else 0 end)num1" // 65岁-69岁预约接种人数
			+ ", sum(case when age>=70 and age<75 then 1 else 0 end)num2" // 70岁-74岁预约接种人数
			+ ", sum(case when age>=75 and age<80 then 1 else 0 end)num3" // 75岁-79岁预约接种人数
			+ ", sum(case when age>=80 and age<86 then 1 else 0 end)num4" // 80岁-85岁预约接种人数
			+ ", sum(case when age>=65 and age<86 then 1 else 0 end)num5" // 65岁-85岁预约接种人数
			+ " from (select t.organ_code,FLOOR(MONTHS_BETWEEN(t.create_date, p.birthday) / 12) age from DC_INOCULATION_APPOINTMENT t"
			+ " inner join SY_PHB_BI_PERSON_INFO p on t.person_idcard = p.idcard %1$s"
			+ " where not exists (select 1 from dc_vaccination_event e where e.person_id = p.id and e.pneumonia_vacc_flag = '1'))"
			+ " group by organ_code)ret1 right join (select create_org"
			+ ", sum(case when age>=65 and age<70 then 1 else 0 end)num6" // 65岁-69岁实际接种人数
			+ ", sum(case when age>=70 and age<75 then 1 else 0 end)num7" // 70岁-74岁实际接种人数
			+ ", sum(case when age>=75 and age<80 then 1 else 0 end)num8" // 75岁-79岁实际接种人数
			+ ", sum(case when age>=80 and age<86 then 1 else 0 end)num9" // 80岁-85岁实际接种人数
			+ ", sum(case when age>=65 and age<86 then 1 else 0 end)num10" // 65岁-85岁实际接种人数
			+ "  from (select t.create_org"
			+ ", FLOOR(MONTHS_BETWEEN(t.create_date, p.birthday) / 12) age from DC_VACCINATION_EVENT t"
			+ " inner join SY_PHB_BI_PERSON_INFO p on t.person_id = p.id and t.immu_type = '4'"
			+ " and t.pneumonia_vacc_flag = '1' and t.is_delete !=1 %2$s) group by create_org)ret2 on ret1.organ_code=ret2.create_org"
			+ " where (num6 is not null or num7 is not null or num8 is not null or num9 is not null)";

	@Override
	public PageList<InoculationAppointment> getPageListBySql(Page page, String sql, Criteria criteria) {
		return getPageList(page, sql, criteria);
	}

	@Override
	public List<Map<String, Object>> getMapListBySql(String sql,Criteria criteria) {
		return getMapList(sql, criteria);
	}

	@Override
	public List<Map<String, Object>> statisticsVaccinationReport(Criteria criteria) {
		StringBuilder conditionBuilder1 = new StringBuilder();
		StringBuilder conditionBuilder2 = new StringBuilder();
		if (criteria.contains("organCode")) {
			conditionBuilder1.append(" and ORGAN_CODE='").append(criteria.get("organCode")).append("'");
			conditionBuilder2.append(" and CREATE_ORG='").append(criteria.get("organCode")).append("'");
		}
		
		/*if (criteria.contains("createOrg")) {
			conditionBuilder.append(" and CREATE_ORG='").append(criteria.get("createOrg")).append("'");
		}*/
		if (criteria.contains("beginDate") && criteria.contains("endDate")) {
			conditionBuilder1.append(" and to_char(t.CREATE_DATE,'yyyy/MM/dd') >='")
			.append(criteria.get("beginDate"))
			.append("' and to_char(t.CREATE_DATE,'yyyy/MM/dd') <='")
			.append(criteria.get("endDate")).append("'");
			
			conditionBuilder2.append(" and to_char(t.CREATE_DATE,'yyyy/MM/dd') >='")
			.append(criteria.get("beginDate"))
			.append("' and to_char(t.CREATE_DATE,'yyyy/MM/dd') <='")
			.append(criteria.get("endDate")).append("'");
		} else if (criteria.contains("beginDate") && !criteria.contains("endDate")) {
			conditionBuilder1.append(" and to_char(t.CREATE_DATE,'yyyy/MM/dd') >='")
			.append(criteria.get("beginDate")).append("'");
			
			conditionBuilder2.append(" and to_char(t.CREATE_DATE,'yyyy/MM/dd') >='")
			.append(criteria.get("beginDate")).append("'");
		} else if (!criteria.contains("beginDate") && criteria.contains("endDate")) {
			conditionBuilder1.append(" and to_char(t.CREATE_DATE,'yyyy/MM/dd') <='")
			.append(criteria.get("endDate")).append("'");
			
			conditionBuilder2.append(" and to_char(t.CREATE_DATE,'yyyy/MM/dd') <='")
			.append(criteria.get("endDate")).append("'");
		}
		String sql = String.format(STATISTICS_SQL, conditionBuilder1.toString(),conditionBuilder2.toString());
		return getMapList(sql, (Criteria)null);
	}
}
