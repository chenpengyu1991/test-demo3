package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.management.DmPopulaceInfo;
import com.founder.rhip.ehr.repository.statistics.IDmYearReportStatisticsDao;
import com.founder.rhip.ehr.statisticsdto.DmYearReport;
import com.founder.rhip.mdm.app.IDiseaseApp;
import com.founder.rhip.mdm.entity.Disease;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 慢病年报和肿瘤年报
 * 
 * @author liuk
 * 
 */
@Service("yearReportService")
public class YearReportServiceImpl implements IYearReportServie {

	private Map<String, DmYearReport> diMap = null;
	private Map<String, DmYearReport> strokeMap = null;
	private Map<String, DmYearReport> coronaryMap = null;
	private Map<String, DmYearReport> malignantTumorMap = null;
	private List<DmYearReport> malignantTumorList = null;
	private List<DmYearReport> nonMalignantTumorList = null;

	@Resource(name = "dmYearReportStatisticsDao")
	private IDmYearReportStatisticsDao dmYearReportStatisticsDao;

	@Resource(name = "diseaseApp")
	private IDiseaseApp diseaseApp;

	@Override
	public Map<String, List<DmYearReport>> getCdYearReportsByGenger(Map<String, Object> populaceMap, Criteria criteria) {
		List<DmYearReport> reports = dmYearReportStatisticsDao.getCdYearReportByGenger(criteria);
		Map<String, List<DmYearReport>> resultMap = new LinkedHashMap<String, List<DmYearReport>>(5);
		getGengerResultMap(populaceMap, reports, resultMap, false);
		addCdDefaultResult(resultMap);// 补充数据
		return resultMap;
	}

	@Override
	public Map<String, List<DmYearReport>> getCdYearReportByAge(DmPopulaceInfo populaceInfo, Criteria criteria) {
		List<DmYearReport> reports = dmYearReportStatisticsDao.getCdYearReportByAge(criteria);
		Map<String, List<DmYearReport>> resultMap = new LinkedHashMap<String, List<DmYearReport>>(5);
		getAgeResultMap(reports, resultMap, false);
		addCdDefaultResult(resultMap);// 补充数据
		return resultMap;
	}

	@Override
	public Map<String, List<DmYearReport>> getTumorYearReportsByGenger(Map<String, Object> populaceMap, Criteria criteria) {
		List<DmYearReport> reports = dmYearReportStatisticsDao.getTumorYearReportByGenger(criteria);
		reports = addTumor(true, reports);// 补充数据
		Map<String, List<DmYearReport>> resultMap = new LinkedHashMap<String, List<DmYearReport>>();
		getGengerResultMap(populaceMap, reports, resultMap, true);
		return resultMap;
	}

	@Override
	public Map<String, List<DmYearReport>> getTumorYearReportByAge(DmPopulaceInfo populaceInfo, Criteria criteria) {
		List<DmYearReport> reports = dmYearReportStatisticsDao.getTumorYearReportByAge(criteria);
		reports = addTumor(true, reports);// 补充数据
		Map<String, List<DmYearReport>> resultMap = new LinkedHashMap<String, List<DmYearReport>>();
		getAgeResultMap(reports, resultMap, true);
		return resultMap;
	}

	@Override
	public List<DmYearReport> getTumorDeathYearReportsByAge(Map<String, Object> populaceMap, Criteria criteria) {
		List<DmYearReport> reports = dmYearReportStatisticsDao.getTumorDeathYearReportByAge(criteria);
		reports = addTumor(false, reports);// 补充数据
		if (ObjectUtil.isNotEmpty(reports)) {
			DmYearReport total = null;
			int totalCount = 0;
			for (int i = reports.size() - 1; i >= 0; i--) {
				DmYearReport dmYearReport = reports.get(i);
				String sub = dmYearReport.getSubDisType();
				if (EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE.equals(sub)) {
					dmYearReport.setSubIncidence(1.0D);
					total = dmYearReport;
					totalCount = dmYearReport.getTotal();
					break;
				}
			}

			for (DmYearReport dmYearReport : reports) {
				String sub = dmYearReport.getSubDisType();
				if (!EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE.equals(sub)) {
					dmYearReport.calSubIncidence(totalCount);
				}
			}
			if (null == total) {
				total = new DmYearReport();
				total.setSubDisType(EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE);
				total.setTotal(0);
				reports.add(total);
			}
		}
		return reports;
	}

