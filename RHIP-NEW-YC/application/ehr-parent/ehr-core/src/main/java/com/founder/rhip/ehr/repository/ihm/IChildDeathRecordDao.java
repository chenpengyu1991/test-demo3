package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.child.ChildDeathRecord;

import java.util.List;

public interface IChildDeathRecordDao extends IDao<ChildDeathRecord, Long>{
	
	/**
     * 儿童死亡率统计，修改
     * @param criteria
     * @return
     */
    public List<ChildDeathRecord> getChildDeathMortality(String criteria, String gbCode);
}
