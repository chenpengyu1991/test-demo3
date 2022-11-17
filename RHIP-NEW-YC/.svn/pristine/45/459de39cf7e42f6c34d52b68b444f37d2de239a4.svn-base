package com.founder.rhip.vaccine.controller.hospital;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.VoUtil;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ph.dto.vaccine.VaccinationDetailsDTO;
import com.founder.rhip.ph.service.vaccine.IVaccinationReadService;
import com.founder.rhip.ph.service.vaccine.IVaccinationSaveService;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author liu_jingyin 狂犬疫苗
 */
@Controller
@RequestMapping(value = "/ph/rabies")
public class RabiesController extends BaseController {

	@Resource(name = "vaccineService")
	private IVaccinationReadService vaccineService;

	@Resource(name = "vaccineOperatorService")
	IVaccinationSaveService vaccineOperatorService;
	
	/**
	 * 选择狂犬疫苗接种类型
	 * @param model
	 * @return
	 */
	@RequestMapping("/select")
	public String select(Model model) {
		return "rhip.vaccine.select.rabies";
	}

	/**
	 * 新增疫苗接种
	 * 
	 * @return
	 */
	@RequestMapping("/add/{rabiesType}")
	public String add(@PathVariable("rabiesType") String rabiesType, Model model) {
		model.addAttribute("rabiesType", rabiesType);
		model.addAttribute("treatmentTime", new Date());
		model.addAttribute("currentDate", DateUtil.getDateTime("yyyy/MM/dd", new Date()));
		return "rhip.vaccine.hospital.add.rabies";
	}
	/**
	 * 修改
	 * 
	 * @param ehrId
	 * @param model
	 * @return
	 */
	@RequestMapping("/update")
	public String update(String ehrId, Model model) {
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",  0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		VaccinationMgmt vaccinationMgmt = vaccineService.getVaccinationMgmt(new Criteria("personId",vaccinationEvent.getPersonId()));
		TraumaHistory traumaHistory = getTraumaHistory(ehrId);
		
		model.addAttribute("ehrId", ehrId);
		model.addAttribute("traumaHistory", traumaHistory);
		model.addAttribute("treatmentTime", new Date());
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		return "rhip.vaccine.hospital.add.rabies";
	}
	
	/**
	 * 删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/delete")
	public @ResponseBody
	String delete(HttpServletRequest request, String ehrId) {
        createOperationLog(request, RhipModuleName.VACCINE, "狂犬疫苗注射", OperationName.DELETE);
		vaccineOperatorService.deleteVaccine(ehrId,IVaccinationSaveService.VACCINE_RABIES);
		return "1";
	}
	
	/** 
	* @Title: updateVaccine 
	* @Description: 查看疫苗注射情况
	* @param @param request
	* @param @param ehrId
	* @param @param model
	* @param @return
	* @return String
	* @throws 
	*/
	@RequestMapping("/injectVaccine")
	public String injectVaccine(HttpServletRequest request,String ehrId, String operate, ModelMap model){
		getVaccine(ehrId, operate, model);
		return "rhip.vaccine.hospital.show.rabies"; 
	}

	/**
	 * @Title: updateVaccine
	 * @Description: 查看疫苗注射情况
	 * @param @param request
	 * @param @param ehrId
	 * @param @param model
	 * @param @return
	 * @return String
	 * @throws
	 */
	@RequestMapping("/searchVaccine")
	public String searchVaccine(HttpServletRequest request,String ehrId, String operate, ModelMap model){
		getVaccine(ehrId, operate, model);
		return "rhip.vaccine.hospital.rabies.list";
	}

