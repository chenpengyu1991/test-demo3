package com.founder.rhip.fdm.service;

import com.founder.rhip.ehr.common.RoleType;

/**
 * 节点任务
 * 
 * @author liuk
 * 
 * @param <T>
 */
public interface IUserTask<T> {
	void execute(T t, RoleType roleType);
}
