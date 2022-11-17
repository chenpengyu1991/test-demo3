package com.founder.rhip.ehr.repository.hsa;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.hsa.InspectionRecord;

/**
 * @author liuk DAO implement of InspectionRecord
 * 
 */
@Repository("hsaInspectionRecordDao")
public class InspectionRecordDaoImpl extends AbstractDao<InspectionRecord, Long> implements IInspectionRecordDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<InspectionRecord> getPageInspectionRecordList(Page page, Criteria criteria) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT *  FROM HSA_INSPECTION_RECORD ");
		SqlBuilder.buildWhereStatement(InspectionRecord.class, sql, criteria);
		// SqlBuilder.buildOrderStatement(sql,
		// "HSA_INSPECTION_RECORD.CREATE_DATE DESC");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public PageList<InspectionRecord> getPagedLocationRecordList(Page page, Criteria criteria) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  HSA_INSPECTION_RECORD.INSP_PERSON_CODE,HSA_INSPECTION_RECORD.SEC_INSP_PERSON_CODE");
		sql.append(",HSA_INSPECTION_RECORD.ID,HSA_INSPECTION_RECORD.INSP_DATE,HSA_INSPECTION_RECORD.IS_GUIDE");
		sql.append(",HSA_INSPECTION_RECORD.IS_REPORT,HSA_INSPECTION_RECORD.INSP_HEALTH_PROFESSIONAL,HSA_INSPECTION_RECORD.FIND_MAIN_PRO");
		sql.append(",HSA_INSPECTION_RECORD.INSP_PERSON_NAME,HSA_INSPECTION_RECORD.SEC_INSP_PERSON_NAME");
		sql.append(",HSA_LOCATION_INFO.UNIT_NAME,HSA_LOCATION_INFO.HEALTH_PROFESSIONAL ");
		sql.append(" FROM HSA_INSPECTION_RECORD");
		sql.append(" INNER JOIN HSA_LOCATION_INFO ON HSA_INSPECTION_RECORD.LOCATION_ID = HSA_LOCATION_INFO.ID ");
		SqlBuilder.buildWhereStatement(InspectionRecord.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, "HSA_INSPECTION_RECORD.UPDATE_DATE DESC ");
		return this.getPageList(page, sql.toString(), criteria);
	}

	@Override
	public List<InspectionRecord> getPagedFamilyRecordList(Page page, Criteria criteria) {
		criteria.add("inspectionRecord.INSP_LOC_TYPE", EHRConstants.INSP_LOC_TYPE_FAMILY);
		StringBuilder sql = new StringBuilder(
				"SELECT familyInfo.id AS FAMILY_ID, familyInfo.PHONE_NUMBER PHONE_NUMBER, familyInfo.HOUSEHOLDER_NAME AS HOUSEHOLDER_NAME, familyInfo.ADDRESS AS ADDRESS, inspectionRecord.INSP_PERSON_CODE,inspectionRecord.SEC_INSP_PERSON_CODE, inspectionRecord.ID,inspectionRecord.INSP_DATE,inspectionRecord.CREATE_ORGAN_CODE,  inspectionRecord.FIND_MAIN_PRO  FROM HSA_FAMILY_INFO familyInfo INNER JOIN HSA_INSPECTION_RECORD inspectionRecord ON familyInfo. ID = inspectionRecord.LOCATION_ID");
		SqlBuilder.buildWhereStatement(InspectionRecord.class, sql, criteria);
		sql.append(" ORDER BY inspectionRecord.UPDATE_DATE DESC ");
		PageList<InspectionRecord> pageList = getPageList(page, sql.toString(), criteria);
		if (null == pageList || null == pageList.getList()) {
			return Collections.emptyList();
		}
		return pageList.getList();
	}
}