package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.TransBloodInfo;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository("hospitalBloodUseQueryDao")
public class HospitalBloodUseQueryDaoImpl extends AbstractDao<TransBloodInfo, Long> implements IHospitalBloodUseQueryDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


    public PageList<TransBloodInfo> getHospitalBloodUseList(Criteria criteria, Page page){

        StringBuilder sql = new StringBuilder("select B.*, P.IDCARD\n" +
                "  from MS_TRANS_BLOOD_INFO B, V_PHB_BI_PERSON_INFO P\n" +
                " WHERE B.PERSON_ID = P.ID ");
        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
            sql.append(" AND ");
            sql.append(criteria.toSql(ClassMetadata.getMetadata(Organization.class), ":")).toString();
        }

//        SqlBuilder.buildWhereStatement(Organization.class, sql, criteria);
        SqlBuilder.buildOrderStatement(sql, " B.ID DESC ");
        return getPageList(page, sql.toString(), criteria);
    }

}
