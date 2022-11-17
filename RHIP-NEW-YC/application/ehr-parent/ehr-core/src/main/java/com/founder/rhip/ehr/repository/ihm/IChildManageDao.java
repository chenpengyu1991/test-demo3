package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.child.ChildUnderThreeManage;

import java.util.List;

public interface IChildManageDao extends IDao<ChildUnderThreeManage, Long>{
	
	/**
     * 儿童管理率统计，修改
     * @param criteria
     * @return
     */
    public List<ChildUnderThreeManage> getChildManageRate(String criteria, String gbCode);
}
