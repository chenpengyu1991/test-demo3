package com.founder.rhip.hsa.controller.sodp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.common.RoleType;
import org.apache.commons.lang.StringUtils;
import org.apache.velocity.tools.config.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.SusOccDisInfo;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.hsa.controller.HsaController;
import com.founder.rhip.hsa.service.ISusOccDiservice;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 可疑职业病人
 * 
 * @author liuk
 * 
 */
@Controller
@RequestMapping(value = "/hsa/inspRecord/sodp")
public class SodpController extends HsaController {

	private final static String CONTROLLER_NAME = "可疑职业病人";

	@Resource(name = "susOccDiService")
	private ISusOccDiservice susOccDiService;

	@Resource(name = "platformService")
	private IPlatformService platformService;

	@RequestMapping(value = "/list")
	public String sodpList(Model model) {
		return "rhip.hsa.sodp.list";
	}

	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, Model model) {
		@SuppressWarnings("rawtypes")
		Map map = getParameterMap(request);
		int mapSize = map.size();
		if (mapSize > 1) {
			boolean update = true;
			model.addAttribute("update", update);
		}
		model.addAttribute("data", map);
		return "rhip.hsa.sodp.add";
	}

	/**
	 * 从request中获得参数Map，并返回可读的Map
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map getParameterMap(HttpServletRequest request) {
		// 参数Map
		Map properties = request.getParameterMap();
		// 返回值Map
		Map returnMap = new HashMap();
		Iterator entries = properties.entrySet().iterator();
		Map.Entry entry;
		String name = "";
		String value = "";
		while (entries.hasNext()) {
			entry = (Map.Entry) entries.next();
			name = (String) entry.getKey();
			Object valueObj = entry.getValue();
			if (null == valueObj) {
				value = "";
			} else if (valueObj instanceof String[]) {
				String[] values = (String[]) valueObj;
				for (int i = 0; i < values.length; i++) {
					value = values[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = valueObj.toString();
			}
			returnMap.put(name, value);
		}
		return returnMap;
	}

	/**
	 * 可疑职业病信息列表
	 * 
	 * @param susOccDisInfo
	 * @return
	 */
	@RequestMapping(value = "/susOccDiSearch")
	public String susOccDiSearch(SusOccDisInfo susOccDisInfo, ModelMap model, HttpServletRequest request, @RequestParam(value = "gbcode", required = false) String town,
			@RequestParam(value = "centerOrganCode", required = false) String org) {
		Criteria criteria = createSearchCriteria(susOccDisInfo, town, org);
		if(hasRole(RoleType.QWGZX,request) && !criteria.contains("createGbcode")){
			criteria.add("createGbcode",getCurrentOrg(request).getGbCode());
		}else if (hasRole(RoleType.ZXWJ,request)) {
			Criteria cr = new Criteria();
			cr.add("createCenterOrganCode", getCurrentOrg(request).getOrganCode());
			cr.add(LOP.OR, "createOrganCode", getCurrentOrg(request).getOrganCode());
			criteria.add(cr);
		}else if(hasRole(RoleType.ZWJ,request)){
			Criteria cr = new Criteria();
			cr.add("createOrganCode", getCurrentOrg(request).getOrganCode());
			criteria.add(cr);
		}
		Page page = buildPage(request);
		PageList<SusOccDisInfo> susOccDisInfoList = susOccDiService.getSusOccDisInfo(criteria, page, getHrRole(request), getCurrentOrg(request));
		List<SusOccDisInfo> list = susOccDisInfoList.getList();
		model.addAttribute("susOccDisInfoList", list);
		return "rhip.hsa.susOccDi.result";
	}
	/**
	 * 保存可疑职业病信息
	 * 
	 * @param susOccDisInfo
	 * @return
	 */
	@RequestMapping(value = "/saveSusOccDisInfo")
	public @ResponseBody
	String saveSusOccDisInfo(SusOccDisInfo susOccDisInfo, ModelMap model, HttpServletRequest request) {
		boolean status = susOccDiService.saveSusOccDisInfo(susOccDisInfo, getCurrentOrg(request), getCurrentUser(request));
		return status ? "success" : "failure";
	}
	/**
	 * 新增可疑职业病信息
	 * 
	 * @param 
	 * @return
	 */
	@RequestMapping(value = "/susOccDiDetailedInfo")
	public String susOccDiDetailedInfo(ModelMap model, HttpServletRequest request) {
		setCurrentUesrInfo(model, request);
		SusOccDisInfo susOccDiInfo =new SusOccDisInfo();
		susOccDiInfo.setInformeFlag("2");
		susOccDiInfo.setAdmissionOrganName(getCurrentOrg(request).getOrganName());
		model.addAttribute("susOccDiInfo", susOccDiInfo);
		return "rhip.hsa.susOccDi.detailedInfo";
	}
	/**
	 * 更新和查询可疑职业病人信息
	 * 
	 * @param id status
	 * @return
	 */
	@RequestMapping(value = "/updateOrSearchSusOccDisInfo")
	public String updateSusOccDisInfo(@RequestParam("id") Long id, @RequestParam("flag") String status, ModelMap model, HttpServletRequest request) {
		SusOccDisInfo susOccDiInfo = susOccDiService.searchSusOccDiDetialedInfo(id);
		model.addAttribute("susOccDiInfo", susOccDiInfo);
		setCurrentUesrInfo(model, request);
		if ("update".equals(status)) {
			return "rhip.hsa.susOccDi.detailedInfo";
		} else {
			return "rhip.hsa.susOccDi.searchView";
		}
	}

	/**
	 * 获取人员信息
	 * 
	 * @param idCard
	 * @return
	 */
	@RequestMapping("/loadPersonInfo")
	@ResponseBody
	public Object load(@RequestParam("idcard") String idCard) {
		PersonInfo personInfo = platformService.queryPersonalInfo(null, idCard);
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			return null;
		}
		Map<String, Object> record = new Record(personInfo);
		Date birthday = personInfo.getBirthday();
		if (ObjectUtil.isNullOrEmpty(birthday)) {
			String idcard = personInfo.getIdcard();
			if (ObjectUtil.isNotEmpty(idcard)) {
				// 如果没有生日,根据身份证算出
				birthday = IDCardUtil.getBirthDateByIdCard(idcard);
				personInfo.setBirthday(birthday);
			}
		}
		if (ObjectUtil.isNotEmpty(birthday)) {
			SimpleDateFormat df = new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN);
			Date date = new Date();
			int calculateAge = (int) ((date.getTime() - birthday.getTime()) / (24 * 60 * 60 * 1000));
			int age = Math.abs(calculateAge / 365);
			record.put("age", age);
			record.put("birthdayStr", df.format(birthday));
		}
		return record;
	}
	//默认加载时间和制定人
	private void setCurrentUesrInfo(ModelMap model, HttpServletRequest request) {
		model.put("currentDate", new Date());
		model.put("currentUserName", getCurrentUser(request).getName());
		model.put("currentOrgName", getCurrentOrg(request).getOrganName());
	}
	
	private Criteria createSearchCriteria(SusOccDisInfo susOccDisInfo, String town, String org) {
		Criteria criteria = new Criteria();
		// 姓名
		if (StringUtils.isNotEmpty(susOccDisInfo.getName()))
			criteria.add("name", OP.LIKE, susOccDisInfo.getName());
		// 身份证
		if (StringUtils.isNotEmpty(susOccDisInfo.getIdcard()))
			criteria.add("idcard", susOccDisInfo.getIdcard());
		// 性别
		if (StringUtils.isNotEmpty(susOccDisInfo.getGender())) {
			int genderCode = Integer.parseInt(susOccDisInfo.getGender());
			if (genderCode != -1)
				criteria.add("gender", susOccDisInfo.getGender());
		}
		if (StringUtils.isNotEmpty(town)&&!"_other".equals(town)) {
			criteria.add("createGbcode", town);
		}
		if (ObjectUtil.isNotEmpty(org) && !"null".equals(org)) {
			Criteria cr = new Criteria();
			cr.add("createCenterOrganCode", org);
			cr.add(LOP.OR, "createOrganCode", org);
			criteria.add(cr);
		}
		return criteria;
	}

	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}

}
