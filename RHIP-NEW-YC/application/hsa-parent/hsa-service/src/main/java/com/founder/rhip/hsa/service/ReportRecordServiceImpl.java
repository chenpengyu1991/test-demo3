package com.founder.rhip.hsa.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;
import com.founder.rhip.ehr.repository.hsa.IReportRecordDao;
import com.founder.rhip.hsa.common.RecordStatus;
import com.founder.rhip.mdm.entity.Organization;

/**
 * @author liuk
 *
 */
@Service("hsaReportRecordService")
public class ReportRecordServiceImpl extends AbstractService implements IReportRecordService {

	@Resource(name = "hasReportRecordDao")
	private IReportRecordDao reportRecordDao;

	private final static String[] UPDATE_PROPERTIES = { "createDate","updateDate", "updateDoctorName", "updateDoctorCode", "updateOrganName", "updateOrganCode", "illegalFlag", "infoTypeCode", "infoContent",
			"discoveryDate","receiveOrganization" };

	@Override
	public List<ReportRecord> getPagedReportRecords(Page page, Criteria criteria, RoleType roleType, Organization organization) {
		Assert.notNull(page, "分页参数不能为空");
		if (null == criteria) {
			criteria = new Criteria();
		}
		addPermissionParam(organization, roleType, criteria);
		PageList<ReportRecord> result = reportRecordDao.getPageList(page, criteria, new Order("UPDATE_DATE", false));
		if (ObjectUtil.isNullOrEmpty(result) || ObjectUtil.isNullOrEmpty(result.getList())) {
			return Collections.emptyList();
		}
		return result.getList();
	}

	private void setInputInfo(boolean update, ReportRecord record, Organization organization, User user) {
		if (!update) {
			record.setCreateOrganCode(organization.getOrganCode());
			record.setCreateDoctorCode(user.getStaffCode() == null ? "" : user.getStaffCode());
			record.setCreateDate(new Date());
			record.setCreateGbcode(organization.getGbCode());
			// 当前最低为中心
			record.setCreateCenterOrganCode(organization.getOrganCode());
		}
		record.setUpdateDate(new Date());
		record.setUpdateDoctorCode(user.getStaffCode() == null ? "" : user.getStaffCode().toString());
		record.setUpdateOrganCode(organization.getOrganCode());
	}

	@Override
	public ReportRecord addRecord(Organization organization, User user, RoleType role) {
		ReportRecord record = new ReportRecord();
		setInputInfo(false, record, organization, user);
		record.setDiscoveryDate(record.getCreateDate());
		return record;
	}

	@Override
	public void saveRecord(ReportRecord reportRecord, Organization organization, User user, RoleType role) {
		setInputInfo(false, reportRecord, organization, user);
		reportRecord.setStatus(RecordStatus.READY.getValue());
		Number reportRecordIdNum = reportRecordDao.generatedKey(reportRecord, "ID", new String[] {});
		Assert.notNull(reportRecordIdNum, "插入报告登记返回id为空");
		reportRecord.setId(reportRecordIdNum.longValue());
	}

	@Override
	public void updateRecord(ReportRecord reportRecord, Organization organization, User user) {
		setInputInfo(true, reportRecord, organization, user);
		if (ObjectUtil.isNullOrEmpty(reportRecord.getCreateDate())) {
			reportRecord.setCreateDate(reportRecord.getDiscoveryDate());
		}
		reportRecordDao.update(reportRecord, UPDATE_PROPERTIES);
	}

	@Override
	public void receiveReportRecord(Long id, Organization organization, User user, RoleType role) {
		Assert.notNull(id, "接收报告id不能为空");
		Parameters parameters = new Parameters("status", RecordStatus.CONFIRMED.getValue());
		//接收时间
		parameters.add("receiveDate", new Date());
		Criteria criteria = new Criteria("id", id);
		recordAppInfo(RecordStatus.CONFIRMED, organization, user);
		reportRecordDao.update(parameters, criteria);
	}

	@Override
	public void dealReportRecord(ReportRecord reportRecord, Organization organization, User user, RoleType role) {
		Assert.notNull(reportRecord, "报告不能为空");

		RecordStatus current = RecordStatus.DEALED;
		// 选择回访,则为待回访
		if ("1".equals(reportRecord.getVisitFlag())) {
			current = RecordStatus.TO_VISIT;
		}
		setInputInfo(true, reportRecord, organization, user);
		reportRecord.setStatus(current.getValue());
		//reportRecord.setDealDate(new Date());
		reportRecordDao.update(reportRecord, "visitFlag", "dealAdvice", "status","dealDate");
		recordAppInfo(current, organization, user);
	}

	@Override
	public void visitReportRecord(ReportRecord reportRecord, Organization organization, User user, RoleType role) {
		Assert.notNull(reportRecord, "报告不能为空");
		RecordStatus current = RecordStatus.VISITED;
		reportRecord.setStatus(current.getValue());
		//reportRecord.setVisitDate(new Date());
		setInputInfo(true, reportRecord, organization, user);
		reportRecordDao.update(reportRecord, "visitAdvice", "status","visitDate");
		recordAppInfo(current, organization, user);
	}

	private void recordAppInfo(RecordStatus recordStatus, Organization organization, User user) {

	}

	@Override
	public ReportRecord getRecord(Criteria criteria) {
		ReportRecord record = reportRecordDao.get(criteria);
		return record;
	}

	/**
	 * 设置权限
	 * @param organization
	 * @param roleType
	 * @param criteria
	 */
	private void addPermissionParam(Organization organization, RoleType roleType, Criteria criteria) {
		if (RoleType.ZX_GLY.equals(roleType)) {
			criteria.add("createOrganCode", organization.getOrganCode());
		} else if (RoleType.ZXDFB.equals(roleType)) {
			criteria.add("receiveOrganization", organization.getOrganCode());
		}
	}
}
