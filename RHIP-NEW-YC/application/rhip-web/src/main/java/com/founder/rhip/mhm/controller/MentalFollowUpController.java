package com.founder.rhip.mhm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.mhm.MhmManagementQueryDto;
import com.founder.rhip.ehr.service.IDualReferralService;
import com.founder.rhip.ehr.service.IOutPatientRecordService;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.controller.form.ManagementQueryForm;
import com.founder.rhip.mhm.service.IMhmManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/mhm/mentalFollowUp")
public class MentalFollowUpController extends MhmBaseController {
    @Resource(name = "mhmManagementService")
    private IMhmManagementService mhmManagementService;

    /**
     * 进入精神卫生随访/精神卫生体检人员列表查询页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/search/{type}")
    public String search(@PathVariable String type, HttpServletRequest request, ModelMap model) {
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
        if("1".equals(type)){//精神卫生随访菜单
            model.put("citeName", "精神卫生随访");
        }else if("2".equals(type)){
            model.put("citeName", "精神卫生体检");
        }
        model.addAttribute("searchSource",type);
        return "rhip.mhm.followup.search";
    }

    /**
     * 进入精神卫生随访/精神卫生体检人员列表页面
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/list")
    public String managementList(ManagementQueryForm form, HttpServletRequest request, ModelMap model) {
        if(StringUtil.isNotEmpty(form.getSearchSource())){
            model.addAttribute("searchSource", form.getSearchSource());
        }
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
        return "rhip.mhm.followup.list";
    }

    
}
