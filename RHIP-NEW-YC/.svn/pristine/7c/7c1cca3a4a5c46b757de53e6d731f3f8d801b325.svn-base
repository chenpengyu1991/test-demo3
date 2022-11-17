package com.founder.rhip.portal.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.PortalSetType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.entity.portal.SMS;
import com.founder.rhip.ehr.repository.portal.ISMSDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.portal.common.EmailAccount;
import com.founder.rhip.portal.service.IAccountInfoService;
import com.founder.rhip.portal.service.IPortalSetService;
import com.founder.rhip.portal.service.util.SMSUtil;
import com.founder.rhip.portal.util.RandomValidateCodeUtil;
import com.founder.rhip.portal.util.SendEmailUtil;

@Controller
@RequestMapping(value = "/regedit")
public class RegeditController {
	@Resource(name = "lhaccountInfoService")
	private IAccountInfoService accountInfoService;

	@Resource(name = "portalSetService")
	private IPortalSetService portalSetService;
	
	@Autowired
	private IPlatformService personService;
	
	@Resource(name = "lhsmsDao")
	private ISMSDao smsDao;
	
	@RequestMapping(value = "/toRegedit")
	public String toRegedit(HttpServletRequest request, Model model) {
		return "portal.info.selectMode";
	}
	
	@RequestMapping(value = "/haveCard")
	public String haveCard(HttpServletRequest request, Model model) {
		return "portal.info.citizenCard";
	}
	
	@RequestMapping(value = "/regeditPage")
	public String regeditPage(Model model,Long personId) {
		Criteria criteria = new Criteria("id",personId);
		PersonInfo personInfo = personService.queryPersonalInfo(criteria);
		model.addAttribute("personInfo", personInfo);
		return "portal.info.regedit";
	}
	
	@RequestMapping(value = "/loadPersonInfo")
	public @ResponseBody String loadPersonInfo(String idcardNo,String citizenCardNo) {
		Criteria criteria = new Criteria("CITIZEN_CARD_NO",citizenCardNo).add("IDCARD", idcardNo);
		PersonInfo personInfo = personService.queryPersonalInfo(criteria);
		if(ObjectUtil.isNotEmpty(personInfo)){
			return personInfo.getId().toString();
		}
		return "0";
	}

	@RequestMapping(value = "/toFindPassword")
	public String toFindPassword(HttpServletRequest request, Model model) {
		return "lhportal.info.findPassword";
	}

	@RequestMapping(value = "/checkEmail")
	@ResponseBody
	public ModelMap checkEmail(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		String accountName = request.getParameter("accountName");
		if (StringUtil.isEmpty(accountName)) {
			model.addAttribute("msg", "账户名不能为空!");
		} else {
			Criteria criteria = null;
			if(accountName.indexOf("@")==-1)
				criteria = new Criteria("accountName", accountName);
			else
				criteria = new Criteria("email", accountName);
			AccountInfo accountInfo = accountInfoService.get(criteria);
			if (null == accountInfo) {
				model.addAttribute("msg", "请输入正确的邮箱或用户名!");
			} else {
				String email = accountInfo.getEmail();
				String suffx = email.split("@")[0];
				suffx = suffx.charAt(0) + "****" + suffx.subSequence(suffx.length() - 1, suffx.length());
				suffx = suffx + "@" + email.split("@")[1];
				model.addAttribute("email", suffx);
				model.addAttribute("success", true);
			}
		}
		return model;
	}

	@RequestMapping(value = "/commitFindPwd")
	@ResponseBody
	public ModelMap commitFindPwd(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		String accountName = request.getParameter("accountName");
		String checkCode = request.getParameter("checkCode");
		String sessionCheckCode = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
		 if (!sessionCheckCode.equals(checkCode.toUpperCase())) {
				model.addAttribute("msg", "验证码错误!");
			} 
		else if (StringUtil.isEmpty(accountName)) {
			model.addAttribute("msg", "用户名不存在!");
		} 
		else {
			Criteria criteria = null;
			if(accountName.indexOf("@")==-1)
				criteria = new Criteria("accountName", accountName);
			else
				criteria = new Criteria("email", accountName);
			AccountInfo accountInfo = accountInfoService.get(criteria);
			if (null == accountInfo) {
				model.addAttribute("msg", "请输入正确的邮箱或用户名!");
			} else {
				String pwd = MD5Encoder.generateRandomPassword();
				accountInfo.setPassword(MD5Encoder.getMD5Str(pwd));
				accountInfoService.update(accountInfo);
				String email = accountInfo.getEmail();
				String suffx = email.split("@")[1].split("\\.")[0];
				String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/regedit/toNewPasswordPage?accountName=" + accountName;
				model.addAttribute("emailUrl", "http://mail." + suffx + ".com");
				model.addAttribute("msg", "是否现在登入邮箱,完成密码修改?");
				model.addAttribute("url", url);
				EmailAccount EMAIL_ACCOUNT = getEmailAccount();
				SendEmailUtil.sendHtml(EMAIL_ACCOUNT,accountInfo.getEmail(), "银川市医疗卫生公众服务平台-密码找回", "请您尽快修改您的账户密码。<br/>账户:"+accountInfo.getAccountName() +"<br/>密码："+pwd);
				model.addAttribute("success", true);
			}
		}
		return model;
	}

