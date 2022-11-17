package com.founder.rhip.ehr.dto;

import com.founder.rhip.ehr.service.export.Item;

/**
 * Created by jiang haiying on 2016/7/26.
 * 慢病纳入相关统计 统计类型按照机构
 */
public class CdmManagerStatisticsDto {

    @Item(index=31,column ="机构名称",isOrganization=true)
    private String create_organ_code;

    @Item(index=33,column ="医务人员名称",isUser=true)
    private String create_doctor_code;

    @Item(index=33,column ="高血压新增管理人数")
    private Integer new_hbp_num;

    @Item(index=33,column ="糖尿病新增管理人数")
    private Integer new_di_num;

    @Item(index=33,column ="高血压累计管理人数")
    private Integer hbp_num;

    @Item(index=33,column ="糖尿病累计管理人数")
    private Integer di_num;

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
