
package com.founder.fasf.repository;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.founder.fasf.config.ConfigurationUtil;
import com.founder.fasf.exception.RepositoryException;

public final class Environment {

	// private Logger LOG = Logger.getLogger(Environment.class);
	private static final Properties GLOBAL_PROPERTIES;

	//public static final String USE_REFLECTION_OPTIMIZER = "fasf.bytecode.use_reflection_optimizer";

	/**
	 * A comma-separated list of token substitutions to use when translating a Hibernate
	 * query to SQL
	 */
	//public static final String QUERY_SUBSTITUTIONS = "fasf.query.substitutions";

	/**
	 * Should we not use contextual LOB creation (aka based on
	 * {@link java.sql.Connection#createBlob()} et al).
	 */
	//public static final String NON_CONTEXTUAL_LOB_CREATION = "fasf.jdbc.lob.non_contextual_creation";

	/**
	 * Tells the JDBC driver to attempt to retrieve row Id with the JDBC 3.0
	 * PreparedStatement.getGeneratedKeys() method. In general, performance will
	 * be better if this property is set to true and the underlying JDBC driver
	 * supports getGeneratedKeys().
	 */
	public static final String USE_GET_GENERATED_KEYS = "fasf.jdbc.use_get_generated_keys";

	/**
	 * Maximum depth of outer join fetching
	 */
	public static final String MAX_FETCH_DEPTH = "fasf.max_fetch_depth";

	/**
	 * Use <tt>java.io</tt> streams to read / write binary data from / to JDBC
	 */
	public static final String USE_STREAMS_FOR_BINARY = "fasf.jdbc.use_streams_for_binary";

	private static final boolean JVM_HAS_TIMESTAMP_BUG;
	static {
		// Map<Integer, String> temp = new HashMap<Integer, String>();
		GLOBAL_PROPERTIES = new Properties();
		// Set USE_REFLECTION_OPTIMIZER to false to fix HHH-227
		// GLOBAL_PROPERTIES.setProperty( USE_REFLECTION_OPTIMIZER,
		// Boolean.FALSE.toString() );
		try {
			InputStream stream = ConfigurationUtil.getResourceAsStream("/fasf.properties");
			try {
				GLOBAL_PROPERTIES.load(stream);
				// LOG.propertiesLoaded( ConfigurationHelper.maskOut(
				// GLOBAL_PROPERTIES, PASS ) );
			} catch (Exception e) {
				// LOG.unableToLoadProperties();
			} finally {
				try {
					stream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (RepositoryException he) {
			// LOG.propertiesNotFound();
		}
		try {
			GLOBAL_PROPERTIES.putAll(System.getProperties());
		} catch (SecurityException se) {
			// LOG.unableToCopySystemProperties();
		}
		//verifyProperties(GLOBAL_PROPERTIES);
		ENABLE_BINARY_STREAMS = ConfigurationUtil.getBoolean(USE_STREAMS_FOR_BINARY, GLOBAL_PROPERTIES);
		long x = 123456789;
		JVM_HAS_TIMESTAMP_BUG = new Timestamp(x).getTime() != x;
		/*if ( JVM_HAS_TIMESTAMP_BUG ) {
			LOG.usingTimestampWorkaround();
		}*/
	}

	/**
	 * Names the  {@literal SQL}
	 * {@link com.founder.fasf.repository.dialect.Dialect} class
	 */
	public static final String DIALECT = "fasf.dialect";

	/**
	 * Maximum JDBC batch size. A nonzero value enables batch updates.
	 */
	public static final String STATEMENT_BATCH_SIZE = "fasf.jdbc.batch_size";

	/**
	 * Enable formatting of SQL logged to the console
	 */
	public static final String FORMAT_SQL = "fasf.format_sql";

    public static final String FASF_DEFAULT_DATASOURCE="fasf.default.datasource";

	/**
	 * Add comments to the generated SQL
	 */
	//public static final String USE_SQL_COMMENTS = "fasf.use_sql_comments";

	/**
	 * Should we use streams to bind binary types to JDBC IN parameters?
	 * 
	 * @return True if streams should be used for binary data handling; false
	 *         otherwise.
	 * 
	 * @see #USE_STREAMS_FOR_BINARY
	 */
	private static final boolean ENABLE_BINARY_STREAMS;

	@SuppressWarnings("rawtypes")
	private static final Map OBSOLETE_PROPERTIES = new HashMap();

	@SuppressWarnings("rawtypes")
	private static final Map RENAMED_PROPERTIES = new HashMap();

	/**
	 * Return <tt>System</tt> properties, extended by any properties specified
	 * in <tt>fasf.properties</tt>.
	 * 
	 * @return Properties
	 */
	public static Properties getProperties() {
		Properties copy = new Properties();
		copy.putAll(GLOBAL_PROPERTIES);
		return copy;
	}

	/**
	 * Does this JVM's implementation of {@link java.sql.Timestamp} have a bug
	 * in which the following is true:<code>
	 * new java.sql.Timestamp( x ).getTime() != x
	 * </code>
	 * <p/>
	 * NOTE : IBM JDK 1.3.1 the only known JVM to exhibit this behavior.
	 * 
	 * @return True if the JVM's {@link Timestamp} implementa
	 */
	public static boolean jvmHasTimestampBug() {
		return JVM_HAS_TIMESTAMP_BUG;
	}

	public static boolean useStreamsForBinary() {
		return ENABLE_BINARY_STREAMS;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void verifyProperties(Map<?, ?> configurationValues) {
		final Map propertiesToAdd = new HashMap();
		for (Map.Entry entry : configurationValues.entrySet()) {
			OBSOLETE_PROPERTIES.get(entry.getKey());
			/*			if ( replacementKey != null ) {
							LOG.unsupportedProperty( entry.getKey(), replacementKey );
						}*/
			final Object renamedKey = RENAMED_PROPERTIES.get(entry.getKey());
			if (renamedKey != null) {
				// LOG.renamedProperty( entry.getKey(), renamedKey );
				propertiesToAdd.put(renamedKey, entry.getValue());
			}
		}
		configurationValues.putAll(propertiesToAdd);
	}
}