	/***
	 * 发送验证码至手机
	 * @param request
	 * @return
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/checkCodeSendPhone")
	@ResponseBody
	public ModelMap checkCode2Phone(HttpServletRequest request) {
		ModelMap model = new ModelMap();
        //修正抓包bug
        String accountName = request.getParameter("accountName");
        Criteria criteria = new Criteria("accountName",accountName);
        AccountInfo accountInfo = accountInfoService.get(criteria);
		String telphone= request.getParameter("telephone");
		if(StringUtil.isEmpty(telphone)){
			model.addAttribute("msg", "手机号码为空");
			return model;
		}
		//防止修改post参数
		if (!telphone.equals(accountInfo.getTelephone())){
		    telphone = accountInfo.getTelephone();
        }
		Random random = new Random();
		Integer num = random.nextInt(899999)+100000;
		String check_code=String.valueOf(num);
		Map<String,String> smsMap = new HashMap<String,String>();
		smsMap.put("CHECK_CODE",check_code);
		SMSUtil smsUtil= new SMSUtil();
		String content=smsUtil.createSMSContent(smsMap,SMSUtil.MODE_TYPE_2);
		boolean rs = true;
        String result ="";
        result = smsUtil.send(content, telphone);
        if(!"Success".equals(result)){
        	rs = false;
        }
        if(rs){
			SMS sms=new SMS();
			sms.setContent(content);
			sms.setName(request.getParameter("realName"));
			sms.setPhoneNumber(telphone);
			sms.setType(SMSUtil.MODE_TYPE_2);
			sms.setCreateTime(new Date());
			smsDao.insert(sms);
		}
		model.addAttribute("rs", rs);
		model.addAttribute("code",MD5Encoder.getMD5Str(check_code));
		//TODO 将短信内容存入库中
		return model;
	}
	
	/***
	 * 发送验证码至邮箱
	 * @param request
	 * @return
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/checkCodeSendEmail")
	@ResponseBody
	public ModelMap checkCode2Email(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		String email= request.getParameter("email");
        //修正抓包bug
        String accountName = request.getParameter("accountName");
        Criteria criteria = new Criteria("accountName",accountName);
        AccountInfo accountInfo = accountInfoService.get(criteria);
		if(StringUtil.isEmpty(email)){
			model.addAttribute("msg", "Email为空");
			return model;
		}
        if(!email.equals(accountInfo.getEmail())){
            email = accountInfo.getEmail();
        }
		Random random = new Random();
		Integer num=random.nextInt(899999)+100000;
		String check_code=String.valueOf(num);
		Map<String,String> map = new HashMap<String,String>();
		map.put("CHECK_CODE",check_code);
		SMSUtil smsUtil=new SMSUtil();
		EmailAccount emailAccount = getEmailAccount();
		String content=smsUtil.createSMSContent(map,SMSUtil.MODE_TYPE_3);
		SendEmailUtil.sendHtml(emailAccount,email, "健康门户服务网-注册验证码",content);
		model.addAttribute("rs", true);
		model.addAttribute("code",MD5Encoder.getMD5Str(check_code));
		model.addAttribute("email", email);
		return model;   
	}
	@RequestMapping(value = "/commitFindPwdStep1")
	public String commitFindPwdStep1(HttpServletRequest request) {
		String msg_jsp="lhportal.info.msg";
		String current_jsp="lhportal.info.findPassword";
		String accountName = request.getParameter("accountName");
		String checkCode = request.getParameter("checkCode");
		String sessionCheckCode = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
		if (StringUtil.isEmpty(accountName)||StringUtil.isEmpty(checkCode)) {
			request.setAttribute("msgVo", "您访问的页面已过期");
			return msg_jsp;
		} 
		if(!checkCode.toUpperCase().equals(sessionCheckCode)) {
			request.setAttribute("accountName",accountName);
			request.setAttribute("checkCodemsg", "验证码错误!");
			return current_jsp;
		}
		Criteria criteria  = new Criteria("accountName", accountName);
		AccountInfo accountInfo = accountInfoService.get(criteria);
		//查询为空则用身份证号
		if (null == accountInfo) {
			criteria = new Criteria("cardNo", accountName);
			accountInfo = accountInfoService.get(criteria);
		}
		if (null == accountInfo) {
			request.setAttribute("userMsg", "用户名不存在!");
			request.setAttribute("accountName",accountName);
			return current_jsp;
		}
		String tel = accountInfo.getTelephone();
        String email = accountInfo.getEmail();
        if(StringUtil.isNotEmpty(email)) {
            String regex = "(\\w{3})(\\w+)(\\w{3})(@\\w+)";
            email = email.replaceAll(regex, "$1***$3$4");
        }
        if(StringUtil.isNotEmpty(tel)) {
            tel = tel.replace(tel.substring(3, 7), "****");
        }
		accountInfo.setPhoneWithStar(tel);
		accountInfo.setEmailWithStar(email);
		request.setAttribute("accountInfo", accountInfo);
		request.setAttribute("checkCode", checkCode);
		return "lhportal.info.findPasswordStep2";
	}
	
	@RequestMapping(value = "/commitFindPwdStep2")
	public String commitFindPwdStep2(HttpServletRequest request) {
		String msg_jsp="lhportal.info.msg";
		String current_jsp="lhportal.info.findPasswordStep2";
		String md5Code = request.getParameter("code");
		String checkCode = request.getParameter("checkCodes");
		String accountName = request.getParameter("accountName");
		String telephone= request.getParameter("telephone");
		String email= request.getParameter("email");
		if (StringUtil.isEmpty(checkCode)||StringUtil.isEmpty(md5Code)||StringUtil.isEmpty(accountName)) {
			request.setAttribute("msgVo", "您访问的页面已过期");
			return msg_jsp;
		} 
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountName(accountName);
		accountInfo.setTelephone(telephone);
		accountInfo.setPhoneWithStar(telephone);
		accountInfo.setEmailWithStar(email);
		accountInfo.setEmail(email);
		request.setAttribute("accountInfo", accountInfo);
		if(!MD5Encoder.getMD5Str(checkCode).equals(md5Code)) {	
			request.setAttribute("msg", "验证码错误!");
			request.setAttribute("code", md5Code);
			return current_jsp;
		}
		return "lhportal.info.findPasswordStep3";
	}

	@RequestMapping(value = "/commitFindPwdStep3")
	public String commitFindPwdStep3(HttpServletRequest request) {
		String msg_jsp="lhportal.info.msg";
		String accountName = request.getParameter("accountName");
		String password= request.getParameter("password");
		if (StringUtil.isEmpty(accountName)||StringUtil.isEmpty(password)) {
			request.setAttribute("msgVo", "您访问的页面已过期");
			return msg_jsp;
		} 
		Criteria criteria = new Criteria("accountName", accountName);
		AccountInfo accountInfo = accountInfoService.get(criteria);
		accountInfo.setPassword(MD5Encoder.getMD5Str(password));
		accountInfoService.update(accountInfo);
		request.setAttribute("msg", "新密码重置成功");
		return "lhportal.info.findPasswordStep4";
	}
	
	private EmailAccount getEmailAccount(){
		HashMap<String,String> map = portalSetService.getSetByType(PortalSetType.SEND_EMAIL.getValue());
		String host = map.get("email_host");
		String user = map.get("email_user");
		String userEmail = map.get("email");
		String pwd = map.get("email_pwd");
		return new EmailAccount(host, user, userEmail, pwd);
	}
	
	@RequestMapping(value = "/toNewPasswordPage")
	public String toNewPasswordPage(HttpServletRequest request) {
		String accountName = request.getParameter("accountName");
		request.setAttribute("accountName", accountName);
		return "lhportal.info.toNewPasswordPage";
	}

	@RequestMapping(value = "/commitNewPwd")
	@ResponseBody
	public ModelMap commitNewPwd(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		String accountName = request.getParameter("accountName");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("checkCode");
		String sessionCheckCode = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
		if (!sessionCheckCode.equals(checkCode.toUpperCase())) {
			model.addAttribute("msg", "验证码错误!");
			return model;
		}
		Criteria criteria = new Criteria("accountName", accountName);
		AccountInfo accountInfo = accountInfoService.get(criteria);
		accountInfo.setPassword(MD5Encoder.getMD5Str(password));
		accountInfoService.update(accountInfo);
		model.addAttribute("msg", "恭喜,密码修改成功,请牢记新密码!");
		model.addAttribute("success", true);
		return model;
	}
}
