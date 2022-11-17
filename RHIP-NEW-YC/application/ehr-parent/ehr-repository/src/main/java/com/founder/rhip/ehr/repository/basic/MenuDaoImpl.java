package com.founder.rhip.ehr.repository.basic;

import com.founder.elb.entity.Menu;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * DAO implement of User
 * 
 */
@Repository("ehrMenuDao")
public class MenuDaoImpl extends AbstractDao<Menu, Long> implements IMenuDao
{

	@Override
	public List<Map<String, Object>> getMenuTree(Integer roleCode) {
		String sql = "select a.id as id, "
				+ "a.parent_code as parentId, "
				+ "a.depth as depth, "
				+ "a.name_zh as nameZh, "
				+ "c.role_code as roleId, "
				+ "a.is_parent as isParent "
				+ "from menu a, accezz b left join role_access c on b.src_id = c.access_code "
				+ "and c.role_code = '" + roleCode + "'" + "where a.id = b.src_id "
				+ "and a.status = '1' " + "and a.flag = '1' ";
		return this.getMapList(sql, new Criteria());
	}

}