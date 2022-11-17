package com.founder.rhip.hsa.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 报告登记
 * 
 * @author liuk
 * 
 */
public interface IReportRecordService {

	/**
	 * 更新记录
	 * 
	 * @param reportRecord
	 * @param organization
	 * @param user
	 */
	void updateRecord(ReportRecord reportRecord, Organization organization, User user);

	/**
	 * 查看记录
	 * 
	 * @param criteria
	 * @return
	 */
	ReportRecord getRecord(Criteria criteria);

	/**
	 * 获取记录分页列表
	 * 
	 * @param page
	 * @param criteria
	 * @param roleType
	 * @param organization
	 * @return
	 */
	List<ReportRecord> getPagedReportRecords(Page page, Criteria criteria, RoleType roleType, Organization organization);

	/**
	 * 保存记录
	 * 
	 * @param reportRecord
	 * @param organization
	 * @param user
	 * @param role
	 */
	void saveRecord(ReportRecord reportRecord, Organization organization, User user, RoleType role);

	/**
	 * 获取新增用记录
	 * 
	 * @param organization
	 * @param user
	 * @param role
	 * @return
	 */
	ReportRecord addRecord(Organization organization, User user, RoleType role);

	/**
	 * 接收
	 * 
	 * @param id
	 * @param organization
	 * @param user
	 * @param role
	 */
	void receiveReportRecord(Long id, Organization organization, User user, RoleType role);

	/**
	 * 处理
	 * 
	 * @param reportRecord
	 * @param organization
	 * @param user
	 * @param role
	 */
	void dealReportRecord(ReportRecord reportRecord, Organization organization, User user, RoleType role);

	/**
	 * 回访
	 * 
	 * @param reportRecord
	 * @param organization
	 * @param user
	 * @param role
	 */
	void visitReportRecord(ReportRecord reportRecord, Organization organization, User user, RoleType role);

}
