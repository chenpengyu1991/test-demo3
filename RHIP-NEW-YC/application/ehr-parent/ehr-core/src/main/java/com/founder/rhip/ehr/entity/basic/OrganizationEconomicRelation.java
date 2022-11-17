package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name = "BI_ORG_ECONOMIC_RELATION")
public class OrganizationEconomicRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ORGANIZATION_ID", columnDefinition = "NUMBER|组织信息标识符|11|", length = 11, nullable = false)
    private Integer organizationId;

    @Column(name = "ECONOMIC", columnDefinition = "VARCHAR2|经济值||", nullable = true)
    private BigDecimal economic;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态|", length = 1, nullable = true)
    private Integer isDelete;

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public BigDecimal getEconomic() {
        return economic;
    }

    public void setEconomic(BigDecimal economic) {
        this.economic = economic;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

}
