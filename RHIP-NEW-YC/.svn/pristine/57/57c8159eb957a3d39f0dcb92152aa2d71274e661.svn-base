package com.founder.rhip.ph.service.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.OccupationDiseaseReport;
import com.founder.rhip.ehr.entity.control.oh.OhCompanyInfo;
import com.founder.rhip.ehr.entity.control.oh.OhEmployeeInfo;
import com.founder.rhip.mdm.entity.Organization;

public interface IOccPatientService {

	/**
	 * 查询职业病病人档案 分页
	 * 
	 * @param Criteria
	 * @param Page
	 * @return PageList<OhEnterpriseInfo>
	 */
	public PageList<OhEmployeeInfo> searchEmployeeInfoList(Criteria criteria,
                                                           Page page);

	/**
	 * 保存职业病病人档案信息
	 *
	 * @param OhEmployeeInfo
	 * @return Boolean
	 */
	//public Boolean saveEmployeeInfo(OhEmployeeInfo employeeInfo, String opType);

	public Boolean saveEmployeeInfo(OhEmployeeInfo employeeInfo, String opType, User user, Organization organization) ;

	/**
	 * 查询职业病病人档案
	 *
	 * @param Criteria
	 * @return OhEmployeeInfo
	 */
	public OhEmployeeInfo searchEmployeeInfo(Criteria criteria);

	/**
	 * 保存职业病病人单位信息
	 *
	 * @param OhCompanyInfo
	 * @return Boolean
	 */
	public Boolean saveCompanyInfo(OhCompanyInfo companyInfo, String opType);

	/**
	 * 查询职业病病人单位信息
	 *
	 * @param Criteria
	 * @return OhCompanyInfo
	 */
	public OhCompanyInfo searchCompanyInfo(Criteria criteria);

	/**
	 * 审核职业病病人档案信息
	 *
	 * @param OhEmployeeInfo
	 * @return Boolean
	 */
	public Boolean verifyEmployeeInfo(OhEmployeeInfo employeeInfo, Long[] idArr,
                                      String opType);
	
	/**
	 * 重置职业病病人档案信息为未审核状态
	 * 
	 * @param employeeInfo
	 * @return Boolean
	 */
	public Boolean resetVerifyState(OhEmployeeInfo employeeInfo);


	/**
	 * 查询职业病报卡
	 * @param criteria
	 * @param page
	 * @return
	 */
	public PageList<OccupationDiseaseReport> getOPReportList(Criteria criteria, Page page);

	/**
	 * 查询职业病报卡
	 * @param criteria
	 * @return
	 */
	public OccupationDiseaseReport getOPReport(Criteria criteria);

	/**
	 * 职业病报卡
	 * @param report
	 * @param organization
	 * @return
	 */
	public void saveReport(OccupationDiseaseReport report, OhEmployeeInfo employeeInfo, Organization organization, User user, RoleType role);
	/**
	 * 职业病报卡
	 * @param report
	 * @return
	 */
	public void saveReport(OccupationDiseaseReport report);
}
