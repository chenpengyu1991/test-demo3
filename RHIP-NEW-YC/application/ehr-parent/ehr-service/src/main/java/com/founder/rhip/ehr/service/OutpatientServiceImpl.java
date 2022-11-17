/**
/* * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.OutpatientReportDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IDiseaseDiagnosisInfoDao;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.IOutpatientPrescriptionDao;
import com.founder.rhip.ehr.repository.clinic.IStudyEventDao;

/**
 * 门诊服务
 * @author gaogf
 */
@Service("outpatientService")
public class OutpatientServiceImpl extends AbstractService implements IOutpatientService {

	@Autowired
	private IOutpatientInfoDao outpatientInfoDao;
	
	@Autowired
	private IOutpatientPrescriptionDao outpatientPrescriptionDao;
	
	@Autowired
	private IExamineEventDao examineEventDao; 
	
	@Autowired
	private IStudyEventDao studyEventDao;
	
	@Autowired
	private IDrugUsageDao drugUsageDao;
	
	@Autowired
	private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;
	
	@Autowired
	private IPersonInfoDao personInfoDao;
	
	/**
	 * 数据获取
	 * @param       outpatientReportDTO
	 * @return      OutpatientReportDTO
	 */
	public OutpatientReportDTO saveOutpatientData(OutpatientReportDTO outpatientReportDTO) {
		OutpatientReportDTO result = new OutpatientReportDTO();
		List<OutpatientInfo> outpatientInfoList = outpatientReportDTO.getOutpatientInfoList();
		if(ObjectUtil.isNotEmpty(outpatientInfoList)){
			outpatientInfoDao.batchInsert(outpatientInfoList);
			result.setOutpatientInfoList(outpatientInfoList);
		}
		
		return result;
	}

	/**
	 * 查看门急诊报告
	 * @param       criteria
	 * @return      OutpatientReportDTO
	 */
	public OutpatientReportDTO getOutpatientReport(Criteria criteria) {
		OutpatientReportDTO result = new OutpatientReportDTO();
		OutpatientInfo outpatientInfo = outpatientInfoDao.get(criteria);
		result.setClinicDate(outpatientInfo.getClinicDate());
		result.setClinicOrganName(outpatientInfo.getClinicOrganName());
		result.setMedicalRoomName(outpatientInfo.getMedicalRoomName());
		result.setReportCardTypeCode(outpatientInfo.getReportCardTypeCode());
		List<OutpatientInfo> outpatientInfoList = outpatientInfoDao.getList(criteria);
		result.setOutpatientInfoList(outpatientInfoList);
		OutpatientPrescription outpatientPrescription = outpatientPrescriptionDao.get(criteria);
		ExamineEvent examineEvent = examineEventDao.get(criteria);
		StudyEvent studyEvent = studyEventDao.get(criteria);
		if(ObjectUtil.isNotEmpty(outpatientPrescription)){
			result.setDrug(true);
		}else {
			result.setDrug(false);
		}
		if(ObjectUtil.isNotEmpty(examineEvent)){
			result.setExam(true);
		}else {
			result.setExam(false);
		}
		if(ObjectUtil.isNotEmpty(studyEvent)){
			result.setStydy(true);
		}else {
			result.setStydy(false);
		}
		return result;
	}

	/**
	 * 导出门急诊报告
	 * @return      OutpatientReportDTO
	 */
	public OutpatientReportDTO exportOutpatientReport(Criteria criteria) {
		OutpatientReportDTO result = new OutpatientReportDTO();
		OutpatientInfo outpatientInfo = outpatientInfoDao.get(criteria);
		result.setClinicDate(outpatientInfo.getClinicDate());
		result.setClinicOrganName(outpatientInfo.getClinicOrganName());
		result.setMedicalRoomName(outpatientInfo.getMedicalRoomName());
		result.setReportCardTypeCode(outpatientInfo.getReportCardTypeCode());
		List<OutpatientInfo> outpatientInfoList =outpatientInfoDao.getList(criteria);
		result.setOutpatientInfoList(outpatientInfoList);
		OutpatientPrescription outpatientPrescription = outpatientPrescriptionDao.get(criteria);
		ExamineEvent examineEvent =examineEventDao.get(criteria);
		StudyEvent studyEvent = studyEventDao.get(criteria);
		if(ObjectUtil.isNotEmpty(outpatientPrescription)){
			result.setDrug(true);
		}else {
			result.setDrug(false);
		}
		if(ObjectUtil.isNotEmpty(examineEvent)){
			result.setExam(true);
		}else {
			result.setExam(false);
		}
		if(ObjectUtil.isNotEmpty(studyEvent)){
			result.setStydy(true);
		}else {
			result.setStydy(false);
		}
		return result;
	}

