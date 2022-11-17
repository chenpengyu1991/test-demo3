package com.founder.rhip.dmbc.controller;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.dmbc.controller.form.VertorQueryForm;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.control.dmbc.*;
import com.founder.rhip.ph.service.dmbc.IVertorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 病媒生物监测
 * @author mei_xingjian Vertor controller
 */
@Controller
@RequestMapping("/dmbc/vertor")
public class VertorController extends BaseController {

	@Resource(name = "dmbcVertorService")
	private IVertorService vertorService;

	// 鼠密度监测begin
	@RequestMapping("/mouseMonitor")
	public String mouseMonitorIndex(HttpServletRequest request, Model model) {
		return "rhip.dmbc.vertor.mouse.monitor.search";
	}

	@RequestMapping(value = "/mouseMonitor/list")
	public String searchMouseMonitor(VertorQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mouse.monitor.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<DmbcMouseMonitor> plist = vertorService.searchMouseMonitor(ca,
				page);
		model.addAttribute("mouseMonitorList", plist);
		model.addAttribute("page", plist.getPage());
		return url;
	}

	@RequestMapping(value = "/initMouseMonitorAdd")
	public String initMouseMonitorAdd(HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mouse.monitor.add";
		model.put("type", OHConstants.add);
		model.put("displayList", "display:none");
		return url;
	}

