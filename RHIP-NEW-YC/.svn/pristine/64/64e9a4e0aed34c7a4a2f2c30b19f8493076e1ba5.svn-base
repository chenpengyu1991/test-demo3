
package com.founder.rhip.ehr.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.*;
import com.founder.rhip.he.common.CriteriaOrganizer;
import com.founder.rhip.ihm.service.IDoctorSignCensusService;
import com.founder.rhip.mdm.entity.DicItem;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.entity.basic.FamilyCanceledInfo;
import com.founder.rhip.ehr.entity.basic.FamilyHostoiletRelation;
import com.founder.rhip.ehr.entity.basic.FamilyInfo;
import com.founder.rhip.ehr.entity.basic.FamilyPersonRelation;
import com.founder.rhip.ehr.entity.basic.FamilyWaterRelation;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.IFamilyRecordService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 家庭档案维护
 */
@Controller
public class FamilyRecordController extends BaseController {

	@Resource(name = "familyRecordService")
	private IFamilyRecordService familyRecordService;

	@Autowired
	private IDictionaryApp dictionaryApp;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	/**
	 * 进入家庭档案查询界面 --社区外其它机构
	 * 
	 * @return
	 */
	@RequestMapping(value = "/family/other")
	public String familySerach(HttpServletRequest request, ModelMap model) {
		String includeTownCodes= "";
		//如果是区卫管中心，则只能查询本区的数据
		if(SecurityUtils.hasRole(RoleType.QWGZX,request)){
			includeTownCodes = getCurrentOrg(request).getGbCode();
		}
		model.addAttribute("includeTownCodes", includeTownCodes);
		return "rhip.ehr.family.other.search";
	}

	/**
	 * 查询家庭档案 -- 社区外其它机构
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/family/list/other")
	public String search(FamilyInfo familyInfo, HttpServletRequest request, ModelMap model) {
		PageList<FamilyInfo> list = searchFamilyList(familyInfo, request);
		List<FamilyInfo> familyList = list.getList();
		List<FamilyBegatsDto> fbd = addString(familyList);//将配偶、子女、孙子女信息组成字符串
		model.addAttribute("familyRecords",fbd);
		model.addAttribute("page", list.getPage());
		if(((String)request.getParameter("selectFlagName")).equals("0")){
			return "rhip.ehr.family.other.list";
		}else {
			return "rhip.ehr.family.other.card";
		}
	}

	/**
	 * 进入家庭档案查询界面 -- 社区
	 * 
	 * @return
	 */
	@RequestMapping(value = "/family/sq")
	public String index() {
		return "rhip.ehr.family.sq.search"; // 社区查询界面，有添加等其它功能
	}

