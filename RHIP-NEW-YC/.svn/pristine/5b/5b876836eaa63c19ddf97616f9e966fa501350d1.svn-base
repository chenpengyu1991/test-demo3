package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.service.export.Item;

/**
 * Created by jiang haiying on 2016/7/26.
 * 慢病体检相关统计 统计类型按照机构
 */
public class CdmPhyStatisticsDto {

    @Item(index=31,column ="机构名称",isOrganization=true)
    private String create_organ_code;

    @Item(index=33,column ="医务人员名称",isUser=true)
    private String create_doctor_code;

    @Item(index=33,column ="高血压新增管理人数")
    private Integer hbp_phy_num;

    @Item(index=33,column ="糖尿病新增管理人数")
    private Integer di_phy_num;

    @Item(index=33,column ="糖尿病体检空血检查人次数")
    private Integer di_fpg_num;

    public String getCreate_organ_code() {
        return create_organ_code;
    }

    public void setCreate_organ_code(String create_organ_code) {
        this.create_organ_code = create_organ_code;
    }

    public String getCreate_doctor_code() {
        return create_doctor_code;
    }

    public void setCreate_doctor_code(String create_doctor_code) {
        this.create_doctor_code = create_doctor_code;
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
