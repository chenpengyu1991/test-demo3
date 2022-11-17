package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.child.*;
import com.founder.rhip.ehr.entity.women.*;
import com.founder.rhip.ehr.repository.child.*;
import com.founder.rhip.ehr.repository.women.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("brwHealthService")
public class BrwHealthServiceImpl extends AbstractService implements IBrwHealthService {
	
	@Resource
	private IPrenatalFollowupDao whPrenatalFollowupDao;
	
	@Resource
	private IBirthCertificateDao chBirthCertificateDao;
	
	@Resource
	private IBirthDefectMonitorDao birthDefectMonitorDao;
	
	@Resource
	private IChildHealthExaminationDao childHealthExaminationDao;
	
	@Autowired
	private IPrenatalFollowupDao prenatalFollowupDao;

	@Autowired
	private IPrenatalFollowupOtherDao prenatalFollowupOtherDao;

	@Autowired
	private IPostnatalFollowupDao postnatalFollowupDao;
	
	@Autowired
	private IPostpartumDaysHealthInfoDao postpartumDaysHealthInfoDao;
	
	@Autowired
	private IDeliveryRecordInfoDao deliveryRecordInfoDao;
	
	@Autowired
	private IPrenatalScreenDiagnosisDao prenatalScreenDiagnosisDao;
	
	@Autowired
	private IBirthControlServiceDao birthControlServiceDao;
	
	@Autowired
	private INeonatalFamilyVisitDao neonatalFamilyVisitDao;
	
	@Autowired
	private INeonatalDiseaseScreenDao neonatalDiseaseScreenDao;
	
	@Autowired
	private IMotherhoodPeriodFollowupDao motherhoodPeriodFollowupDao;
	
	@Autowired
	private IPremaritalHealthServiceDao premaritalHealthServiceDao;
	
	@Autowired
	private IChildHealthCardDao childHealthCardDao;
	
	@Autowired
	private IWomanDiseaseCensusDao womanDiseaseCensusDao;
	
	@Autowired
	private IFrailChildFollowupDao frailChildFollowupDao;
	
    @Autowired
    private IBirthCertificateDao birthCertificateDao; 
    
	@Override
	public List<PrenatalFollowup> getWhPrenatalFollowupList(Criteria criteria) {
		return whPrenatalFollowupDao.getList(criteria);
	}

	@Override
	public PrenatalFollowup getWhPrenatalFollowup(Criteria criteria) {
		return whPrenatalFollowupDao.get(criteria);
	}

	@Override
	public List<BirthCertificate> getChBirthCertificateList(Criteria criteria, String... properties) {
		return chBirthCertificateDao.getList(criteria,properties);
	}

	@Override
	public BirthCertificate getChBirthCertificate(Criteria criteria) {
		return chBirthCertificateDao.get(criteria);
	}

	@Override
	public List<BirthDefectMonitor> getBirthDefectMonitorList(Criteria criteria) {
		return birthDefectMonitorDao.getList(criteria);
	}
	@Override
	public List<BirthDefectMonitor> getBirthDefectMonitorList(Criteria criteria, String... properties) {
		return birthDefectMonitorDao.getList(criteria,new Order("FILL_DATE DESC"),properties);
	}

	@Override
	public BirthDefectMonitor getBirthDefectMonitor(Criteria criteria) {
		return birthDefectMonitorDao.get(criteria);
	}

	@Override
	public List<ChildHealthExamination> getChildHealthAge(Criteria criteria, String[] properties) {
		return childHealthExaminationDao.getList(criteria, properties);
	}

	@Override
	public ChildHealthExamination getChildHealthExam(Criteria criteria) {
		return childHealthExaminationDao.get(criteria);
	}
	
	@Override
	public List<PrenatalFollowup> getPrenatalFollowups(Criteria criteria, String[] properties) {
		return prenatalFollowupDao.getList(criteria, properties);
	}

	@Override
	public List<PrenatalFollowupOther> getPrenatalFollowupOthers(Criteria criteria, String[] properties) {
		return prenatalFollowupOtherDao.getList(criteria, properties);
	}

	@Override
	public List<PrenatalScreenDiagnosis> getPrenatalScreenDiagnosiList(Criteria criteria, String[] properties) {
		return prenatalScreenDiagnosisDao.getList(criteria, new Order("CHECK_DATE DESC"),properties);
	}
	
