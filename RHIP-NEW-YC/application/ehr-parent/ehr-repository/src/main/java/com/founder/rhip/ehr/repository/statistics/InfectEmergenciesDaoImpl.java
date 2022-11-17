package com.founder.rhip.ehr.repository.statistics;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.dto.InfectEmergencies;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IOrganizationDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanzg on 2017/5/8.
 */
@Repository("infectEmergenciesDao")
public class InfectEmergenciesDaoImpl extends AbstractDao<InfectEmergencies,Long> implements IInfectiousEmergenciesDao{
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Resource(name = "mdmOrganizationDao")
    private IOrganizationDao organizationDao;

    private static final String IE_CENSUS_SQL = "SELECT ORG_CODE, SUM(OCCUR_INFECTIOUS_NUM) OCCUR_INFECTIOUS_NUM, SUM(REPORT_INFECTIOUS_NUM) REPORT_INFECTIOUS_NUM," +
            " SUM(TIMELY_INFECTIOUS_NUM) TIMELY_INFECTIOUS_NUM, SUM(OCCUR_EMERGENCIES_NUM) OCCUR_EMERGENCIES_NUM," +
            " SUM(REPORT_EMERGENCIES_NUM) REPORT_EMERGENCIES_NUM, SUM(TIMELY_EMERGENCIES_NUM) TIMELY_EMERGENCIES_NUM," +
            " SUM(NET_REPORT_DEATHNUM) NET_REPORT_DEATHNUM, SUM(YEAR_OCCUR_INFECTIOUS_NUM) YEAR_OCCUR_INFECTIOUS_NUM," +
            " SUM(YEAR_REPORT_INFECTIOUS_NUM) YEAR_REPORT_INFECTIOUS_NUM, SUM(YEAR_TIMELY_INFECTIOUS_NUM) YEAR_TIMELY_INFECTIOUS_NUM," +
            " SUM(YEAR_OCCUR_EMERGENCIES_NUM) YEAR_OCCUR_EMERGENCIES_NUM, SUM(YEAR_REPORT_EMERGENCIES_NUM) YEAR_REPORT_EMERGENCIES_NUM," +
            " SUM(YEAR_TIMELY_EMERGENCIES_NUM) YEAR_TIMELY_EMERGENCIES_NUM, SUM(YEAR_NET_REPORT_DEATHNUM) YEAR_NET_REPORT_DEATHNUM, " +
            " SUM(REGISTER_INFECTIOUS_NUM) REGISTER_INFECTIOUS_NUM, SUM(NETWORK_INFECTIOUS_NUM) NETWORK_INFECTIOUS_NUM, " +
            " SUM(YEAR_REGISTER_INFECTIOUS_NUM) YEAR_REGISTER_INFECTIOUS_NUM, SUM(YEAR_NETWORK_INFECTIOUS_NUM) YEAR_NETWORK_INFECTIOUS_NUM " +
            " FROM SR_INFECT_EMERGENCIES WHERE 1=1 %s  GROUP BY ORG_CODE";
    
    //获取中心下所有站 以及本中心的数据
    public List<InfectEmergencies> getInfectEmerOrgList(String searchOrg,String countType,String parentOrgCode,int year,int quarter){
        Criteria criteria = new Criteria();
        criteria.add("parentCode",parentOrgCode);
        criteria.add("year",year);
        criteria.add("quarter",quarter);
        List<InfectEmergencies> infectEmergenciesList = new ArrayList<InfectEmergencies>();
        if(StringUtil.isNotEmpty(searchOrg)){
            if(searchOrg.equals(parentOrgCode)){
                infectEmergenciesList = getList(new Criteria("orgCode",searchOrg).add("year",year).add("quarter",quarter));
            }else {
                infectEmergenciesList = getList(criteria.add("orgCode",searchOrg));
            }
        }else if(StringUtil.isNullOrEmpty(searchOrg)){
             infectEmergenciesList = getList(criteria);
        }
        if(StringUtil.isNullOrEmpty(searchOrg)){
            List<Organization> organizationList = organizationDao.getList(new Criteria("parentCode",parentOrgCode));
            for (Organization organization : organizationList){
                if(ObjectUtil.isNullOrEmpty(get(new Criteria("orgCode",organization.getOrganCode())))){
                    InfectEmergencies infectEmergencies = new InfectEmergencies();
                    infectEmergencies.setOrgCode(organization.getOrganCode());
                    infectEmergencies.setOrgName(organization.getOrganName());
                    infectEmergenciesList.add(infectEmergencies);
                }
            }

            //添加中心
            InfectEmergencies emerZX = get(new Criteria("orgCode",parentOrgCode).add("year",year).add("quarter",quarter));
            Organization orgZX = organizationDao.get(new Criteria("organCode",parentOrgCode));
            if(ObjectUtil.isNullOrEmpty(emerZX)){
                InfectEmergencies infectEmergencies = new InfectEmergencies();
                infectEmergencies.setOrgCode(orgZX.getOrganCode());
                infectEmergencies.setOrgName(orgZX.getOrganName());
                infectEmergenciesList.add(infectEmergencies);
            }else{
                infectEmergenciesList.add(emerZX);
            }
        }else if(StringUtil.isNotEmpty(searchOrg)){
            if(ObjectUtil.isNullOrEmpty(infectEmergenciesList)){
                InfectEmergencies infectEmergencies = new InfectEmergencies();
                infectEmergencies.setOrgName(organizationDao.get(new Criteria("organCode",searchOrg)).getOrganName());
                infectEmergencies.setOrgCode(searchOrg);
                infectEmergenciesList.add(infectEmergencies);
            }
        }
        return infectEmergenciesList;
    }

