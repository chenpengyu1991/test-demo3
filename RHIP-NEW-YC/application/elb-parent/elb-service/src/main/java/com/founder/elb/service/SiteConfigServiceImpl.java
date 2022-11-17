/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.elb.service;

import com.founder.elb.entity.SiteConfig;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;


public class SiteConfigServiceImpl extends AbstractService  implements ISiteConfigService {


	/**
	 * 系统参数查询
	 * 
	 * @return SetConfig
	 */
	public SiteConfig getSetConfiguration() {
		return genericDao.get(SiteConfig.class,1);
	}

	/**
	 * 恢复默认参数
	 * 
	 * @return int
	 */
	public int resetSetConfiguration() {
		int result = 0;
		SiteConfig siteConfig = genericDao.get(SiteConfig.class,2);
		siteConfig.setId(1);
		result = genericDao.update(siteConfig);
		return result;
	}

	/**
	 * 系统参数更新
	 * 
	 * @param SetConfig
	 * @return int
	 */
	public int updateSetConfiguration(SiteConfig setConfig) {
		int result = 0;
		if (ObjectUtil.isNotEmpty(setConfig)) {
			result = genericDao.update(setConfig);
		}
		return result;
	}

	@Override
	public SiteConfig getSetConfiguration(Integer id) {
		SiteConfig siteConfig = null;
		if (ObjectUtil.isNotEmpty(id)) {
			siteConfig = genericDao.get(SiteConfig.class,id);
		}
		
		return siteConfig;
	}
}