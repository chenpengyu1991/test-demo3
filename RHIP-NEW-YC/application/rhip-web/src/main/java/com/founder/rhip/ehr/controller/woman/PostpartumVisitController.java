package com.founder.rhip.ehr.controller.woman;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.entity.women.PostnatalFollowup;
import com.founder.rhip.ehr.entity.women.PostnatalFollowupDTO;
import com.founder.rhip.ehr.repository.women.IPostnatalFollowupDao;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.hm.service.PersonInfoServiceImpl;
import com.founder.rhip.ihm.service.IPostnatalFollowupService;
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
import java.util.Map;

/**
 * Created by yuanzg on 2017/3/23.
 */
@Controller
@RequestMapping("/maternal")
public class PostpartumVisitController extends BaseController {
    @Autowired
    private IPersonInfoService personInfoService;

    @Autowired
    private IPostnatalFollowupService postnatalFollowupService;

    @Autowired
    private IPostnatalFollowupDao postnatalFollowupDao;
    
    @Resource(name = "wchSearchService")
    private IWchSearchService wchSearchService;
    /**
     * 新增产后访视
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/addPostpartumVisit")
    public String addPostnatalFollowup(HttpServletRequest request, ModelMap model){
        PostnatalFollowup postnatalFollowup = new PostnatalFollowup();
        postnatalFollowup.setVisitDate(new Date());
        postnatalFollowup.setSupervisionDoctor(this.getCurrentUser(request).getStaffCode());
        Organization organization = getCurrentOrg(request);
        postnatalFollowup.setCreateOrganCode(organization.getOrganCode());
        postnatalFollowup.setCreateOrganName(organization.getOrganName());
        model.addAttribute("postnatalFollowup",postnatalFollowup);
        return "rhip.ehr.browser.addPostnatalFollowup";
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
    @RequestMapping("/saveAddPostpartumVisit")
    public String saveAddPostnatalFollowup(PostnatalFollowup postnatalFollowup ,HttpServletRequest request, ModelMap model){
        boolean flg = false;
        if(ObjectUtil.isNotEmpty(postnatalFollowup)){
        String IdCard = postnatalFollowup.getIdCard();
        Criteria criteriaIdCard = new Criteria();
        criteriaIdCard.add("idCard",IdCard);
        //插入登录机构
        PersonInfo personInfo = personInfoService.getPersonInfoId(criteriaIdCard);
        postnatalFollowup.setPersonId(personInfo.getId());
        postnatalFollowup.setIsDelete((short)0);
            postnatalFollowupService.addPostnatalFollowup(postnatalFollowup);
            	List<WomenChildHealth> womenChildHealthList=null;
        		if(ObjectUtil.isNotEmpty(postnatalFollowup.getIdCard())){
        			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, postnatalFollowup.getIdCard()));
        		}
        		if(ObjectUtil.isNullOrEmpty(womenChildHealthList)){
        			WomenChildHealth childHealth=new WomenChildHealth();
        			childHealth.setBabyCardNo("");
        			childHealth.setIdCard(postnatalFollowup.getIdCard());
        			childHealth.setCreateDate(new Date());
        			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        			childHealth.setCreatePerson(currentLoginInfo.getUser().getUserName());
        			childHealth.setGender("2");
        			childHealth.setOrgCode(postnatalFollowup.getCreateOrganCode());
        			childHealth.setOrgName("");
        			childHealth.setChildBirthday(null);
        			childHealth.setName(postnatalFollowup.getName());
        			childHealth.setIdentityType("2");
        			childHealth.setIsDelete("0");
        			childHealth.setUpdateDate(new Date());
        			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
        			childHealth.setPersonId(postnatalFollowup.getPersonId().toString());
        			if(ObjectUtil.isNotEmpty(personInfo)){
        				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
        				childHealth.setPersonId(personInfo.getId().toString());
        			}
        			wchSearchService.inerstWomenChildHealth(childHealth);
        		}else{

        			WomenChildHealth childHealth=womenChildHealthList.get(0);
        			childHealth.setBabyCardNo(postnatalFollowup.getBabyCardNo());
        			childHealth.setIdCard(postnatalFollowup.getIdCard());
        			childHealth.setUpdateDate(new Date());
        			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
        			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
        			childHealth.setGender("2");
        			childHealth.setOrgCode(postnatalFollowup.getCreateOrganCode());
        			childHealth.setOrgName(postnatalFollowup.getCreateOrganName());
        			childHealth.setChildBirthday(null);
        			childHealth.setName(postnatalFollowup.getName());
        			childHealth.setPersonId(postnatalFollowup.getPersonId().toString());
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
     * 修改产后访视详细
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/modifyPostpartumVisit")
    public String modifyPostnatalFollowup(String id, ModelMap model){
        Criteria criteria = new Criteria();
        criteria.add("id",id);
        PostnatalFollowup postnatalFollowup = postnatalFollowupService.getPostnatalFollowup(criteria);
        model.addAttribute("postnatalFollowup",postnatalFollowup);
        return "rhip.ehr.browser.modifyPostnatalFollowup";
    }

    /**
     * 保存修改
     * @param request
     * @return
     */
    @RequestMapping("/savemodifyPostpartumVisit")
    public String savemodifyPostpartumVisit(PostnatalFollowup postnatalFollowup ,HttpServletRequest request,ModelMap model){
        boolean flg = false;
        if(ObjectUtil.isNotEmpty(postnatalFollowup)){
            postnatalFollowup.setIsDelete((short)0);
            int ret = postnatalFollowupService.updatePostnatalFollowup(postnatalFollowup);
        if(ret >0){
            flg = true;
        }else if(ret<=0){
            flg = false;
        }
        }
        return EHRMessageUtil.returnMsg(model, flg ? "success" : "failed");
    }

    /**
     * 删除
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/deletePostpartumVisit")
    public String deletePostpartumVisit(String id,ModelMap model){
        boolean flg = false;
        try {
            Criteria criteria = new Criteria();
            criteria.add("id",id);
            PostnatalFollowup postnatalFollowup =postnatalFollowupService.getPostnatalFollowup(criteria);
            postnatalFollowup.setIsDelete((short)1);
            postnatalFollowupService.updatePostnatalFollowup(postnatalFollowup);
            /*postnatalFollowupService.deletePostnatalFollowup(criteria);*/
            flg = true;
        }catch (Exception e){
            e.printStackTrace();
            flg = false;
        }
        return EHRMessageUtil.returnMsg(model, flg ? "success" : "failed");
    }
}
