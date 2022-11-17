package com.founder.rhip.idm.aop;

import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
//import com.founder.fasf.util.SmsUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserRole;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.repository.basic.IUserDao;
import com.founder.rhip.idm.common.ReportStatus;
import com.founder.rhip.idm.dto.ReportDto;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IOrganizationDao;

/**
 * Created by meixingjian on 2017/3/30.
 */
@Aspect
@Service("reportServiceAop")
public class ReportServiceAop {

    private Logger log = Logger.getLogger(ReportServiceAop.class);

    @Resource(name="mdmOrganizationDao")
    private IOrganizationDao organizationDao;

    @Resource(name="ehrUserDao")
    private IUserDao userDao;

    Properties properties= PropertiesUtils.initProperties("idm-report-notice");

    @Pointcut("execution(* com.founder.rhip.idm.service.ReportServiceImpl.createReport(..))")
    private void createReportMethod(){}//定义一个切入点

    @AfterReturning(pointcut="createReportMethod() && args(reportDto,roleType,user,reportRecordId)",returning="rvt")
    public void smsNoticeHandler(ReportDto reportDto, RoleType roleType, User user, long reportRecordId, boolean rvt) {
            if(!rvt){
                log.warn("报卡保存失败，无需发送短信通知!");
                return;
            }
            IdmReport report =reportDto.getReport();

            if(properties ==null){
                log.warn("找不到配置文件idm-report-notice.properties!");
                return;
            }
            boolean enable= Boolean.valueOf((String)properties.get("notice_switch"));
            if(!enable){
                log.warn("报卡短信通知接口关闭!");
                return;
            }
            if(reportDto == null){
                log.debug("报卡短信通知Aop方法reportDto对象为空，无法发送短信通知!!");
                return;
            }

            if(report == null){
                log.debug("报卡短信通知Aop方法reportDto.report对象为空，无法发送短信通知!");
                return;
            }
            Integer status = report.getReportStatus();
            if(ReportStatus.HOSPITAL_VERIFY.getValue().equals(status)){
                log.info("已审核的外部报卡，无需发送短信通知!");
                return;
            }
            String orgCode = report.getFillOrganCode();
            if(StringUtil.isEmpty(orgCode)){
                log.debug("报卡短信通知Aop方法[报卡机构reportDto.report.fillOrganCode]对象为空!");
                return;
            }
            Criteria temp = new Criteria(Organization.ORGAN_CODE , orgCode);
            Organization org = organizationDao.get(temp);
            if(org==null){
                log.debug("报卡短信通知Aop方法找不到对应机构[orgCode:"+orgCode+"]!");
                return;
            }
            String genreCode = org.getGenreCode();
            UserRole userRole = new UserRole();
            if(OrgGenreCode.STATION.getValue().equals(genreCode)){//卫生服务站
                //获取父机构-社区服务中心编号
                String parentCode = org.getParentCode();
                userRole.setOrganCode(parentCode);
                //userRole.setRoleCode(RoleType.ZCRB.getValue());
                userRole.setRoleCode(RoleType.ZXCRB.getValue());
            }
            else if(OrgGenreCode.CENTRE.getValue().equals(genreCode)){//社区服务中心
                userRole.setOrganCode(org.getOrganCode());
                userRole.setRoleCode(RoleType.ZXCRB.getValue());
            }else if(OrgGenreCode.HOSPITAL.getValue().equals(genreCode)){//综合医院
                userRole.setOrganCode(org.getOrganCode());
                userRole.setRoleCode(RoleType.YYCRB.getValue());
            }
            List<User> userList = userDao.getUserList(userRole,null);
            if(userList==null){
                log.debug("报卡短信通知Aop方法找不到所属机构传防科用户OrganCode:"+userRole.getOrganCode());
                return;
            }
            //传染病code
            String infectiousCode = report.getInfectiousCode();
            //传染病名称
            String infectiousName = report.getInfectiousName();
            String dateStr = properties.getProperty(infectiousCode);
            if(dateStr==null){
                log.debug("报卡短信通知Aop方法找不到配置文件内"+infectiousName+"["+infectiousCode+"]对应的时间,默认成代码固定值!");
                dateStr="3";
            }
            String smsContent = "有一条新的"+infectiousName+"报卡信息,请您在"+dateStr+"小时内审核此数据!";
            String phones = null;
            for(int i=0;i<userList.size();i++){
                User us = userList.get(i);
                String phone = us.getMobile();
                if(StringUtil.isEmpty(phone)||phone.length()!=11){
                    log.debug("报卡短信通知Aop方法找不到所属机构传防科对应用户userCode:"+us.getUserCode()+"username:"+us.getUserName()+"手机号不正确!");
                    continue;
                }
                if(phones==null)
                    phones = phone;
                else
                    phones =phones+";"+phone;
            }
            //法定传染病的上报时限：甲类短信需要通知到【疾控】
            if("101".equals(infectiousCode) || "102".equals(infectiousCode)){
            	UserRole jkcrbRole = new UserRole();
            	jkcrbRole.setOrganCode(EHRConstants.JK_CODE);
            	jkcrbRole.setRoleCode(RoleType.JKFYK.getValue());
            	List<User> jkcrbUserList = userDao.getUserList(jkcrbRole,null);
            	for(int i=0;i<jkcrbUserList.size();i++){
                    User us = jkcrbUserList.get(i);
                    String phone = us.getMobile();
                    if(StringUtil.isEmpty(phone)||phone.length()!=11){
                        log.debug("报卡短信通知Aop方法找不到疾控对应用户userCode:"+us.getUserCode()+"username:"+us.getUserName()+"手机号不正确!");
                        continue;
                    }
                    if(phones==null)
                        phones = phone;
                    else
                        phones =phones+";"+phone;
                }
            }
            if(phones==null){
                log.warn("报卡短信通知-所属机构对应用户的手机号为空!");
                return;
            }
            String rs = null;
            try {
//            	rs = SmsUtil.sendSms(phones,smsContent);
            	//rs = SmsSender.sendMsg(phones,smsContent);
            } catch (Exception e) {
                e.printStackTrace();
                log.debug("短信发送异常",e);
            } 
            if("1".equals(rs))
                log.debug("短信发送成功!");
            else
                log.warn("短信发送失败!");
    }

}
