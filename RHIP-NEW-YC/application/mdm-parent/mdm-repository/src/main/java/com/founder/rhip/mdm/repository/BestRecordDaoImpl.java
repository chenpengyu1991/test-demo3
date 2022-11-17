package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Person;
import com.founder.rhip.mdm.repository.IBestRecordDao;

import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Repository("mdmBestRecordDao")
public class BestRecordDaoImpl extends MDMRepository<Person, String> implements IBestRecordDao {

	public BestRecordDaoImpl() {
		setTableName("BI_BEST_RECORD");
		setKey("PMPI_ID");
	}

	@Override
	public void removeUnusedPmpiId(Set<String> checkList) {
		if (ObjectUtil.isNullOrEmpty(checkList)) {
			return;
		}
		StringBuilder ids = new StringBuilder("(");
		Iterator<String> itr = checkList.iterator();
		while (itr.hasNext()) {
			String pmpiId = itr.next();
			ids.append("'" + pmpiId + "',");
		}
		ids.deleteCharAt(ids.length() - 1);
		ids.append(")");
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM BI_BEST_RECORD WHERE NOT EXISTS ( ")
			.append("SELECT PERSON_ID FROM MDM_PERSON WHERE BI_BEST_RECORD.PMPI_ID = MDM_PERSON.PMPI_ID) ")
			.append("AND PMPI_ID IN ")
			.append(ids);
		execute(sql.toString());
	}
	
	@Override
	public PageList<Person> queryBestRecord(Page page, Criteria criteria, String... properties) {
		String selectPmpiId = SqlBuilder.createSelectString(Person.class, "MDM_PERSON", criteria, null, "pmpiId");
		String[] fields = this.coverPropertiesToFields(properties);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(StringUtil.join(fields)).append(" FROM BI_BEST_RECORD ")
			.append("WHERE PMPI_ID IN (").append(selectPmpiId).append(")");
		return getPageList(page, sql.toString(), criteria);
	}
	
	@Override
	public List<Person> queryBestRecord(Criteria criteria, String... properties) {
		String selectPmpiId = SqlBuilder.createSelectString(Person.class, "MDM_PERSON", criteria, null, "DISTINCT PMPI_ID");
		String[] fields = this.coverPropertiesToFields(properties);
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(StringUtil.join(fields)).append(" FROM BI_BEST_RECORD ")
			.append("WHERE PMPI_ID IN (").append(selectPmpiId).append(")");
		return getList(sql.toString(), criteria);
	}

}
