
package com.founder.fasf.repository.dialect;

import java.util.Properties;

import com.founder.fasf.exception.RepositoryException;
import com.founder.fasf.reflect.ReflectUtil;
import com.founder.fasf.repository.Environment;

public abstract class Dialect {


	public static final String DEFAULT_BATCH_SIZE = "15";

	public static final String NO_BATCH = "0";

	/**
	 * Characters used for quoting SQL identifiers
	 */
	public static final String QUOTE = "`\"[";

	public static final String CLOSED_QUOTE = "`\"]";

	private final Properties properties = new Properties();

	// constructors and factory methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	protected Dialect() {
	}

	/**
	 * Get an instance of the dialect specified by the current <tt>System</tt>
	 * properties.
	 * 
	 * @return The specified Dialect
	 * @throws RepositoryException
	 *             If no dialect was specified, or if it could not be
	 *             instantiated.
	 */
	public static Dialect getDialect() throws RepositoryException {
		String dialectName = Environment.getProperties().getProperty(Environment.DIALECT);
		return instantiateDialect(dialectName);
	}

	/**
	 * Get an instance of the dialect specified by the given properties or by
	 * the current <tt>System</tt> properties.
	 * 
	 * @param props
	 *            The properties to use for finding the dialect class to use.
	 * @return The specified Dialect
	 * @throws RepositoryException
	 *             If no dialect was specified, or if it could not be
	 *             instantiated.
	 */
	public static Dialect getDialect(Properties props) throws RepositoryException {
		String dialectName = props.getProperty(Environment.DIALECT);
		if (dialectName == null) {
			return getDialect();
		}
		return instantiateDialect(dialectName);
	}

	private static Dialect instantiateDialect(String dialectName) throws RepositoryException {
		if (dialectName == null) {
			throw new RepositoryException("The dialect was not set. Set the property hibernate.dialect.");
		}
		try {
			return (Dialect) ReflectUtil.classForName(dialectName).newInstance();
		} catch (ClassNotFoundException cnfe) {
			throw new RepositoryException("Dialect class not found: " + dialectName);
		} catch (Exception e) {
			throw new RepositoryException("Could not instantiate given dialect class: " + dialectName, e);
		}
	}

	/**
	 * Retrieve a set of default Hibernate properties for this database.
	 * 
	 * @return a set of Hibernate properties
	 */
	public final Properties getDefaultProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return getClass().getName();
	}

	// limit/offset support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/**
	 * Does this dialect support some form of limiting query results via a SQL
	 * clause?
	 * 
	 * @return True if this dialect supports some form of LIMIT.
	 */
	public boolean supportsLimit() {
		return false;
	}

	/**
	 * Does this dialect's LIMIT support (if any) additionally support
	 * specifying an offset?
	 * 
	 * @return True if the dialect supports an offset within the limit support.
	 */
	public boolean supportsLimitOffset() {
		return supportsLimit();
	}

	/**
	 * Does this dialect support bind variables (i.e., prepared statement
	 * parameters) for its limit/offset?
	 * 
	 * @return True if bind variables can be used; false otherwise.
	 */
	public boolean supportsVariableLimit() {
		return supportsLimit();
	}

	/**
	 * ANSI SQL defines the LIMIT clause to be in the form LIMIT offset, limit.
	 * Does this dialect require us to bind the parameters in reverse order?
	 * 
	 * @return true if the correct order is limit, offset
	 */
	public boolean bindLimitParametersInReverseOrder() {
		return false;
	}

	/**
	 * Does the <tt>LIMIT</tt> clause come at the start of the <tt>SELECT</tt>
	 * statement, rather than at the end?
	 * 
	 * @return true if limit parameters should come before other parameters
	 */
	public boolean bindLimitParametersFirst() {
		return false;
	}

	/**
	 * Does the <tt>LIMIT</tt> clause take a "maximum" row number instead of a
	 * total number of returned rows?
	 * <p/>
	 * This is easiest understood via an example. Consider you have a table with
	 * 20 rows, but you only want to retrieve rows number 11 through 20.
	 * Generally, a limit with offset would say that the offset = 11 and the
	 * limit = 10 (we only want 10 rows at a time); this is specifying the total
	 * number of returned rows. Some dialects require that we instead specify
	 * offset = 11 and limit = 20, where 20 is the "last" row we want relative
	 * to offset (i.e. total number of rows = 20 - 11 = 9)
	 * <p/>
	 * So essentially, is limit relative from offset? Or is limit absolute?
	 * 
	 * @return True if limit is relative from offset; false otherwise.
	 */
	public boolean useMaxForLimit() {
		return false;
	}

	/**
	 * Generally, if there is no limit applied to a Hibernate query we do not
	 * apply any limits to the SQL query. This option forces that the limit be
	 * written to the SQL query.
	 * 
	 * @return True to force limit into SQL query even if none specified in
	 *         Hibernate query; false otherwise.
	 */
	public boolean forceLimitUsage() {
		return false;
	}

	/**
	 * Given a limit and an offset, apply the limit clause to the query.
	 * 
	 * @param query
	 *            The query to which to apply the limit.
	 * @param offset
	 *            The offset of the limit
	 * @param limit
	 *            The limit of the limit ;)
	 * @return The modified query statement with the limit applied.
	 */
	public String getLimitString(String query, int offset, int limit) {
		return getLimitString(query, (offset > 0 || forceLimitUsage()));
	}
	
	/**
	 * Apply s limit clause to the query.
	 * <p/>
	 * Typically dialects utilize {@link #supportsVariableLimit() variable}
	 * limit clauses when they support limits. Thus, when building the select
	 * command we do not actually need to know the limit or the offest since we
	 * will just be using placeholders.
	 * <p/>
	 * Here we do still pass along whether or not an offset was specified so
	 * that dialects not supporting offsets can generate proper exceptions. In
	 * general, dialects will override one or the other of this method and
	 * {@link #getLimitString(String, int, int)}.
	 * 
	 * @param query
	 *            The query to which to apply the limit.
	 * @param hasOffset
	 *            Is the query requesting an offset?
	 * @return the modified SQL
	 */
	protected String getLimitString(String query, boolean hasOffset) {
		throw new UnsupportedOperationException("Paged queries not supported by " + getClass().getName());
	}

	/**
	 *  APIs explicitly state that setFirstResult() should be a
	 * zero-based offset. Here we allow the Dialect a chance to convert that
	 * value based on what the underlying db or driver will expect.
	 * <p/>
	 * NOTE: what gets passed into {@link #getLimitString(String,int,int)} is
	 * the zero-based offset. Dialects which do not
	 * {@link #supportsVariableLimit} should take care to perform any needed
	 * {@link #convertToFirstRowValue} calls prior to injecting the limit values
	 * into the SQL string.
	 * 
	 * @param zeroBasedFirstResult
	 *            The user-supplied, zero-based first row offset.
	 * 
	 * @return The corresponding db/dialect specific offset.
	 * 
	 * @see org.hibernate.Query#setFirstResult
	 * @see org.hibernate.Criteria#setFirstResult
	 */
	public int convertToFirstRowValue(int zeroBasedFirstResult) {
		return zeroBasedFirstResult;
	}

	// SEQUENCE support ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

		/**
		 * Does this dialect support sequences?
		 *
		 * @return True if sequences supported; false otherwise.
		 */
		public boolean supportsSequences() {
			return false;
		}

		/**
		 * Does this dialect support "pooled" sequences.  Not aware of a better
		 * name for this.  Essentially can we specify the initial and increment values?
		 *
		 * @return True if such "pooled" sequences are supported; false otherwise.
		 * @see #getCreateSequenceStrings(String, int, int)
		 * @see #getCreateSequenceString(String, int, int)
		 */
		public boolean supportsPooledSequences() {
			return false;
		}

		/**
		 * Generate the appropriate select statement to to retreive the next value
		 * of a sequence.
		 * <p/>
		 * This should be a "stand alone" select statement.
		 *
		 * @param sequenceName the name of the sequence
		 * @return String The "nextval" select string.
		 * @throws MappingException If sequences are not supported.
		 */
		public String getSequenceNextValString(String sequenceName) throws RepositoryException {
			throw new RepositoryException( "Dialect does not support sequences" );
		}

		/**
		 * Generate the select expression fragment that will retreive the next
		 * value of a sequence as part of another (typically DML) statement.
		 * <p/>
		 * This differs from {@link #getSequenceNextValString(String)} in that this
		 * should return an expression usable within another statement.
		 *
		 * @param sequenceName the name of the sequence
		 * @return The "nextval" fragment.
		 * @throws MappingException If sequences are not supported.
		 */
		public String getSelectSequenceNextValString(String sequenceName) throws RepositoryException {
			throw new RepositoryException( "Dialect does not support sequences" );
		}

		/**
		 * An optional multi-line form for databases which {@link #supportsPooledSequences()}.
		 *
		 * @param sequenceName The name of the sequence
		 * @param initialValue The initial value to apply to 'create sequence' statement
		 * @param incrementSize The increment value to apply to 'create sequence' statement
		 * @return The sequence creation commands
		 * @throws MappingException If sequences are not supported.
		 */
		public String[] getCreateSequenceStrings(String sequenceName, int initialValue, int incrementSize) throws RepositoryException {
			return new String[] { getCreateSequenceString( sequenceName, initialValue, incrementSize ) };
		}

		/**
		 * Typically dialects which support sequences can create a sequence
		 * with a single command.  This is convenience form of
		 * {@link #getCreateSequenceStrings} to help facilitate that.
		 * <p/>
		 * Dialects which support sequences and can create a sequence in a
		 * single command need *only* override this method.  Dialects
		 * which support sequences but require multiple commands to create
		 * a sequence should instead override {@link #getCreateSequenceStrings}.
		 *
		 * @param sequenceName The name of the sequence
		 * @return The sequence creation command
		 * @throws MappingException If sequences are not supported.
		 */
		protected String getCreateSequenceString(String sequenceName) throws RepositoryException {
			throw new RepositoryException( "Dialect does not support sequences" );
		}

		/**
		 * Overloaded form of {@link #getCreateSequenceString(String)}, additionally
		 * taking the initial value and increment size to be applied to the sequence
		 * definition.
		 * </p>
		 * The default definition is to suffix {@link #getCreateSequenceString(String)}
		 * with the string: " start with {initialValue} increment by {incrementSize}" where
		 * {initialValue} and {incrementSize} are replacement placeholders.  Generally
		 * dialects should only need to override this method if different key phrases
		 * are used to apply the allocation information.
		 *
		 * @param sequenceName The name of the sequence
		 * @param initialValue The initial value to apply to 'create sequence' statement
		 * @param incrementSize The increment value to apply to 'create sequence' statement
		 * @return The sequence creation command
		 * @throws MappingException If sequences are not supported.
		 */
		protected String getCreateSequenceString(String sequenceName, int initialValue, int incrementSize) throws RepositoryException {
			if ( supportsPooledSequences() ) {
				return getCreateSequenceString( sequenceName ) + " start with " + initialValue + " increment by " + incrementSize;
			}
			throw new RepositoryException( "Dialect does not support pooled sequences" );
		}

		/**
		 * The multiline script used to drop a sequence.
		 *
		 * @param sequenceName The name of the sequence
		 * @return The sequence drop commands
		 * @throws MappingException If sequences are not supported.
		 */
		public String[] getDropSequenceStrings(String sequenceName) throws RepositoryException {
			return new String[]{getDropSequenceString( sequenceName )};
		}

		/**
		 * Typically dialects which support sequences can drop a sequence
		 * with a single command.  This is convenience form of
		 * {@link #getDropSequenceStrings} to help facilitate that.
		 * <p/>
		 * Dialects which support sequences and can drop a sequence in a
		 * single command need *only* override this method.  Dialects
		 * which support sequences but require multiple commands to drop
		 * a sequence should instead override {@link #getDropSequenceStrings}.
		 *
		 * @param sequenceName The name of the sequence
		 * @return The sequence drop commands
		 * @throws MappingException If sequences are not supported.
		 */
		protected String getDropSequenceString(String sequenceName) throws RepositoryException {
			throw new RepositoryException( "Dialect does not support sequences" );
		}

		/**
		 * Get the select command used retrieve the names of all sequences.
		 *
		 * @return The select command; or null if sequences are not supported.
		 * @see org.hibernate.tool.hbm2ddl.SchemaUpdate
		 */
		public String getQuerySequencesString() {
			return null;
		}
	
}
