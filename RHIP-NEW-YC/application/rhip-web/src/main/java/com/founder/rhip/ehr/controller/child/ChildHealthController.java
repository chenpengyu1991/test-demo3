package com.founder.rhip.ehr.controller.child;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.entity.child.WomenChildHealthNew;
import com.founder.rhip.ehr.repository.child.IChildHealthExaminationDao;
import com.founder.rhip.ehr.repository.child.IWomenChildHealthDao;
import com.founder.rhip.ehr.service.child.IChildHealthExamineService;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ihm.controller.form.WChQueryForm;
import com.founder.rhip.ihm.service.IWchSearchService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/childHealth")
public class ChildHealthController extends BaseController {
	private static final String INDEX_PAGE_KEY = "pageIndex";// resquest中的当前页的key
    private static final String PAGE_KEY = "page";// page key
	@Autowired
    private IOrganizationApp organizationApp;
	
	@Resource(name = "wchSearchService")
	private IWchSearchService wchSearchService;
	@Resource(name = "excelExportService")
    private IExcelExportService excelExportService;
	@Resource(name = "childHealthExaminationDao")
	private IChildHealthExaminationDao childHealthExaminationDao;
	@Resource
	private IChildHealthExamineService childHealthExamineService;
	@Resource(name = "womenChildHealthDao")
	private IWomenChildHealthDao womenChildHealthDao;
	@RequestMapping("/search")
	public String neonatalVisit1(HttpServletRequest request, Model model) {
		initOrg(request, model);
		return "rhip.ehr.child.childHealth.search";
	}

