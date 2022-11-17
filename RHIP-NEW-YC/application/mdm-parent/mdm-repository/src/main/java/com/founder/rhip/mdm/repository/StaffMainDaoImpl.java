package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Repository("mdmStaffMainDao")
public class StaffMainDaoImpl extends MDMRepository<Staff, String> implements
		IStaffMainDao {

	public StaffMainDaoImpl() {
		setTableName("MDM_STAFF_MAIN");
		setKey("SMPI_ID");
	}
	
	@Override
	public PageList<Staff> queryStaffMain(Page page, Criteria criteria,
			String... properties) {
		String selectSmpiId = SqlBuilder.createSelectString(Staff.class, "STAFF", criteria, null, "SMPI_ID");
		String[] fields = this.coverPropertiesToFields(properties);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(StringUtil.join(fields)).append(" FROM STAFF_MAIN ")
			.append("WHERE SMPI_ID IN (").append(selectSmpiId).append(")");
		PageList<Staff> list = getPageList(page, sql.toString(), criteria);
		
		return list;
	}
	
	@Override
	public List<Staff> queryStaffMain(Criteria criteria, String... properties) {
		String selectPmpiId = SqlBuilder.createSelectString(Staff.class, "STAFF", criteria, null, "DISTINCT SMPI_ID");
		String[] fields = this.coverPropertiesToFields(properties);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(StringUtil.join(fields)).append(" FROM MDM_STAFF_MAIN ")
			.append("WHERE SMPI_ID IN (").append(selectPmpiId).append(")");
		return getList(sql.toString(), criteria);
	}

	@Override
	public void removeUnusedSmpiId(Set<String> checkList) {
		if (ObjectUtil.isNullOrEmpty(checkList)) {
			return;
		}
		StringBuilder ids = new StringBuilder("(");
		Iterator<String> itr = checkList.iterator();
		while (itr.hasNext()) {
			String smpiId = itr.next();
			ids.append("'" + smpiId + "',");
		}
		ids.deleteCharAt(ids.length() - 1);
		ids.append(")");
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM MDM_STAFF_MAIN WHERE NOT EXISTS ( ")
			.append("SELECT STAFF_CODE FROM MDM_STAFF WHERE STAFF_MAIN.SMPI_ID = STAFF.SMPI_ID) ")
			.append("AND SMPI_ID IN ")
			.append(ids);
		execute(sql.toString());
	}

}
