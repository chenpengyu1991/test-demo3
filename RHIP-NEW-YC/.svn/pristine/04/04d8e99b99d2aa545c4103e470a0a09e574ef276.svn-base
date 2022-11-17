package com.founder.rhip.fds.repository;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.fds.common.FDSConstants;
import com.founder.rhip.fds.entity.ServiceRelPackageItem;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of ServiceRelPackageItem
 * 
 */
@Repository("serviceRelPackageItemDao")
public class ServiceRelPackageItemDaoImpl extends AbstractDao<ServiceRelPackageItem, Long> implements IServiceRelPackageItemDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<ServiceRelPackageItem> getServiceItemListOfPackage(String packageCode) {
        StringBuilder sql = new StringBuilder(" SELECT PACKAGE.*,ITEM.NAME ITEM_NAME,ITEM.DESCRIPTION DESCRIPTION FROM SERVICE_REL_PACKAGE_ITEM PACKAGE ");
        sql.append(" LEFT JOIN SERVICE_ITEM ITEM ON ITEM.CODE = PACKAGE.ITEM_CODE");
        //根据服务包编码查询
        StringBuilder sqlWhere = new StringBuilder(" WHERE  ");
        if(ObjectUtil.isNotEmpty(packageCode)){
            sqlWhere.append(" PACKAGE_CODE = '" + packageCode + "'");
        }
        return this.getList(sql.toString() + sqlWhere.toString());
    }
}