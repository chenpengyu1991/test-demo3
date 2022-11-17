package com.founder.rhip.ehr.cache;

import java.util.HashMap;
import java.util.Map;

public class DictionaryCache {

    public static Map<String, String> orgMap = new HashMap<String, String>();
    
    public static Map<String, String> userMap = new HashMap<String, String>();
    
    public static Map<String, String> staffMap = new HashMap<String, String>();
    
    public static Map<String, String> staffListMap = new HashMap<String, String>();

    public static Map<String, String> orgListMap = new HashMap<String, String>();

    public static Map<String, String> dicMap = new HashMap<String, String>();

    public static Map<String, String> dicListMap = new HashMap<String, String>();

    public static Map<String, String> dicRadioMap = new HashMap<String, String>();

    public static Map<String, String> dicCheckboxMap = new HashMap<String, String>();


    public static void destroyOrgCache() {
        orgMap.clear();
    }
    
    public static void destroyUserCache() {
        userMap.clear();
    }
    
    public static void destroyOrgListCache() {
        orgListMap.clear();
    }

    public static void destroyDicCache() {
        dicMap.clear();
    }

    public static void destroyDicListCache() {
        dicListMap.clear();
    }

    public static void destroyDicRadioCache() {
        dicRadioMap.clear();
    }

    public static void destroyDicCheckboxCache() {
        dicCheckboxMap.clear();
    }
}
