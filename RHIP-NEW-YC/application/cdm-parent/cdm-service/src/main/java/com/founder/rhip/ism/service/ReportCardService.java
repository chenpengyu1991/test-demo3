package com.founder.rhip.ism.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.common.ApprovalState;
import com.founder.rhip.cdm.service.IUserTask;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.ism.ApprovalInfo;
import com.founder.rhip.ehr.entity.ism.ReportInfo;
import com.founder.rhip.ehr.repository.ism.IApprovalInfoDao;
import com.founder.rhip.ehr.repository.ism.IReportInfoDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 伤害监测
 *
 * @author liuk
 */
@Service("isReportCardService")
public class ReportCardService extends AbstractService implements IReportCardService {
    /**
     * The Approval info dao.
     */
    @Resource
	private IApprovalInfoDao approvalInfoDao;
    /**
     * The Report info dao.
     */
    @Resource
	private IReportInfoDao reportInfoDao;
    /**
     * The Platform service.
     */
    @Resource(name = "platformService")
	private IPlatformService platformService;

    /**
     * The Update properties.
     */
    private String[] updateProperties;


    /**
     * 状态cache
     */
	private static Map<String, String> statusRule = new HashMap<String, String>();
    /**
     * 状态对应task cache
     */
	private static Map<String, IUserTask<ReportInfo>> noteTask = new HashMap<>();

    /**
     * Init void.
     */
    @PostConstruct
	public void init() {
		initRule() ;
	}

