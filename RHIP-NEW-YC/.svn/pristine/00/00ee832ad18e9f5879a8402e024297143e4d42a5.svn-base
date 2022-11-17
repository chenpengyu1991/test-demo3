package com.founder.rhip.ihm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.dto.TargetDTO;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;
import com.founder.rhip.ehr.service.statistics.ITargetOrgService;
import com.founder.rhip.ihm.controller.form.TargetQueryForm;
import com.founder.rhip.ihm.controller.form.TargetValueForm;

/**
 * 疾病控制
 * 
 */
@Controller
@RequestMapping("/hm/dc/")
public class IDMTargetController extends IHMBaseController {
	
    @Resource(name = "idmHealthTargetService")
    private IPublicHealthTarget idmHealthTarget;

    @Resource(name = "cdmPublicHealthService")
    private IPublicHealthTarget cdmPublicHealthService;

    @Resource(name = "mhmHealthTargetService")
    private IPublicHealthTarget mhmHealthTargetService;
    
	@Resource(name = "targetOrgService")
	private ITargetOrgService targetOrgService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		Date today = new Date();
		Date startDate = DateUtil.firstDateOfMonth(today);
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", today);
		return "ihm.idm.index";
	}
	

    @RequestMapping("/list")
    public String list(HttpServletRequest request,TargetQueryForm targetQueryForm, Model model) {
        String viewType = targetQueryForm.getViewType();
        Integer nextCodeType = targetQueryForm.getSelectOrgCodeNextCodeType();
        Integer codeType = targetQueryForm.getSelectOrgCodeType();
        String orgCode = targetQueryForm.getSelectOrgCode();
        codeType = codeType(request, codeType);
		orgCode = orgCode(request, orgCode);
		nextCodeType =nextCodeType(request, nextCodeType);
        ///统计指标数组
        String[] targetCodes = new String[20];
        List<TargetDTO> targetList=null;
        if("1".equals(viewType)){
            targetCodes = TargetConstants.cdmCodeArray();
           targetList = targetOrgService.getTargetDTOs(nextCodeType, codeType, orgCode,ITargetOrgService.GET_STATION,targetCodes);
        }else if("3".equals(viewType)){
            targetCodes = TargetConstants.MhmCodeArray();
            targetList = targetOrgService.getTargetDTOs(nextCodeType, codeType, orgCode,ITargetOrgService.GET_STATION,targetCodes);
        }else {
            targetCodes = TargetConstants.idmCodeArray();
             targetList = targetOrgService.getTargetDTOs(nextCodeType, codeType, orgCode,ITargetOrgService.GET_CENTER,targetCodes);
        }

        ///统计目标是中心,为True的时候查中心
        ///List<TargetDTO> targetList = targetOrgService.getTargetDTOs(nextCodeType, codeType, orgCode,true);
        model.addAttribute("targetList", targetList);
        model.addAttribute("viewType", viewType);
        return "ihm.idm.list";
    }
	
	@RequestMapping("/getValue")
	public @ResponseBody Float getValue(TargetValueForm targetValueForm, Model model) {
		setTime(targetValueForm);
        //统计目标是站
//		List<String> orgCodes1 = targetOrgService.getStationCodes(targetValueForm.getType(), targetValueForm.getCode());
		//统计目标是中心
		List<String> orgCodes2 = null;
        if(ObjectUtil.isNotEmpty(orgCodes2)){
//            orgCodes1.addAll(orgCodes2);
        }
        String viewType = targetValueForm.getViewType();
        Float at = 0f;
        if("2".equals(viewType)){ //传染病
        	orgCodes2 = targetOrgService.getCenters(targetValueForm.getType(), targetValueForm.getCode());
    		if(ObjectUtil.isNullOrEmpty(orgCodes2)){
    			return 0.0f;
    		}
            at = idmHealthTarget.getIDMTarget(orgCodes2, targetValueForm.getBeginTime(), targetValueForm.getEndTime(), targetValueForm.getTargetCode());
        }else if("3".equals(viewType)){ //精神卫生
        	at = mhmHealthTargetService.getMhmTarget(targetValueForm.getCode(), targetValueForm.getType().toString(), targetValueForm.getBeginTime(), targetValueForm.getEndTime(), targetValueForm.getTargetCode());
        }
        else { //慢病
        	List<String> orgCodes5 = new ArrayList<>();
        	List<String> orgCodes3 = targetOrgService.getCenters(targetValueForm.getType(), targetValueForm.getCode());
        	List<String> orgCodes4= targetOrgService.getStationCodes(targetValueForm.getType(), targetValueForm.getCode());
    		if (ObjectUtil.isNotEmpty(orgCodes3)) {
    			orgCodes5.addAll(orgCodes3);
			}
    		if (ObjectUtil.isNotEmpty(orgCodes4)) {
    			orgCodes5.addAll(orgCodes4);
    		}
        	if(ObjectUtil.isNullOrEmpty(orgCodes5)){
    			return 0.0f;
    		}
        	at = cdmPublicHealthService.getCDMTarget(orgCodes5, targetValueForm.getBeginTime(), targetValueForm.getEndTime(), targetValueForm.getTargetCode());
        }
		return at;
	}
	
	private void setTime(TargetValueForm form) {
		Date start=form.getBeginTime();
		Date end=form.getEndTime();
		if (null!=start) {
			form.setBeginTime(DateUtil.makeTimeToZero(start));
		}
		if(null!=end) {
			form.setEndTime(DateUtil.makeTimeToMax(end));
		}
	}
}