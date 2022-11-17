package com.founder.elb.repository;

import org.springframework.stereotype.Repository;

import com.founder.elb.entity.CvDicmeta;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;

/**
 * DAO implement of User
 * 
 */
@Repository("cvDicmetaDao")
public class CvDicmetaDaoImpl extends AbstractDao<CvDicmeta, Long> implements ICvDicmetaDao
{
	/**
	 * 
	 * @param page
	 * @param clinicId
	 * @param criteria
	 * @return
	 */
	@Override
	public PageList<CvDicmeta> getList(Page page, Integer[] clinicId, Criteria criteria) {
		// TODO check the following sql sentence by business logical
		StringBuilder sql = new StringBuilder("select id,name from clinic where id in ").append("(select r.id from role r where r.id in ").append(
				"(select role_id from user_role_organization +where user_id=:userId and organization_id =:organizationId and sex>=:minSex and sex<=:maxSex))");
		return getPageList(page, sql.toString(), criteria);
	}
}