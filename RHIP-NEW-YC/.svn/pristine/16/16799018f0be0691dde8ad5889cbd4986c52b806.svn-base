package com.founder.rhip.ehr.dto.womenChild;

import com.founder.rhip.ehr.service.export.Item;

import java.util.Date;

/**
 * Created by f on 2018/12/21.
 */
public class GravidaReportResultDto {

    @Item(index=1,column ="姓名")
    String xm;

    @Item(index=2,column ="分娩日期" ,isDate = true,datePattern = "yyyy/MM/dd")
    Date mcrq;

    @Item(index=3,column ="电话")
    String zflxdh;

//    @RecordTrace(isDic = true, dictCode = "HE00020")
    @Item(index=4,column ="早孕建册", isDic= true, dicType="HE00020")
    String zy;

    @Item(index=5,column ="16-20周随访", isDic= true, dicType="HE00020")
    String twentySf;

    @Item(index=6,column ="21-24周随访", isDic= true, dicType="HE00020")
    String twentyFourSf;

    @Item(index=7,column ="28-36周随访", isDic= true, dicType="HE00020")
    String thirtySixSf;

    @Item(index=8,column ="37-40周随访", isDic= true, dicType="HE00020")
    String fourtySf;

    @Item(index=9,column ="产后随访", isDic= true, dicType="HE00020")
    String chfs;

    @Item(index=10,column ="42天检查", isDic= true, dicType="HE00020")
    String jc;

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public Date getMcrq() {
        return mcrq;
    }

    public void setMcrq(Date mcrq) {
        this.mcrq = mcrq;
    }

    public String getZflxdh() {
        return zflxdh;
    }

    public void setZflxdh(String zflxdh) {
        this.zflxdh = zflxdh;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    public String getTwentySf() {
        return twentySf;
    }

    public void setTwentySf(String twentySf) {
        this.twentySf = twentySf;
    }

    public String getTwentyFourSf() {
        return twentyFourSf;
    }

    public void setTwentyFourSf(String twentyFourSf) {
        this.twentyFourSf = twentyFourSf;
    }

    public String getThirtySixSf() {
        return thirtySixSf;
    }

    public void setThirtySixSf(String thirtySixSf) {
        this.thirtySixSf = thirtySixSf;
    }

    public String getFourtySf() {
        return fourtySf;
    }

    public void setFourtySf(String fourtySf) {
        this.fourtySf = fourtySf;
    }

    public String getChfs() {
        return chfs;
    }

    public void setChfs(String chfs) {
        this.chfs = chfs;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }
}
