package com.founder.rhip.ehr.repository.basic;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.PcbDicItem;
import com.founder.rhip.ehr.repository.basic.IPcbDicItemDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;

/**
 * DAO implement of IdmStatusInfo
 * 
 */
@Repository("pcbDicItemDao")
public class PcbDicItemDaoImpl extends AbstractDao<PcbDicItem, Integer> implements IPcbDicItemDao {
   
	@Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<PcbDicItem> queryDictionary(Criteria criteria) {
		String sql = "select distinct dic_code,item.item_code,item.item_name from pcb_dic_item item";
		return this.getList(sql, criteria);
	}

	@Override
	public List<PcbDicItem> queryDicItem(String dicCode) {
		Criteria criteria = new Criteria("dicCode", dicCode);
		return this.getList(criteria);
	}
    
}