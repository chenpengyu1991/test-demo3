package com.founder.rhip.fdm.service;

import java.util.*;

import javax.annotation.Resource;

import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.message.MessageSent;
import com.founder.rhip.ehr.repository.ihm.IMessageSentDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.basic.IReportRecordService;
import com.founder.rhip.fdm.ReportStatus;
import com.founder.rhip.fdm.entity.FoodBorneReport;
import com.founder.rhip.fdm.repository.IFoodBorneReportDao;
import com.founder.rhip.mdm.entity.Organization;

/**
 * @author liuk
 *
 */
@Service("foodBorneReportService")
public class FoodBorneReportServiceImpl extends AbstractService implements IFoodBorneReportService {
	@Resource(name = "fdFoodborneReportDao")
	private IFoodBorneReportDao foodBorneReportDao;

	@Resource(name = "reportRecordService")
	private IReportRecordService reportRecordService;

	@Resource(name = "messageSentDao")
	private IMessageSentDao messageSentDao;

	// TODO add update properties
	private static String[] UPDATE_PROPERTIES;

	/**
	 * 状态cache
	 */
	private static Map<String, String> statusRule = new HashMap<String, String>();
	/**
	 * 状态对应task cache
	 */
	private static Map<String, IUserTask<FoodBorneReport>> noteTask = new HashMap<>();

//	@PostConstruct
//	public void init() {
//		initRule();
//	}

	@Override
	public List<FoodBorneReport> getPagedReports(Page page, Criteria criteria, RoleType roleType, Organization organization) {
		Order order = new Order("id",false);
		order.asc("status");
		PageList<FoodBorneReport> pageList = foodBorneReportDao.getPageList(page, criteria, order);
		List<FoodBorneReport> result = null;
		if (null != pageList) {
			result = pageList.getList();
		}
		if (null == result) {
			result = Collections.emptyList();
		}
		return result;
	}

	@Override
	public FoodBorneReport addReport(Organization organization, User user, RoleType role) {
		FoodBorneReport record = new FoodBorneReport();
		setInputInfo(false, record, organization, user);
		return record;
	}

	@Override
	public FoodBorneReport getReport(Long id) {
		Assert.notNull(id);
		FoodBorneReport record = foodBorneReportDao.get(id);
		Assert.notNull(record);
		return record;
	}

	@Override
	@Transactional
	public synchronized String saveReport(FoodBorneReport report, Organization organization, User user, RoleType role) {
		report.setCreateTime(new Date());
		setInputInfo(false, report, organization, user);
		String num_2=foodBorneReportDao.generatedNumGroupByOrg(report.getNo1(),report.getYear());
		report.setNo2(num_2);
		Number reportRecordIdNum = foodBorneReportDao.generatedKey(report, "ID", new String[] {});
		Assert.notNull(reportRecordIdNum, "save error");
		report.setId(reportRecordIdNum.longValue());
		// 更新记录id,外部报卡上报会产生一条记录,此处将更新此记录的状态为上报成功
		if(StringUtil.isNotEmpty(report.getReportRecordId())){
			Long reportRecordId = Long.valueOf(report.getReportRecordId());
			reportRecordService.update(reportRecordId, reportRecordId, EHRConstants.DM_REPORTE_YES);
		}

		//往消息提醒表添加记录 2015/06/15
		MessageSent messageSent = new MessageSent();
		messageSent.setCreateDate(new Date());
		messageSent.setReceivingUnit(organization.getOrganCode());
		messageSent.setType("3");//食源性疾病
		messageSent.setStatus("1");//未提醒
		messageSent.setTitle("食源性疾病报卡");
		messageSent.setCreateOrganCode(organization.getOrganCode());
		messageSentDao.insert(messageSent);

		return num_2;
	}

	@Override
	public void updateReport(FoodBorneReport report, Organization organization, User user) {
		FoodBorneReport old = foodBorneReportDao.get(report.getId());
		Assert.notNull(report, "当前报卡不存在");
		report.setStatus(ReportStatus.FBK_EDIT.getValue());
//		setInputInfo(true, report, organization, user);
		foodBorneReportDao.update(report);
	}

	@Override
	public void updateReport(FoodBorneReport report){
		String status = report.getStatus();
		if("1".equals(status) || "7".equals(status)){//报卡首次填写或修改
			foodBorneReportDao.update(report);
		}else{//报卡被退回更新状态及退回原因
			Parameters param = new Parameters();
			param.add("STATUS", report.getStatus());
			if(StringUtil.isNotEmpty(report.getBackReason())){
				param.add("BACKREASON", report.getBackReason());
			}
			foodBorneReportDao.update(param, new Criteria("ID", report.getId()));
		}
	}

	public  boolean updateReportJyResult(FoodBorneReport report){
		Parameters param = new Parameters();
		param.add("JY_RESULT", report.getJyResult());
		int rs = foodBorneReportDao.update(param, new Criteria("ID", report.getId()));
		if(rs>0)
			return true;
		else
			return false;
	}

