package com.founder.rhip.cdm.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.management.DmDiseaseInfo;
import com.founder.rhip.ehr.entity.summary.DrugHistory;
import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.ehr.entity.ta.TargetResultValue;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IHealthEvaluateAnomalyDao;
import com.founder.rhip.ehr.repository.clinic.IHealthExaminationDao;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.management.IDmDiseaseInfoDao;
import com.founder.rhip.ehr.repository.summary.IDrugHistoryDao;
import com.founder.rhip.ehr.repository.summary.IFamilyBedHistoryDao;
import com.founder.rhip.ehr.repository.summary.IHospitalizedHistoryDao;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.ehr.service.sync.IServiceSyncLogService;
import com.founder.rhip.ehr.service.ta.ITargetService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 慢病体检
 *
 * @author liuk
 */
@Service("cdmPhyExaminationService")
public class PhyExaminationServiceImpl extends AbstractService implements IPhyExaminationService {

  /**
   * The Elderly phy examination dao.
   */
  @Resource(name = "elderlyPhyExaminationDao")
  private IElderlyPhyExaminationDao elderlyPhyExaminationDao;

  /**
   * The Health evaluate anomaly dao.
   */
  @Resource(name = "healthEvaluateAnomalyDao")
  private IHealthEvaluateAnomalyDao healthEvaluateAnomalyDao;

  /**
   * The Health examination dao.
   */
  @Resource(name = "healthExaminationDao")
  private IHealthExaminationDao healthExaminationDao;

  /**
   * The Ehr health event dao.
   */
  @Resource(name = "ehrHealthEventDao")
  private IEHRHealthEventDao ehrHealthEventDao;

  /**
   * The Disease info dao.
   */
  @Resource(name = "dmDiseaseInfoDao")
  private IDmDiseaseInfoDao diseaseInfoDao;

  /**
   * The Dictionary app.
   */
  @Resource(name = "dictionaryApp")
  private IDictionaryApp dictionaryApp;

  @Resource(name="targetService")
  private ITargetService targetService;

  @Resource(name = "hospitalizedHistoryDao")
  private IHospitalizedHistoryDao hospitalizedHistoryDao;

  @Resource(name = "familyBedHistoryDao")
  IFamilyBedHistoryDao familyBedHistoryDao ;

  @Resource(name = "drugHistoryDao")
  private IDrugHistoryDao drugHistoryDao;

  @Resource(name = "vaccinationInfoDao")
  private IVaccinationInfoDao vaccinationInfoDao;
  
	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;
	
	@Resource(name = "serviceSyncLogService")
	private IServiceSyncLogService serviceSyncLogService;
	
  @Override
  public List<ElderlyPhyExamination> getPhyExaminations(Criteria criteria, Page page) {
    String[] requiredProperties = new String[] {};
    Order order = new Order("inputDate");
    PageList<ElderlyPhyExamination> list = elderlyPhyExaminationDao.getPageList(page, criteria, order, requiredProperties);
    List<ElderlyPhyExamination> result = null;
    if (null != list) {
      result = list.getList();
    }
    if (null == result) {
      result = Collections.emptyList();
    }
    return result;
  }

  @Override
  public List<HealthExamination> getHealthExaminations(Criteria criteria, Page page) {
    String[] requiredProperties = new String[] {};
    Order order = new Order("EXAMINATION_DATE", false);
    PageList<HealthExamination> list = healthExaminationDao.getPageList(page, criteria, order, requiredProperties);
    List<HealthExamination> result = null;
    if (null != list) {
      result = list.getList();
    }
    if (null == result) {
      result = Collections.emptyList();
    }
    return result;
  }

