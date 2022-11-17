package com.founder.rhip.ehr.controller.child;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.controller.form.ChildExamQueryForm;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.child.ChildHealthExamination;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.repository.child.INeonatalFamilyVisitDao;
import com.founder.rhip.ehr.service.child.IChildHealthExamineService;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.ihm.service.IWchSearchService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jingqiu on 17-3-23.
 */
@Controller
@RequestMapping("/childHealthExamine")
public class ChildHealthExamineController extends BaseController {

    @Autowired
    private IOrganizationApp organizationApp;
    @Resource
    private IChildHealthExamineService childHealthExamineService;
    @Resource(name = "wchSearchService")
	private IWchSearchService wchSearchService;
    @Resource
    private IPersonInfoService personInfoService;
    @Resource(name = "neonatalFamilyVisitDao")
    private INeonatalFamilyVisitDao neonatalFamilyVisitDao;  //新生儿家庭访视表
    @RequestMapping("/underOne")
    public String underOne(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("navigation", "1-8月龄儿童检查记录表");
        model.addAttribute("examineAgeGroup", EHRConstants.CHILD_AGE_GROUP_UNDER_ONE);
        return "rhip.ehr.child.search";
    }
    @RequestMapping("/oneToTwo")
    public String oneToTwo(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("navigation", "12-30月龄儿童检查记录表");
        model.addAttribute("examineAgeGroup", EHRConstants.CHILD_AGE_GROUP_ONE_TO_TWO);
        return "rhip.ehr.child.search";
    }
    @RequestMapping("/threeToSix")
    public String threeToSix(HttpServletRequest request, Model model) {
        initOrg(request, model);
        model.addAttribute("navigation", "3-6岁儿童检查记录表");
        model.addAttribute("examineAgeGroup", EHRConstants.CHILD_AGE_GROUP_THREE_TO_SIX);
        return "rhip.ehr.child.search";
    }

    /**
     * 获取体检表里该年龄段的所有的人。
     * @param request
     * @param indexPage
     * @param queryForm
     * @param model
     * @return
     */
    @RequestMapping("/childSearch")
    public String search(HttpServletRequest request, int indexPage,
                         ChildExamQueryForm queryForm, Model model) {
        String examineAgeGroup = queryForm.getExamineAgeGroup();
        Page page = super.getPage(request, indexPage);
        Criteria criteria = queryForm.getCriteria();
        setOrganCritera(criteria, queryForm.getOrgCode(), request);
        PageList<ChildHealthExamination> pagedChildUnderOne = childHealthExamineService.getPagedChildInfo(page, criteria,examineAgeGroup);
        model.addAttribute("examineAgeGroup",examineAgeGroup);
        model.addAttribute("childExams", pagedChildUnderOne.getList());
        model.addAttribute("page", pagedChildUnderOne.getPage());
        return "rhip.ehr.child.list";
    }

