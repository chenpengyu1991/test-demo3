package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.dto.HealthEventItemDTO;
import com.founder.rhip.ehr.dto.OutpatientReportDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.*;
import com.founder.rhip.ehr.entity.management.DMFollowupPlan;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.*;
import com.founder.rhip.ehr.repository.management.IDMFollowupPlanDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.*;

/**
 * 医疗活动
 * 
 * @author liuk
 */
@Service("healthEventService")
public class HealthEventServiceImpl extends AbstractService implements IHealthEventService {
	@Autowired
	private IPersonInfoDao personInfoDao;
	@Autowired
	private IOutpatientPrescriptionDao outpatientPrescriptionDao;
	@Autowired
	private IEHRHealthEventDao ehrHealthEventDao;
	@Autowired
	private IDrugUsageDao drugUsageDao;
	@Autowired
	private IExamineEventDao examineEventDao;
	@Autowired
	private IStudyEventDao studyEventDao;
	@Autowired
	private IInpatientMedicalRecordDao inpatientMedicalRecordDao;
	@Autowired
	private IOuthospitalSummaryDao outhospitalSummaryDao;
	
	@Autowired
	private IDMFollowupPlanDao dMFollowupPlanDao;

	@Resource(name = "physicalExamRecordDao")
	private IPhysicalExamRecordDao physicalExamRecordDao;
	
	@Resource(name = "diseaseDiagnosisInfoDao")
	private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;

    @Resource(name="inpatientInfoDao")
    private IInpatientInfoDao inpatientInfoDao;

    @Resource(name="outpatientInfoDao")
    private IOutpatientInfoDao outpatientInfoDao;
	
	/**
	 * 是否显示标志,1表示不显示
	 */
	private static final String IS_LIMIT = "1";
	
	@Override
	public PageList<HealthEventItemDTO> getMedicalSeviceHealthEventList(Page page, Criteria criteria, Order order) {
		// 通过人员pix查询到相关的住院摘要
		PageList<EHRHealthEvent> events = ehrHealthEventDao.getPageList(page, criteria, order);
		List<HealthEventItemDTO> healthEventItems = new ArrayList<HealthEventItemDTO>();
        InpatientInfo inpatientInfo;
        OutpatientInfo outpatientInfo;
		if (null != events) {
			List<EHRHealthEvent> ehrHealthEvents = events.getList();
			if (null != ehrHealthEvents) {
				for (EHRHealthEvent item : ehrHealthEvents) {
					HealthEventItemDTO eventItemDTO = new HealthEventItemDTO();
					healthEventItems.add(eventItemDTO);
					eventItemDTO.setEhrHealthEvent(item);
					Criteria paramCriteria = new Criteria();
					paramCriteria.add("ehrId", item.getEhrId());
					paramCriteria.add("personId", item.getPersonId());
//					paramCriteria.add("IS_LIMIT", OP.LT,1);
					Criteria limitc = new Criteria("IS_LIMIT", OP.IS, "NULL").add(LOP.OR, "IS_LIMIT", OP.NE, 1);
					paramCriteria.add(limitc);
					// 是否用药
					Integer drugs = drugUsageDao.getCount(paramCriteria, "ehrId", Integer.class);
					eventItemDTO.setHasDrug(drugs > 0);
					// 是否检验
					Integer exams = examineEventDao.getCount(paramCriteria, "ehrId", Integer.class);
					eventItemDTO.setHasExam(exams > 0);
					// 是否检查
					Integer checks = studyEventDao.getCount(paramCriteria, "ehrId", Integer.class);
					eventItemDTO.setHasStudy(checks > 0);
					// 电子病例检查
					eventItemDTO.setHasElecMedicalRecord(checkHasElecMedicalRecord(item, paramCriteria));
					//add by yejianfei 20140731
					if(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode().equals(item.getEhrType())){//老年人健康体检
						eventItemDTO.setHasPhysicalExamRecord(false);//默认没有生成老年人体检报告
						Map<String,Object> phMap = getPhysicalExam(item.getPersonId(),item.getEhrId(),item.getClinicDate());
						if(ObjectUtil.isNotEmpty(phMap)){
							if(ObjectUtil.isNotEmpty(phMap.get("PHYSICAL_EXAM_CODE"))){//判断体检编号是否为空
                                String examCode = phMap.get("PHYSICAL_EXAM_CODE").toString();
								eventItemDTO.setExamNumber(examCode.toString());
								//设置体检报告是否生成标志
								eventItemDTO.setHasPhysicalExamRecord(true);	
							}
						}
					}
					//add by yejianfei 20140731

                    //增加费用项目列 add by bagen 2017-12-08 start
                    if(EventType.INPATIENT.getCode().equals(item.getEhrType())){//住院
                        inpatientInfo = inpatientInfoDao.get(new Criteria("ehrId", item.getEhrId()));
                        if(ObjectUtil.isNotEmpty(inpatientInfo)){
                            eventItemDTO.setCostSum(inpatientInfo.getInhosCostSum());
                        }
                    }else if(EventType.OUTPATIENT.getCode().equals(item.getEhrType())){//门诊
                        outpatientInfo = outpatientInfoDao.get(new Criteria("ehrId", item.getEhrId()));
                        if(ObjectUtil.isNotEmpty(outpatientInfo)){
                            eventItemDTO.setCostSum(outpatientInfo.getOutpatientCostSum());
                        }
                    }
                    //增加费用项目列 add by bagen 2017-12-08 end
				}
			}
			return new PageList<>(healthEventItems, events.getPage());
		}
		return new PageList<>(healthEventItems, null);
	}
	
