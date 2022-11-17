package com.founder.rhip.im.service.loader;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.common.CommonUtil;
import com.founder.rhip.im.entity.basic.RdDataCollectionLog;
import com.founder.rhip.im.entity.medical.RdExamAnalys;
import com.founder.rhip.im.entity.medical.RdRealnameClinic;
import com.founder.rhip.im.repository.medical.IRdExamAnalysDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by yejianfei on 17-03-21.
 * 检验统计
 */
public class ExamAnalysLoader extends BaseLoader<RdExamAnalys> implements Runnable {

    private static Logger logger = Logger.getLogger(ExamAnalysLoader.class);

    private IRdExamAnalysDao rdExamAnalysDao;

    private IOrganizationApp organizationApp;


    private Organization organization;

    private Integer wbcNumber = 0;//白细胞检验人次数
    private Integer wbcLowNumber = 0;//白细胞偏低人次数
    private Integer wbcHighNumber = 0;//白细胞偏高人次数
    private Integer rbcNumber = 0;//红细胞检验人次数
    private Integer rbcLowNumber = 0;//红细胞偏低人次数
    private Integer rbcHighNumber = 0;//红细胞偏高人次数
    private Integer pltNumber = 0;//血小板检验人次数
    private Integer pltLowNumber = 0;//血小板偏低人次数
    private Integer pltHighNumber = 0;//血小板偏高人次数
    private Integer aaNumber = 0;//乙型肝炎抗原检查人数
    private Integer aaPositiveNumber = 0;//乙型肝炎抗原阳性人数
    private Date businessDate;//检验日期

