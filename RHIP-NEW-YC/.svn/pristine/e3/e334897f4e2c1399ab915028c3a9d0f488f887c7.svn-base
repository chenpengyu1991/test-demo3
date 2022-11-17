package com.founder.fasf.repository;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: mindust
 * Date: 12-10-27
 * Time: 下午10:48
 * To change this template use File | Settings | File Templates.
 */
public class AbstractDaoProxy implements InvocationHandler {

        private AopInterface aop;//定义了切入时调用的方法
        private Object proxy_obj;

        AbstractDaoProxy(){}

        public Object factory(Object obj){
            proxy_obj = obj;
            Class cls = obj.getClass();
            return Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), this);
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(this.aop == null)throw new NullPointerException("aop is null");
            if(method == null)throw new NullPointerException("method is null");

            aop.before(proxy_obj);//指定方法调用前的处理
            Object o = method.invoke(proxy_obj, args);
            aop.end(proxy_obj);//指定方法调用后的处理
            return o;
        }

        public AopInterface getAop() {
            return aop;
        }

        public void setAop(AopInterface aop) {
            this.aop = aop;
        }

}
