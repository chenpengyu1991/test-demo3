package com.founder.rhip.ehr.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.ihm.DoubleVisDTO;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;

public interface IDualReferralService {

	public List<ReferralInfo> getList(Criteria criteria);
	
	public PageList<ReferralInfo> getPageList(Page page, Criteria criteria);

	public ReferralInfo getReferralInfo(Criteria criteria);

	public int save(ReferralInfo referralInfo);

	public int delete(ReferralInfo referralInfo);
	
	/**
	 * 根据居民ID，转诊时间查询转诊记录
	 * @param personId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<ReferralInfo> queryReferralInfoList(Long personId, Date beginDate, Date endDate);
	
	/**
	 * 根据居民PIX ID，转诊时间查询转诊记录
	 * @param personId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<ReferralInfo> queryReferralInfoList(String pixId, Date beginDate, Date endDate);
	
	
	 /**
     * 双向转诊统计
     *
     * @param criteria
     * @return
     * @author wangzhou
     */
    public List<DoubleVisDTO> getDoubleVisList(Map<String, String> map);
    
}