    /**
	 * 处方
	 * @return      OutpatientReportDTO
	 */
	public OutpatientReportDTO getOutpatientDrugDetail(Criteria criteria) {
		OutpatientReportDTO result = new OutpatientReportDTO();
		//BUG0135117
		List<DrugUsage> drugUsageList = drugUsageDao.getList(criteria,new Order("DRUG_TYPE"),"quantityUnit", "quantity","drugUseRouteCode",
				"drugTradeName", "drugGenericName", "drugSpecifications","recordNumber", "drugUseDose", "drugUseDoseUnit", "drugUseDays", "drugUseFrequency");
		if(null != drugUsageList && drugUsageList.size() > 0){
			BigDecimal totalPrice = new BigDecimal(0);//总计
			for (DrugUsage drugUsage : drugUsageList) {
				totalPrice = totalPrice.add(drugUsage.getSubtotal() == null ? BigDecimal.ZERO : drugUsage.getSubtotal()); // 高飞于2013-6-24修改当subTotal为null时异常
			}
			result.setTotalPrice(totalPrice);
			result.setDrugUsageList(drugUsageList);//用药信息
			result.setRecordNumber(drugUsageList.get(0).getRecordNumber()); //处方号
			criteria.remove("drugType");
			List<Map<String, Object>> recordNumnerDrugs = encapsulateDrugUsageByRecordNumber(drugUsageList);
			for(Map<String, Object> map : recordNumnerDrugs) { // 获取每个处方的签名医生
				String redNum = "";
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					redNum = entry.getKey();
				}
				criteria.add("recordNumber", redNum);
				OutpatientPrescription outpatientPrescription = outpatientPrescriptionDao.get(criteria,"prescribeDoctorName");
				if(ObjectUtil.isNotEmpty(outpatientPrescription))
					map.put("recordNumber",outpatientPrescription.getPrescribeDoctorName());
				criteria.remove("recordNumber");
			}
			result.setRecordNumnerDrugs(recordNumnerDrugs);
		}
		criteria.remove("recordNumber");
		OutpatientInfo outpatientInfo = outpatientInfoDao.get(criteria,"gender","age","clinicPeopleName","outpatientNo","clinicDate","medicalRoomName","clinicOrganName");
		if(null != outpatientInfo){
			result.setClinicOrganName(outpatientInfo.getClinicOrganName());
			result.setMedicalRoomName(outpatientInfo.getMedicalRoomName());//科室
			result.setClinicDate(outpatientInfo.getClinicDate());//就诊时间
			result.setOutpatientNo(outpatientInfo.getOutpatientNo());//门诊号
			result.setClinicPeopleName(outpatientInfo.getClinicPeopleName());//姓名
			result.setAge(outpatientInfo.getAge());//年龄
			result.setGender(outpatientInfo.getGender());//性别
		}

		OutpatientPrescription outpatientPrescription = outpatientPrescriptionDao.get(criteria,"prescribeDoctorName");
		if(null != outpatientPrescription){
			result.setPrescribeDoctorName(outpatientPrescription.getPrescribeDoctorName());//开具处方医师姓名
		}

//        criteria.add("diagnosisTypeCode", EHRConstants.DIAGNOSIS_TYPE_OUTPATIENT);
		DiseaseDiagnosisInfo diseaseDiagnosisInfo = diseaseDiagnosisInfoDao.get(criteria,"diagnosisDesc");
		if(null != diseaseDiagnosisInfo && null != diseaseDiagnosisInfo.getDiagnosisDesc()){
			result.setDiagnosisDesc(diseaseDiagnosisInfo.getDiagnosisDesc());//诊断
		}

