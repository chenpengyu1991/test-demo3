package com.founder.rhip.ihm.controller;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.TargetConstants;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;
import com.founder.rhip.ehr.service.ihm.IPublicHealthTarget;
import com.founder.rhip.ehr.service.ihm.IStatisticsService;
import com.founder.rhip.ehr.service.report.IRpChildHealthcareService;
import com.founder.rhip.ehr.service.report.IRpChildService;
import com.founder.rhip.ehr.service.report.IRpInhospitalService;
import com.founder.rhip.ehr.service.report.IRpOutpatientService;
import com.founder.rhip.ehr.service.report.IRpPregantWomenHealthcareService;
import com.founder.rhip.ehr.service.report.IRpPremaritalExaminationService;
import com.founder.rhip.ihm.controller.form.TargetOrgQueryForm;
import com.founder.rhip.ihm.service.IhealthVaccinationService;

@Controller
@RequestMapping("/hm")
public class IHMIndexController extends BaseController {

    @Resource(name = "rpChildService")
    private IRpChildService rpChildService;

    @Resource(name = "rpChildHealthcareService")
    private IRpChildHealthcareService rpChildHealthcareService;

    @Resource(name = "rpPregantWomenHealthcareService")
    private IRpPregantWomenHealthcareService rpPregantWomenHealthcareService;

    @Resource(name = "rpPremaritalExaminationService")
    private IRpPremaritalExaminationService rpPremaritalExaminationService;

	@Resource(name = "ihmStatisticsService")
	private IStatisticsService ihmStatisticsService;

    @Resource(name = "ehrIndicatorService")
    private IPublicHealthTarget ehrIndicatorService;
    
    @Resource(name = "cdmPublicHealthService")
    private IPublicHealthTarget cdmPublicHealthService;
    
    @Resource(name = "idmHealthTargetService")
    private IPublicHealthTarget idmHealthTargetService;
	
    @Resource(name = "womanChildrenService")
    private IPublicHealthTarget womanChildrenService;
    
    @Resource(name = "rpInhosptialService")
    private IRpInhospitalService rpInhosptialService;
    
    @Resource(name = "rpOutpatientService")
    private IRpOutpatientService rpOutpatientService;

	@Resource(name = "healthVaccinationService")
	private IhealthVaccinationService healthVaccinationService;
    
	@RequestMapping("/index")
	public String chmHome(HttpServletRequest request, Model model) {
		/*综合管理首页门诊统计 住院统计
		this.statisticsOutpatientAndHospitalize(model);
		健康档案
        model.addAttribute("PH002",ehrIndicatorService.getEHRTarget(null,null,null,TargetConstants.LEI_JI_DANG_AN_FHJ).intValue());
        model.addAttribute("PH001",ehrIndicatorService.getEHRTarget(null,null,null,TargetConstants.LEI_JI_DANG_AN_HJ).intValue());
        糖尿病患者建卡数
        model.addAttribute("PH058",cdmPublicHealthService.getCDMTarget(null,null,null,TargetConstants.CDM_DI_MANAGED_TOTAL_COUNT).intValue());
        糖尿病患者随访数
        model.addAttribute("PH061",cdmPublicHealthService.getCDMTarget(null,null,null,TargetConstants.CDM_DI_FOLLOWUP_COUNT).intValue());
        高血压患者建卡数
        model.addAttribute("PH032",cdmPublicHealthService.getCDMTarget(null,null,null,TargetConstants.CDM_HBP_MANAGED_TOTAL_COUNT).intValue());
        高血压患者随访数
        model.addAttribute("PH062",cdmPublicHealthService.getCDMTarget(null,null,null,TargetConstants.CDM_HBP_FOLLOWUP_COUNT).intValue());
        医生使用档案次数
		model.addAttribute("docReadNum", ihmStatisticsService.countRow(null));
		医生工作站慢病、传染病上报数
		model.addAttribute("PH053",idmHealthTargetService.getIDMTarget(null,null,null,TargetConstants.IDM_CDM_STATION_REPORT).intValue());
		医生工作站慢病、传染病 昨日上报数
		model.addAttribute("PH056",idmHealthTargetService.getIDMTarget(null,null,null,TargetConstants.IDM_YESTERDAY_REPORT).intValue());
		//新生儿访视人数
		model.addAttribute("PH021",womanChildrenService.getWomenChildrenTarget(null,null,null,TargetConstants.WOMAN_CHILDREN_021).intValue());
		 //婴幼儿健康管理数
		model.addAttribute("PH022",womanChildrenService.getWomenChildrenTarget(null,null,null,TargetConstants.WOMAN_CHILDREN_022).intValue());
		 //产后访视产妇数(人)
		model.addAttribute("PH027",womanChildrenService.getWomenChildrenTarget(null,null,null,TargetConstants.WOMAN_CHILDREN_027).intValue());
		//产后42天健康检查产妇数
		model.addAttribute("PH028",womanChildrenService.getWomenChildrenTarget(null,null,null,TargetConstants.WOMAN_CHILDREN_028).intValue());
        预防接种总人数
        model.addAttribute("vaccinationNum", ihmStatisticsService.vaccinationNum(null));
		model.addAttribute("vaccinationNum", healthVaccinationService.getAll(new Criteria()));
        本年接种人数
        String year = String.valueOf(DateUtil.getCurrentYear());
        model.addAttribute("vaccinationCurrentYear", healthVaccinationService.getAll(new Criteria("year", year)));*/
		return "rhip.ihm.index";
	}
	
