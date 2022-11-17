package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListFg;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of IdmListFg
 * 
 */
@Repository("idmListFgDao")
public class ListFgDaoImpl extends AbstractDao<ListFg, Long> implements IListFgDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    public PageList<ListFg> findFgList(Page page, Criteria criteria, Order od){
		PageList<ListFg> result = this.getPageList(page, criteria, od);
		return result;	    	
    }
    
    public List<ListFg> findFgList(Criteria criteria, Order od){
		List<ListFg> result = this.getList(criteria, od);
		return result;	    	
    }    
}