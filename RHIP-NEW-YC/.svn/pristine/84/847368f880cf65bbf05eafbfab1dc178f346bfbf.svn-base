package com.founder.rhip.fds.service;


import com.founder.rhip.fds.entity.ServiceItem;
import com.founder.rhip.fds.entity.ServicePackage;
import com.founder.rhip.fds.entity.ServiceRelPackageItem;

import java.util.List;

/**
 * Created by wansong on 2017/6/7.
 */
public interface ServicePackageService {

      /**
     * 获取服务包及关联服务项目
     * @param packageCode
     * @return
     */
      ServicePackage getServicePackage(String packageCode);

      /**
       * 获取可用服务包
       * @param groupClassifications
       * @param codes
       * @return
       */
      List<ServicePackage> getAvailableList(String[] groupClassifications, String[] codes);

      /**
       * 获取某个服务包的服务项目关系数据
       * @param packageCode
       * @return
       */
      List<ServiceRelPackageItem> getServiceItemListOfPackage(String packageCode);

      /**
       * 获取服务项目
       * @param serviceItemCode
       * @return
       */
      ServiceItem getServiceItem(String serviceItemCode);
}
