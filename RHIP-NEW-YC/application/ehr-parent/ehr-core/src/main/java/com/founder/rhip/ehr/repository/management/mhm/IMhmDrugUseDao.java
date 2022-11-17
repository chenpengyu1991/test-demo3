package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugUse;

/**
 * DAO interface of MhmDrugRecord
 * 
 */
public interface IMhmDrugUseDao extends IDao<MhmDrugUse,Long> {

    /**
     * 获取发药列表
     * */
    public PageList<MhmDrugUse> findDrugUseList(Criteria ca,Page page);
    
    /**
     * 获取发药信息
     * */
    public MhmDrugUse getDrugUse(Criteria ca) ;   
}