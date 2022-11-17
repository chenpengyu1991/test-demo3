package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("doctorSignCensusDao")
public class DoctorSignCensusDaoImpl extends AbstractDao<DoctorSignCensus, Long> implements IDoctorSignCensusDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	// 机构标识
	public static final String ORG_CODE = "orgCode";
	public static final String CENTER_ORG_CODE = "centerOrgCode";
	public static final String GBCODE = "gbcode";

	private static final String DOCTOR_TEAM_NUM_SQL = "SELECT ORGAN_CODE ORG_CODE, COUNT(1) DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM SY_FDS_TEAM " +
			" WHERE SY_FDS_TEAM.valid = 1 %s GROUP BY SY_FDS_TEAM.ORGAN_CODE";

	private static final String BI_POPULACE_SQL = "SELECT ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, SUM(NVL(HOUSEHOLD_NUM, 0)) HOUSEHOLD_NUM, SUM(NVL(HOUSEHOLD_NUM, 0) + NVL(UN_HOUSE_HOLD_NUM, 0)) PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, SUM(NVL(HOUSEHOLD_PHB_NUM, 0) + NVL(UNHOUSEHOLD_PHB_NUM, 0)) HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, SUM(NVL(HOUSEHOLD_DI_NUM, 0) + NVL(UNHOUSEHOLD_DI_NUM, 0)) DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM BI_POPULACE " +
			" WHERE 1 = 1 %s GROUP BY ORGAN_CODE";

	private static final String PERMANENT_SIGN_NUM_SQL = "SELECT ORGAN_CODE ORG_CODE,0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, COUNT(1) PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM SY_FDS_SIGN_PERSON " +
			" WHERE VALID = '1' AND RESCIND_FLAG = '0'  AND PAID_FLAG = '1' %s GROUP BY ORGAN_CODE";

	private static final String FOCUS_GROUPS_NUM_SQL = "SELECT INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, COUNT(DISTINCT ID) FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM\n" +
			"FROM (\n" +
			"    SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"    FROM BI_PERSON_INFO\n" +
			"    WHERE %1$s - TO_CHAR(BI_PERSON_INFO.BIRTHDAY, 'yyyy') < 7 AND FILING_FLAG = '1' " +
			"    UNION ALL\n" +
			"    SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"    FROM BI_PERSON_INFO\n" +
			"    WHERE TO_CHAR(BI_PERSON_INFO.BIRTHDAY, 'YYYY') <= %1$s - 65\n" +
			"    UNION ALL\n" +
			"    SELECT BI_PERSON_INFO.ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"    FROM BI_PERSON_INFO LEFT JOIN SY_MS_WH_PRENATAL_FOLLOWUP ON SY_MS_WH_PRENATAL_FOLLOWUP.PERSON_ID = BI_PERSON_INFO.ID WHERE 1 = 1 %2$s \n" +
			"    UNION ALL\n" +
			"    SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"    FROM BI_PERSON_INFO\n" +
			"    WHERE EXISTS(select person_id\n" +
			"                from DM_DISEASE_INFO D\n" +
			"                where D.HBP_FLAG = 2\n" +
			"                  AND D.STATUS = 1\n" +
			"                  AND BI_PERSON_INFO.ID = D.PERSON_ID %3$s) %4$s \n" +
			"    UNION ALL\n" +
			"    SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"    FROM BI_PERSON_INFO\n" +
			"    WHERE EXISTS(select person_id\n" +
			"                from DM_DISEASE_INFO D\n" +
			"                where D.DI_FLAG = 2\n" +
			"                  AND D.STATUS = 1\n" +
			"                  AND BI_PERSON_INFO.ID = D.PERSON_ID %5$s) %6$s\n" +
			"    UNION ALL\n" +
			"    SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"    FROM BI_PERSON_INFO\n" +
			"    WHERE EXISTS(select dh.person_id\n" +
			"                from DHS_DISEASE_HISTORY dh\n" +
			"                where dh.DISEASE_CODE = '208'\n" +
			"                  and dh.person_id = BI_PERSON_INFO.ID %7$s)\n" +
			"    UNION ALL\n" +
			"    SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"    FROM BI_PERSON_INFO\n" +
			"    WHERE EXISTS(select dh.person_id\n" +
			"                from DHS_DISEASE_HISTORY dh\n" +
			"                where dh.DISEASE_CODE = '207'\n" +
			"                  and dh.person_id = BI_PERSON_INFO.ID %8$s)\n" +
			"    ) T GROUP BY INPUT_ORGAN_CODE";

	private static final String FOCUS_GROUPS_SIGN_NUM_SQL = "SELECT T.INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, COUNT(DISTINCT T.ID) FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM\n" +
			"FROM (\n" +
			"         SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"         FROM BI_PERSON_INFO\n" +
			"         WHERE %1$s - TO_CHAR(BI_PERSON_INFO.BIRTHDAY, 'yyyy') < 7 AND FILING_FLAG = '1' " +
			"         UNION ALL\n" +
			"         SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"         FROM BI_PERSON_INFO\n" +
			"         WHERE TO_CHAR(BI_PERSON_INFO.BIRTHDAY, 'YYYY') <= %1$s - 65\n" +
			"         UNION ALL\n" +
			"         SELECT BI_PERSON_INFO.ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"         FROM BI_PERSON_INFO LEFT JOIN SY_MS_WH_PRENATAL_FOLLOWUP ON SY_MS_WH_PRENATAL_FOLLOWUP.PERSON_ID = BI_PERSON_INFO.ID WHERE 1 = 1 %2$s " +
			"         UNION ALL\n" +
			"         SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"         FROM BI_PERSON_INFO\n" +
			"         WHERE EXISTS(select person_id\n" +
			"                      from DM_DISEASE_INFO D\n" +
			"                      where D.HBP_FLAG = 2\n" +
			"                        AND D.STATUS = 1\n" +
			"                        AND BI_PERSON_INFO.ID = D.PERSON_ID %3$s) %4$s\n" +
			"         UNION ALL\n" +
			"         SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"         FROM BI_PERSON_INFO\n" +
			"         WHERE EXISTS(select person_id\n" +
			"                      from DM_DISEASE_INFO D\n" +
			"                      where D.DI_FLAG = 2\n" +
			"                        AND D.STATUS = 1\n" +
			"                        AND BI_PERSON_INFO.ID = D.PERSON_ID %5$s) %6$s\n" +
			"         UNION ALL\n" +
			"         SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"         FROM BI_PERSON_INFO\n" +
			"         WHERE EXISTS(select dh.person_id\n" +
			"                      from DHS_DISEASE_HISTORY dh\n" +
			"                      where dh.DISEASE_CODE = '208'\n" +
			"                        and dh.person_id = BI_PERSON_INFO.ID %7$s)\n" +
			"         UNION ALL\n" +
			"         SELECT ID, IDCARD, INPUT_ORGAN_CODE\n" +
			"         FROM BI_PERSON_INFO\n" +
			"         WHERE EXISTS(select dh.person_id\n" +
			"                      from DHS_DISEASE_HISTORY dh\n" +
			"                      where dh.DISEASE_CODE = '207'\n" +
			"                        and dh.person_id = BI_PERSON_INFO.ID %8$s)\n" +
			"     ) T LEFT JOIN SY_FDS_SIGN_PERSON ON T.IDCARD = SY_FDS_SIGN_PERSON.IDCARD\n" +
			" WHERE SY_FDS_SIGN_PERSON.VALID = '1'\n" +
			"  AND SY_FDS_SIGN_PERSON.RESCIND_FLAG = '0'\n" +
			"  AND SY_FDS_SIGN_PERSON.PAID_FLAG = '1' %9$s GROUP BY T.INPUT_ORGAN_CODE";

	private static final String CHILD_NUM_SQL = "SELECT INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, COUNT(ID) CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM BI_PERSON_INFO\n" +
			" WHERE %1$s - TO_CHAR(BI_PERSON_INFO.BIRTHDAY, 'yyyy') < 7 AND FILING_FLAG = '1' GROUP BY INPUT_ORGAN_CODE";

	private static final String FAMILY_VISIT_NUM_SQL = "SELECT BI_PERSON_INFO.INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM,  COUNT(DISTINCT BI_PERSON_INFO.ID) FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM CHILD_HEALTH_EXAMINATION LEFT JOIN BI_PERSON_INFO ON BI_PERSON_INFO.ID = CHILD_HEALTH_EXAMINATION.PERSON_ID AND  (BI_PERSON_INFO.IDCARD IS NOT NULl OR BI_PERSON_INFO.BABY_CARD_NO IS NOT NULL) " +
			" WHERE %1$s - TO_CHAR(BI_PERSON_INFO.BIRTHDAY, 'yyyy') < 7 AND FILING_FLAG = '1' " +
			" AND CHILD_HEALTH_EXAMINATION.IS_DELETE IS NULL\n" +
			" GROUP BY BI_PERSON_INFO.INPUT_ORGAN_CODE";

	private static final String CHILD_SIGN_NUM_SQL = "SELECT BI_PERSON_INFO.INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM BI_PERSON_INFO LEFT JOIN SY_FDS_SIGN_PERSON ON BI_PERSON_INFO.IDCARD = SY_FDS_SIGN_PERSON.IDCARD AND BI_PERSON_INFO.IDCARD IS NOT NULl " +
			" WHERE %1$s - TO_CHAR(BI_PERSON_INFO.BIRTHDAY, 'yyyy') < 7 AND FILING_FLAG = '1' " +
			" AND SY_FDS_SIGN_PERSON.VALID = '1'  AND SY_FDS_SIGN_PERSON.RESCIND_FLAG = '0' AND SY_FDS_SIGN_PERSON.PAID_FLAG = '1' %2$s GROUP BY BI_PERSON_INFO.INPUT_ORGAN_CODE";

	private static final String HOUSEHOLD_GREAT_SIXF_NUM_SQL = "SELECT INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM BI_PERSON_INFO" +
			" WHERE TO_CHAR(BI_PERSON_INFO.BIRTHDAY, 'YYYY') <= %1$s - 65 GROUP BY INPUT_ORGAN_CODE ";

	private static final String GREAT_SIXF_HAS_NUM_SQL = "SELECT EXAMINATION_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, COUNT(DISTINCT PERSON_ID) GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM ECH_ELDERLY_PHY_STATUS " +
			" WHERE 1 = 1 %1$s GROUP BY EXAMINATION_ORGAN_CODE";

	private static final String GREAT_SIXF_SIGN_NUM_SQL = "SELECT BI_PERSON_INFO.INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM BI_PERSON_INFO LEFT JOIN SY_FDS_SIGN_PERSON ON BI_PERSON_INFO.IDCARD = SY_FDS_SIGN_PERSON.IDCARD AND BI_PERSON_INFO.IDCARD IS NOT NULL " +
			" WHERE TO_CHAR(BI_PERSON_INFO.BIRTHDAY, 'YYYY') <= %1$s - 65\n" +
			" AND SY_FDS_SIGN_PERSON.VALID = '1' AND SY_FDS_SIGN_PERSON.RESCIND_FLAG = '0' AND SY_FDS_SIGN_PERSON.PAID_FLAG = '1' %2$s GROUP BY BI_PERSON_INFO.INPUT_ORGAN_CODE";

	private static final String WOMEN_NUM_SQL = "SELECT INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM " +
			" FROM BI_PERSON_INFO LEFT JOIN SY_MS_WH_PRENATAL_FOLLOWUP ON SY_MS_WH_PRENATAL_FOLLOWUP.PERSON_ID = BI_PERSON_INFO.ID WHERE 1 = 1 %1$s GROUP BY INPUT_ORGAN_CODE ";

	private static final String WOMEN_SIGN_NUM_SQL = "SELECT BI_PERSON_INFO.INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM BI_PERSON_INFO LEFT JOIN SY_MS_WH_PRENATAL_FOLLOWUP ON SY_MS_WH_PRENATAL_FOLLOWUP.PERSON_ID = BI_PERSON_INFO.ID LEFT JOIN SY_FDS_SIGN_PERSON ON BI_PERSON_INFO.IDCARD = SY_FDS_SIGN_PERSON.IDCARD AND BI_PERSON_INFO.IDCARD IS NOT NULL " +
			" WHERE 1 = 1 %1$s " +
			" AND SY_FDS_SIGN_PERSON.VALID = '1' AND SY_FDS_SIGN_PERSON.RESCIND_FLAG = '0' AND SY_FDS_SIGN_PERSON.PAID_FLAG = '1' %2$s GROUP BY BI_PERSON_INFO.INPUT_ORGAN_CODE";

	private static final String HBP_HAS_NUM_SQL = "SELECT INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM " +
			"FROM BI_PERSON_INFO WHERE EXISTS(SELECT PERSON_ID FROM DM_DISEASE_INFO D WHERE D.HBP_FLAG = 2 AND D.STATUS = 1 AND BI_PERSON_INFO.ID = D.PERSON_ID %1$s) %2$s GROUP BY INPUT_ORGAN_CODE ";

	private static final String HBP_SIGN_NUM_SQL = "SELECT BI_PERSON_INFO.INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM BI_PERSON_INFO LEFT JOIN SY_FDS_SIGN_PERSON ON BI_PERSON_INFO.IDCARD = SY_FDS_SIGN_PERSON.IDCARD AND BI_PERSON_INFO.IDCARD IS NOT NULL\n" +
			" WHERE EXISTS(SELECT PERSON_ID FROM DM_DISEASE_INFO D WHERE D.HBP_FLAG = 2 AND D.STATUS = 1 AND BI_PERSON_INFO.ID = D.PERSON_ID %1$s) " +
			" AND SY_FDS_SIGN_PERSON.VALID = '1' AND SY_FDS_SIGN_PERSON.RESCIND_FLAG = '0' AND SY_FDS_SIGN_PERSON.PAID_FLAG = '1' %2$s GROUP BY BI_PERSON_INFO.INPUT_ORGAN_CODE";

	private static final String DI_HAS_NUM_SQL = "SELECT INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM " +
			"FROM BI_PERSON_INFO WHERE EXISTS(SELECT PERSON_ID FROM DM_DISEASE_INFO D WHERE D.DI_FLAG = 2 AND D.STATUS = 1 AND BI_PERSON_INFO.ID = D.PERSON_ID %1$s) GROUP BY INPUT_ORGAN_CODE ";

	private static final String DI_SIGN_NUM_SQL = "SELECT BI_PERSON_INFO.INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM BI_PERSON_INFO LEFT JOIN SY_FDS_SIGN_PERSON ON BI_PERSON_INFO.IDCARD = SY_FDS_SIGN_PERSON.IDCARD AND BI_PERSON_INFO.IDCARD IS NOT NULL " +
			" WHERE EXISTS(SELECT PERSON_ID FROM DM_DISEASE_INFO D WHERE D.DI_FLAG = 2 AND D.STATUS = 1 AND BI_PERSON_INFO.ID = D.PERSON_ID %1$s) " +
			" AND SY_FDS_SIGN_PERSON.VALID = '1' AND SY_FDS_SIGN_PERSON.RESCIND_FLAG = '0' AND SY_FDS_SIGN_PERSON.PAID_FLAG = '1' %2$s GROUP BY BI_PERSON_INFO.INPUT_ORGAN_CODE";

	private static final String TUBERC_MANAGE_NUM_SQL = "SELECT INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM\n" +
			" FROM BI_PERSON_INFO WHERE EXISTS(SELECT DH.PERSON_ID FROM DHS_DISEASE_HISTORY DH WHERE DH.DISEASE_CODE = '208' and DH.PERSON_ID = BI_PERSON_INFO.ID %1$s) %2$s GROUP BY INPUT_ORGAN_CODE";

	private static final String TUBERC_SIGN_NUM_SQL = "SELECT BI_PERSON_INFO.INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM FROM BI_PERSON_INFO LEFT JOIN SY_FDS_SIGN_PERSON ON BI_PERSON_INFO.IDCARD = SY_FDS_SIGN_PERSON.IDCARD AND BI_PERSON_INFO.IDCARD IS NOT NULL " +
			" WHERE EXISTS(select DH.PERSON_ID from DHS_DISEASE_HISTORY DH where DH.DISEASE_CODE = '208' and DH.PERSON_ID = BI_PERSON_INFO.ID %1$s) " +
			" AND SY_FDS_SIGN_PERSON.VALID = '1' AND SY_FDS_SIGN_PERSON.RESCIND_FLAG = '0' AND SY_FDS_SIGN_PERSON.PAID_FLAG = '1' %2$s GROUP BY BI_PERSON_INFO.INPUT_ORGAN_CODE";

	private static final String MENTAL_MANAGE_NUM_SQL = "SELECT INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) MENTAL_MANAGE_NUM, 0 MENTAL_SIGN_NUM " +
			" FROM BI_PERSON_INFO WHERE EXISTS(select DH.PERSON_ID from DHS_DISEASE_HISTORY DH where DH.DISEASE_CODE = '207' and DH.PERSON_ID = BI_PERSON_INFO.ID %1$s) %2$s GROUP BY INPUT_ORGAN_CODE";

	private static final String MENTAL_SIGN_NUM_SQL = "SELECT BI_PERSON_INFO.INPUT_ORGAN_CODE ORG_CODE, 0 DOCTOR_TEAM_NUM, 0 HOUSEHOLD_NUM, 0 PERMANENT_NUM, 0 PERMANENT_SIGN_NUM, 0 FOCUS_GROUPS_NUM, 0 FOCUS_GROUPS_SIGN_NUM, 0 CHILD_NUM, 0 FAMILY_VISIT_NUM, 0 CHILD_SIGN_NUM, 0 HOUSEHOLD_GREAT_SIXF_NUM, 0 GREAT_SIXF_HAS_NUM, 0 GREAT_SIXF_SIGN_NUM, 0 WOMEN_NUM, 0 WOMEN_SIGN_NUM, 0 HBP_NUM, 0 HBP_HAS_NUM, 0 HBP_SIGN_NUM, 0 DI_NUM, 0 DI_HAS_NUM, 0 DI_SIGN_NUM, 0 TUBERC_MANAGE_NUM, 0 TUBERC_SIGN_NUM, 0 MENTAL_MANAGE_NUM, COUNT(DISTINCT BI_PERSON_INFO.ID) MENTAL_SIGN_NUM FROM BI_PERSON_INFO LEFT JOIN SY_FDS_SIGN_PERSON ON BI_PERSON_INFO.IDCARD = SY_FDS_SIGN_PERSON.IDCARD AND BI_PERSON_INFO.IDCARD IS NOT NULL\n" +
			" WHERE EXISTS(select DH.PERSON_ID from DHS_DISEASE_HISTORY DH where DH.DISEASE_CODE = '207' and DH.PERSON_ID = BI_PERSON_INFO.ID %1$s) " +
			" AND SY_FDS_SIGN_PERSON.VALID = '1' AND SY_FDS_SIGN_PERSON.RESCIND_FLAG = '0' AND SY_FDS_SIGN_PERSON.PAID_FLAG = '1' %2$s GROUP BY BI_PERSON_INFO.INPUT_ORGAN_CODE";


	private void builDSSql(Criteria criteria, StringBuilder finalSql, List<String> list) {
		StringBuilder sqlb = new StringBuilder();
		for(String sql :list){
			if(sqlb.length()==0){
				sqlb.append("(").append(sql);
			}else{
				sqlb.append(" UNION ALL ").append(sql);
			}
		}
		sqlb.append(")");
			
		finalSql.append("SELECT V.GB_CODE GB_CODE,V.ORGAN_CODE ORG_CODE," +
				" NVL(DI_NUM, 0) DI_NUM, NVL(HBP_NUM, 0) HBP_NUM , " +
				"NVL(HBP_HAS_NUM, 0) HBP_HAS_NUM, NVL(DI_HAS_NUM, 0) DI_HAS_NUM" +
				", NVL(HBP_SIGN_NUM, 0) HBP_SIGN_NUM," +
				" NVL(FOCUS_GROUPS_NUM, 0) FOCUS_GROUPS_NUM," +
				" NVL(FOCUS_GROUPS_SIGN_NUM, 0) FOCUS_GROUPS_SIGN_NUM," +
				" NVL(DI_SIGN_NUM, 0) DI_SIGN_NUM, " +
				"NVL(HOUSEHOLD_NUM, 0) HOUSEHOLD_NUM, NVL(PERMANENT_NUM, 0) PERMANENT_NUM," +
				" NVL(PERMANENT_SIGN_NUM, 0) PERMANENT_SIGN_NUM, NVL(FAMILY_VISIT_NUM, 0) FAMILY_VISIT_NUM," +
				" NVL(CHILD_NUM, 0) CHILD_NUM, NVL(HOUSEHOLD_GREAT_SIXF_NUM, 0) HOUSEHOLD_GREAT_SIXF_NUM, " +
				"NVL(GREAT_SIXF_HAS_NUM, 0) GREAT_SIXF_HAS_NUM, NVL(WOMEN_NUM, 0) WOMEN_NUM, " +
				"NVL(CHILD_SIGN_NUM, 0) CHILD_SIGN_NUM," +
				" NVL(GREAT_SIXF_SIGN_NUM, 0) GREAT_SIXF_SIGN_NUM, NVL(WOMEN_SIGN_NUM, 0) WOMEN_SIGN_NUM, " +
				"NVL(DOCTOR_TEAM_NUM, 0) DOCTOR_TEAM_NUM, NVL(TUBERC_MANAGE_NUM, 0) TUBERC_MANAGE_NUM, " +
				"NVL(MENTAL_MANAGE_NUM, 0) MENTAL_MANAGE_NUM," +
				" NVL(TUBERC_SIGN_NUM, 0) TUBERC_SIGN_NUM, NVL(MENTAL_SIGN_NUM, 0) MENTAL_SIGN_NUM " +
				" FROM mdm_organization V LEFT JOIN (")
				
		.append("SELECT ORG_CODE,")
		.append(" NVL(SUM(DI_NUM), 0) DI_NUM, " +
				" NVL(SUM(HBP_NUM), 0) HBP_NUM, " +
				" NVL(SUM(HBP_HAS_NUM), 0) HBP_HAS_NUM, " +
				" NVL(SUM(DI_HAS_NUM),0) DI_HAS_NUM, " +
				" NVL(SUM(HBP_SIGN_NUM),0) HBP_SIGN_NUM, " +
				" NVL(SUM(FOCUS_GROUPS_NUM),0) FOCUS_GROUPS_NUM, " +
				" NVL(SUM(FOCUS_GROUPS_SIGN_NUM),0) FOCUS_GROUPS_SIGN_NUM, " +

				" NVL(SUM(DI_SIGN_NUM),0) DI_SIGN_NUM, " +
				" NVL(SUM(HOUSEHOLD_NUM),0) HOUSEHOLD_NUM, " +
				" NVL(SUM(PERMANENT_NUM),0) PERMANENT_NUM, " +
				" NVL(SUM(PERMANENT_SIGN_NUM),0) PERMANENT_SIGN_NUM, " +
				" NVL(SUM(FAMILY_VISIT_NUM),0) FAMILY_VISIT_NUM, " +
				
				" NVL(SUM(CHILD_NUM),0) CHILD_NUM, " +
				" NVL(SUM(HOUSEHOLD_GREAT_SIXF_NUM),0) HOUSEHOLD_GREAT_SIXF_NUM, " +
				" NVL(SUM(GREAT_SIXF_HAS_NUM),0) GREAT_SIXF_HAS_NUM, " +
				" NVL(SUM(WOMEN_NUM),0) WOMEN_NUM, " +
				" NVL(SUM(CHILD_SIGN_NUM),0) CHILD_SIGN_NUM, " +
				
				" NVL(SUM(GREAT_SIXF_SIGN_NUM),0) GREAT_SIXF_SIGN_NUM, " +
				" NVL(SUM(WOMEN_SIGN_NUM),0) WOMEN_SIGN_NUM, " +
				" NVL(SUM(DOCTOR_TEAM_NUM),0) DOCTOR_TEAM_NUM, " +
				" NVL(SUM(TUBERC_MANAGE_NUM),0) TUBERC_MANAGE_NUM, " +
				" NVL(SUM(MENTAL_MANAGE_NUM),0) MENTAL_MANAGE_NUM, " +
				
				" NVL(SUM(TUBERC_SIGN_NUM),0) TUBERC_SIGN_NUM, " +
				" NVL(SUM(MENTAL_SIGN_NUM),0) MENTAL_SIGN_NUM " +
				
				" FROM  ").append(sqlb).append(" GROUP BY ORG_CODE ) T ON V.ORGAN_CODE=T.ORG_CODE WHERE 1=1 %s ORDER BY V.ORGAN_CODE,V.ORGAN_NAME");
	}

	@Override
	public List<DoctorSignCensus> getDoctorSignCensusList(Criteria criteria,
			List<String> organCodeList) {
		
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year=(String)criteria.get("year");
		
		StringBuilder finalSql = new StringBuilder();
		List<String> sqlList = new ArrayList<>();
		MapSqlParameterSource parameterMap = new MapSqlParameterSource();
		//常驻人口
		Map<String, Object> populaceMap = SqlBuilder.buildOrganCondition("ORGAN_CODE","COUNT_YEAR", null, null, orgCode, year, null, organCodeList, parameterMap, 3);
		String sql = String.format(BI_POPULACE_SQL, populaceMap.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//已建家医团队
		Map<String, Object> doctorTeamMap = SqlBuilder.buildOrganCondition("ORGAN_CODE","CREATE_DATE", null, null, orgCode, year,  month, organCodeList, parameterMap, 5);
		sql = String.format(DOCTOR_TEAM_NUM_SQL, doctorTeamMap.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//签约人
		Map<String, Object> premanentMap = SqlBuilder.buildOrganCondition("ORGAN_CODE","SIGN_TIME", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(PERMANENT_SIGN_NUM_SQL, premanentMap.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//儿童
		sql = String.format(CHILD_NUM_SQL, year);
		sqlList.add(sql);
		sql = String.format(FAMILY_VISIT_NUM_SQL, year);
		sqlList.add(sql);
		Map<String, Object> childMap = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","SIGN_TIME", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(CHILD_SIGN_NUM_SQL, year, childMap.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//老年人
		sql = String.format(HOUSEHOLD_GREAT_SIXF_NUM_SQL, year);
		sqlList.add(sql);
		Map<String, Object> sixfMap = SqlBuilder.buildOrganCondition("EXAMINATION_ORGAN_CODE","EXAMINATION_DATE", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(GREAT_SIXF_HAS_NUM_SQL, sixfMap.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		Map<String, Object> sixfMap2 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","SIGN_TIME", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(GREAT_SIXF_SIGN_NUM_SQL, year, sixfMap2.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//孕产妇
		Map<String, Object> womenMap = buildOrganRange("BI_PERSON_INFO.INPUT_ORGAN_CODE","ESTIMATED_DUE_DATES", null, null, orgCode, year,  month, organCodeList, parameterMap);
		sql = String.format(WOMEN_NUM_SQL, womenMap.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		Map<String, Object> womenMap2 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","SIGN_TIME", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(WOMEN_SIGN_NUM_SQL, womenMap.get(SqlBuilder.WHERE), womenMap2.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//高血压
		Map<String, Object> hbpMap = SqlBuilder.buildOrganCondition("","HBP_DIAGNOSED_DATE", null, null, null, year,  month, null, parameterMap, 5);
		Map<String, Object> hbpMap2 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","", null, null, orgCode, null,  null, organCodeList, parameterMap, 1);
		sql = String.format(HBP_HAS_NUM_SQL, hbpMap.get(SqlBuilder.WHERE), hbpMap2.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		Map<String, Object> hbpMap3 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","SIGN_TIME", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(HBP_SIGN_NUM_SQL, hbpMap.get(SqlBuilder.WHERE), hbpMap3.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//糖尿病
		Map<String, Object> diMap = SqlBuilder.buildOrganCondition("","DI_DIAGNOSED_DATE", null, null, null, year,  month, null, parameterMap, 5);
		Map<String, Object> diMap2 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","", null, null, orgCode, null,  null, organCodeList, parameterMap, 1);
		sql = String.format(DI_HAS_NUM_SQL, diMap.get(SqlBuilder.WHERE), diMap2.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		Map<String, Object> diMap3 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","SIGN_TIME", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(DI_SIGN_NUM_SQL, diMap.get(SqlBuilder.WHERE), diMap3.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//肺结核
		Map<String, Object> tubercMap = SqlBuilder.buildOrganCondition("","DH.CONFIRMATION_DATE", null, null, null, year,  month, null, parameterMap, 5);
		Map<String, Object> tubercMap2 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","", null, null, orgCode, null,  null, organCodeList, parameterMap, 1);
		sql = String.format(TUBERC_MANAGE_NUM_SQL, tubercMap.get(SqlBuilder.WHERE), tubercMap2.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		Map<String, Object> tubercMap3 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","SIGN_TIME", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(TUBERC_SIGN_NUM_SQL, tubercMap.get(SqlBuilder.WHERE), tubercMap3.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//精神健康
		Map<String, Object> mentalMap = SqlBuilder.buildOrganCondition("","DH.CONFIRMATION_DATE", null, null, null, year,  month, null, parameterMap, 5);
		Map<String, Object> mentalMap2 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","", null, null, orgCode, null,  null, organCodeList, parameterMap, 1);
		sql = String.format(MENTAL_MANAGE_NUM_SQL, mentalMap.get(SqlBuilder.WHERE), mentalMap2.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		Map<String, Object> mentalMap3 = SqlBuilder.buildOrganCondition("BI_PERSON_INFO.INPUT_ORGAN_CODE","SIGN_TIME", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(MENTAL_SIGN_NUM_SQL, mentalMap.get(SqlBuilder.WHERE), mentalMap3.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		//重点人群
		sql = String.format(FOCUS_GROUPS_NUM_SQL, year, womenMap.get(SqlBuilder.WHERE), hbpMap.get(SqlBuilder.WHERE), hbpMap2.get(SqlBuilder.WHERE), diMap.get(SqlBuilder.WHERE), diMap2.get(SqlBuilder.WHERE), tubercMap.get(SqlBuilder.WHERE), mentalMap.get(SqlBuilder.WHERE));
		sqlList.add(sql);
		Map<String, Object> focusMap = SqlBuilder.buildOrganCondition("T.INPUT_ORGAN_CODE","SIGN_TIME", null, null, orgCode, year,  month, organCodeList, parameterMap, 1);
		sql = String.format(FOCUS_GROUPS_SIGN_NUM_SQL, year, womenMap.get(SqlBuilder.WHERE), hbpMap.get(SqlBuilder.WHERE), hbpMap2.get(SqlBuilder.WHERE), diMap.get(SqlBuilder.WHERE), diMap2.get(SqlBuilder.WHERE), tubercMap.get(SqlBuilder.WHERE), mentalMap.get(SqlBuilder.WHERE), focusMap.get(SqlBuilder.WHERE));
		sqlList.add(sql);

		Map<String, Object> finalMap = SqlBuilder.buildOrganCondition("V.ORGAN_CODE",null, null, null, orgCode, null, null, organCodeList, parameterMap, 0);
		
		builDSSql(criteria, finalSql, sqlList);
		return getList(DoctorSignCensus.class, String.format(finalSql.toString(), finalMap.get(SqlBuilder.WHERE)), (MapSqlParameterSource) finalMap.get(SqlBuilder.SOURCE));
	}

	private static Map<String, Object> buildOrganRange(String orgCodeColumn, String yearColumn, String quarterColumn, String manageColumn
			, String orgCode, String year, String month, List<String> organCodeList
			, MapSqlParameterSource sqlParameterSource) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuilder where = new StringBuilder();
		if (ObjectUtil.isNotEmpty(orgCode) && organCodeList == null) {
			where.append(" AND ").append(orgCodeColumn).append(" =:createOrgCode");
			sqlParameterSource.addValue("createOrgCode", orgCode);
		} else {
			if (ObjectUtil.isNotEmpty(organCodeList)) {
				where.append(" AND ").append(orgCodeColumn).append(" IN(:createOrgCode)");
				sqlParameterSource.addValue("createOrgCode", organCodeList);
			}
		}

		if (ObjectUtil.isNotEmpty(year) == true && ObjectUtil.isNotEmpty(month) == true && Integer.parseInt(month) != 0) {
			List<String> date = new ArrayList<>();

			if ("01".equals(month) || "1".equals(month)) {
				date.add(year + "0101");
				date.add(year + "0331");
			} else if ("02".equals(month) || "2".equals(month)) {
				date.add(year + "0401");
				date.add(year + "0630");
			} else if ("03".equals(month) || "3".equals(month)) {
				date.add(year + "0701");
				date.add(year + "0930");
			} else {
				date.add(year + "1001");
				date.add(year + "1231");
			}
			if ("ESTIMATED_DUE_DATES".equals(yearColumn)) {
				where.append(" AND (TO_CHAR(").append("ADD_MONTHS(ESTIMATED_DUE_DATES , -10)").append(", 'YYYYMMDD')").append(" <=:day2");
				sqlParameterSource.addValue("day1", date.get(0));
				where.append(" AND TO_CHAR(").append("ESTIMATED_DUE_DATES").append(", 'YYYYMMDD')").append(" >=:day1 )");
				sqlParameterSource.addValue("day2", date.get(1));
			} else {
				where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" >=:day1");
				sqlParameterSource.addValue("day1", date.get(0));
				where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day2");
				sqlParameterSource.addValue("day2", date.get(1));
			}

		} else if (ObjectUtil.isNotEmpty(year) == true) {
			List<String> date = new ArrayList<>();
			if ("ESTIMATED_DUE_DATES".equals(yearColumn)) {
				date.add(year + "0101");
				date.add(year + "1231");
				where.append(" AND (TO_CHAR(").append("ADD_MONTHS(ESTIMATED_DUE_DATES , -10)").append(", 'YYYYMMDD')").append(" <=:day2");
				sqlParameterSource.addValue("day1", date.get(0));
				where.append(" AND TO_CHAR(").append("ESTIMATED_DUE_DATES").append(", 'YYYYMMDD')").append(" >=:day1 )");
				sqlParameterSource.addValue("day2", date.get(1));
			}else {
				where.append(" AND  TO_CHAR(").append(yearColumn).append(", 'YYYY')").append(" =:year");
				sqlParameterSource.addValue("year", year);
			}
		}
		map.put("where", where.toString());
		map.put("source", sqlParameterSource);
		return map;
	}
}
