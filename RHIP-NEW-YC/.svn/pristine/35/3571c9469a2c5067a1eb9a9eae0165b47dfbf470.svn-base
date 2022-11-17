package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.control.idm.special.ListAi;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of IdmListAi
 * 
 */
@Repository("idmListAiDao")
public class ListAiDaoImpl extends AbstractDao<ListAi, Long> implements IListAiDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public PageList<ListAi> findAiList(Page page, Criteria criteria, Order od){
        PageList<ListAi> result = this.getPageList(page, criteria, od);
        return result;
    }

    public List<ListAi> findAiList(Criteria criteria, Order od){
       List<ListAi> result = this.getList(criteria, od);
        return result;
    }
}