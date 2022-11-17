package com.founder.rhip.ep.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.founder.rhip.ehr.common.RhipModuleName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.SelectDTO;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.ep.IodineNutritionSampling;
import com.founder.rhip.ep.service.IIodineNutritionService;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.SchoolInfo;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.ISchoolInfoService;

/**
 * 碘营养与碘缺乏病
 * @author chenweihua
 */
@Controller
@RequestMapping(value = "/ep/iodineNutrition")
public class IodineNutritionController extends BaseController {
	
	@Resource
	private IIodineNutritionService iodineNutritionService;
	
	@Resource(name="mdmDictionaryService")
	private IDictionaryService dictionaryService;
	
	@Resource
	private ISchoolInfoService schoolInfoService;
	
	@RequestMapping("/samplingSearch")
	public String samplingSearch(ModelMap model) {
		model.addAttribute("currentYear",new Date());
		return "rhip.ep.iodineNutrition.samplingSearch";
	}
	
	@RequestMapping(value = "/querySamplingName")
	@ResponseBody
	public SelectDTO<ModelMap> querySamplingName(HttpServletRequest request,String type,String inputValue,int currentPage) {
		List<ModelMap> ret = new ArrayList<ModelMap>();
		Page page = super.getPage(request, currentPage); 
		
		Criteria criteria = new Criteria();
		if (IodineNutritionSampling.TYPE_TOWN.equals(type)) {
			criteria.add(Dictionary.DIC_CODE,"FS990001");
			criteria.add(DicItem.PARENT_CODE, EHRConstants.FS990001_ROOT);
			if(ObjectUtil.isNotEmpty(inputValue)){
				criteria.add("itemName", OP.LIKE ,inputValue);
			}
			PageList<DicItem> pageList = dictionaryService.getDicItems(page, criteria);
			List<DicItem> list = pageList.getList();
			for (DicItem info : list) {
				ModelMap map = new ModelMap();
				map.addAttribute("name", info.getItemName());
				map.addAttribute("value", info.getItemCode());
				ret.add(map);
			}
		} else if (IodineNutritionSampling.TYPE_SCHOOL.equals(type)) {
			if(ObjectUtil.isNotEmpty(inputValue)){
				criteria.add("name", OP.LIKE ,inputValue);
			}
			PageList<SchoolInfo> pageList = schoolInfoService.getPageSchools(page, criteria);
			List<SchoolInfo> list = pageList.getList();
			for (SchoolInfo info : list) {
				ModelMap map = new ModelMap();
				map.addAttribute("name", info.getName());
				map.addAttribute("value", info.getSchoolCode());
				ret.add(map);
			}
		}
		PageList<ModelMap> pageList = new PageList<ModelMap>();
		pageList.setPage(page);
		pageList.setList(ret);
		return new SelectDTO<ModelMap>(pageList);
	}

	@RequestMapping("/samplingList")
	public String samplingList(HttpServletRequest request,ModelMap model, int indexPage, String samplingTime) {
		Page page = super.getPage(request, indexPage); 
		Criteria criteria = new Criteria("deleteFlag", EHRConstants.DELETE_FLG_0);
		if (StringUtil.isNotEmpty(samplingTime)) {
			criteria.add("samplingYear", samplingTime);
		}
		PageList<IodineNutritionSampling> pageList = iodineNutritionService.getPageList(page, criteria);
		model.addAttribute("samplingList", pageList.getList());
		model.addAttribute("page", pageList.getPage());
		model.addAttribute("indexPage", indexPage);
		return "rhip.ep.iodineNutrition.samplingList";
	}
	
	@RequestMapping("/samplingEdit")
	public String samplingEdit(ModelMap model, Long id) {
		if (ObjectUtil.isNotEmpty(id)) {
			IodineNutritionSampling sampling = iodineNutritionService.getDetail(id);
			model.addAttribute("sampling", sampling);
		}
		return "rhip.ep.iodineNutrition.samplingInfoEdit";
	}
	
