package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@Repository("mdmPersonDao")
public class PersonDaoImpl extends MDMRepository<Person, Long> implements IPersonDao {

	@Override
	public void insertPersonLog(String[] properties, Long... personId) {
		if (personId == null || personId.length == 0) {
			return;
		}
		int maxLength = 1000, srcPos = 0;
		Long[] ids = null;
		do {
			int length = (maxLength < (personId.length - srcPos)) ? maxLength : (personId.length - srcPos);
			ids = new Long[length];
			System.arraycopy(personId, srcPos, ids, 0, length);
			String personFields = StringUtil.join(coverPropertiesToFields(properties));
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO MDM_PERSON_LOG (").append(personFields).append(") SELECT ").append(personFields).append(" FROM MDM_PERSON WHERE PERSON_ID IN (")
					.append(StringUtil.join(ids)).append(")");
			execute(sb.toString());
			srcPos += length;
		} while (srcPos < personId.length);
	}

	@Override
	public List<Person> crossQuery(Criteria criteria, Map<String, Object> target) {
		String selectPmpi = SqlBuilder.createSelectString(Person.class, "MDM_PERSON", criteria, null, "DISTINCT PMPI_ID");
		List<String> targetProperties = new ArrayList<String>();
		Set<Entry<String, Object>> set = target.entrySet();
		for (Entry<String, Object> entry : set) {
			if (entry.getValue() == null) {
				targetProperties.add(entry.getKey());
			}
		}
		String targetPropSql = "*";
		if (ObjectUtil.isNotEmpty(targetProperties)) {
			targetPropSql = StringUtil.join(coverPropertiesToFields(StringUtil.toStringArray(targetProperties)));
		}
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(targetPropSql).append(" FROM MDM_PERSON ")
			.append("WHERE PMPI_ID = (").append(selectPmpi).append(") ");
		String domainId = (String) target.get("domainId");
		if (StringUtil.isNotEmpty(domainId)) {
			sql.append("AND DOMAIN_ID = '").append(domainId).append("'");
		}
		return getList(sql.toString(), criteria);
	}
	
	@Override
	public PageList<Person> getPersonLogs(Page page, Long personId, String[] properties) {
		String select = StringUtil.join(coverPropertiesToFields(properties));
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(select).append(" FROM MDM_PERSON WHERE PERSON_ID = " + personId)
			.append(" UNION ").append("SELECT ").append(select).append(" FROM MDM_PERSON_LOG ")
			.append("WHERE PERSON_ID = ").append(personId)
			.append(" ORDER BY UPDATE_TIME DESC");
		return getPageList(page, sql.toString(), null);
	}
	
	@Override
	public Person getPersonLog(Long personId, Long updateTime, String[] properties) {
		String select = StringUtil.join(coverPropertiesToFields(properties));
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ").append(select).append(" FROM MDM_PERSON_LOG ")
			.append("WHERE PERSON_ID = ").append(personId)
			.append(" AND UPDATE_TIME = ").append(updateTime);
		return get(sql.toString(), null);
	}
}
