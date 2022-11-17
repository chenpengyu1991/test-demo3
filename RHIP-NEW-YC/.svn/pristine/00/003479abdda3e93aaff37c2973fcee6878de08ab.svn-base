/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.report.RpWeightSet;
import com.founder.rhip.ehr.repository.report.IRpWeightSetDao;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("rpWeightSetService")
public class RpWeightSetServiceImpl extends AbstractService implements IRpWeightSetService {

	@Resource(name = "rpWeightSetDao")
    private IRpWeightSetDao rpWeightSetDao;
	
	@Override
	public PageList<RpWeightSet> getWeightSets(Page page, Criteria criteria){
        return rpWeightSetDao.getWeightSets(criteria, page);
    }

	@Override
	public RpWeightSet getRpWeightSet(Criteria criteria) {
		return rpWeightSetDao.get(criteria);
	}
	
	/**
	 * 根据机构 类型和时间的查取表中的数据 只有一段时间在此时间段的也算
	 * @param organCode
	 * @param weightIndex
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<RpWeightSet> getWeightSets(String gbCode, String organCode, String weightIndex, Date beginDate, Date endDate) {
		return rpWeightSetDao.getWeightSets(gbCode, organCode, weightIndex, beginDate, endDate);
    }
	
	@Override
	public int insertRpWeightSet(RpWeightSet rpWeightSet) {
		return rpWeightSetDao.insert(rpWeightSet);
	}
	
	@Override
	public int updateRpWeightSet(RpWeightSet rpWeightSet) {
		return rpWeightSetDao.update(rpWeightSet);
	}

	@Override
	public int deletWeightSets(Criteria criteria){
		return rpWeightSetDao.delete(criteria);
	}

	@Override
	public List<Map<String, Object>> getStaffRpPaList(String organCode, String rpType, String weightIndex, String weightIndexColumn, String beginDate, String endDate){
		List<Map<String, Object>> result = rpWeightSetDao.getStaffRpPaList(organCode, rpType, weightIndex, weightIndexColumn, beginDate, endDate);
		return result;
	}
}