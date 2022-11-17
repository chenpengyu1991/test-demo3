package com.founder.rhip.ehr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyStatus;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyStatusDao;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.ehr.repository.ech.IEchIdentificationDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

/**
 * 老年人、体质辨识历史数据处理
 * @author guo.xm
 */
@Service("hmEchService")
@TaskBean(cron = "0 0 0 1 * ?", description = "老年人、体质辨识历史数据处理")
public class HmEchServiceImpl extends AbstractService implements IHmEchService, Task{

	@Resource
	private IEchIdentificationDao echIdentificationDao;
	
	@Resource
	private IElderlyPhyExaminationDao elderlyPhyExaminationDao;
	
	@Resource
	private IElderlyPhyStatusDao elderlyPhyStatusDao;
	
	@Resource
	private IPhysicalExamRecordDao physicalExamRecordDao;
	
	@Resource
	private IPhysiqueExaminationDao physiqueExaminationDao;
	
	@Resource
	private IPersonInfoDao personInfoDao;
	
	@Resource(name = "personalRecordService")
	private IPersonalRecordService personalRecordService;
	
	private int count = 0;
	private long id = 0;
	
	@Override
	public void run(Map<String, Object> data) {
		System.out.println("==========================================");
		System.out.println("===老年人、体质辨识历史数据处理=====开始=====");
		System.out.println("==========================================");
		
		//体质辨识表person_id、TCM_CONCLUSION
		updateIdentification();
		
		//sql执行无反应，只能改定时任务
		//补充老年人idenId--
		updateHmIdenId();
		//补充慢病idenId
		updateCdmIdenId();
		//补充个人体检idenId
		updatePhyIdenId();
		
		//补充老年人examYear
		updateHmExamYear();
		//新增老年人体检状态表
		updateHmPhy();
		
		System.out.println("==========================================");
		System.out.println("===老年人、体质辨识历史数据处理=====结束=====");
		System.out.println("==========================================");
	}

	private void updateHmPhy() {
		id = 0;
		count = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<ElderlyPhyExamination>() {
			@Override
			public PageList<ElderlyPhyExamination> get(Page page) {
				Criteria cri = new Criteria("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
				cri.add("id", OP.GT, id);
				cri.add("examinationOrganCode", OP.UEMPTY, null);
				//全表 新增、修改
				PageList<ElderlyPhyExamination> list = elderlyPhyExaminationDao.getPageList(page,cri, new Order("id"));
				
				//只新增
//				PageList<ElderlyPhyExamination> list = elderlyPhyExaminationDao.getPageHmStatusTemp(page,id);
				return list;
			}

			@Override
			public void run(List<ElderlyPhyExamination> list) {
				List<ElderlyPhyStatus> insertList = new ArrayList<>();
				List<ElderlyPhyStatus> updateList = new ArrayList<>();
				
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				
				for (ElderlyPhyExamination phy : list) {
					id = phy.getId();
					if (ObjectUtil.isNullOrEmpty(phy)) {
						continue;
					}
					
					//新增、更新老年人体检状态表
					Criteria cri = new Criteria("personId",phy.getPersonId());
			    	cri.add("physicalExamCode", phy.getPhysicalExamCode());
			    	cri.add("examinationDate", phy.getExaminationDate());
					ElderlyPhyStatus status = elderlyPhyStatusDao.get(cri, "ID");
					if(ObjectUtil.isNullOrEmpty(status)){
						status  = new ElderlyPhyStatus();
			    	}
//					ElderlyPhyStatus status = new ElderlyPhyStatus();
					status.setEhrId(phy.getEhrId());
			        status.setPersonId(phy.getPersonId());
			        status.setName(phy.getName());
			        status.setPhysicalExamCode(phy.getPhysicalExamCode());
			        status.setExamYear(phy.getExamYear());
			        status.setExaminationDate(phy.getExaminationDate());
			        status.setExaminationOrganCode(phy.getExaminationOrganCode());
			        status.setManaDoctorId(phy.getManaDoctorId());
			        status.setTcmStatus(ObjectUtil.isNotEmpty(phy.getIdentificationId()) ? 1 : 0);
					status.setHealthGuideStatus(updateHealthGuideStatus(phy.getIdentificationId()));
			        status.setEstimateStatus(updateSelfAssessment(phy));
			        status.setCriterionExamination(updateCriterionExamination(phy));
			        if(ObjectUtil.isNotEmpty(status.getId())){
						updateList.add(status);
					}else{
						insertList.add(status);
					}
				}
				count += list.size();
				
				elderlyPhyStatusDao.batchInsert(insertList);
				elderlyPhyStatusDao.batchUpdate(updateList);
				
				System.out.println("----更新老年人状态表----"+id+"-------"+DateUtil.toDateString(new Date(), "HH:mm:ss")+"  已处理" +count+ "条");
			}
		});
	}
 
