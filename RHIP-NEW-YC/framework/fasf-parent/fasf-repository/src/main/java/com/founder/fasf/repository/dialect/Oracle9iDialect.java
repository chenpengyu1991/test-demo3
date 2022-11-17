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

/**
 * A dialect for Oracle 9i databases.
 * <p/>
 * Unlike the older (deprecated) {@link Oracle9Dialect), this version specifies
 * to not use "ANSI join syntax" because 9i does not seem to properly
 * handle it in all cases.
 *
 * @author Steve Ebersole
 */
public class Oracle9iDialect extends Oracle8iDialect {

	public String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
		String forUpdateClause = null;
		boolean isForUpdate = false;
		final int forUpdateIndex = sql.toUpperCase().lastIndexOf("FOR UPDATE");
		if (forUpdateIndex > -1) {
			// save 'for update ...' and then remove it
			forUpdateClause = sql.substring(forUpdateIndex);
			sql = sql.substring(0, forUpdateIndex - 1);
			isForUpdate = true;
		}
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		pagingSelect.append("SELECT * FROM ( SELECT ROW_.*, ROWNUM ROWNUM_ FROM ( ");
		pagingSelect.append(sql);
		//必须保证排序唯一
		pagingSelect.append(" ) ROW_ WHERE ROWNUM <=").append(offset + limit).append(" ) WHERE ").append("  ROWNUM_ > ").append(offset);
		//pagingSelect.append(" ) ROW_ ) WHERE  ROWNUM_ >").append(offset).append(" AND ROWNUM_ <= ").append(offset + limit);
		if (isForUpdate) {
			pagingSelect.append(" ");
			pagingSelect.append(forUpdateClause);
		}
		return pagingSelect.toString();
	}

	public String getCurrentTimestampSelectString() {
		return "SELECT SYSTIMESTAMP FROM DUAL";
	}

	public String getCurrentTimestampSQLFunctionName() {
		// the standard SQL function name is current_timestamp...
		return "CURRENT_TIMESTAMP";
	}

	// locking support
	public String getForUpdateString() {
		return " FOR UPDATE";
	}

	/**
	 * HHH-4907, I don't know if oracle 8 supports this syntax, so I'd think it
	 * is better add this method here. Reopen this issue if you found/know 8
	 * supports it.
	 */
	public boolean supportsRowValueConstructorSyntaxInInList() {
		return true;
	}

	public boolean supportsTupleDistinctCounts() {
		return false;
	}
}
