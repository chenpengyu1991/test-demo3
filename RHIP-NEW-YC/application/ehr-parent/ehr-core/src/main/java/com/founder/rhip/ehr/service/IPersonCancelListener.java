package com.founder.rhip.ehr.service;

/**
 * 注销接口
 * @author ggf
 *
 */
public interface IPersonCancelListener {
	/**
	 * 根据PersonId注销人员档案
	 * @param personId
	 */
	public void cancelPerson(Long personId, String smpiId);
}