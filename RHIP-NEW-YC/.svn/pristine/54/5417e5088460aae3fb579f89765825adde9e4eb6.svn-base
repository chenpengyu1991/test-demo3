package com.founder.rhip.im.service.task;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.repository.medical.IRdExamAnalysDao;
import com.founder.rhip.im.service.loader.ExamAnalysLoader;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 应用菜单：综合管理-医疗服务-检验结果统计
 * Created by yejianfei on 17-03-21.
 */
@Service("examAnalysTaskService")
@TaskBean(description = "检验结果数据抽取")
public class ExamAnalysTaskService extends BasicTaskService {

    @Resource(name = "rdExamAnalysDao")
    private IRdExamAnalysDao rdExamAnalysDao;

    @Override
    public void startCollectLogicData(String uploadDate) {
        if (ObjectUtil.isNullOrEmpty(logger)) logger = Logger.getLogger(ExamAnalysTaskService.class);
        try {
            //因为没有数据采集时间，故这里的上传日期实际就是业务发生时间
            Date businessLastDate = DateUtil.lastTimeOfDay(DateUtil.convert("yyyyMMdd",uploadDate));
            Date businessFirstDate = DateUtil.firstTimeOfDay(DateUtil.convert("yyyyMMdd",uploadDate));
            Criteria ca = new Criteria();
            DateUtil.getCriteriaByDateRange(ca, "CHECK_DATE",businessFirstDate,businessLastDate);
            List<Map<String,Object>> loadMapList = rdExamAnalysDao.getOrganSummary(businessFirstDate,businessLastDate);
            if (ObjectUtil.isNotEmpty(loadMapList)) {
                for(Map<String,Object> map:loadMapList){
                    String organCode = map.get("HOSPITAL_CODE").toString();
                    Organization org = organizationApp.queryOrgan(organCode);
                    String logicDate = DateUtil.getDateTime("yyyyMMdd",businessFirstDate);
                    new ExamAnalysLoader(context,businessFirstDate, org, logicDate, uploadDate, map).run();
                }
            } else {
                logger.debug("[检验结果]表中没有[uploadDate: " + uploadDate + "]的数据。");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    protected void initTask() {
        logger = Logger.getLogger(ExamAnalysTaskService.class);
        super.initTask();
    }
}
