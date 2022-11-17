package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugUse;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of MhmDrugUse
 * 
 */
@Repository("mhmDrugUseDao")
public class MhmDrugUseDaoImpl extends AbstractDao<MhmDrugUse, Long> implements IMhmDrugUseDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    
    /**
     * 获取发药列表
     * */
    public PageList<MhmDrugUse> findDrugUseList(Criteria ca,Page page){
		StringBuilder sql = new StringBuilder();
        sql.append(" select basics.name,basics.gender,basics.idcard,dia.diagnosis_Result,druguse.*,drug.DRUG_NAME from MHM_DRUG_USE druguse");
        sql.append(" left join mhm_drug drug on druguse.drug_id = drug.id");
        sql.append(" left join mhm_status_info status on status.id = druguse.status_id");
        sql.append(" left join mhm_event_info event on (event.status_id = status.id and event.EVENT_TYPE = 2001)");
        sql.append(" left join mhm_basics_info basics on basics.event_id = event.id");
        sql.append(" left join mhm_diagnosis dia on dia.event_id = event.id");
        sql.append(" left join mhm_other_info org on org.event_id = event.id");
        SqlBuilder.buildWhereStatement(MhmDrugUse.class, sql, ca) ;
        SqlBuilder.buildOrderStatement(sql, "druguse.USE_DT DESC,druguse.MODIFY_DATE DESC");
        return this.getPageList(page,sql.toString(),ca);
    }   

    /**
     * 获取发药信息
     * */
    public MhmDrugUse getDrugUse(Criteria ca){
		StringBuilder sql = new StringBuilder();
        sql.append(" select basics.name,basics.idcard,dia.diagnosis_Result,druguse.*,drug.drug_name,drug.DRUG_UNIT,drug.UNIT_MEASURE from MHM_DRUG_USE druguse");
        sql.append(" left join mhm_drug drug on druguse.drug_id = drug.id");
        sql.append(" left join mhm_status_info status on status.id = druguse.status_id");
        sql.append(" left join mhm_event_info event on (event.status_id = status.id and event.EVENT_TYPE = 2001)");
        sql.append(" left join mhm_basics_info basics on basics.event_id = event.id");
        sql.append(" left join MHM_DIAGNOSIS dia on dia.event_id = event.id");        
        SqlBuilder.buildWhereStatement(MhmDrugUse.class, sql, ca) ;
        return this.get(sql.toString(),ca);
    }
    
    //
}