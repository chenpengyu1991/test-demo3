package com.founder.rhip.portal.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.PortalSetType;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.BirthCertificate;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.entity.portal.SMS;
import com.founder.rhip.ehr.repository.portal.ISMSDao;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.portal.common.Constants;
import com.founder.rhip.portal.common.EmailAccount;
import com.founder.rhip.portal.common.OperationName;
import com.founder.rhip.portal.service.IAccountInfoService;
import com.founder.rhip.portal.service.IPortalSetService;
import com.founder.rhip.portal.service.util.SMSUtil;
import com.founder.rhip.portal.util.PropertiesUtils;
import com.founder.rhip.portal.util.RandomValidateCodeUtil;
import com.founder.rhip.portal.util.SendEmailUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.*;

@Controller
@RequestMapping(value = "/accountInfo")
public class AccountInfoController extends BaseController {

    @Resource(name = "lhaccountInfoService")
    private IAccountInfoService accountInfoService;

    @Resource(name = "personInfoService")
	private IPersonInfoService personInfoService;

    @Resource(name = "platformService")
    private IPlatformService platformService;
    
    @Resource(name = "portalSetService")
    private IPortalSetService portalSetService;

    @Autowired
    private IPersonalRecordService personalRecordService;

    @Resource
    private IBrwHealthService brwHealthService;

    @Resource(name = "personalRecordManagmentService")
    private IPersonalRecordManagmentService personalRecordManagmentService;
    
    @Resource(name = "lhsmsDao")
	private ISMSDao smsDao;

    @RequestMapping(value = "/toRegister")
    public String toRegister(HttpServletRequest request, ModelMap model) {
        return "common.underConstruction";
/*        return "lhportal.info.register";*/
    }

    /**
     * 注册的第一步
     *
     * @param request
     * @param accountInfo
     * @return
     */
    @RequestMapping(value = "/registerStep1")
    @ResponseBody
    public ModelMap checkCode(HttpServletRequest request, AccountInfo accountInfo) {
        ModelMap model = new ModelMap();
        String telphone = accountInfo.getTelephone();
        model.addAttribute("telephone", telphone);
        model.addAttribute("success", true);
        return model;
    }

    /**
     * 注册第二步
     *
     * @param request
     * @param accountInfo
     * @return
     */
    @RequestMapping(value = "/registerStep2")
    @ResponseBody
    public ModelMap toRegister(HttpServletRequest request, AccountInfo accountInfo) {
        ModelMap model = new ModelMap();
        String registerCode = (String) request.getParameter("registerCode").trim();
        if(ObjectUtil.isNullOrEmpty(request.getSession().getAttribute("registerCodeSession"))){
    		model.addAttribute("msg", "先获取验证码！");
            model.addAttribute("success", false);
            return model;
    	}
        if (ObjectUtil.isNotEmpty(registerCode)) {
            //获取session中registerCodeSession的值
            String registerCodeSession = (String) request.getSession().getAttribute("registerCodeSession");
            if (registerCodeSession.equals(registerCode)) {
                if (createPerson(request, accountInfo)) {
                    accountInfo.setActivateStatus("1");//0：未激活，1：激活
                    accountInfo.setPassword(MD5Encoder.getMD5Str(accountInfo.getPassword()));
                    accountInfo.setStatus("1");//1：启用,0：禁用
                    accountInfo.setReserveStatus("1");//1：启用预约,0：禁用预约
                    accountInfoService.insert(accountInfo);
                    model.addAttribute("success", true);
                    createOperationLog(request, RhipModuleName.LHPORTAL, "toRegister", OperationName.CREATE_PERSON);
                    return model;
                } else {
                    model.addAttribute("msg", "未成功创建健康档案，注册失败！");
                    model.addAttribute("success", false);
                }
            } else {
                model.addAttribute("msg", "注册码错误！");
                model.addAttribute("success", false);
                return model;
            }
        }
        model.addAttribute("msg", "注册码不能为空！");
        model.addAttribute("success", false);
        return model;
    }

