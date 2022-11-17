package com.founder.rhip.ehr.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.util.ObjectUtil;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.HealthHistoryDTO;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.summary.DiseaseHistory;
import com.founder.rhip.ehr.entity.summary.DrugAllergyHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.ehr.entity.summary.SurgeryHistory;
import com.founder.rhip.ehr.entity.summary.TransBloodHistory;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.summary.IDiseaseHistoryDao;
import com.founder.rhip.ehr.repository.summary.IDrugAllergyHistoryDao;
import com.founder.rhip.ehr.repository.summary.IHospitalizedHistoryDao;
import com.founder.rhip.ehr.repository.summary.ISurgeryHistoryDao;
import com.founder.rhip.ehr.repository.summary.ITransBloodHistoryDao;

@Service("healthHistoryService")
public class HealthHistoryServiceImpl extends AbstractService implements IHealthHistoryService {

	@Resource(name="diseaseHistoryDao")
	private IDiseaseHistoryDao diseaseHistoryDao;

	@Resource(name="surgeryHistoryDao")
	private ISurgeryHistoryDao surgeryHistoryDao;

    @Resource(name="drugAllergyHistoryDao")
	private IDrugAllergyHistoryDao drugAllergyHistoryDao;

    @Resource(name="vaccinationInfoDao")
	private IVaccinationInfoDao vaccinationInfoDao;

    @Resource(name="hospitalizedHistoryDao")
    private IHospitalizedHistoryDao hospitalizedHistoryDao;

    @Resource(name="transBloodHistoryDao")
    private ITransBloodHistoryDao transBloodHistoryDao;

	@Override
	public HealthHistoryDTO getHealthHistory(Criteria criteria) {
		HealthHistoryDTO result = new HealthHistoryDTO();
		Order order = new Order("CONFIRMATION_DATE");
		List<DiseaseHistory> diseaseHistoryList = diseaseHistoryDao.getList(criteria.add(new Criteria("isDelete", OP.NE,1).add(LOP.OR, "isDelete", OP.IS,"NULL")), order,"otherDesc", "confirmationDate", "diseaseCode","diseaseName","ehrId","personId");
		if(null!=diseaseHistoryList&&diseaseHistoryList.size()>1){
			Map<String,DiseaseHistory> map=new LinkedHashMap<>(diseaseHistoryList.size());
			for (DiseaseHistory diseaseHistory : diseaseHistoryList) {
				String code=diseaseHistory.getDiseaseCode();
				DiseaseHistory old=map.get(code);
				if (null==old) {
					map.put(code, diseaseHistory);
				}else{
					if(!"0".equals(diseaseHistory.getEhrId())){
						map.put(code, diseaseHistory);
					}
				}
			}
			diseaseHistoryList=new ArrayList<>(map.values());
		}
		order = new Order("OPS_DATE");
		List<SurgeryHistory> surgeryHistoryList = surgeryHistoryDao.getList(criteria, order, "opsDate", "opsName");
		order = new Order("ID");
		List<DrugAllergyHistory> drugAllergyHistoryList = drugAllergyHistoryDao.getList(criteria, order, "allergensName");

        order = new Order("IN_DATE");
        List<HospitalizedHistory> hospitalizedHistories = hospitalizedHistoryDao.getDistinctList(criteria,order);

        order = new Order("BLOOD_DATE");
        List<TransBloodHistory> transBloodHistories = transBloodHistoryDao.getList(criteria,order,"bloodReason","bloodDate");

        order = new Order("VACCINATION_DATE");
        criteria.add("isDelete", EHRConstants.DELETE_FLG_0);
		List<VaccinationInfo> vaccinationInfoList = vaccinationInfoDao.getDistinctList(criteria, order);

        result.setTransBloodHistories(transBloodHistories);
        result.setHospitalizedHistories(hospitalizedHistories);
        result.setDiseaseHistoryList(diseaseHistoryList);
		result.setDrugAllergyHistoryList(drugAllergyHistoryList);
		result.setSurgeryHistoryList(surgeryHistoryList);
		result.setVaccinationInfoList(vaccinationInfoList);
		return result;
	}
	
	@Override
	public PageList<DiseaseHistory> getDiseaseHistorys(Criteria criteria, Page page) {
		return diseaseHistoryDao.getPageList(page, criteria);
	}

	@Override
	public List<DiseaseHistory> getDiseaseHistorys(Criteria criteria) {
		return diseaseHistoryDao.getList(criteria);
	}

	@Override
	public HealthHistoryDTO getHealthHistory(Criteria criteria, String historyType) {
		HealthHistoryDTO result = new HealthHistoryDTO();
		switch (historyType){
			case "disease":
				//疾病史
				Order order = new Order("CONFIRMATION_DATE");
				Criteria ca = criteria.add(new Criteria("isDelete", OP.NE,1).add(LOP.OR, "isDelete", OP.IS,"NULL"));
				List<DiseaseHistory> diseaseHistoryList = diseaseHistoryDao.getList(ca, order,"otherDesc", "confirmationDate", "diseaseCode","diseaseName","ehrId","personId");
				if(ObjectUtil.isNotEmpty(diseaseHistoryList)){
					Map<String,DiseaseHistory> map=new LinkedHashMap<>(diseaseHistoryList.size());
					for (DiseaseHistory diseaseHistory : diseaseHistoryList) {
						String code=diseaseHistory.getDiseaseCode();
						DiseaseHistory old=map.get(code);
						if (null==old) {
							map.put(code, diseaseHistory);
						}else{
							if(!"0".equals(diseaseHistory.getEhrId())){
								map.put(code, diseaseHistory);
							}
						}
					}
					diseaseHistoryList=new ArrayList<>(map.values());
				}
				result.setDiseaseHistoryList(diseaseHistoryList);
				break;
			case "surgery":
				//手术史
				order = new Order("OPS_DATE");
				List<SurgeryHistory> surgeryHistoryList = surgeryHistoryDao.getList(criteria, order, "opsDate", "opsName");
				result.setSurgeryHistoryList(surgeryHistoryList);
				break;
			case "drugAllergy":
				//过敏史
				order = new Order("ID");
				List<DrugAllergyHistory> drugAllergyHistoryList = drugAllergyHistoryDao.getList(criteria, order, "allergensName");
				result.setDrugAllergyHistoryList(drugAllergyHistoryList);
				break;
			case "vaccinationInfo":
				//接种
				order = new Order("VACCINATION_DATE");
				criteria.add("isDelete", EHRConstants.DELETE_FLG_0);
//				List<VaccinationInfo> vaccinationInfoList = vaccinationInfoDao.getList(criteria, order, "vaccinationDate", "vaccineName");
				List<VaccinationInfo> vaccinationInfoList = vaccinationInfoDao.getDistinctList(criteria, order);
				criteria.remove("isDelete");
				result.setVaccinationInfoList(vaccinationInfoList);
				break;
			case "hospitalized":
				//住院
				order = new Order("IN_DATE");
//				List<HospitalizedHistory> hospitalizedHistories = hospitalizedHistoryDao.getList(criteria,order,"inDate","hosName","inputOrganName");
				List<HospitalizedHistory> hospitalizedHistories = hospitalizedHistoryDao.getDistinctList(criteria,order);
				result.setHospitalizedHistories(hospitalizedHistories);
				break;
			case "transBlood":
				//输血
				order = new Order("BLOOD_DATE");
				List<TransBloodHistory> transBloodHistories = transBloodHistoryDao.getList(criteria,order,"bloodReason","bloodDate");
				result.setTransBloodHistories(transBloodHistories);
				break;
			default:
				break;
		}
		return result;
	}

}
