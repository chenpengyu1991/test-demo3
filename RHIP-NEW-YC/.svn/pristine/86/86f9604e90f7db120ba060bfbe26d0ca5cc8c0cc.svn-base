package com.founder.rhip.fds.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.fds.common.FDSConstants;
import com.founder.rhip.fds.entity.ServiceItem;
import com.founder.rhip.fds.entity.ServicePackage;
import com.founder.rhip.fds.entity.ServiceRelPackageItem;
import com.founder.rhip.fds.repository.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("servicePackageService")
public class ServicePackageServiceImpl extends AbstractService implements ServicePackageService {

	@Resource(name = "servicePackageDao")
	private IServicePackageDao servicePackageDao;
	@Resource(name = "serviceItemDao")
	private IServiceItemDao serviceItemDao;
	@Resource(name = "serviceRelPackageItemDao")
	private IServiceRelPackageItemDao serviceRelPackageItemDao;
	@Override
	public ServicePackage getServicePackage(String packageCode) {
		//获取服务包
		ServicePackage result = servicePackageDao.get(new Criteria("code",packageCode));
		if(ObjectUtil.isNotEmpty(result)) {
			//获取服务包关联服务项目
			Criteria criteria = new Criteria("PACKAGE_CODE", packageCode);
			List<ServiceItem> serviceItems = serviceItemDao.getServiceItemList(criteria);
			result.setServiceItems(serviceItems);
		}
		return result;
	}

	@Override
	public List<ServicePackage> getAvailableList(String[] groupClassifications, String[] codes) {
		return servicePackageDao.getAvailableList(groupClassifications,codes);
	}

	@Override
	public List<ServiceRelPackageItem> getServiceItemListOfPackage(String packageCode) {
		return serviceRelPackageItemDao.getServiceItemListOfPackage(packageCode);
	}

	@Override
	public ServiceItem getServiceItem(String serviceItemCode) {
		return serviceItemDao.get(new Criteria("code",serviceItemCode));
	}


}
