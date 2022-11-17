package com.founder.rhip.ehr.service.basic;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.integration.*;
import com.founder.rhip.ehr.entity.basic.IntegrationLog;
import com.founder.rhip.ehr.entity.basic.IntegrationMonitor;
import com.founder.rhip.mdm.entity.Organization;


public interface IIntegrationMonitorService {
	/**
	 * 查询监控记录
	 * @param criteria
	 * @return
	 */
	List<IntegrationMonitor> queryIntegrationMonitors(Criteria criteria);
	
	/**
	 * 记录医疗数据集成记录
	 * @param map 数据量记录
	 * @param numberCode 编号代码(h01:门诊,h02:门诊诊断等等)
	 * @param numberName 编号名称
	 */
	void recordMedicalIntegrationMonitor(Map<String, Long[]> map, String numberCode, String numberName);
	
	/**
	 * 记录公卫数据集成记录
	 * @param map 数据量记录
	 * @param date 记录日期
	 * @param category 编号代码(C01:出生证明,C02:新生儿疾病筛查等等)
	 */
	void recordHealthCareIntegrationMonitor(Map<String, Long[]> map, Date date, String category);
	
	/**
	 * 按特定时间段组织院内数据监控记录
	 * 
	 * @param organizations 机构对象集合
	 * @param dateList 日期对象集合，选定的日期时间段
	 * @param beginDate 开始日期
	 * @return
	 */
	List<HospitalMedicalMonitorRecord> organizeHospitalMedicalMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate, List<String> projectNameList);
	
	/**
	 * 按特定时间段组织药品目录数据监控记录
	 * 
	 * @param organizations 机构对象集合
	 * @param dateList 日期对象集合，选定的日期时间段
	 * @param beginDate 开始日期
	 * @return
	 */
	List<DrugMonitorRecord> organizeDrugMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate);
	
	/**
	 * 按特定时间段组织妇幼保健数据监控记录
	 * @param dateList 日期对象集合，选定的日期时间段
	 * @param beginDate 开始日期
	 * 
	 * @return
	 */
	List<WomenChildrenMonitorRecord> organizeWomenChildrenMoitorRecord(List<Date> dateList, Date beginDate);
	
	/**
	 * 按特定时间段计免数据监控记录
	 * @param dateList
	 * @param beginDate
	 * 
	 * @return
	 */
	List<GenericMonitor> organizePlanImmunizationMonitorRecord(List<Date> dateList, Date beginDate);
	
	/**
	 * 按特定时间段组织体检数据监控记录
	 * 
	 * @param organizations 机构对象集合
	 * @param dateList 日期对象集合，选定的日期时间段
	 * @param beginDate 开始日期
	 * @return
	 */
	List<PhysicalExaminationMonitorRecord> organizePhysicalExaminationMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate);
	
	/**
	 * 查看集成日志
	 * @param criteria
	 * @param page
	 * @return
	 */
	PageList<IntegrationLog> searchIntegrationLogs(Criteria criteria, Page page);
	
	/**
	 * 获取医疗大数据
	 * @param organizations
	 * @param medicalDataDate
	 * @param projectNameList
	 * @return
	 */
	List<MedicalDataRecord> searchMedicalDataRecord(List<Organization> organizations, Date medicalDataDate, List<String> projectNameList);
	
	/**
	 * 清理集成日志
	 * @param date 指定时间
	 */
	void removeIntegrationLog(Date date);

    /**
     * 按特定时间段 医药卫生用品 监控记录
     *
     * @param organizations 机构对象集合
     * @param dateList 日期对象集合，选定的日期时间段
     * @param beginDate 开始日期
     * @return
     */
    List<HospitalMedicalMonitorRecord> medicalGoodsMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate, List<String> projectNameList);


    /**
     * 按特定时间段 血站 监控记录
     *
     * @param organizations 机构对象集合
     * @param dateList 日期对象集合，选定的日期时间段
     * @param beginDate 开始日期
     * @return
     */
    List<HospitalMedicalMonitorRecord> bloodStationMonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate, List<String> projectNameList);


    /**
     * 按特定时间段 120数据 监控记录
     *
     * @param organizations 机构对象集合
     * @param dateList 日期对象集合，选定的日期时间段
     * @param beginDate 开始日期
     * @return
     */
    List<HospitalMedicalMonitorRecord> data120MonitorRecord(List<Organization> organizations, List<Date> dateList, Date beginDate, List<String> projectNameList);

	Map<String, Object> getMonitorRecordNumMap(Criteria criteria);

	/**按特定时间段组织院内数据监控记录用于图表
	 *
	 * @param criteria
	 * @return
	 */
	MedicalMonitor getHospitalMedicalMonitorRecord(Criteria criteria);
}
