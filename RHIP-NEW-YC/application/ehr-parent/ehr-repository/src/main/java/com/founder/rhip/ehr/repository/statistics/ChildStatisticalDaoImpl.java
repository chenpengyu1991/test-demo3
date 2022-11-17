package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.dto.ChildStatistical;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Repository("childStatisticalDao")
public class ChildStatisticalDaoImpl extends AbstractDao<ChildStatistical, Long> implements IChildStatisticalDao{
	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	private static final String HEALTH_VIDEO_SQL = "select nvl(SUM(t.REFERRAL_TB_NUM),0)referral_tb_num,nvl(SUM(t.FOLLOW_UP_TUBERCULOSIS),0)follow_up_tuberculosis from SR_TUBERCULOSIS t WHERE 1=1 %1$s";
	// 机构标识
	   private static final String HEALTH_VIDEO_SQL3=" union all select null deliveryNum,null gestationalNumber,null familyVisitNum,null womenChildNum,childExaminationNum,createOrganCode,createDate from(SELECT che1.person_id childExaminationNum,null gestationalNumber,"
				+ "null deliveryNum,"
				+" null familyVisitNum,null womenChildNum,che1.create_organ_code createOrganCode,che1.VISIT_DATE createDate"
				+" FROM CH_CHILD_HEALTH_EXAMINATION che1 WHERE IS_DELETE is null "
				+" and che1.id in (select min(che.id) from CH_CHILD_HEALTH_EXAMINATION che where che.IS_DELETE is null and che.person_id is not null %1$s group by che.person_id)";  
	private static final String HEALTH_VIDEO_SQL1="select nvl2(sum(t.gestationalNumber),sum(t.gestationalNumber),0) deliveryNum,"
			+ "count(t.familyVisitNum) familyVisitNum,count(t.womenChildNum ) womenChildNum,count(t.childExaminationNum) childExaminationNum,t.createOrganCode orgCode"
			+" from (select w.id deliveryNum,nvl2(w.gestational_number,w.gestational_number,0) gestationalNumber,null familyVisitNum,null womenChildNum,null childExaminationNum,w.create_organ_code createOrganCode,w.delivery_date createDate"
			+" from WH_DELIVERY_RECORD_INFO w left join WH_DELIVERY_NEONATAL wd on w.ID_CARD = wd.MOTHER_IDCARD and wd.RECORD_NUMBER = w.RECORD_NUMBER WHERE w.IS_DELETE = 0 and wd.puerpera_Result = '1'"
			+" union all select  null deliveryNum, null gestationalNumber,c.person_id familyVisitNum,"
			+ "null womenChildNum,null childExaminationNum,c.create_organ_code createOrganCode,c.VISIT_DATE createDate FROM CH_NEONATAL_FAMILY_VISIT c WHERE c.IS_DELETE=0"
			+ " and  rowid=( select max(rowid) from CH_NEONATAL_FAMILY_VISIT cn  WHERE cn.IS_DELETE = 0 and c.person_id=cn.person_id)"
			+" union all SELECT null deliveryNum,null gestationalNumber,null familyVisitNum,wch.id womenChildNum,null childExaminationNum,wch.ORG_CODE createOrganCode,wch.create_date createDate FROM WOMEN_CHILD_HEALTH wch WHERE wch.IS_DELETE = '0' AND wch.IDENTITY_TYPE = '1'"
			+" unionflag ) ch ) t WHERE 1=1 %1$s group by t.createOrganCode";
	private static final String HEALTH_VIDEO_SQL2="select nvl2(sum(t.gestationalNumber),sum(t.gestationalNumber),0) deliveryNum,"
			+ "count(t.familyVisitNum) familyVisitNum,count(t.womenChildNum ) womenChildNum,count(t.childExaminationNum) childExaminationNum"
			+" from (select w.id deliveryNum,nvl2(w.gestational_number,w.gestational_number,0) gestationalNumber,null familyVisitNum,null womenChildNum,null childExaminationNum,w.create_organ_code createOrganCode,w.delivery_date createDate"
			+" from WH_DELIVERY_RECORD_INFO w left join WH_DELIVERY_NEONATAL wd on w.ID_CARD = wd.MOTHER_IDCARD and wd.RECORD_NUMBER = w.RECORD_NUMBER WHERE w.IS_DELETE = 0 and wd.puerpera_Result = '1'"
			+" union all select  null deliveryNum, null gestationalNumber,c.person_id familyVisitNum,"
			+ "null womenChildNum,null childExaminationNum,c.create_organ_code createOrganCode,c.VISIT_DATE createDate FROM CH_NEONATAL_FAMILY_VISIT c WHERE c.IS_DELETE=0"
			+ " and  rowid=( select max(rowid) from CH_NEONATAL_FAMILY_VISIT cn  WHERE cn.IS_DELETE = 0 and c.person_id=cn.person_id)"
			+" union all SELECT null deliveryNum,null gestationalNumber,null familyVisitNum,wch.id womenChildNum,null childExaminationNum,wch.ORG_CODE createOrganCode,wch.create_date createDate FROM women_child_health wch WHERE wch.IS_DELETE = '0' AND wch.IDENTITY_TYPE = '1'"
			+" unionflag ) ch ) t WHERE 1=1 %1$s";
          
           
		public static final String ORG_CODE = "orgCode";
		public static final String CENTER_ORG_CODE = "centerOrgCode";
		public static final String GBCODE = "gbcode";
		
