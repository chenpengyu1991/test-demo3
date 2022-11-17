package com.founder.rhip.scheduling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.rhip.scheduling.service.ITaskService;
import com.founder.rhip.scheduling.vo.SchedulerVo;

/**
 * @author liuk
 * 
 */
@RequestMapping("/task/scheduler")
@Controller
public class SchedulerController {

	private Logger logger = LoggerFactory.getLogger(SchedulerController.class);

	@Autowired
	private ITaskService quartzTask;

	@RequestMapping(value = "/index")
	public String home(Model model) {
		SchedulerVo schedulerVo = quartzTask.getSchedulerStatus();
		model.addAttribute("scheduler", schedulerVo);
		return "rhip.scheduling.task.scheduler.index";
	}

	@RequestMapping(value = "/start")
	@ResponseBody
	public Object start() {
		boolean result = true;
		try {
			quartzTask.start();
		} catch (Exception e) {
			result = false;
		}
		return result;

	}

	@RequestMapping(value = "/stop")
	@ResponseBody
	public Object stop() {
		boolean result = true;
		try {
			quartzTask.stop();
		} catch (Exception e) {
			result = false;
		}
		return result;

	}

}
