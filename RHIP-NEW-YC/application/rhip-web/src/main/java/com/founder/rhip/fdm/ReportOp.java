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
public enum ReportOp {

    /**
     * 通过
     */
    YES("1"),
    /**
     * 不通过
     */
    NO("2");

    private String value;

    ReportOp(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
