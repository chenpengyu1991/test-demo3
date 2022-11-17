package com.founder.rhip.ehr.common;

import com.founder.fasf.util.ObjectUtil;

import java.util.Properties;

public class WebProperties {
    private static final WebProperties instance = new WebProperties();

    private static Properties properties;

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        WebProperties.properties = properties;
    }

    private WebProperties() {

    }

    public static WebProperties getInstance() {
        if (properties == null) {
            properties = new Properties();
        }
        return instance;
    }

    /**
     * 根据Key获取msg
     *
     * @param msgKey
     * @param ...args
     */
    public static String getMsg(String msgKey, String... args) {
        String msg = properties.getProperty(msgKey);

        if (msg == null) {
            return "";
        }

        if (args == null || args.length == 0) {
            return msg;
        }
        for (int i = 0; i < args.length; i++) {
            String reg = "{" + i + "}";
            String rep = args[i];
            if (ObjectUtil.isNotEmpty(rep)) {
                msg = msg.replace(reg, rep);
            }
        }
        return msg;
    }
}
