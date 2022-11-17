package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "BI_MODIFY_TRACE")
public class ModifyTrace implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|标识|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "REGION_TYPE", columnDefinition = "VARCHAR|所属类型||", length = 50, nullable = true)
    private String regionType;

    @Column(name = "REGION_NAME", columnDefinition = "VARCHAR|所属类型名称||", length = 100, nullable = true)
    private String regionName;

    @Column(name = "ITEM_CODE", columnDefinition = "VARCHAR|变更项代码||", length = 50, nullable = true)
    private String itemCode;

    @Column(name = "ITEM_NAME", columnDefinition = "VARCHAR|变更项名称||", length = 100, nullable = true)
    private String itemName;

    @Column(name = "OLD_VALUE", columnDefinition = "VARCHAR|历史值代码||", length = 2000, nullable = true)
    private String oldValue;

    @Column(name = "OLD_VALUE_NAME", columnDefinition = "VARCHAR|历史值||", length = 500, nullable = true)
    private String oldValueName;

    @Column(name = "NEW_VALUE", columnDefinition = "VARCHAR|更新值代码||", length = 2000, nullable = true)
    private String newValue;

    @Column(name = "NEW_VALUE_NAME", columnDefinition = "VARCHAR|更新值||", length = 500, nullable = true)
    private String newValueName;

    @Column(name = "INPUT_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
    private Date inputDate;

    @Column(name = "INPUT_USER_ID", columnDefinition = "VARCHAR|更新值||", length = 50, nullable = true)
    private String inputUserId;

    @Column(name = "PERSON_ID", columnDefinition = "NUMBER|更新值||", length = 11, nullable = true)
    private Long personId;

    @Column(name = "INPUT_ORG_CODE", columnDefinition = "VARCHAR2|修改机构编码||", length = 50, nullable = true)
    private String inputOrgCode;
    
    @Column(name = "INPUT_ORG", columnDefinition = "VARCHAR2|修改机构名称||", length = 70, nullable = true)
    private String inputOrg;

    @Column(name = "INPUT_NAME", columnDefinition = "VARCHAR2|修改人员||", length = 30, nullable = true)
    private String inputName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getOldValueName() {
        return oldValueName;
    }

    public void setOldValueName(String oldValueName) {
        this.oldValueName = oldValueName;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getNewValueName() {
        return newValueName;
    }

    public void setNewValueName(String newValueName) {
        this.newValueName = newValueName;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public String getInputUserId() {
        return inputUserId;
    }

    public void setInputUserId(String inputUserId) {
        this.inputUserId = inputUserId;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getInputOrg() {
        return inputOrg;
    }

    public void setInputOrg(String inputOrg) {
        this.inputOrg = inputOrg;
    }

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }

	public String getInputOrgCode() {
		return inputOrgCode;
	}

	public void setInputOrgCode(String inputOrgCode) {
		this.inputOrgCode = inputOrgCode;
	}
}