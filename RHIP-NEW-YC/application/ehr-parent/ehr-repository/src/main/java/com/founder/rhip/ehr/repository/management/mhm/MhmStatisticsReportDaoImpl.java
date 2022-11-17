package com.founder.rhip.ehr.repository.management.mhm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.mhm.MhmStatisticsReportDto;
import com.founder.rhip.ehr.entity.management.mhm.MhmStatusInfo;
import com.founder.rhip.mdm.common.OrgGenreCode;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
/**
 * 精神卫生报表查询
 * 
 */
@Repository("mhmStatisticsReportDao")
public class MhmStatisticsReportDaoImpl extends AbstractDao<MhmStatusInfo, Long> implements IMhmStatisticsReportDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 查询MHM_SEVERITY表，获得指定时间内，最后一次病人类型记录
     * 病人类型：重性：1、非重性：2
     */
    private static final String SEVERITY_SQL = " SELECT a.event_id , dt, status FROM MHM_SEVERITY b, ("
    		+ " SELECT event_id, max(start_dt)  dt FROM MHM_SEVERITY"
    		+ " WHERE %1$s"//to_char(start_dt, 'yyyy/mm')<='2013/09'
    		+ " GROUP BY event_id) A"
    		+ " where b.event_id = a.event_id and b.start_dt = a.dt";

    /**
     * 查询MHM_SEVERITY表，与上一单位（年、月、季度，同比增加、减少）比较
     * 病人类型：重性：1、非重性：2
     */
    private static final String SEVERITY_CHANGE_SQL = " SELECT a.event_id , dt, status FROM MHM_SEVERITY b, ("
    		+ " SELECT event_id, max(start_dt)  dt FROM MHM_SEVERITY"
    		+ " WHERE %2$s"//to_char(start_dt, 'yyyy/mm')<=to_char(add_months(to_date('2013/09','yyyy/mm'),-1),'yyyy/mm') 
    		+ " GROUP BY event_id) A"
    		+ " where b.event_id = a.event_id and b.start_dt = a.dt";
    
    /**
     * 查询MHM_DRUG_FREE表，获得指定时间内，是否免费服药
     * 免费：1、收费：2
     */
    private static final String DRUG_FREE_SQL = " SELECT   a.event_id ,   dt, status FROM MHM_DRUG_FREE b, ("
    		+ " SELECT event_id, max(start_dt)  dt  FROM MHM_DRUG_FREE"
    		+ " WHERE %1$s"//to_char(start_dt, 'yyyy/mm')<='2013/09'
    		+ " GROUP BY event_id) A"
    		+ " where b.event_id = a.event_id and b.start_dt = a.dt";

    /**
     * 查询MHM_DRUG_USE表，是否有发药记录
     */
    private static final String DRUG_RECORD_SQL = " SELECT   a.STATUS_ID  FROM MHM_DRUG_USE b, ("
    		+ " SELECT STATUS_ID, MAX(id) record_id  FROM MHM_DRUG_USE"
    		+ " WHERE %6$s"//to_char(start_dt, 'yyyy/mm')<='2013/09'
    		+ " GROUP BY STATUS_ID) A"
    		+ " where b.STATUS_ID = a.STATUS_ID and b.id = a.record_id";
    
    /**
     * 查询MHM_FOLLOWUP表，获得指定时间内，随访病人类型，检验检查
     * 免费：1、收费：2
     */
    private static final String FOLLOWUP_SQL = " select status_id,sum(holergasia) holergasia,sum(regular) regular,"
    		+ " SUM(A01) A01,SUM(A02) A02,SUM(A03) A03,SUM(A04) A04,SUM(A99) A99 from("
    		+ " select  status_id ,event_id"
    		+ " ,DECODE(instr(CHECK_TYPE,'A01'),0,0,null,0,1) A01"
    		+ " ,DECODE(instr(CHECK_TYPE,'A02'),0,0,null,0,1)  A02"
    		+ " ,DECODE(instr(CHECK_TYPE,'A03'),0,0,null,0,1) A03"
    		+ " ,DECODE(instr(CHECK_TYPE,'A04'),0,0,null,0,1)  A04"
    		+ " ,DECODE(instr(CHECK_TYPE,'A99'),0,0,null,0,1) A99"
    		+ " ,case when patient_Type =1 then 1 else 0 end holergasia"
    		+ " ,case  when patient_Type =2 then 1 else 0 end regular from mhm_followup"
    		+ " WHERE %3$s"//to_char(followup_dt, 'yyyy/mm')='2013/09'
    		+ " )group by status_id";

    /**
     * 查询MHM_ECONOMY表，获得指定时间内，最后一次病人经济状况记录
     * 经济状况：经济状况类型（1贫困，在当地贫困线标准以下 ，2非贫困，3不详）
     */
    private static final String ECONOMY_SQL = " SELECT a.event_id , dt, status FROM MHM_ECONOMY b, ("
    		+ " SELECT event_id, max(start_dt)  dt FROM MHM_ECONOMY"
    		+ " WHERE %1$s"
    		+ " GROUP BY event_id) A"
    		+ " where b.event_id = a.event_id and b.start_dt = a.dt";
 
    /**
     * 主SQL
     */
    //@formatter:off
    private static final String BASE_SQL = " select %5$s"
    		+ " ,sum(holergasia) TOTAL_NUM_SEVERE"//病人总数-重性病人数
    		+ " ,sum(holergasiaPoor) TOTAL_NUM_SEVERE_POOR"//病人总数-重性病人数(贫困)
    		+ " ,sum(holergasiaNotPoor) TOTAL_NUM_SEVERE_NOT_POOR"//病人总数-重性病人数(非贫困)
    		+ " ,sum(regular) total_Num_Ordinary"//病人总数-普通病人数
    		+ " ,decode(sign(sum(holergasia) - sum(changeHolergasia)),1,sum(holergasia) - sum(changeHolergasia),0) raise_Severe"//病人增减数-重性病人增加
    		+ " ,decode(sign(sum(regular) - sum(changeRegular)),1,sum(regular) - sum(changeRegular),0) raise_Ordinary"//病人增减数-普通病人增加
    		+ " ,decode(sign(sum(changeHolergasia) - sum(holergasia)),1,sum(changeHolergasia) - sum(holergasia),0) decrease_Severe"//病人增减数-重性病人减少
    		+ " ,decode(sign(sum(changeRegular) - sum(regular)),1,sum(changeRegular) - sum(regular),0) decrease_Ordinary"//病人增减数-普通病人减少
    		+ " ,sum(freeSevereFlag) free_Dispensing_Severe"//免费发药-免费发药人数(重性)
    		+ " ,sum(freeOrdinaryFlag) free_Dispensing_Ordinary"//免费发药-免费发药人数(非重性)
    		+ " ,sum(freeSevereFlag) reality_Medicine_Severe"//免费发药-实际吃药人数(重性)
    		+ " ,sum(freeOrdinaryFlag) reality_Medicine_Ordinary"//免费发药-实际吃药人数(非重性)
    		+ " ,NVL(sum(fHolergasia),0)  followup_Severe"//随访次数-重性病人数
    		+ " ,NVL(sum(medicineNumber),0)  followup_Network"//随访次数-网络直报随访人数
    		+ " ,NVL(sum(fRegular),0)  followup_Ordinary"//随访次数-普通病人数
    		+ " ,SUM(checkNumber) check_Number"//化验检查-人数
    		+ " ,SUM(A01) check_Ecg"//化验检查-心电
    		+ " ,SUM(A02) check_Type_B"//化验检查-B超
    		+ " ,SUM(A03) check_Liver"//化验检查-肝功能
    		+ " ,SUM(A04) check_Blood_Tests"//化验检查-血常规
    		+ " ,SUM(A99) check_Other"//化验检查-其他检查
    		+ " ,SUM(severeCumulativeFile) TOTAL_CUMULATIVE_FILE"//当前病人类型
    		+ " from("
    		+ " SELECT status.ID STATUS_ID,event.id EVENT_ID"
    		+ " ,other.MANAGEMENT_TOWN,other.management_center,other.management_station"
    		+ " ,case when patientType.status =1 then 1 else 0 end holergasia"
    		+ " ,case when (patientType.status =1 AND economy.status=1) then 1 else 0 end holergasiaPoor"//贫困
    		+ " ,case when (patientType.status =1 AND economy.status=2) then 1 else 0 end holergasiaNotPoor"//非贫困
    		+ " ,case  when patientType.status =2 then 1 else 0 end regular"
    		+ " ,case when patientTypeChange.status =1 then 1 else 0 end changeHolergasia"
    		+ " ,case  when patientTypeChange.status =2 then 1 else 0 end changeRegular"
    		+ " ,case  when (free.status =1 AND patientType.status =1) then 1 else 0 end freeSevereFlag"
    		+ " ,case  when (free.status =1 AND patientType.status =2) then 1 else 0 end freeOrdinaryFlag"
    		+ " ,CASE WHEN (patientType.status =1 AND followup.status_id IS NOT NULL) THEN 1 ELSE 0 END  fHolergasia"
    		+ " ,CASE WHEN (patientType.status =2 AND followup.status_id IS NOT NULL) THEN 1 ELSE 0 END fRegular"
    		+ " ,CASE WHEN (patientType.status =1 AND followup.status_id IS NOT NULL AND record.status_id IS NOT NULL) THEN 1 ELSE 0 END  medicineNumber" //重性+服药
    		+ " ,decode(sign(followup.A01 + followup.A02 + followup.A03 + followup.A04 + followup.A99),1,1,0) checkNumber"
    		+ " ,decode(sign(followup.A01),1,1,0) A01"
    		+ " ,decode(sign(followup.A02),1,1,0) A02"
    		+ " ,decode(sign(followup.A03),1,1,0) A03"
    		+ " ,decode(sign(followup.A04),1,1,0) A04"
    		+ " ,decode(sign(followup.A99),1,1,0) A99"
    		+ " ,decode(other.PATIENT_TYPE,1,1,0) severeCumulativeFile"//当前病人类型
    		+ " FROM MHM_STATUS_INFO status"
    		+ " LEFT JOIN MHM_EVENT_INFO event ON (status.id = event.status_id and event.event_type IN (2001) )"
    		+ " LEFT JOIN mhm_basics_info basics ON basics.event_id = event.id"
    		+ " LEFT JOIN MHM_OTHER_INFO other ON other.event_id = event.id"
    		+ " LEFT JOIN("
    		+ SEVERITY_SQL
    		+ " ) patientType on patientType.event_id = event.id"
    		+ " LEFT JOIN("
    		+ ECONOMY_SQL
    		+ " ) economy on economy.event_id = event.id"    		
    		+ " LEFT JOIN("
    		+ SEVERITY_CHANGE_SQL
    		+ " ) patientTypeChange on patientTypeChange.event_id = event.id"
    		+ " LEFT JOIN("
    		+ DRUG_FREE_SQL
    		+ " ) free on free.event_id = event.id "
    		+ " LEFT JOIN("
    		+ DRUG_RECORD_SQL
    		+ " ) record on record.STATUS_ID = status.id "    		
    		+ " LEFT JOIN("
    		+ FOLLOWUP_SQL
    		+ " ) followup on followup.status_id = status.id "
    		+ " WHERE (status.status = 4 or status.status = 9) and event.event_type IN (2001) %4$s"
    		+ " ORDER BY status.id ) result "
    		+ " group by %5$s";    
    //@formatter:on
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
    @Override
    public Map<String, MhmStatisticsReportDto> getStatisticsResult(String year, String month, Integer quarter,String townCode,String orgCode,OrgGenreCode orgType){
    	Map<String, MhmStatisticsReportDto> reportMap = new HashMap<String, MhmStatisticsReportDto>();
		MapSqlParameterSource sqlParameterSource = getParameterSource(year, month, quarter,townCode,orgCode,orgType);
		String sql = getStatisticsSql(year, month, quarter,townCode,orgCode,orgType);
		List<Map<String, Object>> maps = this.getMapList(sql, sqlParameterSource);
		for (Map<String, Object> map : maps) {
			MhmStatisticsReportDto dto = this.get(map, MhmStatisticsReportDto.class);
			if(orgType.equals(OrgGenreCode.CENTRE)){
				reportMap.put(dto.getManagementCenter(), dto);
			}
			if(orgType.equals(OrgGenreCode.STATION)){
				reportMap.put(dto.getManagementStation(), dto);
			}			
		}
		return reportMap;
		
    }

    private String getStatisticsSql(String year, String month, Integer quarter,String townCode,String orgCode,OrgGenreCode orgType){
    	StringBuilder where1 = new StringBuilder();
		StringBuilder where2 = new StringBuilder();
		StringBuilder where3 = new StringBuilder();
		StringBuilder where4 = new StringBuilder();
		StringBuilder where6 = new StringBuilder();
		String groupColumn = null;
		String baseSql= BASE_SQL;
		
		where1.append(buildWhere(1, year, month, quarter));
		where2.append(buildWhere(2, year, month, quarter));
		where3.append(buildWhere(3, year, month, quarter));
		where6.append(buildWhere(6, year, month, quarter));

		if(orgType.equals(OrgGenreCode.CENTRE)){
			if(ObjectUtil.isNotEmpty(townCode)){
				where4.append(" AND MANAGEMENT_TOWN = :townCode");
			}			
			if(ObjectUtil.isNotEmpty(orgCode)){
				where4.append(" AND management_center = :orgCode");
			}
			groupColumn = "MANAGEMENT_TOWN,MANAGEMENT_CENTER";
		}	
		if(orgType.equals(OrgGenreCode.STATION)){
			if(ObjectUtil.isNotEmpty(orgCode)){
				where4.append(" AND management_station = :orgCode");
			}
			groupColumn = "MANAGEMENT_TOWN,MANAGEMENT_CENTER,MANAGEMENT_STATION";
		}
		return String.format(baseSql, where1.toString(),where2.toString(),where3.toString(),where4.toString(), groupColumn,where6);    	
    }
    
    private MapSqlParameterSource getParameterSource(String year, String month, Integer quarter,String townCode,String orgCode,OrgGenreCode orgType){
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		/*按季度*/
		if(ObjectUtil.isNotEmpty(quarter) && ObjectUtil.isNotEmpty(year)){
			sqlParameterSource.addValue("year", year);
			sqlParameterSource.addValue("quarter", quarter);			
		}	
		/*按月*/
		else if(ObjectUtil.isNotEmpty(month)){
			sqlParameterSource.addValue("month", month);			
		}
		/*按年*/
		else if (ObjectUtil.isNotEmpty(year)) {
			sqlParameterSource.addValue("year", year);
			sqlParameterSource.addValue("yearChange", year + "/01");
		}
		if(orgType.equals(OrgGenreCode.CENTRE)){
			if(ObjectUtil.isNotEmpty(townCode)){
				sqlParameterSource.addValue("townCode", townCode);		
			}			
			if(ObjectUtil.isNotEmpty(orgCode)){
				sqlParameterSource.addValue("orgCode", orgCode);		
			}
		}	
		if(orgType.equals(OrgGenreCode.STATION)){
			if(ObjectUtil.isNotEmpty(orgCode)){
				sqlParameterSource.addValue("orgCode", orgCode);	
			}
		}  
		return sqlParameterSource;
    }
    
    private String buildWhere(Integer type,String year, String month, Integer quarter){
    	StringBuilder where = new StringBuilder();
    	String yearWhere = " TO_CHAR(%1$s, 'yyyy') %2$s";
    	String monthWhere = " TO_CHAR(%1$s, 'yyyy/MM') %2$s";
    	String quarterWhere = " TO_CHAR(%1$s, 'yyyy') %2$s  AND TO_CHAR(%1$s, 'q') %3$s";
    	switch (type){//条件类型
    		case 1:
    			yearWhere = String.format(yearWhere, "START_DT","<=:year");
    			monthWhere = String.format(monthWhere, "START_DT","<=:month");
    			quarterWhere = String.format(quarterWhere, "START_DT","<=:year","<=:quarter");
    			break;
    		case 2:
    			yearWhere  = String.format(yearWhere, "START_DT","<=to_char(add_months(to_date(:yearChange,'yyyy/mm'),-12),'yyyy') ");
    			monthWhere = String.format(monthWhere, "START_DT","<=to_char(add_months(to_date(:month,'yyyy/mm'),-1),'yyyy/mm') ");
    			quarterWhere = String.format(quarterWhere, "START_DT","<=:year","<=:quarter-1");
    			break;
    		case 3:
    			yearWhere  = String.format(yearWhere, "FOLLOWUP_DT","=:year");
    			monthWhere = String.format(monthWhere, "FOLLOWUP_DT","=:month");
    			quarterWhere = String.format(quarterWhere, "FOLLOWUP_DT","=:year","=:quarter");;
    			break;
    		case 6:
    			yearWhere = String.format(yearWhere, "USE_DT","=:year");
    			monthWhere = String.format(monthWhere, "USE_DT","=:month");
    			quarterWhere = String.format(quarterWhere, "USE_DT","=:year","=:quarter");    			
    	}
    	/*按季度*/
		if(ObjectUtil.isNotEmpty(quarter) && ObjectUtil.isNotEmpty(year)){
			where.append(quarterWhere);
		}
		/*按月*/
		else if(ObjectUtil.isNotEmpty(month)){
			where.append(monthWhere);
		}
		/*按年*/
		else if (ObjectUtil.isNotEmpty(year)) {
			where.append(yearWhere);
		}  
    	return where.toString();
    }
}