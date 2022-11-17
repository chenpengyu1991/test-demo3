package com.founder.rhip.ehr.repository.child;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * DAO implement of ChildHealthExamination
 * 
 */
@Repository("childHealthExaminationDao")
public class ChildHealthExaminationDaoImpl extends AbstractDao<ChildHealthExamination,String> implements IChildHealthExaminationDao {
	@Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


	private static final String CHILD_PHYSICAL_EXAMINATION_STATISTICS_SQL = "select organCode, rpDate,sum(NVL(weight_num,0))weight_num,"
			+ " sum(NVL(hgb_check_num,0))hgb_check_num,sum(NVL(median_num,0))median_num,"
			+ " sum(NVL(severe_anemia_num,0))severe_anemia_num from (select t.create_organ_code organCode,to_char(t.check_date,'yyyy/MM/dd') rpDate,"
			+ " sum(decode(t.body_weight,null,0,1)) weight_num, sum(decode(t.HEMOGLOBIN_VALUE,null,0,1)) hgb_check_num,"
			+ " max(decode(t.EVALUATIONRESULTCODE,'3',1,0))median_num,max(decode(sign(t.hemoglobin_value-90),-1,1,0)) severe_anemia_num "
			+ " from ch_child_health_examination t %1$s group by t.create_organ_code, t.baby_card_no,to_char(t.check_date,'yyyy/MM/dd')) "
			+ " group by organCode,rpDate";

	private static final String CHILD_CARE_WORKLOAD_STATISTICS_SQL = "select %6$s"
			+ " from (select create_organ_code organCode, input_idcard doctorIdcard,input_job_number doctorCode,max(input_name)doctorName,to_char(input_date,'yyyy/MM/dd')rpDate, count(1)childNum "
			+ " from ch_child_health_card %1$s group by create_organ_code,input_idcard,input_job_number,to_char(input_date,'yyyy/MM/dd')"
			+ " union select create_organ_code organCode, check_idcard doctorIdcard,check_job_number doctorCode,max(check_name)doctorName,to_char(check_date,'yyyy/MM/dd')rpDate,count(1)childNum "
			+ " from ch_child_health_examination %2$s group by create_organ_code,check_idcard,check_job_number,to_char(check_date,'yyyy/MM/dd')"
			+ " union select create_organ_code organCode, check_idcard doctorIdcard,check_job_number doctorCode,max(check_name)doctorName,to_char(check_date,'yyyy/MM/dd')rpDate,count(1)childNum "
			+ " from ch_frail_child_followup %3$s group by create_organ_code,check_idcard,check_job_number,to_char(check_date,'yyyy/MM/dd') "
			+ " union select create_organ_code organCode, check_idcard doctorIdcard,check_job_number doctorCode,max(check_name)doctorName,to_char(check_date,'yyyy/MM/dd')rpDate,count(1)childNum "
			+ " from ch_neonatal_disease_screen %4$s group by create_organ_code,check_idcard,check_job_number,to_char(check_date,'yyyy/MM/dd') "
			+ " union select create_organ_code organCode, supervision_idcard doctorIdcard,supervision_job_number doctorCode,max(SUPERVISION_DOCTOR)doctorName,to_char(visit_date,'yyyy/MM/dd')rpDate,count(1)childNum "
			+ " from ch_neonatal_family_visit %5$s group by create_organ_code,supervision_idcard,supervision_job_number,to_char(visit_date,'yyyy/MM/dd')) "
			+ " group by %7$s";
    /**
     * 统计儿童体检人次、体重体检人次、血红蛋白检查人次
     * @param paramMap
     * @param orgCodes
     * @return
     */
    @Override
    public Map countHealthExamination(Map<String, String> paramMap, List orgCodes) {
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        String orgField = "";
        String genreCode = paramMap.get("genreCode");

        String weight = paramMap.get("weight");
        String hemoglobin = paramMap.get("hemoglobin");

        Criteria ca = new Criteria();
        if("0".equals(genreCode)){
            orgField = "PATOWN_SHIP";
            ca.add(orgField, OP.IN, orgCodes);
        }else{
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }
        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "CHECK_DATE", beginDate,endDate);

