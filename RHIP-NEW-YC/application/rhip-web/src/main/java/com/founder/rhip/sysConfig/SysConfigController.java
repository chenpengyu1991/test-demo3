package com.founder.rhip.sysConfig;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.entity.sysConfig.ReportRefreshTime;
import com.founder.rhip.ehr.service.sysConfig.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 系统参数设置
 * @author Cary
 *
 */
@Controller
@RequestMapping("/sysConfig")
public class SysConfigController extends BaseController {

    @Autowired
    private ISysConfigService sysConfigService;
    /**
     * 消息提醒频率参数配置
     * @return
     */
    @RequestMapping("/reportRemind/frequency/index")
    public String refreshTime(HttpServletRequest request, ModelMap modelMap) {
        ReportRefreshTime reportRefreshTime = sysConfigService.getReportRefreshTime(new Criteria());
        modelMap.addAttribute("reportRefreshTime", reportRefreshTime);
        return "rhip.conifg.refreshTime.index";
    }

    @RequestMapping("/reportRemind/frequency/save")
    public String saveRefreshTime(HttpServletRequest request, ReportRefreshTime reportRefreshTime, ModelMap modelMap) {
        boolean result = false;
        sysConfigService.saveRefreshTime(reportRefreshTime);
        result = true;
        return EHRMessageUtil.returnMsg(modelMap, result ? "success" : "fail");
    }
}