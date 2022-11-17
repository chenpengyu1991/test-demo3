package com.founder.rhip.ehr.service;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.IntegrationEmailConfig;
import com.founder.rhip.ehr.common.IntegrationNumberType;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.repository.basic.IIntegrationMonitorDao;
import com.founder.rhip.ehr.service.basic.IStandParameterCfgService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("emailMonitorService")
@TaskBean(cron = "0 0 4 * * ?", description = "平台监控邮件提醒功能定时任务")
public class EmailMonitorServiceImpl extends AbstractService implements IEmailMonitorService, Task {

	private static Properties properties =  PropertiesUtils.initProperties("organization");
	private static String FILTER_ORG_CODE = "im.fiter.org";
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "integrationMonitorDao")
	private IIntegrationMonitorDao integrationMonitorDao;
	
	@Resource
	private IStandParameterCfgService standParameterCfgService;
	
	/**
	 * 常熟市社区卫生服务站编码
	 */
	private static final String STATION_ORGAN_CODE = "320000000";
	
	private static final String TEMPLATE_PATH = "/template";
	
	@Override
	public void integrationMonitor() throws Exception {
		boolean sendMailFlag = false;
		Map<String,String> monitorMap = new HashMap<String,String>();
		Map<String,String> cfgMap = getCfgMap();
		String outpatientResult = checkOutpatient(cfgMap);
		if(StringUtil.isNotEmpty(outpatientResult)){
			sendMailFlag = true;
			monitorMap.put("OUTPATIENT", outpatientResult);
		}
		
		String pharmacyResult = checkPharmacy(cfgMap);
		if(StringUtil.isNotEmpty(pharmacyResult)){
			sendMailFlag = true;
			monitorMap.put("PHARMACY", pharmacyResult);
		}
		boolean vaccinateFlag = checkVaccinateInfo(cfgMap);
		boolean maternalChildFlag = checkMaternalChild(cfgMap);
		sendMailFlag = sendMailFlag ||vaccinateFlag;
		sendMailFlag = sendMailFlag || maternalChildFlag;

		monitorMap.put("VACCINATE", vaccinateFlag?"1":"0");
		monitorMap.put("MATERNAL_CHILD", maternalChildFlag?"1":"0");
		monitorMap.put(IntegrationEmailConfig.PARAMETER_CODE_MAIL_TO,cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_TO));
		monitorMap.put("MONITOR_DAYS", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_DAYS));
		monitorMap.put("MAIL_TO_NAME", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_TO));
		monitorMap.put("CURRENT_DATE", DateUtil.getDateTime("yyyy年MM月dd日", new Date()));
		if(sendMailFlag){
			String emailContent = createEmailContent(monitorMap);
			sendMail(emailContent,cfgMap);
		}
	}

	/**
	 * 监控门诊记录:h01
	 * 监控机构:市级医院/中心/站
	 *
	 * @author Ye jianfei
	 */
	private String checkOutpatient(Map<String,String> cfgMap){
		StringBuilder result = new StringBuilder();
		
		Criteria criteria = new Criteria("GENRE_CODE",OP.IN,new String[]{OrgGenreCode.HOSPITAL.getValue(),OrgGenreCode.CENTRE.getValue()});
		criteria.add(LOP.OR,"organCode",STATION_ORGAN_CODE);
		//过滤掉没有集成数据的机构
		List<Organization> organizations = filterOrganization(organizationApp.queryOrganization(criteria));
		
		//根据机构从监控表中查询门诊记录
		Integer checkCount = 0;
		Criteria ca = getCriteria(cfgMap);
		ca.add("NUMBER_CODE",IntegrationNumberType.OUTPATIENT.getCode());
		for(Organization org:organizations){
			String organCode = org.getOrganCode();
			ca.add("ORGAN_CODE",organCode);
			checkCount = integrationMonitorDao.getCount(ca, "ID", Integer.class);
			ca.remove("ORGAN_CODE");
			if(checkCount == 0){//如果数据为0,说明该机构集成数据有异常
				if(result.length()>0){
					result.append("、");
				}
				result.append(org.getOrganName());
			}
		}
		return result.toString();
	}
	
	/**
	 * 监控计免数据:v18-2
	 * 监控机构:不区分机构
	 *
	 * @author Ye jianfei
	 */
	private boolean checkVaccinateInfo(Map<String,String> cfgMap){
		Criteria ca = getCriteria(cfgMap);
		ca.add("NUMBER_CODE",IntegrationNumberType.VACCINATE_INFO.getCode());
		Integer checkCount = integrationMonitorDao.getCount(ca, "ID", Integer.class);
		return checkCount>0?false:true;
	}
	
	/**
	 * 监控妇幼数据:C01,W06
	 * 监控机构:不区分机构
	 * @author Ye jianfei
	 */
	private boolean checkMaternalChild(Map<String,String> cfgMap){
		Criteria ca = getCriteria(cfgMap);
		ca.add("NUMBER_CODE",OP.IN
				,new String[]{IntegrationNumberType.BIRTH_CERTIFICATE.getCode(),IntegrationNumberType.DELIVERY_RECORD.getCode()});
		Integer checkCount = integrationMonitorDao.getCount(ca, "ID", Integer.class);
		return checkCount>0?false:true;
	}
	
	/**
	 * 监控电子药品监管数据:da12
	 * 监控机构:中心/市级医院
	 * @author Ye jianfei
	 */
	private String checkPharmacy(Map<String,String> cfgMap){
		StringBuilder result = new StringBuilder();
		Criteria caOrg = new Criteria("GENRE_CODE",OP.IN,new String[]{OrgGenreCode.HOSPITAL.getValue(),OrgGenreCode.CENTRE.getValue()});
		List<Organization> organizations = filterOrganization(organizationApp.queryOrganization(caOrg));
		//根据机构从监控表中查询门诊记录
		Integer checkCount = 0;
		Criteria ca = getCriteria(cfgMap);
		ca.add("NUMBER_CODE",IntegrationNumberType.PHARMACY.getCode());
		for(Organization org:organizations){
			String organCode = org.getOrganCode();
			ca.add("ORGAN_CODE",organCode);
			checkCount = integrationMonitorDao.getCount(ca, "ID", Integer.class);
			ca.remove("ORGAN_CODE");
			if(checkCount == 0){//如果数据为0,说明该机构集成数据有异常
				if(result.length()>0){
					result.append("、");
				}
				result.append(org.getOrganName());
			}
		}
		return result.toString();
	}
	
	/**
	 * 利用模版,创建邮件内容
	 *
	 * @param cfg:配置信息
	 * @return
	 * @author Ye jianfei
	 * @throws Exception 
	 */
	private String createEmailContent(Map<String,String> cfgMap) throws Exception {
		StringWriter writer = new StringWriter();
		if (ObjectUtil.isNullOrEmpty(cfgMap)) {
			return writer.toString();
		}
		//初始化并取得Velocity引擎
		VelocityEngine ve = new VelocityEngine();
		Properties properties = new Properties();
		//取得模版绝对路径
		String originalFilePath = this.getClass().getResource(TEMPLATE_PATH).toString().replaceAll("^file:/", ""); 
		properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, originalFilePath);  
		ve.init(properties);
		//取得velocity的模版 
		Template t = ve.getTemplate("emailVelocity.vm","UTF-8"); 
		//取得velocity的上下文context
		VelocityContext context = new VelocityContext();
		context.put("cfg", cfgMap);
		t.merge(context, writer);
		return writer.toString();

	}
	
	/**
	 * 发送邮件
	 *
	 * @param content
	 * @param cfgMap
	 * @throws EmailException
	 * @author Ye jianfei
	 */
	private void sendMail(String content,Map<String,String> cfgMap) throws EmailException{
		HtmlEmail email = new HtmlEmail();  
		email.setHostName(cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_SMTP));  
		email.setTLS(true); //是否TLS校验，，某些邮箱需要TLS安全校验，同理有SSL校验  
		email.setAuthenticator(new DefaultAuthenticator(cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_USERNAME)
				,cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_PASSWORD)));  

		email.setCharset("GB2312");  
		String [] fromMail = cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_TO_MAIL).split(";");
		for(String mail:fromMail){
			if(StringUtil.isNotEmpty(mail)){
				email.addTo(mail, mail);  
			}
		}
		email.setFrom(cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_FROM_MAIL)
				, cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_FROM));  
		email.setSubject(cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_SUBJECT));  
		email.setHtmlMsg(content);
		email.send();  
	}
	
	/**
	 * 获取配置表中配置信息
	 *
	 * @return
	 * @author Ye jianfei
	 */
	private Map<String,String> getCfgMap(){
		Map<String,String> cfgMap = new HashMap<String,String>();
		List<StandParameterCfg> cfgs = standParameterCfgService.getStandParameterList(IntegrationEmailConfig.STANDARD_CODE);
		if(ObjectUtil.isNotEmpty(cfgs)){
			for(StandParameterCfg cfg:cfgs){
				cfgMap.put(cfg.getParameterCode(), cfg.getParameterValue());
			}
		}	
		return cfgMap;
	}
	
	private Criteria getCriteria(Map<String,String> cfgMap){
		Criteria ca = new Criteria();
		String monitorDays = cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_DAYS);
		Date beginDate = DateUtil.getBeforeDay(new Date(),NumberUtil.convert(monitorDays, Integer.class));
		Date endDate = DateUtil.getBeforeDay(new Date(),1);

		DateUtil.getCriteriaByDateRange(ca, "RECORD_DATE", beginDate,endDate);
		return ca;
	}
	
	/**
	 * 根据配置文件过滤机构
	 *
	 * @param organizations
	 * @return
	 * @author Ye jianfei
	 */
	private List<Organization> filterOrganization(List<Organization> organizations) {
		List<Organization> destOrgs = new ArrayList<>();
		if (ObjectUtil.isNullOrEmpty(organizations)) {
			return destOrgs;
		}
		if (ObjectUtil.isNullOrEmpty(properties)) {
			return organizations;
		}
		String orgs = properties.getProperty(FILTER_ORG_CODE);
		if (ObjectUtil.isNotEmpty(orgs)) {
			String[] orgCodes = StringUtils.split(orgs, ",");
			loop: for (Organization organization : organizations) {
				for (String code : orgCodes) {
					if (StringUtils.equals(code, organization.getOrganCode())) {
						continue loop;
					}
				}
				destOrgs.add(organization);
			}
		}
		return destOrgs;
	}

	@Override
	public void run(Map<String, Object> data) {
		try {
			integrationMonitor();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}
	

}
