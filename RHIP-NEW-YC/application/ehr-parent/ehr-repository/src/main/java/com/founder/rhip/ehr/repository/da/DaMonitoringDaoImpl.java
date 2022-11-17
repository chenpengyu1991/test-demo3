package com.founder.rhip.ehr.repository.da;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.entity.clinic.*;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Map;

/**
 * DAO implement of 日常监控
 * 
 */
@Repository("daMonitoringDao")
public class DaMonitoringDaoImpl extends AbstractDao<DrugUsage, Long> implements IDaMonitoringDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	/**
	 * 药库入库
	 */
	private static final String DRUG_STORAGE_IN_SQL = "WITH  STORAGE_IN AS ("
			+ "	SELECT	ORGAN_CODE,DRUG_MEDICARE_CODE,SUM(PURCHASE_NUM) purchaseNum"
			+ "		,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME"
			+ "		,0.0 as STORAGE_NUM,0.0 as PHARMACY_NUM, 0.0 as ROOM_NUM"
			+ " FROM("
			+ "			SELECT	STORAGEIN.BATCH_NO,STORAGEIN.ORGAN_CODE,STORAGEIN.STORAGE_DT"
			+ "				,DETAIL.DRUG_MEDICARE_CODE,DETAIL.PURCHASE_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
			+ "			FROM DA_STORAGE_IN_DETAIL DETAIL"
			+ "			LEFT JOIN DA_STORAGE_IN STORAGEIN ON DETAIL.BATCH_NO = STORAGEIN.BATCH_NO"
			+ "			%1$s"
			+ "		)"
			+ "	GROUP BY ORGAN_CODE,DRUG_MEDICARE_CODE)";


	/**
	 * 药库库存
	 */
	private static final String DRUG_STORAGE_SQL = ",DRUG_STORAGE AS ("
			+ "	SELECT	ORGAN_CODE,DRUG_MEDICARE_CODE,SUM(STORAGE_NUM) STORAGE_NUM"
			+ "		,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME"
			+ "		,0.0 as purchaseNum,0.0 as PHARMACY_NUM, 0.0 as ROOM_NUM"
			+ " FROM("
			+ "			SELECT	ORGAN_CODE,DRUG_MEDICARE_CODE,DRUG_GENERIC_NAME,DRUG_TRADE_NAME,STORAGE_NUM"
			+ "			FROM DA_STORAGE"
			+ "			%1$s"
			+ "		)"
			+ "	GROUP BY ORGAN_CODE,DRUG_MEDICARE_CODE)";

	/**
	 * 药房、科室库存
	 */
	private static final String PHARMACY_SQL = ",PHARMACY AS("
			+ "	SELECT	ORGAN_CODE,DRUG_MEDICARE_CODE,SUM(PHARMACY_NUM) PHARMACY_NUM,SUM(ROOM_NUM) ROOM_NUM"
			+ "		,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME"
			+ "		,0.0 as purchaseNum,0.0 as STORAGE_NUM"
			+ " FROM("
			+ "			SELECT ORGAN_CODE,DRUG_MEDICARE_CODE,DRUG_GENERIC_NAME,DRUG_TRADE_NAME"
			+ "				,DECODE(PHARMACY_TYPE_CODE,'1',PHARMACY_NUM,'2',PHARMACY_NUM,0) PHARMACY_NUM"
			+ "				,DECODE(PHARMACY_TYPE_CODE,'3',PHARMACY_NUM,0) ROOM_NUM"
			+ "			FROM DA_PHARMACY"
			+ "			%1$s"
			+ "		)"
			+ "	GROUP BY ORGAN_CODE,DRUG_MEDICARE_CODE)";

	/**
	 * 药品分布监控列表
	 */
	private static final String DISTRIBUTION_SQL = ",DISTRIBUTION AS ("
			+ "	SELECT STORAGE_IN.ORGAN_CODE,STORAGE_IN.DRUG_MEDICARE_CODE,STORAGE_IN.GENERIC_NAME"
			+ "		,STORAGE_IN.TRADE_NAME,STORAGE_IN.purchaseNum,STORAGE_IN.STORAGE_NUM"
			+ "		,STORAGE_IN.PHARMACY_NUM,STORAGE_IN.ROOM_NUM"
			+ "		,0 AS DRUG_TYPE"
			+ "	FROM STORAGE_IN"
			+ "	UNION "
			+ "	SELECT DRUG_STORAGE.ORGAN_CODE,DRUG_STORAGE.DRUG_MEDICARE_CODE"
			+ "		,DRUG_STORAGE.GENERIC_NAME,DRUG_STORAGE.TRADE_NAME"
			+ "		,DRUG_STORAGE.purchaseNum,DRUG_STORAGE.STORAGE_NUM"
			+ "		,DRUG_STORAGE.PHARMACY_NUM,DRUG_STORAGE.ROOM_NUM"
			+ "		,1 AS DRUG_TYPE"
			+ "	FROM DRUG_STORAGE"//药库
			+ "	UNION"
			+ "	SELECT PHARMACY.ORGAN_CODE,PHARMACY.DRUG_MEDICARE_CODE,PHARMACY.GENERIC_NAME"
			+ "		,PHARMACY.TRADE_NAME,PHARMACY.purchaseNum,PHARMACY.STORAGE_NUM"
			+ "		,PHARMACY.PHARMACY_NUM,PHARMACY.ROOM_NUM"
			+ "		,2 AS DRUG_TYPE"
			+ "	FROM PHARMACY"//药房
			+ ")"
			+ "	SELECT ORGAN_CODE organCode,DRUG_MEDICARE_CODE medicareCode"
			+ "		,MAX(GENERIC_NAME) genericName,MAX(TRADE_NAME) tradeName"
			+ "		,SUM(DECODE(DRUG_TYPE,0,PURCHASENUM,0)) purchaseNum"
			+ "		,SUM(DECODE(DRUG_TYPE,1,STORAGE_NUM,0)) storageNum"
			+ "		,SUM(DECODE(DRUG_TYPE,2,PHARMACY_NUM,0)) pharmacyNum"
			+ "		,SUM(DECODE(DRUG_TYPE,2,ROOM_NUM,0)) roomNum"
			+ "	FROM DISTRIBUTION"
			+ "	GROUP BY ORGAN_CODE,DRUG_MEDICARE_CODE"
			+ " ORDER BY ORGAN_CODE,DRUG_MEDICARE_CODE";

	/**
	 * 获取药品分布监控列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	@Override
	public PageList<Map<String, Object>> getDrugDistributionList(Page page, Criteria criteria) {
		StringBuilder sql = new StringBuilder(DRUG_STORAGE_IN_SQL + DRUG_STORAGE_SQL
				+ PHARMACY_SQL + DISTRIBUTION_SQL);
		StringBuilder  totalCostWhereSQL = new StringBuilder();
		SqlBuilder.buildWhereStatement(ExpenseDetail.class, totalCostWhereSQL, criteria);
		String lastSql = String.format(sql.toString(),totalCostWhereSQL.toString());
		return this.getPageMapList(page, lastSql, criteria);
	}
}