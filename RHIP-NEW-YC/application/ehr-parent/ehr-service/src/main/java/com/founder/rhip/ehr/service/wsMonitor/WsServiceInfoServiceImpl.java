package com.founder.rhip.ehr.service.wsMonitor;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.wsMonitor.WsClientInfo;
import com.founder.rhip.ehr.entity.wsMonitor.WsOperationLog;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceClient;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceInfo;
import com.founder.rhip.ehr.repository.wsMonitor.IWsClientInfoDao;
import com.founder.rhip.ehr.repository.wsMonitor.IWsOperationLogDao;
import com.founder.rhip.ehr.repository.wsMonitor.IWsServiceClientDao;
import com.founder.rhip.ehr.repository.wsMonitor.IWsServiceInfoDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("wsServiceInfoService")
@TaskBean(cron = "0 0 4 * * ?", description = "ws操作日志只保留前七天的数据")
public class WsServiceInfoServiceImpl extends AbstractService implements
        IWsServiceInfoService, Task {

	@Resource(name = "wsServiceInfoDao")
	private IWsServiceInfoDao wsServiceInfoDao;

	@Resource(name = "wsClientInfoDao")
	private IWsClientInfoDao wsClientInfoDao;

	@Resource(name = "wsServiceClientDao")
	private IWsServiceClientDao wsServiceClientDao;

	@Resource(name = "wsOperationLogDao")
	private IWsOperationLogDao wsOperationLogDao;

	@Override
	public PageList<WsServiceInfo> getPageList(Page page, Criteria criteria, Order order, String... properties) {
		return wsServiceInfoDao.getPageList(page, criteria, order, properties);
	}

	@Override
	public List<WsServiceInfo> getList(Criteria criteria, Order order, String... properties) {
		return wsServiceInfoDao.getList(criteria, order, properties);
	}

	@Override
	public List<WsServiceClient> getWsServiceClientList(String wsServiceName, String ip) {
		return wsServiceClientDao.getWsServiceClientList(wsServiceName, ip);
	}

	@Override
	public List<WsServiceClient> getWsServiceClientList(Criteria criteria) {
		return wsServiceClientDao.getList(criteria);
	}

	@Override
	public WsClientInfo getWsClientInfo(Criteria criteria) {
		return wsClientInfoDao.get(criteria);
	}

	@Override
	public Long saveWsOperationLog(WsOperationLog wsOperationLog) {
		Number id = wsOperationLogDao.insert(wsOperationLog);
		Assert.notNull(id);
		return id.longValue();
	}

	@Override
	public WsServiceInfo getWsServiceInfo(Criteria criteria){
		return wsServiceInfoDao.get(criteria);
	}

	@Override
	public Long saveWsServiceInfo(WsServiceInfo wsServiceInfo) {
		Long id  = wsServiceInfo.getId();
		if(ObjectUtil.isNotEmpty(wsServiceInfo.getId())) {
			wsServiceInfoDao.update(wsServiceInfo);
		} else{
			Number numId = wsServiceInfoDao.insert(wsServiceInfo);
			id = numId.longValue();
		}
		return id;
	}

	@Override
	public Long editWsServiceInfo(WsServiceInfo wsServiceInfo, String properties) {
		return Long.valueOf(wsServiceInfoDao.update(wsServiceInfo, properties));
	}

	@Override
	public PageList<WsOperationLog> getLogList(Page page, Criteria criteria, Order order) {
		return wsOperationLogDao.getPageList(page,criteria,order);
	}

	@Override
	public WsOperationLog getWsOperationLog(Criteria criteria) {
		return wsOperationLogDao.get(criteria);
	}

	@Override
	public void deleteService(Long id){
		wsServiceInfoDao.delete(new Criteria("id", id));
		wsServiceClientDao.delete(new Criteria("SERVICE_ID", id));
	}

	/**
	 * 获取机构访问数量
	 * @param criteria
	 * @return
	 */
	public Long getServiceAccessCount(Criteria criteria){
		return wsOperationLogDao.getCount(criteria,"webServiceName",Long.class);
	}

	private void deleteWsOperationLog(int days) {
		Date date = DateUtil.getBeforeDay(new Date(), days);
		Criteria criteria = new Criteria("START_TIME", OP.LT, DateUtil.makeTimeToMax(date));
		wsOperationLogDao.delete(criteria);
	}

	@Override
	public void run(Map<String, Object> data) {
		Object param = data.get(TaskConstants.TASK_PARAM_KEY);
		Integer days = 7;
		if (null != param) {
			try {
				days = Integer.parseInt(param.toString());
			} catch (Exception e) {
			}
		}
		deleteWsOperationLog(days);
	}

}
