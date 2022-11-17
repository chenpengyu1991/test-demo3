package com.founder.rhip.oh.controller;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.entity.control.oh.OhChemicalsUsed;
import com.founder.rhip.ehr.entity.control.oh.OhCondition;
import com.founder.rhip.ehr.entity.control.oh.OhContactSituation;
import com.founder.rhip.ehr.entity.control.oh.OhEnterpriseInfo;
import com.founder.rhip.ehr.entity.control.oh.OhEquipment;
import com.founder.rhip.ehr.entity.control.oh.OhTestItems;
import com.founder.rhip.oh.controller.form.EnterpriseQueryForm;
import com.founder.rhip.ph.service.oh.IEnterpriseDocService;

/**
 * 
 * @author mei_xingjian EnterpriseDocHome controller
 */
@Controller
@RequestMapping("/oh/enterpriseDoc")
public class EnterpriseDocController extends BaseController {

	@Resource(name = "ohEnterpriseDocService")
	private IEnterpriseDocService enterpriseDocService;

	@RequestMapping("/index")
	public String enterpriseDocHome(HttpServletRequest request, Model model) {
		return "rhip.oh.enterprise.search";
	}

	@RequestMapping(value = "/enterpriselist")
	public String searchEnterpriseInfo(EnterpriseQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.list";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria ca = null;
		ca = form.getCriteria();
		PageList<OhEnterpriseInfo> plist = enterpriseDocService
				.searchEnterpriseInfoList(ca, page);
		model.addAttribute("enterpriseList", plist);
		model.addAttribute("page", plist.getPage());
		return url;
	}