	@Override
	public List<DmYearReport> getTumorDeathYearReportByGenger(Map<String, Object> populaceMap, Criteria criteria) {
		List<DmYearReport> reports = dmYearReportStatisticsDao.getTumorDeathYearReportByGenger(criteria);
		reports = addTumor(false, reports);// 补充数据
		if (ObjectUtil.isNotEmpty(reports)) {
			DmYearReport total = null;
			for (DmYearReport dmYearReport : reports) {
				if(ObjectUtil.isNotEmpty(populaceMap)) {
					int manNum = ObjectUtil.isNullOrEmpty(populaceMap.get("MAN_NUM")) ? 0 : Integer.valueOf(populaceMap.get("MAN_NUM").toString());
					int womanNum = ObjectUtil.isNullOrEmpty(populaceMap.get("WOMAN_NUM")) ? 0 : Integer.valueOf(populaceMap.get("WOMAN_NUM").toString());
					int totalNum = ObjectUtil.isNullOrEmpty(populaceMap.get("TOTAL_NUM")) ? 0 : Integer.valueOf(populaceMap.get("TOTAL_NUM").toString());
					dmYearReport.calIncidence(manNum, womanNum, totalNum);
				}
				String sub = dmYearReport.getSubDisType();
				if (EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE.equals(sub)) {
					dmYearReport.setSubIncidence(1.0D);
					total = dmYearReport;
				}
			}
			if (null == total) {
				total = new DmYearReport();
				total.setSubDisType(EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE);
				total.setTotal(0);
				reports.add(total);
			}
		}
		return reports;
	}

	/**
	 * 分类和计算
	 * 
	 * @param reports
	 * @param resultMap
	 * @param haveAllTotal
	 */
	private void getGengerResultMap(Map<String, Object> populaceMap, List<DmYearReport> reports, Map<String, List<DmYearReport>> resultMap, boolean haveAllTotal) {
		if (ObjectUtil.isNotEmpty(reports)) {
			DmYearReport allTotal = null;// 保存最后一个总合计数据
			for (DmYearReport dmYearReport : reports) {
				if(ObjectUtil.isNotEmpty(populaceMap)) {
					int manNum = ObjectUtil.isNullOrEmpty(populaceMap.get("MAN_NUM")) ? 0 : Integer.valueOf(populaceMap.get("MAN_NUM").toString());
					int womanNum = ObjectUtil.isNullOrEmpty(populaceMap.get("WOMAN_NUM")) ? 0 : Integer.valueOf(populaceMap.get("WOMAN_NUM").toString());
					int totalNum = ObjectUtil.isNullOrEmpty(populaceMap.get("TOTAL_NUM")) ? 0 : Integer.valueOf(populaceMap.get("TOTAL_NUM").toString());
					dmYearReport.calIncidence(manNum, womanNum, totalNum);
				}
				String keyString = dmYearReport.getDisType();
				if (ObjectUtil.isNullOrEmpty(keyString)) {
					allTotal = dmYearReport;
					continue;
				}
				if (null != resultMap) {
					addIntoMapList(dmYearReport, keyString, resultMap);
				}
			}
			// 如果需要全部合计列
			if (haveAllTotal) {
				if (null == allTotal) {
					allTotal = new DmYearReport();
					allTotal.setSubDisType("-1");
				}
				addIntoMapList(allTotal, EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE, resultMap);
			}
		}
	}

	/**
	 * 分类和计算
	 * 
	 * @param reports
	 * @param resultMap
	 * @param haveAllTotal
	 */
	private void getAgeResultMap(List<DmYearReport> reports, Map<String, List<DmYearReport>> resultMap, boolean haveAllTotal) {
		if (ObjectUtil.isNotEmpty(reports)) {
			Map<String, Integer> totalMap = new HashMap<String, Integer>(5);
			List<DmYearReport> subDmYearReports = new ArrayList<>(reports.size());
			DmYearReport allTotal = null;// 保存最后一个总合计数据
			for (DmYearReport dmYearReport : reports) {
				String keyString = dmYearReport.getDisType();
				if (ObjectUtil.isNullOrEmpty(keyString)) {
					// 此处为空说明为合计列
					// 需要根据dao的sql来标志
					allTotal = dmYearReport;
					continue;
				}
				String sub = dmYearReport.getSubDisType();
				if (EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE.equals(sub)) {
					totalMap.put(keyString, dmYearReport.getTotal());
					dmYearReport.setSubIncidence(1.0D);
				} else {
					subDmYearReports.add(dmYearReport);
				}
				if (null != resultMap) {
					addIntoMapList(dmYearReport, keyString, resultMap);
				}
			}
			// 计算占比
			for (DmYearReport dmYearReport : subDmYearReports) {
				String key = dmYearReport.getDisType();
				Integer total = totalMap.get(key);
				dmYearReport.calSubIncidence(total);
			}

			if (haveAllTotal) {
				if (null == allTotal) {
					allTotal = new DmYearReport();
					allTotal.setSubDisType(EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE);
				}
				allTotal.setSubIncidence(1.0D);
				addIntoMapList(allTotal, EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE, resultMap);
			}
		}

	}

