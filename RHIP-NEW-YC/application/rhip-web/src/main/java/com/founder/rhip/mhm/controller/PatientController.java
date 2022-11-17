package com.founder.rhip.mhm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.mhm.MhmClueQueryDto;
import com.founder.rhip.ehr.dto.mhm.MhmMoveQueryDto;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.management.mhm.MhmOtherInfo;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmMoveStatus;
import com.founder.rhip.mhm.common.MhmStatus;
import com.founder.rhip.mhm.controller.form.MhmClueQueryForm;
import com.founder.rhip.mhm.controller.form.MhmMoveQueryForm;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.dto.MhmMoveDto;
import com.founder.rhip.mhm.service.IMhmClueService;
import com.founder.rhip.mhm.service.IMhmManagementService;
import com.founder.rhip.mhm.service.IMhmMoveService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/mhm/patient")
public class PatientController extends MhmBaseController {

	@Resource(name = "mhmClueService")
	private IMhmClueService mhmClueService;
    @Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;
    @Resource(name = "mhmMoveService")
    private IMhmMoveService mhmMoveService;
    @Resource(name = "uploadInfoRecordService")
    private IUploadInfoRecordService uploadInfoRecordService;
	private final static String CONTROLLER_NAME = "精神卫生-迁入迁出";
    /**
     * 进入患者筛查查询画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/into")
    public String into(HttpServletRequest request,ModelMap model) {
        return "rhip.mhm.patient.into.search";
    }

    /**
     * 进入患者筛查列表画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/into/list")
    public String search(MhmClueQueryForm form,HttpServletRequest request,ModelMap model) {
        Criteria ca = form.getPatientIntoCriteria();
        //只查看待建档案盒已建档的数据
        if(!ca.contains("status.STATUS")){
            List params = new ArrayList();
            params.add(MhmStatus.VERIFY_CHECK.getValue());
            params.add(MhmStatus.NO_MANAGEMENT.getValue());
            params.add(MhmStatus.MANAGEMENT.getValue());
            params.add(MhmStatus.DEAD.getValue());
            ca.add("status.STATUS", OP.IN, params.toArray());
        }
		if(hasRole(RoleType.ZXJFYS, request)){
			Organization org = getCurrentOrg(request);
			if (StringUtil.isNullOrEmpty(form.getFillOrganCode())){//如果中心查询时不选择站，则查询该中心下所有站提交的数据
				ca.add("other.BELONG_CENTER",org.getOrganCode());
			}			
		}
        PageList<MhmClueQueryDto> plist = mhmClueService.findMhmClueList(ca, buildPage(request));
        model.addAttribute("mhmClues", plist.getList());
        model.addAttribute("page", plist.getPage());    	
        return "rhip.mhm.patient.into.list";
    }

    /**
     * 进入【纳入－基本档案】画面
     * @param statusId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/into/add")
    public String basicInfo(Long eventId, Long statusId,String logoff, HttpServletRequest request,ModelMap model) {
        ManagementDto managementDto = new ManagementDto();
        managementDto.setStatusId(statusId);
//        managementDto.setEventId(eventId);
        ManagementDto mgntDto = mhmManagementService.getMhmManagement(statusId, MhmEvents.M_ARCHIVES);
        managementDto.setMhmBasicsInfo(mgntDto.getMhmBasicsInfo());
        MhmOtherInfo mhmOtherInfo = mgntDto.getMhmOtherInfo();
        if(!ObjectUtil.isNotEmpty(mhmOtherInfo)){
            mhmOtherInfo = new MhmOtherInfo();
        }
        mhmOtherInfo.setFillDoctorId(getCurrentUser(request).getId().toString());
        mhmOtherInfo.setFillDate(new Date());
        mhmOtherInfo.setFillOrganCode(getCurrentOrg(request).getOrganCode());
        managementDto.setMhmOtherInfo(mhmOtherInfo);
        managementDto.setMhmDiagnosis(mgntDto.getMhmDiagnosis());
        managementDto.setMhmPathHistory(mgntDto.getMhmPathHistory());
        //获取患者病历附件
        List<UploadInfoRecord> uploadInfoRecords =null;
        if(ObjectUtil.isNotEmpty(mgntDto.getMhmBasicsInfo())){
            uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", mgntDto.getMhmBasicsInfo().getId()).add("FILE_RESOURCE", "jszahzbl"));
        }
        model.addAttribute("attches", uploadInfoRecords);
        model.put("managementDto", managementDto);
        model.put("logoff", logoff);
        return "rhip.mhm.patient.into.add";
    }

    /**
     * 进入迁入迁出查询画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/move")
    public String move(HttpServletRequest request,String pageIndex, ModelMap model) {
        return "rhip.mhm.patient.move.search";
    }

    /**
     * 迁入迁出列表画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/move/list")
    public String moveList(MhmMoveQueryForm form, HttpServletRequest request, ModelMap model) {
        Criteria ca = form.getMoveCriteria();
        //精防中心查全部，其他机构查自己的或者等待自己纳入的
        if (!hasRole(RoleType.JKJFZX, request)){
        	if(StringUtil.isNullOrEmpty(form.getMoveInOrgan())){//不选迁入单位
        		if(StringUtil.isNullOrEmpty(form.getTransferStatus())
        				|| "1".equals(form.getTransferStatus())){//状态为空和“待纳入”，查自己的或者等待自己纳入的
  	              Criteria ca1 = new Criteria();
  	              Criteria ca2 = new Criteria();
  	              ca2.add("MOVE_IN_ORGAN", getCurrentOrg(request).getOrganCode());//等待纳入的
  	              ca2.add(LOP.AND,"M.FLAG", OP.NOTIN, new String []{MhmMoveStatus.BACK.getValue(),MhmMoveStatus.NO.getValue()});//等待纳入的,状态不是退回、取消迁出
  	              ca1.add("management_station", getCurrentOrg(request).getOrganCode());//自己管理的
  	              ca1.add(LOP.OR, ca2);	
  	              ca.add(LOP.AND,ca1);         			
        		}else{
        			ca.add("management_station", getCurrentOrg(request).getOrganCode());    
        		}
        	}else {//选择迁入单位
        		Criteria ca1 = new Criteria();
 	            Criteria ca2 = new Criteria();
        		if(!form.getMoveInOrgan().equals(getCurrentOrg(request).getOrganCode())){//如果迁入单位不是本单位
        			 ca2.add("MOVE_OUT_ORGAN", getCurrentOrg(request).getOrganCode());
        		}else{//迁入单位是本单位：已纳入、待纳入
        			ca2.add("MOVE_IN_ORGAN", getCurrentOrg(request).getOrganCode());
        			ca2.add(LOP.AND,"M.FLAG", OP.NOTIN, new String []{MhmMoveStatus.BACK.getValue(),MhmMoveStatus.NO.getValue()});//等待纳入的,状态不是退回、取消迁出
        		}
        		ca1.add("management_station", getCurrentOrg(request).getOrganCode());//自己管理的
	            ca1.add(LOP.OR, ca2);	
	            ca.add(LOP.AND,ca1);  
        	}
        }
        PageList<MhmMoveQueryDto> plist = mhmMoveService.findMoveList(ca, buildPage(request));
        model.addAttribute("mhmMoves", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.mhm.patient.move.list";
    }
    
	/**
	 * 弹出迁出、纳入画面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/move/popupTransfer")
	public String popupTransfer(String type, Long id, String eventId, HttpServletRequest request,ModelMap model) {
        Criteria cr = new Criteria();
        cr.add("eventId", eventId);
        if(null != id && StringUtil.isNotEmpty(id.toString())){
            cr.add("id", id);
        }
        MhmMoveDto moveDto = mhmMoveService.getMove(cr);
        //如果是迁出，则迁出相关信息都应该是空的
        if(type.equalsIgnoreCase(MhmMoveStatus.OUT.getValue())){
            moveDto.setMove(null);
        }
        model.addAttribute("moveDto", moveDto);
        model.addAttribute("type", type);
		return "rhip.mhm.patient.move.transfer";
	}
	
	/**
	 * 保存 纳入、退回
	 * @param request
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping("/move/transfer")
	public String saveTransfer(String type, MhmMoveDto moveDto, HttpServletRequest request,ModelMap model) throws Exception{
		boolean result = true;
        moveDto.setMoveStatus(type);
        moveDto.setCurrentUser(getCurrentUser(request));
        moveDto.setCurrentOrg(getCurrentOrg(request));
        result = mhmMoveService.saveMove(moveDto);
        OperationName  opName = ObjectUtil.isNullOrEmpty(moveDto.getMhmBasicsInfo()) || ObjectUtil.isNullOrEmpty(moveDto.getMhmBasicsInfo().getId())?OperationName.ADD:OperationName.UPDATE;
    	record(request, opName);        
		return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
	}
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}	
}
