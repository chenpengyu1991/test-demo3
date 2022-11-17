package com.founder.fasf.interceptor;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

import com.founder.fasf.log.LoggerUtil;

public class LoggingInterceptor extends OrderedMethodInterceptor
{

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        Method method = invocation.getMethod();
        String message = "method start：" + method.getDeclaringClass().getName()
            + "." + method.getName();
        LoggerUtil.performance(message);
        long time = System.currentTimeMillis();
        Object retVal = null;
        try
        {
            retVal = invocation.proceed();
        }
        finally
        {
            time = System.currentTimeMillis() - time;
            message = "process interval: " + time + " ms";
            LoggerUtil.performance(message);
            message = "method end：" + method.getDeclaringClass().getName()
                + "." + method.getName();
            LoggerUtil.performance(message);
        }
        return retVal;
    }

}
