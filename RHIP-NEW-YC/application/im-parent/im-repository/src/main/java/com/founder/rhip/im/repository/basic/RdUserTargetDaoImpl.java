package com.founder.rhip.im.repository.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.im.entity.basic.RdUserTarget;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of UserTarget
 * 
 */
@Repository("rdUserTargetDao")
public class RdUserTargetDaoImpl extends AbstractDao<RdUserTarget, Long> implements IRdUserTargetDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


    @Override
    public List<RdUserTarget> getUserTargetList(Criteria criteria) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT U.ID,U.USER_CODE,U.TARGET_ID,U.NAME_ZH,U.TARGET_CODE,U.TARGET_TYPE,U.TARGET_SORT,T.UNIT,T.PATH,T.CHART_TYPE FROM RD_USER_TARGET U\n");
        sql.append("LEFT JOIN RD_TARGET_INDEX T ON T.CODE = U.TARGET_CODE");
        SqlBuilder.buildWhereStatement(RdUserTarget.class,sql,criteria);
        SqlBuilder.buildOrderStatement(sql," TARGET_SORT ASC");
        return this.getList(sql.toString(),criteria);
    }
}