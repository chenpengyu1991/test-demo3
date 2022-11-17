package com.founder.elb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.founder.elb.entity.SiteNotice;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;

@Service("siteNoticeService")
public class SiteNoticeServiceImpl extends AbstractService implements ISiteNoticeService {

	/**
	 * 发送站内信
	 * @param       SiteNotice
	 * @return      int
	 */
	public int sendSiteNotice(SiteNotice siteNotice) {
		int result = 0;

		if (ObjectUtil.isNotEmpty(siteNotice)) {
			result = genericDao.insert(siteNotice);
		}
		return result;
	}
	
	/**
	 * 得到指定内容站内信
	 * @param       Notice
	 * @return      int
	 */
	public List<SiteNotice> getSiteNotices(Criteria criteria) {
		List<SiteNotice> siteNoticeList = null;
		if (ObjectUtil.isNotEmpty(criteria)) {
			siteNoticeList = genericDao.getList(SiteNotice.class,criteria);

		}
		return siteNoticeList;
	}

	/**
	 * 通过PK数组删除内容
	 * @param       Notice
	 * @return      int
	 */
	public int deleteSiteNotices(Integer...id) {
		
		int result = 0;
		if (id != null && id.length > 0) {
			result = genericDao.delete(SiteNotice.class,id);
		}

		return result;
	}
	
	/**
	 * 更新信息状态(已读未读)
	 * @param       SiteNotice
	 * @return      int
	 */
	public int updateSiteNotice(SiteNotice siteNotice) {
		int result = 0;

		if (ObjectUtil.isNotEmpty(siteNotice)) {
			result = genericDao.update(siteNotice);
		}
		return result;
	}
}
