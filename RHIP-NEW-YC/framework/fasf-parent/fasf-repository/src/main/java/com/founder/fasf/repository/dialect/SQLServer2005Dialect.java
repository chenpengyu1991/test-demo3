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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A dialect for Microsoft SQL 2005. (HHH-3936 fix)
 * 
 * @author Yoryos Valotasios
 */
public class SQLServer2005Dialect extends SQLServerDialect {

	private static final String SELECT = "select";

	private static final String FROM = "from";

	private static final String DISTINCT = "distinct";

	/*@SuppressWarnings("unused")
	private static final int MAX_LENGTH = 8000;*/

	/**
	 * Regular expression for stripping alias
	 */
	private static final Pattern ALIAS_PATTERN = Pattern.compile("\\sas[^,]+(,?)");

	public SQLServer2005Dialect() {
	}

	@Override
	public boolean supportsLimitOffset() {
		return true;
	}

	@Override
	public boolean bindLimitParametersFirst() {
		return false;
	}

	@Override
	public boolean supportsVariableLimit() {
		return true;
	}

	@Override
	public int convertToFirstRowValue(int zeroBasedFirstResult) {
		// Our dialect paginated results aren't zero based. The first row should
		// get the number 1 and so on
		return zeroBasedFirstResult + 1;
	}

/*	@Override
	public String getLimitString(String query, int offset, int limit) {
		// We transform the query to one with an offset and limit if we have an
		// offset and limit to bind
		if (offset > 1 || limit > 1) {
			return getLimitString(query, true);
		}
		return query;
	}*/

	/**
	 * Add a LIMIT clause to the given SQL SELECT (HHH-2655: ROW_NUMBER for
	 * Paging)
	 * 
	 * The LIMIT SQL will look like:
	 * 
	 * <pre>
	 * WITH query AS (
	 *   SELECT ROW_NUMBER() OVER (ORDER BY orderby) as _row_nr__,
	 *   original_query_without_orderby
	 * )
	 * SELECT * FROM query WHERE _row_nr_ BEETWIN offset AND offset + last
	 * </pre>
	 * 
	 * @param querySqlString
	 *            The SQL statement to base the limit query off of.
	 * @param hasOffset
	 *            Is the query requesting an offset?
	 * 
	 * @return A new SQL statement with the LIMIT clause applied.
	 */
	@Override
	public String getLimitString(String querySqlString, int offset, int limit) {
		StringBuilder sb = new StringBuilder(querySqlString.trim().toLowerCase());
		int orderByIndex = sb.indexOf("order by");
		CharSequence orderby = orderByIndex > 0 ? sb.subSequence(orderByIndex, sb.length()) : "ORDER BY CURRENT_TIMESTAMP";
		// Delete the order by clause at the end of the query
		if (orderByIndex > 0) {
			sb.delete(orderByIndex, orderByIndex + orderby.length());
		}
		// HHH-5715 bug fix
		replaceDistinctWithGroupBy(sb);
		insertRowNumberFunction(sb, orderby);
		// Wrap the query within a with statement:
		sb.insert(0, "WITH query AS (").append(") SELECT * FROM query ");
		sb.append("WHERE _row_nr_ >= ").append(offset).append(" AND _row_nr_ < ").append(offset+limit);
		return sb.toString();
	}

	/**
	 * Utility method that checks if the given sql query is a select distinct
	 * one and if so replaces the distinct select with an equivalent simple
	 * select with a group by clause. See
	 * {@link SQLServer2005DialectTestCase#testReplaceDistinctWithGroupBy()}
	 * 
	 * @param sql
	 *            an sql query
	 */
	protected static void replaceDistinctWithGroupBy(StringBuilder sql) {
		int distinctIndex = sql.indexOf(DISTINCT);
		if (distinctIndex > 0) {
			sql.delete(distinctIndex, distinctIndex + DISTINCT.length() + 1);
			sql.append(" group by").append(getSelectFieldsWithoutAliases(sql));
		}
	}

	/**
	 * This utility method searches the given sql query for the fields of the
	 * select statement and returns them without the aliases. See
	 * {@link SQLServer2005DialectTestCase#testGetSelectFieldsWithoutAliases()}
	 * 
	 * @param sql
	 *            sql query
	 * 
	 * @return the fields of the select statement without their alias
	 */
	protected static CharSequence getSelectFieldsWithoutAliases(StringBuilder sql) {
		String select = sql.substring(sql.indexOf(SELECT) + SELECT.length(), sql.indexOf(FROM));
		// Strip the as clauses
		return stripAliases(select);
	}

	/**
	 * Utility method that strips the aliases. See
	 * {@link SQLServer2005DialectTestCase#testStripAliases()}
	 * 
	 * @param str
	 *            string to replace the as statements
	 * 
	 * @return a string without the as statements
	 */
	protected static String stripAliases(String str) {
		Matcher matcher = ALIAS_PATTERN.matcher(str);
		return matcher.replaceAll("$1");
	}

	/**
	 * Right after the select statement of a given query we must place the
	 * row_number function
	 * 
	 * @param sql
	 *            the initial sql query without the order by clause
	 * @param orderby
	 *            the order by clause of the query
	 */
	protected static void insertRowNumberFunction(StringBuilder sql, CharSequence orderby) {
		// Find the end of the select statement
		int selectEndIndex = sql.indexOf(FROM);
		// Insert after the select statement the row_number() function:
		sql.insert(selectEndIndex - 1, ", ROW_NUMBER() OVER (" + orderby + ") as _row_nr_");
	}
}
