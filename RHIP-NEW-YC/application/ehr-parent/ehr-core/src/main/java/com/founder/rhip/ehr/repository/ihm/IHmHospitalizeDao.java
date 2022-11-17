package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of HmHospitalize
 * 
 */
public interface IHmHospitalizeDao extends IDao<HmHospitalize, Long> {

	public PageList<HmHospitalize> statisticsHospitalize(Criteria criteria,
			Page page);
	
	/**
	 * 综合管理首页住院统计
	 * @param criteria
	 * @return
	 */
	public HmHospitalize statisticsHospitalize(Criteria criteria);
	
	/**
	 * 删除历史数据
	 * @param start
	 * @param end
	 * @return
	 */
	public Boolean deleteHospitalizeData(String start,String end);

    /**
     * 门急诊运营监管
     * @param paramMap
     * @return
     */
    List<Map<String, Object>> getHmHospitalizeMapList(Map<String, String> paramMap);
	
}