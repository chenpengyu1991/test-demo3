package com.founder.rhip.ehr.repository.cic;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.cic.CicTarget;

/**
 * @author liuk
 * @since 2014/5/15 14:12
 */
@Repository("cicTargetTaskDao")
public class CicTargetTaskDaoImpl extends AbstractDao<CicTarget, Long> implements ICicTargetTaskDao {
	@Resource(name = "queryJdbcTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public void syncDi(Date start) {
		//@foff
        String sql =
                "MERGE INTO CIC_TARGET H USING (\n" +
                "	SELECT\n" +
                "		PERSON_ID,\n" +
                "		IDCARD\n" +
                "	FROM\n" +
                "		SY_DMD_DM_DISEASE_INFO\n" +
                "	WHERE\n" +
                "		IS_DELETE = '0'\n" +
                "	AND di_Flag = '2'\n" +
                ") D ON (H.PERSON_ID = D.PERSON_ID)\n" +
                "WHEN MATCHED THEN\n" +
                "	UPDATE\n" +
                "SET H.DIABETES_FLAG = 'T',\n" +
                " H.UPDATE_DATE = SYSDATE\n" +
                "WHEN NOT MATCHED THEN\n" +
                "	INSERT (\n" +
                "		PERSON_ID,\n" +
                "		IDCARD,\n" +
                "		DIABETES_FLAG,\n" +
                "		UPDATE_DATE\n" +
                "	)\n" +
                "VALUES\n" +
                "	(\n" +
                "		D.PERSON_ID,\n" +
                "		D.IDCARD,\n" +
                "		'T',\n" +
                "		SYSDATE\n" +
                "	)";
        //@fon
		execute(sql, null);
	}

	@Override
	public void syncAborh(Date start) {
		//@foff
        String sql =
        "MERGE INTO CIC_TARGET H USING (\n" +
                "	SELECT\n" +
                "		ID,\n" +
                "		IDCARD,\n" +
                "		abo_Blood_Type,\n" +
                "		rh_Blood_Type\n" +
                "	FROM\n" +
                "		BI_PERSON_INFO\n" +
                "	WHERE\n" +
                "		FILING_FLAG IN ('1', '2', '3')\n" +
                (start==null? "": "	AND update_date > =:start" )+
                ") D ON (H .PERSON_ID = D . ID)\n" +
                "WHEN MATCHED THEN\n" +
                "	UPDATE\n" +
                "SET H .abo_Code = D .abo_Blood_Type,\n" +
                " H .rh_Code = D .rh_Blood_Type,\n" +
                " H .UPDATE_DATE = SYSDATE\n" +
                "WHEN NOT MATCHED THEN\n" +
                "	INSERT (\n" +
                "		PERSON_ID,\n" +
                "		IDCARD,\n" +
                "		abo_Code,\n" +
                "		rh_Code,\n" +
                "		UPDATE_DATE\n" +
                "	)\n" +
                "VALUES\n" +
                "	(\n" +
                "		D . ID,\n" +
                "		D .IDCARD,\n" +
                "		D .abo_Blood_Type,\n" +
                "		D .rh_Blood_Type,\n" +
                "		SYSDATE\n" +
                "	)";
        //@fon
		MapSqlParameterSource mapSqlParameterSource = null;
		if (null != start) {
			mapSqlParameterSource = new MapSqlParameterSource();
			mapSqlParameterSource.addValue("start", start);
		}
		execute(sql, mapSqlParameterSource);
	}

	@Override
	public void syncIrritability(Date start) {
		//@foff
        String sql =
        "MERGE INTO CIC_TARGET H USING (\n" +
                "	SELECT\n" +
                "		PERSON_ID,\n" +
                "		MAX (IDCARD) IDCARD,\n" +
                "		REPLACE (\n" +
                "			WMSYS.WM_CONCAT (ALLERGENS_NAME),\n" +
                "			',',\n" +
                "			';'\n" +
                "		) AS ALLERGENS\n" +
                "	FROM\n" +
                "		(\n" +
                "			SELECT\n" +
                "				ALLERGENS_NAME || ':' || OTHER_DESC ALLERGENS_NAME,\n" +
                "				PERSON_ID,\n" +
                "				IDCARD\n" +
                "			FROM\n" +
                "				DHS_DRUG_ALLERGY_HISTORY\n" +
                "			WHERE\n" +
                "				ALLERGENS_NAME IS NOT NULL\n" +
                "		) DDAH\n" +
                "	WHERE\n" +
                "		ALLERGENS_NAME IS NOT NULL\n" +
                "	GROUP BY\n" +
                "		PERSON_ID\n" +
                ") D ON (H .PERSON_ID = D .PERSON_ID)\n" +
                "WHEN MATCHED THEN\n" +
                "	UPDATE\n" +
                "SET H .irritability = D .ALLERGENS,\n" +
                " H .UPDATE_DATE = SYSDATE\n" +
                "WHEN NOT MATCHED THEN\n" +
                "	INSERT (\n" +
                "		PERSON_ID,\n" +
                "		IDCARD,\n" +
                "		irritability,\n" +
                "		UPDATE_DATE\n" +
                "	)\n" +
                "VALUES\n" +
                "	(\n" +
                "		D .PERSON_ID,\n" +
                "		D .IDCARD,\n" +
                "		D .ALLERGENS,\n" +
                "		SYSDATE\n" +
                "	)";
        //@fon
		execute(sql, null);
	}

	private void execute(String sql, SqlParameterSource parameterSource) {
		long start = System.currentTimeMillis();
		RuntimeException exception = null;
		try {
			if (null == parameterSource) {
				simpleJdbcTemplate.update(sql);
			} else {
				simpleJdbcTemplate.update(sql, parameterSource);
			}
		} catch (Exception e) {
			exception = new RuntimeException("计算市民卡指标失败", e);
		}
		long time = System.currentTimeMillis() - start;
		logger.info("计算市民卡指标 用时:" + time);

		if (null != exception) {
			logger.error("结果:失败 " + exception);
			throw exception;
		}
		logger.info("结果:成功");
	}
}
