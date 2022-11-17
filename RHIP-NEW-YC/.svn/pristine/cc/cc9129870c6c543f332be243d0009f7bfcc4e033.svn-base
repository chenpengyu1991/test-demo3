package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.CdmParamCode;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.entity.management.DmHighriskPersonInfo;
import com.founder.rhip.ehr.entity.management.DmPotentialPersonInfo;
import com.founder.rhip.ehr.entity.management.DmPotentialPersonParam;
import com.founder.rhip.ehr.entity.summary.FamilyHistory;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IPhysiqueExaminationDao;
import com.founder.rhip.ehr.repository.management.IDmPotentialPersonInfoDao;
import com.founder.rhip.ehr.repository.management.IDmPotentialPersonParamDao;
import com.founder.rhip.ehr.repository.summary.IFamilyHistoryDao;
import com.founder.rhip.ehr.service.basic.IStandParameterCfgService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 潜在患者Service User: Andy Date: 13-3-12 Time: 下午3:33
 */
@Service("cdmCdPreventService")
@TaskBean(description = "慢病潜在人群筛查", cron = "0 0 3 * * ?")
public class CdPreventService extends AbstractService implements ICdPreventService, Task {

	@Resource
	private IStandParameterCfgService standParameterCfgService;

	@Resource
	private IPhysiqueExaminationDao physiqueExaminationDao;

	@Resource
	private IDmPotentialPersonInfoDao dmPotentialPersonInfoDao;

	@Resource
	private IDmPotentialPersonParamDao dmPotentialPersonParamDao;

	@Resource
	private IFamilyHistoryDao familyHistoryDao;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Override
	public List<DmPotentialPersonInfo> getCdPreventList(Criteria criteria) {
		return null;
	}

	@Override
	public DmPotentialPersonInfo getPerson(Criteria criteria) {
		return null;
	}

	@Override
	public boolean cooptationManage(DmHighriskPersonInfo personInfo) {
		return false;
	}

