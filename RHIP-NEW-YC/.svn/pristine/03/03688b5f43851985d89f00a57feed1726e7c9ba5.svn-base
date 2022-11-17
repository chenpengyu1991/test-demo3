package com.founder.fasf.cache;

/**
 * 缓存范围
 * @author yang_jiangping
 *
 */
public enum CacheScope
{

    /**
     * 租户范围（全局）
     * 
     * 集群中的同一租户下：任何用户，任何应用都可见。
     * 如：服务器1中的lis,his可见服务器2中的lis,his
     */
    TENANT,

    /**
     * 应用范围（同一租户，同一应用：所有用户）
     * 
     * 集群中相同应用（分布式）的任何用户都可见
     * 如：服务器1中的his可见服务器2中的his,但不能处理服务器2中的lis
     */
    APPLICATION,

    /**
     * 用户范围(session)（同一租户，同一用户，所有应用）
     * 
     * 集群中不同应用（分布式）同一用户才可见
     * 服务器1中的his的user1用户可见服务器2中his的user1用户，但对其他用户透明
     */
    USER,

    /**
     *应用-用户范围（同一租户，同一应用，同一用户）
     *
     * 集群中相同应用（分布式）的同一用户才可见
     */
    USER_APPLICATION;

}
