package com.founder.rhip.cdm.service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.service.IPersonCancelListener;
import com.founder.rhip.ehr.service.personal.IPersonRecordActivateService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 健康档案人员注销和恢复
 * 
 * @author liuk
 * 
 */
@Component
public class PersonCancelListener implements IPersonCancelListener, IPersonRecordActivateService {

	@Resource(name = "standardizationService")
	private IStandardizationService standardizationService;

	@Resource
	private IHighRiskService highRiskService;
	
	@Override
	@Transactional
	public void cancelPerson(Long personId, String smpiId) {
		if (ObjectUtil.isNotEmpty(personId)) {
			// 当人员被健康档案注销后,慢病系统撤销管理此人
			// 管理卡
			standardizationService.cancelManage(personId);
			// TODO 高危人员 是否需要结束管理
//			highRiskService.highRiskEndManage(personId);
		}
	}

	@Override
	@Transactional
	public void activatePerson(Long personId, String smpiId) {
		if (ObjectUtil.isNotEmpty(personId)) {
			standardizationService.recoveryManage(personId);
			//高危恢复管理
//			highRiskService.highRiskRecoverManage(personId);
		}
	}

}