    public ExamAnalysLoader(ApplicationContext context, Date businessDate, Organization org, String logicDate, String uploadDate, Map<String, Object> loadMap) {
        super();
        setContext(context);
        if (ObjectUtil.isNullOrEmpty(rdExamAnalysDao)) {
            rdExamAnalysDao = (IRdExamAnalysDao) context.getBean("rdExamAnalysDao");
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
        wbcNumber = NumberUtil.convert(loadMap.get("wbcNumber").toString(),Integer.class);
        wbcLowNumber = NumberUtil.convert(loadMap.get("wbcLowNumber").toString(),Integer.class);
        wbcHighNumber = NumberUtil.convert(loadMap.get("wbcHighNumber").toString(),Integer.class);
        rbcNumber = NumberUtil.convert(loadMap.get("rbcNumber").toString(),Integer.class);
        rbcLowNumber = NumberUtil.convert(loadMap.get("rbcLowNumber").toString(),Integer.class);
        rbcHighNumber = NumberUtil.convert(loadMap.get("rbcHighNumber").toString(),Integer.class);
        pltNumber = NumberUtil.convert(loadMap.get("pltNumber").toString(),Integer.class);
        pltLowNumber = NumberUtil.convert(loadMap.get("pltLowNumber").toString(),Integer.class);
        pltHighNumber = NumberUtil.convert(loadMap.get("pltHighNumber").toString(),Integer.class);
        aaNumber = NumberUtil.convert(loadMap.get("aaNumber").toString(),Integer.class);
        aaPositiveNumber = NumberUtil.convert(loadMap.get("aaPositiveNumber").toString(),Integer.class);
      }

    @Override
    public void run() {
        if(ObjectUtil.isNotEmpty(organization)) {
            logger.debug("[**Start**][检验统计 ExamAnalysLoader][机构名称：" + organization.getOrganName() + "] [机构代码:" + organization.getOrganCode() + "] " +
                    "[数据发生业务日期：" + getLogicDate() + "] [数据上传日期：" + getUploadDate() + "]");
            processLogicData(getLogicDate()
                    , wbcNumber,wbcLowNumber,wbcHighNumber
                    ,rbcNumber,rbcLowNumber,rbcHighNumber
                    ,pltNumber,pltLowNumber,pltHighNumber
                    ,aaNumber,aaPositiveNumber
                    ,businessDate);
        }

        logger.debug("[**End**]");
        increment();
    }

    /**
     *
     * @param logicDate     业务发生时间
     * @param businessDate  检验日期
     */
    public void processLogicData(String logicDate
            , Integer wbcNumber, Integer wbcLowNumber, Integer wbcHighNumber
            , Integer rbcNumber, Integer rbcLowNumber, Integer rbcHighNumber
            , Integer pltNumber, Integer pltLowNumber, Integer pltHighNumber
            , Integer aaNumber, Integer aaPositiveNumber
            ,Date businessDate) {
        try {
            int[] yqm = CommonUtil.converToYearHalfYearQuarterMonth(logicDate);
            RdExamAnalys examAnalysResult = getLogicEntity(rdExamAnalysDao, organization.getOrganCode(), logicDate, new Criteria("YEAR_MONTH",businessDate));
            Timestamp createDate = new Timestamp(System.currentTimeMillis());
            String organCode = organization.getOrganCode();
            String gbCode = organization.getGbCode();
            String centerCode = (organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode();
            String genreCode = organization.getGenreCode();
            String organName = organization.getOrganName();

            RdExamAnalys examAnalys = new RdExamAnalys(organCode,organName, gbCode, centerCode, genreCode
                    , yqm[0], yqm[1], yqm[2], yqm[3]
                    ,wbcNumber,wbcLowNumber,wbcHighNumber
                    ,rbcNumber,rbcLowNumber,rbcHighNumber
                    ,pltNumber,pltLowNumber,pltHighNumber
                    ,aaNumber,aaPositiveNumber
                    ,businessDate);
            //报表数据不存在，则新增
            if (ObjectUtil.isNullOrEmpty(examAnalysResult)) {
                //插入报表日志
                dataCollectionLogInsert(organCode, logicDate, logicDate, createDate, examAnalys);
                //插入报表数据
                logicObjectInsert(rdExamAnalysDao, examAnalys);
            } else {
                //报表日志已存在，需更新
                //获取报表日志
                RdDataCollectionLog logResult = getDataCollectionLogObject(organCode, logicDate, RdExamAnalys.class);
                Integer logWbcNumber = 0;//白细胞检验人次数
                Integer logWbcLowNumber = 0;//白细胞偏低人次数
                Integer logWbcHighNumber = 0;//白细胞偏高人次数
                Integer logRbcNumber = 0;//红细胞检验人次数
                Integer logRbcLowNumber = 0;//红细胞偏低人次数
                Integer logRbcHighNumber = 0;//红细胞偏高人次数
                Integer logPltNumber = 0;//血小板检验人次数
                Integer logPltLowNumber = 0;//血小板偏低人次数
                Integer logPltHighNumber = 0;//血小板偏高人次数
                Integer logAaNumber = 0;//乙型肝炎抗原检查人数
                Integer logAaPositiveNumber = 0;//乙型肝炎抗原阳性人数
                //读取报表日志中的数据
                if (ObjectUtil.isNotEmpty(logResult)) {
                    RdExamAnalys logExamAnalys = convertToEntityObjectFromJSON(logResult.getModelOjbectData(), RdExamAnalys.class);
                    logWbcNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getWbcNumber())?0:logExamAnalys.getWbcNumber();
                    logWbcLowNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getWbcLowNumber())?0:logExamAnalys.getWbcLowNumber();
                    logWbcHighNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getWbcHighNumber())?0:logExamAnalys.getWbcHighNumber();
                    logRbcNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getRbcNumber())?0:logExamAnalys.getRbcNumber();
                    logRbcLowNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getRbcLowNumber())?0:logExamAnalys.getRbcLowNumber();
                    logRbcHighNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getRbcHighNumber())?0:logExamAnalys.getRbcHighNumber();
                    logPltNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getPltNumber())?0:logExamAnalys.getPltNumber();
                    logPltLowNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getPltLowNumber())?0:logExamAnalys.getPltLowNumber();
                    logPltHighNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getPltHighNumber())?0:logExamAnalys.getPltHighNumber();
                    logAaNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getAaNumber())?0:logExamAnalys.getAaNumber();
                    logAaPositiveNumber = ObjectUtil.isNullOrEmpty(logExamAnalys.getAaPositiveNumber())?0:logExamAnalys.getAaPositiveNumber();
                }
                //减去旧数据，更换新数据
                Integer tmpWbcNumber = examAnalysResult.getWbcNumber()-logWbcNumber+wbcNumber;
                Integer tmpWbcLowNumber = examAnalysResult.getWbcLowNumber()-logWbcLowNumber+wbcLowNumber;
                Integer tmpWbcHighNumber = examAnalysResult.getWbcHighNumber()-logWbcHighNumber+wbcHighNumber;
                Integer tmpRbcNumber = examAnalysResult.getRbcNumber()-logRbcNumber+rbcNumber;
                Integer tmpRbcLowNumber = examAnalysResult.getRbcLowNumber()-logRbcLowNumber+rbcLowNumber;
                Integer tmpRbcHighNumber = examAnalysResult.getRbcHighNumber()-logRbcHighNumber+rbcHighNumber;
                Integer tmpPltNumber = examAnalysResult.getPltNumber()-logPltNumber+pltNumber;
                Integer tmpPltLowNumber = examAnalysResult.getPltLowNumber()-logPltLowNumber+pltLowNumber;
                Integer tmpPltHighNumber = examAnalysResult.getPltHighNumber()-logPltHighNumber+pltHighNumber;
                Integer tmpAaNumber = examAnalysResult.getAaNumber()-logAaNumber+aaNumber;
                Integer tmpAaPositiveNumber = examAnalysResult.getAaPositiveNumber()-logAaPositiveNumber+aaPositiveNumber;

                examAnalysResult.setWbcNumber(tmpWbcNumber);
                examAnalysResult.setWbcLowNumber(tmpWbcLowNumber);
                examAnalysResult.setWbcHighNumber(tmpWbcHighNumber);
                examAnalysResult.setRbcNumber(tmpRbcNumber);
                examAnalysResult.setRbcLowNumber(tmpRbcLowNumber);
                examAnalysResult.setRbcHighNumber(tmpRbcHighNumber);
                examAnalysResult.setPltNumber(tmpPltNumber);
                examAnalysResult.setPltLowNumber(tmpPltLowNumber);
                examAnalysResult.setPltHighNumber(tmpPltHighNumber);
                examAnalysResult.setAaNumber(tmpAaNumber);
                examAnalysResult.setAaPositiveNumber(tmpAaPositiveNumber);

                examAnalysResult.setUpdateDate(createDate);
                // 如果存在报表日志，则更新
                if (ObjectUtil.isNotEmpty(logResult)) {
                    dataCollectionLogUpdate(logResult, examAnalys, createDate);
                } else {
                    //插入报表日志
                    dataCollectionLogInsert(organCode, logicDate, logicDate, createDate, examAnalys);
                }
                //更新报表数据
                logicObjectUpdate(rdExamAnalysDao, examAnalysResult);
            }
        } catch (Exception e) {
            logger.error("[RealnameClinicLoader][处理抽取的业务数据出错][orgCode: " + organization.getOrganCode() + "][logicDate:" + logicDate + "] \n" + e.getMessage(), e);
        }
    }
}
