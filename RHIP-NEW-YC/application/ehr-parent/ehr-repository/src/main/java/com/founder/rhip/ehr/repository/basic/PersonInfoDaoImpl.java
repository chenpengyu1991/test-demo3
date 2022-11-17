package com.founder.rhip.ehr.repository.basic;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.RoleType;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonMoveInfo;
import com.founder.rhip.ehr.entity.basic.StatisticsByMonth;
import com.founder.rhip.ehr.entity.child.WomenChildHealth;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;

/**
 * DAO implement of PersonInfo
 *
 */
@Repository("personInfoDao" )
public class PersonInfoDaoImpl extends AbstractDao<PersonInfo, Long> implements IPersonInfoDao {
	Logger log = Logger.getLogger(getClass());
	
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
   
    private static final String FORMATER = "yyyy/mm/dd";
    
    @Override
    public PageList<PersonInfo> getUnRegFamilyPersonList(PersonInfo personInfo, List<Long> exceptIds, Page page,Criteria criteria) {
        StringBuilder sql = new StringBuilder(" select bpi.ID, bpi.SMPI_ID, bpi.HEALTH_FILE_NO, bpi.IDCARD,NAME, bpi.BIRTHDAY, bpi.NATION, bpi.GENDER, bpi.GBCODE from bi_person_info bpi where not EXISTS ");
        sql.append( " (select bfi.person_id from bi_family_person_relation bfi where bfi.person_id = bpi.id and family_Id not in(select id from BI_FAMILY_INFO where status=2))");
        for (Long id : exceptIds) {
            sql.append( " and bpi.id != ");
            sql.append(id);
        }
        if (StringUtils.isNotBlank(personInfo.getName())) {
            sql.append( " and bpi.name like ");
            sql.append( "'"+"%" +personInfo.getName()+"%"+ "'");
        }
        if (StringUtils.isNotBlank(personInfo.getIdcard())) {
            sql.append( " and bpi.idcard = ");
            sql.append( "'"+personInfo.getIdcard()+"'" );
        }
        if(ObjectUtil.isNotEmpty(criteria.get("bpi.INPUT_GBCODE"))){
        	sql.append( " and bpi.INPUT_GBCODE = ");
        	sql.append( "'"+criteria.get("bpi.INPUT_GBCODE")+"'" );
        }if (ObjectUtil.isNotEmpty(criteria.get("bpi.INPUT_CENTER_ORGAN_CODE"))) {
        	sql.append( " and bpi.INPUT_CENTER_ORGAN_CODE = ");
        	sql.append( "'"+criteria.get("bpi.INPUT_CENTER_ORGAN_CODE")+"'" );
		} else if (ObjectUtil.isNotEmpty(criteria.get("bpi.INPUT_ORGAN_CODE"))) {
			sql.append( " and bpi.INPUT_ORGAN_CODE = ");
        	sql.append( "'"+criteria.get("bpi.INPUT_ORGAN_CODE")+"'" );
		}
        
        sql.append( " and bpi.filing_flag != 9" );
        sql.append( " order by id desc");
        return this .getPageList(page, sql.toString(), criteria);
    }
   
       @Override
       public List<Map<String, Object>> getPersonCount(Criteria criteria) {
            StringBuilder sql = new StringBuilder(" SELECT CREATE_GBCODE AS ORGAN_CODE, COUNT(1) AS COUNT FROM BI_PERSON_INFO ");
            SqlBuilder.buildWhereStatement(StatisticsByMonth.class, sql, criteria);
            sql.append(" GROUP BY CREATE_GBCODE ");
            List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
            return maps;
      }
       
       @Override
       public List<Map<String, Object>> getPersonCountStation(Criteria criteria) {
            StringBuilder sql = new StringBuilder(" SELECT CREATE_ORGAN_CODE AS ORGAN_CODE, COUNT(1) AS COUNT FROM BI_PERSON_INFO ");
            SqlBuilder.buildWhereStatement(StatisticsByMonth.class, sql, criteria);
            sql.append(" GROUP BY CREATE_ORGAN_CODE ");
            List<Map<String, Object>> maps = this.getMapList(sql.toString(), criteria);
            return maps;
      }

       @Override
       public List<Map<String, Object>> getChangedCount(Criteria criteria) {
           String householdType = (String)criteria.get("householdType");
           StringBuilder sql = new StringBuilder("SELECT INPUT_ORG_CODE AS ORGAN_CODE, SUM(FCOUNT) AS COUNT\n" +
                   "  FROM (SELECT INPUT_ORG_CODE,\n" +
                   "               INPUT_USER_ID,\n" +
                   "               COUNT(DECODE(SIGN(PCOUNT), 1, 1, NULL)) AS FCOUNT\n" +
                   "          FROM (SELECT INPUT_ORG_CODE,\n" +
                   "                       INPUT_USER_ID,\n" +
                   "                       PERSON_ID,\n" +
                   "                       M.INPUT_DATE,\n" +
                   "                       COUNT(1) AS PCOUNT\n" +
                   "                  FROM BI_MODIFY_TRACE M, BI_PERSON_INFO P\n" +
                   "                 WHERE M.PERSON_ID = P.ID\n" +
                   "                   AND INPUT_USER_ID IS NOT NULL\n" +
                   "                   AND M.INPUT_DATE >= :inputDate\n" );
                   if(StringUtil.isNotEmpty(householdType)){
                       sql.append("AND P.HOUSEHOLD_TYPE = :householdType --户籍 1  非户籍 2\n");
                   }
                   sql.append("                 GROUP BY INPUT_ORG_CODE,\n" +
                   "                          INPUT_USER_ID,\n" +
                   "                          PERSON_ID,\n" +
                   "                          M.INPUT_DATE)\n" +
                   "         GROUP BY INPUT_ORG_CODE, INPUT_USER_ID)\n" +
                   " GROUP BY INPUT_ORG_CODE");
            List<Map<String, Object>> maps = this.getMapList(sql.toString(),criteria);
            return maps;
      }

    public List<Map<String, Object>> getChangedCountTown(Criteria criteria){
        String householdType = (String)criteria.get("householdType");
        StringBuilder sql = new StringBuilder("SELECT ORGAN_CODE, SUM(FCOUNT) AS COUNT\n" +
                "  FROM (SELECT O.GB_CODE AS ORGAN_CODE,\n" +
                "               COUNT(DECODE(SIGN(PCOUNT), 1, 1, NULL)) AS FCOUNT\n" +
                "          FROM (SELECT INPUT_ORG_CODE,\n" +
                "                       PERSON_ID,\n" +
                "                       M.INPUT_DATE,\n" +
                "                       COUNT(1) AS PCOUNT\n" +
                "                  FROM BI_MODIFY_TRACE M, bi_person_info P\n" +
                "                 WHERE M.PERSON_ID = P.ID(+)\n" +
                "                   AND INPUT_USER_ID IS NOT NULL\n" +
                "                   AND M.INPUT_DATE >= :inputDate\n" );
                if(StringUtil.isNotEmpty(householdType)){
                    sql.append("AND P.HOUSEHOLD_TYPE = :householdType --户籍 1  非户籍 2\n");
                }
                sql.append("                 GROUP BY INPUT_ORG_CODE, PERSON_ID, M.INPUT_DATE) MT,\n" +
                "               MDM_ORGANIZATION O\n" +
                "         WHERE O.GENRE_CODE = 'B200' --站\n" +
                "           AND MT.INPUT_ORG_CODE = O.ORGAN_CODE(+)\n" +
                "         GROUP BY O.GB_CODE)\n" +
                " GROUP BY ORGAN_CODE");
        List<Map<String, Object>> maps = this.getMapList(sql.toString(),criteria);
        return maps;
    }
       
       @Override
       public List<Map<String, Object>> getChangedCountNoType(Criteria criteria) {
            StringBuilder sql = new StringBuilder("SELECT t1.INPUT_GBCODE AS ORGAN_CODE,COUNT (t2.PERSON_ID) AS COUNT " +
   				 "FROM BI_PERSON_INFO t1 " +
   				 "LEFT JOIN ( " +
   				 "	SELECT DISTINCT " +
   				 "		PERSON_ID " +
   				 "	FROM " +
   				 "		EHR_HEALTH_EVENT " +
   				 "	WHERE " +
   				 "		CLINIC_DATE >= :clinicDate " +
   				 "	OR UPDATE_DATE >= :clinicDate " +
   				 ") t2 ON t1.ID = t2.PERSON_ID " +
   				 "WHERE " +
   				 "	T1.FILING_FLAG <> 0 " +
   				 " GROUP BY t1.INPUT_GBCODE ");
            List<Map<String, Object>> maps = this.getMapList(sql.toString(),criteria);
            return maps;
      }
       
