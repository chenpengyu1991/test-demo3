package com.founder.rhip.portal.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.SmsRecord;
import com.founder.rhip.ehr.repository.portal.ISmsRecordDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("lhsmsService")
public class SmsRecordServiceImpl extends AbstractService implements ISmsRecordService {

	@Resource(name = "smsRecordDao")
	private ISmsRecordDao smsDao;

	@Override
	public PageList<SmsRecord> getSMSList(Criteria criteria, Page page) {
		PageList<SmsRecord> result = null;
		Order order = new Order("CREATE_TIME", false);
		if(ObjectUtil.isNotEmpty(page)){
			result = smsDao.getPageList(page, criteria, order);
		}
		return result;
	}

}