	/**
	 * 查询家庭档案 -- 社区
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/family/list/sq")
	public String searchFamily(FamilyInfo familyInfo, HttpServletRequest request, ModelMap model) {
		PageList<FamilyInfo> list = searchFamilyList(familyInfo, request);
		List<FamilyInfo> familyList = list.getList();
		List<FamilyBegatsDto> fbd = addString(familyList);//将配偶、子女、孙子女信息组成字符串
		model.addAttribute("familyRecords",fbd);
		model.addAttribute("page", list.getPage());
		if(("0").equals((String)request.getParameter("selectFlagName"))){
			return "rhip.ehr.family.sq.list";
		}else {
			return "rhip.ehr.family.sq.card";
		}
	}
			
	private List<FamilyBegatsDto> addString(List<FamilyInfo> flist){
		List<FamilyBegatsDto> fbdList=new ArrayList<FamilyBegatsDto>();
		for(int i=0;i<flist.size();i++){			
			FamilyBegatsDto fbd=new FamilyBegatsDto();
			StringBuffer sb1=new StringBuffer();
			StringBuffer sb2=new StringBuffer();
			StringBuffer sb3=new StringBuffer();
			StringBuffer sb4=new StringBuffer();
			List<FamilyPersonRelation> fpr=flist.get(i).getFamilyMemberList();			
			for(int j=0;j<fpr.size();j++){
				if(EHRConstants.FAMILY_MEMBERS_SON.equals(fpr.get(j).getFamilyMemTypeCode())){
					sb1.append(fpr.get(j).getFamilyMemberName());
					sb1.append(",");
				}else if(EHRConstants.FAMILY_MEMBERS_DAUGHTER.equals(fpr.get(j).getFamilyMemTypeCode())){
					sb2.append(fpr.get(j).getFamilyMemberName());
					sb2.append(",");
				}else if(
						EHRConstants.FAMILY_MEMBERS_GRANDCHILDREN.equals(fpr.get(j).getFamilyMemTypeCode()) ||
						EHRConstants.FAMILY_MEMBERS_GRANDSON.equals(fpr.get(j).getFamilyMemTypeCode()) ||
						EHRConstants.FAMILY_MEMBERS_GRANDDAUGHTER.equals(fpr.get(j).getFamilyMemTypeCode()) ||
						EHRConstants.FAMILY_MEMBERS_DAUGHTERSSON.equals(fpr.get(j).getFamilyMemTypeCode()) ||
						EHRConstants.FAMILY_MEMBERS_DAUGHTERSDAUGHTER.equals(fpr.get(j).getFamilyMemTypeCode())
				){
					sb3.append(fpr.get(j).getFamilyMemberName());
					sb3.append(",");
				}else if(EHRConstants.FAMILY_MEMBERS_MATE.equals(fpr.get(j).getFamilyMemTypeCode())){
					sb4.append(fpr.get(j).getFamilyMemberName());
					sb4.append(",");
				}
			}
			if(sb1.toString().length()>0){
				fbd.setSon(sb1.toString().substring(0, sb1.toString().length()-1));
			}
			if(sb2.toString().length()>0){
				fbd.setDaughter(sb2.toString().substring(0, sb2.toString().length()-1));
			}
			if(sb3.toString().length()>0){
				fbd.setGrandchildren(sb3.toString().substring(0, sb3.toString().length()-1));
			}			
			if(sb4.toString().length()>0){
				fbd.setMate(sb4.toString().substring(0, sb4.toString().length()-1));
			}
			fbd.setFamilyInfo(flist.get(i));
			fbdList.add(fbd);
		}
		return fbdList;
	}
	/**
	 * 进入创建家庭档案界面
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/family/add")
	public String add(HttpSession session) {
		session.removeAttribute(EHRConstants.FAMILY_MEMBERS);
		return "rhip.ehr.family.add";
	}

	/**
	 * 查看家庭档案界面
	 * @param familyInfo
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/family/lookUp")
	public String lookUp(FamilyInfo familyInfo, ModelMap model, HttpSession session) {
		FamilyRecordDTO dto = (FamilyRecordDTO) familyRecordService.getFamilyRecord(familyInfo);
		model.addAttribute("familyDTO", dto);
		if(ObjectUtil.isNotEmpty(dto.getFamilyInfo().getPatownShip())){
			DicItem dicItem = dictionaryApp.queryDicItem("FS990001", dto.getFamilyInfo().getPatownShip());
			if(ObjectUtil.isNotEmpty(dicItem)){
				model.addAttribute("orgName",dicItem.getItemName());
			}else {
				model.addAttribute("orgName",null);
			}
			model.addAttribute("orgName", dictionaryApp.queryDicItem("FS990001", dto.getFamilyInfo().getPatownShip()).getItemName());
		}
		if(ObjectUtil.isNotEmpty(dto.getFamilyInfo().getPastreet())){
			DicItem dicItem = dictionaryApp.queryDicItem("FS990001", dto.getFamilyInfo().getPastreet());
			if(ObjectUtil.isNotEmpty(dicItem)){
				model.addAttribute("orgNamePastreet",dicItem.getItemName());
			}else {
				model.addAttribute("orgNamePastreet",null);
			}
		}
		session.setAttribute(EHRConstants.FAMILY_MEMBERS, dto.getMemberList());
		return "rhip.ehr.family.lookUp";
	}
	/**
	 * 进入修改家庭档案界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/family/update")
	public String update(FamilyInfo familyInfo, ModelMap model, HttpSession session) {
		FamilyRecordDTO dto = (FamilyRecordDTO) familyRecordService.getFamilyRecord(familyInfo);
		model.addAttribute("familyDTO", dto);
		if(ObjectUtil.isNotEmpty(dto.getFamilyInfo().getPatownShip())){
			model.addAttribute("orgName", dictionaryApp.queryDicItem("FS990001", dto.getFamilyInfo().getPatownShip()).getItemName());
		}
		if(ObjectUtil.isNotEmpty(dto.getFamilyInfo().getPastreet())){
			DicItem dicItem = dictionaryApp.queryDicItem("FS990001", dto.getFamilyInfo().getPastreet());
			if(ObjectUtil.isNotEmpty(dicItem)){
				model.addAttribute("orgNamePastreet",dicItem.getItemName());
			}else {
				model.addAttribute("orgNamePastreet",null);
			}

		}
		session.setAttribute(EHRConstants.FAMILY_MEMBERS, dto.getMemberList());
		return "rhip.ehr.family.add";
	}

	/**
	 * 查看家庭成员
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/family/person/lookUp")
	public String lkkoUpPersonIndex(HttpSession session, ModelMap model) {
		model.addAttribute("personList", addNullPersonList(null));
		model.addAttribute("page", new Page());
		if (null != session.getAttribute(EHRConstants.FAMILY_MEMBERS)) {
			model.addAttribute("memberList", addNullPersonList((List<PersonInfo>) session.getAttribute(EHRConstants.FAMILY_MEMBERS)));
		} else {
			model.addAttribute("memberList", addNullPersonList(null));
		}
		return "rhip.ehr.family.lookUpMember";
	}
	/**
	 * 添加家庭成员首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/family/person/index")
	public String personIndex(HttpSession session, ModelMap model) {
		model.addAttribute("personList", addNullPersonList(null));
		model.addAttribute("page", new Page());
		if (null != session.getAttribute(EHRConstants.FAMILY_MEMBERS)) {
			model.addAttribute("memberList", addNullPersonList((List<PersonInfo>) session.getAttribute(EHRConstants.FAMILY_MEMBERS)));
		} else {
			model.addAttribute("memberList", addNullPersonList(null));
		}
		return "rhip.ehr.family.member";
	}

	/**
	 * 保存家庭档案
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/family/save")
	public String save(FamilyInfo familyInfo, String inputDateString, HttpServletRequest request, ModelMap model) {
		FamilyRecordDTO fiDTO = VoUtil.getFormData(request, FamilyRecordDTO.class);
		if(ObjectUtil.isNotEmpty(inputDateString)){
			familyInfo.setInputDate(DateUtil.parseSimpleDate(inputDateString, null));
		}
		/* 给家庭基本信息赋值 */
		setFamilyInfo(familyInfo, request);
		fiDTO.setFamilyInfo(familyInfo); // 将家庭信息放入DTO统一处理
		fiDTO.coverMemberTOPersonRelation();// 将成员对象存入DTO
		coverFamilyInfoToOther(fiDTO, familyInfo);// 将用水类别和户厕类别放入DTO