	@RequestMapping("/samplingSave")
	@ResponseBody
	public ModelMap samplingSave(HttpServletRequest request, IodineNutritionSampling sampling) {
		ModelMap model = new ModelMap();
		Long id = sampling.getId();
		String code = sampling.getCode();
		String type = sampling.getType();
		if (StringUtil.isNullOrEmpty(code)) {
			model.addAttribute("success", false);
			model.addAttribute("message", "抽样点名称只能选择，不能手动填写！");
			return model;
		}
		if (IodineNutritionSampling.TYPE_TOWN.equals(type)) {
			DicItem item = dictionaryService.getDicItem("FS990001", code);
			if (item != null)  sampling.setName(item.getItemName());
		} else if (IodineNutritionSampling.TYPE_SCHOOL.equals(type)) {
			SchoolInfo info = schoolInfoService.getSchool(code);
			if (info != null)  sampling.setName(info.getName());
		}
		setSamplingValue(request, sampling);
		
		if (ObjectUtil.isNullOrEmpty(id)) {
			String samplingNo = sampling.getSamplingNo();
			Criteria criteria = new Criteria("samplingNo", samplingNo);
			criteria.add("samplingYear", DateUtil.getCurrentYear());
			IodineNutritionSampling dbSampling = iodineNutritionService.getDetail(criteria);
			if (dbSampling != null) {
				model.addAttribute("success", false);
				model.addAttribute("message", "本年度相同编号的抽样序号("+samplingNo+")已经存在");
				return model;
			}
			criteria = new Criteria("code", code);
			criteria.add("samplingYear", DateUtil.getCurrentYear());
			dbSampling = iodineNutritionService.getDetail(criteria);
			if (dbSampling != null) {
				model.addAttribute("success", false);
				model.addAttribute("message", "本年度此抽样点("+sampling.getName()+")已经存在");
				return model;
			}
		}
		
		try {
			iodineNutritionService.save(sampling);
			model.addAttribute("success", true);
			model.addAttribute("message", "保存成功");
			if (sampling.getId() == null) {
				createOperationLog(request, RhipModuleName.EP, "地方病碘营养抽样登记保存", OperationName.ADD);
			} else {
				createOperationLog(request, RhipModuleName.EP, "地方病碘营养抽样登记保存", OperationName.UPDATE);
			}
		} catch (Exception e) {
			logger.error("保存出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/samplingDelete")
	@ResponseBody
	public ModelMap samplingDelete(HttpServletRequest request, Long id) {
		ModelMap model = new ModelMap();
		//IodineNutritionSampling sampling = iodineNutritionService.getDetail(id);
		//setSamplingValue(request, sampling);
		//sampling.setDeleteFlag(EHRConstants.DELETE_FLG_1);
		try {
			iodineNutritionService.delete(id);
			model.addAttribute("success", true);
			model.addAttribute("message", "删除成功");
			createOperationLog(request, RhipModuleName.EP, "地方病碘营养抽样登记删除", OperationName.DELETE);
		} catch (Exception e) {
			logger.error("删除出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	@RequestMapping("/changeSimpling")
	@ResponseBody
	public ModelMap changeSimpling(String type) {
		ModelMap model = new ModelMap();
		try {
			List<IodineNutritionSampling> samplingList = iodineNutritionService.getCurrentYearSampling(null, type);
			model.addAttribute("list", samplingList);
			model.addAttribute("success", true);
			model.addAttribute("message", "查询成功");
		} catch (Exception e) {
			logger.error("查询出错", e);
			model.addAttribute("success", false);
			model.addAttribute("message", e.getMessage());
		}
		return model;
	}
	
	private void setSamplingValue(HttpServletRequest request, IodineNutritionSampling sampling) {
		Date now  = new Date();
		Long id = sampling.getId();
		User user = this.getCurrentUser(request);
		Organization organization=this.getCurrentOrg(request);
		
		if (ObjectUtil.isNullOrEmpty(id)) {
			sampling.setSamplingTime(now);
			sampling.setSamplingYear(DateUtil.toFormatString("yyyy", now));
			sampling.setCreatePerson(user.getUserName());
			sampling.setCreateOrgan(organization.getOrganCode());
			sampling.setCreateTime(now);
		} else {
			sampling.setUpdatePerson(user.getUserName());
			sampling.setUpdateOrgan(organization.getOrganCode());
			sampling.setUpdateTime(now);
		}
	}
}
