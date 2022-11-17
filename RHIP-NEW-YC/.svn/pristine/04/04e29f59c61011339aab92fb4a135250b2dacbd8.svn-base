package com.founder.rhip.mhm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.mhm.MhmManagementQueryDto;
import com.founder.rhip.ehr.entity.clinic.ReferralInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmOutpatientRecord;
import com.founder.rhip.ehr.service.IDualReferralService;
import com.founder.rhip.ehr.service.IOutPatientRecordService;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.entity.Disease;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.controller.form.ManagementQueryForm;
import com.founder.rhip.mhm.service.IMhmManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/mhm/management")
public class ManagementController extends MhmBaseController {
    @Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;

    @Resource(name = "dualReferralService")
    private IDualReferralService dualReferralService;

    @Resource(name = "outPatientService")
    private IOutPatientRecordService outPatientService;

    @Resource(name = "diseaseApp")
    private IDiseaseApp diseaseApp;

    /**
     * 进入精神病人管理查询画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public String search(HttpServletRequest request, ModelMap model) {
        if (hasRole(RoleType.JKJFZX, request)){
            model.put("ROLE", RoleType.JKJFZX.getValue());
            model.put("townValue", "");
        }
        if (hasRole(RoleType.ZXJFYS, request) ){
            model.put("ROLE", RoleType.ZXJFYS.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
        if (hasRole(RoleType.ZJSB, request) ){
            model.put("ROLE", RoleType.ZJSB.getValue());
            model.put("townValue", getCurrentOrg(request).getGbCode());
        }
        return "rhip.mhm.management.search";
    }

    /**
     * 精神病人管理列表
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String managementList(ManagementQueryForm form, HttpServletRequest request, ModelMap model) {
        Criteria ca = form.getMgntCriteria();
        /*事件：精神病人管理*/
        List<Integer> events = new ArrayList<Integer>();
        events.add(MhmEvents.M_ARCHIVES.getValue());
        ca.add("EVENT_TYPE", OP.IN, events);
        //中心权限
        if (hasRole(RoleType.ZXJFYS, request) ){
            ca.add("O.MANAGEMENT_CENTER", getCurrentOrg(request).getOrganCode());
        }
        //站权限
        if (hasRole(RoleType.ZJSB, request) ){
            ca.add("O.MANAGEMENT_STATION", getCurrentOrg(request).getOrganCode());
        }
        PageList<MhmManagementQueryDto> plist = mhmManagementService.findManagementList(ca, buildPage(request));
        model.addAttribute("mhmMgnts", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "rhip.mhm.management.list";
    }

    /**
     * 逻辑删除规范化管理主表数据
     */
    @RequestMapping("/delManageMentData")
    @ResponseBody
    public Map<String, Object> delManageMentData(Long statusId,String pixId,String idcard) {
        boolean result = false;
        result=mhmManagementService.delManageMentData(statusId,pixId,idcard);
        Map<String, Object> map = new HashMap<>();
        map.put("message", result ? "success" : "fail");
        return map;
    }

    /**
     * 精神病人管理详细画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String managementIndex(Long statusId,String logoff, String pixId, String bringIntoMode, HttpServletRequest request, ModelMap model) {
        model.put("statusId", statusId);
        model.put("logoff", logoff);
        model.put("pixId", pixId);
        model.put("bringIntoMode", bringIntoMode);
        return "rhip.mhm.management.index";
    }

    /**
     * 弹出迁出、纳入画面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/popupTransfer")
    public String popupTransfer(String type, HttpServletRequest request, ModelMap model) {
        model.addAttribute("type", type);
        return "rhip.mhm.management.transfer";
    }

    /**
     * 保存 迁出、纳入
     *
     * @param request
     * @param model
     * @throws Exception
     */
    @RequestMapping("/transfer")
    public String saveTransfer(HttpServletRequest request, ModelMap model) throws Exception {
        boolean result = true;
        return EHRMessageUtil.returnMsg(model, result ? "success" : "fail");
    }

    /**
     * 显示门诊信息
     *
     * @param request
     * @param model
     * @throws Exception
     */
    @RequestMapping("/outPatient")
    public String getOutRecords(String statusId, HttpServletRequest request, ModelMap model) throws Exception {
        Criteria criteria = new Criteria("E.STATUS_ID", statusId);
        criteria.add("E.EVENT_TYPE", MhmEvents.I_OUTPATIENT.getValue());
        List<MhmOutpatientRecord> outPatientRecords = outPatientService.getOutPatientRecords(criteria);
        model.addAttribute("outPatientRecords", outPatientRecords);
        return "rhip.mhm.management.outPatient";
    }
    
    /**
     * 显示转诊信息
     *
     * @param request
     * @param model
     * @throws Exception
     */
    @RequestMapping("/referral")
    public String getReferrals(String pixId, HttpServletRequest request, ModelMap model) throws Exception {
       
        List<ReferralInfo> referrals = dualReferralService.queryReferralInfoList(pixId, null, null);
        model.addAttribute("referrals", referrals);
        return "rhip.mhm.management.referral";
    }

    //精神卫生诊断结果集
    @RequestMapping("/complete/mhmDisease")
    @ResponseBody
    public List<Disease> queryDisease(@RequestParam(required = false, value = "inputValue") String key) {
        List<Disease> f = diseaseApp.queryDiseases(new Criteria(Disease.ICD10MAIN, OP.FLIKE, "F"));
        return f;
    }
    
}
