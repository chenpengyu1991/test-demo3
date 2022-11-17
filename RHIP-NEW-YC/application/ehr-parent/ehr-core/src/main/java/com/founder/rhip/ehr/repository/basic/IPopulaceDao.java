package com.founder.rhip.ehr.repository.basic;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.cache.Cache;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.ehr.dto.FamilyStatisticDto;
import com.founder.rhip.ehr.entity.basic.Populace;

public interface IPopulaceDao extends IDao<Populace, Long> {

	List<String> getOrgCodes();

	/**
     * 根据镇 中心统计人口
     * @param criteria
     * @return
     */
    public List<Populace> getTarget(String gbCode, String organCode, Integer countYear, String genreCode);
    
    /**
     * 获取户籍非户籍的数据
     * @param dateStr 日期格式必须是yyyy
     * @return
     */
    public List<Map<String, Object>> getPopulaceStatistics(String dateStr);

    public List<Map<String, Object>> getPopolaceReport(Criteria criteria);

    /**
     * 获取人口总数
     * @param criteria
     * @return
     */
    public Map<String, Object> getTotalCountByYear(Criteria criteria);


    List<FamilyStatisticDto> getFamilyStatisticDtoList(Criteria criteria, List<String> organCodeList);

}
