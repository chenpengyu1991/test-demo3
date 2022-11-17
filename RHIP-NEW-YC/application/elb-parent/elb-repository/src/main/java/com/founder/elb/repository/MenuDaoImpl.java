package com.founder.elb.repository;


import com.founder.elb.entity.Menu;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of Menu
 * 
 */
@Repository("menuDao")
public class MenuDaoImpl extends AbstractDao<Menu, Integer> implements IMenuDao
{

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	@Override
	public List<Map<String, Object>> getMenuTree(String roleCode) {
		//List<Map<String, Object>> list = null;
		String sql = "select a.id as id, " + "a.parent_code as parentId, " + "a.depth as depth, " + "a.name_zh as nameZh, " + "c.role_id as roleId, " + "a.is_parent as isParent "
				+ "from menu a, accezz b left join role_access c on b.src_id = c.access_id " + "and c.role_code = '" + roleCode + "'" + "where a.id = b.src_id " + "and a.status = '1' "
				+ "and a.flag = '1' and b.access_level=2";
		
		Criteria criteria=new Criteria();
		return getMapList(sql, criteria);
	}

	
}