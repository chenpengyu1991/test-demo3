package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.mdm.entity.OrganizationArea;
import com.founder.rhip.mdm.entity.OrganizationAreaHistory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("mdmOrganizationAreaHistoryDao")
public class OrganizationAreaHistoryDao extends MDMRepository<OrganizationAreaHistory, Long> implements IOrganizationAreaHistoryDao {
    /**
     * 获取OrganizationArea对象集合
     * @param criteria
     * @return
     */
    @Override
    public List<OrganizationAreaHistory> getOrganizationAreasHistory(Criteria criteria) {
        List<OrganizationAreaHistory> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append(" select oa.organization_code,oa.area_code,o.organ_name,item.item_name from ORGANIZATION_AREA_HISTORY oa ");
        sql.append(" left join organization_history o  on oa.organization_code = o.organ_code and o.status <> '-1'");
        sql.append(" left join dic_item item on item.item_code = oa.area_code and item.dic_code = 'FS990001'");

        SqlBuilder.buildWhereStatement(OrganizationArea.class, sql, criteria) ;
        SqlBuilder.buildOrderStatement(sql, " oa.area_code ASC");
        result = this.getList(sql.toString(), criteria);
        return result;
    }

}