		boolean isFamilyExist = ObjectUtil.isNotEmpty(fiDTO.getFamilyInfo().getId()) ? true : false;
		String result = familyRecordService.createFamilyRecord(fiDTO);
		request.setAttribute("page", new Page());
		if ("success".equals(result)) {
			request.getSession().removeAttribute(EHRConstants.FAMILY_MEMBERS);
			if(isFamilyExist){
				createOperationLog(request,RhipModuleName.EHR, "家庭档案", OperationName.UPDATE);
			}else {
				createOperationLog(request,RhipModuleName.EHR, "家庭档案", OperationName.ADD);
			}
		}else if("familyNotOnly".equals(result)){
			return EHRMessageUtil.returnMsg(model, "familyNotOnly");
		}else if("accountNotOnly".equals(result)){
			return EHRMessageUtil.returnMsg(model, "accountNotOnly");
		}else if("noFamilyMember".equals(result)){
			return EHRMessageUtil.returnMsg(model, "noFamilyMember");
		}else if("multipleFamilyHeadOrMate".equals(result)){
			return EHRMessageUtil.returnMsg(model, "multipleFamilyHeadOrMate");
		}else if("noFamilyHeadError".equals(result)){
			return EHRMessageUtil.returnMsg(model, "noFamilyHeadError");
		}
		return "rhip.ehr.family.member";
	}

	/**
	 * 注消家庭档案视图
	 */
	@RequestMapping(value = "/family/cancel/view")
	public String cancelFamilyView(String familyId, String status,ModelMap modelMap) {
		if (StringUtils.isNotBlank(familyId)) {
			List<FamilyCanceledInfo> families = familyRecordService.getFamilies(new Criteria("familyId", familyId), new Order("CANCELED_DATE", false).desc("ID"));
			if(ObjectUtil.isNotEmpty(families) && !status.equals(EHRConstants.F_HAD_CREATE)){
				 modelMap.addAttribute("familyCanceledInfo", families.get(0));
			}
        }
        modelMap.addAttribute("status", status);
        modelMap.addAttribute("familyId", familyId);
		return "rhip.ehr.family.off";
	}

	/**
	 * 注消家庭档案
	 * 
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping(value = "/family/cancel")
	public void cancelFamily(FamilyCanceledInfo familyCanceledInfo, HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("remsg", "操作失败");
		map.put("restatus", "0"); 
		/*if (request.getParameter("isApprove").equals("1")) {
			approveFamily(request,map,familyCanceledInfo); // 审核
		} else {
			logoffFamily(request,map,familyCanceledInfo,1);// 注消
		}*/
		// modified by Kevin Ro 2017-4-7 将审核功能去除，不需要审核，直接注销
		logoffFamily(request,map,familyCanceledInfo,2);// 注消
		MessageUtils.outputJSONResult(JSONObject.fromObject(map).toString(),response); 
	}
	
	private void approveFamily(HttpServletRequest request,Map<String, String> map,FamilyCanceledInfo familyCanceledInfo)
	{
		int status = Integer.valueOf(request.getParameter("status"));
		boolean flg = familyRecordService.approveCancelFamily(status, familyCanceledInfo)>0;
		if (flg) {
			String msg = status == 2 ? "审核成功!" : "拒绝成功!"; 
			map.put("remsg", msg);
			map.put("restatus", String.valueOf(status));
			
			if(status == 2){
				createOperationLog(request,RhipModuleName.EHR, "家庭档案", OperationName.DELETE);
			}else {
				createOperationLog(request,RhipModuleName.EHR, "家庭档案", OperationName.UPDATE);
			}
		}
	}
	
	private void logoffFamily(HttpServletRequest request,Map<String, String> map,FamilyCanceledInfo familyCanceledInfo,int status) {
		User userInfo = SecurityUtils.getCurrentUser(request);
		Organization organization = SecurityUtils.getCurrentOrganization(request);
		familyCanceledInfo.setCanceledIdcard(userInfo.getIdentityCard());
		familyCanceledInfo.setCanceledName(userInfo.getName());
		familyCanceledInfo.setCanceledOrganCode(organization.getOrganCode());
		familyCanceledInfo.setCanceledOrganName(organization.getOrganName());
		familyCanceledInfo.setRejectedReason(null);
		familyCanceledInfo.setIsDelete(0); 
		boolean flg = familyRecordService.cancelFamilyRecord(status, familyCanceledInfo)>0;
		if (flg) {
			map.put("remsg", "已结案!");
			map.put("restatus", String.valueOf(status));
			createOperationLog(request,RhipModuleName.EHR, "家庭档案", OperationName.UPDATE);
		}
	}

	private void setFamilyInfo(FamilyInfo familyInfo, HttpServletRequest request) {
		/* 更新家庭信息 */
		Organization organization = SecurityUtils.getCurrentOrganization(request);
		User user = SecurityUtils.getCurrentUser(request);
		/* 每次更新 */
		familyInfo.setUpdateDate(new Date());
		familyInfo.setUpdateName(user.getName());
		familyInfo.setUpdateIdcard(user.getIdentityCard());
		familyInfo.setUpdateOrgancode(organization.getOrganCode());
		familyInfo.setUpdateOrganname(organization.getOrganName());
		familyInfo.setZoneGBCode(familyInfo.getPatownShip());
		familyInfo.setgBCode(familyInfo.getPatownShip());
		familyInfo.setUpdateName(SecurityUtils.getCurrentUser(request).getUserName());
		/* 首次创建 */
		if (null == familyInfo.getId()) {
			familyInfo.setInputDate(new Date());
			familyInfo.setInputOrganCode(organization.getOrganCode());
			familyInfo.setInputOrganName(organization.getOrganName());
			familyInfo.setInputName(user.getName());
			familyInfo.setInputIdcard(user.getIdentityCard());
			familyInfo.setIsDelete(0);
			familyInfo.setStatus(0);
		}
		familyInfo.setAddress(familyInfo.getOrgName() + familyInfo.getPahouseNumber());
	}

	/**
	 * 获取个人列表
	 * 
	 * @param personName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/family/person/list")
	public String searchPerson(String personName, String idCard, HttpServletRequest request, ModelMap model) {
		FamilyRecordDTO fiDTO = VoUtil.getFormData(request, FamilyRecordDTO.class);
		List<PersonInfo> members = mergeMember(request, null);
		List<Long> ids = getMemberIds(members);
		PageList<PersonInfo> list = searchPersonList(personName,idCard, request, ids);
		model.addAttribute("personList", addNullPersonList(list.getList()));
		model.addAttribute("page", list.getPage());
		if (null != WebUtils.getSessionAttribute(request, EHRConstants.FAMILY_MEMBERS)) {
			members = (List<PersonInfo>) WebUtils.getSessionAttribute(request, EHRConstants.FAMILY_MEMBERS);
		}
		model.addAttribute("memberList", setSelected(addNullPersonList(members),fiDTO));
        model.addAttribute("personName", personName);
        model.addAttribute("idCard", idCard);
		return "rhip.ehr.family.member";
	}

	/**
	 * 增加成员
	 * 
	 * @param personName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/family/member/add", method = RequestMethod.POST)
	public String addMember(String personName, String idCard,  HttpServletRequest request, ModelMap model) {
		FamilyRecordDTO fiDTO = VoUtil.getFormData(request, FamilyRecordDTO.class);
		List<PersonInfo> members = mergeMember(request, fiDTO);
		List<Long> ids = getMemberIds(members);
		PageList<PersonInfo> list = searchPersonList(personName, idCard, request, ids);
		model.addAttribute("personList", addNullPersonList(list.getList()));
		model.addAttribute("page", list.getPage());
		model.addAttribute("memberList", setSelected(addNullPersonList(members),fiDTO));
        model.addAttribute("personName", personName);
        model.addAttribute("idCard", idCard);
		WebUtils.setSessionAttribute(request, EHRConstants.FAMILY_MEMBERS, members);
		return "rhip.ehr.family.member";
	}

	/**
	 * 设置家庭角色
	 * @param members
	 * @param fiDTO
	 * @return
	 */
	private List<PersonInfo> setSelected(List<PersonInfo> members,FamilyRecordDTO fiDTO){
		if(ObjectUtil.isNullOrEmpty(fiDTO)){
			return members;
		}
		if(ObjectUtil.isNullOrEmpty(members)){
			return members;
		}
		if(ObjectUtil.isNullOrEmpty(fiDTO.getMemberList())){
			return members;
		}
		
		List<PersonInfo> selectMembers = fiDTO.getMemberList();
		for(PersonInfo p:members){
			Long pId = p.getId();
			if(p.getId() == null){
				break;
			}
			for(PersonInfo sp:selectMembers){
				if(ObjectUtil.isNullOrEmpty(sp)){
					continue;
				}
				if(ObjectUtil.isNullOrEmpty(sp.getSelected())){
					continue;
				}
				if(pId.equals(sp.getSelected())){
					p.setFamilyMemTypeCode(sp.getFamilyMemTypeCode());
					break;
				}
			}
		}
		return members;
	}
	
	/**
	 * 删除成员
	 * 
	 * @param personName
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/family/member/remove")
	public String removeMember(String personName, String idCard, HttpServletRequest request, ModelMap model) {
		FamilyRecordDTO fiDTO = VoUtil.getFormData(request, FamilyRecordDTO.class);
		List<PersonInfo> members = this.removeMember(request, fiDTO);
		List<Long> ids = getMemberIds(members);
		PageList<PersonInfo> list = searchPersonList(personName,idCard, request, ids);
		model.addAttribute("personList", addNullPersonList(list.getList()));
		model.addAttribute("page", list.getPage());
		model.addAttribute("memberList", addNullPersonList(members));
        model.addAttribute("personName", personName);
        model.addAttribute("idCard", idCard);
		WebUtils.setSessionAttribute(request, EHRConstants.FAMILY_MEMBERS, members);
		return "rhip.ehr.family.member";
	}
	
	@RequestMapping("/family/familyOffBack")
	public @ResponseBody Integer familyOffBack(@RequestParam(value="familyId") String familyId,@RequestParam(value="status")Integer familyStatus){
		FamilyInfo familyInfo = familyRecordService.getFamilyInfo(new Criteria("id",familyId));
		if(ObjectUtil.isNotEmpty(familyInfo)){
			familyInfo.setStatus(0);
			boolean flag = familyRecordService.updateFamilyInfo(familyInfo, "status");
			familyStatus = flag ? familyInfo.getStatus() : familyStatus;
		}
		return familyStatus;
	}

	@RequestMapping("/familyStatistics/search")
	public String familyStatisticsSearch(HttpServletRequest request, ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.phsr.familyStatistics.search";
	}

	@RequestMapping("/familyStatistics/list")
	public String familyStatisticsList(HttpServletRequest request, ModelMap model) {
		Criteria criteria = CriteriaOrganizer.initCriteriaCondition(request.getParameterMap());
		criteria.remove("date"); // 去除多余的条件
		String summaryType = request.getParameter("countType");
		if("2".equals(summaryType)){//按月
			criteria.remove("createBeginTime");
			criteria.remove("createEndTime");
		}else if("1".equals(summaryType)){//按年
			criteria.remove("month");
		}

		criteria.remove("countType");
		// 不同身份查询条件
//		organizeCriteria(criteria, model, request,RoleType.ZXJKDN,RoleType.ZJKDN,null);
		Organization org = getCurrentOrg(request);
		model.addAttribute("createrOrg", hasRole(RoleType.YY_GLY, request) ? "_999" : org.getOrganCode()); // 用来控制编辑与删除的操作
		if (!criteria.contains("organCode")) {
			if (hasRole(RoleType.ZXJKDN, request)) {
				criteria.add("centerOrgCode", org.getOrganCode());
			} else if (hasRole(RoleType.ZJKDN, request) || hasRole(null, request)) {
				criteria.add("orgCode", org.getOrganCode());
			}
		}

		// 用来页面判断显示机构
		if (criteria.contains("orgCode")) {
			model.addAttribute("orgCode", criteria.get("orgCode"));
		} else if (criteria.contains("centerOrgCode")) {
			model.addAttribute("centerOrgCode", criteria.get("centerOrgCode"));
		} else if (criteria.contains("gbcode")) {
			model.addAttribute("gbcode", criteria.get("gbcode"));
		}else{
			model.addAttribute("all", "all");
		}
		CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
		if(SecurityUtils.hasRole(RoleType.QWGZX, request)){
			criteria.add("qwgzxCode",currentLoginInfo.getOrganization().getGbCode());
		}
		List<FamilyStatisticDto> reports = familyRecordService.getFamilyDtoList(criteria);

		//统计总数
		FamilyStatisticDto familyStatisticDto = countFamilyStatisticDto(reports);

		model.addAttribute("currentLoginInfo", currentLoginInfo);
		model.addAttribute("reports", reports);
		model.addAttribute("familyStatisticDto", familyStatisticDto);
		return "rhip.phsr.familyStatistics.list";
	}


	private FamilyStatisticDto countFamilyStatisticDto(List<FamilyStatisticDto> reports){
		//统计合计信息
		FamilyStatisticDto familyStatisticDto = new FamilyStatisticDto();
		familyStatisticDto.setRecordFamilyRate(new BigDecimal(0));
		if(ObjectUtil.isNotEmpty(reports)){
			for (FamilyStatisticDto report : reports) {
				//已建档
				familyStatisticDto.setRecordFamilyNum(familyStatisticDto.getRecordFamilyNum() + (report.getRecordFamilyNum()==null?0:report.getRecordFamilyNum()));
				//建档率
				String recordFamilyNumStr = report.getRecordFamilyNum()==0?"0":report.getRecordFamilyNum().toString();
				String familyNumStr = report.getFamilyNum()==0?"0":report.getFamilyNum().toString();
				BigDecimal rate =report.getFamilyNum()==0?new BigDecimal(0):new BigDecimal(recordFamilyNumStr).divide(new BigDecimal(familyNumStr),20,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));
				familyStatisticDto.setRecordFamilyRate(familyStatisticDto.getRecordFamilyRate().add(rate));
			}
		}
		return familyStatisticDto;
	}

	/**
	 * 查询个人列表包含除已添加的成员
	 * 
	 * @param personName
	 * @param request
	 * @return
	 */
	private PageList<PersonInfo> searchPersonList(String personName,String idCard, HttpServletRequest request, List<Long> ids) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = new Page(EHRConstants.PAGE_SIZE_NINE, currentPage);
        PersonInfo personInfo = new PersonInfo();
        if (StringUtils.isNotBlank(personName)) personInfo.setName(personName);	;
        if (StringUtils.isNotBlank(idCard)) personInfo.setIdcard(idCard);
        
