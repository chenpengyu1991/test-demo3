package com.founder.rhip.mhm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.management.mhm.*;
import com.founder.rhip.ehr.service.basic.IUploadInfoRecordService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmStatus;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.dto.MhmClueDto;
import com.founder.rhip.mhm.service.IMhmClueService;
import com.founder.rhip.mhm.service.IMhmManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/mhm/baseArchives")
public class BaseArchivesController extends MhmBaseController {
	@Resource(name = "mhmClueService")
	private IMhmClueService mhmClueService;
    @Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;
    @Resource(name = "uploadInfoRecordService")
    private IUploadInfoRecordService uploadInfoRecordService;
    
    @Resource(name = "platformService")
    private IPlatformService platformService;
	private final static String CONTROLLER_NAME = "精神卫生-规范化管理-基本档案";
    /**
	 * 进入基本档案画面
	 * @param statusId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/init")
	public String init(Long statusId, String logoff, HttpServletRequest request,ModelMap model) {
        ManagementDto managementDto = mhmManagementService.getMhmManagement(statusId, MhmEvents.M_ARCHIVES);
        //获取患者病历附件
        List<UploadInfoRecord> uploadInfoRecords =null;
        if(ObjectUtil.isNotEmpty(managementDto.getMhmBasicsInfo())){
            uploadInfoRecords = uploadInfoRecordService.queryUploadInfoRecord(new Criteria("RESOURCE_ID", managementDto.getMhmBasicsInfo().getId()).add("FILE_RESOURCE", "jszahzbl"));
        }
        model.addAttribute("attches", uploadInfoRecords);
        model.put("managementDto", managementDto);
        model.put("logoff", logoff);
        return "rhip.mhm.mgnt.baseArchives";
	}

    @RequestMapping("/save")
    public String saveMgnt(ManagementDto dto, String saveFlag, HttpServletRequest request,ModelMap model) throws Exception{
        boolean result = false;
        Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("hzbl_fileMap"); // 附件
        Map<String, String> fileNameMap = (Map<String, String>) request.getSession().getAttribute("hzbl_filenameMap"); // 附件文件名
        MhmClueDto clueDto = new MhmClueDto();
        if(ObjectUtil.isNotEmpty(dto)){
        	if(ObjectUtil.isNotEmpty(dto.getMhmBasicsInfo().getIdcard())){
                PersonInfo personInfo = platformService.queryPersonalInfo(null, dto.getMhmBasicsInfo().getIdcard().trim());
                // 检查是否被注销
                if (EHRConstants.HAD_OFF.equals(personInfo.getFilingFlag())) {
                    return EHRMessageUtil.returnMsg(model, "cancel");
                }
            }
            dto.setCurrentUser(getCurrentUser(request));
            if(StringUtil.isNotEmpty(saveFlag)){ //已保存管理信息
            }else {/*//未保存管理信息
                dto.setEventId(null);
                dto.getMhmBasicsInfo().setId(null);
                dto.getMhmOtherInfo().setId(null);
                dto.getMhmDiagnosis().setId(null);
                dto.getMhmPathHistory().setId(null);
            */
            	//根据身份证号码判断是否已保存病人基本信息
                MhmBasicsInfo basicsInfo =mhmManagementService.findBasicInfoByIdCard(dto.getMhmBasicsInfo().getIdcard().trim());
                if(ObjectUtil.isNotEmpty(basicsInfo)){
                    return  EHRMessageUtil.returnMsg(model, "basicInfoExists");
                }
            	//未保存管理信息
            	clueDto.setLogoff(dto.getLogoff());//0
        		clueDto.setMhmBasicsInfo(dto.getMhmBasicsInfo());
        		clueDto.setMhmDiagnosis(dto.getMhmDiagnosis());
        		clueDto.setMhmOtherInfo(dto.getMhmOtherInfo());
        		clueDto.setMhmSign(dto.getMhmSign());

