package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.rhip.mdm.entity.Disease;

import java.util.List;

public interface IDiseaseService {
	/**
	 * 查询标准疾病列表
	 * 
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<Disease> getDiseases(Page page, Criteria criteria);

	/**
	 * 查询标准疾病列表
	 * 
	 * @param criteria
	 * @return
	 */
	public List<Disease> queryDiseases(Criteria criteria);

	/**
	 * 查询标准疾病
	 * 
	 * @param diseaseId
	 * @return
	 */
	public Disease getDisease(Long diseaseId);

	/**
	 * 查询标准疾病
	 * 
	 * @param criteria
	 * @return
	 */
	public Disease getDisease(Criteria criteria);

	/**
	 * 查询标准疾病修改历史
	 * 
	 * @param diseaseId
	 * @return
	 */
	public PageList<Disease> getDiseaseLogs(Page page, Long diseaseId);

	/**
	 * 创建标准疾病
	 * 
	 * @param disease
	 */
	public void createDisease(Disease disease);

	/**
	 * 更新标准疾病
	 * 
	 * @param disease
	 */
	public void updateDisease(Disease disease);

	/**
	 * 删除标准疾病
	 * 
	 * @param diseaseId
	 */
	public void deleteDisease(Long diseaseId);

	/**
	 * 改变疾病状态
	 * 
	 * @param diseaseId
	 * @param oldStatus
	 */
	public void changeStatus(Disease disease);

	/**
	 * 查询当前版本
	 * 
	 * @return
	 */
	public Long getCurrentVersion();

	/**
	 * 发布标准药品新版本
	 * 
	 * @return 新版本号
	 */
	public Long publishDiseaseVersion();

	/**
	 * 导入药物数据
	 * 
	 * @param diseaseList
	 * @param fields
	 * @return
	 */
	public int importDiseases(List<Record> diseaseList);

	/**
	 * 查询标准疾病
	 * 
	 * @param criteria
	 * @return
	 */
	public List<Disease> queryDiseasesUseCache(Criteria criteria);

	/**
	 * 通过类目范围获取疾病 默认取缓存
	 * 
	 * @param startCategory
	 * @param endCategory
	 * @return
	 */
	List<Disease> queryDiseasesByCategoryRangeUseCache(String startCategory, String endCategory);

	/**
	 * 通过类目范围获取疾病
	 * 
	 * @param startCategory
	 * @param endCategory
	 * @return
	 */
	List<Disease> queryDiseasesByCategoryRange(String startCategory, String endCategory);

}
