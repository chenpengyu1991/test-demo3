package com.founder.rhip.ehr.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.cic.CicCitizenCard;

/**
 * 市民卡查询统计
 */
public interface IHealthCardTargetService {
	
	/**
	 * 市民卡查询
	 * @param criteria
	 * @param page
	 * @return
	 */
	public PageList<CicCitizenCard> getCicCitizenCardList(Criteria criteria, Page page);

    /**
     * 市民卡历史查询
     * @param criteria
     * @param page
     * @return
     */
    public PageList<CicCitizenCard> getCicCitizenCardHistory(Criteria criteria, Page page);
	
	/**
	 * 获取市民卡信息
	 * @param id
	 * @return
	 */
	public CicCitizenCard getCicCitizenCard(Long id);
	
	/**
	 * 市民卡统计
	 * @param criteria
	 * @return
	 */
	public List<Map<String, Object>> getCicCitizenCardStatistic(Criteria criteria);
}