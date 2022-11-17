package com.founder.rhip.fds.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.fds.entity.ServiceItem;
import com.founder.rhip.fds.entity.Sign;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of ServiceItem
 * 
 */
@Repository("serviceItemDao")
public class ServiceItemDaoImpl extends AbstractDao<ServiceItem, Long> implements IServiceItemDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<ServiceItem> getServiceItemList(Criteria criteria){
        StringBuilder sql = new StringBuilder();
        StringBuilder whereSql = new StringBuilder();
        sql.append(" SELECT ITEM.*,REL.NEED_TIMES,REL.TIMES  FROM SERVICE_REL_PACKAGE_ITEM REL");
        sql.append("    LEFT JOIN  SERVICE_ITEM ITEM ON REL.ITEM_CODE = ITEM.CODE");

        SqlBuilder.buildWhereStatement(ServiceItem.class,whereSql,criteria);
        sql.append(whereSql.toString());
        return this.getList(sql.toString(),criteria);
    }
}