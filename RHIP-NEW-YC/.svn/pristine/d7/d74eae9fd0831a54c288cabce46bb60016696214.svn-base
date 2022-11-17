package com.founder.rhip.cdm.service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * icd10相关
 * @author liuk
 *
 */
@Component
public class DmIcdTenUtil {
	private Map<String, String> icd10DisTypeMap = new HashMap<>();

	private final static String SEPARATOR = "|";

	public DmIcdTenUtil() {
		// 高血压
		icd10DisTypeMap.put(EHRConstants.DM_HBP_TYPE + SEPARATOR + "1", "I10.x00");// 原发
		icd10DisTypeMap.put(EHRConstants.DM_HBP_TYPE + SEPARATOR + "2", "E10.900");// 继发性高血压

		// 糖尿病
		icd10DisTypeMap.put(EHRConstants.DM_DI_TYPE + SEPARATOR + "1", "I15.900");// 1型糖尿病
		icd10DisTypeMap.put(EHRConstants.DM_DI_TYPE + SEPARATOR + "2", "E11.900");// 2型糖尿病
		icd10DisTypeMap.put(EHRConstants.DM_DI_TYPE + SEPARATOR + "3", "O24.900");// 妊娠期糖尿病
		icd10DisTypeMap.put(EHRConstants.DM_DI_TYPE + SEPARATOR + "4", "E13.900"); // 其他特殊类型
		// 冠心病
		icd10DisTypeMap.put(EHRConstants.DM_CORONARY_TYPE + SEPARATOR + "1", "I21.900");// 急性心梗
		icd10DisTypeMap.put(EHRConstants.DM_CORONARY_TYPE + SEPARATOR + "2", "I20.900"); // 心绞痛
		icd10DisTypeMap.put(EHRConstants.DM_CORONARY_TYPE + SEPARATOR + "3", "I25.900"); // 冠心病猝死
		icd10DisTypeMap.put(EHRConstants.DM_CORONARY_TYPE + SEPARATOR + "4", "I25.902"); // 其他
		// 脑卒中
		icd10DisTypeMap.put(EHRConstants.DM_STROKE_TYPE + SEPARATOR + "1", "I61.900"); // 脑出血
		icd10DisTypeMap.put(EHRConstants.DM_STROKE_TYPE + SEPARATOR + "2", "I63.900"); // 脑梗塞
		icd10DisTypeMap.put(EHRConstants.DM_STROKE_TYPE + SEPARATOR + "3", "I60.900"); // 蛛网膜下腔出血
		icd10DisTypeMap.put(EHRConstants.DM_STROKE_TYPE + SEPARATOR + "4", "I64.x00");// 未分类

	}

	public String getCode(String disType, String subDistype) {
		if (ObjectUtil.isNotEmpty(disType) && ObjectUtil.isNotEmpty(subDistype)) {
			return icd10DisTypeMap.get(disType + SEPARATOR + subDistype);
		}
		return "";
	}
}