	/**
	 * 将key对应值加入到list中
	 * 
	 * @param value
	 * @param key
	 * @param map
	 */
	private void addIntoMapList(DmYearReport value, String key, Map<String, List<DmYearReport>> map) {
		List<DmYearReport> collection = map.get(key);
		if (null == collection) {
			collection = new ArrayList<>();
			map.put(key, collection);
		}
		collection.add(value);
	}

	/**
	 * 补充肿瘤必须项数据
	 */
	private void initTumor() {

		// 鼻咽 C11
		// 食管 C15
		// 胃 C16
		// 结肠 C18
		// 直肠 C19,C20
		// 肝和肝内胆管 C22
		// 胆囊和肝外胆管 C23,C24
		// 胰腺 C25
		// 气管、支气管和肺 C33,C34
		// 乳房 C50
		// 宫颈 C53
		// 前列腺 C61
		// 膀胱 C67
		// 脑、神经系统 C70-C72
		// 恶性淋巴瘤 C81-C85；C88；C90；C96
		// 白血病 C91-C95

		malignantTumorList = new ArrayList<>();
		malignantTumorMap = new LinkedHashMap<>();
		nonMalignantTumorList = new ArrayList<>();

		// 恶性肿瘤

		// 鼻咽 C11
		DmYearReport C11 = new DmYearReport("1", "C11", "鼻咽癌");
		malignantTumorMap.put("C11", C11);
		malignantTumorList.add(C11);

		// 食管 C15
		DmYearReport C15 = new DmYearReport("1", "C15", "食管癌");
		malignantTumorMap.put("C15", C15);
		malignantTumorList.add(C15);

		// 胃 C16
		DmYearReport C16 = new DmYearReport("1", "C16", "胃癌");
		malignantTumorMap.put("C16", C16);
		malignantTumorList.add(C16);

		// 结肠 C18
		DmYearReport C18 = new DmYearReport("1", "C18", "结肠癌");
		malignantTumorMap.put("C18", C18);
		malignantTumorList.add(C18);

		// 直肠 C19,C20
		DmYearReport C19 = new DmYearReport("1", "C19,C20", "直肠癌");
		malignantTumorMap.put("C19", C19);
		malignantTumorMap.put("C20", C19);
		malignantTumorList.add(C19);
		// 肝和肝内胆管 C22
		DmYearReport C22 = new DmYearReport("1", "C22", "肝和肝内胆管癌");
		malignantTumorMap.put("C22", C22);
		malignantTumorList.add(C22);

		// 胆囊和肝外胆管 C23,C24
		DmYearReport C23 = new DmYearReport("1", "C23,C24", "胆囊和肝外胆管癌");
		malignantTumorMap.put("C23", C23);
		malignantTumorMap.put("C24", C23);
		malignantTumorList.add(C23);
		// 胰腺 C25
		DmYearReport C25 = new DmYearReport("1", "C25", "胰腺癌");
		malignantTumorMap.put("C25", C25);
		malignantTumorList.add(C25);

		// 气管、支气管和肺 C33,C34
		DmYearReport C33 = new DmYearReport("1", "C33,C34", "气管,支气管和肺癌");
		malignantTumorMap.put("C33", C33);
		malignantTumorMap.put("C34", C33);
		malignantTumorList.add(C33);
		// 乳腺癌C50
		DmYearReport C50 = new DmYearReport("1", "C50", "乳腺癌");
		malignantTumorMap.put("C50", C50);
		malignantTumorList.add(C50);
		// 宫颈 C53
		DmYearReport C53 = new DmYearReport("1", "C53", "宫颈癌");
		malignantTumorMap.put("C53", C53);
		malignantTumorList.add(C53);
		// 前列腺 C61
		DmYearReport C61 = new DmYearReport("1", "C61", "前列腺癌");
		malignantTumorMap.put("C61", C61);
		malignantTumorList.add(C61);
		// 膀胱 C67
		DmYearReport C67 = new DmYearReport("1", "C67", "膀胱癌");
		malignantTumorMap.put("C67", C67);
		malignantTumorList.add(C67);
		// 脑、神经系统 C70-C72
		DmYearReport C70 = new DmYearReport("1", "C70-C72", "脑/神经系统恶性肿瘤");
		malignantTumorMap.put("C70", C70);
		malignantTumorMap.put("C71", C70);
		malignantTumorMap.put("C72", C70);
		malignantTumorList.add(C70);
		// 恶性淋巴瘤 C81-C85；C88；C90；C96
		DmYearReport C81 = new DmYearReport("1", "C81-C85,C88,C90,C96", "恶性淋巴瘤");
		malignantTumorMap.put("C81", C81);
		malignantTumorMap.put("C82", C81);
		malignantTumorMap.put("C83", C81);
		malignantTumorMap.put("C84", C81);
		malignantTumorMap.put("C85", C81);
		malignantTumorMap.put("C88", C81);
		malignantTumorMap.put("C90", C81);
		malignantTumorMap.put("C96", C81);
		malignantTumorList.add(C81);
		// 白血病 C91-C95
		DmYearReport C91 = new DmYearReport("1", "C91", " 白血病");
		malignantTumorMap.put("C91", C91);
		malignantTumorMap.put("C92", C91);
		malignantTumorMap.put("C93", C91);
		malignantTumorMap.put("C94", C91);
		malignantTumorMap.put("C95", C91);
		malignantTumorList.add(C91);

		// 非恶性肿瘤

		DmYearReport D33 = new DmYearReport("2", "D33", "脑/神经系统良性肿瘤");
		nonMalignantTumorList.add(D33);
		malignantTumorMap.put("D33", D33);

	}

