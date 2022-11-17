package com.founder.rhip.ehr.controller.ehrbrowser;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.FileUtils;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfoAdditional;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.ta.TargetResultValue;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.ta.ITargetService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 主页
 * 
 * @author liuk
 */
@Controller
@RequestMapping("/ehrbrowser")
public class BrwIndexController extends BaseController {

	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;

	@Resource(name = "targetService")
	private ITargetService targetService;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService personalRecordManagmentService;

	@RequestMapping("/index/{id}")
	public String index(@PathVariable("id") Long id, @RequestParam(value = "password", required = false) String password, @RequestParam(value = "cicIdCard", required = false) String cicIdCard, ModelMap model, HttpServletRequest request) {
		model.addAttribute("personId", id);
		PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("id", id), "id", "encryptionFlag", "decryptionPassword", "idcard");
		model.addAttribute("region", request.getParameter("region"));// 用在页面判断返回
		model.addAttribute("cdm", request.getParameter("cdm"));// 慢病随访模块调用，用在页面判断返回
		if (null != personInfo) {
			model.addAttribute("personId", personInfo.getId());
			model.addAttribute("personIdcard", personInfo.getIdcard());

			// 健康档案查阅权限
			int cicResult = checkCic(personInfo, cicIdCard, model, request);
			if (cicResult != 1 && cicResult != 2) {
				return checkCicAndReturn(cicResult, model);
			}

			// 加密检查
			int accessResult = checkAccess(personInfo, password);
			if (accessResult != 0 && accessResult != 2) {
				return checkAccessResultAndReturn(accessResult, model);
			}
			//添加水印文字内容
			String waterMarkTxt = getOperatorName()+" "+getRequestIp(request);
			model.addAttribute("waterMarkTxt", waterMarkTxt);
			return "rhip.ehr.browser.index";
		} else {
			model.addAttribute("message", "没有该身份证关联的健康档案信息");
			return "rhip.ehr.browser.index.error";
		}
	}

	@RequestMapping("/index/idCard/{idCard}")
	public String index2(@PathVariable("idCard") String idCard, @RequestParam(value = "password", required = false) String password, @RequestParam(value = "cicIdCard", required = false) String cicIdCard, ModelMap model, HttpServletRequest request) {
		if (ObjectUtil.isNotEmpty(idCard)) {
			PersonInfo personInfo = personalRecordService.getPersonRecord(new Criteria("idcard", idCard), "id","idcard");
			if (null != personInfo) {
				model.addAttribute("personId", personInfo.getId());
				model.addAttribute("personIdcard", personInfo.getIdcard());

				// 健康档案查阅权限
				int cicResult = checkCic(personInfo, cicIdCard, model, request);
				if (cicResult != 1 && cicResult != 2 && !hasRole(RoleType.ADMIN,request)) {
					return checkCicAndReturn(cicResult, model);
				}

				// 加密检查
				int accessResult = checkAccess(personInfo, password);
				if (accessResult != 0 && accessResult != 2 && hasRole(RoleType.ADMIN,request)) {
					return checkAccessResultAndReturn(accessResult, model);
				}

				return "rhip.ehr.browser.index";
			} else {
				model.addAttribute("message", "没有该身份证关联的健康档案信息");
				return "rhip.ehr.browser.index.error";
			}
		} else {
			model.addAttribute("message", "身份证不能为空");
			return "rhip.ehr.browser.index.error";
		}
	}

	private String checkAccessResultAndReturn(int result, ModelMap model) {
		String page = "rhip.ehr.browser.index.access";
		switch (result) {
		case 1: {
			model.put("accessMessage", "请输入密码");
			break;
		}
		case 3: {
			model.put("accessMessage", "密码错误");
			break;
		}
		case 99: {
			model.put("accessMessage", "无法验证密码,请联系管理员");
			break;
		}
		default: {
			model.put("accessMessage", "发生未知错误");
		}
		}
		return page;
	}

	private int checkAccess(PersonInfo personInfo, String password) {
		return personalRecordManagmentService.checkRecordAccess(personInfo, password);
	}

	private String checkCicAndReturn(int result, ModelMap model) {
		String page = "rhip.ehr.browser.index.check";
		switch (result) {
		case 3: {
			model.put("checkMessage", "请刷市民卡!");
			break;
		}
		case 4: {
			model.put("checkMessage", "当前人员无身份证信息,请检查是否已经建档!");
			break;
		}
		case 5: {
			model.put("checkMessage", "市民卡身份证与当前信息不匹配!");
			break;
		}

		}
		return page;
	}

	private int checkCic(PersonInfo personInfo, String cicIdCard, ModelMap model, HttpServletRequest request) {
		User user=getCurrentUser(request);
		String cicPermission=null;
		if(user!=null){
			cicPermission=user.getCicPermission();
		}
		String idCard = personInfo.getIdcard();
		// 刷卡检查
		if(!EHRConstants.CIC_PERMISSION.equals(cicPermission) && ObjectUtil.isNotEmpty(cicPermission)) {
			return 3;
		}
		if (ObjectUtil.isNullOrEmpty(idCard)) {
			return 4;// 请建档
		}
		return 1;// 检查ok
	}

	@RequestMapping("/hbpchart")
	public String getHbpTargets(@RequestParam("personId") Long personId, Model model) {
		model.addAttribute("personId", personId);
		return "rhip.ehr.browser.index.hbpchart";
	}

	@RequestMapping("/hbpdata")
	@ResponseBody
	public Object getHbpTargets(@RequestParam("personId") Long personId) {
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("createDate", OP.UEMPTY, "");
		criteria.add("valueA", OP.UEMPTY, "");
		criteria.add("valueB", OP.UEMPTY, "");
		Order order = new Order("CREATE_DATE");
		Set<String> select = new HashSet<>(Arrays.asList("valueA", "valueB", "createDate", "createOrganCode", "type"));
		List<TargetResultValue> targetResultValues = targetService.queryTargetResultValues(null, criteria, order, select);
		List<Object[]> sp = new ArrayList<>(targetResultValues.size());
		List<Object[]> dp = new ArrayList<>(targetResultValues.size());
		Map<String, List<Object[]>> result = new HashMap<>(2);
		result.put("sp", sp);
		result.put("dp", dp);
		for (TargetResultValue value : targetResultValues) {
			Date date = value.getCreateDate();
			if (null != date) {
				Long time = date.getTime();
				BigDecimal a = value.getValueA();
				if (null != a) {
					Object[] data = new Object[4];
					data[0] = time;
					data[1] = a;
					data[2] = value.getType();
					data[3] = ObjectUtil.isNullOrEmpty(value.getCreateOrganCode()) ? "" : organizationApp.queryOrganName(value.getCreateOrganCode());
					sp.add(data);
				}
				BigDecimal b = value.getValueB();
				if (null != b) {
					Object[] data = new Object[4];
					data[0] = time;
					data[1] = b;
					data[2] = value.getType();
					data[3] = ObjectUtil.isNullOrEmpty(value.getCreateOrganCode()) ? "" : organizationApp.queryOrganName(value.getCreateOrganCode());
					dp.add(data);
				}
			}
		}
		return result;
	}

	@RequestMapping("/dichart")
	public String getDiTargets(@RequestParam("personId") Long personId, Model model) {
		model.addAttribute("personId", personId);
		return "rhip.ehr.browser.index.dichart";
	}

	@RequestMapping("/didata")
	@ResponseBody
	public Object getDiTargets(@RequestParam("personId") Long personId) {
		Criteria criteria = new Criteria("personId", personId);
		criteria.add("createDate", OP.UEMPTY, "");
		Criteria or = new Criteria("valueC", OP.UEMPTY, "");
		or.add(LOP.OR, "valueD", OP.UEMPTY, "");
		criteria.add(or);
		Order order = new Order("CREATE_DATE");
		Set<String> select = new HashSet<>(Arrays.asList("valueC", "valueD", "createDate", "createOrganCode", "type"));
		List<TargetResultValue> targetResultValues = targetService.queryTargetResultValues(null, criteria, order, select);
		List<Object[]> fbg = new ArrayList<>(targetResultValues.size());
		List<Object[]> pbg = new ArrayList<>(targetResultValues.size());
		Map<String, List<Object[]>> result = new HashMap<>(1);
		result.put("fbg", fbg);
		result.put("pbg", pbg);
		for (TargetResultValue value : targetResultValues) {
			Date date = value.getCreateDate();
			if (null != date) {
				Long time = date.getTime();
				BigDecimal a = value.getValueC();
				if (null != a) {
					Object[] data = new Object[4];
					data[0] = time;
					data[1] = a;
					data[2] = value.getType();
					data[3] = ObjectUtil.isNullOrEmpty(value.getCreateOrganCode()) ? "" : organizationApp.queryOrganName(value.getCreateOrganCode());
					fbg.add(data);
				}
				BigDecimal b = value.getValueD();
				if (null != b) {
					Object[] data = new Object[4];
					data[0] = time;
					data[1] = b;
					data[2] = value.getType();
					data[3] = ObjectUtil.isNullOrEmpty(value.getCreateOrganCode()) ? "" : organizationApp.queryOrganName(value.getCreateOrganCode());
					pbg.add(data);
				}
			}
		}
		return result;
	}

	/**
	 * 在线显示居民头像
	 * @param idcard
	 * @param type
	 * @param response
	 */
	@RequestMapping("/showPhoto/{idcard}")
	public void showPhoto(@PathVariable String idcard, Integer type, HttpServletResponse response) {
		if(StringUtil.isNullOrEmpty(idcard)){
			return;
		}
		PersonInfoAdditional personInfoAdditional = personalRecordService.getPersonInfoAdditional(idcard);
		try {
			if(ObjectUtil.isNullOrEmpty(personInfoAdditional)){
				//取得绝对路径
				String filePath = this.getClass().getResource("/").toString().replaceAll("^file:", "");
				String avatar = filePath +  "../../resources/images/128.gif";
				InputStream in = new FileInputStream(avatar);
				BufferedImage bufferedImage = ImageIO.read(in);
				OutputStream outputStream = response.getOutputStream();
				ImageIO.write(bufferedImage, StringUtils.substringAfterLast(avatar, "."), outputStream);
				outputStream.flush();
				outputStream.close();
			}else {
				outputImage(personInfoAdditional, response);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

	/**
	 * 输出图片
	 * @param personInfoAdditional
	 * @param response
	 */
	private void outputImage(PersonInfoAdditional personInfoAdditional, HttpServletResponse response){
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(personInfoAdditional.getPhoto());
			BufferedImage bufferedImage = ImageIO.read(in);
			OutputStream outputStream = response.getOutputStream();
			ImageIO.write(bufferedImage, "bmp", outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
