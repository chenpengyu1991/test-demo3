package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.service.export.Item;

/**
 * Created by jiang haiying on 2016/7/26.
 * 慢病体检相关统计 统计类型按照现住址
 */
public class CdmPhyStatisticsVillageDto {

    @Item(index=31,column ="所在镇", isDic=true, dicType="FS990001")
    private String patown_ship;

    @Item(index=33,column ="所在居委会",isDic=true, dicType="FS990001")
    private String pastreet;

    @Item(index=33,column ="高血压新增管理人数")
    private Integer hbp_phy_num;

    @Item(index=33,column ="糖尿病新增管理人数")
    private Integer di_phy_num;

    @Item(index=33,column ="糖尿病体检空血检查人次数")
    private Integer di_fpg_num;

    public String getPatown_ship() {
        return patown_ship;
    }

    public void setPatown_ship(String patown_ship) {
        this.patown_ship = patown_ship;
    }

    public String getPastreet() {
        return pastreet;
    }

    public void setPastreet(String pastreet) {
        this.pastreet = pastreet;
    }

    public Integer getHbp_phy_num() {
        return hbp_phy_num;
    }

    public void setHbp_phy_num(Integer hbp_phy_num) {
        this.hbp_phy_num = hbp_phy_num;
    }

    public Integer getDi_phy_num() {
        return di_phy_num;
    }

    public void setDi_phy_num(Integer di_phy_num) {
        this.di_phy_num = di_phy_num;
    }

    public Integer getDi_fpg_num() {
        return di_fpg_num;
    }

    public void setDi_fpg_num(Integer di_fpg_num) {
        this.di_fpg_num = di_fpg_num;
    }
}
