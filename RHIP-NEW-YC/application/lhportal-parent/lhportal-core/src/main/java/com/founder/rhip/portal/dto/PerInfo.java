package com.founder.rhip.portal.dto;

import com.founder.rhip.ehr.common.JaxbDateSerializer2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
public class PerInfo implements Serializable {

	private static final long serialVersionUID = 577024078443982329L;

    @XmlJavaTypeAdapter(JaxbDateSerializer2.class)
	private Date WorkDate;

	private String WorkType;
	
	private String DeptCode;

	private String DocCode;

    private String DeptName;

    private String DocName;

	private String STime;

	private String ETime;

	private String SpaceTime;

	private String PreLimit;

	private String Status;

	private String RegistCode;

	private String RegistName;

    private String PreNum;

    private String Remark;

    private String CliniqueCode;

    public String getDeptName() {
        return DeptName;
    }

    public void setDeptName(String deptName) {
        DeptName = deptName;
    }

    public String getDocName() {
        return DocName;
    }

    public void setDocName(String docName) {
        DocName = docName;
    }

    public Date getWorkDate() {
        return WorkDate;
    }

    public void setWorkDate(Date workDate) {
        WorkDate = workDate;
    }

    public String getWorkType() {
        return WorkType;
    }

    public void setWorkType(String workType) {
        WorkType = workType;
    }

    public String getDeptCode() {
        return DeptCode;
    }

    public void setDeptCode(String deptCode) {
        DeptCode = deptCode;
    }

    public String getDocCode() {
        return DocCode;
    }

    public void setDocCode(String docCode) {
        DocCode = docCode;
    }

    public String getSTime() {
        return STime;
    }

    public void setSTime(String STime) {
        this.STime = STime;
    }

    public String getETime() {
        return ETime;
    }

    public void setETime(String ETime) {
        this.ETime = ETime;
    }

    public String getSpaceTime() {
        return SpaceTime;
    }

    public void setSpaceTime(String spaceTime) {
        SpaceTime = spaceTime;
    }

    public String getPreLimit() {
        return PreLimit;
    }

    public void setPreLimit(String preLimit) {
        PreLimit = preLimit;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getRegistCode() {
        return RegistCode;
    }

    public void setRegistCode(String registCode) {
        RegistCode = registCode;
    }

    public String getRegistName() {
        return RegistName;
    }

    public void setRegistName(String registName) {
        RegistName = registName;
    }

    public String getPreNum() {
        return PreNum;
    }

    public void setPreNum(String preNum) {
        PreNum = preNum;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getCliniqueCode() {
        return CliniqueCode;
    }

    public void setCliniqueCode(String cliniqueCode) {
        CliniqueCode = cliniqueCode;
    }
}
