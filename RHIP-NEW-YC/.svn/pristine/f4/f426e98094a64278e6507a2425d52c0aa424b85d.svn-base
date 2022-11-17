package com.founder.rhip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.controller.medicalservice.ExamController;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.dto.UrlPages;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.basic.UserOperationLog;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.ehr.service.basic.IUserOperationLogService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;

import net.sf.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: Andy
 * Date: 13-2-10
 * Time: 下午1:39
 * To change this template use File | Settings | File Templates.
 */
public class BaseController {
    protected static Logger logger = Logger.getLogger(ExamController.class);

    private static final String INDEX_PAGE_KEY = "pageIndex";// resquest中的当前页的key
    private static final String PAGE_KEY = "page";// page key

    @Resource(name = "userOperationLogService")
    private IUserOperationLogService userOperationLogService;

    @Resource(name = "uploadInfoRecordService")
	private IUploadInfoRecordService uploadInfoRecordService;
    
	@Autowired
    private IOrganizationApp organizationApp;
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // 忽略字段绑定异常
        // binder.setIgnoreInvalidFields(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN), true));
    }

    /**
     * 异常控制
     *
     * @return  return josn string
     */
//    @ExceptionHandler(RuntimeException.class)
//    public @ResponseBody Map<String,Object> runtimeExceptionHandler(RuntimeException runtimeException) {
//        logger.error(runtimeException.getLocalizedMessage());
//        Map model = new HashMap();
//        model.put("errorMsg",runtimeException.getLocalizedMessage());
//        model.put("statusFlg", false);
//        return model;
//    }

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

    /**
     * 翻页如果一次controller请求两部分（一部分详细，一部分列表，例如：直报的采样填写、随访填写）
     * @param request
     * @param indexPage
     * @param url
     * @return
     */
    protected Page getPage(HttpServletRequest request,Integer indexPage,String url) {
        Integer pageSize = EHRConstants.PAGE_SIZE;
        Object o = request.getSession().getAttribute("urlPages");

        if(url == null){
            url = request.getServletPath();
        }

        if(o != null){
            UrlPages urlPages  = (UrlPages)request.getSession().getAttribute("urlPages");
            pageSize = urlPages.getPageSize(url);
        }
        return new Page(pageSize,indexPage,url);
    }

    protected User getCurrentUser(HttpServletRequest request) {
        return SecurityUtils.getCurrentUser(request);
    }

    protected Organization getCurrentOrg(HttpServletRequest request) {
        return SecurityUtils.getCurrentOrganization(request);
    }

    protected List<Role> getCurrentUserRole(HttpServletRequest request) {
        return SecurityUtils.getUserRoles(request);
    }

    protected boolean hasRole(RoleType roleType, HttpServletRequest request) {
        return SecurityUtils.hasRole(roleType, request);
    }
    
    protected List<String> getCurrentUserRoles(HttpServletRequest request) {
    	List<Role> roleList = SecurityUtils.getUserRoles(request);
    	List<String> roles = new ArrayList<String>();
        if(ObjectUtil.isNotEmpty(roleList)){
            for (Role r : roleList) {
                roles.add(r.getRoleCode());
            }
        }
    	return roles;
    }

  /**
   * 判断当前登录用户所在机构的机构类型
   * @param role 机构类型（参照枚举类OrgGenreCode）
   * @param request
   * @return
   */
    protected boolean judgeCurrentOrgRole(String role,HttpServletRequest request){
      Organization organization =  getCurrentOrg(request);
      if(StringUtil.isNullOrEmpty(role)){
        return false;
      }else {
        if(role.equals(organization.getGenreCode())){
          return true;
        }else {
          return false;
        }
      }
    }
    
    /**
     * 设置Excel下载流的头信息
     * @param response
     * @param fileName
     */
    protected void setExcelContent(HttpServletResponse response, String fileName) {
    	String name = fileName;
		try {
			name = new String(fileName.getBytes("GBK"),"ISO8859_1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	response.reset();
    	response.setHeader("Content-Disposition", "attachment; filename=\"" + name + "\"");
    	response.setContentType("application/vnd.ms-excel"); 
    }
    
    /**
     * 取得模板文件的路径，支持空格等特殊字符
     * @param filePath
     * @return
     * @throws UnsupportedEncodingException
     */
    protected String getExcelPath(String filePath) throws UnsupportedEncodingException {
    	URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
    	return URLDecoder.decode(url.getPath(), "UTF-8");
    }
    
    /**
     * 获取当前操作者
     * @param user
     * @return
     */
    protected String getOperator(User user) {
    	return user.getName();
    }
    
    /**
     * 获取当前操作时间
     * @return
     */
    protected Long getOperateTime() {
    	SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(System.currentTimeMillis());
		return Long.parseLong(sf.format(date));
    }

    /**
     *记录用户操作
     * @param request
     * @param moduleName    登录模块名称
     * @param actionName    模块功能名称
     * @param operationName    具体操作
     */
    protected void createOperationLog(HttpServletRequest request, RhipModuleName moduleName,String actionName, OperationName operationName) {
        User user = this.getCurrentUser(request);
        if (user == null || moduleName == null || operationName == null) return;
        UserOperationLog userOperationLog = new UserOperationLog();
        Organization organization=this.getCurrentOrg(request);
        userOperationLog.setUserName(user.getUserName());
        userOperationLog.setUserIp(getRequestIp(request));
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
     * 记录用户使用系统中的重要操作
     */
    protected enum OperationName {
        ADD("新增"),
        UPDATE("更新"),
        DELETE("删除"),
        CHECK("审核"),
        CANCEL("取消审核"),
        MERGE("合并"),
        IMP("导入"),
        EXP("导出"),
        RESERVE_SUCCESS("预约成功"),
        RESERVE_REPEAT("预约相同医生"),
        RESERVE_OVER("预约同一天超过三次"),
        RESERVE_FULL("预约人数已满"),
        RESERVE_FAIL("预约失败");

        OperationName(String zhName) {
            this.zhName = zhName;
        }
        private String zhName;

        public String getZhName() {
            return zhName;
        }
    }
    
	protected void initOrg(HttpServletRequest request, Model model) {
		Organization org = getCurrentOrg(request);
		model.addAttribute("orgCode",org.getOrganCode());	
		model.addAttribute("currentBeginDate",DateUtil.firstDateOfMonth(new Date()));
		model.addAttribute("currentEndDate",new Date());
	}

	  /**
     * 分页设置
     *
     * @param request
     * @return
     */
    protected Page buildPage(HttpServletRequest request) {
        String indexPage = request.getParameter(INDEX_PAGE_KEY);
        int currentPage = 1;
        try {
            currentPage = Integer.valueOf(indexPage);
        } catch (Exception e) {
            logger.warn("没有当前页数");
        }
        Page page = getPage(request, currentPage);
        request.setAttribute(PAGE_KEY, page);
        return page;
    }

    /**
	 * 验证附件数量
	 * @param map
	 * @param fileMap
	 * @param resourceId
	 * @return
	 */
	protected Map<String, Object> validateAttchement(Map<String, Object> map, Map<String, String> fileMap, Long resourceId, boolean isMust) {
		if (map == null) {
			throw new IllegalArgumentException("map参数可以为空！");
		}
		int count = 0;
		/*if (resourceId == null) {
			if (isMust && ObjectUtil.isNullOrEmpty(fileMap)) {
				map.put("result", false);
				map.put("message", "请上传附件！");
				return map;
			}
			count = fileMap.size();
		} else {*/
			List<UploadInfoRecord> infoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", resourceId).add("FILE_RESOURCE", "lhpwdgl"));
			if (ObjectUtil.isNotEmpty(fileMap)) {
				count += fileMap.size();
			}
			if (ObjectUtil.isNotEmpty(infoRecords)) {
				count += infoRecords.size();
			}
		/*}*/
		if (count > 5) {
			map.put("result", false);
			map.put("message", "附件总数量不能大于5个！");
			return map;
		}
		return map;
	}

    /**
     * 获取分页信息
     * @param pageObject
     * @return
     */
    protected Page getPageInfo(JSONObject pageObject){
        int totalRows = 0;
        int pageSize = 0;
        int currentPage = 0;
        if(ObjectUtil.isNotEmpty(pageObject)){
            JSONObject userData = pageObject.getJSONObject("data");
            JSONObject pageInfoObject = userData.getJSONObject("page_info");
            if (ObjectUtil.isNotEmpty(pageInfoObject)){
                pageSize = pageInfoObject.getInt("size");
                currentPage = pageInfoObject.getInt("current_page");
                totalRows = pageInfoObject.getInt("total_num");
            }
        }
        Page page = new Page(pageSize,currentPage);
        page.setTotalRows(totalRows);
        return page;
    }

    /**
     * 获取机构映射
     * @param request
     * @return 手持设备方对应的机构编码
     */
    protected String getOrgMapping(HttpServletRequest request){
        Organization organization = getCurrentOrg(request);
        String orgCode = organization.getOrganCode();
        //卫计委机构不需要映射
        if("01008610-0".equals(orgCode)){
            return "";
        }
        Properties orgProperties =  PropertiesUtils.initProperties("orgcode-map");
        String orgCodeMap = orgProperties.getProperty(orgCode);
        if(StringUtil.isNullOrEmpty(orgCodeMap)){
            return orgCode;
        }
        return orgCodeMap;
    }

    @SuppressWarnings("unchecked")
    protected <T> T unmarshal(String xml, Class<?> clazz) {
        if (ObjectUtil.isNullOrEmpty(xml)) {
            return null;
        }
        try {
            InputStream is = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller um = context.createUnmarshaller();
            T t =  (T) um.unmarshal(is);
            return t;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    protected String marshal(Class<?> clazz, Object o) {
        String str = null;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller jaxbMarshaller = context.createMarshaller();
            // 格式化XML输出
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            jaxbMarshaller.marshal(o, bos);
            str = new String(bos.toByteArray(), "UTF-8");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return str;
    }
    
	 /**
     * 根据服务中心的orgCode得到下面所有orgCode
     * @param
     * @return
     */
     protected List<String> getOrgCodeByOrgCode(HttpServletRequest request){
         //卫管角色-机构
         String searchTown = request.getParameter("searchTown");
         String searchCenter = request.getParameter("searchCenter");
         String searchStation = request.getParameter("searchStation");
         return getOrgCodeByOrgCode(request,searchTown,searchCenter,searchStation);
     }

    protected List<String> getOrgCodeByOrgCode(String orgCode){
        List<String> orgCodes = new ArrayList<String>();
        Criteria criteria = new Criteria(Organization.PARENT_CODE,orgCode);
        List<Organization> organizationList = organizationApp.queryOrganization(criteria);
        orgCodes.add(orgCode);
        if(ObjectUtil.isNotEmpty(organizationList)){
            for (Organization organization : organizationList) {
                orgCodes.add(organization.getOrganCode());
            }
        }
        return orgCodes;
    }

    /**
     * 根据GBCODE得到镇下面所有orgCode
     * @param gbCode
     * @return
     */
    protected List<String> getOrgCodeByGBCode(String gbCode){
        Criteria criteria = new Criteria("gbCode",gbCode);
        List<Organization> stations = organizationApp.queryOrganization(criteria);
        List<String> stationsCodes = new ArrayList<>();
        if(ObjectUtil.isNotEmpty((stations))){
            for (Organization organization : stations) {
                stationsCodes.add(organization.getOrganCode());
            }
        }
        return stationsCodes;
    }

    protected List<String> getOrgCodeByOrgCode(HttpServletRequest request,String searchTown,String searchCenter,String searchStation){
        String orgCode = getCurrentOrg(request).getOrganCode();
        List<String> orgCodes = new ArrayList<String>();
        Criteria criteria = new Criteria();
        if(StringUtil.isNotEmpty(searchStation)){
            orgCodes.add(searchStation);
        }else{
            if(judgeCurrentOrgRole(OrgGenreCode.AREA_HEALTH.getValue(),request) || judgeCurrentOrgRole(OrgGenreCode.CITY_HEALTH.getValue(),request) || judgeCurrentOrgRole(OrgGenreCode.JK.getValue(),request) ){
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
                            criteria.add("GENRE_CODE",OrgGenreCode.INFIRMARY.getValue());
                            orgList = organizationService.getOrganizations(criteria);
                        } else{
                            //按区查询
                            criteria.add("gbCode", searchTown);
                            criteria.add("genreCode", OP.IN, new String[]{"B100", "B200"});
                            orgList = organizationApp.queryOrganization(criteria);
                            if (ObjectUtil.isNullOrEmpty(orgList)) {
                                //按管理中心查询
                                orgList = organizationService.getOrgansRecursion(searchTown);
                            }
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
                if(StringUtil.isNullOrEmpty(searchTown) && judgeCurrentOrgRole(OrgGenreCode.AREA_HEALTH.getValue(),request)){
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
            }else if(judgeCurrentOrgRole(OrgGenreCode.CENTRE.getValue(),request)){//中心情况
                criteria.add(Organization.PARENT_CODE,orgCode);
                List<Organization> organizationList = organizationApp.queryOrganization(criteria);
                orgCodes.add(orgCode);
                if(ObjectUtil.isNotEmpty(organizationList)){
                    for (Organization organization : organizationList) {
                        orgCodes.add(organization.getOrganCode());
                    }
                }
            }else if(judgeCurrentOrgRole(OrgGenreCode.STATION.getValue(),request)){//站情况
                orgCodes.add(orgCode);
            }
        }
        return orgCodes;
    }

    /**
     * 根据服务中心的orgCode得到下面所有orgCode
     * @param orgCode
     * @return
     */
    protected List<String> getOrgsByOrgCode(String orgCode){
        List<String> orgCodes = new ArrayList<String>();
        Criteria criteria = new Criteria(Organization.PARENT_CODE,orgCode);
        List<Organization> organizationList = organizationApp.queryOrganization(criteria);
        orgCodes.add(orgCode);
        if(ObjectUtil.isNotEmpty(organizationList)){
            for (Organization organization : organizationList) {
                orgCodes.add(organization.getOrganCode());
            }
        }
        return orgCodes;
    }

    //机构排序实现jquery treetable的数据排序需求
    protected List<Map<String, Object>> sortOrg(List<Map<String, Object>> ehrStatisticsMaps) {
        List<Map<String, Object>> resultMaps = new ArrayList<>();
        List<Map<String, Object>> firstMaps = new ArrayList<>();
        Map<String, Object> heJiMap = new HashMap<>();

        //先将疾控市级医院和中心找出
        for(Map<String, Object> ehrStatisticsMap : ehrStatisticsMaps) {
            if(ObjectUtil.equals(ehrStatisticsMap.get("genre_code"), OrgGenreCode.JK.getValue())
                    || ObjectUtil.equals(ehrStatisticsMap.get("genre_code"), OrgGenreCode.HOSPITAL.getValue())
                    || ObjectUtil.equals(ehrStatisticsMap.get("genre_code"), OrgGenreCode.CENTRE.getValue())) {
                firstMaps.add(ehrStatisticsMap);
            }
            if(ObjectUtil.equals(ehrStatisticsMap.get("parent_code").toString(), "合计")) {
                heJiMap = ehrStatisticsMap;
            }
        }

        //查询结果只有站时
        if(ObjectUtil.isNullOrEmpty(firstMaps)) {
            Map<String, Object> xiaoJiMap = new HashMap<>();
            List<Map<String, Object>> stationMaps = new ArrayList<>();
            for(Map<String, Object> ehrStatisticsMap : ehrStatisticsMaps) {
                if(!ObjectUtil.equals(ehrStatisticsMap.get("parent_code"), "合计")
                        && ObjectUtil.isNullOrEmpty(ehrStatisticsMap.get("organ_code"))) {
                    xiaoJiMap = ehrStatisticsMap;
                } else if(ObjectUtil.isNotEmpty(ehrStatisticsMap.get("organ_code"))) {
                    stationMaps.add(ehrStatisticsMap);
                }
            }
            resultMaps.add(xiaoJiMap);
            resultMaps.addAll(stationMaps);
            resultMaps.add(heJiMap);
            return resultMaps;
        }

        for(Map<String, Object> firstMap : firstMaps) {
            //先将疾控市级医院找出
            if(ObjectUtil.equals(firstMap.get("genre_code"), OrgGenreCode.JK.getValue())
                    || ObjectUtil.equals(firstMap.get("genre_code"), OrgGenreCode.HOSPITAL.getValue())) {
                resultMaps.add(firstMap);
            }
            //找出中心下属的站
            if(ObjectUtil.equals(firstMap.get("genre_code"), OrgGenreCode.CENTRE.getValue())) {
                Map<String, Object> xiaoJiMap = new HashMap<>();
                List<Map<String, Object>> stationMaps = new ArrayList<>();
                for(Map<String, Object> ehrStatisticsMap : ehrStatisticsMaps) {
                    if(ObjectUtil.equals(ehrStatisticsMap.get("parent_code"), firstMap.get("parent_code"))
                            && ObjectUtil.isNullOrEmpty(ehrStatisticsMap.get("organ_code"))) {
                        xiaoJiMap = ehrStatisticsMap;
                    } else if(ObjectUtil.equals(ehrStatisticsMap.get("parent_code"), firstMap.get("parent_code"))
                            && !ObjectUtil.equals(ehrStatisticsMap.get("organ_code"), firstMap.get("parent_code"))) {
                        stationMaps.add(ehrStatisticsMap);
                    }
                }
                resultMaps.add(xiaoJiMap);
                resultMaps.add(firstMap);
                resultMaps.addAll(stationMaps);
            }

        }
        resultMaps.add(heJiMap);
        return resultMaps;
    }

    /**
     * 获取所有中心
     * @return
     */
    protected List<String> getCenterOrgs(){
        List<Organization> centers = organizationApp.queryOrganization(new Criteria("genreCode", OP.IN, new String[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.INSTITUTES.getValue()}));
        List<String> centerCodes = new ArrayList<>();
        if(ObjectUtil.isNotEmpty((centers))){
            for (Organization organization : centers) {
                centerCodes.add(organization.getOrganCode());
            }
        }
        return centerCodes;
    }

    /**
     * 根据GBCODE得到镇下面所有orgCode
     * @param gbCode
     * @return
     */
    protected List<String> getOrgsByGBCode(String gbCode){
        Criteria criteria = new Criteria("gbCode",gbCode);
        List<Organization> stations = organizationApp.queryOrganization(criteria);
        List<String> stationsCodes = new ArrayList<>();
        if(ObjectUtil.isNotEmpty((stations))){
            for (Organization organization : stations) {
                stationsCodes.add(organization.getOrganCode());
            }
        }
        return stationsCodes;
    }
    
    
    /**
	 * 返回操作者姓名
	 */
	protected String getOperatorName() {
		//return "Admin";
		CurrentLoginInfo current = (CurrentLoginInfo)getSessionObj("currentLoginInfo");
		return current.getUser().getName();
	}
	
	protected Object getSessionObj(String key) {
		return RequestContextHolder.currentRequestAttributes().getAttribute(key, RequestAttributes.SCOPE_SESSION);
	}
}



