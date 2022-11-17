package com.founder.rhip.ehr.repository.da;

import java.util.Map;

import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.OutpatientPrescription;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of 日常监控
 */
public interface IDailyMonitoringDao extends IDao<DrugUsage, Long> {
	
	/**
	 * 获取异常处方列表
	 *
	 * @param page
	 * @param criteria
	 * @param order
	 * @param monitorIndex
	 * @param paramMap
	 * @return
	 * @note monitorIndex = 1:处方金额
	 * @note monitorIndex = 2:用量
	 * @note monitorIndex = 3:天数
	 * @note monitorIndex = 4:处方品种
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getUnusualPrescriptionList(Page page,Criteria criteria,Order order,String monitorIndex,Map<String,String> paramMap);
	
	/**
	 * 获取医生用药列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getPhysicianDrugList(String patientType,Page page,Criteria criteria);	
	
	/**
	 * 获取医师用药排名列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getMedicationRankingList(String patientType,Page page, Criteria criteria);
	
	/**
	 * 获取药品费用占比列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getDrugCostList(String patientType,Page page, Criteria criteria);	
	
	/**
	 * 获取药品明细列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String,Object>> getDrugDetailList(String patientType,Page page, Criteria criteria);
	
	/**
	 * 获取费用明细列表
	 *
	 * @param patientType
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String,Object>> getItemDetailList(String patientType,Page page, Criteria criteria);	
	
	/**
	 * 获取药品价格监控列表
	 *
	 * @param page
	 * @param criteria
	 * @return
	 * @author Ye jianfei
	 */
	public PageList<Map<String, Object>> getDrugPriceList(Page page, Criteria criteria);
	


}