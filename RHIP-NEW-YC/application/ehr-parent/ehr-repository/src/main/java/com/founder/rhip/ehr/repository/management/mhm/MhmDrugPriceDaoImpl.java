package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugPrice;
import com.founder.rhip.ehr.entity.management.mhm.MhmManageType;
import com.founder.rhip.ehr.repository.management.mhm.IMhmDrugPriceDao;

/**
 * DAO implement of MhmDrugPrice
 * 
 */
@Repository("mhmDrugPriceDao")
public class MhmDrugPriceDaoImpl extends AbstractDao<MhmDrugPrice, Long> implements IMhmDrugPriceDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    /**
     * 根据药品ID获取历史记录中最新一条记录
     *
     * @param drugId
     * @return
     * @author Ye jianfei
     */
    public MhmDrugPrice findDrugPrice(Long drugId){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT * FROM MHM_DRUG_PRICE T1 ");
        sql.append(" WHERE VERSION = ");
        sql.append(" (SELECT MAX(VERSION) FROM MHM_DRUG_PRICE T2 WHERE T1.DRUG_ID = T2.DRUG_ID) " );
        sql.append(" AND T1.DRUG_ID = " + drugId);
        return get(sql.toString(), null);
    }
}