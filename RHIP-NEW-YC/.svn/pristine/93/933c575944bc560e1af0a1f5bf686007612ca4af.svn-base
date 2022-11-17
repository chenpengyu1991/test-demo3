package com.founder.rhip.ehr.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.clinic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.dto.HealthExaminationDTO;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;
import com.founder.rhip.ehr.repository.clinic.IHealthExamQueryDao;
import com.founder.rhip.ehr.repository.clinic.IHealthExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IObservationInfoDao;
import com.founder.rhip.ehr.repository.clinic.IStudyEventDao;

@Service("healthExaminationService")
public class HealthExaminationServiceImpl extends AbstractService implements
		IHealthExaminationService {
	
	@Autowired
	private IHealthExaminationDao healthExaminationDao;
	
	@Autowired
	private IObservationInfoDao observationInfoDao;
	
	@Autowired
	private IExamineEventDao examineEventDao;
	
	@Autowired
	private IExamineDetailDao examineDetailDao;
	
	@Autowired
	private IStudyEventDao studyEventDao;
	
	@Resource(name = "healthExamQueryDao")
	private IHealthExamQueryDao healthExamQueryDao;

	@Override
	public HealthExaminationDTO saveHealthExamination(
			HealthExaminationDTO healthExaminationDTO) {
		HealthExaminationDTO result = new HealthExaminationDTO();
		HealthExamination healthExamination = new HealthExamination();
		result.setHealthExamination(healthExamination);
		return result;
	}

	@Override
	public PageList<HealthExamination> getHealthExamList(Page page, Criteria criteria, Order order) {
		return healthExaminationDao.getPageList(page, criteria, order);
	}

	@Override
	public HealthExamination getHealthExam(Criteria criteria) {
		HealthExamination healthExamination = healthExaminationDao.get(criteria);
		return healthExamination;
	}

	@Override
	public List<ObservationInfo> getObservationInfos(Criteria criteria) {
		List<ObservationInfo> observationInfos = observationInfoDao.getList(criteria);
		return observationInfos;
	}

	@Override
	public List<Map<String, Object>> getExamEvents(Criteria criteria) {
		List<Map<String, Object>> examEvents = examineEventDao.getMapList(criteria);
		return examEvents;
	}

    @Override
    public List<ExamineEvent> getExamEventsList(Criteria criteria) {
        List<ExamineEvent> examEvents = examineEventDao.getList(criteria);
        return examEvents;
    }

	@Override
	public List<ExamineDetail> getExamDetails(Criteria criteria) {
		List<ExamineDetail> examDetails = examineDetailDao.getList(criteria);
		return examDetails;
	}

	@Override
	public List<StudyEvent> getStudyEvents(Criteria criteria) {
		List<StudyEvent> studyEvents = studyEventDao.getList(criteria);
		return studyEvents;
	}

	@Override
	public List<ObservationInfo> getPersonIdAndEhrId(int type) {
		List<ObservationInfo> observationInfos = observationInfoDao.getPersonAndEhrList(type);
		return observationInfos;
	}

	@Override
	public HealthExamination getHealthExamination(String year, Long personId, String type) {
		return healthExaminationDao.getHealthExamination(year, personId, type);
	}

	@Override
	public PageList<HealthExamination> getHealthExams(Page page, Criteria criteria, Order order) {
		return healthExamQueryDao.getHealthExaminations(criteria, page, order);
	}

	@Override
	public PageList<HealthExamination> getAnalyzeHealthExams(Page page, Criteria criteria, Order order) {
		return healthExamQueryDao.getAnalyzeHealthExams(criteria, page, order);
	}

    @Override
    public List<HealthExamination> getHealthExamsList(Criteria criteria, Order order) {
        return healthExaminationDao.getList(criteria,order);
    }
}
