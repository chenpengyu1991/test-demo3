package com.founder.rhip.ehr.repository.nc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;

/**
 * @author liuk
 * @since 14-3-19 下午3:48
 */

@Repository("ncDataDao")
public class NcDataDaoImpl extends AbstractDao<PersonInfo, Long> implements INcDataDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	private Map<String, String> insertSqlCache = null;
	private Map<String, String> clearSqlCache = null;

	@PostConstruct
	public void init() {
		insertSqlCache = new HashMap<>(9);
		clearSqlCache = new HashMap<>(9);

		// --1献血量 NC_BLOOD_DONATION
		insertSqlCache.put("NC_BLOOD_DONATION", "INSERT INTO NC_BLOOD_DONATION (PERSON_NAME,ID_CARD,WHOLE_BLOOD,OPERATE_DATE) SELECT PERSON_NAME,ID_CARD,WHOLE_BLOOD,OPERATE_DATE FROM V_NC_BLOOD_DONATION");
		clearSqlCache.put("NC_BLOOD_DONATION", "DELETE FROM NC_BLOOD_DONATION");

		// --2献血小板量 NC_PLATELETS
		insertSqlCache.put("NC_PLATELETS", "INSERT INTO NC_PLATELETS (PERSON_NAME,ID_CARD,PLATELETS,OPERATE_DATE) SELECT PERSON_NAME,ID_CARD,PLATELETS,OPERATE_DATE FROM V_NC_PLATELETS");
		clearSqlCache.put("NC_PLATELETS", "DELETE FROM NC_PLATELETS");

		// --3早孕是否建卡 NC_PERINATAL_CARD
		insertSqlCache.put("NC_PERINATAL_CARD", "INSERT INTO NC_PERINATAL_CARD (PERSON_NAME,ID_CARD,CREATE_DT) SELECT PERSON_NAME,ID_CARD,CREATE_DT FROM V_NC_PERINATAL_CARD");
		clearSqlCache.put("NC_PERINATAL_CARD", "DELETE FROM NC_PERINATAL_CARD");

		// --4产前检查5次 NC_PRENATAL_EXAMINATION
		insertSqlCache.put("NC_PRENATAL_EXAMINATION", "INSERT INTO NC_PRENATAL_EXAMINATION (PERSON_NAME,ID_CARD,EXAMINATION_DT) SELECT PERSON_NAME,ID_CARD,EXAMINATION_DT FROM V_NC_PRENATAL_EXAMINATION");
		clearSqlCache.put("NC_PRENATAL_EXAMINATION", "DELETE FROM NC_PRENATAL_EXAMINATION");

		// ---5儿童检查 NC_CHILD_EXAMINATION
		insertSqlCache.put("NC_CHILD_EXAMINATION", "INSERT INTO NC_CHILD_EXAMINATION (PERSON_NAME,ID_CARD,IS_REGULAR) SELECT PERSON_NAME,ID_CARD,IS_REGULAR FROM V_NC_CHILD_EXAMINATION");
		clearSqlCache.put("NC_CHILD_EXAMINATION", "DELETE FROM NC_CHILD_EXAMINATION");

		// --6健康证 NC_HEALTH_CERTIFICATE
		insertSqlCache.put("NC_HEALTH_CERTIFICATE", "INSERT INTO NC_HEALTH_CERTIFICATE (PERSON_NAME,ID_CARD,ISSUE_DATE,IS_ISSUED) SELECT PERSON_NAME,ID_CARD,ISSUE_DATE,IS_ISSUED FROM V_NC_HEALTH_CERTIFICATE");
		clearSqlCache.put("NC_HEALTH_CERTIFICATE", "DELETE FROM NC_HEALTH_CERTIFICATE");

		// --7行政处罚 NC_PUNISHMENT
		insertSqlCache.put("NC_PUNISHMENT", "INSERT INTO NC_PUNISHMENT  (PERSON_NAME,ID_CARD,PUNISHED_DATE,PUNISHED_TIMES) SELECT PERSON_NAME,ID_CARD,PUNISHED_DATE,PUNISHED_TIMES FROM V_NC_PUNISHMENT");
		clearSqlCache.put("NC_PUNISHMENT", "DELETE FROM NC_PUNISHMENT");

		// --8三星档案 NC_HEALTH_RECORDS
		insertSqlCache.put("NC_HEALTH_RECORDS", "INSERT INTO NC_HEALTH_RECORDS  (PERSON_NAME,ID_CARD,IS_COMPLETE) SELECT PERSON_NAME,ID_CARD,IS_COMPLETE FROM V_NC_HEALTH_RECORDS");
		clearSqlCache.put("NC_HEALTH_RECORDS", "DELETE FROM NC_HEALTH_RECORDS");

		for (Map.Entry<String, String> entry : insertSqlCache.entrySet()) {
			if (!clearSqlCache.containsKey(entry.getKey())) {
				throw new RuntimeException("删除sql配置错误!,缺少" + entry.getKey());
			}
		}

	}

	@Override
	public void dealNcData(String type) {
		List<String> result = new ArrayList<>(9);
		if (null == type) {
			for (Map.Entry<String, String> entry : insertSqlCache.entrySet()) {
				String sql = entry.getValue();
				if (null != sql) {
					String clearSql = clearSqlCache.get(entry.getKey());
					execute(entry.getKey(), clearSql, sql, result);
				}
			}
		} else {
			String sql = insertSqlCache.get(type);
			if (null != sql) {
				String clearSql = clearSqlCache.get(type);
				execute(type, clearSql, sql, result);
			}
		}

		if (result.size() > 0) {
			throw new RuntimeException("以下表数据插入失败" + result);
		}

	}

	private void execute(String type, String clearSql, String sql, List<String> result) {
		try {
			this.simpleJdbcTemplate.update(clearSql);
			this.simpleJdbcTemplate.update(sql);
		} catch (Exception e) {
			result.add(type);
			logger.error("数据插入失败", e);
		}
	}

}