    /**
     * 若此用户没有健康档案则进行创建
     *
     * @param accountInf
     * @return
     */
    private boolean createPerson(HttpServletRequest request, AccountInfo accountInf) {
        PersonInfo personInfo = platformService.queryPersonalInfo(accountInf.getRealName(), accountInf.getCardNo());
        if (ObjectUtil.isNullOrEmpty(personInfo)) {
            personInfo = new PersonInfo();
            personInfo.setName(accountInf.getRealName());
            personInfo.setPhoneNumber(accountInf.getTelephone());
            personInfo.setIdcard(accountInf.getCardNo());
            personInfo.setPastreet(accountInf.getPastreet());
            personInfo.setFilingFlag(EHRConstants.CHECK_FLAG);
            personInfo.setPatownShip(accountInf.getPatownShip());
            personInfo.setPahouseNumber(accountInf.getPahouseNumber());
            personInfo.setHrstreet(accountInf.getHrstreet());
            personInfo.setHrtownShip(accountInf.getHrtownShip());
            personInfo.setHrhouseNumber(accountInf.getHrhouseNumber());
            personInfo.setHouseholdType(accountInf.getHouseholdType());
            personInfo.setUpdateOrganCode("01008610-0");
            personInfo.setUpdateName("银川市卫生和计划生育委员会");
            // end add
            String rs = platformService.createPerson(personInfo, EHRConstants.RETURN_PERSON_ID, false);
            createOperationLog(request, RhipModuleName.LHPORTAL, "createPerson", OperationName.CREATE_PERSON);
            if (!"".equals(rs))
                return true;
            else
                return false;
        }
        return true;
    }

    @RequestMapping(value = "/toLogin")
    public String toLogin(HttpServletRequest request, ModelMap model) {
        /*String lastUrl = request.getHeader("referer");
        model.addAttribute("lastUrl", lastUrl);*/
        return "common.underConstruction";
        /*return "lhportal.info.login";*/
    }

