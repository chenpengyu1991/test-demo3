package com.founder.rhip.ehr.repository.control;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;

/**
 * DAO interface of VaccinationInfo
 */
public interface IVaccinationInfoDao extends IDao<VaccinationInfo, String> {

	/**
	 * 
	*/
	List<Map<String,Object>> getCountByOrgCode(Criteria criteria);

    /**
     * 预防接种总人数
     * @param criteria
     * @return
     */
    public int vaccinationNum(Criteria criteria);

    /**
     * 本年接种人数
     * @param criteria
     * @return
     */
    public int vaccinationNumByYear(Criteria criteria);
    
    /**
     * 查询医生接种工作量
     * @param dateStr
     * @return
     */
    List<Map<String, Object>> getVaccinationInfoMapList(String dateStr);
    
    /**
     * 查询机构接种工作量
     * @param dateStr
     * @return
     */
    List<Map<String, Object>> getOrganizationVaccinationMapList(String dateStr);

    List<VaccinationInfo> getDistinctList(Criteria criteria, Order order);
}