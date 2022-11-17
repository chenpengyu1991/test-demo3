package com.founder.fasf.repository;

/**
 * Created with IntelliJ IDEA.
 * User: mindust
 * Date: 12-10-27
 * Time: 下午10:55
 * To change this template use File | Settings | File Templates.
 */
public class AopInterfaceImpl implements AopInterface{

    public void before(Object obj) {
        System.out.println("调用前拦截");
    }

    public void end(Object obj) {
        System.out.println("调用调用后处理");
    }

}

