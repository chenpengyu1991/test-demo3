package com.founder.rhip.im.service.loader;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.common.CommonUtil;
import com.founder.rhip.im.entity.basic.RdDataCollectionLog;
import com.founder.rhip.im.entity.medical.RdRealnameClinic;
import com.founder.rhip.im.repository.medical.IRdRealnameClinicDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by yejianfei on 16-12-22.
 * 实名就诊
 */
public class RealnameClinicLoader extends BaseLoader<RdRealnameClinic> implements Runnable {

    private static Logger logger = Logger.getLogger(RealnameClinicLoader.class);

    private IRdRealnameClinicDao rdRealnameClinicDao;

    private IOrganizationApp organizationApp;


    private Organization organization;

    private Integer clinicNum = 0;//就诊人次
    private Integer realnameNum = 0;//实名就诊人次
    private Date businessDate;//就诊日期

    public RealnameClinicLoader(ApplicationContext context, Date businessDate, Organization org, String logicDate, String uploadDate, Map<String, Object> loadMap) {
        super();
        setContext(context);
        if (ObjectUtil.isNullOrEmpty(rdRealnameClinicDao)) {
            rdRealnameClinicDao = (IRdRealnameClinicDao) context.getBean("rdRealnameClinicDao");
        }
        if (ObjectUtil.isNullOrEmpty(organizationApp)) {
            organizationApp = (IOrganizationApp) context.getBean("organizationApp");
        }
        this.businessDate = businessDate;
        this.organization = org;
        if(ObjectUtil.isNullOrEmpty(org)){
            return;
        }
        setLogicDate(logicDate);
        setOrgCode(org.getOrganCode());
        setUploadDate(uploadDate);
        clinicNum = NumberUtil.convert(loadMap.get("CLINIC_NUM").toString(),Integer.class);
        realnameNum = NumberUtil.convert(loadMap.get("REALNAME_NUM").toString(),Integer.class);
      }

    @Override
    public void run() {
        if(ObjectUtil.isNotEmpty(organization)) {
            logger.debug("[**Start**][实名就诊 DiagnosisLoader][机构名称：" + organization.getOrganName() + "] [机构代码:" + organization.getOrganCode() + "] " +
                    "[数据发生业务日期：" + getLogicDate() + "] [数据上传日期：" + getUploadDate() + "]");
            processLogicData(getLogicDate(), clinicNum,realnameNum,businessDate);
        }

        logger.debug("[**End**]");
        increment();
    }

    /**
     *
     * @param logicDate     业务发生时间
     * @param clinicNum     就诊人数
     * @param realnameNum   实名就诊人数
     * @param businessDate  就诊日期
     */
    public void processLogicData(String logicDate
            , Integer clinicNum
            ,Integer realnameNum
            ,Date businessDate) {
        try {
            int[] yqm = CommonUtil.converToYearHalfYearQuarterMonth(logicDate);
            RdRealnameClinic realnameClinicResult = getLogicEntity(rdRealnameClinicDao, organization.getOrganCode(), logicDate, new Criteria("YEAR_MONTH",businessDate));
            Timestamp createDate = new Timestamp(System.currentTimeMillis());
            String organCode = organization.getOrganCode();
            String gbCode = organization.getGbCode();
            String centerCode = (organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode();
            String genreCode = organization.getGenreCode();
            String organName = organization.getOrganName();

            RdRealnameClinic realnameClinic = new RdRealnameClinic(organCode,organName, gbCode, centerCode, genreCode
                    , yqm[0], yqm[1], yqm[2], yqm[3]
                    , clinicNum,realnameNum,businessDate);
            //报表数据不存在，则新增
            if (ObjectUtil.isNullOrEmpty(realnameClinicResult)) {
                //插入报表日志
                //dataCollectionLogInsert(organCode, logicDate, logicDate, createDate, realnameClinic);
                //插入报表数据
                logicObjectInsert(rdRealnameClinicDao, realnameClinic);
            } else {
                //报表日志已存在，需更新
                realnameClinicResult.setGbCode(gbCode);//GBCODE可能会在页面更新因此要同步BUG0181365
                //获取报表日志
                RdDataCollectionLog logResult = getDataCollectionLogObject(organCode, logicDate, RdRealnameClinic.class);
                Integer logClinicNum = 0;//就诊人数
                Integer logRealnameNum = 0;//实名就诊人数
                //读取报表日志中的数据
                if (ObjectUtil.isNotEmpty(logResult)) {
                    RdRealnameClinic logRealnameClinic = convertToEntityObjectFromJSON(logResult.getModelOjbectData(), RdRealnameClinic.class);
                    logClinicNum = logRealnameClinic.getClinicNum();
                    logRealnameNum = logRealnameClinic.getRealnameNum();
                }
                //减去旧数据，更换新数据
                Integer tmpClinicNum = realnameClinicResult.getClinicNum() - logClinicNum + clinicNum;
                Integer tmpRealnameNum = realnameClinicResult.getRealnameNum() - logRealnameNum + realnameNum;
                realnameClinicResult.setClinicNum(tmpClinicNum);
                realnameClinicResult.setRealnameNum(tmpRealnameNum);
                realnameClinicResult.setUpdateDate(createDate);
                // 如果存在报表日志，则更新
                if (ObjectUtil.isNotEmpty(logResult)) {
                    dataCollectionLogUpdate(logResult, realnameClinic, createDate);
                } else {
                    //插入报表日志
                    //dataCollectionLogInsert(organCode, logicDate, logicDate, createDate, realnameClinic);
                }
                //更新报表数据
                logicObjectUpdate(rdRealnameClinicDao, realnameClinicResult);
            }
        } catch (Exception e) {
            logger.error("[RealnameClinicLoader][处理抽取的业务数据出错][orgCode: " + organization.getOrganCode() + "][logicDate:" + logicDate + "] \n" + e.getMessage(), e);
        }
    }
}
