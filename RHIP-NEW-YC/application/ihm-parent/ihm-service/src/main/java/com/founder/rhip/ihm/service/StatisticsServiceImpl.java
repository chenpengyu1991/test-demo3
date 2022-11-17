package com.founder.rhip.ihm.service;

import javax.annotation.Resource;

import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;
import com.founder.rhip.ehr.repository.clinic.IReadHealthRecordDao;
import com.founder.rhip.ehr.repository.ihm.IHmHospitalizeDao;
import com.founder.rhip.ehr.repository.ihm.IHmOutpatientDao;
import com.founder.rhip.ehr.service.ihm.IStatisticsService;

import java.util.List;
import java.util.Map;

@Service("ihmStatisticsService")
public class StatisticsServiceImpl extends AbstractService implements IStatisticsService {

	@Resource(name = "ihmOutpatientDao")
	private IHmOutpatientDao ihmOutpatientDao;

	@Resource(name = "ihmHospitalizeDao")
	private IHmHospitalizeDao ihmHospitalizeDao;

	@Resource(name = "readHealthRecordDao")
	private IReadHealthRecordDao readHealthRecordDao;

    @Resource(name = "vaccinationInfoDao")
    private IVaccinationInfoDao vaccinationInfoDao;
	
	@Override
	public HmOutpatient statisticsOutpatient(Criteria criteria) {
		return ihmOutpatientDao.statisticsOutpatient(criteria);
	}

	@Override
	public HmHospitalize statisticsHospitalize(Criteria criteria) {
		return ihmHospitalizeDao.statisticsHospitalize(criteria);
	}

	/**
     * 医生使用档案数
     * @param criteria
     * @return
     */
    @Override
    public int countRow(Criteria criteria) {
    	return readHealthRecordDao.countRow(criteria);
    }

    /**
     * 预防接种总人数
     * @param criteria
     * @return
     */
    public int vaccinationNum(Criteria criteria){
        return vaccinationInfoDao.vaccinationNum(criteria);
    }

    /**
     * 本年接种人数
     * @param criteria
     * @return
     */
    public int vaccinationNumByYear(Criteria criteria){
        return vaccinationInfoDao.vaccinationNumByYear(criteria);
    }

    //检验检查分析
	public List<Map<String, Object>> getCheckExamList(Map<String, String> paramMap){
    	return  ihmOutpatientDao.getCheckExamList(paramMap);
	}

	//用药分析
	public List<Map<String, Object>> getDrugUseList(Map<String, String> paramMap){
		return  ihmOutpatientDao.getDrugUseList(paramMap);
	}

}