       @Override
       public List<Map<String, Object>> getChangedCountStationNoType(Criteria criteria) {
            StringBuilder sql = new StringBuilder("SELECT t1.INPUT_ORGAN_CODE AS ORGAN_CODE,COUNT (t2.PERSON_ID) AS COUNT " +
   				 "FROM BI_PERSON_INFO t1 " +
   				 "LEFT JOIN ( " +
   				 "	SELECT DISTINCT " +
   				 "		PERSON_ID " +
   				 "	FROM " +
   				 "		EHR_HEALTH_EVENT " +
   				 "	WHERE " +
   				 "		CLINIC_DATE >= :clinicDate " +
   				 "	OR UPDATE_DATE >= :clinicDate " +
   				 ") t2 ON t1.ID = t2.PERSON_ID " +
   				 "WHERE " +
   				 "	T1.FILING_FLAG <> 0 " +
   				 " GROUP BY t1.INPUT_ORGAN_CODE ");
            List<Map<String, Object>> maps = this.getMapList(sql.toString(),criteria);
            return maps;
      }
       
       @Override
       public List<Map<String, Object>> getChangedCountStation(Criteria criteria) {
            StringBuilder sql = new StringBuilder("SELECT t1.INPUT_ORGAN_CODE AS ORGAN_CODE,COUNT (t2.PERSON_ID) AS COUNT " +
   				 "FROM BI_PERSON_INFO t1 " +
   				 "LEFT JOIN ( " +
   				 "	SELECT DISTINCT " +
   				 "		PERSON_ID " +
   				 "	FROM " +
   				 "		EHR_HEALTH_EVENT " +
   				 "	WHERE " +
   				 "		CLINIC_DATE >= :clinicDate " +
   				 "	OR UPDATE_DATE >= :clinicDate " +
   				 ") t2 ON t1.ID = t2.PERSON_ID " +
   				 "WHERE " +
   				 "	T1.FILING_FLAG <> 0 " +
   				 "AND t1.HOUSEHOLD_TYPE = :householdType GROUP BY t1.INPUT_ORGAN_CODE ");
            List<Map<String, Object>> maps = this.getMapList(sql.toString(),criteria);
            return maps;
      }
       
       @Override
       public List<String> getOrgCodes(){
       	String sql = "select distinct(INPUT_ORGAN_CODE) organ_code from BI_PERSON_INFO";
       	
       	List<String> orgList = new ArrayList<String>();
       	
       	List<Map<String,Object>> mapList = this.getMapList(sql,new Criteria());
       	for(Map<String,Object> map :mapList){
       		String orgCode = "";
       		Object o = map.get("organ_code");
       		if(o != null){
       			orgCode = map.get("organ_code").toString();
       		}
       		orgList.add(orgCode);
       	}
       	return orgList;
       }

       
       @Override
       public List<Map<String,Object>> getStatisticsListByTown(){
    	   String sql = "select create_gbcode input_gbcode, count(*) coutNum from BI_PERSON_INFO t where t.filing_flag = 1 group by t.create_gbcode";
    	   List<Map<String,Object>> maps  = this.getMapList(sql, new Criteria());
    	   return maps;
       }

	@Override
	public List<Map<String,Object>> getStatisticsListByCenter(String centerCode){
		StringBuilder sql = new StringBuilder("select input_organ_code, count(*) coutNum from BI_PERSON_INFO t ");
		sql.append(" where t.filing_flag in ('1','2','3')  and (t.input_center_organ_code = '" + centerCode + "'");
		sql.append(" or t.input_organ_code = '" + centerCode + "')");
		sql.append("group by t.input_organ_code");
		List<Map<String,Object>> maps  = this.getMapList(sql.toString(), new Criteria());
		return maps;
	}
       
       /**
        * 迁出统计
        */
       @Override
       public List<Map<String, Object>> getCanceledInfoCount(Criteria criteria){
    	   Object parentCode = criteria.get("CREATE_CENTER_ORGAN_CODE");
    	   Object organCode = criteria.get("CREATE_ORGAN_CODE");
    	   criteria.remove("CREATE_CENTER_ORGAN_CODE");
    	   criteria.remove("CREATE_ORGAN_CODE");
     	   StringBuilder sql = new StringBuilder("SELECT HOUSEHOLD_TYPE,COUNT(RECORD.ID) pCount");
    	   sql.append(" FROM BI_ARCHIVES_MOVE_RECORD RECORD");
    	   sql.append(" LEFT JOIN BI_PERSON_INFO PERSON ON PERSON.ID = RECORD.PERSON_ID");
    	   SqlBuilder.buildWhereStatement(PersonMoveInfo.class, sql, criteria);
    	   if(ObjectUtil.isNotEmpty(parentCode) || ObjectUtil.isNotEmpty(organCode)){
	    	   sql.append(" AND OLD_STATION_CODE IN(SELECT ORGAN_CODE FROM MDM_ORGANIZATION");
	    	   sql.append(" WHERE GENRE_CODE in ('B200','B100') ");
	    	   if(ObjectUtil.isNotEmpty(parentCode)){
	    		   sql.append(" AND (PARENT_CODE ='" + parentCode.toString() + "' OR ORGAN_CODE ='"+parentCode.toString()+"') ");
	    	   }
	    	   if(ObjectUtil.isNotEmpty(organCode)){
	    		   sql.append(" AND ORGAN_CODE ='" + organCode.toString() + "'");
	    	   }    	   
	    	   sql.append(" )");
    	   }
    	   sql.append(" group by HOUSEHOLD_TYPE order by HOUSEHOLD_TYPE ");
    	   List<Map<String,Object>> mapList = this.getMapList(sql.toString(), criteria);
    	   return mapList;    	   
       }
       
       @Override
       public List<Map<String,Object>> getStarCount(Criteria criteria){
     	   StringBuilder sql = new StringBuilder("SELECT HOUSEHOLD_TYPE,STAR,COUNT(ID) pCount");
    	   sql.append(" FROM BI_PERSON_INFO ");
    	   SqlBuilder.buildWhereStatement(PersonInfo.class, sql, criteria);
    	   sql.append(" group by HOUSEHOLD_TYPE ,STAR order by HOUSEHOLD_TYPE,STAR ");
    	   List<Map<String,Object>> mapList = this.getMapList(sql.toString(), criteria);
    	   return mapList;
       }
       
       @Override
       public List<Map<String,Object>> getTypeCount(Criteria criteria){
    	   StringBuilder sql = new StringBuilder("SELECT HOUSEHOLD_TYPE,COUNT(ID) pCount");
    	   sql.append(" FROM BI_PERSON_INFO ");
    	   SqlBuilder.buildWhereStatement(PersonInfo.class, sql, criteria);
    	   sql.append(" group by HOUSEHOLD_TYPE order by HOUSEHOLD_TYPE ");
    	   List<Map<String,Object>> mapList = this.getMapList(sql.toString(), criteria);
    	   return mapList;
       }
       
       @Override
       public Long getActiveCount(Criteria criteria,Date startDate,Date endDate){
    	   StringBuilder sql = new StringBuilder("SELECT COUNT( DISTINCT BPF.ID )");
    	   sql.append(" FROM BI_PERSON_INFO BPF INNER JOIN (");
    	   
    	   StringBuilder eSql = new StringBuilder("SELECT DISTINCT(PERSON_ID) FROM EHR_HEALTH_EVENT  ").append(getDateString("CLINIC_DATE",startDate,endDate));
    	   StringBuilder kSql = new StringBuilder("SELECT DISTINCT(PERSON_ID) FROM EHR_HEALTH_EVENT  ").append(getDateString("UPDATE_DATE",startDate,endDate));
    	   StringBuilder mSql = new StringBuilder("SELECT DISTINCT(PERSON_ID) FROM BI_MODIFY_TRACE  ").append(getDateString("INPUT_DATE",startDate,endDate));
    	   sql.append(eSql).append(" union ").append(kSql);
    	   sql.append(" union ").append(mSql + " ) EHE");
      	   sql.append(" ON  BPF.ID = EHE.PERSON_ID ");
      	  
    	   SqlBuilder.buildWhereStatement(PersonInfo.class, sql, criteria);
    	   Long count = this.getSingle(sql.toString(), criteria, Long.class);
    	   return count;
       }
       
