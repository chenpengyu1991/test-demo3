package com.founder.rhip.ehr.service.statistics.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ehr.entity.basic.EhrDocLevel;
import com.founder.rhip.ehr.repository.statistics.IEhrDocLevelDao;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.HaStatistics;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.statistics.IHaStatisticsDao;
import com.founder.rhip.ehr.service.statistics.IStatisticsService;
import com.founder.rhip.ehr.util.StatisticsUtil;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IOrganizationDao;

/**
 * Created with IntelliJ IDEA. User: Andy Date: 13-1-8 Time: 下午1:48 To change
 * this template use File | Settings | File Templates.
 */
@Service("statisticsService")
public class StatisticsServiceImpl extends AbstractService implements IStatisticsService {

	@Resource
	private IHaStatisticsDao haStatisticsDao;

	@Resource
	private IOrganizationDao organizationDao;

	@Resource
	private IOrganizationApp organizationApp;

	@Resource
	private IDictionaryApp dictionaryApp;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "ehrDocLevelDao")
	private IEhrDocLevelDao ehrDocLevelDao;

	// 根据管理员，中心，站查询
	private static final Integer MANAGE_ADMIN = 0;
	private static final Integer MANAGE_CENTER = 1;
	private static final Integer MANAGE_ORG = 2;

	// 根据年月日查询
	private static final String DATE_TYPE_DAY = "1";
	private static final String DATE_TYPE_MONTH = "2";
	private static final String DATE_TYPE_YEAR = "3";

	public IHaStatisticsDao getHaStatisticsDao() {
		return haStatisticsDao;
	}

	public void setHaStatisticsDao(IHaStatisticsDao haStatisticsDao) {
		this.haStatisticsDao = haStatisticsDao;
	}

	public static HaStatistics vo = new HaStatistics();

	public static Map<String, Object> paramMap = new HashMap<String, Object>();

	@Override
	public List<HaStatistics> getCommunityArchiveManagementList(Map<String, Object> paramMap) {
		return haStatisticsDao.getCommunityArchiveManagementList(paramMap);
	}

	@Override
	public List<HaStatistics> getCdcArchiveManagementList(Map<String, Object> paramMap) {
		paramMap.put("organList", organizationDao.getOrganizationList(paramMap.get("orgCode").toString()));
		return haStatisticsDao.getCdcArchiveManagementList(paramMap);
	}

	@Override
	public List<HaStatistics> getAdminArchiveManagementList(Map<String, Object> paramMap) {
		return haStatisticsDao.getAdminArchiveManagementList(paramMap);
	}

	@Override
	public void getArchiveManagementList(Date startDate, Date endDate) {
		Criteria criteria = new Criteria();
		DateUtil.getCriteriaByDateRange(criteria, "inputDate", startDate, endDate);

	}

	private Date[] getDateBetween(String type) {
		Date nowDate = new Date();
		if (type.equals(DATE_TYPE_DAY)) {
			return new Date[] { DateUtil.firstTimeOfDay(nowDate), DateUtil.lastTimeOfDay(nowDate) };
		} else if (type.equals(DATE_TYPE_MONTH)) {
			return new Date[] { DateUtil.firstDateOfMonth(nowDate), DateUtil.lastDateOfMonth(nowDate) };
		} else if (type.equals(DATE_TYPE_YEAR)) {
			return new Date[] { DateUtil.firstDateOfYear(nowDate), DateUtil.lastDateOfYear(nowDate) };
		}
		return new Date[] { null, null };
	}

	/**
	 * @Title: getArchiveManagementList
	 * @Description: 查询统计数据
	 * @param @param startDate
	 * @param @param endDate
	 * @param @param code 中心或者站的编码
	 * @param @param type 0为ADMIN，1为中心，2为站
	 * @return void
	 * @throws
	 */
	@Override
	public Map<String, Long> getArchiveManagementList(String dateType, Organization organization, Integer type) {
		Date[] dateArr = getDateBetween(dateType);

//		System.out.println("========" + new Date());

		Criteria icriteria = getOrgCriteria(organization, type, "CREATE_DATE", dateArr[0], dateArr[1], "CREATE_ORGAN_CODE", "CREATE_CENTER_ORGAN_CODE");
		List<Map<String, Object>> mapList = personInfoDao.getTypeCount(icriteria);

		Criteria ucriteria = getOrgCriteria(organization, type, "UPDATE_DATE", dateArr[0], dateArr[1], "INPUT_ORGAN_CODE", "INPUT_CENTER_ORGAN_CODE");
		List<Map<String, Object>> umapList = personInfoDao.getTypeCount(ucriteria);

		Criteria ccriteria = getOrgCriteria(organization, type, "LOGOUT_DATE", dateArr[0], dateArr[1], "INPUT_ORGAN_CODE", "INPUT_CENTER_ORGAN_CODE");
		// 注销条件
		ccriteria.add("FILING_FLAG", 9);
		List<Map<String, Object>> cmapList = personInfoDao.getTypeCount(ccriteria);

		Criteria scriteria = getOrgCriteria(organization, type, "INPUT_DATE", dateArr[0], dateArr[1], "INPUT_ORGAN_CODE", "INPUT_CENTER_ORGAN_CODE");
		scriteria.add("FILING_FLAG",'1');
		// 星级1,2,3
		scriteria.add("STAR", OP.IN, new String[] { "1", "2", "3" });
		List<Map<String, Object>> smapList = personInfoDao.getStarCount(scriteria);

		//迁出
		Criteria personCanceled = getOrgCriteria(organization, type, "OPERATION_DATE", dateArr[0], dateArr[1], "INPUT_ORGAN_CODE", "INPUT_CENTER_ORGAN_CODE");
		List<Map<String, Object>> pmapList = personInfoDao.getCanceledInfoCount(personCanceled);
		Map<String, Long> retMap = new HashMap<String, Long>();

		// 新增户籍非户籍
		retMap.put("hrArchiveNew", 0L);
		retMap.put("unhrArchiveNew", 0L);
		// 修改户籍非沪江
		retMap.put("hrArchiveTotal", 0L);
		retMap.put("unhrArchiveTotal", 0L);
		// 注销户籍非沪江
		retMap.put("hrArchiveCancel", 0L);
		retMap.put("unhrArchiveCancel", 0L);
		// 一二三星户籍非户籍
		retMap.put("hrOneStar", 0L);
		retMap.put("hrTwoStar", 0L);
		retMap.put("hrThreeStar", 0L);
		retMap.put("unhrOneStar", 0L);
		retMap.put("unhrTwoStar", 0L);
		retMap.put("unhrThreeStar", 0L);
		// 迁出
		retMap.put("hrArchiveEmigration", 0L);
		retMap.put("unhrArchiveEmigration", 0L);
		
		setCountMap(retMap, "hrArchiveNew", "unhrArchiveNew", mapList);
		setCountMap(retMap, "hrArchiveTotal", "unhrArchiveTotal", umapList);
		setCountMap(retMap, "hrArchiveCancel", "unhrArchiveCancel", cmapList);
		setCountMap(retMap, "hrArchiveEmigration", "unhrArchiveEmigration", pmapList);
		for (Map<String, Object> map : smapList) {
			String star = map.get("STAR").toString();
			if (star.equals("1")) {
				setMap(map, retMap, "hrOneStar", "unhrOneStar");
			} else if (star.equals("2")) {
				setMap(map, retMap, "hrTwoStar", "unhrTwoStar");
			} else if (star.equals("3")) {
				setMap(map, retMap, "hrThreeStar", "unhrThreeStar");
			}
		}

//		System.out.println("========" + new Date());
		return retMap;
	}

	/**
	 * @Title: setCountMap
	 * @Description: 设置Map
	 * @param @param retMap
	 * @param @param unKey
	 * @param @param hrKey
	 * @param @param mapList
	 * @return void
	 * @throws
	 */
	private void setCountMap(Map<String, Long> retMap, String hrKey, String unKey, List<Map<String, Object>> mapList) {
		for (Map<String, Object> map : mapList) {
			setMap(map, retMap, hrKey, unKey);
		}
	}

	private void setMap(Map<String, Object> map, Map<String, Long> retMap, String hrKey, String unKey) {
		String householdType = map.get("HOUSEHOLD_TYPE").toString();
		Long pCount = Long.parseLong(map.get("pCount").toString());
		// 户籍
		if (householdType.equals(EHRConstants.HOUSE_HOLDER)) {
			retMap.put(hrKey, pCount);
		} else {
			retMap.put(unKey, pCount);
		}
	}

	/**
	 * @Title: getOrgCriteria
	 * @Description: 测试
	 * @param @param code
	 * @param @param type
	 * @param @param unHr
	 * @param @return
	 * @return Criteria
	 * @throws
	 */
	private Criteria getOrgCriteria(Organization organization, Integer type, String dateProperty, Date startDate, Date endDate,
									String orgCode, String orgCenterCode) {
		String code = organization.getOrganCode();
		Criteria criteria = new Criteria("HOUSEHOLD_TYPE", OP.IN, new String[] { "1", "2" });
		DateUtil.getCriteriaByDateRange(criteria, dateProperty, startDate, endDate);
		if (MANAGE_ADMIN.equals(type)) {
			return criteria;
		} else if (MANAGE_CENTER.equals(type)) {
			return criteria.add(orgCenterCode, code);
		} else if (MANAGE_ORG.equals(type)) {
			return criteria.add(orgCode, code);
		}else if(type.equals(3)){
			List<Organization> organizationList = organizationApp.queryOrganization(new Criteria("gbCode",organization.getGbCode()).add("genreCode",OP.IN, new String[]{OrgGenreCode.CENTRE.getValue(), OrgGenreCode.STATION.getValue()}));
			List<String> orgCodeList = new ArrayList<>();
			for(Organization organ : organizationList){
				orgCodeList.add(organ.getOrganCode());
			}
			return criteria.add(orgCode, OP.IN,orgCodeList);
		}
		return criteria;
	}

	@Override
	public List<HaStatistics> getCommunityMajorCrowdList(Map<String, Object> paramMap) {
		return haStatisticsDao.getCommunityMajorCrowdList(paramMap);
	}

	@Override
	public List<HaStatistics> getCdcMajorCrowdList(Map<String, Object> paramMap) {
		return haStatisticsDao.getCdcMajorCrowdList(paramMap);
	}

	@Override
	public List<HaStatistics> getAdminMajorCrowdList(Map<String, Object> paramMap) {
		return haStatisticsDao.getAdminMajorCrowdList(paramMap);
	}

	@Override
	public List<HaStatistics> getCdmList(Map<String, Object> paramMap) {
		return haStatisticsDao.getCdmList(paramMap);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public synchronized boolean syncStatisticsData(Organization org, String column, String operation) {
		Boolean flag = true;
		Criteria cr = new Criteria("orgCode", org.getOrganCode());

		Organization entity = organizationDao.getGbcodeByOrganization(org.getOrganCode());
		if (haStatisticsDao.getCountByDateAndOrgcode(cr) == 0) {
			try {
				vo = new HaStatistics();
				vo.setOrgCode(org.getOrganCode());
				vo.setOrgName(org.getOrganName());
				vo.setStatisticsDate(new Date());
				if ("0".equals(entity.getParentCode())) {
					vo.setGbcode(entity.getGbCode());
					vo.setTownName(dictionaryApp.queryDicItem("FS990001", entity.getGbCode()).getItemName());
				}
				buildParamMap();
				buildVo(column, operation);
				haStatisticsDao.insert(vo, column, "orgCode", "orgName", "gbcode", "townName", "statisticsDate");
			} catch (Exception e) {
				flag = false;
			}
		} else {
			try {
				vo = haStatisticsDao.getEntityByDateAndOrgcode(cr);
				buildParamMap();
				if (vo != null) {
					buildVo(column, operation);
					haStatisticsDao.update(vo, column);
				}
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}

	private void buildParamMap() {
		paramMap.put(StatisticsUtil.HR_ARCHIVE_CANCEL, vo.getHrArchiveCancel());
		paramMap.put(StatisticsUtil.HR_ARCHIVE_COUNT, vo.getHrArchiveCount());
		paramMap.put(StatisticsUtil.HR_ARCHIVE_EMIGRATION, vo.getHrArchiveEmigration());
		paramMap.put(StatisticsUtil.HR_ARCHIVE_NEW, vo.getHrArchiveNew());
		paramMap.put(StatisticsUtil.HR_ARCHIVE_TOTAL, vo.getHrArchiveTotal());
		paramMap.put(StatisticsUtil.HR_CA, vo.getHrCa());
		paramMap.put(StatisticsUtil.HR_DM, vo.getHrDm());
		paramMap.put(StatisticsUtil.HR_FERTILE_WOMAN, vo.getHrFertileWoman());
		paramMap.put(StatisticsUtil.HR_GREAT_SIXF, vo.getHrGreatSixf());
		paramMap.put(StatisticsUtil.HR_HBP, vo.getHrHbp());
		paramMap.put(StatisticsUtil.HR_HD, vo.getHrHd());
		paramMap.put(StatisticsUtil.HR_IN_HOSPITAL, vo.getHrInHospital());
		paramMap.put(StatisticsUtil.HR_OUTPATIENT, vo.getHrOutpatient());
		paramMap.put(StatisticsUtil.HR_PE, vo.getHrPe());
		paramMap.put(StatisticsUtil.HR_SIX_CHILD, vo.getHrSixChild());
		paramMap.put(StatisticsUtil.HR_SIXO_TO_SIXF, vo.getHrSixoToSixf());
		paramMap.put(StatisticsUtil.HR_STROKE, vo.getHrStroke());
		paramMap.put(StatisticsUtil.UNHR_ARCHIVE_CANCEL, vo.getUnhrArchiveCancel());
		paramMap.put(StatisticsUtil.UNHR_ARCHIVE_COUNT, vo.getUnhrArchiveCount());
		paramMap.put(StatisticsUtil.UNHR_ARCHIVE_EMIGRATION, vo.getUnhrArchiveEmigration());
		paramMap.put(StatisticsUtil.UNHR_ARCHIVE_NEW, vo.getUnhrArchiveNew());
		paramMap.put(StatisticsUtil.UNHR_ARCHIVE_TOTAL, vo.getUnhrArchiveTotal());
		paramMap.put(StatisticsUtil.UNHR_CA, vo.getUnhrCa());
		paramMap.put(StatisticsUtil.UNHR_DM, vo.getUnhrDm());
		paramMap.put(StatisticsUtil.UNHR_FERTILE_WOMAN, vo.getUnhrFertileWoman());
		paramMap.put(StatisticsUtil.UNHR_GREAT_SIXF, vo.getUnhrGreatSixf());
		paramMap.put(StatisticsUtil.UNHR_HBP, vo.getUnhrHbp());
		paramMap.put(StatisticsUtil.UNHR_HD, vo.getUnhrHd());
		paramMap.put(StatisticsUtil.UNHR_IN_HOSPITAL, vo.getUnhrInHospital());
		paramMap.put(StatisticsUtil.UNHR_OUTPATIENT, vo.getUnhrOutpatient());
		paramMap.put(StatisticsUtil.UNHR_PE, vo.getUnhrPe());
		paramMap.put(StatisticsUtil.UNHR_SIX_CHILD, vo.getUnhrSixChild());
		paramMap.put(StatisticsUtil.UNHR_SIXO_TO_SIXF, vo.getUnhrSixoToSixf());
		paramMap.put(StatisticsUtil.UNHR_STROKE, vo.getUnhrStroke());
		paramMap.put(StatisticsUtil.HR_ONE_STAR, vo.getHrOneStar());
		paramMap.put(StatisticsUtil.HR_TWO_STAR, vo.getHrTwoStar());
		paramMap.put(StatisticsUtil.HR_THREE_STAR, vo.getHrThreeStar());
		paramMap.put(StatisticsUtil.UNHR_ONE_STAR, vo.getUnhrOneStar());
		paramMap.put(StatisticsUtil.UNHR_TWO_STAR, vo.getUnhrOneStar());
		paramMap.put(StatisticsUtil.UNHR_THREE_STAR, vo.getUnhrThreeStar());
	}

	private void buildVo(String column, String operation) {
		if (paramMap.get(column) != null && Integer.valueOf(paramMap.get(column).toString()) > 0) {
			switch (operation) {
			case StatisticsUtil.ADD: {
				switch (column) {
				case StatisticsUtil.HR_ARCHIVE_CANCEL:
					vo.setHrArchiveCancel(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_ARCHIVE_COUNT:
					vo.setHrArchiveCount(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_ARCHIVE_EMIGRATION:
					vo.setHrArchiveEmigration(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_ARCHIVE_NEW:
					vo.setHrArchiveNew(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_ARCHIVE_TOTAL:
					vo.setHrArchiveTotal(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_CA:
					vo.setHrCa(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_DM:
					vo.setHrDm(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_FERTILE_WOMAN:
					vo.setHrFertileWoman(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_GREAT_SIXF:
					vo.setHrGreatSixf(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_HBP:
					vo.setHrHbp(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_HD:
					vo.setHrHd(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_IN_HOSPITAL:
					vo.setHrInHospital(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_OUTPATIENT:
					vo.setHrOutpatient(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_PE:
					vo.setHrPe(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_SIX_CHILD:
					vo.setHrSixChild(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_SIXO_TO_SIXF:
					vo.setHrSixoToSixf(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_STROKE:
					vo.setHrStroke(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_ONE_STAR:
					vo.setHrOneStar(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_TWO_STAR:
					vo.setHrTwoStar(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.HR_THREE_STAR:
					vo.setHrThreeStar(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.UNHR_ONE_STAR:
					vo.setUnhrOneStar(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.UNHR_TWO_STAR:
					vo.setUnhrTwoStar(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.UNHR_THREE_STAR:
					vo.setUnhrThreeStar(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_NEW:
					vo.setUnhrArchiveNew(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_COUNT:
					vo.setUnhrArchiveCount(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_CANCEL:
					vo.setUnhrArchiveCancel(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_EMIGRATION:
					vo.setUnhrArchiveEmigration(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_TOTAL:
					vo.setUnhrArchiveTotal(Integer.valueOf(paramMap.get(column).toString()) + 1);
					break;
				default:
					break;
				}
			}
				break;
			case StatisticsUtil.DELETE:
				switch (column) {
				case StatisticsUtil.HR_ARCHIVE_CANCEL:
					vo.setHrArchiveCancel(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_ARCHIVE_COUNT:
					vo.setHrArchiveCount(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_ARCHIVE_EMIGRATION:
					vo.setHrArchiveEmigration(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_ARCHIVE_NEW:
					vo.setHrArchiveNew(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_ARCHIVE_TOTAL:
					vo.setHrArchiveTotal(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_CA:
					vo.setHrCa(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_DM:
					vo.setHrDm(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_FERTILE_WOMAN:
					vo.setHrFertileWoman(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_GREAT_SIXF:
					vo.setHrGreatSixf(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_HBP:
					vo.setHrHbp(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_HD:
					vo.setHrHd(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_IN_HOSPITAL:
					vo.setHrInHospital(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_OUTPATIENT:
					vo.setHrOutpatient(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_PE:
					vo.setHrPe(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_SIX_CHILD:
					vo.setHrSixChild(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_SIXO_TO_SIXF:
					vo.setHrSixoToSixf(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_STROKE:
					vo.setHrStroke(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_ONE_STAR:
					vo.setHrOneStar(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_TWO_STAR:
					vo.setHrTwoStar(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.HR_THREE_STAR:
					vo.setHrThreeStar(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.UNHR_ONE_STAR:
					vo.setUnhrOneStar(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.UNHR_TWO_STAR:
					vo.setUnhrTwoStar(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				case StatisticsUtil.UNHR_THREE_STAR:
					vo.setUnhrThreeStar(Integer.valueOf(paramMap.get(column).toString()) - 1);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		} else {
			switch (operation) {
			case StatisticsUtil.ADD: {
				switch (column) {
				case StatisticsUtil.HR_ARCHIVE_CANCEL:
					vo.setHrArchiveCancel(1);
					break;
				case StatisticsUtil.HR_ARCHIVE_COUNT:
					vo.setHrArchiveCount(1);
					break;
				case StatisticsUtil.HR_ARCHIVE_EMIGRATION:
					vo.setHrArchiveEmigration(1);
					break;
				case StatisticsUtil.HR_ARCHIVE_NEW:
					vo.setHrArchiveNew(1);
					break;
				case StatisticsUtil.HR_ARCHIVE_TOTAL:
					vo.setHrArchiveTotal(1);
					break;
				case StatisticsUtil.HR_CA:
					vo.setHrCa(1);
					break;
				case StatisticsUtil.HR_DM:
					vo.setHrDm(1);
					break;
				case StatisticsUtil.HR_FERTILE_WOMAN:
					vo.setHrFertileWoman(1);
					break;
				case StatisticsUtil.HR_GREAT_SIXF:
					vo.setHrGreatSixf(1);
					break;
				case StatisticsUtil.HR_HBP:
					vo.setHrHbp(1);
					break;
				case StatisticsUtil.HR_HD:
					vo.setHrHd(1);
					break;
				case StatisticsUtil.HR_IN_HOSPITAL:
					vo.setHrInHospital(1);
					break;
				case StatisticsUtil.HR_OUTPATIENT:
					vo.setHrOutpatient(1);
					break;
				case StatisticsUtil.HR_PE:
					vo.setHrPe(1);
					break;
				case StatisticsUtil.HR_SIX_CHILD:
					vo.setHrSixChild(1);
					break;
				case StatisticsUtil.HR_SIXO_TO_SIXF:
					vo.setHrSixoToSixf(1);
					break;
				case StatisticsUtil.HR_STROKE:
					vo.setHrStroke(1);
					break;
				case StatisticsUtil.HR_ONE_STAR:
					vo.setHrOneStar(1);
					break;
				case StatisticsUtil.HR_TWO_STAR:
					vo.setHrTwoStar(1);
					break;
				case StatisticsUtil.HR_THREE_STAR:
					vo.setHrThreeStar(1);
					break;
				case StatisticsUtil.UNHR_ONE_STAR:
					vo.setUnhrOneStar(1);
					break;
				case StatisticsUtil.UNHR_TWO_STAR:
					vo.setUnhrTwoStar(1);
					break;
				case StatisticsUtil.UNHR_THREE_STAR:
					vo.setUnhrThreeStar(1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_NEW:
					vo.setUnhrArchiveNew(1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_COUNT:
					vo.setUnhrArchiveCount(1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_CANCEL:
					vo.setUnhrArchiveCancel(1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_EMIGRATION:
					vo.setUnhrArchiveEmigration(1);
					break;
				case StatisticsUtil.UNHR_ARCHIVE_TOTAL:
					vo.setUnhrArchiveTotal(1);
					break;
				default:
					break;
				}
			}
				break;
			case StatisticsUtil.DELETE:
				switch (column) {
				case StatisticsUtil.HR_ARCHIVE_CANCEL:
					vo.setHrArchiveCancel(0);
					break;
				case StatisticsUtil.HR_ARCHIVE_COUNT:
					vo.setHrArchiveCount(0);
					break;
				case StatisticsUtil.HR_ARCHIVE_EMIGRATION:
					vo.setHrArchiveEmigration(0);
					break;
				case StatisticsUtil.HR_ARCHIVE_NEW:
					vo.setHrArchiveNew(0);
					break;
				case StatisticsUtil.HR_ARCHIVE_TOTAL:
					vo.setHrArchiveTotal(0);
					break;
				case StatisticsUtil.HR_CA:
					vo.setHrCa(0);
					break;
				case StatisticsUtil.HR_DM:
					vo.setHrDm(0);
					break;
				case StatisticsUtil.HR_FERTILE_WOMAN:
					vo.setHrFertileWoman(0);
					break;
				case StatisticsUtil.HR_GREAT_SIXF:
					vo.setHrGreatSixf(0);
					break;
				case StatisticsUtil.HR_HBP:
					vo.setHrHbp(0);
					break;
				case StatisticsUtil.HR_HD:
					vo.setHrHd(0);
					break;
				case StatisticsUtil.HR_IN_HOSPITAL:
					vo.setHrInHospital(0);
					break;
				case StatisticsUtil.HR_OUTPATIENT:
					vo.setHrOutpatient(0);
					break;
				case StatisticsUtil.HR_PE:
					vo.setHrPe(0);
					break;
				case StatisticsUtil.HR_SIX_CHILD:
					vo.setHrSixChild(0);
					break;
				case StatisticsUtil.HR_SIXO_TO_SIXF:
					vo.setHrSixoToSixf(0);
					break;
				case StatisticsUtil.HR_STROKE:
					vo.setHrStroke(0);
					break;
				case StatisticsUtil.HR_ONE_STAR:
					vo.setHrOneStar(0);
					break;
				case StatisticsUtil.HR_TWO_STAR:
					vo.setHrTwoStar(0);
					break;
				case StatisticsUtil.HR_THREE_STAR:
					vo.setHrThreeStar(0);
					break;
				case StatisticsUtil.UNHR_ONE_STAR:
					vo.setUnhrOneStar(0);
					break;
				case StatisticsUtil.UNHR_TWO_STAR:
					vo.setUnhrTwoStar(0);
					break;
				case StatisticsUtil.UNHR_THREE_STAR:
					vo.setUnhrThreeStar(0);
					break;
				default:
					break;
				}
				break;
			default:
				break;
			}
		}
	}

	@Override
	public HaStatistics getQuickJob(Criteria criteria) {

		return haStatisticsDao.getQuickJob(criteria);
	}

	@Override
	public List<HaStatistics> getTownDistributionList(Map<String, Object> paramMap) {
		return haStatisticsDao.getTownDistribution(paramMap);
	}

	@Override
	public List<HaStatistics> getCommunityDistributionList(Criteria cr) {
		return haStatisticsDao.getCommunityDistribution(cr);
	}

	/**
	 * 按镇统计建档数
	 * 
	 * @return
	 */
	@Override
	public List<HaStatistics> getHaStatisticsByTown() {
		List<Map<String, Object>> maps = personInfoDao.getStatisticsListByTown();

		List<HaStatistics> has = new ArrayList<>();

		for (Map<String, Object> map : maps) {
            String inputOrganCode = getStringFromMap(map, "input_gbcode");
			if (ObjectUtil.isNotEmpty(inputOrganCode)) {
                HaStatistics ha = new HaStatistics();
				ha.setGbcode(inputOrganCode);
				int sum = getIntFromMap(map,"coutNum");
				ha.setHrArchiveNew(sum);
				has.add(ha);
			}
		}

		Criteria criteriaZhen = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
		List<DicItem> dicItems = dictionaryApp.queryDicItem(criteriaZhen);

		for (HaStatistics ha : has) {
			String gbName = getTownName(dicItems, ha.getGbcode());
			ha.setTownName(gbName);
		}
		return has;
	}

	/**
	 * 按中心统计建档数
	 * 
	 * @return
	 */
	@Override
	public List<HaStatistics> getHaStatisticsByCenter(String centerCode) {
		List<Map<String, Object>> maps = personInfoDao.getStatisticsListByCenter(centerCode);

		List<HaStatistics> has = new ArrayList<>();

		for (Map<String, Object> map : maps) {
			String inputOrganCode = getStringFromMap(map, "input_organ_code");
			if (inputOrganCode.length() > 0) {
                HaStatistics ha = new HaStatistics();
				ha.setOrgCode(inputOrganCode);
				ha.setHrArchiveNew(getIntFromMap(map, "coutNum"));
				String orgName = organizationApp.queryOrganName(inputOrganCode);
				ha.setTownName(orgName);
				has.add(ha);
			}
		}
		return has;
	}

	private int getIntFromMap(Map<String, Object> map, String key) {
		String value = getStringFromMap(map, key);
		int result = 0;
		try {
			result = Integer.valueOf(value);
		} catch (NumberFormatException e) {
			log.error(e);
		}
		return result;
	}

	private String getStringFromMap(Map<String, Object> map, String key) {
		Object inputOrganCodeOb = map.get(key);
		if (null == inputOrganCodeOb) {
			return "";
		}
		String inputOrganCodeString = inputOrganCodeOb.toString().trim();

		if (ObjectUtil.isNotEmpty(inputOrganCodeString)) {
			return inputOrganCodeString;
		}

		return "";
	}

	private String getTownName(List<DicItem> dicItems, String gbCode) {
		for (DicItem d : dicItems) {
			if (d.getItemCode().equals(gbCode)) {
				return d.getItemName();
			}
		}
		return "";
	}

	@Override
	public Long getAllCreatePerson(Criteria criteria) {
		Long all = personInfoDao.getCount(criteria, "id", Long.class);
		return all;
	}

	public List<HaStatistics> getHaStatisticsEveryTown(List<Organization> organizations) {
		List<HaStatistics> has = new ArrayList<>();
		for(Organization organization: organizations){
			Map<String, Object> map = personInfoDao.getStatisticsListEveryCenter(organization.getOrganCode());
				HaStatistics ha = new HaStatistics();
				ha.setGbcode(organization.getOrganCode());
			    ha.setTownName(organization.getOrganName());
				int sum = getIntFromMap(map,"coutNum");
				ha.setHrArchiveNew(sum);
				has.add(ha);
		}
		return has;
	}

	@Override
	public boolean syncWorkStatisticsData(EhrDocLevel entity){
		int r=0;
		r = ehrDocLevelDao.insert(entity);
		return r>0?true:false;
	}
}
