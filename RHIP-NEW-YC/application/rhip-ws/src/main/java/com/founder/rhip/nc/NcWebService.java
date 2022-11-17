package com.founder.rhip.nc;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.entity.nc.NcLog;
import com.founder.rhip.ehr.service.INcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service("ncWebService")
@WebService(serviceName="ncWebService")
public class NcWebService extends BaseWebService implements INcWebService {

    @Autowired
    private INcService ncService;
    


    /**
     * 当年及前五年内献血接口
     * @param idCard
     * @param personName
     * @param operateDateStr
     * @return
     */
    
    
    @Override
    public int getBloodDonation5(String idCard, String personName, String operateDateStr) {
        if(StringUtil.isEmpty(idCard)){
            return -1; //身份证未传
        }else {
            if(StringUtil.isEmpty(operateDateStr)){
                operateDateStr = DateUtil.getDateTime("yyyyMMdd", new Date());
            }
            NcLog ncLog = new NcLog();
            ncLog.setLogType("1");
            ncLog.setIdCard(idCard);
            ncLog.setPersonName(personName);
            ncLog.setOperateDate(DateUtil.parseSimpleDate(operateDateStr, "yyyyMMdd"));
            ncLog.setCreateDate(DateUtil.convertDate("yyyyMMdd", new Date()));
            ncService.insertNcLog(ncLog);
            return ncService.getBloodDonation5(idCard, personName, operateDateStr);
        }
    }

    /**
     * 当年及前五年内捐献血小板接口
     * @param idCard
     * @param personName
     * @param operateDateStr
     * @return
     */
    @Override
    public int getPlatelets5(String idCard, String personName, String operateDateStr) {
        if(StringUtil.isEmpty(idCard)){
            return -1; //身份证未传
        }else {
            if(StringUtil.isEmpty(operateDateStr)){
                operateDateStr = DateUtil.getDateTime("yyyyMMdd", new Date());
            }
            NcLog ncLog = new NcLog();
            ncLog.setLogType("2");
            ncLog.setIdCard(idCard);
            ncLog.setPersonName(personName);
            ncLog.setOperateDate(DateUtil.parseSimpleDate(operateDateStr, "yyyyMMdd"));
            ncLog.setCreateDate(DateUtil.convertDate("yyyyMMdd", new Date()));
            ncService.insertNcLog(ncLog);
            return ncService.getPlatelets5(idCard, personName, operateDateStr);
        }
    }

    /**
     * 早孕是否建卡接口
     * @param idCard
     * @param personName
     * @return
     */
    @Override
    public String isCarded(String idCard, String personName) {
        if(StringUtil.isEmpty(idCard)){
            return "-1"; //身份证未传
        }else {
            NcLog ncLog = new NcLog();
            ncLog.setLogType("3");
            ncLog.setIdCard(idCard);
            ncLog.setPersonName(personName);
            ncLog.setCreateDate(DateUtil.convertDate("yyyyMMdd", new Date()));
            ncService.insertNcLog(ncLog);
            return ncService.isCarded(idCard, personName);
        }
    }

    /**
     * 产前是否检查接口
     * @param idCard
     * @param personName
     * @return
     */
    @Override
    public String isChecked5(String idCard, String personName) {
        if(StringUtil.isEmpty(idCard)){
            return "-1"; //身份证未传
        }else {
            NcLog ncLog = new NcLog();
            ncLog.setLogType("4");
            ncLog.setIdCard(idCard);
            ncLog.setPersonName(personName);
            ncLog.setCreateDate(DateUtil.convertDate("yyyyMMdd", new Date()));
            ncService.insertNcLog(ncLog);
            return ncService.isChecked5(idCard, personName);
        }
    }

