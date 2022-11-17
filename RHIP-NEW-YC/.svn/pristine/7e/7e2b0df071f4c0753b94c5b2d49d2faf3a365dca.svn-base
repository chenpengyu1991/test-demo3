package com.founder.rhip.hsa.service;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import com.founder.rhip.ehr.entity.hsa.PenaltyInfo;
import com.founder.rhip.ehr.repository.hsa.IPenaltyInfoDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.hsa.BusinessInfo;
import com.founder.rhip.ehr.entity.hsa.LocationInfo;
import com.founder.rhip.ehr.repository.hsa.IBusinessInfoDao;
import com.founder.rhip.ehr.repository.hsa.ILocationInfoDao;
import com.founder.rhip.mdm.common.AreaType;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.entity.OrganizationArea;
import com.founder.rhip.mdm.service.IOrganizationService;

/**
 * 基础信息管理
 * 
 * @author liuk
 * 
 */
@Service("hsaLocationService")
public class LocationServiceImpl extends AbstractService implements ILocationService {

	@Resource(name = "hasLocationInfoDao")
	private ILocationInfoDao locationInfoDao;

	@Resource(name = "hsaBusinessInfoDao")
	private IBusinessInfoDao businessInfoDao;

	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;

	@Resource(name = "hasPenaltyDao")
	private IPenaltyInfoDao penaltyInfoDao;

	// 数据集成　数据字典转换
	private final static Map<String, String> SCALE = new HashMap<String, String>(4);
	private final static Map<String, String> CARD_TYPE = new HashMap<String, String>(4);
	private final static Map<String, String> UNIT_TYPE = new HashMap<String, String>(3);
	private final static Map<String, String> TOWN_SHIP = new HashMap<String, String>(40);
	private final static Map<String, String> EC_NATURE = new HashMap<String, String>(14);
	private final static Map<String, String> BUSINESS_TYPE_CODE = new HashMap<String, String>(7);
	private final static Map<String, String> LICENSE_STATE_CODE = new HashMap<String, String>(2);
	private final static Map<String, String> HEALTH_PROFESSIONAL = new HashMap<String, String>(2);
	private final static Map<String, String> MAIN_BUSINESS_CODE = new HashMap<String, String>(2);
	private final static Map<String, String> FILE_CODE = new HashMap<String, String>(2);
	private final static Map<String, String> NEW_RECORD_FLAG = new HashMap<String, String>(2);

	/**
	 * 不更新的字段
	 */
	private final static String[] NO_UPDATE_PROPERTIES2 = { "isDelete", "status", "dataType", "createOrganName", "createOrganCode", "createDoctorName", "createDoctorCode", "createCenterOrganName", "createCenterOrganCode", "createGbcode", "createDate" };

	/**
	 * 不显示的卫生专业代码
	 */
	public static Set<String> NOT_SHOW_MAIN_BUSINESS_CODE;

	private static String[] UPDATE_PROPERTIES;

	@PostConstruct
	public void init() {
		initDicCode();
		calUpdateProperies();
	}

