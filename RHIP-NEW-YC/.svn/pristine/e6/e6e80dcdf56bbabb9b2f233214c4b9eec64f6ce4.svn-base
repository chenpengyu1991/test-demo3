/**
 * copyright    
 * @date 2012-11-29
 * @author ding_donghong
 * @version V1.0
 * @describe 健康档案编号生成
 */

package com.founder.rhip.ehr.service.basic;

public interface IEHRNumberService {
    /**
     * 根据个人行政区划编号获取健康档案编号（此函数已经废弃，不建议使用（并发会引起档案号重复））
     *
     * @param villageCode
     * @return
     */
    public String getHealthFileNo(String villageCode);

    /**
     * 获得居民个人健康档案编号/体检编号
     * @param villageCode
     * @param numberType 体检编号类型：EXBH 档案编号类型：GRBH
     * @return
     */
    public String getSerialNum(String villageCode,String numberType);
}