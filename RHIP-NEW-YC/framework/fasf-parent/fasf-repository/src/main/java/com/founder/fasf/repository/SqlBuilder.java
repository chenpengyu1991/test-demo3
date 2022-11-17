
package com.founder.fasf.repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Parameter;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.fasf.beans.SqlParameter;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class SqlBuilder {

	static final String PREFIXINSQL = ":";
	public static final String WHERE = "where";
	public static final String SOURCE = "source";
	
	protected static Logger log = Logger.getLogger(SqlBuilder.class);

	//used
	public static String createInsertString(Class<?> clazz, String tableName, String... properties) {
		if (clazz==null) { return null;}
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		StringBuilder sql = new StringBuilder("INSERT INTO ").append(StringUtil.isNullOrEmpty(tableName) ? cMetadata.getTable() : tableName).append(" (");
		StringBuilder colums = new StringBuilder();
		StringBuilder values = new StringBuilder(") VALUES (");
		int i = 0;
		if (properties == null || properties.length < 1) {
			for (PropertyMetadata property : pMetadata.values()) {
				if (!property.isDbField()) {continue;}
				if (i>0) {colums.append(" , "); values.append(" , ");}
				colums.append(property.getColumn());
				values.append(PREFIXINSQL).append(property.getName());					
				i++;
			}
		} else {
			for (String property : properties) {
				if (i>0) {colums.append(" , "); values.append(" , ");}
				colums.append(pMetadata.get(property).getColumn());
				values.append(PREFIXINSQL).append(pMetadata.get(property).getName());
				i++;
			}
		}
		sql.append(colums).append(values).append(")");
		return sql.toString();	
	}
	//used
	public static String createInsertStringWithKeyValue(Class<?> clazz, String tableName,String PrimayKeyValue, String... properties) {
		if (clazz==null) { return null;}
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		StringBuilder sql = new StringBuilder("INSERT INTO ").append(StringUtil.isNullOrEmpty(tableName) ? cMetadata.getTable() : tableName).append(" (");
		StringBuilder colums = new StringBuilder();
		StringBuilder values = new StringBuilder(") VALUES (");
		int i = 0;
		if (properties == null || properties.length < 1) {
			for (PropertyMetadata property : pMetadata.values()) {
				if (!property.isDbField()) {continue;}
				if (i>0) {colums.append(" , "); values.append(" , ");}
				colums.append(property.getColumn());
				if(property.isPrimayKey()){
					values.append(PrimayKeyValue);
				}else{
					values.append(PREFIXINSQL).append(property.getName());			
				}
				i++;
			}
		} else {
			for (String property : properties) {
				if (i>0) {colums.append(" , "); values.append(" , ");}
				PropertyMetadata pProperty=pMetadata.get(property);
				colums.append(pProperty.getColumn());
				if(pProperty.isPrimayKey()){
					values.append(PrimayKeyValue);
				}else{
					values.append(PREFIXINSQL).append(pProperty.getName());
				}
				i++;
			}
		}
		sql.append(colums).append(values).append(")");
		return sql.toString();	
	}
	
	//used
	public static String createDeleteString(Class<?> clazz, String tableName, Criteria criteria) {
		if(clazz==null){ return null; }
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		StringBuilder sql =new StringBuilder("DELETE FROM ").append(StringUtil.isNullOrEmpty(tableName) ? cMetadata.getTable() : tableName);
		if(criteria==null||criteria.getCriteria()==null||criteria.getCriteria().size()<1){ return sql.toString(); }	
		sql.append(" WHERE ").append(criteria.toSql(cMetadata, PREFIXINSQL));
		return sql.toString();		
	}	
	
	//used	
	public static String createUpdateString(Class<?> clazz, String tableName, Parameters parameters, Criteria criteria) {
		if(clazz==null||parameters==null){return null;}
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		LinkedHashMap<String, String> columns=cMetadata.getColumns();		
		StringBuilder sql =new StringBuilder("UPDATE ").append(StringUtil.isNullOrEmpty(tableName) ? cMetadata.getTable() : tableName).append(" SET ");
		int i = 0;
		for (Parameter paramName : parameters.getParameters()) {
			if (i > 0) {sql.append(",");}
			String pName =paramName.getName();				
			String columnName = pMetadata.containsKey(pName) ? pMetadata.get(pName).getColumn() : columns.containsKey(pName.toUpperCase())?pMetadata.get(columns.get(pName.toUpperCase())).getColumn():pName;
			sql.append(columnName).append(" = ");
			Object pVaule=paramName.getValue();				
			if (pVaule == null){
				sql.append(" null ");
			}else if(ObjectUtil.isNumber(pVaule)) {
				sql.append(pVaule).append(" ");
			}else if(ObjectUtil.isDate(pVaule)) {
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
				String dateStr = df.format((Date)pVaule);
				sql.append("to_date('" + dateStr +"', 'yyyyMMddHH24miss')").append(" ");
			} else {
				sql.append("'").append(pVaule).append("' ");
			}
			i++;
		}
		if (criteria==null|| criteria.getCriteria()==null||criteria.getCriteria().size()<1) { return sql.toString();}
		sql.append(" WHERE ").append(criteria.toSql(cMetadata, PREFIXINSQL));
		return sql.toString();	
	}

	//used
	public static String createUpdateString(Class<?> clazz, String tableName, String key, String... properties) {
		if(clazz==null) { return null;}	
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		LinkedHashMap<String, String> columns=cMetadata.getColumns();	
		StringBuilder sql =new StringBuilder("UPDATE ").append(StringUtil.isNullOrEmpty(tableName) ? cMetadata.getTable() : tableName).append(" SET ");
		String cKey;
		String pKey;
		if (ObjectUtil.isNotEmpty(key)) {
			cKey =pMetadata.containsKey(key)?pMetadata.get(key).getColumn():columns.containsKey(key.toUpperCase())?pMetadata.get(columns.get(key.toUpperCase())).getColumn():key;
			pKey=pMetadata.containsKey(key)?pMetadata.get(key).getName():columns.containsKey(key.toUpperCase())?pMetadata.get(columns.get(key.toUpperCase())).getName():key;
		} else {
			cKey = pMetadata.get(cMetadata.getPrimaryKey()).getColumn();
			pKey=cMetadata.getPrimaryKey();
		}
		int i = 0;
		if (ObjectUtil.isNotEmpty(properties) && (properties.length > 0)) {
			for (String property : properties) {
				if(property.equals(pKey)){continue;}
				if (i > 0) {sql.append(",");}
				String columnName = pMetadata.containsKey(property) ? pMetadata.get(property).getColumn() : property;
				sql.append(columnName).append(" = ").append(PREFIXINSQL).append(property);
				i++;
			}
		} else {
			for (PropertyMetadata property :pMetadata.values()) {
				if(pKey.equals(property)){continue;}
				if (!property.isDbField()) {continue;}
				if (i > 0) {sql.append(",");}
				sql.append(property.getColumn()).append(" = ").append(PREFIXINSQL).append(property.getName());
				i++;
			}			
		}		
		sql.append(" WHERE ").append(cKey).append(" = ").append(PREFIXINSQL).append(pKey);
		return sql.toString();
	
	}

	//used
	public static String createSelectString(Class<?> clazz, String tableName, Criteria criteria,Order order, String... properties) {
		if (clazz==null) {return null;}
		StringBuilder sql = new StringBuilder("SELECT ");
		int i = 0;
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		LinkedHashMap<String, String> columns=cMetadata.getColumns();	
		if (ObjectUtil.isNotEmpty(properties) && (properties.length > 0)) {
			for (String property : properties) {
				if (StringUtil.isNotEmpty(property)) {
					if (i > 0) {sql.append(", ");}
					sql.append(pMetadata.containsKey(property)?pMetadata.get(property).getColumn():columns.containsKey(property.toUpperCase())?pMetadata.get(columns.get(property.toUpperCase())).getColumn():property);
					i++;					
				}
			}
		} else {
			for (PropertyMetadata propertyMetada :pMetadata.values()) {
				if (!propertyMetada.isDbField()) {continue;}
				if (i > 0) {sql.append(", ");}
				sql.append(propertyMetada.getColumn());
				i++;
			}
		}
		sql.append(" FROM ").append(StringUtil.isNullOrEmpty(tableName) ? cMetadata.getTable() : tableName);
		if (criteria != null && criteria.getCriteria()!=null&&criteria.getCriteria().size() >0){ sql.append(" WHERE ").append(criteria.toSql(cMetadata, PREFIXINSQL));}				
		if(order!=null) { sql.append(order.toString());}
		return sql.toString();
	}
	
	public static StringBuilder createSelectStringNoWhere(Class<?> clazz, String tableName, String... properties) {
		if (clazz==null) {return null;}
		StringBuilder sql = new StringBuilder("SELECT ");
		int i = 0;
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		LinkedHashMap<String, String> columns=cMetadata.getColumns();	
		if (ObjectUtil.isNotEmpty(properties) && (properties.length > 0)) {
			for (String property : properties) {
				if (StringUtil.isNotEmpty(property)) {
					if (i > 0) {sql.append(", ");}
					sql.append(pMetadata.containsKey(property)?pMetadata.get(property).getColumn():columns.containsKey(property.toUpperCase())?pMetadata.get(columns.get(property.toUpperCase())).getColumn():property);
					i++;					
				}
			}
		} else {
			for (PropertyMetadata propertyMetada :pMetadata.values()) {
				if (!propertyMetada.isDbField()) {continue;}
				if (i > 0) {sql.append(", ");}
				sql.append(propertyMetada.getColumn());
				i++;
			}
		}
		sql.append(" FROM ").append(StringUtil.isNullOrEmpty(tableName) ? cMetadata.getTable() : tableName);
		return sql;
	}
	
	//used
	public static void buildSingleColumnString(Class<?> clazz, Criteria criteria, String tableName, String sumPropertyName,StringBuilder sql) {		
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, PropertyMetadata> pMetadata = cMetadata.getProperty();
		LinkedHashMap<String, String> columns = cMetadata.getColumns();
		String column = sumPropertyName;
		if (pMetadata.containsKey(sumPropertyName)) {
			column = pMetadata.get(sumPropertyName).getColumn();
		} else if (columns.containsKey(sumPropertyName.toUpperCase())) {
			column = pMetadata.get(columns.get(sumPropertyName.toUpperCase())).getColumn();
		}
		sql.append(column).append(")").append(" FROM ").append(StringUtil.isNullOrEmpty(tableName) ? cMetadata.getTable() : tableName);
		if (criteria != null && criteria.getCriteria() != null && criteria.getCriteria().size() > 0) {
			sql.append(" WHERE ").append(criteria.toSql(cMetadata, SqlBuilder.PREFIXINSQL));
		}		
	}
	

	//used
	public static SqlParameterSource getSqlParameterSource(Criteria criteria) {
		if (criteria == null || criteria.getCriteria() == null || criteria.getCriteria().size() < 1) {return null;}
		Map<String, SqlParameter> map = criteria.getParameterMap();
		if (map == null || map.size() < 1) {return null;}
		MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		for (String name : map.keySet()) {
			sqlParameterSource.addValue(name, map.get(name).getValue(), map.get(name).getSqlType());
		}
		return sqlParameterSource;
	}

	//used
	public static SqlParameterSource[] getSqlParameterSourcesByMap(List<? extends Map<String, Object>> list, String... properties) {
		if (list==null||list.size()<1) {return null;}
		SqlParameterSource[] sqlParameterSources=new SqlParameterSource[list.size()];
		int j=0;
		for (Map<String, Object> t:list) {
			sqlParameterSources[j]=SqlBuilder.getSqlParameterSourceByMap(t, properties);
			j++;
		}
		return sqlParameterSources;
	}

	//used
	public static SqlParameterSource getSqlParameterSourceByMap(Map<String, Object> map, String... properties) {
		if (ObjectUtil.isNullOrEmpty(map)) {return null;}
		MapSqlParameterSource sps = new MapSqlParameterSource();
		if (properties == null || properties.length <= 0) {
			for (String key : map.keySet()) {
				buildMapSqlParameterSource(key, map.get(key), sps);
			}
		} else {
			for (String propertyName : properties) {
				buildMapSqlParameterSource(propertyName, map.get(propertyName), sps);
			}
		}
		return sps;
	}

	//used
	public static <T> SqlParameterSource[] getSqlParameterSources(List<T> list, String... properties) {
		if (list==null||list.size()<1) {return null;}
		SqlParameterSource[] sqlParameterSources=new SqlParameterSource[list.size()];		
		int i=0;
		for(T t:list){		
			sqlParameterSources[i]=getSqlParameterSource(t,properties);
			i++;
		}		
		return sqlParameterSources;
	}

	//used
	public static <T> SqlParameterSource getSqlParameterSource(T entity, String... properties) {
		if (ObjectUtil.isNullOrEmpty(entity)) {return null;}		
		ClassMetadata cMetadata = ClassMetadata.getMetadata(entity.getClass());
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		LinkedHashMap<String, String> columns=cMetadata.getColumns();
		ConvertingWrapDynaBean dynaBean=new ConvertingWrapDynaBean(entity);
		if (properties == null || properties.length < 1) {
			return new BeanPropertySqlParameterSource(entity);
		} else {
			MapSqlParameterSource sps = new MapSqlParameterSource();
			for (String property : properties) {
				String pName =pMetadata.containsKey(property)?pMetadata.get(property).getName():columns.containsKey(property.toUpperCase())?pMetadata.get(columns.get(property.toUpperCase())).getName():property;
				Object value = dynaBean.get(property);
				buildMapSqlParameterSource(pName, value, sps);
			}
			return sps;
		}		
	}

	//used
	private static void buildMapSqlParameterSource(String parameterName,Object value ,MapSqlParameterSource sps) {		
		if (value == null) {
			sps.addValue(parameterName, value, 0, null);
		} else {
			Class<?> pClazz = ObjectUtil.isArray(value) ? value.getClass().getDeclaringClass() : value.getClass();
			sps.addValue(parameterName, value, ObjectUtil.javaTypeToSqlParameterType(pClazz), pClazz.getName());
		}
	}

	public static String getUnderscoreString(String strCamel) {
		StringBuilder sb = new StringBuilder();
		if (strCamel != null && strCamel.length() > 0) {
			sb.append(strCamel.substring(0, 1));
			// sb.append(strCamel.substring(0, 1).toLowerCase());
			for (int i = 1; i < strCamel.length(); i++) {
				String preS = strCamel.substring(i - 1, i);
				String s = strCamel.substring(i, i + 1);
				boolean isDigit = s.matches("[0-9]+");
				if (s.equals(s.toUpperCase()) && !isDigit && preS.equals(preS.toLowerCase()) && !preS.equals("_") && !s.equals("_")) {
					sb.append("_");
					sb.append(s.toLowerCase());
				} else {
					sb.append(s);
				}
			}
		}
		return sb.toString();
	}
	
	public static void buildWhereStatement(Class<?> clazz, StringBuilder sql, Criteria criteria) {
		if (criteria == null || criteria.getCriteria() == null || criteria.getCriteria().size() < 1) {
			return;
		}
		if (sql == null) {
			sql = new StringBuilder();
		}
		sql.append(" WHERE ").append(criteria.toSql(ClassMetadata.getMetadata(clazz), PREFIXINSQL)).toString();
	}
	
	public static void buildOrderStatement(StringBuilder sql, String orderStr) {
		if (sql != null) sql.append(" ORDER BY ").append(orderStr);
	}

	/**
	 * 拼接where条件
	 * @param criteria
	 * @param searchOrgColumn
	 * @param organColumn
	 * @param yearColumn
	 * @param year
	 * @param month
	 * @param sqlParameterSource
	 * @param type
	 * @return
	 */
	public static Map<String, Object> buildOrganCondition(Criteria criteria, String searchOrgColumn, String organColumn, String yearColumn, String year, String month, MapSqlParameterSource sqlParameterSource, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuilder where = new StringBuilder();
		String gbCode=(String)criteria.get("gbcode");
		String centerOrgCode=(String)criteria.get("centerOrgCode");
		String orgCode=(String)criteria.get("orgCode");
		if(ObjectUtil.isNotEmpty(searchOrgColumn)) {
			if(ObjectUtil.isNotEmpty(orgCode) ){
				where.append(" AND ").append(searchOrgColumn).append(" =:orgCode");
				sqlParameterSource.addValue("orgCode", orgCode);
			}else if(ObjectUtil.isNotEmpty(centerOrgCode)&& ObjectUtil.isNullOrEmpty(orgCode)) {
				where.append(" AND (").append(searchOrgColumn).append(" =:centerOrgCode");
				where.append(" OR ").append(organColumn).append(" =:centerOrgCode )");
				sqlParameterSource.addValue("centerOrgCode", centerOrgCode);
			}else if(ObjectUtil.isNotEmpty(gbCode)&&ObjectUtil.isNullOrEmpty(centerOrgCode)&& ObjectUtil.isNullOrEmpty(orgCode)) {
				where.append(" AND ").append(searchOrgColumn).append(" =:gbcode");
				sqlParameterSource.addValue("gbcode", gbCode);
			}
		}

		if(ObjectUtil.isNotEmpty(year) && ObjectUtil.isNotEmpty(month) && Integer.parseInt(month) != 0){
			List<String> date=new ArrayList<>();
			//type为1 按找季度筛选日期 这季度的第一天到最后一天
			if(type == 1){
				if("01".equals(month) || "1".equals(month)){
					date.add(year+"0101");
					date.add(year+"0331");
				}else if("02".equals(month) || "2".equals(month)){
					date.add(year+"0401");
					date.add(year+"0630");
				}else if("03".equals(month) || "3".equals(month)){
					date.add(year+"0701");
					date.add(year+"0930");
				}else{
					date.add(year+"1001");
					date.add(year+"1231");
				}
				where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" >=:day1");
				where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day2");
				sqlParameterSource.addValue("day1", date.get(0));
				sqlParameterSource.addValue("day2", date.get(1));
			}else if(type == 3){
				if("01".equals(month)){
					date.add("1");
				}else if("02".equals(month)){
					date.add("1");
					date.add("2");
				}else if("03".equals(month)){
					date.add("1");
					date.add("2");
					date.add("3");
				}
					where.append(" AND ").append(yearColumn).append(" =:year");
				if("b.UPDATE_DATE".equals(yearColumn)) {
					where.append(" AND ").append("e.CREATE_DATE").append(" =:year");
				}
				sqlParameterSource.addValue("year", year);

			}else if(type == 5){
				if("01".equals(month) || "1".equals(month)){
					date.add(year+"0331");
				}else if("02".equals(month) || "2".equals(month)){
					date.add(year+"0630");
				}else if("03".equals(month) || "3".equals(month)){
					date.add(year+"0930");
				}else{
					date.add(year+"1231");
				}
				where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day");
				if("b.UPDATE_DATE".equals(yearColumn)) {
					where.append(" AND TO_CHAR(").append("e.CREATE_DATE").append(", 'YYYYMMDD')").append(" <=:day");
				}
				sqlParameterSource.addValue("day", date.get(0));
			}else if(type == 6){
				if("01".equals(month) || "1".equals(month)){
					date.add(year+"0331");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day");
					sqlParameterSource.addValue("day", date.get(0));
					
				}else if("02".equals(month) || "2".equals(month)){
					date.add(year+"0101");
					date.add(year+"0331");
					date.add(year+"0401");
					date.add(year+"0630");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" >='"+year+"0401"+"'");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <='"+year+"0630"+"'");
					where.append(" AND PERSON_ID in  (SELECT PERSON_ID FROM DM_HYPERTENSION_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(0)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(1)+"'))");;
					
					
				}else if("03".equals(month) || "3".equals(month)){
					date.add(year+"0101");
					date.add(year+"0331");
					date.add(year+"0401");
					date.add(year+"0630");
					date.add(year+"0701");
					date.add(year+"1031");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" >='"+year+"0701"+"'");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <='"+year+"1031"+"'");
					where.append(" AND PERSON_ID in  (SELECT PERSON_ID FROM DM_HYPERTENSION_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(2)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(3)+"')"
							+ "AND PERSON_ID in  (SELECT PERSON_ID FROM DM_HYPERTENSION_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(0)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(1)+"')"
							+ "))");;

				}else{
					date.add(year+"0101");
					date.add(year+"0331");
					date.add(year+"0401");
					date.add(year+"0630");
					date.add(year+"0701");
					date.add(year+"0930");
					date.add(year+"1001");
					date.add(year+"1231");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" >='"+year+"1001"+"'");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <='"+year+"1231"+"'");
					where.append(" AND PERSON_ID in  (SELECT PERSON_ID FROM DM_HYPERTENSION_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(4)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(5)+"')"
							+ "AND PERSON_ID in  (SELECT PERSON_ID FROM DM_HYPERTENSION_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(2)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(3)+"')"
							+ "AND PERSON_ID in  (SELECT PERSON_ID FROM DM_HYPERTENSION_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(0)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(1)+"')"
							+ ")))");;
					
				}
				
//				for(int i=0; i<date.size(); i++){
//					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day");
//					if("b.UPDATE_DATE".equals(yearColumn)) {
//						where.append(" AND TO_CHAR(").append("e.CREATE_DATE").append(", 'YYYYMMDD')").append(" <=:day");
//					}
//					sqlParameterSource.addValue("day", date.get(i));
//				}
				
				
				
			}else if(type == 7){
				if("01".equals(month) || "1".equals(month)){
					date.add(year+"0331");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day");
					sqlParameterSource.addValue("day", date.get(0));
					
				}else if("02".equals(month) || "2".equals(month)){
					date.add(year+"0101");
					date.add(year+"0331");
					date.add(year+"0401");
					date.add(year+"0630");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" >='"+year+"0401"+"'");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <='"+year+"0630"+"'");
					where.append(" AND PERSON_ID in  (SELECT PERSON_ID FROM DM_DIABETIC_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(0)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(1)+"'))");;
					
					
				}else if("03".equals(month) || "3".equals(month)){
					date.add(year+"0101");
					date.add(year+"0331");
					date.add(year+"0401");
					date.add(year+"0630");
					date.add(year+"0701");
					date.add(year+"1031");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" >='"+year+"0701"+"'");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <='"+year+"1031"+"'");
					where.append(" AND PERSON_ID in  (SELECT PERSON_ID FROM DM_DIABETIC_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(2)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(3)+"')"
							+ "AND PERSON_ID in  (SELECT PERSON_ID FROM DM_DIABETIC_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(0)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(1)+"')"
							+ "))");;

				}else{
					date.add(year+"0101");
					date.add(year+"0331");
					date.add(year+"0401");
					date.add(year+"0630");
					date.add(year+"0701");
					date.add(year+"0930");
					date.add(year+"1001");
					date.add(year+"1231");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" >='"+year+"1001"+"'");
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <='"+year+"1231"+"'");
					where.append(" AND PERSON_ID in  (SELECT PERSON_ID FROM DM_DIABETIC_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(4)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(5)+"')"
							+ "AND PERSON_ID in  (SELECT PERSON_ID FROM DM_DIABETIC_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(2)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(3)+"')"
							+ "AND PERSON_ID in  (SELECT PERSON_ID FROM DM_DIABETIC_FOLLOWUP where  (TO_CHAR("+yearColumn+", 'YYYYMMDD') >= '"+date.get(0)+"' and TO_CHAR("+yearColumn+", 'YYYYMMDD') <= '"+date.get(1)+"')"
							+ ")))");;
					
				}
				
