package com.founder.rhip.vaccine.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
//import com.founder.rhip.BaseController.OperationName;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.common.SecurityUtils;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.ph.dto.vaccine.SearchConditionDTO;
import com.founder.rhip.ph.dto.vaccine.VaccineValenceDTO;
import com.founder.rhip.ph.service.vaccine.IVaccinationReadService;

/**
 * 
 * @author xu_bin
 * login controller
 */
@Controller
@RequestMapping("/vaccinehome")
public class VaccineController extends BaseController{
	@Resource(name = "vaccineService")
	private IVaccinationReadService vaccineService;
	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;
	
	@RequestMapping("/index")
	public String vaccieHome(HttpServletRequest request, Model model){
		model.addAttribute("defaultMonth", new Date());
		return "rhip.vaccine.hospital.index";
	}
	
	@RequestMapping("/list")
	public String result(HttpServletRequest request,Integer indexPage, Model model,SearchConditionDTO searchConditionDTO) {
		Page page = super.getPage(request, indexPage); 
        Criteria criteria = searchConditionDTO.getSearchCondition();

		PageList<VaccinationEvent> list = vaccineService.getList(page, criteria);
		for(VaccinationEvent ve:list.getList()){
			ve.setAge(DateUtil.getAgeByBirthday(ve.getBirthday())+"");
			/**
			 * 列表中显示电话号码,电话号码存储在VaccinationMgmt表中.
			 * modify by yejianfei 20140804
			 * modify by cary 20150701 VaccinationMgmt中的ehrid会被更新
			 */
			VaccinationMgmt mgmt = getVaccinationMgmt(new Criteria("PERSON_ID",ve.getPersonId()));
			if(ObjectUtil.isNotEmpty(mgmt)){
				ve.setPhoneNumber(mgmt.getPhoneNumber());
			}
			// 暴露等级
			Criteria c = new Criteria("ehrId", ve.getEhrId()).add("isDelete", OP.NE, 1);
			TraumaHistory traumaHistory = vaccineService.getTraumaHistory(c);
			if (ObjectUtil.isNotEmpty(traumaHistory)) {
				if (ObjectUtil.isNotEmpty(traumaHistory.getBiteLevel())) {
					if (traumaHistory.getBiteLevel().equals(1)) {
						ve.setBiteLevel("I");
					} else if (traumaHistory.getBiteLevel().equals(2)) {
						ve.setBiteLevel("II");
					} else if (traumaHistory.getBiteLevel().equals(3)) {
						ve.setBiteLevel("III");
					}
				}
			}
		}

		model.addAttribute("vaccinationRecords", list.getList());
		model.addAttribute("page",list.getPage());
  
		return "rhip.vaccine.hospital.records";
	}
	@RequestMapping("/excel")
	public void excel(SearchConditionDTO searchConditionDTO, ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		String title = "预防接种";
		final Criteria criteria = searchConditionDTO.getSearchCondition();	
        createOperationLog(request, RhipModuleName.VACCINE, "数据", OperationName.EXP);
        //23价疫苗导出
        if(searchConditionDTO.getImmType().equals("4")){
        	excelExportService.exportListExecl(title, VaccineValenceDTO.class, response,new IDataSource() {
    			@Override
    			public List<Map<String, Object>> get(Page page) {
    				List<Map<String, Object>> dataSource = vaccineService.exportVaccineList(page,criteria);
    				return dataSource;
    			}
    		});
        }else{
        	excelExportService.exportListExecl(title, VaccinationEvent.class, response,new IDataSource() {
        		@Override
        		public List<Map<String, Object>> get(Page page) {
        			List<Map<String, Object>> dataSource = vaccineService.exportVaccineList(page,criteria);
        			return dataSource;
        		}
        	});
        }
	}
	private VaccinationMgmt getVaccinationMgmt(Criteria criteria){
		VaccinationMgmt vaccinationMgmt = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			vaccinationMgmt = vaccineService.getVaccinationMgmt(criteria);
		}
		return vaccinationMgmt;
	}
	private boolean checkRole(RoleType[] ysType,HttpServletRequest request){
		for(RoleType type:ysType){
			if(SecurityUtils.hasRole(type, request)){
				return true;
			}
		}
		return false;
	}
}
