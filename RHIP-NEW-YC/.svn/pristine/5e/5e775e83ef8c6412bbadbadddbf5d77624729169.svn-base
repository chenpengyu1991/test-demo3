package com.founder.rhip.ehr.repository.clinic;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.clinic.ExpenseDetail;
import com.founder.rhip.ehr.entity.clinic.StorageInDetail;

/**
 * DAO implement of StorageInDetail
 * 
 */
@Repository("storageInDetailDao")
public class StorageInDetailDaoImpl extends AbstractDao<StorageInDetail, Long> implements IStorageInDetailDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String DETAIL_SQL = "SELECT DETAIL.BATCH_NO,SOURCE_TYPE,DRUG_MEDICARE_CODE"
    		+ " ,DRUG_GENERIC_NAME,DRUG_TRADE_NAME,PINYING,PINYING_SHORT"
    		+ " ,PURCHASE_PRICE,PURCHASE_NUM,PURCHASE_AMOUNT,FAC_NAME"
    		+ " ,EXPIRY_DT,SPECIFICATIONS,PACKAGING,WHOLESALE_PRICE"
    		+ " ,RETAIL_PRICE FROM DA_STORAGE_IN_DETAIL DETAIL"
    		+ " LEFT JOIN DA_STORAGE_IN STORAGE ON STORAGE.BATCH_NO = DETAIL.BATCH_NO"
    		+ " %1$s";
    
    public PageList<Map<String, Object>> getDetailList(Page page, Criteria criteria){
		StringBuilder sql = new StringBuilder(DETAIL_SQL);
		StringBuilder  totalCostWhereSQL = new StringBuilder();
		SqlBuilder.buildWhereStatement(StorageInDetail.class, totalCostWhereSQL, criteria);
		String lastSql = String.format(sql.toString(),totalCostWhereSQL.toString());
		return this.getPageMapList(page, lastSql, criteria);
    	
    }
}