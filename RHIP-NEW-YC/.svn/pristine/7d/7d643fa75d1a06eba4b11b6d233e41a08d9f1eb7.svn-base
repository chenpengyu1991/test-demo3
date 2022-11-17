package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "BI_ORG_GARBAGE_RELATION")
public class OrganizationGarbageRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ORGANIZATION_ID", columnDefinition = "NUMBER|组织信息标识符|11|", length = 11, nullable = false)
    private Integer organizationId;

    @Column(name = "GARBAGE_DISPOSAL_CODE", columnDefinition = "VARCHAR2|垃圾处理类别代码||", length = 1, nullable = true)
    private String garbageDisposalCode;

    @Column(name = "GARBAGE_DISPOSAL_NAME", columnDefinition = "VARCHAR2|垃圾处理类别名称||", length = 50, nullable = true)
    private String garbageDisposalName;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态|", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getGarbageDisposalCode() {
        return garbageDisposalCode;
    }

    public void setGarbageDisposalCode(String garbageDisposalCode) {
        this.garbageDisposalCode = garbageDisposalCode;
    }

    public String getGarbageDisposalName() {
        return garbageDisposalName;
    }

    public void setGarbageDisposalName(String garbageDisposalName) {
        this.garbageDisposalName = garbageDisposalName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