    /**
     * 登录
     *
     * @param request
     * @param accountInfo
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public ModelMap login(HttpServletRequest request, AccountInfo accountInfo) {
        ModelMap model = new ModelMap();
        String checkCode = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
        if ((StringUtil.isEmpty(accountInfo.getAccountName()) || StringUtil.isEmpty(accountInfo.getTelephone())) 
        		&& StringUtil.isEmpty(accountInfo.getPassword())) {
            model.addAttribute("success", false);
            model.addAttribute("msg", "登入失败,账号或者密码不能为空!");
            return model;
        } else if (StringUtil.isNullOrEmpty(checkCode)) {
            model.addAttribute("success", false);
            model.addAttribute("msg", "登录超时!");
        } else if (StringUtil.isNullOrEmpty(accountInfo.getCheckCode())) {
            model.addAttribute("success", false);
            model.addAttribute("msg", "验证码不能为空!");
        } else {
            if (!checkCode.equals(accountInfo.getCheckCode().toUpperCase())) {
                model.addAttribute("success", false);
                model.addAttribute("msg", "验证码错误!");
            } else {        //登录成功
                Criteria criteria = new Criteria();
                if (StringUtil.isNotEmpty(accountInfo.getAccountName())) {
                	criteria.add("accountName", accountInfo.getAccountName());
                } else {
                	criteria.add("telephone", accountInfo.getTelephone());
                }
                criteria.add("password", MD5Encoder.getMD5Str(accountInfo.getPassword()));
                AccountInfo ai = accountInfoService.get(criteria);
                //"status":1启用,0禁用
                if (ai != null && ai.getActivateStatus().equals("1") && ai.getStatus().equals("1")) {//注册成功标志
                    request.getSession().setAttribute(Constants.ACCOUNT_INFO, ai);
                    model.addAttribute("success", true);
                    String idcard = ai.getCardNo();
                    if (StringUtil.isEmpty(idcard)) {
                        model.addAttribute("msg", "该账号无身份证号!");
                        return model;
                    }
                    //修正身份证号含字母时登陆无法显示姓名及预约报错问题。
                    PersonInfo person = personalRecordService.getPersonRecord(new Criteria("idcard", idcard));
                    if (person == null) {
                        model.addAttribute("msg", "未找到账户的人员信息!");
                        return model;
                    } 
                    //把人员信息中手机号设置成注册手机号，避免由于手机号不一致导致投诉。
                    person.setPhoneNumber(ai.getTelephone());
                    model.addAttribute("success", true);
                    model.addAttribute("url", request.getSession().getAttribute("referer.uri"));
                    LogInSuccess(ai, request, person);
                    createOperationLog(request, RhipModuleName.LHPORTAL, "login", OperationName.LOGIN);               
                } else if (ai != null && ai.getActivateStatus().equals("1") && ai.getStatus().equals("0")) {
                    model.addAttribute("success", false);
                    model.addAttribute("msg", "您的账号已被禁用!");
                } else {
                    model.addAttribute("success", false);
                    model.addAttribute("msg", "登入失败,账号或者密码错误!");
                }
            }
        }
        return model;
    }

    /**
     * 用户登录成功，写入一些基本的信息进内存
     *
     * @param ai
     * @param request
     * @param person
     * @author:shushu
     */
    private void LogInSuccess(AccountInfo ai, HttpServletRequest request, PersonInfo person) {
        if (ObjectUtil.isNullOrEmpty(ai) || ObjectUtil.isNullOrEmpty(person)) return;
        request.getSession().setAttribute(Constants.ACCOUNT_INFO, ai);
        request.getSession().setAttribute(Constants.PERSON_INFO, person);
        List<BirthCertificate> chBirthCertificates = brwHealthService.getChBirthCertificateList(new Criteria("MOTHER_IDCARD", ai.getCardNo()));
        request.getSession().setAttribute(Constants.CH_BIRTH_CERTIFICATES, chBirthCertificates);
        PersonalBasicInfoDTO personBasicInfoDto = personalRecordManagmentService.getPersonalBasicInfo((new Criteria("id", person.getId())));
        request.getSession().setAttribute(Constants.EHR_PERSON_HEALTH, personBasicInfoDto);
    }


    @RequestMapping(value = "/loginOut")
    @ResponseBody
    public ModelMap loginOut(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        request.getSession().removeAttribute(Constants.ACCOUNT_INFO);
        request.getSession().removeAttribute(Constants.PERSON_INFO);
        request.getSession().removeAttribute(Constants.CH_BIRTH_CERTIFICATES);
        request.getSession().removeAttribute(Constants.EHR_PERSON_HEALTH);
        request.getSession().removeAttribute(Constants.REFERER_URI);
        model.addAttribute("success", true);
        //todo:shushu，看看有哪些地方有登录的，跳转到哪个页面？
        createOperationLog(request, RhipModuleName.LHPORTAL, "login", OperationName.QUIT);
        return model;
    }

    @RequestMapping(value = "/toChangePwd")
    public String toChangePwd(HttpServletRequest request, ModelMap model) {
        request.setAttribute("accountInfo", request.getSession().getAttribute(Constants.ACCOUNT_INFO));
        return "lhportal.info.toChangePwd";
    }

