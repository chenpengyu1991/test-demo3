package com.founder.rhip.ehr.controller.medicalservice;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.controller.EhrBaseController;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.service.IDrugService;

/**
 * 用药
 * @author liuk
 *
 */
@Controller
@RequestMapping("/drug")
public class DrugUsageController extends EhrBaseController{
	private static Logger log = Logger.getLogger(DrugUsageController.class);

	@Autowired
	private IDrugService drugService;

	
	@RequestMapping("/search")
	public String search(@RequestParam(value = "personId", required = false) Long personId,Model model){
		model.addAttribute("personId", personId);
		return "rhip.ehr.drug.list";
	}

    private final String[] drugProperties2={"referralHospitalCode","referralHospitalName","quantityUnit","quantity","startDate","drugTradeName","drugGenericName","drugSpecifications"};

    @RequestMapping("/result")
	public String search(@RequestParam(value = "timeType", defaultValue = "1", required = false) String timeType,@RequestParam(value = "personId",  required = false)String smpiId, HttpServletRequest request, Model model) {
		Criteria criteria = new Criteria();
		
		// 当前人
		if (ObjectUtil.isNotEmpty(smpiId)) {
			 criteria.add("personId",smpiId);
		}
        if (isLimitEnabled()){
            criteria.add("referralHospitalCode", OP.NOTIN,getLimitedOrganCode());
        }
        criteria.add("IS_LIMIT",OP.LT,1);
		
		//时间间隔
		DateUtil.setStartDateRange(criteria, timeType.trim(), "startDate");
		Order order=new Order("START_DATE",false).desc("rowid");
		PageList<DrugUsage> drugUsages = drugService.getDrugUsage(buildPage(request), criteria,order,drugProperties2);
		model.addAttribute("drugUsages", drugUsages.getList());
		return "rhip.ehr.drug.result";
	}

}
