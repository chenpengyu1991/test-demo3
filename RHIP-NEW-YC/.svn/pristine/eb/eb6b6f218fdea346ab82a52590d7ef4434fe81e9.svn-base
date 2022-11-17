package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;

/**
 * Created by wang_zhou on 2015/6/15.
 */

/**
 * DAO interface of ReferralInfo
 */
public interface IReferralInfoDoubleDao extends IDao<ReferralInfo, Long> {
    /**
     * 双向转诊统计
     *
     * @param criteria
     * @return
     * @author wangzhou
     */

    /**
     * 转出
     * @param criteria 查询条件
     * @return
     */
    public Integer getOutList(Criteria criteria);

    /**
     * 转入
     * @param criteria 查询条件
     * @return
     */
    public Integer getInList(Criteria criteria);
}