	private void updateHmExamYear() {
		id = 0;
		count = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<ElderlyPhyExamination>() {
			@Override
			public PageList<ElderlyPhyExamination> get(Page page) {
				PageList<ElderlyPhyExamination> list = elderlyPhyExaminationDao.getPageListHmYearTemp(page,id);
				return list;
			}
			@Override
			public void run(List<ElderlyPhyExamination> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (ElderlyPhyExamination phy : list) {
					id = phy.getId();
				}
				count += list.size();
				elderlyPhyExaminationDao.batchUpdate(list, "examYear");
				System.out.println("----老年人体检补充examYear----"+id+"-------"+DateUtil.toDateString(new Date(), "HH:mm:ss")+"  已处理" +count+ "条");
			}
		});
	}
	
	private void updateHmIdenId() {
		id = 0;
		count = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<ElderlyPhyExamination>() {
			@Override
			public PageList<ElderlyPhyExamination> get(Page page) {
				PageList<ElderlyPhyExamination> list = elderlyPhyExaminationDao.getPageListHmTemp(page,id);
				return list;
			}
			@Override
			public void run(List<ElderlyPhyExamination> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (ElderlyPhyExamination phy : list) {
					id = phy.getId();
				}
				count += list.size();
				elderlyPhyExaminationDao.batchUpdate(list, "identificationId");
				System.out.println("----老年人体检补充IDENTIFICATION_ID----"+id+"-------"+DateUtil.toDateString(new Date(), "HH:mm:ss")+"  已处理" +count+ "条");
			}
		});
	}
	
	private void updateCdmIdenId() {
		id = 0;
		count = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<ElderlyPhyExamination>() {
			@Override
			public PageList<ElderlyPhyExamination> get(Page page) {
				PageList<ElderlyPhyExamination> list = elderlyPhyExaminationDao.getPageListCdmTemp(page,id);
				return list;
			}

			@Override
			public void run(List<ElderlyPhyExamination> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				
				for (ElderlyPhyExamination phy : list) {
					id = phy.getId();
				}
				count += list.size();
				elderlyPhyExaminationDao.batchUpdate(list, "identificationId");
				System.out.println("----慢病补充IDENTIFICATION_ID----"+id+"-------"+DateUtil.toDateString(new Date(), "HH:mm:ss")+"  已处理" +count+ "条");
			}
		});
	}

	private void updatePhyIdenId() {
		id = 0;
		count = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<PhysiqueExamination>() {
			@Override
			public PageList<PhysiqueExamination> get(Page page) {
				return physiqueExaminationDao.getPageListTemp(page,id);
			}

			@Override
			public void run(List<PhysiqueExamination> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				
				for (PhysiqueExamination phy : list) {
					id = phy.getId();
				}
				count += list.size();
				physiqueExaminationDao.batchUpdate(list, "identificationId");
				System.out.println("----个人体检补充IDENTIFICATION_ID----"+id+"-------"+DateUtil.toDateString(new Date(), "HH:mm:ss")+"  已处理" +count+ "条");
			}
		});
	}
	
    /**
     * 更新自我评估--必填项
     * @param examination
     * @return int
     */
    private int updateSelfAssessment(ElderlyPhyExamination examination) {
        if (examination == null) {
            return 0;
        }
        return 1;
    }
	    
	/**
	 * 判断是否中医指导
	 * @param elderlyPhyExamination
	 * @param long
	 * @return
	 */
    private Integer updateHealthGuideStatus(Long id) {
    	EchIdentification iden = echIdentificationDao.get(id);
    	Integer res = 0;
    	if(ObjectUtil.isNotEmpty(iden)){
    		if(StringUtil.isNotEmpty(iden.getQiQualityGuidance())  || StringUtil.isNotEmpty(iden.getYangQualityGuidance())
    				|| StringUtil.isNotEmpty(iden.getYinDeficiencyGuidance()) || StringUtil.isNotEmpty(iden.getPhlegmWetnessGuidance())
    				|| StringUtil.isNotEmpty(iden.getHeatMediumGuidance()) || StringUtil.isNotEmpty(iden.getBloodQualityGuidance())
    				|| StringUtil.isNotEmpty(iden.getQiStagnationGuidance()) || StringUtil.isNotEmpty(iden.getSpecialQualityGuidance())
    				|| StringUtil.isNotEmpty(iden.getPeacefulQualityGuidance())){
    			res = 1;
    		}
    	}
		return res;
	}
	
	/**
     * 判断是否规范体检
     * @param elderlyPhyExamination
     * @return
     */
	private Integer updateCriterionExamination(ElderlyPhyExamination phy) {
		Integer res = 0;
			if(	//血常规
				ObjectUtil.isNotEmpty(phy.getHemoglobinValue()) && ObjectUtil.isNotEmpty(phy.getLeukocyteCount()) && ObjectUtil.isNotEmpty(phy.getPlateletCount())
				//尿常规
				&& ObjectUtil.isNotEmpty(phy.getUrineProQuantitativeValue()) && ObjectUtil.isNotEmpty(phy.getUrineSugQuantitativeValue()) && ObjectUtil.isNotEmpty(phy.getKetQuantitativeValue()) && ObjectUtil.isNotEmpty(phy.getEryQuantitativeValue())
				//肝功能
				&& ObjectUtil.isNotEmpty(phy.getSerumGptValue()) && ObjectUtil.isNotEmpty(phy.getSerumAstValue()) && ObjectUtil.isNotEmpty(phy.getTotalBilirubin())
				//肾功能
				&& ObjectUtil.isNotEmpty(phy.getCreatinine()) && ObjectUtil.isNotEmpty(phy.getBloodUreaNitrogenValue())
				//空腹血糖
				&& (ObjectUtil.isNotEmpty(phy.getFpgMg()) || ObjectUtil.isNotEmpty(phy.getFpgMmol()))
				//血脂
				&& ObjectUtil.isNotEmpty(phy.getTc()) && ObjectUtil.isNotEmpty(phy.getTriglycerideValue()) && ObjectUtil.isNotEmpty(phy.getLdlcDetectValue()) && ObjectUtil.isNotEmpty(phy.getHdlcDetectValue())
				//心电图检测
				&& ObjectUtil.isNotEmpty(phy.getEcgAnomalyFlag()) && Integer.valueOf(phy.getEcgAnomalyFlag())!=2
				//腹部B超
				&& ObjectUtil.isNotEmpty(phy.getBmodeAnomalyfFlag()) && Integer.valueOf(phy.getBmodeAnomalyfFlag())!=2 ){
				res = 1;
			}
		return res;
	}
	
	private void updateIdentification() {
		count = 0;
		// 分页处理
		PageableDateSource.execFirst(new IDataSource<EchIdentification>() {
			
			@Override
			public PageList<EchIdentification> get(Page page) {
				return echIdentificationDao.getPageList(page, new Criteria("tcmConclusion", OP.IS, null));
			}

			@Override
			public void run(List<EchIdentification> list) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				
				for (EchIdentification iden : list) {
					if (ObjectUtil.isNullOrEmpty(iden)) {
						continue;
					}
					iden.calTcmFlag();
					String result = getConclusion(iden);
					iden.setTcmConclusion(result.equals("")?" ":result);
				}
				count += list.size();
				echIdentificationDao.batchUpdate(list, "tcmConclusion");
				System.out.println("----体质辨识----"+DateUtil.toDateString(new Date(), "HH:mm:ss")+"  已处理" +count+ "条");
			}
		});
	}

	
    public String getConclusion(EchIdentification identification){
    	String result = "";
    	String mainStr = "";
    	String tendencyStr = "";
    	String basicStr = "";
    	
    	mainStr +=  "1".equals(identification.getQiFlag())?"气虚质 ":"";
    	mainStr +=  "1".equals(identification.getYangFlag())?"阳虚质 ":"";
    	mainStr +=  "1".equals(identification.getYinDeficiencyFlag())?"阴虚质 ":"";
    	mainStr +=  "1".equals(identification.getPhlegmWetnessFlag())?"痰湿质 ":"";
    	mainStr +=  "1".equals(identification.getHeatMediumFlag())?"湿热质 ":"";
    	mainStr +=  "1".equals(identification.getBloodFlag())?"血瘀质 ":"";
    	mainStr +=  "1".equals(identification.getQiStagnationFlag())?"气郁质 ":"";
    	mainStr +=  "1".equals(identification.getSpecialFlag())?"特禀质 ":"";
    	mainStr +=  "1".equals(identification.getPeacefulFlag())?"平和质 ":"";
    	
    	tendencyStr +=  "3".equals(identification.getQiFlag())?"气虚质 ":"";
    	tendencyStr +=  "3".equals(identification.getYangFlag())?"阳虚质 ":"";
    	tendencyStr +=  "3".equals(identification.getYinDeficiencyFlag())?"阴虚质 ":"";
    	tendencyStr +=  "3".equals(identification.getPhlegmWetnessFlag())?"痰湿质 ":"";
    	tendencyStr +=  "3".equals(identification.getHeatMediumFlag())?"湿热质 ":"";
    	tendencyStr +=  "3".equals(identification.getBloodFlag())?"血瘀质 ":"";
    	tendencyStr +=  "3".equals(identification.getQiStagnationFlag())?"气郁质 ":"";
    	tendencyStr +=  "3".equals(identification.getSpecialFlag())?"特禀质 ":"";
	
    	basicStr +=  "2".equals(identification.getPeacefulFlag())?"平和质 ":"";
    	
    	if(StringUtil.isNotEmpty(mainStr)){
    		result += "主要是：";
    		result += mainStr + "  ";
    	}
    	if(StringUtil.isNotEmpty(tendencyStr)){
    		result += "倾向是:";
    		result += tendencyStr + "  ";
    	}
    	if(StringUtil.isNotEmpty(basicStr)){
    		result += "基本是:";
    		result += basicStr;
    	}    	
    	return result;
    }
}