	/**
	 * 综合管理首页门诊统计 住院统计
	 * @return
	 */
	private void statisticsOutpatientAndHospitalize(Model model) {
		/*获取上个月的月份*/
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
		c.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		
		String yesterdayStr = DateUtil.getDateTime("yyyy/MM/dd", DateUtil.getBeforeDay(new Date(), 2));
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String monthDate = DateUtil.getDateTime("yyyy/MM", c.getTime());

		Date nowDate = new Date();
		//现在一年
		Criteria criteriaYear = new Criteria("create_date",OP.BETWEEN, new Date[]{DateUtil.firstDateOfYear(nowDate), DateUtil.lastDateOfYear(nowDate)});
		//获取上个月
		int month = calendar.get(Calendar.MONTH) - 1;
		//获取前一天
		Date yesterday = DateUtil.getBeforeDay(nowDate, 2);
		/*统计上个月住院数据*/
		/*Map<String, Object> feeInhospitalMonthMap = rpInhosptialService.statisticsFeeInhospital(monthDate, "yyyy/mm");*/
		HmHospitalize hospitalizeMonth = ihmStatisticsService.statisticsHospitalize(new Criteria("create_date", OP.BETWEEN, DateUtil.getDateRangeByMonth(month)));
		/*统计一年的住院数据*/
		/*Map<String, Object> feeInhospitalYearMap = rpInhosptialService.statisticsFeeInhospital(year, "yyyy");*/
		HmHospitalize hospitalizeYear = ihmStatisticsService.statisticsHospitalize(criteriaYear);
		
		/*按天统计门诊数据*/
		/*Map<String, Object> feeOutpatientDayMap = rpOutpatientService.statisticsFeeOutpatient(yesterdayStr, "yyyy/mm/dd");*/
		HmOutpatient outpatientDay =  ihmStatisticsService.statisticsOutpatient( new Criteria("create_date", OP.BETWEEN, new Date[]{DateUtil.makeTimeToZero(yesterday), DateUtil.makeTimeToMax(yesterday)}));
		/*按年统计数据门诊*/
		/*Map<String, Object> feeOutpatientYearMap = rpOutpatientService.statisticsFeeOutpatient(year, "yyyy");*/

		HmOutpatient outpatientYear = ihmStatisticsService.statisticsOutpatient(criteriaYear);
		
		model.addAttribute("feeInhospitalMonthMap", hospitalizeMonth);
		model.addAttribute("feeInhospitalYearMap", hospitalizeYear);
		model.addAttribute("feeOutpatientDayMap", outpatientDay);
		model.addAttribute("feeOutpatientYearMap", outpatientYear);
		
	}
	
	
	
