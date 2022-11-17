package com.founder.rhip.ehr.repository.portal;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.portal.ReserveRegister;

/**
 * DAO interface of Appointment
 * 
 */
public interface IReserveRegisterDao extends IDao<ReserveRegister,Long> {

	/**
     * 根据机构获取各个科室的预约数
     * @param criteria
     * @return
     */
	public List<ReserveRegister> getRegisterTargetList(Criteria criteria);

	public PageList<ReserveRegister> getResRegByFreContacts(Long accountId,Criteria criteria,
			Page page);
	
	/**
     * 根据用户ID获取所有的预约(包括常用联系人)
     * @param criteria
     * @return
     */
	public List<ReserveRegister> getAllReserve(Long accountId,Criteria criteria);
	
}