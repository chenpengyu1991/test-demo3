package com.founder.rhip.im.service.loader;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.common.CommonUtil;
import com.founder.rhip.im.common.ImConstants;
import com.founder.rhip.im.entity.basic.RdDataCollectionLog;
import com.founder.rhip.im.entity.publicHealth.RdReportCard;
import com.founder.rhip.im.repository.publicHealth.IRdReportCardDao;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by jingqiu on 16-8-2.
 * 报卡监控
 */
public class ReportCardLoader extends BaseLoader<RdReportCard> implements Runnable {

    private static Logger logger = Logger.getLogger(ReportCardLoader.class);

    private IRdReportCardDao rdReportCardDao;

    private Organization organization;

    private int cdmNumber = 0;
    private int idmFirstNumber = 0;
    private int idmReissueNumber = 0;
    private int foodDisNumber = 0;

    public ReportCardLoader(ApplicationContext context, Organization org, String logicDate, String uploadDate, List<Map<String, Object>> reportCards) {
        super();
        setContext(context);
        if (ObjectUtil.isNullOrEmpty(rdReportCardDao)) {
            rdReportCardDao = (IRdReportCardDao) context.getBean("rdReportCardDao");
        }
        this.organization = org;
        setLogicDate(logicDate);
        setOrgCode(org.getOrganCode());
        setUploadDate(uploadDate);

        for (Map<String, Object> recordCard : reportCards) {
            Integer type = Integer.valueOf(recordCard.get("TYPE").toString());
            Integer status = Integer.valueOf(recordCard.get("STATUS").toString());
            Integer value = Integer.valueOf(recordCard.get("NUM").toString());
            if (type == 1 && status == 2) { //慢病
                cdmNumber = value;
            } else if (type == 2 && status == 2) { //传染病初诊
                idmFirstNumber = value;
            } else if (type == 2 && status == 5) { //传染病补卡
                idmReissueNumber = value;
            } else if (type == 3 && status == 2) {
                foodDisNumber = value;
            }
        }
    }

    @Override
    public void run() {
        logger.debug("[**Start**][报卡监控 ReportCardLoader][机构名称：" + organization.getOrganName() + "] [机构代码:" + organization.getOrganCode() + "] " +
                "[数据发生业务日期：" + getLogicDate() + "] [数据上传日期：" + getUploadDate() + "]");
        if (cdmNumber != 0) {
            logger.debug("[慢病报卡数量：" + cdmNumber + "]");
            processLogicData(getLogicDate(), getUploadDate(), ImConstants.REPORT_CARD_CDM, cdmNumber);
        }
        if (idmFirstNumber != 0) {
            logger.debug("[传染病初诊报卡数量：" + idmFirstNumber + "]");
            processLogicData(getLogicDate(), getUploadDate(), ImConstants.REPORT_CARD_IDM, idmFirstNumber);
        }
        if (idmReissueNumber != 0) {
            logger.debug("[传染病补卡报卡数量：" + idmReissueNumber + "]");
            processLogicData(getLogicDate(), getUploadDate(), ImConstants.REPORT_CARD_IDM_REISSUE, idmReissueNumber);
        }
        if (foodDisNumber != 0) {
            logger.debug("[食源性疾病报卡数量：" + foodDisNumber + "]");
            processLogicData(getLogicDate(), getUploadDate(), ImConstants.REPORT_CARD_FOOD_DIS, foodDisNumber);
        }
        logger.debug("[**End**]");
        increment();
    }

    /**
     *
     * @param logicDate         业务发生时间
     * @param uploadDate        数据上传日期，从前置机上传到数据中心的日期
     * @param businessType      报卡类型
     * @param recordNumber      报卡数量
     */
    public void processLogicData(String logicDate, String uploadDate, String businessType, Integer recordNumber) {
        try {
            int[] yqm = CommonUtil.converToYearHalfYearQuarterMonth(logicDate);
            RdReportCard cardResult = getLogicEntity(rdReportCardDao, organization.getOrganCode(), logicDate, new Criteria("businessType", businessType));
            Timestamp createDate = new Timestamp(System.currentTimeMillis());
            String organCode = organization.getOrganCode();
            String gbCode = organization.getGbCode();
            String centerCode = (organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode();
            String genreCode = organization.getGenreCode();
            String organName = organization.getOrganName();
            RdReportCard card = new RdReportCard(organCode,organName, gbCode, centerCode, genreCode, yqm[0], yqm[1], yqm[2], yqm[3], businessType, recordNumber, createDate);
            //报表数据不存在，则新增
            if (cardResult == null) {
                //插入报表日志
                dataCollectionLogInsert(organCode, logicDate, uploadDate, createDate, card, businessType);
                //插入报表数据
                logicObjectInsert(rdReportCardDao, card);
            } else {
                //报表日志已存在，需更新
                //获取报表日志
                RdDataCollectionLog logResult = getDataCollectionLogObject(organCode, logicDate, RdReportCard.class, businessType);
                int logCardNum = 0;
                //读取报表日志中的数据
                if (ObjectUtil.isNotEmpty(logResult)) {
                    RdReportCard logCard = convertToEntityObjectFromJSON(logResult.getModelOjbectData(), RdReportCard.class);
                    logCardNum = logCard.getRecordNumber();
                }
                //减去旧数据，更换新数据
                int tmpCardNum = cardResult.getRecordNumber() - logCardNum + recordNumber;
                cardResult.setRecordNumber(tmpCardNum);
                cardResult.setUpdateDate(createDate);
                // 如果存在报表日志，则更新
                if (ObjectUtil.isNotEmpty(logResult)) {
                    dataCollectionLogUpdate(logResult, card, createDate);
                } else {
                    //插入报表日志
                    dataCollectionLogInsert(organCode, logicDate, uploadDate, createDate, card, businessType);
                }
                //更新报表数据
                logicObjectUpdate(rdReportCardDao, cardResult);
            }
        } catch (Exception e) {
            logger.error("[ReportCardLoader][处理抽取的业务数据出错][orgCode: " + organization.getOrganCode() + "][logicDate:" + logicDate + "] \n" + e.getMessage(), e);
        }
    }
}
