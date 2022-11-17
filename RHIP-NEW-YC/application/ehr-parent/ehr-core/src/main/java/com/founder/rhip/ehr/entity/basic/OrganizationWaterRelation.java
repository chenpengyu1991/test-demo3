package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "BI_ORG_WATER_RELATION")
public class OrganizationWaterRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ORGANIZATION_ID", columnDefinition = "NUMBER|组织信息标识符|11|", length = 11, nullable = false)
    private Integer organizationId;

    @Column(name = "WATER_CODE", columnDefinition = "VARCHAR2|饮水类别代码||", length = 1, nullable = true)
    private String waterCode;

    @Column(name = "WATER_NAME", columnDefinition = "VARCHAR2|饮水类别名称||", length = 50, nullable = true)
    private String waterName;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态|", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
