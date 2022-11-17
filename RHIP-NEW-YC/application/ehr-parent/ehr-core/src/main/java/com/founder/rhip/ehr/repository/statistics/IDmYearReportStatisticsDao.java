package com.founder.rhip.ehr.repository.statistics;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.statisticsdto.DmYearReport;

/**
 * 慢病年报和肿瘤年报
 * 
 * @author liuk
 * 
 */
public interface IDmYearReportStatisticsDao extends IDao<PersonInfo, Long> {

	/**
	 * 获取慢病性别年报
	 * 
	 * @param criteria
	 * @return
	 */
	List<DmYearReport> getCdYearReportByGenger(Criteria criteria);

	/**
	 * 获取慢病年龄年报
	 * 
	 * @param criteria
	 * @return
	 */
	List<DmYearReport> getCdYearReportByAge(Criteria criteria);

	/**
	 * 获取肿瘤年龄年报
	 * 
	 * @param criteria
	 * @return
	 */
	List<DmYearReport> getTumorYearReportByAge(Criteria criteria);

	/**
	 * 获取肿瘤性别年报
	 * 
	 * @param criteria
	 * @return
	 */
	List<DmYearReport> getTumorYearReportByGenger(Criteria criteria);

	/**
	 * 获取肿瘤死亡年龄年报
	 * 
	 * @param criteria
	 * @return
	 */
	List<DmYearReport> getTumorDeathYearReportByAge(Criteria criteria);

	/**
	 * 获取肿瘤死亡性别年报
	 * 
	 * @param criteria
	 * @return
	 */
	List<DmYearReport> getTumorDeathYearReportByGenger(Criteria criteria);

}
