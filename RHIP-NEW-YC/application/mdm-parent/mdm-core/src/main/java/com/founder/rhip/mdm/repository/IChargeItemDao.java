package com.founder.rhip.mdm.repository;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.SzdTophoschargeitem;

public interface IChargeItemDao extends IDao<SzdTophoschargeitem, String> {

	public void insertChargeItemLog(Criteria criteria);

}
