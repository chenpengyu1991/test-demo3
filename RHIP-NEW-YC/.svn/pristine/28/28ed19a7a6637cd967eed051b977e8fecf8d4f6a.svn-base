package com.founder.rhip.fdm.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.common.RoleType;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.fdm.entity.FoodBorneReport;
import com.founder.rhip.mdm.entity.Organization;

/**
 * @author liuk
 *
 */
public interface IFoodBorneReportService {

	List<FoodBorneReport> getPagedReports(Page page, Criteria criteria, RoleType roleType, Organization organization);

	String saveReport(FoodBorneReport report, Organization organization, User user, RoleType role);

	void updateReport(FoodBorneReport report, Organization organization, User user);

	void updateReport(FoodBorneReport report);

	boolean updateReportJyResult(FoodBorneReport report);

	FoodBorneReport addReport(Organization organization, User user, RoleType role);

	void appReportCard(String op, FoodBorneReport reportInfo, RoleType roleType, User user, Organization organization);

	List<Map<String, Object>> getSummary(String begin, String end);

	FoodBorneReport getReport(Long id);

}
