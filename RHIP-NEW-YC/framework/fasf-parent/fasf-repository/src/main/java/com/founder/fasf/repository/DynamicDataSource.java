package com.founder.fasf.repository;

import java.util.logging.Logger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{  
	  
    static Logger log=Logger.getLogger("DynamicDataSource");  
    
    protected Object determineCurrentLookupKey() {  
        return DbContextHolder.getDbType();  
    }

	@Override
	public Logger getParentLogger() {
		return null;
	}  
  
}  
