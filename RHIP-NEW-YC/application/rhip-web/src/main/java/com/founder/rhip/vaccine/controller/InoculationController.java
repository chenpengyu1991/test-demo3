package com.founder.rhip.vaccine.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.founder.rhip.ehr.entity.management.InoculationAppointment;
import com.founder.rhip.ehr.repository.control.IInoculationDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseController;
import com.founder.rhip.ehr.common.EHRMessageUtil;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.RhipModuleName;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.rhip.ehr.repository.summary.IDiseaseHistoryDao;
import com.founder.rhip.ehr.service.export.IDataSource;
import com.founder.rhip.ehr.service.export.IExcelExportService;
import com.founder.rhip.hm.service.IPersonInfoService;
import com.founder.rhip.idm.controller.form.ReportStatisticsQueryForm;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ph.service.vaccine.IVaccinationReadService;
@Controller
@RequestMapping("/inoculation")
public class InoculationController extends BaseController {
	
	@Resource(name = "vaccineService")
	private IVaccinationReadService vaccineService;
	
	@Autowired
	private IInoculationDao inoculationDao;
	
	@Autowired
	private IPersonInfoService personInfoService;
	
	@Autowired
	private IVaccinationReadService vaccinationReadService;
	
	@Autowired
	private IDiseaseHistoryDao diseaseHistoryDao;
	
	@Resource(name = "excelExportService")
	private IExcelExportService excelExportService;
	
	@Autowired
	private IOrganizationApp organizationApp;
	@RequestMapping("/index")
	public String InoculationIndex(HttpServletRequest request, Model model){
		String dateStr = DateUtil.getDateTime("yyyy/MM", new Date());
		Date defaultMonth = DateUtil.parseSimpleDate(new StringBuilder(dateStr).append("/01").toString(), "yyyy/MM/dd");
		model.addAttribute("defaultMonth", defaultMonth);
		
		return "rhip.vaccine.inoculation.index";
	}
	
