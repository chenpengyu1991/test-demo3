package com.founder.rhip.fds.repository;

import com.founder.rhip.fds.entity.SignServiceItem;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of SignServiceItem
 * 
 */
@Repository("signServiceItemDao")
public class SignServiceItemDaoImpl extends AbstractDao<SignServiceItem, Long> implements ISignServiceItemDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public int countActualTimes(Long signId, String servicePackageCode, String serviceItemCode) {
        String updateSql = "UPDATE SIGN_SERVICE_ITEM SET ACTUAL_TIMES = ACTUAL_TIMES + 1";
        updateSql += " WHERE SIGN_ID=%1$s and SERVICE_PACKAGE_CODE='%2$s' and SERVICE_ITEM_CODE='%3$s'";
        String lastSql = String.format(updateSql,signId,servicePackageCode,serviceItemCode);
        return this.execute(lastSql);
    }
}