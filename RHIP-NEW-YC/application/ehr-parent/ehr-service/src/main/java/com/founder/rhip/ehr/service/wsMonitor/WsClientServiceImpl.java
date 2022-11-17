package com.founder.rhip.ehr.service.wsMonitor;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.wsMonitor.WsClientInfo;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceClient;
import com.founder.rhip.ehr.repository.wsMonitor.IWsClientInfoDao;
import com.founder.rhip.ehr.repository.wsMonitor.IWsServiceClientDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("wsClientInfoService")
public class WsClientServiceImpl extends AbstractService implements
        IWsClientInfoService {

	@Resource(name = "wsClientInfoDao")
	private IWsClientInfoDao wsClientInfoDao;

	@Resource(name = "wsServiceClientDao")
	private IWsServiceClientDao wsServiceClientDao;

	@Override
	public PageList<WsClientInfo> getPageList(Page page, Criteria criteria, Order order, String... properties) {
		return wsClientInfoDao.getPageList(page, criteria, order, properties);
	}

	@Override
	public WsClientInfo getWsClientInfo(Criteria criteria) {
		return wsClientInfoDao.get(criteria);
	}

	@Override
	public Long editWsClientInfo(WsClientInfo wsClientInfo, String properties) {
		return Long.valueOf(wsClientInfoDao.update(wsClientInfo, properties));
	}

	@Override
	public PageList<WsClientInfo> getAccessMap(Page page, String beginDate, String endDate, Criteria criteria) {
		return wsClientInfoDao.getAccessMap(page,beginDate,endDate,criteria);
	}

	@Override
	@Transactional
	public int changeOff(String orgCode,String isOff) {
		int result = 0;
		if(ObjectUtil.isNotEmpty(orgCode)){
			result = wsClientInfoDao.update(new Parameters("isOff","0".equals(isOff)?"1":"0"), new Criteria("orgCode", orgCode));
		}
		return result;
	}

	@Override
	@Transactional
	public Long saveWsClientInfo(WsClientInfo wsClientInfo, String serviceIds, HttpServletRequest request) {
		Number id = 0;
		//修改时
		if(null != wsClientInfo.getId() && wsClientInfo.getId() > 0){
			wsClientInfoDao.update(wsClientInfo);
			id = wsClientInfo.getId();
			wsServiceClientDao.delete(new Criteria("CLIENT_ID", id));
		}else{
			id = wsClientInfoDao.generatedKey(wsClientInfo, "ID", null);
			Assert.notNull(id);
		}
		List<WsServiceClient> wsServiceClients = new ArrayList<WsServiceClient>();
		for(String serviceId : serviceIds.split(",")) {
			WsServiceClient wsServiceClient = new WsServiceClient();
			wsServiceClient.setClientId(id.longValue());
			wsServiceClient.setServiceId(Long.valueOf(serviceId));
			wsServiceClient.setCreateDate(new Date());
			wsServiceClient.setCreateOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
			wsServiceClient.setCreateUserCode(SecurityUtils.getCurrentUser(request).getId().toString());
			wsServiceClients.add(wsServiceClient);
		}
		Number scId = wsServiceClientDao.batchInsert(wsServiceClients);
		Assert.notNull(scId);
		return scId.longValue();
	}

	@Override
	public void deleteClient(Long id){
		wsClientInfoDao.delete(new Criteria("id", id));
		wsServiceClientDao.delete(new Criteria("CLIENT_ID", id));
	}
}
