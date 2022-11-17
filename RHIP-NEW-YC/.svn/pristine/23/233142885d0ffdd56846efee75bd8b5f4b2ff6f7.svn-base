package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.OutTransfer;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IOutTransferService{

	public PageList<OutTransfer> getPageList(Page page, Criteria criteria);

    public List<OutTransfer> getList(Criteria criteria);

	public OutTransfer getOutTransfer(Criteria criteria);

	public Number save(OutTransfer OutTransfer);

    public boolean getCenterApprove(OutTransfer outTransfer);

    public Map editWithCenterAudit(OutTransfer outTransfer);

    public int update(OutTransfer OutTransfer);

	/**
	 * 根据居民ID，转诊时间查询转诊记录
	 * @param personId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<OutTransfer> queryOutTransferList(Long personId, Date beginDate, Date endDate);
	
	/**
	 * 根据居民PIX ID，转诊时间查询转诊记录
	 * @param pixId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<OutTransfer> queryOutTransferList(String pixId, Date beginDate, Date endDate);

    public Long getCount(Criteria criteria, String countPropertyName);
}