       private String getDateString(String colume,Date startDate,Date endDate){
    	   if(ObjectUtil.isNullOrEmpty(startDate) && ObjectUtil.isNullOrEmpty(endDate) ){
    		   return "";
    	   }
    	   StringBuilder eSql = new StringBuilder(" WHERE ");
    	   if(ObjectUtil.isNotEmpty(startDate)){
    		   eSql.append(colume + " >= " + toDateString(startDate));
    		   if(ObjectUtil.isNotEmpty(endDate)){
    			   endDate = DateUtil.makeTimeToMax(endDate);
    			   eSql.append(" AND " + colume + " <= " + toDateString(endDate));
    		   }
    	   }else{
    		   if(ObjectUtil.isNotEmpty(endDate)){
    			   endDate = DateUtil.makeTimeToMax(endDate);
    			   eSql.append(colume + " <=  " + toDateString(endDate));
    		   }
    	   }
    	   return eSql.toString();
       }
       
       private String toDateString(Date date){
    	   String dateString = DateUtil.getDateTime("yyyy/MM/dd HH:mm:ss", date);
    	   String str1 = "to_date('" + dateString + "','yyyy/MM/dd hh24:mi:ss')";
    	   return str1;
       }

	@Override
	public List<Map<String, Object>> getMapList() {
		List<Map<String, Object>> listMap = getMapList("SELECT MIN(T.ID) minId,MAX(T.ID) maxId,MIN(SMPI_ID) minSMId, max(SMPI_ID) maxSMId,T.IDCARD idCard,COUNT(1) FROM BI_PERSON_INFO T GROUP BY T.IDCARD HAVING COUNT(1) =2", (Criteria) null);
		return listMap;
	}


//    /**
//     * 个人绩效（建档量统计）
//     * @param paramMap
//     * @param page
//     * @return
//     */
//    public PageList<Map<String, Object>> getHRPerformance(Map<String, String> paramMap, Page page){
//        String genreCode = paramMap.get("genreCode");
//        String organCode = paramMap.get("organCode");
//        String beginDate = paramMap.get("beginDate");
//        String endDate = paramMap.get("endDate");
//        StringBuilder sql = new StringBuilder();
//        sql = new StringBuilder("WITH PR AS  \n" +
//                " (SELECT INPUT_NAME, COUNT(1) AS PCOUNT  \n" +
//                "    FROM BI_PERSON_INFO  \n" +
//                "   WHERE FILING_FLAG <> 0  \n" +
//                "     AND INPUT_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND  \n" +
//                "         TO_DATE('"+endDate+"', 'YYYY/MM/DD')  \n");
////                "  AND INPUT_ORGAN_CODE = '"+organCode+"'  \n" +
//        if("0".equals(genreCode)){//"0" 按镇查询
//            sql.append(" AND GBCODE = '"+organCode+"'  \n ");
//        }else {
//            sql.append(" AND INPUT_ORGAN_CODE = '"+organCode+"'  \n ");
//        }
//        sql.append("   GROUP BY INPUT_NAME),  \n" +
//                "FR AS \n" +
//                " (SELECT INPUT_NAME, COUNT(1) AS FCOUNT \n" +
//                "    FROM BI_FAMILY_INFO \n" +
//                "   WHERE INPUT_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND \n" +
//                "         TO_DATE('"+endDate+"', 'YYYY/MM/DD') \n");
////                "   AND INPUT_ORGAN_CODE = '"+organCode+"' \n" +
//        if("0".equals(genreCode)){//"0" 按镇查询
//            sql.append(" AND GBCODE = '"+organCode+"'  \n ");
//        }else {
//            sql.append(" AND INPUT_ORGAN_CODE = '"+organCode+"'  \n ");
//        }
//        sql.append("   GROUP BY INPUT_NAME), \n" +
//                "DO AS \n" +
//                " (SELECT PR.INPUT_NAME FROM PR UNION SELECT FR.INPUT_NAME FROM FR) \n" +
//                "SELECT DO.INPUT_NAME, PR.PCOUNT, FR.FCOUNT \n" +
//                "  FROM DO, PR, FR \n" +
//                " WHERE DO.INPUT_NAME = PR.INPUT_NAME(+) \n" +
//                "   AND DO.INPUT_NAME = FR.INPUT_NAME(+) \n");
//
//        PageList<Map<String, Object>> result = getPageMapList(page, sql.toString(), new Criteria());
//        return result;
//    }
    
    
    /**
     * 个人绩效（建档量统计）
     * @param paramMap
     * @param page
     * @return
     */
    public PageList<Map<String, Object>> getHRPerformance(Map<String, String> paramMap, Page page){
        String genreCode = paramMap.get("genreCode");
        String organCode = paramMap.get("organCode");
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
        StringBuilder sql = new StringBuilder();
        /**
         * PCOUNT:建档数
         * THREECOUNT:三星档案数
         * FCOUNT:档案更新数
         */
        sql = new StringBuilder("WITH PR AS  \n" +
                " (SELECT INPUTER_ID, COUNT(1) AS PCOUNT  \n" +
                " ,COUNT(CASE WHEN FILING_FLAG = '1' AND STAR = 3 THEN 1 ELSE NULL END) THREECOUNT \n" +
                "    FROM BI_PERSON_INFO  \n" +
                "   WHERE INPUTER_ID IS NOT NULL AND FILING_FLAG <> 0  \n" +
                "     AND INPUT_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND  \n" +
                "         TO_DATE('"+endDate+"', 'YYYY/MM/DD')  \n");
//                "  AND INPUT_ORGAN_CODE = '"+organCode+"'  \n" +
        if("0".equals(genreCode)){//"0" 按镇查询
            sql.append(" AND CREATE_GBCODE = '"+organCode+"'  \n ");
        }else if(OrgGenreCode.CENTRE.getValue().equals(genreCode)){
        	sql.append(" AND CREATE_CENTER_ORGAN_CODE = '"+organCode+"'  \n ");
        }else {
            sql.append(" AND CREATE_ORGAN_CODE = '"+organCode+"'  \n ");
        }
        //同一份档案根据日期判断,多个字段的痕迹算作一次修改
        sql.append("   GROUP BY INPUTER_ID),  \n" +
                "FR AS \n" +
                " (SELECT INPUT_USER_ID, COUNT(DECODE(SIGN(PCOUNT),1,1,NULL)) AS FCOUNT \n" +
                "    FROM \n" +
                " (SELECT INPUT_USER_ID,PERSON_ID,INPUT_DATE,COUNT(1) AS PCOUNT FROM BI_MODIFY_TRACE" +
                "   WHERE INPUT_USER_ID IS NOT NULL AND  INPUT_DATE BETWEEN TO_DATE('"+beginDate+"', 'YYYY/MM/DD') AND \n" +
                "         TO_DATE('"+endDate+"', 'YYYY/MM/DD') \n");
//                "   AND INPUT_ORGAN_CODE = '"+organCode+"' \n" +
        if("0".equals(genreCode)){//"0" 按镇查询
            sql.append(" AND INPUT_ORG_CODE IN("+getGbCodeWhere(organCode)+")  \n ");
        }else if(OrgGenreCode.CENTRE.getValue().equals(genreCode)){
        	sql.append(" AND INPUT_ORG_CODE IN("+getCenterCodeWhere(organCode)+")  \n ");
        }else {
            sql.append(" AND INPUT_ORG_CODE = '"+organCode+"'  \n ");
        }
        sql.append(" GROUP BY INPUT_USER_ID,PERSON_ID,INPUT_DATE)");
        sql.append("   GROUP BY INPUT_USER_ID), \n" +
                "DO AS \n" +
                " (SELECT PR.INPUTER_ID FROM PR UNION SELECT FR.INPUT_USER_ID INPUTER_ID FROM FR) \n" +
                "SELECT DO.INPUTER_ID, PR.PCOUNT, FR.FCOUNT,PR.THREECOUNT \n" +
                "  FROM DO, PR, FR \n" +
                " WHERE DO.INPUTER_ID = PR.INPUTER_ID(+) \n" +
                "   AND DO.INPUTER_ID = FR.INPUT_USER_ID(+) \n");

        PageList<Map<String, Object>> result = getPageMapList(page, sql.toString(), new Criteria());
        return result;
    }    
 
    private static final String select_gb_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE";
    private static final String select_parent_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";
    private static final String select_organ_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";
    
