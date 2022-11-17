package com.founder.rhip.ehr.controller.person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.util.EHRUtil;
import com.founder.rhip.mdm.app.CheckException;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.app.IPersonApp;
import com.founder.rhip.mdm.entity.Organization;

@Controller
public class RegionlRecordController extends BaseController {
	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Resource
	private IPersonApp personApp;

	@Resource
	private IPersonInfoDao personInfoDao;

	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;

	/**
	 * 卫生局进入区域档案列表页面
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/regionRecord/index")
	public String search(HttpServletRequest request, ModelMap model) {
		model.addAttribute("search_Role", "wsj_Role");
		String includeTownCodes = "";
		//如果是区卫管中心，则只能查询本区的数据
		if(SecurityUtils.hasRole(RoleType.QWGZX,request)){
			includeTownCodes = getCurrentOrg(request).getGbCode();
		}
		model.addAttribute("includeTownCodes", includeTownCodes);
		return "rhip.ehr.regionRecord.list";
	}

	@RequestMapping("/regionRecord/export")
	public void exportPersonInfoList(HttpServletRequest request, HttpServletResponse response) {
		Criteria criteria = new Criteria();
		if(SecurityUtils.hasRole(RoleType.ZX_GLY, request)){
			if(!"".equals(request.getParameter("organCode"))){
				criteria = createSearchCriteria(request,request.getParameter("organCode"));
			}else{
				criteria = createSearchCriteria(request,SecurityUtils.getCurrentOrganization(request).getOrganCode());
			}
		}else {
			criteria = createSearchCriteria(request,null);
			if(hasRole(RoleType.QWGZX,request) && StringUtil.isNullOrEmpty((String) request.getParameter("searchTown")) && !criteria.get("filingFlag").equals("4")){
				String gBCode = getCurrentOrg(request).getGbCode();
				List<String> orgCodes = this.getOrgCodeByGBCode(gBCode);
				if(ObjectUtil.isNotEmpty(orgCodes)){
					criteria.add("inputOrganCode", OP.IN, orgCodes);
				}else {
					criteria.add("inputOrganCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
				}
			}
		}
		final Criteria criteriaFinal = criteria;

		final Order order = new Order("UPDATE_DATE", false);
		excelExportService.exportListExecl("人员列表", PersonInfo.class, response, new IDataSource() {
			@Override
			public List<Map<String, Object>> get(Page page) {
				return personalRecordService.exportPersonRecordList(page, criteriaFinal, order);
			}
		});
	}

	/**
	 * 社区中心进入区域档案列表页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/regionRecord/sqzx")
	public String searchSQZX(HttpServletRequest request, ModelMap model) {
		model.addAttribute("search_Role", "sqzx_Role");
		return "rhip.ehr.regionRecordSQZX.list";
	}

	/**
	 * 点击树---镇
	 */
	@RequestMapping("/regionRecord/Town/{gBCode}")
	public String searchOrgTreeByTown(@PathVariable("gBCode") String gbCode,HttpServletRequest request){
		List<String> orgCodes = this.getOrgCodeByGBCode(gbCode);

		if(!ObjectUtil.isNullOrEmpty(orgCodes)){
			Criteria criteria = new Criteria();
			criteria.add("inputOrganCode", OP.IN, orgCodes);
			searchResult(request,criteria);
		}
		return "rhip.ehr.regionRecord.result";
	}

	/**
	 * 查询列表
	 * @param request
	 */
	private void searchResult(HttpServletRequest request,Criteria criteria)
	{
		Order order = new Order("B.UPDATE_DATE", false);
		order.desc("B.ID");
		PageList<PersonInfo> personRecordList = personalRecordService.queryPersonRecordList(criteria, buildPage(request), order);
		if (ObjectUtil.isNotEmpty(personRecordList)) {
			// 设置头像标记，用于页面判断是否显示默认图片
			for (PersonInfo personInfo : personRecordList.getList()) {
				if (ObjectUtil.isNullOrEmpty(personInfo.getIdcard())) {
					continue;
				}
				Long id = personalRecordService.getPersonInfoAdditionalId(personInfo.getIdcard());
				if (ObjectUtil.isNotEmpty(id)) {
					personInfo.setPersonInfoAdditionalFlag(true);
				}
				
			}
			
		}
		request.setAttribute("personRecordList", personRecordList.getList());
	}