	@RequestMapping("/list")
	public String InoculationList(HttpServletRequest request,Integer indexPage, Model model ,Date dateFrom ,Date dateTo){
		Page page = super.getPage(request, indexPage);
		Criteria ca = new Criteria();
		String personName = request.getParameter("epersonName");
		String personIdcard = request.getParameter("epersonIdcard");
		String organCode = request.getParameter("eorganCode");
		String isInject = request.getParameter("isInject");
		String vaccineType = request.getParameter("vaccineType");
		StringBuilder sql = null;
		if(ObjectUtil.isNotEmpty(isInject)){
		sql = new StringBuilder("SELECT IA.*,DE.PNEUMONIA_VACC_FLAG FROM DC_INOCULATION_APPOINTMENT IA INNER JOIN BI_PERSON_INFO@DL_MEI ON IA.PERSON_IDCARD =BI_PERSON_INFO.IDCARD LEFT JOIN DC_VACCINATION_EVENT DE ON BI_PERSON_INFO.ID = DE.PERSON_ID  AND DE.immu_type='4' AND DE.IS_DELETE !='1' ");
		sql.append(" WHERE (IA.STATUS = '1' OR IA.STATUS = '2')");
		if(ObjectUtil.isNotEmpty(personName)){
			sql.append(" AND IA.PERSON_NAME LIKE '%"+personName+"%'");
		}
		if(ObjectUtil.isNotEmpty(organCode)){
			sql.append(" AND IA.ORGAN_CODE = '"+organCode+"'");
		}
		if(ObjectUtil.isNotEmpty(personIdcard)){
			sql.append(" AND IA.PERSON_IDCARD = '"+personIdcard+"'");
		}
		if(isInject.equals("1")){
			if(vaccineType.equals("1") || vaccineType.equals("3") || vaccineType.equals("4")){
				sql.append(" AND DE.PNEUMONIA_VACC_FLAG = '"+isInject+"'");
			}
			else{
				sql.append(" AND IA.INOCULATE_MARK  = '"+isInject+"'" );
			}
		}else {
			if(vaccineType.equals("1") || vaccineType.equals("3") || vaccineType.equals("4")){
				sql.append(" AND (DE.PNEUMONIA_VACC_FLAG = '"+isInject+"' OR DE.PNEUMONIA_VACC_FLAG IS NULL)");
			}else{
				sql.append(" AND IA.INOCULATE_MARK  = '"+isInject+"'" );
			}
		}
		if(ObjectUtil.isNotEmpty(dateFrom)){
			sql.append(" AND IA.CREATE_DATE >= to_date('"+DateUtil.convertDateToString(dateFrom)+" 00:00:00','yyyy-mm-dd HH24:mi:ss')");
		}
		if(ObjectUtil.isNotEmpty(dateTo)){
			sql.append(" AND IA.CREATE_DATE <= to_date('"+DateUtil.convertDateToString(dateTo)+" 23:59:59','yyyy-mm-dd HH24:mi:ss')");
		}
		if(ObjectUtil.isNotEmpty(vaccineType)){
			sql.append(" AND IA.VACCINE_TYPE = '"+vaccineType+"'");
		}
		sql.append(" ORDER BY IA.CREATE_DATE DESC");
		}else{
			sql = new StringBuilder("SELECT IA.* FROM DC_INOCULATION_APPOINTMENT IA");
			sql.append(" WHERE (IA.STATUS = '1' OR IA.STATUS = '2') ");
			if(ObjectUtil.isNotEmpty(personName)){
				sql.append(" AND IA.PERSON_NAME LIKE '%"+personName+"%'");
			}
			if(ObjectUtil.isNotEmpty(organCode)){
				sql.append(" AND IA.ORGAN_CODE = '"+organCode+"'");
			}
			if(ObjectUtil.isNotEmpty(personIdcard)){
				sql.append(" AND IA.PERSON_IDCARD = '"+personIdcard+"'");
			}
			if(ObjectUtil.isNotEmpty(dateFrom)){
				sql.append(" AND IA.CREATE_DATE >= to_date('"+DateUtil.convertDateToString(dateFrom)+" 00:00:00','yyyy-mm-dd HH24:mi:ss')");
			}
			if(ObjectUtil.isNotEmpty(dateTo)){
				sql.append(" AND IA.CREATE_DATE <= to_date('"+DateUtil.convertDateToString(dateTo)+" 23:59:59','yyyy-mm-dd HH24:mi:ss')");
			}
			if(ObjectUtil.isNotEmpty(vaccineType)){
				sql.append(" AND IA.VACCINE_TYPE = '"+vaccineType+"'");
			}
			sql.append(" ORDER BY IA.CREATE_DATE DESC");
		}
		PageList<InoculationAppointment> list = vaccineService.getInoculationList(ca, page, sql.toString());
		for (int i = list.getList().size()-1; i >=0 ; i--) {
			if(StringUtil.isNotEmpty(list.getList().get(i).getPersonIdcard())){
				String gender = IDCardUtil.getGenderByIdCard(list.getList().get(i).getPersonIdcard());
				list.getList().get(i).setPersonGender(gender);
				if(ObjectUtil.isNotEmpty(personInfoService.getPersonInfo(list.getList().get(i).getPersonIdcard()))){
				String address = personInfoService.getPersonInfo(list.getList().get(i).getPersonIdcard()).getPaAddress();
				list.getList().get(i).setPersonAddress(address);
				}
			}
		}
	
		model.addAttribute("page",list.getPage());
		model.addAttribute("list",list.getList());
		return "rhip.vaccine.inoculation.list";
	}
	@RequestMapping("/view")
	public String viewInoculation(HttpServletRequest request, Model model, Long id){
		InoculationAppointment inoculationAppointment = getDetailsByIdCard(id);
		model.addAttribute("inoculationAppointment",inoculationAppointment);
		return "rhip.vaccine.inoculation.view";
	}
	@RequestMapping("/add")
	public String addInoculation(HttpServletRequest request, Model model){
		
	
		return "rhip.vaccine.inoculation.add";
	}
	@RequestMapping("/save")
	@ResponseBody
	public ModelMap saveInoculation(HttpServletRequest request, InoculationAppointment inoculationAppointment){
		ModelMap model = new ModelMap();
		inoculationAppointment.setStatus("2");
		long id = inoculationDao.getSequenceNextVal("SEQ_DC_INOCULATION_APPOINTMENT", Long.class);
		String createDate = request.getParameter("createDate");
		inoculationAppointment.setCreateDate(DateUtil.convert("yyyy/MM/dd HH:mm:ss", createDate));
		inoculationAppointment.setId(id);
		try {
		inoculationDao.insert(inoculationAppointment,"id","personName","personIdcard","phoneNumber","personAddress","createDate","organCode","status","vaccineType");
		model.addAttribute("result",true);
		model.addAttribute("message","保存成功");
		} catch (Exception e) {
			model.addAttribute("result",false);
			model.addAttribute("message",e.getMessage());
		}
		return model;
	}
	@RequestMapping("/delete")
	public String deleteInoculation(HttpServletRequest request, ModelMap model, Long id){
		Criteria ca = new Criteria();
		ca.add("Id",id);
		Parameters parameter = new Parameters("Status","5");
		if(inoculationDao.update(parameter, ca)>0){
			return EHRMessageUtil.returnMsg(model, "1");//删除成功
		}else{
			return EHRMessageUtil.returnMsg(model, "0");//删除失败
		}
	}
	
