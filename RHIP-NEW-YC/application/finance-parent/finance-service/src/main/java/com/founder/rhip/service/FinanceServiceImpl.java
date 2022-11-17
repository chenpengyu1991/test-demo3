package com.founder.rhip.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.finance.FcOrganFinanceInfo;
import com.founder.rhip.ehr.entity.finance.FcPubFinanceDetails;
import com.founder.rhip.ehr.entity.finance.FcPubFinanceInfo;
import com.founder.rhip.ehr.repository.finance.IFcOrganFinanceInfoDao;
import com.founder.rhip.ehr.repository.finance.IFcPubFinanceDetailsDao;
import com.founder.rhip.ehr.repository.finance.IFcPubFinanceInfoDao;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by chen_haibing on 9/11/2014.
 */
@Service("financeService")
public class FinanceServiceImpl implements IFinanceService {

    @Resource(name = "fcPubFinanceInfoDao")
    private IFcPubFinanceInfoDao pubFinanceInfoDao;

    @Resource(name = "pubFinanceDetailsDao")
    private IFcPubFinanceDetailsDao pubFinanceDetailsDao;

    @Resource(name = "fcOrganFinanceInfoDao")
    private IFcOrganFinanceInfoDao organFinanceInfoDao;

    
    @Override
     public List<FcPubFinanceInfo> getPubFinanceInfoList(Criteria criteria) {
        return pubFinanceInfoDao.getList(criteria);
    }
    @Override
    public List<FcPubFinanceDetails> getPubFinanceDetailsList(Criteria criteria) {
       return pubFinanceDetailsDao.getList(criteria);
   }
    @Override
	public List<FcOrganFinanceInfo> getOrganFinanceInfoList(Criteria criteria) {
		// TODO Auto-generated method stub
		return  organFinanceInfoDao.getList(criteria);
	}
  
    @Override
    public int savePubFinanceInfo(FcPubFinanceInfo fcPubFinanceInfo){
        return pubFinanceInfoDao.insert(fcPubFinanceInfo);
    }
	@Override
	public int savePubFinanceDetails(FcPubFinanceDetails fcPubFinanceDetails) {
		return pubFinanceDetailsDao.insert(fcPubFinanceDetails);
	}
    

    @Override
    public int saveOrganFinanceInfo(FcOrganFinanceInfo fcOrganFinanceInfo){
        return organFinanceInfoDao.insert(fcOrganFinanceInfo);
    }
    
	


}
