package com.founder.fasf.cache;

//import com.founder.fasf.context.ApplicationContext;

public abstract class CacheKeyUtil
{
    /**  
     * 获得cache key的方法，cache key是Cache中一个Element的唯一标识  
     * cache key包括  租户id+用户id+包名+类名+方法名+参数值...，如com.co.cache.service.UserServiceImpl.getAllUser.userName值  
     * @param className 定义方法的类
     * @param methodName 方法名
     * @param arguments 方法对应的参数值
     * @return  唯一标识：与租户id,用户id，类，方法名，参数值有关的唯一标识。
     */
    public static String getFullCacheKey(String className, String methodName,
            Object[] arguments)
    {
        StringBuffer sb = new StringBuffer();
        String partKey = getPartCacheKey(className, methodName);
        sb.append(partKey);
        if ((arguments != null) && (arguments.length != 0))
        {
            for (int i = 0; i < arguments.length; i++)
            {
                sb.append(".").append(arguments[i].toString().trim());
            }
        }
        return sb.toString();
    }

    /**  
     * 获得cache key的方法，cache key是Cache中一个Element的唯一标识  
     * cache key 包括   租户id+用户id+包名+类名+方法名，如com.co.cache.service.UserServiceImpl.getAllUser  
     * @param className 定义方法的类
     * @param methodName 方法名
     * @return  唯一标识：与租户id,用户id，类，方法名，参数值有关的唯一标识。
     */
    public static String getPartCacheKey(String className, String methodName)
    {
        String tenantIdUserId = getTenentIdAndUserId();

        StringBuffer sb = new StringBuffer();
        sb.append(tenantIdUserId.trim());
        sb.append(".");
        sb.append(className.trim()).append(".").append(methodName.trim());
        return sb.toString();
    }

    /**
     * 获取租户id和用户id，组装成的标识
     * 如：租户id为：111111111
     *     用户id为: 222222222
     *     则返回：111111111_222222222
     * @return 租户id和 用户id组装成的标识 
     *         如果：租户不存在，则为none_tenantId
     *               用户不存在，则为none_userId
     */
    public static String getTenentIdAndUserId()
    {
        String tenantId = "none_tenantId";
        String userId = "none_userId";
       // ApplicationContext appContxt = ApplicationContext.getInstance();

      /*  if (appContxt.getCurrentTenantId() != null)
        {
            String tempTenantId = appContxt.getCurrentTenantId();

            if (tempTenantId != null && tempTenantId.trim().length() > 0)
            {
                tenantId = tempTenantId.trim();
            }
        }

        if (appContxt.getCurrentUserId() != null)
        {
            String tempUserId = appContxt.getCurrentUserId();
            if (tempUserId != null && tempUserId.trim().length() > 0)
            {
                userId = tempUserId.trim();
            }
        }*/

        return tenantId + "_" + userId;
    }

    /**
     * 根据缓存范围，对原始缓存唯一标识进行处理，生成相应范围的缓存唯一标识
     * @param srcCacheKey 原始缓存标识
     * @param scope 缓存范围
     * @return 具有指定缓存范围的缓存标识
     */
    public static String getCacheKeyByScope(String srcCacheKey, CacheScope scope)
    {
       // ApplicationContext appContxt = ApplicationContext.getInstance();
        String targetCacheKey = null;
    /*    StringBuffer keySb = new StringBuffer();
        String tenantId = "";//appContxt.getCurrentTenantId();
        keySb.append(tenantId).append("_");

        // 租户范围--加上租户id作前缀
        if (scope.equals(scope.TENANT))
        {
            keySb.append(srcCacheKey);
        }
        // 应用范围--加上应用名做前缀
        else if (scope.equals(scope.APPLICATION))
        {
            String applicationName = appContxt.getApplicationName();
            keySb.append(applicationName).append("_").append(srcCacheKey);
        }
        // 用户范围--加上用户id做前缀
        else if (scope.equals(scope.USER))
        {
            String userId = appContxt.getCurrentUserId();
            keySb.append(userId).append("-").append(srcCacheKey);
        }
        // 用户-应用 范围--加上用户和应用名id做前缀
        else if (scope.equals(scope.USER_APPLICATION))
        {
            String applicationName = appContxt.getApplicationName();
            String userId = appContxt.getCurrentUserId();
            keySb.append(userId).append("_").append(applicationName).append("_").append(
                    srcCacheKey);
        }
        if (!keySb.toString().equalsIgnoreCase(tenantId + "_"))
        {
            targetCacheKey = keySb.toString();
        }*/
        return targetCacheKey;
    }
}