    private static final String ORG_SQL="WITH mdmOrg AS("
    		+ " SELECT GB_CODE,PARENT_CODE,ORGAN_CODE,GENRE_CODE"
    		+ " FROM MDM_ORGANIZATION"
    		+ " %1$s )";//机构条件
    
    /**
     * 机构绩效-建档数,三星建档数
     */
    private static final String ORG_PERFORMANCE_PERSON = ",PR AS( \n"
    		+ "	SELECT INPUT_ORGAN_CODE INPUT_ORGAN_CODE, COUNT(1) AS PCOUNT \n"//建档数
    		+ "		,COUNT(CASE WHEN FILING_FLAG = '1' AND STAR = 3 THEN 1 ELSE NULL END) THREECOUNT \n"//三星建档数
    		+ "	FROM BI_PERSON_INFO  \n"
    		+ "	WHERE CREATE_ID IS NOT NULL AND FILING_FLAG <> 0  \n"
    		+ "		AND INPUT_DATE BETWEEN TO_DATE('%2$s', 'YYYY/MM/DD') \n"
    		+ "		AND TO_DATE('%3$s', 'YYYY/MM/DD')  \n  \n"
    		+ "		%4$s  \n"//机构条件
    		+ "		GROUP BY INPUT_ORGAN_CODE  \n"//按机构分组
    		+ ")";

    /**
     * 机构绩效-建档档案更新数
     */
    private static final String ORG_PERFORMANCE_MODIFY_TRACE = ",FR AS( \n"
    		+ "	SELECT INPUT_ORG_CODE, SUM(FCOUNT) AS FCOUNT \n"//档案更新数
    		+ "	FROM(\n"
    		+ "		SELECT INPUT_ORG_CODE,INPUT_USER_ID, COUNT(DECODE(SIGN(PCOUNT),1,1,NULL)) AS FCOUNT "
    		+ "		FROM(\n"
    		+ "			SELECT INPUT_ORG_CODE,INPUT_USER_ID,PERSON_ID,INPUT_DATE,COUNT(1) AS PCOUNT FROM BI_MODIFY_TRACE	\n"
    		+ "			WHERE INPUT_USER_ID IS NOT NULL AND  INPUT_DATE BETWEEN TO_DATE('%2$s', 'YYYY/MM/DD') \n"
    		+ "				AND TO_DATE('%3$s', 'YYYY/MM/DD')  \n  \n"
    		+ "				%5$s  \n"//机构条件
    		+ "			GROUP BY INPUT_ORG_CODE,INPUT_USER_ID,PERSON_ID,INPUT_DATE)\n"//按机构分组
    		+ "		GROUP BY INPUT_ORG_CODE,INPUT_USER_ID)"
    		+ "	GROUP BY INPUT_ORG_CODE)";
 
    /**
     * 机构绩效-建档数,三星建档数,建档档案更新数,把前两个SQL合并
     */
    private static final String ORG_PERFORMANCE_MERGE = ",DO AS ( \n"
    		+ "	SELECT PR.INPUT_ORGAN_CODE INPUT_ORG_CODE FROM PR UNION SELECT FR.INPUT_ORG_CODE FROM FR)\n"
    		+ "	,PERFORMANCE AS (SELECT DO.INPUT_ORG_CODE, PR.PCOUNT, FR.FCOUNT,PR.THREECOUNT \n"
    		+ "	FROM DO, PR, FR \n"
    		+ "	WHERE DO.INPUT_ORG_CODE = PR.INPUT_ORGAN_CODE(+) \n"
    		+ "	AND DO.INPUT_ORG_CODE = FR.INPUT_ORG_CODE(+)) \n";
    

    /**
     * 机构绩效-建档数,三星建档数,建档档案更新数
     */
    private static final String ORG_PERFORMANCE = "SELECT ORG_PERFORMANCE.* FROM(\n"
    		+ "	SELECT %6$s\n"
    		+ "		,SUM(PERFORMANCE.PCOUNT) PCOUNT \n"
    		+ "		,SUM(PERFORMANCE.FCOUNT) FCOUNT \n"
    		+ "		,SUM(PERFORMANCE.THREECOUNT) THREECOUNT \n"
    		+ "	FROM mdmOrg ORG \n"
    		+ " LEFT JOIN PERFORMANCE ON ORG.ORGAN_CODE = PERFORMANCE.INPUT_ORG_CODE"
    		+ "	GROUP BY %7$s) ORG_PERFORMANCE";
    
    
    private String getOrgField(String genreCode,boolean isSelect){
    	String result = "";
    	switch(genreCode){
    		case "0":
    			result = isSelect?select_gb_code:"ROLLUP(GB_CODE)";
    			break;
    		case "B100":
    			result = isSelect?select_parent_code:"ROLLUP(GB_CODE,ORG.organ_code),parent_Code";
    			break;
    		case "B200":
    			result = isSelect?select_organ_code:"ROLLUP(GB_CODE,parent_Code,ORG.organ_Code)";
    			break;
    		case "A100":
    			result = isSelect?select_organ_code:"ROLLUP(GB_CODE,ORG.organ_code),parent_Code";
    			break;

    	}
    	return result;
    }
    /**
     * 机构绩效（建档量统计）
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> getHRPerformance(Map<String, String> paramMap){
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String parentCode = paramMap.get("parentCode");
        String organCode = paramMap.get("organCode");    	
    	Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getHRPerformanceSql(paramMap);
		return this.getMapList(sql,ca);
    }    
    
    
    private String getHRPerformanceSql(Map<String, String> paramMap){
        String genreCode = paramMap.get("genreCode");
        String gbCode = paramMap.get("gbCode");
        String parentCode = paramMap.get("parentCode");
        String organCode = paramMap.get("organCode");
        String beginDate = paramMap.get("beginDate");
        String endDate = paramMap.get("endDate");
    	StringBuilder sql = new StringBuilder(ORG_SQL + ORG_PERFORMANCE_PERSON + ORG_PERFORMANCE_MODIFY_TRACE
    											+ ORG_PERFORMANCE_MERGE + ORG_PERFORMANCE  );
    	//机构条件
    	StringBuilder orgWhere =  new StringBuilder();
    	//机构字段
    	String orgField = getOrgField(genreCode,false);
    	//SELECT字段
    	String orgSelectField = getOrgField(genreCode,true);
    	Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
    	SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
    	//1:MDM_ORGANIZATION表机构条件
    	//2:开始时间
    	//3:结束时间
    	//4:BI_PERSON_INFO表,MODIFY_TRACE表机构条件
    	//5:SELECT中的机构字段
    	//6:GROUP BY中的机构字段
    	String personOrg = getOrgWhere(gbCode,parentCode,organCode,"1");
    	String modifyOrg = getOrgWhere(gbCode,parentCode,organCode,"2");
    	return String.format(sql.toString(),orgWhere,beginDate,endDate,personOrg,modifyOrg,orgSelectField,orgField);
    }
    
    private String getOrgWhere(String gbCode,String parentCode,String organCode,String type){
    	String result = "";
    	String orgFieldName = ("1".equals(type)?"INPUT_ORGAN_CODE":"INPUT_ORG_CODE");
    	if(StringUtil.isNotEmpty(organCode)){//站
    		result = " AND " + orgFieldName + " = '" + organCode + "'  \n ";
    	}else if(StringUtil.isNotEmpty(parentCode)){//中心
    		result = " AND " + orgFieldName + " IN("+getCenterCodeWhere(organCode)+")  \n ";
    	}else if(StringUtil.isNotEmpty(gbCode)){//镇
    		result = " AND " + orgFieldName + " IN("+getGbCodeWhere(gbCode)+")  \n ";
    	}
    	return result;
    }
    private Criteria getOrgCriteria(String genreCode,String gbCode,String parentCode,String organCode){
    	Criteria ca = new Criteria();
    	if(StringUtil.isNotEmpty(genreCode) && (!"0".equals(genreCode))){
    		ca.add("genre_Code",genreCode);
    	}
    	if(StringUtil.isNotEmpty(gbCode)){
    		ca.add("gb_Code",gbCode);
    	}
    	if(StringUtil.isNotEmpty(parentCode)){
    		if(OrgGenreCode.STATION.getValue().equals(genreCode)){
    			ca.add("parent_Code",parentCode);
    		}else{
    			ca.add("organ_Code",parentCode);
    		}
    	}
    	if(StringUtil.isNotEmpty(organCode)){
    		ca.add("organ_Code",organCode);
    	}
    	ca.add("GB_CODE",OP.UEMPTY,"");
    	ca.add("parent_Code",OP.UEMPTY,"");
    	ca.add("organ_Code",OP.UEMPTY,"");
    	return ca;
    }
    /**
     * 查找镇对应的机构集合
     *
     * @param gbCode
     * @return
     * @author Ye jianfei
     */
    private String getGbCodeWhere(String gbCode){
        String result = " SELECT ORGAN_CODE"
        		+ " FROM MDM_ORGANIZATION"
        		+ " WHERE GB_CODE = '" + gbCode + "'";
        return result;
    }
    
