package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.common.ElderlyHealthStatisticsType;
import com.founder.rhip.ehr.dto.ReportQueryForm;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 老年人和慢病体检
 * 
 * @author liuk
 * 
 */
public interface IElderlyPhyExaminationDao extends IDao<ElderlyPhyExamination, Long> {
	
	ElderlyPhyExamination getElderlyPhyExamination(Long personId, int year, String type);
	
	
	/**
	 * 获取老年人健康体检指标统计结果
	 * @param dateStr
	 * @return 统计结果
	 */
	List<Map<String, Object>> getElderlyExaminationStatisticsMapList(String dateStr);

    PageList<ElderlyPhyExamination> getPhysiqueExaminationTableList(Page page, Criteria criteria,
                                                                    String examinationDateStart, String examinationDateEnd, String year);


    PageList<Map<String, Object>> getPageMapTableList(Page page, Criteria criteria, String examinationDateStart,
                                                      String examinationDateEnd, String year);
	/**
	 * 慢病体检统计
	 * @param page
	 * @param form
	 * @return
	 */
	public PageList<Map<String, Object>> getPhyExaminationStatistics(Page page, ReportQueryForm form, Organization currentOrg);


	List<Map<String, Object>> getPhyCensusList(Criteria criteria);
	
	
	void updateEchIdentification(PhysiqueExamination physiqueExamination);

	//处理历史数据部分
	PageList<ElderlyPhyExamination> getPageListHmTemp(Page page, long id);
	PageList<ElderlyPhyExamination> getPageListCdmTemp(Page page, long id);
	PageList<ElderlyPhyExamination> getPageListHmYearTemp(Page page, long id);
	PageList<ElderlyPhyExamination> getPageHmStatusTemp(Page page, long id);

}