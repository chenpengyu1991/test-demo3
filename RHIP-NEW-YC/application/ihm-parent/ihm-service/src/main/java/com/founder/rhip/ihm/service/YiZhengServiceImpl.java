package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;
import com.founder.rhip.ehr.repository.ihm.IHmHospitalizeDao;
import com.founder.rhip.ehr.repository.ihm.IHmHospitalizeIntegrateDao;
import com.founder.rhip.ehr.repository.ihm.IHmOutpatientDao;
import com.founder.rhip.ehr.repository.ihm.IHmOutpatientIntegrateDao;
import com.founder.rhip.ehr.service.ihm.IYiZhengService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("ihmYiZhengService")
@TaskBean(cron = "0 0 12 * * ?", description = "抓取门诊及住院指标数据到综合管理库")
public class YiZhengServiceImpl extends AbstractService implements IYiZhengService , Task{

    @Resource(name = "ihmOutpatientDao")
    private IHmOutpatientDao ihmOutpatientDao;

    @Resource(name = "ihmHospitalizeDao")
    private IHmHospitalizeDao ihmHospitalizeDao;

    @Resource(name = "ihmHospitalizeIntegrateDao")
    private IHmHospitalizeIntegrateDao ihmHospitalizeIntegrateDao;

    @Resource(name = "ihmOutpatientIntegrateDao")
    private IHmOutpatientIntegrateDao ihmOutpatientIntegrateDao;

    @Autowired
    private IDictionaryApp dictionaryApp;

    @Resource(name = "organizationApp")
    protected IOrganizationApp organizationApp;

    protected Logger logger = LoggerFactory.getLogger(YiZhengServiceImpl.class);

    @Override
    public PageList<HmOutpatient> statisticsOutpatient(Criteria criteria,
                                                       Page page) {
        return ihmOutpatientDao.statisticsOutpatient(criteria, page);
    }

    @Override
    public PageList<HmHospitalize> statisticsHospitalize(Criteria criteria,
                                                         Page page) {
        return ihmHospitalizeDao.statisticsHospitalize(criteria, page);
    }

    @Override
    public HmOutpatient statisticsOutpatient(Criteria criteria) {
        return ihmOutpatientDao.statisticsOutpatient(criteria);
    }

    @Override
    public List<Map<String, Object>> statisticsOutpatient(Map<String, String> paramMap) {

        List<Map<String, Object>> mapList = ihmOutpatientDao.getHmOutpatientMapList(paramMap);
//        List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
        return mapList;
    }

    protected List<Map<String, Object>> matchTowns(List<Map<String, Object>> mapList, Map<String, String> paramMap) {
        List<Map<String, Object>> destMapList = new ArrayList<Map<String,Object>>();
        if (ObjectUtil.isNullOrEmpty(mapList) || ObjectUtil.isNullOrEmpty(paramMap)) {
            return destMapList;
        }
        List<Map<String, Object>> addMapList = new ArrayList<Map<String,Object>>();
        Map<String, Object> totalMap = null;
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        if (ObjectUtil.equals(genreCode, "0") && ObjectUtil.isNullOrEmpty(gbCode) && ObjectUtil.isNotEmpty(mapList)) {
            totalMap = mapList.get(mapList.size() - 1);
            mapList.remove(mapList.size() - 1);
            //获取所有的镇
            Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
            List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
            for (DicItem dicItem : dicItems) {
                boolean flag = true;
                for (Map<String, Object> map : mapList) {
                    if (StringUtils.equals(dicItem.getItemCode(), String.valueOf(map.get("gb_code")))) {
                        flag = false;
                    }
                }
                if (flag) {
                    Map<String, Object> m = new HashMap<String, Object>();
                    m.put("gb_code", dicItem.getItemCode());
                    addMapList.add(m);
                }
            }
        }
        if (ObjectUtil.isNotEmpty(addMapList)) {
            destMapList.addAll(mapList);
            destMapList.addAll(addMapList);
            destMapList.add(totalMap);
            return destMapList;
        } else {
            mapList.add(totalMap);
            return mapList;
        }
    }

    @Override
    public HmHospitalize statisticsHospitalize(Criteria criteria) {
        return ihmHospitalizeDao.statisticsHospitalize(criteria);
    }

    @Override
    public List<Map<String, Object>> statisticsHmHospitalize(Map<String, String> paramMap) {
        List<Map<String, Object>> mapList = ihmHospitalizeDao.getHmHospitalizeMapList(paramMap);
        /*List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);*/
        return mapList;
    }

