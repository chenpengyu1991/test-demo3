package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "BI_FAMILY_HASTOILET_RELATION")
public class FamilyHostoiletRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "FAMILY_ID", columnDefinition = "NUMBER|家庭标识|11|", length = 11, nullable = false)
    private Long familyId;

    @Column(name = "HASTOILET_CODE", columnDefinition = "VARCHAR2|户厕用水code||", length = 1, nullable = true)
    private String hastoiletCode;

    @Column(name = "HASTOILET_NAME", columnDefinition = "VARCHAR2|户厕名称||", length = 50, nullable = true)
    private String hastoiletName;

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

    public String getHastoiletCode() {
        return hastoiletCode;
    }

    public void setHastoiletCode(String hastoiletCode) {
        this.hastoiletCode = hastoiletCode;
    }

    public String getHastoiletName() {
        return hastoiletName;
    }

    public void setHastoiletName(String hastoiletName) {
        this.hastoiletName = hastoiletName;
    }
}