	@Override
	@Transactional
	public boolean saveReportCard(ReportInfo reportInfo, RoleType roleType, User user, Organization organization) {
		if (ObjectUtil.isNullOrEmpty(reportInfo)) {
			log.error("报卡信息不全");
			return false;
		}
		//创建或更新健康档案人员信息
		 createOrUpdatePerson(reportInfo, user, organization);
		try {
			reportInfo.setOccurTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(reportInfo.getOccurTimeToString()));
			reportInfo.setInhosDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(reportInfo.getInhosDateToString()));
		} catch (ParseException e) {
			log.error("时间解析错误");
		}
		reportInfo.setReportNo(getReportNumber());
		doSaveReportCard(reportInfo, roleType, user, organization);
		return true;
	}

    /**
     * Create or update person.
     *
     * @param reportInfo the report info
     * @param user the user
     * @param organization the organization
     * @return the string
     */
    private String createOrUpdatePerson(ReportInfo reportInfo, User user, Organization organization) {
		String smpiId = null;
		if(!ObjectUtil.isNullOrEmpty(reportInfo.getIdcard())){
			PersonInfo person = new PersonInfo();
			reportInfoToEhrPersonInfo(reportInfo, person);
			PersonInfo old =platformService.queryPersonalInfo(null, reportInfo.getIdcard());
			if(!ObjectUtil.isNullOrEmpty(old)){
				reportInfo.setSmpiId(old.getSmpiId());
				person.setId(old.getId());
				updatePerson(person,old,user,organization);
			}else{
				String orgcode = organization.getOrganCode();
				String orgName = organization.getOrganName();
				String idcard = user.getIdentityCard();
				String name = user.getName();
				if (ObjectUtil.isNotEmpty(orgcode)) {
					person.setUpdateOrganCode(orgcode);
					person.setInputOrganCode(orgcode);
				}
				if (ObjectUtil.isNotEmpty(orgName)) {
					person.setUpdateOrganName(orgName);
					person.setInputOrganName(orgName);
				}
				if (ObjectUtil.isNotEmpty(idcard)) {
					person.setUpdateIdcard(idcard);
					person.setInputIdcard(idcard);
				}
				if (ObjectUtil.isNotEmpty(name)) {
					person.setUpdateName(name);
					person.setInputName(name);
				}
				Date date = new Date();
				person.setUpdateDate(date);
				person.setInputDate(date);
				smpiId=platformService.createPerson(person, EHRConstants.RETURN_SMPI_ID, false);
				reportInfo.setSmpiId(smpiId);
			}
		}
		return smpiId;
	}

    /**
     * 慢病人员信息属性拷贝到健康档案人员信息
     *
     * @param reportInfo the report info
     * @param personInfo the person info
     */
	private void reportInfoToEhrPersonInfo(ReportInfo reportInfo, PersonInfo personInfo) {
		try {
			personInfo.setIdcard(reportInfo.getIdcard());
			personInfo.setName(reportInfo.getName());
			personInfo.setGender(reportInfo.getGender());
			personInfo.setOccupation(reportInfo.getOccupation());
			personInfo.setEducation(reportInfo.getEducation());
			personInfo.setInputOrganCode(reportInfo.getCreateOrganCode());
			personInfo.setUpdateOrganCode(reportInfo.getUpdateOrganCode());
			personInfo.setInputDate(reportInfo.getCreateDate());
			personInfo.setUpdateDate(reportInfo.getUpdateDate());
		} catch (Exception e) {
			log.error("人员信息获取出错", e);
			throw new RuntimeException("人员信息获取出错", e);
		}
	}

    /**
     * 修改人的信息
     *
     * @param personInfo the person info
     * @param old the old
     * @param user the user
     * @param organization the organization
     */
	private void updatePerson(PersonInfo personInfo, PersonInfo old, User user, Organization organization) {
	
		List<String> updatePros = new ArrayList<>();

		if (decToUpdate(personInfo.getName(), old.getName())) {
			updatePros.add("name");
		}
		
		if (decToUpdate(personInfo.getGender(), old.getGender())) {
			updatePros.add("gender");
		}
		if (decToUpdate(personInfo.getEducation(), old.getEducation())) {
			updatePros.add("education");
		}
		if (decToUpdate(personInfo.getOccupation(), old.getOccupation())) {
			updatePros.add("occupation");
		}
		if (updatePros.size() > 0) {
			// 增加更新信息
			String orgcode = organization.getOrganCode();
			String orgName = organization.getOrganName();
			String idcard = user.getIdentityCard();
			String name = user.getName();
			if (ObjectUtil.isNotEmpty(orgcode)) {
				personInfo.setUpdateOrganCode(orgcode);
				updatePros.add("updateOrganCode");
			}
			if (ObjectUtil.isNotEmpty(orgName)) {
				personInfo.setUpdateOrganName(orgName);
				updatePros.add("updateOrganName");
			}
			if (ObjectUtil.isNotEmpty(idcard)) {
				personInfo.setUpdateIdcard(idcard);
				updatePros.add("updateIdcard");
			}
			if (ObjectUtil.isNotEmpty(name)) {
				personInfo.setUpdateName(name);
				updatePros.add("updateName");
			}

			personInfo.setUpdateDate(new Date());
			updatePros.add("updateDate");
			platformService.updatePersonInfo(personInfo, updatePros.toArray(new String[] {}));
		}
	}

    /**
     * 判断信息是否被修改
     *
     * @param left the left
     * @param right the right
     * @return boolean
     */
	private boolean decToUpdate(Object left, Object right) {
		if (null == left && ObjectUtil.isNotEmpty(right)) {
			return true;
		}
		if (null != left && !left.equals(right)) {
			return true;
		}
		return false;
	}

    /**
     * 创建报卡
     *
     * @param reportInfo the report info
     * @param roleType the role type
     * @param user the user
     * @param organization the organization
     */
	private void doSaveReportCard(ReportInfo reportInfo, RoleType roleType, User user, Organization organization) {
		createReport(reportInfo, roleType, user, organization);
	}

    /**
     * 创建报卡和报卡状态
     *
     * @param reportInfo the report info
     * @param roleType the role type
     * @param user the user
     * @param organization the organization
     */
	private void createReport(ReportInfo reportInfo, RoleType roleType, User user, Organization organization) {

		/** 根据报卡的角色设置初始状态 */
		if (RoleType.ZXMB.equals(roleType)) {
			reportInfo.setStatus(ApprovalState.VERIFIED_FIRST.getValue());
		} else if (RoleType.JKMBK.equals(roleType)) {
			reportInfo.setStatus(ApprovalState.VERIFIED_SECOND.getValue());
		} else {
			reportInfo.setStatus(ApprovalState.READY.getValue());
		}
        reportInfo.setIsDelete(EHRConstants.DELETE_FLG_0);
		reportInfoDao.insert(reportInfo);
	}

	@Override
	@Transactional
	public String appReportCard(ReportInfo reportInfo, RoleType roleType, User user, Organization organization, int flag, ApprovalInfo approvalInfo) {
		Assert.notNull(roleType);
		Assert.notNull(user);
		String op=flag+"";//操作
		//可能需要更新健康档案人员信息
		 createOrUpdatePerson(reportInfo,user,organization);
		//获取当前状态。
		ReportInfo report = reportInfoDao.get(reportInfo.getId());
		String oldStatus = report.getStatus();
		String status = null;
		/** 审核 */
		try {
			reportInfo.setOccurTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(reportInfo.getOccurTimeToString()));
			reportInfo.setInhosDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(reportInfo.getInhosDateToString()));
		} catch (ParseException e) {
			log.error("时间解析错误");
		}
		status = calNextStatusAndExecuteTask(reportInfo, oldStatus, op, roleType,organization,user);
		if (null != status && !oldStatus.equals(status)) {
			reportInfo.setStatus(status);
			reportInfoDao.update(reportInfo, "status");
		}
		approvalInfo.setStatus(reportInfo.getStatus());
		approvalInfoDao.insert(approvalInfo);
		return flag==3?"success":"back";
	}

    /**
     * 计算报卡下一个状态
     *
     * @param reportInfo the report info
     * @param oldStatus the old status
     * @param op the op
     * @param roleType the role type
     * @param organization the organization
     * @param user the user
     * @return string
     */
	private String calNextStatusAndExecuteTask(ReportInfo reportInfo, String oldStatus, String op, RoleType roleType, Organization organization, User user) {
		String status = null;
		String key = buildRuleKey("1", oldStatus, op, roleType.getValue());
		status = statusRule.get(key);
		if (null != status && !status.equals(oldStatus)) {
			IUserTask<ReportInfo> task = noteTask.get(key);
			if (null != task) {
				task.execute(reportInfo, roleType,organization,user);
			}
		}
		return status;
	}

    /**
     * Init rule.
     */
    private void initRule() {

		// 节点任务,当执行到对应节点时,会执行此任务
		IUserTask<ReportInfo> modifyTask = new ModifyReportTask();// 修改

		// 疾病类型
		String reportDisType = "1";

		// 医院上报,防保科审核通过
		addRule(reportDisType, ApprovalState.VERIFIED_FIRST, ApprovalState.READY, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, modifyTask);
		// 慢病科退回,防保科修改后通过
		addRule(reportDisType, ApprovalState.VERIFIED_FIRST, ApprovalState.REJECT, EHRConstants.DM_APPROVE_PASS, RoleType.ZXMB, modifyTask);
		// 医院上报,防保科作废
		addRule(reportDisType, ApprovalState.CANCEL, ApprovalState.READY, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);
		// 慢病科退回,防保科作废
		addRule(reportDisType, ApprovalState.CANCEL, ApprovalState.REJECT, EHRConstants.DM_APPROVE_REJECT, RoleType.ZXMB, null);
		// 慢病科 退回到防保科
		addRule(reportDisType, ApprovalState.REJECT, ApprovalState.VERIFIED_FIRST, EHRConstants.DM_APPROVE_REJECT, RoleType.JKMBK, modifyTask);
		// 慢病科 通过
		addRule(reportDisType, ApprovalState.VERIFIED_SECOND, ApprovalState.VERIFIED_FIRST, EHRConstants.DM_APPROVE_PASS, RoleType.JKMBK, modifyTask);
		List<String> commonProperties = Arrays.asList("hospitalCode","name","gender","age","registration","education","occupation","inhosDate","occurTime",
						"occurReasonCode","occurPalceCode","occurBehaviorCode","intendsCode","natureCode","partCode","severityCode","clinicalDiagnosis",
						"result","updateOrganCode","updateOrganName",
						"updateDoctorCode","updateDoctorName","updateDate","occurReasonOther","occurPlaceOther","occurBehaviorOther","natureOther","partOther",
						"resultOther");
		ArrayList<String> resultList = new ArrayList<>(commonProperties.size());
		resultList.addAll(commonProperties);
		this.updateProperties = resultList.toArray(new String[0]);
	}

    /**
     * 创建一个节点
     *
     * @param type the type
     * @param value the value
     * @param oldStatus the old status
     * @param op the op
     * @param roleType the role type
     * @param task the task
     */
	private static void addRule(String type, ApprovalState value, ApprovalState oldStatus, String op, RoleType roleType, IUserTask<ReportInfo> task) {
		String key = buildRuleKey(type, oldStatus.getValue(), op, roleType.getValue());
		statusRule.put(key, value.getValue());
		if (ObjectUtil.isNotEmpty(task)) {
			noteTask.put(key, task);
		}
	}

    /**
     * make rule key
     * @param type the type
     * @param oldStatus the old status
     * @param op the op
     * @param roleType the role type
     * @return string
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
     */
	private class ModifyReportTask implements IUserTask<ReportInfo> {
		@Override
		public void execute(ReportInfo reportInfo, RoleType roleType, Organization organization, User user) {
			reportInfoDao.update(reportInfo,updateProperties);
		}
	}

    /**
     * 根据当前日期获取报卡编号
     *
     * @return string
     */
	   private String getReportNumber(){
		   String reportNumber = "320581";
		   
		   Date date=new Date();
		   SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss");
		   String time=df.format(date);
		   Long id = reportInfoDao.getCount(new Criteria("REPORT_NO", OP.LIKE,time + "%"), "ID", Long.class);
		   if(ObjectUtil.isNotEmpty(id)){
			   id = id +1;
		   }else {
			   id = 1L;
		   }
		   reportNumber += time;
		   reportNumber += String.format("%04d",id);
		   return reportNumber;
	   }

	@Override
	public PageList<ReportInfo> getReportsInfo(Page page, Criteria criteria) {
		return reportInfoDao.getPageList(page, criteria, new String[]{});
	}

	@Override
	public PageList<ReportInfo> getRepeatCardList(Page page, Criteria criteria,
                                                  String conditions) {
		return reportInfoDao.getRepeatCardList(page, criteria, conditions);
	}

	@Override
	public List<ApprovalInfo> getAppDetailsList(Criteria criteria) {
		return approvalInfoDao.getList(criteria,new Order("ID",false));
	}

    @Override
    public void deleteReport(Long id){
        reportInfoDao.update(new Parameters("isDelete", EHRConstants.DELETE_FLG_1),new Criteria("id",id));
    }
}