	/**
	 * 新生儿随访信息
	 * @param request
	 * @param form
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String neonatalVisit(HttpServletRequest request, WChQueryForm form, Model model) {
		int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
		Page page = super.getPage(request, currentPage);
		Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setName(request.getParameter("name"));
		form.setGender(request.getParameter("gender"));
		form.setCreateDate(request.getParameter("createDate"));
		form.setCreateDateEnd(request.getParameter("createDateEnd"));
		form.setUpdateDate(request.getParameter("updateDate"));
		form.setUpdateDateEnd(request.getParameter("updateDateEnd"));
		form.setOrganCode(request.getParameter("orgCode"));
		form.setIdCard(request.getParameter("idCard"));
		form.setHealthGuideStatus(request.getParameter("healthGuideStatus"));
		form.setBirthday(request.getParameter("birthday"));
		form.setBirthdayEnd(request.getParameter("birthdayEnd"));
		
		PageList<WomenChildHealthNew> plist = wchSearchService.getChildHealthNewList(flg,orgCodes,form.getParamMap(), page);
		model.addAttribute("childList", plist.getList());
		model.addAttribute("page", plist.getPage());

		return "rhip.ehr.child.childHealth.list";
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
	 * 内部方法:创建查询条件对象
	 * 
	 * @param request
	 * @return
	 */
	/*private Criteria createSearchCriteria(HttpServletRequest request) {
		Criteria criteria = new Criteria();
		// 姓名
        String likeFlag = request.getParameter("likeFlag");
        if (StringUtils.isNotEmpty(request.getParameter("personName")))
            if(StringUtils.isNotEmpty(likeFlag) && likeFlag.equalsIgnoreCase("like")){
                criteria.add("name", OP.LIKE, request.getParameter("personName"));
            }else{
                criteria.add("name", OP.EQ, request.getParameter("personName"));
            }
        //居委会
		if(StringUtil.isNotEmpty(request.getParameter("hrstreet"))){
			List<DicItem> dicItemList = dictionaryApp.queryDicItem(new Criteria("itemName", OP.LIKE, request.getParameter("hrstreet")));
			int a = dicItemList.size();
			String[] dicArray = new String[dicItemList.size()];
			for(int i=0;i<dicItemList.size();i++){
				dicArray[i] =dicItemList.get(i).getItemCode();
			}
			criteria.add("hrstreet", OP.IN, dicArray);
		}
		// 建档时间
        if (StringUtils.isNotEmpty(request.getParameter("paAddress"))){
        	criteria.add("paAddress", OP.LIKE, request.getParameter("paAddress"));
        }
                 
		Date createBeginDate = DateUtil.parseSimpleDate(request.getParameter("createBeginDate"), null);
		Date createEndDate = DateUtil.parseSimpleDate(request.getParameter("createEndDate"), null);
		DateUtil.getCriteriaByDateRange(criteria, "inputDate", createBeginDate, createEndDate);
		// 更新时间
		Date updateBeginDate = DateUtil.parseSimpleDate(request.getParameter("updateBeginDate"), null);
		Date updateEndDate = DateUtil.parseSimpleDate(request.getParameter("updateEndDate"), null);
		DateUtil.getCriteriaByDateRange(criteria, "updateDate", updateBeginDate, updateEndDate);
		String orgCode = request.getParameter("orgCode");
		if(SecurityUtils.hasRole(RoleType.ZX_GLY, request)){
			if(ObjectUtil.isNotEmpty(orgCode)){
				criteria.add("inputOrganCode", orgCode);
			}else{
				List<String> orgCodes = this.getOrgCodeByOrgCode(SecurityUtils.getCurrentOrganization(request).getOrganCode());
				criteria.add("inputOrganCode", OP.IN, orgCodes);
			}
		} else {
			// 建档机构
			if (StringUtils.isNotEmpty(orgCode))
				criteria.add("inputOrganCode", orgCode);
		}

		// 常住类型
		if (StringUtils.isNotEmpty(request.getParameter("householdType"))) {
			int householdType = Integer.parseInt(request.getParameter("householdType"));
			if (householdType != -1)
				criteria.add("householdType", request.getParameter("householdType"));
		}
		// 年龄段
		int eYear = -1;
		int bYear = -1;
		if (StringUtils.isNotEmpty(request.getParameter("beginAge")))
			eYear = DateUtil.getBirthYearByAge(Integer.parseInt(request.getParameter("beginAge")));
		if (StringUtils.isNotEmpty(request.getParameter("endAge")))
			bYear = DateUtil.getBirthYearByAge(Integer.parseInt(request.getParameter("endAge")));
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
			if ("0".equals(filingflag)) {
				criteria.remove("inputOrganCode");
			}
			criteria.add("filingFlag", filingflag);
		}
		// 星级
		String starType = request.getParameter("starType");
		if (StringUtils.isNotBlank(starType) && !"-1".equals(starType)) {
			criteria.add("star", starType.trim());
		}
		String areaCode = request.getParameter("orgArea");
		if (StringUtils.isNotBlank(areaCode) && !"-1".equals(areaCode)) {
			criteria.add("pastreet", areaCode);
		}
		
		//建档医生
		String inputerId=request.getParameter("inputerId");
		if (StringUtils.isNotBlank(inputerId)) {
			criteria.add("inputerId", inputerId);
		}
		
		return criteria;
	}*/
	
	/**
	 * 获取角色
	 * 
	 * @param request
	 * @return
	 */
	public RoleType getRole(HttpServletRequest request) {
		RoleType role = null;
		if (hasRole(RoleType.DDCRBYY, request)) {
			role = RoleType.DDCRBYY;
		} else if (hasRole(RoleType.ZX_GLY, request)) {
			role = RoleType.ZX_GLY;
		} else if (hasRole(RoleType.JKMBK, request)) {
			role = RoleType.JKMBK;
		} else if (hasRole(RoleType.Z_GLY, request)) {
			role = RoleType.Z_GLY;
		} else if (hasRole(RoleType.ADMIN, request)) {
			role = RoleType.ADMIN;
		} else {
			Assert.notNull(role, "没有权限,请更换用户登录");
		}
		return role;
	}
    
    @RequestMapping("/export")
    public void exportPersonInfoList(final WChQueryForm form , HttpServletRequest request, HttpServletResponse response) {
		final Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		final List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setName(request.getParameter("name"));
		form.setGender(request.getParameter("gender"));
		form.setCreateDate(request.getParameter("createDate"));
		form.setCreateDateEnd(request.getParameter("createDateEnd"));
		form.setUpdateDate(request.getParameter("updateDate"));
		form.setUpdateDateEnd(request.getParameter("updateDateEnd"));
		form.setOrganCode(request.getParameter("orgCode"));
		form.setIdCard(request.getParameter("idCard"));
		form.setHealthGuideStatus(request.getParameter("healthGuideStatus"));
		form.setStartAge(request.getParameter("startAge"));
		form.setEndAge(request.getParameter("endAge"));
		
        excelExportService.exportListExecl("儿童人员列表", WomenChildHealthNew.class, response, new IDataSource() {
            @Override
            public List<Map<String, Object>> get(Page page) {
            	return  wchSearchService.exportPersonRecordList(page, flg, orgCodes, form.getParamMap(), 1);
            }
        });
    }

