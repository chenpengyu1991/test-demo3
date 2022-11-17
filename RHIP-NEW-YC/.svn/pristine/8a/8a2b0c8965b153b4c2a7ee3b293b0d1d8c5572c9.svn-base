package com.founder.rhip.ehr.repository.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RpQueryConditionHelper;
import com.founder.rhip.ehr.entity.report.RpHealthyPhysicalExam;
import com.founder.rhip.ehr.entity.report.RpInpatientMedicalRecord;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("rpInpatientMedicalRecordDao")
public class RpInpatientMedicalRecordDaoImpl extends AbstractDao<RpInpatientMedicalRecord, Long> implements IRpInpatientMedicalRecordDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	private static final String HEALTHY_PHYSICAL_EXAM_PA_STATISTICS_SQL = "SELECT ORGAN_CODE, TRUNC(GATHER_DATE) GATHER_DATE, SUM(FEE_ALL) FEE_ALL, SUM(PATHOLOGY_FEE) PATHOLOGY_FEE, SUM(LAB_FEE) LAB_FEE, SUM(IMG_FEE) IMG_FEE, SUM(CLINICAL_FEE) CLINICAL_FEE, SUM(ONE_A) ONE_A, SUM(ONE_B) ONE_B, SUM(ONE_C) ONE_C, SUM(TWO_A) TWO_A, SUM(TWO_B) TWO_B, SUM(TWO_C) TWO_C, SUM(THREE_A) THREE_A, SUM(THREE_B) THREE_B, SUM(THREE_C) THREE_C" +
			" FROM (SELECT HOSPITAL_CODE               ORGAN_CODE," +
			" OUT_HOSPITAL_DATE           GATHER_DATE," +
			" ADMISSION_TOTAL_AMOUNT      FEE_ALL," +
			" PATHOLOGY_DIAGNOSIS_EXPENSE PATHOLOGY_FEE," +
			" LAB_DIAGNOSIS_EXPENSE       LAB_FEE," +
			" IMAGING_DIAGNOSIS_EXPENSE   IMG_FEE," +
			" CLINICAL_ITEM_EXPENSE       CLINICAL_FEE," +
			" 0                           ONE_A," +
			" 0                           ONE_B," +
			" 0                           ONE_C," +
			" 0                           TWO_A," +
			" 0                           TWO_B," +
			" 0                           TWO_C," +
			" 0                           THREE_A," +
			" 0                           THREE_B," +
			" 0                           THREE_C" +
			" FROM MS_INPATIENT_MEDICAL_RECORD@DL_MS MR WHERE %1$s " +
			" UNION ALL" +
			" SELECT HOSPITAL_CODE                                         ORGAN_CODE," +
			" OPERTATION_DATE                                       GATHER_DATE," +
			" 0                                                     FEE_ALL," +
			" 0                                                     PATHOLOGY_FEE," +
			" 0                                                     LAB_FEE," +
			" 0                                                     IMG_FEE," +
			" 0                                                     CLINICAL_FEE," +
			" DECODE(SURGERY.INCISION_HEALING_GRADE_CODE, '1', NUM) ONE_A," +
			" DECODE(SURGERY.INCISION_HEALING_GRADE_CODE, '2', NUM) ONE_B," +
			" DECODE(SURGERY.INCISION_HEALING_GRADE_CODE, '3', NUM) ONE_C," +
			" DECODE(SURGERY.INCISION_HEALING_GRADE_CODE, '4', NUM) TWO_A," +
			" DECODE(SURGERY.INCISION_HEALING_GRADE_CODE, '5', NUM) TWO_B," +
			" DECODE(SURGERY.INCISION_HEALING_GRADE_CODE, '6', NUM) TWO_C," +
			" DECODE(SURGERY.INCISION_HEALING_GRADE_CODE, '7', NUM) THREE_A," +
			" DECODE(SURGERY.INCISION_HEALING_GRADE_CODE, '8', NUM) THREE_B," +
			" DECODE(SURGERY.INCISION_HEALING_GRADE_CODE, '9', NUM) THREE_C" +
			" FROM (SELECT HOSPITAL_CODE, OPERTATION_DATE, INCISION_HEALING_GRADE_CODE, COUNT(ID) NUM" +
			" FROM MS_SURGERY_INFO@DL_MS WHERE %2$s " +
			" GROUP BY HOSPITAL_CODE, INCISION_HEALING_GRADE_CODE, OPERTATION_DATE ) SURGERY) res" +
			" GROUP BY ORGAN_CODE, TRUNC(GATHER_DATE)";

	@Override
	public List<RpInpatientMedicalRecord> getInpatientMedicalRecordList(String startDate, String endDate) {
		Criteria criteria = new Criteria();
		String sql = "";
		String dateMrSql = "TRUNC(MR.OUT_HOSPITAL_DATE) = TRUNC(SYSDATE - 2)";
		String dateSuSql = "TRUNC(OPERTATION_DATE) = TRUNC(SYSDATE - 2)";
		if (ObjectUtil.isNotEmpty(startDate)){
			if (ObjectUtil.isNotEmpty(endDate)){
				dateMrSql = " TRUNC(MR.OUT_HOSPITAL_DATE) >= TRUNC(TO_DATE('" + startDate + "','yyyy/mm/dd')) AND TRUNC(MR.OUT_HOSPITAL_DATE) <= TRUNC(TO_DATE('" + endDate + "','yyyy/mm/dd'))";
				dateSuSql = " TRUNC(OPERTATION_DATE) >= TRUNC(TO_DATE('" + startDate + "','yyyy/mm/dd')) AND TRUNC(OPERTATION_DATE) <= TRUNC(TO_DATE('" + endDate + "','yyyy/mm/dd'))";
			}else {
				dateMrSql = " TRUNC(MR.OUT_HOSPITAL_DATE) = TRUNC(TO_DATE('" + startDate + "','yyyy/mm/dd')) ";
				dateSuSql = " TRUNC(OPERTATION_DATE) = TRUNC(TO_DATE('" + startDate + "','yyyy/mm/dd')) ";
			}
		}
		sql = String.format(HEALTHY_PHYSICAL_EXAM_PA_STATISTICS_SQL, dateMrSql, dateSuSql);
		return getList(sql, criteria);
	}
}
