package com.founder.rhip.im.monitor;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.MachineInfo;
import com.founder.rhip.ehr.service.basic.IMachineMonitorService;
import com.founder.rhip.im.monitor.form.MachineMonitorQueryForm;
import com.founder.rhip.mdm.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 硬件监控
 * @author Jin Jicheng
 */
@Controller
@RequestMapping(value = "/machine/monitor")
public class MachineMonitorController extends BaseController {

    @Resource(name = "machineMonitorService")
    private IMachineMonitorService machineMonitorService;

    
	/**
	 * 进入硬件监控页面
	 */
	@RequestMapping(value = "/search")
	public String search(HttpServletRequest request, Model model) {
		
		return "com.founder.rhip.im.monitor.machineMonitor.search";
		
	}
	
    /**
     * 查詢硬件監控信息
     * @param reportRecordQueryForm
     * @param model
     * @return
     */
    @RequestMapping(value = "/list")
    public String reportSearch(HttpServletRequest request, MachineMonitorQueryForm reportRecordQueryForm, Model model) {
        String indexPage = request.getParameter("indexPage");
        int currentPage = Integer.valueOf(indexPage);
        Page page = super.getPage(request, currentPage);
        Criteria ca = reportRecordQueryForm.getCriteria();
        String order =  "createTime desc";

        PageList<MachineInfo> plist = machineMonitorService.findPageReportRecord(ca, page, order);//MachineInfo

        model.addAttribute("machineInfoList", plist.getList());
        model.addAttribute("page", plist.getPage());

        return "com.founder.rhip.im.monitor.machineMonitor.list";
    }

}
