package com.founder.rhip.ehr.service.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.entity.child.ChildWeekExamNum;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.repository.child.IWomenChildHealthDao;
import com.founder.rhip.ehr.service.child.IChildHealthExamineService;
import com.founder.rhip.ehr.service.child.IChildWeekExamNumService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yuanzg on 2017/6/16.
 */
@Service("staChildToExamService")
@TaskBean(description = "儿童预约体检批量统计")
public class StaChildToExamService implements Task {

    @Resource(name = "womenChildHealthDao")
    private IWomenChildHealthDao womenChildHealthDao;

    @Autowired
    private IChildHealthExamineService childHealthExamineService;

    @Autowired
    private IChildWeekExamNumService childWeekExamNumService;

    @Override
    public void run(Map<String, Object> data) {
        Map<String, Integer> map = getChild();
        childWeekExamNumService.delete(new Criteria());
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            ChildWeekExamNum childWeekExamNum = new ChildWeekExamNum();
            childWeekExamNum.setOrganCode(key);
            childWeekExamNum.setChildExamnum(map.get(key));
            childWeekExamNum.setCreateDate(new Date());
            childWeekExamNumService.save(childWeekExamNum);
        }
    }

    private Map<String, Integer> getChild() {
        Map<String, Integer> map = new HashMap<>();
        List<WomenChildHealth> childList = womenChildHealthDao.getList(new Criteria("isDelete", "0").add("identityType", "1"));
        if (ObjectUtil.isNotEmpty(childList)) {
            for (WomenChildHealth womenChildHealth : childList) {
                Date birth = womenChildHealth.getChildBirthday();
                if (ObjectUtil.isNullOrEmpty(birth)) {
                    continue;
                }
                Date newDate = addDate(birth, 7);//生日减上一周的日期
                long birthYear = newDate.getYear() + 1900;
                long birthMonth = newDate.getMonth() + 1;
                long birthDay = newDate.getDate();
                String physicalExamAge = countAge(birthYear, birthMonth, birthDay);
                Criteria c = new Criteria();
                if (StringUtil.isNotEmpty(physicalExamAge)) {
                    c.add("cPhysicalExamAge", physicalExamAge);
                    if (StringUtil.isNotEmpty(womenChildHealth.getIdCard())) {
                        c.add("idCard", womenChildHealth.getIdCard());
                    }
                    if (StringUtil.isNotEmpty(womenChildHealth.getBabyCardNo())) {
                        c.add("babyCardNo", womenChildHealth.getBabyCardNo());
                    }
                    ChildHealthExamination childHealthExamination = childHealthExamineService.getChildHealthExam(c);
                    if (ObjectUtil.isNullOrEmpty(childHealthExamination)) {
                        boolean flag = map.containsKey(womenChildHealth.getOrgCode());
                        if (flag) {
                            map.put(womenChildHealth.getOrgCode(), map.get(womenChildHealth.getOrgCode()) + 1);
                        } else {
                            map.put(womenChildHealth.getOrgCode(), 1);
                        }
                    }
                }
            }
        }
        return map;
    }

    private String countAge(long birthYear, long birthMonth, long birthDay) {
        String physicalExamAge = "";
        long nowYear = new Date().getYear() + 1900;
        long nowMonth = new Date().getMonth() + 1;
        long nowday = new Date().getDate();
        long nowTime = new Date().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //满月日期
            long oneMYear = (birthMonth + 1) / 12 + birthYear;
            long oneMMonth = (birthMonth + 1) % 12;
            String a = "" + oneMYear + "-" + oneMMonth + "-" + birthDay + "";
            Date oneMDate = sdf.parse("" + oneMYear + "-" + oneMMonth + "-" + birthDay + "");
            //满三月日期
            long threeMYear = (birthMonth + 3) / 12 + birthYear;
            long threeMMonth = (birthMonth + 3) % 12;
            Date threeMDate =  sdf.parse("" + threeMYear + "-" + threeMMonth + "-" + birthDay + "");
            if (nowTime > oneMDate.getTime() && nowTime <= threeMDate.getTime()) {
                physicalExamAge = "满月";
            }
            //满六月日期
            long sixMYear = (birthMonth + 6) / 12 + birthYear;
            long sixMMonth = (birthMonth + 6) % 12;
            Date sixMDate =  sdf.parse("" + sixMYear + "-" + sixMMonth + "-" + birthDay + "");
            if (nowTime > threeMDate.getTime() && nowTime <= sixMDate.getTime()) {
                physicalExamAge = "3月龄";
            }
            //满8月日期
            long eightMYear = (birthMonth + 8) / 12 + birthYear;
            long eightMMonth = (birthMonth + 8) % 12;
            Date eightMDate =  sdf.parse("" + eightMYear + "-" + eightMMonth + "-" + birthDay + "");
            if (nowTime > sixMDate.getTime() && nowTime <= eightMDate.getTime()) {
                physicalExamAge = "6月龄";
            }
            //满12月日期
            long twelveMYear = (birthMonth + 12) / 12 + birthYear;
            long twelveMMonth = (birthMonth + 12) % 12;
            Date twelveMDate =  sdf.parse("" + twelveMYear + "-" + twelveMMonth + "-" + birthDay + "");
            if (nowTime > eightMDate.getTime() && nowTime <= twelveMDate.getTime()) {
                physicalExamAge = "8月龄";
            }
            //满18月日期
            long eighteenMYear = (birthMonth + 18) / 12 + birthYear;
            long eighteenMMonth = (birthMonth + 18) % 12;
            Date eighteenMDate =  sdf.parse("" + eighteenMYear + "-" + eighteenMMonth + "-" + birthDay + "");
            if (nowTime > twelveMDate.getTime() && nowTime <= eighteenMDate.getTime()) {
                physicalExamAge = "12月龄";
            }
            //满24月日期
            long twentyFourMYear = (birthMonth + 24) / 12 + birthYear;
            long twentyFourMMonth = (birthMonth + 24) % 12;
            Date twentyFourMDate =  sdf.parse("" + twentyFourMYear + "-" + twentyFourMMonth + "-" + birthDay + "");
            if (nowTime > eighteenMDate.getTime() && nowTime <= twentyFourMDate.getTime()) {
                physicalExamAge = "18月龄";
            }
            //满30月日期
            long thirtyMYear = (birthMonth + 30) / 12 + birthYear;
            long thirtyMMonth = (birthMonth + 30) % 12;
            Date thirtyMDate =  sdf.parse("" + thirtyMYear + "-" + thirtyMMonth + "-" + birthDay + "");
            if (nowTime > twentyFourMDate.getTime() && nowTime <= thirtyMDate.getTime()) {
                physicalExamAge = "24月龄";
            }
            //满3岁日期
            long threeYYear = birthYear+3;
            Date threeYDate =  sdf.parse("" + threeYYear + "-" + birthMonth + "-" + birthDay + "");
            if (nowTime > thirtyMDate.getTime() && nowTime <= threeYDate.getTime()) {
                physicalExamAge = "30月龄";
            }
            //满4岁日期
            long fourYYear = birthYear+4;
            Date fourYDate =  sdf.parse("" + fourYYear + "-" + birthMonth + "-" + birthDay + "");
            if (nowTime > threeYDate.getTime() && nowTime <= fourYDate.getTime()) {
                physicalExamAge = "3岁";
            }
            //满5岁日期
            long fiveYYear = birthYear+5;
            Date fiveYDate =  sdf.parse("" + fiveYYear + "-" + birthMonth + "-" + birthDay + "");
            if (nowTime > fourYDate.getTime() && nowTime <= fiveYDate.getTime()) {
                physicalExamAge = "4岁";
            }
           //满6岁日期
            long sixYYear = birthYear+6;
            Date sixYDate =  sdf.parse("" + sixYYear + "-" + birthMonth + "-" + birthDay + "");
            if (nowTime > fiveYDate.getTime() && nowTime <= sixYDate.getTime()) {
                physicalExamAge = "5岁";
            }
            if (nowTime > sixYDate.getTime()) {
                physicalExamAge = "6岁";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return physicalExamAge;
    }

    private Date addDate(Date oldDate, long day) {
        long oldTime = oldDate.getTime();
        long newTime = oldTime - day * 24 * 60 * 60 * 1000;
        return new Date(newTime);
    }
}