        		if(ObjectUtil.isNotEmpty(clueDto)){
        			clueDto.setCurrentUser(getCurrentUser(request));
        			clueDto.setCurrentOrg(getCurrentOrg(request));
        			if (hasRole(RoleType.JKJFZX, request)){
        				clueDto.setRoleType(RoleType.JKJFZX);
        			}
        			if (hasRole(RoleType.ZXJFYS, request)){
                        clueDto.setRoleType(RoleType.ZXJFYS);
                    }
                    if (hasRole(RoleType.ZJSB, request)){
                        clueDto.setRoleType(RoleType.ZJSB);
                    }		
                	clueDto.setStatus(MhmStatus.VERIFY_DIAGNOSIS.getValue());
                	clueDto.getMhmDiagnosis().setReCheck(2);
        			updatePersonInfo(clueDto.getPersonInfo(),request);
        			mhmClueService.creatMhmClue(clueDto);
        		}
        		dto.setStatusId(clueDto.getStatusId());
        		dto.setEventId(clueDto.getEventId());          
             /*   dto.setEventId(null);
                dto.getMhmBasicsInfo().setId(null);
                dto.getMhmOtherInfo().setId(null);
                dto.getMhmDiagnosis().setId(null);
                dto.getMhmPathHistory().setId(null);*/
            	
            
            }
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long personId = mhmManagementService.getPersonId(dto.getStatusId());
        	dto.setPersonId(personId);	            
            updatePersonInfo(dto.getPersonInfo(),request);
            dto.setFileMap(fileMap);//保存附件
            dto.setFileNameMap(fileNameMap);//附件文件名
            result = mhmManagementService.saveMhmManagement(dto, MhmEvents.M_ARCHIVES, MhmStatus.MANAGEMENT.getValue());
        	OperationName  opName = ObjectUtil.isNullOrEmpty(saveFlag)?OperationName.ADD:OperationName.UPDATE;
        	record(request, opName);
            // 保存成功清理session
            if (ObjectUtil.isNotEmpty(fileMap)) {
                request.getSession().removeAttribute("hzbl_fileMap");
            }
            if (ObjectUtil.isNotEmpty(fileNameMap)) {
                request.getSession().removeAttribute("hzbl_filenameMap");
            }

        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    @RequestMapping("/saveBaseInfo")
    public String saveBaseInfo(ManagementDto dto,String saveFlag, HttpServletRequest request,ModelMap model) throws Exception{
        boolean result = false;
        Map<String, String> fileMap = (Map<String, String>) request.getSession().getAttribute("hzbl_fileMap"); // 附件
        Map<String, String> fileNameMap = (Map<String, String>) request.getSession().getAttribute("hzbl_filenameMap"); // 附件文件名
        MhmClueDto clueDto = new MhmClueDto();
        if(ObjectUtil.isNotEmpty(dto)){
        	if(ObjectUtil.isNotEmpty(dto.getMhmBasicsInfo().getIdcard())){
                PersonInfo personInfo = platformService.queryPersonalInfo(null, dto.getMhmBasicsInfo().getIdcard().trim());
                // 检查是否被注销
                if(ObjectUtil.isNotEmpty(personInfo)) {
                	if (EHRConstants.HAD_OFF.equals(personInfo.getFilingFlag())) {
                        return EHRMessageUtil.returnMsg(model, "cancel");
                    }
                }
                
            }
            dto.setCurrentUser(getCurrentUser(request));
            if(StringUtil.isNotEmpty(saveFlag)){ //已保存管理信息
            }else {/*//未保存管理信息
                dto.setEventId(null);
                dto.getMhmBasicsInfo().setId(null);
                dto.getMhmOtherInfo().setId(null);
                dto.getMhmDiagnosis().setId(null);
                dto.getMhmPathHistory().setId(null);
            */
            	//未保存管理信息
                /* dto.setEventId(null);
                 dto.getMhmBasicsInfo().setId(null);
                 dto.getMhmOtherInfo().setId(null);
                 dto.getMhmDiagnosis().setId(null);
                 dto.getMhmPathHistory().setId(null);*/
                //根据身份证号码判断是否已保存病人基本信息
                MhmBasicsInfo basicsInfo =mhmManagementService.findBasicInfoByIdCard(dto.getMhmBasicsInfo().getIdcard().trim());
                if(ObjectUtil.isNotEmpty(basicsInfo)){
                    return  EHRMessageUtil.returnMsg(model, "basicInfoExists");
                }
             	clueDto.setLogoff(dto.getLogoff());//0
         		clueDto.setMhmBasicsInfo(dto.getMhmBasicsInfo());
         		clueDto.setMhmDiagnosis(dto.getMhmDiagnosis());
         		clueDto.setMhmOtherInfo(dto.getMhmOtherInfo());
         		clueDto.setMhmSign(dto.getMhmSign());

         		if(ObjectUtil.isNotEmpty(clueDto)){
         			clueDto.setCurrentUser(getCurrentUser(request));
         			clueDto.setCurrentOrg(getCurrentOrg(request));
         			if (hasRole(RoleType.JKJFZX, request)){
         				clueDto.setRoleType(RoleType.JKJFZX);
         			}if (hasRole(RoleType.ZXJFYS, request)){
                        clueDto.setRoleType(RoleType.ZXJFYS);
                    }
                    if (hasRole(RoleType.ZJSB, request)){
                        clueDto.setRoleType(RoleType.ZJSB);
                    }		
                     //获取PERSON_ID modify by yjf 20140107
                 	//personId = mhmClueService.getPersonId(dto.getStatusId());
                 	//clueDto.setPersonId(personId);  
                 	clueDto.setStatus(MhmStatus.VERIFY_DIAGNOSIS.getValue());
                 	clueDto.getMhmDiagnosis().setReCheck(2);
         			updatePersonInfo(clueDto.getPersonInfo(),request);
         			mhmClueService.creatMhmClue(clueDto);
         		}
         		dto.setStatusId(clueDto.getStatusId());
         		dto.setEventId(clueDto.getEventId());     
             	
            }
            /*获取PERSON_ID modify by yjf 20140107*/
        	Long personId = mhmManagementService.getPersonId(dto.getStatusId());
        	dto.setPersonId(personId);	               
            updatePersonInfo(dto.getPersonInfo(),request);
            dto.setFileMap(fileMap);//保存附件
            dto.setFileNameMap(fileNameMap);//附件文件名
            result = mhmManagementService.saveMhmManagement(dto, MhmEvents.M_ARCHIVES, MhmStatus.NO_MANAGEMENT.getValue());
        	OperationName  opName = ObjectUtil.isNullOrEmpty(saveFlag)?OperationName.ADD:OperationName.UPDATE;
        	record(request, opName);
            // 保存成功清理session
            if (ObjectUtil.isNotEmpty(fileMap)) {
                request.getSession().removeAttribute("hzbl_fileMap");
            }
            if (ObjectUtil.isNotEmpty(fileNameMap)) {
                request.getSession().removeAttribute("hzbl_filenameMap");
            }
        }
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 进入出院信息画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/initOutInfo")
    public String initOutInfo(HttpServletRequest request,ModelMap model) {
        return "rhip.mhm.mgnt.outInfo";
    }

    /**
     * 进入病人类型变更记录画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/patientType")
    public String patientType(String eventId, HttpServletRequest request,ModelMap model) {
        String pageIndex = request.getParameter("pageIndex");
        int currentPage = Integer.valueOf(pageIndex);
        Page page = super.getPage(request, currentPage);
        Criteria ca = new Criteria("eventId", eventId);
        PageList<MhmSeverity> plist = mhmManagementService.getPatientTypeList(ca, page, new Order("START_DT", true));
        model.put("patientTypes", plist.getList());
        model.put("page", plist.getPage());
        return "rhip.mhm.mgnt.patientType";
    }

    /**
     * 进入免费服药明细画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/drugFree")
    public String drugFree(String eventId, HttpServletRequest request,ModelMap model) {
        String pageIndex = request.getParameter("pageIndex");
        int currentPage = Integer.valueOf(pageIndex);
        Page page = super.getPage(request, currentPage);
        Criteria ca = new Criteria("eventId", eventId);
        PageList<MhmDrugFree> plist = mhmManagementService.getDrugFreeList(ca,page, new Order("START_DT",true));
        model.put("drugFrees", plist.getList());
        model.put("page", plist.getPage());
        return "rhip.mhm.mgnt.drugFree";
    }

    /**
     * 进入管理变更明细画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/mgntType")
    public String mgntType(String eventId, HttpServletRequest request,ModelMap model) {
        String pageIndex = request.getParameter("pageIndex");
        int currentPage = Integer.valueOf(pageIndex);
        Page page = super.getPage(request, currentPage);
        Criteria ca = new Criteria("eventId", eventId);
        PageList<MhmManageType> plist = mhmManagementService.getManageTypeList(ca, page, new Order("START_DT", true));
        model.put("manageTypes", plist.getList());
        model.put("page", plist.getPage());
        return "rhip.mhm.mgnt.managementType";
    }

    /**
     * 进入管理变更明细画面
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/economyHistory")
    public String economyHistory(String eventId, HttpServletRequest request,ModelMap model) {
        String pageIndex = request.getParameter("pageIndex");
        int currentPage = Integer.valueOf(pageIndex);
        Page page = super.getPage(request, currentPage);
        Criteria ca = new Criteria("eventId", eventId);
        PageList<MhmEconomy> plist = mhmManagementService.getEconomyHistory(ca, page, new Order("START_DT", true));
        model.put("economyHistory", plist.getList());
        model.put("page", plist.getPage());
        return "rhip.mhm.mgnt.economyHistory";
    }
	@Override
	protected String getActionName() {
		return CONTROLLER_NAME;
	}
}
