package com.founder.rhip.fds.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.fds.common.FDSConstants;
import com.founder.rhip.fds.entity.ServicePackage;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * DAO implement of ServicePackage
 * 
 */
@Repository("servicePackageDao")
public class ServicePackageDaoImpl extends AbstractDao<ServicePackage, Long> implements IServicePackageDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<ServicePackage> getAvailableList(String[] groupClassifications, String[] codes) {
        StringBuilder sql = new StringBuilder(" SELECT * FROM SERVICE_PACKAGE ");
        //根据人群分类和服务包编码查询
        StringBuilder sqlWhere = new StringBuilder(" WHERE  published ='" + FDSConstants.PUBLISHED_FLG_1 + "'");
        if(ObjectUtil.isNotEmpty(groupClassifications)){
            //根据人群分类查询，但是基础包必选
            String conGroup = "";
            String groupPrex = " AND ( ";
            for(String groupClassification:groupClassifications){
                conGroup += groupPrex;
                conGroup += " GROUP_CLASSIFICATION like '%" + groupClassification + "%'";
                groupPrex = " or ";
            }
            conGroup += " ) ";
            sqlWhere.append(conGroup);
            //基础包必选
            sqlWhere.append(" or( type ='" + FDSConstants.PACKAGE_TYPE_01 + "'");
            sqlWhere.append(" and published ='" + FDSConstants.PUBLISHED_FLG_1 + "'");
            sqlWhere.append(" and valid ='" + FDSConstants.VALID_1 + "'");
            sqlWhere.append(")");
        }
        if(ObjectUtil.isNotEmpty(codes)){
            sqlWhere.append(" and code in(");
            Object[] objects = (Object[]) codes;
            String flag = ObjectUtil.isNumber(objects[0]) ? "" : "'";
            for (int i = 0; i < objects.length; i++) {
                if (i > 0) {
                    sqlWhere.append(",");
                }
                sqlWhere.append(flag).append(objects[i]).append(flag);
            }
            sqlWhere.append(" )");
        }
        return this.getList(sql.toString() + sqlWhere.toString());
    }
}