	/**
	 * 查看体检报告
	 *
	 * @param personId
	 * @param ehrId
	 * @param clinicDate
	 * @return
	 * @author Ye jianfei
	 */
	private Map<String,Object> getPhysicalExam(Long personId,String ehrId,Date clinicDate){
		Criteria physicalExamCriteria = new Criteria();
		physicalExamCriteria.add("personId", personId);
		physicalExamCriteria.add("ehrId", ehrId);
		physicalExamCriteria.add("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
		if (ObjectUtil.isNotEmpty(clinicDate)) {
			Calendar beginDate = Calendar.getInstance();
			beginDate.setTime(clinicDate);
			beginDate.set(Calendar.MONTH, Calendar.JANUARY);
			beginDate.set(Calendar.DAY_OF_MONTH, 1);
			Calendar endDate = Calendar.getInstance();
			endDate.setTime(clinicDate);
			endDate.set(Calendar.MONTH, Calendar.DECEMBER);
			endDate.set(Calendar.DAY_OF_MONTH, 31);
			physicalExamCriteria.add("examinationDate", OP.BETWEEN, new Date[] {DateUtil.firstTimeOfDay(beginDate.getTime()), DateUtil.lastTimeOfDay(endDate.getTime())});
		}
		return physicalExamRecordDao.getPhysicalExam(physicalExamCriteria);
	}
	/**
	 * 检查是否有电子病例 不同的活动类型检查方式不同
	 * 
	 * @param item
	 * @param criteria
	 * @return
	 */
	private boolean checkHasElecMedicalRecord(EHRHealthEvent item, Criteria criteria) {
		if (EventType.INPATIENT.getCode().equals(item.getEhrType())) {
			// 住院
			// 是否有电子病例,病案首页和出院小结有一个即可
			Integer inpatientMeRecords = inpatientMedicalRecordDao.getCount(criteria, "ehrId", Integer.class);
			Integer outhospitalSummarys = outhospitalSummaryDao.getCount(criteria, "ehrId", Integer.class);
			return (inpatientMeRecords > 0 || outhospitalSummarys > 0);
		} else if (EventType.OUTPATIENT.getCode().equals(item.getEhrType())) {
			// 门诊
			// TODO
		} else if (EventType.PHYSICAL_EXAMINATION.getCode().equals(item.getEhrType())) {
			// 体检
			// TODO
		}
		return false;
	}

	@Override
	public EHRHealthEvent getEHRHealthEvent(Criteria criteria) {
		EHRHealthEvent ehrHealthEvent = ehrHealthEventDao.get(criteria);
		return ehrHealthEvent;
	}

	@Override
	public boolean checkHealthEvent(Criteria criteria) {
		if (null == criteria) {
			return false;
		}
		Integer eventCounts = ehrHealthEventDao.getCount(criteria, "id", Integer.class);
		return eventCounts > 0;
	}

	@Override
	public int checkPersonRecordStatus(Criteria criteria) {
		if (null == criteria) {
			return 0;
		}
		criteria.add("ehrType", EventType.PERSON_RECORD_COVER.getCode());
		boolean coverComplete = this.checkHealthEvent(criteria);

		criteria.remove("ehrType");
		criteria.add("ehrType", EventType.PERSON_RECORD_BASIC_INFO.getCode());
		boolean personInfoComplete = this.checkHealthEvent(criteria);

		criteria.remove("ehrType");
		criteria.add("ehrType", EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode());
		boolean phyComplete = this.checkHealthEvent(criteria);
		// 返回三个结果的按位与后的值
		int coverCompleteStatus = coverComplete ? 1 : 0;
		int personInfoCompleteStatus = personInfoComplete ? 2 : 0;
		int phyCompleteStatus = phyComplete ? 4 : 0;
		return coverCompleteStatus | personInfoCompleteStatus | phyCompleteStatus;

	}

	/**
	 * 获取健康事件列表
	 */
	@Override
	public List<EHRHealthEvent> getEHRHealthEvents(Criteria criteria, String... properties) {
		return ehrHealthEventDao.getList(criteria,properties);
	}

	@Override
	public List<EHRHealthEvent> getEHRHealthEvents(Criteria criteria, Order order, String... properties) {
		return ehrHealthEventDao.getList(criteria, order, properties);
	}

	/**
	 * 获取健康事件列表
	 */
	@Override
	public PageList<EHRHealthEvent> getEHRHealthEventPageList(Page page, Criteria criteria, String... properties) {
		return ehrHealthEventDao.getPageList(page, criteria, properties);
	}

	/**
	 * 获取疾病管理事件
	 */
	@Override
	public List<DMFollowupPlan> getDmFollowupedPlans(Long personId) {
		return dMFollowupPlanDao.getFollowupedPlanByPersonId(personId);
	}
	
	@Override
    public List<String> getRelationOrganCodes(Long personId){
		Assert.notNull(personId, "人员Id不能为空");
		List<String> codes= drugUsageDao.getRelationOrganCodes(personId);
		List<String> eventCodes= ehrHealthEventDao.getRelationOrganCodes(personId);
		List<String> all=new ArrayList<>();
		
		if (ObjectUtil.isNotEmpty(codes)) {
			for (String string : codes) {
				if (ObjectUtil.isNotEmpty(string)) {
					all.add(string);
				}
			}
		}
		
		if (ObjectUtil.isNotEmpty(eventCodes)) {
			for (String string : eventCodes) {
				if (ObjectUtil.isNotEmpty(string)) {
					all.add(string);
				}
			}
		}
		
		return all;
	}
	
	/**
	 * 获取疾病信息列表
	 */
	@Override
	public PageList<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfoPageList(Page page, Criteria criteria) {
		return diseaseDiagnosisInfoDao.getPageList(page, criteria);
	}

	/**
	 * 获取疾病信息列表
	 */
	@Override
	public List<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfoList(Criteria criteria) {
		return diseaseDiagnosisInfoDao.getList(criteria);
	}

	/**
	 * 获取检查列表
	 */
	@Override
	public List<StudyEvent> getStudyEventList(Criteria criteria) {
		return studyEventDao.getList(criteria);
	}

	/**
	 * 获取检验列表
	 */
	@Override
	public List<ExamineEvent> getExamineEventList(Criteria criteria) {
		return examineEventDao.getList(criteria);
	}

	@Override
	public List<DMFollowupPlan> getLifeEventByFollowupPlans(Long personId, String dmType) {
		return dMFollowupPlanDao.getLifeEventByFollowupPlans(personId, dmType);
	}
}
