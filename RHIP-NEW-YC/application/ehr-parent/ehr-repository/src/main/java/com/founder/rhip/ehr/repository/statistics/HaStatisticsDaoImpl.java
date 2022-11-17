package com.founder.rhip.ehr.repository.statistics;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.HaStatistics;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IOrganizationDao;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * DAO implement of HaStatistics
 * 
 */
@Repository("haStatisticsDao")
public class HaStatisticsDaoImpl extends AbstractDao<HaStatistics, Long> implements IHaStatisticsDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    @Resource
	private IOrganizationDao organizationDao;

	@Override
	public List<HaStatistics> getCommunityArchiveManagementList(Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder();
		String statisticsDate = String.valueOf(paramMap.get("statisticsDate"));
		String orgCode = String.valueOf(paramMap.get("orgCode"));
		sb.append("SELECT RP_STATISTICS.HR_ARCHIVE_NEW,RP_STATISTICS.HR_ARCHIVE_TOTAL,RP_STATISTICS.HR_ONE_STAR,RP_STATISTICS.HR_TWO_STAR,RP_STATISTICS.HR_THREE_STAR,RP_STATISTICS.UNHR_ONE_STAR,RP_STATISTICS.UNHR_TWO_STAR,RP_STATISTICS.UNHR_THREE_STAR,RP_STATISTICS.UNHR_ARCHIVE_NEW,RP_STATISTICS.UNHR_ARCHIVE_TOTAL,RP_STATISTICS.HR_ARCHIVE_CANCEL,RP_STATISTICS.HR_ARCHIVE_EMIGRATION,RP_STATISTICS.UNHR_ARCHIVE_CANCEL,RP_STATISTICS.UNHR_ARCHIVE_EMIGRATION FROM RP_STATISTICS WHERE 1 = 1");
		if(statisticsDate != null) {
			switch (statisticsDate) {
			case "1":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE, 'YYYY-MM-DD') = TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD')");
				break;
			case "2":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'MM') = " + ((Calendar.getInstance().get(Calendar.MONTH)) + 1));
				break;
			case "3":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'YYYY') = " + (Calendar.getInstance().get(Calendar.YEAR)));
				break;
			default:
				break;
			}
		}
		if(orgCode != null) {
			sb.append(" AND ORG_CODE = '" + orgCode + "'");
		}
		//SqlBuilder.buildWhereStatement(HaStatistics.class, sb, c);
		return this.getList(sb.toString());
	}

	@Override
	public List<HaStatistics> getCommunityMajorCrowdList(Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT RP_STATISTICS.HR_SIX_CHILD,RP_STATISTICS.HR_FERTILE_WOMAN,RP_STATISTICS.HR_SIXO_TO_SIXF,RP_STATISTICS.HR_GREAT_SIXF,RP_STATISTICS.UNHR_SIX_CHILD,RP_STATISTICS.UNHR_FERTILE_WOMAN,RP_STATISTICS.UNHR_SIXO_TO_SIXF,RP_STATISTICS.UNHR_GREAT_SIXF FROM RP_STATISTICS WHERE 1 = 1");
		if(String.valueOf(paramMap.get("statisticsDate")) != null) {
			switch (String.valueOf(paramMap.get("statisticsDate"))) {
			case "1":
				sb.append(" AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE, 'YYYY-MM-DD') = TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD')");
				break;
			case "2":
				sb.append(" AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'MM') = " + ((Calendar.getInstance().get(Calendar.MONTH)) + 1));
				break;
			case "3":
				sb.append(" AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'YYYY') = " + (Calendar.getInstance().get(Calendar.YEAR)));
				break;
			default:
				break;
			}
		}
		if(String.valueOf(paramMap.get("orgCode")) != null) {
			sb.append(" AND ORG_CODE = '" + String.valueOf(paramMap.get("orgCode")) + "'");
		}
		//SqlBuilder.buildWhereStatement(HaStatistics.class, sb, c);
		return this.getList(sb.toString());
	}
	
	@Override
	public List<HaStatistics> getCdcMajorCrowdList(Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder();
		Criteria cr = new Criteria();
		cr.add("parentCode", String.valueOf(paramMap.get("orgCode")));
//		sb.append("SELECT SY_MDM_ORGANIZATION.ORGAN_CODE FROM SY_MDM_ORGANIZATION WHERE PARENT_CODE = :organCode");
		List<Organization> orgList = organizationDao.getList(cr, "organCode"); //查询当前中心下所有服务站CODE
//		List<Map<String, Object>> list = this.getMapList(sb.toString(), cr);
		sb = new StringBuilder();
		sb.append("SELECT SUM(RP_STATISTICS.HR_SIX_CHILD) AS HR_SIX_CHILD,SUM(RP_STATISTICS.HR_FERTILE_WOMAN) AS HR_FERTILE_WOMAN,SUM(RP_STATISTICS.HR_SIXO_TO_SIXF) AS HR_SIXO_TO_SIXF,SUM(RP_STATISTICS.HR_GREAT_SIXF) AS HR_GREAT_SIXF,SUM(RP_STATISTICS.UNHR_SIX_CHILD) AS UNHR_SIX_CHILD,SUM(RP_STATISTICS.UNHR_FERTILE_WOMAN) AS UNHR_FERTILE_WOMAN,SUM(RP_STATISTICS.UNHR_SIXO_TO_SIXF) AS UNHR_SIXO_TO_SIXF,SUM(RP_STATISTICS.UNHR_GREAT_SIXF) AS UNHR_GREAT_SIXF FROM RP_STATISTICS WHERE 1 = 1");
		if(String.valueOf(paramMap.get("statisticsDate")) != null) {
			switch (String.valueOf(paramMap.get("statisticsDate"))) {
			case "1":
				sb.append(" AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE, 'YYYY-MM-DD') = TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD')");
				break;
			case "2":
				sb.append(" AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'MM') = " + ((Calendar.getInstance().get(Calendar.MONTH)) + 1));
				break;
			case "3":
				sb.append(" AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'YYYY') = " + (Calendar.getInstance().get(Calendar.YEAR)));
				break;
			default:
				break;
			}
		}
		StringBuilder orgCode = new StringBuilder();
		for(Organization org : orgList) {
			if(ObjectUtil.isNotEmpty(org.getOrganCode())) {
				orgCode.append("'").append(org.getOrganCode()).append("',");
			}
			
		}
		if(orgCode.length() > 0) {
			sb.append("AND ORG_CODE IN(" + orgCode.substring(0, orgCode.length() - 1)  + ")");
		}
//		SqlBuilder.buildWhereStatement(HaStatistics.class, sb, c);
		return this.getList(sb.toString());
	}

	@Override
	public List<HaStatistics> getAdminMajorCrowdList(
			Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder();
//		Criteria cr = new Criteria();
//		cr.add("orgCode", String.valueOf(paramMap.get("orgCode")));
//		sb.append("SELECT ORGANIZATION.ORG_CODE FROM ORGANIZATION WHERE SUP_ORGAN_CODE = :orgCode");
//		List<Map<String, Object>> list = this.getMapList(sb.toString(), cr);//查询当前中心下所有服务站CODE
//		sb = new StringBuilder();
		sb.append("SELECT SUM(RP_STATISTICS.HR_SIX_CHILD) AS HR_SIX_CHILD,SUM(RP_STATISTICS.HR_FERTILE_WOMAN) AS HR_FERTILE_WOMAN,SUM(RP_STATISTICS.HR_SIXO_TO_SIXF) AS HR_SIXO_TO_SIXF,SUM(RP_STATISTICS.HR_GREAT_SIXF) AS HR_GREAT_SIXF,SUM(RP_STATISTICS.UNHR_SIX_CHILD) AS UNHR_SIX_CHILD,SUM(RP_STATISTICS.UNHR_FERTILE_WOMAN) AS UNHR_FERTILE_WOMAN,SUM(RP_STATISTICS.UNHR_SIXO_TO_SIXF) AS UNHR_SIXO_TO_SIXF,SUM(RP_STATISTICS.UNHR_GREAT_SIXF) AS UNHR_GREAT_SIXF FROM RP_STATISTICS WHERE 1 = 1");
		if(String.valueOf(paramMap.get("statisticsDate")) != null) {
			switch (String.valueOf(paramMap.get("statisticsDate"))) {
			case "1":
				sb.append(" AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE, 'YYYY-MM-DD') = TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD')");
				break;
			case "2":
				sb.append(" AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'MM') = " + ((Calendar.getInstance().get(Calendar.MONTH)) + 1));
				break;
			case "3":
				sb.append(" AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'YYYY') = " + (Calendar.getInstance().get(Calendar.YEAR)));
				break;
			default:
				break;
			}
		}
		sb.append("GROUP BY GBCODE");
		//SqlBuilder.buildWhereStatement(HaStatistics.class, sb, c);
		return this.getList(sb.toString());
	}

	@Override
	public List<HaStatistics> getCdmList(Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder();
		String statisticsDate = String.valueOf(paramMap.get("statisticsDate"));
		String orgCode = String.valueOf(paramMap.get("orgCode"));
		sb.append("SELECT RP_STATISTICS.ID, RP_STATISTICS.HR_HBP,RP_STATISTICS.HR_DM,RP_STATISTICS.HR_CA,RP_STATISTICS.HR_HD,RP_STATISTICS.HR_STROKE,RP_STATISTICS.UNHR_HBP,RP_STATISTICS.UNHR_DM,RP_STATISTICS.UNHR_CA,RP_STATISTICS.UNHR_HD,RP_STATISTICS.UNHR_STROKE FROM RP_STATISTICS WHERE 1 = 1");
		if(statisticsDate != null) {
			switch (statisticsDate) {
			case "1":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE, 'YYYY-MM-DD') = TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD')");
				break;
			case "2":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'MM') = " + ((Calendar.getInstance().get(Calendar.MONTH)) + 1));
				break;
			case "3":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'YYYY') = " + (Calendar.getInstance().get(Calendar.YEAR)));
				break;
			default:
				break;
			}
		}
		if(orgCode != null) {
			sb.append(" AND ORG_CODE = '" + orgCode + "'");
		}
		//SqlBuilder.buildWhereStatement(HaStatistics.class, sb, c);
		return this.getList(sb.toString());
	}

	@Override
	public Integer getCountByDateAndOrgcode(Criteria cr) {
		return Integer.valueOf(this.getMap("SELECT COUNT(1) AS COUNT FROM RP_STATISTICS WHERE TO_CHAR(STATISTICS_DATE, 'YYYY-MM-DD') = TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') AND ORG_CODE = :orgCode", cr).get("COUNT").toString());
	}

	@Override
	public HaStatistics getEntityByDateAndOrgcode(Criteria cr) {
		return this.get("SELECT ID, ORG_CODE, ORG_NAME, STATISTICS_DATE, HR_SIX_CHILD, HR_FERTILE_WOMAN, HR_SIXO_TO_SIXF, HR_GREAT_SIXF, HR_ARCHIVE_NEW, HR_ARCHIVE_TOTAL, HR_ARCHIVE_COUNT, HR_ARCHIVE_CANCEL, HR_ARCHIVE_EMIGRATION, HR_HBP, HR_DM, HR_CA, HR_HD, HR_STROKE, HR_OUTPATIENT, HR_IN_HOSPITAL, HR_PE, UNHR_SIX_CHILD, UNHR_FERTILE_WOMAN, UNHR_SIXO_TO_SIXF, UNHR_GREAT_SIXF, UNHR_ARCHIVE_NEW, UNHR_ARCHIVE_TOTAL, UNHR_ARCHIVE_COUNT, UNHR_ARCHIVE_CANCEL, UNHR_ARCHIVE_EMIGRATION, UNHR_HBP, UNHR_DM, UNHR_CA, UNHR_HD, UNHR_STROKE, UNHR_OUTPATIENT, UNHR_IN_HOSPITAL, UNHR_PE, NOFILE, TRANSFERRED, CANCELLED, ROLLOUT, HR_ONE_STAR, HR_TWO_STAR, HR_THREE_STAR, UNHR_ONE_STAR, UNHR_TWO_STAR, UNHR_THREE_STAR FROM RP_STATISTICS WHERE TO_CHAR(STATISTICS_DATE, 'YYYY-MM-DD') = TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD') AND ORG_CODE = :orgCode", cr);
	}

	@Override
	public HaStatistics getQuickJob(Criteria criteria) {
		String inputOrganCode = (String) criteria.get("intputOrganCode");
		StringBuffer sb = new StringBuffer("SELECT PERSON_WAIT_CREATE,PERSON_HAD_CREATE,PERSON_HAD_WRITEOFF,FAMILY_HAD_CREATE,FAMILY_HAD_WRITEOFF FROM( ")
				.append("SELECT INPUT_ORGAN_CODE,COUNT(CASE WHEN FILING_FLAG = 1 THEN 1 END) PERSON_HAD_CREATE,COUNT(CASE WHEN FILING_FLAG = 9 THEN 1 END) PERSON_HAD_WRITEOFF ")
				.append("FROM BI_PERSON_INFO WHERE INPUT_ORGAN_CODE = '" + inputOrganCode + "' GROUP BY INPUT_ORGAN_CODE)PERSON ")
				.append("LEFT JOIN( ")
				.append("SELECT '" + inputOrganCode + "' INPUT_ORGAN_CODE, COUNT(CASE WHEN FILING_FLAG = 0 THEN 1 END) PERSON_WAIT_CREATE FROM BI_PERSON_INFO) UNCREATEPERSON ")
				.append("ON PERSON.INPUT_ORGAN_CODE = UNCREATEPERSON.INPUT_ORGAN_CODE ")
				.append("LEFT JOIN( ")
				.append("SELECT INPUT_ORGAN_CODE,COUNT(CASE WHEN STATUS = 0 THEN 1 END) FAMILY_HAD_CREATE,COUNT(CASE WHEN STATUS = 2 THEN 1 END) FAMILY_HAD_WRITEOFF ")
				.append("FROM BI_FAMILY_INFO WHERE INPUT_ORGAN_CODE = '" + inputOrganCode + "' GROUP BY INPUT_ORGAN_CODE)FAMILY ")
				.append("ON PERSON.INPUT_ORGAN_CODE = FAMILY.INPUT_ORGAN_CODE");
		List<HaStatistics> list = getList(sb.toString());
		return (list != null && list.size() > 0) ? getList(sb.toString()).get(0) : null;
	}

	@Override
	public List<HaStatistics> getTownDistribution(Map<String, Object> paramMap) {
		return this.getList("SELECT SUM(RP_STATISTICS.HR_ARCHIVE_NEW) + SUM(UNHR_ARCHIVE_NEW) AS HR_ARCHIVE_NEW,TOWN_NAME FROM RP_STATISTICS WHERE GBCODE IS NOT NULL GROUP BY GBCODE,TOWN_NAME");
	}

	@Override
	public List<HaStatistics> getCommunityDistribution(
			Criteria cr) {
		String communityDistributionSql = "SELECT SUM(HR_ARCHIVE_NEW) + SUM (UNHR_ARCHIVE_NEW) AS HR_ARCHIVE_NEW, ORG_CODE AS ORG_CODE FROM RP_STATISTICS GROUP BY ORG_CODE ";
		List<HaStatistics> haStatisticsList = this.getList(communityDistributionSql, cr);
		Map<String, Integer> haStatisticsMap = new HashMap<String, Integer>();
		for (HaStatistics haStatistics : haStatisticsList) {
			haStatisticsMap.put(haStatistics.getOrgCode(), haStatistics.getHrArchiveNew());
		}
		List<Organization> orgs = organizationDao.getList(cr);
		haStatisticsList = new ArrayList<HaStatistics>();
		for (Organization org : orgs) {
			HaStatistics haStatistics = new HaStatistics();
			haStatistics.setHrArchiveNew(haStatisticsMap.get(org.getOrganCode()));
			haStatistics.setTownName(org.getOrganName());
			haStatisticsList.add(haStatistics);
		}
		return haStatisticsList;
	}

	@Override
	public List<HaStatistics> getCdcArchiveManagementList(
			Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder();
//		Criteria cr = new Criteria();
//		cr.add("organCode", String.valueOf(paramMap.get("orgCode")));
//		sb.append("SELECT SY_MDM_ORGANIZATION.ORGAN_CODE FROM SY_MDM_ORGANIZATION WHERE PARENT_CODE = :organCode");
//		List<Map<String, Object>> list = this.getMapList(sb.toString(), cr);//查询当前中心下所有服务站CODE
		sb = new StringBuilder();
		sb.append("SELECT SUM(RP_STATISTICS.HR_ARCHIVE_NEW) AS HR_ARCHIVE_NEW,SUM(RP_STATISTICS.HR_ARCHIVE_TOTAL) AS HR_ARCHIVE_TOTAL,SUM(RP_STATISTICS.HR_ONE_STAR) AS HR_ONE_STAR,SUM(RP_STATISTICS.HR_TWO_STAR) AS HR_TWO_STAR,SUM(RP_STATISTICS.HR_THREE_STAR) AS HR_THREE_STAR,SUM(RP_STATISTICS.UNHR_ONE_STAR) AS UNHR_ONE_STAR,SUM(RP_STATISTICS.UNHR_TWO_STAR) AS UNHR_TWO_STAR,SUM(RP_STATISTICS.UNHR_THREE_STAR) AS UNHR_THREE_STAR,SUM(RP_STATISTICS.UNHR_ARCHIVE_NEW) AS UNHR_ARCHIVE_NEW,SUM(RP_STATISTICS.UNHR_ARCHIVE_TOTAL) AS UNHR_ARCHIVE_TOTAL ,SUM(RP_STATISTICS.HR_ARCHIVE_CANCEL) AS HR_ARCHIVE_CANCEL,SUM(RP_STATISTICS.HR_ARCHIVE_EMIGRATION) AS HR_ARCHIVE_EMIGRATION,SUM(RP_STATISTICS.UNHR_ARCHIVE_CANCEL) AS UNHR_ARCHIVE_CANCEL,SUM(RP_STATISTICS.UNHR_ARCHIVE_EMIGRATION) AS UNHR_ARCHIVE_EMIGRATION FROM RP_STATISTICS WHERE 1 = 1");
		if(String.valueOf(paramMap.get("statisticsDate")) != null) {
			switch (String.valueOf(paramMap.get("statisticsDate"))) {
			case "1":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE, 'YYYY-MM-DD') = TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD')");
				break;
			case "2":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'MM') = " + ((Calendar.getInstance().get(Calendar.MONTH)) + 1));
				break;
			case "3":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'YYYY') = " + (Calendar.getInstance().get(Calendar.YEAR)));
				break;
			default:
				break;
			}
		}
		StringBuilder orgCode = new StringBuilder();
		if(paramMap.get("organList") != null) {
			for(Organization entity : (List<Organization>)(paramMap.get("organList"))) {
				if(entity.getOrganCode() != null) {
					orgCode.append("'").append(entity.getOrganCode()).append("',");
				}
			}
			if(orgCode.length() > 0) {
				sb.append(" AND ORG_CODE IN(" + orgCode.substring(0, orgCode.length() - 1)  + ")");
			}
		}
		return this.getList(sb.toString());
		//SqlBuilder.buildWhereStatement(HaStatistics.class, sb, c);
	}

	@Override
	public List<HaStatistics> getAdminArchiveManagementList(
			Map<String, Object> paramMap) {
		StringBuilder sb = new StringBuilder();
//		Criteria cr = new Criteria();
//		cr.add("orgCode", String.valueOf(paramMap.get("orgCode")));
//		sb.append("SELECT ORGANIZATION.ORG_CODE FROM ORGANIZATION WHERE SUP_ORGAN_CODE = :orgCode");
//		List<Map<String, Object>> list = this.getMapList(sb.toString(), cr);//查询当前中心下所有服务站CODE
//		sb = new StringBuilder();
		sb.append("SELECT SUM(RP_STATISTICS.HR_ARCHIVE_NEW) AS HR_ARCHIVE_NEW,SUM(RP_STATISTICS.HR_ARCHIVE_TOTAL) AS HR_ARCHIVE_TOTAL,SUM(RP_STATISTICS.HR_ONE_STAR) AS HR_ONE_STAR,SUM(RP_STATISTICS.HR_TWO_STAR) AS HR_TWO_STAR,SUM(RP_STATISTICS.HRRP_STATISTICSAS HR_THREE_STAR,SUM(RP_STATISTICS.UNHR_ONE_STAR) AS UNHR_ONE_STAR,SUM(RP_STATISTICS.UNHR_TWO_STAR) AS UNHR_TWO_STAR,SUM(RP_STATISTICS.UNHR_THREE_STAR) AS UNHR_THREE_STAR,SUM(RP_STATISTICS.UNHR_ARCHIVE_NEW) AS UNHR_ARCHIVE_NEW,SUM(RP_STATISTICS.UNHR_ARCHIVE_TOTAL) AS UNHR_ARCHIVE_TOTAL ,SUM(RP_STATISTICS.HR_ARCHIVE_CANCEL) AS HR_ARCHIVE_CANCEL,SUM(RP_STATISTICS.HR_ARCHIVE_EMIGRATION) AS HR_ARCHIVE_EMIGRATION,SUM(RP_STATISTICS.UNHR_ARCHIVE_CANCEL) AS UNHR_ARCHIVE_CANCEL,SUM(RP_STATISTICS.UNHR_ARCHIVE_EMIGRATION) AS UNHR_ARCHIVE_EMIGRATION FROM RP_STATISTICS WHERE 1 = 1 ");
		if(String.valueOf(paramMap.get("statisticsDate")) != null) {
			switch (String.valueOf(paramMap.get("statisticsDate"))) {
			case "1":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE, 'YYYY-MM-DD') = TO_CHAR(CURRENT_DATE, 'YYYY-MM-DD')");
				break;
			case "2":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'MM') = " + ((Calendar.getInstance().get(Calendar.MONTH)) + 1));
				break;
			case "3":
				sb.append("AND TO_CHAR(RP_STATISTICS.STATISTICS_DATE,'YYYY') = " + (Calendar.getInstance().get(Calendar.YEAR)));
				break;
			default:
				break;
			}
		}
//		StringBuilder orgCode = new StringBuilder();
//		for(Map<String, Object> map : list) {
//			if(map.get("ORG_CODE").toString() != null) {
//				orgCode.append("'").append(map.get("ORG_CODE").toString()).append("',");
//			}
//			
//		}
//		if(orgCode.length() > 0) {
//			sb.append("AND ORG_CODE IN(" + orgCode.substring(0, orgCode.length() - 1)  + ")");
//		}
		sb.append("GROUP BY GBCODE");
		return this.getList(sb.toString());
	}

    @Override
    public List<String> getOrgCodes(){
    	String sql = "select distinct(ORG_CODE) organ_code from RP_STATISTICS";
    	
    	List<String> orgList = new ArrayList<String>();
    	
    	List<Map<String,Object>> mapList = this.getMapList(sql,new Criteria());
    	for(Map<String,Object> map :mapList){
    		String orgCode = map.get("organ_code").toString();
    		orgList.add(orgCode);
    	}
    	return orgList;
    }
}