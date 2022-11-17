package com.founder.rhip.portal.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.entity.portal.FrequentContacts;
import com.founder.rhip.ehr.repository.portal.IAccountInfoDao;
import com.founder.rhip.ehr.repository.portal.IFrequentContactsDao;

/**
 * Created by ss on 2015/11/10.
 */
@Service("lhFrequentContactsService")
public class FrequentContactsImpl extends AbstractService implements IFrequentContactsService {

    @Resource(name = "lhFrequentContactsDao")
    private IFrequentContactsDao frequentContactsDao;
    
    @Autowired
	private IAccountInfoDao accountInfoDao;

    private String[] updateProperties = new String[]{FrequentContacts.GENDER, FrequentContacts.CARD_NO,
            FrequentContacts.BIRTHDAY, FrequentContacts.FREQUENT_NAME, FrequentContacts.TELEPHONE};

    @Override
	public FrequentContacts get(Long id) {
		return frequentContactsDao.get(id);
	}
    
    @Override
	public int update(Parameters parameters, Criteria criteria) {
		return frequentContactsDao.update(parameters, criteria);
	}
    
    @Override
    public PageList<FrequentContacts> getFrequentPageList(Page page, Criteria criteria) {
        return frequentContactsDao.getPageList(page, criteria);
    }

    @Override
    public PageList<FrequentContacts> getRealNameByFrequentPageList(Page page, Criteria criteria) {
        return frequentContactsDao.getRealNameByFrequentPageList(page, criteria);
    }
    
    @Override
    public String update(FrequentContacts frequentContacts, Long accountId) {
        if (ObjectUtil.isNullOrEmpty(frequentContacts) || ObjectUtil.isNullOrEmpty(frequentContacts.getCardNo())) {
            return EHRConstants.FREQUENT_FAIL;
        }
        FrequentContacts frequentContactsDb = frequentContactsDao.get(new Criteria(FrequentContacts.CARD_NO, frequentContacts.getCardNo()).add(FrequentContacts.ACCOUNT_ID, accountId));
        AccountInfo accountInfo = accountInfoDao.get(new Criteria("ID", accountId));
        int result = 0;
        if (ObjectUtil.isNotEmpty(frequentContacts.getId())) { // 修改
            if (ObjectUtil.isNotEmpty(frequentContactsDb) && (!frequentContacts.getId().equals(frequentContactsDb.getId()))) {
                return EHRConstants.FREQUENT_REPEAT;
            }
            result = frequentContactsDao.update(frequentContacts, updateProperties);
        } else { //新增
            if (ObjectUtil.isNotEmpty(frequentContactsDb)) return EHRConstants.FREQUENT_REPEAT;
            if (ObjectUtil.equals(accountInfo.getCardNo(), frequentContacts.getCardNo())) return EHRConstants.FREQUENT_REPEAT_ACCOUNT;
            result = frequentContactsDao.insert(frequentContacts);
        }
        if (ObjectUtil.isNotEmpty(result) && result > 0) {
            return EHRConstants.FREQUENT_OK;
        }
        return EHRConstants.FREQUENT_FAIL;
    }


    @Override
    public String delete(Long id) {
        int result = frequentContactsDao.delete(new Criteria(FrequentContacts.ID, id));
        if (ObjectUtil.isNotEmpty(result) && result > 0) {
            return EHRConstants.FREQUENT_OK;
        }
        return EHRConstants.FREQUENT_FAIL;
    }

    @Override
    public List<FrequentContacts> getFrequentContactsLists(Criteria criteria) {
        return frequentContactsDao.getList(criteria);/*getFrequentList*/
    }
    
    @Override
    public List<FrequentContacts> getFrequentContactsByOrderLists(Criteria criteria, Order order) {
        return frequentContactsDao.getList(criteria,order);/*getFrequentList*/
    }

    @Override
    public FrequentContacts getFrequent(Criteria criteria) {
        return frequentContactsDao.get(criteria);
    }

}
