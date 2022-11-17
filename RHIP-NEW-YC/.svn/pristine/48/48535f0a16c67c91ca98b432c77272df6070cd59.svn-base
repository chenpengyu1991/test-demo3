package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Record;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.entity.Domain;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.service.IDomainService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("domainApp")
public class DomainApp extends MDMBaseApp implements IDomainApp {

	@Resource(name="mdmDomainService")
	private IDomainService domainService;
	
	@Override
	public String registDomain(Domain domain) throws CheckException {
		domain.setOperateTime(getOperatorTime());
		domain.setOperateType(OperateType.regist.getName());
		
		Record record = new Record(domain);
		List<String> chkMessageList = new ArrayList<String>();
		checkAll(chkMessageList, record, EntityType.DOMAIN);
		if (chkMessageList.size() > 0) {
			throw getCheckException(chkMessageList);
		}
		
		String domainCode = domain.getDomainCode();
		Domain dbDomain = domainService.getDomain(domainCode);
		if (dbDomain == null) {
			domainService.insertDomain(domain);
		} else {
			domainService.updateDomain(domain);
		}
		return domainCode;
	}

	@Override
	public List<Domain> queryDomain(Criteria criteria) {
		return domainService.queryDomains(criteria);
	}

}
