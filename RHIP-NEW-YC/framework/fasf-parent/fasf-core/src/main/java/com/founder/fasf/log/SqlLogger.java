package com.founder.fasf.log;
//package com.founder.fasf.core.util.log;
//
//import static com.founder.fasf.core.def.CoreConstants.LOG_ITEM_DELIMITER;
//
//
//import org.aopalliance.intercept.MethodInvocation;
//import org.apache.log4j.Logger;
//import org.seasar.extension.jdbc.SqlLog;
//import org.seasar.extension.jdbc.SqlLogRegistryLocator;
//
//import com.founder.fasf.core.def.CoreConstants;
//

// * @author toyokazu.ohara
// * <pre>
// *------------------------------------------------------------------------------------------
// * MODIFICATION HISTORY
// *------------------------------------------------------------------------------------------
// * SIRID                When          Who           Why
// *------------------------------------------------------------------------------------------
// * </pre>
// */
//public final class SqlLogger {
//

//    private static Logger log;

//    private static final String LF = System.getProperty("line.separator");

//    static {

//        log = Logger.getLogger(CoreConstants.LOG_PACKAGE_SQL);
//    }

//    private SqlLogger() {
//    }
//

//    public static void log(final MethodInvocation invocation) {

//        SqlLog sqlLog = SqlLogRegistryLocator.getInstance().getLast();

//        if (sqlLog != null) {
//            log.info(buildLogMessage(
//                        invocation,
//                        sqlLog.getCompleteSql()));
//        }
//    }
//
//    private static String buildLogMessage(
//            final MethodInvocation invocation
//            , final String execSql) {
//        return LoggerUtil.getInvokeClassName(invocation)
//               + LOG_ITEM_DELIMITER
//               + LoggerUtil.getInvokeMethodName(invocation)
//               + LOG_ITEM_DELIMITER
//               + LF
//               + execSql;
//    }
//}
