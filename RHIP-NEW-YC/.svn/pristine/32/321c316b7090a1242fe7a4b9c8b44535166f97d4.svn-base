package com.founder.rhip.ehr.repository.hsa;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.HealthSuperviseForm;
import com.founder.rhip.ehr.entity.hsa.ReportRecord;
import com.founder.rhip.ehr.statisticsdto.HsaServiceReport;

/**
 * @author liuk
 *
 */
public interface IHsaServiceReportDao extends IDao<ReportRecord,Long> {

	List<HsaServiceReport> getReportData(int type,String gbcode, String centerCode, int year, int month);

	List<HsaServiceReport> getInspectionData(int type,String gbcode, String centerCode, String yearMonthStart,
			String yearMonthEndDate);

	List<HsaServiceReport> getEduData(int type,String gbcode, String centerCode, String yearMonthStart,
			String yearMonthEndDate);

	List<HsaServiceReport> getSodpData(int type, String gbcode, String centerCode, String yearMonthStart,
			String yearMonthEndDate);
//------------
	List<HsaServiceReport> getReportData(int type, String gbcode, String centerCode, String yearMonthStart,
			String yearMonthEndDate);

	public 	List<Map<String,Object>> getHealthSupervision(String roleType,HealthSuperviseForm initForm);

    public List<Map<String,Object>> getHealthSupervisionStation(String code,HealthSuperviseForm initForm);

    public List<Map<String,Object>> getHealthSupervisionGB(String gbcode,HealthSuperviseForm initForm);

    public List<Map<String, Object>> getHealthSupervisionAll(HealthSuperviseForm initForm);

	List<Map<String, Object>> getHealthSupervisionList(Criteria criteria,List<String> organCodeList);

}
