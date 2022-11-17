package com.founder.rhip.ehr.service.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.IDiseaseDataSource;
import com.founder.rhip.ehr.common.PageableDiseaseDataSource;
import com.founder.rhip.ehr.common.PropertiesUtils;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.InpatientMedicalRecord;
import com.founder.rhip.ehr.entity.report.RpInhospitalTreatment;
import com.founder.rhip.ehr.repository.clinic.IDiseaseDiagnosisInfoDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientMedicalRecordDao;
import com.founder.rhip.ehr.repository.report.IRpInhospitalTreatmentDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpInhospitalTreatmentService")
@TaskBean(cron = "0 00 4 * * ?", description = "18种病住院监测治疗定时任务")
public class RpInhospitalTreatmentServiceImpl extends RpBaseService implements
		IRpInhospitalTreatmentService,Task {

	@Resource(name = "rpInhospitalTreatmentDao")
	private IRpInhospitalTreatmentDao rpInhospitalTreatmentDao;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "diseaseDiagnosisInfoDao")
	private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;
	
	@Resource(name = "inpatientMedicalRecordDao")
	private IInpatientMedicalRecordDao inpatientMedicalRecordDao;
	
	
	private static String WAVE = "~";
	
	private static String STRIP = "-";
	
	private static Properties properties = PropertiesUtils.initProperties("disease");
	private static Set<Object> set = properties.keySet();
	private static Map<String,Object> diseaseTypeMap = new HashMap<String,Object>();
	
	static {
		diseaseTypeMap.put("1", "急性心肌梗死");
		diseaseTypeMap.put("2", "充血性心力衰竭");
		diseaseTypeMap.put("3", "脑出血");
		diseaseTypeMap.put("4", "脑梗死");
		diseaseTypeMap.put("5", "创伤性颅脑损伤");
		diseaseTypeMap.put("6", "消化道出血（无并发症）");
		diseaseTypeMap.put("7", "多部位损伤");
		diseaseTypeMap.put("8", "细菌性肺炎");
		diseaseTypeMap.put("9", "慢性阻塞性肺疾病");
		diseaseTypeMap.put("10", "糖尿病伴短期并发症");
		diseaseTypeMap.put("11", "糖尿病伴长期并发症");
		diseaseTypeMap.put("12", "糖尿病伴下肢截肢");
		diseaseTypeMap.put("13", "未控制血糖的糖尿病");
		diseaseTypeMap.put("14", "结节性甲状腺肿");
		diseaseTypeMap.put("15", "急性阑尾炎伴腹膜炎及脓肿");
		diseaseTypeMap.put("16", "前列腺增生");
		diseaseTypeMap.put("17", "肾衰竭");
		diseaseTypeMap.put("18", "败血症(成人)");
		diseaseTypeMap.put("19", "高血压病(成人)");
		diseaseTypeMap.put("20", "急性胰腺炎");
		diseaseTypeMap.put("21", "恶性肿瘤术后化疗");
		diseaseTypeMap.put("22", "恶性肿瘤维持性化疗");
	}
	
	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		saveInhospitalTreatmentStatistics(dateStr);
	}

	@Override
	public void saveInhospitalTreatmentStatistics(String dateStr) {
		String[] strs = null;
		if (ObjectUtil.isNullOrEmpty(dateStr)
				|| !StringUtils.contains(dateStr, ",")
				|| ObjectUtil.isNullOrEmpty(strs = StringUtils.split(dateStr, ","))
				|| strs.length < 2 || !NumberUtil.isInteger(strs[0]) 
				|| !NumberUtil.isInteger(strs[1])
				|| StringUtils.length(strs[0]) != 4 || StringUtils.length(strs[1]) != 1) {
			throw new IllegalArgumentException("18种病住院治疗监测统计方法参数错误！格式为（yyyy,N)yyyy表示年份，N表示季度，如2014,1");
		}
	
		final String year = strs[0];
		final String season = strs[1];
		Object[] dates = DateUtil.getDateRangeByYearAndSeason(Integer.valueOf(year), Integer.valueOf(season));
		final Criteria criteria = new Criteria("outHospitalDate", OP.BETWEEN, dates);
		// 分页处理，按季度数据量大
		PageableDiseaseDataSource.exec(new IDiseaseDataSource<InpatientMedicalRecord>() {

			@Override
			public PageList<InpatientMedicalRecord> get(Page page) {
				return inpatientMedicalRecordDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<InpatientMedicalRecord> list,
					Map<String, Object[]> map) {
				if (ObjectUtil.isNullOrEmpty(list)) {
					return;
				}
				for (InpatientMedicalRecord inpatientMedicalRecord : list) {
					String hospitalCode = null;
					String ehrId = null;
					if (ObjectUtil.isNullOrEmpty(inpatientMedicalRecord) || ObjectUtil.isNullOrEmpty(hospitalCode = inpatientMedicalRecord.getHospitalCode())
							|| ObjectUtil.isNullOrEmpty(ehrId = inpatientMedicalRecord.getEhrId())) {
						continue;
					}
					List<DiseaseDiagnosisInfo> diagnosisInfos = diseaseDiagnosisInfoDao.getList(new Criteria("hospitalCode", hospitalCode).add("ehrId", ehrId).add("diagnosisTypeCode", "01")); // 出院诊断
					if (ObjectUtil.isNullOrEmpty(diagnosisInfos)) {
						continue;
					}
	
					for (Object object : set) {
						String[] diseCodes = StringUtils.split(properties.getProperty(String.valueOf(object)), ",");
						if (ObjectUtil.isNullOrEmpty(diseCodes)) {
							continue;
						}
						for (String str : diseCodes) {
							if (StringUtils.startsWithIgnoreCase(diagnosisInfos.get(0).getDiagnosisCode(), str)) {
								StringBuilder keyBuilder = new StringBuilder(hospitalCode).append(WAVE).append(String.valueOf(object)).append(STRIP).append(year).append(season);
								if (ObjectUtil.isNullOrEmpty(map.get(keyBuilder.toString()))) {
									Object[] obs = new Object[6];
									obs[0] = 1; // 病例数
									obs[1] = inpatientMedicalRecord.getInhosAutopsyFlag() != null ? 1 : null; // 死亡数
									obs[2] = inpatientMedicalRecord.getOuthos15Flag() != null ? 1 : null; // 出院15天内再住院标志
									obs[3] = inpatientMedicalRecord.getOuthosFlag() != null ? 1 : null; // 出院31天内再住院标志
									obs[4] = inpatientMedicalRecord.getInhosDays();// 住院天数
									obs[5] = inpatientMedicalRecord.getAdmissionTotalAmount(); // 住院总费用
									map.put(keyBuilder.toString(), obs);
								} else {
									Object[] obs = map.get(keyBuilder.toString());
									if (inpatientMedicalRecord.getAdmissionTotalAmount() != null 
											&& (NumberUtil.isInteger(inpatientMedicalRecord.getAdmissionTotalAmount().toString()) 
													|| NumberUtil.isDecimal(inpatientMedicalRecord.getAdmissionTotalAmount().toString()))) {
										obs[5] =obs[5] == null ? inpatientMedicalRecord.getAdmissionTotalAmount() : ((BigDecimal) obs[5]).add(inpatientMedicalRecord.getAdmissionTotalAmount()); // 住院总费用
									}
									if (inpatientMedicalRecord.getInhosDays() != null 
											&& (NumberUtil.isInteger(String.valueOf(inpatientMedicalRecord.getInhosDays()))) 
													|| NumberUtil.isDecimal(String.valueOf(inpatientMedicalRecord.getInhosDays()))) {
										obs[4] = obs[4] == null ? inpatientMedicalRecord.getInhosDays() : (inpatientMedicalRecord.getInhosDays() == null ? obs[4] : (Integer) obs[4] + inpatientMedicalRecord.getInhosDays());// 住院天数
									}
									
									if (inpatientMedicalRecord.getInhosAutopsyFlag() != null) {
										obs[1] = obs[1] == null ? 1 : (Integer) obs[1] + 1; //死亡数
									}
									obs[0] = obs[0] == null ? 1 : (Integer) obs[0] + 1; // 病例数
									if (inpatientMedicalRecord.getOuthos15Flag() != null) {
										obs[2] = obs[2] == null ? 1 : (Integer) obs[2] + 1; // 出院15天内再住院
									}
									if (inpatientMedicalRecord.getOuthosFlag() != null) {
										obs[3] = obs[3] == null ? 1 : (Integer) obs[3] + 1; // 出院31天内再住院
									}
								}
							}
						}
					}
				}
			}
			
			@Override
			public void updateStatistics(Map<String, Object[]> map) {
				if (ObjectUtil.isNullOrEmpty(map)) {
					return;
				}
				for (String key : map.keySet()) {
					String organCode = null;
					if (!StringUtils.contains(key, WAVE) || !StringUtils.contains(key, STRIP) || ObjectUtil.isNullOrEmpty(organCode = StringUtils.substringBefore(key, WAVE))) {
						continue;
					}
		
					String str = StringUtils.substringAfter(key, WAVE);
					String diseaseType = StringUtils.substringBefore(str, STRIP);
					String year = StringUtils.substring(StringUtils.substringAfter(str, STRIP), 0, 4);
					String season = StringUtils.substring(StringUtils.substringAfter(str, STRIP),  4);
					Organization org = organizationApp.queryOrgan(organCode);
					RpInhospitalTreatment rpInhospitalTreatment = new RpInhospitalTreatment();
					rpInhospitalTreatment.setOrganCode(organCode); // 机构编码
					rpInhospitalTreatment.setCenterCode((org.getParentCode() == null || org.getParentCode().equals("0")) ? org.getOrganCode() : org.getParentCode());
					rpInhospitalTreatment.setGbCode(org.getGbCode());// 镇编码
					rpInhospitalTreatment.setOrganType(org.getGenreCode());// 机构类型
					rpInhospitalTreatment.setRpYear(year);
					rpInhospitalTreatment.setDiseasesCode(diseaseType);
					Object[] obs = map.get(key);
					RpInhospitalTreatment rht = rpInhospitalTreatmentDao.get(new Criteria("organCode", organCode).add("rpYear", year).add("diseasesCode", diseaseType));
					// 第一季度
					if (StringUtils.equals(season, "1")) {
						if (ObjectUtil.isNullOrEmpty(rht)) {
							setBeanProperty(new ConvertingWrapDynaBean(rpInhospitalTreatment), 1, obs);
							rpInhospitalTreatmentDao.insert(rpInhospitalTreatment);
						} else {
							String[] properties = new String[] {"caseNum1","caseDeathNum1","fifteenAgainNum1","monthAgainNum1","inhospitalDay1","inhospitalFee1"};
							setBeanProperty(new ConvertingWrapDynaBean(rht), 1, obs);
							rpInhospitalTreatmentDao.update(rht, properties);
						}
					} else if (StringUtils.equals(season, "2")) { // 第二季度
						if (ObjectUtil.isNullOrEmpty(rht)) {
							setBeanProperty(new ConvertingWrapDynaBean(rpInhospitalTreatment), 2, obs);
							rpInhospitalTreatmentDao.insert(rpInhospitalTreatment);
						} else {
							String[] properties = new String[] {"caseNum2","caseDeathNum2","fifteenAgainNum2","monthAgainNum2","inhospitalDay2","inhospitalFee2"};
							setBeanProperty(new ConvertingWrapDynaBean(rht), 2, obs);
							rpInhospitalTreatmentDao.update(rht, properties);
						}
					} else if (StringUtils.equals(season, "3")) { // 第三季度
						if (ObjectUtil.isNullOrEmpty(rht)) {
							setBeanProperty(new ConvertingWrapDynaBean(rpInhospitalTreatment), 3, obs);
							rpInhospitalTreatmentDao.insert(rpInhospitalTreatment);
						} else {
							String[] properties = new String[] {"caseNum3","caseDeathNum3","fifteenAgainNum3","monthAgainNum3","inhospitalDay3","inhospitalFee3"};
							setBeanProperty(new ConvertingWrapDynaBean(rht), 3, obs);
							rpInhospitalTreatmentDao.update(rht, properties);
						}
					} else if (StringUtils.equals(season, "4")) { // 第四季度
						if (ObjectUtil.isNullOrEmpty(rht)) {
							setBeanProperty(new ConvertingWrapDynaBean(rpInhospitalTreatment), 4, obs);
							rpInhospitalTreatmentDao.insert(rpInhospitalTreatment);
						} else {
							String[] properties = new String[] {"caseNum4","caseDeathNum4","fifteenAgainNum4","monthAgainNum4","inhospitalDay4","inhospitalFee4"};
							setBeanProperty(new ConvertingWrapDynaBean(rht), 4, obs);
							rpInhospitalTreatmentDao.update(rht, properties);
						}
					}
				}
			}
		});
	
	}
	
	/**
	 * 设置对象属性值
	 * @param dynaBean
	 * @param label
	 * @param obs
	 */
	private void setBeanProperty(ConvertingWrapDynaBean dynaBean, Integer label, Object[] obs) {
		if (ObjectUtil.isNullOrEmpty(dynaBean) || ObjectUtil.isNullOrEmpty(obs) || obs.length < 6) {
			return;
		}
		String[] properties = new String[] {"caseNum","caseDeathNum","fifteenAgainNum","monthAgainNum","inhospitalDay","inhospitalFee"};
		for (int i = 0; i < properties.length; i++) {
			String property = properties[i];
			StringBuilder propertyBuilder = new StringBuilder(property).append(label);
			dynaBean.set(propertyBuilder.toString(), obs[i]);
		}
		
	}

	@Override
	public List<Map<String, Object>> getHospitalTreatmentMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = rpInhospitalTreatmentDao.getHospitalTreatmentMapList(paramMap);
		List<Map<String, Object>> destMapList = fillDiseaseData(mapList);
		return destMapList;
	}
	
	private List<Map<String, Object>> fillDiseaseData(
			List<Map<String, Object>> reports) {
		List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
		String filedDiseaseType = "diseases_code";// 疾病编码字段名称
		String filedDiseaseName = "diseases_name";// 疾病名称字段名称

		Map<String, Object> diseaseData;
		for (int i = 1; i < 23; i++) {
			diseaseData = new HashMap<String, Object>();
			diseaseData.put(filedDiseaseType, String.valueOf(i));
			diseaseData.put(filedDiseaseName, diseaseTypeMap.get(String.valueOf(i)));
			for (Map<String, Object> map : reports) {
				Object diseaseType = map.get(filedDiseaseType);
				if (diseaseType.equals(String.valueOf(i))) {// 如果找到疾病数据
					map.put(filedDiseaseName,diseaseTypeMap.get(String.valueOf(i)));
					diseaseData.putAll(map);
					break;
				}
			}
			results.add(diseaseData);
		}
		return results;
	}

}