    /**
     * 查找中心对应的机构集合
     *
     * @param center
     * @return
     * @author Ye jianfei
     */
    private String getCenterCodeWhere(String center){
        String result = " SELECT ORGAN_CODE"
        		+ " FROM MDM_ORGANIZATION"
        		+ " WHERE PARENT_CODE = '" + center + "'";
        return result;
    }
    
    /**
     * 星级统计的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public List<Map<String, Object>> getPersonInfoStatistics(String dateStr) {
    	if (ObjectUtil.isNullOrEmpty(dateStr)) {
			throw new IllegalArgumentException("日期不可以为空！");
		}
    	StringBuilder sqlBuilder = new StringBuilder("WITH personInfo AS(select t.input_organ_code,t.star,t.integrity,t.household_type"   
    			+" from bi_person_info t where t.star in (1,2,3) and t.filing_flag!='0' and t.filing_flag is not null), " 
    			+" one as(select t.input_organ_code one_org,t.household_type one_type,count(*)oneStarNum"  
    			+" from personInfo t where t.star='1' and t.household_type='1' group by t.input_organ_code,t.household_type)," 
    			+" two as(select t.input_organ_code two_org,t.household_type two_type,count(*)twoStarNum "  
     			+" from personInfo t where t.star='2' and t.household_type='1' group by t.input_organ_code,t.household_type),"  
     			+" three as(select t.input_organ_code three_org,t.household_type three_type,count(*)threeStarNum "  
     			+" from personInfo t where t.star='3' and t.household_type='1' group by t.input_organ_code,t.household_type),"  
     			+" one_integrity as(select t.input_organ_code one_org_in,t.household_type one_type_in,count(*)oneStarCompleteNum"   
     			+" from personInfo t where t.star='1' and t.household_type='1' and t.integrity=1 group by t.input_organ_code,t.household_type), " 
     			+" two_integrity as(select t.input_organ_code two_org_in,t.household_type two_type_in,count(*)twoStarCompleteNum   "
     			+" from personInfo t where t.star='2' and t.household_type='1' and t.integrity=1 group by t.input_organ_code,t.household_type), " 
     			+" three_integrity as(select t.input_organ_code three_org_in,t.household_type three_type_in,count(*)threeStarCompleteNum "
      			+" from personInfo t where t.star='3' and t.household_type='1'  and t.integrity=1 group by t.input_organ_code,t.household_type),"
      			+" household as(select p.input_organ_code hou_org,p.household_type type,count(*)household from bi_person_info p "
      			+" where p.filing_flag!='0' and p.filing_flag is not null group by p.input_organ_code,p.household_type) "  
     			+" select pp.input_organ_code,pp.household_type,nvl(household,0)household,"
     			+" nvl(oneStarNum,0)oneStarNum," 
     			+" nvl(twoStarNum,0)twoStarNum, nvl(threeStarNum,0)threeStarNum, "
     			+" nvl(oneStarCompleteNum,0)oneStarCompleteNum, nvl(twoStarCompleteNum,0)twoStarCompleteNum, "
     			+" nvl(threeStarCompleteNum,0)threeStarCompleteNum  "
     			+" from (select p.input_organ_code,p.household_type"
     			+" from bi_person_info p where p.filing_flag!='0' and p.filing_flag is not null " 
      			+" group by p.input_organ_code,p.household_type) pp "
      			+" left join one on pp.input_organ_code = one.one_org and pp.household_type=one.one_type"
       			+" left join two on pp.input_organ_code = two.two_org and pp.household_type=two.two_type " 
      			+" left join three on pp.input_organ_code = three.three_org and pp.household_type=three.three_type" 
      			+" left join one_integrity on pp.input_organ_code = one_integrity.one_org_in and pp.household_type=one_integrity.one_type_in" 
      			+" left join two_integrity on pp.input_organ_code = two_integrity.two_org_in and pp.household_type=two_integrity.two_type_in"
     			+" left join three_integrity on pp.input_organ_code = three_integrity.three_org_in and pp.household_type=three_integrity.three_type_in"
     			+" left join household on pp.input_organ_code = household.hou_org and pp.household_type=household.type"
     			+" order by pp.input_organ_code");
			
    	return this.getMapList(sqlBuilder.toString(), new Criteria());
    }


	public Map<String,Object> getStatisticsListEveryCenter(String centerOrgCode){
		String sql = "SELECT count(*) coutNum FROM (SELECT input_organ_code,input_organ_name,input_center_organ_code,filing_flag FROM BI_PERSON_INFO t \n" +
				"WHERE t.filing_flag = 1 and (t.input_organ_code = '"+centerOrgCode+"' or t.input_center_organ_code = '"+centerOrgCode+"'))";
		Map<String,Object> map  = this.getMap(sql, new Criteria());
		return map;
	}
	
	public PageList<Map<String, Object>> getPersonInfoListMap(Page page,Boolean flg, List<String> orgCodes, Map<String, String> paramMap,int type){
		String name = paramMap.get("name");
        String gender = paramMap.get("gender");
        String updateDateStart = paramMap.get("updateDate");
        String updateDateEnd = paramMap.get("updateDateEnd");
        String organCode = paramMap.get("organCode");
        String createDate = paramMap.get("createDate");
        String createDateEnd = paramMap.get("createDateEnd");
        String idCard=paramMap.get("idCard");
        String healthGuideStatus= paramMap.get("healthGuideStatus");
//        String startAge= paramMap.get("startAge");
//        String endAge= paramMap.get("endAge");
        String childBirthday= paramMap.get("birthday");
        String childBirthdayEnd= paramMap.get("birthdayEnd");
        Order order = new Order("W.UPDATE_DATE DESC NULLS LAST,W.CREATE_DATE Desc");
        
        Criteria ca = new Criteria();
        ca.add("type",type);
        
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT DISTINCT W.ID,W.NAME,DECODE(W.GENDER,'0','未知的性别','1','男','2','女','未说明的性别') GENDER,W.ID_CARD,B.UPDATE_ORGAN_NAME,W.CREATE_DATE,W.UPDATE_DATE,B.PHONE_NUMBER,B.HOUSEHOLD_TYPE,B.HRTOWN_SHIP,B.HRSTREET,B.HRHOUSE_NUMBER,B.PATOWN_SHIP,B.PASTREET,B.PAHOUSE_NUMBER,B.GUARDIAN_PHONE_ONE,B.HRCOUNTY,B.PACOUNTY,B.UPDATE_NAME,B.PHYSICIANS_CARING_NAME, ");
        
        if(type==1){
        	sql.append(" W.CHILD_BIRTHDAY,FLOOR(MONTHS_BETWEEN(SYSDATE, W.CHILD_BIRTHDAY) / 12)||'岁' AGE,V.MOTHER_NAME,");
        	sql.append("DECODE(SIGN((SELECT count(1) FROM CH_CHILD_HEALTH_EXAMINATION@DL_MS CH WHERE TCM_HEALTH_MANAGE_SERVICE IS NOT NULL AND W.PERSON_ID = CH.PERSON_ID ").append(getVisitDateSql("CH.VISIT_DATE", createDate, createDateEnd)).append(")),1,'是','否') HEALTH_GUIDE_STATUS ");
        }else if(type==2){
    		sql.append("DECODE(SIGN((SELECT count(1) FROM WH_PRENATAL_FOLLOWUP@DL_MS WH WHERE CM_HEALTH_MANAGE IS NOT NULL  AND W.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.VISIT_DATE", createDate, createDateEnd)).append(")+ (SELECT count(1) FROM WH_PRENATAL_FOLLOWUP_OTHER@DL_MS WH WHERE ((TCM_HEALTH_SIGN_TWO IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_TWO", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_THREE IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_THREE", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_FOUR IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_FOUR", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_FIVE IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_FIVE", createDate, createDateEnd)).append(")) AND W.PERSON_ID = WH.PERSON_ID)+ (SELECT count(1) FROM WH_POSTNATAL_FOLLOWUP@DL_MS WH WHERE CMEDICI_MANAGE_FLAG IS NOT NULL AND W.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.VISIT_DATE", createDate, createDateEnd)).append(")+ (SELECT count(1) FROM WH_POSTPARTUM_DAYS_HEALTH_INFO@DL_MS WH WHERE CM_HEALTH_MANAGE IS NOT NULL AND W.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.SUPERVISION_DATE", createDate, createDateEnd)).append(")),1,'是','否') HEALTH_GUIDE_STATUS");
    	}
        
        if(type==1){
        	sql.append(" FROM BI_PERSON_INFO B RIGHT JOIN WOMEN_CHILD_HEALTH@DL_MS W ON B.ID=W.PERSON_ID " );
        	sql.append(" LEFT JOIN CH_NEONATAL_FAMILY_VISIT@DL_MS V ON W.PERSON_ID=V.PERSON_ID ");
        	sql.append(" WHERE W.IS_DELETE=0 AND (V.IS_DELETE=0 OR V.IS_DELETE IS NULL)");
        }else if(type==2){
        	sql.append(" FROM BI_PERSON_INFO B RIGHT JOIN WOMEN_CHILD_HEALTH@DL_MS W ON B.ID=W.PERSON_ID " );
        	sql.append(" WHERE W.IS_DELETE=0 ");
        }
        
        sql.append(" AND ").append("W.IDENTITY_TYPE").append("=:type");
        
        if(StringUtil.isNotEmpty(healthGuideStatus)){
        	if(type==1){
        		sql.append(" AND ").append(Integer.parseInt(healthGuideStatus)==1?" EXISTS ":" NOT EXISTS ").append("(SELECT 1 FROM CH_CHILD_HEALTH_EXAMINATION@DL_MS CH WHERE TCM_HEALTH_MANAGE_SERVICE IS NOT NULL AND W.PERSON_ID = CH.PERSON_ID ").append(getVisitDateSql("CH.VISIT_DATE", createDate, createDateEnd)).append(")");
        	}else if(type==2){
        		sql.append(" AND ").append(Integer.parseInt(healthGuideStatus)==1?" EXISTS ":" NOT EXISTS ").append("(SELECT 1 FROM WH_PRENATAL_FOLLOWUP@DL_MS WH WHERE CM_HEALTH_MANAGE IS NOT NULL  AND W.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.VISIT_DATE", createDate, createDateEnd)).append(" UNION ALL SELECT 1 FROM WH_PRENATAL_FOLLOWUP_OTHER@DL_MS WH WHERE ((TCM_HEALTH_SIGN_TWO IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_TWO", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_THREE IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_THREE", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_FOUR IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_FOUR", createDate, createDateEnd)).append(") OR (TCM_HEALTH_SIGN_FIVE IS NOT NULL ").append(getVisitDateSql("WH.INPUT_DATE_FIVE", createDate, createDateEnd)).append(")) AND W.PERSON_ID = WH.PERSON_ID UNION ALL SELECT 1 FROM SY_WH_POSTNATAL_FOLLOWUP WH WHERE CMEDICI_MANAGE_FLAG IS NOT NULL AND W.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.VISIT_DATE", createDate, createDateEnd)).append(" UNION ALL SELECT 1 FROM WH_POSTPARTUM_DAYS_HEALTH_INFO@DL_MS WH WHERE CM_HEALTH_MANAGE IS NOT NULL AND W.PERSON_ID = WH.PERSON_ID ").append(getVisitDateSql("WH.SUPERVISION_DATE", createDate, createDateEnd)).append(")");
        	}
        }
        if(StringUtil.isNotEmpty(name)){
            sql.append(" AND ").append("W.NAME").append("=:name");
            ca.add("name", name);
        }
        if(StringUtil.isNotEmpty(idCard)){
            sql.append(" AND ").append("W.ID_CARD").append("=:idcard");
            ca.add("idcard", idCard);
        }
        if(StringUtil.isNotEmpty(gender)){
            sql.append(" AND ").append("W.GENDER").append("=:gender");
            ca.add("gender", gender);
        }
        
        if(StringUtil.isNotEmpty(updateDateStart)){
            sql.append(" AND TO_CHAR(").append("W.UPDATE_DATE").append(", 'YYYY/MM/DD')").append(" >=:updateDateStart");
            ca.add("updateDateStart", updateDateStart);
        }
        if(StringUtil.isNotEmpty(updateDateEnd)){
			sql.append(" AND TO_CHAR(").append("W.UPDATE_DATE").append(", 'YYYY/MM/DD')").append(" <=:updateDateEnd");
			ca.add("updateDateEnd", updateDateEnd);
        }
        
        if(StringUtil.isNotEmpty(createDate)){
            sql.append(" AND TO_CHAR(").append("W.CREATE_DATE").append(", 'YYYY/MM/DD')").append(" >=:createDate");
            ca.add("createDate", createDate);
        }
        if(StringUtil.isNotEmpty(createDateEnd)){
			sql.append(" AND TO_CHAR(").append("W.CREATE_DATE").append(", 'YYYY/MM/DD')").append(" <=:createDateEnd");
			ca.add("createDateEnd", createDateEnd);
        }
        
        if(StringUtil.isNotEmpty(childBirthday)){
            sql.append(" AND TO_CHAR(").append("W.CHILD_BIRTHDAY").append(", 'YYYY/MM/DD')").append(" >=:childBirthday");
            ca.add("childBirthday", childBirthday);
        }
        if(StringUtil.isNotEmpty(childBirthdayEnd)){
			sql.append(" AND TO_CHAR(").append("W.CHILD_BIRTHDAY").append(", 'YYYY/MM/DD')").append(" <=:childBirthdayEnd");
			ca.add("childBirthdayEnd", childBirthdayEnd);
        }
        
        if(flg){
            if(ObjectUtil.isNotEmpty(organCode)){
                sql.append(" AND ").append("W.ORG_CODE").append(" =:organCode");
                ca.add("organCode", organCode);
            }else if(ObjectUtil.isNotEmpty(orgCodes)){
            	sql.append(" AND ").append("W.ORG_CODE").append(" IN(:organCode)");
            	ca.add("organCode", orgCodes);
            }
        } else {
            // 建档机构
            if (StringUtils.isNotEmpty(organCode)){
	            sql.append(" AND ").append("W.ORG_CODE").append(" =:organCode");
	            ca.add("organCode", organCode);
            }
        }
		
		sql.append(order.toString());
		PageList<Map<String, Object>> map = getPageMapList(page, sql.toString(),ca);
        return map;
	}
	
	private String getVisitDateSql(String col, String createDate, String createDateEnd){
		StringBuilder sql = new StringBuilder();
   	 	if(StringUtil.isNotEmpty(createDate)){
            sql.append(" AND TO_CHAR(").append(col).append(", 'YYYY/MM/DD')").append(" >=:createDate");
        }
        if(StringUtil.isNotEmpty(createDateEnd)){
			sql.append(" AND TO_CHAR(").append(col).append(", 'YYYY/MM/DD')").append(" <=:createDateEnd");
        }
        return sql.toString();
	}
	
	public PageList<Map<String, Object>> getPersonInfoListMap(Page page, Criteria ca){
        
		StringBuilder sql = new StringBuilder();
		Order order = new Order("W.CREATE_DATE",false);
		ClassMetadata cMetadata = ClassMetadata.getMetadata(WomenChildHealth.class);
		sql.append("SELECT W.NAME,W.ID_CARD,B.UPDATE_ORGAN_NAME,W.CREATE_DATE,B.PHONE_NUMBER,B.HOUSEHOLD_TYPE,B.HRTOWN_SHIP,B.HRSTREET,B.HRHOUSE_NUMBER,B.PATOWN_SHIP,B.PASTREET,B.PAHOUSE_NUMBER,B.GUARDIAN_PHONE_ONE,B.HRCOUNTY,B.PACOUNTY,B.UPDATE_NAME,B.PHYSICIANS_CARING_NAME " +
				" FROM BI_PERSON_INFO B RIGHT JOIN V_MS_WOMEN_CHILD_HEALTH W ON B.ID=W.PERSON_ID " +
				" WHERE W.IS_DELETE=0 AND W.IDENTITY_TYPE=1 ")
			.append(ca.toSql(cMetadata, ":", "W"))
			.append(order.toString());
		return this.getPageMapList(page, sql.toString(),ca);
	}

	@Override
	public PageList<PersonInfo> queryPageList(Page page, Criteria criteria, Order order) {
		String ylTypes =null;
		StringBuilder sql = new StringBuilder();
		StringBuilder sql1 = new StringBuilder();
		ClassMetadata cMetadata = ClassMetadata.getMetadata(PersonInfo.class);
		if (StringUtils.isNotEmpty((String)criteria.get("groupClassification"))) {
			String dynamicRecord = (String)criteria.get("groupClassification");
			criteria.remove("groupClassification");
			sql1 = getDynamicRecord(dynamicRecord,sql1);
		}
		String[] resultSqlArray = getPhyExamSql(criteria);

		sql.append("SELECT B.REMARKS, B.ID, B.NAME, B.IDCARD, B.HEALTH_FILE_NO, B.HOUSEHOLD_TYPE, B.INPUT_ORGAN_NAME, B.INPUT_ORGAN_CODE, B.GENDER, " +
				"B.BABY_CARD_NO, B.OTHER_IDCARD_TYPE, B.BIRTHDAY, B.UPDATE_DATE, B.INPUT_DATE,B.PAPROVINCE, B.PACITY, B.PACOUNTY, B.PATOWN_SHIP, B.PASTREET, B.PAHOUSE_NUMBER, B.FILING_FLAG, B.STAR, B.PHONE_NUMBER, " +
				"B.OTHER_IDCARD, B.NATION, B.PA_ADDRESS, B.LIVING_TYPE,B.SIGN_FLAG FROM BI_PERSON_INFO B" +
				" left join (select t.person_id from sy_ehr_health_event t where " +
				" t.ehr_type = '" + EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode() + "'" + resultSqlArray[1] +" group by t.person_id ) e" +
				" ON b.id = e.person_id LEFT JOIN (SELECT phy.person_id FROM SY_MS_PHYSIQUE_EXAMINATION phy where 1=1 "+resultSqlArray[2] +" GROUP BY phy .person_id) f ON b. ID = f .person_id");
		if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
			if(ObjectUtil.isNotEmpty(criteria.get("ylTypes"))) {
				 ylTypes = (String)criteria.get("ylTypes");
				criteria.remove("ylTypes");
				}
			sql.append(" WHERE  ").append(criteria.toSql(cMetadata, ":", "B"));
		}
		sql.append(sql1);
		if(ObjectUtil.isNotEmpty(ylTypes)){
			sql.append(" and b.id in (SELECT T .person_id FROM sy_ehr_health_event T WHERE T .ehr_type = '"+ylTypes+"'"+")");
		}
		sql.append(resultSqlArray[0]);
		sql.append(resultSqlArray[3]);
		sql.append(order.toString());
//		sql.insert(0,"SELECT DISTINCT T1.* FROM\n" + "(");
//		sql.append("  ) T1 ");
		return this.getPageList(page, sql.toString(), criteria);
	}

	/**
	 * 是否体检
	 * @param criteria
	 */
	private String[] getPhyExamSql(Criteria criteria) {
		String[] resultSqlArray = new String[]{"","","",""};
		if(ObjectUtil.isNotEmpty(criteria.get("isPhyExam"))) {
			resultSqlArray[0] = " and e.person_id is not null";
			String isPhyExam = (String)criteria.get("isPhyExam");
			if(ObjectUtil.equals("1", isPhyExam)) {
				resultSqlArray[0] = " and e.person_id is null";
			}
			if(ObjectUtil.isNotEmpty(criteria.get("clinicYear"))) {
				resultSqlArray[1] = " and t.clinic_date >= TO_DATE('" + criteria.get("clinicYear") + "/01/01', 'yyyy/mm/dd') and t.clinic_date <= TO_DATE('" + criteria.get("clinicYear") + "/12/31', 'yyyy/mm/dd')";
			}
			if(ObjectUtil.isNotEmpty(criteria.get("personPhyExamStartDate"))) {
				resultSqlArray[1] = " and t.clinic_date >= TO_DATE('" + criteria.get("personPhyExamStartDate") + "', 'yyyy/mm/dd')";
				criteria.remove("personPhyExamStartDate");
			}
			if(ObjectUtil.isNotEmpty(criteria.get("personPhyExamEndDate"))) {
				resultSqlArray[1] = resultSqlArray[1]+" and t.clinic_date <= TO_DATE('" + criteria.get("personPhyExamEndDate") + "', 'yyyy/mm/dd')";
				criteria.remove("personPhyExamEndDate");
			}
			if(ObjectUtil.isNotEmpty(criteria.get("tjBeginDate"))) {//体检录入开始时间
				resultSqlArray[2] = " and phy.EXAMINATION_DATE >= TO_DATE('" + criteria.get("tjBeginDate") + "', 'yyyy/mm/dd')";
			}
			if(ObjectUtil.isNotEmpty(criteria.get("tjEndDate"))) {//体检录入结束时间
				resultSqlArray[2] = resultSqlArray[2]+" and phy.EXAMINATION_DATE <= TO_DATE('" + criteria.get("tjEndDate") + "', 'yyyy/mm/dd')";
			}
			if(ObjectUtil.isNotEmpty(criteria.get("tjbh"))) {//体检编号
				resultSqlArray[2] = resultSqlArray[2]+" and phy.PHYSICAL_EXAM_CODE = '" + criteria.get("tjbh") + "'";
			}
			if(ObjectUtil.isNotEmpty(criteria.get("tjBeginDate"))||ObjectUtil.isNotEmpty(criteria.get("tjEndDate"))||ObjectUtil.isNotEmpty(criteria.get("tjbh"))){
				resultSqlArray[3] = " and f.person_id is not null";
			}
			criteria.remove("isPhyExam");
			criteria.remove("clinicYear");
			criteria.remove("tjBeginDate");
			criteria.remove("tjEndDate");
			criteria.remove("tjbh");
		}
		return resultSqlArray;
	}

