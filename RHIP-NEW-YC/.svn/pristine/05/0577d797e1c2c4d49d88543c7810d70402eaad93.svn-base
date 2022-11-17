package com.founder.rhip.ehr.repository.ihm;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.founder.fasf.repository.DbContextHolder;
import com.founder.fasf.repository.internalDao;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.women.PremaritalHealthService;
import com.founder.rhip.ehr.entity.women.WomanDiseaseCensus;
import com.founder.rhip.mdm.entity.Organization;

/**
 * DAO implement of 计划生育
 * 
 */
@Repository("familyPlanningDao")
public class FamilyPlanningDaoImpl extends AbstractDao<PremaritalHealthService, Long> implements IFamilyPlanningDao {
	
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    //育龄妇女
    private final String childBearingList = "select b.* from(select * from WH_PREMARITAL_HEALTH_SERVICE a"+
										" where to_number(to_char(sysdate,'yyyy'))-"+
										" to_number(substr(a.ID_CARD,7,4)) between 15 and 49 and length(a.ID_CARD) = 18 and substr(a.ID_CARD,17,1) in (2,4,6,8,0)"+
										" union all"+
										" select * from WH_PREMARITAL_HEALTH_SERVICE a"+
										" where to_number(to_char(sysdate,'yyyy'))-"+
										" to_number('19'||substr(a.ID_CARD,7,2)) between 15 and 49 and length(a.ID_CARD) = 15 and substr(a.ID_CARD,15,1) in (2,4,6,8,0)) b";
    
    //妇女病普查
    private final String womenDiseaseList = "select * from WH_WOMAN_DISEASE_CENSUS";
    
    //婚检
    private final String premaritalHealthList = "select * from WH_PREMARITAL_HEALTH_SERVICE";
    
	@Override
	public PageList<Map<String, Object>> getChildBearingList(Page page,
			Criteria criteria) {
//		String whereSql = getWhereSql(criteria);
//		int rowCounts = simpleJdbcTemplate.queryForInt("select count(1) from ("+childBearingList+whereSql+")");
//		page.setTotalRows(rowCounts);
//		String sql = dialect.getLimitString(childBearingList+whereSql, page.getStartRow(), page.getPageSize());
//		List<Map<String, Object>> list = simpleJdbcTemplate.queryForList(sql);
		return this.getPageMapList(page, criteria, new Order("id", false));
	}

	@Override
	public PageList<Map<String, Object>> getWomenDiseaseList(Page page,
			Criteria criteria) {
//		String whereSql = getWhereSql(criteria);
//		int rowCounts = simpleJdbcTemplate.queryForInt("select count(1) from ("+womenDiseaseList+whereSql+")");
//		page.setTotalRows(rowCounts);
//		String sql = dialect.getLimitString(womenDiseaseList+whereSql, page.getStartRow(), page.getPageSize());
//		List<Map<String, Object>> list = simpleJdbcTemplate.queryForList(sql);
		return this.getPageMapList(page, criteria);
	}

	@Override
	public PageList<Map<String, Object>> getPremaritalHealthList(Page page,
			Criteria criteria) {
        String gender = (String)criteria.get("gender"); //1：男 2：女
        criteria.remove("gender");
        if(StringUtil.isNullOrEmpty(gender)) {
//            String whereSql = getWhereSql(criteria);
//            int rowCounts = simpleJdbcTemplate.queryForInt("select count(1) from (" + premaritalHealthList + whereSql + ")");
//            page.setTotalRows(rowCounts);
//            String sql = dialect.getLimitString(premaritalHealthList + whereSql, page.getStartRow(), page.getPageSize());
//            List<Map<String, Object>> list = simpleJdbcTemplate.queryForList(sql);

//            return new PageList<Map<String, Object>>(list, page);
            return getPageMapList(page, criteria, new Order("id", false));
        }else {//条件里有性别  根据身份证号来判断
            String genderValue = gender.equals("1")?"1":"0"; //1：男 0：女
            StringBuilder sql = new StringBuilder("SELECT *\n" +
                    "  FROM WH_PREMARITAL_HEALTH_SERVICE\n" +
                    " WHERE ((LENGTH(ID_CARD) = 18 AND MOD(SUBSTR(ID_CARD, 17, 1), 2) = "+genderValue+")\n" +
                    "    OR (LENGTH(ID_CARD) = 15 AND MOD(SUBSTR(ID_CARD, 15, 1), 2) = "+genderValue+")) ");
            if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
                sql.append(" AND ").append(criteria.toSql(ClassMetadata.getMetadata(PremaritalHealthService.class), ":")).toString();
            }
            sql.append(" ORDER BY ID DESC ");
            return this.getPageMapList(page, sql.toString(), criteria);
        }
	}
	
	private String getWhereSql(Criteria criteria){
		List<Criterion> criterias = criteria.getCriteria();
		String whereSql = "";
		if(!CollectionUtils.isEmpty(criterias)){
			whereSql = " where ";
			for(Criterion criterion : criterias){
				if(criterion.getOperation().equals(OP.LIKE)){
					whereSql += criterion.getName()+" like '%"+criterion.getValue()+"%' and ";
				}else if(criterion.getOperation().equals(OP.EQ)){
					whereSql += criterion.getName()+" = '"+criterion.getValue()+"' and ";
				}
				else if(criterion.getOperation().equals(OP.GE)){
		            Calendar calendar = Calendar.getInstance();
		            calendar.set(Integer.valueOf(criterion.getValue().toString()), 0, 1, 0, 0, 0);
		            Date beginDate = calendar.getTime();
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		            whereSql += criterion.getName()+" >= "+"to_date('"+sdf.format(beginDate)+"','yyyy-mm-dd hh24:mi:ss')"+" and ";
				}
				else if(criterion.getOperation().equals(OP.LE)){
					Calendar calendar = Calendar.getInstance();
		            calendar.set(Integer.valueOf(criterion.getValue().toString()), 11, 31, 23, 59, 59);
		            Date endDate = calendar.getTime();
		            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		            whereSql += criterion.getName()+" <= "+"to_date('"+sdf.format(endDate)+"','yyyy-mm-dd hh24:mi:ss')"+" and ";
				}
				else if(criterion.getOperation().equals(OP.IN)){
					whereSql += criterion.getName()+" in "+Convert2Str((List<Organization>)criterion.getValue(),"organCode")+" and ";
				}
			}
		}
		if(StringUtil.isNotEmpty(whereSql)) whereSql = whereSql.substring(0, whereSql.lastIndexOf("and"));
		return whereSql;
	}
	
	private <T> String Convert2Str(List<T> list, String fieldName){
		if(CollectionUtils.isEmpty(list)) return null;
		String str = "(";
		Method method;
		try {
			method = list.get(0).getClass().getDeclaredMethod("get"+fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
			for(int i = 0; i < list.size(); i++){
				str += "'"+method.invoke(list.get(i)) + "',";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		str = str.substring(0, str.lastIndexOf(","))+")";
		return str;
	}

	@Override
	public Object getChildBearing(String id) {
		DbContextHolder.setJdbcTemplate(simpleJdbcTemplate);
		return get(PremaritalHealthService.class, id);
	}

	@Override
	public Object getWomenDisease(String id) {
		DbContextHolder.setJdbcTemplate(simpleJdbcTemplate);
		return get(WomanDiseaseCensus.class, id);
	}

	@Override
	public Object getPremaritalHealth(String id) {
		DbContextHolder.setJdbcTemplate(simpleJdbcTemplate);
		return get(PremaritalHealthService.class, id);
	}
	
}