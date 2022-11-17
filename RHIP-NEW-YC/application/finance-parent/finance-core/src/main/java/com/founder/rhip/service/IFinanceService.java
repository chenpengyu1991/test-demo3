package com.founder.rhip.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.finance.FcOrganFinanceInfo;
import com.founder.rhip.ehr.entity.finance.FcPubFinanceDetails;
import com.founder.rhip.ehr.entity.finance.FcPubFinanceInfo;

import java.util.List;

public interface IFinanceService {

    /**
     * 查询公立医院收支情况
     * @param criteria
     * @return
     */
    public List<FcPubFinanceInfo> getPubFinanceInfoList(Criteria criteria);
    /**
     * 查询公立医院收支明细
     * @param criteria
     * @return
     */
    public List<FcPubFinanceDetails> getPubFinanceDetailsList(Criteria criteria);
   
    /**
     * 查询基层医疗卫生机构收支情况
     * @param criteria
     * @return
     */
    public List<FcOrganFinanceInfo> getOrganFinanceInfoList(Criteria criteria);

    /**
     * 保存公立医院收支情况
     * @param fcPubFinanceInfo
     * @return
     */
    public int savePubFinanceInfo(FcPubFinanceInfo fcPubFinanceInfo);
    public int savePubFinanceDetails(FcPubFinanceDetails fcPubFinanceDetails);
    public int saveOrganFinanceInfo(FcOrganFinanceInfo fcOrganFinanceInfo);

}
