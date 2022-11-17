package com.founder.rhip.cdm.common;

/**
 * Created with IntelliJ IDEA.
 * User: liuk
 * Date: 13-2-28
 * Time: 上午10:58
 */
public enum ApprovalState {
    /** 上报后初始状态,防保科待审核 */
    READY("1"),
    /** 慢病科审核退回 */
    REJECT("2"),
    /** 慢病科待审核 */
    VERIFIED_FIRST("3"),
    /** 慢病科审核通过并分配 */
    VERIFIED_SECOND("4"),
    /** 防保科退回作废 防保科结束*/
    CANCEL("5"),
    /** 防保科分配退回 */
    ALLOC_REJECT_FIRST("6"),
    /** 防保科 已经分配*/
    ALLOCATED("7"),
    /** 社区站分配退回 */
    ALLOC_REJECT_SECOND("8"),
    /** 社区已管理*/
    MANAGED("9"),
    /** 不管理 疾控慢病那边结束*/
    NO_MANAGED("10"),
    /** 死亡补报*/
    DEATH("11"),
    /** 防保科纳入退回*/
    ALLOC_REJECT_THREE("12");
    private String value;

    ApprovalState(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
