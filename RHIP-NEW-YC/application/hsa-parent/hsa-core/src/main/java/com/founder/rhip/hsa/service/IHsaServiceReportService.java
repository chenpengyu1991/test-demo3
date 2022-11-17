package com.founder.rhip.hsa.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.HealthSuperviseForm;
import com.founder.rhip.ehr.statisticsdto.HsaServiceReport;

/**
 * 统计查询
 * @author liuk
 *
 */
public interface IHsaServiceReportService {

	Map<String, HsaServiceReport> getReportData(String gbcode, String centerCode, int year, int month);

	Map<String, HsaServiceReport> getInspectionData(String gbcode, String centerCode, String yearMonthStart,String yearMonthEndDate);

	Map<String, HsaServiceReport> getEduData(String gbcode, String centerCode, String yearMonthStart,String yearMonthEndDate);

	Map<String, HsaServiceReport> getSodpData(String gbcode, String centerCode,  String yearMonthStart,
			String yearMonthEndDate);
//--------------
	Map<String, HsaServiceReport> getReportData(String gbCode, String organCode, String yearMonthStart,
			String yearMonthEndDate);

   public List<Map<String,Object>> getHealthSupervision(String roleType,HealthSuperviseForm initForm);

    public List<Map<String,Object>> getHealthSupervisionStation(String code,HealthSuperviseForm initForm);

    public List<Map<String,Object>> getHealthSupervisionGB(String gbcode,HealthSuperviseForm initForm);

    public List<Map<String,Object>> getHealthSupervisionAll(HealthSuperviseForm initForm);

	List<Map<String, Object>> getHealthSupervisionList(Criteria criteria);
}
