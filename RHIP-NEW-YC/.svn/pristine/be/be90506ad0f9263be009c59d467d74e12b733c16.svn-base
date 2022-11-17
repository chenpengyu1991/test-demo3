package com.founder.fasf.repository;

import java.util.HashMap;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class JdbcTemplateCache {
	   static HashMap<String,SimpleJdbcTemplate> jdbcTemplateCacheMap = new HashMap<>(500);
	    public static void put(String key, SimpleJdbcTemplate simpleJdbcTemplate) {
	           jdbcTemplateCacheMap.put(key,simpleJdbcTemplate);
	    }
	    public static SimpleJdbcTemplate get (String key) {
	           return jdbcTemplateCacheMap.get(key);
	    }
}
