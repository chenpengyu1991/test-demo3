package com.founder.rhip.fds.service;


import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.fds.entity.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by yejianfei on 2017/8/14
 * 个人签约.
 */
public interface PersonSignService {

    /**
     * 签约
     * @param sign
     * @param signPerson
     * @param servicePackageCodes
     * @return
     */
    void saveSignRecord(Sign sign, SignPerson signPerson, String[] servicePackageCodes) throws Exception;

    /**
     * 根据身份证号码判断是否已经签约（包括付费及未付费）
     * @param idcard
     * @return 1:已签约，2:签约，但未付费，3:未签约
     */
    int checkPersonSignFlag(String idcard);

    /**
     * 查询签约居民列表
     * @param criteria
     * @return
     */
    List<SignPerson> getSignPersonList(Criteria criteria);

    /**
     * 查询签约居民列表(分页)
     * @param criteria
     * @return
     */
    PageList<SignPerson> getSignPersonList(Criteria criteria, Page page, Order order);

    /**
     * 查询签约服务包（包含签约记录信息），已付费
     * @param idcard
     * @return
     */
    List<Sign> getServicePackageList(String idcard, Long signId);

    /**
     * 查询签约服务包（包含签约记录信息）,待付费状态
     * @param idcard
     * @return
     */
    List<Sign> getPaidServicePackageList(String idcard, Long signId, String valid);

    /**
     * 查询签约服务包（包含签约记录信息）
     * @param criteria: idcard,signId,paidFlag,valid
    paidFlag
    valid
     * @return
     */
    List<Sign> getPaidServicePackageList(Criteria criteria);

    /**
     * 查询签约服务包下属服务项目
     * @param servicePackageCode
     * @return
     */
    List<SignServiceItem> getSignServiceItemList(String servicePackageCode, Long signId);

    /**
     *  查询服务记录列表
     * @param criteria
     * @return
     */
    List<ServiceRecord> getServiceRecordList(Criteria criteria);

    PageList<ServiceRecord> getServiceRecordList(Criteria criteria, Page page, Order order);
    /**
     * 根据ID获取一个SignPerson实体
     * @param id
     * @return
     */
    SignPerson getSignPersonById(Long id);

    /**
     * 更新签约状态：本库签约信息，健康档案签约信息
     * @param
     * @param idcard
     * @param signId
     * @param packageCode
     * @return 0:失败
     */
    int updateSignStatus(String userName, Date paidTime, String idcard,Long signId, String packageCode);

    /**
     * 查询签约记录
     * @param criteria
     * @return
     */
    Sign getSignRecord(Criteria criteria);

    /**
     * 获取该医生签约居民的个数。
     * @param doctorId
     * @param teamCode  医生所在团队
     * @return Long 签约居民的个数。
     */
    Long getSignedNumberOfDoctor(Long doctorId, String teamCode);

    /**
     * 查询签约记录
     * @param criteria
     * @return
     */
    List<Sign> getSignList(Criteria criteria);

    /**
     * 查询签约记录
     * @param criteria
     * @return
     */
    PageList<Sign> getSignList(Criteria criteria, Page page, Order order);

    /**
     * 获取签约服务包列表
     * @param criteria
     * @return
     */
    List<SignServicePackage> getSignServicePackageList(Criteria criteria);

    /**
     * 保存签约日志（签约时，解约时）
     * @param sign
     * @param logType
     */
    void saveSignLog(Sign sign, String logType);

    /**
     * 解约
     * @param signId
     * @param user
     * @return
     */
    int cancelSign(Long signId, User user);

    /**
     *  查询签约日志列表
     * @param criteria
     * @return
     */
    List<SignLog> getSignLogList(Criteria criteria);

    /**
     * 读取配置信息
     * @param criteria
     * @return
     */
    SystemConfig getSystemConfig(Criteria criteria);

    /**
     * 根据身份证号码判断是否可以续约（yejianfei）
     * @param idcard
     * @param personInfo
     * @return 0:没有签约，1：可以续约，2：不能续约
     */
    int checkRenewalsFlag(String idcard, PersonInfo personInfo);
    
    int updateRefuseFlag(Long signId);
}