		// 时间字段
		public static final String ACTIVE_TIME = "ACTIVE_TIME";
		public static final String RESOURCE_RECORD_TIME = "RESOURCE_RECORD_TIME";
		public static final String USE_TIME = "USE_TIME";
		public static final String ISSUE_TIME = "ISSUE_TIME";
		public static final String CREATE_TIME = "CREATE_TIME";
	
	@Override
	public ChildStatistical getChildStatistical(Criteria criteria) {
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year = (String)criteria.get("year");
		
		Map<String, Object> map = SqlBuilder.buildOrganCondition("che.create_organ_code","che.VISIT_DATE",null,null,orgCode, year,month,null,new MapSqlParameterSource(), 1);
		String finalSql = String.format(HEALTH_VIDEO_SQL3, map.get(SqlBuilder.WHERE));
		
		map = SqlBuilder.buildOrganCondition("t.createOrganCode","t.createDate",null,null,orgCode, year,month,null,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		String finalSql2 = String.format(HEALTH_VIDEO_SQL1, map.get(SqlBuilder.WHERE));
		
		finalSql2=finalSql2.replace(" unionflag ", finalSql);
		return get(ChildStatistical.class, finalSql2, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));
	}

	@Override
	public ChildStatistical getChildStatisticalSum(Criteria criteria, List<String> organCodeList) {
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year = (String)criteria.get("year");
		
		Map<String, Object> map = SqlBuilder.buildOrganCondition("che.create_organ_code","che.VISIT_DATE",null, null,orgCode, year,month,organCodeList, new MapSqlParameterSource(), 1);
		String finalSql = String.format(HEALTH_VIDEO_SQL3, map.get(SqlBuilder.WHERE));
		
		map = SqlBuilder.buildOrganCondition("t.createOrganCode","t.createDate",null, null,orgCode, year,month,organCodeList,(MapSqlParameterSource) map.get(SqlBuilder.SOURCE), 1);
		
		String finalSql2 = String.format(HEALTH_VIDEO_SQL2, map.get(SqlBuilder.WHERE));
		finalSql2=finalSql2.replace("unionflag", finalSql);
		//finalSql=String.format(HEALTH_VIDEO_SQL2, where.toString());
		return get(ChildStatistical.class, finalSql2, (MapSqlParameterSource) map.get(SqlBuilder.SOURCE));
	}

}
