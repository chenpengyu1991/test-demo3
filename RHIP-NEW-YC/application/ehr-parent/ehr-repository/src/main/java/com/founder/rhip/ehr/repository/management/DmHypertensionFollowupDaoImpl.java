package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 高血压随访
 *
 * @author liuk
 */
@Repository("dmHypertensionFollowupDao")
public class DmHypertensionFollowupDaoImpl extends AbstractDao<DmHypertensionFollowup, Long> implements IDmHypertensionFollowupDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<DmHypertensionFollowup> getUnDeList(Criteria criteria) {
		criteria.add(getHmCardDeleteStatus("DM_DISEASE_INFO.", EHRConstants.DM_MANAGED_FLAG));
		StringBuilder sql = new StringBuilder("SELECT DM_HYPERTENSION_FOLLOWUP.* FROM DM_HYPERTENSION_FOLLOWUP LEFT JOIN DM_DISEASE_INFO ON DM_HYPERTENSION_FOLLOWUP.PERSON_ID=DM_DISEASE_INFO.PERSON_ID ");
		SqlBuilder.buildWhereStatement(DmHypertensionFollowup.class, sql, criteria);
		return getList(sql.toString(), criteria);
	}

	@Override
	public DmHypertensionFollowup getLastFollowup(Long personId) {
		String sql = "SELECT A .* FROM (SELECT * FROM DM_HYPERTENSION_FOLLOWUP  WHERE  PERSON_ID=:personId  ORDER BY CREATE_DATE DESC)A WHERE ROWNUM=1 ";
        MapSqlParameterSource parameterSource= new MapSqlParameterSource("personId", personId);
        return get(DmHypertensionFollowup.class, sql, parameterSource);
	}

	/**
	 * 根据随访方式代码统计各个的随访数量
	 * @param criteria
	 * @return
	 */
	@Override
	public Map<String, Object> getNumGroupByVisitWayCode(Criteria criteria) {
		StringBuilder sql = new StringBuilder("select nvl(sum(case when VISIT_WAY_CODE = '1' then 1 else 0 end), 0) mz_num,\n" +
				"    nvl(sum(case when VISIT_WAY_CODE = '2' then 1 else 0 end), 0) sm_num,\n" +
				"    nvl(sum(case when VISIT_WAY_CODE = '3' then 1 else 0 end), 0) dh_num,\n" +
				"    nvl(sum(case when VISIT_WAY_CODE = '4' then 1 else 0 end), 0) jz_num,\n" +
				"    count(*) hj_num from DM_HYPERTENSION_FOLLOWUP");
		SqlBuilder.buildWhereStatement(DmHypertensionFollowup.class, sql, criteria);
		return this.getMap(sql.toString(), criteria);
	}

	private static final String FOLLOWUP_STATISTICS_SQL_ORG = "with followup_plan as(\n" +
			"    select create_organ_code, \n" +
			"    sum(hbp_plan_num) hbp_plan_num,--高血压应随访人数\n" +
			"    sum(di_plan_num)di_plan_num--糖尿病应随访人数\n" +
			"    from (\n" +
			"        select distinct p.person_id,\n" +
			"        d.create_organ_code,\n" +
			"        case when dis_type='1' then 1 else 0 end hbp_plan_num,\n" +
			"        case when dis_type='2' then 1 else 0 end di_plan_num\n" +
			"        from dm_followup_plan p\n" +
			"        left join dm_disease_info d on p.person_id = d.person_id\n" +
			"        where p.dis_type in ('1', '2')\n" +
			"        %8$s and d.status='1'\n" +
			"        %3$s\n" +
			"        and to_char(p.plan_date, 'yyyy/mm/dd') >= '%1$s' and to_char(p.plan_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"    )\n" +
			"    where create_organ_code is not null\n" +
			"    group by create_organ_code\n" +
			"),\n" +
			"hbp_followup as(\n" +
			"    --随访人数 高血压\n" +
			"    select create_organ_code, create_doctor_code,count(distinct person_id)hbp_fllowup_num,count(person_id)hbp_fllowup_times_num  \n" +
			"    from (\n" +
			"        select person_id, create_organ_code, create_doctor_code,id\n" +
			"        from dm_hypertension_followup h\n" +
			"        where person_id is not null and to_char(visit_date, 'yyyy/mm/dd') >= '%1$s' and to_char(visit_date, 'yyyy/mm/dd') <= '%2$s' \n" +
			"        %4$s\n" +
			"    )\n" +
			"    group by create_organ_code, create_doctor_code\n" +
			"),\n" +
			"di_followup as (\n" +
			"    --随访人数 糖尿病\n" +
			"    select create_organ_code, create_doctor_code,count(distinct person_id)di_fllowup_num, count(person_id)di_fllowup_times_num \n" +
			"    from (\n" +
			"        select person_id, create_organ_code, create_doctor_code\n" +
			"        from dm_diabetic_followup h\n" +
			"        where person_id is not null and to_char(visit_date, 'yyyy/mm/dd') >= '%1$s' and to_char(visit_date, 'yyyy/mm/dd') <= '%2$s' \n" +
			"        %4$s\n" +
			"    )\n" +
			"    group by create_organ_code, create_doctor_code\n" +
			"),\n" +
			"followup_result as (\n" +
			"    select \n" +
			"    case when hf.create_organ_code is not null then hf.create_organ_code else df.create_organ_code end create_organ_code,\n" +
			"    case when hf.create_doctor_code is not null then hf.create_doctor_code else df.create_doctor_code end create_doctor_code,\n" +
			"    hbp_fllowup_num,hbp_fllowup_times_num,\n" +
			"    di_fllowup_num,di_fllowup_times_num\n" +
			"    from hbp_followup hf\n" +
			"    full join di_followup df on hf.create_organ_code = df.create_organ_code and hf.create_doctor_code = df.create_doctor_code\n" +
			")\n" +
			"select * from (\n" +
			"select \n" +
			"case when p.create_organ_code is not null then p.create_organ_code else fr.create_organ_code end create_organ_code,\n" +
			"create_doctor_code,\n" +
			"nvl(hbp_plan_num, 0)hbp_plan_num,--高血压应随访人数\n" +
			"nvl(di_plan_num, 0)di_plan_num,--糖尿病应随访人数\n" +
			"nvl(hbp_fllowup_num, 0)hbp_fllowup_num,\n" +
			"nvl(hbp_fllowup_times_num, 0)hbp_fllowup_times_num,\n" +
			"nvl(di_fllowup_num, 0)di_fllowup_num,\n" +
			"nvl(di_fllowup_times_num, 0)di_fllowup_times_num\n" +
			"from followup_plan p\n" +
			"full join followup_result fr on p.create_organ_code = fr.create_organ_code\n" +
			") r\n" +
			"left join mdm_users u on u.user_code = r.create_doctor_code\n" +
			"where 1=1 %5$s %6$s" +
			"order by create_organ_code\n" ;

	private static final String FOLLOWUP_STATISTICS_SQL_VILLAGE = "with followup_plan as(\n" +
			"    select patown_ship, pastreet, \n" +
			"    sum(hbp_plan_num) hbp_plan_num,--高血压应随访人数\n" +
			"    sum(di_plan_num)di_plan_num--糖尿病应随访人数\n" +
			"    from (\n" +
			"        select distinct h.person_id,\n" +
			"        d.create_organ_code,\n" +
			"        info.patown_ship, info.pastreet,\n" +
			"        case when dis_type='1' then 1 else 0 end hbp_plan_num,\n" +
			"        case when dis_type='2' then 1 else 0 end di_plan_num\n" +
			"        from dm_followup_plan h\n" +
			"        left join dm_disease_info d on h.person_id = d.person_id\n" +
			"        left join bi_person_info info on info.id=h.person_id\n" +
			"        where h.dis_type in ('1', '2')\n" +
			"        %8$s and d.status='1'\n" +
			"        %3$s\n" +
			"        and to_char(h.plan_date, 'yyyy/mm/dd') >= '%1$s' and to_char(h.plan_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"    ) h\n" +
			"    where 1=1 %7$s\n" +
			"    group by patown_ship, pastreet\n" +
			"),\n" +
			"hbp_followup as(\n" +
			"    --hbp_fllowup_num 随访人数 hbp_fllowup_times_num随访人次 高血压\n" +
			"    select patown_ship, pastreet,count(distinct person_id)hbp_fllowup_num,count(person_id)hbp_fllowup_times_num\n" +
			"    from (\n" +
			"        select h.person_id, h.create_organ_code, h.create_doctor_code,h.id,\n" +
			"        info.patown_ship, info.pastreet\n" +
			"        from dm_hypertension_followup h\n" +
			"        left join bi_person_info info on info.id=h.person_id\n" +
			"        left join mdm_users u on u.user_code = h.create_doctor_code\n" +
			"        where h.person_id is not null and to_char(visit_date, 'yyyy/mm/dd') >= '%1$s' and to_char(visit_date, 'yyyy/mm/dd') <= '%2$s' \n" +
			"    	 %4$s %6$s  %7$s\n" +
			"    )\n" +
			"    group by patown_ship, pastreet\n" +
			"),\n" +
			"di_followup as (\n" +
			"    --di_fllowup_num随访人数 di_fllowup_times_num随访人次 糖尿病 \n" +
			"    select patown_ship, pastreet,count(distinct person_id)di_fllowup_num, count(person_id)di_fllowup_times_num \n" +
			"    from (\n" +
			"        select h.person_id, h.create_organ_code, h.create_doctor_code,\n" +
			"        info.patown_ship, info.pastreet\n" +
			"        from dm_diabetic_followup h\n" +
			"        left join bi_person_info info on info.id=h.person_id\n" +
			"        left join mdm_users u on u.user_code = h.create_doctor_code\n" +
			"        where person_id is not null and to_char(visit_date, 'yyyy/mm/dd') >= '%1$s' and to_char(visit_date, 'yyyy/mm/dd') <= '%2$s' \n" +
			"    	 %4$s %6$s %7$s\n" +
			"    )\n" +
			"    group by patown_ship, pastreet\n" +
			"),\n" +
			"followup_result as (\n" +
			"    select \n" +
			"    case when hf.patown_ship is not null then hf.patown_ship else df.patown_ship end patown_ship,\n" +
			"    case when hf.pastreet is not null then hf.pastreet else df.pastreet end pastreet,\n" +
			"    hbp_fllowup_num,hbp_fllowup_times_num,\n" +
			"    di_fllowup_num,di_fllowup_times_num\n" +
			"    from hbp_followup hf\n" +
			"    full join di_followup df on hf.patown_ship = df.patown_ship and hf.pastreet = df.pastreet\n" +
			")\n" +
			"select * from (\n" +
			"select \n" +
			"    case when p.patown_ship is not null then p.patown_ship else fr.patown_ship end patown_ship,\n" +
			"    case when p.pastreet is not null then p.pastreet else fr.pastreet end pastreet,\n" +
			"    nvl(hbp_plan_num, 0)hbp_plan_num,--高血压应随访人数\n" +
			"    nvl(di_plan_num, 0)di_plan_num,--糖尿病应随访人数\n" +
			"    nvl(hbp_fllowup_num, 0)hbp_fllowup_num,\n" +
			"    nvl(hbp_fllowup_times_num, 0)hbp_fllowup_times_num,\n" +
			"    nvl(di_fllowup_num, 0)di_fllowup_num,\n" +
			"    nvl(di_fllowup_times_num, 0)di_fllowup_times_num\n" +
			"    from followup_plan p\n" +
			"    full join followup_result fr on p.patown_ship = fr.patown_ship and p.pastreet = fr.pastreet \n" +
			")"+
			"where 1=1 %5$s order by patown_ship,pastreet";

	/**
	 * 随访统计
	 * @param page
	 * @param form
	 * @return
	 */
	@Override
	public PageList<Map<String, Object>> getFollowupStatistics(Page page, ReportQueryForm form, Organization currentOrg) {
		String sql = FOLLOWUP_STATISTICS_SQL_ORG;
		if(ObjectUtil.equals("2", form.getSearchType())) {
			sql = FOLLOWUP_STATISTICS_SQL_VILLAGE;
		}
		String lastSql = this.getLastSql(form, sql, currentOrg);
		PageList<Map<String,Object>> list = this.getPageMapList(page, lastSql, new Criteria());
		return list;
	}

	/**
	 * 根据条件获取最终sql
	 * @param form
	 * @param targetSql
	 * @return
	 */
	private String getLastSql(ReportQueryForm form, String targetSql, Organization currentOrg) {
		String beginStr = form.getBeginDate();
		String endStr = form.getEndDate();
		String orgSql = "";
		String staffSql = "";
		String roleSql = "";

		if (ObjectUtil.isNotEmpty(form.getStationCode())) {//站
			orgSql = " and (create_organ_code = '" + form.getStationCode() + "')";
		} else if (ObjectUtil.isNotEmpty(form.getCentreCode())) {//卫生院
			orgSql = " and (create_organ_code in (select organ_code from mdm_organization " +
					"where organ_code = '" + form.getCentreCode() + "' or parent_code = '" + form.getCentreCode() + "'))";
		}else if (ObjectUtil.isNotEmpty(form.getTownCode())) {//镇
			orgSql = " and (create_organ_code in (select organ_code from mdm_organization " +
					"where gb_code = '" + form.getTownCode() + "'))";
		}
		//应随访人数、随访人数、随访人次数（2018年以后的不包括页面点击新增计划，但2018年以前包含）

		String planTypeSql = "";
		String planTypeFollowupSql = "";
		if(ObjectUtil.isNotEmpty(endStr)) {
			Date searchDate = DateUtil.convert("yyyy", endStr);
			if(searchDate.getYear() > 2018) {
				planTypeSql = "and p.plan_type in('1', '2')";
				planTypeFollowupSql = "and EXISTS(select p.followup_id from DM_FOLLOWUP_PLAN p where p.followup_id = h.id and plan_type in('1', '2'))";
			}
		}

		if (ObjectUtil.isNotEmpty(form.getStaffCode())) {
			staffSql = " and (u.staff_code = '" + form.getStaffCode() + "')";
		}
		if(ObjectUtil.equals("2", form.getSearchType())) {
			//中心 站的用户按照现住址查询时仅可以查询本机构的数据
			if(!ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.JK.getValue())
					&& !ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CITY_HEALTH.getValue())
					&& !ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue())
					) {
				roleSql = orgSql.replace("create_organ_code", "h.create_organ_code");
			}

			if (ObjectUtil.isNotEmpty(form.getPaStreet())) {//居委会
				orgSql = " and (pastreet = '" + form.getPaStreet() + "')";
			}else if (ObjectUtil.isNotEmpty(form.getPatownShip())) {//镇
				orgSql = " and (patown_ship = '" + form.getPatownShip() + "')";
			} else {
				orgSql = "";
			}
		}
		String lastSql = String.format(targetSql, beginStr, endStr, planTypeSql, planTypeFollowupSql, orgSql, staffSql, roleSql,getHmCardDeleteStatusSql("d.", EHRConstants.DM_MANAGED_FLAG));
		return lastSql;
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param alias
	 * @param isDelete
	 * @return
	 */
	private Criteria getHmCardDeleteStatus(String alias, String isDelete) {
		Criteria criteria = new Criteria();
		criteria.add(alias + "hbp_flag", isDelete);
		criteria.add(LOP.OR, alias + "di_flag", isDelete);
		criteria.add(LOP.OR, alias + "stroke_flag", isDelete);
		criteria.add(LOP.OR, alias + "coronary_flag", isDelete);
		criteria.add(LOP.OR, alias + "tumor_flag", isDelete);
		return criteria;
	}

	/**
	 * 管理卡是否撤消的查询条件
	 * @param alias
	 * @param isDelete
	 * @return
	 */
	private String getHmCardDeleteStatusSql(String alias, String isDelete) {
		StringBuffer sqlBuffer = new StringBuffer();
		sqlBuffer.append(" and ( " +alias + "hbp_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "di_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "stroke_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "coronary_flag=" + isDelete);
		sqlBuffer.append(" or " + alias + "tumor_flag=" + isDelete + " )");
		return sqlBuffer.toString();
	}
}
