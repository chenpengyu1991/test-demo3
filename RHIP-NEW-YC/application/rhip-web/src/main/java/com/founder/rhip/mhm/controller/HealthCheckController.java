package com.founder.rhip.mhm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.entity.management.mhm.MhmPhysicalExamination;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmStatus;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.service.IMhmManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping(value = "/mhm/healthCheck")
public class HealthCheckController extends MhmBaseController {

    @Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;
    private final static String CONTROLLER_NAME = "精神卫生-健康体检";

    /**
     * 进入健康体检主画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/main")
    public String healthCheckMain(String statusId, String searchType,HttpServletRequest request, ModelMap model) {
        if(StringUtil.isNotEmpty(searchType)){
            model.put("searchType",searchType);
        }
        model.addAttribute("statusId", statusId);
        return "rhip.mhm.management.healthCheck.main";
    }

    /**
     * 查询健康体检列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String healthCheckList(String statusId, HttpServletRequest request, ModelMap model) {
        Criteria ca = new Criteria("event_type", MhmEvents.M_HEALTH_CHECK.getValue());
        ca.add("statusId", statusId);
        PageList<MhmPhysicalExamination> plist = mhmManagementService.getMhmHealthCheckList(ca, buildPage(request));
        model.addAttribute("statusId", statusId);
        model.addAttribute("plist", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.mhm.management.healthCheck.list";
    }

    /**
     * 进入健康体检新增/查看画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/edit")
    public String editHealthCheck(Long statusId, String id, HttpServletRequest request, ModelMap model) {

        MhmPhysicalExamination physicalExamination = new MhmPhysicalExamination();
        if (StringUtil.isNotEmpty(id)) {//编辑页面
            physicalExamination = mhmManagementService.getHealthCheck(new Criteria("id", id));
        } else { //初始页面
            ManagementDto mhmDto = mhmManagementService.getMhmManagement(statusId, MhmEvents.M_ARCHIVES);
            physicalExamination.setName(mhmDto.getMhmBasicsInfo().getName());
            physicalExamination.setGender(mhmDto.getMhmBasicsInfo().getGender());
            physicalExamination.setIdcard(mhmDto.getMhmBasicsInfo().getIdcard());
            physicalExamination.setBirthdate(mhmDto.getMhmBasicsInfo().getBirthdate());
            physicalExamination.setMarriage(mhmDto.getMhmBasicsInfo().getMarriage());
            physicalExamination.setContactPhone(mhmDto.getMhmBasicsInfo().getContactPhone());
            physicalExamination.setPatownShip(mhmDto.getMhmBasicsInfo().getPatownShip());
            physicalExamination.setPastreet(mhmDto.getMhmBasicsInfo().getPastreet());
            physicalExamination.setPaGroup(mhmDto.getMhmBasicsInfo().getPaGroup());
            physicalExamination.setPahouseNumber(mhmDto.getMhmBasicsInfo().getPahouseNumber());
        }
        model.addAttribute("nowDate", new Date());
        model.addAttribute("statusId", statusId);
        model.addAttribute("healthCheck", physicalExamination);
        return "rhip.mhm.management.healthCheck.edit";
    }

    /**
     * 保存健康体检
     *
     * @param request
     * @param model
     * @throws Exception
     */
    @RequestMapping("/save")
    public String saveHealthCheck(MhmPhysicalExamination healthCheck, Long statusId, HttpServletRequest request, ModelMap model) throws Exception {
        boolean result = true;

        if(!ObjectUtil.isNotEmpty(healthCheck.getFillDate())){
            healthCheck.setFillDate(new Date());
            healthCheck.setFillOrganCode(getCurrentOrg(request).getOrganCode());
            healthCheck.setFillDoctorId(getCurrentUser(request).getId().toString());
        }

        healthCheck.setModifyOrganCode(getCurrentOrg(request).getOrganCode());
        healthCheck.setModifyDate(new Date());
        healthCheck.setModifyDoctorId(getCurrentUser(request).getId().toString());

        ManagementDto managementDto = new ManagementDto();
        managementDto.setStatusId(statusId);
        managementDto.setCurrentUser(getCurrentUser(request));
        managementDto.setMhmPhysicalExamination(healthCheck);
        result = mhmManagementService.saveMhmManagement(managementDto, MhmEvents.M_HEALTH_CHECK, MhmStatus.MANAGEMENT.getValue());
        OperationName opName = ObjectUtil.isNullOrEmpty(healthCheck.getId()) ? OperationName.ADD : OperationName.UPDATE;
        record(request, opName);
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 删除健康体检
     *
     * @param request
     * @param model
     * @throws Exception
     */
    @RequestMapping("/delete")
    public String deleteHealthCheck(Long eventId, HttpServletRequest request, ModelMap model) throws Exception {
        boolean result = true;
        result = mhmManagementService.deleteHealthCheck(eventId);
        record(request, OperationName.DELETE);
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    @Override
    protected String getActionName() {
        return CONTROLLER_NAME;
    }
}
