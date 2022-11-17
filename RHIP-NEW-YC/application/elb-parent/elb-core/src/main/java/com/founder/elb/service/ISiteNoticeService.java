/**
 * copyright    Relax4J 2011
 * @date        2012-02-15
 * @author      founder
 * @version     V1.0
 * @describe    通知服务
 */

package com.founder.elb.service;

import java.util.List;

import com.founder.elb.entity.SiteNotice;
import com.founder.fasf.beans.Criteria;


public interface ISiteNoticeService
{
	/**
	 * 发送站内信
	 * @param       SiteNotice
	 * @return      int
	 */
	int sendSiteNotice(SiteNotice siteNotice);
	
	/**
	 * 得到指定内容站内信
	 * @param       Notice
	 * @return      int
	 */
	List<SiteNotice> getSiteNotices(Criteria criteria);
	
	/**
	 * 删除指定内容站内信
	 * @param       Notice
	 * @return      int
	 */
	int deleteSiteNotices(Integer...id);
	
	/**
	 * 更新信息状态(已读未读)
	 * @param       SiteNotice
	 * @return      int
	 */
	public int updateSiteNotice(SiteNotice siteNotice);

}