package com.founder.rhip.ehr.dto;

public class RecordCountDTO {
    //机构代码
    private String organCode;

    //机构名称
    private String organName;

    //待建档数
    private Integer waitCreateDocNum;

    //待转入个人档案数
    private Integer waitRefInPersonNum;

    //待转入家庭档案数
    private Integer waitRefInFamilyNum;

    //已迁出个人档案数
    private Integer hadEmigrationPersonNum;

    //已迁出家庭档案数
    private Integer hadEmigrationFamilyNum;

    //已注销个人档案数
    private Integer hadWriteOffPersonNum;

    //已注销家庭档案数
    private Integer hadWriteOffFamilyNum;

    //待分配个人档案数
    private Integer waitDistributeDocNum;

    //已分配个人档案数
    private Integer hadDistributeDocNum;

    //总建档数
    private Integer allDocNum;

    //1星级建档数
    private Integer oneStarDocNum;

    //1星完整档案数
    private Integer oneStarFullDocNum;

    //2星级建档数
    private Integer twoStarDocNum;

    //2星完整档案数
    private Integer twoStarFullDocNum;

    //3星级建档数
    private Integer threeDocNum;

    //3星完整档案数
    private Integer threeStarFullDocNum;

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public Integer getWaitCreateDocNum() {
        return waitCreateDocNum;
    }

    public void setWaitCreateDocNum(Integer waitCreateDocNum) {
        this.waitCreateDocNum = waitCreateDocNum;
    }

    public Integer getWaitRefInPersonNum() {
        return waitRefInPersonNum;
    }

    public void setWaitRefInPersonNum(Integer waitRefInPersonNum) {
        this.waitRefInPersonNum = waitRefInPersonNum;
    }

    public Integer getWaitRefInFamilyNum() {
        return waitRefInFamilyNum;
    }

    public void setWaitRefInFamilyNum(Integer waitRefInFamilyNum) {
        this.waitRefInFamilyNum = waitRefInFamilyNum;
    }

    public Integer getHadEmigrationPersonNum() {
        return hadEmigrationPersonNum;
    }

    public void setHadEmigrationPersonNum(Integer hadEmigrationPersonNum) {
        this.hadEmigrationPersonNum = hadEmigrationPersonNum;
    }

    public Integer getHadEmigrationFamilyNum() {
        return hadEmigrationFamilyNum;
    }

    public void setHadEmigrationFamilyNum(Integer hadEmigrationFamilyNum) {
        this.hadEmigrationFamilyNum = hadEmigrationFamilyNum;
    }

    public Integer getHadWriteOffPersonNum() {
        return hadWriteOffPersonNum;
    }

    public void setHadWriteOffPersonNum(Integer hadWriteOffPersonNum) {
        this.hadWriteOffPersonNum = hadWriteOffPersonNum;
    }

    public Integer getHadWriteOffFamilyNum() {
        return hadWriteOffFamilyNum;
    }

    public void setHadWriteOffFamilyNum(Integer hadWriteOffFamilyNum) {
        this.hadWriteOffFamilyNum = hadWriteOffFamilyNum;
    }

    public Integer getWaitDistributeDocNum() {
        return waitDistributeDocNum;
    }

    public void setWaitDistributeDocNum(Integer waitDistributeDocNum) {
        this.waitDistributeDocNum = waitDistributeDocNum;
    }

    public Integer getHadDistributeDocNum() {
        return hadDistributeDocNum;
    }

    public void setHadDistributeDocNum(Integer hadDistributeDocNum) {
        this.hadDistributeDocNum = hadDistributeDocNum;
    }

    public Integer getAllDocNum() {
        return allDocNum;
    }

    public void setAllDocNum(Integer allDocNum) {
        this.allDocNum = allDocNum;
    }

    public Integer getOneStarDocNum() {
        return oneStarDocNum;
    }

    public void setOneStarDocNum(Integer oneStarDocNum) {
        this.oneStarDocNum = oneStarDocNum;
    }

    public Integer getTwoStarDocNum() {
        return twoStarDocNum;
    }

    public void setTwoStarDocNum(Integer twoStarDocNum) {
        this.twoStarDocNum = twoStarDocNum;
    }

    public Integer getThreeDocNum() {
        return threeDocNum;
    }

    public void setThreeDocNum(Integer threeDocNum) {
        this.threeDocNum = threeDocNum;
    }

    public Integer getOneStarFullDocNum() {
        return oneStarFullDocNum;
    }

    public void setOneStarFullDocNum(Integer oneStarFullDocNum) {
        this.oneStarFullDocNum = oneStarFullDocNum;
    }

    public Integer getTwoStarFullDocNum() {
        return twoStarFullDocNum;
    }

    public void setTwoStarFullDocNum(Integer twoStarFullDocNum) {
        this.twoStarFullDocNum = twoStarFullDocNum;
    }

    public Integer getThreeStarFullDocNum() {
        return threeStarFullDocNum;
    }

    public void setThreeStarFullDocNum(Integer threeStarFullDocNum) {
        this.threeStarFullDocNum = threeStarFullDocNum;
    }

}
