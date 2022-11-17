package com.founder.rhip.ehr.controller.woman;

import com.founder.elb.common.MessageUtils;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.ehr.entity.women.DeliveryRecordInfo;
import com.founder.rhip.ehr.service.IBrwHealthService;
import com.founder.rhip.ehr.service.woman.IDeliveryService;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.ihm.controller.form.WChQueryForm;
import com.founder.rhip.ihm.service.IWchSearchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @Author BaGen
 * @Description:
 * @Date Created in 10:46 2017/3/24.
 */
@Controller
@RequestMapping("/ehr/delivery")
public class DeliveryController extends BaseController {

    @Resource(name = "wchSearchService")
    private IWchSearchService wchSearchService;

    @Resource(name = "brwHealthService")
    private IBrwHealthService brwHealthService;

    @Resource(name = "deliveryService")
    private IDeliveryService deliveryService;

    @Resource(name = "personInfoService")
	private IPersonInfoService personInfoService;
	

    /**
     * 产妇分娩记录初始化
     * @return
     */
    @RequestMapping("/index")
    public String deliveryIndex(HttpServletRequest request, WChQueryForm form, Model model) {
        initOrg(request, model);
        return "rhip.ehr.woman.delivery.search";
    }

    /**
     * 产妇分娩记录查询
     * @return
     */
    @RequestMapping("/search")
    public String deliverySearch(HttpServletRequest request, WChQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        Boolean flg = SecurityUtils.hasRole(RoleType.ZX_GLY, request) || hasRole(RoleType.QWGZX,request)|| hasRole(RoleType.ADMIN,request);
		List<String> orgCodes = this.getOrgCodeByOrgCode(request);
		form.setOrganCode(request.getParameter("orgCode"));
        PageList<DeliveryRecordInfo> plist = deliveryService.getDeliveryList(flg, orgCodes, form.getParamMap(), page,request);
        model.addAttribute("womanList", plist.getList());
        model.addAttribute("currentOrganCode",getCurrentOrg(request).getOrganCode());
        model.addAttribute("page", plist.getPage());

        return "rhip.ehr.woman.delivery.list";
    }

    /**
     * 产妇分娩记录新增
     * @return
     */
    @RequestMapping("/add")
    public String deliveryList(String deliveryId, HttpServletRequest request, WChQueryForm form, Model model) {
        DeliveryRecordInfo deliveryRecordInfo = new DeliveryRecordInfo();
        deliveryRecordInfo = null;
        //修改的情况
        if(ObjectUtil.isNotEmpty(deliveryId)) {
            Criteria criteria = new Criteria();
            criteria.add("id", Long.valueOf(deliveryId));
            deliveryRecordInfo  = deliveryService.getDelivery(criteria);
        }
        model.addAttribute("deliveryRecordInfo", deliveryRecordInfo);
        return "rhip.ehr.woman.delivery.edit";
    }

    /**
     * 分娩查看
     * @param personId
     * @param model
     * @return
     */
    @RequestMapping("/delivery")
    public String getDeliveryRecordInfo(String personId, ModelMap model,String type){
        Criteria criteria = new Criteria();
        criteria.add("id", personId);
        DeliveryRecordInfo deliveryRecordInfo = deliveryService.getDelivery(criteria);
        if(ObjectUtil.isNullOrEmpty(deliveryRecordInfo)){
            return "rhip.ehr.browser.error";
        }
        model.addAttribute("deliveryRecordInfo", deliveryRecordInfo);
        if("dialogView".equals(type)){
            return "rhip.ehr.woman.delivery.view1";
        }
        return "rhip.ehr.woman.delivery.view";
    }

