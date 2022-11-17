package com.founder.rhip.mhm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.controller.form.MhmUseDrugQueryForm;
import com.founder.rhip.mhm.dto.MhmDrugUseDto;
import com.founder.rhip.mhm.service.IMhmDrugService;
import com.founder.rhip.mhm.service.IMhmManagementService;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.mhm.MhmManagementQueryDto;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrugUse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/mhm/useDrug")
public class DrugUseController extends MhmBaseController {

	@Resource(name = "mhmDrugService")
	private IMhmDrugService mhmDrugService;

    @Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;
	private final static String CONTROLLER_NAME = "精神卫生-发药登记";	 
    /**
     * 发药登记查询画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest request,ModelMap model) {
    	//站权限
        if (hasRole(RoleType.ZJSB, request) ){
        	model.addAttribute("stationCode", getCurrentOrg(request).getOrganCode());
        }
        return "rhip.mhm.useDrug.search";
    }

    /**
     * 发药登记列表
     *
     * @param query
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/list")
    public String list(MhmUseDrugQueryForm query,HttpServletRequest request,ModelMap model) {
        Criteria ca = query.getUseDrugCriteria();
        /*事件：精神病人管理*/
        List<Integer> events = new ArrayList<Integer>();
        events.add(MhmEvents.M_ARCHIVES.getValue());
        ca.add("EVENT_TYPE", OP.IN, events);
        //中心权限
        if (hasRole(RoleType.ZXJFYS, request) ){
            ca.add("O.MANAGEMENT_CENTER", getCurrentOrg(request).getOrganCode());
        }
        //站权限
        if (hasRole(RoleType.ZJSB, request)){
            ca.add("O.MANAGEMENT_STATION", getCurrentOrg(request).getOrganCode());
        }        
        PageList<MhmManagementQueryDto> plist = mhmManagementService.findManagementList(ca, buildPage(request));
        model.addAttribute("mhmMgnts", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.mhm.useDrug.list";
    }

    /**
     * 进入患者发药登记画面
     *
     * @param statusId
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/edit")
    public String edit(Long statusId,HttpServletRequest request,ModelMap model) {
    	MhmDrugUseDto mhmUseDrugDto = mhmDrugService.getDrugUse(statusId);
    	model.put("mhmUseDrugDto", mhmUseDrugDto);		
        return "rhip.mhm.useDrug.add";
    }

    /**
     * 获取患者发药登记列表
     *
     * @param statusId
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/drugList")
    public String drugList(Long statusId,HttpServletRequest request,ModelMap model) {
    	Criteria ca = new Criteria("druguse.STATUS_ID",statusId);
    	PageList<MhmDrugUse> plist = mhmDrugService.findDrugUseList(ca, buildPage(request));
    	model.addAttribute("mhmDrugUseList", plist.getList());
    	model.addAttribute("page", plist.getPage());		
        return "rhip.mhm.useDrug.drugList";
    }

    /**
     * 弹出发药登记画面
     *
     * @param statusId:状态表ID
     * @param useDrugId：发药表ID
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/popuDrugUse")
    public String popuDrugUse(Long statusId,Long drugUseId,HttpServletRequest request,ModelMap model) {
  		MhmDrugUse mhmDrugUse = new MhmDrugUse();
  		if(ObjectUtil.isNotEmpty(drugUseId)){
  			Criteria ca = new Criteria("druguse.ID",drugUseId);
  			model.addAttribute("type", "edit");
  			mhmDrugUse = mhmDrugService.getDrugUse(ca);
  		}else{
  			mhmDrugUse.setUseDt(new Date());
  			model.addAttribute("type", "add");
  		}
        model.addAttribute("mhmDrugUse", mhmDrugUse);
        model.addAttribute("statusId", statusId);
        return "rhip.mhm.useDrug.popuDrugUse";
    }
	/**
	 * 保存发药登记
	 * @param drugUse
	 * @param request
	 * @param model
	 */
	@RequestMapping("/saveDrugUse")
	public String saveDrugUse(MhmDrugUse drugUse,HttpServletRequest request,ModelMap model){
		boolean result = false;
		if(ObjectUtil.isNotEmpty(drugUse)){
			OperationName op = OperationName.ADD;
			if(ObjectUtil.isNotEmpty(drugUse.getId())){
				op = OperationName.UPDATE;
			}
			updateModify(drugUse,request);
			result = mhmDrugService.saveDrugUse(drugUse);
	    	record(request, op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	
	/**
	 * 删除发药登记信息
	 * @param drugUseId
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/deleteDrugUse")
	public String deleteDrugUse(Long drugUseId,HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = true;
		if(ObjectUtil.isNotEmpty(drugUseId)){
			result = mhmDrugService.deleteDrugUse(drugUseId);
	    	/*记录日志*/
	    	record(request, OperationName.DELETE);
		}		
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}	
	
    /**
     * 发药查询画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/drugUseSearch")
    public String drugUseSearch(HttpServletRequest request,ModelMap model) {
    	//站权限
        if (hasRole(RoleType.ZJSB, request) ){
        	model.addAttribute("fillOrganStation", getCurrentOrg(request).getOrganCode());
        }
        return "rhip.mhm.useDrug.drugUseSearch";
    }
    /**
     * 发药查询列表
     *
     * @param query
     * @param request
     * @param model
     * @return
     * @author Ye jianfei
     */
    @RequestMapping("/drugUselist")
    public String drugUselist(MhmUseDrugQueryForm query,HttpServletRequest request,ModelMap model) {
        Criteria ca = query.getCriteria();
        //中心权限
        if (hasRole(RoleType.ZXJFYS, request) ){
            ca.add("druguse.FILL_ORGAN_CENTER", getCurrentOrg(request).getOrganCode());
        }
        //站权限
        if (hasRole(RoleType.ZJSB, request)){
            ca.add("druguse.fill_Organ_Station", getCurrentOrg(request).getOrganCode());
        }        
        PageList<MhmDrugUse> plist = mhmDrugService.findDrugUseList(ca, buildPage(request));
        model.addAttribute("drugUses", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.mhm.useDrug.drugUseList";
    }    
	/**
	 * 设置药品创建人、更新人等信息
	 *
	 * @param drug
	 * @param request
	 * @author Ye jianfei
	 */
	private void updateModify(MhmDrugUse drugUse,HttpServletRequest request){
		Organization org = getCurrentOrg(request);
		String townCode = org.getGbCode();//镇编码
		String centerCode="";//中心编码
		String stationCode="";//站编码
		if(hasRole(RoleType.ZXJFYS, request)){
			centerCode = org.getOrganCode();
		}
		if(hasRole(RoleType.ZJSB, request)){
			centerCode = org.getParentCode();
			stationCode = org.getOrganCode();
		}		
		if(ObjectUtil.isNullOrEmpty(drugUse.getId())){
			drugUse.setFillDate(new Date());
			drugUse.setFillDoctorId(getCurrentUser(request).getId().toString());
			drugUse.setFillOrganTown(townCode);
			drugUse.setFillOrganCenter(centerCode);
			drugUse.setFillOrganStation(stationCode);
		}
		drugUse.setIsDelete(0);
		drugUse.setModifyDate(new Date());
		drugUse.setModifyDoctorId(getCurrentUser(request).getId().toString());
		drugUse.setModifyOrganTown(townCode);
		drugUse.setModifyOrganCenter(centerCode);
		drugUse.setModifyOrganStation(stationCode);		
	}
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}	
}
