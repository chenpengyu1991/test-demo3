package com.founder.rhip.mhm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.mhm.MhmClueQueryDto;
import com.founder.rhip.ehr.entity.management.mhm.MhmApprovalInfo;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.controller.form.MhmClueQueryForm;
import com.founder.rhip.mhm.dto.MhmClueDto;
import com.founder.rhip.mhm.service.IMhmApprovalInfoService;
import com.founder.rhip.mhm.service.IMhmClueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/mhm/clue")
public class ClueController extends MhmBaseController {

	@Resource(name = "mhmClueService")
	private IMhmClueService mhmClueService;

	@Resource(name = "mhmApprovalInfoService")
	private IMhmApprovalInfoService mhmApprovalInfoService;
	
	private final static String CONTROLLER_NAME = "精神卫生-线索登记";		
    /**
	 * 进入线索查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/search")
	public String search(HttpServletRequest request,ModelMap model) {
        putRole(request,model);		
		return "rhip.mhm.clue.search";
	}

    /**
	 * 进入线索查询画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/diagnosis/search")
	public String diagnosisSearch(HttpServletRequest request,ModelMap model) {
        putRole(request,model);		
		return "rhip.mhm.clue.search";
	}
    /**
     * 线索查询结果画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String list(MhmClueQueryForm form,HttpServletRequest request,ModelMap model) {
        Criteria ca = form.getClueCriteria();
        putRole(request,model);
        /*线索登记核实权限*/
		if (hasRole(RoleType.JKJFZX, request)){
			/*状态*/
			if (StringUtil.isNullOrEmpty(form.getReportStatus())){
				ca.add("status.STATUS",OP.IN,new Integer[]{1,2,3,4,6,7,8,9});
			}			
		}

        Organization org = getCurrentOrg(request);
        if(hasRole(RoleType.ZXJFYS, request)){
			if (StringUtil.isNullOrEmpty(form.getFillOrganCode())){//如果中心查询时不选择站，则查询该中心下所有站提交的数据
				ca.add("other.BELONG_CENTER",org.getOrganCode());
			}			
		}else if(hasRole(RoleType.ZJSB, request)){
            ca.add("other.FILL_ORGAN_CODE",org.getOrganCode());  //站只查自己线索登记的
        }

        PageList<MhmClueQueryDto> plist = mhmClueService.findMhmClueList(ca, buildPage(request));
        model.addAttribute("mhmClues", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "rhip.mhm.clue.list";
    }

    /**
     * 进入线索登记画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request,String pageIndex, Long statusId,String addType,String logoff, String notLoad, ModelMap model) {
    	MhmClueDto clueDto = mhmClueService.getMhmClue(statusId, MhmEvents.M_CLUE);
    	model.addAttribute("addType", addType);
        model.addAttribute("clueDto", clueDto);
        model.addAttribute("logoff", logoff);
        if (ObjectUtil.isNullOrEmpty(notLoad)) {
        	model.addAttribute("loadResourcesMark", "add"); // 进入线索登记页面，加载资源标记
		}
        putRole(request,model);
        return "rhip.mhm.clue.add";
    }

    /**
     * 进入线索登记画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/showClues")
    public String showClues(HttpServletRequest request,String pageIndex, ModelMap model) {
        String checkIds = request.getParameter("checkIds");
        model.addAttribute("checkIds", checkIds);
        return "rhip.mhm.clue.clues";
    }

	/**
	 * 保存线索登记
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/save")
	public String saveregister(MhmClueDto dto,HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = false;
		if(ObjectUtil.isNotEmpty(dto)){
			OperationName op = OperationName.ADD;
			dto.setCurrentUser(getCurrentUser(request));
			dto.setCurrentOrg(getCurrentOrg(request));
			if (hasRole(RoleType.JKJFZX, request)){
				dto.setRoleType(RoleType.JKJFZX);
			}
			if (hasRole(RoleType.ZXJFYS, request) ){
				dto.setRoleType(RoleType.ZXJFYS);
			}	
			if (hasRole(RoleType.ZJSB, request) ){
				dto.setRoleType(RoleType.ZJSB);
			}	
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long personId = mhmClueService.getPersonId(dto.getStatusId());
        	dto.setPersonId(personId);			
			updatePersonInfo(dto.getPersonInfo(),request);
			result = mhmClueService.creatMhmClue(dto);
	    	record(request, op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

	/**
	 * 审核线索登记
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/approval")
	public String approval(MhmClueDto dto,HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = false;
		if(ObjectUtil.isNotEmpty(dto)){
			OperationName op = OperationName.CHECK;
			dto.setCurrentUser(getCurrentUser(request));
			dto.setCurrentOrg(getCurrentOrg(request));
			if (hasRole(RoleType.JKJFZX, request)){
				dto.setRoleType(RoleType.JKJFZX);
			}
            if (hasRole(RoleType.ZXJFYS, request)){
                dto.setRoleType(RoleType.ZXJFYS);
            }
			if (hasRole(RoleType.ZJSB, request) ){
				dto.setRoleType(RoleType.ZJSB);
			}	
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long personId = mhmClueService.getPersonId(dto.getStatusId());
        	dto.setPersonId(personId);				
			updatePersonInfo(dto.getPersonInfo(),request);
			result = mhmClueService.approveMhmClue(dto);
			record(request, op);
		}
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}

    /**
     * 进入审批记录画面
     * @param statusId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/popuApproval")
    public String approval(Long statusId,HttpServletRequest request, ModelMap model){
    	model.addAttribute("statusId", statusId);
        return "rhip.mhm.approval.search";
    }	
    
    /**
     * 查询审批记录
     * @param statusId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/approvallist")
    public String approvallist(Long statusId,HttpServletRequest request, ModelMap model){
        Criteria ca = new Criteria("STATUS_ID",statusId);
        PageList<MhmApprovalInfo> plist = mhmApprovalInfoService.findApprovalInfo(ca,buildPage(request));
        model.addAttribute("approvalInfo",plist);
        model.addAttribute("page", plist.getPage());
        return "rhip.mhm.approval.list";
    }
    
	/**
	 * 根据idcard查询，该患者是否已经精卫系统中存在
	 *
	 * @param idcard
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 * @author Ye jianfei
	 */
	@RequestMapping("/validatePerson")
	public String validatePerson(String idcard,HttpServletResponse response, ModelMap model) throws IOException {
		if(ObjectUtil.isNotEmpty(idcard)) {
			idcard=idcard.trim();
		}
		Long count = mhmClueService.getPersonCount(idcard);
		Map<String, Object> map = new HashMap<String, Object>();
		if (ObjectUtil.isNotEmpty(count)) {
			map.put("validate", count>0?"true":"false");
        }
		return EHRMessageUtil.returnMsg(model, map);
	}
	
    private void putRole(HttpServletRequest request,ModelMap model){
		if (hasRole(RoleType.JKJFZX, request)){
			model.put("ROLE", RoleType.JKJFZX.getValue());
		}
		if (hasRole(RoleType.ZJSB, request) ){
			model.put("ROLE", RoleType.ZJSB.getValue());
		}
        if (hasRole(RoleType.ZXJFYS, request) ){
            model.put("ROLE", RoleType.ZXJFYS.getValue());
        }
    }
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}
}
