package com.founder.rhip.ehr.service.ihm;

import java.util.Date;
import java.util.List;

public interface IPublicHealthTarget {

    /**
     * 获取健康档案统计指标
     * @param orgCode
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     */
    Float getEHRTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode);

    /**
     * 获取健康教育统计指标
     * @param orgCode
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     */
    Float getHETarget(List<String> orgCode, Date startDate, Date endDate, String targetCode);

    /**
     * 获取预防接种统计指标
     * @param orgCode
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     */
    Float getVaccinateTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode);

    /**
     * 获取妇幼接种统计指标
     * @param orgCode
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     */
    Float getWomenChildrenTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode);

    /**
     * 获取老人年健康管理及学生体检指标
     * @param orgCode
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     */
    Float getHmTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode);

    /**
     * 获取慢病统计指标（高血压、糖尿病）
     * @param orgCode
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     */
    Float getCDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode);

    /**
     *获取传染病统计指标
     * @param orgCode
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     */
    Float getIDMTarget(List<String> orgCode, Date startDate, Date endDate, String targetCode);

    /**
     * 获取卫生监督协管统计指标
     * @param orgCode
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     */
    Float getHSATarget(List<String> orgCode, Date startDate, Date endDate, String targetCode);
    
    /**
     * 获取精神卫生管理统计指标
     * @param orgCode
     * @param startDate
     * @param endDate
     * @param targetCode
     * @return
     */
    Float getMhmTarget(String orgCode,String orgType, Date startDate, Date endDate, String targetCode);    
}