  @Override
  public ElderlyPhyExamination add(PersonInfo personInfo, Organization organization) {
    // 获取最近一次体检
//    Criteria criteria = new Criteria("personId", personInfo.getId());
//    criteria.add("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
//    HealthExamination examination = healthExaminationDao.getLastHealthExamination(criteria);
//    ElderlyPhyExamination elderlyPhyExamination = null;
//    if (null != examination) {
//      Criteria exCriteria = new Criteria("personId", personInfo.getId());
//      exCriteria.add("ehrId", examination.getEhrId());
//      elderlyPhyExamination = getPhyExamination(exCriteria);
//    }
    // 如果存在,则使用最新的,否则new
//    if (null == elderlyPhyExamination) {
//      elderlyPhyExamination = new ElderlyPhyExamination();
//    } else {
//      elderlyPhyExamination.setId(null);
//    }

	  //0145128: 【慢病健康管理】慢病体检的新增页面，不应该带出上次的体检内容
     ElderlyPhyExamination elderlyPhyExamination = new ElderlyPhyExamination();
    // 覆盖人员相关信息
    elderlyPhyExamination.setPersonId(personInfo.getId());
    elderlyPhyExamination.setName(personInfo.getName());
    elderlyPhyExamination.setEhrId(null);
    if (null == elderlyPhyExamination.getExaminationDate()) {
      elderlyPhyExamination.setExaminationDate(new Date());
    }
    // 默认当前机构为体检机构
    if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getExaminationOrganCode())) {
      elderlyPhyExamination.setExaminationOrganCode(organization.getOrganCode());
    }

    // 获取慢病信息
    setDefaultValueUseDiseainfo(elderlyPhyExamination);
    return elderlyPhyExamination;
  }

  /**
   * 根据管理卡获取默认值
   *
   * @param elderlyPhyExamination
   *            the elderly phy examination
   */
  private void setDefaultValueUseDiseainfo(ElderlyPhyExamination elderlyPhyExamination) {
    String[] needProperties = new String[] { "hbpType", "diType", "hbpFlag", "diFlag", "hbpSbp", "hbpDbp" };
    DmDiseaseInfo diseaseInfo = diseaseInfoDao.get(new Criteria("personId", elderlyPhyExamination.getPersonId()), needProperties);
    if (null != diseaseInfo) {
      if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getHbpFlag())) {
        elderlyPhyExamination.setHypertensionFlag("1");
        String hbpType = diseaseInfo.getHbpType();
        String name = getValueByDict("DMD00006", hbpType);
        elderlyPhyExamination.setHypertensionDesc(name);
      } else {
        elderlyPhyExamination.setHypertensionFlag("0");
      }

      if (EHRConstants.DM_MANAGED_FLAG.equals(diseaseInfo.getDiFlag())) {
        elderlyPhyExamination.setDiabetesMellitusFlag("1");
        String diType = diseaseInfo.getDiType();
        String name = getValueByDict("DMD00007", diType);
        elderlyPhyExamination.setDiabetesMellituDesc(name);
      } else {
        elderlyPhyExamination.setDiabetesMellitusFlag("0");
      }

      // 修改管理卡血压填到既往最高
      if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getPastHighestSbp())) {
        elderlyPhyExamination.setPastHighestSbp(diseaseInfo.getHbpSbp());
      }
      if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getPastHighesDbp())) {
        elderlyPhyExamination.setPastHighesDbp(diseaseInfo.getHbpDbp());
      }

    }
  }

  /**
   * Gets value by dict.
   *
   * @param type
   *            the type
   * @param code
   *            the code
   * @return the value by dict
   */
  private String getValueByDict(String type, String code) {
    String name = dictionaryApp.queryDicItemName(type, code);
    return name;
  }

  @Override
  @Transactional
  public void updatePhyExamination(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination ,Organization organization,User user) {
    Assert.notNull(personInfo, "体检人员信息不能为空");
    Assert.notNull(elderlyPhyExamination, "体检不能为空");

    // 如果没有体检日志,则设置为当前日期
    if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getExaminationDate())) {
      elderlyPhyExamination.setExaminationDate(new Date());
    }

    // 更新体检数据
    elderlyPhyExamination.setName(personInfo.getName());
    elderlyPhyExamination.setGender(personInfo.getGender());
    elderlyPhyExamination.setBirthday(personInfo.getBirthday());
    elderlyPhyExamination.setAge(DateUtil.getAge(personInfo.getBirthday(), elderlyPhyExamination.getExaminationDate()));
    // 如果没有体检编号,则自动生成
    if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getPhysicalExamCode())) {
	   String examCode = EHRNumberService.getSerialNum(elderlyPhyExamination.getExaminationOrganCode(), EHRConstants.EXAM_NUMBER_TYPE);
       elderlyPhyExamination.setPhysicalExamCode(examCode);
    }
    // 更新体检信息
    Criteria criteria = new Criteria("personId", elderlyPhyExamination.getPersonId());
    String ehrId = elderlyPhyExamination.getEhrId();
    criteria.add("ehrId", ehrId);
    HealthExamination examination = healthExaminationDao.get(criteria);
    Assert.notNull(examination, "无法获取体检信息");
    copyHealthExamination(elderlyPhyExamination, personInfo, examination);
    healthExaminationDao.update(examination);

    elderlyPhyExamination.setPhysicalExamType(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
    elderlyPhyExaminationDao.update(elderlyPhyExamination);
    //log.error("====updatePhyExamination 209 " + (System.currentTimeMillis() - end));
    //end = System.currentTimeMillis();
    // 删除关联的异常数据
    healthEvaluateAnomalyDao.delete(new Criteria("ehrId", ehrId));
    Criteria ca = new Criteria("personId", personInfo.getId()).add("ehrId", ehrId);
			/* 删除关联表 */
    familyBedHistoryDao.delete(ca);
    vaccinationInfoDao.delete(ca);
    drugHistoryDao.delete(ca);
    hospitalizedHistoryDao.delete(ca);
    vaccinationInfoDao.delete(ca);

    // 重新插入新的异常数据
    addHealthEvaluateAnomalies(elderlyPhyExamination, ehrId);
    addHospitalizedHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addFamilyBedHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addDrugHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addVaccinationInfo(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    elderlyPhyExaminationDao.update(elderlyPhyExamination);


    // 更新事件体检机构和体检日期
    updateEhrHealthEvent(personInfo, elderlyPhyExamination);

    //log.error("====updatePhyExamination 216 " + (System.currentTimeMillis() - end));
    //end = System.currentTimeMillis();
    // 更新管理卡相关信息
    updateExamYear(elderlyPhyExamination.getPersonId());
    //log.error("====updatePhyExamination 220 " + (System.currentTimeMillis() - end));

    //指标
    tryAddTargetValue(elderlyPhyExamination,organization,user);
  }

  @Override
  @Transactional
  public String savePhyExamination(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination,Organization organization,User user) {
    //Long end = System.currentTimeMillis();
    Assert.notNull(personInfo, "体检人员信息不能为空");
    Assert.notNull(elderlyPhyExamination, "体检不能为空");

    // 如果没有体检编号,则自动生成
    if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getPhysicalExamCode())) {
	   String examCode = EHRNumberService.getSerialNum(elderlyPhyExamination.getExaminationOrganCode(), EHRConstants.EXAM_NUMBER_TYPE);
       elderlyPhyExamination.setPhysicalExamCode(examCode);
    }
    // 如果没有体检日志,则设置为当前日期
    if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getExaminationDate())) {
      elderlyPhyExamination.setExaminationDate(new Date());
    }
    // 计算年龄
    elderlyPhyExamination.setAge(DateUtil.getAge(personInfo.getBirthday(), elderlyPhyExamination.getExaminationDate()));

    // 体检事件
    EHRHealthEvent event = createEhrHealthEvent(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode(), "慢病体检", personInfo, elderlyPhyExamination);
    //log.error("====savePhyExamination 229 " + (System.currentTimeMillis() - end));

    // 体检信息
    HealthExamination examination = new HealthExamination();
    copyHealthExamination(elderlyPhyExamination, personInfo, examination);
    //end = System.currentTimeMillis();
    String ehrId = event.getEhrId();
    examination.setEhrId(ehrId);
    examination.setPhysicalExamType(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
    healthExaminationDao.insert(examination);
    //log.error("====savePhyExamination 243 " + (System.currentTimeMillis() - end));
    // 体检数据
    elderlyPhyExamination.setEhrId(ehrId);
    elderlyPhyExamination.setName(personInfo.getName());
    elderlyPhyExamination.setGender(personInfo.getGender());
    elderlyPhyExamination.setBirthday(personInfo.getBirthday());
    //end = System.currentTimeMillis();
    //log.error("====savePhyExamination 255 " + (System.currentTimeMillis() - end));
    //end = System.currentTimeMillis();
    elderlyPhyExamination.setPhysicalExamType(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
    elderlyPhyExaminationDao.insert(elderlyPhyExamination);
    addHealthEvaluateAnomalies(elderlyPhyExamination, ehrId);
    addHospitalizedHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addFamilyBedHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addDrugHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addVaccinationInfo(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    //log.error("====savePhyExamination 259 " + (System.currentTimeMillis() - end));

    // 更新管理卡相关信息
    updateExamYear(elderlyPhyExamination.getPersonId());

    //指标
    tryAddTargetValue(elderlyPhyExamination,organization,user);
    return elderlyPhyExamination.getPhysicalExamCode();
  }


  @Override
  @Transactional
  public HealthExamination deleteElderlyPhyExamination(Long personId, String ehrId, String examCode) {
    Assert.notNull(personId, "人员Id不能为空");
//    Assert.notNull(ehrId, "事件不能为空");
    
    Criteria criteria = new Criteria("personId", personId);
    HealthExamination examination;
    if(StringUtil.isNotEmpty(ehrId)){
    	criteria.add("ehrId", ehrId);
    	ehrHealthEventDao.delete(criteria);    
    }else if(StringUtil.isNotEmpty(examCode)){
    	criteria.add("physicalExamCode", examCode);
    }else{
    	return null;
    }
    	
    criteria.add("physicalExamType", EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
	examination = healthExaminationDao.get(criteria, "id","ehrId","physicalExamCode","examinationDate");
	if(ObjectUtil.isNotEmpty(examination)){
		ehrHealthEventDao.delete(new Criteria("personId", personId).add("ehrId", examination.getEhrId()));    

		healthExaminationDao.delete(examination.getId());
		//修改为逻辑删除
		elderlyPhyExaminationDao.update(new Parameters("isDelete",EHRConstants.DELETE_FLG_1),criteria);
		updateExamYear(personId);
    }
    return examination;
    
  }


  /**
   * 更新管理卡中体检年份
   *
   * @param personId
   *            the person id
   */
  private void updateExamYear(Long personId) {
    Date currentDate = new Date();
    final int currentYear = getField(currentDate, Calendar.YEAR);

    // 修改为今年之前,检查是否今年存在体检
    Criteria more = new Criteria("personId", personId);
    Calendar calendar = Calendar.getInstance();
    calendar.set(currentYear + 1, 0, 0, 0, 0, 0);
    more.add("examinationDate", OP.LT, calendar.getTime());
    more.add("physicalExamType", EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());

    // 获取最近一次体检
    HealthExamination examination = healthExaminationDao.getMaxExamDate(more);
    Integer lastYear = null;
    if (null != examination && null != examination.getExaminationDate()) {
      lastYear = getField(examination.getExaminationDate(), Calendar.YEAR);
    }

    // 更新体检年份
    Criteria updateExamYear = new Criteria("personId", personId);
    Parameters parameters = new Parameters("lastPhyExaminationYear", lastYear);
    diseaseInfoDao.update(parameters, updateExamYear);

  }

  /**
   * 设置体检信息表要保存的信息
   *
   * @param elderlyPhyExamination
   *            the elderly phy examination
   * @param personInfo
   *            the person info
   * @param examination
   *            the examination
   */
  private void copyHealthExamination(ElderlyPhyExamination elderlyPhyExamination, PersonInfo personInfo, HealthExamination examination) {
    examination.setAge(elderlyPhyExamination.getAge());
    examination.setBirthday(personInfo.getBirthday());
    examination.setExaminationDate(elderlyPhyExamination.getExaminationDate());
    examination.setGender(personInfo.getGender());
    examination.setName(personInfo.getName());
    examination.setPersonId(personInfo.getId());
    examination.setHospitalCode(elderlyPhyExamination.getExaminationOrganCode());
    examination.setManaDoctorId(elderlyPhyExamination.getManaDoctorId());
    examination.setPhysicalExamCode(elderlyPhyExamination.getPhysicalExamCode());
  }

  @Override
  public ElderlyPhyExamination getPhyExamination(Criteria criteria) {
    String[] requiredProperties = new String[] {};
    ElderlyPhyExamination result = elderlyPhyExaminationDao.get(criteria, requiredProperties);
    // 有可能不存在
    if (null != result) {
      List<HealthEvaluateAnomaly> healthEvaluateAnomalies = healthEvaluateAnomalyDao.getList(new Criteria("ehrId", result.getEhrId()), new Order("SORT"));
      if (null != healthEvaluateAnomalies && healthEvaluateAnomalies.size() > 0) {
			if (healthEvaluateAnomalies.size() < 4) {
				List<Integer> list = new ArrayList<>();
				for(HealthEvaluateAnomaly hea :healthEvaluateAnomalies){
					list.add(hea.getSort());
				}
				for (int i = 1; i < 5; i++){
					if(!list.contains(i)){
						HealthEvaluateAnomaly hea = new HealthEvaluateAnomaly();
						hea.setSort(i);
						healthEvaluateAnomalies.add(hea);
					}
				}
				healthEvaluateAnomalies = getSortList(healthEvaluateAnomalies);
			}
			result.setHealthEvaluateAnomalies(healthEvaluateAnomalies);
			result.setHealthEvaluateAnomalyFlag("1");
		} else {
			result.setHealthEvaluateAnomalyFlag("0");
		}
    }
    return result;
  }

	private List<HealthEvaluateAnomaly> getSortList(List<HealthEvaluateAnomaly> list){
        Collections.sort(list, new Comparator<HealthEvaluateAnomaly>() {
            @Override
            public int compare(HealthEvaluateAnomaly h1, HealthEvaluateAnomaly h2) {
            	if(ObjectUtil.isNotEmpty(h1.getSort()) && ObjectUtil.isNotEmpty(h2.getSort()))
            		return h1.getSort() - h2.getSort();
            	return 0;
            }
        });
        return list;
    }
	
  /**
   * Delete elderly phy examination 2.
   *
   * @param personId
   *            the person id
   * @param ehrId
   *            the ehr id
   */
  @Transactional
  public void deleteElderlyPhyExamination2(Long personId, String ehrId) {
    Assert.notNull(personId, "人员Id不能为空");
    Assert.notNull(ehrId, "事件不能为空");
    Criteria criteria = new Criteria("personId", personId);
    criteria.add("ehrId", ehrId);
    ehrHealthEventDao.delete(criteria);
    criteria.add("physicalExamType", EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
    HealthExamination examination = healthExaminationDao.get(criteria, "id", "examinationDate");
    if (null != examination) {
      Date examDate = examination.getExaminationDate();
      if (null != examDate) {
        int currentYear = DateUtil.getCurrentYear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(examDate);
        int examYear = calendar.get(Calendar.YEAR);
        if (examYear < currentYear || examYear > currentYear) {
          // 删除今年之前的体检,不予更新体检标志
          // 今年之后体检逻辑上不会出现,若存在直接删除
        } else {
          // 删除今年的体检,检查是否今年存在多条体检
          Criteria more = new Criteria("personId", personId);
          calendar.set(examYear, 0, 0, 0, 0, 0);
          more.add("examinationDate", OP.GE, calendar.getTime());
          more.add("physicalExamType", EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
          Integer count = healthExaminationDao.getCount(more, "id", Integer.class);
          if (null != count && count > 1) {
            // 今年存在多个体检,直接删除
          } else {
            // 设置今年未体检
            Parameters parameters = new Parameters("lastPhyExaminationYear", null);
            Criteria updateExamYear = new Criteria("personId", personId);
            diseaseInfoDao.update(parameters, updateExamYear);
          }
        }
      }
      healthExaminationDao.delete(examination.getId());
      elderlyPhyExaminationDao.delete(criteria);
    }
  }

  /**
   * 更新管理卡中体检年份
   *
   * @param oldElderlyPhyExamination
   *            the old elderly phy examination
   */
  private void addLastExamYear(ElderlyPhyExamination oldElderlyPhyExamination) {
    final Long personId = oldElderlyPhyExamination.getPersonId();
    Date date = oldElderlyPhyExamination.getExaminationDate();
    Date currentDate = new Date();
    final int examYear = getField(date, Calendar.YEAR);
    final int currentYear = getField(currentDate, Calendar.YEAR);
    // 当把这个的全部体检日期修改为今年之前的情况 暂不考虑
    if (currentYear <= examYear) {
      // new Thread(new Runnable() {
      // public void run() {
      // try {
      Parameters parameters = new Parameters("lastPhyExaminationYear", examYear);
      Criteria criteria = new Criteria("personId", personId);
      diseaseInfoDao.update(parameters, criteria);
      // } catch (Exception e) {
      // log.error("更新体检年份失败", e);
      // }
      // }
      // }).start();
    }
  }

  /**
   * 更新管理卡中体检年份
   *
   * @param oldElderlyPhyExamination
   *            the old elderly phy examination
   */
  private void updateLastExamYear(ElderlyPhyExamination oldElderlyPhyExamination) {
    final Long personId = oldElderlyPhyExamination.getPersonId();
    Date date = oldElderlyPhyExamination.getExaminationDate();
    Date currentDate = new Date();
    final int examYear = getField(date, Calendar.YEAR);
    final int currentYear = getField(currentDate, Calendar.YEAR);
    if (currentYear < examYear) {
      // 已经限制,无法超过当年
    } else if (currentYear == examYear) {
      // 如果是当年直接更新
      Parameters parameters = new Parameters("lastPhyExaminationYear", examYear);
      Criteria criteria = new Criteria("personId", personId);
      diseaseInfoDao.update(parameters, criteria);
    } else {
      // 修改为今年之前,检查是否今年存在体检
      Criteria more = new Criteria("personId", personId);
      Calendar calendar = Calendar.getInstance();
      calendar.set(currentYear, 0, 0, 0, 0, 0);
      more.add("examinationDate", OP.GE, calendar.getTime());
      more.add("physicalExamType", EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
      Integer count = healthExaminationDao.getCount(more, "id", Integer.class);
      Criteria updateExamYear = new Criteria("personId", personId);
      if (null != count && count > 1) {
        // 今年存在多个体检
        Parameters parameters = new Parameters("lastPhyExaminationYear", currentYear);
        diseaseInfoDao.update(parameters, updateExamYear);
      } else {
        // 设置今年未体检
        Parameters parameters = new Parameters("lastPhyExaminationYear", null);
        diseaseInfoDao.update(parameters, updateExamYear);
      }
    }
  }



  /**
   * 创建或更新卫生事件
   *
   * @param ehrType
   *            the ehr type
   * @param ehrName
   *            the ehr name
   * @param personInfo
   *            the person info
   * @param elderlyPhyExamination
   *            the elderly phy examination
   * @return eHR health event
   */
  private EHRHealthEvent createEhrHealthEvent(String ehrType, String ehrName, PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination) {
    EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
    ehrHealthEvent.setUpdateDate(new Date());
    Long personId = personInfo.getId();
    if (ehrType != null && ehrType.trim().length() > 0 && personId != null) {
      ehrHealthEvent.setEhrType(ehrType);
      ehrHealthEvent.setEhrName(ehrName);
      ehrHealthEvent.setName(personInfo.getName());
      ehrHealthEvent.setAge(elderlyPhyExamination.getAge());
      ehrHealthEvent.setPersonId(personId);
      ehrHealthEvent.setCreateDate(new Date());
      ehrHealthEvent.setClinicOrganCode(elderlyPhyExamination.getExaminationOrganCode());
      ehrHealthEvent.setClinicDate(elderlyPhyExamination.getExaminationDate());
      Number healthEventId = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID", null);
      Assert.notNull(healthEventId, "事件生成失败");
      ehrHealthEvent.setId(healthEventId.longValue());
      ehrHealthEvent.setEhrId(String.valueOf(healthEventId));
      ehrHealthEventDao.update(ehrHealthEvent, "ehrId");
    }
    return ehrHealthEvent;
  }

  /**
   * Update ehr health event.
   *
   * @param personInfo
   *            the person info
   * @param elderlyPhyExamination
   *            the elderly phy examination
   */
  private void updateEhrHealthEvent(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination) {
    // 更新体检信息
    Criteria criteria = new Criteria("personId", elderlyPhyExamination.getPersonId());
    String ehrId = elderlyPhyExamination.getEhrId();
    criteria.add("ehrId", ehrId);
    EHRHealthEvent ehrHealthEvent = ehrHealthEventDao.get(criteria);
    if (null != ehrHealthEvent) {
      ehrHealthEvent.setAge(elderlyPhyExamination.getAge());
      ehrHealthEvent.setName(personInfo.getName());
      ehrHealthEvent.setClinicOrganCode(elderlyPhyExamination.getExaminationOrganCode());
      ehrHealthEvent.setClinicDate(elderlyPhyExamination.getExaminationDate());
      ehrHealthEvent.setUpdateDate(new Date());
      ehrHealthEventDao.update(ehrHealthEvent);
    }
  }

  /**
   * 增加异常信息
   *
   * @param elderlyPhyExamination
   *            the elderly phy examination
   * @param ehrId
   *            the ehr id
   */
  private void addHealthEvaluateAnomalies(ElderlyPhyExamination elderlyPhyExamination, String ehrId) {
    if ("1".equals(elderlyPhyExamination.getHealthEvaluateAnomalyFlag())) {
      List<HealthEvaluateAnomaly> healthEvaluateAnomalies = elderlyPhyExamination.getHealthEvaluateAnomalies();
      if (ObjectUtil.isNotEmpty(healthEvaluateAnomalies)) {
        List<HealthEvaluateAnomaly> toUpdates = new ArrayList<>(healthEvaluateAnomalies.size());
        for (HealthEvaluateAnomaly healthEvaluateAnomaly : healthEvaluateAnomalies) {
          if (null != healthEvaluateAnomaly && StringUtil.isNotEmpty(healthEvaluateAnomaly.getHealthEvaluateAnomalyDesc())) {
            healthEvaluateAnomaly.setEhrId(ehrId);
            toUpdates.add(healthEvaluateAnomaly);
          }
        }
        if (ObjectUtil.isNotEmpty(toUpdates)) {
          healthEvaluateAnomalyDao.batchInsert(toUpdates);
        }
      }
    }
  }

  private void addHospitalizedHistoryList(ElderlyPhyExamination elderlyPhyExamination,Long personId, String ehrId) {
    if (ObjectUtil.isNotEmpty(elderlyPhyExamination.getHospitalizedHistoryList())) {
      List<HospitalizedHistory> HospitalizedHistoryList = elderlyPhyExamination.getHospitalizedHistoryList();
      if (ObjectUtil.isNotEmpty(HospitalizedHistoryList)) {
        List<HospitalizedHistory> toUpdates = new ArrayList<>(HospitalizedHistoryList.size());
        for (HospitalizedHistory HospitalizedHistory : HospitalizedHistoryList) {
          if (null != HospitalizedHistory) {
            HospitalizedHistory.setEhrId(ehrId);
            HospitalizedHistory.setPersonId(personId);
            toUpdates.add(HospitalizedHistory);
          }
        }
        if (ObjectUtil.isNotEmpty(toUpdates)) {
          for (int i = 0; i < toUpdates.size(); i++) {
            if(ObjectUtil.isNullOrEmpty(toUpdates.get(i).getInhosReason())||ObjectUtil.isNullOrEmpty(toUpdates.get(i))){
              toUpdates.remove(i);
              i--;
            }
          }
          hospitalizedHistoryDao.batchInsert(toUpdates);
        }
      }
    }
  }

  private void addFamilyBedHistoryList(ElderlyPhyExamination elderlyPhyExamination,Long personId, String ehrId) {
    if (ObjectUtil.isNotEmpty(elderlyPhyExamination.getFamilyBedHistoryList())) {
      List<FamilyBedHistory> FamilyBedHistoryList = elderlyPhyExamination.getFamilyBedHistoryList();
      if (ObjectUtil.isNotEmpty(FamilyBedHistoryList)) {
        List<FamilyBedHistory> toUpdates = new ArrayList<>(FamilyBedHistoryList.size());
        for (FamilyBedHistory FamilyBedHistory : FamilyBedHistoryList) {
          if (null != FamilyBedHistory) {
            FamilyBedHistory.setEhrId(ehrId);
            FamilyBedHistory.setPersonId(personId);
            toUpdates.add(FamilyBedHistory);
          }
        }
        if (ObjectUtil.isNotEmpty(toUpdates)) {
          for (int i = 0; i < toUpdates.size(); i++) {
            if(ObjectUtil.isNullOrEmpty(toUpdates.get(i).getBuiltBedReason())||ObjectUtil.isNullOrEmpty(toUpdates.get(i))){
              toUpdates.remove(i);
              i--;
            }
          }

          familyBedHistoryDao.batchInsert(toUpdates);
        }
      }
    }
  }
  private void addDrugHistoryList(ElderlyPhyExamination elderlyPhyExamination,Long personId, String ehrId) {
    if (ObjectUtil.isNotEmpty(elderlyPhyExamination.getDrugHistorylist())) {
      List<DrugHistory> DrugHistoryList = elderlyPhyExamination.getDrugHistorylist();
      if (ObjectUtil.isNotEmpty(DrugHistoryList)) {
        List<DrugHistory> toUpdates = new ArrayList<>(DrugHistoryList.size());
        for (DrugHistory DrugHistory : DrugHistoryList) {
          if (null != DrugHistory) {
            DrugHistory.setEhrId(ehrId);
            DrugHistory.setPersonId(personId);
            toUpdates.add(DrugHistory);
          }
        }
        if (ObjectUtil.isNotEmpty(toUpdates)) {
          for (int i = 0; i < toUpdates.size(); i++) {
            if(ObjectUtil.isNullOrEmpty(toUpdates.get(i).getDrugGenericName())||ObjectUtil.isNullOrEmpty(toUpdates.get(i))){
              toUpdates.remove(i);
              i--;
            }
          }
          drugHistoryDao.batchInsert(toUpdates);
        }
      }
    }
  }
  private void addVaccinationInfo(ElderlyPhyExamination elderlyPhyExamination,Long personId, String ehrId) {
    if (ObjectUtil.isNotEmpty(elderlyPhyExamination.getVaccinationInfoList())) {
      List<VaccinationInfo> VaccinationInfoList = elderlyPhyExamination.getVaccinationInfoList();
      if (ObjectUtil.isNotEmpty(VaccinationInfoList)) {
        List<VaccinationInfo> toUpdates = new ArrayList<>(VaccinationInfoList.size());
        for (VaccinationInfo vaccinationInfo : VaccinationInfoList) {
          if (null != vaccinationInfo) {
            vaccinationInfo.setEhrId(ehrId);
            vaccinationInfo.setPersonId(personId);
            toUpdates.add(vaccinationInfo);
          }
        }
        if (ObjectUtil.isNotEmpty(toUpdates)) {
          for (int i = 0; i < toUpdates.size(); i++) {
            if(ObjectUtil.isNullOrEmpty(toUpdates.get(i).getVaccineName())||ObjectUtil.isNullOrEmpty(toUpdates.get(i))){
              toUpdates.remove(i);
              i--;
            }
          }
          vaccinationInfoDao.batchInsert(toUpdates);
        }
      }
    }
  }

  /**
   * Build no.
   * @param elderlyPhyExamination
   *            the elderly phy examination
   */
    //（此函数已经废弃，不建议使用（会引起体检编号重复）
//  private void buildNo(ElderlyPhyExamination elderlyPhyExamination) {
//    // 编号组成
//    // 机构+年份+年度数量
//    StringBuilder stringBuilder = new StringBuilder(13);
//    String organCode = elderlyPhyExamination.getExaminationOrganCode();
//    Assert.notNull(organCode, "体检单位不能为空");
//    Calendar calendar = Calendar.getInstance();
//    int year = calendar.get(Calendar.YEAR);
//    calendar.set(year, 0, 0, 0, 0, 0);
//    Criteria criteria = new Criteria("examinationDate", OP.GE, calendar.getTime());
//    stringBuilder.append(organCode.substring(organCode.length() - 4, organCode.length()));
//    stringBuilder.append(year);
//    Integer count = elderlyPhyExaminationDao.getCount(criteria, "id", Integer.class);
//    if (count == null) {
//      count = 1;
//    } else {
//      count++;
//    }
//    String fix = String.format("%05d", count);
//    stringBuilder.append(fix.substring(fix.length() - 5, fix.length()));
//    elderlyPhyExamination.setPhysicalExamCode(stringBuilder.toString());
//  }

  /**
   * Gets field.
   *
   * @param date
   *            the date
   * @param field
   *            the field
   * @return the field
   */
  private int getField(Date date, int field) {
    if (null == date) {
      return -1;
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(field);
  }

  // ===============指标=======================//
  private void tryAddTargetValue(ElderlyPhyExamination elderlyPhyExamination, Organization organization, User user) {
    try {
      this.addTargetValue(elderlyPhyExamination, organization, user);
    } catch (Exception e) {
      log.error("保存慢病体检指标值失败!", e);
    }
  }

  private void addTargetValue(ElderlyPhyExamination elderlyPhyExamination, Organization organization, User user) {
    if (null == elderlyPhyExamination) {
      return;
    }
    Integer sbp = elderlyPhyExamination.getLeftSbp();
    Integer dbp = elderlyPhyExamination.getLeftDbp();
    BigDecimal fpg = elderlyPhyExamination.getFpgMmol();
    if(null!=sbp||null != dbp ||null != fpg){
      TargetResultValue resultValue = new TargetResultValue();
      Set<String> properties = new HashSet<>(3);
      resultValue.setPersonId(elderlyPhyExamination.getPersonId());
      resultValue.setEhrId(elderlyPhyExamination.getEhrId());
      resultValue.setCreateDate(elderlyPhyExamination.getExaminationDate());
      resultValue.setType("慢病体检");
      if (null != sbp) {
        properties.add("valueA");
        resultValue.setValueA(BigDecimal.valueOf(sbp));
      }
      if (null != dbp) {
        properties.add("valueB");
        resultValue.setValueB(BigDecimal.valueOf(dbp));
      }
      if (null != fpg) {
        properties.add("valueC");
        resultValue.setValueC(fpg);
      }
      resultValue.setIsDelete(0);
      targetService.addOrUpdateTargetResultValue(resultValue, organization.getOrganCode(), String.valueOf(user.getId()), properties);
    }
  }

  /**
   * 个人体检、老年人体检同步到慢病体检
   */
  @Override
  @Transactional
  public void savePhyExaminationFromEhrMeso(PersonalPhyExamDTO dto, ElderlyPhyExamination elderlyPhyExamination,Organization organization,User user, String... properties) {
    Assert.notNull(dto.getPersonInfo().getId(), "体检人员信息不能为空");
    Assert.notNull(elderlyPhyExamination, "体检不能为空");

    // 如果没有体检日志,则设置为当前日期
    if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getExaminationDate())) {
      Assert.notNull(elderlyPhyExamination, "体检日期不能为空");
    }
    //如果非慢病患者，不创建慢病体检
    Criteria mdmDiseaseCriteria = new Criteria("personId",elderlyPhyExamination.getPersonId());
    mdmDiseaseCriteria.add("status",EHRConstants.DM_MANAGE_STATUS_NORMAL);
    mdmDiseaseCriteria.add(getHmCardDeleteStatus("", EHRConstants.DM_MANAGED_FLAG));
    if(ObjectUtil.isNullOrEmpty(diseaseInfoDao.get(mdmDiseaseCriteria))){
      return;
    }
    //找有没有有更新，没有新增
    Criteria criteria = new Criteria("personId", elderlyPhyExamination.getPersonId());
    criteria.add("physicalExamCode", elderlyPhyExamination.getPhysicalExamCode());
    criteria.add("physicalExamType", EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
    HealthExamination examination = healthExaminationDao.get(criteria);
    if(ObjectUtil.isNullOrEmpty(examination)){
		elderlyPhyExamination.setHealthEvaluateAnomalies(dto.getHealthEvaluateAnomalyList());
	    elderlyPhyExamination.setHospitalizedHistoryList(dto.getHospitalizedHistoryList());
	    elderlyPhyExamination.setFamilyBedHistoryList(dto.getFamilyBedHistoryList());
	    elderlyPhyExamination.setDrugHistorylist(dto.getDrugHistoryList());
	    elderlyPhyExamination.setVaccinationInfoList(dto.getVaccinationInfoList());
	    savePhyExaminationFromEhrMesoDb(dto.getPersonInfo(),elderlyPhyExamination,organization,user);
    }else{
      updatePhyExaminationFromEhrMesoDb(dto.getPersonInfo(),elderlyPhyExamination,organization,user,examination,dto.getHealthEvaluateAnomalyList(),dto.getHospitalizedHistoryList(),dto.getFamilyBedHistoryList(),dto.getDrugHistoryList(),dto.getVaccinationInfoList(),properties);
    }
    
    //慢病体检信息存入家医履约表里，由定时任务更新到家医服务记录
    final PersonalPhyExamDTO personalPhyExamDTO = dto;
    final User currentUser = user;
	Thread thread = new Thread(new Runnable() {
		public void run() {
			serviceSyncLogService.insertExam(personalPhyExamDTO, currentUser, null, EHRConstants.CDM_EXAM_JSON_TYPE, null);
		}
	});
	thread.start();
  }

  /**
   * 管理卡是否撤消的查询条件
   * @param alias
   * @param isDelete
   * @return
   */
  private Criteria getHmCardDeleteStatus(String alias, String isDelete) {
    Criteria criteria = new Criteria();
    criteria.add(alias + "hbp_flag", isDelete);
    criteria.add(LOP.OR, alias + "di_flag", isDelete);
    criteria.add(LOP.OR, alias + "stroke_flag", isDelete);
    criteria.add(LOP.OR, alias + "coronary_flag", isDelete);
    criteria.add(LOP.OR, alias + "tumor_flag", isDelete);
    return criteria;
  }

  @Transactional
  private void savePhyExaminationFromEhrMesoDb(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination,Organization organization,User user) {
    // 计算年龄
    elderlyPhyExamination.setAge(DateUtil.getAge(personInfo.getBirthday(), elderlyPhyExamination.getExaminationDate()));
    // 体检事件
    EHRHealthEvent event = createEhrHealthEvent(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode(), "慢病体检", personInfo, elderlyPhyExamination);
    // 体检信息
    HealthExamination examination = new HealthExamination();
    copyHealthExamination(elderlyPhyExamination, personInfo, examination);
    //end = System.currentTimeMillis();
    String ehrId = event.getEhrId();
    examination.setEhrId(ehrId);
    examination.setPhysicalExamType(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
    healthExaminationDao.insert(examination);
    if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getPhysicalExamCode())) {
        String examCode = EHRNumberService.getSerialNum(elderlyPhyExamination.getExaminationOrganCode(), EHRConstants.EXAM_NUMBER_TYPE);
        elderlyPhyExamination.setPhysicalExamCode(examCode);
      }
    // 体检数据
    elderlyPhyExamination.setEhrId(ehrId);
    elderlyPhyExamination.setName(personInfo.getName());
    elderlyPhyExamination.setGender(personInfo.getGender());
    elderlyPhyExamination.setBirthday(personInfo.getBirthday());
    elderlyPhyExamination.setPhysicalExamType(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
    elderlyPhyExaminationDao.insert(elderlyPhyExamination);
    addHealthEvaluateAnomalies(elderlyPhyExamination, ehrId);
    addHospitalizedHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addFamilyBedHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addDrugHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addVaccinationInfo(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    // 更新管理卡相关信息
    updateExamYear(elderlyPhyExamination.getPersonId());
    //指标
    tryAddTargetValue(elderlyPhyExamination,organization,user);
  }
  @Transactional
  private void updatePhyExaminationFromEhrMesoDb(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination ,Organization organization,User user,HealthExamination examination,List<HealthEvaluateAnomaly> healthEvaluateAnomalies,List<HospitalizedHistory> hospitalizedHistoryList, List<FamilyBedHistory> familyBedHistoryList,List<DrugHistory> drugHistoryList,List<VaccinationInfo> vaccinationInfoList, String... properties) {
    // 更新体检数据
    elderlyPhyExamination.setName(personInfo.getName());
    elderlyPhyExamination.setGender(personInfo.getGender());
    elderlyPhyExamination.setBirthday(personInfo.getBirthday());
    elderlyPhyExamination.setAge(DateUtil.getAge(personInfo.getBirthday(), elderlyPhyExamination.getExaminationDate()));

    copyHealthExamination(elderlyPhyExamination, personInfo, examination);
    healthExaminationDao.update(examination);

    Criteria criteriadb = new Criteria("personId", elderlyPhyExamination.getPersonId());
    criteriadb.add("physicalExamCode", elderlyPhyExamination.getPhysicalExamCode());
    criteriadb.add("physicalExamType", EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
    criteriadb.add("ehrId", examination.getEhrId());
    ElderlyPhyExamination elderlyPhyExamDb=elderlyPhyExaminationDao.get(criteriadb);
    Assert.notNull(elderlyPhyExamDb, "无法获取体检信息");
    elderlyPhyExamination.setEhrId(examination.getEhrId());
    elderlyPhyExamination.setId(elderlyPhyExamDb.getId());
    elderlyPhyExamination.setPhysicalExamCode(elderlyPhyExamDb.getPhysicalExamCode());
    elderlyPhyExamination.setPhysicalExamType(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode());
    //高血压、糖尿病中医药健康管理数据拷贝
    CopyHypertensionDiabetesManage(elderlyPhyExamination,elderlyPhyExamDb);
    //家族史
    if(StringUtil.isNullOrEmpty(elderlyPhyExamination.getFamilyHistoryHbpFlg())){
      elderlyPhyExamination.setFamilyHistoryHbpFlg(elderlyPhyExamDb.getFamilyHistoryHbpFlg());
    }
    if(StringUtil.isNullOrEmpty(elderlyPhyExamination.getFamilyHistoryDiFlg())){
      elderlyPhyExamination.setFamilyHistoryDiFlg(elderlyPhyExamDb.getFamilyHistoryDiFlg());
    }
    if(StringUtil.isNullOrEmpty(elderlyPhyExamination.getFamilyHistoryStrokeFlg())){
      elderlyPhyExamination.setFamilyHistoryStrokeFlg(elderlyPhyExamDb.getFamilyHistoryStrokeFlg());
    }
    if(StringUtil.isNullOrEmpty(elderlyPhyExamination.getFamilyHistoryCoronaryFlg())){
      elderlyPhyExamination.setFamilyHistoryCoronaryFlg(elderlyPhyExamDb.getFamilyHistoryCoronaryFlg());
    }
    elderlyPhyExaminationDao.update(elderlyPhyExamination,properties);
    // 删除关联的异常数据
    Criteria ca = new Criteria("personId", personInfo.getId()).add("ehrId", examination.getEhrId());
    healthEvaluateAnomalyDao.delete(new Criteria("ehrId", examination.getEhrId()));
    familyBedHistoryDao.delete(ca);
    hospitalizedHistoryDao.delete(ca);
    drugHistoryDao.delete(ca);
    vaccinationInfoDao.delete(ca);

    // 重新插入新的异常数据
    elderlyPhyExamination.setHealthEvaluateAnomalies(healthEvaluateAnomalies);
    elderlyPhyExamination.setHospitalizedHistoryList(hospitalizedHistoryList);
    elderlyPhyExamination.setFamilyBedHistoryList(familyBedHistoryList);
    elderlyPhyExamination.setDrugHistorylist(drugHistoryList);
    elderlyPhyExamination.setVaccinationInfoList(vaccinationInfoList);
    addHealthEvaluateAnomalies(elderlyPhyExamination, examination.getEhrId());
    addHospitalizedHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addFamilyBedHistoryList(elderlyPhyExamination, elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addDrugHistoryList(elderlyPhyExamination,elderlyPhyExamination.getPersonId(), examination.getEhrId());
    addVaccinationInfo(elderlyPhyExamination,elderlyPhyExamination.getPersonId(), examination.getEhrId());
    elderlyPhyExaminationDao.update(elderlyPhyExamination);

    // 更新事件体检机构和体检日期
    updateEhrHealthEvent(personInfo, elderlyPhyExamination);
    // 更新管理卡相关信息
    updateExamYear(elderlyPhyExamination.getPersonId());

    //指标
    tryAddTargetValue(elderlyPhyExamination,organization,user);
  }

  //高血压、糖尿病中医药健康管理数据拷贝
  private void CopyHypertensionDiabetesManage(ElderlyPhyExamination elderlyPhyExamination,ElderlyPhyExamination elderlyPhyExamDb){
    elderlyPhyExamination.setHyinEmptyYangHyper(elderlyPhyExamDb.getHyinEmptyYangHyper());
    elderlyPhyExamination.setHyinEmptyYangHyperMain(elderlyPhyExamDb.getHyinEmptyYangHyperMain());
    elderlyPhyExamination.setHyinEmptyYangHyperSec(elderlyPhyExamDb.getHyinEmptyYangHyperSec());
    elderlyPhyExamination.setHyinEmptyYangHyperTap(elderlyPhyExamDb.getHyinEmptyYangHyperTap());
    elderlyPhyExamination.setHyinEmptyYangHyperChg(elderlyPhyExamDb.getHyinEmptyYangHyperChg());
    elderlyPhyExamination.setHyinEmptyYangHyperDesc(elderlyPhyExamDb.getHyinEmptyYangHyperDesc());
    elderlyPhyExamination.setHqiBloodEmpty(elderlyPhyExamDb.getHqiBloodEmpty());
    elderlyPhyExamination.setHqiBloodEmptyMain(elderlyPhyExamDb.getHqiBloodEmptyMain());
    elderlyPhyExamination.setHqiBloodEmptySec(elderlyPhyExamDb.getHqiBloodEmptySec());
    elderlyPhyExamination.setHqiBloodEmptyTap(elderlyPhyExamDb.getHqiBloodEmptyTap());
    elderlyPhyExamination.setHqiBloodEmptyChg(elderlyPhyExamDb.getHqiBloodEmptyChg());
    elderlyPhyExamination.setHqiBloodEmptyDesc(elderlyPhyExamDb.getHqiBloodEmptyDesc());
    elderlyPhyExamination.setHphlegmBloodStasis(elderlyPhyExamDb.getHphlegmBloodStasis());
    elderlyPhyExamination.setHphlegmBloodStasisMain(elderlyPhyExamDb.getHphlegmBloodStasisMain());
    elderlyPhyExamination.setHphlegmBloodStasisSec(elderlyPhyExamDb.getHphlegmBloodStasisSec());
    elderlyPhyExamination.setHphlegmBloodStasisTap(elderlyPhyExamDb.getHphlegmBloodStasisTap());
    elderlyPhyExamination.setHphlegmBloodStasisChg(elderlyPhyExamDb.getHphlegmBloodStasisChg());
    elderlyPhyExamination.setHphlegmBloodStasisDesc(elderlyPhyExamDb.getHphlegmBloodStasisDesc());
    elderlyPhyExamination.setHspermDeficiency(elderlyPhyExamDb.getHspermDeficiency());
    elderlyPhyExamination.setHspermDeficiencyMain(elderlyPhyExamDb.getHspermDeficiencyMain());
    elderlyPhyExamination.setHspermDeficiencySec(elderlyPhyExamDb.getHspermDeficiencySec());
    elderlyPhyExamination.setHspermDeficiencyTap(elderlyPhyExamDb.getHspermDeficiencyTap());
    elderlyPhyExamination.setHspermDeficiencyChg(elderlyPhyExamDb.getHspermDeficiencyChg());
    elderlyPhyExamination.setHspermDeficiencyDesc(elderlyPhyExamDb.getHspermDeficiencyDesc());
    elderlyPhyExamination.setHyangEmpty(elderlyPhyExamDb.getHyangEmpty());
    elderlyPhyExamination.setHyangEmptyMain(elderlyPhyExamDb.getHyangEmptyMain());
    elderlyPhyExamination.setHyangEmptySec(elderlyPhyExamDb.getHyangEmptySec());
    elderlyPhyExamination.setHyangEmptyChg(elderlyPhyExamDb.getHyangEmptyChg());
    elderlyPhyExamination.setHyangEmptyDesc(elderlyPhyExamDb.getHyangEmptyDesc());
    elderlyPhyExamination.setHanOffset(elderlyPhyExamDb.getHanOffset());
    elderlyPhyExamination.setHanOffsetMain(elderlyPhyExamDb.getHanOffsetMain());
    elderlyPhyExamination.setHanOffsetSec(elderlyPhyExamDb.getHanOffsetSec());
    elderlyPhyExamination.setHanOffsetChg(elderlyPhyExamDb.getHanOffsetChg());
    elderlyPhyExamination.setHanOffsetDesc(elderlyPhyExamDb.getHanOffsetDesc());
    elderlyPhyExamination.setDyinEmptyHot(elderlyPhyExamDb.getDyinEmptyHot());
    elderlyPhyExamination.setDyinEmptyHotMain(elderlyPhyExamDb.getDyinEmptyHotMain());
    elderlyPhyExamination.setDyinEmptyHotTap(elderlyPhyExamDb.getDyinEmptyHotTap());
    elderlyPhyExamination.setDyinEmptyHotChg(elderlyPhyExamDb.getDyinEmptyHotChg());
    elderlyPhyExamination.setDyinEmptyHotDesc(elderlyPhyExamDb.getDyinEmptyHotDesc());
    elderlyPhyExamination.setDqiYinEmpty(elderlyPhyExamDb.getDqiYinEmpty());
    elderlyPhyExamination.setDqiYinEmptyMain(elderlyPhyExamDb.getDqiYinEmptyMain());
    elderlyPhyExamination.setDqiYinEmptyTap(elderlyPhyExamDb.getDqiYinEmptyTap());
    elderlyPhyExamination.setDqiYinEmptyChg(elderlyPhyExamDb.getDqiYinEmptyChg());
    elderlyPhyExamination.setDqiYinEmptyDesc(elderlyPhyExamDb.getDqiYinEmptyDesc());
    elderlyPhyExamination.setDyinYangEmpty(elderlyPhyExamDb.getDyinYangEmpty());
    elderlyPhyExamination.setDyinYangEmptyMain(elderlyPhyExamDb.getDyinYangEmptyMain());
    elderlyPhyExamination.setDyinYangEmptyTap(elderlyPhyExamDb.getDyinYangEmptyTap());
    elderlyPhyExamination.setDyinYangEmptyChg(elderlyPhyExamDb.getDyinYangEmptyChg());
    elderlyPhyExamination.setDyinYangEmptyDesc(elderlyPhyExamDb.getDyinYangEmptyDesc());
  };


  /**
   * 慢病体检统计
   * @param page
   * @param form
   * @return
   */
  public PageList<Map<String, Object>> getPhyExaminationStatistics(Page page, ReportQueryForm form, Organization currentOrg) {
    return elderlyPhyExaminationDao.getPhyExaminationStatistics(page, form, currentOrg);
  }

  /**
   * 导出慢病体检统计
   * @param page
   * @param form
   * @return
   */
  @Override
  public List<Map<String, Object>> exportPhyExaminationStatistics(Page page, ReportQueryForm form, Organization currentOrg) {
    PageList<Map<String, Object>> pageList = elderlyPhyExaminationDao.getPhyExaminationStatistics(page, form, currentOrg);
    List<Map<String, Object>> list = null;
    if (null != pageList) {
      list = pageList.getList();
    }
    if (null == list) {
      return Collections.emptyList();
    }
    return list;
  }

	@Override
	public List<Map<String, Object>> getPhyCensusList(Criteria criteria) {
		return elderlyPhyExaminationDao.getPhyCensusList(criteria);
	}

	@Override
	public List<ElderlyPhyExamination> getElderlyPhyExaminations(Criteria cri, Order order, String... properties) {
		return elderlyPhyExaminationDao.getList(cri,order, properties);
	}

	@Override
	public List<HealthExamination> getHealthExaminations(Criteria cri, Order order, String... properties) {
		return healthExaminationDao.getList(cri,order, properties);
	}
	
}
