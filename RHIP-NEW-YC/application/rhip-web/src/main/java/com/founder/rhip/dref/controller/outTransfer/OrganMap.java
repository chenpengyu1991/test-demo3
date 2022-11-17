package com.founder.rhip.dref.controller.outTransfer;

import java.util.HashMap;
import java.util.Map;

/**
 *  外部转诊医疗机构code对应
 */
public class OrganMap {

    public static Map<String, String> OrganMap() {
        Map<String, String> organMap = new HashMap<String, String>();
//        organMap.put("300001", "46714063-X"); //常熟市第一人民医院
//
//        organMap.put("300002", "46714062-1"); //常熟市第二人民医院
//        organMap.put("300101", "46714062-1"); //常熟市第二人民医院城中分院
//        organMap.put("300102", "46714062-1"); //常熟市第二人民医院传染病分院（常熟市结核病防治所）
//        organMap.put("300103", "46714062-1"); //常熟市第二人民医院琴枫分院
//
//        organMap.put("300003", "46714117-3"); //常熟市第三人民医院
//
//        organMap.put("300004", "46714078-7"); //常熟市中医院（常熟市新区医院）
//        organMap.put("300106", "46714078-7"); //常熟市中医院（新区医院）外菱塘分院

        organMap.put("46714063-X", "300001"); //常熟市第一人民医院

        organMap.put("46714062-1", "300002"); //常熟市第二人民医院
        organMap.put("46714062-11", "300101"); //常熟市第二人民医院城中分院
        organMap.put("320002991", "300102"); //常熟市第二人民医院传染病分院（常熟市结核病防治所）
        organMap.put("46714062-12", "300103"); //常熟市第二人民医院琴枫分院

        organMap.put("46714117-3", "300003"); //常熟市第三人民医院

        organMap.put("46714077-9", "200039"); //常熟市第五人民医院(老)
        organMap.put("46714077-91", "200026"); //常熟市第五人民医院(新)

        organMap.put("46714078-7", "300004"); //常熟市中医院（常市新区医院）
        organMap.put("46714078-71", "300106"); //常熟市中医院（新区医院）外菱塘分院

        return organMap;
    }
}

