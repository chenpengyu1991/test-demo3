/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */


package com.founder.rhip.fdm;

/**
 * 食源性疾病报卡状态
 * @version 1.0, 2013-11-14
 */
public enum ReportStatus {

//    /**
//     * 未审核（医生上报）
//     */
//    NOT_VERIFY("1"),
//    /**
//     * 已审核（防保科审核）
//     */
//    HOSPITAL_VERIFY("2"),
//    /**
//     * 作废
//     */
//    CANCEL("3");

    /**
     * 报卡已填写（医生上报）
     */
    REPORT_SAVED("1"),
    /**
     * 防保科审核通过
     */
    FBK_PASS("2"),
    /**
     * 检验结果已填写(疾控检验科)
     */
    TS_SAVED("3"),
    /**
     * 疾控审核通过(疾控卫生科)
     */
    JK_PASS("4"),
    /**
     * 防保科审核不通过
     */
    FBK_REJECT("5"),
    /**
     * 疾控打回
     */
    JK_REJECT("6"),
    /**
     * 防保科已修改
     */
    FBK_EDIT("7"),
    /**
     * 疾控审核作废
     */
    JK_CALCEL("8");

    private String value;

    ReportStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
