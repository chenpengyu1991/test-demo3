package com.founder.rhip.ehr.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: zheng_dandan
 * Date: 13-6-14
 * Time: 下午2:48
 * To change this template use File | Settings | File Templates.
 */
public class StopDoctorDTO implements Serializable {

    private Long id;

    private  String  doctorName;

    private  String  doctorSN;

    private  String  deptName;

    private  String  deptSN;

    private  String  hospName;

    private  String  hospitalCode;

    private Date  startDate;

    private Date  endDate;

    private String period;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorSN() {
        return doctorSN;
    }

    public void setDoctorSN(String doctorSN) {
        this.doctorSN = doctorSN;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptSN() {
        return deptSN;
    }

    public void setDeptSN(String deptSN) {
        this.deptSN = deptSN;
    }

    public String getHospName() {
        return hospName;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
