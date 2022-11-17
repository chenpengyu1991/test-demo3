package com.founder.rhip.ehr.service;

import com.founder.rhip.ehr.entity.nc.NcLog;

public interface INcService {
    /**
     * 当年及前五年内献血接口
     *
     * @param idCard
     * @param personName
     * @param operateDateStr
     * @return
     */
    public int getBloodDonation5(String idCard, String personName, String operateDateStr);

    /**
     * 当年及前五年内捐献血小板接口
     *
     * @param idCard
     * @param personName
     * @param operateDateStr
     * @return
     */
    public int getPlatelets5(String idCard, String personName, String operateDateStr);

    /**
     * 早孕是否建卡接口
     *
     * @param idCard
     * @param personName
     * @return
     */
    public String isCarded(String idCard, String personName);

    /**
     * 产前是否检查接口
     *
     * @param idCard
     * @param personName
     * @return
     */
    public String isChecked5(String idCard, String personName);

    /**
     * 儿童是否定期检查接口
     *
     * @param idCard
     * @param personName
     * @return
     */
    public String isChildRegular(String idCard, String personName);

    /**
     * 三星健康档案接口
     *
     * @param idCard
     * @param personName
     * @return
     */
    public String isHealthRecord3Star(String idCard, String personName);

    /**
     * 预防接种是否齐全接口
     *
     * @param idCard
     * @param personName
     * @param birthdayStr
     * @param parentName
     * @return
     */
    public String isVaccinationComplete(String idCard, String personName, String birthdayStr, String parentName);

    /**
     * 是否办理从业人员健康证
     *
     * @param idCard
     * @param personName
     * @return
     */
    public String hasHealthCertificate(String idCard, String personName);

    /**
     * 行政处罚
     *
     * @param idCard
     * @param personName
     * @param punishedDateStr
     * @return
     */
    public int getPunishedTimes(String idCard, String personName, String punishedDateStr);
    
    
    public int insertNcLog(NcLog ncLog);
}
