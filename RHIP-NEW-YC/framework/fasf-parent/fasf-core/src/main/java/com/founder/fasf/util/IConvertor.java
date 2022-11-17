package com.founder.fasf.util;

import java.util.Collection;


public interface IConvertor {
	public Object getValue(Object value);
	public Object[] getArray(Object[] value);
	@SuppressWarnings("rawtypes")
	public Collection getCollection(Object[] value);
}
