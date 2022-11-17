/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.ElderlyHealthStatistics;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.summary.DrugHistory;
import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.mdm.entity.Organization;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IPhysicalExamRecordService {

	/**
	 * 数据获取
	 * @param       criteria
	 * @return      PhysicalExamRecord
	 */
	public PhysicalExamRecord getPhysicalExamRecord(Criteria criteria);

	/**
	 * 数据获取
	 * @param       criteria
	 * @return      List<PhysicalExamRecord>
	 */
	public List<PhysicalExamRecord> getPhysicalExamRecords(Criteria criteria);

	/**
	 * 数据获取
	 * @param       page
	 * @param       criteria
	 * @return      List<PhysicalExamRecord>
	 */
	public PageList<PhysicalExamRecord> getPhysicalExamRecords(Page page, Criteria criteria);

	/**
	 * 更新体检记录
	 * @param       physicalExamRecord
	 * @param       properties
	 * @return      boolean
	 */
	public boolean updatePhysicalExamRecord(PhysicalExamRecord physicalExamRecord,String... properties);

	/**
	 * 创建体检记录
	 * @param       physicalExamRecord
	 * @return      boolean
	 */
	public boolean createPhysicalExamRecord(PhysicalExamRecord physicalExamRecord);
	


	/**
	 * 核实确认体检人员
	 * @param ids
	 */
	public void confirmExamRecord(String organCode, String[] ids);

	/**
	 * 更新本年度待体检人员名单
	 *
	 * @param criteria 机构条件集合
	 * @throws Exception
	 * @author Ye jianfei
	 */
	public void reflashVerify(Criteria criteria) throws Exception;

	/**
	 * 取消核实确认人员
	 * @param ids
	 */
	public void cancelConfirmExamRecord(String organCode, String[] ids);
	
	
	
	public List<ElderlyHealthStatistics> getElderlyHealthStatisticsList(Criteria criteria);
	
	/**
	 * 体质辨识列表数据获取
	 * @param       page
	 * @param       criteria
	 * @return      List<PhysicalExamRecord>
	 */
	public PageList<PhysicalExamRecord> getEchExamRecords(Page page, Criteria criteria);

	/**
	 * 导出体质辨识列表数据获取
	 * @param       page
	 * @param       criteria
	 * @return      List<PhysicalExamRecord>
	 */
	public List<Map<String, Object>> exportEchExamRecords(Page page, Criteria criteria);

	/**
	 * 获取老年人体检进度
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getPhysicalExamProgressMapList(Map<String, String> paramMap);
	
	/**
	 * 获取老年人健康指标统计
	 * @param paramMap
	 * @param organList 
	 * @return
	 */
	public List<Map<String, Object>> getElderlyPhysicalExamStatisticsMapList(Map<String, String> paramMap, List<String> organList);
	public List<Map<String, Object>> getElderlyPhysicalExamStatisticsMapList(Criteria criteria, Integer type);

	/**
	 * 保存老年人健康体检信息
	 * @param personalPhyExamDTO
	 * @param elderlyPhyExamination
	 * @param organization
	 * @param string
	 */
	public void savePhyExamination(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination, Organization organization, String anomalyDesc);

	/**
	 * 更新老年人健康体检信息
	 * @param personInfo
	 * @param elderlyPhyExamination
	 * @param physicalExamRecordId
	 */
	public void updatePhyExamination(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination);

//	/**
//	 * 删除健康体检数据
//	 * @param physicalExamRecordId
//	 */
//	public PhysicalExamRecord deleteElderlyPhyExamination( Long physicalExamRecordId);

	/**
	 * 慢病系统、健康档案更新老年人体检信息（新增或更新）
	 * @param personId
	 * @param elderlyPhyExamination
	 * @param healthEvaluateAnomalies 健康评价异常
	 * @param familyBedHistorylist 
	 * @param drugHistorylist 
	 * @param vaccinationInfoList 
	 * @param HospitalizedHistoryList 
	 * @param organization
	 * @param currentUser 
     */
	public void savePhyExamination(Long personId, ElderlyPhyExamination elderlyPhyExamination, PersonalPhyExamDTO personalPhyExamDTO,Organization organization, User currentUser, String ehrType, String... properties);

	public List<Map<String, Object>> exportPersonRecordList(List<String> orgCodes, Page page, Criteria criteria,String examinationDateStart, String examinationDateEnd);

	public PageList<PhysicalExamRecord> getPhysicalExamRecordList(Page page, List<String> orgCodes, Criteria criteria, String examinationDateStart, String examinationDateEnd);

	public List<PhysicalExamRecord> getPhysicalExamRecordList(Criteria criteria, String examinationDateStart, String examinationDateEnd);

	public Long getCount(Criteria caexam);

	public List<Map<String, Object>> exportPhysiqueExaminationList(Page page, List<Long> idList, String examYear);

    /**
     * 增加老年人体检名单
     * @param personId 个人信息id
     * @param examYear 体检年份
     * @return 返回体检ID
     */
    public Long addOlderExamination(Long personId,Date examYear);

    public List<Map<String, Object>> exportPhysiqueExaminationList(Page page, Criteria criteria,
                                                                   String examinationDateStart, String examinationDateEnd, String year);

    /**
     * 获取老年人体检进度
     * @param criteria
     * @return
     */
    public List<Map<String, Object>> getPhysicalExamProgressMapList(Criteria criteria);

    /**
     * 判断是做过老年人指导或者评估
     * @param criteria
     * @param examYear
     * @return 0 未体检  1 有体检未做指导或评估  2 做过指导或评估
     */
    public int hasPhysicalExam(Criteria criteria,String examYear);

    public int saveEvaluation(ElderlyPhyExamination elderlyPhyExamination);

	public List<Map<String, Object>> getElderlyPhysicalExamStatisticsByPaAddress(Criteria criteria, Integer type);

//	public boolean deleteExaminationByExamCode(Long personId, String examCode);
	/**
	 * 删除老年人体检
	 * @param personId
	 * @param ehrId
	 * @param physicalExamCode 
	 * @return
	 */
	public void deleteByEhrId(Long personId, String ehrId, String physicalExamCode);


}