package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.rhip.ehr.entity.child.*;
import com.founder.rhip.ehr.entity.women.*;

import java.util.List;

public interface IBrwHealthService {
	public List<PrenatalFollowup> getWhPrenatalFollowupList(Criteria criteria);
	
	public PrenatalFollowup getWhPrenatalFollowup(Criteria criteria);
	
	public List<BirthCertificate> getChBirthCertificateList(Criteria criteria, String... properties);
	
	public BirthCertificate getChBirthCertificate(Criteria criteria);
	
	public List<BirthDefectMonitor> getBirthDefectMonitorList(Criteria criteria);

	public List<BirthDefectMonitor> getBirthDefectMonitorList(Criteria criteria, String... properties);
	
	public BirthDefectMonitor getBirthDefectMonitor(Criteria criteria);
	
	/**
	 * 儿童所有的体检年龄
	 * @param criteria
	 * @param properties
	 * @return
	 */
	public List<ChildHealthExamination> getChildHealthAge(Criteria criteria, String[] properties);
	
	/**
	 * 儿童体检详细详细
	 * @param criteria
	 * @return
	 */
	public ChildHealthExamination getChildHealthExam(Criteria criteria);
	
	/**
	 * 第一次产前随访列表
	 * @param criteria
	 * @return
	 */
	public List<PrenatalFollowup> getPrenatalFollowups(Criteria criteria, String[] properties);

	/**
	 * 第2-5次产前随访列表
	 * @param criteria
	 * @return
	 */
	public List<PrenatalFollowupOther> getPrenatalFollowupOthers(Criteria criteria, String[] properties);

	/**
	 * 第一次产前随访详细
	 * @param criteria
	 * @return
	 */
	public PrenatalFollowup getPrenatalFollowup(Criteria criteria);

	/**
	 * 第2-5次产前随访详细
	 * @param criteria
	 * @return
	 */
	public PrenatalFollowupOther getPrenatalFollowupOther(Criteria criteria);
	
	/**
	 * 产后访视列表
	 * @param criteria
	 * @return
	 */
	public List<PostnatalFollowup> getPostnatalFollowups(Criteria criteria, String[] properties);
	
	/**
	 * 产后访视
	 * @param criteria
	 * @return
	 */
	public PostnatalFollowup getPostnatalFollowup(Criteria criteria);
	
	/**
	 * 产后42天健康检查信息
	 * @param criteria
	 * @return
	 */
	public PostpartumDaysHealthInfo getPostpartumDaysHealthInfo(Criteria criteria);
	
	/**
	 * 分娩记录
	 * @param criteria
	 * @return
	 */
	public DeliveryRecordInfo getDeliveryRecordInfo(Criteria criteria);

	 /**
	  * 产前筛查与诊断
	  * @param criteria
	  * @return
	 */
	public List<PrenatalScreenDiagnosis> getPrenatalScreenDiagnosiList(Criteria criteria, String[] properties);
	/**
	  * 产前筛查与诊断
	  * @param criteria
	  * @return
	 */
	public PrenatalScreenDiagnosis getPrenatalScreenDiagnosis(Criteria criteria);
	
	/**
	 * 计划生育技术服务
	 * @param criteria
	 * @return
	 */
	public BirthControlService getBirthControlService(Criteria criteria);
	
	/**
	 * 家庭访视列表
	 * @param criteria
	 * @param properties
	 * @return
	 */
	public List<NeonatalFamilyVisit> getNeonatalFamilyVisits(Criteria criteria, String[] properties);
	
	/**
	 * 家庭访视详细
	 * @param criteria
	 * @return
	 */
	public NeonatalFamilyVisit getNeonatalFamilyVisit(Criteria criteria);
	
	/**
	 * 新生儿疾病筛查
	 * @param criteria
	 * @return
	 */
	public NeonatalDiseaseScreen getNeonatalDiseaseScreen(Criteria criteria);

	/**
	 * 新生儿疾病筛查列表
	 * @param criteria
	 * @return
	 */
	public List<NeonatalDiseaseScreen> getNeonatalDiseaseScreenList(Criteria criteria, Order order, String[] properties);
	
	/**
	 * 孕产期保健服务与高危管理随访 随访时间列表
	 * @param criteria
	 * @param properties
	 * @return
	 */
	public List<MotherhoodPeriodFollowup> getMotherhoodPeriodFollowups(Criteria criteria, String[] properties);
	
	/**
	 * 孕产期保健服务与高危管理随访详细
	 * @param criteria
	 * @param properties
	 * @return
	 */
	public MotherhoodPeriodFollowup getMotherhoodPeriodFollowup(Criteria criteria);

	
	/**
	 * 儿童保健卡
	 * @param criteria
	 * @return
	 */
	public ChildHealthCard getChildHealthCard(Criteria criteria);
	
	/**
	 * 妇女病普查 检查时间 列表
	 * @param criteria
	 * @param properties
	 * @return
	 */
	public List<WomanDiseaseCensus> getWomanDiseaseCensuses(Criteria criteria, String[] properties);
	
	/**
	 * 妇女病普查 详细
	 * @param criteria
	 * @return
	 */
	public WomanDiseaseCensus getWomanDiseaseCensus(Criteria criteria);


	/**
	 * 婚前保健服务列表
	 * @param properties
	 * @return
	 */
	public List<PremaritalHealthService> getPremaritalHealthServices(Criteria criteria, String[] properties);

	/**
	 * 婚前保健服务详情
	 * @param criteria
	 * @return
	 */
	public PremaritalHealthService getPremaritalHealthService(Criteria criteria);

	
	/**
	 * 体弱儿童管理随访 检查时间 列表
	 * @param criteria
	 * @param properties
	 * @return
	 */
	public List<FrailChildFollowup> getFrailChildFollowups(Criteria criteria, Order order, String[] properties);
	
	/**
	 * 体弱儿童管理随访 详细
	 * @param criteria
	 * @return
	 */
	public FrailChildFollowup getFrailChildFollowup(Criteria criteria);

	public BirthCertificate getBirthCertificate(Criteria criteria);
}