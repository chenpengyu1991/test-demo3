package com.founder.rhip.im.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.im.entity.basic.RdTargetIndex;
import com.founder.rhip.im.entity.basic.RdUserTarget;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of TargetInex
 * 
 */
@Repository("rdTargetIndexDao")
public class RdTargetIndexDaoImpl extends AbstractDao<RdTargetIndex, Long> implements IRdTargetIndexDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<RdTargetIndex> getTargetIndexList(String type, String userCode) {
        Criteria criteria = new Criteria("TYPE", OP.LIKE,type);
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM RD_TARGET_INDEX \n");
        SqlBuilder.buildWhereStatement(RdUserTarget.class,sql,criteria);
        sql.append(" AND CODE  NOT IN(\n");
        sql.append("    SELECT TARGET_CODE FROM RD_USER_TARGET\n");
        sql.append("    WHERE USER_CODE = '" + userCode + "'");
        sql.append("    AND TARGET_TYPE <> '" + type + "'");
        sql.append(")\n");
        return this.getList(RdTargetIndex.class,sql.toString(),criteria);
    }
}