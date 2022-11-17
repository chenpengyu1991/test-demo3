package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Staff;

/**
 * DAO interface of 医护人员统计
 */
public interface IHRBaseTargetDao extends IDao<Staff, Long> {
	
	/**
	 * 统计医护人员
	 * 
	 * @param organCode
	 * @param superOrganCode
	 * @param gbCode
	 * @return List<Map<String, Object>> 
	 * @author 	chen_wenbo
	 */
	public List<Map<String, Object>> getHealthTargetList(String organCode, String superOrganCode, String gbCode, String genreCode);


    /**
     * 统计医护人员
     *
     */
    public List<Map<String, Object>> getPracticeList(String organCode, String superOrganCode, String gbCode, String genreCode);

	/**
	 * 统计从业分类
	 * @return
	 */
	public Map<String, Object> getStaffCyTypeDate();
	
}