package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.healtheducation.HeActive;


public interface IHealthEducationStatisticsDao extends IDao<HeActive, Long> {
	

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
	 * 发放健康教育印刷资料数量
	 * @param criteria 查询条件
	 * @return
	 */
	public Integer getMaterialDistributionQuantity(Criteria criteria);
}
