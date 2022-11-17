package com.founder.rhip.ihm.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.blood.BsBloodDonorInfo;
import com.founder.rhip.ehr.entity.jj.JjTacceptevent;
import com.founder.rhip.ehr.entity.jj.JjTalarmevent;
import com.founder.rhip.ehr.entity.jj.JjTambulance;
import com.founder.rhip.ehr.entity.jj.JjTtask;
import com.founder.rhip.ihm.controller.form.BloodJJQueryForm;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IBloodMgntService;
import com.founder.rhip.ihm.service.IEhrRecordStatisticsService;
import com.founder.rhip.ihm.service.IFirstAidService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 急救资源
 * 
 * @author Cary
 * @since 2014年7月30日 14:59:24
 */
@Controller
@RequestMapping("/firstAid")
public class FirstAidController extends IHMBaseController {

    @Resource(name = "firstAidService")
    private IFirstAidService firstAidService;

	/**
	 * 接受事件
	 */
	@RequestMapping("/acceptEvents/index")
	public String acceptEventsSearch(Model model) {
        model.addAttribute("searchUrl", "/firstAid/acceptEvents/list");
		return "ihm.firstAid.searchAcceptEvents";
	}

	@RequestMapping("/acceptEvents/list")
	public String bloodDonationList(HttpServletRequest request, BloodJJQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<JjTacceptevent> plist = firstAidService.getAcceptEventList(page, form.getAcceptEventCriteria());
        model.addAttribute("resultList", plist.getList());
        model.addAttribute("page", plist.getPage());
		return "ihm.firstAid.acceptEventsList";
	}

    @RequestMapping("/acceptEvents/detail")
    public String bloodDonationDetail(HttpServletRequest request, String id, Model model) {
        JjTacceptevent result = firstAidService.getAcceptEvent(new Criteria("ACCEPT_NO", id));
        model.addAttribute("result", result);
        return "ihm.firstAid.acceptEventsDetail";
    }

    /**
     * 车辆信息
     * @param model
     * @return
     */
	@RequestMapping("/ambulanceInfo/index")
	public String ambulanceInfoSearch(Model model) {
        model.addAttribute("searchUrl", "/firstAid/ambulanceInfo/list");
		return "ihm.firstAid.searchAmbulance";
	}

	@RequestMapping("/ambulanceInfo/list")
	public String bloodUseList(HttpServletRequest request, BloodJJQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<JjTambulance> plist = firstAidService.getAmbulanceList(page, form.getAmbulanceCriteria());
        model.addAttribute("resultList", plist.getList());
        model.addAttribute("page", plist.getPage());
		return "ihm.firstAid.ambulanceList";
	}

    @RequestMapping("/ambulanceInfo/detail")
    public String bloodUseList(HttpServletRequest request, String id, Model model) {
        JjTambulance result = firstAidService.getAmbulance(new Criteria("TAMBULANCE_NO", id));
        model.addAttribute("result", result);
        return "ihm.firstAid.ambulanceDetail";
    }

    /**
     * 呼叫事件
     * @param model
     * @return
     */
	@RequestMapping("/callEvents/index")
	public String callEventsSearch(Model model) {
        model.addAttribute("searchUrl", "/firstAid/callEvents/list");
		return "ihm.firstAid.searchCallEvents";
	}

	@RequestMapping("/callEvents/list")
	public String callEventsList(HttpServletRequest request, BloodJJQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<JjTalarmevent> plist = firstAidService.getCallEventList(page, form.getCallEventCriteria());
        model.addAttribute("resultList", plist.getList());
        model.addAttribute("page", plist.getPage());
		return "ihm.firstAid.callEventsList";
	}

    @RequestMapping("/callEvents/detail")
    public String callEventsDetail(HttpServletRequest request, String id, Model model) {
        JjTalarmevent result = firstAidService.getCallEvent(new Criteria("EVENT_NO", id));
        model.addAttribute("result", result);
        return "ihm.firstAid.callEventsDetail";
    }

    /**
     * 任务
     * @param model
     * @return
     */
    @RequestMapping("/task/index")
    public String taskSearch(Model model) {
        model.addAttribute("searchUrl", "/firstAid/task/list");
        return "ihm.firstAid.searchTask";
    }

    @RequestMapping("/task/list")
    public String taskList(HttpServletRequest request, BloodJJQueryForm form, Model model) {
        int currentPage = Integer.valueOf(request.getParameter("pageIndex"));
        Page page = super.getPage(request, currentPage);
        PageList<JjTtask> plist = firstAidService.getTaskList(page, form.getTaskCriteria());
        model.addAttribute("resultList", plist.getList());
        model.addAttribute("page", plist.getPage());
        return "ihm.firstAid.taskList";
    }

    @RequestMapping("/task/detail")
    public String taskdetail(HttpServletRequest request, String id, Model model) {
        JjTtask result = firstAidService.getTask(new Criteria("TASK_NO", id));
        model.addAttribute("result", result);
        return "ihm.firstAid.taskDetail";
    }
}
