package com.founder.rhip.portal.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.security.MD5Encoder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfoTemp;
import com.founder.rhip.ehr.entity.control.RemindStatistics;
import com.founder.rhip.ehr.entity.portal.AccountInfo;
import com.founder.rhip.ehr.service.IRemindStatisticsService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.portal.common.Constants;
import com.founder.rhip.portal.service.IAccountInfoService;
import com.founder.rhip.portal.service.IInfromBookService;

@Controller
@RequestMapping(value = "/userSpace/ehr")
public class UserSpaceController extends BaseController {

    @Resource(name = "platformService")
    private IPlatformService platformService;

    @Autowired
    private IPersonalRecordService personalRecordService;

    @Resource(name = "lhaccountInfoService")
    private IAccountInfoService lhaccountInfoService;

    @Resource(name = "remindStatisticsService")
    private IRemindStatisticsService remindStatisticsService;

    @Resource(name = "personalRecordManagmentService")
    private IPersonalRecordManagmentService personalRecordManagmentService;

    @Resource(name = "lhinfromBookService")
    private IInfromBookService infromBookService;

    @RequestMapping(value = "/underConstruction")
    public String underConstruction(HttpServletRequest request, Model model) {
        return "lhportal.ehr.under.construction";
    }

    @RequestMapping(value = "/basic")
    public String basicInfo(HttpServletRequest request, Model model) {
        String isRead = "";
        String isOpen = "";
       /* if (!checkLoginStatus(request)) {
            return "lhportal.info.login";
        }*/
        model.addAttribute("personBasicInfoDto", getPersonDtoFromRequest(request));
        AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
        isRead = lhaccountInfoService.get(new Criteria("id", accountInfo.getId())).getIsReadInform();
        if(ObjectUtil.isNotEmpty(infromBookService.getInfromBook())){
        	isOpen = infromBookService.getInfromBook().getIsOpen();
        }
        if (isOpen.equals("1")) {
            if (!isRead.equals("1")) {
                lhaccountInfoService.update(accountInfo.getId());
                model.addAttribute("infromBook", infromBookService.getInfromBook());
               // model.addAttribute("isOpen", 1);
            }/* else {
                model.addAttribute("isOpen", 0);
            }*/
        }/* else {
            model.addAttribute("isOpen", 0);
        }*/
        model.addAttribute("isOpen", isOpen);
        model.addAttribute("isRead", isRead);
        return "lhportal.ehr.basic.account";
    }

    public String ehr(HttpServletRequest request, Model model) {
        /*if (!checkLoginStatus(request)) return "lhportal.info.login";*/
        PersonalBasicInfoDTO personBasicInfoDto = getPersonDtoFromRequest(request);
        String expenseInfoStr = "";
        PersonInfo personInfo = personBasicInfoDto.getPersonInfo();
        if (null != personInfo.getPaymentUrbanWorkders() && "01".equals(personInfo.getPaymentUrbanWorkders().trim())) {
            expenseInfoStr += "01,";
        }
        if (null != personInfo.getPaymentUrbanResident() && "02".equals(personInfo.getPaymentUrbanResident().trim())) {
            expenseInfoStr += "02,";
        }
        if (null != personInfo.getPaymentNewRuralCooperation() && "03".equals(personInfo.getPaymentNewRuralCooperation().trim())) {
            expenseInfoStr += "03,";
        }
        if (null != personInfo.getPaymentPovertyRelief() && "04".equals(personInfo.getPaymentPovertyRelief().trim())) {
            expenseInfoStr += "04,";
        }
        if (null != personInfo.getPaymentCommercial() && "05".equals(personInfo.getPaymentCommercial().trim())) {
            expenseInfoStr += "05,";
        }
        if (null != personInfo.getPaymentBursary() && "06".equals(personInfo.getPaymentBursary().trim())) {
            expenseInfoStr += "06,";
        }
        if (null != personInfo.getPaymentPersonalExpenses() && "07".equals(personInfo.getPaymentPersonalExpenses().trim())) {
            expenseInfoStr += "07,";
        }
        if (null != personInfo.getPaymentOther() && "99".equals(personInfo.getPaymentOther().trim())) {
            expenseInfoStr += "99,";
        }
        expenseInfoStr = expenseInfoStr.endsWith(",") ? expenseInfoStr.substring(0, expenseInfoStr.length() - 1) : "";
        personBasicInfoDto.setExpenseInfoStr(expenseInfoStr);
        model.addAttribute("personBasicInfoDto", personBasicInfoDto);
        return "lhportal.ehr.basic";
    }