	private void initDicCode() {
		// 经济性质
		EC_NATURE.put("1", "11");// 国有全资
		EC_NATURE.put("2", "12");// 集体全资
		EC_NATURE.put("3", "13");// 股份合作
		EC_NATURE.put("4", "14");// 联营
		EC_NATURE.put("5", "15");// 有限责任(公司)
		EC_NATURE.put("6", "16");// 股份有限(公司)
		EC_NATURE.put("7", "17");// 私有
		EC_NATURE.put("8", "19");// 其他内资
		EC_NATURE.put("9", "20");// 港澳台投资
		EC_NATURE.put("10", "31");// 中外合资
		EC_NATURE.put("11", "32");// 中外合作
		EC_NATURE.put("12", "33");// 外资
		EC_NATURE.put("13", "40");// 个人独资
		EC_NATURE.put("99", "41");// 个人或个体工商户

		// 单位规模
		SCALE.put("1", "1");// 特大
		SCALE.put("2", "2");// 大
		SCALE.put("3", "3");// 中
		SCALE.put("4", "4");// 小

		// 证件类别
		CARD_TYPE.put("0", "01");// 身份证
		CARD_TYPE.put("1", "03");// 护照
		CARD_TYPE.put("2", "08");// 港澳台身份证
		CARD_TYPE.put("3", "04");// 军官或士兵证

		// 单位类型
		UNIT_TYPE.put("0", "1");// 自然人
		UNIT_TYPE.put("1", "2");// 法人
		UNIT_TYPE.put("2", "3");// 其他

		// 乡镇地段
		TOWN_SHIP.put("01", "1");
		TOWN_SHIP.put("02", "2");
		TOWN_SHIP.put("03", "3");
		TOWN_SHIP.put("04", "4");
		TOWN_SHIP.put("05", "5");
		TOWN_SHIP.put("06", "6");
		TOWN_SHIP.put("07", "7");
		TOWN_SHIP.put("08", "8");
		TOWN_SHIP.put("09", "9");
		TOWN_SHIP.put("10", "10");
		TOWN_SHIP.put("11", "11");
		TOWN_SHIP.put("12", "12");
		TOWN_SHIP.put("13", "13");
		TOWN_SHIP.put("14", "14");
		TOWN_SHIP.put("15", "15");
		TOWN_SHIP.put("16", "16");
		TOWN_SHIP.put("17", "17");
		TOWN_SHIP.put("18", "18");
		TOWN_SHIP.put("19", "19");
		TOWN_SHIP.put("20", "20");
		TOWN_SHIP.put("21", "21");
		TOWN_SHIP.put("22", "22");
		TOWN_SHIP.put("23", "23");
		TOWN_SHIP.put("24", "24");
		TOWN_SHIP.put("25", "25");
		TOWN_SHIP.put("26", "26");
		TOWN_SHIP.put("27", "27");
		TOWN_SHIP.put("28", "28");
		TOWN_SHIP.put("29", "29");
		TOWN_SHIP.put("30", "30");
		TOWN_SHIP.put("31", "31");
		TOWN_SHIP.put("32", "32");
		TOWN_SHIP.put("33", "33");
		TOWN_SHIP.put("34", "34");
		TOWN_SHIP.put("35", "35");
		TOWN_SHIP.put("36", "36");
		TOWN_SHIP.put("37", "37");
		TOWN_SHIP.put("38", "38");
		TOWN_SHIP.put("39", "39");
		TOWN_SHIP.put("40", "40");

		BUSINESS_TYPE_CODE.put("1", "1");
		BUSINESS_TYPE_CODE.put("2", "2");
		BUSINESS_TYPE_CODE.put("3", "3");
		BUSINESS_TYPE_CODE.put("4", "4");
		BUSINESS_TYPE_CODE.put("5", "5");
		BUSINESS_TYPE_CODE.put("6", "6");
		BUSINESS_TYPE_CODE.put("9", "9");

		LICENSE_STATE_CODE.put("0", "1");
		LICENSE_STATE_CODE.put("1", "2");

		HEALTH_PROFESSIONAL.put("餐", "1");
		HEALTH_PROFESSIONAL.put("公", "2");
		HEALTH_PROFESSIONAL.put("水", "3");
		HEALTH_PROFESSIONAL.put("学", "5");
		HEALTH_PROFESSIONAL.put("医", "7");
		HEALTH_PROFESSIONAL.put("血 ", "7");
		HEALTH_PROFESSIONAL.put("传", "6");

		MAIN_BUSINESS_CODE.put("11", "101");
		MAIN_BUSINESS_CODE.put("12", "102");
		MAIN_BUSINESS_CODE.put("13", "103");
		MAIN_BUSINESS_CODE.put("14", "104");
		MAIN_BUSINESS_CODE.put("20", "105");
		MAIN_BUSINESS_CODE.put("30", "106");
		MAIN_BUSINESS_CODE.put("40", "107");
		MAIN_BUSINESS_CODE.put("50", "108");
		MAIN_BUSINESS_CODE.put("60", "109");

		MAIN_BUSINESS_CODE.put("0101", "201");
		MAIN_BUSINESS_CODE.put("0102", "202");
		MAIN_BUSINESS_CODE.put("0103", "203");
		MAIN_BUSINESS_CODE.put("0104", "204");
		MAIN_BUSINESS_CODE.put("0105", "205");
		MAIN_BUSINESS_CODE.put("0106", "206");
		MAIN_BUSINESS_CODE.put("0107", "207");
		MAIN_BUSINESS_CODE.put("0108", "208");
		MAIN_BUSINESS_CODE.put("0109", "209");
		MAIN_BUSINESS_CODE.put("0110", "210");
		MAIN_BUSINESS_CODE.put("0111", "211");
		MAIN_BUSINESS_CODE.put("0112", "212");
		MAIN_BUSINESS_CODE.put("0113", "213");
		MAIN_BUSINESS_CODE.put("0114", "214");
		MAIN_BUSINESS_CODE.put("0115", "215");
		MAIN_BUSINESS_CODE.put("0116", "216");
		MAIN_BUSINESS_CODE.put("0117", "217");
		MAIN_BUSINESS_CODE.put("0118", "218");
		MAIN_BUSINESS_CODE.put("0119", "219");
		MAIN_BUSINESS_CODE.put("0120", "220");
		MAIN_BUSINESS_CODE.put("0121", "221");
		MAIN_BUSINESS_CODE.put("0122", "222");
		MAIN_BUSINESS_CODE.put("0123", "223");
		MAIN_BUSINESS_CODE.put("0124", "224");
		MAIN_BUSINESS_CODE.put("0125", "225");
		MAIN_BUSINESS_CODE.put("0126", "226");
		MAIN_BUSINESS_CODE.put("0127", "227");
		MAIN_BUSINESS_CODE.put("0128", "228");
		MAIN_BUSINESS_CODE.put("0201", "301");
		MAIN_BUSINESS_CODE.put("0202", "302");
		MAIN_BUSINESS_CODE.put("0203", "303");
		MAIN_BUSINESS_CODE.put("0204", "304");
		MAIN_BUSINESS_CODE.put("0501", "501");
		MAIN_BUSINESS_CODE.put("0502", "502");
		MAIN_BUSINESS_CODE.put("0503", "503");
		MAIN_BUSINESS_CODE.put("0504", "504");
		MAIN_BUSINESS_CODE.put("0599", "608");
		MAIN_BUSINESS_CODE.put("2101", "701");
		MAIN_BUSINESS_CODE.put("2102", "702");
		// 非法采供血 新增
		MAIN_BUSINESS_CODE.put("2013", "703");
		MAIN_BUSINESS_CODE.put("10", "601");
		MAIN_BUSINESS_CODE.put("06", "602");
		MAIN_BUSINESS_CODE.put("1901", "603");
		MAIN_BUSINESS_CODE.put("1902", "604");
		MAIN_BUSINESS_CODE.put("1903", "605");
		MAIN_BUSINESS_CODE.put("1908", "607");
		MAIN_BUSINESS_CODE.put("1999", "606");

		FILE_CODE.put("0", "1");
		FILE_CODE.put("1", "2");

		NEW_RECORD_FLAG.put("0", "1");
		NEW_RECORD_FLAG.put("1", "2");

		//
		Set<String> set = new HashSet<>();
		set.add("303");
		set.add("304");
		set.add("602");
		set.add("603");
		set.add("604");
		set.add("605");
		set.add("606");
		set.add("607");
		NOT_SHOW_MAIN_BUSINESS_CODE = set;
	}

