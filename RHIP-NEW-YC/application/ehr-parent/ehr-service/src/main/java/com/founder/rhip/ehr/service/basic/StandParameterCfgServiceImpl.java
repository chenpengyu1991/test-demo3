package com.founder.rhip.ehr.service.basic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.founder.rhip.ehr.common.EHRConstants;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.CdmParamCode;
import com.founder.rhip.ehr.common.IntegrationEmailConfig;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.repository.basic.IStandParameterCfgDao;

@Service("standParameterCfgService")
public class StandParameterCfgServiceImpl extends AbstractService implements IStandParameterCfgService {

	@Resource
	private IStandParameterCfgDao standParameterCfgDao;

	@Override
	public List<StandParameterCfg> getStandParameterList(String standardCode) {
		return standParameterCfgDao.getList(new Criteria("STANDARD_CODE",standardCode));
	}

	@Override
	public StandParameterCfg getStandParameterCfg(Criteria criteria) {
		return standParameterCfgDao.get(criteria);
	}

	@Override
	public void saveStandParameter(List<StandParameterCfg> stands) {
		if (ObjectUtil.isNotEmpty(stands)) {
			for (StandParameterCfg standParameterCfg : stands) {
				Criteria ca = new Criteria("STANDARD_CODE",standParameterCfg.getStandardCode());
				ca.add("PARAMETER_CODE",standParameterCfg.getParameterCode());
				StandParameterCfg spc = standParameterCfgDao.get(ca);
				if (ObjectUtil.isNotEmpty(spc)) {
					Parameters parameter = new Parameters("parameterValue", standParameterCfg.getParameterValue());
					standParameterCfgDao.update(parameter, ca);
				} else {
					standParameterCfgDao.insert(standParameterCfg);
				}
			}
		}
	}

	/**
	 * 风险评估模型参数保存
	 * 
	 * @param standParameterCfgList
	 * @return boolean
	 */
	@Override
	public boolean saveRiskFactorModel(List<StandParameterCfg> standParameterCfgList) {
		if (ObjectUtil.isNotEmpty(standParameterCfgList)) {
			for (StandParameterCfg standParameterCfg : standParameterCfgList) {
				StandParameterCfg spc = standParameterCfgDao.get(new Criteria("parameterCode", standParameterCfg.getParameterCode()));
				if (ObjectUtil.isNotEmpty(spc)) {
					// spc.setParameterValue(standParameterCfg.getParameterValue());
					Parameters parameter = new Parameters("parameterValue", standParameterCfg.getParameterValue());
					Criteria criteria = new Criteria("parameterCode", spc.getParameterCode());
					standParameterCfgDao.update(parameter, criteria);
				} else {
					standParameterCfgDao.insert(standParameterCfg);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 风险评估模型信息查看
	 * 
	 * @param
	 * @return boolean
	 */
	@Override
	public Map<String, Object> loadRiskFactorModelValues() {
		Criteria criteria = new Criteria("standardCode", OP.IN, new String[] { CdmParamCode.FIRST_CLASS_STANDARD.getValue(), CdmParamCode.SECOND_CLASS_STANDARD.getValue() });
		List<StandParameterCfg> standParameterCfgList = standParameterCfgDao.getList(new Criteria().add(criteria));
		Map<String, Object> param = new HashMap<String, Object>();
		setArrayCodes();
		for (StandParameterCfg standParameterCfg : standParameterCfgList) {
			if (arrayCodes.contains(standParameterCfg.getParameterCode())) {
				setParamererArray(param, standParameterCfg);
			} else {
				param.put(standParameterCfg.getParameterCode(), standParameterCfg.getParameterValue());
			}
		}
		return param;
	}

	private Set<String> arrayCodes = null;

	private void setArrayCodes() {
		if (null == arrayCodes) {
			arrayCodes = new HashSet<>();
			arrayCodes.add(CdmParamCode.DIASTOLIC_BLOOD_PRESSURE.getValue());
			arrayCodes.add(CdmParamCode.SYSTOLIC_BLOOD_PRESSURE.getValue());
			arrayCodes.add(CdmParamCode.BLOOD_SUGAR_VALUES.getValue());
			arrayCodes.add(CdmParamCode.SERUM_TOTAL_CHOLESTEROL.getValue());
			arrayCodes.add(CdmParamCode.AGES.getValue());
			arrayCodes.add(CdmParamCode.TOTAL_CHOLESTEROL.getValue());
			arrayCodes.add(CdmParamCode.TRIGLYCERIDES.getValue());
			arrayCodes.add(CdmParamCode.FAMILY_HISTORY.getValue());
		}
	}

	private void setParamererArray(Map<String, Object> param, StandParameterCfg standParameterCfg) {
		String value = standParameterCfg.getParameterValue();
		Object targetValue = null;
		if (ObjectUtil.isNotEmpty(value)) {
			targetValue = value.split(",");
		}
		param.put(standParameterCfg.getParameterCode(), targetValue);
	}

	@Override
	public void saveStandParameter(StandParameterCfg standParameterCfg) {
		Criteria criteria = new Criteria("parameterCode", EHRConstants.PARAMETER_CODE_USER);
		criteria.add("standardCode", EHRConstants.STANDARD_CODE_USER);

		StandParameterCfg spc = standParameterCfgDao.get(criteria);
		if (ObjectUtil.isNotEmpty(spc)) {
			Parameters parameter = new Parameters("parameterValue", standParameterCfg.getParameterValue());
			standParameterCfgDao.update(parameter, criteria);
		} else {
			standParameterCfgDao.insert(standParameterCfg);
		}
	}

	@Override
	public void updateStandParameter(String parameterCode, String parameterValue) {
		if (ObjectUtil.isNullOrEmpty(parameterCode) || ObjectUtil.isNullOrEmpty(parameterValue)) {
			return;
		}
		standParameterCfgDao.update(new Parameters("parameterValue", parameterValue), new Criteria("parameterCode", parameterCode));
	}

}
