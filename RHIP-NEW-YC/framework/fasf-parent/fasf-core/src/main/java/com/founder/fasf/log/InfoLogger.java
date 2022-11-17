package com.founder.fasf.log;


import org.apache.log4j.Logger;

import com.founder.fasf.constants.CoreConstants;

public final class InfoLogger
{

	private static Logger log=Logger.getLogger(CoreConstants.LOG_PACKAGE_PERFORMANCE);  


    /**
     * 防止实例化对象
     */
    private InfoLogger()
    {
    }

    /**
     * 日志输出
     * @param message 输出内容
     */
    public static void log(final String message)
    {
        log.info(message);
    }

    /**
     * 日志输出
     * @param message 输出内容
     */
    public static void log(final Object message)
    {
        log.info(message);
    }

    /**
     * 日志输出
     * @param message 输出内容
     * @param t 输出异常
     */
    public static void log(final Object message, final Throwable t)
    {
        log.info(message, t);
    }
}
