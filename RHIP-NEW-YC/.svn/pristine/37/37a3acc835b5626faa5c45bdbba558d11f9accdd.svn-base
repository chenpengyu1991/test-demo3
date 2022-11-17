package com.founder.rhip.ehr.repository.summary;
import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.management.DmPotentialPersonInfo;
import com.founder.rhip.ehr.entity.summary.FamilyHistory;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;

import javax.annotation.Resource;

/**
 * DAO implement of FamilyHistory
 * 
 */
@Repository("familyHistoryDao")
public class FamilyHistoryDaoImpl extends AbstractDao<FamilyHistory, String> implements IFamilyHistoryDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<FamilyHistory> getCdmHistoryInfo(Criteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT "+
						" BI_PERSON_INFO.NAME AS PATIENT_NAME,"+
						" BI_PERSON_INFO.GENDER AS PATIENT_SEX,"+
						" BI_PERSON_INFO.BIRTHDAY AS INPUT_DATE,"+
					    " BI_PERSON_INFO.IDCARD ,"+
						" BI_PERSON_INFO.ID AS PERSON_ID,"+
						" A.DISEASE_CODE "+
					" FROM"+
						" BI_PERSON_INFO "+
							" INNER JOIN (SELECT"+
											" DHS_FAMILY_HISTORY.PERSON_ID,"+
											" DHS_FAMILY_HISTORY.DISEASE_CODE"+
										" FROM"+
											" DHS_FAMILY_HISTORY "+
										" WHERE");
		if(!ObjectUtil.isNullOrEmpty(criteria.get("hbpCode"))){
			sql.append( " DHS_FAMILY_HISTORY.DISEASE_CODE =:hbpCode");
		}else if(!ObjectUtil.isNullOrEmpty(criteria.get("diCode"))){
			sql.append( " DHS_FAMILY_HISTORY.DISEASE_CODE =:diCode");
		}else if(!ObjectUtil.isNullOrEmpty(criteria.get("diseaseCode"))){
			sql.append( " DHS_FAMILY_HISTORY.DISEASE_CODE =:hbpCode  or  DHS_FAMILY_HISTORY.DISEASE_CODE =:diCode");
		}
		sql.append( " GROUP BY DHS_FAMILY_HISTORY.PERSON_ID,	DHS_FAMILY_HISTORY.DISEASE_CODE "+
							" )" +
							" A" + 
							" ON BI_PERSON_INFO.ID=A.PERSON_ID"+
					      " WHERE"+ 
					              " TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BI_PERSON_INFO.BIRTHDAY,'YYYY')>=:startAge"+ 
					          " AND"+ 
				          		  " TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(BI_PERSON_INFO.BIRTHDAY,'YYYY')<=:endAge" 
					          );
		return this.getList(sql.toString(),criteria);
	}
    
}