	@Override
	public Set<String> getNotShowBsCodes() {
		return Collections.unmodifiableSet(NOT_SHOW_MAIN_BUSINESS_CODE);
	}

	public void calUpdateProperies() {
		ClassMetadata classMetadata = ClassMetadata.getMetadata(LocationInfo.class);
		Map<String, PropertyMetadata> columns = classMetadata.getProperty();
		HashSet<String> noupdate = new HashSet<>(Arrays.asList(NO_UPDATE_PROPERTIES2));
		HashSet<String> update = new HashSet<>();
		for (Map.Entry<String, PropertyMetadata> entry : columns.entrySet()) {
			PropertyMetadata propertyMetadata = entry.getValue();
			if (!propertyMetadata.isDbField()) {
				continue;
			}
			String proper = entry.getKey();
			if (noupdate.contains(proper)) {
				continue;
			}
			update.add(proper);
		}
		UPDATE_PROPERTIES = update.toArray(new String[update.size()]);
	}

	@Override
	public LocationInfo getLocationInfo(Criteria criteria) {
		Assert.notNull(criteria, "获取地点条件不能为空");
		LocationInfo result = locationInfoDao.get(criteria);
		return result;
	}

	@Override
	public LocationInfo getLocationWithBusiInfo(Criteria criteria) {
		LocationInfo result = getLocationInfo(criteria);
		if (null != result) {
			Criteria busiCriteria = new Criteria("locationInfoId", result.getId());
			busiCriteria.add("newRecordFlag", EHRConstants.LOCATION_NEW_RECORD_FLAG_YES);
			List<BusinessInfo> businessInfos = businessInfoDao.getList(busiCriteria);
			result.setBusinessInfos(businessInfos);
		}
		return result;
	}