    @RequestMapping(value = "/basic/toSave")
    @ResponseBody
    public ModelMap toSaveAccount(HttpServletRequest request) {
        ModelMap modelMap = new ModelMap();
        AccountInfo accountInfo = (AccountInfo) request.getSession().getAttribute(Constants.ACCOUNT_INFO);
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        String patownShip = request.getParameter("patownShip");
        String pastreet = request.getParameter("pastreet");
        String pahouseNumber = request.getParameter("pahouseNumber");
        String decryptionPassword = request.getParameter("decryptionPassword");       
        accountInfo.setEmail(email);
        accountInfo.setTelephone(telephone);
        accountInfo.setPatownShip(patownShip);
        accountInfo.setPastreet(pastreet);
        accountInfo.setHrhouseNumber(pahouseNumber);
        accountInfo.setIsReadInform("1");
        lhaccountInfoService.update(accountInfo);
        if (StringUtil.isNotEmpty(decryptionPassword)) {
            Parameters parameters = new Parameters();
            parameters.add("decryptionPassword", MD5Encoder.getMD5Str(decryptionPassword)).add("encryptionFlag", "1");
            Criteria criteria = new Criteria("idcard", accountInfo.getCardNo());
            personalRecordManagmentService.updateDecryptionPassword(parameters, criteria);
            /* 插入一条记录到提醒统计表REMIND_STATISTICS     add by wangzhou   start*/
            PersonInfo personInfo = (PersonInfo) request.getSession().getAttribute(Constants.PERSON_INFO);
            if (personInfo != null) {
                RemindStatistics remindSt = new RemindStatistics();
                remindSt.setOrganCode(personInfo.getInputOrganCode() == null ? "" : personInfo.getInputOrganCode());
                remindSt.setOrganName(personInfo.getInputOrganName() == null ? "" : personInfo.getInputOrganName());
                remindSt.setOrgType("");
                remindSt.setGbcode(personInfo.getInputGbcode() == null ? "" : personInfo.getInputGbcode());
                remindSt.setSupOrganCode("");
                remindSt.setUserCode(personInfo.getId() == null ? "" : personInfo.getId().toString());
                remindSt.setUserName(personInfo.getName() == null ? "" : personInfo.getName());
                remindSt.setCategoryType("11");//档案加密提醒
                remindSt.setCreateDate(new Date());
                remindStatisticsService.save(remindSt);
            /* 插入一条记录到提醒统计表REMIND_STATISTICS     add by wangzhou    end*/
            }
        }
        modelMap.addAttribute("success", true);
        return modelMap;
    }

    public ModelMap toSave(HttpServletRequest request) {
        ModelMap modelMap = new ModelMap();
        PersonalBasicInfoDTO personalBasicInfoDTO = VoUtil.getFormData(request, PersonalBasicInfoDTO.class);
        PersonInfoTemp personInfoTemp = personalBasicInfoDTO.getPersonInfoTemp();
        Criteria criteria = new Criteria("idcard", personInfoTemp.getIdcard());
        PersonInfo person = personalRecordService.getPersonRecord(criteria);
        //如果状态为待审核的状态的时候,修改直接修改的是personinfo表
//		modify by :meixingjian 
//		case:健康门户人员信息更新，不要同步到健康档案。单独的修改门户人员信息，与健康档案无关。
//		if(ObjectUtil.isNotEmpty(person)&&EHRConstants.CHECK_FLAG.equals(person.getFilingFlag())){
        copyPersonInfoTempToPersonInfo(personInfoTemp, person, request);
        platformService.updatePersonInfoNoRegist(person);
//		}else{
//			personInfoTemp.setFilingFlag(EHRConstants.UN_CREATE);
//			platformService.saveOrUpdatePersonInfoTemp(personInfoTemp);
//		}

        modelMap.addAttribute("success", true);
        return modelMap;
    }

