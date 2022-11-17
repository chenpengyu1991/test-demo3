package com.founder.rhip.im.service.task;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.repository.medical.IRdRealnameClinicDao;
import com.founder.rhip.im.service.loader.RealnameClinicLoader;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 处方监控任务调度，应用菜单：大数据分析-实名就诊分析
 * Created by yejianfei on 16-12-2.
 */
@Service("realnameClinicTaskService")
@TaskBean(description = "实名就诊数据抽取")
public class RealnameClinicTaskService extends BasicTaskService {

    @Resource(name = "rdRealnameClinicDao")
    private IRdRealnameClinicDao rdRealnameClinicDao;

    @Override
    public void startCollectLogicData(String uploadDate) {
        if (ObjectUtil.isNullOrEmpty(logger)) logger = Logger.getLogger(RealnameClinicTaskService.class);
        logger.info("实名就诊数据任务开始：" + uploadDate);
        try {
            //因为没有数据采集时间，故这里的上传日期实际就是业务发生时间
            Date businessLastDate = DateUtil.lastTimeOfDay(DateUtil.convert("yyyyMMdd",uploadDate));
            Date businessFirstDate = DateUtil.firstTimeOfDay(DateUtil.convert("yyyyMMdd",uploadDate));
            Criteria ca = new Criteria();
            DateUtil.getCriteriaByDateRange(ca, "CLINIC_DATE",businessFirstDate,businessLastDate);
            List<Map<String,Object>> loadMapList = rdRealnameClinicDao.getOrganSummary(ca);
            if (ObjectUtil.isNotEmpty(loadMapList)) {
                for(Map<String,Object> map:loadMapList){
                    String organCode = map.get("CLINIC_ORGAN_CODE").toString();
                    Organization org = organizationApp.queryOrgan(organCode);
                    String logicDate = DateUtil.getDateTime("yyyyMMdd",businessFirstDate);
                    logger.info("实名就诊数据任务，数据处理：" +(ObjectUtil.isNotEmpty(org)?org.getOrganName():"") );
                    new RealnameClinicLoader(context,businessFirstDate, org, logicDate, uploadDate, map).run();
                }
            } else {
                logger.debug("[实名就诊]表中没有[uploadDate: " + uploadDate + "]的数据。");
                logger.info("[实名就诊]表中没有[uploadDate: " + uploadDate + "]的数据。");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    protected void initTask() {
        logger = Logger.getLogger(RealnameClinicTaskService.class);
        super.initTask();
    }
}
