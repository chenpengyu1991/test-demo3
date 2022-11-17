package com.founder.rhip.ph.service.vaccine;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ehr.entity.management.InoculationAppointment;
import com.founder.rhip.ehr.entity.summary.TraumaHistory;

/**
 * 
 * @author xu_bin
 *	服务于接种记录
 *	提供接种记录集 / 单个接种记录详细信息
 */
public interface IVaccinationReadService {
	PageList<VaccinationEvent> getList(Page page, Criteria criteria);
	
	/**
	 * 获取文档中的预防接种
	 * @param xdsDocQueryLog
	 * @param page
	 * @return
	 */
	PageList<VaccinationInfo> getVaccInDocList(Criteria criteria,Page page);
	
	VaccinationMgmt getVaccinationMgmt(Criteria criteria);
	
	TraumaHistory getTraumaHistory(Criteria criteria);
	
	VaccinationInfo getVaccinationInfo(Criteria criteria);
	
	public List<ExamineDetail> getExamineDetail(Criteria criteria);
	
	List<VaccinationInfo> getVaccinationList(Criteria criteria,String... properties);

	/** 
	* @Title: getVaccinationEvent 
	* @Description: 查询
	* @param @param criteria
	* @param @return
	* @return VaccinationEvent
	* @throws 
	*/
	VaccinationEvent getVaccinationEvent(Criteria criteria);	
	
	/**
	 * 按最后注射日期分析加强针的打法
	 * @param date
	 * @return 2:距离最后一次接种日期大于184天且小于等于365天打两针，分别在0、3天注射；
	 * 3:大于365天且小于等于3年的大三针，分别在0、3、7天注射;4:大于三年打四针，第一次打两针分别在0、3、7天注射;
	 * 0:小于等于184天不用重新打
	 */
	int analyseLastVaccineDate(Date date, Long personId);
	
	/**
	 * 导出体检数据
	 * @param page
	 * @param criteria
	 * @return
	 */
	public List<Map<String, Object>> exportVaccineList(Page page,Criteria criteria);
	
	PageList<InoculationAppointment> getInoculationList(Criteria criteria,Page page,String sql);
	
	/**
	 * 23价疫苗报表
	 * @param criteria
	 * @return
	 */
	List<Map<String, Object>> statisticsVaccinationReport(Criteria criteria);
}