	@Override
	public PageList<Map<String, Object>> queryPageMapList(Page page,Criteria criteria, Order order) {
		StringBuilder sql = new StringBuilder();
		StringBuilder sql1 = new StringBuilder();
		ClassMetadata cMetadata = ClassMetadata.getMetadata(PersonInfo.class);
		if (StringUtils.isNotEmpty((String)criteria.get("groupClassification"))) {
			String dynamicRecord = (String)criteria.get("groupClassification");
			criteria.remove("groupClassification");
			sql1 = getDynamicRecord(dynamicRecord,sql1);
		}
		String[] resultSqlArray = getPhyExamSql(criteria);
		sql.append("SELECT B.REMARKS, B.ID, B.NAME, B.IDCARD, B.HEALTH_FILE_NO, B.HOUSEHOLD_TYPE, B.INPUT_ORGAN_NAME, B.INPUT_ORGAN_CODE, B.GENDER, " +
				"B.BABY_CARD_NO, B.OTHER_IDCARD_TYPE, B.BIRTHDAY, B.UPDATE_DATE, B.PAPROVINCE, B.PACITY, B.PACOUNTY, B.PATOWN_SHIP, B.PASTREET, B.PAHOUSE_NUMBER, B.FILING_FLAG, B.STAR, B.PHONE_NUMBER, " +
				"B.OTHER_IDCARD, B.NATION, B.PA_ADDRESS, B.LIVING_TYPE,B.SIGN_FLAG,B.PA_GROUP,B.HR_GROUP,B.HRTOWN_SHIP,B.HRSTREET,B.HRHOUSE_NUMBER," +
				"B.CREATE_ORGAN_CODE,B.CREATE_NAME,B.CREATE_DATE,B.GUARDIAN_PHONE_ONE,E.clinic_date FROM BI_PERSON_INFO B " +
//				" left join (select t.person_id from sy_ehr_health_event t where " +
				"LEFT JOIN ((SELECT T .* FROM ( SELECT A .*, ROW_NUMBER () OVER ( PARTITION BY A .person_id ORDER BY A .clinic_date DESC ) rw FROM ( SELECT T .person_id, T .clinic_date FROM sy_ehr_health_event T WHERE"+
				" t.ehr_type = '" + EventType.PERSON_RECORD_PHYSICIAL_EXAM.getCode() + "'" + resultSqlArray[1] +" group by t.person_id, t .clinic_date " +
				") A ) T WHERE T .rw = 1)" +
				") e" +
				" ON b.id = e.person_id");
		sql.append(" WHERE  ").append(criteria.toSql(cMetadata, ":", "B"));
		sql.append(sql1);
		sql.append(resultSqlArray[0]);
		sql.append(order.toString());
		
		return this.getPageMapList(page, sql.toString(), criteria);
	}
	