	/**
	 * 卫生局区域档案列表页面
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/regionRecord/result")
	public String result(HttpServletRequest request) {
		Criteria criteria = new Criteria();
		if(SecurityUtils.hasRole(RoleType.ZX_GLY, request)){
			if(!"".equals(request.getParameter("organCode"))){
				criteria = createSearchCriteria(request,request.getParameter("organCode"));
			}else{
				criteria = createSearchCriteria(request,SecurityUtils.getCurrentOrganization(request).getOrganCode());
			}
		}else {
			criteria = createSearchCriteria(request,null);
			if(hasRole(RoleType.QWGZX,request) && StringUtil.isNullOrEmpty((String) request.getParameter("searchTown")) && !criteria.get("filingFlag").equals("4")){
				String gBCode = getCurrentOrg(request).getGbCode();
				List<String> orgCodes = this.getOrgCodeByGBCode(gBCode);
				if(ObjectUtil.isNotEmpty(orgCodes)){
					criteria.add("inputOrganCode", OP.IN, orgCodes);
				}else {
					criteria.add("inputOrganCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
				}
			}
		}
		searchResult(request,criteria);
		return "rhip.ehr.regionRecord.result";
	}


	/**
	 * 点击树
	 * @param orgCode
	 * @param request
	 * @return
	 */
	@RequestMapping("/regionRecord/{orgCode}")
	public String searchById(@PathVariable("orgCode") String orgCode,HttpServletRequest request) {
		List<String> orgCodes = this.getOrgCodeByOrgCode(orgCode);
		if(!ObjectUtil.isNullOrEmpty(orgCodes)){
			Criteria criteria = new Criteria();
			if(1 == orgCodes.size()){
				criteria.add("inputOrganCode", orgCodes.get(0));
			}else {
				criteria.add("inputOrganCode", OP.IN, orgCodes);
			}
			searchResult(request,criteria);
		}
		return "rhip.ehr.regionRecord.result";
	}

	/**
	 * 社区中心区域档案列表页面
	 *
	 * @param request
	 * @return
	 * @throws Exception
	 * @throws CheckException
	 */
	@RequestMapping("/region/tongbuToMDM")
	public String tongbuToMDM(HttpServletRequest request){
		int j=1;
		for(int i=1;i<=254;i++)
		{
			Object[] obj = new Object[2];
			obj[0] = j;
			j += 5000;
			obj[1] = j;
			Criteria c = new Criteria();
			c.add("id",OP.BETWEEN,obj);
//			c.add("id",i);
			String[] str = {"id","name","idCard","healthFileNo","inputOrganName","gender","nation",
					"occupation","marriage","birthday","inputDate","education","phoneNumber","gBcode",
					"hrcity","hrtownShip","hrstreet","hrhouseNumber",
					"paprovince","pacity","pacounty","patownShip","pastreet","pahouseNumber","papostCode",
					"inputName","inputIdcard","inputDate","inputOrganCode","inputOrganName","smpiId","star"};
			List<PersonInfo> personInfoList = personInfoDao.getList(c, str);

			//批量注册
			List<Map<String,Object>> result = new ArrayList<Map<String,Object>>();
			if(personInfoList != null && personInfoList.size() > 0)
			{
				result = personApp.importPersons(EHRUtil.getPersonListFromPersonInfoList(personInfoList));
			}
			//批量更新
			List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
			for(Map<String,Object> map:result)
			{
				Map<String,Object> addMap = new HashMap<String, Object>();
				addMap.put("smpiId", map.get("pmpiId"));
				addMap.put("id", map.get("localId"));
				list.add(addMap);
			}
			personInfoDao.batchMapUpdate(list, "smpiId");
		}
		return "rhip.ehr.regionRecord.result";
	}