		result.setEhrId((String)criteria.get("ehrId"));
		Object personIdObj = criteria.get("personId").toString();
		if(ObjectUtil.isNotEmpty(personIdObj)){
			result.setPersonId(Long.parseLong(personIdObj.toString()));
		}


		//TODO 集成数据中没有地址字段
		//目前取基本信息现住址
		criteria = new Criteria();
		criteria.add("id", result.getPersonId());
		PersonInfo personInfo = personInfoDao.get(criteria,"patownShip","pastreet","pahouseNumber");
		if(null != personInfo){
			result.setPatownShip(personInfo.getPatownShip());
			result.setPastreet(personInfo.getPastreet());
			result.setPahouseNumber(personInfo.getPahouseNumber());
		}
		return result;
	}

	/**
	 * 门诊摘要
	 * @param       criteria
	 * @return      OutpatientReportDTO
	 */
	public OutpatientReportDTO getOutpatientReportDetail(Criteria criteria) {
		OutpatientReportDTO result = new OutpatientReportDTO();
		OutpatientInfo outpatientInfo = outpatientInfoDao.get(criteria);
		List<StudyEvent> studyEventList = studyEventDao.getList(criteria);
		DiseaseDiagnosisInfo diseaseDiagnosisInfo = diseaseDiagnosisInfoDao.get(criteria);
		result.setOutpatientInfo(outpatientInfo);
		result.setStudyEventList(studyEventList);
		result.setDiseaseDiagnosisInfo(diseaseDiagnosisInfo);
		return result;
	}
	
	/**
     * 查询门诊登记信息
     * @param page
     * @param criteria
     * @return
     */
	public PageList<OutpatientInfo> getOutpatientInfoList(Page page, Criteria criteria, Order order){
		return outpatientInfoDao.getPageList(page, criteria, order);
	}

	@Override
	public PageList<OutpatientPrescription> getOutpatientPrescriptionList(Page page, Criteria criteria, Order order) {
		return outpatientPrescriptionDao.getOutpatientPrescriptionList(page, criteria, order);
	}

	/**
	 * 根据处方号封装用药，按处方号分组 add by Kevin Ro 2018-11-26
	 * @param list
	 * @return 此处Object为List<DrugUsage>
	 */
	private List<Map<String,Object>> encapsulateDrugUsageByRecordNumber(List<DrugUsage> list) {
		List<Map<String,Object>> result = new ArrayList<>();
		Map<String,String> recordMap = new HashMap<>();
		for(DrugUsage drug : list) {
			recordMap.put(""+drug.getRecordNumber(), drug.getRecordNumber());
		}

		for (Map.Entry<String, String> entry : recordMap.entrySet()) {
			Map<String,Object> map = new HashMap<>();
			List<DrugUsage> temp = null;
			for(DrugUsage drug : list) {
				temp = (List<DrugUsage>)map.get(drug.getRecordNumber());
				if(ObjectUtil.isNullOrEmpty(temp)) {
					temp = new ArrayList<>();
				}
				if(entry.getKey().equals(drug.getRecordNumber())) {
					temp.add(drug);
					map.put(entry.getKey(),temp);
				}
			}
			result.add(map);

		}
		return result;
	}

	@Override
	public PageList<OutpatientInfo> getOutpatientInfoWithIdCard(Page page,
																Criteria criteria, Order order) {
		return outpatientInfoDao.getOutpatientInfoWithIdCard(page, criteria, order);
	}

	@Override
	public PageList<OutpatientInfo> getOutpatientInfoWithIdCard1(Page page,
																 Criteria criteria, Order order) {
		PageList<OutpatientInfo>  outpatientInfoList = outpatientInfoDao.getOutpatientInfoWithIdCard1(page, criteria, order);
		for(OutpatientInfo outpatientInfo : outpatientInfoList.getList()){
			if(ObjectUtil.isNotEmpty(outpatientInfo.getPersonId())){
				PersonInfo personInfo = personInfoDao.get(outpatientInfo.getPersonId());
				if(ObjectUtil.isNotEmpty(personInfo)){
					outpatientInfo.setIdcard(personInfo.getIdcard());;
				}
			}
		}
		return outpatientInfoList;
	}
}