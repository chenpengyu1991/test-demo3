package com.founder.rhip.hsa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.ImageUtil;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.UploadInfoRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.FamilyInfo;
import com.founder.rhip.ehr.entity.hsa.InspGuideRecord;
import com.founder.rhip.ehr.entity.hsa.InspectionRecord;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;
import com.founder.rhip.ehr.repository.basic.IUploadInfoRecordDao;
import com.founder.rhip.ehr.repository.hsa.IFamilyInfoDao;
import com.founder.rhip.ehr.repository.hsa.IInspGuideRecordDao;
import com.founder.rhip.ehr.repository.hsa.IInspectionRecordDao;
import com.founder.rhip.ehr.repository.hsa.IReportRecordDao;
import com.founder.rhip.ehr.repository.hsa.ISusOccDisInfoDao;
import com.founder.rhip.hsa.common.RecordStatus;
import com.founder.rhip.mdm.app.IStaffApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.Staff;

/**
 * 日常巡查和家庭巡查
 * 
 * @author liuk
 */
@Service("inspRecordService")
public class InspRecordServiceImpl extends AbstractService implements IInspRecordService {
	@Resource(name = "uploadInfoRecordDao")
	private IUploadInfoRecordDao uploadInfoRecordDao;
	@Resource(name = "hsaInspectionRecordDao")
	private IInspectionRecordDao inspectionRecordDao;
	@Resource(name = "hasInspGuideRecordDao")
	private IInspGuideRecordDao inspGuideRecordDao;
	@Resource(name = "hasReportRecordDao")
	private IReportRecordDao reportRecordDao;
	@Resource(name = "susOccDiService")
	private ISusOccDiservice susOccDiservice;
	@Resource(name = "hsaLocationService")
	private ILocationService locationService;
	@Resource(name = "hsaSusOccDisInfoDao")
	private ISusOccDisInfoDao susOccDisInfoDao;
	@Resource(name = "hsaFamilyInfoDao")
	private IFamilyInfoDao familyInfoDao;
	@Autowired
	private IStaffApp staffApp;

	@Resource(name = "hsaReportRecordService")
	private IReportRecordService reportRecordService;

	private final static String[] updateInspRecordProperties = { "updateOrganCode", "updateOrganName", "updateDoctorCode", "updateDoctorName", "updateDate", "findMainPro", "inspDate",
			"inspPersonCode", "secInspPersonCode","secInspPersonName",  "inspPersonName", "remark", "isGuide", "isReport","healthSupervisionOpinion","inspectionRecord" };

	@Override
	public PageList<InspectionRecord> getPageInspectionRecordList(Page page, Criteria criteria, RoleType roleType, Organization organization) {
		setInspRecordParam(organization, roleType, criteria);
		return inspectionRecordDao.getPageInspectionRecordList(page, criteria);
	}

	@Override
	public PageList<InspectionRecord> getPagedLocationRecordList(Page page, Criteria criteria, RoleType roleType, Organization organization) {
//		setInspRecordParam(organization, roleType, criteria);
        //日常巡查 中心只能看到自己的 -团风需求
        if (RoleType.ZXWJ.equals(roleType)) {
            criteria.add("HSA_INSPECTION_RECORD.CREATE_ORGAN_CODE", organization.getOrganCode());
        }
        return inspectionRecordDao.getPagedLocationRecordList(page, criteria);
	}

	@Override
	public List<InspectionRecord> getRecordList(Criteria criteria) {
		List<InspectionRecord> inspectionRecord = inspectionRecordDao.getList(criteria);
		return inspectionRecord;
	}

	@Override
	public LocationInfo getInspLocationByInspId(Long inspId) {
		Assert.notNull(inspId, "巡查记录id不能为空");
		LocationInfo locationInfo = null;
		InspectionRecord inspGuideRecord = inspectionRecordDao.get(new Criteria("id", inspId), "locationId");
		if (null != inspGuideRecord) {
			Long locationId = inspGuideRecord.getLocationId();
			if (null == locationId) {
				log.warn("该巡查记录没有地点信息");
			} else {
				locationInfo = locationService.getLocationInfo(new Criteria("id", locationId));
				if (null == locationInfo) {
					log.warn("该巡查地点已经被删除!");
				}
			}
		}
		return locationInfo;
	}