	/**
	 * 基础资源》综合统计页面
	 * @param model
	 */
	@RequestMapping("/resourse/index")
	public String resourseHome(HttpServletRequest request, Model model) {
		return "rhip.ihm.resourse.index";
	}
	
	/**
	 * 疾病控制》综合统计页面
	 * @param model
	 */
	@RequestMapping("/disease/index")
	public String diseaseHome(HttpServletRequest request, Model model) {
		return "rhip.ihm.disease.index";
	}
	
	/**
	 * 妇幼保健》综合统计页面
	 * @param model
	 */
	@RequestMapping("/women/children/index")
	public String womenChildrenHome(Model model,TargetOrgQueryForm form) {
        form.setGenreCode("0");
        form.setBeginDate("2014/01/01");
        form.setEndDate("2014/12/31");
        List<Map<String, Object>> resultList = rpChildService.getChildAgeMapList(form.getParamMap());
        List<Map<String, Object>> plist = rpChildHealthcareService.getChildHealthcareStatisticsMapList(form.getParamMap());
        List<Map<String, Object>> careList = rpPregantWomenHealthcareService.getPregantWomenHealthcareMapList(form.getParamMap());
        List<Map<String, Object>> statisticslist = rpPremaritalExaminationService.getPremaritalExaminationMapList(form.getParamMap());

        for(int i=0;i<3;i++) {
            model.addAttribute("childChart"+i,resultList.get(i));
            model.addAttribute("childHealthCareChart" + i, plist.get(i));
            model.addAttribute("pregantWomenChart"+i,careList.get(i));
            model.addAttribute("premaritalExaminationChart"+i,statisticslist.get(i));

        }

		return "rhip.ihm.women.children.index";
	}
	
	/**
	 * 全市电子健康档案
	 * @return
     */
	@RequestMapping("/getEHRTarget")
	@ResponseBody
	public Map<String, Object> getEHRTarget() {
		Map<String,Object> resultMap = new HashMap<>();
		/*健康档案*/
		resultMap.put(TargetConstants.LEI_JI_DANG_AN_HJ,ehrIndicatorService.getEHRTarget(null,null,null,TargetConstants.LEI_JI_DANG_AN_HJ).intValue());
		resultMap.put(TargetConstants.LEI_JI_DANG_AN_FHJ,ehrIndicatorService.getEHRTarget(null,null,null,TargetConstants.LEI_JI_DANG_AN_FHJ).intValue());
		 /*医生使用档案次数*/
		resultMap.put("docReadNum",ihmStatisticsService.countRow(null));
		return resultMap;
	}

	/**
	 * 全市社区公共卫生
	 * @return
     */
	@RequestMapping("/getCDMTarget")
	@ResponseBody
	public Map<String, Object> getCDMTarget() {
		Map<String,Object> resultMap = new HashMap<>();
		/*糖尿病患者建卡数*/
		resultMap.put(TargetConstants.CDM_DI_MANAGED_BY_YEAR_COUNT,cdmPublicHealthService.getCDMTarget(null,null,null,TargetConstants.CDM_DI_MANAGED_TOTAL_COUNT).intValue());
		/*糖尿病患者随访数*/
		resultMap.put(TargetConstants.CDM_DI_FOLLOWUP_COUNT,cdmPublicHealthService.getCDMTarget(null,null,null,TargetConstants.CDM_DI_FOLLOWUP_COUNT).intValue());
		/*高血压患者建卡数*/
		resultMap.put(TargetConstants.CDM_HBP_MANAGED_BY_YEAR_COUNT,cdmPublicHealthService.getCDMTarget(null,null,null,TargetConstants.CDM_HBP_MANAGED_TOTAL_COUNT).intValue());
		/*高血压患者随访数*/
		resultMap.put(TargetConstants.CDM_HBP_FOLLOWUP_COUNT,cdmPublicHealthService.getCDMTarget(null,null,null,TargetConstants.CDM_HBP_FOLLOWUP_COUNT).intValue());
		return resultMap;
	}

