package com.founder.rhip.ehr.repository.management;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.QueryForm;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * 慢病信息
 * 
 * @author liuk
 */
@Repository("dmDiseaseInfoDao")
public class DmDiseaseInfoDaoImpl extends AbstractDao<DmDiseaseInfo, Long> implements IDmDiseaseInfoDao {

	@SuppressWarnings("unused")
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	private static final String FORMATER_DATE = "yyyy/MM/dd";

	private static final String FOLLOWUP_PLAN_SQL = "with plans as (select person_id, \n" +
			"--max(hbp_flag) hbp_flag,\n " +
			"max(next_Hbp_followup_date) next_Hbp_followup_date,\n" +
			"--max(di_flag) di_flag,\n" +
			" max(next_di_followup_date) next_di_followup_date,\n" +
			"--max(stroke_flag) stroke_flag,\n " +
			"max(next_stroke_followup_date) next_stroke_followup_date,\n" +
			"--max(coronary_flag) coronary_flag,\n " +
			"max(next_coronary_followup_date) next_coronary_followup_date,\n" +
			"--max(tumor_flag) tumor_flag,\n" +
			" max(next_tumor_followup_date) next_tumor_followup_date\n" +
			"from(\n" +
			"  select person_id,\n" +
			"  case when dis_type = '1' then '2' end hbp_flag, \n" +
			"  case when dis_type = '1' then plan_date end next_Hbp_followup_date,\n" +
			"  case when dis_type = '2' then '2' end di_flag, \n" +
			"  case when dis_type = '2' then plan_date end next_di_followup_date,\n" +
			"  case when dis_type = '3' then '2' end stroke_flag, \n" +
			"  case when dis_type = '3' then plan_date end next_stroke_followup_date,\n" +
			"  case when dis_type = '4' then '2' end coronary_flag, \n" +
			"  case when dis_type = '4' then plan_date end next_coronary_followup_date,\n" +
			"  case when dis_type = '5' then '2' end tumor_flag, \n" +
			"  case when dis_type = '5' then plan_date end next_tumor_followup_date\n" +
			"  from (\n" +
			"    select person_id, dis_type, max(plan_date)plan_date  from dm_followup_plan pn\n" +
			"    where followup_id is null\n %1$s \n" +
			"    group by person_id, dis_type\n" +
			"  )\n" +
			")\n" +
			"group by person_id\n" +
			")\n";

	private static final String MANAGER_INRO_SQL_ORG = "with disease as(\n" +
			"        select\n" +
			"        case when d.hbp_create_organ_code is not null then d.hbp_create_organ_code\n" +
			"         when d.di_create_organ_code is not null then d.di_create_organ_code else '' end create_organ_code,\n" +
			"         hbp_create_doctor_code,\n" +
			"        di_create_doctor_code,\n" +
			"        d.hbp_flag,d.hbp_managed_date,d.di_flag,d.di_managed_date,\n" +
			"        info.patown_ship, info.pastreet,\n" +
			"        case when to_char(d.hbp_managed_date, 'yyyy/mm/dd') >= '%1$s'\n" +
			"                  and to_char(d.hbp_managed_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"                  and d.hbp_flag = '2' then 1 else 0 end new_hbp_num,\n" +
			"        case when to_char(d.hbp_managed_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"                  and d.hbp_flag = '2' then 1 else 0 end hbp_num, \n" +
			"        case when to_char(d.di_managed_date, 'yyyy/mm/dd') >= '%1$s'\n" +
			"                  and to_char(d.di_managed_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"                  and d.di_flag = '2' then 1 else 0 end new_di_num,\n" +
			"        case when to_char(d.di_managed_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"                  and d.di_flag = '2' then 1 else 0 end di_num\n" +
			"        from dm_disease_info d\n" +
			"        left join bi_person_info info on info.id=d.person_id\n" +
			"        where (d.hbp_flag='2' or d.di_flag='2')\n" +
			"),\n" +
			"hbp_disease as(\n" +
			"    select create_organ_code, hbp_create_doctor_code,\n" +
			"    sum(new_hbp_num)new_hbp_num,--高血压新增管理人数\n" +
			"    sum(hbp_num)hbp_num--高血压累计管理人数\n" +
			"    from disease \n" +
			"    where hbp_flag='2'\n" +
			"    group by create_organ_code, hbp_create_doctor_code\n" +
			"),\n" +
			"di_disease as(\n" +
			"    select create_organ_code, di_create_doctor_code,\n" +
			"    sum(new_di_num)new_di_num,--糖尿病新增管理人数\n" +
			"    sum(di_num)di_num--糖尿病累计管理人数\n" +
			"    from disease \n" +
			"    where di_flag=2\n" +
			"    group by create_organ_code, di_create_doctor_code\n" +
			")," +
			"result_disease as(\n" +
			"    select \n" +
			"    case when hbp.create_organ_code is not null then hbp.create_organ_code else di.create_organ_code end create_organ_code,\n" +
			"    case when hbp_create_doctor_code is not null then hbp_create_doctor_code else di_create_doctor_code end create_doctor_code,\n" +
			"    nvl(new_hbp_num, 0) new_hbp_num,\n" +
			"    nvl(hbp_num, 0) hbp_num,\n" +
			"    nvl(new_di_num, 0) new_di_num,\n" +
			"    nvl(di_num, 0) di_num\n" +
			"    from hbp_disease hbp\n" +
			"    full join di_disease di on hbp.create_organ_code=di.create_organ_code and hbp_create_doctor_code=di_create_doctor_code\n" +
			")\n" +
			"select d.* from result_disease d\n" +
			"left join mdm_users u on u.user_code = d.create_doctor_code\n" +
			"where 1=1\n%3$s %4$s" +
			"order by create_organ_code,create_doctor_code";

	private static final String 	MANAGER_INRO_SQL_VILLAGE = "with disease as(\n" +
			"\t\tselect\n" +
			"\t\tcase when d.hbp_create_organ_code is not null then d.hbp_create_organ_code\n" +
			"\t\twhen d.di_create_organ_code is not null then d.di_create_organ_code else '' end create_organ_code,\n" +
			"\t\thbp_create_doctor_code,\n" +
			"\t\tdi_create_doctor_code,\n" +
			"\t\td.hbp_flag,d.hbp_managed_date,d.di_flag,d.di_managed_date,\n" +
			"\t\tinfo.patown_ship, info.pastreet,\n" +
			"\t\tcase when to_char(d.hbp_managed_date, 'yyyy/mm/dd') >= '%1$s'\n" +
			"\t\tand to_char(d.hbp_managed_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"\t\tand d.hbp_flag = '2' then 1 else 0 end new_hbp_num,\n" +
			"\t\tcase when to_char(d.hbp_managed_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"\t\tand d.hbp_flag = '2' then 1 else 0 end hbp_num,\n" +
			"\t\tcase when to_char(d.di_managed_date, 'yyyy/mm/dd') >= '%1$s'\n" +
			"\t\tand to_char(d.di_managed_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"\t\tand d.di_flag = '2' then 1 else 0 end new_di_num,\n" +
			"\t\tcase when to_char(d.di_managed_date, 'yyyy/mm/dd') <= '%2$s'\n" +
			"\t\tand d.di_flag = '2' then 1 else 0 end di_num\n" +
			"\t\tfrom dm_disease_info d\n" +
			"\t\tleft join bi_person_info info on info.id=d.person_id\n" +
			"\t\twhere (d.hbp_flag='2' or d.di_flag='2')\n" +
			"),\n" +
			"hbp_disease as(\n" +
			"    select patown_ship, pastreet,\n" +
			"    sum(new_hbp_num)new_hbp_num,--高血压新增管理人数\n" +
			"    sum(hbp_num)hbp_num--高血压累计管理人数\n" +
			"    from disease\n" +
			"    left join mdm_users u on u.user_code = hbp_create_doctor_code\n" +
			"    where hbp_flag='2'\n" +
			"	 %4$s " +
			"    group by patown_ship, pastreet\n" +
			"),\n" +
			"di_disease as(\n" +
			"    select patown_ship, pastreet,\n" +
			"    sum(new_di_num)new_di_num,--糖尿病新增管理人数\n" +
			"    sum(di_num)di_num--糖尿病累计管理人数\n" +
			"    from disease\n" +
			"    left join mdm_users u on u.user_code = di_create_doctor_code\n" +
			"    where di_flag=2\n" +
			"	 %4$s " +
			"    group by patown_ship, pastreet\n" +
			"),\n" +
			"result_disease as(\n" +
			"    select\n" +
			"    case when hbp.patown_ship is not null then hbp.patown_ship else di.patown_ship end patown_ship,\n" +
			"    case when hbp.pastreet is not null then hbp.pastreet else di.pastreet end pastreet,\n" +
			"    nvl(new_hbp_num, 0) new_hbp_num,\n" +
			"    nvl(hbp_num, 0) hbp_num,\n" +
			"    nvl(new_di_num, 0) new_di_num,\n" +
			"    nvl(di_num, 0) di_num\n" +
			"    from hbp_disease hbp\n" +
			"    full join di_disease di on hbp.patown_ship=di.patown_ship and hbp.pastreet=di.pastreet\n" +
			")\n" +
			"select\n" +
			"d.* from result_disease d\n" +
			"where 1=1\n" +
			"%3$s " +
			"order by patown_ship, pastreet";