    /**
     * 儿童是否定期检查接口
     * @param idCard
     * @param personName
     * @return
     */
    @Override
    public String isChildRegular(String idCard, String personName) {
        if(StringUtil.isEmpty(idCard)){
            return "-1"; //身份证未传
        }else {
            NcLog ncLog = new NcLog();
            ncLog.setLogType("9");
            ncLog.setIdCard(idCard);
            ncLog.setPersonName(personName);
            ncLog.setCreateDate(DateUtil.convertDate("yyyyMMdd", new Date()));
            ncService.insertNcLog(ncLog);
            return ncService.isChildRegular(idCard, personName);
        }
    }

    /**
     * 三星健康档案接口
     * @param idCard
     * @param personName
     * @return
     */
    @Override
    public String isHealthRecord3Star(String idCard, String personName) {
        if(StringUtil.isEmpty(idCard)){
            return "-1"; //身份证未传
        }else {
            NcLog ncLog = new NcLog();
            ncLog.setLogType("5");
            ncLog.setIdCard(idCard);
            ncLog.setPersonName(personName);
            ncLog.setCreateDate(DateUtil.convertDate("yyyyMMdd", new Date()));
            ncService.insertNcLog(ncLog);
            return ncService.isHealthRecord3Star(idCard, personName);
        }
    }

    /**
     * 预防接种是否齐全接口
     * @param idCard
     * @param personName
     * @param birthdayStr
     * @param parentName
     * @return
     */
    @Override
    public String isVaccinationComplete(String idCard, String personName, String birthdayStr, String parentName) {
        if(StringUtil.isEmpty(idCard)){
            return "-1"; //身份证未传
        }else {
            NcLog ncLog = new NcLog();
            ncLog.setLogType("6");
            ncLog.setIdCard(idCard);
            ncLog.setPersonName(personName);
            ncLog.setBrithday(DateUtil.parseSimpleDate(birthdayStr, "yyyyMMdd"));
            ncLog.setParentName(parentName);
            ncLog.setCreateDate(DateUtil.convertDate("yyyyMMdd", new Date()));
            ncService.insertNcLog(ncLog);
            return ncService.isVaccinationComplete(idCard, personName, birthdayStr, parentName);
        }
    }

    /**
     * 是否办理从业人员健康证
     * @param idCard
     * @param personName
     * @return
     */
    @Override
    public String hasHealthCertificate(String idCard, String personName) {
        if(StringUtil.isEmpty(idCard)){
            return "-1"; //身份证未传
        }else {
            NcLog ncLog = new NcLog();
            ncLog.setLogType("7");
            ncLog.setIdCard(idCard);
            ncLog.setPersonName(personName);
            ncLog.setCreateDate(DateUtil.convertDate("yyyyMMdd", new Date()));
            ncService.insertNcLog(ncLog);
            return ncService.hasHealthCertificate(idCard, personName);
        }
    }

    /**
     * 行政处罚
     * @param idCard
     * @param personName
     * @param punishedDateStr
     * @return
     */
    @Override
    public int getPunishedTimes(String idCard, String personName, String punishedDateStr) {
        if(StringUtil.isEmpty(idCard)){
            return -1; //身份证未传
        }else {
            if(StringUtil.isEmpty(punishedDateStr)){
                punishedDateStr = DateUtil.getDateTime("yyyyMMdd", new Date());
            }
            NcLog ncLog = new NcLog();
            ncLog.setLogType("8");
            ncLog.setIdCard(idCard);
            ncLog.setPersonName(personName);
            ncLog.setOperateDate(DateUtil.parseSimpleDate(punishedDateStr, "yyyyMMdd"));
            ncLog.setCreateDate(DateUtil.convertDate("yyyyMMdd", new Date()));
            ncService.insertNcLog(ncLog);
            return ncService.getPunishedTimes(idCard, personName, punishedDateStr);
        }
    }

    private Date getStartDate(String endDateStr){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(endDateStr.substring(0,4)) - 5);
        calendar.set(Calendar.MONTH, Integer.parseInt(endDateStr.substring(4,6)));
        calendar.set(Calendar.DATE, Integer.parseInt(endDateStr.substring(6,8)));
        return calendar.getTime();
    }
}
