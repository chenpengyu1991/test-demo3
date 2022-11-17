package com.founder.rhip.vaccine.controller.cdc;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.ph.dto.vaccine.SearchConditionDTO;
import com.founder.rhip.ph.service.vaccine.IVaccinationReadService;

/**
 * 
 * @author xu_bin for CDC user perform Vaccine. include(condition search / item
 *         list etc.)
 */
@Controller
public class VaccinationController extends BaseController{

	@Resource(name = "vaccineService")
	private IVaccinationReadService vaccineService;

	@RequestMapping("/cdc/vaccination/records")
	public String getRecords(HttpServletRequest request,ModelMap model,Integer indexPage, SearchConditionDTO searchConditionDTO) {
        Page page = super.getPage(request, indexPage); 
        
        Criteria criteria = searchConditionDTO.getSearchCondition();
		PageList<VaccinationEvent> list = vaccineService.getList(page, criteria);
        
		request.setAttribute("vaccinationRecords", list.getList());
        request.setAttribute("page",list.getPage());
        request.setAttribute("searchConditionDTO",searchConditionDTO);
		return "rhip.vaccine.cdc.vaccination.records";
	}
	
	
	@RequestMapping("/hospital/records/add/gray")
	public String grayAdd(@RequestParam("ehrId") String ehrId,Model model){
		String[] type = getparams(ehrId);
//		model.addAttribute("ehrId", type[0]);
//		model.addAttribute("suffererBaseInfoDTO",vaccineService.getSuffererBaseInfo(initSingleEhrIdCriteria(type)));
//		model.addAttribute("hitBaseInfoDTO",vaccineService.getHitBaseInfo(initSingleEhrIdCriteria(type)));
//		model.addAttribute("vaccineRecordDTO1",vaccineService.getVaccinationInfo(initAllCriteria(type)));
		return "rhip.vaccine.hospital.add.gray";
	}	

	private String[] getparams(String ehrId) {
		String[] params = ehrId.split("-");
		return params;
	}
	
	private Criteria initSingleEhrIdCriteria(String[] type){
		return new Criteria("ehrId", type[0]).add("isDelete",OP.NE, 1);
	}
	
	private Criteria initAllCriteria(String[] type){
		return initSingleEhrIdCriteria(type).add("inoculationTimes", type[2]);
	}
}