	@Override
	public List<LocationInfo> getLocationInfos(Criteria criteria) {
		if (null == criteria) {
			criteria = new Criteria();
		}
		List<LocationInfo> result = locationInfoDao.getList(criteria);
		// 不返回null
		if (null == result) {
			result = Collections.emptyList();
		}
		return result;
	}

	@Override
	public PageList<LocationInfo> getPagedLocationInfos(Page page, Criteria criteria) {
		Assert.notNull(page, "分页参数不能为空");
		if (null == criteria) {
			criteria = new Criteria();
		}
		PageList<LocationInfo> result = locationInfoDao.getPageList(page, criteria);
		return result;
	}

	@Override
	public List<Map<String, Object>> getPagedLocInfoMapsAddInspCount(Page page, Criteria criteria, RoleType roleType, Organization organization) {
		Assert.notNull(page, "分页参数不能为空");
		if (null == criteria) {
			criteria = new Criteria();
		}

		criteria.add("HSA_LOCATION_INFO.DATA_TYPE", OP.IN, new String[] { EHRConstants.LOCATION_DATA_TYPE_ADD, EHRConstants.LOCATION_DATA_TYPE_IMPORT });

		if (roleType.equals(RoleType.ZXJCSZ)) {
			Criteria areaOr = new Criteria("HSA_LOCATION_INFO.TOWNSHIP_LOT_CODE", OP.IN, getManagedAreaCode(organization.getOrganCode()));
			areaOr.add(LOP.OR, "HSA_LOCATION_INFO.TOWNSHIP_LOT_CODE", OP.IS, "NULL");
			criteria.add(areaOr);
		}

		PageList<Map<String, Object>> result = locationInfoDao.getPageLocationInfoMapList(page, criteria);

		if (null != result && ObjectUtil.isNotEmpty(result.getList())) {
			return result.getList();
		}

		return Collections.emptyList();
	}

	@Override
	public PageList<LocationInfo> getPagedLocInfosAddInspCount(Page page, Criteria criteria, RoleType roleType, Organization organization) {
		Assert.notNull(page, "分页参数不能为空");
		if (null == criteria) {
			criteria = new Criteria();
		}

		criteria.add("HSA_LOCATION_INFO.DATA_TYPE", OP.IN, new String[] { EHRConstants.LOCATION_DATA_TYPE_ADD, EHRConstants.LOCATION_DATA_TYPE_IMPORT });

        //银川目前无具体机构管辖区域  临时注掉  add by bagen at 2017-04-27
		/*if (roleType.equals(RoleType.ZX_GLY)) {
			Criteria areaOr = new Criteria("HSA_LOCATION_INFO.TOWNSHIP_LOT_CODE", OP.IN, getManagedAreaCode(organization.getOrganCode()));
			areaOr.add(LOP.OR, "HSA_LOCATION_INFO.TOWNSHIP_LOT_CODE", OP.IS, "NULL");
			criteria.add(areaOr);
		}*/

		PageList<LocationInfo> result = locationInfoDao.getPageLocationInfoList(page, criteria);
		if (null != result) {
			List<LocationInfo> infos = result.getList();
			if (null != infos) {
				Date currentDate = new Date();
				Date afterTwoMonthDate = DateUtil.add(new Date(), Calendar.MONTH, 2);
				afterTwoMonthDate = DateUtil.makeTimeToMax(afterTwoMonthDate);
				Date afterOneMonthDate = DateUtil.add(new Date(), Calendar.MONTH, 1);
				afterOneMonthDate = DateUtil.makeTimeToMax(afterOneMonthDate);
				for (LocationInfo locationInfo : infos) {
					Date duDate = locationInfo.getDueDate();
					if (null == duDate) {
						continue;
					}
					if (duDate.before(currentDate)) {
						locationInfo.setLicenseExpireType("4");
					} else if (duDate.before(afterOneMonthDate) || duDate.equals(afterOneMonthDate)) {
						locationInfo.setLicenseExpireType("3");
					} else if (duDate.before(afterTwoMonthDate) || duDate.equals(afterTwoMonthDate)) {
						locationInfo.setLicenseExpireType("2");
					} else {
						locationInfo.setLicenseExpireType("1");
					}
				}
			}
		}
		return result;
	}

