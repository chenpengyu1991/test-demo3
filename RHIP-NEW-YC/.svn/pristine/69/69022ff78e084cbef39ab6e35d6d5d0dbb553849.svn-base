package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.service.export.Item;

/**
 * Created by jiang haiying on 2016/7/26.
 * 慢病纳入相关统计 统计类型按照现住址
 */
public class CdmManagerStatisticsVillageDto {

    @Item(index=31,column ="所在镇",isDic=true, dicType="FS990001")
    private String patown_ship;

    @Item(index=33,column ="所在居委会",isDic=true, dicType="FS990001")
    private String pastreet;

    @Item(index=33,column ="高血压新增管理人数")
    private Integer new_hbp_num;

    @Item(index=33,column ="糖尿病新增管理人数")
    private Integer new_di_num;

    @Item(index=33,column ="高血压累计管理人数")
    private Integer hbp_num;

    @Item(index=33,column ="糖尿病累计管理人数")
    private Integer di_num;

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

    public Integer getNew_hbp_num() {
        return new_hbp_num;
    }

    public void setNew_hbp_num(Integer new_hbp_num) {
        this.new_hbp_num = new_hbp_num;
    }

    public Integer getNew_di_num() {
        return new_di_num;
    }

    public void setNew_di_num(Integer new_di_num) {
        this.new_di_num = new_di_num;
    }

    public Integer getHbp_num() {
        return hbp_num;
    }

    public void setHbp_num(Integer hbp_num) {
        this.hbp_num = hbp_num;
    }

    public Integer getDi_num() {
        return di_num;
    }

    public void setDi_num(Integer di_num) {
        this.di_num = di_num;
    }
}