    //计算中心下所有站的数据总和
    public Map<String,Object> getZXTotal(String parentOrgCode,int year,int quarter){
        Map<String,Object> map = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select SUM(OCCUR_INFECTIOUS_NUM) AllOcInfect, SUM(REPORT_INFECTIOUS_NUM) AllReInfect," +
                " SUM(TIMELY_INFECTIOUS_NUM) AllTimInfect, SUM(OCCUR_EMERGENCIES_NUM) AllOcEmer," +
                " SUM(REPORT_EMERGENCIES_NUM) AllReEmer, SUM(TIMELY_EMERGENCIES_NUM) AllTimEmer," +
                " SUM(NET_REPORT_DEATHNUM) AllNetRep, SUM(YEAR_OCCUR_INFECTIOUS_NUM) AllYearOcInfect," +
                " SUM(YEAR_REPORT_INFECTIOUS_NUM) AllYearReInfect, SUM(YEAR_TIMELY_INFECTIOUS_NUM) AllYearTimInfect," +
                " SUM(YEAR_OCCUR_EMERGENCIES_NUM) AllYearOcEmer, SUM(YEAR_REPORT_EMERGENCIES_NUM) AllYearReEmer," +
                " SUM(YEAR_TIMELY_EMERGENCIES_NUM) AllYearTimEmer, SUM(YEAR_NET_REPORT_DEATHNUM) AllYearNetRep, " +
                " SUM(REGISTER_INFECTIOUS_NUM) AllRegInfect, SUM(NETWORK_INFECTIOUS_NUM) AllNetInfect, " +
                " SUM(YEAR_REGISTER_INFECTIOUS_NUM) AllYearRegInfect, SUM(YEAR_NETWORK_INFECTIOUS_NUM) AllYearNetInfect " +
                " FROM SR_INFECT_EMERGENCIES where (PARENT_CODE ='"+parentOrgCode+"' and YEAR = "+year+" and QUARTER = "+quarter+") OR " +
                " (ORG_CODE ='"+parentOrgCode+"' and YEAR = "+year+" and QUARTER = "+quarter+")");
        map = getMap(sb.toString(), new Criteria());
        return map;
    }

    //计算所有中心和站的统计
    public Map<String,Object> countAll(int year,int quarter,String genreCode){
        Map<String,Object> map = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select SUM(OCCUR_INFECTIOUS_NUM) AllOcInfect, SUM(REPORT_INFECTIOUS_NUM) AllReInfect," +
                " SUM(TIMELY_INFECTIOUS_NUM) AllTimInfect, SUM(OCCUR_EMERGENCIES_NUM) AllOcEmer," +
                " SUM(REPORT_EMERGENCIES_NUM) AllReEmer, SUM(TIMELY_EMERGENCIES_NUM) AllTimEmer," +
                " SUM(NET_REPORT_DEATHNUM) AllNetRep, SUM(YEAR_OCCUR_INFECTIOUS_NUM) AllYearOcInfect," +
                " SUM(YEAR_REPORT_INFECTIOUS_NUM) AllYearReInfect, SUM(YEAR_TIMELY_INFECTIOUS_NUM) AllYearTimInfect," +
                " SUM(YEAR_OCCUR_EMERGENCIES_NUM) AllYearOcEmer, SUM(YEAR_REPORT_EMERGENCIES_NUM) AllYearReEmer," +
                " SUM(YEAR_TIMELY_EMERGENCIES_NUM) AllYearTimEmer, SUM(YEAR_NET_REPORT_DEATHNUM) AllYearNetRep," +
                " SUM(REGISTER_INFECTIOUS_NUM) AllRegInfect, SUM(NETWORK_INFECTIOUS_NUM) AllNetInfect, " +
                " SUM(YEAR_REGISTER_INFECTIOUS_NUM) AllYearRegInfect, SUM(YEAR_NETWORK_INFECTIOUS_NUM) AllYearNetInfect " +
                " FROM SR_INFECT_EMERGENCIES where YEAR = "+year+" and QUARTER = "+quarter+"");
        map = getMap(sb.toString(), new Criteria());
        return map;
    }

    //计算单个机构中的年度统计
    public Map<String,Object> countYearOrg(String orgCode,int year){
        Map<String,Object> map = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select SUM(OCCUR_INFECTIOUS_NUM) AllOcInfect, SUM(REPORT_INFECTIOUS_NUM) AllReInfect," +
                " SUM(TIMELY_INFECTIOUS_NUM) AllTimInfect, SUM(OCCUR_EMERGENCIES_NUM) AllOcEmer," +
                " SUM(REPORT_EMERGENCIES_NUM) AllReEmer, SUM(TIMELY_EMERGENCIES_NUM) AllTimEmer," +
                " SUM(REGISTER_INFECTIOUS_NUM) AllRegInfect, SUM(NETWORK_INFECTIOUS_NUM) AllNetInfect, " +
                " SUM(NET_REPORT_DEATHNUM) AllNetRep FROM SR_INFECT_EMERGENCIES where ORG_CODE ='"+orgCode+"' and YEAR="+year+"");
        map = getMap(sb.toString(), new Criteria());
        return map;
    }

    //统计卫管下的中心
    public Map<String,Object> countWGAllZX(int year,int quarter,String genreCode,String gbCode){
        Map<String,Object> map = null;
        StringBuilder sb = new StringBuilder();
        sb.append("select SUM(OCCUR_INFECTIOUS_NUM) AllOcInfect, SUM(REPORT_INFECTIOUS_NUM) AllReInfect," +
                " SUM(TIMELY_INFECTIOUS_NUM) AllTimInfect, SUM(OCCUR_EMERGENCIES_NUM) AllOcEmer," +
                " SUM(REPORT_EMERGENCIES_NUM) AllReEmer, SUM(TIMELY_EMERGENCIES_NUM) AllTimEmer," +
                " SUM(NET_REPORT_DEATHNUM) AllNetRep, SUM(YEAR_OCCUR_INFECTIOUS_NUM) AllYearOcInfect," +
                " SUM(YEAR_REPORT_INFECTIOUS_NUM) AllYearReInfect, SUM(YEAR_TIMELY_INFECTIOUS_NUM) AllYearTimInfect," +
                " SUM(YEAR_OCCUR_EMERGENCIES_NUM) AllYearOcEmer, SUM(YEAR_REPORT_EMERGENCIES_NUM) AllYearReEmer," +
                " SUM(YEAR_TIMELY_EMERGENCIES_NUM) AllYearTimEmer, SUM(YEAR_NET_REPORT_DEATHNUM) AllYearNetRep," +
                " SUM(REGISTER_INFECTIOUS_NUM) AllRegInfect, SUM(NETWORK_INFECTIOUS_NUM) AllNetInfect, " +
                " SUM(YEAR_REGISTER_INFECTIOUS_NUM) AllYearRegInfect, SUM(YEAR_NETWORK_INFECTIOUS_NUM) AllYearNetInfect " +
                " FROM SR_INFECT_EMERGENCIES where YEAR = "+year+" and QUARTER = "+quarter+"" +
                " and GB_CODE = '"+gbCode+"'");
        map = getMap(sb.toString(), new Criteria());
        return map;
    }

	@Override
	public List<InfectEmergencies> getInfectEmergenciesList(Criteria criteria, List<String> organCodeList) {
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		StringBuilder where = new StringBuilder();
		buildOrganCondition(criteria, where, sqlParameterSource, organCodeList);
		String finalSql = String.format(IE_CENSUS_SQL, where.toString());
		
		return getList(InfectEmergencies.class, finalSql, sqlParameterSource);
	
	}

	private void buildOrganCondition(Criteria criteria, StringBuilder where, MapSqlParameterSource sqlParameterSource, List<String> organCodeList) {
		String orgCode=(String)criteria.get("orgCode");
		String month=(String)criteria.get("month");
		String year=(String)criteria.get("year");
		
		if(ObjectUtil.isNotEmpty(orgCode) && organCodeList==null){
			where.append(" AND ").append(" ORG_CODE ").append(" =:createOrgCode");
			sqlParameterSource.addValue("createOrgCode", orgCode);
		}else{
			if(ObjectUtil.isNotEmpty(organCodeList)){
				where.append(" AND ").append(" ORG_CODE ").append(" in(:createOrgCode)");
				sqlParameterSource.addValue("createOrgCode", organCodeList);
			}
		}
		
		where.append(" AND ").append(" YEAR ").append(" =:year");
		sqlParameterSource.addValue("year", year);
		
		if(ObjectUtil.isNotEmpty(year)==true && ObjectUtil.isNotEmpty(month)==true){
			int quarter;
			if("1".equals(month)){
				quarter = 1;
			}else if("2".equals(month)){
				quarter = 2;
			}else if("3".equals(month)){
				quarter = 3;
			}else{
				quarter = 4;
			}
			where.append(" AND ").append(" QUARTER ").append(" =:quarter");
			sqlParameterSource.addValue("quarter", quarter);
		}
	}
}
