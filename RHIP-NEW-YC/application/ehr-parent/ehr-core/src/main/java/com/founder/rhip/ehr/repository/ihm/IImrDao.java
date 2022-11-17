package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.InpatientMedicalRecord;
import com.founder.rhip.ehr.entity.clinic.OutpatientInfo;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of 综合管理-病案首页
 */
public interface IImrDao extends IDao<InpatientMedicalRecord, Long> {

	/**
	 * 综合管理 病案首页的费用 结果页面
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author huangdan
	 */
	List<Map<String, Object>> getImrFeeList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);

	/**
	 * 综合管理 手术切口 结果页面
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author huangdan
	 */
	List<Map<String, Object>> getIncisionList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);

	/**
	 * 综合管理 诊断符合率分析 结果页面
	 *
	 * @param beginDate
	 * @param endDate
	 * @param genreCode
	 * @param gbCode
	 * @param parentCode
	 * @param organCode
	 * @return
	 * @author huangdan
	 */
	List<Map<String, Object>> getConsistencyList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode);
}