	private StringBuilder getDynamicRecord(String dynamicRecord,StringBuilder sql){
		String[] sourceStrArray = dynamicRecord.split(",");
		for (int i = 0; i < sourceStrArray.length; i++) {
			if(i == 0){ sql.append(" AND( "); }else {sql.append(" OR( ");}

			if(sourceStrArray[i] .equals("1")){
				sql.append(" MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 7");
				sql.append(" AND TO_CHAR(B.BIRTHDAY,'YYYY')>TO_CHAR(SYSDATE,'YYYY')-65");
				sql.append(" AND (MATERNAL_FLAG='1' or MATERNAL_FLAG is null)");
				sql.append(" AND NOT EXISTS( select person_id from DM_DISEASE_INFO D where (D.HBP_FLAG=2  OR D.DI_FLAG=2) AND B.ID=D.PERSON_ID ) ");
			}
			if(sourceStrArray[i] .equals("2")){
				sql.append(" MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 < 7 AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 0");
			}
			if(sourceStrArray[i] .equals("3")){
				sql.append(" TO_CHAR(B.BIRTHDAY,'YYYY')<=TO_CHAR(SYSDATE,'YYYY')-65");
			}
			if(sourceStrArray[i] .equals("4")){
				sql.append(" MATERNAL_FLAG='2'");
			}
			if(sourceStrArray[i] .equals("5")){
				sql.append(" EXISTS( select person_id from DM_DISEASE_INFO D where D.HBP_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
			}
			if(sourceStrArray[i] .equals("6")){
				sql.append(" EXISTS( select person_id from DM_DISEASE_INFO D where D.DI_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
			}
			if(sourceStrArray[i] .equals("7")){
				sql.append(" EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE in('208', '209', '212') and dh.person_id = B.ID)");
			}
			if(sourceStrArray[i] .equals("8")){
				sql.append(" EXISTS( select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '208' and dh.person_id = B.ID)");
			}
			if(sourceStrArray[i] .equals("9")){
				sql.append(" EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '207' and dh.person_id = B.ID )");
			}
			if(i == sourceStrArray.length-1){ sql.append(" ) "); }
			if(i != 0){sql.append(" ) ");}

		}

		return sql;
		/*switch (dynamicRecord) {
		case 1://普通人群
			sql.append(" AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 7");
			//sql.append(" AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 < 65");
			sql.append(" AND TO_CHAR(B.BIRTHDAY,'YYYY')>TO_CHAR(SYSDATE,'YYYY')-65");
			sql.append(" AND (MATERNAL_FLAG='1' or MATERNAL_FLAG is null)");
			sql.append(" AND NOT EXISTS( select person_id from DM_DISEASE_INFO D where (D.HBP_FLAG=2  OR D.DI_FLAG=2) AND B.ID=D.PERSON_ID )");
			break;
		case 2://儿童
			sql.append(" AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 < 7 AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 0");
			break;
		case 3://老年人
			//sql.append(" AND MONTHS_BETWEEN(SYSDATE, B.BIRTHDAY)/12 >= 65");
			sql.append(" AND TO_CHAR(B.BIRTHDAY,'YYYY')<=TO_CHAR(SYSDATE,'YYYY')-65");
			break;
		case 4://孕产妇
			sql.append(" AND MATERNAL_FLAG='2'");
			break;
		case 5://高血压患者
			sql.append(" AND EXISTS( select person_id from DM_DISEASE_INFO D where D.HBP_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
			break;
		case 6://糖尿病患者
			sql.append(" AND EXISTS( select person_id from DM_DISEASE_INFO D where D.DI_FLAG=2 AND D.STATUS = 1 AND B.ID=D.PERSON_ID )");
			break;
		case 7://传染病
			sql.append(" AND EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE in('208', '209', '212') and dh.person_id = B.ID)");
//					"and EXISTS(select id from SY_EHR_HEALTH_EVENT e where ehr_type = '" + EventType.PERSON_RECORD_BASIC_INFO.getCode() + "' and e.person_id = dh.person_id))");
			break;
		case 8://肺结核
			sql.append(" AND EXISTS( select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '208' and dh.person_id = B.ID)");
//					"and  EXISTS(select id from SY_EHR_HEALTH_EVENT e where ehr_type = '" + EventType.PERSON_RECORD_BASIC_INFO.getCode() + "' and e.person_id = dh.person_id))");
			break;
		case 9://精神障碍患者
			sql.append(" AND EXISTS(select dh.person_id from DHS_DISEASE_HISTORY dh where dh.DISEASE_CODE = '207' and dh.person_id = B.ID )");
//					"and EXISTS(select id from SY_EHR_HEALTH_EVENT e where ehr_type = '" + EventType.PERSON_RECORD_BASIC_INFO.getCode() + "' and e.person_id = dh.person_id))");
			break;
		}*/
	}

	/**
	 * 查询所有不在ECH_PHYSICAL_EXAM_RECORD（physicalExamType＝31）65岁以上的老年人信息
	 * @param criteria
	 * @return
	 */
	@Override
	public List<PersonInfo> queryPersonInfoList(Criteria criteria) {
		StringBuilder sql = new StringBuilder("select b.id, b.name, b.IDCARD,b.BIRTHDAY,b.GENDER,b.MARRIAGE,b.HOME_PHONE,b.PHONE_NUMBER,b.EMAIL\n" +
				"from bi_person_info b where not EXISTS(select id from ECH_PHYSICAL_EXAM_RECORD ex where ex.person_id = b.id)");
		ClassMetadata cMetadata = ClassMetadata.getMetadata(PersonInfo.class);
		sql.append(criteria.toSql(cMetadata, ":", "B"));
		return this.getList(sql.toString(), criteria);
	}

	/**
	 * 获取档案编号重复的档案
	 * @return
	 */
	public List<PersonInfo> getRepeatEhrNOList() {
		String sql = "select b1.id, b1.health_file_no, b1.pastreet from bi_person_info b1\n" +
				"left join (select * from (SELECT b2.health_file_no FROM  bi_person_info b2\n" +
				"GROUP BY b2.health_file_no HAVING COUNT(b2.health_file_no) > 1)) b3 on b1.health_file_no = b3.health_file_no\n" +
				"where b3.health_file_no is not null";
		return this.getList(sql);
	}

	/**
	 * 获取档案编号为null的已建档档案
	 * @return
	 */
	public List<PersonInfo> getRepeatEhrNONullList() {
		String sql = "select b1.id, b1.health_file_no, b1.pastreet from bi_person_info b1 " +
				"where b1.health_file_no is null and b1.FILING_FLAG=1";
		return this.getList(sql);
	}


	/**
	 * 根据孕产妇的末次月经日期计算满一年后自动生成为“普通人群”
	 */
	public int updateClassification(){
		String sql ="UPDATE BI_PERSON_INFO SET  MATERNAL_FLAG = '1'  WHERE MATERNAL_FLAG = '2' AND MONTHS_BETWEEN (SYSDATE, LAST_MENSTRUAL_DATE) / 12 >= 1";
		return this.execute(sql);
	};

	@Override
	public PageList<PersonInfo> getPageListAndNotInRecord(Page page, Criteria c) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ID,NAME,IDCARD,BIRTHDAY,GENDER,INPUT_ORGAN_CODE,INPUT_CENTER_ORGAN_CODE,"
				+ " INPUT_GBCODE,MARRIAGE,HOME_PHONE,PHONE_NUMBER,EMAIL,HEALTH_FILE_NO,OTHER_IDCARD"
				+ " FROM BI_PERSON_INFO INFO ");
		SqlBuilder.buildWhereStatement(PersonInfo.class, sql, c);
		
		sql.append(" AND NOT EXISTS (SELECT 1 FROM ECH_PHYSICAL_EXAM_RECORD RECORD WHERE INFO.ID=RECORD.PERSON_ID)");
		return this.getPageList(page, sql.toString(), c);
	}
	
	@Override
	public PersonInfo getPersoninfo(Long id) {
		if(id==null)
			return null;
		String sql = "SELECT ID,NAME FROM BI_PERSON_INFO B where B.id = " + id.toString();
		return this.get(sql,null);
	}
}