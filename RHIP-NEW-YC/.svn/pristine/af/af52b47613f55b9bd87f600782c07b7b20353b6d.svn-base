package com.founder.rhip.ehr.repository.portal;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.OutDoctor;

/**
 * DAO interface of Doctor
 * 
 */
public interface IOutDoctorDao extends IDao<OutDoctor,String> {

	/** 
	* @Title: getScheduleDoctor 
	* @Description: 查询List
	* @param @param criteria
	* @param @return
	* @return List<OutDoctor>
	* @throws 
	*/
	List<OutDoctor> getScheduleDoctor(Criteria criteria);

	/** 
	* @Title: getOutDoctors 
	* @Description: 查询医生的所属医院信息
	* @param @param criteria
	* @param @return
	* @return List<OutDoctor>
	* @throws 
	*/
	List<OutDoctor> getHosInfosByDoctor(Criteria criteria);
	
	List<OutDoctor> getOutHospitals(Criteria criteria);

	List<OutDoctor> getHotDoctors(Criteria criteria);
	
	List<OutDoctor> getHotClinics(Criteria criteria);
	
	List<OutDoctor> getHotEmpTits(Criteria criteria);

	PageList<OutDoctor> showHotDoctors(Page page, String searchContent, Criteria criteria);
	
}