	@Override
	// @Scheduled(cron = "0 0 3 * * ?")
	public void insertPotentialPersonAndParam() {
		Map<String, Object> param = standParameterCfgService.loadRiskFactorModelValues();
		if(ObjectUtil.isNullOrEmpty(param)) {
			return;
		}
		if (dmPotentialPersonParamDao.truncateTable() == true && dmPotentialPersonInfoDao.truncateTable() == true) {
			Iterator it = param.entrySet().iterator();
			Criteria familyHistory = new Criteria();
			Criteria crFirst = new Criteria();
			Criteria crSecondFlag = new Criteria();
			Criteria crSecondFlag1 = new Criteria();
			Criteria crSecondFlag2 = new Criteria();
			Criteria crSecond = new Criteria();

			Criteria cr = new Criteria();
			while (it.hasNext()) {
				Entry obj = (Entry) it.next();
				if (CdmParamCode.SYSTOLIC_BLOOD_PRESSURE.getValue().equals(obj.getKey())) {
					crFirst.add(LOP.OR, "LEFT_SBP", OP.BETWEEN, ((Object[]) obj.getValue()));
				}
				if (CdmParamCode.DIASTOLIC_BLOOD_PRESSURE.getValue().equals(obj.getKey())) {
					crFirst.add(LOP.OR, "LEFT_DBP", OP.BETWEEN, ((Object[]) obj.getValue()));
				}
				if (CdmParamCode.SYSTOLIC_BLOOD_PRESSURE.getValue().equals(obj.getKey())) {
					crFirst.add(LOP.OR, "RIGHT_SBP", OP.BETWEEN, ((Object[]) obj.getValue()));
				}
				if (CdmParamCode.DIASTOLIC_BLOOD_PRESSURE.getValue().equals(obj.getKey())) {
					crFirst.add(LOP.OR, "RIGHT_DBP", OP.BETWEEN, ((Object[]) obj.getValue()));
				}
				if (CdmParamCode.BLOOD_SUGAR_VALUES.getValue().equals(obj.getKey())) {
					crFirst.add(LOP.OR, "FPG_MMOL", OP.BETWEEN, ((Object[]) obj.getValue()));
				}
				if (CdmParamCode.SERUM_TOTAL_CHOLESTEROL.getValue().equals(obj.getKey())) {
					crFirst.add(LOP.OR, "TC", OP.BETWEEN, ((Object[]) obj.getValue()));
				}
				if (CdmParamCode.MALE_WAISTLINE.getValue().equals(obj.getKey())) {
					Criteria male = new Criteria();
					male.add("GENDER", 1);
					male.add("WAOSTLINE", OP.GE, obj.getValue());
					crFirst.add(LOP.OR, male);
				}
				if (CdmParamCode.FEMALE_MALE_WAISTLINE.getValue().equals(obj.getKey())) {
					Criteria female = new Criteria();
					female.add("GENDER", 2);
					female.add("WAOSTLINE", OP.GE, obj.getValue());
					crFirst.add(LOP.OR, female);
				}
				if (CdmParamCode.SMOKE.getValue().equals(obj.getKey())) {
					crFirst.add(LOP.OR, "SMODE_STATUS_CODE", obj.getValue());
				}

				if (CdmParamCode.AGES.getValue().equals(obj.getKey())) {
					crSecondFlag.add("AGE", OP.BETWEEN, ((Object[]) obj.getValue()));
					familyHistory.add("startAge", ((Object[]) obj.getValue())[0]);
					familyHistory.add("endAge", ((Object[]) obj.getValue())[1]);
				}
				if (CdmParamCode.BMI.getValue().equals(obj.getKey())) {
					crSecondFlag1.add(LOP.OR, "INDEX_OF_BODY_CHARACTERISTICS", OP.GE, obj.getValue());
				}
				if (CdmParamCode.SPORT_TIME.getValue().equals(obj.getKey())) {
					crSecondFlag1.add(LOP.OR, "TRAINING_MIN", OP.LE, obj.getValue());
				}
				if (CdmParamCode.SMOKEING_STATUS.getValue().equals(obj.getKey())) {
					crSecondFlag1.add(LOP.OR, "SMODE_STATUS_CODE", obj.getValue());
				}
				if (CdmParamCode.DRINKING_STATUS.getValue().equals(obj.getKey())) {
					crSecondFlag1.add(LOP.OR, "DRINK_FREQUENCY", obj.getValue());
				}
				if (CdmParamCode.TOTAL_CHOLESTEROL.getValue().equals(obj.getKey())) {
					crSecondFlag1.add(LOP.OR, "TC", OP.BETWEEN, ((Object[]) obj.getValue()));
				}
				if (CdmParamCode.TRIGLYCERIDES.getValue().equals(obj.getKey())) {
					crSecondFlag1.add(LOP.OR, "TRIGLYCERIDE_VALUE", OP.BETWEEN, ((Object[]) obj.getValue()));
				}
				// 家族史
				if (CdmParamCode.FAMILY_HISTORY.getValue().equals(obj.getKey())) {
					String[] objReslut = (String[]) obj.getValue();
					if (objReslut.length == 1) {
						if (((String[]) obj.getValue())[0].equals("1")) {
							familyHistory.add("hbpCode", "0" + ((String[]) obj.getValue())[0]);
						} else if (((String[]) obj.getValue())[0].equals("2")) {
							familyHistory.add("diCode", "0" + ((String[]) obj.getValue())[0]);
						}
					} else {
						familyHistory.add("hbpCode", "0" + ((String[]) obj.getValue())[0]);
						familyHistory.add("diCode", "0" + ((String[]) obj.getValue())[1]);
					}

				}
			}
			crSecondFlag2.add(crSecondFlag);
			crSecondFlag2.add(crSecondFlag1);
			crSecond.add(crSecondFlag2);
			cr.add(LOP.OR, crFirst);
			cr.add(LOP.OR, crSecond);
			it = param.entrySet().iterator();
			// 查询家族史
			List<FamilyHistory> familyHistoryList = familyHistoryDao.getCdmHistoryInfo(familyHistory);
			List<PhysiqueExamination> listpExamination = physiqueExaminationDao.getLastelyPExamination(cr);

			if (!ObjectUtil.isNullOrEmpty(listpExamination)) {
				if (listpExamination.size() > 100) {
					listpExamination = listpExamination.subList(0, 100);
				}
				List<DmPotentialPersonParam> listDmPParam = new ArrayList<DmPotentialPersonParam>();
				List<DmPotentialPersonInfo> listDmPPinfo = new ArrayList<DmPotentialPersonInfo>();
				int flag = listpExamination.size() / 1000;
				int i = 0;
				int k = 0;
				for (PhysiqueExamination pe : listpExamination) {
					String ss = pe.getName();
					k = 0;
					// 设置危险因素人员信息表
					for (int j = 0; j < param.size(); j++) {
						if (it.hasNext()) {
							Entry obj = (Entry) it.next();
							DmPotentialPersonParam dmParam = new DmPotentialPersonParam();
							if (CdmParamCode.SYSTOLIC_BLOOD_PRESSURE.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getLeftSbp())
									&& (pe.getLeftSbp().intValue() >= Integer.valueOf(((String[]) obj.getValue())[0]) && pe.getLeftSbp().intValue() <= Integer.valueOf(((String[]) obj.getValue())[1]))) {
								dmParam.setResultValue(pe.getLeftSbp().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.DIASTOLIC_BLOOD_PRESSURE.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getLeftDbp())
									&& (pe.getLeftDbp().intValue() >= Integer.valueOf(((String[]) obj.getValue())[0]) && pe.getLeftDbp().intValue() <= Integer.valueOf(((String[]) obj.getValue())[1]))) {
								dmParam.setResultValue(pe.getLeftDbp().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.SYSTOLIC_BLOOD_PRESSURE.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getRightSbp())
									&& (pe.getRightSbp().intValue() >= Integer.valueOf(((String[]) obj.getValue())[0]) && pe.getRightSbp().intValue() <= Integer.valueOf(((String[]) obj.getValue())[1]))) {
								dmParam.setResultValue(pe.getRightSbp().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.DIASTOLIC_BLOOD_PRESSURE.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getRightDbp())
									&& (pe.getRightDbp().intValue() >= Integer.valueOf(((String[]) obj.getValue())[0]) && pe.getRightDbp().intValue() <= Integer.valueOf(((String[]) obj.getValue())[1]))) {
								dmParam.setResultValue(pe.getRightDbp().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.SMOKE.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getSmodeStatusCode()) && pe.getSmodeStatusCode().equals(obj.getValue())) {
								dmParam.setResultValue(pe.getSmodeStatusCode());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.BLOOD_SUGAR_VALUES.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getFpgMmol())
									&& (pe.getFpgMmol().floatValue() >= Float.valueOf(((String[]) obj.getValue())[0]) && pe.getFpgMmol().floatValue() < Float.valueOf(((String[]) obj.getValue())[1]))) {
								dmParam.setResultValue(pe.getFpgMmol().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.SERUM_TOTAL_CHOLESTEROL.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getTc())
									&& (pe.getTc().floatValue() >= Float.valueOf(((String[]) obj.getValue())[0]) && pe.getTc().floatValue() < Float.valueOf(((String[]) obj.getValue())[1]))) {
								dmParam.setResultValue(pe.getTc().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.MALE_WAISTLINE.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getWaostline())
									&& (pe.getGender().equals("1") && pe.getWaostline().floatValue() >= Float.valueOf(obj.getValue().toString()))) {
								dmParam.setResultValue(pe.getWaostline().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.FEMALE_MALE_WAISTLINE.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getWaostline())
									&& (pe.getGender().equals("2") && pe.getWaostline().floatValue() >= Float.valueOf(obj.getValue().toString()))) {
								dmParam.setResultValue(pe.getWaostline().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.BMI.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getIndexOfBodyCharacteristics())
									&& (pe.getIndexOfBodyCharacteristics().floatValue() >= Float.valueOf(obj.getValue().toString()))) {
								dmParam.setResultValue(pe.getIndexOfBodyCharacteristics().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.SPORT_TIME.getValue().equals(obj.getKey())) {
								if (!ObjectUtil.isNullOrEmpty(pe.getTrainingMin()) && (pe.getTrainingMin().longValue() <= Integer.valueOf(obj.getValue().toString()))) {
									dmParam.setResultValue(pe.getTrainingMin().toString());
									k++;
									setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
								} else if (ObjectUtil.isNullOrEmpty(pe.getTrainingMin())) {
									dmParam.setResultValue("0");
									k++;
									setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
								}
							}
							if (CdmParamCode.SMOKEING_STATUS.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getSmodeStatusCode())
									&& pe.getSmodeStatusCode().equals(obj.getValue().toString())) {
								dmParam.setResultValue(pe.getSmodeStatusCode().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.DRINKING_STATUS.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getDrinkFrequency())
									&& pe.getDrinkFrequency().equals(obj.getValue().toString())) {
								dmParam.setResultValue(pe.getDrinkFrequency().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.TOTAL_CHOLESTEROL.getValue().equals(obj.getKey()) && !ObjectUtil.isNullOrEmpty(pe.getTc())
									&& (pe.getTc().floatValue() >= Float.valueOf(((String[]) obj.getValue())[0]) && pe.getTc().floatValue() <= Float.valueOf(((String[]) obj.getValue())[1]))) {
								dmParam.setResultValue(pe.getTc().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
							if (CdmParamCode.TRIGLYCERIDES.getValue().equals(obj.getKey())
									&& !ObjectUtil.isNullOrEmpty(pe.getTriglycerideValue())
									&& (pe.getTriglycerideValue().floatValue() >= Float.valueOf(((String[]) obj.getValue())[0]) && pe.getTriglycerideValue().floatValue() <= Float
											.valueOf(((String[]) obj.getValue())[1]))) {
								dmParam.setResultValue(pe.getTriglycerideValue().toString());
								k++;
								setDmPotentialParam(obj, pe, dmParam, listDmPParam, listDmPPinfo, k);
							}
						}
					}
					it = param.entrySet().iterator();
					i++;
					if (listpExamination.size() / 1000 < 1 && i == listpExamination.size() && flag == 0) {
						dmPotentialPersonParamDao.batchInsert(listDmPParam);
					} else if (listpExamination.size() / 1000 > 1 && listDmPParam.size() == 1000) {
						dmPotentialPersonParamDao.batchInsert(listDmPParam);
						listDmPParam.clear();
					} else if (i > flag && listpExamination.size() % 1000 == listDmPParam.size() && flag != 0) {
						dmPotentialPersonParamDao.batchInsert(listDmPParam);
					}

					if (listpExamination.size() / 1000 < 1 && i == listpExamination.size() && flag == 0) {
						dmPotentialPersonInfoDao.batchInsert(listDmPPinfo);
					} else if (listpExamination.size() / 1000 > 1 && listDmPPinfo.size() == 1000) {
						dmPotentialPersonInfoDao.batchInsert(listDmPPinfo);
						listDmPPinfo.clear();
					} else if (i > flag && listpExamination.size() % 1000 == listDmPPinfo.size() && flag != 0) {
						dmPotentialPersonInfoDao.batchInsert(listDmPPinfo);
					}
				}
			}

			if (!ObjectUtil.isNullOrEmpty(familyHistoryList)) {
				if (familyHistoryList.size() > 100) {
					familyHistoryList = familyHistoryList.subList(0, 100);
				}
				List<DmPotentialPersonParam> listDmPParam = new ArrayList<DmPotentialPersonParam>();
				List<DmPotentialPersonInfo> listDmPPinfo = new ArrayList<DmPotentialPersonInfo>();
				for (FamilyHistory familyHistoryTo : familyHistoryList) {
					PersonInfo personInfo = personInfoDao.get(familyHistoryTo.getPersonId());
					DmPotentialPersonParam dmParam = new DmPotentialPersonParam();
					dmParam.setParameterId(CdmParamCode.FAMILY_HISTORY.getValue());
					dmParam.setResultValue(familyHistoryTo.getDiseaseCode());
					dmParam.setPersonId(familyHistoryTo.getPersonId());
					listDmPParam.add(dmParam);
					DmPotentialPersonInfo dPPersonInfo = new DmPotentialPersonInfo();
					dPPersonInfo.setBirthday(familyHistoryTo.getInputDate());
					dPPersonInfo.setIdcard(familyHistoryTo.getIdcard());
					dPPersonInfo.setPersonId(familyHistoryTo.getPersonId());
					dPPersonInfo.setGender(familyHistoryTo.getPatientSex());
					dPPersonInfo.setName(familyHistoryTo.getPatientName());
					dPPersonInfo.setInputOrganCode(personInfo.getInputOrganCode());
					dPPersonInfo.setInputOrganName(personInfo.getInputOrganName());
					listDmPPinfo.add(dPPersonInfo);
				}
				dmPotentialPersonInfoDao.batchInsert(listDmPPinfo);
				dmPotentialPersonParamDao.batchInsert(listDmPParam);
			}

		}
	}

	private void setDmPotentialParam(Entry obj, PhysiqueExamination pe, DmPotentialPersonParam dPparam, List<DmPotentialPersonParam> listPParam, List<DmPotentialPersonInfo> listDmPPinfo, int k) {
		// 设置危险因素参数表属性
		dPparam.setParameterId(obj.getKey().toString());
		dPparam.setPersonId(pe.getPersonId());
		listPParam.add(dPparam);
		PersonInfo personInfo = personInfoDao.get(pe.getPersonId());
		if (k == 1) {
			DmPotentialPersonInfo dPPersonInfo = new DmPotentialPersonInfo();
			// 设置危险因素人员信息表属性
			dPPersonInfo.setName(pe.getName());
			dPPersonInfo.setBirthday(pe.getBirthday());
			dPPersonInfo.setGender(pe.getGender());
			dPPersonInfo.setPersonId(pe.getPersonId());
			if(ObjectUtil.isNotEmpty(personInfo)) {
				dPPersonInfo.setInputOrganCode(personInfo.getInputOrganCode());
				dPPersonInfo.setInputOrganName(personInfo.getInputOrganName());
			}
			listDmPPinfo.add(dPPersonInfo);
		}
	}

	@Override
	public void run(Map<String, Object> data) {
		this.insertPotentialPersonAndParam();
	}
}
