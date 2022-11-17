package com.founder.fasf.repository;

public class BeforeAdvice {
	public void setMultiDataSource() {
		DbContextHolder.setDbType("dataSourceB");
	}

}
