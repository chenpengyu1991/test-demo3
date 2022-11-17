package com.founder.rhip.ehr.service.personal;


public interface IPersonRecordActivateService {
	
	/**
	 * 根据PersonId激活人员档案
	 * @param personId
	 */
	public void activatePerson(Long personId, String smpiId);
}