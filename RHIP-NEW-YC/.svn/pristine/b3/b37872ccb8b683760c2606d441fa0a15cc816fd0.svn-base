package com.founder.rhip.ehr.repository.healtheducation;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.healtheducation.HeActive;
import com.founder.rhip.mdm.common.OrgGenreCode;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * DAO implement of HealthEducationActive
 * 
 */
@Repository("heActiveDao")
public class HeActiveDaoImpl extends AbstractDao<HeActive, Long> implements IHeActiveDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 培训
     */
    private static final String HEALTH_EDUCATION_SQL = " SELECT %1$s"
    		+ " ,SUM(EDUCATION_PERSON_QUANTITY) EDUCATION_PERSON_QUANTITY"
    		+ " ,COUNT(1) EDUCATION_QUANTITY FROM HE_ACTIVE"
      		+ " WHERE (ACTIVE_TIME>=TO_DATE('%2$s','yyyy/MM/dd') AND ACTIVE_TIME <= TO_DATE('%3$s','yyyy/MM/dd')) "
    		+ " AND ACTIVE_TYPE = '3' AND STATUS = '1'"//活动类型为健康教育
      		+ " %4$s"
    		+ " GROUP BY %1$s";
    @Override
    public PageList<HeActive> getHealthEducationActiveList(Criteria criteria,Page page,Order order){
        Object educationPersonType=criteria.get("educationPersonType");
        //修正因为逗号分割造成的检索错误问题
        //liuk 2014年4月2日 15:13:17
        //修改方式:
        //将原字段两头加入逗号 eg ,1,2,11,
        //参数两头加入逗号 eg ,1,
        //防止1匹配到1或者11的问题
        if(ObjectUtil.isNotEmpty(educationPersonType)){
            criteria.remove("educationPersonType");
            educationPersonType=educationPersonType.toString().replaceAll("\\s*|\t|\r|\n","");//安全考虑,简单过滤sql
            String haveEducationPersonTypeConditon=" INSTR(','||EDUCATION_PERSON_TYPE||',' ,',"+educationPersonType+",')>0 ";
            StringBuilder sql=new StringBuilder("SELECT * FROM HE_ACTIVE ");
            if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
               SqlBuilder.buildWhereStatement(HeActive.class,sql,criteria);
                sql.append(" AND ").append(haveEducationPersonTypeConditon);
            }else{
                sql.append(" WHERE ").append(haveEducationPersonTypeConditon);
            }
            if (null!=order){
                sql.append(" ").append(order.toString());
            }
            return  getPageList(page,sql.toString(),criteria);
        }else{
            return getPageList(page,criteria,order);
        }
    }


	@Override
	public Map<String, Object> getStatistics(String gbCode, String parentCode, String organCode, OrgGenreCode genreCode, String startDate, String endDate) {
		Map<String,Object> result = null;
		if("B1".equals(genreCode.getValue())){
			result = getCenterStatistics(gbCode,parentCode,startDate,endDate);
		}else if("B2".equals(genreCode.getValue())){
			result = getStationStatistics(gbCode,parentCode,organCode,startDate,endDate);
		}
		return result;
	}
    
	/**
	 * 统计中心数据
	 *
	 * @param gbCode
	 * @param parentCode
	 * @param startDate
	 * @param endDate
	 * @return
	 * @author Ye jianfei
	 */
    private Map<String, Object> getCenterStatistics(String gbCode, String parentCode,String startDate, String endDate){
    	/**
    	 * 参数说明:
    	 * %1$s:机构,GBCODE,CENTER_ORG_CODE
    	 * %2$s:开始时间
    	 * %3$s:结束时间
    	 */
    	Map<String,Object> result = null;
		StringBuilder sbSql = new StringBuilder(HEALTH_EDUCATION_SQL);
		String orgWhere = getOrgWhere(gbCode, parentCode,"");
		String sql = String.format(sbSql.toString(),"GBCODE,CENTER_ORG_CODE",startDate,endDate,orgWhere);
		List<Map<String, Object>> results = this.getMapList(sql, new Criteria());
		if(ObjectUtil.isNotEmpty(results)){
			result = results.get(0);
		}
    	return result;
    }

    /**
     * 统计站数据
     *
     * @param gbCode
     * @param parentCode
     * @param organCode
     * @param startDate
     * @param endDate
     * @return
     * @author Ye jianfei
     */
    private Map<String, Object> getStationStatistics(String gbCode, String parentCode,String organCode,String startDate, String endDate){
    	/**
    	 * 参数说明:
    	 * %1$s:机构,GBCODE,CENTER_ORG_CODE,ORG_CODE
    	 * %2$s:开始时间
    	 * %3$s:结束时间
    	 */
    	Map<String,Object> result = null;
		StringBuilder sbSql = new StringBuilder(HEALTH_EDUCATION_SQL);
		String orgWhere = getOrgWhere(gbCode, parentCode,organCode);
		String sql = String.format(sbSql.toString(),"GBCODE,CENTER_ORG_CODE,ORG_CODE",startDate,endDate,orgWhere);
		List<Map<String, Object>> results = this.getMapList(sql, new Criteria());
		if(ObjectUtil.isNotEmpty(results)){
			result = results.get(0);
		}
    	return result;
    }
    
    private String getOrgWhere(String gbCode, String parentCode,String organCode){
    	String result = "";
    	StringBuilder sql = new StringBuilder();
    	if(StringUtil.isNotEmpty(gbCode)){
    		sql.append(" GBCODE = '" + gbCode + "'");
    	}
    	if(StringUtil.isNotEmpty(parentCode)){
    		if(StringUtil.isNotEmpty(sql.toString())){
    			sql.append(" AND ");
    		}
    		sql.append(" CENTER_ORG_CODE = '" + parentCode + "'");
    	}
    	if(StringUtil.isNotEmpty(organCode)){
    		if(StringUtil.isNotEmpty(sql.toString())){
    			sql.append(" AND ");
    		}    		
    		sql.append(" ORG_CODE = '" + organCode + "'");
    	}  
		if(StringUtil.isNotEmpty(sql.toString())){
			result = " AND " +  sql.toString();
		} 
    	return result;
    }
}
