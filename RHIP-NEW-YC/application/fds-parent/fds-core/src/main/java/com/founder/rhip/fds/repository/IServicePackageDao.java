package com.founder.rhip.fds.repository;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.fds.entity.ServicePackage;

import java.util.List;

/**
 * DAO interface of ServicePackage
 * 
 */
public interface IServicePackageDao extends IDao<ServicePackage,Long> {
    /**
     * 根据人群人类获取服务包列表
     * @param groupClassifications
     * @param codes
     * @return
     */
    List<ServicePackage> getAvailableList(String[] groupClassifications, String[] codes);
}