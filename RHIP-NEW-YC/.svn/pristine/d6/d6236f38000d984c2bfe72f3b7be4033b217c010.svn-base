package com.founder.mapper.base;



/**
 * 所有的Mapper继承这个接口
 * @author GaoFei
 *
 * @param <T>
 */
public interface BaseMapper<T> {
	
	  int deleteByPrimaryKey(Long id);
	  
	  T selectByPrimaryKey(Long id);
	  
	  int insert( T t);
	  
	  int insertSelective(T t);
	  
	  int updateByPrimaryKeySelective(T t);
	  
	  int updateByPrimaryKey(T t);
}
