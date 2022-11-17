package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Department;
import org.springframework.stereotype.Repository;

@Repository("mdmDepartmentDao")
public class DepartmentDao extends MDMRepository<Department, Long> implements IDepartmentDao {
	
	protected static final String TABLE_DEPARTMENT_LOG = "MDM_DEPARTMENT_LOG";
	
	protected static final String TABLE_DEPARTMENT = "MDM_DEPARTMENT";
	
	public void insertDepartmentLog(Criteria criteria) {
		insertLogRecord(TABLE_DEPARTMENT_LOG, criteria);
	}
	
	public PageList<Department> getUpdateHistory(Page page, Long deptId, String... properties) {
		String fields = StringUtil.join(coverPropertiesToFields(properties));
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(fields).append(" FROM ").append(TABLE_DEPARTMENT).append(" WHERE DEPT_ID = ").append(deptId)
			.append(" UNION ").append("SELECT ").append(fields).append(" FROM ").append(TABLE_DEPARTMENT_LOG).append(" WHERE DEPT_ID = ").append(deptId)
			.append(" ORDER BY OPERATE_TIME DESC");
		return getPageList(page, sql.toString(), null);
	}
	
	public int delete(Criteria criteria) {
		setTableName(TABLE_DEPARTMENT_LOG);
		super.delete(criteria);
		setTableName(TABLE_DEPARTMENT);
		return super.delete(criteria);
	}
}