	/**
	 * 获取疫苗接种列表
	 * @param ehrId
	 * @param operate
	 * @param model
	 */
	private void getVaccine(String ehrId, String operate, ModelMap model) {
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",  0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		VaccinationMgmt vaccinationMgmt = vaccineService.getVaccinationMgmt(new Criteria("personId",vaccinationEvent.getPersonId()));

		TraumaHistory traumaHistory = getTraumaHistory(ehrId);

		model.addAttribute("ehrId", ehrId);
		model.addAttribute("traumaHistory", traumaHistory);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("operate", operate);

		List<VaccinationInfo> infoList = vaccineService.getVaccinationList(criteria.add("immuType", IVaccinationSaveService.VACCINE_RABIES));
		model.addAttribute("vaccinationInfoList", infoList);
		boolean prevaccination = false;
		if (ObjectUtil.isNotEmpty(vaccinationEvent.getRabiesType()) && vaccinationEvent.getRabiesType().equals(9)) {
			prevaccination = true;
		}
		boolean continueInject = getInject(traumaHistory, infoList, prevaccination);
		model.addAttribute("continueInject", continueInject);
		boolean continueGray = false;
		//免疫蛋白
		Criteria criteriaContinue = new Criteria("ehrId", ehrId).add("isDelete",  0);
		Criteria criteriaImmuType = new Criteria("immuType",OP.IN,new String[]{IVaccinationSaveService.VACCINE_GRAY});
		criteriaContinue.add(criteriaImmuType);
		List<VaccinationInfo> grayinfoList = vaccineService.getVaccinationList(criteriaContinue);
		if(ObjectUtil.isNotEmpty(grayinfoList)){
			model.addAttribute("grayInfo", grayinfoList.get(0));
		}else{
			continueGray = getGray(traumaHistory);
		}
		model.addAttribute("continueGray", continueGray);
	}
	@RequestMapping("/injectOne")
	public String injectOne(HttpServletRequest request,String ehrId,ModelMap model){
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete", 0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		List<VaccinationInfo> infoList = vaccineService.getVaccinationList(criteria.add("immuType", IVaccinationSaveService.VACCINE_RABIES));
		model.addAttribute("ehrId", ehrId);
		String times = getTimes(infoList);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("timesString", times);
		model.addAttribute("currentDate",new Date());
		return "rhip.vaccine.hospital.inject.vaccine"; 
	}
	
	@RequestMapping("/injectGray")
	public String injectGray(HttpServletRequest request,String ehrId,ModelMap model){
		model.addAttribute("ehrId", ehrId);
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete", 0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("currentDate",new Date());
		return "rhip.vaccine.hospital.inject.gray"; 
	}
	
	/** 
	* @Title: getTimes 
	* @Description: 获取要接种的次数 
	* @param @param request
	* @param @param infoList
	* @param @return
	* @return String
	* @throws 
	*/
	private String getTimes(List<VaccinationInfo> infoList){
		StringBuffer timesString = new StringBuffer();
		for (VaccinationInfo vaccinationInfo : infoList) {
			String times = vaccinationInfo.getInoculationTimes();
			timesString.append(times);
		}
		return timesString.toString();
	}
	
	/** 
	* @Title: getInject 
	* @Description: 获取可以继续接种的权限
	* @param @param request
	* @param @param model
	* @param @param traumaHistory
	* @param @param infoList
	* @param prevaccination 暴露前免疫
	* @param @return
	* @return boolean
	* @throws 
	*/
	private boolean getInject(TraumaHistory traumaHistory,List<VaccinationInfo> infoList, boolean prevaccination){
		// 判断是否可以继续接种
		boolean continueInject = true;
		
		//已经注射5次则不能注射
		if(ObjectUtil.isNotEmpty(infoList) && infoList.size() >= 5){
			continueInject = false;
		}
		//咬伤等级为1的不能注射
		if (ObjectUtil.isNotEmpty(traumaHistory.getBiteLevel()) && traumaHistory.getBiteLevel() == 1  && !prevaccination) {
			continueInject = false;
		}
		return continueInject;
	}

	
	private boolean getGray(TraumaHistory traumaHistory){
		boolean grayInject =  true;
		if (ObjectUtil.isNullOrEmpty(traumaHistory.getBiteLevel())) {
			grayInject = false;
			return grayInject;
		}
		if (traumaHistory.getBiteLevel() != 3) {
			grayInject = false;
			return grayInject;
		}
		return grayInject;
	}
	
