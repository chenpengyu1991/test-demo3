/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;
import com.founder.rhip.ehr.entity.basic.PersonInfoAdditional;
import com.founder.rhip.ehr.repository.basic.IPersonDeathRecordDao;
import com.founder.rhip.ehr.repository.basic.IPersonInfoAdditionalDao;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.RecordCountDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfoTemp;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.basic.IPersonInfoTempDao;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;

/**
 * The type PersonalRecordServiceImpl.
 */
@Service("personalRecordService")
public class PersonalRecordServiceImpl extends AbstractService implements IPersonalRecordService {

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "personInfoTempDao")
	private IPersonInfoTempDao personInfoTempDao;

    @Resource(name = "personDeathRecordDao")
    private IPersonDeathRecordDao personDeathRecordDao;

	@Resource(name = "personInfoAdditionalDao")
	private IPersonInfoAdditionalDao personInfoAdditionalDao;
    /**
     * 导出健康档案列表
     *
     * @return void
     */
	public void exportPersonalRecord() {
		// TODO
	}

	/**
	 * 分类统计个人建档信息(待建档、待转入、已迁出、已注销、迁移中、待分配、已分配健康档案)
	 * 
	 * @param
	 * @return RecordCountDTO
	 */
	public RecordCountDTO statisticPersonalRecord(String organCode) {
		RecordCountDTO result = null;
		// TODO
		return result;
	}

	/**
	 * 导出分类统计个人建档信息
	 * 
	 * @return void
	 */
	public void exportStatisticPersonalRecord(String organCode) {
		// TODO
	}

	/**
	 * 二星及以上的完整率
	 * 
	 * @return void
	 */
	public void statisticIntactRateForTwoStar() {
		// TODO
	}

	@Override
	public PageList<PersonInfo> getPersonRecordList(Criteria criteria, Page page, Order order) {
		String[] str = { "remarks","id", "name", "idCard", "healthFileNo","householdType", "inputOrganName", "inputOrganCode", "gender", "birthday", "updateDate", "paprovince", "pacity", "pacounty", "patownShip", "pastreet", "pahouseNumber",
				"filingFlag", "star", "phoneNumber", "nation","paAddress","livingType" };

		return personInfoDao.getPageList(page, criteria, order, str);
	}

	@Override
	public List<Map<String, Object>> exportPersonRecordList(Page page, Criteria criteria, Order order) {
		String[] str = { "name", "idCard", "householdType", "gender", "birthday", "updateDate", "paprovince", "pacity", "pacounty", "patownShip", "pastreet", "pahouseNumber",
				"filingFlag", "star", "phoneNumber", "nation", "hrcounty","inputName","hrtownShip", "hrstreet", "hrhouseNumber", "inputDate", "physiciansCaringName", "inputOrganCode", "guardianPhoneOne", "inputerId","healthFileNo","remarks","clinicDate" };
		PageList<Map<String, Object>> pageList = personInfoDao.queryPageMapList(page, criteria, order);
		List<Map<String, Object>> list = null;
		if (null != pageList) {
			list = pageList.getList();
		}
		if (null == list) {
			return Collections.emptyList();
		}
		return list;
	}

	@Override
	public List<PersonInfo> getPersonRecordList(Criteria criteria) {
		return personInfoDao.getList(criteria);
	}

	@Override
	public PersonInfo getPersonRecord(Criteria criteria, String... properties) {
		return personInfoDao.get(criteria,properties);
	}

	@Override
	public PageList<PersonInfoTemp> getPersonRecordTempList(Criteria criteria, Page page, Order order) {
		// return personInfoTempDao.getPageList(page,criteria,order);
		return personInfoTempDao.getPersonInfoTempPageList(page, criteria);
	}

	@Override
	public PersonInfoTemp getPersonInfoTemp(Criteria criteria) {
		return personInfoTempDao.get(criteria);
	}


    @Override
    public List<PersonDeathRecord> getDeathPersonRecords(Criteria criteria,Order order,String... properites){
        return  personDeathRecordDao.getList(criteria,order,properites);
    }

	@Override
	public PageList<PersonInfo> queryPersonRecordList(Criteria criteria,
			Page page, Order order) {
		return personInfoDao.queryPageList(page, criteria, order);
	}

	@Override
	public PersonInfoAdditional getPersonInfoAdditional(String idcard) {
		Criteria criteria = new Criteria();
		criteria.add("idCard",idcard);
		return personInfoAdditionalDao.get(criteria);
	}

	@Override
	public Long getPersonInfoAdditionalId(String idcard) {
		PersonInfoAdditional personInfoAdditional = personInfoAdditionalDao.get(new Criteria("idCard",idcard), "id");
		return ObjectUtil.isNotEmpty(personInfoAdditional) ? personInfoAdditional.getId() : null;
	}

}