	@RequestMapping("/finishInoculation")
	public String finishInoculation(HttpServletRequest request, ModelMap model, Long id){
		Criteria ca = new Criteria();
		ca.add("Id",id);
		Parameters parameter = new Parameters("INOCULATE_MARK","1");
		if(inoculationDao.update(parameter, ca)>0){
			return EHRMessageUtil.returnMsg(model, "1");//删除成功
		}else{
			return EHRMessageUtil.returnMsg(model, "0");//删除失败
		}
	}
	
	@RequestMapping("/giveUpInoculation")
	public String giveUpInoculation(HttpServletRequest request, ModelMap model, Long id){
		Criteria ca = new Criteria();
		ca.add("Id",id);
		Parameters parameter = new Parameters("INOCULATE_MARK","-1"); // 放弃接种
		parameter.add("status", "4"); // 取消预约
		if(inoculationDao.update(parameter, ca)>0){
			return EHRMessageUtil.returnMsg(model, "1");//删除成功
		}else{
			return EHRMessageUtil.returnMsg(model, "0");//删除失败
		}
	}
	@RequestMapping("/queryPerson")
	public String queryPerson(String idCard, HttpServletResponse response, ModelMap model) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		// 判断是否已经预约
		Criteria criteria = new Criteria("personIdcard", idCard).add("status", OP.NE, "5");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, -365*5);
		Date date = calendar.getTime();
		DateUtil.getCriteriaByDateRange(criteria, "createDate", date, new Date());
		criteria.add("vaccineType","1");
		InoculationAppointment inoculationAppointment = inoculationDao.get(criteria);
		if (ObjectUtil.isNotEmpty(inoculationAppointment)) {
			map.put("flag", "invalid");
		}
		Date birthDate= IDCardUtil.getBirthDateByIdCard(idCard);
		Calendar ca1 = DateUtil.getToday();
		Calendar ca2 = DateUtil.getToday();
		Calendar ca3 = DateUtil.getToday();
		Calendar ca4 = DateUtil.getToday();
		ca1.add(Calendar.YEAR, -65);
		ca2.add(Calendar.YEAR, -85);
		ca3.add(Calendar.MONTH, -6);
		ca4.add(Calendar.YEAR, -3);
		Date date1= ca1.getTime();
		Date date2= ca2.getTime();
		Date date3= ca3.getTime();
		Date date4= ca4.getTime();
		if(birthDate.before(date3)){
			map.put("vaccineType3", false);
		}else{
			map.put("vaccineType3", true);
		}
		if(birthDate.before(date4)){
			map.put("vaccineType4", false);
		}else{
			map.put("vaccineType4", true);
		}
		if(birthDate.before(date1) && birthDate.after(date2)){
			map.put("vaccineType1", false);
		}else{
			map.put("vaccineType1", true);
		}
		PersonInfo person= personInfoService.getPersonInfo(idCard);
		if (ObjectUtil.isNotEmpty(person)) {
			map.put("personInfoFlag", true);
			map.put("Name", person.getName());
			map.put("Gender", person.getGender());
			map.put("Idcard", person.getIdcard());
			map.put("PaAddress", person.getPaAddress());
			map.put("PhoneNumber", person.getPhoneNumber());
			Criteria limitc = new Criteria("IS_LIMIT", OP.IS, "NULL").add(LOP.OR, "IS_LIMIT", OP.NE, 1);
			List<DiseaseHistory> diseaseHistoryList = diseaseHistoryDao.getDiseaseHistoryListByDistinctDiseaseCode(new Criteria("personId",person.getId()).add(limitc));
			if (ObjectUtil.isNotEmpty(diseaseHistoryList)) {
				List<String> strList = new ArrayList<>();
				for (DiseaseHistory diseaseHistory : diseaseHistoryList) {
					if (ObjectUtil.isNullOrEmpty(diseaseHistory) || ObjectUtil.isNullOrEmpty(diseaseHistory.getDiseaseName())) {
						continue;
					}
					StringBuilder builder = new StringBuilder();
					builder.append(DateUtil.getDateTime("yyyy/MM/dd", diseaseHistory.getConfirmationDate())).append(" ").append(diseaseHistory.getDiseaseName());
					strList.add(builder.toString());
				}
				if (ObjectUtil.isNotEmpty(strList)) {
					map.put("DiseaseHistory", StringUtils.join(strList, "</br>   "));
				}
			}
        }else{
			map.put("personInfoFlag", false);
			map.put("Idcard", idCard);
		}
		return EHRMessageUtil.returnMsg(model, map);
	}
	@RequestMapping("/excel")
	public void excel( ModelMap model, Date dateFrom ,Date dateTo,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		String personName = new String(request.getParameter("epersonName").getBytes("iso-8859-1"), "utf-8");  
		String title = "预防接种预约信息";
		final Criteria ca = new Criteria();
		String personIdcard = request.getParameter("epersonIdcard");
		String organCode = request.getParameter("eorganCode");
		String isInject = request.getParameter("isInject");
		String vaccineType = request.getParameter("vaccineType");
		final StringBuilder sql = new StringBuilder("SELECT IA.* FROM DC_INOCULATION_APPOINTMENT IA "
//				+ "INNER JOIN BI_PERSON_INFO@DL_MEI ON IA.PERSON_IDCARD =BI_PERSON_INFO.IDCARD "
//				+ "LEFT JOIN DC_VACCINATION_EVENT DE ON BI_PERSON_INFO.ID = DE.PERSON_ID AND DE.immu_type='4' AND"
//				+ " DE.IS_DELETE !='1' "
				);
		sql.append(" WHERE (IA.STATUS = '1' OR IA.STATUS = '2')");
		if(ObjectUtil.isNotEmpty(personName)){
			sql.append(" AND IA.PERSON_NAME LIKE '%"+personName+"%'");
		}
		if(ObjectUtil.isNotEmpty(organCode)){
			sql.append(" AND IA.ORGAN_CODE = '"+organCode+"'");
		}
		if(ObjectUtil.isNotEmpty(personIdcard)){
			sql.append(" AND IA.PERSON_IDCARD = '"+personIdcard+"'");
		}
//		if(ObjectUtil.isNotEmpty(isInject)){
//			if(isInject.equals("1")){
//				sql.append(" AND DE.PNEUMONIA_VACC_FLAG = '"+isInject+"'");
//			}else{
//				sql.append(" AND (DE.PNEUMONIA_VACC_FLAG = '"+isInject+"' OR DE.PNEUMONIA_VACC_FLAG IS NULL)");
//			}
//		}
		if(ObjectUtil.isNotEmpty(dateFrom)){
			sql.append(" AND IA.CREATE_DATE >= to_date('"+DateUtil.convertDateToString(dateFrom)+" 00:00:00','yyyy-mm-dd HH24:mi:ss')");
		}
		if(ObjectUtil.isNotEmpty(dateTo)){
			sql.append(" AND IA.CREATE_DATE <= to_date('"+DateUtil.convertDateToString(dateTo)+" 23:59:59','yyyy-mm-dd HH24:mi:ss')");
		}
		if(ObjectUtil.isNotEmpty(vaccineType)){
			sql.append(" AND IA.VACCINE_TYPE = '"+vaccineType+"'");
		}
		sql.append(" ORDER BY IA.CREATE_DATE DESC");
        createOperationLog(request, RhipModuleName.VACCINE, "数据", OperationName.EXP);
		excelExportService.exportListExecl(title, InoculationAppointment.class, response,new IDataSource() {
			@Override
			public List<Map<String, Object>> get(Page page) {
				Order order = new Order("create_date desc");
				List<Map<String, Object>> dataSource = inoculationDao.getMapListBySql(sql.toString(), ca);
				for (int i = 0; i < dataSource.size(); i++) {
//					if(ObjectUtil.isNotEmpty(dataSource.get(i).get("PERSON_IDCARD"))){
//						PersonInfo person = personInfoService.getPersonInfo(dataSource.get(i).get("PERSON_IDCARD").toString());
//						String address = null;
//						if(ObjectUtil.isNotEmpty(person)){
//							if(StringUtil.isNotEmpty(person.getPaAddress())){
//								address = person.getPaAddress();
//							}
//						}
//						dataSource.get(i).put("PA_ADDRESS", address);
//					}
					if(ObjectUtil.isNotEmpty(dataSource.get(i).get("ORGAN_CODE"))){
						String organName = null;
						if(ObjectUtil.isNotEmpty(organizationApp.queryOrgan(dataSource.get(i).get("ORGAN_CODE").toString()))){
							organName = organizationApp.queryOrgan(dataSource.get(i).get("ORGAN_CODE").toString()).getOrganName();
						}
						dataSource.get(i).put("ORGAN_NAME", organName);
					}
				}
				return dataSource;
			}
		});
	}
	public InoculationAppointment getDetailsByIdCard(Long id) {
		InoculationAppointment inoculationAppointment = inoculationDao.get(id);
		PersonInfo personInfo= personInfoService.getPersonInfo(inoculationAppointment.getPersonIdcard());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				return inoculationAppointment;
		}
		// 既往接种史 23价疫苗登记添加既往疾病史信息  修改人：高飞  修改日期：20180417
		//传染病保密设置
		Criteria limitc = new Criteria("IS_LIMIT", OP.IS, "NULL").add(LOP.OR, "IS_LIMIT", OP.NE, 1);
		inoculationAppointment.setPersonAddress(personInfo.getPaAddress());
		inoculationAppointment.setPersonGender(IDCardUtil.getGenderByIdCard(inoculationAppointment.getPersonIdcard()));
		List<DiseaseHistory> diseaseHistoryList = diseaseHistoryDao.getDiseaseHistoryListByDistinctDiseaseCode(new Criteria("personId",personInfo.getId()).add(limitc));
		if (ObjectUtil.isNotEmpty(diseaseHistoryList)) {
			List<String> strList = new ArrayList<>();
			for (DiseaseHistory diseaseHistory : diseaseHistoryList) {
				if (ObjectUtil.isNullOrEmpty(diseaseHistory) || ObjectUtil.isNullOrEmpty(diseaseHistory.getDiseaseName())) {
					continue;
				}
				StringBuilder builder = new StringBuilder();
				builder.append(DateUtil.getDateTime("yyyy/MM/dd", diseaseHistory.getConfirmationDate())).append(" ").append(diseaseHistory.getDiseaseName());
				strList.add(builder.toString());
			}
			if (ObjectUtil.isNotEmpty(strList)) {
				inoculationAppointment.setDiseaseHistory(StringUtils.join(strList, "</br>   "));
			}
		}
		return inoculationAppointment;
	}
	
	/**
	 * 进入23价疫苗报表查询界面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/report")
	public String report(HttpServletRequest request,ModelMap model) {
		/*根据当前机构，设置页面中的上报机构*/
		Organization org = getCurrentOrg(request);
		String currentOrgCode = org.getOrganCode();

		/*防疫科显示所有机构数据*/
		if (!hasRole(RoleType.JKYFJZ, request) && !hasRole(RoleType.ADMIN, request)){
			model.addAttribute("fillOrganCode", currentOrgCode);
		}
		String dateStr = DateUtil.getDateTime("yyyy/MM", new Date());
		Date defaultMonth = DateUtil.parseSimpleDate(new StringBuilder(dateStr).append("/01").toString(), "yyyy/MM/dd");
		model.addAttribute("defaultMonth", defaultMonth);
		return "rhip.vaccine.pneumonia.report";
	}
	
	@RequestMapping("/reportResult")
	public String reportResult(ReportStatisticsQueryForm form,HttpServletRequest request,ModelMap model) {
		Criteria criteria = new Criteria();
		if (ObjectUtil.isNotEmpty(form.getFillOrganCode())) {
			criteria.add("organCode", form.getFillOrganCode());
		}
		if (!hasRole(RoleType.JKYFJZ, request) && !hasRole(RoleType.ADMIN, request)){
			criteria.add("organCode", getCurrentOrg(request).getOrganCode());
		}
		if (ObjectUtil.isNotEmpty(form.getFillBeginDate())) {
			criteria.add("beginDate", form.getFillBeginDate());
		}
		if (ObjectUtil.isNotEmpty(form.getFillEndDate())) {
			criteria.add("endDate", form.getFillEndDate());
		}
		List<Map<String, Object>> mapList = vaccineService.statisticsVaccinationReport(criteria);
		model.addAttribute("mapList", mapList);
		return "rhip.vaccine.pneumonia.report.result";
	}
}