	@Override
	public boolean checDulLocationInfo(LocationInfo locationInfo) {
		Assert.notNull(locationInfo, "地点信息不能为空");
		String selfCode = locationInfo.getOrganizationCode();
		// Assert.notNull(selfCode, "机构代码为空");
		if (ObjectUtil.isNullOrEmpty(selfCode)) {
			return false;
		}
		Criteria criteria = new Criteria("organizationCode", selfCode);
		Integer count = locationInfoDao.getCount(criteria, "id", Integer.class);
		if (null != count && count > 0) {
			//
			return true;
		}
		return false;
	}

	@Override
	public void cancel(Long id) {
		Assert.notNull(id, "地点信息id不能为空");
		Parameters parameters = new Parameters("status", EHRConstants.LOCATION_DATA_STATUS_CANCEL);
		Criteria criteria = new Criteria("id", id);
		criteria.add("dataType", EHRConstants.LOCATION_DATA_TYPE_ADD);
		locationInfoDao.update(parameters, criteria);
	}

	@Override
	@Transactional
	public Long addLocationInfo(LocationInfo locationInfo, Organization organization, User user) {
		Assert.notNull(locationInfo, "地点信息不能为空");
		Assert.notNull(organization, "创建机构不能为空");
		Assert.notNull(user, "创建用户不能为空");
		setInputInfo(false, locationInfo, organization, user);
		// 如果不指定数据类型,则默认为新增类型
		if (ObjectUtil.isNullOrEmpty(locationInfo.getDataType())) {
			locationInfo.setDataType(EHRConstants.LOCATION_DATA_TYPE_ADD);
		}
		locationInfo.setStatus(EHRConstants.LOCATION_DATA_STATUS_NORMAL);
		Number id = locationInfoDao.generatedKey(locationInfo, "ID", new String[] {});
		Assert.notNull(id, "地点信息创建失败");
		return id.longValue();
	}

	@Override
	@Transactional
	public Long updateLocationInfo(LocationInfo locationInfo, Organization organization, User user) {
		Assert.notNull(locationInfo, "地点信息不能为空");
		Assert.notNull(organization, "创建机构不能为空");
		Assert.notNull(user, "创建用户不能为空");

		Long id = locationInfo.getId();
		Assert.notNull(user, "地点id不能为空");

		setInputInfo(true, locationInfo, organization, user);
		locationInfoDao.update(locationInfo, UPDATE_PROPERTIES);
		return id;
	}

	private void setInputInfo(boolean update, LocationInfo locationInfo, Organization organization, User user) {
		if (!update) {
			locationInfo.setCreateOrganCode(organization.getOrganCode());
			locationInfo.setCreateDoctorCode(user.getId() == null ? "" : user.getId().toString());
			locationInfo.setCreateDate(new Date());
		}
		locationInfo.setUpdateDate(new Date());
		locationInfo.setUpdateDoctorCode(user.getId() == null ? "" : user.getId().toString());
		locationInfo.setUpdateOrganCode(organization.getOrganCode());
	}