	@RequestMapping("/delEnterprise")
	@ResponseBody
	public ModelMap delEnterprise(Long id, HttpServletRequest request) {
		OhEnterpriseInfo enterprise = new OhEnterpriseInfo();
		enterprise.setUpdateBy(getCurrentUser(request).getUserName());
		enterprise.setUpdateTime(new Date());
		enterprise.setIsDelete(OHConstants.delete_1);
		enterprise.setId(id);
		Boolean rs = enterpriseDocService.saveEnterpriseInfo(enterprise,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.OH, "重点企业服务档案-删除档案",
					OperationName.DELETE);

		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	@RequestMapping(value = "/initAddView")
	public String initAdd(HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.add";
		model.put("type", OHConstants.add);
		return url;
	}

	@RequestMapping(value = "/initViewModify/{enterpriseId}")
	public String initViewModify(
			@PathVariable("enterpriseId") Long enterpriseId,
			String operatorType, HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.add";
		Criteria criteria = new Criteria();
		criteria.add("id", enterpriseId);
		OhEnterpriseInfo enterpriseInfo = enterpriseDocService
				.searchEnterpriseInfo(criteria);
		model.addAttribute("enterpriseInfo", enterpriseInfo);
		model.put("type", operatorType != null ? operatorType
				: OHConstants.edit);
		return url;
	}

	@RequestMapping(value = "/saveEnterpriseInfo")
	public String saveEnterpriseInfo(OhEnterpriseInfo enterpriseInfo,
			String type, HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.info";
		enterpriseInfo.setCreateBy(getCurrentUser(request).getUserName());
		enterpriseInfo.setCreateTime(new Date());
		enterpriseInfo.setUpdateBy(getCurrentUser(request).getUserName());
		enterpriseInfo.setUpdateTime(new Date());
		Boolean rs = enterpriseDocService.saveEnterpriseInfo(enterpriseInfo,
				type);
		if (rs) {
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-修改基本信息", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-新增基本信息", OperationName.ADD);
			}
			model.put("type", OHConstants.edit);
		} else {
			model.put("type", OHConstants.add);
		}
		model.put("msg", rs);
		model.put("enterpriseInfo", enterpriseInfo);
		return url;
	}

	@RequestMapping(value = "/condition/{enterpriseId}")
	public String condition(@PathVariable("enterpriseId") Long enterpriseId,
			String type, HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.condition";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = new Criteria();
		criteria.add("is_delete", 0);
		criteria.add("enterprise_info_id", enterpriseId);
		PageList<OhCondition> plist = enterpriseDocService.searchConditionList(
				criteria, page);
		model.addAttribute("conditionList", plist);
		model.addAttribute("page", plist.getPage());
		model.put("enterpriseId", enterpriseId);
		model.put("type", type);
		return url;
	}

	@RequestMapping(value = "/initAddViewCondition/{enterpriseId}")
	public String initAddCondition(
			@PathVariable("enterpriseId") Long enterpriseId, Long id,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.condition.add";
		OhCondition condition = null;
		if (id == null) {
			condition = new OhCondition();
			condition.setEnterpriseInfoId(enterpriseId);
			model.put("type", OHConstants.add);
		} else {
			Criteria criteria = new Criteria();
			criteria.add("id", id);
			condition = enterpriseDocService.searchCondition(criteria);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("condition", condition);
		return url;
	}

	@RequestMapping("/saveCondition")
	@ResponseBody
	public ModelMap saveCondition(OhCondition condition, String type,
			HttpServletRequest request) {
		condition.setCreateBy(getCurrentUser(request).getUserName());
		condition.setCreateTime(new Date());
		condition.setUpdateBy(getCurrentUser(request).getUserName());
		condition.setUpdateTime(new Date());
		Boolean rs = enterpriseDocService.saveCondition(condition, type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-修改职业卫生情况", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-新增职业卫生情况", OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delCondition")
	@ResponseBody
	public ModelMap delCondition(Long id, HttpServletRequest request) {
		// Criteria criteria=new Criteria();
		// criteria.add("id", id);
		OhCondition condition = new OhCondition();
		condition.setUpdateBy(getCurrentUser(request).getUserName());
		condition.setUpdateTime(new Date());
		condition.setIsDelete(OHConstants.delete_1);
		condition.setId(id);
		Boolean rs = enterpriseDocService.saveCondition(condition,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.OH, "重点企业服务档案-删除职业卫生情况",
					OperationName.DELETE);
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	/**
	 * 化学物质使用
	 * 
	 * @param enterpriseId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/chemicalsUsed/{enterpriseId}")
	public String chemicalsUsed(
			@PathVariable("enterpriseId") Long enterpriseId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.chemicalsUsed";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = new Criteria();
		criteria.add("is_delete", 0);
		criteria.add("enterprise_info_id", enterpriseId);
		PageList<OhChemicalsUsed> plist = enterpriseDocService
				.searchChemicalsUsedList(criteria, page);
		model.addAttribute("chemicalsUsed", plist);
		model.addAttribute("page", plist.getPage());
		model.put("enterpriseId", enterpriseId);
		model.put("type", type);
		return url;
	}

	/**
	 * 添加、修改使用化学物质
	 * 
	 * @param enterpriseId
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/initAddViewChemicalsUsed/{enterpriseId}")
	public String initAddViewChemicalsUsed(
			@PathVariable("enterpriseId") Long enterpriseId, Long id,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.chemicalsUsed.add";
		OhChemicalsUsed chemicalsUsed = null;
		if (id == null) {
			chemicalsUsed = new OhChemicalsUsed();
			chemicalsUsed.setEnterpriseInfoId(enterpriseId);
			model.put("type", OHConstants.add);
		} else {
			Criteria criteria = new Criteria();
			criteria.add("id", id);
			chemicalsUsed = enterpriseDocService.searchChemicalsUsed(criteria);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("chemicalsUsed", chemicalsUsed);
		return url;
	}

	@RequestMapping("/saveChemicalsUsed")
	@ResponseBody
	public ModelMap saveChemicalsUsed(OhChemicalsUsed chemicalsUsed,
			String type, HttpServletRequest request) {
		chemicalsUsed.setCreateBy(getCurrentUser(request).getUserName());
		chemicalsUsed.setCreateTime(new Date());
		chemicalsUsed.setUpdateBy(getCurrentUser(request).getUserName());
		chemicalsUsed.setUpdateTime(new Date());
		Boolean rs = enterpriseDocService
				.saveChemicalsUsed(chemicalsUsed, type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-修改化学物质使用", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-新增化学物质使用", OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delChemicalsUsed")
	@ResponseBody
	public ModelMap delChemicalsUsed(Long id, HttpServletRequest request) {
		OhChemicalsUsed chemicalsUsed = new OhChemicalsUsed();
		chemicalsUsed.setUpdateBy(getCurrentUser(request).getUserName());
		chemicalsUsed.setUpdateTime(new Date());
		chemicalsUsed.setIsDelete(OHConstants.delete_1);
		chemicalsUsed.setId(id);
		Boolean rs = enterpriseDocService.saveChemicalsUsed(chemicalsUsed,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.OH, "重点企业服务档案-删除化学物质使用",
					OperationName.DELETE);
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	/**
	 * 危害因素接触
	 * 
	 * @param enterpriseId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contactSituation/{enterpriseId}")
	public String contactSituation(
			@PathVariable("enterpriseId") Long enterpriseId, String type,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.contactSituation";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = new Criteria();
		criteria.add("is_delete", 0);
		criteria.add("enterprise_info_id", enterpriseId);
		PageList<OhContactSituation> plist = enterpriseDocService
				.searchContactSituationList(criteria, page);
		model.addAttribute("contactSituation", plist);
		model.addAttribute("page", plist.getPage());
		model.put("enterpriseId", enterpriseId);
		model.put("type", type);
		return url;
	}

	/**
	 * 添加、修改危害因素接触
	 * 
	 * @param enterpriseId
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/initAddViewContactSituation/{enterpriseId}")
	public String initAddViewContactSituation(
			@PathVariable("enterpriseId") Long enterpriseId, Long id,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.contactSituation.add";
		OhContactSituation contactSituation = null;
		if (id == null) {
			contactSituation = new OhContactSituation();
			contactSituation.setEnterpriseInfoId(enterpriseId);
			model.put("type", OHConstants.add);
		} else {
			Criteria criteria = new Criteria();
			criteria.add("id", id);
			contactSituation = enterpriseDocService
					.searchContactSituation(criteria);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("contactSituation", contactSituation);
		return url;
	}

	@RequestMapping("/saveContactSituation")
	@ResponseBody
	public ModelMap saveContactSituation(OhContactSituation contactSituation,
			String type, HttpServletRequest request) {
		contactSituation.setCreateBy(getCurrentUser(request).getUserName());
		contactSituation.setCreateTime(new Date());
		contactSituation.setUpdateBy(getCurrentUser(request).getUserName());
		contactSituation.setUpdateTime(new Date());
		Boolean rs = enterpriseDocService.saveContactSituation(
				contactSituation, type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-修改危害因素接触", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-新增危害因素接触", OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delContactSituation")
	@ResponseBody
	public ModelMap delContactSituation(Long id, HttpServletRequest request) {
		OhContactSituation contactSituation = new OhContactSituation();
		contactSituation.setUpdateBy(getCurrentUser(request).getUserName());
		contactSituation.setUpdateTime(new Date());
		contactSituation.setIsDelete(OHConstants.delete_1);
		contactSituation.setId(id);
		Boolean rs = enterpriseDocService.saveContactSituation(
				contactSituation, OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.OH, "重点企业服务档案-删除害因素接触",
					OperationName.DELETE);
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	/**
	 * 主要生产设备
	 * 
	 * @param enterpriseId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/equipment/{enterpriseId}")
	public String equipment(@PathVariable("enterpriseId") Long enterpriseId,
			String type, HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.equipment";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = new Criteria();
		criteria.add("is_delete", 0);
		criteria.add("enterprise_info_id", enterpriseId);
		PageList<OhEquipment> plist = enterpriseDocService.searchEquipmentList(
				criteria, page);
		model.addAttribute("equipment", plist);
		model.addAttribute("page", plist.getPage());
		model.put("enterpriseId", enterpriseId);
		model.put("type", type);
		return url;
	}

	/**
	 * 添加、修改主要生产设备
	 * 
	 * @param enterpriseId
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/initAddViewEquipment/{enterpriseId}")
	public String initAddViewEquipment(
			@PathVariable("enterpriseId") Long enterpriseId, Long id,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.equipment.add";
		OhEquipment equipment = null;
		if (id == null) {
			equipment = new OhEquipment();
			equipment.setEnterpriseInfoId(enterpriseId);
			model.put("type", OHConstants.add);
		} else {
			Criteria criteria = new Criteria();
			criteria.add("id", id);
			equipment = enterpriseDocService.searchEquipment(criteria);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("equipment", equipment);
		return url;
	}

	@RequestMapping("/saveEquipment")
	@ResponseBody
	public ModelMap saveEquipment(OhEquipment equipment, String type,
			HttpServletRequest request) {
		ModelMap model = new ModelMap();
		OhEquipment eq = enterpriseDocService.searchEquipment(new Criteria(
				"SEQ_NO", equipment.getSeqNo()));
		if (eq != null) {
			if (OHConstants.add.equals(type) || OHConstants.edit.equals(type)
					&& !eq.getId().equals(equipment.getId())) {
				model.addAttribute("result", false);
				model.addAttribute("message", "序号已经存在，保存失败！");
				return model;
			}
		}
		equipment.setCreateBy(getCurrentUser(request).getUserName());
		equipment.setCreateTime(new Date());
		equipment.setUpdateBy(getCurrentUser(request).getUserName());
		equipment.setUpdateTime(new Date());
		Boolean rs = enterpriseDocService.saveEquipment(equipment, type);

		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(rs)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-修改主要生产设备", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-新增主要生产设备", OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败！");
		}
		return model;
	}

	@RequestMapping("/delEquipment")
	@ResponseBody
	public ModelMap delEquipment(Long id, HttpServletRequest request) {
		OhEquipment equipment = new OhEquipment();
		equipment.setUpdateBy(getCurrentUser(request).getUserName());
		equipment.setUpdateTime(new Date());
		equipment.setIsDelete(OHConstants.delete_1);
		equipment.setId(id);
		Boolean rs = enterpriseDocService.saveEquipment(equipment,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.OH, "重点企业服务档案-删除主要生产设备",
					OperationName.DELETE);
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	/**
	 * 监测点示意图
	 * 
	 * @param enterpriseId
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/testItems/{enterpriseId}")
	public String testItems(@PathVariable("enterpriseId") Long enterpriseId,
			String type, HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.testItems";
		String indexPage = request.getParameter("indexPage");
		int currentPage = Integer.valueOf(indexPage);
		Page page = super.getPage(request, currentPage);
		Criteria criteria = new Criteria();
		criteria.add("is_delete", 0);
		criteria.add("enterprise_info_id", enterpriseId);
		PageList<OhTestItems> plist = enterpriseDocService.searchTestItemsList(
				criteria, page);
		model.addAttribute("testItem", plist);
		model.addAttribute("page", plist.getPage());
		model.put("enterpriseId", enterpriseId);
		model.put("type", type);
		return url;
	}

	/**
	 * 添加、修改 监测点示意图
	 * 
	 * @param enterpriseId
	 * @param id
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/initAddViewTestItems/{enterpriseId}")
	public String initAddViewTestItems(
			@PathVariable("enterpriseId") Long enterpriseId, Long id,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.oh.enterprise.testItems.add";
		OhTestItems testItem = null;
		request.getSession().removeAttribute(
				OHConstants.ENTITYPRISE_UPLOAD_SESSION_KEY);
		if (id == null) {
			testItem = new OhTestItems();
			testItem.setEnterpriseInfoId(enterpriseId);
			model.put("type", OHConstants.add);
		} else {
			Criteria criteria = new Criteria();
			criteria.add("id", id);
			testItem = enterpriseDocService.searchTestItem(criteria);
			model.put("type", OHConstants.edit);
		}
		model.addAttribute("testItem", testItem);
		return url;
	}

	@RequestMapping("/saveTestItem")
	@ResponseBody
	public ModelMap saveTestItem(OhTestItems testItem, String type,
			HttpServletRequest request) {
		Map<String, String> fileMap = (Map<String, String>) request
				.getSession().getAttribute(
						OHConstants.ENTITYPRISE_UPLOAD_SESSION_KEY); // 附件
		// 附件
		if (ObjectUtil.isNotEmpty(fileMap)) {
			if (fileMap.size() > 1) {
				ModelMap model = new ModelMap();
				model.addAttribute("result", false);
				model.addAttribute("message", "只能保存一个附件!");
				return model;
			}

			for (String urlKey : fileMap.keySet()) {
				testItem.setMiniUrl(fileMap.get(urlKey));
			}
		}
		testItem.setCreateBy(getCurrentUser(request).getUserName());
		testItem.setCreateTime(new Date());
		testItem.setUpdateBy(getCurrentUser(request).getUserName());
		testItem.setUpdateTime(new Date());
		Boolean rs = enterpriseDocService.saveTestItem(testItem, type);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "保存成功");
			if (OHConstants.edit.equals(rs)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-修改监测点示意图", OperationName.UPDATE);
			} else if (OHConstants.add.equals(type)) {
				createOperationLog(request, RhipModuleName.OH,
						"重点企业服务档案-新增监测点示意图", OperationName.ADD);
			}
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "保存失败");
		}
		return model;
	}

	@RequestMapping("/delTestItem")
	@ResponseBody
	public ModelMap delTestItem(Long id, HttpServletRequest request) {
		OhTestItems testItem = new OhTestItems();
		testItem.setUpdateBy(getCurrentUser(request).getUserName());
		testItem.setUpdateTime(new Date());
		testItem.setIsDelete(OHConstants.delete_1);
		testItem.setId(id);
		Boolean rs = enterpriseDocService.saveTestItem(testItem,
				OHConstants.del);
		ModelMap model = new ModelMap();
		if (rs) {
			model.addAttribute("result", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.OH, "重点企业服务档案-删除监测点示意图",
					OperationName.DELETE);
		} else {
			model.addAttribute("result", false);
			model.addAttribute("message", "删除失败");
		}
		return model;
	}

	@RequestMapping("/showAsImage")
	public void showAsImage(String filePath, HttpServletResponse response) {
		try {
			InputStream in = new FileInputStream(filePath);
			BufferedImage bufferedImage = ImageIO.read(in);
			OutputStream outputStream = response.getOutputStream();
			ImageIO.write(bufferedImage,
					StringUtils.substringAfterLast(filePath, "."), outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
	}

}
