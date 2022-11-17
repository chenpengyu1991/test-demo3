package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.SecrecyDegreeSet;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of ISecrecyDegreeDao
 *
 */
@Repository("secrecyDegreeDao")
public class SecrecyDegreeDaoImpl extends AbstractDao<SecrecyDegreeSet, Long> implements ISecrecyDegreeDao {
	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	/**
	 * 综合管理 检查查询页面用(没有身份证)
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<SecrecyDegreeSet> getSecrecyDegreeList(Page page, Criteria criteria){
		String organCode= (String)criteria.get("organCode");
		StringBuilder sql = new StringBuilder("SELECT T1.*\n" +
				"  FROM IDM_SECRECY_DEGREE_SET T1\n" +
				" WHERE T1.ID IN (SELECT MAX(T2.ID)\n" +
				"                   FROM IDM_SECRECY_DEGREE_SET T2\n" +
				"                  WHERE T1.ORGAN_CODE = T2.ORGAN_CODE\n" );
			if(ObjectUtil.isNotEmpty(organCode)){
				sql.append("AND T2.ORGAN_CODE = '"+organCode+"'");
			}
				sql.append(")\n" +
				" ORDER BY CREATE_DATE DESC\n" );
		PageList<SecrecyDegreeSet> pList = getPageList(page, sql.toString(), new Criteria());
		return pList;
	}

}