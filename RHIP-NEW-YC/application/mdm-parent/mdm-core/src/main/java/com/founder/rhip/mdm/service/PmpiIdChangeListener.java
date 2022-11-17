package com.founder.rhip.mdm.service;

import com.founder.rhip.mdm.entity.Link;

import java.util.List;

public interface PmpiIdChangeListener {
	
	/**
	 * 个人唯一主索引创建
	 * @param pmpiId
	 * @param links
	 */
	public void create(String pmpiId, List<Link> links);
	
	/**
	 * 个人唯一主索引更新
	 * @param pmpiId
	 * @param links
	 */
	public void update(String pmpiId, List<Link> links);
	
	/**
	 * 个人唯一主索引删除
	 * @param pmpiId
	 */
	public void delete(String pmpiId);

}
