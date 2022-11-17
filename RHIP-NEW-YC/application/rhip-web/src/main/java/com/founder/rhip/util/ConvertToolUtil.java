package com.founder.rhip.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 转换工具类
 * Created by admin on 2017/5/11.
 */
public class ConvertToolUtil {


    /**
     * 将报卡等参数字符串转换为map
     *
     * @param query
     * @return
     */
    public static Map<String, Object[]> convertQueryToMap(String query) {
        Map<String, Object[]> map = new HashMap<String, Object[]>();
        String params[] = query.split("&");
        for (String param : params) {
            if (param.indexOf("=") > 0) {
                String keyValues[] = param.split("=");
                if (keyValues.length == 2) {
                    String value=keyValues[1] ;
                    value=value==null?"":value.trim();
                    map.put(keyValues[0], new Object[] { value});
                } else if (keyValues.length == 1) {
                    map.put(keyValues[0], new Object[] { "" });
                }
            }
        }
        return map;
    }

    /**
     * map中获取String值 ,null则返回""
     *
     * @param map
     * @param key
     * @return
     */
    public static String getFieldValue(Map<String, Object[]> map, String key) {
        if (!map.containsKey(key)) {
            return "";
        }
        return map.get(key)[0].toString();
    }
}
