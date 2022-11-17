package com.founder.rhip.ehr.controller.woman;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.entity.women.PostpartumDaysHealthInfo;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.ihm.service.IPostpartumDaysHealthInfoService;
import com.founder.rhip.ihm.service.IWchSearchService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by yuanzg on 2017/3/24.
 */
@Controller
@RequestMapping("/postpartum")
public class PostpartumFTwoController extends BaseController {
    @Resource(name = "wchSearchService")
    private IWchSearchService wchSearchService;
    @Autowired
    private IPersonInfoService personInfoService;

    @Autowired
    private IPostpartumDaysHealthInfoService postpartumDaysHealthInfoService;
    /**
     * 新增产后42天健康检查
     * @return
     */
    @RequestMapping("/addPostpartumFTwo")
    public String addPostpartumFTwo(HttpServletRequest request, ModelMap model){
        PostpartumDaysHealthInfo postpartumDaysHealthInfo = new PostpartumDaysHealthInfo();
        postpartumDaysHealthInfo.setSupervisionDate(new Date());
        postpartumDaysHealthInfo.setSupervisionDoctor(this.getCurrentUser(request).getStaffCode());
        Organization organization = getCurrentOrg(request);
        postpartumDaysHealthInfo.setCreateOrganCode(organization.getOrganCode());
        postpartumDaysHealthInfo.setCreateOrganName(organization.getOrganName());
        model.addAttribute("postpartumDaysHealthInfo",postpartumDaysHealthInfo);
        return "rhip.ehr.browser.addPostpartumFTwo";
    }

    /**
     * 根据身份证获取产妇信息
     * @param request
     * @return
     */
    @RequestMapping("/getMaternalByIdcard")
    @ResponseBody
    public PersonInfo getMaternalByIdcard(HttpServletRequest request){
        String idCard = request.getParameter("idCard");
        Criteria criteria = new Criteria();
        criteria.add("idcard",idCard);
        PersonInfo personInfo = personInfoService.getPersonInfoId(criteria);
        return personInfo;
    }

