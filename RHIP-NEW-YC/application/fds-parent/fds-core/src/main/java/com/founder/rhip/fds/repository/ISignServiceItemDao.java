package com.founder.rhip.fds.repository;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.fds.entity.SignServiceItem;

import java.util.Map;

/**
 * DAO interface of SignServiceItem
 * 
 */
public interface ISignServiceItemDao extends IDao<SignServiceItem,Long> {

    /**
     * 更新实际服务次数
     * @param signId
     * @param servicePackageCode
     * @param serviceItemCode
     * @return
     */
    int countActualTimes(Long signId,String servicePackageCode,String serviceItemCode);
}