	/**
	 * 内部方法:创建查询条件对象
	 *
	 * @param request
	 * @return
	 */
	private Criteria createSearchCriteria(HttpServletRequest request,String typeCode) {
		Criteria criteria = new Criteria();
		String likeFlag = request.getParameter("likeFlag");
		// 姓名
		if (StringUtils.isNotEmpty(request.getParameter("personName")))
			if(StringUtils.isNotEmpty(likeFlag) && likeFlag.equalsIgnoreCase("like")){
				criteria.add("name", OP.LIKE, request.getParameter("personName"));
			}else{
				criteria.add("name", OP.EQ, request.getParameter("personName"));
			}
		// 建档时间
		Date createBeginDate = DateUtil.parseSimpleDate(request.getParameter("createBeginDate"), null);
		Date createEndDate = DateUtil.parseSimpleDate(request.getParameter("createEndDate"), null);
		DateUtil.getCriteriaByDateRange(criteria, "inputDate", createBeginDate, createEndDate);
		// 建档时间
		Date updateBeginDate = DateUtil.parseSimpleDate(request.getParameter("updateBeginDate"), null);
		Date updateEndDate = DateUtil.parseSimpleDate(request.getParameter("updateEndDate"), null);
		DateUtil.getCriteriaByDateRange(criteria, "updateDate", updateBeginDate, updateEndDate);
		// 建档机构
		if (StringUtils.isNotEmpty((String) request.getParameter("orgCode"))){
			String orgCode = (String) request.getParameter("orgCode");
			List<String> orgCodes = this.getOrgCodeByOrgCode(orgCode);
			if(1 == orgCodes.size()){
				criteria.add("inputOrganCode", orgCodes.get(0));
			}else {
				criteria.add("inputOrganCode", OP.IN, orgCodes);
			}
		}
		if (StringUtils.isNotEmpty((String) request.getParameter("gBCode"))){
			String gBCode = (String) request.getParameter("gBCode");
			List<String> orgCodes = this.getOrgCodeByGBCode(gBCode);
			criteria.add("inputOrganCode", OP.IN, orgCodes);
			criteria.remove("gBCode");
		}

		if(StringUtils.isNotEmpty((String) request.getParameter("townOrganCode"))) {
			String orgCode = (String) request.getParameter("townOrganCode");
			criteria.add("inputOrganCode", orgCode);
		}else if(typeCode != null) {
			List<String> orgCodes = this.getOrgCodeByOrgCode(typeCode);
			criteria.add("inputOrganCode", OP.IN, orgCodes);
		}

		if(StringUtils.isNotEmpty((String) request.getParameter("searchstation"))){
			String orgCode = (String) request.getParameter("searchstation");
			criteria.add("inputOrganCode", orgCode);
		}else if(StringUtils.isNotEmpty((String) request.getParameter("searchCenter"))){
			String orgCode = (String) request.getParameter("searchCenter");
			List<String> orgCodes = this.getOrgCodeByOrgCode(orgCode);
			orgCodes.add(orgCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				criteria.add("inputOrganCode", OP.IN, orgCodes);
			}else {
				criteria.add("inputOrganCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
			}
		}else if(StringUtils.isNotEmpty((String) request.getParameter("searchTown"))){
			String gBCode = (String) request.getParameter("searchTown");
			List<String> orgCodes = this.getOrgCodeByGBCode(gBCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				criteria.add("inputOrganCode", OP.IN, orgCodes);
			}else {
				criteria.add("inputOrganCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
			}
		}
		//居住地
		if (StringUtils.isNotEmpty((String) request.getParameter("inPutGBCode"))){
			String gBCode = (String) request.getParameter("gBCode");
			List<String> orgCodes = this.getOrgCodeByGBCode(gBCode);
			criteria.add("inputOrganCode", OP.IN, orgCodes);
		}
		// 户籍类型
		if (StringUtils.isNotEmpty(request.getParameter("householdType"))) {
			int householdType = Integer.parseInt(request.getParameter("householdType"));
			if (householdType != -1)
				criteria.add("householdType", request.getParameter("householdType"));
		}
		//常住类型
		if(StringUtil.isNotEmpty(request.getParameter("livingType"))){
			int livingType = Integer.parseInt(request.getParameter("livingType"));
			if(livingType !=-1){
				criteria.add("livingType", request.getParameter("livingType"));
			}
		}
		//健康档案编号
		if(StringUtil.isNotEmpty(request.getParameter("healthFileNo"))){
			criteria.add("healthFileNo", OP.LIKE,request.getParameter("healthFileNo"));
		}
		//户籍居委会
		if(StringUtil.isNotEmpty(request.getParameter("hrtownShip"))){
			criteria.add("hrtownShip",request.getParameter("hrtownShip"));
		}
		if(StringUtil.isNotEmpty(request.getParameter("hrstreet"))){
			criteria.add("hrstreet",request.getParameter("hrstreet"));
		}
		if(StringUtil.isNotEmpty(request.getParameter("hrGroup"))){
			criteria.add("hrGroup",request.getParameter("hrGroup"));
		}
		//现住址居委会
		if(StringUtil.isNotEmpty(request.getParameter("patownShip"))){
			criteria.add("patownShip",request.getParameter("patownShip"));
		}
		if(StringUtil.isNotEmpty(request.getParameter("pastreet"))){
			criteria.add("pastreet",request.getParameter("pastreet"));
		}
		// 年龄段
		int eYear = -1;
		int bYear = -1;

		if (StringUtils.isNotEmpty(request.getParameter("beginAge"))) {
			eYear = DateUtil.getBirthYearByAge(Integer.parseInt(request.getParameter("beginAge")));
		}
		if (StringUtils.isNotEmpty(request.getParameter("endAge"))) {
			bYear = DateUtil.getBirthYearByAge(Integer.parseInt(request.getParameter("endAge")));
		}
		DateUtil.getCriteriaByYearRange(criteria, "birthday", bYear, eYear);
		// 性别
		if (StringUtils.isNotEmpty(request.getParameter("genderCode"))) {
			int genderCode = Integer.parseInt(request.getParameter("genderCode"));
			if (genderCode != -1)
				criteria.add("gender", request.getParameter("genderCode"));
		}

		// 身份证
		if (StringUtils.isNotEmpty(request.getParameter("idCard")))
			criteria.add("idCard", request.getParameter("idCard"));

		// 档案类型
		if (StringUtils.isNotEmpty(request.getParameter("filingFlag"))) {
			String filingflag = request.getParameter("filingFlag");
			if("0".equals(filingflag)){
				criteria.remove("inputOrganCode");
			}
			criteria.add("filingFlag", filingflag);
		}

		//星级
		String  starType=request.getParameter("starType");
		if (StringUtils.isNotBlank(starType)&&!"-1".equals(starType)) {
			criteria.add("star",starType.trim());
		}

		//管理机构
		if (StringUtils.isNotEmpty(request.getParameter("inputOrgCode"))){
			List<String> orgCodes = this.getOrgCodeByGBCode(request.getParameter("inputOrgCode"));
			criteria.add("inputOrganCode", OP.IN, orgCodes);
		}
		// 动态档案
		if (StringUtils.isNotEmpty(request.getParameter("dynamicRecord"))) {
			int dynamicRecord = Integer.parseInt(request.getParameter("dynamicRecord"));
			if(dynamicRecord == 0){
				criteria.add("id", OP.NOTIN, " SELECT PERSON_ID FROM MODIFY_TRACE ");
			}else if(dynamicRecord == 1){
				criteria.add("id", OP.IN, "SELECT PERSON_ID FROM MODIFY_TRACE ");
			}
		}
		// 人群分类
		if (StringUtils.isNotEmpty(request.getParameter("groupClassification"))) {
			criteria.add("groupClassification", request.getParameter("groupClassification"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("poverty"))){
			int poverty = Integer.parseInt(request.getParameter("poverty"));
			if (poverty != -1)
				criteria.add("poverty", request.getParameter("poverty"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("disabled"))){
			int poverty = Integer.parseInt(request.getParameter("disabled"));
			if (poverty != -1)
				criteria.add("disabled", request.getParameter("disabled"));
		}if(StringUtils.isNotEmpty(request.getParameter("veryPoverty"))){
			int poverty = Integer.parseInt(request.getParameter("veryPoverty"));
			if (poverty != -1)
				criteria.add("veryPoverty", request.getParameter("veryPoverty"));
		}String povertyType=request.getParameter("povertyType");
		if (StringUtils.isNotBlank(povertyType)) {
			criteria.add("povertyType", povertyType);
		}
		String veryPovertyType=request.getParameter("veryPovertyType");
		if (StringUtils.isNotBlank(veryPovertyType)) {
			criteria.add("veryPovertyType", veryPovertyType);
		}

		//是否体检
		if(StringUtils.isNotEmpty(request.getParameter("isPhyExam"))){
			criteria.add("isPhyExam", request.getParameter("isPhyExam"));
		}
		if(StringUtils.isNotEmpty(request.getParameter("clinicYear"))){
			criteria.add("clinicYear", request.getParameter("clinicYear"));
		}
		// 是否签约 modify by yejianfei 2019/01/07
		String signFlag = request.getParameter("signFlag");
		if (StringUtil.isNotEmpty(signFlag)) {
			if("0".equals(signFlag)){
				//签约状态字典：FS10399，0：表示未签约
				Criteria signCri = new Criteria();
				signCri.add("signFlag",signFlag);
				signCri.add(LOP.OR,"signFlag",OP.IS,null);
				criteria.add(signCri);
			}else{
				criteria.add("signFlag", NumberUtil.convert(signFlag,Integer.class));
			}
		}
		//0152922: 【团风健康档案-区域档案/个人档案】添加查询条件，是否有医疗记录，查询字段bi_person_info中ehr_flag
		String ehrFlag=request.getParameter("ehrFlag");//是否有医疗记录
		String ylTypes=request.getParameter("ylTypes");//医疗记录类型
		if(EHRConstants.EHR_FLAG_0.equals(ehrFlag)){//没有医疗记录
			criteria.add("ehrFlag", ehrFlag);
		}
		else if(EHRConstants.EHR_FLAG_1.equals(ehrFlag)){//有医疗记录
			if (StringUtils.isNotEmpty(ylTypes)) {//有选医疗记录类型
				criteria.add("ehrFlag", ylTypes);
			}else{//未选医疗记录类型
				criteria.add("ehrFlag",OP.IN,new String[]{EHRConstants.EHR_FLAG_1,EHRConstants.EHR_FLAG_2});
			}

		}
		return criteria;
	}

	private Date getBirthDateCri(int age){
		Date birthDate = new Date();
		try{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date nowDate = new Date();
			String nowString = simpleDateFormat.format(nowDate);
			int year = Integer.parseInt(nowString.substring(0,4));
			int birthYear = year - age;
			String birthDateString = nowString.replaceAll(String.valueOf(year),String.valueOf(birthYear));
			birthDate = simpleDateFormat.parse(birthDateString);

		}catch (Exception e){
			e.printStackTrace();
		}
		return birthDate;
	}

	@Override
	protected Page buildPage(HttpServletRequest request) {
		String indexPage = request.getParameter("indexPage");
		int currentPage =1;
		if (null!=indexPage&&indexPage.trim().length()>0) {
			try {
				currentPage = Integer.valueOf(indexPage);
			} catch (NumberFormatException e) {

			}
		}
		Page page = super.getPage(request, currentPage);
		request.setAttribute("page", page);
		return page;
	}



	/**
	 * 根据GBCODE得到镇下面所有orgCode
	 * @param gbCode
	 * @return
	 */
	@Deprecated
	private List<String> getOrgCodeByGBCodeOld(String gbCode){
		List<String> orgCodesTowns = new ArrayList<String>();
		Criteria criteria = new Criteria("gbCode",gbCode);
		List<Organization> centers = organizationApp.queryOrganization(criteria); //镇下的中心
		if(ObjectUtil.isNotEmpty((centers))){
			List<String> centerCodes = new ArrayList<String>();
			for (Organization organization : centers) {
				centerCodes.add(organization.getOrganCode());
			}
			criteria = new Criteria();
			criteria.add(Organization.PARENT_CODE, OP.IN, centerCodes);
			List<Organization> organizationListThree = organizationApp.queryOrganization(criteria); //服务站
			if(!ObjectUtil.isNullOrEmpty(organizationListThree)){
				for (Organization organization : organizationListThree) {
					orgCodesTowns.add(organization.getOrganCode());
				}
			}
		}
		return orgCodesTowns;
	}


}
