/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mdm.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.ehr.service.IOrgVillageRelationService;
import com.founder.rhip.mdm.entity.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.AreaType;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.service.IDepartmentService;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IOrganizationService;

/**
 * 机构维护
 */
@Controller
@RequestMapping("/mdmOrganization")
public class MDMOrganizationController extends BaseController {

	private static int ORG_AREA_HISTORY = 1;

	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;

	@Resource(name = "mdmDictionaryService")
	private IDictionaryService dictionaryService;

	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "mdmDepartmentService")
	private IDepartmentService departmentService;

	@Resource(name = "orgVillageRelationService")
	private IOrgVillageRelationService orgVillageRelationService;

	@Autowired
	private IOrganizationApp organizationApp;
	
	@RequestMapping("/manager")
	public String manager(ModelMap model) {
		return search(model);
	}

	@RequestMapping("/showImport")
	public String showImport(ModelMap model) {
		return "com.founder.mdm.smpi.organizationManager";
	}

	/**
	 * 进入查询界面
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String search(ModelMap model) {
		model.addAttribute("criOrganization", new Organization());
		return "com.founder.mdm.smpi.organizationSearch";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap model, Organization criOrganization, int indexPage) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = initCriteria(criOrganization);
		//CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(this.hasRole(RoleType.ZX_GLY, request)) {
			String orgCode = this.getCurrentOrg().getOrganCode();
			Criteria temp = new Criteria(Organization.ORGAN_CODE , orgCode);
			temp.add(LOP.OR, new Criteria(Organization.PARENT_CODE, orgCode));
			criteria.add(temp);
		} else if(this.hasRole(RoleType.YYZH, request)) {
			criteria.add(Organization.ORGAN_CODE , this.getCurrentOrg().getOrganCode());
		}
		PageList<Organization> pageList = organizationService.getOrganizationsNoVirtual(page, criteria);
		model.addAttribute("organList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "com.founder.mdm.smpi.organizationList";
	}

	@RequestMapping("/view")
	public String view(ModelMap model, Long organId, String operateTime) {
		Organization organization = null;
		if (StringUtil.isNullOrEmpty(operateTime)) {
			organization = organizationService.getOrganization(organId);
		} else {
			Criteria criteria = new Criteria(Organization.ORGAN_ID, organId);
			criteria.add(Organization.OPERATE_TIME, operateTime);
			organization = organizationService.getOrganizationHistory(criteria);
			if (organization == null) {
				organization = organizationService.getOrganization(criteria);
			}
		}
		model.addAttribute("organization", organization);
		model.addAttribute("organCodeForSr", organization.getOrganCode());
		
		return "com.founder.mdm.smpi.organizationInfo";
	}

	@RequestMapping("edit")
	public String edit(ModelMap model, Long organId) {
		Organization organization = organizationService.getOrganization(organId);
		List<OrganizationArea> organizationAreas = organizationService.getOrganizationAreas(new Criteria("oa.organization_code", organization.getOrganCode()));
		model.addAttribute("organization", organization);
		model.addAttribute("organizationAreas", organizationAreas);
        model.addAttribute("organizationEdit", "edit");
        this.getOrgVillages(organization.getOrganCode(), organization.getGbCode(), organization.getParentCode(), model);
		return "com.founder.mdm.smpi.organizationInfoEdit";
	}

	@RequestMapping("/add")
	public String add(ModelMap model) {
		int maxSort = organizationService.getMaxSort(new Criteria());
		Organization organization = new Organization();
		if(ObjectUtil.isNotEmpty(maxSort)) {
			organization.setSort(maxSort+1);
		} else {
			organization.setSort(1);
		}
		model.addAttribute("organization", organization);
        model.addAttribute("organizationEdit", "add");
        return "com.founder.mdm.smpi.organizationInfoEdit";
	}

	@RequestMapping("/viewTree")
	public String viewTree(ModelMap model) {
		return "com.founder.mdm.smpi.parentOrganizationTree";
	}

	/**
	 * 搜索树
	 *
	 * @param model
	 * @param orgName
	 * @return
	 */
	@RequestMapping("/treeParent")
	public String treeParent(ModelMap model, String orgName) {
		List<Organization> centres = organizationService.getOrganizations(new Criteria("GENRE_CODE", OrgGenreCode.CENTRE.getValue()));//获取中心医院
		List<String> lstTree = new ArrayList<String>();
		List<DicItem> towns = dictionaryApp.queryDicItems("FS990001", EHRConstants.FS990001_ROOT);
		for (DicItem town : towns) {
			lstTree.add("{\"id\":\"" + town.getItemCode() + "\", \"pId\":\"0\", \"name\":\"" + town.getItemName() + "\" }");
		}

		for (Organization org : centres) {
			lstTree.add("{\"id\":\"" + org.getOrganCode() + "\", \"pId\":\"" + org.getGbCode() + "\", \"name\":\"" + org.getOrganName() + "\" }");
		}
		return EHRMessageUtil.returnMsg(model, lstTree);
	}

	@RequestMapping("/remove")
	@ResponseBody
	public ModelMap remove(Long organId) {
		ModelMap model = new ModelMap();
		try {
			organizationService.deleteOrganization(organId);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("删除机构出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}

	@RequestMapping("/changeStatus")
	@ResponseBody
	public ModelMap changeStatus(Long organId, int oldStatus) {
		ModelMap model = new ModelMap();
		try {
			Organization organization = new Organization();
			organization.setOrganId(organId);
			organization.setEndDate(new Date());
			organization.setOperator(getOperator());
			organization.setOperateTime(getOperatorTime());
			organization.setOperateType(OperateType.update.getName());
			if (oldStatus == StatusValue.normalValue.getValue()) {
				organization.setStatus(StatusValue.deleteValue.getValue());
			} else {
				organization.setStatus(StatusValue.normalValue.getValue());
			}
			organizationService.changeStatus(organization);
			model.addAttribute("result", true);
		} catch (Exception e) {
			log.error("修改机构状态出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}

	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(Organization organization, String type, HttpServletRequest request) {
		//使用园区版本机构保存代码
		ModelMap model = this.validateOrg(organization, type);
		organization.setOperator(getOperator());
		organization.setOperateTime(getOperatorTime());
		Organization dbOrgan = organizationService.getOrganization(organization.getOrganCode());
		List<OrganizationArea> orgAreas = this.getOrgArea(organization.getOrganCode(), organization.getAreaCode(), organization.getGenreCode());
		try {
			if ("add".equalsIgnoreCase(type)) {
				organization.setOperateType(OperateType.create.getName());
				organization.setOperateDetail("");
				organizationService.createOrganization(organization, orgAreas);

				model.addAttribute("result", true);
				model.addAttribute("message", "添加成功");
				createOperationLog(request, RhipModuleName.MDM, "医疗机构-机构添加", OperationName.ADD);
			} else if ("edit".equalsIgnoreCase(type)) {
				organization.setOperateType(OperateType.update.getName());
				organization.setOperateDetail("");
				organization.setOrganId(dbOrgan.getOrganId());
				organizationService.updateOrganization(organization, orgAreas, updateProperties);
				model.addAttribute("result", true);
				model.addAttribute("message", "修改成功");
				createOperationLog(request, RhipModuleName.MDM, "医疗机构-机构更新", OperationName.UPDATE);
			}
		} catch (Exception e) {
			log.error("保存机构出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", "保存机构出错");
		}
		return model;
	}

	/**
	 * 保存机构时进行验证
	 *
	 * @param organization
	 * @param type
	 * @return
	 */
	private ModelMap validateOrg(Organization organization, String type) {
		ModelMap model = new ModelMap();
		//检查合法性
		Record record = new Record(organization);
		List<String> chkMessageList = new ArrayList<String>();
		checkAll(chkMessageList, record, EntityType.ORGANIZATION);

		String parentCode = organization.getParentCode();
		if (StringUtil.isNullOrEmpty(parentCode)) {
			parentCode = Organization.DEFAULT_PARENT_CODE_VALUE;
			record.set(Organization.PARENT_CODE, parentCode);
		} else {
			Criteria criteria = new Criteria(Organization.ORGAN_CODE, parentCode);
			Organization parent = organizationService.getOrganization(criteria);
			if (parent == null) {
				chkMessageList.add("上级机构编码不存在");
			}
		}
		String gbCode = organization.getGbCode();
		if (!Organization.DEFAULT_PARENT_CODE_VALUE.equals(parentCode)
				&& StringUtil.isNotEmpty(gbCode)) {
			chkMessageList.add("上级机构和所在乡镇只能选择一个");
		}

		if (chkMessageList.size() > 0) {
			model.addAttribute("result", false);
			model.addAttribute("message", getCheckErrorStr(chkMessageList));
			return model;
		}

		String organCode = organization.getOrganCode();
		Organization dbOrgan = organizationService.getOrganization(organCode);
		if (dbOrgan == null) {
			if ("edit".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "需要更新的机构不存在");
				return model;
			}
		} else {
			if ("add".equalsIgnoreCase(type)) {
				model.addAttribute("result", false);
				model.addAttribute("message", "相同编码的机构已经存在");
				return model;
			}
		}
		return model;
	}

	private String[] updateProperties = new String[]{"organCode", "parentCode", "organName", "genreCode", "gradeCode", 
			"manageCode", "nationalOrganCode", "economyCode", "registCapital", "startDate", "artificialPerson", 
			"artificialIdcard", "artificialTel", "tel", "postCode", "address", "gbCode", "bedCount", 
			"dentalChairCount", "mail", "mnumber", "fnumber", "operator", "operateType", "operateTime",
			"equipmentNum","openBedCount","equipmentNumOne","equipmentNumTwo","area","businessArea","dilapidatedRatio",
			"constructionArea","completionArea","sort","parentCodeHealth"};

	@RequestMapping("/toShowLogs")
	public String toShowLogs(HttpServletRequest request, ModelMap model, Long organId) {
		model.addAttribute("organId", organId);
		return "com.founder.mdm.smpi.organization.log";
	}
	
	
	@RequestMapping("/showLogs")
	public String showLogs(HttpServletRequest request, ModelMap model, Long organId, int indexPage) {
		Page page = super.getPage(request, indexPage);
		PageList<Organization> pageList = organizationService.getUpdateHistory(page, organId);
		model.addAttribute("logList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("organId", organId);
		return "com.founder.mdm.smpi.organizationLogList";
	}

	@RequestMapping("/downLoadCurrent")
	@ResponseBody
	public void downLoadCurrent(HttpServletResponse response) throws IOException {
		String fileName = "organization.csv";
		setCSVDownLoadResponse(response, fileName);
		Criteria criteria = new Criteria();
		criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		final List<Organization> organizations = organizationService.getOrganizations(criteria);
		outputCSVData(response, new ICSVDataTemplement() {

			@Override
			public String getTitle() {
				return "机构编码,上级机构编码,机构名称,机构类别,机构级别,经营性质,经济类型,注册资金(万元),成立日期,撤销日期,法人代表,法人证件号,法人电话,机构电话,邮政编码,机构地址,所在乡镇,床位数,牙椅数,电子邮箱,男职工数,女职工数";
			}

			@Override
			public int getCount() {
				return organizations.size();
			}

			@Override
			public String getLine(int lineNo) {
				Organization organization = organizations.get(lineNo);
				StringBuilder sb = new StringBuilder();
				sb.append(formatProperty(organization.getOrganCode()));
				sb.append(",");
				sb.append(formatProperty(organization.getParentCode()));
				sb.append(",");
				sb.append(formatProperty(organization.getOrganName()));
				sb.append(",");
				sb.append(formatProperty(getDictName(dictionaryService, "GBT2182002", organization.getGenreCode())));
				sb.append(",");
				sb.append(formatProperty(getDictName(dictionaryService, "DM02-02", organization.getGradeCode())));
				sb.append(",");
				sb.append(formatProperty(getDictName(dictionaryService, "FS10223", organization.getManageCode())));
				sb.append(",");
				sb.append(formatProperty(getDictName(dictionaryService, "GBT124022000", organization.getEconomyCode())));
				sb.append(",");
				sb.append(formatProperty(organization.getRegistCapital()));
				sb.append(",");
				sb.append(formatProperty(organization.getStartDate()));
				sb.append(",");
				sb.append(formatProperty(organization.getEndDate()));
				sb.append(",");
				sb.append(formatProperty(organization.getArtificialPerson()));
				sb.append(",");
				sb.append(formatProperty(organization.getArtificialIdcard()));
				sb.append(",");
				sb.append(formatProperty(organization.getArtificialTel()));
				sb.append(",");
				sb.append(formatProperty(organization.getTel()));
				sb.append(",");
				sb.append(formatProperty(organization.getPostCode()));
				sb.append(",");
				sb.append(formatProperty(organization.getAddress()));
				sb.append(",");
				sb.append(formatProperty(getDictName(dictionaryService, "FS990001", organization.getGbCode())));
				sb.append(",");
				sb.append(formatProperty(organization.getBedCount()));
				sb.append(",");
				sb.append(formatProperty(organization.getDentalChairCount()));
				sb.append(",");
				sb.append(formatProperty(organization.getMail()));
				sb.append(",");
				sb.append(formatProperty(organization.getMnumber()));
				sb.append(",");
				sb.append(formatProperty(organization.getFnumber()));
				sb.append(",");
				return sb.toString();
			}

		});
	}
	
	@RequestMapping("/downTemplate")
	@ResponseBody
	public void downTemplate(HttpServletResponse response) throws IOException {
		String fileName = "organization.csv";
		setCSVDownLoadResponse(response, fileName);
		downFile("../views/mdm/template/organization.csv", response);
	}

	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletResponse response) throws IOException {
		ModelMap model = new ModelMap();
		try {
			InputStream in = file.getInputStream();
			List<Record> organizationList = readCSVFile(in);
			if (organizationList == null || organizationList.size() == 0) {
				model.addAttribute("result", false);
				model.addAttribute("message", "导入文件为空");
				ObjectMapper mapper = new ObjectMapper();   
				String content = mapper.writeValueAsString(model);     
				return content;
			}

			CheckResult results = new CheckResult();
			for (Record record : organizationList) {
				List<String> chkMessageList = new ArrayList<String>();
				record.set(Organization.OPERATOR, getOperator());
				record.set(Organization.OPERATE_TYPE, OperateType.batchImport.getName());
				record.set(Organization.OPERATE_TIME, getOperatorTime());
				record.set(Organization.STATUS, StatusValue.normalValue.getValue());

				checkAll(chkMessageList, record, EntityType.ORGANIZATION);

				String parentCode = record.getAsString(Organization.PARENT_CODE);
				if (StringUtil.isNullOrEmpty(parentCode)) {
					parentCode = Organization.DEFAULT_PARENT_CODE_VALUE;
					record.set(Organization.PARENT_CODE, parentCode);
				} else {
					Criteria criteria = new Criteria(Organization.ORGAN_CODE, parentCode);
					Organization parent = organizationService.getOrganization(criteria);
					if (parent == null) {
						chkMessageList.add("上级机构编码不存在");
					}
				}
				String gbCode = record.getAsString("dbCode");
				if (!Organization.DEFAULT_PARENT_CODE_VALUE.equals(parentCode)
						&& StringUtil.isNotEmpty(gbCode)) {
					chkMessageList.add("上级机构和所在乡镇只能选择一个");
				}
				results.add(chkMessageList);
			}

			if (results.hasError()) {
				model.addAttribute("result", false);
				model.addAttribute("message", getCheckErrorStr(results));
				organizationList.clear();
				organizationList = null;
				ObjectMapper mapper = new ObjectMapper();   
				String content = mapper.writeValueAsString(model);     
				return content;
			}

			int count = organizationService.importOrganizations(organizationList, updateProperties);
			model.addAttribute("message", "总共导入" + organizationList.size() + "条机构，成功" + count + "条，失败" + (organizationList.size() - count) + "条");
			model.addAttribute("result", true);
			organizationList.clear();
			organizationList = null;
		} catch (ParseException e) {
			log.error("导入机构出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", "导入文件中日期数据不合法：" + e.getMessage());
		} catch (Exception e) {
			log.error("导入机构出错", e);
			model.addAttribute("result", false);
			model.addAttribute("message", e.getMessage());
		}
		//outputJsonData(response, model);
		ObjectMapper mapper = new ObjectMapper();   
		String content = mapper.writeValueAsString(model);     
		return content;
	}

	public Map<String, String> getDictionary(String dictKey) {
		Criteria criteria = new Criteria(Dictionary.DIC_CODE, dictKey);
		Map<String, String> dictMap = dictionaryService.getDicItemMapUseCache(criteria);
		return dictMap;
	}

	private Criteria initCriteria(Organization organization) {
		Criteria criteria = new Criteria();
		String organCode = organization.getOrganCode();
		if (StringUtil.isNotEmpty(organCode)) {
			criteria.add(Organization.ORGAN_CODE, OP.LIKE, organCode);
		}
		String organName = organization.getOrganName();
		if (StringUtil.isNotEmpty(organName)) {
			criteria.add("organName", OP.LIKE, organName);
		}
		String manageCode = organization.getManageCode();
		if (StringUtil.isNotEmpty(manageCode)) {
			criteria.add("manageCode", manageCode);
		}
		String genreCode = organization.getGenreCode();
		if (StringUtil.isNotEmpty(genreCode)) {
			criteria.add("genreCode", genreCode);
		}
		String gbCode = organization.getGbCode();
		if (StringUtil.isNotEmpty(gbCode)) {
			criteria.add("gbCode", gbCode);
		}
		String gradeCode = organization.getGradeCode();
		if (StringUtil.isNotEmpty(gradeCode)) {
			criteria.add("gradeCode", gradeCode);
		}
		String parentCode = organization.getParentCode();
		if (StringUtil.isNotEmpty(parentCode)) {
			criteria.add("parentCode", parentCode);
		}
		return criteria;
	}

	@RequestMapping("/filterParentOrg")
	public String filterParentOrg(ModelMap model, String orgName) {
		Criteria criteria = new Criteria("gbCode", OP.UEMPTY, "");
		criteria.add(LOP.OR, "parentCode", OP.GT, "0");
		criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		if (StringUtil.isNotEmpty(orgName)) {
			criteria.add(LOP.AND, "organName", OP.LIKE, orgName);
		}
		List<Organization> organizations = organizationService.getOrganizationsUseCache(criteria);
		List<Organization> organizationTreeData = initTreeData(organizations);
		model.addAttribute("treeData", organizationTreeData);
		return "com.founder.mdm.common.organTreeView2";
	}

	private List<Organization> initTreeData(List<Organization> organizations) {
		List<Organization> roots = new ArrayList<>();
		Map<String, Organization> rootMap = new HashMap<>();
		Map<String, Organization> parentMap = new HashMap<>();
		for (Organization organ : organizations) {
			String gbCode = organ.getGbCode();
			if (StringUtil.isNotEmpty(gbCode) && !("_999".equals(gbCode))) {
				Organization root = rootMap.get(gbCode);
				if (root == null) {
					root = new Organization();
					root.setOrganCode(gbCode);
					root.setOrganName(getDictName(dictionaryService, "FS990001", gbCode));
					rootMap.put(gbCode, root);
					roots.add(root);
				}
				root.addChild(organ);
				parentMap.put(organ.getOrganCode(), organ);
			}
		}
		for (Organization organ : organizations) {
			String parentCode = organ.getParentCode();
			if (StringUtil.isNotEmpty(parentCode)) {
				Organization parent = parentMap.get(parentCode);
				if (parent != null) {
					parent.addChild(organ);
				}
			}
		}
		return roots;
	}

	@RequestMapping("/area/init")
	public String init(ModelMap model) {
		int currentYear = DateUtil.getCurrentYear();
		model.addAttribute("currentYear", currentYear);
		model.addAttribute("years", new Integer[]{currentYear,currentYear-1,currentYear-2});
		return "com.founder.mdm.organization.area.index";
	}

	@RequestMapping("/area/tabIndex")
	public String index(ModelMap model,Integer selectYear) {
		int currentYear = DateUtil.getCurrentYear();
		model.addAttribute("selectYear", selectYear);
		model.addAttribute("currentYear", currentYear);
		return "com.founder.mdm.organization.area.init";
	}

	@RequestMapping("/area/centres")
	public String getCentres(ModelMap model) {
		Criteria criStatus = new Criteria(Organization.STATUS, StatusValue.normalValue.getValue());
		List<Organization> centres = organizationService.getOrganizations(new Criteria("GENRE_CODE", OrgGenreCode.CENTRE.getValue()).add(criStatus));//获取中心医院
		List<Organization> stations = organizationService.getOrganizations(new Criteria("GENRE_CODE", OrgGenreCode.STATION.getValue()).add(criStatus).add(Organization.ORGAN_CODE,OP.NE, "320000000"));//获取卫生服站
		List<String> lstTree = new ArrayList<String>();
		List<DicItem> towns = dictionaryApp.queryDicItems("FS990001", EHRConstants.FS990001_ROOT);
		lstTree.add("{\"id\":\"1\", \"pId\":\"0\", \"name\":\"永城市\" , open:true, chkDisabled:true}");
		for (DicItem town : towns) {
			lstTree.add("{\"id\":\"" + town.getItemCode() + "\", \"genreCode\":\"" + ""  + "\", \"pId\":\"1\", \"name\":\"" + town.getItemName() + "\" , chkDisabled:true}");
		}

		for (Organization org : centres) {
			lstTree.add("{\"id\":\"" + org.getOrganCode() + "\", \"orgId\":\"" + org.getOrganId() + "\", \"genreCode\":\"" + org.getGenreCode() + "\", \"pId\":\"" + org.getGbCode() + "\", \"name\":\"" + org.getOrganName() + "\" }");
		}
		for (Organization station : stations) {
			lstTree.add("{\"id\":\"" + station.getOrganCode()   + "\", \"orgId\":\"" + station.getOrganId() + "\", \"genreCode\":\"" + station.getGenreCode() + "\", \"pId\":\"" + station.getParentCode() + "\", \"name\":\"" + station.getOrganName() + "\"}");
		}
		return EHRMessageUtil.returnMsg(model, lstTree);
	}

	@RequestMapping("/area/centresHistory")
	public String getCentresHistory(ModelMap model) {
		Criteria criStatus = new Criteria(Organization.STATUS, StatusValue.normalValue.getValue());
		List<OrganizationHistory> centres = organizationService.getOrganizationsHistory(new Criteria("GENRE_CODE", OrgGenreCode.CENTRE.getValue()).add(criStatus));//获取中心医院
		List<OrganizationHistory> stations = organizationService.getOrganizationsHistory(new Criteria("GENRE_CODE", OrgGenreCode.STATION.getValue()).add(criStatus).add(Organization.ORGAN_CODE,OP.NE, "320000000"));//获取卫生服站
		List<String> lstTree = new ArrayList<String>();
		List<DicItem> towns = dictionaryApp.queryDicItems("FS990001", EHRConstants.FS990001_ROOT);
		lstTree.add("{\"id\":\"1\", \"pId\":\"0\", \"name\":\"市\" , open:true, chkDisabled:true}");
		for (DicItem town : towns) {
			lstTree.add("{\"id\":\"" + town.getItemCode() + "\", \"pId\":\"1\", \"name\":\"" + town.getItemName() + "\" , chkDisabled:true}");
		}

		for (OrganizationHistory org : centres) {
			lstTree.add("{\"id\":\"" + org.getOrganCode() + "\", \"pId\":\"" + org.getGbCode() + "\", \"name\":\"" + org.getOrganName() + "\" }");
		}
		for (OrganizationHistory station : stations) {
			lstTree.add("{\"id\":\"" + station.getOrganCode() + "\", \"pId\":\"" + station.getParentCode() + "\", \"name\":\"" + station.getOrganName() + "\"}");
		}
		return EHRMessageUtil.returnMsg(model, lstTree);
	}

	@RequestMapping("/area/saveRelation")
	public String saveRelation(String villageCodes, String organCode, ModelMap model) {
		organizationService.saveRelation(organCode, this.getOrgArea(organCode, villageCodes, " "));
		return EHRMessageUtil.returnMsg(model, "success");
	}

	/**
	 * 根据机构code和行政村code获取关联表对象
	 *
	 * @param organCode
	 * @param villageCodes
	 * @return
	 */
	private List<OrganizationArea> getOrgArea(String organCode, String villageCodes, String genreCode) {
		List<OrganizationArea> orgAreas = new ArrayList<OrganizationArea>();
		if (StringUtils.isEmpty(villageCodes)) return orgAreas;

		String villageArray[] = villageCodes.split(",");
		for (String villageCode : villageArray) {
			OrganizationArea orgArea = new OrganizationArea();
			orgArea.setAreaCode(villageCode);
			orgArea.setOrganizationCode(organCode);
			orgArea.setOperator(getOperator());
			orgArea.setOperateTime(getOperatorTime());
			orgAreas.add(orgArea);
			orgArea.setAreaType(AreaType.VILLAGE.getValue());
		}
		return orgAreas;
	}

	/**
	 * 在机构区划是罗列该下所有的行政村
	 *
	 * @param organCode
	 * @param model
	 * @return
	 */
	@RequestMapping("/area/getVillages")
	public String getVillages(String organCode, ModelMap model,Integer selectYear) {
		Organization org = organizationService.getOrganization(new Criteria(Organization.ORGAN_CODE, organCode));
		if (ObjectUtil.isNullOrEmpty(org) || StringUtils.isEmpty(organCode) || !StringUtils.equals(org.getGenreCode(), OrgGenreCode.STATION.getValue())) {
			return "com.founder.mdm.organization.area.list";
		}
		Integer currentYear = DateUtil.getCurrentYear();

		//如果是当年数据则从ORGANIZATION_AREA表中获取
		if(currentYear.equals(selectYear)) {
			List<OrganizationArea> villages = organizationService.getOrganizationAreas(new Criteria("ORGANIZATION_CODE", organCode));
			List<DicItem> noParents = dictionaryService.getDicItemsForOrgArea(this.getGbCode(organCode));
			model.addAttribute("villages", villages);
			model.addAttribute("noParents", noParents);
			model.addAttribute("type", 1);
		}else{
			//如果不是当年数据则从ORG_VILLAGE_RELATION表中获取历史记录
			List<OrgVillageRelation> orgVillageRelations = orgVillageRelationService.getRelation(organCode,selectYear,ORG_AREA_HISTORY);
			model.addAttribute("villages", orgVillageRelations);
			model.addAttribute("type", 2);
		}
		return "com.founder.mdm.organization.area.list";
	}

	/**
	 * 在机构区划是罗列该下所有的行政村
	 *
	 * @param organCode
	 * @param model
	 * @return
	 */
	@RequestMapping("/area/getVillagesHistory")
	public String getVillagesHistory(String organCode, ModelMap model) {
		OrganizationHistory org = organizationService.getOrganizationHistory2(new Criteria(Organization.ORGAN_CODE, organCode));
		if (ObjectUtil.isNullOrEmpty(org) || StringUtils.isEmpty(organCode) || !StringUtils.equals(org.getGenreCode(), OrgGenreCode.STATION.getValue())) {
			return "com.founder.mdm.organization.area.list";
		}
		List<OrganizationAreaHistory> villages = organizationService.getOrganizationAreasHistory(new Criteria("ORGANIZATION_CODE", organCode));
		List<DicItem> noParents = dictionaryService.getDicItemsForOrgArea(this.getGbCode(organCode));
		model.addAttribute("villages", villages);
		model.addAttribute("noParents", noParents);
		return "com.founder.mdm.organization.area.list";
	}

	/**
	 * 在机构添加时罗列该下所有的行政村
	 *
	 * @param organCode
	 * @param gbCode
	 * @param parentCode
	 * @param model
	 * @return
	 */
	@RequestMapping("/getVillages")
	public String getOrgVillages(String organCode, String gbCode, String parentCode, ModelMap model) {
		String tempCode = "";
		if (StringUtils.isNotEmpty(gbCode)) {
			tempCode = gbCode;
		} else if (StringUtils.isNotEmpty(parentCode)) {
			tempCode = this.getGbCode(parentCode);
		}
		List<DicItem> noParents = dictionaryService.getDicItemsForOrgArea(tempCode);
		List<OrganizationArea> useds = organizationService.getOrganizationAreas(new Criteria("ORGANIZATION_CODE", organCode));
		model.addAttribute("noParents", noParents);
		model.addAttribute("useds", useds);
		return "com.founder.mdm.organization.village";
	}

	/**
	 * 当上级机构变化时在机构添加时罗列该下所有的行政村
	 *
	 * @param organCode
	 * @param gbCode
	 * @param parentCode
	 * @param model
	 * @return
	 */
	@RequestMapping("/getVillageOpting")
	public void getVillageOpting(String organCode, String gbCode, String parentCode, ModelMap model, HttpServletResponse response) {
		String tempCode = "";
		if (StringUtils.isNotEmpty(parentCode)) {
			tempCode = this.getGbCode(parentCode);
		} else if (StringUtils.isNotEmpty(gbCode)) {
			tempCode = gbCode;
		}
		List<DicItem> noParents = dictionaryService.getDicItemsForOrgArea(tempCode);
		List<OrganizationArea> useds = organizationService.getOrganizationAreas(new Criteria("ORGANIZATION_CODE", organCode));
		StringBuffer buffer = new StringBuffer();
		if (StringUtils.isNotEmpty(gbCode) && StringUtils.equals(gbCode, tempCode)) {
			for (OrganizationArea organizationArea : useds) {
				buffer.append("<option selected=\"selected\" title=\"" + organizationArea.getItemName() + "\" value='" + organizationArea.getAreaCode() + "'>" + organizationArea.getItemName() + "</option>");
			}
		}
		for (DicItem noParent : noParents) {
			buffer.append("<option title=\"" + noParent.getItemName() + "\" value='" + noParent.getItemCode() + "'>" + noParent.getItemName() + "</option>");
		}

		MessageUtils.outputJSONResult(StringUtils.isNotEmpty(buffer.toString()) ? buffer.toString() : "empty", response);
	}

	/**
	 * 添加机构时
	 *
	 * @param areaCode
	 * @param noParents
	 * @return
	 */
	private List<DicItem> getUsedDicItem(String areaCode, List<DicItem> noParents) {
		List<DicItem> useds = new ArrayList<DicItem>();
		if (StringUtils.isNotEmpty(areaCode)) {
			String areaCodes[] = areaCode.split(",");
			for (String test : areaCodes) {
				if (StringUtils.isNotEmpty(test)) {
					for (DicItem noParent : noParents) {
						if (StringUtils.equals(test, noParent.getItemCode())) {
							useds.add(noParent);
							noParents.remove(noParent);
							break;
						}
					}
				}
			}
		}
		return useds;
	}

	private String getGbCode(String organCode) {
		String gbCode = "";
		Organization organization = organizationService.getOrganization(organCode);
		if (ObjectUtil.isNotEmpty(organization)
				&& (StringUtils.equals(organization.getGenreCode(), OrgGenreCode.CENTRE.getValue())
				||StringUtils.equals(organization.getGenreCode(), OrgGenreCode.AREA_HEALTH.getValue()))) {
			gbCode = organization.getGbCode();
		} else if (ObjectUtil.isNotEmpty(organization) && StringUtils.equals(organization.getGenreCode(), OrgGenreCode.STATION.getValue())) {
			gbCode = organizationService.getOrganization(organization.getParentCode()).getGbCode();
		}
		return gbCode;
	}

	/**
	 * 初始化加载合并镇的页面
	 *
	 * @param orgCodes
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/initMergeDialog")
	public String initMergeDialog(String orgCodes, HttpServletRequest request, ModelMap model) {
		int maxSort = organizationService.getMaxSort(new Criteria());
		Organization organization = new Organization();
		if(ObjectUtil.isNotEmpty(maxSort)) {
			organization.setSort(maxSort+1);
		} else {
			organization.setSort(1);
		}
		model.addAttribute("organization", organization);
		String finalOrgCodes = this.getFinalOrgCodes(orgCodes);
		model.addAttribute("orgCodes", finalOrgCodes);
		model.addAttribute("orgCodesOld", orgCodes);
		if (StringUtils.equals(orgCodes, finalOrgCodes)) {
			model.addAttribute("flag", true);
			String[] orgCodeArray = orgCodes.split(",");
			Organization org = organizationApp.queryOrgan(orgCodeArray[0]);
			if(ObjectUtil.equals(org.getGenreCode(), OrgGenreCode.CENTRE.getValue()) ||
					ObjectUtil.equals(org.getGenreCode(), OrgGenreCode.INSTITUTES.getValue())	) {
				model.addAttribute("genreCode", OrgGenreCode.CENTRE.getValue() + "," + OrgGenreCode.INSTITUTES.getValue());
			} else if(ObjectUtil.equals(org.getGenreCode(), OrgGenreCode.STATION.getValue())){
				model.addAttribute("genreCode", OrgGenreCode.STATION.getValue());
			} else {
				model.addAttribute("genreCode", "J100,R11,A100,B100,B200,C,R200,L");
			}

		} else {
			model.addAttribute("flag", false);
		}
		return "com.founder.mdm.organization.merge";
	}

	/**
	 * 若站被迁移到中心下 则合并后的机构下拉列表只能显示中心
	 *
	 * @param orgCodes
	 * @return
	 */
	private String getFinalOrgCodes(String orgCodes) {
		String[] oldCodeArray = orgCodes.split(",");
		String oldStationCode = "";
		String oldCentreCode = "";
		List<Organization> organizationOlds = organizationService.getOrganizations(new Criteria(Organization.ORGAN_CODE, OP.IN, oldCodeArray));
		for (Organization temp : organizationOlds) {
			if (StringUtils.equals(OrgGenreCode.STATION.getValue(), temp.getGenreCode())) {
				oldStationCode = oldStationCode + "," + temp.getOrganCode();
			} else {
				oldCentreCode = oldCentreCode + "," + temp.getOrganCode();
			}
		}
		if (StringUtils.isNotEmpty(oldStationCode) && StringUtils.isNotEmpty(oldCentreCode)) {
			return oldCentreCode.replaceFirst(",", "");
		}
		return orgCodes;
	}

	/**
	 * 保存合并镇
	 *
	 * @param newCode
	 * @param oldCode
	 * @param organization
	 * @return
	 */
	@RequestMapping("/mergeOrganization")
	@ResponseBody
	public ModelMap mergeOrganization(String newCode, String oldCode, Organization organization, HttpServletRequest request) {
		ModelMap model = this.validateOrg(organization, "add");
		organization.setOperator(getOperator());
		organization.setOperateTime(getOperatorTime());
		organizationService.mergeOrganization(newCode, oldCode, organization);
		model.addAttribute("result", true);
		boolean flag = true;
		if(StringUtils.isEmpty(newCode)) {
			List<Organization> organizationOlds = organizationService.getOrganizations(new Criteria(Organization.ORGAN_CODE, OP.IN, Arrays.asList(oldCode.split(","))));
			for(Organization temp : organizationOlds) {
				if (!OrgGenreCode.STATION.getValue().equals(temp.getGenreCode())) {
					flag = false;
				}
			}
		}
		if(flag) {
			model.addAttribute("message", "合并机构成功，请修改人口设置！");
		} else {
			model.addAttribute("message", "合并机构成功");
		}
		return model;
	}

	/**
	 * 机构树,三层
	 *
	 * @param model
	 * @param name
	 * @param fullPyName
	 * @param pyName
	 * @return
	 * @author liuk
	 */
	@RequestMapping("/organationTree")
	@ResponseBody
	public SelectDTO<Object> getOrganTreeData(ModelMap model,
											  @RequestParam(required = false, value = "inputValue") String name,
											  @RequestParam(required = false, value = "fullPyName") String fullPyName,
											  @RequestParam(required = false, value = "organType") String organType,
											  @RequestParam(required = false, value = "pyName") String pyName) {
		List<DicItem> towns = dictionaryApp.queryDicItems("FS990001", EHRConstants.FS990001_ROOT);
		List<Object> nodes = new ArrayList<>();
		for (DicItem dicItem : towns) {
			nodes.add(createTownNode(dicItem));
		}

		Criteria criteria = new Criteria();

		if (ObjectUtil.isNotEmpty(organType)) {
			criteria.add("GENRE_CODE", OP.IN, organType.split(","));
		} else {
			criteria.add("GENRE_CODE", OP.IN, new Object[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.HOSPITAL.getValue(), OrgGenreCode.STATION.getValue()});
		}

		if (ObjectUtil.isNotEmpty(name)) {
			criteria.add("ORGAN_NAME", OP.LIKE, name);
		}
		criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		List<Organization> organizations = organizationApp.queryOrganization(criteria, new Order("sort"));
		if (ObjectUtil.isNotEmpty(organizations)) {
			for (Organization organization : organizations) {
				nodes.add(createOrganationNode(organization));
			}
		}
		SelectDTO<Object> result = new SelectDTO<>();
		result.setObjList(nodes);
		return result;
	}

	/**
	 * 机构选择框,自动选择框用
	 *
	 * @param model
	 * @param name
	 * @param fullPyName
	 * @param pyName
	 * @param indexPage
	 * @return
	 * @author liuk
	 */
	@RequestMapping("/organationSelect")
	@ResponseBody
	public SelectDTO<Organization> getOrganSelectData(
			HttpServletRequest request,
			ModelMap model,
			@RequestParam(required = false, value = "inputValue") String name,
			@RequestParam(required = false, value = "fullPyName") String fullPyName,
			@RequestParam(required = false, value = "pyName") String pyName,
			@RequestParam(required = false, value = "subsid") String subsid,
			@RequestParam(required = false, value = "organType") String organType,
			@RequestParam(required = false, value = "currentPage") int indexPage) {

		Page page = super.getPage(request, indexPage);

		Criteria criteria = new Criteria();
		if (ObjectUtil.isNotEmpty(organType)) {
			criteria.add("GENRE_CODE", OP.IN, organType.split(","));
		} else {
			criteria.add("GENRE_CODE", OP.IN, new Object[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.HOSPITAL.getValue(), OrgGenreCode.STATION.getValue()});
		}

		if (ObjectUtil.isNotEmpty(name)) {
			criteria.add("ORGAN_NAME", OP.LIKE, name);
		}
		if (ObjectUtil.isNotEmpty(subsid)) {
			criteria.add("SUBSID", subsid);
		}
		criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		PageList<Organization> organizations = organizationService.getOrganizations(page, criteria, new Order("sort"));
		SelectDTO<Organization> result = new SelectDTO<>(organizations);
		return result;
	}

	/**
	 * 创建树节点
	 *
	 * @param dicItem
	 * @return
	 */
	private Object createTownNode(DicItem dicItem) {
		return createNode(dicItem.getItemName(), dicItem.getItemCode(), "0", "0");
	}

	/**
	 * 创建树节点
	 *
	 * @param org
	 * @return
	 */
	private Object createOrganationNode(Organization org) {
		String parentCode = "";
		if (OrgGenreCode.CENTRE.getValue().equals(org.getGenreCode())
				|| OrgGenreCode.HOSPITAL.getValue().equals(org.getGenreCode())
				||OrgGenreCode.AREA_HEALTH.getValue().equals(org.getGenreCode())
				|| OrgGenreCode.CITY_HEALTH.getValue().equals(org.getGenreCode())
				|| OrgGenreCode.OTHER.getValue().equals(org.getGenreCode())) {
			parentCode = org.getGbCode();
			if (null == parentCode) {
				//TODO
			}
		} else {
			parentCode = org.getParentCode();
		}
		return createNode(org.getOrganName(), org.getOrganCode(), parentCode, org.getGenreCode());
	}

	/**
	 * 创建树节点
	 *
	 * @param name
	 * @param code
	 * @param parent
	 * @param type
	 * @return
	 */
	private Object createNode(String name, String code, String parent, String type) {
		Map<String, String> node = new HashMap<>(4);
		node.put("id", code);
		node.put("pId", parent);
		node.put("type", type);
		node.put("name", name);
		return node;
	}

	@RequestMapping("/getDeptList")
	@ResponseBody
	public List<Department> getDeptList(String organCode) {
		return departmentService.getDepartments(new Criteria("organCode", organCode));
	}

	@ResponseBody
	@RequestMapping("/getOrganNameByOrganCode")
	public String getOrganNameByOrganCode(String organCode) {
		String[] codes = organCode.split(",");
		Criteria criteria = new Criteria(Organization.ORGAN_CODE,OP.IN, codes);
		List<Organization> list = organizationService.getOrganizations(criteria);
		// 返回一个json数组
		JSONArray ja = new JSONArray();
		for(int i=0; i<list.size(); i++) {
			JSONObject obj = new JSONObject();
			Organization org = list.get(i);
			obj.put("code", org.getOrganCode());
			obj.put("name", org.getOrganName());
			ja.add(obj);
		}
		return ja.toString();
	}
}