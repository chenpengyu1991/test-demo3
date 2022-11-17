package com.founder.rhip.im.service;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.RdRecord;
import com.founder.rhip.ehr.repository.basic.IRdRecordDao;
import com.founder.rhip.im.common.ImConstants;
import com.founder.rhip.im.entity.medical.RdBedDistribution;
import com.founder.rhip.im.entity.medical.RdIncome;
import com.founder.rhip.im.entity.medical.RdInpatientAnalyse;
import com.founder.rhip.im.entity.medical.RdInpatientCompositive;
import com.founder.rhip.im.entity.medical.RdInspectionAnalyse;
import com.founder.rhip.im.entity.medical.RdMedicalQuality;
import com.founder.rhip.im.entity.medical.RdOutpatientAnalyse;
import com.founder.rhip.im.entity.medical.RdOutpatientCompositive;
import com.founder.rhip.im.repository.medical.IRdBedDistributionDao;
import com.founder.rhip.im.repository.medical.IRdEquipmentDao;
import com.founder.rhip.im.repository.medical.IRdHealthResourcesDao;
import com.founder.rhip.im.repository.medical.IRdIncomeDao;
import com.founder.rhip.im.repository.medical.IRdInpatientAnalyseDao;
import com.founder.rhip.im.repository.medical.IRdInpatientCompositiveDao;
import com.founder.rhip.im.repository.medical.IRdInspectionAnalyseDao;
import com.founder.rhip.im.repository.medical.IRdMedicalQualityDao;
import com.founder.rhip.im.repository.medical.IRdOutpatientAnalyseDao;
import com.founder.rhip.im.repository.medical.IRdOutpatientCompositiveDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;

@Service("transPortPersistenceService")
public class TransPortPersistenceServiceImpl implements ITransPortPersistenceService {
	
	private Logger log = Logger.getLogger(getClass());
	
	@Resource(name = "rdOutpatientCompositiveDao")
	private IRdOutpatientCompositiveDao rdOutpatientCompositiveDao;
	
	@Resource(name = "rdOutpatientAnalyseDao")
	private IRdOutpatientAnalyseDao rdOutpatientAnalyseDao;
	
	@Resource(name = "rdInpatientCompositiveDao")
	private IRdInpatientCompositiveDao rdInpatientCompositiveDao;
	
	@Resource(name = "rdInpatientAnalyseDao")
	private IRdInpatientAnalyseDao rdInpatientAnalyseDao;
	
	@Resource(name = "rdIncomeDao")
	private IRdIncomeDao rdIncomeDao;
	
	@Resource(name = "rdInspectionAnalyseDao")
	private IRdInspectionAnalyseDao rdInspectionAnalyseDao;
	
	@Resource(name = "rdMedicalQualityDao")
	private IRdMedicalQualityDao rdMedicalQualityDao;
	
	@Resource(name = "rdHealthResourcesDao")
	private IRdHealthResourcesDao rdHealthResourcesDao;
	
	@Resource(name = "rdEquipmentDao")
	private IRdEquipmentDao rdEquipmentDao;
	