//        if(hasRole(RoleType.QWGZX,request) && !criteria.contains("gbcode")){
//			criteria.add("gbcode",getCurrentOrg(request).getGbCode());
//		}if (!criteria.contains("orgCode")) {
//			if (hasRole(RoleType.ZXJKJY, request)||hasRole(RoleType.ZX_GLY, request)) {
//				criteria.add("centerOrgCode", getCurrentOrg(request).getOrganCode());
//			} else if (hasRole(RoleType.ZJKJY, request)||hasRole(RoleType.Z_GLY, request)) {
//				criteria.add("orgCode", getCurrentOrg(request).getOrganCode());
//			}
//		}
        Criteria criteria = new Criteria();
        if(hasRole(RoleType.QWGZX,request)){
        	criteria.add("bpi.INPUT_GBCODE",getCurrentOrg(request).getGbCode());
        }if (hasRole(RoleType.ZXJKDN, request)||hasRole(RoleType.ZX_GLY, request)) {
			criteria.add("bpi.INPUT_CENTER_ORGAN_CODE", getCurrentOrg(request).getOrganCode());
		} else if (hasRole(RoleType.ZJKDN, request)||hasRole(RoleType.Z_GLY, request)) {
			criteria.add("bpi.INPUT_ORGAN_CODE", getCurrentOrg(request).getOrganCode());
		}
        
        
		PageList<PersonInfo> list = familyRecordService.getUnRegRecordPersonList(personInfo, ids, page,criteria);
		return list;
	}

	/**
	 * 合并成员
	 * 
	 * @param request
	 * @param fiDTO
	 */
	private List<PersonInfo> mergeMember(HttpServletRequest request, FamilyRecordDTO fiDTO) {
		List<PersonInfo> members = new ArrayList<PersonInfo>();
		if (null != WebUtils.getSessionAttribute(request, EHRConstants.FAMILY_MEMBERS)) {
			members.addAll((List<PersonInfo>) WebUtils.getSessionAttribute(request, EHRConstants.FAMILY_MEMBERS));
		}
		if (null != fiDTO && null != fiDTO.getPersonInfoList()) {
			for (PersonInfo pi : fiDTO.getPersonInfoList()) {
				if (null != pi && null != pi.getId())
					members.add(pi);
			}
		}
		
//		List<PersonInfo> selectMergeMembers = fiDTO.getMemberList();
//		
//		if(ObjectUtil.isNullOrEmpty(selectMergeMembers) || ObjectUtil.isNullOrEmpty(members)){
//			return members;
//		}
		
//		for(PersonInfo p :members){
//			Long pId = p.getId();
//			for()
//		}
		
		return members;
	}

	/**
	 * 删除家庭成员
	 * 
	 * @param request
	 * @param fiDTO
	 * @return
	 */
	private List<PersonInfo> removeMember(HttpServletRequest request, FamilyRecordDTO fiDTO) {
		List<PersonInfo> members = new ArrayList<PersonInfo>();
		if (null != WebUtils.getSessionAttribute(request, EHRConstants.FAMILY_MEMBERS)) {
			members.addAll((List<PersonInfo>) WebUtils.getSessionAttribute(request, EHRConstants.FAMILY_MEMBERS));
		}
		if (null != fiDTO && null != fiDTO.getMemberList()) {
			for (PersonInfo pi : fiDTO.getMemberList()) {
				if (null != pi && null != pi.getId())
					members.remove(pi);
			}
		}
		return members;
	}

	/**
	 * 获取成员ID列表
	 * 
	 * @param members
	 * @return
	 */
	private List<Long> getMemberIds(List<PersonInfo> members) {
		List<Long> ids = new ArrayList<Long>();
		if (null == members)
			return ids;
		for (PersonInfo pi : members)
			ids.add(pi.getId());
		return ids;
	}

	
	/**
	 * 补充空列表显示
	 * 
	 * @param list
	 * @return
	 */
	private List<PersonInfo> addNullPersonList(List<PersonInfo> list) {
		if (null != list && list.size() >= EHRConstants.PAGE_SIZE_NINE)
			return list;
		List<PersonInfo> nList = new ArrayList<PersonInfo>(EHRConstants.PAGE_SIZE_NINE);
		int size = EHRConstants.PAGE_SIZE_NINE;
		if (null != list) {
			size = EHRConstants.PAGE_SIZE_NINE - list.size();
			nList.addAll(list);
		}
		for (int i = 0; i < size; i++) {
			nList.add(new PersonInfo());
		}
		return nList;
	}

	/**
	 * 转换饮用水和户厕
	 * 
	 * @param familyRecordDTO
	 * @param familyInfo
	 */
	private void coverFamilyInfoToOther(FamilyRecordDTO familyRecordDTO, FamilyInfo familyInfo) {
		if (null == familyInfo || null == familyRecordDTO)
			return;
		List<FamilyWaterRelation> familyWaterRelations = new ArrayList<>();
		List<FamilyHostoiletRelation> familyHostoiletRelations = new ArrayList<>();
		for (String s : StringUtils.split(familyInfo.getWater(), ",")) {
			FamilyWaterRelation fw = new FamilyWaterRelation();
			fw.setWaterCode(s);
			familyWaterRelations.add(fw);
		}
		for (String s : StringUtils.split(familyInfo.getHastoilet(), ",")) {
			FamilyHostoiletRelation fh = new FamilyHostoiletRelation();
			fh.setHastoiletCode(s);
			familyHostoiletRelations.add(fh);
		}
		familyRecordDTO.setWaterRelationList(familyWaterRelations);
		familyRecordDTO.setHostoiletRelationList(familyHostoiletRelations);
	}

	/**
	 * 页面列表查询
	 */
	private PageList<FamilyInfo> searchFamilyList(FamilyInfo familyInfo, HttpServletRequest request) {
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage); 
		request.setAttribute("page", page);
		Organization organization = getCurrentOrg(request);
		Criteria ca = new Criteria();
        if (StringUtils.isNotBlank(familyInfo.getMemberLink())) ca.add("memberLink",OP.LIKE, familyInfo.getMemberLink());
        if (StringUtils.isNotBlank(familyInfo.getAddress())) ca.add("address",OP.LIKE, familyInfo.getAddress());
		if (StringUtils.isNotBlank(familyInfo.getHouseholderIdcard())) ca.add("householderIdcard", familyInfo.getHouseholderIdcard());//户主身份证号
        if(hasRole(RoleType.QWGZX,request) && StringUtil.isNullOrEmpty((String) request.getParameter("searchTown"))){
			String gBCode = getCurrentOrg(request).getGbCode();
			List<String> orgCodes = this.getOrganCodeByGBCode(gBCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				ca.add("inputOrganCode", OP.IN, orgCodes);
			}else {
				ca.add("inputOrganCode", EHRConstants.INPUTORGANCODE_NULL);//如果镇下面没有站，给inputOrganCode -1值
			}
		}else if(StringUtils.isNotEmpty((String) request.getParameter("centerOrgCode"))){
			String orgCode = (String) request.getParameter("centerOrgCode");
			ca.add("inputOrganCode", orgCode);
		}else if(StringUtils.isNotEmpty((String) request.getParameter("searchstation"))){
			String orgCode = (String) request.getParameter("searchstation");
			ca.add("inputOrganCode", orgCode);
		}else if(StringUtils.isNotEmpty((String) request.getParameter("searchCenter"))){
			String orgCode = (String) request.getParameter("searchCenter");
			List<String> orgCodes = this.getOrganCodeByOrgCode(orgCode);
			orgCodes.add(orgCode);
            /*if(SecurityUtils.hasRole(RoleType.ZX_GLY,request)){
                orgCodes.add(orgCode);
            }*/
            if(ObjectUtil.isNotEmpty(orgCodes)){
				ca.add("inputOrganCode", OP.IN, orgCodes);
			}else {
				ca.add("inputOrganCode", EHRConstants.INPUTORGANCODE_NULL);//如果中心下面没有站，给inputOrganCode -1值
			}
		}else if(StringUtils.isNotEmpty((String) request.getParameter("searchTown"))){
			String gBCode = (String) request.getParameter("searchTown");
			List<String> orgCodes = this.getOrganCodeByGBCode(gBCode);
			if(ObjectUtil.isNotEmpty(orgCodes)){
				ca.add("inputOrganCode", OP.IN, orgCodes);
			}else {
				ca.add("inputOrganCode", EHRConstants.INPUTORGANCODE_NULL);//如果镇下面没有站，给inputOrganCode -1值
			}
		}else  if ((hasRole(RoleType.ZXJKDN,request) || hasRole(RoleType.ZJKDN,request)) && StringUtils.isEmpty(familyInfo.getInputOrganCode())) {
			List<Organization> organizations = organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, organization.getOrganCode()));
			if(ObjectUtil.isNotEmpty(organizations)){
				List<String> ids = new ArrayList<>();
				for (Organization org : organizations) {
					ids.add(org.getOrganCode());
				}
				//中心查询时加入本中心机构
                ids.add(organization.getOrganCode());
				ca.add("inputOrganCode", OP.IN, ids);
			}else if(!SecurityUtils.hasRole(RoleType.ADMIN,request) && !SecurityUtils.hasRole(RoleType.JKJKDN,request)){
				ca.add("inputOrganCode", organization.getOrganCode());
			}
		}
		

        // 添加状态查询条件
        Integer status = familyInfo.getStatus();
        if(status != null && status != -1) {
            ca.add("status", status);
        }
        Order order = new Order("STATUS",true);
		order.desc("UPDATE_DATE");

		return familyRecordService.getFamilyRecord(page, ca, order);
	}
	
	
	/**
	 * 根据GBCODE得到镇下面所有orgCode
	 * @param gbCode
	 * @return
	 */
	private List<String> getOrganCodeByGBCode(String gbCode){
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


	/**
	 * 根据服务中心的orgCode得到下面所有orgCode
	 * @param orgCode
	 * @return
	 */
	private List<String> getOrganCodeByOrgCode(String orgCode){
		List<String> orgCodes = new ArrayList<String>();
		Criteria criteria = new Criteria(Organization.PARENT_CODE,orgCode);
		List<Organization> organizationList = organizationApp.queryOrganization(criteria);     //
		if(ObjectUtil.isNullOrEmpty(organizationList)){  
			orgCodes.add(orgCode);
		}else{
			for (Organization organization : organizationList) {
				orgCodes.add(organization.getOrganCode());
			}
		}
		return orgCodes;
	}
}
