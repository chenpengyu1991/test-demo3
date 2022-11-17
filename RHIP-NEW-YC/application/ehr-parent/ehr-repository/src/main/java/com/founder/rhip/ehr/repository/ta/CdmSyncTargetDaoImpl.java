package com.founder.rhip.ehr.repository.ta;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author liuk
 * @since 2014/5/26 16:33
 */
@Repository("cdmSyncTargetDao")
public class CdmSyncTargetDaoImpl extends AbstractDao<Long,PersonInfo>  implements ICdmSyncTargetDao {
    @Resource(name = "queryJdbcTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public void syncFollowup(Date start) {
        //@foff
        String hbpSql =
                "MERGE INTO DHS_TARGET_RESULT_VALUE H USING (\n" +
                        "	SELECT\n" +
                        "		D.PERSON_ID,\n" +
                        "		D.SBP,\n" +
                        "		D.DBP,\n" +
                        "		D.VISIT_DATE,\n" +
                        "		D.CREATE_ORGAN_CODE,\n" +
                        "		D.CREATE_DOCTOR_CODE,\n" +
                        "		D.ID\n" +
                        "	FROM\n" +
                        "		DM_HYPERTENSION_FOLLOWUP D\n" +
                        ") D ON (H.PERSON_ID = D.PERSON_ID AND H.TYPE_CATEGORY=1 AND H.TYPE_CATEGORY_SUB_ID=D.ID )\n" +
                        "WHEN MATCHED THEN\n" +
                        "	UPDATE\n" +
                        "SET \n" +
                        "		H.VALUE_A=D.SBP,\n" +
                        "		H.VALUE_B=D.DBP,\n" +
                        "		H.CREATE_ORGAN_CODE=D.CREATE_ORGAN_CODE,\n" +
                        "		H.CREATE_DATE=D.VISIT_DATE,\n" +
                        "		H.CREATE_USER_CODE=D.CREATE_DOCTOR_CODE,\n" +
                        "		H.IS_DELETE=0\n" +
                        "WHEN NOT MATCHED THEN\n" +
                        "	INSERT (\n" +
                        "		PERSON_ID,\n" +
                        "		VALUE_A,\n" +
                        "		VALUE_B,\n" +
                        "		CREATE_DATE,\n" +
                        "		CREATE_ORGAN_CODE,\n" +
                        "		CREATE_USER_CODE,\n" +
                        "		IS_DELETE,\n" +
                        "		TYPE_CATEGORY,\n" +
                        "		TYPE_CATEGORY_SUB_ID,\n" +
                        "		TYPE\n" +
                        "	)\n" +
                        "VALUES\n" +
                        "	(\n" +
                        "		D.PERSON_ID,\n" +
                        "		D.SBP,\n" +
                        "		D.DBP,\n" +
                        "		D.VISIT_DATE,\n" +
                        "		D.CREATE_ORGAN_CODE,\n" +
                        "		D.CREATE_DOCTOR_CODE,\n" +
                        "		0,\n" +
                        "		1,\n" +
                        "		D.ID,\n" +
                        "		'高血压随访'\n" +
                        "	)\n" ;
                String diSql =
                        "MERGE INTO DHS_TARGET_RESULT_VALUE H USING (\n" +
                        "	SELECT\n" +
                        "		D.PERSON_ID,\n" +
                        "		D.SBP,\n" +
                        "		D.DBP,\n" +
                        "		D.FPG,\n" +
                        "		D.VISIT_DATE,\n" +
                        "		D.CREATE_ORGAN_CODE,\n" +
                        "		D.CREATE_DOCTOR_CODE,\n" +
                        "		D.ID\n" +
                        "	FROM\n" +
                        "		DM_DIABETIC_FOLLOWUP D\n" +
                        ") D ON (H.PERSON_ID = D.PERSON_ID AND H.TYPE_CATEGORY=2 AND H.TYPE_CATEGORY_SUB_ID=D.ID )\n" +
                        "WHEN MATCHED THEN\n" +
                        "	UPDATE\n" +
                        "SET \n" +
                        "		H.VALUE_A=D.SBP,\n" +
                        "		H.VALUE_B=D.DBP,\n" +
                        "		H.VALUE_C=D.FPG,\n" +
                        "		H.CREATE_ORGAN_CODE=D.CREATE_ORGAN_CODE,\n" +
                        "		H.CREATE_DATE=D.VISIT_DATE,\n" +
                        "		H.CREATE_USER_CODE=D.CREATE_DOCTOR_CODE,\n" +
                        "		H.IS_DELETE=0\n" +
                        "WHEN NOT MATCHED THEN\n" +
                        "	INSERT (\n" +
                        "		PERSON_ID,\n" +
                        "		VALUE_A,\n" +
                        "		VALUE_B,\n" +
                        "		VALUE_C,\n" +
                        "		CREATE_DATE,\n" +
                        "		CREATE_ORGAN_CODE,\n" +
                        "		CREATE_USER_CODE,\n" +
                        "		IS_DELETE,\n" +
                        "		TYPE_CATEGORY,\n" +
                        "		TYPE_CATEGORY_SUB_ID,\n" +
                        "		TYPE\n" +
                        "	)\n" +
                        "VALUES\n" +
                        "	(\n" +
                        "		D.PERSON_ID,\n" +
                        "		D.SBP,\n" +
                        "		D.DBP,\n" +
                        "		D.FPG,\n" +
                        "		D.VISIT_DATE,\n" +
                        "		D.CREATE_ORGAN_CODE,\n" +
                        "		D.CREATE_DOCTOR_CODE,\n" +
                        "		0,\n" +
                        "		2,\n" +
                        "		D.ID,\n" +
                        "		'糖尿病随访'\n" +
                        "	)\n" ;
                       String strokeSql =
                        "MERGE INTO DHS_TARGET_RESULT_VALUE H USING (\n" +
                        "	SELECT\n" +
                        "		D.PERSON_ID,\n" +
                        "		D.SBP,\n" +
                        "		D.DBP,\n" +
                        "		D.FPG,\n" +
                        "		D.GLU_VALUE,\n" +
                        "		D.VISIT_DATE,\n" +
                        "		D.CREATE_ORGAN_CODE,\n" +
                        "		D.CREATE_DOCTOR_CODE,\n" +
                        "		D.ID\n" +
                        "	FROM\n" +
                        "		DM_STRTUM_FOLLOWUP D WHERE DISEASE_TYPE=3\n" +
                        ") D ON (H.PERSON_ID = D.PERSON_ID AND H.TYPE_CATEGORY=3 AND H.TYPE_CATEGORY_SUB_ID=D.ID )\n" +
                        "WHEN MATCHED THEN\n" +
                        "	UPDATE\n" +
                        "SET \n" +
                        "		H.VALUE_A=D.SBP,\n" +
                        "		H.VALUE_B=D.DBP,\n" +
                        "		H.VALUE_C=D.FPG,\n" +
                        "		H.VALUE_D=D.GLU_VALUE,\n" +
                        "		H.CREATE_ORGAN_CODE=D.CREATE_ORGAN_CODE,\n" +
                        "		H.CREATE_DATE=D.VISIT_DATE,\n" +
                        "		H.CREATE_USER_CODE=D.CREATE_DOCTOR_CODE,\n" +
                        "		H.IS_DELETE=0\n" +
                        "WHEN NOT MATCHED THEN\n" +
                        "	INSERT (\n" +
                        "		PERSON_ID,\n" +
                        "		VALUE_A,\n" +
                        "		VALUE_B,\n" +
                        "		VALUE_C,\n" +
                        "		VALUE_D,\n" +
                        "		CREATE_DATE,\n" +
                        "		CREATE_ORGAN_CODE,\n" +
                        "		CREATE_USER_CODE,\n" +
                        "		IS_DELETE,\n" +
                        "		TYPE_CATEGORY,\n" +
                        "		TYPE_CATEGORY_SUB_ID,\n" +
                        "		TYPE\n" +
                        "	)\n" +
                        "VALUES\n" +
                        "	(\n" +
                        "		D.PERSON_ID,\n" +
                        "		D.SBP,\n" +
                        "		D.DBP,\n" +
                        "		D.FPG,\n" +
                        "		D.GLU_VALUE,\n" +
                        "		D.VISIT_DATE,\n" +
                        "		D.CREATE_ORGAN_CODE,\n" +
                        "		D.CREATE_DOCTOR_CODE,\n" +
                        "		0,\n" +
                        "		3,\n" +
                        "		D.ID,\n" +
                        "		'脑卒中随访'\n" +
                        "	)\n" ;
                      String coronarySql =
                        "MERGE INTO DHS_TARGET_RESULT_VALUE H USING (\n" +
                        "	SELECT\n" +
                        "		D.PERSON_ID,\n" +
                        "		D.SBP,\n" +
                        "		D.DBP,\n" +
                        "		D.FPG,\n" +
                        "		D.GLU_VALUE,\n" +
                        "		D.VISIT_DATE,\n" +
                        "		D.CREATE_ORGAN_CODE,\n" +
                        "		D.CREATE_DOCTOR_CODE,\n" +
                        "		D.ID\n" +
                        "	FROM\n" +
                        "		DM_STRTUM_FOLLOWUP D WHERE DISEASE_TYPE=4\n" +
                        ") D ON (H.PERSON_ID = D.PERSON_ID AND H.TYPE_CATEGORY=4 AND H.TYPE_CATEGORY_SUB_ID=D.ID )\n" +
                        "WHEN MATCHED THEN\n" +
                        "	UPDATE\n" +
                        "SET \n" +
                        "		H.VALUE_A=D.SBP,\n" +
                        "		H.VALUE_B=D.DBP,\n" +
                        "		H.VALUE_C=D.FPG,\n" +
                        "		H.VALUE_D=D.GLU_VALUE,\n" +
                        "		H.CREATE_ORGAN_CODE=D.CREATE_ORGAN_CODE,\n" +
                        "		H.CREATE_DATE=D.VISIT_DATE,\n" +
                        "		H.CREATE_USER_CODE=D.CREATE_DOCTOR_CODE,\n" +
                        "		H.IS_DELETE=0\n" +
                        "WHEN NOT MATCHED THEN\n" +
                        "	INSERT (\n" +
                        "		PERSON_ID,\n" +
                        "		VALUE_A,\n" +
                        "		VALUE_B,\n" +
                        "		VALUE_C,\n" +
                        "		VALUE_D,\n" +
                        "		CREATE_DATE,\n" +
                        "		CREATE_ORGAN_CODE,\n" +
                        "		CREATE_USER_CODE,\n" +
                        "		IS_DELETE,\n" +
                        "		TYPE_CATEGORY,\n" +
                        "		TYPE_CATEGORY_SUB_ID,\n" +
                        "		TYPE\n" +
                        "	)\n" +
                        "VALUES\n" +
                        "	(\n" +
                        "		D.PERSON_ID,\n" +
                        "		D.SBP,\n" +
                        "		D.DBP,\n" +
                        "		D.FPG,\n" +
                        "		D.GLU_VALUE,\n" +
                        "		D.VISIT_DATE,\n" +
                        "		D.CREATE_ORGAN_CODE,\n" +
                        "		D.CREATE_DOCTOR_CODE,\n" +
                        "		0,\n" +
                        "		4,\n" +
                        "		D.ID,\n" +
                        "		'冠心病随访'\n" +
                        "	)";

        MapSqlParameterSource mapSqlParameterSource = null;
        if (null != start) {
            mapSqlParameterSource = new MapSqlParameterSource();
            mapSqlParameterSource.addValue("start", start);
        }

        //@fon
        execute(diSql, mapSqlParameterSource,"糖尿病");
        execute(hbpSql, mapSqlParameterSource,"高血压");
        execute(strokeSql, mapSqlParameterSource,"脑卒中");
        execute(coronarySql, mapSqlParameterSource,"冠心病");
    }

    private void execute(String sql, SqlParameterSource parameterSource,String type) {
        long start = System.currentTimeMillis();
        RuntimeException exception = null;
        try {
            if (null == parameterSource) {
                simpleJdbcTemplate.update(sql);
            } else {
                simpleJdbcTemplate.update(sql, parameterSource);
            }
        } catch (Exception e) {
            exception = new RuntimeException(type+"同步指标失败", e);
        }
        long time = System.currentTimeMillis() - start;
        logger.info(type+"同步指标 用时:" + time);

        if (null != exception) {
            logger.error("结果:失败 " + exception);
            throw exception;
        }
        logger.info("结果:成功");
    }
}
