package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.service.export.Item;

/**
 * Created by jiang haiying on 2016/7/26.
 * 慢病随访统计 统计类型按照机构
 */
public class CdmFollowupStatisticsVillageDto {

    @Item(index=31,column ="所在镇",isDic=true, dicType="FS990001")
    private String patown_ship;

    @Item(index=33,column ="所在居委会",isDic=true, dicType="FS990001")
    private String pastreet;

    @Item(index=33,column ="高血压应随访人数")
    private Integer hbp_plan_num;

    @Item(index=33,column ="糖尿病应随访人数")
    private Integer di_plan_num;

    @Item(index=33,column ="高血压随访人数")
    private Integer hbp_fllowup_num;

    @Item(index=33,column ="糖尿病随访人数")
    private Integer di_fllowup_num;

    @Item(index=33,column ="高血压随访人次数")
    private Integer hbp_fllowup_times_num;

    @Item(index=33,column ="糖尿病随访人次数")
    private Integer di_fllowup_times_num;

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

    public Integer getHbp_plan_num() {
        return hbp_plan_num;
    }

    public void setHbp_plan_num(Integer hbp_plan_num) {
        this.hbp_plan_num = hbp_plan_num;
    }

    public Integer getDi_plan_num() {
        return di_plan_num;
    }

    public void setDi_plan_num(Integer di_plan_num) {
        this.di_plan_num = di_plan_num;
    }

    public Integer getHbp_fllowup_num() {
        return hbp_fllowup_num;
    }

    public void setHbp_fllowup_num(Integer hbp_fllowup_num) {
        this.hbp_fllowup_num = hbp_fllowup_num;
    }

    public Integer getDi_fllowup_num() {
        return di_fllowup_num;
    }

    public void setDi_fllowup_num(Integer di_fllowup_num) {
        this.di_fllowup_num = di_fllowup_num;
    }

    public Integer getHbp_fllowup_times_num() {
        return hbp_fllowup_times_num;
    }

    public void setHbp_fllowup_times_num(Integer hbp_fllowup_times_num) {
        this.hbp_fllowup_times_num = hbp_fllowup_times_num;
    }

    public Integer getDi_fllowup_times_num() {
        return di_fllowup_times_num;
    }

    public void setDi_fllowup_times_num(Integer di_fllowup_times_num) {
        this.di_fllowup_times_num = di_fllowup_times_num;
    }
}
