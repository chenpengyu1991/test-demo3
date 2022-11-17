package com.founder.rhip.im.monitor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.fasf.beans.OP;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.dto.integration.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.IntegrationLog;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.service.basic.IIntegrationMonitorService;
import com.founder.rhip.ehr.service.basic.IStandParameterCfgService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;

@Controller
@RequestMapping("/im")
public class IntegrationMonitorController extends BaseController {

	private static final String RECORD_DATE = "RECORD_DATE";
	private static final String NUMBER_CODE = "NUMBER_CODE";
	// 根据年月日查询
	private static final String DATE_TYPE_DAY = "1";
	private static final String DATE_TYPE_MONTH = "2";
	private static final String DATE_TYPE_YEAR = "3";

	
	private static Properties properties =  PropertiesUtils.initProperties("organization");
	
	private static String FILTER_ORG_CODE = "im.fiter.org";
	
	@Resource(name = "integrationMonitorService")
	private IIntegrationMonitorService integrationMonitorService;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource
	private IStandParameterCfgService standParameterCfgService;
	
	@RequestMapping("/view")
	public String view(ModelMap model, HttpServletRequest request) {
		model.addAttribute("currentUser",request.getSession().getAttribute("currentUser"));
		return "rhip.ehr.integration.view";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/list/{type}")
	public String list(@PathVariable("type") Integer type, String projectNamesHP, ModelMap map, HttpServletRequest request) {
		// 开始日期、查询的时间日期段、机构代码
		Object[] objs = IntegrationQueryConditionUtils.processQueryCondition(request.getParameterMap());
		if (ObjectUtil.isNullOrEmpty(objs) || objs.length < 3) {
			return null;
		}
		List<Date> dateList = (List<Date>) objs[1];
		Date beginDate = (Date) objs[0];
	
		List<Organization> organizations = new ArrayList<>();
		List<Organization> centres = new ArrayList<>();
		// 按特定机构
		if (ObjectUtil.isNotEmpty(objs[2])) {
			Organization organization = organizationApp.queryOrgan(String.valueOf(objs[2]));
			organizations.add(organization);
		} else {
            if(type != IntegrationMonitorType.BLOODSTATION.getCode() && type != IntegrationMonitorType.DATA120.getCode()){
                List<Organization> hospitals = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.HOSPITAL.getValue()));//获取综合医院
                centres = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.CENTRE.getValue()));//获取中心医院
                if (type == IntegrationMonitorType.HOSPITALMEDICAL.getCode() || type == IntegrationMonitorType.PHYSICALEXAMINATION.getCode() || type == IntegrationMonitorType.MEDICALGOODS.getCode()) { // 院内数据、医药卫生用品、体检包括市级医院
                    organizations.addAll(hospitals);
                }
                organizations.addAll(centres);
            }else if(type == IntegrationMonitorType.DATA120.getCode()){ //120数据只需要  急救中心、急救站
                Organization jjCenter = organizationApp.queryOrgan("FS-04");//获取急救中心
                Organization jjStation = organizationApp.queryOrgan("320003328");//获取急救站
                organizations.add(jjCenter);
                organizations.add(jjStation);
            }
		}
		map.put("dateList", dateList);
		if (type == IntegrationMonitorType.FRONTMACHINE.getCode()) { // 前置机
			for (int i = 0; i < organizations.size(); i++) {
				Organization org = organizations.get(i);
				String hostAddress = FrontMachine.getHostAddress(org.getOrganName());//获取前置机IP地址
				String statusName = connectMachine(hostAddress);
				org.setStatusName(statusName);//设置前置机状态信息
				org.setMachineAddress(hostAddress);//设置前置机IP地址
			}
			map.put("organizations", organizations);
			return "rhip.ehr.integration.frontmachine";
		} else if (type == IntegrationMonitorType.DRUGCATEGORY.getCode()) { // 药品目录
			if (ObjectUtil.isNotEmpty(objs[2])) { // 选择特定机构
				centres.addAll(organizations);
			}
			List<DrugMonitorRecord> drugMonitorRecordList = integrationMonitorService.organizeDrugMonitorRecord(filterOrganization(centres), dateList, beginDate);
			map.put("drugMonitorRecordList", drugMonitorRecordList);
			return "rhip.ehr.integration.drug";
		} else if (type == IntegrationMonitorType.HOSPITALMEDICAL.getCode()) { // 院内医疗数据
			if (ObjectUtil.isNullOrEmpty(objs[2])) { // 没有选择特定机构
				// SAAS常熟市社区卫生服务站
				Organization org = organizationApp.queryOrgan("320000000");
				if(null != org) {
					organizations.add(org);
				}
			}
            if(StringUtil.isEmpty(projectNamesHP)){
                return "rhip.ehr.integration.hospitalmedical";
            }
			List<String> projectNameList = Arrays.asList(projectNamesHP.split(","));
			List<HospitalMedicalMonitorRecord> hmMonitorList = integrationMonitorService.organizeHospitalMedicalMonitorRecord(filterOrganization(organizations), dateList, beginDate, projectNameList);
			map.put("hmMonitorList", hmMonitorList);
			map.put("projectNameList", projectNameList);
			return "rhip.ehr.integration.hospitalmedical";
		} else if (type == IntegrationMonitorType.PLANIMMUNIZATION.getCode()) { // 计免
			List<GenericMonitor> genericMonitorList = integrationMonitorService.organizePlanImmunizationMonitorRecord(dateList, beginDate);
			map.put("genericMonitorList", genericMonitorList);
			return "rhip.ehr.integration.planimmu";
		} else if (type == IntegrationMonitorType.WOMENCHILDRENHEALTHCARE.getCode()) { // 妇幼保健
			List<WomenChildrenMonitorRecord> wChildrenMonitorRecordList = integrationMonitorService.organizeWomenChildrenMoitorRecord(dateList, beginDate);
			map.put("wChildrenMonitorRecordList", wChildrenMonitorRecordList);
			return "rhip.ehr.integration.womenchildren";
		} else if (type == IntegrationMonitorType.PHYSICALEXAMINATION.getCode()) { // 体检
			List<PhysicalExaminationMonitorRecord> physicalExamMonitorRecordList = integrationMonitorService.organizePhysicalExaminationMonitorRecord(filterOrganization(organizations), dateList, beginDate);
			map.put("physicalExamMonitorRecordList", physicalExamMonitorRecordList);
			return "rhip.ehr.integration.physicalexam";
		} else if (type == IntegrationMonitorType.MEDICALGOODS.getCode()) { // 医药卫生用品
            if (ObjectUtil.isNullOrEmpty(objs[2])) { // 没有选择特定机构
                // SAAS常熟市社区卫生服务站
                Organization org = organizationApp.queryOrgan("320000000");
				if(null != org) {
					organizations.add(org);
				}
            }
            if(StringUtil.isNullOrEmpty(projectNamesHP)){
                return "rhip.ehr.integration.medicalGoods";
            }
            List<String> projectNameList = Arrays.asList(projectNamesHP.split(","));
            List<HospitalMedicalMonitorRecord> hmMonitorList = integrationMonitorService.medicalGoodsMonitorRecord(filterOrganization(organizations), dateList, beginDate, projectNameList);
            map.put("hmMonitorList", hmMonitorList);
            map.put("projectNameList", projectNameList);
            return "rhip.ehr.integration.medicalGoods";
        }else if (type == IntegrationMonitorType.BLOODSTATION.getCode()) { // 血站
            if(StringUtil.isNullOrEmpty(projectNamesHP)){
                return "rhip.ehr.integration.bloodStation";
            }
            List<String> projectNameList = Arrays.asList(projectNamesHP.split(","));
            List<HospitalMedicalMonitorRecord> hmMonitorList = integrationMonitorService.bloodStationMonitorRecord(filterOrganization(organizations), dateList, beginDate, projectNameList);
            map.put("hmMonitorList", hmMonitorList);
            map.put("projectNameList", projectNameList);
            return "rhip.ehr.integration.bloodStation";
        }else if (type == IntegrationMonitorType.DATA120.getCode()) { // 120数据
            if(StringUtil.isNullOrEmpty(projectNamesHP)){
                return "rhip.ehr.integration.data120";
            }
            List<String> projectNameList = Arrays.asList(projectNamesHP.split(","));
            List<HospitalMedicalMonitorRecord> hmMonitorList = integrationMonitorService.data120MonitorRecord(filterOrganization(organizations), dateList, beginDate, projectNameList);
            map.put("hmMonitorList", hmMonitorList);
            map.put("projectNameList", projectNameList);
            return "rhip.ehr.integration.data120";
        }
        return null;
	}
	
	/**
	 * 获取前置机东方通状态
	 * 
	 * @param hostAddress
	 *            前置机IP地址
	 * @return
	 */
	public String connectMachine(String hostAddress){
		Socket client = new Socket();
			try {
				client.setSoTimeout(100);
				client.connect(new InetSocketAddress(hostAddress, 7777), 100);
				client.setKeepAlive(false);
				client.close();
			} catch (Exception e) {
				return "<font color=\"red\">异常<font>";
			} finally {
				try {
					client.close();
				} catch (IOException e) {
				}
			}
			return "正常";
	}
	
	/**
	 * 初始化查看集成日志的查询页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/log/search")
	public String initSearchLog(HttpServletRequest request, ModelMap model) {
		return "rhip.ehr.integration.log.search";
	}
	
	/**
	 * 集成日志列表
	 * @param integrationLog
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/log/list")
	public String searchLog(IntegrationLog integrationLog, HttpServletRequest request, ModelMap model) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage); 
		Criteria criteria = this.getIntegrationLogCriteria(integrationLog);
		
		PageList<IntegrationLog> plist = integrationMonitorService.searchIntegrationLogs(criteria, page);
		model.addAttribute("integrationLogs", plist.getList());
		model.addAttribute("page", plist.getPage());
		return "rhip.ehr.integration.log.list";
	}
	
	/**
	 * 初始化查看医疗数据的查询页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/medicalData/search")
	public String initSearchMedicalData(HttpServletRequest request, ModelMap model) {
		List<Date> dateList = this.getDateList(new Date());
		model.put("dateList", dateList);
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
//		model.put("currentLoginOrgCode", currentLoginInfo.getOrganization().getOrganCode());
		return "rhip.ehr.integration.medical.data.search";
	}
	
	/**
	 * 医疗数据列表
	 * @param organCode
	 * @param request
	 * @param projectNames
	 * @return
	 */
	@RequestMapping("/medicalData/list")
	public String searchMedicalData(String organCode, Date medicalDataDate,String projectNames, HttpServletRequest request, ModelMap modelMap) {
		//若查询日期为空则默认查当天（包含）之前的两周数据
		if (ObjectUtil.isNullOrEmpty(medicalDataDate)) {
			medicalDataDate = new Date();
		}
		List<Date> dateList = this.getDateList(medicalDataDate);
	
		List<Organization> organizations = new ArrayList<>();
		List<Organization> centres = new ArrayList<>();
		// 按特定机构
		if (ObjectUtil.isNotEmpty(organCode)) {
			Organization organization = organizationApp.queryOrgan(organCode);
			organizations.add(organization);
		} else {
			List<Organization> hospitals = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.HOSPITAL.getValue()));//获取综合医院
			centres = organizationApp.queryOrganization(new Criteria("GENRE_CODE",OrgGenreCode.CENTRE.getValue()));//获取中心医院
			organizations.addAll(hospitals);
			organizations.addAll(centres);
		}
		modelMap.put("dateList", dateList);
		if (ObjectUtil.isNullOrEmpty(organCode)) { // 没有选择特定机构
			// SAAS常熟市社区卫生服务站
			Organization org = organizationApp.queryOrgan("320000000");
			if(null != org) {
				organizations.add(org);
			}
		}
        if(StringUtil.isNullOrEmpty(projectNames)){
            return "rhip.ehr.integration.medical.data.list";
        }
		List<String> projectNameList = Arrays.asList(projectNames.split(","));
		List<MedicalDataRecord> medicalDataList = integrationMonitorService.searchMedicalDataRecord(filterOrganization(organizations), medicalDataDate, projectNameList);
		modelMap.put("medicalDataList", medicalDataList);
		modelMap.put("projectNameList", projectNameList);
		return "rhip.ehr.integration.medical.data.list";
	}
	
	private List<Date> getDateList(Date date) {
		List<Date> dateList = new ArrayList<Date>();
		for (int i = 6; i >= 0; i--) {
			Date di = DateUtil.getBeforeDay(date, i);
			dateList.add(di);
		}
		return dateList;
	}
	
	/**
	 * 初始化提醒设置页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/emailconfig")
	public String emailConfig(HttpServletRequest request, ModelMap model) {
		Map<String,String> cfgMap = getCfgMap();
		Assert.notEmpty(cfgMap, "无法获取集成监控邮件配置信息:");
		Map<String,String> emailConfigMap = new HashMap<String,String>();
		//标准参数编码:SMTP地址
		emailConfigMap.put("smtpAddress", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_SMTP));
		//标准参数编码:用户名
		emailConfigMap.put("emailUserName", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_USERNAME));
		//标准参数编码:密码
		emailConfigMap.put("emailPassword", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_PASSWORD));
		//标准参数编码:发件人邮箱
		emailConfigMap.put("emailFrom", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_FROM_MAIL));
		//标准参数编码:发件人姓名
		emailConfigMap.put("emailFromName", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_FROM));
		//标准参数编码:监控天数
		emailConfigMap.put("monitorDays", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_DAYS));
		//标准参数编码:邮件称谓
		emailConfigMap.put("emailName", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_TO));
		//标准参数编码:邮件主题
		emailConfigMap.put("emailTitle", cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_SUBJECT));
		//标准参数编码:收件人邮箱(多个以分号分割)
		String emailTo = cfgMap.get(IntegrationEmailConfig.PARAMETER_CODE_MAIL_TO_MAIL);
		if(ObjectUtil.isNotEmpty(emailTo)){
			String[] emailTos =  emailTo.split(";");
			for(int i = 0;i<emailTos.length;i++){
				if(i == 0){
					emailConfigMap.put("emailTo", emailTos[i]);
				}else{
					emailConfigMap.put("emailTo" + i, emailTos[i]);
				}
			}
		}
		model.put("emailConfig", emailConfigMap);
		return "rhip.ehr.integration.emailconfig";
	}

	/**
	 * 保存提醒设置
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/emailconfig/save")
	public String emailconfigSave(HttpServletRequest request, ModelMap model) {
		boolean result = true;
		try {
			List<StandParameterCfg> cfgs = organizeCfg(request);
			standParameterCfgService.saveStandParameter(cfgs);
		} catch (Exception e) {
			logger.error("保存出错", e);
			result = false;
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	
	/**
	 * 组织提醒设置数据,每个字段存一条记录
	 *
	 * @param request
	 * @return
	 * @author Ye jianfei
	 */
	private List<StandParameterCfg> organizeCfg(HttpServletRequest request){
		List<StandParameterCfg> result = new ArrayList<StandParameterCfg>();
		StandParameterCfg cfg = new StandParameterCfg();
		
		//标准参数编码:SMTP地址
		cfg = new StandParameterCfg();
		cfg.setStandardCode(IntegrationEmailConfig.STANDARD_CODE);
		cfg.setParameterCode(IntegrationEmailConfig.PARAMETER_CODE_SMTP);
		cfg.setParameterValue(request.getParameter("smtpAddress"));
		result.add(cfg);
		
		//标准参数编码:用户名
		cfg = new StandParameterCfg();
		cfg.setStandardCode(IntegrationEmailConfig.STANDARD_CODE);
		cfg.setParameterCode(IntegrationEmailConfig.PARAMETER_CODE_USERNAME);
		cfg.setParameterValue(request.getParameter("emailUserName"));
		result.add(cfg);
		
		//标准参数编码:密码
		cfg = new StandParameterCfg();
		cfg.setStandardCode(IntegrationEmailConfig.STANDARD_CODE);
		cfg.setParameterCode(IntegrationEmailConfig.PARAMETER_CODE_PASSWORD);
		cfg.setParameterValue(request.getParameter("emailPassword"));
		result.add(cfg);
		
		//标准参数编码:发件人邮箱
		cfg = new StandParameterCfg();
		cfg.setStandardCode(IntegrationEmailConfig.STANDARD_CODE);
		cfg.setParameterCode(IntegrationEmailConfig.PARAMETER_CODE_MAIL_FROM_MAIL);
		cfg.setParameterValue(request.getParameter("emailFrom"));
		result.add(cfg);
		
		//标准参数编码:发件人姓名
		cfg = new StandParameterCfg();
		cfg.setStandardCode(IntegrationEmailConfig.STANDARD_CODE);
		cfg.setParameterCode(IntegrationEmailConfig.PARAMETER_CODE_MAIL_FROM);
		cfg.setParameterValue(request.getParameter("emailFromName"));
		result.add(cfg);
		
		//标准参数编码:监控天数
		cfg = new StandParameterCfg();
		cfg.setStandardCode(IntegrationEmailConfig.STANDARD_CODE);
		cfg.setParameterCode(IntegrationEmailConfig.PARAMETER_CODE_DAYS);
		cfg.setParameterValue(request.getParameter("monitorDays"));
		result.add(cfg);
		
		//标准参数编码:邮件称谓
		cfg = new StandParameterCfg();
		cfg.setStandardCode(IntegrationEmailConfig.STANDARD_CODE);
		cfg.setParameterCode(IntegrationEmailConfig.PARAMETER_CODE_MAIL_TO);
		cfg.setParameterValue(request.getParameter("emailName"));
		result.add(cfg);
		
		//标准参数编码:邮件主题
		cfg = new StandParameterCfg();
		cfg.setStandardCode(IntegrationEmailConfig.STANDARD_CODE);
		cfg.setParameterCode(IntegrationEmailConfig.PARAMETER_CODE_MAIL_SUBJECT);
		cfg.setParameterValue(request.getParameter("emailTitle"));
		result.add(cfg);
		
		//标准参数编码:收件人邮箱(多个以分号分割)
		StringBuilder emailTo = new StringBuilder(request.getParameter("emailTo"));
		for(int i = 0; i< 10;i++){
			String emailToOther = request.getParameter("emailTo" + i);
			if(StringUtil.isNotEmpty(emailToOther)){
				emailTo.append(";");
				emailTo.append(emailToOther);
			}
		}
		cfg = new StandParameterCfg();
		cfg.setStandardCode(IntegrationEmailConfig.STANDARD_CODE);
		cfg.setParameterCode(IntegrationEmailConfig.PARAMETER_CODE_MAIL_TO_MAIL);
		cfg.setParameterValue(emailTo.toString());
		result.add(cfg);
	
		return result;
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
	
	private Criteria getIntegrationLogCriteria(IntegrationLog integrationLog) {
		Criteria criteria = new Criteria();
		/*记录时间*/
		//Date recordDateBegin = DateUtil.parseDateString(integrationLog.getRecordDateBegin());
		//Date recordDateEnd = DateUtil.parseDateString(integrationLog.getRecordDateEnd());
		DateUtil.getCriteriaByDateRange(criteria, "RECORD_DATE", integrationLog.getRecordDateBegin(), integrationLog.getRecordDateEnd());
		/*机构代码*/
		if(ObjectUtil.isNotEmpty(integrationLog.getOrganCode())) {
			criteria.add("ORGAN_CODE", integrationLog.getOrganCode());
		}
		/*编号代码*/
		if(ObjectUtil.isNotEmpty(integrationLog.getNumberCode())) {
			criteria.add("NUMBER_CODE", integrationLog.getNumberCode());
		}
        /*异常分类*/
        String abnormalType = integrationLog.getAbnormalType();
        if(ObjectUtil.isNotEmpty(abnormalType)) {
            if("1".equals(abnormalType)){
                criteria.add("FULL_FLAG", 1);
            }
            if("2".equals(abnormalType)){
                criteria.add("CODE_FLAG", 1);
            }
            if("3".equals(abnormalType)){
                criteria.add("LOGIC_FLAG", 1);
            }

        }
		return criteria;
	}
	
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

	@RequestMapping("/statistics/index")
	public String statisticsIndex(ModelMap model, HttpServletRequest request) {
		model.addAttribute("currentUser",request.getSession().getAttribute("currentUser"));
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap = integrationMonitorService.getMonitorRecordNumMap(new Criteria());

		MedicalMonitor m = integrationMonitorService.getHospitalMedicalMonitorRecord(new Criteria());

		model.addAttribute("shouldCount", m.getShouldCount());
		model.addAttribute("actualCount",m.getActualCount());
		model.addAttribute("resultRight",Integer.valueOf(ObjectUtil.isNullOrEmpty(resultMap.get("FACT_UPLOAD_COUNT")) ? "0" : resultMap.get("FACT_UPLOAD_COUNT").toString()));
		model.addAttribute("resultError",Integer.valueOf(ObjectUtil.isNullOrEmpty(resultMap.get("FACT_FAIL_COUNT")) ? "0" : resultMap.get("FACT_FAIL_COUNT").toString()));
		return "rhip.ehr.integration.statistics";
	}

	/**
	 * 初始化查看集成日志的查询页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/chart")
	public @ResponseBody Object initChart(HttpServletRequest request, ModelMap model, String statisticsDate) {
		Date[] dateArr = getDateBetween(statisticsDate);

		Map<String,Object> hospitalMedalDataMap = new HashMap<String, Object>();
		Map<String,Object> medalDataMap = new HashMap<String, Object>();
		Map<String,Object> physicalExamMap = new HashMap<String, Object>();
		Map<String,Object> drugMonitorMap = new HashMap<String, Object>();
		Map<String,Object> planimmuMap = new HashMap<String, Object>();
		Map<String,Object> wChildrenMap = new HashMap<String, Object>();
		Map<String,Object> medicalGoodsMap = new HashMap<String, Object>();
		Map<String,Object> bloodStationMap = new HashMap<String, Object>();
		Map<String,Object> data120Map = new HashMap<String, Object>();
		Map<String,Object> resultMap = new HashMap<String, Object>();

		Criteria criteriaMonth = new Criteria();
		if(ObjectUtil.isNotEmpty(dateArr)) {
			DateUtil.getCriteriaByDateRange(criteriaMonth, RECORD_DATE, dateArr[0], dateArr[1]);
			hospitalMedalDataMap = integrationMonitorService.getMonitorRecordNumMap(this.getHospitalMedalDataCriteria().add(criteriaMonth));
			physicalExamMap = integrationMonitorService.getMonitorRecordNumMap(this.getpPhysicalExamCriteria().add(criteriaMonth));
			drugMonitorMap = integrationMonitorService.getMonitorRecordNumMap(this.getDrugChargeCriteria().add(criteriaMonth));
			planimmuMap = integrationMonitorService.getMonitorRecordNumMap(this.getPlanimmuCriteria().add(criteriaMonth));
			wChildrenMap = integrationMonitorService.getMonitorRecordNumMap(this.getWChildrenCriteria().add(criteriaMonth));
			medicalGoodsMap = integrationMonitorService.getMonitorRecordNumMap(this.getMedicalGoodsCriteria().add(criteriaMonth));
			bloodStationMap = integrationMonitorService.getMonitorRecordNumMap(this.getBloodStationCriteria().add(criteriaMonth));
			data120Map = integrationMonitorService.getMonitorRecordNumMap(this.getData120Criteria().add(criteriaMonth));
			resultMap = integrationMonitorService.getMonitorRecordNumMap(criteriaMonth);

		} else {
			hospitalMedalDataMap = integrationMonitorService.getMonitorRecordNumMap(this.getHospitalMedalDataCriteria());
			physicalExamMap = integrationMonitorService.getMonitorRecordNumMap(this.getpPhysicalExamCriteria());
			drugMonitorMap = integrationMonitorService.getMonitorRecordNumMap(this.getDrugChargeCriteria());
			planimmuMap = integrationMonitorService.getMonitorRecordNumMap(this.getPlanimmuCriteria());
			wChildrenMap = integrationMonitorService.getMonitorRecordNumMap(this.getWChildrenCriteria());
			medicalGoodsMap = integrationMonitorService.getMonitorRecordNumMap(this.getMedicalGoodsCriteria());
			bloodStationMap = integrationMonitorService.getMonitorRecordNumMap(this.getBloodStationCriteria());
			data120Map = integrationMonitorService.getMonitorRecordNumMap(this.getData120Criteria());
			resultMap = integrationMonitorService.getMonitorRecordNumMap(new Criteria());
		}

		Map<String, Integer> allData = new HashMap<String, Integer>();
		allData.put("hospitalMedalDataRightMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(hospitalMedalDataMap.get("FACT_UPDATE_COUNT")) ? "0" : hospitalMedalDataMap.get("FACT_UPDATE_COUNT").toString()) + Integer.valueOf(ObjectUtil.isNullOrEmpty(hospitalMedalDataMap.get("FACT_ADD_COUNT")) ? "0" : hospitalMedalDataMap.get("FACT_ADD_COUNT").toString()));
		allData.put("physicalExamRightMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(physicalExamMap.get("FACT_UPDATE_COUNT")) ? "0" : physicalExamMap.get("FACT_UPDATE_COUNT").toString()) + Integer.valueOf(ObjectUtil.isNullOrEmpty(physicalExamMap.get("FACT_ADD_COUNT")) ? "0" : physicalExamMap.get("FACT_ADD_COUNT").toString()));
		allData.put("drugMonitorRightMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(drugMonitorMap.get("FACT_UPDATE_COUNT")) ? "0" : drugMonitorMap.get("FACT_UPDATE_COUNT").toString()) + Integer.valueOf(ObjectUtil.isNullOrEmpty(drugMonitorMap.get("FACT_ADD_COUNT")) ? "0" : drugMonitorMap.get("FACT_ADD_COUNT").toString()));
		allData.put("planimmuRightMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(planimmuMap.get("FACT_UPDATE_COUNT")) ? "0" : planimmuMap.get("FACT_UPDATE_COUNT").toString()) + Integer.valueOf(ObjectUtil.isNullOrEmpty(planimmuMap.get("FACT_ADD_COUNT")) ? "0" : planimmuMap.get("FACT_ADD_COUNT").toString()));
		allData.put("wChildrenRightMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(wChildrenMap.get("FACT_UPDATE_COUNT")) ? "0" : wChildrenMap.get("FACT_UPDATE_COUNT").toString()) + Integer.valueOf(ObjectUtil.isNullOrEmpty(wChildrenMap.get("FACT_ADD_COUNT")) ? "0" : wChildrenMap.get("FACT_ADD_COUNT").toString()));
		allData.put("medicalGoodsRightMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(medicalGoodsMap.get("FACT_UPDATE_COUNT")) ? "0" : medicalGoodsMap.get("FACT_UPDATE_COUNT").toString()) + Integer.valueOf(ObjectUtil.isNullOrEmpty(medicalGoodsMap.get("FACT_ADD_COUNT")) ? "0" : medicalGoodsMap.get("FACT_ADD_COUNT").toString()));
		allData.put("bloodStationRightMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(bloodStationMap.get("FACT_UPDATE_COUNT")) ? "0" : bloodStationMap.get("FACT_UPDATE_COUNT").toString()) + Integer.valueOf(ObjectUtil.isNullOrEmpty(bloodStationMap.get("FACT_ADD_COUNT")) ? "0" : bloodStationMap.get("FACT_ADD_COUNT").toString()));
		allData.put("data120RightMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(data120Map.get("FACT_UPDATE_COUNT")) ? "0" : data120Map.get("FACT_UPDATE_COUNT").toString()) + Integer.valueOf(ObjectUtil.isNullOrEmpty(data120Map.get("FACT_ADD_COUNT")) ? "0" : data120Map.get("FACT_ADD_COUNT").toString()));

		allData.put("hospitalMedalDataErrorMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(hospitalMedalDataMap.get("FACT_FAIL_COUNT")) ? "0" : hospitalMedalDataMap.get("FACT_FAIL_COUNT").toString()));
		allData.put("physicalExamErrorMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(physicalExamMap.get("FACT_FAIL_COUNT")) ? "0" : physicalExamMap.get("FACT_FAIL_COUNT").toString()));
		allData.put("drugMonitorErrorMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(drugMonitorMap.get("FACT_FAIL_COUNT")) ? "0" : drugMonitorMap.get("FACT_FAIL_COUNT").toString()));
		allData.put("planimmuErrorMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(planimmuMap.get("FACT_FAIL_COUNT")) ? "0" : planimmuMap.get("FACT_FAIL_COUNT").toString()));
		allData.put("wChildrenErrorMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(wChildrenMap.get("FACT_FAIL_COUNT")) ? "0" : wChildrenMap.get("FACT_FAIL_COUNT").toString()));
		allData.put("medicalGoodsErrorMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(medicalGoodsMap.get("FACT_FAIL_COUNT")) ? "0" : medicalGoodsMap.get("FACT_FAIL_COUNT").toString()));
		allData.put("bloodStationErrorMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(bloodStationMap.get("FACT_FAIL_COUNT")) ? "0" : bloodStationMap.get("FACT_FAIL_COUNT").toString()));
		allData.put("data120ErrorMap", Integer.valueOf(ObjectUtil.isNullOrEmpty(data120Map.get("FACT_FAIL_COUNT")) ? "0" : data120Map.get("FACT_FAIL_COUNT").toString()));

		allData.put("resultRight", Integer.valueOf(ObjectUtil.isNullOrEmpty(resultMap.get("FACT_UPDATE_COUNT")) ? "0" : resultMap.get("FACT_UPDATE_COUNT").toString()) + Integer.valueOf(ObjectUtil.isNullOrEmpty(resultMap.get("FACT_ADD_COUNT")) ? "0" : resultMap.get("FACT_ADD_COUNT").toString()));
		allData.put("resultError",Integer.valueOf(ObjectUtil.isNullOrEmpty(resultMap.get("FACT_FAIL_COUNT")) ? "0" : resultMap.get("FACT_FAIL_COUNT").toString()));
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		allData.put("year", year);
		return allData;
	}

	private Date[] getDateBetween(String type) {
		Date nowDate = new Date();
		if (type.equals(DATE_TYPE_DAY)) {
			return new Date[] { DateUtil.firstTimeOfDay(nowDate), DateUtil.lastTimeOfDay(nowDate) };
		} else if (type.equals(DATE_TYPE_MONTH)) {
			return new Date[] { DateUtil.firstDateOfMonth(nowDate), DateUtil.lastDateOfMonth(nowDate) };
		} else if (type.equals(DATE_TYPE_YEAR)) {
			return new Date[] { DateUtil.firstDateOfYear(nowDate), DateUtil.lastDateOfYear(nowDate) };
		}
		return null;
	}

	private Criteria getHospitalMedalDataCriteria() {
		Criteria criteria = new Criteria();
		criteria.add(NUMBER_CODE, OP.IN, new String[]{"h01", "h02", "h03", "h04", "h06", "h07", "h09", "h10", "h11", "h12", "h13", "h14", "h15"});
		return  criteria;
	}

	private Criteria getpPhysicalExamCriteria() {
		Criteria criteria = new Criteria();
		criteria.add(NUMBER_CODE, IntegrationNumberType.PHYSICAL_EXAMINATION.getCode());
		return  criteria;
	}

	private Criteria getPlanimmuCriteria() {
		Criteria criteria = new Criteria();
		criteria.add(NUMBER_CODE, IntegrationNumberType.VACCINATE_INFO.getCode());
		return  criteria;
	}

	private Criteria getWChildrenCriteria() {
		Criteria criteria = new Criteria();
		List<String> codes = new ArrayList<String>();
		for (WomenChildrenHealthcareType womenChildrenHealthcareType : WomenChildrenHealthcareType.values()) {
			codes.add(womenChildrenHealthcareType.getCode());
		}
		criteria.add(NUMBER_CODE, OP.IN, codes);
		return  criteria;
	}

	private Criteria getMedicalGoodsCriteria() {
		Criteria criteria = new Criteria();
		criteria.add(NUMBER_CODE,OP.IN, new String[]{"da01", "da02", "da03", "da04", "da05", "da06", "da07", "da08",
				"da09", "da10", "da11", "da12", "da13"
				, "da14", "da15", "da16", "da17", "da18", "da19", "da20", "da21", "da22", "da23", "da24", "da25"});
		return  criteria;
	}

	private Criteria getBloodStationCriteria() {
		Criteria criteria = new Criteria();
		criteria.add(NUMBER_CODE,OP.IN, new String[]{"bs01", "bs02", "bs03", "bs04"});
		return  criteria;
	}

	private Criteria getData120Criteria() {
		Criteria criteria = new Criteria();
		criteria.add(NUMBER_CODE,OP.IN, new String[]{"jj01", "jj02", "jj03", "jj04"});
		return  criteria;
	}

	private Criteria getDrugChargeCriteria() {
		Criteria criteria = new Criteria();
		criteria.add(NUMBER_CODE, IntegrationNumberType.DRUG_CHARGE.getCode());
		return  criteria;
	}

	/**
	 * 初始化查看集成日志的查询页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/medical/chart")
	public @ResponseBody Object initMedicalChart(HttpServletRequest request, ModelMap model, String statisticsDate) {
		Date[] dateArr = getDateBetween(statisticsDate);
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);

		MedicalMonitor m = new MedicalMonitor();
		Criteria criteriaMonth = new Criteria();
		if(ObjectUtil.isNotEmpty(dateArr)) {
			DateUtil.getCriteriaByDateRange(criteriaMonth, RECORD_DATE, dateArr[0], dateArr[1]);
		}
		m = integrationMonitorService.getHospitalMedicalMonitorRecord(criteriaMonth);
		m.setYear(year);
		return m;
	}


	/**
	 * 医疗数据
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/medical_data/view")
	public String searchMedical_data(ModelMap model, HttpServletRequest request) {
		model.addAttribute("currentUser", request.getSession().getAttribute("currentUser"));
		return "rhip.ehr.integration.medical_data.search";
	}

	/**
	 * 公共卫生
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/public_health")
	public String setting(ModelMap model, HttpServletRequest request) {
		model.addAttribute("currentUser",request.getSession().getAttribute("currentUser"));
		return "rhip.ehr.integration.public_health.search";
	}

	/**
	 * 其他
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/other/view")
	public String searchOther(ModelMap model, HttpServletRequest request) {
		model.addAttribute("currentUser",request.getSession().getAttribute("currentUser"));
		return "rhip.ehr.integration.other.search";
	}

	@RequestMapping("/front_machine/search")
	public String searchFrontMachine(ModelMap model, HttpServletRequest request) {
		model.addAttribute("currentUser",request.getSession().getAttribute("currentUser"));
		return "rhip.ehr.integration.front_machine.search";
	}

}