	/** 
	* @Title: getTraumaHistory 
	* @Description: 获取咬伤历史 
	* @param @param ehrId
	* @param @return
	* @return TraumaHistory
	* @throws 
	*/
	private TraumaHistory getTraumaHistory(String ehrId){
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete", OP.NE, 1);
		TraumaHistory traumaHistory = vaccineService.getTraumaHistory(criteria);
		
		// 将咬伤类型值付给其他
		traumaHistory.setHurtOther(traumaHistory.getHurtType());
		String tp = traumaHistory.getHurtType();
		if (tp != null && !tp.equals("狗")) {

			if (!tp.equals("猫")) {
                if (!tp.equals("蝙蝠")) {
                    traumaHistory.setHurtType("0");
                }
			}
		}
		if(ObjectUtil.isNotEmpty(traumaHistory.getHurtSource())){
			traumaHistory.setSourceOther(traumaHistory.getHurtSource());
			String tp1 = traumaHistory.getHurtSource();
			if (tp1 != null &&!tp1.equals("自家养")) {
				if (!tp1.equals("他人养")) {
	                if (!tp1.equals("流浪动物")) {
	                    traumaHistory.setHurtSource("0");
	                }
				}
			}
		}
		if(ObjectUtil.isNotEmpty(traumaHistory.getExposeType())){
			traumaHistory.setExposeOther(traumaHistory.getExposeType());
			String tp2 = traumaHistory.getExposeType();
			if (tp2 != null && !tp2.equals("咬伤")) {
			if (!tp2.equals("抓伤")) {
                if (!tp2.equals("其他")) {
                    traumaHistory.setExposeType("0");
                }
			}
		}
		}
		return traumaHistory;
	}
	
	
	@RequestMapping("/printDetails")
	public String printDetail(HttpServletRequest request, String ehrId,String vacciantionFlag, ModelMap model) {
		Criteria criteria = new Criteria("ehrId", ehrId).add("isDelete",  0);
		VaccinationEvent vaccinationEvent = vaccineService.getVaccinationEvent(criteria);
		VaccinationMgmt vaccinationMgmt = vaccineService.getVaccinationMgmt(new Criteria("personId",vaccinationEvent.getPersonId()));
		TraumaHistory traumaHistory = vaccineService.getTraumaHistory(criteria);
		List<VaccinationInfo> infoList = vaccineService.getVaccinationList(criteria.add("immuType", "1"));
		
		model.addAttribute("ehrId", ehrId);
		model.addAttribute("traumaHistory", traumaHistory);
		model.addAttribute("vaccinationEvent", vaccinationEvent);
		model.addAttribute("vacciantionFlag", vacciantionFlag);//0:打印非加强针页面，1：打印加强针页面
		model.addAttribute("vaccinationMgmt", vaccinationMgmt);
		model.addAttribute("vaccinationInfoList", infoList);
		model.addAttribute("vaccineRecordDTO2", vaccineService.getVaccinationInfo(initType5Criteria(ehrId)));
		
		Map<String, Date> reservation = getReservationDate(vaccinationEvent.getCreateDate(), vacciantionFlag, vaccinationEvent.getLastInjectedDate(), vaccinationEvent.getRabiesType());
		model.addAttribute("reservation", reservation);//预约日期
        model.addAttribute("currentDt", new Date());//当前日期

        Organization org = getCurrentOrg(request);
		model.addAttribute("organName", org.getOrganName());//接种单位
		model.addAttribute("organTel", org.getTel());//接种单位电话
		return "rhip.vaccine.hospital.print.rabies";
	}
	
