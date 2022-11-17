package com.founder.rhip.ihm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;

import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.elb.entity.Role;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.dto.TargetDTO;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;
import com.founder.rhip.ehr.service.ihm.IYiZhengService;
import com.founder.rhip.ehr.service.statistics.ITargetOrgService;
import com.founder.rhip.ihm.controller.form.StatisticsQueryForm;

/**
 * 医疗服务
 * @author mei_xingjian hmhome controller
 */
@Controller
@RequestMapping("/hm/yz")
public class YiZhengController extends IHMBaseController {

	@Resource(name = "ihmYiZhengService")
	private IYiZhengService yiZhengService;

	@Resource(name = "targetOrgService")
	private ITargetOrgService targetOrgService;

	@RequestMapping("/index/{type}")
	public String index(@PathVariable("type")int type, HttpServletRequest request,Model model,String reportType) {
		Date today = new Date();
		Date startDate = DateUtil.firstDateOfMonth(today);
		model.addAttribute("currentBeginDate", startDate);
		model.addAttribute("currentEndDate", today);
        Organization org = getCurrentOrg(request);
        model.addAttribute("orgCode",org.getOrganCode());
        //初始化统计报表类型
        if (ObjectUtil.isNotEmpty(reportType)) {
        	model.addAttribute("reportType",reportType.substring(0,4));
		}
        //默认中心
        model.addAttribute("genreCodeSelect", 3);
        model.addAttribute("type", type); // 页面导航文字显示判断使用
        // 1、门急诊输液监管 2、门诊统计 3、门急诊抗生素监管 4、门急诊患者情况分析 5、住院患者情况分析 6、住院统计
        if (type == 4) {
			model.addAttribute("reportType", "T001"); // 门诊
		} else if (type == 5) {
			model.addAttribute("reportType", "T002"); // 住院
		}
		return "rhip.ihm.yz.search";
	}

	@RequestMapping("/list")
	public String ihmYiZhengList(HttpServletRequest request, Model model) {
		model.addAttribute("reports", new ArrayList<HmOutpatient>());
		return "rhip.ihm.yz.outpatientList";
	}

	@RequestMapping("/importHistoryData")
	@ResponseBody
	public ModelMap importHistoryData(String begin, String end,
			HttpServletRequest request, Model model) {
		model.addAttribute("reports", new ArrayList<HmOutpatient>());
		boolean rs = yiZhengService.importHistoryData(begin, end);
		ModelMap md = new ModelMap();
		md.addAttribute("result", rs);
		if (rs)
			md.addAttribute("message", "导入成功");
		return md;
	}

	/**
	 * 门急诊监管
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/outpatientList")
	public String outpatientList(TargetOrgQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.yz.outpatientList";
        Map<String, String> paramMap = form.getParamMap();
        List<Map<String, Object>> reports = yiZhengService.statisticsOutpatient(paramMap);
        if(reports.size()>1){
            if("320581100000".equals(reports.get(0).get("GB_CODE")) && "0".equals(form.getGenreCode())){
            reports.remove(0);
            }
        }
        model.addAttribute("reports", reports);
        model.addAttribute("genreCode", form.getGenreCode());

        return url;
	}

	/**
	 * 住院监管
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/hospitalizeList")
	public String hospitalizeList(TargetOrgQueryForm form,
			HttpServletRequest request, ModelMap model) {
		String url = "rhip.ihm.yz.hospitalizeList";
        Map<String, String> paramMap = form.getParamMap();
        List<Map<String, Object>> reports = yiZhengService.statisticsHmHospitalize(paramMap);
        if(reports.size()>1){
            if("320581100000".equals(reports.get(0).get("GB_CODE")) && "0".equals(form.getGenreCode())){
                reports.remove(0);
            }
        }
		/*Integer nextCodeType = form.getSelectOrgCodeNextCodeType();
		Integer codeType = form.getSelectOrgCodeType();
		String orgCode = form.getSelectOrgCode();
		codeType = codeType(request, codeType);
		orgCode = orgCode(request, orgCode);
		nextCodeType =nextCodeType(request, nextCodeType);
		List<Role> roleList = this.getCurrentUserRole(request);
		for (Role role : roleList) {
			if (RoleType.ZX_GLY.getValue().equals(role.getRoleCode())) {
				codeType = TargetDTO.CENTER;
			}
		}
		List<TargetDTO> targetList = targetOrgService.getTargetDTOs(
				nextCodeType, codeType, orgCode, ITargetOrgService.GET_ALL,
				null);
		List<HmHospitalize> plist = new ArrayList<HmHospitalize>();

		for (TargetDTO dto : targetList) {
			Criteria ca = form.getCriteria();
			List<String> orgCodes = targetOrgService.getStationCodes(
					dto.getType(), dto.getCode());
			List<String> orgCenterCodes = targetOrgService.getCenters(
					dto.getType(), dto.getCode());

			if(orgCenterCodes != null){
				orgCodes.addAll(orgCenterCodes);
			}
			ca.add("ORGAN_CODE", OP.IN, orgCodes);
			HmHospitalize hospital = yiZhengService.statisticsHospitalize(ca);
			hospital.setOrganCode(dto.getCode());
			hospital.setType(dto.getType());
			plist.add(hospital);
		}*/
		model.addAttribute("reports", reports);
        model.addAttribute("genreCode", form.getGenreCode());
        return url;
	}
}
