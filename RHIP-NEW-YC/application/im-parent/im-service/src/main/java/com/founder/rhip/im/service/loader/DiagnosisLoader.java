package com.founder.rhip.im.service.loader;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.service.IDiseaseDiagnosisInfoService;
import com.founder.rhip.im.common.CommonUtil;
import com.founder.rhip.im.entity.basic.RdDataCollectionLog;
import com.founder.rhip.im.entity.medical.RdDiagnosis;
import com.founder.rhip.im.entity.medical.RdPrescription;
import com.founder.rhip.im.repository.medical.IRdDiagnosisDao;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by yejianfei on 16-12-8.
 * 疾病排名
 */
public class DiagnosisLoader extends BaseLoader<RdDiagnosis> implements Runnable {

    private static Logger logger = Logger.getLogger(DiagnosisLoader.class);

    private IRdDiagnosisDao rdDiagnosisDao;

    private IOrganizationApp organizationApp;

    private IDiseaseApp diseaseApp;

    private IDiseaseDiagnosisInfoService diseaseDiagnosisInfoService;

    private Organization organization;

    private String diagnosisCode;//诊断代码
    private String diagnosisName = "";//诊断名称
    private Integer diagnosisCount;//诊断数量
    private Date businessDate;//诊断日期

    public DiagnosisLoader(ApplicationContext context, Date businessDate, Organization org, String logicDate, String uploadDate, Map<String, Object> diagnosisMap) {
        super();
        setContext(context);
        if (ObjectUtil.isNullOrEmpty(rdDiagnosisDao)) {
            rdDiagnosisDao = (IRdDiagnosisDao) context.getBean("rdDiagnosisDao");
        }
        if (ObjectUtil.isNullOrEmpty(organizationApp)) {
            organizationApp = (IOrganizationApp) context.getBean("organizationApp");
        }
        if (ObjectUtil.isNullOrEmpty(diseaseApp)) {
            diseaseApp = (IDiseaseApp) context.getBean("diseaseApp");
        }
        if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfoService)) {
            diseaseDiagnosisInfoService = (IDiseaseDiagnosisInfoService) context.getBean("diseaseDiagnosisInfoService");
        }
        this.businessDate = businessDate;
        this.organization = org;
        if(ObjectUtil.isNullOrEmpty(org)){
            return;
        }
        setLogicDate(logicDate);
        setOrgCode(org.getOrganCode());
        setUploadDate(uploadDate);
        diagnosisCode = diagnosisMap.get("DIAGNOSIS_CODE").toString();
        diagnosisCount = NumberUtil.convert(diagnosisMap.get("DIAGNOSE_COUNT").toString(),Integer.class);
        //diagnosisName = getDiagnosisName(diagnosisCode);
      }

    @Override
    public void run() {
        if(ObjectUtil.isNotEmpty(organization)) {
            logger.debug("[**Start**][疾病排名 DiagnosisLoader][机构名称：" + organization.getOrganName() + "] [机构代码:" + organization.getOrganCode() + "] " +
                    "[数据发生业务日期：" + getLogicDate() + "] [数据上传日期：" + getUploadDate() + "]");
            processLogicData(getLogicDate(), diagnosisCode,diagnosisName,diagnosisCount,businessDate);
        }

        logger.debug("[**End**]");
        increment();
    }

    /**
     *
     * @param logicDate                 业务发生时间
     * @param diagnosisCode     诊断代码
     * @param diagnosisCount    诊断数量
     * @param businessDate      诊断日期
     */
    public void processLogicData(String logicDate
            , String diagnosisCode
            ,String diagnosisName
            ,Integer diagnosisCount
            ,Date businessDate) {
        try {
            int[] yqm = CommonUtil.converToYearHalfYearQuarterMonth(logicDate);
            RdDiagnosis diagnosisResult = getLogicEntity(rdDiagnosisDao, organization.getOrganCode(), logicDate, new Criteria("YEAR_MONTH",businessDate).add("DIAGNOSIS_CODE",diagnosisCode));
            Timestamp createDate = new Timestamp(System.currentTimeMillis());
            String organCode = organization.getOrganCode();
            String gbCode = organization.getGbCode();
            String centerCode = (organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode();
            String genreCode = organization.getGenreCode();
            String organName = organization.getOrganName();

            RdDiagnosis diagnosis = new RdDiagnosis(organCode,organName, gbCode, centerCode, genreCode
                    , yqm[0], yqm[1], yqm[2], yqm[3]
                    , diagnosisCode,diagnosisName,diagnosisCount,businessDate);
            //报表数据不存在，则新增
            if (ObjectUtil.isNullOrEmpty(diagnosisResult)) {
                //插入报表日志
                dataCollectionLogInsert(organCode, logicDate, logicDate, createDate, diagnosis);
                //插入报表数据
                logicObjectInsert(rdDiagnosisDao, diagnosis);
            } else {
                //报表日志已存在，需更新
                //获取报表日志
                RdDataCollectionLog logResult = getDataCollectionLogObject(organCode, logicDate, RdPrescription.class);
                String logDagnosisCode;//诊断代码
                Integer logDiagnosisCount = 0;//诊断数量
                //读取报表日志中的数据
                if (ObjectUtil.isNotEmpty(logResult)) {
                    RdDiagnosis logDiagnosis = convertToEntityObjectFromJSON(logResult.getModelOjbectData(), RdDiagnosis.class);
                    logDagnosisCode = logDiagnosis.getDiagnosisCode();
                    logDiagnosisCount = logDiagnosis.getDiagnosisCount();
                }
                //减去旧数据，更换新数据
                Integer tmpCount = diagnosisResult.getDiagnosisCount() - logDiagnosisCount + diagnosisCount;
                diagnosisResult.setDiagnosisCount(tmpCount);
                diagnosisResult.setUpdateDate(createDate);
                // 如果存在报表日志，则更新
                if (ObjectUtil.isNotEmpty(logResult)) {
                    dataCollectionLogUpdate(logResult, diagnosis, createDate);
                } else {
                    //插入报表日志
                    dataCollectionLogInsert(organCode, logicDate, logicDate, createDate, diagnosis);
                }
                //更新报表数据
                logicObjectUpdate(rdDiagnosisDao, diagnosisResult);
            }
        } catch (Exception e) {
            logger.error("[DiagnosisLoader][处理抽取的业务数据出错][orgCode: " + organization.getOrganCode() + "][logicDate:" + logicDate + "] \n" + e.getMessage(), e);
        }
    }

    private String getDiagnosisName(String diagnosisCode){
        String result = "";
        Disease disease = diseaseApp.getDisease(diagnosisCode);
        //如果疾病表disease中疾病名称为空，则从诊断表中获取
        if(ObjectUtil.isNotEmpty(disease)){
            result = disease.getDiseaseName();
        }else{
            result = diseaseDiagnosisInfoService.getDiseaseName(new Criteria("DIAGNOSIS_CODE",diagnosisCode));
        }
        return result;
    }
}