    private void copyPersonInfoTempToPersonInfo(PersonInfoTemp personInfoTemp, PersonInfo personInfo, HttpServletRequest request) {
        personInfo.setBirthday(personInfoTemp.getBirthday());
        personInfo.setAboBloodType(personInfoTemp.getAboBloodType());
        personInfo.setEducation(personInfoTemp.getEducation());
        String temp = personInfoTemp.getExpenseInfoStr();
        personInfo.setPaymentUrbanWorkders((StringUtil.isNotEmpty(temp) && temp.indexOf("01") != -1) ? "01" : "");
        personInfo.setPaymentUrbanResident((StringUtil.isNotEmpty(temp) && temp.indexOf("02") != -1) ? "02" : "");
        personInfo.setPaymentNewRuralCooperation((StringUtil.isNotEmpty(temp) && temp.indexOf("03") != -1) ? "03" : "");
        personInfo.setPaymentPovertyRelief((StringUtil.isNotEmpty(temp) && temp.indexOf("04") != -1) ? "04" : "");
        personInfo.setPaymentCommercial((StringUtil.isNotEmpty(temp) && temp.indexOf("05") != -1) ? "05" : "");
        personInfo.setPaymentBursary((StringUtil.isNotEmpty(temp) && temp.indexOf("06") != -1) ? "06" : "");
        personInfo.setPaymentPersonalExpenses((StringUtil.isNotEmpty(temp) && temp.indexOf("07") != -1) ? "07" : "");
        personInfo.setPaymentOther((StringUtil.isNotEmpty(temp) && temp.indexOf("99") != -1) ? "99" : "");
        personInfo.setFirstGuardian(personInfoTemp.getFirstGuardian());
        personInfo.setFowlType(personInfoTemp.getFowlType());
        personInfo.setFuel(personInfoTemp.getFuel());
        personInfo.setGender(personInfoTemp.getGender());
        personInfo.setGuardianPhoneOne(personInfoTemp.getGuardianPhoneOne());
        personInfo.setSecondGuardian(personInfoTemp.getSecondGuardian());
        personInfo.setGuardianPhoneTwo(personInfoTemp.getGuardianPhoneTwo());
        personInfo.setHastoilet(personInfoTemp.getHastoilet());
        personInfo.setHouseholdType(personInfoTemp.getHouseholdType());
        personInfo.setIdcard(personInfoTemp.getIdcard());
        personInfo.setMarriage(personInfoTemp.getMarriage());
        personInfo.setName(personInfoTemp.getName());
        personInfo.setNation(personInfoTemp.getNation());
        personInfo.setOccupation(personInfoTemp.getOccupation());
        personInfo.setOccupationOther(personInfoTemp.getOccupationOther());
        personInfo.setOutWindType(personInfoTemp.getOutWindType());
        personInfo.setPhoneNumber(personInfoTemp.getPhoneNumber());
        personInfo.setRhBloodType(personInfoTemp.getRhBloodType());
        personInfo.setUnitName(personInfoTemp.getUnitName());
        personInfo.setWater(personInfoTemp.getWater());
    }

    /**
     * 完成基本信息保存操作
     *
     * @param request
     */
    @RequestMapping("/savePersonBasicInfo")
    public String savePersonInfo(HttpServletRequest request, ModelMap model) {
        PersonalBasicInfoDTO personalBasicInfoDTO = VoUtil.getFormData(request, PersonalBasicInfoDTO.class);
        PersonInfo uptObj = createPersonInfo(personalBasicInfoDTO, request);
        Assert.notNull(uptObj.getId(), "人员信息ID获取失败");
        PersonInfo pTmp = platformService.queryPersonalInfo(uptObj.getId());
        Assert.notNull(pTmp, "获取指定的人员信息失败id is:".concat(uptObj.getId().toString()));
        uptObj.setFilingFlag(pTmp.getFilingFlag());

        platformService.updatePersonInfo(uptObj);
        return "redirect:/userSpace/ehr/basic";
    }

