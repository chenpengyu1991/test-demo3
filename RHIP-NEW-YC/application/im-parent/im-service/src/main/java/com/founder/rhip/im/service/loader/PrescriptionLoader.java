package com.founder.rhip.im.service.loader;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.common.CommonUtil;
import com.founder.rhip.im.entity.basic.RdDataCollectionLog;
import com.founder.rhip.im.entity.medical.RdPrescription;
import com.founder.rhip.im.repository.medical.IRdPrescriptionDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by yejianfei on 16-12-2.
 * 处方监控
 */
public class PrescriptionLoader extends BaseLoader<RdPrescription> implements Runnable {

    private static Logger logger = Logger.getLogger(PrescriptionLoader.class);

    private IRdPrescriptionDao rdPrescriptionDao;

    private IOrganizationApp organizationApp;

    private Organization organization;

    private BigDecimal prescriptionTotalCost;
    private Integer prescriptionCount;
    private BigDecimal prescriptionMaxCost;
    private Date businessDate;

    public PrescriptionLoader(ApplicationContext context, Date businessDate, Organization org, String logicDate, String uploadDate, Map<String, Object> prescriptionMap) {
        super();
        setContext(context);
        if (ObjectUtil.isNullOrEmpty(rdPrescriptionDao)) {
            rdPrescriptionDao = (IRdPrescriptionDao) context.getBean("rdPrescriptionDao");
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
        prescriptionTotalCost = NumberUtil.convert(prescriptionMap.get("PRESCRIPTION_TOTAL_COST").toString(),BigDecimal.class);
        prescriptionCount = NumberUtil.convert(prescriptionMap.get("PRESCRIPTION_COUNT").toString(),Integer.class);
        prescriptionMaxCost = NumberUtil.convert(prescriptionMap.get("PRESCRIPTION_MAX_COST").toString(),BigDecimal.class);
    }

    @Override
    public void run() {
        if(ObjectUtil.isNotEmpty(organization)) {
            logger.debug("[**Start**][处方监控 ReportCardLoader][机构名称：" + organization.getOrganName() + "] [机构代码:" + organization.getOrganCode() + "] " +
                    "[数据发生业务日期：" + getLogicDate() + "] [数据上传日期：" + getUploadDate() + "]");
            processLogicData(getLogicDate(), prescriptionTotalCost,prescriptionCount,prescriptionMaxCost,businessDate);
        }

        logger.debug("[**End**]");
        increment();
    }

    /**
     *
     * @param logicDate                 业务发生时间
     * @param prescriptionTotalCost     处方费用合计
     * @param prescriptionCount         处方数量
     * @param prescriptionMaxCost       最大单个处方金额
     */
    public void processLogicData(String logicDate
            , BigDecimal prescriptionTotalCost
            ,Integer prescriptionCount
            ,BigDecimal prescriptionMaxCost
            ,Date businessDate) {
        try {
            int[] yqm = CommonUtil.converToYearHalfYearQuarterMonth(logicDate);
            RdPrescription prescriptionResult = getLogicEntity(rdPrescriptionDao, organization.getOrganCode(), logicDate, new Criteria("YEAR_MONTH",businessDate));
            Timestamp createDate = new Timestamp(System.currentTimeMillis());
            String organCode = organization.getOrganCode();
            String gbCode = organization.getGbCode();
            String centerCode = (organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode();
            String genreCode = organization.getGenreCode();
            String organName = organization.getOrganName();

            /*private BigDecimal prescriptionTotalCost;
            private Integer prescriptionCount;
            private BigDecimal prescriptionMaxCost;
            private Date businessDate;*/
            RdPrescription prescription = new RdPrescription(organCode,organName, gbCode, centerCode, genreCode
                    , yqm[0], yqm[1], yqm[2], yqm[3]
                    , prescriptionTotalCost, prescriptionCount, prescriptionMaxCost,businessDate);
            //报表数据不存在，则新增
            if (ObjectUtil.isNullOrEmpty(prescriptionResult)) {
                //插入报表日志
                dataCollectionLogInsert(organCode, logicDate, logicDate, createDate, prescription);
                //插入报表数据
                logicObjectInsert(rdPrescriptionDao, prescription);
            } else {
                //报表日志已存在，需更新
                //获取报表日志
                RdDataCollectionLog logResult = getDataCollectionLogObject(organCode, logicDate, RdPrescription.class);
                BigDecimal logTotalCost = new BigDecimal(0);
                Integer logCount = 0;
                BigDecimal logMaxCost = new BigDecimal(0);
                //读取报表日志中的数据
                if (ObjectUtil.isNotEmpty(logResult)) {
                    RdPrescription logPrescription = convertToEntityObjectFromJSON(logResult.getModelOjbectData(), RdPrescription.class);
                    logTotalCost = logPrescription.getPrescriptionTotalCost();
                    logCount = logPrescription.getPrescriptionCount();
                    logMaxCost = logPrescription.getPrescriptionMaxCost();
                }
                //减去旧数据，更换新数据
                BigDecimal tmpTotalCost = prescriptionResult.getPrescriptionTotalCost().subtract(logTotalCost).add(prescriptionTotalCost);
                Integer tmpCount = prescriptionResult.getPrescriptionCount() - logCount + prescriptionCount;
                BigDecimal maxCost = prescriptionResult.getPrescriptionMaxCost().subtract(logMaxCost).add(prescriptionMaxCost);
                prescriptionResult.setPrescriptionTotalCost(tmpTotalCost);
                prescriptionResult.setPrescriptionMaxCost(maxCost);
                prescriptionResult.setPrescriptionCount(tmpCount);
                prescriptionResult.setUpdateDate(createDate);
                // 如果存在报表日志，则更新
                if (ObjectUtil.isNotEmpty(logResult)) {
                    dataCollectionLogUpdate(logResult, prescription, createDate);
                } else {
                    //插入报表日志
                    dataCollectionLogInsert(organCode, logicDate, logicDate, createDate, prescription);
                }
                //更新报表数据
                logicObjectUpdate(rdPrescriptionDao, prescriptionResult);
            }
        } catch (Exception e) {
            logger.error("[PrescriptionLoader][处理抽取的业务数据出错][orgCode: " + organization.getOrganCode() + "][logicDate:" + logicDate + "] \n" + e.getMessage(), e);
        }
    }
}
