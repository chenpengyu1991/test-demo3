package com.founder.rhip.hsa.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.repository.hsa.IInspectionRecordDao;
import com.founder.rhip.ehr.repository.hsa.ILocationInfoDao;
import com.founder.rhip.ehr.repository.hsa.IReportRecordDao;
import com.founder.rhip.ehr.repository.hsa.ISusOccDisInfoDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 卫生监督所,机构合并
 * 
 * @author liuk
 * 
 */
@Service("hsaOrganizationMergeListener")
@Transactional
public class OrganizationMergeListener implements IMergerOrganizationListener, IMergerTownListener {


	@Resource(name = "hsaInspectionRecordDao")
	private IInspectionRecordDao inspectionRecordDao;

	@Resource(name = "hsaSusOccDisInfoDao")
	private ISusOccDisInfoDao susOccDisInfoDao;

	@Resource(name = "hasLocationInfoDao")
	private ILocationInfoDao locationInfoDao;

	@Resource(name = "hasReportRecordDao")
	private IReportRecordDao reportRecordDao;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Override
	public void mergeStation(Organization newOrganization, List<Organization> stationList) {
		
	    List<String> stationCodes = new ArrayList<>();
	    List<String> stationNames = new ArrayList<>();
        for(Organization org : stationList){
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
            stationNames.add(org.getOrganName());
        }
		Criteria criteria = searchCriteria("create_Organ_Code",stationCodes);
		Parameters parameters = new Parameters("create_Organ_Code", newOrganization.getOrganCode());
		parameters.add("CREATE_ORGAN_NAME", newOrganization.getOrganName());
		locationInfoDao.update(parameters, criteria);
		if(ObjectUtil.isNotEmpty(newOrganization.getParentCode())){
			Organization centerOrgan = organizationApp.queryOrgan(newOrganization.getParentCode());
			parameters.add("CREATE_CENTER_ORGAN_Code", centerOrgan.getOrganCode());
			parameters.add("CREATE_CENTER_ORGAN_NAME", centerOrgan.getOrganName());
		}
		parameters.add("create_Gbcode", newOrganization.getGbCode()); // 所在镇
		inspectionRecordDao.update(parameters, criteria);
		susOccDisInfoDao.update(parameters, criteria);
		reportRecordDao.update(parameters, criteria);
	
		parameters = new Parameters("UPDATE_ORGAN_CODE", newOrganization.getOrganCode());
		parameters = parameters.add("UPDATE_ORGAN_NAME", newOrganization.getOrganName());
		criteria = searchCriteria("UPDATE_ORGAN_CODE",stationCodes);
		inspectionRecordDao.update(parameters, criteria);
		susOccDisInfoDao.update(parameters, criteria);
		reportRecordDao.update(parameters, criteria);
		locationInfoDao.update(parameters, criteria);
		parameters = new Parameters("RECEIVE_ORGANIZATION", newOrganization.getOrganName());
		criteria = searchCriteria("RECEIVE_ORGANIZATION",stationNames);
		reportRecordDao.update(parameters, criteria);
		parameters = new Parameters("RECEIVE_ORGANIZATION", newOrganization.getOrganCode());
		criteria = searchCriteria("RECEIVE_ORGANIZATION",stationCodes);
		reportRecordDao.update(parameters, criteria);

	}
	
	

