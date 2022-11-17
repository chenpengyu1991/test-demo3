package com.founder.rhip.ehr.common;

import com.founder.fasf.util.ObjectUtil;


public class SiteNoticeUtil {
    /**
     * 根据Key获取msg
     *
     * @param msgKey
     * @param ...args
     */
    public static String getMsg(String msgKey, String... args) {
        String msg = WebProperties.getMsg(msgKey);

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
            } else {
                msg = msg.replace(reg, "");
            }
        }
        return msg;
    }
}