    private PersonInfo createPersonInfo(PersonalBasicInfoDTO personalBasicInfoDTO, HttpServletRequest request) {
        String expenseInfoStr = personalBasicInfoDTO.getExpenseInfoStr();
        PersonInfo personInfo = personalBasicInfoDTO.getPersonInfo();
        PersonInfo currentPersonInfo = this.getPerson(request);
        Integer oldStar = personInfo.getStar() == null ? 0 : personInfo.getStar();
        currentPersonInfo.setStar(oldStar);
        currentPersonInfo.setGender(personInfo.getGender());
        currentPersonInfo.setBirthday(personInfo.getBirthday());
        currentPersonInfo.setPhoneNumber(personInfo.getPhoneNumber());
        currentPersonInfo.setUnitName(personInfo.getUnitName());
        currentPersonInfo.setFirstGuardian(personInfo.getFirstGuardian());
        currentPersonInfo.setGuardianPhoneOne(personInfo.getGuardianPhoneOne());
        currentPersonInfo.setSecondGuardian(personInfo.getSecondGuardian());
        currentPersonInfo.setGuardianPhoneTwo(personInfo.getGuardianPhoneTwo());
        currentPersonInfo.setNation(personInfo.getNation());
        currentPersonInfo.setAboBloodType(personInfo.getAboBloodType());
        currentPersonInfo.setRhBloodType(personInfo.getRhBloodType());
        currentPersonInfo.setEducation(personInfo.getEducation());
        currentPersonInfo.setOccupation(personInfo.getOccupation());
        currentPersonInfo.setOccupationOther(personInfo.getOccupationOther());
        currentPersonInfo.setMarriage(personInfo.getMarriage());
        currentPersonInfo.setOutWindType(personInfo.getOutWindType());
        currentPersonInfo.setFuel(personInfo.getFuel());
        currentPersonInfo.setWater(personInfo.getWater());
        currentPersonInfo.setHastoilet(personInfo.getHastoilet());
        currentPersonInfo.setFowlType(personInfo.getFowlType());
        currentPersonInfo.setFilingFlag(EHRConstants.CHECK_FLAG);
        currentPersonInfo.setHouseholdType(personInfo.getHouseholdType());

        String orgCode = personInfo.getUpdateOrganCode();
        if (ObjectUtil.isNullOrEmpty(orgCode)) {
            orgCode = "46714114-9";
        }

        String name = personInfo.getUpdateName();
        if (ObjectUtil.isNullOrEmpty(name)) {
            name = "admin";
        }

        //add by shengguimin 2013年7月18日11:21:29
        currentPersonInfo.setUpdateOrganCode(orgCode);
        currentPersonInfo.setUpdateName(name);
        //end
        if (StringUtil.isNotEmpty(expenseInfoStr)) {
            currentPersonInfo.setPaymentUrbanWorkders(expenseInfoStr.indexOf("01") != -1 ? "01" : "");
            currentPersonInfo.setPaymentUrbanResident(expenseInfoStr.indexOf("02") != -1 ? "02" : "");
            currentPersonInfo.setPaymentNewRuralCooperation(expenseInfoStr.indexOf("03") != -1 ? "03" : "");
            currentPersonInfo.setPaymentPovertyRelief(expenseInfoStr.indexOf("04") != -1 ? "04" : "");
            currentPersonInfo.setPaymentCommercial(expenseInfoStr.indexOf("05") != -1 ? "05" : "");
            currentPersonInfo.setPaymentBursary(expenseInfoStr.indexOf("06") != -1 ? "06" : "");
            currentPersonInfo.setPaymentPersonalExpenses(expenseInfoStr.indexOf("07") != -1 ? "07" : "");
            currentPersonInfo.setPaymentOther(expenseInfoStr.indexOf("99") != -1 ? "99" : "");
        }
        return currentPersonInfo;
    }

    @RequestMapping(value = "/phy")
    public String phy(HttpServletRequest request, Model model) {
       /* if (!checkLoginStatus(request)) return "lhportal.info.login";*/
        PersonalBasicInfoDTO personBasicInfoDto = getPersonDtoFromRequest(request);
        model.addAttribute("personBasicInfoDto", personBasicInfoDto);
        PersonalPhyExamDTO personalPhyExamDTO = personalRecordManagmentService.getPersonalPhysical((new Criteria("id", getPersonId(request))));
        model.addAttribute("personalPhyExamDTO", personalPhyExamDTO);
        return "lhportal.ehr.phyExam";
    }

    @RequestMapping(value = "/history")
    public String history(HttpServletRequest request, Model model) {
        /*if (!checkLoginStatus(request)) return "lhportal.info.login";*/
        model.addAttribute("personBasicInfoDto", getPersonDtoFromRequest(request));
        return "lhportal.ehr.historyIll";
    }

    @RequestMapping(value = "/iframe")
    public String iframe(String type, ModelMap model) {
        String url = "/userSpace/ehr/iframeLayout?type=" + type;
        model.addAttribute("iframeUrl", url);
        return "lhportal.ehr.iframe";
    }

    @RequestMapping(value = "/iframeLayout")
    public String iframeLayout(String type, ModelMap model) {
        model.addAttribute("type", type);
        return "lhportal.info.iframeLayout";
    }


    /**
     * 医疗服务
     *
     * @return
     */
    @RequestMapping(value = "/service")
    public String index() {
        return "lhportal.ehr.service";
    }

    @RequestMapping(value = "/fybj")
    public String fybj() {
        return "lhportal.ehr.nook";
    }
}

