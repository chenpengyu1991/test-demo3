package com.founder.rhip.cdm.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 慢病体检
 * 
 * @author liuk
 * 
 */
public interface IPhyExaminationService {

	/**
	 * 获取体检列表
	 * 
	 * @param criteria
	 * @param page
	 * @return
	 */
	List<ElderlyPhyExamination> getPhyExaminations(Criteria criteria, Page page);

	/**
	 * 更新体检
	 * 
	 * @param personInfo
	 * @param elderlyPhyExamination
	 */
	void updatePhyExamination(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination, Organization organization, User user);

	/**
	 * 新增保存体检
	 *返回体检编号
	 * @param personInfo
	 * @param elderlyPhyExamination
	 */
	String savePhyExamination(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination, Organization organization, User user);

	/**
	 * 获取体检信息列表
	 * 
	 * @param criteria
	 * @param page
	 * @return
	 */
	List<HealthExamination> getHealthExaminations(Criteria criteria, Page page);

	/**
	 * 获取体检
	 * 
	 * @param criteria
	 * @return
	 */
	ElderlyPhyExamination getPhyExamination(Criteria criteria);

	/**
	 * 新增体检,获取默认数据
	 * 
	 * @param personInfo
	 * @param organization
	 * @return
	 */
	ElderlyPhyExamination add(PersonInfo personInfo, Organization organization);

	/**
	 * 删除体检
	 * @param personId
	 * @param ehrId
	 * @param examCode 
	 * @return 
	 */
	HealthExamination deleteElderlyPhyExamination(Long personId, String ehrId, String examCode);

	/**
	 * 新增修改从健康体检和老年人体检过来的体检数据到慢病体检表中
	 * @param personInfo
	 * @param elderlyPhyExamination
	 * @param organization
	 * @param user
	 * @param healthEvaluateAnomalies
	 * @param hospitalizedHistoryList
	 * @param familyBedHistoryList
	 * @param drugHistoryList
	 * @param vaccinationInfoList
	 * @param properties
	 */
	void savePhyExaminationFromEhrMeso(PersonalPhyExamDTO dto, ElderlyPhyExamination elderlyPhyExamination,
									   Organization organization, User user,  String ...properties);

	/**
	 * 慢病体检统计
	 * @param page
	 * @param form
	 * @return
	 */
	public PageList<Map<String, Object>> getPhyExaminationStatistics(Page page, ReportQueryForm form, Organization currentOrg);

	/**
	 * 导出慢病体检统计
	 * @param page
	 * @param form
	 * @return
	 */
	public List<Map<String, Object>> exportPhyExaminationStatistics(Page page, ReportQueryForm form, Organization currentOrg);

	List<Map<String, Object>> getPhyCensusList(Criteria criteria);
	
	List<ElderlyPhyExamination> getElderlyPhyExaminations(Criteria cri, Order order, String... properties);
	
	List<HealthExamination> getHealthExaminations(Criteria cri, Order order, String... properties);

}