    /**
     * 保存新增
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/saveAddPostpartumFTwo")
    public String saveAddPostpartumFTwo(PostpartumDaysHealthInfo postpartumDaysHealthInfo ,HttpServletRequest request, ModelMap model){
        boolean flg = false;
        if(ObjectUtil.isNotEmpty(postpartumDaysHealthInfo)){
            String IdCard = postpartumDaysHealthInfo.getIdCard();
            Criteria criteriaIdCard = new Criteria();
            criteriaIdCard.add("IDCARD",IdCard);
            /*PostpartumDaysHealthInfo postpartumDaysHealthInfoExist = postpartumDaysHealthInfoDao.get(criteriaIdCard);*/
            //添加机构
            PersonInfo personInfo = personInfoService.getPersonInfoId(criteriaIdCard);
            /*postpartumDaysHealthInfo.setCreateOrganCode(personInfo.getInputOrganCode());
            postpartumDaysHealthInfo.setCreateOrganName(personInfo.getInputOrganName());*/
            postpartumDaysHealthInfo.setIsDelete((short)0);
            postpartumDaysHealthInfoService.addPostpartumDaysHealthInfo(postpartumDaysHealthInfo);
            	List<WomenChildHealth> womenChildHealthList=null;
        		if(ObjectUtil.isNotEmpty(postpartumDaysHealthInfo.getIdCard())){
        			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, postpartumDaysHealthInfo.getIdCard()));
        		}
        		if(ObjectUtil.isNullOrEmpty(womenChildHealthList)){
        			WomenChildHealth childHealth=new WomenChildHealth();
        			childHealth.setBabyCardNo("");
        			childHealth.setIdCard(postpartumDaysHealthInfo.getIdCard());
        			childHealth.setCreateDate(new Date());
        			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        			childHealth.setCreatePerson(currentLoginInfo.getUser().getUserName());
        			childHealth.setGender("2");
        			childHealth.setOrgCode(postpartumDaysHealthInfo.getCreateOrganCode());
        			childHealth.setOrgName("");
        			childHealth.setChildBirthday(null);
        			childHealth.setName(postpartumDaysHealthInfo.getName());
        			childHealth.setIdentityType("2");
        			childHealth.setIsDelete("0");
        			childHealth.setUpdateDate(new Date());
        			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
        			
        			if(ObjectUtil.isNotEmpty(personInfo)){
        				childHealth.setPersonId(personInfo.getId().toString());
        				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
        			}
        			wchSearchService.inerstWomenChildHealth(childHealth);
        		}else{

        			WomenChildHealth childHealth=womenChildHealthList.get(0);
        			childHealth.setBabyCardNo(postpartumDaysHealthInfo.getBabyCardNo());
        			childHealth.setIdCard(postpartumDaysHealthInfo.getIdCard());
        			childHealth.setUpdateDate(new Date());
        			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
        			childHealth.setGender("2");
        			childHealth.setOrgCode(postpartumDaysHealthInfo.getCreateOrganCode());
        			childHealth.setOrgName(postpartumDaysHealthInfo.getCreateOrganName());
        			childHealth.setChildBirthday(null);
        			childHealth.setName(postpartumDaysHealthInfo.getName());
        			childHealth.setPersonId(postpartumDaysHealthInfo.getPersonId().toString());
        			childHealth.setIdentityType("2");
        			if(ObjectUtil.isNotEmpty(personInfo)){
        				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
        				childHealth.setPersonId(personInfo.getId().toString());
        			}
        			wchSearchService.updateWomenChildHealth(childHealth);
        		
        		}
            flg = true;
        }else{
            flg = false;
        }
        return EHRMessageUtil.returnMsg(model, flg ? "success" : "failed");
    }

    /**
     * 修改产后健康检查页面
     * @param personId
     * @param model
     * @return
     */
    @RequestMapping("/modifyPostpartumFTwo")
    public String modifyPostpartumFTwo(String personId,ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("id",personId);
        PostpartumDaysHealthInfo postpartumDaysHealthInfo = postpartumDaysHealthInfoService.getPostpartumDaysHealthInfo(criteria);
        model.addAttribute("postpartumDaysHealthInfo",postpartumDaysHealthInfo);
        return "rhip.ehr.browser.modifyPostpartumFTwo";
    }

    /**
     * 保存修改
     * @param postpartumDaysHealthInfo
     * @param model
     * @return
     */
    @RequestMapping("/saveModifyPostpartumFTwo")
    public String saveModifyPostpartumFTwo(PostpartumDaysHealthInfo postpartumDaysHealthInfo,ModelMap model){
        boolean flg = false;
        if(ObjectUtil.isNotEmpty(postpartumDaysHealthInfo)){
            postpartumDaysHealthInfo.setIsDelete((short)0);
            int ret = postpartumDaysHealthInfoService.updatePostpartumDaysHealthInfo(postpartumDaysHealthInfo);
            if (ret > 0) {
                flg = true;
            } else if (ret <= 0) {
                flg = false;
            }
        }
        return EHRMessageUtil.returnMsg(model, flg ? "success" : "failed");
    }

    /**
     * 删除产后健康检查记录
     * @param personId
     * @param model
     * @return
     */
    @RequestMapping("/deletePostpartumFTwo")
    public String deletePostpartumFTwo(String personId,ModelMap model){
        boolean flg = false;
        try {
            Criteria criteria = new Criteria();
            criteria.add("id",personId);
            /*postpartumDaysHealthInfoService.deletePostpartumDaysHealthInfo(criteria);*/
            PostpartumDaysHealthInfo postpartumDaysHealthInfo =postpartumDaysHealthInfoService.getPostpartumDaysHealthInfo(criteria);
            postpartumDaysHealthInfo.setIsDelete((short)1);
            postpartumDaysHealthInfoService.updatePostpartumDaysHealthInfo(postpartumDaysHealthInfo);
            flg = true;
        }catch (Exception e){
            e.printStackTrace();
            flg = false;
        }
        return EHRMessageUtil.returnMsg(model, flg ? "success" : "failed");
    }
}
