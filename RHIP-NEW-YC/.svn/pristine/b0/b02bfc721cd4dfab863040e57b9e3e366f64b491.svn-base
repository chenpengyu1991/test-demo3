package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.entity.healtheducation.HeActive;
import com.founder.rhip.ehr.entity.healtheducation.HeResource;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Map;

@Repository("healthEducationStatisticsDao_")
public class HealthEducationStatisticsDaoImpl extends AbstractDao<HeActive, Long> implements IHealthEducationStatisticsDao {
	
	 @Resource(name = "phbdbJDBCTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;
	 
	// 播放音像数量数 
	private static final String HEALTH_VIDEO_SQL = "SELECT  COUNT(1) PLAY_VIDEO_QUANTITY, SUM(EDUCATION_PERSON_QUANTITY) PLAY_VIDEO_PERSON_QUANTITY FROM HE_ACTIVE WHERE ACTIVE_TYPE='4' AND STATUS = '1' ";
	//开展公众健康咨询次数  ACTIVE_TYPE='2'活动类别为“社会宣传活动”
	private static final String HEALTH_CONSULT_SQL = "SELECT  COUNT(1) HEALTH_CONSULT_QUANTITY, SUM(EDUCATION_PERSON_QUANTITY) HEALTH_CONSULT_PERSON_QUANTITY FROM HE_ACTIVE  WHERE ACTIVE_TYPE='2' AND STATUS = '1'  ";
	// 举办健康知识讲座次数 ACTIVE_TYPE='1'活动类别为“健康教育讲座”
	private static final String HEALTH_LECTURE_SQL = "SELECT COUNT(1) HEALTH_LECTURE_QUANTITY, SUM(EDUCATION_PERSON_QUANTITY) HEALTH_LECTURE_PERSON_QUANTITY FROM HE_ACTIVE WHERE ACTIVE_TYPE='1' AND STATUS = '1' ";
	// 其他健康教育活动数 ACTIVE_TYPE != '1' AND ACTIVE_TYPE != '4' AND ACTIVE_TYPE != '2'  活动类别除了“健康教育讲座”、“社会宣传活动”、“播放影音资料”
	private static final String OTHER_ACTIVE_SQL = "SELECT COUNT(1) OTHER_ACTIVE_QUANTITY, SUM(EDUCATION_PERSON_QUANTITY) OTHER_ACTIVE_PERSON_QUANTITY FROM HE_ACTIVE WHERE ACTIVE_TYPE != '1' AND ACTIVE_TYPE != '4' AND ACTIVE_TYPE != '2' AND STATUS = '1' ";
	// 设置宣传栏数
	private static final String BULLETIN_BOARD_SQL = "SELECT  SUM(GALLERY_QUANTITY) BULLETIN_BOARD_QUANTITY FROM HE_RESOURCE WHERE RESOURCE_TYPE = '2' AND STATUS = '1'  ";
	// 宣传栏更新次数 positionType = 1  阵地类型为“宣传栏”
	private static final String BULLETIN_BOARD_USE_SQL = "SELECT  COUNT(1) BULLETIN_BOARD_USE_FREQUENCY FROM HE_RESOURCE_RECORD  WHERE RESOURCE_TYPE = '1' AND  POSITION_TYPE = '1' AND STATUS = '1' ";
	// 发放健康教育印刷资料数量
	private static final String MATERIAL_DISTRIBUTION_SQL = "SELECT  SUM(ISSUE_QUANTITY) ISSUE_MATERIAL_QUANTITY FROM HE_RESOURCE_RECORD WHERE RESOURCE_TYPE = '2' AND MATERIAL_TYPE <>'1' AND STATUS = '1' ";


	
	// 机构标识
	public static final String ORG_CODE = "orgCode";
	public static final String GBCODE = "gbcode";
	
	// 时间字段
	public static final String ACTIVE_TIME = "ACTIVE_TIME";
	public static final String RESOURCE_RECORD_TIME = "RESOURCE_RECORD_TIME";
	public static final String USE_TIME = "USE_TIME";
	public static final String ISSUE_TIME = "ISSUE_TIME";
	
	@Override
	public Float getHETarget(Criteria criteria, String targetCode) {
		StringBuilder sqlBuilder = new StringBuilder();
		Class<?>  clazz = HeActive.class;
		if (StringUtils.equalsIgnoreCase(TargetConstants.HE_DELIVERY_MATERIAL_QUANTITY, targetCode)) { // 发放健康教育印刷资料数量
			clazz = HeResourceRecord.class;
			sqlBuilder.append("SELECT SUM(ISSUE_QUANTITY) allNum FROM HEALTH_RESOURCE_RECORD WHERE RESOURCE_TYPE = 2 AND STATUS = '1' ");
		} else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_PLAY_AUDIO_QUANTITY, targetCode)) { // 播放音像数量数
			sqlBuilder.append("SELECT COUNT(1) allNum FROM HE_ACTIVE WHERE ACTIVE_TYPE='4' AND STATUS = '1' ");
		} else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_SET_BULLETIN_BOARD_QUANTITY, targetCode)) { // 设置宣传栏数
			clazz = HeResource.class;
			sqlBuilder.append("SELECT SUM(GALLERY_QUANTITY) allNum FROM HEALTH_EDUCATION_RESOURCE WHERE RESOURCE_TYPE = 2 AND STATUS = '1' ");
		}  else if (StringUtils.equalsIgnoreCase(TargetConstants.HE_BULLETIN_BOARD_QUANTITY_UPDATE_QUANTITY, targetCode)) {  //宣传栏更新次数
			clazz = HeResourceRecord.class;
			sqlBuilder.append("SELECT COUNT(1) allNum FROM HEALTH_RESOURCE_RECORD  WHERE RESOURCE_TYPE = 1 AND STATUS = '1' ");
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
		StringBuilder sqlBuilder = new StringBuilder(HEALTH_VIDEO_SQL).append(organizeDateStatisticsSQL(criteria, ACTIVE_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		Integer[] nums = new Integer[2];
		nums[0] = (map != null && ObjectUtil.isNotEmpty(map.get("PLAY_VIDEO_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("PLAY_VIDEO_QUANTITY"))) : 0;
		nums[1] = (map != null && ObjectUtil.isNotEmpty(map.get("PLAY_VIDEO_PERSON_QUANTITY"))) ? Integer.valueOf(String.valueOf(map.get("PLAY_VIDEO_PERSON_QUANTITY"))) : 0;
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
		//宣传栏organizeDateStatisticsSQL参数bulletinBoard设为true
		StringBuilder sqlBuilder = new StringBuilder(BULLETIN_BOARD_SQL).append(organizeDateStatisticsSQL(criteria, RESOURCE_RECORD_TIME, true)).append(organizeOrganizationSQL(criteria));
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
	public Integer getMaterialDistributionQuantity(Criteria criteria) {
		StringBuilder sqlBuilder = new StringBuilder(MATERIAL_DISTRIBUTION_SQL).append(organizeDateStatisticsSQL(criteria, ISSUE_TIME, false)).append(organizeOrganizationSQL(criteria));
		Map<String, Object> map = this.getMap(sqlBuilder.toString(), criteria);
		if (map != null && ObjectUtil.isNotEmpty(map.get("ISSUE_MATERIAL_QUANTITY"))) {
			return Integer.valueOf(String.valueOf(map.get("ISSUE_MATERIAL_QUANTITY")));
		} else {
			return 0;
		}
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
		if (criteria.contains("beginDate") && criteria.contains("endDate")) {
			sb.append(" AND ");
			sb.append(timeColumn);
			//宣传栏根据endDate为标准统计当年的数量
			if (bulletinBoard) {
				String endDate = String.valueOf(criteria.get("endDate"));
				String year = endDate.substring(0, 4);

				sb.append(" BETWEEN TO_DATE('");
				sb.append(year + "/01/01");
				sb.append("', 'yyyy/MM/dd') AND TO_DATE('");
				sb.append(year + "/12/31");
				sb.append("', 'yyyy/MM/dd')");
			} else {
				sb.append(" BETWEEN TO_DATE('");
				sb.append(criteria.get("beginDate"));
				sb.append("', 'yyyy/MM/dd') AND TO_DATE('");
				sb.append(criteria.get("endDate"));
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
		}else if (criteria.contains("gbCode")) {
//			sqlBuilder.append(" AND GBCODE ='");
			sqlBuilder.append(" AND ORG_CODE in (");
			sqlBuilder.append(String.valueOf(criteria.get("gbCode")));
			sqlBuilder.append(") ");
//			sqlBuilder.append("'");
		}
		return sqlBuilder.toString();
	}
}