    /**
     * 修改密码
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/changePwd")
    @ResponseBody
    public ModelMap changePwd(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
        String password = (String) request.getParameter("password");
        String newPassword = (String) request.getParameter("newPassword");
        String newPasswordAgain = (String) request.getParameter("newPasswordAgain");
        if (StringUtil.isEmpty(password) || StringUtil.isEmpty(newPassword) || StringUtil.isEmpty(newPasswordAgain)) {
            model.addAttribute("msg", "请完善修改信息！");
        } else if (!newPassword.equals(newPasswordAgain)) {
            model.addAttribute("msg", "两次密码不一致,请重新输入!");
        } else if (!MD5Encoder.getMD5Str(password).equals(accountInfo.getPassword())) {
            model.addAttribute("msg", "原始密码错误！");
        } else {
            model.addAttribute("success", true);
            accountInfo.setPassword(MD5Encoder.getMD5Str(newPassword));
            accountInfoService.update(accountInfo);
            createOperationLog(request, RhipModuleName.LHPORTAL, "changePwd", OperationName.MODIFY_PASSWORD);
            model.addAttribute("msg", "恭喜,密码修改成功,请牢记新密码!!");
            request.getSession().removeAttribute(Constants.ACCOUNT_INFO);
        }
        return model;
    }

    /***
     * 
    * @Title: toChangePerInfo 
    * @Description: 修改个人信息
    * @param @param request
    * @param @param model
    * @param @return  参数说明 
    * @return String    返回类型 
    * @throws
     */
    @RequestMapping(value = "/toChangePerInfo")
    public String toChangePerInfo(HttpServletRequest request, ModelMap model) {
    	request.setAttribute("accountInfo", request.getSession().getAttribute(Constants.ACCOUNT_INFO));
    	return "lhportal.info.toChangePerInfo";
    }
    
    @RequestMapping(value = "/changePerInfo")
    @ResponseBody
    public ModelMap changePerInfo(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
        String telephone = (String) request.getParameter("telephone");
        String email = (String) request.getParameter("email");
        if (StringUtil.isNotEmpty(email)) {
        	accountInfo.setEmail(email);
        }
        accountInfo.setTelephone(telephone);
        PersonInfo personInfo = platformService.queryPersonalInfo(accountInfo.getRealName(), accountInfo.getCardNo());
        personInfo.setPhoneNumber(telephone);
        personInfoService.updatePersonInfo(personInfo);
        accountInfoService.update(accountInfo);
        request.getSession().setAttribute(Constants.ACCOUNT_INFO, accountInfo);
        request.getSession().setAttribute(Constants.PERSON_INFO, personInfo);
        model.addAttribute("success", true);
        createOperationLog(request, RhipModuleName.LHPORTAL, "changePerInfo", OperationName.UPDATE);
        model.addAttribute("msg", "修改成功!");
        return model;
    }
    
    
    @RequestMapping(value = "/toFindPwd")
    public String toFindPwd(HttpServletRequest request, ModelMap model) {
    	model.addAttribute("accountName", request.getParameter("accountName"));
    	model.addAttribute("checkCode", request.getParameter("checkCode"));
        return "lhportal.info.toFindPwd";
    }

