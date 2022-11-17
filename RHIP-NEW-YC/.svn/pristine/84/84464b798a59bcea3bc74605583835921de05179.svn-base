package com.founder.rhip.mdm.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.rhip.ehr.entity.basic.User;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import au.com.bytecode.opencsv.CSVReader;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.UrlPages;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;
import com.founder.rhip.ehr.service.basic.IUserOperationLogService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.CheckUtil;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IMDMConfigService;
import com.founder.rhip.mdm.service.IOrganizationService;

public class BaseController implements CheckUtil.ICheckDictionary {
	
	@Resource(name = "userOperationLogService")
    private IUserOperationLogService userOperationLogService;
	
	@Autowired
    private IOrganizationApp organizationApp;
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	
	public static final int PAGE_SIZE = 10;
	
	public static final String IMPORT_FILE_ENCODING = "GBK";
	
	public static final String EXPORT_FILE_ENCODING = "GBK";
	
	public static final String COMMON_DATE_PATTERN = "yyyy/MM/dd";
	
	protected Logger log = LoggerFactory.getLogger(getClass());
	
	@Resource
	private IMDMConfigService mdmConfigService;
	
	
    /**
     * 获取
     * @param request
     * @param indexPage
     * @return
     */
    protected Page getPage(HttpServletRequest request,Integer indexPage) {
    	Integer pageSize = EHRConstants.PAGE_SIZE;
    	Object o = request.getSession().getAttribute("urlPages");
    	String url = request.getServletPath();
    	
    	if(o != null){
        	UrlPages urlPages  = (UrlPages)request.getSession().getAttribute("urlPages");
        	pageSize = urlPages.getPageSize(url);
    	}
        return new Page(pageSize,indexPage,url);
    }
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(COMMON_DATE_PATTERN), true));
	}
	
	
    protected boolean hasRole(RoleType roleType, HttpServletRequest request) {
        return SecurityUtils.hasRole(roleType, request);
    }
    
    protected Organization getCurrentOrg(HttpServletRequest request) {
        return SecurityUtils.getCurrentOrganization(request);
    }

	protected User getCurrentUser(HttpServletRequest request) {
		return SecurityUtils.getCurrentUser(request);
	}
	
	protected Object getSessionObj(String key) {
		return RequestContextHolder.currentRequestAttributes().getAttribute(key, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	 * 返回操作者
	 */
	protected String getOperator() {
		//return "Admin";
		CurrentLoginInfo current = (CurrentLoginInfo)getSessionObj("currentLoginInfo");
		return current.getUser().getUserName();
	}
	
	protected Organization getCurrentOrg() {
		CurrentLoginInfo current = (CurrentLoginInfo)getSessionObj("currentLoginInfo");
		return current.getOrganization();
	}
	/**
	 * 返回操作时间
	 * @return
	 */
	protected Long getOperatorTime() {
		return CheckUtil.getOperatorTime();
	}
	
	/**
	 * 不为空检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void notNullCheck(List<String> messageList, Record record, EntityType entityType) {
		CheckUtil.getInstance(mdmConfigService).notNullCheck(messageList, record, entityType);
	}
	
	/**
	 * 字典数据检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void dictionaryCheck(List<String> messageList, Record record, EntityType entityType) {
		CheckUtil.getInstance(mdmConfigService).dictionaryCheck(messageList, record, entityType, this);
	}
	
	/**
	 * 正则表达式检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void regexCheck(List<String> messageList, Record record, EntityType entityType) {
		CheckUtil.getInstance(mdmConfigService).regexCheck(messageList, record, entityType);
	}
	
	/**
	 * 最大长度的检查
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void maxLengthCheck(List<String> messageList, Record record, EntityType entityType) {
		CheckUtil.getInstance(mdmConfigService).maxLengthCheck(messageList, record, entityType);
	}
	
	/**
	 * 检查所有规格
	 * @param messageList
	 * @param record
	 * @param entityType
	 */
	protected void checkAll(List<String> messageList, Record record, EntityType entityType) {
		notNullCheck(messageList, record, entityType);
		dictionaryCheck(messageList, record, entityType);
		regexCheck(messageList, record, entityType);
		maxLengthCheck(messageList, record, entityType);
	}
	
	/**
	 * 检查输入条件的合法性
	 * @param messageList
	 * @param criteria
	 * @param entityType
	 */
	protected void checkCriteria(List<String> messageList, Criteria criteria, EntityType entityType) {
		CheckUtil.getInstance(mdmConfigService).checkCriteria(messageList, criteria, entityType);
	}
	
	protected String getCheckErrorStr(List<String> errorMessageList) {
		return StringUtil.join(errorMessageList);
	}
	
	protected String getCheckErrorStr(CheckResult errors) {
		StringBuilder sb = new StringBuilder();
		int lineNo = 0;
		for (List<String> lineError : errors) {
			lineNo++;
			if (lineError == null || lineError.size() == 0) {
				continue;
			}
			sb.append(String.format("第%d行：%s\n", lineNo, StringUtil.join(lineError)));
		}
		return sb.toString();
	}
	
	protected void setCSVDownLoadResponse(HttpServletResponse response, String fileName) {
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        response.setContentType("text/csv");
	}
	
	protected void setCostomerJsonlDownLoadResponse(HttpServletResponse response) {
        response.reset();
        response.setContentType("text/html");
        response.setCharacterEncoding(JsonEncoding.UTF8.getJavaName());
	}
	
	protected void outputJsonData(HttpServletResponse response, Object value) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonGenerator generator = objectMapper.getJsonFactory().createJsonGenerator(response.getOutputStream(), JsonEncoding.UTF8);
		objectMapper.writeValue(generator, value);
	}
	/*
	protected String[] fieldLine;
	
	protected List<String> getFields() {
		List<String> ret = new ArrayList<>();
		for (String s : fieldLine) {
			if (s.equalsIgnoreCase("no")) {
				continue;
			}
			ret.add(s);
		}
		return ret;
	}
	*/
	protected List<Record> readCSVFile(InputStream in) throws Exception {
		List<Record> records = new ArrayList<Record>();
		CSVReader reader = new CSVReader(new InputStreamReader(in, IMPORT_FILE_ENCODING));
		try {
            // 读取字段信息
			String[] fieldLine = reader.readNext();
            // 读取字段描述
            reader.readNext();
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                Record record = new Record();
                for (int i = 0; i < fieldLine.length; i++) {
                	if (i >= nextLine.length) {
                		continue;
                	}
                    String fieldName = fieldLine[i];
                    String value = nextLine[i].trim();
                    if ("".equals(value) || fieldName.equalsIgnoreCase("no")) {
                        continue;
                    }
                    setValue(record, fieldName, value);
                    
                }
                records.add(record);
            }
		} finally {
			reader.close();
		}
		return records;
	}
	
	private void setValue(Record record, String fieldName, String value) throws ParseException {
		if (fieldName.contains("@")) {
			String[] vals = fieldName.split("@");
            SimpleDateFormat df = new SimpleDateFormat(vals[1]);
            Date date = df.parse(value);
            record.set(vals[0], date);
        } else {
        	record.set(fieldName, value);
        }
	}
	
	protected void downFile(String filePath, HttpServletResponse response) throws IOException {
		URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        InputStream in = new BufferedInputStream(url.openStream());
        OutputStream out = new BufferedOutputStream(response.getOutputStream());
        try {
            byte[] buffer = new byte[1024 * 8];
            int j = -1;
            while ((j = in.read(buffer)) != -1) {
                out.write(buffer, 0, j);
            }
        } finally {
            in.close();
            out.flush();
            out.close();
        }
	}
	
	protected void outputCSVData(HttpServletResponse response, ICSVDataTemplement dataTemplement) throws IOException {
		PrintWriter writer = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), EXPORT_FILE_ENCODING));
		writer.println(dataTemplement.getTitle());
		int size = dataTemplement.getCount();
		for (int i = 0; i < size; i++) {
			writer.println(dataTemplement.getLine(i));
			if (i%1000==0) {
				writer.flush();
			}
		}
		writer.flush();
		writer.close();
	}
	
	protected List<DicItem> getDictList(IDictionaryService dictionaryService, String dicCode, String parentCode) {
		Criteria criteria = new Criteria();
		criteria.add(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicItem.PARENT_CODE, parentCode);
		List<DicItem> items = dictionaryService.getDicItemsUseCache(criteria);
		return items;
	}
	
	protected String getDictName(IDictionaryService dictionaryService, String dicCode, String itemCode) {
		Criteria criteria = new Criteria();
		criteria.add(Dictionary.DIC_CODE, dicCode);
		criteria.add(DicItem.ITEM_CODE, itemCode);
		List<DicItem> items = dictionaryService.getDicItemsUseCache(criteria);
		if (items == null || items.size() < 1) {
			return "";
		}
		return items.get(0).getItemName();
	}
	
	protected String formatProperty(Object property) {
		if (property == null) {
			return "";
		}
		if (property instanceof Date) {
			SimpleDateFormat df = new SimpleDateFormat(COMMON_DATE_PATTERN);
			return df.format(property);
		}
		return property.toString();
	}
	
	protected void mergeValue(Object dbObject, Object obj) {
		ConvertingWrapDynaBean dbBean = new ConvertingWrapDynaBean(dbObject);
		ConvertingWrapDynaBean bean = new ConvertingWrapDynaBean(obj);
		Set<String> propertyNames = dbBean.getPropertyNames();
		for (String prop : propertyNames) {
			Object dbVal = dbBean.get(prop);
			Object val = bean.get(prop);
			if (val == null && dbVal != null) {
				bean.set(prop, dbVal);
			}
		}
	}

	public Map<String, String> getDictionary(String dictKey) {
		return null;
	}
	
	/**
     *记录用户操作
     * @param request
     * @param moduleName    登录模块名称
     * @param actionName    模块功能名称
     * @param operationName    具体操作
     */
    protected void createOperationLog(HttpServletRequest request, RhipModuleName moduleName,String actionName, OperationName operationName) {
        UserOperationLog userOperationLog = new UserOperationLog();
        Organization organization=this.getCurrentOrg();
        userOperationLog.setUserName(this.getOperator());
        userOperationLog.setUserIp(request.getRemoteHost());
        userOperationLog.setUserRequest(request.getRequestURI());
        userOperationLog.setModuleName(moduleName.getZhName());
        userOperationLog.setActionName(actionName);
        userOperationLog.setOperationName(operationName.getZhName());
        if (null!=organization) {
        	  userOperationLog.setOrgCode(organization.getOrganCode());
		}
        userOperationLog.setOperationTime(new Date());
        userOperationLogService.createOperationLog(userOperationLog);
    }

    /**
     * 记录用户使用系统中的重要操作
     */
    protected enum OperationName {
        ADD("新增"),
        UPDATE("更新"),
        DELETE("删除"),
        MERGE("合并");

        OperationName(String zhName) {
            this.zhName = zhName;
        }
        private String zhName;

        public String getZhName() {
            return zhName;
        }
    }
    
    public String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
    
	 /**
     * 根据orgCode得到下面所有orgCode
     * @param
     * @return
     */
    protected List<String> getOrgCodeByOrgCode(HttpServletRequest request, String searchTown, String searchCenter, String searchStation){
		//卫管角色-机构
		String orgCode = getCurrentOrg(request).getOrganCode();
		List<String> orgCodes = new ArrayList<String>();
		Criteria criteria = new Criteria();
		if(StringUtil.isNotEmpty(searchStation)){
			 orgCodes.add(searchStation);
		}else{
			if(hasRole(RoleType.QWGZX,request) || hasRole(RoleType.ADMIN,request)){
				if(StringUtil.isNotEmpty(searchCenter) && StringUtil.isNullOrEmpty(searchStation)){
					 criteria.add(Organization.PARENT_CODE,searchCenter);
		             List<Organization> organizationList = organizationApp.queryOrganization(criteria);
		             orgCodes.add(searchCenter);
		             if(ObjectUtil.isNotEmpty(organizationList)){
		                 for (Organization organization : organizationList) {
		                	 orgCodes.add(organization.getOrganCode());
		                 }
		             }
				}
				if(StringUtil.isNotEmpty(searchTown) && StringUtil.isNullOrEmpty(searchCenter)){
		            if(StringUtil.isNotEmpty(searchCenter) && StringUtil.isNullOrEmpty(searchStation)){
		                criteria.add(Organization.PARENT_CODE,searchCenter);
		                List<Organization> organizationList = organizationApp.queryOrganization(criteria);
		                orgCodes.add(searchCenter);
		                if(ObjectUtil.isNotEmpty(organizationList)){
		                    for (Organization organization : organizationList) {
		                    	orgCodes.add(organization.getOrganCode());
		                    }
		                }
		            }else if(StringUtil.isNotEmpty(searchStation)){
		                orgCodes.add(searchStation);
		            }else {
		            	List<Organization> orgList = null;
		            	if(StringUtils.endsWith(searchTown, "_hospital")) {
		            		criteria.add("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue());
		            		orgList = organizationService.getOrganizations(criteria); 
		            	} else if(StringUtils.endsWith(searchTown, "_other")) {
		    				criteria.add("GENRE_CODE", OP.IN, new String[]{OrgGenreCode.CITY_HEALTH.getValue(), OrgGenreCode.OTHER.getValue()});
		    				orgList = organizationService.getOrganizations(criteria);
		    			 } else if(searchTown.equals(EHRConstants._INFIRMARY)) {
		    				criteria.add("GENRE_CODE",OrgGenreCode.HEALTH_OVERSIGHT.getValue());
		    				orgList = organizationService.getOrganizations(criteria);
		    			 } else{
		    				orgList = organizationService.getOrgansRecursion(searchTown);
		    			 }
		            	
		                if (ObjectUtil.isNotEmpty(orgList)) {
		                    for (Organization organization : orgList) {
		                    	orgCodes.add(organization.getOrganCode());
		                    }
		                }else{
		                	orgCodes.add(searchTown);
		                }
		            }
				}
				if(StringUtil.isNullOrEmpty(searchTown) && hasRole(RoleType.QWGZX,request)){
					criteria.add("gbCode", getCurrentOrg(request).getGbCode());
					criteria.add("genreCode", OP.IN, new String[]{"B1", "B2"});
					List<Organization> organizationList = organizationApp.queryOrganization(criteria);
					if(ObjectUtil.isNotEmpty(organizationList)){
						for (Organization organization : organizationList) {
							orgCodes.add(organization.getOrganCode());
							orgCodes.add(organization.getGbCode());
						}
					}
				}
		    }else if(hasRole(RoleType.ZX_GLY,request)){
		        criteria.add(Organization.PARENT_CODE,orgCode);
		        List<Organization> organizationList = organizationApp.queryOrganization(criteria);
		        orgCodes.add(orgCode);
		        if(ObjectUtil.isNotEmpty(organizationList)){
		            for (Organization organization : organizationList) {
		                orgCodes.add(organization.getOrganCode());
		            }
		        }
			}
		}
        return orgCodes;
    }

}
