package com.founder.rhip.ehr.repository.statistics;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.common.ElderlyHealthStatisticsType;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;

/**
 * DAO interface of PhysicalExamRecord
 * 
 */
public interface IPhysicalExamRecordDao extends IDao<PhysicalExamRecord,Long> {

	/**
	 * 根据体检前缀查找最大流水号
	 * @param examNoPre
	 * @return
	 */
	String findMaxExamNo(String examNoPre);

	List<Map<String, Object>> getRecordInCurrentYear(List ids, String... properties);
	
	PhysicalExamRecord get(long personId, int year);
	
	Float getHMTarget(Criteria criteria, String targetCode);
	
	/**
	 * 综合管理-老年人保健-管理率
	 *
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public Map<String, Object> getHmTarget(Criteria criteria);

	
	/**
	 * 体质辨识列表
	 *
	 * @param page
	 * @param ca
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<PhysicalExamRecord> getEchPhysicalExams(Page page,Criteria ca);

	/**
	 * 导出体质辨识列表
	 *
	 * @param page
	 * @param ca
	 * @return
	 * @author Ye jianfei
	 */
	public List<Map<String, Object>> exportEchPhysicalExams(Page page,Criteria ca);
	/**
	 * 从已经生成老年人体检报告视图中获取老年人体检信息
	 *
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public Map<String,Object> getPhysicalExam(Criteria criteria);
	
	/**
	 * 老年人体检进度统计
	 * @param paramMap 查询参数
	 * @return
	 */
	List<Map<String, Object>> getPhysicalExamProgressMapList(Map<String, String> paramMap);
	
	/**
	 * 老年人体检进度统计
	 * @param dateStr 日期
	 * @return
	 */
	List<Map<String, Object>> getPhysicalExamMapList(String dateStr);

	PageList<Map<String, Object>> getPersonInfoListMap(List<String> orgCodes, Page page, Criteria criteria,String examinationDateStart,String examinationDateEnd);

	PageList<PhysicalExamRecord> getPhysicalExamRecordList(Page page, List<String> orgCodes, Criteria criteria,String examinationDateStart,String examinationDateEnd);


	List<PhysicalExamRecord> getPhysicalExamRecordList(Criteria criteria, String examinationDateStart, String examinationDateEnd);

    /**
     * 老年人体检进度统计
     * @param criteria 查询参数
     * @return
     */
    List<Map<String, Object>> getPhysicalExamProgressMapList(Criteria criteria);

	/**
	 * Update organ by village
	 * @param inputSuperOrganCode
	 * @param orgCode
	 * @param newAddVillageCodes
	 */
	public void updateOrganByVillage(String inputSuperOrganCode, String orgCode, String[] newAddVillageCodes);
}