package com.founder.rhip.ehr.repository.management.mhm;

import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.mhm.MhmStatisticsReportDto;
import com.founder.rhip.ehr.entity.management.mhm.MhmStatusInfo;
import com.founder.rhip.mdm.common.OrgGenreCode;

/**
 * DAO interface of MhmStatusInfo
 * 
 */
public interface IMhmStatisticsReportDao extends IDao<MhmStatusInfo,Long> {

    /**
	 * 报表管理查询
	 *
	 * @param year:年份： yyyy
	 * @param month：月份： yyyy/MM
	 * @param quarter 季度：1、2、3、4
	 * @param townCode 镇编码
	 * @param orgCode 机构编码
	 * @param orgType 机构类型:中心、站
	 * @return Map<String, MhmStatisticsReportDto>
	 * @author Ye jianfei
	 */ 
    public Map<String, MhmStatisticsReportDto> getStatisticsResult(String year, String month, Integer quarter,String townCode,String orgCode,OrgGenreCode orgType);
}