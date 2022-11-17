package com.founder.rhip.portal.repository;

import java.util.Date;
import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.FrequentContacts;
import com.founder.rhip.ehr.entity.portal.RegisterSchedule;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;
import com.founder.rhip.ehr.repository.portal.IFrequentContactsDao;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by ss on 2015/11/10.
 */
@Repository("lhFrequentContactsDao")
public class FrequentContactsDaoImpl extends AbstractDao<FrequentContacts,Long> implements IFrequentContactsDao {

    @Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    @Override
	public PageList<FrequentContacts> getRealNameByFrequentPageList(Page page, Criteria criteria) {
    	StringBuilder sb = new StringBuilder("select fc.id, "
    			+ "fc.frequent_name, "
    			+ "fc.gender, "
    			+ "fc.card_no,"
    			+ "fc.telephone,"
    			+ "fc.account_id,"
    			+ "fc.birthday,"
    			+ "fc.reserve_status,"
    			+ " ac.real_name");
		sb.append(" from frequent_contacts fc");
		sb.append(" left join account_info ac");
		sb.append(" on fc.account_id = ac.id");
		SqlBuilder.buildWhereStatement(FrequentContacts.class, sb, criteria);
		PageList<FrequentContacts> getRealNameByFrequentPageList = this.getPageList(page, sb.toString(), criteria);
		return getRealNameByFrequentPageList;
	}
}
