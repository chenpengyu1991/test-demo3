package com.founder.rhip.im.service.task;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.im.service.ICollectDataService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskConstants;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by shushu on 2016/4/25.
 */
public abstract class BasicTaskService implements ICollectDataService, ApplicationContextAware, Task {

    protected static Logger logger;

    // Spring应用上下文环境
    protected static ApplicationContext context;

    @Resource(name = "organizationApp")
    protected IOrganizationApp organizationApp;

    @Override
    public void run(Map<String, Object> data) {
        initTask();
        Object param = data.get(TaskConstants.TASK_PARAM_KEY); // 参数格式yyyyMM 年份如201611
        Date date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        if(ObjectUtil.isNotEmpty(param)){
            //按天
            if(DateUtil.isValidDate(param.toString(),"yyyyMMdd")){
                cal.setTime(DateUtil.convert("yyyyMMdd",param.toString()));
                startCollectLogicData(new SimpleDateFormat("yyyyMMdd").format(cal.getTime()));
            }else if(DateUtil.isValidDate(param.toString(),"yyyyMM")){
                //按月
                date = DateUtil.convert("yyyyMM",param.toString());
                cal.setTime(date);
                int lastDay = cal.getActualMaximum(Calendar.DATE);
                for(int i = 1;i<=lastDay;i++){
                    cal.set(Calendar.DAY_OF_MONTH,i);
                    startCollectLogicData(new SimpleDateFormat("yyyyMMdd").format(cal.getTime()));
                }
            }else if(DateUtil.isValidDate(param.toString(),"yyyy")){
                //按年
                for(int i = 1;i<13;i++) {
                    date = DateUtil.convert("yyyyMM", param.toString() + String.format("%02d",i));
                    cal.setTime(date);
                    int lastDay = cal.getActualMaximum(Calendar.DATE);
                    for (int j = 1; j <= lastDay; j++) {
                        cal.set(Calendar.DAY_OF_MONTH, j);
                        startCollectLogicData(new SimpleDateFormat("yyyyMMdd").format(cal.getTime()));
                    }
                }
            }
        }else{
            //取前一天数据
            startCollectLogicData(new SimpleDateFormat("yyyyMMdd").format(cal.getTime()));
        }


    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void startCollectLogicData(String uploadDate) {
        if (uploadDate == null || uploadDate.isEmpty() || uploadDate.length() != 8) {
            String message = "参数 uploadDate 为空 或  非法长度  错误 ";
            logger.error(message);
            throw new NullPointerException(message);
        }
        //因为没有数据采集时间，故这里的上传日期实际就是业务发生时间
        this.startCollectLogicData(uploadDate);
    }

    @Override
    public void startCollectLogicData(String orgCode, String uploadDate) {

    }

    @Override
    public void startCollectLogicData(String[] orgCodes, String uploadDate) {
        if (orgCodes == null || orgCodes.length == 0) {
            String message = "参数 orgCodes为空错误 ";
            logger.error(message);
            throw new NullPointerException(message);
        }
        if (uploadDate == null || uploadDate.isEmpty() || uploadDate.length() != 8) {
            String message = "参数 uploadDate 为空 或  非法长度  错误 ";
            logger.error(message);
            throw new NullPointerException(message);
        }
        for (String orgCode : orgCodes) {
            this.startCollectLogicData(orgCode, uploadDate);
        }
    }

    protected void initTask(){

    }

}
