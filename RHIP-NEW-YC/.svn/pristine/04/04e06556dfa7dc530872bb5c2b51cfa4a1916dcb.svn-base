package com.founder.rhip.ehr.repository.cic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.cic.CicCitizenCard;
/**
 * DAO interface of CicCitizenCard
 * 
 */
public interface ICicCitizenCardDao extends IDao<CicCitizenCard,Long> {

    public PageList<CicCitizenCard> getCicCitizenCardList(Criteria criteria, Page page);

	public List<Map<String,Object>> getCicCitizenCardStatistic(Criteria criteria);
}