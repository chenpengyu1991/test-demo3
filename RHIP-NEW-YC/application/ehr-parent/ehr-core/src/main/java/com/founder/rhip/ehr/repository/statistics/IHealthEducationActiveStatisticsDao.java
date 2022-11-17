package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.entity.healtheducation.HeActive;

import java.util.List;
import java.util.Map;


public interface IHealthEducationActiveStatisticsDao extends IDao<HeActive, Long> {
	

	/**
	 * 统计指标
	 * @param criteria 查询条件
	 * @return
	 */
	public Float getHETarget(Criteria criteria, String targetCode);
	
	/**
	 * 播放音像数量数 
	 * @param criteria 查询条件
	 * @return
	 */
	public Integer[] getHealthVideoQuantity(Criteria criteria);
	
	/**
	 * 公众健康咨询次数
	 * @param criteria 查询条件
	 * @return
	 */
	public Integer[] getConsultQuantity(Criteria criteria);
	
	/**
	 * 健康知识讲座次数
	 * @param criteria 查询条件
	 * @return
	 */
	public Integer[] getLectureQuantity(Criteria criteria);
	
	/**
	 * 其他健康教育活动数
	 * @param criteria 查询条件
	 * @return
	 */
	public Integer[] getOtherActiveQuantity(Criteria criteria);
	
	/**
	 * 设置宣传栏数
	 * @param criteria 查询条件
	 * @return
	 */
	public Integer getBulletinBoardQuantity(Criteria criteria);
	
	/**
	 * 宣传栏更新次数
	 * @param criteria 查询条件
	 * @return
	 */
	public Integer getBulletinBoardUseQuantity(Criteria criteria);
	
	/**
	 * 发放健康教育印刷资料
	 * @param criteria 查询条件
	 * @return
	 */
	public Map<String, Object> getMaterialDistributionQuantity(Criteria criteria);

	/**
	 * 中医健康教育处方及资料数
	 * @param criteria 查询条件
	 * @return
	 */
	public Map<String, Object> getPrescriptionQuantity(Criteria criteria);

	public List<HealthEducationReport> getEduCensusList(Criteria criteria);
}