	@RequestMapping("/childHealthindex/{babycard}/{idcard}")
	public String index(@PathVariable("babycard") String babycard ,@PathVariable("idcard") String idcard ,HttpServletRequest request, Model model) {
		Criteria criteria = new Criteria();
		if(babycard.equals("babyCard")){
			criteria.add("ID_CARD",idcard);
		}else{
			criteria.add("BABY_CARD_NO",babycard);
		}

		WomenChildHealth womenChildHealth  = womenChildHealthDao.get(criteria);
		ChildHealthExamination childHealthExamList = childHealthExaminationDao.get(criteria);
		model.addAttribute("child",womenChildHealth);
		model.addAttribute("exam",childHealthExamList);
		return "rhip.ehr.child.childHealth.childRecordIndex";
	}

	@RequestMapping("/examList")
	public String examList(HttpServletRequest request, String examineAgeGroup,
						   String babyCardNo,String idCard, Model model) {
		Criteria criteria = new Criteria();
		if(examineAgeGroup.equals("1")){
			criteria = new Criteria("babyCardNo", babyCardNo)
					.add("examineAgeGroup", examineAgeGroup);
		}else {
			criteria = new Criteria("idCard", babyCardNo)
					.add("examineAgeGroup", examineAgeGroup);
		}

		setOrganCritera(criteria, getCurrentOrg(request).getOrganCode(), request);
		Criteria deleteCriteria = new Criteria("IS_DELETE", OP.NE, EHRConstants.DELETE_FLG_1);
		deleteCriteria.add(LOP.OR,"IS_DELETE", OP.IS,"NULL");
		criteria.add(deleteCriteria);
		Order order = new Order("VISIT_DATE", false);

		List<ChildHealthExamination> childHealthExamList = childHealthExamineService.getChildHealthExamList(criteria, order);
		model.addAttribute("examList", childHealthExamList);
		if (ObjectUtil.isNotEmpty(childHealthExamList)) {
			model.addAttribute("exam", childHealthExamList.get(0));
		}
		model.addAttribute("examineAgeGroup",examineAgeGroup);
		return "rhip.ehr.childHealth.examList";
	}

	private Criteria setOrganCritera(Criteria criteria, String organCode, HttpServletRequest request) {
		String searchCenter = request.getParameter("searchCenter");
		String searchStation = request.getParameter("searchStation");
		if (SecurityUtils.hasRole(RoleType.ZX_GLY, request)) {
			//社区中心
			criteria.add(new Criteria("createOrganCode", organCode).add(LOP.OR, "createSuperOrganCode", organCode));
		} else if (SecurityUtils.hasRole(RoleType.QWGZX, request)) {
			//卫管中心
			Criteria criOrg = new Criteria();
			criteria.add("createGbCode", getCurrentOrg(request).getGbCode());
			if(StringUtil.isNotEmpty(searchCenter) && StringUtil.isNullOrEmpty(searchStation)){
				criOrg.add(Organization.PARENT_CODE,searchCenter);
				List<Organization> organizationList = organizationApp.queryOrganization(criOrg);
				String[] orgCodes = new String[organizationList.size()+1];
				for(int i=0;i<organizationList.size();i++){
					orgCodes[i] = organizationList.get(i).getOrganCode();
				}
				orgCodes[organizationList.size()] = searchCenter;
				criteria.add("createOrganCode", OP.IN,orgCodes);
			}
			if(StringUtil.isNotEmpty(searchStation)){
				criteria.add("createOrganCode",searchStation);
			}
            /*organizationApp.queryOrganization(criteria);*/
		} else if (SecurityUtils.hasRole(RoleType.Z_GLY, request)) {
			//社区服务站
			criteria.add("createOrganCode", organCode);
		}
		return criteria;
	}
}
