package com.founder.rhip.im.service.task;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.clinic.IDiseaseDiagnosisInfoDao;
import com.founder.rhip.im.service.loader.DiagnosisLoader;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 处方监控任务调度，应用菜单：疾病排名
 * Created by yejianfei on 16-12-2.
 */
@Service("diagnosisTaskService")
@TaskBean(description = "疾病排名数据抽取(参数格式yyyyMMdd)")
public class DiagnosisTaskService extends BasicTaskService {

    @Resource(name = "diseaseDiagnosisInfoDao")
    private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;

    @Override
    public void startCollectLogicData(String uploadDate) {
        if (ObjectUtil.isNullOrEmpty(logger)) logger = Logger.getLogger(DiagnosisTaskService.class);
        try {
            //因为没有数据采集时间，故这里的上传日期实际就是业务发生时间
            Date businessLastDate = DateUtil.lastTimeOfDay(DateUtil.convert("yyyyMMdd",uploadDate));
            Date businessFirstDate = DateUtil.firstTimeOfDay(DateUtil.convert("yyyyMMdd",uploadDate));
            Criteria ca = new Criteria();
            DateUtil.getCriteriaByDateRange(ca, "DIAGNOSE_DATE",businessFirstDate,businessLastDate);
            List<Map<String,Object>> prescriptionMap = diseaseDiagnosisInfoDao.getDiseaseMapList(ca);
            if (ObjectUtil.isNotEmpty(prescriptionMap)) {
                for(Map<String,Object> map:prescriptionMap){
                    String organCode = map.get("HOSPITAL_CODE").toString();
                    Organization org = organizationApp.queryOrgan(organCode);
                    String logicDate = DateUtil.getDateTime("yyyyMMdd",businessFirstDate);
                    new DiagnosisLoader(context,businessFirstDate, org, logicDate, uploadDate, map).run();
                }
            } else {
                logger.debug("[疾病排名]表中没有[uploadDate: " + uploadDate + "]的数据。");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    protected void initTask() {
        logger = Logger.getLogger(DiagnosisTaskService.class);
        super.initTask();
    }
}