//				for(int i=0; i<date.size(); i++){
//					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day");
//					if("b.UPDATE_DATE".equals(yearColumn)) {
//						where.append(" AND TO_CHAR(").append("e.CREATE_DATE").append(", 'YYYYMMDD')").append(" <=:day");
//					}
//					sqlParameterSource.addValue("day", date.get(i));
//				}
				
				
				
			}
		}else if (ObjectUtil.isNotEmpty(year)){
			if(type == 3){
				where.append(" AND ").append(yearColumn).append(" =:year");
				if("b.UPDATE_DATE".equals(yearColumn)) {
					where.append(" AND ").append("e.CREATE_DATE").append(" =:year");
				}
				sqlParameterSource.addValue("year", year);
			}else if(type == 5){
				where.append(" AND  TO_CHAR(").append(yearColumn).append(", 'YYYY')").append(" <=:year");
				if("b.UPDATE_DATE".equals(yearColumn)) {
					where.append(" AND  TO_CHAR(").append("e.CREATE_DATE").append(", 'YYYY')").append(" <=:year");
				}
				sqlParameterSource.addValue("year", year);
			}
		}
		map.put(WHERE, where.toString());
		map.put(SOURCE, sqlParameterSource);
		return map;
	}
	
	public static Map<String, Object> buildOrganCondition(String orgCodeColumn,String yearColumn,String quarterColumn, String manageColumn
			, String orgCode,String year, String month,List<String>organCodeList
			, MapSqlParameterSource sqlParameterSource, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuilder where = new StringBuilder();
		if(ObjectUtil.isNotEmpty(orgCode) && organCodeList==null){
			where.append(" AND ").append(orgCodeColumn).append(" =:createOrgCode");
			sqlParameterSource.addValue("createOrgCode", orgCode);
		}else{
			if(ObjectUtil.isNotEmpty(organCodeList)){
				where.append(" AND ").append(orgCodeColumn).append(" IN(:createOrgCode)");
				sqlParameterSource.addValue("createOrgCode", organCodeList);
			}
		}
		if(ObjectUtil.isNotEmpty(manageColumn)){
			where.append(" AND ").append(manageColumn).append(" IS NOT NULL ");
		}
		
		if(ObjectUtil.isNotEmpty(year)==true && ObjectUtil.isNotEmpty(month)==true && Integer.parseInt(month) != 0){
			List<String> date=new ArrayList<>();
			
			if(type == 1){//按时间段查询
				if("01".equals(month) || "1".equals(month)){
					date.add(year+"0331");
				}else if("02".equals(month) || "2".equals(month)){
					date.add(year+"0630");
				}else if("03".equals(month) || "3".equals(month)){
					date.add(year+"0930");
				}else{
					date.add(year+"1231");
				}
				if("b.UPDATE_DATE".equals(yearColumn)) {
					where.append(" AND  TO_CHAR(").append(yearColumn).append(", 'YYYY')").append(" =:year");
					sqlParameterSource.addValue("year", year);
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day");
					sqlParameterSource.addValue("day", date.get(0));
				}else {
					where.append(" AND  TO_CHAR(").append(yearColumn).append(", 'YYYY')").append(" =:year");
					sqlParameterSource.addValue("year", year);
					where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day");
					sqlParameterSource.addValue("day", date.get(0));
				}
			}else if(type == 2){//按月份查询
				if("01".equals(month) || "1".equals(month)){
					date.add(year+"01");
					date.add(year+"02");
					date.add(year+"03");
				}else if("02".equals(month) || "2".equals(month)){
					date.add(year+"04");
					date.add(year+"05");
					date.add(year+"06");
				}else if("03".equals(month) || "3".equals(month)){
					date.add(year+"07");
					date.add(year+"08");
					date.add(year+"09");
				}else{
					date.add(year+"10");
					date.add(year+"11");
					date.add(year+"12");
				}
				if("b.UPDATE_DATE".equals(yearColumn)) {
					where.append(" AND ( TO_CHAR(").append(yearColumn).append(", 'YYYYMM')").append(" =:year1");
					sqlParameterSource.addValue("year1", date.get(0));
					where.append(" OR  TO_CHAR(").append(yearColumn).append(", 'YYYYMM')").append(" =:year2");
					sqlParameterSource.addValue("year2", date.get(1));
					where.append(" OR  TO_CHAR(").append(yearColumn).append(", 'YYYYMM')").append(" =:year3)");
					sqlParameterSource.addValue("year3", date.get(2));
				}else {
					where.append(" AND ( TO_CHAR(").append(yearColumn).append(", 'YYYYMM')").append(" =:year1");
					sqlParameterSource.addValue("year1", date.get(0));
					where.append(" OR  TO_CHAR(").append(yearColumn).append(", 'YYYYMM')").append(" =:year2");
					sqlParameterSource.addValue("year2", date.get(1));
					where.append(" OR  TO_CHAR(").append(yearColumn).append(", 'YYYYMM')").append(" =:year3)");
					sqlParameterSource.addValue("year3", date.get(2));
				}
				
			}else if(type == 3){//按季度查询
				if("01".equals(month)){
					date.add("1");
				}else if("02".equals(month)){
					date.add("1");
					date.add("2");
				}else if("03".equals(month)){
					date.add("1");
					date.add("2");
					date.add("3");
				}
					where.append(" AND ").append(yearColumn).append(" =:year");
				sqlParameterSource.addValue("year", year);
				
				for(int i=0; i<date.size(); i++){
					where.append(" AND ").append(quarterColumn).append(" =:month" + i);
					sqlParameterSource.addValue("month" + i, date.get(i));
				}
			}else if(type == 4){
				where.append(" AND ").append(yearColumn).append(" =:year");
				sqlParameterSource.addValue("year", year);
				
				where.append(" AND ").append(quarterColumn).append(" <=:quarter");
				sqlParameterSource.addValue("quarter", month);
			}else if(type == 5){
				if("01".equals(month) || "1".equals(month)){
					date.add(year+"0331");
				}else if("02".equals(month) || "2".equals(month)){
					date.add(year+"0630");
				}else if("03".equals(month) || "3".equals(month)){
					date.add(year+"0930");
				}else{
					date.add(year+"1231");
				}
				where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day");
				sqlParameterSource.addValue("day", date.get(0));
			}
		}else if (ObjectUtil.isNotEmpty(year)==true){
			if(type == 1 || type == 2){
				
				where.append(" AND  TO_CHAR(").append(yearColumn).append(", 'YYYY')").append(" =:year");
				sqlParameterSource.addValue("year", year);
			}else if(type == 3 || type == 4){
				where.append(" AND ").append(yearColumn).append(" =:year");
				sqlParameterSource.addValue("year", year);
			}else if(type == 5){
				where.append(" AND  TO_CHAR(").append(yearColumn).append(", 'YYYY')").append(" <=:year");
				sqlParameterSource.addValue("year", year);
			}
		}
		map.put(WHERE, where.toString());
		map.put(SOURCE, sqlParameterSource);
		return map;
	}
	
	public static Map<String, Object> buildOrganConditions(String orgCodeColumn,String yearColumn,String brithdayColumn,String quarterColumn, String manageColumn
			, String orgCode,String year, String month,String brithday,List<String>organCodeList
			, MapSqlParameterSource sqlParameterSource, Integer type) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuilder where = new StringBuilder();
		where.append(" AND TO_CHAR(").append(brithdayColumn).append(", 'yyyy-mm-dd')").append(" <=:brithday");
		//where.append(" AND ").append(brithdayColumn).append(" <:brithday");
		sqlParameterSource.addValue("brithday", brithday);
		if(ObjectUtil.isNotEmpty(orgCode) && organCodeList==null){
			where.append(" AND ").append(orgCodeColumn).append(" =:createOrgCode");
			sqlParameterSource.addValue("createOrgCode", orgCode);
		}else{
			if(ObjectUtil.isNotEmpty(organCodeList)){
				where.append(" AND ").append(orgCodeColumn).append(" IN(:createOrgCode)");
				sqlParameterSource.addValue("createOrgCode", organCodeList);
			}
		}

		if(ObjectUtil.isNotEmpty(manageColumn)){
			where.append(" AND ").append(manageColumn).append(" IS NOT NULL ");
		}
		
		if(ObjectUtil.isNotEmpty(year)==true && ObjectUtil.isNotEmpty(month)==true && Integer.parseInt(month) != 0){
			List<String> date=new ArrayList<>();
			
			if(type == 1){//按时间段查询
				if("01".equals(month) || "1".equals(month)){
					date.add(year+"0331");
				}else if("02".equals(month) || "2".equals(month)){
					date.add(year+"0630");
				}else if("03".equals(month) || "3".equals(month)){
					date.add(year+"0930");
				}else{
					date.add(year+"1231");
				}
				where.append(" AND  TO_CHAR(").append(yearColumn).append(", 'YYYY')").append(" <=:year");
				sqlParameterSource.addValue("year", year);
				
				where.append(" AND TO_CHAR(").append(yearColumn).append(", 'YYYYMMDD')").append(" <=:day");
				sqlParameterSource.addValue("day", date.get(0));
			}else if(type == 2){//按月份查询
				if("01".equals(month) || "1".equals(month)){
					date.add(year+"01");
					date.add(year+"02");
					date.add(year+"03");
				}else if("02".equals(month) || "2".equals(month)){
					date.add(year+"04");
					date.add(year+"05");
					date.add(year+"06");
				}else if("03".equals(month) || "3".equals(month)){
					date.add(year+"07");
					date.add(year+"08");
					date.add(year+"09");
				}else{
					date.add(year+"10");
					date.add(year+"11");
					date.add(year+"12");
				}
				where.append(" AND ( TO_CHAR(").append(yearColumn).append(", 'YYYYMM')").append(" <=:year1");
				sqlParameterSource.addValue("year1", date.get(0));
				where.append(" OR  TO_CHAR(").append(yearColumn).append(", 'YYYYMM')").append(" <=:year2");
				sqlParameterSource.addValue("year2", date.get(1));
				where.append(" OR  TO_CHAR(").append(yearColumn).append(", 'YYYYMM')").append(" <=:year3)");
				sqlParameterSource.addValue("year3", date.get(2));
			}else if(type == 3){//按季度查询
				if("01".equals(month)){
					date.add("1");
				}else if("02".equals(month)){
					date.add("1");
					date.add("2");
				}else if("03".equals(month)){
					date.add("1");
					date.add("2");
					date.add("3");
				}
				
				where.append(" AND ").append(yearColumn).append(" <=:year");
				sqlParameterSource.addValue("year", year);
				
				for(int i=0; i<date.size(); i++){
					where.append(" AND ").append(quarterColumn).append(" <=:month" + i);
					sqlParameterSource.addValue("month" + i, date.get(i));
				}
			}else if(type == 4){
				
				where.append(" AND ").append(yearColumn).append(" <=:year");
				sqlParameterSource.addValue("year", year);
				
				where.append(" AND ").append(quarterColumn).append(" <=:quarter");
				sqlParameterSource.addValue("quarter", month);
			}
		}else if (ObjectUtil.isNotEmpty(year)==true){
			if(type == 1 || type == 2){
				where.append(" AND  TO_CHAR(").append(yearColumn).append(", 'YYYY')").append(" <=:year");
				sqlParameterSource.addValue("year", year);
			}else if(type == 3 || type == 4){
				where.append(" AND ").append(yearColumn).append(" <=:year");
				sqlParameterSource.addValue("year", year);
			}
		}
		map.put(WHERE, where.toString());
		map.put(SOURCE, sqlParameterSource);
		return map;
	}
}
