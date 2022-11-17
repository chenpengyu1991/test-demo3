package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.clinic.Pharmacy;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;

import javax.annotation.Resource;

/**
 * DAO implement of 基药管理
 * 
 */
@Repository("daTargetDao")
public class DaTargetDaoImpl extends	AbstractDao<Pharmacy, Long> implements IDaTargetDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


    /**
     * 库存入库
     */
    private static final String STORAGE_IN_SQL = "SELECT %1$s,MAX(DRUG_GENERIC_NAME) MEDICARE_NAME,DRUG_MEDICARE_CODE ,SUM(PURCHASE_NUM) storageInNum FROM ("//入库数量
    		+ " SELECT STORAGEIN.BATCH_NO,STORAGEIN.%1$s,STORAGEIN.SEARCH_DT,"
    		+ " DETAIL.DRUG_MEDICARE_CODE,DETAIL.PURCHASE_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
    		+ " FROM DA_STORAGE_IN_DETAIL DETAIL"
    		+ " LEFT JOIN  "
    		+ " (SELECT BATCH_NO,ORG_TYPE,GBCODE,SUP_ORGAN_CODE,ORGAN_CODE,STORAGE_DT SEARCH_DT FROM DA_STORAGE_IN) STORAGEIN"
    		+ " ON DETAIL.BATCH_NO = STORAGEIN.BATCH_NO"
    		+ " %2$s"//条件
    		+ " )GROUP BY %1$s,DRUG_MEDICARE_CODE ) A";
    
    /**
     * 库存出库
     */
    private static final String STORAGE_OUT_SQL = "SELECT %1$s,MAX(DRUG_GENERIC_NAME) MEDICARE_NAME,DRUG_MEDICARE_CODE ,SUM(APPLY_REAL_NUM) storageOutNum FROM ("//出库数量
    		+ " SELECT STORAGEOUT.BATCH_NO,STORAGEOUT.%1$s,STORAGEOUT.SEARCH_DT,"
    		+ " DETAIL.DRUG_MEDICARE_CODE,DETAIL.APPLY_REAL_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
    		+ " FROM DA_STORAGE_OUT_DETAIL DETAIL"
    		+ " LEFT JOIN "
    		+ " (SELECT BATCH_NO,ORG_TYPE,GBCODE,SUP_ORGAN_CODE,ORGAN_CODE,DELIVERY_DT SEARCH_DT FROM DA_STORAGE_OUT) STORAGEOUT"
    		+ " ON DETAIL.BATCH_NO = STORAGEOUT.BATCH_NO"
    		+ " %2$s"//条件
    		+ " )GROUP BY %1$s,DRUG_MEDICARE_CODE ) B";  
    
    /**
     * 药房入库
     */
    private static final String DA_PHARMACY_IN_SQL = "SELECT %1$s,MAX(DRUG_GENERIC_NAME) MEDICARE_NAME,DRUG_MEDICARE_CODE ,SUM(PURCHASE_NUM) pharmacyInNum FROM ("//入库数量
    		+ " SELECT PHARMACYIN.BATCH_NO,PHARMACYIN.%1$s,PHARMACYIN.SEARCH_DT,"
    		+ " DETAIL.DRUG_MEDICARE_CODE,DETAIL.PURCHASE_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
    		+ " FROM DA_PHARMACY_IN_DETAIL DETAIL"
    		+ " LEFT JOIN"
    		+ " (SELECT BATCH_NO,ORG_TYPE,GBCODE,SUP_ORGAN_CODE,ORGAN_CODE,PHARMACY_DT SEARCH_DT FROM DA_PHARMACY_IN) PHARMACYIN"
    		+ " ON DETAIL.BATCH_NO = PHARMACYIN.BATCH_NO"
    		+ " %2$s"//条件
    		+ " )GROUP BY %1$s,DRUG_MEDICARE_CODE ) C"; 
    
    /**
     * 药房出库
     */
    private static final String DA_PHARMACY_OUT_SQL = "SELECT %1$s,MAX(DRUG_GENERIC_NAME) MEDICARE_NAME,DRUG_MEDICARE_CODE,SUM(APPLY_REAL_NUM) pharmacyOutNum FROM ("//出库数量
    		+ " SELECT PHARMACYOUT.BATCH_NO,PHARMACYOUT.%1$s,PHARMACYOUT.SEARCH_DT,"
    		+ " DETAIL.DRUG_MEDICARE_CODE,DETAIL.APPLY_REAL_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
    		+ " FROM DA_PHARMACY_OUT_DETAIL DETAIL"
    		+ " LEFT JOIN"
    		+ " (SELECT BATCH_NO,ORG_TYPE,GBCODE,SUP_ORGAN_CODE,ORGAN_CODE,DELIVERY_DT SEARCH_DT FROM DA_PHARMACY_OUT) PHARMACYOUT"
    		+ " ON DETAIL.BATCH_NO = PHARMACYOUT.BATCH_NO"
    		+ " %2$s"//条件
    		+ " )GROUP BY %1$s,DRUG_MEDICARE_CODE ) D";
    
    /**
     * 药库库存
     */
    private static final String DA_STORAGE_SQL = " SELECT %1$s,MAX(DRUG_GENERIC_NAME) MEDICARE_NAME,DRUG_MEDICARE_CODE,SUM(STORAGE_NUM) storageNum FROM ("
    		+ " SELECT %1$s,DRUG_MEDICARE_CODE,DRUG_GENERIC_NAME,DRUG_TRADE_NAME,STORAGE_NUM"
    		+ " FROM DA_STORAGE "
    		+ " %2$s "
    		+ " )GROUP BY %1$s,DRUG_MEDICARE_CODE ) E";
    
    /**
     * 药房、科室库存
     */
    private static final String DA_PHARMACY_SQL = " SELECT %1$s,MAX(DRUG_GENERIC_NAME) MEDICARE_NAME,DRUG_MEDICARE_CODE,SUM(PHARMACY_NUM) pharmacyNum,SUM(ROOM_NUM) roomNum FROM ("
    		+ " SELECT %1$s,DRUG_MEDICARE_CODE,DRUG_GENERIC_NAME,DRUG_TRADE_NAME"
    		+ " ,DECODE(PHARMACY_TYPE_CODE,1,PHARMACY_NUM,2,PHARMACY_NUM,0) PHARMACY_NUM"//药房库存
    		+ " ,DECODE(PHARMACY_TYPE_CODE,3,0) ROOM_NUM"//科室库存
    		+ " FROM DA_PHARMACY"
    		+ " %2$s "
    		+ " )GROUP BY %1$s,DRUG_MEDICARE_CODE ) F";   
    
 
    /**
     * 药库入库
     */
    private static final String DRUG_STORAGE_IN_SQL = "WITH  STORAGE_IN AS ("
    		+ "	SELECT	%1$s,DRUG_MEDICARE_CODE,SUM(PURCHASE_NUM) STORAGE_IN_NUM"
    		+ "		,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME"
    		+ "		,0.0 as STORAGE_OUT_NUM,0.0 as PHARMACY_IN_NUM, 0.0 as PHARMACY_OUT_NUM"
    		+ " FROM("
    		+ "		SELECT	STORAGEIN.%1$s,STORAGEIN.BATCH_NO,STORAGEIN.SEARCH_DT"
    		+ "				,DETAIL.DRUG_MEDICARE_CODE,DETAIL.PURCHASE_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
    		+ "		FROM DA_STORAGE_IN_DETAIL DETAIL"
    		+ "		LEFT JOIN (SELECT BATCH_NO,ORG_TYPE,GBCODE,SUP_ORGAN_CODE,ORGAN_CODE,STORAGE_DT SEARCH_DT FROM DA_STORAGE_IN) STORAGEIN"
	    	+ " 	ON DETAIL.BATCH_NO = STORAGEIN.BATCH_NO"	
    		+ "		%2$s"
    		+ "	)"
    		+ "	GROUP BY %1$s,DRUG_MEDICARE_CODE)";
    
    /**
     * 药库出库
     */
    private static final String DRUG_STORAGE_OUT_SQL = ",STORAGE_OUT AS ("
    		+ "	SELECT	%1$s,DRUG_MEDICARE_CODE,SUM(APPLY_REAL_NUM) STORAGE_OUT_NUM"
    		+ "		,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME"
    		+ "		,0.0 as STORAGE_IN_NUM,0.0 as PHARMACY_IN_NUM, 0.0 as PHARMACY_OUT_NUM"
    		+ " FROM("
    		+ "		SELECT	STORAGEOUT.%1$s,STORAGEOUT.BATCH_NO,STORAGEOUT.SEARCH_DT"
    		+ "			,DETAIL.DRUG_MEDICARE_CODE,DETAIL.APPLY_REAL_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
    		+ "		FROM DA_STORAGE_OUT_DETAIL DETAIL"
    		+ "		LEFT JOIN  (SELECT BATCH_NO,ORG_TYPE,GBCODE,SUP_ORGAN_CODE,ORGAN_CODE,DELIVERY_DT SEARCH_DT FROM DA_STORAGE_OUT)  STORAGEOUT"
    		+ "     ON DETAIL.BATCH_NO = STORAGEOUT.BATCH_NO"
    		+ "		%2$s"
    		+ "	)"
    		+ "	GROUP BY %1$s,DRUG_MEDICARE_CODE)";

    /**
     * 药房入库
     */
    private static final String DRUG_PHARMACY_IN_SQL = ",PHARMACY_IN AS ("
    		+ "	SELECT	%1$s,DRUG_MEDICARE_CODE,SUM(PURCHASE_NUM) PHARMACY_IN_NUM"
    		+ "		,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME"
    		+ "		,0.0 as STORAGE_OUT_NUM,0.0 as STORAGE_IN_NUM, 0.0 as PHARMACY_OUT_NUM"
    		+ " FROM("
    		+ "		SELECT	PHARMACYIN.%1$s,PHARMACYIN.BATCH_NO,PHARMACYIN.SEARCH_DT"
    		+ "			,DETAIL.DRUG_MEDICARE_CODE,DETAIL.PURCHASE_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
    		+ "		FROM DA_PHARMACY_IN_DETAIL DETAIL"
    		+ "		LEFT JOIN  (SELECT BATCH_NO,ORG_TYPE,GBCODE,SUP_ORGAN_CODE,ORGAN_CODE,PHARMACY_DT SEARCH_DT FROM DA_PHARMACY_IN)  PHARMACYIN"
    		+ "     ON DETAIL.BATCH_NO = PHARMACYIN.BATCH_NO"
    		+ "		%2$s"
    		+ "	)"
    		+ "	GROUP BY %1$s,DRUG_MEDICARE_CODE)";
    
    /**
     * 药房出库
     */
    private static final String DRUG_PHARMACY_OUT_SQL = ",PHARMACY_OUT AS ("
    		+ "	SELECT	%1$s,DRUG_MEDICARE_CODE,SUM(APPLY_REAL_NUM) PHARMACY_OUT_NUM"
    		+ "		,MAX(DRUG_GENERIC_NAME) GENERIC_NAME,MAX(DRUG_TRADE_NAME) TRADE_NAME"
    		+ "		,0.0 as PHARMACY_IN_NUM,0.0 as STORAGE_OUT_NUM, 0.0 as STORAGE_IN_NUM"
    		+ " FROM("
    		+ "		SELECT	PHARMACYOUT.%1$s,PHARMACYOUT.BATCH_NO,PHARMACYOUT.SEARCH_DT"
    		+ "			,DETAIL.DRUG_MEDICARE_CODE,DETAIL.APPLY_REAL_NUM,DETAIL.DRUG_GENERIC_NAME,DETAIL.DRUG_TRADE_NAME"
    		+ "		FROM DA_PHARMACY_OUT_DETAIL DETAIL"
    		+ "		LEFT JOIN  (SELECT BATCH_NO,ORG_TYPE,GBCODE,SUP_ORGAN_CODE,ORGAN_CODE,DELIVERY_DT SEARCH_DT FROM DA_PHARMACY_OUT)  PHARMACYOUT"
    		+ "     ON DETAIL.BATCH_NO = PHARMACYOUT.BATCH_NO"
    		+ "		%2$s"
    		+ "	)"
    		+ "	GROUP BY %1$s,DRUG_MEDICARE_CODE)";

    private static final String DISTRIBUTION_SQL = ",DISTRIBUTION AS ("
    		+ "	SELECT STORAGE_IN.%1$s,STORAGE_IN.DRUG_MEDICARE_CODE,STORAGE_IN.GENERIC_NAME"
    		+ "		,STORAGE_IN.TRADE_NAME,STORAGE_IN.STORAGE_IN_NUM,STORAGE_IN.STORAGE_OUT_NUM"
    		+ "		,STORAGE_IN.PHARMACY_IN_NUM,STORAGE_IN.PHARMACY_OUT_NUM"
    		+ "		,0 AS DRUG_TYPE"
    		+ "	FROM STORAGE_IN"//药库入库
    		+ "	UNION "
    		+ "	SELECT STORAGE_OUT.%1$s,STORAGE_OUT.DRUG_MEDICARE_CODE"
    		+ "		,STORAGE_OUT.GENERIC_NAME,STORAGE_OUT.TRADE_NAME"
    		+ "		,STORAGE_OUT.STORAGE_IN_NUM,STORAGE_OUT.STORAGE_OUT_NUM"
    		+ "		,STORAGE_OUT.PHARMACY_IN_NUM,STORAGE_OUT.PHARMACY_OUT_NUM"
    		+ "		,1 AS DRUG_TYPE"
    		+ "	FROM STORAGE_OUT"//药库出库
    		+ "	UNION"
    		+ "	SELECT PHARMACY_IN.%1$s,PHARMACY_IN.DRUG_MEDICARE_CODE,PHARMACY_IN.GENERIC_NAME"
    		+ "		,PHARMACY_IN.TRADE_NAME,PHARMACY_IN.STORAGE_IN_NUM,PHARMACY_IN.STORAGE_OUT_NUM"
    		+ "		,PHARMACY_IN.PHARMACY_IN_NUM,PHARMACY_IN.PHARMACY_OUT_NUM"
    		+ "		,2 AS DRUG_TYPE"
    		+ "	FROM PHARMACY_IN"//药房入库
    		+ "	UNION"
    		+ "	SELECT PHARMACY_OUT.%1$s,PHARMACY_OUT.DRUG_MEDICARE_CODE,PHARMACY_OUT.GENERIC_NAME"
    		+ "		,PHARMACY_OUT.TRADE_NAME,PHARMACY_OUT.STORAGE_IN_NUM,PHARMACY_OUT.STORAGE_OUT_NUM"
    		+ "		,PHARMACY_OUT.PHARMACY_IN_NUM,PHARMACY_OUT.PHARMACY_OUT_NUM"
    		+ "		,3 AS DRUG_TYPE"
    		+ "	FROM PHARMACY_OUT"//药房出库 		
    		+ ")"
    		+ "	SELECT %1$s orgCode,DRUG_MEDICARE_CODE medicareCode"
    		+ "		,MAX(GENERIC_NAME) medicareName,MAX(TRADE_NAME) tradeName"
    		+ "		,SUM(DECODE(DRUG_TYPE,0,STORAGE_IN_NUM,0)) storageInNum"
    		+ "		,SUM(DECODE(DRUG_TYPE,1,STORAGE_OUT_NUM,0)) storageOutNum"
    		+ "		,SUM(DECODE(DRUG_TYPE,2,PHARMACY_IN_NUM,0)) pharmacyInNum"
    		+ "		,SUM(DECODE(DRUG_TYPE,3,PHARMACY_OUT_NUM,0)) pharmacyOutNum"
    		+ "	FROM DISTRIBUTION"
    		+ "	GROUP BY %1$s,DRUG_MEDICARE_CODE"
    		+ " ORDER BY %1$s,DRUG_MEDICARE_CODE";
    
    private static final String CHANGE_SQL = " SELECT DECODE(aOrgCode,NULL"
    		+ ",DECODE(bOrgCode,NULL"
    		+ ",DECODE(cOrgCode,NULL,dOrgCode,cOrgCode),bOrgCode),aOrgCode) orgCode"
    		+ ",DECODE(aMedicareCode,NULL"
    		+ ",DECODE(bMedicareCode,NULL"
    		+ ",DECODE(cMedicareCode,NULL,dMedicareCode,cMedicareCode),bMedicareCode),aMedicareCode) medicareCode"
    		+ ",DECODE(aMedicareName,NULL"
    		+ ",DECODE(bMedicareName,NULL"
    		+ ",DECODE(cMedicareName,NULL,dMedicareName,cMedicareName),bMedicareName),aMedicareName) medicareName"
    		+ ",storageInNum,storageOutNum,pharmacyInNum,pharmacyOutNum"
    		+ " FROM("
    		+ " SELECT A.%1$s aOrgCode,B.%1$s bOrgCode,C.%1$s cOrgCode,D.%1$s dOrgCode"
    		+ " ,A.DRUG_MEDICARE_CODE aMedicareCode,B.DRUG_MEDICARE_CODE bMedicareCode,C.DRUG_MEDICARE_CODE cMedicareCode,D.DRUG_MEDICARE_CODE dMedicareCode"
    		+ " ,A.MEDICARE_NAME aMedicareName,B.MEDICARE_NAME bMedicareName,C.MEDICARE_NAME cMedicareName,D.MEDICARE_NAME dMedicareName"
    		+ ",A.storageInNum "//库存入库
    		+ ",B.storageOutNum"//库存出库
    		+ ",C.pharmacyInNum"//药房入库
    		+ ",D.pharmacyOutNum"//药房出库
    		+ " FROM ("
    		+ STORAGE_IN_SQL
    		+ " FULL OUTER JOIN ("
    		+ STORAGE_OUT_SQL
    		+ "  ON (A.%1$s = B.%1$s  AND A.DRUG_MEDICARE_CODE = B.DRUG_MEDICARE_CODE)"
    		+ " FULL OUTER JOIN ("
    		+ DA_PHARMACY_IN_SQL
    		+ "  ON ((A.%1$s = C.%1$s AND A.DRUG_MEDICARE_CODE = C.DRUG_MEDICARE_CODE)"
    		+ " OR (B.%1$s = C.%1$s AND B.DRUG_MEDICARE_CODE = C.DRUG_MEDICARE_CODE))"
    		+ " FULL OUTER JOIN ("
    		+ DA_PHARMACY_OUT_SQL
    		+ "  ON ((A.%1$s = D.%1$s AND A.DRUG_MEDICARE_CODE = D.DRUG_MEDICARE_CODE)"
    		+ " OR (B.%1$s = D.%1$s AND B.DRUG_MEDICARE_CODE = D.DRUG_MEDICARE_CODE)"
    		+ " OR (C.%1$s = D.%1$s AND C.DRUG_MEDICARE_CODE = D.DRUG_MEDICARE_CODE))"
    		+ " )";


    private static final String STORAGE_SQL =" SELECT DECODE(eOrgCode,NULL,fOrgCode,eOrgCode) orgCode" 
    		+ ",DECODE(eMedicareCode,NULL,fMedicareCode,eMedicareCode)  medicareCode"
    		+ ",DECODE(eMedicareName,NULL,fMedicareName,eMedicareName)  medicareName"
    		+ ",storageNum,pharmacyNum,roomNum"
    		+ " FROM("
    		+ " SELECT E.%1$s eOrgCode,F.%1$s fOrgCode"
    		+ " ,E.DRUG_MEDICARE_CODE eMedicareCode,F.DRUG_MEDICARE_CODE fMedicareCode"
    		+ " ,E.MEDICARE_NAME eMedicareName,F.MEDICARE_NAME fMedicareName"
    		+ ",E.storageNum "//药库库存
    		+ ",F.pharmacyNum"//药房库存
    		+ ",F.roomNum"//科室库存
    		+ " FROM ("
    		+ DA_STORAGE_SQL
    		+ " FULL OUTER JOIN ("
    		+ DA_PHARMACY_SQL
    		+ "  ON (E.%1$s = F.%1$s AND E.DRUG_MEDICARE_CODE = F.DRUG_MEDICARE_CODE))";
    
    private static final String Change_STATISTICS_SQL =  " select "
			+ " sum(NVL(storageInNum, 0))storageInNum,sum(NVL(storageOutNum, 0))storageOutNum,"
			+ " sum(NVL(pharmacyInNum, 0))pharmacyInNum,sum(NVL(pharmacyOutNum, 0))pharmacyOutNum"
			+ " from";
    private static final String Storage_STATISTICS_SQL =  " select "
			+ " sum(NVL(storageNum, 0))storageNum,sum(NVL(pharmacyNum, 0))pharmacyNum"
			+ " from";

    
	@Override
	public PageList<Map<String, Object>> getChangeTargetList(Page page,Criteria criteria, String orgType) {
		StringBuilder sql = new StringBuilder(DRUG_STORAGE_IN_SQL+ DRUG_STORAGE_OUT_SQL 
				+ DRUG_PHARMACY_IN_SQL + DRUG_PHARMACY_OUT_SQL + DISTRIBUTION_SQL);
		StringBuilder  whereSQL = new StringBuilder();
		String fieldStr = "0".equals(orgType)?"GBCODE":"ORGAN_CODE";
		SqlBuilder.buildWhereStatement(Pharmacy.class, whereSQL, criteria);
		String lastSql = String.format(sql.toString(),fieldStr,whereSQL.toString());
		return this.getPageMapList(page, lastSql, criteria);
		
	}
	@Override
	public List<Map<String, Object>> getChangeTargetSum(Criteria criteria, String orgType) {
		StringBuilder sql = new StringBuilder(DRUG_STORAGE_IN_SQL+ DRUG_STORAGE_OUT_SQL 
				+ DRUG_PHARMACY_IN_SQL + DRUG_PHARMACY_OUT_SQL + DISTRIBUTION_SQL);
		StringBuilder  whereSQL = new StringBuilder();
		String fieldStr = "0".equals(orgType)?"GBCODE":"ORGAN_CODE";
		SqlBuilder.buildWhereStatement(Pharmacy.class, whereSQL, criteria);
		String lastSql = String.format(sql.toString(),fieldStr,whereSQL.toString());
		String sumSql = Change_STATISTICS_SQL + "(" + lastSql + ")";
		return getMapList(sumSql, criteria);
	}
	
	@Override
	public PageList<Map<String, Object>> getStorageTargetList(Page page,Criteria criteria, String orgType) {
		StringBuilder sql = new StringBuilder(STORAGE_SQL);
		StringBuilder  whereSQL = new StringBuilder();
		String fieldStr = "0".equals(orgType)?"GBCODE":"ORGAN_CODE";
		SqlBuilder.buildWhereStatement(Pharmacy.class, whereSQL, criteria);
		String lastSql = String.format(sql.toString(),fieldStr,whereSQL.toString());
		return this.getPageMapList(page, lastSql, criteria);
	}
	@Override
	public List<Map<String, Object>> getStorageTargetSum(Criteria criteria, String orgType) {
		StringBuilder sql = new StringBuilder(STORAGE_SQL);
		StringBuilder  whereSQL = new StringBuilder();
		String fieldStr = "0".equals(orgType)?"GBCODE":"ORGAN_CODE";
		SqlBuilder.buildWhereStatement(Pharmacy.class, whereSQL, criteria);
		String lastSql = String.format(sql.toString(),fieldStr,whereSQL.toString());
		String sumSql = Storage_STATISTICS_SQL + "(" + lastSql + ")";
		return getMapList(sumSql, criteria);
	}
}