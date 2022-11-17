package com.founder.rhip.ehr.entity.clinic;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by f on 2016/12/12.
 */
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@Table(name = "MS_PAITENTBED_STATUS")
public class PaitentbedStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    @XmlTransient
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号(自增长)|11|", length = 11, nullable = false)
    private Long id;

    @XmlElement
    @NotEmpty(message="医院编码为空")
    @Column(name = "HOSPITAL_CODE", columnDefinition = "VARCHAR2|医院编码|50|", length = 50, nullable = true)
    private String hospitalCode;

    @XmlElement
    @NotEmpty(message="科室编码为空")
    @Column(name = "DEP_CODE", columnDefinition = "VARCHAR2|科室编码|20|", length = 20, nullable = true)
    private String depCode;

    @XmlElement
    @NotEmpty(message="科室名称为空")
    @Column(name = "DEP_NAME", columnDefinition = "VARCHAR2|科室名称|50|", length = 50, nullable = true)
    private String depName;

    @XmlElement
    @NotEmpty(message="总床位为空")
    @Column(name = "SUM_BED", columnDefinition = "VARCHAR2|总床位|4|", length = 4, nullable = true)
    private String sumBed;

    @XmlElement
    @NotEmpty(message="剩余床位为空")
    @Column(name = "RESIDUE_BED", columnDefinition = "VARCHAR2|剩余床位|4|", length = 4, nullable = true)
    private String residueBed;

    @XmlElement
    @NotEmpty(message="联系电话为空")
    @Column(name = "TEL_NO", columnDefinition = "VARCHAR2|联系电话|20|", length = 20, nullable = true)
    private String telNo;

    @Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||",  nullable = true)
    private Date createTime;

    @Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||",  nullable = true)
    private Date updateTime;

    @Transient
    private String hospitalName;

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Long getId() {
        return id;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public String getDepCode() {
        return depCode;
    }

    public String getDepName() {
        return depName;
    }

    public String getSumBed() {
        return sumBed;
    }

    public String getResidueBed() {
        return residueBed;
    }

    public String getTelNo() {
        return telNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public void setSumBed(String sumBed) {
        this.sumBed = sumBed;
    }

    public void setResidueBed(String residueBed) {
        this.residueBed = residueBed;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
