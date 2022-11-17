/**
/* * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.clinic.IExpenseDetailDao;
import com.founder.rhip.ehr.repository.clinic.IExpenseInfoDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientPrescriptionDao;
import com.founder.rhip.ehr.repository.clinic.ISurgeryInfoDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

/**
 * 信息标示
 * @author gaogf
 */
@Service("msTrigerService")
@TaskBean(description = "信息标识", cron = "0 0 23 * * ?")
public class MsTrigerServiceImpl extends AbstractService implements IMsTrigerService,Task {

	@Autowired
	private IOutpatientPrescriptionDao outpatientPrescriptionDao;
	
	@Autowired
	private IDrugUsageDao drugUsageDao;
	
	@Resource(name = "expenseInfoDao")
	private IExpenseInfoDao expenseInfoDao;
	
	@Resource(name = "expenseDetailDao")
	private IExpenseDetailDao expenseDetailDao;
	
	@Resource(name = "surgeryInfoDao")
	private ISurgeryInfoDao surgeryInfoDao;
	
	/**
     * 根据ehr_id区分是住院还是门诊来填充op_em_hp_mark
     * EHR_ID门诊是mz开头的
     * zy开头的是住院
     * 急诊的活动号也是mz 
     * 1、2:急诊、普通门诊 3：住院
     */
//	@Scheduled(cron = "0 0 23 * * ?")
	public void updateMsMark() {
		/*处方信息*/
		outpatientPrescriptionDao.updateOpEmHpMark();
//		outpatientPrescriptionDao.update(new Parameters("op_em_hp_mark", "1"), new Criteria("op_em_hp_mark",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "mz"));
//		outpatientPrescriptionDao.update(new Parameters("op_em_hp_mark", "2"), new Criteria("op_em_hp_mark",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "zy"));
		/*住院医嘱表*/
		drugUsageDao.updateClinicMark();
//		drugUsageDao.update(new Parameters("CLINIC_MARK", "1"), new Criteria("CLINIC_MARK",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "mz"));
//		drugUsageDao.update(new Parameters("CLINIC_MARK", "2"), new Criteria("CLINIC_MARK",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "zy"));
		/*费用表*/
		expenseInfoDao.updateOpEmHpMark();
//		expenseInfoDao.update(new Parameters("OP_EM_HP_MARK", "1"), new Criteria("OP_EM_HP_MARK",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "mz"));
//		expenseInfoDao.update(new Parameters("OP_EM_HP_MARK", "2"), new Criteria("OP_EM_HP_MARK",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "zy"));
		/*费用明细表*/
		expenseDetailDao.updateClinicMark();
//		expenseDetailDao.update(new Parameters("CLINIC_MARK", "1"), new Criteria("CLINIC_MARK",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "mz"));
//		expenseDetailDao.update(new Parameters("CLINIC_MARK", "2"), new Criteria("CLINIC_MARK",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "zy"));
		/*手术信息表*/
		surgeryInfoDao.updateOpEmHpMark();
//		surgeryInfoDao.update(new Parameters("OP_EM_HP_MARK", "1"), new Criteria("OP_EM_HP_MARK",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "mz"));
//		surgeryInfoDao.update(new Parameters("OP_EM_HP_MARK", "2"), new Criteria("OP_EM_HP_MARK",OP.IS, "NULL").add("ehr_id",OP.FLIKE, "zy"));
	}

	@Override
	public void run(Map<String, Object> data) {
		this.updateMsMark();
	}
}