	@Resource(name = "rdBedDistributionDao")
	private IRdBedDistributionDao rdBedDistributionDao;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "rdRecordDao")
	private IRdRecordDao rdRecordDao;
	
	private static final String ORGAN_CODE = "organCode";
	private static final String REPORT_TYPE = "reportType";
	private static final String YEAR_MONTH = "yearMonth";
	private static final String CREATE_DATE = "createDate";
	private static final String UPDATE_DATE = "updateDate";
	private static final String ID = "id";
	
	@Override
	public int persistence(ConvertingWrapDynaBean dynaBean, String dataType, String dataXml) {
		Criteria criteria = new Criteria(ORGAN_CODE, dynaBean.get(ORGAN_CODE))
				.add(REPORT_TYPE, dynaBean.get(REPORT_TYPE))
				.add(YEAR_MONTH, dynaBean.get(YEAR_MONTH));
		
		// 设置上级机构编码和GBCODE
		Organization organization = organizationApp.queryOrgan(String.valueOf(dynaBean.get(ORGAN_CODE)));
		if (StringUtils.equalsIgnoreCase("0", organization.getParentCode())) {
			dynaBean.set("centerCode", dynaBean.get(ORGAN_CODE));
		} else {
			dynaBean.set("centerCode", organization.getParentCode());
		}
		dynaBean.set("gbCode", organization.getGbCode());
		int ret = -1;
		try {
			switch (dataType) {
			case ImConstants.M01: // 门急诊综合
				RdOutpatientCompositive rpc = rdOutpatientCompositiveDao.get(criteria);
				if (ObjectUtil.isNullOrEmpty(rpc)) {
					dynaBean.set(CREATE_DATE, new Date());
					RdOutpatientCompositive rdOutpatientCompositive = (RdOutpatientCompositive) dynaBean.getInstance();
					rdOutpatientCompositiveDao.insert(rdOutpatientCompositive);
					ret = 1;
				} else {
					dynaBean.set(CREATE_DATE, rpc.getCreateDate());
					dynaBean.set(UPDATE_DATE, new Date());
					dynaBean.set(ID, rpc.getId());
					RdOutpatientCompositive rdOutpatientCompositive = (RdOutpatientCompositive) dynaBean.getInstance();
					rdOutpatientCompositiveDao.update(rdOutpatientCompositive);
					ret = 2;
				}
				break;
			case ImConstants.M02:	// 门急诊费用分析
				RdOutpatientAnalyse roa = rdOutpatientAnalyseDao.get(criteria);
				if (ObjectUtil.isNullOrEmpty(roa)) {
					dynaBean.set(CREATE_DATE, new Date());
					RdOutpatientAnalyse rdOutpatientAnalyse = (RdOutpatientAnalyse) dynaBean.getInstance();
					rdOutpatientAnalyseDao.insert(rdOutpatientAnalyse);
					ret = 1;
				} else {
					dynaBean.set(UPDATE_DATE, new Date());
					dynaBean.set(CREATE_DATE, roa.getCreateDate());
					dynaBean.set(ID, roa.getId());
					RdOutpatientAnalyse rdOutpatientAnalyse = (RdOutpatientAnalyse) dynaBean.getInstance();
					rdOutpatientAnalyseDao.update(rdOutpatientAnalyse);
					ret = 2;
				}
				break;
			case ImConstants.M03: // 住院综合
				RdInpatientCompositive ric = rdInpatientCompositiveDao.get(criteria);
				if (ObjectUtil.isNullOrEmpty(ric)) {
					dynaBean.set(CREATE_DATE, new Date());
					RdInpatientCompositive rdInpatientCompositive = (RdInpatientCompositive) dynaBean.getInstance();
					rdInpatientCompositiveDao.insert(rdInpatientCompositive);
					ret = 1;
				} else {
					dynaBean.set(CREATE_DATE, ric.getCreateDate());
					dynaBean.set(UPDATE_DATE, new Date());
					dynaBean.set(ID, ric.getId());
					RdInpatientCompositive rdInpatientCompositive = (RdInpatientCompositive) dynaBean.getInstance();
					rdInpatientCompositiveDao.update(rdInpatientCompositive);
					ret = 2;
				}
				break;
			case ImConstants.M04: // 出院病人费用分析
				RdInpatientAnalyse ria = rdInpatientAnalyseDao.get(criteria);
				if (ObjectUtil.isNullOrEmpty(ria)) {
					dynaBean.set(CREATE_DATE, new Date());
					RdInpatientAnalyse rdInpatientAnalyse = (RdInpatientAnalyse) dynaBean.getInstance();
					rdInpatientAnalyseDao.insert(rdInpatientAnalyse);
					ret = 1;
				} else {
					dynaBean.set(CREATE_DATE, ria.getCreateDate());
					dynaBean.set(UPDATE_DATE, new Date());
					dynaBean.set(ID, ria.getId());
					RdInpatientAnalyse rdInpatientAnalyse = (RdInpatientAnalyse) dynaBean.getInstance();
					rdInpatientAnalyseDao.update(rdInpatientAnalyse);
					ret = 2;
				}
				break;
			case ImConstants.M05: // 全院收入情况
				RdIncome ri = rdIncomeDao.get(criteria);
				if (ObjectUtil.isNullOrEmpty(ri)) {
					dynaBean.set(CREATE_DATE, new Date());
					RdIncome rdIncome = (RdIncome) dynaBean.getInstance();
					rdIncomeDao.insert(rdIncome);
					ret = 1;
				} else {
					dynaBean.set(CREATE_DATE, ri.getCreateDate());
					dynaBean.set(UPDATE_DATE, new Date());
					dynaBean.set(ID, ri.getId());
					RdIncome rdIncome = (RdIncome) dynaBean.getInstance();
					rdIncomeDao.update(rdIncome);
					ret = 2;
				}
				break;
			case ImConstants.M06: // 医技检查分析
				RdInspectionAnalyse rias = rdInspectionAnalyseDao.get(criteria);
				if (ObjectUtil.isNullOrEmpty(rias)) {
					dynaBean.set(CREATE_DATE, new Date());
					RdInspectionAnalyse rdInspectionAnalyse = (RdInspectionAnalyse) dynaBean.getInstance();
					rdInspectionAnalyseDao.insert(rdInspectionAnalyse);
					ret = 1;
				} else {
					dynaBean.set(CREATE_DATE, rias.getCreateDate());
					dynaBean.set(UPDATE_DATE, new Date());
					dynaBean.set(ID, rias.getId());
					RdInspectionAnalyse rdInspectionAnalyse = (RdInspectionAnalyse) dynaBean.getInstance();
					rdInspectionAnalyseDao.update(rdInspectionAnalyse);
					ret = 2;
				}
				break;
			case ImConstants.M07: // 医疗质量与安全
				RdMedicalQuality rmq = rdMedicalQualityDao.get(criteria);
				if (ObjectUtil.isNullOrEmpty(rmq)) {
					dynaBean.set(CREATE_DATE, new Date());
					RdMedicalQuality rdMedicalQuality = (RdMedicalQuality) dynaBean.getInstance();
					rdMedicalQualityDao.insert(rdMedicalQuality);
					ret = 1;
				} else {
					dynaBean.set(CREATE_DATE, rmq.getCreateDate());
					dynaBean.set(UPDATE_DATE, new Date());
					dynaBean.set(ID, rmq.getId());
					RdMedicalQuality rdMedicalQuality = (RdMedicalQuality) dynaBean.getInstance();
					rdMedicalQualityDao.update(rdMedicalQuality);
					ret = 2;
				}
				break;
			case ImConstants.M08: //  床位分布
				RdBedDistribution rdb = rdBedDistributionDao.get(criteria);
				if (ObjectUtil.isNullOrEmpty(rdb)) {
					dynaBean.set(CREATE_DATE, new Date());
					RdBedDistribution rdBedDistribution = (RdBedDistribution) dynaBean.getInstance();
					rdBedDistributionDao.insert(rdBedDistribution);
					ret = 1;
				} else {
					dynaBean.set(CREATE_DATE, rdb.getCreateDate());
					dynaBean.set(UPDATE_DATE, new Date());
					dynaBean.set(ID, rdb.getId());
					RdBedDistribution rdBedDistribution = (RdBedDistribution) dynaBean.getInstance();
					rdBedDistributionDao.update(rdBedDistribution);
					ret = 2;
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e); // 捕获记录日志
			e.printStackTrace();
			throw e; // 继续抛出被AOP异常处理拦截便于获取具体出错信息
		}
		return ret;
	}

	@Override
	public void record(RdRecord rdRecord) {
		if (ObjectUtil.isNullOrEmpty(rdRecord) || ObjectUtil.isNullOrEmpty(rdRecord.getOrganCode())) {
			return;
		}
		Organization organization = organizationApp.queryOrgan(String.valueOf(rdRecord.getOrganCode()));
		rdRecord.setCenterCode(StringUtils.equals(organization.getParentCode(), "0") ? organization.getOrganCode() : organization.getParentCode());
		rdRecord.setGbCode(organization.getGbCode());
		rdRecord.setRecordTime(new Date());
		rdRecordDao.insert(rdRecord);
	}

}