	private static final String HBP_DI_MANAGER_SQL = "select '月末高血压规范化管理人数'organ_name,\n" +
			"        sum(one_num) one_num, sum(two_num) two_num, sum(three_num) three_num, sum(four_num) four_num, sum(five_num) five_num, \n" +
			"        sum(six_num) six_num, sum(seven_num) seven_num, sum(eight_num) eight_num, sum(nine_num) nine_num,\n" +
			"        sum(ten_num) ten_num, sum(eleven_num) eleven_num, sum(twelve_num) twelve_num\n" +
			"      from (\n" +
			"        select case when HBP_CREATE_DATE <= '%1$s/01' then num else 0 end one_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/02' then num else 0 end two_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/03' then num else 0 end three_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/04' then num else 0 end four_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/05' then num else 0 end five_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/06' then num else 0 end six_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/07' then num else 0 end seven_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/08' then num else 0 end eight_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/09' then num else 0 end nine_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/10' then num else 0 end ten_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/11' then num else 0 end eleven_num,\n" +
			"              case when HBP_CREATE_DATE <= '%1$s/12' then num else 0 end twelve_num \n" +
			"        from (\n" +
			"          select HBP_CREATE_DATE,count(*) num\n" +
			"          from (\n" +
			"            select HBP_CREATE_ORGAN_CODE, to_char(HBP_CREATE_DATE, 'yyyy/mm') HBP_CREATE_DATE from dm_disease_info \n" +
			"            where hbp_flag=2 and to_char(HBP_CREATE_DATE, 'yyyy') <= '%1$s'\n" +
			"                   and HBP_CREATE_ORGAN_CODE in (select organ_code from mdm_organization \n" +
			"                        where (organ_code='SZ586068' or parent_code = 'SZ586068')\n" +
			"					)\n" +
			"            )\n" +
			"          group by HBP_CREATE_DATE\n" +
			"          )\n" +
			"      )\n" +
			"      union all\n" +
			"      select '月末糖尿病规范化管理人数'organ_name,\n" +
			"        sum(one_num) one_num, sum(two_num) two_num, sum(three_num) three_num, sum(four_num) four_num, sum(five_num) five_num, \n" +
			"        sum(six_num) six_num, sum(seven_num) seven_num, sum(eight_num) eight_num, sum(nine_num) nine_num,\n" +
			"        sum(ten_num) ten_num, sum(eleven_num) eleven_num, sum(twelve_num) twelve_num\n" +
			"      from (\n" +
			"        select case when DI_CREATE_DATE <= '%1$s/01' then num else 0 end one_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/02' then num else 0 end two_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/03' then num else 0 end three_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/04' then num else 0 end four_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/05' then num else 0 end five_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/06' then num else 0 end six_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/07' then num else 0 end seven_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/08' then num else 0 end eight_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/09' then num else 0 end nine_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/10' then num else 0 end ten_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/11' then num else 0 end eleven_num,\n" +
			"              case when DI_CREATE_DATE <= '%1$s/12' then num else 0 end twelve_num \n" +
			"        from (\n" +
			"          select DI_CREATE_DATE,count(*) num\n" +
			"          from (\n" +
			"            select to_char(DI_CREATE_DATE, 'yyyy/mm') DI_CREATE_DATE from dm_disease_info \n" +
			"            where di_flag=2 and to_char(DI_CREATE_DATE, 'yyyy') <= '%1$s'\n" +
			"                   and DI_CREATE_ORGAN_CODE in (select organ_code from mdm_organization \n" +
			"                        where (organ_code='SZ586068' or parent_code = 'SZ586068'))\n" +
			"            )\n" +
			"          group by DI_CREATE_DATE\n" +
			"          )\n" +
			"      )";

