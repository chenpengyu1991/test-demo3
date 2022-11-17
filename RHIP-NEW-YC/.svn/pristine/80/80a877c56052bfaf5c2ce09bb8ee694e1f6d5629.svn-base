package com.founder.rhip.ehr.repository.ech;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.mdm.common.OrgGenreCode;

/**
 * DAO implement of EchIdentificationOption
 * 
 */
@Repository("echStatisticsQueryDao")
public class EchStatisticsQueryDaoImpl extends AbstractDao<PhysicalExamRecord, Long> implements IEchStatisticsQueryDao {
	 @Resource(name = "queryJdbcTemplate")
	 private SimpleJdbcTemplate simpleJdbcTemplate;
	 
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		return simpleJdbcTemplate;
	}
	
	/*private static final String STATISTICS_SQL = "WITH EXAM_RECORD AS("
			+ " SELECT %1$s orgCode,sum(TCM_STATUS) MANAGE_NUM from ("//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " select input_organ_code,decode(genre_code,'B200',parent_code, organ_code) INPUT_SUPER_ORGAN_CODE ,DECODE (NVL(TCM_STATUS, 0), 1, 1, 0) TCM_STATUS "
			+ " FROM ECH_PHYSICAL_EXAM_RECORD  record left join mdm_organization  org on RECORD.input_organ_code=ORG.organ_code"//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " WHERE TO_CHAR(EXAM_YEAR,'yyyy') = '%2$s')"
			+ " GROUP BY %1$s),"
			+ " EXAM_RECORDS AS("
			+ " SELECT %1$s orgCode,sum(TCM_STATUS) MANAGE_NUM from ("//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " select input_organ_code,decode(genre_code,'B200',parent_code, organ_code) INPUT_SUPER_ORGAN_CODE ,DECODE (NVL(TCM_STATUS, 0), 1, 1, 0) TCM_STATUS "
			+ " FROM ECH_PHYSICAL_EXAM_RECORD  record left join mdm_organization  org on RECORD.input_organ_code=ORG.organ_code"//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " WHERE TO_CHAR(EXAM_YEAR,'yyyy') = '%2$s')"
			+ " GROUP BY %1$s)"
			
			
			+ " SELECT populace.orgCode ,populace.HOUSEHOLD_NUM householdNum,NVL(EXAM_RECORD.MANAGE_NUM,0) manageNum " 
			+ " ,ROUND(DECODE(SIGN(NVL(populace.HOUSEHOLD_NUM,0)),0,0,NVL(EXAM_RECORD.MANAGE_NUM,0)/populace.HOUSEHOLD_NUM),4) manageRate"
			+ " FROM ("
			+ " SELECT %3$s orgCode,sum(HOUSEHOLD_NUM) HOUSEHOLD_NUM FROM("////中心：parent_code，站：organ_code
			+ " SELECT mdm_organization.gb_code,decode(MDM_ORGANIZATION.GENRE_CODE,'B100',MDM_ORGANIZATION.organ_code,'B200',MDM_ORGANIZATION.PARENT_CODE,MDM_ORGANIZATION.PARENT_CODE) parent_code"
			+ " ,MDM_ORGANIZATION.organ_code"
			+ " ,NVL(HOUSEHOLD_GREAT_SIXF_NUM,0)+NVL(UN_HOUSEHOLD_GREAT_SIXF_NUM,0) HOUSEHOLD_NUM"
			+ " FROM MDM_ORGANIZATION"
			+ " LEFT JOIN (select HOUSEHOLD_NUM,UN_HOUSEHOLD_GREAT_SIXF_NUM,HOUSEHOLD_GREAT_SIXF_NUM,COUNT_YEAR,organ_code from BI_POPULACE WHERE COUNT_YEAR = %4$s)BI_POPULACE ON MDM_ORGANIZATION.organ_code = bi_populace.organ_code"
			+ " WHERE (genre_code ='"+ OrgGenreCode.STATION.getValue() +"' or genre_code ='"+ OrgGenreCode.CENTRE.getValue()+"') and status=1"//只关联站和中心的数据
			+ " )"
			+ " GROUP BY %3$s "
			+ " )populace"
			+ " LEFT JOIN EXAM_RECORD ON EXAM_RECORD.orgCode = populace.orgCode left join MDM_ORGANIZATION org on org.organ_code= populace.orgCode";
*/
	private static final String STATISTICS_SQL = "WITH EXAM_RECORD AS("
			+ " SELECT %1$s orgCode,COUNT(DISTINCT RECORD.PERSON_ID) MANAGE_NUM from ("//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " select input_organ_code,decode(genre_code,'B200',parent_code, organ_code) INPUT_SUPER_ORGAN_CODE ,DECODE (NVL(TCM_STATUS, 0), 1, 1, 0) TCM_STATUS "
			+ " FROM ECH_PHYSICAL_EXAM_RECORD  record left join mdm_organization  org on RECORD.input_organ_code=ORG.organ_code"//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " inner join (\n"
			+ "	select person_id\n"
			+ "		from ECH_IDENTIFICATION where to_char(create_date,'yyyy')='%2$s'\n"
			+ "	UNION all\n"
			+ "		select person_id\n"
			+ "		from ECH_ELDERLY_PHY_EXAMINATION\n"
			+ "		where PHYSICAL_EXAM_TYPE='31' and IDENTIFICATION_ID is not null and IDENTIFICATION_ID <>0 and exam_year='%2$s'\n"
			+ " ) temp on RECORD.person_id=temp.person_id where LOGOFF =0 and TO_CHAR (RECORD.EXAM_year, 'yyyy') <= '%2$s'"
			+ " GROUP BY %1$s),"
			+ " EXAM_RECORDS AS("
			+ " SELECT %1$s orgCode,sum(TCM_STATUS) TCM_NUM from ("//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " select input_organ_code,decode(genre_code,'B200',parent_code, organ_code) INPUT_SUPER_ORGAN_CODE ,DECODE (NVL(TCM_STATUS, 0), 1, 1, 0) TCM_STATUS "
			+ " FROM ECH_PHYSICAL_EXAM_RECORD  record  LEFT JOIN ECH_IDENTIFICATION ech on ech.EXAM_RECORD_ID = record.ID left join mdm_organization  org on RECORD.input_organ_code=ORG.organ_code"//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " WHERE TO_CHAR(EXAM_YEAR,'yyyy') = '%2$s' and TCM_STATUS='1' and LOGOFF = 0 "
			+ " and (((ech.tcm_qi_quality>='11' or ech.tcm_qi_quality='9' or ech.tcm_qi_quality='10' ) and ech.tcm_qi_quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.qi_quality_guidance='1,2,3,4,5'  ) "
			+ " or ( (ech.tcm_yang_quality>=11 or ech.tcm_yang_quality='9' or ech.tcm_yang_quality='10') and ech.tcm_yang_quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.yang_quality_guidance='1,2,3,4,5'  ) "
			+ " or ( (ech.tcm_Yin_Deficiency>=11 or ech.tcm_Yin_Deficiency='9' or ech.tcm_Yin_Deficiency='10') and ech.tcm_Yin_Deficiency=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.yin_Deficiency_Guidance='1,2,3,4,5' ) "
			+ " or ( (ech.tcm_Phlegm_Wetness>=11 or ech.tcm_Phlegm_Wetness='9' or ech.tcm_Phlegm_Wetness='10') and ech.tcm_Phlegm_Wetness=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.phlegm_Wetness_Guidance='1,2,3,4,5'  ) "
			+ " or ( (ech.tcm_Heat_Medium>=11 or ech.tcm_Heat_Medium='9' or ech.tcm_Heat_Medium='10') and ech.tcm_Heat_Medium=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.heat_Medium_Guidance='1,2,3,4,5'  ) "
			+ " or ( (ech.tcm_blood_quality>=11 or ech.tcm_blood_quality='9' or ech.tcm_blood_quality='10') and ech.tcm_blood_quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.blood_Quality_Guidance='1,2,3,4,5' ) "
			+ " or ( (ech.tcm_Qi_Stagnation>=11 or ech.tcm_Qi_Stagnation='9' or ech.tcm_Qi_Stagnation='10') and  ech.tcm_Qi_Stagnation=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.qi_Stagnation_Guidance='1,2,3,4,5' ) "
			+ " or ( ((((ech.Tcm_Peaceful_Quality>='17' and ech.tcm_qi_quality<='8' and ech.Tcm_Yang_Quality<='8') and ech.Tcm_Yin_Deficiency>='8' and ech.Tcm_Phlegm_Wetness<='8' and ech.Tcm_Heat_Medium<='8' and ech.Tcm_Blood_Quality<='8' and ech.Tcm_Qi_Stagnation<='8' and ech.Tcm_Special_Quality<='8') or (ech.Tcm_Peaceful_Quality>='17' and ech.tcm_qi_quality<='10' and ech.Tcm_Yang_Quality<='10' and ech.Tcm_Yin_Deficiency<='10' and ech.Tcm_Phlegm_Wetness<='10' and ech.Tcm_Heat_Medium<='10' and ech.Tcm_Blood_Quality<='10' and ech.Tcm_Qi_Stagnation<='10' and ech.Tcm_Special_Quality<='10'))  and ech.tcm_Peaceful_Quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) ) and  ech.peaceful_Quality_Guidance='1,2,3,4,5'  )"
			+ " or (  ((ech.tcm_Special_Quality>=11 or ech.tcm_Special_Quality='9' or ech.tcm_Special_Quality='10') and ech.tcm_Special_Quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) ) and ech.special_Quality_Guidance='1,2,3,4,5' ) "
			+ " or ((ech.tcm_qi_quality>='11' or ech.tcm_qi_quality='9' or ech.tcm_qi_quality='10') and ech.tcm_qi_quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.qi_quality_guidance='1,2,3,4,5,6'  ) "
			+ " or ( (ech.tcm_yang_quality>=11 or ech.tcm_yang_quality='9' or ech.tcm_yang_quality='10') and ech.tcm_yang_quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.yang_quality_guidance='1,2,3,4,5,6'  ) "
			+ " or ( (ech.tcm_Yin_Deficiency>=11 or ech.tcm_Yin_Deficiency='9' or ech.tcm_Yin_Deficiency='10') and ech.tcm_Yin_Deficiency=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.yin_Deficiency_Guidance='1,2,3,4,5,6' ) "
			+ " or ( (ech.tcm_Phlegm_Wetness>=11 or ech.tcm_Phlegm_Wetness='9' or ech.tcm_Phlegm_Wetness='10') and ech.tcm_Phlegm_Wetness=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.phlegm_Wetness_Guidance='1,2,3,4,5,6'  ) "
			+ " or ( (ech.tcm_Heat_Medium>=11 or ech.tcm_Heat_Medium='9' or ech.tcm_Heat_Medium='10') and ech.tcm_Heat_Medium=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.heat_Medium_Guidance='1,2,3,4,5,6'  ) "
			+ " or ( (ech.tcm_blood_quality>=11 or ech.tcm_blood_quality='9' or ech.tcm_blood_quality='10') and ech.tcm_blood_quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.blood_Quality_Guidance='1,2,3,4,5,6' ) "
			+ " or ( (ech.tcm_Qi_Stagnation>=11 or ech.tcm_Qi_Stagnation='9' or ech.tcm_Qi_Stagnation='10') and  ech.tcm_Qi_Stagnation=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) and ech.qi_Stagnation_Guidance='1,2,3,4,5,6' ) "
			+ " or ( (((ech.Tcm_Peaceful_Quality>='17' and ech.tcm_qi_quality<='8' and ech.Tcm_Yang_Quality<='8' and ech.Tcm_Yin_Deficiency>='8' and ech.Tcm_Phlegm_Wetness<='8' and ech.Tcm_Heat_Medium<='8' and ech.Tcm_Blood_Quality<='8' and ech.Tcm_Qi_Stagnation<='8' and ech.Tcm_Special_Quality<='8') or (ech.Tcm_Peaceful_Quality>='17' and ech.tcm_qi_quality<='10' and ech.Tcm_Yang_Quality<='10' and ech.Tcm_Yin_Deficiency<='10' and ech.Tcm_Phlegm_Wetness<='10' and ech.Tcm_Heat_Medium<='10' and ech.Tcm_Blood_Quality<='10' and ech.Tcm_Qi_Stagnation<='10' and ech.Tcm_Special_Quality<='10'))  and ech.tcm_Peaceful_Quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) ) and  ech.peaceful_Quality_Guidance='1,2,3,4,5,6'  )"
			+ " or (  ((ech.tcm_Special_Quality>=11 or ech.tcm_Special_Quality='9' or ech.tcm_Special_Quality='10') and ech.tcm_Special_Quality=GREATEST( CASE  WHEN ech.qi_flag>0 THEN ech.tcm_qi_quality  ELSE 0 END, CASE WHEN ech.yang_flag>0 THEN ech.tcm_yang_quality  ELSE 0 END,CASE  WHEN ech.blood_flag>0 THEN ech.tcm_blood_quality  ELSE 0 END, CASE  WHEN  ech.yin_deficiency_flag>0 THEN  ech.tcm_Yin_Deficiency    ELSE 0 END,CASE  WHEN ech.phle_gmwetness_flag>0 THEN ech.tcm_Phlegm_Wetness  ELSE 0 END,CASE WHEN ech.heat_medium_flag>0 THEN ech.tcm_Heat_Medium  ELSE 0 END,CASE WHEN ech.qi_stagnation_flag>0 THEN ech.tcm_Qi_Stagnation  ELSE 0 END,CASE WHEN  ech.special_flag>0 THEN  ech.tcm_Special_Quality ELSE 0 END, CASE  WHEN  ech.peaceful_flag>0 THEN  ech.tcm_Peaceful_Quality ELSE 0 END   ) ) and ech.special_Quality_Guidance='1,2,3,4,5,6' ) "
			+ " )"
			+ " )"
			+ " GROUP BY %1$s)"
			+ " SELECT populace.orgCode ,populace.HOUSEHOLD_NUM householdNum,NVL(MANAGE_NUM,0) manageNum" 
			+ " ,ROUND(DECODE(SIGN(NVL(populace.HOUSEHOLD_NUM,0)),0,0,NVL(MANAGE_NUM,0)/populace.HOUSEHOLD_NUM),4) manageRate"
			+ " FROM ("
			+ " SELECT %3$s orgCode,sum(HOUSEHOLD_NUM) HOUSEHOLD_NUM ,SUM (MANAGE_NUM) MANAGE_NUM FROM("////中心：parent_code，站：organ_code
			+ " SELECT mdm_organization.gb_code,decode(MDM_ORGANIZATION.GENRE_CODE,'B100',MDM_ORGANIZATION.organ_code,'B200',MDM_ORGANIZATION.PARENT_CODE,MDM_ORGANIZATION.PARENT_CODE) parent_code"
			+ " ,MDM_ORGANIZATION.organ_code"
			+ " ,NVL(HOUSEHOLD_GREAT_SIXF_NUM,0)+NVL(UN_HOUSEHOLD_GREAT_SIXF_NUM,0) HOUSEHOLD_NUM, NVL (MANAGE_NUM,0) MANAGE_NUM"
			+ " FROM MDM_ORGANIZATION"
			+ " LEFT JOIN (select HOUSEHOLD_NUM,UN_HOUSEHOLD_GREAT_SIXF_NUM,HOUSEHOLD_GREAT_SIXF_NUM,COUNT_YEAR,organ_code from BI_POPULACE WHERE COUNT_YEAR = %4$s)BI_POPULACE ON MDM_ORGANIZATION.organ_code = bi_populace.organ_code"
			+ " LEFT JOIN EXAM_RECORD ON EXAM_RECORD.orgCode = MDM_ORGANIZATION.organ_code"
			+ " WHERE (genre_code ='"+ OrgGenreCode.STATION.getValue() +"' or genre_code ='"+ OrgGenreCode.CENTRE.getValue()+"') and status=1"//只关联站和中心的数据
			+ " )"
			+ " GROUP BY %3$s "
			+ " )populace";
	private static final String RATE_SQL = "WITH EXAM_RECORD AS("
			+ " SELECT %1$s orgCode"//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " ,SUM(DECODE(NVL(es .TCM_STATUS,0),1,1,0)) MANAGE_NUM "
			+ " ,COUNT(1) APPLY_NUM"
			+ " ,COUNT(DECODE(es.HEALTH_GUIDE_STATUS,1,DECODE(es.ESTIMATE_STATUS,1,1,NULL),NULL)) WHOLE_NUM"
			+ " FROM ECH_PHYSICAL_EXAM_RECORD er LEFT JOIN ECH_ELDERLY_PHY_STATUS es ON er.PERSON_ID = es.PERSON_ID "//中心：INPUT_SUPER_ORGAN_CODE，站：INPUT_ORGAN_CODE
			+ " WHERE TO_CHAR(er.EXAM_YEAR,'yyyy') = '%2$s' %4$s "
			+ " GROUP BY %1$s)"
			+ " SELECT orgCode organCode,householdNum,manageNum,wholeNum,applyNum"
			+ " ,ROUND(DECODE(SIGN(NVL(householdNum,0)),0,0,NVL(manageNum,0)/householdNum),4) manageRate" 
			+ "  FROM (SELECT populace.orgCode,SUM(populace.HOUSEHOLD_NUM) householdNum"
			+ " ,SUM(NVL(EXAM_RECORD.MANAGE_NUM,0)) manageNum "
			+ " ,SUM(NVL(EXAM_RECORD.WHOLE_NUM,0)) wholeNum "
			+ " ,SUM(NVL(EXAM_RECORD.APPLY_NUM,0)) applyNum"
			+ " FROM ("
			+ " SELECT %3$s orgCode,sum(HOUSEHOLD_NUM) HOUSEHOLD_NUM FROM("////中心：parent_code，站：organ_code
			+ " SELECT org.gb_code,org.parent_code"
			+ " ,org.organ_code"
			+ " ,NVL(HOUSEHOLD_GREAT_SIXF_NUM,0)+NVL(UN_HOUSEHOLD_GREAT_SIXF_NUM,0) HOUSEHOLD_NUM"
			+ " FROM MDM_ORGANIZATION ORG"
			+ " LEFT JOIN (SELECT organ_code,HOUSEHOLD_GREAT_SIXF_NUM,COUNT_YEAR,UN_HOUSEHOLD_GREAT_SIXF_NUM FROM BI_POPULACE WHERE COUNT_YEAR = %2$s) bi_populace ON org.organ_code = bi_populace.organ_code"
			+ " WHERE gb_code is not null and genre_code ='"+ OrgGenreCode.STATION.getValue() +"' %5$s)"//只关联站数据
			+ " GROUP BY %3$s "
			+ " )populace"
			+ " LEFT JOIN EXAM_RECORD ON EXAM_RECORD.orgCode = populace.orgCode"
			+ " WHERE populace.orgCode IS NOT NULL"
			+ " GROUP BY ROLLUP(populace.orgCode) )";	
	
	private static final String TARGET_SQL = "SELECT %3$s organCode"
			+ " ,SUM(SHOULD_EXAM_QUANTITY) shouldExamQuantity"
			+ " ,SUM(ACTUAL_EXAM_QUANTITY) actualExamQuantity"
			+ " ,NVL(DECODE(SIGN(SUM(SHOULD_EXAM_QUANTITY)),0,0,ROUND(SUM(ACTUAL_EXAM_QUANTITY)/SUM(SHOULD_EXAM_QUANTITY),4)),0) physicalExamRate"
			+ " ,SUM(BLOOD_BIO_QUANTITY) bloodBioQuantity"
			+ " ,SUM(URINE_ROUTINE_QUANTITY) urineRoutineQuantity"
			+ " ,SUM(ECG_QUANTITY) ecgQuantity"
			+ " ,SUM(B_ULTRASONIC_QUANTITY) bUltrasonicQuantity"
			+ " ,SUM(X_RAY_QUANTITY) xRayQuantity"
			+ " ,SUM(BPV_QUANTITY) bpvQuantity"
			+ " ,SUM(IFG_QUANTITY) ifgQuantity"
			+ " ,SUM(DYSLIPIDEMIA_QUANTITY) dyslipidemiaQuantity"
			+ " ,SUM(LIVER_ABNORMAL_QUANTITY) liverAbnormalQuantity"
			+ " ,SUM(RENAL_ABNORMAL_QUANTITY) renalAbnormalQuantity"
			+ " ,SUM(X_RAY_ABNORMAL_QUANTITY) xRayAbnormalQuantity"
			+ " ,SUM(HEPATIC_CYST_QUANTITY) hepaticCystQuantity"
			+ " ,SUM(FATTY_LIVER_QUANTITY) fattyLiverQuantity"
			+ " ,SUM(GALL_STONE_QUANTITY) gallStoneQuantity"
			+ " ,SUM(CHOLECYSTITIS_QUANTITY) cholecystitisQuantity"
			+ " ,SUM(RENAL_CYST_QUANTITY) renalCystQuantity"
			+ " ,SUM(KIDNEY_STONE_QUANTITY) kidneyStoneQuantity"
			+ " ,SUM(TUMOR_QUANTITY) tumorQuantity"
			+ " ,SUM(TUBERCULOSIS_QUANTITY) tuberculosisQuantity"
			+ " FROM "
			+ " (SELECT org.gb_code,org.parent_code,org.ORGAN_CODE,org.GENRE_CODE,ELDERLY.*  FROM MDM_ORGANIZATION ORG"
			+ " LEFT JOIN (SELECT * FROM ECH_ELDERLY_HEALTH_STATISTICS %1$s) ELDERLY ON ELDERLY.ORG_CODE = ORG.ORGAN_CODE"
			+ " %2$s"
			+ " ) ELDERLY_DATA"
			+ " WHERE %3$s IS NOT NULL"
			+ " GROUP BY ROLLUP(%3$s)"
			+ " ORDER BY %3$s";    
	
    private String getStatisticsSql(String year,String orgType){
    	String baseSql= STATISTICS_SQL;
    	String orgField1 = "";//体检表机构字段
    	String orgField2 = "";//人口基数机构字段
    	if(orgType.equals(OrgGenreCode.CENTRE.getValue())){//按中心查询
    		orgField1 = "INPUT_ORGAN_CODE";
    		orgField2 = "GB_CODE,PARENT_CODE";
    	}else if (orgType.equals(OrgGenreCode.STATION.getValue())){//按站查询
    		//orgField1 = "INPUT_SUPER_ORGAN_CODE,INPUT_ORGAN_CODE";
    		orgField1 = "INPUT_ORGAN_CODE";
    		orgField2 = "PARENT_CODE,ORGAN_CODE";    		
    	}
    	return String.format(baseSql,orgField1,year,orgField2,year);
    }

	/**
	 * 健康管理-按站统计
	 *
	 * @param page
	 * @param year
	 * @param parentCode：中心编码
	 * @param organCode:站编码
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public List<Map<String, Object>> getStatisticsStationResult(String year, String parentCode, String organCode) {
		String sql = getStatisticsSql(year,OrgGenreCode.STATION.getValue());
		
		if(StringUtil.isNotEmpty(organCode)){
			sql += " WHERE populace.orgCode='" + organCode + "'";//站
			sql +=" order by org.gb_code,genre_code,nlssort(organ_name,'NLS_SORT=SCHINESE_PINYIN_M')";
		}else{
			sql += " WHERE populace.orgCode='" + parentCode + "'";
			sql += "or populace.PARENT_CODE='" + parentCode + "'";//中心
			
			sql +=" order by org.gb_code,genre_code,nlssort(organ_name,'NLS_SORT=SCHINESE_PINYIN_M')";
		}
		return this.getMapList(sql,new Criteria());
	}

	/**
	 * 健康管理-按中心统计
	 *
	 * @param page
	 * @param year
	 * @param gbCode：镇编码
	 * @param parentCode :中心编码
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public List<Map<String, Object>> getStatisticsCentreResult(String year, String gbCode, String parentCode) {
		String sql = getStatisticsSql(year,OrgGenreCode.CENTRE.getValue());
		
		if(StringUtil.isNotEmpty(parentCode)){
			sql += " WHERE populace.orgCode='" + parentCode + "'";//中心
		}else if(StringUtil.isNotEmpty(gbCode)){
			sql += " WHERE populace.GB_CODE='" + gbCode + "'";//镇
		}
		sql +=" order by org.gb_code,genre_code,nlssort(organ_name,'NLS_SORT=SCHINESE_PINYIN_M')";
		return this.getMapList(sql,new Criteria());
	}

	/**
	 * 综合管理-老年人保健-指标
	 *
	 * @param examYear:体检年份
	 * @param genreCode：机构类型
	 * @param gbCode：镇编码
	 * @param parentCode：中心编码
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getTargetData(Integer examYear,String genreCode,String gbCode,String parentCode){
		StringBuilder sql = new StringBuilder(TARGET_SQL);
		String orgField = "0".equals(genreCode)?"GB_CODE":"ORGAN_CODE";
		StringBuilder whereSQL1 = new StringBuilder(" WHERE TO_CHAR(EXAM_YEAR,'yyyy') ='" + examYear + "'");
		StringBuilder  whereSQL2 = new StringBuilder("WHERE GENRE_CODE = '"+ OrgGenreCode.CENTRE.getValue()+"'");
		if(StringUtil.isNotEmpty(gbCode)){
			whereSQL2.append(" AND GB_CODE ='" + gbCode +  "'");
		}
		if(StringUtil.isNotEmpty(parentCode)){
			whereSQL2.append(" AND ORGAN_CODE='" + parentCode +  "'");
		}		
		String lastSql = String.format(sql.toString(),whereSQL1.toString(),whereSQL2.toString(),orgField);
		return this.getMapList(lastSql,new Criteria());
	}
	
	/**
	 * 综合管理-老年人保健-管理率
	 *
	 * @param examYear:体检年份
	 * @param genreCode：机构类型
	 * @param gbCode：镇编码
	 * @param parentCode：中心编码
	 * @param parentCode：站编码
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> getRateData(Integer examYear,String genreCode,String gbCode,String parentCode,String organCode){
		String sql = getHmStatisticsSql(examYear,genreCode,gbCode,parentCode,organCode);	
		return this.getMapList(sql,new Criteria());		
	}
	
    private String getHmStatisticsSql(Integer examYear,String genreCode,String gbCode,String parentCode,String organCode){
    	StringBuilder sql = new StringBuilder(RATE_SQL);
    	String orgField1 = "";//体检表机构字段
    	String orgField2 = "";//人口基数机构字段
    	StringBuilder whereSQL1 = new StringBuilder();
		StringBuilder  whereSQL2 = new StringBuilder();
    	if(genreCode.equals("0")){//按镇查询
    		orgField1 = "GBCODE";
    		orgField2 = "GB_CODE";
    	}else if(genreCode.equals(OrgGenreCode.CENTRE.getValue())){//按中心查询
    		orgField1 = "INPUT_SUPER_ORGAN_CODE";
    		orgField2 = "PARENT_CODE";
    	}else if (genreCode.equals(OrgGenreCode.STATION.getValue())){//按站查询
    		orgField1 = "INPUT_ORGAN_CODE";
    		orgField2 = "ORGAN_CODE";    		
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		whereSQL1.append(" AND GBCODE='" + gbCode + "'");    
    		whereSQL2.append(" AND org.GB_CODE='" + gbCode + "'");  
    	}
    	if(StringUtil.isNotEmpty(parentCode)){
    		whereSQL1.append(" AND INPUT_SUPER_ORGAN_CODE='" + parentCode + "'");    
    		whereSQL2.append(" AND org.PARENT_CODE='" + parentCode + "'");  
    	}
    	if(StringUtil.isNotEmpty(organCode)){
    		whereSQL1.append(" AND INPUT_ORGAN_CODE='" + organCode + "'");    
    		whereSQL2.append(" AND org.ORGAN_CODE='" + organCode + "'");  
    	}    	
    	return String.format(sql.toString(),orgField1,examYear,orgField2,whereSQL1.toString(),whereSQL2.toString());
    }
}