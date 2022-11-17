package com.founder.rhip.ehr.service;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.ServiceSyncTemp;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.clinic.ServiceSyncLog;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.entity.management.DmDiabeticFollowup;
import com.founder.rhip.ehr.entity.management.DmHypertensionFollowup;
import com.founder.rhip.ehr.entity.ta.TargetResultValue;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.basic.IServiceSyncTempDao;
import com.founder.rhip.ehr.repository.basic.IUserDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IHealthEvaluateAnomalyDao;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.management.IDMFollowupPlanDao;
import com.founder.rhip.ehr.repository.management.IDmDiabeticFollowupDao;
import com.founder.rhip.ehr.repository.management.IDmHypertensionFollowupDao;
import com.founder.rhip.ehr.repository.summary.IDrugHistoryDao;
import com.founder.rhip.ehr.repository.summary.IFamilyBedHistoryDao;
import com.founder.rhip.ehr.repository.summary.IHospitalizedHistoryDao;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ehr.service.sync.IServiceSyncLogService;
import com.founder.rhip.ehr.service.ta.ITargetService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("serviceSyncTempService")
@TaskBean(cron = "0 0 0/2 * * ?", description = "家医履约同步公卫")
public class ServiceSyncTempServiceImpl extends AbstractService implements
        IServiceSyncTempService, Task {

	@Resource(name = "serviceSyncTempDao")
	public IServiceSyncTempDao serviceSyncTempDao;
	
    @Resource(name="targetService")
    private ITargetService targetService;
    
	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;
	
	@Autowired
	private IOrganizationApp organizationApp;
	
	@Resource(name = "ehrUserDao")
	private IUserDao userDao;
	
    @Resource(name = "personalRecordManagmentService")
    private IPersonalRecordManagmentService personalRecordManagmentService;
    
	@Resource(name = "physiqueExaminationDao")
	private IPhysiqueExaminationDao physiqueExaminationDao;
    
	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;
	
	@Resource(name = "serviceSyncLogService")
	private IServiceSyncLogService serviceSyncLogService;
    
	@Resource(name = "elderlyPhyExaminationDao")
	private IElderlyPhyExaminationDao elderlyPhyExaminationDao;
	
	@Resource(name = "platformService")
	private IPlatformService platformService;
	
	@Resource(name = "healthEvaluateAnomalyDao")
	private IHealthEvaluateAnomalyDao healthEvaluateAnomalyDao;
	
	@Resource(name = "hospitalizedHistoryDao")
	private IHospitalizedHistoryDao hospitalizedHistoryDao;
	@Resource(name = "familyBedHistoryDao")
	private IFamilyBedHistoryDao familyBedHistoryDao;
	@Resource(name = "drugHistoryDao")
	private IDrugHistoryDao drugHistoryDao;
	@Resource(name = "vaccinationInfoDao")
	private IVaccinationInfoDao vaccinationInfoDao;
	
	@Resource(name = "dmHypertensionFollowupDao")
	private IDmHypertensionFollowupDao hypertensionFollowupDao;
	
	@Resource(name = "dmFollowupPlanDao")
	private IDMFollowupPlanDao followupPlanDao;
	
	@Resource(name = "dmDiabeticFollowupDao")
	private IDmDiabeticFollowupDao dmDiabeticFollowupDao;
	
	int num = 0;
	long start = System.currentTimeMillis();
	@Override
	public void run(Map<String, Object> data) {
		System.out.println("==========================================");
		System.out.println("========家医履约同步公卫=====开始=====");
		System.out.println("==========================================");
		
		//同步从家医同步过来的数据
		sync();
		
		//以下为处理历史数据部分
//		//给体检编号为空的个人体检新增体检编号
//		voluationExamCode();
//		//把19年的个人体检、慢病体检、老年人体检加入到中间表
//		saveFollowDi();
//		saveFollowHbp();
//		saveLog();
//		savePhyLog();
		
		System.out.println("==========================================");
		System.out.println("========家医履约同步公卫=====结束=====");
		System.out.println("==========================================");
	}

	private void saveFollowDi() {
		num = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<DmDiabeticFollowup>() {
			Criteria criteria = new Criteria("userName", "admin");
			User user = userDao.get(criteria);
			long id = 2528;
			@Override
			public PageList<DmDiabeticFollowup> get(Page page) {
				Criteria cri = new Criteria("id",OP.GT, id);
				Date beginDate = DateUtil.parseSimpleDate("2019/01/01", null);
				DateUtil.getCriteriaByDateRange(cri, "visitDate", beginDate, new Date());
				return dmDiabeticFollowupDao.getPageList(page, cri, new Order("ID"));
			}
				
			@Override
			public void run(List<DmDiabeticFollowup> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for(DmDiabeticFollowup di : list){
					id = di.getId();
					System.out.println(id);
					ServiceSyncLog log = serviceSyncLogService.getLog(id +"", di.getPersonId(), null);
					if(ObjectUtil.isNullOrEmpty(log)){
						DMFollowupPlan plan = followupPlanDao.get(new Criteria("followupId", di.getId()));
						if(ObjectUtil.isNotEmpty(plan)){
							String planType =  plan.getPlanType();
							if(!"3".equals(planType)){
								serviceSyncLogService.insertDi(di, user, planType);
								num ++;
								if(num%10==0){
									long end = System.currentTimeMillis();
									System.out.println("已处理糖尿病随访"+ num + ",id"+id+",用时：" + (end-start)/1000);
									start = System.currentTimeMillis();
								}
							}
						}
					}
				}
			}
		});
		
	}

	private void saveFollowHbp() {
		num = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<DmHypertensionFollowup>() {
			Criteria criteria = new Criteria("userName", "admin");
			User user = userDao.get(criteria);
			long id = 0;
			@Override
			public PageList<DmHypertensionFollowup> get(Page page) {
				Criteria cri = new Criteria("id",OP.GT, id);
				Date beginDate = DateUtil.parseSimpleDate("2019/01/01", null);
				DateUtil.getCriteriaByDateRange(cri, "visitDate", beginDate, new Date());
				return hypertensionFollowupDao.getPageList(page, cri, new Order("ID"));
			}
				
			@Override
			public void run(List<DmHypertensionFollowup> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for(DmHypertensionFollowup hbp : list){
					id = hbp.getId();
					ServiceSyncLog log = serviceSyncLogService.getLog(id +"", hbp.getPersonId(), null);
					if(ObjectUtil.isNullOrEmpty(log)){
						DMFollowupPlan plan =followupPlanDao.get(new Criteria("followupId", hbp.getId()));
						if(ObjectUtil.isNotEmpty(plan)){
							String planType =  plan.getPlanType();
							if(!"3".equals(planType)){
								serviceSyncLogService.insertHbp(hbp, user, planType);
								num ++;
								if(num%10==0){
									long end = System.currentTimeMillis();
									System.out.println("已处理高血压随访"+ num + ","+id+",用时：" + (end-start)/1000);
									start = System.currentTimeMillis();
								}
							}
						}
					}
				}
			}
		});
	}

	private void saveLog() {
		num = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<ElderlyPhyExamination>() {
			Criteria criteria = new Criteria("userName", "admin");
			User user = userDao.get(criteria);
			long id = 0;
			@Override
			public PageList<ElderlyPhyExamination> get(Page page) {
				Criteria cri = new Criteria("physicalExamCode",OP.IS, "not null");
				cri.add(new Criteria("isDelete", "0").add(LOP.OR,"isDelete",OP.IS, "null" ));
				cri.add("id",OP.GT, id);
				Date beginDate = DateUtil.parseSimpleDate("2019/01/01", null);
				DateUtil.getCriteriaByDateRange(cri, "examinationDate", beginDate, new Date());
				return elderlyPhyExaminationDao.getPageList(page, cri, new Order("ID"));
			}
				
			@Override
			public void run(List<ElderlyPhyExamination> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for(ElderlyPhyExamination ephy : list){
					id = ephy.getId();
					PhysiqueExamination phy = getPhyExamination(ephy);
					String type = "";
					if("31".equals(ephy.getPhysicalExamType())){
						type = EHRConstants.HM_EXAM_JSON_TYPE;
					}else if("39".equals(ephy.getPhysicalExamType())){
						type = EHRConstants.CDM_EXAM_JSON_TYPE;
					}
					if(StringUtil.isNotEmpty(type)){
						dd(phy, user, type);
					}
				}
			}
		});
	}

	private void savePhyLog() {
		num = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<PhysiqueExamination>() {
			Criteria criteria = new Criteria("userName", "admin");
			User user = userDao.get(criteria);
			long id = 0;
			@Override
			public PageList<PhysiqueExamination> get(Page page) {
				Criteria cri = new Criteria("physicalExamCode",OP.IS, "not null");
				cri.add("id",OP.GT, id);
				Date beginDate = DateUtil.parseSimpleDate("2019/01/01", null);
				DateUtil.getCriteriaByDateRange(cri, "examinationDate", beginDate, new Date());
				return physiqueExaminationDao.getPageList(page, cri, new Order("ID"));
			}
				
			@Override
			public void run(List<PhysiqueExamination> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for(PhysiqueExamination phy : list){
					id = phy.getId();
					dd(phy, user, EHRConstants.EXAM_JSON_TYPE);
				}
			}
		});
	}

	private void dd(PhysiqueExamination phy, User user, String type){
		if(ObjectUtil.isNotEmpty(phy.getPersonId()) && ObjectUtil.isNotEmpty(phy.getEhrId())&& ObjectUtil.isNotEmpty(phy.getPhysicalExamCode())){
			
			ServiceSyncLog log = serviceSyncLogService.getLog(phy.getPhysicalExamCode(), phy.getPersonId(), type);
			if(ObjectUtil.isNullOrEmpty(log)){
				
				PersonalPhyExamDTO dto = null;
				if(type.equals(EHRConstants.EXAM_JSON_TYPE)){
					dto = personalRecordManagmentService.getPersonalPhysical(new Criteria("id", phy.getPersonId()), phy.getEhrId());
				}else{
					dto = new PersonalPhyExamDTO();
					Criteria anomalyCrt = new Criteria("ehrId", phy.getEhrId());
					Criteria crt = new Criteria("isDelete", OP.IS, null).add(LOP.OR, "isDelete", OP.NE, 1);
					anomalyCrt.add(crt);
					Criteria ca = new Criteria("personId", phy.getPersonId()).add("ehrId",phy.getEhrId());
					
					dto.setHealthEvaluateAnomalyList(healthEvaluateAnomalyDao.getList(anomalyCrt, new Order("SORT")));
					dto.setVaccinationInfoList(vaccinationInfoDao.getList(ca));
					dto.setDrugHistoryList(drugHistoryDao.getList(ca));
					dto.setHospitalizedHistoryList(hospitalizedHistoryDao.getList(ca));;
					dto.setFamilyBedHistoryList(familyBedHistoryDao.getList(ca));
					dto.setPersonInfo(platformService.queryPersonalInfo(phy.getPersonId()));
					dto.setPhysiqueExamination(phy);
				}
				
				if(ObjectUtil.isNotEmpty(dto)){
					System.out.println(type + "----"+ phy.getId() + "_____" + dto.getPersonInfo().getIdcard());
					serviceSyncLogService.insertExam(dto, user, null, type, null);
					num ++;
					if(num%10==0){
						long end = System.currentTimeMillis();
						System.out.println("已处理"+type +":"+ num + ",用时：" + (end-start)/1000);
						start = System.currentTimeMillis();
					}
				}
			}
		}
	}
	
	private void voluationExamCode() {
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<PhysiqueExamination>() {
			int num = 0;
			@Override
			public PageList<PhysiqueExamination> get(Page page) {
				Criteria cri = new Criteria("physicalExamCode",OP.IS, "null");
				cri.add("examinationOrganCode",OP.IS, "not null");
				return physiqueExaminationDao.getPageList(page, cri);
			}
				
			@Override
			public void run(List<PhysiqueExamination> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for(PhysiqueExamination phy : list){
					if(StringUtil.isNullOrEmpty(phy.getPhysicalExamCode()) && StringUtil.isNotEmpty(phy.getExaminationOrganCode())
							&& !"ZX002".equals(phy.getExaminationOrganCode()) && !"Z002".equals(phy.getExaminationOrganCode()) && !"Z001".equals(phy.getExaminationOrganCode())){
						String examCode = EHRNumberService.getSerialNum(phy.getExaminationOrganCode(), EHRConstants.EXAM_NUMBER_TYPE);
						if(StringUtil.isNotEmpty(examCode)){
							phy.setPhysicalExamCode(examCode);
							physiqueExaminationDao.update(phy, "physicalExamCode");
							
							System.out.println("为体检["+phy.getName()+"]["+phy.getEhrId()+"]生成体检编号"+ examCode);
							num ++;
							if(num%10==0){
								System.out.println("已处理"+ num);
							}
						} 
					}
				}
			}
		});
	}

	@Override
	public void sync() {
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<ServiceSyncTemp>() {

			@Override
			public PageList<ServiceSyncTemp> get(Page page) {
				return serviceSyncTempDao.getPageList(page, new Criteria("isDataSync", 0).add("createUser", OP.IS, "not null"));
			}

			@Override
			public void run(List<ServiceSyncTemp> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (ServiceSyncTemp temp : list) {
					if (ObjectUtil.isNullOrEmpty(temp)) {
						continue;
					}
					
					analyse(temp);
				}
			}

			@Transactional
			private void analyse(ServiceSyncTemp temp) {
				Criteria criteria = new Criteria("userName", temp.getCreateUser());
				User user = userDao.get(criteria);
				JSONObject sfObject = JSONObject.fromObject(temp.getJsonData());
				PhysiqueExamination phy = (PhysiqueExamination) JSONObject.toBean(sfObject, PhysiqueExamination.class);
				String examCode = null;
				if(temp.getJsonType()==1 ){//个人体检
					PersonInfo personInfo = personInfoDao.get(temp.getPersonId());
					Organization inputOrg = organizationApp.queryOrgan(temp.getOrganCode());
					phy.setRecordId(temp.getRecordId());
					phy.setExaminationOrganCode(temp.getOrganCode());
					phy.setExaminationDate(temp.getServiceTime());
					phy.setPhysicalExamCode(temp.getExamCode());
					phy.setPersonId(temp.getPersonId());
					examCode = personalRecordManagmentService.savePhyExamFromElderly(user, inputOrg, personInfo, phy, null, null,null,null,null, new String[]{});
					
				}else if(temp.getJsonType()==2 ){//血压
					TargetResultValue resultValue = new TargetResultValue();
					if(StringUtil.isNotEmpty(temp.getExamCode()) && temp.getExamCode().length() < 13){
						resultValue.setId(Long.parseLong(temp.getExamCode()));
					}
					resultValue.setPersonId(temp.getPersonId());
					resultValue.setCreateDate(temp.getServiceTime());
					resultValue.setCreateOrganCode(temp.getOrganCode());
					resultValue.setCreateUserCode(user.getUserCode());
			        resultValue.setValueA(BigDecimal.valueOf(phy.getLeftSbp()));
			        resultValue.setValueB(BigDecimal.valueOf(phy.getLeftDbp()));
					resultValue.setType("家医履约血压");
			           
					Set<String> properties = new HashSet<>(3);
					properties.add("valueA");
					properties.add("valueB");
					properties.add("createDate");
					Long id = targetService.addOrUpdateTargetResultValue(resultValue, temp.getOrganCode(),user.getUserCode(), properties);
					examCode = id.toString();
				}else if(temp.getJsonType()==3 && ObjectUtil.isNotEmpty(phy.getFpgMmol())){//血糖
					TargetResultValue resultValue = new TargetResultValue();
					if(StringUtil.isNotEmpty(temp.getExamCode()) && temp.getExamCode().length() < 13){
						resultValue.setId(Long.parseLong(temp.getExamCode()));
					}
					resultValue.setPersonId(temp.getPersonId());
					resultValue.setValueC(phy.getFpgMmol());
					resultValue.setCreateDate(temp.getServiceTime());
					resultValue.setCreateOrganCode(temp.getOrganCode());
					resultValue.setCreateUserCode(user.getUserCode());
					resultValue.setType("家医履约血糖");
					
					Set<String> properties = new HashSet<>(2);
					properties.add("valueC");
					properties.add("createDate");
					Long id = targetService.addOrUpdateTargetResultValue(resultValue, temp.getOrganCode(),user.getUserCode(), properties);
					examCode = id.toString();
				}
				temp.setExamCode(examCode);
				temp.setIsDataSync(1L);
				serviceSyncTempDao.update(temp, "isDataSync", "examCode");				
			}
		});
	}
	
	private PhysiqueExamination getPhyExamination(ElderlyPhyExamination elderlyPhyExamination) {
		PhysiqueExamination result = new PhysiqueExamination();
		ConvertUtils.register(new DateConverter(null), java.util.Date.class);
		ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
        ConvertUtils.register(new IntegerConverter(null),Integer.class);
		try {
			BeanUtils.copyProperties(result, elderlyPhyExamination);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
}
