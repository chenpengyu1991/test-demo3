package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.Staff;
import com.founder.rhip.mdm.entity.StaffOrg;

import java.util.List;
import java.util.Map;

public interface IStaffService {

	public Staff createStaff(Staff staff);
	
	public Staff createStaffWithSid(Staff staff);
	
	public void createStaffs(List<Map<String, Object>> staffs);
	
	public Staff updateStaff(Staff staff);

	public Staff updateStaff(List<Map<String, Object>> changedValues);
	
	public int deleteStaff(Criteria criteria);
	
	public List<Staff> queryStaff(Criteria criteria);
	
	public PageList<Staff> queryStaff(Page page, Criteria criteria, String... properties);

	public Staff getStaffMain(String smpiId);

	public Staff getStaff(String staffCode);

	public List<Staff> getStaffs(Criteria criteria);

	public List<Staff> getLinkStaffs(String smpiId);

	public PageList<Staff> getStaffLogs(Page page, String staffCode);
	
	public PageList<Staff> getPageStaffs(Page page, Criteria criteria);

	public Staff getStaffLog(String staffCode, Long updateTime);

	public Staff findOldStaff(String organCode, String localId);
	
	public int mergeStaff(List<Staff> staffList, String smpiId);
	
	public int splitStaff(String operator, String... staffCode);

	public Object compareOldStaff(Staff oldStaff, Staff staff);

	public int updateStatus(String staffCode, Integer status);
	
	/**
	 * 获取各个机构下的医务人员数量
	 * @return
	 */
	public Map<String, Long> getStaffNumByOrg(Criteria criteria);

	public Staff getStaff(Criteria criteria);

	/**
	 * 查询医务人员 关联表staff_org
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<Staff> getStaffPageList(Page page, Criteria criteria);

	/**
	 * 获取医务人员和机构的关系表
	 * @param criteria
	 * @return
	 */
	public List<StaffOrg> getStaffOrgList(Criteria criteria);

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
	public List<Staff> getAllStaffs(Criteria criteria);
}
