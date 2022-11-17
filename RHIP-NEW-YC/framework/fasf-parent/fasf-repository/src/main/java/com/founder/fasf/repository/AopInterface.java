package com.founder.fasf.repository;

/**
 * Created with IntelliJ IDEA.
 * User: mindust
 * Date: 12-10-27
 * Time: 下午10:53
 * To change this template use File | Settings | File Templates.
 */
public interface AopInterface {
    public void before(Object obj);//调用的处理
    public void end(Object obj);//调用后的处理
}