	@Override
	public void importLocationInfos(List<LocationInfo> list) {
		if (ObjectUtil.isNullOrEmpty(list)) {
			return;
		}
		Map<String, LocationInfo> news = new HashMap<>();
		// 检查,转换数据
		for (LocationInfo locationInfo : list) {
			String mainId = locationInfo.getMainId();
			if (ObjectUtil.isNullOrEmpty(mainId)) {
				throw new RuntimeException(locationInfo.getUnitName() + "主键为空");
			}
			String secondaryId = locationInfo.getSecondaryId();
			if (ObjectUtil.isNullOrEmpty(secondaryId)) {
				throw new RuntimeException(locationInfo.getUnitName() + "业务主键为空");
			}
			cal(locationInfo, news);
			// 字典转换
			convertLocationInfoData(locationInfo);

			calDataType(locationInfo);
		}

		// 导入地点数据
		Collection<LocationInfo> locationList = news.values();
		// int size = locationList.size();
		for (LocationInfo locationInfo : locationList) {
			String mainId = locationInfo.getMainId();
			Criteria criteria = new Criteria("mainId", mainId);
			LocationInfo oldLocationInfo = locationInfoDao.get(criteria, "id");
			// locationInfo.setDataType(EHRConstants.LOCATION_DATA_TYPE_IMPORT);
			if (null != oldLocationInfo) {
				locationInfo.setLocationInfoId(oldLocationInfo.getId());
				locationInfoDao.importOnUpdate(locationInfo);
			} else {
				// locationInfo.setStatus(EHRConstants.LOCATION_DATA_STATUS_NORMAL);
				// locationInfo.setCreateDate(new Date());
				Number id = locationInfoDao.generatedKey(locationInfo, "ID", null);
				locationInfo.setLocationInfoId(id.longValue());
			}
			// System.err.println(size--);
		}

		// size = list.size();
		// 导入业务数据
		for (LocationInfo locationInfo : list) {
			String mainId = locationInfo.getMainId();
			LocationInfo saved = news.get(mainId);
			locationInfo.setLocationInfoId(saved.getLocationInfoId());
			String secondaryId = locationInfo.getSecondaryId();
			Criteria criteria = new Criteria("secondaryId", secondaryId);
			Integer count = businessInfoDao.getCount(criteria, "secondaryId", Integer.class);
			if (null != count && count > 0) {
				businessInfoDao.importOnUpdate(locationInfo);
			} else {
				businessInfoDao.importOnAdd(locationInfo);
			}
			// System.err.println(size--);
		}

		locationList = null;
		news = null;
	}

	private void cal(LocationInfo locationInfo, Map<String, LocationInfo> news) {
		String mainId = locationInfo.getMainId();
		LocationInfo oldLocationInfo = news.get(mainId);
		if (null != oldLocationInfo) {
			Date old = oldLocationInfo.getUpdateDate();
			Date neww = locationInfo.getUpdateDate();
			if (null == old && neww != null) {
				news.put(mainId, locationInfo);
			} else if (null != old && neww != null && neww.after(old)) {
				news.put(mainId, locationInfo);
			}
		} else {
			news.put(mainId, locationInfo);
		}
	}

	@Override
	public List<String> getManagedAreaCode(String organCode) {
		Criteria criteria = new Criteria("organizationCode", organCode);
		criteria.add("areaType", AreaType.TOWN.getValue());
		List<OrganizationArea> areas = organizationService.getOrganizationAreas(criteria);
		List<String> areaCodes = Collections.emptyList();
		if (ObjectUtil.isNotEmpty(areas)) {
			areaCodes = new ArrayList<>(areas.size());
			for (OrganizationArea organizationArea : areas) {
				areaCodes.add(organizationArea.getAreaCode());
			}
		}
		return areaCodes;
	}

	private void calDataType(LocationInfo info) {
		String code = info.getMainBusinessCode();
		code = code == null ? "" : code;
		if (NOT_SHOW_MAIN_BUSINESS_CODE.contains(code)) {
			info.setDataType(EHRConstants.LOCATION_DATA_TYPE_IMPORT_NOT_SHOW);
		} else {
			info.setDataType(EHRConstants.LOCATION_DATA_TYPE_IMPORT);
		}
	}

