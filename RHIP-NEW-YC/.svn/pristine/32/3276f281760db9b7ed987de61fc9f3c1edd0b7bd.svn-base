package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugPrice;

/**
 * DAO interface of MhmDrugPrice
 * 
 */
public interface IMhmDrugPriceDao extends IDao<MhmDrugPrice,Long> {

    /**
     * 根据药品ID获取历史记录中最新一条记录
     *
     * @param drugId
     * @return
     * @author Ye jianfei
     */
    public MhmDrugPrice findDrugPrice(Long drugId);
}