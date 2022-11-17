package com.founder.rhip.fds.service;


import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.fds.entity.ServiceRecord;

public interface ServiceRecordService {

    /**
     * 新增
     * @param serviceRecord
     * @param currentUser
     * @return
     */
    int addServiceRecord(ServiceRecord serviceRecord, String currentUser);

    /**
     * 获取服务记录
     * @param criteria
     * @return
     */
    ServiceRecord getServiceRecord(Criteria criteria);

    /**
     * 分页查询服务记录
     * @param criteria
     * @param page
     * @param order
     * @return
     */
    PageList<ServiceRecord> getList(Criteria criteria, Page page, Order order);
    
    /**
     * 同步区域卫生信息平台高血压随访数据到家医平台
     * @param dmHypertensionFollowup
     */
    void synchronize(DmHypertensionFollowup dmHypertensionFollowup, User user);
    
    /**
     * 同步区域卫生信息平台慢病随访数据到家医平台
     * @param dynaBean 随访数据对象
     * @param user 区域卫生信息平台操作用户
     * @param type 慢病类型1:高血压 2:糖尿病
     */
    void synchronize(ConvertingWrapDynaBean dynaBean, User user, int type);
}