	@Override
	public void moveStation(Organization center, List<Organization> stationList) {
		List<String> stationCodes = new ArrayList<>();
        for(Organization org : stationList){
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        //备份数据
        Criteria criteria = new Criteria("create_Organ_Code", OP.IN, stationCodes);
        //更新数据
        Parameters parameters = new Parameters("CREATE_CENTER_ORGAN_Code", center.getOrganCode());
		parameters.add("CREATE_CENTER_ORGAN_NAME", center.getOrganName());
		inspectionRecordDao.update(parameters, criteria);
		susOccDisInfoDao.update(parameters, criteria);
		reportRecordDao.update(parameters, criteria); 
	}

	@Override
	public void mergeCenter(Organization center, List<Organization> centerList) {
		Assert.notEmpty(centerList, "需要合并的中心编码为空");
		Assert.notNull(center, "目标中心不能为空");
		List<String> oldCenterOrganCodes = new ArrayList<>();
		List<String> oldCenterOrganNames = new ArrayList<>();
		for (Organization organization : centerList) {
			oldCenterOrganCodes.add(organization.getOrganCode());
			oldCenterOrganNames.add(organization.getOrganName());
		}
		Criteria criteria = searchCriteria("create_Organ_Code",oldCenterOrganCodes);
		Parameters parameters = new Parameters("create_Organ_Code", center.getOrganCode());
		parameters.add("CREATE_ORGAN_NAME", center.getOrganName());
		locationInfoDao.update(parameters, criteria);
		if(ObjectUtil.isNotEmpty(center.getParentCode())){
			Organization centerOrgan = organizationApp.queryOrgan(center.getParentCode());
			parameters.add("CREATE_CENTER_ORGAN_Code", centerOrgan.getOrganCode());
			parameters.add("CREATE_CENTER_ORGAN_NAME", centerOrgan.getOrganName());
		}
		parameters.add("create_Gbcode", center.getGbCode()); // 所在镇
		inspectionRecordDao.update(parameters, criteria);
		susOccDisInfoDao.update(parameters, criteria);
		reportRecordDao.update(parameters, criteria);
	
		parameters = new Parameters("UPDATE_ORGAN_CODE", center.getOrganCode());
	    parameters.add("UPDATE_ORGAN_NAME", center.getOrganName());
		criteria = searchCriteria("UPDATE_ORGAN_CODE",oldCenterOrganCodes);
		inspectionRecordDao.update(parameters, criteria);
		susOccDisInfoDao.update(parameters, criteria);
		reportRecordDao.update(parameters, criteria);
		locationInfoDao.update(parameters, criteria);
		parameters = new Parameters("RECEIVE_ORGANIZATION", center.getOrganName());
		criteria = searchCriteria("RECEIVE_ORGANIZATION",oldCenterOrganNames);
		reportRecordDao.update(parameters, criteria);
		parameters = new Parameters("RECEIVE_ORGANIZATION", center.getOrganCode());
		criteria = searchCriteria("RECEIVE_ORGANIZATION",oldCenterOrganCodes);
		reportRecordDao.update(parameters, criteria);

		parameters = new Parameters("CREATE_CENTER_ORGAN_Code", center.getOrganCode());
		parameters.add("CREATE_CENTER_ORGAN_NAME", center.getOrganName());
		criteria = searchCriteria("CREATE_CENTER_ORGAN_Code",oldCenterOrganCodes);
		inspectionRecordDao.update(parameters, criteria);
		susOccDisInfoDao.update(parameters, criteria);
		reportRecordDao.update(parameters, criteria);
		/*		// 更新创建机构
		Criteria criteria = new Criteria("createOrganCode", OP.IN, oldCenterOrganCodes);
		Parameters parameters = new Parameters("createOrganCode", center.getOrganCode());
        //地点信息不用更新创建机构
		//HistoryRecorder.record(LocationInfo.class, locationInfoDao, criteria, new String[] { "id", "createOrganCode" });
		//locationInfoDao.update(parameters, criteria);

		parameters.add("createCenterOrganCode", center.getOrganCode());
		parameters.add("createGbcode", center.getGbCode()); // 所在镇
		
		//HistoryRecorder.record(InspectionRecord.class, inspectionRecordDao, criteria, new String[] { "id", "createCenterOrganCode", "createGbcode", "createOrganCode" });
		inspectionRecordDao.update(parameters, criteria);
		//HistoryRecorder.record(SusOccDisInfo.class, susOccDisInfoDao, criteria, new String[] { "id", "createCenterOrganCode", "createGbcode", "createOrganCode" });
		susOccDisInfoDao.update(parameters, criteria);
		//HistoryRecorder.record(ReportRecord.class, reportRecordDao, criteria, new String[] { "id", "createCenterOrganCode", "createGbcode", "createOrganCode" });
		
		
		reportRecordDao.update(parameters, criteria);*/
	}

	@Override
	public void mergeTown(String newTownCode, String[] oldTownCode) {
		Assert.notEmpty(oldTownCode, "需要合并的镇编码为空");
		Assert.notNull(newTownCode, "目标中心不能为空");
		Criteria criteria = new Criteria("createGbcode", OP.IN, oldTownCode);
		Parameters parameters = new Parameters("createGbcode", newTownCode);
		//HistoryRecorder.record(InspectionRecord.class, inspectionRecordDao, criteria, new String[] { "id", "createGbcode" });
		inspectionRecordDao.update(parameters, criteria);
		//HistoryRecorder.record(ReportRecord.class, reportRecordDao, criteria, new String[] { "id", "createGbcode" });
		reportRecordDao.update(parameters, criteria);

		// 镇合并不需要更新可疑职业病的创建相关信息
        //HistoryRecorder.record(SusOccDisInfo.class, inspectionRecordDao, criteria, new String[] { "id", "createGbcode" });
        susOccDisInfoDao.update(parameters, criteria);

		// 更新可疑职业病 住址信息
		criteria = new Criteria("hrtownShip", OP.IN, oldTownCode);
		//criteria.add("domicileType", EHRConstants.HOUSE_HOLDER);// 只有户籍类型需要更新
		parameters = new Parameters("hrtownShip", newTownCode);
		//HistoryRecorder.record(SusOccDisInfo.class, susOccDisInfoDao, criteria, new String[] { "id", "hrtownShip" });
		susOccDisInfoDao.update(parameters, criteria);

		criteria = new Criteria("patownShip", OP.IN, oldTownCode);
		parameters = new Parameters("patownShip", newTownCode);
		//HistoryRecorder.record(SusOccDisInfo.class, susOccDisInfoDao, criteria, new String[] { "id", "patownShip" });
		susOccDisInfoDao.update(parameters, criteria);
		
		criteria = new Criteria("TOWNSHIP_LOT_CODE", OP.IN, oldTownCode);
		parameters = new Parameters("TOWNSHIP_LOT_CODE", newTownCode);
		locationInfoDao.update(parameters, criteria);
		criteria = new Criteria("TOWNSHIP_LOT_CODE_ORI", OP.IN, oldTownCode);
		parameters = new Parameters("TOWNSHIP_LOT_CODE_ORI", newTownCode);
		locationInfoDao.update(parameters, criteria);
		
	}

	@Override
	public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {
		Assert.notNull(townCode, "目标镇编码为空");
		Assert.notEmpty(newAddVillageCodes, "需要迁移的村编码为空");
		// 更新户籍地址 镇
		Criteria criteria = new Criteria("hrstreet", OP.IN, newAddVillageCodes);
		criteria.add("domicileType", EHRConstants.HOUSE_HOLDER);// 只有户籍类型需要更新
		Parameters parameters = new Parameters("hrtownShip", townCode);
		//HistoryRecorder.record(SusOccDisInfo.class, susOccDisInfoDao, criteria, new String[] { "id", "hrtownShip" });
		susOccDisInfoDao.update(parameters, criteria);
		// 更新现地址 镇
		criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);
		parameters = new Parameters("patownShip", townCode);
		//HistoryRecorder.record(SusOccDisInfo.class, susOccDisInfoDao, criteria, new String[] { "id", "patownShip" });
		susOccDisInfoDao.update(parameters, criteria);
	}

	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
		// 修改站和村关系不需要更新可疑职业病的相信息
		//@foff
        /*
		Assert.notNull(orgCode, "目标机构编码为空");
		Organization organization = organizationApp.queryOrgan(orgCode);
		Assert.notNull(organization, "目标机构在系统中不存在");
		Assert.notEmpty(newAddVillageCodes, "需要迁移的村编码为空");
		// 更新管理机构
		Parameters param = new Parameters("createOrganCode", organization.getParentCode());
		param.add("createCenterOrganCode", organization.getParentCode());// 中心,直接取parentCode因为迁移针只对站
		param.add("createGbcode", organization.getGbCode()); // 所在镇
		param.add("patownShip", organization.getGbCode());
		Criteria criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);
		HistoryRecorder.record(SusOccDisInfo.class, susOccDisInfoDao, criteria, new String[] { "id", "patownShip", "createCenterOrganCode", "createGbcode", "createOrganCode" });
		susOccDisInfoDao.update(param, criteria);
		*/
        //@fon
	}
	
	private Criteria searchCriteria(String field, List organs){
		Criteria criteria = new Criteria();
		criteria.add(field, OP.IN, organs);
		return criteria;
	}
}
