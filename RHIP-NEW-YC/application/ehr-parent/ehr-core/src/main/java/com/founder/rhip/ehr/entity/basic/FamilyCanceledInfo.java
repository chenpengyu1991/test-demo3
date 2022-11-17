package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "BI_FAMILY_CANCELED_INFO")
public class FamilyCanceledInfo implements Serializable {

    private static final long serialVersionUID = -7313564364933619294L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|主键|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "FAMILY_ID", columnDefinition = "NUMBER|家庭号||", length = 50, nullable = true)
    private Long familyId;

    @Column(name = "CANCELED_REASON", columnDefinition = "VARCHAR2|注销原因||", length = 20, nullable = true)
    private String canceledReason;

    @Column(name = "REMARK", columnDefinition = "VARCHAR2|注销说明||", length = 500, nullable = true)
    private String remark;

    @Column(name = "CANCELED_IDCARD", columnDefinition = "VARCHAR2|注销人员身份证件号码||", length = 18, nullable = true)
    private String canceledIdcard;

    @Column(name = "CANCELED_NAME", columnDefinition = "VARCHAR2|注销人员姓名||", length = 50, nullable = true)
    private String canceledName;

    @Column(name = "CANCELED_ORGAN_CODE", columnDefinition = "VARCHAR2|注销机构代码||", length = 15, nullable = true)
    private String canceledOrganCode;

    @Column(name = "CANCELED_ORGAN_NAME", columnDefinition = "VARCHAR2|注销机构名称||", length = 15, nullable = true)
    private String canceledOrganName;

    @Column(name = "CANCELED_DATE", columnDefinition = "DATE|注销时间||", length = 15, nullable = true)
    private Date canceledDate;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    @Column(name = "REJECTED_REASON", columnDefinition = "VARCHAR2|拒绝原因||", length = 500, nullable = true)
    private String rejectedReason;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFamilyId() {
        return familyId;
    }


    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getCanceledReason() {
        return canceledReason;
    }

    public void setCanceledReason(String canceledReason) {
        this.canceledReason = canceledReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCanceledIdcard() {
        return canceledIdcard;
    }

    public void setCanceledIdcard(String canceledIdcard) {
        this.canceledIdcard = canceledIdcard;
    }

    public String getCanceledName() {
        return canceledName;
    }

    public void setCanceledName(String canceledName) {
        this.canceledName = canceledName;
    }

    public String getCanceledOrganCode() {
        return canceledOrganCode;
    }

    public void setCanceledOrganCode(String canceledOrganCode) {
        this.canceledOrganCode = canceledOrganCode;
    }

    public String getCanceledOrganName() {
        return canceledOrganName;
    }

    public void setCanceledOrganName(String canceledOrganName) {
        this.canceledOrganName = canceledOrganName;
    }

    public Date getCanceledDate() {
        return canceledDate;
    }

    public void setCanceledDate(Date canceledDate) {
        this.canceledDate = canceledDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }


    public String getRejectedReason() {
        return rejectedReason;
    }


    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FamilyCanceledInfo other = (FamilyCanceledInfo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