        if("Y".equals(weight)){
            ca.add("BODY_WEIGHT", OP.UEMPTY, null);//体重
        }
        if("Y".equals(hemoglobin)){
            ca.add("HEMOGLOBIN_VALUE", OP.UEMPTY, null);//血红蛋白值
        }

//        StringBuilder sql = new StringBuilder("SELECT "+orgField+" AS org, COUNT(1) AS weightCheckCount FROM CH_CHILD_HEALTH_EXAMINATION ");
        StringBuilder sql = new StringBuilder("SELECT DECODE("+orgField+",null,'合计',"+orgField+") AS org, count(1) AS hcCount FROM CH_CHILD_HEALTH_EXAMINATION ");
        SqlBuilder.buildWhereStatement(ChildHealthExamination.class, sql, ca);
//        sql.append(" GROUP BY "+orgField);
        sql.append(" GROUP BY "+ " ROLLUP(" + orgField + ")" );
        List<Map<String, Object>> birthDefects = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> birthCertificate : birthDefects){
            resultMap.put(birthCertificate.get("org"), birthCertificate.get("hcCount"));
        }
        return resultMap;
    }

    /**
     * 统计体重<(中位数-2SD)的人数、中重度贫血人数
     * @param paramMap
     * @param orgCodes
     * @return
     */

    public Map countHealthExaminationByPerson(Map<String, String> paramMap, List orgCodes){
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        String orgField = "";
        String genreCode = paramMap.get("genreCode");

        Criteria ca = new Criteria();
        if("0".equals(genreCode)){
            orgField = "PATOWN_SHIP";
            ca.add(orgField, OP.IN, orgCodes);
        }else{
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }
        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(beginDateStr, null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr, null);
        DateUtil.getCriteriaByDateRange(ca, "CHECK_DATE", beginDate,endDate);


        String evaluationresultcode = paramMap.get("evaluationresultcode");
        String hemoglobin = paramMap.get("hemoglobin");
        if(StringUtil.isNotEmpty(evaluationresultcode)){
            ca.add("EVALUATIONRESULTCODE", evaluationresultcode); //体重<(中位数-2SD)的人数
        }
        if(StringUtil.isNotEmpty(hemoglobin)){
            if(hemoglobin.equals("Y")){
                ca.add("HEMOGLOBIN_VALUE", OP.UEMPTY, ""); //血红蛋白检查人数
            }else{
                ca.add("HEMOGLOBIN_VALUE", OP.LT, 90); //中重度贫血人数
            }
        }

        StringBuilder sql = new StringBuilder("SELECT DECODE("+ orgField +", null, '合计', "+ orgField +") AS org, count(1) AS personCount ");
        sql.append(" FROM ( ");
        sql.append(getPersons(ca));
        sql.append(" )  GROUP BY ROLLUP("+ orgField +") ");

        List<Map<String, Object>> persons = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> person : persons){
            resultMap.put(person.get("org"), person.get("personCount"));
        }
        return resultMap;
    }

    private String getPersons(Criteria criteria){
        StringBuilder sql = new StringBuilder("SELECT DISTINCT BABY_CARD_NO, CREATE_ORGAN_CODE, PATOWN_SHIP ");
        sql.append(" FROM CH_CHILD_HEALTH_EXAMINATION ");
        SqlBuilder.buildWhereStatement(ChildHealthExamination.class, sql, criteria);
        return sql.toString();
    }

    //7岁以下保健覆盖
    public Map count7Mgnt(Map<String, String> paramMap, List orgCodes){
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        String orgField = "";
        String genreCode = paramMap.get("genreCode");

        Criteria ca = new Criteria();
        if("0".equals(genreCode)){
            orgField = "PATOWN_SHIP";
            ca.add(orgField, OP.IN, orgCodes);
        }else{
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }
        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(endDateStr.substring(0,4)+"/01/01", null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr.substring(0,4)+"/12/31", null);
        DateUtil.getCriteriaByDateRange(ca, "CHECK_DATE", beginDate,endDate);

//        StringBuilder sql = new StringBuilder("SELECT DECODE("+ orgField +", null, '合计', "+ orgField +") AS org, count(1) AS personCount ");
//        sql.append(" FROM ( ");
//        sql.append(getPersons(ca));
//        sql.append(" )  GROUP BY ROLLUP("+ orgField +") ");

        StringBuilder sql = new StringBuilder("SELECT DECODE("+ orgField +", null, '合计', "+ orgField +") AS org, count(1) AS count7 " +
                "  FROM (SELECT DISTINCT NAME, "+orgField+" \n" +
                "           FROM CH_CHILD_HEALTH_EXAMINATION\n");
                SqlBuilder.buildWhereStatement(ChildHealthExamination.class, sql, ca);
//                sql.append(ca.toSql(ClassMetadata.getMetadata(ChildHealthExamination.class), ":")).toString();
                sql.append("       AND (BODY_WEIGHT IS NOT NULL OR STATURE IS NOT NULL OR\n" +
                "          HEIGHT IS NOT NULL))\n" +
                " GROUP BY ROLLUP("+orgField+")");

        List<Map<String, Object>> persons = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> person : persons){
            resultMap.put(person.get("org"), person.get("count7"));
        }
        return resultMap;
    }

    //3岁以下系统管理
    public Map count3Mgnt(Map<String, String> paramMap, List orgCodes){
        String beginDateStr = paramMap.get("beginDate");
        String endDateStr = paramMap.get("endDate");
        String orgField = "";
        String genreCode = paramMap.get("genreCode");

        Criteria ca = new Criteria();
        if("0".equals(genreCode)){
            orgField = "PATOWN_SHIP";
            ca.add(orgField, OP.IN, orgCodes);
        }else{
            orgField = "CREATE_ORGAN_CODE";
            ca.add(orgField, OP.IN, orgCodes);
        }
        /* 时间范围 */
        Date beginDate = DateUtil.parseSimpleDate(endDateStr.substring(0,4)+"/01/01", null);
        Date endDate = DateUtil.parseSimpleDate(endDateStr.substring(0,4)+"/12/31", null);
        DateUtil.getCriteriaByDateRange(ca, "CHECK_DATE", beginDate,endDate);

//        StringBuilder sql = new StringBuilder("SELECT DECODE("+ orgField +", null, '合计', "+ orgField +") AS org, count(1) AS personCount ");
//        sql.append(" FROM ( ");
//        sql.append(getPersons(ca));
//        sql.append(" )  GROUP BY ROLLUP("+ orgField +") ");

        StringBuilder sql = new StringBuilder("SELECT DECODE("+ orgField +", null, '合计', "+ orgField +") AS org, count(1) AS count3 " +
                "  FROM (SELECT DISTINCT NAME, "+orgField+" \n" +
                "           FROM CH_CHILD_HEALTH_EXAMINATION\n");
        SqlBuilder.buildWhereStatement(ChildHealthExamination.class, sql, ca);
//                sql.append(ca.toSql(ClassMetadata.getMetadata(ChildHealthExamination.class), ":")).toString();
        sql.append(" AND FLOOR(MONTHS_BETWEEN(TO_DATE('"+endDateStr+"', 'YYYY/MM/DD'), BIRTHDAY) / 12) <3  ");
        sql.append("       AND (BODY_WEIGHT IS NOT NULL OR STATURE IS NOT NULL OR\n" +
                "          HEIGHT IS NOT NULL))\n" +
                " GROUP BY ROLLUP("+orgField+")");

        List<Map<String, Object>> persons = getMapList(sql.toString(), ca);

        Map resultMap = new HashMap();
        for(Map<String, Object> person : persons){
            resultMap.put(person.get("org"), person.get("count3"));
        }
        return resultMap;
    }

	@Override
	public List<Map<String, Object>> getChildHealthExaminationMapList(
			String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder conditionSqlBuilder = new StringBuilder(" where to_char(t.gather_date,'yyyy/MM/dd')='").append(dateStr).append("'");
		String sql = String.format(CHILD_PHYSICAL_EXAMINATION_STATISTICS_SQL, conditionSqlBuilder.toString());
		return getMapList(sql, new Criteria());
	}

	@Override
	public List<Map<String, Object>> getChildCareWorkLoad(String dateStr) {
		Assert.notNull(dateStr);
		String conditionSQL = new StringBuilder(" where to_char(gather_date,'yyyy/MM/dd')='").append(dateStr).append("'").toString();
		String columnNames = "organCode,doctorIdcard,doctorCode,doctorName,rpDate ";
		String sql = String.format(CHILD_CARE_WORKLOAD_STATISTICS_SQL, conditionSQL, conditionSQL, conditionSQL, conditionSQL, conditionSQL, columnNames+",sum(NVL(childNum,0))childNum", columnNames);
		return getMapList(sql, new Criteria());
	}

	@Override
	public void updateBirthDay(String idCard,String birthday,String babyNo,Long personId){
	    String sql = "UPDATE CH_CHILD_HEALTH_EXAMINATION SET BIRTHDAY = to_date('"+birthday+"','yyyy-mm-dd')";
        if(StringUtil.isNotEmpty(babyNo)){
           sql = sql +",BABY_CARD_NO = '"+babyNo+"'";
        }
        if(StringUtil.isNotEmpty(idCard)){
            sql = sql +",ID_CARD = '"+idCard+"'";
        }
        sql = sql +" WHERE PERSON_ID = "+personId+"";
        execute(sql);
    }

    @Override
    public void updateOrganByVillage(Organization org, String[] newAddVillageCodes) {
        String sql = "UPDATE CH_CHILD_HEALTH_EXAMINATION cd SET cd.CREATE_ORGAN_CODE = :createOrganCode,\n" +
                "cd.CREATE_ORGAN_NAME= :createOrganName,\n" +
                "cd.CREATE_SUPER_ORGAN_CODE= :createSuperOrganCode,\n" +
                "cd.CREATE_GB_CODE= :createGbCode\n" +
                "WHERE EXISTS ( SELECT 1 FROM V_PHB_BI_PERSON_INFO bi WHERE cd.PERSON_ID = bi.id AND bi.PASTREET IN (:villages))";
        String historySql = "INSERT INTO CH_CHILD_HEALTH_EXAMINATION_RH(ID,CREATE_ORGAN_CODE,CREATE_SUPER_ORGAN_CODE,CREATE_GB_CODE,RECORD_CHANGE_TIME)" +
                " SELECT cd.ID,cd.CREATE_ORGAN_CODE,cd.CREATE_SUPER_ORGAN_CODE,cd.CREATE_GB_CODE,to_date('2020-04-01 10:25:42','yyyy-mm-dd hh24:mi:ss') " +
                "FROM CH_CHILD_HEALTH_EXAMINATION cd, V_PHB_BI_PERSON_INFO bi  WHERE cd.PERSON_ID = bi.id AND bi.PASTREET IN (:villages)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("villages", Arrays.asList(newAddVillageCodes));
        parameterSource.addValue("createOrganCode", org.getOrganCode());
        parameterSource.addValue("createOrganName", org.getOrganName());
        if(ObjectUtil.equals(org.getGenreCode(), OrgGenreCode.CENTRE.getValue())) {
            parameterSource.addValue("createSuperOrganCode", org.getOrganCode());
        } else {
            parameterSource.addValue("createSuperOrganCode", org.getParentCode());
        }
        parameterSource.addValue("createGbCode", org.getGbCode());

//        simpleJdbcTemplate.update(historySql, parameterSource); 记录表不存在 所以需要注释掉
        simpleJdbcTemplate.update(sql, parameterSource);
    }
}