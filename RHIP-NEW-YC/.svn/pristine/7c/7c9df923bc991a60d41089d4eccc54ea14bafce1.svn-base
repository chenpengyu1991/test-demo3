package com.founder.rhip.im.service.task;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.basic.IReportRecordDao;
import com.founder.rhip.im.service.loader.ReportCardLoader;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 报卡监控任务调度
 * Created by jingqiu on 16-8-2.
 */
@Service("reportRecordTaskService")
@TaskBean(description = "报卡监控数据抽取")
public class ReportCardTaskService extends BasicTaskService {

    @Resource
    private IReportRecordDao reportRecordDao;

    @Override
    public void startCollectLogicData(String orgCode, String uploadDate) {/*
        if (ObjectUtil.isNullOrEmpty(logger)) logger = Logger.getLogger(ReportCardTaskService.class);
        try {
            List<String> times = getReportRecordTimeslice(orgCode, uploadDate);
            Organization org = organizationApp.queryOrgan(orgCode);
            if (ObjectUtil.isNotEmpty(times)) {
                for (String logicDate : times) {
                    List<Map<String, Object>> reportCards = reportRecordDao.countReportCard(orgCode, logicDate);
                    if (ObjectUtil.isNotEmpty(reportCards)) {
                        //报卡监控
                        new ReportCardLoader(context, org, logicDate, uploadDate, reportCards).run();
                    } else {
                        logger.debug("[报卡监控 REPORT_RECORD] 机构 [orgName:" + org.getOrganName() + "][orgCode" + orgCode + "][uploadDate:" + uploadDate + "] 的数据不存在 .");
                    }
                }
            } else {
                logger.debug("[报卡监控 REPORT_RECORD]表中没有  [orgName:" + org.getOrganName() + "][orgCode:" + orgCode + "][uploadDate: " + uploadDate + "]的数据。");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    */}


    private List<String> getReportRecordTimeslice(String orgCode, String uploadDate) throws Exception {
        List<String> timeslice = new ArrayList<>();
/*        for(int i=1;i<7;i++){
            Date monthDay = DateUtil.lastDateOfMonth(DateUtil.parseSimpleDate(String.format("2016%02d01",i),"yyyyMMdd"));
            int day = DateUtil.getField(monthDay, Calendar.DAY_OF_MONTH);
            for(int j=1;j<day;j++){
                timeslice.add(String.format("2016%02d%02d",i,j));
            }
        }*/
        timeslice.add(uploadDate);
        return timeslice;
    }

    @Override
    protected void initTask() {
        logger = Logger.getLogger(ReportCardTaskService.class);
        super.initTask();
    }
}
