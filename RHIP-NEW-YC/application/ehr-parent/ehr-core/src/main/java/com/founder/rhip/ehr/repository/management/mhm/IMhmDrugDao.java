package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;

import java.util.List;

/**
 * DAO interface of MhmDrugRecord
 * 
 */
public interface IMhmDrugDao extends IDao<MhmDrug,Long> {

    public List<MhmDrug> findDrugList(Criteria ca);

    /**
     * 获取药物列表，取版本号最大的记录
     * */
    public PageList<MhmDrug> findDrugList(Criteria ca,Page page);
}