	/**
	 * 全市实际门急诊业务（天）
	 * @return
     */
	@RequestMapping("/getOutpatientTarget")
	@ResponseBody
	public Map<String, Object> getOutpatientTarget() {
		Map<String,Object> resultMap = new HashMap<>();
		Date nowDate = new Date();
		Date yesterday = DateUtil.getBeforeDay(nowDate, 2);
		/*按天统计门诊数据*/
		resultMap.put("outpatientDay",ihmStatisticsService.statisticsOutpatient( new Criteria("create_date", OP.BETWEEN, new Date[]{DateUtil.makeTimeToZero(yesterday), DateUtil.makeTimeToMax(yesterday)})));
		return resultMap;
	}



	/**
	 * 全市实际住院业务（月）
	 * @return
	 */
	@RequestMapping("/getOutpatientMonthTarget")
	@ResponseBody
	public Map<String, Object> getOutpatientMonthTarget() {
		Map<String,Object> resultMap = new HashMap<>();
		Date nowDate = new Date();
		/*获取上个月的月份*/
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(nowDate);
		int month = calendar.get(Calendar.MONTH) - 1;
		/*统计上个月住院数据*/
		resultMap.put("hospitalizeMonth",ihmStatisticsService.statisticsHospitalize(new Criteria("create_date", OP.BETWEEN, DateUtil.getDateRangeByMonth(month))));
		return resultMap;
	}

	/**
	 * 全市实际门急诊业务（年）,全市实际住院业务（年）,全市实际医疗费用（年）
	 * @return
	 */
	@RequestMapping("/getYearTarget")
	@ResponseBody
	public Map<String, Object> getYearTarget() {
		Map<String,Object> resultMap = new HashMap<>();
		Date nowDate = new Date();
		Criteria criteriaYear = new Criteria("create_date",OP.BETWEEN, new Date[]{DateUtil.firstDateOfYear(nowDate), DateUtil.lastDateOfYear(nowDate)});
		/*按年统计数据门诊*/
		HmOutpatient outpatientYear = ihmStatisticsService.statisticsOutpatient(criteriaYear);
		resultMap.put("outpatientYear",outpatientYear);
		/*统计一年的住院数据*/
		HmHospitalize hospitalizeYear = ihmStatisticsService.statisticsHospitalize(criteriaYear);
		resultMap.put("hospitalizeYear",hospitalizeYear);

		BigDecimal medicinalFee = null;
		BigDecimal allFee = null;
		/*BigDecimal类型相加*/
		if(ObjectUtil.isNullOrEmpty(outpatientYear.getMedicinalFee()) && ObjectUtil.isNullOrEmpty(hospitalizeYear.getInHosMedicinalFee())) {
			medicinalFee = new BigDecimal(0);
		} else if (ObjectUtil.isNullOrEmpty(outpatientYear.getMedicinalFee()) && ObjectUtil.isNotEmpty(hospitalizeYear.getInHosMedicinalFee())) {
			medicinalFee = hospitalizeYear.getInHosMedicinalFee();
		} else if (ObjectUtil.isNotEmpty(outpatientYear.getMedicinalFee()) && ObjectUtil.isNullOrEmpty(hospitalizeYear.getInHosMedicinalFee())) {
			medicinalFee = outpatientYear.getMedicinalFee();
		} else {
			medicinalFee = outpatientYear.getMedicinalFee().add(hospitalizeYear.getInHosMedicinalFee());
		}
//		allFee = medicinalFee.add(outpatientYear.getAllFee()).add(hospitalizeYear.getInHosFee());
		// 添加非空判断，解决空指针异常问题 by GaoFei 2017/02/09
		BigDecimal fee = null;
		if (ObjectUtil.isNotEmpty(outpatientYear.getAllFee())) {
			fee = medicinalFee.add(outpatientYear.getAllFee());
		}
		if (ObjectUtil.isNotEmpty(fee) && ObjectUtil.isNotEmpty(hospitalizeYear.getInHosFee())) {
			allFee = fee.add(hospitalizeYear.getInHosFee());
		}
		if (ObjectUtil.isNotEmpty(fee) && ObjectUtil.isNullOrEmpty(hospitalizeYear.getInHosFee())) {
			allFee = fee;
		}
		if (ObjectUtil.isNullOrEmpty(fee) && ObjectUtil.isNotEmpty(hospitalizeYear.getInHosFee())) {
			allFee = medicinalFee.add(hospitalizeYear.getInHosFee());
		}
		if (ObjectUtil.isNullOrEmpty(outpatientYear.getAllFee()) && ObjectUtil.isNullOrEmpty(hospitalizeYear.getInHosFee())) {
			allFee = medicinalFee;
		}
		/*BigDecimal类型相除再小数点右移两位*/
		if(!(medicinalFee.floatValue() == 0.00f)) {
			medicinalFee = medicinalFee.divide(allFee, 4, BigDecimal.ROUND_HALF_UP);
		}
		//门急诊人均费用
		BigDecimal allFeeAvg = new BigDecimal(0);
		if(ObjectUtil.isNotEmpty(outpatientYear.getAllNum())) {
			int i = outpatientYear.getAllNum().compareTo(BigDecimal.ZERO);
			if (i == 1) {
				allFeeAvg = outpatientYear.getAllFee().divide(outpatientYear.getAllNum(), 0, BigDecimal.ROUND_HALF_UP);
			}
		}
		resultMap.put("allFeeAvg",allFeeAvg);
		//住院人均费用
		BigDecimal inHosFeeAvg = new BigDecimal(0);
		if(ObjectUtil.isNotEmpty(hospitalizeYear.getLeaveHospitalNum())) {
			if (!hospitalizeYear.getLeaveHospitalNum().equals(0L) && ObjectUtil.isNotEmpty(hospitalizeYear.getInHosFee())) {
				inHosFeeAvg = hospitalizeYear.getInHosFee().divide(new BigDecimal(hospitalizeYear.getLeaveHospitalNum()),0,BigDecimal.ROUND_HALF_UP);
			}
		}
		resultMap.put("inHosFeeAvg",inHosFeeAvg);
		NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
		percent.setMaximumFractionDigits(2); //百分比小数点最多2位
		resultMap.put("medicinalPercent",percent.format(medicinalFee));

		return resultMap;
	}

