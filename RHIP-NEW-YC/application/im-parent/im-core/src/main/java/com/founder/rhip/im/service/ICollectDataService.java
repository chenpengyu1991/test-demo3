package com.founder.rhip.im.service;
/**
 * 抽取业务数据接口
 *
 * @author ye jianfei
 * @version 1.0 2016-02-29
 */
public interface ICollectDataService {
    /**
     * 根据上传日期（数据从前置机上传到数据中心的日期），从源库抽取所有机构的业务数据到业务库。
     *
     * @param uploadDate 上传日期，数据从前置机上传到数据中心的日期。格式：yyyyMMdd
     * @author ye jianfei
     */
    void startCollectLogicData(String uploadDate);
    /**
     * 根据医疗机构代码和上传日期（数据从前置机上传到数据中心的日期），从源库抽取所有机构的业务数据到业务库。
     *
     * @param orgCode 医疗机构代码
     * @param uploadDate 上传日期，数据从前置机上传到数据中心的日期。格式：yyyyMMdd
     * @author ye jianfei
     */
    void startCollectLogicData(String orgCode, String uploadDate);
    /**
     * 根据医疗机构代码和上传日期（数据从前置机上传到数据中心的日期），从源库抽取所有机构的业务数据到业务库。
     *
     * @param orgCodes 医疗机构代码数组
     * @param uploadDate 上传日期，数据从前置机上传到数据中心的日期。格式：yyyyMMdd
     * @author ye jianfei
     */
    void startCollectLogicData(String[] orgCodes, String uploadDate);
}