package com.founder.rhip.ncp.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.service.ICdmPersonService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.WebProperties;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.ncp.dao.INcpPatientDao;
import com.founder.rhip.ncp.entity.NcpMonitorPlan;
import com.founder.rhip.ncp.entity.NcpPatient;
import com.founder.rhip.ncp.repository.IMonitorPlanDao;
import com.founder.rhip.ncp.repository.INcpMonitorPlanDao;

@Service("ncpPatientService")
public class NcpPatientServiceImpl extends AbstractService implements INcpPatientService {
    @Resource(name = "ncpPatientDao")
    private INcpPatientDao ncpPatientDao;
    @Resource(name = "cdmPersonService")
    private ICdmPersonService cdmPersonService;
	@Resource(name = "platformService")
	private IPlatformService platformService;
    @Resource(name = "ncpMonitorPlanDao")
    private IMonitorPlanDao ncpMonitorPlanDao;
	@Override
	public PageList<NcpPatient> getNcpPatientList(Page buildPage, Criteria criteria) {
		return ncpPatientDao.getNcpPatientList(buildPage,criteria);
	}
	
	@Override
	@Transactional
	public int saveNcpPatientInfo(NcpPatient ncpPatient, User user, Organization organization) {
		  PersonInfo personInfo=ncpPatient.getPersonInfo();
		  personInfo.setId(ncpPatient.getPersonId());
		  cdmPersonService.saveOrUpdatePerson(personInfo, user, organization);
		  Criteria criteria=new Criteria();
		  criteria.add("personId", ncpPatient.getPersonId());
		  NcpPatient patient= ncpPatientDao.get(criteria);
		String[] properties1 = {"cardno","cardType","personId", "createOrg", "patientType","zlType", "clinicalClass", "diagnosticDate", "dischargeDate", "diagnosticHospital", "segregationBegin", "segregationEnd",
				"segregationLocation", "updateTime","managementTime"};
		if(ObjectUtil.isNotEmpty(ncpPatient.getId())) {
			ncpPatient.setCardno(ncpPatient.getPersonInfo().getIdcard());
			ncpPatient.setCardType("0");
			ncpPatient.setUpdateTime(new Date());
			ncpPatient.setPersonId(ncpPatient.getPersonId());
			return ncpPatientDao.update(ncpPatient,properties1);
		} else if(ObjectUtil.isNotEmpty(patient)){
			
			String[] properties2 = {"cardno","cardType","personId", "zlType","createOrg", "patientType", "clinicalClass", "diagnosticDate", "dischargeDate", "diagnosticHospital", "segregationBegin", "segregationEnd",
					"segregationLocation", "createTime", "updateTime","isDelete","managementTime"};
			patient.setIsDelete(0);
			patient.setCardno(ncpPatient.getPersonInfo().getIdcard());
			patient.setCreateOrg(organization.getOrganCode());
			patient.setPatientType(ncpPatient.getPatientType());
			patient.setZlType(ncpPatient.getZlType());
			patient.setClinicalClass(ncpPatient.getClinicalClass());
			patient.setDiagnosticDate(ncpPatient.getDiagnosticDate());
			patient.setDischargeDate(ncpPatient.getDischargeDate());
			patient.setDiagnosticHospital(ncpPatient.getDiagnosticHospital());
			patient.setSegregationBegin(ncpPatient.getSegregationBegin());
			patient.setSegregationEnd(ncpPatient.getSegregationEnd());
			patient.setSegregationLocation(ncpPatient.getSegregationLocation());
			patient.setCreateTime(new Date());
			patient.setUpdateTime(new Date());
			patient.setManagementTime(ncpPatient.getManagementTime());
			return ncpPatientDao.update(patient,properties2);
		 }else {
			ncpPatient.setCardno(ncpPatient.getPersonInfo().getIdcard());
			ncpPatient.setCardType("0");
			ncpPatient.setHealthStatus("0");
			ncpPatient.setReexamineStatus("0");
			ncpPatient.setCreateOrg(organization.getOrganCode());
			ncpPatient.setUpdateTime(new Date());
			ncpPatient.setCreateTime(new Date());
			ncpPatient.setIsDelete(0);
			List<NcpMonitorPlan> plans = new ArrayList<NcpMonitorPlan>();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(ncpPatient.getDischargeDate());
			Number ncpPatientid= ncpPatientDao.generatedKey(ncpPatient,"ID",null);
			int followupTimes = Integer.valueOf(WebProperties.getMsg("ncp.followp.times"));
			for (int i = 1; i < followupTimes+1; i++) {
				NcpMonitorPlan ncpMonitorPlan = new NcpMonitorPlan();
				ncpMonitorPlan.setCardno(ncpPatient.getPersonInfo().getIdcard());
				ncpMonitorPlan.setCreateTime(new Date());
				ncpMonitorPlan.setPlanType("1");
				ncpMonitorPlan.setCreateStaffCode(user.getStaffCode());
				ncpMonitorPlan.setPid(new BigDecimal(ncpPatientid.longValue()));
				calendar.add(java.util.Calendar.DATE, 1);
				ncpMonitorPlan.setType(new BigDecimal(1));
				ncpMonitorPlan.setPlanDate(calendar.getTime());
				plans.add(ncpMonitorPlan);
			}
			
			NcpMonitorPlan ncpMonitorPlan = new NcpMonitorPlan();
			ncpMonitorPlan.setCardno(ncpPatient.getPersonInfo().getIdcard());
			ncpMonitorPlan.setCreateTime(new Date());
			ncpMonitorPlan.setPlanType("1");
			ncpMonitorPlan.setCreateStaffCode(user.getStaffCode());
			ncpMonitorPlan.setPid(new BigDecimal(ncpPatientid.longValue()));
			ncpMonitorPlan.setType(new BigDecimal(2));
			ncpMonitorPlan.setPlanDate(DateUtil.getAfterDay(ncpPatient.getDischargeDate(), 14));
			plans.add(ncpMonitorPlan);
			//新冠管理卡填写后生成第一条且只有一条，计划随访日期改为以出院时间+4个月
			NcpMonitorPlan sfPlan = new NcpMonitorPlan();
			sfPlan.setCardno(ncpPatient.getPersonInfo().getIdcard());
			sfPlan.setCreateTime(new Date());
			sfPlan.setCreateStaffCode(user.getStaffCode());
			sfPlan.setPid(new BigDecimal(ncpPatientid.longValue()));
			sfPlan.setType(new BigDecimal(3));
			sfPlan.setPlanType("1");//保存新冠管理卡生成的随访属于计划内随访  1:计划内 2:计划外
			//0193326: 【新冠肺炎健康管理】 新冠随访作出如下调整 随访计划生成时间改为以出院时间+4个月，已过期的随访都可以填写，未到计划时间的可以提前一个月录入
			String planDateStr = DateUtil.convertDateToString(DateUtil.getMonthsLater(ncpPatient.getDischargeDate(),4));
			sfPlan.setPlanDate(DateUtil.parseSimpleDate(planDateStr,"yyyy/MM/dd"));
			plans.add(sfPlan);
			return ncpMonitorPlanDao.batchInsert(plans);
		}
		
	}
	@Override
	public NcpPatient getNcpPatient(Criteria criteria) {
		criteria.add("isDelete","0");
		NcpPatient ncpPatient = ncpPatientDao.get(criteria);
		if (ObjectUtil.isNullOrEmpty(ncpPatient)) {
			log.warn("指定条件无法获取到关联的管理卡");
			return null;
		}
		Long personId = ncpPatient.getPersonId();
		if (ObjectUtil.isNullOrEmpty(personId)) {
			log.error("管理卡人员信息获取失败");
			return null;
		}
		PersonInfo personInfo = platformService.queryPersonalInfo(personId);
		ncpPatient.setPersonInfo(personInfo);
		return ncpPatient;
	}

	@Override
	public int deleteNcpPatient(NcpPatient ncpPatient) {
		// TODO Auto-generated method stub
		return ncpPatientDao.update(ncpPatient,"isDelete");
	}

	@Override
	public List<Map<String, Object>> exportNcpPatientList(Page page, Criteria criteria) {
		// TODO Auto-generated method stub
		return ncpPatientDao.exportNcpPatientList(page,criteria);
	}


	public static void main(String[] args) {

	}
}

