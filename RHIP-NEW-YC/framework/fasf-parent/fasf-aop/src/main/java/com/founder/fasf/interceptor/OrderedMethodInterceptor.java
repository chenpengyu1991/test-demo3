package com.founder.fasf.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public abstract class OrderedMethodInterceptor implements MethodInterceptor//, Ordered
{
    private int order;

    //@Override
    public int getOrder()
    {
        return this.order;
    }

    public void setOrder(int order)
    {
        this.order = order;
    }

    @Override
    public abstract Object invoke(MethodInvocation invocation) throws Throwable;

}
