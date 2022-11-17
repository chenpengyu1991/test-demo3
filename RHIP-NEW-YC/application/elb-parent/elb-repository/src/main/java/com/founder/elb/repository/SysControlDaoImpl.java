
package com.founder.elb.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.founder.elb.entity.SysControl;
import com.founder.fasf.repository.AbstractDao;

/**
 * DAO implement of Menu
 * 
 */
@Repository("sysControlDao")
public class SysControlDaoImpl extends AbstractDao<SysControl, Integer> implements ISysControlDao {

	@Override
	public List<SysControl> getList() {
		String sql = "SELECT A.ID AS ID,S.SYS_NAME,PATH,S.DESCRIPTION FROM SYS_CONTROL S LEFT JOIN  ACCEZZ A ON S.ID=A.SRC_ID WHERE ACCESS_LEVEL=1 ORDER BY SYS_NAME DESC";		
		return getList(sql);
	}
}