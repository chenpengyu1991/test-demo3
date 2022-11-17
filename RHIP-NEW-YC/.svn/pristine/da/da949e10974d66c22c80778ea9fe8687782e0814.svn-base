package com.founder.rhip.fdm.repository;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.fdm.entity.FoodBorneReport;

import java.util.List;
import java.util.Map;

/**
 * @author liuk
 *
 */
public interface IFoodBorneReportDao extends IDao<FoodBorneReport,Long> {

    List<Map<String, Object>> getSummary(String begin, String end);

    String generatedNumGroupByOrg(String orgIndex,Integer year);

}