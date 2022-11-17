package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.cdm.common.ApprovalState;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.management.*;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 慢病机构合并实现
 * 
 * @author liuk
 * 
 */
@Service("cdmOrganizationMergeListener")
public class OrganizationMergeListener implements IMergerOrganizationListener {
	@Resource(name = "dmDiseaseInfoDao")
	private IDmDiseaseInfoDao dmDiseaseInfoDao;

	@Resource(name = "dmPersonInfoDao")
	private IDmPersonInfoDao dmPersonInfoDao;

	@Resource(name = "dmReportInfoDao")
	private IDmReportInfoDao dmReportInfoDao;

	@Resource(name = "dmHypertensionConclusionDao")
	private IDmHypertensionConclusionDao dmHypertensionConclusionDao;// 保健计划dao

	@Resource(name = "dmHypertensionFollowupDao")
	private IDmHypertensionFollowupDao hypertensionFollowupDao;

	@Resource(name = "dmFollowupPlanDao")
	private IDMFollowupPlanDao followupPlanDao;

	@Resource(name = "dmDiabeticFollowupDao")
	private IDmDiabeticFollowupDao dmDiabeticFollowupDao;

	@Resource(name = "dmTumorFollowupDao")
	private IDmTumorFollowupDao dmTumorFollowupDao;

	@Resource(name = "dmStrtumFollowupDao")
	private IDmStrtumFollowupDao dmStrtumFollowupDao;

	@Resource(name = "cdmApprovalInfoDao")
	private ICdmApprovalInfoDao cdmApprovalInfoDao;

	@Resource
	private IDmHighriskPersonInfoDao dmHighriskPersonInfoDao;

	@Resource
	private IDmHighriskManagePlanDao dmHighriskManagePlanDao;

	@Resource
	private IDmHighriskFollowupDao dmHighriskFollowupDao;

