package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "BI_ORG_OLDPEOPLEHOME_RELATION")
public class OrganizationOldPeopleHomeRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ORGANIZATION_ID", columnDefinition = "NUMBER|组织信息标识符|11|", length = 11, nullable = false)
    private Integer organizationId;

    @Column(name = "OLD_PEOPLE_HOME", columnDefinition = "VARCHAR2|养老院||", length = 1, nullable = true)
    private String OldPeopleHome;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态|", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOldPeopleHome() {
        return OldPeopleHome;
    }

    public void setOldPeopleHome(String oldPeopleHome) {
        OldPeopleHome = oldPeopleHome;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

}
