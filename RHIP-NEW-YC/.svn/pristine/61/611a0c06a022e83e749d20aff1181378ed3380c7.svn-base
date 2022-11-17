package com.founder.rhip.fds.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.fds.entity.Sign;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of Sign
 * 
 */
@Repository("signDao")
public class SignDaoImpl extends AbstractDao<Sign, Long> implements ISignDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<Sign> getServicePackageList(Criteria criteria) {
        StringBuilder sql = new StringBuilder();
        StringBuilder whereSql = new StringBuilder();
        sql.append(" SELECT SIGN.*");
        sql.append("    ,PACK.SERVICE_PACKAGE_CODE,PACK.SERVICE_PACKAGE_NAME,PACK.SERVICE_PACKAGE_PRICE,PACK.GROUP_CLASSIFICATION");
        sql.append(" FROM SIGN");
        sql.append(" LEFT JOIN SIGN_SERVICE_PACKAGE PACK ON PACK.SIGN_ID = SIGN.ID");

        SqlBuilder.buildWhereStatement(Sign.class,whereSql,criteria);
        sql.append(whereSql.toString());
        return this.getList(sql.toString(),criteria);
    }
}