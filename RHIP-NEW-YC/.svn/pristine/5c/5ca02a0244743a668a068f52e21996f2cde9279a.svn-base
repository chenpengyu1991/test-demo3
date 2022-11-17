package com.founder.rhip.report.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.elb.common.MessageUtils;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.WeightSetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.report.RpWeightSet;
import com.founder.rhip.ehr.service.report.IRpWeightSetService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.report.controller.form.WeightSetQueryForm;

/**
 * 权重设置
 */
@Controller
@RequestMapping("/report/rpWeight")
public class RpWeightController extends BaseController {

    @Resource(name = "rpWeightSetService")
    private IRpWeightSetService rpWeightSetService;

    @Autowired
    private IOrganizationApp organizationApp;
    
    /**
     * 权重设置(初始页面)
     * * @return
     */
    @RequestMapping("/search")
    public String weightSearch(HttpServletRequest request, Model model) {
        return "ihm.weigthSearch.search";
    }

    /**
     * 权重查询
     * @param request
     * @param model
     * @param indexPage
     * @return
     */
    @RequestMapping("/list")
    public String weightList(HttpServletRequest request, ModelMap model, WeightSetQueryForm weightSetQueryForm, int indexPage) {
        Page page = super.getPage(request, indexPage);
        Criteria criteria = weightSetQueryForm.getCriteria();
        PageList<RpWeightSet> pageList = rpWeightSetService.getWeightSets(page, criteria);
        model.addAttribute("weightSetList", pageList.getList());
        model.addAttribute("page", pageList.getPage());
        model.addAttribute("indexPage", indexPage);
        return "ihm.weigthSearch.list";
    }

    @RequestMapping("/add")
	public String add(HttpServletRequest request, ModelMap modelMap, Long id) {
		if (id != null) {
			RpWeightSet rpWeightSet = rpWeightSetService.getRpWeightSet(new Criteria("id", id));
			modelMap.addAttribute("rpWeightSet", rpWeightSet);
		}
		return "ihm.weigth.set.add";
	}
    
    @RequestMapping("/save")
	@ResponseBody
	public ModelMap save(HttpServletRequest request, RpWeightSet rpWeightSet, BindingResult errors) {
    	ModelMap modelMap = new ModelMap();
    	if(ObjectUtil.isNullOrEmpty(rpWeightSet.getOrganCode())) {
    		rpWeightSet.setOrganCode(rpWeightSet.getCenterCode());
    	}
    	List<RpWeightSet> rpWeightSets = rpWeightSetService.getWeightSets("", rpWeightSet.getOrganCode(), rpWeightSet.getWeightIndex(),
    			rpWeightSet.getRpBeginDate(), rpWeightSet.getRpEndDate());
    	if(ObjectUtil.isNotEmpty(rpWeightSets) && rpWeightSet.getRpType().equalsIgnoreCase("1")) {
    		modelMap.addAttribute("message", "数据库中已存在此日期区间的数据，请核实后再保存！");
    		return modelMap;
    	}
    	if(ObjectUtil.isNotEmpty(rpWeightSet.getId())) {
    		rpWeightSetService.updateRpWeightSet(rpWeightSet);
    	} else {
    		rpWeightSetService.insertRpWeightSet(rpWeightSet);
    	}
    	modelMap.addAttribute("success", "保存成功！");
    	return modelMap;
	}

	@RequestMapping("/delete")
	public void delete(HttpServletResponse response, long id){
		Criteria criteria = new Criteria("id",id);
		int result = 0;
		result = rpWeightSetService.deletWeightSets(criteria);
		MessageUtils.outputJSONResult(result > 0 ? "success" : "fail", response);
	}


    /**
     * 权重查询
     * @param request
     * @param model
     * @param indexPage
     * @return
     */
    @RequestMapping("/child/list")
    public String weightList(HttpServletRequest request, ModelMap model, RpWeightSet rpWeightSet) {
    	if(ObjectUtil.isNullOrEmpty(rpWeightSet.getOrganCode())) {
    		rpWeightSet.setOrganCode(rpWeightSet.getCenterCode());
    	}
    	List<RpWeightSet> rpWeightSets = rpWeightSetService.getWeightSets(rpWeightSet.getGbCode(),rpWeightSet.getOrganCode(), rpWeightSet.getWeightIndex(),
    			rpWeightSet.getRpBeginDate(), rpWeightSet.getRpEndDate());
        model.addAttribute("weightSetList", rpWeightSets);
        return "ihm.weigthSearch.list.child";
    }


	/**
	 * 个人绩效模拟(初始页面)
	 * * @return
	 */
	@RequestMapping("/staffRpPa/search")
	public String staffRpPaSearch(HttpServletRequest request, Model model) {
		return "ihm.staffRpPaSearch.search";
	}

	/**
	 * 个人绩效模拟(查询页面)
	 * @param model
	 * @param weightSetQueryForm
	 * @return
	 */
	@RequestMapping("/staffRpPa/list")
	public String staffRpPaList(ModelMap model, WeightSetQueryForm weightSetQueryForm) {
		List<Map<String, Object>> result = rpWeightSetService.getStaffRpPaList(weightSetQueryForm.getOrganCode(), weightSetQueryForm.getRpType(), weightSetQueryForm.getWeightIndex(), WeightSetType.getByWeightIndex(weightSetQueryForm.getWeightIndex()).getWeightIndexColumn(), weightSetQueryForm.getBeginDate(), weightSetQueryForm.getEndDate());
		model.addAttribute("result", result);
		return "ihm.staffRpPaSearch.list";
	}

}