	/**
	 * 预防接种
	 * @return
	 */
	@RequestMapping("/getVaccinationTarget")
	@ResponseBody
	public Map<String, Object> getVaccinationTarget() {
		Map<String,Object> resultMap = new HashMap<>();
		/*预防接种总人数*/
		resultMap.put("vaccinationNum",ihmStatisticsService.vaccinationNum(null));
		/*本年接种人数*/
		String year = String.valueOf(DateUtil.getCurrentYear());
		resultMap.put("vaccinationCurrentYear",ihmStatisticsService.vaccinationNumByYear(new Criteria("year", year)));
		return resultMap;
	}

	/**
	 * 妇幼保健
	 * @return
	 */
	@RequestMapping("/getWomenChildrenTarget")
	@ResponseBody
	public Map<String, Object> getWomenChildrenTarget() {
		Map<String,Object> resultMap = new HashMap<>();
		//新生儿访视人数
		resultMap.put(TargetConstants.WOMAN_CHILDREN_021,womanChildrenService.getWomenChildrenTarget(null,null,null,TargetConstants.WOMAN_CHILDREN_021).intValue());
		//婴幼儿健康管理数
		resultMap.put(TargetConstants.WOMAN_CHILDREN_022,womanChildrenService.getWomenChildrenTarget(null,null,null,TargetConstants.WOMAN_CHILDREN_022).intValue());
		//产后访视产妇数(人)
		resultMap.put(TargetConstants.WOMAN_CHILDREN_027,womanChildrenService.getWomenChildrenTarget(null,null,null,TargetConstants.WOMAN_CHILDREN_027).intValue());
		//产后42天健康检查产妇数
		resultMap.put(TargetConstants.WOMAN_CHILDREN_028,womanChildrenService.getWomenChildrenTarget(null,null,null,TargetConstants.WOMAN_CHILDREN_028).intValue());
		return resultMap;
	}