	@RequestMapping(value = "/saveMouseMonitor")
	public String saveMouseMonitor(DmbcMouseMonitor mouseMonitor, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mouse.monitor.add";
		if (OHConstants.add.equals(type)) {
			mouseMonitor.setCreateBy(getCurrentUser(request).getUserName());
			mouseMonitor.setCreateTime(new Date());
		}
		mouseMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		mouseMonitor.setUpdateTime(new Date());
		Boolean rs = vertorService.saveMouseMonitor(mouseMonitor, type);
		if (rs) {
			if (OHConstants.edit.equals(type)) {
				//addMouse(model, request, mouseMonitor.getId());
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-鼠密度监测",
						OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-鼠密度监测",
						OperationName.ADD);
			}
			model.put("type", OHConstants.edit);
		} else {
			model.put("type", OHConstants.add);
		}
		model.put("msg", rs);
		model.put("mouseMonitor", mouseMonitor);
		return url;
	}

	@RequestMapping("/delMouseMonitor")
	@ResponseBody
	public ModelMap delMouseMonitor(Long id, HttpServletRequest request) {
		DmbcMouseMonitor mouseMonitor = new DmbcMouseMonitor();
		mouseMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		mouseMonitor.setUpdateTime(new Date());
		mouseMonitor.setId(id);
		Boolean rs = vertorService.saveMouseMonitor(mouseMonitor,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "病媒监测-鼠密度监测",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	@RequestMapping(value = "/initMouseMonitorViewModify/{mouseMonitorId}")
	public String initMouseMonitorViewModify(
			@PathVariable("mouseMonitorId") Long mouseMonitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mouse.monitor.add";
		DmbcMouseMonitor mouseMonitor = vertorService
				.searchMouseMonitor(mouseMonitorId);
		//addMouse(model, request, mouseMonitorId);
		model.addAttribute("mouseMonitor", mouseMonitor);
		
		model.put("type", type);
		return url;
	}

	private void addMouse(ModelMap model,HttpServletRequest request,Long monitorId){
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", monitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcMouseCaught> mouseList = vertorService.searchMouse(page,
				ca);
		model.addAttribute("mouseList", mouseList);
		model.addAttribute("page", mouseList.getPage());
	}
	@RequestMapping(value = "/mouseList/{mouseMonitorId}")
	public String mouseList(
			@PathVariable("mouseMonitorId") Long mouseMonitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mouse.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", mouseMonitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcMouseCaught> mouseList = vertorService.searchMouse(page,
				ca);
		model.addAttribute("mouseList", mouseList);
		model.addAttribute("page", mouseList.getPage());
		model.addAttribute("type", type);
		return url;
	}

	@RequestMapping(value = "/initMouseAdd/{monitorId}")
	public String initMouseAdd(@PathVariable("monitorId") Long monitorId,
			Long id, HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mouse.add";
		DmbcMouseCaught mouse = null;
		if (id == null) {
			mouse = new DmbcMouseCaught();
			mouse.setMonitorId(monitorId);
			model.put("type", OHConstants.add);
		} else {
			mouse = vertorService.searchMouse(id);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("mouse", mouse);
		return url;
	}

	@RequestMapping("/saveMouse")
	@ResponseBody
	public ModelMap saveMouse(DmbcMouseCaught mouse, String type,
			HttpServletRequest request) {
		if (OHConstants.add.equals(type)) {
			mouse.setCreateBy(getCurrentUser(request).getUserName());
			mouse.setCreateTime(new Date());
		}
		mouse.setUpdateBy(getCurrentUser(request).getUserName());
		mouse.setUpdateTime(new Date());
		Boolean rs = vertorService.saveMouse(mouse, type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕鼠记录",
						OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕鼠记录",
						OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delMouse")
	@ResponseBody
	public ModelMap delMouse(Long id, HttpServletRequest request) {
		DmbcMouseCaught mouse = new DmbcMouseCaught();
		mouse.setUpdateBy(getCurrentUser(request).getUserName());
		mouse.setUpdateTime(new Date());
		mouse.setId(id);
		Boolean rs = vertorService.saveMouse(mouse, OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕鼠记录",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	// 鼠密度监测end

	// 成蚊监测begin
	@RequestMapping("/mosquitoesMonitor")
	public String mosquitoesMonitorIndex(HttpServletRequest request, Model model) {
		return "rhip.dmbc.vertor.mosquitoes.monitor.search";
	}
	
	@RequestMapping(value = "/mosquitoesMonitor/list")
	public String searchMosquitoesMonitor(VertorQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mosquitoes.monitor.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<DmbcMosquitoesMonitor> plist = vertorService.searchMosquitoesMonitor(ca,
				page);
		model.addAttribute("mosquitoesMonitorList", plist);
		model.addAttribute("page", plist.getPage());
		return url;
	}
	
	@RequestMapping(value = "/initMosquitoesMonitorAdd")
	public String initMosquitoesMonitorAdd(HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mosquitoes.monitor.add";
		model.put("type", OHConstants.add);
		model.put("displayList", "display:none");
		return url;
	}
	
	@RequestMapping(value = "/saveMosquitoesMonitor")
	public String saveMosquitoesMonitor(DmbcMosquitoesMonitor mosquitoesMonitor, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mosquitoes.monitor.add";
		if (OHConstants.add.equals(type)) {
			mosquitoesMonitor.setCreateBy(getCurrentUser(request).getUserName());
			mosquitoesMonitor.setCreateTime(new Date());
		}
		mosquitoesMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		mosquitoesMonitor.setUpdateTime(new Date());
		Boolean rs = vertorService.saveMosquitoesMonitor(mosquitoesMonitor, type);
		if (rs) {
			if (OHConstants.edit.equals(type)) {
				//addMosquitoes(request, model, mosquitoesMonitor.getId());
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-成蚊监测",
						OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-成蚊监测",
						OperationName.ADD);
			}
			model.put("type", OHConstants.edit);
		} else {
			model.put("type", OHConstants.add);
		}
		model.put("msg", rs);
		model.put("mosquitoesMonitor", mosquitoesMonitor);
		return url;
	}
	
	@RequestMapping("/delMosquitoesMonitor")
	@ResponseBody
	public ModelMap delMosquitoesMonitor(Long id, HttpServletRequest request) {
		DmbcMosquitoesMonitor mosquitoesMonitor = new DmbcMosquitoesMonitor();
		mosquitoesMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		mosquitoesMonitor.setUpdateTime(new Date());
		mosquitoesMonitor.setId(id);
		Boolean rs = vertorService.saveMosquitoesMonitor(mosquitoesMonitor,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "病媒监测-成蚊监测",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}
	
	@RequestMapping(value = "/initMosquitoesMonitorViewModify/{monitorId}")
	public String initMosquitoesMonitorViewModify(
			@PathVariable("monitorId") Long monitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mosquitoes.monitor.add";
		DmbcMosquitoesMonitor mosquitoesMonitor = vertorService
				.searchMosquitoesMonitor(monitorId);
		//addMosquitoes(request, model, monitorId);
		model.addAttribute("mosquitoesMonitor", mosquitoesMonitor);
		
		model.put("type", type);
		return url;
	}
	
	private void addMosquitoes(HttpServletRequest request, ModelMap model,Long monitorId){
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", monitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcMosquitoesCaught> mosquitoesList = vertorService.searchMosquitoes(page,
				ca);
		model.addAttribute("mosquitoesList", mosquitoesList);
		model.addAttribute("page", mosquitoesList.getPage());
	}

	@RequestMapping(value = "/mosquitoesList/{mosquitoesMonitorId}")
	public String mosquitoesList(
			@PathVariable("mosquitoesMonitorId") Long mosquitoesMonitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mosquitoes.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", mosquitoesMonitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcMosquitoesCaught> mosquitoesList = vertorService.searchMosquitoes(page,
				ca);
		model.addAttribute("mosquitoesList", mosquitoesList);
		model.addAttribute("page", mosquitoesList.getPage());
		model.addAttribute("type", type);
		return url;
	}

	@RequestMapping(value = "/initMosquitoesAdd/{monitorId}")
	public String initMosquitoesAdd(@PathVariable("monitorId") Long monitorId,
			Long id, HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.mosquitoes.add";
		DmbcMosquitoesCaught mosquitoes = null;
		if (id == null) {
			mosquitoes = new DmbcMosquitoesCaught();
			mosquitoes.setMonitorId(monitorId);
			model.put("type", OHConstants.add);
		} else {
			mosquitoes = vertorService.searchMosquitoes(id);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("mosquitoes", mosquitoes);
		return url;
	}

	@RequestMapping("/saveMosquitoes")
	@ResponseBody
	public ModelMap saveMosquitoes(DmbcMosquitoesCaught mosquitoes, String type,
			HttpServletRequest request) {
		if (OHConstants.add.equals(type)) {
			mosquitoes.setCreateBy(getCurrentUser(request).getUserName());
			mosquitoes.setCreateTime(new Date());
		}
		mosquitoes.setUpdateBy(getCurrentUser(request).getUserName());
		mosquitoes.setUpdateTime(new Date());
		Boolean rs = vertorService.saveMosquitoes(mosquitoes, type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕蚊记录",
						OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕蚊记录",
						OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delMosquitoes")
	@ResponseBody
	public ModelMap delMosquitoes(Long id, HttpServletRequest request) {
		DmbcMosquitoesCaught mosquitoes = new DmbcMosquitoesCaught();
		mosquitoes.setUpdateBy(getCurrentUser(request).getUserName());
		mosquitoes.setUpdateTime(new Date());
		mosquitoes.setId(id);
		Boolean rs = vertorService.saveMosquitoes(mosquitoes, OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕蚊记录",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}
	// 成蚊监测end
	
	//苍蝇监测 begin
	@RequestMapping("/flyMonitor")
	public String flyMonitorIndex(HttpServletRequest request, Model model) {
		return "rhip.dmbc.vertor.fly.monitor.search";
	}
	
	@RequestMapping(value = "/flyMonitor/list")
	public String searchFlyMonitor(VertorQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.fly.monitor.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<DmbcFlyMonitor> plist = vertorService.searchFlyMonitor(ca,
				page);
		model.addAttribute("flyMonitorList", plist);
		model.addAttribute("page", plist.getPage());
		return url;
	}
	
	@RequestMapping(value = "/initFlyMonitorAdd")
	public String initFlyMonitorAdd(HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.fly.monitor.add";
		model.put("type", OHConstants.add);
		model.put("displayList", "display:none");
		return url;
	}
	
	@RequestMapping(value = "/saveFlyMonitor")
	public String saveFlyMonitor(DmbcFlyMonitor flyMonitor, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.fly.monitor.add";
		if (OHConstants.add.equals(type)) {
			flyMonitor.setCreateBy(getCurrentUser(request).getUserName());
			flyMonitor.setCreateTime(new Date());
		}
		flyMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		flyMonitor.setUpdateTime(new Date());
		Boolean rs = vertorService.saveFlyMonitor(flyMonitor, type);
		if (rs) {
			if (OHConstants.edit.equals(type)) {
				//addFly(request, model, flyMonitor.getId());
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-苍蝇监测",
						OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-苍蝇监测",
						OperationName.ADD);
			}
			model.put("type", OHConstants.edit);
		} else {
			model.put("type", OHConstants.add);
		}
		model.put("msg", rs);
		model.put("flyMonitor", flyMonitor);
		return url;
	}
	
	@RequestMapping("/delFlyMonitor")
	@ResponseBody
	public ModelMap delFlyMonitor(Long id, HttpServletRequest request) {
		DmbcFlyMonitor flyMonitor = new DmbcFlyMonitor();
		flyMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		flyMonitor.setUpdateTime(new Date());
		flyMonitor.setId(id);
		Boolean rs = vertorService.saveFlyMonitor(flyMonitor,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "病媒监测-苍蝇监测",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}
	
	@RequestMapping(value = "/initFlyMonitorViewModify/{monitorId}")
	public String initFlyMonitorViewModify(
			@PathVariable("monitorId") Long monitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.fly.monitor.add";
		DmbcFlyMonitor flyMonitor = vertorService
				.searchFlyMonitor(monitorId);
		//addFly(request, model, monitorId);
		model.addAttribute("flyMonitor", flyMonitor);
		model.put("type", type);
		return url;
	}
	
	private void addFly(HttpServletRequest request, ModelMap model,Long monitorId){
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", monitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcFlyCaught> flyList = vertorService.searchFly(page,
				ca);
		model.addAttribute("flyList", flyList);
		model.addAttribute("page", flyList.getPage());
	}

	@RequestMapping(value = "/flyList/{flyMonitorId}")
	public String flyList(
			@PathVariable("flyMonitorId") Long flyMonitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.fly.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", flyMonitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcFlyCaught> flyList = vertorService.searchFly(page,
				ca);
		model.addAttribute("flyList", flyList);
		model.addAttribute("page", flyList.getPage());
		model.addAttribute("type", type);
		return url;
	}

	@RequestMapping(value = "/initFlyAdd/{monitorId}")
	public String initFlyAdd(@PathVariable("monitorId") Long monitorId,
			Long id, HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.fly.add";
		DmbcFlyCaught fly = null;
		if (id == null) {
			fly = new DmbcFlyCaught();
			fly.setMonitorId(monitorId);
			model.put("type", OHConstants.add);
		} else {
			fly = vertorService.searchFly(id);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("fly", fly);
		return url;
	}

	@RequestMapping("/saveFly")
	@ResponseBody
	public ModelMap saveFly(DmbcFlyCaught fly, String type,
			HttpServletRequest request) {
		if (OHConstants.add.equals(type)) {
			fly.setCreateBy(getCurrentUser(request).getUserName());
			fly.setCreateTime(new Date());
		}
		fly.setUpdateBy(getCurrentUser(request).getUserName());
		fly.setUpdateTime(new Date());
		Boolean rs = vertorService.saveFly(fly, type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕蝇记录",
						OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕蝇记录",
						OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delFly")
	@ResponseBody
	public ModelMap delFly(Long id, HttpServletRequest request) {
		DmbcFlyCaught fly = new DmbcFlyCaught();
		fly.setUpdateBy(getCurrentUser(request).getUserName());
		fly.setUpdateTime(new Date());
		fly.setId(id);
		Boolean rs = vertorService.saveFly(fly, OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕蝇记录",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}
	//苍蝇监测end
	
	//蟑螂监测begin
	@RequestMapping("/roachMonitor")
	public String roachMonitorIndex(HttpServletRequest request, Model model) {
		return "rhip.dmbc.vertor.roach.monitor.search";
	}
	
	@RequestMapping(value = "/roachMonitor/list")
	public String searchRoachMonitor(VertorQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.roach.monitor.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<DmbcRoachMonitor> plist = vertorService.searchRoachMonitor(ca,
				page);
		model.addAttribute("roachMonitorList", plist);
		model.addAttribute("page", plist.getPage());
		return url;
	}
	
	@RequestMapping(value = "/initRoachMonitorAdd")
	public String initRoachMonitorAdd(HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.roach.monitor.add";
		model.put("type", OHConstants.add);
		model.put("displayList", "display:none");
		return url;
	}
	
	@RequestMapping(value = "/saveRoachMonitor")
	public String saveRoachMonitor(DmbcRoachMonitor roachMonitor, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.roach.monitor.add";
		if (OHConstants.add.equals(type)) {
			roachMonitor.setCreateBy(getCurrentUser(request).getUserName());
			roachMonitor.setCreateTime(new Date());
		}
		roachMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		roachMonitor.setUpdateTime(new Date());
		Boolean rs = vertorService.saveRoachMonitor(roachMonitor, type);
		if (rs) {
			if (OHConstants.edit.equals(type)) {
				//addRoach(request, model, roachMonitor.getId());
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-蟑螂监测",
						OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-蟑螂监测",
						OperationName.ADD);
			}
			model.put("type", OHConstants.edit);
		} else {
			model.put("type", OHConstants.add);
		}
		model.put("msg", rs);
		model.put("roachMonitor", roachMonitor);
		return url;
	}
	
	@RequestMapping("/delRoachMonitor")
	@ResponseBody
	public ModelMap delRoachMonitor(Long id, HttpServletRequest request) {
		DmbcRoachMonitor roachMonitor = new DmbcRoachMonitor();
		roachMonitor.setUpdateBy(getCurrentUser(request).getUserName());
		roachMonitor.setUpdateTime(new Date());
		roachMonitor.setId(id);
		Boolean rs = vertorService.saveRoachMonitor(roachMonitor,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "病媒监测-蟑螂监测",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}
	
	@RequestMapping(value = "/initRoachMonitorViewModify/{monitorId}")
	public String initRoachMonitorViewModify(
			@PathVariable("monitorId") Long monitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.roach.monitor.add";
		DmbcRoachMonitor roachMonitor = vertorService
				.searchRoachMonitor(monitorId);
		//addRoach(request, model, monitorId);
		model.addAttribute("roachMonitor", roachMonitor);
		model.put("type", type);
		return url;
	}
	
	private void addRoach(HttpServletRequest request, ModelMap model,Long monitorId){
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", monitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcRoachCaught> roachList = vertorService.searchRoach(page,
				ca);
		model.addAttribute("roachList", roachList);
		model.addAttribute("page", roachList.getPage());
	}

	@RequestMapping(value = "/roachList/{roachMonitorId}")
	public String roachList(
			@PathVariable("roachMonitorId") Long roachMonitorId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.roach.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = new Criteria();
		ca.add("monitor_id", roachMonitorId);
		ca.add("is_delete", OHConstants.delete_0);
		PageList<DmbcRoachCaught> roachList = vertorService.searchRoach(page,
				ca);
		model.addAttribute("roachList", roachList);
		model.addAttribute("page", roachList.getPage());
		model.addAttribute("type", type);
		return url;
	}

	@RequestMapping(value = "/initRoachAdd/{monitorId}")
	public String initRoachAdd(@PathVariable("monitorId") Long monitorId,
			Long id, HttpServletRequest request, ModelMap model) {
		String url = "rhip.dmbc.vertor.roach.add";
		DmbcRoachCaught roach = null;
		if (id == null) {
			roach = new DmbcRoachCaught();
			roach.setMonitorId(monitorId);
			model.put("type", OHConstants.add);
		} else {
			roach = vertorService.searchRoach(id);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("roach", roach);
		return url;
	}

	@RequestMapping("/saveRoach")
	@ResponseBody
	public ModelMap saveRoach(DmbcRoachCaught roach, String type,
			HttpServletRequest request) {
		if (OHConstants.add.equals(type)) {
			roach.setCreateBy(getCurrentUser(request).getUserName());
			roach.setCreateTime(new Date());
		}
		roach.setUpdateBy(getCurrentUser(request).getUserName());
		roach.setUpdateTime(new Date());
		Boolean rs = vertorService.saveRoach(roach, type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕蟑螂记录",
						OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕蟑螂记录",
						OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delRoach")
	@ResponseBody
	public ModelMap delRoach(Long id, HttpServletRequest request) {
		DmbcRoachCaught roach = new DmbcRoachCaught();
		roach.setUpdateBy(getCurrentUser(request).getUserName());
		roach.setUpdateTime(new Date());
		roach.setId(id);
		Boolean rs = vertorService.saveRoach(roach, OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.DMBC, "病媒监测-捕蟑螂记录",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}
	//蟑螂监测end

	//汇总统计表
	@RequestMapping("/reportSearch")
	public String mouseReportSearch(ModelMap modelMap, String type) {
		modelMap.addAttribute("type", type);
		return "rhip.dmbc.vertor.reportSearch";
	}

	@RequestMapping("/mouse/report")
	public String report(HttpServletRequest request, ModelMap modelMap) {
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String townShip = request.getParameter("townShip");
		List<Map<String, Object>> report = vertorService.mouseReport(beginDate, endDate, townShip);
		modelMap.addAttribute("report", report);
		if (StringUtil.isNotEmpty(beginDate)) {
			modelMap.addAttribute("beginDate", DateUtil.parseSimpleDate(beginDate,"yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(endDate)) {
			modelMap.addAttribute("endDate", DateUtil.parseSimpleDate(endDate, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(townShip)) {
			modelMap.addAttribute("townShip", townShip);
		} else {
			modelMap.addAttribute("townShip", EHRConstants.FS990001_ROOT);
		}
		return "rhip.dmbc.vertor.mouse.report";
	}

	@RequestMapping("/mosquitoes/report")
	public String mosquitoesReport(HttpServletRequest request, ModelMap modelMap) {
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String townShip = request.getParameter("townShip");
		List<Map<String, Object>> report = vertorService.mosquitoesReport(beginDate, endDate, townShip);
		for (Map map : report) {
			String species = (String) map.get("SPECIES");
			species = removeDuplicateSpecies(species);
			map.put("SPECIES", species);
		}
		modelMap.addAttribute("report", report);
		if (StringUtil.isNotEmpty(beginDate)) {
			modelMap.addAttribute("beginDate", DateUtil.parseSimpleDate(beginDate, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(endDate)) {
			modelMap.addAttribute("endDate", DateUtil.parseSimpleDate(endDate, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(townShip)) {
			modelMap.addAttribute("townShip", townShip);
		} else {
			modelMap.addAttribute("townShip", EHRConstants.FS990001_ROOT);
		}
		return "rhip.dmbc.vertor.mosquitoes.report";
	}

	@RequestMapping("/fly/report")
	public String flyReport(HttpServletRequest request, ModelMap modelMap) {
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String townShip = request.getParameter("townShip");
		List<Map<String, Object>> report = vertorService.flyReport(beginDate, endDate, townShip);
		for (Map map : report) {
			String species = (String) map.get("SPECIES");
			species = removeDuplicateSpecies(species);
			map.put("SPECIES", species);
		}
		modelMap.addAttribute("report", report);
		if (StringUtil.isNotEmpty(beginDate)) {
			modelMap.addAttribute("beginDate", DateUtil.parseSimpleDate(beginDate, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(endDate)) {
			modelMap.addAttribute("endDate", DateUtil.parseSimpleDate(endDate, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(townShip)) {
			modelMap.addAttribute("townShip", townShip);
		} else {
			modelMap.addAttribute("townShip", EHRConstants.FS990001_ROOT);
		}
		return "rhip.dmbc.vertor.fly.report";
	}

	@RequestMapping("/roach/report")
	public String roachReport(HttpServletRequest request, ModelMap modelMap) {
		String beginDate = request.getParameter("beginDate");
		String endDate = request.getParameter("endDate");
		String townShip = request.getParameter("townShip");
		List<Map<String, Object>> report = vertorService.roachReport(beginDate, endDate, townShip);
		for (Map map : report) {
			String species = (String) map.get("SPECIES");
			species = removeDuplicateSpecies(species);
			map.put("SPECIES", species);
		}
		modelMap.addAttribute("report", report);
		if (StringUtil.isNotEmpty(beginDate)) {
			modelMap.addAttribute("beginDate", DateUtil.parseSimpleDate(beginDate, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(endDate)) {
			modelMap.addAttribute("endDate", DateUtil.parseSimpleDate(endDate, "yyyy/MM/dd"));
		}
		if (StringUtil.isNotEmpty(townShip)) {
			modelMap.addAttribute("townShip", townShip);
		} else {
			modelMap.addAttribute("townShip", EHRConstants.FS990001_ROOT);
		}
		return "rhip.dmbc.vertor.roach.report";
	}

	private String removeDuplicateSpecies(String species) {
		if (StringUtil.isNullOrEmpty(species)) {
			return null;
		}
		String[] arr = species.split(",");
		List<String> list = new ArrayList<>();
		for (String a : arr) {
			if (!list.contains(a)) {
				list.add(a);
			}
		}
		return StringUtils.collectionToCommaDelimitedString(list);
	}
}