	@Resource
	private IDmHighriskConclusionDao dmHighriskConclusionDao;

	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Override
	@Transactional
	public void mergeStation(Organization newOrganization, List<Organization> stationList) {
		if (ObjectUtil.isNotEmpty(stationList)) {
			checkNewOrganization(newOrganization);
			// 需要变更的机构
			Set<String> oldOrganCodes = new HashSet<>(stationList.size());
			// 目标上级 中心
			String newCenterOrganCode = newOrganization.getParentCode();
			// 跨中心合并的站
			Set<String> changedsSuperOrganCodes = new HashSet<>(stationList.size());
			Set<String> oldSupeOrganCodes = new HashSet<>(stationList.size());
			for (Organization organization : stationList) {
				oldOrganCodes.add(organization.getOrganCode());
				String oldCerterOrganCode = organization.getParentCode();
				oldSupeOrganCodes.add(oldCerterOrganCode);
				if (!newCenterOrganCode.equals(oldCerterOrganCode)) {
					changedsSuperOrganCodes.add(organization.getOrganCode());
				}
			}
			// 更新条件
			Criteria criteria = new Criteria("createOrganCode", OP.IN, oldOrganCodes);
			// 更新字段,站边和站名
			Parameters parameters = new Parameters("createOrganCode", newOrganization.getOrganCode());
			parameters.add("createOrganName", newOrganization.getOrganName());

			// 管理卡
			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[] { "id", "createOrganCode" });
			dmDiseaseInfoDao.update(parameters, criteria);

			// 随访
			hypertensionFollowupDao.update(parameters, criteria);
			dmTumorFollowupDao.update(parameters, criteria);
			dmDiabeticFollowupDao.update(parameters, criteria);
			dmStrtumFollowupDao.update(parameters, criteria);
			// 随访计划
			followupPlanDao.update(parameters, criteria);
			// 保健计划
			dmHypertensionConclusionDao.update(parameters, criteria);

			// 高危人群
//			 dmHighriskConclusionDao.update(parameters, criteria);
//			 dmHighriskFollowupDao.update(parameters, criteria);
//			 dmHighriskManagePlanDao.update(parameters, criteria);

			// 迁移人员基本信息,人员冗余了上级和镇信息,都需要更新
			parameters.add("createCenterOrganCode", newOrganization.getParentCode());// 中心,直接取parentCode因为迁移针只对站
			parameters.add("createGbcode", newOrganization.getGbCode()); // 所在镇

			// 高危人群
//			HistoryRecorder.record(dmHighriskPersonInfoDao, criteria, new String[] { "id", "createOrganCode", "createCenterOrganCode", "createGbcode" });
//			dmHighriskPersonInfoDao.update(parameters, criteria);

			criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
			HistoryRecorder.record(dmPersonInfoDao, criteria, new String[] { "id", "createOrganCode", "createCenterOrganCode", "createGbcode" });
			dmPersonInfoDao.update(parameters, criteria);

			//修改随访医院
			criteria = new Criteria("visitOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("visitOrganCode", newOrganization.getOrganCode());
			parameters.add("visitOrganName", newOrganization.getOrganName());
			hypertensionFollowupDao.update(parameters, criteria);
			dmTumorFollowupDao.update(parameters, criteria);
			dmDiabeticFollowupDao.update(parameters, criteria);
			dmStrtumFollowupDao.update(parameters, criteria);

			//修改随访更新医院
			criteria = new Criteria("updateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("updateOrganCode", newOrganization.getOrganCode());
			parameters.add("updateOrganName", newOrganization.getOrganName());
			hypertensionFollowupDao.update(parameters, criteria);
			dmTumorFollowupDao.update(parameters, criteria);
			dmDiabeticFollowupDao.update(parameters, criteria);
			dmStrtumFollowupDao.update(parameters, criteria);
			followupPlanDao.update(parameters, criteria);

			//转诊机构
			criteria = new Criteria("referralOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("referralOrganCode", newOrganization.getOrganCode());
			dmDiabeticFollowupDao.update(parameters, criteria);
			hypertensionFollowupDao.update(parameters, criteria);

			//修改慢病人员基本信息健康档案管理机构
			criteria = new Criteria("type", EHRConstants.DM_PERSON_MANGE_TYPE);
			criteria.add("inputOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("inputOrganCode", newOrganization.getOrganCode());
			parameters.add("inputOrganName", newOrganization.getOrganName());
//			HistoryRecorder.record(dmPersonInfoDao, criteria, new String[]{"id", "inputOrganName","createOrganCode"});
			dmPersonInfoDao.update(parameters, criteria);

			//修改慢病人员基本信息更新机构
			criteria = new Criteria("type", EHRConstants.DM_PERSON_MANGE_TYPE);
			criteria.add("updateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("updateOrganCode", newOrganization.getOrganCode());
			parameters.add("updateOrganName", newOrganization.getOrganName());
//			HistoryRecorder.record(dmPersonInfoDao, criteria, new String[]{"id", "updateOrganName","updateOrganCode"});
			dmPersonInfoDao.update(parameters, criteria);

			// 报卡更新
			// 更新 分配到的机构 社区站
			Criteria reportCriteria = new Criteria();
			reportCriteria.add("manageOrganCode", OP.IN, oldOrganCodes);
			reportCriteria.add("superManageOrganCode", OP.IN, oldSupeOrganCodes);
			/*HistoryRecorder.record(dmReportInfoDao, reportCriteria, new String[] { "id", "superManageOrganCode", "manageOrganCode", "manageOrganName", "superManageOrganName" });*/
			Parameters reportUpdateParas = new Parameters("manageOrganCode", newOrganization.getOrganCode());
			reportUpdateParas.add("manageOrganName", newOrganization.getOrganName());
			reportUpdateParas.add("superManageOrganCode", newCenterOrganCode);
			Organization centerOrganization = organizationApp.queryOrgan(newCenterOrganCode);
			reportUpdateParas.add("superManageOrganName", centerOrganization.getOrganName());
			dmReportInfoDao.update(reportUpdateParas, reportCriteria);

			//修改保卡填报机构
			criteria = new Criteria("createOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("createOrganCode", newOrganization.getOrganCode());
			parameters.add("createOrganName", newOrganization.getOrganName());
			parameters.add("createCenterOrganCode", newCenterOrganCode);
//			HistoryRecorder.record(dmReportInfoDao, criteria, new String[]{"id", "createOrganName","createOrganCode"});
			dmReportInfoDao.update(parameters, criteria);

			//修改保卡更新机构
			criteria = new Criteria("updateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("updateOrganCode", newOrganization.getOrganCode());
			parameters.add("updateOrganName", newOrganization.getOrganName());
//			HistoryRecorder.record(dmReportInfoDao, criteria, new String[]{"id", "updateOrganCode", "updateOrganName"});
			dmReportInfoDao.update(parameters, criteria);
			//诊断机构
			criteria = new Criteria("diagnosisOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("diagnosisOrganCode", newOrganization.getOrganCode());
			parameters.add("diagnosisOrganName", newOrganization.getOrganName());
//			HistoryRecorder.record(dmReportInfoDao, criteria, new String[]{"id", "diagnosisOrganCode", "diagnosisOrganName"});
			dmReportInfoDao.update(parameters, criteria);

			//死亡上报机构
			criteria = new Criteria("deathReportOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("deathReportOrganCode", newOrganization.getOrganCode());
			//HistoryRecorder.record(dmReportInfoDao, criteria, new String[]{"id", "deathReportOrganCode"});
			dmReportInfoDao.update(parameters, criteria);

			//修改高血压确诊医院
			criteria = new Criteria("hbpDiagnosedOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("hbpDiagnosedOrganCode", newOrganization.getOrganCode());
			parameters.add("hbpDiagnosedOrganName", newOrganization.getOrganName());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "hbpDiagnosedOrganCode", "hbpDiagnosedOrganName"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改糖尿病确诊医院
			criteria = new Criteria("diDiagnosedOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("diDiagnosedOrganCode", newOrganization.getOrganCode());
			parameters.add("diDiagnosedOrganName", newOrganization.getOrganName());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "diDiagnosedOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改高血压填报医院
			criteria = new Criteria("hbpCreateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("hbpCreateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "hbpCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改高血压更新医院
			criteria = new Criteria("hbpUpdateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("hbpUpdateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "hbpUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改糖尿病填报医院
			criteria = new Criteria("diCreateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("diCreateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "diCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改糖尿病更新医院
			criteria = new Criteria("diUpdateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("diUpdateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "diUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改脑卒中填报医院
			criteria = new Criteria("strokeCreateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("strokeCreateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "strokeCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改脑卒中更新医院
			criteria = new Criteria("strokeUpdateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("strokeUpdateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "strokeUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改冠心病填报医院
			criteria = new Criteria("coronaryCreateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("coronaryCreateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "coronaryCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改冠心病更新医院
			criteria = new Criteria("coronaryUpdateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("coronaryUpdateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "coronaryUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改肿瘤填报医院
			criteria = new Criteria("tumorCreateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("tumorCreateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "tumorCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改肿瘤更新医院
			criteria = new Criteria("tumorUpdateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("tumorUpdateOrganCode", newOrganization.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "tumorUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改管理卡更新医院
			criteria = new Criteria("updateOrganCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("updateOrganCode", newOrganization.getOrganCode());
			parameters.add("updateOrganName", newOrganization.getOrganName());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "updateOrganCode", "updateOrganName"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改管理卡历史审核机构
			criteria = new Criteria("orgCode", OP.IN, oldOrganCodes);
			parameters = new Parameters("orgCode", newOrganization.getOrganCode());
			parameters.add("orgName", newOrganization.getOrganName());
			cdmApprovalInfoDao.update(parameters, criteria);
		}
	}

	@Override
	@Transactional
	public void mergeCenter(Organization center, List<Organization> centerList) {
		if (ObjectUtil.isNotEmpty(centerList)) {
			checkNewOrganization(center);
			Set<String> oldCenterOrganCodes = new HashSet<>(centerList.size());
			for (Organization organization : centerList) {
				oldCenterOrganCodes.add(organization.getOrganCode());
			}

			// 更新冗余中心字段
			Criteria criteria = new Criteria("createCenterOrganCode", OP.IN, oldCenterOrganCodes);
			Parameters parameters = new Parameters("createCenterOrganCode", center.getOrganCode());
			// 更新所在镇上级机构
			parameters.add("createGbcode", center.getGbCode());
			HistoryRecorder.record(dmPersonInfoDao, criteria, new String[] { "id", "createCenterOrganCode", "createGbcode" });
			//HistoryRecorder.record(dmHighriskPersonInfoDao, criteria, new String[] { "id", "createCenterOrganCode", "createGbcode" });

			dmHighriskPersonInfoDao.update(parameters, criteria);
			criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
			dmPersonInfoDao.update(parameters, criteria);
			criteria = new Criteria("superManageOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("superManageOrganCode", center.getOrganCode());
			dmReportInfoDao.update(parameters, criteria);
			// 更新条件
			criteria = new Criteria("createOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("createOrganCode", center.getOrganCode());
			parameters.add("createOrganName", center.getOrganName());

			// 管理卡
			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[] { "id", "createOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			// 随访
			hypertensionFollowupDao.update(parameters, criteria);
			dmTumorFollowupDao.update(parameters, criteria);
			dmDiabeticFollowupDao.update(parameters, criteria);
			dmStrtumFollowupDao.update(parameters, criteria);
			// 随访计划
			followupPlanDao.update(parameters, criteria);
			// 保健计划
			dmHypertensionConclusionDao.update(parameters, criteria);
			// 迁移人员基本信息,人员冗余了上级和镇信息,都需要更新
			criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
			HistoryRecorder.record(dmPersonInfoDao, criteria, new String[] { "id", "createOrganCode"});
			dmPersonInfoDao.update(parameters, criteria);

			//修改随访医院
			criteria = new Criteria("visitOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("visitOrganCode", center.getOrganCode());
			parameters.add("visitOrganName", center.getOrganName());
			hypertensionFollowupDao.update(parameters, criteria);
			dmTumorFollowupDao.update(parameters, criteria);
			dmDiabeticFollowupDao.update(parameters, criteria);
			dmStrtumFollowupDao.update(parameters, criteria);

			//修改随访更新医院
			criteria = new Criteria("updateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("updateOrganCode", center.getOrganCode());
			parameters.add("updateOrganName", center.getOrganName());
			hypertensionFollowupDao.update(parameters, criteria);
			dmTumorFollowupDao.update(parameters, criteria);
			dmDiabeticFollowupDao.update(parameters, criteria);
			dmStrtumFollowupDao.update(parameters, criteria);
			followupPlanDao.update(parameters, criteria);

			//转诊机构
			criteria = new Criteria("referralOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("referralOrganCode", center.getOrganCode());
			dmDiabeticFollowupDao.update(parameters, criteria);
			hypertensionFollowupDao.update(parameters, criteria);

			//修改慢病人员基本信息健康档案管理机构
			criteria = new Criteria("type", EHRConstants.DM_PERSON_MANGE_TYPE);
			criteria.add("inputOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("inputOrganCode", center.getOrganCode());
			parameters.add("inputOrganName", center.getOrganName());
			HistoryRecorder.record(dmPersonInfoDao, criteria, new String[]{"id", "createOrganCode"});
			dmPersonInfoDao.update(parameters, criteria);

			//修改慢病人员基本信息更新机构
			criteria = new Criteria("type", EHRConstants.DM_PERSON_MANGE_TYPE);
			criteria.add("updateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("updateOrganCode", center.getOrganCode());
			parameters.add("updateOrganName", center.getOrganName());
			HistoryRecorder.record(dmPersonInfoDao, criteria, new String[]{"id", "createOrganCode"});
			dmPersonInfoDao.update(parameters, criteria);

			// 报卡更新
			// 更新 分配到的机构 社区站
			Criteria reportCriteria = new Criteria();
			reportCriteria.add("manageOrganCode", OP.IN, oldCenterOrganCodes);
			HistoryRecorder.record(dmReportInfoDao, reportCriteria, new String[] { "id", "manageOrganCode" });
			Parameters reportUpdateParas = new Parameters("manageOrganCode", center.getOrganCode());
			reportUpdateParas.add("manageOrganName", center.getOrganName());
			dmReportInfoDao.update(reportUpdateParas, reportCriteria);

			//修改保卡填报机构
			criteria = new Criteria("createOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("createOrganCode", center.getOrganCode());
			parameters.add("createOrganName", center.getOrganName());
			HistoryRecorder.record(dmReportInfoDao, criteria, new String[]{"id", "createOrganCode"});
			dmReportInfoDao.update(parameters, criteria);

			criteria = new Criteria("createCenterOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("createCenterOrganCode", center.getOrganCode());
			dmReportInfoDao.update(parameters, criteria);

			//修改保卡更新机构
			criteria = new Criteria("updateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("updateOrganCode", center.getOrganCode());
			parameters.add("updateOrganName", center.getOrganName());
			HistoryRecorder.record(dmReportInfoDao, criteria, new String[]{"id", "createOrganCode"});
			dmReportInfoDao.update(parameters, criteria);
			//诊断机构
			criteria = new Criteria("diagnosisOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("diagnosisOrganCode", center.getOrganCode());
			parameters.add("diagnosisOrganName", center.getOrganName());
//			HistoryRecorder.record(dmReportInfoDao, criteria, new String[]{"id", "diagnosisOrganCode", "diagnosisOrganName"});
			dmReportInfoDao.update(parameters, criteria);

			//死亡上报机构
			criteria = new Criteria("deathReportOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("deathReportOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmReportInfoDao, criteria, new String[]{"id", "deathReportOrganCode"});
			dmReportInfoDao.update(parameters, criteria);

			//修改高血压确诊医院
			criteria = new Criteria("hbpDiagnosedOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("hbpDiagnosedOrganCode", center.getOrganCode());
			parameters.add("hbpDiagnosedOrganName", center.getOrganName());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "hbpDiagnosedOrganCode", "hbpDiagnosedOrganName"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改糖尿病确诊医院
			criteria = new Criteria("diDiagnosedOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("diDiagnosedOrganCode", center.getOrganCode());
			parameters.add("diDiagnosedOrganName", center.getOrganName());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "diDiagnosedOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改高血压填报医院
			criteria = new Criteria("hbpCreateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("hbpCreateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "hbpCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改高血压更新医院
			criteria = new Criteria("hbpUpdateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("hbpUpdateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "hbpUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改糖尿病填报医院
			criteria = new Criteria("diCreateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("diCreateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "diCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改糖尿病更新医院
			criteria = new Criteria("diUpdateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("diUpdateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "diUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改脑卒中填报医院
			criteria = new Criteria("strokeCreateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("strokeCreateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "strokeCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改脑卒中更新医院
			criteria = new Criteria("strokeUpdateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("strokeUpdateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "strokeUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改冠心病填报医院
			criteria = new Criteria("coronaryCreateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("coronaryCreateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "coronaryCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改冠心病更新医院
			criteria = new Criteria("coronaryUpdateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("coronaryUpdateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "coronaryUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改肿瘤填报医院
			criteria = new Criteria("tumorCreateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("tumorCreateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "tumorCreateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改肿瘤更新医院
			criteria = new Criteria("tumorUpdateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("tumorUpdateOrganCode", center.getOrganCode());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "tumorUpdateOrganCode"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改管理卡更新医院
			criteria = new Criteria("updateOrganCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("updateOrganCode", center.getOrganCode());
			parameters.add("updateOrganName", center.getOrganName());
//			HistoryRecorder.record(dmDiseaseInfoDao, criteria, new String[]{"id", "updateOrganCode", "updateOrganName"});
			dmDiseaseInfoDao.update(parameters, criteria);

			//修改管理卡历史审核机构
			criteria = new Criteria("orgCode", OP.IN, oldCenterOrganCodes);
			parameters = new Parameters("orgCode", center.getOrganCode());
			parameters.add("orgName", center.getOrganName());
			cdmApprovalInfoDao.update(parameters, criteria);

		}
	}

	@Override
	@Transactional
	public void moveStation(Organization center, List<Organization> stationList) {
		if (ObjectUtil.isNotEmpty(stationList)) {
			checkNewOrganization(center);
			Set<String> oldOrganCodes = new HashSet<>(stationList.size());
			Set<String> oldSupeOrganCodes = new HashSet<>(stationList.size());
			for (Organization organization : stationList) {
				oldOrganCodes.add(organization.getOrganCode());
				oldSupeOrganCodes.add(organization.getParentCode());
			}
			// 更新条件
			Criteria criteria = new Criteria("createOrganCode", OP.IN, oldOrganCodes);
			// 更新字段,站边和站名
			Parameters parameters = new Parameters("createCenterOrganCode", center.getOrganCode());// 中心,直接取parentCode因为迁移针只对站
			parameters.add("createGbcode", center.getGbCode()); // 所在镇
			HistoryRecorder.record(dmHighriskPersonInfoDao, criteria, new String[] { "id", "createOrganCode", "createCenterOrganCode", "createGbcode" });
			dmHighriskPersonInfoDao.update(parameters, criteria);

			criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
			HistoryRecorder.record(dmPersonInfoDao, criteria, new String[] { "id", "createOrganCode", "createCenterOrganCode", "createGbcode" });
			dmPersonInfoDao.update(parameters, criteria);

			// 更新条件
			criteria = new Criteria("manageOrganCode", OP.IN, oldOrganCodes);
			criteria.add("superManageOrganCode", OP.IN, oldSupeOrganCodes);
			// 更新字段,站边和站名
			Parameters reportCentreUpdateParas = new Parameters("superManageOrganCode", center.getOrganCode());
			HistoryRecorder.record(dmReportInfoDao, criteria, new String[] { "id", "superManageOrganCode", "manageOrganCode", "createOrganCode" });
			dmReportInfoDao.update(reportCentreUpdateParas, criteria);
		}
	}

	private void checkNewOrganization(Organization organization) {
		Assert.notNull(organization, "目标机构为空");
	}

	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
		Assert.notNull(orgCode, "目标机构编码为空");
		Organization organization = organizationApp.queryOrgan(orgCode);
		Assert.notNull(organization, "目标机构在系统中不存在");
		Assert.notEmpty(newAddVillageCodes, "需要迁移的村编码为空");

		Parameters param = new Parameters("inputOrganCode", orgCode);
		param.add("createOrganCode", orgCode);
		// 更新冗余上级机构
		param.add("createCenterOrganCode", organization.getParentCode());// 中心,直接取parentCode因为迁移针只对站
		param.add("createGbcode", organization.getGbCode()); // 所在镇
		param.add("patownShip", organization.getGbCode()); // 现住址 镇
		Criteria criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);

		// 慢病信息
		dmDiseaseInfoDao.updateOrganByVillage(orgCode, newAddVillageCodes);
		// 报卡更新
		// 更新已经分配的包卡
		dmReportInfoDao.updateOrganByVillage(orgCode, organization.getParentCode(), newAddVillageCodes, ApprovalState.ALLOCATED.getValue());

		// 高危人群
		HistoryRecorder.record(dmHighriskPersonInfoDao, criteria, new String[] { "id", "createOrganCode", "createCenterOrganCode", "createGbcode", "patownShip", "pastreet" });
		dmHighriskPersonInfoDao.update(param, criteria);

		// 慢病人员
		criteria.add("type", EHRConstants.DM_PERSON_MANGE_TYPE);
		HistoryRecorder.record(dmPersonInfoDao, criteria, new String[] { "id", "createOrganCode", "createCenterOrganCode", "createGbcode", "patownShip", "pastreet" });
		dmPersonInfoDao.update(param, criteria);

	}


}