	private StringBuilder manageCardListSql(Page page, Criteria criteria){
		if (null == criteria) {
			criteria = new Criteria();
		}

		Object hbpManagedFlag=criteria.get("dmDiseaseInfo.HBP_MANAGED_FLAG");
		Object diManagedFlag=criteria.get("dmDiseaseInfo.DI_MANAGED_FLAG");
		Object createCenterOrganCode=criteria.get("dmPersonInfo.CREATE_CENTER_ORGAN_CODE");

		//获取慢病体检(1已体检、2待体检)
        String phyExamSql = null;
        if(ObjectUtil.isNotEmpty(criteria.get("phyExamType"))) {
        	String phyExamType = criteria.get("phyExamType").toString();
            criteria.remove("phyExamType");
            
            phyExamSql = (phyExamType.equals("1")?"":"NOT ")+"EXISTS (SELECT 1 FROM SY_MS_HEALTH_EXAM EX WHERE PHYSICAL_EXAM_TYPE='39' and  EX.PERSON_ID=dmDiseaseInfo.Person_Id ";
            //获取体检年份
            if(ObjectUtil.isNotEmpty(criteria.get("yearDt"))) {
            	String yearDt = criteria.get("yearDt").toString();
                criteria.remove("yearDt");
                phyExamSql += " AND TO_CHAR(EX.EXAMINATION_DATE,'YYYY')='" + yearDt + "'";
            }
            phyExamSql += ")";
        }
        
		//2014年4月3日 14:22:18 liuk
		//修改高血压和糖尿病管理状态条件
		//随访过的为管理,否则为不管理状态

		//构造构造高血压和糖尿病条件,不能共存
		String hbpDiMfCondition=null;
		if (ObjectUtil.isNotEmpty(hbpManagedFlag)){
			criteria.remove("dmDiseaseInfo.HBP_MANAGED_FLAG");
			hbpDiMfCondition=(EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(hbpManagedFlag)?"":"NOT ")+"EXISTS (SELECT 1 FROM DM_HYPERTENSION_FOLLOWUP f WHERE f.person_id=dmDiseaseInfo.PERSON_ID )";
		}

		if (ObjectUtil.isNotEmpty(diManagedFlag)){
			criteria.remove("dmDiseaseInfo.DI_MANAGED_FLAG");
			hbpDiMfCondition=(EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(diManagedFlag)?"":"NOT ")+"EXISTS (SELECT 1 FROM DM_DIABETIC_FOLLOWUP f WHERE f.person_id=dmDiseaseInfo.PERSON_ID )";
		}
		//创建dmPersonInfo的机构和DmDiseaseInfo的机构不一定一样 例如张三在A站报卡 可以在B站创建管理卡
		String centerOrgCodeCondition=null;
		if(criteria.contains("dmPersonInfo.CREATE_CENTER_ORGAN_CODE")) {
			criteria.remove("dmPersonInfo.CREATE_CENTER_ORGAN_CODE");
			centerOrgCodeCondition = " dmDiseaseInfo.CREATE_ORGAN_CODE in (select organ_code from MDM_ORGANIZATION " +
					"where parent_code='" + createCenterOrganCode + "' or organ_code ='" + createCenterOrganCode +"' )";
		}
		criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_MANGE_TYPE);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DMDISEASEINFO.STATUS, DMDISEASEINFO.TUMOR_MANAGED_DATE,DMDISEASEINFO.CORONARY_MANAGED_DATE,DMDISEASEINFO.STROKE_MANAGED_DATE,DMDISEASEINFO.DI_MANAGED_DATE,DMDISEASEINFO.HBP_MANAGED_DATE, DMDISEASEINFO.ID,DMDISEASEINFO.NEXT_HBP_FOLLOWUP_DATE,DMDISEASEINFO.NEXT_DI_FOLLOWUP_DATE,DMDISEASEINFO.NEXT_STROKE_FOLLOWUP_DATE,DMDISEASEINFO.NEXT_CORONARY_FOLLOWUP_DATE,DMDISEASEINFO.NEXT_TUMOR_FOLLOWUP_DATE,DMDISEASEINFO.PERSON_ID, DMDISEASEINFO.CREATE_ORGAN_CODE, DMDISEASEINFO.HBP_FLAG, DMDISEASEINFO.DI_FLAG, DMDISEASEINFO.TUMOR_FLAG, DMDISEASEINFO.CORONARY_FLAG, DMDISEASEINFO.STROKE_FLAG, DMPERSONINFO.IDCARD, DMPERSONINFO.NAME, DMPERSONINFO.GENDER, DMPERSONINFO.BIRTHDAY, DMPERSONINFO.PHONE_NUMBER");
		sql.append(", org.ORGAN_NAME,CASE WHEN hbp_Flag = '2' THEN '高血压 ' END||CASE WHEN di_Flag = '2' THEN '糖尿病 ' END||CASE WHEN tumor_Flag = '2' THEN '肿瘤 ' END||CASE WHEN coronary_Flag = '2' THEN '冠心病 ' END||CASE WHEN coronary_Flag = '2' THEN '脑卒中 ' END diease_name");
		sql.append(" FROM DM_DISEASE_INFO dmDiseaseInfo  INNER JOIN DM_PERSON_INFO dmPersonInfo  ON dmDiseaseInfo.PERSON_ID = dmPersonInfo.PERSON_ID ");
		sql.append(" JOIN MDM_ORGANIZATION org  ON org.organ_code = dmDiseaseInfo.create_Organ_Code ");
		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, sql, criteria);
		//构造高血压和糖尿病条件,根据criteria,一定有where条件直接追加
		if(null!=phyExamSql){
        	sql.append(" AND ").append(phyExamSql);
        }
		if(null!=hbpDiMfCondition){
			sql.append(" AND ").append(hbpDiMfCondition);
		}
		if(null!=centerOrgCodeCondition){
			sql.append(" AND ").append(centerOrgCodeCondition);
		}

		//一期数据迁移时状态有三种管理标识：0 收到，1 纳入管理，2 结束管理 为0的数据在二期中不处理不显示 jianghaiying
		sql.append("  AND (STROKE_MANAGED_FLAG               <> 0 or STROKE_MANAGED_FLAG is null)\n" +
				"    AND (CORONARY_MANAGED_FLAG             <> 0 or CORONARY_MANAGED_FLAG is null)");
		SqlBuilder.buildOrderStatement(sql, "dmDiseaseInfo.UPDATE_DATE  DESC , dmDiseaseInfo.ID  DESC");
		return sql;
	}
	@Override
	public PageList<DmDiseaseInfo> getManageCardList(Page page, Criteria criteria) {
		StringBuilder sql = manageCardListSql(page,criteria);
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public List<Map<String, Object>> exportManageCardList(Page page, Criteria criteria) {
		StringBuilder sql = manageCardListSql(page,criteria);
		PageList<Map<String, Object>> pageList = this.getPageMapList(page, sql.toString(), criteria);
		List<Map<String, Object>> result = null == pageList ? null : pageList.getList();
		return result;
	}

	@Override
	public PageList<DmDiseaseInfo> getManageCardWithFollowupCountList(Page page, Criteria criteria, QueryForm form) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		String disType = form.getDiseaseType();
		if(ObjectUtil.isNotEmpty(disType)){
			int tokenStart=disType.indexOf(",");
			if(tokenStart>0){
				disType=disType.substring(0,tokenStart);
			}
		}
		Date followupStart = form.getFollowupDateStart();
		Date followupEnd = form.getFollowupDateEnd();
		Integer followupCount = form.getFollowupCount();
		String compareType = form.getFollowupCountCompareType();
		String doctorCode = form.getDoctorCode();
		String diseaseType = form.getDiseaseType();
		criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_MANGE_TYPE);
		//获取慢病计划相关的sql
		String planSql = String.format(FOLLOWUP_PLAN_SQL, this.getFollowupPlanWhereSql(form));
		StringBuilder sql = new StringBuilder(planSql + "SELECT * FROM (SELECT ");
		String column = " DMDISEASEINFO.TUMOR_MANAGED_DATE,DMDISEASEINFO.CORONARY_MANAGED_DATE,DMDISEASEINFO.STROKE_MANAGED_DATE,DMDISEASEINFO.DI_MANAGED_DATE,DMDISEASEINFO.HBP_MANAGED_DATE, DMDISEASEINFO.ID," +
				"plans.NEXT_HBP_FOLLOWUP_DATE,plans.NEXT_DI_FOLLOWUP_DATE,plans.NEXT_STROKE_FOLLOWUP_DATE," +
				"plans.NEXT_CORONARY_FOLLOWUP_DATE,plans.NEXT_TUMOR_FOLLOWUP_DATE,DMDISEASEINFO.PERSON_ID," +
				" DMDISEASEINFO.CREATE_ORGAN_CODE, " +
				"dmDiseaseInfo.HBP_FLAG, dmDiseaseInfo.DI_FLAG, dmDiseaseInfo.TUMOR_FLAG, dmDiseaseInfo.CORONARY_FLAG, dmDiseaseInfo.STROKE_FLAG, " +
				"DMPERSONINFO.IDCARD, DMPERSONINFO.NAME, DMPERSONINFO.GENDER, DMPERSONINFO.BIRTHDAY, DMPERSONINFO.PHONE_NUMBER  ";
		String table = " FROM (\n" +
				"  select ID, PERSON_ID,TUMOR_MANAGED_DATE,\n" +
				"    CORONARY_MANAGED_DATE, STROKE_MANAGED_DATE,\n" +
				"    DI_MANAGED_DATE, HBP_MANAGED_DATE," +
				"	 HBP_FLAG, DI_FLAG, TUMOR_FLAG, CORONARY_FLAG, STROKE_FLAG,\n" +
				"    UPDATE_DATE, CREATE_ORGAN_CODE, STATUS         \n" +
				"    from DM_DISEASE_INFO\n" +
				"    ) dmDiseaseInfo  " +
				" INNER JOIN DM_PERSON_INFO dmPersonInfo  ON dmDiseaseInfo.PERSON_ID = dmPersonInfo.PERSON_ID " +
				" left join plans on plans.person_id = dmDiseaseInfo.PERSON_ID";

        //补充条件
        StringBuilder countWhere=null;
		if ((null != followupStart || null != followupEnd || ObjectUtil.isNotEmpty(followupCount) )&& ObjectUtil.isNotEmpty(disType)) {
            countWhere= new StringBuilder(" ");//根据随访次数过滤
            String op;
			if ("1".equals(compareType)) {
				op = "<=";
			} else if ("2".equals(compareType)) {
				op = "=";
			} else {
				op = ">=";
			}
			switch (disType) {
			case EHRConstants.DM_HBP_TYPE:
				if (ObjectUtil.isNotEmpty(followupCount)) {
					countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_HBP,0)").append(op).append(followupCount).append(" ");
				}
				sql.append("NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_HBP,0) FOLLOWUP_COUNT_HBP,").append(column).append(" ");
				sql.append(table);
				sql.append(" LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT_HBP FROM DM_HYPERTENSION_FOLLOWUP WHERE 1=1 ");
				break;
			case EHRConstants.DM_DI_TYPE:
				if (ObjectUtil.isNotEmpty(followupCount)) {
					countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_DI,0)").append(op).append(followupCount).append(" ");
				}
				sql.append("NVL( FOLLOWUPCOUNT.FOLLOWUP_COUNT_DI,0) FOLLOWUP_COUNT_DI ,").append(column).append(" ");
				sql.append(table);
				sql.append(" LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT_DI FROM DM_DIABETIC_FOLLOWUP WHERE 1=1 ");
				break;
			case EHRConstants.DM_CORONARY_TYPE:
				if (ObjectUtil.isNotEmpty(followupCount)) {
					countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_CORONARY,0)").append(op).append(followupCount).append(" ");
				}
				sql.append(" NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_CORONARY,0) FOLLOWUP_COUNT_CORONARY ,").append(column).append(" ");
				sql.append(table);
				sql.append(" LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT_CORONARY FROM DM_STRTUM_FOLLOWUP WHERE 1=1 ");
				sql.append(" AND DISEASE_TYPE=").append(EHRConstants.DM_CORONARY_TYPE);
				break;
			case EHRConstants.DM_STROKE_TYPE:
				if (ObjectUtil.isNotEmpty(followupCount)) {
					countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_STROKE,0)").append(op).append(followupCount).append(" ");
				}
				sql.append(" NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_STROKE,0) FOLLOWUP_COUNT_STROKE ,").append(column).append(" ");
				sql.append(table);
				sql.append("  LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT_STROKE FROM DM_STRTUM_FOLLOWUP WHERE 1=1 ");
				sql.append(" AND DISEASE_TYPE=").append(EHRConstants.DM_STROKE_TYPE);
				break;
			case EHRConstants.DM_TUMOR_TYPE:
				if (ObjectUtil.isNotEmpty(followupCount)) {
					countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_TUMOR,0)").append(op).append(followupCount).append(" ");
				}
				sql.append(" NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT_TUMOR,0) FOLLOWUP_COUNT_TUMOR ,").append(column).append(" ");
				sql.append(table);
				sql.append("  LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT_TUMOR FROM DM_TUMOR_FOLLOWUP WHERE 1=1 ");
			}
			if (null == followupStart && null != followupEnd) {
				sql.append(" AND VISIT_DATE <=to_date('");
				sql.append(DateUtil.toDateString(followupEnd, "yyyy-MM-dd"));
				sql.append(" 23:23:59','yyyy-mm-dd hh24:mi:ss') ");
			} else if (null != followupStart && null == followupEnd) {
				sql.append(" AND VISIT_DATE >=to_date('");
				sql.append(DateUtil.toDateString(followupStart, "yyyy-MM-dd"));
				sql.append(" 00:00:00','yyyy-mm-dd hh24:mi:ss') ");
			} else if (null != followupStart && null != followupEnd) {
				sql.append(" AND VISIT_DATE >=to_date('");
				sql.append(DateUtil.toDateString(followupStart, "yyyy-MM-dd"));
				sql.append(" 00:00:00','yyyy-mm-dd hh24:mi:ss') AND VISIT_DATE <=to_date('");
				sql.append(DateUtil.toDateString(followupEnd, "yyyy-MM-dd"));
				sql.append(" 23:23:59','yyyy-mm-dd hh24:mi:ss') ");
			}

			sql.append(" GROUP BY PERSON_ID ");
			sql.append(")FOLLOWUPCOUNT  ON FOLLOWUPCOUNT.PERSON_ID = dmPersonInfo.PERSON_ID");
		} else {
			sql.append(column);
			sql.append(table);
		}

		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, sql, criteria);
        if(null!=countWhere){
            sql.append(countWhere);
        }
		SqlBuilder.buildOrderStatement(sql, "dmDiseaseInfo.UPDATE_DATE  DESC , dmDiseaseInfo.ID  DESC");
		sql.append(")");
		//查询随访医生
		if(!ObjectUtil.isNullOrEmpty(doctorCode) && ObjectUtil.isNullOrEmpty(diseaseType)) {
			sql.append(" where PERSON_ID in ( ");
			sql.append("  with aa as ( ");
			sql.append("  SELECT id AS FOLLOWUP_ID, 1 as DIS_type FROM DM_HYPERTENSION_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
			sql.append("    UNION ");
			sql.append("  SELECT id AS FOLLOWUP_ID, 2 as DIS_type FROM DM_DIABETIC_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
			sql.append("    UNION ");
			sql.append("  SELECT id AS FOLLOWUP_ID, 3 as DIS_type FROM DM_STRTUM_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("' and disease_type=3 ");
			sql.append("    UNION ");
			sql.append("  SELECT id AS FOLLOWUP_ID, 4 as DIS_type FROM DM_STRTUM_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("' and disease_type=4 ");
			sql.append("    UNION ");
			sql.append("  SELECT id AS FOLLOWUP_ID, 5 as DIS_type FROM DM_TUMOR_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
			sql.append("  ) ");
			sql.append(" select person_id from aa,DM_FOLLOWUP_PLAN where aa.FOLLOWUP_ID=DM_FOLLOWUP_PLAN.FOLLOWUP_ID and aa.dis_type=DM_FOLLOWUP_PLAN.dis_type ");
			sql.append(" ) ");
		}
		if(!ObjectUtil.isNullOrEmpty(doctorCode) && !ObjectUtil.isNullOrEmpty(diseaseType)) {
			sql.append(" where PERSON_ID in ( ");
			sql.append("  with aa as ( ");

			sql.append("  SELECT 0 AS FOLLOWUP_ID, 0 as DIS_type FROM DM_HYPERTENSION_FOLLOWUP WHERE 1!=1");
			if(diseaseType.contains("1")) {
				sql.append("    UNION ");
				sql.append("  SELECT id AS FOLLOWUP_ID, 1 as DIS_type FROM DM_HYPERTENSION_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
			}
			if(diseaseType.contains("2")) {
				sql.append("    UNION ");
				sql.append("  SELECT id AS FOLLOWUP_ID, 2 as DIS_type FROM DM_DIABETIC_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
			}
			if(diseaseType.contains("3")) {
				sql.append("    UNION ");
				sql.append("  SELECT id AS FOLLOWUP_ID, 3 as DIS_type FROM DM_STRTUM_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("' and disease_type=3 ");
			}
			if(diseaseType.contains("4")) {
				sql.append("    UNION ");
				sql.append("  SELECT id AS FOLLOWUP_ID, 4 as DIS_type FROM DM_STRTUM_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("' and disease_type=4 ");
			}
			if(diseaseType.contains("5")) {
				sql.append("    UNION ");
				sql.append("  SELECT id AS FOLLOWUP_ID, 5 as DIS_type FROM DM_TUMOR_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
			}
			sql.append("  ) ");
			sql.append(" select person_id from aa,DM_FOLLOWUP_PLAN where aa.FOLLOWUP_ID=DM_FOLLOWUP_PLAN.FOLLOWUP_ID and aa.dis_type=DM_FOLLOWUP_PLAN.dis_type ");
			sql.append(" ) ");
		}
		return this.getPageList(page, sql.toString(), criteria);
	}

	private StringBuilder getFollowupPlanWhereSql(QueryForm form) {
		StringBuilder followupPlanWhereSql = new StringBuilder("");
		if (ObjectUtil.isNotEmpty(form.getNextFollowupDate())) {
			followupPlanWhereSql.append("and to_char(plan_date, 'yyyy/mm/dd') = '" + DateUtil.toDateString(form.getNextFollowupDate(), FORMATER_DATE) + "'");
		}
		if (ObjectUtil.isNotEmpty(form.getFollowupFlag())) {
			followupPlanWhereSql.append(getFollowupNextDateRangeSql(form));
		}
		if(StringUtil.isNotEmpty(form.getDiseaseType())) {
			followupPlanWhereSql.append("and dis_type in (" + form.getDiseaseType() + ")");
		}
		return followupPlanWhereSql;
	}

	/**
	 *更加待访类型获取下次随访的起始日期
	 * @param form
	 * @return
	 */
	private StringBuilder getFollowupNextDateRangeSql(QueryForm form) {
		Date date = new Date();
		StringBuilder followupPlanWhereSql = new StringBuilder("");

		switch (form.getFollowupFlag()) {
			case EHRConstants.DM_FOLLOWUP_EXPIRE_TODAY:
				followupPlanWhereSql.append(" and to_char(plan_date, 'yyyy/mm/dd') = '" + DateUtil.toDateString(date, FORMATER_DATE) + "'");
				break;
			case EHRConstants.DM_FOLLOWUP_EXPIRE_WEEK:
				followupPlanWhereSql.append(" and to_char(plan_date, 'yyyy/mm/dd') >= '" + DateUtil.toDateString(DateUtil.add(date, Calendar.DAY_OF_MONTH, -7), FORMATER_DATE) + "'");
				followupPlanWhereSql.append(" and to_char(plan_date, 'yyyy/mm/dd') <= '" + DateUtil.toDateString(DateUtil.add(date, Calendar.DAY_OF_MONTH, 7), FORMATER_DATE) + "'");
				break;
			case EHRConstants.DM_FOLLOWUP_EXPIRE_MONTH:
				followupPlanWhereSql.append(" and to_char(plan_date, 'yyyy/mm/dd') >= '" + DateUtil.toDateString(DateUtil.add(date, Calendar.MONTH, -1), FORMATER_DATE) + "'");
				followupPlanWhereSql.append(" and to_char(plan_date, 'yyyy/mm/dd') <= '" + DateUtil.toDateString(DateUtil.add(date, Calendar.MONTH, 1), FORMATER_DATE) + "'");

				break;
			case EHRConstants.DM_FOLLOWUP_EXPIRE_EXPIRED:
				followupPlanWhereSql.append(" and to_char(plan_date, 'yyyy/mm/dd') <= '" + DateUtil.toDateString(DateUtil.add(date, Calendar.MONTH, -1), FORMATER_DATE) + "'");
				break;
			case EHRConstants.DM_FOLLOWUP_NEXT_MONTH_EXPIRED:
				followupPlanWhereSql.append(" and to_char(plan_date, 'yyyy/mm/dd') <= '" + DateUtil.toDateString(DateUtil.add(date, Calendar.MONTH, 1), FORMATER_DATE) + "'");
				break;
		}
		return followupPlanWhereSql;
	}

	@Override
	public List<Map<String, Object>> exportDisAndFollowup(Page page, String disType, Criteria criteria) {
		criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_MANGE_TYPE);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT dmPersonInfo.NAME, dmPersonInfo.GENDER, dmPersonInfo.BIRTHDAY,  dmPersonInfo.IDCARD,dmPersonInfo.PHONE_NUMBER ,dmPersonInfo.HRHOUSE_NUMBER,dmPersonInfo.HRSTREET,dmPersonInfo.HRTOWN_SHIP,dmPersonInfo.PAHOUSE_NUMBER,dmPersonInfo.PASTREET,dmPersonInfo.PATOWN_SHIP,");
		String followupTable = null;
		String selectSql = null;
		switch (disType) {
		case EHRConstants.DM_HBP_TYPE:
			criteria.add("followup.ID", OP.IS, "NOT NULL");
			selectSql = ("followup.VISIT_WAY_CODE, followup.CUR_SYMPTOM, followup.OTHER_SYMPTOM, followup.OTHER_BODY_CHARACTERISTICS, followup.INDEX_OF_BODY_CHARACTERISTICS, followup.TURN_SICKNESS_REASON, followup.HEIGHT, followup.BODY_WEIGHT, followup.HIP, followup.WAOSTLINE, followup.SBP, followup.DBP, followup.HEART_RATE, followup.DAILY_DAILY_SMOKEBER, followup.DAILY_DRINK, followup.TRAINING_MIN, followup.SALT_CLASSIFICATION, followup.MENTALITY, followup.COMPIANCE, followup.AE_RESULT_DESC, followup.MEDICATION_COMPLIANCE, followup.SIDE_EFFECTS, followup.EFFECTS_STATE, followup.VISIT_TYPE, followup.CHINESE_MEDICINE_TYPE, followup.VISIT_DATE, followup.VISIT_ORGAN_CODE, followup.VISIT_ORGAN_NAME, followup.VISIT_IDCARD, followup.VISIT_NAME, followup.CREATE_ORGAN_NAME, followup.CREATE_ORGAN_CODE, followup.CREATE_DOCTOR_NAME, followup.CREATE_DOCTOR_CODE, followup.CREATE_DATE, followup.SIGN_OTHER, followup.TRAIN_FREQUENCY, followup.DRUG_CODE_FIRST, followup.DRUG_NAME_FIRST, followup.DRUG_PERDAY_FIRST, followup.DRUG_PERTIME_FIRST, followup.DRUG_CODE_SECOND, followup.DRUG_NAME_SECOND, followup.DRUG_PERDAY_SECOND, followup.DRUG_PERTIME_SECOND, followup.DRUG_CODE_THIRD, followup.DRUG_NAME_THIRD, followup.DRUG_PERDAY_THIRD, followup.DRUG_PERTIME_THIRD, followup.SALINITY, followup.MEAT_MOUNT, followup.TC, followup.TRIGLYCERIDE_VALUE, followup.LDLC_DETECT_VALUE, followup.HDLC_DETECT_VALUE, followup.REFERRAL_ORGAN_CODE, followup.REFERRAL_REASONS, followup.REFERRAL_DEPARTMENT, followup.NEXT_FOLLOWUP_DAILY_DRINK, followup.SMOKEBER_TARGET, followup.NEXT_FOLLOWUP_BMI, followup.NEXT_FOLLOWUP_BODY_WEIGHT, followup.REFERRAL_HBP_FLAG, followup.MEDICATE_HBP_FLAG, followup.NEXT_EXERCISE_FREQUENCY, followup.NEXT_EXERCISE_TIME, followup.NEXT_SALINITY_TARGET, followup.CUR_SYMPTOM_FLAG, followup.FIRST_MEDICATE_UNIT, followup.SECOND_MEDICATE_UNIT, followup.THIRD_MEDICATE_UNIT ");
			followupTable = "DM_HYPERTENSION_FOLLOWUP";
			break;
		case EHRConstants.DM_DI_TYPE:
			criteria.add("followup.ID", OP.IS, "NOT NULL");
			selectSql = "followup.VISIT_WAY_CODE, followup.INSULIN_USAGE_REMARK,followup.CUR_SYMPTOM, followup.OTHER_SYMPTOM, followup.HEIGHT, followup.BODY_WEIGHT, followup.SBP, followup.DBP, followup.ARTERIOPALMUS, followup.DAILY_SMOKE, followup.DAILY_DRINK, followup.TRAIN_FREQUENCY_TYPE, followup.TRAINING_MIN, followup.DAILY_RICE, followup.MENTALITY, followup.COMPIANCE, followup.FPG, followup.GLU_VALUE, followup.LOW_EFFECTS, followup.HGB, followup.SUB_CHECK, followup.MEDICATION_COMPLIANCE, followup.SIDE_EFFECTS, followup.EFFECTS_STATE, followup.VISIT_TYPE, followup.INSULIN_TYPE, followup.INSULIN_FREQUENCY, followup.INSULIN_DOSE, followup.VISIT_DATE, followup.NEXT_VISIT_DATE, followup.VISIT_ORGAN_CODE, followup.VISIT_ORGAN_NAME, followup.VISIT_IDCARD, followup.VISIT_NAME, followup.CREATE_ORGAN_NAME, followup.CREATE_ORGAN_CODE, followup.CREATE_DOCTOR_NAME, followup.CREATE_DOCTOR_CODE, followup.CREATE_DATE, followup.INDEX_OF_BODY_CHARACTERISTICS, followup.HEART_RATE, followup.SELF_BS_MONITORING, followup.DRUG_REACTION, followup.HYPOGLYCEMIA_REACTION, followup.DI_COMPLICATION, followup.GLU_TWO_HOUR_VALUE, followup.DRUG_CODE_FIRST, followup.DRUG_NAME_FIRST, followup.DRUG_PERDAY_FIRST, followup.DRUG_PERTIME_FIRST, followup.DRUG_CODE_SECOND, followup.DRUG_NAME_SECOND, followup.DRUG_PERDAY_SECOND, followup.DRUG_PERTIME_SECOND, followup.DRUG_CODE_THIRD, followup.DRUG_NAME_THIRD, followup.DRUG_PERDAY_THIRD, followup.DRUG_PERTIME_THIRD, followup.TC, followup.TRIGLYCERIDE_VALUE, followup.LDLC_DETECT_VALUE, followup.HDLC_DETECT_VALUE, followup.SIGN_OTHER, followup.REFERRAL_ORGAN_CODE, followup.REFERRAL_REASONS, followup.REFERRAL_DEPARTMENT, followup.NEXT_FOLLOWUP_DAILY_DRINK, followup.SMOKEBER_TARGET, followup.NEXT_FOLLOWUP_BMI, followup.NEXT_FOLLOWUP_BODY_WEIGHT, followup.REFERRAL_DI_FLAG, followup.MEDICATE_DI_FLAG, followup.NEXT_EXERCISE_FREQUENCY, followup.NEXT_EXERCISE_TIME, followup.STAPLE, followup.CHECK_DATE, followup.OTHER_CHECK, followup.INSULIN_SORT, followup.INSULIN_USAGE, followup.DOSAGE, followup.CUR_SYMPTOM_FLAG, followup.FIRST_MEDICATE_UNIT, followup.SECOND_MEDICATE_UNIT, followup.THIRD_MEDICATE_UNIT, followup.INSULIN_FLAG, followup.INSULIN_DOSAGE_UNIT, followup.PERSON_ID ";
			followupTable = "DM_DIABETIC_FOLLOWUP";
			break;
		case EHRConstants.DM_TUMOR_TYPE:
			criteria.add("followup.ID", OP.IS, "NOT NULL");
			selectSql = "followup.VISIT_WAY_CODE, followup.FIRST_DATE, followup.RECUR_DATE, followup.CUR_STATE, followup.CURE, followup.CURE_PROJECT, followup.OTHER_CURE, followup.THERIOMA_HISTORY_FLAG, followup.OPS, followup.THERIOMA_OPERATION, followup.METASTASIS, followup.METASTASIS_PART, followup.OPS_HOSPITAL, followup.OPS_DATE, followup.CRTESIAN_VALUE, followup.VISIT_DATE, followup.NEXT_VISIT_DATE, followup.VISIT_ORGAN_CODE, followup.VISIT_ORGAN_NAME, followup.VISIT_IDCARD, followup.VISIT_NAME, followup.CREATE_ORGAN_NAME, followup.CREATE_ORGAN_CODE, followup.CREATE_DOCTOR_NAME, followup.CREATE_DOCTOR_CODE, followup.CREATE_DATE, followup.DEATH_PLACE, followup.DEATH_REASON, followup.DEATH_DATE, followup.CANCEL_DATE, followup.GUIDANCE_CONTENT, followup.FOLLOWUP_FLAG, followup.RECUR, followup.RECUR_TIME, followup.CHEMOTHERAPY_HOSPITAL, followup.RADIOTHERAPY_HOSPITAL, followup.THERIOMA_HISTORY_DETAIL, followup.CURRENT_STATUS_FLAG, followup.REMARK, followup.DEFINITION_NEXT_DATE, followup.PERSON_ID ";
			followupTable = "DM_TUMOR_FOLLOWUP";
			break;
		case EHRConstants.DM_STROKE_TYPE:
			criteria.add("followup.DISEASE_TYPE", EHRConstants.DM_STROKE_TYPE);
			selectSql = "followup.PERSON_ID, followup.VISIT_WAY_CODE, followup.POSITIVE_SIGNS, followup.ASSAY, followup.ECG, followup.SPECIAL_EXAM, followup.OTHER_STATUS, followup.SMOKING, followup.DRINKING, followup.MEAT, followup.PRODUCE, followup.PHYSICAL_ACTIVITY, followup.ECG_TIMES, followup.BLOOD_TIMES, followup.DRUG_PAYMENTS, followup.NON_DRUGS, followup.HEDUCATION, followup.CONCLUSION, followup.AFFIRM_PERSON, followup.CONDITION, followup.TREATMENT, followup.FOLLOWUP_FLAG, followup.DISEASE_TYPE, followup.HEIGHT, followup.BODY_WEIGHT, followup.WAOSTLINE, followup.BP_EXAM_FLAG, followup.SBP, followup.DBP, followup.BLOOD_GLUCOSE_FALG, followup.FPG, followup.GLU_VALUE, followup.HGB, followup.BLOOD_FAT, followup.TC, followup.TRIGLYCERIDE_VALUE, followup.LDLC_DETECT_VALUE, followup.HDLC_DETECT_VALUE, followup.BP_DRUG_FLAG, followup.BP_DRUG_CODE_FIRST, followup.BP_DRUG_NAME_FIRST, followup.BP_DRUG_METHOD_FIRST, followup.BP_DRUG_CODE_SECOND, followup.BP_DRUG_NAME_SECOND, followup.BP_DRUG_METHOD_SECOND, followup.BP_DRUG_CODE_THIRD, followup.BP_DRUG_NAME_THIRD, followup.BP_DRUG_METHOD_THIRD, followup.BG_DRUG_FLAG, followup.BG_DRUG_CODE_FIRST, followup.BG_DRUG_NAME_FIRST, followup.BG_DRUG_METHOD_FIRST, followup.BG_DRUG_CODE_SECOND, followup.BG_DRUG_NAME_SECOND, followup.BG_DRUG_METHOD_SECOND, followup.BG_DRUG_CODE_THIRD, followup.BG_DRUG_NAME_THIRD, followup.BG_DRUG_METHOD_THIRD, followup.BF_DRUG_FLAG, followup.BF_DRUG_CODE_FIRST, followup.BF_DRUG_NAME_FIRST, followup.BF_DRUG_METHOD_FIRST, followup.BF_DRUG_CODE_SECOND, followup.BF_DRUG_NAME_SECOND, followup.BF_DRUG_METHOD_SECOND, followup.BF_DRUG_CODE_THIRD, followup.BF_DRUG_NAME_THIRD, followup.BF_DRUG_METHOD_THIRD, followup.VISIT_DATE, followup.NEXT_VISIT_DATE, followup.VISIT_ORGAN_CODE, followup.VISIT_ORGAN_NAME, followup.VISIT_IDCARD, followup.VISIT_NAME, followup.CREATE_ORGAN_NAME, followup.CREATE_ORGAN_CODE, followup.CREATE_DOCTOR_NAME, followup.CREATE_DOCTOR_CODE, followup.CREATE_DATE, followup.BP_DRUG_NO_REGULAR_REASON, followup.BG_DRUG_NO_REGULAR_REASON, followup.BF_DRUG_NO_REGULAR_REASON, followup.NON_DRUGS_OTHER";
			followupTable = "DM_STRTUM_FOLLOWUP";
			break;
		case EHRConstants.DM_CORONARY_TYPE:
			criteria.add("followup.DISEASE_TYPE", EHRConstants.DM_CORONARY_TYPE);
			selectSql = "followup.PERSON_ID, followup.VISIT_WAY_CODE, followup.POSITIVE_SIGNS, followup.ASSAY, followup.ECG, followup.SPECIAL_EXAM, followup.OTHER_STATUS, followup.SMOKING, followup.DRINKING, followup.MEAT, followup.PRODUCE, followup.PHYSICAL_ACTIVITY, followup.ECG_TIMES, followup.BLOOD_TIMES, followup.DRUG_PAYMENTS, followup.NON_DRUGS, followup.HEDUCATION, followup.CONCLUSION, followup.AFFIRM_PERSON, followup.CONDITION, followup.TREATMENT, followup.FOLLOWUP_FLAG, followup.DISEASE_TYPE, followup.HEIGHT, followup.BODY_WEIGHT, followup.WAOSTLINE, followup.BP_EXAM_FLAG, followup.SBP, followup.DBP, followup.BLOOD_GLUCOSE_FALG, followup.FPG, followup.GLU_VALUE, followup.HGB, followup.BLOOD_FAT, followup.TC, followup.TRIGLYCERIDE_VALUE, followup.LDLC_DETECT_VALUE, followup.HDLC_DETECT_VALUE, followup.BP_DRUG_FLAG, followup.BP_DRUG_CODE_FIRST, followup.BP_DRUG_NAME_FIRST, followup.BP_DRUG_METHOD_FIRST, followup.BP_DRUG_CODE_SECOND, followup.BP_DRUG_NAME_SECOND, followup.BP_DRUG_METHOD_SECOND, followup.BP_DRUG_CODE_THIRD, followup.BP_DRUG_NAME_THIRD, followup.BP_DRUG_METHOD_THIRD, followup.BG_DRUG_FLAG, followup.BG_DRUG_CODE_FIRST, followup.BG_DRUG_NAME_FIRST, followup.BG_DRUG_METHOD_FIRST, followup.BG_DRUG_CODE_SECOND, followup.BG_DRUG_NAME_SECOND, followup.BG_DRUG_METHOD_SECOND, followup.BG_DRUG_CODE_THIRD, followup.BG_DRUG_NAME_THIRD, followup.BG_DRUG_METHOD_THIRD, followup.BF_DRUG_FLAG, followup.BF_DRUG_CODE_FIRST, followup.BF_DRUG_NAME_FIRST, followup.BF_DRUG_METHOD_FIRST, followup.BF_DRUG_CODE_SECOND, followup.BF_DRUG_NAME_SECOND, followup.BF_DRUG_METHOD_SECOND, followup.BF_DRUG_CODE_THIRD, followup.BF_DRUG_NAME_THIRD, followup.BF_DRUG_METHOD_THIRD, followup.VISIT_DATE, followup.NEXT_VISIT_DATE, followup.VISIT_ORGAN_CODE, followup.VISIT_ORGAN_NAME, followup.VISIT_IDCARD, followup.VISIT_NAME, followup.CREATE_ORGAN_NAME, followup.CREATE_ORGAN_CODE, followup.CREATE_DOCTOR_NAME, followup.CREATE_DOCTOR_CODE, followup.CREATE_DATE, followup.BP_DRUG_NO_REGULAR_REASON, followup.BG_DRUG_NO_REGULAR_REASON, followup.BF_DRUG_NO_REGULAR_REASON, followup.NON_DRUGS_OTHER";
			followupTable = "DM_STRTUM_FOLLOWUP";
			break;

		default:
			break;
		}
		sql.append(selectSql);
		sql.append(" FROM DM_DISEASE_INFO dmDiseaseInfo   INNER JOIN DM_PERSON_INFO dmPersonInfo  ON dmDiseaseInfo.PERSON_ID = dmPersonInfo.PERSON_ID ");
		sql.append(" LEFT JOIN ").append(followupTable).append(" followup ON followup.PERSON_ID = dmPersonInfo.PERSON_ID ");
		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, "dmDiseaseInfo.UPDATE_DATE  DESC , dmDiseaseInfo.ID  DESC");
		PageList<Map<String, Object>> pageList = this.getPageMapList(page, sql.toString(), criteria);
		List<Map<String, Object>> result = null == pageList ? null : pageList.getList();
		if (null == result) {
			result = Collections.emptyList();
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> exportFollowupPlan(Page page, String disType, Criteria criteria) {
		criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_MANGE_TYPE);
		String plans = "SELECT person_id, dis_type, MAX( to_char(plan_date, 'yyyy/mm/dd'))plan_date  FROM dm_followup_plan pn "  
				     + " WHERE followup_date  IS NULL  AND dis_Type IN ( "+ disType + ") "
		             + " and to_char(plan_date, 'yyyy/mm/dd') >= '"+ criteria.get("beginDate") + "' and to_char(plan_date, 'yyyy/mm/dd') <= '"+ criteria.get("endDate") + "'  GROUP BY person_id, dis_type ";
	    criteria.remove("beginDate");
	    criteria.remove("endDate");
	    StringBuilder baseInfo = new StringBuilder(" SELECT dmDiseaseInfo.PERSON_ID,dmDiseaseInfo.CREATE_ORGAN_CODE,dmDiseaseInfo.IDCARD, NAME, GENDER, BIRTHDAY,PHONE_NUMBER "
	    		+ " FROM dm_Disease_Info dmDiseaseInfo LEFT JOIN DM_PERSON_INFO dmPersonInfo ON dmDiseaseInfo.person_id = dmPersonInfo.person_id ");
		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, baseInfo, criteria);
		
		StringBuilder lastSql = new StringBuilder(" with BASE_INFO as ( " + baseInfo + " ), plans as ( " + plans + " ) " );
		lastSql.append(" select b.*, dis_type disease_Type , plan_date followup_Date, to_date(plan_date, 'yyyy/mm/dd')-to_date(TO_CHAR(sysdate, 'yyyy/mm/dd'), 'yyyy/mm/dd') days  "
				+ " from  plans p inner join  BASE_INFO  b on  b.PERSON_ID = p.PERSON_ID ");
		PageList<Map<String, Object>> pageList = this.getPageMapList(page, lastSql.toString(), criteria);
		List<Map<String, Object>> result = null == pageList ? null : pageList.getList();
		if (null == result) {
			result = Collections.emptyList();
		}
		return result;
	}

	@Override
    public List<Map<String, Object>> exportPersonFollowup(Page page, String disType, QueryForm form, Criteria criteria){
        if (null == criteria) {
            criteria = new Criteria();
        }
        if(ObjectUtil.isNotEmpty(disType)){
            int tokenStart=disType.indexOf(",");
            if(tokenStart>0){
                disType=disType.substring(0,tokenStart);
            }
        }
        Date followupStart = form.getFollowupDateStart();
        Date followupEnd = form.getFollowupDateEnd();
        Integer followupCount = form.getFollowupCount();
        String compareType = form.getFollowupCountCompareType();
        String doctorCode = form.getDoctorCode();
        String diseaseType = form.getDiseaseType();
        criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_MANGE_TYPE);
        //获取慢病计划相关的sql
        String planSql = String.format(FOLLOWUP_PLAN_SQL, this.getFollowupPlanWhereSql(form));
        StringBuilder sql = new StringBuilder(planSql + "SELECT * FROM (SELECT ");
        String column = "DMPERSONINFO.IDCARD, DMPERSONINFO.NAME, DMPERSONINFO.GENDER, DMPERSONINFO.BIRTHDAY, DMPERSONINFO.PHONE_NUMBER, DMPERSONINFO.PERSON_ID  ";
        String table = " FROM (\n" +
                "  select ID, PERSON_ID,TUMOR_MANAGED_DATE,\n" +
                "    CORONARY_MANAGED_DATE, STROKE_MANAGED_DATE,\n" +
                "    DI_MANAGED_DATE, HBP_MANAGED_DATE," +
                "	 HBP_FLAG, DI_FLAG, TUMOR_FLAG, CORONARY_FLAG, STROKE_FLAG,\n" +
                "    UPDATE_DATE, CREATE_ORGAN_CODE, STATUS         \n" +
                "    from DM_DISEASE_INFO\n" +
                "    ) dmDiseaseInfo  " +
                " INNER JOIN DM_PERSON_INFO dmPersonInfo  ON dmDiseaseInfo.PERSON_ID = dmPersonInfo.PERSON_ID " +
                " left join plans on plans.person_id = dmDiseaseInfo.PERSON_ID";

        //补充条件
        StringBuilder countWhere=null;
        if ((null != followupStart || null != followupEnd || ObjectUtil.isNotEmpty(followupCount) )&& ObjectUtil.isNotEmpty(disType)) {
            countWhere= new StringBuilder(" ");//根据随访次数过滤
            String op;
            if ("1".equals(compareType)) {
                op = "<=";
            } else if ("2".equals(compareType)) {
                op = "=";
            } else {
                op = ">=";
            }
            switch (disType) {
                case EHRConstants.DM_HBP_TYPE:
                    if (ObjectUtil.isNotEmpty(followupCount)) {
                        countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT,0)").append(op).append(followupCount).append(" ");
                    }
                    sql.append("NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT,0) FOLLOWUP_COUNT,").append(column).append(" ");
                    sql.append(table);
                    sql.append(" LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT FROM DM_HYPERTENSION_FOLLOWUP WHERE 1=1 ");
                    break;
                case EHRConstants.DM_DI_TYPE:
                    if (ObjectUtil.isNotEmpty(followupCount)) {
                        countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT,0)").append(op).append(followupCount).append(" ");
                    }
                    sql.append("NVL( FOLLOWUPCOUNT.FOLLOWUP_COUNT,0) FOLLOWUP_COUNT ,").append(column).append(" ");
                    sql.append(table);
                    sql.append(" LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT FROM DM_DIABETIC_FOLLOWUP WHERE 1=1 ");
                    break;
                case EHRConstants.DM_CORONARY_TYPE:
                    if (ObjectUtil.isNotEmpty(followupCount)) {
                        countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT,0)").append(op).append(followupCount).append(" ");
                    }
                    sql.append(" NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT,0) FOLLOWUP_COUNT ,").append(column).append(" ");
                    sql.append(table);
                    sql.append(" LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT FROM DM_STRTUM_FOLLOWUP WHERE 1=1 ");
                    sql.append(" AND DISEASE_TYPE=").append(EHRConstants.DM_CORONARY_TYPE);
                    break;
                case EHRConstants.DM_STROKE_TYPE:
                    if (ObjectUtil.isNotEmpty(followupCount)) {
                        countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT,0)").append(op).append(followupCount).append(" ");
                    }
                    sql.append(" NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT,0) FOLLOWUP_COUNT ,").append(column).append(" ");
                    sql.append(table);
                    sql.append("  LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT FROM DM_STRTUM_FOLLOWUP WHERE 1=1 ");
                    sql.append(" AND DISEASE_TYPE=").append(EHRConstants.DM_STROKE_TYPE);
                    break;
                case EHRConstants.DM_TUMOR_TYPE:
                    if (ObjectUtil.isNotEmpty(followupCount)) {
                        countWhere.append("AND NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT,0)").append(op).append(followupCount).append(" ");
                    }
                    sql.append(" NVL(FOLLOWUPCOUNT.FOLLOWUP_COUNT,0) FOLLOWUP_COUNT ,").append(column).append(" ");
                    sql.append(table);
                    sql.append("  LEFT JOIN(SELECT PERSON_ID,COUNT(1) FOLLOWUP_COUNT FROM DM_TUMOR_FOLLOWUP WHERE 1=1 ");
            }
            if (null == followupStart && null != followupEnd) {
                sql.append(" AND VISIT_DATE <=to_date('");
                sql.append(DateUtil.toDateString(followupEnd, "yyyy-MM-dd"));
                sql.append(" 23:23:59','yyyy-mm-dd hh24:mi:ss') ");
            } else if (null != followupStart && null == followupEnd) {
                sql.append(" AND VISIT_DATE >=to_date('");
                sql.append(DateUtil.toDateString(followupStart, "yyyy-MM-dd"));
                sql.append(" 00:00:00','yyyy-mm-dd hh24:mi:ss') ");
            } else if (null != followupStart && null != followupEnd) {
                sql.append(" AND VISIT_DATE >=to_date('");
                sql.append(DateUtil.toDateString(followupStart, "yyyy-MM-dd"));
                sql.append(" 00:00:00','yyyy-mm-dd hh24:mi:ss') AND VISIT_DATE <=to_date('");
                sql.append(DateUtil.toDateString(followupEnd, "yyyy-MM-dd"));
                sql.append(" 23:23:59','yyyy-mm-dd hh24:mi:ss') ");
            }

            sql.append(" GROUP BY PERSON_ID ");
            sql.append(")FOLLOWUPCOUNT  ON FOLLOWUPCOUNT.PERSON_ID = dmPersonInfo.PERSON_ID");
        } else {
            sql.append(column);
            sql.append(table);
        }

        SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, sql, criteria);
        if(null!=countWhere){
            sql.append(countWhere);
        }
        SqlBuilder.buildOrderStatement(sql, "dmDiseaseInfo.UPDATE_DATE  DESC , dmDiseaseInfo.ID  DESC");
        sql.append(")");
        //查询随访医生
        if(!ObjectUtil.isNullOrEmpty(doctorCode) && ObjectUtil.isNullOrEmpty(diseaseType)) {
            sql.append(" where PERSON_ID in ( ");
            sql.append("  with aa as ( ");
            sql.append("  SELECT id AS FOLLOWUP_ID, 1 as DIS_type FROM DM_HYPERTENSION_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
            sql.append("    UNION ");
            sql.append("  SELECT id AS FOLLOWUP_ID, 2 as DIS_type FROM DM_DIABETIC_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
            sql.append("    UNION ");
            sql.append("  SELECT id AS FOLLOWUP_ID, 3 as DIS_type FROM DM_STRTUM_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("' and disease_type=3 ");
            sql.append("    UNION ");
            sql.append("  SELECT id AS FOLLOWUP_ID, 4 as DIS_type FROM DM_STRTUM_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("' and disease_type=4 ");
            sql.append("    UNION ");
            sql.append("  SELECT id AS FOLLOWUP_ID, 5 as DIS_type FROM DM_TUMOR_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
            sql.append("  ) ");
            sql.append(" select person_id from aa,DM_FOLLOWUP_PLAN where aa.FOLLOWUP_ID=DM_FOLLOWUP_PLAN.FOLLOWUP_ID and aa.dis_type=DM_FOLLOWUP_PLAN.dis_type ");
            sql.append(" ) ");
        }
        if(!ObjectUtil.isNullOrEmpty(doctorCode) && !ObjectUtil.isNullOrEmpty(diseaseType)) {
            sql.append(" where PERSON_ID in ( ");
            sql.append("  with aa as ( ");

            sql.append("  SELECT 0 AS FOLLOWUP_ID, 0 as DIS_type FROM DM_HYPERTENSION_FOLLOWUP WHERE 1!=1");
            if(diseaseType.contains("1")) {
                sql.append("    UNION ");
                sql.append("  SELECT id AS FOLLOWUP_ID, 1 as DIS_type FROM DM_HYPERTENSION_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
            }
            if(diseaseType.contains("2")) {
                sql.append("    UNION ");
                sql.append("  SELECT id AS FOLLOWUP_ID, 2 as DIS_type FROM DM_DIABETIC_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
            }
            if(diseaseType.contains("3")) {
                sql.append("    UNION ");
                sql.append("  SELECT id AS FOLLOWUP_ID, 3 as DIS_type FROM DM_STRTUM_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("' and disease_type=3 ");
            }
            if(diseaseType.contains("4")) {
                sql.append("    UNION ");
                sql.append("  SELECT id AS FOLLOWUP_ID, 4 as DIS_type FROM DM_STRTUM_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("' and disease_type=4 ");
            }
            if(diseaseType.contains("5")) {
                sql.append("    UNION ");
                sql.append("  SELECT id AS FOLLOWUP_ID, 5 as DIS_type FROM DM_TUMOR_FOLLOWUP WHERE CREATE_DOCTOR_CODE = '").append(doctorCode).append("' or CREATE_DOCTOR_NAME = '").append(doctorCode).append("'");
            }
            sql.append("  ) ");
            sql.append(" select person_id from aa,DM_FOLLOWUP_PLAN where aa.FOLLOWUP_ID=DM_FOLLOWUP_PLAN.FOLLOWUP_ID and aa.dis_type=DM_FOLLOWUP_PLAN.dis_type ");
            sql.append(" ) ");
        }
        PageList<Map<String, Object>> pageList =  this.getPageMapList(page, sql.toString(), criteria);
        List<Map<String, Object>> result = null == pageList ? null : pageList.getList();
        if (null == result) {
            result = Collections.emptyList();
        }
        return result;
    }

	@Override
	public Long getManageCardCount(Criteria criteria, String orgCodeList) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		criteria.add("pn.followup_id", OP.IS, "NULL");
		//criteria.add("pn.IS_DELETE", EHRConstants.DELETE_FLG_0);
		StringBuilder sql = new StringBuilder();
		sql.append("select count(distinct pn.person_id) from dm_followup_plan pn\n" +
				"    inner join DM_DISEASE_INFO DMDISEASEINFO on DMDISEASEINFO.person_id = pn.person_id " +
				" INNER JOIN DM_PERSON_INFO dmPersonInfo ON DMDISEASEINFO.PERSON_ID = dmPersonInfo.PERSON_ID");
		sql.append(" WHERE ((dmDiseaseInfo.hbp_Flag='2' and dis_type='1'\n" +
				"    %1$s) \n" +
				"    or (dmDiseaseInfo.di_Flag='2' and dis_type='2'\n" +
				"    %1$s) \n" +
				"    or (dmDiseaseInfo.stroke_Flag='2' and dis_type='3'\n" +
				"    %1$s) \n" +
				"   or  (dmDiseaseInfo.coronary_Flag='2' and dis_type='4'\n" +
				"    %1$s) \n" +
				"   or  (dmDiseaseInfo.tumor_Flag='2' and dis_type='5'\n" +
				"    %1$s))");
		StringBuilder dateSql = new StringBuilder();
		if(criteria.contains("beginDate")) {
			String beginStr = DateUtil.toFormatString("yyyy/MM/dd", (Date)criteria.get("beginDate"));
			dateSql.append(" and to_char(plan_date, 'yyyy/mm/dd') >= '"+ beginStr + "'");
			criteria.remove("beginDate");
		}
		if(criteria.contains("endDate")) {
			String endStr = DateUtil.toFormatString("yyyy/MM/dd", (Date)criteria.get("endDate"));
			dateSql.append(" and to_char(plan_date, 'yyyy/mm/dd') <= '"+ endStr + "'");
			criteria.remove("endDate");
		}
		if(ObjectUtil.isNotEmpty(orgCodeList)){
			sql.append(" and dmPersonInfo.CREATE_CENTER_ORGAN_CODE='"+orgCodeList+ "' ");
		}
		
		if(ObjectUtil.isNotEmpty(criteria)) {
			sql.append(" and");
			sql.append(criteria.toSql(ClassMetadata.getMetadata(DmDiseaseInfo.class), ":"));

		}
		String lastSql = String.format(sql.toString(), dateSql);
		Long count = getSingle(lastSql, criteria, Long.class);
		return count;
	}

	@Override
	public Long getPersonIdCount(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select count(distinct(d.person_id)) from DM_DISEASE_INFO d");
		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, sb, criteria);
		Long count = this.getSingle(sb.toString(), criteria, Long.class);
		return count;
	}

	@Override
	public void updateOrganByVillage(String orgCode, String[] newAddVillageCodes) {
		String sql = "UPDATE DM_DISEASE_INFO SET  DM_DISEASE_INFO.CREATE_ORGAN_CODE = :orgCode WHERE EXISTS ( SELECT 1 FROM DM_PERSON_INFO WHERE DM_DISEASE_INFO.PERSON_ID = DM_PERSON_INFO.PERSON_ID AND DM_PERSON_INFO. TYPE =:type AND DM_PERSON_INFO.PASTREET IN (:villages))";
		String historySql = "INSERT INTO DM_DISEASE_INFO_RH(ID,CREATE_ORGAN_CODE,RECORD_CHANGE_TIME) SELECT DM_DISEASE_INFO.ID, DM_DISEASE_INFO.CREATE_ORGAN_CODE,to_date('" + DateUtil.toDateString(new Date(), "yyyy-MM-dd HH:mm:ss")
				+ "','yyyy-mm-dd hh24:mi:ss') FROM DM_DISEASE_INFO, DM_PERSON_INFO  WHERE DM_DISEASE_INFO.PERSON_ID = DM_PERSON_INFO.PERSON_ID AND DM_PERSON_INFO. TYPE =:type AND DM_PERSON_INFO.PASTREET IN (:villages)";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource("type", EHRConstants.DM_PERSON_MANGE_TYPE);
		parameterSource.addValue("villages", Arrays.asList(newAddVillageCodes));
		parameterSource.addValue("orgCode", orgCode);
		simpleJdbcTemplate.update(historySql, parameterSource);
		simpleJdbcTemplate.update(sql, parameterSource);
	}

	public List<Map<String, Object>> exportManageCard(Page page, Criteria criteria) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		Object hbpManagedFlag = criteria.get("dmDiseaseInfo.HBP_MANAGED_FLAG");
		Object diManagedFlag = criteria.get("dmDiseaseInfo.DI_MANAGED_FLAG");
		Object createCenterOrganCode=criteria.get("dmPersonInfo.CREATE_CENTER_ORGAN_CODE");

		//2014年4月3日 14:22:18 liuk
		//修改高血压和糖尿病管理状态条件
		//随访过的为管理,否则为不管理状态

		//构造构造高血压和糖尿病条件,不能共存
		String hbpDiMfCondition = null;
		if (ObjectUtil.isNotEmpty(hbpManagedFlag)) {
			criteria.remove("dmDiseaseInfo.HBP_MANAGED_FLAG");
			hbpDiMfCondition = (EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(hbpManagedFlag) ? "" : "NOT ") + "EXISTS (SELECT 1 FROM DM_HYPERTENSION_FOLLOWUP f WHERE f.person_id=dmDiseaseInfo.PERSON_ID )";
		}

		if (ObjectUtil.isNotEmpty(diManagedFlag)) {
			criteria.remove("dmDiseaseInfo.DI_MANAGED_FLAG");
			hbpDiMfCondition = (EHRConstants.DM_SC_MANAGED_FLAG_YES.equals(diManagedFlag) ? "" : "NOT ") + "EXISTS (SELECT 1 FROM DM_DIABETIC_FOLLOWUP f WHERE f.person_id=dmDiseaseInfo.PERSON_ID )";
		}

		//创建dmPersonInfo的机构和DmDiseaseInfo的机构不一定一样 例如张三在A站报卡 可以在B站创建管理卡
		String centerOrgCodeCondition=null;
		if(criteria.contains("dmPersonInfo.CREATE_CENTER_ORGAN_CODE")) {
			criteria.remove("dmPersonInfo.CREATE_CENTER_ORGAN_CODE");
			centerOrgCodeCondition = " dmDiseaseInfo.CREATE_ORGAN_CODE in (select organ_code from mdm_organization " +
					"where parent_code='" + createCenterOrganCode + "' or organ_code ='" + createCenterOrganCode +"' )";
		}

		criteria.add("biPersonInfo.TYPE", EHRConstants.DM_PERSON_MANGE_TYPE);
		StringBuilder sql = new StringBuilder();
		sql.append(" select dmDiseaseInfo.*,DMPERSONINFO.NAME, DMPERSONINFO.GENDER, DMPERSONINFO.BIRTHDAY, DMPERSONINFO.PHONE_NUMBER,DMPERSONINFO.UNIT_NAME,");
		sql.append(" DMPERSONINFO.nation,DMPERSONINFO.EDUCATION, DMPERSONINFO.patown_Ship , DMPERSONINFO.pastreet, DMPERSONINFO.pahouse_Number,DMPERSONINFO.PA_GROUP");
		sql.append(" from v_dm_export_manage_card dmDiseaseInfo");
		sql.append(" INNER JOIN BI_PERSON_INFO dmPersonInfo  ON dmDiseaseInfo.PERSON_ID = dmPersonInfo.ID");
		sql.append(" INNER JOIN DM_PERSON_INFO biPersonInfo  ON dmDiseaseInfo.PERSON_ID = biPersonInfo.PERSON_ID");
		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, sql, criteria);
		//构造高血压和糖尿病条件,根据criteria,一定有where条件直接追加
		if (null != hbpDiMfCondition) {
			sql.append(" AND ").append(hbpDiMfCondition);
		}
		if(null!=centerOrgCodeCondition){
			sql.append(" AND ").append(centerOrgCodeCondition);
		}
		SqlBuilder.buildOrderStatement(sql, "dmDiseaseInfo.UPDATE_DATE  DESC , dmDiseaseInfo.ID  DESC");
		PageList<Map<String, Object>> pageList = this.getPageMapList(page, sql.toString(), criteria);
		List<Map<String, Object>> result = null == pageList ? null : pageList.getList();
		return result;
	}

	/**
	 * 统计五种慢病已管理的数量
	 * @param criteria
	 * @return
	 */
	public Map<String, Object> getMangerNum(Criteria criteria) {
		StringBuilder sqlBuilder = new StringBuilder("select\n" +
				"      nvl(sum(case when HBP_FLAG='2' and EXISTS (SELECT 1 FROM DM_HYPERTENSION_FOLLOWUP f WHERE f.person_id=dmDiseaseInfo.PERSON_ID) then 1 else 0 end), 0) HBP_NUM,--高血压\n" +
				"      nvl(sum(case when DI_FLAG='2' and EXISTS (SELECT 1 FROM DM_DIABETIC_FOLLOWUP f WHERE f.person_id=dmDiseaseInfo.PERSON_ID) then 1 else 0 end), 0) DI_NUM,--糖尿病\n" +
				"      nvl(sum(case when TUMOR_FLAG='2' and dmDiseaseInfo.TUMOR_MANAGED_FLAG='1' then 1 else 0 end), 0) TUMOR_NUM,--肿瘤\n" +
				"      nvl(sum(case when CORONARY_FLAG='2' and dmDiseaseInfo.CORONARY_MANAGED_FLAG='1' then 1 else 0 end), 0) CORONARY_NUM,--冠心病\n" +
				"      nvl(sum(case when STROKE_FLAG='2' and dmDiseaseInfo.STROKE_MANAGED_FLAG='1' then 1 else 0 end), 0) STROKE_NUM --脑卒中\n" +
				"       FROM DM_DISEASE_INFO dmDiseaseInfo\n" +
				"    INNER JOIN DM_PERSON_INFO dmPersonInfo\n" +
				"        ON dmDiseaseInfo.PERSON_ID          = dmPersonInfo.PERSON_ID\n");

		criteria.add("dmPersonInfo.TYPE", EHRConstants.DM_PERSON_MANGE_TYPE);
		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, sqlBuilder, criteria);
		//一期数据迁移时状态有三种管理标识：0 收到，1 纳入管理，2 结束管理 为0的数据在二期中不处理不显示 jianghaiying
		sqlBuilder.append("  AND (STROKE_MANAGED_FLAG  <> 0 or STROKE_MANAGED_FLAG is null)\n" +
				"    AND (CORONARY_MANAGED_FLAG <> 0 or CORONARY_MANAGED_FLAG is null)");
		return this.getMap(sqlBuilder.toString(), criteria);
	}

	/**
	 *  统计不同时间段每种慢病的纳入管理的情况
	 * @param dateType
	 * @return
	 */
	@Override
	public Map<String, Object> getBringNum(int dateType, Organization organization, RoleType roleType) {
		StringBuilder sql = new StringBuilder("select\n" +
				"      sum(case when HBP_FLAG='2' %1$s then 1 else 0 end) HBP_NUM,--高血压\n" +
				"      sum(case when DI_FLAG='2' %2$s then 1 else 0 end) DI_NUM,--糖尿病\n" +
				"      sum(case when TUMOR_FLAG='2' %3$s then 1 else 0 end) TUMOR_NUM,--肿瘤\n" +
				"      sum(case when CORONARY_FLAG='2' %4$s then 1 else 0 end) CORONARY_NUM,--冠心病\n" +
				"      sum(case when STROKE_FLAG='2' %5$s then 1 else 0 end) STROKE_NUM --脑卒中\n" +
				"       FROM DM_DISEASE_INFO dmDiseaseInfo\n" +
				"    INNER JOIN DM_PERSON_INFO dmPersonInfo\n" +
				"        ON dmDiseaseInfo.PERSON_ID          = dmPersonInfo.PERSON_ID\n" +
				"    where  dmDiseaseInfo.STATUS            ='1'\n" +
				"    AND dmPersonInfo.TYPE               ='2'\n" +
				"    AND (STROKE_MANAGED_FLAG           <> 0\n" +
				"    OR STROKE_MANAGED_FLAG             IS NULL)\n" +
				"    AND (CORONARY_MANAGED_FLAG         <> 0\n" +
				"    OR CORONARY_MANAGED_FLAG           IS NULL)");
		String hbpDate = "";
		String diDate = "";
		String tumorDate = "";
		String coronaryDate = "";
		String strokeDate = "";
		if (dateType == 1) {//今日
			hbpDate = "and to_char(HBP_MANAGED_DATE, 'yyyy/mm/dd') = '" + DateUtil.toFormatString("yyyy/MM/dd", new Date()) + "'";
			diDate = "and to_char(DI_MANAGED_DATE, 'yyyy/mm/dd') = '" + DateUtil.toFormatString("yyyy/MM/dd", new Date()) + "'";
			tumorDate = "and to_char(TUMOR_MANAGED_DATE, 'yyyy/mm/dd') = '" + DateUtil.toFormatString("yyyy/MM/dd", new Date()) + "'";
			coronaryDate = "and to_char(CORONARY_MANAGED_DATE, 'yyyy/mm/dd') = '" + DateUtil.toFormatString("yyyy/MM/dd", new Date()) + "'";
			strokeDate = "and to_char(STROKE_MANAGED_DATE, 'yyyy/mm/dd') = '" + DateUtil.toFormatString("yyyy/MM/dd", new Date()) + "'";
		} else if (dateType == 2) { //本月
			hbpDate = "and to_char(HBP_MANAGED_DATE, 'yyyy/mm') = '" + DateUtil.toFormatString("yyyy/MM", new Date()) + "'";
			diDate = "and to_char(DI_MANAGED_DATE, 'yyyy/mm') = '" + DateUtil.toFormatString("yyyy/MM", new Date()) + "'";
			tumorDate = "and to_char(TUMOR_MANAGED_DATE, 'yyyy/mm') = '" + DateUtil.toFormatString("yyyy/MM", new Date()) + "'";
			coronaryDate = "and to_char(CORONARY_MANAGED_DATE, 'yyyy/mm') = '" + DateUtil.toFormatString("yyyy/MM", new Date()) + "'";
			strokeDate = "and to_char(STROKE_MANAGED_DATE, 'yyyy/mm') = '" + DateUtil.toFormatString("yyyy/MM", new Date()) + "'";
		} else if (dateType == 3) { //本年
			hbpDate = "and to_char(HBP_MANAGED_DATE, 'yyyy') = '" + DateUtil.getCurrentYear() + "'";
			diDate = "and to_char(DI_MANAGED_DATE, 'yyyy') = '" + DateUtil.getCurrentYear() + "'";
			tumorDate = "and to_char(TUMOR_MANAGED_DATE, 'yyyy') = '" + DateUtil.getCurrentYear() + "'";
			coronaryDate = "and to_char(CORONARY_MANAGED_DATE, 'yyyy') = '" + DateUtil.getCurrentYear() + "'";
			strokeDate = "and to_char(STROKE_MANAGED_DATE, 'yyyy') = '" + DateUtil.getCurrentYear() + "'";

		}

		if (ObjectUtil.isNotEmpty(roleType) && roleType.equals(RoleType.ZXMB) || roleType.equals(RoleType.ZMB)) {
			sql.append(" and dmDiseaseInfo.CREATE_ORGAN_CODE = '" + organization.getOrganCode() + "'");
		}
		String lastSql = String.format(sql.toString(), hbpDate, diDate, tumorDate, coronaryDate, strokeDate);
		return this.getMap(lastSql, new Criteria());
	}

	/**
	 * 慢病纳入统计
	 * @param page
	 * @param form
	 * @return
	 */
	@Override
	public PageList<Map<String, Object>> getMangerIntoStatistics(Page page, ReportQueryForm form, Organization currentOrg) {
		String sql = MANAGER_INRO_SQL_ORG;
		if(ObjectUtil.equals("2", form.getSearchType())) {
			sql = MANAGER_INRO_SQL_VILLAGE;
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

		if (ObjectUtil.isNotEmpty(form.getStaffCode())) {
			staffSql = " and (u.staff_code = '" + form.getStaffCode() + "')";
		}
		if(ObjectUtil.equals("2", form.getSearchType())) {
			//中心 站的用户按照现住址查询时仅可以查询本机构的数据
			if(!ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.JK.getValue())
					&& !ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.CITY_HEALTH.getValue())
					&& !ObjectUtil.equals(currentOrg.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue())
					) {
				roleSql = orgSql;

			}
			//按照现住址查询
			if (ObjectUtil.isNotEmpty(form.getPaStreet())) {//居委会
				orgSql = " and (pastreet = '" + form.getPaStreet() + "')";
			}else if (ObjectUtil.isNotEmpty(form.getPatownShip())) {//镇
				orgSql = " and (patown_ship = '" + form.getPatownShip() + "')";
			} else {
				orgSql = "";
			}
		}
		String lastSql = String.format(targetSql, beginStr, endStr, orgSql, staffSql + roleSql);
		return lastSql;
	}

	/**
	 * 获取高血压糖尿病规范化管理人数
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getHbpDiManagerMaps(String year) {
		String orgSql = "";
		if(ObjectUtil.isNullOrEmpty(year)) {
			year = String.valueOf(DateUtil.getCurrentYear());
		}

		String lastSql = String.format(HBP_DI_MANAGER_SQL, year);

		List<Map<String, Object>> result = this.getMapList(lastSql, new Criteria());

		return result;
	}

	@Override
	public DmDiseaseInfo getDiseaseInfoOnly(Criteria criteria) {
		if (ObjectUtil.isNullOrEmpty(criteria)) {
			return null;
		}
		StringBuilder sqlBuilder = new StringBuilder("select * from DM_DISEASE_INFO");
		SqlBuilder.buildWhereStatement(DmDiseaseInfo.class, sqlBuilder, criteria);
		sqlBuilder.append(" and ( (hbp_flag='2' or di_flag='2' or stroke_flag='2' or coronary_flag='2' or tumor_flag='2' )\n" +
				"or (hbp_flag='1' or di_flag='1' or stroke_flag='1' or coronary_flag='1' or tumor_flag='1' ))");
		return this.get(sqlBuilder.toString(), criteria);
	}
}
