package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Staff;

import java.util.List;
import java.util.Map;

public interface IStaffDao extends IDao<Staff, Long>{

	public void insertStaffLog(String[] properties, String... staffCode);

	public PageList<Staff> getStaffLogs(Page page, String staffCode, String[] properties);

	public Staff getStaffLog(String staffCode, Long updateTime, String[] properties);

	/**
	 * ��ȡ�������µ�ҽ����Ա����
	 * @return
	 */
	public List<Map<String, Object>>  getStaffNumByOrg(Criteria criteria);
	public Long getStaffCount(Criteria criteria);

	/**
	 * 获取医务人员对象 同时获取非兼职的机构
	 * @param criteria
	 * @return
	 */
	public Staff getStaff(Criteria criteria);

	/**
	 * 查询医务人员 关联表staff_org
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<Staff> getStaffPageList(Page page, Criteria criteria);

	/**
	 * 返回不存在user表中的staff
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<Staff> getStaffPageListsNoInUsers(Page page, Criteria criteria);

	/**
	 * 根据医务人员编码和用户编码获取医务人员
	 * @param staffCodes
	 * @param userCodes
	 * @return
	 */
	public List<Staff> getStaffsByUserCode(String staffCodes[], String userCodes[]);

	/**
	 * 获取某一个机构下的所有医务人员包括兼职的
	 * @param criteria
	 * @return
	 */
	public List<Staff> getStaffs(Criteria criteria);
}
