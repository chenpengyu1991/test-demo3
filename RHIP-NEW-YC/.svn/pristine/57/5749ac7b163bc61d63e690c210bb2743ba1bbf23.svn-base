package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of 妇幼保健
 */
public interface IWchTargetDao extends IDao<IdmReport, Long> {
	
	/**
	 * 各年龄段儿童统计
	 * @param paramMap
	 * @return
	 * @author Cary
	 */
	public List<Map<String, Object>> getChildCount(Map<String, String> paramMap);


    /**
     * 儿童保健基础统计
     * @param paramMap
     * @return
     * @author Cary
     */
    public List<Map<String, Object>> getChildBaseCount(Map<String, String> paramMap);

	/**
	 * 住院分娩率
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getHospitalDelivery(Map<String, String> paramMap);


}