package com.founder.rhip.ehr.repository.ihm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of HmOutpatient
 * 
 */
public interface IHmOutpatientDao extends IDao<HmOutpatient,Long> {

	public PageList<HmOutpatient> statisticsOutpatient(Criteria criteria,
			Page page);
	
	/**
	 * 综合管理首页门诊统计
	 * @param criteria
	 * @return
	 */
	public HmOutpatient statisticsOutpatient(Criteria criteria);
	
	/**
	 * 删除历史数据
	 * @param start
	 * @param end
	 * @return
	 */
	public Boolean deleteOutpatientData(String start,String end);

    /**
     * 门急诊运营监管
     * @param paramMap
     * @return
     */
    List<Map<String, Object>> getHmOutpatientMapList(Map<String, String> paramMap);


    //检验检查分析
	public List<Map<String, Object>> getCheckExamList(Map<String, String> paramMap);

	//用药分析
	public List<Map<String, Object>> getDrugUseList(Map<String, String> paramMap);
}