	@Override
	public PrenatalScreenDiagnosis getPrenatalScreenDiagnosis(Criteria criteria) {
		return prenatalScreenDiagnosisDao.get(criteria);
	}

	@Override
	public PrenatalFollowup getPrenatalFollowup(Criteria criteria) {
		return prenatalFollowupDao.get(criteria);
	}

	@Override
	public PrenatalFollowupOther getPrenatalFollowupOther(Criteria criteria) {
		return prenatalFollowupOtherDao.get(criteria);
	}

	@Override
	public PostnatalFollowup getPostnatalFollowup(Criteria criteria) {
		return postnatalFollowupDao.get(criteria);
	}

	@Override
	public List<PostnatalFollowup> getPostnatalFollowups(Criteria criteria, String[] properties) {
		return postnatalFollowupDao.getList(criteria, properties);
	}
	
	@Override
	public PostpartumDaysHealthInfo getPostpartumDaysHealthInfo(Criteria criteria) {
		return postpartumDaysHealthInfoDao.get(criteria);
	}

	@Override
	public DeliveryRecordInfo getDeliveryRecordInfo(Criteria criteria) {
		return deliveryRecordInfoDao.get(criteria);
	}
	
	@Override
	public BirthControlService getBirthControlService(Criteria criteria) {
		return birthControlServiceDao.get(criteria);
	}

	@Override
	public List<NeonatalFamilyVisit> getNeonatalFamilyVisits(Criteria criteria, String[] properties) {
		return neonatalFamilyVisitDao.getList(criteria, properties);
	}

	@Override
	public NeonatalFamilyVisit getNeonatalFamilyVisit(Criteria criteria) {
		return neonatalFamilyVisitDao.get(criteria);
	}

	@Override
	public NeonatalDiseaseScreen getNeonatalDiseaseScreen(Criteria criteria) {
		return neonatalDiseaseScreenDao.get(criteria);
	}

	@Override
	public List<NeonatalDiseaseScreen> getNeonatalDiseaseScreenList(Criteria criteria, Order order, String[] properties){
		return neonatalDiseaseScreenDao.getList(criteria, order, properties);
	}

	@Override
	public List<MotherhoodPeriodFollowup> getMotherhoodPeriodFollowups(Criteria criteria, String[] properties) {
		return motherhoodPeriodFollowupDao.getList(criteria, properties);
	}

	@Override
	public MotherhoodPeriodFollowup getMotherhoodPeriodFollowup(Criteria criteria) {
		return motherhoodPeriodFollowupDao.get(criteria);
	}

	@Override
	public PremaritalHealthService getPremaritalHealthService(Criteria criteria) {
		return premaritalHealthServiceDao.get(criteria);
	}

	@Override
	public ChildHealthCard getChildHealthCard(Criteria criteria) {
		return childHealthCardDao.get(criteria);
	}

	@Override
	public List<PremaritalHealthService> getPremaritalHealthServices(Criteria criteria, String[] properties){
		return premaritalHealthServiceDao.getList(criteria,new Order("CHECK_DATE DESC"), properties);
	};

	@Override
	public List<WomanDiseaseCensus> getWomanDiseaseCensuses(Criteria criteria, String[] properties) {
		return womanDiseaseCensusDao.getList(criteria,new Order("CHECK_DATE DESC"), properties);
	}

	@Override
	public WomanDiseaseCensus getWomanDiseaseCensus(Criteria criteria) {
		return womanDiseaseCensusDao.get(criteria);
	}

	@Override
	public List<FrailChildFollowup> getFrailChildFollowups(Criteria criteria, Order order, String[] properties) {
		return frailChildFollowupDao.getList(criteria, order, properties);
	}

	@Override
	public FrailChildFollowup getFrailChildFollowup(Criteria criteria) {
		return frailChildFollowupDao.get(criteria);
	}

	@Override
	public BirthCertificate getBirthCertificate(Criteria criteria) {

        List<BirthCertificate> birthCertificates = birthCertificateDao.getList(criteria);
        if (ObjectUtil.isNotEmpty(birthCertificates)) {
            return birthCertificates.get(0);
        }
        return null;
    
	}
}