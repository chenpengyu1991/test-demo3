package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "BI_ORG_ENVIRONMENT_RELATION")
public class OrganizationEnvironmentRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ORGANIZATION_ID", columnDefinition = "NUMBER|组织信息标识符|11|", length = 11, nullable = false)
    private Integer organizationId;

    @Column(name = "ENVIRONMENT_CODE", columnDefinition = "VARCHAR2|环境类别代码||", length = 1, nullable = true)
    private String environmentCode;

    @Column(name = "ENVIRONMENT_NAME", columnDefinition = "VARCHAR2|环境类别名称||", length = 50, nullable = true)
    private String environmentName;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态|", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getEnvironmentCode() {
        return environmentCode;
    }

    public void setEnvironmentCode(String environmentCode) {
        this.environmentCode = environmentCode;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
