package com.founder.rhip.dref.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;
import com.founder.rhip.ehr.service.IDualReferralService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDepartmentService;
import com.founder.rhip.mdm.service.IStaffService;

@Controller
@RequestMapping(value = "/referral")
public class DualReferralBrwController extends BaseController {

	@Resource
	private IDualReferralService dualReferralService;

	@Resource
	private IPlatformService platformService;

	@Resource
	private IDepartmentService departmentService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "mdmStaffService")
	private IStaffService staffService;
	
	@Autowired
	private IPersonalRecordService personalRecordService;
	
	@RequestMapping("/explorer")
	public String healthBrw(HttpServletRequest request, Model model){
		//假的session
		HttpSession session = request.getSession();
		String base = request.getQueryString();
		String result = null;
		try {
			result = Base64Util.decrypt(base, "UTF-8");
		} catch (Exception e) {
			logger.error("参数解析失败!");
		}
		Map<String, String> map = new HashMap<String, String>();
		if(ObjectUtil.isNotEmpty(result)){
			String[] results = result.split("&");
			for(int i=0;i<results.length;i++){
				String[] values = results[i].split("=");
				if(values.length == 2 && ObjectUtil.isNotEmpty(values[0]) && ObjectUtil.isNotEmpty(values[1])){
					map.put(values[0], values[1]);
				}else {
					logger.error("参数错误!");
					break;
				}
			}
		}else {
			logger.error("参数错误!");
		}
		session.setAttribute("explorerInfo", map);
		return "rhip.dref.browser.explorer";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, ModelMap modelMap) {
		modelMap.addAttribute("from", "explore");
		HttpSession session = request.getSession();
		Map<String, String> mapInfo = (Map<String, String>) session.getAttribute("explorerInfo");
		if (ObjectUtil.isNullOrEmpty(mapInfo)) {
			return "rhip.dref.edit";
		}
		String drefType = StringUtils.trimToEmpty(mapInfo.get("drefType"));//转诊类型：转出1，回转2
		String organCode = StringUtils.trimToEmpty(mapInfo.get("organCode"));
		String docName = StringUtils.trimToEmpty(mapInfo.get("docName"));
		String idCard = StringUtils.trimToEmpty(mapInfo.get("idcard"));
		if (!("1".equals(drefType)) && !("2".equals(drefType))) {
			modelMap.addAttribute("message", "转诊类型code有误，当前转诊类型code:" + drefType);
			return "rhip.dref.edit";
		}
		
		Organization currentOrgan =  organizationApp.queryOrgan(organCode);
		if (ObjectUtil.isNullOrEmpty(currentOrgan)) {
			modelMap.addAttribute("message", "机构不存在，当前机构code:" + organCode);
			return "rhip.dref.edit";
		}
		
		if (StringUtil.isNotEmpty(idCard)) {
			Criteria criteria = new Criteria("idcard", idCard);
			PersonInfo person = personalRecordService.getPersonRecord(criteria);
			ReferralInfo referralInfo = new ReferralInfo();
			
			if (ObjectUtil.isNullOrEmpty(person)) {
				referralInfo.setIdCard(idCard);
			} else {
				referralInfo.setIdCard(idCard);
				referralInfo.setName(person.getName());
				referralInfo.setBirthday(person.getBirthday());
				referralInfo.setGender(person.getGender());
				referralInfo.setPatientPhone(person.getPhoneNumber());
				referralInfo.setFatownShip(person.getPatownShip());
				referralInfo.setFastreet(person.getPastreet());
				referralInfo.setFahouseNumber(person.getPahouseNumber());
			}
			modelMap.put("referral", referralInfo);
		}
        
		
		List<Department> destRoomList = departmentService.getDepartments(new Criteria("organCode", organCode));
		modelMap.addAttribute("destRoomList", destRoomList);
		modelMap.addAttribute("drefType", drefType);
		modelMap.addAttribute("currentOrgan", currentOrgan);
		modelMap.addAttribute("docName", StringUtil.isNotEmpty(docName)?docName:"");
		modelMap.addAttribute("message", "");
		return "rhip.dref.edit";
	}
}
