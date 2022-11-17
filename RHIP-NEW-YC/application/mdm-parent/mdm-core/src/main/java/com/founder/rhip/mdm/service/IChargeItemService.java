package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.SzdTophoschargeitem;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IChargeItemService {

	public List<Map<String, Object>> getLatestChargeItems(String organCode, Date lastDate);

	public List<SzdTophoschargeitem> getLatestChargeItems(String organCode, Integer type, Date lastDate);

	public Map<String, Object> getChargeItemInMap(Long catalogId, String tenantId);

	public int syncChargeItems(List<Map<String, Object>> chargeItems);

	public int syncChargeItem(Map<String,Object> item);

	public int insertChargeItems(List<Map<String, Object>> chargeItems);

	public int updateChargeItems(List<Map<String, Object>> chargeItems);

	public PageList<SzdTophoschargeitem> getChargeItems(Page page, Criteria criteria);

	public void updateChargeItemMapping(List<SzdTophoschargeitem> items);

	public SzdTophoschargeitem getChargeItem(String catalogId);
}