	/**
	 * 获取肿瘤名字
	 * 
	 * @param icd
	 * @return
	 */
	private String getTumorName(String icd) {
		Disease disease = diseaseApp.queryDisease(icd);
		if (null != disease) {
			return disease.getDiseaseName();
		}
		return "";
	}

	/**
	 * 补充肿瘤
	 * 
	 * @param haveNonMalignant
	 * @param reports
	 * @return
	 */
	private List<DmYearReport> addTumor(boolean haveNonMalignant, List<DmYearReport> reports) {
		initTumor();
		List<DmYearReport> result = new ArrayList<>();
		if (null != reports) {
			for (DmYearReport dmYearReport : reports) {
				DmYearReport target = malignantTumorMap.get(dmYearReport.getSubDisType());
				if (null != target) {
					target.add(dmYearReport);
				} else {
					dmYearReport.setSubDisTypeName(getTumorName(dmYearReport.getSubDisType()));
					result.add(dmYearReport);
				}
			}
		}
		if (haveNonMalignant) {
			result.addAll(0, nonMalignantTumorList);
		}
		result.addAll(0, malignantTumorList);
		return result;
	}

	/**
	 * 初始化慢病必须项
	 */
	private void initCd() {
		diMap = new LinkedHashMap<>(4);// 糖尿病
		strokeMap = new LinkedHashMap<>(4);// 脑卒中
		coronaryMap = new LinkedHashMap<>(4);// 肿瘤

		DmYearReport one = new DmYearReport();
		one.setSubDisType("1");
		DmYearReport two = new DmYearReport();
		two.setSubDisType("2");
		DmYearReport three = new DmYearReport();
		three.setSubDisType("3");
		DmYearReport four = new DmYearReport();
		four.setSubDisType("4");

		diMap.put("1", one);
		diMap.put("2", two);
		diMap.put("3", three);
		diMap.put("4", four);

		strokeMap.put("1", one);
		strokeMap.put("2", two);
		strokeMap.put("3", three);
		strokeMap.put("4", four);

		coronaryMap.put("1", one);
		coronaryMap.put("2", two);
		coronaryMap.put("3", three);
		coronaryMap.put("4", four);

	}

	/**
	 * 增加慢病必须项目
	 * 
	 * @param map
	 */
	private void addCdDefaultResult(Map<String, List<DmYearReport>> map) {
		initCd();
		addDefaultItems(map, EHRConstants.DM_DI_TYPE, diMap);
		addDefaultItems(map, EHRConstants.DM_STROKE_TYPE, strokeMap);
		addDefaultItems(map, EHRConstants.DM_CORONARY_TYPE, coronaryMap);
	}

	/**
	 * 增加慢病必须项目
	 * 
	 * @param map
	 * @param key
	 * @param diMap
	 */
	private void addDefaultItems(Map<String, List<DmYearReport>> map, String key, Map<String, DmYearReport> diMap) {
		if (map.containsKey(key)) {
			List<DmYearReport> reportItems = map.get(key);
			// 如果不足5行,则进行补充
			int size = reportItems.size();
			if (size < 5) {
				for (DmYearReport dmYearReport : reportItems) {
					diMap.put(dmYearReport.getSubDisType(), dmYearReport);
				}
				reportItems.clear();
				reportItems.addAll(diMap.values());
			}
		} else {
			List<DmYearReport> reportItems = new ArrayList<>(diMap.values());
			DmYearReport one = new DmYearReport();
			reportItems.add(one);
			one.setSubDisType(EHRConstants.DM_STATISTICS_TOTAL_COLUMN_VALUE);
			map.put(key, reportItems);
		}
	}
}
