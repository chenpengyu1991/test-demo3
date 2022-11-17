package com.founder.rhip.nc;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface INcWebService {
    /**
     * 当年及前五年内献血接口
     * @param idCard
     * @param personName
     * @param operateDateStr
     * @return
     */
    @WebMethod
    public int getBloodDonation5(
            @WebParam(name = "idCard") String idCard,
            @WebParam(name = "personName") String personName,
            @WebParam(name = "operateDateStr") String operateDateStr
    );

    /**
     * 当年及前五年内捐献血小板接口
     * @param idCard
     * @param personName
     * @param operateDateStr
     * @return
     */
    @WebMethod
    public int getPlatelets5(
            @WebParam(name = "idCard") String idCard,
            @WebParam(name = "personName") String personName,
            @WebParam(name = "operateDateStr") String operateDateStr
    );

    /**
     * 早孕是否建卡接口
     * @param idCard
     * @param personName
     * @return
     */
    @WebMethod
    public String isCarded(
            @WebParam(name = "idCard") String idCard,
            @WebParam(name = "personName") String personName
    );

    /**
     * 产前是否检查接口
     * @param idCard
     * @param personName
     * @return
     */
    @WebMethod
    public String isChecked5(
            @WebParam(name = "idCard") String idCard,
            @WebParam(name = "personName") String personName
    );

    /**
     * 儿童是否定期检查接口
     * @param idCard
     * @param personName
     * @return
     */
    @WebMethod
    public String isChildRegular(
            @WebParam(name = "idCard") String idCard,
            @WebParam(name = "personName") String personName
    );

    /**
     * 三星健康档案接口
     * @param idCard
     * @param personName
     * @return
     */
    @WebMethod
    public String isHealthRecord3Star(
            @WebParam(name = "idCard") String idCard,
            @WebParam(name = "personName") String personName
    );

    /**
     * 预防接种是否齐全接口
     * @param idCard
     * @param personName
     * @param birthdayStr
     * @param parentName
     * @return
     */
    @WebMethod
    public String isVaccinationComplete(
            @WebParam(name = "idCard") String idCard,
            @WebParam(name = "personName") String personName,
            @WebParam(name = "birthdayStr") String birthdayStr,
            @WebParam(name = "parentName") String parentName
    );

    /**
     * 是否办理从业人员健康证
     * @param idCard
     * @param personName
     * @return
     */
    @WebMethod
    public String hasHealthCertificate(
            @WebParam(name = "idCard") String idCard,
            @WebParam(name = "personName") String personName
    );

    /**
     * 行政处罚
     * @param idCard
     * @param personName
     * @param punishedDateStr
     * @return
     */
    @WebMethod
    public int getPunishedTimes(
            @WebParam(name = "idCard") String idCard,
            @WebParam(name = "personName") String personName,
            @WebParam(name = "punishedDateStr") String punishedDateStr

    );
}
