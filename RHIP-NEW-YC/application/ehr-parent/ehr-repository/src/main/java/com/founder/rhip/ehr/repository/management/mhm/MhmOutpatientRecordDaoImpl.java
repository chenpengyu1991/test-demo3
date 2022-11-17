package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmOutpatientRecord;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of MhmOutpatientRecord
 * 
 */
@Repository("mhmOutpatientRecordDao")
public class MhmOutpatientRecordDaoImpl extends AbstractDao<MhmOutpatientRecord, Long> implements IMhmOutpatientRecordDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public List<MhmOutpatientRecord> getOutPatientRecords (Criteria criteria){
        StringBuilder sql = new StringBuilder("SELECT O.OUTPATIENT_DT,\n" +
                "       O.OUTPATIENT_ORGAN,\n" +
                "       O.OUTPATIENT_NO,\n" +
                "       O.DIAGNOSIS_RESULT,\n" +
                "       O.DIAGNOSIS_DOCTOR\n" +
                "  FROM MHM_OUTPATIENT_RECORD O, MHM_EVENT_INFO E\n" +
                "  WHERE E.ID = O.EVENT_ID AND ");
        sql.append(criteria.toSql(ClassMetadata.getMetadata(MhmOutpatientRecord.class), ":").toString());
        sql.append(" ORDER BY O.OUTPATIENT_DT DESC ");
        return getList(sql.toString(), criteria);
    }
}