	private void convertLocationInfoData(LocationInfo info) {

		// 转换无档
		String noFile = info.getNoFile();
		info.setNoFileOri(noFile);
		if (ObjectUtil.isNotEmpty(noFile)) {
			String newNoFile = FILE_CODE.get(noFile.trim());
			if (ObjectUtil.isNullOrEmpty(newNoFile)) {
				log.warn("无档标志转换失败,范围之外的编码:" + noFile);
			}
			info.setNoFile(newNoFile);
		}

		// 转换许可证有无
		String noFileId = info.getNoFileId();
		info.setNoFileIdOri(noFileId);
		if (ObjectUtil.isNotEmpty(noFileId)) {
			String newNoFileId = FILE_CODE.get(noFileId.trim());
			if (ObjectUtil.isNullOrEmpty(newNoFileId)) {
				log.warn("许可证有无标志转换失败,范围之外的编码:" + noFileId);
			}
			info.setNoFileId(newNoFileId);
		}

		// 转换单位规模
		String scale = info.getScale();
		info.setScaleOri(scale);
		if (ObjectUtil.isNotEmpty(scale)) {
			String newScale = SCALE.get(scale.trim());
			if (ObjectUtil.isNullOrEmpty(newScale)) {
				log.warn("单位规模转换失败,范围之外的编码:" + scale);
			}
			info.setScale(newScale);
		}
		// 转换证件类别
		String cardType = info.getDocumentTypeCode();
		info.setDocumentTypeCodeOri(cardType);
		if (ObjectUtil.isNotEmpty(cardType)) {
			String newtype = CARD_TYPE.get(cardType.trim());
			if (ObjectUtil.isNullOrEmpty(newtype)) {
				log.warn("证件类别转换失败,范围之外的编码:" + cardType);
			}
			info.setDocumentTypeCode(newtype);
		}
		// 单位类型
		String unitType = info.getUnitTypeCode();
		info.setUnitTypeCodeOri(unitType);
		if (ObjectUtil.isNotEmpty(unitType)) {
			String newUnitType = UNIT_TYPE.get(unitType.trim());
			if (ObjectUtil.isNullOrEmpty(newUnitType)) {
				log.warn("单位类型转换失败,范围之外的编码:" + unitType);
			}
			info.setUnitTypeCode(newUnitType);
		}

		// 乡镇地段
		String townCode = info.getTownshipLotCode();
		info.setTownshipLotCodeOri(townCode);
		if (ObjectUtil.isNotEmpty(townCode)) {
			String newTownCode = TOWN_SHIP.get(townCode.trim());
			if (ObjectUtil.isNullOrEmpty(newTownCode)) {
				log.warn("乡镇地段转换失败,范围之外的编码:" + townCode);
			}
			info.setTownshipLotCode(newTownCode);
		}
		// 经济性质
		String ecNature = info.getEconomicNatureCode();
		info.setEconomicNatureCodeOri(ecNature);
		if (ObjectUtil.isNotEmpty(ecNature)) {
			String newEcNature = EC_NATURE.get(ecNature.trim());
			if (ObjectUtil.isNullOrEmpty(newEcNature)) {
				log.warn(" 经济性质转换失败,范围之外的编码:" + ecNature);
			}
			info.setEconomicNatureCode(newEcNature);
		}

		// 业务类型
		String businessTypeCode = info.getBusinessTypeCode();
		info.setBusinessTypeCodeOri(businessTypeCode);
		if (ObjectUtil.isNotEmpty(businessTypeCode)) {
			String newBusinessTypeCode = BUSINESS_TYPE_CODE.get(businessTypeCode.trim());
			if (ObjectUtil.isNullOrEmpty(newBusinessTypeCode)) {
				log.warn("业务类型转换失败,范围之外的编码:" + businessTypeCode);
			}
			info.setBusinessTypeCode(newBusinessTypeCode);
		}

		// 许可证状态
		String licenseStateCode = info.getLicenseStateCode();
		info.setLicenseStateCodeOri(licenseStateCode);
		if (ObjectUtil.isNotEmpty(licenseStateCode)) {
			String newLicenseStateCode = LICENSE_STATE_CODE.get(licenseStateCode.trim());
			if (ObjectUtil.isNullOrEmpty(newLicenseStateCode)) {
				log.warn("许可证状态转换失败,范围之外的编码:" + ecNature);
			}
			info.setLicenseStateCode(newLicenseStateCode);
		}

		// 卫生专业
		String healthProfessional = info.getHealthProfessional();
		// 保存原始数据
		info.setHealthProfessionalOri(healthProfessional);
		if (ObjectUtil.isNotEmpty(healthProfessional)) {
			healthProfessional = healthProfessional.trim();
			// 特殊项
			if ("医".equals(healthProfessional)) {
				String mainBusinessCode = info.getMainBusinessCode();
				if (null != mainBusinessCode && mainBusinessCode.trim().startsWith("10")) {
					healthProfessional = "传";
				}
			}

			if ("学".equals(healthProfessional)) {
				String mainBusinessCode = info.getMainBusinessCode();
				if (null != mainBusinessCode && mainBusinessCode.trim().equals("0599")) {
					healthProfessional = "传";
				}
			}

			String newHealthProfessional = HEALTH_PROFESSIONAL.get(healthProfessional.trim());
			if (ObjectUtil.isNullOrEmpty(newHealthProfessional)) {
				log.warn("卫生专业转换失败,范围之外的编码:" + healthProfessional);
				// 暂给其他
				info.setHealthProfessional("99");
			} else {
				info.setHealthProfessional(newHealthProfessional);
			}
		}

		// 主营行业
		String mainBusinessCode = info.getMainBusinessCode();
		// 保存原始数据
		info.setMainBusinessCodeOri(mainBusinessCode);
		if (ObjectUtil.isNotEmpty(mainBusinessCode)) {
			mainBusinessCode = mainBusinessCode.trim();
			// 截取编码处理
			if (mainBusinessCode.startsWith("10")) {
				mainBusinessCode = "10";// 医 医疗卫生单位 10 （档案中的主营行业分类有下级代码，取左侧二个字符）
			} else if (mainBusinessCode.startsWith("06")) {
				mainBusinessCode = "06";// 传 消毒产品生产单位 06
										// （档案中的主营行业分类有下级代码，取左侧二个字符）
			} else if (mainBusinessCode.startsWith("0201")) {
				mainBusinessCode = "0201";// 水 集中式供水
											// 0201（档案中的主营行业分类有下级代码，取左侧四个字符）
			} else if (mainBusinessCode.startsWith("0202")) {
				mainBusinessCode = "0202";// 水 二次供水
											// 0202（档案中的主营行业分类有下级代码，取左侧四个字符）
			} else if (mainBusinessCode.startsWith("0203")) {
				mainBusinessCode = "0203";// 水 涉水产品生产单位
											// 0203（档案中的主营行业分类有下级代码，取左侧四个字符）
			}

			String newMainBusinessCode = MAIN_BUSINESS_CODE.get(mainBusinessCode);
			if (ObjectUtil.isNullOrEmpty(newMainBusinessCode)) {
				log.warn("主营行业转换失败,范围之外的编码:" + mainBusinessCode);
			}
			info.setMainBusinessCode(newMainBusinessCode);
		}

		// 责任监督员
		String supervisorCode = info.getSupervisorCode();
		info.setSupervisorCodeOri(supervisorCode);
		if (ObjectUtil.isNotEmpty(supervisorCode)) {
			if ("-1".equals(supervisorCode.trim())) {
				info.setSupervisorCode(null);
			}
		}

		// 计算注销状态
		if ("9".equals(info.getBusinessTypeCode()) || "2".equals(info.getLicenseStateCode())) {
			info.setStatus(EHRConstants.LOCATION_DATA_STATUS_CANCEL);
		} else {
			info.setStatus(EHRConstants.LOCATION_DATA_STATUS_NORMAL);
		}

		// 业务新记录标志
		String newRecordFlag = info.getNewRecordFlag();
		info.setNewRecordFlagOri(newRecordFlag);
		if (ObjectUtil.isNotEmpty(newRecordFlag)) {
			String newNewRecordFlag = NEW_RECORD_FLAG.get(newRecordFlag.trim());
			if (ObjectUtil.isNullOrEmpty(newNewRecordFlag)) {
				log.warn("业务新记录标志转换失败,范围之外的编码:" + newRecordFlag);
			}
			info.setNewRecordFlag(newNewRecordFlag);
		}
	}

	// ====================行政处罚=================//
    
	@Override
	public void importPenaltyInfos(List<PenaltyInfo> list) {
		if (ObjectUtil.isNullOrEmpty(list)) {
			return;
		}
		Date now = new Date();
		for (PenaltyInfo info : list) {
			String mainId = info.getMainId();
            if (ObjectUtil.isNullOrEmpty(mainId)){
                throw  new RuntimeException("mainId为空,单位名称:"+info.getUnitName());
            }
            info.setUpdateDate(now);
			Criteria criteria = new Criteria("mainId", mainId);
			PenaltyInfo oldPenPenaltyInfo = penaltyInfoDao.get(criteria, "id", "createDate","isDelete");
			if (null != oldPenPenaltyInfo) {
				info.setCreateDate(oldPenPenaltyInfo.getCreateDate());
                info.setIsDelete(oldPenPenaltyInfo.getIsDelete());
				info.setId(oldPenPenaltyInfo.getId());
				penaltyInfoDao.update(info);
			} else {
				info.setCreateDate(now);
                info.setIsDelete(EHRConstants.DELETE_FLG_0);
				penaltyInfoDao.insert(info);
			}
		}
	}

}
