package com.founder.rhip.ehr.repository.portal;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.OutClinic;

/**
 * DAO interface of Department
 * 
 */
public interface IOutClinicDao extends IDao<OutClinic,String> {

	List<String> getOutHospitalCode();

	/** 
	* @Title: getOutClinics 
	* @Description: 查询科室
	* @param @param criteria
	* @param @return
	* @return List<OutClinic>
	* @throws 
	*/
	List<OutClinic> getOutClinics(Criteria criteria);
	
	/** 
	* @Title: getOutClinics 
	* @Description: 查询可预约的科室
	* @param @param criteria
	* @param @return
	* @return List<OutClinic>
	* @throws 
	*/
	List<OutClinic> getReserveableClinics(Criteria criteria);

}