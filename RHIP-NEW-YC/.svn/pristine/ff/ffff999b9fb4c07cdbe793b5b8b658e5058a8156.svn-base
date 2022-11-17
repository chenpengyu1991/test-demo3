/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2010, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package com.founder.fasf.repository.dialect;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.founder.fasf.exception.RepositoryException;
import com.founder.fasf.reflect.ReflectUtil;

/**
 * An SQL dialect for Oracle 9 (uses ANSI-style syntax where possible).
 *
 * @author Gavin King, David Channon
 */
public class Oracle9Dialect extends Dialect {

	//private static final Logger LOG = Logger.getLogger(Oracle9Dialect.class.getName());

	public Oracle9Dialect() {
		super();
	}

	public String getAddColumnString() {
		return "add";
	}

	public String getSequenceNextValString(String sequenceName) {
		return "SELECT " + getSelectSequenceNextValString( sequenceName ) + " FROM DUAL";
	}

	public String getSelectSequenceNextValString(String sequenceName) {
		return sequenceName + ".NEXTVAL";
	}

	public String getCreateSequenceString(String sequenceName) {
		return "CREATE SEQUENCE " + sequenceName; //starts with 1, implicitly
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

	public String getLimitString(String sql, int offset, int limit) {

		sql = sql.trim();
		/*		boolean isForUpdate = false;
				if ( sql.toLowerCase().endsWith(" for update") ) {
					sql = sql.substring( 0, sql.length()-11 );
					isForUpdate = true;
				}*/
		 boolean hasOffset=offset>0;
		StringBuffer pagingSelect = new StringBuffer( sql.length()+100 );
		if (hasOffset) {
			pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		}
		else {
			pagingSelect.append("select * from ( ");
		}
		pagingSelect.append(sql);
		if (hasOffset) {
			pagingSelect.append(" ) row_ ) where rownum_ <= ").append(offset+limit).append(" and rownum_ > ").append(offset);
		} else {
			pagingSelect.append(" ) where rownum <= ").append(offset+limit);
		}

/*		if ( isForUpdate ) {
			pagingSelect.append( " for update" );
		}*/

		return pagingSelect.toString();
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
		return "select sequence_name from user_sequences";
	}

	public String getSelectGUIDString() {
		return "select rawtohex(sys_guid()) from dual";
	}



	// not final-static to avoid possible classcast exceptions if using different oracle drivers.
	int oracletypes_cursor_value = 0;
	@SuppressWarnings("rawtypes")
	public int registerResultSetOutParameter(java.sql.CallableStatement statement,int col) throws SQLException {
		if(oracletypes_cursor_value==0) {
			try {
				Class types = ReflectUtil.classForName("oracle.jdbc.driver.OracleTypes");
				oracletypes_cursor_value = types.getField("CURSOR").getInt(types.newInstance());
			} catch (Exception se) {
				throw new RepositoryException("Problem while trying to load or access OracleTypes.CURSOR value",se);
			}
		}
		//	register the type of the out param - an Oracle specific type
		statement.registerOutParameter(col, oracletypes_cursor_value);
		col++;
		return col;
	}

	public ResultSet getResultSet(CallableStatement ps) throws SQLException {
		ps.execute();
		return ( ResultSet ) ps.getObject( 1 );
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

	public String getCurrentTimestampSelectString() {
		return "select systimestamp from dual";
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
