/*
 * Hibernate, Relational Persistence for Idiomatic Java
 * 
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as indicated by
 * the @author tags or express copyright attribution statements applied by the
 * authors. All third-party contributions are distributed under license by Red
 * Hat Inc.
 * 
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to: Free Software Foundation,
 * Inc. 51 Franklin Street, Fifth Floor Boston, MA 02110-1301 USA
 */

package com.founder.fasf.repository.dialect;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.founder.fasf.exception.RepositoryException;
import com.founder.fasf.reflect.ReflectUtil;
import com.founder.fasf.repository.Environment;

/**
 * A dialect for Oracle 8i.
 * 
 * @author Steve Ebersole
 */
public class Oracle8iDialect extends Dialect {

	public Oracle8iDialect() {
		super();
		registerReverseHibernateTypeMappings();
		registerDefaultProperties();
	}

	protected void registerReverseHibernateTypeMappings() {
	}

	protected void registerDefaultProperties() {
		getDefaultProperties().setProperty(Environment.USE_STREAMS_FOR_BINARY, "true");
		getDefaultProperties().setProperty(Environment.STATEMENT_BATCH_SIZE, DEFAULT_BATCH_SIZE);
		getDefaultProperties().setProperty(Environment.USE_GET_GENERATED_KEYS, "false");
	}

	/**
	 * {@inheritDoc}
	 */
	public String getCrossJoinSeparator() {
		return ", ";
	}
	

	public String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
/*		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}*/
		boolean hasOffset=offset>0;
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		if (hasOffset) {
			pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		} else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (hasOffset) {
			pagingSelect.append(" ) row_ ) where rownum_ <= ").append(offset+limit).append(" and rownum_ > ").append(offset);
		} else {
			pagingSelect.append(" ) where rownum <= ").append(offset+limit);
		}
/*		if (isForUpdate) {
			pagingSelect.append(" for update");
		}*/
		return pagingSelect.toString();
		
	}

	public String getSelectClauseNullString(int sqlType) {
		switch (sqlType) {
			case Types.VARCHAR:
			case Types.CHAR:
				return "to_char(null)";
			case Types.DATE:
			case Types.TIMESTAMP:
			case Types.TIME:
				return "to_date(null)";
			default:
				return "to_number(null)";
		}
	}

	public String getCurrentTimestampSelectString() {
		return "select sysdate from dual";
	}

	public String getCurrentTimestampSQLFunctionName() {
		return "sysdate";
	}

	// features which remain constant across 8i, 9i, and 10g ~~~~~~~~~~~~~~~~~~
	public String getAddColumnString() {
		return "add";
	}

	public String getSequenceNextValString(String sequenceName) {
		return "SELECT " + getSelectSequenceNextValString(sequenceName) + " FROM DUAL";
	}

	public String getSelectSequenceNextValString(String sequenceName) {
		return sequenceName + ".NEXTVAL";
	}

	public String getCreateSequenceString(String sequenceName) {
		return "CREATE SEQUENCE " + sequenceName; // starts with 1, implicitly
	}

	public String getDropSequenceString(String sequenceName) {
		return "DROP SEQUENCE " + sequenceName;
	}

	public String getCascadeConstraintsString() {
		return " cascade constraints";
	}

	public boolean dropConstraints() {
		return false;
	}

	public String getForUpdateNowaitString() {
		return " for update nowait";
	}

	public boolean supportsSequences() {
		return true;
	}

	public boolean supportsPooledSequences() {
		return true;
	}

	public boolean supportsLimit() {
		return true;
	}

	public boolean bindLimitParametersInReverseOrder() {
		return true;
	}

	public boolean useMaxForLimit() {
		return true;
	}

	public boolean forUpdateOfColumns() {
		return true;
	}

	public String getQuerySequencesString() {
		return " select sequence_name from all_sequences" + "  union" + " select synonym_name" + "   from all_synonyms us, all_sequences asq"
				+ "  where asq.sequence_name = us.table_name" + "    and asq.sequence_owner = us.table_owner";
	}

	public String getSelectGUIDString() {
		return "select rawtohex(sys_guid()) from dual";
	}

	public static final String ORACLE_TYPES_CLASS_NAME = "oracle.jdbc.OracleTypes";

	public static final String DEPRECATED_ORACLE_TYPES_CLASS_NAME = "oracle.jdbc.driver.OracleTypes";

	public static final int INIT_ORACLETYPES_CURSOR_VALUE = -99;

	// not final-static to avoid possible classcast exceptions if using
	// different oracle drivers.
	private int oracleCursorTypeSqlType = INIT_ORACLETYPES_CURSOR_VALUE;

	public int getOracleCursorTypeSqlType() {
		if (oracleCursorTypeSqlType == INIT_ORACLETYPES_CURSOR_VALUE) {
			// todo : is there really any reason to kkeep trying if this fails
			// once?
			oracleCursorTypeSqlType = extractOracleCursorTypeValue();
		}
		return oracleCursorTypeSqlType;
	}

	@SuppressWarnings("rawtypes")
	protected int extractOracleCursorTypeValue() {
		Class oracleTypesClass;
		try {
			oracleTypesClass = ReflectUtil.classForName(ORACLE_TYPES_CLASS_NAME);
		} catch (ClassNotFoundException cnfe) {
			try {
				oracleTypesClass = ReflectUtil.classForName(DEPRECATED_ORACLE_TYPES_CLASS_NAME);
			} catch (ClassNotFoundException e) {
				throw new RepositoryException("Unable to locate OracleTypes class", e);
			}
		}
		try {
			return oracleTypesClass.getField("CURSOR").getInt(null);
		} catch (Exception se) {
			throw new RepositoryException("Unable to access OracleTypes.CURSOR value", se);
		}
	}

	public int registerResultSetOutParameter(CallableStatement statement, int col) throws SQLException {
		// register the type of the out param - an Oracle specific type
		statement.registerOutParameter(col, getOracleCursorTypeSqlType());
		col++;
		return col;
	}

	public ResultSet getResultSet(CallableStatement ps) throws SQLException {
		ps.execute();
		return (ResultSet) ps.getObject(1);
	}

	public boolean supportsUnionAll() {
		return true;
	}

	public boolean supportsCommentOn() {
		return true;
	}

	public boolean supportsTemporaryTables() {
		return true;
	}

	public String getCreateTemporaryTableString() {
		return "create global temporary table";
	}

	public String getCreateTemporaryTablePostfix() {
		return "on commit delete rows";
	}

	public boolean dropTemporaryTableAfterUse() {
		return false;
	}

	public boolean supportsCurrentTimestampSelection() {
		return true;
	}

	public boolean isCurrentTimestampSelectStringCallable() {
		return false;
	}

	// Overridden informational metadata ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public boolean supportsEmptyInList() {
		return false;
	}

	public boolean supportsExistsInSelect() {
		return false;
	}

}