	/**
	 * 全市医疗单位信息
	 * @return
	 */
	@RequestMapping("/getIDMTarget")
	@ResponseBody
	public Map<String, Object> getIDMTarget() {
		Map<String,Object> resultMap = new HashMap<>();
		/*医生工作站慢病、传染病上报数*/
		resultMap.put(TargetConstants.IDM_CDM_STATION_REPORT,idmHealthTargetService.getIDMTarget(null,null,null,TargetConstants.IDM_CDM_STATION_REPORT).intValue());
		/*医生工作站慢病、传染病 昨日上报数*/
		resultMap.put(TargetConstants.IDM_YESTERDAY_REPORT,idmHealthTargetService.getIDMTarget(null,null,null,TargetConstants.IDM_YESTERDAY_REPORT).intValue());
		return resultMap;
	}

	/**
	 * 获取首页中图标的数据
	 * @param model
	 */
	@RequestMapping("/chart")
	public @ResponseBody Object statisticsForImager(Model model) {
		/*获取上个月的月份*/
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		calendar.setTime(new Date());
		Map<String,Object> allData = new HashMap<String,Object>();
		Map<String,Object> outpatientCount = new HashMap<String, Object>();
		Map<String,Object> hospitalizeCount = new HashMap<String, Object>();
		Map<String,Object> outFeeCount = new HashMap<String, Object>();
		Map<String,Object> outInsuranceFeeCount = new HashMap<String, Object>();
		Map<String,Object> hosFeeCount = new HashMap<String, Object>();
		Map<String,Object> hosInsuranceFeeCount = new HashMap<String, Object>();
		for(int month = calendar.get(Calendar.MONTH);month >= 0;month--) {
			Criteria criteriaMonth = new Criteria("create_date", OP.BETWEEN, DateUtil.getDateRangeByMonth(month));
			HmOutpatient outpatientMonth = ihmStatisticsService.statisticsOutpatient(criteriaMonth);
			HmHospitalize hospitalizeMonth = ihmStatisticsService.statisticsHospitalize(criteriaMonth);
			outpatientCount.put("outpatient" + month, ObjectUtil.isNotEmpty(outpatientMonth.getAllNum()) ? outpatientMonth.getAllNum() : 0);
			hospitalizeCount.put("hospitalize" + month, ObjectUtil.isNotEmpty(hospitalizeMonth.getLeaveHospitalNum()) ? hospitalizeMonth.getLeaveHospitalNum() : 0);
			outFeeCount.put("outfee" + month, ObjectUtil.isNotEmpty(outpatientMonth.getAllFee()) ? outpatientMonth.getAllFee() : 0);
			outInsuranceFeeCount.put("outinsurancefee" + month, ObjectUtil.isNotEmpty(outpatientMonth.getInsuranceFee()) ? outpatientMonth.getInsuranceFee() : 0);
			hosFeeCount.put("hosfee" + month, ObjectUtil.isNotEmpty(hospitalizeMonth.getInHosFee()) ? hospitalizeMonth.getInHosFee() : 0);
			hosInsuranceFeeCount.put("hosinsurancefee" + month, ObjectUtil.isNotEmpty(hospitalizeMonth.getInInsuranceFee()) ? hospitalizeMonth.getInInsuranceFee() : 0);
		}
		
		allData.put("outpatient", outpatientCount);
		allData.put("hospitalize", hospitalizeCount);
		allData.put("outfees", outFeeCount);
		allData.put("outinsurancefees", outInsuranceFeeCount);
		allData.put("hosfees", hosFeeCount);
		allData.put("hosinsurancefees", hosInsuranceFeeCount);
		allData.put("year", year);
				
		return allData;
	}
}