	/**
	 * 自动生成预约日期。
	 * 规则是：第一针是第0天（当天）、第二针是第7天、第三针是第21天。
	 * 如果建卡日期为空，则取当前日期
	 * @param vaccintionFlag "0"非加强针 "1"加强针  修改人：高飞 修改日期：2017/01/10
	 * @param lastInjectedDate TODO
	 * @param rabiesType 狂犬疫苗接种类型
	 * @return
	 * @author Ye jianfei
	 */
	private Map<String,Date> getReservationDate(Date firstDate, String vaccintionFlag, Date lastInjectedDate, Integer rabiesType){
		Map<String, Date> reservationMap = new HashMap<String, Date>();
		if(ObjectUtil.isNullOrEmpty(firstDate)){
			firstDate = new Date();
		}
		if (StringUtils.equals(vaccintionFlag, "0") || StringUtils.isBlank(vaccintionFlag)) { // 非加强针
			if (ObjectUtil.isNotEmpty(rabiesType) && rabiesType.equals(5)) { // 五针法
				Date secondDate = getVisitDate(firstDate, 3);
				Date thirdDate = getVisitDate(firstDate, 7);
				Date fourDate = getVisitDate(firstDate, 14);
				Date fiveDate = getVisitDate(firstDate, 28);
				reservationMap.put("firstDate", firstDate);
				reservationMap.put("secondDate", secondDate);
				reservationMap.put("thirdDate", thirdDate);
				reservationMap.put("fourDate", fourDate);
				reservationMap.put("fiveDate", fiveDate);
			} else if (ObjectUtil.isNotEmpty(rabiesType) && rabiesType.equals(9)) { // 健康人预防接种
				Date secondDate = getVisitDate(firstDate, 7);
				Date thirdDate = getVisitDate(firstDate, 21);
				Date fourDate = getVisitDate(firstDate, 28);
				reservationMap.put("firstDate", firstDate);
				reservationMap.put("secondDate", secondDate);
				reservationMap.put("thirdDate", thirdDate);
				reservationMap.put("fourDate", fourDate);
			} else {  // 四针法
				Date secondDate = getVisitDate(firstDate, 7);
				Date thirdDate = getVisitDate(firstDate, 21);
				reservationMap.put("firstDate", firstDate);
				reservationMap.put("secondDate", secondDate);
				reservationMap.put("thirdDate", thirdDate);
			}
		} else { // 加强针
//			int ret = vaccineService.analyseLastVaccineDate(firstDate, personId);
			// 计算最近接种时间与本次就诊时间相差的天数
			int days = DateUtil.getBetweenDays(lastInjectedDate, firstDate);
			if (ObjectUtil.isNotEmpty(rabiesType) && rabiesType.equals(9)) { // 健康人预防接种
				if (days >= 365 && days < 365 * 2) {
					reservationMap.put("firstDate", firstDate);
				}
			} else {
				// 距离最后一次接种日期大于183天且小于等于365天打两针，分别为0、3天注射
				if (days > 183 && days <= 365) {
					reservationMap.put("firstDate", firstDate);
					reservationMap.put("secondDate", getVisitDate(firstDate, 3));
				} else if (days > 365 && days <= 365*3) { // 距离最后一次接种日期大于365天且小于等于3年的大三针，分别为0、3、7天注射，第一针打一针
					reservationMap.put("firstDate", firstDate);
					reservationMap.put("secondDate", getVisitDate(firstDate, 3));
					reservationMap.put("thirdDate", getVisitDate(firstDate, 7));
				} else if (days > 365*3) { // 距离最后一次接种日期大于3年以上重新接种，并且第一次打两针
					reservationMap.put("firstDate", firstDate);
					reservationMap.put("secondDate", getVisitDate(firstDate, 3));
					reservationMap.put("thirdDate", getVisitDate(firstDate, 7));
					reservationMap.put("fourThDate", firstDate); // 便于页面判断第一针打两针
				}
			}
		}
		return reservationMap;
	}
	
	private Map<String,Date> getReservationDate1(Date firstDate, String vaccintionFlag, Date lastInjectedDate){
		Map<String, Date> reservationMap = new HashMap<String, Date>();
		if(ObjectUtil.isNullOrEmpty(firstDate)){
			firstDate = new Date();
		}
		if (StringUtils.equals(vaccintionFlag, "0") || StringUtils.isBlank(vaccintionFlag)) {// 非加强针
			Date secondDate = getVisitDate(firstDate, 3);
			Date thirdDate = getVisitDate(firstDate, 7);
			Date fourDate = getVisitDate(firstDate, 14);
			Date fiveDate = getVisitDate(firstDate, 28);
			reservationMap.put("firstDate", firstDate);
			reservationMap.put("secondDate", secondDate);
			reservationMap.put("thirdDate", thirdDate);
			reservationMap.put("fourDate", fourDate);
			reservationMap.put("fiveDate", fiveDate);
		} else { // 加强针
//			int ret = vaccineService.analyseLastVaccineDate(firstDate, personId);
			// 计算最近接种时间与本次就诊时间相差的天数
			int days = DateUtil.getBetweenDays(lastInjectedDate, firstDate);
			// 距离最后一次接种日期大于183天且小于等于365天打两针，分别为0、3天注射
			if (days > 183 && days <= 365) {
				reservationMap.put("firstDate", firstDate);
				reservationMap.put("secondDate", getVisitDate(firstDate, 3));
			} else if (days > 365 && days <= 365*3) { // 距离最后一次接种日期大于365天且小于等于3年的大三针，分别为0、3、7天注射，第一针打一针
				reservationMap.put("firstDate", firstDate);
				reservationMap.put("secondDate", getVisitDate(firstDate, 3));
				reservationMap.put("thirdDate", getVisitDate(firstDate, 7));
			} else if (days > 365*3) { // 距离最后一次接种日期大于3年以上重新接种，并且第一次打两针
				reservationMap.put("firstDate", firstDate);
				reservationMap.put("secondDate", getVisitDate(firstDate, 3));
				reservationMap.put("thirdDate", getVisitDate(firstDate, 7));
				reservationMap.put("fourThDate", firstDate); // 便于页面判断第一针打两针
			}
		}
		return reservationMap;
	}
	
