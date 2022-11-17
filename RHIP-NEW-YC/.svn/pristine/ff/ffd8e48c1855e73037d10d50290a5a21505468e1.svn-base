package com.founder.rhip.ehr.repository.women;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.women.WhYcfbjXmgztz;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * DAO implement of WhYcfbjXmgztzDao
 * 
 */
@Repository("whYcfbjXmgztzDao")
public class WhYcfbjXmgztzDaoImpl extends AbstractDao<WhYcfbjXmgztz,Long> implements IWhYcfbjXmgztzDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


    @Override
    public List<WhYcfbjXmgztz> getAccountList(Criteria ca) {
        StringBuilder sql = new StringBuilder("SELECT DWMC,NF,YF,NVL(XQRKS,0) XQRKS,NVL(CSL,0) CSL,NVL(NYCFMBJCS,0) NYCFMBJCS,NVL(YCFMBJCS,0) YCFMBJCS,NVL(HCS,0) HCS,NVL(SJJCS,0) SJJCS,NVL(ZYJCS,0) ZYJCS,NVL(ZYJCL,0) ZYJCL,NVL(YSLESZJCS,0) YSLESZJCS,NVL(YEYESZJCS,0) YEYESZJCS,NVL(YEBSLZJCS,0) YEBSLZJCS,NVL(YSQSLZJCS,0) YSQSLZJCS,NVL(JKGLS,0) JKGLS,NVL(JKGLL,0) JKGLL,NVL(CHFSS,0) CHFSS,NVL(CHFSL,0) CHFSL,NVL(XTGLS,0) XTGLS,NVL(XTGLL,0) XTGLL,TBR,TBRQ FROM WH_YCFBJ_XMGZTZ");
        SqlBuilder.buildWhereStatement(WhYcfbjXmgztz.class, sql, ca);
        sql.append(" ORDER BY NF ASC,YF ASC");
        return getList(sql.toString(), ca);
    }

    public BigDecimal getMaxRate(Criteria ca){
        StringBuilder sql = new StringBuilder("SELECT NVL(MAX(CSL),0) CSL FROM WH_YCFBJ_XMGZTZ");
        SqlBuilder.buildWhereStatement(WhYcfbjXmgztz.class, sql, ca);
        WhYcfbjXmgztz mgtz=get(sql.toString(), ca);

        return mgtz.getCsl();
    };

    public static void buildWhereStatement(Class<?> clazz, StringBuilder sql, Criteria criteria) {
        if (criteria == null || criteria.getCriteria() == null || criteria.getCriteria().size() < 1) {
            return;
        }
        if (sql == null) {
            sql = new StringBuilder();
        }
        sql.append(" WHERE ").append(criteria.toSql(ClassMetadata.getMetadata(clazz), ":")).toString();
    }
}
