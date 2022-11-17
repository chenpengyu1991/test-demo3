package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "BI_ORGANIZATION_ITEM_RELATION")
public class OrganizationItemRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "ORG_CODE", columnDefinition = "VARCHAR|机构代码|50|", length = 50, nullable = true)
    private String orgCode;

    @Column(name = "ITEM_CODE", columnDefinition = "VARCHAR|行政区划代码|50|", length = 50, nullable = true)
    private String itemCode;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态|1|", length = 1, nullable = true)
    private String isDelete = "0";


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getOrgCode() {
        return orgCode;
    }


    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }


    public String getItemCode() {
        return itemCode;
    }


    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }


    public String getIsDelete() {
        return isDelete;
    }


    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }


}
