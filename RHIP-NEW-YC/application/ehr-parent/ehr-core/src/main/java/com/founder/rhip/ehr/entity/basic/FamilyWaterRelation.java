package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "BI_FAMILY_WATER_RELATION")
public class FamilyWaterRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "FAMILY_ID", columnDefinition = "NUMBER|家庭标识|11|", length = 11, nullable = false)
    private Long familyId;

    @Column(name = "WATER_CODE", columnDefinition = "VARCHAR2|家庭用水code||", length = 1, nullable = true)
    private String waterCode;

    @Column(name = "WATER_NAME", columnDefinition = "VARCHAR2|家庭用水名称||", length = 50, nullable = true)
    private String waterName;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getWaterCode() {
        return waterCode;
    }

    public void setWaterCode(String waterCode) {
        this.waterCode = waterCode;
    }

    public String getWaterName() {
        return waterName;
    }

    public void setWaterName(String waterName) {
        this.waterName = waterName;
    }
}
