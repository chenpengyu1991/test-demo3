package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.Disease;

import java.util.List;

public interface IDiseaseApp {
	
	/**
	 * 查询疾病
	 * @param icd10
	 * @return
	 */
	public Disease queryDisease(String icd10);
	
	/**
	 * 查询疾病列表
	 * @param criteria
	 * @return
	 */
	public List<Disease> queryDiseases(Criteria criteria);
	
	/**
	 * 注册疾病
	 * @param medicine
	 * @return
	 */
	public String registDisease(Disease disease) throws CheckException;

	/**
	 * 通过类目范围查询
	 * @param startCategory
	 * @param endCategory
	 * @return
	 */
	List<Disease> queryDiseasesByCategoryRange(String startCategory, String endCategory);

	/**
	 * 根据ICD10精确查找疾病
	 * @param icd10
	 * @return
	 */
	public Disease getDisease(String icd10);
}