    /**
     * 根据出生编号获取一个人这段年龄内的体检记录
     * @param examineAgeGroup
     * @param babyCardNo
     * @param model
     * @return
     */
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
        return "rhip.ehr.child.examList";
    }

    /**
     * 编辑体检记录
     * @param examineAgeGroup
     * @param babyCardNo
     * @param examId
     * @param model
     * @return
     */
    @RequestMapping("/editExam")
    public String editExam(HttpServletRequest request, String examineAgeGroup, String babyCardNo,String idCard, Integer examId, Model model) {
        String remove = "'";
        if(StringUtil.isNotEmpty(idCard)){
            idCard = idCard.replace(remove,"");
        }
        if(StringUtil.isNotEmpty(babyCardNo)){
            babyCardNo = babyCardNo.replace(remove,"");
        }
        model.addAttribute("examineAgeGroup", examineAgeGroup);
        if (StringUtil.isNullOrEmpty(babyCardNo) && examineAgeGroup.equals("1")) {
            //没有出生编号，跳转到个人信息页面填写
            return "rhip.ehr.child.childInfoEdit";
        }
        if (StringUtil.isNullOrEmpty(idCard) && !examineAgeGroup.equals("1")) {
            //没有身份证，跳转到个人信息页面填写
            return "rhip.ehr.child.childInfoEdit";
        }
        if (ObjectUtil.isNotEmpty(examId)) {
            //修改体检
            ChildHealthExamination exam = childHealthExamineService.getChildHealthExam(new Criteria("id", examId));
            model.addAttribute("exam", exam);
            model.addAttribute("examAge", exam.getcPhysicalExamAge());
        } else {
            //新建体检
            if (!model.containsAttribute("exam")) {
                //没有填过基本资料，取最近的检查记录，获取基本信息
                ChildHealthExamination exam = getRecentChildInfo(examineAgeGroup, babyCardNo, idCard);
                exam.setVisitDoctorCode(getCurrentUser(request).getStaffCode());
                model.addAttribute("exam", exam);
            }
        }
        //默认的体检月龄
        if (!model.containsAttribute("examAge")) {
            model.addAttribute("examAge", defaultExamAge(examineAgeGroup));
        }
        return determineExamForm(examineAgeGroup);
    }

    /**
     * 根据个人信息返回体检表
     * @param examineAgeGroup
     * @param examination
     * @param model
     * @return
     */
    @RequestMapping("/showExamineForm")
    public String showExamineForm(HttpServletRequest request, String examineAgeGroup, ChildHealthExamination examination, Model model) {
        String babyCardNo = examination.getBabyCardNo();
        String idCard = examination.getIdCard();
        String examAge = examination.getcPhysicalExamAge();
        model.addAttribute("examAge", examAge);
        Criteria criteria = new Criteria("babyCardNo", babyCardNo);
        if (StringUtil.isNotEmpty(examination.getIdCard())) {
            criteria.add(LOP.OR, "idcard", examination.getIdCard());
        }
        //根据出生编号查找个人信息是否存在
        List<PersonInfo> personInfoList = personInfoService.getPersonInfo(criteria);
        if (ObjectUtil.isNotEmpty(personInfoList)) {
            PersonInfo personInfo = personInfoList.get(0);
            examination.setPersonId(personInfo.getId());
            boolean needUpdate = false;
            //如果个人信息没有身份证号而体检信息有，则更新个人信息的身份证号
            if (StringUtil.isNullOrEmpty(personInfo.getIdcard()) &&
                    StringUtil.isNotEmpty(examination.getIdCard())) {
                personInfo.setIdcard(examination.getIdCard());
                if("4".equals( personInfo.getFilingFlag())&& StringUtil.isNotEmpty(examination.getIdCard())){
                	personInfo.setFilingFlag(EHRConstants.UN_CREATE);
                }else{
                	personInfo.setFilingFlag(personInfo.getFilingFlag());
                }
                needUpdate = true;
            }
            //如果个人信息没有宝宝卡号而体检信息有，则更新个人信息的宝宝卡号
            if (StringUtil.isNullOrEmpty(personInfo.getBabyCardNo()) && StringUtil.isNotEmpty(examination.getBabyCardNo())) {
                personInfo.setBabyCardNo(examination.getBabyCardNo());
                if("4".equals( personInfo.getFilingFlag())&& StringUtil.isNotEmpty(examination.getIdCard())){
                	personInfo.setFilingFlag(EHRConstants.UN_CREATE);
                }else{
                	personInfo.setFilingFlag(personInfo.getFilingFlag());
                }
                needUpdate = true;
            }
            if (needUpdate) {
                personInfoService.updatePersonInfo(personInfo);
            }
        }
        model.addAttribute("exam", examination);
        return editExam(request, examineAgeGroup, babyCardNo, idCard,null, model);
    }

    /**
     * 不同月龄返回不同的体检项
     * @param examineAgeGroup
     * @param cPhysicalExamAge
     * @param model
     * @return
     */
    @RequestMapping("/loadExamDetail")
    public String loadExamDetail(String examineAgeGroup, String cPhysicalExamAge, Model model) {
        model.addAttribute("examAge", cPhysicalExamAge);
        return determineExamDetailForm(examineAgeGroup);
    }

    @RequestMapping("/saveChildExamine")
    @ResponseBody
    public Map<String, Object> saveChildExam(ChildHealthExamination examination, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (examination.getId() == null) {
                Organization organization = SecurityUtils.getCurrentOrganization(request);
                User user = SecurityUtils.getCurrentUser(request);
                childHealthExamineService.addChildHealthExam(examination, organization, user);
                List<WomenChildHealth> womenChildHealthList=null;
        		if(ObjectUtil.isNotEmpty(examination.getIdCard())&& ObjectUtil.isNotEmpty(examination.getBabyCardNo())){
        			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, examination.getIdCard()).add("BABY_CARD_NO", OP.EQ, examination.getBabyCardNo()));
        		}else if(ObjectUtil.isNullOrEmpty(examination.getIdCard())&& ObjectUtil.isNotEmpty(examination.getBabyCardNo())){
        			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("BABY_CARD_NO", OP.EQ, examination.getBabyCardNo()));
        		}else{
        			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, examination.getIdCard()));
        		}
        		if(ObjectUtil.isNullOrEmpty(womenChildHealthList)){
        			
        			WomenChildHealth childHealth=new WomenChildHealth();
        			childHealth.setBabyCardNo(examination.getBabyCardNo());
        			childHealth.setIdCard(examination.getIdCard());
        			childHealth.setCreateDate(new Date());
        			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        			childHealth.setCreatePerson(currentLoginInfo.getUser().getUserName());
        			childHealth.setGender(examination.getGender());
        			childHealth.setOrgCode(examination.getCreateOrganCode());
        			childHealth.setOrgName(examination.getCreateOrganName());
        			childHealth.setChildBirthday(examination.getBirthday());
        			childHealth.setName(examination.getName());
        			childHealth.setIdentityType("1");
        			childHealth.setIsDelete("0");
        			childHealth.setUpdateDate(new Date());
        			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
        			childHealth.setPersonId(examination.getPersonId().toString());
        			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",examination.getIdCard()));
        			if(ObjectUtil.isNullOrEmpty(personInfo)){
        				personInfo= personInfoService.getPersonInfoId(new Criteria("BABY_CARD_NO",examination.getBabyCardNo()));
        			}
        			if(ObjectUtil.isNotEmpty(personInfo)){
        				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
        				childHealth.setPersonId(personInfo.getId().toString());
        			}
        			wchSearchService.inerstWomenChildHealth(childHealth);
        		}else{
        			WomenChildHealth childHealth=womenChildHealthList.get(0);
        			childHealth.setBabyCardNo(examination.getBabyCardNo());
        			childHealth.setIdCard(examination.getIdCard());
        			childHealth.setUpdateDate(new Date());
        			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
        			childHealth.setGender(examination.getGender());
        			childHealth.setOrgCode(examination.getCreateOrganCode());
        			childHealth.setOrgName(examination.getCreateOrganName());
        			childHealth.setChildBirthday(examination.getBirthday());
        			childHealth.setName(examination.getName());
        			childHealth.setPersonId(examination.getPersonId().toString());
        			childHealth.setIdentityType("1");
        			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",examination.getIdCard()));
        			if(ObjectUtil.isNullOrEmpty(personInfo)){
        				personInfo= personInfoService.getPersonInfoId(new Criteria("BABY_CARD_NO",examination.getBabyCardNo()));
        			}
        			if(ObjectUtil.isNotEmpty(personInfo)){
        				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
        				childHealth.setPersonId(personInfo.getId().toString());
        			}
        			wchSearchService.updateWomenChildHealth(childHealth);
        		}
                
            } else {
                childHealthExamineService.updateChildHealthExam(examination);
            }
            result.put("success", true);
        } catch (Exception e) {
            logger.error(e);
            result.put("success", false);
            result.put("message", e.getMessage());
        }
        return result;
    }

    @RequestMapping("/viewExam")
    public String viewExam(Integer examId, Model model) {
        ChildHealthExamination exam = childHealthExamineService.getChildHealthExam(new Criteria("id", examId));
        model.addAttribute("exam", exam);
        return determineExamView(exam.getExamineAgeGroup());
    }

    @RequestMapping("/deleteExam")
    @ResponseBody
    public boolean deleteExam(Integer examId) {
        int rt = childHealthExamineService.deleteChildHealthExam(examId);
        return rt != 0;
    }

    @RequestMapping("/getChildInfo")
    @ResponseBody
    public Map<String, Object> getChildInfo(String idCard, String babyCardNo) {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(idCard)) {
        	if(idCard.length()==15){
        		if(IDCardUtil.validateIdCard15(idCard)){
        			idCard= IDCardUtil.conver15CardTo18(idCard);
        		}
        		
        		
        	}
            criteria.add("idcard", idCard);
        } else if (StringUtil.isNotEmpty(babyCardNo)) {
            criteria.add("babyCardNo", babyCardNo);
        } else {
            return null;
        }
        PersonInfo personInfo = personInfoService.getPersonInfoId(criteria);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        if (ObjectUtil.isNotEmpty(personInfo)) {
        	Map<String, Object> result = new HashMap<>();
            result.put("id", personInfo.getId());
            result.put("name", personInfo.getName());
            result.put("gender", personInfo.getGender());
            if(ObjectUtil.isNotEmpty(personInfo.getBirthday())){
                result.put("birthday", sdf.format(personInfo.getBirthday()));
            }
            if(ObjectUtil.isNotEmpty(idCard)){
            	result.put("idCard", idCard);
            }else{
            	result.put("idCard", personInfo.getIdcard());
            }
            
            result.put("babyCardNo", personInfo.getBabyCardNo());
            result.put("telNumber", personInfo.getPhoneNumber());
            result.put("pacounty", personInfo.getPacounty());
            result.put("patownShip", personInfo.getPatownShip());
            result.put("pastreet", personInfo.getPastreet());
            result.put("pahouseNumber", personInfo.getPahouseNumber());
            result.put("healthFileNo", personInfo.getHealthFileNo());
            List<NeonatalFamilyVisit> list= neonatalFamilyVisitDao.getList(new Criteria("PERSON_ID", personInfo.getId()), new Order("CREATE_DATE,ID"));
            if(ObjectUtil.isNotEmpty(list)){
            	result.put("fatherName", list.get(0).getFatherName());
            	result.put("fatherPhone", list.get(0).getFatherPhone());
            	result.put("motherName", list.get(0).getMotherName());
            	result.put("matherPhone", list.get(0).getMatherPhone());
            	result.put("fatherOccupationalGroupCode", list.get(0).getFatherOccupation());
            	result.put("fatherBirthday", DateUtil.formatDate(list.get(0).getFatherBirthday(), "yyyy/MM/dd"));
            	result.put("motherOccupationalGroupCode", list.get(0).getMotherOccupation());
            	result.put("motherBirthday", DateUtil.formatDate(list.get(0).getMotherBirthday(), "yyyy/MM/dd"));
            }
            return result;
        }
        return null;
        
        
    }

    private ChildHealthExamination getRecentChildInfo(String examineAgeGroup, String babyCardNo , String idCard) {
        List<ChildHealthExamination> childHealthExamList = childHealthExamineService.getChildHealthExamList(examineAgeGroup, babyCardNo, idCard);
        ChildHealthExamination recent = childHealthExamList.get(0);
        ChildHealthExamination exam = new ChildHealthExamination();
        exam.setPersonId(recent.getPersonId());
        exam.setName(recent.getName());
        exam.setGender(recent.getGender());
        exam.setBirthday(recent.getBirthday());
        exam.setBabyCardNo(recent.getBabyCardNo());
        exam.setIdCard(recent.getIdCard());
        exam.setMotherIdcard(recent.getMotherIdcard());
        exam.setPacounty(recent.getPacounty());
        exam.setPatownShip(recent.getPatownShip());
        exam.setPastreet(recent.getPastreet());
        exam.setPahouseNumber(recent.getPahouseNumber());
        exam.setTelNumber(recent.getTelNumber());
        exam.setExamineAgeGroup(examineAgeGroup);
        return exam;
    }

    private Criteria setOrganCritera(Criteria criteria, String organCode, HttpServletRequest request) {
        String searchCenter = request.getParameter("searchCenter");
        String searchStation = request.getParameter("searchStation");
        if (SecurityUtils.hasRole(RoleType.ZXEB, request)) {
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
        } else if (SecurityUtils.hasRole(RoleType.ZEB, request)) {
            //社区服务站
            criteria.add("createOrganCode", organCode);
        }
        return criteria;
    }

    private String determineExamForm(String examineAgeGroup) {
        if (EHRConstants.CHILD_AGE_GROUP_UNDER_ONE.equals(examineAgeGroup)) {
            return "rhip.ehr.child.underOne.editExam";
        }
        if (EHRConstants.CHILD_AGE_GROUP_ONE_TO_TWO.equals(examineAgeGroup)) {
            return "rhip.ehr.child.oneToTwo.editExam";
        }
        if (EHRConstants.CHILD_AGE_GROUP_THREE_TO_SIX.equals(examineAgeGroup)) {
            return "rhip.ehr.child.threeToSix.editExam";
        }
        return null;
    }

    private String determineExamView(String examineAgeGroup) {
        if (EHRConstants.CHILD_AGE_GROUP_UNDER_ONE.equals(examineAgeGroup)) {
            return "rhip.ehr.child.underOne.viewExam";
        }
        if (EHRConstants.CHILD_AGE_GROUP_ONE_TO_TWO.equals(examineAgeGroup)) {
            return "rhip.ehr.child.oneToTwo.viewExam";
        }
        if (EHRConstants.CHILD_AGE_GROUP_THREE_TO_SIX.equals(examineAgeGroup)) {
            return "rhip.ehr.child.threeToSix.viewExam";
        }
        return null;
    }

    private String determineExamDetailForm(String examineAgeGroup) {
        if (EHRConstants.CHILD_AGE_GROUP_UNDER_ONE.equals(examineAgeGroup)) {
            return "rhip.ehr.child.underOne.editExamDetail";
        }
        if (EHRConstants.CHILD_AGE_GROUP_ONE_TO_TWO.equals(examineAgeGroup)) {
            return "rhip.ehr.child.oneToTwo.editExamDetail";
        }
        if (EHRConstants.CHILD_AGE_GROUP_THREE_TO_SIX.equals(examineAgeGroup)) {
            return "rhip.ehr.child.threeToSix.editExamDetail";
        }
        return null;
    }

    private String defaultExamAge(String examineAgeGroup) {
        if (EHRConstants.CHILD_AGE_GROUP_UNDER_ONE.equals(examineAgeGroup)) {
            return "满月";
        }
        if (EHRConstants.CHILD_AGE_GROUP_ONE_TO_TWO.equals(examineAgeGroup)) {
            return "12月龄";
        }
        if (EHRConstants.CHILD_AGE_GROUP_THREE_TO_SIX.equals(examineAgeGroup)) {
            return "3岁";
        }
        return null;
    }
}