	private Map<String,Date> getReservationDate2(Date firstDate, String vaccintionFlag, Date lastInjectedDate){
		Map<String, Date> reservationMap = new HashMap<String, Date>();
		if(ObjectUtil.isNullOrEmpty(firstDate)){
			firstDate = new Date();
		}
		if (StringUtils.equals(vaccintionFlag, "0") || StringUtils.isBlank(vaccintionFlag)) {// 非加强针
			Date secondDate = getVisitDate(firstDate, 7);
			Date thirdDate = getVisitDate(firstDate, 21);
			Date fourDate = getVisitDate(firstDate, 28);
			reservationMap.put("firstDate", firstDate);
			reservationMap.put("secondDate", secondDate);
			reservationMap.put("thirdDate", thirdDate);
			reservationMap.put("fourDate", fourDate);
		} else { // 加强针
//			int ret = vaccineService.analyseLastVaccineDate(firstDate, personId);
			// 计算最近接种时间与本次就诊时间相差的天数
			int days = DateUtil.getBetweenDays(lastInjectedDate, firstDate);
			// 距离最后一次接种日期大于183天且小于等于365天打两针，分别为0、3天注射
			if (days > 183 && days <= 365) {
				reservationMap.put("firstDate", firstDate);
				reservationMap.put("secondDate", getVisitDate(firstDate, 3));
			} else if (days > 365 && days <= 365*3) { // 距离最后一次接种日期大于365天且小于等于3年的大三针，分别为0、3、7天注射，第一针打一针
				reservationMap.put("firstDate", firstDate);
				reservationMap.put("secondDate", getVisitDate(firstDate, 3));
				reservationMap.put("thirdDate", getVisitDate(firstDate, 7));
			} else if (days > 365*3) { // 距离最后一次接种日期大于3年以上重新接种，并且第一次打两针
				reservationMap.put("firstDate", firstDate);
				reservationMap.put("secondDate", getVisitDate(firstDate, 3));
				reservationMap.put("thirdDate", getVisitDate(firstDate, 7));
				reservationMap.put("fourThDate", firstDate); // 便于页面判断第一针打两针
			}
		}
		return reservationMap;
	}
	
	
	/**
	 * 保存新增或修改
	 * 
	 * @param request
	 * @param ehrId
	 * @param comment
	 * @param model
	 * @return
	 */
	@RequestMapping("/save")
	public String save(HttpServletRequest request, String ehrId, String comment, ModelMap model) {
		VaccinationDetailsDTO vaccinationDetailsDTO = VoUtil.getFormData(request, VaccinationDetailsDTO.class);

		// 其他动物咬伤处理
		String oter = vaccinationDetailsDTO.getTraumaHistory().getHurtType();
		String ot = vaccinationDetailsDTO.getTraumaHistory().getHurtOther();
		
		// 其他暴露
		String oter1 = vaccinationDetailsDTO.getTraumaHistory().getExposeType();
		String ot1 = vaccinationDetailsDTO.getTraumaHistory().getExposeOther();
				
		// 其他来源
		String oter2 = vaccinationDetailsDTO.getTraumaHistory().getHurtSource();
		String ot2 = vaccinationDetailsDTO.getTraumaHistory().getSourceOther();
		if ("0".equals(oter)) {
			vaccinationDetailsDTO.getTraumaHistory().setHurtType(ot);
		}
		if ("0".equals(oter1)) {
			vaccinationDetailsDTO.getTraumaHistory().setExposeType(ot1);
		}
		if ("0".equals(oter2)) {
			vaccinationDetailsDTO.getTraumaHistory().setHurtSource(ot2);
		}
		
		if (ObjectUtil.isNotEmpty(vaccinationDetailsDTO.getRabiesType()) && !vaccinationDetailsDTO.getRabiesType().equals(9)) { // 非预防性接种
			Date opsDate = vaccinationDetailsDTO.getTraumaHistory().getOpsDate();
			String opsHour = vaccinationDetailsDTO.getTraumaHistory().getOpsHour();
			String opsDateStr = DateUtil.toFormatString("yyyy/MM/dd", opsDate);
			Date opsDateReal = DateUtil.convert("yyyy/MM/dd hh:mm", opsDateStr + " " + opsHour);
			vaccinationDetailsDTO.getTraumaHistory().setOpsDate(opsDateReal);

		}
		vaccinationDetailsDTO.setCurrentOrg(getCurrentOrg(request));
		vaccinationDetailsDTO.setCurrentUser(super.getCurrentUser(request));

        Date treatmentTime = vaccinationDetailsDTO.getTraumaHistory().getTreatmentTime();
        String treatmentHour = vaccinationDetailsDTO.getTraumaHistory().getTreatmentHour();
        String treatmentTimeStr = DateUtil.toFormatString("yyyy/MM/dd", treatmentTime);
        Date treatmentTimeReal = DateUtil.convert("yyyy/MM/dd hh:mm", treatmentTimeStr + " " + treatmentHour);
        vaccinationDetailsDTO.getTraumaHistory().setTreatmentTime(treatmentTimeReal);

        createOperationLog(request, RhipModuleName.VACCINE, "狂犬疫苗注射", StringUtil.isNotEmpty(ehrId)?OperationName.UPDATE:OperationName.ADD);

		//把同一事务的方法添加到一个SERVICE方法中，并添加事务 modify yjf 20140211
		vaccineOperatorService.save(vaccinationDetailsDTO,comment,ehrId);
		
		return EHRMessageUtil.returnMsg(model, 1);
		}
	
	
	/**
	 * 继续接种
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/contine")
	public String contineRabiesSave(HttpServletRequest request, String comment, VaccinationInfo vaccinationInfo, ModelMap model) {
		Organization currentOrg = getCurrentOrg(request);
		User currentUser = super.getCurrentUser(request);
//		Integer completeFlag = Integer.valueOf(request.getParameter("completeFlag"));
		vaccinationInfo.setVaccineName("狂犬疫苗");
		vaccinationInfo.setImmuType(IVaccinationSaveService.VACCINE_RABIES);
		vaccinationInfo.setImmuUnitId(getCurrentOrg(request).getOrganCode());
		vaccineOperatorService.contineSave(vaccinationInfo,currentOrg,currentUser,comment);
		return EHRMessageUtil.returnMsg(model, 1);
	}

	/**
	 * 继续接种免疫球蛋白
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveGray")
	public String saveGray(HttpServletRequest request, VaccinationInfo vaccinationInfo, String comment, ModelMap model) {
		Organization currentOrg = getCurrentOrg(request);
		User currentUser = super.getCurrentUser(request);
		
		vaccinationInfo.setVaccineName("免疫球蛋白");
		vaccinationInfo.setImmuType(IVaccinationSaveService.VACCINE_GRAY);
		vaccinationInfo.setImmuUnitId(getCurrentOrg(request).getOrganCode());
		vaccineOperatorService.contineSave(vaccinationInfo,currentOrg,currentUser, comment);
		return EHRMessageUtil.returnMsg(model, 1);
	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/deleteVaccine")
	public String deleteVaccine(HttpServletRequest request,Long id,ModelMap model) {
		vaccineOperatorService.deleteVaccine(id);
		return EHRMessageUtil.returnMsg(model, 1);
	}

	/**
	 * 查看患者最近一次是否正规注射，及注射情况
	 *
	 * @param personId
	 * @param hitDate
	 * @param response
	 * @param model
	 * @return
	 * @author Ye jianfei
	 */
	@RequestMapping("/getVaccineType")
	public String getVaccineType(Long personId,String hitDate,HttpServletResponse response, ModelMap model) {
		Map<String, Object> map = vaccineOperatorService.getRabiesVaccine(personId,hitDate);
		return EHRMessageUtil.returnMsg(model, map);
	}
	
	/**
	 * 删除
	 * @param model
	 * @return
	 */
	@RequestMapping("/updatePrintFlag")
	public String updatePrintFlag(String ehrId,Integer printFlag, ModelMap model) {
		vaccineOperatorService.updatePrintFlag(ehrId, printFlag);
		return EHRMessageUtil.returnMsg(model, 1);
	}
	/**
	 * @param ehrId
	 * @return
	 */
	private Criteria initType5Criteria(String ehrId) {
		return new Criteria("ehrId", ehrId).add("isDelete", OP.NE, 1).add("immuType", "5");
	}
	
	private Date getVisitDate(Date date, int amount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, amount);
		return calendar.getTime();
	}
}