    /**
     * 修改密码的时候，确认密码
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkPassword")
    @ResponseBody
    public ModelMap checkPassword(HttpServletRequest request, String password) {
        ModelMap model = new ModelMap();
        AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
        /*String password = (String) request.getParameter("password");*/
        if (!MD5Encoder.getMD5Str(password).equals(accountInfo.getPassword())) {
            model.addAttribute("msg", "原始密码错误！");
            model.addAttribute("fail", "true");
        }
        return model;
    }
    
    /**
     * 密码找回时验证用户名或者邮箱是否存在
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkEmail")
    @ResponseBody
    public ModelMap checkEmail(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        String accountName = request.getParameter("accountName");
        if (StringUtil.isEmpty(accountName)) {
            model.addAttribute("msg", "邮箱或用户名不能为空!");
            model.addAttribute("success", "false");
            return model;
        }
        AccountInfo accountInfo = existAccountEmail(accountName);
        if (null != accountInfo) {
            String email = accountInfo.getEmail();
            String suffx = email.split("@")[0];
            suffx = suffx.charAt(0) + "****" + suffx.subSequence(suffx.length() - 1, suffx.length());
            suffx = suffx + "@" + email.split("@")[1];
            model.addAttribute("email", suffx);
            model.addAttribute("success", true);
        } else {
            model.addAttribute("msg", "请输入正确的邮箱或用户名!");
        }
        return model;
    }

    @RequestMapping(value = "/findPwd")
    @ResponseBody
    public ModelMap findPwd(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        String accountName = request.getParameter("accountName");
        String checkCode = request.getParameter("checkCode");
        String sessionCheckCode = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
        if (sessionCheckCode.equals(checkCode.toUpperCase())) {
            AccountInfo accountInfo = existAccountEmail(accountName);
            if (null == accountInfo) {
                model.addAttribute("msg", "请输入正确的邮箱或用户名!");
            } else {
                String pwd = MD5Encoder.generateRandomPassword();
                accountInfo.setPassword(MD5Encoder.getMD5Str(pwd));
                accountInfoService.update(accountInfo);
                String email = accountInfo.getEmail();
                String suffx = email.split("@")[1].split("\\.")[0];
                model.addAttribute("emailUrl", "http://mail." + suffx + ".com");
                model.addAttribute("msg", "是否现在登入邮箱,完成密码修改?");
                EmailAccount emailAccount = getEmailAccount();/*请您尽快修改您的账户密码。*/
                SendEmailUtil.sendHtml(emailAccount, accountInfo.getEmail(), "健康门户服务网-密码找回", "<br/>账户:" + accountInfo.getAccountName() + "<br/>密码：" + pwd);
                model.addAttribute("success", true);
                createOperationLog(request, RhipModuleName.LHPORTAL, "findPwd", OperationName.FIND_PASSWORD);
            }
        } else {
            model.addAttribute("msg", "验证码错误!");
            model.addAttribute("success", false);
        }
        return model;
    }

    /**
     * 找回密码时验证用户名或者邮箱是否存在
     *
     * @param accountName
     * @return
     */
    private AccountInfo existAccountEmail(String accountName) {
        Criteria criteria = new Criteria();
        if (accountName.indexOf("@") == -1)
            criteria = new Criteria("accountName", accountName);
        else
            criteria = new Criteria("email", accountName);
        AccountInfo accountInfo = accountInfoService.get(criteria);
        return accountInfo;
    }

    /**
     * 验证邮箱是否被注册
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "/checkExistEmail")
    @ResponseBody
    public ModelMap checkEmail(String email) {
        ModelMap model = new ModelMap();
        Criteria criteria = new Criteria();
        criteria.add("email", email);
        criteria.add("activateStatus", "1");
        AccountInfo existEmail = accountInfoService.get(criteria);
        if (null != existEmail) {
            model.addAttribute("msg", "邮箱号已被注册！");
            model.addAttribute("success", false);
        } else {
            model.addAttribute("success", true);
        }
        return model;
    }

    /**
     * 验证身份证是否被注册
     *
     * @param cardNo
     * @return
     */
    @RequestMapping(value = "/checkCardNo")
    @ResponseBody
    private ModelMap checkCardNo(String cardNo) {
        ModelMap model = new ModelMap();
        Criteria criteria = new Criteria();
        criteria.add("cardNo", cardNo);
        criteria.add("activateStatus", "1");
        AccountInfo existCardNo = accountInfoService.get(criteria);
        if (existCardNo != null) {
            model.addAttribute("msg", "该身份证号已被注册！");
            model.addAttribute("success", false);
        } else {
            model.addAttribute("success", true);
        }
        return model;
    }

    /**
     * 验证手机号是否被注册
     *
     * @param telephone
     * @return
     */
    @RequestMapping(value = "/checkPhoneNo")
    @ResponseBody
    private ModelMap checkPhoneNo(HttpServletRequest request, String telephone) {
    	AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
        ModelMap model = new ModelMap();
        Criteria criteria = new Criteria();
        criteria.add("telephone", telephone);
        criteria.add("activateStatus", "1");
        AccountInfo existPhoneNo = accountInfoService.get(criteria);
        if (ObjectUtil.isNotEmpty(accountInfo)) {
        	if(ObjectUtil.isNotEmpty(existPhoneNo) && 
        		ObjectUtil.equals(existPhoneNo.getTelephone(), accountInfo.getTelephone())) {
        		model.addAttribute("success", true);
        	} else if (ObjectUtil.isNullOrEmpty(existPhoneNo)) {
        		model.addAttribute("success", true);
        	} else {
        		model.addAttribute("msg", "该手机号已被注册！");
        		model.addAttribute("success", false);
        	}
        } else {
        	if (ObjectUtil.isNotEmpty(existPhoneNo)) {
        		model.addAttribute("msg", "该手机号已被注册！");
        		model.addAttribute("success", false);
        	} else {
        		model.addAttribute("success", true);
        	}
        }
        return model;
    }

    /**
     * 检验验证码
     *
     * @param checkCode
     * @return
     */
    @RequestMapping(value = "/checkCode")
    @ResponseBody
    private ModelMap checkCode(HttpServletRequest request, String checkCode) {
        String validateCode = (String) request.getSession().getAttribute(RandomValidateCodeUtil.RANDOMCODEKEY);
        ModelMap model = new ModelMap();
        //判断验证码
        if (!validateCode.equals(checkCode.toUpperCase())) {
            model.addAttribute("msg", "验证码错误！");
            model.addAttribute("success", false);
        } else {
            model.addAttribute("success", true);
        }
        return model;
    }

    /**
     * 验证用户名是否被注册
     *
     * @param accountName
     * @return
     */
    @RequestMapping(value = "/checkAccountName")
    @ResponseBody
    private ModelMap checkAccountName(String accountName) {
        ModelMap model = new ModelMap();
        Criteria criteria = new Criteria();
        criteria.add("accountName", accountName);
        criteria.add("activateStatus", "1");
        AccountInfo existAccountName = accountInfoService.get(criteria);
        if (existAccountName != null) {
            model.addAttribute("msg", "用户名已经存在!");
            model.addAttribute("success", false);
        } else {
            model.addAttribute("success", true);
        }
        return model;
    }

    /**
     * 通过EmailAccountConf.properties的配置文件来获取发件人信息
     *
     * @return
     */
    private EmailAccount getSendEmailAccount() {
        Properties pro = PropertiesUtils.initProperties("EmailAccountConf");
        String host = pro.getProperty("host");
        String user = pro.getProperty("user");
        String userEmail = pro.getProperty("userEmail");
        String pwd = pro.getProperty("pwd");
        return new EmailAccount(host, user, userEmail, pwd);
    }

    /**
     * 通过门户设置获取发件人信息
     *
     * @return
     */
    private EmailAccount getEmailAccount() {
        HashMap<String, String> map = portalSetService.getSetByType(PortalSetType.SEND_EMAIL.getValue());
        String host = map.get("email_host");
        String user = map.get("email_user");
        String userEmail = map.get("email");
        String pwd = map.get("email_pwd");
        return new EmailAccount(host, user, userEmail, pwd);
    }

    /**
     * 发送验证码至手机
     *
     * @param request
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = "eckCodeSendPhone")
    @ResponseBody
    public ModelMap checkCode2Phone(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        String telphone = request.getParameter("telephone");
        if (StringUtil.isEmpty(telphone)) {
            model.addAttribute("msg", "手机号码为空");
            return model;
        }
        Random random = new Random();
        Integer num = random.nextInt(899999) + 100000;
        String check_code = String.valueOf(num);
        HttpSession registerCodeSession = request.getSession();
        registerCodeSession.setAttribute("registerCodeSession", check_code);//将注册码放到session中
        Map<String, String> smsMap = new HashMap<String, String>();
        smsMap.put("CHECK_CODE", check_code);
        SMSUtil smsUtil = new SMSUtil();
        String content = smsUtil.createSMSContent(smsMap, SMSUtil.MODE_TYPE_5);
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
			sms.setType(SMSUtil.MODE_TYPE_5);
			sms.setCreateTime(new Date());
			smsDao.insert(sms);
		}
        model.addAttribute("rs", rs);
        model.addAttribute("code", MD5Encoder.getMD5Str(check_code));
        return model;
    }
}
