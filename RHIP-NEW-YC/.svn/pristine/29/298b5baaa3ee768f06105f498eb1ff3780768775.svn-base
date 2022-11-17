package com.founder.rhip.dref.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.dref.controller.form.DualReferralQueryForm;
import net.sf.cglib.beans.BeanMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.Base64Util;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;
import com.founder.rhip.ehr.service.IDualReferralService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDepartmentService;

@Controller
@RequestMapping(value = "/dref")
public class DualReferralController extends BaseController {

	@Resource
	private IDualReferralService dualReferralService;

	@Resource
	private IPlatformService platformService;

	@Resource
	private IDepartmentService departmentService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@RequestMapping("/search")
	public String search() {
		return "rhip.dref.search";
	}

	@RequestMapping("/list")
	public String list(HttpServletRequest request, ModelMap modelMap, int indexPage, DualReferralQueryForm form) {
		Page page = super.getPage(request, indexPage);
		Criteria criteria = form.toCriteria();
		if (hasRole(RoleType.Z_GLY, request) || hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.YY_GLY, request)) {
			Organization currentOrgan = getCurrentOrg(request);
            Criteria ca = new Criteria("destDeptCode", currentOrgan.getOrganCode());
            ca.add(LOP.OR, "referralHospitalCode" , currentOrgan.getOrganCode());
            criteria.add(ca);
		}
		PageList<ReferralInfo> list = dualReferralService.getPageList(page, criteria);
		modelMap.addAttribute("referralList", list.getList());
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("indexPage", indexPage);
		return "rhip.dref.list";
	}

	@RequestMapping("/edit")
	public String edit(HttpServletRequest request, ModelMap modelMap, Long id, String drefType) {
		if (id != null) {
			ReferralInfo referralInfo = dualReferralService.getReferralInfo(new Criteria("id", id));
			if (referralInfo != null) {
				List<Department> referralDeptList = departmentService.getDepartments(new Criteria("organCode", referralInfo.getReferralHospitalCode()));
				modelMap.addAttribute("referralDeptList", referralDeptList);
				modelMap.addAttribute("referral", referralInfo);
				drefType = referralInfo.getDualReferralType();
			}
		}
		Organization currentOrgan = getCurrentOrg(request);
		List<Department> destRoomList = departmentService.getDepartments(new Criteria("organCode", currentOrgan.getOrganCode()));
		modelMap.addAttribute("destRoomList", destRoomList);
		modelMap.addAttribute("drefType", drefType);
		modelMap.addAttribute("currentOrgan", currentOrgan);
		return "rhip.dref.edit";
	}

	@RequestMapping("/outEdit")
	public String outEdit(HttpServletRequest request, ModelMap model, Long id, String drefType) {
		Map<String, Object[]> map = this.decryptCharset(request, model);
        if(ObjectUtil.isNullOrEmpty(map)) {
        	return "rhip.idm.report.error";
        }
        Map<String, Object>  checkMap = checkInputParams(map);
        if(!(boolean)checkMap.get("result")){
            model.put("errorMessage", checkMap.get("message").toString());
            return "rhip.idm.report.error";
        }

        ReferralInfo referralInfo = setReferralInfo(map);
        model.put("referral", referralInfo);
        String organCode = (String) map.get("fromOrganCode")[0];//发起转出活转入的机构代码
        List<Department> destRoomList = departmentService.getDepartments(new Criteria("organCode", organCode));
        model.addAttribute("destRoomList", destRoomList);
        model.addAttribute("drefType", (String) map.get("fromType")[0]);
        Organization currentOrgan = organizationApp.queryOrgan(organCode);
        model.addAttribute("currentOrgan", currentOrgan);
		return "rhip.dref.edit.out";
	}
	
	private ReferralInfo setReferralInfo(Map<String, Object[]> map) {
		ReferralInfo referralInfo = new ReferralInfo();
		referralInfo.setIdCard((String) map.get("idcard")[0]);
		referralInfo.setName((String) map.get("name")[0]);
    	referralInfo.setGender((String) map.get("gender")[0]);
    	referralInfo.setBirthday(DateUtil.parseSimpleDate((String)map.get("birthday")[0], "yyyy/MM/dd"));
    	referralInfo.setDestDeptCode((String) map.get("fromOfficeCode")[0]);
    	referralInfo.setDestRoomCode((String) map.get("fromOrganCode")[0]);
    	referralInfo.setReferralDoctorName((String) map.get("doctor")[0]);
    	referralInfo.setReferralDoctorPhone((String) map.get("doctorTel")[0]);
		return referralInfo;
	}
	 /**
     * 判断编码规则
     */
    private Map<String, Object[]> decryptCharset(HttpServletRequest request, ModelMap model) {
    	//先用UTF-8解析看有没有编码参数
        Map<String, Object[]> map = null;
        String parameters = "";
        parameters = Base64Util.decrypt((request.getQueryString()), "UTF-8");

        if (ObjectUtil.isNotEmpty(parameters)){
            try{
                map = convertQueryToReport(parameters);
            }catch (Exception e) {
                logger.error("报卡上报接口,参数解析失败", e);
                model.put("errorMessage", "报卡上报接口,参数解析失败");
            }
        }
        //以下判断按照什么编码原则解析参数
        String charsetName = "";
        charsetName = getFieldValue(map, "charsetName");
        //没有编码参数默认是GB2312
        if (!ObjectUtil.isNotEmpty(charsetName)) {
            // 默认中文编码是GB2312
            parameters = Base64Util.decrypt((request.getQueryString()), "GB2312");
        }
        //由编码参数但是不是UTF-8
        else if(!charsetName.equalsIgnoreCase("UTF-8")){
            parameters = Base64Util.decrypt((request.getQueryString()), charsetName);
        }
      //以下按照什么编码原则分拆参数
        try {
            if (ObjectUtil.isNotEmpty(parameters) && !ObjectUtil.isNotEmpty(charsetName)) {
                map = convertQueryToReport(parameters);
            }else if(ObjectUtil.isNotEmpty(parameters) && !charsetName.equalsIgnoreCase("UTF-8")){
                map = convertQueryToReport(parameters);
            }
        } catch (Exception e) {
            logger.error("参数解析失败", e);
            model.put("errorMessage", "参数解析失败");
            return null;
        }
        return map;
    }
    
    /**
     * 将报卡参数字符串转换为map
     *
     * @param query
     * @return
     */
    private Map<String, Object[]> convertQueryToReport(String query) {
        Map<String, Object[]> map = new HashMap<String, Object[]>();
        String params[] = query.split("&");
        for (String param : params) {
            if (param.indexOf("=") > 0) {
                String keyValues[] = param.split("=");
                if (keyValues.length == 2) {
                    String value=keyValues[1] ;
                    value=value==null?"":value.trim();
                    map.put(keyValues[0], new Object[] { value});
                } else if (keyValues.length == 1) {
                    map.put(keyValues[0], new Object[] { "" });
                }
            }
        }
        return map;
    }
    
    /**
     * map中获取String值 ,null则返回""
     *
     * @param map
     * @param key
     * @return
     */
    private String getFieldValue(Map<String, Object[]> map, String key) {
        if (!map.containsKey(key)) {
            return "";
        }
        return map.get(key)[0].toString();
    }
    
    public Map<String, Object>  checkInputParams(Map<String, Object[]> map){
        boolean result = true;
        StringBuilder message = new StringBuilder();
        Map<String, Object> checkMap = new HashMap<String, Object>();
        String charsetName = ObjectUtil.isNotEmpty(map.get("charsetName"))?(String)map.get("charsetName")[0]:"";
        String name = ObjectUtil.isNotEmpty(map.get("name"))?(String)map.get("name")[0]:"";
        String idcard = ObjectUtil.isNotEmpty(map.get("idcard"))?(String)map.get("idcard")[0]:"";
        String gender = ObjectUtil.isNotEmpty(map.get("gender"))?(String)map.get("gender")[0]:"";
        String birthday = ObjectUtil.isNotEmpty(map.get("birthday"))?(String)map.get("birthday")[0]:"";

        String doctor = ObjectUtil.isNotEmpty(map.get("doctor"))?(String)map.get("doctor")[0]:"";
        String doctorTel = ObjectUtil.isNotEmpty(map.get("doctorTel"))?(String)map.get("doctorTel")[0]:"";
        
        String fromOrganCode = ObjectUtil.isNotEmpty(map.get("fromOrganCode"))?(String)map.get("fromOrganCode")[0]:"";
        /*1：转出单 2：回转单*/
        String fromType = ObjectUtil.isNotEmpty(map.get("fromType"))?(String)map.get("fromType")[0]:"";
        String fromOfficeCode = ObjectUtil.isNotEmpty(map.get("fromOfficeCode"))?(String)map.get("fromOfficeCode")[0]:"";

        if(StringUtil.isNullOrEmpty(charsetName)){
            result = false;
            message.append("参数charsetName不正确    ");
        }
        if(StringUtil.isNullOrEmpty(name)){
            result = false;
            message.append("参数name不正确    ");
        }
        if(StringUtil.isEmpty(idcard)){
            result = false;
            message.append("参数idcard不正确    ");
        }
        if(StringUtil.isNullOrEmpty(gender)){
            result = false;
            message.append("参数gender不正确    ");
        }
        if(StringUtil.isNullOrEmpty(birthday)){
            result = false;
            message.append("参数birthday不正确    ");
        }
        /*if(StringUtil.isNullOrEmpty(doctor) || doctor.length()>16){
            result = false;
            message.append("参数doctor不正确    ");
        }*/

        if(StringUtil.isNullOrEmpty(fromOrganCode)){
            result = false;
            message.append("参数fromOrganCode不正确    ");
        }
       if(StringUtil.isNullOrEmpty(fromType) || ((!fromType.equals("0"))&&(!fromType.equals("1")))){
            result = false;
            message.append("参数fromType不正确    ");
        }
       /*  if(StringUtil.isNullOrEmpty(fromOfficeCode)){
            result = false;
            message.append("参数fromOfficeCode不正确    ");
        }*/

        checkMap.put("result", result);
        checkMap.put("message", message);
        return checkMap;
    }

    
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap save(HttpServletRequest request, ReferralInfo referralInfo, String from) {
		ModelMap modelMap = new ModelMap();
		actionRecord(request, referralInfo);
		referralInfo.setIsDelete(0);
		referralInfo.setIntegratedData(0);
        //转诊状态 0：未接诊
        referralInfo.setReferralStatus(0);
        //转诊来源 2：平台
        referralInfo.setReferralSource(2);
        //转诊唯一码 18位唯一码
        referralInfo.setReferralCode(getReferralCode());
		try {
			int result = dualReferralService.save(referralInfo);
			if ("explore".equals(from)) {
				modelMap.addAttribute("explore", true);
			} else {
				createOperationLog(request, RhipModuleName.DREF, "市内转诊", referralInfo.getId() == null? OperationName.ADD:OperationName.UPDATE);
				modelMap.addAttribute("explore", false);
			}
			if (result != 0) {
				modelMap.addAttribute("success", true);
				modelMap.addAttribute("message", "保存成功！");
			} else {
				modelMap.addAttribute("success", false);
				modelMap.addAttribute("message", "保存失败！");
			}
			modelMap.addAttribute("id", result);
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", "保存失败！" + e.getMessage());
		}
		return modelMap;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ModelMap delete(HttpServletRequest request, Long id) {
		ModelMap modelMap = new ModelMap();
		ReferralInfo referralInfo = new ReferralInfo();
		referralInfo.setId(id);
		actionRecord(request, referralInfo);
		try {
			int result = dualReferralService.delete(referralInfo);
            createOperationLog(request, RhipModuleName.DREF, "市内转诊", OperationName.DELETE);
			if (result != 0) {
				modelMap.addAttribute("success", true);
				modelMap.addAttribute("message", "删除成功！");
			} else {
				modelMap.addAttribute("success", false);
				modelMap.addAttribute("message", "删除失败！");
			}
		} catch (Exception e) {
			modelMap.addAttribute("success", false);
			modelMap.addAttribute("message", "删除失败！" + e.getMessage());
		}
		return modelMap;
	}

	@RequestMapping("/print1")
    public String print1(HttpServletRequest request, ModelMap modelMap, Long id) {
        if (id != null) {
        	ReferralInfo referralInfo = dualReferralService.getReferralInfo(new Criteria("id", id));
            modelMap.addAttribute("referral", referralInfo);
            modelMap.addAttribute("drefType", referralInfo.getDualReferralType());
        }
        return "rhip.dref.referral.print1";
    }

    @RequestMapping("/print2")
    public String print2(HttpServletRequest request, ModelMap modelMap, Long id) {
        if (id != null) {
        	ReferralInfo referralInfo = dualReferralService.getReferralInfo(new Criteria("id", id));
            modelMap.addAttribute("referral", referralInfo);
            modelMap.addAttribute("drefType", referralInfo.getDualReferralType());
        }
        return "rhip.dref.referral.print2";
    }
    
	@RequestMapping("/view")
	public String view(ModelMap modelMap, Long id) {
		ReferralInfo referralInfo = dualReferralService.getReferralInfo(new Criteria("id", id));
		modelMap.addAttribute("referral", referralInfo);
		modelMap.addAttribute("drefType", referralInfo.getDualReferralType());
		return  "rhip.dref.view";
	}

	@RequestMapping("/getPersonInfo")
	@ResponseBody
	public Object getPersonInfo(String idCard) {
		PersonInfo personInfo = platformService.queryPersonalInfo(null, idCard);
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			return null;
		}
		Record record = new Record(personInfo);
		Date birthday = personInfo.getBirthday();
		if (ObjectUtil.isNotEmpty(birthday)) {
			SimpleDateFormat df = new SimpleDateFormat(EHRConstants.COMMON_DATE_PATTERN);
			record.put("birthdayStr", df.format(birthday));
		}
		return record;
	}

	private void actionRecord(HttpServletRequest request, Object entity) {
		BeanMap beanMap = BeanMap.create(entity);
		Date date = new Date();
		beanMap.put("updatePerson", "saas");
		beanMap.put("updateOrgan", beanMap.get("destDeptCode"));
		beanMap.put("updateTime", date);
	}

    /***
     * 生成18位转诊唯一码
     * @return
     */
    private String getReferralCode() {
        long current = System.currentTimeMillis();
        String k  =String.valueOf(current);
        int length = 5;
        for (int i = 0; i < length; i++) {
            int temp = (int) (Math.random() * 9);
            k = k + temp;
        }
        return k;
    }
}
