package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of MhmDrugRecord
 * 
 */
@Repository("mhmDrugDao")
public class MhmDrugDaoImpl extends AbstractDao<MhmDrug, Long> implements IMhmDrugDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public List<MhmDrug> findDrugList(Criteria ca){
        return this.getList(ca);
    }
    
    /**
     * 获取药物列表
     * 如果药品已经使用（MHM_DRUG_RECORD），则不能删除
     * */
    public PageList<MhmDrug> findDrugList(Criteria ca,Page page){
		StringBuilder sql = new StringBuilder();
        sql.append("SELECT drug.*,nvl(drugrecord.DRUG_ID,0) DELETE_FLG FROM MHM_DRUG drug");
        sql.append(" LEFT JOIN ");
        sql.append(" (select t1.* from MHM_DRUG_RECORD t1 where t1.id in (select max(t2.id) from MHM_DRUG_RECORD t2 where t2.drug_id = t1.drug_id ))");
        sql.append("  drugrecord on drug.id = drugrecord.DRUG_ID");
        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, ca) ;
        SqlBuilder.buildOrderStatement(sql, "drug.MODIFY_DATE DESC");
        return this.getPageList(page,sql.toString(),ca);
    }
}