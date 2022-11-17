package com.founder.rhip.ehr.repository.ihm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import javax.annotation.Resource;

/**
 * DAO implement of 传染病分析
 * 
 */
@Repository("idmAnalyseTargetDao")
public class IdmAnalyseTargetDaoImpl extends	AbstractDao<IdmReport, Long> implements IIdmAnalyseTargetDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    private static final String select_gb_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE";
    private static final String select_parent_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";
    private static final String select_organ_code = "decode(grouping_id(GB_CODE),1,'grouping',GB_CODE) GB_CODE,"
    		+ "decode(grouping_id(parent_Code),1,'grouping',parent_Code) PARENT_CODE,"
    		+ "decode(grouping_id(ORG.organ_Code),1,'grouping',ORG.organ_Code) ORGAN_CODE";
    
    private static final String ORG_SQL="WITH ORGANIZATION_RESULT AS("
    		+ " SELECT GB_CODE,PARENT_CODE,ORGAN_CODE,GENRE_CODE"
    		+ " FROM V_MDM_ORGANIZATION_NOSUB"
    		+ " %1$s )";//机构条件
 
    private static final String REGION_SQL = " SELECT region.* FROM("
    		+ " SELECT %5$s"
    		+ " 		,SUM(infections101) infections101"//鼠疫
    		+ " 		,SUM(infections102) infections102"//霍乱
    		+ " 		,SUM(infections201) infections201"//传染性非典
    		+ " 		,SUM(infections202) infections202"//艾滋病
    		+ " 		,SUM(infections203) infections203"//肝炎
    		+ " 		,SUM(infections204) infections204"//脊灰
    		+ " 		,SUM(infections205) infections205"//人禽流感
    		+ " 		,SUM(infections206) infections206"//甲型H1N1流感
    		+ " 		,SUM(infections207) infections207"//麻疹
    		+ " 		,SUM(infections208) infections208"//出血热
    		+ " 		,SUM(infections209) infections209"//狂犬病
    		+ " 		,SUM(infections210) infections210"//乙脑
    		+ " 		,SUM(infections211) infections211"//登革热
    		+ " 		,SUM(infections212) infections212"//炭疽
    		+ " 		,SUM(infections213) infections213"//痢疾
    		+ " 		,SUM(infections214) infections214"//肺结核
    		+ " 		,SUM(infections215) infections215"//伤寒+副伤寒
    		+ " 		,SUM(infections216) infections216"//流脑
    		+ " 		,SUM(infections217) infections217"//百日咳
    		+ " 		,SUM(infections218) infections218"//白喉
    		+ " 		,SUM(infections218) infections219"//新生儿破伤风
    		+ " 		,SUM(infections220) infections220"//猩红热
    		+ " 		,SUM(infections221) infections221"//布病
    		+ " 		,SUM(infections222) infections222"//淋病
    		+ " 		,SUM(infections223) infections223"//梅毒
    		+ " 		,SUM(infections224) infections224"//钩体病
    		+ " 		,SUM(infections225) infections225"//血吸虫病
    		+ " 		,SUM(infections226) infections226"//疟疾
    		+ " 		,SUM(infections301) infections301"//流行性感冒
    		+ " 		,SUM(infections302) infections302"//流行性腮腺炎
    		+ " 		,SUM(infections303) infections303"//风疹
    		+ " 		,SUM(infections304) infections304"//急性出血性结膜炎
    		+ " 		,SUM(infections305) infections305"//麻风病
    		+ " 		,SUM(infections306) infections306"//斑疹伤寒
    		+ " 		,SUM(infections307) infections307"//黑热病
    		+ " 		,SUM(infections308) infections308"//包虫病
    		+ " 		,SUM(infections309) infections309"//丝虫病
    		+ " 		,SUM(infections310) infections310"//其它感染性腹泻病
    		+ " 		,SUM(infections311) infections311"//手足口病	
    		+ "			,SUM(INFECTIONS_COUNT) INFECTIONS_COUNT"//合计
     		+ " FROM ORGANIZATION_RESULT ORG"
    		+ " LEFT JOIN("
    		+ " 	SELECT FILL_ORGAN_CODE"
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'101',1,NULL)) infections101"//鼠疫
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'102',1,NULL)) infections102"//霍乱
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'201',1,NULL)) infections201"//传染性非典
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'202',1,NULL)) infections202"//艾滋病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'203',1,NULL)) infections203"//肝炎
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'204',1,NULL)) infections204"//脊灰
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'205',1,NULL)) infections205"//人禽流感
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'206',1,NULL)) infections206"//甲型H1N1流感
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'207',1,NULL)) infections207"//麻疹
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'208',1,NULL)) infections208"//出血热
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'209',1,NULL)) infections209"//狂犬病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'210',1,NULL)) infections210"//乙脑
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'211',1,NULL)) infections211"//登革热
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'212',1,NULL)) infections212"//炭疽
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'213',1,NULL)) infections213"//痢疾
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'214',1,NULL)) infections214"//肺结核
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'215',1,NULL)) infections215"//伤寒+副伤寒
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'216',1,NULL)) infections216"//流脑
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'217',1,NULL)) infections217"//百日咳
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'218',1,NULL)) infections218"//白喉
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'219',1,NULL)) infections219"//新生儿破伤风
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'220',1,NULL)) infections220"//猩红热
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'221',1,NULL)) infections221"//布病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'222',1,NULL)) infections222"//淋病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'223',1,NULL)) infections223"//梅毒
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'224',1,NULL)) infections224"//钩体病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'225',1,NULL)) infections225"//血吸虫病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'226',1,NULL)) infections226"//疟疾
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'301',1,NULL)) infections301"//流行性感冒
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'302',1,NULL)) infections302"//流行性腮腺炎
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'303',1,NULL)) infections303"//风疹
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'304',1,NULL)) infections304"//急性出血性结膜炎
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'305',1,NULL)) infections305"//麻风病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'306',1,NULL)) infections306"//斑疹伤寒
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'307',1,NULL)) infections307"//黑热病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'308',1,NULL)) infections308"//包虫病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'309',1,NULL)) infections309"//丝虫病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'310',1,NULL)) infections310"//其它感染性腹泻病
    		+ " 		,COUNT(DECODE(SUBSTR(INFECTIOUS_CODE,0,3),'311',1,NULL)) infections311"//手足口病	
    		+ "			,COUNT(1) INFECTIONS_COUNT"
    		+ " 	FROM V_DCD_IDM_DATA"
    		+ " 	WHERE (FILL_DATE>=TO_DATE('%2$s','yyyy/MM/dd') AND FILL_DATE<=TO_DATE('%3$s','yyyy/MM/dd')) %6$s"
    		+ "		GROUP BY FILL_ORGAN_CODE"
    		+ " )region on org.ORGAN_CODE = region.FILL_ORGAN_CODE"
    		+ " GROUP BY %4$s) region";
 
    private static final String TREND_SQL = " SELECT "
			+ "	SUM(month01) month01"//1月
			+ "	,SUM(month02) month02"//2月
			+ "	,SUM(month03) month03"//3月
			+ "	,SUM(month04) month04"//4月
			+ "	,SUM(month05) month05"//5月
			+ "	,SUM(month06) month06"//6月
			+ "	,SUM(month07) month07"//7月
			+ "	,SUM(month08) month08"//8月
			+ "	,SUM(month09) month09"//9月
			+ "	,SUM(month10) month10"//10月
			+ "	,SUM(month11) month11"//11月
			+ "	,SUM(month12) month12"//12月    		
    		+ "	FROM(SELECT FILL_ORGAN_CODE"
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'01',1,NULL)) month01"//1月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'02',1,NULL)) month02"//2月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'03',1,NULL)) month03"//3月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'04',1,NULL)) month04"//4月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'05',1,NULL)) month05"//5月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'06',1,NULL)) month06"//6月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'07',1,NULL)) month07"//7月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'08',1,NULL)) month08"//8月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'09',1,NULL)) month09"//9月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'10',1,NULL)) month10"//10月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'11',1,NULL)) month11"//11月
			+ "			,COUNT(DECODE(TO_CHAR(FILL_DATE,'mm'),'12',1,NULL)) month12"//12月
			+ "		FROM V_DCD_IDM_DATA"
			+ "		WHERE (FILL_DATE>=TO_DATE('%1$s','yyyy/MM/dd') AND FILL_DATE<=TO_DATE('%2$s','yyyy/MM/dd')) %3$s"
			+ "		GROUP BY FILL_ORGAN_CODE"
			+ "	)";
    private String getTrendSql(String beginDate
    		, String endDate
    		, String genreCode
    		,String gbCode
    		,String parentCode
    		,String organCode
    		,String infectiousCode){
    	StringBuilder sql = new StringBuilder(TREND_SQL);
    	//机构条件
    	StringBuilder orgWhere =  new StringBuilder(getWhere(genreCode,gbCode,parentCode,organCode,infectiousCode));
 
    	return String.format(sql.toString(),beginDate,endDate,orgWhere);
    }
 
    private String getRegionSql(String beginDate
    		, String endDate
    		, String genreCode
    		, Criteria ca){
    	StringBuilder sql = new StringBuilder(ORG_SQL + REGION_SQL);
    	//机构条件
    	StringBuilder orgWhere =  new StringBuilder();
    	//机构字段
    	String orgField = getOrgField(genreCode,false);
    	//SELECT字段
    	String orgSelectField = getOrgField(genreCode,true);
    	SqlBuilder.buildWhereStatement(Organization.class,orgWhere,ca);
    	Object organCodeObj = ca.get("organ_Code");
    	String organCode = ObjectUtil.isNotEmpty(organCodeObj)?"AND FILL_ORGAN_CODE='" + organCodeObj.toString() + "'":"";
    	return String.format(sql.toString(),orgWhere.toString(),beginDate,endDate,orgField,orgSelectField,organCode);
    }
    
    private String getWhere(String genreCode,String gbCode,String parentCode,String organCode,String infectiousCode){
    	String result = "";
    	if(StringUtil.isNotEmpty(organCode)){//市级医院
    		result = " AND FILL_ORGAN_CODE = '" + organCode + "'";
    	}else if(StringUtil.isNotEmpty(parentCode)){//中心
    		result = " AND FILL_ORGAN_CODE ='"+ parentCode +"'";
    	}else if(StringUtil.isNotEmpty(gbCode)){//镇
    		result = " AND FILL_ORGAN_CODE IN("+getGbCodeWhere(genreCode,gbCode)+")  \n ";
    	}else{
    		result = " AND FILL_ORGAN_CODE IN("+getGbCodeWhere(genreCode,"")+")  \n ";
    	}
    	result += " AND INFECTIOUS_CODE LIKE '" + infectiousCode + "%' ";
    	return result;
    }
    
    /**
     * 查找镇对应的机构集合
     *
     * @param gbCode
     * @return
     * @author Ye jianfei
     */
    private String getGbCodeWhere(String genreCode,String gbCode){
        String result = " SELECT ORGAN_CODE"
        		+ " FROM V_MDM_ORGANIZATION_NOSUB WHERE 1=1 ";
        if(StringUtil.isNotEmpty(genreCode) && (!"0".equals(genreCode))){
        	result += " AND  GENRE_CODE ='" + genreCode + "'";
        }
        if(StringUtil.isNotEmpty(gbCode)){
        	result += " AND GB_CODE = '" + gbCode + "'";
        }
        return result;
    }
    
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
    
	@Override
	public Map<String, Object> getTrendMap(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode,String infectiousCode) {
		Map<String,Object> result = new HashMap<String,Object>();
		String sql = getTrendSql(beginDate,endDate,genreCode,gbCode,parentCode,organCode,infectiousCode);
		List<Map<String,Object>> maplist = this.getMapList(sql,new Criteria());
		if(ObjectUtil.isNotEmpty(maplist)){
			result = maplist.get(0);
		}
		return result;
	} 
	
	@Override
	public List<Map<String, Object>> getRegionList(String beginDate, String endDate, String genreCode, String gbCode, String parentCode, String organCode) {
		Criteria ca = getOrgCriteria(genreCode,gbCode,parentCode,organCode);
		String sql = getRegionSql(beginDate,endDate,genreCode,ca);
		return this.getMapList(sql,ca);
	} 
}