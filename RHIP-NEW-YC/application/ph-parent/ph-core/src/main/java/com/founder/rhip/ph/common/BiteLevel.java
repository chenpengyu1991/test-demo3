package com.founder.rhip.ph.common;

/**
 * User: liujy
 * Date: 13-1-14
 * Time: 下午5:37
 * To change this template use File | Settings | File Templates.
 */
public enum BiteLevel {
    LEVEL1(1), //咬伤等级1
    LEVEL2(2), //咬伤等级2
    LEVEL3(3); //咬伤等级3

    private Integer value;

    BiteLevel(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }
}
