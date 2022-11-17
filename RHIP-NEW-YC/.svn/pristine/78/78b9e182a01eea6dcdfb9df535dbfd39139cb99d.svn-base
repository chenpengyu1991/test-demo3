package com.founder.fasf.repository;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class DbContextHolder {
	private static final ThreadLocal contextHolder = new ThreadLocal();
	
	public static void setDbType(String dbType){
		contextHolder.set(dbType);
	}
	
	public static String getDbType(){
		return (String)contextHolder.get();
	}
	
	public static void clearDbType(){
		contextHolder.remove();
	}

    public static void setJdbcTemplate(SimpleJdbcTemplate simpleJdbcTemplate) {
         contextHolder.set(simpleJdbcTemplate);
    }

    public static SimpleJdbcTemplate getJdbcTmplate() {
        return (SimpleJdbcTemplate)contextHolder.get();
    }

}

