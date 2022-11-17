package com.founder.rhip.im.service.task;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.clinic.IOutpatientPrescriptionDao;
import com.founder.rhip.im.service.loader.PrescriptionLoader;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 处方监控任务调度，应用菜单：综合管理-处方监控-处方费用
 * Created by yejianfei on 16-12-2.
 */
@Service("prescriptionTaskService")
@TaskBean(description = "处方监控数据抽取")
public class PrescriptionTaskService extends BasicTaskService {

    @Resource(name = "outpatientPrescriptionDao")
    private IOutpatientPrescriptionDao outpatientPrescriptionDao;

    @Override
    public void startCollectLogicData(String uploadDate) {
        if (ObjectUtil.isNullOrEmpty(logger)) logger = Logger.getLogger(PrescriptionTaskService.class);
        try {
            //因为没有数据采集时间，故这里的上传日期实际就是业务发生时间
            Date businessLastDate = DateUtil.lastTimeOfDay(DateUtil.convert("yyyyMMdd",uploadDate));
            Date businessFirstDate = DateUtil.firstTimeOfDay(DateUtil.convert("yyyyMMdd",uploadDate));
            Criteria ca = new Criteria();
            DateUtil.getCriteriaByDateRange(ca, "PRESCRIBE_DATE",businessFirstDate,businessLastDate);
            List<Map<String,Object>> prescriptionMap = outpatientPrescriptionDao.getPrescriptionSummary(ca);
            if (ObjectUtil.isNotEmpty(prescriptionMap)) {
                for(Map<String,Object> map:prescriptionMap){
                    String organCode = map.get("HOSPITAL_CODE").toString();
                    Organization org = organizationApp.queryOrgan(organCode);
                    String logicDate = DateUtil.getDateTime("yyyyMMdd",businessFirstDate);
                    new PrescriptionLoader(context,businessFirstDate, org, logicDate, uploadDate, map).run();
                }
            } else {
                logger.debug("[处方监控]表中没有[uploadDate: " + uploadDate + "]的数据。");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    protected void initTask() {
        logger = Logger.getLogger(PrescriptionTaskService.class);
        super.initTask();
    }
}
