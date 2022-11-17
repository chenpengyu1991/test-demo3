package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.entity.healtheducation.HeActive;
import com.founder.rhip.ehr.entity.healtheducation.HeResource;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository("healthEducationActiveStatisticsDao")
public class HealthEducationActiveStatisticsDaoImpl extends AbstractDao<HeActive, Long> implements IHealthEducationActiveStatisticsDao {
	
	 @Resource(name = "phbdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;
	 
	// 播放音像数量数 
	//private static final String HEALTH_VIDEO_SQL = "SELECT  COUNT(1) PLAY_VIDEO_QUANTITY, SUM(EDUCATION_PERSON_QUANTITY) PLAY_VIDEO_PERSON_QUANTITY FROM HE_ACTIVE WHERE ACTIVE_TYPE='4' AND STATUS = '1' ";
	private static final String HEALTH_VIDEO_SQL = "SELECT COUNT(distinct THEME || '-' || ORG_CODE) SPECIES_VIDEO_QUANTITY, nvl(SUM(TIMES),0) PLAY_VIDEO_QUANTITY FROM HE_MEDIA WHERE 1 = 1 ";
	//开展公众健康咨询次数  ACTIVE_TYPE='2'活动类别为“社会宣传活动”
	private static final String HEALTH_CONSULT_SQL = "SELECT  COUNT(1) HEALTH_CONSULT_QUANTITY, SUM(EDUCATION_PERSON_QUANTITY) HEALTH_CONSULT_PERSON_QUANTITY FROM HE_ACTIVE  WHERE ACTIVE_TYPE='2' AND STATUS = '1'  ";
	// 举办健康知识讲座次数 ACTIVE_TYPE='1'活动类别为“健康教育讲座”
	private static final String HEALTH_LECTURE_SQL = "SELECT COUNT(1) HEALTH_LECTURE_QUANTITY, SUM(EDUCATION_PERSON_QUANTITY) HEALTH_LECTURE_PERSON_QUANTITY FROM HE_ACTIVE WHERE ACTIVE_TYPE='1' AND STATUS = '1' ";
	// 其他健康教育活动数 ACTIVE_TYPE != '1' AND ACTIVE_TYPE != '4' AND ACTIVE_TYPE != '2'  活动类别除了“健康教育讲座”、“社会宣传活动”、“播放影音资料”
	private static final String OTHER_ACTIVE_SQL = "SELECT COUNT(1) OTHER_ACTIVE_QUANTITY, SUM(EDUCATION_PERSON_QUANTITY) OTHER_ACTIVE_PERSON_QUANTITY FROM HE_ACTIVE WHERE ACTIVE_TYPE != '1' AND ACTIVE_TYPE != '4' AND ACTIVE_TYPE != '2' AND STATUS = '1' ";
	// 设置宣传栏数
	private static final String BULLETIN_BOARD_SQL = "SELECT  SUM(GALLERY_QUANTITY) BULLETIN_BOARD_QUANTITY FROM HE_RESOURCE WHERE RESOURCE_TYPE = '2' AND STATUS = '1'  ";
	// 宣传栏更新次数 positionType = 1  阵地类型为“宣传栏”
//	private static final String BULLETIN_BOARD_USE_SQL = "SELECT  COUNT(1) BULLETIN_BOARD_USE_FREQUENCY FROM HE_RESOURCE_RECORD  WHERE RESOURCE_TYPE = '1' AND  POSITION_TYPE = '1' AND STATUS = '1' ";
    //银川更新宣传类型  positionType = 6  modify by bagen at 2017-05-16
    private static final String BULLETIN_BOARD_USE_SQL = "SELECT  COUNT(1) BULLETIN_BOARD_USE_FREQUENCY FROM HE_RESOURCE_RECORD  WHERE RESOURCE_TYPE = '1' AND  POSITION_TYPE = '6' AND STATUS = '1' ";

    // 发放健康教育印刷资料数量 bug0131478
	private static final String MATERIAL_DISTRIBUTION_SQL = "SELECT COUNT(distinct(MATERIAL_TYPE || '-' || ORG_CODE)) SPECIES_MATERIAL_QUANTITY, nvl(SUM(ISSUE_QUANTITY),0) ISSUE_MATERIAL_QUANTITY FROM HE_RESOURCE_RECORD WHERE RESOURCE_TYPE = '2' AND MATERIAL_TYPE <>'6' AND STATUS = '1' AND ACTIVE_ID IS NULL ";

    //健康教育处方种类（数）
    private static final String HEALTH_PRESCRIPTION_SQL = "SELECT COUNT(distinct MATERIAL_NAME || '-' || ORG_CODE) PRESCRIPTION_QUANTITY FROM HE_RESOURCE WHERE STATUS='1' AND MATERIAL_TYPE = '4'";

    private static final String HEALTH_CENSUS_ORG_SQL = "with org as (select organ_code,GB_CODE,ORGAN_NAME,genre_code,decode(genre_code,'B200',parent_code,organ_code) parent_code from mdm_organization \n" +
    		"			where genre_code in ('B100','B200') and STATUS=1 %3$s \n" +
    		"),\n" +
    		"res as(\n" +
    		"		SELECT ORG_CODE,(THEME||'-'||ORG_CODE) SPECIES_VIDEO_QUANTITY, \n" +//影像资料_种类数(种)
    		"		null HEALTH_CONSULT_QUANTITY,null HEALTH_CONSULT_PERSON_QUANTITY,null HEALTH_LECTURE_QUANTITY, null HEALTH_LECTURE_PERSON_QUANTITY, null BULLETIN_BOARD_USE_FREQUENCY,null SPECIES_MATERIAL_QUANTITY,null ISSUE_MATERIAL_QUANTITY, null PRESCRIPTION_QUANTITY,\n" +
			"NULL HEALTH_EDUCATION_QUANTITY\n" +
    		"		FROM HE_MEDIA WHERE to_char(FILL_DATE,'yyyy/mm/dd')>= '%1$s' \n" +
    		"		and to_char(FILL_DATE,'yyyy/mm/dd')<='%2$s' \n" +
    		"	UNION all\n" +
    		"		select \n" +
    		"		ORG_CODE,null SPECIES_VIDEO_QUANTITY,\n" +
    		"		decode(ACTIVE_TYPE,'2',1,0) HEALTH_CONSULT_QUANTITY,\n" +//开展公众健康咨询服务_开展公众健康咨询服务活动次数(次) 
    		"		decode(ACTIVE_TYPE,'2',EDUCATION_PERSON_QUANTITY,0) HEALTH_CONSULT_PERSON_QUANTITY,\n" +//开展公众健康咨询服务_接受咨询的人数
    		"		decode(ACTIVE_TYPE,'1',1,0) HEALTH_LECTURE_QUANTITY,\n" +//举办健康知识讲座_举办健康知识讲座次数(次)
    		"		decode(ACTIVE_TYPE,'1',EDUCATION_PERSON_QUANTITY,0) HEALTH_LECTURE_PERSON_QUANTITY,\n" +//举办健康知识讲座_听讲人数(人次)
    		"		 null BULLETIN_BOARD_USE_FREQUENCY,null SPECIES_MATERIAL_QUANTITY,null ISSUE_MATERIAL_QUANTITY, null PRESCRIPTION_QUANTITY,\n" +
			"NULL HEALTH_EDUCATION_QUANTITY\n" +
    		"		from HE_ACTIVE where STATUS = '1' \n" +
    		"		and to_char(ACTIVE_TIME,'yyyy/mm/dd')>= '%1$s' \n" +
    		"		and to_char(ACTIVE_TIME,'yyyy/mm/dd')<='%2$s' \n" +
    		"	UNION all\n" +
    		"		SELECT  ORG_CODE,null SPECIES_VIDEO_QUANTITY,null HEALTH_CONSULT_QUANTITY,null HEALTH_CONSULT_PERSON_QUANTITY,null HEALTH_LECTURE_QUANTITY, null HEALTH_LECTURE_PERSON_QUANTITY, "+ 
    		"		1 BULLETIN_BOARD_USE_FREQUENCY, \n" +//设置健康教育宣传栏_宣传栏内容更新次数(次)
    		"		null SPECIES_MATERIAL_QUANTITY,null ISSUE_MATERIAL_QUANTITY, null PRESCRIPTION_QUANTITY,\n" +
			"NULL HEALTH_EDUCATION_QUANTITY\n" +
    		"		FROM HE_RESOURCE_RECORD  WHERE RESOURCE_TYPE = '1' AND  POSITION_TYPE = '6' AND STATUS = '1' \n" +
    		"		and to_char(USE_TIME,'yyyy/mm/dd')>= '%1$s' \n" +
    		"		and to_char(USE_TIME,'yyyy/mm/dd')<='%2$s' \n" +
    		"	UNION all\n" +
    		"		SELECT ORG_CODE,null SPECIES_VIDEO_QUANTITY,null HEALTH_CONSULT_QUANTITY,null HEALTH_CONSULT_PERSON_QUANTITY,null HEALTH_LECTURE_QUANTITY, null HEALTH_LECTURE_PERSON_QUANTITY, null BULLETIN_BOARD_USE_FREQUENCY,\n" +
    		"		(MATERIAL_TYPE || '-' || MATERIAL_NAME) SPECIES_MATERIAL_QUANTITY,\n" +//印刷资料_种类数(种)
    		"		nvl(ISSUE_QUANTITY,0) ISSUE_MATERIAL_QUANTITY,\n" +//印刷资料_发放数(份)
    		"		 null PRESCRIPTION_QUANTITY,\n" +
			"NULL HEALTH_EDUCATION_QUANTITY\n" +
    		"		FROM HE_RESOURCE_RECORD WHERE RESOURCE_TYPE = '2' AND MATERIAL_TYPE in ('1','2','4') AND STATUS = '1' AND ACTIVE_ID IS NULL\n" +
    		"		and to_char(ISSUE_TIME,'yyyy/mm/dd')>= '%1$s' \n" +
    		"		and to_char(ISSUE_TIME,'yyyy/mm/dd')<='%2$s' \n" +
//    		"	UNION all \n" +
//    		"		SELECT ORG_CODE,null SPECIES_VIDEO_QUANTITY,null HEALTH_CONSULT_QUANTITY,null HEALTH_CONSULT_PERSON_QUANTITY,null HEALTH_LECTURE_QUANTITY, null HEALTH_LECTURE_PERSON_QUANTITY, null BULLETIN_BOARD_USE_FREQUENCY,null SPECIES_MATERIAL_QUANTITY,null ISSUE_MATERIAL_QUANTITY,\n" +
//    		"		(MATERIAL_NAME || '-' || ORG_CODE) PRESCRIPTION_QUANTITY\n" +//健康教育处方_健康教育处方种类(数)
//    		"		FROM HE_RESOURCE WHERE STATUS='1' AND MATERIAL_TYPE = '4'\n" +
//    		"		and to_char(RESOURCE_RECORD_TIME,'yyyy/mm/dd')>= '%1$s' \n" +
//    		"		and to_char(RESOURCE_RECORD_TIME,'yyyy/mm/dd')<='%2$s' \n" +
			"			UNION ALL\n" +
			"SELECT HE_RESOURCE_RECORD.ORG_CODE,NULL SPECIES_VIDEO_QUANTITY,NULL HEALTH_CONSULT_QUANTITY,NULL HEALTH_CONSULT_PERSON_QUANTITY,NULL HEALTH_LECTURE_QUANTITY,NULL HEALTH_LECTURE_PERSON_QUANTITY,NULL BULLETIN_BOARD_USE_FREQUENCY,NULL SPECIES_MATERIAL_QUANTITY,NULL ISSUE_MATERIAL_QUANTITY,NULL PRESCRIPTION_QUANTITY,\n" +
			"CASE WHEN MDM_ORGANIZATION.genre_code = 'B100' THEN\n" +
			"(CASE WHEN count(*)  = 1 THEN 1 WHEN count(*)  >= 2 THEN 2 ELSE 0 END)\n" +
			"WHEN MDM_ORGANIZATION.genre_code = 'B200' THEN(CASE WHEN count(*)  >= 1 THEN 1 ELSE 0 END)\n" +
			"ELSE 0 END HEALTH_EDUCATION_QUANTITY\n" +
			"FROM HE_RESOURCE_RECORD\n" +
			"LEFT JOIN mdm_organization ON HE_RESOURCE_RECORD.ORG_CODE = MDM_ORGANIZATION.ORGAN_CODE\n" +
			"WHERE HE_RESOURCE_RECORD.RESOURCE_TYPE = '1'AND HE_RESOURCE_RECORD.POSITION_TYPE = '6'AND HE_RESOURCE_RECORD.STATUS = '1'"+
			"		and to_char(HE_RESOURCE_RECORD.USE_TIME,'yyyy/mm/dd')>= '%1$s' \n" +
			"		and to_char(HE_RESOURCE_RECORD.USE_TIME,'yyyy/mm/dd')<='%2$s' \n" +
			"GROUP BY HE_RESOURCE_RECORD.ORG_CODE,MDM_ORGANIZATION.genre_code"+
			")\n" +
    		"select org_code,SPECIES_MATERIAL_QUANTITY,ISSUE_MATERIAL_QUANTITY,SPECIES_VIDEO_QUANTITY,BULLETIN_BOARD_USE_FREQUENCY,HEALTH_CONSULT_QUANTITY,HEALTH_CONSULT_PERSON_QUANTITY,HEALTH_LECTURE_QUANTITY,HEALTH_LECTURE_PERSON_QUANTITY,HEALTH_EDUCATION_QUANTITY"+
//    		"		,TRADITIONAL_CHINESE_QUANTITY "+ 
    		"		from (\n" +
    		"		select decode(grouping(%4$s), 1, '合计', %4$s) org_code,\n" +
    		"		COUNT(distinct SPECIES_VIDEO_QUANTITY) SPECIES_VIDEO_QUANTITY ,sum(nvl(HEALTH_CONSULT_QUANTITY,0)) HEALTH_CONSULT_QUANTITY , sum(nvl(HEALTH_CONSULT_PERSON_QUANTITY,0)) HEALTH_CONSULT_PERSON_QUANTITY ,sum(nvl(HEALTH_LECTURE_QUANTITY,0)) HEALTH_LECTURE_QUANTITY,sum(nvl(HEALTH_LECTURE_PERSON_QUANTITY,0)) HEALTH_LECTURE_PERSON_QUANTITY,\n" +
    		"		count(BULLETIN_BOARD_USE_FREQUENCY) BULLETIN_BOARD_USE_FREQUENCY,count(SPECIES_MATERIAL_QUANTITY) SPECIES_MATERIAL_QUANTITY ,sum(nvl(ISSUE_MATERIAL_QUANTITY,0)) ISSUE_MATERIAL_QUANTITY "+
			"			,SUM (\n" +
			"				NVL (HEALTH_EDUCATION_QUANTITY, 0)\n" +
			"			) HEALTH_EDUCATION_QUANTITY"+
//    		"		,count(distinct PRESCRIPTION_QUANTITY) TRADITIONAL_CHINESE_QUANTITY\n" +
    		"		from org  left join res on RES.org_code=org.organ_code \n" +
    		"		group by rollup(%4$s)\n" +
    		") t left join org on org.organ_code=t.org_code \n" +
    		"order by GB_CODE, genre_code,nlssort(organ_name,'NLS_SORT=SCHINESE_PINYIN_M')";
	// 机构标识
	public static final String ORG_CODE = "orgCode";
	public static final String CENTER_ORG_CODE = "centerOrgCode";
	public static final String GBCODE = "gbcode";
	
	// 时间字段
	public static final String ACTIVE_TIME = "ACTIVE_TIME";
	public static final String RESOURCE_RECORD_TIME = "RESOURCE_RECORD_TIME";
	public static final String USE_TIME = "USE_TIME";
	public static final String ISSUE_TIME = "ISSUE_TIME";
	public static final String FILL_DATE = "FILL_DATE";
	public static final String CREATE_TIME = "CREATE_TIME";

	@Override
	public Float getHETarget(Criteria criteria, String targetCode) {
		StringBuilder sqlBuilder = new StringBuilder();
		Class<?>  clazz = HeActive.class;
		if (StringUtils.equalsIgnoreCase(TargetConstants.HE_DELIVERY_MATERIAL_QUANTITY, targetCode)) { // 发放健康教育印刷资料数量
			clazz = HeResourceRecord.class;
			sqlBuilder.append("SELECT SUM(ISSUE_QUANTITY) allNum FROM HE_RESOURCE_RECORD WHERE RESOURCE_TYPE = 2 AND STATUS = '1' ");
		} else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_PLAY_AUDIO_QUANTITY, targetCode)) { // 播放音像数量数
			sqlBuilder.append("SELECT COUNT(1) allNum FROM HE_ACTIVE WHERE ACTIVE_TYPE='4' AND STATUS = '1' ");
		} else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_SET_BULLETIN_BOARD_QUANTITY, targetCode)) { // 设置宣传栏数
			clazz = HeResource.class;
			sqlBuilder.append("SELECT SUM(GALLERY_QUANTITY) allNum FROM HEALTH_EDUCATION_RESOURCE WHERE RESOURCE_TYPE = 2 AND STATUS = '1' ");
		}  else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_BULLETIN_BOARD_QUANTITY_UPDATE_QUANTITY, targetCode)) {  //宣传栏更新次数
			clazz = HeResourceRecord.class;
			sqlBuilder.append("SELECT COUNT(1) allNum FROM HE_RESOURCE_RECORD  WHERE RESOURCE_TYPE = 1 AND STATUS = '1' ");
		}  else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_PUBLIC_HEALTH_CONSULT_QUANTITY, targetCode)) { //开展公众健康咨询次数
			sqlBuilder.append("SELECT COUNT(1) allNum FROM HE_ACTIVE  WHERE ACTIVE_TYPE='2' AND STATUS = '1'  ");
		}  else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_PUBLIC_HEALTH_CONSULT_PERSON_QUANTITY, targetCode)) { //开展公众健康咨询参加人数
			sqlBuilder.append("SELECT SUM(EDUCATION_PERSON_QUANTITY) allNum FROM HE_ACTIVE  WHERE ACTIVE_TYPE='2' AND STATUS = '1'  ");
		}  else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_HEALTH_KNOWLEDGE_LECTURE_QUANTITY, targetCode)) { //举办健康知识讲座次数
			sqlBuilder.append("SELECT COUNT(1) allNum FROM HE_ACTIVE WHERE ACTIVE_TYPE='1' AND STATUS = '1' ");
		}  else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_HEALTH_KNOWLEDGE_LECTURE_PERSON_QUANTITY, targetCode)) { //举办健康知识讲座参加人数
			sqlBuilder.append("SELECT SUM(EDUCATION_PERSON_QUANTITY) allNum FROM HE_ACTIVE WHERE ACTIVE_TYPE='1' AND STATUS = '1' ");
		}
		
		sqlBuilder.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(clazz), ":")).toString();
		//int result = this.execute(sqlBuilder.toString());
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		if(map != null && ObjectUtil.isNotEmpty(map.get("allNum"))) {
			return ((BigDecimal)map.get("allNum")).floatValue();
		} else {
			return 0f;
		}
	}

	@Override
	public Integer[] getHealthVideoQuantity(Criteria criteria) {
		StringBuilder sqlBuilder = new StringBuilder(HEALTH_VIDEO_SQL).append(organizeDateStatisticsSQL(criteria, FILL_DATE, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		Integer[] nums = new Integer[2];
		nums[0] = (map != null && ObjectUtil.isNotEmpty(map.get("PLAY_VIDEO_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("PLAY_VIDEO_QUANTITY"))) : 0;
		nums[1] = (map != null && ObjectUtil.isNotEmpty(map.get("SPECIES_VIDEO_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("SPECIES_VIDEO_QUANTITY"))) : 0;
		return nums;
	}

	@Override
	public Integer[] getConsultQuantity(Criteria criteria) {
		StringBuilder sqlBuilder = new StringBuilder(HEALTH_CONSULT_SQL).append(organizeDateStatisticsSQL(criteria, ACTIVE_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		Integer[] nums = new Integer[2];
		nums[0] = (map != null && ObjectUtil.isNotEmpty(map.get("HEALTH_CONSULT_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("HEALTH_CONSULT_QUANTITY"))) : 0;
		nums[1] = (map != null && ObjectUtil.isNotEmpty(map.get("HEALTH_CONSULT_PERSON_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("HEALTH_CONSULT_PERSON_QUANTITY"))) : 0;
		return nums;
	}

	@Override
	public Integer[] getLectureQuantity(Criteria criteria) {
		StringBuilder sqlBuilder = new StringBuilder(HEALTH_LECTURE_SQL).append(organizeDateStatisticsSQL(criteria, ACTIVE_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		Integer[] nums = new Integer[2];
		nums[0] = (map != null && ObjectUtil.isNotEmpty(map.get("HEALTH_LECTURE_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("HEALTH_LECTURE_QUANTITY"))) : 0;
		nums[1] = (map != null && ObjectUtil.isNotEmpty(map.get("HEALTH_LECTURE_PERSON_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("HEALTH_LECTURE_PERSON_QUANTITY"))) : 0;
		return nums;
	}

	@Override
	public Integer[] getOtherActiveQuantity(Criteria criteria) {
		StringBuilder sqlBuilder = new StringBuilder(OTHER_ACTIVE_SQL).append(organizeDateStatisticsSQL(criteria, ACTIVE_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		Integer[] nums = new Integer[2];
		nums[0] = (map != null && ObjectUtil.isNotEmpty(map.get("OTHER_ACTIVE_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("OTHER_ACTIVE_QUANTITY"))) : 0;
		nums[1] = (map != null && ObjectUtil.isNotEmpty(map.get("OTHER_ACTIVE_PERSON_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("OTHER_ACTIVE_PERSON_QUANTITY"))) : 0;
		return nums;
	}

	@Override
	public Integer getBulletinBoardQuantity(Criteria criteria) {
		Criteria ca = new Criteria();
		ca.addAll(criteria);
		ca.remove("month");//条件：月份，对宣传栏无效
		ca.remove("createBeginTime");//条件：开始时间，对宣传栏无效
		ca.remove("createEndTime");//条件：结束时间，对宣传栏无效
		StringBuilder sqlBuilder = new StringBuilder(BULLETIN_BOARD_SQL).append(organizeDateStatisticsSQL(ca, RESOURCE_RECORD_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		if (map != null && ObjectUtil.isNotEmpty(map.get("BULLETIN_BOARD_QUANTITY"))) {
			return Integer.valueOf(String.valueOf(map.get("BULLETIN_BOARD_QUANTITY")));
		} else {
			return 0;
		}
	}

	@Override
	public Integer getBulletinBoardUseQuantity(Criteria criteria) {
		StringBuilder sqlBuilder = new StringBuilder(BULLETIN_BOARD_USE_SQL).append(organizeDateStatisticsSQL(criteria, USE_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		if (map != null && ObjectUtil.isNotEmpty(map.get("BULLETIN_BOARD_USE_FREQUENCY"))) {
			return Integer.valueOf(String.valueOf(map.get("BULLETIN_BOARD_USE_FREQUENCY")));
		} else {
			return 0;
		}
	}

	@Override
	public Map<String, Object> getMaterialDistributionQuantity(Criteria criteria){
		StringBuilder sqlBuilder = new StringBuilder(MATERIAL_DISTRIBUTION_SQL).append(organizeDateStatisticsSQL(criteria, ISSUE_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		return map;
	}

	@Override
	public Map<String, Object> getPrescriptionQuantity(Criteria criteria){
		StringBuilder sqlBuilder = new StringBuilder(HEALTH_PRESCRIPTION_SQL).append(organizeDateStatisticsSQL(criteria, RESOURCE_RECORD_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		return map;
	}

	/**
	 * 组织按时间统计条件
	 * 
	 * @param criteria 查询条件包含时间
	 * @param timeColumn 时间字段
	 * @param bulletinBoard 是否为宣传栏
	 * @return
	 */
	private String organizeDateStatisticsSQL(Criteria criteria, String timeColumn, boolean bulletinBoard) {
		if (criteria == null || ObjectUtil.isNullOrEmpty(timeColumn)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		if (criteria.contains("year") && !criteria.contains("month") && (!criteria.contains("createBeginTime") && !criteria.contains("createEndTime"))) {
			sb.append(" AND TO_CHAR(");
			sb.append(timeColumn);
			sb.append(", 'yyyy')");
			sb = bulletinBoard ? sb.append(" <= ") : sb.append(" = ");
			sb.append(criteria.get("year"));
		} else if (criteria.contains("year") && criteria.contains("month")) {
			sb.append(" AND TO_CHAR(");
			sb.append(timeColumn);
			sb.append(", 'yyyy/MM')");
			sb = bulletinBoard ? sb.append(" <= '") : sb.append(" = '");
			sb.append(criteria.get("year"));
			sb.append("/");
			sb.append(criteria.get("month"));
			sb.append("'");
		} else if (criteria.contains("createBeginTime") && criteria.contains("createEndTime")) {
			sb.append(" AND ");
			sb.append(timeColumn);
			if (bulletinBoard) {
				sb.append(" <= TO_DATE('");
				sb.append(criteria.get("createEndTime"));
				sb.append("', 'yyyy/MM/dd')");
			} else {
				sb.append(" BETWEEN TO_DATE('");
				sb.append(criteria.get("createBeginTime"));
				sb.append("', 'yyyy/MM/dd') AND TO_DATE('");
				sb.append(criteria.get("createEndTime"));
				sb.append("', 'yyyy/MM/dd')");
			}
		} else if (criteria.contains("createBeginTime") && !criteria.contains("createEndTime")) {
				sb.append(" AND ");
				sb.append(timeColumn);
				if (bulletinBoard) {
					sb.append(" <= TO_DATE('");
					sb.append(criteria.get("createBeginTime"));
					sb.append("', 'yyyy/MM/dd')");
				} else {
					//查询本年度数据
					Date createBeginTime = DateUtil.parseSimpleDate(criteria.get("createBeginTime").toString(), "yyyy/MM/dd");
					Date createEndTime = DateUtil.lastDateOfYear(createBeginTime);
					sb.append(" BETWEEN TO_DATE('");
					sb.append(DateUtil.getDateTime("yyyy/MM/dd", createBeginTime));
					sb.append("', 'yyyy/MM/dd') AND TO_DATE('");
					sb.append(DateUtil.getDateTime("yyyy/MM/dd", createEndTime));
					sb.append("', 'yyyy/MM/dd')");
				}
		} else if (!criteria.contains("createBeginTime") && criteria.contains("createEndTime")) {
				sb.append(" AND ");
				sb.append(timeColumn);
				if (bulletinBoard) {
					sb.append(" <= TO_DATE('");
					sb.append(criteria.get("createEndTime"));
					sb.append("', 'yyyy/MM/dd')");
				} else {
					//查询本年度数据
					Date createEndTime = DateUtil.parseSimpleDate(criteria.get("createEndTime").toString(), "yyyy/MM/dd");
					Date createBeginTime = DateUtil.firstDateOfYear(createEndTime);
					sb.append(" BETWEEN TO_DATE('");
					sb.append(DateUtil.getDateTime("yyyy/MM/dd", createBeginTime));
					sb.append("', 'yyyy/MM/dd') AND TO_DATE('");
					sb.append(DateUtil.getDateTime("yyyy/MM/dd", createEndTime));
					sb.append("', 'yyyy/MM/dd')");					
				}
		}
		return sb.toString();	
	}
	
	/**
	 * 组织不同机构类别查询条件
	 * @param criteria
	 * @return
	 */
	private String organizeOrganizationSQL(Criteria criteria) {
		StringBuilder sqlBuilder = new StringBuilder();
		if (criteria.contains("orgCode")) {
			sqlBuilder.append(" AND ORG_CODE ='");
			sqlBuilder.append(String.valueOf(criteria.get("orgCode")));
			sqlBuilder.append("'");
		} else if (criteria.contains("centerOrgCode")) {
			sqlBuilder.append(" AND ORG_CODE in (");
			sqlBuilder.append(String.valueOf(criteria.get("centerOrgCode")));
			sqlBuilder.append(")");
		} else if (criteria.contains("gbcode")) {
			sqlBuilder.append(" AND GBCODE ='");
			sqlBuilder.append(String.valueOf(criteria.get("gbcode")));
			sqlBuilder.append("'");
		}
		return sqlBuilder.toString();
	}

	@Override
	public List<HealthEducationReport> getEduCensusList(Criteria c) {
		String sql = HEALTH_CENSUS_ORG_SQL;
		String createBeginTime = (String)c.get("createBeginTime");
		String createEndTime = (String)c.get("createEndTime");
		String gbcode = (String)c.get("gbcode");
		String centerOrgCode = (String)c.get("centerOrgCode");
		String orgCode = (String)c.get("orgCode");
        String org3 = "";
        String col4 = " ORG.parent_code ";
        if (ObjectUtil.isNotEmpty(orgCode)) {//站
        	org3 = " and organ_code = '" + orgCode + "'";
        	col4 = " org.organ_code ";
        } else if (ObjectUtil.isNotEmpty(centerOrgCode)) {//卫生院
        	org3 = " and (organ_code = '" + centerOrgCode + "' or parent_code = '" + centerOrgCode + "')";
        	col4 = " org.organ_code ";
        }else if (ObjectUtil.isNotEmpty(gbcode)) {//镇
        	org3 = " and gb_code = '" + gbcode + "'";
        }
        String lastSql = String.format(sql, createBeginTime, createEndTime, org3, col4);
        return this.getList(HealthEducationReport.class, lastSql, new Criteria());
	}
	
}
