
package com.founder.fasf.beans;

public class SqlParameter {

	/** SQL type constant from <code>java.sql.Types</code> */
	private int sqlType;

	/**
	 * Used for types that are user-named like: STRUCT, DISTINCT, JAVA_OBJECT,
	 * named array types
	 */
	private String typeName;

	/** The scale to apply in case of a NUMERIC or DECIMAL type, if any */
	private Integer scale;

	private String name;

	private Object value;

	public SqlParameter(String name,Object value, String typeName,int sqlType,Integer scale) {
		this.name=name;
		this.value=value;
		this.typeName=typeName;
		this.sqlType=sqlType;
		this.scale=scale;
	}

	public String getName() {
		return name;
	}

	public Integer getScale() {
		return scale;
	}

	public final int getSqlType() {
		return sqlType;
	}

	public String getTypeName() {
		return typeName;
	}

	public Object getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public void setSqlType(int sqlType) {
		this.sqlType = sqlType;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