	/**
	 * 添加
	 * 
	 * @param InspectionRecord InspectionRecord
	 * @param Organization Organization
	 * @param User User
	 * @return void
	 */
	@Override
	@Transactional
	public void addRecord(InspectionRecord inspectionRecord, Organization organization, User user, RoleType roleType,Map<String, Map<String, String>> linkMap) {
		Assert.notNull(inspectionRecord, "巡查指导记录不能为空");
		Assert.notNull(organization, "创建机构不能为空");
		Assert.notNull(user, "创建用户不能为空");
		
		
		if (ObjectUtil.isNullOrEmpty(inspectionRecord.getId())) {
			setInspectionRecordInputInfp(false, inspectionRecord, organization, user);
			saveHsaRecord(inspectionRecord, organization, user);
			saveUploadInfoRecod(inspectionRecord.getId(), linkMap, user.getUserCode());
		} else {
			setInspectionRecordInputInfp(true, inspectionRecord, organization, user);
			updateHsaRecord(inspectionRecord, organization, user);
			saveUploadInfoRecod(inspectionRecord.getId(), linkMap, user.getUserCode());
		}
	}

	private void saveUploadInfoRecod(Long id, Map<String, Map<String, String>> mapResult, String createUserCode) {
		// 附件
		if(ObjectUtil.isNotEmpty(mapResult.get("inspMap"))){
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			/*UploadInfoRecord infoRecord= uploadInfoRecordDao.get(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", "inspectionRecord"));
			if(ObjectUtil.isNotEmpty(infoRecord)){
				uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", "inspectionRecord"));
			}*/
			Map<String, String> map = mapResult.get("inspMap");
			Map<String, String> nameMap = mapResult.get("inspNameMap");
			for(String uuid : map.keySet()){
				//String originalFilePath = map.get(uuid).substring(0, map.get(uuid).indexOf("[<+=0a0=+>]"));
				//String originalFileName = map.get(uuid).substring(map.get(uuid).indexOf("[<+=0a0=+>]")+11,map.get(uuid).length());
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(id);
				uploadInfoRecord.setOriginalFilePath(map.get(uuid));
				uploadInfoRecord.setOriginalFileName(nameMap.get(uuid));
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(map.get(uuid))); // 缩略图地址
				uploadInfoRecord.setFileResource("inspectionRecord");
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createUserCode);
				uploadInfoRecords.add(uploadInfoRecord);
			}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
		if(ObjectUtil.isNotEmpty(mapResult.get("inspHsoMap"))) {
			Map<String, String> map = mapResult.get("inspHsoMap");
			Map<String, String> nameMap = mapResult.get("inspHsoNameMap");
			List<UploadInfoRecord> uploadInfoRecords = new ArrayList<>();
			/*UploadInfoRecord infoRecord= uploadInfoRecordDao.get(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", "healthSupervisionOpinion"));
			if(ObjectUtil.isNotEmpty(infoRecord)){
				uploadInfoRecordDao.delete(new Criteria("RESOURCE_ID", id).add("FILE_RESOURCE", "healthSupervisionOpinion"));
			}*/
			for(String uuid : map.keySet()){
				//String originalFilePath = map.get(uuid).substring(0, map.get(uuid).indexOf("[<+=0a0=+>]"));
				//String originalFileName = map.get(uuid).substring(map.get(uuid).indexOf("[<+=0a0=+>]")+11,map.get(uuid).length());
				UploadInfoRecord uploadInfoRecord = new UploadInfoRecord();
				uploadInfoRecord.setResourceId(id);
				uploadInfoRecord.setOriginalFilePath(map.get(uuid));
				uploadInfoRecord.setOriginalFileName(nameMap.get(uuid));
				uploadInfoRecord.setThumbnailPath(ImageUtil.getThumbnailPath(map.get(uuid))); // 缩略图地址
				uploadInfoRecord.setFileResource("healthSupervisionOpinion");
				uploadInfoRecord.setCreateTime(new Date());
				uploadInfoRecord.setCreater(createUserCode);
				uploadInfoRecords.add(uploadInfoRecord);
		}
			uploadInfoRecordDao.batchInsert(uploadInfoRecords);
		}
	}
	
	// 更新社区卫生监督协管巡查记录
	private void updateHsaRecord(InspectionRecord inspectionRecord, Organization organization, User user) {
		// 更新社区卫生监督协管巡查记录
		setStaffName(inspectionRecord);	//设置巡查人员姓名,检索用
		if(ObjectUtil.isNotEmpty(inspectionRecord.getId())){
			inspectionRecordDao.update(inspectionRecord, updateInspRecordProperties);
		}
		
		if (EHRConstants.INSPECTION_HAVE_GUIDE.equals(inspectionRecord.getIsGuide())) {
			InspGuideRecord inspGuideRecord = inspectionRecord.getInspGuideRecord();
			Assert.notNull(inspGuideRecord, "巡查指导信息获取失败");
			inspGuideRecord.setInspReocrdId(inspectionRecord.getId());
			inspGuideRecord.setInspGuideTypeCode(inspectionRecord.getInspHealthProfessional());
			Long guideRecordId = inspGuideRecord.getId();
			if (ObjectUtil.isNullOrEmpty(guideRecordId)) {
				inspGuideRecordDao.insert(inspGuideRecord);
			} else {
				inspGuideRecordDao.update(inspectionRecord.getInspGuideRecord());
			}
		} else {
			inspGuideRecordDao.delete(new Criteria("inspReocrdId", inspectionRecord.getId()));
		}
		// 保存报告登记
		if (EHRConstants.INSPECTION_HAVE_REPORT_CARD.equals(inspectionRecord.getIsReport())) {
			ReportRecord reportRecord = inspectionRecord.getReportRecord();
			Assert.notNull(reportRecord, "报告登记信息获取失败");
			// 更新报告登记
			reportRecord.setInfoTypeCode(inspectionRecord.getInspHealthProfessional());
			reportRecord.setInspReocrdId(inspectionRecord.getId());
			Long reportRecordId = reportRecord.getId();
			if (ObjectUtil.isNullOrEmpty(reportRecordId)) {
				reportRecordService.saveRecord(reportRecord, organization, user, null);
			} else {
				reportRecordService.updateRecord(reportRecord, organization, user);
			}
		} else {
			reportRecordDao.delete(new Criteria("inspReocrdId", inspectionRecord.getId()));
		}
	}

	// 保存监督协管表单记录
	private void saveHsaRecord(InspectionRecord inspectionRecord, Organization organization, User user) {
		// 非法行医特别处理
		// 直接新增地点信息
		/*Number inspRecordId = inspectionRecordDao.generatedKey(inspectionRecord, "ID", new String[] {});
		if(ObjectUtil.isNotEmpty(inspectionRecord)){
			inspectionRecord.setId(Long.parseLong(inspRecordId.toString()));
			inspectionRecordDao.update(inspectionRecord);
		}*/
		if (ObjectUtil.isNullOrEmpty(inspectionRecord.getLocationId())) {
			LocationInfo locationInfo = inspectionRecord.getLocationInfo();
			// 如果是非法行医,则地点信息必须存在
			Assert.notNull(locationInfo, "地点信息不能为空");
			if (!EHRConstants.INSPECTION_HP_IM.equals(locationInfo.getHealthProfessional())) {
				throw new RuntimeException("请选择地点信息");
			} else {
				Assert.notNull(locationInfo.getUnitName(), "非法行医地点名称不能为空");
			}
			// 地点数据类型为不显示
			locationInfo.setDataType(EHRConstants.LOCATION_DATA_TYPE_ADD_NOT_SHOW);
			Long locationId = locationService.addLocationInfo(locationInfo, organization, user);
			inspectionRecord.setLocationId(locationId);
		}

		//设置巡查人员姓名,检索用
		setStaffName(inspectionRecord);

		// 保存巡查记录
        Number inspRecordId = inspectionRecordDao.generatedKey(inspectionRecord, "ID", new String[] {});
		Assert.notNull(inspRecordId, "巡查信息保存失败");
		// 保存巡查指导记录
		if (EHRConstants.INSPECTION_HAVE_GUIDE.equals(inspectionRecord.getIsGuide())) {
			InspGuideRecord inspGuideRecord = inspectionRecord.getInspGuideRecord();
			Assert.notNull(inspGuideRecord, "巡查指导信息获取失败");
			inspGuideRecord.setInspGuideTypeCode(inspectionRecord.getInspHealthProfessional());
			inspGuideRecord.setInspReocrdId(inspRecordId.longValue());
			inspGuideRecordDao.insert(inspGuideRecord);
		}

		// 保存报告登记
		if (EHRConstants.INSPECTION_HAVE_REPORT_CARD.equals(inspectionRecord.getIsReport())) {
			ReportRecord reportRecord = inspectionRecord.getReportRecord();
			Assert.notNull(reportRecord, "报告登记信息获取失败");
			reportRecord.setInfoTypeCode(inspectionRecord.getInspHealthProfessional());
			reportRecord.setInspReocrdId(inspRecordId.longValue());
			reportRecordService.saveRecord(reportRecord, organization, user, null);
		}
	}

	private void setStaffName(InspectionRecord inspectionRecord) {
		String first = inspectionRecord.getInspPersonCode();
		if (StringUtil.isNotEmpty(first)) {
			String name = getStaffName(first);
			inspectionRecord.setInspPersonName(name);
		}
		String sec = inspectionRecord.getSecInspPersonCode();
		if (StringUtil.isNotEmpty(sec)) {
			String name = getStaffName(sec);
			inspectionRecord.setSecInspPersonName(name);
		}
	}

	private String getStaffName(String first) {
		List<Staff> list = null;
		String name = "";
		try {
			list = staffApp.queryStaff(new Criteria("staffCode", first));
		} catch (Exception e) {
			log.error("获取医务人员姓名失败", e);
		}

		if (ObjectUtil.isNotEmpty(list)) {
			name = list.get(0).getName();
		}
		return name;
	}

	@Override
	public InspectionRecord getRecordForUpdate(Criteria criteria) {
		InspectionRecord inspectionRecord = inspectionRecordDao.get(criteria);
		Assert.notNull(inspectionRecord, "无法获取指定的巡查记录");
		Long id = inspectionRecord.getId();
		Long loacationId = inspectionRecord.getLocationId();

		if (EHRConstants.INSP_LOC_TYPE_FAMILY.equals(inspectionRecord.getInspLocType())) {
			Assert.notNull(loacationId, "家庭信息id为空");
			FamilyInfo familyInfo = familyInfoDao.get(loacationId);
			Assert.notNull(familyInfo, "无法获取家庭信息");
			inspectionRecord.setFamilyInfo(familyInfo);

		} else if (EHRConstants.INSP_LOC_TYPE_LOCATION.equals(inspectionRecord.getInspLocType())) {
			// 获取地点信息
//			Assert.notNull(loacationId, "地点信息id为空");
			LocationInfo locationInfo = locationService.getLocationInfo(new Criteria("id", loacationId));
			// 允许地点信息不存在,地点信息可以被删除
			if (null == locationInfo) {
				log.warn("地点信息已经被删除,指定的id为" + loacationId);
			}
			inspectionRecord.setLocationInfo(locationInfo);
			// 获取报告信息
			if (EHRConstants.INSPECTION_HAVE_GUIDE.equals(inspectionRecord.getIsReport())) {
				ReportRecord record = reportRecordDao.get(new Criteria("inspReocrdId", id));
				Assert.notNull(record);
				inspectionRecord.setReportRecord(record);
			}
		} else {
			throw new RuntimeException("不支持的记录类型,请检查数据是否正确");
		}

		// 获取指导记录信息
		if (EHRConstants.INSPECTION_HAVE_REPORT_CARD.equals(inspectionRecord.getIsGuide())) {
			InspGuideRecord guideRecord = inspGuideRecordDao.get(new Criteria("inspReocrdId", id));
			Assert.notNull(guideRecord);
			inspectionRecord.setInspGuideRecord(guideRecord);
		}
		return inspectionRecord;
	}

	// =================家庭===================//
	@Override
	public List<InspectionRecord> getFamilyRecordList(Page page, Criteria criteria, Organization organization, RoleType roleType) {
		if (criteria == null) {
			criteria = new Criteria();
		}
		addPermissionParam("inspectionRecord.CREATE_ORGAN_CODE", organization, roleType, criteria);
		List<InspectionRecord> list = inspectionRecordDao.getPagedFamilyRecordList(page, criteria);
		return list;
	}

	@Override
	public void saveFamilyRecord(InspectionRecord inspectionRecord, Organization organization, User user, RoleType roleType) {
		Assert.notNull(inspectionRecord, "巡查记录不能为空");
		Assert.notNull(organization, "机构不能为空");
		Assert.notNull(user, "用户不能为空");
		InspGuideRecord inspGuideRecord = inspectionRecord.getInspGuideRecord();
		Assert.notNull(inspGuideRecord, "巡查指导记录不能为空");
		FamilyInfo familyInfo = inspectionRecord.getFamilyInfo();
		Assert.notNull(familyInfo, "家庭记录不能为空");
		if (ObjectUtil.isNullOrEmpty(inspectionRecord.getId())) {
			Number familyId = familyInfoDao.generatedKey(familyInfo, "ID", new String[] {});
			Assert.notNull(familyId, "家庭记录保存失败");
			setInspectionRecordInputInfp(false, inspectionRecord, organization, user);
			inspectionRecord.setIsGuide("1");

			// 设置为饮用水
			inspectionRecord.setInspHealthProfessional("3");
			inspectionRecord.setStatus(getAddRecordStatus(roleType).getValue());
			inspectionRecord.setLocationId(familyId.longValue());
			inspectionRecord.setInspLocType(EHRConstants.INSP_LOC_TYPE_FAMILY);
			setStaffName(inspectionRecord);
			Number inspRecordId = inspectionRecordDao.generatedKey(inspectionRecord, "ID", new String[] {});
			Assert.notNull(inspRecordId, "巡查记录保存失败");
			// 保存巡查指导记录
			inspGuideRecord.setInspReocrdId(inspRecordId.longValue());
			inspGuideRecordDao.insert(inspGuideRecord);
		} else {
			// 巡查记录检查
			Long id = inspectionRecord.getId();
			Assert.notNull(id, "id不能为空");
			InspectionRecord oldInspectionRecord = inspectionRecordDao.get(id);
			Assert.notNull(oldInspectionRecord, "根据指定的Id无法获取巡查记录");

			// 巡查记录更新
			inspectionRecord.setIsGuide("1");
			inspectionRecord.setInspLocType(EHRConstants.INSP_LOC_TYPE_FAMILY);
			setInspectionRecordInputInfp(true, inspectionRecord, organization, user);
			setStaffName(inspectionRecord);
			inspectionRecordDao.update(inspectionRecord, updateInspRecordProperties);

			// 家庭更新
			Long familyId = oldInspectionRecord.getLocationId();
			Assert.notNull(familyId, "家庭id为空");
			familyInfo.setId(familyId);
			familyInfoDao.update(familyInfo);

			// 巡查指导
			InspGuideRecord oldInspGuideRecord = inspGuideRecordDao.get(new Criteria("INSP_REOCRD_ID", id));
			Assert.notNull(oldInspGuideRecord, "根据取巡查记录无法获取巡查指导");
			inspGuideRecord.setInspReocrdId(id);
			inspGuideRecord.setId(oldInspGuideRecord.getId());
			inspGuideRecordDao.update(inspGuideRecord, "dosp", "dostv");

		}
	}

	@Override
	public InspectionRecord getFamilyRecord(Long id) {
		// 巡查记录
		Assert.notNull(id, "id不能为空");
		InspectionRecord inspectionRecord = inspectionRecordDao.get(id);
		Assert.notNull(inspectionRecord, "根据指定的Id无法获取巡查记录");

		// 巡查指导
		InspGuideRecord inspGuideRecord = inspGuideRecordDao.get(new Criteria("INSP_REOCRD_ID", id));
		Assert.notNull(inspectionRecord, "根据取巡查记录无法获取巡查指导");
		inspectionRecord.setInspGuideRecord(inspGuideRecord);

		// 家庭信息
		Long familyId = inspectionRecord.getLocationId();
		Assert.notNull(familyId, "家庭id为空");
		FamilyInfo familyInfo = familyInfoDao.get(new Criteria("id", familyId));
		Assert.notNull(familyInfo, "根据指定的id无法获取家庭");
		inspectionRecord.setFamilyInfo(familyInfo);

		return inspectionRecord;
	}

	// =================家庭==end===============//

	private RecordStatus getAddRecordStatus(RoleType roleType) {
		if (null != roleType && RoleType.ZXDFB.equals(roleType)) {
			return RecordStatus.CONFIRMED;
		}
		return RecordStatus.READY;
	}

	/**
	 * 设置权限
	 * 
	 * @param key
	 * @param organization
	 * @param roleType
	 * @param criteria
	 */
	private void addPermissionParam(String key, Organization organization, RoleType roleType, Criteria criteria) {
		if (RoleType.ZX_GLY.equals(roleType)) {
			criteria.add(key, organization.getOrganCode());
		}
	}

	private void setInspRecordParam(Organization organization, RoleType roleType, Criteria criteria) {
		addPermissionParam("HSA_INSPECTION_RECORD.CREATE_ORGAN_CODE", organization, roleType, criteria);
	}

	/**
	 * 设置输入信息
	 * 
	 * @param update
	 * @param inspectionRecord
	 * @param organization
	 * @param user
	 */
	private void setInspectionRecordInputInfp(boolean update, InspectionRecord inspectionRecord, Organization organization, User user) {
		if (!update) {
			inspectionRecord.setCreateDate(new Date());
			inspectionRecord.setCreateDoctorCode(user.getId() + "");
			inspectionRecord.setCreateDoctorName(user.getName());
			inspectionRecord.setCreateOrganCode(organization.getOrganCode());
			inspectionRecord.setCreateOrganName(organization.getOrganName());
			inspectionRecord.setCreateGbcode(organization.getGbCode());
		}
		inspectionRecord.setUpdateDate(new Date());
		inspectionRecord.setUpdateDoctorCode(user.getId() + "");
		inspectionRecord.setUpdateDoctorName(user.getName());
		inspectionRecord.setUpdateOrganCode(organization.getOrganCode());
		inspectionRecord.setUpdateOrganName(organization.getOrganName());
	}

	// =======================old=====================//
	/**
	 * 卫生监督所审核确认修改状态
	 * 
	 * @param InspectionRecord
	 * @param Organization
	 * @param User
	 * @return void
	 */
	@Override
	public void updateRecord(InspectionRecord inspectionRecord, Organization organization, User user) {
		Assert.notNull(inspectionRecord, "巡查指导记录不能为空");
		Assert.notNull(organization, "创建机构不能为空");
		Assert.notNull(user, "创建用户不能为空");
		setInspectionRecordInputInfp(true, inspectionRecord, organization, user);
		inspectionRecordDao.update(new Parameters("STATUS", RecordStatus.CONFIRMED.getValue()), new Criteria("ID", inspectionRecord.getId()));
	}

}