    /**
     * 分娩登记保存
     * @param deliveryDate
     * @param model
     * @return
     */
    @RequestMapping("/save")
    public void deliverySave(String deliveryDate, DeliveryRecordInfo deliveryRecordInfo, HttpServletRequest request, HttpServletResponse response , ModelMap model){
        Criteria criteria = new Criteria();
        deliveryRecordInfo.setDeliveryDate(DateUtil.parseSimpleDate(deliveryDate,"yyyy/MM/dd HH:mm"));
        deliveryRecordInfo.setCreateOrganCode(this.getCurrentOrg(request).getOrganCode());
        deliveryRecordInfo.setCreateOrganName(this.getCurrentOrg(request).getOrganName());
        deliveryRecordInfo.setOperate(this.getCurrentUser(request).getUserName());
        deliveryRecordInfo.setIsDelete((short)0);
        //妇女保健号 现在默认系统自动生成 年月日时分+8位随机数 数据库判断唯一性
        String dateString = DateUtil.toDateString(deliveryRecordInfo.getDeliveryDate(),"yyyyMMddHHmm");
        String randomRecordNumber =dateString+(int)((Math.random()*9+1)*10000000);
        deliveryRecordInfo.setRecordNumber(randomRecordNumber);
        deliveryService.saveDelivery(deliveryRecordInfo);
        	List<WomenChildHealth> womenChildHealthList=null;
    		if(ObjectUtil.isNotEmpty(deliveryRecordInfo.getIdCard())){
    			womenChildHealthList=wchSearchService.getWomenChildHealthSumList(new Criteria("ID_CARD", OP.EQ, deliveryRecordInfo.getIdCard()));
    		}
    		if(ObjectUtil.isNullOrEmpty(womenChildHealthList)){
    			WomenChildHealth childHealth=new WomenChildHealth();
    			childHealth.setBabyCardNo("");
    			childHealth.setIdCard(deliveryRecordInfo.getIdCard());
    			childHealth.setCreateDate(new Date());
    			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
    			childHealth.setCreatePerson(currentLoginInfo.getUser().getUserName());
    			childHealth.setGender("2");
    			childHealth.setOrgCode(deliveryRecordInfo.getCreateOrganCode());
    			childHealth.setOrgName("");
    			childHealth.setChildBirthday(deliveryRecordInfo.getBirthday());
    			childHealth.setName(deliveryRecordInfo.getName());
    			childHealth.setIdentityType("2");
    			childHealth.setIsDelete("0");
    			childHealth.setUpdateDate(new Date());
    			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
    			childHealth.setPersonId(deliveryRecordInfo.getPersonId().toString());
    			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",deliveryRecordInfo.getIdCard()));
    			if(ObjectUtil.isNotEmpty(personInfo)){
    				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
    				childHealth.setPersonId(personInfo.getId().toString());
    			}
    			wchSearchService.inerstWomenChildHealth(childHealth);
    		}else{

    			WomenChildHealth childHealth=womenChildHealthList.get(0);
    			childHealth.setBabyCardNo("");
    			childHealth.setIdCard(deliveryRecordInfo.getIdCard());
    			childHealth.setUpdateDate(new Date());
    			CurrentLoginInfo currentLoginInfo = (CurrentLoginInfo) request.getSession().getAttribute("currentLoginInfo");
    			childHealth.setUpdatePerson(currentLoginInfo.getUser().getUserName());
    			childHealth.setGender("2");
    			childHealth.setOrgCode(deliveryRecordInfo.getCreateOrganCode());
    			childHealth.setOrgName(deliveryRecordInfo.getCreateOrganName());
    			childHealth.setChildBirthday(deliveryRecordInfo.getBirthday());
    			childHealth.setName(deliveryRecordInfo.getName());
    			childHealth.setPersonId(deliveryRecordInfo.getPersonId().toString());
    			childHealth.setIdentityType("2");
    			PersonInfo personInfo= personInfoService.getPersonInfoId(new Criteria("IDCARD",deliveryRecordInfo.getIdCard()));
    			if(ObjectUtil.isNotEmpty(personInfo)){
    				childHealth.setHealthFileNo(personInfo.getHealthFileNo());
    				childHealth.setPersonId(personInfo.getId().toString());
    			}
    			wchSearchService.updateWomenChildHealth(childHealth);
    		
    		}
        
        MessageUtils.outputJSONResult("success",response);
    }

    /**
     * 分娩登记删除
     * @param deliveryId
     * @param model
     * @return
     */
    @RequestMapping("/delete")
    public void deliveryDel(String deliveryId, HttpServletRequest request,ModelMap model,HttpServletResponse response) {
        Criteria criteria = new Criteria();
        //新增
        criteria.add("id", deliveryId);
        DeliveryRecordInfo sdeliveryRecordInfo = brwHealthService.getDeliveryRecordInfo(criteria);
        if (ObjectUtil.isNullOrEmpty(sdeliveryRecordInfo)) {
            MessageUtils.outputJSONResult("fail",response);
        } else {
            sdeliveryRecordInfo.setIsDelete((short)1);
            deliveryService.saveDelivery(sdeliveryRecordInfo);
            MessageUtils.outputJSONResult("success", response);
        }
    }
}