    public void taskDataIntegration(String yestodayDate) {
        if (ObjectUtil.isNullOrEmpty(yestodayDate)) {
            Calendar c= DateUtil.getToday();
            //取昨天数据
            c.add(Calendar.DATE, -1);
            yestodayDate = DateUtil.getStringByDate(c.getTime());
        }
        //重复跑job时，按时间删除已存在的数据
        ihmHospitalizeDao.deleteHospitalizeData(yestodayDate, yestodayDate);
        ihmOutpatientDao.deleteOutpatientData(yestodayDate, yestodayDate);

        List<HmHospitalize> hopitalizeList = ihmHospitalizeIntegrateDao.catchHospitalizeData(yestodayDate);
        logger.info("查询到"+yestodayDate+"住院数据"+hopitalizeList.size()+"条。");
        int hospRs = ihmHospitalizeDao.batchInsert(hopitalizeList);
        List<HmOutpatient> outPatList=ihmOutpatientIntegrateDao.catchOutpatientData(yestodayDate);
        logger.info("查询到"+yestodayDate+"门急诊数据"+outPatList.size()+"条。");
        int outpatRs =ihmOutpatientDao.batchInsert(outPatList);
    }

    public Boolean importHistoryData(String begin, String end){
        String formate  ="yyyy/MM/dd";
        Date b = DateUtil.convert(formate,begin);
        Date e = DateUtil.convert(formate,end);
        int cnt= DateUtil.getBetweenDays(b, e);
        Calendar c = Calendar.getInstance();
        c.setTime(b);
//        ihmHospitalizeDao.deleteHospitalizeData(begin, end);
        ihmOutpatientDao.deleteOutpatientData(begin, end);
        for(int i=0;i<cnt;i++){
            String dd = DateUtil.getStringByDate(c.getTime());
//            List<HmHospitalize> hopitalizeList = ihmHospitalizeIntegrateDao.catchHospitalizeData(dd);
//            logger.info("查询到"+dd+"住院数据"+hopitalizeList.size()+"条。");
//            int hospRs = ihmHospitalizeDao.batchInsert(hopitalizeList);
//            logger.info("insert return count:"+hospRs);
            List<HmOutpatient> outPatList=ihmOutpatientIntegrateDao.catchOutpatientData(dd);
            logger.info("查询到"+dd+"门急诊数据"+outPatList.size()+"条。");
            int outpatRs =ihmOutpatientDao.batchInsert(outPatList);
            logger.info("insert return count:"+outpatRs);
            c.add(Calendar.DATE, 1);
        }
        return true;
    }

    @Override
    public void run(Map<String, Object> data) {
        Object param = data.get(TaskConstants.TASK_PARAM_KEY); // 参数格式yyyy/MM 年份如2016/11
        /*String param = "2017/08/28";*/
        Date date = new Date(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1);
        if(ObjectUtil.isNotEmpty(param)){
            //按天
            if(DateUtil.isValidDate(param.toString(), DAY_FORMAT)){
                cal.setTime(DateUtil.convert(DAY_FORMAT,param.toString()));
                taskDataIntegration(new SimpleDateFormat(DAY_FORMAT).format(cal.getTime()));
            }
            //按月
            else if(DateUtil.isValidDate(param.toString(),MONTH_FORMAT)){
                date = DateUtil.convert(MONTH_FORMAT,param.toString());
                cal.setTime(date);
                int lastDay = cal.getActualMaximum(Calendar.DATE);
                for(int i = 1;i<=lastDay;i++){
                    cal.set(Calendar.DAY_OF_MONTH,i);
                    taskDataIntegration(new SimpleDateFormat(DAY_FORMAT).format(cal.getTime()));
                }
            }
            //按年
            else if(DateUtil.isValidDate(param.toString(),YEAR_FORMAT)){
                for(int i = 1;i<13;i++) {
                    date = DateUtil.convert(MONTH_FORMAT, param.toString() + "/"+ String.format("%02d",i));
                    cal.setTime(date);
                    int lastDay = cal.getActualMaximum(Calendar.DATE);
                    for (int j = 1; j <= lastDay; j++) {
                        cal.set(Calendar.DAY_OF_MONTH, j);
                        taskDataIntegration(new SimpleDateFormat(DAY_FORMAT).format(cal.getTime()));
                    }
                }
            }
        } else {
            //取前一天数据
            taskDataIntegration(new SimpleDateFormat(DAY_FORMAT).format(cal.getTime()));
        }
    }
}