	@Override
	@Transactional
	public void appReportCard(String op, FoodBorneReport reportInfo, RoleType roleType, User user, Organization organization) {
//		Assert.notNull(roleType);
//		Assert.notNull(user);
//		FoodBorneReport report = foodBorneReportDao.get(reportInfo.getId());
//		Assert.notNull(report, "当前报卡不存在");
//		String oldStatus = report.getStatus();
//		String status = null;
//		/** 审核 */
//		status = calNextStatusAndExecuteTask(reportInfo, oldStatus, op, roleType);
//
//		if (null != status && !oldStatus.equals(status)) {
//			reportInfo.setStatus(status);
//			foodBorneReportDao.update(reportInfo, "status");
//		}

	}

	/**
	 * 计算报卡下一个状态
	 *
	 * @param reportInfo
	 * @param oldStatus
	 * @param op
	 * @param roleType
	 * @return
	 */
	private String calNextStatusAndExecuteTask(FoodBorneReport reportInfo, String oldStatus, String op, RoleType roleType) {
		String status = null;
		String key = buildRuleKey("1", oldStatus, op, roleType.getValue());
		status = statusRule.get(key);
		if (null != status && !status.equals(oldStatus)) {
			IUserTask<FoodBorneReport> task = noteTask.get(key);
			if (null != task) {
				task.execute(reportInfo, roleType);
			}
		}
		return status;
	}

//	private void initRule() {
//
//		// 节点任务,当执行到对应节点时,会执行此任务
//		IUserTask<FoodBorneReport> modifyTask = new ModifyReportTask();// 修改
//		// 疾病类型
//		String reportDisType = "1";
//
//		// 医院上报,防保科审核通过
//		addRule(reportDisType, ReportStatus.HOSPITAL_VERIFY.getValue(), ReportStatus.NOT_VERIFY.getValue(), ReportOp.YES.getValue(), RoleType.ZX_GLY, modifyTask);
//		addRule(reportDisType, ReportStatus.HOSPITAL_VERIFY.getValue(), ReportStatus.NOT_VERIFY.getValue(), ReportOp.YES.getValue(), RoleType.DDCRBYY, modifyTask);
//		addRule(reportDisType, ReportStatus.HOSPITAL_VERIFY.getValue(), ReportStatus.NOT_VERIFY.getValue(), ReportOp.YES.getValue(), RoleType.ADMIN, modifyTask);
//
//		// 医院上报,防保科审核未通过
//		addRule(reportDisType, ReportStatus.CANCEL.getValue(), ReportStatus.NOT_VERIFY.getValue(), ReportOp.NO.getValue(), RoleType.ZX_GLY, null);
//		addRule(reportDisType, ReportStatus.CANCEL.getValue(), ReportStatus.NOT_VERIFY.getValue(), ReportOp.NO.getValue(), RoleType.DDCRBYY, null);
//		addRule(reportDisType, ReportStatus.CANCEL.getValue(), ReportStatus.NOT_VERIFY.getValue(), ReportOp.NO.getValue(), RoleType.ADMIN, null);
//
//	}

//	/**
//	 * 创建一个节点
//	 *
//	 * @param value
//	 * @param oldStatus
//	 * @param op
//	 * @param roleType
//	 */
//	private static void addRule(String type, String newStatus, String oldStatus, String op, RoleType roleType, IUserTask<FoodBorneReport> task) {
//		String key = buildRuleKey(type, oldStatus, op, roleType.getValue());
//		statusRule.put(key, newStatus);
//		if (ObjectUtil.isNotEmpty(task)) {
//			noteTask.put(key, task);
//		}
//	}

	/**
	 * make rule key
	 *
	 * @param oldStatus
	 * @param op
	 * @param roleType
	 * @return
	 */
	private static String buildRuleKey(String type, String oldStatus, String op, String roleType) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(type).append("|").append(oldStatus).append("|").append(op).append("|").append(roleType);
		return stringBuilder.toString();
	}

	/**
	 * 修改报卡
	 *
	 * @author liuk
	 *
	 */
	private class ModifyReportTask implements IUserTask<FoodBorneReport> {
		@Override
		public void execute(FoodBorneReport reportInfo, RoleType roleType) {
			foodBorneReportDao.update(reportInfo);
		}
	}

	/**
	 * add recoed input and update info
	 *
	 * @param update
	 * @param record
	 * @param organization
	 * @param user
	 */
	private void setInputInfo(boolean update, FoodBorneReport record, Organization organization, User user) {
		if (!update) {
			// input info
		}
		// update info
	}

	@Override
	public List<Map<String, Object>> getSummary(String begin, String end){
		return foodBorneReportDao.getSummary(begin, end);
	}

}
